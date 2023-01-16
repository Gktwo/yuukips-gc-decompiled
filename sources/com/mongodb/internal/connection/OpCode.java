package com.mongodb.internal.connection;

import emu.grasscutter.net.proto.RetcodeOuterClass;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/OpCode.class */
public enum OpCode {
    OP_REPLY(1),
    OP_UPDATE(RetcodeOuterClass.Retcode.RET_UID_NOT_EXIST_VALUE),
    OP_INSERT(2002),
    OP_QUERY(RetcodeOuterClass.Retcode.RET_ORDER_INFO_NOT_EXIST_VALUE),
    OP_GETMORE(2005),
    OP_DELETE(2006),
    OP_KILL_CURSORS(RetcodeOuterClass.Retcode.RET_PRODUCT_NOT_EXIST_VALUE),
    OP_COMPRESSED(2012),
    OP_MSG(2013);
    
    private final int value;

    OpCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
