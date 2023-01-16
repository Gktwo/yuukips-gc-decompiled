package org.luaj.vm2;

import org.luaj.vm2.Varargs;

/* loaded from: grasscutter.jar:org/luaj/vm2/LuaValue.class */
public abstract class LuaValue extends Varargs {
    public static final int TINT = -2;
    public static final int TNONE = -1;
    public static final int TNIL = 0;
    public static final int TBOOLEAN = 1;
    public static final int TLIGHTUSERDATA = 2;
    public static final int TNUMBER = 3;
    public static final int TSTRING = 4;
    public static final int TTABLE = 5;
    public static final int TFUNCTION = 6;
    public static final int TUSERDATA = 7;
    public static final int TTHREAD = 8;
    public static final int TVALUE = 9;
    public static final String[] TYPE_NAMES = {"nil", "boolean", "lightuserdata", "number", "string", "table", "function", "userdata", "thread", "value"};
    public static final LuaValue NIL = LuaNil._NIL;
    public static final LuaBoolean TRUE = LuaBoolean._TRUE;
    public static final LuaBoolean FALSE = LuaBoolean._FALSE;
    public static final LuaValue NONE = None._NONE;
    public static final LuaNumber ZERO = LuaInteger.valueOf(0);
    public static final LuaNumber ONE = LuaInteger.valueOf(1);
    public static final LuaNumber MINUSONE = LuaInteger.valueOf(-1);
    public static final LuaValue[] NOVALS = new LuaValue[0];
    public static LuaString ENV = valueOf("_ENV");
    public static final LuaString INDEX = valueOf("__index");
    public static final LuaString NEWINDEX = valueOf("__newindex");
    public static final LuaString CALL = valueOf("__call");
    public static final LuaString MODE = valueOf("__mode");
    public static final LuaString METATABLE = valueOf("__metatable");
    public static final LuaString ADD = valueOf("__add");
    public static final LuaString SUB = valueOf("__sub");
    public static final LuaString DIV = valueOf("__div");
    public static final LuaString MUL = valueOf("__mul");
    public static final LuaString POW = valueOf("__pow");
    public static final LuaString MOD = valueOf("__mod");
    public static final LuaString UNM = valueOf("__unm");
    public static final LuaString LEN = valueOf("__len");

    /* renamed from: EQ */
    public static final LuaString f3291EQ = valueOf("__eq");

    /* renamed from: LT */
    public static final LuaString f3292LT = valueOf("__lt");

    /* renamed from: LE */
    public static final LuaString f3293LE = valueOf("__le");
    public static final LuaString TOSTRING = valueOf("__tostring");
    public static final LuaString CONCAT = valueOf("__concat");
    public static final LuaString EMPTYSTRING = valueOf("");
    private static int MAXSTACK = 250;
    public static final LuaValue[] NILS = new LuaValue[MAXSTACK];
    private static final int MAXTAGLOOP = 100;

    /* loaded from: grasscutter.jar:org/luaj/vm2/LuaValue$None.class */
    private static final class None extends LuaNil {
        static None _NONE = new None();

        private None() {
        }

        @Override // org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
        public LuaValue arg(int i) {
            return NIL;
        }

        @Override // org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
        public int narg() {
            return 0;
        }

        @Override // org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
        public LuaValue arg1() {
            return NIL;
        }

        @Override // org.luaj.vm2.LuaNil, org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
        public String tojstring() {
            return "none";
        }

        @Override // org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
        public Varargs subargs(int i) {
            return i > 0 ? this : argerror(1, "start must be > 0");
        }

        @Override // org.luaj.vm2.Varargs
        void copyto(LuaValue[] luaValueArr, int i, int i2) {
            while (i2 > 0) {
                i++;
                luaValueArr[i] = NIL;
                i2--;
            }
        }
    }

    public abstract int type();

    public abstract String typename();

    public boolean isboolean() {
        return false;
    }

    public boolean isclosure() {
        return false;
    }

    public boolean isfunction() {
        return false;
    }

    public boolean isint() {
        return false;
    }

    public boolean isinttype() {
        return false;
    }

    public boolean islong() {
        return false;
    }

    public boolean isnil() {
        return false;
    }

    public boolean isnumber() {
        return false;
    }

    public boolean isstring() {
        return false;
    }

    public boolean isthread() {
        return false;
    }

    public boolean istable() {
        return false;
    }

    public boolean isuserdata() {
        return false;
    }

    public boolean isuserdata(Class cls) {
        return false;
    }

