package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* compiled from: -DeprecatedUpgrade.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��\u0012\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010��\u001a\u00020\u0001¢\u0006\b\n��\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n��\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m373d2 = {"Okio", "Lokio/-DeprecatedOkio;", "getOkio", "()Lokio/-DeprecatedOkio;", "Utf8", "Lokio/-DeprecatedUtf8;", "getUtf8", "()Lokio/-DeprecatedUtf8;", "okio"})
@JvmName(name = "-DeprecatedUpgrade")
/* renamed from: okio.-DeprecatedUpgrade  reason: invalid class name */
/* loaded from: grasscutter.jar:okio/-DeprecatedUpgrade.class */
public final class DeprecatedUpgrade {
    @NotNull
    private static final DeprecatedOkio Okio = DeprecatedOkio.INSTANCE;
    @NotNull
    private static final DeprecatedUtf8 Utf8 = DeprecatedUtf8.INSTANCE;

    @NotNull
    public static final DeprecatedOkio getOkio() {
        return Okio;
    }

    @NotNull
    public static final DeprecatedUtf8 getUtf8() {
        return Utf8;
    }
}
