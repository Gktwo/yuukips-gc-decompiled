package org.luaj.vm2.lib;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.util.Random;
import org.luaj.vm2.LuaDouble;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/MathLib.class */
public class MathLib extends TwoArgFunction {
    public static MathLib MATHLIB = null;

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/MathLib$BinaryOp.class */
    protected static abstract class BinaryOp extends TwoArgFunction {
        @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
            return valueOf(call(luaValue.checkdouble(), luaValue2.checkdouble()));
        }

        protected abstract double call(double d, double d2);
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/MathLib$UnaryOp.class */
    protected static abstract class UnaryOp extends OneArgFunction {
        @Override // org.luaj.vm2.lib.OneArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return valueOf(call(luaValue.checkdouble()));
        }

        protected abstract double call(double d);
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/MathLib$abs.class */
    static final class abs extends UnaryOp {
        abs() {
        }

        @Override // org.luaj.vm2.lib.MathLib.UnaryOp
        protected double call(double d) {
            return Math.abs(d);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/MathLib$ceil.class */
    static final class ceil extends UnaryOp {
        ceil() {
        }

        @Override // org.luaj.vm2.lib.MathLib.UnaryOp
        protected double call(double d) {
            return Math.ceil(d);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/MathLib$cos.class */
    static final class cos extends UnaryOp {
        cos() {
        }

        @Override // org.luaj.vm2.lib.MathLib.UnaryOp
        protected double call(double d) {
            return Math.cos(d);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/MathLib$deg.class */
    static final class deg extends UnaryOp {
        deg() {
        }

        @Override // org.luaj.vm2.lib.MathLib.UnaryOp
        protected double call(double d) {
            return Math.toDegrees(d);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/MathLib$exp.class */
    static final class exp extends UnaryOp {
        final MathLib mathlib;

        exp(MathLib mathLib) {
            this.mathlib = mathLib;
        }

        @Override // org.luaj.vm2.lib.MathLib.UnaryOp
        protected double call(double d) {
            return this.mathlib.dpow_lib(2.718281828459045d, d);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/MathLib$floor.class */
    static final class floor extends UnaryOp {
        floor() {
        }

        @Override // org.luaj.vm2.lib.MathLib.UnaryOp
        protected double call(double d) {
            return Math.floor(d);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/MathLib$fmod.class */
    static final class fmod extends BinaryOp {
        fmod() {
        }

        @Override // org.luaj.vm2.lib.MathLib.BinaryOp
        protected double call(double d, double d2) {
            double d3 = d / d2;
            return d - (d2 * (d3 >= 0.0d ? Math.floor(d3) : Math.ceil(d3)));
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/MathLib$frexp.class */
    static class frexp extends VarArgFunction {
        frexp() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            double checkdouble = varargs.checkdouble(1);
            if (checkdouble == 0.0d) {
                return varargsOf(ZERO, ZERO);
            }
            long doubleToLongBits = Double.doubleToLongBits(checkdouble);
            return varargsOf(valueOf(((double) ((doubleToLongBits & 4503599627370495L) + 4503599627370496L)) * (doubleToLongBits >= 0 ? 1.1102230246251565E-16d : -1.1102230246251565E-16d)), valueOf((double) ((((int) (doubleToLongBits >> 52)) & PacketOpcodes.ActivityScheduleInfoNotify) - 1022)));
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/MathLib$ldexp.class */
    static final class ldexp extends BinaryOp {
        ldexp() {
        }

        @Override // org.luaj.vm2.lib.MathLib.BinaryOp
        protected double call(double d, double d2) {
            return d * Double.longBitsToDouble((((long) d2) + 1023) << 52);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/MathLib$max.class */
    static class max extends VarArgFunction {
        max() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            double checkdouble = varargs.checkdouble(1);
            int narg = varargs.narg();
            for (int i = 2; i <= narg; i++) {
                checkdouble = Math.max(checkdouble, varargs.checkdouble(i));
            }
            return valueOf(checkdouble);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/MathLib$min.class */
    static class min extends VarArgFunction {
        min() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            double checkdouble = varargs.checkdouble(1);
            int narg = varargs.narg();
            for (int i = 2; i <= narg; i++) {
                checkdouble = Math.min(checkdouble, varargs.checkdouble(i));
            }
            return valueOf(checkdouble);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/MathLib$modf.class */
    static class modf extends VarArgFunction {
        modf() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            double checkdouble = varargs.checkdouble(1);
            double floor = checkdouble > 0.0d ? Math.floor(checkdouble) : Math.ceil(checkdouble);
            return varargsOf(valueOf(floor), valueOf(checkdouble - floor));
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/MathLib$pow.class */
    static final class pow extends BinaryOp {
        pow() {
        }

        @Override // org.luaj.vm2.lib.MathLib.BinaryOp
        protected double call(double d, double d2) {
            return MathLib.dpow_default(d, d2);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/MathLib$rad.class */
    static final class rad extends UnaryOp {
        rad() {
        }

        @Override // org.luaj.vm2.lib.MathLib.UnaryOp
        protected double call(double d) {
            return Math.toRadians(d);
        }
    }

    /* renamed from: org.luaj.vm2.lib.MathLib$random */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/MathLib$random.class */
    static class C5864random extends LibFunction {
        Random random = new Random();

        C5864random() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call() {
            return valueOf(this.random.nextDouble());
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            int checkint = luaValue.checkint();
            if (checkint < 1) {
                argerror(1, "interval is empty");
            }
            return valueOf(1 + this.random.nextInt(checkint));
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
            int checkint = luaValue.checkint();
            int checkint2 = luaValue2.checkint();
            if (checkint2 < checkint) {
                argerror(2, "interval is empty");
            }
            return valueOf(checkint + this.random.nextInt((checkint2 + 1) - checkint));
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/MathLib$randomseed.class */
    static class randomseed extends OneArgFunction {
        final C5864random random;

        randomseed(C5864random random) {
            this.random = random;
        }

        @Override // org.luaj.vm2.lib.OneArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            long checklong = luaValue.checklong();
            this.random.random = new Random(checklong);
            return NONE;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/MathLib$sin.class */
    static final class sin extends UnaryOp {
        sin() {
        }

        @Override // org.luaj.vm2.lib.MathLib.UnaryOp
        protected double call(double d) {
            return Math.sin(d);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/MathLib$sqrt.class */
    static final class sqrt extends UnaryOp {
        sqrt() {
        }

        @Override // org.luaj.vm2.lib.MathLib.UnaryOp
        protected double call(double d) {
            return Math.sqrt(d);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/MathLib$tan.class */
    static final class tan extends UnaryOp {
        tan() {
        }

        @Override // org.luaj.vm2.lib.MathLib.UnaryOp
        protected double call(double d) {
            return Math.tan(d);
        }
    }

    public MathLib() {
        MATHLIB = this;
    }

    @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        LuaTable luaTable = new LuaTable(0, 30);
        luaTable.set("abs", new abs());
        luaTable.set("ceil", new ceil());
        luaTable.set("cos", new cos());
        luaTable.set("deg", new deg());
        luaTable.set("exp", new exp(this));
        luaTable.set("floor", new floor());
        luaTable.set("fmod", new fmod());
        luaTable.set("frexp", new frexp());
        luaTable.set("huge", LuaDouble.POSINF);
        luaTable.set("ldexp", new ldexp());
        luaTable.set("max", new max());
        luaTable.set("min", new min());
        luaTable.set("modf", new modf());
        luaTable.set("pi", 3.141592653589793d);
        luaTable.set("pow", new pow());
        C5864random random = new C5864random();
        luaTable.set("random", random);
        luaTable.set("randomseed", new randomseed(random));
        luaTable.set("rad", new rad());
        luaTable.set("sin", new sin());
        luaTable.set("sqrt", new sqrt());
        luaTable.set("tan", new tan());
        luaValue2.set("math", luaTable);
        luaValue2.get("package").get("loaded").set("math", luaTable);
        return luaTable;
    }

    public static LuaValue dpow(double d, double d2) {
        return LuaDouble.valueOf(MATHLIB != null ? MATHLIB.dpow_lib(d, d2) : dpow_default(d, d2));
    }

    public static double dpow_d(double d, double d2) {
        return MATHLIB != null ? MATHLIB.dpow_lib(d, d2) : dpow_default(d, d2);
    }

    public double dpow_lib(double d, double d2) {
        return dpow_default(d, d2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [double] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [double] */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static double dpow_default(double r7, double r9) {
        /*
            r0 = r9
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x000f
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r1 = r7
            r2 = r9
            double r2 = -r2
            double r1 = dpow_default(r1, r2)
            double r0 = r0 / r1
            return r0
        L_0x000f:
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r11 = r0
            r0 = r9
            int r0 = (int) r0
            r13 = r0
            r0 = r7
            r14 = r0
        L_0x0019:
            r0 = r13
            if (r0 <= 0) goto L_0x003c
            r0 = r13
            r1 = 1
            r0 = r0 & r1
            if (r0 == 0) goto L_0x002c
            r0 = r11
            r1 = r14
            double r0 = r0 * r1
            r11 = r0
        L_0x002c:
            r0 = r13
            r1 = 1
            int r0 = r0 >> r1
            r13 = r0
            r0 = r14
            r1 = r14
            double r0 = r0 * r1
            r14 = r0
            goto L_0x0019
        L_0x003c:
            r0 = r9
            r1 = r13
            double r1 = (double) r1
            double r0 = r0 - r1
            r1 = r0; r1 = r0; 
            r9 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0074
            r0 = 4679240012837945344(0x40f0000000000000, double:65536.0)
            r1 = r9
            double r0 = r0 * r1
            int r0 = (int) r0
            r14 = r0
        L_0x0050:
            r0 = r14
            r1 = 65535(0xffff, float:9.1834E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0074
            r0 = r7
            double r0 = java.lang.Math.sqrt(r0)
            r7 = r0
            r0 = r14
            r1 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x006b
            r0 = r11
            r1 = r7
            double r0 = r0 * r1
            r11 = r0
        L_0x006b:
            r0 = r14
            r1 = 1
            int r0 = r0 << r1
            r14 = r0
            goto L_0x0050
        L_0x0074:
            r0 = r11
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.lib.MathLib.dpow_default(double, double):double");
    }
}
