package org.luaj.vm2.lib.jse;

import java.lang.reflect.Array;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaUserdata;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JavaArray.class */
class JavaArray extends LuaUserdata {
    static final LuaValue LENGTH = valueOf("length");
    static final LuaTable array_metatable = new LuaTable();

    /* renamed from: org.luaj.vm2.lib.jse.JavaArray$1 */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JavaArray$1.class */
    static class C58751 {
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JavaArray$LenFunction.class */
    private static final class LenFunction extends OneArgFunction {
        private LenFunction() {
        }

        @Override // org.luaj.vm2.lib.OneArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return LuaValue.valueOf(Array.getLength(((LuaUserdata) luaValue).m_instance));
        }

        LenFunction(C58751 r3) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public JavaArray(Object obj) {
        super(obj);
        setmetatable(array_metatable);
    }

    @Override // org.luaj.vm2.LuaUserdata, org.luaj.vm2.LuaValue
    public LuaValue get(LuaValue luaValue) {
        if (luaValue.equals(LENGTH)) {
            return valueOf(Array.getLength(this.m_instance));
        }
        if (!luaValue.isint()) {
            return get(luaValue);
        }
        int i = luaValue.toint() - 1;
        return (i < 0 || i >= Array.getLength(this.m_instance)) ? NIL : CoerceJavaToLua.coerce(Array.get(this.m_instance, luaValue.toint() - 1));
    }

    @Override // org.luaj.vm2.LuaUserdata, org.luaj.vm2.LuaValue
    public void set(LuaValue luaValue, LuaValue luaValue2) {
        if (luaValue.isint()) {
            int i = luaValue.toint() - 1;
            if (i >= 0 && i < Array.getLength(this.m_instance)) {
                Array.set(this.m_instance, i, CoerceLuaToJava.coerce(luaValue2, this.m_instance.getClass().getComponentType()));
            } else if (this.m_metatable == null || !settable(this, luaValue, luaValue2)) {
                error("array index out of bounds");
            }
        } else {
            set(luaValue, luaValue2);
        }
    }

    static {
        array_metatable.rawset(LuaValue.LEN, new LenFunction(null));
    }
}
