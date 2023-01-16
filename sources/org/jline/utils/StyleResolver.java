package org.jline.utils;

import dev.morphia.mapping.Mapper;
import emu.grasscutter.net.packet.PacketOpcodes;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.pattern.color.ANSIConstants;
import p013io.javalin.http.sse.EmitterKt;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/StyleResolver.class */
public class StyleResolver {
    private static final Logger log = Logger.getLogger(StyleResolver.class.getName());
    private final Function<String, String> source;

    public StyleResolver(Function<String, String> source) {
        this.source = (Function) Objects.requireNonNull(source);
    }

    private static Integer colorRgb(String name) {
        String name2 = name.toLowerCase(Locale.US);
        if (name2.charAt(0) == 'x' || name2.charAt(0) == '#') {
            try {
                return Integer.valueOf(Integer.parseInt(name2.substring(1), 16));
            } catch (NumberFormatException e) {
                log.warning("Invalid hexadecimal color: " + name2);
                return null;
            }
        } else {
            Integer color = color(name2);
            if (!(color == null || color.intValue() == -1)) {
                color = Integer.valueOf(Colors.DEFAULT_COLORS_256[color.intValue()]);
            }
            return color;
        }
    }

    private static Integer color(String name) {
        int flags = 0;
        if (name.equals("default")) {
            return -1;
        }
        if (name.charAt(0) == '!') {
            name = name.substring(1);
            flags = 8;
        } else if (name.startsWith("bright-")) {
            name = name.substring(7);
            flags = 8;
        } else if (name.charAt(0) == '~') {
            String name2 = name.substring(1);
            try {
                return Colors.rgbColor(name2);
            } catch (IllegalArgumentException e) {
                log.warning("Invalid style-color name: " + name2);
                return null;
            }
        }
        char c = 65535;
        switch (name.hashCode()) {
            case -734239628:
                if (name.equals("yellow")) {
                    c = 6;
                    break;
                }
                break;
            case 98:
                if (name.equals("b")) {
                    c = '\t';
                    break;
                }
                break;
            case 99:
                if (name.equals("c")) {
                    c = '\r';
                    break;
                }
                break;
            case 103:
                if (name.equals("g")) {
                    c = 5;
                    break;
                }
                break;
            case 107:
                if (name.equals("k")) {
                    c = 1;
                    break;
                }
                break;
            case 109:
                if (name.equals(ANSIConstants.ESC_END)) {
                    c = 11;
                    break;
                }
                break;
            case 114:
                if (name.equals("r")) {
                    c = 3;
                    break;
                }
                break;
            case 119:
                if (name.equals("w")) {
                    c = 15;
                    break;
                }
                break;
            case 121:
                if (name.equals("y")) {
                    c = 7;
                    break;
                }
                break;
            case 112785:
                if (name.equals("red")) {
                    c = 2;
                    break;
                }
                break;
            case 3027034:
                if (name.equals("blue")) {
                    c = '\b';
                    break;
                }
                break;
            case 3068707:
                if (name.equals("cyan")) {
                    c = '\f';
                    break;
                }
                break;
            case 93818879:
                if (name.equals("black")) {
                    c = 0;
                    break;
                }
                break;
            case 98619139:
                if (name.equals("green")) {
                    c = 4;
                    break;
                }
                break;
            case 113101865:
                if (name.equals("white")) {
                    c = 14;
                    break;
                }
                break;
            case 828922025:
                if (name.equals("magenta")) {
                    c = '\n';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                return Integer.valueOf(flags + 0);
            case 2:
            case 3:
                return Integer.valueOf(flags + 1);
            case 4:
            case 5:
                return Integer.valueOf(flags + 2);
            case 6:
            case 7:
                return Integer.valueOf(flags + 3);
            case '\b':
            case '\t':
                return Integer.valueOf(flags + 4);
            case '\n':
            case 11:
                return Integer.valueOf(flags + 5);
            case '\f':
            case '\r':
                return Integer.valueOf(flags + 6);
            case 14:
            case 15:
                return Integer.valueOf(flags + 7);
            default:
                return null;
        }
    }

    public AttributedStyle resolve(String spec) {
        Objects.requireNonNull(spec);
        if (log.isLoggable(Level.FINEST)) {
            log.finest("Resolve: " + spec);
        }
        if (spec.indexOf(CoreConstants.DEFAULT_VALUE_SEPARATOR) == -1) {
            return apply(AttributedStyle.DEFAULT, spec);
        }
        String[] parts = spec.split(CoreConstants.DEFAULT_VALUE_SEPARATOR);
        return resolve(parts[0].trim(), parts[1].trim());
    }

    public AttributedStyle resolve(String spec, String defaultSpec) {
        Objects.requireNonNull(spec);
        if (log.isLoggable(Level.FINEST)) {
            log.finest(String.format("Resolve: %s; default: %s", spec, defaultSpec));
        }
        AttributedStyle style = apply(AttributedStyle.DEFAULT, spec);
        if (style == AttributedStyle.DEFAULT && defaultSpec != null) {
            style = apply(style, defaultSpec);
        }
        return style;
    }

    private AttributedStyle apply(AttributedStyle style, String spec) {
        if (log.isLoggable(Level.FINEST)) {
            log.finest("Apply: " + spec);
        }
        for (String item : spec.split(",")) {
            String item2 = item.trim();
            if (!item2.isEmpty()) {
                if (item2.startsWith(Mapper.IGNORED_FIELDNAME)) {
                    style = applyReference(style, item2);
                } else if (item2.contains(EmitterKt.COMMENT_PREFIX)) {
                    style = applyColor(style, item2);
                } else if (item2.matches("[0-9]+(;[0-9]+)*")) {
                    style = applyAnsi(style, item2);
                } else {
                    style = applyNamed(style, item2);
                }
            }
        }
        return style;
    }

    private AttributedStyle applyAnsi(AttributedStyle style, String spec) {
        if (log.isLoggable(Level.FINEST)) {
            log.finest("Apply-ansi: " + spec);
        }
        return new AttributedStringBuilder().style(style).ansiAppend(ANSIConstants.ESC_START + spec + ANSIConstants.ESC_END).style();
    }

    private AttributedStyle applyReference(AttributedStyle style, String spec) {
        if (log.isLoggable(Level.FINEST)) {
            log.finest("Apply-reference: " + spec);
        }
        if (spec.length() == 1) {
            log.warning("Invalid style-reference; missing discriminator: " + spec);
        } else {
            String resolvedSpec = this.source.apply(spec.substring(1, spec.length()));
            if (resolvedSpec != null) {
                return apply(style, resolvedSpec);
            }
        }
        return style;
    }

    private AttributedStyle applyNamed(AttributedStyle style, String name) {
        if (log.isLoggable(Level.FINEST)) {
            log.finest("Apply-named: " + name);
        }
        String lowerCase = name.toLowerCase(Locale.US);
        char c = 65535;
        switch (lowerCase.hashCode()) {
            case -1255743117:
                if (lowerCase.equals("inverse-neg")) {
                    c = 7;
                    break;
                }
                break;
            case -1217487446:
                if (lowerCase.equals("hidden")) {
                    c = '\f';
                    break;
                }
                break;
            case -1178781136:
                if (lowerCase.equals("italic")) {
                    c = 3;
                    break;
                }
                break;
            case -1026963764:
                if (lowerCase.equals("underline")) {
                    c = 4;
                    break;
                }
                break;
            case -967429792:
                if (lowerCase.equals("crossed-out")) {
                    c = '\n';
                    break;
                }
                break;
            case 3029637:
                if (lowerCase.equals("bold")) {
                    c = 1;
                    break;
                }
                break;
            case 93826908:
                if (lowerCase.equals("blink")) {
                    c = 5;
                    break;
                }
                break;
            case 97193300:
                if (lowerCase.equals("faint")) {
                    c = 2;
                    break;
                }
                break;
            case 384498191:
                if (lowerCase.equals("crossedout")) {
                    c = 11;
                    break;
                }
                break;
            case 951023759:
                if (lowerCase.equals("conceal")) {
                    c = '\t';
                    break;
                }
                break;
            case 1544803905:
                if (lowerCase.equals("default")) {
                    c = 0;
                    break;
                }
                break;
            case 1899216992:
                if (lowerCase.equals("inverseneg")) {
                    c = '\b';
                    break;
                }
                break;
            case 1959910192:
                if (lowerCase.equals("inverse")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return AttributedStyle.DEFAULT;
            case 1:
                return style.bold();
            case 2:
                return style.faint();
            case 3:
                return style.italic();
            case 4:
                return style.underline();
            case 5:
                return style.blink();
            case 6:
                return style.inverse();
            case 7:
            case '\b':
                return style.inverseNeg();
            case '\t':
                return style.conceal();
            case '\n':
            case 11:
                return style.crossedOut();
            case '\f':
                return style.hidden();
            default:
                log.warning("Unknown style: " + name);
                return style;
        }
    }

    private AttributedStyle applyColor(AttributedStyle style, String spec) {
        if (log.isLoggable(Level.FINEST)) {
            log.finest("Apply-color: " + spec);
        }
        String[] parts = spec.split(EmitterKt.COMMENT_PREFIX, 2);
        String colorMode = parts[0].trim();
        String colorName = parts[1].trim();
        String lowerCase = colorMode.toLowerCase(Locale.US);
        char c = 65535;
        switch (lowerCase.hashCode()) {
            case -1392734395:
                if (lowerCase.equals("bg-rgb")) {
                    c = '\n';
                    break;
                }
                break;
            case -1332194002:
                if (lowerCase.equals("background")) {
                    c = 3;
                    break;
                }
                break;
            case -1278217791:
                if (lowerCase.equals("fg-rgb")) {
                    c = 7;
                    break;
                }
                break;
            case -575521469:
                if (lowerCase.equals("foreground-rgb")) {
                    c = 6;
                    break;
                }
                break;
            case 98:
                if (lowerCase.equals("b")) {
                    c = 5;
                    break;
                }
                break;
            case 102:
                if (lowerCase.equals("f")) {
                    c = 2;
                    break;
                }
                break;
            case 3141:
                if (lowerCase.equals("bg")) {
                    c = 4;
                    break;
                }
                break;
            case PacketOpcodes.PlayerChatNotify:
                if (lowerCase.equals("fg")) {
                    c = 1;
                    break;
                }
                break;
            case 91958498:
                if (lowerCase.equals("b-rgb")) {
                    c = 11;
                    break;
                }
                break;
            case 95652582:
                if (lowerCase.equals("f-rgb")) {
                    c = '\b';
                    break;
                }
                break;
            case 1426340782:
                if (lowerCase.equals("background-rgb")) {
                    c = '\t';
                    break;
                }
                break;
            case 1984457027:
                if (lowerCase.equals("foreground")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
                Integer color = color(colorName);
                if (color == null) {
                    log.warning("Invalid color-name: " + colorName);
                    break;
                } else {
                    return color.intValue() >= 0 ? style.foreground(color.intValue()) : style.foregroundDefault();
                }
            case 3:
            case 4:
            case 5:
                Integer color2 = color(colorName);
                if (color2 == null) {
                    log.warning("Invalid color-name: " + colorName);
                    break;
                } else {
                    return color2.intValue() >= 0 ? style.background(color2.intValue()) : style.backgroundDefault();
                }
            case 6:
            case 7:
            case '\b':
                Integer color3 = colorRgb(colorName);
                if (color3 == null) {
                    log.warning("Invalid color-name: " + colorName);
                    break;
                } else {
                    return color3.intValue() >= 0 ? style.foregroundRgb(color3.intValue()) : style.foregroundDefault();
                }
            case '\t':
            case '\n':
            case 11:
                Integer color4 = colorRgb(colorName);
                if (color4 == null) {
                    log.warning("Invalid color-name: " + colorName);
                    break;
                } else {
                    return color4.intValue() >= 0 ? style.backgroundRgb(color4.intValue()) : style.backgroundDefault();
                }
            default:
                log.warning("Invalid color-mode: " + colorMode);
                break;
        }
        return style;
    }
}
