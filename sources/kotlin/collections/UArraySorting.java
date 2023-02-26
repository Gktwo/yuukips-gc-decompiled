package kotlin.collections;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.UnsignedUtils;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��0\n��\n\u0002\u0010\b\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a*\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001��¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001��¢\u0006\u0004\b\t\u0010\n\u001a*\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001��¢\u0006\u0004\b\f\u0010\r\u001a*\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001��¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001��¢\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001��¢\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001��¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001��¢\u0006\u0004\b\u0019\u0010\u001a\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001��¢\u0006\u0004\b\u001e\u0010\u0014\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001��¢\u0006\u0004\b\u001f\u0010\u0016\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001��¢\u0006\u0004\b \u0010\u0018\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001��¢\u0006\u0004\b!\u0010\u001a\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, m373d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"})
/* renamed from: kotlin.collections.UArraySortingKt */
/* loaded from: grasscutter.jar:kotlin/collections/UArraySortingKt.class */
public final class UArraySorting {
    @ExperimentalUnsignedTypes
    /* renamed from: partition-4UcCI2c  reason: not valid java name */
    private static final int m7518partition4UcCI2c(byte[] array, int left, int right) {
        int i = left;
        int j = right;
        byte pivot = UByteArray.m7125getw2LRezQ(array, (left + right) / 2);
        while (i <= j) {
            while (Intrinsics.compare(UByteArray.m7125getw2LRezQ(array, i) & 255, pivot & 255) < 0) {
                i++;
            }
            while (Intrinsics.compare(UByteArray.m7125getw2LRezQ(array, j) & 255, pivot & 255) > 0) {
                j--;
            }
            if (i <= j) {
                byte tmp = UByteArray.m7125getw2LRezQ(array, i);
                UByteArray.m7126setVurrAj0(array, i, UByteArray.m7125getw2LRezQ(array, j));
                UByteArray.m7126setVurrAj0(array, j, tmp);
                i++;
                j--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-4UcCI2c  reason: not valid java name */
    private static final void m7519quickSort4UcCI2c(byte[] array, int left, int right) {
        int index = m7518partition4UcCI2c(array, left, right);
        if (left < index - 1) {
            m7519quickSort4UcCI2c(array, left, index - 1);
        }
        if (index < right) {
            m7519quickSort4UcCI2c(array, index, right);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-Aa5vz7o  reason: not valid java name */
    private static final int m7520partitionAa5vz7o(short[] array, int left, int right) {
        int i = left;
        int j = right;
        short pivot = UShortArray.m7389getMh2AYeg(array, (left + right) / 2);
        while (i <= j) {
            while (Intrinsics.compare(UShortArray.m7389getMh2AYeg(array, i) & 65535, pivot & 65535) < 0) {
                i++;
            }
            while (Intrinsics.compare(UShortArray.m7389getMh2AYeg(array, j) & 65535, pivot & 65535) > 0) {
                j--;
            }
            if (i <= j) {
                short tmp = UShortArray.m7389getMh2AYeg(array, i);
                UShortArray.m7390set01HTLdE(array, i, UShortArray.m7389getMh2AYeg(array, j));
                UShortArray.m7390set01HTLdE(array, j, tmp);
                i++;
                j--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-Aa5vz7o  reason: not valid java name */
    private static final void m7521quickSortAa5vz7o(short[] array, int left, int right) {
        int index = m7520partitionAa5vz7o(array, left, right);
        if (left < index - 1) {
            m7521quickSortAa5vz7o(array, left, index - 1);
        }
        if (index < right) {
            m7521quickSortAa5vz7o(array, index, right);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-oBK06Vg  reason: not valid java name */
    private static final int m7522partitionoBK06Vg(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int pivot = UIntArray.m7204getpVg5ArA(array, (left + right) / 2);
        while (i <= j) {
            while (UnsignedUtils.uintCompare(UIntArray.m7204getpVg5ArA(array, i), pivot) < 0) {
                i++;
            }
            while (UnsignedUtils.uintCompare(UIntArray.m7204getpVg5ArA(array, j), pivot) > 0) {
                j--;
            }
            if (i <= j) {
                int tmp = UIntArray.m7204getpVg5ArA(array, i);
                UIntArray.m7205setVXSXFK8(array, i, UIntArray.m7204getpVg5ArA(array, j));
                UIntArray.m7205setVXSXFK8(array, j, tmp);
                i++;
                j--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-oBK06Vg  reason: not valid java name */
    private static final void m7523quickSortoBK06Vg(int[] array, int left, int right) {
        int index = m7522partitionoBK06Vg(array, left, right);
        if (left < index - 1) {
            m7523quickSortoBK06Vg(array, left, index - 1);
        }
        if (index < right) {
            m7523quickSortoBK06Vg(array, index, right);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition--nroSd4  reason: not valid java name */
    private static final int m7524partitionnroSd4(long[] array, int left, int right) {
        int i = left;
        int j = right;
        long pivot = ULongArray.m7283getsVKNKU(array, (left + right) / 2);
        while (i <= j) {
            while (UnsignedUtils.ulongCompare(ULongArray.m7283getsVKNKU(array, i), pivot) < 0) {
                i++;
            }
            while (UnsignedUtils.ulongCompare(ULongArray.m7283getsVKNKU(array, j), pivot) > 0) {
                j--;
            }
            if (i <= j) {
                long tmp = ULongArray.m7283getsVKNKU(array, i);
                ULongArray.m7284setk8EXiF4(array, i, ULongArray.m7283getsVKNKU(array, j));
                ULongArray.m7284setk8EXiF4(array, j, tmp);
                i++;
                j--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort--nroSd4  reason: not valid java name */
    private static final void m7525quickSortnroSd4(long[] array, int left, int right) {
        int index = m7524partitionnroSd4(array, left, right);
        if (left < index - 1) {
            m7525quickSortnroSd4(array, left, index - 1);
        }
        if (index < right) {
            m7525quickSortnroSd4(array, index, right);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-4UcCI2c  reason: not valid java name */
    public static final void m7526sortArray4UcCI2c(@NotNull byte[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        m7519quickSort4UcCI2c(array, fromIndex, toIndex - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-Aa5vz7o  reason: not valid java name */
    public static final void m7527sortArrayAa5vz7o(@NotNull short[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        m7521quickSortAa5vz7o(array, fromIndex, toIndex - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-oBK06Vg  reason: not valid java name */
    public static final void m7528sortArrayoBK06Vg(@NotNull int[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        m7523quickSortoBK06Vg(array, fromIndex, toIndex - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray--nroSd4  reason: not valid java name */
    public static final void m7529sortArraynroSd4(@NotNull long[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        m7525quickSortnroSd4(array, fromIndex, toIndex - 1);
    }
}
