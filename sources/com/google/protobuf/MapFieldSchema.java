package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import java.util.Map;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/protobuf/MapFieldSchema.class */
public interface MapFieldSchema {
    Map<?, ?> forMutableMapData(Object obj);

    Map<?, ?> forMapData(Object obj);

    boolean isImmutable(Object obj);

    Object toImmutable(Object obj);

    Object newMapField(Object obj);

    MapEntryLite.Metadata<?, ?> forMapMetadata(Object obj);

    Object mergeFrom(Object obj, Object obj2);

    int getSerializedSize(int i, Object obj, Object obj2);
}
