package com.mchange.p009v2.c3p0.example;

import com.mchange.p009v2.c3p0.AbstractConnectionCustomizer;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.sql.Connection;
import java.sql.Statement;

/* renamed from: com.mchange.v2.c3p0.example.InitSqlConnectionCustomizer */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/example/InitSqlConnectionCustomizer.class */
public class InitSqlConnectionCustomizer extends AbstractConnectionCustomizer {
    static final MLogger logger = MLog.getLogger(InitSqlConnectionCustomizer.class);

    private String getInitSql(String parentDataSourceIdentityToken) {
        return (String) extensionsForToken(parentDataSourceIdentityToken).get("initSql");
    }

    @Override // com.mchange.p009v2.c3p0.AbstractConnectionCustomizer, com.mchange.p009v2.c3p0.ConnectionCustomizer
    public void onCheckOut(Connection c, String parentDataSourceIdentityToken) throws Exception {
        String initSql = getInitSql(parentDataSourceIdentityToken);
        if (initSql != null) {
            Statement stmt = null;
            try {
                stmt = c.createStatement();
                int num = stmt.executeUpdate(initSql);
                if (logger.isLoggable(MLevel.FINEST)) {
                    logger.log(MLevel.FINEST, "Initialized checked-out Connection '" + c + "' with initSql '" + initSql + "'. Return value: " + num);
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Throwable th) {
                if (stmt != null) {
                    stmt.close();
                }
                throw th;
            }
        }
    }
}
