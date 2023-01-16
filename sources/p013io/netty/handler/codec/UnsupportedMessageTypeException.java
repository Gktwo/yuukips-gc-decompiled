package p013io.netty.handler.codec;

/* renamed from: io.netty.handler.codec.UnsupportedMessageTypeException */
/* loaded from: grasscutter.jar:io/netty/handler/codec/UnsupportedMessageTypeException.class */
public class UnsupportedMessageTypeException extends CodecException {
    private static final long serialVersionUID = 2799598826487038726L;

    public UnsupportedMessageTypeException(Object message, Class<?>... expectedTypes) {
        super(message(message == null ? "null" : message.getClass().getName(), expectedTypes));
    }

    public UnsupportedMessageTypeException() {
    }

    public UnsupportedMessageTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedMessageTypeException(String s) {
        super(s);
    }

    public UnsupportedMessageTypeException(Throwable cause) {
        super(cause);
    }

    private static String message(String actualType, Class<?>... expectedTypes) {
        Class<?> t;
        StringBuilder buf = new StringBuilder(actualType);
        if (expectedTypes != null && expectedTypes.length > 0) {
            buf.append(" (expected: ").append(expectedTypes[0].getName());
            int i = 1;
            while (i < expectedTypes.length && (t = expectedTypes[i]) != null) {
                buf.append(", ").append(t.getName());
                i++;
            }
            buf.append(')');
        }
        return buf.toString();
    }
}
