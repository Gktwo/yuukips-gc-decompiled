package okio;

import emu.grasscutter.net.packet.PacketOpcodes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Utf8.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��D\n��\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n��\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\b\u001a\u0011\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007H\b\u001a4\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001��\u001a4\u0010\u0017\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001��\u001a4\u0010\u0018\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001��\u001a4\u0010\u0019\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001��\u001a4\u0010\u001a\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001��\u001a4\u0010\u001c\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001��\u001a%\u0010\u001d\u001a\u00020\u001e*\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u001f\"\u000e\u0010��\u001a\u00020\u0001XT¢\u0006\u0002\n��\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n��\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n��\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n��\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n��\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n��\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n��\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n��\u0002\u0007\n\u0005\b20\u0001¨\u0006 "}, m373d2 = {"HIGH_SURROGATE_HEADER", "", "LOG_SURROGATE_HEADER", "MASK_2BYTES", "MASK_3BYTES", "MASK_4BYTES", "REPLACEMENT_BYTE", "", "REPLACEMENT_CHARACTER", "", "REPLACEMENT_CODE_POINT", "isIsoControl", "", "codePoint", "isUtf8Continuation", "byte", "process2Utf8Bytes", "", "beginIndex", "endIndex", "yield", "Lkotlin/Function1;", "", "process3Utf8Bytes", "process4Utf8Bytes", "processUtf16Chars", "processUtf8Bytes", "", "processUtf8CodePoints", "utf8Size", "", "size", "okio"})
@JvmName(name = "Utf8")
/* loaded from: grasscutter.jar:okio/Utf8.class */
public final class Utf8 {
    public static final byte REPLACEMENT_BYTE;
    public static final char REPLACEMENT_CHARACTER;
    public static final int REPLACEMENT_CODE_POINT;
    public static final int HIGH_SURROGATE_HEADER;
    public static final int LOG_SURROGATE_HEADER;
    public static final int MASK_2BYTES;
    public static final int MASK_3BYTES;
    public static final int MASK_4BYTES;

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String $this$utf8Size, int beginIndex) {
        Intrinsics.checkNotNullParameter($this$utf8Size, "<this>");
        return size$default($this$utf8Size, beginIndex, 0, 2, null);
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String $this$utf8Size) {
        Intrinsics.checkNotNullParameter($this$utf8Size, "<this>");
        return size$default($this$utf8Size, 0, 0, 3, null);
    }

    public static /* synthetic */ long size$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return size(str, i, i2);
    }

    /* JADX WARN: Type inference failed for: r0v27, types: [long] */
    /* JADX WARN: Type inference failed for: r0v34, types: [long] */
    /* JADX WARN: Type inference failed for: r0v40, types: [long] */
    /* JADX WARN: Type inference failed for: r0v51, types: [long] */
    /* JADX WARN: Type inference failed for: r0v59, types: [long] */
    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String $this$utf8Size, int beginIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$utf8Size, "<this>");
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("beginIndex < 0: ", Integer.valueOf(beginIndex)).toString());
        }
        if (!(endIndex >= beginIndex)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + endIndex + " < " + beginIndex).toString());
        }
        if (!(endIndex <= $this$utf8Size.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + endIndex + " > " + $this$utf8Size.length()).toString());
        }
        char c = 0;
        int i = beginIndex;
        while (i < endIndex) {
            int c2 = $this$utf8Size.charAt(i);
            if (c2 < 128) {
                c++;
                i++;
            } else if (c2 < 2048) {
                c += (long) 2;
                i++;
            } else if (c2 < 55296 || c2 > 57343) {
                c += (long) 3;
                i++;
            } else {
                int low = i + 1 < endIndex ? $this$utf8Size.charAt(i + 1) : 0;
                if (c2 > 56319 || low < 56320 || low > 57343) {
                    c++;
                    i++;
                } else {
                    c += (long) 4;
                    i += 2;
                }
            }
        }
        return c;
    }

    public static final boolean isIsoControl(int codePoint) {
        if (!(0 <= codePoint ? codePoint <= 31 : false)) {
            if (!(127 <= codePoint ? codePoint <= 159 : false)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isUtf8Continuation(byte b) {
        return (b & 192) == 128;
    }

    public static final void processUtf8Bytes(@NotNull String $this$processUtf8Bytes, int beginIndex, int endIndex, @NotNull Function1<? super Byte, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$processUtf8Bytes, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int index = beginIndex;
        while (index < endIndex) {
            char c = $this$processUtf8Bytes.charAt(index);
            if (Intrinsics.compare((int) c, 128) < 0) {
                function1.invoke(Byte.valueOf((byte) c));
                index++;
                while (index < endIndex && Intrinsics.compare((int) $this$processUtf8Bytes.charAt(index), 128) < 0) {
                    index++;
                    function1.invoke(Byte.valueOf((byte) $this$processUtf8Bytes.charAt(index)));
                }
            } else if (Intrinsics.compare((int) c, 2048) < 0) {
                function1.invoke(Byte.valueOf((byte) ((c >> 6) | 192)));
                function1.invoke(Byte.valueOf((byte) ((c & '?') | 128)));
                index++;
            } else {
                if (!(55296 <= c ? c <= 57343 : false)) {
                    function1.invoke(Byte.valueOf((byte) ((c >> '\f') | PacketOpcodes.WorldPlayerLocationNotify)));
                    function1.invoke(Byte.valueOf((byte) (((c >> 6) & 63) | 128)));
                    function1.invoke(Byte.valueOf((byte) ((c & '?') | 128)));
                    index++;
                } else {
                    if (Intrinsics.compare((int) c, 56319) <= 0 && endIndex > index + 1) {
                        char charAt = $this$processUtf8Bytes.charAt(index + 1);
                        if (56320 <= charAt ? charAt <= 57343 : false) {
                            int codePoint = ((c << '\n') + $this$processUtf8Bytes.charAt(index + 1)) - 56613888;
                            function1.invoke(Byte.valueOf((byte) ((codePoint >> 18) | PacketOpcodes.ExecuteGadgetLuaRsp)));
                            function1.invoke(Byte.valueOf((byte) (((codePoint >> 12) & 63) | 128)));
                            function1.invoke(Byte.valueOf((byte) (((codePoint >> 6) & 63) | 128)));
                            function1.invoke(Byte.valueOf((byte) ((codePoint & 63) | 128)));
                            index += 2;
                        }
                    }
                    function1.invoke((byte) 63);
                    index++;
                }
            }
        }
    }

    public static final void processUtf8CodePoints(@NotNull byte[] $this$processUtf8CodePoints, int beginIndex, int endIndex, @NotNull Function1<? super Integer, Unit> function1) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        boolean z2;
        Intrinsics.checkNotNullParameter($this$processUtf8CodePoints, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int index = beginIndex;
        while (index < endIndex) {
            byte b0 = $this$processUtf8CodePoints[index];
            if (b0 >= 0) {
                function1.invoke(Integer.valueOf(b0));
                index++;
                while (index < endIndex && $this$processUtf8CodePoints[index] >= 0) {
                    index++;
                    function1.invoke(Integer.valueOf($this$processUtf8CodePoints[index]));
                }
            } else if ((b0 >> 5) == -2) {
                if (endIndex <= index + 1) {
                    function1.invoke(65533);
                    Unit unit = Unit.INSTANCE;
                    i2 = index;
                    i = 1;
                } else {
                    byte b0$iv = $this$processUtf8CodePoints[index];
                    byte b1$iv = $this$processUtf8CodePoints[index + 1];
                    if (!((b1$iv & 192) == 128)) {
                        function1.invoke(65533);
                        Unit unit2 = Unit.INSTANCE;
                        i2 = index;
                        i = 1;
                    } else {
                        int codePoint$iv = (3968 ^ b1$iv) ^ (b0$iv << 6);
                        if (codePoint$iv < 128) {
                            function1.invoke(65533);
                            Unit unit3 = Unit.INSTANCE;
                            i2 = index;
                        } else {
                            function1.invoke(Integer.valueOf(codePoint$iv));
                            Unit unit4 = Unit.INSTANCE;
                            i2 = index;
                        }
                        i = 2;
                    }
                }
                index = i2 + i;
            } else if ((b0 >> 4) == -2) {
                if (endIndex <= index + 2) {
                    function1.invoke(65533);
                    Unit unit5 = Unit.INSTANCE;
                    i4 = index;
                    if (endIndex > index + 1) {
                        if (($this$processUtf8CodePoints[index + 1] & 192) == 128) {
                            i3 = 2;
                        }
                    }
                    i3 = 1;
                } else {
                    byte b0$iv2 = $this$processUtf8CodePoints[index];
                    byte b1$iv2 = $this$processUtf8CodePoints[index + 1];
                    if (!((b1$iv2 & 192) == 128)) {
                        function1.invoke(65533);
                        Unit unit6 = Unit.INSTANCE;
                        i4 = index;
                        i3 = 1;
                    } else {
                        byte b2$iv = $this$processUtf8CodePoints[index + 2];
                        if (!((b2$iv & 192) == 128)) {
                            function1.invoke(65533);
                            Unit unit7 = Unit.INSTANCE;
                            i4 = index;
                            i3 = 2;
                        } else {
                            int codePoint$iv2 = ((-123008 ^ b2$iv) ^ (b1$iv2 << 6)) ^ (b0$iv2 << 12);
                            if (codePoint$iv2 < 2048) {
                                function1.invoke(65533);
                                Unit unit8 = Unit.INSTANCE;
                                i4 = index;
                            } else {
                                if (55296 <= codePoint$iv2) {
                                    z = codePoint$iv2 <= 57343;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    function1.invoke(65533);
                                    Unit unit9 = Unit.INSTANCE;
                                    i4 = index;
                                } else {
                                    function1.invoke(Integer.valueOf(codePoint$iv2));
                                    Unit unit10 = Unit.INSTANCE;
                                    i4 = index;
                                }
                            }
                            i3 = 3;
                        }
                    }
                }
                index = i4 + i3;
            } else if ((b0 >> 3) == -2) {
                if (endIndex <= index + 3) {
                    function1.invoke(65533);
                    Unit unit11 = Unit.INSTANCE;
                    i6 = index;
                    if (endIndex > index + 1) {
                        if (($this$processUtf8CodePoints[index + 1] & 192) == 128) {
                            if (endIndex > index + 2) {
                                if (($this$processUtf8CodePoints[index + 2] & 192) == 128) {
                                    i5 = 3;
                                }
                            }
                            i5 = 2;
                        }
                    }
                    i5 = 1;
                } else {
                    byte b0$iv3 = $this$processUtf8CodePoints[index];
                    byte b1$iv3 = $this$processUtf8CodePoints[index + 1];
                    if (!((b1$iv3 & 192) == 128)) {
                        function1.invoke(65533);
                        Unit unit12 = Unit.INSTANCE;
                        i6 = index;
                        i5 = 1;
                    } else {
                        byte b2$iv2 = $this$processUtf8CodePoints[index + 2];
                        if (!((b2$iv2 & 192) == 128)) {
                            function1.invoke(65533);
                            Unit unit13 = Unit.INSTANCE;
                            i6 = index;
                            i5 = 2;
                        } else {
                            byte b3$iv = $this$processUtf8CodePoints[index + 3];
                            if (!((b3$iv & 192) == 128)) {
                                function1.invoke(65533);
                                Unit unit14 = Unit.INSTANCE;
                                i6 = index;
                                i5 = 3;
                            } else {
                                int codePoint$iv3 = (((3678080 ^ b3$iv) ^ (b2$iv2 << 6)) ^ (b1$iv3 << 12)) ^ (b0$iv3 << 18);
                                if (codePoint$iv3 > 1114111) {
                                    function1.invoke(65533);
                                    Unit unit15 = Unit.INSTANCE;
                                    i6 = index;
                                } else {
                                    if (55296 <= codePoint$iv3) {
                                        z2 = codePoint$iv3 <= 57343;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        function1.invoke(65533);
                                        Unit unit16 = Unit.INSTANCE;
                                        i6 = index;
                                    } else if (codePoint$iv3 < 65536) {
                                        function1.invoke(65533);
                                        Unit unit17 = Unit.INSTANCE;
                                        i6 = index;
                                    } else {
                                        function1.invoke(Integer.valueOf(codePoint$iv3));
                                        Unit unit18 = Unit.INSTANCE;
                                        i6 = index;
                                    }
                                }
                                i5 = 4;
                            }
                        }
                    }
                }
                index = i6 + i5;
            } else {
                function1.invoke(65533);
                index++;
            }
        }
    }

    public static final void processUtf16Chars(@NotNull byte[] $this$processUtf16Chars, int beginIndex, int endIndex, @NotNull Function1<? super Character, Unit> function1) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        boolean z2;
        Intrinsics.checkNotNullParameter($this$processUtf16Chars, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int index = beginIndex;
        while (index < endIndex) {
            byte b0 = $this$processUtf16Chars[index];
            if (b0 >= 0) {
                function1.invoke(Character.valueOf((char) b0));
                index++;
                while (index < endIndex && $this$processUtf16Chars[index] >= 0) {
                    index++;
                    function1.invoke(Character.valueOf((char) $this$processUtf16Chars[index]));
                }
            } else if ((b0 >> 5) == -2) {
                if (endIndex <= index + 1) {
                    function1.invoke(Character.valueOf((char) 65533));
                    Unit unit = Unit.INSTANCE;
                    i2 = index;
                    i = 1;
                } else {
                    byte b0$iv = $this$processUtf16Chars[index];
                    byte b1$iv = $this$processUtf16Chars[index + 1];
                    if (!((b1$iv & 192) == 128)) {
                        function1.invoke(Character.valueOf((char) 65533));
                        Unit unit2 = Unit.INSTANCE;
                        i2 = index;
                        i = 1;
                    } else {
                        int codePoint$iv = (3968 ^ b1$iv) ^ (b0$iv << 6);
                        if (codePoint$iv < 128) {
                            function1.invoke(Character.valueOf((char) 65533));
                            Unit unit3 = Unit.INSTANCE;
                            i2 = index;
                        } else {
                            function1.invoke(Character.valueOf((char) codePoint$iv));
                            Unit unit4 = Unit.INSTANCE;
                            i2 = index;
                        }
                        i = 2;
                    }
                }
                index = i2 + i;
            } else if ((b0 >> 4) == -2) {
                if (endIndex <= index + 2) {
                    function1.invoke(Character.valueOf((char) 65533));
                    Unit unit5 = Unit.INSTANCE;
                    i4 = index;
                    if (endIndex > index + 1) {
                        if (($this$processUtf16Chars[index + 1] & 192) == 128) {
                            i3 = 2;
                        }
                    }
                    i3 = 1;
                } else {
                    byte b0$iv2 = $this$processUtf16Chars[index];
                    byte b1$iv2 = $this$processUtf16Chars[index + 1];
                    if (!((b1$iv2 & 192) == 128)) {
                        function1.invoke(Character.valueOf((char) 65533));
                        Unit unit6 = Unit.INSTANCE;
                        i4 = index;
                        i3 = 1;
                    } else {
                        byte b2$iv = $this$processUtf16Chars[index + 2];
                        if (!((b2$iv & 192) == 128)) {
                            function1.invoke(Character.valueOf((char) 65533));
                            Unit unit7 = Unit.INSTANCE;
                            i4 = index;
                            i3 = 2;
                        } else {
                            int codePoint$iv2 = ((-123008 ^ b2$iv) ^ (b1$iv2 << 6)) ^ (b0$iv2 << 12);
                            if (codePoint$iv2 < 2048) {
                                function1.invoke(Character.valueOf((char) 65533));
                                Unit unit8 = Unit.INSTANCE;
                                i4 = index;
                            } else {
                                if (55296 <= codePoint$iv2) {
                                    z = codePoint$iv2 <= 57343;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    function1.invoke(Character.valueOf((char) 65533));
                                    Unit unit9 = Unit.INSTANCE;
                                    i4 = index;
                                } else {
                                    function1.invoke(Character.valueOf((char) codePoint$iv2));
                                    Unit unit10 = Unit.INSTANCE;
                                    i4 = index;
                                }
                            }
                            i3 = 3;
                        }
                    }
                }
                index = i4 + i3;
            } else if ((b0 >> 3) == -2) {
                if (endIndex <= index + 3) {
                    if (65533 != 65533) {
                        function1.invoke(Character.valueOf((char) ((65533 >>> 10) + HIGH_SURROGATE_HEADER)));
                        function1.invoke(Character.valueOf((char) ((65533 & 1023) + 56320)));
                    } else {
                        function1.invoke((char) 65533);
                    }
                    Unit unit11 = Unit.INSTANCE;
                    i6 = index;
                    if (endIndex > index + 1) {
                        if (($this$processUtf16Chars[index + 1] & 192) == 128) {
                            if (endIndex > index + 2) {
                                if (($this$processUtf16Chars[index + 2] & 192) == 128) {
                                    i5 = 3;
                                }
                            }
                            i5 = 2;
                        }
                    }
                    i5 = 1;
                } else {
                    byte b0$iv3 = $this$processUtf16Chars[index];
                    byte b1$iv3 = $this$processUtf16Chars[index + 1];
                    if (!((b1$iv3 & 192) == 128)) {
                        if (65533 != 65533) {
                            function1.invoke(Character.valueOf((char) ((65533 >>> 10) + HIGH_SURROGATE_HEADER)));
                            function1.invoke(Character.valueOf((char) ((65533 & 1023) + 56320)));
                        } else {
                            function1.invoke((char) 65533);
                        }
                        Unit unit12 = Unit.INSTANCE;
                        i6 = index;
                        i5 = 1;
                    } else {
                        byte b2$iv2 = $this$processUtf16Chars[index + 2];
                        if (!((b2$iv2 & 192) == 128)) {
                            if (65533 != 65533) {
                                function1.invoke(Character.valueOf((char) ((65533 >>> 10) + HIGH_SURROGATE_HEADER)));
                                function1.invoke(Character.valueOf((char) ((65533 & 1023) + 56320)));
                            } else {
                                function1.invoke((char) 65533);
                            }
                            Unit unit13 = Unit.INSTANCE;
                            i6 = index;
                            i5 = 2;
                        } else {
                            byte b3$iv = $this$processUtf16Chars[index + 3];
                            if (!((b3$iv & 192) == 128)) {
                                if (65533 != 65533) {
                                    function1.invoke(Character.valueOf((char) ((65533 >>> 10) + HIGH_SURROGATE_HEADER)));
                                    function1.invoke(Character.valueOf((char) ((65533 & 1023) + 56320)));
                                } else {
                                    function1.invoke((char) 65533);
                                }
                                Unit unit14 = Unit.INSTANCE;
                                i6 = index;
                                i5 = 3;
                            } else {
                                int codePoint$iv3 = (((3678080 ^ b3$iv) ^ (b2$iv2 << 6)) ^ (b1$iv3 << 12)) ^ (b0$iv3 << 18);
                                if (codePoint$iv3 > 1114111) {
                                    if (65533 != 65533) {
                                        function1.invoke(Character.valueOf((char) ((65533 >>> 10) + HIGH_SURROGATE_HEADER)));
                                        function1.invoke(Character.valueOf((char) ((65533 & 1023) + 56320)));
                                    } else {
                                        function1.invoke((char) 65533);
                                    }
                                    Unit unit15 = Unit.INSTANCE;
                                    i6 = index;
                                } else {
                                    if (55296 <= codePoint$iv3) {
                                        z2 = codePoint$iv3 <= 57343;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        if (65533 != 65533) {
                                            function1.invoke(Character.valueOf((char) ((65533 >>> 10) + HIGH_SURROGATE_HEADER)));
                                            function1.invoke(Character.valueOf((char) ((65533 & 1023) + 56320)));
                                        } else {
                                            function1.invoke((char) 65533);
                                        }
                                        Unit unit16 = Unit.INSTANCE;
                                        i6 = index;
                                    } else if (codePoint$iv3 < 65536) {
                                        if (65533 != 65533) {
                                            function1.invoke(Character.valueOf((char) ((65533 >>> 10) + HIGH_SURROGATE_HEADER)));
                                            function1.invoke(Character.valueOf((char) ((65533 & 1023) + 56320)));
                                        } else {
                                            function1.invoke((char) 65533);
                                        }
                                        Unit unit17 = Unit.INSTANCE;
                                        i6 = index;
                                    } else {
                                        if (codePoint$iv3 != 65533) {
                                            function1.invoke(Character.valueOf((char) ((codePoint$iv3 >>> 10) + HIGH_SURROGATE_HEADER)));
                                            function1.invoke(Character.valueOf((char) ((codePoint$iv3 & 1023) + 56320)));
                                        } else {
                                            function1.invoke((char) 65533);
                                        }
                                        Unit unit18 = Unit.INSTANCE;
                                        i6 = index;
                                    }
                                }
                                i5 = 4;
                            }
                        }
                    }
                }
                index = i6 + i5;
            } else {
                function1.invoke((char) 65533);
                index++;
            }
        }
    }

    public static final int process2Utf8Bytes(@NotNull byte[] $this$process2Utf8Bytes, int beginIndex, int endIndex, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$process2Utf8Bytes, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        if (endIndex <= beginIndex + 1) {
            function1.invoke(65533);
            return 1;
        }
        byte b0 = $this$process2Utf8Bytes[beginIndex];
        byte b1 = $this$process2Utf8Bytes[beginIndex + 1];
        if (!((b1 & 192) == 128)) {
            function1.invoke(65533);
            return 1;
        }
        int codePoint = (3968 ^ b1) ^ (b0 << 6);
        if (codePoint < 128) {
            function1.invoke(65533);
            return 2;
        }
        function1.invoke(Integer.valueOf(codePoint));
        return 2;
    }

    public static final int process3Utf8Bytes(@NotNull byte[] $this$process3Utf8Bytes, int beginIndex, int endIndex, @NotNull Function1<? super Integer, Unit> function1) {
        boolean z;
        Intrinsics.checkNotNullParameter($this$process3Utf8Bytes, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        if (endIndex <= beginIndex + 2) {
            function1.invoke(65533);
            if (endIndex <= beginIndex + 1) {
                return 1;
            }
            if (!(($this$process3Utf8Bytes[beginIndex + 1] & 192) == 128)) {
                return 1;
            }
            return 2;
        }
        byte b0 = $this$process3Utf8Bytes[beginIndex];
        byte b1 = $this$process3Utf8Bytes[beginIndex + 1];
        if (!((b1 & 192) == 128)) {
            function1.invoke(65533);
            return 1;
        }
        byte b2 = $this$process3Utf8Bytes[beginIndex + 2];
        if (!((b2 & 192) == 128)) {
            function1.invoke(65533);
            return 2;
        }
        int codePoint = ((-123008 ^ b2) ^ (b1 << 6)) ^ (b0 << 12);
        if (codePoint < 2048) {
            function1.invoke(65533);
            return 3;
        }
        if (55296 <= codePoint) {
            z = codePoint <= 57343;
        } else {
            z = false;
        }
        if (z) {
            function1.invoke(65533);
            return 3;
        }
        function1.invoke(Integer.valueOf(codePoint));
        return 3;
    }

    public static final int process4Utf8Bytes(@NotNull byte[] $this$process4Utf8Bytes, int beginIndex, int endIndex, @NotNull Function1<? super Integer, Unit> function1) {
        boolean z;
        Intrinsics.checkNotNullParameter($this$process4Utf8Bytes, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        if (endIndex <= beginIndex + 3) {
            function1.invoke(65533);
            if (endIndex <= beginIndex + 1) {
                return 1;
            }
            if (!(($this$process4Utf8Bytes[beginIndex + 1] & 192) == 128)) {
                return 1;
            }
            if (endIndex <= beginIndex + 2) {
                return 2;
            }
            if (!(($this$process4Utf8Bytes[beginIndex + 2] & 192) == 128)) {
                return 2;
            }
            return 3;
        }
        byte b0 = $this$process4Utf8Bytes[beginIndex];
        byte b1 = $this$process4Utf8Bytes[beginIndex + 1];
        if (!((b1 & 192) == 128)) {
            function1.invoke(65533);
            return 1;
        }
        byte b2 = $this$process4Utf8Bytes[beginIndex + 2];
        if (!((b2 & 192) == 128)) {
            function1.invoke(65533);
            return 2;
        }
        byte b3 = $this$process4Utf8Bytes[beginIndex + 3];
        if (!((b3 & 192) == 128)) {
            function1.invoke(65533);
            return 3;
        }
        int codePoint = (((3678080 ^ b3) ^ (b2 << 6)) ^ (b1 << 12)) ^ (b0 << 18);
        if (codePoint > 1114111) {
            function1.invoke(65533);
            return 4;
        }
        if (55296 <= codePoint) {
            z = codePoint <= 57343;
        } else {
            z = false;
        }
        if (z) {
            function1.invoke(65533);
            return 4;
        } else if (codePoint < 65536) {
            function1.invoke(65533);
            return 4;
        } else {
            function1.invoke(Integer.valueOf(codePoint));
            return 4;
        }
    }
}
