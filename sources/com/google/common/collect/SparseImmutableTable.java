package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.Immutable;
import java.util.LinkedHashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
@Immutable(containerOf = {"R", "C", "V"})
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/SparseImmutableTable.class */
public final class SparseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    static final ImmutableTable<Object, Object, Object> EMPTY = new SparseImmutableTable(ImmutableList.m1438of(), ImmutableSet.m1396of(), ImmutableSet.m1396of());
    private final ImmutableMap<R, ImmutableMap<C, V>> rowMap;
    private final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    private final int[] cellRowIndices;
    private final int[] cellColumnInRowIndices;

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.common.collect.SparseImmutableTable<R, C, V> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public SparseImmutableTable(ImmutableList<Table.Cell<R, C, V>> cellList, ImmutableSet<R> rowSpace, ImmutableSet<C> columnSpace) {
        Map<R, Integer> rowIndex = Maps.indexMap(rowSpace);
        Map<R, Map<C, V>> rows = Maps.newLinkedHashMap();
        UnmodifiableIterator<R> it = rowSpace.iterator();
        while (it.hasNext()) {
            rows.put(it.next(), new LinkedHashMap<>());
        }
        Map<C, Map<R, V>> columns = Maps.newLinkedHashMap();
        UnmodifiableIterator<C> it2 = columnSpace.iterator();
        while (it2.hasNext()) {
            columns.put(it2.next(), new LinkedHashMap<>());
        }
        int[] cellRowIndices = new int[cellList.size()];
        int[] cellColumnInRowIndices = new int[cellList.size()];
        for (int i = 0; i < cellList.size(); i++) {
            Table.Cell<R, C, V> cell = cellList.get(i);
            R rowKey = cell.getRowKey();
            C columnKey = cell.getColumnKey();
            V value = cell.getValue();
            cellRowIndices[i] = rowIndex.get(rowKey).intValue();
            Map<C, V> thisRow = rows.get(rowKey);
            cellColumnInRowIndices[i] = thisRow.size();
            checkNoDuplicate(rowKey, columnKey, thisRow.put(columnKey, value), value);
            columns.get(columnKey).put(rowKey, value);
        }
        this.cellRowIndices = cellRowIndices;
        this.cellColumnInRowIndices = cellColumnInRowIndices;
        ImmutableMap.Builder<R, ImmutableMap<C, V>> rowBuilder = new ImmutableMap.Builder<>(rows.size());
        for (Map.Entry<R, Map<C, V>> row : rows.entrySet()) {
            rowBuilder.put(row.getKey(), ImmutableMap.copyOf(row.getValue()));
        }
        this.rowMap = rowBuilder.build();
        ImmutableMap.Builder<C, ImmutableMap<R, V>> columnBuilder = new ImmutableMap.Builder<>(columns.size());
        for (Map.Entry<C, Map<R, V>> col : columns.entrySet()) {
            columnBuilder.put(col.getKey(), ImmutableMap.copyOf(col.getValue()));
        }
        this.columnMap = columnBuilder.build();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf(this.columnMap);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.copyOf(this.rowMap);
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.cellRowIndices.length;
    }

    @Override // com.google.common.collect.RegularImmutableTable
    Table.Cell<R, C, V> getCell(int index) {
        Map.Entry<R, ImmutableMap<C, V>> rowEntry = this.rowMap.entrySet().asList().get(this.cellRowIndices[index]);
        ImmutableMap<C, V> row = rowEntry.getValue();
        Map.Entry<C, V> colEntry = row.entrySet().asList().get(this.cellColumnInRowIndices[index]);
        return cellOf(rowEntry.getKey(), colEntry.getKey(), colEntry.getValue());
    }

    @Override // com.google.common.collect.RegularImmutableTable
    V getValue(int index) {
        ImmutableMap<C, V> row = this.rowMap.values().asList().get(this.cellRowIndices[index]);
        return row.values().asList().get(this.cellColumnInRowIndices[index]);
    }

    @Override // com.google.common.collect.ImmutableTable
    ImmutableTable.SerializedForm createSerializedForm() {
        Map<C, Integer> columnKeyToIndex = Maps.indexMap(columnKeySet());
        int[] cellColumnIndices = new int[cellSet().size()];
        int i = 0;
        UnmodifiableIterator<Table.Cell<R, C, V>> it = cellSet().iterator();
        while (it.hasNext()) {
            i++;
            cellColumnIndices[i] = columnKeyToIndex.get(it.next().getColumnKey()).intValue();
        }
        return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, cellColumnIndices);
    }
}
