package org.jline.reader;

/* loaded from: grasscutter.jar:org/jline/reader/Macro.class */
public class Macro implements Binding {
    private final String sequence;

    public Macro(String sequence) {
        this.sequence = sequence;
    }

    public String getSequence() {
        return this.sequence;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return this.sequence.equals(((Macro) o).sequence);
    }

    public int hashCode() {
        return this.sequence.hashCode();
    }

    public String toString() {
        return "Macro[" + this.sequence + ']';
    }
}
