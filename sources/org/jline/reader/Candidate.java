package org.jline.reader;

import java.util.Objects;

/* loaded from: grasscutter.jar:org/jline/reader/Candidate.class */
public class Candidate implements Comparable<Candidate> {
    private final String value;
    private final String displ;
    private final String group;
    private final String descr;
    private final String suffix;
    private final String key;
    private final boolean complete;
    private final int sort;

    public Candidate(String value) {
        this(value, value, null, null, null, null, true, 0);
    }

    public Candidate(String value, String displ, String group, String descr, String suffix, String key, boolean complete, int sort) {
        this.value = (String) Objects.requireNonNull(value);
        this.displ = (String) Objects.requireNonNull(displ);
        this.group = group;
        this.descr = descr;
        this.suffix = suffix;
        this.key = key;
        this.complete = complete;
        this.sort = sort;
    }

    public Candidate(String value, String displ, String group, String descr, String suffix, String key, boolean complete) {
        this(value, displ, group, descr, suffix, key, complete, 0);
    }

    public String value() {
        return this.value;
    }

    public String displ() {
        return this.displ;
    }

    public String group() {
        return this.group;
    }

    public String descr() {
        return this.descr;
    }

    public String suffix() {
        return this.suffix;
    }

    public String key() {
        return this.key;
    }

    public boolean complete() {
        return this.complete;
    }

    public int sort() {
        return this.sort;
    }

    public int compareTo(Candidate o) {
        if (this.sort == o.sort()) {
            return this.value.compareTo(o.value);
        }
        return this.sort - o.sort();
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return Objects.equals(this.value, ((Candidate) o).value);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @Override // java.lang.Object
    public String toString() {
        return "Candidate{" + this.value + "}";
    }
}
