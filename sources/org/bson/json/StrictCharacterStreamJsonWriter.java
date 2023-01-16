package org.bson.json;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.io.IOException;
import java.io.Writer;
import org.bson.BSONException;
import org.bson.BsonInvalidOperationException;
import org.bson.assertions.Assertions;

/* loaded from: grasscutter.jar:org/bson/json/StrictCharacterStreamJsonWriter.class */
public final class StrictCharacterStreamJsonWriter implements StrictJsonWriter {
    private final Writer writer;
    private final StrictCharacterStreamJsonWriterSettings settings;
    private StrictJsonContext context = new StrictJsonContext(null, JsonContextType.TOP_LEVEL, "");
    private State state = State.INITIAL;
    private int curLength;
    private boolean isTruncated;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/bson/json/StrictCharacterStreamJsonWriter$JsonContextType.class */
    public enum JsonContextType {
        TOP_LEVEL,
        DOCUMENT,
        ARRAY
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/bson/json/StrictCharacterStreamJsonWriter$State.class */
    public enum State {
        INITIAL,
        NAME,
        VALUE,
        DONE
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/bson/json/StrictCharacterStreamJsonWriter$StrictJsonContext.class */
    public static class StrictJsonContext {
        private final StrictJsonContext parentContext;
        private final JsonContextType contextType;
        private final String indentation;
        private boolean hasElements;

        StrictJsonContext(StrictJsonContext parentContext, JsonContextType contextType, String indentChars) {
            this.parentContext = parentContext;
            this.contextType = contextType;
            this.indentation = parentContext == null ? indentChars : parentContext.indentation + indentChars;
        }
    }

    public StrictCharacterStreamJsonWriter(Writer writer, StrictCharacterStreamJsonWriterSettings settings) {
        this.writer = writer;
        this.settings = settings;
    }

    public int getCurrentLength() {
        return this.curLength;
    }

    @Override // org.bson.json.StrictJsonWriter
    public void writeStartObject(String name) {
        writeName(name);
        writeStartObject();
    }

    @Override // org.bson.json.StrictJsonWriter
    public void writeStartArray(String name) {
        writeName(name);
        writeStartArray();
    }

    @Override // org.bson.json.StrictJsonWriter
    public void writeBoolean(String name, boolean value) {
        Assertions.notNull("name", name);
        writeName(name);
        writeBoolean(value);
    }

    @Override // org.bson.json.StrictJsonWriter
    public void writeNumber(String name, String value) {
        Assertions.notNull("name", name);
        Assertions.notNull("value", value);
        writeName(name);
        writeNumber(value);
    }

    @Override // org.bson.json.StrictJsonWriter
    public void writeString(String name, String value) {
        Assertions.notNull("name", name);
        Assertions.notNull("value", value);
        writeName(name);
        writeString(value);
    }

    @Override // org.bson.json.StrictJsonWriter
    public void writeRaw(String name, String value) {
        Assertions.notNull("name", name);
        Assertions.notNull("value", value);
        writeName(name);
        writeRaw(value);
    }

    @Override // org.bson.json.StrictJsonWriter
    public void writeNull(String name) {
        writeName(name);
        writeNull();
    }

    @Override // org.bson.json.StrictJsonWriter
    public void writeName(String name) {
        Assertions.notNull("name", name);
        checkState(State.NAME);
        if (this.context.hasElements) {
            write(",");
        }
        if (this.settings.isIndent()) {
            write(this.settings.getNewLineCharacters());
            write(this.context.indentation);
        } else if (this.context.hasElements) {
            write(" ");
        }
        writeStringHelper(name);
        write(": ");
        this.state = State.VALUE;
    }

    @Override // org.bson.json.StrictJsonWriter
    public void writeBoolean(boolean value) {
        checkState(State.VALUE);
        preWriteValue();
        write(value ? C3P0Substitutions.DEBUG : "false");
        setNextState();
    }

    @Override // org.bson.json.StrictJsonWriter
    public void writeNumber(String value) {
        Assertions.notNull("value", value);
        checkState(State.VALUE);
        preWriteValue();
        write(value);
        setNextState();
    }

    @Override // org.bson.json.StrictJsonWriter
    public void writeString(String value) {
        Assertions.notNull("value", value);
        checkState(State.VALUE);
        preWriteValue();
        writeStringHelper(value);
        setNextState();
    }

    @Override // org.bson.json.StrictJsonWriter
    public void writeRaw(String value) {
        Assertions.notNull("value", value);
        checkState(State.VALUE);
        preWriteValue();
        write(value);
        setNextState();
    }

    @Override // org.bson.json.StrictJsonWriter
    public void writeNull() {
        checkState(State.VALUE);
        preWriteValue();
        write("null");
        setNextState();
    }

