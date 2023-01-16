package org.luaj.vm2.lib;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/TwoArgFunction.class */
public abstract class TwoArgFunction extends LibFunction {
    @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public abstract LuaValue call(LuaValue luaValue, LuaValue luaValue2);

    @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public final LuaValue call() {
        return call(NIL, NIL);
    }

    @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public final LuaValue call(LuaValue luaValue) {
        return call(luaValue, NIL);
    }

    @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2, LuaValue luaValue3) {
        return call(luaValue, luaValue2);
    }

    @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public Varargs invoke(Varargs varargs) {
        return call(varargs.arg1(), varargs.arg(2));
    }
}
