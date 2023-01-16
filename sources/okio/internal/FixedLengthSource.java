package okio.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.implementation.MethodDelegation;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;
import org.jetbrains.annotations.NotNull;

/* compiled from: FixedLengthSource.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n��\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b��\u0018��2\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002R\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n��¨\u0006\u0011"}, m373d2 = {"Lokio/internal/FixedLengthSource;", "Lokio/ForwardingSource;", MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX, "Lokio/Source;", "size", "", "truncate", "", "(Lokio/Source;JZ)V", "bytesReceived", "read", "sink", "Lokio/Buffer;", "byteCount", "truncateToSize", "", "newSize", "okio"})
/* loaded from: grasscutter.jar:okio/internal/FixedLengthSource.class */
public final class FixedLengthSource extends ForwardingSource {
    private final long size;
    private final boolean truncate;
    private long bytesReceived;

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public FixedLengthSource(@NotNull Source delegate, long size, boolean truncate) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.size = size;
        this.truncate = truncate;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // okio.ForwardingSource, okio.Source
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long read(@org.jetbrains.annotations.NotNull okio.Buffer r10, long r11) {
        /*
        // Method dump skipped, instructions count: 217
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.FixedLengthSource.read(okio.Buffer, long):long");
    }

    private final void truncateToSize(Buffer $this$truncateToSize, long newSize) {
        Buffer scratch = new Buffer();
        scratch.writeAll($this$truncateToSize);
        $this$truncateToSize.write(scratch, newSize);
        scratch.clear();
    }
}
