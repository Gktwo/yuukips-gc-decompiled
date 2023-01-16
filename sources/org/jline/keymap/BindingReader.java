package org.jline.keymap;

import java.io.IOError;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.stream.IntStream;
import org.jline.reader.EndOfFileException;
import org.jline.utils.ClosedException;
import org.jline.utils.NonBlockingReader;

/* loaded from: grasscutter.jar:org/jline/keymap/BindingReader.class */
public class BindingReader {
    protected final NonBlockingReader reader;
    protected final StringBuilder opBuffer = new StringBuilder();
    protected final Deque<Integer> pushBackChar = new ArrayDeque();
    protected String lastBinding;

    public BindingReader(NonBlockingReader reader) {
        this.reader = reader;
    }

    public <T> T readBinding(KeyMap<T> keys) {
        return (T) readBinding(keys, null, true);
    }

    public <T> T readBinding(KeyMap<T> keys, KeyMap<T> local) {
        return (T) readBinding(keys, local, true);
    }

    public <T> T readBinding(KeyMap<T> keys, KeyMap<T> local, boolean block) {
        int c;
        this.lastBinding = null;
        T o = null;
        int[] remaining = new int[1];
        boolean hasRead = false;
        while (true) {
            if (local != null) {
                o = local.getBound(this.opBuffer, remaining);
            }
            if (o == null && (local == null || remaining[0] >= 0)) {
                o = keys.getBound(this.opBuffer, remaining);
            }
            if (o != null) {
                if (remaining[0] >= 0) {
                    runMacro(this.opBuffer.substring(this.opBuffer.length() - remaining[0]));
                    this.opBuffer.setLength(this.opBuffer.length() - remaining[0]);
                } else {
                    long ambiguousTimeout = keys.getAmbiguousTimeout();
                    if (ambiguousTimeout > 0 && peekCharacter(ambiguousTimeout) != -2) {
                        o = null;
                    }
                }
                if (o != null) {
                    this.lastBinding = this.opBuffer.toString();
                    this.opBuffer.setLength(0);
                    return o;
                }
            } else if (remaining[0] > 0) {
                int cp = this.opBuffer.codePointAt(0);
                String rem = this.opBuffer.substring(Character.charCount(cp));
                this.lastBinding = this.opBuffer.substring(0, Character.charCount(cp));
                o = cp >= 128 ? keys.getUnicode() : keys.getNomatch();
                this.opBuffer.setLength(0);
                this.opBuffer.append(rem);
                if (o != null) {
                    return o;
                }
            }
            if ((!block && hasRead) || (c = readCharacter()) == -1) {
                return null;
            }
            this.opBuffer.appendCodePoint(c);
            hasRead = true;
        }
    }

    public String readStringUntil(String sequence) {
        StringBuilder sb = new StringBuilder();
        if (!this.pushBackChar.isEmpty()) {
            Deque<Integer> deque = this.pushBackChar;
            Objects.requireNonNull(sb);
            deque.forEach((v1) -> {
                r1.appendCodePoint(v1);
            });
        }
        try {
            char[] buf = new char[64];
            while (true) {
                int idx = sb.indexOf(sequence, Math.max(0, (sb.length() - buf.length) - sequence.length()));
                if (idx >= 0) {
                    runMacro(sb.substring(idx + sequence.length()));
                    return sb.substring(0, idx);
                }
                int l = this.reader.readBuffered(buf);
                if (l < 0) {
                    throw new ClosedException();
                }
                sb.append(buf, 0, l);
            }
        } catch (ClosedException e) {
            throw new EndOfFileException(e);
        } catch (IOException e2) {
            throw new IOError(e2);
        }
    }

    public int readCharacter() {
        if (!this.pushBackChar.isEmpty()) {
            return this.pushBackChar.pop().intValue();
        }
        int c = -2;
        int s = 0;
        while (c == -2) {
            try {
                c = this.reader.read(100);
                if (c >= 0 && Character.isHighSurrogate((char) c)) {
                    s = c;
                    c = -2;
                }
            } catch (ClosedException e) {
                throw new EndOfFileException(e);
            } catch (IOException e2) {
                throw new IOError(e2);
            }
        }
        return s != 0 ? Character.toCodePoint((char) s, (char) c) : c;
    }

    public int readCharacterBuffered() {
        try {
            if (this.pushBackChar.isEmpty()) {
                char[] buf = new char[32];
                int l = this.reader.readBuffered(buf);
                if (l <= 0) {
                    return -1;
                }
                int s = 0;
                int i = 0;
                while (i < l) {
                    i++;
                    char c = buf[i];
                    if (Character.isHighSurrogate((char) c)) {
                        s = c;
                        if (i >= l) {
                            break;
                        }
                        i++;
                        this.pushBackChar.addLast(Integer.valueOf(Character.toCodePoint((char) s, (char) buf[i])));
                    } else {
                        s = 0;
                        this.pushBackChar.addLast(Integer.valueOf(c));
                    }
                }
                if (s != 0) {
                    int c2 = this.reader.read();
                    if (c2 < 0) {
                        return -1;
                    }
                    this.pushBackChar.addLast(Integer.valueOf(Character.toCodePoint((char) s, (char) c2)));
                }
            }
            return this.pushBackChar.pop().intValue();
        } catch (ClosedException e) {
            throw new EndOfFileException(e);
        } catch (IOException e2) {
            throw new IOError(e2);
        }
    }

    public int peekCharacter(long timeout) {
        if (!this.pushBackChar.isEmpty()) {
            return this.pushBackChar.peek().intValue();
        }
        try {
            return this.reader.peek(timeout);
        } catch (IOException e) {
            throw new IOError(e);
        }
    }

    public void runMacro(String macro) {
        IntStream codePoints = macro.codePoints();
        Deque<Integer> deque = this.pushBackChar;
        Objects.requireNonNull(deque);
        codePoints.forEachOrdered((v1) -> {
            r1.addLast(v1);
        });
    }

    public String getCurrentBuffer() {
        return this.opBuffer.toString();
    }

    public String getLastBinding() {
        return this.lastBinding;
    }
}
