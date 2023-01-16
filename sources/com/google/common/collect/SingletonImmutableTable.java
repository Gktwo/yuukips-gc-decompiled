package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import java.util.Map;

/* access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/SingletonImmutableTable.class */
public class SingletonImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
    final R singleRowKey;
    final C singleColumnKey;
    final V singleValue;

    /* access modifiers changed from: package-private */
    public SingletonImmutableTable(R rowKey, C columnKey, V value) {
        this.singleRowKey = (R) Preconditions.checkNotNull(rowKey);
        this.singleColumnKey = (C) Preconditions.checkNotNull(columnKey);
        this.singleValue = (V) Preconditions.checkNotNull(value);
    }

    /* access modifiers changed from: package-private */
    public SingletonImmutableTable(Table.Cell<R, C, V> cell) {
        this(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<R, V> column(C columnKey) {
        Preconditions.checkNotNull(columnKey);
        if (containsColumn(columnKey)) {
            return ImmutableMap.m1418of(this.singleRowKey, (Object) this.singleValue);
        }
        return ImmutableMap.m1419of();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.m1418of(this.singleColumnKey, ImmutableMap.m1418of(this.singleRowKey, (Object) this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.m1418of(this.singleRowKey, ImmutableMap.m1418of(this.singleColumnKey, (Object) this.singleValue));
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return 1;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    public ImmutableSet<Table.Cell<R, C, V>> createCellSet() {
        return ImmutableSet.m1395of(cellOf(this.singleRowKey, this.singleColumnKey, this.singleValue));
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    public ImmutableCollection<V> createValues() {
        return ImmutableSet.m1395of(this.singleValue);
    }

    @Override // com.google.common.collect.ImmutableTable
    ImmutableTable.SerializedForm createSerializedForm() {
        return ImmutableTable.SerializedForm.create(this, new int[]{0}, new int[]{0});
    }
}
