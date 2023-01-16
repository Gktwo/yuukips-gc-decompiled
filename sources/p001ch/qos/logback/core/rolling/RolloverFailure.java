package p001ch.qos.logback.core.rolling;

import p001ch.qos.logback.core.LogbackException;

/* renamed from: ch.qos.logback.core.rolling.RolloverFailure */
/* loaded from: grasscutter.jar:ch/qos/logback/core/rolling/RolloverFailure.class */
public class RolloverFailure extends LogbackException {
    private static final long serialVersionUID = -4407533730831239458L;

    public RolloverFailure(String msg) {
        super(msg);
    }

    public RolloverFailure(String message, Throwable cause) {
        super(message, cause);
    }
}
