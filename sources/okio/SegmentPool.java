package okio;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: SegmentPool.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��.\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\b\n��\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J\b\u0010\u0014\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n��\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u001e\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e0\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u0015"}, m373d2 = {"Lokio/SegmentPool;", "", "()V", "HASH_BUCKET_COUNT", "", "LOCK", "Lokio/Segment;", "MAX_SIZE", "getMAX_SIZE", "()I", "byteCount", "getByteCount", "hashBuckets", "", "Ljava/util/concurrent/atomic/AtomicReference;", "[Ljava/util/concurrent/atomic/AtomicReference;", "firstRef", "recycle", "", "segment", "take", "okio"})
/* loaded from: grasscutter.jar:okio/SegmentPool.class */
public final class SegmentPool {
    @NotNull
    public static final SegmentPool INSTANCE = new SegmentPool();
    private static final int MAX_SIZE = 65536;
    @NotNull
    private static final Segment LOCK = new Segment(new byte[0], 0, 0, false, false);
    private static final int HASH_BUCKET_COUNT = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
    @NotNull
    private static final AtomicReference<Segment>[] hashBuckets;

    private SegmentPool() {
    }

    public final int getMAX_SIZE() {
        return MAX_SIZE;
    }

    static {
        int i = HASH_BUCKET_COUNT;
        AtomicReference<Segment>[] atomicReferenceArr = new AtomicReference[i];
        for (int i2 = 0; i2 < i; i2++) {
            atomicReferenceArr[i2] = new AtomicReference<>();
        }
        hashBuckets = atomicReferenceArr;
    }

    public final int getByteCount() {
        Segment first = firstRef().get();
        if (first == null) {
            return 0;
        }
        return first.limit;
    }

    @JvmStatic
    @NotNull
    public static final Segment take() {
        AtomicReference firstRef = INSTANCE.firstRef();
        Segment first = firstRef.getAndSet(LOCK);
        if (first == LOCK) {
            return new Segment();
        }
        if (first == null) {
            firstRef.set(null);
            return new Segment();
        }
        firstRef.set(first.next);
        first.next = null;
        first.limit = 0;
        return first;
    }

    @JvmStatic
    public static final void recycle(@NotNull Segment segment) {
        AtomicReference firstRef;
        Segment first;
        Intrinsics.checkNotNullParameter(segment, "segment");
        if (!(segment.next == null && segment.prev == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!segment.shared && (first = (firstRef = INSTANCE.firstRef()).get()) != LOCK) {
            int firstLimit = first == null ? 0 : first.limit;
            SegmentPool segmentPool = INSTANCE;
            if (firstLimit < MAX_SIZE) {
                segment.next = first;
                segment.pos = 0;
                segment.limit = firstLimit + 8192;
                if (!firstRef.compareAndSet(first, segment)) {
                    segment.next = null;
                }
            }
        }
    }

    private final AtomicReference<Segment> firstRef() {
        return hashBuckets[(int) (Thread.currentThread().getId() & (((long) HASH_BUCKET_COUNT) - 1))];
    }
}
