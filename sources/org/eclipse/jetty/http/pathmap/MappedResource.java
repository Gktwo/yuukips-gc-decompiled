package org.eclipse.jetty.http.pathmap;

import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;

@ManagedObject("Mapped Resource")
/* loaded from: grasscutter.jar:org/eclipse/jetty/http/pathmap/MappedResource.class */
public class MappedResource<E> implements Comparable<MappedResource<E>> {
    private final PathSpec pathSpec;
    private final E resource;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((MappedResource) ((MappedResource) obj));
    }

    public MappedResource(PathSpec pathSpec, E resource) {
        this.pathSpec = pathSpec;
        this.resource = resource;
    }

    public int compareTo(MappedResource<E> other) {
        return this.pathSpec.compareTo(other.pathSpec);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MappedResource<?> other = (MappedResource) obj;
        if (this.pathSpec == null) {
            return other.pathSpec == null;
        }
        return this.pathSpec.equals(other.pathSpec);
    }

    @ManagedAttribute(value = "path spec", readonly = true)
    public PathSpec getPathSpec() {
        return this.pathSpec;
    }

    @ManagedAttribute(value = "resource", readonly = true)
    public E getResource() {
        return this.resource;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (31 * 1) + (this.pathSpec == null ? 0 : this.pathSpec.hashCode());
    }

    @Override // java.lang.Object
    public String toString() {
        return String.format("MappedResource[pathSpec=%s,resource=%s]", this.pathSpec, this.resource);
    }
}
