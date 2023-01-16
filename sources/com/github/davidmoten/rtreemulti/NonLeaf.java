package com.github.davidmoten.rtreemulti;

import com.github.davidmoten.rtreemulti.geometry.Geometry;
import java.util.List;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/NonLeaf.class */
public interface NonLeaf<T, S extends Geometry> extends Node<T, S> {
    Node<T, S> child(int i);

    List<Node<T, S>> children();

    @Override // com.github.davidmoten.rtreemulti.Node
    default boolean isLeaf() {
        return false;
    }
}
