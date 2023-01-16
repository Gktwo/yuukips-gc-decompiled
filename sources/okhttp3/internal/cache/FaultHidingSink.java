package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.implementation.MethodDelegation;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;
import org.jetbrains.annotations.NotNull;

/* compiled from: FaultHidingSink.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��4\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n��\b\u0010\u0018��2\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n��R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, m373d2 = {"Lokhttp3/internal/cache/FaultHidingSink;", "Lokio/ForwardingSink;", MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX, "Lokio/Sink;", "onException", "Lkotlin/Function1;", "Ljava/io/IOException;", "", "(Lokio/Sink;Lkotlin/jvm/functions/Function1;)V", "hasErrors", "", "getOnException", "()Lkotlin/jvm/functions/Function1;", "close", "flush", "write", "source", "Lokio/Buffer;", "byteCount", "", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/cache/FaultHidingSink.class */
public class FaultHidingSink extends ForwardingSink {
    @NotNull
    private final Function1<IOException, Unit> onException;
    private boolean hasErrors;

    @NotNull
    public final Function1<IOException, Unit> getOnException() {
        return this.onException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super java.io.IOException, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public FaultHidingSink(@NotNull Sink delegate, @NotNull Function1<? super IOException, Unit> function1) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        Intrinsics.checkNotNullParameter(function1, "onException");
        this.onException = function1;
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(@NotNull Buffer source, long byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.hasErrors) {
            source.skip(byteCount);
            return;
        }
        try {
            write(source, byteCount);
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke(e);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
    public void flush() {
        if (!this.hasErrors) {
            try {
                flush();
            } catch (IOException e) {
                this.hasErrors = true;
                this.onException.invoke(e);
            }
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.hasErrors) {
            try {
                close();
            } catch (IOException e) {
                this.hasErrors = true;
                this.onException.invoke(e);
            }
        }
    }
}
