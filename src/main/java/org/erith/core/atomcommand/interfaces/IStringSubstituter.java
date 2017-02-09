package org.erith.core.atomcommand.interfaces;

/**
 * <summary>Replaces special tokens in a string with substituted values (typically variables or localisation strings).</summary>
 */
public interface IStringSubstituter
{
    /// <summary>
    /// The internal StringBuilder object used to perform string substitution.
    /// This is exposed publicly to allow for optimized string manipulation in client code.
    /// </summary>
    StringBuilder getStringBuilder();

    /// <summary>
    /// Populates a cache of all components in the scene that implement ISubstitutionHandler.
    /// </summary>
    void CacheSubstitutionHandlers();

    /// <summary>
    /// Returns a new string that has been processed by all substitution handlers in the scene.
    /// </summary>
    String SubstituteStrings(String input);

    /// <summary>
    /// Returns a new string that has been processed by all substitution handlers in the scene.
    /// </summary>
    boolean SubstituteStrings(StringBuilder input);
}