    public boolean toboolean() {
        return true;
    }

    public byte tobyte() {
        return 0;
    }

    public char tochar() {
        return 0;
    }

    public double todouble() {
        return 0.0d;
    }

    public float tofloat() {
        return 0.0f;
    }

    public int toint() {
        return 0;
    }

    public long tolong() {
        return 0;
    }

    public short toshort() {
        return 0;
    }

    @Override // org.luaj.vm2.Varargs
    public String tojstring() {
        return new StringBuffer().append(typename()).append(": ").append(Integer.toHexString(hashCode())).toString();
    }

    public Object touserdata() {
        return null;
    }

    public Object touserdata(Class cls) {
        return null;
    }

    @Override // org.luaj.vm2.Varargs
    public String toString() {
        return tojstring();
    }

    public LuaValue tonumber() {
        return NIL;
    }

    public LuaValue tostring() {
        return NIL;
    }

    public boolean optboolean(boolean z) {
        argerror("boolean");
        return false;
    }

    public LuaClosure optclosure(LuaClosure luaClosure) {
        argerror("closure");
        return null;
    }

    public double optdouble(double d) {
        argerror("double");
        return 0.0d;
    }

    public LuaFunction optfunction(LuaFunction luaFunction) {
        argerror("function");
        return null;
    }

    public int optint(int i) {
        argerror("int");
        return 0;
    }

    public LuaInteger optinteger(LuaInteger luaInteger) {
        argerror("integer");
        return null;
    }

    public long optlong(long j) {
        argerror("long");
        return 0;
    }

    public LuaNumber optnumber(LuaNumber luaNumber) {
        argerror("number");
        return null;
    }

    public String optjstring(String str) {
        argerror("String");
        return null;
    }

    public LuaString optstring(LuaString luaString) {
        argerror("string");
        return null;
    }

    public LuaTable opttable(LuaTable luaTable) {
        argerror("table");
        return null;
    }

    public LuaThread optthread(LuaThread luaThread) {
        argerror("thread");
        return null;
    }

    public Object optuserdata(Object obj) {
        argerror("object");
        return null;
    }

    public Object optuserdata(Class cls, Object obj) {
        argerror(cls.getName());
        return null;
    }

    public LuaValue optvalue(LuaValue luaValue) {
        return this;
    }

    public boolean checkboolean() {
        argerror("boolean");
        return false;
    }

    public LuaClosure checkclosure() {
        argerror("closure");
        return null;
    }

    public double checkdouble() {
        argerror("double");
        return 0.0d;
    }

    public LuaFunction checkfunction() {
        argerror("function");
        return null;
    }

    public Globals checkglobals() {
        argerror("globals");
        return null;
    }

    public int checkint() {
        argerror("int");
        return 0;
    }

    public LuaInteger checkinteger() {
        argerror("integer");
        return null;
    }

    public long checklong() {
        argerror("long");
        return 0;
    }

    public LuaNumber checknumber() {
        argerror("number");
        return null;
    }

    public LuaNumber checknumber(String str) {
        throw new LuaError(str);
    }

    public String checkjstring() {
        argerror("string");
        return null;
    }

    public LuaString checkstring() {
        argerror("string");
        return null;
    }

    public LuaTable checktable() {
        argerror("table");
        return null;
    }

    public LuaThread checkthread() {
        argerror("thread");
        return null;
    }

    public Object checkuserdata() {
        argerror("userdata");
        return null;
    }

    public Object checkuserdata(Class cls) {
        argerror("userdata");
        return null;
    }

    public LuaValue checknotnil() {
        return this;
    }

    public boolean isvalidkey() {
        return true;
    }

    public static LuaValue error(String str) {
        throw new LuaError(str);
    }

    public static void assert_(boolean z, String str) {
        if (!z) {
            throw new LuaError(str);
        }
    }

    protected LuaValue argerror(String str) {
        throw new LuaError(new StringBuffer().append("bad argument: ").append(str).append(" expected, got ").append(typename()).toString());
    }

    public static LuaValue argerror(int i, String str) {
        throw new LuaError(new StringBuffer().append("bad argument #").append(i).append(": ").append(str).toString());
    }

    protected LuaValue typerror(String str) {
        throw new LuaError(new StringBuffer().append(str).append(" expected, got ").append(typename()).toString());
    }

    protected LuaValue unimplemented(String str) {
        throw new LuaError(new StringBuffer().append("'").append(str).append("' not implemented for ").append(typename()).toString());
    }

