package org.eclipse.jetty.util.security;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/security/CredentialProvider.class */
public interface CredentialProvider {
    Credential getCredential(String str);

    String getPrefix();
}
