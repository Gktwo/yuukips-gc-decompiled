package org.luaj.vm2.lib.jse;

import java.util.HashMap;
import java.util.Map;
import org.luaj.vm2.LuaDouble;
import org.luaj.vm2.LuaInteger;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaValue;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/CoerceJavaToLua.class */
public class CoerceJavaToLua {
    static final Map COERCIONS = new HashMap();
    static final Coercion instanceCoercion;
    static final Coercion arrayCoercion;
    static final Coercion luaCoercion;
    static Class class$java$lang$Boolean;
    static Class class$java$lang$Byte;
    static Class class$java$lang$Character;
    static Class class$java$lang$Short;
    static Class class$java$lang$Integer;
    static Class class$java$lang$Long;
    static Class class$java$lang$Float;
    static Class class$java$lang$Double;
    static Class class$java$lang$String;
    static Class array$B;
    static Class class$java$lang$Class;

    /* renamed from: org.luaj.vm2.lib.jse.CoerceJavaToLua$1 */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/CoerceJavaToLua$1.class */
    static class C58661 {
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/CoerceJavaToLua$ArrayCoercion.class */
    private static final class ArrayCoercion implements Coercion {
        private ArrayCoercion() {
        }

        @Override // org.luaj.vm2.lib.jse.CoerceJavaToLua.Coercion
        public LuaValue coerce(Object obj) {
            return new JavaArray(obj);
        }

