package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/common/graph/UndirectedGraphConnections.class */
public final class UndirectedGraphConnections<N, V> implements GraphConnections<N, V> {
    private final Map<N, V> adjacentNodeValues;

    private UndirectedGraphConnections(Map<N, V> adjacentNodeValues) {
        this.adjacentNodeValues = (Map) Preconditions.checkNotNull(adjacentNodeValues);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: of */
    public static <N, V> UndirectedGraphConnections<N, V> m1336of() {
        return new UndirectedGraphConnections<>(new HashMap(2, 1.0f));
    }

    /* access modifiers changed from: package-private */
    public static <N, V> UndirectedGraphConnections<N, V> ofImmutable(Map<N, V> adjacentNodeValues) {
        return new UndirectedGraphConnections<>(ImmutableMap.copyOf(adjacentNodeValues));
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> adjacentNodes() {
        return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> predecessors() {
        return adjacentNodes();
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> successors() {
        return adjacentNodes();
    }

    @Override // com.google.common.graph.GraphConnections
    public V value(N node) {
        return this.adjacentNodeValues.get(node);
    }

    @Override // com.google.common.graph.GraphConnections
    public void removePredecessor(N node) {
        removeSuccessor(node);
    }

    @Override // com.google.common.graph.GraphConnections
    public V removeSuccessor(N node) {
        return this.adjacentNodeValues.remove(node);
    }

    @Override // com.google.common.graph.GraphConnections
    public void addPredecessor(N node, V value) {
        addSuccessor(node, value);
    }

    @Override // com.google.common.graph.GraphConnections
    public V addSuccessor(N node, V value) {
        return this.adjacentNodeValues.put(node, value);
    }
}
