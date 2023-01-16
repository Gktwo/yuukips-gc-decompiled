package org.eclipse.jetty.http.pathmap;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/pathmap/RegexPathSpec.class */
public class RegexPathSpec extends AbstractPathSpec {
    private static final Logger LOG = Log.getLogger(UriTemplatePathSpec.class);
    private static final Map<Character, String> FORBIDDEN_ESCAPED = new HashMap();
    private final String _declaration;
    private final PathSpecGroup _group;
    private final int _pathDepth;
    private final int _specLength;
    private final Pattern _pattern;

    static {
        FORBIDDEN_ESCAPED.put('s', "any whitespace");
        FORBIDDEN_ESCAPED.put('n', "newline");
        FORBIDDEN_ESCAPED.put('r', "carriage return");
        FORBIDDEN_ESCAPED.put('t', "tab");
        FORBIDDEN_ESCAPED.put('f', "form-feed");
        FORBIDDEN_ESCAPED.put('b', "bell");
        FORBIDDEN_ESCAPED.put('e', "escape");
        FORBIDDEN_ESCAPED.put('c', "control char");
    }

    public RegexPathSpec(String regex) {
        String declaration;
        PathSpecGroup group;
        if (regex.startsWith("regex|")) {
            declaration = regex.substring("regex|".length());
        } else {
            declaration = regex;
        }
        int specLength = declaration.length();
        boolean inTextList = false;
        boolean inQuantifier = false;
        StringBuilder signature = new StringBuilder();
        int pathDepth = 0;
        char last = 0;
        for (int i = 0; i < declaration.length(); i++) {
            char c = declaration.charAt(i);
            switch (c) {
                case '$':
                case '\'':
                case '(':
                case ')':
                case '^':
                    break;
                case '*':
                case '+':
                case '.':
                case '?':
                case '|':
                    signature.append('g');
                    break;
                case '/':
                    if (!inTextList && !inQuantifier) {
                        pathDepth++;
                        break;
                    }
                    break;
                case '[':
                    inTextList = true;
                    break;
                case ']':
                    inTextList = false;
                    signature.append('g');
                    break;
                case '{':
                    inQuantifier = true;
                    break;
                case '}':
                    inQuantifier = false;
                    break;
                default:
                    if (!inTextList && !inQuantifier && Character.isLetterOrDigit(c)) {
                        if (last != '\\') {
                            signature.append('l');
                            break;
                        } else {
                            String forbiddenReason = FORBIDDEN_ESCAPED.get(Character.valueOf(c));
                            if (forbiddenReason != null) {
                                throw new IllegalArgumentException(String.format("%s does not support \\%c (%s) for \"%s\"", getClass().getSimpleName(), Character.valueOf(c), forbiddenReason, declaration));
                            }
                            switch (c) {
                                case 'D':
                                case 'S':
                                case 'W':
                                case 'd':
                                case 'w':
                                    signature.append('g');
                                    continue;
                                default:
                                    signature.append('l');
                                    continue;
                            }
                        }
                    }
                    break;
            }
            last = c;
        }
        Pattern pattern = Pattern.compile(declaration);
        String sig = signature.toString();
        if (Pattern.matches("^l*$", sig)) {
            group = PathSpecGroup.EXACT;
        } else if (Pattern.matches("^l*g+", sig)) {
            group = PathSpecGroup.PREFIX_GLOB;
        } else if (Pattern.matches("^g+l+.*", sig)) {
            group = PathSpecGroup.SUFFIX_GLOB;
        } else {
            group = PathSpecGroup.MIDDLE_GLOB;
        }
        this._declaration = declaration;
        this._group = group;
        this._pathDepth = pathDepth;
        this._specLength = specLength;
        this._pattern = pattern;
        if (LOG.isDebugEnabled()) {
            LOG.debug("Creating RegexPathSpec[{}] (signature: [{}], group: {})", this._declaration, sig, this._group);
        }
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
            return new RegexMatchedPath(this, path, matcher);
        }
        return null;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/pathmap/RegexPathSpec$RegexMatchedPath.class */
    private class RegexMatchedPath implements MatchedPath {
        private final RegexPathSpec pathSpec;
        private final String path;
        private final Matcher matcher;

        public RegexMatchedPath(RegexPathSpec regexPathSpec, String path, Matcher matcher) {
            this.pathSpec = regexPathSpec;
            this.path = path;
            this.matcher = matcher;
        }

        @Override // org.eclipse.jetty.http.pathmap.MatchedPath
        public String getPathMatch() {
            try {
                String p = this.matcher.group("name");
                if (p != null) {
                    return p;
                }
            } catch (IllegalArgumentException e) {
            }
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
            try {
                String p = this.matcher.group("info");
                if (p != null) {
                    return p;
                }
            } catch (IllegalArgumentException e) {
            }
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
