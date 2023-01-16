package org.luaj.vm2.luajc;

import java.util.HashMap;
import java.util.Map;
import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Prototype;

/* loaded from: grasscutter.jar:org/luaj/vm2/luajc/JavaLoader.class */
public class JavaLoader extends ClassLoader {
    private Map unloaded = new HashMap();

    public LuaFunction load(Prototype prototype, String str, String str2, LuaValue luaValue) {
        return load(new JavaGen(prototype, str, str2, false), luaValue);
    }

    public LuaFunction load(JavaGen javaGen, LuaValue luaValue) {
        include(javaGen);
        return load(javaGen.classname, luaValue);
    }

    public LuaFunction load(String str, LuaValue luaValue) {
        try {
            LuaFunction luaFunction = (LuaFunction) loadClass(str).newInstance();
            luaFunction.initupvalue1(luaValue);
            return luaFunction;
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException(new StringBuffer().append("bad class gen: ").append(e).toString());
        }
    }

    public void include(JavaGen javaGen) {
        this.unloaded.put(javaGen.classname, javaGen.bytecode);
        int length = javaGen.inners != null ? javaGen.inners.length : 0;
        for (int i = 0; i < length; i++) {
            include(javaGen.inners[i]);
        }
    }

    @Override // java.lang.ClassLoader
    public Class findClass(String str) throws ClassNotFoundException {
        byte[] bArr = (byte[]) this.unloaded.get(str);
        return bArr != null ? defineClass(str, bArr, 0, bArr.length) : findClass(str);
    }
}
