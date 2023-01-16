package com.github.davidmoten.rtreemulti;

import com.github.davidmoten.rtreemulti.geometry.Geometry;
import java.util.List;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/Selector.class */
public interface Selector {
    <T, S extends Geometry> Node<T, S> select(Geometry geometry, List<? extends Node<T, S>> list);
}
