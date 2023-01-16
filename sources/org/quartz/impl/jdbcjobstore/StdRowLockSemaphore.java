package org.quartz.impl.jdbcjobstore;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/StdRowLockSemaphore.class */
public class StdRowLockSemaphore extends DBSemaphore {
    public static final String SELECT_FOR_LOCK = "SELECT * FROM {0}LOCKS WHERE SCHED_NAME = {1} AND LOCK_NAME = ? FOR UPDATE";
    public static final String INSERT_LOCK = "INSERT INTO {0}LOCKS(SCHED_NAME, LOCK_NAME) VALUES ({1}, ?)";
    private int maxRetry;
    private long retryPeriod;

    public StdRowLockSemaphore() {
        super(Constants.DEFAULT_TABLE_PREFIX, null, SELECT_FOR_LOCK, "INSERT INTO {0}LOCKS(SCHED_NAME, LOCK_NAME) VALUES ({1}, ?)");
        this.maxRetry = 3;
        this.retryPeriod = 1000;
    }

    public StdRowLockSemaphore(String tablePrefix, String schedName, String selectWithLockSQL) {
        super(tablePrefix, schedName, selectWithLockSQL != null ? selectWithLockSQL : SELECT_FOR_LOCK, "INSERT INTO {0}LOCKS(SCHED_NAME, LOCK_NAME) VALUES ({1}, ?)");
        this.maxRetry = 3;
        this.retryPeriod = 1000;
    }

    public void setMaxRetry(int maxRetry) {
        this.maxRetry = maxRetry;
    }

    public void setRetryPeriod(long retryPeriod) {
        this.retryPeriod = retryPeriod;
    }

    public int getMaxRetry() {
        return this.maxRetry;
    }

    public long getRetryPeriod() {
        return this.retryPeriod;
    }

    /* JADX WARNING: Removed duplicated region for block: B:82:0x0222 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0211 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // org.quartz.impl.jdbcjobstore.DBSemaphore
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void executeSQL(java.sql.Connection r7, java.lang.String r8, java.lang.String r9, java.lang.String r10) throws org.quartz.impl.jdbcjobstore.LockException {
        /*
        // Method dump skipped, instructions count: 582
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.impl.jdbcjobstore.StdRowLockSemaphore.executeSQL(java.sql.Connection, java.lang.String, java.lang.String, java.lang.String):void");
    }

    protected String getSelectWithLockSQL() {
        return getSQL();
    }

    public void setSelectWithLockSQL(String selectWithLockSQL) {
        setSQL(selectWithLockSQL);
    }
}
