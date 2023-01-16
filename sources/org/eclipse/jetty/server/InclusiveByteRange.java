package org.eclipse.jetty.server;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/InclusiveByteRange.class */
public class InclusiveByteRange {
    private static final Logger LOG = Log.getLogger(InclusiveByteRange.class);
    private long first;
    private long last;

    public InclusiveByteRange(long first, long last) {
        this.first = first;
        this.last = last;
    }

    public long getFirst() {
        return this.first;
    }

    public long getLast() {
        return this.last;
    }

    private void coalesce(InclusiveByteRange r) {
        this.first = Math.min(this.first, r.first);
        this.last = Math.max(this.last, r.last);
    }

    private boolean overlaps(InclusiveByteRange range) {
        return (range.first >= this.first && range.first <= this.last) || (range.last >= this.first && range.last <= this.last) || (range.first < this.first && range.last > this.last);
    }

    public long getSize() {
        return (this.last - this.first) + 1;
    }

    public String toHeaderRangeString(long size) {
        StringBuilder sb = new StringBuilder(40);
        sb.append("bytes ");
        sb.append(this.first);
        sb.append('-');
        sb.append(this.last);
        sb.append("/");
        sb.append(size);
        return sb.toString();
    }

    public int hashCode() {
        return (int) (this.first ^ this.last);
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof InclusiveByteRange) && ((InclusiveByteRange) obj).first == this.first && ((InclusiveByteRange) obj).last == this.last;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(60);
        sb.append(this.first);
        sb.append(EmitterKt.COMMENT_PREFIX);
        sb.append(this.last);
        return sb.toString();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:84:0x01bf */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [long] */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3, types: [long] */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r18v12 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<org.eclipse.jetty.server.InclusiveByteRange> satisfiableRanges(java.util.Enumeration<java.lang.String> r7, long r8) {
        /*
        // Method dump skipped, instructions count: 540
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.InclusiveByteRange.satisfiableRanges(java.util.Enumeration, long):java.util.List");
    }

    public static String to416HeaderRangeString(long size) {
        StringBuilder sb = new StringBuilder(40);
        sb.append("bytes */");
        sb.append(size);
        return sb.toString();
    }
}
