package p013io.github.classgraph;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* renamed from: io.github.classgraph.AnnotationParameterValue */
/* loaded from: grasscutter.jar:io/github/classgraph/AnnotationParameterValue.class */
public class AnnotationParameterValue extends ScanResultObject implements HasName, Comparable<AnnotationParameterValue> {
    private String name;
    private ObjectTypedValueWrapper value;

    AnnotationParameterValue() {
    }

    /* access modifiers changed from: package-private */
    public AnnotationParameterValue(String name, Object value) {
        this.name = name;
        this.value = new ObjectTypedValueWrapper(value);
    }

    @Override // p013io.github.classgraph.HasName
    public String getName() {
        return this.name;
    }

    public Object getValue() {
        if (this.value == null) {
            return null;
        }
        return this.value.get();
    }

    void setValue(Object newValue) {
        this.value = new ObjectTypedValueWrapper(newValue);
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
        if (this.value != null) {
            this.value.setScanResult(scanResult);
        }
    }

    /* access modifiers changed from: protected */
    @Override // p013io.github.classgraph.ScanResultObject
    public void findReferencedClassInfo(Map<String, ClassInfo> classNameToClassInfo, Set<ClassInfo> refdClassInfo) {
        if (this.value != null) {
            this.value.findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
        }
    }

    /* access modifiers changed from: package-private */
    public void convertWrapperArraysToPrimitiveArrays(ClassInfo annotationClassInfo) {
        if (this.value != null) {
            this.value.convertWrapperArraysToPrimitiveArrays(annotationClassInfo, this.name);
        }
    }

    /* access modifiers changed from: package-private */
    public Object instantiate(ClassInfo annotationClassInfo) {
        return this.value.instantiateOrGet(annotationClassInfo, this.name);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder buf = new StringBuilder();
        toString(buf);
        return buf.toString();
    }

    /* access modifiers changed from: package-private */
    public void toString(StringBuilder buf) {
        buf.append(this.name);
        buf.append("=");
        toStringParamValueOnly(buf);
    }

    /* access modifiers changed from: package-private */
    public void toStringParamValueOnly(StringBuilder buf) {
        if (this.value == null) {
            buf.append("null");
            return;
        }
        Object paramVal = this.value.get();
        if (paramVal.getClass().isArray()) {
            buf.append('{');
            int n = Array.getLength(paramVal);
            for (int j = 0; j < n; j++) {
                if (j > 0) {
                    buf.append(", ");
                }
                Object elt = Array.get(paramVal, j);
                buf.append(elt == null ? "null" : elt.toString());
            }
            buf.append('}');
        } else if (paramVal instanceof String) {
            buf.append('\"');
            buf.append(paramVal.toString().replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r"));
            buf.append('\"');
        } else if (paramVal instanceof Character) {
            buf.append('\'');
            buf.append(paramVal.toString().replace("'", "\\'").replace("\n", "\\n").replace("\r", "\\r"));
            buf.append('\'');
        } else {
            buf.append(paramVal.toString());
        }
    }

    private String toStringParamValueOnly() {
        StringBuilder buf = new StringBuilder();
        toStringParamValueOnly(buf);
        return buf.toString();
    }

    public int compareTo(AnnotationParameterValue other) {
        if (other == this) {
            return 0;
        }
        int diff = this.name.compareTo(other.getName());
        if (diff != 0) {
            return diff;
        }
        if (this.value.equals(other.value)) {
            return 0;
        }
        Object p0 = getValue();
        Object p1 = other.getValue();
        if (p0 != null && p1 != null) {
            return toStringParamValueOnly().compareTo(other.toStringParamValueOnly());
        }
        return (p0 == null ? 0 : 1) - (p1 == null ? 0 : 1);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AnnotationParameterValue)) {
            return false;
        }
        AnnotationParameterValue other = (AnnotationParameterValue) obj;
        if (this.name.equals(other.name)) {
            if ((this.value == null) == (other.value == null) && (this.value == null || this.value.equals(other.value))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Objects.hash(this.name, this.value);
    }
}
