package dev.morphia.mapping.codec.pojo;

import com.mongodb.lang.Nullable;
import dev.morphia.Datastore;
import dev.morphia.mapping.MappingException;
import dev.morphia.sofia.Sofia;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/pojo/ClassMethodPair.class */
public class ClassMethodPair {
    private final Class<?> type;
    private final Method method;
    private final Datastore datastore;
    private final Class<? extends Annotation> event;

    /* access modifiers changed from: package-private */
    public ClassMethodPair(Datastore datastore, Method method, @Nullable Class<?> type, Class<? extends Annotation> event) {
        this.event = event;
        this.type = type;
        this.method = method;
        this.datastore = datastore;
    }

    /* access modifiers changed from: package-private */
    public void invoke(Document document, Object entity) {
        Object instance;
        try {
            if (this.type != null) {
                instance = getOrCreateInstance(this.type);
            } else {
                instance = entity;
            }
            Method method = getMethod();
            method.setAccessible(true);
            Sofia.logCallingLifecycleMethod(this.event.getSimpleName(), method, instance, new Locale[0]);
            List<Object> args = new ArrayList<>();
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                if (parameterType.equals(Document.class)) {
                    args.add(document);
                } else if (parameterType.equals(Datastore.class)) {
                    args.add(this.datastore);
                } else {
                    args.add(entity);
                }
            }
            method.invoke(instance, args.toArray());
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    private Object getOrCreateInstance(Class<?> type) {
        try {
            Constructor<?> declaredConstructor = type.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(new Object[0]);
        } catch (ReflectiveOperationException e) {
            throw new MappingException(Sofia.cannotInstantiate(type, e.getMessage(), new Locale[0]));
        }
    }

    public Method getMethod() {
        return this.method;
    }
}
