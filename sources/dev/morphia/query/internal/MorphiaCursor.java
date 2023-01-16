package dev.morphia.query.internal;

import com.mongodb.client.MongoCursor;

@Deprecated(forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/query/internal/MorphiaCursor.class */
public class MorphiaCursor<T> extends dev.morphia.query.MorphiaCursor<T> {
    public MorphiaCursor(MongoCursor<T> cursor) {
        super(cursor);
    }
}
