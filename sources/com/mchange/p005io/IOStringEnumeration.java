package com.mchange.p005io;

import java.io.IOException;

/* renamed from: com.mchange.io.IOStringEnumeration */
/* loaded from: grasscutter.jar:com/mchange/io/IOStringEnumeration.class */
public interface IOStringEnumeration extends IOEnumeration {
    boolean hasMoreStrings() throws IOException;

    String nextString() throws IOException;
}
