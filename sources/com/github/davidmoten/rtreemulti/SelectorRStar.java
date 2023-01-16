package com.github.davidmoten.rtreemulti;

import com.github.davidmoten.rtreemulti.geometry.Geometry;
import java.util.List;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/SelectorRStar.class */
public final class SelectorRStar implements Selector {
    public static final SelectorRStar INSTANCE = new SelectorRStar();

    private SelectorRStar() {
    }

    @Override // com.github.davidmoten.rtreemulti.Selector
    public <T, S extends Geometry> Node<T, S> select(Geometry g, List<? extends Node<T, S>> nodes) {
        if (((Node) nodes.get(0)).isLeaf()) {
            return SelectorMinimalOverlapVolume.INSTANCE.select(g, nodes);
        }
        return SelectorMinimalVolumeIncrease.INSTANCE.select(g, nodes);
    }
}
