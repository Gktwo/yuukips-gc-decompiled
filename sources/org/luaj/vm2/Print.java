package org.luaj.vm2;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.jline.reader.LineReader;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/luaj/vm2/Print.class */
public class Print extends Lua {
    private static final String STRING_FOR_NULL = "null";

    /* renamed from: ps */
    public static PrintStream f3294ps = System.out;
    public static final String[] OPNAMES = {"MOVE", "LOADK", "LOADKX", "LOADBOOL", "LOADNIL", "GETUPVAL", "GETTABUP", "GETTABLE", "SETTABUP", "SETUPVAL", "SETTABLE", "NEWTABLE", "SELF", "ADD", "SUB", "MUL", "DIV", "MOD", "POW", "UNM", "NOT", "LEN", "CONCAT", "JMP", "EQ", "LT", "LE", "TEST", "TESTSET", "CALL", "TAILCALL", "RETURN", "FORLOOP", "FORPREP", "TFORCALL", "TFORLOOP", "SETLIST", "CLOSURE", "VARARG", "EXTRAARG", null};

    static void printString(PrintStream printStream, LuaString luaString) {
        printStream.print('\"');
        int i = luaString.m_length;
        for (int i2 = 0; i2 < i; i2++) {
            byte b = luaString.m_bytes[luaString.m_offset + i2];
            if (b < 32 || b > 126 || b == 34 || b == 92) {
                switch (b) {
                    case 7:
                        printStream.print("\\a");
                        continue;
                    case 8:
                        printStream.print("\\b");
                        continue;
                    case 9:
                        printStream.print("\\t");
                        continue;
                    case 10:
                        printStream.print("\\n");
                        continue;
                    case 11:
                        printStream.print("\\v");
                        continue;
                    case 12:
                        printStream.print("\\f");
                        continue;
                    case 13:
                        printStream.print("\\r");
                        continue;
                    case 34:
                        printStream.print("\\\"");
                        continue;
                    case 92:
                        printStream.print("\\\\");
                        continue;
                    default:
                        printStream.print('\\');
                        printStream.print(Integer.toString(1255 & b).substring(1));
                        continue;
                }
            } else {
                printStream.print((char) b);
            }
        }
        printStream.print('\"');
    }

    static void printValue(PrintStream printStream, LuaValue luaValue) {
        switch (luaValue.type()) {
            case 4:
                printString(printStream, (LuaString) luaValue);
                return;
            default:
                printStream.print(luaValue.tojstring());
                return;
        }
    }

    static void printConstant(PrintStream printStream, Prototype prototype, int i) {
        printValue(printStream, prototype.f3295k[i]);
    }

    static void printUpvalue(PrintStream printStream, Upvaldesc upvaldesc) {
        printStream.print(new StringBuffer().append((int) upvaldesc.idx).append(" ").toString());
        printValue(printStream, upvaldesc.name);
    }

    public static void printCode(Prototype prototype) {
        int length = prototype.code.length;
        for (int i = 0; i < length; i++) {
            printOpCode(prototype, i);
            f3294ps.println();
        }
    }

    public static void printOpCode(Prototype prototype, int i) {
        printOpCode(f3294ps, prototype, i);
    }

