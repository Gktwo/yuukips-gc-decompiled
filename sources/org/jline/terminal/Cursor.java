package org.jline.terminal;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/Cursor.class */
public class Cursor {

    /* renamed from: x */
    private final int f3198x;

    /* renamed from: y */
    private final int f3199y;

    public Cursor(int x, int y) {
        this.f3198x = x;
        this.f3199y = y;
    }

    public int getX() {
        return this.f3198x;
    }

    public int getY() {
        return this.f3199y;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Cursor)) {
            return false;
        }
        Cursor c = (Cursor) o;
        return this.f3198x == c.f3198x && this.f3199y == c.f3199y;
    }

    public int hashCode() {
        return (this.f3198x * 31) + this.f3199y;
    }

    public String toString() {
        return "Cursor[x=" + this.f3198x + ", y=" + this.f3199y + ']';
    }
}
