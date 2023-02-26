package kotlin.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedUtils;

@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"�� \n��\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n��\n\u0002\u0010\t\n\u0002\b\u0002\u001a*\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002ø\u0001��¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010��\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002ø\u0001��¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001ø\u0001��¢\u0006\u0004\b\u000f\u0010\u0006\u001a*\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001ø\u0001��¢\u0006\u0004\b\u0011\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m373d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"})
/* renamed from: kotlin.internal.UProgressionUtilKt */
/* loaded from: grasscutter.jar:kotlin/internal/UProgressionUtilKt.class */
public final class UProgressionUtil {
    /* renamed from: differenceModulo-WZ9TVnA  reason: not valid java name */
    private static final int m8278differenceModuloWZ9TVnA(int a, int b, int c) {
        int ac = UnsignedUtils.m7409uintRemainderJ1ME1BU(a, c);
        int bc = UnsignedUtils.m7409uintRemainderJ1ME1BU(b, c);
        if (UnsignedUtils.uintCompare(ac, bc) >= 0) {
            return UInt.m7198constructorimpl(ac - bc);
        }
        return UInt.m7198constructorimpl(UInt.m7198constructorimpl(ac - bc) + c);
    }

    /* renamed from: differenceModulo-sambcqE  reason: not valid java name */
    private static final long m8279differenceModulosambcqE(long a, long b, long c) {
        long ac = UnsignedUtils.m7411ulongRemaindereb3DHEI(a, c);
        long bc = UnsignedUtils.m7411ulongRemaindereb3DHEI(b, c);
        if (UnsignedUtils.ulongCompare(ac, bc) >= 0) {
            return ULong.m7277constructorimpl(ac - bc);
        }
        return ULong.m7277constructorimpl(ULong.m7277constructorimpl(ac - bc) + c);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: getProgressionLastElement-Nkh28Cs  reason: not valid java name */
    public static final int m8280getProgressionLastElementNkh28Cs(int start, int end, int step) {
        if (step > 0) {
            return UnsignedUtils.uintCompare(start, end) >= 0 ? end : UInt.m7198constructorimpl(end - m8278differenceModuloWZ9TVnA(end, start, UInt.m7198constructorimpl(step)));
        }
        if (step < 0) {
            return UnsignedUtils.uintCompare(start, end) <= 0 ? end : UInt.m7198constructorimpl(end + m8278differenceModuloWZ9TVnA(start, end, UInt.m7198constructorimpl(-step)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: getProgressionLastElement-7ftBX0g  reason: not valid java name */
    public static final long m8281getProgressionLastElement7ftBX0g(long start, long end, long step) {
        if (step > 0) {
            return UnsignedUtils.ulongCompare(start, end) >= 0 ? end : ULong.m7277constructorimpl(end - m8279differenceModulosambcqE(end, start, ULong.m7277constructorimpl(step)));
        }
        if (step < 0) {
            return UnsignedUtils.ulongCompare(start, end) <= 0 ? end : ULong.m7277constructorimpl(end + m8279differenceModulosambcqE(start, end, ULong.m7277constructorimpl(-step)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
