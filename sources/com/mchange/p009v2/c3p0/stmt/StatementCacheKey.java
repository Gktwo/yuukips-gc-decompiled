package com.mchange.p009v2.c3p0.stmt;

import com.mchange.p006v1.util.ArrayUtils;
import com.mchange.p009v2.lang.ObjectUtils;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Arrays;

/* access modifiers changed from: package-private */
/* renamed from: com.mchange.v2.c3p0.stmt.StatementCacheKey */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/stmt/StatementCacheKey.class */
public abstract class StatementCacheKey {
    static final int SIMPLE = 0;
    static final int MEMORY_COALESCED = 1;
    static final int VALUE_IDENTITY = 2;
    Connection physicalConnection;
    String stmtText;
    boolean is_callable;
    int result_set_type;
    int result_set_concurrency;
    int[] columnIndexes;
    String[] columnNames;
    Integer autogeneratedKeys;
    Integer resultSetHoldability;

    public static synchronized StatementCacheKey find(Connection pcon, Method stmtProducingMethod, Object[] args) {
        switch (2) {
            case 0:
                return SimpleStatementCacheKey._find(pcon, stmtProducingMethod, args);
            case 1:
                return MemoryCoalescedStatementCacheKey._find(pcon, stmtProducingMethod, args);
            case 2:
                return ValueIdentityStatementCacheKey._find(pcon, stmtProducingMethod, args);
            default:
                throw new InternalError("StatementCacheKey.find() is misconfigured.");
        }
    }

    /* access modifiers changed from: package-private */
    public StatementCacheKey() {
    }

    /* access modifiers changed from: package-private */
    public StatementCacheKey(Connection physicalConnection, String stmtText, boolean is_callable, int result_set_type, int result_set_concurrency, int[] columnIndexes, String[] columnNames, Integer autogeneratedKeys, Integer resultSetHoldability) {
        init(physicalConnection, stmtText, is_callable, result_set_type, result_set_concurrency, columnIndexes, columnNames, autogeneratedKeys, resultSetHoldability);
    }

    /* access modifiers changed from: package-private */
    public void init(Connection physicalConnection, String stmtText, boolean is_callable, int result_set_type, int result_set_concurrency, int[] columnIndexes, String[] columnNames, Integer autogeneratedKeys, Integer resultSetHoldability) {
        this.physicalConnection = physicalConnection;
        this.stmtText = stmtText;
        this.is_callable = is_callable;
        this.result_set_type = result_set_type;
        this.result_set_concurrency = result_set_concurrency;
        this.columnIndexes = columnIndexes;
        this.columnNames = columnNames;
        this.autogeneratedKeys = autogeneratedKeys;
        this.resultSetHoldability = resultSetHoldability;
    }

    /* access modifiers changed from: package-private */
    public static boolean equals(StatementCacheKey _this, Object o) {
        if (_this == o) {
            return true;
        }
        if (!(o instanceof StatementCacheKey)) {
            return false;
        }
        StatementCacheKey sck = (StatementCacheKey) o;
        return sck.physicalConnection.equals(_this.physicalConnection) && sck.stmtText.equals(_this.stmtText) && sck.is_callable == _this.is_callable && sck.result_set_type == _this.result_set_type && sck.result_set_concurrency == _this.result_set_concurrency && Arrays.equals(sck.columnIndexes, _this.columnIndexes) && Arrays.equals(sck.columnNames, _this.columnNames) && ObjectUtils.eqOrBothNull(sck.autogeneratedKeys, _this.autogeneratedKeys) && ObjectUtils.eqOrBothNull(sck.resultSetHoldability, _this.resultSetHoldability);
    }

    /* access modifiers changed from: package-private */
    public static int hashCode(StatementCacheKey _this) {
        return (((((((_this.physicalConnection.hashCode() ^ _this.stmtText.hashCode()) ^ (_this.is_callable ? 1 : 0)) ^ _this.result_set_type) ^ _this.result_set_concurrency) ^ ArrayUtils.hashOrZeroArray(_this.columnIndexes)) ^ ArrayUtils.hashOrZeroArray(_this.columnNames)) ^ ObjectUtils.hashOrZero(_this.autogeneratedKeys)) ^ ObjectUtils.hashOrZero(_this.resultSetHoldability);
    }

    public String toString() {
        StringBuffer out = new StringBuffer(128);
        out.append("[" + getClass().getName() + ": ");
        out.append("physicalConnection->" + this.physicalConnection);
        out.append(", stmtText->" + this.stmtText);
        out.append(", is_callable->" + this.is_callable);
        out.append(", result_set_type->" + this.result_set_type);
        out.append(", result_set_concurrency->" + this.result_set_concurrency);
        out.append(", columnIndexes->" + ArrayUtils.toString(this.columnIndexes));
        out.append(", columnNames->" + ArrayUtils.toString(this.columnNames));
        out.append(", autogeneratedKeys->" + this.autogeneratedKeys);
        out.append(", resultSetHoldability->" + this.resultSetHoldability);
        out.append(']');
        return out.toString();
    }
}
