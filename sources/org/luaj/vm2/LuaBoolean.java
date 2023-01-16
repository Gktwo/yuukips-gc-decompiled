package org.luaj.vm2;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;

/* loaded from: grasscutter.jar:org/luaj/vm2/LuaBoolean.class */
public final class LuaBoolean extends LuaValue {
    static final LuaBoolean _TRUE = new LuaBoolean(true);
    static final LuaBoolean _FALSE = new LuaBoolean(false);
    public static LuaValue s_metatable;

    /* renamed from: v */
    public final boolean f3286v;

    LuaBoolean(boolean z) {
        this.f3286v = z;
    }

    @Override // org.luaj.vm2.LuaValue
    public int type() {
        return 1;
    }

    @Override // org.luaj.vm2.LuaValue
    public String typename() {
        return "boolean";
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isboolean() {
        return true;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue not() {
        return this.f3286v ? FALSE : LuaValue.TRUE;
    }

    public boolean booleanValue() {
        return this.f3286v;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean toboolean() {
        return this.f3286v;
    }

    @Override // org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
    public String tojstring() {
        return this.f3286v ? C3P0Substitutions.DEBUG : "false";
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean optboolean(boolean z) {
        return this.f3286v;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean checkboolean() {
        return this.f3286v;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue getmetatable() {
        return s_metatable;
    }
}
