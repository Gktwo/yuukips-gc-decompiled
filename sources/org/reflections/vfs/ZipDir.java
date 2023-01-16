package org.reflections.vfs;

import java.io.IOException;
import java.util.jar.JarFile;
import java.util.zip.ZipFile;
import org.reflections.Reflections;
import org.reflections.vfs.Vfs;

/* loaded from: grasscutter.jar:org/reflections/vfs/ZipDir.class */
public class ZipDir implements Vfs.Dir {
    final ZipFile jarFile;

    public ZipDir(JarFile jarFile) {
        this.jarFile = jarFile;
    }

    @Override // org.reflections.vfs.Vfs.Dir
    public String getPath() {
        return this.jarFile != null ? this.jarFile.getName().replace("\\", "/") : "/NO-SUCH-DIRECTORY/";
    }

    @Override // org.reflections.vfs.Vfs.Dir
    public Iterable<Vfs.File> getFiles() {
        return () -> {
            return this.jarFile.stream().filter(entry -> {
                return !entry.isDirectory();
            }).map(entry -> {
                return new ZipFile(this, entry);
            }).iterator();
        };
    }

    @Override // org.reflections.vfs.Vfs.Dir
    public void close() {
        try {
            this.jarFile.close();
        } catch (IOException e) {
            if (Reflections.log != null) {
                Reflections.log.warn("Could not close JarFile", (Throwable) e);
            }
        }
    }

    public String toString() {
        return this.jarFile.getName();
    }
}
