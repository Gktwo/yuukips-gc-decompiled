package com.github.davidmoten.rtreemulti;

import com.github.davidmoten.rtreemulti.geometry.Geometry;
import com.github.davidmoten.rtreemulti.internal.Comparators;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/SelectorMinimalVolumeIncrease.class */
public final class SelectorMinimalVolumeIncrease implements Selector {
    public static final SelectorMinimalVolumeIncrease INSTANCE = new SelectorMinimalVolumeIncrease();

    private SelectorMinimalVolumeIncrease() {
    }

    @Override // com.github.davidmoten.rtreemulti.Selector
    public <T, S extends Geometry> Node<T, S> select(Geometry g, List<? extends Node<T, S>> nodes) {
        return (Node) Collections.min(nodes, Comparators.volumeIncreaseThenVolumeComparator(g.mbr()));
    }
}
