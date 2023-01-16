package org.luaj.vm2.lib;

import dev.morphia.mapping.Mapper;
import java.io.IOException;
import java.io.InputStream;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaBoolean;
import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/PackageLib.class */
public class PackageLib extends TwoArgFunction {
    public static String DEFAULT_LUA_PATH;
    private static final LuaString _LOADED;
    private static final LuaString _LOADLIB;
    private static final LuaString _PRELOAD;
    private static final LuaString _PATH;
    private static final LuaString _SEARCHPATH;
    private static final LuaString _SEARCHERS;
    Globals globals;
    LuaTable package_;
    public preload_searcher preload_searcher;
    public lua_searcher lua_searcher;
    public java_searcher java_searcher;
    private static final LuaString _SENTINEL;
    private static final String FILE_SEP;

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/PackageLib$java_searcher.class */
    public class java_searcher extends VarArgFunction {
        private final PackageLib this$0;

        public java_searcher(PackageLib packageLib) {
            this.this$0 = packageLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            String classname = PackageLib.toClassname(varargs.checkjstring(1));
            try {
                LuaValue luaValue = (LuaValue) Class.forName(classname).newInstance();
                if (luaValue.isfunction()) {
                    ((LuaFunction) luaValue).initupvalue1(this.this$0.globals);
                }
                return varargsOf(luaValue, this.this$0.globals);
            } catch (ClassNotFoundException e) {
                return valueOf(new StringBuffer().append("\n\tno class '").append(classname).append("'").toString());
            } catch (Exception e2) {
                return valueOf(new StringBuffer().append("\n\tjava load failed on '").append(classname).append("', ").append(e2).toString());
            }
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/PackageLib$loadlib.class */
    public static class loadlib extends VarArgFunction {
        public Varargs loadlib(Varargs varargs) {
            varargs.checkstring(1);
            return varargsOf(NIL, valueOf("dynamic libraries not enabled"), valueOf("absent"));
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/PackageLib$lua_searcher.class */
    public class lua_searcher extends VarArgFunction {
        private final PackageLib this$0;

        public lua_searcher(PackageLib packageLib) {
            this.this$0 = packageLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaString checkstring = varargs.checkstring(1);
            LuaValue luaValue = this.this$0.package_.get(PackageLib.access$400());
            if (!luaValue.isstring()) {
                return valueOf("package.path is not a string");
            }
            Varargs invoke = this.this$0.package_.get(PackageLib.access$500()).invoke(varargsOf(checkstring, luaValue));
            if (!invoke.isstring(1)) {
                return invoke.arg(2).tostring();
            }
            LuaString strvalue = invoke.arg1().strvalue();
            LuaValue loadfile = this.this$0.globals.loadfile(strvalue.tojstring());
            return loadfile.arg1().isfunction() ? LuaValue.varargsOf(loadfile.arg1(), strvalue) : varargsOf(NIL, valueOf(new StringBuffer().append("'").append(strvalue).append("': ").append(loadfile.arg(2).tojstring()).toString()));
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/PackageLib$preload_searcher.class */
    public class preload_searcher extends VarArgFunction {
        private final PackageLib this$0;

        public preload_searcher(PackageLib packageLib) {
            this.this$0 = packageLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaString checkstring = varargs.checkstring(1);
            LuaValue luaValue = this.this$0.package_.get(PackageLib.access$300()).get(checkstring);
            return luaValue.isnil() ? valueOf(new StringBuffer().append("\n\tno field package.preload['").append(checkstring).append("']").toString()) : luaValue;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/PackageLib$require.class */
    public class require extends OneArgFunction {
        private final PackageLib this$0;

        public require(PackageLib packageLib) {
            this.this$0 = packageLib;
        }

        @Override // org.luaj.vm2.lib.OneArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            Varargs invoke;
            LuaString checkstring = luaValue.checkstring();
            LuaValue luaValue2 = this.this$0.package_.get(PackageLib.access$000());
            LuaValue luaValue3 = luaValue2.get(checkstring);
            if (luaValue3.toboolean()) {
                if (luaValue3 == PackageLib.access$100()) {
                    error(new StringBuffer().append("loop or previous error loading module '").append(checkstring).append("'").toString());
                }
                return luaValue3;
            }
            LuaTable checktable = this.this$0.package_.get(PackageLib.access$200()).checktable();
            StringBuffer stringBuffer = new StringBuffer();
            int i = 1;
            while (true) {
                LuaValue luaValue4 = checktable.get(i);
                if (luaValue4.isnil()) {
                    error(new StringBuffer().append("module '").append(checkstring).append("' not found: ").append(checkstring).append((Object) stringBuffer).toString());
                }
                invoke = luaValue4.invoke(checkstring);
                if (invoke.isfunction(1)) {
                    break;
                }
                if (invoke.isstring(1)) {
                    stringBuffer.append(invoke.tojstring(1));
                }
                i++;
            }
            luaValue2.set(checkstring, PackageLib.access$100());
            LuaValue call = invoke.arg1().call(checkstring, invoke.arg(2));
            if (!call.isnil()) {
                luaValue2.set(checkstring, call);
            } else {
                LuaValue luaValue5 = luaValue2.get(checkstring);
                call = luaValue5;
                if (luaValue5 == PackageLib.access$100()) {
                    LuaBoolean luaBoolean = LuaValue.TRUE;
                    call = luaBoolean;
                    luaValue2.set(checkstring, luaBoolean);
                }
            }
            return call;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/PackageLib$searchpath.class */
    public class searchpath extends VarArgFunction {
        private final PackageLib this$0;

        public searchpath(PackageLib packageLib) {
            this.this$0 = packageLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            String checkjstring = varargs.checkjstring(1);
            String checkjstring2 = varargs.checkjstring(2);
            String optjstring = varargs.optjstring(3, Mapper.IGNORED_FIELDNAME);
            String optjstring2 = varargs.optjstring(4, PackageLib.access$600());
            int i = -1;
            int length = checkjstring2.length();
            StringBuffer stringBuffer = null;
            String replace = checkjstring.replace(optjstring.charAt(0), optjstring2.charAt(0));
            while (i < length) {
                int i2 = i + 1;
                i = checkjstring2.indexOf(59, i2);
                if (i < 0) {
                    i = checkjstring2.length();
                }
                String substring = checkjstring2.substring(i2, i);
                int indexOf = substring.indexOf(63);
                String str = substring;
                if (indexOf >= 0) {
                    str = new StringBuffer().append(substring.substring(0, indexOf)).append(replace).append(substring.substring(indexOf + 1)).toString();
                }
                InputStream findResource = this.this$0.globals.finder.findResource(str);
                if (findResource != null) {
                    try {
                        findResource.close();
                    } catch (IOException e) {
                    }
                    return valueOf(str);
                }
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer();
                }
                stringBuffer.append(new StringBuffer().append("\n\t").append(str).toString());
            }
            return varargsOf(NIL, valueOf(stringBuffer.toString()));
        }
    }

    @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        this.globals = luaValue2.checkglobals();
        this.globals.set("require", new require(this));
        this.package_ = new LuaTable();
        this.package_.set(_LOADED, new LuaTable());
        this.package_.set(_PRELOAD, new LuaTable());
        this.package_.set(_PATH, LuaValue.valueOf(DEFAULT_LUA_PATH));
        this.package_.set(_LOADLIB, new loadlib());
        this.package_.set(_SEARCHPATH, new searchpath(this));
        LuaTable luaTable = new LuaTable();
        preload_searcher preload_searcher2 = new preload_searcher(this);
        this.preload_searcher = preload_searcher2;
        luaTable.set(1, preload_searcher2);
        lua_searcher lua_searcher2 = new lua_searcher(this);
        this.lua_searcher = lua_searcher2;
        luaTable.set(2, lua_searcher2);
        java_searcher java_searcher2 = new java_searcher(this);
        this.java_searcher = java_searcher2;
        luaTable.set(3, java_searcher2);
        this.package_.set(_SEARCHERS, luaTable);
        this.package_.get(_LOADED).set("package", this.package_);
        luaValue2.set("package", this.package_);
        this.globals.package_ = this;
        return luaValue2;
    }

    public void setIsLoaded(String str, LuaTable luaTable) {
        this.package_.get(_LOADED).set(str, luaTable);
    }

    public void setLuaPath(String str) {
        this.package_.set(_PATH, LuaValue.valueOf(str));
    }

    @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaFunction, org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
    public String tojstring() {
        return "package";
    }

    public static final String toClassname(String str) {
        int length = str.length();
        int i = length;
        if (str.endsWith(".lua")) {
            i -= 4;
        }
        for (int i2 = 0; i2 < i; i2++) {
            char charAt = str.charAt(i2);
            if (!isClassnamePart(charAt) || charAt == '/' || charAt == '\\') {
                StringBuffer stringBuffer = new StringBuffer(i);
                for (int i3 = 0; i3 < i; i3++) {
                    char charAt2 = str.charAt(i3);
                    stringBuffer.append(isClassnamePart(charAt2) ? charAt2 : (charAt2 == '/' || charAt2 == '\\') ? '.' : '_');
                }
                return stringBuffer.toString();
            }
        }
        return length == i ? str : str.substring(0, i);
    }

    private static final boolean isClassnamePart(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        if (c >= '0' && c <= '9') {
            return true;
        }
        switch (c) {
            case '$':
            case '.':
            case '_':
                return true;
            default:
                return false;
        }
    }

    static LuaString access$000() {
        return _LOADED;
    }

    static LuaString access$100() {
        return _SENTINEL;
    }

    static LuaString access$200() {
        return _SEARCHERS;
    }

    static LuaString access$300() {
        return _PRELOAD;
    }

    static LuaString access$400() {
        return _PATH;
    }

    static LuaString access$500() {
        return _SEARCHPATH;
    }

    static String access$600() {
        return FILE_SEP;
    }

    static {
        try {
            DEFAULT_LUA_PATH = System.getProperty("luaj.package.path");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        if (DEFAULT_LUA_PATH == null) {
            DEFAULT_LUA_PATH = "?.lua";
        }
        _LOADED = valueOf("loaded");
        _LOADLIB = valueOf("loadlib");
        _PRELOAD = valueOf("preload");
        _PATH = valueOf("path");
        _SEARCHPATH = valueOf("searchpath");
        _SEARCHERS = valueOf("searchers");
        _SENTINEL = valueOf("\u0001");
        FILE_SEP = System.getProperty("file.separator");
    }
}
