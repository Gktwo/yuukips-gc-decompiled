package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Optional;
import java.util.Set;

@Beta
/* loaded from: grasscutter.jar:com/google/common/graph/ValueGraph.class */
public interface ValueGraph<N, V> extends BaseGraph<N> {
    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    Set<N> nodes();

    @Override // com.google.common.graph.BaseGraph
    Set<EndpointPair<N>> edges();

    Graph<N> asGraph();

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    boolean isDirected();

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    boolean allowsSelfLoops();

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    ElementOrder<N> nodeOrder();

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    Set<N> adjacentNodes(N n);

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    Set<N> predecessors(N n);

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    Set<N> successors(N n);

    @Override // com.google.common.graph.BaseGraph
    Set<EndpointPair<N>> incidentEdges(N n);

    @Override // com.google.common.graph.BaseGraph
    int degree(N n);

    @Override // com.google.common.graph.BaseGraph
    int inDegree(N n);

    @Override // com.google.common.graph.BaseGraph
    int outDegree(N n);

    @Override // com.google.common.graph.BaseGraph
    boolean hasEdgeConnecting(N n, N n2);

    @Override // com.google.common.graph.BaseGraph
    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    Optional<V> edgeValue(N n, N n2);

    Optional<V> edgeValue(EndpointPair<N> endpointPair);

    V edgeValueOrDefault(N n, N n2, V v);

    V edgeValueOrDefault(EndpointPair<N> endpointPair, V v);

    boolean equals(Object obj);

    int hashCode();
}
