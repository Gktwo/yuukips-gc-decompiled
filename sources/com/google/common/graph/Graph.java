package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Set;

@Beta
/* loaded from: grasscutter.jar:com/google/common/graph/Graph.class */
public interface Graph<N> extends BaseGraph<N> {
    Set<N> nodes();

    @Override // com.google.common.graph.BaseGraph
    Set<EndpointPair<N>> edges();

    boolean isDirected();

    boolean allowsSelfLoops();

    ElementOrder<N> nodeOrder();

    Set<N> adjacentNodes(N n);

    Set<N> predecessors(N n);

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

    boolean equals(Object obj);

    int hashCode();
}
