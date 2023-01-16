package p018;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import org.luaj.vm2.Globals;
import org.luaj.vm2.Print;
import org.luaj.vm2.Prototype;
import org.luaj.vm2.compiler.DumpState;
import org.luaj.vm2.lib.jse.JsePlatform;

/* renamed from: luac */
/* loaded from: grasscutter.jar:luac.class */
public class luac {
    private static final String version = "Luaj-jse 3.0.1Copyright (C) 2009 luaj.org";
    private static final String usage = "usage: java -cp luaj-jse.jar luac [options] [filenames].\nAvailable options are:\n  -        process stdin\n  -l       list\n  -o name  output to file 'name' (default is \"luac.out\")\n  -p       parse only\n  -s       strip debug information\n  -e       little endian format for numbers\n  -i<n>    number format 'n', (n=0,1 or 4, default=0)\n  -v       show version information\n  -c enc  \tuse the supplied encoding 'enc' for input files\n  --       stop handling options\n";
    private boolean list;
    private String output;
    private boolean parseonly;
    private boolean stripdebug;
    private boolean littleendian;
    private int numberformat;
    private boolean versioninfo;
    private boolean processing;
    private String encoding;

    private static void usageExit() {
        System.out.println(usage);
        System.exit(-1);
    }

    public static void main(String[] strArr) throws IOException {
        new luac(strArr);
    }

    private luac(String[] strArr) throws IOException {
        this.list = false;
        this.output = "luac.out";
        this.parseonly = false;
        this.stripdebug = false;
        this.littleendian = false;
        this.numberformat = 0;
        this.versioninfo = false;
        this.processing = true;
        this.encoding = null;
        int i = 0;
        while (i < strArr.length) {
            try {
                if (this.processing && strArr[i].startsWith("-") && strArr[i].length() > 1) {
                    switch (strArr[i].charAt(1)) {
                        case '-':
                            if (strArr[i].length() > 2) {
                                usageExit();
                            }
                            this.processing = false;
                            continue;
                        case 'c':
                            i++;
                            if (i >= strArr.length) {
                                usageExit();
                            }
                            this.encoding = strArr[i];
                            continue;
                        case 'e':
                            this.littleendian = true;
                            continue;
                        case 'i':
                            if (strArr[i].length() <= 2) {
                                usageExit();
                            }
                            this.numberformat = Integer.parseInt(strArr[i].substring(2));
                            continue;
                        case 'l':
                            this.list = true;
                            continue;
                        case 'o':
                            i++;
                            if (i >= strArr.length) {
                                usageExit();
                            }
                            this.output = strArr[i];
                            continue;
                        case 'p':
                            this.parseonly = true;
                            continue;
                        case 's':
                            this.stripdebug = true;
                            continue;
                        case 'v':
                            this.versioninfo = true;
                            continue;
                        default:
                            usageExit();
                            continue;
                    }
                }
                i++;
            } catch (IOException e) {
                System.err.println(e.toString());
                System.exit(-2);
                return;
            }
        }
        if (this.versioninfo) {
            System.out.println(version);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(this.output);
        Globals standardGlobals = JsePlatform.standardGlobals();
        this.processing = true;
        int i2 = 0;
        while (i2 < strArr.length) {
            if (!this.processing || !strArr[i2].startsWith("-")) {
                processScript(standardGlobals, new FileInputStream(strArr[i2]), strArr[i2].substring(0, strArr[i2].length() - 4), fileOutputStream);
            } else if (strArr[i2].length() <= 1) {
                processScript(standardGlobals, System.in, "=stdin", fileOutputStream);
            } else {
                switch (strArr[i2].charAt(1)) {
                    case '-':
                        this.processing = false;
                        continue;
                    case 'c':
                    case 'o':
                        i2++;
                        continue;
                }
            }
            i2++;
        }
        fileOutputStream.close();
    }

    private void processScript(Globals globals, InputStream inputStream, String str, OutputStream outputStream) throws IOException {
        try {
            try {
                inputStream = new BufferedInputStream(inputStream);
                Prototype compilePrototype = this.encoding != null ? globals.compilePrototype(new InputStreamReader(inputStream, this.encoding), str) : globals.compilePrototype(inputStream, str);
                if (this.list) {
                    Print.printCode(compilePrototype);
                }
                if (!this.parseonly) {
                    DumpState.dump(compilePrototype, outputStream, this.stripdebug, this.numberformat, this.littleendian);
                }
            } catch (Exception e) {
                e.printStackTrace(System.err);
                inputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }
}
