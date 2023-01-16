package org.luaj.vm2.lib;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/OneArgFunction.class */
public abstract class OneArgFunction extends LibFunction {
    @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public abstract LuaValue call(LuaValue luaValue);

    @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public final LuaValue call() {
        return call(NIL);
    }

    @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public final LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        return call(luaValue);
    }

    @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2, LuaValue luaValue3) {
        return call(luaValue);
    }

    @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public Varargs invoke(Varargs varargs) {
        return call(varargs.arg1());
    }
}
