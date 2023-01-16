package emu.grasscutter.scripts.serializer;

import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/scripts/serializer/Serializer.class */
public interface Serializer {
    <T> List<T> toList(Class<T> cls, Object obj);

    <T> T toObject(Class<T> cls, Object obj);

    <T> Map<String, T> toMap(Class<T> cls, Object obj);
}
