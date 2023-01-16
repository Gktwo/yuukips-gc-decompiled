package org.eclipse.jetty.server.session;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/AbstractSessionDataStoreFactory.class */
public abstract class AbstractSessionDataStoreFactory implements SessionDataStoreFactory {
    int _gracePeriodSec;
    int _savePeriodSec;

    public int getGracePeriodSec() {
        return this._gracePeriodSec;
    }

    public void setGracePeriodSec(int gracePeriodSec) {
        this._gracePeriodSec = gracePeriodSec;
    }

    public int getSavePeriodSec() {
        return this._savePeriodSec;
    }

    public void setSavePeriodSec(int savePeriodSec) {
        this._savePeriodSec = savePeriodSec;
    }
}
