package com.mongodb;

import java.util.LinkedList;
import java.util.Map;

/* loaded from: grasscutter.jar:com/mongodb/BasicDBObjectBuilder.class */
public class BasicDBObjectBuilder {
    private final LinkedList<DBObject> _stack = new LinkedList<>();

    public BasicDBObjectBuilder() {
        this._stack.add(new BasicDBObject());
    }

    public static BasicDBObjectBuilder start() {
        return new BasicDBObjectBuilder();
    }

    public static BasicDBObjectBuilder start(String key, Object val) {
        return new BasicDBObjectBuilder().add(key, val);
    }

    public static BasicDBObjectBuilder start(Map documentAsMap) {
        BasicDBObjectBuilder builder = new BasicDBObjectBuilder();
        for (Map.Entry entry : documentAsMap.entrySet()) {
            builder.add(entry.getKey().toString(), entry.getValue());
        }
        return builder;
    }

    public BasicDBObjectBuilder append(String key, Object val) {
        _cur().put(key, val);
        return this;
    }

    public BasicDBObjectBuilder add(String key, Object val) {
        return append(key, val);
    }

    public BasicDBObjectBuilder push(String key) {
        BasicDBObject o = new BasicDBObject();
        _cur().put(key, o);
        this._stack.addLast(o);
        return this;
    }

    public BasicDBObjectBuilder pop() {
        if (this._stack.size() <= 1) {
            throw new IllegalArgumentException("can't pop last element");
        }
        this._stack.removeLast();
        return this;
    }

    public DBObject get() {
        return this._stack.getFirst();
    }

    public boolean isEmpty() {
        return ((BasicDBObject) this._stack.getFirst()).size() == 0;
    }

    private DBObject _cur() {
        return this._stack.getLast();
    }
}
