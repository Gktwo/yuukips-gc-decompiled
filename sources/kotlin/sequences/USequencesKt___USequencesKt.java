package kotlin.sequences;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.WasExperimental;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: _USequences.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 5, m369xi = 49, m374d1 = {"��\"\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010��\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007ø\u0001��¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010��\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007ø\u0001��¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001c\u0010��\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007ø\u0001��¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010��\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007ø\u0001��¢\u0006\u0004\b\u000b\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m373d2 = {"sum", "Lkotlin/UInt;", "Lkotlin/sequences/Sequence;", "Lkotlin/UByte;", "sumOfUByte", "(Lkotlin/sequences/Sequence;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Lkotlin/sequences/Sequence;)J", "Lkotlin/UShort;", "sumOfUShort", "kotlin-stdlib"}, m368xs = "kotlin/sequences/USequencesKt")
/* loaded from: grasscutter.jar:kotlin/sequences/USequencesKt___USequencesKt.class */
class USequencesKt___USequencesKt {
    @SinceKotlin(version = "1.5")
    @JvmName(name = "sumOfUInt")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int sumOfUInt(@NotNull Sequence<UInt> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        int sum = 0;
        for (UInt uInt : sequence) {
            sum = UInt.m7201constructorimpl(sum + uInt.m7203unboximpl());
        }
        return sum;
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [long] */
    @SinceKotlin(version = "1.5")
    @JvmName(name = "sumOfULong")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long sumOfULong(@NotNull Sequence<ULong> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        char c = 0;
        for (ULong uLong : sequence) {
            c = ULong.m7280constructorimpl(c + uLong.m7282unboximpl());
        }
        return c;
    }

    @SinceKotlin(version = "1.5")
    @JvmName(name = "sumOfUByte")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int sumOfUByte(@NotNull Sequence<UByte> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        int sum = 0;
        for (UByte uByte : sequence) {
            sum = UInt.m7201constructorimpl(sum + UInt.m7201constructorimpl(uByte.m7124unboximpl() & 255));
        }
        return sum;
    }

    @SinceKotlin(version = "1.5")
    @JvmName(name = "sumOfUShort")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int sumOfUShort(@NotNull Sequence<UShort> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        int sum = 0;
        for (UShort uShort : sequence) {
            sum = UInt.m7201constructorimpl(sum + UInt.m7201constructorimpl(uShort.m7388unboximpl() & 65535));
        }
        return sum;
    }
}
