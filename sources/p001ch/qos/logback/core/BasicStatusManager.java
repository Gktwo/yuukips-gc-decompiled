package p001ch.qos.logback.core;

import java.util.ArrayList;
import java.util.List;
import p001ch.qos.logback.core.helpers.CyclicBuffer;
import p001ch.qos.logback.core.spi.LogbackLock;
import p001ch.qos.logback.core.status.OnConsoleStatusListener;
import p001ch.qos.logback.core.status.Status;
import p001ch.qos.logback.core.status.StatusListener;
import p001ch.qos.logback.core.status.StatusManager;

/* renamed from: ch.qos.logback.core.BasicStatusManager */
/* loaded from: grasscutter.jar:ch/qos/logback/core/BasicStatusManager.class */
public class BasicStatusManager implements StatusManager {
    public static final int MAX_HEADER_COUNT = 150;
    public static final int TAIL_SIZE = 150;
    int count = 0;
    protected final List<Status> statusList = new ArrayList();
    protected final CyclicBuffer<Status> tailBuffer = new CyclicBuffer<>(150);
    protected final LogbackLock statusListLock = new LogbackLock();
    int level = 0;
    protected final List<StatusListener> statusListenerList = new ArrayList();
    protected final LogbackLock statusListenerListLock = new LogbackLock();

    @Override // p001ch.qos.logback.core.status.StatusManager
    public void add(Status newStatus) {
        fireStatusAddEvent(newStatus);
        this.count++;
        if (newStatus.getLevel() > this.level) {
            this.level = newStatus.getLevel();
        }
        synchronized (this.statusListLock) {
            if (this.statusList.size() < 150) {
                this.statusList.add(newStatus);
            } else {
                this.tailBuffer.add(newStatus);
            }
        }
    }

    @Override // p001ch.qos.logback.core.status.StatusManager
    public List<Status> getCopyOfStatusList() {
        List<Status> tList;
        synchronized (this.statusListLock) {
            tList = new ArrayList<>(this.statusList);
            tList.addAll(this.tailBuffer.asList());
        }
        return tList;
    }

    private void fireStatusAddEvent(Status status) {
        synchronized (this.statusListenerListLock) {
            for (StatusListener sl : this.statusListenerList) {
                sl.addStatusEvent(status);
            }
        }
    }

    @Override // p001ch.qos.logback.core.status.StatusManager
    public void clear() {
        synchronized (this.statusListLock) {
            this.count = 0;
            this.statusList.clear();
            this.tailBuffer.clear();
        }
    }

    public int getLevel() {
        return this.level;
    }

    @Override // p001ch.qos.logback.core.status.StatusManager
    public int getCount() {
        return this.count;
    }

    @Override // p001ch.qos.logback.core.status.StatusManager
    public boolean add(StatusListener listener) {
        synchronized (this.statusListenerListLock) {
            if ((listener instanceof OnConsoleStatusListener) && checkForPresence(this.statusListenerList, listener.getClass())) {
                return false;
            }
            this.statusListenerList.add(listener);
            return true;
        }
    }

    private boolean checkForPresence(List<StatusListener> statusListenerList, Class<?> aClass) {
        for (StatusListener e : statusListenerList) {
            if (e.getClass() == aClass) {
                return true;
            }
        }
        return false;
    }

    @Override // p001ch.qos.logback.core.status.StatusManager
    public void remove(StatusListener listener) {
        synchronized (this.statusListenerListLock) {
            this.statusListenerList.remove(listener);
        }
    }

    @Override // p001ch.qos.logback.core.status.StatusManager
    public List<StatusListener> getCopyOfStatusListenerList() {
        ArrayList arrayList;
        synchronized (this.statusListenerListLock) {
            arrayList = new ArrayList(this.statusListenerList);
        }
        return arrayList;
    }
}
