package org.luaj.vm2;

import org.luaj.vm2.lib.MathLib;

/* loaded from: grasscutter.jar:org/luaj/vm2/LuaDouble.class */
public class LuaDouble extends LuaNumber {
    public static final LuaDouble NAN = new LuaDouble(Double.NaN);
    public static final LuaDouble POSINF = new LuaDouble(Double.POSITIVE_INFINITY);
    public static final LuaDouble NEGINF = new LuaDouble(Double.NEGATIVE_INFINITY);
    public static final String JSTR_NAN = "nan";
    public static final String JSTR_POSINF = "inf";
    public static final String JSTR_NEGINF = "-inf";

    /* renamed from: v */
    final double f3288v;

    public static LuaNumber valueOf(double d) {
        int i = (int) d;
        return d == ((double) i) ? LuaInteger.valueOf(i) : new LuaDouble(d);
    }

    private LuaDouble(double d) {
        this.f3288v = d;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f3288v + 1.0d);
        return ((int) (doubleToLongBits >> 32)) + ((int) doubleToLongBits);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean islong() {
        return this.f3288v == ((double) ((long) this.f3288v));
    }

    @Override // org.luaj.vm2.LuaValue
    public byte tobyte() {
        return (byte) ((int) ((long) this.f3288v));
    }

    @Override // org.luaj.vm2.LuaValue
    public char tochar() {
        return (char) ((int) ((long) this.f3288v));
    }

    @Override // org.luaj.vm2.LuaValue
    public double todouble() {
        return this.f3288v;
    }

    @Override // org.luaj.vm2.LuaValue
    public float tofloat() {
        return (float) this.f3288v;
    }

