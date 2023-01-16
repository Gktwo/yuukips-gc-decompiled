package javassist;

import javassist.CtField;

/* compiled from: CtClassType.java */
/* loaded from: grasscutter.jar:javassist/FieldInitLink.class */
class FieldInitLink {
    FieldInitLink next = null;
    CtField field;
    CtField.Initializer init;

    /* access modifiers changed from: package-private */
    public FieldInitLink(CtField f, CtField.Initializer i) {
        this.field = f;
        this.init = i;
    }
}
