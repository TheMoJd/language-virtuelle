package interpretor;

import expressions.*;
import instructions.*;
import variables.*;

import java.util.*;

public class SimpleStackInterpreter extends Visitor {
    Stack<Expr> stack;
    Map<Variable, IntExpr> values;
    Map<String, Variable> variables;

    public SimpleStackInterpreter() {
        this.stack = new Stack<>();
        this.values = new HashMap<>();
        this.variables = new HashMap<>();
    }

    // Méthode pour récupérer une variable par son nom
    public Variable getVariableNamed(String name) {
        return variables.computeIfAbsent(name, Variable::new);
    }

    // Visiteur pour IntExpr
    @Override
    public void visitIntExpr(IntExpr intExpr) {
        stack.push(intExpr);
    }

    // Visiteur pour VariableUse
    @Override
    public void visitVariableUse(VariableUse varUse) {
        Variable v = varUse.getVariable();
        stack.push(new IntExpr(values.get(v).getRawValue()));
    }

    // Visiteur pour PlusExpr
    @Override
    public void visitPlusExpr(PlusExpr plusExpr) {
        plusExpr.left.accept(this);
        plusExpr.right.accept(this);
        IntExpr right = (IntExpr) stack.pop();
        IntExpr left = (IntExpr) stack.pop();
        stack.push(new IntExpr(left.getRawValue() + right.getRawValue()));
    }

    // Visiteur pour MinusExpr
    @Override
    public void visitMinusExpr(MinusExpr minusExpr) {
        minusExpr.left.accept(this);
        minusExpr.right.accept(this);
        IntExpr right = (IntExpr) stack.pop();
        IntExpr left = (IntExpr) stack.pop();
        stack.push(new IntExpr(left.getRawValue() - right.getRawValue()));
    }

    // Visiteur pour MultExpr
    @Override
    public void visitMultExpr(MultExpr multExpr) {
        multExpr.left.accept(this);
        multExpr.right.accept(this);
        IntExpr right = (IntExpr) stack.pop();
        IntExpr left = (IntExpr) stack.pop();
        stack.push(new IntExpr(left.getRawValue() * right.getRawValue()));
    }

    // Visiteur pour DivExpr
    @Override
    public void visitDivExpr(DivExpr divExpr) {
        divExpr.left.accept(this);
        divExpr.right.accept(this);
        IntExpr right = (IntExpr) stack.pop();
        IntExpr left = (IntExpr) stack.pop();
        stack.push(new IntExpr(left.getRawValue() / right.getRawValue()));
    }

    // Visiteur pour l'affectation
    @Override
    public void visitAssignment(Assignment assignment) {
        assignment.rightHandSide.accept(this);
        IntExpr value = (IntExpr) stack.pop();
        values.put(assignment.variable, value);
    }

    // Visiteur pour Println
    @Override
    public void visitPrintln(Println println) {
        for (Expr arg : println.args) {
            arg.accept(this);
            System.out.println(((IntExpr) stack.pop()).getRawValue());
        }
    }
}
