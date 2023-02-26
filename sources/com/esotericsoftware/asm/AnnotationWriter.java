package com.esotericsoftware.asm;

/* loaded from: grasscutter.jar:com/esotericsoftware/asm/AnnotationWriter.class */
final class AnnotationWriter extends AnnotationVisitor {

    /* renamed from: a */
    private final ClassWriter f23a;

    /* renamed from: b */
    private int f24b;

    /* renamed from: c */
    private final boolean f25c;

    /* renamed from: d */
    private final ByteVector f26d;

    /* renamed from: e */
    private final ByteVector f27e;

    /* renamed from: f */
    private final int f28f;

    /* renamed from: g */
    AnnotationWriter f29g;

    /* renamed from: h */
    AnnotationWriter f30h;

    /* access modifiers changed from: package-private */
    public AnnotationWriter(ClassWriter classWriter, boolean z, ByteVector byteVector, ByteVector byteVector2, int i) {
        super(327680);
        this.f23a = classWriter;
        this.f25c = z;
        this.f26d = byteVector;
        this.f27e = byteVector2;
        this.f28f = i;
    }

    @Override // com.esotericsoftware.asm.AnnotationVisitor
    public void visit(String str, Object obj) {
        this.f24b++;
        if (this.f25c) {
            this.f26d.putShort(this.f23a.newUTF8(str));
        }
        if (obj instanceof String) {
            this.f26d.m1575b(115, this.f23a.newUTF8((String) obj));
        } else if (obj instanceof Byte) {
            this.f26d.m1575b(66, this.f23a.m1554a((int) ((Byte) obj).byteValue()).f135a);
        } else if (obj instanceof Boolean) {
            this.f26d.m1575b(90, this.f23a.m1554a(((Boolean) obj).booleanValue() ? 1 : 0).f135a);
        } else if (obj instanceof Character) {
            this.f26d.m1575b(67, this.f23a.m1554a((int) ((Character) obj).charValue()).f135a);
        } else if (obj instanceof Short) {
            this.f26d.m1575b(83, this.f23a.m1554a((int) ((Short) obj).shortValue()).f135a);
        } else if (obj instanceof Type) {
            this.f26d.m1575b(99, this.f23a.newUTF8(((Type) obj).getDescriptor()));
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            this.f26d.m1575b(91, bArr.length);
            for (byte b : bArr) {
                this.f26d.m1575b(66, this.f23a.m1554a((int) b).f135a);
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            this.f26d.m1575b(91, zArr.length);
            for (boolean z : zArr) {
                this.f26d.m1575b(90, this.f23a.m1554a(z ? 1 : 0).f135a);
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            this.f26d.m1575b(91, sArr.length);
            for (short s : sArr) {
                this.f26d.m1575b(83, this.f23a.m1554a((int) s).f135a);
            }
        } else if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            this.f26d.m1575b(91, cArr.length);
            for (char c : cArr) {
                this.f26d.m1575b(67, this.f23a.m1554a((int) c).f135a);
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            this.f26d.m1575b(91, iArr.length);
            for (int i : iArr) {
                this.f26d.m1575b(73, this.f23a.m1554a(i).f135a);
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            this.f26d.m1575b(91, jArr.length);
            for (long j : jArr) {
                this.f26d.m1575b(74, this.f23a.m1550a(j).f135a);
            }
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            this.f26d.m1575b(91, fArr.length);
            for (float f : fArr) {
                this.f26d.m1575b(70, this.f23a.m1555a(f).f135a);
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            this.f26d.m1575b(91, dArr.length);
            for (double d : dArr) {
                this.f26d.m1575b(68, this.f23a.m1556a(d).f135a);
            }
        } else {
            Item a = this.f23a.m1548a(obj);
            this.f26d.m1575b(".s.IFJDCS".charAt(a.f136b), a.f135a);
        }
    }

    @Override // com.esotericsoftware.asm.AnnotationVisitor
    public void visitEnum(String str, String str2, String str3) {
        this.f24b++;
        if (this.f25c) {
            this.f26d.putShort(this.f23a.newUTF8(str));
        }
        this.f26d.m1575b(101, this.f23a.newUTF8(str2)).putShort(this.f23a.newUTF8(str3));
    }

    @Override // com.esotericsoftware.asm.AnnotationVisitor
    public AnnotationVisitor visitAnnotation(String str, String str2) {
        this.f24b++;
        if (this.f25c) {
            this.f26d.putShort(this.f23a.newUTF8(str));
        }
        this.f26d.m1575b(64, this.f23a.newUTF8(str2)).putShort(0);
        return new AnnotationWriter(this.f23a, true, this.f26d, this.f26d, this.f26d.f34b - 2);
    }

    @Override // com.esotericsoftware.asm.AnnotationVisitor
    public AnnotationVisitor visitArray(String str) {
        this.f24b++;
        if (this.f25c) {
            this.f26d.putShort(this.f23a.newUTF8(str));
        }
        this.f26d.m1575b(91, 0);
        return new AnnotationWriter(this.f23a, false, this.f26d, this.f26d, this.f26d.f34b - 2);
    }

    @Override // com.esotericsoftware.asm.AnnotationVisitor
    public void visitEnd() {
        if (this.f27e != null) {
            byte[] bArr = this.f27e.f33a;
            bArr[this.f28f] = (byte) (this.f24b >>> 8);
            bArr[this.f28f + 1] = (byte) this.f24b;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int m1584a() {
        int i = 0;
        for (AnnotationWriter annotationWriter = this; annotationWriter != null; annotationWriter = annotationWriter.f29g) {
            i += annotationWriter.f26d.f34b;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1582a(ByteVector byteVector) {
        int i = 0;
        int i2 = 2;
        AnnotationWriter annotationWriter = null;
        for (AnnotationWriter annotationWriter2 = this; annotationWriter2 != null; annotationWriter2 = annotationWriter2.f29g) {
            i++;
            i2 += annotationWriter2.f26d.f34b;
            annotationWriter2.visitEnd();
            annotationWriter2.f30h = annotationWriter;
            annotationWriter = annotationWriter2;
        }
        byteVector.putInt(i2);
        byteVector.putShort(i);
        for (AnnotationWriter annotationWriter3 = annotationWriter; annotationWriter3 != null; annotationWriter3 = annotationWriter3.f30h) {
            byteVector.putByteArray(annotationWriter3.f26d.f33a, 0, annotationWriter3.f26d.f34b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m1581a(AnnotationWriter[] annotationWriterArr, int i, ByteVector byteVector) {
        int length = 1 + (2 * (annotationWriterArr.length - i));
        for (int i2 = i; i2 < annotationWriterArr.length; i2++) {
            length += annotationWriterArr[i2] == null ? 0 : annotationWriterArr[i2].m1584a();
        }
        byteVector.putInt(length).putByte(annotationWriterArr.length - i);
        for (int i3 = i; i3 < annotationWriterArr.length; i3++) {
            AnnotationWriter annotationWriter = null;
            int i4 = 0;
            for (AnnotationWriter annotationWriter2 = annotationWriterArr[i3]; annotationWriter2 != null; annotationWriter2 = annotationWriter2.f29g) {
                i4++;
                annotationWriter2.visitEnd();
                annotationWriter2.f30h = annotationWriter;
                annotationWriter = annotationWriter2;
            }
            byteVector.putShort(i4);
            for (AnnotationWriter annotationWriter3 = annotationWriter; annotationWriter3 != null; annotationWriter3 = annotationWriter3.f30h) {
                byteVector.putByteArray(annotationWriter3.f26d.f33a, 0, annotationWriter3.f26d.f34b);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m1583a(int i, TypePath typePath, ByteVector byteVector) {
        switch (i >>> 24) {
            case 0:
            case 1:
            case 22:
                byteVector.putShort(i >>> 16);
                break;
            case 19:
            case 20:
            case 21:
                byteVector.putByte(i >>> 24);
                break;
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
                byteVector.putInt(i);
                break;
            default:
                byteVector.m1575b(i >>> 24, (i & 16776960) >> 8);
                break;
        }
        if (typePath == null) {
            byteVector.putByte(0);
            return;
        }
        byteVector.putByteArray(typePath.f211a, typePath.f212b, (typePath.f211a[typePath.f212b] * 2) + 1);
    }
}
