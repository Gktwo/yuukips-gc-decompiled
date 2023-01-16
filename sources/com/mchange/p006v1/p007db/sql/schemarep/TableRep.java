package com.mchange.p006v1.p007db.sql.schemarep;

import java.util.Iterator;
import java.util.Set;

/* renamed from: com.mchange.v1.db.sql.schemarep.TableRep */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/schemarep/TableRep.class */
public interface TableRep {
    String getTableName();

    Iterator getColumnNames();

    ColumnRep columnRepForName(String str);

    Set getPrimaryKeyColumnNames();

    Set getForeignKeyReps();

    Set getUniquenessConstraintReps();
}
