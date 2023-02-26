package org.luaj.vm2.lib.jse;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.VarArgFunction;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/LuajavaLib.class */
public class LuajavaLib extends VarArgFunction {
    static final int INIT = 0;
    static final int BINDCLASS = 1;
    static final int NEWINSTANCE = 2;
    static final int NEW = 3;
    static final int CREATEPROXY = 4;
    static final int LOADLIB = 5;
    static final String[] NAMES = {"bindClass", TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME, "new", "createProxy", "loadLib"};
    static final int METHOD_MODIFIERS_VARARGS = 128;
    static Class class$java$lang$Class;

    /* renamed from: org.luaj.vm2.lib.jse.LuajavaLib$1 */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/LuajavaLib$1.class */
    static class C58711 {
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/LuajavaLib$ProxyInvocationHandler.class */
    private static final class ProxyInvocationHandler implements InvocationHandler {
        private final LuaValue lobj;

        private ProxyInvocationHandler(LuaValue luaValue) {
            this.lobj = luaValue;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            LuaValue[] luaValueArr;
            LuaValue luaValue = this.lobj.get(method.getName());
            if (luaValue.isnil()) {
                return null;
            }
            boolean z = (method.getModifiers() & 128) != 0;
            int length = objArr != null ? objArr.length : 0;
            if (z) {
                int i = length - 1;
                Object obj2 = objArr[i];
                int length2 = Array.getLength(obj2);
                luaValueArr = new LuaValue[i + length2];
                for (int i2 = 0; i2 < i; i2++) {
                    luaValueArr[i2] = CoerceJavaToLua.coerce(objArr[i2]);
                }
                for (int i3 = 0; i3 < length2; i3++) {
                    luaValueArr[i3 + i] = CoerceJavaToLua.coerce(Array.get(obj2, i3));
                }
            } else {
                luaValueArr = new LuaValue[length];
                for (int i4 = 0; i4 < length; i4++) {
                    luaValueArr[i4] = CoerceJavaToLua.coerce(objArr[i4]);
                }
            }
            return CoerceLuaToJava.coerce(luaValue.invoke(luaValueArr).arg1(), method.getReturnType());
        }

        ProxyInvocationHandler(LuaValue luaValue, C58711 r5) {
            this(luaValue);
        }
    }

    @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public Varargs invoke(Varargs varargs) {
        Class cls;
        Class cls2;
        try {
            switch (this.opcode) {
                case 0:
                    LuaValue arg = varargs.arg(2);
                    LuaTable luaTable = new LuaTable();
                    bind(luaTable, getClass(), NAMES, 1);
                    arg.set("luajava", luaTable);
                    arg.get("package").get("loaded").set("luajava", luaTable);
                    return luaTable;
                case 1:
                    return JavaClass.forClass(classForName(varargs.checkjstring(1)));
                case 2:
                case 3:
                    LuaValue checkvalue = varargs.checkvalue(1);
                    if (this.opcode == 2) {
                        cls = classForName(checkvalue.tojstring());
                    } else {
                        if (class$java$lang$Class == null) {
                            cls2 = class$("java.lang.Class");
                            class$java$lang$Class = cls2;
                        } else {
                            cls2 = class$java$lang$Class;
                        }
                        cls = (Class) checkvalue.checkuserdata(cls2);
                    }
                    return JavaClass.forClass(cls).getConstructor().invoke(varargs.subargs(2));
                case 4:
                    int narg = varargs.narg() - 1;
                    if (narg <= 0) {
                        throw new LuaError("no interfaces");
                    }
                    LuaTable checktable = varargs.checktable(narg + 1);
                    Class[] clsArr = new Class[narg];
                    for (int i = 0; i < narg; i++) {
                        clsArr[i] = classForName(varargs.checkjstring(i + 1));
                    }
                    return LuaValue.userdataOf(Proxy.newProxyInstance(getClass().getClassLoader(), clsArr, new ProxyInvocationHandler(checktable, null)));
                case 5:
                    String checkjstring = varargs.checkjstring(1);
                    String checkjstring2 = varargs.checkjstring(2);
                    Class classForName = classForName(checkjstring);
                    Object invoke = classForName.getMethod(checkjstring2, new Class[0]).invoke(classForName, new Object[0]);
                    return invoke instanceof LuaValue ? (LuaValue) invoke : NIL;
                default:
                    throw new LuaError(new StringBuffer().append("not yet supported: ").append(this).toString());
            }
        } catch (InvocationTargetException e) {
            throw new LuaError(e.getTargetException());
        } catch (LuaError e2) {
            throw e2;
        } catch (Exception e3) {
            throw new LuaError(e3);
        }
    }

    protected Class classForName(String str) throws ClassNotFoundException {
        return Class.forName(str, true, ClassLoader.getSystemClassLoader());
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }
}
