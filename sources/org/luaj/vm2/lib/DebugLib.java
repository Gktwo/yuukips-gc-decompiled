package org.luaj.vm2.lib;

import dev.morphia.mapping.Mapper;
import org.jline.reader.LineReader;
import org.luaj.vm2.Globals;
import org.luaj.vm2.Lua;
import org.luaj.vm2.LuaBoolean;
import org.luaj.vm2.LuaClosure;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaNil;
import org.luaj.vm2.LuaNumber;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaThread;
import org.luaj.vm2.LuaUserdata;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Print;
import org.luaj.vm2.Prototype;
import org.luaj.vm2.Varargs;
import org.quartz.jobs.p027ee.ejb.EJBInvokerJob;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/DebugLib.class */
public class DebugLib extends TwoArgFunction {
    public static boolean CALLS;
    public static boolean TRACE;
    private static final LuaString LUA;
    private static final LuaString QMARK;
    private static final LuaString CALL;
    private static final LuaString LINE;
    private static final LuaString COUNT;
    private static final LuaString RETURN;
    private static final LuaString FUNC;
    private static final LuaString ISTAILCALL;
    private static final LuaString ISVARARG;
    private static final LuaString NUPS;
    private static final LuaString NPARAMS;
    private static final LuaString NAME;
    private static final LuaString NAMEWHAT;
    private static final LuaString WHAT;
    private static final LuaString SOURCE;
    private static final LuaString SHORT_SRC;
    private static final LuaString LINEDEFINED;
    private static final LuaString LASTLINEDEFINED;
    private static final LuaString CURRENTLINE;
    private static final LuaString ACTIVELINES;
    Globals globals;

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/DebugLib$CallFrame.class */
    public static class CallFrame {

        /* renamed from: f */
        LuaFunction f3298f;

        /* renamed from: pc */
        int f3299pc;
        int top;

        /* renamed from: v */
        Varargs f3300v;
        LuaValue[] stack;
        CallFrame previous;

        CallFrame() {
        }

        void set(LuaClosure luaClosure, Varargs varargs, LuaValue[] luaValueArr) {
            this.f3298f = luaClosure;
            this.f3300v = varargs;
            this.stack = luaValueArr;
        }

        public String shortsource() {
            return this.f3298f.isclosure() ? this.f3298f.checkclosure().f3251p.shortsource() : "[Java]";
        }

        void set(LuaFunction luaFunction) {
            this.f3298f = luaFunction;
        }

        void reset() {
            this.f3298f = null;
            this.f3300v = null;
            this.stack = null;
        }

        void instr(int i, Varargs varargs, int i2) {
            this.f3299pc = i;
            this.f3300v = varargs;
            this.top = i2;
            if (DebugLib.TRACE) {
                Print.printState(this.f3298f.checkclosure(), i, this.stack, i2, varargs);
            }
        }

        Varargs getLocal(int i) {
            LuaString luaString = getlocalname(i);
            return luaString != null ? LuaValue.varargsOf(luaString, this.stack[i - 1]) : LuaValue.NIL;
        }

        Varargs setLocal(int i, LuaValue luaValue) {
            LuaString luaString = getlocalname(i);
            if (luaString == null) {
                return LuaValue.NIL;
            }
            this.stack[i - 1] = luaValue;
            return luaString;
        }

        int currentline() {
            int[] iArr;
            if (this.f3298f.isclosure() && (iArr = this.f3298f.checkclosure().f3251p.lineinfo) != null && this.f3299pc >= 0 && this.f3299pc < iArr.length) {
                return iArr[this.f3299pc];
            }
            return -1;
        }

        String sourceline() {
            return !this.f3298f.isclosure() ? this.f3298f.tojstring() : new StringBuffer().append(this.f3298f.checkclosure().f3251p.shortsource()).append(EmitterKt.COMMENT_PREFIX).append(currentline()).toString();
        }

        private int linedefined() {
            if (this.f3298f.isclosure()) {
                return this.f3298f.checkclosure().f3251p.linedefined;
            }
            return -1;
        }

        LuaString getlocalname(int i) {
            if (!this.f3298f.isclosure()) {
                return null;
            }
            return this.f3298f.checkclosure().f3251p.getlocalname(i, this.f3299pc);
        }

