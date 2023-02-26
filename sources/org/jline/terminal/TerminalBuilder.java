package org.jline.terminal;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicReference;
import org.jline.terminal.Terminal;
import org.jline.terminal.impl.AbstractPosixTerminal;
import org.jline.terminal.impl.AbstractTerminal;
import org.jline.terminal.impl.DumbTerminal;
import org.jline.terminal.impl.ExecPty;
import org.jline.terminal.impl.ExternalTerminal;
import org.jline.terminal.impl.PosixPtyTerminal;
import org.jline.terminal.impl.PosixSysTerminal;
import org.jline.terminal.spi.JansiSupport;
import org.jline.terminal.spi.JnaSupport;
import org.jline.terminal.spi.Pty;
import org.jline.utils.Log;
import org.jline.utils.OSUtils;
import org.quartz.jobs.NativeJob;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/TerminalBuilder.class */
public final class TerminalBuilder {
    public static final String PROP_ENCODING = "org.jline.terminal.encoding";
    public static final String PROP_CODEPAGE = "org.jline.terminal.codepage";
    public static final String PROP_TYPE = "org.jline.terminal.type";
    public static final String PROP_JNA = "org.jline.terminal.jna";
    public static final String PROP_JANSI = "org.jline.terminal.jansi";
    public static final String PROP_EXEC = "org.jline.terminal.exec";
    public static final String PROP_DUMB = "org.jline.terminal.dumb";
    public static final String PROP_DUMB_COLOR = "org.jline.terminal.dumb.color";
    public static final String PROP_NON_BLOCKING_READS = "org.jline.terminal.pty.nonBlockingReads";
    public static final String PROP_COLOR_DISTANCE = "org.jline.utils.colorDistance";
    public static final String PROP_DISABLE_ALTERNATE_CHARSET = "org.jline.utils.disableAlternateCharset";
    private static final AtomicReference<Terminal> SYSTEM_TERMINAL = new AtomicReference<>();
    private static final AtomicReference<Terminal> TERMINAL_OVERRIDE = new AtomicReference<>();
    private String name;

    /* renamed from: in */
    private InputStream f3202in;
    private OutputStream out;
    private String type;
    private Charset encoding;
    private int codepage;
    private Boolean system;
    private Boolean jna;
    private Boolean jansi;
    private Boolean exec;
    private Boolean dumb;
    private Boolean color;
    private Attributes attributes;
    private Size size;
    private boolean nativeSignals = false;
    private Terminal.SignalHandler signalHandler = Terminal.SignalHandler.SIG_DFL;
    private boolean paused = false;

    public static Terminal terminal() throws IOException {
        return builder().build();
    }

    public static TerminalBuilder builder() {
        return new TerminalBuilder();
    }

    private TerminalBuilder() {
    }

    public TerminalBuilder name(String name) {
        this.name = name;
        return this;
    }

    public TerminalBuilder streams(InputStream in, OutputStream out) {
        this.f3202in = in;
        this.out = out;
        return this;
    }

    public TerminalBuilder system(boolean system) {
        this.system = Boolean.valueOf(system);
        return this;
    }

    public TerminalBuilder jna(boolean jna) {
        this.jna = Boolean.valueOf(jna);
        return this;
    }

    public TerminalBuilder jansi(boolean jansi) {
        this.jansi = Boolean.valueOf(jansi);
        return this;
    }

    public TerminalBuilder exec(boolean exec) {
        this.exec = Boolean.valueOf(exec);
        return this;
    }

    public TerminalBuilder dumb(boolean dumb) {
        this.dumb = Boolean.valueOf(dumb);
        return this;
    }

    public TerminalBuilder type(String type) {
        this.type = type;
        return this;
    }

    public TerminalBuilder color(boolean color) {
        this.color = Boolean.valueOf(color);
        return this;
    }

    public TerminalBuilder encoding(String encoding) throws UnsupportedCharsetException {
        return encoding(encoding != null ? Charset.forName(encoding) : null);
    }

    public TerminalBuilder encoding(Charset encoding) {
        this.encoding = encoding;
        return this;
    }

    @Deprecated
    public TerminalBuilder codepage(int codepage) {
        this.codepage = codepage;
        return this;
    }

    public TerminalBuilder attributes(Attributes attributes) {
        this.attributes = attributes;
        return this;
    }

