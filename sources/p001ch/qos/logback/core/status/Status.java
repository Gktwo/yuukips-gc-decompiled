package p001ch.qos.logback.core.status;

import java.util.Iterator;

/* renamed from: ch.qos.logback.core.status.Status */
/* loaded from: grasscutter.jar:ch/qos/logback/core/status/Status.class */
public interface Status {
    public static final int INFO = 0;
    public static final int WARN = 1;
    public static final int ERROR = 2;

    int getLevel();

    int getEffectiveLevel();

    Object getOrigin();

    String getMessage();

    Throwable getThrowable();

    Long getDate();

    boolean hasChildren();

    void add(Status status);

    boolean remove(Status status);

    Iterator<Status> iterator();
}
