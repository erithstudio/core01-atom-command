/**
 * Copyright 2017, Denis Prasetio, Erith Studio
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License
 * at http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.erith.core.atomcommand.components;

import org.erith.core.atomcommand.commands.Command;

import java.util.*;

/**
 * <summary>
 *     A container for a sequence of Fungus comands.
 * </summary>
 */
public class Block extends Node {
    /// <summary>
    /// Unique identifier for the Block.
    /// </summary>
    protected int itemId = -1;

    /// <summary>
    /// The name of the block node as displayed in the Flowchart window.
    /// </summary>
    protected String blockName = "New Block";

    /// <summary>
    /// Description text to display under the block node
    /// </summary>
    protected String description = "";

    /// <summary>
    /// An optional Event Handler which can execute the block when an event occurs.
    /// Note: Using the concrete class instead of the interface here because of weird editor behaviour.
    /// </summary>
    protected EventHandler eventHandler;

    /// <summary>
    /// The list of commands in the sequence.
    /// </summary>
    protected List<Command> commandList = new ArrayList<Command>();

    /// <summary>
    /// The execution state of the Block.
    /// </summary>
    protected ExecutionState executionState;

    /// <summary>
    /// The currently executing command.
    /// </summary>
    protected Command activeCommand;

    /// <summary>
    /// Timer for fading Block execution icon.
    /// </summary>
    protected float ExecutingIconTimer;

    /// <summary>
    /// Controls the next command to execute in the block execution coroutine.
    /// </summary>
    protected int JumpToCommandIndex;

    /**
     * <summary>
     *     Index of last command executed before the current one.
     *     -1 indicates no previous command.
     * </summary>
     */
    protected int previousActiveCommandIndex = -1;

    protected int jumpToCommandIndex = -1;

    protected int executionCount;

