package org.eclipse.jetty.http.pathmap;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/pathmap/PathSpecSet.class */
public class PathSpecSet extends AbstractSet<String> implements Predicate<String> {
    private final PathMappings<Boolean> specs = new PathMappings<>();

    public boolean test(String s) {
        return this.specs.getMatched(s) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.specs.size();
    }

    private PathSpec asPathSpec(Object o) {
        if (o == null) {
            return null;
        }
        if (o instanceof PathSpec) {
            return (PathSpec) o;
        }
        return PathSpec.from(Objects.toString(o));
    }

    public boolean add(String s) {
        return this.specs.put(PathSpec.from(s), (PathSpec) Boolean.TRUE);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o) {
        return this.specs.remove(asPathSpec(o));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.specs.reset();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator<String> iterator() {
        final Iterator<MappedResource<Boolean>> iterator = this.specs.iterator();
        return new Iterator<String>() { // from class: org.eclipse.jetty.http.pathmap.PathSpecSet.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override // java.util.Iterator
            public String next() {
                return ((MappedResource) iterator.next()).getPathSpec().getDeclaration();
            }
        };
    }
}
