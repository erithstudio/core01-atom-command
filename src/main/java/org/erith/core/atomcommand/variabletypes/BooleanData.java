package org.erith.core.atomcommand.variabletypes;

import org.erith.core.atomcommand.annotations.VariableProperty;

import java.io.Serializable;

/// <summary>
/// Container for a Boolean variable reference or constant value.
/// </summary>
public class BooleanData implements Serializable {

    @VariableProperty(defaultText = "<Value>", variableTypes = BooleanVariable.class)
    public BooleanVariable booleanRef;
    public Boolean booleanVal;

    public BooleanData(boolean v) {
        booleanVal = v;
        booleanRef = null;
    }

    public boolean getValue() {
        return (booleanRef == null) ? booleanVal : booleanRef.getValue();
    }

    public void setValue(boolean value) {
        if (booleanRef == null) {
            booleanVal = value;
        } else {
            booleanRef.setValue(value);
        }
    }

    public String GetDescription() {
        if (booleanRef == null) {
            return booleanVal.toString();
        } else {
            return booleanRef.getKey();
        }
    }
}
