package com.mchange.p005io;

import java.io.InvalidClassException;

/* renamed from: com.mchange.io.UnknownStreamClassException */
/* loaded from: grasscutter.jar:com/mchange/io/UnknownStreamClassException.class */
public class UnknownStreamClassException extends InvalidClassException {
    public UnknownStreamClassException(ClassNotFoundException classNotFoundException) {
        super(classNotFoundException.getMessage());
    }
}
