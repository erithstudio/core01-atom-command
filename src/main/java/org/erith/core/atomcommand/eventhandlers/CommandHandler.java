package org.erith.core.atomcommand.eventhandlers;

import org.erith.core.atomcommand.commands.Command;
import org.erith.core.atomcommand.components.Block;

/**
 * Created by user on 2/10/2017.
 */
public interface CommandHandler {
    void execute(Block block, Command command, int commandIndex, int maxCommandIndex);
}
