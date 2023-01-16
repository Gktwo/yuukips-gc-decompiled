package p013io.github.classgraph;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* access modifiers changed from: package-private */
/* renamed from: io.github.classgraph.ObjectTypedValueWrapper */
/* loaded from: grasscutter.jar:io/github/classgraph/ObjectTypedValueWrapper.class */
public class ObjectTypedValueWrapper extends ScanResultObject {
    private AnnotationEnumValue annotationEnumValue;
    private AnnotationClassRef annotationClassRef;
    private AnnotationInfo annotationInfo;
    private String stringValue;
    private Integer integerValue;
    private Long longValue;
    private Short shortValue;
    private Boolean booleanValue;
    private Character characterValue;
    private Float floatValue;
    private Double doubleValue;
    private Byte byteValue;
    private String[] stringArrayValue;
    private int[] intArrayValue;
    private long[] longArrayValue;
    private short[] shortArrayValue;
    private boolean[] booleanArrayValue;
    private char[] charArrayValue;
    private float[] floatArrayValue;
    private double[] doubleArrayValue;
    private byte[] byteArrayValue;
    private ObjectTypedValueWrapper[] objectArrayValue;

    public ObjectTypedValueWrapper() {
    }

    public ObjectTypedValueWrapper(Object annotationParamValue) {
        if (annotationParamValue != null) {
            Class<?> annotationParameterValueClass = annotationParamValue.getClass();
            if (annotationParameterValueClass.isArray()) {
                if (annotationParameterValueClass == String[].class) {
                    this.stringArrayValue = (String[]) annotationParamValue;
                } else if (annotationParameterValueClass == int[].class) {
                    this.intArrayValue = (int[]) annotationParamValue;
                } else if (annotationParameterValueClass == long[].class) {
                    this.longArrayValue = (long[]) annotationParamValue;
                } else if (annotationParameterValueClass == short[].class) {
                    this.shortArrayValue = (short[]) annotationParamValue;
                } else if (annotationParameterValueClass == boolean[].class) {
                    this.booleanArrayValue = (boolean[]) annotationParamValue;
                } else if (annotationParameterValueClass == char[].class) {
                    this.charArrayValue = (char[]) annotationParamValue;
                } else if (annotationParameterValueClass == float[].class) {
                    this.floatArrayValue = (float[]) annotationParamValue;
                } else if (annotationParameterValueClass == double[].class) {
                    this.doubleArrayValue = (double[]) annotationParamValue;
                } else if (annotationParameterValueClass == byte[].class) {
                    this.byteArrayValue = (byte[]) annotationParamValue;
                } else {
                    int n = Array.getLength(annotationParamValue);
                    this.objectArrayValue = new ObjectTypedValueWrapper[n];
                    for (int i = 0; i < n; i++) {
                        this.objectArrayValue[i] = new ObjectTypedValueWrapper(Array.get(annotationParamValue, i));
                    }
                }
            } else if (annotationParamValue instanceof AnnotationEnumValue) {
                this.annotationEnumValue = (AnnotationEnumValue) annotationParamValue;
            } else if (annotationParamValue instanceof AnnotationClassRef) {
                this.annotationClassRef = (AnnotationClassRef) annotationParamValue;
            } else if (annotationParamValue instanceof AnnotationInfo) {
                this.annotationInfo = (AnnotationInfo) annotationParamValue;
            } else if (annotationParamValue instanceof String) {
                this.stringValue = (String) annotationParamValue;
            } else if (annotationParamValue instanceof Integer) {
                this.integerValue = (Integer) annotationParamValue;
            } else if (annotationParamValue instanceof Long) {
                this.longValue = (Long) annotationParamValue;
            } else if (annotationParamValue instanceof Short) {
                this.shortValue = (Short) annotationParamValue;
            } else if (annotationParamValue instanceof Boolean) {
                this.booleanValue = (Boolean) annotationParamValue;
            } else if (annotationParamValue instanceof Character) {
                this.characterValue = (Character) annotationParamValue;
            } else if (annotationParamValue instanceof Float) {
                this.floatValue = (Float) annotationParamValue;
            } else if (annotationParamValue instanceof Double) {
                this.doubleValue = (Double) annotationParamValue;
            } else if (annotationParamValue instanceof Byte) {
                this.byteValue = (Byte) annotationParamValue;
            } else {
                throw new IllegalArgumentException("Unsupported annotation parameter value type: " + annotationParameterValueClass.getName());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Object instantiateOrGet(ClassInfo annotationClassInfo, String paramName) {
        boolean instantiate = annotationClassInfo != null;
        if (this.annotationEnumValue != null) {
            return instantiate ? this.annotationEnumValue.loadClassAndReturnEnumValue() : this.annotationEnumValue;
        }
        if (this.annotationClassRef != null) {
            return instantiate ? this.annotationClassRef.loadClass() : this.annotationClassRef;
        }
        if (this.annotationInfo != null) {
            return instantiate ? this.annotationInfo.loadClassAndInstantiate() : this.annotationInfo;
        }
        if (this.stringValue != null) {
            return this.stringValue;
        }
        if (this.integerValue != null) {
            return this.integerValue;
        }
        if (this.longValue != null) {
            return this.longValue;
        }
        if (this.shortValue != null) {
            return this.shortValue;
        }
        if (this.booleanValue != null) {
            return this.booleanValue;
        }
        if (this.characterValue != null) {
            return this.characterValue;
        }
        if (this.floatValue != null) {
            return this.floatValue;
        }
        if (this.doubleValue != null) {
            return this.doubleValue;
        }
        if (this.byteValue != null) {
            return this.byteValue;
        }
        if (this.stringArrayValue != null) {
            return this.stringArrayValue;
        }
        if (this.intArrayValue != null) {
            return this.intArrayValue;
        }
        if (this.longArrayValue != null) {
            return this.longArrayValue;
        }
        if (this.shortArrayValue != null) {
            return this.shortArrayValue;
        }
        if (this.booleanArrayValue != null) {
            return this.booleanArrayValue;
        }
        if (this.charArrayValue != null) {
            return this.charArrayValue;
        }
        if (this.floatArrayValue != null) {
            return this.floatArrayValue;
        }
        if (this.doubleArrayValue != null) {
            return this.doubleArrayValue;
        }
        if (this.byteArrayValue != null) {
            return this.byteArrayValue;
        }
        if (this.objectArrayValue == null) {
            return null;
        }
        Class<?> eltClass = instantiate ? (Class) getArrayValueClassOrName(annotationClassInfo, paramName, true) : null;
        Object annotationValueObjectArray = eltClass == null ? new Object[this.objectArrayValue.length] : Array.newInstance(eltClass, this.objectArrayValue.length);
        for (int i = 0; i < this.objectArrayValue.length; i++) {
            if (this.objectArrayValue[i] != null) {
                Array.set(annotationValueObjectArray, i, this.objectArrayValue[i].instantiateOrGet(annotationClassInfo, paramName));
            }
        }
        return annotationValueObjectArray;
    }

    public Object get() {
        return instantiateOrGet(null, null);
    }

    private Object getArrayValueClassOrName(ClassInfo annotationClassInfo, String paramName, boolean getClass) {
        MethodInfoList annotationMethodList = (annotationClassInfo == null || annotationClassInfo.methodInfo == null) ? null : annotationClassInfo.methodInfo.get(paramName);
        if (annotationClassInfo == null || annotationMethodList == null || annotationMethodList.isEmpty()) {
            ObjectTypedValueWrapper[] objectTypedValueWrapperArr = this.objectArrayValue;
            for (ObjectTypedValueWrapper elt : objectTypedValueWrapperArr) {
                if (elt != null) {
                    if (elt.integerValue != null) {
                        return getClass ? Integer.class : "int";
                    } else {
                        if (elt.longValue != null) {
                            return getClass ? Long.class : "long";
                        }
                        if (elt.shortValue != null) {
                            return getClass ? Short.class : "short";
                        }
                        if (elt.characterValue != null) {
                            return getClass ? Character.class : "char";
                        }
                        if (elt.byteValue != null) {
                            return getClass ? Byte.class : "byte";
                        }
                        if (elt.booleanValue != null) {
                            return getClass ? Boolean.class : "boolean";
                        }
                        if (elt.doubleValue != null) {
                            return getClass ? Double.class : "double";
                        }
                        if (elt.floatValue != null) {
                            return getClass ? Float.class : "float";
                        }
                        if (getClass) {
                            return elt.getClass();
                        }
                        return elt.getClass().getName();
                    }
                }
            }
        } else if (annotationMethodList.size() > 1) {
            throw new IllegalArgumentException("Duplicated annotation parameter method " + paramName + "() in annotation class " + annotationClassInfo.getName());
        } else {
            TypeSignature annotationMethodResultTypeSig = ((MethodInfo) annotationMethodList.get(0)).getTypeSignatureOrTypeDescriptor().getResultType();
            if (!(annotationMethodResultTypeSig instanceof ArrayTypeSignature)) {
                throw new IllegalArgumentException("Annotation parameter " + paramName + " in annotation class " + annotationClassInfo.getName() + " holds an array, but does not have an array type signature");
            }
            ArrayTypeSignature arrayTypeSig = (ArrayTypeSignature) annotationMethodResultTypeSig;
            if (arrayTypeSig.getNumDimensions() != 1) {
                throw new IllegalArgumentException("Annotations only support 1-dimensional arrays");
            }
            TypeSignature elementTypeSig = arrayTypeSig.getElementTypeSignature();
            if (elementTypeSig instanceof ClassRefTypeSignature) {
                ClassRefTypeSignature classRefTypeSignature = (ClassRefTypeSignature) elementTypeSig;
                return getClass ? classRefTypeSignature.loadClass() : classRefTypeSignature.getFullyQualifiedClassName();
            } else if (elementTypeSig instanceof BaseTypeSignature) {
                BaseTypeSignature baseTypeSignature = (BaseTypeSignature) elementTypeSig;
                return getClass ? baseTypeSignature.getType() : baseTypeSignature.getTypeStr();
            }
        }
        return getClass ? Object.class : "java.lang.Object";
    }

    /* access modifiers changed from: package-private */
    public void convertWrapperArraysToPrimitiveArrays(ClassInfo annotationClassInfo, String paramName) {
        if (this.annotationInfo != null) {
            this.annotationInfo.convertWrapperArraysToPrimitiveArrays();
        } else if (this.objectArrayValue != null) {
            ObjectTypedValueWrapper[] objectTypedValueWrapperArr = this.objectArrayValue;
            for (ObjectTypedValueWrapper elt : objectTypedValueWrapperArr) {
                if (elt.annotationInfo != null) {
                    elt.annotationInfo.convertWrapperArraysToPrimitiveArrays();
                }
            }
            if (!this.objectArrayValue.getClass().getComponentType().isArray()) {
                String targetElementTypeName = (String) getArrayValueClassOrName(annotationClassInfo, paramName, false);
                char c = 65535;
                switch (targetElementTypeName.hashCode()) {
                    case -1325958191:
                        if (targetElementTypeName.equals("double")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 104431:
                        if (targetElementTypeName.equals("int")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 3039496:
                        if (targetElementTypeName.equals("byte")) {
                            c = '\b';
                            break;
                        }
                        break;
                    case 3052374:
                        if (targetElementTypeName.equals("char")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 3327612:
                        if (targetElementTypeName.equals("long")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 64711720:
                        if (targetElementTypeName.equals("boolean")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 97526364:
                        if (targetElementTypeName.equals("float")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 109413500:
                        if (targetElementTypeName.equals("short")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 1195259493:
                        if (targetElementTypeName.equals("java.lang.String")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.stringArrayValue = new String[this.objectArrayValue.length];
                        for (int j = 0; j < this.objectArrayValue.length; j++) {
                            this.stringArrayValue[j] = this.objectArrayValue[j].stringValue;
                        }
                        this.objectArrayValue = null;
                        return;
                    case 1:
                        this.intArrayValue = new int[this.objectArrayValue.length];
                        for (int j2 = 0; j2 < this.objectArrayValue.length; j2++) {
                            if (this.objectArrayValue[j2] == null) {
                                throw new IllegalArgumentException("Illegal null value for array of element type " + targetElementTypeName + " in parameter " + paramName + " of annotation class " + (annotationClassInfo == null ? "<class outside whitelist>" : annotationClassInfo.getName()));
                            }
                            this.intArrayValue[j2] = this.objectArrayValue[j2].integerValue.intValue();
                        }
                        this.objectArrayValue = null;
                        return;
                    case 2:
                        this.longArrayValue = new long[this.objectArrayValue.length];
                        for (int j3 = 0; j3 < this.objectArrayValue.length; j3++) {
                            if (this.objectArrayValue[j3] == null) {
                                throw new IllegalArgumentException("Illegal null value for array of element type " + targetElementTypeName + " in parameter " + paramName + " of annotation class " + (annotationClassInfo == null ? "<class outside whitelist>" : annotationClassInfo.getName()));
                            }
                            this.longArrayValue[j3] = this.objectArrayValue[j3].longValue.longValue();
                        }
                        this.objectArrayValue = null;
                        return;
                    case 3:
                        this.shortArrayValue = new short[this.objectArrayValue.length];
                        for (int j4 = 0; j4 < this.objectArrayValue.length; j4++) {
                            if (this.objectArrayValue[j4] == null) {
                                throw new IllegalArgumentException("Illegal null value for array of element type " + targetElementTypeName + " in parameter " + paramName + " of annotation class " + (annotationClassInfo == null ? "<class outside whitelist>" : annotationClassInfo.getName()));
                            }
                            this.shortArrayValue[j4] = this.objectArrayValue[j4].shortValue.shortValue();
                        }
                        this.objectArrayValue = null;
                        return;
                    case 4:
                        this.charArrayValue = new char[this.objectArrayValue.length];
                        for (int j5 = 0; j5 < this.objectArrayValue.length; j5++) {
                            if (this.objectArrayValue[j5] == null) {
                                throw new IllegalArgumentException("Illegal null value for array of element type " + targetElementTypeName + " in parameter " + paramName + " of annotation class " + (annotationClassInfo == null ? "<class outside whitelist>" : annotationClassInfo.getName()));
                            }
                            this.charArrayValue[j5] = this.objectArrayValue[j5].characterValue.charValue();
                        }
                        this.objectArrayValue = null;
                        return;
                    case 5:
                        this.floatArrayValue = new float[this.objectArrayValue.length];
                        for (int j6 = 0; j6 < this.objectArrayValue.length; j6++) {
                            if (this.objectArrayValue[j6] == null) {
                                throw new IllegalArgumentException("Illegal null value for array of element type " + targetElementTypeName + " in parameter " + paramName + " of annotation class " + (annotationClassInfo == null ? "<class outside whitelist>" : annotationClassInfo.getName()));
                            }
                            this.floatArrayValue[j6] = this.objectArrayValue[j6].floatValue.floatValue();
                        }
                        this.objectArrayValue = null;
                        return;
                    case 6:
                        this.doubleArrayValue = new double[this.objectArrayValue.length];
                        for (int j7 = 0; j7 < this.objectArrayValue.length; j7++) {
                            if (this.objectArrayValue[j7] == null) {
                                throw new IllegalArgumentException("Illegal null value for array of element type " + targetElementTypeName + " in parameter " + paramName + " of annotation class " + (annotationClassInfo == null ? "<class outside whitelist>" : annotationClassInfo.getName()));
                            }
                            this.doubleArrayValue[j7] = this.objectArrayValue[j7].doubleValue.doubleValue();
                        }
                        this.objectArrayValue = null;
                        return;
                    case 7:
                        this.booleanArrayValue = new boolean[this.objectArrayValue.length];
                        for (int j8 = 0; j8 < this.objectArrayValue.length; j8++) {
                            if (this.objectArrayValue[j8] == null) {
                                throw new IllegalArgumentException("Illegal null value for array of element type " + targetElementTypeName + " in parameter " + paramName + " of annotation class " + (annotationClassInfo == null ? "<class outside whitelist>" : annotationClassInfo.getName()));
                            }
                            this.booleanArrayValue[j8] = this.objectArrayValue[j8].booleanValue.booleanValue();
                        }
                        this.objectArrayValue = null;
                        return;
                    case '\b':
                        this.byteArrayValue = new byte[this.objectArrayValue.length];
                        for (int j9 = 0; j9 < this.objectArrayValue.length; j9++) {
                            if (this.objectArrayValue[j9] == null) {
                                throw new IllegalArgumentException("Illegal null value for array of element type " + targetElementTypeName + " in parameter " + paramName + " of annotation class " + (annotationClassInfo == null ? "<class outside whitelist>" : annotationClassInfo.getName()));
                            }
                            this.byteArrayValue[j9] = this.objectArrayValue[j9].byteValue.byteValue();
                        }
                        this.objectArrayValue = null;
                        return;
                    default:
                        return;
                }
            }
        }
    }

    @Override // p013io.github.classgraph.ScanResultObject
    protected String getClassName() {
        throw new IllegalArgumentException("getClassName() cannot be called here");
    }

    /* access modifiers changed from: protected */
    @Override // p013io.github.classgraph.ScanResultObject
    public ClassInfo getClassInfo() {
        throw new IllegalArgumentException("getClassInfo() cannot be called here");
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ScanResultObject
    public void setScanResult(ScanResult scanResult) {
        setScanResult(scanResult);
        if (this.annotationEnumValue != null) {
            this.annotationEnumValue.setScanResult(scanResult);
        } else if (this.annotationClassRef != null) {
            this.annotationClassRef.setScanResult(scanResult);
        } else if (this.annotationInfo != null) {
            this.annotationInfo.setScanResult(scanResult);
        } else if (this.objectArrayValue != null) {
            ObjectTypedValueWrapper[] objectTypedValueWrapperArr = this.objectArrayValue;
            for (ObjectTypedValueWrapper anObjectArrayValue : objectTypedValueWrapperArr) {
                if (anObjectArrayValue != null) {
                    anObjectArrayValue.setScanResult(scanResult);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // p013io.github.classgraph.ScanResultObject
    public void findReferencedClassInfo(Map<String, ClassInfo> classNameToClassInfo, Set<ClassInfo> refdClassInfo) {
        if (this.annotationEnumValue != null) {
            this.annotationEnumValue.findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
        } else if (this.annotationClassRef != null) {
            ClassInfo classInfo = this.annotationClassRef.getClassInfo();
            if (classInfo != null) {
                refdClassInfo.add(classInfo);
            }
        } else if (this.annotationInfo != null) {
            this.annotationInfo.findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
        } else if (this.objectArrayValue != null) {
            for (ObjectTypedValueWrapper item : this.objectArrayValue) {
                item.findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
            }
        }
    }

    public int hashCode() {
        return Objects.hash(this.annotationEnumValue, this.annotationClassRef, this.annotationInfo, this.stringValue, this.integerValue, this.longValue, this.shortValue, this.booleanValue, this.characterValue, this.floatValue, this.doubleValue, this.byteValue, Integer.valueOf(Arrays.hashCode(this.stringArrayValue)), Integer.valueOf(Arrays.hashCode(this.intArrayValue)), Integer.valueOf(Arrays.hashCode(this.longArrayValue)), Integer.valueOf(Arrays.hashCode(this.shortArrayValue)), Integer.valueOf(Arrays.hashCode(this.booleanArrayValue)), Integer.valueOf(Arrays.hashCode(this.charArrayValue)), Integer.valueOf(Arrays.hashCode(this.floatArrayValue)), Integer.valueOf(Arrays.hashCode(this.doubleArrayValue)), Integer.valueOf(Arrays.hashCode(this.byteArrayValue)), Integer.valueOf(Arrays.hashCode(this.objectArrayValue)));
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ObjectTypedValueWrapper)) {
            return false;
        }
        ObjectTypedValueWrapper o = (ObjectTypedValueWrapper) other;
        return Objects.equals(this.annotationEnumValue, o.annotationEnumValue) && Objects.equals(this.annotationClassRef, o.annotationClassRef) && Objects.equals(this.annotationInfo, o.annotationInfo) && Objects.equals(this.stringValue, o.stringValue) && Objects.equals(this.integerValue, o.integerValue) && Objects.equals(this.longValue, o.longValue) && Objects.equals(this.shortValue, o.shortValue) && Objects.equals(this.booleanValue, o.booleanValue) && Objects.equals(this.characterValue, o.characterValue) && Objects.equals(this.floatValue, o.floatValue) && Objects.equals(this.doubleValue, o.doubleValue) && Objects.equals(this.byteValue, o.byteValue) && Arrays.equals(this.stringArrayValue, o.stringArrayValue) && Arrays.equals(this.intArrayValue, o.intArrayValue) && Arrays.equals(this.longArrayValue, o.longArrayValue) && Arrays.equals(this.shortArrayValue, o.shortArrayValue) && Arrays.equals(this.floatArrayValue, o.floatArrayValue) && Arrays.equals(this.byteArrayValue, o.byteArrayValue) && Arrays.deepEquals(this.objectArrayValue, o.objectArrayValue);
    }
}
