package org.erith.core.atomcommand.components;

import org.erith.core.atomcommand.annotations.Tooltip;
import org.erith.core.atomcommand.commands.Command;
import org.erith.core.atomcommand.components.variables.Variable;
import org.erith.core.atomcommand.interfaces.ISubstitutionHandler;
import org.erith.core.atomcommand.thirdparty.LuaEnvironment;
import org.erith.core.atomcommand.utils.AtomCommandConstants;
import org.erith.core.atomcommand.utils.StringSubstituter;

import java.util.ArrayList;
import java.util.List;

public class Flowchart implements ISubstitutionHandler
{
    protected int version = 0; // Default to 0 to always trigger an update for older versions of Fungus.

    /// <summary>
    /// Scroll position of Flowchart editor window.
    /// </summary>
    protected Object scrollPos;

    /// <summary>
    /// Scroll position of Flowchart variables window.
    /// </summary>
    protected Object variablesScrollPos;

    /// <summary>
    /// Show the variables pane.
    /// </summary>
    protected boolean variablesExpanded = true;

    /// <summary>
    /// Height of command block view in inspector.
    /// </summary>
    protected float blockViewHeight = 400;

    /// <summary>
    /// Zoom level of Flowchart editor window.
    /// </summary>
    protected float zoom = 1f;

    /// <summary>
    /// Scrollable area for Flowchart editor window.
    /// </summary>
    protected Object scrollViewRect;

    /// <summary>
    /// Current actively selected block in the Flowchart editor.
    /// </summary>
    protected List<Block> selectedBlocks = new ArrayList<Block>();

    /// <summary>
    /// Currently selected command in the Flowchart editor.
    /// </summary>
    protected List<Command> selectedCommands = new ArrayList<Command>();

    /// <summary>
    /// The list of variables that can be accessed by the Flowchart.
    /// </summary>
    protected List<Variable> variables = new ArrayList<Variable>();

    /// <summary>
    /// Description text displayed in the Flowchart editor window
    /// </summary>
    @Tooltip(message = "Description text displayed in the Flowchart editor window")
    protected String description = "";

    /// <summary>
    /// Slow down execution in the editor to make it easier to visualise program flow.
    /// </summary>
    @Tooltip(message = "Adds a pause after each execution step to make it easier to visualise program flow. Editor only, has no effect in platform builds.")
    protected float stepPause = 0f;

    /// <summary>
    /// Use command color when displaying the command list in the inspector.
    /// </summary>
    @Tooltip(message = "Use command color when displaying the command list in the Fungus Editor window")
    protected boolean colorCommands = true;

    @Tooltip(message = "Hides the Flowchart block and command components in the inspector. Deselect to inspect the block and command components that make up the Flowchart.")
    protected boolean hideComponents = true;

    /// <summary>
    /// Saves the selected block and commands when saving the scene. Helps avoid version control conflicts if you've only changed the active selection.
    /// </summary>
    @Tooltip(message = "Saves the selected block and commands when saving the scene. Helps avoid version control conflicts if you've only changed the active selection.")
    protected boolean saveSelection = true;

    /// <summary>
    /// Unique identifier for identifying this flowchart in localized string keys.
    /// </summary>
    @Tooltip(message = "Unique identifier for this flowchart in localized string keys. If no id is specified then the name of the Flowchart object will be used.")
    protected String localizationId = "";

    /// <summary>
    /// Display line numbers in the command list in the Block inspector.
    /// </summary>
    @Tooltip(message = "Display line numbers in the command list in the Block inspector.")
    protected boolean showLineNumbers = false;

    @Tooltip(message = "List of commands to hide in the Add Command menu. Use this to restrict the set of commands available when editing a Flowchart.")
    protected List<String> hideCommands = new ArrayList<String>();

    /// <summary>
    /// Lua Environment to be used by default for all Execute Lua commands in this Flowchart.
    /// </summary>
    @Tooltip(message = "Lua Environment to be used by default for all Execute Lua commands in this Flowchart")
    protected LuaEnvironment luaEnvironment;

