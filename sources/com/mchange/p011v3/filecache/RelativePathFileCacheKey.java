package com.mchange.p011v3.filecache;

import java.net.MalformedURLException;
import java.net.URL;

/* renamed from: com.mchange.v3.filecache.RelativePathFileCacheKey */
/* loaded from: grasscutter.jar:com/mchange/v3/filecache/RelativePathFileCacheKey.class */
public class RelativePathFileCacheKey implements FileCacheKey {
    final URL url;
    final String relPath;

    public RelativePathFileCacheKey(URL url, String str) throws MalformedURLException, IllegalArgumentException {
        String trim = str.trim();
        if (url == null || str == null) {
            throw new IllegalArgumentException("parentURL [" + url + "] and relative path [" + str + "] must be non-null");
        } else if (trim.length() == 0) {
            throw new IllegalArgumentException("relative path [" + str + "] must not be a blank string");
        } else if (!trim.equals(str)) {
            throw new IllegalArgumentException("relative path [" + str + "] must not begin or end with whitespace.");
        } else if (str.startsWith("/")) {
            throw new IllegalArgumentException("Path must be relative, '" + str + "' begins with '/'.");
        } else {
            this.url = new URL(url, str);
            this.relPath = str;
        }
    }

    @Override // com.mchange.p011v3.filecache.FileCacheKey
    public URL getURL() {
        return this.url;
    }

    @Override // com.mchange.p011v3.filecache.FileCacheKey
    public String getCacheFilePath() {
        return this.relPath;
    }

    @Override // com.mchange.p011v3.filecache.FileCacheKey
    public boolean equals(Object obj) {
        if (!(obj instanceof RelativePathFileCacheKey)) {
            return false;
        }
        RelativePathFileCacheKey relativePathFileCacheKey = (RelativePathFileCacheKey) obj;
        return this.url.equals(relativePathFileCacheKey.url) && this.relPath.equals(relativePathFileCacheKey.relPath);
    }

    @Override // com.mchange.p011v3.filecache.FileCacheKey
    public int hashCode() {
        return this.url.hashCode() ^ this.relPath.hashCode();
    }
}
