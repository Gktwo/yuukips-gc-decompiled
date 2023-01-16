package com.mchange.p009v2.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

/* renamed from: com.mchange.v2.util.CollectionUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/util/CollectionUtils.class */
public final class CollectionUtils {
    public static final SortedSet EMPTY_SORTED_SET = Collections.unmodifiableSortedSet(new TreeSet());
    static final Class[] EMPTY_ARG_CLASSES = new Class[0];
    static final Object[] EMPTY_ARGS = new Object[0];
    static final Class[] COMPARATOR_ARG_CLASSES = {Comparator.class};
    static final Class[] COLLECTION_ARG_CLASSES = {Collection.class};
    static final Class[] SORTED_SET_ARG_CLASSES = {SortedSet.class};
    static final Class[] MAP_ARG_CLASSES = {Map.class};
    static final Class[] SORTED_MAP_ARG_CLASSES = {SortedMap.class};
    static final Class STD_UNMODIFIABLE_COLLECTION_CL;
    static final Class STD_UNMODIFIABLE_SET_CL;
    static final Class STD_UNMODIFIABLE_LIST_CL;
    static final Class STD_UNMODIFIABLE_RA_LIST_CL;
    static final Class STD_UNMODIFIABLE_SORTED_SET_CL;
    static final Class STD_UNMODIFIABLE_MAP_CL;
    static final Class STD_UNMODIFIABLE_SORTED_MAP_CL;
    static final Class STD_SYNCHRONIZED_COLLECTION_CL;
    static final Class STD_SYNCHRONIZED_SET_CL;
    static final Class STD_SYNCHRONIZED_LIST_CL;
    static final Class STD_SYNCHRONIZED_RA_LIST_CL;
    static final Class STD_SYNCHRONIZED_SORTED_SET_CL;
    static final Class STD_SYNCHRONIZED_MAP_CL;
    static final Class STD_SYNCHRONIZED_SORTED_MAP_CL;
    static final Set UNMODIFIABLE_WRAPPERS;
    static final Set SYNCHRONIZED_WRAPPERS;
    static final Set ALL_COLLECTIONS_WRAPPERS;

    static {
        HashSet hashSet = new HashSet();
        TreeSet treeSet = new TreeSet();
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        Class<?> cls = Collections.unmodifiableCollection(arrayList).getClass();
        STD_UNMODIFIABLE_COLLECTION_CL = cls;
        hashSet2.add(cls);
        Class<?> cls2 = Collections.unmodifiableSet(hashSet).getClass();
        STD_UNMODIFIABLE_SET_CL = cls2;
        hashSet2.add(cls2);
        Class<?> cls3 = Collections.unmodifiableList(linkedList).getClass();
        STD_UNMODIFIABLE_LIST_CL = cls3;
        hashSet2.add(cls3);
        Class<?> cls4 = Collections.unmodifiableList(arrayList).getClass();
        STD_UNMODIFIABLE_RA_LIST_CL = cls4;
        hashSet2.add(cls4);
        Class<?> cls5 = Collections.unmodifiableSortedSet(treeSet).getClass();
        STD_UNMODIFIABLE_SORTED_SET_CL = cls5;
        hashSet2.add(cls5);
        Class<?> cls6 = Collections.unmodifiableMap(hashMap).getClass();
        STD_UNMODIFIABLE_MAP_CL = cls6;
        hashSet2.add(cls6);
        Class<?> cls7 = Collections.unmodifiableSortedMap(treeMap).getClass();
        STD_UNMODIFIABLE_SORTED_MAP_CL = cls7;
        hashSet2.add(cls7);
        Class<?> cls8 = Collections.synchronizedCollection(arrayList).getClass();
        STD_SYNCHRONIZED_COLLECTION_CL = cls8;
        hashSet3.add(cls8);
        Class<?> cls9 = Collections.synchronizedSet(hashSet).getClass();
        STD_SYNCHRONIZED_SET_CL = cls9;
        hashSet3.add(cls9);
        Class<?> cls10 = Collections.synchronizedList(linkedList).getClass();
        STD_SYNCHRONIZED_LIST_CL = cls10;
        hashSet3.add(cls10);
        Class<?> cls11 = Collections.synchronizedList(arrayList).getClass();
        STD_SYNCHRONIZED_RA_LIST_CL = cls11;
        hashSet3.add(cls11);
        Class<?> cls12 = Collections.synchronizedSortedSet(treeSet).getClass();
        STD_SYNCHRONIZED_SORTED_SET_CL = cls12;
        hashSet3.add(cls12);
        Class<?> cls13 = Collections.synchronizedMap(hashMap).getClass();
        STD_SYNCHRONIZED_MAP_CL = cls13;
        hashSet3.add(cls13);
        Class<?> cls14 = Collections.synchronizedMap(treeMap).getClass();
        STD_SYNCHRONIZED_SORTED_MAP_CL = cls14;
        hashSet3.add(cls14);
        UNMODIFIABLE_WRAPPERS = Collections.unmodifiableSet(hashSet2);
        SYNCHRONIZED_WRAPPERS = Collections.unmodifiableSet(hashSet3);
        HashSet hashSet4 = new HashSet(hashSet2);
        hashSet4.addAll(hashSet3);
        ALL_COLLECTIONS_WRAPPERS = Collections.unmodifiableSet(hashSet4);
    }

    public static boolean isCollectionsWrapper(Class cls) {
        return ALL_COLLECTIONS_WRAPPERS.contains(cls);
    }

    public static boolean isCollectionsWrapper(Collection collection) {
        return isCollectionsWrapper(collection.getClass());
    }

