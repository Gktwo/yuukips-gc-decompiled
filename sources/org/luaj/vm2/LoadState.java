package org.luaj.vm2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.LongCompanionObject;
import org.luaj.vm2.Globals;

/* loaded from: grasscutter.jar:org/luaj/vm2/LoadState.class */
public class LoadState {
    public static final int NUMBER_FORMAT_FLOATS_OR_DOUBLES = 0;
    public static final int NUMBER_FORMAT_INTS_ONLY = 1;
    public static final int NUMBER_FORMAT_NUM_PATCH_INT32 = 4;
    public static final int LUA_TINT = -2;
    public static final int LUA_TNONE = -1;
    public static final int LUA_TNIL = 0;
    public static final int LUA_TBOOLEAN = 1;
    public static final int LUA_TLIGHTUSERDATA = 2;
    public static final int LUA_TNUMBER = 3;
    public static final int LUA_TSTRING = 4;
    public static final int LUA_TTABLE = 5;
    public static final int LUA_TFUNCTION = 6;
    public static final int LUA_TUSERDATA = 7;
    public static final int LUA_TTHREAD = 8;
    public static final int LUA_TVALUE = 9;
    public static final String SOURCE_BINARY_STRING = "binary string";
    public static final int LUAC_VERSION = 82;
    public static final int LUAC_FORMAT = 0;
    public static final int LUAC_HEADERSIZE = 12;
    private int luacVersion;
    private int luacFormat;
    private boolean luacLittleEndian;
    private int luacSizeofInt;
    private int luacSizeofSizeT;
    private int luacSizeofInstruction;
    private int luacSizeofLuaNumber;
    private int luacNumberFormat;

    /* renamed from: is */
    public final DataInputStream f3285is;
    String name;
    private byte[] buf = new byte[512];
    public static final Globals.Undumper instance = new GlobalsUndumper(null);
    public static String encoding = null;
    public static final byte[] LUA_SIGNATURE = {27, 76, 117, 97};
    public static final byte[] LUAC_TAIL = {25, -109, 13, 10, 26, 10};
    private static final LuaValue[] NOVALUES = new LuaValue[0];
    private static final Prototype[] NOPROTOS = new Prototype[0];
    private static final LocVars[] NOLOCVARS = new LocVars[0];
    private static final LuaString[] NOSTRVALUES = new LuaString[0];
    private static final Upvaldesc[] NOUPVALDESCS = new Upvaldesc[0];
    private static final int[] NOINTS = new int[0];

    /* renamed from: org.luaj.vm2.LoadState$1 */
    /* loaded from: grasscutter.jar:org/luaj/vm2/LoadState$1.class */
    static class C58631 {
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/LoadState$GlobalsUndumper.class */
    private static final class GlobalsUndumper implements Globals.Undumper {
        private GlobalsUndumper() {
        }

        @Override // org.luaj.vm2.Globals.Undumper
        public Prototype undump(InputStream inputStream, String str) throws IOException {
            return LoadState.undump(inputStream, str);
        }

        GlobalsUndumper(C58631 r3) {
            this();
        }
    }

    public static void install(Globals globals) {
        globals.undumper = instance;
    }

    int loadInt() throws IOException {
        this.f3285is.readFully(this.buf, 0, 4);
        return this.luacLittleEndian ? (this.buf[3] << 24) | ((255 & this.buf[2]) << 16) | ((255 & this.buf[1]) << 8) | (255 & this.buf[0]) : (this.buf[0] << 24) | ((255 & this.buf[1]) << 16) | ((255 & this.buf[2]) << 8) | (255 & this.buf[3]);
    }

    int[] loadIntArray() throws IOException {
        byte b;
        byte b2;
        int i;
        int loadInt = loadInt();
        if (loadInt == 0) {
            return NOINTS;
        }
        int i2 = loadInt << 2;
        if (this.buf.length < i2) {
            this.buf = new byte[i2];
        }
        this.f3285is.readFully(this.buf, 0, i2);
        int[] iArr = new int[loadInt];
        int i3 = 0;
        int i4 = 0;
        while (i3 < loadInt) {
            if (this.luacLittleEndian) {
                i = (this.buf[i4 + 3] << 24) | ((255 & this.buf[i4 + 2]) << 16) | ((255 & this.buf[i4 + 1]) << 8);
                b2 = 255;
                b = this.buf[i4 + 0];
            } else {
                i = (this.buf[i4 + 0] << 24) | ((255 & this.buf[i4 + 1]) << 16) | ((255 & this.buf[i4 + 2]) << 8);
                b2 = 255;
                b = this.buf[i4 + 3];
            }
            iArr[i3] = i | (b2 & b);
            i3++;
            i4 += 4;
        }
        return iArr;
    }

    long loadInt64() throws IOException {
        int i;
        int i2;
        if (this.luacLittleEndian) {
            i2 = loadInt();
            i = loadInt();
        } else {
            i = loadInt();
            i2 = loadInt();
        }
        return (((long) i) << 32) | (((long) i2) & 4294967295L);
    }

    LuaString loadString() throws IOException {
        int loadInt64 = this.luacSizeofSizeT == 8 ? (int) loadInt64() : loadInt();
        if (loadInt64 == 0) {
            return null;
        }
        byte[] bArr = new byte[loadInt64];
        this.f3285is.readFully(bArr, 0, loadInt64);
        return LuaString.valueUsing(bArr, 0, bArr.length - 1);
    }

