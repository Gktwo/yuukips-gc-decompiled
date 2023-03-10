package org.greenrobot.eventbus;

import dev.morphia.mapping.Mapper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/greenrobot/eventbus/SubscriberMethodFinder.class */
public class SubscriberMethodFinder {
    private static final int BRIDGE = 64;
    private static final int SYNTHETIC = 4096;
    private static final int MODIFIERS_IGNORE = 5192;
    private List<SubscriberInfoIndex> subscriberInfoIndexes;
    private final boolean strictMethodVerification;
    private final boolean ignoreGeneratedIndex;
    private static final int POOL_SIZE = 4;
    private static final Map<Class<?>, List<SubscriberMethod>> METHOD_CACHE = new ConcurrentHashMap();
    private static final FindState[] FIND_STATE_POOL = new FindState[4];

    /* access modifiers changed from: package-private */
    public SubscriberMethodFinder(List<SubscriberInfoIndex> subscriberInfoIndexes, boolean strictMethodVerification, boolean ignoreGeneratedIndex) {
        this.subscriberInfoIndexes = subscriberInfoIndexes;
        this.strictMethodVerification = strictMethodVerification;
        this.ignoreGeneratedIndex = ignoreGeneratedIndex;
    }

    /* access modifiers changed from: package-private */
    public List<SubscriberMethod> findSubscriberMethods(Class<?> subscriberClass) {
        List<SubscriberMethod> subscriberMethods;
        List<SubscriberMethod> subscriberMethods2 = METHOD_CACHE.get(subscriberClass);
        if (subscriberMethods2 != null) {
            return subscriberMethods2;
        }
        if (this.ignoreGeneratedIndex) {
            subscriberMethods = findUsingReflection(subscriberClass);
        } else {
            subscriberMethods = findUsingInfo(subscriberClass);
        }
        if (subscriberMethods.isEmpty()) {
            throw new EventBusException("Subscriber " + subscriberClass + " and its super classes have no public methods with the @Subscribe annotation");
        }
        METHOD_CACHE.put(subscriberClass, subscriberMethods);
        return subscriberMethods;
    }

    private List<SubscriberMethod> findUsingInfo(Class<?> subscriberClass) {
        FindState findState = prepareFindState();
        findState.initForSubscriber(subscriberClass);
        while (findState.clazz != null) {
            findState.subscriberInfo = getSubscriberInfo(findState);
            if (findState.subscriberInfo != null) {
                SubscriberMethod[] array = findState.subscriberInfo.getSubscriberMethods();
                for (SubscriberMethod subscriberMethod : array) {
                    if (findState.checkAdd(subscriberMethod.method, subscriberMethod.eventType)) {
                        findState.subscriberMethods.add(subscriberMethod);
                    }
                }
            } else {
                findUsingReflectionInSingleClass(findState);
            }
            findState.moveToSuperclass();
        }
        return getMethodsAndRelease(findState);
    }

    private List<SubscriberMethod> getMethodsAndRelease(FindState findState) {
        List<SubscriberMethod> subscriberMethods = new ArrayList<>(findState.subscriberMethods);
        findState.recycle();
        synchronized (FIND_STATE_POOL) {
            int i = 0;
            while (true) {
                if (i >= 4) {
                    break;
                } else if (FIND_STATE_POOL[i] == null) {
                    FIND_STATE_POOL[i] = findState;
                    break;
                } else {
                    i++;
                }
            }
        }
        return subscriberMethods;
    }

    private FindState prepareFindState() {
        synchronized (FIND_STATE_POOL) {
            for (int i = 0; i < 4; i++) {
                FindState state = FIND_STATE_POOL[i];
                if (state != null) {
                    FIND_STATE_POOL[i] = null;
                    return state;
                }
            }
            return new FindState();
        }
    }

    private SubscriberInfo getSubscriberInfo(FindState findState) {
        if (!(findState.subscriberInfo == null || findState.subscriberInfo.getSuperSubscriberInfo() == null)) {
            SubscriberInfo superclassInfo = findState.subscriberInfo.getSuperSubscriberInfo();
            if (findState.clazz == superclassInfo.getSubscriberClass()) {
                return superclassInfo;
            }
        }
        if (this.subscriberInfoIndexes == null) {
            return null;
        }
        for (SubscriberInfoIndex index : this.subscriberInfoIndexes) {
            SubscriberInfo info = index.getSubscriberInfo(findState.clazz);
            if (info != null) {
                return info;
            }
        }
        return null;
    }

