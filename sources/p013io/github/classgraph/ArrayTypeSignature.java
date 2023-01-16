package p013io.github.classgraph;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.Set;
import nonapi.p019io.github.classgraph.types.ParseException;
import nonapi.p019io.github.classgraph.types.Parser;
import okhttp3.HttpUrl;

/* renamed from: io.github.classgraph.ArrayTypeSignature */
/* loaded from: grasscutter.jar:io/github/classgraph/ArrayTypeSignature.class */
public class ArrayTypeSignature extends ReferenceTypeSignature {
    private final TypeSignature elementTypeSignature;
    private final int numDims;
    private final String typeSignatureStr;
    private String className;
    private ArrayClassInfo arrayClassInfo;
    private Class<?> elementClassRef;

    /* access modifiers changed from: package-private */
    public ArrayTypeSignature(TypeSignature elementTypeSignature, int numDims, String typeSignatureStr) {
        this.elementTypeSignature = elementTypeSignature;
        this.numDims = numDims;
        this.typeSignatureStr = typeSignatureStr;
    }

    /* access modifiers changed from: package-private */
    public ArrayTypeSignature(String eltClassName, int numDims) {
        String eltTypeSigStr;
        BaseTypeSignature baseTypeSignature = BaseTypeSignature.getTypeSignature(eltClassName);
        if (baseTypeSignature != null) {
            eltTypeSigStr = baseTypeSignature.getTypeSignatureChar();
            this.elementTypeSignature = baseTypeSignature;
        } else {
            eltTypeSigStr = "L" + eltClassName.replace('.', '/') + ";";
            try {
                this.elementTypeSignature = ClassRefTypeSignature.parse(new Parser(eltTypeSigStr), (String) null);
                if (this.elementTypeSignature == null) {
                    throw new IllegalArgumentException("Could not form array base type signature for class " + eltClassName);
                }
            } catch (ParseException e) {
                throw new IllegalArgumentException("Could not form array base type signature for class " + eltClassName);
            }
        }
        StringBuilder buf = new StringBuilder(numDims + eltTypeSigStr.length());
        for (int i = 0; i < numDims; i++) {
            buf.append('[');
        }
        buf.append(eltTypeSigStr);
        this.typeSignatureStr = buf.toString();
        this.numDims = numDims;
    }

    public String getTypeSignatureStr() {
        return this.typeSignatureStr;
    }

    public TypeSignature getElementTypeSignature() {
        return this.elementTypeSignature;
    }

    public int getNumDimensions() {
        return this.numDims;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.github.classgraph.ScanResultObject
    public String getClassName() {
        if (this.className == null) {
            this.className = toStringInternal(false);
        }
        return this.className;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.github.classgraph.ScanResultObject
    public ClassInfo getClassInfo() {
        return getArrayClassInfo();
    }

    public ArrayClassInfo getArrayClassInfo() {
        if (this.arrayClassInfo == null) {
            if (this.scanResult != null) {
                String clsName = getClassName();
                this.arrayClassInfo = (ArrayClassInfo) this.scanResult.classNameToClassInfo.get(clsName);
                if (this.arrayClassInfo == null) {
                    Map<String, ClassInfo> map = this.scanResult.classNameToClassInfo;
                    ArrayClassInfo arrayClassInfo = new ArrayClassInfo(this);
                    this.arrayClassInfo = arrayClassInfo;
                    map.put(clsName, arrayClassInfo);
                    this.arrayClassInfo.setScanResult(this.scanResult);
                }
            } else {
                this.arrayClassInfo = new ArrayClassInfo(this);
            }
        }
        return this.arrayClassInfo;
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ScanResultObject
    public void setScanResult(ScanResult scanResult) {
        setScanResult(scanResult);
        if (this.elementTypeSignature != null) {
            this.elementTypeSignature.setScanResult(scanResult);
        }
        if (this.arrayClassInfo != null) {
            this.arrayClassInfo.setScanResult(scanResult);
        }
    }

    @Override // p013io.github.classgraph.TypeSignature
    protected void findReferencedClassNames(Set<String> refdClassNames) {
        this.elementTypeSignature.findReferencedClassNames(refdClassNames);
    }

    public Class<?> loadElementClass(boolean ignoreExceptions) {
        IllegalArgumentException illegalArgumentException;
        if (this.elementClassRef == null) {
            if (this.elementTypeSignature instanceof BaseTypeSignature) {
                this.elementClassRef = ((BaseTypeSignature) this.elementTypeSignature).getType();
            } else if (this.scanResult != null) {
                this.elementClassRef = this.elementTypeSignature.loadClass(ignoreExceptions);
            } else {
                String elementTypeName = ((ClassRefTypeSignature) this.elementTypeSignature).getFullyQualifiedClassName();
                try {
                    this.elementClassRef = Class.forName(elementTypeName);
                } finally {
                    if (!ignoreExceptions) {
                    }
                }
            }
        }
        return this.elementClassRef;
    }

    public Class<?> loadElementClass() {
        return loadElementClass(false);
    }

    @Override // p013io.github.classgraph.ScanResultObject
    public Class<?> loadClass(boolean ignoreExceptions) {
        Class<?> eltClassRef;
        if (this.classRef == null) {
            if (ignoreExceptions) {
                try {
                    eltClassRef = loadElementClass();
                } catch (IllegalArgumentException e) {
                    return null;
                }
            } else {
                eltClassRef = loadElementClass();
            }
            if (eltClassRef == null) {
                throw new IllegalArgumentException("Could not load array element class " + this.elementTypeSignature);
            }
            this.classRef = Array.newInstance(eltClassRef, new int[this.numDims]).getClass();
        }
        return this.classRef;
    }

    @Override // p013io.github.classgraph.ScanResultObject
    public Class<?> loadClass() {
        return loadClass(false);
    }

    public int hashCode() {
        return this.elementTypeSignature.hashCode() + (this.numDims * 15);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ArrayTypeSignature)) {
            return false;
        }
        ArrayTypeSignature other = (ArrayTypeSignature) obj;
        return other.elementTypeSignature.equals(this.elementTypeSignature) && other.numDims == this.numDims;
    }

    @Override // p013io.github.classgraph.TypeSignature
    public boolean equalsIgnoringTypeParams(TypeSignature other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArrayTypeSignature)) {
            return false;
        }
        ArrayTypeSignature o = (ArrayTypeSignature) other;
        return o.elementTypeSignature.equalsIgnoringTypeParams(this.elementTypeSignature) && o.numDims == this.numDims;
    }

    @Override // p013io.github.classgraph.TypeSignature
    protected String toStringInternal(boolean useSimpleNames) {
        StringBuilder buf = new StringBuilder();
        buf.append(useSimpleNames ? this.elementTypeSignature.toStringWithSimpleNames() : this.elementTypeSignature.toString());
        for (int i = 0; i < this.numDims; i++) {
            buf.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        return buf.toString();
    }

    /* access modifiers changed from: package-private */
    public static ArrayTypeSignature parse(Parser parser, String definingClassName) throws ParseException {
        int numArrayDims = 0;
        int begin = parser.getPosition();
        while (parser.peek() == '[') {
            numArrayDims++;
            parser.next();
        }
        if (numArrayDims <= 0) {
            return null;
        }
        TypeSignature elementTypeSignature = TypeSignature.parse(parser, definingClassName);
        if (elementTypeSignature != null) {
            return new ArrayTypeSignature(elementTypeSignature, numArrayDims, parser.getSubsequence(begin, parser.getPosition()).toString());
        }
        throw new ParseException(parser, "elementTypeSignature == null");
    }
}
