package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Set;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/common/graph/AbstractBaseGraph.class */
public abstract class AbstractBaseGraph<N> implements BaseGraph<N> {
    /* JADX WARN: Type inference failed for: r0v17, types: [long] */
    protected long edgeCount() {
        char c = 0;
        for (N node : nodes()) {
            c += (long) degree(node);
        }
        Preconditions.checkState((c & 1) == 0);
        return c >>> 1;
    }

    @Override // com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> edges() {
        return new AbstractSet<EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return EndpointPairIterator.m1337of(AbstractBaseGraph.this);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return Ints.saturatedCast(AbstractBaseGraph.this.edgeCount());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object o) {
                throw new UnsupportedOperationException();
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: com.google.common.graph.AbstractBaseGraph */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair<?> endpointPair = (EndpointPair) obj;
                return AbstractBaseGraph.this.isOrderingCompatible(endpointPair) && AbstractBaseGraph.this.nodes().contains(endpointPair.nodeU()) && AbstractBaseGraph.this.successors((AbstractBaseGraph) endpointPair.nodeU()).contains(endpointPair.nodeV());
            }
        };
    }

    @Override // com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> incidentEdges(N node) {
        Preconditions.checkNotNull(node);
        Preconditions.checkArgument(nodes().contains(node), "Node %s is not an element of this graph.", node);
        return IncidentEdgeSet.m1343of((BaseGraph) this, (Object) node);
    }

    @Override // com.google.common.graph.BaseGraph
    public int degree(N node) {
        if (isDirected()) {
            return IntMath.saturatedAdd(predecessors((AbstractBaseGraph<N>) node).size(), successors((AbstractBaseGraph<N>) node).size());
        }
        Set<N> neighbors = adjacentNodes(node);
        return IntMath.saturatedAdd(neighbors.size(), (!allowsSelfLoops() || !neighbors.contains(node)) ? 0 : 1);
    }

    @Override // com.google.common.graph.BaseGraph
    public int inDegree(N node) {
        return isDirected() ? predecessors((AbstractBaseGraph<N>) node).size() : degree(node);
    }

    @Override // com.google.common.graph.BaseGraph
    public int outDegree(N node) {
        return isDirected() ? successors((AbstractBaseGraph<N>) node).size() : degree(node);
    }

    @Override // com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(N nodeU, N nodeV) {
        Preconditions.checkNotNull(nodeU);
        Preconditions.checkNotNull(nodeV);
        return nodes().contains(nodeU) && successors((AbstractBaseGraph<N>) nodeU).contains(nodeV);
    }

    @Override // com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(EndpointPair<N> endpoints) {
        Preconditions.checkNotNull(endpoints);
        if (!isOrderingCompatible(endpoints)) {
            return false;
        }
        N nodeU = endpoints.nodeU();
        return nodes().contains(nodeU) && successors((AbstractBaseGraph<N>) nodeU).contains(endpoints.nodeV());
    }

    protected final void validateEndpoints(EndpointPair<?> endpoints) {
        Preconditions.checkNotNull(endpoints);
        Preconditions.checkArgument(isOrderingCompatible(endpoints), "Mismatch: unordered endpoints cannot be used with directed graphs");
    }

    protected final boolean isOrderingCompatible(EndpointPair<?> endpoints) {
        return endpoints.isOrdered() || !isDirected();
    }

    /* loaded from: grasscutter.jar:com/google/common/graph/AbstractBaseGraph$IncidentEdgeSet.class */
    private static abstract class IncidentEdgeSet<N> extends AbstractSet<EndpointPair<N>> {
        protected final N node;
        protected final BaseGraph<N> graph;

        /* renamed from: of */
        public static <N> IncidentEdgeSet<N> m1343of(BaseGraph<N> graph, N node) {
            return graph.isDirected() ? new Directed(graph, node) : new Undirected(graph, node);
        }

        private IncidentEdgeSet(BaseGraph<N> graph, N node) {
            this.graph = graph;
            this.node = node;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:com/google/common/graph/AbstractBaseGraph$IncidentEdgeSet$Directed.class */
        public static final class Directed<N> extends IncidentEdgeSet<N> {
            private Directed(BaseGraph<N> graph, N node) {
                super(graph, node);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.graph.BaseGraph */
            /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.google.common.graph.BaseGraph */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return Iterators.unmodifiableIterator(Iterators.concat(Iterators.transform(this.graph.predecessors((BaseGraph) this.node).iterator(), new Function<N, EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Directed.1
                    @Override // com.google.common.base.Function, java.util.function.Function
                    public EndpointPair<N> apply(N predecessor) {
                        return EndpointPair.ordered(predecessor, Directed.this.node);
                    }
                }), Iterators.transform(Sets.difference(this.graph.successors((BaseGraph) this.node), ImmutableSet.m1395of(this.node)).iterator(), new Function<N, EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Directed.2
                    @Override // com.google.common.base.Function, java.util.function.Function
                    public EndpointPair<N> apply(N successor) {
                        return EndpointPair.ordered(Directed.this.node, successor);
                    }
                })));
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.graph.BaseGraph */
            /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.google.common.graph.BaseGraph */
            /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.google.common.graph.BaseGraph */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return (this.graph.inDegree(this.node) + this.graph.outDegree(this.node)) - (this.graph.successors((BaseGraph) this.node).contains(this.node) ? 1 : 0);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v19, resolved type: com.google.common.graph.BaseGraph */
            /* JADX DEBUG: Multi-variable search result rejected for r0v23, resolved type: com.google.common.graph.BaseGraph */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair<?> endpointPair = (EndpointPair) obj;
                if (!endpointPair.isOrdered()) {
                    return false;
                }
                Object source = endpointPair.source();
                Object target = endpointPair.target();
                return (this.node.equals(source) && this.graph.successors((BaseGraph) this.node).contains(target)) || (this.node.equals(target) && this.graph.predecessors((BaseGraph) this.node).contains(source));
            }
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:com/google/common/graph/AbstractBaseGraph$IncidentEdgeSet$Undirected.class */
        public static final class Undirected<N> extends IncidentEdgeSet<N> {
            private Undirected(BaseGraph<N> graph, N node) {
                super(graph, node);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.graph.BaseGraph */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return Iterators.unmodifiableIterator(Iterators.transform(this.graph.adjacentNodes(this.node).iterator(), new Function<N, EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Undirected.1
                    @Override // com.google.common.base.Function, java.util.function.Function
                    public EndpointPair<N> apply(N adjacentNode) {
                        return EndpointPair.unordered(Undirected.this.node, adjacentNode);
                    }
                }));
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.graph.BaseGraph */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.graph.adjacentNodes(this.node).size();
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: com.google.common.graph.BaseGraph */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair<?> endpointPair = (EndpointPair) obj;
                if (endpointPair.isOrdered()) {
                    return false;
                }
                Set<N> adjacent = this.graph.adjacentNodes(this.node);
                Object nodeU = endpointPair.nodeU();
                Object nodeV = endpointPair.nodeV();
                return (this.node.equals(nodeV) && adjacent.contains(nodeU)) || (this.node.equals(nodeU) && adjacent.contains(nodeV));
            }
        }
    }
}
