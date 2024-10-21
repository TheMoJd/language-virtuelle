package expressions;

import interpretor.Visitor;

// Division
public class DivExpr extends BinExpr {
    public DivExpr(Expr left, Expr right) {
        super(left, right);
    }

    @Override
    public void accept(Visitor v) {
        v.visitDivExpr(this);
    }
}