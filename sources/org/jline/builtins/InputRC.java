package org.jline.builtins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.jline.console.Printer;
import org.jline.keymap.KeyMap;
import org.jline.reader.Binding;
import org.jline.reader.LineReader;
import org.jline.reader.Macro;
import org.jline.reader.Reference;
import org.jline.utils.Log;

/* loaded from: grasscutter.jar:org/jline/builtins/InputRC.class */
public final class InputRC {
    private final LineReader reader;

    public static void configure(LineReader reader, URL url) throws IOException {
        InputStream is = url.openStream();
        try {
            configure(reader, is);
            if (is != null) {
                is.close();
            }
        } catch (Throwable th) {
            if (is != null) {
                try {
                    is.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static void configure(LineReader reader, InputStream is) throws IOException {
        InputStreamReader r = new InputStreamReader(is);
        try {
            configure(reader, r);
            r.close();
        } catch (Throwable th) {
            try {
                r.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void configure(LineReader reader, Reader r) throws IOException {
        BufferedReader br;
        if (r instanceof BufferedReader) {
            br = (BufferedReader) r;
        } else {
            br = new BufferedReader(r);
        }
        reader.getVariables().putIfAbsent(LineReader.EDITING_MODE, LineReader.EMACS);
        reader.setKeyMap(LineReader.MAIN);
        if ("vi".equals(reader.getVariable(LineReader.EDITING_MODE))) {
            reader.getKeyMaps().put(LineReader.MAIN, reader.getKeyMaps().get(LineReader.VIINS));
        } else if (LineReader.EMACS.equals(reader.getVariable(LineReader.EDITING_MODE))) {
            reader.getKeyMaps().put(LineReader.MAIN, reader.getKeyMaps().get(LineReader.EMACS));
        }
        new InputRC(reader).parse(br);
        if ("vi".equals(reader.getVariable(LineReader.EDITING_MODE))) {
            reader.getKeyMaps().put(LineReader.MAIN, reader.getKeyMaps().get(LineReader.VIINS));
        } else if (LineReader.EMACS.equals(reader.getVariable(LineReader.EDITING_MODE))) {
            reader.getKeyMaps().put(LineReader.MAIN, reader.getKeyMaps().get(LineReader.EMACS));
        }
    }

    private InputRC(LineReader reader) {
        this.reader = reader;
    }

    private void parse(BufferedReader br) throws IOException, IllegalArgumentException {
        String keySeq;
        boolean parsing = true;
        List<Boolean> ifsStack = new ArrayList<>();
        while (true) {
            String line = br.readLine();
            if (line != null) {
                try {
                    String line2 = line.trim();
                    if (!(line2.length() == 0 || line2.charAt(0) == '#')) {
                        if (line2.charAt(0) == '$') {
                            int i = 0 + 1;
                            while (i < line2.length() && (line2.charAt(i) == ' ' || line2.charAt(i) == '\t')) {
                                i++;
                            }
                            while (i < line2.length() && line2.charAt(i) != ' ' && line2.charAt(i) != '\t') {
                                i++;
                            }
                            String cmd = line2.substring(i, i);
                            while (i < line2.length() && (line2.charAt(i) == ' ' || line2.charAt(i) == '\t')) {
                                i++;
                            }
                            while (i < line2.length() && line2.charAt(i) != ' ' && line2.charAt(i) != '\t') {
                                i++;
                            }
                            String args = line2.substring(i, i);
                            if ("if".equalsIgnoreCase(cmd)) {
                                ifsStack.add(Boolean.valueOf(parsing));
                                if (parsing) {
                                    if (!args.startsWith("term=")) {
                                        if (args.startsWith("mode=")) {
                                            parsing = args.substring("mode=".length()).equalsIgnoreCase((String) this.reader.getVariable(LineReader.EDITING_MODE));
                                        } else {
                                            parsing = args.equalsIgnoreCase(this.reader.getAppName());
                                        }
                                    }
                                }
                            } else if ("else".equalsIgnoreCase(cmd)) {
                                if (ifsStack.isEmpty()) {
                                    throw new IllegalArgumentException("$else found without matching $if");
                                }
                                boolean invert = true;
                                Iterator<Boolean> it = ifsStack.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    } else if (!it.next().booleanValue()) {
                                        invert = false;
                                        break;
                                    }
                                }
                                if (invert) {
                                    parsing = !parsing;
                                }
                            } else if ("endif".equalsIgnoreCase(cmd)) {
                                if (ifsStack.isEmpty()) {
                                    throw new IllegalArgumentException("endif found without matching $if");
                                }
                                parsing = ifsStack.remove(ifsStack.size() - 1).booleanValue();
                            } else if (Printer.INCLUDE.equalsIgnoreCase(cmd)) {
                            }
                        } else if (parsing) {
                            int i2 = 0 + 1;
                            if (line2.charAt(0) == '\"') {
                                boolean esc = false;
                                while (i2 < line2.length()) {
                                    if (esc) {
                                        esc = false;
                                    } else if (line2.charAt(i2) == '\\') {
                                        esc = true;
                                    } else if (line2.charAt(i2) == '\"') {
                                    }
                                    i2++;
                                }
                                throw new IllegalArgumentException("Missing closing quote on line '" + line2 + "'");
                            }
                            while (i2 < line2.length() && line2.charAt(i2) != ':' && line2.charAt(i2) != ' ' && line2.charAt(i2) != '\t') {
                                i2++;
                            }
                            String keySeq2 = line2.substring(0, i2);
                            boolean equivalency = i2 + 1 < line2.length() && line2.charAt(i2) == ':' && line2.charAt(i2 + 1) == '=';
                            int i3 = i2 + 1;
                            if (equivalency) {
                                i3++;
                            }
                            if (keySeq2.equalsIgnoreCase("set")) {
                                while (i3 < line2.length() && (line2.charAt(i3) == ' ' || line2.charAt(i3) == '\t')) {
                                    i3++;
                                }
                                while (i3 < line2.length() && line2.charAt(i3) != ' ' && line2.charAt(i3) != '\t') {
                                    i3++;
                                }
                                String key = line2.substring(i3, i3);
                                while (i3 < line2.length() && (line2.charAt(i3) == ' ' || line2.charAt(i3) == '\t')) {
                                    i3++;
                                }
                                while (i3 < line2.length() && line2.charAt(i3) != ' ' && line2.charAt(i3) != '\t') {
                                    i3++;
                                }
                                setVar(this.reader, key, line2.substring(i3, i3));
                            } else {
                                while (i3 < line2.length() && (line2.charAt(i3) == ' ' || line2.charAt(i3) == '\t')) {
                                    i3++;
                                }
                                if (i3 < line2.length() && (line2.charAt(i3) == '\'' || line2.charAt(i3) == '\"')) {
                                    i3++;
                                    char delim = line2.charAt(i3);
                                    boolean esc2 = false;
                                    while (i3 < line2.length()) {
                                        if (esc2) {
                                            esc2 = false;
                                        } else if (line2.charAt(i3) == '\\') {
                                            esc2 = true;
                                        } else if (line2.charAt(i3) == delim) {
                                            break;
                                        }
                                        i3++;
                                    }
                                }
                                while (i3 < line2.length() && line2.charAt(i3) != ' ' && line2.charAt(i3) != '\t') {
                                    i3++;
                                }
                                String val = line2.substring(Math.min(i3, line2.length()), Math.min(i3, line2.length()));
                                if (keySeq2.charAt(0) == '\"') {
                                    keySeq = translateQuoted(keySeq2);
                                } else {
                                    char key2 = getKeyFromName(keySeq2.lastIndexOf(45) > 0 ? keySeq2.substring(keySeq2.lastIndexOf(45) + 1) : keySeq2);
                                    String keyName = keySeq2.toLowerCase();
                                    String keySeq3 = "";
                                    if (keyName.contains("meta-") || keyName.contains("m-")) {
                                        keySeq3 = keySeq3 + "\u001b";
                                    }
                                    if (keyName.contains("control-") || keyName.contains("c-") || keyName.contains("ctrl-")) {
                                        key2 = (char) (Character.toUpperCase(key2) & 31);
                                    }
                                    keySeq = keySeq3 + key2;
                                }
                                if (val.length() <= 0 || !(val.charAt(0) == '\'' || val.charAt(0) == '\"')) {
                                    this.reader.getKeys().bind((KeyMap<Binding>) new Reference(val), keySeq);
                                } else {
                                    this.reader.getKeys().bind((KeyMap<Binding>) new Macro(translateQuoted(val)), keySeq);
                                }
                            }
                        }
                    }
                } catch (IllegalArgumentException e) {
                    Log.warn("Unable to parse user configuration: ", e);
                }
            } else {
                return;
            }
        }
    }

    private static String translateQuoted(String keySeq) {
        int k;
        int k2;
        int k3;
        String str = keySeq.substring(1, keySeq.length() - 1);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c == '\\') {
                boolean ctrl = str.regionMatches(i, "\\C-", 0, 3) || str.regionMatches(i, "\\M-\\C-", 0, 6);
                boolean meta = str.regionMatches(i, "\\M-", 0, 3) || str.regionMatches(i, "\\C-\\M-", 0, 6);
                i += (meta ? 3 : 0) + (ctrl ? 3 : 0) + ((meta || ctrl) ? 0 : 1);
                if (i >= str.length()) {
                    return sb.toString();
                }
                char c2 = str.charAt(i);
                if (meta) {
                    sb.append("\u001b");
                }
                if (ctrl) {
                    c2 = c2 == '?' ? 127 : (char) (Character.toUpperCase(c2) & 31);
                }
                if (!meta && !ctrl) {
                    switch (c2) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                            char c3 = 0;
                            int j = 0;
                            while (j < 3 && i < str.length() && (k3 = Character.digit(str.charAt(i), 8)) >= 0) {
                                c3 = (char) ((c3 * '\b') + k3);
                                j++;
                                i++;
                            }
                            c2 = (char) (c3 & 255);
                            break;
                        case '\\':
                            c2 = '\\';
                            break;
                        case 'a':
                            c2 = 7;
                            break;
                        case 'b':
                            c2 = '\b';
                            break;
                        case 'd':
                            c2 = 127;
                            break;
                        case 'e':
                            c2 = 27;
                            break;
                        case 'f':
                            c2 = '\f';
                            break;
                        case 'n':
                            c2 = '\n';
                            break;
                        case 'r':
                            c2 = '\r';
                            break;
                        case 't':
                            c2 = '\t';
                            break;
                        case 'u':
                            i++;
                            c2 = 0;
                            int j2 = 0;
                            while (j2 < 4 && i < str.length() && (k = Character.digit(str.charAt(i), 16)) >= 0) {
                                c2 = (char) ((c2 * 16) + k);
                                j2++;
                                i++;
                            }
                            break;
                        case 'v':
                            c2 = 11;
                            break;
                        case 'x':
                            i++;
                            char c4 = 0;
                            int j3 = 0;
                            while (j3 < 2 && i < str.length() && (k2 = Character.digit(str.charAt(i), 16)) >= 0) {
                                c4 = (char) ((c4 * 16) + k2);
                                j3++;
                                i++;
                            }
                            c2 = (char) (c4 & 255);
                            break;
                    }
                }
                sb.append(c2);
            } else {
                sb.append(c);
            }
            i++;
        }
        return sb.toString();
    }

    private static char getKeyFromName(String name) {
        if ("DEL".equalsIgnoreCase(name) || "Rubout".equalsIgnoreCase(name)) {
            return 127;
        }
        if ("ESC".equalsIgnoreCase(name) || "Escape".equalsIgnoreCase(name)) {
            return 27;
        }
        if ("LFD".equalsIgnoreCase(name) || "NewLine".equalsIgnoreCase(name)) {
            return '\n';
        }
        if ("RET".equalsIgnoreCase(name) || "Return".equalsIgnoreCase(name)) {
            return '\r';
        }
        if ("SPC".equalsIgnoreCase(name) || "Space".equalsIgnoreCase(name)) {
            return ' ';
        }
        if ("Tab".equalsIgnoreCase(name)) {
            return '\t';
        }
        return name.charAt(0);
    }

    private static void setVar(LineReader reader, String key, String val) {
        if (LineReader.KEYMAP.equalsIgnoreCase(key)) {
            reader.setKeyMap(val);
            return;
        }
        LineReader.Option[] values = LineReader.Option.values();
        for (LineReader.Option option : values) {
            if (option.name().toLowerCase(Locale.ENGLISH).replace('_', '-').equals(val)) {
                if ("on".equalsIgnoreCase(val)) {
                    reader.setOpt(option);
                    return;
                } else if ("off".equalsIgnoreCase(val)) {
                    reader.unsetOpt(option);
                    return;
                } else {
                    return;
                }
            }
        }
        reader.setVariable(key, val);
    }
}
