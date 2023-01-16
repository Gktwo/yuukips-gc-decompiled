package com.mchange.p009v2.log;

/* renamed from: com.mchange.v2.log.NameTransformer */
/* loaded from: grasscutter.jar:com/mchange/v2/log/NameTransformer.class */
public interface NameTransformer {
    String transformName(String str);

    String transformName(Class cls);

    String transformName();
}
