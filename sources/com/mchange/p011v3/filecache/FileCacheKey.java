package com.mchange.p011v3.filecache;

import java.net.URL;

/* renamed from: com.mchange.v3.filecache.FileCacheKey */
/* loaded from: grasscutter.jar:com/mchange/v3/filecache/FileCacheKey.class */
public interface FileCacheKey {
    URL getURL();

    String getCacheFilePath();

    boolean equals(Object obj);

    int hashCode();
}
