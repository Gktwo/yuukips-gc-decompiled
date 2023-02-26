package org.luaj.vm2;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Reader;
import org.luaj.vm2.lib.BaseLib;
import org.luaj.vm2.lib.DebugLib;
import org.luaj.vm2.lib.PackageLib;
import org.luaj.vm2.lib.ResourceFinder;

/* loaded from: grasscutter.jar:org/luaj/vm2/Globals.class */
public class Globals extends LuaTable {
    public ResourceFinder finder;
    public BaseLib baselib;
    public PackageLib package_;
    public DebugLib debuglib;
    public Loader loader;
    public Compiler compiler;
    public Undumper undumper;
    public InputStream STDIN = null;
    public PrintStream STDOUT = System.out;
    public PrintStream STDERR = System.err;
    public LuaThread running = new LuaThread(this);

    /* loaded from: grasscutter.jar:org/luaj/vm2/Globals$AbstractBufferedStream.class */
    static abstract class AbstractBufferedStream extends InputStream {

        /* renamed from: b */
        protected byte[] f3240b;

        /* renamed from: i */
        protected int f3241i = 0;

        /* renamed from: j */
        protected int f3242j = 0;

        protected AbstractBufferedStream(int i) {
            this.f3240b = new byte[i];
        }

        protected abstract int avail() throws IOException;

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (avail() <= 0) {
                return -1;
            }
            byte[] bArr = this.f3240b;
            int i = this.f3241i;
            this.f3241i = i + 1;
            return 255 & bArr[i];
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            return read(bArr, 0, bArr.length);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int avail = avail();
            if (avail <= 0) {
                return -1;
            }
            int min = Math.min(avail, i2);
            System.arraycopy(this.f3240b, this.f3241i, bArr, i, min);
            this.f3241i += min;
            return min;
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            long min = Math.min(j, (long) (this.f3242j - this.f3241i));
            this.f3241i = (int) (((long) this.f3241i) + min);
            return min;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.f3242j - this.f3241i;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/Globals$BufferedStream.class */
    public static class BufferedStream extends AbstractBufferedStream {

        /* renamed from: s */
        private final InputStream f3243s;

        public BufferedStream(InputStream inputStream) {
            this(128, inputStream);
        }

        BufferedStream(int i, InputStream inputStream) {
            super(i);
            this.f3243s = inputStream;
        }