    private List<SubscriberMethod> findUsingReflection(Class<?> subscriberClass) {
        FindState findState = prepareFindState();
        findState.initForSubscriber(subscriberClass);
        while (findState.clazz != null) {
            findUsingReflectionInSingleClass(findState);
            findState.moveToSuperclass();
        }
        return getMethodsAndRelease(findState);
    }

    private void findUsingReflectionInSingleClass(FindState findState) {
        Method[] methods;
        String msg;
        try {
            methods = findState.clazz.getDeclaredMethods();
        } catch (Throwable th) {
            try {
                methods = findState.clazz.getMethods();
                findState.skipSuperClasses = true;
            } catch (LinkageError error) {
                String msg2 = "Could not inspect methods of " + findState.clazz.getName();
                if (this.ignoreGeneratedIndex) {
                    msg = msg2 + ". Please consider using EventBus annotation processor to avoid reflection.";
                } else {
                    msg = msg2 + ". Please make this class visible to EventBus annotation processor to avoid reflection.";
                }
                throw new EventBusException(msg, error);
            }
        }
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & MODIFIERS_IGNORE) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    Subscribe subscribeAnnotation = (Subscribe) method.getAnnotation(Subscribe.class);
                    if (subscribeAnnotation != null) {
                        Class<?> eventType = parameterTypes[0];
                        if (findState.checkAdd(method, eventType)) {
                            findState.subscriberMethods.add(new SubscriberMethod(method, eventType, subscribeAnnotation.threadMode(), subscribeAnnotation.priority(), subscribeAnnotation.sticky()));
                        }
                    }
                } else if (this.strictMethodVerification && method.isAnnotationPresent(Subscribe.class)) {
                    throw new EventBusException("@Subscribe method " + (method.getDeclaringClass().getName() + Mapper.IGNORED_FIELDNAME + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.strictMethodVerification && method.isAnnotationPresent(Subscribe.class)) {
                throw new EventBusException((method.getDeclaringClass().getName() + Mapper.IGNORED_FIELDNAME + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static void clearCaches() {
        METHOD_CACHE.clear();
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/greenrobot/eventbus/SubscriberMethodFinder$FindState.class */
    public static class FindState {
        final List<SubscriberMethod> subscriberMethods = new ArrayList();
        final Map<Class, Object> anyMethodByEventType = new HashMap();
        final Map<String, Class> subscriberClassByMethodKey = new HashMap();
        final StringBuilder methodKeyBuilder = new StringBuilder(128);
        Class<?> subscriberClass;
        Class<?> clazz;
        boolean skipSuperClasses;
        SubscriberInfo subscriberInfo;

        FindState() {
        }

        void initForSubscriber(Class<?> subscriberClass) {
            this.clazz = subscriberClass;
            this.subscriberClass = subscriberClass;
            this.skipSuperClasses = false;
            this.subscriberInfo = null;
        }

        void recycle() {
            this.subscriberMethods.clear();
            this.anyMethodByEventType.clear();
            this.subscriberClassByMethodKey.clear();
            this.methodKeyBuilder.setLength(0);
            this.subscriberClass = null;
            this.clazz = null;
            this.skipSuperClasses = false;
            this.subscriberInfo = null;
        }

        boolean checkAdd(Method method, Class<?> eventType) {
            Object existing = this.anyMethodByEventType.put(eventType, method);
            if (existing == null) {
                return true;
            }
            if (existing instanceof Method) {
                if (!checkAddWithMethodSignature((Method) existing, eventType)) {
                    throw new IllegalStateException();
                }
                this.anyMethodByEventType.put(eventType, this);
            }
            return checkAddWithMethodSignature(method, eventType);
        }

        private boolean checkAddWithMethodSignature(Method method, Class<?> eventType) {
            this.methodKeyBuilder.setLength(0);
            this.methodKeyBuilder.append(method.getName());
            this.methodKeyBuilder.append('>').append(eventType.getName());
            String methodKey = this.methodKeyBuilder.toString();
            Class<?> methodClass = method.getDeclaringClass();
            Class<?> methodClassOld = this.subscriberClassByMethodKey.put(methodKey, methodClass);
            if (methodClassOld == null || methodClassOld.isAssignableFrom(methodClass)) {
                return true;
            }
            this.subscriberClassByMethodKey.put(methodKey, methodClassOld);
            return false;
        }

        void moveToSuperclass() {
            if (this.skipSuperClasses) {
                this.clazz = null;
                return;
            }
            this.clazz = this.clazz.getSuperclass();
            String clazzName = this.clazz.getName();
            if (clazzName.startsWith("java.") || clazzName.startsWith("javax.") || clazzName.startsWith("android.") || clazzName.startsWith("androidx.")) {
                this.clazz = null;
            }
        }
    }
}
