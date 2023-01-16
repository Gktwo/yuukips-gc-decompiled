package javassist;

import java.io.InputStream;
import java.net.URL;

/* loaded from: grasscutter.jar:javassist/ClassPath.class */
public interface ClassPath {
    InputStream openClassfile(String str) throws NotFoundException;

    URL find(String str);
}
