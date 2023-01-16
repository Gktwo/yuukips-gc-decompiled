package org.jline.terminal;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/Cursor.class */
public class Cursor {

    /* renamed from: x */
    private final int f3234x;

    /* renamed from: y */
    private final int f3235y;

    public Cursor(int x, int y) {
        this.f3234x = x;
        this.f3235y = y;
    }

    public int getX() {
        return this.f3234x;
    }

    public int getY() {
        return this.f3235y;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Cursor)) {
            return false;
        }
        Cursor c = (Cursor) o;
        return this.f3234x == c.f3234x && this.f3235y == c.f3235y;
    }

    public int hashCode() {
        return (this.f3234x * 31) + this.f3235y;
    }

    public String toString() {
        return "Cursor[x=" + this.f3234x + ", y=" + this.f3235y + ']';
    }
}
