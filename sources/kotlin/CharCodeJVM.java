package kotlin;

import kotlin.internal.InlineOnly;

@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��\u0010\n��\n\u0002\u0010\f\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\bø\u0001��¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, m373d2 = {"Char", "", "code", "Lkotlin/UShort;", "Char-xj2QHRw", "(S)C", "kotlin-stdlib"})
/* renamed from: kotlin.CharCodeJVMKt */
/* loaded from: grasscutter.jar:kotlin/CharCodeJVMKt.class */
public final class CharCodeJVM {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: Char-xj2QHRw  reason: not valid java name */
    private static final char m7044Charxj2QHRw(short code) {
        return (char) (code & 65535);
    }
}