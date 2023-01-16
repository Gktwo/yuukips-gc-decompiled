package com.mchange.p006v1.p007db.sql.schemarep;

import com.mchange.p006v1.util.SetUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.mchange.v1.db.sql.schemarep.UniquenessConstraintRepImpl */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/schemarep/UniquenessConstraintRepImpl.class */
public class UniquenessConstraintRepImpl implements UniquenessConstraintRep {
    Set uniqueColNames;

    public UniquenessConstraintRepImpl(Collection collection) {
        this.uniqueColNames = Collections.unmodifiableSet(new HashSet(collection));
    }

    @Override // com.mchange.p006v1.p007db.sql.schemarep.UniquenessConstraintRep
    public Set getUniqueColumnNames() {
        return this.uniqueColNames;
    }

    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass() && SetUtils.equivalentDisregardingSort(this.uniqueColNames, ((UniquenessConstraintRepImpl) obj).uniqueColNames);
    }

    public int hashCode() {
        return getClass().hashCode() ^ SetUtils.hashContentsDisregardingSort(this.uniqueColNames);
    }
}
