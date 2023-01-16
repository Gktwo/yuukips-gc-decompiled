package p013io.netty.handler.ssl;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.net.ssl.X509KeyManager;
import p013io.netty.buffer.ByteBufAllocator;

/* renamed from: io.netty.handler.ssl.OpenSslCachingKeyMaterialProvider */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslCachingKeyMaterialProvider.class */
final class OpenSslCachingKeyMaterialProvider extends OpenSslKeyMaterialProvider {
    private final int maxCachedEntries;
    private volatile boolean full;
    private final ConcurrentMap<String, OpenSslKeyMaterial> cache = new ConcurrentHashMap();

    /* access modifiers changed from: package-private */
    public OpenSslCachingKeyMaterialProvider(X509KeyManager keyManager, String password, int maxCachedEntries) {
        super(keyManager, password);
        this.maxCachedEntries = maxCachedEntries;
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.netty.handler.ssl.OpenSslKeyMaterialProvider
    public OpenSslKeyMaterial chooseKeyMaterial(ByteBufAllocator allocator, String alias) throws Exception {
        OpenSslKeyMaterial material = this.cache.get(alias);
        if (material == null) {
            material = chooseKeyMaterial(allocator, alias);
            if (material == null) {
                return null;
            }
            if (this.full) {
                return material;
            }
            if (this.cache.size() > this.maxCachedEntries) {
                this.full = true;
                return material;
            }
            OpenSslKeyMaterial old = this.cache.putIfAbsent(alias, material);
            if (old != null) {
                material.release();
                material = old;
            }
        }
        return material.retain();
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.netty.handler.ssl.OpenSslKeyMaterialProvider
    public void destroy() {
        do {
            Iterator<OpenSslKeyMaterial> iterator = this.cache.values().iterator();
            while (iterator.hasNext()) {
                iterator.next().release();
                iterator.remove();
            }
        } while (!this.cache.isEmpty());
    }
}
