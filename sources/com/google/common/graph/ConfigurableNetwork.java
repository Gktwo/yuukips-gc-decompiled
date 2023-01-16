package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: grasscutter.jar:com/google/common/graph/ConfigurableNetwork.class */
class ConfigurableNetwork<N, E> extends AbstractNetwork<N, E> {
    private final boolean isDirected;
    private final boolean allowsParallelEdges;
    private final boolean allowsSelfLoops;
    private final ElementOrder<N> nodeOrder;
    private final ElementOrder<E> edgeOrder;
    protected final MapIteratorCache<N, NetworkConnections<N, E>> nodeConnections;
    protected final MapIteratorCache<E, N> edgeToReferenceNode;

    /* access modifiers changed from: package-private */
    public ConfigurableNetwork(NetworkBuilder<? super N, ? super E> builder) {
        this(builder, builder.nodeOrder.createMap(((Integer) builder.expectedNodeCount.mo1456or((Optional) 10)).intValue()), builder.edgeOrder.createMap(builder.expectedEdgeCount.mo1456or((Optional<Integer>) 20).intValue()));
    }

    /* access modifiers changed from: package-private */
    public ConfigurableNetwork(NetworkBuilder<? super N, ? super E> builder, Map<N, NetworkConnections<N, E>> nodeConnections, Map<E, N> edgeToReferenceNode) {
        this.isDirected = builder.directed;
        this.allowsParallelEdges = builder.allowsParallelEdges;
        this.allowsSelfLoops = builder.allowsSelfLoops;
        this.nodeOrder = builder.nodeOrder.cast();
        this.edgeOrder = (ElementOrder<E>) builder.edgeOrder.cast();
        this.nodeConnections = nodeConnections instanceof TreeMap ? new MapRetrievalCache<>(nodeConnections) : new MapIteratorCache<>(nodeConnections);
        this.edgeToReferenceNode = new MapIteratorCache<>(edgeToReferenceNode);
    }

    @Override // com.google.common.graph.Network
    public Set<N> nodes() {
        return this.nodeConnections.unmodifiableKeySet();
    }

    @Override // com.google.common.graph.Network
    public Set<E> edges() {
        return this.edgeToReferenceNode.unmodifiableKeySet();
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return this.isDirected;
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return this.allowsParallelEdges;
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<N> nodeOrder() {
        return this.nodeOrder;
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<E> edgeOrder() {
        return this.edgeOrder;
    }

    @Override // com.google.common.graph.Network
    public Set<E> incidentEdges(N node) {
        return checkedConnections(node).incidentEdges();
    }

    @Override // com.google.common.graph.Network
    public EndpointPair<N> incidentNodes(E edge) {
        N nodeU = checkedReferenceNode(edge);
        return EndpointPair.m1338of(this, nodeU, this.nodeConnections.get(nodeU).adjacentNode(edge));
    }

    @Override // com.google.common.graph.Network
    public Set<N> adjacentNodes(N node) {
        return checkedConnections(node).adjacentNodes();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> edgesConnecting(N nodeU, N nodeV) {
        NetworkConnections<N, E> connectionsU = checkedConnections(nodeU);
        if (!this.allowsSelfLoops && nodeU == nodeV) {
            return ImmutableSet.m1396of();
        }
        Preconditions.checkArgument(containsNode(nodeV), "Node %s is not an element of this graph.", nodeV);
        return connectionsU.edgesConnecting(nodeV);
    }

    @Override // com.google.common.graph.Network
    public Set<E> inEdges(N node) {
        return checkedConnections(node).inEdges();
    }

    @Override // com.google.common.graph.Network
    public Set<E> outEdges(N node) {
        return checkedConnections(node).outEdges();
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public Set<N> predecessors(N node) {
        return checkedConnections(node).predecessors();
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public Set<N> successors(N node) {
        return checkedConnections(node).successors();
    }

    protected final NetworkConnections<N, E> checkedConnections(N node) {
        NetworkConnections<N, E> connections = this.nodeConnections.get(node);
        if (connections != null) {
            return connections;
        }
        Preconditions.checkNotNull(node);
        throw new IllegalArgumentException(String.format("Node %s is not an element of this graph.", node));
    }

    protected final N checkedReferenceNode(E edge) {
        N referenceNode = this.edgeToReferenceNode.get(edge);
        if (referenceNode != null) {
            return referenceNode;
        }
        Preconditions.checkNotNull(edge);
        throw new IllegalArgumentException(String.format("Edge %s is not an element of this graph.", edge));
    }

    protected final boolean containsNode(N node) {
        return this.nodeConnections.containsKey(node);
    }

    protected final boolean containsEdge(E edge) {
        return this.edgeToReferenceNode.containsKey(edge);
    }
}
