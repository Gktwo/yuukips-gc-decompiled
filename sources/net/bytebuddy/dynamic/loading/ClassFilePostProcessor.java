package net.bytebuddy.dynamic.loading;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;

/* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassFilePostProcessor.class */
public interface ClassFilePostProcessor {
    byte[] transform(ClassLoader classLoader, String str, ProtectionDomain protectionDomain, byte[] bArr);

    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassFilePostProcessor$NoOp.class */
    public enum NoOp implements ClassFilePostProcessor {
        INSTANCE;

        @Override // net.bytebuddy.dynamic.loading.ClassFilePostProcessor
        public byte[] transform(ClassLoader classLoader, String name, ProtectionDomain protectionDomain, byte[] binaryRepresentation) {
            return binaryRepresentation;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassFilePostProcessor$ForClassFileTransformer.class */
    public static class ForClassFileTransformer implements ClassFilePostProcessor {
        private static final Class<?> UNLOADED_TYPE = null;
        private final ClassFileTransformer classFileTransformer;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.classFileTransformer.equals(((ForClassFileTransformer) obj).classFileTransformer);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.classFileTransformer.hashCode();
        }

        public ForClassFileTransformer(ClassFileTransformer classFileTransformer) {
            this.classFileTransformer = classFileTransformer;
        }

        @Override // net.bytebuddy.dynamic.loading.ClassFilePostProcessor
        public byte[] transform(ClassLoader classLoader, String name, ProtectionDomain protectionDomain, byte[] binaryRepresentation) {
            try {
                byte[] transformed = this.classFileTransformer.transform(classLoader, name.replace('.', '/'), UNLOADED_TYPE, protectionDomain, binaryRepresentation);
                return transformed == null ? binaryRepresentation : transformed;
            } catch (IllegalClassFormatException exception) {
                throw new IllegalStateException("Failed to transform " + name, exception);
            }
        }
    }
}
