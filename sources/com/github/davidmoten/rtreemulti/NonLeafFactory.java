package com.github.davidmoten.rtreemulti;

import com.github.davidmoten.rtreemulti.geometry.Geometry;
import java.util.List;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/NonLeafFactory.class */
public interface NonLeafFactory<T, S extends Geometry> {
    NonLeaf<T, S> createNonLeaf(List<? extends Node<T, S>> list, Context<T, S> context);
}
