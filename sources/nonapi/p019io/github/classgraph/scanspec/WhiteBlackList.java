package nonapi.p019io.github.classgraph.scanspec;

import dev.morphia.mapping.Mapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import nonapi.p019io.github.classgraph.utils.CollectionUtils;
import nonapi.p019io.github.classgraph.utils.FastPathResolver;
import nonapi.p019io.github.classgraph.utils.FileUtils;
import nonapi.p019io.github.classgraph.utils.JarUtils;

/* renamed from: nonapi.io.github.classgraph.scanspec.WhiteBlackList */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/scanspec/WhiteBlackList.class */
public abstract class WhiteBlackList {
    protected Set<String> whitelist;
    protected Set<String> blacklist;
    protected Set<String> whitelistPrefixesSet;
    protected List<String> whitelistPrefixes;
    protected List<String> blacklistPrefixes;
    protected Set<String> whitelistGlobs;
    protected Set<String> blacklistGlobs;
    protected transient List<Pattern> whitelistPatterns;
    protected transient List<Pattern> blacklistPatterns;
    protected char separatorChar;

    public abstract void addToWhitelist(String str);

    public abstract void addToBlacklist(String str);

    public abstract boolean isWhitelistedAndNotBlacklisted(String str);

    public abstract boolean isWhitelisted(String str);

    public abstract boolean whitelistHasPrefix(String str);

    public abstract boolean isBlacklisted(String str);

    public WhiteBlackList() {
    }

    public WhiteBlackList(char separatorChar) {
        this.separatorChar = separatorChar;
    }

    /* renamed from: nonapi.io.github.classgraph.scanspec.WhiteBlackList$WhiteBlackListPrefix */
    /* loaded from: grasscutter.jar:nonapi/io/github/classgraph/scanspec/WhiteBlackList$WhiteBlackListPrefix.class */
    public static class WhiteBlackListPrefix extends WhiteBlackList {
        public WhiteBlackListPrefix() {
        }

        public WhiteBlackListPrefix(char separatorChar) {
            super(separatorChar);
        }

        @Override // nonapi.p019io.github.classgraph.scanspec.WhiteBlackList
        public void addToWhitelist(String str) {
            if (str.contains("*")) {
                throw new IllegalArgumentException("Cannot use a glob wildcard here: " + str);
            }
            if (this.whitelistPrefixesSet == null) {
                this.whitelistPrefixesSet = new HashSet();
            }
            this.whitelistPrefixesSet.add(str);
        }

        @Override // nonapi.p019io.github.classgraph.scanspec.WhiteBlackList
        public void addToBlacklist(String str) {
            if (str.contains("*")) {
                throw new IllegalArgumentException("Cannot use a glob wildcard here: " + str);
            }
            if (this.blacklistPrefixes == null) {
                this.blacklistPrefixes = new ArrayList();
            }
            this.blacklistPrefixes.add(str);
        }

