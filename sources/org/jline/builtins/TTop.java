package org.jline.builtins;

import dev.morphia.mapping.codec.reader.NameState;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import org.jline.builtins.Options;
import org.jline.keymap.BindingReader;
import org.jline.keymap.KeyMap;
import org.jline.terminal.Attributes;
import org.jline.terminal.Size;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.Display;
import org.jline.utils.InfoCmp;
import org.jline.utils.Log;
import org.quartz.impl.jdbcjobstore.Constants;
import org.slf4j.Marker;
import p001ch.qos.logback.core.rolling.helper.IntegerTokenConverter;

/* loaded from: grasscutter.jar:org/jline/builtins/TTop.class */
public class TTop {
    public static final String STAT_UPTIME = "uptime";
    public static final String STAT_TID = "tid";
    public static final String STAT_NAME = "name";
    public static final String STAT_STATE = "state";
    public static final String STAT_BLOCKED_TIME = "blocked_time";
    public static final String STAT_BLOCKED_COUNT = "blocked_count";
    public static final String STAT_WAITED_TIME = "waited_time";
    public static final String STAT_WAITED_COUNT = "waited_count";
    public static final String STAT_LOCK_NAME = "lock_name";
    public static final String STAT_LOCK_OWNER_ID = "lock_owner_id";
    public static final String STAT_LOCK_OWNER_NAME = "lock_owner_name";
    public static final String STAT_USER_TIME = "user_time";
    public static final String STAT_USER_TIME_PERC = "user_time_perc";
    public static final String STAT_CPU_TIME = "cpu_time";
    public static final String STAT_CPU_TIME_PERC = "cpu_time_perc";
    public List<String> sort;
    public long delay;
    public List<String> stats;
    public int nthreads;
    private final Terminal terminal;
    private final Display display;
    private final BindingReader bindingReader;
    private Comparator<Map<String, Comparable<?>>> comparator;
    private final Map<String, Column> columns = new LinkedHashMap();
    private final Size size = new Size();
    private Map<Long, Map<String, Object>> previous = new HashMap();
    private Map<Long, Map<String, Long>> changes = new HashMap();
    private Map<String, Integer> widths = new HashMap();
    private final KeyMap<Operation> keys = new KeyMap<>();

    /* loaded from: grasscutter.jar:org/jline/builtins/TTop$Align.class */
    public enum Align {
        Left,
        Right
    }

    /* loaded from: grasscutter.jar:org/jline/builtins/TTop$Operation.class */
    public enum Operation {
        INCREASE_DELAY,
        DECREASE_DELAY,
        HELP,
        EXIT,
        CLEAR,
        REVERSE
    }

