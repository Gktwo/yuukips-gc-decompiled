package org.eclipse.jetty.server.session;

import java.io.File;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/FileSessionDataStoreFactory.class */
public class FileSessionDataStoreFactory extends AbstractSessionDataStoreFactory {
    boolean _deleteUnrestorableFiles;
    File _storeDir;

    public boolean isDeleteUnrestorableFiles() {
        return this._deleteUnrestorableFiles;
    }

    public void setDeleteUnrestorableFiles(boolean deleteUnrestorableFiles) {
        this._deleteUnrestorableFiles = deleteUnrestorableFiles;
    }

    public File getStoreDir() {
        return this._storeDir;
    }

    public void setStoreDir(File storeDir) {
        this._storeDir = storeDir;
    }

    @Override // org.eclipse.jetty.server.session.SessionDataStoreFactory
    public SessionDataStore getSessionDataStore(SessionHandler handler) {
        FileSessionDataStore fsds = new FileSessionDataStore();
        fsds.setDeleteUnrestorableFiles(isDeleteUnrestorableFiles());
        fsds.setStoreDir(getStoreDir());
        fsds.setGracePeriodSec(getGracePeriodSec());
        fsds.setSavePeriodSec(getSavePeriodSec());
        return fsds;
    }
}
