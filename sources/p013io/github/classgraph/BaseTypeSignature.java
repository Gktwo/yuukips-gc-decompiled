package p013io.github.classgraph;

import java.util.Set;
import nonapi.p019io.github.classgraph.types.Parser;

/* renamed from: io.github.classgraph.BaseTypeSignature */
/* loaded from: grasscutter.jar:io/github/classgraph/BaseTypeSignature.class */
public class BaseTypeSignature extends TypeSignature {
    private final String baseType;
    private final String typeSignatureChar;
    private static final BaseTypeSignature BYTE = new BaseTypeSignature("byte", 'B');
    private static final BaseTypeSignature CHAR = new BaseTypeSignature("char", 'C');
    private static final BaseTypeSignature DOUBLE = new BaseTypeSignature("double", 'D');
    private static final BaseTypeSignature FLOAT = new BaseTypeSignature("float", 'F');
    private static final BaseTypeSignature INT = new BaseTypeSignature("int", 'I');
    private static final BaseTypeSignature LONG = new BaseTypeSignature("long", 'J');
    private static final BaseTypeSignature SHORT = new BaseTypeSignature("short", 'S');
    private static final BaseTypeSignature BOOLEAN = new BaseTypeSignature("boolean", 'Z');
    static final BaseTypeSignature VOID = new BaseTypeSignature("void", 'V');

    private BaseTypeSignature(String baseType, char typeSignatureChar) {
        this.baseType = baseType;
        this.typeSignatureChar = Character.toString(typeSignatureChar);
    }

    public String getTypeStr() {
        return this.baseType;
    }

    public String getTypeSignatureChar() {
        return this.typeSignatureChar;
    }

    public Class<?> getType() {
        String str = this.baseType;
        char c = 65535;
        switch (str.hashCode()) {
            case -1325958191:
                if (str.equals("double")) {
                    c = 2;
                    break;
                }
                break;
            case 104431:
                if (str.equals("int")) {
                    c = 4;
                    break;
                }
                break;
            case 3039496:
                if (str.equals("byte")) {
                    c = 0;
                    break;
                }
                break;
            case 3052374:
                if (str.equals("char")) {
                    c = 1;
                    break;
                }
                break;
            case 3327612:
                if (str.equals("long")) {
                    c = 5;
                    break;
                }
                break;
            case 3625364:
                if (str.equals("void")) {
                    c = '\b';
                    break;
                }
                break;
            case 64711720:
                if (str.equals("boolean")) {
                    c = 7;
                    break;
                }
                break;
            case 97526364:
                if (str.equals("float")) {
                    c = 3;
                    break;
                }
                break;
            case 109413500:
                if (str.equals("short")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return Byte.TYPE;
            case 1:
                return Character.TYPE;
            case 2:
                return Double.TYPE;
            case 3:
                return Float.TYPE;
            case 4:
                return Integer.TYPE;
            case 5:
                return Long.TYPE;
            case 6:
                return Short.TYPE;
            case 7:
                return Boolean.TYPE;
            case '\b':
                return Void.TYPE;
            default:
                throw new IllegalArgumentException("Unknown base type " + this.baseType);
        }
    }

    public static BaseTypeSignature getTypeSignature(String typeName) {
        char c = 65535;
        switch (typeName.hashCode()) {
            case -1325958191:
                if (typeName.equals("double")) {
                    c = 2;
                    break;
                }
                break;
            case 104431:
                if (typeName.equals("int")) {
                    c = 4;
                    break;
                }
                break;
            case 3039496:
                if (typeName.equals("byte")) {
                    c = 0;
                    break;
                }
                break;
            case 3052374:
                if (typeName.equals("char")) {
                    c = 1;
                    break;
                }
                break;
            case 3327612:
                if (typeName.equals("long")) {
                    c = 5;
                    break;
                }
                break;
            case 3625364:
                if (typeName.equals("void")) {
                    c = '\b';
                    break;
                }
                break;
            case 64711720:
                if (typeName.equals("boolean")) {
                    c = 7;
                    break;
                }
                break;
            case 97526364:
                if (typeName.equals("float")) {
                    c = 3;
                    break;
                }
                break;
            case 109413500:
                if (typeName.equals("short")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return BYTE;
            case 1:
                return CHAR;
            case 2:
                return DOUBLE;
            case 3:
                return FLOAT;
            case 4:
                return INT;
            case 5:
                return LONG;
            case 6:
                return SHORT;
            case 7:
                return BOOLEAN;
            case '\b':
                return VOID;
            default:
                return null;
        }
    }

    @Override // p013io.github.classgraph.ScanResultObject
    Class<?> loadClass() {
        return getType();
    }

    @Override // p013io.github.classgraph.ScanResultObject
    <T> Class<T> loadClass(Class<T> superclassOrInterfaceType) {
        Class<T> cls = (Class<T>) getType();
        if (superclassOrInterfaceType.isAssignableFrom(cls)) {
            return cls;
        }
        throw new IllegalArgumentException("Primitive class " + this.baseType + " cannot be cast to " + superclassOrInterfaceType.getName());
    }

    /* access modifiers changed from: package-private */
    public static BaseTypeSignature parse(Parser parser) {
        switch (parser.peek()) {
            case 'B':
                parser.next();
                return BYTE;
            case 'C':
                parser.next();
                return CHAR;
            case 'D':
                parser.next();
                return DOUBLE;
            case 'E':
            case 'G':
            case 'H':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'T':
            case 'U':
            case 'W':
            case 'X':
            case 'Y':
            default:
                return null;
            case 'F':
                parser.next();
                return FLOAT;
            case 'I':
                parser.next();
                return INT;
            case 'J':
                parser.next();
                return LONG;
            case 'S':
                parser.next();
                return SHORT;
            case 'V':
                parser.next();
                return VOID;
            case 'Z':
                parser.next();
                return BOOLEAN;
        }
    }

    @Override // p013io.github.classgraph.ScanResultObject
    protected String getClassName() {
        return this.baseType;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.github.classgraph.ScanResultObject
    public ClassInfo getClassInfo() {
        return null;
    }

    @Override // p013io.github.classgraph.TypeSignature
    protected void findReferencedClassNames(Set<String> refdClassNames) {
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ScanResultObject
    public void setScanResult(ScanResult scanResult) {
    }

    public int hashCode() {
        return this.baseType.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BaseTypeSignature)) {
            return false;
        }
        return ((BaseTypeSignature) obj).baseType.equals(this.baseType);
    }

    @Override // p013io.github.classgraph.TypeSignature
    public boolean equalsIgnoringTypeParams(TypeSignature other) {
        if (!(other instanceof BaseTypeSignature)) {
            return false;
        }
        return this.baseType.equals(((BaseTypeSignature) other).baseType);
    }

    @Override // p013io.github.classgraph.TypeSignature
    protected String toStringInternal(boolean useSimpleNames) {
        return this.baseType;
    }
}
