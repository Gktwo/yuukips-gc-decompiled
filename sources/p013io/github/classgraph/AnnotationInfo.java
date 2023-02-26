package p013io.github.classgraph;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.jline.console.Printer;

/* renamed from: io.github.classgraph.AnnotationInfo */
/* loaded from: grasscutter.jar:io/github/classgraph/AnnotationInfo.class */
public class AnnotationInfo extends ScanResultObject implements Comparable<AnnotationInfo>, HasName {
    private String name;
    private AnnotationParameterValueList annotationParamValues;
    private transient boolean annotationParamValuesHasBeenConvertedToPrimitive;
    private transient AnnotationParameterValueList annotationParamValuesWithDefaults;

    AnnotationInfo() {
    }

    /* access modifiers changed from: package-private */
    public AnnotationInfo(String name, AnnotationParameterValueList annotationParamValues) {
        this.name = name;
        this.annotationParamValues = annotationParamValues;
    }

    @Override // p013io.github.classgraph.HasName
    public String getName() {
        return this.name;
    }

    public boolean isInherited() {
        return getClassInfo().isInherited;
    }

    public AnnotationParameterValueList getDefaultParameterValues() {
        return getClassInfo().getAnnotationDefaultParameterValues();
    }

    public AnnotationParameterValueList getParameterValues() {
        if (this.annotationParamValuesWithDefaults == null) {
            ClassInfo classInfo = getClassInfo();
            if (classInfo == null) {
                return this.annotationParamValues == null ? AnnotationParameterValueList.EMPTY_LIST : this.annotationParamValues;
            }
            if (this.annotationParamValues != null && !this.annotationParamValuesHasBeenConvertedToPrimitive) {
                this.annotationParamValues.convertWrapperArraysToPrimitiveArrays(classInfo);
                this.annotationParamValuesHasBeenConvertedToPrimitive = true;
            }
            if (classInfo.annotationDefaultParamValues != null && !classInfo.annotationDefaultParamValuesHasBeenConvertedToPrimitive) {
                classInfo.annotationDefaultParamValues.convertWrapperArraysToPrimitiveArrays(classInfo);
                classInfo.annotationDefaultParamValuesHasBeenConvertedToPrimitive = true;
            }
            AnnotationParameterValueList defaultParamValues = classInfo.annotationDefaultParamValues;
            if (defaultParamValues != null || this.annotationParamValues != null) {
                if (defaultParamValues != null) {
                    if (this.annotationParamValues != null) {
                        Map<String, Object> allParamValues = new HashMap<>();
                        Iterator it = defaultParamValues.iterator();
                        while (it.hasNext()) {
                            AnnotationParameterValue defaultParamValue = (AnnotationParameterValue) it.next();
                            allParamValues.put(defaultParamValue.getName(), defaultParamValue.getValue());
                        }
                        Iterator it2 = this.annotationParamValues.iterator();
                        while (it2.hasNext()) {
                            AnnotationParameterValue annotationParamValue = (AnnotationParameterValue) it2.next();
                            allParamValues.put(annotationParamValue.getName(), annotationParamValue.getValue());
                        }
                        if (classInfo.methodInfo != null) {
                            this.annotationParamValuesWithDefaults = new AnnotationParameterValueList();
                            Iterator it3 = classInfo.methodInfo.iterator();
                            while (it3.hasNext()) {
                                String paramName = ((MethodInfo) it3.next()).getName();
                                char c = 65535;
                                switch (paramName.hashCode()) {
                                    case -1944711511:
                                        if (paramName.equals("<clinit>")) {
                                            c = 1;
                                            break;
                                        }
                                        break;
                                    case -1776922004:
                                        if (paramName.equals(Printer.TO_STRING)) {
                                            c = 4;
                                            break;
                                        }
                                        break;
                                    case -1295482945:
                                        if (paramName.equals("equals")) {
                                            c = 3;
                                            break;
                                        }
                                        break;
                                    case 147696667:
                                        if (paramName.equals("hashCode")) {
                                            c = 2;
                                            break;
                                        }
                                        break;
                                    case 1444986633:
                                        if (paramName.equals("annotationType")) {
                                            c = 5;
                                            break;
                                        }
                                        break;
                                    case 1818100338:
                                        if (paramName.equals("<init>")) {
                                            c = 0;
                                            break;
                                        }
                                        break;
                                }
                                switch (c) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                        break;
                                    default:
                                        Object paramValue = allParamValues.get(paramName);
                                        if (paramValue == null) {
                                            break;
                                        } else {
                                            this.annotationParamValuesWithDefaults.add(new AnnotationParameterValue(paramName, paramValue));
                                            break;
                                        }
                                }
                            }
                        } else {
                            throw new IllegalArgumentException("Could not find methods for annotation " + classInfo.getName());
                        }
                    } else {
                        return defaultParamValues;
                    }
                } else {
                    return this.annotationParamValues;
                }
            } else {
                return AnnotationParameterValueList.EMPTY_LIST;
            }
        }
        return this.annotationParamValuesWithDefaults;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.github.classgraph.ScanResultObject
    public String getClassName() {
        return this.name;
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ScanResultObject
    public void setScanResult(ScanResult scanResult) {
        setScanResult(scanResult);
        if (this.annotationParamValues != null) {
            Iterator it = this.annotationParamValues.iterator();
            while (it.hasNext()) {
                ((AnnotationParameterValue) it.next()).setScanResult(scanResult);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // p013io.github.classgraph.ScanResultObject
    public void findReferencedClassInfo(Map<String, ClassInfo> classNameToClassInfo, Set<ClassInfo> refdClassInfo) {
        findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
        if (this.annotationParamValues != null) {
            Iterator it = this.annotationParamValues.iterator();
            while (it.hasNext()) {
                ((AnnotationParameterValue) it.next()).findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
            }
        }
    }

    @Override // p013io.github.classgraph.ScanResultObject
    public ClassInfo getClassInfo() {
        return getClassInfo();
    }

    public Annotation loadClassAndInstantiate() {
        Class<? extends Annotation> annotationClass = getClassInfo().loadClass(Annotation.class);
        return (Annotation) Proxy.newProxyInstance(annotationClass.getClassLoader(), new Class[]{annotationClass}, new AnnotationInvocationHandler(annotationClass, this));
    }

    /* access modifiers changed from: private */
    /* renamed from: io.github.classgraph.AnnotationInfo$AnnotationInvocationHandler */
    /* loaded from: grasscutter.jar:io/github/classgraph/AnnotationInfo$AnnotationInvocationHandler.class */
    public static class AnnotationInvocationHandler implements InvocationHandler {
        private final Class<? extends Annotation> annotationClass;
        private final AnnotationInfo annotationInfo;
        private final Map<String, Object> annotationParameterValuesInstantiated = new HashMap();

        AnnotationInvocationHandler(Class<? extends Annotation> annotationClass, AnnotationInfo annotationInfo) {
            this.annotationClass = annotationClass;
            this.annotationInfo = annotationInfo;
            Iterator it = annotationInfo.getParameterValues().iterator();
            while (it.hasNext()) {
                AnnotationParameterValue apv = (AnnotationParameterValue) it.next();
                Object instantiatedValue = apv.instantiate(annotationInfo.getClassInfo());
                if (instantiatedValue == null) {
                    throw new IllegalArgumentException("Got null value for annotation parameter " + apv.getName() + " of annotation " + annotationInfo.getName());
                }
                this.annotationParameterValuesInstantiated.put(apv.getName(), instantiatedValue);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:33:0x00ba  */
        @Override // java.lang.reflect.InvocationHandler
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object invoke(java.lang.Object r6, java.lang.reflect.Method r7, java.lang.Object[] r8) {
            /*
            // Method dump skipped, instructions count: 1013
            */
            throw new UnsupportedOperationException("Method not decompiled: p013io.github.classgraph.AnnotationInfo.AnnotationInvocationHandler.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
        }
    }

    /* access modifiers changed from: package-private */
    public void convertWrapperArraysToPrimitiveArrays() {
        if (this.annotationParamValues != null) {
            this.annotationParamValues.convertWrapperArraysToPrimitiveArrays(getClassInfo());
        }
    }

    public int compareTo(AnnotationInfo o) {
        int diff = getName().compareTo(o.getName());
        if (diff != 0) {
            return diff;
        }
        if (this.annotationParamValues == null && o.annotationParamValues == null) {
            return 0;
        }
        if (this.annotationParamValues == null) {
            return -1;
        }
        if (o.annotationParamValues == null) {
            return 1;
        }
        int max = Math.max(this.annotationParamValues.size(), o.annotationParamValues.size());
        for (int i = 0; i < max; i++) {
            if (i >= this.annotationParamValues.size()) {
                return -1;
            }
            if (i >= o.annotationParamValues.size()) {
                return 1;
            }
            int diff2 = ((AnnotationParameterValue) this.annotationParamValues.get(i)).compareTo((AnnotationParameterValue) o.annotationParamValues.get(i));
            if (diff2 != 0) {
                return diff2;
            }
        }
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof AnnotationInfo) && compareTo((AnnotationInfo) obj) == 0;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int h = getName().hashCode();
        if (this.annotationParamValues != null) {
            Iterator it = this.annotationParamValues.iterator();
            while (it.hasNext()) {
                AnnotationParameterValue e = (AnnotationParameterValue) it.next();
                h = (h * 7) + (e.getName().hashCode() * 3) + e.getValue().hashCode();
            }
        }
        return h;
    }

    /* access modifiers changed from: package-private */
    public void toString(StringBuilder buf) {
        buf.append('@').append(getName());
        AnnotationParameterValueList paramVals = getParameterValues();
        if (!paramVals.isEmpty()) {
            buf.append('(');
            for (int i = 0; i < paramVals.size(); i++) {
                if (i > 0) {
                    buf.append(", ");
                }
                AnnotationParameterValue paramVal = (AnnotationParameterValue) paramVals.get(i);
                if (paramVals.size() > 1 || !"value".equals(paramVal.getName())) {
                    paramVal.toString(buf);
                } else {
                    paramVal.toStringParamValueOnly(buf);
                }
            }
            buf.append(')');
        }
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder buf = new StringBuilder();
        toString(buf);
        return buf.toString();
    }
}
