package org.luaj.vm2.lib.jse;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.lib.IoLib;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JseIoLib.class */
public class JseIoLib extends IoLib {

    /* renamed from: org.luaj.vm2.lib.jse.JseIoLib$1 */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JseIoLib$1.class */
    static class C58681 {
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JseIoLib$FileImpl.class */
    private final class FileImpl extends IoLib.File {
        private final RandomAccessFile file;

        /* renamed from: is */
        private final InputStream f3307is;

        /* renamed from: os */
        private final OutputStream f3308os;
        private boolean closed;
        private boolean nobuffer;
        private final JseIoLib this$0;

        private FileImpl(JseIoLib jseIoLib, RandomAccessFile randomAccessFile, InputStream inputStream, OutputStream outputStream) {
            super(jseIoLib);
            this.this$0 = jseIoLib;
            this.closed = false;
            this.nobuffer = false;
            this.file = randomAccessFile;
            this.f3307is = inputStream != null ? inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream) : null;
            this.f3308os = outputStream;
        }

        private FileImpl(JseIoLib jseIoLib, RandomAccessFile randomAccessFile) {
            this(jseIoLib, randomAccessFile, null, null);
        }

        private FileImpl(JseIoLib jseIoLib, InputStream inputStream) {
            this(jseIoLib, null, inputStream, null);
        }

        private FileImpl(JseIoLib jseIoLib, OutputStream outputStream) {
            this(jseIoLib, null, null, outputStream);
        }

