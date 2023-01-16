package org.jline.builtins;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.jline.utils.StyleResolver;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/jline/builtins/Styles.class */
public class Styles {
    protected static final List<String> ANSI_STYLES = Arrays.asList("blink", "bold", "conceal", "crossed-out", "crossedout", "faint", "hidden", "inverse", "inverse-neg", "inverseneg", "italic", "underline");
    private static final String DEFAULT_LS_COLORS = "di=1;91:ex=1;92:ln=1;96:fi=";
    private static final String DEFAULT_HELP_COLORS = "ti=1;34:co=1:ar=3:op=33";
    private static final String DEFAULT_PRNT_COLORS = "th=1;34:rn=1;34:rs=,~grey15:mk=1;34:em=31:vs=32";
    private static final String LS_COLORS = "LS_COLORS";
    private static final String HELP_COLORS = "HELP_COLORS";
    private static final String PRNT_COLORS = "PRNT_COLORS";
    private static final String KEY = "([a-z]{2}|\\*\\.[a-zA-Z0-9]+)";
    private static final String VALUE = "([!~#]?[a-zA-Z0-9]+[a-z0-9-;]*)?";
    private static final String VALUES = "([!~#]?[a-zA-Z0-9]+[a-z0-9-;]*)?(,([!~#]?[a-zA-Z0-9]+[a-z0-9-;]*)?)*";
    private static final String STYLE_PATTERN = "([a-z]{2}|\\*\\.[a-zA-Z0-9]+)=([!~#]?[a-zA-Z0-9]+[a-z0-9-;]*)?(,([!~#]?[a-zA-Z0-9]+[a-z0-9-;]*)?)*(:([a-z]{2}|\\*\\.[a-zA-Z0-9]+)=([!~#]?[a-zA-Z0-9]+[a-z0-9-;]*)?(,([!~#]?[a-zA-Z0-9]+[a-z0-9-;]*)?)*)*(:|)";

    public static StyleResolver lsStyle() {
        return style(LS_COLORS, DEFAULT_LS_COLORS);
    }

    public static StyleResolver helpStyle() {
        return style(HELP_COLORS, DEFAULT_HELP_COLORS);
    }

    public static StyleResolver prntStyle() {
        return style(PRNT_COLORS, DEFAULT_PRNT_COLORS);
    }

    public static boolean isStylePattern(String style) {
        return style.matches(STYLE_PATTERN);
    }

    private static StyleResolver style(String name, String defStyle) {
        String style = consoleOption(name);
        if (style == null) {
            style = defStyle;
        }
        return style(style);
    }

    private static String consoleOption(String name) {
        String out = null;
        try {
            ConsoleOptionGetter cog = (ConsoleOptionGetter) Class.forName("org.jline.console.SystemRegistry").getDeclaredMethod(BeanUtil.PREFIX_GETTER_GET, new Class[0]).invoke(null, new Object[0]);
            if (cog != null) {
                out = (String) cog.consoleOption(name);
                if (out != null) {
                    if (!out.matches(STYLE_PATTERN)) {
                        out = null;
                    }
                }
            }
        } catch (Exception e) {
        }
        if (out == null) {
            out = System.getenv(name);
            if (out != null && !out.matches(STYLE_PATTERN)) {
                out = null;
            }
        }
        return out;
    }

    public static StyleResolver style(String style) {
        StyleCompiler styleCompiler = new StyleCompiler((Map) Arrays.stream(style.split(EmitterKt.COMMENT_PREFIX)).collect(Collectors.toMap(s -> {
            return s.substring(0, s.indexOf(61));
        }, s -> {
            return s.substring(s.indexOf(61) + 1);
        })));
        return new StyleResolver(this::getStyle);
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/jline/builtins/Styles$StyleCompiler.class */
    public static class StyleCompiler {
        private static final String ANSI_VALUE = "[0-9]*(;[0-9]+){0,2}";
        private static final String COLORS_24BIT = "[#x][0-9a-fA-F]{6}";
        private static final List<String> COLORS_8 = Arrays.asList("white", "black", "red", "blue", "green", "yellow", "magenta", "cyan");
        private static final Map<String, Integer> COLORS_NANO = new HashMap();
        private final Map<String, String> colors;
        private final boolean nanoStyle;

        static {
            COLORS_NANO.put("pink", 204);
            COLORS_NANO.put("purple", 163);
            COLORS_NANO.put("mauve", 134);
            COLORS_NANO.put("lagoon", 38);
            COLORS_NANO.put("mint", 48);
            COLORS_NANO.put("lime", 148);
            COLORS_NANO.put("peach", 215);
            COLORS_NANO.put("orange", Integer.valueOf((int) PacketOpcodes.PlatformStartRouteNotify));
            COLORS_NANO.put("latte", 137);
        }

        public StyleCompiler(Map<String, String> colors) {
            this(colors, false);
        }

        public StyleCompiler(Map<String, String> colors, boolean nanoStyle) {
            this.colors = colors;
            this.nanoStyle = nanoStyle;
        }

        public String getStyle(String reference) {
            if (!this.colors.containsKey(reference)) {
                return null;
            }
            String rawStyle = this.colors.get(reference);
            if (!this.nanoStyle && rawStyle.matches(ANSI_VALUE)) {
                return rawStyle;
            }
            StringBuilder out = new StringBuilder();
            boolean first = true;
            boolean fg = true;
            String[] split = rawStyle.split(",");
            for (String s : split) {
                if (s.trim().isEmpty()) {
                    fg = false;
                } else {
                    if (!first) {
                        out.append(",");
                    }
                    if (Styles.ANSI_STYLES.contains(s)) {
                        out.append(s);
                    } else if (COLORS_8.contains(s) || COLORS_NANO.containsKey(s) || s.startsWith("light") || s.startsWith("bright") || s.startsWith("~") || s.startsWith("!") || s.matches("\\d+") || s.matches(COLORS_24BIT) || s.equals("normal") || s.equals("default")) {
                        if (s.matches(COLORS_24BIT)) {
                            if (fg) {
                                out.append("fg-rgb:");
                            } else {
                                out.append("bg-rgb:");
                            }
                            out.append(s);
                        } else if (s.matches("\\d+") || COLORS_NANO.containsKey(s)) {
                            if (fg) {
                                out.append("38;5;");
                            } else {
                                out.append("48;5;");
                            }
                            out.append(s.matches("\\d+") ? s : COLORS_NANO.get(s).toString());
                        } else {
                            if (fg) {
                                out.append("fg:");
                            } else {
                                out.append("bg:");
                            }
                            if (COLORS_8.contains(s) || s.startsWith("~") || s.startsWith("!") || s.startsWith("bright-")) {
                                out.append(s);
                            } else if (s.startsWith("light")) {
                                out.append("!").append(s.substring(5));
                            } else if (s.startsWith("bright")) {
                                out.append("!").append(s.substring(6));
                            } else {
                                out.append("default");
                            }
                        }
                        fg = false;
                    }
                    first = false;
                }
            }
            return out.toString();
        }
    }
}
