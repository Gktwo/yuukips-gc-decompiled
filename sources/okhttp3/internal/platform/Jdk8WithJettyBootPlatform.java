package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.quartz.jobs.p027ee.ejb.EJBInvokerJob;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: Jdk8WithJettyBootPlatform.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n��\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018�� \u00162\u00020\u0001:\u0002\u0015\u0016B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\rH\u0016R\u0012\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u0012\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0004¢\u0006\u0002\n��¨\u0006\u0017"}, m373d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform;", "Lokhttp3/internal/platform/Platform;", "putMethod", "Ljava/lang/reflect/Method;", "getMethod", "removeMethod", "clientProviderClass", "Ljava/lang/Class;", "serverProviderClass", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V", "afterHandshake", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "configureTlsExtensions", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "AlpnProvider", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/platform/Jdk8WithJettyBootPlatform.class */
public final class Jdk8WithJettyBootPlatform extends Platform {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Method putMethod;
    @NotNull
    private final Method getMethod;
    @NotNull
    private final Method removeMethod;
    @NotNull
    private final Class<?> clientProviderClass;
    @NotNull
    private final Class<?> serverProviderClass;

    public Jdk8WithJettyBootPlatform(@NotNull Method putMethod, @NotNull Method getMethod, @NotNull Method removeMethod, @NotNull Class<?> cls, @NotNull Class<?> cls2) {
        Intrinsics.checkNotNullParameter(putMethod, "putMethod");
        Intrinsics.checkNotNullParameter(getMethod, "getMethod");
        Intrinsics.checkNotNullParameter(removeMethod, "removeMethod");
        Intrinsics.checkNotNullParameter(cls, "clientProviderClass");
        Intrinsics.checkNotNullParameter(cls2, "serverProviderClass");
        this.putMethod = putMethod;
        this.getMethod = getMethod;
        this.removeMethod = removeMethod;
        this.clientProviderClass = cls;
        this.serverProviderClass = cls2;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(@NotNull SSLSocket sslSocket, @Nullable String hostname, @NotNull List<? extends Protocol> list) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(list, "protocols");
        try {
            this.putMethod.invoke(null, sslSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new AlpnProvider(Platform.Companion.alpnProtocolNames(list))));
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to set ALPN", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to set ALPN", e2);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void afterHandshake(@NotNull SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        try {
            this.removeMethod.invoke(null, sslSocket);
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to remove ALPN", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to remove ALPN", e2);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.getMethod.invoke(null, sslSocket));
            if (invocationHandler == null) {
                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            }
            AlpnProvider provider = (AlpnProvider) invocationHandler;
            if (!provider.getUnsupported() && provider.getSelected() == null) {
                Platform.log$default(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            } else if (provider.getUnsupported()) {
                return null;
            } else {
                return provider.getSelected();
            }
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to get ALPN selected protocol", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        }
    }

    /* compiled from: Jdk8WithJettyBootPlatform.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��4\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0002\u0018��2\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J0\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010\u0018R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n��R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n��\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, m373d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform$AlpnProvider;", "Ljava/lang/reflect/InvocationHandler;", "protocols", "", "", "(Ljava/util/List;)V", "selected", "getSelected", "()Ljava/lang/String;", "setSelected", "(Ljava/lang/String;)V", "unsupported", "", "getUnsupported", "()Z", "setUnsupported", "(Z)V", "invoke", "", "proxy", EJBInvokerJob.EJB_METHOD_KEY, "Ljava/lang/reflect/Method;", EJBInvokerJob.EJB_ARGS_KEY, "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/platform/Jdk8WithJettyBootPlatform$AlpnProvider.class */
    private static final class AlpnProvider implements InvocationHandler {
        @NotNull
        private final List<String> protocols;
        private boolean unsupported;
        @Nullable
        private String selected;

        public AlpnProvider(@NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(list, "protocols");
            this.protocols = list;
        }

        public final boolean getUnsupported() {
            return this.unsupported;
        }

        public final void setUnsupported(boolean z) {
            this.unsupported = z;
        }

        @Nullable
        public final String getSelected() {
            return this.selected;
        }

        public final void setSelected(@Nullable String str) {
            this.selected = str;
        }

