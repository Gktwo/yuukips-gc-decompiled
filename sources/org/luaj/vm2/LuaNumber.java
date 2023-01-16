package org.luaj.vm2;

/* loaded from: grasscutter.jar:org/luaj/vm2/LuaNumber.class */
public abstract class LuaNumber extends LuaValue {
    public static LuaValue s_metatable;

    @Override // org.luaj.vm2.LuaValue
    public int type() {
        return 3;
    }

    @Override // org.luaj.vm2.LuaValue
    public String typename() {
        return "number";
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaNumber checknumber() {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaNumber checknumber(String str) {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaNumber optnumber(LuaNumber luaNumber) {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue tonumber() {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isnumber() {
        return true;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isstring() {
        return true;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue getmetatable() {
        return s_metatable;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue concat(LuaValue luaValue) {
        return luaValue.concatTo(this);
    }

    @Override // org.luaj.vm2.LuaValue
    public Buffer concat(Buffer buffer) {
        return buffer.concatTo(this);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue concatTo(LuaNumber luaNumber) {
        return strvalue().concatTo(luaNumber.strvalue());
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue concatTo(LuaString luaString) {
        return strvalue().concatTo(luaString);
    }
}
