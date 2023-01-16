package com.mchange.p011v3.filecache;

import com.mchange.p009v2.log.MLogger;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* renamed from: com.mchange.v3.filecache.URLFetcher */
/* loaded from: grasscutter.jar:com/mchange/v3/filecache/URLFetcher.class */
public interface URLFetcher {
    InputStream openStream(URL url, MLogger mLogger) throws IOException;
}
