package org.jline.style;

import java.util.function.Function;

/* loaded from: grasscutter.jar:org/jline/style/InterpolationHelper.class */
public final class InterpolationHelper {
    private static final char ESCAPE_CHAR = '\\';
    private static final String DELIM_START = "@{";
    private static final String DELIM_STOP = "}";
    private static final String MARKER = "@__";

    private InterpolationHelper() {
    }

    public static String substVars(String val, Function<String, String> callback, boolean defaultsToEmptyString) throws IllegalArgumentException {
        return unescape(doSubstVars(val, callback, defaultsToEmptyString));
    }

    private static String doSubstVars(String val, Function<String, String> callback, boolean defaultsToEmptyString) throws IllegalArgumentException {
        int startDelim;
        int idx;
        int stopDelim = -1;
        do {
            stopDelim = val.indexOf(DELIM_STOP, stopDelim + 1);
            while (stopDelim > 0 && val.charAt(stopDelim - 1) == '\\') {
                stopDelim = val.indexOf(DELIM_STOP, stopDelim + 1);
            }
            startDelim = val.indexOf(DELIM_START);
            while (stopDelim >= 0 && (idx = val.indexOf(DELIM_START, startDelim + DELIM_START.length())) >= 0 && idx <= stopDelim) {
                if (idx < stopDelim) {
                    startDelim = idx;
                }
            }
            if (startDelim < 0 || stopDelim < 0) {
                break;
            }
        } while (stopDelim < startDelim + DELIM_START.length());
        if (startDelim < 0 || stopDelim < 0) {
            return val;
        }
        String variable = val.substring(startDelim + DELIM_START.length(), stopDelim);
        String substValue = null;
        if (variable.length() > 0 && callback != null) {
            substValue = callback.apply(variable);
        }
        if (substValue == null) {
            if (defaultsToEmptyString) {
                substValue = "";
            } else {
                substValue = "@__{" + variable + DELIM_STOP;
            }
        }
        return doSubstVars(val.substring(0, startDelim) + substValue + val.substring(stopDelim + DELIM_STOP.length(), val.length()), callback, defaultsToEmptyString);
    }

    private static String unescape(String val) {
        String val2 = val.replaceAll(MARKER, "@");
        int escape = val2.indexOf(92);
        while (escape >= 0 && escape < val2.length() - 1) {
            char c = val2.charAt(escape + 1);
            if (c == '{' || c == '}' || c == '\\') {
                val2 = val2.substring(0, escape) + val2.substring(escape + 1);
            }
            escape = val2.indexOf(92, escape + 1);
        }
        return val2;
    }
}
