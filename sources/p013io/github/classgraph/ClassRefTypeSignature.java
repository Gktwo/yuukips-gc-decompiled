package p013io.github.classgraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import nonapi.p019io.github.classgraph.types.ParseException;
import nonapi.p019io.github.classgraph.types.Parser;
import nonapi.p019io.github.classgraph.types.TypeUtils;

/* renamed from: io.github.classgraph.ClassRefTypeSignature */
/* loaded from: grasscutter.jar:io/github/classgraph/ClassRefTypeSignature.class */
public final class ClassRefTypeSignature extends ClassRefOrTypeVariableSignature {
    final String className;
    private String fullyQualifiedClassName;
    private final List<TypeArgument> typeArguments;
    private final List<String> suffixes;
    private final List<List<TypeArgument>> suffixTypeArguments;

    private ClassRefTypeSignature(String className, List<TypeArgument> typeArguments, List<String> suffixes, List<List<TypeArgument>> suffixTypeArguments) {
        this.className = className;
        this.typeArguments = typeArguments;
        this.suffixes = suffixes;
        this.suffixTypeArguments = suffixTypeArguments;
    }

    public String getBaseClassName() {
        return this.className;
    }

    public String getFullyQualifiedClassName() {
        if (this.fullyQualifiedClassName == null) {
            StringBuilder buf = new StringBuilder();
            buf.append(this.className);
            for (String suffix : this.suffixes) {
                buf.append('$');
                buf.append(suffix);
            }
            this.fullyQualifiedClassName = buf.toString();
        }
        return this.fullyQualifiedClassName;
    }

    public List<TypeArgument> getTypeArguments() {
        return this.typeArguments;
    }

    public List<String> getSuffixes() {
        return this.suffixes;
    }

    public List<List<TypeArgument>> getSuffixTypeArguments() {
        return this.suffixTypeArguments;
    }

    @Override // p013io.github.classgraph.ScanResultObject
    public Class<?> loadClass(boolean ignoreExceptions) {
        return loadClass(ignoreExceptions);
    }

    @Override // p013io.github.classgraph.ScanResultObject
    public Class<?> loadClass() {
        return loadClass();
    }

    @Override // p013io.github.classgraph.ScanResultObject
    protected String getClassName() {
        return getFullyQualifiedClassName();
    }

    @Override // p013io.github.classgraph.ScanResultObject
    public ClassInfo getClassInfo() {
        return getClassInfo();
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ScanResultObject
    public void setScanResult(ScanResult scanResult) {
        setScanResult(scanResult);
        if (this.typeArguments != null) {
            for (TypeArgument typeArgument : this.typeArguments) {
                typeArgument.setScanResult(scanResult);
            }
        }
        if (this.suffixTypeArguments != null) {
            for (List<TypeArgument> list : this.suffixTypeArguments) {
                for (TypeArgument typeArgument2 : list) {
                    typeArgument2.setScanResult(scanResult);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // p013io.github.classgraph.TypeSignature
    public void findReferencedClassNames(Set<String> refdClassNames) {
        refdClassNames.add(getFullyQualifiedClassName());
        for (TypeArgument typeArgument : this.typeArguments) {
            typeArgument.findReferencedClassNames(refdClassNames);
        }
    }

    public int hashCode() {
        return this.className.hashCode() + (7 * this.typeArguments.hashCode()) + (15 * this.suffixes.hashCode());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClassRefTypeSignature)) {
            return false;
        }
        ClassRefTypeSignature o = (ClassRefTypeSignature) obj;
        return o.className.equals(this.className) && o.typeArguments.equals(this.typeArguments) && o.suffixes.equals(this.suffixes);
    }

    @Override // p013io.github.classgraph.TypeSignature
    public boolean equalsIgnoringTypeParams(TypeSignature other) {
        if (other instanceof TypeVariableSignature) {
            return other.equalsIgnoringTypeParams(this);
        }
        if (!(other instanceof ClassRefTypeSignature)) {
            return false;
        }
        ClassRefTypeSignature o = (ClassRefTypeSignature) other;
        if (o.suffixes.equals(this.suffixes)) {
            return o.className.equals(this.className);
        }
        return o.getFullyQualifiedClassName().equals(getFullyQualifiedClassName());
    }

    @Override // p013io.github.classgraph.TypeSignature
    protected String toStringInternal(boolean useSimpleNames) {
        StringBuilder buf = new StringBuilder();
        if (!useSimpleNames || this.suffixes.isEmpty()) {
            buf.append(useSimpleNames ? ClassInfo.getSimpleName(this.className) : this.className);
            if (!this.typeArguments.isEmpty()) {
                buf.append('<');
                for (int i = 0; i < this.typeArguments.size(); i++) {
                    if (i > 0) {
                        buf.append(", ");
                    }
                    buf.append(useSimpleNames ? this.typeArguments.get(i).toStringWithSimpleNames() : this.typeArguments.get(i).toString());
                }
                buf.append('>');
            }
        }
        for (int i2 = (!useSimpleNames || this.suffixes.isEmpty()) ? 0 : this.suffixes.size() - 1; i2 < this.suffixes.size(); i2++) {
            if (!useSimpleNames) {
                buf.append('.');
            }
            buf.append(this.suffixes.get(i2));
            List<TypeArgument> suffixTypeArgs = this.suffixTypeArguments.get(i2);
            if (!suffixTypeArgs.isEmpty()) {
                buf.append('<');
                for (int j = 0; j < suffixTypeArgs.size(); j++) {
                    if (j > 0) {
                        buf.append(", ");
                    }
                    buf.append(useSimpleNames ? suffixTypeArgs.get(j).toStringWithSimpleNames() : suffixTypeArgs.get(j).toString());
                }
                buf.append('>');
            }
        }
        return buf.toString();
    }

    /* access modifiers changed from: package-private */
    public static ClassRefTypeSignature parse(Parser parser, String definingClassName) throws ParseException {
        List<List<TypeArgument>> suffixTypeArguments;
        List<String> suffixes;
        if (parser.peek() != 'L') {
            return null;
        }
        parser.next();
        if (!TypeUtils.getIdentifierToken(parser, '/', '.')) {
            throw new ParseException(parser, "Could not parse identifier token");
        }
        String className = parser.currToken();
        List<TypeArgument> typeArguments = TypeArgument.parseList(parser, definingClassName);
        if (parser.peek() == '.') {
            suffixes = new ArrayList<>();
            suffixTypeArguments = new ArrayList<>();
            while (parser.peek() == '.') {
                parser.expect('.');
                if (!TypeUtils.getIdentifierToken(parser, '/', '.')) {
                    throw new ParseException(parser, "Could not parse identifier token");
                }
                suffixes.add(parser.currToken());
                suffixTypeArguments.add(TypeArgument.parseList(parser, definingClassName));
            }
        } else {
            suffixes = Collections.emptyList();
            suffixTypeArguments = Collections.emptyList();
        }
        parser.expect(';');
        return new ClassRefTypeSignature(className, typeArguments, suffixes, suffixTypeArguments);
    }
}
