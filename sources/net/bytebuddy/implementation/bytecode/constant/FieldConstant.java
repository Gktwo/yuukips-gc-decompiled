package net.bytebuddy.implementation.bytecode.constant;

import java.lang.reflect.Field;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.jar.asm.MethodVisitor;

/* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/constant/FieldConstant.class */
public class FieldConstant implements StackManipulation {
    private final FieldDescription.InDefinedShape fieldDescription;

    public FieldConstant(FieldDescription.InDefinedShape fieldDescription) {
        this.fieldDescription = fieldDescription;
    }

    public StackManipulation cached() {
        return new Cached(this);
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public boolean isValid() {
        return true;
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
        try {
            return new StackManipulation.Compound(ClassConstant.m114of(this.fieldDescription.getDeclaringType()), new TextConstant(this.fieldDescription.getInternalName()), MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(Class.class.getMethod("getDeclaredField", String.class)))).apply(methodVisitor, implementationContext);
        } catch (NoSuchMethodException exception) {
            throw new IllegalStateException("Cannot locate Class::getDeclaredField", exception);
        }
    }

    public int hashCode() {
        return this.fieldDescription.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        return this.fieldDescription.equals(((FieldConstant) other).fieldDescription);
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/constant/FieldConstant$Cached.class */
    protected static class Cached implements StackManipulation {
        private final StackManipulation fieldConstant;

        public Cached(StackManipulation fieldConstant) {
            this.fieldConstant = fieldConstant;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return this.fieldConstant.isValid();
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
            return FieldAccess.forField(implementationContext.cache(this.fieldConstant, TypeDescription.ForLoadedType.m247of(Field.class))).read().apply(methodVisitor, implementationContext);
        }

        public int hashCode() {
            return this.fieldConstant.hashCode();
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || getClass() != other.getClass()) {
                return false;
            }
            return this.fieldConstant.equals(((Cached) other).fieldConstant);
        }
    }
}
