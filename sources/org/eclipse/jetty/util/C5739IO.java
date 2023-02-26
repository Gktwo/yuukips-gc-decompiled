package org.eclipse.jetty.util;

import dev.morphia.mapping.Mapper;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import p001ch.qos.logback.classic.pattern.CallerDataConverter;

/* renamed from: org.eclipse.jetty.util.IO */
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/IO.class */
public class C5739IO {
    public static final String CRLF = "\r\n";
    public static final int bufferSize = 65536;
    private static final Logger LOG = Log.getLogger(C5739IO.class);
    public static final byte[] CRLF_BYTES = {13, 10};
    private static NullOS __nullStream = new NullOS();
    private static ClosedIS __closedStream = new ClosedIS();
    private static NullWrite __nullWriter = new NullWrite();
    private static PrintWriter __nullPrintWriter = new PrintWriter(__nullWriter);

    /* renamed from: org.eclipse.jetty.util.IO$Job */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/IO$Job.class */
    static class Job implements Runnable {

        /* renamed from: in */
        InputStream f3122in;
        OutputStream out;
        Reader read;
        Writer write;

        Job(InputStream in, OutputStream out) {
            this.f3122in = in;
            this.out = out;
            this.read = null;
            this.write = null;
        }

        Job(Reader read, Writer write) {
            this.f3122in = null;
            this.out = null;
            this.read = read;
            this.write = write;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f3122in != null) {
                    C5739IO.copy(this.f3122in, this.out, -1);
                } else {
                    C5739IO.copy(this.read, this.write, -1);
                }
            } catch (IOException e) {
                C5739IO.LOG.ignore(e);
                try {
                    if (this.out != null) {
                        this.out.close();
                    }
                    if (this.write != null) {
                        this.write.close();
                    }
                } catch (IOException ex2) {
                    C5739IO.LOG.ignore(ex2);
                }
            }
        }
    }

    public static void copy(InputStream in, OutputStream out) throws IOException {
        copy(in, out, -1);
    }

    public static void copy(Reader in, Writer out) throws IOException {
        copy(in, out, -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v18, types: [long] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copy(java.io.InputStream r5, java.io.OutputStream r6, long r7) throws java.io.IOException {
        /*
            r0 = 65536(0x10000, float:9.18355E-41)
            byte[] r0 = new byte[r0]
            r9 = r0
            r0 = 65536(0x10000, float:9.18355E-41)
            r10 = r0
            r0 = r7
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x004d
        L_0x0010:
            r0 = r7
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x006c
            r0 = r7
            r1 = 65536(0x10000, double:3.2379E-319)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0023
            r0 = r7
            int r0 = (int) r0
            goto L_0x0025
        L_0x0023:
            r0 = 65536(0x10000, float:9.18355E-41)
        L_0x0025:
            r11 = r0
            r0 = r5
            r1 = r9
            r2 = 0
            r3 = r11
            int r0 = r0.read(r1, r2, r3)
            r10 = r0
            r0 = r10
            r1 = -1
            if (r0 != r1) goto L_0x003b
            goto L_0x006c
        L_0x003b:
            r0 = r7
            r1 = r10
            long r1 = (long) r1
            long r0 = r0 - r1
            r7 = r0
            r0 = r6
            r1 = r9
            r2 = 0
            r3 = r10
            r0.write(r1, r2, r3)
            goto L_0x0010
        L_0x004d:
            r0 = r5
            r1 = r9
            r2 = 0
            r3 = 65536(0x10000, float:9.18355E-41)
            int r0 = r0.read(r1, r2, r3)
            r10 = r0
            r0 = r10
            if (r0 >= 0) goto L_0x0060
            goto L_0x006c
        L_0x0060:
            r0 = r6
            r1 = r9
            r2 = 0
            r3 = r10
            r0.write(r1, r2, r3)
            goto L_0x004d
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.C5739IO.copy(java.io.InputStream, java.io.OutputStream, long):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v25, types: [long] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copy(java.io.Reader r6, java.io.Writer r7, long r8) throws java.io.IOException {
        /*
            r0 = 65536(0x10000, float:9.18355E-41)
            char[] r0 = new char[r0]
            r10 = r0
            r0 = 65536(0x10000, float:9.18355E-41)
            r11 = r0
            r0 = r8
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0052
        L_0x0010:
            r0 = r8
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x00aa
            r0 = r8
            r1 = 65536(0x10000, double:3.2379E-319)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x002c
            r0 = r6
            r1 = r10
            r2 = 0
            r3 = r8
            int r3 = (int) r3
            int r0 = r0.read(r1, r2, r3)
            r11 = r0
            goto L_0x0037
        L_0x002c:
            r0 = r6
            r1 = r10
            r2 = 0
            r3 = 65536(0x10000, float:9.18355E-41)
            int r0 = r0.read(r1, r2, r3)
            r11 = r0
        L_0x0037:
            r0 = r11
            r1 = -1
            if (r0 != r1) goto L_0x0040
            goto L_0x00aa
        L_0x0040:
            r0 = r8
            r1 = r11
            long r1 = (long) r1
            long r0 = r0 - r1
            r8 = r0
            r0 = r7
            r1 = r10
            r2 = 0
            r3 = r11
            r0.write(r1, r2, r3)
            goto L_0x0010
        L_0x0052:
            r0 = r7
            boolean r0 = r0 instanceof java.io.PrintWriter
            if (r0 == 0) goto L_0x008a
            r0 = r7
            java.io.PrintWriter r0 = (java.io.PrintWriter) r0
            r12 = r0
        L_0x005f:
            r0 = r12
            boolean r0 = r0.checkError()
            if (r0 != 0) goto L_0x0087
            r0 = r6
            r1 = r10
            r2 = 0
            r3 = 65536(0x10000, float:9.18355E-41)
            int r0 = r0.read(r1, r2, r3)
            r11 = r0
            r0 = r11
            r1 = -1
            if (r0 != r1) goto L_0x007b
            goto L_0x0087
        L_0x007b:
            r0 = r7
            r1 = r10
            r2 = 0
            r3 = r11
            r0.write(r1, r2, r3)
            goto L_0x005f
        L_0x0087:
            goto L_0x00aa
        L_0x008a:
            r0 = r6
            r1 = r10
            r2 = 0
            r3 = 65536(0x10000, float:9.18355E-41)
            int r0 = r0.read(r1, r2, r3)
            r11 = r0
            r0 = r11
            r1 = -1
            if (r0 != r1) goto L_0x009e
            goto L_0x00aa
        L_0x009e:
            r0 = r7
            r1 = r10
            r2 = 0
            r3 = r11
            r0.write(r1, r2, r3)
            goto L_0x008a
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.C5739IO.copy(java.io.Reader, java.io.Writer, long):void");
    }

    public static void copy(File from, File to) throws IOException {
        if (from.isDirectory()) {
            copyDir(from, to);
        } else {
            copyFile(from, to);
        }
    }

    public static void copyDir(File from, File to) throws IOException {
        if (!to.exists()) {
            to.mkdirs();
        } else if (!to.isDirectory()) {
            throw new IllegalArgumentException(to.toString());
        }
        File[] files = from.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String name = files[i].getName();
                if (!Mapper.IGNORED_FIELDNAME.equals(name) && !CallerDataConverter.DEFAULT_RANGE_DELIMITER.equals(name)) {
                    copy(files[i], new File(to, name));
                }
            }
        }
    }

    public static void copyFile(File from, File to) throws IOException {
        InputStream in = new FileInputStream(from);
        try {
            OutputStream out = new FileOutputStream(to);
            copy(in, out);
            out.close();
            in.close();
        } catch (Throwable th) {
            try {
                in.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static String toString(Path path, Charset charset) throws IOException {
        return new String(Files.readAllBytes(path), charset);
    }

    public static String toString(InputStream in) throws IOException {
        return toString(in, (Charset) null);
    }

    public static String toString(InputStream in, String encoding) throws IOException {
        return toString(in, encoding == null ? null : Charset.forName(encoding));
    }

    public static String toString(InputStream in, Charset encoding) throws IOException {
        StringWriter writer = new StringWriter();
        copy(encoding == null ? new InputStreamReader(in) : new InputStreamReader(in, encoding), writer);
        return writer.toString();
    }

    public static String toString(Reader in) throws IOException {
        StringWriter writer = new StringWriter();
        copy(in, writer);
        return writer.toString();
    }

    public static boolean delete(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            int i = 0;
            while (files != null && i < files.length) {
                delete(files[i]);
                i++;
            }
        }
        return file.delete();
    }

    public static boolean isEmptyDir(File dir) {
        if (dir == null || !dir.exists()) {
            return true;
        }
        if (!dir.isDirectory()) {
            return false;
        }
        String[] list = dir.list();
        return list == null || list.length <= 0;
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException ignore) {
                LOG.ignore(ignore);
            }
        }
    }

    public static void close(InputStream is) {
        close((Closeable) is);
    }

    public static void close(OutputStream os) {
        close((Closeable) os);
    }

    public static void close(Reader reader) {
        close((Closeable) reader);
    }

    public static void close(Writer writer) {
        close((Closeable) writer);
    }

    public static byte[] readBytes(InputStream in) throws IOException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        copy(in, bout);
        return bout.toByteArray();
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [long] */
    public static long write(GatheringByteChannel out, ByteBuffer[] buffers, int offset, int length) throws IOException {
        char c = 0;
        while (length > 0) {
            long wrote = out.write(buffers, offset, length);
            if (wrote != 0) {
                c += wrote;
                int i = offset;
                while (true) {
                    if (i >= buffers.length) {
                        length = 0;
                        break;
                    } else if (buffers[i].hasRemaining()) {
                        length -= i - offset;
                        offset = i;
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                break;
            }
        }
        return c;
    }

    public static OutputStream getNullStream() {
        return __nullStream;
    }

    public static InputStream getClosedStream() {
        return __closedStream;
    }

    /* renamed from: org.eclipse.jetty.util.IO$NullOS */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/IO$NullOS.class */
    private static class NullOS extends OutputStream {
        private NullOS() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.OutputStream
        public void write(byte[] b) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] b, int i, int l) {
        }

        @Override // java.io.OutputStream
        public void write(int b) {
        }
    }

    /* renamed from: org.eclipse.jetty.util.IO$ClosedIS */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/IO$ClosedIS.class */
    private static class ClosedIS extends InputStream {
        private ClosedIS() {
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            return -1;
        }
    }

    public static Writer getNullWriter() {
        return __nullWriter;
    }

    public static PrintWriter getNullPrintWriter() {
        return __nullPrintWriter;
    }

    /* renamed from: org.eclipse.jetty.util.IO$NullWrite */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/IO$NullWrite.class */
    private static class NullWrite extends Writer {
        private NullWrite() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] b) {
        }

        @Override // java.io.Writer
        public void write(char[] b, int o, int l) {
        }

        @Override // java.io.Writer
        public void write(int b) {
        }

        @Override // java.io.Writer
        public void write(String s) {
        }

        @Override // java.io.Writer
        public void write(String s, int o, int l) {
        }
    }
}
