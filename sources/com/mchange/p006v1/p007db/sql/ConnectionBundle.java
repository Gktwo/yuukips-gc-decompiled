package com.mchange.p006v1.p007db.sql;

import com.mchange.p006v1.util.ClosableResource;
import java.sql.Connection;
import java.sql.PreparedStatement;

/* renamed from: com.mchange.v1.db.sql.ConnectionBundle */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/ConnectionBundle.class */
public interface ConnectionBundle extends ClosableResource {
    Connection getConnection();

    PreparedStatement getStatement(String str);

    void putStatement(String str, PreparedStatement preparedStatement);
}
