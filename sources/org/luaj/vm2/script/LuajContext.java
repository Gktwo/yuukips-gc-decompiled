package org.luaj.vm2.script;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import javax.script.ScriptContext;
import javax.script.SimpleScriptContext;
import org.luaj.vm2.Globals;
import org.luaj.vm2.lib.jse.JsePlatform;
import org.luaj.vm2.luajc.LuaJC;

/* loaded from: grasscutter.jar:org/luaj/vm2/script/LuajContext.class */
public class LuajContext extends SimpleScriptContext implements ScriptContext {
    public final Globals globals;
    private final InputStream stdin;
    private final PrintStream stdout;
    private final PrintStream stderr;

    /* loaded from: grasscutter.jar:org/luaj/vm2/script/LuajContext$ReaderInputStream.class */
    static final class ReaderInputStream extends InputStream {

        /* renamed from: r */
        final Reader f3325r;

        ReaderInputStream(Reader reader) {
            this.f3325r = reader;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            return this.f3325r.read();
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/script/LuajContext$WriterOutputStream.class */
    static final class WriterOutputStream extends OutputStream {

        /* renamed from: w */
        final Writer f3326w;

        WriterOutputStream(Writer writer) {
            this.f3326w = writer;
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.f3326w.write(new String(new byte[]{(byte) i}));
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.f3326w.write(new String(bArr, i, i2));
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f3326w.write(new String(bArr));
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f3326w.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.f3326w.flush();
        }
    }

    public LuajContext() {
        this(C3P0Substitutions.DEBUG.equals(System.getProperty("org.luaj.debug")), C3P0Substitutions.DEBUG.equals(System.getProperty("org.luaj.luajc")));
    }

    public LuajContext(boolean z, boolean z2) {
        this.globals = z ? JsePlatform.debugGlobals() : JsePlatform.standardGlobals();
        if (z2) {
            LuaJC.install(this.globals);
        }
        this.stdin = this.globals.STDIN;
        this.stdout = this.globals.STDOUT;
        this.stderr = this.globals.STDERR;
    }

    public void setErrorWriter(Writer writer) {
        this.globals.STDERR = writer != null ? new PrintStream(new WriterOutputStream(writer)) : this.stderr;
    }

    public void setReader(Reader reader) {
        this.globals.STDIN = reader != null ? new ReaderInputStream(reader) : this.stdin;
    }

    public void setWriter(Writer writer) {
        this.globals.STDOUT = writer != null ? new PrintStream((OutputStream) new WriterOutputStream(writer), true) : this.stdout;
    }
}
