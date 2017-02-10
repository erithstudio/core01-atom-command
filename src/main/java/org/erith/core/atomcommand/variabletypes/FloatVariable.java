package org.erith.core.atomcommand.variabletypes;


import org.erith.core.atomcommand.annotations.VariableInfo;
import org.erith.core.atomcommand.components.variables.CompareOperator;
import org.erith.core.atomcommand.components.variables.VariableBase;

import java.io.Serializable;

import static org.erith.core.atomcommand.components.variables.CompareOperator.*;

/// <summary>
/// Float variable type.
/// </summary>
@VariableInfo(category = "", variableType = "Float", order = 0)
public class FloatVariable extends VariableBase<Float> implements Serializable {
    public boolean Evaluate(CompareOperator compareOperator, float floatValue) {
        float lhs = value;
        float rhs = floatValue;

        boolean condition = false;

        switch (compareOperator) {
            case Equals:
                condition = lhs == rhs;
                break;
            case NotEquals:
                condition = lhs != rhs;
                break;
            case LessThan:
                condition = lhs < rhs;
                break;
            case GreaterThan:
                condition = lhs > rhs;
                break;
            case LessThanOrEquals:
                condition = lhs <= rhs;
                break;
            case GreaterThanOrEquals:
                condition = lhs >= rhs;
                break;
        }

        return condition;
    }
}