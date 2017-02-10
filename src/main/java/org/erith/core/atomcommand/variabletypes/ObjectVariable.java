package org.erith.core.atomcommand.variabletypes;

import org.erith.core.atomcommand.annotations.VariableInfo;
import org.erith.core.atomcommand.components.variables.VariableBase;

import java.io.Serializable;

/// <summary>
/// Object variable type.
/// </summary>
@VariableInfo(category = "Other", variableType = "Object", order = 0)
public class ObjectVariable extends VariableBase<Object> implements Serializable {
}