package okhttp3.internal.platform.android;

import dev.morphia.mapping.Mapper;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import org.jetbrains.annotations.NotNull;

/* compiled from: AndroidSocketAdapter.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001d\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��*\u0001��\b\n\u0018��2\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, m373d2 = {"okhttp3/internal/platform/android/AndroidSocketAdapter$Companion$factory$1", "Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "create", "Lokhttp3/internal/platform/android/SocketAdapter;", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "matchesSocket", "", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/platform/android/AndroidSocketAdapter$Companion$factory$1.class */
public final class AndroidSocketAdapter$Companion$factory$1 implements DeferredSocketAdapter.Factory {
    final /* synthetic */ String $packageName;

    /* access modifiers changed from: package-private */
    public AndroidSocketAdapter$Companion$factory$1(String $packageName) {
        this.$packageName = $packageName;
    }

    @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
    public boolean matchesSocket(@NotNull SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        String name = sslSocket.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "sslSocket.javaClass.name");
        return StringsKt.startsWith$default(name, Intrinsics.stringPlus(this.$packageName, Mapper.IGNORED_FIELDNAME), false, 2, (Object) null);
    }

    @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
    @NotNull
    public SocketAdapter create(@NotNull SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return AndroidSocketAdapter.Companion.build(sslSocket.getClass());
    }
}
