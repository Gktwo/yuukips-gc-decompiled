package com.mchange.p009v2.naming;

import javax.naming.NamingException;
import javax.naming.Reference;

/* renamed from: com.mchange.v2.naming.ReferenceMaker */
/* loaded from: grasscutter.jar:com/mchange/v2/naming/ReferenceMaker.class */
public interface ReferenceMaker {
    Reference createReference(Object obj) throws NamingException;
}
