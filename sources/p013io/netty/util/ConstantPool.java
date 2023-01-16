package p013io.netty.util;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import p013io.netty.util.Constant;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.util.ConstantPool */
/* loaded from: grasscutter.jar:io/netty/util/ConstantPool.class */
public abstract class ConstantPool<T extends Constant<T>> {
    private final ConcurrentMap<String, T> constants = PlatformDependent.newConcurrentHashMap();
    private final AtomicInteger nextId = new AtomicInteger(1);

    protected abstract T newConstant(int i, String str);

    public T valueOf(Class<?> firstNameComponent, String secondNameComponent) {
        return valueOf(((Class) ObjectUtil.checkNotNull(firstNameComponent, "firstNameComponent")).getName() + '#' + ((String) ObjectUtil.checkNotNull(secondNameComponent, "secondNameComponent")));
    }

    public T valueOf(String name) {
        return getOrCreate(ObjectUtil.checkNonEmpty(name, "name"));
    }

    private T getOrCreate(String name) {
        T constant = this.constants.get(name);
        if (constant == null) {
            T tempConstant = newConstant(nextId(), name);
            constant = this.constants.putIfAbsent(name, tempConstant);
            if (constant == null) {
                return tempConstant;
            }
        }
        return constant;
    }

    public boolean exists(String name) {
        return this.constants.containsKey(ObjectUtil.checkNonEmpty(name, "name"));
    }

    public T newInstance(String name) {
        return createOrThrow(ObjectUtil.checkNonEmpty(name, "name"));
    }

    private T createOrThrow(String name) {
        if (this.constants.get(name) == null) {
            T tempConstant = newConstant(nextId(), name);
            if (this.constants.putIfAbsent(name, tempConstant) == null) {
                return tempConstant;
            }
        }
        throw new IllegalArgumentException(String.format("'%s' is already in use", name));
    }

    @Deprecated
    public final int nextId() {
        return this.nextId.getAndIncrement();
    }
}
