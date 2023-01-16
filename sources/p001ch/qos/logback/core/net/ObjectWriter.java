package p001ch.qos.logback.core.net;

import java.io.IOException;

/* renamed from: ch.qos.logback.core.net.ObjectWriter */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/ObjectWriter.class */
public interface ObjectWriter {
    void write(Object obj) throws IOException;
}
