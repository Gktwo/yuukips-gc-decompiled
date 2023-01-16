package p001ch.qos.logback.core.util;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

/* renamed from: ch.qos.logback.core.util.LocationUtil */
/* loaded from: grasscutter.jar:ch/qos/logback/core/util/LocationUtil.class */
public class LocationUtil {
    public static final String SCHEME_PATTERN = "^\\p{Alpha}[\\p{Alnum}+.-]*:.*$";
    public static final String CLASSPATH_SCHEME = "classpath:";

    public static URL urlForResource(String location) throws MalformedURLException, FileNotFoundException {
        URL url;
        if (location == null) {
            throw new NullPointerException("location is required");
        }
        if (!location.matches(SCHEME_PATTERN)) {
            url = Loader.getResourceBySelfClassLoader(location);
        } else if (location.startsWith(CLASSPATH_SCHEME)) {
            String path = location.substring(CLASSPATH_SCHEME.length());
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            if (path.length() == 0) {
                throw new MalformedURLException("path is required");
            }
            url = Loader.getResourceBySelfClassLoader(path);
        } else {
            url = new URL(location);
        }
        if (url != null) {
            return url;
        }
        throw new FileNotFoundException(location);
    }
}
