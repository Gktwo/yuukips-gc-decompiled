package org.jline.style;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: grasscutter.jar:org/jline/style/MemoryStyleSource.class */
public class MemoryStyleSource implements StyleSource {
    private static final Logger log = Logger.getLogger(MemoryStyleSource.class.getName());
    private final Map<String, Map<String, String>> backing = new ConcurrentHashMap();

    @Override // org.jline.style.StyleSource
    @Nullable
    public String get(String group, String name) {
        String style = null;
        Map<String, String> styles = this.backing.get(group);
        if (styles != null) {
            style = styles.get(name);
        }
        if (log.isLoggable(Level.FINEST)) {
            log.finest(String.format("Get: [%s] %s -> %s", group, name, style));
        }
        return style;
    }

    @Override // org.jline.style.StyleSource
    public void set(String group, String name, String style) {
        Objects.requireNonNull(group);
        Objects.requireNonNull(name);
        Objects.requireNonNull(style);
        this.backing.computeIfAbsent(group, k -> {
            return new ConcurrentHashMap();
        }).put(name, style);
        if (log.isLoggable(Level.FINEST)) {
            log.finest(String.format("Set: [%s] %s -> %s", group, name, style));
        }
    }

    @Override // org.jline.style.StyleSource
    public void remove(String group) {
        Objects.requireNonNull(group);
        if (this.backing.remove(group) != null && log.isLoggable(Level.FINEST)) {
            log.finest(String.format("Removed: [%s]", group));
        }
    }

    @Override // org.jline.style.StyleSource
    public void remove(String group, String name) {
        Objects.requireNonNull(group);
        Objects.requireNonNull(name);
        Map<String, String> styles = this.backing.get(group);
        if (styles != null) {
            styles.remove(name);
            if (log.isLoggable(Level.FINEST)) {
                log.finest(String.format("Removed: [%s] %s", group, name));
            }
        }
    }

    @Override // org.jline.style.StyleSource
    public void clear() {
        this.backing.clear();
        log.finest("Cleared");
    }

    @Override // org.jline.style.StyleSource
    public Iterable<String> groups() {
        return Collections.unmodifiableSet(this.backing.keySet());
    }

    @Override // org.jline.style.StyleSource
    public Map<String, String> styles(String group) {
        Objects.requireNonNull(group);
        Map<String, String> result = this.backing.get(group);
        if (result == null) {
            result = Collections.emptyMap();
        }
        return Collections.unmodifiableMap(result);
    }
}
