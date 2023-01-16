package p013io.javalin.http.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.http.Context;

/* compiled from: SeekableWriter.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��>\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n��\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J.\u0010\t\u001a\u00020\n*\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0018"}, m373d2 = {"Lio/javalin/http/util/SeekableWriter;", "", "()V", "chunkSize", "", "getChunkSize", "()I", "setChunkSize", "(I)V", "write", "", "ctx", "Lio/javalin/http/Context;", "inputStream", "Ljava/io/InputStream;", "contentType", "", "totalBytes", "", "Ljava/io/OutputStream;", "from", "to", "buffer", "", "javalin"})
/* renamed from: io.javalin.http.util.SeekableWriter */
/* loaded from: grasscutter.jar:io/javalin/http/util/SeekableWriter.class */
public final class SeekableWriter {
    @NotNull
    public static final SeekableWriter INSTANCE = new SeekableWriter();
    private static int chunkSize = 128000;

    private SeekableWriter() {
    }

    public final int getChunkSize() {
        return chunkSize;
    }

    public final void setChunkSize(int i) {
        chunkSize = i;
    }

    public final void write(@NotNull Context ctx, @NotNull InputStream inputStream, @NotNull String contentType, long totalBytes) {
        long to;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        if (ctx.header("Range") == null) {
            ctx.header("Content-Type", contentType);
            ctx.result(inputStream);
            return;
        }
        String header = ctx.header("Range");
        Intrinsics.checkNotNull(header);
        Iterable $this$filter$iv = StringsKt.split$default((CharSequence) StringsKt.split$default((CharSequence) header, new String[]{"="}, false, 0, 6, (Object) null).get(1), new String[]{"-"}, false, 0, 6, (Object) null);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (((String) element$iv$iv).length() > 0) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List requestedRange = (List) destination$iv$iv;
        long from = Long.parseLong((String) requestedRange.get(0));
        if (from + ((long) chunkSize) > totalBytes) {
            to = totalBytes - 1;
        } else if (requestedRange.size() == 2) {
            to = Long.parseLong((String) requestedRange.get(1));
        } else {
            to = (from + ((long) chunkSize)) - 1;
        }
        ctx.status(206);
        ctx.header("Content-Type", contentType);
        ctx.header("Accept-Ranges", "bytes");
        ctx.header("Content-Range", "bytes " + from + '-' + to + '/' + totalBytes);
        ctx.header("Content-Length", String.valueOf(Math.min((to - from) + 1, totalBytes)));
        ServletOutputStream outputStream = ctx.res.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "ctx.res.outputStream");
        write$default(this, outputStream, inputStream, from, to, null, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [long] */
    /* JADX WARN: Type inference failed for: r23v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v26, types: [long] */
    /* JADX WARN: Type inference failed for: r23v2 */
    /* JADX WARN: Type inference failed for: r0v30, types: [long] */
    /* JADX WARN: Type inference failed for: r23v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void write(java.io.OutputStream r9, java.io.InputStream r10, long r11, long r13, byte[] r15) {
        /*
            r8 = this;
            r0 = r10
            java.io.Closeable r0 = (java.io.Closeable) r0
            r16 = r0
            r0 = 0
            r17 = r0
            r0 = 0
            r18 = r0
            r0 = 0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r18 = r0
            r0 = r16
            java.io.InputStream r0 = (java.io.InputStream) r0     // Catch: Throwable -> 0x0085, all -> 0x008e
            r19 = r0
            r0 = 0
            r20 = r0
            r0 = r11
            r21 = r0
        L_0x0020:
            r0 = r21
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x003a
            r0 = r19
            r1 = r21
            long r0 = r0.skip(r1)     // Catch: Throwable -> 0x0085, all -> 0x008e
            r23 = r0
            r0 = r21
            r1 = r23
            long r0 = r0 - r1
            r21 = r0
            goto L_0x0020
        L_0x003a:
            r0 = r13
            r1 = r11
            long r0 = r0 - r1
            r1 = 1
            long r0 = r0 + r1
            r23 = r0
        L_0x0042:
            r0 = r23
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0071
            r0 = r19
            r1 = r15
            r2 = 0
            r3 = r15
            int r3 = r3.length     // Catch: Throwable -> 0x0085, all -> 0x008e
            long r3 = (long) r3     // Catch: Throwable -> 0x0085, all -> 0x008e
            r4 = r23
            long r3 = kotlin.ranges.RangesKt.coerceAtMost(r3, r4)     // Catch: Throwable -> 0x0085, all -> 0x008e
            int r3 = (int) r3     // Catch: Throwable -> 0x0085, all -> 0x008e
            int r0 = r0.read(r1, r2, r3)     // Catch: Throwable -> 0x0085, all -> 0x008e
            r25 = r0
            r0 = r9
            r1 = r15
            r2 = 0
            r3 = r25
            r0.write(r1, r2, r3)     // Catch: Throwable -> 0x0085, all -> 0x008e
            r0 = r23
            r1 = r25
            long r1 = (long) r1     // Catch: Throwable -> 0x0085, all -> 0x008e
            long r0 = r0 - r1
            r23 = r0
            goto L_0x0042
        L_0x0071:
            r0 = r10
            r0.close()     // Catch: Throwable -> 0x0085, all -> 0x008e
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: Throwable -> 0x0085, all -> 0x008e
            r19 = r0
            r0 = r16
            r1 = r18
            kotlin.p016io.Closeable.closeFinally(r0, r1)
            goto L_0x009a
        L_0x0085:
            r19 = move-exception
            r0 = r19
            r18 = r0
            r0 = r19
            throw r0     // Catch: all -> 0x008e
        L_0x008e:
            r19 = move-exception
            r0 = r16
            r1 = r18
            kotlin.p016io.Closeable.closeFinally(r0, r1)
            r0 = r19
            throw r0
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.javalin.http.util.SeekableWriter.write(java.io.OutputStream, java.io.InputStream, long, long, byte[]):void");
    }

    static /* synthetic */ void write$default(SeekableWriter seekableWriter, OutputStream outputStream, InputStream inputStream, long j, long j2, byte[] bArr, int i, Object obj) {
        if ((i & 8) != 0) {
            bArr = new byte[1024];
        }
        seekableWriter.write(outputStream, inputStream, j, j2, bArr);
    }
}
