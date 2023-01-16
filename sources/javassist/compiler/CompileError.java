package javassist.compiler;

import javassist.CannotCompileException;
import javassist.NotFoundException;

/* loaded from: grasscutter.jar:javassist/compiler/CompileError.class */
public class CompileError extends Exception {
    private static final long serialVersionUID = 1;
    private Lex lex;
    private String reason;

    public CompileError(String s, Lex l) {
        this.reason = s;
        this.lex = l;
    }

    public CompileError(String s) {
        this.reason = s;
        this.lex = null;
    }

    public CompileError(CannotCompileException e) {
        this(e.getReason());
    }

    public CompileError(NotFoundException e) {
        this("cannot find " + e.getMessage());
    }

    public Lex getLex() {
        return this.lex;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.reason;
    }

    @Override // java.lang.Throwable, java.lang.Object
    public String toString() {
        return "compile error: " + this.reason;
    }
}
