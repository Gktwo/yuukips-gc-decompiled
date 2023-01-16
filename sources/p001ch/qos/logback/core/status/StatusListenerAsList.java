package p001ch.qos.logback.core.status;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ch.qos.logback.core.status.StatusListenerAsList */
/* loaded from: grasscutter.jar:ch/qos/logback/core/status/StatusListenerAsList.class */
public class StatusListenerAsList implements StatusListener {
    List<Status> statusList = new ArrayList();

    @Override // p001ch.qos.logback.core.status.StatusListener
    public void addStatusEvent(Status status) {
        this.statusList.add(status);
    }

    public List<Status> getStatusList() {
        return this.statusList;
    }
}
