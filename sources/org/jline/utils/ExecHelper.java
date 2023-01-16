package org.jline.utils;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.ProcessBuilder;
import java.util.Objects;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/ExecHelper.class */
public final class ExecHelper {
    private ExecHelper() {
    }

    public static String exec(boolean redirectInput, String... cmd) throws IOException {
        Objects.requireNonNull(cmd);
        try {
            Log.trace("Running: ", cmd);
            ProcessBuilder pb = new ProcessBuilder(cmd);
            if (redirectInput) {
                pb.redirectInput(ProcessBuilder.Redirect.INHERIT);
            }
            Process p = pb.start();
            String result = waitAndCapture(p);
            Log.trace("Result: ", result);
            if (p.exitValue() == 0) {
                return result;
            }
            if (result.endsWith("\n")) {
                result = result.substring(0, result.length() - 1);
            }
            throw new IOException("Error executing '" + String.join(" ", cmd) + "': " + result);
        } catch (InterruptedException e) {
            throw ((IOException) new InterruptedIOException("Command interrupted").initCause(e));
        }
    }

    public static String waitAndCapture(Process p) throws IOException, InterruptedException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        InputStream in = null;
        InputStream err = null;
        OutputStream out = null;
        try {
            in = p.getInputStream();
            while (true) {
                int c = in.read();
                if (c == -1) {
                    break;
                }
                bout.write(c);
            }
            err = p.getErrorStream();
            while (true) {
                int c2 = err.read();
                if (c2 != -1) {
                    bout.write(c2);
                } else {
                    out = p.getOutputStream();
                    p.waitFor();
                    close(in, out, err);
                    return bout.toString();
                }
            }
        } catch (Throwable th) {
            close(in, out, err);
            throw th;
        }
    }

    private static void close(Closeable... closeables) {
        for (Closeable c : closeables) {
            if (c != null) {
                try {
                    c.close();
                } catch (Exception e) {
                }
            }
        }
    }
}
