package org.luaj.vm2;

/* loaded from: grasscutter.jar:org/luaj/vm2/Upvaldesc.class */
public class Upvaldesc {
    public LuaString name;
    public final boolean instack;
    public final short idx;

    public Upvaldesc(LuaString luaString, boolean z, int i) {
        this.name = luaString;
        this.instack = z;
        this.idx = (short) i;
    }

    public String toString() {
        return new StringBuffer().append((int) this.idx).append(this.instack ? " instack " : " closed ").append(String.valueOf(this.name)).toString();
    }
}
