package com.google.common.p004io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;

@Beta
@GwtIncompatible
/* renamed from: com.google.common.io.LineProcessor */
/* loaded from: grasscutter.jar:com/google/common/io/LineProcessor.class */
public interface LineProcessor<T> {
    @CanIgnoreReturnValue
    boolean processLine(String str) throws IOException;

    T getResult();
}
