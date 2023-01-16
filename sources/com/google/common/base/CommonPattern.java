package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

/* access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/base/CommonPattern.class */
public abstract class CommonPattern {
    public abstract CommonMatcher matcher(CharSequence charSequence);

    public abstract String pattern();

    public abstract int flags();

    @Override // java.lang.Object
    public abstract String toString();

    public static CommonPattern compile(String pattern) {
        return Platform.compilePattern(pattern);
    }

    public static boolean isPcreLike() {
        return Platform.patternCompilerIsPcreLike();
    }
}
