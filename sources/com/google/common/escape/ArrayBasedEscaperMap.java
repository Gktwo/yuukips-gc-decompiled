package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;

@Beta
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/escape/ArrayBasedEscaperMap.class */
public final class ArrayBasedEscaperMap {
    private final char[][] replacementArray;
    private static final char[][] EMPTY_REPLACEMENT_ARRAY = new char[0][0][];

    public static ArrayBasedEscaperMap create(Map<Character, String> replacements) {
        return new ArrayBasedEscaperMap(createReplacementArray(replacements));
    }

    private ArrayBasedEscaperMap(char[][] replacementArray) {
        this.replacementArray = replacementArray;
    }

    /* access modifiers changed from: package-private */
    public char[][] getReplacementArray() {
        return this.replacementArray;
    }

    @VisibleForTesting
    static char[][] createReplacementArray(Map<Character, String> map) {
        Preconditions.checkNotNull(map);
        if (map.isEmpty()) {
            return EMPTY_REPLACEMENT_ARRAY;
        }
        char[][] replacements = new char[((Character) Collections.max(map.keySet())).charValue() + 1];
        for (Character ch : map.keySet()) {
            char c = ch.charValue();
            replacements[c] = map.get(Character.valueOf(c)).toCharArray();
        }
        return replacements;
    }
}
