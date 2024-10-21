package expressions;

import interpretor.Visitor;

public class MinusExpr extends BinExpr {

    public MinusExpr(Expr left, Expr right) {
        super(left, right);
    }

    public void accept(Visitor v) {
        v.visitMinusExpr(this);
    }
}
