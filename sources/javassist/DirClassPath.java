package javassist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: ClassPoolTail.java */
/* loaded from: grasscutter.jar:javassist/DirClassPath.class */
final class DirClassPath implements ClassPath {
    String directory;

    /* access modifiers changed from: package-private */
    public DirClassPath(String dirName) {
        this.directory = dirName;
    }

    @Override // javassist.ClassPath
    public InputStream openClassfile(String classname) {
        try {
            char sep = File.separatorChar;
            return new FileInputStream((this.directory + sep + classname.replace('.', sep) + ".class").toString());
        } catch (FileNotFoundException | SecurityException e) {
            return null;
        }
    }

    @Override // javassist.ClassPath
    public URL find(String classname) {
        char sep = File.separatorChar;
        File f = new File(this.directory + sep + classname.replace('.', sep) + ".class");
        if (!f.exists()) {
            return null;
        }
        try {
            return f.getCanonicalFile().toURI().toURL();
        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e2) {
            return null;
        }
    }

    public String toString() {
        return this.directory;
    }
}
