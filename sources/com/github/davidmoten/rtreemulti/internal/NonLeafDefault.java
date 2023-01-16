package com.github.davidmoten.rtreemulti.internal;

import com.github.davidmoten.guavamini.Preconditions;
import com.github.davidmoten.rtreemulti.Context;
import com.github.davidmoten.rtreemulti.Entry;
import com.github.davidmoten.rtreemulti.Node;
import com.github.davidmoten.rtreemulti.NonLeaf;
import com.github.davidmoten.rtreemulti.geometry.Geometry;
import com.github.davidmoten.rtreemulti.geometry.Rectangle;
import java.util.List;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/internal/NonLeafDefault.class */
public final class NonLeafDefault<T, S extends Geometry> implements NonLeaf<T, S> {
    private final List<? extends Node<T, S>> children;
    private final Rectangle mbr;
    private final Context<T, S> context;

    public NonLeafDefault(List<? extends Node<T, S>> children, Context<T, S> context) {
        Preconditions.checkArgument(!children.isEmpty());
        this.context = context;
        this.children = children;
        this.mbr = Util.mbr(children);
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.HasGeometry
    public Geometry geometry() {
        return this.mbr;
    }

    @Override // com.github.davidmoten.rtreemulti.Node
    public int count() {
        return this.children.size();
    }

    @Override // com.github.davidmoten.rtreemulti.Node
    public List<Node<T, S>> add(Entry<? extends T, ? extends S> entry) {
        return NonLeafHelper.add(entry, this);
    }

    @Override // com.github.davidmoten.rtreemulti.Node
    public NodeAndEntries<T, S> delete(Entry<? extends T, ? extends S> entry, boolean all) {
        return NonLeafHelper.delete(entry, all, this);
    }

    @Override // com.github.davidmoten.rtreemulti.Node
    public Context<T, S> context() {
        return this.context;
    }

    @Override // com.github.davidmoten.rtreemulti.NonLeaf
    public Node<T, S> child(int i) {
        return (Node) this.children.get(i);
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.List<? extends com.github.davidmoten.rtreemulti.Node<T, S extends com.github.davidmoten.rtreemulti.geometry.Geometry>>, java.util.List<com.github.davidmoten.rtreemulti.Node<T, S extends com.github.davidmoten.rtreemulti.geometry.Geometry>> */
    @Override // com.github.davidmoten.rtreemulti.NonLeaf
    public List<Node<T, S>> children() {
        return (List<? extends Node<T, S>>) this.children;
    }

    public String toString() {
        return "NonLeafDefault [mbr=" + this.mbr + ", children=" + this.children + "]";
    }
}
