package org.bson;

import java.util.Collection;
import java.util.Iterator;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/StringUtils.class */
public final class StringUtils {
    public static String join(String delimiter, Collection<?> s) {
        StringBuilder builder = new StringBuilder();
        Iterator<?> iter = s.iterator();
        while (iter.hasNext()) {
            builder.append(iter.next());
            if (!iter.hasNext()) {
                break;
            }
            builder.append(delimiter);
        }
        return builder.toString();
    }

    private StringUtils() {
    }
}