    @Override // org.luaj.vm2.LuaValue
    public int toint() {
        return (int) ((long) this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public long tolong() {
        return (long) this.f3288v;
    }

    @Override // org.luaj.vm2.LuaValue
    public short toshort() {
        return (short) ((int) ((long) this.f3288v));
    }

    @Override // org.luaj.vm2.LuaValue
    public double optdouble(double d) {
        return this.f3288v;
    }

    @Override // org.luaj.vm2.LuaValue
    public int optint(int i) {
        return (int) ((long) this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaInteger optinteger(LuaInteger luaInteger) {
        return LuaInteger.valueOf((int) ((long) this.f3288v));
    }

    @Override // org.luaj.vm2.LuaValue
    public long optlong(long j) {
        return (long) this.f3288v;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaInteger checkinteger() {
        return LuaInteger.valueOf((int) ((long) this.f3288v));
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue neg() {
        return valueOf(-this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean equals(Object obj) {
        return (obj instanceof LuaDouble) && ((LuaDouble) obj).f3288v == this.f3288v;
    }

    @Override // org.luaj.vm2.LuaValue
    /* renamed from: eq */
    public LuaValue mo24eq(LuaValue luaValue) {
        return luaValue.raweq(this.f3288v) ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean eq_b(LuaValue luaValue) {
        return luaValue.raweq(this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean raweq(LuaValue luaValue) {
        return luaValue.raweq(this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean raweq(double d) {
        return this.f3288v == d;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean raweq(int i) {
        return this.f3288v == ((double) i);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue add(LuaValue luaValue) {
        return luaValue.add(this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue add(double d) {
        return valueOf(d + this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue sub(LuaValue luaValue) {
        return luaValue.subFrom(this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue sub(double d) {
        return valueOf(this.f3288v - d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue sub(int i) {
        return valueOf(this.f3288v - ((double) i));
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue subFrom(double d) {
        return valueOf(d - this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mul(LuaValue luaValue) {
        return luaValue.mul(this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mul(double d) {
        return valueOf(d * this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mul(int i) {
        return valueOf(((double) i) * this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue pow(LuaValue luaValue) {
        return luaValue.powWith(this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue pow(double d) {
        return MathLib.dpow(this.f3288v, d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue pow(int i) {
        return MathLib.dpow(this.f3288v, (double) i);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue powWith(double d) {
        return MathLib.dpow(d, this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue powWith(int i) {
        return MathLib.dpow((double) i, this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue div(LuaValue luaValue) {
        return luaValue.divInto(this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue div(double d) {
        return ddiv(this.f3288v, d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue div(int i) {
        return ddiv(this.f3288v, (double) i);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue divInto(double d) {
        return ddiv(d, this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mod(LuaValue luaValue) {
        return luaValue.modFrom(this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mod(double d) {
        return dmod(this.f3288v, d);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue mod(int i) {
        return dmod(this.f3288v, (double) i);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue modFrom(double d) {
        return dmod(d, this.f3288v);
    }

    public static LuaValue ddiv(double d, double d2) {
        return d2 != 0.0d ? valueOf(d / d2) : d > 0.0d ? POSINF : d == 0.0d ? NAN : NEGINF;
    }

    public static double ddiv_d(double d, double d2) {
        if (d2 != 0.0d) {
            return d / d2;
        }
        if (d > 0.0d) {
            return Double.POSITIVE_INFINITY;
        }
        return d == 0.0d ? Double.NaN : Double.NEGATIVE_INFINITY;
    }

    public static LuaValue dmod(double d, double d2) {
        return d2 != 0.0d ? valueOf(d - (d2 * Math.floor(d / d2))) : NAN;
    }

    public static double dmod_d(double d, double d2) {
        if (d2 != 0.0d) {
            return d - (d2 * Math.floor(d / d2));
        }
        return Double.NaN;
    }

    @Override // org.luaj.vm2.LuaValue
    /* renamed from: lt */
    public LuaValue mo18lt(LuaValue luaValue) {
        return luaValue.gt_b(this.f3288v) ? LuaValue.TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    /* renamed from: lt */
    public LuaValue mo20lt(double d) {
        return this.f3288v < d ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    /* renamed from: lt */
    public LuaValue mo19lt(int i) {
        return this.f3288v < ((double) i) ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lt_b(LuaValue luaValue) {
        return luaValue.gt_b(this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lt_b(int i) {
        return this.f3288v < ((double) i);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lt_b(double d) {
        return this.f3288v < d;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue lteq(LuaValue luaValue) {
        return luaValue.gteq_b(this.f3288v) ? LuaValue.TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue lteq(double d) {
        return this.f3288v <= d ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue lteq(int i) {
        return this.f3288v <= ((double) i) ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lteq_b(LuaValue luaValue) {
        return luaValue.gteq_b(this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lteq_b(int i) {
        return this.f3288v <= ((double) i);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean lteq_b(double d) {
        return this.f3288v <= d;
    }

    @Override // org.luaj.vm2.LuaValue
    /* renamed from: gt */
    public LuaValue mo21gt(LuaValue luaValue) {
        return luaValue.lt_b(this.f3288v) ? LuaValue.TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    /* renamed from: gt */
    public LuaValue mo23gt(double d) {
        return this.f3288v > d ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    /* renamed from: gt */
    public LuaValue mo22gt(int i) {
        return this.f3288v > ((double) i) ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gt_b(LuaValue luaValue) {
        return luaValue.lt_b(this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gt_b(int i) {
        return this.f3288v > ((double) i);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gt_b(double d) {
        return this.f3288v > d;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue gteq(LuaValue luaValue) {
        return luaValue.lteq_b(this.f3288v) ? LuaValue.TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue gteq(double d) {
        return this.f3288v >= d ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue gteq(int i) {
        return this.f3288v >= ((double) i) ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gteq_b(LuaValue luaValue) {
        return luaValue.lteq_b(this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gteq_b(int i) {
        return this.f3288v >= ((double) i);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean gteq_b(double d) {
        return this.f3288v >= d;
    }

    @Override // org.luaj.vm2.LuaValue
    public int strcmp(LuaString luaString) {
        typerror("attempt to compare number with string");
        return 0;
    }

    @Override // org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
    public String tojstring() {
        long j = (long) this.f3288v;
        return ((double) j) == this.f3288v ? Long.toString(j) : Double.isNaN(this.f3288v) ? JSTR_NAN : Double.isInfinite(this.f3288v) ? this.f3288v < 0.0d ? JSTR_NEGINF : JSTR_POSINF : Float.toString((float) this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaString strvalue() {
        return LuaString.valueOf(tojstring());
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaString optstring(LuaString luaString) {
        return LuaString.valueOf(tojstring());
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue tostring() {
        return LuaString.valueOf(tojstring());
    }

    @Override // org.luaj.vm2.LuaValue
    public String optjstring(String str) {
        return tojstring();
    }

    @Override // org.luaj.vm2.LuaNumber, org.luaj.vm2.LuaValue
    public LuaNumber optnumber(LuaNumber luaNumber) {
        return this;
    }

    @Override // org.luaj.vm2.LuaNumber, org.luaj.vm2.LuaValue
    public boolean isnumber() {
        return true;
    }

    @Override // org.luaj.vm2.LuaNumber, org.luaj.vm2.LuaValue
    public boolean isstring() {
        return true;
    }

    @Override // org.luaj.vm2.LuaNumber, org.luaj.vm2.LuaValue
    public LuaValue tonumber() {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public int checkint() {
        return (int) ((long) this.f3288v);
    }

    @Override // org.luaj.vm2.LuaValue
    public long checklong() {
        return (long) this.f3288v;
    }

    @Override // org.luaj.vm2.LuaNumber, org.luaj.vm2.LuaValue
    public LuaNumber checknumber() {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public double checkdouble() {
        return this.f3288v;
    }

    @Override // org.luaj.vm2.LuaValue
    public String checkjstring() {
        return tojstring();
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaString checkstring() {
        return LuaString.valueOf(tojstring());
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isvalidkey() {
        return !Double.isNaN(this.f3288v);
    }
}