    public static void printOpCode(PrintStream printStream, Prototype prototype, int i) {
        int[] iArr = prototype.code;
        int i2 = iArr[i];
        int GET_OPCODE = GET_OPCODE(i2);
        int GETARG_A = GETARG_A(i2);
        int GETARG_B = GETARG_B(i2);
        int GETARG_C = GETARG_C(i2);
        int GETARG_Bx = GETARG_Bx(i2);
        int GETARG_sBx = GETARG_sBx(i2);
        int i3 = getline(prototype, i);
        printStream.print(new StringBuffer().append("  ").append(i + 1).append("  ").toString());
        if (i3 > 0) {
            printStream.print(new StringBuffer().append("[").append(i3).append("]  ").toString());
        } else {
            printStream.print("[-]  ");
        }
        printStream.print(new StringBuffer().append(OPNAMES[GET_OPCODE]).append("  ").toString());
        switch (getOpMode(GET_OPCODE)) {
            case 0:
                printStream.print(GETARG_A);
                if (getBMode(GET_OPCODE) != 0) {
                    printStream.print(new StringBuffer().append(" ").append(ISK(GETARG_B) ? -1 - INDEXK(GETARG_B) : GETARG_B).toString());
                }
                if (getCMode(GET_OPCODE) != 0) {
                    printStream.print(new StringBuffer().append(" ").append(ISK(GETARG_C) ? -1 - INDEXK(GETARG_C) : GETARG_C).toString());
                    break;
                }
                break;
            case 1:
                if (getBMode(GET_OPCODE) != 3) {
                    printStream.print(new StringBuffer().append(GETARG_A).append(" ").append(GETARG_Bx).toString());
                    break;
                } else {
                    printStream.print(new StringBuffer().append(GETARG_A).append(" ").append(-1 - GETARG_Bx).toString());
                    break;
                }
            case 2:
                if (GET_OPCODE != 23) {
                    printStream.print(new StringBuffer().append(GETARG_A).append(" ").append(GETARG_sBx).toString());
                    break;
                } else {
                    printStream.print(GETARG_sBx);
                    break;
                }
        }
        switch (GET_OPCODE) {
            case 1:
                printStream.print("  ; ");
                printConstant(printStream, prototype, GETARG_Bx);
                return;
            case 2:
            case 3:
            case 4:
            case 11:
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 34:
            case 35:
            default:
                return;
            case 5:
            case 9:
                printStream.print("  ; ");
                printUpvalue(printStream, prototype.upvalues[GETARG_B]);
                return;
            case 6:
                printStream.print("  ; ");
                printUpvalue(printStream, prototype.upvalues[GETARG_B]);
                printStream.print(" ");
                if (ISK(GETARG_C)) {
                    printConstant(printStream, prototype, INDEXK(GETARG_C));
                    return;
                } else {
                    printStream.print("-");
                    return;
                }
            case 7:
            case 12:
                if (ISK(GETARG_C)) {
                    printStream.print("  ; ");
                    printConstant(printStream, prototype, INDEXK(GETARG_C));
                    return;
                }
                return;
            case 8:
                printStream.print("  ; ");
                printUpvalue(printStream, prototype.upvalues[GETARG_A]);
                printStream.print(" ");
                if (ISK(GETARG_B)) {
                    printConstant(printStream, prototype, INDEXK(GETARG_B));
                } else {
                    printStream.print("-");
                }
                printStream.print(" ");
                if (ISK(GETARG_C)) {
                    printConstant(printStream, prototype, INDEXK(GETARG_C));
                    return;
                } else {
                    printStream.print("-");
                    return;
                }
            case 10:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 24:
            case 25:
            case 26:
                if (ISK(GETARG_B) || ISK(GETARG_C)) {
                    printStream.print("  ; ");
                    if (ISK(GETARG_B)) {
                        printConstant(printStream, prototype, INDEXK(GETARG_B));
                    } else {
                        printStream.print("-");
                    }
                    printStream.print(" ");
                    if (ISK(GETARG_C)) {
                        printConstant(printStream, prototype, INDEXK(GETARG_C));
                        return;
                    } else {
                        printStream.print("-");
                        return;
                    }
                } else {
                    return;
                }
            case 23:
            case 32:
            case 33:
                printStream.print(new StringBuffer().append("  ; to ").append(GETARG_sBx + i + 2).toString());
                return;
            case 36:
                if (GETARG_C == 0) {
                    printStream.print(new StringBuffer().append("  ; ").append(iArr[i + 1]).toString());
                    return;
                } else {
                    printStream.print(new StringBuffer().append("  ; ").append(GETARG_C).toString());
                    return;
                }
            case 37:
                printStream.print(new StringBuffer().append("  ; ").append(prototype.f3296p[GETARG_Bx].getClass().getName()).toString());
                return;
            case 38:
                printStream.print(new StringBuffer().append("  ; is_vararg=").append(prototype.is_vararg).toString());
                return;
        }
    }

    private static int getline(Prototype prototype, int i) {
        if (i <= 0 || prototype.lineinfo == null || i >= prototype.lineinfo.length) {
            return -1;
        }
        return prototype.lineinfo[i];
    }

    static void printHeader(Prototype prototype) {
        String valueOf = String.valueOf(prototype.source);
        f3294ps.print(new StringBuffer().append("\n%").append(prototype.linedefined == 0 ? LineReader.MAIN : "function").append(" <").append((valueOf.startsWith("@") || valueOf.startsWith("=")) ? valueOf.substring(1) : "\u001bLua".equals(valueOf) ? "(bstring)" : "(string)").append(EmitterKt.COMMENT_PREFIX).append(prototype.linedefined).append(",").append(prototype.lastlinedefined).append("> (").append(prototype.code.length).append(" instructions, ").append(prototype.code.length * 4).append(" bytes at ").append(m16id(prototype)).append(")\n").toString());
        f3294ps.print(new StringBuffer().append(prototype.numparams).append(" param, ").append(prototype.maxstacksize).append(" slot, ").append(prototype.upvalues.length).append(" upvalue, ").toString());
        f3294ps.print(new StringBuffer().append(prototype.locvars.length).append(" local, ").append(prototype.f3295k.length).append(" constant, ").append(prototype.f3296p.length).append(" function\n").toString());
    }