    @Override // org.bson.json.StrictJsonWriter
    public void writeStartObject() {
        if (this.state == State.INITIAL || this.state == State.VALUE) {
            preWriteValue();
            write("{");
            this.context = new StrictJsonContext(this.context, JsonContextType.DOCUMENT, this.settings.getIndentCharacters());
            this.state = State.NAME;
            return;
        }
        throw new BsonInvalidOperationException("Invalid state " + this.state);
    }

    @Override // org.bson.json.StrictJsonWriter
    public void writeStartArray() {
        preWriteValue();
        write("[");
        this.context = new StrictJsonContext(this.context, JsonContextType.ARRAY, this.settings.getIndentCharacters());
        this.state = State.VALUE;
    }

    @Override // org.bson.json.StrictJsonWriter
    public void writeEndObject() {
        checkState(State.NAME);
        if (this.settings.isIndent() && this.context.hasElements) {
            write(this.settings.getNewLineCharacters());
            write(this.context.parentContext.indentation);
        }
        write("}");
        this.context = this.context.parentContext;
        if (this.context.contextType == JsonContextType.TOP_LEVEL) {
            this.state = State.DONE;
        } else {
            setNextState();
        }
    }

    @Override // org.bson.json.StrictJsonWriter
    public void writeEndArray() {
        checkState(State.VALUE);
        if (this.context.contextType != JsonContextType.ARRAY) {
            throw new BsonInvalidOperationException("Can't end an array if not in an array");
        }
        if (this.settings.isIndent() && this.context.hasElements) {
            write(this.settings.getNewLineCharacters());
            write(this.context.parentContext.indentation);
        }
        write("]");
        this.context = this.context.parentContext;
        if (this.context.contextType == JsonContextType.TOP_LEVEL) {
            this.state = State.DONE;
        } else {
            setNextState();
        }
    }

    @Override // org.bson.json.StrictJsonWriter
    public boolean isTruncated() {
        return this.isTruncated;
    }

    /* access modifiers changed from: package-private */
    public void flush() {
        try {
            this.writer.flush();
        } catch (IOException e) {
            throwBSONException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public Writer getWriter() {
        return this.writer;
    }

    private void preWriteValue() {
        if (this.context.contextType == JsonContextType.ARRAY) {
            if (this.context.hasElements) {
                write(",");
            }
            if (this.settings.isIndent()) {
                write(this.settings.getNewLineCharacters());
                write(this.context.indentation);
            } else if (this.context.hasElements) {
                write(" ");
            }
        }
        this.context.hasElements = true;
    }

    private void setNextState() {
        if (this.context.contextType == JsonContextType.ARRAY) {
            this.state = State.VALUE;
        } else {
            this.state = State.NAME;
        }
    }

    private void writeStringHelper(String str) {
        write('\"');
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '\b':
                    write("\\b");
                    break;
                case '\t':
                    write("\\t");
                    break;
                case '\n':
                    write("\\n");
                    break;
                case '\f':
                    write("\\f");
                    break;
                case '\r':
                    write("\\r");
                    break;
                case '\"':
                    write("\\\"");
                    break;
                case '\\':
                    write("\\\\");
                    break;
                default:
                    switch (Character.getType(c)) {
                        case 1:
                        case 2:
                        case 3:
                        case 5:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                            write(c);
                            continue;
                        case 4:
                        case 6:
                        case 7:
                        case 8:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        default:
                            write("\\u");
                            write(Integer.toHexString((c & 61440) >> 12));
                            write(Integer.toHexString((c & 3840) >> 8));
                            write(Integer.toHexString((c & 240) >> 4));
                            write(Integer.toHexString(c & 15));
                            continue;
                    }
            }
        }
        write('\"');
    }

    private void write(String str) {
        try {
            if (this.settings.getMaxLength() == 0 || str.length() + this.curLength < this.settings.getMaxLength()) {
                this.writer.write(str);
                this.curLength += str.length();
            } else {
                this.writer.write(str.substring(0, this.settings.getMaxLength() - this.curLength));
                this.curLength = this.settings.getMaxLength();
                this.isTruncated = true;
            }
        } catch (IOException e) {
            throwBSONException(e);
        }
    }

    private void write(char c) {
        try {
            if (this.settings.getMaxLength() == 0 || this.curLength < this.settings.getMaxLength()) {
                this.writer.write(c);
                this.curLength++;
            } else {
                this.isTruncated = true;
            }
        } catch (IOException e) {
            throwBSONException(e);
        }
    }

    private void checkState(State requiredState) {
        if (this.state != requiredState) {
            throw new BsonInvalidOperationException("Invalid state " + this.state);
        }
    }

    private void throwBSONException(IOException e) {
        throw new BSONException("Wrapping IOException", e);
    }
}