    public TerminalBuilder size(Size size) {
        this.size = size;
        return this;
    }

    public TerminalBuilder nativeSignals(boolean nativeSignals) {
        this.nativeSignals = nativeSignals;
        return this;
    }

    public TerminalBuilder signalHandler(Terminal.SignalHandler signalHandler) {
        this.signalHandler = signalHandler;
        return this;
    }

    public TerminalBuilder paused(boolean paused) {
        this.paused = paused;
        return this;
    }

    public Terminal build() throws IOException {
        Terminal override = TERMINAL_OVERRIDE.get();
        Terminal terminal = override != null ? override : doBuild();
        if (override != null) {
            Log.debug(() -> {
                return "Overriding terminal with global value set by TerminalBuilder.setTerminalOverride";
            });
        }
        Log.debug(() -> {
            return "Using terminal " + terminal.getClass().getSimpleName();
        });
        if (terminal instanceof AbstractPosixTerminal) {
            Log.debug(() -> {
                return "Using pty " + ((AbstractPosixTerminal) terminal).getPty().getClass().getSimpleName();
            });
        }
        return terminal;
    }

    private Terminal doBuild() throws IOException {
        String str;
        String charsetName;
        String name = this.name;
        if (name == null) {
            name = "JLine terminal";
        }
        Charset encoding = this.encoding;
        if (encoding == null && (charsetName = System.getProperty("org.jline.terminal.encoding")) != null && Charset.isSupported(charsetName)) {
            encoding = Charset.forName(charsetName);
        }
        int codepage = this.codepage;
        if (codepage <= 0 && (str = System.getProperty("org.jline.terminal.codepage")) != null) {
            codepage = Integer.parseInt(str);
        }
        String type = this.type;
        if (type == null) {
            type = System.getProperty("org.jline.terminal.type");
        }
        if (type == null) {
            type = System.getenv("TERM");
        }
        Boolean jna = this.jna;
        if (jna == null) {
            jna = getBoolean("org.jline.terminal.jna", true);
        }
        Boolean jansi = this.jansi;
        if (jansi == null) {
            jansi = getBoolean("org.jline.terminal.jansi", true);
        }
        Boolean exec = this.exec;
        if (exec == null) {
            exec = getBoolean("org.jline.terminal.exec", true);
        }
        Boolean dumb = this.dumb;
        if (dumb == null) {
            dumb = getBoolean("org.jline.terminal.dumb", null);
        }
        if ((this.system == null || !this.system.booleanValue()) && !(this.system == null && this.f3202in == null && this.out == null)) {
            if (jna.booleanValue()) {
                try {
                    return new PosixPtyTerminal(name, type, ((JnaSupport) load(JnaSupport.class)).open(this.attributes, this.size), this.f3202in, this.out, encoding, this.signalHandler, this.paused);
                } catch (Throwable t) {
                    Log.debug("Error creating JNA based terminal: ", t.getMessage(), t);
                }
            }
            if (jansi.booleanValue()) {
                try {
                    return new PosixPtyTerminal(name, type, ((JansiSupport) load(JansiSupport.class)).open(this.attributes, this.size), this.f3202in, this.out, encoding, this.signalHandler, this.paused);
                } catch (Throwable t2) {
                    Log.debug("Error creating JANSI based terminal: ", t2.getMessage(), t2);
                }
            }
            return new ExternalTerminal(name, type, this.f3202in, this.out, encoding, this.signalHandler, this.paused, this.attributes, this.size);
        } else if (this.system == null || ((this.f3202in == null || this.f3202in.equals(System.in)) && (this.out == null || this.out.equals(System.out)))) {
            Terminal terminal = null;
            IllegalStateException exception = new IllegalStateException("Unable to create a system terminal");
            TerminalBuilderSupport tbs = new TerminalBuilderSupport(jna.booleanValue(), jansi.booleanValue());
            if (tbs.isConsoleInput() && tbs.isConsoleOutput()) {
                if (!(this.attributes == null && this.size == null)) {
                    Log.warn("Attributes and size fields are ignored when creating a system terminal");
                }
                if (OSUtils.IS_WINDOWS) {
                    boolean ansiPassThrough = OSUtils.IS_CONEMU;
                    if (tbs.hasJnaSupport()) {
                        try {
                            terminal = tbs.getJnaSupport().winSysTerminal(name, type, ansiPassThrough, encoding, codepage, this.nativeSignals, this.signalHandler, this.paused);
                        } catch (Throwable t3) {
                            Log.debug("Error creating JNA based terminal: ", t3.getMessage(), t3);
                            exception.addSuppressed(t3);
                        }
                    }
                    if (terminal == null && tbs.hasJansiSupport()) {
                        try {
                            terminal = tbs.getJansiSupport().winSysTerminal(name, type, ansiPassThrough, encoding, codepage, this.nativeSignals, this.signalHandler, this.paused);
                        } catch (Throwable t4) {
                            Log.debug("Error creating JANSI based terminal: ", t4.getMessage(), t4);
                            exception.addSuppressed(t4);
                        }
                    }
                    if (terminal == null && exec.booleanValue() && (OSUtils.IS_CYGWIN || OSUtils.IS_MSYSTEM)) {
                        try {
                            if ("xterm".equals(type) && this.type == null && System.getProperty("org.jline.terminal.type") == null) {
                                type = "xterm-256color";
                            }
                            terminal = new PosixSysTerminal(name, type, tbs.getExecPty(), encoding, this.nativeSignals, this.signalHandler);
                        } catch (IOException e) {
                            Log.debug("Error creating EXEC based terminal: ", e.getMessage(), e);
                            exception.addSuppressed(e);
                        }
                    }
                    if (terminal == null && !jna.booleanValue() && !jansi.booleanValue() && (dumb == null || !dumb.booleanValue())) {
                        throw new IllegalStateException("Unable to create a system terminal. On windows, either JNA or JANSI library is required.  Make sure to add one of those in the classpath.");
                    }
                } else {
                    if (tbs.hasJnaSupport()) {
                        try {
                            terminal = new PosixSysTerminal(name, type, tbs.getJnaSupport().current(), encoding, this.nativeSignals, this.signalHandler);
                        } catch (Throwable t5) {
                            Log.debug("Error creating JNA based terminal: ", t5.getMessage(), t5);
                            exception.addSuppressed(t5);
                        }
                    }
                    if (terminal == null && tbs.hasJansiSupport()) {
                        try {
                            terminal = new PosixSysTerminal(name, type, tbs.getJansiSupport().current(), encoding, this.nativeSignals, this.signalHandler);
                        } catch (Throwable t6) {
                            Log.debug("Error creating JANSI based terminal: ", t6.getMessage(), t6);
                            exception.addSuppressed(t6);
                        }
                    }
                    if (terminal == null && exec.booleanValue()) {
                        try {
                            terminal = new PosixSysTerminal(name, type, tbs.getExecPty(), encoding, this.nativeSignals, this.signalHandler);
                        } catch (Throwable t7) {
                            Log.debug("Error creating EXEC based terminal: ", t7.getMessage(), t7);
                            exception.addSuppressed(t7);
                        }
                    }
                }
                if (terminal instanceof AbstractTerminal) {
                    AbstractTerminal t8 = (AbstractTerminal) terminal;
                    if (SYSTEM_TERMINAL.compareAndSet(null, t8)) {
                        t8.setOnClose(() -> {
                            SYSTEM_TERMINAL.compareAndSet(t8, null);
                        });
                    } else {
                        exception.addSuppressed(new IllegalStateException("A system terminal is already running. Make sure to use the created system Terminal on the LineReaderBuilder if you're using one or that previously created system Terminals have been correctly closed."));
                        terminal.close();
                        terminal = null;
                    }
                }
            }
            if (terminal == null && (dumb == null || dumb.booleanValue())) {
                Boolean color = this.color;
                if (color == null) {
                    color = getBoolean("org.jline.terminal.dumb.color", false);
                    if (!color.booleanValue()) {
                        color = Boolean.valueOf(System.getenv("INSIDE_EMACS") != null);
                    }
                    if (!color.booleanValue()) {
                        String command = getParentProcessCommand();
                        color = Boolean.valueOf(command != null && command.contains("idea"));
                    }
                    if (!color.booleanValue()) {
                        color = Boolean.valueOf(tbs.isConsoleOutput() && System.getenv("TERM") != null);
                    }
                    if (!color.booleanValue() && dumb == null) {
                        if (Log.isDebugEnabled()) {
                            Log.warn("input is tty: ", Boolean.valueOf(tbs.isConsoleInput()));
                            Log.warn("output is tty: ", Boolean.valueOf(tbs.isConsoleOutput()));
                            Log.warn("Creating a dumb terminal", exception);
                        } else {
                            Log.warn("Unable to create a system terminal, creating a dumb terminal (enable debug logging for more information)");
                        }
                    }
                }
                terminal = new DumbTerminal(name, color.booleanValue() ? "dumb-color" : "dumb", new FileInputStream(FileDescriptor.in), new FileOutputStream(FileDescriptor.out), encoding, this.signalHandler);
            }
            if (terminal != null) {
                return terminal;
            }
            throw exception;
        } else {
            throw new IllegalArgumentException("Cannot create a system terminal using non System streams");
        }
    }

