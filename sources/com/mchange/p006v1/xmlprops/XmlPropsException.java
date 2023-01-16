package com.mchange.p006v1.xmlprops;

import com.mchange.lang.PotentiallySecondaryException;

/* renamed from: com.mchange.v1.xmlprops.XmlPropsException */
/* loaded from: grasscutter.jar:com/mchange/v1/xmlprops/XmlPropsException.class */
public class XmlPropsException extends PotentiallySecondaryException {
    public XmlPropsException(String str, Throwable th) {
        super(str, th);
    }

    public XmlPropsException(Throwable th) {
        super(th);
    }

    public XmlPropsException(String str) {
        super(str);
    }

    public XmlPropsException() {
    }
}
