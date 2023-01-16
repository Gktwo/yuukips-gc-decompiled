package org.bson;

import java.util.Map;
import java.util.Set;

/* loaded from: grasscutter.jar:org/bson/BSONObject.class */
public interface BSONObject {
    Object put(String str, Object obj);

    void putAll(BSONObject bSONObject);

    void putAll(Map map);

    Object get(String str);

    Map toMap();

    Object removeField(String str);

    boolean containsField(String str);

    Set<String> keySet();
}
