package org.eclipse.jetty.websocket.common.util;

import java.nio.ByteBuffer;
import org.eclipse.jetty.util.Utf8StringBuilder;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/util/Utf8PartialBuilder.class */
public class Utf8PartialBuilder {
    private final Utf8StringBuilder utf8 = new Utf8StringBuilder();

    public String toPartialString(ByteBuffer buf) {
        if (buf == null) {
            return "";
        }
        this.utf8.append(buf);
        return this.utf8.takePartialString();
    }
}
