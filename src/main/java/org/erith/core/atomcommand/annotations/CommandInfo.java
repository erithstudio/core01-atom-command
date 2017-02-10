package org.erith.core.atomcommand.annotations;

/// <summary>
/// Metadata atribute for the Command class.
/// </summary>
public @interface CommandInfo {
    /// <param name="category">The category to place this command in.</param>
    String category();

    /// <param name="commandName">The display name of the command.</param>
    String commandName();

    /// <param name="helpText">Help information to display in the inspector.</param>
    String helpText();

    /// <param name="priority">If two command classes have the same name, the one with highest priority is listed. Negative priority removess the command from the list.</param>///
    int priority();
}