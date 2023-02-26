package org.jline.terminal.impl;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import org.jline.terminal.Attributes;
import org.jline.terminal.spi.Pty;
import org.jline.utils.NonBlockingInputStream;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/impl/AbstractPty.class */
public abstract class AbstractPty implements Pty {
    private Attributes current;

    protected abstract void doSetAttr(Attributes attributes) throws IOException;

    protected abstract InputStream doGetSlaveInput() throws IOException;

    @Override // org.jline.terminal.spi.Pty
    public void setAttr(Attributes attr) throws IOException {
        this.current = new Attributes(attr);
        doSetAttr(attr);
    }

    @Override // org.jline.terminal.spi.Pty
    public InputStream getSlaveInput() throws IOException {
        InputStream si = doGetSlaveInput();
        if (Boolean.parseBoolean(System.getProperty("org.jline.terminal.pty.nonBlockingReads", C3P0Substitutions.DEBUG))) {
            return new PtyInputStream(si);
        }
        return si;
    }

    protected void checkInterrupted() throws InterruptedIOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/impl/AbstractPty$PtyInputStream.class */
    class PtyInputStream extends NonBlockingInputStream {

        /* renamed from: in */
        final InputStream f3203in;

        /* renamed from: c */
        int f3204c = 0;

        PtyInputStream(InputStream in) {
            this.f3203in = in;
        }

        @Override // org.jline.utils.NonBlockingInputStream
        public int read(long timeout, boolean isPeek) throws IOException {
            AbstractPty.this.checkInterrupted();
            if (this.f3204c != 0) {
                int r = this.f3204c;
                if (!isPeek) {
                    this.f3204c = 0;
                }
                return r;
            }
            setNonBlocking();
            long start = System.currentTimeMillis();
            while (true) {
                int r2 = this.f3203in.read();
                if (r2 >= 0) {
                    if (isPeek) {
                        this.f3204c = r2;
                    }
                    return r2;
                }
                AbstractPty.this.checkInterrupted();
                long cur = System.currentTimeMillis();
                if (timeout > 0 && cur - start > timeout) {
                    return -2;
                }
            }
        }

        @Override // org.jline.utils.NonBlockingInputStream
        public int readBuffered(byte[] b) throws IOException {
            return this.f3203in.read(b);
        }

        private void setNonBlocking() {
            if (AbstractPty.this.current == null || AbstractPty.this.current.getControlChar(Attributes.ControlChar.VMIN) != 0 || AbstractPty.this.current.getControlChar(Attributes.ControlChar.VTIME) != 1) {
                try {
                    Attributes attr = AbstractPty.this.getAttr();
                    attr.setControlChar(Attributes.ControlChar.VMIN, 0);
                    attr.setControlChar(Attributes.ControlChar.VTIME, 1);
                    AbstractPty.this.setAttr(attr);
                } catch (IOException e) {
                    throw new IOError(e);
                }
            }
        }
    }
}
