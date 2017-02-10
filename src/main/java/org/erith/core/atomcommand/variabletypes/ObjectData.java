package org.erith.core.atomcommand.variabletypes;


import org.erith.core.atomcommand.annotations.VariableProperty;

import java.io.Serializable;

/// <summary>
/// Container for an Object variable reference or constant value.
/// </summary>
public class ObjectData implements Serializable {
    @VariableProperty(defaultText = "<Value>", variableTypes = ObjectVariable.class)
    public ObjectVariable objectRef;
    public Object objectVal;

    public ObjectData(Object v) {
        objectVal = v;
        objectRef = null;
    }

    public Object getValue() {
        return (objectRef == null) ? objectVal : objectRef.getValue();
    }

    public void setValue(Object value) {
        if (objectRef == null) {
            objectVal = value;
        } else {
            objectRef.setValue(value);
        }
    }

    public String GetDescription() {
        if (objectRef == null) {
            return objectVal.toString();
        } else {
            return objectRef.getKey();
        }
    }
}