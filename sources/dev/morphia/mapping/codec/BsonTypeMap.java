package dev.morphia.mapping.codec;

import com.mongodb.lang.Nullable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.BsonDbPointer;
import org.bson.BsonRegularExpression;
import org.bson.BsonTimestamp;
import org.bson.BsonType;
import org.bson.BsonUndefined;
import org.bson.Document;
import org.bson.types.Binary;
import org.bson.types.Code;
import org.bson.types.CodeWithScope;
import org.bson.types.Decimal128;
import org.bson.types.MaxKey;
import org.bson.types.MinKey;
import org.bson.types.ObjectId;
import org.bson.types.Symbol;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/BsonTypeMap.class */
public class BsonTypeMap {
    private final Map<Class<?>, BsonType> map = new HashMap();

    public BsonTypeMap() {
        this.map.put(List.class, BsonType.ARRAY);
        this.map.put(Binary.class, BsonType.BINARY);
        this.map.put(Boolean.class, BsonType.BOOLEAN);
        this.map.put(Date.class, BsonType.DATE_TIME);
        this.map.put(BsonDbPointer.class, BsonType.DB_POINTER);
        this.map.put(Document.class, BsonType.DOCUMENT);
        this.map.put(Double.class, BsonType.DOUBLE);
        this.map.put(Integer.class, BsonType.INT32);
        this.map.put(Long.class, BsonType.INT64);
        this.map.put(Decimal128.class, BsonType.DECIMAL128);
        this.map.put(MaxKey.class, BsonType.MAX_KEY);
        this.map.put(MinKey.class, BsonType.MIN_KEY);
        this.map.put(Code.class, BsonType.JAVASCRIPT);
        this.map.put(CodeWithScope.class, BsonType.JAVASCRIPT_WITH_SCOPE);
        this.map.put(ObjectId.class, BsonType.OBJECT_ID);
        this.map.put(BsonRegularExpression.class, BsonType.REGULAR_EXPRESSION);
        this.map.put(String.class, BsonType.STRING);
        this.map.put(Symbol.class, BsonType.SYMBOL);
        this.map.put(BsonTimestamp.class, BsonType.TIMESTAMP);
        this.map.put(BsonUndefined.class, BsonType.UNDEFINED);
    }

    @Nullable
    public BsonType get(Class<?> type) {
        return this.map.get(type);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return this.map.equals(((BsonTypeMap) o).map);
    }

    public int hashCode() {
        return this.map.hashCode();
    }
}
