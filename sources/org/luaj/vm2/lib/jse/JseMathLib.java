package org.luaj.vm2.lib.jse;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.MathLib;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JseMathLib.class */
public class JseMathLib extends MathLib {

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JseMathLib$acos.class */
    static final class acos extends MathLib.UnaryOp {
        acos() {
        }

        @Override // org.luaj.vm2.lib.MathLib.UnaryOp
        protected double call(double d) {
            return Math.acos(d);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JseMathLib$asin.class */
    static final class asin extends MathLib.UnaryOp {
        asin() {
        }

        @Override // org.luaj.vm2.lib.MathLib.UnaryOp
        protected double call(double d) {
            return Math.asin(d);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JseMathLib$atan.class */
    static final class atan extends MathLib.UnaryOp {
        atan() {
        }

        @Override // org.luaj.vm2.lib.MathLib.UnaryOp
        protected double call(double d) {
            return Math.atan(d);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JseMathLib$atan2.class */
    static final class atan2 extends MathLib.BinaryOp {
        atan2() {
        }

        @Override // org.luaj.vm2.lib.MathLib.BinaryOp
        protected double call(double d, double d2) {
            return Math.atan2(d, d2);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JseMathLib$cosh.class */
    static final class cosh extends MathLib.UnaryOp {
        cosh() {
        }

        @Override // org.luaj.vm2.lib.MathLib.UnaryOp
        protected double call(double d) {
            return Math.cosh(d);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JseMathLib$exp.class */
    static final class exp extends MathLib.UnaryOp {
        exp() {
        }

        @Override // org.luaj.vm2.lib.MathLib.UnaryOp
        protected double call(double d) {
            return Math.exp(d);
        }
    }

    /* renamed from: org.luaj.vm2.lib.jse.JseMathLib$log */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JseMathLib$log.class */
    static final class C5877log extends MathLib.UnaryOp {
        C5877log() {
        }

        @Override // org.luaj.vm2.lib.MathLib.UnaryOp
        protected double call(double d) {
            return Math.log(d);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JseMathLib$pow.class */
    static final class pow extends MathLib.BinaryOp {
        pow() {
        }

        @Override // org.luaj.vm2.lib.MathLib.BinaryOp
        protected double call(double d, double d2) {
            return Math.pow(d, d2);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JseMathLib$sinh.class */
    static final class sinh extends MathLib.UnaryOp {
        sinh() {
        }

        @Override // org.luaj.vm2.lib.MathLib.UnaryOp
        protected double call(double d) {
            return Math.sinh(d);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JseMathLib$tanh.class */
    static final class tanh extends MathLib.UnaryOp {
        tanh() {
        }

        @Override // org.luaj.vm2.lib.MathLib.UnaryOp
        protected double call(double d) {
            return Math.tanh(d);
        }
    }

    @Override // org.luaj.vm2.lib.MathLib, org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        call(luaValue, luaValue2);
        LuaValue luaValue3 = luaValue2.get("math");
        luaValue3.set("acos", new acos());
        luaValue3.set("asin", new asin());
        luaValue3.set("atan", new atan());
        luaValue3.set("atan2", new atan2());
        luaValue3.set("cosh", new cosh());
        luaValue3.set("exp", new exp());
        luaValue3.set("log", new C5877log());
        luaValue3.set("pow", new pow());
        luaValue3.set("sinh", new sinh());
        luaValue3.set("tanh", new tanh());
        return luaValue3;
    }

    @Override // org.luaj.vm2.lib.MathLib
    public double dpow_lib(double d, double d2) {
        return Math.pow(d, d2);
    }
}
