package org.jline.reader.impl;

import java.util.ListIterator;
import org.jline.reader.Expander;
import org.jline.reader.History;

/* loaded from: grasscutter.jar:org/jline/reader/impl/DefaultExpander.class */
public class DefaultExpander implements Expander {
    @Override // org.jline.reader.Expander
    public String expandHistory(History history, String line) {
        boolean inQuote = false;
        StringBuilder sb = new StringBuilder();
        boolean escaped = false;
        int unicode = 0;
        int i = 0;
        while (i < line.length()) {
            char c = line.charAt(i);
            if (unicode > 0) {
                unicode--;
                escaped = unicode >= 0;
                sb.append(c);
            } else if (escaped) {
                if (c == 'u') {
                    unicode = 4;
                } else {
                    escaped = false;
                }
                sb.append(c);
            } else if (c == '\'') {
                inQuote = !inQuote;
                sb.append(c);
            } else if (inQuote) {
                sb.append(c);
            } else {
                switch (c) {
                    case '!':
                        if (i + 1 < line.length()) {
                            i++;
                            char c2 = line.charAt(i);
                            boolean neg = false;
                            String rep = null;
                            switch (c2) {
                                case '\t':
                                case ' ':
                                    sb.append('!');
                                    sb.append(c2);
                                    break;
                                case '\n':
                                case 11:
                                case '\f':
                                case '\r':
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                case 18:
                                case 19:
                                case 20:
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                case 26:
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                case 31:
                                case '\"':
                                case '%':
                                case '&':
                                case '\'':
                                case '(':
                                case ')':
                                case '*':
                                case '+':
                                case ',':
                                case '.':
                                case '/':
                                case ':':
                                case ';':
                                case '<':
                                case '=':
                                case '>':
                                default:
                                    String ss = line.substring(i);
                                    i = line.length();
                                    int idx = searchBackwards(history, ss, history.index(), true);
                                    if (idx >= 0) {
                                        rep = history.get(idx);
                                        break;
                                    } else {
                                        throw new IllegalArgumentException("!" + ss + ": event not found");
                                    }
                                case '!':
                                    if (history.size() != 0) {
                                        rep = history.get(history.index() - 1);
                                        break;
                                    } else {
                                        throw new IllegalArgumentException("!!: event not found");
                                    }
                                case '#':
                                    sb.append(sb.toString());
                                    break;
                                case '$':
                                    if (history.size() != 0) {
                                        String previous = history.get(history.index() - 1).trim();
                                        int lastSpace = previous.lastIndexOf(32);
                                        if (lastSpace == -1) {
                                            rep = previous;
                                            break;
                                        } else {
                                            rep = previous.substring(lastSpace + 1);
                                            break;
                                        }
                                    } else {
                                        throw new IllegalArgumentException("!$: event not found");
                                    }
                                case '-':
                                    neg = true;
                                    i++;
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    while (i < line.length() && (c = line.charAt(i)) >= '0' && c <= '9') {
                                        i++;
                                    }
                                    try {
                                        int idx2 = Integer.parseInt(line.substring(i, i));
                                        if (!neg || idx2 <= 0 || idx2 > history.size()) {
                                            if (!neg && idx2 > history.index() - history.size() && idx2 <= history.index()) {
                                                rep = history.get(idx2 - 1);
                                                break;
                                            } else {
                                                throw new IllegalArgumentException((neg ? "!-" : "!") + line.substring(i, i) + ": event not found");
                                            }
                                        } else {
                                            rep = history.get(history.index() - idx2);
                                            break;
                                        }
                                    } catch (NumberFormatException e) {
                                        throw new IllegalArgumentException((neg ? "!-" : "!") + line.substring(i, i) + ": event not found");
                                    }
                                case '?':
                                    int i1 = line.indexOf(63, i + 1);
                                    if (i1 < 0) {
                                        i1 = line.length();
                                    }
                                    String sc = line.substring(i + 1, i1);
                                    i = i1;
                                    int idx3 = searchBackwards(history, sc, history.index(), false);
                                    if (idx3 >= 0) {
                                        rep = history.get(idx3);
                                        break;
                                    } else {
                                        throw new IllegalArgumentException("!?" + sc + ": event not found");
                                    }
                            }
                            if (rep == null) {
                                break;
                            } else {
                                sb.append(rep);
                                break;
                            }
                        } else {
                            sb.append(c);
                            continue;
                        }
                    case '\\':
                        escaped = true;
                        sb.append(c);
                        continue;
                    case '^':
                        if (i == 0) {
                            int i12 = line.indexOf(94, i + 1);
                            int i2 = line.indexOf(94, i12 + 1);
                            if (i2 < 0) {
                                i2 = line.length();
                            }
                            if (i12 > 0 && i2 > 0) {
                                sb.append(history.get(history.index() - 1).replace(line.substring(i + 1, i12), line.substring(i12 + 1, i2)));
                                i = i2 + 1;
                                continue;
                            }
                        }
                        sb.append(c);
                        break;
                    default:
                        sb.append(c);
                        continue;
                }
            }
            i++;
        }
        return sb.toString();
    }

    @Override // org.jline.reader.Expander
    public String expandVar(String word) {
        return word;
    }

    protected int searchBackwards(History history, String searchTerm, int startIndex, boolean startsWith) {
        ListIterator<History.Entry> it = history.iterator(startIndex);
        while (it.hasPrevious()) {
            History.Entry e = it.previous();
            if (startsWith) {
                if (e.line().startsWith(searchTerm)) {
                    return e.index();
                }
            } else if (e.line().contains(searchTerm)) {
                return e.index();
            }
        }
        return -1;
    }
}
