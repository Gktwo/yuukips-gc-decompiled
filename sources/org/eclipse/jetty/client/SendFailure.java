package org.eclipse.jetty.client;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/SendFailure.class */
public class SendFailure {
    public final Throwable failure;
    public final boolean retry;

    public SendFailure(Throwable failure, boolean retry) {
        this.failure = failure;
        this.retry = retry;
    }

    public String toString() {
        return String.format("%s@%x[failure=%s,retry=%b]", getClass().getSimpleName(), Integer.valueOf(hashCode()), this.failure, Boolean.valueOf(this.retry));
    }
}
