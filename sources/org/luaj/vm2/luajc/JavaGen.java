package org.luaj.vm2.luajc;

import org.luaj.vm2.LocVars;
import org.luaj.vm2.Lua;
import org.luaj.vm2.Prototype;
import org.luaj.vm2.Upvaldesc;

/* loaded from: grasscutter.jar:org/luaj/vm2/luajc/JavaGen.class */
public class JavaGen {
    public final String classname;
    public final byte[] bytecode;
    public final JavaGen[] inners;

    public JavaGen(Prototype prototype, String str, String str2, boolean z) {
        this(new ProtoInfo(prototype, str), str, str2, z);
    }

    private JavaGen(ProtoInfo protoInfo, String str, String str2, boolean z) {
        this.classname = str;
        JavaBuilder javaBuilder = new JavaBuilder(protoInfo, str, str2);
        scanInstructions(protoInfo, str, javaBuilder);
        for (int i = 0; i < protoInfo.prototype.locvars.length; i++) {
            LocVars locVars = protoInfo.prototype.locvars[i];
            javaBuilder.setVarStartEnd(i, locVars.startpc, locVars.endpc, locVars.varname.tojstring());
        }
        this.bytecode = javaBuilder.completeClass(z);
        if (protoInfo.subprotos != null) {
            int length = protoInfo.subprotos.length;
            this.inners = new JavaGen[length];
            for (int i2 = 0; i2 < length; i2++) {
                this.inners[i2] = new JavaGen(protoInfo.subprotos[i2], protoInfo.subprotos[i2].name, str2, false);
            }
            return;
        }
        this.inners = null;
    }

