package org.jline.terminal.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Objects;
import org.jline.terminal.Attributes;
import org.jline.terminal.Size;
import org.jline.terminal.Terminal;
import org.jline.utils.NonBlocking;
import org.jline.utils.NonBlockingPumpInputStream;
import org.jline.utils.NonBlockingReader;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/impl/LineDisciplineTerminal.class */
public class LineDisciplineTerminal extends AbstractTerminal {
    private static final String DEFAULT_TERMINAL_ATTRIBUTES = "speed 9600 baud; 24 rows; 80 columns;\nlflags: icanon isig iexten echo echoe -echok echoke -echonl echoctl\n\t-echoprt -altwerase -noflsh -tostop -flusho pendin -nokerninfo\n\t-extproc\niflags: -istrip icrnl -inlcr -igncr ixon -ixoff ixany imaxbel iutf8\n\t-ignbrk brkint -inpck -ignpar -parmrk\noflags: opost onlcr -oxtabs -onocr -onlret\ncflags: cread cs8 -parenb -parodd hupcl -clocal -cstopb -crtscts -dsrflow\n\t-dtrflow -mdmbuf\ncchars: discard = ^O; dsusp = ^Y; eof = ^D; eol = <undef>;\n\teol2 = <undef>; erase = ^?; intr = ^C; kill = ^U; lnext = ^V;\n\tmin = 1; quit = ^\\; reprint = ^R; start = ^Q; status = ^T;\n\tstop = ^S; susp = ^Z; time = 0; werase = ^W;\n";
    private static final int PIPE_SIZE = 1024;
    protected final OutputStream masterOutput;
    protected final OutputStream slaveInputPipe;
    protected final NonBlockingPumpInputStream slaveInput;
    protected final NonBlockingReader slaveReader;
    protected final PrintWriter slaveWriter;
    protected final OutputStream slaveOutput;
    protected final Attributes attributes;
    protected final Size size;

    public LineDisciplineTerminal(String name, String type, OutputStream masterOutput, Charset encoding) throws IOException {
        this(name, type, masterOutput, encoding, Terminal.SignalHandler.SIG_DFL);
    }

    public LineDisciplineTerminal(String name, String type, OutputStream masterOutput, Charset encoding, Terminal.SignalHandler signalHandler) throws IOException {
        super(name, type, encoding, signalHandler);
        NonBlockingPumpInputStream input = NonBlocking.nonBlockingPumpInputStream(1024);
        this.slaveInputPipe = input.getOutputStream();
        this.slaveInput = input;
        this.slaveReader = NonBlocking.nonBlocking(getName(), this.slaveInput, encoding());
        this.slaveOutput = new FilteringOutputStream();
        this.slaveWriter = new PrintWriter(new OutputStreamWriter(this.slaveOutput, encoding()));
        this.masterOutput = masterOutput;
        this.attributes = ExecPty.doGetAttr("speed 9600 baud; 24 rows; 80 columns;\nlflags: icanon isig iexten echo echoe -echok echoke -echonl echoctl\n\t-echoprt -altwerase -noflsh -tostop -flusho pendin -nokerninfo\n\t-extproc\niflags: -istrip icrnl -inlcr -igncr ixon -ixoff ixany imaxbel iutf8\n\t-ignbrk brkint -inpck -ignpar -parmrk\noflags: opost onlcr -oxtabs -onocr -onlret\ncflags: cread cs8 -parenb -parodd hupcl -clocal -cstopb -crtscts -dsrflow\n\t-dtrflow -mdmbuf\ncchars: discard = ^O; dsusp = ^Y; eof = ^D; eol = <undef>;\n\teol2 = <undef>; erase = ^?; intr = ^C; kill = ^U; lnext = ^V;\n\tmin = 1; quit = ^\\; reprint = ^R; start = ^Q; status = ^T;\n\tstop = ^S; susp = ^Z; time = 0; werase = ^W;\n");
        this.size = new Size(160, 50);
        parseInfoCmp();
    }

    @Override // org.jline.terminal.Terminal
    public NonBlockingReader reader() {
        return this.slaveReader;
    }

    @Override // org.jline.terminal.Terminal
    public PrintWriter writer() {
        return this.slaveWriter;
    }

    @Override // org.jline.terminal.Terminal
    public InputStream input() {
        return this.slaveInput;
    }

    @Override // org.jline.terminal.Terminal
    public OutputStream output() {
        return this.slaveOutput;
    }

    @Override // org.jline.terminal.Terminal
    public Attributes getAttributes() {
        Attributes attr = new Attributes();
        attr.copy(this.attributes);
        return attr;
    }

