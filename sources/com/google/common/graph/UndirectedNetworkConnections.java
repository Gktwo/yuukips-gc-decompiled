package com.google.common.graph;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* loaded from: grasscutter.jar:com/google/common/graph/UndirectedNetworkConnections.class */
final class UndirectedNetworkConnections<N, E> extends AbstractUndirectedNetworkConnections<N, E> {
    protected UndirectedNetworkConnections(Map<E, N> incidentEdgeMap) {
        super(incidentEdgeMap);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: of */
    public static <N, E> UndirectedNetworkConnections<N, E> m1334of() {
        return new UndirectedNetworkConnections<>(HashBiMap.create(2));
    }

    /* access modifiers changed from: package-private */
    public static <N, E> UndirectedNetworkConnections<N, E> ofImmutable(Map<E, N> incidentEdges) {
        return new UndirectedNetworkConnections<>(ImmutableBiMap.copyOf((Map) incidentEdges));
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> adjacentNodes() {
        return Collections.unmodifiableSet(((BiMap) this.incidentEdgeMap).values());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> edgesConnecting(N node) {
        return new EdgesConnecting(((BiMap) this.incidentEdgeMap).inverse(), node);
    }
}
