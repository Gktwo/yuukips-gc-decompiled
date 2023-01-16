package org.luaj.vm2;

/* loaded from: grasscutter.jar:org/luaj/vm2/LuaUserdata.class */
public class LuaUserdata extends LuaValue {
    public Object m_instance;
    public LuaValue m_metatable;

    public LuaUserdata(Object obj) {
        this.m_instance = obj;
    }

    public LuaUserdata(Object obj, LuaValue luaValue) {
        this.m_instance = obj;
        this.m_metatable = luaValue;
    }

    @Override // org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
    public String tojstring() {
        return String.valueOf(this.m_instance);
    }

    @Override // org.luaj.vm2.LuaValue
    public int type() {
        return 7;
    }

    @Override // org.luaj.vm2.LuaValue
    public String typename() {
        return "userdata";
    }

    public int hashCode() {
        return this.m_instance.hashCode();
    }

    public Object userdata() {
        return this.m_instance;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isuserdata() {
        return true;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isuserdata(Class cls) {
        return cls.isAssignableFrom(this.m_instance.getClass());
    }

    @Override // org.luaj.vm2.LuaValue
    public Object touserdata() {
        return this.m_instance;
    }

    @Override // org.luaj.vm2.LuaValue
    public Object touserdata(Class cls) {
        if (cls.isAssignableFrom(this.m_instance.getClass())) {
            return this.m_instance;
        }
        return null;
    }

    @Override // org.luaj.vm2.LuaValue
    public Object optuserdata(Object obj) {
        return this.m_instance;
    }

    @Override // org.luaj.vm2.LuaValue
    public Object optuserdata(Class cls, Object obj) {
        if (!cls.isAssignableFrom(this.m_instance.getClass())) {
            typerror(cls.getName());
        }
        return this.m_instance;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue getmetatable() {
        return this.m_metatable;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue setmetatable(LuaValue luaValue) {
        this.m_metatable = luaValue;
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public Object checkuserdata() {
        return this.m_instance;
    }

    @Override // org.luaj.vm2.LuaValue
    public Object checkuserdata(Class cls) {
        return cls.isAssignableFrom(this.m_instance.getClass()) ? this.m_instance : typerror(cls.getName());
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue get(LuaValue luaValue) {
        return this.m_metatable != null ? gettable(this, luaValue) : NIL;
    }

    @Override // org.luaj.vm2.LuaValue
    public void set(LuaValue luaValue, LuaValue luaValue2) {
        if (this.m_metatable == null || !settable(this, luaValue, luaValue2)) {
            error(new StringBuffer().append("cannot set ").append(luaValue).append(" for userdata").toString());
        }
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LuaUserdata)) {
            return false;
        }
        return this.m_instance.equals(((LuaUserdata) obj).m_instance);
    }

    @Override // org.luaj.vm2.LuaValue
    /* renamed from: eq */
    public LuaValue mo24eq(LuaValue luaValue) {
        return eq_b(luaValue) ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean eq_b(LuaValue luaValue) {
        LuaValue luaValue2;
        if (luaValue.raweq(this)) {
            return true;
        }
        return this.m_metatable != null && luaValue.isuserdata() && (luaValue2 = luaValue.getmetatable()) != null && LuaValue.eqmtcall(this, this.m_metatable, luaValue, luaValue2);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean raweq(LuaValue luaValue) {
        return luaValue.raweq(this);
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean raweq(LuaUserdata luaUserdata) {
        return this == luaUserdata || (this.m_metatable == luaUserdata.m_metatable && this.m_instance.equals(luaUserdata.m_instance));
    }

    public boolean eqmt(LuaValue luaValue) {
        if (this.m_metatable == null || !luaValue.isuserdata()) {
            return false;
        }
        return LuaValue.eqmtcall(this, this.m_metatable, luaValue, luaValue.getmetatable());
    }
}
