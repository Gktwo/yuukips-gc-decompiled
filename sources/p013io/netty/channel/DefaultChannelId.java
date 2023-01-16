package p013io.netty.channel;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import p013io.netty.buffer.ByteBufUtil;
import p013io.netty.util.internal.EmptyArrays;
import p013io.netty.util.internal.MacAddressUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.SystemPropertyUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.channel.DefaultChannelId */
/* loaded from: grasscutter.jar:io/netty/channel/DefaultChannelId.class */
public final class DefaultChannelId implements ChannelId {
    private static final long serialVersionUID = 3884076183504074063L;
    private static final InternalLogger logger;
    private static final byte[] MACHINE_ID;
    private static final int PROCESS_ID_LEN = 4;
    private static final int PROCESS_ID;
    private static final int SEQUENCE_LEN = 4;
    private static final int TIMESTAMP_LEN = 8;
    private static final int RANDOM_LEN = 4;
    private static final AtomicInteger nextSequence;
    private final byte[] data = new byte[(((MACHINE_ID.length + 4) + 4) + 8) + 4];
    private final int hashCode;
    private transient String shortValue;
    private transient String longValue;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !DefaultChannelId.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(DefaultChannelId.class);
        nextSequence = new AtomicInteger();
        int processId = -1;
        String customProcessId = SystemPropertyUtil.get("io.netty.processId");
        if (customProcessId != null) {
            try {
                processId = Integer.parseInt(customProcessId);
            } catch (NumberFormatException e) {
            }
            if (processId < 0) {
                processId = -1;
                logger.warn("-Dio.netty.processId: {} (malformed)", customProcessId);
            } else if (logger.isDebugEnabled()) {
                logger.debug("-Dio.netty.processId: {} (user-set)", Integer.valueOf(processId));
            }
        }
        if (processId < 0) {
            processId = defaultProcessId();
            if (logger.isDebugEnabled()) {
                logger.debug("-Dio.netty.processId: {} (auto-detected)", Integer.valueOf(processId));
            }
        }
        PROCESS_ID = processId;
        byte[] machineId = null;
        String customMachineId = SystemPropertyUtil.get("io.netty.machineId");
        if (customMachineId != null) {
            try {
                machineId = MacAddressUtil.parseMAC(customMachineId);
            } catch (Exception e2) {
                logger.warn("-Dio.netty.machineId: {} (malformed)", customMachineId, e2);
            }
            if (machineId != null) {
                logger.debug("-Dio.netty.machineId: {} (user-set)", customMachineId);
            }
        }
        if (machineId == null) {
            machineId = MacAddressUtil.defaultMachineId();
            if (logger.isDebugEnabled()) {
                logger.debug("-Dio.netty.machineId: {} (auto-detected)", MacAddressUtil.formatAddress(machineId));
            }
        }
        MACHINE_ID = machineId;
    }

    public static DefaultChannelId newInstance() {
        return new DefaultChannelId();
    }

    static int processHandlePid(ClassLoader loader) {
        if (PlatformDependent.javaVersion() < 9) {
            return -1;
        }
        try {
            Class<?> processHandleImplType = Class.forName("java.lang.ProcessHandle", true, loader);
            Long pid = (Long) processHandleImplType.getMethod("pid", new Class[0]).invoke(processHandleImplType.getMethod("current", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            if (pid.longValue() <= 2147483647L && pid.longValue() >= -2147483648L) {
                return pid.intValue();
            }
            throw new IllegalStateException("Current process ID exceeds int range: " + pid);
        } catch (Exception e) {
            logger.debug("Could not invoke ProcessHandle.current().pid();", (Throwable) e);
            return -1;
        }
    }

    static int jmxPid(ClassLoader loader) {
        String value;
        int pid;
        try {
            Class<?> mgmtFactoryType = Class.forName("java.lang.management.ManagementFactory", true, loader);
            value = (String) Class.forName("java.lang.management.RuntimeMXBean", true, loader).getMethod("getName", EmptyArrays.EMPTY_CLASSES).invoke(mgmtFactoryType.getMethod("getRuntimeMXBean", EmptyArrays.EMPTY_CLASSES).invoke(null, EmptyArrays.EMPTY_OBJECTS), EmptyArrays.EMPTY_OBJECTS);
        } catch (Throwable t) {
            logger.debug("Could not invoke ManagementFactory.getRuntimeMXBean().getName(); Android?", t);
            try {
                value = Class.forName("android.os.Process", true, loader).getMethod("myPid", EmptyArrays.EMPTY_CLASSES).invoke(null, EmptyArrays.EMPTY_OBJECTS).toString();
            } catch (Throwable t2) {
                logger.debug("Could not invoke Process.myPid(); not Android?", t2);
                value = "";
            }
        }
        int atIndex = value.indexOf(64);
        if (atIndex >= 0) {
            value = value.substring(0, atIndex);
        }
        try {
            pid = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            pid = -1;
        }
        if (pid < 0) {
            pid = PlatformDependent.threadLocalRandom().nextInt();
            logger.warn("Failed to find the current process ID from '{}'; using a random value: {}", value, Integer.valueOf(pid));
        }
        return pid;
    }

    static int defaultProcessId() {
        ClassLoader loader = PlatformDependent.getClassLoader(DefaultChannelId.class);
        int processId = processHandlePid(loader);
        if (processId != -1) {
            return processId;
        }
        return jmxPid(loader);
    }

    private DefaultChannelId() {
        System.arraycopy(MACHINE_ID, 0, this.data, 0, MACHINE_ID.length);
        int i = writeInt(writeLong(writeInt(writeInt(0 + MACHINE_ID.length, PROCESS_ID), nextSequence.getAndIncrement()), Long.reverse(System.nanoTime()) ^ System.currentTimeMillis()), PlatformDependent.threadLocalRandom().nextInt());
        if ($assertionsDisabled || i == this.data.length) {
            this.hashCode = Arrays.hashCode(this.data);
            return;
        }
        throw new AssertionError();
    }

    private int writeInt(int i, int value) {
        int i2 = i + 1;
        this.data[i] = (byte) (value >>> 24);
        int i3 = i2 + 1;
        this.data[i2] = (byte) (value >>> 16);
        int i4 = i3 + 1;
        this.data[i3] = (byte) (value >>> 8);
        int i5 = i4 + 1;
        this.data[i4] = (byte) value;
        return i5;
    }

    private int writeLong(int i, long value) {
        int i2 = i + 1;
        this.data[i] = (byte) ((int) (value >>> 56));
        int i3 = i2 + 1;
        this.data[i2] = (byte) ((int) (value >>> 48));
        int i4 = i3 + 1;
        this.data[i3] = (byte) ((int) (value >>> 40));
        int i5 = i4 + 1;
        this.data[i4] = (byte) ((int) (value >>> 32));
        int i6 = i5 + 1;
        this.data[i5] = (byte) ((int) (value >>> 24));
        int i7 = i6 + 1;
        this.data[i6] = (byte) ((int) (value >>> 16));
        int i8 = i7 + 1;
        this.data[i7] = (byte) ((int) (value >>> 8));
        int i9 = i8 + 1;
        this.data[i8] = (byte) ((int) value);
        return i9;
    }

    @Override // p013io.netty.channel.ChannelId
    public String asShortText() {
        String shortValue = this.shortValue;
        if (shortValue == null) {
            String hexDump = ByteBufUtil.hexDump(this.data, this.data.length - 4, 4);
            shortValue = hexDump;
            this.shortValue = hexDump;
        }
        return shortValue;
    }

    @Override // p013io.netty.channel.ChannelId
    public String asLongText() {
        String longValue = this.longValue;
        if (longValue == null) {
            String newLongValue = newLongValue();
            longValue = newLongValue;
            this.longValue = newLongValue;
        }
        return longValue;
    }

    private String newLongValue() {
        StringBuilder buf = new StringBuilder((2 * this.data.length) + 5);
        int i = appendHexDumpField(buf, appendHexDumpField(buf, appendHexDumpField(buf, appendHexDumpField(buf, appendHexDumpField(buf, 0, MACHINE_ID.length), 4), 4), 8), 4);
        if ($assertionsDisabled || i == this.data.length) {
            return buf.substring(0, buf.length() - 1);
        }
        throw new AssertionError();
    }

    private int appendHexDumpField(StringBuilder buf, int i, int length) {
        buf.append(ByteBufUtil.hexDump(this.data, i, length));
        buf.append('-');
        return i + length;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.hashCode;
    }

    public int compareTo(ChannelId o) {
        if (this == o) {
            return 0;
        }
        if (!(o instanceof DefaultChannelId)) {
            return asLongText().compareTo(o.asLongText());
        }
        byte[] otherData = ((DefaultChannelId) o).data;
        int len1 = this.data.length;
        int len2 = otherData.length;
        int len = Math.min(len1, len2);
        for (int k = 0; k < len; k++) {
            byte x = this.data[k];
            byte y = otherData[k];
            if (x != y) {
                return (x & 255) - (y & 255);
            }
        }
        return len1 - len2;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DefaultChannelId)) {
            return false;
        }
        DefaultChannelId other = (DefaultChannelId) obj;
        return this.hashCode == other.hashCode && Arrays.equals(this.data, other.data);
    }

    @Override // java.lang.Object
    public String toString() {
        return asShortText();
    }
}
