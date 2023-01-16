package org.bson.internal;

import org.bson.UuidRepresentation;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:org/bson/internal/CodecRegistryHelper.class */
public final class CodecRegistryHelper {
    public static CodecRegistry createRegistry(CodecRegistry codecRegistry, UuidRepresentation uuidRepresentation) {
        if (uuidRepresentation == UuidRepresentation.UNSPECIFIED) {
            return codecRegistry;
        }
        return new OverridableUuidRepresentationCodecRegistry(codecRegistry, uuidRepresentation);
    }

    private CodecRegistryHelper() {
    }
}
