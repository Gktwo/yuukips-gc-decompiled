package org.luaj.vm2.lib.jse;

import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.VarArgFunction;
import org.luaj.vm2.lib.jse.CoerceLuaToJava;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JavaMember.class */
abstract class JavaMember extends VarArgFunction {
    static final int METHOD_MODIFIERS_VARARGS = 128;
    final CoerceLuaToJava.Coercion[] fixedargs;
    final CoerceLuaToJava.Coercion varargs;

    /* access modifiers changed from: protected */
    public JavaMember(Class[] clsArr, int i) {
        boolean z = (i & 128) != 0;
        this.fixedargs = new CoerceLuaToJava.Coercion[z ? clsArr.length - 1 : clsArr.length];
        for (int i2 = 0; i2 < this.fixedargs.length; i2++) {
            this.fixedargs[i2] = CoerceLuaToJava.getCoercion(clsArr[i2]);
        }
        this.varargs = z ? CoerceLuaToJava.getCoercion(clsArr[clsArr.length - 1]) : null;
    }

    int score(Varargs varargs) {
        int narg = varargs.narg();
        int length = narg > this.fixedargs.length ? CoerceLuaToJava.SCORE_WRONG_TYPE * (narg - this.fixedargs.length) : 0;
        for (int i = 0; i < this.fixedargs.length; i++) {
            length += this.fixedargs[i].score(varargs.arg(i + 1));
        }
        if (this.varargs != null) {
            for (int length2 = this.fixedargs.length; length2 < narg; length2++) {
                length += this.varargs.score(varargs.arg(length2 + 1));
            }
        }
        return length;
    }

    protected Object[] convertArgs(Varargs varargs) {
        Object[] objArr;
        if (this.varargs == null) {
            objArr = new Object[this.fixedargs.length];
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = this.fixedargs[i].coerce(varargs.arg(i + 1));
            }
        } else {
            int max = Math.max(this.fixedargs.length, varargs.narg());
            objArr = new Object[max];
            for (int i2 = 0; i2 < this.fixedargs.length; i2++) {
                objArr[i2] = this.fixedargs[i2].coerce(varargs.arg(i2 + 1));
            }
            for (int length = this.fixedargs.length; length < max; length++) {
                objArr[length] = this.varargs.coerce(varargs.arg(length + 1));
            }
        }
        return objArr;
    }
}
