package org.bson.internal;

import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:org/bson/internal/CycleDetectingCodecRegistry.class */
interface CycleDetectingCodecRegistry extends CodecRegistry {
    <T> Codec<T> get(ChildCodecRegistry<T> childCodecRegistry);
}
