package org.erith.core.atomcommand.variabletypes;

import org.erith.core.atomcommand.annotations.VariableInfo;
import org.erith.core.atomcommand.components.variables.CompareOperator;
import org.erith.core.atomcommand.components.variables.VariableBase;

import java.io.Serializable;

import static org.erith.core.atomcommand.components.variables.CompareOperator.*;

/// <summary>
/// Boolean variable type.
/// </summary>
@VariableInfo(category = "", variableType = "Boolean", order = 0)
public class BooleanVariable extends VariableBase<Boolean> implements Serializable {
    public boolean Evaluate(CompareOperator compareOperator, boolean booleanValue) {
        boolean condition = false;
        boolean lhs = value;
        boolean rhs = booleanValue;

        switch (compareOperator)
        {
            case Equals:
                condition = lhs == rhs;
                break;
            case NotEquals:
            default:
                condition = lhs != rhs;
                break;
        }

        return condition;
    }
}