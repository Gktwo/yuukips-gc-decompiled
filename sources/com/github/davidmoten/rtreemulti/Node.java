package com.github.davidmoten.rtreemulti;

import com.github.davidmoten.rtreemulti.geometry.Geometry;
import com.github.davidmoten.rtreemulti.geometry.HasGeometry;
import com.github.davidmoten.rtreemulti.internal.NodeAndEntries;
import java.util.List;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/Node.class */
public interface Node<T, S extends Geometry> extends HasGeometry {
    List<Node<T, S>> add(Entry<? extends T, ? extends S> entry);

    NodeAndEntries<T, S> delete(Entry<? extends T, ? extends S> entry, boolean z);

    int count();

    Context<T, S> context();

    boolean isLeaf();
}