        static int access$1500(CallFrame callFrame) {
            return callFrame.linedefined();
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/DebugLib$CallStack.class */
    public static class CallStack {
        static final CallFrame[] EMPTY = new CallFrame[0];
        CallFrame[] frame = EMPTY;
        int calls = 0;

        CallStack() {
        }

        synchronized int currentline() {
            if (this.calls > 0) {
                return this.frame[this.calls - 1].currentline();
            }
            return -1;
        }

        private synchronized CallFrame pushcall() {
            if (this.calls >= this.frame.length) {
                int max = Math.max(4, (this.frame.length * 3) / 2);
                CallFrame[] callFrameArr = new CallFrame[max];
                System.arraycopy(this.frame, 0, callFrameArr, 0, this.frame.length);
                for (int length = this.frame.length; length < max; length++) {
                    callFrameArr[length] = new CallFrame();
                }
                this.frame = callFrameArr;
                for (int i = 1; i < max; i++) {
                    callFrameArr[i].previous = callFrameArr[i - 1];
                }
            }
            CallFrame[] callFrameArr2 = this.frame;
            int i2 = this.calls;
            this.calls = i2 + 1;
            return callFrameArr2[i2];
        }

        final synchronized void onCall(LuaFunction luaFunction) {
            pushcall().set(luaFunction);
        }

        final synchronized void onCall(LuaClosure luaClosure, Varargs varargs, LuaValue[] luaValueArr) {
            pushcall().set(luaClosure, varargs, luaValueArr);
        }

        final synchronized void onReturn() {
            if (this.calls > 0) {
                CallFrame[] callFrameArr = this.frame;
                int i = this.calls - 1;
                this.calls = i;
                callFrameArr[i].reset();
            }
        }

        final synchronized void onInstruction(int i, Varargs varargs, int i2) {
            if (this.calls > 0) {
                this.frame[this.calls - 1].instr(i, varargs, i2);
            }
        }

        synchronized String traceback(int i) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("stack traceback:");
            while (true) {
                i++;
                CallFrame callFrame = getCallFrame(i);
                if (callFrame != null) {
                    stringBuffer.append("\n\t");
                    stringBuffer.append(callFrame.shortsource());
                    stringBuffer.append(':');
                    if (callFrame.currentline() > 0) {
                        stringBuffer.append(new StringBuffer().append(callFrame.currentline()).append(EmitterKt.COMMENT_PREFIX).toString());
                    }
                    stringBuffer.append(" in ");
                    DebugInfo auxgetinfo = auxgetinfo("n", callFrame.f3298f, callFrame);
                    if (CallFrame.access$1500(callFrame) == 0) {
                        stringBuffer.append("main chunk");
                    } else if (auxgetinfo.name != null) {
                        stringBuffer.append("function '");
                        stringBuffer.append(auxgetinfo.name);
                        stringBuffer.append('\'');
                    } else {
                        stringBuffer.append(new StringBuffer().append("function <").append(callFrame.shortsource()).append(EmitterKt.COMMENT_PREFIX).append(CallFrame.access$1500(callFrame)).append(">").toString());
                    }
                } else {
                    stringBuffer.append("\n\t[Java]: in ?");
                    return stringBuffer.toString();
                }
            }
        }

        synchronized CallFrame getCallFrame(int i) {
            if (i < 1 || i > this.calls) {
                return null;
            }
            return this.frame[this.calls - i];
        }

        synchronized CallFrame findCallFrame(LuaValue luaValue) {
            for (int i = 1; i <= this.calls; i++) {
                if (this.frame[this.calls - i].f3298f == luaValue) {
                    return this.frame[i];
                }
            }
            return null;
        }

        synchronized DebugInfo auxgetinfo(String str, LuaFunction luaFunction, CallFrame callFrame) {
            NameWhat nameWhat;
            DebugInfo debugInfo = new DebugInfo();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                switch (str.charAt(i)) {
                    case 'S':
                        debugInfo.funcinfo(luaFunction);
                        break;
                    case 'l':
                        debugInfo.currentline = (callFrame == null || !callFrame.f3298f.isclosure()) ? -1 : callFrame.currentline();
                        break;
                    case 'n':
                        if (!(callFrame == null || callFrame.previous == null || !callFrame.previous.f3298f.isclosure() || (nameWhat = DebugLib.getfuncname(callFrame.previous)) == null)) {
                            debugInfo.name = nameWhat.name;
                            debugInfo.namewhat = nameWhat.namewhat;
                        }
                        if (debugInfo.namewhat == null) {
                            debugInfo.namewhat = "";
                            debugInfo.name = null;
                            break;
                        } else {
                            break;
                        }
                        break;
                    case 't':
                        debugInfo.istailcall = false;
                        break;
                    case 'u':
                        if (luaFunction == null || !luaFunction.isclosure()) {
                            debugInfo.nups = 0;
                            debugInfo.isvararg = true;
                            debugInfo.nparams = 0;
                            break;
                        } else {
                            Prototype prototype = luaFunction.checkclosure().f3251p;
                            debugInfo.nups = (short) prototype.upvalues.length;
                            debugInfo.nparams = (short) prototype.numparams;
                            debugInfo.isvararg = prototype.is_vararg != 0;
                            break;
                        }
                        break;
                }
            }
            return debugInfo;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/DebugLib$DebugInfo.class */
    public static class DebugInfo {
        String name;
        String namewhat;
        String what;
        String source;
        int currentline;
        int linedefined;
        int lastlinedefined;
        short nups;
        short nparams;
        boolean isvararg;
        boolean istailcall;
        String short_src;

        /* renamed from: cf */
        CallFrame f3301cf;

        DebugInfo() {
        }

        public void funcinfo(LuaFunction luaFunction) {
            if (luaFunction.isclosure()) {
                Prototype prototype = luaFunction.checkclosure().f3251p;
                this.source = prototype.source != null ? prototype.source.tojstring() : "=?";
                this.linedefined = prototype.linedefined;
                this.lastlinedefined = prototype.lastlinedefined;
                this.what = this.linedefined == 0 ? LineReader.MAIN : "Lua";
                this.short_src = prototype.shortsource();
                return;
            }
            this.source = "=[Java]";
            this.linedefined = -1;
            this.lastlinedefined = -1;
            this.what = "Java";
            this.short_src = luaFunction.name();
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/DebugLib$NameWhat.class */
    public static class NameWhat {
        final String name;
        final String namewhat;

        NameWhat(String str, String str2) {
            this.name = str;
            this.namewhat = str2;
        }
    }

    /* renamed from: org.luaj.vm2.lib.DebugLib$debug */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/DebugLib$debug.class */
    static final class C5863debug extends ZeroArgFunction {
        C5863debug() {
        }

        @Override // org.luaj.vm2.lib.ZeroArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call() {
            return NONE;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/DebugLib$gethook.class */
    final class gethook extends VarArgFunction {
        private final DebugLib this$0;

        gethook(DebugLib debugLib) {
            this.this$0 = debugLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaThread.State state = (varargs.narg() > 0 ? varargs.checkthread(1) : this.this$0.globals.running).state;
            return varargsOf(state.hookfunc != null ? state.hookfunc : NIL, valueOf(new StringBuffer().append(state.hookcall ? "c" : "").append(state.hookline ? "l" : "").append(state.hookrtrn ? "r" : "").toString()), valueOf(state.hookcount));
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/DebugLib$getinfo.class */
    final class getinfo extends VarArgFunction {
        private final DebugLib this$0;

        getinfo(DebugLib debugLib) {
            this.this$0 = debugLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaThread luaThread;
            CallFrame callFrame;
            int i = 1;
            if (varargs.isthread(1)) {
                i = 1 + 1;
                luaThread = varargs.checkthread(1);
            } else {
                luaThread = this.this$0.globals.running;
            }
            int i2 = i + 1;
            LuaValue arg = varargs.arg(i);
            int i3 = i2 + 1;
            String optjstring = varargs.optjstring(i2, "flnStu");
            CallStack callstack = this.this$0.callstack(luaThread);
            if (arg.isnumber()) {
                callFrame = callstack.getCallFrame(arg.toint());
                if (callFrame == null) {
                    return NONE;
                }
                arg = callFrame.f3298f;
            } else if (!arg.isfunction()) {
                return argerror(i3 - 2, "function or level");
            } else {
                callFrame = callstack.findCallFrame(arg);
            }
            DebugInfo auxgetinfo = callstack.auxgetinfo(optjstring, (LuaFunction) arg, callFrame);
            LuaTable luaTable = new LuaTable();
            if (optjstring.indexOf(83) >= 0) {
                luaTable.set(DebugLib.access$000(), DebugLib.access$100());
                luaTable.set(DebugLib.access$200(), valueOf(auxgetinfo.source));
                luaTable.set(DebugLib.access$300(), valueOf(auxgetinfo.short_src));
                luaTable.set(DebugLib.access$400(), valueOf(auxgetinfo.linedefined));
                luaTable.set(DebugLib.access$500(), valueOf(auxgetinfo.lastlinedefined));
            }
            if (optjstring.indexOf(108) >= 0) {
                luaTable.set(DebugLib.access$600(), valueOf(auxgetinfo.currentline));
            }
            if (optjstring.indexOf(117) >= 0) {
                luaTable.set(DebugLib.access$700(), valueOf((int) auxgetinfo.nups));
                luaTable.set(DebugLib.access$800(), valueOf((int) auxgetinfo.nparams));
                luaTable.set(DebugLib.access$900(), auxgetinfo.isvararg ? ONE : ZERO);
            }
            if (optjstring.indexOf(110) >= 0) {
                luaTable.set(DebugLib.access$1000(), LuaValue.valueOf(auxgetinfo.name != null ? auxgetinfo.name : "?"));
                luaTable.set(DebugLib.access$1100(), LuaValue.valueOf(auxgetinfo.namewhat));
            }
            if (optjstring.indexOf(116) >= 0) {
                luaTable.set(DebugLib.access$1200(), ZERO);
            }
            if (optjstring.indexOf(76) >= 0) {
                LuaTable luaTable2 = new LuaTable();
                luaTable.set(DebugLib.access$1300(), luaTable2);
                int i4 = 1;
                while (true) {
                    CallFrame callFrame2 = callstack.getCallFrame(i4);
                    if (callFrame2 == null) {
                        break;
                    }
                    if (callFrame2.f3298f == arg) {
                        luaTable2.insert(-1, valueOf(callFrame2.currentline()));
                    }
                    i4++;
                }
            }
            if (optjstring.indexOf(102) >= 0 && arg != null) {
                luaTable.set(DebugLib.access$1400(), arg);
            }
            return luaTable;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/DebugLib$getlocal.class */
    final class getlocal extends VarArgFunction {
        private final DebugLib this$0;

        getlocal(DebugLib debugLib) {
            this.this$0 = debugLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaThread luaThread;
            int i = 1;
            if (varargs.isthread(1)) {
                i = 1 + 1;
                luaThread = varargs.checkthread(1);
            } else {
                luaThread = this.this$0.globals.running;
            }
            int i2 = i + 1;
            int checkint = varargs.checkint(i);
            int i3 = i2 + 1;
            int checkint2 = varargs.checkint(i2);
            CallFrame callFrame = this.this$0.callstack(luaThread).getCallFrame(checkint);
            return callFrame != null ? callFrame.getLocal(checkint2) : NONE;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/DebugLib$getmetatable.class */
    final class getmetatable extends LibFunction {
        private final DebugLib this$0;

        getmetatable(DebugLib debugLib) {
            this.this$0 = debugLib;
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            LuaValue luaValue2 = luaValue.getmetatable();
            return luaValue2 != null ? luaValue2 : NIL;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/DebugLib$getregistry.class */
    final class getregistry extends ZeroArgFunction {
        private final DebugLib this$0;

        getregistry(DebugLib debugLib) {
            this.this$0 = debugLib;
        }

        @Override // org.luaj.vm2.lib.ZeroArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call() {
            return this.this$0.globals;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/DebugLib$getupvalue.class */
    static final class getupvalue extends VarArgFunction {
        getupvalue() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaClosure luaClosure;
            LuaString findupvalue;
            LuaFunction checkfunction = varargs.checkfunction(1);
            int checkint = varargs.checkint(2);
            return (!(checkfunction instanceof LuaClosure) || (findupvalue = DebugLib.findupvalue((luaClosure = (LuaClosure) checkfunction), checkint)) == null) ? NIL : varargsOf(findupvalue, luaClosure.upValues[checkint - 1].getValue());
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/DebugLib$getuservalue.class */
    static final class getuservalue extends LibFunction {
        getuservalue() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return luaValue.isuserdata() ? luaValue : NIL;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/DebugLib$sethook.class */
    final class sethook extends VarArgFunction {
        private final DebugLib this$0;

        sethook(DebugLib debugLib) {
            this.this$0 = debugLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaThread luaThread;
            int i = 1;
            if (varargs.isthread(1)) {
                i = 1 + 1;
                luaThread = varargs.checkthread(1);
            } else {
                luaThread = this.this$0.globals.running;
            }
            int i2 = i + 1;
            LuaFunction optfunction = varargs.optfunction(i, null);
            int i3 = i2 + 1;
            String optjstring = varargs.optjstring(i2, "");
            int i4 = i3 + 1;
            int optint = varargs.optint(i3, 0);
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (int i5 = 0; i5 < optjstring.length(); i5++) {
                switch (optjstring.charAt(i5)) {
                    case 'c':
                        z = true;
                        break;
                    case 'l':
                        z2 = true;
                        break;
                    case 'r':
                        z3 = true;
                        break;
                }
            }
            LuaThread.State state = luaThread.state;
            state.hookfunc = optfunction;
            state.hookcall = z;
            state.hookline = z2;
            state.hookcount = optint;
            state.hookrtrn = z3;
            return NONE;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/DebugLib$setlocal.class */
    final class setlocal extends VarArgFunction {
        private final DebugLib this$0;

        setlocal(DebugLib debugLib) {
            this.this$0 = debugLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaThread luaThread;
            int i = 1;
            if (varargs.isthread(1)) {
                i = 1 + 1;
                luaThread = varargs.checkthread(1);
            } else {
                luaThread = this.this$0.globals.running;
            }
            int i2 = i + 1;
            int checkint = varargs.checkint(i);
            int i3 = i2 + 1;
            int checkint2 = varargs.checkint(i2);
            int i4 = i3 + 1;
            LuaValue arg = varargs.arg(i3);
            CallFrame callFrame = this.this$0.callstack(luaThread).getCallFrame(checkint);
            return callFrame != null ? callFrame.setLocal(checkint2, arg) : NONE;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/DebugLib$setmetatable.class */
    final class setmetatable extends TwoArgFunction {
        private final DebugLib this$0;

        setmetatable(DebugLib debugLib) {
            this.this$0 = debugLib;
        }

        @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
            LuaTable opttable = luaValue2.opttable(null);
            switch (luaValue.type()) {
                case 0:
                    LuaNil.s_metatable = opttable;
                    break;
                case 1:
                    LuaBoolean.s_metatable = opttable;
                    break;
                case 2:
                case 5:
                case 7:
                default:
                    luaValue.setmetatable(opttable);
                    break;
                case 3:
                    LuaNumber.s_metatable = opttable;
                    break;
                case 4:
                    LuaString.s_metatable = opttable;
                    break;
                case 6:
                    LuaFunction.s_metatable = opttable;
                    break;
                case 8:
                    LuaThread.s_metatable = opttable;
                    break;
            }
            return luaValue;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/DebugLib$setupvalue.class */
    final class setupvalue extends VarArgFunction {
        private final DebugLib this$0;

        setupvalue(DebugLib debugLib) {
            this.this$0 = debugLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaClosure luaClosure;
            LuaString findupvalue;
            LuaFunction checkfunction = varargs.checkfunction(1);
            int checkint = varargs.checkint(2);
            LuaValue arg = varargs.arg(3);
            if (!(checkfunction instanceof LuaClosure) || (findupvalue = DebugLib.findupvalue((luaClosure = (LuaClosure) checkfunction), checkint)) == null) {
                return NIL;
            }
            luaClosure.upValues[checkint - 1].setValue(arg);
            return findupvalue;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/DebugLib$setuservalue.class */
    final class setuservalue extends VarArgFunction {
        private final DebugLib this$0;

        setuservalue(DebugLib debugLib) {
            this.this$0 = debugLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            varargs.checkuserdata(1);
            LuaValue checkvalue = varargs.checkvalue(2);
            LuaUserdata luaUserdata = (LuaUserdata) varargs.arg1();
            luaUserdata.m_instance = checkvalue.checkuserdata();
            luaUserdata.m_metatable = checkvalue.getmetatable();
            return NONE;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/DebugLib$traceback.class */
    final class traceback extends VarArgFunction {
        private final DebugLib this$0;

        traceback(DebugLib debugLib) {
            this.this$0 = debugLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaThread luaThread;
            int i = 1;
            if (varargs.isthread(1)) {
                i = 1 + 1;
                luaThread = varargs.checkthread(1);
            } else {
                luaThread = this.this$0.globals.running;
            }
            int i2 = i + 1;
            String optjstring = varargs.optjstring(i, null);
            int i3 = i2 + 1;
            String traceback = this.this$0.callstack(luaThread).traceback(varargs.optint(i2, 1));
            return valueOf(optjstring != null ? new StringBuffer().append(optjstring).append("\n").append(traceback).toString() : traceback);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/DebugLib$upvalueid.class */
    final class upvalueid extends VarArgFunction {
        private final DebugLib this$0;

        upvalueid(DebugLib debugLib) {
            this.this$0 = debugLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaFunction checkfunction = varargs.checkfunction(1);
            int checkint = varargs.checkint(2);
            if (checkfunction instanceof LuaClosure) {
                LuaClosure luaClosure = (LuaClosure) checkfunction;
                if (luaClosure.upValues != null && checkint > 0 && checkint <= luaClosure.upValues.length) {
                    return valueOf(luaClosure.upValues[checkint - 1].hashCode());
                }
            }
            return NIL;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/DebugLib$upvaluejoin.class */
    final class upvaluejoin extends VarArgFunction {
        private final DebugLib this$0;

        upvaluejoin(DebugLib debugLib) {
            this.this$0 = debugLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaClosure checkclosure = varargs.checkclosure(1);
            int checkint = varargs.checkint(2);
            LuaClosure checkclosure2 = varargs.checkclosure(3);
            int checkint2 = varargs.checkint(4);
            if (checkint < 1 || checkint > checkclosure.upValues.length) {
                argerror("index out of range");
            }
            if (checkint2 < 1 || checkint2 > checkclosure2.upValues.length) {
                argerror("index out of range");
            }
            checkclosure.upValues[checkint - 1] = checkclosure2.upValues[checkint2 - 1];
            return NONE;
        }
    }

    @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        this.globals = luaValue2.checkglobals();
        this.globals.debuglib = this;
        LuaTable luaTable = new LuaTable();
        luaTable.set("debug", new C5863debug());
        luaTable.set("gethook", new gethook(this));
        luaTable.set("getinfo", new getinfo(this));
        luaTable.set("getlocal", new getlocal(this));
        luaTable.set("getmetatable", new getmetatable(this));
        luaTable.set("getregistry", new getregistry(this));
        luaTable.set("getupvalue", new getupvalue());
        luaTable.set("getuservalue", new getuservalue());
        luaTable.set("sethook", new sethook(this));
        luaTable.set("setlocal", new setlocal(this));
        luaTable.set("setmetatable", new setmetatable(this));
        luaTable.set("setupvalue", new setupvalue(this));
        luaTable.set("setuservalue", new setuservalue(this));
        luaTable.set("traceback", new traceback(this));
        luaTable.set("upvalueid", new upvalueid(this));
        luaTable.set("upvaluejoin", new upvaluejoin(this));
        luaValue2.set("debug", luaTable);
        luaValue2.get("package").get("loaded").set("debug", luaTable);
        return luaTable;
    }

    public void onCall(LuaFunction luaFunction) {
        LuaThread.State state = this.globals.running.state;
        if (!state.inhook) {
            callstack().onCall(luaFunction);
            if (state.hookcall) {
                callHook(state, CALL, NIL);
            }
        }
    }

    public void onCall(LuaClosure luaClosure, Varargs varargs, LuaValue[] luaValueArr) {
        LuaThread.State state = this.globals.running.state;
        if (!state.inhook) {
            callstack().onCall(luaClosure, varargs, luaValueArr);
            if (state.hookcall) {
                callHook(state, CALL, NIL);
            }
        }
    }

    public void onInstruction(int i, Varargs varargs, int i2) {
        int currentline;
        LuaThread.State state = this.globals.running.state;
        if (!state.inhook) {
            callstack().onInstruction(i, varargs, i2);
            if (state.hookfunc != null) {
                if (state.hookcount > 0) {
                    int i3 = state.bytecodes + 1;
                    state.bytecodes = i3;
                    if (i3 % state.hookcount == 0) {
                        callHook(state, COUNT, NIL);
                    }
                }
                if (state.hookline && (currentline = callstack().currentline()) != state.lastline) {
                    state.lastline = currentline;
                    callHook(state, LINE, LuaValue.valueOf(currentline));
                }
            }
        }
    }

    public void onReturn() {
        LuaThread.State state = this.globals.running.state;
        if (!state.inhook) {
            callstack().onReturn();
            if (state.hookrtrn) {
                callHook(state, RETURN, NIL);
            }
        }
    }

    public String traceback(int i) {
        return callstack().traceback(i);
    }

    void callHook(LuaThread.State state, LuaValue luaValue, LuaValue luaValue2) {
        if (!state.inhook && state.hookfunc != null) {
            try {
                state.inhook = true;
                try {
                    state.hookfunc.call(luaValue, luaValue2);
                    state.inhook = false;
                } catch (LuaError e) {
                    throw e;
                } catch (RuntimeException e2) {
                    throw new LuaError(e2);
                }
            } catch (Throwable th) {
                state.inhook = false;
                throw th;
            }
        }
    }

    CallStack callstack() {
        return callstack(this.globals.running);
    }

    CallStack callstack(LuaThread luaThread) {
        if (luaThread.callstack == null) {
            luaThread.callstack = new CallStack();
        }
        return (CallStack) luaThread.callstack;
    }

    static LuaString findupvalue(LuaClosure luaClosure, int i) {
        if (luaClosure.upValues == null || i <= 0 || i > luaClosure.upValues.length) {
            return null;
        }
        return (luaClosure.f3251p.upvalues == null || i > luaClosure.f3251p.upvalues.length) ? LuaString.valueOf(new StringBuffer().append(Mapper.IGNORED_FIELDNAME).append(i).toString()) : luaClosure.f3251p.upvalues[i - 1].name;
    }

    static void lua_assert(boolean z) {
        if (!z) {
            throw new RuntimeException("lua_assert failed");
        }
    }

    static NameWhat getfuncname(CallFrame callFrame) {
        LuaString luaString;
        if (!callFrame.f3298f.isclosure()) {
            return new NameWhat(callFrame.f3298f.classnamestub(), "Java");
        }
        Prototype prototype = callFrame.f3298f.checkclosure().f3251p;
        int i = callFrame.f3299pc;
        int i2 = prototype.code[i];
        switch (Lua.GET_OPCODE(i2)) {
            case 6:
            case 7:
            case 12:
                luaString = LuaValue.INDEX;
                break;
            case 8:
            case 10:
                luaString = LuaValue.NEWINDEX;
                break;
            case 9:
            case 11:
            case 20:
            case 23:
            case 27:
            case 28:
            case 31:
            case 32:
            case 33:
            default:
                return null;
            case 13:
                luaString = LuaValue.ADD;
                break;
            case 14:
                luaString = LuaValue.SUB;
                break;
            case 15:
                luaString = LuaValue.MUL;
                break;
            case 16:
                luaString = LuaValue.DIV;
                break;
            case 17:
                luaString = LuaValue.MOD;
                break;
            case 18:
                luaString = LuaValue.POW;
                break;
            case 19:
                luaString = LuaValue.UNM;
                break;
            case 21:
                luaString = LuaValue.LEN;
                break;
            case 22:
                luaString = LuaValue.CONCAT;
                break;
            case 24:
                luaString = LuaValue.f3255EQ;
                break;
            case 25:
                luaString = LuaValue.f3256LT;
                break;
            case 26:
                luaString = LuaValue.f3257LE;
                break;
            case 29:
            case 30:
                return getobjname(prototype, i, Lua.GETARG_A(i2));
            case 34:
                return new NameWhat("(for iterator)", "(for iterator");
        }
        return new NameWhat(luaString.tojstring(), "metamethod");
    }

    public static NameWhat getobjname(Prototype prototype, int i, int i2) {
        LuaString luaString = prototype.getlocalname(i2 + 1, i);
        if (luaString != null) {
            return new NameWhat(luaString.tojstring(), "local");
        }
        int findsetreg = findsetreg(prototype, i, i2);
        if (findsetreg == -1) {
            return null;
        }
        int i3 = prototype.code[findsetreg];
        switch (Lua.GET_OPCODE(i3)) {
            case 0:
                int GETARG_A = Lua.GETARG_A(i3);
                int GETARG_B = Lua.GETARG_B(i3);
                if (GETARG_B < GETARG_A) {
                    return getobjname(prototype, findsetreg, GETARG_B);
                }
                return null;
            case 1:
            case 2:
                int GETARG_Bx = Lua.GET_OPCODE(i3) == 1 ? Lua.GETARG_Bx(i3) : Lua.GETARG_Ax(prototype.code[findsetreg + 1]);
                if (prototype.f3259k[GETARG_Bx].isstring()) {
                    return new NameWhat(prototype.f3259k[GETARG_Bx].strvalue().tojstring(), "constant");
                }
                return null;
            case 3:
            case 4:
            case 8:
            case 9:
            case 10:
            case 11:
            default:
                return null;
            case 5:
                int GETARG_B2 = Lua.GETARG_B(i3);
                return new NameWhat((GETARG_B2 < prototype.upvalues.length ? prototype.upvalues[GETARG_B2].name : QMARK).tojstring(), "upvalue");
            case 6:
            case 7:
                int GETARG_C = Lua.GETARG_C(i3);
                int GETARG_B3 = Lua.GETARG_B(i3);
                LuaString luaString2 = Lua.GET_OPCODE(i3) == 7 ? prototype.getlocalname(GETARG_B3 + 1, findsetreg) : GETARG_B3 < prototype.upvalues.length ? prototype.upvalues[GETARG_B3].name : QMARK;
                return new NameWhat(kname(prototype, GETARG_C).tojstring(), (luaString2 == null || !luaString2.eq_b(ENV)) ? "field" : "global");
            case 12:
                return new NameWhat(kname(prototype, Lua.GETARG_C(i3)).tojstring(), EJBInvokerJob.EJB_METHOD_KEY);
        }
    }

    static LuaString kname(Prototype prototype, int i) {
        return (!Lua.ISK(i) || !prototype.f3259k[Lua.INDEXK(i)].isstring()) ? QMARK : prototype.f3259k[Lua.INDEXK(i)].strvalue();
    }

    static int findsetreg(Prototype prototype, int i, int i2) {
        int i3 = -1;
        int i4 = 0;
        while (i4 < i) {
            int i5 = prototype.code[i4];
            int GET_OPCODE = Lua.GET_OPCODE(i5);
            int GETARG_A = Lua.GETARG_A(i5);
            switch (GET_OPCODE) {
                case 4:
                    int GETARG_B = Lua.GETARG_B(i5);
                    if (GETARG_A <= i2 && i2 <= GETARG_A + GETARG_B) {
                        i3 = i4;
                        break;
                    }
                    break;
                case 23:
                    int GETARG_sBx = Lua.GETARG_sBx(i5);
                    int i6 = i4 + 1 + GETARG_sBx;
                    if (i4 < i6 && i6 <= i) {
                        i4 += GETARG_sBx;
                        break;
                    }
                    break;
                case 27:
                    if (i2 != GETARG_A) {
                        break;
                    } else {
                        i3 = i4;
                        break;
                    }
                case 29:
                case 30:
                    if (i2 < GETARG_A) {
                        break;
                    } else {
                        i3 = i4;
                        break;
                    }
                case 34:
                    if (i2 < GETARG_A + 2) {
                        break;
                    } else {
                        i3 = i4;
                        break;
                    }
                default:
                    if (Lua.testAMode(GET_OPCODE) && i2 == GETARG_A) {
                        i3 = i4;
                        break;
                    }
                    break;
            }
            i4++;
        }
        return i3;
    }

    static LuaString access$000() {
        return WHAT;
    }

    static LuaString access$100() {
        return LUA;
    }

    static LuaString access$200() {
        return SOURCE;
    }

    static LuaString access$300() {
        return SHORT_SRC;
    }

    static LuaString access$400() {
        return LINEDEFINED;
    }

    static LuaString access$500() {
        return LASTLINEDEFINED;
    }

    static LuaString access$600() {
        return CURRENTLINE;
    }

    static LuaString access$700() {
        return NUPS;
    }

    static LuaString access$800() {
        return NPARAMS;
    }

    static LuaString access$900() {
        return ISVARARG;
    }

    static LuaString access$1000() {
        return NAME;
    }

    static LuaString access$1100() {
        return NAMEWHAT;
    }

    static LuaString access$1200() {
        return ISTAILCALL;
    }

    static LuaString access$1300() {
        return ACTIVELINES;
    }

    static LuaString access$1400() {
        return FUNC;
    }

    static {
        try {
            CALLS = null != System.getProperty("CALLS");
        } catch (Exception e) {
        }
        try {
            TRACE = null != System.getProperty("TRACE");
        } catch (Exception e2) {
        }
        LUA = valueOf("Lua");
        QMARK = valueOf("?");
        CALL = valueOf("call");
        LINE = valueOf("line");
        COUNT = valueOf("count");
        RETURN = valueOf("return");
        FUNC = valueOf("func");
        ISTAILCALL = valueOf("istailcall");
        ISVARARG = valueOf("isvararg");
        NUPS = valueOf("nups");
        NPARAMS = valueOf("nparams");
        NAME = valueOf("name");
        NAMEWHAT = valueOf("namewhat");
        WHAT = valueOf("what");
        SOURCE = valueOf("source");
        SHORT_SRC = valueOf("short_src");
        LINEDEFINED = valueOf("linedefined");
        LASTLINEDEFINED = valueOf("lastlinedefined");
        CURRENTLINE = valueOf("currentline");
        ACTIVELINES = valueOf("activelines");
    }
}
