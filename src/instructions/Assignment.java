package instructions;

import expressions.Expr;
import interpretor.Visitor;
import variables.Variable;

//affectation
public class Assignment extends Expr {
    public Variable variable;
    public Expr rightHandSide;

    public Assignment(Variable variable, Expr rhs) {
        this.variable = variable;
        this.rightHandSide = rhs;
    }

    @Override
    public void accept(Visitor v) {
        v.visitAssignment(this);
    }
}
