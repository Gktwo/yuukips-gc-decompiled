package org.jline.utils;

import java.io.File;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/OSUtils.class */
public class OSUtils {
    public static final boolean IS_WINDOWS = System.getProperty("os.name").toLowerCase().contains("win");
    public static final boolean IS_CYGWIN;
    @Deprecated
    public static final boolean IS_MINGW;
    public static final boolean IS_MSYSTEM;
    public static final boolean IS_CONEMU;
    public static final boolean IS_OSX;
    public static String TTY_COMMAND;
    public static String STTY_COMMAND;
    public static String STTY_F_OPTION;
    public static String INFOCMP_COMMAND;

    static {
        String infocmp;
        String sttyfopt;
        String stty;
        String tty;
        IS_CYGWIN = IS_WINDOWS && System.getenv("PWD") != null && System.getenv("PWD").startsWith("/");
        IS_MINGW = IS_WINDOWS && System.getenv("MSYSTEM") != null && System.getenv("MSYSTEM").startsWith("MINGW");
        IS_MSYSTEM = IS_WINDOWS && System.getenv("MSYSTEM") != null && (System.getenv("MSYSTEM").startsWith("MINGW") || System.getenv("MSYSTEM").equals("MSYS"));
        IS_CONEMU = IS_WINDOWS && System.getenv("ConEmuPID") != null;
        IS_OSX = System.getProperty("os.name").toLowerCase().contains("mac");
        if (IS_CYGWIN || IS_MSYSTEM) {
            tty = "tty.exe";
            stty = "stty.exe";
            sttyfopt = null;
            infocmp = "infocmp.exe";
            String path = System.getenv("PATH");
            if (path != null) {
                String[] paths = path.split(";");
                for (String p : paths) {
                    if (tty == null && new File(p, "tty.exe").exists()) {
                        tty = new File(p, "tty.exe").getAbsolutePath();
                    }
                    if (stty == null && new File(p, "stty.exe").exists()) {
                        stty = new File(p, "stty.exe").getAbsolutePath();
                    }
                    if (infocmp == null && new File(p, "infocmp.exe").exists()) {
                        infocmp = new File(p, "infocmp.exe").getAbsolutePath();
                    }
                }
            }
        } else {
            tty = "tty";
            stty = "stty";
            sttyfopt = "-F";
            infocmp = "infocmp";
            if (IS_OSX) {
                stty = "/bin/stty";
                sttyfopt = "-f";
            }
        }
        TTY_COMMAND = tty;
        STTY_COMMAND = stty;
        STTY_F_OPTION = sttyfopt;
        INFOCMP_COMMAND = infocmp;
    }
}