    public static LuaValue longBitsToLuaNumber(long j) {
        if ((j & LongCompanionObject.MAX_VALUE) == 0) {
            return LuaValue.ZERO;
        }
        int i = ((int) ((j >> 52) & 2047)) - 1023;
        if (i >= 0 && i < 31) {
            long j2 = j & 4503599627370495L;
            int i2 = 52 - i;
            if ((j2 & ((1 << i2) - 1)) == 0) {
                int i3 = ((int) (j2 >> i2)) | (1 << i);
                return LuaInteger.valueOf((j >> 63) != 0 ? -i3 : i3);
            }
        }
        return LuaValue.valueOf(Double.longBitsToDouble(j));
    }

    LuaValue loadNumber() throws IOException {
        return this.luacNumberFormat == 1 ? LuaInteger.valueOf(loadInt()) : longBitsToLuaNumber(loadInt64());
    }

    void loadConstants(Prototype prototype) throws IOException {
        int loadInt = loadInt();
        LuaValue[] luaValueArr = loadInt > 0 ? new LuaValue[loadInt] : NOVALUES;
        for (int i = 0; i < loadInt; i++) {
            switch (this.f3285is.readByte()) {
                case -2:
                    luaValueArr[i] = LuaInteger.valueOf(loadInt());
                    break;
                case -1:
                case 2:
                default:
                    throw new IllegalStateException("bad constant");
                case 0:
                    luaValueArr[i] = LuaValue.NIL;
                    break;
                case 1:
                    luaValueArr[i] = 0 != this.f3285is.readUnsignedByte() ? LuaValue.TRUE : LuaValue.FALSE;
                    break;
                case 3:
                    luaValueArr[i] = loadNumber();
                    break;
                case 4:
                    luaValueArr[i] = loadString();
                    break;
            }
        }
        prototype.f3295k = luaValueArr;
        int loadInt2 = loadInt();
        Prototype[] prototypeArr = loadInt2 > 0 ? new Prototype[loadInt2] : NOPROTOS;
        for (int i2 = 0; i2 < loadInt2; i2++) {
            prototypeArr[i2] = loadFunction(prototype.source);
        }
        prototype.f3296p = prototypeArr;
    }

    void loadUpvalues(Prototype prototype) throws IOException {
        int loadInt = loadInt();
        prototype.upvalues = loadInt > 0 ? new Upvaldesc[loadInt] : NOUPVALDESCS;
        for (int i = 0; i < loadInt; i++) {
            prototype.upvalues[i] = new Upvaldesc(null, this.f3285is.readByte() != 0, this.f3285is.readByte() & 255);
        }
    }

    void loadDebug(Prototype prototype) throws IOException {
        prototype.source = loadString();
        prototype.lineinfo = loadIntArray();
        int loadInt = loadInt();
        prototype.locvars = loadInt > 0 ? new LocVars[loadInt] : NOLOCVARS;
        for (int i = 0; i < loadInt; i++) {
            prototype.locvars[i] = new LocVars(loadString(), loadInt(), loadInt());
        }
        int loadInt2 = loadInt();
        for (int i2 = 0; i2 < loadInt2; i2++) {
            prototype.upvalues[i2].name = loadString();
        }
    }

    public Prototype loadFunction(LuaString luaString) throws IOException {
        Prototype prototype = new Prototype();
        prototype.linedefined = loadInt();
        prototype.lastlinedefined = loadInt();
        prototype.numparams = this.f3285is.readUnsignedByte();
        prototype.is_vararg = this.f3285is.readUnsignedByte();
        prototype.maxstacksize = this.f3285is.readUnsignedByte();
        prototype.code = loadIntArray();
        loadConstants(prototype);
        loadUpvalues(prototype);
        loadDebug(prototype);
        return prototype;
    }

    public void loadHeader() throws IOException {
        this.luacVersion = this.f3285is.readByte();
        this.luacFormat = this.f3285is.readByte();
        this.luacLittleEndian = 0 != this.f3285is.readByte();
        this.luacSizeofInt = this.f3285is.readByte();
        this.luacSizeofSizeT = this.f3285is.readByte();
        this.luacSizeofInstruction = this.f3285is.readByte();
        this.luacSizeofLuaNumber = this.f3285is.readByte();
        this.luacNumberFormat = this.f3285is.readByte();
        for (int i = 0; i < LUAC_TAIL.length; i++) {
            if (this.f3285is.readByte() != LUAC_TAIL[i]) {
                throw new LuaError(new StringBuffer().append("Unexpeted byte in luac tail of header, index=").append(i).toString());
            }
        }
    }

    public static Prototype undump(InputStream inputStream, String str) throws IOException {
        if (inputStream.read() != LUA_SIGNATURE[0] || inputStream.read() != LUA_SIGNATURE[1] || inputStream.read() != LUA_SIGNATURE[2] || inputStream.read() != LUA_SIGNATURE[3]) {
            return null;
        }
        String sourceName = getSourceName(str);
        LoadState loadState = new LoadState(inputStream, sourceName);
        loadState.loadHeader();
        switch (loadState.luacNumberFormat) {
            case 0:
            case 1:
            case 4:
                return loadState.loadFunction(LuaString.valueOf(sourceName));
            case 2:
            case 3:
            default:
                throw new LuaError("unsupported int size");
        }
    }

    public static String getSourceName(String str) {
        String str2 = str;
        if (str.startsWith("@") || str.startsWith("=")) {
            str2 = str.substring(1);
        } else if (str.startsWith("\u001b")) {
            str2 = SOURCE_BINARY_STRING;
        }
        return str2;
    }

    private LoadState(InputStream inputStream, String str) {
        this.name = str;
        this.f3285is = new DataInputStream(inputStream);
    }
}
