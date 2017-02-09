package org.erith.core.atomcommand.variabletypes;

import org.erith.core.atomcommand.annotations.VariableInfo;
import org.erith.core.atomcommand.components.variables.CompareOperator;
import org.erith.core.atomcommand.components.variables.VariableBase;

import java.io.Serializable;

/// <summary>
/// Boolean variable type.
/// </summary>
@VariableInfo(category = "", variableType = "Boolean", order = 0)
public class BooleanVariable extends VariableBase<Boolean> implements Serializable {
    public boolean Evaluate(CompareOperator compareOperator, boolean booleanValue) {
        boolean condition = false;
        boolean lhs = value;
        boolean rhs = booleanValue;

        if(compareOperator == CompareOperator.Equals) {
            condition = lhs == rhs;
        } else {
            condition = lhs != rhs;
        }

        return condition;
    }
}