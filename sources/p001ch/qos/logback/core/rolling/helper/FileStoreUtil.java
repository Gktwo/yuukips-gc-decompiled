package p001ch.qos.logback.core.rolling.helper;

import java.io.File;
import java.lang.reflect.Method;
import p001ch.qos.logback.core.rolling.RolloverFailure;

/* renamed from: ch.qos.logback.core.rolling.helper.FileStoreUtil */
/* loaded from: grasscutter.jar:ch/qos/logback/core/rolling/helper/FileStoreUtil.class */
public class FileStoreUtil {
    static final String PATH_CLASS_STR = "java.nio.file.Path";
    static final String FILES_CLASS_STR = "java.nio.file.Files";

    public static boolean areOnSameFileStore(File a, File b) throws RolloverFailure {
        if (!a.exists()) {
            throw new IllegalArgumentException("File [" + a + "] does not exist.");
        } else if (!b.exists()) {
            throw new IllegalArgumentException("File [" + b + "] does not exist.");
        } else {
            try {
                Class<?> pathClass = Class.forName(PATH_CLASS_STR);
                Class<?> filesClass = Class.forName(FILES_CLASS_STR);
                Method toPath = File.class.getMethod("toPath", new Class[0]);
                Method getFileStoreMethod = filesClass.getMethod("getFileStore", pathClass);
                return getFileStoreMethod.invoke(null, toPath.invoke(a, new Object[0])).equals(getFileStoreMethod.invoke(null, toPath.invoke(b, new Object[0])));
            } catch (Exception e) {
                throw new RolloverFailure("Failed to check file store equality for [" + a + "] and [" + b + "]", e);
            }
        }
    }
}
