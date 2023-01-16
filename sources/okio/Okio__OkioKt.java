package okio;

import java.io.Closeable;
import kotlin.Exceptions;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Okio.kt */
/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 5, 1}, m372k = 5, m369xi = 48, m374d1 = {"��,\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010��\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0005*\u00020\u0006\u001aA\u0010\u0007\u001a\u0002H\b\"\u0010\b��\u0010\t*\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b\"\u0004\b\u0001\u0010\b*\u0002H\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\b0\rH\bø\u0001��¢\u0006\u0002\u0010\u000e\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000f"}, m373d2 = {"blackholeSink", "Lokio/Sink;", "blackhole", "buffer", "Lokio/BufferedSink;", "Lokio/BufferedSource;", "Lokio/Source;", "use", "R", "T", "Ljava/io/Closeable;", "Lokio/Closeable;", "block", "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "okio"}, m368xs = "okio/Okio")
/* loaded from: grasscutter.jar:okio/Okio__OkioKt.class */
public final /* synthetic */ class Okio__OkioKt {
    @NotNull
    public static final BufferedSource buffer(@NotNull Source $this$buffer) {
        Intrinsics.checkNotNullParameter($this$buffer, "<this>");
        return new RealBufferedSource($this$buffer);
    }

    @NotNull
    public static final BufferedSink buffer(@NotNull Sink $this$buffer) {
        Intrinsics.checkNotNullParameter($this$buffer, "<this>");
        return new RealBufferedSink($this$buffer);
    }

    @JvmName(name = "blackhole")
    @NotNull
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends Closeable, R> R use(T t, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        R r = null;
        Throwable thrown = null;
        try {
            r = function1.invoke(t);
        } catch (Throwable t2) {
            thrown = t2;
        }
        if (t != null) {
            try {
                t.close();
            } catch (Throwable t3) {
                if (thrown == null) {
                    thrown = t3;
                } else {
                    Exceptions.addSuppressed(thrown, t3);
                }
            }
        }
        if (thrown != null) {
            throw thrown;
        }
        Intrinsics.checkNotNull(r);
        return r;
    }
}
