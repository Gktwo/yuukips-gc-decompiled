package org.jline.terminal.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import org.jline.terminal.Attributes;
import org.jline.terminal.Size;
import org.jline.terminal.Terminal;
import org.jline.utils.NonBlocking;
import org.jline.utils.NonBlockingInputStream;
import org.jline.utils.NonBlockingReader;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/impl/DumbTerminal.class */
public class DumbTerminal extends AbstractTerminal {
    private final NonBlockingInputStream input;
    private final OutputStream output;
    private final NonBlockingReader reader;
    private final PrintWriter writer;
    private final Attributes attributes;
    private final Size size;

    public DumbTerminal(InputStream in, OutputStream out) throws IOException {
        this("dumb", "dumb", in, out, null);
    }

    public DumbTerminal(String name, String type, InputStream in, OutputStream out, Charset encoding) throws IOException {
        this(name, type, in, out, encoding, Terminal.SignalHandler.SIG_DFL);
    }

    public DumbTerminal(String name, String type, InputStream in, OutputStream out, Charset encoding, Terminal.SignalHandler signalHandler) throws IOException {
        super(name, type, encoding, signalHandler);
        final NonBlockingInputStream nbis = NonBlocking.nonBlocking(getName(), in);
        this.input = new NonBlockingInputStream() { // from class: org.jline.terminal.impl.DumbTerminal.1
            @Override // org.jline.utils.NonBlockingInputStream
            public int read(long timeout, boolean isPeek) throws IOException {
                int c;
                while (true) {
                    c = nbis.read(timeout, isPeek);
                    if (DumbTerminal.this.attributes.getLocalFlag(Attributes.LocalFlag.ISIG)) {
                        if (c == DumbTerminal.this.attributes.getControlChar(Attributes.ControlChar.VINTR)) {
                            DumbTerminal.this.raise(Terminal.Signal.INT);
                        } else if (c == DumbTerminal.this.attributes.getControlChar(Attributes.ControlChar.VQUIT)) {
                            DumbTerminal.this.raise(Terminal.Signal.QUIT);
                        } else if (c == DumbTerminal.this.attributes.getControlChar(Attributes.ControlChar.VSUSP)) {
                            DumbTerminal.this.raise(Terminal.Signal.TSTP);
                        } else if (c == DumbTerminal.this.attributes.getControlChar(Attributes.ControlChar.VSTATUS)) {
                            DumbTerminal.this.raise(Terminal.Signal.INFO);
                        }
                    }
                    if (c == 13) {
                        if (!DumbTerminal.this.attributes.getInputFlag(Attributes.InputFlag.IGNCR)) {
                            if (DumbTerminal.this.attributes.getInputFlag(Attributes.InputFlag.ICRNL)) {
                                c = 10;
                            }
                        }
                    } else if (c == 10 && DumbTerminal.this.attributes.getInputFlag(Attributes.InputFlag.INLCR)) {
                        c = 13;
                    }
                }
                return c;
            }
        };
        this.output = out;
        this.reader = NonBlocking.nonBlocking(getName(), this.input, encoding());
        this.writer = new PrintWriter(new OutputStreamWriter(this.output, encoding()));
        this.attributes = new Attributes();
        this.attributes.setControlChar(Attributes.ControlChar.VERASE, 127);
        this.attributes.setControlChar(Attributes.ControlChar.VWERASE, 23);
        this.attributes.setControlChar(Attributes.ControlChar.VKILL, 21);
        this.attributes.setControlChar(Attributes.ControlChar.VLNEXT, 22);
        this.size = new Size();
        parseInfoCmp();
    }

    @Override // org.jline.terminal.Terminal
    public NonBlockingReader reader() {
        return this.reader;
    }

    @Override // org.jline.terminal.Terminal
    public PrintWriter writer() {
        return this.writer;
    }

    @Override // org.jline.terminal.Terminal
    public InputStream input() {
        return this.input;
    }

    @Override // org.jline.terminal.Terminal
    public OutputStream output() {
        return this.output;
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
}
