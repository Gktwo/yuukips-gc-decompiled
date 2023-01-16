package net.bytebuddy.implementation.bytecode.member;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.JavaConstant;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/member/HandleInvocation.class */
public class HandleInvocation implements StackManipulation {
    private static final String METHOD_HANDLE_NAME = "java/lang/invoke/MethodHandle";
    private static final String INVOKE_EXACT = "invokeExact";
    private final JavaConstant.MethodType methodType;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.methodType.equals(((HandleInvocation) obj).methodType);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.methodType.hashCode();
    }

    public HandleInvocation(JavaConstant.MethodType methodType) {
        this.methodType = methodType;
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public boolean isValid() {
        return true;
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
        methodVisitor.visitMethodInsn(182, METHOD_HANDLE_NAME, INVOKE_EXACT, this.methodType.getDescriptor(), false);
        int size = this.methodType.getReturnType().getStackSize().getSize() - this.methodType.getParameterTypes().getStackSize();
        return new StackManipulation.Size(size, Math.max(size, 0));
    }
}
