package com.mongodb.internal.operation;

import com.mongodb.MongoChangeStreamException;
import com.mongodb.MongoCursorNotFoundException;
import com.mongodb.MongoException;
import com.mongodb.MongoInterruptedException;
import com.mongodb.MongoNotPrimaryException;
import com.mongodb.MongoSocketException;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.util.Arrays;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/ChangeStreamBatchCursorHelper.class */
final class ChangeStreamBatchCursorHelper {
    private static final List<Integer> RETRYABLE_SERVER_ERROR_CODES = Arrays.asList(6, 7, 63, 89, 91, 133, 150, 189, Integer.valueOf((int) PacketOpcodes.JoinPlayerSceneReq), Integer.valueOf((int) PacketOpcodes.SceneEntityMoveRsp), Integer.valueOf((int) RetcodeOuterClass.Retcode.RET_REUNION_FINISHED_VALUE), 10107, 11600, 11602, 13388, 13435, 13436);
    private static final String RESUMABLE_CHANGE_STREAM_ERROR_LABEL = "ResumableChangeStreamError";

    /* access modifiers changed from: package-private */
    public static boolean isRetryableError(Throwable t, int maxWireVersion) {
        if (!(t instanceof MongoException) || (t instanceof MongoChangeStreamException) || (t instanceof MongoInterruptedException)) {
            return false;
        }
        if ((t instanceof MongoNotPrimaryException) || (t instanceof MongoCursorNotFoundException) || (t instanceof MongoSocketException)) {
            return true;
        }
        if (maxWireVersion >= 9) {
            return ((MongoException) t).getErrorLabels().contains(RESUMABLE_CHANGE_STREAM_ERROR_LABEL);
        }
        return RETRYABLE_SERVER_ERROR_CODES.contains(Integer.valueOf(((MongoException) t).getCode()));
    }

    private ChangeStreamBatchCursorHelper() {
    }
}
