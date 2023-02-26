package org.luaj.vm2.lib;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.luaj.vm2.Buffer;
import org.luaj.vm2.LuaClosure;
import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.compiler.DumpState;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/StringLib.class */
public class StringLib extends TwoArgFunction {
    private static final String FLAGS = "-+ #0";
    private static final int L_ESC = 37;
    private static final int MAX_CAPTURES = 32;
    private static final int CAP_UNFINISHED = -1;
    private static final int CAP_POSITION = -2;
    private static final byte MASK_ALPHA = 1;
    private static final byte MASK_LOWERCASE = 2;
    private static final byte MASK_UPPERCASE = 4;
    private static final byte MASK_DIGIT = 8;
    private static final byte MASK_PUNCT = 16;
    private static final byte MASK_SPACE = 32;
    private static final byte MASK_CONTROL = 64;
    private static final byte MASK_HEXDIGIT = Byte.MIN_VALUE;
    private static final LuaString SPECIALS = valueOf("^$*+?.([%-");
    private static final byte[] CHAR_TABLE = new byte[256];

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/StringLib$FormatDesc.class */
    static class FormatDesc {
        private boolean leftAdjust;
        private boolean zeroPad;
        private boolean explicitPlus;
        private boolean space;
        private boolean alternateForm;
        private static final int MAX_FLAGS = 5;
        private int width;
        private int precision;
        public final int conversion;
        public final int length;

        public FormatDesc(Varargs varargs, LuaString luaString, int i) {
            int i2;
            int i3 = i;
            int length = luaString.length();
            int i4 = 0;
            boolean z = true;
            while (z) {
                if (i3 < length) {
                    i3++;
                    i2 = luaString.luaByte(i3);
                } else {
                    i2 = 0;
                }
                i4 = i2;
                switch (i2) {
                    case 32:
                        this.space = true;
                        break;
                    case 35:
                        this.alternateForm = true;
                        break;
                    case 43:
                        this.explicitPlus = true;
                        break;
                    case 45:
                        this.leftAdjust = true;
                        break;
                    case 48:
                        this.zeroPad = true;
                        break;
                    default:
                        z = false;
                        break;
                }
            }
            if (i3 - i > 5) {
                LuaValue.error("invalid format (repeated flags)");
            }
            this.width = -1;
            if (Character.isDigit((char) i4)) {
                this.width = i4 - 48;
                if (i3 < length) {
                    i3++;
                    i4 = luaString.luaByte(i3);
                } else {
                    i4 = 0;
                }
                if (Character.isDigit((char) i4)) {
                    this.width = (this.width * 10) + (i4 - 48);
                    if (i3 < length) {
                        i3++;
                        i4 = luaString.luaByte(i3);
                    } else {
                        i4 = 0;
                    }
                }
            }
            this.precision = -1;
            if (i4 == 46) {
                if (i3 < length) {
                    i3++;
                    i4 = luaString.luaByte(i3);
                } else {
                    i4 = 0;
                }
                if (Character.isDigit((char) i4)) {
                    this.precision = i4 - 48;
                    if (i3 < length) {
                        i3++;
                        i4 = luaString.luaByte(i3);
                    } else {
                        i4 = 0;
                    }
                    if (Character.isDigit((char) i4)) {
                        this.precision = (this.precision * 10) + (i4 - 48);
                        if (i3 < length) {
                            i3++;
                            i4 = luaString.luaByte(i3);
                        } else {
                            i4 = 0;
                        }
                    }
                }
            }
            if (Character.isDigit((char) i4)) {
                LuaValue.error("invalid format (width or precision too long)");
            }
            this.zeroPad &= !this.leftAdjust;
            this.conversion = i4;
            this.length = i3 - i;
        }

        public void format(Buffer buffer, byte b) {
            buffer.append(b);
        }

