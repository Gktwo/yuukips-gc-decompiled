package com.github.davidmoten.rtreemulti;

import com.github.davidmoten.rtreemulti.geometry.Geometry;
import java.util.List;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/Leaf.class */
public interface Leaf<T, S extends Geometry> extends Node<T, S> {
    List<Entry<T, S>> entries();

    Entry<T, S> entry(int i);

    @Override // com.github.davidmoten.rtreemulti.Node
    default boolean isLeaf() {
        return true;
    }
}
