package org.jline.builtins;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jline.utils.AttributedCharSequence;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.StyleResolver;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/jline/builtins/Options.class */
public class Options {
    private static final int GROUP_SHORT_OPT_1 = 1;
    private static final int GROUP_SHORT_OPT_2 = 2;
    private static final int GROUP_LONG_OPT_1 = 3;
    private static final int GROUP_ARG_1 = 4;
    private static final int GROUP_LONG_OPT_2 = 5;
    private static final int GROUP_DEFAULT = 6;
    private final Map<String, Boolean> unmodifiableOptSet;
    private final Map<String, Object> unmodifiableOptArg;
    private static final String UNKNOWN = "unknown";
    private final String[] spec;
    private final String[] gspec;
    private final String defOpts;
    private final String[] defArgs;

    /* renamed from: NL */
    public static final String f3202NL = System.getProperty("line.separator", "\n");
    private static final String regex = "(?x)\\s*(?:-([^-]))?(?:,?\\s*-(\\w))?(?:,?\\s*--(\\w[\\w-]*)(=\\w+)?)?(?:,?\\s*--(\\w[\\w-]*))?.*?(?:\\(default=(.*)\\))?\\s*";
    private static final Pattern parser = Pattern.compile(regex);
    private static final Pattern uname = Pattern.compile("^Usage:\\s+(\\w+)");
    private final Map<String, Boolean> optSet = new HashMap();
    private final Map<String, Object> optArg = new HashMap();
    private final Map<String, String> optName = new HashMap();
    private final Map<String, String> optAlias = new HashMap();
    private final List<Object> xargs = new ArrayList();
    private List<String> args = null;
    private String usageName = UNKNOWN;
    private int usageIndex = 0;
    private String error = null;
    private boolean optionsFirst = false;
    private boolean stopOnBadOption = false;

    public static Options compile(String[] optSpec) {
        return new Options(optSpec, null, null, System::getenv);
    }

    public static Options compile(String[] optSpec, Function<String, String> env) {
        return new Options(optSpec, null, null, env);
    }

    public static Options compile(String optSpec) {
        return compile(optSpec.split("\\n"), System::getenv);
    }

    public static Options compile(String optSpec, Function<String, String> env) {
        return compile(optSpec.split("\\n"), env);
    }

    public static Options compile(String[] optSpec, Options gopt) {
        return new Options(optSpec, null, gopt, System::getenv);
    }

    public static Options compile(String[] optSpec, String[] gspec) {
        return new Options(optSpec, gspec, null, System::getenv);
    }

    public Options setStopOnBadOption(boolean stopOnBadOption) {
        this.stopOnBadOption = stopOnBadOption;
        return this;
    }

    public Options setOptionsFirst(boolean optionsFirst) {
        this.optionsFirst = optionsFirst;
        return this;
    }

    public boolean isSet(String name) {
        if (this.optSet.containsKey(name)) {
            return this.optSet.get(name).booleanValue();
        }
        throw new IllegalArgumentException("option not defined in spec: " + name);
    }

    public Object getObject(String name) {
        if (!this.optArg.containsKey(name)) {
            throw new IllegalArgumentException("option not defined with argument: " + name);
        }
        List<Object> list = getObjectList(name);
        return list.isEmpty() ? "" : list.get(list.size() - 1);
    }

    public List<Object> getObjectList(String name) {
        List<Object> list;
        Object arg = this.optArg.get(name);
        if (arg == null) {
            throw new IllegalArgumentException("option not defined with argument: " + name);
        }
        if (arg instanceof String) {
            list = new ArrayList<>();
            if (!"".equals(arg)) {
                list.add(arg);
            }
        } else {
            list = (List) arg;
        }
        return list;
    }

    public List<String> getList(String name) {
        ArrayList<String> list = new ArrayList<>();
        Iterator<Object> it = getObjectList(name).iterator();
        while (it.hasNext()) {
            try {
                list.add((String) it.next());
            } catch (ClassCastException e) {
                throw new IllegalArgumentException("option not String: " + name);
            }
        }
        return list;
    }

    private void addArg(String name, Object value) {
        List<Object> list;
        Object arg = this.optArg.get(name);
        if (arg instanceof String) {
            list = new ArrayList<>();
            this.optArg.put(name, list);
        } else {
            list = (List) arg;
        }
        list.add(value);
    }

    public String get(String name) {
        try {
            return (String) getObject(name);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("option not String: " + name);
        }
    }

