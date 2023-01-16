package p013io.github.classgraph;

import dev.morphia.mapping.Mapper;
import java.lang.reflect.Field;

/* renamed from: io.github.classgraph.AnnotationEnumValue */
/* loaded from: grasscutter.jar:io/github/classgraph/AnnotationEnumValue.class */
public class AnnotationEnumValue extends ScanResultObject implements Comparable<AnnotationEnumValue> {
    private String className;
    private String valueName;

    AnnotationEnumValue() {
    }

    /* access modifiers changed from: package-private */
    public AnnotationEnumValue(String className, String constValueName) {
        this.className = className;
        this.valueName = constValueName;
    }

    @Override // p013io.github.classgraph.ScanResultObject
    public String getClassName() {
        return this.className;
    }

    public String getValueName() {
        return this.valueName;
    }

    public String getName() {
        return this.className + Mapper.IGNORED_FIELDNAME + this.valueName;
    }

    public Object loadClassAndReturnEnumValue(boolean ignoreExceptions) throws IllegalArgumentException {
        Class<?> classRef = loadClass(ignoreExceptions);
        if (classRef == null) {
            if (ignoreExceptions) {
                return null;
            }
            throw new IllegalArgumentException("Enum class " + this.className + " could not be loaded");
        } else if (!classRef.isEnum()) {
            throw new IllegalArgumentException("Class " + this.className + " is not an enum");
        } else {
            try {
                Field field = classRef.getDeclaredField(this.valueName);
                if (!field.isEnumConstant()) {
                    throw new IllegalArgumentException("Field " + toString() + " is not an enum constant");
                }
                try {
                    return field.get(null);
                } catch (ReflectiveOperationException | SecurityException e) {
                    throw new IllegalArgumentException("Field " + toString() + " is not accessible", e);
                }
            } catch (ReflectiveOperationException | SecurityException e2) {
                throw new IllegalArgumentException("Could not find enum constant " + toString(), e2);
            }
        }
    }

    public Object loadClassAndReturnEnumValue() throws IllegalArgumentException {
        return loadClassAndReturnEnumValue(false);
    }

    public int compareTo(AnnotationEnumValue o) {
        int diff = this.className.compareTo(o.className);
        return diff == 0 ? this.valueName.compareTo(o.valueName) : diff;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof AnnotationEnumValue) && compareTo((AnnotationEnumValue) obj) == 0;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.className.hashCode() * 11) + this.valueName.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return this.className + Mapper.IGNORED_FIELDNAME + this.valueName;
    }
}
