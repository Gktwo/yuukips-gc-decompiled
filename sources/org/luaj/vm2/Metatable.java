package org.luaj.vm2;

import org.luaj.vm2.LuaTable;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/luaj/vm2/Metatable.class */
public interface Metatable {
    boolean useWeakKeys();

    boolean useWeakValues();

    LuaValue toLuaValue();

    LuaTable.Slot entry(LuaValue luaValue, LuaValue luaValue2);

    LuaValue wrap(LuaValue luaValue);

    LuaValue arrayget(LuaValue[] luaValueArr, int i);
}
