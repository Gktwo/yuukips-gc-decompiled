package com.github.davidmoten.rtreemulti.internal;

import com.github.davidmoten.rtreemulti.Entry;
import com.github.davidmoten.rtreemulti.Node;
import com.github.davidmoten.rtreemulti.geometry.Geometry;
import java.util.List;
import java.util.Optional;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/internal/NodeAndEntries.class */
public final class NodeAndEntries<T, S extends Geometry> {
    private final Optional<? extends Node<T, S>> node;
    private final List<Entry<T, S>> entries;
    private final int count;

    public NodeAndEntries(Optional<? extends Node<T, S>> node, List<Entry<T, S>> entries, int countDeleted) {
        this.node = node;
        this.entries = entries;
        this.count = countDeleted;
    }

    public Optional<? extends Node<T, S>> node() {
        return this.node;
    }

    public List<Entry<T, S>> entriesToAdd() {
        return this.entries;
    }

    public int countDeleted() {
        return this.count;
    }
}
