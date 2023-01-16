package com.google.common.graph;

import com.google.common.annotations.Beta;

@Beta
/* loaded from: grasscutter.jar:com/google/common/graph/SuccessorsFunction.class */
public interface SuccessorsFunction<N> {
    @Override // com.google.common.graph.Graph
    Iterable<? extends N> successors(N n);
}
