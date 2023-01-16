package okhttp3;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.authenticator.JavaNetAuthenticator;
import org.eclipse.jetty.util.security.Constraint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Authenticator.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001e\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0001\u0018�� \b2\u00020\u0001:\u0001\bJ\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, m373d2 = {"Lokhttp3/Authenticator;", "", "authenticate", "Lokhttp3/Request;", "route", "Lokhttp3/Route;", "response", "Lokhttp3/Response;", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/Authenticator.class */
public interface Authenticator {
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;
    @JvmField
    @NotNull
    public static final Authenticator NONE = new Companion.AuthenticatorNone();
    @JvmField
    @NotNull
    public static final Authenticator JAVA_NET_AUTHENTICATOR = new JavaNetAuthenticator(null, 1, null);

    @Nullable
    Request authenticate(@Nullable Route route, @NotNull Response response) throws IOException;

    /* compiled from: Authenticator.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0014\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018��2\u00020\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n��¨\u0006\u0001R\u0013\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n��¨\u0006\u0001¨\u0006\u0007"}, m373d2 = {"Lokhttp3/Authenticator$Companion;", "", "()V", "JAVA_NET_AUTHENTICATOR", "Lokhttp3/Authenticator;", Constraint.NONE, "AuthenticatorNone", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/Authenticator$Companion.class */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* compiled from: Authenticator.kt */
        @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\b\u0002\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m373d2 = {"Lokhttp3/Authenticator$Companion$AuthenticatorNone;", "Lokhttp3/Authenticator;", "()V", "authenticate", "Lokhttp3/Request;", "route", "Lokhttp3/Route;", "response", "Lokhttp3/Response;", "okhttp"})
        /* loaded from: grasscutter.jar:okhttp3/Authenticator$Companion$AuthenticatorNone.class */
        private static final class AuthenticatorNone implements Authenticator {
            @Override // okhttp3.Authenticator
            @Nullable
            public Request authenticate(@Nullable Route route, @NotNull Response response) {
                Intrinsics.checkNotNullParameter(response, "response");
                return null;
            }
        }
    }
}
