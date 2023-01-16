package org.eclipse.jetty.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/Fields.class */
public class Fields implements Iterable<Field> {
    private final boolean caseSensitive;
    private final Map<String, Field> fields;

    public Fields() {
        this(false);
    }

    public Fields(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
        this.fields = new LinkedHashMap();
    }

    public Fields(Fields original, boolean immutable) {
        this.caseSensitive = original.caseSensitive;
        Map<String, Field> copy = new LinkedHashMap<>();
        copy.putAll(original.fields);
        this.fields = immutable ? Collections.unmodifiableMap(copy) : copy;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Fields that = (Fields) obj;
        if (!(getSize() == that.getSize() && this.caseSensitive == that.caseSensitive)) {
            return false;
        }
        for (Map.Entry<String, Field> entry : this.fields.entrySet()) {
            if (!entry.getValue().equals(that.get(entry.getKey()), this.caseSensitive)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.fields.hashCode();
    }

    public Set<String> getNames() {
        Set<String> result = new LinkedHashSet<>();
        for (Field field : this.fields.values()) {
            result.add(field.getName());
        }
        return result;
    }

    private String normalizeName(String name) {
        return this.caseSensitive ? name : name.toLowerCase(Locale.ENGLISH);
    }

    public Field get(String name) {
        return this.fields.get(normalizeName(name));
    }

    public void put(String name, String value) {
        this.fields.put(normalizeName(name), new Field(name, value));
    }

    public void put(Field field) {
        if (field != null) {
            this.fields.put(normalizeName(field.getName()), field);
        }
    }

    public void add(String name, String value) {
        String key = normalizeName(name);
        Field field = this.fields.get(key);
        if (field == null) {
            this.fields.put(key, new Field(name, value));
        } else {
            this.fields.put(key, new Field(field.getName(), field.getValues(), new String[]{value}));
        }
    }

    public Field remove(String name) {
        return this.fields.remove(normalizeName(name));
    }

    public void clear() {
        this.fields.clear();
    }

    public boolean isEmpty() {
        return this.fields.isEmpty();
    }

    public int getSize() {
        return this.fields.size();
    }

    @Override // java.lang.Iterable
    public Iterator<Field> iterator() {
        return this.fields.values().iterator();
    }

    @Override // java.lang.Object
    public String toString() {
        return this.fields.toString();
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Fields$Field.class */
    public static class Field {
        private final String name;
        private final List<String> values;

        public Field(String name, String value) {
            this(name, Collections.singletonList(value), new String[0]);
        }

        private Field(String name, List<String> values, String... moreValues) {
            this.name = name;
            List<String> list = new ArrayList<>(values.size() + moreValues.length);
            list.addAll(values);
            list.addAll(Arrays.asList(moreValues));
            this.values = Collections.unmodifiableList(list);
        }

        public boolean equals(Field that, boolean caseSensitive) {
            if (this == that) {
                return true;
            }
            if (that == null) {
                return false;
            }
            if (caseSensitive) {
                return equals(that);
            }
            return this.name.equalsIgnoreCase(that.name) && this.values.equals(that.values);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Field that = (Field) obj;
            return this.name.equals(that.name) && this.values.equals(that.values);
        }

        public int hashCode() {
            return (31 * this.name.hashCode()) + this.values.hashCode();
        }

        public String getName() {
            return this.name;
        }

        public String getValue() {
            return this.values.get(0);
        }

        public Integer getValueAsInt() {
            String value = getValue();
            if (value == null) {
                return null;
            }
            return Integer.valueOf(value);
        }

        public List<String> getValues() {
            return this.values;
        }

        public boolean hasMultipleValues() {
            return this.values.size() > 1;
        }

        public String toString() {
            return String.format("%s=%s", this.name, this.values);
        }
    }
}
