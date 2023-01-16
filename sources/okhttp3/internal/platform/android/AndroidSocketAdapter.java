package okhttp3.internal.platform.android;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.platform.AndroidPlatform;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AndroidSocketAdapter.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n��\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018�� \u00182\u00020\u0001:\u0001\u0018B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b��\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u0004H\u0016R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n��R\u0016\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n��R\u0016\u0010\n\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n��R\u000e\u0010\u000b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n��R\u0016\u0010\u0002\u001a\n\u0012\u0006\b��\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n��¨\u0006\u0019"}, m373d2 = {"Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "Lokhttp3/internal/platform/android/SocketAdapter;", "sslSocketClass", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "(Ljava/lang/Class;)V", "getAlpnSelectedProtocol", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "setAlpnProtocols", "setHostname", "setUseSessionTickets", "configureTlsExtensions", "", "sslSocket", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "isSupported", "", "matchesSocket", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/platform/android/AndroidSocketAdapter.class */
public class AndroidSocketAdapter implements SocketAdapter {
    @NotNull
    private final Class<? super SSLSocket> sslSocketClass;
    @NotNull
    private final Method setUseSessionTickets;
    private final Method setHostname;
    private final Method getAlpnSelectedProtocol;
    private final Method setAlpnProtocols;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final DeferredSocketAdapter.Factory playProviderFactory = Companion.factory("com.google.android.gms.org.conscrypt");

