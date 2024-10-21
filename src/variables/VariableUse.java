package variables;

import expressions.Expr;
import interpretor.Visitor;

public class VariableUse extends Expr {
    Variable variable;

    public VariableUse(Variable variable) {
        this.variable = variable;
    }

    @Override
    public void accept(Visitor v) {
        v.visitVariableUse(this);
    }

    public Variable getVariable() {
        return variable;
    }
}
