package com.mchange.p006v1.p007db.sql;

import java.sql.ResultSet;

/* renamed from: com.mchange.v1.db.sql.CBPCursor */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/CBPCursor.class */
public abstract class CBPCursor extends SimpleCursor {
    ConnectionBundle returnMe;
    ConnectionBundlePool home;

    public CBPCursor(ResultSet resultSet, ConnectionBundle connectionBundle, ConnectionBundlePool connectionBundlePool) {
        super(resultSet);
        this.returnMe = connectionBundle;
        this.home = connectionBundlePool;
    }

    @Override // com.mchange.p006v1.p007db.sql.SimpleCursor, com.mchange.p006v1.util.UIterator, com.mchange.p006v1.util.ClosableResource
    public void close() throws Exception {
        try {
            close();
        } finally {
            this.home.checkinBundle(this.returnMe);
        }
    }
}
