package org.luaj.vm2.lib.jse;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JavaMethod.class */
public class JavaMethod extends JavaMember {
    static final Map methods = Collections.synchronizedMap(new HashMap());
    final Method method;

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JavaMethod$Overload.class */
    public static class Overload extends LuaFunction {
        final JavaMethod[] methods;

        Overload(JavaMethod[] javaMethodArr) {
            this.methods = javaMethodArr;
        }

        @Override // org.luaj.vm2.LuaValue
        public LuaValue call() {
            return error("method cannot be called without instance");
        }

        @Override // org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return invokeBestMethod(luaValue.checkuserdata(), LuaValue.NONE);
        }

        @Override // org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
            return invokeBestMethod(luaValue.checkuserdata(), luaValue2);
        }

        @Override // org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2, LuaValue luaValue3) {
            return invokeBestMethod(luaValue.checkuserdata(), LuaValue.varargsOf(luaValue2, luaValue3));
        }

        @Override // org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            return invokeBestMethod(varargs.checkuserdata(1), varargs.subargs(2));
        }

        private LuaValue invokeBestMethod(Object obj, Varargs varargs) {
            JavaMethod javaMethod = null;
            int i = CoerceLuaToJava.SCORE_UNCOERCIBLE;
            for (int i2 = 0; i2 < this.methods.length; i2++) {
                int score = this.methods[i2].score(varargs);
                if (score < i) {
                    i = score;
                    javaMethod = this.methods[i2];
                    if (i == 0) {
                        break;
                    }
                }
            }
            if (javaMethod == null) {
                LuaValue.error("no coercible public method");
            }
            return javaMethod.invokeMethod(obj, varargs);
        }
    }

    /* access modifiers changed from: package-private */
    public static JavaMethod forMethod(Method method) {
        JavaMethod javaMethod = (JavaMethod) methods.get(method);
        if (javaMethod == null) {
            Map map = methods;
            JavaMethod javaMethod2 = new JavaMethod(method);
            javaMethod = javaMethod2;
            map.put(method, javaMethod2);
        }
        return javaMethod;
    }

    /* access modifiers changed from: package-private */
    public static LuaFunction forMethods(JavaMethod[] javaMethodArr) {
        return new Overload(javaMethodArr);
    }

    private JavaMethod(Method method) {
        super(method.getParameterTypes(), method.getModifiers());
        this.method = method;
        try {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
        } catch (SecurityException e) {
        }
    }

    @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call() {
        return error("method cannot be called without instance");
    }

    @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue) {
        return invokeMethod(luaValue.checkuserdata(), LuaValue.NONE);
    }

    @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        return invokeMethod(luaValue.checkuserdata(), luaValue2);
    }

    @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2, LuaValue luaValue3) {
        return invokeMethod(luaValue.checkuserdata(), LuaValue.varargsOf(luaValue2, luaValue3));
    }

    @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public Varargs invoke(Varargs varargs) {
        return invokeMethod(varargs.checkuserdata(1), varargs.subargs(2));
    }

    LuaValue invokeMethod(Object obj, Varargs varargs) {
        try {
            return CoerceJavaToLua.coerce(this.method.invoke(obj, convertArgs(varargs)));
        } catch (InvocationTargetException e) {
            throw new LuaError(e.getTargetException());
        } catch (Exception e2) {
            return LuaValue.error(new StringBuffer().append("coercion error ").append(e2).toString());
        }
    }
}
