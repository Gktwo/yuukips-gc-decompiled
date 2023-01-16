package org.eclipse.jetty.client.api;

import java.net.URI;
import org.eclipse.jetty.client.api.Authentication;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/AuthenticationStore.class */
public interface AuthenticationStore {
    void addAuthentication(Authentication authentication);

    void removeAuthentication(Authentication authentication);

    void clearAuthentications();

    Authentication findAuthentication(String str, URI uri, String str2);

    void addAuthenticationResult(Authentication.Result result);

    void removeAuthenticationResult(Authentication.Result result);

    void clearAuthenticationResults();

    Authentication.Result findAuthenticationResult(URI uri);

    default boolean hasAuthenticationResults() {
        return true;
    }
}
