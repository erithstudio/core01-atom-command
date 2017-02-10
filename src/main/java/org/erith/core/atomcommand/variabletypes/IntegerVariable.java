package org.erith.core.atomcommand.variabletypes;

import org.erith.core.atomcommand.components.variables.CompareOperator;
import org.erith.core.atomcommand.components.variables.VariableBase;

import java.io.Serializable;

import static org.erith.core.atomcommand.components.variables.CompareOperator.*;

/// <summary>
/// Integer variable type.
/// </summary>
public class IntegerVariable extends VariableBase<Integer> implements Serializable {
    public boolean Evaluate(CompareOperator compareOperator, int integerValue) {
        int lhs = value;
        int rhs = integerValue;

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