package org.luaj.vm2.ast;

import org.luaj.vm2.LuaValue;

/* loaded from: grasscutter.jar:org/luaj/vm2/ast/Variable.class */
public class Variable {
    public final String name;
    public final NameScope definingScope;
    public boolean isupvalue;
    public boolean hasassignments;
    public LuaValue initialValue;

    public Variable(String str) {
        this.name = str;
        this.definingScope = null;
    }

    public Variable(String str, NameScope nameScope) {
        this.name = str;
        this.definingScope = nameScope;
    }

    public boolean isLocal() {
        return this.definingScope != null;
    }

    public boolean isConstant() {
        return !this.hasassignments && this.initialValue != null;
    }
}
