package org.eclipse.jetty.server.handler.gzip;

import java.util.zip.Deflater;
import org.eclipse.jetty.server.Request;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/gzip/GzipFactory.class */
public interface GzipFactory {
    Deflater getDeflater(Request request, long j);

    boolean isMimeTypeGzipable(String str);

    void recycle(Deflater deflater);
}
