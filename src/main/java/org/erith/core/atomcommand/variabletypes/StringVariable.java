package org.erith.core.atomcommand.variabletypes;

/// <summary>
/// String variable type.
/// </summary>

import org.erith.core.atomcommand.annotations.VariableInfo;
import org.erith.core.atomcommand.components.variables.CompareOperator;
import org.erith.core.atomcommand.components.variables.VariableBase;

import java.io.Serializable;

import static org.erith.core.atomcommand.components.variables.CompareOperator.*;

/// <summary>
/// String variable type.
/// </summary>
@VariableInfo(category = "", variableType = "String", order = 0)
public class StringVariable extends VariableBase<String> implements Serializable {
    public boolean Evaluate(CompareOperator compareOperator, String stringValue) {
        String lhs = value;
        String rhs = stringValue;

        boolean condition = false;

        switch (compareOperator) {
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