    public static void ttop(Terminal terminal, PrintStream out, PrintStream err, String[] argv) throws Exception {
        Options opt = Options.compile(new String[]{"ttop -  display and update sorted information about threads", "Usage: ttop [OPTIONS]", "  -? --help                    Show help", "  -o --order=ORDER             Comma separated list of sorting keys", "  -t --stats=STATS             Comma separated list of stats to display", "  -s --seconds=SECONDS         Delay between updates in seconds", "  -m --millis=MILLIS           Delay between updates in milliseconds", "  -n --nthreads=NTHREADS       Only display up to NTHREADS threads"}).parse(argv);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        }
        TTop ttop = new TTop(terminal);
        ttop.sort = opt.isSet("order") ? Arrays.asList(opt.get("order").split(",")) : null;
        ttop.delay = opt.isSet("seconds") ? (long) (opt.getNumber("seconds") * 1000) : ttop.delay;
        ttop.delay = opt.isSet("millis") ? (long) opt.getNumber("millis") : ttop.delay;
        ttop.stats = opt.isSet("stats") ? Arrays.asList(opt.get("stats").split(",")) : null;
        ttop.nthreads = opt.isSet("nthreads") ? opt.getNumber("nthreads") : ttop.nthreads;
        ttop.run();
    }

    public TTop(Terminal terminal) {
        this.terminal = terminal;
        this.display = new Display(terminal, true);
        this.bindingReader = new BindingReader(terminal.reader());
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        DecimalFormat perc = new DecimalFormat("0.00%", dfs);
        register(STAT_TID, Align.Right, "TID", o -> {
            return String.format("%3d", (Long) o);
        });
        register("name", Align.Left, NameState.NAME, padcut(40));
        register(STAT_STATE, Align.Left, Constants.COL_ENTRY_STATE, o -> {
            return o.toString().toLowerCase();
        });
        register(STAT_BLOCKED_TIME, Align.Right, "T-BLOCKED", o -> {
            return millis(((Long) o).longValue());
        });
        register(STAT_BLOCKED_COUNT, Align.Right, "#-BLOCKED", (v0) -> {
            return v0.toString();
        });
        register(STAT_WAITED_TIME, Align.Right, "T-WAITED", o -> {
            return millis(((Long) o).longValue());
        });
        register(STAT_WAITED_COUNT, Align.Right, "#-WAITED", (v0) -> {
            return v0.toString();
        });
        register(STAT_LOCK_NAME, Align.Left, "LOCK-NAME", (v0) -> {
            return v0.toString();
        });
        register(STAT_LOCK_OWNER_ID, Align.Right, "LOCK-OWNER-ID", id -> {
            return ((Long) id).longValue() >= 0 ? id.toString() : "";
        });
        register(STAT_LOCK_OWNER_NAME, Align.Left, "LOCK-OWNER-NAME", name -> {
            return name != null ? name.toString() : "";
        });
        register(STAT_USER_TIME, Align.Right, "T-USR", o -> {
            return nanos(((Long) o).longValue());
        });
        register(STAT_CPU_TIME, Align.Right, "T-CPU", o -> {
            return nanos(((Long) o).longValue());
        });
        Align align = Align.Right;
        Objects.requireNonNull(perc);
        register(STAT_USER_TIME_PERC, align, "%-USR", this::format);
        Align align2 = Align.Right;
        Objects.requireNonNull(perc);
        register(STAT_CPU_TIME_PERC, align2, "%-CPU", this::format);
        bindKeys(this.keys);
    }

    public KeyMap<Operation> getKeys() {
        return this.keys;
    }

    /* JADX WARN: Type inference failed for: r0v111, types: [long] */
    /* JADX WARN: Type inference failed for: r0v159, types: [long] */
    /* JADX WARN: Type inference failed for: r0v161, types: [long] */
    public void run() throws IOException, InterruptedException {
        Terminal.SignalHandler prevHandler;
        Attributes attr;
        Operation op;
        this.comparator = buildComparator(this.sort);
        this.delay = this.delay > 0 ? Math.max(this.delay, 100L) : 1000;
        if (this.stats == null || this.stats.isEmpty()) {
            this.stats = new ArrayList(Arrays.asList(STAT_TID, "name", STAT_STATE, STAT_CPU_TIME, STAT_LOCK_OWNER_ID));
        }
        Boolean isThreadContentionMonitoringEnabled = null;
        ThreadMXBean threadsBean = ManagementFactory.getThreadMXBean();
        if (this.stats.contains(STAT_BLOCKED_TIME) || this.stats.contains(STAT_BLOCKED_COUNT) || this.stats.contains(STAT_WAITED_TIME) || this.stats.contains(STAT_WAITED_COUNT)) {
            if (threadsBean.isThreadContentionMonitoringSupported()) {
                isThreadContentionMonitoringEnabled = Boolean.valueOf(threadsBean.isThreadContentionMonitoringEnabled());
                if (!isThreadContentionMonitoringEnabled.booleanValue()) {
                    threadsBean.setThreadContentionMonitoringEnabled(true);
                }
            } else {
                this.stats.removeAll(Arrays.asList(STAT_BLOCKED_TIME, STAT_BLOCKED_COUNT, STAT_WAITED_TIME, STAT_WAITED_COUNT));
            }
        }
        Boolean isThreadCpuTimeEnabled = null;
        if (this.stats.contains(STAT_USER_TIME) || this.stats.contains(STAT_CPU_TIME)) {
            if (threadsBean.isThreadCpuTimeSupported()) {
                isThreadCpuTimeEnabled = Boolean.valueOf(threadsBean.isThreadCpuTimeEnabled());
                if (!isThreadCpuTimeEnabled.booleanValue()) {
                    threadsBean.setThreadCpuTimeEnabled(true);
                }
            } else {
                this.stats.removeAll(Arrays.asList(STAT_USER_TIME, STAT_CPU_TIME));
            }
        }
        try {
            this.size.copy(this.terminal.getSize());
            prevHandler = this.terminal.handle(Terminal.Signal.WINCH, this::handle);
            attr = this.terminal.enterRawMode();
            try {
                if (!this.terminal.puts(InfoCmp.Capability.enter_ca_mode, new Object[0])) {
                    this.terminal.puts(InfoCmp.Capability.clear_screen, new Object[0]);
                }
                this.terminal.puts(InfoCmp.Capability.keypad_xmit, new Object[0]);
                this.terminal.puts(InfoCmp.Capability.cursor_invisible, new Object[0]);
                this.terminal.writer().flush();
                char currentTimeMillis = System.currentTimeMillis();
                do {
                    display();
                    checkInterrupted();
                    op = null;
                    int ch = this.bindingReader.peekCharacter((((((System.currentTimeMillis() - currentTimeMillis) / this.delay) + 1) * this.delay) + currentTimeMillis) - System.currentTimeMillis());
                    if (ch == -1) {
                        op = Operation.EXIT;
                    } else if (ch != -2) {
                        op = (Operation) this.bindingReader.readBinding(this.keys, null, false);
                    }
                    if (op != null) {
                        switch (op) {
                            case INCREASE_DELAY:
                                this.delay *= 2;
                                currentTimeMillis = System.currentTimeMillis();
                                break;
                            case DECREASE_DELAY:
                                this.delay = Math.max(this.delay / 2, 16L);
                                currentTimeMillis = System.currentTimeMillis();
                                break;
                            case CLEAR:
                                this.display.clear();
                                break;
                            case REVERSE:
                                this.comparator = this.comparator.reversed();
                                break;
                        }
                    }
                } while (op != Operation.EXIT);
                this.terminal.setAttributes(attr);
                if (prevHandler != null) {
                    this.terminal.handle(Terminal.Signal.WINCH, prevHandler);
                }
                if (!this.terminal.puts(InfoCmp.Capability.exit_ca_mode, new Object[0])) {
                    this.terminal.puts(InfoCmp.Capability.clear_screen, new Object[0]);
                }
                this.terminal.puts(InfoCmp.Capability.keypad_local, new Object[0]);
                this.terminal.puts(InfoCmp.Capability.cursor_visible, new Object[0]);
                this.terminal.writer().flush();
                if (isThreadContentionMonitoringEnabled != null) {
                    threadsBean.setThreadContentionMonitoringEnabled(isThreadContentionMonitoringEnabled.booleanValue());
                }
                if (isThreadCpuTimeEnabled != null) {
                    threadsBean.setThreadCpuTimeEnabled(isThreadCpuTimeEnabled.booleanValue());
                }
            } catch (Error err) {
                Log.info("Error: ", err);
                this.terminal.setAttributes(attr);
                if (prevHandler != null) {
                    this.terminal.handle(Terminal.Signal.WINCH, prevHandler);
                }
                if (!this.terminal.puts(InfoCmp.Capability.exit_ca_mode, new Object[0])) {
                    this.terminal.puts(InfoCmp.Capability.clear_screen, new Object[0]);
                }
                this.terminal.puts(InfoCmp.Capability.keypad_local, new Object[0]);
                this.terminal.puts(InfoCmp.Capability.cursor_visible, new Object[0]);
                this.terminal.writer().flush();
                if (isThreadContentionMonitoringEnabled != null) {
                    threadsBean.setThreadContentionMonitoringEnabled(isThreadContentionMonitoringEnabled.booleanValue());
                }
                if (isThreadCpuTimeEnabled != null) {
                    threadsBean.setThreadCpuTimeEnabled(isThreadCpuTimeEnabled.booleanValue());
                }
            } catch (InterruptedException e) {
                this.terminal.setAttributes(attr);
                if (prevHandler != null) {
                    this.terminal.handle(Terminal.Signal.WINCH, prevHandler);
                }
                if (!this.terminal.puts(InfoCmp.Capability.exit_ca_mode, new Object[0])) {
                    this.terminal.puts(InfoCmp.Capability.clear_screen, new Object[0]);
                }
                this.terminal.puts(InfoCmp.Capability.keypad_local, new Object[0]);
                this.terminal.puts(InfoCmp.Capability.cursor_visible, new Object[0]);
                this.terminal.writer().flush();
                if (isThreadContentionMonitoringEnabled != null) {
                    threadsBean.setThreadContentionMonitoringEnabled(isThreadContentionMonitoringEnabled.booleanValue());
                }
                if (isThreadCpuTimeEnabled != null) {
                    threadsBean.setThreadCpuTimeEnabled(isThreadCpuTimeEnabled.booleanValue());
                }
            }
        } catch (Throwable th) {
            this.terminal.setAttributes(attr);
            if (prevHandler != null) {
                this.terminal.handle(Terminal.Signal.WINCH, prevHandler);
            }
            if (!this.terminal.puts(InfoCmp.Capability.exit_ca_mode, new Object[0])) {
                this.terminal.puts(InfoCmp.Capability.clear_screen, new Object[0]);
            }
            this.terminal.puts(InfoCmp.Capability.keypad_local, new Object[0]);
            this.terminal.puts(InfoCmp.Capability.cursor_visible, new Object[0]);
            this.terminal.writer().flush();
            if (isThreadContentionMonitoringEnabled != null) {
                threadsBean.setThreadContentionMonitoringEnabled(isThreadContentionMonitoringEnabled.booleanValue());
            }
            if (isThreadCpuTimeEnabled != null) {
                threadsBean.setThreadCpuTimeEnabled(isThreadCpuTimeEnabled.booleanValue());
            }
            throw th;
        }
    }

    private void handle(Terminal.Signal signal) {
        int prevw = this.size.getColumns();
        this.size.copy(this.terminal.getSize());
        try {
            if (this.size.getColumns() < prevw) {
                this.display.clear();
            }
            display();
        } catch (IOException e) {
        }
    }

    private List<Map<String, Comparable<?>>> infos() {
        long ctime = ManagementFactory.getRuntimeMXBean().getUptime();
        Long ptime = (Long) this.previous.computeIfAbsent(-1L, id -> {
            return new HashMap();
        }).put(STAT_UPTIME, Long.valueOf(ctime));
        long delta = ptime != null ? ctime - ptime.longValue() : 0;
        ThreadMXBean threadsBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] infos = threadsBean.dumpAllThreads(false, false);
        List<Map<String, Comparable<?>>> threads = new ArrayList<>();
        for (ThreadInfo ti : infos) {
            Map<String, Comparable<?>> t = new HashMap<>();
            t.put(STAT_TID, Long.valueOf(ti.getThreadId()));
            t.put("name", ti.getThreadName());
            t.put(STAT_STATE, ti.getThreadState());
            if (threadsBean.isThreadContentionMonitoringEnabled()) {
                t.put(STAT_BLOCKED_TIME, Long.valueOf(ti.getBlockedTime()));
                t.put(STAT_BLOCKED_COUNT, Long.valueOf(ti.getBlockedCount()));
                t.put(STAT_WAITED_TIME, Long.valueOf(ti.getWaitedTime()));
                t.put(STAT_WAITED_COUNT, Long.valueOf(ti.getWaitedCount()));
            }
            t.put(STAT_LOCK_NAME, ti.getLockName());
            t.put(STAT_LOCK_OWNER_ID, Long.valueOf(ti.getLockOwnerId()));
            t.put(STAT_LOCK_OWNER_NAME, ti.getLockOwnerName());
            if (threadsBean.isThreadCpuTimeSupported() && threadsBean.isThreadCpuTimeEnabled()) {
                long tid = ti.getThreadId();
                long t1 = threadsBean.getThreadCpuTime(tid);
                long t0 = ((Long) this.previous.computeIfAbsent(Long.valueOf(tid), id -> {
                    return new HashMap();
                }).getOrDefault(STAT_CPU_TIME, Long.valueOf(t1))).longValue();
                t.put(STAT_CPU_TIME, Long.valueOf(t1));
                t.put(STAT_CPU_TIME_PERC, Double.valueOf(delta != 0 ? ((double) (t1 - t0)) / (((double) delta) * 1000000.0d) : 0.0d));
                long t12 = threadsBean.getThreadUserTime(tid);
                long t02 = ((Long) this.previous.computeIfAbsent(Long.valueOf(tid), id -> {
                    return new HashMap();
                }).getOrDefault(STAT_USER_TIME, Long.valueOf(t12))).longValue();
                t.put(STAT_USER_TIME, Long.valueOf(t12));
                t.put(STAT_USER_TIME_PERC, Double.valueOf(delta != 0 ? ((double) (t12 - t02)) / (((double) delta) * 1000000.0d) : 0.0d));
            }
            threads.add(t);
        }
        return threads;
    }

    private void align(AttributedStringBuilder sb, String val, int width, Align align) {
        if (align == Align.Left) {
            sb.append((CharSequence) val);
            for (int i = 0; i < width - val.length(); i++) {
                sb.append(' ');
            }
            return;
        }
        for (int i2 = 0; i2 < width - val.length(); i2++) {
            sb.append(' ');
        }
        sb.append((CharSequence) val);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x02e3 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:83:0x0542 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r1v117. Raw type applied. Possible types: java.util.function.Function, java.util.function.Function<? super java.util.Map<java.lang.String, java.lang.Comparable<?>>, ? extends R> */
    /* JADX DEBUG: Type inference failed for r0v114. Raw type applied. Possible types: java.util.stream.Stream<R>, java.util.stream.Stream */
    /* JADX WARN: Type inference failed for: r0v0, types: [long] */
    /* JADX WARN: Type inference failed for: r35v0, types: [long] */
    /* JADX WARN: Type inference failed for: r35v2 */
    /* JADX WARN: Type inference failed for: r35v4 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void display() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1866
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.builtins.TTop.display():void");
    }

    private Comparator<Map<String, Comparable<?>>> buildComparator(List<String> sort) {
        boolean asc;
        String fkey;
        if (sort == null || sort.isEmpty()) {
            sort = Collections.singletonList(STAT_TID);
        }
        Comparator<Map<String, Comparable<?>>> comparator = null;
        for (String key : sort) {
            if (key.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                fkey = key.substring(1);
                asc = true;
            } else if (key.startsWith("-")) {
                fkey = key.substring(1);
                asc = false;
            } else {
                fkey = key;
                asc = true;
            }
            if (!this.columns.containsKey(fkey)) {
                throw new IllegalArgumentException("Unsupported sort key: " + fkey);
            }
            Comparator<Map<String, Comparable<?>>> comp = Comparator.comparing(m -> {
                return (Comparable) m.get(fkey);
            });
            if (asc) {
                comp = comp.reversed();
            }
            if (comparator != null) {
                comparator = comparator.thenComparing(comp);
            } else {
                comparator = comp;
            }
        }
        return comparator;
    }

    private void register(String name, Align align, String header, Function<Object, String> format) {
        this.columns.put(name, new Column(name, align, header, format));
    }

    private static String nanos(long nanos) {
        return millis(nanos / 1000000);
    }

    private static String millis(long millis) {
        long secs = millis / 1000;
        long millis2 = millis % 1000;
        long mins = secs / 60;
        long secs2 = secs % 60;
        long hours = mins / 60;
        long mins2 = mins % 60;
        if (hours > 0) {
            return String.format("%d:%02d:%02d.%03d", Long.valueOf(hours), Long.valueOf(mins2), Long.valueOf(secs2), Long.valueOf(millis2));
        }
        if (mins2 > 0) {
            return String.format("%d:%02d.%03d", Long.valueOf(mins2), Long.valueOf(secs2), Long.valueOf(millis2));
        }
        return String.format("%d.%03d", Long.valueOf(secs2), Long.valueOf(millis2));
    }

    private static Function<Object, String> padcut(int nb) {
        return o -> {
            return padcut(o.toString(), nb);
        };
    }

    private static String padcut(String str, int nb) {
        if (str.length() <= nb) {
            StringBuilder sb = new StringBuilder(nb);
            sb.append(str);
            while (sb.length() < nb) {
                sb.append(' ');
            }
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder(nb);
        sb2.append((CharSequence) str, 0, nb - 3);
        sb2.append("...");
        return sb2.toString();
    }

    private static String memory(long cur, long max) {
        if (max <= 0) {
            return humanReadableByteCount(cur, false);
        }
        String smax = humanReadableByteCount(max, false);
        String cmax = humanReadableByteCount(cur, false);
        StringBuilder sb = new StringBuilder((smax.length() * 2) + 3);
        for (int i = cmax.length(); i < smax.length(); i++) {
            sb.append(' ');
        }
        sb.append(cmax).append(" / ").append(smax);
        return sb.toString();
    }

    private static String humanReadableByteCount(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < 1024) {
            return bytes + " B";
        }
        int exp = (int) (Math.log((double) bytes) / Math.log(1024.0d));
        return String.format("%.1f %sB", Double.valueOf(((double) bytes) / Math.pow((double) unit, (double) exp)), (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : IntegerTokenConverter.CONVERTER_KEY));
    }

    private void checkInterrupted() throws InterruptedException {
        Thread.yield();
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException();
        }
    }

    private void bindKeys(KeyMap<Operation> map) {
        map.bind((KeyMap<Operation>) Operation.HELP, "h", "?");
        map.bind((KeyMap<Operation>) Operation.EXIT, "q", ":q", "Q", ":Q", "ZZ");
        map.bind((KeyMap<Operation>) Operation.INCREASE_DELAY, Marker.ANY_NON_NULL_MARKER);
        map.bind((KeyMap<Operation>) Operation.DECREASE_DELAY, "-");
        map.bind((KeyMap<Operation>) Operation.CLEAR, KeyMap.ctrl('L'));
        map.bind((KeyMap<Operation>) Operation.REVERSE, "r");
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/builtins/TTop$Column.class */
    public static class Column {
        final String name;
        final Align align;
        final String header;
        final Function<Object, String> format;

        Column(String name, Align align, String header, Function<Object, String> format) {
            this.name = name;
            this.align = align;
            this.header = header;
            this.format = format;
        }
    }
}