        @Override // nonapi.p019io.github.classgraph.scanspec.WhiteBlackList
        public boolean isWhitelistedAndNotBlacklisted(String str) {
            boolean isWhitelisted = this.whitelistPrefixes == null;
            if (!isWhitelisted) {
                Iterator it = this.whitelistPrefixes.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (str.startsWith((String) it.next())) {
                            isWhitelisted = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (!isWhitelisted) {
                return false;
            }
            if (this.blacklistPrefixes == null) {
                return true;
            }
            for (String prefix : this.blacklistPrefixes) {
                if (str.startsWith(prefix)) {
                    return false;
                }
            }
            return true;
        }

        @Override // nonapi.p019io.github.classgraph.scanspec.WhiteBlackList
        public boolean isWhitelisted(String str) {
            boolean isWhitelisted = this.whitelistPrefixes == null;
            if (!isWhitelisted) {
                Iterator it = this.whitelistPrefixes.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (str.startsWith((String) it.next())) {
                            isWhitelisted = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            return isWhitelisted;
        }

        @Override // nonapi.p019io.github.classgraph.scanspec.WhiteBlackList
        public boolean whitelistHasPrefix(String str) {
            throw new IllegalArgumentException("Can only find prefixes of whole strings");
        }

        @Override // nonapi.p019io.github.classgraph.scanspec.WhiteBlackList
        public boolean isBlacklisted(String str) {
            if (this.blacklistPrefixes == null) {
                return false;
            }
            for (String prefix : this.blacklistPrefixes) {
                if (str.startsWith(prefix)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: nonapi.io.github.classgraph.scanspec.WhiteBlackList$WhiteBlackListWholeString */
    /* loaded from: grasscutter.jar:nonapi/io/github/classgraph/scanspec/WhiteBlackList$WhiteBlackListWholeString.class */
    public static class WhiteBlackListWholeString extends WhiteBlackList {
        public WhiteBlackListWholeString() {
        }

        public WhiteBlackListWholeString(char separatorChar) {
            super(separatorChar);
        }

        @Override // nonapi.p019io.github.classgraph.scanspec.WhiteBlackList
        public void addToWhitelist(String str) {
            if (str.contains("*")) {
                if (this.whitelistGlobs == null) {
                    this.whitelistGlobs = new HashSet();
                    this.whitelistPatterns = new ArrayList();
                }
                this.whitelistGlobs.add(str);
                this.whitelistPatterns.add(globToPattern(str));
            } else {
                if (this.whitelist == null) {
                    this.whitelist = new HashSet();
                }
                this.whitelist.add(str);
            }
            if (this.whitelistPrefixesSet == null) {
                this.whitelistPrefixesSet = new HashSet();
                this.whitelistPrefixesSet.add("");
                this.whitelistPrefixesSet.add("/");
            }
            String separator = Character.toString(this.separatorChar);
            String prefix = str;
            if (prefix.contains("*")) {
                String prefix2 = prefix.substring(0, prefix.indexOf(42));
                if (prefix2.lastIndexOf(this.separatorChar) < 0) {
                    prefix = "";
                } else {
                    prefix = prefix2.substring(0, prefix2.lastIndexOf(this.separatorChar));
                }
            }
            while (prefix.endsWith(separator)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            while (!prefix.isEmpty()) {
                this.whitelistPrefixesSet.add(prefix + this.separatorChar);
                prefix = FileUtils.getParentDirPath(prefix, this.separatorChar);
            }
        }

        @Override // nonapi.p019io.github.classgraph.scanspec.WhiteBlackList
        public void addToBlacklist(String str) {
            if (str.contains("*")) {
                if (this.blacklistGlobs == null) {
                    this.blacklistGlobs = new HashSet();
                    this.blacklistPatterns = new ArrayList();
                }
                this.blacklistGlobs.add(str);
                this.blacklistPatterns.add(globToPattern(str));
                return;
            }
            if (this.blacklist == null) {
                this.blacklist = new HashSet();
            }
            this.blacklist.add(str);
        }

        @Override // nonapi.p019io.github.classgraph.scanspec.WhiteBlackList
        public boolean isWhitelistedAndNotBlacklisted(String str) {
            return isWhitelisted(str) && !isBlacklisted(str);
        }

        @Override // nonapi.p019io.github.classgraph.scanspec.WhiteBlackList
        public boolean isWhitelisted(String str) {
            return (this.whitelist == null && this.whitelistPatterns == null) || (this.whitelist != null && this.whitelist.contains(str)) || WhiteBlackList.matchesPatternList(str, this.whitelistPatterns);
        }

        @Override // nonapi.p019io.github.classgraph.scanspec.WhiteBlackList
        public boolean whitelistHasPrefix(String str) {
            if (this.whitelistPrefixesSet == null) {
                return false;
            }
            return this.whitelistPrefixesSet.contains(str);
        }

        @Override // nonapi.p019io.github.classgraph.scanspec.WhiteBlackList
        public boolean isBlacklisted(String str) {
            return (this.blacklist != null && this.blacklist.contains(str)) || WhiteBlackList.matchesPatternList(str, this.blacklistPatterns);
        }
    }

    /* renamed from: nonapi.io.github.classgraph.scanspec.WhiteBlackList$WhiteBlackListLeafname */
    /* loaded from: grasscutter.jar:nonapi/io/github/classgraph/scanspec/WhiteBlackList$WhiteBlackListLeafname.class */
    public static class WhiteBlackListLeafname extends WhiteBlackListWholeString {
        public WhiteBlackListLeafname() {
        }

        public WhiteBlackListLeafname(char separatorChar) {
            super(separatorChar);
        }

        @Override // nonapi.p019io.github.classgraph.scanspec.WhiteBlackList.WhiteBlackListWholeString, nonapi.p019io.github.classgraph.scanspec.WhiteBlackList
        public void addToWhitelist(String str) {
            addToWhitelist(JarUtils.leafName(str));
        }

        @Override // nonapi.p019io.github.classgraph.scanspec.WhiteBlackList.WhiteBlackListWholeString, nonapi.p019io.github.classgraph.scanspec.WhiteBlackList
        public void addToBlacklist(String str) {
            addToBlacklist(JarUtils.leafName(str));
        }

        @Override // nonapi.p019io.github.classgraph.scanspec.WhiteBlackList.WhiteBlackListWholeString, nonapi.p019io.github.classgraph.scanspec.WhiteBlackList
        public boolean isWhitelistedAndNotBlacklisted(String str) {
            return isWhitelistedAndNotBlacklisted(JarUtils.leafName(str));
        }

        @Override // nonapi.p019io.github.classgraph.scanspec.WhiteBlackList.WhiteBlackListWholeString, nonapi.p019io.github.classgraph.scanspec.WhiteBlackList
        public boolean isWhitelisted(String str) {
            return isWhitelisted(JarUtils.leafName(str));
        }

        @Override // nonapi.p019io.github.classgraph.scanspec.WhiteBlackList.WhiteBlackListWholeString, nonapi.p019io.github.classgraph.scanspec.WhiteBlackList
        public boolean whitelistHasPrefix(String str) {
            throw new IllegalArgumentException("Can only find prefixes of whole strings");
        }

        @Override // nonapi.p019io.github.classgraph.scanspec.WhiteBlackList.WhiteBlackListWholeString, nonapi.p019io.github.classgraph.scanspec.WhiteBlackList
        public boolean isBlacklisted(String str) {
            return isBlacklisted(JarUtils.leafName(str));
        }
    }

    public static String normalizePath(String path) {
        String pathResolved = FastPathResolver.resolve(path);
        while (pathResolved.startsWith("/")) {
            pathResolved = pathResolved.substring(1);
        }
        return pathResolved;
    }

    public static String normalizePackageOrClassName(String packageOrClassName) {
        return normalizePath(packageOrClassName.replace('.', '/')).replace('/', '.');
    }

    public static String pathToPackageName(String path) {
        return path.replace('/', '.');
    }

    public static String packageNameToPath(String packageName) {
        return packageName.replace('.', '/');
    }

    public static String classNameToClassfilePath(String className) {
        return JarUtils.classNameToClassfilePath(className);
    }

    public static Pattern globToPattern(String glob) {
        return Pattern.compile("^" + glob.replace(Mapper.IGNORED_FIELDNAME, "\\.").replace("*", ".*") + "$");
    }

    /* access modifiers changed from: private */
    public static boolean matchesPatternList(String str, List<Pattern> patterns) {
        if (patterns == null) {
            return false;
        }
        for (Pattern pattern : patterns) {
            if (pattern.matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    public boolean whitelistIsEmpty() {
        return this.whitelist == null && this.whitelistPrefixes == null && this.whitelistGlobs == null;
    }

    public boolean blacklistIsEmpty() {
        return this.blacklist == null && this.blacklistPrefixes == null && this.blacklistGlobs == null;
    }

    public boolean whitelistAndBlacklistAreEmpty() {
        return whitelistIsEmpty() && blacklistIsEmpty();
    }

    public boolean isSpecificallyWhitelistedAndNotBlacklisted(String str) {
        return !whitelistIsEmpty() && isWhitelistedAndNotBlacklisted(str);
    }

    public boolean isSpecificallyWhitelisted(String str) {
        return !whitelistIsEmpty() && isWhitelisted(str);
    }

    /* access modifiers changed from: package-private */
    public void sortPrefixes() {
        if (this.whitelistPrefixesSet != null) {
            this.whitelistPrefixes = new ArrayList(this.whitelistPrefixesSet);
        }
        if (this.whitelistPrefixes != null) {
            CollectionUtils.sortIfNotEmpty(this.whitelistPrefixes);
        }
        if (this.blacklistPrefixes != null) {
            CollectionUtils.sortIfNotEmpty(this.blacklistPrefixes);
        }
    }

    private static void quoteList(Collection<String> coll, StringBuilder buf) {
        buf.append('[');
        boolean first = true;
        for (String item : coll) {
            if (first) {
                first = false;
            } else {
                buf.append(", ");
            }
            buf.append('\"');
            for (int i = 0; i < item.length(); i++) {
                char c = item.charAt(i);
                if (c == '\"') {
                    buf.append("\\\"");
                } else {
                    buf.append(c);
                }
            }
            buf.append('\"');
        }
        buf.append(']');
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        if (this.whitelist != null) {
            buf.append("whitelist: ");
            quoteList(this.whitelist, buf);
        }
        if (this.whitelistPrefixes != null) {
            if (buf.length() > 0) {
                buf.append("; ");
            }
            buf.append("whitelistPrefixes: ");
            quoteList(this.whitelistPrefixes, buf);
        }
        if (this.whitelistGlobs != null) {
            if (buf.length() > 0) {
                buf.append("; ");
            }
            buf.append("whitelistGlobs: ");
            quoteList(this.whitelistGlobs, buf);
        }
        if (this.blacklist != null) {
            if (buf.length() > 0) {
                buf.append("; ");
            }
            buf.append("blacklist: ");
            quoteList(this.blacklist, buf);
        }
        if (this.blacklistPrefixes != null) {
            if (buf.length() > 0) {
                buf.append("; ");
            }
            buf.append("blacklistPrefixes: ");
            quoteList(this.blacklistPrefixes, buf);
        }
        if (this.blacklistGlobs != null) {
            if (buf.length() > 0) {
                buf.append("; ");
            }
            buf.append("blacklistGlobs: ");
            quoteList(this.blacklistGlobs, buf);
        }
        return buf.toString();
    }
}
