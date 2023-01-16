package kotlin;

import kotlin.internal.InlineOnly;

@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��\u000e\n��\n\u0002\u0010\b\n\u0002\u0010\f\n\u0002\b\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010��\u001a\u00020\u0001H\b\"\u001f\u0010��\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m373d2 = {"code", "", "", "getCode$annotations", "(C)V", "getCode", "(C)I", "Char", "kotlin-stdlib"})
/* renamed from: kotlin.CharCodeKt */
/* loaded from: grasscutter.jar:kotlin/CharCodeKt.class */
public final class CharCode {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static /* synthetic */ void getCode$annotations(char c) {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final char Char(int code) {
        if (code >= 0 && code <= 65535) {
            return (char) code;
        }
        throw new IllegalArgumentException("Invalid Char code: " + code);
    }

    private static final int getCode(char $this$code) {
        return $this$code;
    }
}