    protected LuaValue illegal(String str, String str2) {
        throw new LuaError(new StringBuffer().append("illegal operation '").append(str).append("' for ").append(str2).toString());
    }

    protected LuaValue lenerror() {
        throw new LuaError(new StringBuffer().append("attempt to get length of ").append(typename()).toString());
    }

    protected LuaValue aritherror() {
        throw new LuaError(new StringBuffer().append("attempt to perform arithmetic on ").append(typename()).toString());
    }

    protected LuaValue aritherror(String str) {
        throw new LuaError(new StringBuffer().append("attempt to perform arithmetic '").append(str).append("' on ").append(typename()).toString());
    }

    protected LuaValue compareerror(String str) {
        throw new LuaError(new StringBuffer().append("attempt to compare ").append(typename()).append(" with ").append(str).toString());
    }

    protected LuaValue compareerror(LuaValue luaValue) {
        throw new LuaError(new StringBuffer().append("attempt to compare ").append(typename()).append(" with ").append(luaValue.typename()).toString());
    }

    public LuaValue get(LuaValue luaValue) {
        return gettable(this, luaValue);
    }

    public LuaValue get(int i) {
        return get(LuaInteger.valueOf(i));
    }

    public LuaValue get(String str) {
        return get(valueOf(str));
    }

    public void set(LuaValue luaValue, LuaValue luaValue2) {
        settable(this, luaValue, luaValue2);
    }

    public void set(int i, LuaValue luaValue) {
        set(LuaInteger.valueOf(i), luaValue);
    }

    public void set(int i, String str) {
        set(i, valueOf(str));
    }

    public void set(String str, LuaValue luaValue) {
        set(valueOf(str), luaValue);
    }

    public void set(String str, double d) {
        set(valueOf(str), valueOf(d));
    }

    public void set(String str, int i) {
        set(valueOf(str), valueOf(i));
    }

    public void set(String str, String str2) {
        set(valueOf(str), valueOf(str2));
    }

    public LuaValue rawget(LuaValue luaValue) {
        return unimplemented("rawget");
    }

    public LuaValue rawget(int i) {
        return rawget(valueOf(i));
    }

    public LuaValue rawget(String str) {
        return rawget(valueOf(str));
    }

    public void rawset(LuaValue luaValue, LuaValue luaValue2) {
        unimplemented("rawset");
    }

    public void rawset(int i, LuaValue luaValue) {
        rawset(valueOf(i), luaValue);
    }

    public void rawset(int i, String str) {
        rawset(i, valueOf(str));
    }

    public void rawset(String str, LuaValue luaValue) {
        rawset(valueOf(str), luaValue);
    }

    public void rawset(String str, double d) {
        rawset(valueOf(str), valueOf(d));
    }

    public void rawset(String str, int i) {
        rawset(valueOf(str), valueOf(i));
    }

    public void rawset(String str, String str2) {
        rawset(valueOf(str), valueOf(str2));
    }

    public void rawsetlist(int i, Varargs varargs) {
        int narg = varargs.narg();
        for (int i2 = 0; i2 < narg; i2++) {
            rawset(i + i2, varargs.arg(i2 + 1));
        }
    }

    public void presize(int i) {
        typerror("table");
    }

    public Varargs next(LuaValue luaValue) {
        return typerror("table");
    }

    public Varargs inext(LuaValue luaValue) {
        return typerror("table");
    }

    public LuaValue load(LuaValue luaValue) {
        return luaValue.call(EMPTYSTRING, this);
    }

    @Override // org.luaj.vm2.Varargs
    public LuaValue arg(int i) {
        return i == 1 ? this : NIL;
    }

    @Override // org.luaj.vm2.Varargs
    public int narg() {
        return 1;
    }

    @Override // org.luaj.vm2.Varargs
    public LuaValue arg1() {
        return this;
    }

    public LuaValue getmetatable() {
        return null;
    }

    public LuaValue setmetatable(LuaValue luaValue) {
        return argerror("table");
    }

    public LuaValue call() {
        return callmt().call(this);
    }

    public LuaValue call(LuaValue luaValue) {
        return callmt().call(this, luaValue);
    }

    public LuaValue call(String str) {
        return call(valueOf(str));
    }

