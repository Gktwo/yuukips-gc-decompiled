package org.luaj.vm2;

/* loaded from: grasscutter.jar:org/luaj/vm2/LuaNil.class */
public class LuaNil extends LuaValue {
    static final LuaNil _NIL = new LuaNil();
    public static LuaValue s_metatable;

    @Override // org.luaj.vm2.LuaValue
    public int type() {
        return 0;
    }

    @Override // org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
    public String toString() {
        return "nil";
    }

    @Override // org.luaj.vm2.LuaValue
    public String typename() {
        return "nil";
    }

    @Override // org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
    public String tojstring() {
        return "nil";
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue not() {
        return LuaValue.TRUE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean toboolean() {
        return false;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isnil() {
        return true;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue getmetatable() {
        return s_metatable;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean equals(Object obj) {
        return obj instanceof LuaNil;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue checknotnil() {
        return argerror("value");
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isvalidkey() {
        return false;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean optboolean(boolean z) {
        return z;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaClosure optclosure(LuaClosure luaClosure) {
        return luaClosure;
    }

    @Override // org.luaj.vm2.LuaValue
    public double optdouble(double d) {
        return d;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaFunction optfunction(LuaFunction luaFunction) {
        return luaFunction;
    }

    @Override // org.luaj.vm2.LuaValue
    public int optint(int i) {
        return i;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaInteger optinteger(LuaInteger luaInteger) {
        return luaInteger;
    }

    @Override // org.luaj.vm2.LuaValue
    public long optlong(long j) {
        return j;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaNumber optnumber(LuaNumber luaNumber) {
        return luaNumber;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaTable opttable(LuaTable luaTable) {
        return luaTable;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaThread optthread(LuaThread luaThread) {
        return luaThread;
    }

    @Override // org.luaj.vm2.LuaValue
    public String optjstring(String str) {
        return str;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaString optstring(LuaString luaString) {
        return luaString;
    }

    @Override // org.luaj.vm2.LuaValue
    public Object optuserdata(Object obj) {
        return obj;
    }

    @Override // org.luaj.vm2.LuaValue
    public Object optuserdata(Class cls, Object obj) {
        return obj;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue optvalue(LuaValue luaValue) {
        return luaValue;
    }
}
