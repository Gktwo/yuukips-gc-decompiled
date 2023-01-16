package com.mchange.p009v2.p010io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.mchange.v2.io.FileUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/io/FileUtils.class */
public final class FileUtils {
    public static File findRelativeToParent(File file, File file2) throws IOException {
        String path = file.getPath();
        String path2 = file2.getPath();
        if (!path2.startsWith(path)) {
            throw new IllegalArgumentException(path2 + " is not a child of " + path + " [no transformations or canonicalizations tried]");
        }
        File file3 = new File(path2.substring(path.length()));
        if (file3.isAbsolute()) {
            file3 = new File(file3.getPath().substring(1));
        }
        return file3;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [long] */
    public static long diskSpaceUsed(File file) throws IOException {
        char c = 0;
        FileIterator depthFirstEagerDescent = DirectoryDescentUtils.depthFirstEagerDescent(file);
        while (depthFirstEagerDescent.hasNext()) {
            File nextFile = depthFirstEagerDescent.nextFile();
            if (nextFile.isFile()) {
                c += nextFile.length();
            }
        }
        return c;
    }

    public static void touchExisting(File file) throws IOException {
        if (file.exists()) {
            unguardedTouch(file);
        }
    }

    public static void touch(File file) throws IOException {
        if (!file.exists()) {
            createEmpty(file);
        }
        unguardedTouch(file);
    }

    public static void createEmpty(File file) throws IOException {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rws");
            randomAccessFile.setLength(0);
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable th) {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    throw th;
                }
            }
            throw th;
        }
    }

    private static void unguardedTouch(File file) throws IOException {
        file.setLastModified(System.currentTimeMillis());
    }

    private FileUtils() {
    }
}
