package p013io.javalin.http;

import kotlin.Metadata;
import org.eclipse.jetty.util.security.Constraint;
import org.jetbrains.annotations.NotNull;
import org.jline.console.Printer;

/* compiled from: Cookie.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n��\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018��2\b\u0012\u0004\u0012\u00020��0\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m373d2 = {"Lio/javalin/http/SameSite;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", Printer.TO_STRING, Constraint.NONE, "STRICT", "LAX", "javalin"})
/* renamed from: io.javalin.http.SameSite */
/* loaded from: grasscutter.jar:io/javalin/http/SameSite.class */
public enum SameSite {
    NONE("SameSite=None"),
    STRICT("SameSite=Strict"),
    LAX("SameSite=Lax");
    
    @NotNull
    private final String value;

    SameSite(String value) {
        this.value = value;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum, java.lang.Object
    @NotNull
    public String toString() {
        return this.value;
    }
}
