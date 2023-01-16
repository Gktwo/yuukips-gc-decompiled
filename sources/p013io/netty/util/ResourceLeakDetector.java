package p013io.netty.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.LongCompanionObject;
import p013io.netty.util.internal.EmptyArrays;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.StringUtil;
import p013io.netty.util.internal.SystemPropertyUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.util.ResourceLeakDetector */
/* loaded from: grasscutter.jar:io/netty/util/ResourceLeakDetector.class */
public class ResourceLeakDetector<T> {
    private static final String PROP_LEVEL_OLD = "io.netty.leakDetectionLevel";
    private static final String PROP_LEVEL = "io.netty.leakDetection.level";
    private static final String PROP_TARGET_RECORDS = "io.netty.leakDetection.targetRecords";
    private static final int DEFAULT_TARGET_RECORDS = 4;
    private static final String PROP_SAMPLING_INTERVAL = "io.netty.leakDetection.samplingInterval";
    private static final int DEFAULT_SAMPLING_INTERVAL = 128;
    private static final int TARGET_RECORDS;
    static final int SAMPLING_INTERVAL;
    private static Level level;
    private final Set<DefaultResourceLeak<?>> allLeaks;
    private final ReferenceQueue<Object> refQueue;
    private final Set<String> reportedLeaks;
    private final String resourceType;
    private final int samplingInterval;
    private static final AtomicReference<String[]> excludedMethods;
    private static final Level DEFAULT_LEVEL = Level.SIMPLE;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ResourceLeakDetector.class);

    static {
        boolean disabled;
        if (SystemPropertyUtil.get("io.netty.noResourceLeakDetection") != null) {
            disabled = SystemPropertyUtil.getBoolean("io.netty.noResourceLeakDetection", false);
            logger.debug("-Dio.netty.noResourceLeakDetection: {}", Boolean.valueOf(disabled));
            logger.warn("-Dio.netty.noResourceLeakDetection is deprecated. Use '-D{}={}' instead.", PROP_LEVEL, DEFAULT_LEVEL.name().toLowerCase());
        } else {
            disabled = false;
        }
        Level level2 = Level.parseLevel(SystemPropertyUtil.get(PROP_LEVEL, SystemPropertyUtil.get(PROP_LEVEL_OLD, (disabled ? Level.DISABLED : DEFAULT_LEVEL).name())));
        TARGET_RECORDS = SystemPropertyUtil.getInt(PROP_TARGET_RECORDS, 4);
        SAMPLING_INTERVAL = SystemPropertyUtil.getInt(PROP_SAMPLING_INTERVAL, 128);
        level = level2;
        if (logger.isDebugEnabled()) {
            logger.debug("-D{}: {}", PROP_LEVEL, level2.name().toLowerCase());
            logger.debug("-D{}: {}", PROP_TARGET_RECORDS, Integer.valueOf(TARGET_RECORDS));
        }
        excludedMethods = new AtomicReference<>(EmptyArrays.EMPTY_STRINGS);
    }

    /* renamed from: io.netty.util.ResourceLeakDetector$Level */
    /* loaded from: grasscutter.jar:io/netty/util/ResourceLeakDetector$Level.class */
    public enum Level {
        DISABLED,
        SIMPLE,
        ADVANCED,
        PARANOID;

        static Level parseLevel(String levelStr) {
            String trimmedLevelStr = levelStr.trim();
            Level[] values = values();
            for (Level l : values) {
                if (trimmedLevelStr.equalsIgnoreCase(l.name()) || trimmedLevelStr.equals(String.valueOf(l.ordinal()))) {
                    return l;
                }
            }
            return ResourceLeakDetector.DEFAULT_LEVEL;
        }
    }

    @Deprecated
    public static void setEnabled(boolean enabled) {
        setLevel(enabled ? Level.SIMPLE : Level.DISABLED);
    }

    public static boolean isEnabled() {
        return getLevel().ordinal() > Level.DISABLED.ordinal();
    }

    public static void setLevel(Level level2) {
        level = (Level) ObjectUtil.checkNotNull(level2, "level");
    }

    public static Level getLevel() {
        return level;
    }

    @Deprecated
    public ResourceLeakDetector(Class<?> resourceType) {
        this(StringUtil.simpleClassName(resourceType));
    }

    @Deprecated
    public ResourceLeakDetector(String resourceType) {
        this(resourceType, 128, (long) LongCompanionObject.MAX_VALUE);
    }

    @Deprecated
    public ResourceLeakDetector(Class<?> resourceType, int samplingInterval, long maxActive) {
        this(resourceType, samplingInterval);
    }

    public ResourceLeakDetector(Class<?> resourceType, int samplingInterval) {
        this(StringUtil.simpleClassName(resourceType), samplingInterval, (long) LongCompanionObject.MAX_VALUE);
    }

    @Deprecated
    public ResourceLeakDetector(String resourceType, int samplingInterval, long maxActive) {
        this.allLeaks = Collections.newSetFromMap(new ConcurrentHashMap());
        this.refQueue = new ReferenceQueue<>();
        this.reportedLeaks = Collections.newSetFromMap(new ConcurrentHashMap());
        this.resourceType = (String) ObjectUtil.checkNotNull(resourceType, "resourceType");
        this.samplingInterval = samplingInterval;
    }

    @Deprecated
    public final ResourceLeak open(T obj) {
        return track0(obj);
    }

    public final ResourceLeakTracker<T> track(T obj) {
        return track0(obj);
    }

    private DefaultResourceLeak track0(T obj) {
        Level level2 = level;
        if (level2 == Level.DISABLED) {
            return null;
        }
        if (level2.ordinal() >= Level.PARANOID.ordinal()) {
            reportLeak();
            return new DefaultResourceLeak(obj, this.refQueue, this.allLeaks, getInitialHint(this.resourceType));
        } else if (PlatformDependent.threadLocalRandom().nextInt(this.samplingInterval) != 0) {
            return null;
        } else {
            reportLeak();
            return new DefaultResourceLeak(obj, this.refQueue, this.allLeaks, getInitialHint(this.resourceType));
        }
    }

    private void clearRefQueue() {
        while (true) {
            DefaultResourceLeak ref = (DefaultResourceLeak) this.refQueue.poll();
            if (ref != null) {
                ref.dispose();
            } else {
                return;
            }
        }
    }

    protected boolean needReport() {
        return logger.isErrorEnabled();
    }

    private void reportLeak() {
        if (!needReport()) {
            clearRefQueue();
            return;
        }
        while (true) {
            DefaultResourceLeak ref = (DefaultResourceLeak) this.refQueue.poll();
            if (ref != null) {
                if (ref.dispose()) {
                    String records = ref.getReportAndClearRecords();
                    if (this.reportedLeaks.add(records)) {
                        if (records.isEmpty()) {
                            reportUntracedLeak(this.resourceType);
                        } else {
                            reportTracedLeak(this.resourceType, records);
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    protected void reportTracedLeak(String resourceType, String records) {
        logger.error("LEAK: {}.release() was not called before it's garbage-collected. See https://netty.io/wiki/reference-counted-objects.html for more information.{}", resourceType, records);
    }

    protected void reportUntracedLeak(String resourceType) {
        logger.error("LEAK: {}.release() was not called before it's garbage-collected. Enable advanced leak reporting to find out where the leak occurred. To enable advanced leak reporting, specify the JVM option '-D{}={}' or call {}.setLevel() See https://netty.io/wiki/reference-counted-objects.html for more information.", resourceType, PROP_LEVEL, Level.ADVANCED.name().toLowerCase(), StringUtil.simpleClassName(this));
    }

    @Deprecated
    protected void reportInstancesLeak(String resourceType) {
    }

    protected Object getInitialHint(String resourceType) {
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.ResourceLeakDetector$DefaultResourceLeak */
    /* loaded from: grasscutter.jar:io/netty/util/ResourceLeakDetector$DefaultResourceLeak.class */
    public static final class DefaultResourceLeak<T> extends WeakReference<Object> implements ResourceLeakTracker<T>, ResourceLeak {
        private static final AtomicReferenceFieldUpdater<DefaultResourceLeak<?>, TraceRecord> headUpdater;
        private static final AtomicIntegerFieldUpdater<DefaultResourceLeak<?>> droppedRecordsUpdater;
        private volatile TraceRecord head;
        private volatile int droppedRecords;
        private final Set<DefaultResourceLeak<?>> allLeaks;
        private final int trackedHash;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !ResourceLeakDetector.class.desiredAssertionStatus();
            headUpdater = AtomicReferenceFieldUpdater.newUpdater(DefaultResourceLeak.class, TraceRecord.class, "head");
            droppedRecordsUpdater = AtomicIntegerFieldUpdater.newUpdater(DefaultResourceLeak.class, "droppedRecords");
        }

        DefaultResourceLeak(Object referent, ReferenceQueue<Object> refQueue, Set<DefaultResourceLeak<?>> allLeaks, Object initialHint) {
            super(referent, refQueue);
            if ($assertionsDisabled || referent != null) {
                this.trackedHash = System.identityHashCode(referent);
                allLeaks.add(this);
                headUpdater.set(this, initialHint == null ? new TraceRecord(TraceRecord.BOTTOM) : new TraceRecord(TraceRecord.BOTTOM, initialHint));
                this.allLeaks = allLeaks;
                return;
            }
            throw new AssertionError();
        }

        @Override // p013io.netty.util.ResourceLeakTracker, p013io.netty.util.ResourceLeak
        public void record() {
            record0(null);
        }

        @Override // p013io.netty.util.ResourceLeakTracker, p013io.netty.util.ResourceLeak
        public void record(Object hint) {
            record0(hint);
        }

        private void record0(Object hint) {
            TraceRecord oldHead;
            TraceRecord prevHead;
            boolean dropped;
            if (ResourceLeakDetector.TARGET_RECORDS > 0) {
                do {
                    oldHead = headUpdater.get(this);
                    prevHead = oldHead;
                    if (oldHead != null) {
                        int numElements = oldHead.pos + 1;
                        if (numElements >= ResourceLeakDetector.TARGET_RECORDS) {
                            boolean z = PlatformDependent.threadLocalRandom().nextInt(1 << Math.min(numElements - ResourceLeakDetector.TARGET_RECORDS, 30)) != 0;
                            dropped = z;
                            if (z) {
                                prevHead = oldHead.next;
                            }
                        } else {
                            dropped = false;
                        }
                    } else {
                        return;
                    }
                } while (!headUpdater.compareAndSet(this, oldHead, hint != null ? new TraceRecord(prevHead, hint) : new TraceRecord(prevHead)));
                if (dropped) {
                    droppedRecordsUpdater.incrementAndGet(this);
                }
            }
        }

        boolean dispose() {
            clear();
            return this.allLeaks.remove(this);
        }

        @Override // p013io.netty.util.ResourceLeak
        public boolean close() {
            if (!this.allLeaks.remove(this)) {
                return false;
            }
            clear();
            headUpdater.set(this, null);
            return true;
        }

        @Override // p013io.netty.util.ResourceLeakTracker
        public boolean close(T trackedObject) {
            if ($assertionsDisabled || this.trackedHash == System.identityHashCode(trackedObject)) {
                try {
                    return close();
                } finally {
                    reachabilityFence0(trackedObject);
                }
            } else {
                throw new AssertionError();
            }
        }

        private static void reachabilityFence0(Object ref) {
            if (ref != null) {
                synchronized (ref) {
                }
            }
        }

        @Override // java.lang.Object
        public String toString() {
            return generateReport(headUpdater.get(this));
        }

        String getReportAndClearRecords() {
            return generateReport(headUpdater.getAndSet(this, null));
        }

        private String generateReport(TraceRecord oldHead) {
            if (oldHead == null) {
                return "";
            }
            int dropped = droppedRecordsUpdater.get(this);
            int duped = 0;
            int present = oldHead.pos + 1;
            StringBuilder buf = new StringBuilder(present * 2048).append(StringUtil.NEWLINE);
            buf.append("Recent access records: ").append(StringUtil.NEWLINE);
            int i = 1;
            Set<String> seen = new HashSet<>(present);
            while (oldHead != TraceRecord.BOTTOM) {
                String s = oldHead.toString();
                if (!seen.add(s)) {
                    duped++;
                } else if (oldHead.next == TraceRecord.BOTTOM) {
                    buf.append("Created at:").append(StringUtil.NEWLINE).append(s);
                } else {
                    i++;
                    buf.append('#').append(i).append(':').append(StringUtil.NEWLINE).append(s);
                }
                oldHead = oldHead.next;
            }
            if (duped > 0) {
                buf.append(": ").append(duped).append(" leak records were discarded because they were duplicates").append(StringUtil.NEWLINE);
            }
            if (dropped > 0) {
                buf.append(": ").append(dropped).append(" leak records were discarded because the leak record count is targeted to ").append(ResourceLeakDetector.TARGET_RECORDS).append(". Use system property ").append(ResourceLeakDetector.PROP_TARGET_RECORDS).append(" to increase the limit.").append(StringUtil.NEWLINE);
            }
            buf.setLength(buf.length() - StringUtil.NEWLINE.length());
            return buf.toString();
        }
    }

    public static void addExclusions(Class clz, String... methodNames) {
        String[] oldMethods;
        String[] newMethods;
        Set<String> nameSet = new HashSet<>(Arrays.asList(methodNames));
        Method[] declaredMethods = clz.getDeclaredMethods();
        int length = declaredMethods.length;
        int i = 0;
        while (i < length && (!nameSet.remove(declaredMethods[i].getName()) || !nameSet.isEmpty())) {
            i++;
        }
        if (!nameSet.isEmpty()) {
            throw new IllegalArgumentException("Can't find '" + nameSet + "' in " + clz.getName());
        }
        do {
            oldMethods = excludedMethods.get();
            newMethods = (String[]) Arrays.copyOf(oldMethods, oldMethods.length + (2 * methodNames.length));
            for (int i2 = 0; i2 < methodNames.length; i2++) {
                newMethods[oldMethods.length + (i2 * 2)] = clz.getName();
                newMethods[oldMethods.length + (i2 * 2) + 1] = methodNames[i2];
            }
        } while (!excludedMethods.compareAndSet(oldMethods, newMethods));
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.ResourceLeakDetector$TraceRecord */
    /* loaded from: grasscutter.jar:io/netty/util/ResourceLeakDetector$TraceRecord.class */
    public static class TraceRecord extends Throwable {
        private static final long serialVersionUID = 6065153674892850720L;
        private static final TraceRecord BOTTOM = new TraceRecord() { // from class: io.netty.util.ResourceLeakDetector.TraceRecord.1
            private static final long serialVersionUID = 7396077602074694571L;

            @Override // java.lang.Throwable
            public Throwable fillInStackTrace() {
                return this;
            }
        };
        private final String hintString;
        private final TraceRecord next;
        private final int pos;

        TraceRecord(TraceRecord next, Object hint) {
            this.hintString = hint instanceof ResourceLeakHint ? ((ResourceLeakHint) hint).toHintString() : hint.toString();
            this.next = next;
            this.pos = next.pos + 1;
        }

        TraceRecord(TraceRecord next) {
            this.hintString = null;
            this.next = next;
            this.pos = next.pos + 1;
        }

        private TraceRecord() {
            this.hintString = null;
            this.next = null;
            this.pos = -1;
        }

        @Override // java.lang.Throwable, java.lang.Object
        public String toString() {
            StringBuilder buf = new StringBuilder(2048);
            if (this.hintString != null) {
                buf.append("\tHint: ").append(this.hintString).append(StringUtil.NEWLINE);
            }
            StackTraceElement[] array = getStackTrace();
            for (int i = 3; i < array.length; i++) {
                StackTraceElement element = array[i];
                String[] exclusions = (String[]) ResourceLeakDetector.excludedMethods.get();
                int k = 0;
                while (true) {
                    if (k >= exclusions.length) {
                        buf.append('\t');
                        buf.append(element.toString());
                        buf.append(StringUtil.NEWLINE);
                        break;
                    } else if (!exclusions[k].equals(element.getClassName()) || !exclusions[k + 1].equals(element.getMethodName())) {
                        k += 2;
                    }
                }
            }
            return buf.toString();
        }
    }
}
