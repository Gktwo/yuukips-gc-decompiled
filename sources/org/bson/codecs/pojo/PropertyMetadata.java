package org.bson.codecs.pojo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.codecs.configuration.CodecConfigurationException;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/codecs/pojo/PropertyMetadata.class */
public final class PropertyMetadata<T> {
    private final String name;
    private final String declaringClassName;
    private final TypeData<T> typeData;
    private final Map<Class<? extends Annotation>, Annotation> readAnnotations = new HashMap();
    private final Map<Class<? extends Annotation>, Annotation> writeAnnotations = new HashMap();
    private TypeParameterMap typeParameterMap;
    private List<TypeData<?>> typeParameters;
    private String error;
    private Field field;
    private Method getter;
    private Method setter;

    /* access modifiers changed from: package-private */
    public PropertyMetadata(String name, String declaringClassName, TypeData<T> typeData) {
        this.name = name;
        this.declaringClassName = declaringClassName;
        this.typeData = typeData;
    }

    public String getName() {
        return this.name;
    }

    public List<Annotation> getReadAnnotations() {
        return new ArrayList(this.readAnnotations.values());
    }

    public PropertyMetadata<T> addReadAnnotation(Annotation annotation) {
        if (!this.readAnnotations.containsKey(annotation.annotationType())) {
            this.readAnnotations.put(annotation.annotationType(), annotation);
            return this;
        } else if (annotation.equals(this.readAnnotations.get(annotation.annotationType()))) {
            return this;
        } else {
            throw new CodecConfigurationException(String.format("Read annotation %s for '%s' already exists in %s", annotation.annotationType(), this.name, this.declaringClassName));
        }
    }

    public List<Annotation> getWriteAnnotations() {
        return new ArrayList(this.writeAnnotations.values());
    }

    public PropertyMetadata<T> addWriteAnnotation(Annotation annotation) {
        if (!this.writeAnnotations.containsKey(annotation.annotationType())) {
            this.writeAnnotations.put(annotation.annotationType(), annotation);
            return this;
        } else if (annotation.equals(this.writeAnnotations.get(annotation.annotationType()))) {
            return this;
        } else {
            throw new CodecConfigurationException(String.format("Write annotation %s for '%s' already exists in %s", annotation.annotationType(), this.name, this.declaringClassName));
        }
    }

    public Field getField() {
        return this.field;
    }

    public PropertyMetadata<T> field(Field field) {
        this.field = field;
        return this;
    }

    public Method getGetter() {
        return this.getter;
    }

    public void setGetter(Method getter) {
        this.getter = getter;
    }

    public Method getSetter() {
        return this.setter;
    }

    public void setSetter(Method setter) {
        this.setter = setter;
    }

    public String getDeclaringClassName() {
        return this.declaringClassName;
    }

    public TypeData<T> getTypeData() {
        return this.typeData;
    }

    public TypeParameterMap getTypeParameterMap() {
        return this.typeParameterMap;
    }

    public List<TypeData<?>> getTypeParameters() {
        return this.typeParameters;
    }

    public <S> PropertyMetadata<T> typeParameterInfo(TypeParameterMap typeParameterMap, TypeData<S> parentTypeData) {
        if (!(typeParameterMap == null || parentTypeData == null)) {
            this.typeParameterMap = typeParameterMap;
            this.typeParameters = parentTypeData.getTypeParameters();
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public String getError() {
        return this.error;
    }

    /* access modifiers changed from: package-private */
    public void setError(String error) {
        this.error = error;
    }

    public boolean isSerializable() {
        return this.getter != null ? this.field == null || notStaticOrTransient(this.field.getModifiers()) : this.field != null && isPublicAndNotStaticOrTransient(this.field.getModifiers());
    }

    public boolean isDeserializable() {
        return this.setter != null ? this.field == null || (!Modifier.isFinal(this.field.getModifiers()) && notStaticOrTransient(this.field.getModifiers())) : this.field != null && !Modifier.isFinal(this.field.getModifiers()) && isPublicAndNotStaticOrTransient(this.field.getModifiers());
    }

    private boolean notStaticOrTransient(int modifiers) {
        return !Modifier.isTransient(modifiers) && !Modifier.isStatic(modifiers);
    }

    private boolean isPublicAndNotStaticOrTransient(int modifiers) {
        return Modifier.isPublic(modifiers) && notStaticOrTransient(modifiers);
    }

    public String toString() {
        return "PropertyMetadata{name='" + this.name + "', declaringClassName='" + this.declaringClassName + "', typeData=" + this.typeData + ", readAnnotations=" + this.readAnnotations + ", writeAnnotations=" + this.writeAnnotations + ", typeParameterMap=" + this.typeParameterMap + ", typeParameters=" + this.typeParameters + ", error='" + this.error + "', field=" + this.field + ", getter=" + this.getter + ", setter=" + this.setter + '}';
    }
}
