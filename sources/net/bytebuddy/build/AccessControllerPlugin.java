package net.bytebuddy.build;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import edu.umd.p012cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.util.HashMap;
import java.util.Map;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.modifier.FieldManifestation;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.OpenedClassReader;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/build/AccessControllerPlugin.class */
public class AccessControllerPlugin extends Plugin.ForElementMatcher implements Plugin.Factory {
    private static final String ACCESS_CONTROLLER = "java.security.AccessController";
    private static final String NAME = "ACCESS_CONTROLLER";
    private static final Object[] EMPTY = new Object[0];
    private static final Map<MethodDescription.SignatureToken, MethodDescription.SignatureToken> SIGNATURES = new HashMap();
    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
    private final String property;

    @Target({ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: grasscutter.jar:net/bytebuddy/build/AccessControllerPlugin$Enhance.class */
    public @interface Enhance {
    }

    @Override // net.bytebuddy.build.Plugin.ForElementMatcher, java.lang.Object
    public boolean equals(Object obj) {
        if (!equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.property;
        String str2 = ((AccessControllerPlugin) obj).property;
        return str2 != null ? str != null && str.equals(str2) : str == null;
    }

    @Override // net.bytebuddy.build.Plugin.ForElementMatcher, java.lang.Object
    public int hashCode() {
        int hashCode = hashCode() * 31;
        String str = this.property;
        return str != null ? hashCode + str.hashCode() : hashCode;
    }

    static {
        SIGNATURES.put(new MethodDescription.SignatureToken("doPrivileged", TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(PrivilegedAction.class)), new MethodDescription.SignatureToken("doPrivileged", TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(PrivilegedAction.class)));
        SIGNATURES.put(new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(PrivilegedAction.class)), new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(PrivilegedAction.class)));
        SIGNATURES.put(new MethodDescription.SignatureToken("doPrivileged", TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(PrivilegedAction.class), TypeDescription.OBJECT), new MethodDescription.SignatureToken("doPrivileged", TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(PrivilegedAction.class), JavaType.ACCESS_CONTROL_CONTEXT.getTypeStub()));
        SIGNATURES.put(new MethodDescription.SignatureToken("doPrivileged", TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(PrivilegedAction.class), TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(Permission[].class)), new MethodDescription.SignatureToken("doPrivileged", TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(PrivilegedAction.class), JavaType.ACCESS_CONTROL_CONTEXT.getTypeStub(), TypeDescription.ForLoadedType.m247of(Permission[].class)));
        SIGNATURES.put(new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(PrivilegedAction.class), TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(Permission[].class)), new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(PrivilegedAction.class), JavaType.ACCESS_CONTROL_CONTEXT.getTypeStub(), TypeDescription.ForLoadedType.m247of(Permission[].class)));
        SIGNATURES.put(new MethodDescription.SignatureToken("doPrivileged", TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(PrivilegedActionException.class)), new MethodDescription.SignatureToken("doPrivileged", TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(PrivilegedActionException.class)));
        SIGNATURES.put(new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(PrivilegedAction.class)), new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(PrivilegedAction.class)));
        SIGNATURES.put(new MethodDescription.SignatureToken("doPrivileged", TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(PrivilegedActionException.class), TypeDescription.OBJECT), new MethodDescription.SignatureToken("doPrivileged", TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(PrivilegedActionException.class), JavaType.ACCESS_CONTROL_CONTEXT.getTypeStub()));
        SIGNATURES.put(new MethodDescription.SignatureToken("doPrivileged", TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(PrivilegedActionException.class), TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(Permission[].class)), new MethodDescription.SignatureToken("doPrivileged", TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(PrivilegedActionException.class), JavaType.ACCESS_CONTROL_CONTEXT.getTypeStub(), TypeDescription.ForLoadedType.m247of(Permission[].class)));
        SIGNATURES.put(new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(PrivilegedActionException.class), TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(Permission[].class)), new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.OBJECT, TypeDescription.ForLoadedType.m247of(PrivilegedActionException.class), JavaType.ACCESS_CONTROL_CONTEXT.getTypeStub(), TypeDescription.ForLoadedType.m247of(Permission[].class)));
        SIGNATURES.put(new MethodDescription.SignatureToken("getContext", TypeDescription.OBJECT, new TypeDescription[0]), new MethodDescription.SignatureToken("getContext", JavaType.ACCESS_CONTROL_CONTEXT.getTypeStub(), new TypeDescription[0]));
        SIGNATURES.put(new MethodDescription.SignatureToken("checkPermission", TypeDescription.VOID, TypeDescription.ForLoadedType.m247of(Permission.class)), new MethodDescription.SignatureToken("checkPermission", TypeDescription.VOID, TypeDescription.ForLoadedType.m247of(Permission.class)));
    }

    public AccessControllerPlugin() {
        this(null);
    }

    public AccessControllerPlugin(String property) {
        super(ElementMatchers.declaresMethod(ElementMatchers.isAnnotatedWith(Enhance.class)));
        this.property = property;
    }

    @Override // net.bytebuddy.build.Plugin.Factory
    public Plugin make() {
        return this;
    }

    @Override // net.bytebuddy.build.Plugin
    @SuppressFBWarnings(value = {"SBSC_USE_STRINGBUFFER_CONCATENATION"}, justification = "Collision is unlikely and buffer overhead not justified")
    public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        String name = NAME;
        while (!typeDescription.getDeclaredFields().filter(ElementMatchers.named(name)).isEmpty()) {
            name = name + "$";
        }
        return builder.defineField(name, Boolean.TYPE, Visibility.PRIVATE, Ownership.STATIC, FieldManifestation.FINAL).visit(new AsmVisitorWrapper.ForDeclaredMethods().method(ElementMatchers.isAnnotatedWith(Enhance.class), new AccessControlWrapper(name))).initializer(this.property == null ? new Initializer.WithoutProperty(typeDescription, name) : new Initializer.WithProperty(typeDescription, name, this.property));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/build/AccessControllerPlugin$Initializer.class */
    protected static abstract class Initializer implements ByteCodeAppender {
        private final TypeDescription instrumentedType;
        private final String name;

        protected abstract int onAccessController(MethodVisitor methodVisitor);

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.name.equals(((Initializer) obj).name) && this.instrumentedType.equals(((Initializer) obj).instrumentedType);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.instrumentedType.hashCode()) * 31) + this.name.hashCode();
        }

        protected Initializer(TypeDescription instrumentedType, String name) {
            this.instrumentedType = instrumentedType;
            this.name = name;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext, MethodDescription instrumentedMethod) {
            Label start = new Label();
            Label end = new Label();
            Label classNotFound = new Label();
            Label securityException = new Label();
            Label complete = new Label();
            methodVisitor.visitTryCatchBlock(start, end, classNotFound, Type.getInternalName(ClassNotFoundException.class));
            methodVisitor.visitTryCatchBlock(start, end, securityException, Type.getInternalName(SecurityException.class));
            methodVisitor.visitLabel(start);
            methodVisitor.visitLdcInsn(AccessControllerPlugin.ACCESS_CONTROLLER);
            methodVisitor.visitInsn(3);
            methodVisitor.visitInsn(1);
            methodVisitor.visitMethodInsn(184, Type.getInternalName(Class.class), "forName", Type.getMethodDescriptor(Type.getType(Class.class), Type.getType(String.class), Type.getType(Boolean.TYPE), Type.getType(ClassLoader.class)), false);
            methodVisitor.visitInsn(87);
            int size = onAccessController(methodVisitor);
            methodVisitor.visitFieldInsn(179, this.instrumentedType.getInternalName(), this.name, Type.getDescriptor(Boolean.TYPE));
            methodVisitor.visitLabel(end);
            methodVisitor.visitJumpInsn(167, complete);
            methodVisitor.visitLabel(classNotFound);
            if (implementationContext.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V6)) {
                methodVisitor.visitFrame(4, AccessControllerPlugin.EMPTY.length, AccessControllerPlugin.EMPTY, 1, new Object[]{Type.getInternalName(ClassNotFoundException.class)});
            }
            methodVisitor.visitInsn(87);
            methodVisitor.visitInsn(3);
            methodVisitor.visitFieldInsn(179, this.instrumentedType.getInternalName(), this.name, Type.getDescriptor(Boolean.TYPE));
            methodVisitor.visitJumpInsn(167, complete);
            methodVisitor.visitLabel(securityException);
            if (implementationContext.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V6)) {
                methodVisitor.visitFrame(4, AccessControllerPlugin.EMPTY.length, AccessControllerPlugin.EMPTY, 1, new Object[]{Type.getInternalName(SecurityException.class)});
            }
            methodVisitor.visitInsn(87);
            methodVisitor.visitInsn(4);
            methodVisitor.visitFieldInsn(179, this.instrumentedType.getInternalName(), this.name, Type.getDescriptor(Boolean.TYPE));
            methodVisitor.visitLabel(complete);
            if (implementationContext.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V6)) {
                methodVisitor.visitFrame(3, AccessControllerPlugin.EMPTY.length, AccessControllerPlugin.EMPTY, AccessControllerPlugin.EMPTY.length, AccessControllerPlugin.EMPTY);
            }
            return new ByteCodeAppender.Size(Math.max(3, size), 0);
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/build/AccessControllerPlugin$Initializer$WithProperty.class */
        protected static class WithProperty extends Initializer {
            private final String property;

            @Override // net.bytebuddy.build.AccessControllerPlugin.Initializer
            public boolean equals(Object obj) {
                if (!equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.property.equals(((WithProperty) obj).property);
            }

            @Override // net.bytebuddy.build.AccessControllerPlugin.Initializer
            public int hashCode() {
                return (hashCode() * 31) + this.property.hashCode();
            }

            protected WithProperty(TypeDescription instrumentedType, String name, String property) {
                super(instrumentedType, name);
                this.property = property;
            }

            @Override // net.bytebuddy.build.AccessControllerPlugin.Initializer
            protected int onAccessController(MethodVisitor methodVisitor) {
                methodVisitor.visitLdcInsn(this.property);
                methodVisitor.visitLdcInsn(C3P0Substitutions.DEBUG);
                methodVisitor.visitMethodInsn(184, Type.getInternalName(System.class), "getProperty", Type.getMethodDescriptor(Type.getType(String.class), Type.getType(String.class), Type.getType(String.class)), false);
                methodVisitor.visitMethodInsn(184, Type.getInternalName(Boolean.class), "parseBoolean", Type.getMethodDescriptor(Type.getType(Boolean.TYPE), Type.getType(String.class)), false);
                return 2;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/build/AccessControllerPlugin$Initializer$WithoutProperty.class */
        protected static class WithoutProperty extends Initializer {
            @Override // net.bytebuddy.build.AccessControllerPlugin.Initializer
            public boolean equals(Object obj) {
                if (!equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass();
            }

            @Override // net.bytebuddy.build.AccessControllerPlugin.Initializer
            public int hashCode() {
                return hashCode();
            }

            protected WithoutProperty(TypeDescription instrumentedType, String name) {
                super(instrumentedType, name);
            }

            @Override // net.bytebuddy.build.AccessControllerPlugin.Initializer
            protected int onAccessController(MethodVisitor methodVisitor) {
                methodVisitor.visitInsn(4);
                return 1;
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/build/AccessControllerPlugin$AccessControlWrapper.class */
    protected static class AccessControlWrapper implements AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper {
        private final String name;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.name.equals(((AccessControlWrapper) obj).name);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.name.hashCode();
        }

        protected AccessControlWrapper(String name) {
            this.name = name;
        }

        @Override // net.bytebuddy.asm.AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper
        public MethodVisitor wrap(TypeDescription instrumentedType, MethodDescription instrumentedMethod, MethodVisitor methodVisitor, Implementation.Context implementationContext, TypePool typePool, int writerFlags, int readerFlags) {
            MethodDescription.SignatureToken token = (MethodDescription.SignatureToken) AccessControllerPlugin.SIGNATURES.get(instrumentedMethod.asDefined().asSignatureToken());
            if (token == null) {
                throw new IllegalStateException(instrumentedMethod + " does not have a method with a matching signature in " + AccessControllerPlugin.ACCESS_CONTROLLER);
            } else if (instrumentedMethod.isPublic() || instrumentedMethod.isProtected()) {
                throw new IllegalStateException(instrumentedMethod + " is either public or protected what is not permitted to avoid context leaks");
            } else {
                return new PrefixingMethodVisitor(methodVisitor, instrumentedType, token, this.name, instrumentedMethod.isStatic() ? 0 : 1, (writerFlags & 2) == 0 && implementationContext.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V6));
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/build/AccessControllerPlugin$AccessControlWrapper$PrefixingMethodVisitor.class */
        protected static class PrefixingMethodVisitor extends MethodVisitor {
            private final TypeDescription instrumentedType;
            private final MethodDescription.SignatureToken token;
            private final String name;
            private final int offset;
            private final boolean frames;

            protected PrefixingMethodVisitor(MethodVisitor methodVisitor, TypeDescription instrumentedType, MethodDescription.SignatureToken token, String name, int offset, boolean frames) {
                super(OpenedClassReader.ASM_API, methodVisitor);
                this.instrumentedType = instrumentedType;
                this.token = token;
                this.name = name;
                this.offset = offset;
                this.frames = frames;
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            public void visitCode() {
                this.f3068mv.visitCode();
                this.f3068mv.visitFieldInsn(178, this.instrumentedType.getInternalName(), this.name, Type.getDescriptor(Boolean.TYPE));
                Label label = new Label();
                this.f3068mv.visitJumpInsn(153, label);
                int offset = this.offset;
                for (TypeDescription typeDescription : this.token.getParameterTypes()) {
                    this.f3068mv.visitVarInsn(Type.getType(typeDescription.getDescriptor()).getOpcode(21), offset);
                    if (typeDescription.equals(JavaType.ACCESS_CONTROL_CONTEXT.getTypeStub())) {
                        this.f3068mv.visitTypeInsn(192, typeDescription.getInternalName());
                    }
                    offset += typeDescription.getStackSize().getSize();
                }
                this.f3068mv.visitMethodInsn(184, AccessControllerPlugin.ACCESS_CONTROLLER.replace('.', '/'), this.token.getName(), this.token.getDescriptor(), false);
                this.f3068mv.visitInsn(Type.getType(this.token.getReturnType().getDescriptor()).getOpcode(172));
                this.f3068mv.visitLabel(label);
                if (this.frames) {
                    this.f3068mv.visitFrame(3, AccessControllerPlugin.EMPTY.length, AccessControllerPlugin.EMPTY, AccessControllerPlugin.EMPTY.length, AccessControllerPlugin.EMPTY);
                }
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            public void visitMaxs(int stackSize, int localVariableLength) {
                this.f3068mv.visitMaxs(Math.max(Math.max(StackSize.m121of(this.token.getParameterTypes()), this.token.getReturnType().getStackSize().getSize()), stackSize), localVariableLength);
            }
        }
    }
}
