package org.eclipse.jetty.util.resource;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.eclipse.jetty.util.C5747IO;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.UrlEncoded;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.quartz.xml.XMLSchedulingDataProcessor;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/resource/Resource.class */
public abstract class Resource implements ResourceFactory, Closeable {
    private static final Logger LOG = Log.getLogger(Resource.class);
    public static boolean __defaultUseCaches = true;
    volatile Object _associate;

    public abstract boolean isContainedIn(Resource resource) throws MalformedURLException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract boolean exists();

    public abstract boolean isDirectory();

    public abstract long lastModified();

    public abstract long length();

    @Deprecated
    public abstract URL getURL();

    public abstract File getFile() throws IOException;

    public abstract String getName();

    public abstract InputStream getInputStream() throws IOException;

    public abstract ReadableByteChannel getReadableByteChannel() throws IOException;

    public abstract boolean delete() throws SecurityException;

    public abstract boolean renameTo(Resource resource) throws SecurityException;

    public abstract String[] list();

    public abstract Resource addPath(String str) throws IOException, MalformedURLException;

    public static void setDefaultUseCaches(boolean useCaches) {
        __defaultUseCaches = useCaches;
    }

    public static boolean getDefaultUseCaches() {
        return __defaultUseCaches;
    }

    public static Resource newResource(URI uri) throws MalformedURLException {
        return newResource(uri.toURL());
    }

    public static Resource newResource(URL url) {
        return newResource(url, __defaultUseCaches);
    }

    static Resource newResource(URL url, boolean useCaches) {
        if (url == null) {
            return null;
        }
        String urlString = url.toExternalForm();
        if (urlString.startsWith("file:")) {
            try {
                return new PathResource(url);
            } catch (Exception e) {
                LOG.warn(e.toString(), new Object[0]);
                LOG.debug(Log.EXCEPTION, e);
                return new BadResource(url, e.toString());
            }
        } else if (urlString.startsWith("jar:file:")) {
            return new JarFileResource(url, useCaches);
        } else {
            if (urlString.startsWith(XMLSchedulingDataProcessor.QUARTZ_SYSTEM_ID_JAR_PREFIX)) {
                return new JarResource(url, useCaches);
            }
            return new URLResource(url, null, useCaches);
        }
    }

    public static Resource newResource(String resource) throws IOException {
        return newResource(resource, __defaultUseCaches);
    }

    public static Resource newResource(String resource, boolean useCaches) throws IOException {
        try {
            return newResource(new URL(resource), useCaches);
        } catch (MalformedURLException e) {
            if (!resource.startsWith("ftp:") && !resource.startsWith("file:") && !resource.startsWith(XMLSchedulingDataProcessor.QUARTZ_SYSTEM_ID_JAR_PREFIX)) {
                return new PathResource(Paths.get(resource, new String[0]));
            }
            LOG.warn("Bad Resource: " + resource, new Object[0]);
            throw e;
        }
    }

    public static Resource newResource(File file) {
        return new PathResource(file.toPath());
    }

    public static Resource newResource(Path path) {
        return new PathResource(path);
    }

    public static Resource newSystemResource(String resource) throws IOException {
        ClassLoader loader;
        URL url = null;
        ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
        if (loader2 != null) {
            try {
                url = loader2.getResource(resource);
                if (url == null && resource.startsWith("/")) {
                    url = loader2.getResource(resource.substring(1));
                }
            } catch (IllegalArgumentException e) {
                LOG.ignore(e);
                url = null;
            }
        }
        if (url == null && (loader = Resource.class.getClassLoader()) != null) {
            url = loader.getResource(resource);
            if (url == null && resource.startsWith("/")) {
                url = loader.getResource(resource.substring(1));
            }
        }
        if (url == null) {
            url = ClassLoader.getSystemResource(resource);
            if (url == null && resource.startsWith("/")) {
                url = ClassLoader.getSystemResource(resource.substring(1));
            }
        }
        if (url == null) {
            return null;
        }
        return newResource(url);
    }

