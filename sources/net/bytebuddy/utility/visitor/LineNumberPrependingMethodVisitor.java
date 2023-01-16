package net.bytebuddy.utility.visitor;

import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.OpenedClassReader;

/* loaded from: grasscutter.jar:net/bytebuddy/utility/visitor/LineNumberPrependingMethodVisitor.class */
public class LineNumberPrependingMethodVisitor extends ExceptionTableSensitiveMethodVisitor {
    private final Label startOfMethod = new Label();
    private boolean prependLineNumber = true;

    public LineNumberPrependingMethodVisitor(MethodVisitor methodVisitor) {
        super(OpenedClassReader.ASM_API, methodVisitor);
    }

    @Override // net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor
    protected void onAfterExceptionTable() {
        visitLabel(this.startOfMethod);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitLineNumber(int line, Label start) {
        if (this.prependLineNumber) {
            start = this.startOfMethod;
            this.prependLineNumber = false;
        }
        visitLineNumber(line, start);
    }
}
