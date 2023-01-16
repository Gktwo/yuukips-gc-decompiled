package com.google.protobuf;

import java.util.Arrays;

/* loaded from: grasscutter.jar:com/google/protobuf/TextFormatParseLocation.class */
public final class TextFormatParseLocation {
    public static final TextFormatParseLocation EMPTY = new TextFormatParseLocation(-1, -1);
    private final int line;
    private final int column;

    /* access modifiers changed from: package-private */
    public static TextFormatParseLocation create(int line, int column) {
        if (line == -1 && column == -1) {
            return EMPTY;
        }
        if (line >= 0 && column >= 0) {
            return new TextFormatParseLocation(line, column);
        }
        throw new IllegalArgumentException(String.format("line and column values must be >= 0: line %d, column: %d", Integer.valueOf(line), Integer.valueOf(column)));
    }

    private TextFormatParseLocation(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.column;
    }

    public String toString() {
        return String.format("ParseLocation{line=%d, column=%d}", Integer.valueOf(this.line), Integer.valueOf(this.column));
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TextFormatParseLocation)) {
            return false;
        }
        TextFormatParseLocation that = (TextFormatParseLocation) o;
        return this.line == that.getLine() && this.column == that.getColumn();
    }

    public int hashCode() {
        return Arrays.hashCode(new int[]{this.line, this.column});
    }
}
