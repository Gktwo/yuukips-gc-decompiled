package kotlin.experimental;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;

@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��\u0010\n��\n\u0002\u0010\u0005\n��\n\u0002\u0010\n\n\u0002\b\u0004\u001a\u0015\u0010��\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\u0015\u0010��\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\f\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0004\u001a\u00020\u0003*\u00020\u0003H\b\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\u0015\u0010\u0005\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\f\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\u0015\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\f¨\u0006\u0007"}, m373d2 = {"and", "", "other", "", "inv", "or", "xor", "kotlin-stdlib"})
/* renamed from: kotlin.experimental.BitwiseOperationsKt */
/* loaded from: grasscutter.jar:kotlin/experimental/BitwiseOperationsKt.class */
public final class bitwiseOperations {
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte and(byte $this$and, byte other) {
        return (byte) ($this$and & other);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: or */
    private static final byte m357or(byte $this$or, byte other) {
        return (byte) ($this$or | other);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte xor(byte $this$xor, byte other) {
        return (byte) ($this$xor ^ other);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte inv(byte $this$inv) {
        return (byte) ($this$inv ^ -1);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short and(short $this$and, short other) {
        return (short) ($this$and & other);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: or */
    private static final short m356or(short $this$or, short other) {
        return (short) ($this$or | other);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short xor(short $this$xor, short other) {
        return (short) ($this$xor ^ other);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short inv(short $this$inv) {
        return (short) ($this$inv ^ -1);
    }
}