    private void scanInstructions(ProtoInfo protoInfo, String str, JavaBuilder javaBuilder) {
        Prototype prototype = protoInfo.prototype;
        int i = -1;
        for (int i2 = 0; i2 < protoInfo.blocklist.length; i2++) {
            BasicBlock basicBlock = protoInfo.blocklist[i2];
            for (int i3 = 0; i3 < prototype.maxstacksize; i3++) {
                int i4 = basicBlock.pc0;
                if (protoInfo.isUpvalueCreate(i4, i3) && protoInfo.vars[i3][i4].isPhiVar()) {
                    javaBuilder.convertToUpvalue(i4, i3);
                }
            }
            int i5 = basicBlock.pc0;
            while (i5 <= basicBlock.pc1) {
                int i6 = prototype.code[i5];
                int i7 = i5 < prototype.lineinfo.length ? prototype.lineinfo[i5] : -1;
                int GET_OPCODE = Lua.GET_OPCODE(i6);
                int GETARG_A = Lua.GETARG_A(i6);
                int GETARG_B = Lua.GETARG_B(i6);
                int GETARG_Bx = Lua.GETARG_Bx(i6);
                int GETARG_sBx = Lua.GETARG_sBx(i6);
                int GETARG_C = Lua.GETARG_C(i6);
                switch (GET_OPCODE) {
                    case 0:
                        javaBuilder.loadLocal(i5, GETARG_B);
                        javaBuilder.storeLocal(i5, GETARG_A);
                        break;
                    case 1:
                        javaBuilder.loadConstant(prototype.f3295k[GETARG_Bx]);
                        javaBuilder.storeLocal(i5, GETARG_A);
                        break;
                    case 3:
                        javaBuilder.loadBoolean(GETARG_B != 0);
                        javaBuilder.storeLocal(i5, GETARG_A);
                        if (GETARG_C != 0) {
                            javaBuilder.addBranch(i5, 1, i5 + 2);
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        javaBuilder.loadNil();
                        while (GETARG_B >= 0) {
                            if (GETARG_B > 0) {
                                javaBuilder.dup();
                            }
                            javaBuilder.storeLocal(i5, GETARG_A);
                            GETARG_A++;
                            GETARG_B--;
                        }
                        break;
                    case 5:
                        javaBuilder.loadUpvalue(GETARG_B);
                        javaBuilder.storeLocal(i5, GETARG_A);
                        break;
                    case 6:
                        javaBuilder.loadUpvalue(GETARG_B);
                        loadLocalOrConstant(prototype, javaBuilder, i5, GETARG_C);
                        javaBuilder.getTable();
                        javaBuilder.storeLocal(i5, GETARG_A);
                        break;
                    case 7:
                        javaBuilder.loadLocal(i5, GETARG_B);
                        loadLocalOrConstant(prototype, javaBuilder, i5, GETARG_C);
                        javaBuilder.getTable();
                        javaBuilder.storeLocal(i5, GETARG_A);
                        break;
                    case 8:
                        javaBuilder.loadUpvalue(GETARG_A);
                        loadLocalOrConstant(prototype, javaBuilder, i5, GETARG_B);
                        loadLocalOrConstant(prototype, javaBuilder, i5, GETARG_C);
                        javaBuilder.setTable();
                        break;
                    case 9:
                        javaBuilder.storeUpvalue(i5, GETARG_B, GETARG_A);
                        break;
                    case 10:
                        javaBuilder.loadLocal(i5, GETARG_A);
                        loadLocalOrConstant(prototype, javaBuilder, i5, GETARG_B);
                        loadLocalOrConstant(prototype, javaBuilder, i5, GETARG_C);
                        javaBuilder.setTable();
                        break;
                    case 11:
                        javaBuilder.newTable(GETARG_B, GETARG_C);
                        javaBuilder.storeLocal(i5, GETARG_A);
                        break;
                    case 12:
                        javaBuilder.loadLocal(i5, GETARG_B);
                        javaBuilder.dup();
                        javaBuilder.storeLocal(i5, GETARG_A + 1);
                        loadLocalOrConstant(prototype, javaBuilder, i5, GETARG_C);
                        javaBuilder.getTable();
                        javaBuilder.storeLocal(i5, GETARG_A);
                        break;
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        loadLocalOrConstant(prototype, javaBuilder, i5, GETARG_B);
                        loadLocalOrConstant(prototype, javaBuilder, i5, GETARG_C);
                        javaBuilder.binaryop(GET_OPCODE);
                        javaBuilder.storeLocal(i5, GETARG_A);
                        break;
                    case 19:
                    case 20:
                    case 21:
                        javaBuilder.loadLocal(i5, GETARG_B);
                        javaBuilder.unaryop(GET_OPCODE);
                        javaBuilder.storeLocal(i5, GETARG_A);
                        break;
                    case 22:
                        for (int i8 = GETARG_B; i8 <= GETARG_C; i8++) {
                            javaBuilder.loadLocal(i5, i8);
                        }
                        if (GETARG_C > GETARG_B + 1) {
                            javaBuilder.tobuffer();
                            int i9 = GETARG_C;
                            while (true) {
                                i9--;
                                if (i9 >= GETARG_B) {
                                    javaBuilder.concatbuffer();
                                } else {
                                    javaBuilder.tovalue();
                                }
                            }
                        } else {
                            javaBuilder.concatvalue();
                        }
                        javaBuilder.storeLocal(i5, GETARG_A);
                        break;
                    case 23:
                        if (GETARG_A > 0) {
                            for (int i10 = GETARG_A - 1; i10 < protoInfo.openups.length; i10++) {
                                javaBuilder.closeUpvalue(i5, i10);
                            }
                        }
                        javaBuilder.addBranch(i5, 1, i5 + 1 + GETARG_sBx);
                        break;
                    case 24:
                    case 25:
                    case 26:
                        loadLocalOrConstant(prototype, javaBuilder, i5, GETARG_B);
                        loadLocalOrConstant(prototype, javaBuilder, i5, GETARG_C);
                        javaBuilder.compareop(GET_OPCODE);
                        javaBuilder.addBranch(i5, GETARG_A != 0 ? 3 : 2, i5 + 2);
                        break;
                    case 27:
                        javaBuilder.loadLocal(i5, GETARG_A);
                        javaBuilder.toBoolean();
                        javaBuilder.addBranch(i5, GETARG_C != 0 ? 3 : 2, i5 + 2);
                        break;
                    case 28:
                        javaBuilder.loadLocal(i5, GETARG_B);
                        javaBuilder.toBoolean();
                        javaBuilder.addBranch(i5, GETARG_C != 0 ? 3 : 2, i5 + 2);
                        javaBuilder.loadLocal(i5, GETARG_B);
                        javaBuilder.storeLocal(i5, GETARG_A);
                        break;
                    case 29:
                        javaBuilder.loadLocal(i5, GETARG_A);
                        int i11 = GETARG_B - 1;
                        switch (i11) {
                            case -1:
                                loadVarargResults(javaBuilder, i5, GETARG_A + 1, i);
                                i11 = -1;
                                break;
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                                for (int i12 = 1; i12 < GETARG_B; i12++) {
                                    javaBuilder.loadLocal(i5, GETARG_A + i12);
                                }
                                break;
                            default:
                                javaBuilder.newVarargs(i5, GETARG_A + 1, GETARG_B - 1);
                                i11 = -1;
                                break;
                        }
                        boolean z = i11 < 0 || GETARG_C < 1 || GETARG_C > 2;
                        if (z) {
                            javaBuilder.invoke(i11);
                        } else {
                            javaBuilder.call(i11);
                        }
                        switch (GETARG_C) {
                            case 0:
                                i = GETARG_A;
                                javaBuilder.storeVarresult();
                                break;
                            case 1:
                                javaBuilder.pop();
                                break;
                            case 2:
                                if (z) {
                                    javaBuilder.arg(1);
                                }
                                javaBuilder.storeLocal(i5, GETARG_A);
                                break;
                            default:
                                for (int i13 = 1; i13 < GETARG_C; i13++) {
                                    if (i13 + 1 < GETARG_C) {
                                        javaBuilder.dup();
                                    }
                                    javaBuilder.arg(i13);
                                    javaBuilder.storeLocal(i5, (GETARG_A + i13) - 1);
                                }
                                break;
                        }
                    case 30:
                        javaBuilder.loadLocal(i5, GETARG_A);
                        switch (GETARG_B) {
                            case 0:
                                loadVarargResults(javaBuilder, i5, GETARG_A + 1, i);
                                break;
                            case 1:
                                javaBuilder.loadNone();
                                break;
                            case 2:
                                javaBuilder.loadLocal(i5, GETARG_A + 1);
                                break;
                            default:
                                javaBuilder.newVarargs(i5, GETARG_A + 1, GETARG_B - 1);
                                break;
                        }
                        javaBuilder.newTailcallVarargs();
                        javaBuilder.areturn();
                        break;
                    case 31:
                        if (GETARG_C != 1) {
                            switch (GETARG_B) {
                                case 0:
                                    loadVarargResults(javaBuilder, i5, GETARG_A, i);
                                    break;
                                case 1:
                                    javaBuilder.loadNone();
                                    break;
                                case 2:
                                    javaBuilder.loadLocal(i5, GETARG_A);
                                    break;
                                default:
                                    javaBuilder.newVarargs(i5, GETARG_A, GETARG_B - 1);
                                    break;
                            }
                        } else {
                            javaBuilder.loadNone();
                        }
                        javaBuilder.areturn();
                        break;
                    case 32:
                        javaBuilder.loadLocal(i5, GETARG_A);
                        javaBuilder.loadLocal(i5, GETARG_A + 2);
                        javaBuilder.binaryop(13);
                        javaBuilder.dup();
                        javaBuilder.dup();
                        javaBuilder.storeLocal(i5, GETARG_A);
                        javaBuilder.storeLocal(i5, GETARG_A + 3);
                        javaBuilder.loadLocal(i5, GETARG_A + 1);
                        javaBuilder.loadLocal(i5, GETARG_A + 2);
                        javaBuilder.testForLoop();
                        javaBuilder.addBranch(i5, 2, i5 + 1 + GETARG_sBx);
                        break;
                    case 33:
                        javaBuilder.loadLocal(i5, GETARG_A);
                        javaBuilder.loadLocal(i5, GETARG_A + 2);
                        javaBuilder.binaryop(14);
                        javaBuilder.storeLocal(i5, GETARG_A);
                        javaBuilder.addBranch(i5, 1, i5 + 1 + GETARG_sBx);
                        break;
                    case 34:
                        javaBuilder.loadLocal(i5, GETARG_A);
                        javaBuilder.loadLocal(i5, GETARG_A + 1);
                        javaBuilder.loadLocal(i5, GETARG_A + 2);
                        javaBuilder.invoke(2);
                        for (int i14 = 1; i14 <= GETARG_C; i14++) {
                            if (i14 < GETARG_C) {
                                javaBuilder.dup();
                            }
                            javaBuilder.arg(i14);
                            javaBuilder.storeLocal(i5, GETARG_A + 2 + i14);
                        }
                        break;
                    case 35:
                        javaBuilder.loadLocal(i5, GETARG_A + 1);
                        javaBuilder.dup();
                        javaBuilder.storeLocal(i5, GETARG_A);
                        javaBuilder.isNil();
                        javaBuilder.addBranch(i5, 3, i5 + 1 + GETARG_sBx);
                        break;
                    case 36:
                        int i15 = ((GETARG_C - 1) * 50) + 1;
                        javaBuilder.loadLocal(i5, GETARG_A);
                        if (GETARG_B == 0) {
                            int i16 = i - (GETARG_A + 1);
                            if (i16 > 0) {
                                javaBuilder.setlistStack(i5, GETARG_A + 1, i15, i16);
                                i15 += i16;
                            }
                            javaBuilder.setlistVarargs(i15, i);
                            break;
                        } else {
                            javaBuilder.setlistStack(i5, GETARG_A + 1, i15, GETARG_B);
                            javaBuilder.pop();
                            break;
                        }
                    case 37:
                        Prototype prototype2 = prototype.f3296p[GETARG_Bx];
                        int length = prototype2.upvalues.length;
                        String str2 = protoInfo.subprotos[GETARG_Bx].name;
                        javaBuilder.closureCreate(str2);
                        if (length > 0) {
                            javaBuilder.dup();
                        }
                        javaBuilder.storeLocal(i5, GETARG_A);
                        for (int i17 = 0; i17 < length; i17++) {
                            if (i17 + 1 < length) {
                                javaBuilder.dup();
                            }
                            Upvaldesc upvaldesc = prototype2.upvalues[i17];
                            if (upvaldesc.instack) {
                                javaBuilder.closureInitUpvalueFromLocal(str2, i17, i5, upvaldesc.idx);
                            } else {
                                javaBuilder.closureInitUpvalueFromUpvalue(str2, i17, upvaldesc.idx);
                            }
                        }
                        break;
                    case 38:
                        if (GETARG_B == 0) {
                            javaBuilder.loadVarargs();
                            javaBuilder.storeVarresult();
                            i = GETARG_A;
                            break;
                        } else {
                            for (int i18 = 1; i18 < GETARG_B; i18++) {
                                javaBuilder.loadVarargs(i18);
                                javaBuilder.storeLocal(i5, GETARG_A);
                                GETARG_A++;
                            }
                            break;
                        }
                }
                javaBuilder.onEndOfLuaInstruction(i5, i7);
                i5++;
            }
        }
    }

    private void loadVarargResults(JavaBuilder javaBuilder, int i, int i2, int i3) {
        if (i3 <= i2) {
            javaBuilder.loadVarresult();
            javaBuilder.subargs((i2 + 1) - i3);
        } else if (i3 == i2) {
            javaBuilder.loadVarresult();
        } else {
            javaBuilder.newVarargsVarresult(i, i2, i3 - i2);
        }
    }

    private void loadLocalOrConstant(Prototype prototype, JavaBuilder javaBuilder, int i, int i2) {
        if (i2 <= 255) {
            javaBuilder.loadLocal(i, i2);
        } else {
            javaBuilder.loadConstant(prototype.f3295k[i2 & 255]);
        }
    }
}
