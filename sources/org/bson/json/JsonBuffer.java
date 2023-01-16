package org.bson.json;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/JsonBuffer.class */
public interface JsonBuffer {
    int getPosition();

    int read();

    void unread(int i);

    int mark();

    void reset(int i);

    void discard(int i);
}
