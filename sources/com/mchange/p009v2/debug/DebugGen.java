package com.mchange.p009v2.debug;

import com.mchange.p006v1.lang.BooleanUtils;
import com.mchange.p006v1.p008io.WriterUtils;
import com.mchange.p006v1.util.SetUtils;
import com.mchange.p006v1.util.StringTokenizerUtils;
import com.mchange.p009v2.cmdline.CommandLineUtils;
import com.mchange.p009v2.cmdline.ParsedCommandLine;
import com.mchange.p009v2.p010io.DirectoryDescentUtils;
import com.mchange.p009v2.p010io.FileIterator;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.jetty.http.HttpFields;

/* renamed from: com.mchange.v2.debug.DebugGen */
/* loaded from: grasscutter.jar:com/mchange/v2/debug/DebugGen.class */
public final class DebugGen implements DebugConstants {
    static final String[] VALID = {"codebase", "packages", "trace", "debug", "recursive", "javac", "noclobber", "classname", "skipdirs", "outputbase"};
    static final String[] REQUIRED = {"codebase", "packages", "trace", "debug"};
    static final String[] ARGS = {"codebase", "packages", "trace", "debug", "classname", "outputbase"};
    static final String EOL = System.getProperty("line.separator");
    static int trace_level;
    static boolean debug;
    static boolean recursive;
    static String classname;
    static boolean clobber;
    static Set skipDirs;

