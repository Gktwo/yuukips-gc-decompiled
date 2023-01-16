package org.luaj.vm2.lib;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaThread;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/CoroutineLib.class */
public class CoroutineLib extends TwoArgFunction {
    static int coroutine_count = 0;
    Globals globals;

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/CoroutineLib$create.class */
    final class create extends LibFunction {
        private final CoroutineLib this$0;

        create(CoroutineLib coroutineLib) {
            this.this$0 = coroutineLib;
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return new LuaThread(this.this$0.globals, luaValue.checkfunction());
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/CoroutineLib$resume.class */
    final class resume extends VarArgFunction {
        private final CoroutineLib this$0;

        resume(CoroutineLib coroutineLib) {
            this.this$0 = coroutineLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            return varargs.checkthread(1).resume(varargs.subargs(2));
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/CoroutineLib$running.class */
    final class running extends VarArgFunction {
        private final CoroutineLib this$0;

        running(CoroutineLib coroutineLib) {
            this.this$0 = coroutineLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaThread luaThread = this.this$0.globals.running;
            return varargsOf(luaThread, valueOf(luaThread.isMainThread()));
        }
    }

    /* renamed from: org.luaj.vm2.lib.CoroutineLib$status */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/CoroutineLib$status.class */
    static final class C5870status extends LibFunction {
        C5870status() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return valueOf(luaValue.checkthread().getStatus());
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/CoroutineLib$wrap.class */
    final class wrap extends LibFunction {
        private final CoroutineLib this$0;

        wrap(CoroutineLib coroutineLib) {
            this.this$0 = coroutineLib;
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return new wrapper(this.this$0, new LuaThread(this.this$0.globals, luaValue.checkfunction()));
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/CoroutineLib$wrapper.class */
    final class wrapper extends VarArgFunction {
        final LuaThread luathread;
        private final CoroutineLib this$0;

        wrapper(CoroutineLib coroutineLib, LuaThread luaThread) {
            this.this$0 = coroutineLib;
            this.luathread = luaThread;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            Varargs resume = this.luathread.resume(varargs);
            return resume.arg1().toboolean() ? resume.subargs(2) : error(resume.arg(2).tojstring());
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/CoroutineLib$yield.class */
    final class yield extends VarArgFunction {
        private final CoroutineLib this$0;

        yield(CoroutineLib coroutineLib) {
            this.this$0 = coroutineLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            return this.this$0.globals.yield(varargs);
        }
    }

    @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        this.globals = luaValue2.checkglobals();
        LuaTable luaTable = new LuaTable();
        luaTable.set("create", new create(this));
        luaTable.set("resume", new resume(this));
        luaTable.set("running", new running(this));
        luaTable.set("status", new C5870status());
        luaTable.set("yield", new yield(this));
        luaTable.set("wrap", new wrap(this));
        luaValue2.set("coroutine", luaTable);
        luaValue2.get("package").get("loaded").set("coroutine", luaTable);
        return luaTable;
    }
}
