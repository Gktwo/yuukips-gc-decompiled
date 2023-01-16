package nonapi.p019io.github.classgraph.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import p013io.github.classgraph.ClassGraphException;

/* renamed from: nonapi.io.github.classgraph.utils.FileUtils */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/utils/FileUtils.class */
public final class FileUtils {
    private static Method cleanMethod;
    private static Method attachmentMethod;
    private static Object theUnsafe;
    public static final String CURR_DIR_PATH;
    public static final int MAX_BUFFER_SIZE = 2147483639;

    private FileUtils() {
    }

    static {
        String currDirPathStr = "";
        try {
            Path currDirPath = Paths.get("", new String[0]).toAbsolutePath();
            currDirPath.toString();
            Path currDirPath2 = currDirPath.normalize();
            currDirPath2.toString();
            currDirPathStr = FastPathResolver.resolve(currDirPath2.toRealPath(LinkOption.NOFOLLOW_LINKS).toString());
            CURR_DIR_PATH = currDirPathStr;
            AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: nonapi.io.github.classgraph.utils.FileUtils.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    FileUtils.lookupCleanMethodPrivileged();
                    return null;
                }
            });
        } catch (IOException e) {
            throw ClassGraphException.newClassGraphException("Could not resolve current directory: " + currDirPathStr, e);
        }
    }

    public static String sanitizeEntryPath(String path, boolean removeInitialSlash, boolean removeFinalSlash) {
        if (path.isEmpty()) {
            return "";
        }
        boolean foundSegmentToSanitize = false;
        int pathLen = path.length();
        char[] pathChars = new char[pathLen];
        path.getChars(0, pathLen, pathChars, 0);
        int lastSepIdx = -1;
        char prevC = 0;
        int i = 0;
        int ii = pathLen + 1;
        while (i < ii) {
            char c = i == pathLen ? 0 : pathChars[i];
            if (c == '/' || c == '!' || c == 0) {
                int segmentLength = i - (lastSepIdx + 1);
                if ((segmentLength == 0 && prevC == c) || ((segmentLength == 1 && pathChars[i - 1] == '.') || (segmentLength == 2 && pathChars[i - 2] == '.' && pathChars[i - 1] == '.'))) {
                    foundSegmentToSanitize = true;
                }
                lastSepIdx = i;
            }
            prevC = c;
            i++;
        }
        boolean pathHasInitialSlash = pathLen > 0 && pathChars[0] == '/';
        StringBuilder pathSanitized = new StringBuilder(pathLen + 16);
        if (foundSegmentToSanitize) {
            List<List<CharSequence>> allSectionSegments = new ArrayList<>();
            List<CharSequence> currSectionSegments = new ArrayList<>();
            allSectionSegments.add(currSectionSegments);
            int lastSepIdx2 = -1;
            int i2 = 0;
            while (i2 < pathLen + 1) {
                char c2 = i2 == pathLen ? 0 : pathChars[i2];
                if (c2 == '/' || c2 == '!' || c2 == 0) {
                    int segmentStartIdx = lastSepIdx2 + 1;
                    int segmentLen = i2 - segmentStartIdx;
                    if (!(segmentLen == 0 || (segmentLen == 1 && pathChars[segmentStartIdx] == '.'))) {
                        if (segmentLen != 2 || pathChars[segmentStartIdx] != '.' || pathChars[segmentStartIdx + 1] != '.') {
                            currSectionSegments.add(path.subSequence(segmentStartIdx, segmentStartIdx + segmentLen));
                        } else if (!currSectionSegments.isEmpty()) {
                            currSectionSegments.remove(currSectionSegments.size() - 1);
                        }
                    }
                    if (c2 == '!' && !currSectionSegments.isEmpty()) {
                        currSectionSegments = new ArrayList<>();
                        allSectionSegments.add(currSectionSegments);
                    }
                    lastSepIdx2 = i2;
                }
                i2++;
            }
            for (List<CharSequence> sectionSegments : allSectionSegments) {
                if (!sectionSegments.isEmpty()) {
                    if (pathSanitized.length() > 0) {
                        pathSanitized.append('!');
                    }
                    for (CharSequence sectionSegment : sectionSegments) {
                        pathSanitized.append('/');
                        pathSanitized.append(sectionSegment);
                    }
                }
            }
            if (pathSanitized.length() == 0 && pathHasInitialSlash) {
                pathSanitized.append('/');
            }
        } else {
            pathSanitized.append(path);
        }
        int startIdx = 0;
        if (removeInitialSlash || !pathHasInitialSlash) {
            while (startIdx < pathSanitized.length() && pathSanitized.charAt(startIdx) == '/') {
                startIdx++;
            }
        }
        if (removeFinalSlash) {
            while (pathSanitized.length() > 0 && pathSanitized.charAt(pathSanitized.length() - 1) == '/') {
                pathSanitized.setLength(pathSanitized.length() - 1);
            }
        }
        return pathSanitized.substring(startIdx);
    }

    public static boolean isClassfile(String path) {
        int len = path.length();
        return len > 6 && path.regionMatches(true, len - 6, ".class", 0, 6);
    }

    public static boolean canRead(File file) {
        try {
            return file.canRead();
        } catch (SecurityException e) {
            return false;
        }
    }

    public static boolean canReadAndIsFile(File file) {
        try {
            if (!file.canRead()) {
                return false;
            }
            return file.isFile();
        } catch (SecurityException e) {
            return false;
        }
    }

    public static boolean canReadAndIsFile(Path path) {
        try {
            if (!Files.exists(path, new LinkOption[0])) {
                return false;
            }
            return Files.isRegularFile(path, new LinkOption[0]);
        } catch (SecurityException e) {
            return false;
        }
    }

    public static void checkCanReadAndIsFile(File file) throws IOException {
        try {
            if (!file.canRead()) {
                throw new FileNotFoundException("File does not exist or cannot be read: " + file);
            } else if (!file.isFile()) {
                throw new IOException("Not a regular file: " + file);
            }
        } catch (SecurityException e) {
            throw new FileNotFoundException("File " + file + " cannot be accessed: " + e);
        }
    }

    public static void checkCanReadAndIsFile(Path path) throws IOException {
        try {
            if (!Files.exists(path, new LinkOption[0])) {
                throw new FileNotFoundException("Path does not exist or cannot be read: " + path);
            } else if (!Files.isRegularFile(path, new LinkOption[0])) {
                throw new IOException("Not a regular file: " + path);
            }
        } catch (SecurityException e) {
            throw new FileNotFoundException("Path " + path + " cannot be accessed: " + e);
        }
    }

    public static boolean canReadAndIsDir(File file) {
        try {
            if (!file.canRead()) {
                return false;
            }
            return file.isDirectory();
        } catch (SecurityException e) {
            return false;
        }
    }

    public static boolean canReadAndIsDir(Path path) {
        try {
            if (!Files.exists(path, new LinkOption[0])) {
                return false;
            }
            return Files.isDirectory(path, new LinkOption[0]);
        } catch (SecurityException e) {
            return false;
        }
    }

    public static void checkCanReadAndIsDir(File file) throws IOException {
        try {
            if (!file.canRead()) {
                throw new FileNotFoundException("Directory does not exist or cannot be read: " + file);
            } else if (!file.isDirectory()) {
                throw new IOException("Not a directory: " + file);
            }
        } catch (SecurityException e) {
            throw new FileNotFoundException("File " + file + " cannot be accessed: " + e);
        }
    }

    public static String getParentDirPath(String path, char separator) {
        int lastSlashIdx = path.lastIndexOf(separator);
        if (lastSlashIdx <= 0) {
            return "";
        }
        return path.substring(0, lastSlashIdx);
    }

    public static String getParentDirPath(String path) {
        return getParentDirPath(path, '/');
    }

    /* access modifiers changed from: private */
    public static void lookupCleanMethodPrivileged() {
        Class<?> unsafeClass;
        if (VersionFinder.JAVA_MAJOR_VERSION < 9) {
            try {
                cleanMethod = Class.forName("sun.misc.Cleaner").getMethod("clean", new Class[0]);
                cleanMethod.setAccessible(true);
                attachmentMethod = Class.forName("sun.nio.ch.DirectBuffer").getMethod("attachment", new Class[0]);
                attachmentMethod.setAccessible(true);
            } catch (LinkageError | ReflectiveOperationException e) {
            } catch (SecurityException e2) {
                throw ClassGraphException.newClassGraphException("You need to grant classgraph RuntimePermission(\"accessClassInPackage.sun.misc\"), RuntimePermission(\"accessClassInPackage.sun.nio.ch\"), and ReflectPermission(\"suppressAccessChecks\")", e2);
            }
        } else {
            try {
                try {
                    unsafeClass = Class.forName("sun.misc.Unsafe");
                } catch (LinkageError | ReflectiveOperationException e3) {
                    unsafeClass = Class.forName("jdk.internal.misc.Unsafe");
                }
                Field theUnsafeField = unsafeClass.getDeclaredField("theUnsafe");
                theUnsafeField.setAccessible(true);
                theUnsafe = theUnsafeField.get(null);
                cleanMethod = unsafeClass.getMethod("invokeCleaner", ByteBuffer.class);
                cleanMethod.setAccessible(true);
            } catch (LinkageError | ReflectiveOperationException e4) {
            } catch (SecurityException e5) {
                throw ClassGraphException.newClassGraphException("You need to grant classgraph RuntimePermission(\"accessClassInPackage.sun.misc\"), RuntimePermission(\"accessClassInPackage.jdk.internal.misc\") and ReflectPermission(\"suppressAccessChecks\")", e5);
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean closeDirectByteBufferPrivileged(ByteBuffer byteBuffer, LogNode log) {
        try {
            if (cleanMethod == null) {
                if (log == null) {
                    return false;
                }
                log.log("Could not unmap ByteBuffer, cleanMethod == null");
                return false;
            } else if (VersionFinder.JAVA_MAJOR_VERSION < 9) {
                if (attachmentMethod == null) {
                    if (log == null) {
                        return false;
                    }
                    log.log("Could not unmap ByteBuffer, attachmentMethod == null");
                    return false;
                } else if (attachmentMethod.invoke(byteBuffer, new Object[0]) != null) {
                    return false;
                } else {
                    Method cleaner = byteBuffer.getClass().getMethod("cleaner", new Class[0]);
                    if (cleaner != null) {
                        try {
                            cleaner.setAccessible(true);
                            if (cleaner.invoke(byteBuffer, new Object[0]) != null) {
                                try {
                                    cleanMethod.invoke(cleaner.invoke(byteBuffer, new Object[0]), new Object[0]);
                                    return true;
                                } catch (Exception e) {
                                    if (log == null) {
                                        return false;
                                    }
                                    log.log("Could not unmap ByteBuffer, cleanMethod.invoke(cleanerResult) failed: " + e);
                                    return false;
                                }
                            } else if (log == null) {
                                return false;
                            } else {
                                log.log("Could not unmap ByteBuffer, cleanerResult == null");
                                return false;
                            }
                        } catch (Exception e2) {
                            if (log == null) {
                                return false;
                            }
                            log.log("Could not unmap ByteBuffer, cleaner.setAccessible(true) failed");
                            return false;
                        }
                    } else if (log == null) {
                        return false;
                    } else {
                        log.log("Could not unmap ByteBuffer, cleaner == null");
                        return false;
                    }
                }
            } else if (theUnsafe != null) {
                try {
                    cleanMethod.invoke(theUnsafe, byteBuffer);
                    return true;
                } catch (IllegalArgumentException e3) {
                    return false;
                }
            } else if (log == null) {
                return false;
            } else {
                log.log("Could not unmap ByteBuffer, theUnsafe == null");
                return false;
            }
        } catch (ReflectiveOperationException | SecurityException e4) {
            if (log == null) {
                return false;
            }
            log.log("Could not unmap ByteBuffer: " + e4);
            return false;
        }
    }

    public static boolean closeDirectByteBuffer(final ByteBuffer byteBuffer, final LogNode log) {
        if (byteBuffer == null || !byteBuffer.isDirect()) {
            return false;
        }
        return ((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: nonapi.io.github.classgraph.utils.FileUtils.2
            @Override // java.security.PrivilegedAction
            public Boolean run() {
                return Boolean.valueOf(FileUtils.closeDirectByteBufferPrivileged(byteBuffer, log));
            }
        })).booleanValue();
    }
}
