package org.eclipse.jetty.http.pathmap;

import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/pathmap/ServletPathSpec.class */
public class ServletPathSpec extends AbstractPathSpec {
    private static final Logger LOG = Log.getLogger(ServletPathSpec.class);
    private final String _declaration;
    private final PathSpecGroup _group;
    private final int _pathDepth;
    private final int _specLength;
    private final int _matchLength;
    private final String _prefix;
    private final String _suffix;
    private final MatchedPath _preMatchedPath;

    public static String normalize(String pathSpec) {
        if (!StringUtil.isNotBlank(pathSpec) || pathSpec.startsWith("/") || pathSpec.startsWith("*")) {
            return pathSpec;
        }
        return "/" + pathSpec;
    }

    public ServletPathSpec(String servletPathSpec) {
        MatchedPath preMatchedPath;
        String suffix;
        String prefix;
        PathSpecGroup group;
        servletPathSpec = servletPathSpec == null ? "" : servletPathSpec;
        servletPathSpec = servletPathSpec.startsWith("servlet|") ? servletPathSpec.substring("servlet|".length()) : servletPathSpec;
        assertValidServletPathSpec(servletPathSpec);
        if (servletPathSpec.isEmpty()) {
            this._declaration = "";
            this._group = PathSpecGroup.ROOT;
            this._pathDepth = -1;
            this._specLength = 1;
            this._matchLength = 0;
            this._prefix = null;
            this._suffix = null;
            this._preMatchedPath = MatchedPath.from("", "/");
        } else if ("/".equals(servletPathSpec)) {
            this._declaration = "/";
            this._group = PathSpecGroup.DEFAULT;
            this._pathDepth = -1;
            this._specLength = 1;
            this._matchLength = 0;
            this._prefix = null;
            this._suffix = null;
            this._preMatchedPath = null;
        } else {
            int specLength = servletPathSpec.length();
            if (servletPathSpec.charAt(0) == '/' && servletPathSpec.endsWith("/*")) {
                group = PathSpecGroup.PREFIX_GLOB;
                prefix = servletPathSpec.substring(0, specLength - 2);
                suffix = null;
                preMatchedPath = MatchedPath.from(prefix, null);
            } else if (servletPathSpec.charAt(0) != '*' || servletPathSpec.length() <= 1) {
                group = PathSpecGroup.EXACT;
                prefix = servletPathSpec;
                suffix = null;
                if (servletPathSpec.endsWith("*")) {
                    LOG.warn("Suspicious URL pattern: '{}'; see sections 12.1 and 12.2 of the Servlet specification", servletPathSpec);
                }
                preMatchedPath = MatchedPath.from(servletPathSpec, null);
            } else {
                group = PathSpecGroup.SUFFIX_GLOB;
                prefix = null;
                suffix = servletPathSpec.substring(2, specLength);
                preMatchedPath = null;
            }
            int pathDepth = 0;
            for (int i = 0; i < specLength; i++) {
                char c = servletPathSpec.charAt(i);
                if (c < 128 && c == '/') {
                    pathDepth++;
                }
            }
            this._declaration = servletPathSpec;
            this._group = group;
            this._pathDepth = pathDepth;
            this._specLength = specLength;
            this._matchLength = prefix == null ? 0 : prefix.length();
            this._prefix = prefix;
            this._suffix = suffix;
            this._preMatchedPath = preMatchedPath;
            if (LOG.isDebugEnabled()) {
                LOG.debug("Creating {}[{}] (group: {}, prefix: \"{}\", suffix: \"{}\")", getClass().getSimpleName(), this._declaration, this._group, this._prefix, this._suffix);
            }
        }
    }

    private static void assertValidServletPathSpec(String servletPathSpec) {
        int idx;
        if (servletPathSpec != null && !servletPathSpec.equals("")) {
            int len = servletPathSpec.length();
            if (servletPathSpec.charAt(0) == '/') {
                if (len != 1 && (idx = servletPathSpec.indexOf(42)) >= 0 && idx != len - 1) {
                    throw new IllegalArgumentException("Servlet Spec 12.2 violation: glob '*' can only exist at end of prefix based matches: bad spec \"" + servletPathSpec + "\"");
                }
            } else if (!servletPathSpec.startsWith("*.")) {
                throw new IllegalArgumentException("Servlet Spec 12.2 violation: path spec must start with \"/\" or \"*.\": bad spec \"" + servletPathSpec + "\"");
            } else if (servletPathSpec.indexOf(47) >= 0) {
                throw new IllegalArgumentException("Servlet Spec 12.2 violation: suffix based path spec cannot have path separators: bad spec \"" + servletPathSpec + "\"");
            } else if (servletPathSpec.indexOf(42, 2) >= 1) {
                throw new IllegalArgumentException("Servlet Spec 12.2 violation: suffix based path spec cannot have multiple glob '*': bad spec \"" + servletPathSpec + "\"");
            }
        }
    }

