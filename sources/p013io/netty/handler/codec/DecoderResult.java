package p013io.netty.handler.codec;

import p013io.netty.util.Signal;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.codec.DecoderResult */
/* loaded from: grasscutter.jar:io/netty/handler/codec/DecoderResult.class */
public class DecoderResult {
    protected static final Signal SIGNAL_UNFINISHED = Signal.valueOf(DecoderResult.class, "UNFINISHED");
    protected static final Signal SIGNAL_SUCCESS = Signal.valueOf(DecoderResult.class, "SUCCESS");
    public static final DecoderResult UNFINISHED = new DecoderResult(SIGNAL_UNFINISHED);
    public static final DecoderResult SUCCESS = new DecoderResult(SIGNAL_SUCCESS);
    private final Throwable cause;

    public static DecoderResult failure(Throwable cause) {
        return new DecoderResult((Throwable) ObjectUtil.checkNotNull(cause, "cause"));
    }

    protected DecoderResult(Throwable cause) {
        this.cause = (Throwable) ObjectUtil.checkNotNull(cause, "cause");
    }

    public boolean isFinished() {
        return this.cause != SIGNAL_UNFINISHED;
    }

    public boolean isSuccess() {
        return this.cause == SIGNAL_SUCCESS;
    }

    public boolean isFailure() {
        return (this.cause == SIGNAL_SUCCESS || this.cause == SIGNAL_UNFINISHED) ? false : true;
    }

    public Throwable cause() {
        if (isFailure()) {
            return this.cause;
        }
        return null;
    }

    public String toString() {
        if (!isFinished()) {
            return "unfinished";
        }
        if (isSuccess()) {
            return "success";
        }
        String cause = cause().toString();
        return new StringBuilder(cause.length() + 17).append("failure(").append(cause).append(')').toString();
    }
}
