package com.github.davidmoten.rtreemulti.internal;

import com.github.davidmoten.guavamini.Objects;
import com.github.davidmoten.guavamini.Preconditions;
import com.github.davidmoten.rtreemulti.Entry;
import com.github.davidmoten.rtreemulti.geometry.Geometry;
import com.github.davidmoten.rtreemulti.internal.util.ObjectsHelper;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/internal/EntryDefault.class */
public final class EntryDefault<T, S extends Geometry> implements Entry<T, S> {
    private final T value;
    private final S geometry;

    public EntryDefault(T value, S geometry) {
        Preconditions.checkNotNull(geometry);
        this.value = value;
        this.geometry = geometry;
    }

    public static <T, S extends Geometry> Entry<T, S> entry(T value, S geometry) {
        return new EntryDefault(value, geometry);
    }

    @Override // com.github.davidmoten.rtreemulti.Entry
    public T value() {
        return this.value;
    }

    @Override // com.github.davidmoten.rtreemulti.Entry, com.github.davidmoten.rtreemulti.geometry.HasGeometry
    public S geometry() {
        return this.geometry;
    }

    public String toString() {
        return "Entry [value=" + this.value + ", geometry=" + this.geometry + "]";
    }

    public int hashCode() {
        return Objects.hashCode(this.value, this.geometry);
    }

    public boolean equals(Object obj) {
        EntryDefault other = (EntryDefault) ObjectsHelper.asClass(obj, EntryDefault.class);
        return other != null && Objects.equal(this.value, other.value) && Objects.equal(this.geometry, other.geometry);
    }
}
