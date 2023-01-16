package dev.morphia.mapping.codec.references;

import com.mongodb.lang.Nullable;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/references/MorphiaProxy.class */
public interface MorphiaProxy {
    boolean isFetched();

    @Nullable
    <T> T unwrap();
}
