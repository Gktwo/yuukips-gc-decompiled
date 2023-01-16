package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.Immutable;
import java.util.Set;

@Immutable(containerOf = {"N", "V"})
@Beta
/* loaded from: grasscutter.jar:com/google/common/graph/ImmutableValueGraph.class */
public final class ImmutableValueGraph<N, V> extends ConfigurableValueGraph<N, V> {
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.ValueGraph
    public /* bridge */ /* synthetic */ Object edgeValueOrDefault(EndpointPair endpointPair, Object obj) {
        return edgeValueOrDefault(endpointPair, obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.ValueGraph
    public /* bridge */ /* synthetic */ Object edgeValueOrDefault(Object obj, Object obj2, Object obj3) {
        return edgeValueOrDefault(obj, obj2, obj3);
    }

    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(EndpointPair endpointPair) {
        return hasEdgeConnecting(endpointPair);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(Object obj, Object obj2) {
        return hasEdgeConnecting(obj, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set successors(Object obj) {
        return successors((ImmutableValueGraph<N, V>) obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set predecessors(Object obj) {
        return predecessors((ImmutableValueGraph<N, V>) obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set adjacentNodes(Object obj) {
        return adjacentNodes(obj);
    }

    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ ElementOrder nodeOrder() {
        return nodeOrder();
    }

    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return allowsSelfLoops();
    }

    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean isDirected() {
        return isDirected();
    }

    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set nodes() {
        return nodes();
    }

    private ImmutableValueGraph(ValueGraph<N, V> graph) {
        super(ValueGraphBuilder.from(graph), getNodeConnections(graph), (long) graph.edges().size());
    }

    public static <N, V> ImmutableValueGraph<N, V> copyOf(ValueGraph<N, V> graph) {
        return graph instanceof ImmutableValueGraph ? (ImmutableValueGraph) graph : new ImmutableValueGraph<>(graph);
    }

    @Deprecated
    public static <N, V> ImmutableValueGraph<N, V> copyOf(ImmutableValueGraph<N, V> graph) {
        return (ImmutableValueGraph) Preconditions.checkNotNull(graph);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.ValueGraph
    public ImmutableGraph<N> asGraph() {
        return new ImmutableGraph<>(this);
    }

    private static <N, V> ImmutableMap<N, GraphConnections<N, V>> getNodeConnections(ValueGraph<N, V> graph) {
        ImmutableMap.Builder<N, GraphConnections<N, V>> nodeConnections = ImmutableMap.builder();
        for (N node : graph.nodes()) {
            nodeConnections.put(node, connectionsOf(graph, node));
        }
        return nodeConnections.build();
    }

    private static <N, V> GraphConnections<N, V> connectionsOf(final ValueGraph<N, V> graph, final N node) {
        Function<N, V> successorNodeToValueFn = new Function<N, V>() { // from class: com.google.common.graph.ImmutableValueGraph.1
            /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.graph.ValueGraph */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.base.Function, java.util.function.Function
            public V apply(N successorNode) {
                return (V) graph.edgeValueOrDefault(node, successorNode, null);
            }
        };
        if (graph.isDirected()) {
            return DirectedGraphConnections.ofImmutable(graph.predecessors((ValueGraph<N, V>) node), Maps.asMap(graph.successors((ValueGraph<N, V>) node), successorNodeToValueFn));
        }
        return UndirectedGraphConnections.ofImmutable(Maps.asMap(graph.adjacentNodes(node), successorNodeToValueFn));
    }
}
