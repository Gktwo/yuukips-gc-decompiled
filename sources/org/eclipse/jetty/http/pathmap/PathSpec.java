package org.eclipse.jetty.http.pathmap;

import java.util.Objects;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/pathmap/PathSpec.class */
public interface PathSpec extends Comparable<PathSpec> {
    int getSpecLength();

    PathSpecGroup getGroup();

    int getPathDepth();

    @Deprecated
    String getPathInfo(String str);

    @Deprecated
    String getPathMatch(String str);

    String getDeclaration();

    String getPrefix();

    String getSuffix();

    @Deprecated
    boolean matches(String str);

    MatchedPath matched(String str);

    static PathSpec from(String pathSpecString) {
        Objects.requireNonNull(pathSpecString, "null PathSpec not supported");
        if (pathSpecString.length() == 0) {
            return new ServletPathSpec("");
        }
        return pathSpecString.charAt(0) == '^' ? new RegexPathSpec(pathSpecString) : new ServletPathSpec(pathSpecString);
    }
}