    public AndroidSocketAdapter(@NotNull Class<? super SSLSocket> cls) {
        Intrinsics.checkNotNullParameter(cls, "sslSocketClass");
        this.sslSocketClass = cls;
        Method declaredMethod = this.sslSocketClass.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        Intrinsics.checkNotNullExpressionValue(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.setUseSessionTickets = declaredMethod;
        this.setHostname = this.sslSocketClass.getMethod("setHostname", String.class);
        this.getAlpnSelectedProtocol = this.sslSocketClass.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.setAlpnProtocols = this.sslSocketClass.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory sslSocketFactory) {
        return SocketAdapter.DefaultImpls.trustManager(this, sslSocketFactory);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocketFactory(@NotNull SSLSocketFactory sslSocketFactory) {
        return SocketAdapter.DefaultImpls.matchesSocketFactory(this, sslSocketFactory);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean isSupported() {
        return AndroidPlatform.Companion.isSupported();
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(@NotNull SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return this.sslSocketClass.isInstance(sslSocket);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
        jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:4:0x0014
        	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:232)
        	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:54)
        */
    @Override // okhttp3.internal.platform.android.SocketAdapter
    public void configureTlsExtensions(@org.jetbrains.annotations.NotNull javax.net.ssl.SSLSocket r8, @org.jetbrains.annotations.Nullable java.lang.String r9, @org.jetbrains.annotations.NotNull java.util.List<? extends okhttp3.Protocol> r10) {
        /*
            r7 = this;
            r0 = r8
            java.lang.String r1 = "sslSocket"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r10
            java.lang.String r1 = "protocols"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r7
            r1 = r8
            boolean r0 = r0.matchesSocket(r1)
            if (r0 == 0) goto L_0x007f
            r0 = r7
            java.lang.reflect.Method r0 = r0.setUseSessionTickets     // Catch: IllegalAccessException -> 0x0067, InvocationTargetException -> 0x0073
            r1 = r8
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: IllegalAccessException -> 0x0067, InvocationTargetException -> 0x0073
            r11 = r2
            r2 = r11
            r3 = 0
            r4 = 1
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch: IllegalAccessException -> 0x0067, InvocationTargetException -> 0x0073
            r2[r3] = r4     // Catch: IllegalAccessException -> 0x0067, InvocationTargetException -> 0x0073
            r2 = r11
            java.lang.Object r0 = r0.invoke(r1, r2)     // Catch: IllegalAccessException -> 0x0067, InvocationTargetException -> 0x0073
            r0 = r9
            if (r0 == 0) goto L_0x0048
            r0 = r7
            java.lang.reflect.Method r0 = r0.setHostname     // Catch: IllegalAccessException -> 0x0067, InvocationTargetException -> 0x0073
            r1 = r8
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: IllegalAccessException -> 0x0067, InvocationTargetException -> 0x0073
            r11 = r2
            r2 = r11
            r3 = 0
            r4 = r9
            r2[r3] = r4     // Catch: IllegalAccessException -> 0x0067, InvocationTargetException -> 0x0073
            r2 = r11
            java.lang.Object r0 = r0.invoke(r1, r2)     // Catch: IllegalAccessException -> 0x0067, InvocationTargetException -> 0x0073
        L_0x0048:
            r0 = r7
            java.lang.reflect.Method r0 = r0.setAlpnProtocols     // Catch: IllegalAccessException -> 0x0067, InvocationTargetException -> 0x0073
            r1 = r8
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: IllegalAccessException -> 0x0067, InvocationTargetException -> 0x0073
            r11 = r2
            r2 = r11
            r3 = 0
            okhttp3.internal.platform.Platform$Companion r4 = okhttp3.internal.platform.Platform.Companion     // Catch: IllegalAccessException -> 0x0067, InvocationTargetException -> 0x0073
            r5 = r10
            byte[] r4 = r4.concatLengthPrefixed(r5)     // Catch: IllegalAccessException -> 0x0067, InvocationTargetException -> 0x0073
            r2[r3] = r4     // Catch: IllegalAccessException -> 0x0067, InvocationTargetException -> 0x0073
            r2 = r11
            java.lang.Object r0 = r0.invoke(r1, r2)     // Catch: IllegalAccessException -> 0x0067, InvocationTargetException -> 0x0073
            goto L_0x007f
        L_0x0067:
            r11 = move-exception
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r1 = r0
            r2 = r11
            r1.<init>(r2)
            throw r0
        L_0x0073:
            r11 = move-exception
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r1 = r0
            r2 = r11
            r1.<init>(r2)
            throw r0
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.android.AndroidSocketAdapter.configureTlsExtensions(javax.net.ssl.SSLSocket, java.lang.String, java.util.List):void");
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sslSocket) {
        String str;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        if (!matchesSocket(sslSocket)) {
            return null;
        }
        try {
            byte[] alpnResult = (byte[]) this.getAlpnSelectedProtocol.invoke(sslSocket, new Object[0]);
            str = alpnResult == null ? null : new String(alpnResult, Charsets.UTF_8);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (!(cause instanceof NullPointerException) || !Intrinsics.areEqual(((NullPointerException) cause).getMessage(), "ssl == null")) {
                throw new AssertionError(e2);
            }
            str = null;
        }
        return str;
    }

    /* compiled from: AndroidSocketAdapter.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��,\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\b��\u0012\u00020\u000b0\nH\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m373d2 = {"Lokhttp3/internal/platform/android/AndroidSocketAdapter$Companion;", "", "()V", "playProviderFactory", "Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "getPlayProviderFactory", "()Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "actualSSLSocketClass", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "factory", "packageName", "", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/platform/android/AndroidSocketAdapter$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final DeferredSocketAdapter.Factory getPlayProviderFactory() {
            return AndroidSocketAdapter.playProviderFactory;
        }

        /* access modifiers changed from: private */
        public final AndroidSocketAdapter build(Class<? super SSLSocket> cls) {
            Class possibleClass = cls;
            while (possibleClass != null && !Intrinsics.areEqual(possibleClass.getSimpleName(), "OpenSSLSocketImpl")) {
                possibleClass = possibleClass.getSuperclass();
                if (possibleClass == null) {
                    throw new AssertionError(Intrinsics.stringPlus("No OpenSSLSocketImpl superclass of socket of type ", cls));
                }
            }
            Intrinsics.checkNotNull(possibleClass);
            return new AndroidSocketAdapter(possibleClass);
        }

        @NotNull
        public final DeferredSocketAdapter.Factory factory(@NotNull String packageName) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            return new AndroidSocketAdapter$Companion$factory$1(packageName);
        }
    }
}
