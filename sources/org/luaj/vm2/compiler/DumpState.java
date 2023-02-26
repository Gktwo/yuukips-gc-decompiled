package org.luaj.vm2.compiler;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.luaj.vm2.LoadState;
import org.luaj.vm2.LocVars;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Prototype;

/* loaded from: grasscutter.jar:org/luaj/vm2/compiler/DumpState.class */
public class DumpState {
    public static boolean ALLOW_INTEGER_CASTING = false;
    public static final int NUMBER_FORMAT_FLOATS_OR_DOUBLES = 0;
    public static final int NUMBER_FORMAT_INTS_ONLY = 1;
    public static final int NUMBER_FORMAT_NUM_PATCH_INT32 = 4;
    public static final int NUMBER_FORMAT_DEFAULT = 0;
    private static final int SIZEOF_INT = 4;
    private static final int SIZEOF_SIZET = 4;
    private static final int SIZEOF_INSTRUCTION = 4;
    DataOutputStream writer;
    boolean strip;
    private boolean IS_LITTLE_ENDIAN = false;
    private int NUMBER_FORMAT = 0;
    private int SIZEOF_LUA_NUMBER = 8;
    int status = 0;

    public DumpState(OutputStream outputStream, boolean z) {
        this.writer = new DataOutputStream(outputStream);
        this.strip = z;
    }

    void dumpBlock(byte[] bArr, int i) throws IOException {
        this.writer.write(bArr, 0, i);
    }

    void dumpChar(int i) throws IOException {
        this.writer.write(i);
    }

    void dumpInt(int i) throws IOException {
        if (this.IS_LITTLE_ENDIAN) {
            this.writer.writeByte(i & 255);
            this.writer.writeByte((i >> 8) & 255);
            this.writer.writeByte((i >> 16) & 255);
            this.writer.writeByte((i >> 24) & 255);
            return;
        }
        this.writer.writeInt(i);
    }

    void dumpString(LuaString luaString) throws IOException {
        int i = luaString.len().toint();
        dumpInt(i + 1);
        luaString.write(this.writer, 0, i);
        this.writer.write(0);
    }

    void dumpDouble(double d) throws IOException {
        long doubleToLongBits = Double.doubleToLongBits(d);
        if (this.IS_LITTLE_ENDIAN) {
            dumpInt((int) doubleToLongBits);
            dumpInt((int) (doubleToLongBits >> 32));
            return;
        }
        this.writer.writeLong(doubleToLongBits);
    }

    void dumpCode(Prototype prototype) throws IOException {
        int[] iArr = prototype.code;
        int length = iArr.length;
        dumpInt(length);
        for (int i : iArr) {
            dumpInt(i);
        }
    }

    void dumpConstants(Prototype prototype) throws IOException {
        LuaValue[] luaValueArr = prototype.f3259k;
        int length = luaValueArr.length;
        dumpInt(length);
        for (LuaValue luaValue : luaValueArr) {
            switch (luaValue.type()) {
                case 0:
                    this.writer.write(0);
                    break;
                case 1:
                    this.writer.write(1);
                    dumpChar(luaValue.toboolean() ? 1 : 0);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException(new StringBuffer().append("bad type for ").append(luaValue).toString());
                case 3:
                    switch (this.NUMBER_FORMAT) {
                        case 0:
                            this.writer.write(3);
                            dumpDouble(luaValue.todouble());
                            continue;
                        case 1:
                            if (ALLOW_INTEGER_CASTING || luaValue.isint()) {
                                this.writer.write(3);
                                dumpInt(luaValue.toint());
                                continue;
                            } else {
                                throw new IllegalArgumentException(new StringBuffer().append("not an integer: ").append(luaValue).toString());
                            }
                        case 2:
                        case 3:
                        default:
                            throw new IllegalArgumentException(new StringBuffer().append("number format not supported: ").append(this.NUMBER_FORMAT).toString());
                        case 4:
                            if (!luaValue.isint()) {
                                this.writer.write(3);
                                dumpDouble(luaValue.todouble());
                                break;
                            } else {
                                this.writer.write(-2);
                                dumpInt(luaValue.toint());
                                continue;
                            }
                    }
                case 4:
                    this.writer.write(4);
                    dumpString((LuaString) luaValue);
                    break;
            }
        }
        int length2 = prototype.f3260p.length;
        dumpInt(length2);
        for (int i = 0; i < length2; i++) {
            dumpFunction(prototype.f3260p[i]);
        }
    }

    void dumpUpvalues(Prototype prototype) throws IOException {
        int length = prototype.upvalues.length;
        dumpInt(length);
        for (int i = 0; i < length; i++) {
            this.writer.writeByte(prototype.upvalues[i].instack ? 1 : 0);
            this.writer.writeByte(prototype.upvalues[i].idx);
        }
    }

    void dumpDebug(Prototype prototype) throws IOException {
        if (this.strip) {
            dumpInt(0);
        } else {
            dumpString(prototype.source);
        }
        int length = this.strip ? 0 : prototype.lineinfo.length;
        dumpInt(length);
        for (int i = 0; i < length; i++) {
            dumpInt(prototype.lineinfo[i]);
        }
        int length2 = this.strip ? 0 : prototype.locvars.length;
        dumpInt(length2);
        for (int i2 = 0; i2 < length2; i2++) {
            LocVars locVars = prototype.locvars[i2];
            dumpString(locVars.varname);
            dumpInt(locVars.startpc);
            dumpInt(locVars.endpc);
        }
        int length3 = this.strip ? 0 : prototype.upvalues.length;
        dumpInt(length3);
        for (int i3 = 0; i3 < length3; i3++) {
            dumpString(prototype.upvalues[i3].name);
        }
    }

    void dumpFunction(Prototype prototype) throws IOException {
        dumpInt(prototype.linedefined);
        dumpInt(prototype.lastlinedefined);
        dumpChar(prototype.numparams);
        dumpChar(prototype.is_vararg);
        dumpChar(prototype.maxstacksize);
        dumpCode(prototype);
        dumpConstants(prototype);
        dumpUpvalues(prototype);
        dumpDebug(prototype);
    }

    void dumpHeader() throws IOException {
        this.writer.write(LoadState.LUA_SIGNATURE);
        this.writer.write(82);
        this.writer.write(0);
        this.writer.write(this.IS_LITTLE_ENDIAN ? 1 : 0);
        this.writer.write(4);
        this.writer.write(4);
        this.writer.write(4);
        this.writer.write(this.SIZEOF_LUA_NUMBER);
        this.writer.write(this.NUMBER_FORMAT);
        this.writer.write(LoadState.LUAC_TAIL);
    }

    public static int dump(Prototype prototype, OutputStream outputStream, boolean z) throws IOException {
        DumpState dumpState = new DumpState(outputStream, z);
        dumpState.dumpHeader();
        dumpState.dumpFunction(prototype);
        return dumpState.status;
    }

    public static int dump(Prototype prototype, OutputStream outputStream, boolean z, int i, boolean z2) throws IOException {
        switch (i) {
            case 0:
            case 1:
            case 4:
                DumpState dumpState = new DumpState(outputStream, z);
                dumpState.IS_LITTLE_ENDIAN = z2;
                dumpState.NUMBER_FORMAT = i;
                dumpState.SIZEOF_LUA_NUMBER = i == 1 ? 4 : 8;
                dumpState.dumpHeader();
                dumpState.dumpFunction(prototype);
                return dumpState.status;
            case 2:
            case 3:
            default:
                throw new IllegalArgumentException(new StringBuffer().append("number format not supported: ").append(i).toString());
        }
    }
}
