package org.jline.builtins;

import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.text.DateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.jline.builtins.Options;
import org.jline.console.Printer;
import org.jline.keymap.KeyMap;
import org.jline.reader.impl.DefaultParser;
import org.jline.terminal.Attributes;
import org.jline.terminal.Size;
import org.jline.terminal.Terminal;
import org.jline.terminal.impl.LineDisciplineTerminal;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.Colors;
import org.jline.utils.Display;
import org.jline.utils.InfoCmp;
import p001ch.qos.logback.core.rolling.helper.DateTokenConverter;

/* loaded from: grasscutter.jar:org/jline/builtins/Tmux.class */
public class Tmux {
    public static final String OPT_PREFIX = "prefix";
    public static final String CMD_COMMANDS = "commands";
    public static final String CMD_SEND_PREFIX = "send-prefix";
    public static final String CMD_SPLIT_WINDOW = "split-window";
    public static final String CMD_SPLITW = "splitw";
    public static final String CMD_SELECT_PANE = "select-pane";
    public static final String CMD_SELECTP = "selectp";
    public static final String CMD_RESIZE_PANE = "resize-pane";
    public static final String CMD_RESIZEP = "resizep";
    public static final String CMD_DISPLAY_PANES = "display-panes";
    public static final String CMD_DISPLAYP = "displayp";
    public static final String CMD_CLOCK_MODE = "clock-mode";
    public static final String CMD_SET_OPTION = "set-option";
    public static final String CMD_SET = "set";
    public static final String CMD_LIST_KEYS = "list-keys";
    public static final String CMD_LSK = "lsk";
    public static final String CMD_SEND_KEYS = "send-keys";
    public static final String CMD_SEND = "send";
    public static final String CMD_BIND_KEY = "bind-key";
    public static final String CMD_BIND = "bind";
    public static final String CMD_UNBIND_KEY = "unbind-key";
    public static final String CMD_UNBIND = "unbind";
    public static final String CMD_NEW_WINDOW = "new-window";
    public static final String CMD_NEWW = "neww";
    public static final String CMD_NEXT_WINDOW = "next-window";
    public static final String CMD_NEXT = "next";
    public static final String CMD_PREVIOUS_WINDOW = "previous-window";
    public static final String CMD_PREV = "prev";
    public static final String CMD_LIST_WINDOWS = "list-windows";
    public static final String CMD_LSW = "lsw";
    private static final int[][][] WINDOW_CLOCK_TABLE = {new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}}, new int[][]{new int[]{0, 0, 0, 0, 1}, new int[]{0, 0, 0, 0, 1}, new int[]{0, 0, 0, 0, 1}, new int[]{0, 0, 0, 0, 1}, new int[]{0, 0, 0, 0, 1}}, new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0}, new int[]{1, 1, 1, 1, 1}}, new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}, new int[]{0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}}, new int[][]{new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}, new int[]{0, 0, 0, 0, 1}, new int[]{0, 0, 0, 0, 1}}, new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0}, new int[]{1, 1, 1, 1, 1}, new int[]{0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}}, new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0}, new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}}, new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{0, 0, 0, 0, 1}, new int[]{0, 0, 0, 0, 1}, new int[]{0, 0, 0, 0, 1}, new int[]{0, 0, 0, 0, 1}}, new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}}, new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}, new int[]{0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}}, new int[][]{new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 1, 0, 0}, new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 1, 0, 0}, new int[]{0, 0, 0, 0, 0}}, new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 0, 0, 1}}, new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0}, new int[]{1, 0, 0, 0, 0}}, new int[][]{new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 0, 1, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 0, 0, 1}}};
    private final Terminal terminal;
    private final Display display;
    private final PrintStream err;
    private final String term;
    private final Consumer<Terminal> runner;
    private boolean identify;
    private ScheduledExecutorService executor;
    private ScheduledFuture<?> clockFuture;
    private KeyMap<Object> keyMap;
    private final AtomicBoolean dirty = new AtomicBoolean(true);
    private final AtomicBoolean resized = new AtomicBoolean(true);
    private List<Window> windows = new ArrayList();
    private Integer windowsId = 0;
    private int activeWindow = 0;
    private final AtomicBoolean running = new AtomicBoolean(true);
    private final Size size = new Size();
    private final Map<String, String> serverOptions = new HashMap();
    int ACTIVE_COLOR = 3908;
    int INACTIVE_COLOR = RetcodeOuterClass.Retcode.RET_DUNGEON_ENTER_EXCEED_DAY_COUNT_VALUE;
    int CLOCK_COLOR = RetcodeOuterClass.Retcode.RET_DUNGEON_ENTER_EXCEED_DAY_COUNT_VALUE;

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/jline/builtins/Tmux$Binding.class */
    public enum Binding {
        Discard,
        SelfInsert,
        Mouse
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/builtins/Tmux$Window.class */
    public class Window {
        private VirtualConsole active;
        private int lastActive;
        private Tmux tmux;
        private String name;
        private List<VirtualConsole> panes = new CopyOnWriteArrayList();
        private final AtomicInteger paneId = new AtomicInteger();
        private Layout layout = new Layout();

        public Window(Tmux tmux) throws IOException {
            this.tmux = tmux;
            this.layout.f3206sx = Tmux.this.size.getColumns();
            this.layout.f3207sy = Tmux.this.size.getRows();
            this.layout.type = Layout.Type.WindowPane;
            Objects.requireNonNull(tmux);
            Runnable r9 = () -> {
                tmux.setDirty();
            };
            Objects.requireNonNull(tmux);
            this.active = new VirtualConsole(this.paneId.incrementAndGet(), Tmux.this.term, 0, 0, Tmux.this.size.getColumns(), Tmux.this.size.getRows() - 1, r9, x$0 -> {
                tmux.close(x$0);
            }, this.layout);
            VirtualConsole virtualConsole = this.active;
            int i = this.lastActive;
            this.lastActive = i + 1;
            virtualConsole.active = i;
            this.active.getConsole().setAttributes(Tmux.this.terminal.getAttributes());
            this.panes.add(this.active);
            this.name = "win" + (Tmux.this.windowsId.intValue() < 10 ? "0" + Tmux.this.windowsId : Tmux.this.windowsId);
            Integer num = Tmux.this.windowsId;
            Integer num2 = Tmux.this.windowsId = Integer.valueOf(Tmux.this.windowsId.intValue() + 1);
        }

        public String getName() {
            return this.name;
        }

        public List<VirtualConsole> getPanes() {
            return this.panes;
        }

        public VirtualConsole getActive() {
            return this.active;
        }

        public void remove(VirtualConsole console) {
            this.panes.remove(console);
            if (!this.panes.isEmpty()) {
                console.layout.remove();
                if (this.active == console) {
                    this.active = this.panes.stream().sorted(Comparator.comparingInt(p -> {
                        return p.active;
                    }).reversed()).findFirst().get();
                }
                this.layout = this.active.layout;
                while (this.layout.parent != null) {
                    this.layout = this.layout.parent;
                }
                this.layout.fixOffsets();
                this.layout.fixPanes(Tmux.this.size.getColumns(), Tmux.this.size.getRows());
            }
        }

        public void handleResize() {
            this.layout.resize(Tmux.this.size.getColumns(), Tmux.this.size.getRows() - 1);
            this.panes.forEach(vc -> {
                if (vc.width() != vc.layout.f3206sx || vc.height() != vc.layout.f3207sy || vc.left() != vc.layout.xoff || vc.top() != vc.layout.yoff) {
                    vc.resize(vc.layout.xoff, vc.layout.yoff, vc.layout.f3206sx, vc.layout.f3207sy);
                    Tmux.this.display.clear();
                }
            });
        }

        public VirtualConsole splitPane(Options opt) throws IOException {
            Layout.Type type = opt.isSet("horizontal") ? Layout.Type.LeftRight : Layout.Type.TopBottom;
            if (this.layout.type == Layout.Type.WindowPane) {
                Layout p = new Layout();
                p.f3206sx = this.layout.f3206sx;
                p.f3207sy = this.layout.f3207sy;
                p.type = type;
                p.cells.add(this.layout);
                this.layout.parent = p;
                this.layout = p;
            }
            Layout cell = this.active.layout();
            if (opt.isSet("f")) {
                while (cell.parent != this.layout) {
                    cell = cell.parent;
                }
            }
            int size = -1;
            if (opt.isSet("size")) {
                size = opt.getNumber("size");
            } else if (opt.isSet("perc")) {
                int p2 = opt.getNumber("perc");
                if (type == Layout.Type.TopBottom) {
                    size = (cell.f3207sy * p2) / 100;
                } else {
                    size = (cell.f3206sx * p2) / 100;
                }
            }
            Layout newCell = cell.split(type, size, opt.isSet("before"));
            if (newCell == null) {
                Tmux.this.err.println("create pane failed: pane too small");
                return null;
            }
            int incrementAndGet = this.paneId.incrementAndGet();
            String str = Tmux.this.term;
            int i = newCell.xoff;
            int i2 = newCell.yoff;
            int i3 = newCell.f3206sx;
            int i4 = newCell.f3207sy;
            Tmux tmux = this.tmux;
            Objects.requireNonNull(tmux);
            Runnable r8 = () -> {
                tmux.setDirty();
            };
            Tmux tmux2 = this.tmux;
            Objects.requireNonNull(tmux2);
            VirtualConsole newConsole = new VirtualConsole(incrementAndGet, str, i, i2, i3, i4, r8, x$0 -> {
                tmux2.close(x$0);
            }, newCell);
            this.panes.add(newConsole);
            newConsole.getConsole().setAttributes(Tmux.this.terminal.getAttributes());
            if (!opt.isSet(DateTokenConverter.CONVERTER_KEY)) {
                this.active = newConsole;
                VirtualConsole virtualConsole = this.active;
                int i5 = this.lastActive;
                this.lastActive = i5 + 1;
                virtualConsole.active = i5;
            }
            return newConsole;
        }

        public boolean selectPane(Options opt) {
            VirtualConsole prevActive = this.active;
            if (opt.isSet("L")) {
                this.active = this.panes.stream().filter(c -> {
                    return c.bottom() > this.active.top() && c.top() < this.active.bottom();
                }).filter(c -> {
                    return c != this.active;
                }).sorted(Comparator.comparingInt(c -> {
                    return c.left() > this.active.left() ? c.left() : c.left() + Tmux.this.size.getColumns();
                }).reversed().thenComparingInt(c -> {
                    return -c.active;
                })).findFirst().orElse(this.active);
            } else if (opt.isSet("R")) {
                this.active = this.panes.stream().filter(c -> {
                    return c.bottom() > this.active.top() && c.top() < this.active.bottom();
                }).filter(c -> {
                    return c != this.active;
                }).sorted(Comparator.comparingInt(c -> {
                    return c.left() > this.active.left() ? c.left() : c.left() + Tmux.this.size.getColumns();
                }).thenComparingInt(c -> {
                    return -c.active;
                })).findFirst().orElse(this.active);
            } else if (opt.isSet("U")) {
                this.active = this.panes.stream().filter(c -> {
                    return c.right() > this.active.left() && c.left() < this.active.right();
                }).filter(c -> {
                    return c != this.active;
                }).sorted(Comparator.comparingInt(c -> {
                    return c.top() > this.active.top() ? c.top() : c.top() + Tmux.this.size.getRows();
                }).reversed().thenComparingInt(c -> {
                    return -c.active;
                })).findFirst().orElse(this.active);
            } else if (opt.isSet("D")) {
                this.active = this.panes.stream().filter(c -> {
                    return c.right() > this.active.left() && c.left() < this.active.right();
                }).filter(c -> {
                    return c != this.active;
                }).sorted(Comparator.comparingInt(c -> {
                    return c.top() > this.active.top() ? c.top() : c.top() + Tmux.this.size.getRows();
                }).thenComparingInt(c -> {
                    return -c.active;
                })).findFirst().orElse(this.active);
            }
            boolean out = false;
            if (prevActive != this.active) {
                VirtualConsole virtualConsole = this.active;
                int i = this.lastActive;
                this.lastActive = i + 1;
                virtualConsole.active = i;
                out = true;
            }
            return out;
        }

        public void resizePane(Options opt, int adjust) {
            if (opt.isSet(Printer.WIDTH)) {
                this.active.layout().resizeTo(Layout.Type.LeftRight, opt.getNumber(Printer.WIDTH));
            }
            if (opt.isSet("height")) {
                this.active.layout().resizeTo(Layout.Type.TopBottom, opt.getNumber("height"));
            }
            if (opt.isSet("L")) {
                this.active.layout().resize(Layout.Type.LeftRight, -adjust, true);
            } else if (opt.isSet("R")) {
                this.active.layout().resize(Layout.Type.LeftRight, adjust, true);
            } else if (opt.isSet("U")) {
                this.active.layout().resize(Layout.Type.TopBottom, -adjust, true);
            } else if (opt.isSet("D")) {
                this.active.layout().resize(Layout.Type.TopBottom, adjust, true);
            }
        }
    }

    public Tmux(Terminal terminal, PrintStream err, Consumer<Terminal> runner) throws IOException {
        this.terminal = terminal;
        this.err = err;
        this.runner = runner;
        this.display = new Display(terminal, true);
        Integer colors = terminal.getNumericCapability(InfoCmp.Capability.max_colors);
        this.term = (colors == null || colors.intValue() < 256) ? "screen" : "screen-256color";
        this.serverOptions.put(OPT_PREFIX, "`");
        this.keyMap = createKeyMap(this.serverOptions.get(OPT_PREFIX));
    }

    protected KeyMap<Object> createKeyMap(String prefix) {
        KeyMap<Object> keyMap = createEmptyKeyMap(prefix);
        keyMap.bind((KeyMap<Object>) CMD_SEND_PREFIX, prefix + prefix);
        keyMap.bind((KeyMap<Object>) "split-window -v", prefix + "\"");
        keyMap.bind((KeyMap<Object>) "split-window -h", prefix + "%");
        keyMap.bind((KeyMap<Object>) "select-pane -U", prefix + KeyMap.key(this.terminal, InfoCmp.Capability.key_up));
        keyMap.bind((KeyMap<Object>) "select-pane -D", prefix + KeyMap.key(this.terminal, InfoCmp.Capability.key_down));
        keyMap.bind((KeyMap<Object>) "select-pane -L", prefix + KeyMap.key(this.terminal, InfoCmp.Capability.key_left));
        keyMap.bind((KeyMap<Object>) "select-pane -R", prefix + KeyMap.key(this.terminal, InfoCmp.Capability.key_right));
        keyMap.bind((KeyMap<Object>) "resize-pane -U 5", prefix + KeyMap.esc() + KeyMap.key(this.terminal, InfoCmp.Capability.key_up));
        keyMap.bind((KeyMap<Object>) "resize-pane -D 5", prefix + KeyMap.esc() + KeyMap.key(this.terminal, InfoCmp.Capability.key_down));
        keyMap.bind((KeyMap<Object>) "resize-pane -L 5", prefix + KeyMap.esc() + KeyMap.key(this.terminal, InfoCmp.Capability.key_left));
        keyMap.bind((KeyMap<Object>) "resize-pane -R 5", prefix + KeyMap.esc() + KeyMap.key(this.terminal, InfoCmp.Capability.key_right));
        keyMap.bind((KeyMap<Object>) "resize-pane -U", prefix + KeyMap.translate("^[[1;5A"), prefix + KeyMap.alt(KeyMap.translate("^[[A")));
        keyMap.bind((KeyMap<Object>) "resize-pane -D", prefix + KeyMap.translate("^[[1;5B"), prefix + KeyMap.alt(KeyMap.translate("^[[B")));
        keyMap.bind((KeyMap<Object>) "resize-pane -L", prefix + KeyMap.translate("^[[1;5C"), prefix + KeyMap.alt(KeyMap.translate("^[[C")));
        keyMap.bind((KeyMap<Object>) "resize-pane -R", prefix + KeyMap.translate("^[[1;5D"), prefix + KeyMap.alt(KeyMap.translate("^[[D")));
        keyMap.bind((KeyMap<Object>) CMD_DISPLAY_PANES, prefix + "q");
        keyMap.bind((KeyMap<Object>) CMD_CLOCK_MODE, prefix + "t");
        keyMap.bind((KeyMap<Object>) CMD_NEW_WINDOW, prefix + "c");
        keyMap.bind((KeyMap<Object>) CMD_NEXT_WINDOW, prefix + "n");
        keyMap.bind((KeyMap<Object>) CMD_PREVIOUS_WINDOW, prefix + "p");
        return keyMap;
    }

    protected KeyMap<Object> createEmptyKeyMap(String prefix) {
        KeyMap<Object> keyMap = new KeyMap<>();
        keyMap.setUnicode(Binding.SelfInsert);
        keyMap.setNomatch(Binding.SelfInsert);
        for (int i = 0; i < 255; i++) {
            keyMap.bind((KeyMap<Object>) Binding.Discard, prefix + ((char) i));
        }
        keyMap.bind((KeyMap<Object>) Binding.Mouse, KeyMap.key(this.terminal, InfoCmp.Capability.key_mouse));
        return keyMap;
    }

    public void run() throws IOException {
        Terminal.SignalHandler prevWinchHandler = this.terminal.handle(Terminal.Signal.WINCH, this::resize);
        Terminal.SignalHandler prevIntHandler = this.terminal.handle(Terminal.Signal.INT, this::interrupt);
        Terminal.SignalHandler prevSuspHandler = this.terminal.handle(Terminal.Signal.TSTP, this::suspend);
        Attributes attributes = this.terminal.enterRawMode();
        this.terminal.puts(InfoCmp.Capability.enter_ca_mode, new Object[0]);
        this.terminal.puts(InfoCmp.Capability.keypad_xmit, new Object[0]);
        this.terminal.trackMouse(Terminal.MouseTracking.Any);
        this.terminal.flush();
        this.executor = Executors.newSingleThreadScheduledExecutor();
        try {
            try {
                this.size.copy(this.terminal.getSize());
                this.windows.add(new Window(this));
                this.activeWindow = 0;
                this.runner.accept(active().getConsole());
                new Thread(this::inputLoop, "Mux input loop").start();
                redrawLoop();
                this.executor.shutdown();
                this.terminal.trackMouse(Terminal.MouseTracking.Off);
                this.terminal.puts(InfoCmp.Capability.keypad_local, new Object[0]);
                this.terminal.puts(InfoCmp.Capability.exit_ca_mode, new Object[0]);
                this.terminal.flush();
                this.terminal.setAttributes(attributes);
                this.terminal.handle(Terminal.Signal.WINCH, prevWinchHandler);
                this.terminal.handle(Terminal.Signal.INT, prevIntHandler);
                this.terminal.handle(Terminal.Signal.TSTP, prevSuspHandler);
            } catch (RuntimeException e) {
                throw e;
            }
        } catch (Throwable th) {
            this.executor.shutdown();
            this.terminal.trackMouse(Terminal.MouseTracking.Off);
            this.terminal.puts(InfoCmp.Capability.keypad_local, new Object[0]);
            this.terminal.puts(InfoCmp.Capability.exit_ca_mode, new Object[0]);
            this.terminal.flush();
            this.terminal.setAttributes(attributes);
            this.terminal.handle(Terminal.Signal.WINCH, prevWinchHandler);
            this.terminal.handle(Terminal.Signal.INT, prevIntHandler);
            this.terminal.handle(Terminal.Signal.TSTP, prevSuspHandler);
            throw th;
        }
    }

    private VirtualConsole active() {
        return this.windows.get(this.activeWindow).getActive();
    }

    private List<VirtualConsole> panes() {
        return this.windows.get(this.activeWindow).getPanes();
    }

    private Window window() {
        return this.windows.get(this.activeWindow);
    }

    private void redrawLoop() {
        while (this.running.get()) {
            try {
                synchronized (this.dirty) {
                    while (this.running.get() && !this.dirty.compareAndSet(true, false)) {
                        this.dirty.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handleResize();
            redraw();
        }
    }

    /* access modifiers changed from: private */
    public void setDirty() {
        synchronized (this.dirty) {
            this.dirty.set(true);
            this.dirty.notifyAll();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Try blocks wrapping queue limit reached! Please report as an issue!
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.connectExcHandlers(BlockExceptionHandler.java:88)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.process(BlockExceptionHandler.java:58)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.independentBlockTreeMod(BlockProcessor.java:452)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:51)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private void inputLoop() {
        /*
        // Method dump skipped, instructions count: 447
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.builtins.Tmux.inputLoop():void");
    }

    /* access modifiers changed from: private */
    public synchronized void close(VirtualConsole terminal) {
        int idx = -1;
        Window window = null;
        Iterator<Window> it = this.windows.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Window w = it.next();
            idx = w.getPanes().indexOf(terminal);
            if (idx >= 0) {
                window = w;
                break;
            }
        }
        if (idx >= 0) {
            window.remove(terminal);
            if (!window.getPanes().isEmpty()) {
                resize(Terminal.Signal.WINCH);
            } else if (this.windows.size() > 1) {
                this.windows.remove(window);
                if (this.activeWindow >= this.windows.size()) {
                    this.activeWindow--;
                }
                resize(Terminal.Signal.WINCH);
            } else {
                this.running.set(false);
                setDirty();
            }
        }
    }

    private void resize(Terminal.Signal signal) {
        this.resized.set(true);
        setDirty();
    }

    private void interrupt(Terminal.Signal signal) {
        active().getConsole().raise(signal);
    }

    private void suspend(Terminal.Signal signal) {
        active().getConsole().raise(signal);
    }

    private void handleResize() {
        if (this.resized.compareAndSet(true, false)) {
            this.size.copy(this.terminal.getSize());
        }
        window().handleResize();
    }

    public void execute(PrintStream out, PrintStream err, String command) throws Exception {
        execute(out, err, new DefaultParser().parse(command.trim(), 0).words());
    }

    public synchronized void execute(PrintStream out, PrintStream err, List<String> command) throws Exception {
        String name = command.get(0);
        List<String> args = command.subList(1, command.size());
        char c = 65535;
        switch (name.hashCode()) {
            case -1830406552:
                if (name.equals(CMD_UNBIND_KEY)) {
                    c = '\f';
                    break;
                }
                break;
            case -1625275273:
                if (name.equals(CMD_SEND_PREFIX)) {
                    c = 0;
                    break;
                }
                break;
            case -1485481469:
                if (name.equals(CMD_SPLIT_WINDOW)) {
                    c = 1;
                    break;
                }
                break;
            case -1270525501:
                if (name.equals(CMD_LIST_KEYS)) {
                    c = 14;
                    break;
                }
                break;
            case -911558431:
                if (name.equals(CMD_RESIZE_PANE)) {
                    c = 5;
                    break;
                }
                break;
            case -895858531:
                if (name.equals(CMD_SPLITW)) {
                    c = 2;
                    break;
                }
                break;
            case -840745386:
                if (name.equals(CMD_UNBIND)) {
                    c = '\r';
                    break;
                }
                break;
            case -809256876:
                if (name.equals(CMD_LIST_WINDOWS)) {
                    c = 26;
                    break;
                }
                break;
            case -574715715:
                if (name.equals(CMD_NEW_WINDOW)) {
                    c = 20;
                    break;
                }
                break;
            case -19729127:
                if (name.equals(CMD_SEND_KEYS)) {
                    c = 16;
                    break;
                }
                break;
            case 107460:
                if (name.equals(CMD_LSK)) {
                    c = 15;
                    break;
                }
                break;
            case 107472:
                if (name.equals(CMD_LSW)) {
                    c = 27;
                    break;
                }
                break;
            case 113762:
                if (name.equals("set")) {
                    c = 19;
                    break;
                }
                break;
            case 3023933:
                if (name.equals(CMD_BIND)) {
                    c = 11;
                    break;
                }
                break;
            case 3377879:
                if (name.equals(CMD_NEWW)) {
                    c = 21;
                    break;
                }
                break;
            case 3377907:
                if (name.equals(CMD_NEXT)) {
                    c = 23;
                    break;
                }
                break;
            case 3449395:
                if (name.equals(CMD_PREV)) {
                    c = 25;
                    break;
                }
                break;
            case 3526536:
                if (name.equals(CMD_SEND)) {
                    c = 17;
                    break;
                }
                break;
            case 169151897:
                if (name.equals(CMD_SELECT_PANE)) {
                    c = 3;
                    break;
                }
                break;
            case 182391818:
                if (name.equals(CMD_NEXT_WINDOW)) {
                    c = 22;
                    break;
                }
                break;
            case 285081582:
                if (name.equals(CMD_DISPLAYP)) {
                    c = '\b';
                    break;
                }
                break;
            case 317560710:
                if (name.equals(CMD_PREVIOUS_WINDOW)) {
                    c = 24;
                    break;
                }
                break;
            case 938332367:
                if (name.equals(CMD_BIND_KEY)) {
                    c = '\n';
                    break;
                }
                break;
            case 1043650562:
                if (name.equals(CMD_CLOCK_MODE)) {
                    c = '\t';
                    break;
                }
                break;
            case 1097202236:
                if (name.equals(CMD_RESIZEP)) {
                    c = 6;
                    break;
                }
                break;
            case 1393433920:
                if (name.equals(CMD_DISPLAY_PANES)) {
                    c = 7;
                    break;
                }
                break;
            case 1581835328:
                if (name.equals(CMD_SET_OPTION)) {
                    c = 18;
                    break;
                }
                break;
            case 1978100468:
                if (name.equals(CMD_SELECTP)) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                sendPrefix(out, err, args);
                return;
            case 1:
            case 2:
                splitWindow(out, err, args);
                return;
            case 3:
            case 4:
                selectPane(out, err, args);
                return;
            case 5:
            case 6:
                resizePane(out, err, args);
                return;
            case 7:
            case '\b':
                displayPanes(out, err, args);
                return;
            case '\t':
                clockMode(out, err, args);
                return;
            case '\n':
            case 11:
                bindKey(out, err, args);
                return;
            case '\f':
            case '\r':
                unbindKey(out, err, args);
                return;
            case 14:
            case 15:
                listKeys(out, err, args);
                return;
            case 16:
            case 17:
                sendKeys(out, err, args);
                return;
            case 18:
            case 19:
                setOption(out, err, args);
                return;
            case 20:
            case 21:
                newWindow(out, err, args);
                return;
            case 22:
            case 23:
                nextWindow(out, err, args);
                return;
            case 24:
            case 25:
                previousWindow(out, err, args);
                return;
            case 26:
            case 27:
                listWindows(out, err, args);
                return;
            default:
                return;
        }
    }

    protected void listWindows(PrintStream out, PrintStream err, List<String> args) throws Exception {
        Options opt = Options.compile(new String[]{"list-windows - ", "Usage: list-windows", "  -? --help                    Show help"}).parse(args);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        }
        Stream sorted = IntStream.range(0, this.windows.size()).mapToObj(i -> {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(": ");
            sb.append(this.windows.get(i).getName());
            sb.append(i == this.activeWindow ? "* " : " ");
            sb.append("(");
            sb.append(this.windows.get(i).getPanes().size());
            sb.append(" panes)");
            if (i == this.activeWindow) {
                sb.append(" (active)");
            }
            return sb.toString();
        }).sorted();
        Objects.requireNonNull(out);
        sorted.forEach(this::println);
    }

    protected void previousWindow(PrintStream out, PrintStream err, List<String> args) throws Exception {
        Options opt = Options.compile(new String[]{"previous-window - ", "Usage: previous-window", "  -? --help                    Show help"}).parse(args);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        } else if (this.windows.size() > 1) {
            this.activeWindow--;
            if (this.activeWindow < 0) {
                this.activeWindow = this.windows.size() - 1;
            }
            setDirty();
        }
    }

    protected void nextWindow(PrintStream out, PrintStream err, List<String> args) throws Exception {
        Options opt = Options.compile(new String[]{"next-window - ", "Usage: next-window", "  -? --help                    Show help"}).parse(args);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        } else if (this.windows.size() > 1) {
            this.activeWindow++;
            if (this.activeWindow >= this.windows.size()) {
                this.activeWindow = 0;
            }
            setDirty();
        }
    }

    protected void newWindow(PrintStream out, PrintStream err, List<String> args) throws Exception {
        Options opt = Options.compile(new String[]{"new-window - ", "Usage: new-window", "  -? --help                    Show help"}).parse(args);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        }
        this.windows.add(new Window(this));
        this.activeWindow = this.windows.size() - 1;
        this.runner.accept(active().getConsole());
        setDirty();
    }

    protected void setOption(PrintStream out, PrintStream err, List<String> args) throws Exception {
        Options opt = Options.compile(new String[]{"set-option - ", "Usage: set-option [-agosquw] option [value]", "  -? --help                    Show help", "  -u --unset                   Unset the option"}).parse(args);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        }
        int nbargs = opt.args().size();
        if (nbargs < 1 || nbargs > 2) {
            throw new Options.HelpException(opt.usage());
        }
        String name = opt.args().get(0);
        String value = nbargs > 1 ? opt.args().get(1) : null;
        if (!name.startsWith("@")) {
            char c = 65535;
            switch (name.hashCode()) {
                case -980110702:
                    if (name.equals(OPT_PREFIX)) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (value == null) {
                        throw new IllegalArgumentException("Missing argument");
                    }
                    String prefix = KeyMap.translate(value);
                    String oldPrefix = this.serverOptions.put(OPT_PREFIX, prefix);
                    KeyMap<Object> newKeys = createEmptyKeyMap(prefix);
                    for (Map.Entry<String, Object> e : this.keyMap.getBoundKeys().entrySet()) {
                        if (e.getValue() instanceof String) {
                            if (e.getKey().equals(oldPrefix + oldPrefix)) {
                                newKeys.bind((KeyMap<Object>) e.getValue(), prefix + prefix);
                            } else if (e.getKey().startsWith(oldPrefix)) {
                                newKeys.bind((KeyMap<Object>) e.getValue(), prefix + e.getKey().substring(oldPrefix.length()));
                            } else {
                                newKeys.bind((KeyMap<Object>) e.getValue(), e.getKey());
                            }
                        }
                    }
                    this.keyMap = newKeys;
                    return;
                default:
                    return;
            }
        }
    }

    protected void bindKey(PrintStream out, PrintStream err, List<String> args) throws Exception {
        Options opt = Options.compile(new String[]{"bind-key - ", "Usage: bind-key key command [arguments]", "  -? --help                    Show help"}).setOptionsFirst(true).parse(args);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        }
        List<String> vargs = opt.args();
        if (vargs.size() < 2) {
            throw new Options.HelpException(opt.usage());
        }
        String key = this.serverOptions.get(OPT_PREFIX) + KeyMap.translate(vargs.remove(0));
        this.keyMap.unbind(key.substring(0, 2));
        this.keyMap.bind((KeyMap<Object>) vargs.toArray(new String[vargs.size()]), key);
    }

    protected void unbindKey(PrintStream out, PrintStream err, List<String> args) throws Exception {
        Options opt = Options.compile(new String[]{"unbind-key - ", "Usage: unbind-key key", "  -? --help                    Show help"}).setOptionsFirst(true).parse(args);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        }
        List<String> vargs = opt.args();
        if (vargs.size() != 1) {
            throw new Options.HelpException(opt.usage());
        }
        String key = this.serverOptions.get(OPT_PREFIX) + KeyMap.translate(vargs.remove(0));
        this.keyMap.unbind(key);
        this.keyMap.bind((KeyMap<Object>) Binding.Discard, key);
    }

    protected void listKeys(PrintStream out, PrintStream err, List<String> args) throws Exception {
        Options opt = Options.compile(new String[]{"list-keys - ", "Usage: list-keys ", "  -? --help                    Show help"}).parse(args);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        }
        String prefix = this.serverOptions.get(OPT_PREFIX);
        Stream sorted = this.keyMap.getBoundKeys().entrySet().stream().filter(e -> {
            return e.getValue() instanceof String;
        }).map(e -> {
            String key = (String) e.getKey();
            String val = (String) e.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append("bind-key -T ");
            if (key.startsWith(prefix)) {
                sb.append("prefix ");
                key = key.substring(prefix.length());
            } else {
                sb.append("root   ");
            }
            sb.append(KeyMap.display(key));
            while (sb.length() < 32) {
                sb.append(" ");
            }
            sb.append(val);
            return sb.toString();
        }).sorted();
        Objects.requireNonNull(out);
        sorted.forEach(this::println);
    }

    protected void sendKeys(PrintStream out, PrintStream err, List<String> args) throws Exception {
        Options opt = Options.compile(new String[]{"send-keys - ", "Usage: send-keys [-lXRM] [-N repeat-count] [-t target-pane] key...", "  -? --help                    Show help", "  -l --literal                Send key literally", "  -N --number=repeat-count     Specifies a repeat count"}).parse(args);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        }
        int n = opt.getNumber("number");
        for (int i = 0; i < n; i++) {
            for (String arg : opt.args()) {
                active().getMasterInputOutput().write((opt.isSet("literal") ? arg : KeyMap.translate(arg)).getBytes());
            }
        }
    }

    protected void clockMode(PrintStream out, PrintStream err, List<String> args) throws Exception {
        Options opt = Options.compile(new String[]{"clock-mode - ", "Usage: clock-mode", "  -? --help                    Show help"}).parse(args);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        }
        active().clock = true;
        if (this.clockFuture == null) {
            this.clockFuture = this.executor.scheduleWithFixedDelay(this::setDirty, Instant.now().until(Instant.now().truncatedTo(ChronoUnit.MINUTES).plusSeconds(60), ChronoUnit.MILLIS), TimeUnit.MILLISECONDS.convert(1, TimeUnit.SECONDS), TimeUnit.MILLISECONDS);
        }
        setDirty();
    }

    protected void displayPanes(PrintStream out, PrintStream err, List<String> args) throws Exception {
        Options opt = Options.compile(new String[]{"display-panes - ", "Usage: display-panes", "  -? --help                    Show help"}).parse(args);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        }
        this.identify = true;
        setDirty();
        this.executor.schedule(() -> {
            this.identify = false;
            setDirty();
        }, 1, TimeUnit.SECONDS);
    }

    protected void resizePane(PrintStream out, PrintStream err, List<String> args) throws Exception {
        int adjust;
        Options opt = Options.compile(new String[]{"resize-pane - ", "Usage: resize-pane [-UDLR] [-x width] [-y height] [-t target-pane] [adjustment]", "  -? --help                    Show help", "  -U                           Resize pane upward", "  -D                           Select pane downward", "  -L                           Select pane to the left", "  -R                           Select pane to the right", "  -x --width=width             Set the width of the pane", "  -y --height=height           Set the height of the pane"}).parse(args);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        }
        if (opt.args().size() == 0) {
            adjust = 1;
        } else if (opt.args().size() == 1) {
            adjust = Integer.parseInt(opt.args().get(0));
        } else {
            throw new Options.HelpException(opt.usage());
        }
        window().resizePane(opt, adjust);
        setDirty();
    }

    protected void selectPane(PrintStream out, PrintStream err, List<String> args) throws Exception {
        Options opt = Options.compile(new String[]{"select-pane - ", "Usage: select-pane [-UDLR] [-t target-pane]", "  -? --help                    Show help", "  -U                           Select pane up", "  -D                           Select pane down", "  -L                           Select pane left", "  -R                           Select pane right"}).parse(args);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        } else if (window().selectPane(opt)) {
            setDirty();
        }
    }

    protected void sendPrefix(PrintStream out, PrintStream err, List<String> args) throws Exception {
        Options opt = Options.compile(new String[]{"send-prefix - ", "Usage: send-prefix [-2] [-t target-pane]", "  -? --help                    Show help"}).parse(args);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        }
        active().getMasterInputOutput().write(this.serverOptions.get(OPT_PREFIX).getBytes());
    }

    protected void splitWindow(PrintStream out, PrintStream err, List<String> args) throws Exception {
        Options opt = Options.compile(new String[]{"split-window - ", "Usage: split-window [-bdfhvP] [-c start-directory] [-F format] [-p percentage|-l size] [-t target-pane] [command]", "  -? --help                    Show help", "  -h --horizontal              Horizontal split", "  -v --vertical                Vertical split", "  -l --size=size               Size", "  -p --perc=percentage         Percentage", "  -b --before                  Insert the new pane before the active one", "  -f                           Split the full window instead of the active pane", "  -d                           Do not make the new pane the active one"}).parse(args);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        }
        this.runner.accept(window().splitPane(opt).getConsole());
        setDirty();
    }

    protected void layoutResize() {
    }

    protected synchronized void redraw() {
        long[] screen = new long[this.size.getRows() * this.size.getColumns()];
        Arrays.fill(screen, 32L);
        int[] cursor = new int[2];
        Iterator<VirtualConsole> it = panes().iterator();
        while (it.hasNext()) {
            VirtualConsole terminal = it.next();
            if (terminal.clock) {
                print(screen, terminal, DateFormat.getTimeInstance(3).format(new Date()), this.CLOCK_COLOR);
            } else {
                terminal.dump(screen, terminal.top(), terminal.left(), this.size.getRows(), this.size.getColumns(), terminal == active() ? cursor : null);
            }
            if (this.identify) {
                print(screen, terminal, Integer.toString(terminal.f3208id), terminal == active() ? this.ACTIVE_COLOR : this.INACTIVE_COLOR);
            }
            drawBorder(screen, this.size, terminal, 0);
        }
        drawBorder(screen, this.size, active(), 1155173304420532224L);
        Arrays.fill(screen, (this.size.getRows() - 1) * this.size.getColumns(), this.size.getRows() * this.size.getColumns(), 2305843558969507872L);
        List<AttributedString> lines = new ArrayList<>();
        int prevBg = 0;
        int prevFg = 0;
        boolean prevInv = false;
        boolean prevUl = false;
        boolean prevBold = false;
        boolean prevConceal = false;
        boolean prevHasFg = false;
        boolean prevHasBg = false;
        for (int y = 0; y < this.size.getRows(); y++) {
            AttributedStringBuilder sb = new AttributedStringBuilder(this.size.getColumns());
            for (int x = 0; x < this.size.getColumns(); x++) {
                long d = screen[(y * this.size.getColumns()) + x];
                int c = (int) (d & 4294967295L);
                int a = (int) (d >> 32);
                int bg = a & PacketOpcodes.TakeFirstShareRewardRsp;
                int fg = (a & 16773120) >> 12;
                boolean ul = (a & 16777216) != 0;
                boolean inv = (a & 33554432) != 0;
                boolean conceal = (a & 67108864) != 0;
                boolean bold = (a & 134217728) != 0;
                boolean hasFg = (a & 268435456) != 0;
                boolean hasBg = (a & 536870912) != 0;
                if ((hasBg && prevHasBg && bg != prevBg) || prevHasBg != hasBg) {
                    if (!hasBg) {
                        sb.style(sb.style().backgroundDefault());
                    } else {
                        sb.style(sb.style().background(Colors.roundRgbColor((bg & 3840) >> 4, bg & PacketOpcodes.ExecuteGadgetLuaRsp, (bg & 15) << 4, 256)));
                    }
                    prevBg = bg;
                    prevHasBg = hasBg;
                }
                if ((hasFg && prevHasFg && fg != prevFg) || prevHasFg != hasFg) {
                    if (!hasFg) {
                        sb.style(sb.style().foregroundDefault());
                    } else {
                        sb.style(sb.style().foreground(Colors.roundRgbColor((fg & 3840) >> 4, fg & PacketOpcodes.ExecuteGadgetLuaRsp, (fg & 15) << 4, 256)));
                    }
                    prevFg = fg;
                    prevHasFg = hasFg;
                }
                if (conceal != prevConceal) {
                    sb.style(conceal ? sb.style().conceal() : sb.style().concealOff());
                    prevConceal = conceal;
                }
                if (inv != prevInv) {
                    sb.style(inv ? sb.style().inverse() : sb.style().inverseOff());
                    prevInv = inv;
                }
                if (ul != prevUl) {
                    sb.style(ul ? sb.style().underline() : sb.style().underlineOff());
                    prevUl = ul;
                }
                if (bold != prevBold) {
                    sb.style(bold ? sb.style().bold() : sb.style().boldOff());
                    prevBold = bold;
                }
                sb.append((char) c);
            }
            lines.add(sb.toAttributedString());
        }
        this.display.resize(this.size.getRows(), this.size.getColumns());
        this.display.update(lines, this.size.cursorPos(cursor[1], cursor[0]));
    }

    private void print(long[] screen, VirtualConsole terminal, String id, int color) {
        int idx;
        if (terminal.height() > 5) {
            long attr = (((long) color) << 32) | 2305843009213693952L;
            int yoff = (terminal.height() - 5) / 2;
            int xoff = (terminal.width() - (id.length() * 6)) / 2;
            for (int i = 0; i < id.length(); i++) {
                char ch = id.charAt(i);
                switch (ch) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        idx = ch - '0';
                        break;
                    case ':':
                        idx = 10;
                        break;
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                    case '?':
                    case '@':
                    case 'B':
                    case 'C':
                    case 'D':
                    case 'E':
                    case 'F':
                    case 'G':
                    case 'H':
                    case 'I':
                    case 'J':
                    case 'K':
                    case 'L':
                    case 'N':
                    case 'O':
                    default:
                        idx = -1;
                        break;
                    case 'A':
                        idx = 11;
                        break;
                    case 'M':
                        idx = 13;
                        break;
                    case 'P':
                        idx = 12;
                        break;
                }
                if (idx >= 0) {
                    int[][] data = WINDOW_CLOCK_TABLE[idx];
                    for (int y = 0; y < data.length; y++) {
                        for (int x = 0; x < data[y].length; x++) {
                            if (data[y][x] != 0) {
                                screen[((terminal.top + yoff + y) * this.size.getColumns()) + terminal.left() + xoff + x + (6 * i)] = attr | 32;
                            }
                        }
                    }
                }
            }
            return;
        }
        long attr2 = (((long) color) << 44) | 1152921504606846976L;
        int off = ((terminal.top + ((terminal.height() + 1) / 2)) * this.size.getColumns()) + terminal.left() + ((terminal.width() - id.length()) / 2);
        for (int i2 = 0; i2 < id.length(); i2++) {
            screen[off + i2] = attr2 | ((long) id.charAt(i2));
        }
    }

    private void drawBorder(long[] screen, Size size, VirtualConsole terminal, long attr) {
        for (int i = terminal.left(); i < terminal.right(); i++) {
            int y0 = terminal.top() - 1;
            int y1 = terminal.bottom();
            drawBorderChar(screen, size, i, y0, attr, 9472);
            drawBorderChar(screen, size, i, y1, attr, 9472);
        }
        for (int i2 = terminal.top(); i2 < terminal.bottom(); i2++) {
            int x0 = terminal.left() - 1;
            int x1 = terminal.right();
            drawBorderChar(screen, size, x0, i2, attr, 9474);
            drawBorderChar(screen, size, x1, i2, attr, 9474);
        }
        drawBorderChar(screen, size, terminal.left() - 1, terminal.top() - 1, attr, 9484);
        drawBorderChar(screen, size, terminal.right(), terminal.top() - 1, attr, 9488);
        drawBorderChar(screen, size, terminal.left() - 1, terminal.bottom(), attr, 9492);
        drawBorderChar(screen, size, terminal.right(), terminal.bottom(), attr, 9496);
    }

    private void drawBorderChar(long[] screen, Size size, int x, int y, long attr, int c) {
        if (x >= 0 && x < size.getColumns() && y >= 0 && y < size.getRows() - 1) {
            screen[(y * size.getColumns()) + x] = attr | ((long) addBorder(c, (int) (screen[(y * size.getColumns()) + x] & 4294967295L)));
        }
    }

    private int addBorder(int c, int oldc) {
        if (oldc == 32) {
            return c;
        }
        if (oldc == 9532) {
            return 9532;
        }
        switch (c) {
            case 9472:
                return addBorder(9588, addBorder(9590, oldc));
            case 9474:
                return addBorder(9591, addBorder(9589, oldc));
            case 9484:
                return addBorder(9590, addBorder(9591, oldc));
            case 9488:
                return addBorder(9588, addBorder(9591, oldc));
            case 9492:
                return addBorder(9590, addBorder(9589, oldc));
            case 9496:
                return addBorder(9588, addBorder(9589, oldc));
            case 9500:
                return addBorder(9590, addBorder(9474, oldc));
            case 9508:
                return addBorder(9588, addBorder(9474, oldc));
            case 9516:
                return addBorder(9591, addBorder(9472, oldc));
            case 9524:
                return addBorder(9589, addBorder(9472, oldc));
            case 9588:
                switch (oldc) {
                    case 9472:
                        return 9472;
                    case 9474:
                        return 9508;
                    case 9484:
                        return 9516;
                    case 9488:
                        return 9488;
                    case 9492:
                        return 9524;
                    case 9496:
                        return 9496;
                    case 9500:
                        return 9532;
                    case 9508:
                        return 9508;
                    case 9516:
                        return 9516;
                    case 9524:
                        return 9524;
                    default:
                        throw new IllegalArgumentException();
                }
            case 9589:
                switch (oldc) {
                    case 9472:
                        return 9524;
                    case 9474:
                        return 9474;
                    case 9484:
                        return 9500;
                    case 9488:
                        return 9508;
                    case 9492:
                        return 9492;
                    case 9496:
                        return 9496;
                    case 9500:
                        return 9500;
                    case 9508:
                        return 9508;
                    case 9516:
                        return 9532;
                    case 9524:
                        return 9524;
                    default:
                        throw new IllegalArgumentException();
                }
            case 9590:
                switch (oldc) {
                    case 9472:
                        return 9472;
                    case 9474:
                        return 9500;
                    case 9484:
                        return 9484;
                    case 9488:
                        return 9516;
                    case 9492:
                        return 9492;
                    case 9496:
                        return 9524;
                    case 9500:
                        return 9500;
                    case 9508:
                        return 9532;
                    case 9516:
                        return 9516;
                    case 9524:
                        return 9524;
                    default:
                        throw new IllegalArgumentException();
                }
            case 9591:
                switch (oldc) {
                    case 9472:
                        return 9516;
                    case 9474:
                        return 9474;
                    case 9484:
                        return 9484;
                    case 9488:
                        return 9488;
                    case 9492:
                        return 9500;
                    case 9496:
                        return 9508;
                    case 9500:
                        return 9500;
                    case 9508:
                        return 9508;
                    case 9516:
                        return 9516;
                    case 9524:
                        return 9532;
                    default:
                        throw new IllegalArgumentException();
                }
            default:
                throw new IllegalArgumentException();
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/jline/builtins/Tmux$Layout.class */
    public static class Layout {
        static final Pattern PATTERN = Pattern.compile("([0-9]+)x([0-9]+),([0-9]+),([0-9]+)([^0-9]\\S*)?");
        private static final int PANE_MINIMUM = 3;
        Type type;
        Layout parent;

        /* renamed from: sx */
        int f3206sx;

        /* renamed from: sy */
        int f3207sy;
        int xoff;
        int yoff;
        List<Layout> cells = new CopyOnWriteArrayList();

        /* access modifiers changed from: package-private */
        /* loaded from: grasscutter.jar:org/jline/builtins/Tmux$Layout$Type.class */
        public enum Type {
            LeftRight,
            TopBottom,
            WindowPane
        }

        Layout() {
        }

        public static Layout parse(String layout) {
            if (layout.length() < 6) {
                throw new IllegalArgumentException("Bad syntax");
            }
            String chk = layout.substring(0, 4);
            if (layout.charAt(4) != ',') {
                throw new IllegalArgumentException("Bad syntax");
            }
            String layout2 = layout.substring(5);
            if (Integer.parseInt(chk, 16) == checksum(layout2)) {
                return parseCell(null, layout2);
            }
            throw new IllegalArgumentException("Bad checksum");
        }

        public String dump() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("0000,");
            doDump(sb);
            int chk = checksum(sb, 5);
            sb.setCharAt(0, toHexChar((chk >> 12) & 15));
            sb.setCharAt(1, toHexChar((chk >> 8) & 15));
            sb.setCharAt(2, toHexChar((chk >> 4) & 15));
            sb.setCharAt(3, toHexChar(chk & 15));
            return sb.toString();
        }

        private static char toHexChar(int i) {
            return i < 10 ? (char) (i + 48) : (char) ((i - 10) + 97);
        }

        private void doDump(StringBuilder sb) {
            sb.append(this.f3206sx).append('x').append(this.f3207sy).append(',').append(this.xoff).append(',').append(this.yoff);
            switch (this.type) {
                case WindowPane:
                    sb.append(',').append('0');
                    return;
                case TopBottom:
                case LeftRight:
                    sb.append(this.type == Type.TopBottom ? '[' : '{');
                    boolean first = true;
                    for (Layout c : this.cells) {
                        if (first) {
                            first = false;
                        } else {
                            sb.append(',');
                        }
                        c.doDump(sb);
                    }
                    sb.append(this.type == Type.TopBottom ? ']' : '}');
                    return;
                default:
                    return;
            }
        }

        public void resize(Type type, int change, boolean opposite) {
            int size;
            Layout lc = this;
            Layout lcparent = lc.parent;
            while (lcparent != null && lcparent.type != type) {
                lc = lcparent;
                lcparent = lc.parent;
            }
            if (lcparent != null) {
                if (lc.nextSibling() == null) {
                    lc = lc.prevSibling();
                }
                int needed = change;
                while (needed != 0) {
                    if (change > 0) {
                        size = lc.resizePaneGrow(type, needed, opposite);
                        needed -= size;
                    } else {
                        size = lc.resizePaneShrink(type, needed);
                        needed += size;
                    }
                    if (size == 0) {
                        break;
                    }
                }
                fixOffsets();
                fixPanes();
            }
        }

        int resizePaneGrow(Type type, int needed, boolean opposite) {
            int size = 0;
            Layout lcremove = nextSibling();
            while (lcremove != null) {
                size = lcremove.resizeCheck(type);
                if (size > 0) {
                    break;
                }
                lcremove = lcremove.nextSibling();
            }
            if (opposite && lcremove == null) {
                lcremove = prevSibling();
                while (lcremove != null) {
                    size = lcremove.resizeCheck(type);
                    if (size > 0) {
                        break;
                    }
                    lcremove = lcremove.prevSibling();
                }
            }
            if (lcremove == null) {
                return 0;
            }
            if (size > needed) {
                size = needed;
            }
            resizeAdjust(type, size);
            lcremove.resizeAdjust(type, -size);
            return size;
        }

        int resizePaneShrink(Type type, int needed) {
            int size;
            Layout lcadd;
            Layout lcremove = this;
            do {
                size = lcremove.resizeCheck(type);
                if (size > 0) {
                    break;
                }
                lcremove = lcremove.prevSibling();
            } while (lcremove != null);
            if (lcremove == null || (lcadd = nextSibling()) == null) {
                return 0;
            }
            if (size > (-needed)) {
                size = -needed;
            }
            lcadd.resizeAdjust(type, size);
            lcremove.resizeAdjust(type, -size);
            return size;
        }

        Layout prevSibling() {
            int idx = this.parent.cells.indexOf(this);
            if (idx > 0) {
                return this.parent.cells.get(idx - 1);
            }
            return null;
        }

        Layout nextSibling() {
            int idx = this.parent.cells.indexOf(this);
            if (idx < this.parent.cells.size() - 1) {
                return this.parent.cells.get(idx + 1);
            }
            return null;
        }

        public void resizeTo(Type type, int new_size) {
            Layout lc = this;
            Layout lcparent = lc.parent;
            while (lcparent != null && lcparent.type != type) {
                lc = lcparent;
                lcparent = lc.parent;
            }
            if (lcparent != null) {
                int size = type == Type.LeftRight ? lc.f3206sx : lc.f3207sy;
                lc.resize(type, lc.nextSibling() == null ? size - new_size : new_size - size, true);
            }
        }

        public void resize(int sx, int sy) {
            int xchange = sx - this.f3206sx;
            int xlimit = resizeCheck(Type.LeftRight);
            if (xchange < 0 && xchange < (-xlimit)) {
                xchange = -xlimit;
            }
            if (xlimit == 0) {
                if (sx <= this.f3206sx) {
                    xchange = 0;
                } else {
                    xchange = sx - this.f3206sx;
                }
            }
            if (xchange != 0) {
                resizeAdjust(Type.LeftRight, xchange);
            }
            int ychange = sy - this.f3207sy;
            int ylimit = resizeCheck(Type.TopBottom);
            if (ychange < 0 && ychange < (-ylimit)) {
                ychange = -ylimit;
            }
            if (ylimit == 0) {
                if (sy <= this.f3207sy) {
                    ychange = 0;
                } else {
                    ychange = sy - this.f3207sy;
                }
            }
            if (ychange != 0) {
                resizeAdjust(Type.TopBottom, ychange);
            }
            fixOffsets();
            fixPanes(sx, sy);
        }

        public void remove() {
            if (this.parent == null) {
                throw new IllegalStateException();
            }
            int idx = this.parent.cells.indexOf(this);
            Layout other = this.parent.cells.get(idx == 0 ? 1 : idx - 1);
            other.resizeAdjust(this.parent.type, this.parent.type == Type.LeftRight ? this.f3206sx + 1 : this.f3207sy + 1);
            this.parent.cells.remove(this);
            if (other.parent.cells.size() != 1) {
                return;
            }
            if (other.parent.parent == null) {
                other.parent = null;
                return;
            }
            other.parent.parent.cells.set(other.parent.parent.cells.indexOf(other.parent), other);
            other.parent = other.parent.parent;
        }

        private int resizeCheck(Type type) {
            int avail;
            int avail2;
            if (this.type == Type.WindowPane) {
                int min = 3;
                if (type == Type.LeftRight) {
                    avail = this.f3206sx;
                } else {
                    avail = this.f3207sy;
                    min = 3 + 1;
                }
                if (avail > min) {
                    avail2 = avail - min;
                } else {
                    avail2 = 0;
                }
                return avail2;
            } else if (this.type == type) {
                return this.cells.stream().mapToInt(c -> {
                    if (c != null) {
                        return c.resizeCheck(type);
                    }
                    return 0;
                }).sum();
            } else {
                return this.cells.stream().mapToInt(c -> {
                    if (c != null) {
                        return c.resizeCheck(type);
                    }
                    return Integer.MAX_VALUE;
                }).min().orElse(Integer.MAX_VALUE);
            }
        }

        private void resizeAdjust(Type type, int change) {
            if (type == Type.LeftRight) {
                this.f3206sx += change;
            } else {
                this.f3207sy += change;
            }
            if (this.type != Type.WindowPane) {
                if (this.type != type) {
                    for (Layout c : this.cells) {
                        c.resizeAdjust(type, change);
                    }
                    return;
                }
                while (change != 0) {
                    for (Layout c2 : this.cells) {
                        if (change == 0) {
                            break;
                        } else if (change > 0) {
                            c2.resizeAdjust(type, 1);
                            change--;
                        } else if (c2.resizeCheck(type) > 0) {
                            c2.resizeAdjust(type, -1);
                            change++;
                        }
                    }
                }
            }
        }

        public void fixOffsets() {
            if (this.type == Type.LeftRight) {
                int xoff = this.xoff;
                for (Layout cell : this.cells) {
                    cell.xoff = xoff;
                    cell.yoff = this.yoff;
                    cell.fixOffsets();
                    xoff += cell.f3206sx + 1;
                }
            } else if (this.type == Type.TopBottom) {
                int yoff = this.yoff;
                for (Layout cell2 : this.cells) {
                    cell2.xoff = this.xoff;
                    cell2.yoff = yoff;
                    cell2.fixOffsets();
                    yoff += cell2.f3207sy + 1;
                }
            }
        }

        public void fixPanes() {
        }

        public void fixPanes(int sx, int sy) {
        }

        public int countCells() {
            switch (this.type) {
                case TopBottom:
                case LeftRight:
                    return this.cells.stream().mapToInt((v0) -> {
                        return v0.countCells();
                    }).sum();
                default:
                    return 1;
            }
        }

        public Layout split(Type type, int size, boolean insertBefore) {
            Layout cell2;
            Layout cell1;
            if (type == Type.WindowPane) {
                throw new IllegalStateException();
            }
            if ((type == Type.LeftRight ? this.f3206sx : this.f3207sy) < 7) {
                return null;
            }
            if (this.parent == null) {
                throw new IllegalStateException();
            }
            int saved_size = type == Type.LeftRight ? this.f3206sx : this.f3207sy;
            int size2 = size < 0 ? ((saved_size + 1) / 2) - 1 : insertBefore ? (saved_size - size) - 1 : size;
            if (size2 < 3) {
                size2 = 3;
            } else if (size2 > saved_size - 2) {
                size2 = saved_size - 2;
            }
            int size1 = (saved_size - 1) - size2;
            if (this.parent.type != type) {
                Layout p = new Layout();
                p.type = type;
                p.parent = this.parent;
                p.f3206sx = this.f3206sx;
                p.f3207sy = this.f3207sy;
                p.xoff = this.xoff;
                p.yoff = this.yoff;
                this.parent.cells.set(this.parent.cells.indexOf(this), p);
                p.cells.add(this);
                this.parent = p;
            }
            Layout cell = new Layout();
            cell.type = Type.WindowPane;
            cell.parent = this.parent;
            this.parent.cells.add(this.parent.cells.indexOf(this) + (insertBefore ? 0 : 1), cell);
            int sx = this.f3206sx;
            int sy = this.f3207sy;
            int xoff = this.xoff;
            int yoff = this.yoff;
            if (insertBefore) {
                cell1 = cell;
                cell2 = this;
            } else {
                cell1 = this;
                cell2 = cell;
            }
            if (type == Type.LeftRight) {
                cell1.setSize(size1, sy, xoff, yoff);
                cell2.setSize(size2, sy, xoff + size1 + 1, yoff);
            } else {
                cell1.setSize(sx, size1, xoff, yoff);
                cell2.setSize(sx, size2, xoff, yoff + size1 + 1);
            }
            return cell;
        }

        private void setSize(int sx, int sy, int xoff, int yoff) {
            this.f3206sx = sx;
            this.f3207sy = sy;
            this.xoff = xoff;
            this.yoff = yoff;
        }

        private static int checksum(CharSequence layout) {
            return checksum(layout, 0);
        }

        private static int checksum(CharSequence layout, int start) {
            int csum = 0;
            for (int i = start; i < layout.length(); i++) {
                csum = (csum >> 1) + ((csum & 1) << 15) + layout.charAt(i);
            }
            return csum;
        }

        private static Layout parseCell(Layout parent, String layout) {
            Matcher matcher = PATTERN.matcher(layout);
            if (matcher.matches()) {
                Layout cell = new Layout();
                cell.type = Type.WindowPane;
                cell.parent = parent;
                cell.f3206sx = Integer.parseInt(matcher.group(1));
                cell.f3207sy = Integer.parseInt(matcher.group(2));
                cell.xoff = Integer.parseInt(matcher.group(3));
                cell.yoff = Integer.parseInt(matcher.group(4));
                if (parent != null) {
                    parent.cells.add(cell);
                }
                String layout2 = matcher.group(5);
                if (layout2 == null || layout2.isEmpty()) {
                    return cell;
                }
                if (layout2.charAt(0) == ',') {
                    int i = 1;
                    while (i < layout2.length() && Character.isDigit(layout2.charAt(i))) {
                        i++;
                    }
                    if (i == layout2.length()) {
                        return cell;
                    }
                    if (layout2.charAt(i) == ',') {
                        layout2 = layout2.substring(i);
                    }
                }
                switch (layout2.charAt(0)) {
                    case ',':
                        parseCell(parent, layout2.substring(1));
                        return cell;
                    case '[':
                        cell.type = Type.TopBottom;
                        int i2 = Tmux.findMatch(layout2, '[', ']');
                        parseCell(cell, layout2.substring(1, i2));
                        String layout3 = layout2.substring(i2 + 1);
                        if (!layout3.isEmpty() && layout3.charAt(0) == ',') {
                            parseCell(parent, layout3.substring(1));
                        }
                        return cell;
                    case '{':
                        cell.type = Type.LeftRight;
                        int i3 = Tmux.findMatch(layout2, '{', '}');
                        parseCell(cell, layout2.substring(1, i3));
                        String layout4 = layout2.substring(i3 + 1);
                        if (!layout4.isEmpty() && layout4.charAt(0) == ',') {
                            parseCell(parent, layout4.substring(1));
                        }
                        return cell;
                    default:
                        throw new IllegalArgumentException("Unexpected '" + layout2.charAt(0) + "'");
                }
            } else {
                throw new IllegalArgumentException("Bad syntax");
            }
        }
    }

    /* access modifiers changed from: private */
    public static int findMatch(String layout, char c0, char c1) {
        if (layout.charAt(0) != c0) {
            throw new IllegalArgumentException();
        }
        int nb = 0;
        int i = 0;
        while (i < layout.length()) {
            char c = layout.charAt(i);
            if (c == c0) {
                nb++;
            } else if (c == c1) {
                nb--;
                if (nb == 0) {
                    return i;
                }
            } else {
                continue;
            }
            i++;
        }
        if (nb <= 0) {
            return i;
        }
        throw new IllegalArgumentException("No matching '" + c1 + "'");
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/builtins/Tmux$VirtualConsole.class */
    public static class VirtualConsole implements Closeable {
        private final ScreenTerminal terminal;
        private final Consumer<VirtualConsole> closer;

        /* renamed from: id */
        private final int f3208id;
        private int left;
        private int top;
        private final Layout layout;
        private int active;
        private boolean clock;
        private final OutputStream masterOutput = new MasterOutputStream();
        private final OutputStream masterInputOutput = new OutputStream() { // from class: org.jline.builtins.Tmux.VirtualConsole.2
            @Override // java.io.OutputStream
            public void write(int b) throws IOException {
                VirtualConsole.this.console.processInputByte(b);
            }
        };
        private final LineDisciplineTerminal console;

        public VirtualConsole(int id, String type, int left, int top, int columns, int rows, final Runnable dirty, final Consumer<VirtualConsole> closer, Layout layout) throws IOException {
            String name = String.format("tmux%02d", Integer.valueOf(id));
            this.f3208id = id;
            this.left = left;
            this.top = top;
            this.closer = closer;
            this.terminal = new ScreenTerminal(columns, rows) { // from class: org.jline.builtins.Tmux.VirtualConsole.1
                /* access modifiers changed from: protected */
                @Override // org.jline.builtins.ScreenTerminal
                public void setDirty() {
                    setDirty();
                    dirty.run();
                }
            };
            this.console = new LineDisciplineTerminal(name, type, this.masterOutput, null) { // from class: org.jline.builtins.Tmux.VirtualConsole.3
                /* access modifiers changed from: protected */
                @Override // org.jline.terminal.impl.LineDisciplineTerminal, org.jline.terminal.impl.AbstractTerminal
                public void doClose() throws IOException {
                    doClose();
                    closer.accept(VirtualConsole.this);
                }
            };
            this.console.setSize(new Size(columns, rows));
            this.layout = layout;
        }

        Layout layout() {
            return this.layout;
        }

        public int left() {
            return this.left;
        }

        public int top() {
            return this.top;
        }

        public int right() {
            return left() + width();
        }

        public int bottom() {
            return top() + height();
        }

        public int width() {
            return this.console.getWidth();
        }

        public int height() {
            return this.console.getHeight();
        }

        public LineDisciplineTerminal getConsole() {
            return this.console;
        }

        public OutputStream getMasterInputOutput() {
            return this.masterInputOutput;
        }

        public void resize(int left, int top, int width, int height) {
            this.left = left;
            this.top = top;
            this.console.setSize(new Size(width, height));
            this.terminal.setSize(width, height);
            this.console.raise(Terminal.Signal.WINCH);
        }

        public void dump(long[] fullscreen, int ftop, int fleft, int fheight, int fwidth, int[] cursor) {
            this.terminal.dump(fullscreen, ftop, fleft, fheight, fwidth, cursor);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.console.close();
        }

        /* loaded from: grasscutter.jar:org/jline/builtins/Tmux$VirtualConsole$MasterOutputStream.class */
        private class MasterOutputStream extends OutputStream {
            private final ByteArrayOutputStream buffer;
            private final CharsetDecoder decoder;

            private MasterOutputStream() {
                this.buffer = new ByteArrayOutputStream();
                this.decoder = Charset.defaultCharset().newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
            }

            @Override // java.io.OutputStream
            public synchronized void write(int b) {
                this.buffer.write(b);
            }

            @Override // java.io.OutputStream
            public void write(byte[] b, int off, int len) throws IOException {
                this.buffer.write(b, off, len);
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public synchronized void flush() throws IOException {
                CharBuffer out;
                ByteBuffer in;
                int size = this.buffer.size();
                if (size > 0) {
                    while (true) {
                        out = CharBuffer.allocate(size);
                        in = ByteBuffer.wrap(this.buffer.toByteArray());
                        if (!this.decoder.decode(in, out, false).isOverflow()) {
                            break;
                        }
                        size *= 2;
                    }
                    this.buffer.reset();
                    this.buffer.write(in.array(), in.arrayOffset(), in.remaining());
                    if (out.position() > 0) {
                        out.flip();
                        VirtualConsole.this.terminal.write(out);
                        VirtualConsole.this.masterInputOutput.write(VirtualConsole.this.terminal.read().getBytes());
                    }
                }
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                flush();
            }
        }
    }
}
