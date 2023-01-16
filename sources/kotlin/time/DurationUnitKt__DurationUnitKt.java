package kotlin.time;

import emu.grasscutter.net.packet.PacketOpcodes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p001ch.qos.logback.core.pattern.color.ANSIConstants;
import p001ch.qos.logback.core.rolling.helper.DateTokenConverter;

/* compiled from: DurationUnit.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 5, m369xi = 49, m374d1 = {"��\u001c\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\f\n��\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n��\u001a\u0018\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0001\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0001¨\u0006\t"}, m373d2 = {"durationUnitByIsoChar", "Lkotlin/time/DurationUnit;", "isoChar", "", "isTimeComponent", "", "durationUnitByShortName", "shortName", "", "kotlin-stdlib"}, m368xs = "kotlin/time/DurationUnitKt")
/* loaded from: grasscutter.jar:kotlin/time/DurationUnitKt__DurationUnitKt.class */
class DurationUnitKt__DurationUnitKt extends DurationUnitJvm {

    /* compiled from: DurationUnit.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 48)
    /* loaded from: grasscutter.jar:kotlin/time/DurationUnitKt__DurationUnitKt$WhenMappings.class */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DurationUnit.values().length];
            iArr[DurationUnit.NANOSECONDS.ordinal()] = 1;
            iArr[DurationUnit.MICROSECONDS.ordinal()] = 2;
            iArr[DurationUnit.MILLISECONDS.ordinal()] = 3;
            iArr[DurationUnit.SECONDS.ordinal()] = 4;
            iArr[DurationUnit.MINUTES.ordinal()] = 5;
            iArr[DurationUnit.HOURS.ordinal()] = 6;
            iArr[DurationUnit.DAYS.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final String shortName(@NotNull DurationUnit $this$shortName) {
        Intrinsics.checkNotNullParameter($this$shortName, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$shortName.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "us";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return ANSIConstants.ESC_END;
            case 6:
                return "h";
            case 7:
                return DateTokenConverter.CONVERTER_KEY;
            default:
                throw new IllegalStateException(("Unknown unit: " + $this$shortName).toString());
        }
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final DurationUnit durationUnitByShortName(@NotNull String shortName) {
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        switch (shortName.hashCode()) {
            case 100:
                if (shortName.equals(DateTokenConverter.CONVERTER_KEY)) {
                    return DurationUnit.DAYS;
                }
                break;
            case 104:
                if (shortName.equals("h")) {
                    return DurationUnit.HOURS;
                }
                break;
            case 109:
                if (shortName.equals(ANSIConstants.ESC_END)) {
                    return DurationUnit.MINUTES;
                }
                break;
            case 115:
                if (shortName.equals("s")) {
                    return DurationUnit.SECONDS;
                }
                break;
            case PacketOpcodes.ForceDragBackTransferNotify:
                if (shortName.equals("ms")) {
                    return DurationUnit.MILLISECONDS;
                }
                break;
            case 3525:
                if (shortName.equals("ns")) {
                    return DurationUnit.NANOSECONDS;
                }
                break;
            case 3742:
                if (shortName.equals("us")) {
                    return DurationUnit.MICROSECONDS;
                }
                break;
        }
        throw new IllegalArgumentException("Unknown duration unit short name: " + shortName);
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final DurationUnit durationUnitByIsoChar(char isoChar, boolean isTimeComponent) {
        if (!isTimeComponent) {
            if (isoChar == 'D') {
                return DurationUnit.DAYS;
            }
            throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + isoChar);
        } else if (isoChar == 'H') {
            return DurationUnit.HOURS;
        } else {
            if (isoChar == 'M') {
                return DurationUnit.MINUTES;
            }
            if (isoChar == 'S') {
                return DurationUnit.SECONDS;
            }
            throw new IllegalArgumentException("Invalid duration ISO time unit: " + isoChar);
        }
    }
}
