package expressions;

import interpretor.Visitor;

public abstract class BinExpr extends Expr{

    public Expr left;
    public Expr right;

    public BinExpr(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }
}
