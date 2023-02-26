package org.eclipse.jetty.util;

import java.time.Instant;
import java.util.Properties;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/Jetty.class */
public class Jetty {
    private static final Logger LOG;
    public static final String VERSION;
    public static final String POWERED_BY;
    public static final boolean STABLE;
    public static final String GIT_HASH;
    public static final String BUILD_TIMESTAMP;
    private static final Properties __buildProperties;

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:7:0x002c
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    static {
        /*
        // Method dump skipped, instructions count: 235
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.Jetty.m9788clinit():void");
    }

    private Jetty() {
    }

    private static String formatTimestamp(String timestamp) {
        try {
            return Instant.ofEpochMilli(Long.parseLong(timestamp)).toString();
        } catch (NumberFormatException e) {
            LOG.ignore(e);
            return "unknown";
        }
    }
}
