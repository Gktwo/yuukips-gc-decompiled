package net.bytebuddy.implementation;

import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import org.jline.console.Printer;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/implementation/ToStringMethod.class */
public class ToStringMethod implements Implementation {
    private static final MethodDescription.InDefinedShape STRING_BUILDER_CONSTRUCTOR = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.m247of(StringBuilder.class).getDeclaredMethods().filter(ElementMatchers.isConstructor().and(ElementMatchers.takesArguments(String.class))).getOnly();
    private static final MethodDescription.InDefinedShape TO_STRING = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.m247of(StringBuilder.class).getDeclaredMethods().filter(ElementMatchers.isToString()).getOnly();
    private final PrefixResolver prefixResolver;
    private final String start;
    private final String end;
    private final String separator;
    private final String definer;
    private final ElementMatcher.Junction<? super FieldDescription.InDefinedShape> ignored;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.start.equals(((ToStringMethod) obj).start) && this.end.equals(((ToStringMethod) obj).end) && this.separator.equals(((ToStringMethod) obj).separator) && this.definer.equals(((ToStringMethod) obj).definer) && this.prefixResolver.equals(((ToStringMethod) obj).prefixResolver) && this.ignored.equals(((ToStringMethod) obj).ignored);
    }

    public int hashCode() {
        return (((((((((((getClass().hashCode() * 31) + this.prefixResolver.hashCode()) * 31) + this.start.hashCode()) * 31) + this.end.hashCode()) * 31) + this.separator.hashCode()) * 31) + this.definer.hashCode()) * 31) + this.ignored.hashCode();
    }

    protected ToStringMethod(PrefixResolver prefixResolver) {
        this(prefixResolver, "{", "}", ", ", "=", ElementMatchers.none());
    }

    private ToStringMethod(PrefixResolver prefixResolver, String start, String end, String separator, String definer, ElementMatcher.Junction<? super FieldDescription.InDefinedShape> ignored) {
        this.prefixResolver = prefixResolver;
        this.start = start;
        this.end = end;
        this.separator = separator;
        this.definer = definer;
        this.ignored = ignored;
    }

    public static ToStringMethod prefixedByFullyQualifiedClassName() {
        return prefixedBy(PrefixResolver.Default.FULLY_QUALIFIED_CLASS_NAME);
    }

    public static ToStringMethod prefixedByCanonicalClassName() {
        return prefixedBy(PrefixResolver.Default.CANONICAL_CLASS_NAME);
    }

    public static ToStringMethod prefixedBySimpleClassName() {
        return prefixedBy(PrefixResolver.Default.SIMPLE_CLASS_NAME);
    }

    public static ToStringMethod prefixedBy(String prefix) {
        if (prefix != null) {
            return prefixedBy(new PrefixResolver.ForFixedValue(prefix));
        }
        throw new IllegalArgumentException("Prefix cannot be null");
    }

    public static ToStringMethod prefixedBy(PrefixResolver prefixResolver) {
        return new ToStringMethod(prefixResolver);
    }

    public ToStringMethod withIgnoredFields(ElementMatcher<? super FieldDescription.InDefinedShape> ignored) {
        return new ToStringMethod(this.prefixResolver, this.start, this.end, this.separator, this.definer, this.ignored.mo105or(ignored));
    }

    public Implementation withTokens(String start, String end, String separator, String definer) {
        if (start != null && end != null && separator != null && definer != null) {
            return new ToStringMethod(this.prefixResolver, start, end, separator, definer, this.ignored);
        }
        throw new IllegalArgumentException("Token values cannot be null");
    }

    @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
    public InstrumentedType prepare(InstrumentedType instrumentedType) {
        return instrumentedType;
    }

    @Override // net.bytebuddy.implementation.Implementation
    public Appender appender(Implementation.Target implementationTarget) {
        if (implementationTarget.getInstrumentedType().isInterface()) {
            throw new IllegalStateException("Cannot implement meaningful toString method for " + implementationTarget.getInstrumentedType());
        }
        String prefix = this.prefixResolver.resolve(implementationTarget.getInstrumentedType());
        if (prefix != null) {
            return new Appender(prefix, this.start, this.end, this.separator, this.definer, implementationTarget.getInstrumentedType().getDeclaredFields().filter(ElementMatchers.not(ElementMatchers.isStatic().mo105or(this.ignored))));
        }
        throw new IllegalStateException("Prefix for toString method cannot be null");
    }

    /* access modifiers changed from: protected */
    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/ToStringMethod$Appender.class */
    public static class Appender implements ByteCodeAppender {
        private final String prefix;
        private final String start;
        private final String end;
        private final String separator;
        private final String definer;
        private final List<? extends FieldDescription.InDefinedShape> fieldDescriptions;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.prefix.equals(((Appender) obj).prefix) && this.start.equals(((Appender) obj).start) && this.end.equals(((Appender) obj).end) && this.separator.equals(((Appender) obj).separator) && this.definer.equals(((Appender) obj).definer) && this.fieldDescriptions.equals(((Appender) obj).fieldDescriptions);
        }

        public int hashCode() {
            return (((((((((((getClass().hashCode() * 31) + this.prefix.hashCode()) * 31) + this.start.hashCode()) * 31) + this.end.hashCode()) * 31) + this.separator.hashCode()) * 31) + this.definer.hashCode()) * 31) + this.fieldDescriptions.hashCode();
        }

        protected Appender(String prefix, String start, String end, String separator, String definer, List<? extends FieldDescription.InDefinedShape> fieldDescriptions) {
            this.prefix = prefix;
            this.start = start;
            this.end = end;
            this.separator = separator;
            this.definer = definer;
            this.fieldDescriptions = fieldDescriptions;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext, MethodDescription instrumentedMethod) {
            if (instrumentedMethod.isStatic()) {
                throw new IllegalStateException("toString method must not be static: " + instrumentedMethod);
            } else if (!instrumentedMethod.getReturnType().asErasure().isAssignableFrom(String.class)) {
                throw new IllegalStateException("toString method does not return String-compatible type: " + instrumentedMethod);
            } else {
                List<StackManipulation> stackManipulations = new ArrayList<>(Math.max(0, (this.fieldDescriptions.size() * 7) - 2) + 10);
                stackManipulations.add(TypeCreation.m119of(TypeDescription.ForLoadedType.m247of(StringBuilder.class)));
                stackManipulations.add(Duplication.SINGLE);
                stackManipulations.add(new TextConstant(this.prefix));
                stackManipulations.add(MethodInvocation.invoke(ToStringMethod.STRING_BUILDER_CONSTRUCTOR));
                stackManipulations.add(new TextConstant(this.start));
                stackManipulations.add(ValueConsumer.STRING);
                boolean first = true;
                for (FieldDescription.InDefinedShape fieldDescription : this.fieldDescriptions) {
                    if (first) {
                        first = false;
                    } else {
                        stackManipulations.add(new TextConstant(this.separator));
                        stackManipulations.add(ValueConsumer.STRING);
                    }
                    stackManipulations.add(new TextConstant(fieldDescription.getName() + this.definer));
                    stackManipulations.add(ValueConsumer.STRING);
                    stackManipulations.add(MethodVariableAccess.loadThis());
                    stackManipulations.add(FieldAccess.forField(fieldDescription).read());
                    stackManipulations.add(ValueConsumer.m140of(fieldDescription.getType().asErasure()));
                }
                stackManipulations.add(new TextConstant(this.end));
                stackManipulations.add(ValueConsumer.STRING);
                stackManipulations.add(MethodInvocation.invoke(ToStringMethod.TO_STRING));
                stackManipulations.add(MethodReturn.REFERENCE);
                return new ByteCodeAppender.Size(new StackManipulation.Compound(stackManipulations).apply(methodVisitor, implementationContext).getMaximalSize(), instrumentedMethod.getStackSize());
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/ToStringMethod$PrefixResolver.class */
    public interface PrefixResolver {

        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/ToStringMethod$PrefixResolver$Default.class */
        public enum Default implements PrefixResolver {
            FULLY_QUALIFIED_CLASS_NAME {
                @Override // net.bytebuddy.implementation.ToStringMethod.PrefixResolver
                public String resolve(TypeDescription instrumentedType) {
                    return instrumentedType.getName();
                }
            },
            CANONICAL_CLASS_NAME {
                @Override // net.bytebuddy.implementation.ToStringMethod.PrefixResolver
                public String resolve(TypeDescription instrumentedType) {
                    return instrumentedType.getCanonicalName();
                }
            },
            SIMPLE_CLASS_NAME {
                @Override // net.bytebuddy.implementation.ToStringMethod.PrefixResolver
                public String resolve(TypeDescription instrumentedType) {
                    return instrumentedType.getSimpleName();
                }
            }
        }

        String resolve(TypeDescription typeDescription);

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/implementation/ToStringMethod$PrefixResolver$ForFixedValue.class */
        public static class ForFixedValue implements PrefixResolver {
            private final String prefix;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.prefix.equals(((ForFixedValue) obj).prefix);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.prefix.hashCode();
            }

            protected ForFixedValue(String prefix) {
                this.prefix = prefix;
            }

            @Override // net.bytebuddy.implementation.ToStringMethod.PrefixResolver
            public String resolve(TypeDescription instrumentedType) {
                return this.prefix;
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/implementation/ToStringMethod$ValueConsumer.class */
    protected enum ValueConsumer implements StackManipulation {
        BOOLEAN {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Z)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        CHARACTER {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(C)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        INTEGER {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        LONG {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(J)Ljava/lang/StringBuilder;", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        FLOAT {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(F)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        DOUBLE {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(D)Ljava/lang/StringBuilder;", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        STRING {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        CHARACTER_SEQUENCE {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        OBJECT {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/Object;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        BOOLEAN_ARRAY {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", Printer.TO_STRING, "([Z)Ljava/lang/String;", false);
                methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        BYTE_ARRAY {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", Printer.TO_STRING, "([B)Ljava/lang/String;", false);
                methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        SHORT_ARRAY {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", Printer.TO_STRING, "([S)Ljava/lang/String;", false);
                methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        CHARACTER_ARRAY {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", Printer.TO_STRING, "([C)Ljava/lang/String;", false);
                methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        INTEGER_ARRAY {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", Printer.TO_STRING, "([I)Ljava/lang/String;", false);
                methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        LONG_ARRAY {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", Printer.TO_STRING, "([J)Ljava/lang/String;", false);
                methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        FLOAT_ARRAY {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", Printer.TO_STRING, "([F)Ljava/lang/String;", false);
                methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        DOUBLE_ARRAY {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", Printer.TO_STRING, "([D)Ljava/lang/String;", false);
                methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        REFERENCE_ARRAY {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", Printer.TO_STRING, "([Ljava/lang/Object;)Ljava/lang/String;", false);
                methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        },
        NESTED_ARRAY {
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "deepToString", "([Ljava/lang/Object;)Ljava/lang/String;", false);
                methodVisitor.visitMethodInsn(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                return StackManipulation.Size.ZERO;
            }
        };

        /* renamed from: of */
        protected static StackManipulation m140of(TypeDescription typeDescription) {
            if (typeDescription.represents(Boolean.TYPE)) {
                return BOOLEAN;
            }
            if (typeDescription.represents(Character.TYPE)) {
                return CHARACTER;
            }
            if (typeDescription.represents(Byte.TYPE) || typeDescription.represents(Short.TYPE) || typeDescription.represents(Integer.TYPE)) {
                return INTEGER;
            }
            if (typeDescription.represents(Long.TYPE)) {
                return LONG;
            }
            if (typeDescription.represents(Float.TYPE)) {
                return FLOAT;
            }
            if (typeDescription.represents(Double.TYPE)) {
                return DOUBLE;
            }
            if (typeDescription.represents(String.class)) {
                return STRING;
            }
            if (typeDescription.isAssignableTo(CharSequence.class)) {
                return CHARACTER_SEQUENCE;
            }
            if (typeDescription.represents(boolean[].class)) {
                return BOOLEAN_ARRAY;
            }
            if (typeDescription.represents(byte[].class)) {
                return BYTE_ARRAY;
            }
            if (typeDescription.represents(short[].class)) {
                return SHORT_ARRAY;
            }
            if (typeDescription.represents(char[].class)) {
                return CHARACTER_ARRAY;
            }
            if (typeDescription.represents(int[].class)) {
                return INTEGER_ARRAY;
            }
            if (typeDescription.represents(long[].class)) {
                return LONG_ARRAY;
            }
            if (typeDescription.represents(float[].class)) {
                return FLOAT_ARRAY;
            }
            if (typeDescription.represents(double[].class)) {
                return DOUBLE_ARRAY;
            }
            if (typeDescription.isArray()) {
                return typeDescription.getComponentType().isArray() ? NESTED_ARRAY : REFERENCE_ARRAY;
            }
            return OBJECT;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return true;
        }
    }
}
