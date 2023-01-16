package okhttp3;

import java.security.cert.Certificate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Handshake.kt */
/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 48, m374d1 = {"��\f\n��\n\u0002\u0010 \n\u0002\u0018\u0002\n��\u0010��\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, m373d2 = {"<anonymous>", "", "Ljava/security/cert/Certificate;", "invoke"})
/* loaded from: grasscutter.jar:okhttp3/Handshake$Companion$handshake$1.class */
public final class Handshake$Companion$handshake$1 extends Lambda implements Function0<List<? extends Certificate>> {
    final /* synthetic */ List<Certificate> $peerCertificatesCopy;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends java.security.cert.Certificate> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public Handshake$Companion$handshake$1(List<? extends Certificate> list) {
        super(0);
        this.$peerCertificatesCopy = list;
    }

    /* Return type fixed from 'java.util.List<java.security.cert.Certificate>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final List<? extends Certificate> invoke() {
        return this.$peerCertificatesCopy;
    }
}
