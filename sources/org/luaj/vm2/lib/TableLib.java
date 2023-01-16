package org.luaj.vm2.lib;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/TableLib.class */
public class TableLib extends TwoArgFunction {

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/TableLib$TableLibFunction.class */
    static class TableLibFunction extends LibFunction {
        TableLibFunction() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call() {
            return argerror(1, "table expected, got no value");
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/TableLib$concat.class */
    static class concat extends TableLibFunction {
        concat() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return luaValue.checktable().concat(EMPTYSTRING, 1, luaValue.length());
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
            return luaValue.checktable().concat(luaValue2.checkstring(), 1, luaValue.length());
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2, LuaValue luaValue3) {
            return luaValue.checktable().concat(luaValue2.checkstring(), luaValue3.checkint(), luaValue.length());
        }

        @Override // org.luaj.vm2.lib.LibFunction
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2, LuaValue luaValue3, LuaValue luaValue4) {
            return luaValue.checktable().concat(luaValue2.checkstring(), luaValue3.checkint(), luaValue4.checkint());
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/TableLib$insert.class */
    static class insert extends VarArgFunction {
        insert() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            switch (varargs.narg()) {
                case 0:
                case 1:
                    return argerror(2, "value expected");
                case 2:
                    LuaTable checktable = varargs.arg1().checktable();
                    checktable.insert(checktable.length() + 1, varargs.arg(2));
                    return NONE;
                default:
                    varargs.arg1().checktable().insert(varargs.checkint(2), varargs.arg(3));
                    return NONE;
            }
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/TableLib$pack.class */
    static class pack extends VarArgFunction {
        pack() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaTable tableOf = tableOf(varargs, 1);
            tableOf.set("n", varargs.narg());
            return tableOf;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/TableLib$remove.class */
    static class remove extends VarArgFunction {
        remove() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            return varargs.arg1().checktable().remove(varargs.optint(2, 0));
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/TableLib$sort.class */
    static class sort extends VarArgFunction {
        sort() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            varargs.arg1().checktable().sort(varargs.arg(2).isnil() ? NIL : varargs.arg(2).checkfunction());
            return NONE;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/TableLib$unpack.class */
    static class unpack extends VarArgFunction {
        unpack() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaTable checktable = varargs.checktable(1);
            switch (varargs.narg()) {
                case 1:
                    return checktable.unpack();
                case 2:
                    return checktable.unpack(varargs.checkint(2));
                default:
                    return checktable.unpack(varargs.checkint(2), varargs.checkint(3));
            }
        }
    }

    @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        LuaTable luaTable = new LuaTable();
        luaTable.set("concat", new concat());
        luaTable.set("insert", new insert());
        luaTable.set("pack", new pack());
        luaTable.set("remove", new remove());
        luaTable.set("sort", new sort());
        luaTable.set("unpack", new unpack());
        luaValue2.set("table", luaTable);
        luaValue2.get("package").get("loaded").set("table", luaTable);
        return NIL;
    }
}
