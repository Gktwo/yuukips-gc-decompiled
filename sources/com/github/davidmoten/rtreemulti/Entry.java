package com.github.davidmoten.rtreemulti;

import com.github.davidmoten.rtreemulti.geometry.Geometry;
import com.github.davidmoten.rtreemulti.geometry.HasGeometry;
import com.github.davidmoten.rtreemulti.internal.EntryDefault;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/Entry.class */
public interface Entry<T, S extends Geometry> extends HasGeometry {
    T value();

    @Override // com.github.davidmoten.rtreemulti.geometry.HasGeometry
    S geometry();

    static <T, S extends Geometry> Entry<T, S> entry(T object, S geometry) {
        return EntryDefault.entry(object, geometry);
    }
}
