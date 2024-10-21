package expressions;

import interpretor.Visitor;

public class MultExpr extends BinExpr {

    public MultExpr(Expr left, Expr right) {
        super(left, right);
    }

    public void accept(Visitor v) {
        v.visitMultExpr(this);
    }
}
