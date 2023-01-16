package org.jline.style;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

/* loaded from: grasscutter.jar:org/jline/style/NopStyleSource.class */
public class NopStyleSource implements StyleSource {
    @Override // org.jline.style.StyleSource
    @Nullable
    public String get(String group, String name) {
        Objects.requireNonNull(group);
        Objects.requireNonNull(name);
        return null;
    }

    @Override // org.jline.style.StyleSource
    public void set(String group, String name, String style) {
        Objects.requireNonNull(group);
        Objects.requireNonNull(name);
        Objects.requireNonNull(style);
    }

    @Override // org.jline.style.StyleSource
    public void remove(String group) {
        Objects.requireNonNull(group);
    }

    @Override // org.jline.style.StyleSource
    public void remove(String group, String name) {
        Objects.requireNonNull(group);
        Objects.requireNonNull(name);
    }

    @Override // org.jline.style.StyleSource
    public void clear() {
    }

    @Override // org.jline.style.StyleSource
    public Iterable<String> groups() {
        return Collections.unmodifiableList(Collections.emptyList());
    }

    @Override // org.jline.style.StyleSource
    public Map<String, String> styles(String group) {
        return Collections.unmodifiableMap(Collections.emptyMap());
    }
}
