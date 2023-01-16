package org.eclipse.jetty.util;

import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/Utf8LineParser.class */
public class Utf8LineParser {
    private State state = State.START;
    private Utf8StringBuilder utf;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Utf8LineParser$State.class */
    public enum State {
        START,
        PARSE,
        END
    }

    public String parse(ByteBuffer buf) {
        while (buf.remaining() > 0) {
            if (parseByte(buf.get())) {
                this.state = State.START;
                return this.utf.toString();
            }
        }
        return null;
    }

    private boolean parseByte(byte b) {
        switch (this.state) {
            case START:
                this.utf = new Utf8StringBuilder();
                this.state = State.PARSE;
                return parseByte(b);
            case PARSE:
                if (!this.utf.isUtf8SequenceComplete() || !(b == 13 || b == 10)) {
                    this.utf.append(b);
                    return false;
                }
                this.state = State.END;
                return parseByte(b);
            case END:
                if (b != 10) {
                    return false;
                }
                this.state = State.START;
                return true;
            default:
                return false;
        }
    }
}
