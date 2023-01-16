package org.eclipse.jetty.util;

import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/HttpCookieStore.class */
public class HttpCookieStore implements CookieStore {
    private final CookieStore delegate = new CookieManager().getCookieStore();

    @Override // java.net.CookieStore
    public void add(URI uri, HttpCookie cookie) {
        this.delegate.add(uri, cookie);
    }

    @Override // java.net.CookieStore
    public List<HttpCookie> get(URI uri) {
        return this.delegate.get(uri);
    }

    @Override // java.net.CookieStore
    public List<HttpCookie> getCookies() {
        return this.delegate.getCookies();
    }

    @Override // java.net.CookieStore
    public List<URI> getURIs() {
        return this.delegate.getURIs();
    }

    @Override // java.net.CookieStore
    public boolean remove(URI uri, HttpCookie cookie) {
        return this.delegate.remove(uri, cookie);
    }

    @Override // java.net.CookieStore
    public boolean removeAll() {
        return this.delegate.removeAll();
    }

    public static List<HttpCookie> matchPath(URI uri, List<HttpCookie> cookies) {
        if (cookies == null || cookies.isEmpty()) {
            return Collections.emptyList();
        }
        List<HttpCookie> result = new ArrayList<>(4);
        String path = uri.getPath();
        if (path == 0 || path.trim().isEmpty()) {
            path = "/";
        }
        for (HttpCookie cookie : cookies) {
            String cookiePath = cookie.getPath();
            if (cookiePath == null) {
                result.add(cookie);
            } else if (path.equals(cookiePath)) {
                result.add(cookie);
            } else if (path.startsWith(cookiePath) && (cookiePath.endsWith("/") || path.charAt(cookiePath.length()) == '/')) {
                result.add(cookie);
            }
        }
        return result;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/HttpCookieStore$Empty.class */
    public static class Empty implements CookieStore {
        @Override // java.net.CookieStore
        public void add(URI uri, HttpCookie cookie) {
        }

        @Override // java.net.CookieStore
        public List<HttpCookie> get(URI uri) {
            return Collections.emptyList();
        }

        @Override // java.net.CookieStore
        public List<HttpCookie> getCookies() {
            return Collections.emptyList();
        }

        @Override // java.net.CookieStore
        public List<URI> getURIs() {
            return Collections.emptyList();
        }

        @Override // java.net.CookieStore
        public boolean remove(URI uri, HttpCookie cookie) {
            return false;
        }

        @Override // java.net.CookieStore
        public boolean removeAll() {
            return false;
        }
    }
}
