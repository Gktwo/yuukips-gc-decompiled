package com.mchange.p005io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* renamed from: com.mchange.io.FileUtils */
/* loaded from: grasscutter.jar:com/mchange/io/FileUtils.class */
public final class FileUtils {
    public static byte[] getBytes(File file, int i) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            byte[] bytes = InputStreamUtils.getBytes(bufferedInputStream, i);
            InputStreamUtils.attemptClose(bufferedInputStream);
            return bytes;
        } catch (Throwable th) {
            InputStreamUtils.attemptClose(bufferedInputStream);
            throw th;
        }
    }

    public static byte[] getBytes(File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            return InputStreamUtils.getBytes(bufferedInputStream);
        } finally {
            InputStreamUtils.attemptClose(bufferedInputStream);
        }
    }

    public static String getContentsAsString(File file, String str) throws IOException, UnsupportedEncodingException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            String contentsAsString = InputStreamUtils.getContentsAsString(bufferedInputStream, str);
            InputStreamUtils.attemptClose(bufferedInputStream);
            return contentsAsString;
        } catch (Throwable th) {
            InputStreamUtils.attemptClose(bufferedInputStream);
            throw th;
        }
    }

    public static String getContentsAsString(File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            return InputStreamUtils.getContentsAsString(bufferedInputStream);
        } finally {
            InputStreamUtils.attemptClose(bufferedInputStream);
        }
    }

    public static String getContentsAsString(File file, int i, String str) throws IOException, UnsupportedEncodingException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            String contentsAsString = InputStreamUtils.getContentsAsString(bufferedInputStream, i, str);
            InputStreamUtils.attemptClose(bufferedInputStream);
            return contentsAsString;
        } catch (Throwable th) {
            InputStreamUtils.attemptClose(bufferedInputStream);
            throw th;
        }
    }

    public static String getContentsAsString(File file, int i) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            String contentsAsString = InputStreamUtils.getContentsAsString(bufferedInputStream, i);
            InputStreamUtils.attemptClose(bufferedInputStream);
            return contentsAsString;
        } catch (Throwable th) {
            InputStreamUtils.attemptClose(bufferedInputStream);
            throw th;
        }
    }

    private FileUtils() {
    }
}
