package com.mchange.p009v2.p010io;

import com.mchange.p006v1.util.UIterator;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

/* renamed from: com.mchange.v2.io.FileIterator */
/* loaded from: grasscutter.jar:com/mchange/v2/io/FileIterator.class */
public interface FileIterator extends UIterator {
    public static final FileIterator EMPTY_FILE_ITERATOR = new FileIterator() { // from class: com.mchange.v2.io.FileIterator.1
        @Override // com.mchange.p009v2.p010io.FileIterator
        public File nextFile() {
            throw new NoSuchElementException();
        }

        @Override // com.mchange.p009v2.p010io.FileIterator, com.mchange.p006v1.util.UIterator
        public boolean hasNext() {
            return false;
        }

        @Override // com.mchange.p009v2.p010io.FileIterator, com.mchange.p006v1.util.UIterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // com.mchange.p009v2.p010io.FileIterator, com.mchange.p006v1.util.UIterator
        public void remove() {
            throw new IllegalStateException();
        }

        @Override // com.mchange.p009v2.p010io.FileIterator, com.mchange.p006v1.util.UIterator, com.mchange.p006v1.util.ClosableResource
        public void close() {
        }
    };

    File nextFile() throws IOException;

    @Override // com.mchange.p006v1.util.UIterator
    boolean hasNext() throws IOException;

    @Override // com.mchange.p006v1.util.UIterator
    Object next() throws IOException;

    @Override // com.mchange.p006v1.util.UIterator
    void remove() throws IOException;

    @Override // com.mchange.p006v1.util.UIterator, com.mchange.p006v1.util.ClosableResource
    void close() throws IOException;
}
