package expressions;

import interpretor.Visitor;

public class InterExpr extends Expr{

    @Override
    public void accept(Visitor v) {
        v.visitIntExpr(this);
    }
}
