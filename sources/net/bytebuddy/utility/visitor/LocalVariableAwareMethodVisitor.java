package net.bytebuddy.utility.visitor;

import edu.umd.p012cs.findbugs.annotations.SuppressFBWarnings;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.OpenedClassReader;

/* loaded from: grasscutter.jar:net/bytebuddy/utility/visitor/LocalVariableAwareMethodVisitor.class */
public class LocalVariableAwareMethodVisitor extends MethodVisitor {
    private int freeOffset;

    public LocalVariableAwareMethodVisitor(MethodVisitor methodVisitor, MethodDescription methodDescription) {
        super(OpenedClassReader.ASM_API, methodVisitor);
        this.freeOffset = methodDescription.getStackSize();
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    @SuppressFBWarnings(value = {"SF_SWITCH_NO_DEFAULT"}, justification = "No action required on default option.")
    public void visitVarInsn(int opcode, int offset) {
        switch (opcode) {
            case 54:
            case 56:
            case 58:
                this.freeOffset = Math.max(this.freeOffset, offset + 1);
                break;
            case 55:
            case 57:
                this.freeOffset = Math.max(this.freeOffset, offset + 2);
                break;
        }
        visitVarInsn(opcode, offset);
    }

    public int getFreeOffset() {
        return this.freeOffset;
    }
}
