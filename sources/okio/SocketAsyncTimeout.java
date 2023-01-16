package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JvmOkio.kt */
/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"�� \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\b\u0002\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\b\u001a\u00020\tH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��¨\u0006\n"}, m373d2 = {"Lokio/SocketAsyncTimeout;", "Lokio/AsyncTimeout;", "socket", "Ljava/net/Socket;", "(Ljava/net/Socket;)V", "newTimeoutException", "Ljava/io/IOException;", "cause", "timedOut", "", "okio"})
/* loaded from: grasscutter.jar:okio/SocketAsyncTimeout.class */
public final class SocketAsyncTimeout extends AsyncTimeout {
    @NotNull
    private final Socket socket;

    public SocketAsyncTimeout(@NotNull Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        this.socket = socket;
    }

    @Override // okio.AsyncTimeout
    @NotNull
    protected IOException newTimeoutException(@Nullable IOException cause) {
        SocketTimeoutException ioe = new SocketTimeoutException("timeout");
        if (cause != null) {
            ioe.initCause(cause);
        }
        return ioe;
    }

    @Override // okio.AsyncTimeout
    protected void timedOut() {
        try {
            this.socket.close();
        } catch (AssertionError e) {
            if (Okio.isAndroidGetsocknameError(e)) {
                JvmOkio.logger.log(Level.WARNING, Intrinsics.stringPlus("Failed to close timed out socket ", this.socket), (Throwable) e);
                return;
            }
            throw e;
        } catch (Exception e2) {
            JvmOkio.logger.log(Level.WARNING, Intrinsics.stringPlus("Failed to close timed out socket ", this.socket), (Throwable) e2);
        }
    }
}
