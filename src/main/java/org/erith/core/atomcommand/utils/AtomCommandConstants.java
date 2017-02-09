package org.erith.core.atomcommand.utils;

/// <summary>
/// Global constants used in various parts of Fungus.
/// </summary>
public interface AtomCommandConstants {
    /// <summary>
    /// Duration of fade for executing icon displayed beside blocks & commands.
    /// </summary>
    float ExecutingIconFadeTime = 0.5f;

    /// <summary>
    /// The current version of the Flowchart. Used for updating components.
    /// </summary>
    int CurrentVersion = 1;

    /// <summary>
    /// The name of the initial block in a new flowchart.
    /// </summary>
    String DefaultBlockName = "New Block";

    /// <summary>
    /// The default choice block color.
    /// </summary>
    // public static Color DefaultChoiceBlockTint = new Color(1.0f, 0.627f, 0.313f, 1.0f);
    Object DefaultChoiceBlockTint = new Object();

    /// <summary>
    /// The default event block color.
    /// </summary>
    // public static Color DefaultEventBlockTint = new Color(0.784f, 0.882f, 1.0f, 1.0f);
    Object DefaultEventBlockTint = new Object();

    /// <summary>
    /// The default process block color.
    /// </summary>
    // public static Color DefaultProcessBlockTint = new Color(1.0f, 0.882f, 0.0f, 1.0f);
    Object DefaultProcessBlockTint = new Object();

    /// <summary>
    /// The default key used for storing save game data in PlayerPrefs.
    /// </summary>
    String DefaultSaveDataKey = "save_data";
}
