package org.quartz;

/* loaded from: grasscutter.jar:org/quartz/SchedulerException.class */
public class SchedulerException extends Exception {
    private static final long serialVersionUID = 174841398690789156L;

    public SchedulerException() {
    }

    public SchedulerException(String msg) {
        super(msg);
    }

    public SchedulerException(Throwable cause) {
        super(cause);
    }

    public SchedulerException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public Throwable getUnderlyingException() {
        return getCause();
    }

    @Override // java.lang.Throwable, java.lang.Object
    public String toString() {
        Throwable cause = getUnderlyingException();
        if (cause == null || cause == this) {
            return toString();
        }
        return toString() + " [See nested exception: " + cause + "]";
    }
}
