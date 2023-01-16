package com.mchange.p006v1.lang;

/* renamed from: com.mchange.v1.lang.AmbiguousClassNameException */
/* loaded from: grasscutter.jar:com/mchange/v1/lang/AmbiguousClassNameException.class */
public class AmbiguousClassNameException extends Exception {
    /* access modifiers changed from: package-private */
    public AmbiguousClassNameException(String str, Class cls, Class cls2) {
        super(str + " could refer either to " + cls.getName() + " or " + cls2.getName());
    }
}
