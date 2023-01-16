package org.luaj.vm2.lib.jse;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaValue;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/CoerceLuaToJava.class */
public class CoerceLuaToJava {
    static int SCORE_NULL_VALUE = 16;
    static int SCORE_WRONG_TYPE = 256;
    static int SCORE_UNCOERCIBLE = 65536;
    static final Map COERCIONS = Collections.synchronizedMap(new HashMap());
    static Class class$java$lang$Integer;
    static Class class$java$lang$Double;
    static Class class$java$lang$Boolean;
    static Class class$java$lang$String;
    static Class class$java$lang$Byte;
    static Class class$java$lang$Character;
    static Class class$java$lang$Short;
    static Class class$java$lang$Long;
    static Class class$java$lang$Float;
    static Class array$B;

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/CoerceLuaToJava$ArrayCoercion.class */
    public static final class ArrayCoercion implements Coercion {
        final Class componentType;
        final Coercion componentCoercion;

        public ArrayCoercion(Class cls) {
            this.componentType = cls;
            this.componentCoercion = CoerceLuaToJava.getCoercion(cls);
        }

        public String toString() {
            return new StringBuffer().append("ArrayCoercion(").append(this.componentType.getName()).append(")").toString();
        }

        @Override // org.luaj.vm2.lib.jse.CoerceLuaToJava.Coercion
        public int score(LuaValue luaValue) {
            switch (luaValue.type()) {
                case 0:
                    return CoerceLuaToJava.SCORE_NULL_VALUE;
                case 5:
                    if (luaValue.length() == 0) {
                        return 0;
                    }
                    return this.componentCoercion.score(luaValue.get(1));
                case 7:
                    return CoerceLuaToJava.inheritanceLevels(this.componentType, luaValue.touserdata().getClass().getComponentType());
                default:
                    return CoerceLuaToJava.SCORE_UNCOERCIBLE;
            }
        }

