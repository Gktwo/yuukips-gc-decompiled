package p001ch.qos.logback.core.status;

import java.util.List;

/* renamed from: ch.qos.logback.core.status.StatusManager */
/* loaded from: grasscutter.jar:ch/qos/logback/core/status/StatusManager.class */
public interface StatusManager {
    void add(Status status);

    List<Status> getCopyOfStatusList();

    int getCount();

    boolean add(StatusListener statusListener);

    void remove(StatusListener statusListener);

    void clear();

    List<StatusListener> getCopyOfStatusListenerList();
}
