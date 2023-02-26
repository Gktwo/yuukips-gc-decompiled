package org.luaj.vm2;

import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/luaj/vm2/Prototype.class */
public class Prototype {

    /* renamed from: k */
    public LuaValue[] f3259k;
    public int[] code;

    /* renamed from: p */
    public Prototype[] f3260p;
    public int[] lineinfo;
    public LocVars[] locvars;
    public Upvaldesc[] upvalues;
    public LuaString source;
    public int linedefined;
    public int lastlinedefined;
    public int numparams;
    public int is_vararg;
    public int maxstacksize;
    private static final Upvaldesc[] NOUPVALUES = new Upvaldesc[0];
    private static final Prototype[] NOSUBPROTOS = new Prototype[0];

    public Prototype() {
        this.f3260p = NOSUBPROTOS;
        this.upvalues = NOUPVALUES;
    }

    public Prototype(int i) {
        this.f3260p = NOSUBPROTOS;
        this.upvalues = new Upvaldesc[i];
    }

    public String toString() {
        return new StringBuffer().append(this.source).append(EmitterKt.COMMENT_PREFIX).append(this.linedefined).append("-").append(this.lastlinedefined).toString();
    }

    public LuaString getlocalname(int i, int i2) {
        int i3 = 0;
        while (i3 < this.locvars.length && this.locvars[i3].startpc <= i2) {
            if (i2 < this.locvars[i3].endpc) {
                i--;
                if (i == 0) {
                    return this.locvars[i3].varname;
                }
            }
            i3++;
        }
        return null;
    }

    public String shortsource() {
        String str = this.source.tojstring();
        if (str.startsWith("@") || str.startsWith("=")) {
            str = str.substring(1);
        } else if (str.startsWith("\u001b")) {
            str = LoadState.SOURCE_BINARY_STRING;
        }
        return str;
    }
}
