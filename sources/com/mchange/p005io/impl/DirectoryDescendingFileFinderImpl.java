package com.mchange.p005io.impl;

import com.mchange.p005io.FileEnumeration;
import com.mchange.p005io.IOEnumeration;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.Stack;

/* renamed from: com.mchange.io.impl.DirectoryDescendingFileFinderImpl */
/* loaded from: grasscutter.jar:com/mchange/io/impl/DirectoryDescendingFileFinderImpl.class */
public class DirectoryDescendingFileFinderImpl implements IOEnumeration, FileEnumeration {
    private static final Object dummy = new Object();
    Hashtable markedDirex;
    Stack direx;
    Stack files;
    FilenameFilter filter;
    boolean canonical;

    public DirectoryDescendingFileFinderImpl(File file, FilenameFilter filenameFilter, boolean z) throws IOException {
        this.markedDirex = new Hashtable();
        this.direx = new Stack();
        this.files = new Stack();
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(file.getName() + " is not a directory.");
        }
        this.filter = filenameFilter;
        this.canonical = z;
        blossomDirectory(file);
        while (this.files.empty() && !this.direx.empty()) {
            blossomDirectory((File) this.direx.pop());
        }
    }

    public DirectoryDescendingFileFinderImpl(File file) throws IOException {
        this(file, null, false);
    }

    @Override // com.mchange.p005io.FileEnumeration
    public boolean hasMoreFiles() {
        return !this.files.empty();
    }

    @Override // com.mchange.p005io.FileEnumeration
    public File nextFile() throws IOException {
        if (this.files.empty()) {
            throw new NoSuchElementException();
        }
        File file = (File) this.files.pop();
        while (this.files.empty() && !this.direx.empty()) {
            blossomDirectory((File) this.direx.pop());
        }
        return file;
    }

    @Override // com.mchange.p005io.IOEnumeration
    public boolean hasMoreElements() {
        return hasMoreFiles();
    }

    @Override // com.mchange.p005io.IOEnumeration
    public Object nextElement() throws IOException {
        return nextFile();
    }

    private void blossomDirectory(File file) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        String[] list = this.filter == null ? file.list() : file.list(this.filter);
        int length = list.length;
        while (true) {
            length--;
            if (length < 0) {
                this.markedDirex.put(canonicalPath, dummy);
                return;
            } else if (this.filter == null || this.filter.accept(file, list[length])) {
                File file2 = new File((this.canonical ? canonicalPath : file.getPath()) + File.separator + list[length]);
                if (file2.isFile()) {
                    this.files.push(file2);
                } else if (!this.markedDirex.containsKey(file2.getCanonicalPath())) {
                    this.direx.push(file2);
                }
            }
        }
    }

    public static void main(String[] strArr) {
        try {
            DirectoryDescendingFileFinderImpl directoryDescendingFileFinderImpl = new DirectoryDescendingFileFinderImpl(new File(strArr[0]));
            while (directoryDescendingFileFinderImpl.hasMoreFiles()) {
                System.out.println(directoryDescendingFileFinderImpl.nextFile().getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
