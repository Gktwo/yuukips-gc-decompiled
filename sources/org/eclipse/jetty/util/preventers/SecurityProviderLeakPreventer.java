package org.eclipse.jetty.util.preventers;

import java.security.Security;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/preventers/SecurityProviderLeakPreventer.class */
public class SecurityProviderLeakPreventer extends AbstractLeakPreventer {
    @Override // org.eclipse.jetty.util.preventers.AbstractLeakPreventer
    public void prevent(ClassLoader loader) {
        Security.getProviders();
    }
}
