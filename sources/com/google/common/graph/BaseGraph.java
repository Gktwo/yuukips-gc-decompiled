package com.google.common.graph;

import java.util.Set;

/* loaded from: grasscutter.jar:com/google/common/graph/BaseGraph.class */
interface BaseGraph<N> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    @Override // com.google.common.graph.Graph
    Set<N> nodes();

    Set<EndpointPair<N>> edges();

    @Override // com.google.common.graph.Graph
    boolean isDirected();

    @Override // com.google.common.graph.Graph
    boolean allowsSelfLoops();

    @Override // com.google.common.graph.Graph
    ElementOrder<N> nodeOrder();

    @Override // com.google.common.graph.Graph
    Set<N> adjacentNodes(N n);

    @Override // com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    Set<N> predecessors(N n);

    @Override // com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    Set<N> successors(N n);

    Set<EndpointPair<N>> incidentEdges(N n);

    int degree(N n);

    int inDegree(N n);

    int outDegree(N n);

    boolean hasEdgeConnecting(N n, N n2);

    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);
}
