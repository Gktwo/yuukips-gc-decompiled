package net.bytebuddy.description.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.annotation.IncompleteAnnotationException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;

/* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue.class */
public interface AnnotationValue<T, S> {
    public static final AnnotationValue<?, ?> UNDEFINED = null;

    State getState();

    Sort getSort();

    AnnotationValue<T, S> filter(MethodDescription.InDefinedShape inDefinedShape);

    AnnotationValue<T, S> filter(MethodDescription.InDefinedShape inDefinedShape, TypeDefinition typeDefinition);

    T resolve();

    <W> W resolve(Class<? extends W> cls);

    Loaded<S> load(ClassLoader classLoader);

    /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$RenderingDispatcher.class */
    public enum RenderingDispatcher {
        LEGACY_VM('[', ']', true) {
            @Override // net.bytebuddy.description.annotation.AnnotationValue.RenderingDispatcher
            public String toSourceString(char value) {
                return Character.toString(value);
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.RenderingDispatcher
            public String toSourceString(long value) {
                return Long.toString(value);
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.RenderingDispatcher
            public String toSourceString(float value) {
                return Float.toString(value);
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.RenderingDispatcher
            public String toSourceString(double value) {
                return Double.toString(value);
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.RenderingDispatcher
            public String toSourceString(String value) {
                return value;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.RenderingDispatcher
            public String toSourceString(TypeDescription value) {
                return value.toString();
            }
        },
        JAVA_9_CAPABLE_VM('{', '}', true) {
            @Override // net.bytebuddy.description.annotation.AnnotationValue.RenderingDispatcher
            public String toSourceString(char value) {
                StringBuilder stringBuilder = new StringBuilder().append('\'');
                if (value == '\'') {
                    stringBuilder.append("\\'");
                } else {
                    stringBuilder.append(value);
                }
                return stringBuilder.append('\'').toString();
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.RenderingDispatcher
            public String toSourceString(long value) {
                return Math.abs(value) <= 2147483647L ? String.valueOf(value) : value + "L";
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.RenderingDispatcher
            public String toSourceString(float value) {
                return Math.abs(value) <= Float.MAX_VALUE ? value + "f" : Float.isInfinite(value) ? value < 0.0f ? "-1.0f/0.0f" : "1.0f/0.0f" : "0.0f/0.0f";
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.RenderingDispatcher
            public String toSourceString(double value) {
                if (Math.abs(value) <= Double.MAX_VALUE) {
                    return Double.toString(value);
                }
                return Double.isInfinite(value) ? value < 0.0d ? "-1.0/0.0" : "1.0/0.0" : "0.0/0.0";
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.RenderingDispatcher
            public String toSourceString(String value) {
                return "\"" + (value.indexOf(34) == -1 ? value : value.replace("\"", "\\\"")) + "\"";
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.RenderingDispatcher
            public String toSourceString(TypeDescription value) {
                return value.getActualName() + ".class";
            }
        },
        JAVA_14_CAPABLE_VM('{', '}', ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).isLessThan(ClassFileVersion.JAVA_V17)) {
            @Override // net.bytebuddy.description.annotation.AnnotationValue.RenderingDispatcher
            public String toSourceString(byte value) {
                return "(byte)0x" + Integer.toHexString(value & 255);
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.RenderingDispatcher
            public String toSourceString(char value) {
                StringBuilder stringBuilder = new StringBuilder().append('\'');
                if (value == '\'') {
                    stringBuilder.append("\\'");
                } else {
                    stringBuilder.append(value);
                }
                return stringBuilder.append('\'').toString();
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.RenderingDispatcher
            public String toSourceString(long value) {
                return value + "L";
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.RenderingDispatcher
            public String toSourceString(float value) {
                return Math.abs(value) <= Float.MAX_VALUE ? value + "f" : Float.isInfinite(value) ? value < 0.0f ? "-1.0f/0.0f" : "1.0f/0.0f" : "0.0f/0.0f";
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.RenderingDispatcher
            public String toSourceString(double value) {
                if (Math.abs(value) <= Double.MAX_VALUE) {
                    return Double.toString(value);
                }
                return Double.isInfinite(value) ? value < 0.0d ? "-1.0/0.0" : "1.0/0.0" : "0.0/0.0";
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.RenderingDispatcher
            public String toSourceString(String value) {
                return "\"" + (value.indexOf(34) == -1 ? value : value.replace("\"", "\\\"")) + "\"";
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.RenderingDispatcher
            public String toSourceString(TypeDescription value) {
                return value.getActualName() + ".class";
            }
        };
        
        private static final String ARRAY_PREFIX = "Array with component tag: ";
        public static final RenderingDispatcher CURRENT;
        private final char openingBrace;
        private final char closingBrace;
        private final boolean componentAsInteger;

        public abstract String toSourceString(char c);

        public abstract String toSourceString(long j);

        public abstract String toSourceString(float f);

        public abstract String toSourceString(double d);

        public abstract String toSourceString(String str);

        public abstract String toSourceString(TypeDescription typeDescription);

        static {
            ClassFileVersion classFileVersion = ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5);
            if (classFileVersion.isAtLeast(ClassFileVersion.JAVA_V14)) {
                CURRENT = JAVA_14_CAPABLE_VM;
            } else if (classFileVersion.isAtLeast(ClassFileVersion.JAVA_V9)) {
                CURRENT = JAVA_9_CAPABLE_VM;
            } else {
                CURRENT = LEGACY_VM;
            }
        }

        RenderingDispatcher(char openingBrace, char closingBrace, boolean componentAsInteger) {
            this.openingBrace = openingBrace;
            this.closingBrace = closingBrace;
            this.componentAsInteger = componentAsInteger;
        }

        public String toSourceString(boolean value) {
            return Boolean.toString(value);
        }

        public String toSourceString(byte value) {
            return Byte.toString(value);
        }

        public String toSourceString(short value) {
            return Short.toString(value);
        }

        public String toSourceString(int value) {
            return Integer.toString(value);
        }

        public String toSourceString(List<?> values) {
            StringBuilder stringBuilder = new StringBuilder().append(this.openingBrace);
            boolean first = true;
            for (Object value : values) {
                if (first) {
                    first = false;
                } else {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(value);
            }
            return stringBuilder.append(this.closingBrace).toString();
        }

        public String toArrayErrorString(Sort sort) {
            String str;
            StringBuilder append = new StringBuilder().append(ARRAY_PREFIX);
            if (this.componentAsInteger || !sort.isDefined()) {
                str = Integer.toString(sort.getTag());
            } else {
                str = Character.toString((char) sort.getTag());
            }
            return append.append(str).toString();
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$Loaded.class */
    public interface Loaded<U> {
        State getState();

        U resolve();

        <V> V resolve(Class<? extends V> cls);

        boolean represents(Object obj);

        /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$Loaded$AbstractBase.class */
        public static abstract class AbstractBase<W> implements Loaded<W> {
            @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
            public <X> X resolve(Class<? extends X> type) {
                return (X) type.cast(resolve());
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$Loaded$AbstractBase$ForUnresolvedProperty.class */
            public static abstract class ForUnresolvedProperty<Z> extends AbstractBase<Z> {
                @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
                public State getState() {
                    return State.UNRESOLVED;
                }

                @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
                public boolean represents(Object value) {
                    return false;
                }
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$State.class */
    public enum State {
        UNDEFINED,
        UNRESOLVED,
        RESOLVED;

        public boolean isDefined() {
            return this != UNDEFINED;
        }

        public boolean isResolved() {
            return this == RESOLVED;
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$Sort.class */
    public enum Sort {
        BOOLEAN(90),
        BYTE(66),
        SHORT(83),
        CHARACTER(67),
        INTEGER(73),
        LONG(74),
        FLOAT(70),
        DOUBLE(68),
        STRING(115),
        TYPE(99),
        ENUMERATION(101),
        ANNOTATION(64),
        ARRAY(91),
        NONE(0);
        
        private final int tag;

        Sort(int tag) {
            this.tag = tag;
        }

        /* renamed from: of */
        public static Sort m260of(TypeDefinition typeDefinition) {
            if (typeDefinition.represents(Boolean.TYPE)) {
                return BOOLEAN;
            }
            if (typeDefinition.represents(Byte.TYPE)) {
                return BYTE;
            }
            if (typeDefinition.represents(Short.TYPE)) {
                return SHORT;
            }
            if (typeDefinition.represents(Character.TYPE)) {
                return CHARACTER;
            }
            if (typeDefinition.represents(Integer.TYPE)) {
                return INTEGER;
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
            if (typeDefinition.represents(String.class)) {
                return STRING;
            }
            if (typeDefinition.represents(Class.class)) {
                return TYPE;
            }
            if (typeDefinition.isEnum()) {
                return ENUMERATION;
            }
            if (typeDefinition.isAnnotation()) {
                return ANNOTATION;
            }
            if (typeDefinition.isArray()) {
                return ARRAY;
            }
            return NONE;
        }

        protected int getTag() {
            return this.tag;
        }

        public boolean isDefined() {
            return this != NONE;
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$AbstractBase.class */
    public static abstract class AbstractBase<U, V> implements AnnotationValue<U, V> {
        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public <W> W resolve(Class<? extends W> type) {
            return (W) type.cast(resolve());
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public AnnotationValue<U, V> filter(MethodDescription.InDefinedShape property) {
            return filter(property, property.getReturnType());
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForConstant.class */
    public static class ForConstant<U> extends AbstractBase<U, U> {
        private final U value;
        private final PropertyDelegate propertyDelegate;
        private transient /* synthetic */ int hashCode;

        protected ForConstant(U value, PropertyDelegate propertyDelegate) {
            this.value = value;
            this.propertyDelegate = propertyDelegate;
        }

        /* renamed from: of */
        public static AnnotationValue<Boolean, Boolean> m275of(boolean value) {
            return new ForConstant(Boolean.valueOf(value), PropertyDelegate.ForNonArrayType.BOOLEAN);
        }

        /* renamed from: of */
        public static AnnotationValue<Byte, Byte> m284of(byte value) {
            return new ForConstant(Byte.valueOf(value), PropertyDelegate.ForNonArrayType.BYTE);
        }

        /* renamed from: of */
        public static AnnotationValue<Short, Short> m276of(short value) {
            return new ForConstant(Short.valueOf(value), PropertyDelegate.ForNonArrayType.SHORT);
        }

        /* renamed from: of */
        public static AnnotationValue<Character, Character> m283of(char value) {
            return new ForConstant(Character.valueOf(value), PropertyDelegate.ForNonArrayType.CHARACTER);
        }

        /* renamed from: of */
        public static AnnotationValue<Integer, Integer> m280of(int value) {
            return new ForConstant(Integer.valueOf(value), PropertyDelegate.ForNonArrayType.INTEGER);
        }

        /* renamed from: of */
        public static AnnotationValue<Long, Long> m279of(long value) {
            return new ForConstant(Long.valueOf(value), PropertyDelegate.ForNonArrayType.LONG);
        }

        /* renamed from: of */
        public static AnnotationValue<Float, Float> m281of(float value) {
            return new ForConstant(Float.valueOf(value), PropertyDelegate.ForNonArrayType.FLOAT);
        }

        /* renamed from: of */
        public static AnnotationValue<Double, Double> m282of(double value) {
            return new ForConstant(Double.valueOf(value), PropertyDelegate.ForNonArrayType.DOUBLE);
        }

        /* renamed from: of */
        public static AnnotationValue<String, String> m277of(String value) {
            return new ForConstant(value, PropertyDelegate.ForNonArrayType.STRING);
        }

        /* renamed from: of */
        public static AnnotationValue<boolean[], boolean[]> m266of(boolean... value) {
            return new ForConstant(value, PropertyDelegate.ForArrayType.BOOLEAN);
        }

        /* renamed from: of */
        public static AnnotationValue<byte[], byte[]> m274of(byte... value) {
            return new ForConstant(value, PropertyDelegate.ForArrayType.BYTE);
        }

        /* renamed from: of */
        public static AnnotationValue<short[], short[]> m267of(short... value) {
            return new ForConstant(value, PropertyDelegate.ForArrayType.SHORT);
        }

        /* renamed from: of */
        public static AnnotationValue<char[], char[]> m273of(char... value) {
            return new ForConstant(value, PropertyDelegate.ForArrayType.CHARACTER);
        }

        /* renamed from: of */
        public static AnnotationValue<int[], int[]> m270of(int... value) {
            return new ForConstant(value, PropertyDelegate.ForArrayType.INTEGER);
        }

        /* renamed from: of */
        public static AnnotationValue<long[], long[]> m269of(long... value) {
            return new ForConstant(value, PropertyDelegate.ForArrayType.LONG);
        }

        /* renamed from: of */
        public static AnnotationValue<float[], float[]> m271of(float... value) {
            return new ForConstant(value, PropertyDelegate.ForArrayType.FLOAT);
        }

        /* renamed from: of */
        public static AnnotationValue<double[], double[]> m272of(double... value) {
            return new ForConstant(value, PropertyDelegate.ForArrayType.DOUBLE);
        }

        /* renamed from: of */
        public static AnnotationValue<String[], String[]> m268of(String... value) {
            return new ForConstant(value, PropertyDelegate.ForArrayType.STRING);
        }

        /* JADX DEBUG: Type inference failed for r0v40. Raw type applied. Possible types: net.bytebuddy.description.annotation.AnnotationValue<java.lang.String[], java.lang.String[]>, net.bytebuddy.description.annotation.AnnotationValue<?, ?> */
        /* JADX DEBUG: Type inference failed for r0v44. Raw type applied. Possible types: net.bytebuddy.description.annotation.AnnotationValue<double[], double[]>, net.bytebuddy.description.annotation.AnnotationValue<?, ?> */
        /* JADX DEBUG: Type inference failed for r0v48. Raw type applied. Possible types: net.bytebuddy.description.annotation.AnnotationValue<float[], float[]>, net.bytebuddy.description.annotation.AnnotationValue<?, ?> */
        /* JADX DEBUG: Type inference failed for r0v52. Raw type applied. Possible types: net.bytebuddy.description.annotation.AnnotationValue<long[], long[]>, net.bytebuddy.description.annotation.AnnotationValue<?, ?> */
        /* JADX DEBUG: Type inference failed for r0v56. Raw type applied. Possible types: net.bytebuddy.description.annotation.AnnotationValue<int[], int[]>, net.bytebuddy.description.annotation.AnnotationValue<?, ?> */
        /* JADX DEBUG: Type inference failed for r0v60. Raw type applied. Possible types: net.bytebuddy.description.annotation.AnnotationValue<char[], char[]>, net.bytebuddy.description.annotation.AnnotationValue<?, ?> */
        /* JADX DEBUG: Type inference failed for r0v64. Raw type applied. Possible types: net.bytebuddy.description.annotation.AnnotationValue<short[], short[]>, net.bytebuddy.description.annotation.AnnotationValue<?, ?> */
        /* JADX DEBUG: Type inference failed for r0v68. Raw type applied. Possible types: net.bytebuddy.description.annotation.AnnotationValue<byte[], byte[]>, net.bytebuddy.description.annotation.AnnotationValue<?, ?> */
        /* JADX DEBUG: Type inference failed for r0v72. Raw type applied. Possible types: net.bytebuddy.description.annotation.AnnotationValue<boolean[], boolean[]>, net.bytebuddy.description.annotation.AnnotationValue<?, ?> */
        /* renamed from: of */
        public static AnnotationValue<?, ?> m278of(Object value) {
            if (value instanceof Boolean) {
                return m275of(((Boolean) value).booleanValue());
            }
            if (value instanceof Byte) {
                return m284of(((Byte) value).byteValue());
            }
            if (value instanceof Short) {
                return m276of(((Short) value).shortValue());
            }
            if (value instanceof Character) {
                return m283of(((Character) value).charValue());
            }
            if (value instanceof Integer) {
                return m280of(((Integer) value).intValue());
            }
            if (value instanceof Long) {
                return m279of(((Long) value).longValue());
            }
            if (value instanceof Float) {
                return m281of(((Float) value).floatValue());
            }
            if (value instanceof Double) {
                return m282of(((Double) value).doubleValue());
            }
            if (value instanceof String) {
                return m277of((String) value);
            }
            if (value instanceof boolean[]) {
                return m266of((boolean[]) value);
            }
            if (value instanceof byte[]) {
                return m274of((byte[]) value);
            }
            if (value instanceof short[]) {
                return m267of((short[]) value);
            }
            if (value instanceof char[]) {
                return m273of((char[]) value);
            }
            if (value instanceof int[]) {
                return m270of((int[]) value);
            }
            if (value instanceof long[]) {
                return m269of((long[]) value);
            }
            if (value instanceof float[]) {
                return m271of((float[]) value);
            }
            if (value instanceof double[]) {
                return m272of((double[]) value);
            }
            if (value instanceof String[]) {
                return m268of((String[]) value);
            }
            throw new IllegalArgumentException("Not a constant annotation value: " + value);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public State getState() {
            return State.RESOLVED;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public Sort getSort() {
            return Sort.m260of(TypeDescription.ForLoadedType.m247of(this.value.getClass()).asUnboxed());
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public AnnotationValue<U, U> filter(MethodDescription.InDefinedShape property, TypeDefinition typeDefinition) {
            if (typeDefinition.asErasure().asBoxed().represents(this.value.getClass())) {
                return this;
            }
            if (this.value.getClass().isArray()) {
                return new ForMismatchedType(property, RenderingDispatcher.CURRENT.toArrayErrorString(Sort.m260of(TypeDescription.ForLoadedType.m247of(this.value.getClass().getComponentType()))));
            }
            if (this.value instanceof Enum) {
                return new ForMismatchedType(property, this.value.getClass().getName() + '.' + ((Enum) this.value).name());
            }
            return new ForMismatchedType(property, this.value.getClass().getName() + '[' + this.value + ']');
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public U resolve() {
            return this.value;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public Loaded<U> load(ClassLoader classLoader) {
            return new Loaded(this.value, this.propertyDelegate);
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int hashCode = this.hashCode != 0 ? 0 : this.propertyDelegate.hashCode(this.value);
            if (hashCode == 0) {
                hashCode = this.hashCode;
            } else {
                this.hashCode = hashCode;
            }
            return hashCode;
        }

        public boolean equals(Object other) {
            return this == other || ((other instanceof AnnotationValue) && this.propertyDelegate.equals(this.value, ((AnnotationValue) other).resolve()));
        }

        public String toString() {
            return this.propertyDelegate.toString(this.value);
        }

        /* access modifiers changed from: protected */
        /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForConstant$PropertyDelegate.class */
        public interface PropertyDelegate {
            <S> S copy(S s);

            int hashCode(Object obj);

            boolean equals(Object obj, Object obj2);

            String toString(Object obj);

            /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForConstant$PropertyDelegate$ForNonArrayType.class */
            public enum ForNonArrayType implements PropertyDelegate {
                BOOLEAN {
                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public String toString(Object value) {
                        return RenderingDispatcher.CURRENT.toSourceString(((Boolean) value).booleanValue());
                    }
                },
                BYTE {
                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public String toString(Object value) {
                        return RenderingDispatcher.CURRENT.toSourceString(((Byte) value).byteValue());
                    }
                },
                SHORT {
                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public String toString(Object value) {
                        return RenderingDispatcher.CURRENT.toSourceString(((Short) value).shortValue());
                    }
                },
                CHARACTER {
                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public String toString(Object value) {
                        return RenderingDispatcher.CURRENT.toSourceString(((Character) value).charValue());
                    }
                },
                INTEGER {
                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public String toString(Object value) {
                        return RenderingDispatcher.CURRENT.toSourceString(((Integer) value).intValue());
                    }
                },
                LONG {
                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public String toString(Object value) {
                        return RenderingDispatcher.CURRENT.toSourceString(((Long) value).longValue());
                    }
                },
                FLOAT {
                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public String toString(Object value) {
                        return RenderingDispatcher.CURRENT.toSourceString(((Float) value).floatValue());
                    }
                },
                DOUBLE {
                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public String toString(Object value) {
                        return RenderingDispatcher.CURRENT.toSourceString(((Double) value).doubleValue());
                    }
                },
                STRING {
                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public String toString(Object value) {
                        return RenderingDispatcher.CURRENT.toSourceString((String) value);
                    }
                };

                @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                public <S> S copy(S value) {
                    return value;
                }

                @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                public int hashCode(Object value) {
                    return value.hashCode();
                }

                @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                public boolean equals(Object self, Object other) {
                    return self.equals(other);
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForConstant$PropertyDelegate$ForArrayType.class */
            public enum ForArrayType implements PropertyDelegate {
                BOOLEAN {
                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate.ForArrayType
                    protected Object doCopy(Object value) {
                        return ((boolean[]) value).clone();
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public int hashCode(Object value) {
                        return Arrays.hashCode((boolean[]) value);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public boolean equals(Object self, Object other) {
                        return (other instanceof boolean[]) && Arrays.equals((boolean[]) self, (boolean[]) other);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate.ForArrayType
                    protected String toString(Object array, int index) {
                        return ForNonArrayType.BOOLEAN.toString(Boolean.valueOf(Array.getBoolean(array, index)));
                    }
                },
                BYTE {
                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate.ForArrayType
                    protected Object doCopy(Object value) {
                        return ((byte[]) value).clone();
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public int hashCode(Object value) {
                        return Arrays.hashCode((byte[]) value);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public boolean equals(Object self, Object other) {
                        return (other instanceof byte[]) && Arrays.equals((byte[]) self, (byte[]) other);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate.ForArrayType
                    protected String toString(Object array, int index) {
                        return ForNonArrayType.BYTE.toString(Byte.valueOf(Array.getByte(array, index)));
                    }
                },
                SHORT {
                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate.ForArrayType
                    protected Object doCopy(Object value) {
                        return ((short[]) value).clone();
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public int hashCode(Object value) {
                        return Arrays.hashCode((short[]) value);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public boolean equals(Object self, Object other) {
                        return (other instanceof short[]) && Arrays.equals((short[]) self, (short[]) other);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate.ForArrayType
                    protected String toString(Object array, int index) {
                        return ForNonArrayType.SHORT.toString(Short.valueOf(Array.getShort(array, index)));
                    }
                },
                CHARACTER {
                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate.ForArrayType
                    protected Object doCopy(Object value) {
                        return ((char[]) value).clone();
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public int hashCode(Object value) {
                        return Arrays.hashCode((char[]) value);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public boolean equals(Object self, Object other) {
                        return (other instanceof char[]) && Arrays.equals((char[]) self, (char[]) other);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate.ForArrayType
                    protected String toString(Object array, int index) {
                        return ForNonArrayType.CHARACTER.toString(Character.valueOf(Array.getChar(array, index)));
                    }
                },
                INTEGER {
                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate.ForArrayType
                    protected Object doCopy(Object value) {
                        return ((int[]) value).clone();
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public int hashCode(Object value) {
                        return Arrays.hashCode((int[]) value);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public boolean equals(Object self, Object other) {
                        return (other instanceof int[]) && Arrays.equals((int[]) self, (int[]) other);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate.ForArrayType
                    protected String toString(Object array, int index) {
                        return ForNonArrayType.INTEGER.toString(Integer.valueOf(Array.getInt(array, index)));
                    }
                },
                LONG {
                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate.ForArrayType
                    protected Object doCopy(Object value) {
                        return ((long[]) value).clone();
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public int hashCode(Object value) {
                        return Arrays.hashCode((long[]) value);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public boolean equals(Object self, Object other) {
                        return (other instanceof long[]) && Arrays.equals((long[]) self, (long[]) other);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate.ForArrayType
                    protected String toString(Object array, int index) {
                        return ForNonArrayType.LONG.toString(Long.valueOf(Array.getLong(array, index)));
                    }
                },
                FLOAT {
                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate.ForArrayType
                    protected Object doCopy(Object value) {
                        return ((float[]) value).clone();
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public int hashCode(Object value) {
                        return Arrays.hashCode((float[]) value);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public boolean equals(Object self, Object other) {
                        return (other instanceof float[]) && Arrays.equals((float[]) self, (float[]) other);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate.ForArrayType
                    protected String toString(Object array, int index) {
                        return ForNonArrayType.FLOAT.toString(Float.valueOf(Array.getFloat(array, index)));
                    }
                },
                DOUBLE {
                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate.ForArrayType
                    protected Object doCopy(Object value) {
                        return ((double[]) value).clone();
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public int hashCode(Object value) {
                        return Arrays.hashCode((double[]) value);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public boolean equals(Object self, Object other) {
                        return (other instanceof double[]) && Arrays.equals((double[]) self, (double[]) other);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate.ForArrayType
                    protected String toString(Object array, int index) {
                        return ForNonArrayType.DOUBLE.toString(Double.valueOf(Array.getDouble(array, index)));
                    }
                },
                STRING {
                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate.ForArrayType
                    protected Object doCopy(Object value) {
                        return ((String[]) value).clone();
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public int hashCode(Object value) {
                        return Arrays.hashCode((String[]) value);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                    public boolean equals(Object self, Object other) {
                        return (other instanceof String[]) && Arrays.equals((String[]) self, (String[]) other);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate.ForArrayType
                    protected String toString(Object array, int index) {
                        return ForNonArrayType.STRING.toString(Array.get(array, index));
                    }
                };

                protected abstract Object doCopy(Object obj);

                protected abstract String toString(Object obj, int i);

                @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                public <S> S copy(S value) {
                    return (S) doCopy(value);
                }

                @Override // net.bytebuddy.description.annotation.AnnotationValue.ForConstant.PropertyDelegate
                public String toString(Object value) {
                    List<String> elements = new ArrayList<>(Array.getLength(value));
                    for (int index = 0; index < Array.getLength(value); index++) {
                        elements.add(toString(value, index));
                    }
                    return RenderingDispatcher.CURRENT.toSourceString(elements);
                }
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForConstant$Loaded.class */
        protected static class Loaded<V> extends Loaded.AbstractBase<V> {
            private final V value;
            private final PropertyDelegate propertyDelegate;
            private transient /* synthetic */ int hashCode;

            protected Loaded(V value, PropertyDelegate propertyDelegate) {
                this.value = value;
                this.propertyDelegate = propertyDelegate;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
            public State getState() {
                return State.RESOLVED;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
            public V resolve() {
                return (V) this.propertyDelegate.copy(this.value);
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
            public boolean represents(Object value) {
                return this.propertyDelegate.equals(this.value, value);
            }

            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int hashCode = this.hashCode != 0 ? 0 : this.propertyDelegate.hashCode(this.value);
                if (hashCode == 0) {
                    hashCode = this.hashCode;
                } else {
                    this.hashCode = hashCode;
                }
                return hashCode;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded<?> annotationValue = (Loaded) other;
                return annotationValue.getState().isResolved() && this.propertyDelegate.equals(this.value, annotationValue.resolve());
            }

            public String toString() {
                return this.propertyDelegate.toString(this.value);
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForAnnotationDescription.class */
    public static class ForAnnotationDescription<U extends Annotation> extends AbstractBase<AnnotationDescription, U> {
        private final AnnotationDescription annotationDescription;

        public ForAnnotationDescription(AnnotationDescription annotationDescription) {
            this.annotationDescription = annotationDescription;
        }

        /* renamed from: of */
        public static <V extends Annotation> AnnotationValue<AnnotationDescription, V> m285of(TypeDescription annotationType, Map<String, ? extends AnnotationValue<?, ?>> annotationValues) {
            return new ForAnnotationDescription(new AnnotationDescription.Latent(annotationType, annotationValues));
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public State getState() {
            return State.RESOLVED;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public Sort getSort() {
            return Sort.ANNOTATION;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public AnnotationValue<AnnotationDescription, U> filter(MethodDescription.InDefinedShape property, TypeDefinition typeDefinition) {
            String str;
            if (typeDefinition.asErasure().equals(this.annotationDescription.getAnnotationType())) {
                return this;
            }
            if (property.getReturnType().isArray()) {
                str = RenderingDispatcher.CURRENT.toArrayErrorString(Sort.ANNOTATION);
            } else {
                str = this.annotationDescription.toString();
            }
            return new ForMismatchedType(property, str);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public AnnotationDescription resolve() {
            return this.annotationDescription;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public Loaded<U> load(ClassLoader classLoader) {
            try {
                return new Loaded(this.annotationDescription.prepare(Class.forName(this.annotationDescription.getAnnotationType().getName(), false, classLoader)).load());
            } catch (ClassNotFoundException exception) {
                return new ForMissingType.Loaded(this.annotationDescription.getAnnotationType().getName(), exception);
            }
        }

        public int hashCode() {
            return this.annotationDescription.hashCode();
        }

        public boolean equals(Object other) {
            return this == other || ((other instanceof AnnotationValue) && this.annotationDescription.equals(((AnnotationValue) other).resolve()));
        }

        public String toString() {
            return this.annotationDescription.toString();
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForAnnotationDescription$Loaded.class */
        public static class Loaded<V extends Annotation> extends Loaded.AbstractBase<V> {
            private final V annotation;

            public Loaded(V annotation) {
                this.annotation = annotation;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
            public State getState() {
                return State.RESOLVED;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
            public V resolve() {
                return this.annotation;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
            public boolean represents(Object value) {
                return this.annotation.equals(value);
            }

            public int hashCode() {
                return this.annotation.hashCode();
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded<?> annotationValue = (Loaded) other;
                return annotationValue.getState().isResolved() && this.annotation.equals(annotationValue.resolve());
            }

            public String toString() {
                return this.annotation.toString();
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForEnumerationDescription.class */
    public static class ForEnumerationDescription<U extends Enum<U>> extends AbstractBase<EnumerationDescription, U> {
        private final EnumerationDescription enumerationDescription;

        public ForEnumerationDescription(EnumerationDescription enumerationDescription) {
            this.enumerationDescription = enumerationDescription;
        }

        /* renamed from: of */
        public static <V extends Enum<V>> AnnotationValue<EnumerationDescription, V> m262of(EnumerationDescription value) {
            return new ForEnumerationDescription(value);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public EnumerationDescription resolve() {
            return this.enumerationDescription;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public State getState() {
            return State.RESOLVED;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public Sort getSort() {
            return Sort.ENUMERATION;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public AnnotationValue<EnumerationDescription, U> filter(MethodDescription.InDefinedShape property, TypeDefinition typeDefinition) {
            String str;
            if (typeDefinition.asErasure().equals(this.enumerationDescription.getEnumerationType())) {
                return this;
            }
            if (property.getReturnType().isArray()) {
                str = RenderingDispatcher.CURRENT.toArrayErrorString(Sort.ENUMERATION);
            } else {
                str = this.enumerationDescription.getEnumerationType().getName() + '.' + this.enumerationDescription.getValue();
            }
            return new ForMismatchedType(property, str);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public Loaded<U> load(ClassLoader classLoader) {
            try {
                return new Loaded(this.enumerationDescription.load(Class.forName(this.enumerationDescription.getEnumerationType().getName(), false, classLoader)));
            } catch (ClassNotFoundException exception) {
                return new ForMissingType.Loaded(this.enumerationDescription.getEnumerationType().getName(), exception);
            }
        }

        public int hashCode() {
            return this.enumerationDescription.hashCode();
        }

        public boolean equals(Object other) {
            return this == other || ((other instanceof AnnotationValue) && this.enumerationDescription.equals(((AnnotationValue) other).resolve()));
        }

        public String toString() {
            return this.enumerationDescription.toString();
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForEnumerationDescription$Loaded.class */
        public static class Loaded<V extends Enum<V>> extends Loaded.AbstractBase<V> {
            private final V enumeration;

            public Loaded(V enumeration) {
                this.enumeration = enumeration;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
            public State getState() {
                return State.RESOLVED;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
            public V resolve() {
                return this.enumeration;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
            public boolean represents(Object value) {
                return this.enumeration.equals(value);
            }

            public int hashCode() {
                return this.enumeration.hashCode();
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded<?> annotationValue = (Loaded) other;
                return annotationValue.getState().isResolved() && this.enumeration.equals(annotationValue.resolve());
            }

            public String toString() {
                return this.enumeration.toString();
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForEnumerationDescription$Loaded$WithIncompatibleRuntimeType.class */
            public static class WithIncompatibleRuntimeType extends Loaded.AbstractBase<Enum<?>> {
                private final Class<?> type;

                public WithIncompatibleRuntimeType(Class<?> type) {
                    this.type = type;
                }

                @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
                public State getState() {
                    return State.UNRESOLVED;
                }

                @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
                public Enum<?> resolve() {
                    throw new IncompatibleClassChangeError("Not an enumeration type: " + this.type.toString());
                }

                @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
                public boolean represents(Object value) {
                    return false;
                }
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForEnumerationDescription$WithUnknownConstant.class */
        public static class WithUnknownConstant<U extends Enum<U>> extends AbstractBase<EnumerationDescription, U> {
            private final TypeDescription typeDescription;
            private final String value;

            public WithUnknownConstant(TypeDescription typeDescription, String value) {
                this.typeDescription = typeDescription;
                this.value = value;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue
            public State getState() {
                return State.UNRESOLVED;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue
            public Sort getSort() {
                return Sort.NONE;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue
            public AnnotationValue<EnumerationDescription, U> filter(MethodDescription.InDefinedShape property, TypeDefinition typeDefinition) {
                return this;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue
            public EnumerationDescription resolve() {
                throw new IllegalStateException(this.typeDescription + " does not declare enumeration constant " + this.value);
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue
            public Loaded<U> load(ClassLoader classLoader) {
                try {
                    return new Loaded(Class.forName(this.typeDescription.getName(), false, classLoader), this.value);
                } catch (ClassNotFoundException exception) {
                    return new ForMissingType.Loaded(this.typeDescription.getName(), exception);
                }
            }

            public String toString() {
                return this.value + " /* Warning: constant not present! */";
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForEnumerationDescription$WithUnknownConstant$Loaded.class */
            public static class Loaded extends Loaded.AbstractBase.ForUnresolvedProperty<Enum<?>> {
                private final Class<? extends Enum<?>> enumType;
                private final String value;

                public Loaded(Class<? extends Enum<?>> enumType, String value) {
                    this.enumType = enumType;
                    this.value = value;
                }

                @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
                public Enum<?> resolve() {
                    throw new EnumConstantNotPresentException(this.enumType, this.value);
                }

                public String toString() {
                    return this.value + " /* Warning: constant not present! */";
                }
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForTypeDescription.class */
    public static class ForTypeDescription<U extends Class<U>> extends AbstractBase<TypeDescription, U> {
        private static final boolean NO_INITIALIZATION = false;
        private final TypeDescription typeDescription;

        public ForTypeDescription(TypeDescription typeDescription) {
            this.typeDescription = typeDescription;
        }

        /* renamed from: of */
        public static <V extends Class<V>> AnnotationValue<TypeDescription, V> m261of(TypeDescription typeDescription) {
            return new ForTypeDescription(typeDescription);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public State getState() {
            return State.RESOLVED;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public Sort getSort() {
            return Sort.TYPE;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public AnnotationValue<TypeDescription, U> filter(MethodDescription.InDefinedShape property, TypeDefinition typeDefinition) {
            String str;
            if (typeDefinition.asErasure().represents(Class.class)) {
                return this;
            }
            if (property.getReturnType().isArray()) {
                str = RenderingDispatcher.CURRENT.toArrayErrorString(Sort.TYPE);
            } else {
                str = Class.class.getName() + '[' + this.typeDescription.getName() + ']';
            }
            return new ForMismatchedType(property, str);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public TypeDescription resolve() {
            return this.typeDescription;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public Loaded<U> load(ClassLoader classLoader) {
            try {
                return new Loaded(Class.forName(this.typeDescription.getName(), false, classLoader));
            } catch (ClassNotFoundException exception) {
                return new ForMissingType.Loaded(this.typeDescription.getName(), exception);
            }
        }

        public int hashCode() {
            return this.typeDescription.hashCode();
        }

        public boolean equals(Object other) {
            return this == other || ((other instanceof AnnotationValue) && this.typeDescription.equals(((AnnotationValue) other).resolve()));
        }

        public String toString() {
            return RenderingDispatcher.CURRENT.toSourceString(this.typeDescription);
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForTypeDescription$Loaded.class */
        protected static class Loaded<U extends Class<U>> extends Loaded.AbstractBase<U> {
            private final U type;

            public Loaded(U type) {
                this.type = type;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
            public State getState() {
                return State.RESOLVED;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
            public U resolve() {
                return this.type;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
            public boolean represents(Object value) {
                return this.type.equals(value);
            }

            public int hashCode() {
                return this.type.hashCode();
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded<?> annotationValue = (Loaded) other;
                return annotationValue.getState().isResolved() && this.type.equals(annotationValue.resolve());
            }

            public String toString() {
                return RenderingDispatcher.CURRENT.toSourceString(TypeDescription.ForLoadedType.m247of(this.type));
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForDescriptionArray.class */
    public static class ForDescriptionArray<U, V> extends AbstractBase<U, V> {
        private final Class<?> unloadedComponentType;
        private final TypeDescription componentType;
        private final List<? extends AnnotationValue<?, ?>> values;
        private transient /* synthetic */ int hashCode;

        public ForDescriptionArray(Class<?> unloadedComponentType, TypeDescription componentType, List<? extends AnnotationValue<?, ?>> values) {
            this.unloadedComponentType = unloadedComponentType;
            this.componentType = componentType;
            this.values = values;
        }

        /* renamed from: of */
        public static <W extends Enum<W>> AnnotationValue<EnumerationDescription[], W[]> m264of(TypeDescription enumerationType, EnumerationDescription[] enumerationDescription) {
            List<AnnotationValue<EnumerationDescription, W>> values = new ArrayList<>(enumerationDescription.length);
            for (EnumerationDescription value : enumerationDescription) {
                if (!value.getEnumerationType().equals(enumerationType)) {
                    throw new IllegalArgumentException(value + " is not of " + enumerationType);
                }
                values.add(ForEnumerationDescription.m262of(value));
            }
            return new ForDescriptionArray(EnumerationDescription.class, enumerationType, values);
        }

        /* renamed from: of */
        public static <W extends Annotation> AnnotationValue<AnnotationDescription[], W[]> m265of(TypeDescription annotationType, AnnotationDescription[] annotationDescription) {
            List<AnnotationValue<AnnotationDescription, W>> values = new ArrayList<>(annotationDescription.length);
            for (AnnotationDescription value : annotationDescription) {
                if (!value.getAnnotationType().equals(annotationType)) {
                    throw new IllegalArgumentException(value + " is not of " + annotationType);
                }
                values.add(new ForAnnotationDescription<>(value));
            }
            return new ForDescriptionArray(AnnotationDescription.class, annotationType, values);
        }

        /* renamed from: of */
        public static AnnotationValue<TypeDescription[], Class<?>[]> m263of(TypeDescription[] typeDescription) {
            List<AnnotationValue<TypeDescription, Class<?>>> values = new ArrayList<>(typeDescription.length);
            for (TypeDescription value : typeDescription) {
                values.add(ForTypeDescription.m261of(value));
            }
            return new ForDescriptionArray(TypeDescription.class, TypeDescription.CLASS, values);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public State getState() {
            return State.RESOLVED;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public Sort getSort() {
            return Sort.ARRAY;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public AnnotationValue<U, V> filter(MethodDescription.InDefinedShape property, TypeDefinition typeDefinition) {
            if (!typeDefinition.isArray() || !typeDefinition.getComponentType().asErasure().equals(this.componentType)) {
                return new ForMismatchedType(property, RenderingDispatcher.CURRENT.toArrayErrorString(Sort.m260of(this.componentType)));
            }
            for (AnnotationValue<?, ?> value : this.values) {
                AnnotationValue<U, V> filter = value.filter(property, typeDefinition.getComponentType());
                if (filter.getState() != State.RESOLVED) {
                    return filter;
                }
            }
            return this;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public U resolve() {
            U resolved = (U) Array.newInstance(this.unloadedComponentType, this.values.size());
            int index = 0;
            for (AnnotationValue<?, ?> value : this.values) {
                index++;
                Array.set(resolved, index, value.resolve());
            }
            return resolved;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public Loaded<V> load(ClassLoader classLoader) {
            List<Loaded<?>> values = new ArrayList<>(this.values.size());
            for (AnnotationValue<?, ?> value : this.values) {
                values.add(value.load(classLoader));
            }
            try {
                return new Loaded(Class.forName(this.componentType.getName(), false, classLoader), values);
            } catch (ClassNotFoundException exception) {
                return new ForMissingType.Loaded(this.componentType.getName(), exception);
            }
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int i;
            if (this.hashCode != 0) {
                i = 0;
            } else {
                int result = 1;
                for (AnnotationValue<?, ?> value : this.values) {
                    result = (31 * result) + value.hashCode();
                }
                i = result;
            }
            if (i == 0) {
                i = this.hashCode;
            } else {
                this.hashCode = i;
            }
            return i;
        }

        public boolean equals(Object other) {
            Object value;
            if (this == other) {
                return true;
            }
            if (!((other instanceof AnnotationValue) && (value = ((AnnotationValue) other).resolve()) != null && value.getClass().isArray() && this.values.size() == Array.getLength(value))) {
                return false;
            }
            Iterator<? extends AnnotationValue<?, ?>> iterator = this.values.iterator();
            for (int index = 0; index < this.values.size(); index++) {
                if (!((AnnotationValue) iterator.next()).resolve().equals(Array.get(value, index))) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return RenderingDispatcher.CURRENT.toSourceString(this.values);
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForDescriptionArray$Loaded.class */
        protected static class Loaded<W> extends Loaded.AbstractBase<W> {
            private final Class<W> componentType;
            private final List<Loaded<?>> values;
            private transient /* synthetic */ int hashCode;

            protected Loaded(Class<W> componentType, List<Loaded<?>> values) {
                this.componentType = componentType;
                this.values = values;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
            public State getState() {
                for (Loaded<?> value : this.values) {
                    if (!value.getState().isResolved()) {
                        return State.UNRESOLVED;
                    }
                }
                return State.RESOLVED;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
            public W resolve() {
                W array = (W) Array.newInstance((Class<?>) this.componentType, this.values.size());
                int index = 0;
                for (Loaded<?> annotationValue : this.values) {
                    index++;
                    Array.set(array, index, annotationValue.resolve());
                }
                return array;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
            public boolean represents(Object value) {
                if (!((value instanceof Object[]) && value.getClass().getComponentType() == this.componentType)) {
                    return false;
                }
                Object[] array = (Object[]) value;
                if (this.values.size() != array.length) {
                    return false;
                }
                Iterator<Loaded<?>> iterator = this.values.iterator();
                for (Object aValue : array) {
                    if (!iterator.next().represents(aValue)) {
                        return false;
                    }
                }
                return true;
            }

            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int i;
                if (this.hashCode != 0) {
                    i = 0;
                } else {
                    int result = 1;
                    for (Loaded<?> value : this.values) {
                        result = (31 * result) + value.hashCode();
                    }
                    i = result;
                }
                if (i == 0) {
                    i = this.hashCode;
                } else {
                    this.hashCode = i;
                }
                return i;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded<?> annotationValue = (Loaded) other;
                if (!annotationValue.getState().isResolved()) {
                    return false;
                }
                Object value = annotationValue.resolve();
                if (!(value instanceof Object[])) {
                    return false;
                }
                Object[] arrayValue = (Object[]) value;
                if (this.values.size() != arrayValue.length) {
                    return false;
                }
                Iterator<Loaded<?>> iterator = this.values.iterator();
                for (Object aValue : arrayValue) {
                    Loaded<?> self = iterator.next();
                    if (!self.getState().isResolved() || !self.resolve().equals(aValue)) {
                        return false;
                    }
                }
                return true;
            }

            public String toString() {
                return RenderingDispatcher.CURRENT.toSourceString(this.values);
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForMissingType.class */
    public static class ForMissingType<U, V> extends AbstractBase<U, V> {
        private final String typeName;

        public ForMissingType(String typeName) {
            this.typeName = typeName;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public State getState() {
            return State.UNRESOLVED;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public Sort getSort() {
            return Sort.NONE;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public AnnotationValue<U, V> filter(MethodDescription.InDefinedShape property, TypeDefinition typeDefinition) {
            return this;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public U resolve() {
            throw new IllegalStateException("Type not found: " + this.typeName);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public Loaded<V> load(ClassLoader classLoader) {
            return new Loaded(this.typeName, new ClassNotFoundException(this.typeName));
        }

        public String toString() {
            return this.typeName + ".class /* Warning: type not present! */";
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForMissingType$Loaded.class */
        public static class Loaded<U> extends Loaded.AbstractBase.ForUnresolvedProperty<U> {
            private final String typeName;
            private final ClassNotFoundException exception;

            public Loaded(String typeName, ClassNotFoundException exception) {
                this.typeName = typeName;
                this.exception = exception;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
            public U resolve() {
                throw new TypeNotPresentException(this.typeName, this.exception);
            }

            public String toString() {
                return this.typeName + ".class /* Warning: type not present! */";
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForMismatchedType.class */
    public static class ForMismatchedType<U, V> extends AbstractBase<U, V> {
        private final MethodDescription.InDefinedShape property;
        private final String value;

        public ForMismatchedType(MethodDescription.InDefinedShape property, String value) {
            this.property = property;
            this.value = value;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public State getState() {
            return State.UNRESOLVED;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public Sort getSort() {
            return Sort.NONE;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public AnnotationValue<U, V> filter(MethodDescription.InDefinedShape property, TypeDefinition typeDefinition) {
            return new ForMismatchedType(property, this.value);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public U resolve() {
            throw new IllegalStateException(this.value + " cannot be used as value for " + this.property);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:5:0x0031
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public net.bytebuddy.description.annotation.AnnotationValue.Loaded<V> load(java.lang.ClassLoader r7) {
            /*
                r6 = this;
                r0 = r6
                net.bytebuddy.description.method.MethodDescription$InDefinedShape r0 = r0.property     // Catch: ClassNotFoundException -> 0x003b
                net.bytebuddy.description.type.TypeDescription r0 = r0.getDeclaringType()     // Catch: ClassNotFoundException -> 0x003b
                java.lang.String r0 = r0.getName()     // Catch: ClassNotFoundException -> 0x003b
                r1 = 0
                r2 = r7
                java.lang.Class r0 = java.lang.Class.forName(r0, r1, r2)     // Catch: ClassNotFoundException -> 0x003b
                r8 = r0
                net.bytebuddy.description.annotation.AnnotationValue$ForMismatchedType$Loaded r0 = new net.bytebuddy.description.annotation.AnnotationValue$ForMismatchedType$Loaded     // Catch: ClassNotFoundException -> 0x003b, NoSuchMethodException -> 0x0031
                r1 = r0
                r2 = r8
                r3 = r6
                net.bytebuddy.description.method.MethodDescription$InDefinedShape r3 = r3.property     // Catch: ClassNotFoundException -> 0x003b, NoSuchMethodException -> 0x0031
                java.lang.String r3 = r3.getName()     // Catch: ClassNotFoundException -> 0x003b, NoSuchMethodException -> 0x0031
                r4 = 0
                java.lang.Class[] r4 = new java.lang.Class[r4]     // Catch: ClassNotFoundException -> 0x003b, NoSuchMethodException -> 0x0031
                java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch: ClassNotFoundException -> 0x003b, NoSuchMethodException -> 0x0031
                r3 = r6
                java.lang.String r3 = r3.value     // Catch: ClassNotFoundException -> 0x003b, NoSuchMethodException -> 0x0031
                r1.<init>(r2, r3)     // Catch: ClassNotFoundException -> 0x003b, NoSuchMethodException -> 0x0031
                return r0
            L_0x0031:
                r9 = move-exception
                net.bytebuddy.description.annotation.AnnotationValue$ForIncompatibleType$Loaded r0 = new net.bytebuddy.description.annotation.AnnotationValue$ForIncompatibleType$Loaded     // Catch: ClassNotFoundException -> 0x003b
                r1 = r0
                r2 = r8
                r1.<init>(r2)     // Catch: ClassNotFoundException -> 0x003b
                return r0
            L_0x003b:
                r8 = move-exception
                net.bytebuddy.description.annotation.AnnotationValue$ForMissingType$Loaded r0 = new net.bytebuddy.description.annotation.AnnotationValue$ForMissingType$Loaded
                r1 = r0
                r2 = r6
                net.bytebuddy.description.method.MethodDescription$InDefinedShape r2 = r2.property
                net.bytebuddy.description.type.TypeDescription r2 = r2.getDeclaringType()
                java.lang.String r2 = r2.getName()
                r3 = r8
                r1.<init>(r2, r3)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.annotation.AnnotationValue.ForMismatchedType.load(java.lang.ClassLoader):net.bytebuddy.description.annotation.AnnotationValue$Loaded");
        }

        public String toString() {
            return "/* Warning type mismatch! \"" + this.value + "\" */";
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForMismatchedType$Loaded.class */
        public static class Loaded<W> extends Loaded.AbstractBase.ForUnresolvedProperty<W> {
            private final Method property;
            private final String value;

            public Loaded(Method property, String value) {
                this.property = property;
                this.value = value;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
            public W resolve() {
                throw new AnnotationTypeMismatchException(this.property, this.value);
            }

            public String toString() {
                return "/* Warning type mismatch! \"" + this.value + "\" */";
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForMissingValue.class */
    public static class ForMissingValue<U, V> extends AbstractBase<U, V> {
        private final TypeDescription typeDescription;
        private final String property;

        public ForMissingValue(TypeDescription typeDescription, String property) {
            this.typeDescription = typeDescription;
            this.property = property;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public State getState() {
            return State.UNDEFINED;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public Sort getSort() {
            return Sort.NONE;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public AnnotationValue<U, V> filter(MethodDescription.InDefinedShape property, TypeDefinition typeDefinition) {
            return this;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public Loaded<V> load(ClassLoader classLoader) {
            try {
                Class<?> cls = Class.forName(this.typeDescription.getName(), false, classLoader);
                return cls.isAnnotation() ? new Loaded(cls, this.property) : new ForIncompatibleType.Loaded(cls);
            } catch (ClassNotFoundException exception) {
                return new ForMissingType.Loaded(this.typeDescription.getName(), exception);
            }
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public U resolve() {
            throw new IllegalStateException(this.typeDescription + " does not define " + this.property);
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForMissingValue$Loaded.class */
        public static class Loaded<W> extends Loaded.AbstractBase<W> {
            private final Class<? extends Annotation> type;
            private final String property;

            public Loaded(Class<? extends Annotation> type, String property) {
                this.type = type;
                this.property = property;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
            public State getState() {
                return State.UNDEFINED;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
            public W resolve() {
                throw new IncompleteAnnotationException(this.type, this.property);
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
            public boolean represents(Object value) {
                return false;
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForIncompatibleType.class */
    public static class ForIncompatibleType<U, V> extends AbstractBase<U, V> {
        private final TypeDescription typeDescription;

        public ForIncompatibleType(TypeDescription typeDescription) {
            this.typeDescription = typeDescription;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public State getState() {
            return State.UNRESOLVED;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public Sort getSort() {
            return Sort.NONE;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public AnnotationValue<U, V> filter(MethodDescription.InDefinedShape property, TypeDefinition typeDefinition) {
            return this;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public U resolve() {
            throw new IllegalStateException("Property is defined with an incompatible runtime type: " + this.typeDescription);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationValue
        public Loaded<V> load(ClassLoader classLoader) {
            try {
                return new Loaded(Class.forName(this.typeDescription.getName(), false, classLoader));
            } catch (ClassNotFoundException exception) {
                return new ForMissingType.Loaded(this.typeDescription.getName(), exception);
            }
        }

        public String toString() {
            return "/* Warning type incompatibility! \"" + this.typeDescription.getName() + "\" */";
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationValue$ForIncompatibleType$Loaded.class */
        public static class Loaded<W> extends Loaded.AbstractBase.ForUnresolvedProperty<W> {
            private final Class<?> type;

            public Loaded(Class<?> type) {
                this.type = type;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationValue.Loaded
            public W resolve() {
                throw new IncompatibleClassChangeError(this.type.toString());
            }

            public String toString() {
                return "/* Warning type incompatibility! \"" + this.type.getName() + "\" */";
            }
        }
    }
}
