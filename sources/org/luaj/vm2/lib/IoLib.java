package org.luaj.vm2.lib;

import dev.morphia.mapping.Mapper;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.slf4j.Marker;
import p001ch.qos.logback.core.joran.action.Action;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/IoLib.class */
public abstract class IoLib extends TwoArgFunction {
    protected static final int FTYPE_STDIN = 0;
    protected static final int FTYPE_STDOUT = 1;
    protected static final int FTYPE_STDERR = 2;
    protected static final int FTYPE_NAMED = 3;
    private File infile = null;
    private File outfile = null;
    private File errfile = null;
    private static final int IO_CLOSE = 0;
    private static final int IO_FLUSH = 1;
    private static final int IO_INPUT = 2;
    private static final int IO_LINES = 3;
    private static final int IO_OPEN = 4;
    private static final int IO_OUTPUT = 5;
    private static final int IO_POPEN = 6;
    private static final int IO_READ = 7;
    private static final int IO_TMPFILE = 8;
    private static final int IO_TYPE = 9;
    private static final int IO_WRITE = 10;
    private static final int FILE_CLOSE = 11;
    private static final int FILE_FLUSH = 12;
    private static final int FILE_LINES = 13;
    private static final int FILE_READ = 14;
    private static final int FILE_SEEK = 15;
    private static final int FILE_SETVBUF = 16;
    private static final int FILE_WRITE = 17;
    private static final int IO_INDEX = 18;
    private static final int LINES_ITER = 19;
    LuaTable filemethods;
    protected Globals globals;
    static Class class$org$luaj$vm2$lib$IoLib$IoLibV;
    private static final LuaValue STDIN = valueOf("stdin");
    private static final LuaValue STDOUT = valueOf("stdout");
    private static final LuaValue STDERR = valueOf("stderr");
    private static final LuaValue FILE = valueOf(Action.FILE_ATTRIBUTE);
    private static final LuaValue CLOSED_FILE = valueOf("closed file");
    public static final String[] IO_NAMES = {"close", "flush", "input", "lines", "open", "output", "popen", "read", "tmpfile", "type", "write"};
    public static final String[] FILE_NAMES = {"close", "flush", "lines", "read", "seek", "setvbuf", "write"};

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/IoLib$File.class */
    public abstract class File extends LuaValue {
        private final IoLib this$0;

        /* access modifiers changed from: protected */
        public File(IoLib ioLib) {
            this.this$0 = ioLib;
        }

        public abstract void write(LuaString luaString) throws IOException;

        public abstract void flush() throws IOException;

        public abstract boolean isstdfile();

        public abstract void close() throws IOException;

        public abstract boolean isclosed();

        public abstract int seek(String str, int i) throws IOException;

        public abstract void setvbuf(String str, int i);

        public abstract int remaining() throws IOException;

        public abstract int peek() throws IOException, EOFException;

        public abstract int read() throws IOException, EOFException;

        public abstract int read(byte[] bArr, int i, int i2) throws IOException;

        @Override // org.luaj.vm2.LuaValue
        public LuaValue get(LuaValue luaValue) {
            return this.this$0.filemethods.get(luaValue);
        }

        @Override // org.luaj.vm2.LuaValue
        public int type() {
            return 7;
        }

        @Override // org.luaj.vm2.LuaValue
        public String typename() {
            return "userdata";
        }