    public static Resource newClassPathResource(String resource) {
        return newClassPathResource(resource, true, false);
    }

    public static Resource newClassPathResource(String name, boolean useCaches, boolean checkParents) {
        URL url = Resource.class.getResource(name);
        if (url == null) {
            url = Loader.getResource(name);
        }
        if (url == null) {
            return null;
        }
        return newResource(url, useCaches);
    }

    public static boolean isContainedIn(Resource r, Resource containingResource) throws MalformedURLException {
        return r.isContainedIn(containingResource);
    }

    @Override // java.lang.Object
    protected void finalize() {
        close();
    }

    public boolean isSame(Resource resource) {
        return equals(resource);
    }

    public final void release() {
        close();
    }

    public URI getURI() {
        try {
            return getURL().toURI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.eclipse.jetty.util.resource.ResourceFactory
    public Resource getResource(String path) {
        try {
            return addPath(path);
        } catch (Exception e) {
            LOG.debug(e);
            return null;
        }
    }

    @Deprecated
    public String encode(String uri) {
        return null;
    }

    public Object getAssociate() {
        return this._associate;
    }

    public void setAssociate(Object o) {
        this._associate = o;
    }

    public boolean isAlias() {
        return getAlias() != null;
    }

    public URI getAlias() {
        return null;
    }

    @Deprecated
    public String getListHTML(String base, boolean parent) throws IOException {
        return getListHTML(base, parent, null);
    }

    public String getListHTML(String base, boolean parent, String query) throws IOException {
        String[] rawListing;
        String base2 = URIUtil.canonicalPath(base);
        if (base2 == null || !isDirectory() || (rawListing = list()) == null) {
            return null;
        }
        boolean sortOrderAscending = true;
        String sortColumn = "N";
        if (query != null) {
            MultiMap<String> params = new MultiMap<>();
            UrlEncoded.decodeUtf8To(query, 0, query.length(), params);
            String paramO = params.getString("O");
            String paramC = params.getString("C");
            if (StringUtil.isNotBlank(paramO)) {
                if (paramO.equals("A")) {
                    sortOrderAscending = true;
                } else if (paramO.equals("D")) {
                    sortOrderAscending = false;
                }
            }
            if (StringUtil.isNotBlank(paramC) && (paramC.equals("N") || paramC.equals("M") || paramC.equals("S"))) {
                sortColumn = paramC;
            }
        }
        List<Resource> items = new ArrayList<>();
        for (String l : rawListing) {
            items.add(addPath(l));
        }
        if (sortColumn.equals("M")) {
            Collections.sort(items, ResourceCollators.byLastModified(sortOrderAscending));
        } else if (sortColumn.equals("S")) {
            Collections.sort(items, ResourceCollators.bySize(sortOrderAscending));
        } else {
            Collections.sort(items, ResourceCollators.byName(sortOrderAscending));
        }
        String title = "Directory: " + deTag(URIUtil.decodePath(base2));
        StringBuilder buf = new StringBuilder(4096);
        buf.append("<!DOCTYPE html>\n");
        buf.append("<html lang=\"en\">\n");
        buf.append("<head>\n");
        buf.append("<meta charset=\"utf-8\">\n");
        buf.append("<link href=\"jetty-dir.css\" rel=\"stylesheet\" />\n");
        buf.append("<title>");
        buf.append(title);
        buf.append("</title>\n");
        buf.append("</head>\n");
        buf.append("<body>\n");
        buf.append("<h1 class=\"title\">").append(title).append("</h1>\n");
        buf.append("<table class=\"listing\">\n");
        buf.append("<thead>\n");
        String arrow = "";
        String order = "A";
        if (sortColumn.equals("N")) {
            if (sortOrderAscending) {
                order = "D";
                arrow = "&nbsp; &#8679;";
            } else {
                order = "A";
                arrow = "&nbsp; &#8681;";
            }
        }
        buf.append("<tr><th class=\"name\"><a href=\"?C=N&O=").append(order).append("\">");
        buf.append("Name").append(arrow);
        buf.append("</a></th>");
        String arrow2 = "";
        String order2 = "A";
        if (sortColumn.equals("M")) {
            if (sortOrderAscending) {
                order2 = "D";
                arrow2 = "&nbsp; &#8679;";
            } else {
                order2 = "A";
                arrow2 = "&nbsp; &#8681;";
            }
        }
        buf.append("<th class=\"lastmodified\"><a href=\"?C=M&O=").append(order2).append("\">");
        buf.append("Last Modified").append(arrow2);
        buf.append("</a></th>");
        String arrow3 = "";
        String order3 = "A";
        if (sortColumn.equals("S")) {
            if (sortOrderAscending) {
                order3 = "D";
                arrow3 = "&nbsp; &#8679;";
            } else {
                order3 = "A";
                arrow3 = "&nbsp; &#8681;";
            }
        }
        buf.append("<th class=\"size\"><a href=\"?C=S&O=").append(order3).append("\">");
        buf.append("Size").append(arrow3);
        buf.append("</a></th></tr>\n");
        buf.append("</thead>\n");
        buf.append("<tbody>\n");
        String encodedBase = hrefEncodeURI(base2);
        if (parent) {
            buf.append("<tr><td class=\"name\"><a href=\"");
            buf.append(URIUtil.addPaths(encodedBase, "../"));
            buf.append("\">Parent Directory</a></td>");
            buf.append("<td class=\"lastmodified\">-</td>");
            buf.append("<td>-</td>");
            buf.append("</tr>\n");
        }
        DateFormat dfmt = DateFormat.getDateTimeInstance(2, 2);
        for (Resource item : items) {
            String name = item.getFileName();
            if (!StringUtil.isBlank(name)) {
                if (item.isDirectory() && !name.endsWith("/")) {
                    name = name + "/";
                }
                buf.append("<tr><td class=\"name\"><a href=\"");
                buf.append(URIUtil.addEncodedPaths(encodedBase, URIUtil.encodePath(name)));
                buf.append("\">");
                buf.append(deTag(name));
                buf.append("&nbsp;");
                buf.append("</a></td>");
                buf.append("<td class=\"lastmodified\">");
                if (item.lastModified() > 0) {
                    buf.append(dfmt.format(new Date(item.lastModified())));
                }
                buf.append("&nbsp;</td>");
                buf.append("<td class=\"size\">");
                if (item.length() >= 0) {
                    buf.append(String.format("%,d bytes", Long.valueOf(item.length())));
                }
                buf.append("&nbsp;</td></tr>\n");
            }
        }
        buf.append("</tbody>\n");
        buf.append("</table>\n");
        buf.append("</body></html>\n");
        return buf.toString();
    }

    private String getFileName() {
        String encodedFileName;
        try {
            File file = getFile();
            if (file != null) {
                return file.getName();
            }
        } catch (Throwable th) {
        }
        try {
            String rawName = getName();
            int idx = rawName.lastIndexOf(47);
            if (idx == rawName.length() - 1) {
                idx = rawName.lastIndexOf(47, idx - 1);
            }
            if (idx >= 0) {
                encodedFileName = rawName.substring(idx + 1);
            } else {
                encodedFileName = rawName;
            }
            return UrlEncoded.decodeString(encodedFileName, 0, encodedFileName.length(), StandardCharsets.UTF_8);
        } catch (Throwable th2) {
            return null;
        }
    }

    private static String hrefEncodeURI(String raw) {
        StringBuffer buf = null;
        int i = 0;
        while (true) {
            if (i < raw.length()) {
                switch (raw.charAt(i)) {
                    case '\"':
                    case '\'':
                    case '<':
                    case '>':
                        buf = new StringBuffer(raw.length() << 1);
                        break;
                    default:
                        i++;
                }
            }
        }
        if (buf == null) {
            return raw;
        }
        for (int i2 = 0; i2 < raw.length(); i2++) {
            char c = raw.charAt(i2);
            switch (c) {
                case '\"':
                    buf.append("%22");
                    break;
                case '\'':
                    buf.append("%27");
                    break;
                case '<':
                    buf.append("%3C");
                    break;
                case '>':
                    buf.append("%3E");
                    break;
                default:
                    buf.append(c);
                    break;
            }
        }
        return buf.toString();
    }

    private static String deTag(String raw) {
        return StringUtil.sanitizeXmlString(raw);
    }

    public void writeTo(OutputStream out, long start, long count) throws IOException {
        InputStream in = getInputStream();
        try {
            in.skip(start);
            if (count < 0) {
                C5747IO.copy(in, out);
            } else {
                C5747IO.copy(in, out, count);
            }
            if (in != null) {
                in.close();
            }
        } catch (Throwable th) {
            if (in != null) {
                try {
                    in.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void copyTo(File destination) throws IOException {
        if (destination.exists()) {
            throw new IllegalArgumentException(destination + " exists");
        }
        OutputStream out = new FileOutputStream(destination);
        try {
            writeTo(out, 0, -1);
            out.close();
        } catch (Throwable th) {
            try {
                out.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public String getWeakETag() {
        return getWeakETag("");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getWeakETag(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r2 = 32
            r1.<init>(r2)
            r9 = r0
            r0 = r9
            java.lang.String r1 = "W/\""
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            java.lang.String r0 = r0.getName()
            r10 = r0
            r0 = r10
            int r0 = r0.length()
            r11 = r0
            r0 = 0
            r12 = r0
            r0 = 0
            r14 = r0
        L_0x0022:
            r0 = r14
            r1 = r11
            if (r0 >= r1) goto L_0x003f
            r0 = 31
            r1 = r12
            long r0 = r0 * r1
            r1 = r10
            r2 = r14
            char r1 = r1.charAt(r2)
            long r1 = (long) r1
            long r0 = r0 + r1
            r12 = r0
            int r14 = r14 + 1
            goto L_0x0022
        L_0x003f:
            java.util.Base64$Encoder r0 = java.util.Base64.getEncoder()
            java.util.Base64$Encoder r0 = r0.withoutPadding()
            r14 = r0
            r0 = r9
            r1 = r14
            r2 = r7
            long r2 = r2.lastModified()
            r3 = r12
            long r2 = r2 ^ r3
            byte[] r2 = longToBytes(r2)
            java.lang.String r1 = r1.encodeToString(r2)
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r9
            r1 = r14
            r2 = r7
            long r2 = r2.length()
            r3 = r12
            long r2 = r2 ^ r3
            byte[] r2 = longToBytes(r2)
            java.lang.String r1 = r1.encodeToString(r2)
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r9
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r9
            r1 = 34
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r9
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.resource.Resource.getWeakETag(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] longToBytes(long r7) {
        /*
            r0 = 8
            byte[] r0 = new byte[r0]
            r9 = r0
            r0 = 7
            r10 = r0
        L_0x0008:
            r0 = r10
            if (r0 < 0) goto L_0x0021
            r0 = r9
            r1 = r10
            r2 = r7
            r3 = 255(0xff, double:1.26E-321)
            long r2 = r2 & r3
            int r2 = (int) r2
            byte r2 = (byte) r2
            r0[r1] = r2
            r0 = r7
            r1 = 8
            long r0 = r0 >> r1
            r7 = r0
            int r10 = r10 + -1
            goto L_0x0008
        L_0x0021:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.resource.Resource.longToBytes(long):byte[]");
    }

    public Collection<Resource> getAllResources() {
        try {
            ArrayList<Resource> deep = new ArrayList<>();
            String[] list = list();
            if (list != null) {
                for (String i : list) {
                    Resource r = addPath(i);
                    if (r.isDirectory()) {
                        deep.addAll(r.getAllResources());
                    } else {
                        deep.add(r);
                    }
                }
            }
            return deep;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static URL toURL(File file) throws MalformedURLException {
        return file.toURI().toURL();
    }
}
