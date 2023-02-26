package org.luaj.vm2.luajc;

import org.luaj.vm2.Lua;

/* loaded from: grasscutter.jar:org/luaj/vm2/luajc/UpvalInfo.class */
public class UpvalInfo {

    /* renamed from: pi */
    ProtoInfo f3314pi;
    int slot;
    int nvars;
    VarInfo[] var;

    /* renamed from: rw */
    boolean f3315rw;

    public UpvalInfo(ProtoInfo protoInfo) {
        this.f3314pi = protoInfo;
        this.slot = 0;
        this.nvars = 1;
        this.var = new VarInfo[]{VarInfo.PARAM(0)};
        this.f3315rw = false;
    }

    public UpvalInfo(ProtoInfo protoInfo, int i, int i2) {
        this.f3314pi = protoInfo;
        this.slot = i2;
        this.nvars = 0;
        this.var = null;
        includeVarAndPosteriorVars(protoInfo.vars[i2][i]);
        for (int i3 = 0; i3 < this.nvars; i3++) {
            this.var[i3].allocupvalue = testIsAllocUpvalue(this.var[i3]);
        }
        this.f3315rw = this.nvars > 1;
    }

    private boolean includeVarAndPosteriorVars(VarInfo varInfo) {
        if (varInfo == null || varInfo == VarInfo.INVALID) {
            return false;
        }
        if (varInfo.upvalue == this) {
            return true;
        }
        varInfo.upvalue = this;
        appendVar(varInfo);
        if (isLoopVariable(varInfo)) {
            return false;
        }
        boolean includePosteriorVarsCheckLoops = includePosteriorVarsCheckLoops(varInfo);
        if (includePosteriorVarsCheckLoops) {
            includePriorVarsIgnoreLoops(varInfo);
        }
        return includePosteriorVarsCheckLoops;
    }

    private boolean isLoopVariable(VarInfo varInfo) {
        if (varInfo.f3316pc < 0) {
            return false;
        }
        switch (Lua.GET_OPCODE(this.f3314pi.prototype.code[varInfo.f3316pc])) {
            case 32:
            case 35:
                return true;
            default:
                return false;
        }
    }

    private boolean includePosteriorVarsCheckLoops(VarInfo varInfo) {
        boolean z = false;
        int length = this.f3314pi.blocklist.length;
        for (int i = 0; i < length; i++) {
            BasicBlock basicBlock = this.f3314pi.blocklist[i];
            if (this.f3314pi.vars[this.slot][basicBlock.pc1] == varInfo) {
                int length2 = basicBlock.next != null ? basicBlock.next.length : 0;
                for (int i2 = 0; i2 < length2; i2++) {
                    VarInfo varInfo2 = this.f3314pi.vars[this.slot][basicBlock.next[i2].pc0];
                    if (varInfo2 != varInfo) {
                        z |= includeVarAndPosteriorVars(varInfo2);
                        if (varInfo2.isPhiVar()) {
                            includePriorVarsIgnoreLoops(varInfo2);
                        }
                    }
                }
            } else {
                int i3 = basicBlock.pc1 - 1;
                while (true) {
                    if (i3 < basicBlock.pc0) {
                        break;
                    } else if (this.f3314pi.vars[this.slot][i3] == varInfo) {
                        z |= includeVarAndPosteriorVars(this.f3314pi.vars[this.slot][i3 + 1]);
                        break;
                    } else {
                        i3--;
                    }
                }
            }
        }
        return z;
    }

    private void includePriorVarsIgnoreLoops(VarInfo varInfo) {
        int length = this.f3314pi.blocklist.length;
        for (int i = 0; i < length; i++) {
            BasicBlock basicBlock = this.f3314pi.blocklist[i];
            if (this.f3314pi.vars[this.slot][basicBlock.pc0] == varInfo) {
                int length2 = basicBlock.prev != null ? basicBlock.prev.length : 0;
                for (int i2 = 0; i2 < length2; i2++) {
                    VarInfo varInfo2 = this.f3314pi.vars[this.slot][basicBlock.prev[i2].pc1];
                    if (varInfo2 != varInfo) {
                        includeVarAndPosteriorVars(varInfo2);
                    }
                }
            } else {
                int i3 = basicBlock.pc0 + 1;
                while (true) {
                    if (i3 > basicBlock.pc1) {
                        break;
                    } else if (this.f3314pi.vars[this.slot][i3] == varInfo) {
                        includeVarAndPosteriorVars(this.f3314pi.vars[this.slot][i3 - 1]);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
    }

    private void appendVar(VarInfo varInfo) {
        if (this.nvars == 0) {
            this.var = new VarInfo[1];
        } else if (this.nvars + 1 >= this.var.length) {
            VarInfo[] varInfoArr = this.var;
            this.var = new VarInfo[(this.nvars * 2) + 1];
            System.arraycopy(varInfoArr, 0, this.var, 0, this.nvars);
        }
        VarInfo[] varInfoArr2 = this.var;
        int i = this.nvars;
        this.nvars = i + 1;
        varInfoArr2[i] = varInfo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f3314pi.name);
        int i = 0;
        while (i < this.nvars) {
            stringBuffer.append(i > 0 ? "," : " ");
            stringBuffer.append(String.valueOf(this.var[i]));
            i++;
        }
        if (this.f3315rw) {
            stringBuffer.append("(rw)");
        }
        return stringBuffer.toString();
    }

    private boolean testIsAllocUpvalue(VarInfo varInfo) {
        if (varInfo.f3316pc < 0) {
            return true;
        }
        BasicBlock basicBlock = this.f3314pi.blocks[varInfo.f3316pc];
        if (varInfo.f3316pc > basicBlock.pc0) {
            return this.f3314pi.vars[this.slot][varInfo.f3316pc - 1].upvalue != this;
        }
        if (basicBlock.prev == null) {
            VarInfo varInfo2 = this.f3314pi.params[this.slot];
            return (varInfo2 == null || varInfo2.upvalue == this) ? false : true;
        }
        int length = basicBlock.prev.length;
        for (int i = 0; i < length; i++) {
            VarInfo varInfo3 = this.f3314pi.vars[this.slot][basicBlock.prev[i].pc1];
            if (!(varInfo3 == null || varInfo3.upvalue == this)) {
                return true;
            }
        }
        return false;
    }
}
