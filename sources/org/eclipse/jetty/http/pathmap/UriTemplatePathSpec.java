package org.eclipse.jetty.http.pathmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/pathmap/UriTemplatePathSpec.class */
public class UriTemplatePathSpec extends AbstractPathSpec {
    private static final String VARIABLE_RESERVED = ":/?#[]@!$&'()*+,;=";
    private static final String VARIABLE_SYMBOLS = "-._";
    private final String _declaration;
    private final PathSpecGroup _group;
    private final int _pathDepth;
    private final int _specLength;
    private final Pattern _pattern;
    private final String[] _variables;
    private final String _logicalDeclaration;
    private static final Logger LOG = Log.getLogger(UriTemplatePathSpec.class);
    private static final Pattern VARIABLE_PATTERN = Pattern.compile("\\{(.*)\\}");
    private static final Set<String> FORBIDDEN_SEGMENTS = new HashSet();

    static {
        FORBIDDEN_SEGMENTS.add("/./");
        FORBIDDEN_SEGMENTS.add("/../");
        FORBIDDEN_SEGMENTS.add("//");
    }

    public UriTemplatePathSpec(String rawSpec) {
        PathSpecGroup group;
        Objects.requireNonNull(rawSpec, "Path Param Spec cannot be null");
        if ("".equals(rawSpec) || "/".equals(rawSpec)) {
            this._declaration = "/";
            this._group = PathSpecGroup.EXACT;
            this._pathDepth = 1;
            this._specLength = 1;
            this._pattern = Pattern.compile("^/$");
            this._variables = new String[0];
            this._logicalDeclaration = "/";
        } else if (rawSpec.charAt(0) != '/') {
            throw new IllegalArgumentException("Syntax Error: path spec \"" + rawSpec + "\" must start with '/'");
        } else {
            for (String forbidden : FORBIDDEN_SEGMENTS) {
                if (rawSpec.contains(forbidden)) {
                    throw new IllegalArgumentException("Syntax Error: segment " + forbidden + " is forbidden in path spec: " + rawSpec);
                }
            }
            StringBuilder regex = new StringBuilder();
            regex.append('^');
            List<String> varNames = new ArrayList<>();
            String[] segments = rawSpec.substring(1).split("/");
            char[] segmentSignature = new char[segments.length];
            StringBuilder logicalSignature = new StringBuilder();
            int pathDepth = segments.length;
            for (int i = 0; i < segments.length; i++) {
                String segment = segments[i];
                Matcher mat = VARIABLE_PATTERN.matcher(segment);
                if (mat.matches()) {
                    String variable = mat.group(1);
                    if (varNames.contains(variable)) {
                        throw new IllegalArgumentException("Syntax Error: variable " + variable + " is duplicated in path spec: " + rawSpec);
                    }
                    assertIsValidVariableLiteral(variable, rawSpec);
                    segmentSignature[i] = 'v';
                    logicalSignature.append("/*");
                    varNames.add(variable);
                    regex.append("/([^/]+)");
                } else if (mat.find(0)) {
                    throw new IllegalArgumentException("Syntax Error: variable " + mat.group() + " must exist as entire path segment: " + rawSpec);
                } else if (segment.indexOf(123) >= 0 || segment.indexOf(125) >= 0) {
                    throw new IllegalArgumentException("Syntax Error: invalid path segment /" + segment + "/ variable declaration incomplete: " + rawSpec);
                } else if (segment.indexOf(42) >= 0) {
                    throw new IllegalArgumentException("Syntax Error: path segment /" + segment + "/ contains a wildcard symbol (not supported by this uri-template implementation): " + rawSpec);
                } else {
                    segmentSignature[i] = 'e';
                    logicalSignature.append('/').append(segment);
                    regex.append('/');
                    for (int j = 0; j < segment.length(); j++) {
                        char c = segment.charAt(j);
                        if (c == '.' || c == '[' || c == ']' || c == '\\') {
                            regex.append('\\');
                        }
                        regex.append(c);
                    }
                }
            }
            if (rawSpec.charAt(rawSpec.length() - 1) == '/') {
                regex.append('/');
                logicalSignature.append('/');
            }
            regex.append('$');
            Pattern pattern = Pattern.compile(regex.toString());
            String[] variables = (String[]) varNames.toArray(new String[varNames.size()]);
            String sig = String.valueOf(segmentSignature);
            if (Pattern.matches("^e*$", sig)) {
                group = PathSpecGroup.EXACT;
            } else if (Pattern.matches("^e*v+", sig)) {
                group = PathSpecGroup.PREFIX_GLOB;
            } else if (Pattern.matches("^v+e+", sig)) {
                group = PathSpecGroup.SUFFIX_GLOB;
            } else {
                group = PathSpecGroup.MIDDLE_GLOB;
            }
            this._declaration = rawSpec;
            this._group = group;
            this._pathDepth = pathDepth;
            this._specLength = rawSpec.length();
            this._pattern = pattern;
            this._variables = variables;
            this._logicalDeclaration = logicalSignature.toString();
            if (LOG.isDebugEnabled()) {
                LOG.debug("Creating UriTemplatePathSpec[{}] (regex: \"{}\", signature: [{}], group: {}, variables: [{}])", this._declaration, regex, sig, this._group, String.join(", ", this._variables));
            }
        }
    }

