package org.luaj.vm2;

/* loaded from: grasscutter.jar:org/luaj/vm2/Varargs.class */
public abstract class Varargs {

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/Varargs$ArrayPartVarargs.class */
    public static final class ArrayPartVarargs extends Varargs {
        private final int offset;

        /* renamed from: v */
        private final LuaValue[] f3297v;
        private final int length;
        private final Varargs more;

        ArrayPartVarargs(LuaValue[] luaValueArr, int i, int i2) {
            this.f3297v = luaValueArr;
            this.offset = i;
            this.length = i2;
            this.more = LuaValue.NONE;
        }

        public ArrayPartVarargs(LuaValue[] luaValueArr, int i, int i2, Varargs varargs) {
            this.f3297v = luaValueArr;
            this.offset = i;
            this.length = i2;
            this.more = varargs;
        }

        @Override // org.luaj.vm2.Varargs
        public LuaValue arg(int i) {
            return i < 1 ? LuaValue.NIL : i <= this.length ? this.f3297v[(this.offset + i) - 1] : this.more.arg(i - this.length);
        }

        @Override // org.luaj.vm2.Varargs
        public int narg() {
            return this.length + this.more.narg();
        }

        @Override // org.luaj.vm2.Varargs
        public LuaValue arg1() {
            return this.length > 0 ? this.f3297v[this.offset] : this.more.arg1();
        }

        @Override // org.luaj.vm2.Varargs
        public Varargs subargs(int i) {
            if (i <= 0) {
                LuaValue.argerror(1, "start must be > 0");
            }
            return i == 1 ? this : i > this.length ? this.more.subargs(i - this.length) : LuaValue.varargsOf(this.f3297v, (this.offset + i) - 1, this.length - (i - 1), this.more);
        }