        @Override // java.lang.reflect.InvocationHandler
        @Nullable
        public Object invoke(@NotNull Object proxy, @NotNull Method method, @Nullable Object[] args) throws Throwable {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            Intrinsics.checkNotNullParameter(method, EJBInvokerJob.EJB_METHOD_KEY);
            Object[] callArgs = args;
            if (callArgs == null) {
                callArgs = new Object[0];
            }
            String methodName = method.getName();
            Class returnType = method.getReturnType();
            if (Intrinsics.areEqual(methodName, "supports") && Intrinsics.areEqual(Boolean.TYPE, returnType)) {
                return true;
            }
            if (!Intrinsics.areEqual(methodName, "unsupported") || !Intrinsics.areEqual(Void.TYPE, returnType)) {
                if (Intrinsics.areEqual(methodName, "protocols")) {
                    if (callArgs.length == 0) {
                        return this.protocols;
                    }
                }
                if ((Intrinsics.areEqual(methodName, "selectProtocol") || Intrinsics.areEqual(methodName, "select")) && Intrinsics.areEqual(String.class, returnType) && callArgs.length == 1 && (callArgs[0] instanceof List)) {
                    Object obj = callArgs[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
                    }
                    List peerProtocols = (List) obj;
                    int i = 0;
                    int size = peerProtocols.size();
                    if (0 <= size) {
                        do {
                            i++;
                            Object obj2 = peerProtocols.get(i);
                            if (obj2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            String protocol = (String) obj2;
                            if (this.protocols.contains(protocol)) {
                                this.selected = protocol;
                                return this.selected;
                            }
                        } while (i != size);
                        this.selected = this.protocols.get(0);
                        return this.selected;
                    }
                    this.selected = this.protocols.get(0);
                    return this.selected;
                } else if ((!Intrinsics.areEqual(methodName, "protocolSelected") && !Intrinsics.areEqual(methodName, "selected")) || callArgs.length != 1) {
                    return method.invoke(this, Arrays.copyOf(callArgs, callArgs.length));
                } else {
                    Object obj3 = callArgs[0];
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    this.selected = (String) obj3;
                    return null;
                }
            } else {
                this.unsupported = true;
                return null;
            }
        }
    }

    /* compiled from: Jdk8WithJettyBootPlatform.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\u0005"}, m373d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/Platform;", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/platform/Jdk8WithJettyBootPlatform$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Platform buildIfSupported() {
            String jvmVersion = System.getProperty("java.specification.version", "unknown");
            try {
                Intrinsics.checkNotNullExpressionValue(jvmVersion, "jvmVersion");
                if (Integer.parseInt(jvmVersion) >= 9) {
                    return null;
                }
            } catch (NumberFormatException e) {
            }
            try {
                Class alpnClass = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                Class providerClass = Class.forName(Intrinsics.stringPlus("org.eclipse.jetty.alpn.ALPN", "$Provider"), true, null);
                Class clientProviderClass = Class.forName(Intrinsics.stringPlus("org.eclipse.jetty.alpn.ALPN", "$ClientProvider"), true, null);
                Class serverProviderClass = Class.forName(Intrinsics.stringPlus("org.eclipse.jetty.alpn.ALPN", "$ServerProvider"), true, null);
                Method putMethod = alpnClass.getMethod("put", SSLSocket.class, providerClass);
                Method getMethod = alpnClass.getMethod(BeanUtil.PREFIX_GETTER_GET, SSLSocket.class);
                Method removeMethod = alpnClass.getMethod("remove", SSLSocket.class);
                Intrinsics.checkNotNullExpressionValue(putMethod, "putMethod");
                Intrinsics.checkNotNullExpressionValue(getMethod, "getMethod");
                Intrinsics.checkNotNullExpressionValue(removeMethod, "removeMethod");
                Intrinsics.checkNotNullExpressionValue(clientProviderClass, "clientProviderClass");
                Intrinsics.checkNotNullExpressionValue(serverProviderClass, "serverProviderClass");
                return new Jdk8WithJettyBootPlatform(putMethod, getMethod, removeMethod, clientProviderClass, serverProviderClass);
            } catch (ClassNotFoundException | NoSuchMethodException e2) {
                return null;
            }
        }
    }
}
