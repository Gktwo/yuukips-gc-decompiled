package com.mchange.p006v1.p007db.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;

/* renamed from: com.mchange.v1.db.sql.PSManager */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/PSManager.class */
public interface PSManager {
    PreparedStatement getPS(Connection connection, String str);

    void putPS(Connection connection, String str, PreparedStatement preparedStatement);
}
