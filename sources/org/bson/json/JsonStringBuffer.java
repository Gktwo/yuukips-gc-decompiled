package org.bson.json;

/* loaded from: grasscutter.jar:org/bson/json/JsonStringBuffer.class */
class JsonStringBuffer implements JsonBuffer {
    private final String buffer;
    private int position;
    private boolean eof;

    /* access modifiers changed from: package-private */
    public JsonStringBuffer(String buffer) {
        this.buffer = buffer;
    }

    @Override // org.bson.json.JsonBuffer
    public int getPosition() {
        return this.position;
    }

    @Override // org.bson.json.JsonBuffer
    public int read() {
        if (this.eof) {
            throw new JsonParseException("Trying to read past EOF.");
        } else if (this.position >= this.buffer.length()) {
            this.eof = true;
            return -1;
        } else {
            String str = this.buffer;
            int i = this.position;
            this.position = i + 1;
            return str.charAt(i);
        }
    }

    @Override // org.bson.json.JsonBuffer
    public void unread(int c) {
        this.eof = false;
        if (c != -1 && this.buffer.charAt(this.position - 1) == c) {
            this.position--;
        }
    }

    @Override // org.bson.json.JsonBuffer
    public int mark() {
        return this.position;
    }

    @Override // org.bson.json.JsonBuffer
    public void reset(int markPos) {
        if (markPos > this.position) {
            throw new IllegalStateException("mark cannot reset ahead of position, only back");
        }
        this.position = markPos;
    }

    @Override // org.bson.json.JsonBuffer
    public void discard(int markPos) {
    }
}
