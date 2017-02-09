package org.erith.core.atomcommand.interfaces;



/**
 * <summary></summary>Interface for components that support substituting strings.</summary>
 */
public interface ISubstitutionHandler
{
    /// <summary>
    /// Modifies a StringBuilder so that tokens are replaced by subsituted values.
    /// It's up to clients how to implement substitution but the convention looks like:
    /// "Hi {$VarName}" => "Hi John" where VarName == "John"
    /// </summary>
    /// <returns>True if the input was modified</returns>
    boolean SubstituteStrings(StringBuilder input);
}