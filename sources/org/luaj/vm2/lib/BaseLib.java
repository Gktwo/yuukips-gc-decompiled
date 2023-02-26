package org.luaj.vm2.lib;

import java.io.IOException;
import java.io.InputStream;
import org.jline.builtins.Tmux;
import org.jline.reader.impl.LineReaderImpl;
import org.luaj.vm2.Globals;
import org.luaj.vm2.Lua;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib.class */
public class BaseLib extends TwoArgFunction implements ResourceFinder {
    Globals globals;

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$StringInputStream.class */
    private static class StringInputStream extends InputStream {
        final LuaValue func;
        byte[] bytes;
        int offset;
        int remaining = 0;

        StringInputStream(LuaValue luaValue) {
            this.func = luaValue;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.remaining <= 0) {
                LuaValue call = this.func.call();
                if (call.isnil()) {
                    return -1;
                }
                LuaString strvalue = call.strvalue();
                this.bytes = strvalue.m_bytes;
                this.offset = strvalue.m_offset;
                this.remaining = strvalue.m_length;
                if (this.remaining <= 0) {
                    return -1;
                }
            }
            this.remaining--;
            byte[] bArr = this.bytes;
            int i = this.offset;
            this.offset = i + 1;
            return bArr[i];
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$_assert.class */
    static final class _assert extends VarArgFunction {
        _assert() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            if (!varargs.arg1().toboolean()) {
                error(varargs.narg() > 1 ? varargs.optjstring(2, "assertion failed!") : "assertion failed!");
            }
            return varargs;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$collectgarbage.class */
    static final class collectgarbage extends VarArgFunction {
        collectgarbage() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            String optjstring = varargs.optjstring(1, "collect");
            if ("collect".equals(optjstring)) {
                System.gc();
                return ZERO;
            } else if ("count".equals(optjstring)) {
                Runtime runtime = Runtime.getRuntime();
                long freeMemory = runtime.totalMemory() - runtime.freeMemory();
                return varargsOf(valueOf(((double) freeMemory) / 1024.0d), valueOf((double) (freeMemory % 1024)));
            } else if ("step".equals(optjstring)) {
                System.gc();
                return LuaValue.TRUE;
            } else {
                argerror("gc op");
                return NIL;
            }
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$dofile.class */
    final class dofile extends VarArgFunction {
        private final BaseLib this$0;

        dofile(BaseLib baseLib) {
            this.this$0 = baseLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            varargs.argcheck(varargs.isstring(1) || varargs.isnil(1), 1, "filename must be string or nil");
            Varargs loadStream = (varargs.isstring(1) ? varargs.tojstring(1) : null) == null ? this.this$0.loadStream(this.this$0.globals.STDIN, "=stdin", "bt", this.this$0.globals) : this.this$0.loadFile(varargs.checkjstring(1), "bt", this.this$0.globals);
            return loadStream.isnil(1) ? error(loadStream.tojstring(2)) : loadStream.arg1().invoke();
        }
    }

    /* renamed from: org.luaj.vm2.lib.BaseLib$error */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$error.class */
    static final class C5860error extends TwoArgFunction {
        C5860error() {
        }

