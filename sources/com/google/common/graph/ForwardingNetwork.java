package com.google.common.graph;

import java.util.Optional;
import java.util.Set;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/common/graph/ForwardingNetwork.class */
public abstract class ForwardingNetwork<N, E> extends AbstractNetwork<N, E> {
    protected abstract Network<N, E> delegate();

    @Override // com.google.common.graph.Network
    public Set<N> nodes() {
        return delegate().nodes();
    }

    @Override // com.google.common.graph.Network
    public Set<E> edges() {
        return delegate().edges();
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return delegate().isDirected();
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return delegate().allowsParallelEdges();
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return delegate().allowsSelfLoops();
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<N> nodeOrder() {
        return delegate().nodeOrder();
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<E> edgeOrder() {
        return delegate().edgeOrder();
    }

    @Override // com.google.common.graph.Network
    public Set<N> adjacentNodes(N node) {
        return delegate().adjacentNodes(node);
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public Set<N> predecessors(N node) {
        return delegate().predecessors((Network<N, E>) node);
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public Set<N> successors(N node) {
        return delegate().successors((Network<N, E>) node);
    }

    @Override // com.google.common.graph.Network
    public Set<E> incidentEdges(N node) {
        return delegate().incidentEdges(node);
    }

    @Override // com.google.common.graph.Network
    public Set<E> inEdges(N node) {
        return delegate().inEdges(node);
    }

    @Override // com.google.common.graph.Network
    public Set<E> outEdges(N node) {
        return delegate().outEdges(node);
    }

    @Override // com.google.common.graph.Network
    public EndpointPair<N> incidentNodes(E edge) {
        return delegate().incidentNodes(edge);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> adjacentEdges(E edge) {
        return delegate().adjacentEdges(edge);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int degree(N node) {
        return delegate().degree(node);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int inDegree(N node) {
        return delegate().inDegree(node);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int outDegree(N node) {
        return delegate().outDegree(node);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> edgesConnecting(N nodeU, N nodeV) {
        return delegate().edgesConnecting(nodeU, nodeV);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> edgesConnecting(EndpointPair<N> endpoints) {
        return delegate().edgesConnecting(endpoints);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Optional<E> edgeConnecting(N nodeU, N nodeV) {
        return delegate().edgeConnecting(nodeU, nodeV);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Optional<E> edgeConnecting(EndpointPair<N> endpoints) {
        return delegate().edgeConnecting(endpoints);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public E edgeConnectingOrNull(N nodeU, N nodeV) {
        return delegate().edgeConnectingOrNull(nodeU, nodeV);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public E edgeConnectingOrNull(EndpointPair<N> endpoints) {
        return delegate().edgeConnectingOrNull(endpoints);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public boolean hasEdgeConnecting(N nodeU, N nodeV) {
        return delegate().hasEdgeConnecting(nodeU, nodeV);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public boolean hasEdgeConnecting(EndpointPair<N> endpoints) {
        return delegate().hasEdgeConnecting(endpoints);
    }
}
