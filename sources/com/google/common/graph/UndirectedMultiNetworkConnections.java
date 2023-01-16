package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: grasscutter.jar:com/google/common/graph/UndirectedMultiNetworkConnections.class */
final class UndirectedMultiNetworkConnections<N, E> extends AbstractUndirectedNetworkConnections<N, E> {
    @LazyInit
    private transient Reference<Multiset<N>> adjacentNodesReference;

    private UndirectedMultiNetworkConnections(Map<E, N> incidentEdges) {
        super(incidentEdges);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: of */
    public static <N, E> UndirectedMultiNetworkConnections<N, E> m1335of() {
        return new UndirectedMultiNetworkConnections<>(new HashMap(2, 1.0f));
    }

    /* access modifiers changed from: package-private */
    public static <N, E> UndirectedMultiNetworkConnections<N, E> ofImmutable(Map<E, N> incidentEdges) {
        return new UndirectedMultiNetworkConnections<>(ImmutableMap.copyOf(incidentEdges));
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> adjacentNodes() {
        return Collections.unmodifiableSet(adjacentNodesMultiset().elementSet());
    }

    /* access modifiers changed from: private */
    public Multiset<N> adjacentNodesMultiset() {
        Multiset<N> adjacentNodes = (Multiset) getReference(this.adjacentNodesReference);
        if (adjacentNodes == null) {
            adjacentNodes = HashMultiset.create(this.incidentEdgeMap.values());
            this.adjacentNodesReference = new SoftReference(adjacentNodes);
        }
        return adjacentNodes;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> edgesConnecting(final N node) {
        return new MultiEdgesConnecting<E>(this.incidentEdgeMap, node) { // from class: com.google.common.graph.UndirectedMultiNetworkConnections.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return UndirectedMultiNetworkConnections.this.adjacentNodesMultiset().count(node);
            }
        };
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public N removeInEdge(E edge, boolean isSelfLoop) {
        if (!isSelfLoop) {
            return removeOutEdge(edge);
        }
        return null;
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public N removeOutEdge(E edge) {
        N node = removeOutEdge(edge);
        Multiset<N> adjacentNodes = (Multiset) getReference(this.adjacentNodesReference);
        if (adjacentNodes != null) {
            Preconditions.checkState(adjacentNodes.remove(node));
        }
        return node;
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void addInEdge(E edge, N node, boolean isSelfLoop) {
        if (!isSelfLoop) {
            addOutEdge(edge, node);
        }
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void addOutEdge(E edge, N node) {
        addOutEdge(edge, node);
        Multiset<N> adjacentNodes = (Multiset) getReference(this.adjacentNodesReference);
        if (adjacentNodes != null) {
            Preconditions.checkState(adjacentNodes.add(node));
        }
    }

    private static <T> T getReference(Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }
}
