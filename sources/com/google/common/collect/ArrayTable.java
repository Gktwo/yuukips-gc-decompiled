package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import emu.grasscutter.net.packet.PacketOpcodes;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;

@Beta
@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/ArrayTable.class */
public final class ArrayTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    private final ImmutableList<R> rowList;
    private final ImmutableList<C> columnList;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final V[][] array;
    private transient ArrayTable<R, C, V>.ColumnMap columnMap;
    private transient ArrayTable<R, C, V>.RowMap rowMap;
    private static final long serialVersionUID = 0;

    @Override // com.google.common.collect.AbstractTable, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return toString();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return hashCode();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return equals(obj);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> rowKeys, Iterable<? extends C> columnKeys) {
        return new ArrayTable<>(rowKeys, columnKeys);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Table<R, C, V> table) {
        return table instanceof ArrayTable ? new ArrayTable<>((ArrayTable) table) : new ArrayTable<>(table);
    }

    private ArrayTable(Iterable<? extends R> rowKeys, Iterable<? extends C> columnKeys) {
        this.rowList = ImmutableList.copyOf(rowKeys);
        this.columnList = ImmutableList.copyOf(columnKeys);
        Preconditions.checkArgument(this.rowList.isEmpty() == this.columnList.isEmpty());
        this.rowKeyToIndex = Maps.indexMap(this.rowList);
        this.columnKeyToIndex = Maps.indexMap(this.columnList);
        this.array = (V[][]) new Object[this.rowList.size()][this.columnList.size()][];
        eraseAll();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.common.collect.Table<R, C, V> */
    /* JADX WARN: Multi-variable type inference failed */
    private ArrayTable(Table<R, C, V> table) {
        this(table.rowKeySet(), table.columnKeySet());
        putAll(table);
    }

    private ArrayTable(ArrayTable<R, C, V> table) {
        this.rowList = table.rowList;
        this.columnList = table.columnList;
        this.rowKeyToIndex = table.rowKeyToIndex;
        this.columnKeyToIndex = table.columnKeyToIndex;
        V[][] copy = (V[][]) new Object[this.rowList.size()][this.columnList.size()][];
        this.array = copy;
        for (int i = 0; i < this.rowList.size(); i++) {
            System.arraycopy(table.array[i], 0, copy[i], 0, table.array[i].length);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/ArrayTable$ArrayMap.class */
    public static abstract class ArrayMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> {
        private final ImmutableMap<K, Integer> keyIndex;

        abstract String getKeyRole();

        abstract V getValue(int i);

        abstract V setValue(int i, V v);

        private ArrayMap(ImmutableMap<K, Integer> keyIndex) {
            this.keyIndex = keyIndex;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.keyIndex.keySet();
        }

        K getKey(int index) {
            return this.keyIndex.keySet().asList().get(index);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.keyIndex.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.keyIndex.isEmpty();
        }

        Map.Entry<K, V> getEntry(final int index) {
            Preconditions.checkElementIndex(index, size());
            return new AbstractMapEntry<K, V>() { // from class: com.google.common.collect.ArrayTable.ArrayMap.1
                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public K getKey() {
                    return (K) ArrayMap.this.getKey(index);
                }

                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public V getValue() {
                    return (V) ArrayMap.this.getValue(index);
                }

                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public V setValue(V value) {
                    return (V) ArrayMap.this.setValue(index, value);
                }
            };
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Iterator<Map.Entry<K, V>> entryIterator() {
            return new AbstractIndexedListIterator<Map.Entry<K, V>>(size()) { // from class: com.google.common.collect.ArrayTable.ArrayMap.2
                /* access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIndexedListIterator
                public Map.Entry<K, V> get(int index) {
                    return ArrayMap.this.getEntry(index);
                }
            };
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Spliterator<Map.Entry<K, V>> entrySpliterator() {
            return CollectSpliterators.indexed(size(), 16, this::getEntry);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object key) {
            return this.keyIndex.containsKey(key);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object key) {
            Integer index = this.keyIndex.get(key);
            if (index == null) {
                return null;
            }
            return getValue(index.intValue());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K key, V value) {
            Integer index = this.keyIndex.get(key);
            if (index != null) {
                return setValue(index.intValue(), value);
            }
            throw new IllegalArgumentException(getKeyRole() + " " + key + " not in " + this.keyIndex.keySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object key) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    /* renamed from: at */
    public V m1449at(int rowIndex, int columnIndex) {
        Preconditions.checkElementIndex(rowIndex, this.rowList.size());
        Preconditions.checkElementIndex(columnIndex, this.columnList.size());
        return this.array[rowIndex][columnIndex];
    }

    @CanIgnoreReturnValue
    public V set(int rowIndex, int columnIndex, V value) {
        Preconditions.checkElementIndex(rowIndex, this.rowList.size());
        Preconditions.checkElementIndex(columnIndex, this.columnList.size());
        V oldValue = this.array[rowIndex][columnIndex];
        this.array[rowIndex][columnIndex] = value;
        return oldValue;
    }

    @GwtIncompatible
    public V[][] toArray(Class<V> valueClass) {
        V[][] copy = (V[][]) ((Object[][]) Array.newInstance((Class<?>) valueClass, this.rowList.size(), this.columnList.size()));
        for (int i = 0; i < this.rowList.size(); i++) {
            System.arraycopy(this.array[i], 0, copy[i], 0, this.array[i].length);
        }
        return copy;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public void eraseAll() {
        for (V[] row : this.array) {
            Arrays.fill(row, (Object) null);
        }
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean contains(Object rowKey, Object columnKey) {
        return containsRow(rowKey) && containsColumn(columnKey);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsColumn(Object columnKey) {
        return this.columnKeyToIndex.containsKey(columnKey);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsRow(Object rowKey) {
        return this.rowKeyToIndex.containsKey(rowKey);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsValue(Object value) {
        V[][] vArr = this.array;
        for (V[] row : vArr) {
            for (V element : row) {
                if (Objects.equal(value, element)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public V get(Object rowKey, Object columnKey) {
        Integer rowIndex = this.rowKeyToIndex.get(rowKey);
        Integer columnIndex = this.columnKeyToIndex.get(columnKey);
        if (rowIndex == null || columnIndex == null) {
            return null;
        }
        return m1449at(rowIndex.intValue(), columnIndex.intValue());
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean isEmpty() {
        return this.rowList.isEmpty() || this.columnList.isEmpty();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public V put(R rowKey, C columnKey, V value) {
        Preconditions.checkNotNull(rowKey);
        Preconditions.checkNotNull(columnKey);
        Integer rowIndex = this.rowKeyToIndex.get(rowKey);
        Preconditions.checkArgument(rowIndex != null, "Row %s not in %s", rowKey, this.rowList);
        Integer columnIndex = this.columnKeyToIndex.get(columnKey);
        Preconditions.checkArgument(columnIndex != null, "Column %s not in %s", columnKey, this.columnList);
        return set(rowIndex.intValue(), columnIndex.intValue(), value);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        putAll(table);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    @CanIgnoreReturnValue
    @Deprecated
    public V remove(Object rowKey, Object columnKey) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    public V erase(Object rowKey, Object columnKey) {
        Integer rowIndex = this.rowKeyToIndex.get(rowKey);
        Integer columnIndex = this.columnKeyToIndex.get(columnKey);
        if (rowIndex == null || columnIndex == null) {
            return null;
        }
        return set(rowIndex.intValue(), columnIndex.intValue(), null);
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return cellSet();
    }

    @Override // com.google.common.collect.AbstractTable
    Iterator<Table.Cell<R, C, V>> cellIterator() {
        return new AbstractIndexedListIterator<Table.Cell<R, C, V>>(size()) { // from class: com.google.common.collect.ArrayTable.1
            /* access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIndexedListIterator
            public Table.Cell<R, C, V> get(int index) {
                return ArrayTable.this.getCell(index);
            }
        };
    }

    @Override // com.google.common.collect.AbstractTable
    Spliterator<Table.Cell<R, C, V>> cellSpliterator() {
        return CollectSpliterators.indexed(size(), PacketOpcodes.SceneTransToPointRsp, this::getCell);
    }

    /* access modifiers changed from: private */
    public Table.Cell<R, C, V> getCell(final int index) {
        return new Tables.AbstractCell<R, C, V>() { // from class: com.google.common.collect.ArrayTable.2
            final int rowIndex;
            final int columnIndex;

            {
                this.rowIndex = index / ArrayTable.this.columnList.size();
                this.columnIndex = index % ArrayTable.this.columnList.size();
            }

            @Override // com.google.common.collect.Table.Cell
            public R getRowKey() {
                return (R) ArrayTable.this.rowList.get(this.rowIndex);
            }

            @Override // com.google.common.collect.Table.Cell
            public C getColumnKey() {
                return (C) ArrayTable.this.columnList.get(this.columnIndex);
            }

            @Override // com.google.common.collect.Table.Cell
            public V getValue() {
                return (V) ArrayTable.this.m1449at(this.rowIndex, this.columnIndex);
            }
        };
    }

    /* access modifiers changed from: private */
    public V getValue(int index) {
        return m1449at(index / this.columnList.size(), index % this.columnList.size());
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C columnKey) {
        Preconditions.checkNotNull(columnKey);
        Integer columnIndex = this.columnKeyToIndex.get(columnKey);
        return columnIndex == null ? ImmutableMap.m1419of() : new Column(columnIndex.intValue());
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/ArrayTable$Column.class */
    public class Column extends ArrayMap<R, V> {
        final int columnIndex;

        Column(int columnIndex) {
            super(ArrayTable.this.rowKeyToIndex);
            this.columnIndex = columnIndex;
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        String getKeyRole() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        V getValue(int index) {
            return (V) ArrayTable.this.m1449at(index, this.columnIndex);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        V setValue(int index, V newValue) {
            return (V) ArrayTable.this.set(index, this.columnIndex, newValue);
        }
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.ColumnMap map = this.columnMap;
        if (map != null) {
            return map;
        }
        ArrayTable<R, C, V>.ColumnMap columnMap = new ColumnMap();
        this.columnMap = columnMap;
        return columnMap;
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/ArrayTable$ColumnMap.class */
    private class ColumnMap extends ArrayMap<C, Map<R, V>> {
        @Override // com.google.common.collect.ArrayTable.ArrayMap, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return put((ColumnMap) obj, (Map) ((Map) obj2));
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        /* bridge */ /* synthetic */ Object setValue(int i, Object obj) {
            return setValue(i, (Map) ((Map) obj));
        }

        private ColumnMap() {
            super(ArrayTable.this.columnKeyToIndex);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        String getKeyRole() {
            return "Column";
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public Map<R, V> getValue(int index) {
            return new Column(index);
        }

        Map<R, V> setValue(int index, Map<R, V> newValue) {
            throw new UnsupportedOperationException();
        }

        public Map<R, V> put(C key, Map<R, V> value) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R rowKey) {
        Preconditions.checkNotNull(rowKey);
        Integer rowIndex = this.rowKeyToIndex.get(rowKey);
        return rowIndex == null ? ImmutableMap.m1419of() : new Row(rowIndex.intValue());
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/ArrayTable$Row.class */
    public class Row extends ArrayMap<C, V> {
        final int rowIndex;

        Row(int rowIndex) {
            super(ArrayTable.this.columnKeyToIndex);
            this.rowIndex = rowIndex;
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        String getKeyRole() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        V getValue(int index) {
            return (V) ArrayTable.this.m1449at(this.rowIndex, index);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        V setValue(int index, V newValue) {
            return (V) ArrayTable.this.set(this.rowIndex, index, newValue);
        }
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.Table
    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.RowMap map = this.rowMap;
        if (map != null) {
            return map;
        }
        ArrayTable<R, C, V>.RowMap rowMap = new RowMap();
        this.rowMap = rowMap;
        return rowMap;
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/ArrayTable$RowMap.class */
    private class RowMap extends ArrayMap<R, Map<C, V>> {
        @Override // com.google.common.collect.ArrayTable.ArrayMap, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return put((RowMap) obj, (Map) ((Map) obj2));
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        /* bridge */ /* synthetic */ Object setValue(int i, Object obj) {
            return setValue(i, (Map) ((Map) obj));
        }

        private RowMap() {
            super(ArrayTable.this.rowKeyToIndex);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        String getKeyRole() {
            return "Row";
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.ArrayMap
        public Map<C, V> getValue(int index) {
            return new Row(index);
        }

        Map<C, V> setValue(int index, Map<C, V> newValue) {
            throw new UnsupportedOperationException();
        }

        public Map<C, V> put(R key, Map<C, V> value) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Collection<V> values() {
        return values();
    }

    @Override // com.google.common.collect.AbstractTable
    Iterator<V> valuesIterator() {
        return new AbstractIndexedListIterator<V>(size()) { // from class: com.google.common.collect.ArrayTable.3
            @Override // com.google.common.collect.AbstractIndexedListIterator
            protected V get(int index) {
                return (V) ArrayTable.this.getValue(index);
            }
        };
    }

    @Override // com.google.common.collect.AbstractTable
    Spliterator<V> valuesSpliterator() {
        return CollectSpliterators.indexed(size(), 16, this::getValue);
    }
}