    private static String getParentProcessCommand() {
        try {
            Class<?> phClass = Class.forName("java.lang.ProcessHandle");
            Object parent = ((Optional) phClass.getMethod("parent", new Class[0]).invoke(phClass.getMethod("current", new Class[0]).invoke(null, new Object[0]), new Object[0])).orElse(null);
            Method infoMethod = phClass.getMethod("info", new Class[0]);
            return (String) ((Optional) infoMethod.getReturnType().getMethod(NativeJob.PROP_COMMAND, new Class[0]).invoke(infoMethod.invoke(parent, new Object[0]), new Object[0])).orElse(null);
        } catch (Throwable th) {
            return null;
        }
    }

    private static Boolean getBoolean(String name, Boolean def) {
        try {
            String str = System.getProperty(name);
            if (str != null) {
                return Boolean.valueOf(Boolean.parseBoolean(str));
            }
        } catch (IllegalArgumentException | NullPointerException e) {
        }
        return def;
    }

    /* access modifiers changed from: private */
    public static <S> S load(Class<S> clazz) {
        return ServiceLoader.load(clazz, clazz.getClassLoader()).iterator().next();
    }

    @Deprecated
    public static void setTerminalOverride(Terminal terminal) {
        TERMINAL_OVERRIDE.set(terminal);
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/terminal/TerminalBuilder$TerminalBuilderSupport.class */
    public static class TerminalBuilderSupport {
        private JansiSupport jansiSupport;
        private JnaSupport jnaSupport;
        private boolean jnaFullSupport;
        private boolean jansiFullSupport;
        private Pty pty;
        private boolean consoleOutput;

        TerminalBuilderSupport(boolean jna, boolean jansi) {
            this.jansiSupport = null;
            this.jnaSupport = null;
            this.pty = null;
            if (jna) {
                try {
                    this.jnaSupport = (JnaSupport) TerminalBuilder.load(JnaSupport.class);
                    this.consoleOutput = this.jnaSupport.isConsoleOutput();
                    this.jnaFullSupport = true;
                } catch (Throwable e) {
                    Log.debug("jnaSupport.isConsoleOutput(): ", e);
                }
            }
            if (jansi) {
                try {
                    this.jansiSupport = (JansiSupport) TerminalBuilder.load(JansiSupport.class);
                    this.consoleOutput = this.jansiSupport.isConsoleOutput();
                    this.jansiFullSupport = true;
                } catch (Throwable e2) {
                    Log.debug("jansiSupport.isConsoleOutput(): ", e2);
                }
            }
            if (!this.jnaFullSupport && !this.jansiFullSupport) {
                try {
                    this.pty = ExecPty.current();
                    this.consoleOutput = true;
                } catch (Exception e3) {
                    Log.debug("ExecPty.current(): ", e3);
                }
            }
        }

        public boolean isConsoleOutput() {
            return this.consoleOutput;
        }

        public boolean isConsoleInput() {
            if (this.jnaFullSupport) {
                return this.jnaSupport.isConsoleInput();
            }
            if (this.jansiFullSupport) {
                return this.jansiSupport.isConsoleInput();
            }
            if (this.pty != null) {
                return true;
            }
            return false;
        }

        public boolean hasJnaSupport() {
            return this.jnaSupport != null;
        }

        public boolean hasJansiSupport() {
            return this.jansiSupport != null;
        }

        public JnaSupport getJnaSupport() {
            return this.jnaSupport;
        }

        public JansiSupport getJansiSupport() {
            return this.jansiSupport;
        }

        public Pty getExecPty() throws IOException {
            if (this.pty == null) {
                this.pty = ExecPty.current();
            }
            return this.pty;
        }
    }
}
