package org.luaj.vm2.lib;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import p001ch.qos.logback.core.pattern.parser.Parser;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/Bit32Lib.class */
public class Bit32Lib extends TwoArgFunction {
    static Class class$org$luaj$vm2$lib$Bit32Lib$Bit32LibV;
    static Class class$org$luaj$vm2$lib$Bit32Lib$Bit32Lib2;

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/Bit32Lib$Bit32Lib2.class */
    static final class Bit32Lib2 extends TwoArgFunction {
        Bit32Lib2() {
        }

        @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
            switch (this.opcode) {
                case 0:
                    return Bit32Lib.arshift(luaValue.checkint(), luaValue2.checkint());
                case 1:
                    return Bit32Lib.lrotate(luaValue.checkint(), luaValue2.checkint());
                case 2:
                    return Bit32Lib.lshift(luaValue.checkint(), luaValue2.checkint());
                case 3:
                    return Bit32Lib.rrotate(luaValue.checkint(), luaValue2.checkint());
                case 4:
                    return Bit32Lib.rshift(luaValue.checkint(), luaValue2.checkint());
                default:
                    return NIL;
            }
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/Bit32Lib$Bit32LibV.class */
    static final class Bit32LibV extends VarArgFunction {
        Bit32LibV() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            switch (this.opcode) {
                case 0:
                    return Bit32Lib.band(varargs);
                case 1:
                    return Bit32Lib.bnot(varargs);
                case 2:
                    return Bit32Lib.bor(varargs);
                case 3:
                    return Bit32Lib.btest(varargs);
                case 4:
                    return Bit32Lib.bxor(varargs);
                case 5:
                    return Bit32Lib.extract(varargs.checkint(1), varargs.checkint(2), varargs.optint(3, 1));
                case 6:
                    return Bit32Lib.replace(varargs.checkint(1), varargs.checkint(2), varargs.checkint(3), varargs.optint(4, 1));
                default:
                    return NIL;
            }
        }
    }

    @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        Class cls;
        Class cls2;
        LuaTable luaTable = new LuaTable();
        if (class$org$luaj$vm2$lib$Bit32Lib$Bit32LibV == null) {
            cls = class$("org.luaj.vm2.lib.Bit32Lib$Bit32LibV");
            class$org$luaj$vm2$lib$Bit32Lib$Bit32LibV = cls;
        } else {
            cls = class$org$luaj$vm2$lib$Bit32Lib$Bit32LibV;
        }
        bind(luaTable, cls, new String[]{"band", "bnot", "bor", "btest", "bxor", "extract", Parser.REPLACE_CONVERTER_WORD});
        if (class$org$luaj$vm2$lib$Bit32Lib$Bit32Lib2 == null) {
            cls2 = class$("org.luaj.vm2.lib.Bit32Lib$Bit32Lib2");
            class$org$luaj$vm2$lib$Bit32Lib$Bit32Lib2 = cls2;
        } else {
            cls2 = class$org$luaj$vm2$lib$Bit32Lib$Bit32Lib2;
        }
        bind(luaTable, cls2, new String[]{"arshift", "lrotate", "lshift", "rrotate", "rshift"});
        luaValue2.set("bit32", luaTable);
        luaValue2.get("package").get("loaded").set("bit32", luaTable);
        return luaTable;
    }

    static LuaValue arshift(int i, int i2) {
        return i2 >= 0 ? bitsToValue(i >> i2) : bitsToValue(i << (-i2));
    }

    static LuaValue rshift(int i, int i2) {
        return (i2 >= 32 || i2 <= -32) ? ZERO : i2 >= 0 ? bitsToValue(i >>> i2) : bitsToValue(i << (-i2));
    }

    static LuaValue lshift(int i, int i2) {
        return (i2 >= 32 || i2 <= -32) ? ZERO : i2 >= 0 ? bitsToValue(i << i2) : bitsToValue(i >>> (-i2));
    }

    static Varargs band(Varargs varargs) {
        int i = -1;
        for (int i2 = 1; i2 <= varargs.narg(); i2++) {
            i &= varargs.checkint(i2);
        }
        return bitsToValue(i);
    }

    static Varargs bnot(Varargs varargs) {
        return bitsToValue(varargs.checkint(1) ^ -1);
    }

    static Varargs bor(Varargs varargs) {
        int i = 0;
        for (int i2 = 1; i2 <= varargs.narg(); i2++) {
            i |= varargs.checkint(i2);
        }
        return bitsToValue(i);
    }

    static Varargs btest(Varargs varargs) {
        int i = -1;
        for (int i2 = 1; i2 <= varargs.narg(); i2++) {
            i &= varargs.checkint(i2);
        }
        return valueOf(i != 0);
    }

    static Varargs bxor(Varargs varargs) {
        int i = 0;
        for (int i2 = 1; i2 <= varargs.narg(); i2++) {
            i ^= varargs.checkint(i2);
        }
        return bitsToValue(i);
    }

    static LuaValue lrotate(int i, int i2) {
        if (i2 < 0) {
            return rrotate(i, -i2);
        }
        int i3 = i2 & 31;
        return bitsToValue((i << i3) | (i >>> (32 - i3)));
    }

    static LuaValue rrotate(int i, int i2) {
        if (i2 < 0) {
            return lrotate(i, -i2);
        }
        int i3 = i2 & 31;
        return bitsToValue((i >>> i3) | (i << (32 - i3)));
    }

    static LuaValue extract(int i, int i2, int i3) {
        if (i2 < 0) {
            argerror(2, "field cannot be negative");
        }
        if (i3 < 0) {
            argerror(3, "width must be postive");
        }
        if (i2 + i3 > 32) {
            error("trying to access non-existent bits");
        }
        return bitsToValue((i >>> i2) & (-1 >>> (32 - i3)));
    }

    static LuaValue replace(int i, int i2, int i3, int i4) {
        if (i3 < 0) {
            argerror(3, "field cannot be negative");
        }
        if (i4 < 0) {
            argerror(4, "width must be postive");
        }
        if (i3 + i4 > 32) {
            error("trying to access non-existent bits");
        }
        int i5 = (-1 >>> (32 - i4)) << i3;
        return bitsToValue((i & (i5 ^ -1)) | ((i2 << i3) & i5));
    }

    private static LuaValue bitsToValue(int i) {
        return i < 0 ? valueOf((double) (((long) i) & 4294967295L)) : valueOf(i);
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }
}
