package org.eclipse.jetty.websocket.common;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import okhttp3.internal.p021ws.WebSocketProtocol;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/AcceptHash.class */
public class AcceptHash {
    private static final byte[] MAGIC = WebSocketProtocol.ACCEPT_MAGIC.getBytes(StandardCharsets.ISO_8859_1);

    public static String hashKey(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            md.update(key.getBytes(StandardCharsets.UTF_8));
            md.update(MAGIC);
            return Base64.getEncoder().encodeToString(md.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
