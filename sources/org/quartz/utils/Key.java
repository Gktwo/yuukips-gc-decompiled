package org.quartz.utils;

import java.io.Serializable;
import java.util.UUID;

/* loaded from: grasscutter.jar:org/quartz/utils/Key.class */
public class Key<T> implements Serializable, Comparable<Key<T>> {
    private static final long serialVersionUID = -7141167957642391350L;
    public static final String DEFAULT_GROUP = "DEFAULT";
    private final String name;
    private final String group;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((Key) ((Key) obj));
    }

    public Key(String name, String group) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
        this.name = name;
        if (group != null) {
            this.group = group;
        } else {
            this.group = "DEFAULT";
        }
    }

    public String getName() {
        return this.name;
    }

    public String getGroup() {
        return this.group;
    }

    @Override // java.lang.Object
    public String toString() {
        return getGroup() + '.' + getName();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (31 * ((31 * 1) + (this.group == null ? 0 : this.group.hashCode()))) + (this.name == null ? 0 : this.name.hashCode());
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Key<T> other = (Key) obj;
        if (this.group == null) {
            if (other.group != null) {
                return false;
            }
        } else if (!this.group.equals(other.group)) {
            return false;
        }
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
            return true;
        } else if (!this.name.equals(other.name)) {
            return false;
        } else {
            return true;
        }
    }

    public int compareTo(Key<T> o) {
        if (this.group.equals("DEFAULT") && !o.group.equals("DEFAULT")) {
            return -1;
        }
        if (!this.group.equals("DEFAULT") && o.group.equals("DEFAULT")) {
            return 1;
        }
        int r = this.group.compareTo(o.getGroup());
        if (r != 0) {
            return r;
        }
        return this.name.compareTo(o.getName());
    }

    public static String createUniqueName(String group) {
        if (group == null) {
            group = "DEFAULT";
        }
        return String.format("%s-%s", UUID.nameUUIDFromBytes(group.getBytes()).toString().substring(24), UUID.randomUUID().toString());
    }
}