    static void printConstants(Prototype prototype) {
        int length = prototype.f3295k.length;
        f3294ps.print(new StringBuffer().append("constants (").append(length).append(") for ").append(m16id(prototype)).append(":\n").toString());
        for (int i = 0; i < length; i++) {
            f3294ps.print(new StringBuffer().append("  ").append(i + 1).append("  ").toString());
            printValue(f3294ps, prototype.f3295k[i]);
            f3294ps.print("\n");
        }
    }

    static void printLocals(Prototype prototype) {
        int length = prototype.locvars.length;
        f3294ps.print(new StringBuffer().append("locals (").append(length).append(") for ").append(m16id(prototype)).append(":\n").toString());
        for (int i = 0; i < length; i++) {
            f3294ps.println(new StringBuffer().append("  ").append(i).append("  ").append(prototype.locvars[i].varname).append(" ").append(prototype.locvars[i].startpc + 1).append(" ").append(prototype.locvars[i].endpc + 1).toString());
        }
    }

    static void printUpValues(Prototype prototype) {
        int length = prototype.upvalues.length;
        f3294ps.print(new StringBuffer().append("upvalues (").append(length).append(") for ").append(m16id(prototype)).append(":\n").toString());
        for (int i = 0; i < length; i++) {
            f3294ps.print(new StringBuffer().append("  ").append(i).append("  ").append(prototype.upvalues[i]).append("\n").toString());
        }
    }

    public static void print(Prototype prototype) {
        printFunction(prototype, true);
    }

    public static void printFunction(Prototype prototype, boolean z) {
        int length = prototype.f3296p.length;
        printHeader(prototype);
        printCode(prototype);
        if (z) {
            printConstants(prototype);
            printLocals(prototype);
            printUpValues(prototype);
        }
        for (int i = 0; i < length; i++) {
            printFunction(prototype.f3296p[i], z);
        }
    }

    private static void format(String str, int i) {
        int length = str.length();
        if (length > i) {
            f3294ps.print(str.substring(0, i));
            return;
        }
        f3294ps.print(str);
        int i2 = i - length;
        while (true) {
            i2--;
            if (i2 >= 0) {
                f3294ps.print(' ');
            } else {
                return;
            }
        }
    }

    /* renamed from: id */
    private static String m16id(Prototype prototype) {
        return "Proto";
    }

    private void _assert(boolean z) {
        if (!z) {
            throw new NullPointerException("_assert failed");
        }
    }

    public static void printState(LuaClosure luaClosure, int i, LuaValue[] luaValueArr, int i2, Varargs varargs) {
        PrintStream printStream = f3294ps;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        f3294ps = new PrintStream(byteArrayOutputStream);
        printOpCode(luaClosure.f3287p, i);
        f3294ps.flush();
        f3294ps.close();
        f3294ps = printStream;
        format(byteArrayOutputStream.toString(), 50);
        printStack(luaValueArr, i2, varargs);
        f3294ps.println();
    }

    public static void printStack(LuaValue[] luaValueArr, int i, Varargs varargs) {
        f3294ps.print('[');
        for (int i2 = 0; i2 < luaValueArr.length; i2++) {
            LuaValue luaValue = luaValueArr[i2];
            if (luaValue != null) {
                switch (luaValue.type()) {
                    case 4:
                        LuaString checkstring = luaValue.checkstring();
                        f3294ps.print(checkstring.length() < 48 ? checkstring.tojstring() : new StringBuffer().append(checkstring.substring(0, 32).tojstring()).append("...+").append(checkstring.length() - 32).append("b").toString());
                        break;
                    case 5:
                    default:
                        f3294ps.print(luaValue.tojstring());
                        break;
                    case 6:
                        f3294ps.print(luaValue.tojstring());
                        break;
                    case 7:
                        Object obj = luaValue.touserdata();
                        if (obj != null) {
                            String name = obj.getClass().getName();
                            f3294ps.print(new StringBuffer().append(name.substring(name.lastIndexOf(46) + 1)).append(": ").append(Integer.toHexString(obj.hashCode())).toString());
                            break;
                        } else {
                            f3294ps.print(luaValue.toString());
                            break;
                        }
                }
            } else {
                f3294ps.print(STRING_FOR_NULL);
            }
            if (i2 + 1 == i) {
                f3294ps.print(']');
            }
            f3294ps.print(" | ");
        }
        f3294ps.print(varargs);
    }
}
