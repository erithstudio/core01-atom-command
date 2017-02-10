package org.erith.core.atomcommand.signals;

import org.erith.core.atomcommand.commands.Command;
import org.erith.core.atomcommand.components.Block;
import org.erith.core.atomcommand.eventhandlers.BlockHandler;
import org.erith.core.atomcommand.eventhandlers.CommandHandler;

/// <summary>
/// Block event signalling system.
/// You can use this to be notified about various events in the Block execution process.
/// </summary>
public class BlockSignals
{
    /// <summary>
    /// BlockStart signal. Sent when the Block starts execution.
    /// </summary>
    public static BlockHandler onBlockStart;
    public static void doBlockStart(Block block) { if (onBlockStart != null) onBlockStart.execute(block); }

    /// <summary>
    /// BlockEnd signal. Sent when the Block ends execution.
    /// </summary>
    public static BlockHandler onBlockEnd;
    public static void doBlockEnd(Block block) { if (onBlockEnd != null) onBlockEnd.execute(block); }

    /// <summary>
    /// CommandExecute signal. Sent just before a Command in a Block executes.
    /// </summary>
    public static CommandHandler onCommandExecute;
    public static void doCommandExecute(Block block, Command command, int commandIndex, int maxCommandIndex) { if (onCommandExecute != null) onCommandExecute.execute(block, command, commandIndex, maxCommandIndex); }

}