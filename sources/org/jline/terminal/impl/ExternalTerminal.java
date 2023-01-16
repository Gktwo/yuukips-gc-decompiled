package org.jline.terminal.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.IntConsumer;
import org.jline.terminal.Attributes;
import org.jline.terminal.Cursor;
import org.jline.terminal.Size;
import org.jline.terminal.Terminal;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/impl/ExternalTerminal.class */
public class ExternalTerminal extends LineDisciplineTerminal {
    protected final AtomicBoolean closed;
    protected final InputStream masterInput;
    protected final Object lock;
    protected boolean paused;
    protected Thread pumpThread;

    public ExternalTerminal(String name, String type, InputStream masterInput, OutputStream masterOutput, Charset encoding) throws IOException {
        this(name, type, masterInput, masterOutput, encoding, Terminal.SignalHandler.SIG_DFL);
    }

    public ExternalTerminal(String name, String type, InputStream masterInput, OutputStream masterOutput, Charset encoding, Terminal.SignalHandler signalHandler) throws IOException {
        this(name, type, masterInput, masterOutput, encoding, signalHandler, false);
    }

    public ExternalTerminal(String name, String type, InputStream masterInput, OutputStream masterOutput, Charset encoding, Terminal.SignalHandler signalHandler, boolean paused) throws IOException {
        this(name, type, masterInput, masterOutput, encoding, signalHandler, paused, null, null);
    }

    public ExternalTerminal(String name, String type, InputStream masterInput, OutputStream masterOutput, Charset encoding, Terminal.SignalHandler signalHandler, boolean paused, Attributes attributes, Size size) throws IOException {
        super(name, type, masterOutput, encoding, signalHandler);
        this.closed = new AtomicBoolean();
        this.lock = new Object();
        this.paused = true;
        this.masterInput = masterInput;
        if (attributes != null) {
            setAttributes(attributes);
        }
        if (size != null) {
            setSize(size);
        }
        if (!paused) {
            resume();
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.jline.terminal.impl.LineDisciplineTerminal, org.jline.terminal.impl.AbstractTerminal
    public void doClose() throws IOException {
        if (this.closed.compareAndSet(false, true)) {
            pause();
            doClose();
        }
    }

    @Override // org.jline.terminal.impl.AbstractTerminal, org.jline.terminal.Terminal
    public boolean canPauseResume() {
        return true;
    }

    @Override // org.jline.terminal.impl.AbstractTerminal, org.jline.terminal.Terminal
    public void pause() {
        synchronized (this.lock) {
            this.paused = true;
        }
    }

    @Override // org.jline.terminal.impl.AbstractTerminal, org.jline.terminal.Terminal
    public void pause(boolean wait) throws InterruptedException {
        Thread p;
        synchronized (this.lock) {
            this.paused = true;
            p = this.pumpThread;
        }
        if (p != null) {
            p.interrupt();
            p.join();
        }
    }

    @Override // org.jline.terminal.impl.AbstractTerminal, org.jline.terminal.Terminal
    public void resume() {
        synchronized (this.lock) {
            this.paused = false;
            if (this.pumpThread == null) {
                this.pumpThread = new Thread(this::pump, toString() + " input pump thread");
                this.pumpThread.setDaemon(true);
                this.pumpThread.start();
            }
        }
    }

    @Override // org.jline.terminal.impl.AbstractTerminal, org.jline.terminal.Terminal
    public boolean paused() {
        boolean z;
        synchronized (this.lock) {
            z = this.paused;
        }
        return z;
    }

    public void pump() {
        try {
            try {
                byte[] buf = new byte[1024];
                while (true) {
                    int c = this.masterInput.read(buf);
                    if (c >= 0) {
                        processInputBytes(buf, 0, c);
                    }
                    if (c < 0 || this.closed.get()) {
                        break;
                    }
                    synchronized (this.lock) {
                        try {
                            if (this.paused) {
                                this.pumpThread = null;
                                synchronized (this.lock) {
                                    try {
                                        this.pumpThread = null;
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                                return;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                synchronized (this.lock) {
                    try {
                        this.pumpThread = null;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
            } catch (IOException e) {
                processIOException(e);
                synchronized (this.lock) {
                    try {
                        this.pumpThread = null;
                    } catch (Throwable th4) {
                        throw th4;
                    }
                }
            }
            try {
                this.slaveInput.close();
            } catch (IOException e2) {
            }
        } catch (Throwable th5) {
            synchronized (this.lock) {
                try {
                    this.pumpThread = null;
                    throw th5;
                } catch (Throwable th6) {
                    throw th6;
                }
            }
        }
    }

    @Override // org.jline.terminal.impl.AbstractTerminal, org.jline.terminal.Terminal
    public Cursor getCursorPosition(IntConsumer discarded) {
        return CursorSupport.getCursorPosition(this, discarded);
    }
}
