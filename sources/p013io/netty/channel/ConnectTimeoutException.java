package p013io.netty.channel;

import java.net.ConnectException;

/* renamed from: io.netty.channel.ConnectTimeoutException */
/* loaded from: grasscutter.jar:io/netty/channel/ConnectTimeoutException.class */
public class ConnectTimeoutException extends ConnectException {
    private static final long serialVersionUID = 2317065249988317463L;

    public ConnectTimeoutException(String msg) {
        super(msg);
    }

    public ConnectTimeoutException() {
    }
}