    protected boolean executionInfoSet = false;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public ExecutionState getExecutionState() {
        return this.executionState;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public List<Command> getCommandList() {
        return commandList;
    }

    public void setCommandList(List<Command> commandList) {
        this.commandList = commandList;
    }

    protected void Awake()
    {
        setExecutionInfo();
    }

    public float getExecutingIconTimer() {
        return ExecutingIconTimer;
    }

    public void setExecutingIconTimer(float executingIconTimer) {
        ExecutingIconTimer = executingIconTimer;
    }

    public int getJumpToCommandIndex() {
        return JumpToCommandIndex;
    }

    public void setJumpToCommandIndex(int jumpToCommandIndex) {
        JumpToCommandIndex = jumpToCommandIndex;
    }

    protected void setExecutionInfo()
    {
        // Give each child command a reference back to its parent block
        // and tell each command its index in the list.
        int index = 0;
        for (int i = 0; i < commandList.size(); i++)
        {
            Command command = commandList.get(i);
            if (command == null)
            {
                continue;
            }
            command.setParentBlock(this);
            command.setCommandIndex(index++);
        }

        // Ensure all commands are at their correct indent level
        // This should have already happened in the editor, but may be necessary
        // if commands are added to the Block at runtime.
        UpdateIndentLevels();

        executionInfoSet = true;
    }

    // The user can modify the command list order while playing in the editor,
    // so we keep the command indices updated every frame. There's no need to
    // do this in player builds so we compile this bit out for those builds.
    protected void Update()
    {
        int index = 0;
        for (int i = 0; i < commandList.size(); i++)
        {
            Command command = commandList.get(i);
            if (command == null)// Null entry will be deleted automatically later

            {
                continue;
            }
            command.CommandIndex = index++;
        }
    }

    /// <summary>
    /// Returns the parent Flowchart for this Block.
    /// </summary>
    public Flowchart GetFlowchart()
    {
        return GetComponent<Flowchart>();
    }

    /// <summary>
    /// Returns true if the Block is executing a command.
    /// </summary>
    public boolean IsExecuting()
    {
        return (executionState == ExecutionState.Executing);
    }

    /// <summary>
    /// Returns the number of times this Block has executed.
    /// </summary>
    public int GetExecutionCount()
    {
        return executionCount;
    }

    /// <summary>
    /// Start a coroutine which executes all commands in the Block. Only one running instance of each Block is permitted.
    /// </summary>
    public void StartExecution()
    {
        StartCoroutine(Execute());
    }

    /// <summary>
    /// A coroutine method that executes all commands in the Block. Only one running instance of each Block is permitted.
    /// </summary>
    /// <param name="commandIndex">Index of command to start execution at</param>
    /// <param name="onComplete">Delegate function to call when execution completes</param>
    public Enumeration Execute(int commandIndex = 0, Action onComplete = null)
    {
        if (executionState != ExecutionState.Idle)
        {
            yield break;
        }

        if (!executionInfoSet)
        {
            SetExecutionInfo();
        }

        executionCount++;

        var flowchart = GetFlowchart();
        executionState = ExecutionState.Executing;
        BlockSignals.DoBlockStart(this);

            #if UNITY_EDITOR
        // Select the executing block & the first command
        flowchart.SelectedBlock = this;
        if (commandList.Count > 0)
        {
            flowchart.ClearSelectedCommands();
            flowchart.AddSelectedCommand(commandList[0]);
        }
            #endif

            jumpToCommandIndex = commandIndex;

        int i = 0;
        while (true)
        {
            // Executing commands specify the next command to skip to by setting jumpToCommandIndex using Command.Continue()
            if (jumpToCommandIndex > -1)
            {
                i = jumpToCommandIndex;
                jumpToCommandIndex = -1;
            }

            // Skip disabled commands, comments and labels
            while (i < commandList.Count &&
                    (!commandList[i].enabled ||
                            commandList[i].GetType() == typeof(Comment) ||
                            commandList[i].GetType() == typeof(Label)))
            {
                i = commandList[i].CommandIndex + 1;
            }

            if (i >= commandList.Count)
            {
                break;
            }

            // The previous active command is needed for if / else / else if commands
            if (activeCommand == null)
            {
                previousActiveCommandIndex = -1;
            }
            else
            {
                previousActiveCommandIndex = activeCommand.CommandIndex;
            }

            var command = commandList[i];
            activeCommand = command;

            if (flowchart.IsActive())
            {
                // Auto select a command in some situations
                if ((flowchart.SelectedCommands.Count == 0 && i == 0) ||
                        (flowchart.SelectedCommands.Count == 1 && flowchart.SelectedCommands[0].CommandIndex == previousActiveCommandIndex))
                {
                    flowchart.ClearSelectedCommands();
                    flowchart.AddSelectedCommand(commandList[i]);
                }
            }

            command.IsExecuting = true;
            // This icon timer is managed by the FlowchartWindow class, but we also need to
            // set it here in case a command starts and finishes execution before the next window update.
            command.ExecutingIconTimer = Time.realtimeSinceStartup + FungusConstants.ExecutingIconFadeTime;
            BlockSignals.DoCommandExecute(this, command, i, commandList.Count);
            command.Execute();

            // Wait until the executing command sets another command to jump to via Command.Continue()
            while (jumpToCommandIndex == -1)
            {
                yield return null;
            }

                #if UNITY_EDITOR
            if (flowchart.StepPause > 0f)
            {
                yield return new WaitForSeconds(flowchart.StepPause);
            }
                #endif

            command.IsExecuting = false;
        }

        executionState = ExecutionState.Idle;
        activeCommand = null;
        BlockSignals.DoBlockEnd(this);

        if (onComplete != null)
        {
            onComplete();
        }
    }

    /// <summary>
    /// Stop executing commands in this Block.
    /// </summary>
    public void Stop()
    {
        // Tell the executing command to stop immediately
        if (activeCommand != null)
        {
            activeCommand.IsExecuting = false;
            activeCommand.OnStopExecuting();
        }

        // This will cause the execution loop to break on the next iteration
        jumpToCommandIndex = int.MaxValue;
    }

    /// <summary>
    /// Returns a list of all Blocks connected to this one.
    /// </summary>
    public List<Block> GetConnectedBlocks()
    {
        List<Block> connectedBlocks = new ArrayList<Block>();
        for (int i = 0; i < commandList.size(); i++)
        {
            Command command = commandList.get(i)
            if (command != null)
            {
                command.GetConnectedBlocks(connectedBlocks);
            }
        }
        return connectedBlocks;
    }

    /// <summary>
    /// Returns the type of the previously executing command.
    /// </summary>
    /// <returns>The previous active command type.</returns>
    public Class GetPreviousActiveCommandType()
    {
        if (previousActiveCommandIndex >= 0 &&
                previousActiveCommandIndex < commandList.size())
        {
            return commandList.get(previousActiveCommandIndex).getClass();
        }

        return null;
    }

    /// <summary>
    /// Recalculate the indent levels for all commands in the list.
    /// </summary>
    public void UpdateIndentLevels()
    {
        int indentLevel = 0;
        for (int i = 0; i < commandList.size(); i++)
        {
            Command command = commandList.get(i);
            if (command == null)
            {
                continue;
            }
            if (command.CloseBlock())
            {
                indentLevel--;
            }
            // Negative indent level is not permitted
            indentLevel = Math.max(indentLevel, 0);
            command.IndentLevel = indentLevel;
            if (command.OpenBlock())
            {
                indentLevel++;
            }
        }
    }

    /// <summary>
    /// Returns the index of the Label command with matching key, or -1 if not found.
    /// </summary>
    public int GetLabelIndex(String labelKey)
    {
        if (labelKey.length() == 0)
        {
            return -1;
        }

        for (int i = 0; i < commandList.size(); i++)
        {
            Command command = commandList.get(i);
            var labelCommand = command as Label;
            if (labelCommand != null && String.Compare(labelCommand.Key, labelKey, true) == 0)
            {
                return i;
            }
        }

        return -1;
    }
}
