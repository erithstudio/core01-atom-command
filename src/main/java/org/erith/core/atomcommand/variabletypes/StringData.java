package org.erith.core.atomcommand.variabletypes;

import org.erith.core.atomcommand.annotations.VariableProperty;

import java.io.Serializable;

/// <summary>
/// Container for a string variable reference or constant value.
/// Appears as a single line property in the inspector.
/// For a multi-line property, use StringDataMulti.
/// </summary>
public class StringData implements Serializable {

    @VariableProperty(defaultText = "<Value>", variableTypes = StringVariable.class)
    public StringVariable stringRef;

    public String stringVal;

    public StringData(String v) {
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