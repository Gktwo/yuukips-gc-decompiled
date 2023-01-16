package com.github.davidmoten.rtreemulti.internal;

import com.github.davidmoten.rtreemulti.Context;
import com.github.davidmoten.rtreemulti.Entry;
import com.github.davidmoten.rtreemulti.Node;
import com.github.davidmoten.rtreemulti.NonLeaf;
import com.github.davidmoten.rtreemulti.geometry.Geometry;
import com.github.davidmoten.rtreemulti.geometry.ListPair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/internal/NonLeafHelper.class */
public final class NonLeafHelper {
    private NonLeafHelper() {
    }

    public static <T, S extends Geometry> List<Node<T, S>> add(Entry<? extends T, ? extends S> entry, NonLeaf<T, S> node) {
        Context<T, S> context = node.context();
        List<Node<T, S>> children = node.children();
        Node<T, S> child = context.selector().select(entry.geometry().mbr(), children);
        List<? extends Node<T, S>> children2 = Util.replace(children, child, child.add(entry));
        if (children2.size() <= context.maxChildren()) {
            return Collections.singletonList(context.factory().createNonLeaf(children2, context));
        }
        return makeNonLeaves(context.splitter().split(children2, context.minChildren()), context);
    }

    private static <T, S extends Geometry> List<Node<T, S>> makeNonLeaves(ListPair<? extends Node<T, S>> pair, Context<T, S> context) {
        List<Node<T, S>> list = new ArrayList<>();
        list.add(context.factory().createNonLeaf(pair.group1().list(), context));
        list.add(context.factory().createNonLeaf(pair.group2().list(), context));
        return list;
    }

    public static <T, S extends Geometry> NodeAndEntries<T, S> delete(Entry<? extends T, ? extends S> entry, boolean all, NonLeaf<T, S> node) {
        List<Entry<T, S>> addTheseEntries = new ArrayList<>();
        List<Node<T, S>> removeTheseNodes = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        int countDeleted = 0;
        List<? extends Node<T, S>> children = node.children();
        for (Node<T, S> child : children) {
            if (entry.geometry().intersects(child.geometry().mbr())) {
                NodeAndEntries<T, S> result = child.delete(entry, all);
                if (!result.node().isPresent()) {
                    removeTheseNodes.add(child);
                    addTheseEntries.addAll(result.entriesToAdd());
                    countDeleted += result.countDeleted();
                    if (!all) {
                        break;
                    }
                } else if (result.node().get() != child) {
                    arrayList.add(result.node().get());
                    removeTheseNodes.add(child);
                    addTheseEntries.addAll(result.entriesToAdd());
                    countDeleted += result.countDeleted();
                    if (!all) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        if (removeTheseNodes.isEmpty()) {
            return new NodeAndEntries<>(Optional.of(node), Collections.emptyList(), 0);
        }
        List<Node<T, S>> nodes = Util.remove(children, removeTheseNodes);
        nodes.addAll(arrayList);
        if (nodes.size() == 0) {
            return new NodeAndEntries<>(Optional.empty(), addTheseEntries, countDeleted);
        }
        return new NodeAndEntries<>(Optional.of(node.context().factory().createNonLeaf(nodes, node.context())), addTheseEntries, countDeleted);
    }
}
