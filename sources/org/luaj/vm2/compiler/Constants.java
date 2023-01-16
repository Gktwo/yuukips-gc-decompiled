package org.luaj.vm2.compiler;

import org.luaj.vm2.LocVars;
import org.luaj.vm2.Lua;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Prototype;
import org.luaj.vm2.Upvaldesc;
import org.luaj.vm2.compiler.LexState;

/* loaded from: grasscutter.jar:org/luaj/vm2/compiler/Constants.class */
public class Constants extends Lua {
    public static final int MAXSTACK = 250;
    static final int LUAI_MAXUPVAL = 255;
    static final int LUAI_MAXVARS = 200;
    static final int NO_REG = 255;
    static final int iABC = 0;
    static final int iABx = 1;
    static final int iAsBx = 2;
    static final int OpArgN = 0;
    static final int OpArgU = 1;
    static final int OpArgR = 2;
    static final int OpArgK = 3;

    protected static void _assert(boolean z) {
        if (!z) {
            throw new LuaError("compiler assert failed");
        }
    }

    static void SET_OPCODE(InstructionPtr instructionPtr, int i) {
        instructionPtr.set((instructionPtr.get() & -64) | ((i << 0) & 63));
    }

    static void SETARG_A(int[] iArr, int i, int i2) {
        iArr[i] = (iArr[i] & Lua.MASK_NOT_A) | ((i2 << 6) & Lua.MASK_A);
    }

    static void SETARG_A(InstructionPtr instructionPtr, int i) {
        instructionPtr.set((instructionPtr.get() & Lua.MASK_NOT_A) | ((i << 6) & Lua.MASK_A));
    }

    static void SETARG_B(InstructionPtr instructionPtr, int i) {
        instructionPtr.set((instructionPtr.get() & Lua.MASK_NOT_B) | ((i << 23) & Lua.MASK_B));
    }

    static void SETARG_C(InstructionPtr instructionPtr, int i) {
        instructionPtr.set((instructionPtr.get() & Lua.MASK_NOT_C) | ((i << 14) & Lua.MASK_C));
    }

    static void SETARG_Bx(InstructionPtr instructionPtr, int i) {
        instructionPtr.set((instructionPtr.get() & Lua.MASK_NOT_Bx) | ((i << 14) & Lua.MASK_Bx));
    }

    static void SETARG_sBx(InstructionPtr instructionPtr, int i) {
        SETARG_Bx(instructionPtr, i + Lua.MAXARG_sBx);
    }

    static int CREATE_ABC(int i, int i2, int i3, int i4) {
        return ((i << 0) & 63) | ((i2 << 6) & Lua.MASK_A) | ((i3 << 23) & Lua.MASK_B) | ((i4 << 14) & Lua.MASK_C);
    }

    static int CREATE_ABx(int i, int i2, int i3) {
        return ((i << 0) & 63) | ((i2 << 6) & Lua.MASK_A) | ((i3 << 14) & Lua.MASK_Bx);
    }

    static LuaValue[] realloc(LuaValue[] luaValueArr, int i) {
        LuaValue[] luaValueArr2 = new LuaValue[i];
        if (luaValueArr != null) {
            System.arraycopy(luaValueArr, 0, luaValueArr2, 0, Math.min(luaValueArr.length, i));
        }
        return luaValueArr2;
    }

    static Prototype[] realloc(Prototype[] prototypeArr, int i) {
        Prototype[] prototypeArr2 = new Prototype[i];
        if (prototypeArr != null) {
            System.arraycopy(prototypeArr, 0, prototypeArr2, 0, Math.min(prototypeArr.length, i));
        }
        return prototypeArr2;
    }

    static LuaString[] realloc(LuaString[] luaStringArr, int i) {
        LuaString[] luaStringArr2 = new LuaString[i];
        if (luaStringArr != null) {
            System.arraycopy(luaStringArr, 0, luaStringArr2, 0, Math.min(luaStringArr.length, i));
        }
        return luaStringArr2;
    }

    static LocVars[] realloc(LocVars[] locVarsArr, int i) {
        LocVars[] locVarsArr2 = new LocVars[i];
        if (locVarsArr != null) {
            System.arraycopy(locVarsArr, 0, locVarsArr2, 0, Math.min(locVarsArr.length, i));
        }
        return locVarsArr2;
    }

    static Upvaldesc[] realloc(Upvaldesc[] upvaldescArr, int i) {
        Upvaldesc[] upvaldescArr2 = new Upvaldesc[i];
        if (upvaldescArr != null) {
            System.arraycopy(upvaldescArr, 0, upvaldescArr2, 0, Math.min(upvaldescArr.length, i));
        }
        return upvaldescArr2;
    }

    static LexState.Vardesc[] realloc(LexState.Vardesc[] vardescArr, int i) {
        LexState.Vardesc[] vardescArr2 = new LexState.Vardesc[i];
        if (vardescArr != null) {
            System.arraycopy(vardescArr, 0, vardescArr2, 0, Math.min(vardescArr.length, i));
        }
        return vardescArr2;
    }

    static LexState.Labeldesc[] grow(LexState.Labeldesc[] labeldescArr, int i) {
        return labeldescArr == null ? new LexState.Labeldesc[2] : labeldescArr.length < i ? realloc(labeldescArr, labeldescArr.length * 2) : labeldescArr;
    }

    static LexState.Labeldesc[] realloc(LexState.Labeldesc[] labeldescArr, int i) {
        LexState.Labeldesc[] labeldescArr2 = new LexState.Labeldesc[i];
        if (labeldescArr != null) {
            System.arraycopy(labeldescArr, 0, labeldescArr2, 0, Math.min(labeldescArr.length, i));
        }
        return labeldescArr2;
    }

    static int[] realloc(int[] iArr, int i) {
        int[] iArr2 = new int[i];
        if (iArr != null) {
            System.arraycopy(iArr, 0, iArr2, 0, Math.min(iArr.length, i));
        }
        return iArr2;
    }

    static byte[] realloc(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        if (bArr != null) {
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
        }
        return bArr2;
    }

    static char[] realloc(char[] cArr, int i) {
        char[] cArr2 = new char[i];
        if (cArr != null) {
            System.arraycopy(cArr, 0, cArr2, 0, Math.min(cArr.length, i));
        }
        return cArr2;
    }
}
