package kotlin.collections;

import java.util.Collection;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.WasExperimental;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: _UCollections.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 5, m369xi = 49, m374d1 = {"��F\n��\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010��\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007ø\u0001��¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010��\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007ø\u0001��¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001c\u0010��\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007ø\u0001��¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010��\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007ø\u0001��¢\u0006\u0004\b\u000b\u0010\u0005\u001a\u001a\u0010\f\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0007ø\u0001��¢\u0006\u0002\u0010\u000f\u001a\u001a\u0010\u0010\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007ø\u0001��¢\u0006\u0002\u0010\u0012\u001a\u001a\u0010\u0013\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0007ø\u0001��¢\u0006\u0002\u0010\u0015\u001a\u001a\u0010\u0016\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\n0\u000eH\u0007ø\u0001��¢\u0006\u0002\u0010\u0018\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, m373d2 = {"sum", "Lkotlin/UInt;", "", "Lkotlin/UByte;", "sumOfUByte", "(Ljava/lang/Iterable;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Ljava/lang/Iterable;)J", "Lkotlin/UShort;", "sumOfUShort", "toUByteArray", "Lkotlin/UByteArray;", "", "(Ljava/util/Collection;)[B", "toUIntArray", "Lkotlin/UIntArray;", "(Ljava/util/Collection;)[I", "toULongArray", "Lkotlin/ULongArray;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lkotlin/UShortArray;", "(Ljava/util/Collection;)[S", "kotlin-stdlib"}, m368xs = "kotlin/collections/UCollectionsKt")
/* loaded from: grasscutter.jar:kotlin/collections/UCollectionsKt___UCollectionsKt.class */
class UCollectionsKt___UCollectionsKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] toUByteArray(@NotNull Collection<UByte> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        byte[] result = UByteArray.m7127constructorimpl(collection.size());
        int index = 0;
        for (UByte uByte : collection) {
            index++;
            UByteArray.m7129setVurrAj0(result, index, uByte.m7124unboximpl());
        }
        return result;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final int[] toUIntArray(@NotNull Collection<UInt> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] result = UIntArray.m7206constructorimpl(collection.size());
        int index = 0;
        for (UInt uInt : collection) {
            index++;
            UIntArray.m7208setVXSXFK8(result, index, uInt.m7203unboximpl());
        }
        return result;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final long[] toULongArray(@NotNull Collection<ULong> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] result = ULongArray.m7285constructorimpl(collection.size());
        int index = 0;
        for (ULong uLong : collection) {
            index++;
            ULongArray.m7287setk8EXiF4(result, index, uLong.m7282unboximpl());
        }
        return result;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final short[] toUShortArray(@NotNull Collection<UShort> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        short[] result = UShortArray.m7391constructorimpl(collection.size());
        int index = 0;
        for (UShort uShort : collection) {
            index++;
            UShortArray.m7393set01HTLdE(result, index, uShort.m7388unboximpl());
        }
        return result;
    }

    @SinceKotlin(version = "1.5")
    @JvmName(name = "sumOfUInt")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int sumOfUInt(@NotNull Iterable<UInt> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        int sum = 0;
        for (UInt uInt : iterable) {
            sum = UInt.m7201constructorimpl(sum + uInt.m7203unboximpl());
        }
        return sum;
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [long] */
    @SinceKotlin(version = "1.5")
    @JvmName(name = "sumOfULong")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long sumOfULong(@NotNull Iterable<ULong> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        char c = 0;
        for (ULong uLong : iterable) {
            c = ULong.m7280constructorimpl(c + uLong.m7282unboximpl());
        }
        return c;
    }

    @SinceKotlin(version = "1.5")
    @JvmName(name = "sumOfUByte")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int sumOfUByte(@NotNull Iterable<UByte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        int sum = 0;
        for (UByte uByte : iterable) {
            sum = UInt.m7201constructorimpl(sum + UInt.m7201constructorimpl(uByte.m7124unboximpl() & 255));
        }
        return sum;
    }

    @SinceKotlin(version = "1.5")
    @JvmName(name = "sumOfUShort")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int sumOfUShort(@NotNull Iterable<UShort> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        int sum = 0;
        for (UShort uShort : iterable) {
            sum = UInt.m7201constructorimpl(sum + UInt.m7201constructorimpl(uShort.m7388unboximpl() & 65535));
        }
        return sum;
    }
}