    private static void assertIsValidVariableLiteral(String variable, String declaration) {
        int len = variable.length();
        int i = 0;
        boolean valid = len > 0;
        while (valid && i < len) {
            int codepoint = variable.codePointAt(i);
            i += Character.charCount(codepoint);
            if (!isValidBasicLiteralCodepoint(codepoint, declaration) && !Character.isSupplementaryCodePoint(codepoint)) {
                if (codepoint == 37) {
                    if (i + 2 > len) {
                        valid = false;
                    } else {
                        int i2 = i + 1;
                        i = i2 + 1;
                        if (isValidBasicLiteralCodepoint((TypeUtil.convertHexDigit(variable.codePointAt(i)) << 4) | TypeUtil.convertHexDigit(variable.codePointAt(i2)), declaration)) {
                        }
                    }
                }
                valid = false;
            }
        }
        if (!valid) {
            throw new IllegalArgumentException("Syntax Error: variable {" + variable + "} an invalid variable name: " + declaration);
        }
    }

    private static boolean isValidBasicLiteralCodepoint(int codepoint, String declaration) {
        if (codepoint >= 97 && codepoint <= 122) {
            return true;
        }
        if (codepoint >= 65 && codepoint <= 90) {
            return true;
        }
        if ((codepoint >= 48 && codepoint <= 57) || VARIABLE_SYMBOLS.indexOf(codepoint) >= 0) {
            return true;
        }
        if (VARIABLE_RESERVED.indexOf(codepoint) < 0) {
            return false;
        }
        LOG.warn("Detected URI Template reserved symbol [{}] in path spec \"{}\"", Character.valueOf((char) codepoint), declaration);
        return false;
    }

    @Override // org.eclipse.jetty.http.pathmap.AbstractPathSpec
    public int compareTo(PathSpec other) {
        if (other instanceof UriTemplatePathSpec) {
            return ((UriTemplatePathSpec) other)._logicalDeclaration.compareTo(this._logicalDeclaration);
        }
        return compareTo(other);
    }

    public Map<String, String> getPathParams(String path) {
        Matcher matcher = getMatcher(path);
        if (!matcher.matches()) {
            return null;
        }
        if (this._group == PathSpecGroup.EXACT) {
            return Collections.emptyMap();
        }
        Map<String, String> ret = new HashMap<>();
        int groupCount = matcher.groupCount();
        for (int i = 1; i <= groupCount; i++) {
            ret.put(this._variables[i - 1], matcher.group(i));
        }
        return ret;
    }

    protected Matcher getMatcher(String path) {
        int idx = path.indexOf(63);
        if (idx >= 0) {
            return this._pattern.matcher(path.substring(0, idx));
        }
        return this._pattern.matcher(path);
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
    public String getPathInfo(String path) {
        if (this._group != PathSpecGroup.PREFIX_GLOB) {
            return null;
        }
        Matcher matcher = getMatcher(path);
        if (!matcher.matches() || matcher.groupCount() < 1) {
            return null;
        }
        String pathInfo = matcher.group(1);
        if ("".equals(pathInfo)) {
            return "/";
        }
        return pathInfo;
    }

    @Override // org.eclipse.jetty.http.pathmap.PathSpec
    public String getPathMatch(String path) {
        Matcher matcher = getMatcher(path);
        if (!matcher.matches()) {
            return null;
        }
        if (this._group == PathSpecGroup.PREFIX_GLOB && matcher.groupCount() >= 1) {
            int idx = matcher.start(1);
            if (idx > 0) {
                if (path.charAt(idx - 1) == '/') {
                    idx--;
                }
                return path.substring(0, idx);
            }
        }
        return path;
    }

    @Override // org.eclipse.jetty.http.pathmap.PathSpec
    public String getDeclaration() {
        return this._declaration;
    }

    @Override // org.eclipse.jetty.http.pathmap.PathSpec
    public String getPrefix() {
        return null;
    }

    @Override // org.eclipse.jetty.http.pathmap.PathSpec
    public String getSuffix() {
        return null;
    }

    public Pattern getPattern() {
        return this._pattern;
    }

    @Override // org.eclipse.jetty.http.pathmap.PathSpec
    public boolean matches(String path) {
        return getMatcher(path).matches();
    }

    @Override // org.eclipse.jetty.http.pathmap.PathSpec
    public MatchedPath matched(String path) {
        Matcher matcher = getMatcher(path);
        if (matcher.matches()) {
            return new UriTemplateMatchedPath(this, path, matcher);
        }
        return null;
    }

    public int getVariableCount() {
        return this._variables.length;
    }

    public String[] getVariables() {
        return this._variables;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/pathmap/UriTemplatePathSpec$UriTemplateMatchedPath.class */
    private static class UriTemplateMatchedPath implements MatchedPath {
        private final UriTemplatePathSpec pathSpec;
        private final String path;
        private final Matcher matcher;

        public UriTemplateMatchedPath(UriTemplatePathSpec uriTemplatePathSpec, String path, Matcher matcher) {
            this.pathSpec = uriTemplatePathSpec;
            this.path = path;
            this.matcher = matcher;
        }

        @Override // org.eclipse.jetty.http.pathmap.MatchedPath
        public String getPathMatch() {
            if (this.pathSpec.getGroup() == PathSpecGroup.PREFIX_GLOB && this.matcher.groupCount() >= 1) {
                int idx = this.matcher.start(1);
                if (idx > 0) {
                    if (this.path.charAt(idx - 1) == '/') {
                        idx--;
                    }
                    return this.path.substring(0, idx);
                }
            }
            return this.path;
        }

        @Override // org.eclipse.jetty.http.pathmap.MatchedPath
        public String getPathInfo() {
            if (this.pathSpec.getGroup() != PathSpecGroup.PREFIX_GLOB || this.matcher.groupCount() < 1) {
                return null;
            }
            String pathInfo = this.matcher.group(1);
            if ("".equals(pathInfo)) {
                return "/";
            }
            return pathInfo;
        }

        public String toString() {
            return getClass().getSimpleName() + "[pathSpec=" + this.pathSpec + ", path=\"" + this.path + "\", matcher=" + this.matcher + ']';
        }
    }
}
