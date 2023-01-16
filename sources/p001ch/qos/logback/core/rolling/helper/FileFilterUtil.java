package p001ch.qos.logback.core.rolling.helper;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: ch.qos.logback.core.rolling.helper.FileFilterUtil */
/* loaded from: grasscutter.jar:ch/qos/logback/core/rolling/helper/FileFilterUtil.class */
public class FileFilterUtil {
    public static void sortFileArrayByName(File[] fileArray) {
        Arrays.sort(fileArray, new Comparator<File>() { // from class: ch.qos.logback.core.rolling.helper.FileFilterUtil.1
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public static void reverseSortFileArrayByName(File[] fileArray) {
        Arrays.sort(fileArray, new Comparator<File>() { // from class: ch.qos.logback.core.rolling.helper.FileFilterUtil.2
            public int compare(File o1, File o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });
    }

    public static String afterLastSlash(String sregex) {
        int i = sregex.lastIndexOf(47);
        if (i == -1) {
            return sregex;
        }
        return sregex.substring(i + 1);
    }

    public static boolean isEmptyDirectory(File dir) {
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("[" + dir + "] must be a directory");
        }
        String[] filesInDir = dir.list();
        if (filesInDir == null || filesInDir.length == 0) {
            return true;
        }
        return false;
    }

    public static File[] filesInFolderMatchingStemRegex(File file, final String stemRegex) {
        if (file == null) {
            return new File[0];
        }
        if (!file.exists() || !file.isDirectory()) {
            return new File[0];
        }
        return file.listFiles(new FilenameFilter() { // from class: ch.qos.logback.core.rolling.helper.FileFilterUtil.3
            @Override // java.io.FilenameFilter
            public boolean accept(File dir, String name) {
                return name.matches(stemRegex);
            }
        });
    }

    public static int findHighestCounter(File[] matchingFileArray, String stemRegex) {
        int max = Integer.MIN_VALUE;
        for (File aFile : matchingFileArray) {
            int aCounter = extractCounter(aFile, stemRegex);
            if (max < aCounter) {
                max = aCounter;
            }
        }
        return max;
    }

    public static int extractCounter(File file, String stemRegex) {
        Pattern p = Pattern.compile(stemRegex);
        String lastFileName = file.getName();
        Matcher m = p.matcher(lastFileName);
        if (m.matches()) {
            return new Integer(m.group(1)).intValue();
        }
        throw new IllegalStateException("The regex [" + stemRegex + "] should match [" + lastFileName + "]");
    }

    public static String slashify(String in) {
        return in.replace('\\', '/');
    }

    public static void removeEmptyParentDirectories(File file, int recursivityCount) {
        if (recursivityCount < 3) {
            File parent = file.getParentFile();
            if (parent.isDirectory() && isEmptyDirectory(parent)) {
                parent.delete();
                removeEmptyParentDirectories(parent, recursivityCount + 1);
            }
        }
    }
}