    /// <summary>
/// The ExecuteLua command adds a global Lua variable with this name bound to the flowchart prior to executing.
/// </summary>
    @Tooltip(message = "The ExecuteLua command adds a global Lua variable with this name bound to the flowchart prior to executing.")
    protected String luaBindingName = "flowchart";

    /// <summary>
    /// Cached list of flowchart objects in the scene for fast lookup.
    /// </summary>
    public static List<Flowchart> cachedFlowcharts;

    protected static boolean eventSystemPresent;

    protected StringSubstituter stringSubstituer;

    static {
        cachedFlowcharts = new ArrayList<Flowchart>();
    }

    protected void Awake()
    {
        CheckEventSystem();
        LevelWasLoaded();
    }

    protected void LevelWasLoaded()
    {
        // Reset the flag for checking for an event system as there may not be one in the newly loaded scene.
//            eventSystemPresent = false;
    }

    protected void Start()
    {
        CheckEventSystem();
    }

    // There must be an Event System in the scene for Say and Menu input to work.
    // This method will automatically instantiate one if none exists.
    protected void CheckEventSystem()
    {
//            if (eventSystemPresent)
//            {
//                return;
//            }
//
//            EventSystem eventSystem = GameObject.FindObjectOfType<EventSystem>();
//            if (eventSystem == null)
//            {
//                // Auto spawn an Event System from the prefab
//                GameObject prefab = Resources.Load<GameObject>("Prefabs/EventSystem");
//                if (prefab != null)
//                {
//                    GameObject go = Instantiate(prefab) as GameObject;
//                    go.name = "EventSystem";
//                }
//            }
//
//            eventSystemPresent = true;
    }

    protected void OnEnable()
    {
//            if (!cachedFlowcharts.Contains(this))
//            {
//                cachedFlowcharts.Add(this);
//            }
//
//            CheckItemIds();
//            CleanupComponents();
//            UpdateVersion();
    }

    protected void UpdateVersion()
    {
//            if (version == FungusConstants.CurrentVersion)
//            {
//                // No need to update
//                return;
//            }
//
//            // Tell all components that implement IUpdateable to update to the new version
//            var components = GetComponents<Component>();
//            for (int i = 0; i < components.Length; i++)
//            {
//                var component = components[i];
//                IUpdateable u = component as IUpdateable;
//                if (u != null)
//                {
//                    u.UpdateToVersion(version, FungusConstants.CurrentVersion);
//                }
//            }
//
//            version = FungusConstants.CurrentVersion;
    }

    protected void OnDisable()
    {
//            cachedFlowcharts.Remove(this);
    }

    protected void CheckItemIds()
    {
//            // Make sure item ids are unique and monotonically increasing.
//            // This should always be the case, but some legacy Flowcharts may have issues.
//            List<int> usedIds = new List<int>();
//            var blocks = GetComponents<Block>();
//            for (int i = 0; i < blocks.Length; i++)
//            {
//                var block = blocks[i];
//                if (block.ItemId == -1 || usedIds.Contains(block.ItemId))
//                {
//                    block.ItemId = NextItemId();
//                }
//                usedIds.Add(block.ItemId);
//            }
//
//            var commands = GetComponents<Command>();
//            for (int i = 0; i < commands.Length; i++)
//            {
//                var command = commands[i];
//                if (command.ItemId == -1 || usedIds.Contains(command.ItemId))
//                {
//                    command.ItemId = NextItemId();
//                }
//                usedIds.Add(command.ItemId);
//            }
    }

