package org.luaj.vm2.lib.jse;

import net.bytebuddy.description.method.ParameterDescription;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LoadState;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.compiler.LuaC;
import org.luaj.vm2.lib.Bit32Lib;
import org.luaj.vm2.lib.CoroutineLib;
import org.luaj.vm2.lib.DebugLib;
import org.luaj.vm2.lib.PackageLib;
import org.luaj.vm2.lib.StringLib;
import org.luaj.vm2.lib.TableLib;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JsePlatform.class */
public class JsePlatform {
    public static Globals standardGlobals() {
        Globals globals = new Globals();
        globals.load(new JseBaseLib());
        globals.load(new PackageLib());
        globals.load(new Bit32Lib());
        globals.load(new TableLib());
        globals.load(new StringLib());
        globals.load(new CoroutineLib());
        globals.load(new JseMathLib());
        globals.load(new JseIoLib());
        globals.load(new JseOsLib());
        globals.load(new LuajavaLib());
        LoadState.install(globals);
        LuaC.install(globals);
        return globals;
    }

    public static Globals debugGlobals() {
        Globals standardGlobals = standardGlobals();
        standardGlobals.load(new DebugLib());
        return standardGlobals;
    }

    public static void luaMain(LuaValue luaValue, String[] strArr) {
        Globals standardGlobals = standardGlobals();
        int length = strArr.length;
        LuaValue[] luaValueArr = new LuaValue[strArr.length];
        for (int i = 0; i < length; i++) {
            luaValueArr[i] = LuaValue.valueOf(strArr[i]);
        }
        LuaTable listOf = LuaValue.listOf(luaValueArr);
        listOf.set("n", length);
        standardGlobals.set(ParameterDescription.NAME_PREFIX, listOf);
        luaValue.initupvalue1(standardGlobals);
        luaValue.invoke(LuaValue.varargsOf(luaValueArr));
    }
}
