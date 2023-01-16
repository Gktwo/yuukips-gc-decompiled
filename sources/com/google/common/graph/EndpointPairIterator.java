package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;

/* loaded from: grasscutter.jar:com/google/common/graph/EndpointPairIterator.class */
abstract class EndpointPairIterator<N> extends AbstractIterator<EndpointPair<N>> {
    private final BaseGraph<N> graph;
    private final Iterator<N> nodeIterator;
    protected N node;
    protected Iterator<N> successorIterator;

    /* access modifiers changed from: package-private */
    /* renamed from: of */
    public static <N> EndpointPairIterator<N> m1337of(BaseGraph<N> graph) {
        return graph.isDirected() ? new Directed(graph) : new Undirected(graph);
    }

    private EndpointPairIterator(BaseGraph<N> graph) {
        this.node = null;
        this.successorIterator = ImmutableSet.m1396of().iterator();
        this.graph = graph;
        this.nodeIterator = graph.nodes().iterator();
    }

    protected final boolean advance() {
        Preconditions.checkState(!this.successorIterator.hasNext());
        if (!this.nodeIterator.hasNext()) {
            return false;
        }
        this.node = this.nodeIterator.next();
        this.successorIterator = this.graph.successors((BaseGraph<N>) this.node).iterator();
        return true;
    }

    /* loaded from: grasscutter.jar:com/google/common/graph/EndpointPairIterator$Directed.class */
    private static final class Directed<N> extends EndpointPairIterator<N> {
        private Directed(BaseGraph<N> graph) {
            super(graph);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        public EndpointPair<N> computeNext() {
            while (!this.successorIterator.hasNext()) {
                if (!advance()) {
                    return endOfData();
                }
            }
            return EndpointPair.ordered(this.node, this.successorIterator.next());
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/graph/EndpointPairIterator$Undirected.class */
    private static final class Undirected<N> extends EndpointPairIterator<N> {
        private Set<N> visitedNodes;

        private Undirected(BaseGraph<N> graph) {
            super(graph);
            this.visitedNodes = Sets.newHashSetWithExpectedSize(graph.nodes().size());
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: java.util.Set<N> */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        public EndpointPair<N> computeNext() {
            while (true) {
                if (this.successorIterator.hasNext()) {
                    Object next = this.successorIterator.next();
                    if (!this.visitedNodes.contains(next)) {
                        return EndpointPair.unordered(this.node, next);
                    }
                } else {
                    this.visitedNodes.add(this.node);
                    if (!advance()) {
                        this.visitedNodes = null;
                        return endOfData();
                    }
                }
            }
        }
    }
}
