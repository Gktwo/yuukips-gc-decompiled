package javassist.compiler.ast;

import javassist.compiler.CompileError;
import javassist.compiler.TokenId;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:javassist/compiler/ast/CastExpr.class */
public class CastExpr extends ASTList implements TokenId {
    private static final long serialVersionUID = 1;
    protected int castType;
    protected int arrayDim;

    public CastExpr(ASTList className, int dim, ASTree expr) {
        super(className, new ASTList(expr));
        this.castType = 307;
        this.arrayDim = dim;
    }

    public CastExpr(int type, int dim, ASTree expr) {
        super(null, new ASTList(expr));
        this.castType = type;
        this.arrayDim = dim;
    }

    public int getType() {
        return this.castType;
    }

    public int getArrayDim() {
        return this.arrayDim;
    }

    public ASTList getClassName() {
        return (ASTList) getLeft();
    }

    public ASTree getOprand() {
        return getRight().getLeft();
    }

    public void setOprand(ASTree t) {
        getRight().setLeft(t);
    }

    @Override // javassist.compiler.ast.ASTree
    public String getTag() {
        return "cast:" + this.castType + EmitterKt.COMMENT_PREFIX + this.arrayDim;
    }

    @Override // javassist.compiler.ast.ASTList, javassist.compiler.ast.ASTree
    public void accept(Visitor v) throws CompileError {
        v.atCastExpr(this);
    }
}
