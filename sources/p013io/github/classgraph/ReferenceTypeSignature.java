package p013io.github.classgraph;

import nonapi.p019io.github.classgraph.types.ParseException;
import nonapi.p019io.github.classgraph.types.Parser;

/* renamed from: io.github.classgraph.ReferenceTypeSignature */
/* loaded from: grasscutter.jar:io/github/classgraph/ReferenceTypeSignature.class */
public abstract class ReferenceTypeSignature extends TypeSignature {
    /* access modifiers changed from: package-private */
    public static ReferenceTypeSignature parseReferenceTypeSignature(Parser parser, String definingClassName) throws ParseException {
        ClassRefTypeSignature classTypeSignature = ClassRefTypeSignature.parse(parser, definingClassName);
        if (classTypeSignature != null) {
            return classTypeSignature;
        }
        TypeVariableSignature typeVariableSignature = TypeVariableSignature.parse(parser, definingClassName);
        if (typeVariableSignature != null) {
            return typeVariableSignature;
        }
        ArrayTypeSignature arrayTypeSignature = ArrayTypeSignature.parse(parser, definingClassName);
        if (arrayTypeSignature != null) {
            return arrayTypeSignature;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public static ReferenceTypeSignature parseClassBound(Parser parser, String definingClassName) throws ParseException {
        parser.expect(':');
        return parseReferenceTypeSignature(parser, definingClassName);
    }
}
