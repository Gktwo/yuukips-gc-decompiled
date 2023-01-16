package com.mchange.p005io;

import com.mchange.util.ByteArrayBinding;
import com.mchange.util.ByteArrayComparator;
import java.io.IOException;

/* renamed from: com.mchange.io.IOSequentialByteArrayMap */
/* loaded from: grasscutter.jar:com/mchange/io/IOSequentialByteArrayMap.class */
public interface IOSequentialByteArrayMap extends IOByteArrayMap {

    /* renamed from: com.mchange.io.IOSequentialByteArrayMap$Cursor */
    /* loaded from: grasscutter.jar:com/mchange/io/IOSequentialByteArrayMap$Cursor.class */
    public interface Cursor {
        ByteArrayBinding getFirst() throws IOException;

        ByteArrayBinding getNext() throws IOException;

        ByteArrayBinding getPrevious() throws IOException;

        ByteArrayBinding getLast() throws IOException;

        ByteArrayBinding getCurrent() throws IOException;

        ByteArrayBinding find(byte[] bArr) throws IOException;

        ByteArrayBinding findGreaterThanOrEqual(byte[] bArr) throws IOException;

        ByteArrayBinding findLessThanOrEqual(byte[] bArr) throws IOException;

        void deleteCurrent() throws IOException;

        void replaceCurrent(byte[] bArr) throws IOException;
    }

    ByteArrayComparator getByteArrayComparator();

    Cursor getCursor();
}
