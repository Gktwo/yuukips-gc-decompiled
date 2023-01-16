package p013io.netty.util.internal;

import java.lang.Thread;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.util.internal.ThreadLocalRandom */
/* loaded from: grasscutter.jar:io/netty/util/internal/ThreadLocalRandom.class */
public final class ThreadLocalRandom extends Random {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ThreadLocalRandom.class);
    private static final AtomicLong seedUniquifier = new AtomicLong();
    private static volatile long initialSeedUniquifier;
    private static final Thread seedGeneratorThread;
    private static final BlockingQueue<Long> seedQueue;
    private static final long seedGeneratorStartTime;
    private static volatile long seedGeneratorEndTime;
    private static final long multiplier = 25214903917L;
    private static final long addend = 11;
    private static final long mask = 281474976710655L;
    private long rnd;
    boolean initialized = true;
    private long pad0;
    private long pad1;
    private long pad2;
    private long pad3;
    private long pad4;
    private long pad5;
    private long pad6;
    private long pad7;
    private static final long serialVersionUID = -5851777807851030925L;

    static {
        initialSeedUniquifier = SystemPropertyUtil.getLong("io.netty.initialSeedUniquifier", 0);
        if (initialSeedUniquifier != 0) {
            seedGeneratorThread = null;
            seedQueue = null;
            seedGeneratorStartTime = 0;
        } else if (SystemPropertyUtil.getBoolean("java.util.secureRandomSeed", false)) {
            seedQueue = new LinkedBlockingQueue();
            seedGeneratorStartTime = System.nanoTime();
            seedGeneratorThread = new Thread("initialSeedUniquifierGenerator") { // from class: io.netty.util.internal.ThreadLocalRandom.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    byte[] seed = new SecureRandom().generateSeed(8);
                    long unused = ThreadLocalRandom.seedGeneratorEndTime = System.nanoTime();
                    ThreadLocalRandom.seedQueue.add(Long.valueOf(((((long) seed[0]) & 255) << 56) | ((((long) seed[1]) & 255) << 48) | ((((long) seed[2]) & 255) << 40) | ((((long) seed[3]) & 255) << 32) | ((((long) seed[4]) & 255) << 24) | ((((long) seed[5]) & 255) << 16) | ((((long) seed[6]) & 255) << 8) | (((long) seed[7]) & 255)));
                }
            };
            seedGeneratorThread.setDaemon(true);
            seedGeneratorThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: io.netty.util.internal.ThreadLocalRandom.2
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread t, Throwable e) {
                    ThreadLocalRandom.logger.debug("An exception has been raised by {}", t.getName(), e);
                }
            });
            seedGeneratorThread.start();
        } else {
            initialSeedUniquifier = mix64(System.currentTimeMillis()) ^ mix64(System.nanoTime());
            seedGeneratorThread = null;
            seedQueue = null;
            seedGeneratorStartTime = 0;
        }
    }

    public static void setInitialSeedUniquifier(long initialSeedUniquifier2) {
        initialSeedUniquifier = initialSeedUniquifier2;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    /* JADX WARN: Type inference failed for: r0v21, types: [long] */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006b, code lost:
        r6 = r16.longValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long getInitialSeedUniquifier() {
        /*
        // Method dump skipped, instructions count: 233
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.internal.ThreadLocalRandom.getInitialSeedUniquifier():long");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.concurrent.atomic.AtomicLong] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long newSeed() {
        /*
        L_0x0000:
            java.util.concurrent.atomic.AtomicLong r0 = p013io.netty.util.internal.ThreadLocalRandom.seedUniquifier
            long r0 = r0.get()
            r11 = r0
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0011
            r0 = r11
            goto L_0x0014
        L_0x0011:
            long r0 = getInitialSeedUniquifier()
        L_0x0014:
            r13 = r0
            r0 = r13
            r1 = 181783497276652981(0x285d320ad33fdb5, double:1.6685641475275746E-296)
            long r0 = r0 * r1
            r15 = r0
            java.util.concurrent.atomic.AtomicLong r0 = p013io.netty.util.internal.ThreadLocalRandom.seedUniquifier
            r1 = r11
            r2 = r15
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L_0x008e
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0087
            io.netty.util.internal.logging.InternalLogger r0 = p013io.netty.util.internal.ThreadLocalRandom.logger
            boolean r0 = r0.isDebugEnabled()
            if (r0 == 0) goto L_0x0087
            long r0 = p013io.netty.util.internal.ThreadLocalRandom.seedGeneratorEndTime
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x006f
            io.netty.util.internal.logging.InternalLogger r0 = p013io.netty.util.internal.ThreadLocalRandom.logger
            java.lang.String r1 = "-Dio.netty.initialSeedUniquifier: 0x%016x (took %d ms)"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r13
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r3[r4] = r5
            r3 = r2
            r4 = 1
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r6 = p013io.netty.util.internal.ThreadLocalRandom.seedGeneratorEndTime
            long r7 = p013io.netty.util.internal.ThreadLocalRandom.seedGeneratorStartTime
            long r6 = r6 - r7
            long r5 = r5.toMillis(r6)
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r3[r4] = r5
            java.lang.String r1 = java.lang.String.format(r1, r2)
            r0.debug(r1)
            goto L_0x0087
        L_0x006f:
            io.netty.util.internal.logging.InternalLogger r0 = p013io.netty.util.internal.ThreadLocalRandom.logger
            java.lang.String r1 = "-Dio.netty.initialSeedUniquifier: 0x%016x"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r13
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r3[r4] = r5
            java.lang.String r1 = java.lang.String.format(r1, r2)
            r0.debug(r1)
        L_0x0087:
            r0 = r15
            long r1 = java.lang.System.nanoTime()
            long r0 = r0 ^ r1
            return r0
        L_0x008e:
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.internal.ThreadLocalRandom.newSeed():long");
    }

    private static long mix64(long z) {
        long z2 = (z ^ (z >>> 33)) * -49064778989728563L;
        long z3 = (z2 ^ (z2 >>> 33)) * -4265267296055464877L;
        return z3 ^ (z3 >>> 33);
    }

    /* access modifiers changed from: package-private */
    public ThreadLocalRandom() {
        super(newSeed());
    }

    public static ThreadLocalRandom current() {
        return InternalThreadLocalMap.get().random();
    }

    @Override // java.util.Random
    public void setSeed(long seed) {
        if (this.initialized) {
            throw new UnsupportedOperationException();
        }
        this.rnd = (seed ^ multiplier) & mask;
    }

    @Override // java.util.Random
    protected int next(int bits) {
        this.rnd = ((this.rnd * multiplier) + addend) & mask;
        return (int) (this.rnd >>> (48 - bits));
    }

    public int nextInt(int least, int bound) {
        if (least < bound) {
            return nextInt(bound - least) + least;
        }
        throw new IllegalArgumentException();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x003d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r0v18, types: [long] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long nextLong(long r8) {
        /*
            r7 = this;
            r0 = r8
            java.lang.String r1 = "n"
            long r0 = p013io.netty.util.internal.ObjectUtil.checkPositive(r0, r1)
            r0 = 0
            r10 = r0
        L_0x0009:
            r0 = r8
            r1 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0043
            r0 = r7
            r1 = 2
            int r0 = r0.next(r1)
            r12 = r0
            r0 = r8
            r1 = 1
            long r0 = r0 >>> r1
            r13 = r0
            r0 = r12
            r1 = 2
            r0 = r0 & r1
            if (r0 != 0) goto L_0x0029
            r0 = r13
            goto L_0x002d
        L_0x0029:
            r0 = r8
            r1 = r13
            long r0 = r0 - r1
        L_0x002d:
            r15 = r0
            r0 = r12
            r1 = 1
            r0 = r0 & r1
            if (r0 != 0) goto L_0x003d
            r0 = r10
            r1 = r8
            r2 = r15
            long r1 = r1 - r2
            long r0 = r0 + r1
            r10 = r0
        L_0x003d:
            r0 = r15
            r8 = r0
            goto L_0x0009
        L_0x0043:
            r0 = r10
            r1 = r7
            r2 = r8
            int r2 = (int) r2
            int r1 = r1.nextInt(r2)
            long r1 = (long) r1
            long r0 = r0 + r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.internal.ThreadLocalRandom.nextLong(long):long");
    }

    public long nextLong(long least, long bound) {
        if (least < bound) {
            return nextLong(bound - least) + least;
        }
        throw new IllegalArgumentException();
    }

    public double nextDouble(double n) {
        ObjectUtil.checkPositive(n, "n");
        return nextDouble() * n;
    }

    public double nextDouble(double least, double bound) {
        if (least < bound) {
            return (nextDouble() * (bound - least)) + least;
        }
        throw new IllegalArgumentException();
    }
}
