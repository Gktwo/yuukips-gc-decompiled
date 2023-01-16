package com.mchange.p006v1.p007db.sql;

import com.mchange.p006v1.util.UIterator;
import java.sql.ResultSet;
import java.sql.SQLException;

/* renamed from: com.mchange.v1.db.sql.SimpleCursor */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/SimpleCursor.class */
public abstract class SimpleCursor implements UIterator {

    /* renamed from: rs */
    ResultSet f378rs;
    int available = -1;

    protected abstract Object objectFromResultSet(ResultSet resultSet) throws SQLException;

    public SimpleCursor(ResultSet resultSet) {
        this.f378rs = resultSet;
    }

    @Override // com.mchange.p006v1.util.UIterator
    public boolean hasNext() throws SQLException {
        ratchet();
        return this.available == 1;
    }

    @Override // com.mchange.p006v1.util.UIterator
    public Object next() throws SQLException {
        ratchet();
        Object objectFromResultSet = objectFromResultSet(this.f378rs);
        clear();
        return objectFromResultSet;
    }

    @Override // com.mchange.p006v1.util.UIterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // com.mchange.p006v1.util.UIterator, com.mchange.p006v1.util.ClosableResource
    public void close() throws Exception {
        this.f378rs.close();
        this.f378rs = null;
    }

    public void finalize() throws Exception {
        if (this.f378rs != null) {
            close();
        }
    }

    private void ratchet() throws SQLException {
        if (this.available == -1) {
            this.available = this.f378rs.next() ? 1 : 0;
        }
    }

    private void clear() {
        this.available = -1;
    }
}