        @Override // org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
        public String tojstring() {
            return new StringBuffer().append("file: ").append(Integer.toHexString(hashCode())).toString();
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/IoLib$IoLibV.class */
    public static final class IoLibV extends VarArgFunction {

        /* renamed from: f */
        private File f3338f;
        public IoLib iolib;

        public IoLibV() {
        }

        public IoLibV(File file, String str, int i, IoLib ioLib) {
            this.f3338f = file;
            this.name = str;
            this.opcode = i;
            this.iolib = ioLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            try {
                switch (this.opcode) {
                    case 0:
                        return this.iolib._io_close(varargs.arg1());
                    case 1:
                        return this.iolib._io_flush();
                    case 2:
                        return this.iolib._io_input(varargs.arg1());
                    case 3:
                        return this.iolib._io_lines(varargs.isvalue(1) ? varargs.checkjstring(1) : null);
                    case 4:
                        return this.iolib._io_open(varargs.checkjstring(1), varargs.optjstring(2, "r"));
                    case 5:
                        return this.iolib._io_output(varargs.arg1());
                    case 6:
                        return this.iolib._io_popen(varargs.checkjstring(1), varargs.optjstring(2, "r"));
                    case 7:
                        return this.iolib._io_read(varargs);
                    case 8:
                        return this.iolib._io_tmpfile();
                    case 9:
                        return this.iolib._io_type(varargs.arg1());
                    case 10:
                        return this.iolib._io_write(varargs);
                    case 11:
                        return this.iolib._file_close(varargs.arg1());
                    case 12:
                        return this.iolib._file_flush(varargs.arg1());
                    case 13:
                        return this.iolib._file_lines(varargs.arg1());
                    case 14:
                        return this.iolib._file_read(varargs.arg1(), varargs.subargs(2));
                    case 15:
                        return this.iolib._file_seek(varargs.arg1(), varargs.optjstring(2, "cur"), varargs.optint(3, 0));
                    case 16:
                        return this.iolib._file_setvbuf(varargs.arg1(), varargs.checkjstring(2), varargs.optint(3, 1024));
                    case 17:
                        return this.iolib._file_write(varargs.arg1(), varargs.subargs(2));
                    case 18:
                        return this.iolib._io_index(varargs.arg(2));
                    case 19:
                        return this.iolib._lines_iter(this.f3338f);
                    default:
                        return NONE;
                }
            } catch (IOException e) {
                return IoLib.access$000(e);
            }
        }
    }

    protected abstract File wrapStdin() throws IOException;

    protected abstract File wrapStdout() throws IOException;

    protected abstract File wrapStderr() throws IOException;

    protected abstract File openFile(String str, boolean z, boolean z2, boolean z3, boolean z4) throws IOException;

    protected abstract File tmpFile() throws IOException;

    protected abstract File openProgram(String str, String str2) throws IOException;

    @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        Class cls;
        Class cls2;
        Class cls3;
        this.globals = luaValue2.checkglobals();
        LuaTable luaTable = new LuaTable();
        if (class$org$luaj$vm2$lib$IoLib$IoLibV == null) {
            cls = class$("org.luaj.vm2.lib.IoLib$IoLibV");
            class$org$luaj$vm2$lib$IoLib$IoLibV = cls;
        } else {
            cls = class$org$luaj$vm2$lib$IoLib$IoLibV;
        }
        bind(luaTable, cls, IO_NAMES);
        this.filemethods = new LuaTable();
        LuaValue luaValue3 = this.filemethods;
        if (class$org$luaj$vm2$lib$IoLib$IoLibV == null) {
            cls2 = class$("org.luaj.vm2.lib.IoLib$IoLibV");
            class$org$luaj$vm2$lib$IoLib$IoLibV = cls2;
        } else {
            cls2 = class$org$luaj$vm2$lib$IoLib$IoLibV;
        }
        bind(luaValue3, cls2, FILE_NAMES, 11);
        LuaTable luaTable2 = new LuaTable();
        if (class$org$luaj$vm2$lib$IoLib$IoLibV == null) {
            cls3 = class$("org.luaj.vm2.lib.IoLib$IoLibV");
            class$org$luaj$vm2$lib$IoLib$IoLibV = cls3;
        } else {
            cls3 = class$org$luaj$vm2$lib$IoLib$IoLibV;
        }
        bind(luaTable2, cls3, new String[]{"__index"}, 18);
        luaTable.setmetatable(luaTable2);
        setLibInstance(luaTable);
        setLibInstance(this.filemethods);
        setLibInstance(luaTable2);
        luaValue2.set("io", luaTable);
        luaValue2.get("package").get("loaded").set("io", luaTable);
        return luaTable;
    }

