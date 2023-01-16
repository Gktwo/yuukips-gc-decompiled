package com.mchange.p005io;

import java.io.File;
import java.io.IOException;

/* renamed from: com.mchange.io.FileEnumeration */
/* loaded from: grasscutter.jar:com/mchange/io/FileEnumeration.class */
public interface FileEnumeration extends IOEnumeration {
    boolean hasMoreFiles() throws IOException;

    File nextFile() throws IOException;
}
