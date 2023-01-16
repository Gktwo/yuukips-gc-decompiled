package com.mchange.util.impl;

import com.mchange.util.MEnumeration;
import java.util.NoSuchElementException;

/* loaded from: grasscutter.jar:com/mchange/util/impl/EmptyMEnumeration.class */
public class EmptyMEnumeration implements MEnumeration {
    public static MEnumeration SINGLETON = new EmptyMEnumeration();

    private EmptyMEnumeration() {
    }

    @Override // com.mchange.util.MEnumeration, com.mchange.p005io.IOEnumeration
    public Object nextElement() {
        throw new NoSuchElementException();
    }

    @Override // com.mchange.util.MEnumeration, com.mchange.p005io.IOEnumeration
    public boolean hasMoreElements() {
        return false;
    }
}
