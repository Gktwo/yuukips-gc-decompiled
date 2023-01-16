package com.mchange.p006v1.p007db.sql.schemarep;

import java.util.Set;

/* renamed from: com.mchange.v1.db.sql.schemarep.SimpleSchemaRep */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/schemarep/SimpleSchemaRep.class */
public interface SimpleSchemaRep {
    Set getTableNames();

    TableRep tableRepForName(String str);
}
