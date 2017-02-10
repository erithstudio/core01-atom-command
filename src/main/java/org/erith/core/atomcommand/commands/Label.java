package org.erith.core.atomcommand.commands;

import com.badlogic.gdx.graphics.Color;
import org.erith.core.atomcommand.annotations.CommandInfo;
import org.erith.core.atomcommand.annotations.Tooltip;

/// <summary>
/// Marks a position in the command list for execution to jump to.
/// </summary>
@CommandInfo(category = "Flow", commandName = "Label",
        helpText = "Marks a position in the command list for execution to jump to.", priority = 0)
public class Label extends Command {
    @Tooltip(message = "Display name for the label")
    protected String key = "";

    /// <summary>
    /// Display name for the label
    /// </summary>
    public String getKey() {
        return key;
    }

    public void onEnter() {
        Continue();
    }

    public String GetSummary() {
        return key;
    }

    public Color GetButtonColor() {
        return new Color(200, 200, 253, 255);
    }

}