    @Override // org.eclipse.jetty.http.pathmap.PathSpec
    public int getSpecLength() {
        return this._specLength;
    }

    @Override // org.eclipse.jetty.http.pathmap.PathSpec
    public PathSpecGroup getGroup() {
        return this._group;
    }

    @Override // org.eclipse.jetty.http.pathmap.PathSpec
    public int getPathDepth() {
        return this._pathDepth;
    }

    @Override // org.eclipse.jetty.http.pathmap.PathSpec
    @Deprecated
    public String getPathInfo(String path) {
        switch (this._group) {
            case ROOT:
                return path;
            case PREFIX_GLOB:
                if (path.length() == this._matchLength) {
                    return null;
                }
                return path.substring(this._matchLength);
            default:
                return null;
        }
    }

    @Override // org.eclipse.jetty.http.pathmap.PathSpec
    @Deprecated
    public String getPathMatch(String path) {
        switch (this._group) {
            case ROOT:
                return "";
            case PREFIX_GLOB:
                if (isWildcardMatch(path)) {
                    return path.substring(0, this._matchLength);
                }
                return null;
            case EXACT:
                if (this._declaration.equals(path)) {
                    return path;
                }
                return null;
            case SUFFIX_GLOB:
                if (path.regionMatches(path.length() - (this._specLength - 1), this._declaration, 1, this._specLength - 1)) {
                    return path;
                }
                return null;
            case DEFAULT:
                return path;
            default:
                return null;
        }
    }

    @Override // org.eclipse.jetty.http.pathmap.PathSpec
    public String getDeclaration() {
        return this._declaration;
    }

    @Override // org.eclipse.jetty.http.pathmap.PathSpec
    public String getPrefix() {
        return this._prefix;
    }

    @Override // org.eclipse.jetty.http.pathmap.PathSpec
    public String getSuffix() {
        return this._suffix;
    }

    private boolean isWildcardMatch(String path) {
        if (this._group != PathSpecGroup.PREFIX_GLOB || path.length() < this._matchLength || !path.regionMatches(0, this._declaration, 0, this._matchLength)) {
            return false;
        }
        return path.length() == this._matchLength || path.charAt(this._matchLength) == '/';
    }

    @Override // org.eclipse.jetty.http.pathmap.PathSpec
    public MatchedPath matched(String path) {
        switch (this._group) {
            case ROOT:
                if ("/".equals(path)) {
                    return this._preMatchedPath;
                }
                return null;
            case PREFIX_GLOB:
                if (!isWildcardMatch(path)) {
                    return null;
                }
                if (path.length() == this._matchLength) {
                    return this._preMatchedPath;
                }
                return MatchedPath.from(path.substring(0, this._matchLength), path.substring(this._matchLength));
            case EXACT:
                if (this._declaration.equals(path)) {
                    return this._preMatchedPath;
                }
                return null;
            case SUFFIX_GLOB:
                if (path.regionMatches((path.length() - this._specLength) + 1, this._declaration, 1, this._specLength - 1)) {
                    return MatchedPath.from(path, null);
                }
                return null;
            case DEFAULT:
                return MatchedPath.from(path, null);
            default:
                return null;
        }
    }

    @Override // org.eclipse.jetty.http.pathmap.PathSpec
    public boolean matches(String path) {
        switch (this._group) {
            case ROOT:
                return "/".equals(path);
            case PREFIX_GLOB:
                return isWildcardMatch(path);
            case EXACT:
                return this._declaration.equals(path);
            case SUFFIX_GLOB:
                return path.regionMatches((path.length() - this._specLength) + 1, this._declaration, 1, this._specLength - 1);
            case DEFAULT:
                return true;
            default:
                return false;
        }
    }
}
