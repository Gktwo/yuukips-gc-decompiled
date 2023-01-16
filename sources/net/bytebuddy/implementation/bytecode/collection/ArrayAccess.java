package net.bytebuddy.implementation.bytecode.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.jar.asm.MethodVisitor;

/* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/collection/ArrayAccess.class */
public enum ArrayAccess {
    BYTE(51, 84, StackSize.SINGLE),
    SHORT(53, 86, StackSize.SINGLE),
    CHARACTER(52, 85, StackSize.SINGLE),
    INTEGER(46, 79, StackSize.SINGLE),
    LONG(47, 80, StackSize.DOUBLE),
    FLOAT(48, 81, StackSize.SINGLE),
    DOUBLE(49, 82, StackSize.DOUBLE),
    REFERENCE(50, 83, StackSize.SINGLE);
    
    private final int loadOpcode;
    private final int storeOpcode;
    private final StackSize stackSize;

    ArrayAccess(int loadOpcode, int storeOpcode, StackSize stackSize) {
        this.loadOpcode = loadOpcode;
        this.storeOpcode = storeOpcode;
        this.stackSize = stackSize;
    }

    /* renamed from: of */
    public static ArrayAccess m115of(TypeDefinition componentType) {
        if (!componentType.isPrimitive()) {
            return REFERENCE;
        }
        if (componentType.represents(Boolean.TYPE) || componentType.represents(Byte.TYPE)) {
            return BYTE;
        }
        if (componentType.represents(Short.TYPE)) {
            return SHORT;
        }
        if (componentType.represents(Character.TYPE)) {
            return CHARACTER;
        }
        if (componentType.represents(Integer.TYPE)) {
            return INTEGER;
        }
        if (componentType.represents(Long.TYPE)) {
            return LONG;
        }
        if (componentType.represents(Float.TYPE)) {
            return FLOAT;
        }
        if (componentType.represents(Double.TYPE)) {
            return DOUBLE;
        }
        throw new IllegalArgumentException("Not a legal array type: " + componentType);
    }

    public StackManipulation load() {
        return new Loader();
    }

    public StackManipulation store() {
        return new Putter();
    }

    public StackManipulation forEach(List<? extends StackManipulation> processInstructions) {
        List<StackManipulation> stackManipulations = new ArrayList<>(processInstructions.size());
        int index = 0;
        Iterator<? extends StackManipulation> it = processInstructions.iterator();
        while (it.hasNext()) {
            index++;
            stackManipulations.add(new StackManipulation.Compound(Duplication.SINGLE, IntegerConstant.forValue(index), new Loader(), (StackManipulation) it.next()));
        }
        return new StackManipulation.Compound(stackManipulations);
    }

    /* access modifiers changed from: protected */
    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/collection/ArrayAccess$Loader.class */
    public class Loader implements StackManipulation {
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && ArrayAccess.this.equals(ArrayAccess.this);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + ArrayAccess.this.hashCode();
        }

        protected Loader() {
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return true;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
            methodVisitor.visitInsn(ArrayAccess.this.loadOpcode);
            return ArrayAccess.this.stackSize.toIncreasingSize().aggregate(new StackManipulation.Size(-2, 0));
        }
    }

    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/collection/ArrayAccess$Putter.class */
    protected class Putter implements StackManipulation {
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && ArrayAccess.this.equals(ArrayAccess.this);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + ArrayAccess.this.hashCode();
        }

        protected Putter() {
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return true;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
            methodVisitor.visitInsn(ArrayAccess.this.storeOpcode);
            return ArrayAccess.this.stackSize.toDecreasingSize().aggregate(new StackManipulation.Size(-2, 0));
        }
    }
}
