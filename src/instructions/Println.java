package instructions;

import expressions.Expr;
import interpretor.Visitor;

public class Println extends Expr {
    public Expr[] args;

    public Println(Expr[] args) {
        this.args = args;
    }

    @Override
    public void accept(Visitor v) {
        v.visitPrintln(this);
    }
}
