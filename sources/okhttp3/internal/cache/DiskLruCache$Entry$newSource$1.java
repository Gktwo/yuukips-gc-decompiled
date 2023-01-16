package okhttp3.internal.cache;

import kotlin.Metadata;
import kotlin.Unit;
import okhttp3.internal.cache.DiskLruCache;
import okio.ForwardingSource;
import okio.Source;

/* compiled from: DiskLruCache.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0017\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0010\u0002\n��*\u0001��\b\n\u0018��2\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n��¨\u0006\u0006"}, m373d2 = {"okhttp3/internal/cache/DiskLruCache$Entry$newSource$1", "Lokio/ForwardingSource;", "closed", "", "close", "", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/cache/DiskLruCache$Entry$newSource$1.class */
public final class DiskLruCache$Entry$newSource$1 extends ForwardingSource {
    private boolean closed;
    final /* synthetic */ Source $fileSource;
    final /* synthetic */ DiskLruCache this$0;
    final /* synthetic */ DiskLruCache.Entry this$1;

    /* access modifiers changed from: package-private */
    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public DiskLruCache$Entry$newSource$1(Source $fileSource, DiskLruCache $receiver, DiskLruCache.Entry $receiver2) {
        super($fileSource);
        this.$fileSource = $fileSource;
        this.this$0 = $receiver;
        this.this$1 = $receiver2;
    }

    @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close();
        if (!this.closed) {
            this.closed = true;
            DiskLruCache diskLruCache = this.this$0;
            DiskLruCache.Entry entry = this.this$1;
            DiskLruCache diskLruCache2 = this.this$0;
            synchronized (diskLruCache) {
                entry.setLockingSourceCount$okhttp(entry.getLockingSourceCount$okhttp() - 1);
                if (entry.getLockingSourceCount$okhttp() == 0 && entry.getZombie$okhttp()) {
                    diskLruCache2.removeEntry$okhttp(entry);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
