package nonapi.p019io.github.classgraph.json;

import java.lang.reflect.Constructor;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSequentialList;
import java.util.AbstractSet;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;
import p013io.github.classgraph.ClassGraphException;

/* access modifiers changed from: package-private */
/* renamed from: nonapi.io.github.classgraph.json.ClassFieldCache */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/json/ClassFieldCache.class */
public class ClassFieldCache {
    private final boolean resolveTypes;
    private final boolean onlySerializePublicFields;
    private static final Constructor<?> NO_CONSTRUCTOR;
    private final Map<Class<?>, ClassFields> classToClassFields = new HashMap();
    private final Map<Class<?>, Constructor<?>> defaultConstructorForConcreteType = new HashMap();
    private final Map<Class<?>, Constructor<?>> constructorForConcreteTypeWithSizeHint = new HashMap();

    /* renamed from: nonapi.io.github.classgraph.json.ClassFieldCache$NoConstructor */
    /* loaded from: grasscutter.jar:nonapi/io/github/classgraph/json/ClassFieldCache$NoConstructor.class */
    private static class NoConstructor {
    }

    static {
        try {
            NO_CONSTRUCTOR = NoConstructor.class.getDeclaredConstructor(new Class[0]);
        } catch (NoSuchMethodException | SecurityException e) {
            throw ClassGraphException.newClassGraphException("Could not find or access constructor for " + NoConstructor.class.getName(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public ClassFieldCache(boolean forDeserialization, boolean onlySerializePublicFields) {
        this.resolveTypes = forDeserialization;
        this.onlySerializePublicFields = !forDeserialization && onlySerializePublicFields;
    }

    /* access modifiers changed from: package-private */
    public ClassFields get(Class<?> cls) {
        ClassFields classFields = this.classToClassFields.get(cls);
        if (classFields == null) {
            Map<Class<?>, ClassFields> map = this.classToClassFields;
            ClassFields classFields2 = new ClassFields(cls, this.resolveTypes, this.onlySerializePublicFields, this);
            classFields = classFields2;
            map.put(cls, classFields2);
        }
        return classFields;
    }

    private static Class<?> getConcreteType(Class<?> rawType, boolean returnNullIfNotMapOrCollection) {
        if (rawType == Map.class || rawType == AbstractMap.class || rawType == HashMap.class) {
            return HashMap.class;
        }
        if (rawType == ConcurrentMap.class || rawType == ConcurrentHashMap.class) {
            return ConcurrentHashMap.class;
        }
        if (rawType == SortedMap.class || rawType == NavigableMap.class || rawType == TreeMap.class) {
            return TreeMap.class;
        }
        if (rawType == ConcurrentNavigableMap.class || rawType == ConcurrentSkipListMap.class) {
            return ConcurrentSkipListMap.class;
        }
        if (rawType == List.class || rawType == AbstractList.class || rawType == ArrayList.class || rawType == Collection.class) {
            return ArrayList.class;
        }
        if (rawType == AbstractSequentialList.class || rawType == LinkedList.class) {
            return LinkedList.class;
        }
        if (rawType == Set.class || rawType == AbstractSet.class || rawType == HashSet.class) {
            return HashSet.class;
        }
        if (rawType == SortedSet.class || rawType == TreeSet.class) {
            return TreeSet.class;
        }
        if (rawType == Queue.class || rawType == AbstractQueue.class || rawType == Deque.class || rawType == ArrayDeque.class) {
            return ArrayDeque.class;
        }
        if (rawType == BlockingQueue.class || rawType == LinkedBlockingQueue.class) {
            return LinkedBlockingQueue.class;
        }
        if (rawType == BlockingDeque.class || rawType == LinkedBlockingDeque.class) {
            return LinkedBlockingDeque.class;
        }
        if (rawType == TransferQueue.class || rawType == LinkedTransferQueue.class) {
            return LinkedTransferQueue.class;
        }
        if (returnNullIfNotMapOrCollection) {
            return null;
        }
        return rawType;
    }

    /* access modifiers changed from: package-private */
    public Constructor<?> getDefaultConstructorForConcreteTypeOf(Class<?> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Class reference cannot be null");
        }
        Constructor<?> constructor = this.defaultConstructorForConcreteType.get(cls);
        if (constructor != null) {
            return constructor;
        }
        Class<?> c = getConcreteType(cls, false);
        while (c != null && (c != Object.class || cls == Object.class)) {
            try {
                Constructor<?> defaultConstructor = c.getDeclaredConstructor(new Class[0]);
                JSONUtils.isAccessibleOrMakeAccessible(defaultConstructor);
                this.defaultConstructorForConcreteType.put(cls, defaultConstructor);
                return defaultConstructor;
            } catch (ReflectiveOperationException | SecurityException e) {
                c = c.getSuperclass();
            }
        }
        throw new IllegalArgumentException("Class " + cls.getName() + " does not have an accessible default (no-arg) constructor");
    }

    /* access modifiers changed from: package-private */
    public Constructor<?> getConstructorWithSizeHintForConcreteTypeOf(Class<?> cls) {
        Constructor<?> constructor = this.constructorForConcreteTypeWithSizeHint.get(cls);
        if (constructor == NO_CONSTRUCTOR) {
            return null;
        }
        if (constructor != null) {
            return constructor;
        }
        Class<?> concreteType = getConcreteType(cls, true);
        if (concreteType != null) {
            Class<?> c = concreteType;
            while (c != null && (c != Object.class || cls == Object.class)) {
                try {
                    Constructor<?> constructorWithSizeHint = c.getDeclaredConstructor(Integer.TYPE);
                    JSONUtils.isAccessibleOrMakeAccessible(constructorWithSizeHint);
                    this.constructorForConcreteTypeWithSizeHint.put(cls, constructorWithSizeHint);
                    return constructorWithSizeHint;
                } catch (ReflectiveOperationException | SecurityException e) {
                    c = c.getSuperclass();
                }
            }
        }
        this.constructorForConcreteTypeWithSizeHint.put(cls, NO_CONSTRUCTOR);
        return null;
    }
}
