package org.jline.terminal.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jline.terminal.Terminal;
import org.jline.terminal.spi.Pty;
import org.jline.utils.ClosedException;
import org.jline.utils.NonBlocking;
import org.jline.utils.NonBlockingInputStream;
import org.jline.utils.NonBlockingReader;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/impl/PosixPtyTerminal.class */
public class PosixPtyTerminal extends AbstractPosixTerminal {

    /* renamed from: in */
    private final InputStream f3205in;
    private final OutputStream out;
    private final InputStream masterInput;
    private final OutputStream masterOutput;
    private final NonBlockingInputStream input;
    private final OutputStream output;
    private final NonBlockingReader reader;
    private final PrintWriter writer;
    private final Object lock;
    private Thread inputPumpThread;
    private Thread outputPumpThread;
    private boolean paused;

    public PosixPtyTerminal(String name, String type, Pty pty, InputStream in, OutputStream out, Charset encoding) throws IOException {
        this(name, type, pty, in, out, encoding, Terminal.SignalHandler.SIG_DFL);
    }

    public PosixPtyTerminal(String name, String type, Pty pty, InputStream in, OutputStream out, Charset encoding, Terminal.SignalHandler signalHandler) throws IOException {
        this(name, type, pty, in, out, encoding, signalHandler, false);
    }

    public PosixPtyTerminal(String name, String type, Pty pty, InputStream in, OutputStream out, Charset encoding, Terminal.SignalHandler signalHandler, boolean paused) throws IOException {
        super(name, type, pty, encoding, signalHandler);
        this.lock = new Object();
        this.paused = true;
        this.f3205in = (InputStream) Objects.requireNonNull(in);
        this.out = (OutputStream) Objects.requireNonNull(out);
        this.masterInput = pty.getMasterInput();
        this.masterOutput = pty.getMasterOutput();
        this.input = new InputStreamWrapper(NonBlocking.nonBlocking(name, pty.getSlaveInput()));
        this.output = pty.getSlaveOutput();
        this.reader = NonBlocking.nonBlocking(name, this.input, encoding());
        this.writer = new PrintWriter(new OutputStreamWriter(this.output, encoding()));
        parseInfoCmp();
        if (!paused) {
            resume();
        }
    }

    @Override // org.jline.terminal.Terminal
    public InputStream input() {
        return this.input;
    }

    @Override // org.jline.terminal.Terminal
    public NonBlockingReader reader() {
        return this.reader;
    }

    @Override // org.jline.terminal.Terminal
    public OutputStream output() {
        return this.output;
    }

    @Override // org.jline.terminal.Terminal
    public PrintWriter writer() {
        return this.writer;
    }

    /* access modifiers changed from: protected */
    @Override // org.jline.terminal.impl.AbstractPosixTerminal, org.jline.terminal.impl.AbstractTerminal
    public void doClose() throws IOException {
        doClose();
        this.reader.close();
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
        Thread p1;
        Thread p2;
        synchronized (this.lock) {
            this.paused = true;
            p1 = this.inputPumpThread;
            p2 = this.outputPumpThread;
        }
        if (p1 != null) {
            p1.interrupt();
        }
        if (p2 != null) {
            p2.interrupt();
        }
        if (p1 != null) {
            p1.join();
        }
        if (p2 != null) {
            p2.join();
        }
    }

    @Override // org.jline.terminal.impl.AbstractTerminal, org.jline.terminal.Terminal
    public void resume() {
        synchronized (this.lock) {
            this.paused = false;
            if (this.inputPumpThread == null) {
                this.inputPumpThread = new Thread(this::pumpIn, toString() + " input pump thread");
                this.inputPumpThread.setDaemon(true);
                this.inputPumpThread.start();
            }
            if (this.outputPumpThread == null) {
                this.outputPumpThread = new Thread(this::pumpOut, toString() + " output pump thread");
                this.outputPumpThread.setDaemon(true);
                this.outputPumpThread.start();
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

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/impl/PosixPtyTerminal$InputStreamWrapper.class */
    private static class InputStreamWrapper extends NonBlockingInputStream {

        /* renamed from: in */
        private final NonBlockingInputStream f3206in;
        private final AtomicBoolean closed = new AtomicBoolean();

        protected InputStreamWrapper(NonBlockingInputStream in) {
            this.f3206in = in;
        }

        @Override // org.jline.utils.NonBlockingInputStream
        public int read(long timeout, boolean isPeek) throws IOException {
            if (!this.closed.get()) {
                return this.f3206in.read(timeout, isPeek);
            }
            throw new ClosedException();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.closed.set(true);
        }
    }

    private void pumpIn() {
        while (true) {
            try {
                try {
                    synchronized (this.lock) {
                        try {
                            if (this.paused) {
                                this.inputPumpThread = null;
                                synchronized (this.lock) {
                                    try {
                                        this.inputPumpThread = null;
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                                return;
                            }
                            int b = this.f3205in.read();
                            if (b < 0) {
                                this.input.close();
                                synchronized (this.lock) {
                                    try {
                                        this.inputPumpThread = null;
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                                return;
                            }
                            this.masterOutput.write(b);
                            this.masterOutput.flush();
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    synchronized (this.lock) {
                        try {
                            this.inputPumpThread = null;
                            return;
                        } catch (Throwable th4) {
                            throw th4;
                        }
                    }
                }
            } catch (Throwable th5) {
                synchronized (this.lock) {
                    try {
                        this.inputPumpThread = null;
                        throw th5;
                    } catch (Throwable th6) {
                        throw th6;
                    }
                }
            }
        }
    }

    private void pumpOut() {
        while (true) {
            try {
                try {
                    synchronized (this.lock) {
                        try {
                            if (this.paused) {
                                this.outputPumpThread = null;
                                synchronized (this.lock) {
                                    try {
                                        this.outputPumpThread = null;
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                                return;
                            }
                            int b = this.masterInput.read();
                            if (b < 0) {
                                this.input.close();
                                synchronized (this.lock) {
                                    try {
                                        this.outputPumpThread = null;
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                                break;
                            }
                            this.out.write(b);
                            this.out.flush();
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    synchronized (this.lock) {
                        try {
                            this.outputPumpThread = null;
                        } catch (Throwable th4) {
                            throw th4;
                        }
                    }
                }
            } catch (Throwable th5) {
                synchronized (this.lock) {
                    try {
                        this.outputPumpThread = null;
                        throw th5;
                    } catch (Throwable th6) {
                        throw th6;
                    }
                }
            }
        }
        try {
            close();
        } catch (Throwable th7) {
        }
    }
}
