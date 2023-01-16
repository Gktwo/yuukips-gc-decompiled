package com.google.common.p004io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.nio.file.FileSystemException;

@Beta
@GwtIncompatible
/* renamed from: com.google.common.io.InsecureRecursiveDeleteException */
/* loaded from: grasscutter.jar:com/google/common/io/InsecureRecursiveDeleteException.class */
public final class InsecureRecursiveDeleteException extends FileSystemException {
    public InsecureRecursiveDeleteException(String file) {
        super(file, null, "unable to guarantee security of recursive delete");
    }
}