        @Override // org.luaj.vm2.lib.IoLib.File, org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
        public String tojstring() {
            return new StringBuffer().append("file (").append(hashCode()).append(")").toString();
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public boolean isstdfile() {
            return this.file == null;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void close() throws IOException {
            this.closed = true;
            if (this.file != null) {
                this.file.close();
            }
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void flush() throws IOException {
            if (this.f3308os != null) {
                this.f3308os.flush();
            }
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void write(LuaString luaString) throws IOException {
            if (this.f3308os != null) {
                this.f3308os.write(luaString.m_bytes, luaString.m_offset, luaString.m_length);
            } else if (this.file != null) {
                this.file.write(luaString.m_bytes, luaString.m_offset, luaString.m_length);
            } else {
                JseIoLib.access$500();
            }
            if (this.nobuffer) {
                flush();
            }
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public boolean isclosed() {
            return this.closed;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int seek(String str, int i) throws IOException {
            if (this.file != null) {
                if ("set".equals(str)) {
                    this.file.seek((long) i);
                } else if ("end".equals(str)) {
                    this.file.seek(this.file.length() + ((long) i));
                } else {
                    this.file.seek(this.file.getFilePointer() + ((long) i));
                }
                return (int) this.file.getFilePointer();
            }
            JseIoLib.access$500();
            return 0;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void setvbuf(String str, int i) {
            this.nobuffer = "no".equals(str);
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int remaining() throws IOException {
            if (this.file != null) {
                return (int) (this.file.length() - this.file.getFilePointer());
            }
            return -1;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int peek() throws IOException {
            if (this.f3307is != null) {
                this.f3307is.mark(1);
                int read = this.f3307is.read();
                this.f3307is.reset();
                return read;
            } else if (this.file != null) {
                long filePointer = this.file.getFilePointer();
                int read2 = this.file.read();
                this.file.seek(filePointer);
                return read2;
            } else {
                JseIoLib.access$500();
                return 0;
            }
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int read() throws IOException {
            if (this.f3307is != null) {
                return this.f3307is.read();
            }
            if (this.file != null) {
                return this.file.read();
            }
            JseIoLib.access$500();
            return 0;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (this.file != null) {
                return this.file.read(bArr, i, i2);
            }
            if (this.f3307is != null) {
                return this.f3307is.read(bArr, i, i2);
            }
            JseIoLib.access$500();
            return i2;
        }

        FileImpl(JseIoLib jseIoLib, RandomAccessFile randomAccessFile, C58681 r7) {
            this(jseIoLib, randomAccessFile);
        }

        FileImpl(JseIoLib jseIoLib, OutputStream outputStream, C58681 r7) {
            this(jseIoLib, outputStream);
        }

        FileImpl(JseIoLib jseIoLib, InputStream inputStream, C58681 r7) {
            this(jseIoLib, inputStream);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JseIoLib$StdinFile.class */
    private final class StdinFile extends IoLib.File {
        private final JseIoLib this$0;

        private StdinFile(JseIoLib jseIoLib) {
            super(jseIoLib);
            this.this$0 = jseIoLib;
        }

        @Override // org.luaj.vm2.lib.IoLib.File, org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
        public String tojstring() {
            return new StringBuffer().append("file (").append(hashCode()).append(")").toString();
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void write(LuaString luaString) throws IOException {
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void flush() throws IOException {
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public boolean isstdfile() {
            return true;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void close() throws IOException {
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public boolean isclosed() {
            return false;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int seek(String str, int i) throws IOException {
            return 0;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void setvbuf(String str, int i) {
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int remaining() throws IOException {
            return 0;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int peek() throws IOException, EOFException {
            JseIoLib.access$800(this.this$0).STDIN.mark(1);
            int read = JseIoLib.access$900(this.this$0).STDIN.read();
            JseIoLib.access$1000(this.this$0).STDIN.reset();
            return read;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int read() throws IOException, EOFException {
            return JseIoLib.access$1100(this.this$0).STDIN.read();
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int read(byte[] bArr, int i, int i2) throws IOException {
            return JseIoLib.access$1200(this.this$0).STDIN.read(bArr, i, i2);
        }

        StdinFile(JseIoLib jseIoLib, C58681 r5) {
            this(jseIoLib);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JseIoLib$StdoutFile.class */
    private final class StdoutFile extends IoLib.File {
        private final int file_type;
        private final JseIoLib this$0;

        private StdoutFile(JseIoLib jseIoLib, int i) {
            super(jseIoLib);
            this.this$0 = jseIoLib;
            this.file_type = i;
        }

        @Override // org.luaj.vm2.lib.IoLib.File, org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
        public String tojstring() {
            return new StringBuffer().append("file (").append(hashCode()).append(")").toString();
        }

        private final PrintStream getPrintStream() {
            return this.file_type == 2 ? JseIoLib.access$600(this.this$0).STDERR : JseIoLib.access$700(this.this$0).STDOUT;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void write(LuaString luaString) throws IOException {
            getPrintStream().write(luaString.m_bytes, luaString.m_offset, luaString.m_length);
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void flush() throws IOException {
            getPrintStream().flush();
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public boolean isstdfile() {
            return true;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void close() throws IOException {
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public boolean isclosed() {
            return false;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int seek(String str, int i) throws IOException {
            return 0;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public void setvbuf(String str, int i) {
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int remaining() throws IOException {
            return 0;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int peek() throws IOException, EOFException {
            return 0;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int read() throws IOException, EOFException {
            return 0;
        }

        @Override // org.luaj.vm2.lib.IoLib.File
        public int read(byte[] bArr, int i, int i2) throws IOException {
            return 0;
        }

        StdoutFile(JseIoLib jseIoLib, int i, C58681 r7) {
            this(jseIoLib, i);
        }
    }

    @Override // org.luaj.vm2.lib.IoLib
    protected IoLib.File wrapStdin() throws IOException {
        return new StdinFile(this, null);
    }

    @Override // org.luaj.vm2.lib.IoLib
    protected IoLib.File wrapStdout() throws IOException {
        return new StdoutFile(this, 1, null);
    }

    @Override // org.luaj.vm2.lib.IoLib
    protected IoLib.File wrapStderr() throws IOException {
        return new StdoutFile(this, 2, null);
    }

    @Override // org.luaj.vm2.lib.IoLib
    protected IoLib.File openFile(String str, boolean z, boolean z2, boolean z3, boolean z4) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, z ? "r" : "rw");
        if (z2) {
            randomAccessFile.seek(randomAccessFile.length());
        } else if (!z) {
            randomAccessFile.setLength(0);
        }
        return new FileImpl(this, randomAccessFile, (C58681) null);
    }

    @Override // org.luaj.vm2.lib.IoLib
    protected IoLib.File openProgram(String str, String str2) throws IOException {
        Process exec = Runtime.getRuntime().exec(str);
        return "w".equals(str2) ? new FileImpl(this, exec.getOutputStream(), (C58681) null) : new FileImpl(this, exec.getInputStream(), (C58681) null);
    }

    @Override // org.luaj.vm2.lib.IoLib
    protected IoLib.File tmpFile() throws IOException {
        File createTempFile = File.createTempFile(".luaj", "bin");
        createTempFile.deleteOnExit();
        return new FileImpl(this, new RandomAccessFile(createTempFile, "rw"), (C58681) null);
    }

    private static void notimplemented() {
        throw new LuaError("not implemented");
    }

    static void access$500() {
        notimplemented();
    }

    static Globals access$600(JseIoLib jseIoLib) {
        return jseIoLib.globals;
    }

    static Globals access$700(JseIoLib jseIoLib) {
        return jseIoLib.globals;
    }

    static Globals access$800(JseIoLib jseIoLib) {
        return jseIoLib.globals;
    }

    static Globals access$900(JseIoLib jseIoLib) {
        return jseIoLib.globals;
    }

    static Globals access$1000(JseIoLib jseIoLib) {
        return jseIoLib.globals;
    }

    static Globals access$1100(JseIoLib jseIoLib) {
        return jseIoLib.globals;
    }

    static Globals access$1200(JseIoLib jseIoLib) {
        return jseIoLib.globals;
    }
}
