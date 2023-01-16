package com.github.davidmoten.rtreemulti.internal;

import com.github.davidmoten.rtreemulti.Context;
import com.github.davidmoten.rtreemulti.Entry;
import com.github.davidmoten.rtreemulti.Leaf;
import com.github.davidmoten.rtreemulti.Node;
import com.github.davidmoten.rtreemulti.geometry.Geometry;
import com.github.davidmoten.rtreemulti.geometry.ListPair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/internal/LeafHelper.class */
public final class LeafHelper {
    private LeafHelper() {
    }

    public static <T, S extends Geometry> NodeAndEntries<T, S> delete(Entry<? extends T, ? extends S> entry, boolean all, Leaf<T, S> leaf) {
        List<Entry<T, S>> entries = leaf.entries();
        if (!entries.contains(entry)) {
            return new NodeAndEntries<>(Optional.of(leaf), Collections.emptyList(), 0);
        }
        List<Entry<T, S>> entries2 = new ArrayList<>(entries);
        entries2.remove(entry);
        int numDeleted = 1;
        while (all && entries2.remove(entry)) {
            numDeleted++;
        }
        if (entries2.size() >= leaf.context().minChildren()) {
            return new NodeAndEntries<>(Optional.of(leaf.context().factory().createLeaf(entries2, leaf.context())), Collections.emptyList(), numDeleted);
        }
        return new NodeAndEntries<>(Optional.empty(), entries2, numDeleted);
    }

    public static <T, S extends Geometry> List<Node<T, S>> add(Entry<? extends T, ? extends S> entry, Leaf<T, S> leaf) {
        List<Entry<T, S>> entries = leaf.entries();
        Context<T, S> context = leaf.context();
        List<Entry<T, S>> entries2 = Util.add(entries, entry);
        if (entries2.size() <= context.maxChildren()) {
            return Collections.singletonList(context.factory().createLeaf(entries2, context));
        }
        return makeLeaves(context.splitter().split(entries2, context.minChildren()), context);
    }

    private static <T, S extends Geometry> List<Node<T, S>> makeLeaves(ListPair<Entry<T, S>> pair, Context<T, S> context) {
        List<Node<T, S>> list = new ArrayList<>(2);
        list.add(context.factory().createLeaf(pair.group1().list(), context));
        list.add(context.factory().createLeaf(pair.group2().list(), context));
        return list;
    }
}
