package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

@Beta
/* loaded from: grasscutter.jar:com/google/common/graph/GraphBuilder.class */
public final class GraphBuilder<N> extends AbstractGraphBuilder<N> {
    private GraphBuilder(boolean directed) {
        super(directed);
    }

    public static GraphBuilder<Object> directed() {
        return new GraphBuilder<>(true);
    }

    public static GraphBuilder<Object> undirected() {
        return new GraphBuilder<>(false);
    }

    public static <N> GraphBuilder<N> from(Graph<N> graph) {
        return (GraphBuilder<N>) new GraphBuilder(graph.isDirected()).allowsSelfLoops(graph.allowsSelfLoops()).nodeOrder(graph.nodeOrder());
    }

    public GraphBuilder<N> allowsSelfLoops(boolean allowsSelfLoops) {
        this.allowsSelfLoops = allowsSelfLoops;
        return this;
    }

    public GraphBuilder<N> expectedNodeCount(int expectedNodeCount) {
        this.expectedNodeCount = Optional.m1463of(Integer.valueOf(Graphs.checkNonNegative(expectedNodeCount)));
        return this;
    }

    public <N1 extends N> GraphBuilder<N1> nodeOrder(ElementOrder<N1> nodeOrder) {
        GraphBuilder<N1> newBuilder = cast();
        newBuilder.nodeOrder = (ElementOrder) Preconditions.checkNotNull(nodeOrder);
        return newBuilder;
    }

    public <N1 extends N> MutableGraph<N1> build() {
        return new ConfigurableMutableGraph(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.graph.GraphBuilder<N> */
    /* JADX WARN: Multi-variable type inference failed */
    private <N1 extends N> GraphBuilder<N1> cast() {
        return this;
    }
}
