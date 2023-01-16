package com.mchange.p009v2.uid;

import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import org.jline.reader.impl.LineReaderImpl;

/* renamed from: com.mchange.v2.uid.UidUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/uid/UidUtils.class */
public final class UidUtils {
    static final MLogger logger = MLog.getLogger(UidUtils.class);
    public static final String VM_ID = generateVmId();
    private static long within_vm_seq_counter = 0;

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:5:0x002a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private static java.lang.String generateVmId() {
        /*
        // Method dump skipped, instructions count: 435
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.p009v2.uid.UidUtils.generateVmId():java.lang.String");
    }

    private static synchronized long nextWithinVmSeq() {
        long j = within_vm_seq_counter + 1;
        within_vm_seq_counter = j;
        return j;
    }

    public static String allocateWithinVmSequential() {
        return VM_ID + LineReaderImpl.DEFAULT_COMMENT_BEGIN + nextWithinVmSeq();
    }

    private UidUtils() {
    }
}