    @Override // org.jline.terminal.Terminal
    public void setAttributes(Attributes attr) {
        this.attributes.copy(attr);
    }

    @Override // org.jline.terminal.Terminal
    public Size getSize() {
        Size sz = new Size();
        sz.copy(this.size);
        return sz;
    }

    @Override // org.jline.terminal.Terminal
    public void setSize(Size sz) {
        this.size.copy(sz);
    }

    @Override // org.jline.terminal.impl.AbstractTerminal, org.jline.terminal.Terminal
    public void raise(Terminal.Signal signal) {
        Objects.requireNonNull(signal);
        echoSignal(signal);
        raise(signal);
    }

    public void processInputByte(int c) throws IOException {
        boolean flushOut = doProcessInputByte(c);
        this.slaveInputPipe.flush();
        if (flushOut) {
            this.masterOutput.flush();
        }
    }

    public void processInputBytes(byte[] input) throws IOException {
        processInputBytes(input, 0, input.length);
    }

    public void processInputBytes(byte[] input, int offset, int length) throws IOException {
        boolean flushOut = false;
        for (int i = 0; i < length; i++) {
            flushOut |= doProcessInputByte(input[offset + i]);
        }
        this.slaveInputPipe.flush();
        if (flushOut) {
            this.masterOutput.flush();
        }
    }

    protected boolean doProcessInputByte(int c) throws IOException {
        if (this.attributes.getLocalFlag(Attributes.LocalFlag.ISIG)) {
            if (c == this.attributes.getControlChar(Attributes.ControlChar.VINTR)) {
                raise(Terminal.Signal.INT);
                return false;
            } else if (c == this.attributes.getControlChar(Attributes.ControlChar.VQUIT)) {
                raise(Terminal.Signal.QUIT);
                return false;
            } else if (c == this.attributes.getControlChar(Attributes.ControlChar.VSUSP)) {
                raise(Terminal.Signal.TSTP);
                return false;
            } else if (c == this.attributes.getControlChar(Attributes.ControlChar.VSTATUS)) {
                raise(Terminal.Signal.INFO);
            }
        }
        if (c == 13) {
            if (this.attributes.getInputFlag(Attributes.InputFlag.IGNCR)) {
                return false;
            }
            if (this.attributes.getInputFlag(Attributes.InputFlag.ICRNL)) {
                c = 10;
            }
        } else if (c == 10 && this.attributes.getInputFlag(Attributes.InputFlag.INLCR)) {
            c = 13;
        }
        boolean flushOut = false;
        if (this.attributes.getLocalFlag(Attributes.LocalFlag.ECHO)) {
            processOutputByte(c);
            flushOut = true;
        }
        this.slaveInputPipe.write(c);
        return flushOut;
    }

    protected void processOutputByte(int c) throws IOException {
        if (!this.attributes.getOutputFlag(Attributes.OutputFlag.OPOST) || c != 10 || !this.attributes.getOutputFlag(Attributes.OutputFlag.ONLCR)) {
            this.masterOutput.write(c);
            return;
        }
        this.masterOutput.write(13);
        this.masterOutput.write(10);
    }

    protected void processIOException(IOException ioException) {
        this.slaveInput.setIoException(ioException);
    }

    /* access modifiers changed from: protected */
    @Override // org.jline.terminal.impl.AbstractTerminal
    public void doClose() throws IOException {
        doClose();
        try {
            this.slaveReader.close();
            try {
                this.slaveInputPipe.close();
                this.slaveWriter.close();
            } catch (Throwable th) {
                this.slaveWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            try {
                this.slaveInputPipe.close();
                this.slaveWriter.close();
                throw th2;
            } catch (Throwable th3) {
                this.slaveWriter.close();
                throw th3;
            }
        }
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/impl/LineDisciplineTerminal$FilteringOutputStream.class */
    private class FilteringOutputStream extends OutputStream {
        private FilteringOutputStream() {
        }

        @Override // java.io.OutputStream
        public void write(int b) throws IOException {
            LineDisciplineTerminal.this.processOutputByte(b);
            flush();
        }

        @Override // java.io.OutputStream
        public void write(byte[] b, int off, int len) throws IOException {
            if (b == null) {
                throw new NullPointerException();
            } else if (off < 0 || off > b.length || len < 0 || off + len > b.length || off + len < 0) {
                throw new IndexOutOfBoundsException();
            } else if (len != 0) {
                for (int i = 0; i < len; i++) {
                    LineDisciplineTerminal.this.processOutputByte(b[off + i]);
                }
                flush();
            }
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            LineDisciplineTerminal.this.masterOutput.flush();
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            LineDisciplineTerminal.this.masterOutput.close();
        }
    }
}
