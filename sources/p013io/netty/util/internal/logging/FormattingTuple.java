package p013io.netty.util.internal.logging;

/* renamed from: io.netty.util.internal.logging.FormattingTuple */
/* loaded from: grasscutter.jar:io/netty/util/internal/logging/FormattingTuple.class */
public final class FormattingTuple {
    private final String message;
    private final Throwable throwable;

    /* access modifiers changed from: package-private */
    public FormattingTuple(String message, Throwable throwable) {
        this.message = message;
        this.throwable = throwable;
    }

    public String getMessage() {
        return this.message;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }
}
