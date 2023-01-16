package net.bytebuddy.implementation.bytecode.constant;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.ConstantDynamic;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.utility.JavaConstant;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/constant/JavaConstantValue.class */
public class JavaConstantValue implements StackManipulation {
    private final JavaConstant constant;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.constant.equals(((JavaConstantValue) obj).constant);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.constant.hashCode();
    }

    public JavaConstantValue(JavaConstant constant) {
        this.constant = constant;
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public boolean isValid() {
        return true;
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
        methodVisitor.visitLdcInsn(this.constant.accept(Visitor.INSTANCE));
        return this.constant.getTypeDescription().getStackSize().toIncreasingSize();
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/constant/JavaConstantValue$Visitor.class */
    public enum Visitor implements JavaConstant.Visitor<Object> {
        INSTANCE;

        @Override // net.bytebuddy.utility.JavaConstant.Visitor
        public Object onValue(JavaConstant.Simple<?> constant) {
            return constant.getValue();
        }

        /* Return type fixed from 'net.bytebuddy.jar.asm.Type' to match base method */
        @Override // net.bytebuddy.utility.JavaConstant.Visitor
        public Object onType(JavaConstant.Simple<TypeDescription> constant) {
            return Type.getType(constant.getValue().getDescriptor());
        }

        /* Return type fixed from 'net.bytebuddy.jar.asm.Type' to match base method */
        @Override // net.bytebuddy.utility.JavaConstant.Visitor
        public Object onMethodType(JavaConstant.MethodType constant) {
            StringBuilder stringBuilder = new StringBuilder().append('(');
            for (TypeDescription parameterType : constant.getParameterTypes()) {
                stringBuilder.append(parameterType.getDescriptor());
            }
            return Type.getMethodType(stringBuilder.append(')').append(constant.getReturnType().getDescriptor()).toString());
        }

        /* Return type fixed from 'net.bytebuddy.jar.asm.Handle' to match base method */
        @Override // net.bytebuddy.utility.JavaConstant.Visitor
        public Object onMethodHandle(JavaConstant.MethodHandle constant) {
            return new Handle(constant.getHandleType().getIdentifier(), constant.getOwnerType().getInternalName(), constant.getName(), constant.getDescriptor(), constant.getOwnerType().isInterface());
        }

        /* Return type fixed from 'net.bytebuddy.jar.asm.ConstantDynamic' to match base method */
        @Override // net.bytebuddy.utility.JavaConstant.Visitor
        public Object onDynamic(JavaConstant.Dynamic constant) {
            Object[] argument = new Object[constant.getArguments().size()];
            for (int index = 0; index < argument.length; index++) {
                argument[index] = constant.getArguments().get(index).accept(this);
            }
            return new ConstantDynamic(constant.getName(), constant.getTypeDescription().getDescriptor(), onMethodHandle(constant.getBootstrap()), argument);
        }
    }
}
