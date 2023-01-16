package org.eclipse.jetty.websocket.api;

import java.nio.charset.StandardCharsets;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/CloseStatus.class */
public class CloseStatus {
    private static final int MAX_CONTROL_PAYLOAD = 125;
    public static final int MAX_REASON_PHRASE = 123;
    private int code;
    private String phrase;

    @Deprecated
    public static String trimMaxReasonLength(String reason) {
        if (reason == null) {
            return null;
        }
        byte[] reasonBytes = reason.getBytes(StandardCharsets.UTF_8);
        if (reasonBytes.length <= 123) {
            return reason;
        }
        byte[] trimmed = new byte[123];
        System.arraycopy(reasonBytes, 0, trimmed, 0, 123);
        return new String(trimmed, StandardCharsets.UTF_8);
    }

    public CloseStatus(int closeCode, String reasonPhrase) {
        this.code = closeCode;
        this.phrase = reasonPhrase;
        if (reasonPhrase.length() > 123) {
            throw new IllegalArgumentException("Phrase exceeds maximum length of 123");
        }
    }

    public int getCode() {
        return this.code;
    }

    public String getPhrase() {
        return this.phrase;
    }
}
