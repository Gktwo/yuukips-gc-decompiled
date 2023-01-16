package com.mchange.p009v2.c3p0.test;

import com.mchange.p009v2.c3p0.ComboPooledDataSource;

/* renamed from: com.mchange.v2.c3p0.test.StatsTest */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/StatsTest.class */
public final class StatsTest {
    static void display(ComboPooledDataSource cpds) throws Exception {
        System.err.println("numConnections: " + cpds.getNumConnections());
        System.err.println("numBusyConnections: " + cpds.getNumBusyConnections());
        System.err.println("numIdleConnections: " + cpds.getNumIdleConnections());
        System.err.println("numUnclosedOrphanedConnections: " + cpds.getNumUnclosedOrphanedConnections());
        System.err.println();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:12:0x00f6
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static void main(java.lang.String[] r9) {
        /*
        // Method dump skipped, instructions count: 343
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.c3p0.test.StatsTest.main(java.lang.String[]):void");
    }
}
