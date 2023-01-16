package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import okhttp3.internal.concurrent.Task;
import okio.Okio;

/* compiled from: DiskLruCache.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0011\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n��*\u0001��\b\n\u0018��2\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m373d2 = {"okhttp3/internal/cache/DiskLruCache$cleanupTask$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/cache/DiskLruCache$cleanupTask$1.class */
public final class DiskLruCache$cleanupTask$1 extends Task {
    final /* synthetic */ DiskLruCache this$0;

    /* access modifiers changed from: package-private */
    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public DiskLruCache$cleanupTask$1(DiskLruCache $receiver, String $super_call_param$1) {
        super($super_call_param$1, false, 2, null);
        this.this$0 = $receiver;
    }

    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        DiskLruCache diskLruCache = this.this$0;
        DiskLruCache diskLruCache2 = this.this$0;
        synchronized (diskLruCache) {
            if (!(diskLruCache2.initialized) || diskLruCache2.getClosed$okhttp()) {
                return -1;
            }
            try {
                diskLruCache2.trimToSize();
            } catch (IOException e) {
                diskLruCache2.mostRecentTrimFailed = true;
            }
            try {
                if (diskLruCache2.journalRebuildRequired()) {
                    diskLruCache2.rebuildJournal$okhttp();
                    diskLruCache2.redundantOpCount = 0;
                }
            } catch (IOException e2) {
                diskLruCache2.mostRecentRebuildFailed = true;
                diskLruCache2.journalWriter = Okio.buffer(Okio.blackhole());
            }
            return -1;
        }
    }
}
