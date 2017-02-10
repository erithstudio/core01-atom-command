package org.erith.core.atomcommand.variabletypes;


import org.erith.core.atomcommand.annotations.VariableProperty;

import java.io.Serializable;

/// <summary>
/// Container for a string variable reference or constant value.
/// Appears as a multi-line property in the inspector.
/// For a single-line property, use StringData.
/// </summary>
public class StringDataMulti implements Serializable {
    @VariableProperty(defaultText = "<Value>", variableTypes = StringVariable.class)
    public StringVariable stringRef;
    public String stringVal;

    public StringDataMulti(String v) {
        stringVal = v;
        stringRef = null;
    }

    public String getValue() {
        return (stringRef == null) ? stringVal : stringRef.getValue();
    }

    public void setValue(String value) {
        if (stringRef == null) {
            stringVal = value;
        } else {
            stringRef.setValue(value);
        }
    }

    public String GetDescription() {
        if (stringRef == null) {
            return stringVal;
        } else {
            return stringRef.getKey();
        }
    }
}