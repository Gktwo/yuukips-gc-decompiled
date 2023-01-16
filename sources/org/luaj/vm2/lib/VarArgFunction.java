package org.luaj.vm2.lib;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/VarArgFunction.class */
public abstract class VarArgFunction extends LibFunction {
    @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call() {
        return invoke(NONE).arg1();
    }

    @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue) {
        return invoke(luaValue).arg1();
    }

    @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        return invoke(varargsOf(luaValue, luaValue2)).arg1();
    }

    @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2, LuaValue luaValue3) {
        return invoke(varargsOf(luaValue, luaValue2, luaValue3)).arg1();
    }

    @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public Varargs invoke(Varargs varargs) {
        return onInvoke(varargs).eval();
    }

    @Override // org.luaj.vm2.LuaValue
    public Varargs onInvoke(Varargs varargs) {
        return invoke(varargs);
    }
}
