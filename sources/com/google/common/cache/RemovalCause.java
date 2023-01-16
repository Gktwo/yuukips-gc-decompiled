package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/cache/RemovalCause.class */
public enum RemovalCause {
    EXPLICIT {
        @Override // com.google.common.cache.RemovalCause
        boolean wasEvicted() {
            return false;
        }
    },
    REPLACED {
        @Override // com.google.common.cache.RemovalCause
        boolean wasEvicted() {
            return false;
        }
    },
    COLLECTED {
        @Override // com.google.common.cache.RemovalCause
        boolean wasEvicted() {
            return true;
        }
    },
    EXPIRED {
        @Override // com.google.common.cache.RemovalCause
        boolean wasEvicted() {
            return true;
        }
    },
    SIZE {
        @Override // com.google.common.cache.RemovalCause
        boolean wasEvicted() {
            return true;
        }
    };

    /* access modifiers changed from: package-private */
    public abstract boolean wasEvicted();
}
