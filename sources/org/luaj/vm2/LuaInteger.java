package org.luaj.vm2;

import org.luaj.vm2.lib.MathLib;

/* loaded from: grasscutter.jar:org/luaj/vm2/LuaInteger.class */
public class LuaInteger extends LuaNumber {
    private static final LuaInteger[] intValues = new LuaInteger[512];

    /* renamed from: v */
    public final int f3289v;

    public static LuaInteger valueOf(int i) {
        return (i > 255 || i < -256) ? new LuaInteger(i) : intValues[i + 256];
    }

    public static LuaNumber valueOf(long j) {
        int i = (int) j;
        return j == ((long) i) ? (i > 255 || i < -256) ? new LuaInteger(i) : intValues[i + 256] : LuaDouble.valueOf((double) j);
    }

    LuaInteger(int i) {
        this.f3289v = i;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isint() {
        return true;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isinttype() {
        return true;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean islong() {
        return true;
    }

    @Override // org.luaj.vm2.LuaValue
    public byte tobyte() {
        return (byte) this.f3289v;
    }

    @Override // org.luaj.vm2.LuaValue
    public char tochar() {
        return (char) this.f3289v;
    }

    @Override // org.luaj.vm2.LuaValue
    public double todouble() {
        return (double) this.f3289v;
    }

    @Override // org.luaj.vm2.LuaValue
    public float tofloat() {
        return (float) this.f3289v;
    }

    @Override // org.luaj.vm2.LuaValue
    public int toint() {
        return this.f3289v;
    }

    @Override // org.luaj.vm2.LuaValue
    public long tolong() {
        return (long) this.f3289v;
    }

    @Override // org.luaj.vm2.LuaValue
    public short toshort() {
        return (short) this.f3289v;
    }

    @Override // org.luaj.vm2.LuaValue
    public double optdouble(double d) {
        return (double) this.f3289v;
    }

    @Override // org.luaj.vm2.LuaValue
    public int optint(int i) {
        return this.f3289v;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaInteger optinteger(LuaInteger luaInteger) {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public long optlong(long j) {
        return (long) this.f3289v;
    }

    @Override // org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
    public String tojstring() {
        return Integer.toString(this.f3289v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaString strvalue() {
        return LuaString.valueOf(Integer.toString(this.f3289v));
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaString optstring(LuaString luaString) {
        return LuaString.valueOf(Integer.toString(this.f3289v));
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue tostring() {
        return LuaString.valueOf(Integer.toString(this.f3289v));
    }

    @Override // org.luaj.vm2.LuaValue
    public String optjstring(String str) {
        return Integer.toString(this.f3289v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaInteger checkinteger() {
        return this;
    }

    @Override // org.luaj.vm2.LuaNumber, org.luaj.vm2.LuaValue
    public boolean isstring() {
        return true;
    }

    public int hashCode() {
        return this.f3289v;
    }

    public static int hashCode(int i) {
        return i;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue neg() {
        return valueOf(-((long) this.f3289v));
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean equals(Object obj) {
        return (obj instanceof LuaInteger) && ((LuaInteger) obj).f3289v == this.f3289v;
    }

    @Override // org.luaj.vm2.LuaValue
    /* renamed from: eq */
    public LuaValue mo24eq(LuaValue luaValue) {
        return luaValue.raweq(this.f3289v) ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean eq_b(LuaValue luaValue) {
        return luaValue.raweq(this.f3289v);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean raweq(LuaValue luaValue) {
        return luaValue.raweq(this.f3289v);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean raweq(double d) {
        return ((double) this.f3289v) == d;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean raweq(int i) {
        return this.f3289v == i;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue add(LuaValue luaValue) {
        return luaValue.add(this.f3289v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue add(double d) {
        return LuaDouble.valueOf(d + ((double) this.f3289v));
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue add(int i) {
        return valueOf(((long) i) + ((long) this.f3289v));
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue sub(LuaValue luaValue) {
        return luaValue.subFrom(this.f3289v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue sub(double d) {
        return LuaDouble.valueOf(((double) this.f3289v) - d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue sub(int i) {
        return LuaDouble.valueOf(this.f3289v - i);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue subFrom(double d) {
        return LuaDouble.valueOf(d - ((double) this.f3289v));
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue subFrom(int i) {
        return valueOf(((long) i) - ((long) this.f3289v));
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mul(LuaValue luaValue) {
        return luaValue.mul(this.f3289v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mul(double d) {
        return LuaDouble.valueOf(d * ((double) this.f3289v));
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mul(int i) {
        return valueOf(((long) i) * ((long) this.f3289v));
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue pow(LuaValue luaValue) {
        return luaValue.powWith(this.f3289v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue pow(double d) {
        return MathLib.dpow((double) this.f3289v, d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue pow(int i) {
        return MathLib.dpow((double) this.f3289v, (double) i);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue powWith(double d) {
        return MathLib.dpow(d, (double) this.f3289v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue powWith(int i) {
        return MathLib.dpow((double) i, (double) this.f3289v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue div(LuaValue luaValue) {
        return luaValue.divInto((double) this.f3289v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue div(double d) {
        return LuaDouble.ddiv((double) this.f3289v, d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue div(int i) {
        return LuaDouble.ddiv((double) this.f3289v, (double) i);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue divInto(double d) {
        return LuaDouble.ddiv(d, (double) this.f3289v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mod(LuaValue luaValue) {
        return luaValue.modFrom((double) this.f3289v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mod(double d) {
        return LuaDouble.dmod((double) this.f3289v, d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mod(int i) {
        return LuaDouble.dmod((double) this.f3289v, (double) i);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue modFrom(double d) {
        return LuaDouble.dmod(d, (double) this.f3289v);
    }

    @Override // org.luaj.vm2.LuaValue
    /* renamed from: lt */
    public LuaValue mo18lt(LuaValue luaValue) {
        return luaValue.gt_b(this.f3289v) ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    /* renamed from: lt */
    public LuaValue mo20lt(double d) {
        return ((double) this.f3289v) < d ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    /* renamed from: lt */
    public LuaValue mo19lt(int i) {
        return this.f3289v < i ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lt_b(LuaValue luaValue) {
        return luaValue.gt_b(this.f3289v);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lt_b(int i) {
        return this.f3289v < i;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lt_b(double d) {
        return ((double) this.f3289v) < d;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue lteq(LuaValue luaValue) {
        return luaValue.gteq_b(this.f3289v) ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue lteq(double d) {
        return ((double) this.f3289v) <= d ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue lteq(int i) {
        return this.f3289v <= i ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lteq_b(LuaValue luaValue) {
        return luaValue.gteq_b(this.f3289v);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lteq_b(int i) {
        return this.f3289v <= i;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lteq_b(double d) {
        return ((double) this.f3289v) <= d;
    }

    @Override // org.luaj.vm2.LuaValue
    /* renamed from: gt */
    public LuaValue mo21gt(LuaValue luaValue) {
        return luaValue.lt_b(this.f3289v) ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    /* renamed from: gt */
    public LuaValue mo23gt(double d) {
        return ((double) this.f3289v) > d ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    /* renamed from: gt */
    public LuaValue mo22gt(int i) {
        return this.f3289v > i ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gt_b(LuaValue luaValue) {
        return luaValue.lt_b(this.f3289v);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gt_b(int i) {
        return this.f3289v > i;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gt_b(double d) {
        return ((double) this.f3289v) > d;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue gteq(LuaValue luaValue) {
        return luaValue.lteq_b(this.f3289v) ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue gteq(double d) {
        return ((double) this.f3289v) >= d ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue gteq(int i) {
        return this.f3289v >= i ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gteq_b(LuaValue luaValue) {
        return luaValue.lteq_b(this.f3289v);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gteq_b(int i) {
        return this.f3289v >= i;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gteq_b(double d) {
        return ((double) this.f3289v) >= d;
    }

    @Override // org.luaj.vm2.LuaValue
    public int strcmp(LuaString luaString) {
        typerror("attempt to compare number with string");
        return 0;
    }

    @Override // org.luaj.vm2.LuaValue
    public int checkint() {
        return this.f3289v;
    }

    @Override // org.luaj.vm2.LuaValue
    public long checklong() {
        return (long) this.f3289v;
    }

    @Override // org.luaj.vm2.LuaValue
    public double checkdouble() {
        return (double) this.f3289v;
    }

    @Override // org.luaj.vm2.LuaValue
    public String checkjstring() {
        return String.valueOf(this.f3289v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaString checkstring() {
        return valueOf(String.valueOf(this.f3289v));
    }

    static {
        for (int i = 0; i < 512; i++) {
            intValues[i] = new LuaInteger(i - 256);
        }
    }
}
