package org.jline.reader;

import java.io.IOException;
import java.util.List;

/* loaded from: grasscutter.jar:org/jline/reader/Editor.class */
public interface Editor {
    void open(List<String> list) throws IOException;

    void run() throws IOException;

    void setRestricted(boolean z);
}
