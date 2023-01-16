package com.mchange.p006v1.p007db.sql.schemarep;

import com.mchange.p006v1.util.ListUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.mchange.v1.db.sql.schemarep.ForeignKeyRepImpl */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/schemarep/ForeignKeyRepImpl.class */
public class ForeignKeyRepImpl implements ForeignKeyRep {
    List locColNames;
    String refTableName;
    List refColNames;

    public ForeignKeyRepImpl(List list, String str, List list2) {
        this.locColNames = Collections.unmodifiableList(new ArrayList(list));
        this.refTableName = str;
        this.refColNames = Collections.unmodifiableList(new ArrayList(list2));
    }

    @Override // com.mchange.p006v1.p007db.sql.schemarep.ForeignKeyRep
    public List getLocalColumnNames() {
        return this.locColNames;
    }

    @Override // com.mchange.p006v1.p007db.sql.schemarep.ForeignKeyRep
    public String getReferencedTableName() {
        return this.refTableName;
    }

    @Override // com.mchange.p006v1.p007db.sql.schemarep.ForeignKeyRep
    public List getReferencedColumnNames() {
        return this.refColNames;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ForeignKeyRepImpl foreignKeyRepImpl = (ForeignKeyRepImpl) obj;
        return ListUtils.equivalent(this.locColNames, foreignKeyRepImpl.locColNames) && this.refTableName.equals(foreignKeyRepImpl.refTableName) && ListUtils.equivalent(this.refColNames, foreignKeyRepImpl.refColNames);
    }

    public int hashCode() {
        return (ListUtils.hashContents(this.locColNames) ^ this.refTableName.hashCode()) ^ ListUtils.hashContents(this.refColNames);
    }
}
