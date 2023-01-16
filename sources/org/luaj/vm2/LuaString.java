package org.luaj.vm2;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import org.luaj.vm2.lib.MathLib;

/* loaded from: grasscutter.jar:org/luaj/vm2/LuaString.class */
public class LuaString extends LuaValue {
    public static LuaValue s_metatable;
    public final byte[] m_bytes;
    public final int m_offset;
    public final int m_length;
    private final int m_hashcode;
    static final int RECENT_STRINGS_CACHE_SIZE = 128;
    static final int RECENT_STRINGS_MAX_LENGTH = 32;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/LuaString$RecentShortStrings.class */
    public static final class RecentShortStrings {
        private static final LuaString[] recent_short_strings = new LuaString[128];

        private RecentShortStrings() {
        }

        static LuaString[] access$000() {
            return recent_short_strings;
        }
    }

    public static LuaString valueOf(String str) {
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[lengthAsUtf8(charArray)];
        encodeToUtf8(charArray, charArray.length, bArr, 0);
        return valueUsing(bArr, 0, bArr.length);
    }

    public static LuaString valueOf(byte[] bArr, int i, int i2) {
        if (i2 > 32) {
            return valueFromCopy(bArr, i, i2);
        }
        int hashCode = hashCode(bArr, i, i2);
        int i3 = hashCode & 127;
        LuaString luaString = RecentShortStrings.access$000()[i3];
        if (luaString != null && luaString.m_hashcode == hashCode && luaString.byteseq(bArr, i, i2)) {
            return luaString;
        }
        LuaString valueFromCopy = valueFromCopy(bArr, i, i2);
        RecentShortStrings.access$000()[i3] = valueFromCopy;
        return valueFromCopy;
    }

