package okio;

import java.io.IOException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.implementation.MethodDelegation;
import org.jetbrains.annotations.NotNull;
import org.jline.console.Printer;

/* compiled from: ForwardingSource.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\b&\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\r\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0013\u0010\u0002\u001a\u00020\u00018\u0007¢\u0006\b\n��\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0011"}, m373d2 = {"Lokio/ForwardingSource;", "Lokio/Source;", MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX, "(Lokio/Source;)V", "()Lokio/Source;", "close", "", "-deprecated_delegate", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", Printer.TO_STRING, "", "okio"})
/* loaded from: grasscutter.jar:okio/ForwardingSource.class */
public abstract class ForwardingSource implements Source {
    @NotNull
    private final Source delegate;

    public ForwardingSource(@NotNull Source delegate) {
        Intrinsics.checkNotNullParameter(delegate, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.delegate = delegate;
    }

    @JvmName(name = MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX)
    @NotNull
    public final Source delegate() {
        return this.delegate;
    }

    @Override // okio.Source
    public long read(@NotNull Buffer sink, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return this.delegate.read(sink, byteCount);
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.String : 0x000b: INVOKE  (r1v3 java.lang.String A[REMOVE]) = 
      (wrap: java.lang.Class<?> : 0x0008: INVOKE  (r1v2 java.lang.Class<?> A[REMOVE]) = (r3v0 'this' okio.ForwardingSource A[D('this' okio.ForwardingSource), IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: java.lang.Object.getClass():java.lang.Class)
     type: VIRTUAL call: java.lang.Class.getSimpleName():java.lang.String)), ('(' char), (wrap: okio.Source : 0x0017: IGET  (r1v6 okio.Source A[REMOVE]) = (r3v0 'this' okio.ForwardingSource A[D('this' okio.ForwardingSource), IMMUTABLE_TYPE, THIS]) okio.ForwardingSource.delegate okio.Source), (')' char)] */
    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return new StringBuilder().append((Object) getClass().getSimpleName()).append('(').append(this.delegate).append(')').toString();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "delegate", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_delegate")
    @NotNull
    /* renamed from: -deprecated_delegate  reason: not valid java name */
    public final Source m9392deprecated_delegate() {
        return this.delegate;
    }
}
