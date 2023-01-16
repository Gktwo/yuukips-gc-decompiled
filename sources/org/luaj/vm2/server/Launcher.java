package org.luaj.vm2.server;

import java.io.InputStream;
import java.io.Reader;

/* loaded from: grasscutter.jar:org/luaj/vm2/server/Launcher.class */
public interface Launcher {
    Object[] launch(String str, Object[] objArr);

    Object[] launch(InputStream inputStream, Object[] objArr);

    Object[] launch(Reader reader, Object[] objArr);
}
