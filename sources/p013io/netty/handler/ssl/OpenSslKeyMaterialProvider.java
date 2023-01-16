package p013io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLException;
import javax.net.ssl.X509KeyManager;
import p013io.netty.buffer.ByteBufAllocator;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.handler.ssl.OpenSslKeyMaterialProvider */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslKeyMaterialProvider.class */
public class OpenSslKeyMaterialProvider {
    private final X509KeyManager keyManager;
    private final String password;

    /* access modifiers changed from: package-private */
    public OpenSslKeyMaterialProvider(X509KeyManager keyManager, String password) {
        this.keyManager = keyManager;
        this.password = password;
    }

    /* access modifiers changed from: package-private */
    public static void validateKeyMaterialSupported(X509Certificate[] keyCertChain, PrivateKey key, String keyPassword) throws SSLException {
        validateSupported(keyCertChain);
        validateSupported(key, keyPassword);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x000a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [long] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [long] */
    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    /* JADX WARN: Type inference failed for: r9v2, types: [long] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void validateSupported(java.security.PrivateKey r5, java.lang.String r6) throws javax.net.ssl.SSLException {
        /*
            r0 = r5
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r7 = r0
            r0 = 0
            r9 = r0
            io.netty.buffer.UnpooledByteBufAllocator r0 = p013io.netty.buffer.UnpooledByteBufAllocator.DEFAULT     // Catch: Exception -> 0x002c, all -> 0x0050
            r1 = r5
            long r0 = p013io.netty.handler.ssl.ReferenceCountedOpenSslContext.toBIO(r0, r1)     // Catch: Exception -> 0x002c, all -> 0x0050
            r7 = r0
            r0 = r7
            r1 = r6
            long r0 = io.netty.internal.tcnative.SSL.parsePrivateKey(r0, r1)     // Catch: Exception -> 0x002c, all -> 0x0050
            r9 = r0
            r0 = r7
            io.netty.internal.tcnative.SSL.freeBIO(r0)
            r0 = r9
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0065
            r0 = r9
            io.netty.internal.tcnative.SSL.freePrivateKey(r0)
            goto L_0x0065
        L_0x002c:
            r11 = move-exception
            javax.net.ssl.SSLException r0 = new javax.net.ssl.SSLException     // Catch: all -> 0x0050
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: all -> 0x0050
            r3 = r2
            r3.<init>()     // Catch: all -> 0x0050
            java.lang.String r3 = "PrivateKey type not supported "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: all -> 0x0050
            r3 = r5
            java.lang.String r3 = r3.getFormat()     // Catch: all -> 0x0050
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: all -> 0x0050
            java.lang.String r2 = r2.toString()     // Catch: all -> 0x0050
            r3 = r11
            r1.<init>(r2, r3)     // Catch: all -> 0x0050
            throw r0     // Catch: all -> 0x0050
        L_0x0050:
            r12 = move-exception
            r0 = r7
            io.netty.internal.tcnative.SSL.freeBIO(r0)
            r0 = r9
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0062
            r0 = r9
            io.netty.internal.tcnative.SSL.freePrivateKey(r0)
        L_0x0062:
            r0 = r12
            throw r0
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.ssl.OpenSslKeyMaterialProvider.validateSupported(java.security.PrivateKey, java.lang.String):void");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0011 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [long] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [long] */
    /* JADX WARN: Type inference failed for: r0v20, types: [long] */
    /* JADX WARN: Type inference failed for: r8v3, types: [long] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void validateSupported(java.security.cert.X509Certificate[] r5) throws javax.net.ssl.SSLException {
        /*
            r0 = r5
            if (r0 == 0) goto L_0x0009
            r0 = r5
            int r0 = r0.length
            if (r0 != 0) goto L_0x000a
        L_0x0009:
            return
        L_0x000a:
            r0 = 0
            r6 = r0
            r0 = 0
            r8 = r0
            r0 = 0
            r10 = r0
            io.netty.buffer.UnpooledByteBufAllocator r0 = p013io.netty.buffer.UnpooledByteBufAllocator.DEFAULT     // Catch: Exception -> 0x004c, all -> 0x005a
            r1 = 1
            r2 = r5
            io.netty.handler.ssl.PemEncoded r0 = p013io.netty.handler.ssl.PemX509Certificate.toPEM(r0, r1, r2)     // Catch: Exception -> 0x004c, all -> 0x005a
            r10 = r0
            io.netty.buffer.UnpooledByteBufAllocator r0 = p013io.netty.buffer.UnpooledByteBufAllocator.DEFAULT     // Catch: Exception -> 0x004c, all -> 0x005a
            r1 = r10
            io.netty.handler.ssl.PemEncoded r1 = r1.retain()     // Catch: Exception -> 0x004c, all -> 0x005a
            long r0 = p013io.netty.handler.ssl.ReferenceCountedOpenSslContext.toBIO(r0, r1)     // Catch: Exception -> 0x004c, all -> 0x005a
            r6 = r0
            r0 = r6
            long r0 = io.netty.internal.tcnative.SSL.parseX509Chain(r0)     // Catch: Exception -> 0x004c, all -> 0x005a
            r8 = r0
            r0 = r6
            io.netty.internal.tcnative.SSL.freeBIO(r0)
            r0 = r8
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x003c
            r0 = r8
            io.netty.internal.tcnative.SSL.freeX509Chain(r0)
        L_0x003c:
            r0 = r10
            if (r0 == 0) goto L_0x007a
            r0 = r10
            boolean r0 = r0.release()
            goto L_0x007a
        L_0x004c:
            r11 = move-exception
            javax.net.ssl.SSLException r0 = new javax.net.ssl.SSLException     // Catch: all -> 0x005a
            r1 = r0
            java.lang.String r2 = "Certificate type not supported"
            r3 = r11
            r1.<init>(r2, r3)     // Catch: all -> 0x005a
            throw r0     // Catch: all -> 0x005a
        L_0x005a:
            r12 = move-exception
            r0 = r6
            io.netty.internal.tcnative.SSL.freeBIO(r0)
            r0 = r8
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x006a
            r0 = r8
            io.netty.internal.tcnative.SSL.freeX509Chain(r0)
        L_0x006a:
            r0 = r10
            if (r0 == 0) goto L_0x0077
            r0 = r10
            boolean r0 = r0.release()
        L_0x0077:
            r0 = r12
            throw r0
        L_0x007a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.ssl.OpenSslKeyMaterialProvider.validateSupported(java.security.cert.X509Certificate[]):void");
    }

    /* access modifiers changed from: package-private */
    public X509KeyManager keyManager() {
        return this.keyManager;
    }

    /* JADX WARN: Type inference failed for: r0v49, types: [long] */
    /* access modifiers changed from: package-private */
    public OpenSslKeyMaterial chooseKeyMaterial(ByteBufAllocator allocator, String alias) throws Exception {
        OpenSslKeyMaterial keyMaterial;
        X509Certificate[] certificates = this.keyManager.getCertificateChain(alias);
        if (certificates == null || certificates.length == 0) {
            return null;
        }
        PrivateKey key = this.keyManager.getPrivateKey(alias);
        PemEncoded encoded = PemX509Certificate.toPEM(allocator, true, certificates);
        long chainBio = 0;
        char c = 0;
        long chain = 0;
        long pkey = 0;
        try {
            chainBio = ReferenceCountedOpenSslContext.toBIO(allocator, encoded.retain());
            long chain2 = SSL.parseX509Chain(chainBio);
            if (key instanceof OpenSslPrivateKey) {
                keyMaterial = ((OpenSslPrivateKey) key).newKeyMaterial(chain2, certificates);
            } else {
                c = ReferenceCountedOpenSslContext.toBIO(allocator, key);
                keyMaterial = new DefaultOpenSslKeyMaterial(chain2, key == null ? 0 : SSL.parsePrivateKey(c, this.password), certificates);
            }
            chain = 0;
            pkey = 0;
            return keyMaterial;
        } finally {
            SSL.freeBIO(chainBio);
            SSL.freeBIO(0);
            if (chain != 0) {
                SSL.freeX509Chain(chain);
            }
            if (pkey != 0) {
                SSL.freePrivateKey(pkey);
            }
            encoded.release();
        }
    }

    /* access modifiers changed from: package-private */
    public void destroy() {
    }
}