    public static boolean isCollectionsWrapper(Map map) {
        return isCollectionsWrapper(map.getClass());
    }

    public static boolean isSynchronizedWrapper(Class cls) {
        return SYNCHRONIZED_WRAPPERS.contains(cls);
    }

    public static boolean isSynchronizedWrapper(Collection collection) {
        return isSynchronizedWrapper(collection.getClass());
    }

    public static boolean isSynchronizedWrapper(Map map) {
        return isSynchronizedWrapper(map.getClass());
    }

    public static boolean isUnmodifiableWrapper(Class cls) {
        return UNMODIFIABLE_WRAPPERS.contains(cls);
    }

    public static boolean isUnmodifiableWrapper(Collection collection) {
        return isUnmodifiableWrapper(collection.getClass());
    }

    public static boolean isUnmodifiableWrapper(Map map) {
        return isUnmodifiableWrapper(map.getClass());
    }

    public static Collection narrowUnmodifiableCollection(Collection collection) {
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet) collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set) collection);
        }
        if (collection instanceof List) {
            return Collections.unmodifiableList((List) collection);
        }
        return Collections.unmodifiableCollection(collection);
    }

    public static Collection narrowSynchronizedCollection(Collection collection) {
        if (collection instanceof SortedSet) {
            return Collections.synchronizedSortedSet((SortedSet) collection);
        }
        if (collection instanceof Set) {
            return Collections.synchronizedSet((Set) collection);
        }
        if (collection instanceof List) {
            return Collections.synchronizedList((List) collection);
        }
        return Collections.synchronizedCollection(collection);
    }

    public static Map narrowUnmodifiableMap(Map map) {
        if (map instanceof SortedMap) {
            return Collections.unmodifiableSortedMap((SortedMap) map);
        }
        return Collections.unmodifiableMap(map);
    }

    public static Map narrowSynchronizedMap(Map map) {
        if (map instanceof SortedMap) {
            return Collections.synchronizedSortedMap((SortedMap) map);
        }
        return Collections.synchronizedMap(map);
    }

    public static Collection attemptClone(Collection collection) throws NoSuchMethodException {
        if (collection instanceof Vector) {
            return (Collection) ((Vector) collection).clone();
        }
        if (collection instanceof ArrayList) {
            return (Collection) ((ArrayList) collection).clone();
        }
        if (collection instanceof LinkedList) {
            return (Collection) ((LinkedList) collection).clone();
        }
        if (collection instanceof HashSet) {
            return (Collection) ((HashSet) collection).clone();
        }
        if (collection instanceof TreeSet) {
            return (Collection) ((TreeSet) collection).clone();
        }
        Collection collection2 = null;
        Class<?> cls = collection.getClass();
        try {
            collection2 = (Collection) cls.getMethod("clone", EMPTY_ARG_CLASSES).invoke(collection, EMPTY_ARGS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (collection2 == null) {
            try {
                collection2 = (Collection) cls.getConstructor(collection instanceof SortedSet ? SORTED_SET_ARG_CLASSES : COLLECTION_ARG_CLASSES).newInstance(collection);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (collection2 == null) {
            try {
                collection2 = (Collection) cls.getConstructor(cls).newInstance(collection);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        if (collection2 != null) {
            return collection2;
        }
        throw new NoSuchMethodException("No accessible clone() method or reasonable copy constructor could be called on Collection " + collection);
    }

    public static Map attemptClone(Map map) throws NoSuchMethodException {
        if (map instanceof Properties) {
            return (Map) ((Properties) map).clone();
        }
        if (map instanceof Hashtable) {
            return (Map) ((Hashtable) map).clone();
        }
        if (map instanceof HashMap) {
            return (Map) ((HashMap) map).clone();
        }
        if (map instanceof TreeMap) {
            return (Map) ((TreeMap) map).clone();
        }
        Map map2 = null;
        Class<?> cls = map.getClass();
        try {
            map2 = (Map) cls.getMethod("clone", EMPTY_ARG_CLASSES).invoke(map, EMPTY_ARGS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (map2 == null) {
            try {
                map2 = (Map) cls.getConstructor(map instanceof SortedMap ? SORTED_MAP_ARG_CLASSES : MAP_ARG_CLASSES).newInstance(map);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (map2 == null) {
            try {
                map2 = (Map) cls.getConstructor(cls).newInstance(map);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        if (map2 != null) {
            return map2;
        }
        throw new NoSuchMethodException("No accessible clone() method or reasonable copy constructor could be called on Map " + map);
    }

    public static void add(Collection collection, Object obj) {
        collection.add(obj);
    }

    public static void remove(Collection collection, Object obj) {
        collection.remove(obj);
    }

    public static int size(Object obj) {
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Map) {
            return ((Map) obj).size();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj instanceof boolean[]) {
            return ((boolean[]) obj).length;
        }
        if (obj instanceof byte[]) {
            return ((byte[]) obj).length;
        }
        if (obj instanceof char[]) {
            return ((char[]) obj).length;
        }
        if (obj instanceof short[]) {
            return ((short[]) obj).length;
        }
        if (obj instanceof int[]) {
            return ((int[]) obj).length;
        }
        if (obj instanceof long[]) {
            return ((long[]) obj).length;
        }
        if (obj instanceof float[]) {
            return ((float[]) obj).length;
        }
        if (obj instanceof double[]) {
            return ((double[]) obj).length;
        }
        throw new IllegalArgumentException(obj + " must be a Collection, Map, or array!");
    }

    private CollectionUtils() {
    }
}
