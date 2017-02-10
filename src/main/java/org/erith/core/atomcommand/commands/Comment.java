package org.erith.core.atomcommand.commands;

import com.badlogic.gdx.graphics.Color;
import org.erith.core.atomcommand.annotations.CommandInfo;
import org.erith.core.atomcommand.annotations.Tooltip;

/// <summary>
/// Use comments to record design notes and reminders about your game.
/// </summary>
@CommandInfo(category = "",
        commandName = "Comment",
        helpText = "Use comments to record design notes and reminders about your game.", priority = 0)
public class Comment extends Command {
    @Tooltip(message = "Name of Commenter")
    protected String commenterName = "";

    @Tooltip(message = "Text to display for this comment")
    protected String commentText = "";

    public void OnEnter() {
        Continue();
    }

    public String GetSummary() {
        if (commenterName != "") {
            return commenterName + ": " + commentText;
        }
        return commentText;
    }

    public Color GetButtonColor() {
        return new Color(220, 220, 220, 255);
    }
}