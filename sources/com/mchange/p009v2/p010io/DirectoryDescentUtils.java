package com.mchange.p009v2.p010io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/* renamed from: com.mchange.v2.io.DirectoryDescentUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/io/DirectoryDescentUtils.class */
public final class DirectoryDescentUtils {
    public static FileIterator depthFirstEagerDescent(File file) throws IOException {
        return depthFirstEagerDescent(file, null, false);
    }

    public static FileIterator depthFirstEagerDescent(File file, FileFilter fileFilter, boolean z) throws IOException {
        LinkedList linkedList = new LinkedList();
        depthFirstEagerDescend(file, fileFilter, z, linkedList, new HashSet());
        return new IteratorFileIterator(linkedList.iterator());
    }

    public static void addSubtree(File file, FileFilter fileFilter, boolean z, Collection collection) throws IOException {
        depthFirstEagerDescend(file, fileFilter, z, collection, new HashSet());
    }

    private static void depthFirstEagerDescend(File file, FileFilter fileFilter, boolean z, Collection collection, Set set) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        if (!set.contains(canonicalPath)) {
            if (fileFilter == null || fileFilter.accept(file)) {
                collection.add(z ? new File(canonicalPath) : file);
            }
            set.add(canonicalPath);
            for (String str : file.list()) {
                File file2 = new File(file, str);
                if (file2.isDirectory()) {
                    depthFirstEagerDescend(file2, fileFilter, z, collection, set);
                } else if (fileFilter == null || fileFilter.accept(file2)) {
                    collection.add(z ? file2.getCanonicalFile() : file2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.mchange.v2.io.DirectoryDescentUtils$IteratorFileIterator */
    /* loaded from: grasscutter.jar:com/mchange/v2/io/DirectoryDescentUtils$IteratorFileIterator.class */
    public static class IteratorFileIterator implements FileIterator {

        /* renamed from: ii */
        Iterator f422ii;
        Object last;

        IteratorFileIterator(Iterator it) {
            this.f422ii = it;
        }

        @Override // com.mchange.p009v2.p010io.FileIterator
        public File nextFile() throws IOException {
            return (File) next();
        }

        @Override // com.mchange.p009v2.p010io.FileIterator, com.mchange.p006v1.util.UIterator
        public boolean hasNext() throws IOException {
            return this.f422ii.hasNext();
        }

        @Override // com.mchange.p009v2.p010io.FileIterator, com.mchange.p006v1.util.UIterator
        public Object next() throws IOException {
            Object next = this.f422ii.next();
            this.last = next;
            return next;
        }

        @Override // com.mchange.p009v2.p010io.FileIterator, com.mchange.p006v1.util.UIterator
        public void remove() throws IOException {
            if (this.last != null) {
                ((File) this.last).delete();
                this.last = null;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // com.mchange.p009v2.p010io.FileIterator, com.mchange.p006v1.util.UIterator, com.mchange.p006v1.util.ClosableResource
        public void close() throws IOException {
        }
    }

    private DirectoryDescentUtils() {
    }

    public static void main(String[] strArr) {
        try {
            FileIterator depthFirstEagerDescent = depthFirstEagerDescent(new File(strArr[0]));
            while (depthFirstEagerDescent.hasNext()) {
                System.err.println(depthFirstEagerDescent.nextFile().getPath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
