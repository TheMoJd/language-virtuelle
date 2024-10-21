package expressions;

import interpretor.Visitor;

public class PlusExpr extends BinExpr {

    public PlusExpr(Expr left, Expr right) {
        super(left, right);
    }

    public void accept(Visitor v) {
        v.visitPlusExpr(this);
    }
}
