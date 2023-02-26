package okio.internal;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

/* compiled from: -Utf8.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��\u0016\n��\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010��\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, m373d2 = {"commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "beginIndex", "", "endIndex", "okio"})
/* loaded from: grasscutter.jar:okio/internal/_Utf8Kt.class */
public final class _Utf8Kt {
    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return commonToUtf8String(bArr, i, i2);
    }

    @NotNull
    public static final String commonToUtf8String(@NotNull byte[] $this$commonToUtf8String, int beginIndex, int endIndex) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        boolean z2;
        Intrinsics.checkNotNullParameter($this$commonToUtf8String, "<this>");
        if (beginIndex < 0 || endIndex > $this$commonToUtf8String.length || beginIndex > endIndex) {
            throw new ArrayIndexOutOfBoundsException("size=" + $this$commonToUtf8String.length + " beginIndex=" + beginIndex + " endIndex=" + endIndex);
        }
        char[] chars = new char[endIndex - beginIndex];
        int length = 0;
        int index$iv = beginIndex;
        while (index$iv < endIndex) {
            byte b0$iv = $this$commonToUtf8String[index$iv];
            if (b0$iv >= 0) {
                length++;
                chars[length] = (char) b0$iv;
                index$iv++;
                while (index$iv < endIndex && $this$commonToUtf8String[index$iv] >= 0) {
                    index$iv++;
                    length++;
                    chars[length] = (char) $this$commonToUtf8String[index$iv];
                }
            } else if ((b0$iv >> 5) == -2) {
                if (endIndex <= index$iv + 1) {
                    length++;
                    chars[length] = (char) 65533;
                    Unit unit = Unit.INSTANCE;
                    i2 = index$iv;
                    i = 1;
                } else {
                    byte b0$iv$iv = $this$commonToUtf8String[index$iv];
                    byte b1$iv$iv = $this$commonToUtf8String[index$iv + 1];
                    if (!((b1$iv$iv & 192) == 128)) {
                        length++;
                        chars[length] = (char) 65533;
                        Unit unit2 = Unit.INSTANCE;
                        i2 = index$iv;
                        i = 1;
                    } else {
                        int codePoint$iv$iv = (3968 ^ b1$iv$iv) ^ (b0$iv$iv << 6);
                        if (codePoint$iv$iv < 128) {
                            length++;
                            chars[length] = (char) 65533;
                            Unit unit3 = Unit.INSTANCE;
                            i2 = index$iv;
                        } else {
                            length++;
                            chars[length] = (char) codePoint$iv$iv;
                            Unit unit4 = Unit.INSTANCE;
                            i2 = index$iv;
                        }
                        i = 2;
                    }
                }
                index$iv = i2 + i;
            } else if ((b0$iv >> 4) == -2) {
                if (endIndex <= index$iv + 2) {
                    length++;
                    chars[length] = (char) 65533;
                    Unit unit5 = Unit.INSTANCE;
                    i4 = index$iv;
                    if (endIndex > index$iv + 1) {
                        if (($this$commonToUtf8String[index$iv + 1] & 192) == 128) {
                            i3 = 2;
                        }
                    }
                    i3 = 1;
                } else {
                    byte b0$iv$iv2 = $this$commonToUtf8String[index$iv];
                    byte b1$iv$iv2 = $this$commonToUtf8String[index$iv + 1];
                    if (!((b1$iv$iv2 & 192) == 128)) {
                        length++;
                        chars[length] = (char) 65533;
                        Unit unit6 = Unit.INSTANCE;
                        i4 = index$iv;
                        i3 = 1;
                    } else {
                        byte b2$iv$iv = $this$commonToUtf8String[index$iv + 2];
                        if (!((b2$iv$iv & 192) == 128)) {
                            length++;
                            chars[length] = (char) 65533;
                            Unit unit7 = Unit.INSTANCE;
                            i4 = index$iv;
                            i3 = 2;
                        } else {
                            int codePoint$iv$iv2 = ((-123008 ^ b2$iv$iv) ^ (b1$iv$iv2 << 6)) ^ (b0$iv$iv2 << 12);
                            if (codePoint$iv$iv2 < 2048) {
                                length++;
                                chars[length] = (char) 65533;
                                Unit unit8 = Unit.INSTANCE;
                                i4 = index$iv;
                            } else {
                                if (55296 <= codePoint$iv$iv2) {
                                    z = codePoint$iv$iv2 <= 57343;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    length++;
                                    chars[length] = (char) 65533;
                                    Unit unit9 = Unit.INSTANCE;
                                    i4 = index$iv;
                                } else {
                                    length++;
                                    chars[length] = (char) codePoint$iv$iv2;
                                    Unit unit10 = Unit.INSTANCE;
                                    i4 = index$iv;
                                }
                            }
                            i3 = 3;
                        }
                    }
                }
                index$iv = i4 + i3;
            } else if ((b0$iv >> 3) == -2) {
                if (endIndex <= index$iv + 3) {
                    if (65533 != 65533) {
                        int length2 = length + 1;
                        chars[length] = (char) ((65533 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                        length = length2 + 1;
                        chars[length2] = (char) ((65533 & 1023) + 56320);
                    } else {
                        length++;
                        chars[length] = 65533;
                    }
                    Unit unit11 = Unit.INSTANCE;
                    i6 = index$iv;
                    if (endIndex > index$iv + 1) {
                        if (($this$commonToUtf8String[index$iv + 1] & 192) == 128) {
                            if (endIndex > index$iv + 2) {
                                if (($this$commonToUtf8String[index$iv + 2] & 192) == 128) {
                                    i5 = 3;
                                }
                            }
                            i5 = 2;
                        }
                    }
                    i5 = 1;
                } else {
                    byte b0$iv$iv3 = $this$commonToUtf8String[index$iv];
                    byte b1$iv$iv3 = $this$commonToUtf8String[index$iv + 1];
                    if (!((b1$iv$iv3 & 192) == 128)) {
                        if (65533 != 65533) {
                            int length3 = length + 1;
                            chars[length] = (char) ((65533 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                            length = length3 + 1;
                            chars[length3] = (char) ((65533 & 1023) + 56320);
                        } else {
                            length++;
                            chars[length] = 65533;
                        }
                        Unit unit12 = Unit.INSTANCE;
                        i6 = index$iv;
                        i5 = 1;
                    } else {
                        byte b2$iv$iv2 = $this$commonToUtf8String[index$iv + 2];
                        if (!((b2$iv$iv2 & 192) == 128)) {
                            if (65533 != 65533) {
                                int length4 = length + 1;
                                chars[length] = (char) ((65533 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                length = length4 + 1;
                                chars[length4] = (char) ((65533 & 1023) + 56320);
                            } else {
                                length++;
                                chars[length] = 65533;
                            }
                            Unit unit13 = Unit.INSTANCE;
                            i6 = index$iv;
                            i5 = 2;
                        } else {
                            byte b3$iv$iv = $this$commonToUtf8String[index$iv + 3];
                            if (!((b3$iv$iv & 192) == 128)) {
                                if (65533 != 65533) {
                                    int length5 = length + 1;
                                    chars[length] = (char) ((65533 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                    length = length5 + 1;
                                    chars[length5] = (char) ((65533 & 1023) + 56320);
                                } else {
                                    length++;
                                    chars[length] = 65533;
                                }
                                Unit unit14 = Unit.INSTANCE;
                                i6 = index$iv;
                                i5 = 3;
                            } else {
                                int codePoint$iv$iv3 = (((3678080 ^ b3$iv$iv) ^ (b2$iv$iv2 << 6)) ^ (b1$iv$iv3 << 12)) ^ (b0$iv$iv3 << 18);
                                if (codePoint$iv$iv3 > 1114111) {
                                    if (65533 != 65533) {
                                        int length6 = length + 1;
                                        chars[length] = (char) ((65533 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                        length = length6 + 1;
                                        chars[length6] = (char) ((65533 & 1023) + 56320);
                                    } else {
                                        length++;
                                        chars[length] = 65533;
                                    }
                                    Unit unit15 = Unit.INSTANCE;
                                    i6 = index$iv;
                                } else {
                                    if (55296 <= codePoint$iv$iv3) {
                                        z2 = codePoint$iv$iv3 <= 57343;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        if (65533 != 65533) {
                                            int length7 = length + 1;
                                            chars[length] = (char) ((65533 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                            length = length7 + 1;
                                            chars[length7] = (char) ((65533 & 1023) + 56320);
                                        } else {
                                            length++;
                                            chars[length] = 65533;
                                        }
                                        Unit unit16 = Unit.INSTANCE;
                                        i6 = index$iv;
                                    } else if (codePoint$iv$iv3 < 65536) {
                                        if (65533 != 65533) {
                                            int length8 = length + 1;
                                            chars[length] = (char) ((65533 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                            length = length8 + 1;
                                            chars[length8] = (char) ((65533 & 1023) + 56320);
                                        } else {
                                            length++;
                                            chars[length] = 65533;
                                        }
                                        Unit unit17 = Unit.INSTANCE;
                                        i6 = index$iv;
                                    } else {
                                        if (codePoint$iv$iv3 != 65533) {
                                            int length9 = length + 1;
                                            chars[length] = (char) ((codePoint$iv$iv3 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                            length = length9 + 1;
                                            chars[length9] = (char) ((codePoint$iv$iv3 & 1023) + 56320);
                                        } else {
                                            length++;
                                            chars[length] = 65533;
                                        }
                                        Unit unit18 = Unit.INSTANCE;
                                        i6 = index$iv;
                                    }
                                }
                                i5 = 4;
                            }
                        }
                    }
                }
                index$iv = i6 + i5;
            } else {
                length++;
                chars[length] = 65533;
                index$iv++;
            }
        }
        return StringsKt.concatToString(chars, 0, length);
    }

    @NotNull
    public static final byte[] commonAsUtf8ToByteArray(@NotNull String $this$commonAsUtf8ToByteArray) {
        Intrinsics.checkNotNullParameter($this$commonAsUtf8ToByteArray, "<this>");
        byte[] bytes = new byte[4 * $this$commonAsUtf8ToByteArray.length()];
        int index = 0;
        int length = $this$commonAsUtf8ToByteArray.length();
        if (0 < length) {
            do {
                index++;
                char b0 = $this$commonAsUtf8ToByteArray.charAt(index);
                if (Intrinsics.compare((int) b0, 128) >= 0) {
                    int size = index;
                    int endIndex$iv = $this$commonAsUtf8ToByteArray.length();
                    int index$iv = index;
                    while (index$iv < endIndex$iv) {
                        char c$iv = $this$commonAsUtf8ToByteArray.charAt(index$iv);
                        if (Intrinsics.compare((int) c$iv, 128) < 0) {
                            size++;
                            bytes[size] = (byte) c$iv;
                            index$iv++;
                            while (index$iv < endIndex$iv && Intrinsics.compare((int) $this$commonAsUtf8ToByteArray.charAt(index$iv), 128) < 0) {
                                index$iv++;
                                size++;
                                bytes[size] = (byte) $this$commonAsUtf8ToByteArray.charAt(index$iv);
                            }
                        } else if (Intrinsics.compare((int) c$iv, 2048) < 0) {
                            int size2 = size + 1;
                            bytes[size] = (byte) ((c$iv >> 6) | 192);
                            size = size2 + 1;
                            bytes[size2] = (byte) ((c$iv & '?') | 128);
                            index$iv++;
                        } else {
                            if (!(55296 <= c$iv ? c$iv <= 57343 : false)) {
                                int size3 = size + 1;
                                bytes[size] = (byte) ((c$iv >> '\f') | PacketOpcodes.SceneAvatarStaminaStepRsp);
                                int size4 = size3 + 1;
                                bytes[size3] = (byte) (((c$iv >> 6) & 63) | 128);
                                size = size4 + 1;
                                bytes[size4] = (byte) ((c$iv & '?') | 128);
                                index$iv++;
                            } else {
                                if (Intrinsics.compare((int) c$iv, 56319) <= 0 && endIndex$iv > index$iv + 1) {
                                    char charAt = $this$commonAsUtf8ToByteArray.charAt(index$iv + 1);
                                    if (56320 <= charAt ? charAt <= 57343 : false) {
                                        int codePoint$iv = ((c$iv << '\n') + $this$commonAsUtf8ToByteArray.charAt(index$iv + 1)) - 56613888;
                                        int size5 = size + 1;
                                        bytes[size] = (byte) ((codePoint$iv >> 18) | PacketOpcodes.SceneKickPlayerRsp);
                                        int size6 = size5 + 1;
                                        bytes[size5] = (byte) (((codePoint$iv >> 12) & 63) | 128);
                                        int size7 = size6 + 1;
                                        bytes[size6] = (byte) (((codePoint$iv >> 6) & 63) | 128);
                                        size = size7 + 1;
                                        bytes[size7] = (byte) ((codePoint$iv & 63) | 128);
                                        index$iv += 2;
                                    }
                                }
                                size++;
                                bytes[size] = 63;
                                index$iv++;
                            }
                        }
                    }
                    byte[] copyOf = Arrays.copyOf(bytes, size);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                    return copyOf;
                }
                bytes[index] = (byte) b0;
            } while (index < length);
            byte[] copyOf2 = Arrays.copyOf(bytes, $this$commonAsUtf8ToByteArray.length());
            Intrinsics.checkNotNullExpressionValue(copyOf2, "java.util.Arrays.copyOf(this, newSize)");
            return copyOf2;
        }
        byte[] copyOf2 = Arrays.copyOf(bytes, $this$commonAsUtf8ToByteArray.length());
        Intrinsics.checkNotNullExpressionValue(copyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf2;
    }
}
