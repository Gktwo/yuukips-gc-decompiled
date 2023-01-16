package p013io.github.classgraph;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import nonapi.p019io.github.classgraph.types.ParseException;
import nonapi.p019io.github.classgraph.types.Parser;

/* renamed from: io.github.classgraph.TypeSignature */
/* loaded from: grasscutter.jar:io/github/classgraph/TypeSignature.class */
public abstract class TypeSignature extends HierarchicalTypeSignature {
    public abstract boolean equalsIgnoringTypeParams(TypeSignature typeSignature);

    protected abstract String toStringInternal(boolean z);

    /* access modifiers changed from: protected */
    public void findReferencedClassNames(Set<String> refdClassNames) {
        String className = getClassName();
        if (className != null && !className.isEmpty()) {
            refdClassNames.add(getClassName());
        }
    }

    /* access modifiers changed from: protected */
    @Override // p013io.github.classgraph.ScanResultObject
    public final void findReferencedClassInfo(Map<String, ClassInfo> classNameToClassInfo, Set<ClassInfo> refdClassInfo) {
        Set<String> refdClassNames = new HashSet<>();
        findReferencedClassNames(refdClassNames);
        for (String refdClassName : refdClassNames) {
            ClassInfo classInfo = ClassInfo.getOrCreateClassInfo(refdClassName, classNameToClassInfo);
            classInfo.scanResult = this.scanResult;
            refdClassInfo.add(classInfo);
        }
    }

    public String toStringWithSimpleNames() {
        return toStringInternal(true);
    }

    public String toString() {
        return toStringInternal(false);
    }

    /* access modifiers changed from: package-private */
    public static TypeSignature parse(Parser parser, String definingClass) throws ParseException {
        ReferenceTypeSignature referenceTypeSignature = ReferenceTypeSignature.parseReferenceTypeSignature(parser, definingClass);
        if (referenceTypeSignature != null) {
            return referenceTypeSignature;
        }
        BaseTypeSignature baseTypeSignature = BaseTypeSignature.parse(parser);
        if (baseTypeSignature != null) {
            return baseTypeSignature;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public static TypeSignature parse(String typeDescriptor, String definingClass) throws ParseException {
        Parser parser = new Parser(typeDescriptor);
        TypeSignature typeSignature = parse(parser, definingClass);
        if (typeSignature == null) {
            throw new ParseException(parser, "Could not parse type signature");
        } else if (!parser.hasMore()) {
            return typeSignature;
        } else {
            throw new ParseException(parser, "Extra characters at end of type descriptor");
        }
    }
}