        public void format(Buffer buffer, long j) {
            String str;
            int i;
            if (j == 0 && this.precision == 0) {
                str = "";
            } else {
                switch (this.conversion) {
                    case 88:
                    case 120:
                        i = 16;
                        break;
                    case 111:
                        i = 8;
                        break;
                    default:
                        i = 10;
                        break;
                }
                str = Long.toString(j, i);
                if (this.conversion == 88) {
                    str = str.toUpperCase();
                }
            }
            int length = str.length();
            int i2 = length;
            if (j < 0) {
                i2--;
            } else if (this.explicitPlus || this.space) {
                length++;
            }
            int i3 = this.precision > i2 ? this.precision - i2 : (this.precision != -1 || !this.zeroPad || this.width <= length) ? 0 : this.width - length;
            int i4 = length + i3;
            int i5 = this.width > i4 ? this.width - i4 : 0;
            if (!this.leftAdjust) {
                pad(buffer, ' ', i5);
            }
            if (j < 0) {
                if (i3 > 0) {
                    buffer.append((byte) 45);
                    str = str.substring(1);
                }
            } else if (this.explicitPlus) {
                buffer.append((byte) 43);
            } else if (this.space) {
                buffer.append((byte) 32);
            }
            if (i3 > 0) {
                pad(buffer, '0', i3);
            }
            buffer.append(str);
            if (this.leftAdjust) {
                pad(buffer, ' ', i5);
            }
        }

        public void format(Buffer buffer, double d) {
            buffer.append(String.valueOf(d));
        }

        public void format(Buffer buffer, LuaString luaString) {
            int indexOf = luaString.indexOf((byte) 0, 0);
            if (indexOf != -1) {
                luaString = luaString.substring(0, indexOf);
            }
            buffer.append(luaString);
        }

        public static final void pad(Buffer buffer, char c, int i) {
            byte b = (byte) c;
            while (true) {
                i--;
                if (i > 0) {
                    buffer.append(b);
                } else {
                    return;
                }
            }
        }