    private void setLibInstance(LuaTable luaTable) {
        for (LuaValue luaValue : luaTable.keys()) {
            ((IoLibV) luaTable.get(luaValue)).iolib = this;
        }
    }

    private File input() {
        if (this.infile != null) {
            return this.infile;
        }
        File ioopenfile = ioopenfile(0, "-", "r");
        this.infile = ioopenfile;
        return ioopenfile;
    }

    public Varargs _io_flush() throws IOException {
        checkopen(output());
        this.outfile.flush();
        return LuaValue.TRUE;
    }

    public Varargs _io_tmpfile() throws IOException {
        return tmpFile();
    }

    public Varargs _io_close(LuaValue luaValue) throws IOException {
        File output = luaValue.isnil() ? output() : checkfile(luaValue);
        checkopen(output);
        return ioclose(output);
    }

    public Varargs _io_input(LuaValue luaValue) {
        this.infile = luaValue.isnil() ? input() : luaValue.isstring() ? ioopenfile(3, luaValue.checkjstring(), "r") : checkfile(luaValue);
        return this.infile;
    }

    public Varargs _io_output(LuaValue luaValue) {
        this.outfile = luaValue.isnil() ? output() : luaValue.isstring() ? ioopenfile(3, luaValue.checkjstring(), "w") : checkfile(luaValue);
        return this.outfile;
    }

    public Varargs _io_type(LuaValue luaValue) {
        File optfile = optfile(luaValue);
        return optfile != null ? optfile.isclosed() ? CLOSED_FILE : FILE : NIL;
    }

    public Varargs _io_popen(String str, String str2) throws IOException {
        return openProgram(str, str2);
    }

    public Varargs _io_open(String str, String str2) throws IOException {
        return rawopenfile(3, str, str2);
    }

    public Varargs _io_lines(String str) {
        this.infile = str == null ? input() : ioopenfile(3, str, "r");
        checkopen(this.infile);
        return lines(this.infile);
    }

    public Varargs _io_read(Varargs varargs) throws IOException {
        checkopen(input());
        return ioread(this.infile, varargs);
    }

    public Varargs _io_write(Varargs varargs) throws IOException {
        checkopen(output());
        return iowrite(this.outfile, varargs);
    }

    public Varargs _file_close(LuaValue luaValue) throws IOException {
        return ioclose(checkfile(luaValue));
    }

    public Varargs _file_flush(LuaValue luaValue) throws IOException {
        checkfile(luaValue).flush();
        return LuaValue.TRUE;
    }

    public Varargs _file_setvbuf(LuaValue luaValue, String str, int i) {
        checkfile(luaValue).setvbuf(str, i);
        return LuaValue.TRUE;
    }

    public Varargs _file_lines(LuaValue luaValue) {
        return lines(checkfile(luaValue));
    }

    public Varargs _file_read(LuaValue luaValue, Varargs varargs) throws IOException {
        return ioread(checkfile(luaValue), varargs);
    }

    public Varargs _file_seek(LuaValue luaValue, String str, int i) throws IOException {
        return valueOf(checkfile(luaValue).seek(str, i));
    }

    public Varargs _file_write(LuaValue luaValue, Varargs varargs) throws IOException {
        return iowrite(checkfile(luaValue), varargs);
    }

    public Varargs _io_index(LuaValue luaValue) {
        return luaValue.equals(STDOUT) ? output() : luaValue.equals(STDIN) ? input() : luaValue.equals(STDERR) ? errput() : NIL;
    }

    public Varargs _lines_iter(LuaValue luaValue) throws IOException {
        return freadline(checkfile(luaValue));
    }

    private File output() {
        if (this.outfile != null) {
            return this.outfile;
        }
        File ioopenfile = ioopenfile(1, "-", "w");
        this.outfile = ioopenfile;
        return ioopenfile;
    }

    private File errput() {
        if (this.errfile != null) {
            return this.errfile;
        }
        File ioopenfile = ioopenfile(2, "-", "w");
        this.errfile = ioopenfile;
        return ioopenfile;
    }