        @Override // org.luaj.vm2.Varargs
        void copyto(LuaValue[] luaValueArr, int i, int i2) {
            int min = Math.min(this.length, i2);
            System.arraycopy(this.f3297v, this.offset, luaValueArr, i, min);
            this.more.copyto(luaValueArr, i + min, i2 - min);
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/Varargs$ArrayVarargs.class */
    public static final class ArrayVarargs extends Varargs {

        /* renamed from: v */
        private final LuaValue[] f3298v;

        /* renamed from: r */
        private final Varargs f3299r;

        /* access modifiers changed from: package-private */
        public ArrayVarargs(LuaValue[] luaValueArr, Varargs varargs) {
            this.f3298v = luaValueArr;
            this.f3299r = varargs;
        }

        @Override // org.luaj.vm2.Varargs
        public LuaValue arg(int i) {
            return i < 1 ? LuaValue.NIL : i <= this.f3298v.length ? this.f3298v[i - 1] : this.f3299r.arg(i - this.f3298v.length);
        }

        @Override // org.luaj.vm2.Varargs
        public int narg() {
            return this.f3298v.length + this.f3299r.narg();
        }

        @Override // org.luaj.vm2.Varargs
        public LuaValue arg1() {
            return this.f3298v.length > 0 ? this.f3298v[0] : this.f3299r.arg1();
        }

        @Override // org.luaj.vm2.Varargs
        public Varargs subargs(int i) {
            if (i <= 0) {
                LuaValue.argerror(1, "start must be > 0");
            }
            return i == 1 ? this : i > this.f3298v.length ? this.f3299r.subargs(i - this.f3298v.length) : LuaValue.varargsOf(this.f3298v, i - 1, this.f3298v.length - (i - 1), this.f3299r);
        }

        @Override // org.luaj.vm2.Varargs
        void copyto(LuaValue[] luaValueArr, int i, int i2) {
            int min = Math.min(this.f3298v.length, i2);
            System.arraycopy(this.f3298v, 0, luaValueArr, i, min);
            this.f3299r.copyto(luaValueArr, i + min, i2 - min);
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/Varargs$PairVarargs.class */
    public static final class PairVarargs extends Varargs {

        /* renamed from: v1 */
        private final LuaValue f3300v1;

        /* renamed from: v2 */
        private final Varargs f3301v2;

        /* access modifiers changed from: package-private */
        public PairVarargs(LuaValue luaValue, Varargs varargs) {
            this.f3300v1 = luaValue;
            this.f3301v2 = varargs;
        }

        @Override // org.luaj.vm2.Varargs
        public LuaValue arg(int i) {
            return i == 1 ? this.f3300v1 : this.f3301v2.arg(i - 1);
        }

        @Override // org.luaj.vm2.Varargs
        public int narg() {
            return 1 + this.f3301v2.narg();
        }

        @Override // org.luaj.vm2.Varargs
        public LuaValue arg1() {
            return this.f3300v1;
        }

        @Override // org.luaj.vm2.Varargs
        public Varargs subargs(int i) {
            return i == 1 ? this : i == 2 ? this.f3301v2 : i > 2 ? this.f3301v2.subargs(i - 1) : LuaValue.argerror(1, "start must be > 0");
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/Varargs$SubVarargs.class */
    static class SubVarargs extends Varargs {

        /* renamed from: v */
        private final Varargs f3302v;
        private final int start;
        private final int end;

        public SubVarargs(Varargs varargs, int i, int i2) {
            this.f3302v = varargs;
            this.start = i;
            this.end = i2;
        }

        @Override // org.luaj.vm2.Varargs
        public LuaValue arg(int i) {
            int i2 = i + (this.start - 1);
            return (i2 < this.start || i2 > this.end) ? LuaValue.NIL : this.f3302v.arg(i2);
        }

        @Override // org.luaj.vm2.Varargs
        public LuaValue arg1() {
            return this.f3302v.arg(this.start);
        }

        @Override // org.luaj.vm2.Varargs
        public int narg() {
            return (this.end + 1) - this.start;
        }

        @Override // org.luaj.vm2.Varargs
        public Varargs subargs(int i) {
            if (i == 1) {
                return this;
            }
            int i2 = (this.start + i) - 1;
            return i > 0 ? i2 >= this.end ? LuaValue.NONE : i2 == this.end ? this.f3302v.arg(this.end) : i2 == this.end - 1 ? new PairVarargs(this.f3302v.arg(this.end - 1), this.f3302v.arg(this.end)) : new SubVarargs(this.f3302v, i2, this.end) : new SubVarargs(this.f3302v, i2, this.end);
        }
    }

    public abstract LuaValue arg(int i);

    public abstract int narg();

    public abstract LuaValue arg1();

    public Varargs eval() {
        return this;
    }

    public boolean isTailcall() {
        return false;
    }

    public int type(int i) {
        return arg(i).type();
    }

    public boolean isnil(int i) {
        return arg(i).isnil();
    }

    public boolean isfunction(int i) {
        return arg(i).isfunction();
    }

    public boolean isnumber(int i) {
        return arg(i).isnumber();
    }

    public boolean isstring(int i) {
        return arg(i).isstring();
    }

    public boolean istable(int i) {
        return arg(i).istable();
    }

    public boolean isthread(int i) {
        return arg(i).isthread();
    }

    public boolean isuserdata(int i) {
        return arg(i).isuserdata();
    }

    public boolean isvalue(int i) {
        return i > 0 && i <= narg();
    }

    public boolean optboolean(int i, boolean z) {
        return arg(i).optboolean(z);
    }

    public LuaClosure optclosure(int i, LuaClosure luaClosure) {
        return arg(i).optclosure(luaClosure);
    }

    public double optdouble(int i, double d) {
        return arg(i).optdouble(d);
    }

    public LuaFunction optfunction(int i, LuaFunction luaFunction) {
        return arg(i).optfunction(luaFunction);
    }

    public int optint(int i, int i2) {
        return arg(i).optint(i2);
    }

    public LuaInteger optinteger(int i, LuaInteger luaInteger) {
        return arg(i).optinteger(luaInteger);
    }

    public long optlong(int i, long j) {
        return arg(i).optlong(j);
    }

    public LuaNumber optnumber(int i, LuaNumber luaNumber) {
        return arg(i).optnumber(luaNumber);
    }

    public String optjstring(int i, String str) {
        return arg(i).optjstring(str);
    }

    public LuaString optstring(int i, LuaString luaString) {
        return arg(i).optstring(luaString);
    }

    public LuaTable opttable(int i, LuaTable luaTable) {
        return arg(i).opttable(luaTable);
    }

    public LuaThread optthread(int i, LuaThread luaThread) {
        return arg(i).optthread(luaThread);
    }

    public Object optuserdata(int i, Object obj) {
        return arg(i).optuserdata(obj);
    }

    public Object optuserdata(int i, Class cls, Object obj) {
        return arg(i).optuserdata(cls, obj);
    }

    public LuaValue optvalue(int i, LuaValue luaValue) {
        return (i <= 0 || i > narg()) ? luaValue : arg(i);
    }

    public boolean checkboolean(int i) {
        return arg(i).checkboolean();
    }

    public LuaClosure checkclosure(int i) {
        return arg(i).checkclosure();
    }

    public double checkdouble(int i) {
        return arg(i).checknumber().todouble();
    }

    public LuaFunction checkfunction(int i) {
        return arg(i).checkfunction();
    }

    public int checkint(int i) {
        return arg(i).checknumber().toint();
    }

    public LuaInteger checkinteger(int i) {
        return arg(i).checkinteger();
    }

    public long checklong(int i) {
        return arg(i).checknumber().tolong();
    }

    public LuaNumber checknumber(int i) {
        return arg(i).checknumber();
    }

    public String checkjstring(int i) {
        return arg(i).checkjstring();
    }

    public LuaString checkstring(int i) {
        return arg(i).checkstring();
    }

    public LuaTable checktable(int i) {
        return arg(i).checktable();
    }

    public LuaThread checkthread(int i) {
        return arg(i).checkthread();
    }

    public Object checkuserdata(int i) {
        return arg(i).checkuserdata();
    }

    public Object checkuserdata(int i, Class cls) {
        return arg(i).checkuserdata(cls);
    }

    public LuaValue checkvalue(int i) {
        return i <= narg() ? arg(i) : LuaValue.argerror(i, "value expected");
    }

    public LuaValue checknotnil(int i) {
        return arg(i).checknotnil();
    }

    public void argcheck(boolean z, int i, String str) {
        if (!z) {
            LuaValue.argerror(i, str);
        }
    }

    public boolean isnoneornil(int i) {
        return i > narg() || arg(i).isnil();
    }

    public boolean toboolean(int i) {
        return arg(i).toboolean();
    }

    public byte tobyte(int i) {
        return arg(i).tobyte();
    }

    public char tochar(int i) {
        return arg(i).tochar();
    }

    public double todouble(int i) {
        return arg(i).todouble();
    }

    public float tofloat(int i) {
        return arg(i).tofloat();
    }

    public int toint(int i) {
        return arg(i).toint();
    }

    public long tolong(int i) {
        return arg(i).tolong();
    }

    public String tojstring(int i) {
        return arg(i).tojstring();
    }

    public short toshort(int i) {
        return arg(i).toshort();
    }

    public Object touserdata(int i) {
        return arg(i).touserdata();
    }

    public Object touserdata(int i, Class cls) {
        return arg(i).touserdata(cls);
    }

    public String tojstring() {
        Buffer buffer = new Buffer();
        buffer.append("(");
        int narg = narg();
        for (int i = 1; i <= narg; i++) {
            if (i > 1) {
                buffer.append(",");
            }
            buffer.append(arg(i).tojstring());
        }
        buffer.append(")");
        return buffer.tojstring();
    }

    public String toString() {
        return tojstring();
    }

    public abstract Varargs subargs(int i);

    /* access modifiers changed from: package-private */
    public void copyto(LuaValue[] luaValueArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            luaValueArr[i + i3] = arg(i3 + 1);
        }
    }

    /* access modifiers changed from: package-private */
    public Varargs dealias() {
        int narg = narg();
        switch (narg) {
            case 0:
                return LuaValue.NONE;
            case 1:
                return arg1();
            case 2:
                return new PairVarargs(arg1(), arg(2));
            default:
                LuaValue[] luaValueArr = new LuaValue[narg];
                copyto(luaValueArr, 0, narg);
                return new ArrayVarargs(luaValueArr, LuaValue.NONE);
        }
    }
}
