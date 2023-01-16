package org.eclipse.jetty.server;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Formatter;
import java.util.Locale;
import org.eclipse.jetty.p023io.EofException;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/ResponseWriter.class */
public class ResponseWriter extends PrintWriter {
    private static final Logger LOG = Log.getLogger(ResponseWriter.class);
    private final HttpWriter _httpWriter;
    private final Locale _locale;
    private final String _encoding;
    private IOException _ioException;
    private boolean _isClosed = false;
    private Formatter _formatter;

    public ResponseWriter(HttpWriter httpWriter, Locale locale, String encoding) {
        super((Writer) httpWriter, false);
        this._httpWriter = httpWriter;
        this._locale = locale;
        this._encoding = encoding;
    }

    public boolean isFor(Locale locale, String encoding) {
        if (this._locale != null || locale == null) {
            return (this._encoding != null || encoding == null) && this._encoding.equalsIgnoreCase(encoding) && this._locale.equals(locale);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void reopen() {
        synchronized (this.lock) {
            this._isClosed = false;
            clearError();
            this.out = this._httpWriter;
        }
    }

    @Override // java.io.PrintWriter
    protected void clearError() {
        synchronized (this.lock) {
            this._ioException = null;
            clearError();
        }
    }

    @Override // java.io.PrintWriter
    public boolean checkError() {
        boolean z;
        synchronized (this.lock) {
            z = this._ioException != null || checkError();
        }
        return z;
    }

    private void setError(Throwable th) {
        setError();
        if (th instanceof IOException) {
            this._ioException = (IOException) th;
        } else {
            this._ioException = new IOException(String.valueOf(th));
            this._ioException.initCause(th);
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug(th);
        }
    }

    @Override // java.io.PrintWriter
    protected void setError() {
        setError(new IOException());
    }

    private void isOpen() throws IOException {
        if (this._ioException != null) {
            throw this._ioException;
        } else if (this._isClosed) {
            this._ioException = new EofException("Stream closed");
            throw this._ioException;
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer, java.io.Flushable
    public void flush() {
        try {
            synchronized (this.lock) {
                isOpen();
                this.out.flush();
            }
        } catch (Throwable ex) {
            setError(ex);
        }
    }

    @Override // java.io.PrintWriter, java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
    public void close() {
        try {
            synchronized (this.lock) {
                this.out.close();
                this._isClosed = true;
            }
        } catch (IOException ex) {
            setError(ex);
        }
    }

    public void complete(Callback callback) {
        synchronized (this.lock) {
            this._isClosed = true;
        }
        this._httpWriter.complete(callback);
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(int c) {
        try {
            synchronized (this.lock) {
                isOpen();
                this.out.write(c);
            }
        } catch (InterruptedIOException ex) {
            LOG.debug(ex);
            Thread.currentThread().interrupt();
        } catch (IOException ex2) {
            setError(ex2);
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(char[] buf, int off, int len) {
        try {
            synchronized (this.lock) {
                isOpen();
                this.out.write(buf, off, len);
            }
        } catch (InterruptedIOException ex) {
            LOG.debug(ex);
            Thread.currentThread().interrupt();
        } catch (IOException ex2) {
            setError(ex2);
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(char[] buf) {
        write(buf, 0, buf.length);
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(String s, int off, int len) {
        try {
            synchronized (this.lock) {
                isOpen();
                this.out.write(s, off, len);
            }
        } catch (InterruptedIOException ex) {
            LOG.debug(ex);
            Thread.currentThread().interrupt();
        } catch (IOException ex2) {
            setError(ex2);
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(String s) {
        write(s, 0, s.length());
    }

    @Override // java.io.PrintWriter
    public void print(boolean b) {
        write(b ? C3P0Substitutions.DEBUG : "false");
    }

    @Override // java.io.PrintWriter
    public void print(char c) {
        write(c);
    }

    @Override // java.io.PrintWriter
    public void print(int i) {
        write(String.valueOf(i));
    }

    @Override // java.io.PrintWriter
    public void print(long l) {
        write(String.valueOf(l));
    }

    @Override // java.io.PrintWriter
    public void print(float f) {
        write(String.valueOf(f));
    }

    @Override // java.io.PrintWriter
    public void print(double d) {
        write(String.valueOf(d));
    }

    @Override // java.io.PrintWriter
    public void print(char[] s) {
        write(s);
    }

    @Override // java.io.PrintWriter
    public void print(String s) {
        if (s == null) {
            s = "null";
        }
        write(s);
    }

    @Override // java.io.PrintWriter
    public void print(Object obj) {
        write(String.valueOf(obj));
    }

    @Override // java.io.PrintWriter
    public void println() {
        try {
            synchronized (this.lock) {
                isOpen();
                this.out.write(System.lineSeparator());
            }
        } catch (InterruptedIOException ex) {
            LOG.debug(ex);
            Thread.currentThread().interrupt();
        } catch (IOException ex2) {
            setError(ex2);
        }
    }

    @Override // java.io.PrintWriter
    public void println(boolean b) {
        println(Boolean.toString(b));
    }

    @Override // java.io.PrintWriter
    public void println(char c) {
        try {
            synchronized (this.lock) {
                isOpen();
                this.out.write(c);
                this.out.write(System.lineSeparator());
            }
        } catch (InterruptedIOException ex) {
            LOG.debug(ex);
            Thread.currentThread().interrupt();
        } catch (IOException ex2) {
            setError(ex2);
        }
    }

    @Override // java.io.PrintWriter
    public void println(int x) {
        println(String.valueOf(x));
    }

    @Override // java.io.PrintWriter
    public void println(long x) {
        println(String.valueOf(x));
    }

    @Override // java.io.PrintWriter
    public void println(float x) {
        println(String.valueOf(x));
    }

    @Override // java.io.PrintWriter
    public void println(double x) {
        println(String.valueOf(x));
    }

    @Override // java.io.PrintWriter
    public void println(char[] s) {
        try {
            synchronized (this.lock) {
                isOpen();
                this.out.write(s, 0, s.length);
                this.out.write(System.lineSeparator());
            }
        } catch (InterruptedIOException ex) {
            LOG.debug(ex);
            Thread.currentThread().interrupt();
        } catch (IOException ex2) {
            setError(ex2);
        }
    }

    @Override // java.io.PrintWriter
    public void println(String s) {
        if (s == null) {
            s = "null";
        }
        try {
            synchronized (this.lock) {
                isOpen();
                this.out.write(s, 0, s.length());
                this.out.write(System.lineSeparator());
            }
        } catch (InterruptedIOException ex) {
            LOG.debug(ex);
            Thread.currentThread().interrupt();
        } catch (IOException ex2) {
            setError(ex2);
        }
    }

    @Override // java.io.PrintWriter
    public void println(Object x) {
        println(String.valueOf(x));
    }

    @Override // java.io.PrintWriter
    public PrintWriter printf(String format, Object... args) {
        return format(this._locale, format, args);
    }

    @Override // java.io.PrintWriter
    public PrintWriter printf(Locale l, String format, Object... args) {
        return format(l, format, args);
    }

    @Override // java.io.PrintWriter
    public PrintWriter format(String format, Object... args) {
        return format(this._locale, format, args);
    }

    @Override // java.io.PrintWriter
    public PrintWriter format(Locale locale, String format, Object... args) {
        if (locale == null) {
            try {
                locale = this._locale;
            } catch (InterruptedIOException ex) {
                LOG.debug(ex);
                Thread.currentThread().interrupt();
            } catch (IOException ex2) {
                setError(ex2);
            }
        }
        synchronized (this.lock) {
            isOpen();
            if (this._formatter == null) {
                this._formatter = new Formatter(this, locale);
            } else if (!this._formatter.locale().equals(locale)) {
                this._formatter = new Formatter(this, locale);
            }
            this._formatter.format(locale, format, args);
        }
        return this;
    }
}