        @Override // org.luaj.vm2.lib.jse.CoerceLuaToJava.Coercion
        public Object coerce(LuaValue luaValue) {
            switch (luaValue.type()) {
                case 0:
                    return null;
                case 5:
                    int length = luaValue.length();
                    Object newInstance = Array.newInstance(this.componentType, length);
                    for (int i = 0; i < length; i++) {
                        Array.set(newInstance, i, this.componentCoercion.coerce(luaValue.get(i + 1)));
                    }
                    return newInstance;
                case 7:
                    return luaValue.touserdata();
                default:
                    return null;
            }
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/CoerceLuaToJava$BoolCoercion.class */
    static final class BoolCoercion implements Coercion {
        BoolCoercion() {
        }

        public String toString() {
            return "BoolCoercion()";
        }

        @Override // org.luaj.vm2.lib.jse.CoerceLuaToJava.Coercion
        public int score(LuaValue luaValue) {
            switch (luaValue.type()) {
                case 1:
                    return 0;
                default:
                    return 1;
            }
        }

        @Override // org.luaj.vm2.lib.jse.CoerceLuaToJava.Coercion
        public Object coerce(LuaValue luaValue) {
            return luaValue.toboolean() ? Boolean.TRUE : Boolean.FALSE;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/CoerceLuaToJava$Coercion.class */
    public interface Coercion {
        int score(LuaValue luaValue);

        Object coerce(LuaValue luaValue);
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/CoerceLuaToJava$NumericCoercion.class */
    static final class NumericCoercion implements Coercion {
        static final int TARGET_TYPE_BYTE = 0;
        static final int TARGET_TYPE_CHAR = 1;
        static final int TARGET_TYPE_SHORT = 2;
        static final int TARGET_TYPE_INT = 3;
        static final int TARGET_TYPE_LONG = 4;
        static final int TARGET_TYPE_FLOAT = 5;
        static final int TARGET_TYPE_DOUBLE = 6;
        static final String[] TYPE_NAMES = {"byte", "char", "short", "int", "long", "float", "double"};
        final int targetType;

        public String toString() {
            return new StringBuffer().append("NumericCoercion(").append(TYPE_NAMES[this.targetType]).append(")").toString();
        }

        NumericCoercion(int i) {
            this.targetType = i;
        }

        @Override // org.luaj.vm2.lib.jse.CoerceLuaToJava.Coercion
        public int score(LuaValue luaValue) {
            int i = 0;
            if (luaValue.type() == 4) {
                luaValue = luaValue.tonumber();
                if (luaValue.isnil()) {
                    return CoerceLuaToJava.SCORE_UNCOERCIBLE;
                }
                i = 4;
            }
            if (luaValue.isint()) {
                switch (this.targetType) {
                    case 0:
                        int i2 = luaValue.toint();
                        return i + (i2 == ((byte) i2) ? 0 : CoerceLuaToJava.SCORE_WRONG_TYPE);
                    case 1:
                        int i3 = luaValue.toint();
                        return i + (i3 == ((byte) i3) ? 1 : i3 == ((char) i3) ? 0 : CoerceLuaToJava.SCORE_WRONG_TYPE);
                    case 2:
                        int i4 = luaValue.toint();
                        return i + (i4 == ((byte) i4) ? 1 : i4 == ((short) i4) ? 0 : CoerceLuaToJava.SCORE_WRONG_TYPE);
                    case 3:
                        int i5 = luaValue.toint();
                        return i + (i5 == ((byte) i5) ? 2 : (i5 == ((char) i5) || i5 == ((short) i5)) ? 1 : 0);
                    case 4:
                        return i + 1;
                    case 5:
                        return i + 1;
                    case 6:
                        return i + 2;
                    default:
                        return CoerceLuaToJava.SCORE_WRONG_TYPE;
                }
            } else if (!luaValue.isnumber()) {
                return CoerceLuaToJava.SCORE_UNCOERCIBLE;
            } else {
                switch (this.targetType) {
                    case 0:
                        return CoerceLuaToJava.SCORE_WRONG_TYPE;
                    case 1:
                        return CoerceLuaToJava.SCORE_WRONG_TYPE;
                    case 2:
                        return CoerceLuaToJava.SCORE_WRONG_TYPE;
                    case 3:
                        return CoerceLuaToJava.SCORE_WRONG_TYPE;
                    case 4:
                        double d = luaValue.todouble();
                        return i + (d == ((double) ((long) d)) ? 0 : CoerceLuaToJava.SCORE_WRONG_TYPE);
                    case 5:
                        double d2 = luaValue.todouble();
                        return i + (d2 == ((double) ((float) d2)) ? 0 : CoerceLuaToJava.SCORE_WRONG_TYPE);
                    case 6:
                        double d3 = luaValue.todouble();
                        return i + ((d3 == ((double) ((long) d3)) || d3 == ((double) ((float) d3))) ? 1 : 0);
                    default:
                        return CoerceLuaToJava.SCORE_WRONG_TYPE;
                }
            }
        }

        @Override // org.luaj.vm2.lib.jse.CoerceLuaToJava.Coercion
        public Object coerce(LuaValue luaValue) {
            switch (this.targetType) {
                case 0:
                    return new Byte((byte) luaValue.toint());
                case 1:
                    return new Character((char) luaValue.toint());
                case 2:
                    return new Short((short) luaValue.toint());
                case 3:
                    return new Integer(luaValue.toint());
                case 4:
                    return new Long((long) luaValue.todouble());
                case 5:
                    return new Float((float) luaValue.todouble());
                case 6:
                    return new Double(luaValue.todouble());
                default:
                    return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/CoerceLuaToJava$ObjectCoercion.class */
    public static final class ObjectCoercion implements Coercion {
        final Class targetType;

        ObjectCoercion(Class cls) {
            this.targetType = cls;
        }

        public String toString() {
            return new StringBuffer().append("ObjectCoercion(").append(this.targetType.getName()).append(")").toString();
        }

        @Override // org.luaj.vm2.lib.jse.CoerceLuaToJava.Coercion
        public int score(LuaValue luaValue) {
            Class cls;
            Class cls2;
            Class cls3;
            switch (luaValue.type()) {
                case 0:
                    return CoerceLuaToJava.SCORE_NULL_VALUE;
                case 1:
                    Class cls4 = this.targetType;
                    if (CoerceLuaToJava.class$java$lang$Boolean == null) {
                        cls2 = CoerceLuaToJava.class$("java.lang.Boolean");
                        CoerceLuaToJava.class$java$lang$Boolean = cls2;
                    } else {
                        cls2 = CoerceLuaToJava.class$java$lang$Boolean;
                    }
                    return CoerceLuaToJava.inheritanceLevels(cls4, cls2);
                case 2:
                case 5:
                case 6:
                default:
                    return CoerceLuaToJava.inheritanceLevels(this.targetType, luaValue.getClass());
                case 3:
                    Class cls5 = this.targetType;
                    if (luaValue.isint()) {
                        if (CoerceLuaToJava.class$java$lang$Integer == null) {
                            cls3 = CoerceLuaToJava.class$("java.lang.Integer");
                            CoerceLuaToJava.class$java$lang$Integer = cls3;
                        } else {
                            cls3 = CoerceLuaToJava.class$java$lang$Integer;
                        }
                    } else if (CoerceLuaToJava.class$java$lang$Double == null) {
                        cls3 = CoerceLuaToJava.class$("java.lang.Double");
                        CoerceLuaToJava.class$java$lang$Double = cls3;
                    } else {
                        cls3 = CoerceLuaToJava.class$java$lang$Double;
                    }
                    return CoerceLuaToJava.inheritanceLevels(cls5, cls3);
                case 4:
                    Class cls6 = this.targetType;
                    if (CoerceLuaToJava.class$java$lang$String == null) {
                        cls = CoerceLuaToJava.class$("java.lang.String");
                        CoerceLuaToJava.class$java$lang$String = cls;
                    } else {
                        cls = CoerceLuaToJava.class$java$lang$String;
                    }
                    return CoerceLuaToJava.inheritanceLevels(cls6, cls);
                case 7:
                    return CoerceLuaToJava.inheritanceLevels(this.targetType, luaValue.touserdata().getClass());
            }
        }

        @Override // org.luaj.vm2.lib.jse.CoerceLuaToJava.Coercion
        public Object coerce(LuaValue luaValue) {
            switch (luaValue.type()) {
                case 0:
                    return null;
                case 1:
                    return luaValue.toboolean() ? Boolean.TRUE : Boolean.FALSE;
                case 2:
                case 5:
                case 6:
                default:
                    return luaValue;
                case 3:
                    return luaValue.isint() ? new Integer(luaValue.toint()) : new Double(luaValue.todouble());
                case 4:
                    return luaValue.tojstring();
                case 7:
                    return luaValue.optuserdata(this.targetType, (Object) null);
            }
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/CoerceLuaToJava$StringCoercion.class */
    static final class StringCoercion implements Coercion {
        public static final int TARGET_TYPE_STRING = 0;
        public static final int TARGET_TYPE_BYTES = 1;
        final int targetType;

        public StringCoercion(int i) {
            this.targetType = i;
        }

        public String toString() {
            return new StringBuffer().append("StringCoercion(").append(this.targetType == 0 ? "String" : "byte[]").append(")").toString();
        }

        @Override // org.luaj.vm2.lib.jse.CoerceLuaToJava.Coercion
        public int score(LuaValue luaValue) {
            switch (luaValue.type()) {
                case 0:
                    return CoerceLuaToJava.SCORE_NULL_VALUE;
                case 4:
                    if (luaValue.checkstring().isValidUtf8()) {
                        return this.targetType == 0 ? 0 : 1;
                    }
                    if (this.targetType == 1) {
                        return 0;
                    }
                    return CoerceLuaToJava.SCORE_WRONG_TYPE;
                default:
                    return this.targetType == 0 ? CoerceLuaToJava.SCORE_WRONG_TYPE : CoerceLuaToJava.SCORE_UNCOERCIBLE;
            }
        }

        @Override // org.luaj.vm2.lib.jse.CoerceLuaToJava.Coercion
        public Object coerce(LuaValue luaValue) {
            if (luaValue.isnil()) {
                return null;
            }
            if (this.targetType == 0) {
                return luaValue.tojstring();
            }
            LuaString checkstring = luaValue.checkstring();
            byte[] bArr = new byte[checkstring.m_length];
            checkstring.copyInto(0, bArr, 0, bArr.length);
            return bArr;
        }
    }

    public static Object coerce(LuaValue luaValue, Class cls) {
        return getCoercion(cls).coerce(luaValue);
    }

    static final int inheritanceLevels(Class cls, Class cls2) {
        if (cls2 == null) {
            return SCORE_UNCOERCIBLE;
        }
        if (cls == cls2) {
            return 0;
        }
        int min = Math.min(SCORE_UNCOERCIBLE, inheritanceLevels(cls, cls2.getSuperclass()) + 1);
        for (Class<?> cls3 : cls2.getInterfaces()) {
            min = Math.min(min, inheritanceLevels(cls, cls3) + 1);
        }
        return min;
    }

    /* access modifiers changed from: package-private */
    public static Coercion getCoercion(Class cls) {
        Coercion coercion;
        Coercion coercion2 = (Coercion) COERCIONS.get(cls);
        if (coercion2 != null) {
            return coercion2;
        }
        if (cls.isArray()) {
            cls.getComponentType();
            coercion = new ArrayCoercion(cls.getComponentType());
        } else {
            coercion = new ObjectCoercion(cls);
        }
        COERCIONS.put(cls, coercion);
        return coercion;
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
        BoolCoercion boolCoercion = new BoolCoercion();
        NumericCoercion numericCoercion = new NumericCoercion(0);
        NumericCoercion numericCoercion2 = new NumericCoercion(1);
        NumericCoercion numericCoercion3 = new NumericCoercion(2);
        NumericCoercion numericCoercion4 = new NumericCoercion(3);
        NumericCoercion numericCoercion5 = new NumericCoercion(4);
        NumericCoercion numericCoercion6 = new NumericCoercion(5);
        NumericCoercion numericCoercion7 = new NumericCoercion(6);
        StringCoercion stringCoercion = new StringCoercion(0);
        StringCoercion stringCoercion2 = new StringCoercion(1);
        COERCIONS.put(Boolean.TYPE, boolCoercion);
        Map map = COERCIONS;
        if (class$java$lang$Boolean == null) {
            cls = class$("java.lang.Boolean");
            class$java$lang$Boolean = cls;
        } else {
            cls = class$java$lang$Boolean;
        }
        map.put(cls, boolCoercion);
        COERCIONS.put(Byte.TYPE, numericCoercion);
        Map map2 = COERCIONS;
        if (class$java$lang$Byte == null) {
            cls2 = class$("java.lang.Byte");
            class$java$lang$Byte = cls2;
        } else {
            cls2 = class$java$lang$Byte;
        }
        map2.put(cls2, numericCoercion);
        COERCIONS.put(Character.TYPE, numericCoercion2);
        Map map3 = COERCIONS;
        if (class$java$lang$Character == null) {
            cls3 = class$("java.lang.Character");
            class$java$lang$Character = cls3;
        } else {
            cls3 = class$java$lang$Character;
        }
        map3.put(cls3, numericCoercion2);
        COERCIONS.put(Short.TYPE, numericCoercion3);
        Map map4 = COERCIONS;
        if (class$java$lang$Short == null) {
            cls4 = class$("java.lang.Short");
            class$java$lang$Short = cls4;
        } else {
            cls4 = class$java$lang$Short;
        }
        map4.put(cls4, numericCoercion3);
        COERCIONS.put(Integer.TYPE, numericCoercion4);
        Map map5 = COERCIONS;
        if (class$java$lang$Integer == null) {
            cls5 = class$("java.lang.Integer");
            class$java$lang$Integer = cls5;
        } else {
            cls5 = class$java$lang$Integer;
        }
        map5.put(cls5, numericCoercion4);
        COERCIONS.put(Long.TYPE, numericCoercion5);
        Map map6 = COERCIONS;
        if (class$java$lang$Long == null) {
            cls6 = class$("java.lang.Long");
            class$java$lang$Long = cls6;
        } else {
            cls6 = class$java$lang$Long;
        }
        map6.put(cls6, numericCoercion5);
        COERCIONS.put(Float.TYPE, numericCoercion6);
        Map map7 = COERCIONS;
        if (class$java$lang$Float == null) {
            cls7 = class$("java.lang.Float");
            class$java$lang$Float = cls7;
        } else {
            cls7 = class$java$lang$Float;
        }
        map7.put(cls7, numericCoercion6);
        COERCIONS.put(Double.TYPE, numericCoercion7);
        Map map8 = COERCIONS;
        if (class$java$lang$Double == null) {
            cls8 = class$("java.lang.Double");
            class$java$lang$Double = cls8;
        } else {
            cls8 = class$java$lang$Double;
        }
        map8.put(cls8, numericCoercion7);
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
        map10.put(cls10, stringCoercion2);
    }
}
