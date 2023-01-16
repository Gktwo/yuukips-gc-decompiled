package org.eclipse.jetty.client;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.eclipse.jetty.client.api.Authentication;
import org.eclipse.jetty.client.api.AuthenticationStore;
import org.eclipse.jetty.client.util.AbstractAuthentication;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpAuthenticationStore.class */
public class HttpAuthenticationStore implements AuthenticationStore {
    private final List<Authentication> authentications = new CopyOnWriteArrayList();
    private final Map<URI, Authentication.Result> results = new ConcurrentHashMap();

    @Override // org.eclipse.jetty.client.api.AuthenticationStore
    public void addAuthentication(Authentication authentication) {
        this.authentications.add(authentication);
    }

    @Override // org.eclipse.jetty.client.api.AuthenticationStore
    public void removeAuthentication(Authentication authentication) {
        this.authentications.remove(authentication);
    }

    @Override // org.eclipse.jetty.client.api.AuthenticationStore
    public void clearAuthentications() {
        this.authentications.clear();
    }

    @Override // org.eclipse.jetty.client.api.AuthenticationStore
    public Authentication findAuthentication(String type, URI uri, String realm) {
        for (Authentication authentication : this.authentications) {
            if (authentication.matches(type, uri, realm)) {
                return authentication;
            }
        }
        return null;
    }

    @Override // org.eclipse.jetty.client.api.AuthenticationStore
    public void addAuthenticationResult(Authentication.Result result) {
        URI uri = result.getURI();
        if (uri != null) {
            this.results.put(uri, result);
        }
    }

    @Override // org.eclipse.jetty.client.api.AuthenticationStore
    public void removeAuthenticationResult(Authentication.Result result) {
        this.results.remove(result.getURI());
    }

    @Override // org.eclipse.jetty.client.api.AuthenticationStore
    public void clearAuthenticationResults() {
        this.results.clear();
    }

    @Override // org.eclipse.jetty.client.api.AuthenticationStore
    public Authentication.Result findAuthenticationResult(URI uri) {
        for (Map.Entry<URI, Authentication.Result> entry : this.results.entrySet()) {
            if (AbstractAuthentication.matchesURI(entry.getKey(), uri)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override // org.eclipse.jetty.client.api.AuthenticationStore
    public boolean hasAuthenticationResults() {
        return !this.results.isEmpty();
    }
}
