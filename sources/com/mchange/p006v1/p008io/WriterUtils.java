package com.mchange.p006v1.p008io;

import java.io.IOException;
import java.io.Writer;

/* renamed from: com.mchange.v1.io.WriterUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/io/WriterUtils.class */
public final class WriterUtils {
    public static void attemptClose(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private WriterUtils() {
    }
}
