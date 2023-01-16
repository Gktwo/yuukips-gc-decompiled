package org.luaj.vm2;

import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/luaj/vm2/LuaClosure.class */
public class LuaClosure extends LuaFunction {
    private static final UpValue[] NOUPVALUES = new UpValue[0];

    /* renamed from: p */
    public final Prototype f3287p;
    public UpValue[] upValues;
    final Globals globals;

    public LuaClosure(Prototype prototype, LuaValue luaValue) {
        this.f3287p = prototype;
        if (prototype.upvalues == null || prototype.upvalues.length == 0) {
            this.upValues = NOUPVALUES;
        } else {
            this.upValues = new UpValue[prototype.upvalues.length];
            this.upValues[0] = new UpValue(new LuaValue[]{luaValue}, 0);
        }
        this.globals = luaValue instanceof Globals ? (Globals) luaValue : null;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isclosure() {
        return true;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaClosure optclosure(LuaClosure luaClosure) {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaClosure checkclosure() {
        return this;
    }

    @Override // org.luaj.vm2.LuaFunction, org.luaj.vm2.LuaValue
    public LuaValue getmetatable() {
        return s_metatable;
    }

    @Override // org.luaj.vm2.LuaFunction, org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
    public String tojstring() {
        return new StringBuffer().append("function: ").append(this.f3287p.toString()).toString();
    }

    @Override // org.luaj.vm2.LuaValue
    public final LuaValue call() {
        LuaValue[] luaValueArr = new LuaValue[this.f3287p.maxstacksize];
        for (int i = 0; i < this.f3287p.numparams; i++) {
            luaValueArr[i] = NIL;
        }
        return execute(luaValueArr, NONE).arg1();
    }

    @Override // org.luaj.vm2.LuaValue
    public final LuaValue call(LuaValue luaValue) {
        LuaValue[] luaValueArr = new LuaValue[this.f3287p.maxstacksize];
        System.arraycopy(NILS, 0, luaValueArr, 0, this.f3287p.maxstacksize);
        for (int i = 1; i < this.f3287p.numparams; i++) {
            luaValueArr[i] = NIL;
        }
        switch (this.f3287p.numparams) {
            case 0:
                return execute(luaValueArr, luaValue).arg1();
            default:
                luaValueArr[0] = luaValue;
                return execute(luaValueArr, NONE).arg1();
        }
    }

    @Override // org.luaj.vm2.LuaValue
    public final LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        LuaValue[] luaValueArr = new LuaValue[this.f3287p.maxstacksize];
        for (int i = 2; i < this.f3287p.numparams; i++) {
            luaValueArr[i] = NIL;
        }
        switch (this.f3287p.numparams) {
            case 0:
                return execute(luaValueArr, this.f3287p.is_vararg != 0 ? varargsOf(luaValue, luaValue2) : NONE).arg1();
            case 1:
                luaValueArr[0] = luaValue;
                return execute(luaValueArr, luaValue2).arg1();
            default:
                luaValueArr[0] = luaValue;
                luaValueArr[1] = luaValue2;
                return execute(luaValueArr, NONE).arg1();
        }
    }

    @Override // org.luaj.vm2.LuaValue
    public final LuaValue call(LuaValue luaValue, LuaValue luaValue2, LuaValue luaValue3) {
        LuaValue[] luaValueArr = new LuaValue[this.f3287p.maxstacksize];
        for (int i = 3; i < this.f3287p.numparams; i++) {
            luaValueArr[i] = NIL;
        }
        switch (this.f3287p.numparams) {
            case 0:
                return execute(luaValueArr, this.f3287p.is_vararg != 0 ? varargsOf(luaValue, luaValue2, luaValue3) : NONE).arg1();
            case 1:
                luaValueArr[0] = luaValue;
                return execute(luaValueArr, this.f3287p.is_vararg != 0 ? varargsOf(luaValue2, luaValue3) : NONE).arg1();
            case 2:
                luaValueArr[0] = luaValue;
                luaValueArr[1] = luaValue2;
                return execute(luaValueArr, luaValue3).arg1();
            default:
                luaValueArr[0] = luaValue;
                luaValueArr[1] = luaValue2;
                luaValueArr[2] = luaValue3;
                return execute(luaValueArr, NONE).arg1();
        }
    }

    @Override // org.luaj.vm2.LuaValue
    public final Varargs invoke(Varargs varargs) {
        return onInvoke(varargs).eval();
    }

    @Override // org.luaj.vm2.LuaValue
    public final Varargs onInvoke(Varargs varargs) {
        LuaValue[] luaValueArr = new LuaValue[this.f3287p.maxstacksize];
        for (int i = 0; i < this.f3287p.numparams; i++) {
            luaValueArr[i] = varargs.arg(i + 1);
        }
        return execute(luaValueArr, this.f3287p.is_vararg != 0 ? varargs.subargs(this.f3287p.numparams + 1) : NONE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:366:0x0c2c, code lost:
        if (r0.gteq_b(r0) != false) goto L_0x0c2f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected org.luaj.vm2.Varargs execute(org.luaj.vm2.LuaValue[] r10, org.luaj.vm2.Varargs r11) {
        /*
        // Method dump skipped, instructions count: 3873
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.LuaClosure.execute(org.luaj.vm2.LuaValue[], org.luaj.vm2.Varargs):org.luaj.vm2.Varargs");
    }

    String errorHook(String str, int i) {
        if (this.globals == null) {
            return str;
        }
        LuaThread luaThread = this.globals.running;
        if (luaThread.errorfunc == null) {
            return this.globals.debuglib != null ? new StringBuffer().append(str).append("\n").append(this.globals.debuglib.traceback(i)).toString() : str;
        }
        LuaValue luaValue = luaThread.errorfunc;
        luaThread.errorfunc = null;
        try {
            String str2 = luaValue.call(LuaValue.valueOf(str)).tojstring();
            luaThread.errorfunc = luaValue;
            return str2;
        } catch (Throwable th) {
            luaThread.errorfunc = luaValue;
            throw th;
        }
    }

    private void processErrorHooks(LuaError luaError, Prototype prototype, int i) {
        luaError.fileline = new StringBuffer().append(prototype.source != null ? prototype.source.tojstring() : "?").append(EmitterKt.COMMENT_PREFIX).append((prototype.lineinfo == null || i < 0 || i >= prototype.lineinfo.length) ? "?" : String.valueOf(prototype.lineinfo[i])).toString();
        luaError.traceback = errorHook(luaError.getMessage(), luaError.level);
    }

    private UpValue findupval(LuaValue[] luaValueArr, short s, UpValue[] upValueArr) {
        int length = upValueArr.length;
        for (int i = 0; i < length; i++) {
            if (upValueArr[i] != null && upValueArr[i].index == s) {
                return upValueArr[i];
            }
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (upValueArr[i2] == null) {
                UpValue upValue = new UpValue(luaValueArr, s);
                upValueArr[i2] = upValue;
                return upValue;
            }
        }
        error("No space for upvalue");
        return null;
    }

    protected LuaValue getUpvalue(int i) {
        return this.upValues[i].getValue();
    }

    protected void setUpvalue(int i, LuaValue luaValue) {
        this.upValues[i].setValue(luaValue);
    }

    @Override // org.luaj.vm2.LuaFunction
    public String name() {
        return new StringBuffer().append("<").append(this.f3287p.shortsource()).append(EmitterKt.COMMENT_PREFIX).append(this.f3287p.linedefined).append(">").toString();
    }
}