    private File ioopenfile(int i, String str, String str2) {
        try {
            return rawopenfile(i, str, str2);
        } catch (Exception e) {
            error(new StringBuffer().append("io error: ").append(e.getMessage()).toString());
            return null;
        }
    }

    private static Varargs ioclose(File file) throws IOException {
        if (file.isstdfile()) {
            return errorresult("cannot close standard file");
        }
        file.close();
        return successresult();
    }

    private static Varargs successresult() {
        return LuaValue.TRUE;
    }

    private static Varargs errorresult(Exception exc) {
        String message = exc.getMessage();
        return errorresult(new StringBuffer().append("io error: ").append(message != null ? message : exc.toString()).toString());
    }

    private static Varargs errorresult(String str) {
        return varargsOf(NIL, valueOf(str));
    }

    private Varargs lines(File file) {
        try {
            return new IoLibV(file, "lnext", 19, this);
        } catch (Exception e) {
            return error(new StringBuffer().append("lines: ").append(e).toString());
        }
    }

    private static Varargs iowrite(File file, Varargs varargs) throws IOException {
        int narg = varargs.narg();
        for (int i = 1; i <= narg; i++) {
            file.write(varargs.checkstring(i));
        }
        return file;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.luaj.vm2.Varargs ioread(org.luaj.vm2.lib.IoLib.File r6, org.luaj.vm2.Varargs r7) throws java.io.IOException {
        /*
            r5 = this;
            r0 = r7
            int r0 = r0.narg()
            r9 = r0
            r0 = r9
            org.luaj.vm2.LuaValue[] r0 = new org.luaj.vm2.LuaValue[r0]
            r10 = r0
            r0 = 0
            r8 = r0
        L_0x000f:
            r0 = r8
            r1 = r9
            if (r0 >= r1) goto L_0x00cf
            r0 = r7
            r1 = r8
            r2 = 1
            int r1 = r1 + r2
            org.luaj.vm2.LuaValue r0 = r0.arg(r1)
            r1 = r0
            r11 = r1
            int r0 = r0.type()
            switch(r0) {
                case 3: goto L_0x003c;
                case 4: goto L_0x004a;
                default: goto L_0x00b3;
            }
        L_0x003c:
            r0 = r6
            r1 = r11
            int r1 = r1.toint()
            org.luaj.vm2.LuaValue r0 = freadbytes(r0, r1)
            r12 = r0
            goto L_0x00bc
        L_0x004a:
            r0 = r11
            org.luaj.vm2.LuaString r0 = r0.checkstring()
            r13 = r0
            r0 = r13
            int r0 = r0.m_length
            r1 = 2
            if (r0 != r1) goto L_0x00b3
            r0 = r13
            byte[] r0 = r0.m_bytes
            r1 = r13
            int r1 = r1.m_offset
            r0 = r0[r1]
            r1 = 42
            if (r0 != r1) goto L_0x00b3
            r0 = r13
            byte[] r0 = r0.m_bytes
            r1 = r13
            int r1 = r1.m_offset
            r2 = 1
            int r1 = r1 + r2
            r0 = r0[r1]
            switch(r0) {
                case 97: goto L_0x00aa;
                case 108: goto L_0x00a1;
                case 110: goto L_0x0098;
                default: goto L_0x00b3;
            }
        L_0x0098:
            r0 = r6
            org.luaj.vm2.LuaValue r0 = freadnumber(r0)
            r12 = r0
            goto L_0x00bc
        L_0x00a1:
            r0 = r6
            org.luaj.vm2.LuaValue r0 = freadline(r0)
            r12 = r0
            goto L_0x00bc
        L_0x00aa:
            r0 = r6
            org.luaj.vm2.LuaValue r0 = freadall(r0)
            r12 = r0
            goto L_0x00bc
        L_0x00b3:
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            java.lang.String r1 = "(invalid format)"
            org.luaj.vm2.LuaValue r0 = argerror(r0, r1)
            return r0
        L_0x00bc:
            r0 = r10
            r1 = r8
            int r8 = r8 + 1
            r2 = r12
            r3 = r2; r2 = r1; r1 = r0; r0 = r3; 
            r1[r2] = r3
            boolean r0 = r0.isnil()
            if (r0 == 0) goto L_0x000f
            goto L_0x00cf
        L_0x00cf:
            r0 = r8
            if (r0 != 0) goto L_0x00d9
            org.luaj.vm2.LuaValue r0 = org.luaj.vm2.lib.IoLib.NIL
            goto L_0x00e0
        L_0x00d9:
            r0 = r10
            r1 = 0
            r2 = r8
            org.luaj.vm2.Varargs r0 = varargsOf(r0, r1, r2)
        L_0x00e0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.lib.IoLib.ioread(org.luaj.vm2.lib.IoLib$File, org.luaj.vm2.Varargs):org.luaj.vm2.Varargs");
    }

    private static File checkfile(LuaValue luaValue) {
        File optfile = optfile(luaValue);
        if (optfile == null) {
            argerror(1, Action.FILE_ATTRIBUTE);
        }
        checkopen(optfile);
        return optfile;
    }

    private static File optfile(LuaValue luaValue) {
        if (luaValue instanceof File) {
            return (File) luaValue;
        }
        return null;
    }

    private static File checkopen(File file) {
        if (file.isclosed()) {
            error("attempt to use a closed file");
        }
        return file;
    }

    private File rawopenfile(int i, String str, String str2) throws IOException {
        switch (i) {
            case 0:
                return wrapStdin();
            case 1:
                return wrapStdout();
            case 2:
                return wrapStderr();
            default:
                return openFile(str, str2.startsWith("r"), str2.startsWith("a"), str2.indexOf(Marker.ANY_NON_NULL_MARKER) > 0, str2.endsWith("b"));
        }
    }

    public static LuaValue freadbytes(File file, int i) throws IOException {
        byte[] bArr = new byte[i];
        int read = file.read(bArr, 0, bArr.length);
        return read < 0 ? NIL : LuaString.valueUsing(bArr, 0, read);
    }

    public static LuaValue freaduntil(File file, boolean z) throws IOException {
        int i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            if (!z) {
                while (true) {
                    int read = file.read();
                    i = read;
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(i);
                }
            } else {
                while (true) {
                    int read2 = file.read();
                    i = read2;
                    if (read2 > 0) {
                        switch (i) {
                            case 10:
                                break;
                            case 13:
                                break;
                            default:
                                byteArrayOutputStream.write(i);
                                break;
                        }
                    }
                }
            }
        } catch (EOFException e) {
            i = -1;
        }
        return (i >= 0 || byteArrayOutputStream.size() != 0) ? LuaString.valueUsing(byteArrayOutputStream.toByteArray()) : NIL;
    }

    public static LuaValue freadline(File file) throws IOException {
        return freaduntil(file, true);
    }

    public static LuaValue freadall(File file) throws IOException {
        int remaining = file.remaining();
        return remaining >= 0 ? freadbytes(file, remaining) : freaduntil(file, false);
    }

    public static LuaValue freadnumber(File file) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        freadchars(file, " \t\r\n", null);
        freadchars(file, "-+", byteArrayOutputStream);
        freadchars(file, "0123456789", byteArrayOutputStream);
        freadchars(file, Mapper.IGNORED_FIELDNAME, byteArrayOutputStream);
        freadchars(file, "0123456789", byteArrayOutputStream);
        String byteArrayOutputStream2 = byteArrayOutputStream.toString();
        return byteArrayOutputStream2.length() > 0 ? valueOf(Double.parseDouble(byteArrayOutputStream2)) : NIL;
    }

    private static void freadchars(File file, String str, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        while (true) {
            int peek = file.peek();
            if (str.indexOf(peek) >= 0) {
                file.read();
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.write(peek);
                }
            } else {
                return;
            }
        }
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    static Varargs access$000(Exception exc) {
        return errorresult(exc);
    }
}
