package org.luaj.vm2.compiler;

import java.util.Hashtable;
import org.luaj.vm2.LocVars;
import org.luaj.vm2.Lua;
import org.luaj.vm2.LuaDouble;
import org.luaj.vm2.LuaInteger;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Prototype;
import org.luaj.vm2.Upvaldesc;
import org.luaj.vm2.compiler.LexState;
import org.luaj.vm2.compiler.LuaC;

/* loaded from: grasscutter.jar:org/luaj/vm2/compiler/FuncState.class */
public class FuncState extends Constants {

    /* renamed from: f */
    Prototype f3271f;

    /* renamed from: h */
    Hashtable f3272h;
    FuncState prev;

    /* renamed from: ls */
    LexState f3273ls;

    /* renamed from: L */
    LuaC.CompileState f3274L;

    /* renamed from: bl */
    BlockCnt f3275bl;

    /* renamed from: pc */
    int f3276pc;
    int lasttarget;
    IntPtr jpc;

    /* renamed from: nk */
    int f3277nk;

    /* renamed from: np */
    int f3278np;
    int firstlocal;
    short nlocvars;
    short nactvar;
    short nups;
    short freereg;

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/compiler/FuncState$BlockCnt.class */
    public static class BlockCnt {
        BlockCnt previous;
        short firstlabel;
        short firstgoto;
        short nactvar;
        boolean upval;
        boolean isloop;
    }

    /* access modifiers changed from: package-private */
    public InstructionPtr getcodePtr(LexState.expdesc expdesc) {
        return new InstructionPtr(this.f3271f.code, expdesc.f3295u.info);
    }

    /* access modifiers changed from: package-private */
    public int getcode(LexState.expdesc expdesc) {
        return this.f3271f.code[expdesc.f3295u.info];
    }

    /* access modifiers changed from: package-private */
    public int codeAsBx(int i, int i2, int i3) {
        return codeABx(i, i2, i3 + Lua.MAXARG_sBx);
    }

    /* access modifiers changed from: package-private */
    public void setmultret(LexState.expdesc expdesc) {
        setreturns(expdesc, -1);
    }