        @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
            if (luaValue.isnil()) {
                throw new LuaError(null, luaValue2.optint(1));
            }
            if (luaValue.isstring()) {
                throw new LuaError(luaValue.tojstring(), luaValue2.optint(1));
            }
            throw new LuaError(luaValue);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$getmetatable.class */
    static final class getmetatable extends LibFunction {
        getmetatable() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call() {
            return argerror(1, "value");
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            LuaValue luaValue2 = luaValue.getmetatable();
            return luaValue2 != null ? luaValue2.rawget(METATABLE).optvalue(luaValue2) : NIL;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$inext.class */
    static final class inext extends VarArgFunction {
        inext() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            return varargs.checktable(1).inext(varargs.arg(2));
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$ipairs.class */
    static final class ipairs extends VarArgFunction {
        inext inext = new inext();

        ipairs() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            return varargsOf(this.inext, varargs.checktable(1), ZERO);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$load.class */
    final class load extends VarArgFunction {
        private final BaseLib this$0;

        load(BaseLib baseLib) {
            this.this$0 = baseLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaValue arg1 = varargs.arg1();
            varargs.argcheck(arg1.isstring() || arg1.isfunction(), 1, "ld must be string or function");
            return this.this$0.loadStream(arg1.isstring() ? arg1.strvalue().toInputStream() : new StringInputStream(arg1.checkfunction()), varargs.optjstring(2, arg1.isstring() ? arg1.tojstring() : "=(load)"), varargs.optjstring(3, "bt"), varargs.optvalue(4, this.this$0.globals));
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$loadfile.class */
    final class loadfile extends VarArgFunction {
        private final BaseLib this$0;

        loadfile(BaseLib baseLib) {
            this.this$0 = baseLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            varargs.argcheck(varargs.isstring(1) || varargs.isnil(1), 1, "filename must be string or nil");
            String str = varargs.isstring(1) ? varargs.tojstring(1) : null;
            String optjstring = varargs.optjstring(2, "bt");
            LuaValue optvalue = varargs.optvalue(3, this.this$0.globals);
            return str == null ? this.this$0.loadStream(this.this$0.globals.STDIN, "=stdin", optjstring, optvalue) : this.this$0.loadFile(str, optjstring, optvalue);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$next.class */
    static final class next extends VarArgFunction {
        next() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            return varargs.checktable(1).next(varargs.arg(2));
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$pairs.class */
    static final class pairs extends VarArgFunction {
        final next next;

        pairs(next next) {
            this.next = next;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            return varargsOf(this.next, varargs.checktable(1), NIL);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$pcall.class */
    final class pcall extends VarArgFunction {
        private final BaseLib this$0;

        pcall(BaseLib baseLib) {
            this.this$0 = baseLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaValue checkvalue = varargs.checkvalue(1);
            if (!(this.this$0.globals == null || this.this$0.globals.debuglib == null)) {
                this.this$0.globals.debuglib.onCall(this);
            }
            try {
                try {
                    try {
                        Varargs varargsOf = varargsOf(TRUE, checkvalue.invoke(varargs.subargs(2)));
                        if (!(this.this$0.globals == null || this.this$0.globals.debuglib == null)) {
                            this.this$0.globals.debuglib.onReturn();
                        }
                        return varargsOf;
                    } catch (Exception e) {
                        String message = e.getMessage();
                        Varargs varargsOf2 = varargsOf(FALSE, valueOf(message != null ? message : e.toString()));
                        if (!(this.this$0.globals == null || this.this$0.globals.debuglib == null)) {
                            this.this$0.globals.debuglib.onReturn();
                        }
                        return varargsOf2;
                    }
                } catch (LuaError e2) {
                    LuaValue messageObject = e2.getMessageObject();
                    Varargs varargsOf3 = varargsOf(FALSE, messageObject != null ? messageObject : NIL);
                    if (!(this.this$0.globals == null || this.this$0.globals.debuglib == null)) {
                        this.this$0.globals.debuglib.onReturn();
                    }
                    return varargsOf3;
                }
            } catch (Throwable th) {
                if (!(this.this$0.globals == null || this.this$0.globals.debuglib == null)) {
                    this.this$0.globals.debuglib.onReturn();
                }
                throw th;
            }
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$print.class */
    final class print extends VarArgFunction {
        final BaseLib baselib;
        private final BaseLib this$0;

        print(BaseLib baseLib, BaseLib baseLib2) {
            this.this$0 = baseLib;
            this.baselib = baseLib2;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaValue luaValue = this.this$0.globals.get("tostring");
            int narg = varargs.narg();
            for (int i = 1; i <= narg; i++) {
                if (i > 1) {
                    this.this$0.globals.STDOUT.print('\t');
                }
                this.this$0.globals.STDOUT.print(luaValue.call(varargs.arg(i)).strvalue().tojstring());
            }
            this.this$0.globals.STDOUT.println();
            return NONE;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$rawequal.class */
    static final class rawequal extends LibFunction {
        rawequal() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call() {
            return argerror(1, "value");
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return argerror(2, "value");
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
            return valueOf(luaValue.raweq(luaValue2));
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$rawget.class */
    static final class rawget extends LibFunction {
        rawget() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call() {
            return argerror(1, "value");
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return argerror(2, "value");
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
            return luaValue.checktable().rawget(luaValue2);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$rawlen.class */
    static final class rawlen extends LibFunction {
        rawlen() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return valueOf(luaValue.rawlen());
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$rawset.class */
    static final class rawset extends LibFunction {
        rawset() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return argerror(2, "value");
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
            return argerror(3, "value");
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2, LuaValue luaValue3) {
            LuaTable checktable = luaValue.checktable();
            checktable.rawset(luaValue2.checknotnil(), luaValue3);
            return checktable;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$select.class */
    static final class select extends VarArgFunction {
        select() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            int narg = varargs.narg() - 1;
            if (varargs.arg1().equals(valueOf(LineReaderImpl.DEFAULT_COMMENT_BEGIN))) {
                return valueOf(narg);
            }
            int checkint = varargs.checkint(1);
            if (checkint == 0 || checkint < (-narg)) {
                argerror(1, "index out of range");
            }
            return varargs.subargs(checkint < 0 ? narg + checkint + 2 : checkint + 1);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$setmetatable.class */
    static final class setmetatable extends LibFunction {
        setmetatable() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return argerror(2, "value");
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
            LuaValue luaValue3 = luaValue.checktable().getmetatable();
            if (luaValue3 != null && !luaValue3.rawget(METATABLE).isnil()) {
                error("cannot change a protected metatable");
            }
            return luaValue.setmetatable(luaValue2.isnil() ? null : luaValue2.checktable());
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$tonumber.class */
    static final class tonumber extends LibFunction {
        tonumber() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return luaValue.tonumber();
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
            if (luaValue2.isnil()) {
                return luaValue.tonumber();
            }
            int checkint = luaValue2.checkint();
            if (checkint < 2 || checkint > 36) {
                argerror(2, "base out of range");
            }
            return luaValue.checkstring().tonumber(checkint);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$tostring.class */
    static final class tostring extends LibFunction {
        tostring() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            LuaValue metatag = luaValue.metatag(TOSTRING);
            if (!metatag.isnil()) {
                return metatag.call(luaValue);
            }
            LuaValue luaValue2 = luaValue.tostring();
            return !luaValue2.isnil() ? luaValue2 : valueOf(luaValue.tojstring());
        }
    }

    /* renamed from: org.luaj.vm2.lib.BaseLib$type */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$type.class */
    static final class C5861type extends LibFunction {
        C5861type() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return valueOf(luaValue.typename());
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/BaseLib$xpcall.class */
    final class xpcall extends VarArgFunction {
        private final BaseLib this$0;

        xpcall(BaseLib baseLib) {
            this.this$0 = baseLib;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:17:0x007e
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public org.luaj.vm2.Varargs invoke(org.luaj.vm2.Varargs r6) {
            /*
            // Method dump skipped, instructions count: 330
            */
            throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.lib.BaseLib.xpcall.invoke(org.luaj.vm2.Varargs):org.luaj.vm2.Varargs");
        }
    }

    @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        this.globals = luaValue2.checkglobals();
        this.globals.finder = this;
        this.globals.baselib = this;
        luaValue2.set("_G", luaValue2);
        luaValue2.set("_VERSION", Lua._VERSION);
        luaValue2.set("assert", new _assert());
        luaValue2.set("collectgarbage", new collectgarbage());
        luaValue2.set("dofile", new dofile(this));
        luaValue2.set("error", new C5860error());
        luaValue2.set("getmetatable", new getmetatable());
        luaValue2.set("load", new load(this));
        luaValue2.set("loadfile", new loadfile(this));
        luaValue2.set("pcall", new pcall(this));
        luaValue2.set("print", new print(this, this));
        luaValue2.set("rawequal", new rawequal());
        luaValue2.set("rawget", new rawget());
        luaValue2.set("rawlen", new rawlen());
        luaValue2.set("rawset", new rawset());
        luaValue2.set("select", new select());
        luaValue2.set("setmetatable", new setmetatable());
        luaValue2.set("tonumber", new tonumber());
        luaValue2.set("tostring", new tostring());
        luaValue2.set("type", new C5861type());
        luaValue2.set("xpcall", new xpcall(this));
        next next2 = new next();
        luaValue2.set(Tmux.CMD_NEXT, next2);
        luaValue2.set("pairs", new pairs(next2));
        luaValue2.set("ipairs", new ipairs());
        return luaValue2;
    }

    @Override // org.luaj.vm2.lib.ResourceFinder
    public InputStream findResource(String str) {
        return getClass().getResourceAsStream(str.startsWith("/") ? str : new StringBuffer().append("/").append(str).toString());
    }

    public Varargs loadFile(String str, String str2, LuaValue luaValue) {
        InputStream findResource = this.globals.finder.findResource(str);
        if (findResource == null) {
            return varargsOf(NIL, valueOf(new StringBuffer().append("cannot open ").append(str).append(": No such file or directory").toString()));
        }
        try {
            return loadStream(findResource, new StringBuffer().append("@").append(str).toString(), str2, luaValue);
        } finally {
            try {
                findResource.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Varargs loadStream(InputStream inputStream, String str, String str2, LuaValue luaValue) {
        try {
            return inputStream == null ? varargsOf(NIL, valueOf(new StringBuffer().append("not found: ").append(str).toString())) : this.globals.load(inputStream, str, str2, luaValue);
        } catch (Exception e) {
            return varargsOf(NIL, valueOf(e.getMessage()));
        }
    }
}
