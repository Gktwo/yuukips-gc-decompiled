package nonapi.p019io.github.classgraph.types;

/* renamed from: nonapi.io.github.classgraph.types.TypeUtils */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/types/TypeUtils.class */
public final class TypeUtils {

    /* renamed from: nonapi.io.github.classgraph.types.TypeUtils$ModifierType */
    /* loaded from: grasscutter.jar:nonapi/io/github/classgraph/types/TypeUtils$ModifierType.class */
    public enum ModifierType {
        CLASS,
        METHOD,
        FIELD
    }

    private TypeUtils() {
    }

    public static boolean getIdentifierToken(Parser parser, char separator, char separatorReplace) {
        boolean consumedChar = false;
        while (parser.hasMore()) {
            char c = parser.peek();
            if (c != separator) {
                if (c == ';' || c == '[' || c == '<' || c == '>' || c == ':' || c == '/' || c == '.') {
                    break;
                }
                parser.appendToToken(c);
                parser.next();
                consumedChar = true;
            } else {
                parser.appendToToken(separatorReplace);
                parser.next();
                consumedChar = true;
            }
        }
        return consumedChar;
    }

    public static boolean getIdentifierToken(Parser parser) throws ParseException {
        return getIdentifierToken(parser, 0, 0);
    }

    private static void appendModifierKeyword(StringBuilder buf, String modifierKeyword) {
        if (buf.length() > 0 && buf.charAt(buf.length() - 1) != ' ') {
            buf.append(' ');
        }
        buf.append(modifierKeyword);
    }

    public static void modifiersToString(int modifiers, ModifierType modifierType, boolean isDefault, StringBuilder buf) {
        if ((modifiers & 1) != 0) {
            appendModifierKeyword(buf, "public");
        } else if ((modifiers & 2) != 0) {
            appendModifierKeyword(buf, "private");
        } else if ((modifiers & 4) != 0) {
            appendModifierKeyword(buf, "protected");
        }
        if (!(modifierType == ModifierType.FIELD || (modifiers & 1024) == 0)) {
            appendModifierKeyword(buf, "abstract");
        }
        if ((modifiers & 8) != 0) {
            appendModifierKeyword(buf, "static");
        }
        if (modifierType == ModifierType.FIELD) {
            if ((modifiers & 64) != 0) {
                appendModifierKeyword(buf, "volatile");
            }
            if ((modifiers & 128) != 0) {
                appendModifierKeyword(buf, "transient");
            }
        }
        if ((modifiers & 16) != 0) {
            appendModifierKeyword(buf, "final");
        }
        if (modifierType == ModifierType.METHOD) {
            if ((modifiers & 32) != 0) {
                appendModifierKeyword(buf, "synchronized");
            }
            if (isDefault) {
                appendModifierKeyword(buf, "default");
            }
        }
        if ((modifiers & 4096) != 0) {
            appendModifierKeyword(buf, "synthetic");
        }
        if (!(modifierType == ModifierType.FIELD || (modifiers & 64) == 0)) {
            appendModifierKeyword(buf, "bridge");
        }
        if (modifierType == ModifierType.METHOD && (modifiers & 256) != 0) {
            appendModifierKeyword(buf, "native");
        }
        if (modifierType != ModifierType.FIELD && (modifiers & 2048) != 0) {
            appendModifierKeyword(buf, "strictfp");
        }
    }
}
