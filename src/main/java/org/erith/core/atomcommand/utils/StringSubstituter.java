package org.erith.core.atomcommand.utils;

import org.erith.core.atomcommand.interfaces.IStringSubstituter;
import org.erith.core.atomcommand.interfaces.ISubstitutionHandler;

import java.util.*;

/// <summary>
/// Replaces special tokens in a string with substituted values (typically variables or localisation strings).
/// </summary>
public class StringSubstituter implements IStringSubstituter
{
    protected List<ISubstitutionHandler> substitutionHandlers = new ArrayList<ISubstitutionHandler>();

    /// <summary>
    /// The StringBuilder instance used to substitute strings optimally.
    /// </summary>
    protected StringBuilder stringBuilder;

    protected int recursionDepth;


    /// <summary>
    /// Constructor which caches all components in the scene that implement ISubstitutionHandler.
    /// <param name="recursionDepth">Number of levels of recursively embedded keys to resolve.</param>
    /// </summary>
    public StringSubstituter(int recursionDepth)
    {
        stringBuilder = new StringBuilder(1024);
        this.recursionDepth = recursionDepth;
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public void CacheSubstitutionHandlers()
    {
    // Use reflection to find all components in the scene that implement ISubstitutionHandler
//        var types = this.GetType().Assembly.GetTypes().Where(type => type.IsClass &&
//        !type.IsAbstract &&
//        typeof(ISubstitutionHandler).IsAssignableFrom(type));

        Class[] types = null;

        substitutionHandlers.clear();
        for (Class t : types)
        {
            // Object[] objects = GameObject.FindObjectsOfType(t);
            Object[] objects = null;
            for (Object o : objects)
            {
                ISubstitutionHandler handler = (ISubstitutionHandler) o;
                if (handler != null)
                {
                    substitutionHandlers.add(handler);
                }
            }
        }
    }

    public String SubstituteStrings(String input)
    {
        stringBuilder.setLength(0);
        stringBuilder.append(input);

        if (SubstituteStrings(stringBuilder))
        {
            return stringBuilder.toString();
        }
        else
        {
            return input; // String wasn't modified
        }
    }

    public boolean SubstituteStrings(StringBuilder input)
    {
        boolean result = false;

        // Perform the substitution multiple times to expand nested keys
        int loopCount = 0; // Avoid infinite recursion loops
        while (loopCount < recursionDepth)
        {
            boolean modified = false;
            for (ISubstitutionHandler handler : substitutionHandlers)
            {
                if (handler.SubstituteStrings(input))
                {
                    modified = true;
                    result = true;
                }
            }

            if (!modified)
            {
                break;
            }

            loopCount++;
        }

        return result;
    }
}