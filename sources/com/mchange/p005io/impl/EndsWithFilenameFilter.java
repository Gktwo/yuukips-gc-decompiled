package com.mchange.p005io.impl;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.mchange.io.impl.EndsWithFilenameFilter */
/* loaded from: grasscutter.jar:com/mchange/io/impl/EndsWithFilenameFilter.class */
public class EndsWithFilenameFilter implements FilenameFilter {
    public static final int ALWAYS = 0;
    public static final int NEVER = 1;
    public static final int MATCH = 2;
    String[] endings;
    int accept_dirs;

    public EndsWithFilenameFilter(String[] strArr, int i) {
        this.endings = null;
        this.endings = strArr;
        this.accept_dirs = i;
    }

    public EndsWithFilenameFilter(String str, int i) {
        this.endings = null;
        this.endings = new String[]{str};
        this.accept_dirs = i;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        if (this.accept_dirs != 2 && new File(file, str).isDirectory()) {
            return this.accept_dirs == 0;
        }
        int length = this.endings.length;
        do {
            length--;
            if (length < 0) {
                return false;
            }
        } while (!str.endsWith(this.endings[length]));
        return true;
    }
}