    protected void CleanupComponents()
    {
//            // Delete any unreferenced components which shouldn't exist any more
//            // Unreferenced components don't have any effect on the flowchart behavior, but
//            // they waste memory so should be cleared out periodically.
//
//            // Remove any null entries in the variables list
//            // It shouldn't happen but it seemed to occur for a user on the forum
//            variables.RemoveAll(item => item == null);
//
//            var allVariables = GetComponents<Variable>();
//            for (int i = 0; i < allVariables.Length; i++)
//            {
//                var variable = allVariables[i];
//                if (!variables.Contains(variable))
//                {
//                    DestroyImmediate(variable);
//                }
//            }
//
//            var blocks = GetComponents<Block>();
//            var commands = GetComponents<Command>();
//            for (int i = 0; i < commands.Length; i++)
//            {
//                var command = commands[i];
//                bool found = false;
//                for (int j = 0; j < blocks.Length; j++)
//                {
//                    var block = blocks[j];
//                    if (block.CommandList.Contains(command))
//                    {
//                        found = true;
//                        break;
//                    }
//                }
//                if (!found)
//                {
//                    DestroyImmediate(command);
//                }
//            }
//
//            var eventHandlers = GetComponents<EventHandler>();
//            for (int i = 0; i < eventHandlers.Length; i++)
//            {
//                var eventHandler = eventHandlers[i];
//                bool found = false;
//                for (int j = 0; j < blocks.Length; j++)
//                {
//                    var block = blocks[j];
//                    if (block._EventHandler == eventHandler)
//                    {
//                        found = true;
//                        break;
//                    }
//                }
//                if (!found)
//                {
//                    DestroyImmediate(eventHandler);
//                }
//            }
    }

    protected Block CreateBlockComponent(GameObject parent)
    {
//            Block block = parent.AddComponent<Block>();
//            return block;

        return null;
    }

    /// <summary>
    /// Sends a message to all Flowchart objects in the current scene.
    /// Any block with a matching MessageReceived event handler will start executing.
    /// </summary>
    public static void BroadcastFungusMessage(String messageName)
    {
        /*var eventHandlers = UnityEngine.Object.FindObjectsOfType<MessageReceived>();
        for (int i = 0; i < eventHandlers.Length; i++)
        {
            var eventHandler = eventHandlers[i];
            eventHandler.OnSendFungusMessage(messageName);
        }*/
    }

    /// <summary>
    /// Position in the center of all blocks in the flowchart.
    /// </summary>
    public virtual Vector2 CenterPosition { set; get; }

    /// <summary>
    /// Variable to track flowchart's version so components can update to new versions.
    /// </summary>
    public int version { set { version = value; } }

    /// <summary>
    /// Returns true if the Flowchart gameobject is active.
    /// </summary>
    public boolean isActive()
    {
        // return gameObject.activeInHierarchy;
        return true;
    }

    /// <summary>
    /// Returns the Flowchart gameobject name.
    /// </summary>
    public String getName()
    {
//        return gameObject.name;
        return "";
    }

    /// <summary>
    /// Returns the next id to assign to a new flowchart item.
    /// Item ids increase monotically so they are guaranteed to
    /// be unique within a Flowchart.
    /// </summary>
    public int nextItemId()
    {
        int maxId = -1;
        /*var blocks = GetComponents<Block>();
        for (int i = 0; i < blocks.Length; i++)
        {
            var block = blocks[i];
            maxId = Math.Max(maxId, block.ItemId);
        }

        var commands = GetComponents<Command>();
        for (int i = 0; i < commands.Length; i++)
        {
            var command = commands[i];
            maxId = Math.Max(maxId, command.ItemId);
        }*/
        return maxId + 1;
    }

    /// <summary>
    /// Create a new block node which you can then add commands to.
    /// </summary>
    // public Block CreateBlock(Vector2 position)
    public Block createBlock(Object position)
    {
//        Block b = CreateBlockComponent(gameObject);
//        b._NodeRect = new Rect(position.x, position.y, 0, 0);
//        b.BlockName = GetUniqueBlockKey(b.BlockName, b);
//        b.ItemId = NextItemId();
//
//        return b;
        return null;
    }

