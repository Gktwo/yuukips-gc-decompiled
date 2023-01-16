package p013io.javalin.http;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.websocket.api.StatusCode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;

/* compiled from: Cookie.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��(\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n��\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b,\b\b\u0018��2\u00020\u0001Bm\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003Js\u00106\u001a\u00020��2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u00107\u001a\u00020\t2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0007HÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u000e\n��\u001a\u0004\b\u000b\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n��\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n��\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n��\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n��\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\u001a\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u000e\n��\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001d¨\u0006;"}, m373d2 = {"Lio/javalin/http/Cookie;", "", "name", "", "value", "path", "maxAge", "", "secure", "", "version", "isHttpOnly", "comment", "domain", "sameSite", "Lio/javalin/http/SameSite;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZIZLjava/lang/String;Ljava/lang/String;Lio/javalin/http/SameSite;)V", "getComment", "()Ljava/lang/String;", "setComment", "(Ljava/lang/String;)V", "getDomain", "setDomain", "()Z", "setHttpOnly", "(Z)V", "getMaxAge", "()I", "setMaxAge", "(I)V", "getName", "setName", "getPath", "setPath", "getSameSite", "()Lio/javalin/http/SameSite;", "setSameSite", "(Lio/javalin/http/SameSite;)V", "getSecure", "setSecure", "getValue", "setValue", "getVersion", "setVersion", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", Printer.TO_STRING, "javalin"})
/* renamed from: io.javalin.http.Cookie */
/* loaded from: grasscutter.jar:io/javalin/http/Cookie.class */
public final class Cookie {
    @NotNull
    private String name;
    @NotNull
    private String value;
    @NotNull
    private String path;
    private int maxAge;
    private boolean secure;
    private int version;
    private boolean isHttpOnly;
    @Nullable
    private String comment;
    @Nullable
    private String domain;
    @Nullable
    private SameSite sameSite;

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final String component2() {
        return this.value;
    }

    @NotNull
    public final String component3() {
        return this.path;
    }

    public final int component4() {
        return this.maxAge;
    }

    public final boolean component5() {
        return this.secure;
    }

    public final int component6() {
        return this.version;
    }

    public final boolean component7() {
        return this.isHttpOnly;
    }

    @Nullable
    public final String component8() {
        return this.comment;
    }

    @Nullable
    public final String component9() {
        return this.domain;
    }

    @Nullable
    public final SameSite component10() {
        return this.sameSite;
    }

