package org.erith.core.atomcommand.variabletypes;

import org.erith.core.atomcommand.annotations.VariableProperty;

import java.io.Serializable;

/// <summary>
/// Container for an integer variable reference or constant value.
/// </summary>
public class IntegerData implements Serializable {
    @VariableProperty(defaultText = "<Value>", variableTypes = IntegerVariable.class)
    public IntegerVariable integerRef;

    public Integer integerVal;

    public IntegerData(int v) {
        integerVal = v;
        integerRef = null;
    }

    public Integer getValue() {
        return (integerRef == null) ? integerVal : integerRef.getValue();
    }

    public void setValue(Integer value) {
        if (integerRef == null) {
            integerVal = value;
        } else {
            integerRef.setValue(value);
        }
    }

    public String GetDescription() {
        if (integerRef == null) {
            return integerVal.toString();
        } else {
            return integerRef.getKey();
        }
    }
}