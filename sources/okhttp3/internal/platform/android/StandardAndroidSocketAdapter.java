package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StandardAndroidSocketAdapter.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018�� \u000e2\u00020\u0001:\u0001\u000eB1\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b��\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b��\u0012\u00020\u00060\u0003\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u0012\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\u0002\n��R\u0016\u0010\u0005\u001a\n\u0012\u0006\b��\u0012\u00020\u00060\u0003X\u0004¢\u0006\u0002\n��¨\u0006\u000f"}, m373d2 = {"Lokhttp3/internal/platform/android/StandardAndroidSocketAdapter;", "Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "sslSocketClass", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "sslSocketFactoryClass", "Ljavax/net/ssl/SSLSocketFactory;", "paramClass", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V", "matchesSocketFactory", "", "sslSocketFactory", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/platform/android/StandardAndroidSocketAdapter.class */
public final class StandardAndroidSocketAdapter extends AndroidSocketAdapter {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Class<? super SSLSocketFactory> sslSocketFactoryClass;
    @NotNull
    private final Class<?> paramClass;

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public StandardAndroidSocketAdapter(@NotNull Class<? super SSLSocket> cls, @NotNull Class<? super SSLSocketFactory> cls2, @NotNull Class<?> cls3) {
        super(cls);
        Intrinsics.checkNotNullParameter(cls, "sslSocketClass");
        Intrinsics.checkNotNullParameter(cls2, "sslSocketFactoryClass");
        Intrinsics.checkNotNullParameter(cls3, "paramClass");
        this.sslSocketFactoryClass = cls2;
        this.paramClass = cls3;
    }

    @Override // okhttp3.internal.platform.android.AndroidSocketAdapter, okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocketFactory(@NotNull SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
        return this.sslSocketFactoryClass.isInstance(sslSocketFactory);
    }

    @Override // okhttp3.internal.platform.android.AndroidSocketAdapter, okhttp3.internal.platform.android.SocketAdapter
    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
        Object context = Util.readFieldOrNull(sslSocketFactory, this.paramClass, "sslParameters");
        Intrinsics.checkNotNull(context);
        X509TrustManager x509TrustManager = (X509TrustManager) Util.readFieldOrNull(context, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager == null ? (X509TrustManager) Util.readFieldOrNull(context, X509TrustManager.class, "trustManager") : x509TrustManager;
    }

    /* compiled from: StandardAndroidSocketAdapter.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0018\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m373d2 = {"Lokhttp3/internal/platform/android/StandardAndroidSocketAdapter$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/android/SocketAdapter;", "packageName", "", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/platform/android/StandardAndroidSocketAdapter$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ SocketAdapter buildIfSupported$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return companion.buildIfSupported(str);
        }

        @Nullable
        public final SocketAdapter buildIfSupported(@NotNull String packageName) {
            SocketAdapter socketAdapter;
            Class sslSocketClass;
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            try {
                sslSocketClass = Class.forName(Intrinsics.stringPlus(packageName, ".OpenSSLSocketImpl"));
            } catch (Exception e) {
                Platform.Companion.get().log("unable to load android socket classes", 5, e);
                socketAdapter = null;
            }
            if (sslSocketClass == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocket>");
            }
            Class sslSocketFactoryClass = Class.forName(Intrinsics.stringPlus(packageName, ".OpenSSLSocketFactoryImpl"));
            if (sslSocketFactoryClass == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocketFactory>");
            }
            Class paramsClass = Class.forName(Intrinsics.stringPlus(packageName, ".SSLParametersImpl"));
            Intrinsics.checkNotNullExpressionValue(paramsClass, "paramsClass");
            socketAdapter = new StandardAndroidSocketAdapter(sslSocketClass, sslSocketFactoryClass, paramsClass);
            return socketAdapter;
        }
    }
}
