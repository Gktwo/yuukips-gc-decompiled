package com.fasterxml.jackson.core.util;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/util/InternCache.class */
public final class InternCache extends ConcurrentHashMap<String, String> {
    private static final long serialVersionUID = 1;
    private static final int MAX_ENTRIES = 180;
    public static final InternCache instance = new InternCache();
    private final Object lock = new Object();

    private InternCache() {
        super(180, 0.8f, 4);
    }

    public String intern(String input) {
        String result = get(input);
        if (result != null) {
            return result;
        }
        if (size() >= 180) {
            synchronized (this.lock) {
                if (size() >= 180) {
                    clear();
                }
            }
        }
        String result2 = input.intern();
        put(result2, result2);
        return result2;
    }
}
