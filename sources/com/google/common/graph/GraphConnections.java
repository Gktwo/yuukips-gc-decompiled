package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Set;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/common/graph/GraphConnections.class */
public interface GraphConnections<N, V> {
    Set<N> adjacentNodes();

    Set<N> predecessors();

    Set<N> successors();

    V value(N n);

    void removePredecessor(N n);

    @CanIgnoreReturnValue
    V removeSuccessor(N n);

    void addPredecessor(N n, V v);

    @CanIgnoreReturnValue
    V addSuccessor(N n, V v);
}
