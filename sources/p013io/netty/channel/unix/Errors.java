package p013io.netty.channel.unix;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.NotYetConnectedException;
import p013io.netty.util.internal.EmptyArrays;

/* renamed from: io.netty.channel.unix.Errors */
/* loaded from: grasscutter.jar:io/netty/channel/unix/Errors.class */
public final class Errors {
    public static final int ERRNO_ENOENT_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoENOENT();
    public static final int ERRNO_ENOTCONN_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoENOTCONN();
    public static final int ERRNO_EBADF_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEBADF();
    public static final int ERRNO_EPIPE_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEPIPE();
    public static final int ERRNO_ECONNRESET_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoECONNRESET();
    public static final int ERRNO_EAGAIN_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEAGAIN();
    public static final int ERRNO_EWOULDBLOCK_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEWOULDBLOCK();
    public static final int ERRNO_EINPROGRESS_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEINPROGRESS();
    public static final int ERROR_ECONNREFUSED_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errorECONNREFUSED();
    public static final int ERROR_EISCONN_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errorEISCONN();
    public static final int ERROR_EALREADY_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errorEALREADY();
    public static final int ERROR_ENETUNREACH_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errorENETUNREACH();
    private static final String[] ERRORS = new String[512];

    static {
        for (int i = 0; i < ERRORS.length; i++) {
            ERRORS[i] = ErrorsStaticallyReferencedJniMethods.strError(i);
        }
    }

    /* renamed from: io.netty.channel.unix.Errors$NativeIoException */
    /* loaded from: grasscutter.jar:io/netty/channel/unix/Errors$NativeIoException.class */
    public static final class NativeIoException extends IOException {
        private static final long serialVersionUID = 8222160204268655526L;
        private final int expectedErr;
        private final boolean fillInStackTrace;

        public NativeIoException(String method, int expectedErr) {
            this(method, expectedErr, true);
        }

        public NativeIoException(String method, int expectedErr, boolean fillInStackTrace) {
            super(method + "(..) failed: " + Errors.ERRORS[-expectedErr]);
            this.expectedErr = expectedErr;
            this.fillInStackTrace = fillInStackTrace;
        }

        public int expectedErr() {
            return this.expectedErr;
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            if (this.fillInStackTrace) {
                return fillInStackTrace();
            }
            return this;
        }
    }

    /* renamed from: io.netty.channel.unix.Errors$NativeConnectException */
    /* loaded from: grasscutter.jar:io/netty/channel/unix/Errors$NativeConnectException.class */
    static final class NativeConnectException extends ConnectException {
        private static final long serialVersionUID = -5532328671712318161L;
        private final int expectedErr;

        NativeConnectException(String method, int expectedErr) {
            super(method + "(..) failed: " + Errors.ERRORS[-expectedErr]);
            this.expectedErr = expectedErr;
        }

        int expectedErr() {
            return this.expectedErr;
        }
    }

    /* access modifiers changed from: package-private */
    public static boolean handleConnectErrno(String method, int err) throws IOException {
        if (err == ERRNO_EINPROGRESS_NEGATIVE || err == ERROR_EALREADY_NEGATIVE) {
            return false;
        }
        throw newConnectException0(method, err);
    }

    @Deprecated
    public static void throwConnectException(String method, int err) throws IOException {
        if (err == ERROR_EALREADY_NEGATIVE) {
            throw new ConnectionPendingException();
        }
        throw newConnectException0(method, err);
    }

    private static IOException newConnectException0(String method, int err) {
        if (err == ERROR_ENETUNREACH_NEGATIVE) {
            return new NoRouteToHostException();
        }
        if (err == ERROR_EISCONN_NEGATIVE) {
            throw new AlreadyConnectedException();
        } else if (err == ERRNO_ENOENT_NEGATIVE) {
            return new FileNotFoundException();
        } else {
            return new ConnectException(method + "(..) failed: " + ERRORS[-err]);
        }
    }

    public static NativeIoException newConnectionResetException(String method, int errnoNegative) {
        NativeIoException exception = new NativeIoException(method, errnoNegative, false);
        exception.setStackTrace(EmptyArrays.EMPTY_STACK_TRACE);
        return exception;
    }

    public static NativeIoException newIOException(String method, int err) {
        return new NativeIoException(method, err);
    }

    @Deprecated
    public static int ioResult(String method, int err, NativeIoException resetCause, ClosedChannelException closedCause) throws IOException {
        if (err == ERRNO_EAGAIN_NEGATIVE || err == ERRNO_EWOULDBLOCK_NEGATIVE) {
            return 0;
        }
        if (err == resetCause.expectedErr()) {
            throw resetCause;
        } else if (err == ERRNO_EBADF_NEGATIVE) {
            throw closedCause;
        } else if (err == ERRNO_ENOTCONN_NEGATIVE) {
            throw new NotYetConnectedException();
        } else if (err == ERRNO_ENOENT_NEGATIVE) {
            throw new FileNotFoundException();
        } else {
            throw newIOException(method, err);
        }
    }

    public static int ioResult(String method, int err) throws IOException {
        if (err == ERRNO_EAGAIN_NEGATIVE || err == ERRNO_EWOULDBLOCK_NEGATIVE) {
            return 0;
        }
        if (err == ERRNO_EBADF_NEGATIVE) {
            throw new ClosedChannelException();
        } else if (err == ERRNO_ENOTCONN_NEGATIVE) {
            throw new NotYetConnectedException();
        } else if (err == ERRNO_ENOENT_NEGATIVE) {
            throw new FileNotFoundException();
        } else {
            throw new NativeIoException(method, err, false);
        }
    }

    private Errors() {
    }
}