    /// <summary>
    /// Returns the named Block in the flowchart, or null if not found.
    /// </summary>
    public Block findBlock(String blockName)
    {
//        var blocks = GetComponents<Block>();
//        for (int i = 0; i < blocks.Length; i++)
//        {
//            var block = blocks[i];
//            if (block.BlockName == blockName)
//            {
//                return block;
//            }
//        }

        return null;
    }

    /// <summary>
    /// Execute a child block in the Flowchart.
    /// You can use this method in a UI event. e.g. to handle a button click.
    public void ExecuteBlock(String blockName)
    {
//        var block = FindBlock(blockName);
//
//        if (block == null)
//        {
//            Debug.LogError("Block " + blockName  + "does not exist");
//            return;
//        }
//
//        if (!ExecuteBlock(block))
//        {
//            Debug.LogWarning("Block " + blockName  + "failed to execute");
//        }
    }

    /// <summary>
    /// Execute a child block in the flowchart.
    /// The block must be in an idle state to be executed.
    /// This version provides extra options to control how the block is executed.
    /// Returns true if the Block started execution.
    /// </summary>
    public boolean ExecuteBlock(Block block, int commandIndex, Action onComplete)
    {
        if (block == null)
        {
            Debug.LogError("Block must not be null");
            return false;
        }

        if (((Block)block).gameObject != gameObject)
        {
            Debug.LogError("Block must belong to the same gameobject as this Flowchart");
            return false;
        }

        // Can't restart a running block, have to wait until it's idle again
        if (block.IsExecuting())
        {
            return false;
        }

        // Start executing the Block as a new coroutine
        StartCoroutine(block.Execute(commandIndex, onComplete));

        return true;
    }

    /// <summary>
    /// Stop all executing Blocks in this Flowchart.
    /// </summary>
    public void StopAllBlocks()
    {
        var blocks = GetComponents<Block>();
        for (int i = 0; i < blocks.Length; i++)
        {
            var block = blocks[i];
            if (block.IsExecuting())
            {
                block.Stop();
            }
        }
    }

    /// <summary>
    /// Sends a message to this Flowchart only.
    /// Any block with a matching MessageReceived event handler will start executing.
    /// </summary>
    public void SendFungusMessage(String messageName)
    {
        var eventHandlers = GetComponents<MessageReceived>();
        for (int i = 0; i < eventHandlers.Length; i++)
        {
            var eventHandler = eventHandlers[i];
            eventHandler.OnSendFungusMessage(messageName);
        }
    }

    /// <summary>
    /// Returns a new variable key that is guaranteed not to clash with any existing variable in the list.
    /// </summary>
    public String GetUniqueVariableKey(string originalKey, Variable ignoreVariable = null)
    {
        int suffix = 0;
        string baseKey = originalKey;

        // Only letters and digits allowed
        char[] arr = baseKey.Where(c => (char.IsLetterOrDigit(c) || c == '_')).ToArray();
        baseKey = new string(arr);

        // No leading digits allowed
        baseKey = baseKey.TrimStart('0','1','2','3','4','5','6','7','8','9');

        // No empty keys allowed
        if (baseKey.Length == 0)
        {
            baseKey = "Var";
        }

        string key = baseKey;
        while (true)
        {
            bool collision = false;
            for (int i = 0; i < variables.Count; i++)
            {
                var variable = variables[i];
                if (variable == null || variable == ignoreVariable || variable.Key == null)
                {
                    continue;
                }
                if (variable.Key.Equals(key, StringComparison.CurrentCultureIgnoreCase))
                {
                    collision = true;
                    suffix++;
                    key = baseKey + suffix;
                }
            }

            if (!collision)
            {
                return key;
            }
        }
    }

