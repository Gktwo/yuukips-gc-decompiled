package net.bytebuddy.implementation.bytecode.assign;

import edu.umd.p012cs.findbugs.annotations.SuppressFBWarnings;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveTypeAwareAssigner;
import net.bytebuddy.implementation.bytecode.assign.primitive.VoidAwareAssigner;
import net.bytebuddy.implementation.bytecode.assign.reference.GenericTypeAwareAssigner;
import net.bytebuddy.implementation.bytecode.assign.reference.ReferenceTypeAwareAssigner;

@SuppressFBWarnings(value = {"IC_SUPERCLASS_USES_SUBCLASS_DURING_INITIALIZATION"}, justification = "Safe initialization is implied")
/* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/assign/Assigner.class */
public interface Assigner {
    public static final Assigner DEFAULT = new VoidAwareAssigner(new PrimitiveTypeAwareAssigner(ReferenceTypeAwareAssigner.INSTANCE));
    public static final Assigner GENERICS_AWARE = new VoidAwareAssigner(new PrimitiveTypeAwareAssigner(GenericTypeAwareAssigner.INSTANCE));

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/assign/Assigner$EqualTypesOnly.class */
    public enum EqualTypesOnly implements Assigner {
        GENERIC {
            @Override // net.bytebuddy.implementation.bytecode.assign.Assigner
            public StackManipulation assign(TypeDescription.Generic source, TypeDescription.Generic target, Typing typing) {
                return source.equals(target) ? StackManipulation.Trivial.INSTANCE : StackManipulation.Illegal.INSTANCE;
            }
        },
        ERASURE {
            @Override // net.bytebuddy.implementation.bytecode.assign.Assigner
            public StackManipulation assign(TypeDescription.Generic source, TypeDescription.Generic target, Typing typing) {
                return source.asErasure().equals(target.asErasure()) ? StackManipulation.Trivial.INSTANCE : StackManipulation.Illegal.INSTANCE;
            }
        }
    }

    StackManipulation assign(TypeDescription.Generic generic, TypeDescription.Generic generic2, Typing typing);

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/assign/Assigner$Typing.class */
    public enum Typing {
        STATIC(false),
        DYNAMIC(true);
        
        private final boolean dynamic;

        Typing(boolean dynamic) {
            this.dynamic = dynamic;
        }

        /* renamed from: of */
        public static Typing m118of(boolean dynamic) {
            return dynamic ? DYNAMIC : STATIC;
        }

        public boolean isDynamic() {
            return this.dynamic;
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/bytecode/assign/Assigner$Refusing.class */
    public enum Refusing implements Assigner {
        INSTANCE;

        @Override // net.bytebuddy.implementation.bytecode.assign.Assigner
        public StackManipulation assign(TypeDescription.Generic source, TypeDescription.Generic target, Typing typing) {
            return StackManipulation.Illegal.INSTANCE;
        }
    }
}
