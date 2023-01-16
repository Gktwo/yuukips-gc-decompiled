package com.github.davidmoten.rtreemulti;

import com.github.davidmoten.rtreemulti.geometry.Geometry;
import java.util.List;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/LeafFactory.class */
public interface LeafFactory<T, S extends Geometry> {
    Leaf<T, S> createLeaf(List<Entry<T, S>> list, Context<T, S> context);
}
