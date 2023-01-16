package org.jline.reader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: grasscutter.jar:org/jline/reader/Parser.class */
public interface Parser {
    public static final String REGEX_VARIABLE = "[a-zA-Z_]{1,}[a-zA-Z0-9_-]*";
    public static final String REGEX_COMMAND = "[:]{0,1}[a-zA-Z]{1,}[a-zA-Z0-9_-]*";

    /* loaded from: grasscutter.jar:org/jline/reader/Parser$ParseContext.class */
    public enum ParseContext {
        UNSPECIFIED,
        ACCEPT_LINE,
        SPLIT_LINE,
        COMPLETE,
        SECONDARY_PROMPT
    }

    ParsedLine parse(String str, int i, ParseContext parseContext) throws SyntaxError;

    default ParsedLine parse(String line, int cursor) throws SyntaxError {
        return parse(line, cursor, ParseContext.UNSPECIFIED);
    }

    default boolean isEscapeChar(char ch) {
        return ch == '\\';
    }

    default boolean validCommandName(String name) {
        return name != null && name.matches(REGEX_COMMAND);
    }

    default boolean validVariableName(String name) {
        return name != null && name.matches(REGEX_VARIABLE);
    }

    default String getCommand(String line) {
        String out;
        Matcher matcher = Pattern.compile("^\\s*[a-zA-Z_]{1,}[a-zA-Z0-9_-]*=([:]{0,1}[a-zA-Z]{1,}[a-zA-Z0-9_-]*)(\\s+|$)").matcher(line);
        if (matcher.find()) {
            out = matcher.group(1);
        } else {
            out = line.trim().split("\\s+")[0];
            if (!out.matches(REGEX_COMMAND)) {
                out = "";
            }
        }
        return out;
    }

    default String getVariable(String line) {
        String out = null;
        Matcher matcher = Pattern.compile("^\\s*([a-zA-Z_]{1,}[a-zA-Z0-9_-]*)\\s*=[^=~].*").matcher(line);
        if (matcher.find()) {
            out = matcher.group(1);
        }
        return out;
    }
}
