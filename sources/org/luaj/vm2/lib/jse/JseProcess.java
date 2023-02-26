package org.luaj.vm2.lib.jse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JseProcess.class */
public class JseProcess {
    final Process process;
    final Thread input;
    final Thread output;
    final Thread error;

    /* access modifiers changed from: package-private */
    /* renamed from: org.luaj.vm2.lib.jse.JseProcess$1 */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JseProcess$1.class */
    public static class C58701 {
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JseProcess$CopyThread.class */
    public static final class CopyThread extends Thread {
        private final OutputStream output;
        private final OutputStream ownedOutput;
        private final InputStream ownedInput;
        private final InputStream input;

        private CopyThread(OutputStream outputStream, OutputStream outputStream2, InputStream inputStream, InputStream inputStream2) {
            this.output = outputStream;
            this.ownedOutput = outputStream2;
            this.ownedInput = inputStream;
            this.input = inputStream2;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:13:0x003f
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            /*
                r5 = this;
                r0 = 1024(0x400, float:1.435E-42)
                byte[] r0 = new byte[r0]     // Catch: IOException -> 0x0061
                r6 = r0
            L_0x0006:
                r0 = r5
                java.io.InputStream r0 = r0.input     // Catch: IOException -> 0x0061, all -> 0x003f
                r1 = r6
                int r0 = r0.read(r1)     // Catch: IOException -> 0x0061, all -> 0x003f
                r1 = r0
                r7 = r1
                if (r0 < 0) goto L_0x0020
                r0 = r5
                java.io.OutputStream r0 = r0.output     // Catch: IOException -> 0x0061, all -> 0x003f
                r1 = r6
                r2 = 0
                r3 = r7
                r0.write(r1, r2, r3)     // Catch: IOException -> 0x0061, all -> 0x003f
                goto L_0x0006
            L_0x0020:
                r0 = r5
                java.io.InputStream r0 = r0.ownedInput     // Catch: IOException -> 0x0061
                if (r0 == 0) goto L_0x002e
                r0 = r5
                java.io.InputStream r0 = r0.ownedInput     // Catch: IOException -> 0x0061
                r0.close()     // Catch: IOException -> 0x0061
            L_0x002e:
                r0 = r5
                java.io.OutputStream r0 = r0.ownedOutput     // Catch: IOException -> 0x0061
                if (r0 == 0) goto L_0x005e
                r0 = r5
                java.io.OutputStream r0 = r0.ownedOutput     // Catch: IOException -> 0x0061
                r0.close()     // Catch: IOException -> 0x0061
                goto L_0x005e
            L_0x003f:
                r8 = move-exception
                r0 = r5
                java.io.InputStream r0 = r0.ownedInput     // Catch: IOException -> 0x0061
                if (r0 == 0) goto L_0x004e
                r0 = r5
                java.io.InputStream r0 = r0.ownedInput     // Catch: IOException -> 0x0061
                r0.close()     // Catch: IOException -> 0x0061
            L_0x004e:
                r0 = r5
                java.io.OutputStream r0 = r0.ownedOutput     // Catch: IOException -> 0x0061
                if (r0 == 0) goto L_0x005c
                r0 = r5
                java.io.OutputStream r0 = r0.ownedOutput     // Catch: IOException -> 0x0061
                r0.close()     // Catch: IOException -> 0x0061
            L_0x005c:
                r0 = r8
                throw r0     // Catch: IOException -> 0x0061
            L_0x005e:
                goto L_0x0066
            L_0x0061:
                r6 = move-exception
                r0 = r6
                r0.printStackTrace()
            L_0x0066:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.lib.jse.JseProcess.CopyThread.run():void");
        }

        CopyThread(OutputStream outputStream, OutputStream outputStream2, InputStream inputStream, InputStream inputStream2, C58701 r11) {
            this(outputStream, outputStream2, inputStream, inputStream2);
        }
    }

    public JseProcess(String[] strArr, InputStream inputStream, OutputStream outputStream, OutputStream outputStream2) throws IOException {
        this(Runtime.getRuntime().exec(strArr), inputStream, outputStream, outputStream2);
    }

    public JseProcess(String str, InputStream inputStream, OutputStream outputStream, OutputStream outputStream2) throws IOException {
        this(Runtime.getRuntime().exec(str), inputStream, outputStream, outputStream2);
    }

    private JseProcess(Process process, InputStream inputStream, OutputStream outputStream, OutputStream outputStream2) {
        this.process = process;
        this.input = inputStream == null ? null : copyBytes(inputStream, process.getOutputStream(), null, process.getOutputStream());
        this.output = outputStream == null ? null : copyBytes(process.getInputStream(), outputStream, process.getInputStream(), null);
        this.error = outputStream2 == null ? null : copyBytes(process.getErrorStream(), outputStream2, process.getErrorStream(), null);
    }

    public int exitValue() {
        return this.process.exitValue();
    }

    public int waitFor() throws InterruptedException {
        int waitFor = this.process.waitFor();
        if (this.input != null) {
            this.input.join();
        }
        if (this.output != null) {
            this.output.join();
        }
        if (this.error != null) {
            this.error.join();
        }
        this.process.destroy();
        return waitFor;
    }

    private Thread copyBytes(InputStream inputStream, OutputStream outputStream, InputStream inputStream2, OutputStream outputStream2) {
        CopyThread copyThread = new CopyThread(outputStream, outputStream2, inputStream2, inputStream, null);
        copyThread.start();
        return copyThread;
    }
}
