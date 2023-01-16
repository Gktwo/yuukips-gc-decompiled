package com.mchange.p009v2.c3p0.impl;

import com.mchange.p009v2.c3p0.C3P0Registry;
import com.mchange.p009v2.naming.JavaBeanObjectFactory;
import java.util.Map;
import java.util.Set;

/* renamed from: com.mchange.v2.c3p0.impl.C3P0JavaBeanObjectFactory */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/C3P0JavaBeanObjectFactory.class */
public class C3P0JavaBeanObjectFactory extends JavaBeanObjectFactory {
    private static final Class[] CTOR_ARG_TYPES = {Boolean.TYPE};
    private static final Object[] CTOR_ARGS = {Boolean.FALSE};

    /* access modifiers changed from: protected */
    @Override // com.mchange.p009v2.naming.JavaBeanObjectFactory
    public Object createBlankInstance(Class beanClass) throws Exception {
        if (IdentityTokenized.class.isAssignableFrom(beanClass)) {
            return beanClass.getConstructor(CTOR_ARG_TYPES).newInstance(CTOR_ARGS);
        }
        return createBlankInstance(beanClass);
    }

    /* access modifiers changed from: protected */
    @Override // com.mchange.p009v2.naming.JavaBeanObjectFactory
    public Object findBean(Class beanClass, Map propertyMap, Set refProps) throws Exception {
        Object out = findBean(beanClass, propertyMap, refProps);
        if (out instanceof IdentityTokenized) {
            out = C3P0Registry.reregister((IdentityTokenized) out);
        }
        return out;
    }
}
