package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.cache.DiskLruCache;
import org.jetbrains.annotations.NotNull;

/* compiled from: DiskLruCache.kt */
/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 48, m374d1 = {"��\u000e\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m373d2 = {"<anonymous>", "", "it", "Ljava/io/IOException;", "invoke"})
/* loaded from: grasscutter.jar:okhttp3/internal/cache/DiskLruCache$Editor$newSink$1$1.class */
public final class DiskLruCache$Editor$newSink$1$1 extends Lambda implements Function1<IOException, Unit> {
    final /* synthetic */ DiskLruCache this$0;
    final /* synthetic */ DiskLruCache.Editor this$1;

    /* access modifiers changed from: package-private */
    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public DiskLruCache$Editor$newSink$1$1(DiskLruCache $receiver, DiskLruCache.Editor $receiver2) {
        super(1);
        this.this$0 = $receiver;
        this.this$1 = $receiver2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IOException iOException) {
        invoke(iOException);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull IOException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        DiskLruCache diskLruCache = this.this$0;
        DiskLruCache.Editor editor = this.this$1;
        synchronized (diskLruCache) {
            editor.detach$okhttp();
            Unit unit = Unit.INSTANCE;
        }
    }
}