    /// <summary>
    /// Returns a new Block key that is guaranteed not to clash with any existing Block in the Flowchart.
    /// </summary>
    public String GetUniqueBlockKey(String originalKey, Block ignoreBlock = null)
    {
        int suffix = 0;
        String baseKey = originalKey.trim();

        // No empty keys allowed
        if (baseKey.length() == 0)
        {
            baseKey = AtomCommandConstants.DefaultBlockName;
        }

        // var blocks = GetComponents<Block>();
        Block[] blocks = null;

        String key = baseKey;
        while (true)
        {
            boolean collision = false;
            for (int i = 0; i < blocks.length; i++)
            {
                Block block = blocks[i];
                if (block == ignoreBlock || block.getBlockName() == null)
                {
                    continue;
                }
                if (block.getBlockName().equalsIgnoreCase(key))
                {
                    collision = true;
                    suffix++;
                    key = baseKey + suffix;
                }
            }

            if (!collision)
            {
                return key;
            }
        }
    }

    /// <summary>
    /// Returns a new Label key that is guaranteed not to clash with any existing Label in the Block.
    /// </summary>
    public String GetUniqueLabelKey(String originalKey, Label ignoreLabel)
    {
        int suffix = 0;
        String baseKey = originalKey.trim();

        // No empty keys allowed
        if (baseKey.length() == 0)
        {
            baseKey = "New Label";
        }

        var block = ignoreLabel.ParentBlock;

        String key = baseKey;
        while (true)
        {
            bool collision = false;
            var commandList = block.CommandList;
            for (int i = 0; i < commandList.Count; i++)
            {
                var command = commandList[i];
                Label label = command as Label;
                if (label == null || label == ignoreLabel)
                {
                    continue;
                }
                if (label.Key.Equals(key, StringComparison.CurrentCultureIgnoreCase))
                {
                    collision = true;
                    suffix++;
                    key = baseKey + suffix;
                }
            }

            if (!collision)
            {
                return key;
            }
        }
    }

    /// <summary>
    /// Returns the variable with the specified key, or null if the key is not found.
    /// You will need to cast the returned variable to the correct sub-type.
    /// You can then access the variable's value using the Value property. e.g.
    /// BooleanVariable boolVar = flowchart.GetVariable("MyBool") as BooleanVariable;
    /// boolVar.Value = false;
    /// </summary>
    public Variable GetVariable(String key)
    {
        for (int i = 0; i < variables.size(); i++)
        {
            Variable variable = variables.get(i);
            if (variable != null && variable.getKey().equalsIgnoreCase(key))
            {
                return variable;
            }
        }

        return null;
    }

/// <summary>
/// Returns the variable with the specified key, or null if the key is not found.
/// You can then access the variable's value using the Value property. e.g.
/// BooleanVariable boolVar = flowchart.GetVariable<BooleanVariable>("MyBool");
/// boolVar.Value = false;
/// </summary>
public T GetVariable<T>(string key) where T : Variable
        {
        for (int i = 0; i < variables.Count; i++)
        {
        var variable = variables[i];
        if (variable != null && variable.Key == key)
        {
        return variable as T;
        }
        }

        Debug.LogWarning("Variable " + key + " not found.");
        return null;
        }

/// <summary>
/// Register a new variable with the Flowchart at runtime.
/// The variable should be added as a component on the Flowchart game object.
/// </summary>
public void SetVariable<T>(string key, T newvariable) where T : Variable
        {
        for (int i = 0; i < variables.Count; i++)
        {
        var v = variables[i];
        if (v != null && v.Key == key)
        {
        T variable = v as T;
        if (variable != null)
        {
        variable = newvariable;
        return;
        }
        }
        }

        Debug.LogWarning("Variable " + key + " not found.");
        }

    /// <summary>
    /// Checks if a given variable exists in the flowchart.
    /// </summary>
    public boolean HasVariable(String key)
    {
        for (int i = 0; i < variables.size(); i++)
        {
            Variable v = variables.get(i);
            if (v != null && v.getKey().equals(key))
            {
            return true;
            }
        }
        return false;
    }

