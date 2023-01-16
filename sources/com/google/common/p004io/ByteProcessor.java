package com.google.common.p004io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;

@Beta
@GwtIncompatible
/* renamed from: com.google.common.io.ByteProcessor */
/* loaded from: grasscutter.jar:com/google/common/io/ByteProcessor.class */
public interface ByteProcessor<T> {
    @CanIgnoreReturnValue
    boolean processBytes(byte[] bArr, int i, int i2) throws IOException;

    T getResult();
}
