package com.mchange.p006v1.p007db.sql.schemarep;

import java.util.List;

/* renamed from: com.mchange.v1.db.sql.schemarep.ForeignKeyRep */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/schemarep/ForeignKeyRep.class */
public interface ForeignKeyRep {
    List getLocalColumnNames();

    String getReferencedTableName();

    List getReferencedColumnNames();
}
