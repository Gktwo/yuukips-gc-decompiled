package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Beta
/* loaded from: grasscutter.jar:com/google/common/graph/Graphs.class */
public final class Graphs {

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/graph/Graphs$NodeVisitState.class */
    public enum NodeVisitState {
        PENDING,
        COMPLETE
    }

    private Graphs() {
    }

    public static <N> boolean hasCycle(Graph<N> graph) {
        int numEdges = graph.edges().size();
        if (numEdges == 0) {
            return false;
        }
        if (!graph.isDirected() && numEdges >= graph.nodes().size()) {
            return true;
        }
        Map<Object, NodeVisitState> visitedNodes = Maps.newHashMapWithExpectedSize(graph.nodes().size());
        for (N node : graph.nodes()) {
            if (subgraphHasCycle(graph, visitedNodes, node, null)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle(Network<?, ?> network) {
        if (network.isDirected() || !network.allowsParallelEdges() || network.edges().size() <= network.asGraph().edges().size()) {
            return hasCycle(network.asGraph());
        }
        return true;
    }

    private static <N> boolean subgraphHasCycle(Graph<N> graph, Map<Object, NodeVisitState> visitedNodes, N node, N previousNode) {
        NodeVisitState state = visitedNodes.get(node);
        if (state == NodeVisitState.COMPLETE) {
            return false;
        }
        if (state == NodeVisitState.PENDING) {
            return true;
        }
        visitedNodes.put(node, NodeVisitState.PENDING);
        for (N nextNode : graph.successors((Graph<N>) node)) {
            if (canTraverseWithoutReusingEdge(graph, nextNode, previousNode) && subgraphHasCycle(graph, visitedNodes, nextNode, node)) {
                return true;
            }
        }
        visitedNodes.put(node, NodeVisitState.COMPLETE);
        return false;
    }

    private static boolean canTraverseWithoutReusingEdge(Graph<?> graph, Object nextNode, Object previousNode) {
        if (graph.isDirected() || !Objects.equal(previousNode, nextNode)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.common.graph.MutableGraph, com.google.common.graph.Graph<N>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <N> com.google.common.graph.Graph<N> transitiveClosure(com.google.common.graph.Graph<N> r4) {
        /*
            r0 = r4
            com.google.common.graph.GraphBuilder r0 = com.google.common.graph.GraphBuilder.from(r0)
            r1 = 1
            com.google.common.graph.GraphBuilder r0 = r0.allowsSelfLoops(r1)
            com.google.common.graph.MutableGraph r0 = r0.build()
            r5 = r0
            r0 = r4
            boolean r0 = r0.isDirected()
            if (r0 == 0) goto L_0x0063
            r0 = r4
            java.util.Set r0 = r0.nodes()
            java.util.Iterator r0 = r0.iterator()
            r6 = r0
        L_0x0021:
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0060
            r0 = r6
            java.lang.Object r0 = r0.next()
            r7 = r0
            r0 = r4
            r1 = r7
            java.util.Set r0 = reachableNodes(r0, r1)
            java.util.Iterator r0 = r0.iterator()
            r8 = r0
        L_0x003d:
            r0 = r8
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x005d
            r0 = r8
            java.lang.Object r0 = r0.next()
            r9 = r0
            r0 = r5
            r1 = r7
            r2 = r9
            boolean r0 = r0.putEdge(r1, r2)
            goto L_0x003d
        L_0x005d:
            goto L_0x0021
        L_0x0060:
            goto L_0x00fb
        L_0x0063:
            java.util.HashSet r0 = new java.util.HashSet
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r4
            java.util.Set r0 = r0.nodes()
            java.util.Iterator r0 = r0.iterator()
            r7 = r0
        L_0x0077:
            r0 = r7
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00fb
            r0 = r7
            java.lang.Object r0 = r0.next()
            r8 = r0
            r0 = r6
            r1 = r8
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x00f8
            r0 = r4
            r1 = r8
            java.util.Set r0 = reachableNodes(r0, r1)
            r9 = r0
            r0 = r6
            r1 = r9
            boolean r0 = r0.addAll(r1)
            r0 = 1
            r10 = r0
            r0 = r9
            java.util.Iterator r0 = r0.iterator()
            r11 = r0
        L_0x00b0:
            r0 = r11
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00f8
            r0 = r11
            java.lang.Object r0 = r0.next()
            r12 = r0
            r0 = r9
            r1 = r10
            int r10 = r10 + 1
            java.lang.Iterable r0 = com.google.common.collect.Iterables.limit(r0, r1)
            java.util.Iterator r0 = r0.iterator()
            r13 = r0
        L_0x00d4:
            r0 = r13
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00f5
            r0 = r13
            java.lang.Object r0 = r0.next()
            r14 = r0
            r0 = r5
            r1 = r12
            r2 = r14
            boolean r0 = r0.putEdge(r1, r2)
            goto L_0x00d4
        L_0x00f5:
            goto L_0x00b0
        L_0x00f8:
            goto L_0x0077
        L_0x00fb:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.Graphs.transitiveClosure(com.google.common.graph.Graph):com.google.common.graph.Graph");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.graph.Graph<N> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <N> Set<N> reachableNodes(Graph<N> graph, N node) {
        Preconditions.checkArgument(graph.nodes().contains(node), "Node %s is not an element of this graph.", node);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayDeque arrayDeque = new ArrayDeque();
        linkedHashSet.add(node);
        arrayDeque.add(node);
        while (!arrayDeque.isEmpty()) {
            for (Object obj : graph.successors((Graph<N>) arrayDeque.remove())) {
                if (linkedHashSet.add(obj)) {
                    arrayDeque.add(obj);
                }
            }
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public static <N> Graph<N> transpose(Graph<N> graph) {
        if (!graph.isDirected()) {
            return graph;
        }
        if (graph instanceof TransposedGraph) {
            return ((TransposedGraph) graph).graph;
        }
        return new TransposedGraph(graph);
    }

    public static <N, V> ValueGraph<N, V> transpose(ValueGraph<N, V> graph) {
        if (!graph.isDirected()) {
            return graph;
        }
        if (graph instanceof TransposedValueGraph) {
            return ((TransposedValueGraph) graph).graph;
        }
        return new TransposedValueGraph(graph);
    }

    public static <N, E> Network<N, E> transpose(Network<N, E> network) {
        if (!network.isDirected()) {
            return network;
        }
        if (network instanceof TransposedNetwork) {
            return ((TransposedNetwork) network).network;
        }
        return new TransposedNetwork(network);
    }

    static <N> EndpointPair<N> transpose(EndpointPair<N> endpoints) {
        if (endpoints.isOrdered()) {
            return EndpointPair.ordered(endpoints.target(), endpoints.source());
        }
        return endpoints;
    }

    /* loaded from: grasscutter.jar:com/google/common/graph/Graphs$TransposedGraph.class */
    private static class TransposedGraph<N> extends ForwardingGraph<N> {
        private final Graph<N> graph;

        TransposedGraph(Graph<N> graph) {
            this.graph = graph;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.graph.ForwardingGraph
        public Graph<N> delegate() {
            return this.graph;
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        public Set<N> predecessors(N node) {
            return delegate().successors((Graph<N>) node);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public Set<N> successors(N node) {
            return delegate().predecessors((Graph<N>) node);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int inDegree(N node) {
            return delegate().outDegree(node);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int outDegree(N node) {
            return delegate().inDegree(node);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(N nodeU, N nodeV) {
            return delegate().hasEdgeConnecting(nodeV, nodeU);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(EndpointPair<N> endpoints) {
            return delegate().hasEdgeConnecting(Graphs.transpose(endpoints));
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/graph/Graphs$TransposedValueGraph.class */
    private static class TransposedValueGraph<N, V> extends ForwardingValueGraph<N, V> {
        private final ValueGraph<N, V> graph;

        TransposedValueGraph(ValueGraph<N, V> graph) {
            this.graph = graph;
        }

        @Override // com.google.common.graph.ForwardingValueGraph
        protected ValueGraph<N, V> delegate() {
            return this.graph;
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        public Set<N> predecessors(N node) {
            return delegate().successors((ValueGraph<N, V>) node);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public Set<N> successors(N node) {
            return delegate().predecessors((ValueGraph<N, V>) node);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int inDegree(N node) {
            return delegate().outDegree(node);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int outDegree(N node) {
            return delegate().inDegree(node);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(N nodeU, N nodeV) {
            return delegate().hasEdgeConnecting(nodeV, nodeU);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(EndpointPair<N> endpoints) {
            return delegate().hasEdgeConnecting(Graphs.transpose(endpoints));
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.ValueGraph
        public Optional<V> edgeValue(N nodeU, N nodeV) {
            return delegate().edgeValue(nodeV, nodeU);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.ValueGraph
        public Optional<V> edgeValue(EndpointPair<N> endpoints) {
            return delegate().edgeValue(Graphs.transpose(endpoints));
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.ValueGraph
        public V edgeValueOrDefault(N nodeU, N nodeV, V defaultValue) {
            return delegate().edgeValueOrDefault(nodeV, nodeU, defaultValue);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.ValueGraph
        public V edgeValueOrDefault(EndpointPair<N> endpoints, V defaultValue) {
            return delegate().edgeValueOrDefault(Graphs.transpose(endpoints), defaultValue);
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/graph/Graphs$TransposedNetwork.class */
    private static class TransposedNetwork<N, E> extends ForwardingNetwork<N, E> {
        private final Network<N, E> network;

        TransposedNetwork(Network<N, E> network) {
            this.network = network;
        }

        @Override // com.google.common.graph.ForwardingNetwork
        protected Network<N, E> delegate() {
            return this.network;
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        public Set<N> predecessors(N node) {
            return delegate().successors((Network<N, E>) node);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        public Set<N> successors(N node) {
            return delegate().predecessors((Network<N, E>) node);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public int inDegree(N node) {
            return delegate().outDegree(node);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public int outDegree(N node) {
            return delegate().inDegree(node);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public Set<E> inEdges(N node) {
            return delegate().outEdges(node);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public Set<E> outEdges(N node) {
            return delegate().inEdges(node);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public EndpointPair<N> incidentNodes(E edge) {
            EndpointPair<N> endpointPair = delegate().incidentNodes(edge);
            return EndpointPair.m1338of((Network<?, ?>) this.network, (Object) endpointPair.nodeV(), (Object) endpointPair.nodeU());
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Set<E> edgesConnecting(N nodeU, N nodeV) {
            return delegate().edgesConnecting(nodeV, nodeU);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Set<E> edgesConnecting(EndpointPair<N> endpoints) {
            return delegate().edgesConnecting(Graphs.transpose(endpoints));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Optional<E> edgeConnecting(N nodeU, N nodeV) {
            return delegate().edgeConnecting(nodeV, nodeU);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Optional<E> edgeConnecting(EndpointPair<N> endpoints) {
            return delegate().edgeConnecting(Graphs.transpose(endpoints));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public E edgeConnectingOrNull(N nodeU, N nodeV) {
            return delegate().edgeConnectingOrNull(nodeV, nodeU);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public E edgeConnectingOrNull(EndpointPair<N> endpoints) {
            return delegate().edgeConnectingOrNull(Graphs.transpose(endpoints));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public boolean hasEdgeConnecting(N nodeU, N nodeV) {
            return delegate().hasEdgeConnecting(nodeV, nodeU);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public boolean hasEdgeConnecting(EndpointPair<N> endpoints) {
            return delegate().hasEdgeConnecting(Graphs.transpose(endpoints));
        }
    }

    public static <N> MutableGraph<N> inducedSubgraph(Graph<N> graph, Iterable<? extends N> nodes) {
        MutableGraph<N> subgraph;
        if (nodes instanceof Collection) {
            subgraph = GraphBuilder.from(graph).expectedNodeCount(((Collection) nodes).size()).build();
        } else {
            subgraph = GraphBuilder.from(graph).build();
        }
        Iterator<? extends N> it = nodes.iterator();
        while (it.hasNext()) {
            subgraph.addNode(it.next());
        }
        for (N node : subgraph.nodes()) {
            for (N successorNode : graph.successors((Graph<N>) node)) {
                if (subgraph.nodes().contains(successorNode)) {
                    subgraph.putEdge(node, successorNode);
                }
            }
        }
        return subgraph;
    }

    public static <N, V> MutableValueGraph<N, V> inducedSubgraph(ValueGraph<N, V> graph, Iterable<? extends N> nodes) {
        MutableValueGraph<N, V> subgraph;
        if (nodes instanceof Collection) {
            subgraph = ValueGraphBuilder.from(graph).expectedNodeCount(((Collection) nodes).size()).build();
        } else {
            subgraph = ValueGraphBuilder.from(graph).build();
        }
        Iterator<? extends N> it = nodes.iterator();
        while (it.hasNext()) {
            subgraph.addNode(it.next());
        }
        for (N node : subgraph.nodes()) {
            for (N successorNode : graph.successors((ValueGraph<N, V>) node)) {
                if (subgraph.nodes().contains(successorNode)) {
                    subgraph.putEdgeValue(node, successorNode, graph.edgeValueOrDefault(node, successorNode, null));
                }
            }
        }
        return subgraph;
    }

    public static <N, E> MutableNetwork<N, E> inducedSubgraph(Network<N, E> network, Iterable<? extends N> nodes) {
        MutableNetwork<N, E> subgraph;
        if (nodes instanceof Collection) {
            subgraph = NetworkBuilder.from(network).expectedNodeCount(((Collection) nodes).size()).build();
        } else {
            subgraph = NetworkBuilder.from(network).build();
        }
        Iterator<? extends N> it = nodes.iterator();
        while (it.hasNext()) {
            subgraph.addNode(it.next());
        }
        for (N node : subgraph.nodes()) {
            for (E edge : network.outEdges(node)) {
                N successorNode = network.incidentNodes(edge).adjacentNode(node);
                if (subgraph.nodes().contains(successorNode)) {
                    subgraph.addEdge(node, successorNode, edge);
                }
            }
        }
        return subgraph;
    }

    public static <N> MutableGraph<N> copyOf(Graph<N> graph) {
        MutableGraph<N> copy = (MutableGraph<N>) GraphBuilder.from(graph).expectedNodeCount(graph.nodes().size()).build();
        for (N node : graph.nodes()) {
            copy.addNode(node);
        }
        for (EndpointPair<N> edge : graph.edges()) {
            copy.putEdge(edge.nodeU(), edge.nodeV());
        }
        return copy;
    }

    public static <N, V> MutableValueGraph<N, V> copyOf(ValueGraph<N, V> graph) {
        MutableValueGraph<N, V> copy = (MutableValueGraph<N, V>) ValueGraphBuilder.from(graph).expectedNodeCount(graph.nodes().size()).build();
        for (N node : graph.nodes()) {
            copy.addNode(node);
        }
        for (EndpointPair<N> edge : graph.edges()) {
            copy.putEdgeValue(edge.nodeU(), edge.nodeV(), graph.edgeValueOrDefault(edge.nodeU(), edge.nodeV(), null));
        }
        return copy;
    }

    public static <N, E> MutableNetwork<N, E> copyOf(Network<N, E> network) {
        MutableNetwork<N, E> copy = (MutableNetwork<N, E>) NetworkBuilder.from(network).expectedNodeCount(network.nodes().size()).expectedEdgeCount(network.edges().size()).build();
        for (N node : network.nodes()) {
            copy.addNode(node);
        }
        for (E edge : network.edges()) {
            EndpointPair<N> endpointPair = network.incidentNodes(edge);
            copy.addEdge(endpointPair.nodeU(), endpointPair.nodeV(), edge);
        }
        return copy;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static int checkNonNegative(int value) {
        Preconditions.checkArgument(value >= 0, "Not true that %s is non-negative.", value);
        return value;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static long checkNonNegative(long value) {
        Preconditions.checkArgument(value >= 0, "Not true that %s is non-negative.", value);
        return value;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static int checkPositive(int value) {
        Preconditions.checkArgument(value > 0, "Not true that %s is positive.", value);
        return value;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static long checkPositive(long value) {
        Preconditions.checkArgument(value > 0, "Not true that %s is positive.", value);
        return value;
    }
}