        static int access$200(FormatDesc formatDesc) {
            return formatDesc.precision;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/StringLib$GMatchAux.class */
    static class GMatchAux extends VarArgFunction {
        private final int srclen;

        /* renamed from: ms */
        private final MatchState f3304ms;
        private int soffset = 0;

        public GMatchAux(Varargs varargs, LuaString luaString, LuaString luaString2) {
            this.srclen = luaString.length();
            this.f3304ms = new MatchState(varargs, luaString, luaString2);
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            while (this.soffset < this.srclen) {
                this.f3304ms.reset();
                int match = this.f3304ms.match(this.soffset, 0);
                if (match >= 0) {
                    int i = this.soffset;
                    this.soffset = match;
                    return this.f3304ms.push_captures(true, i, match);
                }
                this.soffset++;
            }
            return NIL;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/StringLib$MatchState.class */
    public static class MatchState {

        /* renamed from: s */
        final LuaString f3305s;

        /* renamed from: p */
        final LuaString f3306p;
        final Varargs args;
        int level = 0;
        int[] cinit = new int[32];
        int[] clen = new int[32];

        MatchState(Varargs varargs, LuaString luaString, LuaString luaString2) {
            this.f3305s = luaString;
            this.f3306p = luaString2;
            this.args = varargs;
        }

        void reset() {
            this.level = 0;
        }

        private void add_s(Buffer buffer, LuaString luaString, int i, int i2) {
            int length = luaString.length();
            int i3 = 0;
            while (i3 < length) {
                byte luaByte = (byte) luaString.luaByte(i3);
                if (luaByte != 37) {
                    buffer.append(luaByte);
                } else {
                    i3++;
                    byte luaByte2 = (byte) luaString.luaByte(i3);
                    if (!Character.isDigit((char) luaByte2)) {
                        buffer.append(luaByte2);
                    } else if (luaByte2 == 48) {
                        buffer.append(this.f3305s.substring(i, i2));
                    } else {
                        buffer.append(push_onecapture(luaByte2 - 49, i, i2).strvalue());
                    }
                }
                i3++;
            }
        }

        public void add_value(Buffer buffer, int i, int i2, LuaValue luaValue) {
            LuaString luaString;
            switch (luaValue.type()) {
                case 3:
                case 4:
                    add_s(buffer, luaValue.strvalue(), i, i2);
                    return;
                case 5:
                    luaString = luaValue.get(push_onecapture(0, i, i2));
                    break;
                case 6:
                    luaString = luaValue.invoke(push_captures(true, i, i2)).arg1();
                    break;
                default:
                    LuaValue.error("bad argument: string/function/table expected");
                    return;
            }
            if (!luaString.toboolean()) {
                luaString = this.f3305s.substring(i, i2);
            } else if (!luaString.isstring()) {
                LuaValue.error(new StringBuffer().append("invalid replacement value (a ").append(luaString.typename()).append(")").toString());
            }
            buffer.append(luaString.strvalue());
        }

        Varargs push_captures(boolean z, int i, int i2) {
            int i3 = (this.level != 0 || !z) ? this.level : 1;
            switch (i3) {
                case 0:
                    return LuaValue.NONE;
                case 1:
                    return push_onecapture(0, i, i2);
                default:
                    LuaValue[] luaValueArr = new LuaValue[i3];
                    for (int i4 = 0; i4 < i3; i4++) {
                        luaValueArr[i4] = push_onecapture(i4, i, i2);
                    }
                    return LuaValue.varargsOf(luaValueArr);
            }
        }

        private LuaValue push_onecapture(int i, int i2, int i3) {
            if (i >= this.level) {
                return i == 0 ? this.f3305s.substring(i2, i3) : LuaValue.error("invalid capture index");
            }
            int i4 = this.clen[i];
            if (i4 == -1) {
                return LuaValue.error("unfinished capture");
            }
            if (i4 == -2) {
                return LuaValue.valueOf(this.cinit[i] + 1);
            }
            int i5 = this.cinit[i];
            return this.f3305s.substring(i5, i5 + i4);
        }

        private int check_capture(int i) {
            int i2 = i - 49;
            if (i2 < 0 || i2 >= this.level || this.clen[i2] == -1) {
                LuaValue.error("invalid capture index");
            }
            return i2;
        }

        private int capture_to_close() {
            int i = this.level;
            while (true) {
                i--;
                if (i < 0) {
                    LuaValue.error("invalid pattern capture");
                    return 0;
                } else if (this.clen[i] == -1) {
                    return i;
                }
            }
        }

        int classend(int i) {
            int i2 = i + 1;
            switch (this.f3306p.luaByte(i)) {
                case 37:
                    if (i2 == this.f3306p.length()) {
                        LuaValue.error("malformed pattern (ends with %)");
                    }
                    return i2 + 1;
                case 91:
                    if (this.f3306p.luaByte(i2) == 94) {
                        i2++;
                    }
                    do {
                        if (i2 == this.f3306p.length()) {
                            LuaValue.error("malformed pattern (missing ])");
                        }
                        i2++;
                        if (this.f3306p.luaByte(i2) == 37 && i2 != this.f3306p.length()) {
                            i2++;
                        }
                    } while (this.f3306p.luaByte(i2) != 93);
                    return i2 + 1;
                default:
                    return i2;
            }
        }

        static boolean match_class(int i, int i2) {
            boolean z;
            char lowerCase = Character.toLowerCase((char) i2);
            byte b = StringLib.access$300()[i];
            switch (lowerCase) {
                case 'a':
                    z = (b & 1) != 0;
                    break;
                case 'b':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'm':
                case 'n':
                case 'o':
                case 'q':
                case 'r':
                case 't':
                case 'v':
                case 'y':
                default:
                    return i2 == i;
                case 'c':
                    z = (b & 64) != 0;
                    break;
                case 'd':
                    z = (b & 8) != 0;
                    break;
                case 'l':
                    z = (b & 2) != 0;
                    break;
                case 'p':
                    z = (b & 16) != 0;
                    break;
                case 's':
                    z = (b & 32) != 0;
                    break;
                case 'u':
                    z = (b & 4) != 0;
                    break;
                case 'w':
                    z = (b & 9) != 0;
                    break;
                case 'x':
                    z = (b & Byte.MIN_VALUE) != 0;
                    break;
                case 'z':
                    z = i == 0;
                    break;
            }
            return lowerCase == i2 ? z : !z;
        }

        boolean matchbracketclass(int i, int i2, int i3) {
            boolean z = true;
            if (this.f3306p.luaByte(i2 + 1) == 94) {
                z = false;
                i2++;
            }
            while (true) {
                i2++;
                if (i2 >= i3) {
                    return !z;
                }
                if (this.f3306p.luaByte(i2) == 37) {
                    i2++;
                    if (match_class(i, this.f3306p.luaByte(i2))) {
                        return z;
                    }
                } else if (this.f3306p.luaByte(i2 + 1) == 45 && i2 + 2 < i3) {
                    i2 += 2;
                    if (this.f3306p.luaByte(i2 - 2) <= i && i <= this.f3306p.luaByte(i2)) {
                        return z;
                    }
                } else if (this.f3306p.luaByte(i2) == i) {
                    return z;
                }
            }
        }

        boolean singlematch(int i, int i2, int i3) {
            switch (this.f3306p.luaByte(i2)) {
                case 37:
                    return match_class(i, this.f3306p.luaByte(i2 + 1));
                case 46:
                    return true;
                case 91:
                    return matchbracketclass(i, i2, i3 - 1);
                default:
                    return this.f3306p.luaByte(i2) == i;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:95:0x0150 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        int match(int r7, int r8) {
            /*
            // Method dump skipped, instructions count: 546
            */
            throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.lib.StringLib.MatchState.match(int, int):int");
        }

        int max_expand(int i, int i2, int i3) {
            int i4 = 0;
            while (i + i4 < this.f3305s.length() && singlematch(this.f3305s.luaByte(i + i4), i2, i3)) {
                i4++;
            }
            while (i4 >= 0) {
                int match = match(i + i4, i3 + 1);
                if (match != -1) {
                    return match;
                }
                i4--;
            }
            return -1;
        }

        int min_expand(int i, int i2, int i3) {
            while (true) {
                int match = match(i, i3 + 1);
                if (match != -1) {
                    return match;
                }
                if (i >= this.f3305s.length() || !singlematch(this.f3305s.luaByte(i), i2, i3)) {
                    return -1;
                }
                i++;
            }
        }

        int start_capture(int i, int i2, int i3) {
            int i4 = this.level;
            if (i4 >= 32) {
                LuaValue.error("too many captures");
            }
            this.cinit[i4] = i;
            this.clen[i4] = i3;
            this.level = i4 + 1;
            int match = match(i, i2);
            if (match == -1) {
                this.level--;
            }
            return match;
        }

        int end_capture(int i, int i2) {
            int capture_to_close = capture_to_close();
            this.clen[capture_to_close] = i - this.cinit[capture_to_close];
            int match = match(i, i2);
            if (match == -1) {
                this.clen[capture_to_close] = -1;
            }
            return match;
        }

        int match_capture(int i, int i2) {
            int check_capture = check_capture(i2);
            int i3 = this.clen[check_capture];
            if (this.f3305s.length() - i < i3 || !LuaString.equals(this.f3305s, this.cinit[check_capture], this.f3305s, i, i3)) {
                return -1;
            }
            return i + i3;
        }

        int matchbalance(int i, int i2) {
            int luaByte;
            int length = this.f3306p.length();
            if (i2 == length || i2 + 1 == length) {
                LuaValue.error("unbalanced pattern");
            }
            int length2 = this.f3305s.length();
            if (i >= length2 || this.f3305s.luaByte(i) != (luaByte = this.f3306p.luaByte(i2))) {
                return -1;
            }
            int luaByte2 = this.f3306p.luaByte(i2 + 1);
            int i3 = 1;
            while (true) {
                i++;
                if (i >= length2) {
                    return -1;
                }
                if (this.f3305s.luaByte(i) == luaByte2) {
                    i3--;
                    if (i3 == 0) {
                        return i + 1;
                    }
                } else if (this.f3305s.luaByte(i) == luaByte) {
                    i3++;
                }
            }
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/StringLib$byte_.class */
    static final class byte_ extends VarArgFunction {
        byte_() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaString checkstring = varargs.checkstring(1);
            int i = checkstring.m_length;
            int access$000 = StringLib.access$000(varargs.optint(2, 1), i);
            int access$0002 = StringLib.access$000(varargs.optint(3, access$000), i);
            if (access$000 <= 0) {
                access$000 = 1;
            }
            if (access$0002 > i) {
                access$0002 = i;
            }
            if (access$000 > access$0002) {
                return NONE;
            }
            int i2 = (access$0002 - access$000) + 1;
            if (access$000 + i2 <= access$0002) {
                error("string slice too long");
            }
            LuaValue[] luaValueArr = new LuaValue[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                luaValueArr[i3] = valueOf(checkstring.luaByte((access$000 + i3) - 1));
            }
            return varargsOf(luaValueArr);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/StringLib$char_.class */
    static final class char_ extends VarArgFunction {
        char_() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            int narg = varargs.narg();
            byte[] bArr = new byte[narg];
            int i = 0;
            int i2 = 1;
            while (i < narg) {
                int checkint = varargs.checkint(i2);
                if (checkint < 0 || checkint >= 256) {
                    argerror(i2, "invalid value");
                }
                bArr[i] = (byte) checkint;
                i++;
                i2++;
            }
            return LuaString.valueUsing(bArr);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/StringLib$dump.class */
    static final class dump extends OneArgFunction {
        dump() {
        }

        @Override // org.luaj.vm2.lib.OneArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            LuaFunction checkfunction = luaValue.checkfunction();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                DumpState.dump(((LuaClosure) checkfunction).f3251p, byteArrayOutputStream, true);
                return LuaString.valueUsing(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                return error(e.getMessage());
            }
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/StringLib$find.class */
    static final class find extends VarArgFunction {
        find() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            return StringLib.str_find_aux(varargs, true);
        }
    }

    /* renamed from: org.luaj.vm2.lib.StringLib$format */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/StringLib$format.class */
    static final class C5865format extends VarArgFunction {
        C5865format() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaString checkstring = varargs.checkstring(1);
            int length = checkstring.length();
            Buffer buffer = new Buffer(length);
            int i = 1;
            int i2 = 0;
            while (i2 < length) {
                i2++;
                int luaByte = checkstring.luaByte(i2);
                switch (luaByte) {
                    case 10:
                        buffer.append("\n");
                        break;
                    case 37:
                        if (i2 >= length) {
                            break;
                        } else if (checkstring.luaByte(i2) == 37) {
                            i2++;
                            buffer.append((byte) 37);
                            break;
                        } else {
                            i++;
                            FormatDesc formatDesc = new FormatDesc(varargs, checkstring, i2);
                            i2 += formatDesc.length;
                            switch (formatDesc.conversion) {
                                case 69:
                                case 71:
                                case 101:
                                case 102:
                                case 103:
                                    formatDesc.format(buffer, varargs.checkdouble(i));
                                    continue;
                                case 70:
                                case 72:
                                case 73:
                                case 74:
                                case 75:
                                case 76:
                                case 77:
                                case 78:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                case 84:
                                case 85:
                                case 86:
                                case 87:
                                case 89:
                                case 90:
                                case 91:
                                case 92:
                                case 93:
                                case 94:
                                case 95:
                                case 96:
                                case 97:
                                case 98:
                                case 104:
                                case 106:
                                case 107:
                                case 108:
                                case 109:
                                case 110:
                                case 112:
                                case 114:
                                case 116:
                                case 118:
                                case 119:
                                default:
                                    error(new StringBuffer().append("invalid option '%").append((char) formatDesc.conversion).append("' to 'format'").toString());
                                    continue;
                                case 88:
                                case 111:
                                case 117:
                                case 120:
                                    formatDesc.format(buffer, varargs.checklong(i));
                                    continue;
                                case 99:
                                    formatDesc.format(buffer, (byte) varargs.checkint(i));
                                    continue;
                                case 100:
                                case 105:
                                    formatDesc.format(buffer, (long) varargs.checkint(i));
                                    continue;
                                case 113:
                                    StringLib.access$100(buffer, varargs.checkstring(i));
                                    continue;
                                case 115:
                                    LuaString checkstring2 = varargs.checkstring(i);
                                    if (FormatDesc.access$200(formatDesc) != -1 || checkstring2.length() < 100) {
                                        formatDesc.format(buffer, checkstring2);
                                        break;
                                    } else {
                                        buffer.append(checkstring2);
                                        continue;
                                    }
                            }
                        }
                    default:
                        buffer.append((byte) luaByte);
                        break;
                }
            }
            return buffer.tostring();
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/StringLib$gmatch.class */
    static final class gmatch extends VarArgFunction {
        gmatch() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            return new GMatchAux(varargs, varargs.checkstring(1), varargs.checkstring(2));
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/StringLib$gsub.class */
    static final class gsub extends VarArgFunction {
        gsub() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaString checkstring = varargs.checkstring(1);
            int length = checkstring.length();
            LuaString checkstring2 = varargs.checkstring(2);
            LuaValue arg = varargs.arg(3);
            int optint = varargs.optint(4, length + 1);
            boolean z = checkstring2.length() > 0 && checkstring2.charAt(0) == 94;
            Buffer buffer = new Buffer(length);
            MatchState matchState = new MatchState(varargs, checkstring, checkstring2);
            int i = 0;
            int i2 = 0;
            while (i2 < optint) {
                matchState.reset();
                int match = matchState.match(i, z ? 1 : 0);
                if (match != -1) {
                    i2++;
                    matchState.add_value(buffer, i, match, arg);
                }
                if (match == -1 || match <= i) {
                    if (i >= length) {
                        break;
                    }
                    i++;
                    buffer.append((byte) checkstring.luaByte(i));
                } else {
                    i = match;
                }
                if (z) {
                    break;
                }
            }
            buffer.append(checkstring.substring(i, length));
            return varargsOf(buffer.tostring(), valueOf(i2));
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/StringLib$len.class */
    static final class len extends OneArgFunction {
        len() {
        }

        @Override // org.luaj.vm2.lib.OneArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return luaValue.checkstring().len();
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/StringLib$lower.class */
    static final class lower extends OneArgFunction {
        lower() {
        }

        @Override // org.luaj.vm2.lib.OneArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return valueOf(luaValue.checkjstring().toLowerCase());
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/StringLib$match.class */
    static final class match extends VarArgFunction {
        match() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            return StringLib.str_find_aux(varargs, false);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/StringLib$rep.class */
    static final class rep extends VarArgFunction {
        rep() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaString checkstring = varargs.checkstring(1);
            byte[] bArr = new byte[checkstring.length() * varargs.checkint(2)];
            int length = checkstring.length();
            for (int i = 0; i < bArr.length; i += length) {
                checkstring.copyInto(0, bArr, i, length);
            }
            return LuaString.valueUsing(bArr);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/StringLib$reverse.class */
    static final class reverse extends OneArgFunction {
        reverse() {
        }

        @Override // org.luaj.vm2.lib.OneArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            LuaString checkstring = luaValue.checkstring();
            int length = checkstring.length();
            byte[] bArr = new byte[length];
            int i = 0;
            int i2 = length - 1;
            while (i < length) {
                bArr[i2] = (byte) checkstring.luaByte(i);
                i++;
                i2--;
            }
            return LuaString.valueUsing(bArr);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/StringLib$sub.class */
    static final class sub extends VarArgFunction {
        sub() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaString checkstring = varargs.checkstring(1);
            int length = checkstring.length();
            int access$000 = StringLib.access$000(varargs.checkint(2), length);
            int access$0002 = StringLib.access$000(varargs.optint(3, -1), length);
            if (access$000 < 1) {
                access$000 = 1;
            }
            if (access$0002 > length) {
                access$0002 = length;
            }
            return access$000 <= access$0002 ? checkstring.substring(access$000 - 1, access$0002) : EMPTYSTRING;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/StringLib$upper.class */
    static final class upper extends OneArgFunction {
        upper() {
        }

        @Override // org.luaj.vm2.lib.OneArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return valueOf(luaValue.checkjstring().toUpperCase());
        }
    }

    @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        LuaTable luaTable = new LuaTable();
        luaTable.set("byte", new byte_());
        luaTable.set("char", new char_());
        luaTable.set("dump", new dump());
        luaTable.set("find", new find());
        luaTable.set("format", new C5865format());
        luaTable.set("gmatch", new gmatch());
        luaTable.set("gsub", new gsub());
        luaTable.set("len", new len());
        luaTable.set("lower", new lower());
        luaTable.set("match", new match());
        luaTable.set("rep", new rep());
        luaTable.set("reverse", new reverse());
        luaTable.set("sub", new sub());
        luaTable.set("upper", new upper());
        LuaTable tableOf = LuaValue.tableOf(new LuaValue[]{INDEX, luaTable});
        luaValue2.set("string", luaTable);
        luaValue2.get("package").get("loaded").set("string", luaTable);
        if (LuaString.s_metatable == null) {
            LuaString.s_metatable = tableOf;
        }
        return luaTable;
    }

    private static void addquoted(Buffer buffer, LuaString luaString) {
        buffer.append((byte) 34);
        int length = luaString.length();
        for (int i = 0; i < length; i++) {
            int luaByte = luaString.luaByte(i);
            switch (luaByte) {
                case 10:
                case 34:
                case 92:
                    buffer.append((byte) 92);
                    buffer.append((byte) luaByte);
                    break;
                default:
                    if (luaByte <= 31 || luaByte == 127) {
                        buffer.append((byte) 92);
                        if (i + 1 == length || luaString.luaByte(i + 1) < 48 || luaString.luaByte(i + 1) > 57) {
                            buffer.append(Integer.toString(luaByte));
                            break;
                        } else {
                            buffer.append((byte) 48);
                            buffer.append((byte) ((char) (48 + (luaByte / 10))));
                            buffer.append((byte) ((char) (48 + (luaByte % 10))));
                            break;
                        }
                    } else {
                        buffer.append((byte) luaByte);
                        break;
                    }
                    break;
            }
        }
        buffer.append((byte) 34);
    }

    static Varargs str_find_aux(Varargs varargs, boolean z) {
        LuaString checkstring = varargs.checkstring(1);
        LuaString checkstring2 = varargs.checkstring(2);
        int optint = varargs.optint(3, 1);
        if (optint > 0) {
            optint = Math.min(optint - 1, checkstring.length());
        } else if (optint < 0) {
            optint = Math.max(0, checkstring.length() + optint);
        }
        if (!(z && (varargs.arg(4).toboolean() || checkstring2.indexOfAny(SPECIALS) == -1))) {
            MatchState matchState = new MatchState(varargs, checkstring, checkstring2);
            boolean z2 = false;
            int i = 0;
            if (checkstring2.luaByte(0) == 94) {
                z2 = true;
                i = 1;
            }
            int i2 = optint;
            do {
                matchState.reset();
                int match2 = matchState.match(i2, i);
                if (match2 == -1) {
                    i2++;
                    if (i2 >= checkstring.length()) {
                        break;
                    }
                } else {
                    return z ? varargsOf(valueOf(i2 + 1), valueOf(match2), matchState.push_captures(false, i2, match2)) : matchState.push_captures(true, i2, match2);
                }
            } while (!z2);
        } else {
            int indexOf = checkstring.indexOf(checkstring2, optint);
            if (indexOf != -1) {
                return varargsOf(valueOf(indexOf + 1), valueOf(indexOf + checkstring2.length()));
            }
        }
        return NIL;
    }

    private static int posrelat(int i, int i2) {
        return i >= 0 ? i : i2 + i + 1;
    }

    static int access$000(int i, int i2) {
        return posrelat(i, i2);
    }

    static void access$100(Buffer buffer, LuaString luaString) {
        addquoted(buffer, luaString);
    }

    static byte[] access$300() {
        return CHAR_TABLE;
    }

    static {
        for (int i = 0; i < 256; i++) {
            char c = (char) i;
            CHAR_TABLE[i] = (byte) ((Character.isDigit(c) ? 8 : 0) | (Character.isLowerCase(c) ? 2 : 0) | (Character.isUpperCase(c) ? 4 : 0) | ((c < ' ' || c == 127) ? 64 : 0));
            if ((c >= 'a' && c <= 'f') || ((c >= 'A' && c <= 'F') || (c >= '0' && c <= '9'))) {
                byte[] bArr = CHAR_TABLE;
                bArr[i] = (byte) (bArr[i] | Byte.MIN_VALUE);
            }
            if ((c >= '!' && c <= '/') || (c >= ':' && c <= '@')) {
                byte[] bArr2 = CHAR_TABLE;
                bArr2[i] = (byte) (bArr2[i] | 16);
            }
            if ((CHAR_TABLE[i] & 6) != 0) {
                byte[] bArr3 = CHAR_TABLE;
                bArr3[i] = (byte) (bArr3[i] | 1);
            }
        }
        CHAR_TABLE[32] = 32;
        byte[] bArr4 = CHAR_TABLE;
        bArr4[13] = (byte) (bArr4[13] | 32);
        byte[] bArr5 = CHAR_TABLE;
        bArr5[10] = (byte) (bArr5[10] | 32);
        byte[] bArr6 = CHAR_TABLE;
        bArr6[9] = (byte) (bArr6[9] | 32);
        byte[] bArr7 = CHAR_TABLE;
        bArr7[12] = (byte) (bArr7[12] | 32);
        byte[] bArr8 = CHAR_TABLE;
        bArr8[12] = (byte) (bArr8[12] | 32);
    }
}
