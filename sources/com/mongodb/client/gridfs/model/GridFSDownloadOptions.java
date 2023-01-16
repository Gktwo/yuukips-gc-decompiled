package com.mongodb.client.gridfs.model;

/* loaded from: grasscutter.jar:com/mongodb/client/gridfs/model/GridFSDownloadOptions.class */
public final class GridFSDownloadOptions {
    private int revision = -1;

    public GridFSDownloadOptions revision(int revision) {
        this.revision = revision;
        return this;
    }

    public int getRevision() {
        return this.revision;
    }
}
