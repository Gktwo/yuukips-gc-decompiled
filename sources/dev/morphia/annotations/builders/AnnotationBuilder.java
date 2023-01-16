package dev.morphia.annotations.builders;

import dev.morphia.mapping.MappingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: grasscutter.jar:dev/morphia/annotations/builders/AnnotationBuilder.class */
public abstract class AnnotationBuilder<T extends Annotation> implements Annotation {
    private final Map<String, Object> values = new HashMap();

    @Override // java.lang.annotation.Annotation
    public abstract Class<T> annotationType();

    /* access modifiers changed from: protected */
    public AnnotationBuilder() {
        Method[] declaredMethods = annotationType().getDeclaredMethods();
        for (Method method : declaredMethods) {
            this.values.put(method.getName(), method.getDefaultValue());
        }
    }

    /* access modifiers changed from: protected */
    public AnnotationBuilder(T original) {
        try {
            Method[] declaredMethods = annotationType().getDeclaredMethods();
            for (Method method : declaredMethods) {
                this.values.put(method.getName(), method.invoke(original, new Object[0]));
            }
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    protected <V> V get(String key) {
        return (V) this.values.get(key);
    }

    protected void put(String key, Object value) {
        if (value != null) {
            this.values.put(key, value);
        }
    }

    void putAll(Map<String, Object> map) {
        this.values.putAll(map);
    }

    @Override // java.lang.annotation.Annotation, java.lang.Object
    public String toString() {
        return String.format("@%s %s", annotationType().getName(), this.values);
    }

    static <A extends Annotation> Map<String, Object> toMap(A annotation) {
        Map<String, Object> map = new HashMap<>();
        try {
            Method[] declaredMethods = annotation.annotationType().getDeclaredMethods();
            for (Method method : declaredMethods) {
                Object value = unwrapAnnotation(method.invoke(annotation, new Object[0]));
                Object defaultValue = unwrapAnnotation(method.getDefaultValue());
                if (value != null && !value.equals(defaultValue)) {
                    map.put(method.getName(), value);
                }
            }
            return map;
        } catch (Exception e) {
            throw new MappingException(e.getMessage(), e);
        }
    }

    private static Object unwrapAnnotation(Object o) {
        if (o instanceof Annotation) {
            return toMap((Annotation) o);
        }
        return o;
    }

    @Override // java.lang.annotation.Annotation, java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AnnotationBuilder)) {
            return false;
        }
        return this.values.equals(((AnnotationBuilder) o).values);
    }

    @Override // java.lang.annotation.Annotation, java.lang.Object
    public int hashCode() {
        return this.values.hashCode();
    }
}
