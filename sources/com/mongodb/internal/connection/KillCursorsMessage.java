package com.mongodb.internal.connection;

import com.mongodb.assertions.Assertions;
import com.mongodb.internal.connection.RequestMessage;
import java.util.List;
import org.bson.p022io.BsonOutput;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/KillCursorsMessage.class */
public class KillCursorsMessage extends LegacyMessage {
    private final List<Long> cursors;

    /* access modifiers changed from: package-private */
    public KillCursorsMessage(List<Long> cursors) {
        super(OpCode.OP_KILL_CURSORS, MessageSettings.builder().build());
        this.cursors = (List) Assertions.notNull("cursors", cursors);
    }

    @Override // com.mongodb.internal.connection.LegacyMessage
    protected RequestMessage.EncodingMetadata encodeMessageBodyWithMetadata(BsonOutput bsonOutput) {
        writeKillCursorsPrologue(this.cursors.size(), bsonOutput);
        for (Long cur : this.cursors) {
            bsonOutput.writeInt64(cur.longValue());
        }
        return new RequestMessage.EncodingMetadata(bsonOutput.getPosition());
    }

    private void writeKillCursorsPrologue(int numCursors, BsonOutput bsonOutput) {
        bsonOutput.writeInt32(0);
        bsonOutput.writeInt32(numCursors);
    }
}
