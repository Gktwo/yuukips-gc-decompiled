package org.eclipse.jetty.server;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/EncodingHttpWriter.class */
public class EncodingHttpWriter extends HttpWriter {
    final Writer _converter;

    public EncodingHttpWriter(HttpOutput out, String encoding) {
        super(out);
        try {
            this._converter = new OutputStreamWriter(this._bytes, encoding);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.eclipse.jetty.server.HttpWriter, java.io.Writer
    public void write(char[] s, int offset, int length) throws IOException {
        HttpOutput out = this._out;
        while (length > 0) {
            this._bytes.reset();
            int chars = Math.min(length, 512);
            this._converter.write(s, offset, chars);
            this._converter.flush();
            this._bytes.writeTo(out);
            length -= chars;
            offset += chars;
        }
    }
}
