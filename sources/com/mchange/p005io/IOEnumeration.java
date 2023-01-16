package com.mchange.p005io;

import java.io.IOException;

/* renamed from: com.mchange.io.IOEnumeration */
/* loaded from: grasscutter.jar:com/mchange/io/IOEnumeration.class */
public interface IOEnumeration {
    boolean hasMoreElements() throws IOException;

    Object nextElement() throws IOException;
}
