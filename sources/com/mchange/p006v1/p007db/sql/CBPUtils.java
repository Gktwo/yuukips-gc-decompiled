package com.mchange.p006v1.p007db.sql;

/* renamed from: com.mchange.v1.db.sql.CBPUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/CBPUtils.class */
public class CBPUtils {
    public static void attemptCheckin(ConnectionBundle connectionBundle, ConnectionBundlePool connectionBundlePool) {
        try {
            connectionBundlePool.checkinBundle(connectionBundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
