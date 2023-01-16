package org.eclipse.jetty.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/TopologicalSort.class */
public class TopologicalSort<T> {
    private final Map<T, Set<T>> _dependencies = new HashMap();

    public void addDependency(T dependent, T dependency) {
        Set<T> set = this._dependencies.get(dependent);
        if (set == null) {
            set = new HashSet();
            this._dependencies.put(dependent, set);
        }
        set.add(dependency);
    }

    public void sort(T[] array) {
        List<T> sorted = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        Comparator<T> comparator = new InitialOrderComparator<>(array);
        for (T t : array) {
            visit(t, visited, sorted, comparator);
        }
        sorted.toArray(array);
    }

    public void sort(Collection<T> list) {
        List<T> sorted = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        Comparator<T> comparator = new InitialOrderComparator<>(list);
        for (T t : list) {
            visit(t, visited, sorted, comparator);
        }
        list.clear();
        list.addAll(sorted);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: org.eclipse.jetty.util.TopologicalSort<T> */
    /* JADX WARN: Multi-variable type inference failed */
    private void visit(T item, Set<T> visited, List<T> sorted, Comparator<T> comparator) {
        if (!visited.contains(item)) {
            visited.add(item);
            Collection<? extends T> dependencies = (Set) this._dependencies.get(item);
            if (dependencies != null) {
                SortedSet<T> orderedDeps = new TreeSet<>((Comparator<? super T>) comparator);
                orderedDeps.addAll(dependencies);
                try {
                    for (T d : orderedDeps) {
                        visit(d, visited, sorted, comparator);
                    }
                } catch (CyclicException e) {
                    throw new CyclicException(item, e);
                }
            }
            sorted.add(item);
        } else if (!sorted.contains(item)) {
            throw new CyclicException(item);
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/TopologicalSort$InitialOrderComparator.class */
    private static class InitialOrderComparator<T> implements Comparator<T> {
        private final Map<T, Integer> _indexes = new HashMap();

        InitialOrderComparator(T[] initial) {
            int i = 0;
            for (T t : initial) {
                i++;
                this._indexes.put(t, Integer.valueOf(i));
            }
        }

        InitialOrderComparator(Collection<T> initial) {
            int i = 0;
            for (T t : initial) {
                i++;
                this._indexes.put(t, Integer.valueOf(i));
            }
        }

        @Override // java.util.Comparator
        public int compare(T o1, T o2) {
            Integer i1 = this._indexes.get(o1);
            Integer i2 = this._indexes.get(o2);
            if (i1 == null || i2 == null || i1.equals(o2)) {
                return 0;
            }
            if (i1.intValue() < i2.intValue()) {
                return -1;
            }
            return 1;
        }
    }

    public String toString() {
        return "TopologicalSort " + this._dependencies;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/TopologicalSort$CyclicException.class */
    public static class CyclicException extends IllegalStateException {
        CyclicException(Object item) {
            super("cyclic at " + item);
        }

        CyclicException(Object item, CyclicException e) {
            super("cyclic at " + item, e);
        }
    }
}
