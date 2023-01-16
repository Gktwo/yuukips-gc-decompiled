package com.mchange.p006v1.cachedstore;

import com.mchange.p006v1.cachedstore.CachedStore;
import com.mchange.p006v1.cachedstore.WritableCachedStore;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* renamed from: com.mchange.v1.cachedstore.CachedStoreFactory */
/* loaded from: grasscutter.jar:com/mchange/v1/cachedstore/CachedStoreFactory.class */
public final class CachedStoreFactory {
    public static TweakableCachedStore createNoCleanupCachedStore(CachedStore.Manager manager) {
        return new NoCleanupCachedStore(manager);
    }

    public static TweakableCachedStore createSoftValueCachedStore(CachedStore.Manager manager) {
        return new SoftReferenceCachedStore(manager);
    }

    public static TweakableCachedStore createSynchronousCleanupSoftKeyCachedStore(CachedStore.Manager manager) {
        final ManualCleanupSoftKeyCachedStore manualCleanupSoftKeyCachedStore = new ManualCleanupSoftKeyCachedStore(manager);
        return (TweakableCachedStore) Proxy.newProxyInstance(CachedStoreFactory.class.getClassLoader(), new Class[]{TweakableCachedStore.class}, new InvocationHandler() { // from class: com.mchange.v1.cachedstore.CachedStoreFactory.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                manualCleanupSoftKeyCachedStore.vacuum();
                return method.invoke(manualCleanupSoftKeyCachedStore, objArr);
            }
        });
    }

    public static TweakableCachedStore createNoCacheCachedStore(CachedStore.Manager manager) {
        return new NoCacheCachedStore(manager);
    }

    public static WritableCachedStore createDefaultWritableCachedStore(WritableCachedStore.Manager manager) {
        return new SimpleWritableCachedStore(createSynchronousCleanupSoftKeyCachedStore(manager), manager);
    }

    public static WritableCachedStore cacheWritesOnlyWritableCachedStore(WritableCachedStore.Manager manager) {
        return new SimpleWritableCachedStore(createNoCacheCachedStore(manager), manager);
    }

    public static WritableCachedStore createNoCacheWritableCachedStore(WritableCachedStore.Manager manager) {
        return new NoCacheWritableCachedStore(manager);
    }
}
