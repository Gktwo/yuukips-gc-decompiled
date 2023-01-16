package org.eclipse.jetty.server.resource;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/resource/RangeWriter.class */
public interface RangeWriter extends Closeable {
    void writeTo(OutputStream outputStream, long j, long j2) throws IOException;
}
