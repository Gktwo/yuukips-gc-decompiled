package okhttp3.internal.cache2;

import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: FileOperator.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��&\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\b��\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��¨\u0006\u000e"}, m373d2 = {"Lokhttp3/internal/cache2/FileOperator;", "", "fileChannel", "Ljava/nio/channels/FileChannel;", "(Ljava/nio/channels/FileChannel;)V", "read", "", "pos", "", "sink", "Lokio/Buffer;", "byteCount", "write", "source", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/cache2/FileOperator.class */
public final class FileOperator {
    @NotNull
    private final FileChannel fileChannel;

    public FileOperator(@NotNull FileChannel fileChannel) {
        Intrinsics.checkNotNullParameter(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [long] */
    /* JADX WARN: Type inference failed for: r11v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [long] */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r0v15, types: [long] */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void write(long r8, @org.jetbrains.annotations.NotNull okio.Buffer r10, long r11) throws java.io.IOException {
        /*
            r7 = this;
            r0 = r10
            java.lang.String r1 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0017
            r0 = r11
            r1 = r10
            long r1 = r1.size()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x001f
        L_0x0017:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x001f:
            r0 = r8
            r13 = r0
            r0 = r11
            r15 = r0
        L_0x0026:
            r0 = r15
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x004f
            r0 = r7
            java.nio.channels.FileChannel r0 = r0.fileChannel
            r1 = r10
            java.nio.channels.ReadableByteChannel r1 = (java.nio.channels.ReadableByteChannel) r1
            r2 = r13
            r3 = r15
            long r0 = r0.transferFrom(r1, r2, r3)
            r17 = r0
            r0 = r13
            r1 = r17
            long r0 = r0 + r1
            r13 = r0
            r0 = r15
            r1 = r17
            long r0 = r0 - r1
            r15 = r0
            goto L_0x0026
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.FileOperator.write(long, okio.Buffer, long):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [long] */
    /* JADX WARN: Type inference failed for: r11v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [long] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void read(long r8, @org.jetbrains.annotations.NotNull okio.Buffer r10, long r11) {
        /*
            r7 = this;
            r0 = r10
            java.lang.String r1 = "sink"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0015
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x0015:
            r0 = r8
            r13 = r0
            r0 = r11
            r15 = r0
        L_0x001c:
            r0 = r15
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0045
            r0 = r7
            java.nio.channels.FileChannel r0 = r0.fileChannel
            r1 = r13
            r2 = r15
            r3 = r10
            java.nio.channels.WritableByteChannel r3 = (java.nio.channels.WritableByteChannel) r3
            long r0 = r0.transferTo(r1, r2, r3)
            r17 = r0
            r0 = r13
            r1 = r17
            long r0 = r0 + r1
            r13 = r0
            r0 = r15
            r1 = r17
            long r0 = r0 - r1
            r15 = r0
            goto L_0x001c
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.FileOperator.read(long, okio.Buffer, long):void");
    }
}
