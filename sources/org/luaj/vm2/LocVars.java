package org.luaj.vm2;

/* loaded from: grasscutter.jar:org/luaj/vm2/LocVars.class */
public class LocVars {
    public LuaString varname;
    public int startpc;
    public int endpc;

    public LocVars(LuaString luaString, int i, int i2) {
        this.varname = luaString;
        this.startpc = i;
        this.endpc = i2;
    }

    public String tojstring() {
        return new StringBuffer().append(this.varname).append(" ").append(this.startpc).append("-").append(this.endpc).toString();
    }
}
