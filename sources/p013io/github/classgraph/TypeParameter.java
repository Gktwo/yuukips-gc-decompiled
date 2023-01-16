package p013io.github.classgraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import nonapi.p019io.github.classgraph.types.ParseException;
import nonapi.p019io.github.classgraph.types.Parser;
import nonapi.p019io.github.classgraph.types.TypeUtils;

/* renamed from: io.github.classgraph.TypeParameter */
/* loaded from: grasscutter.jar:io/github/classgraph/TypeParameter.class */
public final class TypeParameter extends HierarchicalTypeSignature {
    final String name;
    final ReferenceTypeSignature classBound;
    final List<ReferenceTypeSignature> interfaceBounds;

    private TypeParameter(String identifier, ReferenceTypeSignature classBound, List<ReferenceTypeSignature> interfaceBounds) {
        this.name = identifier;
        this.classBound = classBound;
        this.interfaceBounds = interfaceBounds;
    }

    public String getName() {
        return this.name;
    }

    public ReferenceTypeSignature getClassBound() {
        return this.classBound;
    }

    public List<ReferenceTypeSignature> getInterfaceBounds() {
        return this.interfaceBounds;
    }

    /* access modifiers changed from: package-private */
    public static List<TypeParameter> parseList(Parser parser, String definingClassName) throws ParseException {
        List<ReferenceTypeSignature> interfaceBounds;
        if (parser.peek() != '<') {
            return Collections.emptyList();
        }
        parser.expect('<');
        List<TypeParameter> typeParams = new ArrayList<>(1);
        while (parser.peek() != '>') {
            if (!parser.hasMore()) {
                throw new ParseException(parser, "Missing '>'");
            } else if (!TypeUtils.getIdentifierToken(parser)) {
                throw new ParseException(parser, "Could not parse identifier token");
            } else {
                String identifier = parser.currToken();
                ReferenceTypeSignature classBound = ReferenceTypeSignature.parseClassBound(parser, definingClassName);
                if (parser.peek() == ':') {
                    interfaceBounds = new ArrayList<>();
                    while (parser.peek() == ':') {
                        parser.expect(':');
                        ReferenceTypeSignature interfaceTypeSignature = ReferenceTypeSignature.parseReferenceTypeSignature(parser, definingClassName);
                        if (interfaceTypeSignature == null) {
                            throw new ParseException(parser, "Missing interface type signature");
                        }
                        interfaceBounds.add(interfaceTypeSignature);
                    }
                    continue;
                } else {
                    interfaceBounds = Collections.emptyList();
                }
                typeParams.add(new TypeParameter(identifier, classBound, interfaceBounds));
            }
        }
        parser.expect('>');
        return typeParams;
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
        if (this.classBound != null) {
            this.classBound.setScanResult(scanResult);
        }
        if (this.interfaceBounds != null) {
            for (ReferenceTypeSignature referenceTypeSignature : this.interfaceBounds) {
                referenceTypeSignature.setScanResult(scanResult);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void findReferencedClassNames(Set<String> refdClassNames) {
        if (this.classBound != null) {
            this.classBound.findReferencedClassNames(refdClassNames);
        }
        for (ReferenceTypeSignature typeSignature : this.interfaceBounds) {
            typeSignature.findReferencedClassNames(refdClassNames);
        }
    }

    public int hashCode() {
        return this.name.hashCode() + (this.classBound == null ? 0 : this.classBound.hashCode() * 7) + (this.interfaceBounds.hashCode() * 15);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TypeParameter)) {
            return false;
        }
        TypeParameter o = (TypeParameter) obj;
        return o.name.equals(this.name) && ((o.classBound == null && this.classBound == null) || (o.classBound != null && o.classBound.equals(this.classBound))) && o.interfaceBounds.equals(this.interfaceBounds);
    }

    public String toString() {
        String classBoundStr;
        StringBuilder buf = new StringBuilder();
        buf.append(this.name);
        if (this.classBound == null) {
            classBoundStr = null;
        } else {
            classBoundStr = this.classBound.toString();
            if (classBoundStr.equals("java.lang.Object")) {
                classBoundStr = null;
            }
        }
        if (classBoundStr != null || !this.interfaceBounds.isEmpty()) {
            buf.append(" extends");
        }
        if (classBoundStr != null) {
            buf.append(' ');
            buf.append(classBoundStr);
        }
        for (int i = 0; i < this.interfaceBounds.size(); i++) {
            if (i > 0 || classBoundStr != null) {
                buf.append(" &");
            }
            buf.append(' ');
            buf.append(this.interfaceBounds.get(i).toString());
        }
        return buf.toString();
    }
}
