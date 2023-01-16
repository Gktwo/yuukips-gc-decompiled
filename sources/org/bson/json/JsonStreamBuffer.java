package org.bson.json;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:org/bson/json/JsonStreamBuffer.class */
class JsonStreamBuffer implements JsonBuffer {
    private final Reader reader;
    private final List<Integer> markedPositions;
    private final int initialBufferSize;
    private int position;
    private int lastChar;
    private boolean reuseLastChar;
    private boolean eof;
    private char[] buffer;
    private int bufferStartPos;
    private int bufferCount;

    /* access modifiers changed from: package-private */
    public JsonStreamBuffer(Reader reader) {
        this(reader, 16);
    }

    JsonStreamBuffer(Reader reader, int initialBufferSize) {
        this.markedPositions = new ArrayList();
        this.initialBufferSize = initialBufferSize;
        this.reader = reader;
        resetBuffer();
    }

    @Override // org.bson.json.JsonBuffer
    public int getPosition() {
        return this.position;
    }

    @Override // org.bson.json.JsonBuffer
    public int read() {
        if (this.eof) {
            throw new JsonParseException("Trying to read past EOF.");
        } else if (this.reuseLastChar) {
            this.reuseLastChar = false;
            int reusedChar = this.lastChar;
            this.lastChar = -1;
            this.position++;
            return reusedChar;
        } else if (this.position - this.bufferStartPos < this.bufferCount) {
            char c = this.buffer[this.position - this.bufferStartPos];
            this.lastChar = c;
            this.position++;
            return c;
        } else {
            if (this.markedPositions.isEmpty()) {
                resetBuffer();
            }
            try {
                int nextChar = this.reader.read();
                if (nextChar != -1) {
                    this.lastChar = nextChar;
                    addToBuffer((char) nextChar);
                }
                this.position++;
                if (nextChar == -1) {
                    this.eof = true;
                }
                return nextChar;
            } catch (IOException e) {
                throw new JsonParseException(e);
            }
        }
    }

    private void resetBuffer() {
        this.bufferStartPos = -1;
        this.bufferCount = 0;
        this.buffer = new char[this.initialBufferSize];
    }

    @Override // org.bson.json.JsonBuffer
    public void unread(int c) {
        this.eof = false;
        if (c != -1 && this.lastChar == c) {
            this.reuseLastChar = true;
            this.position--;
        }
    }

    @Override // org.bson.json.JsonBuffer
    public int mark() {
        if (this.bufferCount == 0) {
            this.bufferStartPos = this.position;
        }
        if (!this.markedPositions.contains(Integer.valueOf(this.position))) {
            this.markedPositions.add(Integer.valueOf(this.position));
        }
        return this.position;
    }

    @Override // org.bson.json.JsonBuffer
    public void reset(int markPos) {
        if (markPos > this.position) {
            throw new IllegalStateException("mark cannot reset ahead of position, only back");
        }
        int idx = this.markedPositions.indexOf(Integer.valueOf(markPos));
        if (idx == -1) {
            throw new IllegalArgumentException("mark invalidated");
        }
        if (markPos != this.position) {
            this.reuseLastChar = false;
        }
        this.markedPositions.subList(idx, this.markedPositions.size()).clear();
        this.position = markPos;
    }

    @Override // org.bson.json.JsonBuffer
    public void discard(int markPos) {
        int idx = this.markedPositions.indexOf(Integer.valueOf(markPos));
        if (idx != -1) {
            this.markedPositions.subList(idx, this.markedPositions.size()).clear();
        }
    }

    private void addToBuffer(char curChar) {
        if (!this.markedPositions.isEmpty()) {
            if (this.bufferCount == this.buffer.length) {
                char[] newBuffer = new char[this.buffer.length * 2];
                System.arraycopy(this.buffer, 0, newBuffer, 0, this.bufferCount);
                this.buffer = newBuffer;
            }
            this.buffer[this.bufferCount] = curChar;
            this.bufferCount++;
        }
    }
}
