package com.github.davidmoten.rtreemulti.internal;

import com.github.davidmoten.rtreemulti.Context;
import com.github.davidmoten.rtreemulti.Entry;
import com.github.davidmoten.rtreemulti.Factory;
import com.github.davidmoten.rtreemulti.Leaf;
import com.github.davidmoten.rtreemulti.Node;
import com.github.davidmoten.rtreemulti.NonLeaf;
import com.github.davidmoten.rtreemulti.geometry.Geometry;
import java.util.List;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/internal/FactoryDefault.class */
public final class FactoryDefault<T, S extends Geometry> implements Factory<T, S> {

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/internal/FactoryDefault$Holder.class */
    public static class Holder {
        private static final Factory<Object, Geometry> INSTANCE = new FactoryDefault();

        private Holder() {
        }
    }

    public static <T, S extends Geometry> Factory<T, S> instance() {
        return Holder.INSTANCE;
    }

    @Override // com.github.davidmoten.rtreemulti.LeafFactory
    public Leaf<T, S> createLeaf(List<Entry<T, S>> entries, Context<T, S> context) {
        return new LeafDefault(entries, context);
    }

    @Override // com.github.davidmoten.rtreemulti.NonLeafFactory
    public NonLeaf<T, S> createNonLeaf(List<? extends Node<T, S>> children, Context<T, S> context) {
        return new NonLeafDefault(children, context);
    }

    @Override // com.github.davidmoten.rtreemulti.EntryFactory
    public Entry<T, S> createEntry(T value, S geometry) {
        return Entry.entry(value, geometry);
    }
}
