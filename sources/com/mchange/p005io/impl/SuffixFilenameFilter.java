package com.mchange.p005io.impl;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.mchange.io.impl.SuffixFilenameFilter */
/* loaded from: grasscutter.jar:com/mchange/io/impl/SuffixFilenameFilter.class */
public class SuffixFilenameFilter implements FilenameFilter {
    public static final int ALWAYS = 0;
    public static final int NEVER = 1;
    public static final int MATCH = 2;
    String[] suffixes;
    int accept_dirs;

    public SuffixFilenameFilter(String[] strArr, int i) {
        this.suffixes = null;
        this.suffixes = strArr;
        this.accept_dirs = i;
    }

    public SuffixFilenameFilter(String str, int i) {
        this.suffixes = null;
        this.suffixes = new String[]{str};
        this.accept_dirs = i;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        if (this.accept_dirs != 2 && new File(file, str).isDirectory()) {
            return this.accept_dirs == 0;
        }
        int length = this.suffixes.length;
        do {
            length--;
            if (length < 0) {
                return false;
            }
        } while (!str.endsWith(this.suffixes[length]));
        return true;
    }
}
