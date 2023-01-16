package org.reflections.vfs;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Predicate;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.reflections.Reflections;
import org.reflections.ReflectionsException;
import org.reflections.vfs.Vfs;
import p001ch.qos.logback.core.joran.action.Action;

/* loaded from: grasscutter.jar:org/reflections/vfs/UrlTypeVFS.class */
public class UrlTypeVFS implements Vfs.UrlType {
    public static final String[] REPLACE_EXTENSION = {".ear/", ".jar/", ".war/", ".sar/", ".har/", ".par/"};
    final String VFSZIP = "vfszip";
    final String VFSFILE = "vfsfile";

    @Override // org.reflections.vfs.Vfs.UrlType
    public boolean matches(URL url) {
        return "vfszip".equals(url.getProtocol()) || "vfsfile".equals(url.getProtocol());
    }

    @Override // org.reflections.vfs.Vfs.UrlType
    public Vfs.Dir createDir(URL url) {
        try {
            return new ZipDir(new JarFile(adaptURL(url).getFile()));
        } catch (Exception e) {
            try {
                return new ZipDir(new JarFile(url.getFile()));
            } catch (IOException e2) {
                if (Reflections.log == null) {
                    return null;
                }
                Reflections.log.warn("Could not get URL", (Throwable) e);
                return null;
            }
        }
    }

    public URL adaptURL(URL url) throws MalformedURLException {
        if ("vfszip".equals(url.getProtocol())) {
            return replaceZipSeparators(url.getPath(), file -> {
                return file.exists() && file.isFile();
            });
        }
        if ("vfsfile".equals(url.getProtocol())) {
            return new URL(url.toString().replace("vfsfile", Action.FILE_ATTRIBUTE));
        }
        return url;
    }

    URL replaceZipSeparators(String path, Predicate<File> acceptFile) throws MalformedURLException {
        int pos = 0;
        while (pos != -1) {
            pos = findFirstMatchOfDeployableExtention(path, pos);
            if (pos > 0 && acceptFile.test(new File(path.substring(0, pos - 1)))) {
                return replaceZipSeparatorStartingFrom(path, pos);
            }
        }
        throw new ReflectionsException("Unable to identify the real zip file in path '" + path + "'.");
    }

    int findFirstMatchOfDeployableExtention(String path, int pos) {
        Matcher m = Pattern.compile("\\.[ejprw]ar/").matcher(path);
        if (m.find(pos)) {
            return m.end();
        }
        return -1;
    }

    URL replaceZipSeparatorStartingFrom(String path, int pos) throws MalformedURLException {
        String zipFile = path.substring(0, pos - 1);
        String zipPath = path.substring(pos);
        int numSubs = 1;
        String[] strArr = REPLACE_EXTENSION;
        for (String ext : strArr) {
            while (zipPath.contains(ext)) {
                zipPath = zipPath.replace(ext, ext.substring(0, 4) + "!");
                numSubs++;
            }
        }
        String prefix = "";
        for (int i = 0; i < numSubs; i++) {
            prefix = prefix + "zip:";
        }
        if (zipPath.trim().length() == 0) {
            return new URL(prefix + "/" + zipFile);
        }
        return new URL(prefix + "/" + zipFile + "!" + zipPath);
    }
}