        ArrayCoercion(C58661 r3) {
            this();
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/CoerceJavaToLua$BoolCoercion.class */
    private static final class BoolCoercion implements Coercion {
        private BoolCoercion() {
        }

        @Override // org.luaj.vm2.lib.jse.CoerceJavaToLua.Coercion
        public LuaValue coerce(Object obj) {
            return ((Boolean) obj).booleanValue() ? LuaValue.TRUE : LuaValue.FALSE;
        }

        BoolCoercion(C58661 r3) {
            this();
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/CoerceJavaToLua$BytesCoercion.class */
    private static final class BytesCoercion implements Coercion {
        private BytesCoercion() {
        }

        @Override // org.luaj.vm2.lib.jse.CoerceJavaToLua.Coercion
        public LuaValue coerce(Object obj) {
            return LuaValue.valueOf((byte[]) obj);
        }

        BytesCoercion(C58661 r3) {
            this();
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/CoerceJavaToLua$CharCoercion.class */
    private static final class CharCoercion implements Coercion {
        private CharCoercion() {
        }

        @Override // org.luaj.vm2.lib.jse.CoerceJavaToLua.Coercion
        public LuaValue coerce(Object obj) {
            return LuaInteger.valueOf((int) ((Character) obj).charValue());
        }

        CharCoercion(C58661 r3) {
            this();
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/CoerceJavaToLua$ClassCoercion.class */
    private static final class ClassCoercion implements Coercion {
        private ClassCoercion() {
        }

        @Override // org.luaj.vm2.lib.jse.CoerceJavaToLua.Coercion
        public LuaValue coerce(Object obj) {
            return JavaClass.forClass((Class) obj);
        }

        ClassCoercion(C58661 r3) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/CoerceJavaToLua$Coercion.class */
    public interface Coercion {
        LuaValue coerce(Object obj);
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/CoerceJavaToLua$DoubleCoercion.class */
    private static final class DoubleCoercion implements Coercion {
        private DoubleCoercion() {
        }

        @Override // org.luaj.vm2.lib.jse.CoerceJavaToLua.Coercion
        public LuaValue coerce(Object obj) {
            return LuaDouble.valueOf(((Number) obj).doubleValue());
        }

        DoubleCoercion(C58661 r3) {
            this();
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/CoerceJavaToLua$InstanceCoercion.class */
    private static final class InstanceCoercion implements Coercion {
        private InstanceCoercion() {
        }

        @Override // org.luaj.vm2.lib.jse.CoerceJavaToLua.Coercion
        public LuaValue coerce(Object obj) {
            return new JavaInstance(obj);
        }

        InstanceCoercion(C58661 r3) {
            this();
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/CoerceJavaToLua$IntCoercion.class */
    private static final class IntCoercion implements Coercion {
        private IntCoercion() {
        }

        @Override // org.luaj.vm2.lib.jse.CoerceJavaToLua.Coercion
        public LuaValue coerce(Object obj) {
            return LuaInteger.valueOf(((Number) obj).intValue());
        }

        IntCoercion(C58661 r3) {
            this();
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/CoerceJavaToLua$LuaCoercion.class */
    private static final class LuaCoercion implements Coercion {
        private LuaCoercion() {
        }

        @Override // org.luaj.vm2.lib.jse.CoerceJavaToLua.Coercion
        public LuaValue coerce(Object obj) {
            return (LuaValue) obj;
        }

        LuaCoercion(C58661 r3) {
            this();
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/CoerceJavaToLua$StringCoercion.class */
    private static final class StringCoercion implements Coercion {
        private StringCoercion() {
        }

        @Override // org.luaj.vm2.lib.jse.CoerceJavaToLua.Coercion
        public LuaValue coerce(Object obj) {
            return LuaString.valueOf(obj.toString());
        }

        StringCoercion(C58661 r3) {
            this();
        }
    }

    public static LuaValue coerce(Object obj) {
        if (obj == null) {
            return LuaValue.NIL;
        }
        Class<?> cls = obj.getClass();
        Coercion coercion = (Coercion) COERCIONS.get(cls);
        if (coercion == null) {
            coercion = cls.isArray() ? arrayCoercion : obj instanceof LuaValue ? luaCoercion : instanceCoercion;
            COERCIONS.put(cls, coercion);
        }
        return coercion.coerce(obj);
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    static {
        Class cls;
        Class cls2;
        Class cls3;
        Class cls4;
        Class cls5;
        Class cls6;
        Class cls7;
        Class cls8;
        Class cls9;
        Class cls10;
        Class cls11;
        BoolCoercion boolCoercion = new BoolCoercion(null);
        IntCoercion intCoercion = new IntCoercion(null);
        CharCoercion charCoercion = new CharCoercion(null);
        DoubleCoercion doubleCoercion = new DoubleCoercion(null);
        StringCoercion stringCoercion = new StringCoercion(null);
        BytesCoercion bytesCoercion = new BytesCoercion(null);
        ClassCoercion classCoercion = new ClassCoercion(null);
        Map map = COERCIONS;
        if (class$java$lang$Boolean == null) {
            cls = class$("java.lang.Boolean");
            class$java$lang$Boolean = cls;
        } else {
            cls = class$java$lang$Boolean;
        }
        map.put(cls, boolCoercion);
        Map map2 = COERCIONS;
        if (class$java$lang$Byte == null) {
            cls2 = class$("java.lang.Byte");
            class$java$lang$Byte = cls2;
        } else {
            cls2 = class$java$lang$Byte;
        }
        map2.put(cls2, intCoercion);
        Map map3 = COERCIONS;
        if (class$java$lang$Character == null) {
            cls3 = class$("java.lang.Character");
            class$java$lang$Character = cls3;
        } else {
            cls3 = class$java$lang$Character;
        }
        map3.put(cls3, charCoercion);
        Map map4 = COERCIONS;
        if (class$java$lang$Short == null) {
            cls4 = class$("java.lang.Short");
            class$java$lang$Short = cls4;
        } else {
            cls4 = class$java$lang$Short;
        }
        map4.put(cls4, intCoercion);
        Map map5 = COERCIONS;
        if (class$java$lang$Integer == null) {
            cls5 = class$("java.lang.Integer");
            class$java$lang$Integer = cls5;
        } else {
            cls5 = class$java$lang$Integer;
        }
        map5.put(cls5, intCoercion);
        Map map6 = COERCIONS;
        if (class$java$lang$Long == null) {
            cls6 = class$("java.lang.Long");
            class$java$lang$Long = cls6;
        } else {
            cls6 = class$java$lang$Long;
        }
        map6.put(cls6, doubleCoercion);
        Map map7 = COERCIONS;
        if (class$java$lang$Float == null) {
            cls7 = class$("java.lang.Float");
            class$java$lang$Float = cls7;
        } else {
            cls7 = class$java$lang$Float;
        }
        map7.put(cls7, doubleCoercion);
        Map map8 = COERCIONS;
        if (class$java$lang$Double == null) {
            cls8 = class$("java.lang.Double");
            class$java$lang$Double = cls8;
        } else {
            cls8 = class$java$lang$Double;
        }
        map8.put(cls8, doubleCoercion);
        Map map9 = COERCIONS;
        if (class$java$lang$String == null) {
            cls9 = class$("java.lang.String");
            class$java$lang$String = cls9;
        } else {
            cls9 = class$java$lang$String;
        }
        map9.put(cls9, stringCoercion);
        Map map10 = COERCIONS;
        if (array$B == null) {
            cls10 = class$("[B");
            array$B = cls10;
        } else {
            cls10 = array$B;
        }
        map10.put(cls10, bytesCoercion);
        Map map11 = COERCIONS;
        if (class$java$lang$Class == null) {
            cls11 = class$("java.lang.Class");
            class$java$lang$Class = cls11;
        } else {
            cls11 = class$java$lang$Class;
        }
        map11.put(cls11, classCoercion);
        instanceCoercion = new InstanceCoercion(null);
        arrayCoercion = new ArrayCoercion(null);
        luaCoercion = new LuaCoercion(null);
    }
}
