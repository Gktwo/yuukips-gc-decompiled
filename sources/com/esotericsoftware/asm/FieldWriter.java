package com.esotericsoftware.asm;

import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ConstantAttribute;
import javassist.bytecode.DeprecatedAttribute;
import javassist.bytecode.SignatureAttribute;
import javassist.bytecode.SyntheticAttribute;
import javassist.bytecode.TypeAnnotationsAttribute;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/esotericsoftware/asm/FieldWriter.class */
public final class FieldWriter extends FieldVisitor {

    /* renamed from: b */
    private final ClassWriter f104b;

    /* renamed from: c */
    private final int f105c;

    /* renamed from: d */
    private final int f106d;

    /* renamed from: e */
    private final int f107e;

    /* renamed from: f */
    private int f108f;

    /* renamed from: g */
    private int f109g;

    /* renamed from: h */
    private AnnotationWriter f110h;

    /* renamed from: i */
    private AnnotationWriter f111i;

    /* renamed from: k */
    private AnnotationWriter f112k;

    /* renamed from: l */
    private AnnotationWriter f113l;

    /* renamed from: j */
    private Attribute f114j;

    /* access modifiers changed from: package-private */
    public FieldWriter(ClassWriter classWriter, int i, String str, String str2, String str3, Object obj) {
        super(327680);
        if (classWriter.f73B == null) {
            classWriter.f73B = this;
        } else {
            classWriter.f74C.f103fv = this;
        }
        classWriter.f74C = this;
        this.f104b = classWriter;
        this.f105c = i;
        this.f106d = classWriter.newUTF8(str);
        this.f107e = classWriter.newUTF8(str2);
        if (str3 != null) {
            this.f108f = classWriter.newUTF8(str3);
        }
        if (obj != null) {
            this.f109g = classWriter.m1548a(obj).f135a;
        }
    }

    @Override // com.esotericsoftware.asm.FieldVisitor
    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(this.f104b.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f104b, true, byteVector, byteVector, 2);
        if (z) {
            annotationWriter.f29g = this.f110h;
            this.f110h = annotationWriter;
        } else {
            annotationWriter.f29g = this.f111i;
            this.f111i = annotationWriter;
        }
        return annotationWriter;
    }

    @Override // com.esotericsoftware.asm.FieldVisitor
    public AnnotationVisitor visitTypeAnnotation(int i, TypePath typePath, String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        AnnotationWriter.m1583a(i, typePath, byteVector);
        byteVector.putShort(this.f104b.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f104b, true, byteVector, byteVector, byteVector.f34b - 2);
        if (z) {
            annotationWriter.f29g = this.f112k;
            this.f112k = annotationWriter;
        } else {
            annotationWriter.f29g = this.f113l;
            this.f113l = annotationWriter;
        }
        return annotationWriter;
    }

    @Override // com.esotericsoftware.asm.FieldVisitor
    public void visitAttribute(Attribute attribute) {
        attribute.f32a = this.f114j;
        this.f114j = attribute;
    }

    @Override // com.esotericsoftware.asm.FieldVisitor
    public void visitEnd() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int m1535a() {
        int i = 8;
        if (this.f109g != 0) {
            this.f104b.newUTF8(ConstantAttribute.tag);
            i = 8 + 8;
        }
        if ((this.f105c & 4096) != 0 && ((this.f104b.f42b & 65535) < 49 || (this.f105c & 262144) != 0)) {
            this.f104b.newUTF8(SyntheticAttribute.tag);
            i += 6;
        }
        if ((this.f105c & 131072) != 0) {
            this.f104b.newUTF8(DeprecatedAttribute.tag);
            i += 6;
        }
        if (this.f108f != 0) {
            this.f104b.newUTF8(SignatureAttribute.tag);
            i += 8;
        }
        if (this.f110h != null) {
            this.f104b.newUTF8(AnnotationsAttribute.visibleTag);
            i += 8 + this.f110h.m1584a();
        }
        if (this.f111i != null) {
            this.f104b.newUTF8(AnnotationsAttribute.invisibleTag);
            i += 8 + this.f111i.m1584a();
        }
        if (this.f112k != null) {
            this.f104b.newUTF8(TypeAnnotationsAttribute.visibleTag);
            i += 8 + this.f112k.m1584a();
        }
        if (this.f113l != null) {
            this.f104b.newUTF8(TypeAnnotationsAttribute.invisibleTag);
            i += 8 + this.f113l.m1584a();
        }
        if (this.f114j != null) {
            i += this.f114j.m1579a(this.f104b, null, 0, -1, -1);
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1534a(ByteVector byteVector) {
        byteVector.putShort(this.f105c & ((393216 | ((this.f105c & 262144) / 64)) ^ -1)).putShort(this.f106d).putShort(this.f107e);
        int i = 0;
        if (this.f109g != 0) {
            i = 0 + 1;
        }
        if ((this.f105c & 4096) != 0 && ((this.f104b.f42b & 65535) < 49 || (this.f105c & 262144) != 0)) {
            i++;
        }
        if ((this.f105c & 131072) != 0) {
            i++;
        }
        if (this.f108f != 0) {
            i++;
        }
        if (this.f110h != null) {
            i++;
        }
        if (this.f111i != null) {
            i++;
        }
        if (this.f112k != null) {
            i++;
        }
        if (this.f113l != null) {
            i++;
        }
        if (this.f114j != null) {
            i += this.f114j.m1580a();
        }
        byteVector.putShort(i);
        if (this.f109g != 0) {
            byteVector.putShort(this.f104b.newUTF8(ConstantAttribute.tag));
            byteVector.putInt(2).putShort(this.f109g);
        }
        if ((this.f105c & 4096) != 0 && ((this.f104b.f42b & 65535) < 49 || (this.f105c & 262144) != 0)) {
            byteVector.putShort(this.f104b.newUTF8(SyntheticAttribute.tag)).putInt(0);
        }
        if ((this.f105c & 131072) != 0) {
            byteVector.putShort(this.f104b.newUTF8(DeprecatedAttribute.tag)).putInt(0);
        }
        if (this.f108f != 0) {
            byteVector.putShort(this.f104b.newUTF8(SignatureAttribute.tag));
            byteVector.putInt(2).putShort(this.f108f);
        }
        if (this.f110h != null) {
            byteVector.putShort(this.f104b.newUTF8(AnnotationsAttribute.visibleTag));
            this.f110h.m1582a(byteVector);
        }
        if (this.f111i != null) {
            byteVector.putShort(this.f104b.newUTF8(AnnotationsAttribute.invisibleTag));
            this.f111i.m1582a(byteVector);
        }
        if (this.f112k != null) {
            byteVector.putShort(this.f104b.newUTF8(TypeAnnotationsAttribute.visibleTag));
            this.f112k.m1582a(byteVector);
        }
        if (this.f113l != null) {
            byteVector.putShort(this.f104b.newUTF8(TypeAnnotationsAttribute.invisibleTag));
            this.f113l.m1582a(byteVector);
        }
        if (this.f114j != null) {
            this.f114j.m1578a(this.f104b, null, 0, -1, -1, byteVector);
        }
    }
}
