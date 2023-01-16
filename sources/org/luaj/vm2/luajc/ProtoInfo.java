package org.luaj.vm2.luajc;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Hashtable;
import org.luaj.vm2.Lua;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.Print;
import org.luaj.vm2.Prototype;
import org.luaj.vm2.Upvaldesc;

/* loaded from: grasscutter.jar:org/luaj/vm2/luajc/ProtoInfo.class */
public class ProtoInfo {
    public final String name;
    public final Prototype prototype;
    public final ProtoInfo[] subprotos;
    public final BasicBlock[] blocks;
    public final BasicBlock[] blocklist;
    public final VarInfo[] params;
    public final VarInfo[][] vars;
    public final UpvalInfo[] upvals;
    public final UpvalInfo[][] openups;

    public ProtoInfo(Prototype prototype, String str) {
        this(prototype, str, null);
    }

    private ProtoInfo(Prototype prototype, String str, UpvalInfo[] upvalInfoArr) {
        this.name = str;
        this.prototype = prototype;
        this.upvals = upvalInfoArr != null ? upvalInfoArr : new UpvalInfo[]{new UpvalInfo(this)};
        this.subprotos = (prototype.f3296p == null || prototype.f3296p.length <= 0) ? null : new ProtoInfo[prototype.f3296p.length];
        this.blocks = BasicBlock.findBasicBlocks(prototype);
        this.blocklist = BasicBlock.findLiveBlocks(this.blocks);
        this.params = new VarInfo[prototype.maxstacksize];
        for (int i = 0; i < prototype.maxstacksize; i++) {
            this.params[i] = VarInfo.PARAM(i);
        }
        this.vars = findVariables();
        replaceTrivialPhiVariables();
        this.openups = new UpvalInfo[prototype.maxstacksize];
        findUpvalues();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new StringBuffer().append("proto '").append(this.name).append("'\n").toString());
        int length = this.upvals != null ? this.upvals.length : 0;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(new StringBuffer().append(" up[").append(i).append("]: ").append(this.upvals[i]).append("\n").toString());
        }
        for (int i2 = 0; i2 < this.blocklist.length; i2++) {
            BasicBlock basicBlock = this.blocklist[i2];
            int i3 = basicBlock.pc0;
            stringBuffer.append(new StringBuffer().append("  block ").append(basicBlock.toString()).toString());
            appendOpenUps(stringBuffer, -1);
            while (i3 <= basicBlock.pc1) {
                appendOpenUps(stringBuffer, i3);
                stringBuffer.append("     ");
                for (int i4 = 0; i4 < this.prototype.maxstacksize; i4++) {
                    VarInfo varInfo = this.vars[i4][i3];
                    stringBuffer.append(new StringBuffer().append(varInfo == null ? "null   " : String.valueOf(varInfo)).append(varInfo == null ? "" : varInfo.upvalue != null ? !varInfo.upvalue.f3351rw ? "[C] " : (!varInfo.allocupvalue || varInfo.f3352pc != i3) ? "[]  " : "[*] " : "    ").toString());
                }
                stringBuffer.append("  ");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                PrintStream printStream = Print.f3294ps;
                Print.f3294ps = new PrintStream(byteArrayOutputStream);
                try {
                    Print.printOpCode(this.prototype, i3);
                    Print.f3294ps.close();
                    Print.f3294ps = printStream;
                    stringBuffer.append(byteArrayOutputStream.toString());
                    stringBuffer.append("\n");
                    i3++;
                } catch (Throwable th) {
                    Print.f3294ps.close();
                    Print.f3294ps = printStream;
                    throw th;
                }
            }
        }
        int length2 = this.subprotos != null ? this.subprotos.length : 0;
        for (int i5 = 0; i5 < length2; i5++) {
            stringBuffer.append(this.subprotos[i5].toString());
        }
        return stringBuffer.toString();
    }

    private void appendOpenUps(StringBuffer stringBuffer, int i) {
        for (int i2 = 0; i2 < this.prototype.maxstacksize; i2++) {
            VarInfo varInfo = i < 0 ? this.params[i2] : this.vars[i2][i];
            if (varInfo != null && varInfo.f3352pc == i && varInfo.allocupvalue) {
                stringBuffer.append(new StringBuffer().append("    open: ").append(varInfo.upvalue).append("\n").toString());
            }
        }
    }

    private VarInfo[][] findVariables() {
        int length = this.prototype.code.length;
        int i = this.prototype.maxstacksize;
        VarInfo[][] varInfoArr = new VarInfo[i];
        for (int i2 = 0; i2 < varInfoArr.length; i2++) {
            varInfoArr[i2] = new VarInfo[length];
        }
        for (int i3 = 0; i3 < this.blocklist.length; i3++) {
            BasicBlock basicBlock = this.blocklist[i3];
            int length2 = basicBlock.prev != null ? basicBlock.prev.length : 0;
            for (int i4 = 0; i4 < i; i4++) {
                VarInfo varInfo = null;
                if (length2 == 0) {
                    varInfo = this.params[i4];
                } else if (length2 == 1) {
                    varInfo = varInfoArr[i4][basicBlock.prev[0].pc1];
                } else {
                    for (int i5 = 0; i5 < length2; i5++) {
                        if (varInfoArr[i4][basicBlock.prev[i5].pc1] == VarInfo.INVALID) {
                            varInfo = VarInfo.INVALID;
                        }
                    }
                }
                if (varInfo == null) {
                    varInfo = VarInfo.PHI(this, i4, basicBlock.pc0);
                }
                varInfoArr[i4][basicBlock.pc0] = varInfo;
            }
            for (int i6 = basicBlock.pc0; i6 <= basicBlock.pc1; i6++) {
                if (i6 > basicBlock.pc0) {
                    propogateVars(varInfoArr, i6 - 1, i6);
                }
                int i7 = this.prototype.code[i6];
                switch (Lua.GET_OPCODE(i7)) {
                    case 0:
                    case 19:
                    case 20:
                    case 21:
                    case 28:
                        int GETARG_A = Lua.GETARG_A(i7);
                        varInfoArr[Lua.GETARG_B(i7)][i6].isreferenced = true;
                        varInfoArr[GETARG_A][i6] = new VarInfo(GETARG_A, i6);
                        break;
                    case 1:
                    case 3:
                    case 5:
                    case 11:
                        int GETARG_A2 = Lua.GETARG_A(i7);
                        varInfoArr[GETARG_A2][i6] = new VarInfo(GETARG_A2, i6);
                        break;
                    case 2:
                    default:
                        throw new IllegalStateException(new StringBuffer().append("unhandled opcode: ").append(i7).toString());
                    case 4:
                        int GETARG_A3 = Lua.GETARG_A(i7);
                        int GETARG_B = Lua.GETARG_B(i7);
                        while (true) {
                            GETARG_B--;
                            if (GETARG_B >= 0) {
                                varInfoArr[GETARG_A3][i6] = new VarInfo(GETARG_A3, i6);
                                GETARG_A3++;
                            }
                        }
                        break;
                    case 6:
                        int GETARG_A4 = Lua.GETARG_A(i7);
                        int GETARG_C = Lua.GETARG_C(i7);
                        if (!Lua.ISK(GETARG_C)) {
                            varInfoArr[GETARG_C][i6].isreferenced = true;
                        }
                        varInfoArr[GETARG_A4][i6] = new VarInfo(GETARG_A4, i6);
                        break;
                    case 7:
                        int GETARG_A5 = Lua.GETARG_A(i7);
                        int GETARG_B2 = Lua.GETARG_B(i7);
                        int GETARG_C2 = Lua.GETARG_C(i7);
                        varInfoArr[GETARG_B2][i6].isreferenced = true;
                        if (!Lua.ISK(GETARG_C2)) {
                            varInfoArr[GETARG_C2][i6].isreferenced = true;
                        }
                        varInfoArr[GETARG_A5][i6] = new VarInfo(GETARG_A5, i6);
                        break;
                    case 8:
                        int GETARG_B3 = Lua.GETARG_B(i7);
                        int GETARG_C3 = Lua.GETARG_C(i7);
                        if (!Lua.ISK(GETARG_B3)) {
                            varInfoArr[GETARG_B3][i6].isreferenced = true;
                        }
                        if (!Lua.ISK(GETARG_C3)) {
                            varInfoArr[GETARG_C3][i6].isreferenced = true;
                            break;
                        } else {
                            break;
                        }
                    case 9:
                    case 27:
                        varInfoArr[Lua.GETARG_A(i7)][i6].isreferenced = true;
                        break;
                    case 10:
                        int GETARG_A6 = Lua.GETARG_A(i7);
                        int GETARG_B4 = Lua.GETARG_B(i7);
                        int GETARG_C4 = Lua.GETARG_C(i7);
                        varInfoArr[GETARG_A6][i6].isreferenced = true;
                        if (!Lua.ISK(GETARG_B4)) {
                            varInfoArr[GETARG_B4][i6].isreferenced = true;
                        }
                        if (!Lua.ISK(GETARG_C4)) {
                            varInfoArr[GETARG_C4][i6].isreferenced = true;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int GETARG_A7 = Lua.GETARG_A(i7);
                        int GETARG_B5 = Lua.GETARG_B(i7);
                        int GETARG_C5 = Lua.GETARG_C(i7);
                        varInfoArr[GETARG_B5][i6].isreferenced = true;
                        if (!Lua.ISK(GETARG_C5)) {
                            varInfoArr[GETARG_C5][i6].isreferenced = true;
                        }
                        varInfoArr[GETARG_A7][i6] = new VarInfo(GETARG_A7, i6);
                        varInfoArr[GETARG_A7 + 1][i6] = new VarInfo(GETARG_A7 + 1, i6);
                        break;
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        int GETARG_A8 = Lua.GETARG_A(i7);
                        int GETARG_B6 = Lua.GETARG_B(i7);
                        int GETARG_C6 = Lua.GETARG_C(i7);
                        if (!Lua.ISK(GETARG_B6)) {
                            varInfoArr[GETARG_B6][i6].isreferenced = true;
                        }
                        if (!Lua.ISK(GETARG_C6)) {
                            varInfoArr[GETARG_C6][i6].isreferenced = true;
                        }
                        varInfoArr[GETARG_A8][i6] = new VarInfo(GETARG_A8, i6);
                        break;
                    case 22:
                        int GETARG_A9 = Lua.GETARG_A(i7);
                        int GETARG_C7 = Lua.GETARG_C(i7);
                        for (int GETARG_B7 = Lua.GETARG_B(i7); GETARG_B7 <= GETARG_C7; GETARG_B7++) {
                            varInfoArr[GETARG_B7][i6].isreferenced = true;
                        }
                        varInfoArr[GETARG_A9][i6] = new VarInfo(GETARG_A9, i6);
                        break;
                    case 23:
                        int GETARG_A10 = Lua.GETARG_A(i7);
                        if (GETARG_A10 > 0) {
                            for (int i8 = GETARG_A10 - 1; i8 < i; i8++) {
                                varInfoArr[i8][i6] = VarInfo.INVALID;
                            }
                            break;
                        } else {
                            break;
                        }
                    case 24:
                    case 25:
                    case 26:
                        int GETARG_B8 = Lua.GETARG_B(i7);
                        int GETARG_C8 = Lua.GETARG_C(i7);
                        if (!Lua.ISK(GETARG_B8)) {
                            varInfoArr[GETARG_B8][i6].isreferenced = true;
                        }
                        if (!Lua.ISK(GETARG_C8)) {
                            varInfoArr[GETARG_C8][i6].isreferenced = true;
                            break;
                        } else {
                            break;
                        }
                    case 29:
                        int GETARG_A11 = Lua.GETARG_A(i7);
                        int GETARG_B9 = Lua.GETARG_B(i7);
                        int GETARG_C9 = Lua.GETARG_C(i7);
                        varInfoArr[GETARG_A11][i6].isreferenced = true;
                        varInfoArr[GETARG_A11][i6].isreferenced = true;
                        for (int i9 = 1; i9 <= GETARG_B9 - 1; i9++) {
                            varInfoArr[GETARG_A11 + i9][i6].isreferenced = true;
                        }
                        int i10 = 0;
                        while (i10 <= GETARG_C9 - 2) {
                            varInfoArr[GETARG_A11][i6] = new VarInfo(GETARG_A11, i6);
                            i10++;
                            GETARG_A11++;
                        }
                        while (GETARG_A11 < i) {
                            varInfoArr[GETARG_A11][i6] = VarInfo.INVALID;
                            GETARG_A11++;
                        }
                        break;
                    case 30:
                        int GETARG_A12 = Lua.GETARG_A(i7);
                        int GETARG_B10 = Lua.GETARG_B(i7);
                        varInfoArr[GETARG_A12][i6].isreferenced = true;
                        for (int i11 = 1; i11 <= GETARG_B10 - 1; i11++) {
                            varInfoArr[GETARG_A12 + i11][i6].isreferenced = true;
                        }
                        break;
                    case 31:
                        int GETARG_A13 = Lua.GETARG_A(i7);
                        int GETARG_B11 = Lua.GETARG_B(i7);
                        for (int i12 = 0; i12 <= GETARG_B11 - 2; i12++) {
                            varInfoArr[GETARG_A13 + i12][i6].isreferenced = true;
                        }
                        break;
                    case 32:
                        int GETARG_A14 = Lua.GETARG_A(i7);
                        varInfoArr[GETARG_A14][i6].isreferenced = true;
                        varInfoArr[GETARG_A14 + 2][i6].isreferenced = true;
                        varInfoArr[GETARG_A14][i6] = new VarInfo(GETARG_A14, i6);
                        varInfoArr[GETARG_A14][i6].isreferenced = true;
                        varInfoArr[GETARG_A14 + 1][i6].isreferenced = true;
                        varInfoArr[GETARG_A14 + 3][i6] = new VarInfo(GETARG_A14 + 3, i6);
                        break;
                    case 33:
                        int GETARG_A15 = Lua.GETARG_A(i7);
                        varInfoArr[GETARG_A15 + 2][i6].isreferenced = true;
                        varInfoArr[GETARG_A15][i6] = new VarInfo(GETARG_A15, i6);
                        break;
                    case 34:
                        int GETARG_A16 = Lua.GETARG_A(i7);
                        int GETARG_C10 = Lua.GETARG_C(i7);
                        int i13 = GETARG_A16 + 1;
                        varInfoArr[GETARG_A16][i6].isreferenced = true;
                        int i14 = i13 + 1;
                        varInfoArr[i13][i6].isreferenced = true;
                        int i15 = i14 + 1;
                        varInfoArr[i14][i6].isreferenced = true;
                        int i16 = 0;
                        while (i16 < GETARG_C10) {
                            varInfoArr[i15][i6] = new VarInfo(i15, i6);
                            i16++;
                            i15++;
                        }
                        while (i15 < i) {
                            varInfoArr[i15][i6] = VarInfo.INVALID;
                            i15++;
                        }
                        break;
                    case 35:
                        int GETARG_A17 = Lua.GETARG_A(i7);
                        varInfoArr[GETARG_A17 + 1][i6].isreferenced = true;
                        varInfoArr[GETARG_A17][i6] = new VarInfo(GETARG_A17, i6);
                        break;
                    case 36:
                        int GETARG_A18 = Lua.GETARG_A(i7);
                        int GETARG_B12 = Lua.GETARG_B(i7);
                        varInfoArr[GETARG_A18][i6].isreferenced = true;
                        for (int i17 = 1; i17 <= GETARG_B12; i17++) {
                            varInfoArr[GETARG_A18 + i17][i6].isreferenced = true;
                        }
                        break;
                    case 37:
                        int GETARG_A19 = Lua.GETARG_A(i7);
                        Upvaldesc[] upvaldescArr = this.prototype.f3296p[Lua.GETARG_Bx(i7)].upvalues;
                        int length3 = upvaldescArr.length;
                        for (int i18 = 0; i18 < length3; i18++) {
                            if (upvaldescArr[i18].instack) {
                                varInfoArr[upvaldescArr[i18].idx][i6].isreferenced = true;
                            }
                        }
                        varInfoArr[GETARG_A19][i6] = new VarInfo(GETARG_A19, i6);
                        break;
                    case 38:
                        int GETARG_A20 = Lua.GETARG_A(i7);
                        int GETARG_B13 = Lua.GETARG_B(i7);
                        int i19 = 1;
                        while (i19 < GETARG_B13) {
                            varInfoArr[GETARG_A20][i6] = new VarInfo(GETARG_A20, i6);
                            i19++;
                            GETARG_A20++;
                        }
                        if (GETARG_B13 == 0) {
                            while (GETARG_A20 < i) {
                                varInfoArr[GETARG_A20][i6] = VarInfo.INVALID;
                                GETARG_A20++;
                            }
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return varInfoArr;
    }

    private static void propogateVars(VarInfo[][] varInfoArr, int i, int i2) {
        int length = varInfoArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            varInfoArr[i3][i2] = varInfoArr[i3][i];
        }
    }

    private void replaceTrivialPhiVariables() {
        for (int i = 0; i < this.blocklist.length; i++) {
            BasicBlock basicBlock = this.blocklist[i];
            for (int i2 = 0; i2 < this.prototype.maxstacksize; i2++) {
                VarInfo varInfo = this.vars[i2][basicBlock.pc0];
                VarInfo resolvePhiVariableValues = varInfo.resolvePhiVariableValues();
                if (resolvePhiVariableValues != null) {
                    substituteVariable(i2, varInfo, resolvePhiVariableValues);
                }
            }
        }
    }

    private void substituteVariable(int i, VarInfo varInfo, VarInfo varInfo2) {
        int length = this.prototype.code.length;
        for (int i2 = 0; i2 < length; i2++) {
            replaceAll(this.vars[i], this.vars[i].length, varInfo, varInfo2);
        }
    }

    private void replaceAll(VarInfo[] varInfoArr, int i, VarInfo varInfo, VarInfo varInfo2) {
        for (int i2 = 0; i2 < i; i2++) {
            if (varInfoArr[i2] == varInfo) {
                varInfoArr[i2] = varInfo2;
            }
        }
    }

    private void findUpvalues() {
        int[] iArr = this.prototype.code;
        int length = iArr.length;
        String[] findInnerprotoNames = findInnerprotoNames();
        for (int i = 0; i < length; i++) {
            if (Lua.GET_OPCODE(iArr[i]) == 37) {
                int GETARG_Bx = Lua.GETARG_Bx(iArr[i]);
                Prototype prototype = this.prototype.f3296p[GETARG_Bx];
                UpvalInfo[] upvalInfoArr = new UpvalInfo[prototype.upvalues.length];
                String stringBuffer = new StringBuffer().append(this.name).append("$").append(findInnerprotoNames[GETARG_Bx]).toString();
                for (int i2 = 0; i2 < prototype.upvalues.length; i2++) {
                    Upvaldesc upvaldesc = prototype.upvalues[i2];
                    upvalInfoArr[i2] = upvaldesc.instack ? findOpenUp(i, upvaldesc.idx) : this.upvals[upvaldesc.idx];
                }
                this.subprotos[GETARG_Bx] = new ProtoInfo(prototype, stringBuffer, upvalInfoArr);
            }
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (Lua.GET_OPCODE(iArr[i3]) == 9) {
                this.upvals[Lua.GETARG_B(iArr[i3])].f3351rw = true;
            }
        }
    }

    private UpvalInfo findOpenUp(int i, int i2) {
        if (this.openups[i2] == null) {
            this.openups[i2] = new UpvalInfo[this.prototype.code.length];
        }
        if (this.openups[i2][i] != null) {
            return this.openups[i2][i];
        }
        UpvalInfo upvalInfo = new UpvalInfo(this, i, i2);
        int length = this.prototype.code.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.vars[i2][i3] != null && this.vars[i2][i3].upvalue == upvalInfo) {
                this.openups[i2][i3] = upvalInfo;
            }
        }
        return upvalInfo;
    }

    public boolean isUpvalueAssign(int i, int i2) {
        VarInfo varInfo = i < 0 ? this.params[i2] : this.vars[i2][i];
        return (varInfo == null || varInfo.upvalue == null || !varInfo.upvalue.f3351rw) ? false : true;
    }

    public boolean isUpvalueCreate(int i, int i2) {
        VarInfo varInfo = i < 0 ? this.params[i2] : this.vars[i2][i];
        return varInfo != null && varInfo.upvalue != null && varInfo.upvalue.f3351rw && varInfo.allocupvalue && i == varInfo.f3352pc;
    }

    public boolean isUpvalueRefer(int i, int i2) {
        if (i > 0 && this.vars[i2][i] != null && this.vars[i2][i].f3352pc == i && this.vars[i2][i - 1] != null) {
            i--;
        }
        VarInfo varInfo = i < 0 ? this.params[i2] : this.vars[i2][i];
        return (varInfo == null || varInfo.upvalue == null || !varInfo.upvalue.f3351rw) ? false : true;
    }

    public boolean isInitialValueUsed(int i) {
        return this.params[i].isreferenced;
    }

    public boolean isReadWriteUpvalue(UpvalInfo upvalInfo) {
        return upvalInfo.f3351rw;
    }

    private String[] findInnerprotoNames() {
        if (this.prototype.f3296p.length <= 0) {
            return null;
        }
        String[] strArr = new String[this.prototype.f3296p.length];
        Hashtable hashtable = new Hashtable();
        int[] iArr = this.prototype.code;
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (Lua.GET_OPCODE(iArr[i]) == 37) {
                int GETARG_Bx = Lua.GETARG_Bx(iArr[i]);
                String str = null;
                int i2 = iArr[i + 1];
                switch (Lua.GET_OPCODE(i2)) {
                    case 8:
                    case 10:
                        int GETARG_B = Lua.GETARG_B(i2);
                        if (Lua.ISK(GETARG_B)) {
                            str = this.prototype.f3295k[GETARG_B & 255].tojstring();
                            break;
                        }
                        break;
                    case 9:
                        LuaString luaString = this.prototype.upvalues[Lua.GETARG_B(i2)].name;
                        if (luaString != null) {
                            str = luaString.tojstring();
                            break;
                        }
                        break;
                    default:
                        LuaString luaString2 = this.prototype.getlocalname(Lua.GETARG_A(iArr[i]) + 1, i + 1);
                        if (luaString2 != null) {
                            str = luaString2.tojstring();
                            break;
                        }
                        break;
                }
                String javaClassPart = str != null ? toJavaClassPart(str) : String.valueOf(GETARG_Bx);
                if (hashtable.containsKey(javaClassPart)) {
                    int i3 = 1;
                    do {
                        i3++;
                        javaClassPart = new StringBuffer().append(javaClassPart).append('$').append(i3).toString();
                    } while (hashtable.containsKey(javaClassPart));
                    hashtable.put(javaClassPart, Boolean.TRUE);
                    strArr[GETARG_Bx] = javaClassPart;
                } else {
                    hashtable.put(javaClassPart, Boolean.TRUE);
                    strArr[GETARG_Bx] = javaClassPart;
                }
            }
        }
        return strArr;
    }

    private static String toJavaClassPart(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        for (int i = 0; i < length; i++) {
            stringBuffer.append(Character.isJavaIdentifierPart(str.charAt(i)) ? str.charAt(i) : '_');
        }
        return stringBuffer.toString();
    }
}
