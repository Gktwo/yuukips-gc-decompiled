package kotlin;

import kotlin.internal.InlineOnly;

/* compiled from: UInt.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��,\n��\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n��\n\u0002\u0010\u0006\n��\n\u0002\u0010\u0007\n��\n\u0002\u0010\b\n��\n\u0002\u0010\t\n��\n\u0002\u0010\n\n\u0002\b\u0002\u001a\u0015\u0010��\u001a\u00020\u0001*\u00020\u0002H\bø\u0001��¢\u0006\u0002\u0010\u0003\u001a\u0015\u0010��\u001a\u00020\u0001*\u00020\u0004H\bø\u0001��¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010��\u001a\u00020\u0001*\u00020\u0006H\bø\u0001��¢\u0006\u0002\u0010\u0007\u001a\u0015\u0010��\u001a\u00020\u0001*\u00020\bH\bø\u0001��¢\u0006\u0002\u0010\t\u001a\u0015\u0010��\u001a\u00020\u0001*\u00020\nH\bø\u0001��¢\u0006\u0002\u0010\u000b\u001a\u0015\u0010��\u001a\u00020\u0001*\u00020\fH\bø\u0001��¢\u0006\u0002\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, m373d2 = {"toUInt", "Lkotlin/UInt;", "", "(B)I", "", "(D)I", "", "(F)I", "", "(I)I", "", "(J)I", "", "(S)I", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/UIntKt.class */
public final class UIntKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final int toUInt(byte $this$toUInt) {
        return UInt.m7198constructorimpl($this$toUInt);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final int toUInt(short $this$toUInt) {
        return UInt.m7198constructorimpl($this$toUInt);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final int toUInt(int $this$toUInt) {
        return UInt.m7198constructorimpl($this$toUInt);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final int toUInt(long $this$toUInt) {
        return UInt.m7198constructorimpl((int) $this$toUInt);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final int toUInt(float $this$toUInt) {
        return UnsignedUtils.doubleToUInt((double) $this$toUInt);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final int toUInt(double $this$toUInt) {
        return UnsignedUtils.doubleToUInt($this$toUInt);
    }
}
