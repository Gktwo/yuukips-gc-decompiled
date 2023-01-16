package net.bytebuddy.implementation;

import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.Addition;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Multiplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/implementation/HashCodeMethod.class */
public class HashCodeMethod implements Implementation {
    private static final int DEFAULT_OFFSET = 17;
    private static final int DEFAULT_MULTIPLIER = 31;
    private static final MethodDescription.InDefinedShape HASH_CODE = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.m247of(Object.class).getDeclaredMethods().filter(ElementMatchers.isHashCode()).getOnly();
    private static final MethodDescription.InDefinedShape GET_CLASS = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.m247of(Object.class).getDeclaredMethods().filter(ElementMatchers.named("getClass").and(ElementMatchers.takesArguments(0))).getOnly();
    private final OffsetProvider offsetProvider;
    private final int multiplier;
    private final ElementMatcher.Junction<? super FieldDescription.InDefinedShape> ignored;
    private final ElementMatcher.Junction<? super FieldDescription.InDefinedShape> nonNullable;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.multiplier == ((HashCodeMethod) obj).multiplier && this.offsetProvider.equals(((HashCodeMethod) obj).offsetProvider) && this.ignored.equals(((HashCodeMethod) obj).ignored) && this.nonNullable.equals(((HashCodeMethod) obj).nonNullable);
    }

    public int hashCode() {
        return (((((((getClass().hashCode() * 31) + this.offsetProvider.hashCode()) * 31) + this.multiplier) * 31) + this.ignored.hashCode()) * 31) + this.nonNullable.hashCode();
    }

    protected HashCodeMethod(OffsetProvider offsetProvider) {
        this(offsetProvider, 31, ElementMatchers.none(), ElementMatchers.none());
    }

    private HashCodeMethod(OffsetProvider offsetProvider, int multiplier, ElementMatcher.Junction<? super FieldDescription.InDefinedShape> ignored, ElementMatcher.Junction<? super FieldDescription.InDefinedShape> nonNullable) {
        this.offsetProvider = offsetProvider;
        this.multiplier = multiplier;
        this.ignored = ignored;
        this.nonNullable = nonNullable;
    }

    public static HashCodeMethod usingSuperClassOffset() {
        return new HashCodeMethod(OffsetProvider.ForSuperMethodCall.INSTANCE);
    }

    public static HashCodeMethod usingTypeHashOffset(boolean dynamic) {
        return new HashCodeMethod(dynamic ? OffsetProvider.ForDynamicTypeHash.INSTANCE : OffsetProvider.ForStaticTypeHash.INSTANCE);
    }

    public static HashCodeMethod usingDefaultOffset() {
        return usingOffset(17);
    }

    public static HashCodeMethod usingOffset(int value) {
        return new HashCodeMethod(new OffsetProvider.ForFixedValue(value));
    }

    public HashCodeMethod withIgnoredFields(ElementMatcher<? super FieldDescription.InDefinedShape> ignored) {
        return new HashCodeMethod(this.offsetProvider, this.multiplier, this.ignored.mo105or(ignored), this.nonNullable);
    }

    public HashCodeMethod withNonNullableFields(ElementMatcher<? super FieldDescription.InDefinedShape> nonNullable) {
        return new HashCodeMethod(this.offsetProvider, this.multiplier, this.ignored, this.nonNullable.mo105or(nonNullable));
    }

    public Implementation withMultiplier(int multiplier) {
        if (multiplier != 0) {
            return new HashCodeMethod(this.offsetProvider, multiplier, this.ignored, this.nonNullable);
        }
        throw new IllegalArgumentException("Hash code multiplier must not be zero");
    }

    @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
    public InstrumentedType prepare(InstrumentedType instrumentedType) {
        return instrumentedType;
    }

    @Override // net.bytebuddy.implementation.Implementation
    public ByteCodeAppender appender(Implementation.Target implementationTarget) {
        if (!implementationTarget.getInstrumentedType().isInterface()) {
            return new Appender(this.offsetProvider.resolve(implementationTarget.getInstrumentedType()), this.multiplier, implementationTarget.getInstrumentedType().getDeclaredFields().filter(ElementMatchers.not(ElementMatchers.isStatic().mo105or(this.ignored))), this.nonNullable);
        }
        throw new IllegalStateException("Cannot implement meaningful hash code method for " + implementationTarget.getInstrumentedType());
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/HashCodeMethod$OffsetProvider.class */
    public interface OffsetProvider {
        StackManipulation resolve(TypeDescription typeDescription);

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/HashCodeMethod$OffsetProvider$ForFixedValue.class */
        public static class ForFixedValue implements OffsetProvider {
            private final int value;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.value == ((ForFixedValue) obj).value;
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.value;
            }

            protected ForFixedValue(int value) {
                this.value = value;
            }

            @Override // net.bytebuddy.implementation.HashCodeMethod.OffsetProvider
            public StackManipulation resolve(TypeDescription instrumentedType) {
                return IntegerConstant.forValue(this.value);
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/HashCodeMethod$OffsetProvider$ForSuperMethodCall.class */
        public enum ForSuperMethodCall implements OffsetProvider {
            INSTANCE;

            @Override // net.bytebuddy.implementation.HashCodeMethod.OffsetProvider
            public StackManipulation resolve(TypeDescription instrumentedType) {
                TypeDefinition superClass = instrumentedType.getSuperClass();
                if (superClass != null) {
                    return new StackManipulation.Compound(MethodVariableAccess.loadThis(), MethodInvocation.invoke(HashCodeMethod.HASH_CODE).special(superClass.asErasure()));
                }
                throw new IllegalStateException(instrumentedType + " does not declare a super class");
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/HashCodeMethod$OffsetProvider$ForStaticTypeHash.class */
        public enum ForStaticTypeHash implements OffsetProvider {
            INSTANCE;

            @Override // net.bytebuddy.implementation.HashCodeMethod.OffsetProvider
            public StackManipulation resolve(TypeDescription instrumentedType) {
                return new StackManipulation.Compound(ClassConstant.m114of(instrumentedType), MethodInvocation.invoke(HashCodeMethod.HASH_CODE).virtual(TypeDescription.CLASS));
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/HashCodeMethod$OffsetProvider$ForDynamicTypeHash.class */
        public enum ForDynamicTypeHash implements OffsetProvider {
            INSTANCE;

            @Override // net.bytebuddy.implementation.HashCodeMethod.OffsetProvider
            public StackManipulation resolve(TypeDescription instrumentedType) {
                return new StackManipulation.Compound(MethodVariableAccess.loadThis(), MethodInvocation.invoke(HashCodeMethod.GET_CLASS).virtual(instrumentedType), MethodInvocation.invoke(HashCodeMethod.HASH_CODE).virtual(TypeDescription.CLASS));
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/HashCodeMethod$NullValueGuard.class */
    protected interface NullValueGuard {
        StackManipulation before();

        StackManipulation after();

        int getRequiredVariablePadding();

        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/HashCodeMethod$NullValueGuard$NoOp.class */
        public enum NoOp implements NullValueGuard {
            INSTANCE;

            @Override // net.bytebuddy.implementation.HashCodeMethod.NullValueGuard
            public StackManipulation before() {
                return StackManipulation.Trivial.INSTANCE;
            }

            @Override // net.bytebuddy.implementation.HashCodeMethod.NullValueGuard
            public StackManipulation after() {
                return StackManipulation.Trivial.INSTANCE;
            }

            @Override // net.bytebuddy.implementation.HashCodeMethod.NullValueGuard
            public int getRequiredVariablePadding() {
                return StackSize.ZERO.getSize();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/HashCodeMethod$NullValueGuard$UsingJump.class */
        public static class UsingJump implements NullValueGuard {
            private static final Object[] EMPTY = new Object[0];
            private static final Object[] INTEGER = {Opcodes.INTEGER};
            private final MethodDescription instrumentedMethod;
            private final Label label = new Label();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.instrumentedMethod.equals(((UsingJump) obj).instrumentedMethod) && this.label.equals(((UsingJump) obj).label);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.instrumentedMethod.hashCode()) * 31) + this.label.hashCode();
            }

            protected UsingJump(MethodDescription instrumentedMethod) {
                this.instrumentedMethod = instrumentedMethod;
            }

            @Override // net.bytebuddy.implementation.HashCodeMethod.NullValueGuard
            public StackManipulation before() {
                return new BeforeInstruction();
            }

            @Override // net.bytebuddy.implementation.HashCodeMethod.NullValueGuard
            public StackManipulation after() {
                return new AfterInstruction();
            }

            @Override // net.bytebuddy.implementation.HashCodeMethod.NullValueGuard
            public int getRequiredVariablePadding() {
                return 1;
            }

            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            /* loaded from: grasscutter.jar:net/bytebuddy/implementation/HashCodeMethod$NullValueGuard$UsingJump$BeforeInstruction.class */
            protected class BeforeInstruction implements StackManipulation {
                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && UsingJump.this.equals(UsingJump.this);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + UsingJump.this.hashCode();
                }

                protected BeforeInstruction() {
                }

                @Override // net.bytebuddy.implementation.bytecode.StackManipulation
                public boolean isValid() {
                    return true;
                }

                @Override // net.bytebuddy.implementation.bytecode.StackManipulation
                public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                    methodVisitor.visitVarInsn(58, UsingJump.this.instrumentedMethod.getStackSize());
                    methodVisitor.visitVarInsn(25, UsingJump.this.instrumentedMethod.getStackSize());
                    methodVisitor.visitJumpInsn(198, UsingJump.this.label);
                    methodVisitor.visitVarInsn(25, UsingJump.this.instrumentedMethod.getStackSize());
                    return StackManipulation.Size.ZERO;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            /* loaded from: grasscutter.jar:net/bytebuddy/implementation/HashCodeMethod$NullValueGuard$UsingJump$AfterInstruction.class */
            protected class AfterInstruction implements StackManipulation {
                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && UsingJump.this.equals(UsingJump.this);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + UsingJump.this.hashCode();
                }

                protected AfterInstruction() {
                }

                @Override // net.bytebuddy.implementation.bytecode.StackManipulation
                public boolean isValid() {
                    return true;
                }

                @Override // net.bytebuddy.implementation.bytecode.StackManipulation
                public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                    methodVisitor.visitLabel(UsingJump.this.label);
                    if (implementationContext.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V6)) {
                        methodVisitor.visitFrame(4, UsingJump.EMPTY.length, UsingJump.EMPTY, UsingJump.INTEGER.length, UsingJump.INTEGER);
                    }
                    return StackManipulation.Size.ZERO;
                }
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/HashCodeMethod$ValueTransformer.class */
    protected enum ValueTransformer implements StackManipulation {
        LONG {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitInsn(92);
                methodVisitor.visitIntInsn(16, 32);
                methodVisitor.visitInsn(125);
                methodVisitor.visitInsn(131);
                methodVisitor.visitInsn(136);
                return new StackManipulation.Size(-1, 3);
            }
        },
        FLOAT {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(184, "java/lang/Float", "floatToIntBits", "(F)I", false);
                return StackManipulation.Size.ZERO;
            }
        },
        DOUBLE {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(184, "java/lang/Double", "doubleToLongBits", "(D)J", false);
                methodVisitor.visitInsn(92);
                methodVisitor.visitIntInsn(16, 32);
                methodVisitor.visitInsn(125);
                methodVisitor.visitInsn(131);
                methodVisitor.visitInsn(136);
                return new StackManipulation.Size(-1, 3);
            }
        },
        BOOLEAN_ARRAY {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([Z)I", false);
                return StackManipulation.Size.ZERO;
            }
        },
        BYTE_ARRAY {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([B)I", false);
                return StackManipulation.Size.ZERO;
            }
        },
        SHORT_ARRAY {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([S)I", false);
                return StackManipulation.Size.ZERO;
            }
        },
        CHARACTER_ARRAY {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([C)I", false);
                return StackManipulation.Size.ZERO;
            }
        },
        INTEGER_ARRAY {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([I)I", false);
                return StackManipulation.Size.ZERO;
            }
        },
        LONG_ARRAY {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([J)I", false);
                return StackManipulation.Size.ZERO;
            }
        },
        FLOAT_ARRAY {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([F)I", false);
                return StackManipulation.Size.ZERO;
            }
        },
        DOUBLE_ARRAY {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([D)I", false);
                return StackManipulation.Size.ZERO;
            }
        },
        REFERENCE_ARRAY {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([Ljava/lang/Object;)I", false);
                return StackManipulation.Size.ZERO;
            }
        },
        NESTED_ARRAY {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "deepHashCode", "([Ljava/lang/Object;)I", false);
                return StackManipulation.Size.ZERO;
            }
        };

        /* renamed from: of */
        public static StackManipulation m189of(TypeDefinition typeDefinition) {
            if (typeDefinition.represents(Boolean.TYPE) || typeDefinition.represents(Byte.TYPE) || typeDefinition.represents(Short.TYPE) || typeDefinition.represents(Character.TYPE) || typeDefinition.represents(Integer.TYPE)) {
                return StackManipulation.Trivial.INSTANCE;
            }
            if (typeDefinition.represents(Long.TYPE)) {
                return LONG;
            }
            if (typeDefinition.represents(Float.TYPE)) {
                return FLOAT;
            }
            if (typeDefinition.represents(Double.TYPE)) {
                return DOUBLE;
            }
            if (typeDefinition.represents(boolean[].class)) {
                return BOOLEAN_ARRAY;
            }
            if (typeDefinition.represents(byte[].class)) {
                return BYTE_ARRAY;
            }
            if (typeDefinition.represents(short[].class)) {
                return SHORT_ARRAY;
            }
            if (typeDefinition.represents(char[].class)) {
                return CHARACTER_ARRAY;
            }
            if (typeDefinition.represents(int[].class)) {
                return INTEGER_ARRAY;
            }
            if (typeDefinition.represents(long[].class)) {
                return LONG_ARRAY;
            }
            if (typeDefinition.represents(float[].class)) {
                return FLOAT_ARRAY;
            }
            if (typeDefinition.represents(double[].class)) {
                return DOUBLE_ARRAY;
            }
            if (typeDefinition.isArray()) {
                return typeDefinition.getComponentType().isArray() ? NESTED_ARRAY : REFERENCE_ARRAY;
            }
            return MethodInvocation.invoke(HashCodeMethod.HASH_CODE).virtual(typeDefinition.asErasure());
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return true;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/HashCodeMethod$Appender.class */
    protected static class Appender implements ByteCodeAppender {
        private final StackManipulation initialValue;
        private final int multiplier;
        private final List<FieldDescription.InDefinedShape> fieldDescriptions;
        private final ElementMatcher<? super FieldDescription.InDefinedShape> nonNullable;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.multiplier == ((Appender) obj).multiplier && this.initialValue.equals(((Appender) obj).initialValue) && this.fieldDescriptions.equals(((Appender) obj).fieldDescriptions) && this.nonNullable.equals(((Appender) obj).nonNullable);
        }

        public int hashCode() {
            return (((((((getClass().hashCode() * 31) + this.initialValue.hashCode()) * 31) + this.multiplier) * 31) + this.fieldDescriptions.hashCode()) * 31) + this.nonNullable.hashCode();
        }

        protected Appender(StackManipulation initialValue, int multiplier, List<FieldDescription.InDefinedShape> fieldDescriptions, ElementMatcher<? super FieldDescription.InDefinedShape> nonNullable) {
            this.initialValue = initialValue;
            this.multiplier = multiplier;
            this.fieldDescriptions = fieldDescriptions;
            this.nonNullable = nonNullable;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext, MethodDescription instrumentedMethod) {
            if (instrumentedMethod.isStatic()) {
                throw new IllegalStateException("Hash code method must not be static: " + instrumentedMethod);
            } else if (!instrumentedMethod.getReturnType().represents(Integer.TYPE)) {
                throw new IllegalStateException("Hash code method does not return primitive integer: " + instrumentedMethod);
            } else {
                List<StackManipulation> stackManipulations = new ArrayList<>(2 + (this.fieldDescriptions.size() * 8));
                stackManipulations.add(this.initialValue);
                int padding = 0;
                for (FieldDescription.InDefinedShape fieldDescription : this.fieldDescriptions) {
                    stackManipulations.add(IntegerConstant.forValue(this.multiplier));
                    stackManipulations.add(Multiplication.INTEGER);
                    stackManipulations.add(MethodVariableAccess.loadThis());
                    stackManipulations.add(FieldAccess.forField(fieldDescription).read());
                    NullValueGuard nullValueGuard = (fieldDescription.getType().isPrimitive() || fieldDescription.getType().isArray() || this.nonNullable.matches(fieldDescription)) ? NullValueGuard.NoOp.INSTANCE : new NullValueGuard.UsingJump(instrumentedMethod);
                    stackManipulations.add(nullValueGuard.before());
                    stackManipulations.add(ValueTransformer.m189of(fieldDescription.getType()));
                    stackManipulations.add(Addition.INTEGER);
                    stackManipulations.add(nullValueGuard.after());
                    padding = Math.max(padding, nullValueGuard.getRequiredVariablePadding());
                }
                stackManipulations.add(MethodReturn.INTEGER);
                return new ByteCodeAppender.Size(new StackManipulation.Compound(stackManipulations).apply(methodVisitor, implementationContext).getMaximalSize(), instrumentedMethod.getStackSize() + padding);
            }
        }
    }
}
