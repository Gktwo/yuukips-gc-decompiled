package org.eclipse.jetty.server;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/Utf8HttpWriter.class */
public class Utf8HttpWriter extends HttpWriter {
    int _surrogate = 0;

    public Utf8HttpWriter(HttpOutput out) {
        super(out);
    }

    /* JADX WARNING: Removed duplicated region for block: B:78:0x02e1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02ea A[SYNTHETIC] */
    @Override // org.eclipse.jetty.server.HttpWriter, java.io.Writer
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(char[] r7, int r8, int r9) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 784
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.Utf8HttpWriter.write(char[], int, int):void");
    }
}
