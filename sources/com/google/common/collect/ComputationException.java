package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/ComputationException.class */
public class ComputationException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public ComputationException(Throwable cause) {
        super(cause);
    }
}
