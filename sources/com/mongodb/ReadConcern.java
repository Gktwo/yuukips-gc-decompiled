package com.mongodb;

import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.BsonValue;

/* loaded from: grasscutter.jar:com/mongodb/ReadConcern.class */
public final class ReadConcern {
    private final ReadConcernLevel level;
    public static final ReadConcern DEFAULT = new ReadConcern();
    public static final ReadConcern LOCAL = new ReadConcern(ReadConcernLevel.LOCAL);
    public static final ReadConcern MAJORITY = new ReadConcern(ReadConcernLevel.MAJORITY);
    public static final ReadConcern LINEARIZABLE = new ReadConcern(ReadConcernLevel.LINEARIZABLE);
    public static final ReadConcern SNAPSHOT = new ReadConcern(ReadConcernLevel.SNAPSHOT);
    public static final ReadConcern AVAILABLE = new ReadConcern(ReadConcernLevel.AVAILABLE);

    public ReadConcern(ReadConcernLevel level) {
        this.level = (ReadConcernLevel) Assertions.notNull("level", level);
    }

    @Nullable
    public ReadConcernLevel getLevel() {
        return this.level;
    }

    public boolean isServerDefault() {
        return this.level == null;
    }

    public BsonDocument asDocument() {
        BsonDocument readConcern = new BsonDocument();
        if (this.level != null) {
            readConcern.put("level", (BsonValue) new BsonString(this.level.getValue()));
        }
        return readConcern;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return o != null && getClass() == o.getClass() && this.level == ((ReadConcern) o).level;
    }

    public int hashCode() {
        if (this.level != null) {
            return this.level.hashCode();
        }
        return 0;
    }

    private ReadConcern() {
        this.level = null;
    }
}