    /* access modifiers changed from: package-private */
    public void checkrepeated(LexState.Labeldesc[] labeldescArr, int i, LuaString luaString) {
        for (int i2 = this.f3275bl.firstlabel; i2 < i; i2++) {
            if (luaString.eq_b(labeldescArr[i2].name)) {
                this.f3273ls.semerror(this.f3273ls.f3283L.pushfstring(new StringBuffer().append("label '").append(luaString).append(" already defined on line ").append(labeldescArr[i2].line).toString()));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void checklimit(int i, int i2, String str) {
        if (i > i2) {
            errorlimit(i2, str);
        }
    }

    void errorlimit(int i, String str) {
        this.f3273ls.lexerror(this.f3271f.linedefined == 0 ? this.f3274L.pushfstring(new StringBuffer().append("main function has more than ").append(i).append(" ").append(str).toString()) : this.f3274L.pushfstring(new StringBuffer().append("function at line ").append(this.f3271f.linedefined).append(" has more than ").append(i).append(" ").append(str).toString()), 0);
    }

    /* access modifiers changed from: package-private */
    public LocVars getlocvar(int i) {
        short s = this.f3273ls.dyd.actvar[this.firstlocal + i].idx;
        _assert(s < this.nlocvars);
        return this.f3271f.locvars[s];
    }

    void removevars(int i) {
        this.f3273ls.dyd.n_actvar -= this.nactvar - i;
        while (this.nactvar > i) {
            short s = (short) (this.nactvar - 1);
            this.nactvar = s;
            getlocvar(s).endpc = this.f3276pc;
        }
    }

    int searchupvalue(LuaString luaString) {
        Upvaldesc[] upvaldescArr = this.f3271f.upvalues;
        for (int i = 0; i < this.nups; i++) {
            if (upvaldescArr[i].name.eq_b(luaString)) {
                return i;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int newupvalue(LuaString luaString, LexState.expdesc expdesc) {
        checklimit(this.nups + 1, 255, "upvalues");
        if (this.f3271f.upvalues == null || this.nups + 1 > this.f3271f.upvalues.length) {
            this.f3271f.upvalues = realloc(this.f3271f.upvalues, this.nups > 0 ? this.nups * 2 : 1);
        }
        this.f3271f.upvalues[this.nups] = new Upvaldesc(luaString, expdesc.f3294k == 7, expdesc.f3295u.info);
        short s = this.nups;
        this.nups = (short) (s + 1);
        return s;
    }

    int searchvar(LuaString luaString) {
        for (int i = this.nactvar - 1; i >= 0; i--) {
            if (luaString.eq_b(getlocvar(i).varname)) {
                return i;
            }
        }
        return -1;
    }

    void markupval(int i) {
        BlockCnt blockCnt = this.f3275bl;
        while (blockCnt.nactvar > i) {
            blockCnt = blockCnt.previous;
        }
        blockCnt.upval = true;
    }

    /* access modifiers changed from: package-private */
    public static int singlevaraux(FuncState funcState, LuaString luaString, LexState.expdesc expdesc, int i) {
        if (funcState == null) {
            return 0;
        }
        int searchvar = funcState.searchvar(luaString);
        if (searchvar >= 0) {
            expdesc.init(7, searchvar);
            if (i != 0) {
                return 7;
            }
            funcState.markupval(searchvar);
            return 7;
        }
        int searchupvalue = funcState.searchupvalue(luaString);
        if (searchupvalue < 0) {
            if (singlevaraux(funcState.prev, luaString, expdesc, 0) == 0) {
                return 0;
            }
            searchupvalue = funcState.newupvalue(luaString, expdesc);
        }
        expdesc.init(8, searchupvalue);
        return 8;
    }

    void movegotosout(BlockCnt blockCnt) {
        int i = blockCnt.firstgoto;
        LexState.Labeldesc[] labeldescArr = this.f3273ls.dyd.f3289gt;
        while (i < this.f3273ls.dyd.n_gt) {
            LexState.Labeldesc labeldesc = labeldescArr[i];
            if (labeldesc.nactvar > blockCnt.nactvar) {
                if (blockCnt.upval) {
                    patchclose(labeldesc.f3291pc, blockCnt.nactvar);
                }
                labeldesc.nactvar = blockCnt.nactvar;
            }
            if (!this.f3273ls.findlabel(i)) {
                i++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void enterblock(BlockCnt blockCnt, boolean z) {
        blockCnt.isloop = z;
        blockCnt.nactvar = this.nactvar;
        blockCnt.firstlabel = (short) this.f3273ls.dyd.n_label;
        blockCnt.firstgoto = (short) this.f3273ls.dyd.n_gt;
        blockCnt.upval = false;
        blockCnt.previous = this.f3275bl;
        this.f3275bl = blockCnt;
        _assert(this.freereg == this.nactvar);
    }

    /* access modifiers changed from: package-private */
    public void leaveblock() {
        BlockCnt blockCnt = this.f3275bl;
        if (blockCnt.previous != null && blockCnt.upval) {
            int jump = jump();
            patchclose(jump, blockCnt.nactvar);
            patchtohere(jump);
        }
        if (blockCnt.isloop) {
            this.f3273ls.breaklabel();
        }
        this.f3275bl = blockCnt.previous;
        removevars(blockCnt.nactvar);
        _assert(blockCnt.nactvar == this.nactvar);
        this.freereg = this.nactvar;
        this.f3273ls.dyd.n_label = blockCnt.firstlabel;
        if (blockCnt.previous != null) {
            movegotosout(blockCnt);
        } else if (blockCnt.firstgoto < this.f3273ls.dyd.n_gt) {
            this.f3273ls.undefgoto(this.f3273ls.dyd.f3289gt[blockCnt.firstgoto]);
        }
    }

    /* access modifiers changed from: package-private */
    public void closelistfield(LexState.ConsControl consControl) {
        if (consControl.f3285v.f3294k != 0) {
            exp2nextreg(consControl.f3285v);
            consControl.f3285v.f3294k = 0;
            if (consControl.tostore == 50) {
                setlist(consControl.f3286t.f3295u.info, consControl.f3288na, consControl.tostore);
                consControl.tostore = 0;
            }
        }
    }

    boolean hasmultret(int i) {
        return i == 12 || i == 13;
    }

    /* access modifiers changed from: package-private */
    public void lastlistfield(LexState.ConsControl consControl) {
        if (consControl.tostore != 0) {
            if (hasmultret(consControl.f3285v.f3294k)) {
                setmultret(consControl.f3285v);
                setlist(consControl.f3286t.f3295u.info, consControl.f3288na, -1);
                consControl.f3288na--;
                return;
            }
            if (consControl.f3285v.f3294k != 0) {
                exp2nextreg(consControl.f3285v);
            }
            setlist(consControl.f3286t.f3295u.info, consControl.f3288na, consControl.tostore);
        }
    }

    /* access modifiers changed from: package-private */
    public void nil(int i, int i2) {
        int i3 = (i + i2) - 1;
        if (this.f3276pc > this.lasttarget && this.f3276pc > 0) {
            int i4 = this.f3271f.code[this.f3276pc - 1];
            if (GET_OPCODE(i4) == 4) {
                int GETARG_A = GETARG_A(i4);
                int GETARG_B = GETARG_A + GETARG_B(i4);
                if ((GETARG_A <= i && i <= GETARG_B + 1) || (i <= GETARG_A && GETARG_A <= i3 + 1)) {
                    if (GETARG_A < i) {
                        i = GETARG_A;
                    }
                    if (GETARG_B > i3) {
                        i3 = GETARG_B;
                    }
                    InstructionPtr instructionPtr = new InstructionPtr(this.f3271f.code, this.f3276pc - 1);
                    SETARG_A(instructionPtr, i);
                    SETARG_B(instructionPtr, i3 - i);
                    return;
                }
            }
        }
        codeABC(4, i, i2 - 1, 0);
    }

    /* access modifiers changed from: package-private */
    public int jump() {
        int i = this.jpc.f3279i;
        this.jpc.f3279i = -1;
        IntPtr intPtr = new IntPtr(codeAsBx(23, 0, -1));
        concat(intPtr, i);
        return intPtr.f3279i;
    }

    /* access modifiers changed from: package-private */
    public void ret(int i, int i2) {
        codeABC(31, i, i2 + 1, 0);
    }

    int condjump(int i, int i2, int i3, int i4) {
        codeABC(i, i2, i3, i4);
        return jump();
    }

    void fixjump(int i, int i2) {
        InstructionPtr instructionPtr = new InstructionPtr(this.f3271f.code, i);
        int i3 = i2 - (i + 1);
        _assert(i2 != -1);
        if (Math.abs(i3) > 131071) {
            this.f3273ls.syntaxerror("control structure too long");
        }
        SETARG_sBx(instructionPtr, i3);
    }

    /* access modifiers changed from: package-private */
    public int getlabel() {
        this.lasttarget = this.f3276pc;
        return this.f3276pc;
    }

    int getjump(int i) {
        int GETARG_sBx = GETARG_sBx(this.f3271f.code[i]);
        if (GETARG_sBx == -1) {
            return -1;
        }
        return i + 1 + GETARG_sBx;
    }

    InstructionPtr getjumpcontrol(int i) {
        InstructionPtr instructionPtr = new InstructionPtr(this.f3271f.code, i);
        return (i < 1 || !testTMode(GET_OPCODE(instructionPtr.code[instructionPtr.idx - 1]))) ? instructionPtr : new InstructionPtr(instructionPtr.code, instructionPtr.idx - 1);
    }

    boolean need_value(int i) {
        while (i != -1) {
            if (GET_OPCODE(getjumpcontrol(i).get()) != 28) {
                return true;
            }
            i = getjump(i);
        }
        return false;
    }

    boolean patchtestreg(int i, int i2) {
        InstructionPtr instructionPtr = getjumpcontrol(i);
        if (GET_OPCODE(instructionPtr.get()) != 28) {
            return false;
        }
        if (i2 == 255 || i2 == GETARG_B(instructionPtr.get())) {
            instructionPtr.set(CREATE_ABC(27, GETARG_B(instructionPtr.get()), 0, Lua.GETARG_C(instructionPtr.get())));
            return true;
        }
        SETARG_A(instructionPtr, i2);
        return true;
    }

    void removevalues(int i) {
        while (i != -1) {
            patchtestreg(i, 255);
            i = getjump(i);
        }
    }

    void patchlistaux(int i, int i2, int i3, int i4) {
        while (i != -1) {
            i = getjump(i);
            if (patchtestreg(i, i3)) {
                fixjump(i, i2);
            } else {
                fixjump(i, i4);
            }
        }
    }

    void dischargejpc() {
        patchlistaux(this.jpc.f3279i, this.f3276pc, 255, this.f3276pc);
        this.jpc.f3279i = -1;
    }

    /* access modifiers changed from: package-private */
    public void patchlist(int i, int i2) {
        if (i2 == this.f3276pc) {
            patchtohere(i);
            return;
        }
        _assert(i2 < this.f3276pc);
        patchlistaux(i, i2, 255, i2);
    }

    /* access modifiers changed from: package-private */
    public void patchclose(int i, int i2) {
        int i3 = i2 + 1;
        while (i != -1) {
            i = getjump(i);
            _assert(GET_OPCODE(this.f3271f.code[i]) == 23 && (GETARG_A(this.f3271f.code[i]) == 0 || GETARG_A(this.f3271f.code[i]) >= i3));
            SETARG_A(this.f3271f.code, i, i3);
        }
    }

    /* access modifiers changed from: package-private */
    public void patchtohere(int i) {
        getlabel();
        concat(this.jpc, i);
    }

    /* access modifiers changed from: package-private */
    public void concat(IntPtr intPtr, int i) {
        if (i != -1) {
            if (intPtr.f3279i == -1) {
                intPtr.f3279i = i;
                return;
            }
            int i2 = intPtr.f3279i;
            while (true) {
                int i3 = getjump(i2);
                if (i3 != -1) {
                    i2 = i3;
                } else {
                    fixjump(i2, i);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void checkstack(int i) {
        int i2 = this.freereg + i;
        if (i2 > this.f3271f.maxstacksize) {
            if (i2 >= 250) {
                this.f3273ls.syntaxerror("function or expression too complex");
            }
            this.f3271f.maxstacksize = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public void reserveregs(int i) {
        checkstack(i);
        this.freereg = (short) (this.freereg + i);
    }

    void freereg(int i) {
        if (!ISK(i) && i >= this.nactvar) {
            this.freereg = (short) (this.freereg - 1);
            _assert(i == this.freereg);
        }
    }

    void freeexp(LexState.expdesc expdesc) {
        if (expdesc.f3294k == 6) {
            freereg(expdesc.f3295u.info);
        }
    }

    int addk(LuaValue luaValue) {
        if (this.f3272h == null) {
            this.f3272h = new Hashtable();
        } else if (this.f3272h.containsKey(luaValue)) {
            return ((Integer) this.f3272h.get(luaValue)).intValue();
        }
        int i = this.f3277nk;
        this.f3272h.put(luaValue, new Integer(i));
        Prototype prototype = this.f3271f;
        if (prototype.f3259k == null || this.f3277nk + 1 >= prototype.f3259k.length) {
            prototype.f3259k = realloc(prototype.f3259k, (this.f3277nk * 2) + 1);
        }
        LuaValue[] luaValueArr = prototype.f3259k;
        int i2 = this.f3277nk;
        this.f3277nk = i2 + 1;
        luaValueArr[i2] = luaValue;
        return i;
    }

    /* access modifiers changed from: package-private */
    public int stringK(LuaString luaString) {
        return addk(luaString);
    }

    /* access modifiers changed from: package-private */
    public int numberK(LuaValue luaValue) {
        if (luaValue instanceof LuaDouble) {
            double d = luaValue.todouble();
            int i = (int) d;
            if (d == ((double) i)) {
                luaValue = LuaInteger.valueOf(i);
            }
        }
        return addk(luaValue);
    }

    int boolK(boolean z) {
        return addk(z ? LuaValue.TRUE : LuaValue.FALSE);
    }

    int nilK() {
        return addk(LuaValue.NIL);
    }

    /* access modifiers changed from: package-private */
    public void setreturns(LexState.expdesc expdesc, int i) {
        if (expdesc.f3294k == 12) {
            SETARG_C(getcodePtr(expdesc), i + 1);
        } else if (expdesc.f3294k == 13) {
            SETARG_B(getcodePtr(expdesc), i + 1);
            SETARG_A(getcodePtr(expdesc), this.freereg);
            reserveregs(1);
        }
    }

    /* access modifiers changed from: package-private */
    public void setoneret(LexState.expdesc expdesc) {
        if (expdesc.f3294k == 12) {
            expdesc.f3294k = 6;
            expdesc.f3295u.info = GETARG_A(getcode(expdesc));
        } else if (expdesc.f3294k == 13) {
            SETARG_B(getcodePtr(expdesc), 2);
            expdesc.f3294k = 11;
        }
    }

    /* access modifiers changed from: package-private */
    public void dischargevars(LexState.expdesc expdesc) {
        switch (expdesc.f3294k) {
            case 7:
                expdesc.f3294k = 6;
                return;
            case 8:
                expdesc.f3295u.info = codeABC(5, 0, expdesc.f3295u.info, 0);
                expdesc.f3294k = 11;
                return;
            case 9:
                int i = 6;
                freereg(expdesc.f3295u.ind_idx);
                if (expdesc.f3295u.ind_vt == 7) {
                    freereg(expdesc.f3295u.ind_t);
                    i = 7;
                }
                expdesc.f3295u.info = codeABC(i, 0, expdesc.f3295u.ind_t, expdesc.f3295u.ind_idx);
                expdesc.f3294k = 11;
                return;
            case 10:
            case 11:
            default:
                return;
            case 12:
            case 13:
                setoneret(expdesc);
                return;
        }
    }

    int code_label(int i, int i2, int i3) {
        getlabel();
        return codeABC(3, i, i2, i3);
    }

    void discharge2reg(LexState.expdesc expdesc, int i) {
        dischargevars(expdesc);
        switch (expdesc.f3294k) {
            case 1:
                nil(i, 1);
                break;
            case 2:
            case 3:
                codeABC(3, i, expdesc.f3294k == 2 ? 1 : 0, 0);
                break;
            case 4:
                codeABx(1, i, expdesc.f3295u.info);
                break;
            case 5:
                codeABx(1, i, numberK(expdesc.f3295u.nval()));
                break;
            case 6:
                if (i != expdesc.f3295u.info) {
                    codeABC(0, i, expdesc.f3295u.info, 0);
                    break;
                }
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            default:
                _assert(expdesc.f3294k == 0 || expdesc.f3294k == 10);
                return;
            case 11:
                SETARG_A(getcodePtr(expdesc), i);
                break;
        }
        expdesc.f3295u.info = i;
        expdesc.f3294k = 6;
    }

    void discharge2anyreg(LexState.expdesc expdesc) {
        if (expdesc.f3294k != 6) {
            reserveregs(1);
            discharge2reg(expdesc, this.freereg - 1);
        }
    }

    void exp2reg(LexState.expdesc expdesc, int i) {
        discharge2reg(expdesc, i);
        if (expdesc.f3294k == 10) {
            concat(expdesc.f3296t, expdesc.f3295u.info);
        }
        if (expdesc.hasjumps()) {
            int i2 = -1;
            int i3 = -1;
            if (need_value(expdesc.f3296t.f3279i) || need_value(expdesc.f3297f.f3279i)) {
                int jump = expdesc.f3294k == 10 ? -1 : jump();
                i2 = code_label(i, 0, 1);
                i3 = code_label(i, 1, 0);
                patchtohere(jump);
            }
            int i4 = getlabel();
            patchlistaux(expdesc.f3297f.f3279i, i4, i, i2);
            patchlistaux(expdesc.f3296t.f3279i, i4, i, i3);
        }
        IntPtr intPtr = expdesc.f3297f;
        expdesc.f3296t.f3279i = -1;
        intPtr.f3279i = -1;
        expdesc.f3295u.info = i;
        expdesc.f3294k = 6;
    }

    /* access modifiers changed from: package-private */
    public void exp2nextreg(LexState.expdesc expdesc) {
        dischargevars(expdesc);
        freeexp(expdesc);
        reserveregs(1);
        exp2reg(expdesc, this.freereg - 1);
    }

    /* access modifiers changed from: package-private */
    public int exp2anyreg(LexState.expdesc expdesc) {
        dischargevars(expdesc);
        if (expdesc.f3294k == 6) {
            if (!expdesc.hasjumps()) {
                return expdesc.f3295u.info;
            }
            if (expdesc.f3295u.info >= this.nactvar) {
                exp2reg(expdesc, expdesc.f3295u.info);
                return expdesc.f3295u.info;
            }
        }
        exp2nextreg(expdesc);
        return expdesc.f3295u.info;
    }

    /* access modifiers changed from: package-private */
    public void exp2anyregup(LexState.expdesc expdesc) {
        if (expdesc.f3294k != 8 || expdesc.hasjumps()) {
            exp2anyreg(expdesc);
        }
    }

    /* access modifiers changed from: package-private */
    public void exp2val(LexState.expdesc expdesc) {
        if (expdesc.hasjumps()) {
            exp2anyreg(expdesc);
        } else {
            dischargevars(expdesc);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int exp2RK(org.luaj.vm2.compiler.LexState.expdesc r6) {
        /*
            r5 = this;
            r0 = r5
            r1 = r6
            r0.exp2val(r1)
            r0 = r6
            int r0 = r0.f3294k
            switch(r0) {
                case 1: goto L_0x002c;
                case 2: goto L_0x002c;
                case 3: goto L_0x002c;
                case 4: goto L_0x0084;
                case 5: goto L_0x006d;
                default: goto L_0x009c;
            }
        L_0x002c:
            r0 = r5
            int r0 = r0.f3277nk
            r1 = 255(0xff, float:3.57E-43)
            if (r0 > r1) goto L_0x009c
            r0 = r6
            org.luaj.vm2.compiler.LexState$expdesc$U r0 = r0.f3295u
            r1 = r6
            int r1 = r1.f3294k
            r2 = 1
            if (r1 != r2) goto L_0x0049
            r1 = r5
            int r1 = r1.nilK()
            goto L_0x005a
        L_0x0049:
            r1 = r5
            r2 = r6
            int r2 = r2.f3294k
            r3 = 2
            if (r2 != r3) goto L_0x0056
            r2 = 1
            goto L_0x0057
        L_0x0056:
            r2 = 0
        L_0x0057:
            int r1 = r1.boolK(r2)
        L_0x005a:
            r0.info = r1
            r0 = r6
            r1 = 4
            r0.f3294k = r1
            r0 = r6
            org.luaj.vm2.compiler.LexState$expdesc$U r0 = r0.f3295u
            int r0 = r0.info
            int r0 = RKASK(r0)
            return r0
        L_0x006d:
            r0 = r6
            org.luaj.vm2.compiler.LexState$expdesc$U r0 = r0.f3295u
            r1 = r5
            r2 = r6
            org.luaj.vm2.compiler.LexState$expdesc$U r2 = r2.f3295u
            org.luaj.vm2.LuaValue r2 = r2.nval()
            int r1 = r1.numberK(r2)
            r0.info = r1
            r0 = r6
            r1 = 4
            r0.f3294k = r1
        L_0x0084:
            r0 = r6
            org.luaj.vm2.compiler.LexState$expdesc$U r0 = r0.f3295u
            int r0 = r0.info
            r1 = 255(0xff, float:3.57E-43)
            if (r0 > r1) goto L_0x009c
            r0 = r6
            org.luaj.vm2.compiler.LexState$expdesc$U r0 = r0.f3295u
            int r0 = r0.info
            int r0 = RKASK(r0)
            return r0
        L_0x009c:
            r0 = r5
            r1 = r6
            int r0 = r0.exp2anyreg(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.compiler.FuncState.exp2RK(org.luaj.vm2.compiler.LexState$expdesc):int");
    }

    /* access modifiers changed from: package-private */
    public void storevar(LexState.expdesc expdesc, LexState.expdesc expdesc2) {
        switch (expdesc.f3294k) {
            case 7:
                freeexp(expdesc2);
                exp2reg(expdesc2, expdesc.f3295u.info);
                return;
            case 8:
                codeABC(9, exp2anyreg(expdesc2), expdesc.f3295u.info, 0);
                break;
            case 9:
                codeABC(expdesc.f3295u.ind_vt == 7 ? 10 : 8, expdesc.f3295u.ind_t, expdesc.f3295u.ind_idx, exp2RK(expdesc2));
                break;
            default:
                _assert(false);
                break;
        }
        freeexp(expdesc2);
    }

    /* access modifiers changed from: package-private */
    public void self(LexState.expdesc expdesc, LexState.expdesc expdesc2) {
        exp2anyreg(expdesc);
        freeexp(expdesc);
        short s = this.freereg;
        reserveregs(2);
        codeABC(12, s, expdesc.f3295u.info, exp2RK(expdesc2));
        freeexp(expdesc2);
        expdesc.f3295u.info = s;
        expdesc.f3294k = 6;
    }

    void invertjump(LexState.expdesc expdesc) {
        InstructionPtr instructionPtr = getjumpcontrol(expdesc.f3295u.info);
        _assert((!testTMode(GET_OPCODE(instructionPtr.get())) || GET_OPCODE(instructionPtr.get()) == 28 || Lua.GET_OPCODE(instructionPtr.get()) == 27) ? false : true);
        SETARG_A(instructionPtr, GETARG_A(instructionPtr.get()) != 0 ? 0 : 1);
    }

    int jumponcond(LexState.expdesc expdesc, int i) {
        if (expdesc.f3294k == 11) {
            int i2 = getcode(expdesc);
            if (GET_OPCODE(i2) == 20) {
                this.f3276pc--;
                return condjump(27, GETARG_B(i2), 0, i != 0 ? 0 : 1);
            }
        }
        discharge2anyreg(expdesc);
        freeexp(expdesc);
        return condjump(28, 255, expdesc.f3295u.info, i);
    }

    /* access modifiers changed from: package-private */
    public void goiftrue(LexState.expdesc expdesc) {
        int i;
        dischargevars(expdesc);
        switch (expdesc.f3294k) {
            case 2:
            case 4:
            case 5:
                i = -1;
                break;
            case 3:
            case 6:
            case 7:
            case 8:
            case 9:
            default:
                i = jumponcond(expdesc, 0);
                break;
            case 10:
                invertjump(expdesc);
                i = expdesc.f3295u.info;
                break;
        }
        concat(expdesc.f3297f, i);
        patchtohere(expdesc.f3296t.f3279i);
        expdesc.f3296t.f3279i = -1;
    }

    /* access modifiers changed from: package-private */
    public void goiffalse(LexState.expdesc expdesc) {
        int i;
        dischargevars(expdesc);
        switch (expdesc.f3294k) {
            case 1:
            case 3:
                i = -1;
                break;
            case 10:
                i = expdesc.f3295u.info;
                break;
            default:
                i = jumponcond(expdesc, 1);
                break;
        }
        concat(expdesc.f3296t, i);
        patchtohere(expdesc.f3297f.f3279i);
        expdesc.f3297f.f3279i = -1;
    }

    void codenot(LexState.expdesc expdesc) {
        dischargevars(expdesc);
        switch (expdesc.f3294k) {
            case 1:
            case 3:
                expdesc.f3294k = 2;
                break;
            case 2:
            case 4:
            case 5:
                expdesc.f3294k = 3;
                break;
            case 6:
            case 11:
                discharge2anyreg(expdesc);
                freeexp(expdesc);
                expdesc.f3295u.info = codeABC(20, 0, expdesc.f3295u.info, 0);
                expdesc.f3294k = 11;
                break;
            case 7:
            case 8:
            case 9:
            default:
                _assert(false);
                break;
            case 10:
                invertjump(expdesc);
                break;
        }
        int i = expdesc.f3297f.f3279i;
        expdesc.f3297f.f3279i = expdesc.f3296t.f3279i;
        expdesc.f3296t.f3279i = i;
        removevalues(expdesc.f3297f.f3279i);
        removevalues(expdesc.f3296t.f3279i);
    }

    static boolean vkisinreg(int i) {
        return i == 6 || i == 7;
    }

    /* access modifiers changed from: package-private */
    public void indexed(LexState.expdesc expdesc, LexState.expdesc expdesc2) {
        expdesc.f3295u.ind_t = (short) expdesc.f3295u.info;
        expdesc.f3295u.ind_idx = (short) exp2RK(expdesc2);
        LuaC._assert(expdesc.f3294k == 8 || vkisinreg(expdesc.f3294k));
        expdesc.f3295u.ind_vt = (short) (expdesc.f3294k == 8 ? 8 : 7);
        expdesc.f3294k = 9;
    }

    boolean constfolding(int i, LexState.expdesc expdesc, LexState.expdesc expdesc2) {
        LuaValue luaValue;
        if (!expdesc.isnumeral() || !expdesc2.isnumeral()) {
            return false;
        }
        if ((i == 16 || i == 17) && expdesc2.f3295u.nval().eq_b(LuaValue.ZERO)) {
            return false;
        }
        LuaValue nval = expdesc.f3295u.nval();
        LuaValue nval2 = expdesc2.f3295u.nval();
        switch (i) {
            case 13:
                luaValue = nval.add(nval2);
                break;
            case 14:
                luaValue = nval.sub(nval2);
                break;
            case 15:
                luaValue = nval.mul(nval2);
                break;
            case 16:
                luaValue = nval.div(nval2);
                break;
            case 17:
                luaValue = nval.mod(nval2);
                break;
            case 18:
                luaValue = nval.pow(nval2);
                break;
            case 19:
                luaValue = nval.neg();
                break;
            case 20:
            default:
                _assert(false);
                luaValue = null;
                break;
            case 21:
                return false;
        }
        if (Double.isNaN(luaValue.todouble())) {
            return false;
        }
        expdesc.f3295u.setNval(luaValue);
        return true;
    }

    void codearith(int i, LexState.expdesc expdesc, LexState.expdesc expdesc2, int i2) {
        if (!constfolding(i, expdesc, expdesc2)) {
            int exp2RK = (i == 19 || i == 21) ? 0 : exp2RK(expdesc2);
            int exp2RK2 = exp2RK(expdesc);
            if (exp2RK2 > exp2RK) {
                freeexp(expdesc);
                freeexp(expdesc2);
            } else {
                freeexp(expdesc2);
                freeexp(expdesc);
            }
            expdesc.f3295u.info = codeABC(i, 0, exp2RK2, exp2RK);
            expdesc.f3294k = 11;
            fixline(i2);
        }
    }

    void codecomp(int i, int i2, LexState.expdesc expdesc, LexState.expdesc expdesc2) {
        int exp2RK = exp2RK(expdesc);
        int exp2RK2 = exp2RK(expdesc2);
        freeexp(expdesc2);
        freeexp(expdesc);
        if (i2 == 0 && i != 24) {
            exp2RK = exp2RK2;
            exp2RK2 = exp2RK;
            i2 = 1;
        }
        expdesc.f3295u.info = condjump(i, i2, exp2RK, exp2RK2);
        expdesc.f3294k = 10;
    }

    /* access modifiers changed from: package-private */
    public void prefix(int i, LexState.expdesc expdesc, int i2) {
        LexState.expdesc expdesc2 = new LexState.expdesc();
        expdesc2.init(5, 0);
        switch (i) {
            case 0:
                if (expdesc.isnumeral()) {
                    expdesc.f3295u.setNval(expdesc.f3295u.nval().neg());
                    return;
                }
                exp2anyreg(expdesc);
                codearith(19, expdesc, expdesc2, i2);
                return;
            case 1:
                codenot(expdesc);
                return;
            case 2:
                exp2anyreg(expdesc);
                codearith(21, expdesc, expdesc2, i2);
                return;
            default:
                _assert(false);
                return;
        }
    }

    /* access modifiers changed from: package-private */
    public void infix(int i, LexState.expdesc expdesc) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                if (!expdesc.isnumeral()) {
                    exp2RK(expdesc);
                    return;
                }
                return;
            case 6:
                exp2nextreg(expdesc);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            default:
                exp2RK(expdesc);
                return;
            case 13:
                goiftrue(expdesc);
                return;
            case 14:
                goiffalse(expdesc);
                return;
        }
    }

    /* access modifiers changed from: package-private */
    public void posfix(int i, LexState.expdesc expdesc, LexState.expdesc expdesc2, int i2) {
        switch (i) {
            case 0:
                codearith(13, expdesc, expdesc2, i2);
                return;
            case 1:
                codearith(14, expdesc, expdesc2, i2);
                return;
            case 2:
                codearith(15, expdesc, expdesc2, i2);
                return;
            case 3:
                codearith(16, expdesc, expdesc2, i2);
                return;
            case 4:
                codearith(17, expdesc, expdesc2, i2);
                return;
            case 5:
                codearith(18, expdesc, expdesc2, i2);
                return;
            case 6:
                exp2val(expdesc2);
                if (expdesc2.f3294k == 11 && GET_OPCODE(getcode(expdesc2)) == 22) {
                    _assert(expdesc.f3295u.info == GETARG_B(getcode(expdesc2)) - 1);
                    freeexp(expdesc);
                    SETARG_B(getcodePtr(expdesc2), expdesc.f3295u.info);
                    expdesc.f3294k = 11;
                    expdesc.f3295u.info = expdesc2.f3295u.info;
                    return;
                }
                exp2nextreg(expdesc2);
                codearith(22, expdesc, expdesc2, i2);
                return;
            case 7:
                codecomp(24, 0, expdesc, expdesc2);
                return;
            case 8:
                codecomp(24, 1, expdesc, expdesc2);
                return;
            case 9:
                codecomp(25, 1, expdesc, expdesc2);
                return;
            case 10:
                codecomp(26, 1, expdesc, expdesc2);
                return;
            case 11:
                codecomp(25, 0, expdesc, expdesc2);
                return;
            case 12:
                codecomp(26, 0, expdesc, expdesc2);
                return;
            case 13:
                _assert(expdesc.f3296t.f3279i == -1);
                dischargevars(expdesc2);
                concat(expdesc2.f3297f, expdesc.f3297f.f3279i);
                expdesc.setvalue(expdesc2);
                return;
            case 14:
                _assert(expdesc.f3297f.f3279i == -1);
                dischargevars(expdesc2);
                concat(expdesc2.f3296t, expdesc.f3296t.f3279i);
                expdesc.setvalue(expdesc2);
                return;
            default:
                _assert(false);
                return;
        }
    }

    /* access modifiers changed from: package-private */
    public void fixline(int i) {
        this.f3271f.lineinfo[this.f3276pc - 1] = i;
    }

    int code(int i, int i2) {
        Prototype prototype = this.f3271f;
        dischargejpc();
        if (prototype.code == null || this.f3276pc + 1 > prototype.code.length) {
            prototype.code = LuaC.realloc(prototype.code, (this.f3276pc * 2) + 1);
        }
        prototype.code[this.f3276pc] = i;
        if (prototype.lineinfo == null || this.f3276pc + 1 > prototype.lineinfo.length) {
            prototype.lineinfo = LuaC.realloc(prototype.lineinfo, (this.f3276pc * 2) + 1);
        }
        prototype.lineinfo[this.f3276pc] = i2;
        int i3 = this.f3276pc;
        this.f3276pc = i3 + 1;
        return i3;
    }

    /* access modifiers changed from: package-private */
    public int codeABC(int i, int i2, int i3, int i4) {
        _assert(getOpMode(i) == 0);
        _assert(getBMode(i) != 0 || i3 == 0);
        _assert(getCMode(i) != 0 || i4 == 0);
        return code(CREATE_ABC(i, i2, i3, i4), this.f3273ls.lastline);
    }

    /* access modifiers changed from: package-private */
    public int codeABx(int i, int i2, int i3) {
        _assert(getOpMode(i) == 1 || getOpMode(i) == 2);
        _assert(getCMode(i) == 0);
        _assert(i3 >= 0 && i3 <= 262143);
        return code(CREATE_ABx(i, i2, i3), this.f3273ls.lastline);
    }

    void setlist(int i, int i2, int i3) {
        int i4 = ((i2 - 1) / 50) + 1;
        int i5 = i3 == -1 ? 0 : i3;
        _assert(i3 != 0);
        if (i4 <= 511) {
            codeABC(36, i, i5, i4);
        } else {
            codeABC(36, i, i5, 0);
            code(i4, this.f3273ls.lastline);
        }
        this.freereg = (short) (i + 1);
    }
}
