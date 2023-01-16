package com.mchange.p006v1.p007db.sql.schemarep;

/* renamed from: com.mchange.v1.db.sql.schemarep.ColumnRep */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/schemarep/ColumnRep.class */
public interface ColumnRep {
    String getColumnName();

    int getColumnType();

    int[] getColumnSize();

    boolean acceptsNulls();

    Object getDefaultValue();
}
