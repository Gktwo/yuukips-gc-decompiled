package net.bytebuddy.utility.visitor;

import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.OpenedClassReader;

/* loaded from: grasscutter.jar:net/bytebuddy/utility/visitor/FramePaddingMethodVisitor.class */
public class FramePaddingMethodVisitor extends MethodVisitor {
    private boolean padding = false;

    public FramePaddingMethodVisitor(MethodVisitor methodVisitor) {
        super(OpenedClassReader.ASM_API, methodVisitor);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitFrame(int type, int numLocal, Object[] local, int numStack, Object[] stack) {
        if (this.padding) {
            visitInsn(0);
        } else {
            this.padding = true;
        }
        visitFrame(type, numLocal, local, numStack, stack);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitInsn(int opcode) {
        this.padding = false;
        visitInsn(opcode);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitIntInsn(int opcode, int operand) {
        this.padding = false;
        visitIntInsn(opcode, operand);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitVarInsn(int opcode, int offset) {
        this.padding = false;
        visitVarInsn(opcode, offset);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitTypeInsn(int opcode, String type) {
        this.padding = false;
        visitTypeInsn(opcode, type);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitFieldInsn(int opcode, String owner, String name, String descriptor) {
        this.padding = false;
        visitFieldInsn(opcode, owner, name, descriptor);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitMethodInsn(int opcode, String owner, String name, String descriptor) {
        this.padding = false;
        visitMethodInsn(opcode, owner, name, descriptor);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        this.padding = false;
        visitMethodInsn(opcode, owner, name, descriptor, isInterface);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitInvokeDynamicInsn(String name, String descriptor, Handle handle, Object... argument) {
        this.padding = false;
        visitInvokeDynamicInsn(name, descriptor, handle, argument);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitJumpInsn(int opcode, Label label) {
        this.padding = false;
        visitJumpInsn(opcode, label);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitLdcInsn(Object value) {
        this.padding = false;
        visitLdcInsn(value);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitIincInsn(int offset, int increment) {
        this.padding = false;
        visitIincInsn(offset, increment);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... label) {
        this.padding = false;
        visitTableSwitchInsn(min, max, dflt, label);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitLookupSwitchInsn(Label dflt, int[] key, Label[] label) {
        this.padding = false;
        visitLookupSwitchInsn(dflt, key, label);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitMultiANewArrayInsn(String descriptor, int dimensions) {
        this.padding = false;
        visitMultiANewArrayInsn(descriptor, dimensions);
    }
}
