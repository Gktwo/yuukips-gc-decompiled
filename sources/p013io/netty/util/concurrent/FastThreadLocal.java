package p013io.netty.util.concurrent;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import p013io.netty.util.internal.InternalThreadLocalMap;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.util.concurrent.FastThreadLocal */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/FastThreadLocal.class */
public class FastThreadLocal<V> {
    private static final int variablesToRemoveIndex = InternalThreadLocalMap.nextVariableIndex();
    private final int index = InternalThreadLocalMap.nextVariableIndex();

    public static void removeAll() {
        InternalThreadLocalMap threadLocalMap = InternalThreadLocalMap.getIfSet();
        if (threadLocalMap != null) {
            try {
                Object v = threadLocalMap.indexedVariable(variablesToRemoveIndex);
                if (!(v == null || v == InternalThreadLocalMap.UNSET)) {
                    for (FastThreadLocal<?> tlv : (FastThreadLocal[]) ((Set) v).toArray(new FastThreadLocal[0])) {
                        tlv.remove(threadLocalMap);
                    }
                }
            } finally {
                InternalThreadLocalMap.remove();
            }
        }
    }

    public static int size() {
        InternalThreadLocalMap threadLocalMap = InternalThreadLocalMap.getIfSet();
        if (threadLocalMap == null) {
            return 0;
        }
        return threadLocalMap.size();
    }

    public static void destroy() {
        InternalThreadLocalMap.destroy();
    }

    private static void addToVariablesToRemove(InternalThreadLocalMap threadLocalMap, FastThreadLocal<?> variable) {
        Set<FastThreadLocal<?>> variablesToRemove;
        Object v = threadLocalMap.indexedVariable(variablesToRemoveIndex);
        if (v == InternalThreadLocalMap.UNSET || v == null) {
            variablesToRemove = Collections.newSetFromMap(new IdentityHashMap());
            threadLocalMap.setIndexedVariable(variablesToRemoveIndex, variablesToRemove);
        } else {
            variablesToRemove = (Set) v;
        }
        variablesToRemove.add(variable);
    }

    private static void removeFromVariablesToRemove(InternalThreadLocalMap threadLocalMap, FastThreadLocal<?> variable) {
        Object v = threadLocalMap.indexedVariable(variablesToRemoveIndex);
        if (v != InternalThreadLocalMap.UNSET && v != null) {
            ((Set) v).remove(variable);
        }
    }

    public final V get() {
        InternalThreadLocalMap threadLocalMap = InternalThreadLocalMap.get();
        V v = (V) threadLocalMap.indexedVariable(this.index);
        if (v != InternalThreadLocalMap.UNSET) {
            return v;
        }
        return initialize(threadLocalMap);
    }

    public final V getIfExists() {
        V v;
        InternalThreadLocalMap threadLocalMap = InternalThreadLocalMap.getIfSet();
        if (threadLocalMap == null || (v = (V) threadLocalMap.indexedVariable(this.index)) == InternalThreadLocalMap.UNSET) {
            return null;
        }
        return v;
    }

    public final V get(InternalThreadLocalMap threadLocalMap) {
        V v = (V) threadLocalMap.indexedVariable(this.index);
        if (v != InternalThreadLocalMap.UNSET) {
            return v;
        }
        return initialize(threadLocalMap);
    }

    private V initialize(InternalThreadLocalMap threadLocalMap) {
        V v = null;
        try {
            v = initialValue();
        } catch (Exception e) {
            PlatformDependent.throwException(e);
        }
        threadLocalMap.setIndexedVariable(this.index, v);
        addToVariablesToRemove(threadLocalMap, this);
        return v;
    }

    public final void set(V value) {
        if (value != InternalThreadLocalMap.UNSET) {
            setKnownNotUnset(InternalThreadLocalMap.get(), value);
        } else {
            remove();
        }
    }

    public final void set(InternalThreadLocalMap threadLocalMap, V value) {
        if (value != InternalThreadLocalMap.UNSET) {
            setKnownNotUnset(threadLocalMap, value);
        } else {
            remove(threadLocalMap);
        }
    }

    private void setKnownNotUnset(InternalThreadLocalMap threadLocalMap, V value) {
        if (threadLocalMap.setIndexedVariable(this.index, value)) {
            addToVariablesToRemove(threadLocalMap, this);
        }
    }

    public final boolean isSet() {
        return isSet(InternalThreadLocalMap.getIfSet());
    }

    public final boolean isSet(InternalThreadLocalMap threadLocalMap) {
        return threadLocalMap != null && threadLocalMap.isIndexedVariableSet(this.index);
    }

    public final void remove() {
        remove(InternalThreadLocalMap.getIfSet());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: io.netty.util.concurrent.FastThreadLocal<V> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void remove(InternalThreadLocalMap threadLocalMap) {
        if (threadLocalMap != null) {
            Object v = threadLocalMap.removeIndexedVariable(this.index);
            removeFromVariablesToRemove(threadLocalMap, this);
            if (v != InternalThreadLocalMap.UNSET) {
                try {
                    onRemoval(v);
                } catch (Exception e) {
                    PlatformDependent.throwException(e);
                }
            }
        }
    }

    protected V initialValue() throws Exception {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onRemoval(V value) throws Exception {
    }
}
