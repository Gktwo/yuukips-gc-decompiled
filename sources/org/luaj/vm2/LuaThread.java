package org.luaj.vm2;

import java.lang.ref.WeakReference;

/* loaded from: grasscutter.jar:org/luaj/vm2/LuaThread.class */
public class LuaThread extends LuaValue {
    public static LuaValue s_metatable;
    public static final int STATUS_INITIAL = 0;
    public static final int STATUS_SUSPENDED = 1;
    public static final int STATUS_RUNNING = 2;
    public static final int STATUS_NORMAL = 3;
    public static final int STATUS_DEAD = 4;
    public final State state;
    public static final int MAX_CALLSTACK = 256;
    public Object callstack;
    public final Globals globals;
    public LuaValue errorfunc;
    public static int coroutine_count = 0;
    public static long thread_orphan_check_interval = 5000;
    public static final String[] STATUS_NAMES = {"suspended", "suspended", "running", "normal", "dead"};

    /* loaded from: grasscutter.jar:org/luaj/vm2/LuaThread$State.class */
    public static class State implements Runnable {
        private final Globals globals;
        final WeakReference lua_thread;
        public final LuaValue function;
        public LuaValue hookfunc;
        public boolean hookline;
        public boolean hookcall;
        public boolean hookrtrn;
        public int hookcount;
        public boolean inhook;
        public int lastline;
        public int bytecodes;
        Varargs args = LuaValue.NONE;
        Varargs result = LuaValue.NONE;
        String error = null;
        public int status = 0;

        State(Globals globals, LuaThread luaThread, LuaValue luaValue) {
            this.globals = globals;
            this.lua_thread = new WeakReference(luaThread);
            this.function = luaValue;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            try {
                Varargs varargs = this.args;
                this.args = LuaValue.NONE;
                this.result = this.function.invoke(varargs);
                this.status = 4;
                notify();
            } catch (Throwable th) {
                this.status = 4;
                notify();
                throw th;
            }
        }

