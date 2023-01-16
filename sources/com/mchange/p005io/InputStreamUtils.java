package com.mchange.p005io;

import com.mchange.util.RobustMessageLogger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* renamed from: com.mchange.io.InputStreamUtils */
/* loaded from: grasscutter.jar:com/mchange/io/InputStreamUtils.class */
public final class InputStreamUtils {
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

    public static void attemptClose(InputStream inputStream) {
        attemptClose(inputStream, null);
    }

    public static void attemptClose(InputStream inputStream, RobustMessageLogger robustMessageLogger) {
        try {
            inputStream.close();
        } catch (IOException e) {
            if (robustMessageLogger != null) {
                robustMessageLogger.log(e, "IOException trying to close InputStream");
            }
        } catch (NullPointerException e2) {
            if (robustMessageLogger != null) {
                robustMessageLogger.log(e2, "NullPointerException trying to close InputStream");
            }
        }
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