    public int getNumber(String name) {
        String number = get(name);
        if (number == null) {
            return 0;
        }
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("option '" + name + "' not Number: " + number);
        }
    }

    public List<Object> argObjects() {
        return this.xargs;
    }

    public List<String> args() {
        if (this.args == null) {
            this.args = new ArrayList();
            Iterator<Object> it = this.xargs.iterator();
            while (it.hasNext()) {
                Object arg = it.next();
                this.args.add(arg == null ? "null" : arg.toString());
            }
        }
        return this.args;
    }

    public void usage(PrintStream err) {
        err.print(usage());
    }

    public String usage() {
        StringBuilder buf = new StringBuilder();
        int index = 0;
        if (this.error != null) {
            buf.append(this.error);
            buf.append(f3202NL);
            index = this.usageIndex;
        }
        for (int i = index; i < this.spec.length; i++) {
            buf.append(this.spec[i]);
            buf.append(f3202NL);
        }
        return buf.toString();
    }

    public IllegalArgumentException usageError(String s) {
        this.error = this.usageName + ": " + s;
        return new IllegalArgumentException(this.error);
    }

    private Options(String[] spec, String[] gspec, Options opt, Function<String, String> env) {
        this.gspec = gspec;
        if (gspec == null && opt == null) {
            this.spec = spec;
        } else {
            ArrayList<String> list = new ArrayList<>();
            list.addAll(Arrays.asList(spec));
            list.addAll(Arrays.asList(gspec != null ? gspec : opt.gspec));
            this.spec = (String[]) list.toArray(new String[list.size()]);
        }
        Map<String, Boolean> myOptSet = new HashMap<>();
        Map<String, Object> myOptArg = new HashMap<>();
        parseSpec(myOptSet, myOptArg);
        if (opt != null) {
            for (Map.Entry<String, Boolean> e : opt.optSet.entrySet()) {
                if (e.getValue().booleanValue()) {
                    myOptSet.put(e.getKey(), true);
                }
            }
            for (Map.Entry<String, Object> e2 : opt.optArg.entrySet()) {
                if (!e2.getValue().equals("")) {
                    myOptArg.put(e2.getKey(), e2.getValue());
                }
            }
            opt.reset();
        }
        this.unmodifiableOptSet = Collections.unmodifiableMap(myOptSet);
        this.unmodifiableOptArg = Collections.unmodifiableMap(myOptArg);
        this.defOpts = env != null ? env.apply(this.usageName.toUpperCase() + "_OPTS") : null;
        this.defArgs = this.defOpts != null ? this.defOpts.split("\\s+") : new String[0];
    }

    private void parseSpec(Map<String, Boolean> myOptSet, Map<String, Object> myOptArg) {
        int index = 0;
        String[] strArr = this.spec;
        for (String line : strArr) {
            Matcher m = parser.matcher(line);
            if (m.matches()) {
                String opt = m.group(3);
                String name = opt != null ? opt : m.group(1);
                if (name != null) {
                    if (myOptSet.containsKey(name)) {
                        throw new IllegalArgumentException("duplicate option in spec: --" + name);
                    }
                    myOptSet.put(name, false);
                }
                String dflt = m.group(6) != null ? m.group(6) : "";
                if (m.group(4) != null) {
                    myOptArg.put(opt, dflt);
                }
                String opt2 = m.group(5);
                if (opt2 != null) {
                    this.optAlias.put(opt2, opt);
                    myOptSet.put(opt2, false);
                    if (m.group(4) != null) {
                        myOptArg.put(opt2, "");
                    }
                }
                int i = 0;
                while (i < 2) {
                    String sopt = m.group(i == 0 ? 1 : 2);
                    if (sopt != null) {
                        if (this.optName.containsKey(sopt)) {
                            throw new IllegalArgumentException("duplicate option in spec: -" + sopt);
                        }
                        this.optName.put(sopt, name);
                    }
                    i++;
                }
            }
            if (Objects.equals(this.usageName, UNKNOWN)) {
                Matcher u = uname.matcher(line);
                if (u.find()) {
                    this.usageName = u.group(1);
                    this.usageIndex = index;
                }
            }
            index++;
        }
    }

    private void reset() {
        this.optSet.clear();
        this.optSet.putAll(this.unmodifiableOptSet);
        this.optArg.clear();
        this.optArg.putAll(this.unmodifiableOptArg);
        this.xargs.clear();
        this.args = null;
        this.error = null;
    }

    public Options parse(Object[] argv) {
        return parse(argv, false);
    }

    public Options parse(List<?> argv) {
        return parse(argv, false);
    }

    public Options parse(Object[] argv, boolean skipArg0) {
        if (null != argv) {
            return parse(Arrays.asList(argv), skipArg0);
        }
        throw new IllegalArgumentException("argv is null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0064, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jline.builtins.Options parse(java.util.List<?> r6, boolean r7) {
        /*
        // Method dump skipped, instructions count: 1111
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.builtins.Options.parse(java.util.List, boolean):org.jline.builtins.Options");
    }

    public String toString() {
        return "isSet" + this.optSet + "\nArg" + this.optArg + "\nargs" + this.xargs;
    }

    /* loaded from: grasscutter.jar:org/jline/builtins/Options$HelpException.class */
    public static class HelpException extends Exception {
        public HelpException(String message) {
            super(message);
        }

        public static StyleResolver defaultStyle() {
            return Styles.helpStyle();
        }

        public static AttributedString highlight(String msg, StyleResolver resolver) {
            String syntax;
            String comment;
            Matcher tm = Pattern.compile("(^|\\n)(Usage|Summary)(:)").matcher(msg);
            if (!tm.find()) {
                return AttributedString.fromAnsi(msg);
            }
            boolean subcommand = tm.group(2).equals("Summary");
            AttributedStringBuilder asb = new AttributedStringBuilder(msg.length());
            asb.append((AttributedCharSequence) new AttributedStringBuilder().append((CharSequence) msg.substring(0, tm.start(2))).styleMatches(Pattern.compile("(?:^\\s*)([a-z]+[a-zA-Z0-9-]*)\\b"), Collections.singletonList(resolver.resolve(".co"))));
            asb.styled(resolver.resolve(".ti"), tm.group(2)).append((CharSequence) EmitterKt.COMMENT_PREFIX);
            String[] split = msg.substring(tm.end(3)).split("\n");
            for (String line : split) {
                int ind = line.lastIndexOf("  ");
                if (ind > 20) {
                    syntax = line.substring(0, ind);
                    comment = line.substring(ind + 1);
                } else {
                    syntax = line;
                    comment = "";
                }
                asb.append((AttributedCharSequence) _highlightSyntax(syntax, resolver, subcommand));
                asb.append((AttributedCharSequence) _highlightComment(comment, resolver));
                asb.append((CharSequence) "\n");
            }
            return asb.toAttributedString();
        }

        public static AttributedString highlightSyntax(String syntax, StyleResolver resolver, boolean subcommands) {
            return _highlightSyntax(syntax, resolver, subcommands).toAttributedString();
        }

        public static AttributedString highlightSyntax(String syntax, StyleResolver resolver) {
            return _highlightSyntax(syntax, resolver, false).toAttributedString();
        }

        public static AttributedString highlightComment(String comment, StyleResolver resolver) {
            return _highlightComment(comment, resolver).toAttributedString();
        }

        private static AttributedStringBuilder _highlightSyntax(String syntax, StyleResolver resolver, boolean subcommand) {
            char c;
            StringBuilder indent = new StringBuilder();
            char[] charArray = syntax.toCharArray();
            int length = charArray.length;
            int i = 0;
            while (i < length && (c = charArray[i]) == ' ') {
                indent.append(c);
                i++;
            }
            AttributedStringBuilder asyntax = new AttributedStringBuilder().append((CharSequence) syntax.substring(indent.length()));
            asyntax.styleMatches(Pattern.compile("(?:^)([a-z]+[a-zA-Z0-9-]*)\\b"), Collections.singletonList(resolver.resolve(".co")));
            if (!subcommand) {
                asyntax.styleMatches(Pattern.compile("(?:<|\\[|\\s|=)([A-Za-z]+[A-Za-z_-]*)\\b"), Collections.singletonList(resolver.resolve(".ar")));
                asyntax.styleMatches(Pattern.compile("(?:^|\\s|\\[)(-\\$|-\\?|[-]{1,2}[A-Za-z-]+\\b)"), Collections.singletonList(resolver.resolve(".op")));
            }
            return new AttributedStringBuilder().append((CharSequence) indent).append((AttributedCharSequence) asyntax);
        }

        private static AttributedStringBuilder _highlightComment(String comment, StyleResolver resolver) {
            AttributedStringBuilder acomment = new AttributedStringBuilder().append((CharSequence) comment);
            acomment.styleMatches(Pattern.compile("(?:\\s|\\[)(-\\$|-\\?|[-]{1,2}[A-Za-z-]+\\b)"), Collections.singletonList(resolver.resolve(".op")));
            acomment.styleMatches(Pattern.compile("(?:\\s)([a-z]+[-]+[a-z]+|[A-Z_]{2,})(?:\\s)"), Collections.singletonList(resolver.resolve(".ar")));
            return acomment;
        }
    }
}
