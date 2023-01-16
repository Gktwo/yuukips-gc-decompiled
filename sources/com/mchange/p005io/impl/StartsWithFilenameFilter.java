package com.mchange.p005io.impl;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.mchange.io.impl.StartsWithFilenameFilter */
/* loaded from: grasscutter.jar:com/mchange/io/impl/StartsWithFilenameFilter.class */
public class StartsWithFilenameFilter implements FilenameFilter {
    public static final int ALWAYS = 0;
    public static final int NEVER = 1;
    public static final int MATCH = 2;
    String[] beginnings;
    int accept_dirs;

    public StartsWithFilenameFilter(String[] strArr, int i) {
        this.beginnings = null;
        this.beginnings = strArr;
        this.accept_dirs = i;
    }

    public StartsWithFilenameFilter(String str, int i) {
        this.beginnings = null;
        this.beginnings = new String[]{str};
        this.accept_dirs = i;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        if (this.accept_dirs != 2 && new File(file, str).isDirectory()) {
            return this.accept_dirs == 0;
        }
        int length = this.beginnings.length;
        do {
            length--;
            if (length < 0) {
                return false;
            }
        } while (!str.startsWith(this.beginnings[length]));
        return true;
    }
}
