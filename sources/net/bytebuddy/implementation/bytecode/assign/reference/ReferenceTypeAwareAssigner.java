package net.bytebuddy.implementation.bytecode.assign.reference;

import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;

/* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/assign/reference/ReferenceTypeAwareAssigner.class */
public enum ReferenceTypeAwareAssigner implements Assigner {
    INSTANCE;

    @Override // net.bytebuddy.implementation.bytecode.assign.Assigner
    public StackManipulation assign(TypeDescription.Generic source, TypeDescription.Generic target, Assigner.Typing typing) {
        if (source.isPrimitive() || target.isPrimitive()) {
            return source.equals(target) ? StackManipulation.Trivial.INSTANCE : StackManipulation.Illegal.INSTANCE;
        } else if (source.asErasure().isAssignableTo(target.asErasure())) {
            return StackManipulation.Trivial.INSTANCE;
        } else {
            if (typing.isDynamic()) {
                return TypeCasting.m116to(target);
            }
            return StackManipulation.Illegal.INSTANCE;
        }
    }
}
