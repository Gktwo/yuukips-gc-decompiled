package org.luaj.vm2.ast;

import java.util.ArrayList;
import java.util.List;
import org.luaj.vm2.LuaString;

/* loaded from: grasscutter.jar:org/luaj/vm2/ast/FuncArgs.class */
public class FuncArgs extends SyntaxElement {
    public final List exps;

    public static FuncArgs explist(List list) {
        return new FuncArgs(list);
    }

    public static FuncArgs tableconstructor(TableConstructor tableConstructor) {
        return new FuncArgs(tableConstructor);
    }

    public static FuncArgs string(LuaString luaString) {
        return new FuncArgs(luaString);
    }

    public FuncArgs(List list) {
        this.exps = list;
    }

    public FuncArgs(LuaString luaString) {
        this.exps = new ArrayList();
        this.exps.add(Exp.constant(luaString));
    }

    public FuncArgs(TableConstructor tableConstructor) {
        this.exps = new ArrayList();
        this.exps.add(tableConstructor);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