    /// <summary>
    /// Returns the list of variable names in the Flowchart.
    /// </summary>
    public String[] getVariableNames()
    {
        String[] vList = new String[variables.size()];

        for (int i = 0; i < variables.size(); i++)
        {
            Variable v = variables.get(i);
            if (v != null)
            {
                vList[i] = v.getKey();
            }
        }
        return vList;
    }

/// <summary>
/// Gets a list of all variables with public scope in this Flowchart.
/// </summary>
public virtual List<Variable> GetPublicVariables()
        {
        var publicVariables = new List<Variable>();
        for (int i = 0; i < variables.Count; i++)
        {
        var v = variables[i];
        if (v != null && v.Scope == VariableScope.Public)
        {
        publicVariables.Add(v);
        }
        }

        return publicVariables;
        }

/// <summary>
/// Gets the value of a boolean variable.
/// Returns false if the variable key does not exist.
/// </summary>
public virtual bool GetBooleanVariable(string key)
        {
        var variable = GetVariable<BooleanVariable>(key);
        if(variable != null)
        {
        return GetVariable<BooleanVariable>(key).Value;
        }
        else
        {
        return false;
        }
        }

/// <summary>
/// Sets the value of a boolean variable.
/// The variable must already be added to the list of variables for this Flowchart.
/// </summary>
public virtual void SetBooleanVariable(string key, bool value)
        {
        var variable = GetVariable<BooleanVariable>(key);
        if(variable != null)
        {
        variable.Value = value;
        }
        }

/// <summary>
/// Gets the value of an integer variable.
/// Returns 0 if the variable key does not exist.
/// </summary>
public virtual int GetIntegerVariable(string key)
        {
        var variable = GetVariable<IntegerVariable>(key);
        if (variable != null)
        {
        return GetVariable<IntegerVariable>(key).Value;
        }
        else
        {
        return 0;
        }
        }

/// <summary>
/// Sets the value of an integer variable.
/// The variable must already be added to the list of variables for this Flowchart.
/// </summary>
public virtual void SetIntegerVariable(string key, int value)
        {
        var variable = GetVariable<IntegerVariable>(key);
        if (variable != null)
        {
        variable.Value = value;
        }
        }

/// <summary>
/// Gets the value of a float variable.
/// Returns 0 if the variable key does not exist.
/// </summary>
public virtual float GetFloatVariable(string key)
        {
        var variable = GetVariable<FloatVariable>(key);
        if (variable != null)
        {
        return GetVariable<FloatVariable>(key).Value;
        }
        else
        {
        return 0f;
        }
        }

/// <summary>
/// Sets the value of a float variable.
/// The variable must already be added to the list of variables for this Flowchart.
/// </summary>
public virtual void SetFloatVariable(string key, float value)
        {
        var variable = GetVariable<FloatVariable>(key);
        if (variable != null)
        {
        variable.Value = value;
        }
        }

/// <summary>
/// Gets the value of a string variable.
/// Returns the empty string if the variable key does not exist.
/// </summary>
public virtual string GetStringVariable(string key)
        {
        var variable = GetVariable<StringVariable>(key);
        if (variable != null)
        {
        return GetVariable<StringVariable>(key).Value;
        }
        else
        {
        return "";
        }
        }

/// <summary>
/// Sets the value of a string variable.
/// The variable must already be added to the list of variables for this Flowchart.
/// </summary>
public virtual void SetStringVariable(string key, string value)
        {
        var variable = GetVariable<StringVariable>(key);
        if (variable != null)
        {
        variable.Value = value;
        }
        }

/// <summary>
/// Gets the value of a GameObject variable.
/// Returns null if the variable key does not exist.
/// </summary>
public virtual GameObject GetGameObjectVariable(string key)
        {
        var variable = GetVariable<GameObjectVariable>(key);

        if (variable != null)
        {
        return GetVariable<GameObjectVariable>(key).Value;
        }
        else
        {
        return null;
        }
        }

/// <summary>
/// Sets the value of a GameObject variable.
/// The variable must already be added to the list of variables for this Flowchart.
/// </summary>
public virtual void SetGameObjectVariable(string key, GameObject value)
        {
        var variable = GetVariable<GameObjectVariable>(key);
        if (variable != null)
        {
        variable.Value = value;
        }
        }

/// <summary>
/// Gets the value of a Transform variable.
/// Returns null if the variable key does not exist.
/// </summary>
public virtual Transform GetTransformVariable(string key)
        {
        var variable = GetVariable<TransformVariable>(key);

        if (variable != null)
        {
        return GetVariable<TransformVariable>(key).Value;
        }
        else
        {
        return null;
        }
        }

/// <summary>
/// Sets the value of a Transform variable.
/// The variable must already be added to the list of variables for this Flowchart.
/// </summary>
public virtual void SetTransformVariable(string key, Transform value)
        {
        var variable = GetVariable<TransformVariable>(key);
        if (variable != null)
        {
        variable.Value = value;
        }
        }

/// <summary>
/// Set the block objects to be hidden or visible depending on the hideComponents property.
/// </summary>
public virtual void UpdateHideFlags()
        {
        if (hideComponents)
        {
        var blocks = GetComponents<Block>();
        for (int i = 0; i < blocks.Length; i++)
        {
        var block = blocks[i];
        block.hideFlags = HideFlags.HideInInspector;
        if (block.gameObject != gameObject)
        {
        block.hideFlags = HideFlags.HideInHierarchy;
        }
        }

        var commands = GetComponents<Command>();
        for (int i = 0; i < commands.Length; i++)
        {
        var command = commands[i];
        command.hideFlags = HideFlags.HideInInspector;
        }

        var eventHandlers = GetComponents<EventHandler>();
        for (int i = 0; i < eventHandlers.Length; i++)
        {
        var eventHandler = eventHandlers[i];
        eventHandler.hideFlags = HideFlags.HideInInspector;
        }
        }
        else
        {
        var monoBehaviours = GetComponents<MonoBehaviour>();
        for (int i = 0; i < monoBehaviours.Length; i++)
        {
        var monoBehaviour = monoBehaviours[i];
        if (monoBehaviour == null)
        {
        continue;
        }
        monoBehaviour.hideFlags = HideFlags.None;
        monoBehaviour.gameObject.hideFlags = HideFlags.None;
        }
        }
        }

/// <summary>
/// Clears the list of selected commands.
/// </summary>
public virtual void ClearSelectedCommands()
        {
        selectedCommands.Clear();
        }

/// <summary>
/// Adds a command to the list of selected commands.
/// </summary>
public virtual void AddSelectedCommand(Command command)
        {
        if (!selectedCommands.Contains(command))
        {
        selectedCommands.Add(command);
        }
        }

/// <summary>
/// Clears the list of selected blocks.
/// </summary>
public virtual void ClearSelectedBlocks()
        {
        selectedBlocks.Clear();
        }

/// <summary>
/// Adds a block to the list of selected blocks.
/// </summary>
public virtual void AddSelectedBlock(Block block)
        {
        if (!selectedBlocks.Contains(block))
        {
        selectedBlocks.Add(block);
        }
        }

/// <summary>
/// Reset the commands and variables in the Flowchart.
/// </summary>
public virtual void Reset(bool resetCommands, bool resetVariables)
        {
        if (resetCommands)
        {
        var commands = GetComponents<Command>();
        for (int i = 0; i < commands.Length; i++)
        {
        var command = commands[i];
        command.OnReset();
        }
        }

        if (resetVariables)
        {
        for (int i = 0; i < variables.Count; i++)
        {
        var variable = variables[i];
        variable.OnReset();
        }
        }
        }

/// <summary>
/// Override this in a Flowchart subclass to filter which commands are shown in the Add Command list.
/// </summary>
public virtual bool IsCommandSupported(CommandInfoAttribute commandInfo)
        {
        for (int i = 0; i < hideCommands.Count; i++)
        {
        // Match on category or command name (case insensitive)
        var key = hideCommands[i];
        if (String.Compare(commandInfo.Category, key, StringComparison.OrdinalIgnoreCase) == 0 || String.Compare(commandInfo.CommandName, key, StringComparison.OrdinalIgnoreCase) == 0)
        {
        return false;
        }
        }

        return true;
        }

/// <summary>
/// Returns true if there are any executing blocks in this Flowchart.
/// </summary>
public virtual bool HasExecutingBlocks()
        {
        var blocks = GetComponents<Block>();
        for (int i = 0; i < blocks.Length; i++)
        {
        var block = blocks[i];
        if (block.IsExecuting())
        {
        return true;
        }
        }
        return false;
        }

/// <summary>
/// Returns a list of all executing blocks in this Flowchart.
/// </summary>
public virtual List<Block> GetExecutingBlocks()
        {
        var executingBlocks = new List<Block>();
        var blocks = GetComponents<Block>();
        for (int i = 0; i < blocks.Length; i++)
        {
        var block = blocks[i];
        if (block.IsExecuting())
        {
        executingBlocks.Add(block);
        }
        }

        return executingBlocks;
        }

/// <summary>
/// Substitute variables in the input text with the format {$VarName}
/// This will first match with private variables in this Flowchart, and then
/// with public variables in all Flowcharts in the scene (and any component
/// in the scene that implements StringSubstituter.ISubstitutionHandler).
/// </summary>
public virtual string SubstituteVariables(string input)
        {
        if (stringSubstituer == null)
        {
        stringSubstituer = new StringSubstituter();
        stringSubstituer.CacheSubstitutionHandlers();
        }

        // Use the string builder from StringSubstituter for efficiency.
        StringBuilder sb = stringSubstituer._StringBuilder;
        sb.Length = 0;
        sb.Append(input);

        // Instantiate the regular expression object.
        Regex r = new Regex("{\\$.*?}");

        bool changed = false;

        // Match the regular expression pattern against a text string.
        var results = r.Matches(input);
        for (int i = 0; i < results.Count; i++)
        {
        Match match = results[i];
        string key = match.Value.Substring(2, match.Value.Length - 3);
        // Look for any matching private variables in this Flowchart first
        for (int j = 0; j < variables.Count; j++)
        {
        var variable = variables[j];
        if (variable == null)
        continue;
        if (variable.Scope == VariableScope.Private && variable.Key == key)
        {
        string value = variable.ToString();
        sb.Replace(match.Value, value);
        changed = true;
        }
        }
        }

        // Now do all other substitutions in the scene
        changed |= stringSubstituer.SubstituteStrings(sb);

        if (changed)
        {
        return sb.ToString();
        }
        else
        {
        return input;
        }
        }

        #endregion

        #region IStringSubstituter implementation

        /// <summary>
        /// Implementation of StringSubstituter.ISubstitutionHandler which matches any public variable in the Flowchart.
        /// To perform full variable substitution with all substitution handlers in the scene, you should
        /// use the SubstituteVariables() method instead.
        /// </summary>
        [MoonSharp.Interpreter.MoonSharpHidden]
public virtual bool SubstituteStrings(StringBuilder input)
        {
        // Instantiate the regular expression object.
        Regex r = new Regex("{\\$.*?}");

        bool modified = false;

        // Match the regular expression pattern against a text string.
        var results = r.Matches(input.ToString());
        for (int i = 0; i < results.Count; i++)
        {
        Match match = results[i];
        string key = match.Value.Substring(2, match.Value.Length - 3);
        // Look for any matching public variables in this Flowchart
        for (int j = 0; j < variables.Count; j++)
        {
        var variable = variables[j];
        if (variable == null)
        {
        continue;
        }
        if (variable.Scope == VariableScope.Public && variable.Key == key)
        {
        string value = variable.ToString();
        input.Replace(match.Value, value);
        modified = true;
        }
        }
        }

        return modified;
        }

        #endregion
        }