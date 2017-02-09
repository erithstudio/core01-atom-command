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

package org.erith.core.atomcommand.commands;

import org.erith.core.atomcommand.components.Block;
import org.erith.core.atomcommand.components.Flowchart;
import org.erith.core.atomcommand.components.variables.Variable;

import java.io.Serializable;
import java.util.List;

public abstract class Command implements Serializable {
    protected int itemId = -1;
    protected int indentLevel;
    protected String errorMessage = "";
    protected int commandIndex = -1;
    protected boolean isExecuting;
    protected float executingIconTimer;
    protected Block parentBlock;

    public Flowchart GetFlowchart() {
        /*var flowchart = GetComponent<Flowchart>();
        if (flowchart == null &&
                transform.parent != null)
        {
            flowchart = transform.parent.GetComponent<Flowchart>();
        }
        return flowchart;*/

        return null;
    }

    /// <summary>
    /// Execute the command.
    /// </summary>
    public void Execute() {
        OnEnter();
    }

    /// <summary>
    /// End execution of this command and continue execution at the next command.
    /// </summary>
    public void Continue() {
        // This is a noop if the Block has already been stopped
        if (isExecuting) {
            Continue(commandIndex + 1);
        }
    }

    /// <summary>
    /// End execution of this command and continue execution at a specific command index.
    /// </summary>
    /// <param name="nextCommandIndex">Next command index.</param>
    public void Continue(int nextCommandIndex) {
        OnExit();
        if (parentBlock != null) {
            parentBlock.setJumpToCommandIndex(nextCommandIndex);
        }
    }

    /// <summary>
    /// Stops the parent Block executing.
    /// </summary>
    public void StopParentBlock() {
        OnExit();
        if (parentBlock != null) {
            parentBlock.Stop();
        }
    }

    /// <summary>
    /// Called when the parent block has been requested to stop executing, and
    /// this command is the currently executing command.
    /// Use this callback to terminate any asynchronous operations and
    /// cleanup state so that the command is ready to execute again later on.
    /// </summary>
    public abstract void OnStopExecuting();

    /// <summary>
    /// Called when the new command is added to a block in the editor.
    /// </summary>
    public abstract void OnCommandAdded(Block parentBlock);

    /// <summary>
    /// Called when the command is deleted from a block in the editor.
    /// </summary>
    public abstract void OnCommandRemoved(Block parentBlock);

    /// <summary>
    /// Called when this command starts execution.
    /// </summary>
    public abstract void OnEnter();

    /// <summary>
    /// Called when this command ends execution.
    /// </summary>
    public abstract void OnExit();

    /// <summary>
    /// Called when this command is reset. This happens when the Reset command is used.
    /// </summary>
    public abstract void OnReset();

    /// <summary>
    /// Populates a list with the Blocks that this command references.
    /// </summary>
    public abstract void GetConnectedBlocks(List<Block> connectedBlocks);

    /// <summary>
    /// Returns true if this command references the variable.
    /// Used to highlight variables in the variable list when a command is selected.
    /// </summary>
    public abstract boolean HasReference(Variable variable);

    /// <summary>
    /// Returns the summary text to display in the command inspector.
    /// </summary>
    public abstract String GetSummary();

    /// <summary>
    /// Returns the help text to display for this command.
    /// </summary>
    public abstract String GetHelpText();

    /// <summary>
    /// Return true if this command opens a block of commands. Used for indenting commands.
    /// </summary>
    public abstract boolean OpenBlock();

    /// <summary>
    /// Return true if this command closes a block of commands. Used for indenting commands.
    /// </summary>
    public abstract boolean CloseBlock();

    /// <summary>
    /// Return the color for the command background in inspector.
    /// </summary>
    /// <returns>The button color.</returns>
    public abstract Object GetButtonColor();
//    public virtual Color GetButtonColor()
//    {
//        return Color.white;
//    }

    /// <summary>
    /// Returns true if the specified property should be displayed in the inspector.
    /// This is useful for hiding certain properties based on the value of another property.
    /// </summary>
    public abstract boolean IsPropertyVisible(String propertyName);

    /// <summary>
    /// Returns true if the specified property should be displayed as a reorderable list in the inspector.
    /// This only applies for array properties and has no effect for non-array properties.
    /// </summary>
    public abstract boolean IsReorderableArray(String propertyName);

    /// <summary>
    /// Returns the localization id for the Flowchart that contains this command.
    /// </summary>
    public String GetFlowchartLocalizationId() {
        // If no localization id has been set then use the Flowchart name
        Flowchart flowchart = GetFlowchart();
        if (flowchart == null) {
            return "";
        }

        /*String localizationId = GetFlowchart().LocalizationId;
        if (localizationId.length() == 0)
        {
            localizationId = flowchart.GetName();
        }
        return localizationId;
        */

        return "en_US";
    }

    public Block getParentBlock() {
        return parentBlock;
    }

    public void setParentBlock(Block parentBlock) {
        this.parentBlock = parentBlock;
    }

    public int getCommandIndex() {
        return commandIndex;
    }

    public void setCommandIndex(int commandIndex) {
        this.commandIndex = commandIndex;
    }
}
