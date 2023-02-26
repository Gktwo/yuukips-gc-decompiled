package org.luaj.vm2.script;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import javax.script.AbstractScriptEngine;
import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;
import javax.script.SimpleBindings;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaClosure;
import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.ThreeArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;

/* loaded from: grasscutter.jar:org/luaj/vm2/script/LuaScriptEngine.class */
public class LuaScriptEngine extends AbstractScriptEngine implements ScriptEngine, Compilable {
    private static final String __ENGINE_VERSION__ = "Luaj-jse 3.0.1";
    private static final String __NAME__ = "Luaj";
    private static final String __SHORT_NAME__ = "Luaj";
    private static final String __LANGUAGE__ = "lua";
    private static final String __LANGUAGE_VERSION__ = "5.2";
    private static final String __ARGV__ = "arg";
    private static final String __FILENAME__ = "?";
    private static final ScriptEngineFactory myFactory = new LuaScriptEngineFactory();
    private LuajContext context = new LuajContext();

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/script/LuaScriptEngine$BindingsMetatable.class */
    public static class BindingsMetatable extends LuaTable {
        BindingsMetatable(final Bindings bindings) {
            rawset(LuaValue.INDEX, new TwoArgFunction() { // from class: org.luaj.vm2.script.LuaScriptEngine.BindingsMetatable.1
                @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
                public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
                    return luaValue2.isstring() ? LuaScriptEngine.toLua(bindings.get(luaValue2.tojstring())) : rawget(luaValue2);
                }
            });
            rawset(LuaValue.NEWINDEX, new ThreeArgFunction() { // from class: org.luaj.vm2.script.LuaScriptEngine.BindingsMetatable.2
                @Override // org.luaj.vm2.lib.ThreeArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
                public LuaValue call(LuaValue luaValue, LuaValue luaValue2, LuaValue luaValue3) {
                    if (luaValue2.isstring()) {
                        String str = luaValue2.tojstring();
                        Object java = LuaScriptEngine.toJava(luaValue3);
                        if (java == null) {
                            bindings.remove(str);
                        } else {
                            bindings.put(str, java);
                        }
                    } else {
                        rawset(luaValue2, luaValue3);
                    }
                    return LuaValue.NONE;
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/script/LuaScriptEngine$LuajCompiledScript.class */
    public class LuajCompiledScript extends CompiledScript {
        final LuaFunction function;
        final Globals compiling_globals;

        LuajCompiledScript(LuaFunction luaFunction, Globals globals) {
            this.function = luaFunction;
            this.compiling_globals = globals;
        }

        public ScriptEngine getEngine() {
            return LuaScriptEngine.this;
        }

        public Object eval() throws ScriptException {
            return eval(LuaScriptEngine.this.getContext());
        }

        public Object eval(Bindings bindings) throws ScriptException {
            return eval(LuaScriptEngine.this.getContext().globals, bindings);
        }

        public Object eval(ScriptContext scriptContext) throws ScriptException {
            return eval(((LuajContext) scriptContext).globals, scriptContext.getBindings(100));
        }

        Object eval(Globals globals, Bindings bindings) throws ScriptException {
            LuaFunction luaFunction;
            globals.setmetatable(new BindingsMetatable(bindings));
            LuaFunction luaFunction2 = this.function;
            if (luaFunction2.isclosure()) {
                luaFunction = new LuaClosure(luaFunction2.checkclosure().f3251p, globals);
            } else {
                try {
                    luaFunction = (LuaFunction) luaFunction2.getClass().newInstance();
                    luaFunction.initupvalue1(globals);
                } catch (Exception e) {
                    throw new ScriptException(e);
                }
            }
            return LuaScriptEngine.toJava(luaFunction.invoke(LuaValue.NONE));
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/script/LuaScriptEngine$Utf8Encoder.class */
    public final class Utf8Encoder extends InputStream {

        /* renamed from: r */
        private final Reader f3323r;
        private final int[] buf;

        /* renamed from: n */
        private int f3324n;

        private Utf8Encoder(Reader reader) {
            this.buf = new int[2];
            this.f3323r = reader;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f3324n > 0) {
                int[] iArr = this.buf;
                int i = this.f3324n - 1;
                this.f3324n = i;
                return iArr[i];
            }
            int read = this.f3323r.read();
            if (read < 128) {
                return read;
            }
            this.f3324n = 0;
            if (read < 2048) {
                int[] iArr2 = this.buf;
                int i2 = this.f3324n;
                this.f3324n = i2 + 1;
                iArr2[i2] = 128 | (read & 63);
                return 192 | ((read >> 6) & 31);
            }
            int[] iArr3 = this.buf;
            int i3 = this.f3324n;
            this.f3324n = i3 + 1;
            iArr3[i3] = 128 | (read & 63);
            int[] iArr4 = this.buf;
            int i4 = this.f3324n;
            this.f3324n = i4 + 1;
            iArr4[i4] = 128 | ((read >> 6) & 63);
            return 224 | ((read >> 12) & 15);
        }
    }

    public LuaScriptEngine() {
        this.context.setBindings(createBindings(), 100);
        setContext(this.context);
        put("javax.script.language_version", __LANGUAGE_VERSION__);
        put("javax.script.language", __LANGUAGE__);
        put("javax.script.engine", "Luaj");
        put("javax.script.engine_version", "Luaj-jse 3.0.1");
        put("javax.script.argv", "arg");
        put("javax.script.filename", "?");
        put("javax.script.name", "Luaj");
        put("THREADING", null);
    }

    public CompiledScript compile(String str) throws ScriptException {
        return compile(new StringReader(str));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x0033
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public javax.script.CompiledScript compile(java.io.Reader r7) throws javax.script.ScriptException {
        /*
            r6 = this;
            org.luaj.vm2.script.LuaScriptEngine$Utf8Encoder r0 = new org.luaj.vm2.script.LuaScriptEngine$Utf8Encoder     // Catch: Exception -> 0x0049
            r1 = r0
            r2 = r6
            r3 = r7
            r4 = 0
            r1.<init>(r3)     // Catch: Exception -> 0x0049
            r8 = r0
            r0 = r6
            org.luaj.vm2.script.LuajContext r0 = r0.context     // Catch: Exception -> 0x0049, LuaError -> 0x0033, all -> 0x0040
            org.luaj.vm2.Globals r0 = r0.globals     // Catch: Exception -> 0x0049, LuaError -> 0x0033, all -> 0x0040
            r9 = r0
            r0 = r9
            r1 = r7
            java.lang.String r2 = "script"
            org.luaj.vm2.LuaValue r0 = r0.load(r1, r2)     // Catch: Exception -> 0x0049, LuaError -> 0x0033, all -> 0x0040
            org.luaj.vm2.LuaFunction r0 = r0.checkfunction()     // Catch: Exception -> 0x0049, LuaError -> 0x0033, all -> 0x0040
            r10 = r0
            org.luaj.vm2.script.LuaScriptEngine$LuajCompiledScript r0 = new org.luaj.vm2.script.LuaScriptEngine$LuajCompiledScript     // Catch: Exception -> 0x0049, LuaError -> 0x0033, all -> 0x0040
            r1 = r0
            r2 = r6
            r3 = r10
            r4 = r9
            r1.<init>(r3, r4)     // Catch: Exception -> 0x0049, LuaError -> 0x0033, all -> 0x0040
            r11 = r0
            r0 = r8
            r0.close()     // Catch: Exception -> 0x0049
            r0 = r11
            return r0
        L_0x0033:
            r9 = move-exception
            javax.script.ScriptException r0 = new javax.script.ScriptException     // Catch: all -> 0x0040, Exception -> 0x0049
            r1 = r0
            r2 = r9
            java.lang.String r2 = r2.getMessage()     // Catch: all -> 0x0040, Exception -> 0x0049
            r1.<init>(r2)     // Catch: all -> 0x0040, Exception -> 0x0049
            throw r0     // Catch: all -> 0x0040, Exception -> 0x0049
        L_0x0040:
            r12 = move-exception
            r0 = r8
            r0.close()     // Catch: Exception -> 0x0049
            r0 = r12
            throw r0     // Catch: Exception -> 0x0049
        L_0x0049:
            r8 = move-exception
            javax.script.ScriptException r0 = new javax.script.ScriptException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "eval threw "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r8
            java.lang.String r3 = r3.toString()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.script.LuaScriptEngine.compile(java.io.Reader):javax.script.CompiledScript");
    }

    public Object eval(Reader reader, Bindings bindings) throws ScriptException {
        return compile(reader).eval(this.context.globals, bindings);
    }

    public Object eval(String str, Bindings bindings) throws ScriptException {
        return eval(new StringReader(str), bindings);
    }

    protected ScriptContext getScriptContext(Bindings bindings) {
        throw new IllegalStateException("LuajScriptEngine should not be allocating contexts.");
    }

    public Bindings createBindings() {
        return new SimpleBindings();
    }

    public Object eval(String str, ScriptContext scriptContext) throws ScriptException {
        return eval(new StringReader(str), scriptContext);
    }

    public Object eval(Reader reader, ScriptContext scriptContext) throws ScriptException {
        return compile(reader).eval(scriptContext);
    }

    public ScriptEngineFactory getFactory() {
        return myFactory;
    }

    /* access modifiers changed from: private */
    public static LuaValue toLua(Object obj) {
        return obj == null ? LuaValue.NIL : obj instanceof LuaValue ? (LuaValue) obj : CoerceJavaToLua.coerce(obj);
    }

    /* access modifiers changed from: private */
    public static Object toJava(LuaValue luaValue) {
        switch (luaValue.type()) {
            case 0:
                return null;
            case 1:
            case 2:
            case 5:
            case 6:
            default:
                return luaValue;
            case 3:
                return luaValue.isinttype() ? new Integer(luaValue.toint()) : new Double(luaValue.todouble());
            case 4:
                return luaValue.tojstring();
            case 7:
                return luaValue.checkuserdata(Object.class);
        }
    }

    /* access modifiers changed from: private */
    public static Object toJava(Varargs varargs) {
        int narg = varargs.narg();
        switch (narg) {
            case 0:
                return null;
            case 1:
                return toJava(varargs.arg1());
            default:
                Object[] objArr = new Object[narg];
                for (int i = 0; i < narg; i++) {
                    objArr[i] = toJava(varargs.arg(i + 1));
                }
                return objArr;
        }
    }
}
