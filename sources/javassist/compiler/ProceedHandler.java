package javassist.compiler;

import javassist.bytecode.Bytecode;
import javassist.compiler.ast.ASTList;

/* loaded from: grasscutter.jar:javassist/compiler/ProceedHandler.class */
public interface ProceedHandler {
    void doit(JvstCodeGen jvstCodeGen, Bytecode bytecode, ASTList aSTList) throws CompileError;

    void setReturnType(JvstTypeChecker jvstTypeChecker, ASTList aSTList) throws CompileError;
}
