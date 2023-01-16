package com.mongodb.internal.connection;

import com.mongodb.MongoInternalException;
import com.mongodb.assertions.Assertions;
import java.util.HashMap;
import java.util.Map;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/IndexMap.class */
public abstract class IndexMap {
    public abstract IndexMap add(int i, int i2);

    public abstract int map(int i);

    public static IndexMap create() {
        return new RangeBased();
    }

    public static IndexMap create(int startIndex, int count) {
        return new RangeBased(startIndex, count);
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/IndexMap$HashBased.class */
    private static class HashBased extends IndexMap {
        private final Map<Integer, Integer> indexMap = new HashMap();

        HashBased(int startIndex, int count) {
            for (int i = startIndex; i < startIndex + count; i++) {
                this.indexMap.put(Integer.valueOf(i - startIndex), Integer.valueOf(i));
            }
        }

        @Override // com.mongodb.internal.connection.IndexMap
        public IndexMap add(int index, int originalIndex) {
            this.indexMap.put(Integer.valueOf(index), Integer.valueOf(originalIndex));
            return this;
        }

        @Override // com.mongodb.internal.connection.IndexMap
        public int map(int index) {
            Integer originalIndex = this.indexMap.get(Integer.valueOf(index));
            if (originalIndex != null) {
                return originalIndex.intValue();
            }
            throw new MongoInternalException("no mapping found for index " + index);
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/IndexMap$RangeBased.class */
    private static class RangeBased extends IndexMap {
        private int startIndex;
        private int count;

        RangeBased() {
        }

        RangeBased(int startIndex, int count) {
            Assertions.isTrueArgument("startIndex", startIndex >= 0);
            Assertions.isTrueArgument("count", count > 0);
            this.startIndex = startIndex;
            this.count = count;
        }

        @Override // com.mongodb.internal.connection.IndexMap
        public IndexMap add(int index, int originalIndex) {
            if (this.count == 0) {
                this.startIndex = originalIndex;
                this.count = 1;
                return this;
            } else if (originalIndex == this.startIndex + this.count) {
                this.count++;
                return this;
            } else {
                IndexMap hashBasedMap = new HashBased(this.startIndex, this.count);
                hashBasedMap.add(index, originalIndex);
                return hashBasedMap;
            }
        }

        @Override // com.mongodb.internal.connection.IndexMap
        public int map(int index) {
            if (index < 0) {
                throw new MongoInternalException("no mapping found for index " + index);
            } else if (index < this.count) {
                return this.startIndex + index;
            } else {
                throw new MongoInternalException("index should not be greater than or equal to count");
            }
        }
    }
}
