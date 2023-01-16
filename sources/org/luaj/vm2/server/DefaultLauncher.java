package org.luaj.vm2.server;

import java.io.InputStream;
import java.io.Reader;
import org.jline.reader.LineReader;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.JsePlatform;

/* loaded from: grasscutter.jar:org/luaj/vm2/server/DefaultLauncher.class */
public class DefaultLauncher implements Launcher {

    /* renamed from: g */
    protected Globals f3363g = JsePlatform.standardGlobals();

    @Override // org.luaj.vm2.server.Launcher
    public Object[] launch(String str, Object[] objArr) {
        return launchChunk(this.f3363g.load(str, LineReader.MAIN), objArr);
    }

    @Override // org.luaj.vm2.server.Launcher
    public Object[] launch(InputStream inputStream, Object[] objArr) {
        return launchChunk(this.f3363g.load(inputStream, LineReader.MAIN, "bt", this.f3363g), objArr);
    }

    @Override // org.luaj.vm2.server.Launcher
    public Object[] launch(Reader reader, Object[] objArr) {
        return launchChunk(this.f3363g.load(reader, LineReader.MAIN), objArr);
    }

    private Object[] launchChunk(LuaValue luaValue, Object[] objArr) {
        LuaValue[] luaValueArr = new LuaValue[objArr.length];
        for (int i = 0; i < luaValueArr.length; i++) {
            luaValueArr[i] = CoerceJavaToLua.coerce(objArr[i]);
        }
        Varargs invoke = luaValue.invoke(LuaValue.varargsOf(luaValueArr));
        int narg = invoke.narg();
        Object[] objArr2 = new Object[narg];
        for (int i2 = 0; i2 < narg; i2++) {
            LuaValue arg = invoke.arg(i2 + 1);
            switch (arg.type()) {
                case -2:
                    objArr2[i2] = Integer.valueOf(arg.toint());
                    break;
                case -1:
                case 2:
                case 5:
                case 6:
                default:
                    objArr2[i2] = arg;
                    break;
                case 0:
                    objArr2[i2] = null;
                    break;
                case 1:
                    objArr2[i2] = Boolean.valueOf(arg.toboolean());
                    break;
                case 3:
                    objArr2[i2] = Double.valueOf(arg.todouble());
                    break;
                case 4:
                    objArr2[i2] = arg.tojstring();
                    break;
                case 7:
                    objArr2[i2] = arg.touserdata();
                    break;
            }
        }
        return objArr2;
    }
}
