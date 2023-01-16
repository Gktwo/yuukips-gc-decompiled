package org.luaj.vm2.lib;

import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/LibFunction.class */
public abstract class LibFunction extends LuaFunction {
    protected int opcode;
    protected String name;

    @Override // org.luaj.vm2.LuaFunction, org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
    public String tojstring() {
        return this.name != null ? this.name : tojstring();
    }

    protected void bind(LuaValue luaValue, Class cls, String[] strArr) {
        bind(luaValue, cls, strArr, 0);
    }

    protected void bind(LuaValue luaValue, Class cls, String[] strArr, int i) {
        try {
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                LibFunction libFunction = (LibFunction) cls.newInstance();
                libFunction.opcode = i + i2;
                libFunction.name = strArr[i2];
                luaValue.set(libFunction.name, libFunction);
            }
        } catch (Exception e) {
            throw new LuaError(new StringBuffer().append("bind failed: ").append(e).toString());
        }
    }

    protected static LuaValue[] newupe() {
        return new LuaValue[1];
    }

    protected static LuaValue[] newupn() {
        return new LuaValue[]{NIL};
    }

    protected static LuaValue[] newupl(LuaValue luaValue) {
        return new LuaValue[]{luaValue};
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue call() {
        return argerror(1, "value");
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue) {
        return call();
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        return call(luaValue);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2, LuaValue luaValue3) {
        return call(luaValue, luaValue2);
    }

    public LuaValue call(LuaValue luaValue, LuaValue luaValue2, LuaValue luaValue3, LuaValue luaValue4) {
        return call(luaValue, luaValue2, luaValue3);
    }

    @Override // org.luaj.vm2.LuaValue
    public Varargs invoke(Varargs varargs) {
        switch (varargs.narg()) {
            case 0:
                return call();
            case 1:
                return call(varargs.arg1());
            case 2:
                return call(varargs.arg1(), varargs.arg(2));
            case 3:
                return call(varargs.arg1(), varargs.arg(2), varargs.arg(3));
            default:
                return call(varargs.arg1(), varargs.arg(2), varargs.arg(3), varargs.arg(4));
        }
    }
}
