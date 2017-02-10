package org.erith.core.atomcommand.variabletypes;

import org.erith.core.atomcommand.annotations.VariableProperty;

import java.io.Serializable;

/// <summary>
/// Container for an float variable reference or constant value.
/// </summary>
public class FloatData implements Serializable {
    @VariableProperty(defaultText = "<Value>", variableTypes = FloatVariable.class)
    public FloatVariable floatRef;
    public Float floatVal;

    public FloatData(float v) {
        floatVal = v;
        floatRef = null;
    }

    public Float getValue() {
        return (floatRef == null) ? floatVal : floatRef.getValue();
    }

    public void setValue(Float value) {
        if (floatRef == null) {
            floatVal = value;
        } else {
            floatRef.setValue(value);
        }
    }

    public String GetDescription() {
        if (floatRef == null) {
            return floatVal.toString();
        } else {
            return floatRef.getKey();
        }
    }
}