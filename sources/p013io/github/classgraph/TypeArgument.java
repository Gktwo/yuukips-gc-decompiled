package p013io.github.classgraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import nonapi.p019io.github.classgraph.types.ParseException;
import nonapi.p019io.github.classgraph.types.Parser;

/* renamed from: io.github.classgraph.TypeArgument */
/* loaded from: grasscutter.jar:io/github/classgraph/TypeArgument.class */
public final class TypeArgument extends HierarchicalTypeSignature {
    private final Wildcard wildcard;
    private final ReferenceTypeSignature typeSignature;

    /* renamed from: io.github.classgraph.TypeArgument$Wildcard */
    /* loaded from: grasscutter.jar:io/github/classgraph/TypeArgument$Wildcard.class */
    public enum Wildcard {
        NONE,
        ANY,
        EXTENDS,
        SUPER
    }

    private TypeArgument(Wildcard wildcard, ReferenceTypeSignature typeSignature) {
        this.wildcard = wildcard;
        this.typeSignature = typeSignature;
    }

    public Wildcard getWildcard() {
        return this.wildcard;
    }

    public ReferenceTypeSignature getTypeSignature() {
        return this.typeSignature;
    }

    private static TypeArgument parse(Parser parser, String definingClassName) throws ParseException {
        char peek = parser.peek();
        if (peek == '*') {
            parser.expect('*');
            return new TypeArgument(Wildcard.ANY, null);
        } else if (peek == '+') {
            parser.expect('+');
            ReferenceTypeSignature typeSignature = ReferenceTypeSignature.parseReferenceTypeSignature(parser, definingClassName);
            if (typeSignature != null) {
                return new TypeArgument(Wildcard.EXTENDS, typeSignature);
            }
            throw new ParseException(parser, "Missing '+' type bound");
        } else if (peek == '-') {
            parser.expect('-');
            ReferenceTypeSignature typeSignature2 = ReferenceTypeSignature.parseReferenceTypeSignature(parser, definingClassName);
            if (typeSignature2 != null) {
                return new TypeArgument(Wildcard.SUPER, typeSignature2);
            }
            throw new ParseException(parser, "Missing '-' type bound");
        } else {
            ReferenceTypeSignature typeSignature3 = ReferenceTypeSignature.parseReferenceTypeSignature(parser, definingClassName);
            if (typeSignature3 != null) {
                return new TypeArgument(Wildcard.NONE, typeSignature3);
            }
            throw new ParseException(parser, "Missing type bound");
        }
    }

    /* access modifiers changed from: package-private */
    public static List<TypeArgument> parseList(Parser parser, String definingClassName) throws ParseException {
        if (parser.peek() != '<') {
            return Collections.emptyList();
        }
        parser.expect('<');
        List<TypeArgument> typeArguments = new ArrayList<>(2);
        while (parser.peek() != '>') {
            if (!parser.hasMore()) {
                throw new ParseException(parser, "Missing '>'");
            }
            typeArguments.add(parse(parser, definingClassName));
        }
        parser.expect('>');
        return typeArguments;
    }

    @Override // p013io.github.classgraph.ScanResultObject
    protected String getClassName() {
        throw new IllegalArgumentException("getClassName() cannot be called here");
    }

    /* access modifiers changed from: protected */
    @Override // p013io.github.classgraph.ScanResultObject
    public ClassInfo getClassInfo() {
        throw new IllegalArgumentException("getClassInfo() cannot be called here");
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ScanResultObject
    public void setScanResult(ScanResult scanResult) {
        setScanResult(scanResult);
        if (this.typeSignature != null) {
            this.typeSignature.setScanResult(scanResult);
        }
    }

    public void findReferencedClassNames(Set<String> refdClassNames) {
        if (this.typeSignature != null) {
            this.typeSignature.findReferencedClassNames(refdClassNames);
        }
    }

    public int hashCode() {
        return this.typeSignature.hashCode() + (7 * this.wildcard.hashCode());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TypeArgument)) {
            return false;
        }
        TypeArgument o = (TypeArgument) obj;
        return o.typeSignature.equals(this.typeSignature) && o.wildcard.equals(this.wildcard);
    }

    private String toStringInternal(boolean useSimpleNames) {
        switch (this.wildcard) {
            case ANY:
                return "?";
            case EXTENDS:
                String typeSigStr = this.typeSignature.toString();
                return typeSigStr.equals("java.lang.Object") ? "?" : "? extends " + typeSigStr;
            case SUPER:
                return "? super " + this.typeSignature.toString();
            case NONE:
                return useSimpleNames ? this.typeSignature.toStringWithSimpleNames() : this.typeSignature.toString();
            default:
                throw ClassGraphException.newClassGraphException("Unknown wildcard type " + this.wildcard);
        }
    }

    public String toStringWithSimpleNames() {
        return toStringInternal(true);
    }

    public String toString() {
        return toStringInternal(false);
    }
}