        @Override // org.luaj.vm2.Globals.AbstractBufferedStream
        protected int avail() throws IOException {
            if (this.f3241i < this.f3242j) {
                return this.f3242j - this.f3241i;
            }
            if (this.f3242j >= this.f3240b.length) {
                this.f3242j = 0;
                this.f3241i = 0;
            }
            int read = this.f3243s.read(this.f3240b, this.f3242j, this.f3240b.length - this.f3242j);
            if (read < 0) {
                return -1;
            }
            if (read == 0) {
                int read2 = this.f3243s.read();
                if (read2 < 0) {
                    return -1;
                }
                this.f3240b[this.f3242j] = (byte) read2;
                read = 1;
            }
            this.f3242j += read;
            return read;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f3243s.close();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            if (this.f3241i > 0 || i > this.f3240b.length) {
                byte[] bArr = i > this.f3240b.length ? new byte[i] : this.f3240b;
                System.arraycopy(this.f3240b, this.f3241i, bArr, 0, this.f3242j - this.f3241i);
                this.f3242j -= this.f3241i;
                this.f3241i = 0;
                this.f3240b = bArr;
            }
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            this.f3241i = 0;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/Globals$Compiler.class */
    public interface Compiler {
        Prototype compile(InputStream inputStream, String str) throws IOException;
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/Globals$Loader.class */
    public interface Loader {
        LuaFunction load(Prototype prototype, String str, LuaValue luaValue) throws IOException;
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/Globals$StrReader.class */
    static class StrReader extends Reader {

        /* renamed from: s */
        final String f3244s;

        /* renamed from: i */
        int f3245i = 0;

        /* renamed from: n */
        final int f3246n;

        StrReader(String str) {
            this.f3244s = str;
            this.f3246n = str.length();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f3245i = this.f3246n;
        }

        @Override // java.io.Reader
        public int read() throws IOException {
            if (this.f3245i >= this.f3246n) {
                return -1;
            }
            String str = this.f3244s;
            int i = this.f3245i;
            this.f3245i = i + 1;
            return str.charAt(i);
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (i3 < i2 && this.f3245i < this.f3246n) {
                cArr[i + i3] = this.f3244s.charAt(this.f3245i);
                i3++;
                this.f3245i++;
            }
            if (i3 > 0 || i2 == 0) {
                return i3;
            }
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/Globals$UTF8Stream.class */
    public static class UTF8Stream extends AbstractBufferedStream {

        /* renamed from: c */
        private final char[] f3247c = new char[32];

        /* renamed from: r */
        private final Reader f3248r;

        UTF8Stream(Reader reader) {
            super(96);
            this.f3248r = reader;
        }

        @Override // org.luaj.vm2.Globals.AbstractBufferedStream
        protected int avail() throws IOException {
            if (this.f3241i < this.f3242j) {
                return this.f3242j - this.f3241i;
            }
            int read = this.f3248r.read(this.f3247c);
            if (read < 0) {
                return -1;
            }
            if (read == 0) {
                int read2 = this.f3248r.read();
                if (read2 < 0) {
                    return -1;
                }
                this.f3247c[0] = (char) read2;
                read = 1;
            }
            char[] cArr = this.f3247c;
            byte[] bArr = this.f3240b;
            this.f3241i = 0;
            this.f3242j = LuaString.encodeToUtf8(cArr, read, bArr, 0);
            return this.f3242j;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f3248r.close();
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/Globals$Undumper.class */
    public interface Undumper {
        Prototype undump(InputStream inputStream, String str) throws IOException;
    }

    @Override // org.luaj.vm2.LuaValue
    public Globals checkglobals() {
        return this;
    }

    public LuaValue loadfile(String str) {
        try {
            return load(this.finder.findResource(str), new StringBuffer().append("@").append(str).toString(), "bt", this);
        } catch (Exception e) {
            return error(new StringBuffer().append("load ").append(str).append(": ").append(e).toString());
        }
    }

    public LuaValue load(String str, String str2) {
        return load(new StrReader(str), str2);
    }

    public LuaValue load(String str) {
        return load(new StrReader(str), str);
    }

    public LuaValue load(String str, String str2, LuaTable luaTable) {
        return load(new StrReader(str), str2, luaTable);
    }

    public LuaValue load(Reader reader, String str) {
        return load(new UTF8Stream(reader), str, "t", this);
    }

    public LuaValue load(Reader reader, String str, LuaTable luaTable) {
        return load(new UTF8Stream(reader), str, "t", luaTable);
    }

    public LuaValue load(InputStream inputStream, String str, String str2, LuaValue luaValue) {
        try {
            return this.loader.load(loadPrototype(inputStream, str, str2), str, luaValue);
        } catch (LuaError e) {
            throw e;
        } catch (Exception e2) {
            return error(new StringBuffer().append("load ").append(str).append(": ").append(e2).toString());
        }
    }

    public Prototype loadPrototype(InputStream inputStream, String str, String str2) throws IOException {
        if (str2.indexOf(98) >= 0) {
            if (this.undumper == null) {
                error("No undumper.");
            }
            if (!inputStream.markSupported()) {
                inputStream = new BufferedStream(inputStream);
            }
            inputStream.mark(4);
            Prototype undump = this.undumper.undump(inputStream, str);
            if (undump != null) {
                return undump;
            }
            inputStream.reset();
        }
        if (str2.indexOf(116) >= 0) {
            return compilePrototype(inputStream, str);
        }
        error(new StringBuffer().append("Failed to load prototype ").append(str).append(" using mode '").append(str2).append("'").toString());
        return null;
    }

    public Prototype compilePrototype(Reader reader, String str) throws IOException {
        return compilePrototype(new UTF8Stream(reader), str);
    }

    public Prototype compilePrototype(InputStream inputStream, String str) throws IOException {
        if (this.compiler == null) {
            error("No compiler.");
        }
        return this.compiler.compile(inputStream, str);
    }

    public Varargs yield(Varargs varargs) {
        if (this.running != null && !this.running.isMainThread()) {
            return this.running.state.lua_yield(varargs);
        }
        throw new LuaError("cannot yield main thread");
    }
}
