package org.eclipse.jetty.server;

import java.io.IOException;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/Iso88591HttpWriter.class */
public class Iso88591HttpWriter extends HttpWriter {
    public Iso88591HttpWriter(HttpOutput out) {
        super(out);
    }

    @Override // org.eclipse.jetty.server.HttpWriter, java.io.Writer
    public void write(char[] s, int offset, int length) throws IOException {
        HttpOutput out = this._out;
        if (length == 1) {
            char c = s[offset];
            out.write(c < 256 ? c : '?');
            return;
        }
        while (length > 0) {
            this._bytes.reset();
            int chars = Math.min(length, 512);
            byte[] buffer = this._bytes.getBuf();
            int bytes = this._bytes.getCount();
            if (chars > buffer.length - bytes) {
                chars = buffer.length - bytes;
            }
            for (int i = 0; i < chars; i++) {
                char c2 = s[offset + i];
                bytes++;
                buffer[bytes] = (byte) (c2 < 256 ? c2 : '?');
            }
            if (bytes >= 0) {
                this._bytes.setCount(bytes);
            }
            this._bytes.writeTo(out);
            length -= chars;
            offset += chars;
        }
    }
}
