package com.github.davidmoten.rtreemulti.internal;

import com.github.davidmoten.rtreemulti.Context;
import com.github.davidmoten.rtreemulti.Entry;
import com.github.davidmoten.rtreemulti.Leaf;
import com.github.davidmoten.rtreemulti.Node;
import com.github.davidmoten.rtreemulti.geometry.Geometry;
import com.github.davidmoten.rtreemulti.geometry.Rectangle;
import java.util.List;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/internal/LeafDefault.class */
public final class LeafDefault<T, S extends Geometry> implements Leaf<T, S> {
    private final List<Entry<T, S>> entries;
    private final Rectangle mbr;
    private final Context<T, S> context;

    public LeafDefault(List<Entry<T, S>> entries, Context<T, S> context) {
        this.entries = entries;
        this.context = context;
        this.mbr = Util.mbr(entries);
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.HasGeometry
    public Geometry geometry() {
        return this.mbr;
    }

    @Override // com.github.davidmoten.rtreemulti.Leaf
    public List<Entry<T, S>> entries() {
        return this.entries;
    }

    @Override // com.github.davidmoten.rtreemulti.Node
    public int count() {
        return this.entries.size();
    }

    @Override // com.github.davidmoten.rtreemulti.Node
    public List<Node<T, S>> add(Entry<? extends T, ? extends S> entry) {
        return LeafHelper.add(entry, this);
    }

    @Override // com.github.davidmoten.rtreemulti.Node
    public NodeAndEntries<T, S> delete(Entry<? extends T, ? extends S> entry, boolean all) {
        return LeafHelper.delete(entry, all, this);
    }

    @Override // com.github.davidmoten.rtreemulti.Node
    public Context<T, S> context() {
        return this.context;
    }

    @Override // com.github.davidmoten.rtreemulti.Leaf
    public Entry<T, S> entry(int i) {
        return this.entries.get(i);
    }

    public String toString() {
        return "LeafDefault [mbr=" + this.mbr + ", entries=" + this.entries + "]";
    }
}
