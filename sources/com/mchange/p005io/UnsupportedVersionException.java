package com.mchange.p005io;

import java.io.InvalidClassException;

/* renamed from: com.mchange.io.UnsupportedVersionException */
/* loaded from: grasscutter.jar:com/mchange/io/UnsupportedVersionException.class */
public class UnsupportedVersionException extends InvalidClassException {
    public UnsupportedVersionException(String str) {
        super(str);
    }

    public UnsupportedVersionException(Object obj, int i) {
        this(obj.getClass().getName() + " -- unsupported version: " + i);
    }
}
