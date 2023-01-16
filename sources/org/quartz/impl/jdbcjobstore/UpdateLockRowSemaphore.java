package org.quartz.impl.jdbcjobstore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/UpdateLockRowSemaphore.class */
public class UpdateLockRowSemaphore extends DBSemaphore {
    public static final String UPDATE_FOR_LOCK = "UPDATE {0}LOCKS SET LOCK_NAME = LOCK_NAME WHERE SCHED_NAME = {1} AND LOCK_NAME = ? ";
    public static final String INSERT_LOCK = "INSERT INTO {0}LOCKS(SCHED_NAME, LOCK_NAME) VALUES ({1}, ?)";
    private static final int RETRY_COUNT = 2;

    public UpdateLockRowSemaphore() {
        super(Constants.DEFAULT_TABLE_PREFIX, null, UPDATE_FOR_LOCK, "INSERT INTO {0}LOCKS(SCHED_NAME, LOCK_NAME) VALUES ({1}, ?)");
    }

    @Override // org.quartz.impl.jdbcjobstore.DBSemaphore
    protected void executeSQL(Connection conn, String lockName, String expandedSQL, String expandedInsertSQL) throws LockException {
        SQLException lastFailure = null;
        for (int i = 0; i < 2; i++) {
            try {
                if (!lockViaUpdate(conn, lockName, expandedSQL)) {
                    lockViaInsert(conn, lockName, expandedInsertSQL);
                    return;
                }
                return;
            } catch (SQLException e) {
                lastFailure = e;
                if (i + 1 == 2) {
                    getLog().debug("Lock '{}' was not obtained by: {}", lockName, Thread.currentThread().getName());
                } else {
                    getLog().debug("Lock '{}' was not obtained by: {} - will try again.", lockName, Thread.currentThread().getName());
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        throw new LockException("Failure obtaining db row lock: " + lastFailure.getMessage(), lastFailure);
    }

    protected String getUpdateLockRowSQL() {
        return getSQL();
    }

    public void setUpdateLockRowSQL(String updateLockRowSQL) {
        setSQL(updateLockRowSQL);
    }

    private boolean lockViaUpdate(Connection conn, String lockName, String sql) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        try {
            ps.setString(1, lockName);
            getLog().debug("Lock '" + lockName + "' is being obtained: " + Thread.currentThread().getName());
            return ps.executeUpdate() >= 1;
        } finally {
            ps.close();
        }
    }

    private void lockViaInsert(Connection conn, String lockName, String sql) throws SQLException {
        getLog().debug("Inserting new lock row for lock: '" + lockName + "' being obtained by thread: " + Thread.currentThread().getName());
        PreparedStatement ps = conn.prepareStatement(sql);
        try {
            ps.setString(1, lockName);
            if (ps.executeUpdate() != 1) {
                throw new SQLException(Util.rtp("No row exists, and one could not be inserted in table {0}LOCKS for lock named: " + lockName, getTablePrefix(), getSchedulerNameLiteral()));
            }
        } finally {
            ps.close();
        }
    }
}
