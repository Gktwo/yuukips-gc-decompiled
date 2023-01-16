package org.eclipse.jetty.util;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import okhttp3.HttpUrl;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/LazyList.class */
public class LazyList implements Cloneable, Serializable {
    private static final String[] __EMPTY_STRING_ARRAY = new String[0];

    private LazyList() {
    }

    public static Object add(Object list, Object item) {
        if (list == null) {
            if (!(item instanceof List) && item != null) {
                return item;
            }
            List<Object> l = new ArrayList<>();
            l.add(item);
            return l;
        } else if (list instanceof List) {
            ((List) list).add(item);
            return list;
        } else {
            List<Object> l2 = new ArrayList<>();
            l2.add(list);
            l2.add(item);
            return l2;
        }
    }

    public static Object add(Object list, int index, Object item) {
        if (list == null) {
            if (index <= 0 && !(item instanceof List) && item != null) {
                return item;
            }
            List<Object> l = new ArrayList<>();
            l.add(index, item);
            return l;
        } else if (list instanceof List) {
            ((List) list).add(index, item);
            return list;
        } else {
            List<Object> l2 = new ArrayList<>();
            l2.add(list);
            l2.add(index, item);
            return l2;
        }
    }

    public static Object addCollection(Object list, Collection<?> collection) {
        Iterator<?> i = collection.iterator();
        while (i.hasNext()) {
            list = add(list, i.next());
        }
        return list;
    }

    public static Object addArray(Object list, Object[] array) {
        int i = 0;
        while (array != null && i < array.length) {
            list = add(list, array[i]);
            i++;
        }
        return list;
    }

    public static Object ensureSize(Object list, int initialSize) {
        if (list == null) {
            return new ArrayList(initialSize);
        }
        if (list instanceof ArrayList) {
            ArrayList<?> ol = (ArrayList) list;
            if (ol.size() > initialSize) {
                return ol;
            }
            ArrayList<Object> nl = new ArrayList<>(initialSize);
            nl.addAll(ol);
            return nl;
        }
        List<Object> l = new ArrayList<>(initialSize);
        l.add(list);
        return l;
    }

    public static Object remove(Object list, Object o) {
        if (list == null) {
            return null;
        }
        if (list instanceof List) {
            List<?> l = (List) list;
            l.remove(o);
            if (l.size() == 0) {
                return null;
            }
            return list;
        } else if (list.equals(o)) {
            return null;
        } else {
            return list;
        }
    }

    public static Object remove(Object list, int i) {
        if (list == null) {
            return null;
        }
        if (list instanceof List) {
            List<?> l = (List) list;
            l.remove(i);
            if (l.size() == 0) {
                return null;
            }
            return list;
        } else if (i == 0) {
            return null;
        } else {
            return list;
        }
    }

    public static <E> List<E> getList(Object list) {
        return getList(list, false);
    }

    public static <E> List<E> getList(Object list, boolean nullForEmpty) {
        if (list == null) {
            if (nullForEmpty) {
                return null;
            }
            return Collections.emptyList();
        } else if (list instanceof List) {
            return (List) list;
        } else {
            return Collections.singletonList(list);
        }
    }

    public static boolean hasEntry(Object list) {
        if (list == null) {
            return false;
        }
        return !(list instanceof List) || !((List) list).isEmpty();
    }

    public static boolean isEmpty(Object list) {
        if (list == null) {
            return true;
        }
        if (list instanceof List) {
            return ((List) list).isEmpty();
        }
        return false;
    }

    public static String[] toStringArray(Object list) {
        if (list == null) {
            return __EMPTY_STRING_ARRAY;
        }
        if (!(list instanceof List)) {
            return new String[]{list.toString()};
        }
        List<?> l = (List) list;
        String[] a = new String[l.size()];
        int i = l.size();
        while (true) {
            i--;
            if (i <= 0) {
                return a;
            }
            Object o = l.get(i);
            if (o != null) {
                a[i] = o.toString();
            }
        }
    }

    public static Object toArray(Object list, Class<?> clazz) {
        if (list == null) {
            return Array.newInstance(clazz, 0);
        }
        if (list instanceof List) {
            List<?> l = (List) list;
            if (!clazz.isPrimitive()) {
                return l.toArray((Object[]) Array.newInstance(clazz, l.size()));
            }
            Object a = Array.newInstance(clazz, l.size());
            for (int i = 0; i < l.size(); i++) {
                Array.set(a, i, l.get(i));
            }
            return a;
        }
        Object a2 = Array.newInstance(clazz, 1);
        Array.set(a2, 0, list);
        return a2;
    }

    public static int size(Object list) {
        if (list == null) {
            return 0;
        }
        if (list instanceof List) {
            return ((List) list).size();
        }
        return 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> E get(Object list, int i) {
        if (list == 0) {
            throw new IndexOutOfBoundsException();
        } else if (list instanceof List) {
            return (E) ((List) list).get(i);
        } else {
            if (i == 0) {
                return list;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static boolean contains(Object list, Object item) {
        if (list == null) {
            return false;
        }
        if (list instanceof List) {
            return ((List) list).contains(item);
        }
        return list.equals(item);
    }

    public static Object clone(Object list) {
        if (list == null) {
            return null;
        }
        if (list instanceof List) {
            return new ArrayList((List) list);
        }
        return list;
    }

    public static String toString(Object list) {
        if (list == null) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        if (list instanceof List) {
            return list.toString();
        }
        return "[" + list + "]";
    }

    public static <E> Iterator<E> iterator(Object list) {
        if (list == null) {
            return Collections.emptyList().iterator();
        }
        if (list instanceof List) {
            return ((List) list).iterator();
        }
        return getList(list).iterator();
    }

    public static <E> ListIterator<E> listIterator(Object list) {
        if (list == null) {
            return Collections.emptyList().listIterator();
        }
        if (list instanceof List) {
            return ((List) list).listIterator();
        }
        return getList(list).listIterator();
    }
}
