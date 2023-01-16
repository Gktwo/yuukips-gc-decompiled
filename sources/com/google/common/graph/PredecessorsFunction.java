package com.google.common.graph;

import com.google.common.annotations.Beta;

@Beta
/* loaded from: grasscutter.jar:com/google/common/graph/PredecessorsFunction.class */
public interface PredecessorsFunction<N> {
    @Override // com.google.common.graph.Graph
    Iterable<? extends N> predecessors(N n);
}
