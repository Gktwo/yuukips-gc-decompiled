package com.esotericsoftware.asm;

/* loaded from: grasscutter.jar:com/esotericsoftware/asm/Attribute.class */
public class Attribute {
    public final String type;

    /* renamed from: b */
    byte[] f31b;

    /* renamed from: a */
    Attribute f32a;

    /* access modifiers changed from: protected */
    public Attribute(String str) {
        this.type = str;
    }

    public boolean isUnknown() {
        return true;
    }

    public boolean isCodeAttribute() {
        return false;
    }

    /* access modifiers changed from: protected */
    public Label[] getLabels() {
        return null;
    }

    /* access modifiers changed from: protected */
    public Attribute read(ClassReader classReader, int i, int i2, char[] cArr, int i3, Label[] labelArr) {
        Attribute attribute = new Attribute(this.type);
        attribute.f31b = new byte[i2];
        System.arraycopy(classReader.f35b, i, attribute.f31b, 0, i2);
        return attribute;
    }

    protected ByteVector write(ClassWriter classWriter, byte[] bArr, int i, int i2, int i3) {
        ByteVector byteVector = new ByteVector();
        byteVector.f33a = this.f31b;
        byteVector.f34b = this.f31b.length;
        return byteVector;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int m1580a() {
        int i = 0;
        for (Attribute attribute = this; attribute != null; attribute = attribute.f32a) {
            i++;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int m1579a(ClassWriter classWriter, byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        for (Attribute attribute = this; attribute != null; attribute = attribute.f32a) {
            classWriter.newUTF8(attribute.type);
            i4 += attribute.write(classWriter, bArr, i, i2, i3).f34b + 6;
        }
        return i4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m1578a(ClassWriter classWriter, byte[] bArr, int i, int i2, int i3, ByteVector byteVector) {
        for (Attribute attribute = this; attribute != null; attribute = attribute.f32a) {
            ByteVector write = attribute.write(classWriter, bArr, i, i2, i3);
            byteVector.putShort(classWriter.newUTF8(attribute.type)).putInt(write.f34b);
            byteVector.putByteArray(write.f33a, 0, write.f34b);
        }
    }
}
