package org.jline.style;

import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: grasscutter.jar:org/jline/style/StyleSource.class */
public interface StyleSource {
    @Nullable
    String get(String str, String str2);

    void set(String str, String str2, String str3);

    void remove(String str);

    void remove(String str, String str2);

    void clear();

    Iterable<String> groups();

    Map<String, String> styles(String str);
}
