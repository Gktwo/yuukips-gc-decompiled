package com.google.common.p004io;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;

/* access modifiers changed from: package-private */
@GwtIncompatible
/* renamed from: com.google.common.io.LineBuffer */
/* loaded from: grasscutter.jar:com/google/common/io/LineBuffer.class */
public abstract class LineBuffer {
    private StringBuilder line = new StringBuilder();
    private boolean sawReturn;

    protected abstract void handleLine(String str, String str2) throws IOException;

    /* access modifiers changed from: protected */
    public void add(char[] cbuf, int off, int len) throws IOException {
        int pos = off;
        if (this.sawReturn && len > 0) {
            if (finishLine(cbuf[pos] == '\n')) {
                pos++;
            }
        }
        int start = pos;
        int end = off + len;
        while (pos < end) {
            switch (cbuf[pos]) {
                case '\n':
                    this.line.append(cbuf, start, pos - start);
                    finishLine(true);
                    start = pos + 1;
                    break;
                case '\r':
                    this.line.append(cbuf, start, pos - start);
                    this.sawReturn = true;
                    if (pos + 1 < end) {
                        if (finishLine(cbuf[pos + 1] == '\n')) {
                            pos++;
                        }
                    }
                    start = pos + 1;
                    break;
            }
            pos++;
        }
        this.line.append(cbuf, start, (off + len) - start);
    }

    @CanIgnoreReturnValue
    private boolean finishLine(boolean sawNewline) throws IOException {
        handleLine(this.line.toString(), this.sawReturn ? sawNewline ? "\r\n" : "\r" : sawNewline ? "\n" : "");
        this.line = new StringBuilder();
        this.sawReturn = false;
        return sawNewline;
    }

    /* access modifiers changed from: protected */
    public void finish() throws IOException {
        if (this.sawReturn || this.line.length() > 0) {
            finishLine(false);
        }
    }
}
