package p013io.netty.buffer;

/* renamed from: io.netty.buffer.SizeClassesMetric */
/* loaded from: grasscutter.jar:io/netty/buffer/SizeClassesMetric.class */
public interface SizeClassesMetric {
    int sizeIdx2size(int i);

    int sizeIdx2sizeCompute(int i);

    long pageIdx2size(int i);

    long pageIdx2sizeCompute(int i);

    int size2SizeIdx(int i);

    int pages2pageIdx(int i);

    int pages2pageIdxFloor(int i);

    int normalizeSize(int i);
}
