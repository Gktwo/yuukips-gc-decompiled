package org.bson.codecs.pojo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.codecs.configuration.CodecConfigurationException;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.quartz.jobs.p027ee.ejb.EJBInvokerJob;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/codecs/pojo/CreatorExecutable.class */
public final class CreatorExecutable<T> {
    private final Class<T> clazz;
    private final Constructor<T> constructor;
    private final Method method;
    private final List<BsonProperty> properties;
    private final Integer idPropertyIndex;
    private final List<Class<?>> parameterTypes;
    private final List<Type> parameterGenericTypes;

    /* access modifiers changed from: package-private */
    public CreatorExecutable(Class<T> clazz, Constructor<T> constructor) {
        this(clazz, constructor, null);
    }

    /* access modifiers changed from: package-private */
    public CreatorExecutable(Class<T> clazz, Method method) {
        this(clazz, null, method);
    }

    private CreatorExecutable(Class<T> clazz, Constructor<T> constructor, Method method) {
        this.properties = new ArrayList();
        this.parameterTypes = new ArrayList();
        this.parameterGenericTypes = new ArrayList();
        this.clazz = clazz;
        this.constructor = constructor;
        this.method = method;
        Integer idPropertyIndex = null;
        if (!(constructor == null && method == null)) {
            Class<?>[] paramTypes = constructor != null ? constructor.getParameterTypes() : method.getParameterTypes();
            Type[] genericParamTypes = constructor != null ? constructor.getGenericParameterTypes() : method.getGenericParameterTypes();
            this.parameterTypes.addAll(Arrays.asList(paramTypes));
            this.parameterGenericTypes.addAll(Arrays.asList(genericParamTypes));
            Annotation[][] parameterAnnotations = constructor != null ? constructor.getParameterAnnotations() : method.getParameterAnnotations();
            for (int i = 0; i < parameterAnnotations.length; i++) {
                Annotation[] parameterAnnotation = parameterAnnotations[i];
                int length = parameterAnnotation.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        Annotation annotation = parameterAnnotation[i2];
                        if (annotation.annotationType().equals(BsonProperty.class)) {
                            this.properties.add((BsonProperty) annotation);
                            break;
                        } else if (annotation.annotationType().equals(BsonId.class)) {
                            this.properties.add(null);
                            idPropertyIndex = Integer.valueOf(i);
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
        }
        this.idPropertyIndex = idPropertyIndex;
    }

    /* access modifiers changed from: package-private */
    public Class<T> getType() {
        return this.clazz;
    }

    /* access modifiers changed from: package-private */
    public List<BsonProperty> getProperties() {
        return this.properties;
    }

    /* access modifiers changed from: package-private */
    public Integer getIdPropertyIndex() {
        return this.idPropertyIndex;
    }

    /* access modifiers changed from: package-private */
    public List<Class<?>> getParameterTypes() {
        return this.parameterTypes;
    }

    /* access modifiers changed from: package-private */
    public List<Type> getParameterGenericTypes() {
        return this.parameterGenericTypes;
    }

    /* access modifiers changed from: package-private */
    public T getInstance() {
        checkHasAnExecutable();
        try {
            if (this.constructor != null) {
                return this.constructor.newInstance(new Object[0]);
            }
            return (T) this.method.invoke(this.clazz, new Object[0]);
        } catch (Exception e) {
            throw new CodecConfigurationException(e.getMessage(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public T getInstance(Object[] params) {
        checkHasAnExecutable();
        try {
            if (this.constructor != null) {
                return this.constructor.newInstance(params);
            }
            return (T) this.method.invoke(this.clazz, params);
        } catch (Exception e) {
            throw new CodecConfigurationException(e.getMessage(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public CodecConfigurationException getError(Class<?> clazz, String msg) {
        return getError(clazz, this.constructor != null, msg);
    }

    private void checkHasAnExecutable() {
        if (this.constructor == null && this.method == null) {
            throw new CodecConfigurationException(String.format("Cannot find a public constructor for '%s'.", this.clazz.getSimpleName()));
        }
    }

    private static CodecConfigurationException getError(Class<?> clazz, boolean isConstructor, String msg) {
        Object[] objArr = new Object[3];
        objArr[0] = isConstructor ? "constructor" : EJBInvokerJob.EJB_METHOD_KEY;
        objArr[1] = clazz.getSimpleName();
        objArr[2] = msg;
        return new CodecConfigurationException(String.format("Invalid @BsonCreator %s in %s. %s", objArr));
    }
}
