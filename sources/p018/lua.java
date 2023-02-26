package p018;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import net.bytebuddy.description.method.ParameterDescription;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

/* renamed from: lua */
/* loaded from: grasscutter.jar:lua.class */
public class lua {
    private static final String version = "Luaj-jse 3.0.1 Copyright (c) 2012 Luaj.org.org";
    private static final String usage = "usage: java -cp luaj-jse.jar lua [options] [script [args]].\nAvailable options are:\n  -e stat  execute string 'stat'\n  -l name  require library 'name'\n  -i       enter interactive mode after executing 'script'\n  -v       show version information\n  -b      \tuse luajc bytecode-to-bytecode compiler (requires bcel on class path)\n  -n      \tnodebug - do not load debug library by default\n  -p      \tprint the prototype\n  -c enc  \tuse the supplied encoding 'enc' for input files\n  --       stop handling options\n  -        execute stdin and stop handling options";
    private static Globals globals;
    private static boolean print = false;
    private static String encoding = null;

    private static void usageExit() {
        System.out.println(usage);
        System.exit(-1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0199, code lost:
        processScript(new java.io.FileInputStream(r5[r12]), r5[r12], r5, r12);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r5) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 579
        */
        throw new UnsupportedOperationException("Method not decompiled: p018.lua.main(java.lang.String[]):void");
    }

    private static void loadLibrary(String str) throws IOException {
        LuaString valueOf = LuaValue.valueOf(str);
        try {
            globals.get("require").call(valueOf);
        } catch (Exception e) {
            try {
                ((LuaValue) Class.forName(str).newInstance()).call(valueOf, globals);
            } catch (Exception e2) {
                throw new IOException(new StringBuffer().append("loadLibrary(").append(str).append(") failed: ").append(e).append(",").append(e2).toString());
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Try blocks wrapping queue limit reached! Please report as an issue!
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.connectExcHandlers(BlockExceptionHandler.java:88)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.process(BlockExceptionHandler.java:58)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.independentBlockTreeMod(BlockProcessor.java:452)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:51)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private static void processScript(java.io.InputStream r6, java.lang.String r7, java.lang.String[] r8, int r9) throws java.io.IOException {
        /*
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch: Exception -> 0x0072, all -> 0x003a
            r1 = r0
            r2 = r6
            r1.<init>(r2)     // Catch: Exception -> 0x0072, all -> 0x003a
            r6 = r0
            java.lang.String r0 = p018.lua.encoding     // Catch: Exception -> 0x0072, all -> 0x003a
            if (r0 == 0) goto L_0x0024
            org.luaj.vm2.Globals r0 = p018.lua.globals     // Catch: Exception -> 0x0072, all -> 0x003a
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: Exception -> 0x0072, all -> 0x003a
            r2 = r1
            r3 = r6
            java.lang.String r4 = p018.lua.encoding     // Catch: Exception -> 0x0072, all -> 0x003a
            r2.<init>(r3, r4)     // Catch: Exception -> 0x0072, all -> 0x003a
            r2 = r7
            org.luaj.vm2.LuaValue r0 = r0.load(r1, r2)     // Catch: Exception -> 0x0072, all -> 0x003a
            goto L_0x0031
        L_0x0024:
            org.luaj.vm2.Globals r0 = p018.lua.globals     // Catch: Exception -> 0x0072, all -> 0x003a
            r1 = r6
            r2 = r7
            java.lang.String r3 = "bt"
            org.luaj.vm2.Globals r4 = p018.lua.globals     // Catch: Exception -> 0x0072, all -> 0x003a
            org.luaj.vm2.LuaValue r0 = r0.load(r1, r2, r3, r4)     // Catch: Exception -> 0x0072, all -> 0x003a
        L_0x0031:
            r10 = r0
            r0 = r6
            r0.close()     // Catch: Exception -> 0x0072
            goto L_0x0043
        L_0x003a:
            r11 = move-exception
            r0 = r6
            r0.close()     // Catch: Exception -> 0x0072
            r0 = r11
            throw r0     // Catch: Exception -> 0x0072
        L_0x0043:
            boolean r0 = p018.lua.print     // Catch: Exception -> 0x0072
            if (r0 == 0) goto L_0x005c
            r0 = r10
            boolean r0 = r0.isclosure()     // Catch: Exception -> 0x0072
            if (r0 == 0) goto L_0x005c
            r0 = r10
            org.luaj.vm2.LuaClosure r0 = r0.checkclosure()     // Catch: Exception -> 0x0072
            org.luaj.vm2.Prototype r0 = r0.f3251p     // Catch: Exception -> 0x0072
            org.luaj.vm2.Print.print(r0)     // Catch: Exception -> 0x0072
        L_0x005c:
            r0 = r7
            r1 = r8
            r2 = r9
            org.luaj.vm2.Globals r3 = p018.lua.globals     // Catch: Exception -> 0x0072
            org.luaj.vm2.Varargs r0 = setGlobalArg(r0, r1, r2, r3)     // Catch: Exception -> 0x0072
            r11 = r0
            r0 = r10
            r1 = r11
            org.luaj.vm2.Varargs r0 = r0.invoke(r1)     // Catch: Exception -> 0x0072
            goto L_0x007c
        L_0x0072:
            r10 = move-exception
            r0 = r10
            java.io.PrintStream r1 = java.lang.System.err
            r0.printStackTrace(r1)
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p018.lua.processScript(java.io.InputStream, java.lang.String, java.lang.String[], int):void");
    }

    private static Varargs setGlobalArg(String str, String[] strArr, int i, LuaValue luaValue) {
        if (strArr == null) {
            return LuaValue.NONE;
        }
        LuaTable tableOf = LuaValue.tableOf();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            tableOf.set(i2 - i, LuaValue.valueOf(strArr[i2]));
        }
        tableOf.set(0, LuaValue.valueOf(str));
        tableOf.set(-1, LuaValue.valueOf("luaj"));
        luaValue.set(ParameterDescription.NAME_PREFIX, tableOf);
        return tableOf.unpack();
    }

    private static void interactiveMode() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("> ");
            System.out.flush();
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                processScript(new ByteArrayInputStream(readLine.getBytes()), "=stdin", null, 0);
            } else {
                return;
            }
        }
    }
}
