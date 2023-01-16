package net.bytebuddy.matcher;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.matcher.FilterableList;

/* loaded from: grasscutter.jar:net/bytebuddy/matcher/FilterableList.class */
public interface FilterableList<T, S extends FilterableList<T, S>> extends List<T> {
    S filter(ElementMatcher<? super T> elementMatcher);

    T getOnly();

    @Override // java.util.List
    S subList(int i, int i2);

    /* loaded from: grasscutter.jar:net/bytebuddy/matcher/FilterableList$Empty.class */
    public static class Empty<T, S extends FilterableList<T, S>> extends AbstractList<T> implements FilterableList<T, S> {
        @Override // java.util.AbstractList, java.util.List
        public T get(int index) {
            throw new IndexOutOfBoundsException("index = " + index);
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return 0;
        }

        @Override // net.bytebuddy.matcher.FilterableList
        public T getOnly() {
            throw new IllegalStateException("size = 0");
        }

        @Override // net.bytebuddy.matcher.FilterableList
        public S filter(ElementMatcher<? super T> elementMatcher) {
            return this;
        }

        @Override // java.util.AbstractList, java.util.List, net.bytebuddy.matcher.FilterableList
        public S subList(int fromIndex, int toIndex) {
            if (fromIndex == toIndex && toIndex == 0) {
                return this;
            }
            if (fromIndex > toIndex) {
                throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
            }
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/matcher/FilterableList$AbstractBase.class */
    public static abstract class AbstractBase<T, S extends FilterableList<T, S>> extends AbstractList<T> implements FilterableList<T, S> {
        private static final int ONLY = 0;

        protected abstract S wrap(List<T> list);

        /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: ? super T */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // net.bytebuddy.matcher.FilterableList
        public S filter(ElementMatcher<? super T> elementMatcher) {
            List<T> filteredElements = new ArrayList<>(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                Object obj = (Object) it.next();
                if (elementMatcher.matches(obj)) {
                    filteredElements.add(obj);
                }
            }
            return filteredElements.size() == size() ? this : wrap(filteredElements);
        }

        @Override // net.bytebuddy.matcher.FilterableList
        public T getOnly() {
            if (size() == 1) {
                return get(0);
            }
            throw new IllegalStateException("size = " + size());
        }

        @Override // java.util.AbstractList, java.util.List, net.bytebuddy.matcher.FilterableList
        public S subList(int fromIndex, int toIndex) {
            return wrap(subList(fromIndex, toIndex));
        }
    }
}
