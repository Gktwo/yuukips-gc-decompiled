package com.mchange.p009v2.ser;

import java.io.InvalidClassException;

/* renamed from: com.mchange.v2.ser.UnsupportedVersionException */
/* loaded from: grasscutter.jar:com/mchange/v2/ser/UnsupportedVersionException.class */
public class UnsupportedVersionException extends InvalidClassException {
    public UnsupportedVersionException(String str) {
        super(str);
    }

    public UnsupportedVersionException(Object obj, int i) {
        this(obj.getClass().getName() + " -- unsupported version: " + i);
    }
}
