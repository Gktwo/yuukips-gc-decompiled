package p001ch.qos.logback.core.rolling.helper;

import java.io.File;
import p001ch.qos.logback.core.rolling.RollingFileAppender;
import p001ch.qos.logback.core.rolling.RolloverFailure;
import p001ch.qos.logback.core.spi.ContextAwareBase;
import p001ch.qos.logback.core.util.EnvUtil;
import p001ch.qos.logback.core.util.FileUtil;

/* renamed from: ch.qos.logback.core.rolling.helper.RenameUtil */
/* loaded from: grasscutter.jar:ch/qos/logback/core/rolling/helper/RenameUtil.class */
public class RenameUtil extends ContextAwareBase {
    static String RENAMING_ERROR_URL = "http://logback.qos.ch/codes.html#renamingError";

    public void rename(String src, String target) throws RolloverFailure {
        if (src.equals(target)) {
            addWarn("Source and target files are the same [" + src + "]. Skipping.");
            return;
        }
        File srcFile = new File(src);
        if (srcFile.exists()) {
            File targetFile = new File(target);
            createMissingTargetDirsIfNecessary(targetFile);
            addInfo("Renaming file [" + srcFile + "] to [" + targetFile + "]");
            if (!srcFile.renameTo(targetFile)) {
                addWarn("Failed to rename file [" + srcFile + "] as [" + targetFile + "].");
                if (Boolean.TRUE.equals(areOnDifferentVolumes(srcFile, targetFile))) {
                    addWarn("Detected different file systems for source [" + src + "] and target [" + target + "]. Attempting rename by copying.");
                    renameByCopying(src, target);
                    return;
                }
                addWarn("Please consider leaving the [file] option of " + RollingFileAppender.class.getSimpleName() + " empty.");
                addWarn("See also " + RENAMING_ERROR_URL);
                return;
            }
            return;
        }
        throw new RolloverFailure("File [" + src + "] does not exist.");
    }

    Boolean areOnDifferentVolumes(File srcFile, File targetFile) throws RolloverFailure {
        if (!EnvUtil.isJDK7OrHigher()) {
            return false;
        }
        File parentOfTarget = targetFile.getAbsoluteFile().getParentFile();
        if (parentOfTarget == null) {
            addWarn("Parent of target file [" + targetFile + "] is null");
            return null;
        } else if (!parentOfTarget.exists()) {
            addWarn("Parent of target file [" + targetFile + "] does not exist");
            return null;
        } else {
            try {
                return Boolean.valueOf(!FileStoreUtil.areOnSameFileStore(srcFile, parentOfTarget));
            } catch (RolloverFailure rf) {
                addWarn("Error while checking file store equality", rf);
                return null;
            }
        }
    }

    public void renameByCopying(String src, String target) throws RolloverFailure {
        new FileUtil(getContext()).copy(src, target);
        if (!new File(src).delete()) {
            addWarn("Could not delete " + src);
        }
    }

    void createMissingTargetDirsIfNecessary(File toFile) throws RolloverFailure {
        if (!FileUtil.createMissingParentDirectories(toFile)) {
            throw new RolloverFailure("Failed to create parent directories for [" + toFile.getAbsolutePath() + "]");
        }
    }

    public String toString() {
        return "c.q.l.co.rolling.helper.RenameUtil";
    }
}
