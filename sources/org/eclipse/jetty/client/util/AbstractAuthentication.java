package org.eclipse.jetty.client.util;

import java.net.URI;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.Authentication;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/AbstractAuthentication.class */
public abstract class AbstractAuthentication implements Authentication {
    private final URI uri;
    private final String realm;

    public abstract String getType();

    public AbstractAuthentication(URI uri, String realm) {
        this.uri = uri;
        this.realm = realm;
    }

    public URI getURI() {
        return this.uri;
    }

    public String getRealm() {
        return this.realm;
    }

    @Override // org.eclipse.jetty.client.api.Authentication
    public boolean matches(String type, URI uri, String realm) {
        if (!getType().equalsIgnoreCase(type)) {
            return false;
        }
        if (this.realm.equals(Authentication.ANY_REALM) || this.realm.equals(realm)) {
            return matchesURI(this.uri, uri);
        }
        return false;
    }

    public static boolean matchesURI(URI uri1, URI uri2) {
        String scheme = uri1.getScheme();
        if (!scheme.equalsIgnoreCase(uri2.getScheme()) || !uri1.getHost().equalsIgnoreCase(uri2.getHost()) || HttpClient.normalizePort(scheme, uri1.getPort()) != HttpClient.normalizePort(scheme, uri2.getPort())) {
            return false;
        }
        return uri2.getPath().startsWith(uri1.getPath());
    }
}
