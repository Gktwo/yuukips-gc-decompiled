package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;

/* access modifiers changed from: package-private */
@GwtIncompatible
/* loaded from: grasscutter.jar:com/google/common/base/PatternCompiler.class */
public interface PatternCompiler {
    CommonPattern compile(String str);

    boolean isPcreLike();
}
