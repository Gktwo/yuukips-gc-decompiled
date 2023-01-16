package com.github.davidmoten.rtreemulti;

import com.github.davidmoten.rtreemulti.geometry.Geometry;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/EntryFactory.class */
public interface EntryFactory<T, S extends Geometry> {
    Entry<T, S> createEntry(T t, S s);
}
