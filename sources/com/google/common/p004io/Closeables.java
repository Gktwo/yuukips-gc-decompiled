package com.google.common.p004io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
@GwtIncompatible
/* renamed from: com.google.common.io.Closeables */
/* loaded from: grasscutter.jar:com/google/common/io/Closeables.class */
public final class Closeables {
    @VisibleForTesting
    static final Logger logger = Logger.getLogger(Closeables.class.getName());

    private Closeables() {
    }

    public static void close(Closeable closeable, boolean swallowIOException) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                if (swallowIOException) {
                    logger.log(Level.WARNING, "IOException thrown while closing Closeable.", (Throwable) e);
                    return;
                }
                throw e;
            }
        }
    }

    public static void closeQuietly(InputStream inputStream) {
        try {
            close(inputStream, true);
        } catch (IOException impossible) {
            throw new AssertionError(impossible);
        }
    }

    public static void closeQuietly(Reader reader) {
        try {
            close(reader, true);
        } catch (IOException impossible) {
            throw new AssertionError(impossible);
        }
    }
}
