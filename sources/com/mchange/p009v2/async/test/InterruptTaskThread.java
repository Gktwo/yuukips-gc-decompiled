package com.mchange.p009v2.async.test;

import com.mchange.p009v2.lang.ThreadUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.mchange.v2.async.test.InterruptTaskThread */
/* loaded from: grasscutter.jar:com/mchange/v2/async/test/InterruptTaskThread.class */
public class InterruptTaskThread {
    static Set interruptedThreads = Collections.synchronizedSet(new HashSet());

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x002d
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static void main(java.lang.String[] r5) {
        /*
            com.mchange.v2.async.RoundRobinAsynchronousRunner r0 = new com.mchange.v2.async.RoundRobinAsynchronousRunner     // Catch: Exception -> 0x0061
            r1 = r0
            r2 = 5
            r3 = 0
            r1.<init>(r2, r3)     // Catch: Exception -> 0x0061
            r6 = r0
            com.mchange.v2.async.test.InterruptTaskThread$Interrupter r0 = new com.mchange.v2.async.test.InterruptTaskThread$Interrupter     // Catch: Exception -> 0x0061
            r1 = r0
            r1.<init>()     // Catch: Exception -> 0x0061
            r0.start()     // Catch: Exception -> 0x0061
            r0 = 0
            r7 = r0
        L_0x0016:
            r0 = r7
            r1 = 1000(0x3e8, float:1.401E-42)
            if (r0 >= r1) goto L_0x003e
            r0 = r6
            com.mchange.v2.async.test.InterruptTaskThread$DumbTask r1 = new com.mchange.v2.async.test.InterruptTaskThread$DumbTask     // Catch: Exception -> 0x0061, Exception -> 0x002d
            r2 = r1
            r2.<init>()     // Catch: Exception -> 0x0061, Exception -> 0x002d
            r0.postRunnable(r1)     // Catch: Exception -> 0x0061, Exception -> 0x002d
            goto L_0x0032
        L_0x002d:
            r8 = move-exception
            r0 = r8
            r0.printStackTrace()     // Catch: Exception -> 0x0061
        L_0x0032:
            r0 = 50
            java.lang.Thread.sleep(r0)     // Catch: Exception -> 0x0061
            int r7 = r7 + 1
            goto L_0x0016
        L_0x003e:
            java.io.PrintStream r0 = java.lang.System.out     // Catch: Exception -> 0x0061
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: Exception -> 0x0061
            r2 = r1
            r2.<init>()     // Catch: Exception -> 0x0061
            java.lang.String r2 = "Interrupted Threads: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: Exception -> 0x0061
            java.util.Set r2 = com.mchange.p009v2.async.test.InterruptTaskThread.interruptedThreads     // Catch: Exception -> 0x0061
            int r2 = r2.size()     // Catch: Exception -> 0x0061
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: Exception -> 0x0061
            java.lang.String r1 = r1.toString()     // Catch: Exception -> 0x0061
            r0.println(r1)     // Catch: Exception -> 0x0061
            goto L_0x0066
        L_0x0061:
            r6 = move-exception
            r0 = r6
            r0.printStackTrace()
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.async.test.InterruptTaskThread.main(java.lang.String[]):void");
    }

    /* renamed from: com.mchange.v2.async.test.InterruptTaskThread$Interrupter */
    /* loaded from: grasscutter.jar:com/mchange/v2/async/test/InterruptTaskThread$Interrupter.class */
    static class Interrupter extends Thread {
        Interrupter() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    Thread[] threadArr = new Thread[1000];
                    ThreadUtils.enumerateAll(threadArr);
                    int i = 0;
                    while (true) {
                        if (threadArr[i] == null) {
                            break;
                        } else if (threadArr[i].getName().indexOf("RunnableQueue.TaskThread") >= 0) {
                            threadArr[i].interrupt();
                            System.out.println("INTERRUPTED!");
                            InterruptTaskThread.interruptedThreads.add(threadArr[i]);
                            break;
                        } else {
                            i++;
                        }
                    }
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    /* renamed from: com.mchange.v2.async.test.InterruptTaskThread$DumbTask */
    /* loaded from: grasscutter.jar:com/mchange/v2/async/test/InterruptTaskThread$DumbTask.class */
    static class DumbTask implements Runnable {
        static int count = 0;

        DumbTask() {
        }

        static synchronized int number() {
            int i = count;
            count = i + 1;
            return i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(200);
                System.out.println("DumbTask complete! " + number());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
