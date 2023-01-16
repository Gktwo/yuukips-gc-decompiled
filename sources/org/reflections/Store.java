package org.reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: grasscutter.jar:org/reflections/Store.class */
public class Store extends HashMap<String, Map<String, Set<String>>> {
    public Store() {
    }

    public Store(Map<String, Map<String, Set<String>>> storeMap) {
        super(storeMap);
    }
}
