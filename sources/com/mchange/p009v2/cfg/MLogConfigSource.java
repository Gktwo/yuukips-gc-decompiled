package com.mchange.p009v2.cfg;

import java.util.List;

/* renamed from: com.mchange.v2.cfg.MLogConfigSource */
/* loaded from: grasscutter.jar:com/mchange/v2/cfg/MLogConfigSource.class */
public final class MLogConfigSource {
    public static MultiPropertiesConfig readVmConfig(String[] strArr, String[] strArr2, List list) {
        return ConfigUtils.readVmConfig(strArr, strArr2, list);
    }

    private MLogConfigSource() {
    }
}
