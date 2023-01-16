package com.mchange.p006v1.p007db.sql;

import java.sql.Connection;
import java.sql.SQLException;

/* renamed from: com.mchange.v1.db.sql.Schema */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/Schema.class */
public interface Schema {
    void createSchema(Connection connection) throws SQLException;

    void dropSchema(Connection connection) throws SQLException;

    String getStatementText(String str, String str2);
}
