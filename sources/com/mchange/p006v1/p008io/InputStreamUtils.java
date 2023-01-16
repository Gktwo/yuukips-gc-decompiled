package com.mchange.p006v1.p008io;

import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.log.NullMLogger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* renamed from: com.mchange.v1.io.InputStreamUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/io/InputStreamUtils.class */
public final class InputStreamUtils {
    private static final MLogger logger = MLog.getLogger(InputStreamUtils.class);
    private static InputStream EMPTY_ISTREAM = new ByteArrayInputStream(new byte[0]);

    public static boolean compare(InputStream inputStream, InputStream inputStream2, long j) throws IOException {
        for (long j2 = 0; j2 < j; j2++) {
            int read = inputStream.read();
            if (read != inputStream2.read()) {
                return false;
            }
            if (read < 0) {
                return true;
            }
        }
        return true;
    }

    public static boolean compare(InputStream inputStream, InputStream inputStream2) throws IOException {
        int i = 0;
        while (i >= 0) {
            int read = inputStream.read();
            i = read;
            if (read != inputStream2.read()) {
                return false;
            }
        }
        return true;
    }

    public static byte[] getBytes(InputStream inputStream, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i);
        int i2 = 0;
        int read = inputStream.read();
        while (read >= 0 && i2 < i) {
            byteArrayOutputStream.write(read);
            read = inputStream.read();
            i2++;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int read = inputStream.read();
        while (read >= 0) {
            byteArrayOutputStream.write(read);
            read = inputStream.read();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String getContentsAsString(InputStream inputStream, String str) throws IOException, UnsupportedEncodingException {
        return new String(getBytes(inputStream), str);
    }

    public static String getContentsAsString(InputStream inputStream) throws IOException {
        try {
            return getContentsAsString(inputStream, System.getProperty("file.encoding", "8859_1"));
        } catch (UnsupportedEncodingException e) {
            throw new InternalError("You have no default character encoding, and iso-8859-1 is unsupported?!?!");
        }
    }

    public static String getContentsAsString(InputStream inputStream, int i, String str) throws IOException, UnsupportedEncodingException {
        return new String(getBytes(inputStream, i), str);
    }

    public static String getContentsAsString(InputStream inputStream, int i) throws IOException {
        try {
            return getContentsAsString(inputStream, i, System.getProperty("file.encoding", "8859_1"));
        } catch (UnsupportedEncodingException e) {
            throw new InternalError("You have no default character encoding, and iso-8859-1 is unsupported?!?!");
        }
    }

    public static InputStream getEmptyInputStream() {
        return EMPTY_ISTREAM;
    }

    public static void attemptClose(InputStream inputStream, MLogger mLogger) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                if (mLogger.isLoggable(MLevel.WARNING)) {
                    mLogger.log(MLevel.WARNING, "InputStream close FAILED.", (Throwable) e);
                }
            }
        }
    }

    public static void attemptClose(InputStream inputStream) {
        attemptClose(inputStream, logger);
    }

    public static void attemptCloseIgnore(InputStream inputStream) {
        attemptClose(inputStream, NullMLogger.instance());
    }

    public static void skipFully(InputStream inputStream, long j) throws EOFException, IOException {
        long j2 = 0;
        while (j2 < j) {
            long skip = inputStream.skip(j - j2);
            if (skip > 0) {
                j2 += skip;
            } else {
                inputStream.read();
                if (inputStream.read() < 0) {
                    throw new EOFException("Skipped only " + j2 + " bytes to end of file.");
                }
                j2++;
            }
        }
    }

    private InputStreamUtils() {
    }
}