    public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        return callmt().call(this, luaValue, luaValue2);
    }

    public LuaValue call(LuaValue luaValue, LuaValue luaValue2, LuaValue luaValue3) {
        return callmt().invoke(new LuaValue[]{this, luaValue, luaValue2, luaValue3}).arg1();
    }

    public LuaValue method(String str) {
        return get(str).call(this);
    }

    public LuaValue method(LuaValue luaValue) {
        return get(luaValue).call(this);
    }

    public LuaValue method(String str, LuaValue luaValue) {
        return get(str).call(this, luaValue);
    }

    public LuaValue method(LuaValue luaValue, LuaValue luaValue2) {
        return get(luaValue).call(this, luaValue2);
    }

    public LuaValue method(String str, LuaValue luaValue, LuaValue luaValue2) {
        return get(str).call(this, luaValue, luaValue2);
    }

    public LuaValue method(LuaValue luaValue, LuaValue luaValue2, LuaValue luaValue3) {
        return get(luaValue).call(this, luaValue2, luaValue3);
    }

    public Varargs invoke() {
        return invoke(NONE);
    }

    public Varargs invoke(Varargs varargs) {
        return callmt().invoke(this, varargs);
    }

    public Varargs invoke(LuaValue luaValue, Varargs varargs) {
        return invoke(varargsOf(luaValue, varargs));
    }

    public Varargs invoke(LuaValue luaValue, LuaValue luaValue2, Varargs varargs) {
        return invoke(varargsOf(luaValue, luaValue2, varargs));
    }

    public Varargs invoke(LuaValue[] luaValueArr) {
        return invoke(varargsOf(luaValueArr));
    }

    public Varargs invoke(LuaValue[] luaValueArr, Varargs varargs) {
        return invoke(varargsOf(luaValueArr, varargs));
    }

    public Varargs invokemethod(String str) {
        return get(str).invoke(this);
    }

    public Varargs invokemethod(LuaValue luaValue) {
        return get(luaValue).invoke(this);
    }

    public Varargs invokemethod(String str, Varargs varargs) {
        return get(str).invoke(varargsOf(this, varargs));
    }

    public Varargs invokemethod(LuaValue luaValue, Varargs varargs) {
        return get(luaValue).invoke(varargsOf(this, varargs));
    }

    public Varargs invokemethod(String str, LuaValue[] luaValueArr) {
        return get(str).invoke(varargsOf(this, varargsOf(luaValueArr)));
    }

    public Varargs invokemethod(LuaValue luaValue, LuaValue[] luaValueArr) {
        return get(luaValue).invoke(varargsOf(this, varargsOf(luaValueArr)));
    }

    protected LuaValue callmt() {
        return checkmetatag(CALL, "attempt to call ");
    }

    public LuaValue not() {
        return FALSE;
    }

    public LuaValue neg() {
        return checkmetatag(UNM, "attempt to perform arithmetic on ").call(this);
    }

    public LuaValue len() {
        return checkmetatag(LEN, "attempt to get length of ").call(this);
    }

    public int length() {
        return len().toint();
    }

    public int rawlen() {
        typerror("table or string");
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    /* renamed from: eq */
    public LuaValue mo24eq(LuaValue luaValue) {
        return this == luaValue ? TRUE : FALSE;
    }

    public boolean eq_b(LuaValue luaValue) {
        return this == luaValue;
    }

    public LuaValue neq(LuaValue luaValue) {
        return eq_b(luaValue) ? FALSE : TRUE;
    }

    public boolean neq_b(LuaValue luaValue) {
        return !eq_b(luaValue);
    }

    public boolean raweq(LuaValue luaValue) {
        return this == luaValue;
    }

    public boolean raweq(LuaUserdata luaUserdata) {
        return false;
    }

    public boolean raweq(LuaString luaString) {
        return false;
    }

    public boolean raweq(double d) {
        return false;
    }

    public boolean raweq(int i) {
        return false;
    }

    public static final boolean eqmtcall(LuaValue luaValue, LuaValue luaValue2, LuaValue luaValue3, LuaValue luaValue4) {
        LuaValue rawget = luaValue2.rawget(f3291EQ);
        if (rawget.isnil() || rawget != luaValue4.rawget(f3291EQ)) {
            return false;
        }
        return rawget.call(luaValue, luaValue3).toboolean();
    }

    public LuaValue add(LuaValue luaValue) {
        return arithmt(ADD, luaValue);
    }

    public LuaValue add(double d) {
        return arithmtwith(ADD, d);
    }

    public LuaValue add(int i) {
        return add((double) i);
    }

    public LuaValue sub(LuaValue luaValue) {
        return arithmt(SUB, luaValue);
    }

    public LuaValue sub(double d) {
        return aritherror("sub");
    }

    public LuaValue sub(int i) {
        return aritherror("sub");
    }

    public LuaValue subFrom(double d) {
        return arithmtwith(SUB, d);
    }

    public LuaValue subFrom(int i) {
        return subFrom((double) i);
    }

    public LuaValue mul(LuaValue luaValue) {
        return arithmt(MUL, luaValue);
    }

    public LuaValue mul(double d) {
        return arithmtwith(MUL, d);
    }

    public LuaValue mul(int i) {
        return mul((double) i);
    }

    public LuaValue pow(LuaValue luaValue) {
        return arithmt(POW, luaValue);
    }

    public LuaValue pow(double d) {
        return aritherror("pow");
    }

    public LuaValue pow(int i) {
        return aritherror("pow");
    }

    public LuaValue powWith(double d) {
        return arithmtwith(POW, d);
    }

    public LuaValue powWith(int i) {
        return powWith((double) i);
    }

    public LuaValue div(LuaValue luaValue) {
        return arithmt(DIV, luaValue);
    }

    public LuaValue div(double d) {
        return aritherror("div");
    }

    public LuaValue div(int i) {
        return aritherror("div");
    }

    public LuaValue divInto(double d) {
        return arithmtwith(DIV, d);
    }

    public LuaValue mod(LuaValue luaValue) {
        return arithmt(MOD, luaValue);
    }

    public LuaValue mod(double d) {
        return aritherror("mod");
    }

    public LuaValue mod(int i) {
        return aritherror("mod");
    }

    public LuaValue modFrom(double d) {
        return arithmtwith(MOD, d);
    }

    protected LuaValue arithmt(LuaValue luaValue, LuaValue luaValue2) {
        LuaValue metatag = metatag(luaValue);
        if (metatag.isnil()) {
            metatag = luaValue2.metatag(luaValue);
            if (metatag.isnil()) {
                error(new StringBuffer().append("attempt to perform arithmetic ").append(luaValue).append(" on ").append(typename()).append(" and ").append(luaValue2.typename()).toString());
            }
        }
        return metatag.call(this, luaValue2);
    }

    protected LuaValue arithmtwith(LuaValue luaValue, double d) {
        LuaValue metatag = metatag(luaValue);
        if (metatag.isnil()) {
            error(new StringBuffer().append("attempt to perform arithmetic ").append(luaValue).append(" on number and ").append(typename()).toString());
        }
        return metatag.call(valueOf(d), this);
    }

    /* renamed from: lt */
    public LuaValue mo18lt(LuaValue luaValue) {
        return comparemt(f3292LT, luaValue);
    }

    /* renamed from: lt */
    public LuaValue mo20lt(double d) {
        return compareerror("number");
    }

    /* renamed from: lt */
    public LuaValue mo19lt(int i) {
        return compareerror("number");
    }

    public boolean lt_b(LuaValue luaValue) {
        return comparemt(f3292LT, luaValue).toboolean();
    }

    public boolean lt_b(int i) {
        compareerror("number");
        return false;
    }

    public boolean lt_b(double d) {
        compareerror("number");
        return false;
    }

    public LuaValue lteq(LuaValue luaValue) {
        return comparemt(f3293LE, luaValue);
    }

    public LuaValue lteq(double d) {
        return compareerror("number");
    }

    public LuaValue lteq(int i) {
        return compareerror("number");
    }

    public boolean lteq_b(LuaValue luaValue) {
        return comparemt(f3293LE, luaValue).toboolean();
    }

    public boolean lteq_b(int i) {
        compareerror("number");
        return false;
    }

    public boolean lteq_b(double d) {
        compareerror("number");
        return false;
    }

    /* renamed from: gt */
    public LuaValue mo21gt(LuaValue luaValue) {
        return luaValue.comparemt(f3293LE, this);
    }

    /* renamed from: gt */
    public LuaValue mo23gt(double d) {
        return compareerror("number");
    }

    /* renamed from: gt */
    public LuaValue mo22gt(int i) {
        return compareerror("number");
    }

    public boolean gt_b(LuaValue luaValue) {
        return luaValue.comparemt(f3293LE, this).toboolean();
    }

    public boolean gt_b(int i) {
        compareerror("number");
        return false;
    }

    public boolean gt_b(double d) {
        compareerror("number");
        return false;
    }

    public LuaValue gteq(LuaValue luaValue) {
        return luaValue.comparemt(f3292LT, this);
    }

    public LuaValue gteq(double d) {
        return compareerror("number");
    }

    public LuaValue gteq(int i) {
        return valueOf(todouble() >= ((double) i));
    }

    public boolean gteq_b(LuaValue luaValue) {
        return luaValue.comparemt(f3292LT, this).toboolean();
    }

    public boolean gteq_b(int i) {
        compareerror("number");
        return false;
    }

    public boolean gteq_b(double d) {
        compareerror("number");
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        if (r0.isnil() == false) goto L_0x0049;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.luaj.vm2.LuaValue comparemt(org.luaj.vm2.LuaValue r5, org.luaj.vm2.LuaValue r6) {
        /*
            r4 = this;
            r0 = r4
            r1 = r5
            org.luaj.vm2.LuaValue r0 = r0.metatag(r1)
            r1 = r0
            r7 = r1
            boolean r0 = r0.isnil()
            if (r0 == 0) goto L_0x001a
            r0 = r6
            r1 = r5
            org.luaj.vm2.LuaValue r0 = r0.metatag(r1)
            r1 = r0
            r7 = r1
            boolean r0 = r0.isnil()
            if (r0 != 0) goto L_0x0021
        L_0x001a:
            r0 = r7
            r1 = r4
            r2 = r6
            org.luaj.vm2.LuaValue r0 = r0.call(r1, r2)
            return r0
        L_0x0021:
            org.luaj.vm2.LuaString r0 = org.luaj.vm2.LuaValue.f3293LE
            r1 = r5
            boolean r0 = r0.raweq(r1)
            if (r0 == 0) goto L_0x0053
            r0 = r4
            org.luaj.vm2.LuaString r1 = org.luaj.vm2.LuaValue.f3292LT
            org.luaj.vm2.LuaValue r0 = r0.metatag(r1)
            r1 = r0
            r7 = r1
            boolean r0 = r0.isnil()
            if (r0 == 0) goto L_0x0049
            r0 = r6
            org.luaj.vm2.LuaString r1 = org.luaj.vm2.LuaValue.f3292LT
            org.luaj.vm2.LuaValue r0 = r0.metatag(r1)
            r1 = r0
            r7 = r1
            boolean r0 = r0.isnil()
            if (r0 != 0) goto L_0x0053
        L_0x0049:
            r0 = r7
            r1 = r6
            r2 = r4
            org.luaj.vm2.LuaValue r0 = r0.call(r1, r2)
            org.luaj.vm2.LuaValue r0 = r0.not()
            return r0
        L_0x0053:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r1 = r0
            r1.<init>()
            java.lang.String r1 = "attempt to compare "
            java.lang.StringBuffer r0 = r0.append(r1)
            r1 = r5
            java.lang.StringBuffer r0 = r0.append(r1)
            java.lang.String r1 = " on "
            java.lang.StringBuffer r0 = r0.append(r1)
            r1 = r4
            java.lang.String r1 = r1.typename()
            java.lang.StringBuffer r0 = r0.append(r1)
            java.lang.String r1 = " and "
            java.lang.StringBuffer r0 = r0.append(r1)
            r1 = r6
            java.lang.String r1 = r1.typename()
            java.lang.StringBuffer r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            org.luaj.vm2.LuaValue r0 = error(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.LuaValue.comparemt(org.luaj.vm2.LuaValue, org.luaj.vm2.LuaValue):org.luaj.vm2.LuaValue");
    }

    public int strcmp(LuaValue luaValue) {
        error(new StringBuffer().append("attempt to compare ").append(typename()).toString());
        return 0;
    }

    public int strcmp(LuaString luaString) {
        error(new StringBuffer().append("attempt to compare ").append(typename()).toString());
        return 0;
    }

    public LuaValue concat(LuaValue luaValue) {
        return concatmt(luaValue);
    }

    public LuaValue concatTo(LuaValue luaValue) {
        return luaValue.concatmt(this);
    }

    public LuaValue concatTo(LuaNumber luaNumber) {
        return luaNumber.concatmt(this);
    }

    public LuaValue concatTo(LuaString luaString) {
        return luaString.concatmt(this);
    }

    public Buffer buffer() {
        return new Buffer(this);
    }

    public Buffer concat(Buffer buffer) {
        return buffer.concatTo(this);
    }

    public LuaValue concatmt(LuaValue luaValue) {
        LuaValue metatag = metatag(CONCAT);
        if (metatag.isnil()) {
            LuaValue metatag2 = luaValue.metatag(CONCAT);
            metatag = metatag2;
            if (metatag2.isnil()) {
                error(new StringBuffer().append("attempt to concatenate ").append(typename()).append(" and ").append(luaValue.typename()).toString());
            }
        }
        return metatag.call(this, luaValue);
    }

    public LuaValue and(LuaValue luaValue) {
        return toboolean() ? luaValue : this;
    }

    /* renamed from: or */
    public LuaValue m17or(LuaValue luaValue) {
        return toboolean() ? this : luaValue;
    }

    public boolean testfor_b(LuaValue luaValue, LuaValue luaValue2) {
        return luaValue2.gt_b(0) ? lteq_b(luaValue) : gteq_b(luaValue);
    }

    public LuaString strvalue() {
        typerror("strValue");
        return null;
    }

    public LuaValue strongvalue() {
        return this;
    }

    public static LuaBoolean valueOf(boolean z) {
        return z ? TRUE : FALSE;
    }

    public static LuaInteger valueOf(int i) {
        return LuaInteger.valueOf(i);
    }

    public static LuaNumber valueOf(double d) {
        return LuaDouble.valueOf(d);
    }

    public static LuaString valueOf(String str) {
        return LuaString.valueOf(str);
    }

    public static LuaString valueOf(byte[] bArr) {
        return LuaString.valueOf(bArr);
    }

    public static LuaString valueOf(byte[] bArr, int i, int i2) {
        return LuaString.valueOf(bArr, i, i2);
    }

    public static LuaTable tableOf() {
        return new LuaTable();
    }

    public static LuaTable tableOf(Varargs varargs, int i) {
        return new LuaTable(varargs, i);
    }

    public static LuaTable tableOf(int i, int i2) {
        return new LuaTable(i, i2);
    }

    public static LuaTable listOf(LuaValue[] luaValueArr) {
        return new LuaTable(null, luaValueArr, null);
    }

    public static LuaTable listOf(LuaValue[] luaValueArr, Varargs varargs) {
        return new LuaTable(null, luaValueArr, varargs);
    }

    public static LuaTable tableOf(LuaValue[] luaValueArr) {
        return new LuaTable(luaValueArr, null, null);
    }

    public static LuaTable tableOf(LuaValue[] luaValueArr, LuaValue[] luaValueArr2) {
        return new LuaTable(luaValueArr, luaValueArr2, null);
    }

    public static LuaTable tableOf(LuaValue[] luaValueArr, LuaValue[] luaValueArr2, Varargs varargs) {
        return new LuaTable(luaValueArr, luaValueArr2, varargs);
    }

    public static LuaUserdata userdataOf(Object obj) {
        return new LuaUserdata(obj);
    }

    public static LuaUserdata userdataOf(Object obj, LuaValue luaValue) {
        return new LuaUserdata(obj, luaValue);
    }

    protected static LuaValue gettable(LuaValue luaValue, LuaValue luaValue2) {
        LuaValue luaValue3;
        int i = 0;
        do {
            if (luaValue.istable()) {
                LuaValue rawget = luaValue.rawget(luaValue2);
                if (rawget.isnil()) {
                    LuaValue metatag = luaValue.metatag(INDEX);
                    luaValue3 = metatag;
                    if (metatag.isnil()) {
                    }
                }
                return rawget;
            }
            LuaValue metatag2 = luaValue.metatag(INDEX);
            luaValue3 = metatag2;
            if (metatag2.isnil()) {
                luaValue.indexerror();
            }
            if (luaValue3.isfunction()) {
                return luaValue3.call(luaValue, luaValue2);
            }
            luaValue = luaValue3;
            i++;
        } while (i < 100);
        error("loop in gettable");
        return NIL;
    }

    protected static boolean settable(LuaValue luaValue, LuaValue luaValue2, LuaValue luaValue3) {
        LuaValue luaValue4;
        int i = 0;
        do {
            if (luaValue.istable()) {
                if (luaValue.rawget(luaValue2).isnil()) {
                    LuaValue metatag = luaValue.metatag(NEWINDEX);
                    luaValue4 = metatag;
                    if (metatag.isnil()) {
                    }
                }
                luaValue.rawset(luaValue2, luaValue3);
                return true;
            }
            LuaValue metatag2 = luaValue.metatag(NEWINDEX);
            luaValue4 = metatag2;
            if (metatag2.isnil()) {
                luaValue.typerror("index");
            }
            if (luaValue4.isfunction()) {
                luaValue4.call(luaValue, luaValue2, luaValue3);
                return true;
            }
            luaValue = luaValue4;
            i++;
        } while (i < 100);
        error("loop in settable");
        return false;
    }

    public LuaValue metatag(LuaValue luaValue) {
        LuaValue luaValue2 = getmetatable();
        return luaValue2 == null ? NIL : luaValue2.rawget(luaValue);
    }

    protected LuaValue checkmetatag(LuaValue luaValue, String str) {
        LuaValue metatag = metatag(luaValue);
        if (!metatag.isnil()) {
            return metatag;
        }
        throw new LuaError(new StringBuffer().append(str).append(typename()).toString());
    }

    protected static Metatable metatableOf(LuaValue luaValue) {
        if (luaValue != null && luaValue.istable()) {
            LuaValue rawget = luaValue.rawget(MODE);
            if (rawget.isstring()) {
                String str = rawget.tojstring();
                boolean z = str.indexOf(107) >= 0;
                boolean z2 = str.indexOf(118) >= 0;
                if (z || z2) {
                    return new WeakTable(z, z2, luaValue);
                }
            }
            return (LuaTable) luaValue;
        } else if (luaValue != null) {
            return new NonTableMetatable(luaValue);
        } else {
            return null;
        }
    }

    private void indexerror() {
        error(new StringBuffer().append("attempt to index ? (a ").append(typename()).append(" value)").toString());
    }

    public static Varargs varargsOf(LuaValue[] luaValueArr) {
        switch (luaValueArr.length) {
            case 0:
                return NONE;
            case 1:
                return luaValueArr[0];
            case 2:
                return new Varargs.PairVarargs(luaValueArr[0], luaValueArr[1]);
            default:
                return new Varargs.ArrayVarargs(luaValueArr, NONE);
        }
    }

    public static Varargs varargsOf(LuaValue[] luaValueArr, Varargs varargs) {
        switch (luaValueArr.length) {
            case 0:
                return varargs;
            case 1:
                return varargs.narg() > 0 ? new Varargs.PairVarargs(luaValueArr[0], varargs) : luaValueArr[0];
            case 2:
                return varargs.narg() > 0 ? new Varargs.ArrayVarargs(luaValueArr, varargs) : new Varargs.PairVarargs(luaValueArr[0], luaValueArr[1]);
            default:
                return new Varargs.ArrayVarargs(luaValueArr, varargs);
        }
    }

    public static Varargs varargsOf(LuaValue[] luaValueArr, int i, int i2) {
        switch (i2) {
            case 0:
                return NONE;
            case 1:
                return luaValueArr[i];
            case 2:
                return new Varargs.PairVarargs(luaValueArr[i + 0], luaValueArr[i + 1]);
            default:
                return new Varargs.ArrayPartVarargs(luaValueArr, i, i2, NONE);
        }
    }

    public static Varargs varargsOf(LuaValue[] luaValueArr, int i, int i2, Varargs varargs) {
        switch (i2) {
            case 0:
                return varargs;
            case 1:
                return varargs.narg() > 0 ? new Varargs.PairVarargs(luaValueArr[i], varargs) : luaValueArr[i];
            case 2:
                return varargs.narg() > 0 ? new Varargs.ArrayPartVarargs(luaValueArr, i, i2, varargs) : new Varargs.PairVarargs(luaValueArr[i], luaValueArr[i + 1]);
            default:
                return new Varargs.ArrayPartVarargs(luaValueArr, i, i2, varargs);
        }
    }

    public static Varargs varargsOf(LuaValue luaValue, Varargs varargs) {
        switch (varargs.narg()) {
            case 0:
                return luaValue;
            default:
                return new Varargs.PairVarargs(luaValue, varargs);
        }
    }

    public static Varargs varargsOf(LuaValue luaValue, LuaValue luaValue2, Varargs varargs) {
        switch (varargs.narg()) {
            case 0:
                return new Varargs.PairVarargs(luaValue, luaValue2);
            default:
                return new Varargs.ArrayPartVarargs(new LuaValue[]{luaValue, luaValue2}, 0, 2, varargs);
        }
    }

    public static Varargs tailcallOf(LuaValue luaValue, Varargs varargs) {
        return new TailcallVarargs(luaValue, varargs);
    }

    public Varargs onInvoke(Varargs varargs) {
        return invoke(varargs);
    }

    public void initupvalue1(LuaValue luaValue) {
    }

    @Override // org.luaj.vm2.Varargs
    public Varargs subargs(int i) {
        return i == 1 ? this : i > 1 ? NONE : argerror(1, "start must be > 0");
    }

    static {
        for (int i = 0; i < MAXSTACK; i++) {
            NILS[i] = NIL;
        }
    }
}
