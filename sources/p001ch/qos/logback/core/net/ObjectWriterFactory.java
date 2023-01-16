package p001ch.qos.logback.core.net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/* renamed from: ch.qos.logback.core.net.ObjectWriterFactory */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/ObjectWriterFactory.class */
public class ObjectWriterFactory {
    public AutoFlushingObjectWriter newAutoFlushingObjectWriter(OutputStream outputStream) throws IOException {
        return new AutoFlushingObjectWriter(new ObjectOutputStream(outputStream), 70);
    }
}
