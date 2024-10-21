package expressions;

import interpretor.Visitor;

public class IntExpr extends Expr {

    int rawValue;

    public IntExpr(int value) {
        this.rawValue = value;
    }

    public int getRawValue() {
        return rawValue;
    }

    @Override
    public void accept(Visitor v) {
        v.visitIntExpr(this);
    }
}
