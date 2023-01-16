package javassist.compiler.ast;

import javassist.compiler.CompileError;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:javassist/compiler/ast/Variable.class */
public class Variable extends Symbol {
    private static final long serialVersionUID = 1;
    protected Declarator declarator;

    public Variable(String sym, Declarator d) {
        super(sym);
        this.declarator = d;
    }

    public Declarator getDeclarator() {
        return this.declarator;
    }

    @Override // javassist.compiler.ast.Symbol, javassist.compiler.ast.ASTree, java.lang.Object
    public String toString() {
        return this.identifier + EmitterKt.COMMENT_PREFIX + this.declarator.getType();
    }

    @Override // javassist.compiler.ast.Symbol, javassist.compiler.ast.ASTree
    public void accept(Visitor v) throws CompileError {
        v.atVariable(this);
    }
}
