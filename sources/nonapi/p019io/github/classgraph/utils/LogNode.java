package nonapi.p019io.github.classgraph.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import net.bytebuddy.ClassFileVersion;
import nonapi.p019io.github.classgraph.classpath.SystemJarFinder;
import p001ch.qos.logback.classic.net.SyslogAppender;
import p013io.github.classgraph.ClassGraph;

/* renamed from: nonapi.io.github.classgraph.utils.LogNode */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/utils/LogNode.class */
public final class LogNode {
    private final long timeStampNano;
    private final long timeStampMillis;
    private final String msg;
    private String stackTrace;
    private long elapsedTimeNanos;
    private LogNode parent;
    private final Map<String, LogNode> children;
    private final String sortKeyPrefix;
    private static boolean logInRealtime;
    private static final Logger log = Logger.getLogger(ClassGraph.class.getName());
    private static AtomicInteger sortKeyUniqueSuffix = new AtomicInteger(0);
    private static final SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZ", Locale.US);
    private static final DecimalFormat nanoFormatter = new DecimalFormat("0.000000");

    public static void logInRealtime(boolean logInRealtime2) {
        logInRealtime = logInRealtime2;
    }

    private LogNode(String sortKey, String msg, long elapsedTimeNanos, Throwable exception) {
        this.timeStampNano = System.nanoTime();
        this.timeStampMillis = System.currentTimeMillis();
        this.children = new ConcurrentSkipListMap();
        this.sortKeyPrefix = sortKey;
        this.msg = msg;
        this.elapsedTimeNanos = elapsedTimeNanos;
        if (exception != null) {
            StringWriter writer = new StringWriter();
            exception.printStackTrace(new PrintWriter(writer));
            this.stackTrace = writer.toString();
        } else {
            this.stackTrace = null;
        }
        if (logInRealtime) {
            log.info(toString());
        }
    }

    public LogNode() {
        this("", "", -1, null);
        log("ClassGraph version " + VersionFinder.getVersion());
        logJavaInfo();
    }

    private void logJavaInfo() {
        log("Operating system: " + VersionFinder.getProperty("os.name") + " " + VersionFinder.getProperty("os.version") + " " + VersionFinder.getProperty("os.arch"));
        log("Java version: " + VersionFinder.getProperty(ClassFileVersion.VersionLocator.JAVA_VERSION) + " / " + VersionFinder.getProperty("java.runtime.version") + " (" + VersionFinder.getProperty("java.vendor") + ")");
        log("Java home: " + VersionFinder.getProperty("java.home"));
        String jreRtJarPath = SystemJarFinder.getJreRtJarPath();
        if (jreRtJarPath != null) {
            log("JRE rt.jar:").log(jreRtJarPath);
        }
    }

    private void appendLine(String timeStampStr, int indentLevel, String line, StringBuilder buf) {
        buf.append(timeStampStr);
        buf.append('\t');
        buf.append(ClassGraph.class.getSimpleName());
        buf.append('\t');
        int numDashes = 2 * (indentLevel - 1);
        for (int i = 0; i < numDashes; i++) {
            buf.append('-');
        }
        if (numDashes > 0) {
            buf.append(' ');
        }
        buf.append(line);
        buf.append('\n');
    }

    private void toString(int indentLevel, StringBuilder buf) {
        String timeStampStr;
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(this.timeStampMillis);
        synchronized (dateTimeFormatter) {
            timeStampStr = dateTimeFormatter.format(cal.getTime());
        }
        if (this.msg != null && !this.msg.isEmpty()) {
            appendLine(timeStampStr, indentLevel, this.elapsedTimeNanos > 0 ? this.msg + " (took " + nanoFormatter.format(((double) this.elapsedTimeNanos) * 1.0E-9d) + " sec)" : this.msg, buf);
        }
        if (this.stackTrace != null && !this.stackTrace.isEmpty()) {
            for (String part : this.stackTrace.split("\n")) {
                appendLine(timeStampStr, indentLevel, part, buf);
            }
        }
        for (Map.Entry<String, LogNode> ent : this.children.entrySet()) {
            ent.getValue().toString(indentLevel + 1, buf);
        }
    }

    public String toString() {
        String sb;
        synchronized (dateTimeFormatter) {
            StringBuilder buf = new StringBuilder();
            toString(0, buf);
            sb = buf.toString();
        }
        return sb;
    }

    public void addElapsedTime() {
        this.elapsedTimeNanos = System.nanoTime() - this.timeStampNano;
    }

    private LogNode addChild(String sortKey, String msg, long elapsedTimeNanos, Throwable exception) {
        String newSortKey = this.sortKeyPrefix + SyslogAppender.DEFAULT_STACKTRACE_PATTERN + (sortKey == null ? "" : sortKey) + SyslogAppender.DEFAULT_STACKTRACE_PATTERN + String.format("%09d", Integer.valueOf(sortKeyUniqueSuffix.getAndIncrement()));
        LogNode newChild = new LogNode(newSortKey, msg, elapsedTimeNanos, exception);
        newChild.parent = this;
        this.children.put(newSortKey, newChild);
        return newChild;
    }

    private LogNode addChild(String sortKey, String msg, long elapsedTimeNanos) {
        return addChild(sortKey, msg, elapsedTimeNanos, null);
    }

    private LogNode addChild(Throwable exception) {
        return addChild("", "", -1, exception);
    }

    public LogNode log(String sortKey, String msg, long elapsedTimeNanos, Throwable e) {
        return addChild(sortKey, msg, elapsedTimeNanos).addChild(e);
    }

    public LogNode log(String sortKey, String msg, long elapsedTimeNanos) {
        return addChild(sortKey, msg, elapsedTimeNanos);
    }

    public LogNode log(String sortKey, String msg, Throwable e) {
        return addChild(sortKey, msg, -1).addChild(e);
    }

    public LogNode log(String sortKey, String msg) {
        return addChild(sortKey, msg, -1);
    }

    public LogNode log(String msg, long elapsedTimeNanos, Throwable e) {
        return addChild("", msg, elapsedTimeNanos).addChild(e);
    }

    public LogNode log(String msg, long elapsedTimeNanos) {
        return addChild("", msg, elapsedTimeNanos);
    }

    public LogNode log(String msg, Throwable e) {
        return addChild("", msg, -1).addChild(e);
    }

    public LogNode log(String msg) {
        return addChild("", msg, -1);
    }

    public LogNode log(Collection<String> msgs) {
        LogNode last = null;
        for (String m : msgs) {
            last = log(m);
        }
        return last;
    }

    public LogNode log(Throwable e) {
        return log("Exception thrown").addChild(e);
    }

    public void flush() {
        if (this.parent != null) {
            throw new IllegalArgumentException("Only flush the toplevel LogNode");
        } else if (!this.children.isEmpty()) {
            String logOutput = toString();
            this.children.clear();
            log.info(logOutput);
        }
    }
}
