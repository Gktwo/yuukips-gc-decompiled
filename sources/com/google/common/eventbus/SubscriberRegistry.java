package com.google.common.eventbus;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.reflect.TypeToken;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.j2objc.annotations.Weak;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/common/eventbus/SubscriberRegistry.class */
public final class SubscriberRegistry {
    private final ConcurrentMap<Class<?>, CopyOnWriteArraySet<Subscriber>> subscribers = Maps.newConcurrentMap();
    @Weak
    private final EventBus bus;
    private static final LoadingCache<Class<?>, ImmutableList<Method>> subscriberMethodsCache = CacheBuilder.newBuilder().weakKeys().build(new CacheLoader<Class<?>, ImmutableList<Method>>() { // from class: com.google.common.eventbus.SubscriberRegistry.1
        public ImmutableList<Method> load(Class<?> concreteClass) throws Exception {
            return SubscriberRegistry.getAnnotatedMethodsNotCached(concreteClass);
        }
    });
    private static final LoadingCache<Class<?>, ImmutableSet<Class<?>>> flattenHierarchyCache = CacheBuilder.newBuilder().weakKeys().build(new CacheLoader<Class<?>, ImmutableSet<Class<?>>>() { // from class: com.google.common.eventbus.SubscriberRegistry.2
        public ImmutableSet<Class<?>> load(Class<?> concreteClass) {
            return ImmutableSet.copyOf((Collection) TypeToken.m1299of((Class) concreteClass).getTypes().rawTypes());
        }
    });

    /* access modifiers changed from: package-private */
    public SubscriberRegistry(EventBus bus) {
        this.bus = (EventBus) Preconditions.checkNotNull(bus);
    }

    /* access modifiers changed from: package-private */
    public void register(Object listener) {
        for (Map.Entry<Class<?>, Collection<Subscriber>> entry : findAllSubscribers(listener).asMap().entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<Subscriber> eventMethodsInListener = entry.getValue();
            CopyOnWriteArraySet<Subscriber> eventSubscribers = this.subscribers.get(eventType);
            if (eventSubscribers == null) {
                CopyOnWriteArraySet<Subscriber> newSet = new CopyOnWriteArraySet<>();
                eventSubscribers = (CopyOnWriteArraySet) MoreObjects.firstNonNull(this.subscribers.putIfAbsent(eventType, newSet), newSet);
            }
            eventSubscribers.addAll(eventMethodsInListener);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void unregister(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = r5
            r1 = r6
            com.google.common.collect.Multimap r0 = r0.findAllSubscribers(r1)
            r7 = r0
            r0 = r7
            java.util.Map r0 = r0.asMap()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r8 = r0
        L_0x0017:
            r0 = r8
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0085
            r0 = r8
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            r9 = r0
            r0 = r9
            java.lang.Object r0 = r0.getKey()
            java.lang.Class r0 = (java.lang.Class) r0
            r10 = r0
            r0 = r9
            java.lang.Object r0 = r0.getValue()
            java.util.Collection r0 = (java.util.Collection) r0
            r11 = r0
            r0 = r5
            java.util.concurrent.ConcurrentMap<java.lang.Class<?>, java.util.concurrent.CopyOnWriteArraySet<com.google.common.eventbus.Subscriber>> r0 = r0.subscribers
            r1 = r10
            java.lang.Object r0 = r0.get(r1)
            java.util.concurrent.CopyOnWriteArraySet r0 = (java.util.concurrent.CopyOnWriteArraySet) r0
            r12 = r0
            r0 = r12
            if (r0 == 0) goto L_0x0062
            r0 = r12
            r1 = r11
            boolean r0 = r0.removeAll(r1)
            if (r0 != 0) goto L_0x0082
        L_0x0062:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "missing event subscriber for an annotated method. Is "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r6
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = " registered?"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0082:
            goto L_0x0017
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.eventbus.SubscriberRegistry.unregister(java.lang.Object):void");
    }

    @VisibleForTesting
    Set<Subscriber> getSubscribersForTesting(Class<?> eventType) {
        return (Set) MoreObjects.firstNonNull(this.subscribers.get(eventType), ImmutableSet.m1396of());
    }

    /* access modifiers changed from: package-private */
    public Iterator<Subscriber> getSubscribers(Object event) {
        ImmutableSet<Class<?>> eventTypes = flattenHierarchy(event.getClass());
        List<Iterator<Subscriber>> subscriberIterators = Lists.newArrayListWithCapacity(eventTypes.size());
        UnmodifiableIterator<Class<?>> it = eventTypes.iterator();
        while (it.hasNext()) {
            CopyOnWriteArraySet<Subscriber> eventSubscribers = this.subscribers.get(it.next());
            if (eventSubscribers != null) {
                subscriberIterators.add(eventSubscribers.iterator());
            }
        }
        return Iterators.concat(subscriberIterators.iterator());
    }

    private Multimap<Class<?>, Subscriber> findAllSubscribers(Object listener) {
        Multimap<Class<?>, Subscriber> methodsInListener = HashMultimap.create();
        UnmodifiableIterator<Method> it = getAnnotatedMethods(listener.getClass()).iterator();
        while (it.hasNext()) {
            Method method = it.next();
            methodsInListener.put(method.getParameterTypes()[0], Subscriber.create(this.bus, listener, method));
        }
        return methodsInListener;
    }

    private static ImmutableList<Method> getAnnotatedMethods(Class<?> clazz) {
        return subscriberMethodsCache.getUnchecked(clazz);
    }

    /* access modifiers changed from: private */
    public static ImmutableList<Method> getAnnotatedMethodsNotCached(Class<?> clazz) {
        Set<? extends Class<?>> supertypes = TypeToken.m1299of((Class) clazz).getTypes().rawTypes();
        Map<MethodIdentifier, Method> identifiers = Maps.newHashMap();
        for (Class<?> supertype : supertypes) {
            Method[] declaredMethods = supertype.getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (method.isAnnotationPresent(Subscribe.class) && !method.isSynthetic()) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    Preconditions.checkArgument(parameterTypes.length == 1, "Method %s has @Subscribe annotation but has %s parameters.Subscriber methods must have exactly 1 parameter.", (Object) method, parameterTypes.length);
                    MethodIdentifier ident = new MethodIdentifier(method);
                    if (!identifiers.containsKey(ident)) {
                        identifiers.put(ident, method);
                    }
                }
            }
        }
        return ImmutableList.copyOf((Collection) identifiers.values());
    }

    @VisibleForTesting
    static ImmutableSet<Class<?>> flattenHierarchy(Class<?> concreteClass) {
        try {
            return flattenHierarchyCache.getUnchecked(concreteClass);
        } catch (UncheckedExecutionException e) {
            throw Throwables.propagate(e.getCause());
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/eventbus/SubscriberRegistry$MethodIdentifier.class */
    public static final class MethodIdentifier {
        private final String name;
        private final List<Class<?>> parameterTypes;

        MethodIdentifier(Method method) {
            this.name = method.getName();
            this.parameterTypes = Arrays.asList(method.getParameterTypes());
        }

        public int hashCode() {
            return Objects.hashCode(this.name, this.parameterTypes);
        }

        public boolean equals(Object o) {
            if (!(o instanceof MethodIdentifier)) {
                return false;
            }
            MethodIdentifier ident = (MethodIdentifier) o;
            return this.name.equals(ident.name) && this.parameterTypes.equals(ident.parameterTypes);
        }
    }
}
