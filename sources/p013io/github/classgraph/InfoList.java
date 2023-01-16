package p013io.github.classgraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import p013io.github.classgraph.HasName;

/* renamed from: io.github.classgraph.InfoList */
/* loaded from: grasscutter.jar:io/github/classgraph/InfoList.class */
public class InfoList<T extends HasName> extends PotentiallyUnmodifiableList<T> {
    static final long serialVersionUID = 1;

    @Override // p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.List, java.util.AbstractList
    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return listIterator();
    }

    @Override // p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public /* bridge */ /* synthetic */ void clear() {
        clear();
    }

    @Override // p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return retainAll(collection);
    }

    @Override // p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return removeAll(collection);
    }

    @Override // p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.List, java.util.AbstractList
    public /* bridge */ /* synthetic */ boolean addAll(int i, Collection collection) {
        return addAll(i, collection);
    }

    @Override // p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return addAll(collection);
    }

    @Override // p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return remove(obj);
    }

    /* access modifiers changed from: package-private */
    public InfoList() {
    }

    /* access modifiers changed from: package-private */
    public InfoList(int sizeHint) {
        super(sizeHint);
    }

    /* access modifiers changed from: package-private */
    public InfoList(Collection<T> infoCollection) {
        super(infoCollection);
    }

    @Override // p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Object
    public boolean equals(Object o) {
        return equals(o);
    }

    @Override // p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Object
    public int hashCode() {
        return hashCode();
    }

    public List<String> getNames() {
        if (isEmpty()) {
            return Collections.emptyList();
        }
        List<String> names = new ArrayList<>(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            HasName hasName = (HasName) it.next();
            if (hasName != null) {
                names.add(hasName.getName());
            }
        }
        return names;
    }

    public List<String> getAsStrings() {
        if (isEmpty()) {
            return Collections.emptyList();
        }
        List<String> toStringVals = new ArrayList<>(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            HasName hasName = (HasName) it.next();
            toStringVals.add(hasName == null ? "null" : hasName.toString());
        }
        return toStringVals;
    }
}
