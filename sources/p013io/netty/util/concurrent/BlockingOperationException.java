package p013io.netty.util.concurrent;

/* renamed from: io.netty.util.concurrent.BlockingOperationException */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/BlockingOperationException.class */
public class BlockingOperationException extends IllegalStateException {
    private static final long serialVersionUID = 2462223247762460301L;

    public BlockingOperationException() {
    }

    public BlockingOperationException(String s) {
        super(s);
    }

    public BlockingOperationException(Throwable cause) {
        super(cause);
    }

    public BlockingOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
