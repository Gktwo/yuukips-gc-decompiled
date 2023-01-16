package org.eclipse.jetty.util.preventers;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/preventers/LoginConfigurationLeakPreventer.class */
public class LoginConfigurationLeakPreventer extends AbstractLeakPreventer {
    @Override // org.eclipse.jetty.util.preventers.AbstractLeakPreventer
    public void prevent(ClassLoader loader) {
        try {
            Class.forName("javax.security.auth.login.Configuration", true, loader);
        } catch (ClassNotFoundException e) {
            LOG.warn(e);
        }
    }
}
