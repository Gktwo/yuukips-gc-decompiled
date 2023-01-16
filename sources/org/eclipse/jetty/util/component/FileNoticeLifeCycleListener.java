package org.eclipse.jetty.util.component;

import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/component/FileNoticeLifeCycleListener.class */
public class FileNoticeLifeCycleListener implements LifeCycle.Listener {
    private static final Logger LOG = Log.getLogger(FileNoticeLifeCycleListener.class);
    private final String _filename;

    public FileNoticeLifeCycleListener(String filename) {
        this._filename = filename;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:5:0x002b
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private void writeState(java.lang.String r6, org.eclipse.jetty.util.component.LifeCycle r7) {
        /*
            r5 = this;
            java.io.FileWriter r0 = new java.io.FileWriter     // Catch: Exception -> 0x0043
            r1 = r0
            r2 = r5
            java.lang.String r2 = r2._filename     // Catch: Exception -> 0x0043
            r3 = 1
            r1.<init>(r2, r3)     // Catch: Exception -> 0x0043
            r8 = r0
            r0 = r8
            r1 = r6
            java.io.Writer r0 = r0.append(r1)     // Catch: Exception -> 0x0043, Throwable -> 0x002b
            java.lang.String r1 = " "
            java.io.Writer r0 = r0.append(r1)     // Catch: Exception -> 0x0043, Throwable -> 0x002b
            r1 = r7
            java.lang.String r1 = r1.toString()     // Catch: Exception -> 0x0043, Throwable -> 0x002b
            java.io.Writer r0 = r0.append(r1)     // Catch: Exception -> 0x0043, Throwable -> 0x002b
            java.lang.String r1 = "\n"
            java.io.Writer r0 = r0.append(r1)     // Catch: Exception -> 0x0043, Throwable -> 0x002b
            r0 = r8
            r0.close()     // Catch: Exception -> 0x0043
            goto L_0x0040
        L_0x002b:
            r9 = move-exception
            r0 = r8
            r0.close()     // Catch: Exception -> 0x0043, Throwable -> 0x0034
            goto L_0x003d
        L_0x0034:
            r10 = move-exception
            r0 = r9
            r1 = r10
            r0.addSuppressed(r1)     // Catch: Exception -> 0x0043
        L_0x003d:
            r0 = r9
            throw r0     // Catch: Exception -> 0x0043
        L_0x0040:
            goto L_0x004d
        L_0x0043:
            r8 = move-exception
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.util.component.FileNoticeLifeCycleListener.LOG
            r1 = r8
            r0.warn(r1)
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.component.FileNoticeLifeCycleListener.writeState(java.lang.String, org.eclipse.jetty.util.component.LifeCycle):void");
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle.Listener
    public void lifeCycleStarting(LifeCycle event) {
        writeState(AbstractLifeCycle.STARTING, event);
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle.Listener
    public void lifeCycleStarted(LifeCycle event) {
        writeState(AbstractLifeCycle.STARTED, event);
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle.Listener
    public void lifeCycleFailure(LifeCycle event, Throwable cause) {
        writeState(AbstractLifeCycle.FAILED, event);
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle.Listener
    public void lifeCycleStopping(LifeCycle event) {
        writeState(AbstractLifeCycle.STOPPING, event);
    }

    @Override // org.eclipse.jetty.util.component.LifeCycle.Listener
    public void lifeCycleStopped(LifeCycle event) {
        writeState(AbstractLifeCycle.STOPPED, event);
    }
}
