package p013io.javalin.plugin.json;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: PipedStreamUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u001d\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n��*\u0001��\b\n\u0018��2\u00020\u0001J\b\u0010\t\u001a\u00020\nH\u0016R\"\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, m373d2 = {"io/javalin/plugin/json/PipedStreamUtil$getInputStream$pipedInputStream$1", "Ljava/io/PipedInputStream;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getException", "()Ljava/lang/Exception;", "setException", "(Ljava/lang/Exception;)V", "close", "", "javalin"})
/* renamed from: io.javalin.plugin.json.PipedStreamUtil$getInputStream$pipedInputStream$1 */
/* loaded from: grasscutter.jar:io/javalin/plugin/json/PipedStreamUtil$getInputStream$pipedInputStream$1.class */
public final class PipedStreamUtil$getInputStream$pipedInputStream$1 extends PipedInputStream {
    @Nullable
    private Exception exception;
    final /* synthetic */ PipedOutputStream $pipedOutputStream;

    /* access modifiers changed from: package-private */
    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public PipedStreamUtil$getInputStream$pipedInputStream$1(PipedOutputStream $pipedOutputStream) {
        super($pipedOutputStream);
        this.$pipedOutputStream = $pipedOutputStream;
    }

    @Nullable
    public final Exception getException() {
        return this.exception;
    }

    public final void setException(@Nullable Exception exc) {
        this.exception = exc;
    }

    @Override // java.io.PipedInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() {
        Exception it = this.exception;
        if (it == null) {
            close();
            return;
        }
        throw it;
    }
}
