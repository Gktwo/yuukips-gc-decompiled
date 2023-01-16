package com.mchange.p006v1.p007db.sql.schemarep;

import com.mchange.p006v1.util.ListUtils;
import com.mchange.p006v1.util.MapUtils;
import com.mchange.p006v1.util.SetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.mchange.v1.db.sql.schemarep.TableRepImpl */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/schemarep/TableRepImpl.class */
public class TableRepImpl implements TableRep {
    String tableName;
    List colNameList;
    Map namesToColReps;
    Set primaryKeyColNames;
    Set foreignKeyReps;
    Set uniqConstrReps;

    public TableRepImpl(String str, List list, Collection collection, Collection collection2, Collection collection3) {
        this.tableName = str;
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ColumnRep columnRep = (ColumnRep) list.get(i);
            String columnName = columnRep.getColumnName();
            arrayList.add(columnName);
            hashMap.put(columnName, columnRep);
        }
        this.colNameList = Collections.unmodifiableList(arrayList);
        this.namesToColReps = Collections.unmodifiableMap(hashMap);
        this.primaryKeyColNames = collection == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(new HashSet(collection));
        this.foreignKeyReps = collection2 == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(new HashSet(collection2));
        this.uniqConstrReps = collection3 == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(new HashSet(collection3));
    }

    @Override // com.mchange.p006v1.p007db.sql.schemarep.TableRep
    public String getTableName() {
        return this.tableName;
    }

    @Override // com.mchange.p006v1.p007db.sql.schemarep.TableRep
    public Iterator getColumnNames() {
        return this.colNameList.iterator();
    }

    @Override // com.mchange.p006v1.p007db.sql.schemarep.TableRep
    public ColumnRep columnRepForName(String str) {
        return (ColumnRep) this.namesToColReps.get(str);
    }

    @Override // com.mchange.p006v1.p007db.sql.schemarep.TableRep
    public Set getPrimaryKeyColumnNames() {
        return this.primaryKeyColNames;
    }

    @Override // com.mchange.p006v1.p007db.sql.schemarep.TableRep
    public Set getForeignKeyReps() {
        return this.foreignKeyReps;
    }

    @Override // com.mchange.p006v1.p007db.sql.schemarep.TableRep
    public Set getUniquenessConstraintReps() {
        return this.uniqConstrReps;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TableRepImpl tableRepImpl = (TableRepImpl) obj;
        return this.tableName.equals(tableRepImpl.tableName) && ListUtils.equivalent(this.colNameList, tableRepImpl.colNameList) && MapUtils.equivalentDisregardingSort(this.namesToColReps, tableRepImpl.namesToColReps) && SetUtils.equivalentDisregardingSort(this.primaryKeyColNames, tableRepImpl.primaryKeyColNames) && SetUtils.equivalentDisregardingSort(this.foreignKeyReps, tableRepImpl.foreignKeyReps) && SetUtils.equivalentDisregardingSort(this.uniqConstrReps, tableRepImpl.uniqConstrReps);
    }

    public int hashCode() {
        return ((((this.tableName.hashCode() ^ ListUtils.hashContents(this.colNameList)) ^ MapUtils.hashContentsDisregardingSort(this.namesToColReps)) ^ SetUtils.hashContentsDisregardingSort(this.primaryKeyColNames)) ^ SetUtils.hashContentsDisregardingSort(this.foreignKeyReps)) ^ SetUtils.hashContentsDisregardingSort(this.uniqConstrReps);
    }
}
