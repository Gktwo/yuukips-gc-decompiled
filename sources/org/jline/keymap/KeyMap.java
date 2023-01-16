package org.jline.keymap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import org.jline.terminal.Terminal;
import org.jline.utils.Curses;
import org.jline.utils.InfoCmp;

/* loaded from: grasscutter.jar:org/jline/keymap/KeyMap.class */
public class KeyMap<T> {
    public static final int KEYMAP_LENGTH = 128;
    public static final long DEFAULT_AMBIGUOUS_TIMEOUT = 1000;
    private T unicode;
    private T nomatch;
    public static final Comparator<String> KEYSEQ_COMPARATOR = s1, s2 -> {
        int len1 = s1.length();
        int len2 = s2.length();
        int lim = Math.min(len1, len2);
        for (int k = 0; k < lim; k++) {
            char c1 = s1.charAt(k);
            char c2 = s2.charAt(k);
            if (c1 != c2) {
                int l = len1 - len2;
                return l != 0 ? l : c1 - c2;
            }
        }
        return len1 - len2;
    };
    private Object[] mapping = new Object[128];
    private T anotherKey = null;
    private long ambiguousTimeout = 1000;

    public static String display(String key) {
        StringBuilder sb = new StringBuilder();
        sb.append("\"");
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c < ' ') {
                sb.append('^');
                sb.append((char) ((c + 'A') - 1));
            } else if (c == 127) {
                sb.append("^?");
            } else if (c == '^' || c == '\\') {
                sb.append('\\').append(c);
            } else if (c >= 128) {
                sb.append(String.format("\\u%04x", Integer.valueOf(c)));
            } else {
                sb.append(c);
            }
        }
        sb.append("\"");
        return sb.toString();
    }

    public static String translate(String str) {
        int k;
        int k2;
        int k3;
        char c;
        if (!str.isEmpty() && (((c = str.charAt(0)) == '\'' || c == '\"') && str.charAt(str.length() - 1) == c)) {
            str = str.substring(1, str.length() - 1);
        }
        StringBuilder keySeq = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            char c2 = str.charAt(i);
            if (c2 == '\\') {
                i++;
                if (i >= str.length()) {
                    return keySeq.toString();
                }
                c2 = str.charAt(i);
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
                        i--;
                        c2 = (char) (c3 & 255);
                        continue;
                    case 'C':
                        i++;
                        if (i >= str.length()) {
                            break;
                        } else {
                            c2 = str.charAt(i);
                            if (c2 == '-') {
                                i++;
                                if (i >= str.length()) {
                                    break;
                                } else {
                                    c2 = str.charAt(i);
                                }
                            }
                            c2 = c2 == '?' ? 127 : (char) (Character.toUpperCase(c2) & 31);
                            continue;
                        }
                    case 'E':
                    case 'e':
                        c2 = 27;
                        continue;
                    case '\\':
                        c2 = '\\';
                        continue;
                    case 'a':
                        c2 = 7;
                        continue;
                    case 'b':
                        c2 = '\b';
                        continue;
                    case 'd':
                        c2 = 127;
                        continue;
                    case 'f':
                        c2 = '\f';
                        continue;
                    case 'n':
                        c2 = '\n';
                        continue;
                    case 'r':
                        c2 = '\r';
                        continue;
                    case 't':
                        c2 = '\t';
                        continue;
                    case 'u':
                        i++;
                        c2 = 0;
                        int j2 = 0;
                        while (true) {
                            if (j2 >= 4) {
                                continue;
                            } else if (i < str.length() && (k = Character.digit(str.charAt(i), 16)) >= 0) {
                                c2 = (char) ((c2 * 16) + k);
                                j2++;
                                i++;
                            }
                        }
                        break;
                    case 'v':
                        c2 = 11;
                        continue;
                    case 'x':
                        int i2 = i + 1;
                        char c4 = 0;
                        int j3 = 0;
                        while (j3 < 2 && i2 < str.length() && (k2 = Character.digit(str.charAt(i2), 16)) >= 0) {
                            c4 = (char) ((c4 * 16) + k2);
                            j3++;
                            i2++;
                        }
                        i = i2 - 1;
                        c2 = (char) (c4 & 255);
                        continue;
                }
                keySeq.append(c2);
                i++;
            } else {
                if (c2 == '^') {
                    i++;
                    if (i >= str.length()) {
                        return keySeq.toString();
                    }
                    c2 = str.charAt(i);
                    if (c2 != '^') {
                        c2 = c2 == '?' ? 127 : (char) (Character.toUpperCase(c2) & 31);
                    }
                } else {
                    continue;
                }
                keySeq.append(c2);
                i++;
            }
        }
        return keySeq.toString();
    }

    public static Collection<String> range(String range) {
        String pfx;
        String[] keys = range.split("-");
        if (keys.length != 2) {
            return null;
        }
        keys[0] = translate(keys[0]);
        keys[1] = translate(keys[1]);
        if (keys[0].length() != keys[1].length()) {
            return null;
        }
        if (keys[0].length() > 1) {
            pfx = keys[0].substring(0, keys[0].length() - 1);
            if (!keys[1].startsWith(pfx)) {
                return null;
            }
        } else {
            pfx = "";
        }
        char c0 = keys[0].charAt(keys[0].length() - 1);
        char c1 = keys[1].charAt(keys[1].length() - 1);
        if (c0 > c1) {
            return null;
        }
        Collection<String> seqs = new ArrayList<>();
        for (char c = c0; c <= c1; c = (char) (c + 1)) {
            seqs.add(pfx + c);
        }
        return seqs;
    }

    public static String esc() {
        return "\u001b";
    }

    public static String alt(char c) {
        return "\u001b" + c;
    }

    public static String alt(String c) {
        return "\u001b" + c;
    }

    public static String del() {
        return "";
    }

    public static String ctrl(char key) {
        return key == '?' ? del() : Character.toString((char) (Character.toUpperCase(key) & 31));
    }

    public static String key(Terminal terminal, InfoCmp.Capability capability) {
        return Curses.tputs(terminal.getStringCapability(capability), new Object[0]);
    }

    public T getUnicode() {
        return this.unicode;
    }

    public void setUnicode(T unicode) {
        this.unicode = unicode;
    }

    public T getNomatch() {
        return this.nomatch;
    }

    public void setNomatch(T nomatch) {
        this.nomatch = nomatch;
    }

    public long getAmbiguousTimeout() {
        return this.ambiguousTimeout;
    }

    public void setAmbiguousTimeout(long ambiguousTimeout) {
        this.ambiguousTimeout = ambiguousTimeout;
    }

    public T getAnotherKey() {
        return this.anotherKey;
    }

    public Map<String, T> getBoundKeys() {
        Map<String, T> bound = new TreeMap<>(KEYSEQ_COMPARATOR);
        doGetBoundKeys(this, "", bound);
        return bound;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.Map<java.lang.String, T> */
    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void doGetBoundKeys(KeyMap<T> keyMap, String prefix, Map<String, T> bound) {
        if (((KeyMap) keyMap).anotherKey != null) {
            bound.put(prefix, ((KeyMap) keyMap).anotherKey);
        }
        for (int c = 0; c < ((KeyMap) keyMap).mapping.length; c++) {
            if (((KeyMap) keyMap).mapping[c] instanceof KeyMap) {
                doGetBoundKeys((KeyMap) ((KeyMap) keyMap).mapping[c], prefix + ((char) c), bound);
            } else if (((KeyMap) keyMap).mapping[c] != null) {
                bound.put(prefix + ((char) c), ((KeyMap) keyMap).mapping[c]);
            }
        }
    }

    public T getBound(CharSequence keySeq, int[] remaining) {
        remaining[0] = -1;
        if (keySeq == null || keySeq.length() <= 0) {
            return this.anotherKey;
        }
        char c = keySeq.charAt(0);
        if (c >= this.mapping.length) {
            remaining[0] = Character.codePointCount(keySeq, 0, keySeq.length());
            return null;
        } else if (this.mapping[c] instanceof KeyMap) {
            return (T) ((KeyMap) this.mapping[c]).getBound(keySeq.subSequence(1, keySeq.length()), remaining);
        } else if (this.mapping[c] != null) {
            remaining[0] = keySeq.length() - 1;
            return (T) this.mapping[c];
        } else {
            remaining[0] = keySeq.length();
            return this.anotherKey;
        }
    }

    public T getBound(CharSequence keySeq) {
        int[] remaining = new int[1];
        T res = getBound(keySeq, remaining);
        if (remaining[0] <= 0) {
            return res;
        }
        return null;
    }

    public void bindIfNotBound(T function, CharSequence keySeq) {
        if (function != null && keySeq != null) {
            bind(this, keySeq, function, true);
        }
    }

    public void bind(T function, CharSequence... keySeqs) {
        for (CharSequence keySeq : keySeqs) {
            bind((KeyMap<T>) function, keySeq);
        }
    }

    public void bind(T function, Iterable<? extends CharSequence> keySeqs) {
        for (CharSequence keySeq : keySeqs) {
            bind((KeyMap<T>) function, keySeq);
        }
    }

    public void bind(T function, CharSequence keySeq) {
        if (keySeq == null) {
            return;
        }
        if (function == null) {
            unbind(keySeq);
        } else {
            bind(this, keySeq, function, false);
        }
    }

    public void unbind(CharSequence... keySeqs) {
        for (CharSequence keySeq : keySeqs) {
            unbind(keySeq);
        }
    }

    public void unbind(CharSequence keySeq) {
        if (keySeq != null) {
            unbind(this, keySeq);
        }
    }

    private static <T> T unbind(KeyMap<T> map, CharSequence keySeq) {
        KeyMap<T> prev = null;
        if (keySeq == null || keySeq.length() <= 0) {
            return null;
        }
        for (int i = 0; i < keySeq.length() - 1; i++) {
            char c = keySeq.charAt(i);
            if (c > ((KeyMap) map).mapping.length || !(((KeyMap) map).mapping[c] instanceof KeyMap)) {
                return null;
            }
            prev = map;
            map = (KeyMap) ((KeyMap) map).mapping[c];
        }
        char c2 = keySeq.charAt(keySeq.length() - 1);
        if (c2 > ((KeyMap) map).mapping.length) {
            return null;
        }
        if (((KeyMap) map).mapping[c2] instanceof KeyMap) {
            KeyMap<?> sub = (KeyMap) ((KeyMap) map).mapping[c2];
            T t = ((KeyMap) sub).anotherKey;
            ((KeyMap) sub).anotherKey = null;
            return t;
        }
        T t2 = (T) ((KeyMap) map).mapping[c2];
        ((KeyMap) map).mapping[c2] = null;
        int nb = 0;
        for (int i2 = 0; i2 < ((KeyMap) map).mapping.length; i2++) {
            if (((KeyMap) map).mapping[i2] != null) {
                nb++;
            }
        }
        if (nb == 0 && prev != null) {
            ((KeyMap) prev).mapping[keySeq.charAt(keySeq.length() - 2)] = ((KeyMap) map).anotherKey;
        }
        return t2;
    }

    private static <T> void bind(KeyMap<T> map, CharSequence keySeq, T function, boolean onlyIfNotBound) {
        char c;
        if (keySeq != null && keySeq.length() > 0) {
            int i = 0;
            while (i < keySeq.length() && (c = keySeq.charAt(i)) < ((KeyMap) map).mapping.length) {
                if (i < keySeq.length() - 1) {
                    if (!(((KeyMap) map).mapping[c] instanceof KeyMap)) {
                        KeyMap<T> m = new KeyMap<>();
                        ((KeyMap) m).anotherKey = (T) ((KeyMap) map).mapping[c];
                        ((KeyMap) map).mapping[c] = m;
                    }
                    map = (KeyMap) ((KeyMap) map).mapping[c];
                } else if (((KeyMap) map).mapping[c] instanceof KeyMap) {
                    ((KeyMap) ((KeyMap) map).mapping[c]).anotherKey = function;
                } else {
                    Object op = ((KeyMap) map).mapping[c];
                    if (!onlyIfNotBound || op == null) {
                        ((KeyMap) map).mapping[c] = function;
                    }
                }
                i++;
            }
        }
    }
}