        public synchronized Varargs lua_resume(LuaThread luaThread, Varargs varargs) {
            LuaThread luaThread2;
            try {
                luaThread2 = this.globals.running;
                try {
                    this.globals.running = luaThread;
                    this.args = varargs;
                    if (this.status == 0) {
                        this.status = 2;
                        StringBuffer append = new StringBuffer().append("Coroutine-");
                        int i = LuaThread.coroutine_count + 1;
                        LuaThread.coroutine_count = i;
                        new Thread(this, append.append(i).toString()).start();
                    } else {
                        notify();
                    }
                    if (luaThread2 != null) {
                        luaThread2.state.status = 3;
                    }
                    this.status = 2;
                    wait();
                    return this.error != null ? LuaValue.varargsOf(LuaValue.FALSE, LuaValue.valueOf(this.error)) : LuaValue.varargsOf(LuaValue.TRUE, this.result);
                } catch (InterruptedException e) {
                    throw new OrphanedThread();
                }
            } finally {
                this.args = LuaValue.NONE;
                this.result = LuaValue.NONE;
                this.error = null;
                this.globals.running = luaThread2;
                if (luaThread2 != null) {
                    this.globals.running.state.status = 2;
                }
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Try blocks wrapping queue limit reached! Please report as an issue!
            	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.connectExcHandlers(BlockExceptionHandler.java:88)
            	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.process(BlockExceptionHandler.java:58)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.independentBlockTreeMod(BlockProcessor.java:452)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:51)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        public synchronized org.luaj.vm2.Varargs lua_yield(org.luaj.vm2.Varargs r5) {
            /*
                r4 = this;
                r0 = r4
                r1 = r5
                r0.result = r1     // Catch: InterruptedException -> 0x0049, all -> 0x0057
                r0 = r4
                r1 = 1
                r0.status = r1     // Catch: InterruptedException -> 0x0049, all -> 0x0057
                r0 = r4
                r0.notify()     // Catch: InterruptedException -> 0x0049, all -> 0x0057
            L_0x000e:
                r0 = r4
                long r1 = org.luaj.vm2.LuaThread.thread_orphan_check_interval     // Catch: InterruptedException -> 0x0049, all -> 0x0057
                r0.wait(r1)     // Catch: InterruptedException -> 0x0049, all -> 0x0057
                r0 = r4
                java.lang.ref.WeakReference r0 = r0.lua_thread     // Catch: InterruptedException -> 0x0049, all -> 0x0057
                java.lang.Object r0 = r0.get()     // Catch: InterruptedException -> 0x0049, all -> 0x0057
                if (r0 != 0) goto L_0x002c
                r0 = r4
                r1 = 4
                r0.status = r1     // Catch: InterruptedException -> 0x0049, all -> 0x0057
                org.luaj.vm2.OrphanedThread r0 = new org.luaj.vm2.OrphanedThread     // Catch: InterruptedException -> 0x0049, all -> 0x0057
                r1 = r0
                r1.<init>()     // Catch: InterruptedException -> 0x0049, all -> 0x0057
                throw r0     // Catch: InterruptedException -> 0x0049, all -> 0x0057
            L_0x002c:
                r0 = r4
                int r0 = r0.status     // Catch: InterruptedException -> 0x0049, all -> 0x0057
                r1 = 1
                if (r0 == r1) goto L_0x000e
                r0 = r4
                org.luaj.vm2.Varargs r0 = r0.args     // Catch: InterruptedException -> 0x0049, all -> 0x0057
                r6 = r0
                r0 = r4
                org.luaj.vm2.LuaValue r1 = org.luaj.vm2.LuaValue.NONE
                r0.args = r1
                r0 = r4
                org.luaj.vm2.LuaValue r1 = org.luaj.vm2.LuaValue.NONE
                r0.result = r1
                r0 = r6
                return r0
            L_0x0049:
                r6 = move-exception
                r0 = r4
                r1 = 4
                r0.status = r1     // Catch: all -> 0x0057
                org.luaj.vm2.OrphanedThread r0 = new org.luaj.vm2.OrphanedThread     // Catch: all -> 0x0057
                r1 = r0
                r1.<init>()     // Catch: all -> 0x0057
                throw r0     // Catch: all -> 0x0057
            L_0x0057:
                r7 = move-exception
                r0 = r4
                org.luaj.vm2.LuaValue r1 = org.luaj.vm2.LuaValue.NONE
                r0.args = r1
                r0 = r4
                org.luaj.vm2.LuaValue r1 = org.luaj.vm2.LuaValue.NONE
                r0.result = r1
                r0 = r7
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.LuaThread.State.lua_yield(org.luaj.vm2.Varargs):org.luaj.vm2.Varargs");
        }
    }

    public LuaThread(Globals globals) {
        this.state = new State(globals, this, null);
        this.state.status = 2;
        this.globals = globals;
    }

    public LuaThread(Globals globals, LuaValue luaValue) {
        LuaValue.assert_(luaValue != null, "function cannot be null");
        this.state = new State(globals, this, luaValue);
        this.globals = globals;
    }

    @Override // org.luaj.vm2.LuaValue
    public int type() {
        return 8;
    }

    @Override // org.luaj.vm2.LuaValue
    public String typename() {
        return "thread";
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isthread() {
        return true;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaThread optthread(LuaThread luaThread) {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaThread checkthread() {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue getmetatable() {
        return s_metatable;
    }

    public String getStatus() {
        return STATUS_NAMES[this.state.status];
    }

    public boolean isMainThread() {
        return this.state.function == null;
    }

    public Varargs resume(Varargs varargs) {
        State state = this.state;
        if (state.status <= 1) {
            return state.lua_resume(this, varargs);
        }
        return LuaValue.varargsOf(LuaValue.FALSE, LuaValue.valueOf(new StringBuffer().append("cannot resume ").append(state.status == 4 ? "dead" : "non-suspended").append(" coroutine").toString()));
    }
}
