package expressions;


import interpretor.Visitor;

// Classe abstraite représentant une expression
abstract class Expr {
    public abstract void accept(Visitor v);
}
