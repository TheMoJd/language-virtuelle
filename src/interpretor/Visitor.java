package interpretor;

import expressions.*;
import instructions.Assignment;
import instructions.Println;
import variables.VariableUse;

public abstract class Visitor {
    public abstract void visitIntExpr(IntExpr interExpr);
    public abstract void visitVariableUse(VariableUse varUse);
    public abstract void visitPlusExpr(PlusExpr plusExpr);
    public abstract void visitMinusExpr(MinusExpr minusExpr);
    public abstract void visitMultExpr(MultExpr multExpr);
    public abstract void visitDivExpr(DivExpr divExpr);
    public abstract void visitAssignment(Assignment assignment);
    public abstract void visitPrintln(Println println);
}