    private static LuaString valueFromCopy(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr2[i3] = bArr[i + i3];
        }
        return new LuaString(bArr2, 0, i2);
    }

    public static LuaString valueUsing(byte[] bArr, int i, int i2) {
        if (bArr.length > 32) {
            return new LuaString(bArr, i, i2);
        }
        int hashCode = hashCode(bArr, i, i2);
        int i3 = hashCode & 127;
        LuaString luaString = RecentShortStrings.access$000()[i3];
        if (luaString != null && luaString.m_hashcode == hashCode && luaString.byteseq(bArr, i, i2)) {
            return luaString;
        }
        LuaString luaString2 = new LuaString(bArr, i, i2);
        RecentShortStrings.access$000()[i3] = luaString2;
        return luaString2;
    }

    public static LuaString valueOf(char[] cArr) {
        return valueOf(cArr, 0, cArr.length);
    }

    public static LuaString valueOf(char[] cArr, int i, int i2) {
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) cArr[i3 + i];
        }
        return valueUsing(bArr, 0, i2);
    }

    public static LuaString valueOf(byte[] bArr) {
        return valueOf(bArr, 0, bArr.length);
    }

    public static LuaString valueUsing(byte[] bArr) {
        return valueUsing(bArr, 0, bArr.length);
    }

    private LuaString(byte[] bArr, int i, int i2) {
        this.m_bytes = bArr;
        this.m_offset = i;
        this.m_length = i2;
        this.m_hashcode = hashCode(bArr, i, i2);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isstring() {
        return true;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue getmetatable() {
        return s_metatable;
    }

    @Override // org.luaj.vm2.LuaValue
    public int type() {
        return 4;
    }

    @Override // org.luaj.vm2.LuaValue
    public String typename() {
        return "string";
    }

    @Override // org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
    public String tojstring() {
        return decodeAsUtf8(this.m_bytes, this.m_offset, this.m_length);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue neg() {
        double scannumber = scannumber();
        return Double.isNaN(scannumber) ? neg() : valueOf(-scannumber);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue add(LuaValue luaValue) {
        double scannumber = scannumber();
        return Double.isNaN(scannumber) ? arithmt(ADD, luaValue) : luaValue.add(scannumber);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue add(double d) {
        return valueOf(checkarith() + d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue add(int i) {
        return valueOf(checkarith() + ((double) i));
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue sub(LuaValue luaValue) {
        double scannumber = scannumber();
        return Double.isNaN(scannumber) ? arithmt(SUB, luaValue) : luaValue.subFrom(scannumber);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue sub(double d) {
        return valueOf(checkarith() - d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue sub(int i) {
        return valueOf(checkarith() - ((double) i));
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue subFrom(double d) {
        return valueOf(d - checkarith());
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mul(LuaValue luaValue) {
        double scannumber = scannumber();
        return Double.isNaN(scannumber) ? arithmt(MUL, luaValue) : luaValue.mul(scannumber);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mul(double d) {
        return valueOf(checkarith() * d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mul(int i) {
        return valueOf(checkarith() * ((double) i));
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue pow(LuaValue luaValue) {
        double scannumber = scannumber();
        return Double.isNaN(scannumber) ? arithmt(POW, luaValue) : luaValue.powWith(scannumber);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue pow(double d) {
        return MathLib.dpow(checkarith(), d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue pow(int i) {
        return MathLib.dpow(checkarith(), (double) i);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue powWith(double d) {
        return MathLib.dpow(d, checkarith());
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue powWith(int i) {
        return MathLib.dpow((double) i, checkarith());
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue div(LuaValue luaValue) {
        double scannumber = scannumber();
        return Double.isNaN(scannumber) ? arithmt(DIV, luaValue) : luaValue.divInto(scannumber);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue div(double d) {
        return LuaDouble.ddiv(checkarith(), d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue div(int i) {
        return LuaDouble.ddiv(checkarith(), (double) i);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue divInto(double d) {
        return LuaDouble.ddiv(d, checkarith());
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mod(LuaValue luaValue) {
        double scannumber = scannumber();
        return Double.isNaN(scannumber) ? arithmt(MOD, luaValue) : luaValue.modFrom(scannumber);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mod(double d) {
        return LuaDouble.dmod(checkarith(), d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mod(int i) {
        return LuaDouble.dmod(checkarith(), (double) i);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue modFrom(double d) {
        return LuaDouble.dmod(d, checkarith());
    }

    @Override // org.luaj.vm2.LuaValue
    /* renamed from: lt */
    public LuaValue mo18lt(LuaValue luaValue) {
        return luaValue.strcmp(this) > 0 ? LuaValue.TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lt_b(LuaValue luaValue) {
        return luaValue.strcmp(this) > 0;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lt_b(int i) {
        typerror("attempt to compare string with number");
        return false;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lt_b(double d) {
        typerror("attempt to compare string with number");
        return false;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue lteq(LuaValue luaValue) {
        return luaValue.strcmp(this) >= 0 ? LuaValue.TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lteq_b(LuaValue luaValue) {
        return luaValue.strcmp(this) >= 0;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lteq_b(int i) {
        typerror("attempt to compare string with number");
        return false;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lteq_b(double d) {
        typerror("attempt to compare string with number");
        return false;
    }

    @Override // org.luaj.vm2.LuaValue
    /* renamed from: gt */
    public LuaValue mo21gt(LuaValue luaValue) {
        return luaValue.strcmp(this) < 0 ? LuaValue.TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gt_b(LuaValue luaValue) {
        return luaValue.strcmp(this) < 0;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gt_b(int i) {
        typerror("attempt to compare string with number");
        return false;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gt_b(double d) {
        typerror("attempt to compare string with number");
        return false;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue gteq(LuaValue luaValue) {
        return luaValue.strcmp(this) <= 0 ? LuaValue.TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gteq_b(LuaValue luaValue) {
        return luaValue.strcmp(this) <= 0;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gteq_b(int i) {
        typerror("attempt to compare string with number");
        return false;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gteq_b(double d) {
        typerror("attempt to compare string with number");
        return false;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue concat(LuaValue luaValue) {
        return luaValue.concatTo(this);
    }

    @Override // org.luaj.vm2.LuaValue
    public Buffer concat(Buffer buffer) {
        return buffer.concatTo(this);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue concatTo(LuaNumber luaNumber) {
        return concatTo(luaNumber.strvalue());
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue concatTo(LuaString luaString) {
        byte[] bArr = new byte[luaString.m_length + this.m_length];
        System.arraycopy(luaString.m_bytes, luaString.m_offset, bArr, 0, luaString.m_length);
        System.arraycopy(this.m_bytes, this.m_offset, bArr, luaString.m_length, this.m_length);
        return valueUsing(bArr, 0, bArr.length);
    }

    @Override // org.luaj.vm2.LuaValue
    public int strcmp(LuaValue luaValue) {
        return -luaValue.strcmp(this);
    }

    @Override // org.luaj.vm2.LuaValue
    public int strcmp(LuaString luaString) {
        int i = 0;
        int i2 = 0;
        while (i < this.m_length && i2 < luaString.m_length) {
            if (this.m_bytes[this.m_offset + i] != luaString.m_bytes[luaString.m_offset + i2]) {
                return this.m_bytes[this.m_offset + i] - luaString.m_bytes[luaString.m_offset + i2];
            }
            i++;
            i2++;
        }
        return this.m_length - luaString.m_length;
    }

    private double checkarith() {
        double scannumber = scannumber();
        if (Double.isNaN(scannumber)) {
            aritherror();
        }
        return scannumber;
    }

    @Override // org.luaj.vm2.LuaValue
    public int checkint() {
        return (int) ((long) checkdouble());
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaInteger checkinteger() {
        return valueOf(checkint());
    }

    @Override // org.luaj.vm2.LuaValue
    public long checklong() {
        return (long) checkdouble();
    }

    @Override // org.luaj.vm2.LuaValue
    public double checkdouble() {
        double scannumber = scannumber();
        if (Double.isNaN(scannumber)) {
            argerror("number");
        }
        return scannumber;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaNumber checknumber() {
        return valueOf(checkdouble());
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaNumber checknumber(String str) {
        double scannumber = scannumber();
        if (Double.isNaN(scannumber)) {
            error(str);
        }
        return valueOf(scannumber);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isnumber() {
        return !Double.isNaN(scannumber());
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isint() {
        double scannumber = scannumber();
        return !Double.isNaN(scannumber) && ((double) ((int) scannumber)) == scannumber;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean islong() {
        double scannumber = scannumber();
        return !Double.isNaN(scannumber) && ((double) ((long) scannumber)) == scannumber;
    }

    @Override // org.luaj.vm2.LuaValue
    public byte tobyte() {
        return (byte) toint();
    }

    @Override // org.luaj.vm2.LuaValue
    public char tochar() {
        return (char) toint();
    }

    @Override // org.luaj.vm2.LuaValue
    public double todouble() {
        double scannumber = scannumber();
        if (Double.isNaN(scannumber)) {
            return 0.0d;
        }
        return scannumber;
    }

    @Override // org.luaj.vm2.LuaValue
    public float tofloat() {
        return (float) todouble();
    }

    @Override // org.luaj.vm2.LuaValue
    public int toint() {
        return (int) tolong();
    }

    @Override // org.luaj.vm2.LuaValue
    public long tolong() {
        return (long) todouble();
    }

    @Override // org.luaj.vm2.LuaValue
    public short toshort() {
        return (short) toint();
    }

    @Override // org.luaj.vm2.LuaValue
    public double optdouble(double d) {
        return checknumber().checkdouble();
    }

    @Override // org.luaj.vm2.LuaValue
    public int optint(int i) {
        return checknumber().checkint();
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaInteger optinteger(LuaInteger luaInteger) {
        return checknumber().checkinteger();
    }

    @Override // org.luaj.vm2.LuaValue
    public long optlong(long j) {
        return checknumber().checklong();
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaNumber optnumber(LuaNumber luaNumber) {
        return checknumber().checknumber();
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaString optstring(LuaString luaString) {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue tostring() {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public String optjstring(String str) {
        return tojstring();
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaString strvalue() {
        return this;
    }

    public LuaString substring(int i, int i2) {
        int i3 = this.m_offset + i;
        int i4 = i2 - i;
        return i4 >= this.m_length / 2 ? valueUsing(this.m_bytes, i3, i4) : valueOf(this.m_bytes, i3, i4);
    }

    public int hashCode() {
        return this.m_hashcode;
    }

    public static int hashCode(byte[] bArr, int i, int i2) {
        int i3 = i2;
        int i4 = (i2 >> 5) + 1;
        for (int i5 = i2; i5 >= i4; i5 -= i4) {
            i3 ^= ((i3 << 5) + (i3 >> 2)) + (bArr[(i + i5) - 1] & 255);
        }
        return i3;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean equals(Object obj) {
        if (obj instanceof LuaString) {
            return raweq((LuaString) obj);
        }
        return false;
    }

    @Override // org.luaj.vm2.LuaValue
    /* renamed from: eq */
    public LuaValue mo24eq(LuaValue luaValue) {
        return luaValue.raweq(this) ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean eq_b(LuaValue luaValue) {
        return luaValue.raweq(this);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean raweq(LuaValue luaValue) {
        return luaValue.raweq(this);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean raweq(LuaString luaString) {
        if (this == luaString) {
            return true;
        }
        if (luaString.m_length != this.m_length) {
            return false;
        }
        if (luaString.m_bytes == this.m_bytes && luaString.m_offset == this.m_offset) {
            return true;
        }
        if (luaString.hashCode() != hashCode()) {
            return false;
        }
        for (int i = 0; i < this.m_length; i++) {
            if (luaString.m_bytes[luaString.m_offset + i] != this.m_bytes[this.m_offset + i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(LuaString luaString, int i, LuaString luaString2, int i2, int i3) {
        return equals(luaString.m_bytes, luaString.m_offset + i, luaString2.m_bytes, luaString2.m_offset + i2, i3);
    }

    private boolean byteseq(byte[] bArr, int i, int i2) {
        return this.m_length == i2 && equals(this.m_bytes, this.m_offset, bArr, i, i2);
    }

    public static boolean equals(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr.length < i + i3 || bArr2.length < i2 + i3) {
            return false;
        }
        do {
            i3--;
            if (i3 < 0) {
                return true;
            }
            i++;
            i2++;
        } while (bArr[i] == bArr2[i2]);
        return false;
    }

    public void write(DataOutputStream dataOutputStream, int i, int i2) throws IOException {
        dataOutputStream.write(this.m_bytes, this.m_offset + i, i2);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue len() {
        return LuaInteger.valueOf(this.m_length);
    }

    @Override // org.luaj.vm2.LuaValue
    public int length() {
        return this.m_length;
    }

    @Override // org.luaj.vm2.LuaValue
    public int rawlen() {
        return this.m_length;
    }

    public int luaByte(int i) {
        return this.m_bytes[this.m_offset + i] & 255;
    }

    public int charAt(int i) {
        if (i >= 0 && i < this.m_length) {
            return luaByte(i);
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.luaj.vm2.LuaValue
    public String checkjstring() {
        return tojstring();
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaString checkstring() {
        return this;
    }

    public InputStream toInputStream() {
        return new ByteArrayInputStream(this.m_bytes, this.m_offset, this.m_length);
    }

    public void copyInto(int i, byte[] bArr, int i2, int i3) {
        System.arraycopy(this.m_bytes, this.m_offset + i, bArr, i2, i3);
    }

    public int indexOfAny(LuaString luaString) {
        int i = this.m_offset + this.m_length;
        int i2 = luaString.m_offset + luaString.m_length;
        for (int i3 = this.m_offset; i3 < i; i3++) {
            for (int i4 = luaString.m_offset; i4 < i2; i4++) {
                if (this.m_bytes[i3] == luaString.m_bytes[i4]) {
                    return i3 - this.m_offset;
                }
            }
        }
        return -1;
    }

    public int indexOf(byte b, int i) {
        for (int i2 = i; i2 < this.m_length; i2++) {
            if (this.m_bytes[this.m_offset + i2] == b) {
                return i2;
            }
        }
        return -1;
    }

    public int indexOf(LuaString luaString, int i) {
        int length = luaString.length();
        int i2 = this.m_length - length;
        for (int i3 = i; i3 <= i2; i3++) {
            if (equals(this.m_bytes, this.m_offset + i3, luaString.m_bytes, luaString.m_offset, length)) {
                return i3;
            }
        }
        return -1;
    }

    public int lastIndexOf(LuaString luaString) {
        int length = luaString.length();
        for (int i = this.m_length - length; i >= 0; i--) {
            if (equals(this.m_bytes, this.m_offset + i, luaString.m_bytes, luaString.m_offset, length)) {
                return i;
            }
        }
        return -1;
    }

    public static String decodeAsUtf8(byte[] bArr, int i, int i2) {
        int i3;
        int i4 = i;
        int i5 = i + i2;
        int i6 = 0;
        while (i4 < i5) {
            i4++;
            switch (224 & bArr[i4]) {
                case 192:
                    break;
                case PacketOpcodes.WorldPlayerLocationNotify:
                    i4++;
                    break;
                default:
                    i6++;
            }
            i4++;
            i6++;
        }
        char[] cArr = new char[i6];
        int i7 = i;
        int i8 = i + i2;
        int i9 = 0;
        while (i7 < i8) {
            i9++;
            i7++;
            byte b = bArr[i7];
            if (b >= 0 || i7 >= i8) {
                i3 = b;
            } else if (b < -32 || i7 + 1 >= i8) {
                i7++;
                i3 = ((b & 63) << 6) | (bArr[i7] & 63);
            } else {
                int i10 = i7 + 1;
                i7 = i10 + 1;
                i3 = ((b & 15) << 12) | ((bArr[i7] & 63) << 6) | (bArr[i10] & 63);
            }
            cArr[i9] = (char) i3;
        }
        return new String(cArr);
    }

    public static int lengthAsUtf8(char[] cArr) {
        int length = cArr.length;
        int i = length;
        int i2 = length;
        while (true) {
            i2--;
            if (i2 < 0) {
                return i;
            }
            char c = cArr[i2];
            if (c >= 128) {
                i += c >= 2048 ? 2 : 1;
            }
        }
    }

    public static int encodeToUtf8(char[] cArr, int i, byte[] bArr, int i2) {
        int i3 = i2;
        for (int i4 = 0; i4 < i; i4++) {
            char c = cArr[i4];
            if (c < 128) {
                i3++;
                bArr[i3] = (byte) c;
            } else if (c < 2048) {
                int i5 = i3 + 1;
                bArr[i3] = (byte) (192 | ((c >> 6) & 31));
                i3 = i5 + 1;
                bArr[i5] = (byte) (128 | (c & '?'));
            } else {
                int i6 = i3 + 1;
                bArr[i3] = (byte) (224 | ((c >> '\f') & 15));
                int i7 = i6 + 1;
                bArr[i6] = (byte) (128 | ((c >> 6) & 63));
                i3 = i7 + 1;
                bArr[i7] = (byte) (128 | (c & '?'));
            }
        }
        return i3 - i2;
    }

    public boolean isValidUtf8() {
        int i = this.m_offset;
        int i2 = this.m_offset + this.m_length;
        while (i < i2) {
            i++;
            byte b = this.m_bytes[i];
            if (b < 0) {
                if ((b & 224) == 192 && i < i2) {
                    i++;
                    if ((this.m_bytes[i] & 192) == 128) {
                        continue;
                    }
                }
                if ((b & 240) != 224 || i + 1 >= i2) {
                    return false;
                }
                int i3 = i + 1;
                if ((this.m_bytes[i] & 192) != 128) {
                    return false;
                }
                i = i3 + 1;
                if ((this.m_bytes[i3] & 192) != 128) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue tonumber() {
        double scannumber = scannumber();
        return Double.isNaN(scannumber) ? NIL : valueOf(scannumber);
    }

    public LuaValue tonumber(int i) {
        double scannumber = scannumber(i);
        return Double.isNaN(scannumber) ? NIL : valueOf(scannumber);
    }

    public double scannumber() {
        int i = this.m_offset;
        int i2 = this.m_offset + this.m_length;
        while (i < i2 && this.m_bytes[i] == 32) {
            i++;
        }
        while (i < i2 && this.m_bytes[i2 - 1] == 32) {
            i2--;
        }
        if (i >= i2) {
            return Double.NaN;
        }
        if (this.m_bytes[i] == 48 && i + 1 < i2 && (this.m_bytes[i + 1] == 120 || this.m_bytes[i + 1] == 88)) {
            return scanlong(16, i + 2, i2);
        }
        double scanlong = scanlong(10, i, i2);
        return Double.isNaN(scanlong) ? scandouble(i, i2) : scanlong;
    }

    public double scannumber(int i) {
        if (i < 2 || i > 36) {
            return Double.NaN;
        }
        int i2 = this.m_offset;
        int i3 = this.m_offset + this.m_length;
        while (i2 < i3 && this.m_bytes[i2] == 32) {
            i2++;
        }
        while (i2 < i3 && this.m_bytes[i3 - 1] == 32) {
            i3--;
        }
        if (i2 >= i3) {
            return Double.NaN;
        }
        return scanlong(i, i2, i3);
    }

    private double scanlong(int i, int i2, int i3) {
        long j = 0;
        boolean z = this.m_bytes[i2] == 45;
        for (int i4 = z ? i2 + 1 : i2; i4 < i3; i4++) {
            int i5 = this.m_bytes[i4] - ((i <= 10 || (this.m_bytes[i4] >= 48 && this.m_bytes[i4] <= 57)) ? 48 : (this.m_bytes[i4] < 65 || this.m_bytes[i4] > 90) ? (byte) 87 : 55);
            if (i5 < 0 || i5 >= i) {
                return Double.NaN;
            }
            j = (j * ((long) i)) + ((long) i5);
            if (j < 0) {
                return Double.NaN;
            }
        }
        return z ? (double) (-j) : (double) j;
    }

    private double scandouble(int i, int i2) {
        if (i2 > i + 64) {
            i2 = i + 64;
        }
        for (int i3 = i; i3 < i2; i3++) {
            switch (this.m_bytes[i3]) {
                case 43:
                case 45:
                case 46:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 69:
                case 101:
                case 44:
                case 47:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 70:
                case 71:
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
                case 88:
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
                case 99:
                case 100:
                default:
                    return Double.NaN;
            }
        }
        char[] cArr = new char[i2 - i];
        for (int i4 = i; i4 < i2; i4++) {
            cArr[i4 - i] = (char) this.m_bytes[i4];
        }
        try {
            return Double.parseDouble(new String(cArr));
        } catch (Exception e) {
            return Double.NaN;
        }
    }

    public void printToStream(PrintStream printStream) {
        int i = this.m_length;
        for (int i2 = 0; i2 < i; i2++) {
            printStream.print((char) this.m_bytes[this.m_offset + i2]);
        }
    }
}
