package com.mchange.p009v2.ser;

import java.io.IOException;
import java.io.Serializable;

/* renamed from: com.mchange.v2.ser.IndirectlySerialized */
/* loaded from: grasscutter.jar:com/mchange/v2/ser/IndirectlySerialized.class */
public interface IndirectlySerialized extends Serializable {
    Object getObject() throws ClassNotFoundException, IOException;
}