    @NotNull
    public final Cookie copy(@NotNull String name, @NotNull String value, @NotNull String path, int maxAge, boolean secure, int version, boolean isHttpOnly, @Nullable String comment, @Nullable String domain, @Nullable SameSite sameSite) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(path, "path");
        return new Cookie(name, value, path, maxAge, secure, version, isHttpOnly, comment, domain, sameSite);
    }

    public static /* synthetic */ Cookie copy$default(Cookie cookie, String str, String str2, String str3, int i, boolean z, int i2, boolean z2, String str4, String str5, SameSite sameSite, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = cookie.name;
        }
        if ((i3 & 2) != 0) {
            str2 = cookie.value;
        }
        if ((i3 & 4) != 0) {
            str3 = cookie.path;
        }
        if ((i3 & 8) != 0) {
            i = cookie.maxAge;
        }
        if ((i3 & 16) != 0) {
            z = cookie.secure;
        }
        if ((i3 & 32) != 0) {
            i2 = cookie.version;
        }
        if ((i3 & 64) != 0) {
            z2 = cookie.isHttpOnly;
        }
        if ((i3 & 128) != 0) {
            str4 = cookie.comment;
        }
        if ((i3 & 256) != 0) {
            str5 = cookie.domain;
        }
        if ((i3 & 512) != 0) {
            sameSite = cookie.sameSite;
        }
        return cookie.copy(str, str2, str3, i, z, i2, z2, str4, str5, sameSite);
    }

    @NotNull
    public String toString() {
        return "Cookie(name=" + this.name + ", value=" + this.value + ", path=" + this.path + ", maxAge=" + this.maxAge + ", secure=" + this.secure + ", version=" + this.version + ", isHttpOnly=" + this.isHttpOnly + ", comment=" + ((Object) this.comment) + ", domain=" + ((Object) this.domain) + ", sameSite=" + this.sameSite + ')';
    }

    public int hashCode() {
        int hashCode = ((((((this.name.hashCode() * 31) + this.value.hashCode()) * 31) + this.path.hashCode()) * 31) + Integer.hashCode(this.maxAge)) * 31;
        boolean z = this.secure;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int hashCode2 = (((hashCode + i) * 31) + Integer.hashCode(this.version)) * 31;
        boolean z2 = this.isHttpOnly;
        if (z2) {
            z2 = true;
        }
        int i4 = z2 ? 1 : 0;
        int i5 = z2 ? 1 : 0;
        int i6 = z2 ? 1 : 0;
        return ((((((hashCode2 + i4) * 31) + (this.comment == null ? 0 : this.comment.hashCode())) * 31) + (this.domain == null ? 0 : this.domain.hashCode())) * 31) + (this.sameSite == null ? 0 : this.sameSite.hashCode());
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) other;
        return Intrinsics.areEqual(this.name, cookie.name) && Intrinsics.areEqual(this.value, cookie.value) && Intrinsics.areEqual(this.path, cookie.path) && this.maxAge == cookie.maxAge && this.secure == cookie.secure && this.version == cookie.version && this.isHttpOnly == cookie.isHttpOnly && Intrinsics.areEqual(this.comment, cookie.comment) && Intrinsics.areEqual(this.domain, cookie.domain) && this.sameSite == cookie.sameSite;
    }

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Cookie(@NotNull String name, @NotNull String value, @NotNull String path, int maxAge, boolean secure, int version, boolean isHttpOnly, @Nullable String comment, @Nullable String domain) {
        this(name, value, path, maxAge, secure, version, isHttpOnly, comment, domain, null, 512, null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(path, "path");
    }

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Cookie(@NotNull String name, @NotNull String value, @NotNull String path, int maxAge, boolean secure, int version, boolean isHttpOnly, @Nullable String comment) {
        this(name, value, path, maxAge, secure, version, isHttpOnly, comment, null, null, 768, null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(path, "path");
    }

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Cookie(@NotNull String name, @NotNull String value, @NotNull String path, int maxAge, boolean secure, int version, boolean isHttpOnly) {
        this(name, value, path, maxAge, secure, version, isHttpOnly, null, null, null, RetcodeOuterClass.Retcode.RET_SEA_LAMP_COIN_NOT_ENOUGH_VALUE, null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(path, "path");
    }

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Cookie(@NotNull String name, @NotNull String value, @NotNull String path, int maxAge, boolean secure, int version) {
        this(name, value, path, maxAge, secure, version, false, null, null, null, 960, null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(path, "path");
    }

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Cookie(@NotNull String name, @NotNull String value, @NotNull String path, int maxAge, boolean secure) {
        this(name, value, path, maxAge, secure, 0, false, null, null, null, 992, null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(path, "path");
    }

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Cookie(@NotNull String name, @NotNull String value, @NotNull String path, int maxAge) {
        this(name, value, path, maxAge, false, 0, false, null, null, null, StatusCode.POLICY_VIOLATION, null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(path, "path");
    }

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Cookie(@NotNull String name, @NotNull String value, @NotNull String path) {
        this(name, value, path, 0, false, 0, false, null, null, null, 1016, null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(path, "path");
    }

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Cookie(@NotNull String name, @NotNull String value) {
        this(name, value, null, 0, false, 0, false, null, null, null, 1020, null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @JvmOverloads
    public Cookie(@NotNull String name, @NotNull String value, @NotNull String path, int maxAge, boolean secure, int version, boolean isHttpOnly, @Nullable String comment, @Nullable String domain, @Nullable SameSite sameSite) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(path, "path");
        this.name = name;
        this.value = value;
        this.path = path;
        this.maxAge = maxAge;
        this.secure = secure;
        this.version = version;
        this.isHttpOnly = isHttpOnly;
        this.comment = comment;
        this.domain = domain;
        this.sameSite = sameSite;
    }

    public /* synthetic */ Cookie(String str, String str2, String str3, int i, boolean z, int i2, boolean z2, String str4, String str5, SameSite sameSite, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? "/" : str3, (i3 & 8) != 0 ? -1 : i, (i3 & 16) != 0 ? false : z, (i3 & 32) != 0 ? 0 : i2, (i3 & 64) != 0 ? false : z2, (i3 & 128) != 0 ? null : str4, (i3 & 256) != 0 ? null : str5, (i3 & 512) != 0 ? null : sameSite);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public final void setValue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.value = str;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    public final void setPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.path = str;
    }

    public final int getMaxAge() {
        return this.maxAge;
    }

    public final void setMaxAge(int i) {
        this.maxAge = i;
    }

    public final boolean getSecure() {
        return this.secure;
    }

    public final void setSecure(boolean z) {
        this.secure = z;
    }

    public final int getVersion() {
        return this.version;
    }

    public final void setVersion(int i) {
        this.version = i;
    }

    public final boolean isHttpOnly() {
        return this.isHttpOnly;
    }

    public final void setHttpOnly(boolean z) {
        this.isHttpOnly = z;
    }

    @Nullable
    public final String getComment() {
        return this.comment;
    }

    public final void setComment(@Nullable String str) {
        this.comment = str;
    }

    @Nullable
    public final String getDomain() {
        return this.domain;
    }

    public final void setDomain(@Nullable String str) {
        this.domain = str;
    }

    @Nullable
    public final SameSite getSameSite() {
        return this.sameSite;
    }

    public final void setSameSite(@Nullable SameSite sameSite) {
        this.sameSite = sameSite;
    }
}
