package p013io.github.classgraph;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: io.github.classgraph.PackageInfoList */
/* loaded from: grasscutter.jar:io/github/classgraph/PackageInfoList.class */
public class PackageInfoList extends MappableInfoList<PackageInfo> {
    private static final long serialVersionUID = 1;
    static final PackageInfoList EMPTY_LIST = new PackageInfoList() { // from class: io.github.classgraph.PackageInfoList.1
        private static final long serialVersionUID = 1;

        public boolean add(PackageInfo e) {
            throw new IllegalArgumentException("List is immutable");
        }

        public void add(int index, PackageInfo element) {
            throw new IllegalArgumentException("List is immutable");
        }

        @Override // p013io.github.classgraph.InfoList, p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection
        public boolean remove(Object o) {
            throw new IllegalArgumentException("List is immutable");
        }

        @Override // p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.List, java.util.AbstractList
        public PackageInfo remove(int index) {
            throw new IllegalArgumentException("List is immutable");
        }

        @Override // p013io.github.classgraph.InfoList, p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends PackageInfo> c) {
            throw new IllegalArgumentException("List is immutable");
        }

        @Override // p013io.github.classgraph.InfoList, p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.List, java.util.AbstractList
        public boolean addAll(int index, Collection<? extends PackageInfo> c) {
            throw new IllegalArgumentException("List is immutable");
        }

        @Override // p013io.github.classgraph.InfoList, p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            throw new IllegalArgumentException("List is immutable");
        }

        @Override // p013io.github.classgraph.InfoList, p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            throw new IllegalArgumentException("List is immutable");
        }

        @Override // p013io.github.classgraph.InfoList, p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
        public void clear() {
            throw new IllegalArgumentException("List is immutable");
        }

        public PackageInfo set(int index, PackageInfo element) {
            throw new IllegalArgumentException("List is immutable");
        }
    };

    @FunctionalInterface
    /* renamed from: io.github.classgraph.PackageInfoList$PackageInfoFilter */
    /* loaded from: grasscutter.jar:io/github/classgraph/PackageInfoList$PackageInfoFilter.class */
    public interface PackageInfoFilter {
        boolean accept(PackageInfo packageInfo);
    }

    PackageInfoList() {
    }

    /* access modifiers changed from: package-private */
    public PackageInfoList(int sizeHint) {
        super(sizeHint);
    }

    /* access modifiers changed from: package-private */
    public PackageInfoList(Collection<PackageInfo> packageInfoCollection) {
        super(packageInfoCollection);
    }

    public PackageInfoList filter(PackageInfoFilter filter) {
        PackageInfoList packageInfoFiltered = new PackageInfoList();
        Iterator it = iterator();
        while (it.hasNext()) {
            PackageInfo resource = (PackageInfo) it.next();
            if (filter.accept(resource)) {
                packageInfoFiltered.add(resource);
            }
        }
        return packageInfoFiltered;
    }
}
