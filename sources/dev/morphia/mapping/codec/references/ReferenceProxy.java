package dev.morphia.mapping.codec.references;

import dev.morphia.annotations.IdGetter;
import dev.morphia.mapping.experimental.MorphiaReference;
import dev.morphia.mapping.lazy.proxy.ReferenceException;
import dev.morphia.sofia.Sofia;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/references/ReferenceProxy.class */
public class ReferenceProxy implements MorphiaProxy, InvocationHandler {
    private static final List<String> NONFETCHES = List.of("isEmpty", "size");
    private final MorphiaReference<?> reference;

    /* access modifiers changed from: package-private */
    public ReferenceProxy(MorphiaReference<?> reference) {
        this.reference = reference;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("isFetched")) {
            return Boolean.valueOf(isFetched());
        }
        if (method.getAnnotation(IdGetter.class) != null) {
            return this.reference.getIds().get(0);
        }
        if ("isEmpty".equals(method.getName())) {
            return isFetched() ? invoke(method, args) : Boolean.valueOf(this.reference.getIds().isEmpty());
        }
        if ("size".equals(method.getName())) {
            return isFetched() ? invoke(method, args) : Integer.valueOf(this.reference.getIds().size());
        }
        fetch(method);
        return invoke(method, args);
    }

    @Override // dev.morphia.mapping.codec.references.MorphiaProxy
    public boolean isFetched() {
        return this.reference.isResolved();
    }

    @Override // dev.morphia.mapping.codec.references.MorphiaProxy
    public <T> T unwrap() {
        return (T) this.reference.get();
    }

    private Object invoke(Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        if (method.getDeclaringClass().isAssignableFrom(getClass())) {
            return method.invoke(this, args);
        }
        if (!isFetched()) {
            return method.invoke(this.reference.getIds(), args);
        }
        Object target = this.reference.get();
        if (target != null) {
            return method.invoke(target, args);
        }
        throw new ReferenceException(Sofia.missingReferencedEntity(this.reference.getType(), new Locale[0]));
    }

    private void fetch(Method method) {
        if (!isFetched() && !NONFETCHES.contains(method.getName())) {
            this.reference.get();
        }
    }
}
