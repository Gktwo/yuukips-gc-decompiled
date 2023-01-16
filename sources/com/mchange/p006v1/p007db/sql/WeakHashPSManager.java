package com.mchange.p006v1.p007db.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: com.mchange.v1.db.sql.WeakHashPSManager */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/WeakHashPSManager.class */
public class WeakHashPSManager implements PSManager {
    WeakHashMap wmap = new WeakHashMap();

    @Override // com.mchange.p006v1.p007db.sql.PSManager
    public PreparedStatement getPS(Connection connection, String str) {
        Map map = (Map) this.wmap.get(connection);
        if (map == null) {
            return null;
        }
        return (PreparedStatement) map.get(str);
    }

    @Override // com.mchange.p006v1.p007db.sql.PSManager
    public void putPS(Connection connection, String str, PreparedStatement preparedStatement) {
        Map map = (Map) this.wmap.get(connection);
        if (map == null) {
            map = new HashMap();
            this.wmap.put(connection, map);
        }
        map.put(str, preparedStatement);
    }
}
