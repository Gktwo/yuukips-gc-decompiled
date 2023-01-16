package com.mongodb.connection;

import com.mongodb.annotations.ThreadSafe;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.BsonObjectId;
import org.bson.types.ObjectId;

@ThreadSafe
/* loaded from: grasscutter.jar:com/mongodb/connection/TopologyVersion.class */
public final class TopologyVersion {
    private final ObjectId processId;
    private final long counter;

    public TopologyVersion(BsonDocument topologyVersionDocument) {
        this.processId = topologyVersionDocument.getObjectId("processId").getValue();
        this.counter = topologyVersionDocument.getInt64("counter").getValue();
    }

    public TopologyVersion(ObjectId processId, long counter) {
        this.processId = processId;
        this.counter = counter;
    }

    public ObjectId getProcessId() {
        return this.processId;
    }

    public long getCounter() {
        return this.counter;
    }

    public BsonDocument asDocument() {
        return new BsonDocument("processId", new BsonObjectId(this.processId)).append("counter", new BsonInt64(this.counter));
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TopologyVersion that = (TopologyVersion) o;
        if (this.counter != that.counter) {
            return false;
        }
        return this.processId.equals(that.processId);
    }

    public int hashCode() {
        return (31 * this.processId.hashCode()) + ((int) (this.counter ^ (this.counter >>> 32)));
    }

    public String toString() {
        return "TopologyVersion{processId=" + this.processId + ", counter=" + this.counter + '}';
    }
}