    public static final synchronized void main(String[] strArr) {
        String str;
        try {
            ParsedCommandLine parse = CommandLineUtils.parse(strArr, "--", VALID, REQUIRED, ARGS);
            String platify = platify(parse.getSwitchArg("codebase"));
            if (!platify.endsWith(File.separator)) {
                platify = platify + File.separator;
            }
            String switchArg = parse.getSwitchArg("outputbase");
            if (switchArg != null) {
                str = platify(switchArg);
                if (!str.endsWith(File.separator)) {
                    str = str + File.separator;
                }
            } else {
                str = platify;
            }
            File file = new File(str);
            if (file.exists()) {
                if (!file.isDirectory()) {
                    System.exit(-1);
                } else if (!file.canWrite()) {
                    System.err.println("Output Base '" + file.getPath() + "' is not writable!");
                    System.exit(-1);
                }
            } else if (!file.mkdirs()) {
                System.err.println("Output Base directory '" + file.getPath() + "' does not exist, and could not be created!");
                System.exit(-1);
            }
            String[] strArr2 = StringTokenizerUtils.tokenizeToArray(parse.getSwitchArg("packages"), HttpFields.__separators);
            File[] fileArr = new File[strArr2.length];
            int length = strArr2.length;
            for (int i = 0; i < length; i++) {
                fileArr[i] = new File(platify + sepify(strArr2[i]));
            }
            trace_level = Integer.parseInt(parse.getSwitchArg("trace"));
            debug = BooleanUtils.parseBoolean(parse.getSwitchArg("debug"));
            classname = parse.getSwitchArg("classname");
            if (classname == null) {
                classname = "Debug";
            }
            recursive = parse.includesSwitch("recursive");
            clobber = !parse.includesSwitch("noclobber");
            String switchArg2 = parse.getSwitchArg("skipdirs");
            if (switchArg2 != null) {
                skipDirs = SetUtils.setFromArray(StringTokenizerUtils.tokenizeToArray(switchArg2, HttpFields.__separators));
            } else {
                skipDirs = new HashSet();
                skipDirs.add("CVS");
            }
            if (parse.includesSwitch("javac")) {
                System.err.println("autorecompilation of packages not yet implemented.");
            }
            int length2 = fileArr.length;
            for (int i2 = 0; i2 < length2; i2++) {
                if (recursive) {
                    if (!recursivePrecheckPackages(platify, fileArr[i2], str, file)) {
                        System.err.println("One or more of the specifies packages could not be processed. Aborting. No files have been modified.");
                        System.exit(-1);
                    }
                } else if (!precheckPackage(platify, fileArr[i2], str, file)) {
                    System.err.println("One or more of the specifies packages could not be processed. Aborting. No files have been modified.");
                    System.exit(-1);
                }
            }
            int length3 = fileArr.length;
            for (int i3 = 0; i3 < length3; i3++) {
                if (recursive) {
                    recursiveWriteDebugFiles(platify, fileArr[i3], str, file);
                } else {
                    writeDebugFile(str, fileArr[i3]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println();
            usage();
        }
    }

    private static void usage() {
        System.err.println("java " + DebugGen.class.getName() + " \\");
        System.err.println("\t--codebase=<directory under which packages live> \\  (no default)");
        System.err.println("\t--packages=<comma separated list of packages>    \\  (no default)");
        System.err.println("\t--debug=<true|false>                             \\  (no default)");
        System.err.println("\t--trace=<an int between 0 and 10>                \\  (no default)");
        System.err.println("\t--outputdir=<directory under which to generate>  \\  (defaults to same dir as codebase)");
        System.err.println("\t--recursive                                      \\  (no args)");
        System.err.println("\t--noclobber                                      \\  (no args)");
        System.err.println("\t--classname=<class to generate>                  \\  (defaults to Debug)");
        System.err.println("\t--skipdirs=<directories that should be skipped>  \\  (defaults to CVS)");
    }

    private static String ify(String str, char c, char c2) {
        if (c == c2) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        int length = stringBuffer.length();
        for (int i = 0; i < length; i++) {
            if (stringBuffer.charAt(i) == c) {
                stringBuffer.setCharAt(i, c2);
            }
        }
        return stringBuffer.toString();
    }

    private static String platify(String str) {
        return ify(ify(ify(str, '/', File.separatorChar), '\\', File.separatorChar), ':', File.separatorChar);
    }

    private static String dottify(String str) {
        return ify(str, File.separatorChar, '.');
    }

    private static String sepify(String str) {
        return ify(str, '.', File.separatorChar);
    }

    private static boolean recursivePrecheckPackages(String str, File file, String str2, File file2) throws IOException {
        FileIterator depthFirstEagerDescent = DirectoryDescentUtils.depthFirstEagerDescent(file);
        while (depthFirstEagerDescent.hasNext()) {
            File nextFile = depthFirstEagerDescent.nextFile();
            if (nextFile.isDirectory() && !skipDirs.contains(nextFile.getName())) {
                File outputDir = outputDir(str, nextFile, str2, file2);
                if (!outputDir.exists() && !outputDir.mkdirs()) {
                    System.err.println("Required output dir: '" + outputDir + "' does not exist, and could not be created.");
                    return false;
                } else if (!precheckOutputPackageDir(outputDir)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static File outputDir(String str, File file, String str2, File file2) {
        if (str.equals(str2)) {
            return file;
        }
        String path = file.getPath();
        if (!path.startsWith(str)) {
            System.err.println(DebugGen.class.getName() + ": program bug. Source package path '" + path + "' does not begin with codebase '" + str + "'.");
            System.exit(-1);
        }
        return new File(file2, path.substring(str.length()));
    }

    private static boolean precheckPackage(String str, File file, String str2, File file2) throws IOException {
        return precheckOutputPackageDir(outputDir(str, file, str2, file2));
    }

    private static boolean precheckOutputPackageDir(File file) throws IOException {
        File file2 = new File(file, classname + ".java");
        if (!file.canWrite()) {
            System.err.println("File '" + file2.getPath() + "' is not writable.");
            return false;
        } else if (clobber || !file2.exists()) {
            return true;
        } else {
            System.err.println("File '" + file2.getPath() + "' exists, and we are in noclobber mode.");
            return false;
        }
    }

    private static void recursiveWriteDebugFiles(String str, File file, String str2, File file2) throws IOException {
        FileIterator depthFirstEagerDescent = DirectoryDescentUtils.depthFirstEagerDescent(outputDir(str, file, str2, file2));
        while (depthFirstEagerDescent.hasNext()) {
            File nextFile = depthFirstEagerDescent.nextFile();
            if (nextFile.isDirectory() && !skipDirs.contains(nextFile.getName())) {
                writeDebugFile(str2, nextFile);
            }
        }
    }

    private static void writeDebugFile(String str, File file) throws IOException {
        File file2 = new File(file, classname + ".java");
        String dottify = dottify(file.getPath().substring(str.length()));
        System.err.println("Writing file: " + file2.getPath());
        OutputStreamWriter outputStreamWriter = null;
        try {
            outputStreamWriter = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file2)), "UTF8");
            outputStreamWriter.write("/********************************************************************" + EOL);
            outputStreamWriter.write(" * This class generated by " + DebugGen.class.getName() + EOL);
            outputStreamWriter.write(" * and will probably be overwritten by the same! Edit at" + EOL);
            outputStreamWriter.write(" * YOUR PERIL!!! Hahahahaha." + EOL);
            outputStreamWriter.write(" ********************************************************************/" + EOL);
            outputStreamWriter.write(EOL);
            outputStreamWriter.write("package " + dottify + ';' + EOL);
            outputStreamWriter.write(EOL);
            outputStreamWriter.write("import com.mchange.v2.debug.DebugConstants;" + EOL);
            outputStreamWriter.write(EOL);
            outputStreamWriter.write("final class " + classname + " implements DebugConstants" + EOL);
            outputStreamWriter.write("{" + EOL);
            outputStreamWriter.write("\tfinal static boolean DEBUG = " + debug + ';' + EOL);
            outputStreamWriter.write("\tfinal static int     TRACE = " + traceStr(trace_level) + ';' + EOL);
            outputStreamWriter.write(EOL);
            outputStreamWriter.write("\tprivate " + classname + "()" + EOL);
            outputStreamWriter.write("\t{}" + EOL);
            outputStreamWriter.write("}" + EOL);
            outputStreamWriter.write(EOL);
            outputStreamWriter.flush();
            WriterUtils.attemptClose(outputStreamWriter);
        } catch (Throwable th) {
            WriterUtils.attemptClose(outputStreamWriter);
            throw th;
        }
    }

    private static String traceStr(int i) {
        if (i == 0) {
            return "TRACE_NONE";
        }
        if (i == 5) {
            return "TRACE_MED";
        }
        if (i == 10) {
            return "TRACE_MAX";
        }
        return String.valueOf(i);
    }
}
