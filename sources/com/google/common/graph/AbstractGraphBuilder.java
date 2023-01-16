package com.google.common.graph;

import com.google.common.base.Optional;

/* loaded from: grasscutter.jar:com/google/common/graph/AbstractGraphBuilder.class */
abstract class AbstractGraphBuilder<N> {
    final boolean directed;
    boolean allowsSelfLoops = false;
    ElementOrder<N> nodeOrder = ElementOrder.insertion();
    Optional<Integer> expectedNodeCount = Optional.absent();

    /* access modifiers changed from: package-private */
    public AbstractGraphBuilder(boolean directed) {
        this.directed = directed;
    }
}
