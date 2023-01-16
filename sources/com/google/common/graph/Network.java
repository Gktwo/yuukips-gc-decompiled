package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Optional;
import java.util.Set;

@Beta
/* loaded from: grasscutter.jar:com/google/common/graph/Network.class */
public interface Network<N, E> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    Set<N> nodes();

    Set<E> edges();

    Graph<N> asGraph();

    boolean isDirected();

    boolean allowsParallelEdges();

    boolean allowsSelfLoops();

    ElementOrder<N> nodeOrder();

    ElementOrder<E> edgeOrder();

    Set<N> adjacentNodes(N n);

    @Override // com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    Set<N> predecessors(N n);

    @Override // com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    Set<N> successors(N n);

    Set<E> incidentEdges(N n);

    Set<E> inEdges(N n);

    Set<E> outEdges(N n);

    int degree(N n);

    int inDegree(N n);

    int outDegree(N n);

    EndpointPair<N> incidentNodes(E e);

    Set<E> adjacentEdges(E e);

    Set<E> edgesConnecting(N n, N n2);

    Set<E> edgesConnecting(EndpointPair<N> endpointPair);

    Optional<E> edgeConnecting(N n, N n2);

    Optional<E> edgeConnecting(EndpointPair<N> endpointPair);

    E edgeConnectingOrNull(N n, N n2);

    E edgeConnectingOrNull(EndpointPair<N> endpointPair);

    boolean hasEdgeConnecting(N n, N n2);

    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    boolean equals(Object obj);

    int hashCode();
}
