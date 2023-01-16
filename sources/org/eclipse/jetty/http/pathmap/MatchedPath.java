package org.eclipse.jetty.http.pathmap;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/pathmap/MatchedPath.class */
public interface MatchedPath {
    public static final MatchedPath EMPTY = new MatchedPath() { // from class: org.eclipse.jetty.http.pathmap.MatchedPath.1
        @Override // org.eclipse.jetty.http.pathmap.MatchedPath
        public String getPathMatch() {
            return null;
        }

        @Override // org.eclipse.jetty.http.pathmap.MatchedPath
        public String getPathInfo() {
            return null;
        }

        public String toString() {
            return MatchedPath.class.getSimpleName() + ".EMPTY";
        }
    };

    String getPathMatch();

    String getPathInfo();

    static MatchedPath from(final String pathMatch, final String pathInfo) {
        return new MatchedPath() { // from class: org.eclipse.jetty.http.pathmap.MatchedPath.2
            @Override // org.eclipse.jetty.http.pathmap.MatchedPath
            public String getPathMatch() {
                return pathMatch;
            }

            @Override // org.eclipse.jetty.http.pathmap.MatchedPath
            public String getPathInfo() {
                return pathInfo;
            }

            public String toString() {
                return MatchedPath.class.getSimpleName() + "[pathMatch=" + pathMatch + ", pathInfo=" + pathInfo + "]";
            }
        };
    }
}
