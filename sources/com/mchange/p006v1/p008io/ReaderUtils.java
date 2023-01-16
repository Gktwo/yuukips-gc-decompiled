package com.mchange.p006v1.p008io;

import java.io.IOException;
import java.io.Reader;

/* renamed from: com.mchange.v1.io.ReaderUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/io/ReaderUtils.class */
public final class ReaderUtils {
    public static void attemptClose(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private ReaderUtils() {
    }
}
