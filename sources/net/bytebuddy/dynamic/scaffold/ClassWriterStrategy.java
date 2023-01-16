package net.bytebuddy.dynamic.scaffold;

import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.jar.asm.ClassReader;
import net.bytebuddy.jar.asm.ClassWriter;
import net.bytebuddy.pool.TypePool;

/* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/ClassWriterStrategy.class */
public interface ClassWriterStrategy {
    ClassWriter resolve(int i, TypePool typePool);

    ClassWriter resolve(int i, TypePool typePool, ClassReader classReader);

    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/ClassWriterStrategy$Default.class */
    public enum Default implements ClassWriterStrategy {
        CONSTANT_POOL_RETAINING {
            @Override // net.bytebuddy.dynamic.scaffold.ClassWriterStrategy
            public ClassWriter resolve(int flags, TypePool typePool, ClassReader classReader) {
                return new FrameComputingClassWriter(classReader, flags, typePool);
            }
        },
        CONSTANT_POOL_DISCARDING {
            @Override // net.bytebuddy.dynamic.scaffold.ClassWriterStrategy
            public ClassWriter resolve(int flags, TypePool typePool, ClassReader classReader) {
                return resolve(flags, typePool);
            }
        };

        @Override // net.bytebuddy.dynamic.scaffold.ClassWriterStrategy
        public ClassWriter resolve(int flags, TypePool typePool) {
            return new FrameComputingClassWriter(flags, typePool);
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/ClassWriterStrategy$FrameComputingClassWriter.class */
    public static class FrameComputingClassWriter extends ClassWriter {
        private final TypePool typePool;

        public FrameComputingClassWriter(int flags, TypePool typePool) {
            super(flags);
            this.typePool = typePool;
        }

        public FrameComputingClassWriter(ClassReader classReader, int flags, TypePool typePool) {
            super(classReader, flags);
            this.typePool = typePool;
        }

        @Override // net.bytebuddy.jar.asm.ClassWriter
        protected String getCommonSuperClass(String leftTypeName, String rightTypeName) {
            TypeDescription leftType = this.typePool.describe(leftTypeName.replace('/', '.')).resolve();
            TypeDescription rightType = this.typePool.describe(rightTypeName.replace('/', '.')).resolve();
            if (leftType.isAssignableFrom(rightType)) {
                return leftType.getInternalName();
            }
            if (leftType.isAssignableTo(rightType)) {
                return rightType.getInternalName();
            }
            if (leftType.isInterface() || rightType.isInterface()) {
                return TypeDescription.OBJECT.getInternalName();
            }
            do {
                leftType = leftType.getSuperClass().asErasure();
            } while (!leftType.isAssignableFrom(rightType));
            return leftType.getInternalName();
        }
    }
}
