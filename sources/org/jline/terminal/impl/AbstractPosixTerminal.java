package org.jline.terminal.impl;

import java.io.IOError;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.function.IntConsumer;
import org.jline.terminal.Attributes;
import org.jline.terminal.Cursor;
import org.jline.terminal.Size;
import org.jline.terminal.Terminal;
import org.jline.terminal.spi.Pty;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/impl/AbstractPosixTerminal.class */
public abstract class AbstractPosixTerminal extends AbstractTerminal {
    protected final Pty pty;
    protected final Attributes originalAttributes;

    public AbstractPosixTerminal(String name, String type, Pty pty) throws IOException {
        this(name, type, pty, null, Terminal.SignalHandler.SIG_DFL);
    }

    public AbstractPosixTerminal(String name, String type, Pty pty, Charset encoding, Terminal.SignalHandler signalHandler) throws IOException {
        super(name, type, encoding, signalHandler);
        Objects.requireNonNull(pty);
        this.pty = pty;
        this.originalAttributes = this.pty.getAttr();
    }

    public Pty getPty() {
        return this.pty;
    }

    @Override // org.jline.terminal.Terminal
    public Attributes getAttributes() {
        try {
            return this.pty.getAttr();
        } catch (IOException e) {
            throw new IOError(e);
        }
    }

    @Override // org.jline.terminal.Terminal
    public void setAttributes(Attributes attr) {
        try {
            this.pty.setAttr(attr);
        } catch (IOException e) {
            throw new IOError(e);
        }
    }

    @Override // org.jline.terminal.Terminal
    public Size getSize() {
        try {
            return this.pty.getSize();
        } catch (IOException e) {
            throw new IOError(e);
        }
    }

    @Override // org.jline.terminal.Terminal
    public void setSize(Size size) {
        try {
            this.pty.setSize(size);
        } catch (IOException e) {
            throw new IOError(e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.jline.terminal.impl.AbstractTerminal
    public void doClose() throws IOException {
        doClose();
        this.pty.setAttr(this.originalAttributes);
        this.pty.close();
    }

    @Override // org.jline.terminal.impl.AbstractTerminal, org.jline.terminal.Terminal
    public Cursor getCursorPosition(IntConsumer discarded) {
        return CursorSupport.getCursorPosition(this, discarded);
    }
}
