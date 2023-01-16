package com.esotericsoftware.asm;

import emu.grasscutter.net.packet.PacketOpcodes;
import javassist.bytecode.AnnotationDefaultAttribute;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.DeprecatedAttribute;
import javassist.bytecode.ExceptionsAttribute;
import javassist.bytecode.LineNumberAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodParametersAttribute;
import javassist.bytecode.ParameterAnnotationsAttribute;
import javassist.bytecode.SignatureAttribute;
import javassist.bytecode.StackMap;
import javassist.bytecode.StackMapTable;
import javassist.bytecode.SyntheticAttribute;
import javassist.bytecode.TypeAnnotationsAttribute;
import p013io.netty.channel.SelectStrategy;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/esotericsoftware/asm/MethodWriter.class */
public class MethodWriter extends MethodVisitor {

    /* renamed from: b */
    final ClassWriter f156b;

    /* renamed from: c */
    private int f157c;

    /* renamed from: d */
    private final int f158d;

    /* renamed from: e */
    private final int f159e;

    /* renamed from: f */
    private final String f160f;

    /* renamed from: g */
    String f161g;

    /* renamed from: h */
    int f162h;

    /* renamed from: i */
    int f163i;

    /* renamed from: j */
    int f164j;

    /* renamed from: k */
    int[] f165k;

    /* renamed from: l */
    private ByteVector f166l;

    /* renamed from: m */
    private AnnotationWriter f167m;

    /* renamed from: n */
    private AnnotationWriter f168n;

    /* renamed from: U */
    private AnnotationWriter f169U;

    /* renamed from: V */
    private AnnotationWriter f170V;

    /* renamed from: o */
    private AnnotationWriter[] f171o;

    /* renamed from: p */
    private AnnotationWriter[] f172p;

    /* renamed from: S */
    private int f173S;

    /* renamed from: q */
    private Attribute f174q;

    /* renamed from: r */
    private ByteVector f175r = new ByteVector();

    /* renamed from: s */
    private int f176s;

    /* renamed from: t */
    private int f177t;

    /* renamed from: T */
    private int f178T;

    /* renamed from: u */
    private int f179u;

    /* renamed from: v */
    private ByteVector f180v;

    /* renamed from: w */
    private int f181w;

    /* renamed from: x */
    private int[] f182x;

    /* renamed from: z */
    private int[] f183z;

    /* renamed from: A */
    private int f184A;

    /* renamed from: B */
    private Handler f185B;

    /* renamed from: C */
    private Handler f186C;

    /* renamed from: Z */
    private int f187Z;

    /* renamed from: $ */
    private ByteVector f188$;

    /* renamed from: D */
    private int f189D;

    /* renamed from: E */
    private ByteVector f190E;

    /* renamed from: F */
    private int f191F;

    /* renamed from: G */
    private ByteVector f192G;

    /* renamed from: H */
    private int f193H;

    /* renamed from: I */
    private ByteVector f194I;

    /* renamed from: Y */
    private int f195Y;

    /* renamed from: W */
    private AnnotationWriter f196W;

    /* renamed from: X */
    private AnnotationWriter f197X;

    /* renamed from: J */
    private Attribute f198J;

    /* renamed from: K */
    private boolean f199K;

    /* renamed from: L */
    private int f200L;

    /* renamed from: M */
    private final int f201M;

    /* renamed from: N */
    private Label f202N;

    /* renamed from: O */
    private Label f203O;

    /* renamed from: P */
    private Label f204P;

    /* renamed from: Q */
    private int f205Q;

    /* renamed from: R */
    private int f206R;

    /* access modifiers changed from: package-private */
    public MethodWriter(ClassWriter classWriter, int i, String str, String str2, String str3, String[] strArr, boolean z, boolean z2) {
        super(327680);
        if (classWriter.f75D == null) {
            classWriter.f75D = this;
        } else {
            classWriter.f76E.f155mv = this;
        }
        classWriter.f76E = this;
        this.f156b = classWriter;
        this.f157c = i;
        if ("<init>".equals(str)) {
            this.f157c |= 524288;
        }
        this.f158d = classWriter.newUTF8(str);
        this.f159e = classWriter.newUTF8(str2);
        this.f160f = str2;
        this.f161g = str3;
        if (strArr != null && strArr.length > 0) {
            this.f164j = strArr.length;
            this.f165k = new int[this.f164j];
            for (int i2 = 0; i2 < this.f164j; i2++) {
                this.f165k[i2] = classWriter.newClass(strArr[i2]);
            }
        }
        this.f201M = z2 ? 0 : z ? 1 : 2;
        if (z || z2) {
            int argumentsAndReturnSizes = Type.getArgumentsAndReturnSizes(this.f160f) >> 2;
            argumentsAndReturnSizes = (i & 8) != 0 ? argumentsAndReturnSizes - 1 : argumentsAndReturnSizes;
            this.f177t = argumentsAndReturnSizes;
            this.f178T = argumentsAndReturnSizes;
            this.f202N = new Label();
            this.f202N.f144a |= 8;
            visitLabel(this.f202N);
        }
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitParameter(String str, int i) {
        if (this.f188$ == null) {
            this.f188$ = new ByteVector();
        }
        this.f187Z++;
        this.f188$.putShort(str == null ? 0 : this.f156b.newUTF8(str)).putShort(i);
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public AnnotationVisitor visitAnnotationDefault() {
        this.f166l = new ByteVector();
        return new AnnotationWriter(this.f156b, false, this.f166l, null, 0);
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(this.f156b.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f156b, true, byteVector, byteVector, 2);
        if (z) {
            annotationWriter.f29g = this.f167m;
            this.f167m = annotationWriter;
        } else {
            annotationWriter.f29g = this.f168n;
            this.f168n = annotationWriter;
        }
        return annotationWriter;
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public AnnotationVisitor visitTypeAnnotation(int i, TypePath typePath, String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        AnnotationWriter.m1583a(i, typePath, byteVector);
        byteVector.putShort(this.f156b.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f156b, true, byteVector, byteVector, byteVector.f34b - 2);
        if (z) {
            annotationWriter.f29g = this.f169U;
            this.f169U = annotationWriter;
        } else {
            annotationWriter.f29g = this.f170V;
            this.f170V = annotationWriter;
        }
        return annotationWriter;
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public AnnotationVisitor visitParameterAnnotation(int i, String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        if ("Ljava/lang/Synthetic;".equals(str)) {
            this.f173S = Math.max(this.f173S, i + 1);
            return new AnnotationWriter(this.f156b, false, byteVector, null, 0);
        }
        byteVector.putShort(this.f156b.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f156b, true, byteVector, byteVector, 2);
        if (z) {
            if (this.f171o == null) {
                this.f171o = new AnnotationWriter[Type.getArgumentTypes(this.f160f).length];
            }
            annotationWriter.f29g = this.f171o[i];
            this.f171o[i] = annotationWriter;
        } else {
            if (this.f172p == null) {
                this.f172p = new AnnotationWriter[Type.getArgumentTypes(this.f160f).length];
            }
            annotationWriter.f29g = this.f172p[i];
            this.f172p[i] = annotationWriter;
        }
        return annotationWriter;
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitAttribute(Attribute attribute) {
        if (attribute.isCodeAttribute()) {
            attribute.f32a = this.f198J;
            this.f198J = attribute;
            return;
        }
        attribute.f32a = this.f174q;
        this.f174q = attribute;
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitCode() {
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitFrame(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        int i4;
        if (this.f201M != 0) {
            if (i == -1) {
                if (this.f182x == null) {
                    m1484f();
                }
                this.f178T = i2;
                int a = m1500a(this.f175r.f34b, i2, i3);
                for (int i5 = 0; i5 < i2; i5++) {
                    if (objArr[i5] instanceof String) {
                        a++;
                        this.f183z[a] = 24117248 | this.f156b.m1537c((String) objArr[i5]);
                    } else if (objArr[i5] instanceof Integer) {
                        a++;
                        this.f183z[a] = ((Integer) objArr[i5]).intValue();
                    } else {
                        a++;
                        this.f183z[a] = 25165824 | this.f156b.m1546a("", ((Label) objArr[i5]).f146c);
                    }
                }
                for (int i6 = 0; i6 < i3; i6++) {
                    if (objArr2[i6] instanceof String) {
                        a++;
                        this.f183z[a] = 24117248 | this.f156b.m1537c((String) objArr2[i6]);
                    } else if (objArr2[i6] instanceof Integer) {
                        a++;
                        this.f183z[a] = ((Integer) objArr2[i6]).intValue();
                    } else {
                        a++;
                        this.f183z[a] = 25165824 | this.f156b.m1546a("", ((Label) objArr2[i6]).f146c);
                    }
                }
                m1491b();
            } else {
                if (this.f180v == null) {
                    this.f180v = new ByteVector();
                    i4 = this.f175r.f34b;
                } else {
                    i4 = (this.f175r.f34b - this.f181w) - 1;
                    if (i4 < 0) {
                        if (i != 3) {
                            throw new IllegalStateException();
                        }
                        return;
                    }
                }
                switch (i) {
                    case 0:
                        this.f178T = i2;
                        this.f180v.putByte(255).putShort(i4).putShort(i2);
                        for (int i7 = 0; i7 < i2; i7++) {
                            m1496a(objArr[i7]);
                        }
                        this.f180v.putShort(i3);
                        for (int i8 = 0; i8 < i3; i8++) {
                            m1496a(objArr2[i8]);
                        }
                        break;
                    case 1:
                        this.f178T += i2;
                        this.f180v.putByte(PacketOpcodes.EnterSceneReadyRsp + i2).putShort(i4);
                        for (int i9 = 0; i9 < i2; i9++) {
                            m1496a(objArr[i9]);
                        }
                        break;
                    case 2:
                        this.f178T -= i2;
                        this.f180v.putByte(PacketOpcodes.EnterSceneReadyRsp - i2).putShort(i4);
                        break;
                    case 3:
                        if (i4 < 64) {
                            this.f180v.putByte(i4);
                            break;
                        } else {
                            this.f180v.putByte(PacketOpcodes.EnterSceneReadyRsp).putShort(i4);
                            break;
                        }
                    case 4:
                        if (i4 < 64) {
                            this.f180v.putByte(64 + i4);
                        } else {
                            this.f180v.putByte(247).putShort(i4);
                        }
                        m1496a(objArr2[0]);
                        break;
                }
                this.f181w = this.f175r.f34b;
                this.f179u++;
            }
            this.f176s = Math.max(this.f176s, i3);
            this.f177t = Math.max(this.f177t, this.f178T);
        }
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitInsn(int i) {
        this.f195Y = this.f175r.f34b;
        this.f175r.putByte(i);
        if (this.f204P != null) {
            if (this.f201M == 0) {
                this.f204P.f151h.m1530a(i, 0, (ClassWriter) null, (Item) null);
            } else {
                int i2 = this.f205Q + Frame.f115a[i];
                if (i2 > this.f206R) {
                    this.f206R = i2;
                }
                this.f205Q = i2;
            }
            if ((i >= 172 && i <= 177) || i == 191) {
                m1485e();
            }
        }
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitIntInsn(int i, int i2) {
        this.f195Y = this.f175r.f34b;
        if (this.f204P != null) {
            if (this.f201M == 0) {
                this.f204P.f151h.m1530a(i, i2, (ClassWriter) null, (Item) null);
            } else if (i != 188) {
                int i3 = this.f205Q + 1;
                if (i3 > this.f206R) {
                    this.f206R = i3;
                }
                this.f205Q = i3;
            }
        }
        if (i == 17) {
            this.f175r.m1575b(i, i2);
        } else {
            this.f175r.m1576a(i, i2);
        }
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitVarInsn(int i, int i2) {
        this.f195Y = this.f175r.f34b;
        if (this.f204P != null) {
            if (this.f201M == 0) {
                this.f204P.f151h.m1530a(i, i2, (ClassWriter) null, (Item) null);
            } else if (i == 169) {
                this.f204P.f144a |= 256;
                this.f204P.f149f = this.f205Q;
                m1485e();
            } else {
                int i3 = this.f205Q + Frame.f115a[i];
                if (i3 > this.f206R) {
                    this.f206R = i3;
                }
                this.f205Q = i3;
            }
        }
        if (this.f201M != 2) {
            int i4 = (i == 22 || i == 24 || i == 55 || i == 57) ? i2 + 2 : i2 + 1;
            if (i4 > this.f177t) {
                this.f177t = i4;
            }
        }
        if (i2 < 4 && i != 169) {
            this.f175r.putByte(i < 54 ? 26 + ((i - 21) << 2) + i2 : 59 + ((i - 54) << 2) + i2);
        } else if (i2 >= 256) {
            this.f175r.putByte(196).m1575b(i, i2);
        } else {
            this.f175r.m1576a(i, i2);
        }
        if (i >= 54 && this.f201M == 0 && this.f184A > 0) {
            visitLabel(new Label());
        }
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitTypeInsn(int i, String str) {
        this.f195Y = this.f175r.f34b;
        Item a = this.f156b.m1547a(str);
        if (this.f204P != null) {
            if (this.f201M == 0) {
                this.f204P.f151h.m1530a(i, this.f175r.f34b, this.f156b, a);
            } else if (i == 187) {
                int i2 = this.f205Q + 1;
                if (i2 > this.f206R) {
                    this.f206R = i2;
                }
                this.f205Q = i2;
            }
        }
        this.f175r.m1575b(i, a.f135a);
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitFieldInsn(int i, String str, String str2, String str3) {
        int i2;
        this.f195Y = this.f175r.f34b;
        Item a = this.f156b.m1543a(str, str2, str3);
        if (this.f204P != null) {
            if (this.f201M == 0) {
                this.f204P.f151h.m1530a(i, 0, this.f156b, a);
            } else {
                char charAt = str3.charAt(0);
                switch (i) {
                    case 178:
                        i2 = this.f205Q + ((charAt == 'D' || charAt == 'J') ? 2 : 1);
                        break;
                    case 179:
                        i2 = this.f205Q + ((charAt == 'D' || charAt == 'J') ? -2 : -1);
                        break;
                    case 180:
                        i2 = this.f205Q + ((charAt == 'D' || charAt == 'J') ? 1 : 0);
                        break;
                    default:
                        i2 = this.f205Q + ((charAt == 'D' || charAt == 'J') ? -3 : -2);
                        break;
                }
                if (i2 > this.f206R) {
                    this.f206R = i2;
                }
                this.f205Q = i2;
            }
        }
        this.f175r.m1575b(i, a.f135a);
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitMethodInsn(int i, String str, String str2, String str3, boolean z) {
        this.f195Y = this.f175r.f34b;
        Item a = this.f156b.m1542a(str, str2, str3, z);
        int i2 = a.f137c;
        if (this.f204P != null) {
            if (this.f201M == 0) {
                this.f204P.f151h.m1530a(i, 0, this.f156b, a);
            } else {
                if (i2 == 0) {
                    i2 = Type.getArgumentsAndReturnSizes(str3);
                    a.f137c = i2;
                }
                int i3 = i == 184 ? (this.f205Q - (i2 >> 2)) + (i2 & 3) + 1 : (this.f205Q - (i2 >> 2)) + (i2 & 3);
                if (i3 > this.f206R) {
                    this.f206R = i3;
                }
                this.f205Q = i3;
            }
        }
        if (i == 185) {
            if (i2 == 0) {
                i2 = Type.getArgumentsAndReturnSizes(str3);
                a.f137c = i2;
            }
            this.f175r.m1575b(185, a.f135a).m1576a(i2 >> 2, 0);
            return;
        }
        this.f175r.m1575b(i, a.f135a);
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        this.f195Y = this.f175r.f34b;
        Item a = this.f156b.m1544a(str, str2, handle, objArr);
        int i = a.f137c;
        if (this.f204P != null) {
            if (this.f201M == 0) {
                this.f204P.f151h.m1530a(186, 0, this.f156b, a);
            } else {
                if (i == 0) {
                    i = Type.getArgumentsAndReturnSizes(str2);
                    a.f137c = i;
                }
                int i2 = (this.f205Q - (i >> 2)) + (i & 3) + 1;
                if (i2 > this.f206R) {
                    this.f206R = i2;
                }
                this.f205Q = i2;
            }
        }
        this.f175r.m1575b(186, a.f135a);
        this.f175r.putShort(0);
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitJumpInsn(int i, Label label) {
        this.f195Y = this.f175r.f34b;
        Label label2 = null;
        if (this.f204P != null) {
            if (this.f201M == 0) {
                this.f204P.f151h.m1530a(i, 0, (ClassWriter) null, (Item) null);
                label.m1510a().f144a |= 16;
                m1499a(0, label);
                if (i != 167) {
                    label2 = new Label();
                }
            } else if (i == 168) {
                if ((label.f144a & 512) == 0) {
                    label.f144a |= 512;
                    this.f200L++;
                }
                this.f204P.f144a |= 128;
                m1499a(this.f205Q + 1, label);
                label2 = new Label();
            } else {
                this.f205Q += Frame.f115a[i];
                m1499a(this.f205Q, label);
            }
        }
        if ((label.f144a & 2) == 0 || label.f146c - this.f175r.f34b >= -32768) {
            this.f175r.putByte(i);
            label.m1504a(this, this.f175r, this.f175r.f34b - 1, false);
        } else {
            if (i == 167) {
                this.f175r.putByte(200);
            } else if (i == 168) {
                this.f175r.putByte(201);
            } else {
                if (label2 != null) {
                    label2.f144a |= 16;
                }
                this.f175r.putByte(i <= 166 ? ((i + 1) ^ 1) - 1 : i ^ 1);
                this.f175r.putShort(8);
                this.f175r.putByte(200);
            }
            label.m1504a(this, this.f175r, this.f175r.f34b - 1, true);
        }
        if (this.f204P != null) {
            if (label2 != null) {
                visitLabel(label2);
            }
            if (i == 167) {
                m1485e();
            }
        }
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitLabel(Label label) {
        this.f199K |= label.m1505a(this, this.f175r.f34b, this.f175r.f33a);
        if ((label.f144a & 1) == 0) {
            if (this.f201M == 0) {
                if (this.f204P != null) {
                    if (label.f146c == this.f204P.f146c) {
                        this.f204P.f144a |= label.f144a & 16;
                        label.f151h = this.f204P.f151h;
                        return;
                    }
                    m1499a(0, label);
                }
                this.f204P = label;
                if (label.f151h == null) {
                    label.f151h = new Frame();
                    label.f151h.f116b = label;
                }
                if (this.f203O != null) {
                    if (label.f146c == this.f203O.f146c) {
                        this.f203O.f144a |= label.f144a & 16;
                        label.f151h = this.f203O.f151h;
                        this.f204P = this.f203O;
                        return;
                    }
                    this.f203O.f152i = label;
                }
                this.f203O = label;
            } else if (this.f201M == 1) {
                if (this.f204P != null) {
                    this.f204P.f150g = this.f206R;
                    m1499a(this.f205Q, label);
                }
                this.f204P = label;
                this.f205Q = 0;
                this.f206R = 0;
                if (this.f203O != null) {
                    this.f203O.f152i = label;
                }
                this.f203O = label;
            }
        }
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitLdcInsn(Object obj) {
        this.f195Y = this.f175r.f34b;
        Item a = this.f156b.m1548a(obj);
        if (this.f204P != null) {
            if (this.f201M == 0) {
                this.f204P.f151h.m1530a(18, 0, this.f156b, a);
            } else {
                int i = (a.f136b == 5 || a.f136b == 6) ? this.f205Q + 2 : this.f205Q + 1;
                if (i > this.f206R) {
                    this.f206R = i;
                }
                this.f205Q = i;
            }
        }
        int i2 = a.f135a;
        if (a.f136b == 5 || a.f136b == 6) {
            this.f175r.m1575b(20, i2);
        } else if (i2 >= 256) {
            this.f175r.m1575b(19, i2);
        } else {
            this.f175r.m1576a(18, i2);
        }
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitIincInsn(int i, int i2) {
        int i3;
        this.f195Y = this.f175r.f34b;
        if (this.f204P != null && this.f201M == 0) {
            this.f204P.f151h.m1530a(132, i, (ClassWriter) null, (Item) null);
        }
        if (this.f201M != 2 && (i3 = i + 1) > this.f177t) {
            this.f177t = i3;
        }
        if (i > 255 || i2 > 127 || i2 < -128) {
            this.f175r.putByte(196).m1575b(132, i).putShort(i2);
        } else {
            this.f175r.putByte(132).m1576a(i, i2);
        }
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitTableSwitchInsn(int i, int i2, Label label, Label... labelArr) {
        this.f195Y = this.f175r.f34b;
        int i3 = this.f175r.f34b;
        this.f175r.putByte(170);
        this.f175r.putByteArray(null, 0, (4 - (this.f175r.f34b % 4)) % 4);
        label.m1504a(this, this.f175r, i3, true);
        this.f175r.putInt(i).putInt(i2);
        for (Label label2 : labelArr) {
            label2.m1504a(this, this.f175r, i3, true);
        }
        m1497a(label, labelArr);
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        this.f195Y = this.f175r.f34b;
        int i = this.f175r.f34b;
        this.f175r.putByte(171);
        this.f175r.putByteArray(null, 0, (4 - (this.f175r.f34b % 4)) % 4);
        label.m1504a(this, this.f175r, i, true);
        this.f175r.putInt(labelArr.length);
        for (int i2 = 0; i2 < labelArr.length; i2++) {
            this.f175r.putInt(iArr[i2]);
            labelArr[i2].m1504a(this, this.f175r, i, true);
        }
        m1497a(label, labelArr);
    }

    /* renamed from: a */
    private void m1497a(Label label, Label[] labelArr) {
        if (this.f204P != null) {
            if (this.f201M == 0) {
                this.f204P.f151h.m1530a(171, 0, (ClassWriter) null, (Item) null);
                m1499a(0, label);
                label.m1510a().f144a |= 16;
                for (int i = 0; i < labelArr.length; i++) {
                    m1499a(0, labelArr[i]);
                    labelArr[i].m1510a().f144a |= 16;
                }
            } else {
                this.f205Q--;
                m1499a(this.f205Q, label);
                for (Label label2 : labelArr) {
                    m1499a(this.f205Q, label2);
                }
            }
            m1485e();
        }
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitMultiANewArrayInsn(String str, int i) {
        this.f195Y = this.f175r.f34b;
        Item a = this.f156b.m1547a(str);
        if (this.f204P != null) {
            if (this.f201M == 0) {
                this.f204P.f151h.m1530a(197, i, this.f156b, a);
            } else {
                this.f205Q += 1 - i;
            }
        }
        this.f175r.m1575b(197, a.f135a).putByte(i);
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public AnnotationVisitor visitInsnAnnotation(int i, TypePath typePath, String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        AnnotationWriter.m1583a((i & -16776961) | (this.f195Y << 8), typePath, byteVector);
        byteVector.putShort(this.f156b.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f156b, true, byteVector, byteVector, byteVector.f34b - 2);
        if (z) {
            annotationWriter.f29g = this.f196W;
            this.f196W = annotationWriter;
        } else {
            annotationWriter.f29g = this.f197X;
            this.f197X = annotationWriter;
        }
        return annotationWriter;
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
        this.f184A++;
        Handler handler = new Handler();
        handler.f129a = label;
        handler.f130b = label2;
        handler.f131c = label3;
        handler.f132d = str;
        handler.f133e = str != null ? this.f156b.newClass(str) : 0;
        if (this.f186C == null) {
            this.f185B = handler;
        } else {
            this.f186C.f134f = handler;
        }
        this.f186C = handler;
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public AnnotationVisitor visitTryCatchAnnotation(int i, TypePath typePath, String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        AnnotationWriter.m1583a(i, typePath, byteVector);
        byteVector.putShort(this.f156b.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f156b, true, byteVector, byteVector, byteVector.f34b - 2);
        if (z) {
            annotationWriter.f29g = this.f196W;
            this.f196W = annotationWriter;
        } else {
            annotationWriter.f29g = this.f197X;
            this.f197X = annotationWriter;
        }
        return annotationWriter;
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i) {
        if (str3 != null) {
            if (this.f192G == null) {
                this.f192G = new ByteVector();
            }
            this.f191F++;
            this.f192G.putShort(label.f146c).putShort(label2.f146c - label.f146c).putShort(this.f156b.newUTF8(str)).putShort(this.f156b.newUTF8(str3)).putShort(i);
        }
        if (this.f190E == null) {
            this.f190E = new ByteVector();
        }
        this.f189D++;
        this.f190E.putShort(label.f146c).putShort(label2.f146c - label.f146c).putShort(this.f156b.newUTF8(str)).putShort(this.f156b.newUTF8(str2)).putShort(i);
        if (this.f201M != 2) {
            char charAt = str2.charAt(0);
            int i2 = i + ((charAt == 'J' || charAt == 'D') ? 2 : 1);
            if (i2 > this.f177t) {
                this.f177t = i2;
            }
        }
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public AnnotationVisitor visitLocalVariableAnnotation(int i, TypePath typePath, Label[] labelArr, Label[] labelArr2, int[] iArr, String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        byteVector.putByte(i >>> 24).putShort(labelArr.length);
        for (int i2 = 0; i2 < labelArr.length; i2++) {
            byteVector.putShort(labelArr[i2].f146c).putShort(labelArr2[i2].f146c - labelArr[i2].f146c).putShort(iArr[i2]);
        }
        if (typePath == null) {
            byteVector.putByte(0);
        } else {
            byteVector.putByteArray(typePath.f211a, typePath.f212b, (typePath.f211a[typePath.f212b] * 2) + 1);
        }
        byteVector.putShort(this.f156b.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.f156b, true, byteVector, byteVector, byteVector.f34b - 2);
        if (z) {
            annotationWriter.f29g = this.f196W;
            this.f196W = annotationWriter;
        } else {
            annotationWriter.f29g = this.f197X;
            this.f197X = annotationWriter;
        }
        return annotationWriter;
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitLineNumber(int i, Label label) {
        if (this.f194I == null) {
            this.f194I = new ByteVector();
        }
        this.f193H++;
        this.f194I.putShort(label.f146c);
        this.f194I.putShort(i);
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitMaxs(int i, int i2) {
        if (this.f199K) {
            m1486d();
        }
        if (this.f201M == 0) {
            for (Handler handler = this.f185B; handler != null; handler = handler.f134f) {
                Label a = handler.f131c.m1510a();
                Label a2 = handler.f130b.m1510a();
                int c = 24117248 | this.f156b.m1537c(handler.f132d == null ? "java/lang/Throwable" : handler.f132d);
                a.f144a |= 16;
                for (Label a3 = handler.f129a.m1510a(); a3 != a2; a3 = a3.f152i) {
                    Edge edge = new Edge();
                    edge.f100a = c;
                    edge.f101b = a;
                    edge.f102c = a3.f153j;
                    a3.f153j = edge;
                }
            }
            Frame frame = this.f202N.f151h;
            frame.m1527a(this.f156b, this.f157c, Type.getArgumentTypes(this.f160f), this.f177t);
            m1490b(frame);
            int i3 = 0;
            Label label = this.f202N;
            while (label != null) {
                label = label.f154k;
                label.f154k = null;
                Frame frame2 = label.f151h;
                if ((label.f144a & 16) != 0) {
                    label.f144a |= 32;
                }
                label.f144a |= 64;
                int length = frame2.f118d.length + label.f150g;
                if (length > i3) {
                    i3 = length;
                }
                for (Edge edge2 = label.f153j; edge2 != null; edge2 = edge2.f102c) {
                    Label a4 = edge2.f101b.m1510a();
                    if (frame2.m1526a(this.f156b, a4.f151h, edge2.f100a) && a4.f154k == null) {
                        a4.f154k = label;
                        label = a4;
                    }
                }
            }
            for (Label label2 = this.f202N; label2 != null; label2 = label2.f152i) {
                Frame frame3 = label2.f151h;
                if ((label2.f144a & 32) != 0) {
                    m1490b(frame3);
                }
                if ((label2.f144a & 64) == 0) {
                    Label label3 = label2.f152i;
                    int i4 = label2.f146c;
                    int i5 = (label3 == null ? this.f175r.f34b : label3.f146c) - 1;
                    if (i5 >= i4) {
                        i3 = Math.max(i3, 1);
                        for (int i6 = i4; i6 < i5; i6++) {
                            this.f175r.f33a[i6] = 0;
                        }
                        this.f175r.f33a[i5] = -65;
                        this.f183z[m1500a(i4, 0, 1)] = 24117248 | this.f156b.m1537c("java/lang/Throwable");
                        m1491b();
                        this.f185B = Handler.m1519a(this.f185B, label2, label3);
                    }
                }
            }
            this.f184A = 0;
            for (Handler handler2 = this.f185B; handler2 != null; handler2 = handler2.f134f) {
                this.f184A++;
            }
            this.f176s = i3;
        } else if (this.f201M == 1) {
            for (Handler handler3 = this.f185B; handler3 != null; handler3 = handler3.f134f) {
                Label label4 = handler3.f131c;
                Label label5 = handler3.f130b;
                for (Label label6 = handler3.f129a; label6 != label5; label6 = label6.f152i) {
                    Edge edge3 = new Edge();
                    edge3.f100a = Integer.MAX_VALUE;
                    edge3.f101b = label4;
                    if ((label6.f144a & 128) == 0) {
                        edge3.f102c = label6.f153j;
                        label6.f153j = edge3;
                    } else {
                        edge3.f102c = label6.f153j.f102c.f102c;
                        label6.f153j.f102c.f102c = edge3;
                    }
                }
            }
            if (this.f200L > 0) {
                int i7 = 0;
                this.f202N.m1503b(null, 1, this.f200L);
                for (Label label7 = this.f202N; label7 != null; label7 = label7.f152i) {
                    if ((label7.f144a & 128) != 0) {
                        Label label8 = label7.f153j.f102c.f101b;
                        if ((label8.f144a & 1024) == 0) {
                            i7++;
                            label8.m1503b(null, ((((long) i7) / 32) << 32) | (1 << (i7 % 32)), this.f200L);
                        }
                    }
                }
                for (Label label9 = this.f202N; label9 != null; label9 = label9.f152i) {
                    if ((label9.f144a & 128) != 0) {
                        for (Label label10 = this.f202N; label10 != null; label10 = label10.f152i) {
                            label10.f144a &= -2049;
                        }
                        label9.f153j.f102c.f101b.m1503b(label9, 0, this.f200L);
                    }
                }
            }
            int i8 = 0;
            Label label11 = this.f202N;
            while (label11 != null) {
                label11 = label11.f154k;
                int i9 = label11.f149f;
                int i10 = i9 + label11.f150g;
                if (i10 > i8) {
                    i8 = i10;
                }
                Edge edge4 = label11.f153j;
                if ((label11.f144a & 128) != 0) {
                    edge4 = edge4.f102c;
                }
                while (edge4 != null) {
                    Label label12 = edge4.f101b;
                    if ((label12.f144a & 8) == 0) {
                        label12.f149f = edge4.f100a == Integer.MAX_VALUE ? 1 : i9 + edge4.f100a;
                        label12.f144a |= 8;
                        label12.f154k = label11;
                        label11 = label12;
                    }
                    edge4 = edge4.f102c;
                }
            }
            this.f176s = Math.max(i, i8);
        } else {
            this.f176s = i;
            this.f177t = i2;
        }
    }

    @Override // com.esotericsoftware.asm.MethodVisitor
    public void visitEnd() {
    }

    /* renamed from: a */
    private void m1499a(int i, Label label) {
        Edge edge = new Edge();
        edge.f100a = i;
        edge.f101b = label;
        edge.f102c = this.f204P.f153j;
        this.f204P.f153j = edge;
    }

    /* renamed from: e */
    private void m1485e() {
        if (this.f201M == 0) {
            Label label = new Label();
            label.f151h = new Frame();
            label.f151h.f116b = label;
            label.m1505a(this, this.f175r.f34b, this.f175r.f33a);
            this.f203O.f152i = label;
            this.f203O = label;
        } else {
            this.f204P.f150g = this.f206R;
        }
        this.f204P = null;
    }

    /* renamed from: b */
    private void m1490b(Frame frame) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int[] iArr = frame.f117c;
        int[] iArr2 = frame.f118d;
        int i4 = 0;
        while (i4 < iArr.length) {
            int i5 = iArr[i4];
            if (i5 == 16777216) {
                i++;
            } else {
                i2 += i + 1;
                i = 0;
            }
            if (i5 == 16777220 || i5 == 16777219) {
                i4++;
            }
            i4++;
        }
        int i6 = 0;
        while (i6 < iArr2.length) {
            int i7 = iArr2[i6];
            i3++;
            if (i7 == 16777220 || i7 == 16777219) {
                i6++;
            }
            i6++;
        }
        int a = m1500a(frame.f116b.f146c, i2, i3);
        int i8 = 0;
        while (i2 > 0) {
            int i9 = iArr[i8];
            a++;
            this.f183z[a] = i9;
            if (i9 == 16777220 || i9 == 16777219) {
                i8++;
            }
            i8++;
            i2--;
        }
        int i10 = 0;
        while (i10 < iArr2.length) {
            int i11 = iArr2[i10];
            a++;
            this.f183z[a] = i11;
            if (i11 == 16777220 || i11 == 16777219) {
                i10++;
            }
            i10++;
        }
        m1491b();
    }

    /* renamed from: f */
    private void m1484f() {
        int a = m1500a(0, this.f160f.length() + 1, 0);
        if ((this.f157c & 8) == 0) {
            if ((this.f157c & 524288) == 0) {
                a++;
                this.f183z[a] = 24117248 | this.f156b.m1537c(this.f156b.f55I);
            } else {
                a++;
                this.f183z[a] = 6;
            }
        }
        int i = 1;
        while (true) {
            i++;
            switch (this.f160f.charAt(i)) {
                case 'B':
                case 'C':
                case 'I':
                case 'S':
                case 'Z':
                    a++;
                    this.f183z[a] = 1;
                    break;
                case 'D':
                    a++;
                    this.f183z[a] = 3;
                    break;
                case 'E':
                case 'G':
                case 'H':
                case 'K':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                default:
                    this.f183z[1] = a - 3;
                    m1491b();
                    return;
                case 'F':
                    a++;
                    this.f183z[a] = 2;
                    break;
                case 'J':
                    a++;
                    this.f183z[a] = 4;
                    break;
                case 'L':
                    while (this.f160f.charAt(i) != ';') {
                        i++;
                    }
                    a++;
                    int i2 = i + 1;
                    i++;
                    this.f183z[a] = 24117248 | this.f156b.m1537c(this.f160f.substring(i2, i));
                    break;
                case '[':
                    while (this.f160f.charAt(i) == '[') {
                        i++;
                    }
                    if (this.f160f.charAt(i) == 'L') {
                        while (true) {
                            i++;
                            if (this.f160f.charAt(i) != ';') {
                            }
                        }
                    }
                    a++;
                    i++;
                    this.f183z[a] = 24117248 | this.f156b.m1537c(this.f160f.substring(i, i));
                    break;
            }
        }
    }

    /* renamed from: a */
    private int m1500a(int i, int i2, int i3) {
        int i4 = 3 + i2 + i3;
        if (this.f183z == null || this.f183z.length < i4) {
            this.f183z = new int[i4];
        }
        this.f183z[0] = i;
        this.f183z[1] = i2;
        this.f183z[2] = i3;
        return 3;
    }

    /* renamed from: b */
    private void m1491b() {
        if (this.f182x != null) {
            if (this.f180v == null) {
                this.f180v = new ByteVector();
            }
            m1488c();
            this.f179u++;
        }
        this.f182x = this.f183z;
        this.f183z = null;
    }

    /* renamed from: c */
    private void m1488c() {
        int i = this.f183z[1];
        int i2 = this.f183z[2];
        if ((this.f156b.f42b & 65535) < 50) {
            this.f180v.putShort(this.f183z[0]).putShort(i);
            m1501a(3, 3 + i);
            this.f180v.putShort(i2);
            m1501a(3 + i, 3 + i + i2);
            return;
        }
        int i3 = this.f182x[1];
        char c = 255;
        int i4 = 0;
        int i5 = this.f179u == 0 ? this.f183z[0] : (this.f183z[0] - this.f182x[0]) - 1;
        if (i2 == 0) {
            i4 = i - i3;
            switch (i4) {
                case SelectStrategy.BUSY_WAIT /* -3 */:
                case -2:
                case -1:
                    c = 248;
                    i3 = i;
                    break;
                case 0:
                    c = i5 < 64 ? (char) 0 : 251;
                    break;
                case 1:
                case 2:
                case 3:
                    c = 252;
                    break;
            }
        } else if (i == i3 && i2 == 1) {
            c = i5 < 63 ? '@' : 247;
        }
        if (c != 255) {
            int i6 = 3;
            int i7 = 0;
            while (true) {
                if (i7 < i3) {
                    if (this.f183z[i6] != this.f182x[i6]) {
                        c = 255;
                    } else {
                        i6++;
                        i7++;
                    }
                }
            }
        }
        switch (c) {
            case 0:
                this.f180v.putByte(i5);
                return;
            case '@':
                this.f180v.putByte(64 + i5);
                m1501a(3 + i, 4 + i);
                return;
            case 247:
                this.f180v.putByte(247).putShort(i5);
                m1501a(3 + i, 4 + i);
                return;
            case PacketOpcodes.ScenePlayerLocationNotify /* 248 */:
                this.f180v.putByte(PacketOpcodes.EnterSceneReadyRsp + i4).putShort(i5);
                return;
            case PacketOpcodes.EnterSceneReadyRsp /* 251 */:
                this.f180v.putByte(PacketOpcodes.EnterSceneReadyRsp).putShort(i5);
                return;
            case PacketOpcodes.PersonalSceneJumpReq /* 252 */:
                this.f180v.putByte(PacketOpcodes.EnterSceneReadyRsp + i4).putShort(i5);
                m1501a(3 + i3, 3 + i);
                return;
            default:
                this.f180v.putByte(255).putShort(i5).putShort(i);
                m1501a(3, 3 + i);
                this.f180v.putShort(i2);
                m1501a(3 + i, 3 + i + i2);
                return;
        }
    }

    /* renamed from: a */
    private void m1501a(int i, int i2) {
        for (int i3 = i; i3 < i2; i3++) {
            int i4 = this.f183z[i3];
            int i5 = i4 & -268435456;
            if (i5 == 0) {
                int i6 = i4 & 1048575;
                switch (i4 & 267386880) {
                    case 24117248:
                        this.f180v.putByte(7).putShort(this.f156b.newClass(this.f156b.f51H[i6].f139g));
                        continue;
                    case 25165824:
                        this.f180v.putByte(8).putShort(this.f156b.f51H[i6].f137c);
                        continue;
                    default:
                        this.f180v.putByte(i6);
                        continue;
                }
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                int i7 = i5 >> 28;
                while (true) {
                    i7--;
                    if (i7 > 0) {
                        stringBuffer.append('[');
                    } else {
                        if ((i4 & 267386880) != 24117248) {
                            switch (i4 & 15) {
                                case 1:
                                    stringBuffer.append('I');
                                    break;
                                case 2:
                                    stringBuffer.append('F');
                                    break;
                                case 3:
                                    stringBuffer.append('D');
                                    break;
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                default:
                                    stringBuffer.append('J');
                                    break;
                                case 9:
                                    stringBuffer.append('Z');
                                    break;
                                case 10:
                                    stringBuffer.append('B');
                                    break;
                                case 11:
                                    stringBuffer.append('C');
                                    break;
                                case 12:
                                    stringBuffer.append('S');
                                    break;
                            }
                        } else {
                            stringBuffer.append('L');
                            stringBuffer.append(this.f156b.f51H[i4 & 1048575].f139g);
                            stringBuffer.append(';');
                        }
                        this.f180v.putByte(7).putShort(this.f156b.newClass(stringBuffer.toString()));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m1496a(Object obj) {
        if (obj instanceof String) {
            this.f180v.putByte(7).putShort(this.f156b.newClass((String) obj));
        } else if (obj instanceof Integer) {
            this.f180v.putByte(((Integer) obj).intValue());
        } else {
            this.f180v.putByte(8).putShort(((Label) obj).f146c);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int m1502a() {
        if (this.f162h != 0) {
            return 6 + this.f163i;
        }
        int i = 8;
        if (this.f175r.f34b > 0) {
            if (this.f175r.f34b > 65535) {
                throw new RuntimeException("Method code too large!");
            }
            this.f156b.newUTF8(CodeAttribute.tag);
            i = 8 + 18 + this.f175r.f34b + (8 * this.f184A);
            if (this.f190E != null) {
                this.f156b.newUTF8(LocalVariableAttribute.tag);
                i += 8 + this.f190E.f34b;
            }
            if (this.f192G != null) {
                this.f156b.newUTF8("LocalVariableTypeTable");
                i += 8 + this.f192G.f34b;
            }
            if (this.f194I != null) {
                this.f156b.newUTF8(LineNumberAttribute.tag);
                i += 8 + this.f194I.f34b;
            }
            if (this.f180v != null) {
                this.f156b.newUTF8((this.f156b.f42b & 65535) >= 50 ? StackMapTable.tag : StackMap.tag);
                i += 8 + this.f180v.f34b;
            }
            if (this.f196W != null) {
                this.f156b.newUTF8(TypeAnnotationsAttribute.visibleTag);
                i += 8 + this.f196W.m1584a();
            }
            if (this.f197X != null) {
                this.f156b.newUTF8(TypeAnnotationsAttribute.invisibleTag);
                i += 8 + this.f197X.m1584a();
            }
            if (this.f198J != null) {
                i += this.f198J.m1579a(this.f156b, this.f175r.f33a, this.f175r.f34b, this.f176s, this.f177t);
            }
        }
        if (this.f164j > 0) {
            this.f156b.newUTF8(ExceptionsAttribute.tag);
            i += 8 + (2 * this.f164j);
        }
        if ((this.f157c & 4096) != 0 && ((this.f156b.f42b & 65535) < 49 || (this.f157c & 262144) != 0)) {
            this.f156b.newUTF8(SyntheticAttribute.tag);
            i += 6;
        }
        if ((this.f157c & 131072) != 0) {
            this.f156b.newUTF8(DeprecatedAttribute.tag);
            i += 6;
        }
        if (this.f161g != null) {
            this.f156b.newUTF8(SignatureAttribute.tag);
            this.f156b.newUTF8(this.f161g);
            i += 8;
        }
        if (this.f188$ != null) {
            this.f156b.newUTF8(MethodParametersAttribute.tag);
            i += 7 + this.f188$.f34b;
        }
        if (this.f166l != null) {
            this.f156b.newUTF8(AnnotationDefaultAttribute.tag);
            i += 6 + this.f166l.f34b;
        }
        if (this.f167m != null) {
            this.f156b.newUTF8(AnnotationsAttribute.visibleTag);
            i += 8 + this.f167m.m1584a();
        }
        if (this.f168n != null) {
            this.f156b.newUTF8(AnnotationsAttribute.invisibleTag);
            i += 8 + this.f168n.m1584a();
        }
        if (this.f169U != null) {
            this.f156b.newUTF8(TypeAnnotationsAttribute.visibleTag);
            i += 8 + this.f169U.m1584a();
        }
        if (this.f170V != null) {
            this.f156b.newUTF8(TypeAnnotationsAttribute.invisibleTag);
            i += 8 + this.f170V.m1584a();
        }
        if (this.f171o != null) {
            this.f156b.newUTF8(ParameterAnnotationsAttribute.visibleTag);
            i += 7 + (2 * (this.f171o.length - this.f173S));
            for (int length = this.f171o.length - 1; length >= this.f173S; length--) {
                i += this.f171o[length] == null ? 0 : this.f171o[length].m1584a();
            }
        }
        if (this.f172p != null) {
            this.f156b.newUTF8(ParameterAnnotationsAttribute.invisibleTag);
            i += 7 + (2 * (this.f172p.length - this.f173S));
            for (int length2 = this.f172p.length - 1; length2 >= this.f173S; length2--) {
                i += this.f172p[length2] == null ? 0 : this.f172p[length2].m1584a();
            }
        }
        if (this.f174q != null) {
            i += this.f174q.m1579a(this.f156b, null, 0, -1, -1);
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m1498a(ByteVector byteVector) {
        byteVector.putShort(this.f157c & ((917504 | ((this.f157c & 262144) / 64)) ^ -1)).putShort(this.f158d).putShort(this.f159e);
        if (this.f162h != 0) {
            byteVector.putByteArray(this.f156b.f41M.f35b, this.f162h, this.f163i);
            return;
        }
        int i = 0;
        if (this.f175r.f34b > 0) {
            i = 0 + 1;
        }
        if (this.f164j > 0) {
            i++;
        }
        if ((this.f157c & 4096) != 0 && ((this.f156b.f42b & 65535) < 49 || (this.f157c & 262144) != 0)) {
            i++;
        }
        if ((this.f157c & 131072) != 0) {
            i++;
        }
        if (this.f161g != null) {
            i++;
        }
        if (this.f188$ != null) {
            i++;
        }
        if (this.f166l != null) {
            i++;
        }
        if (this.f167m != null) {
            i++;
        }
        if (this.f168n != null) {
            i++;
        }
        if (this.f169U != null) {
            i++;
        }
        if (this.f170V != null) {
            i++;
        }
        if (this.f171o != null) {
            i++;
        }
        if (this.f172p != null) {
            i++;
        }
        if (this.f174q != null) {
            i += this.f174q.m1580a();
        }
        byteVector.putShort(i);
        if (this.f175r.f34b > 0) {
            int i2 = 12 + this.f175r.f34b + (8 * this.f184A);
            if (this.f190E != null) {
                i2 += 8 + this.f190E.f34b;
            }
            if (this.f192G != null) {
                i2 += 8 + this.f192G.f34b;
            }
            if (this.f194I != null) {
                i2 += 8 + this.f194I.f34b;
            }
            if (this.f180v != null) {
                i2 += 8 + this.f180v.f34b;
            }
            if (this.f196W != null) {
                i2 += 8 + this.f196W.m1584a();
            }
            if (this.f197X != null) {
                i2 += 8 + this.f197X.m1584a();
            }
            if (this.f198J != null) {
                i2 += this.f198J.m1579a(this.f156b, this.f175r.f33a, this.f175r.f34b, this.f176s, this.f177t);
            }
            byteVector.putShort(this.f156b.newUTF8(CodeAttribute.tag)).putInt(i2);
            byteVector.putShort(this.f176s).putShort(this.f177t);
            byteVector.putInt(this.f175r.f34b).putByteArray(this.f175r.f33a, 0, this.f175r.f34b);
            byteVector.putShort(this.f184A);
            if (this.f184A > 0) {
                for (Handler handler = this.f185B; handler != null; handler = handler.f134f) {
                    byteVector.putShort(handler.f129a.f146c).putShort(handler.f130b.f146c).putShort(handler.f131c.f146c).putShort(handler.f133e);
                }
            }
            int i3 = 0;
            if (this.f190E != null) {
                i3 = 0 + 1;
            }
            if (this.f192G != null) {
                i3++;
            }
            if (this.f194I != null) {
                i3++;
            }
            if (this.f180v != null) {
                i3++;
            }
            if (this.f196W != null) {
                i3++;
            }
            if (this.f197X != null) {
                i3++;
            }
            if (this.f198J != null) {
                i3 += this.f198J.m1580a();
            }
            byteVector.putShort(i3);
            if (this.f190E != null) {
                byteVector.putShort(this.f156b.newUTF8(LocalVariableAttribute.tag));
                byteVector.putInt(this.f190E.f34b + 2).putShort(this.f189D);
                byteVector.putByteArray(this.f190E.f33a, 0, this.f190E.f34b);
            }
            if (this.f192G != null) {
                byteVector.putShort(this.f156b.newUTF8("LocalVariableTypeTable"));
                byteVector.putInt(this.f192G.f34b + 2).putShort(this.f191F);
                byteVector.putByteArray(this.f192G.f33a, 0, this.f192G.f34b);
            }
            if (this.f194I != null) {
                byteVector.putShort(this.f156b.newUTF8(LineNumberAttribute.tag));
                byteVector.putInt(this.f194I.f34b + 2).putShort(this.f193H);
                byteVector.putByteArray(this.f194I.f33a, 0, this.f194I.f34b);
            }
            if (this.f180v != null) {
                byteVector.putShort(this.f156b.newUTF8((this.f156b.f42b & 65535) >= 50 ? StackMapTable.tag : StackMap.tag));
                byteVector.putInt(this.f180v.f34b + 2).putShort(this.f179u);
                byteVector.putByteArray(this.f180v.f33a, 0, this.f180v.f34b);
            }
            if (this.f196W != null) {
                byteVector.putShort(this.f156b.newUTF8(TypeAnnotationsAttribute.visibleTag));
                this.f196W.m1582a(byteVector);
            }
            if (this.f197X != null) {
                byteVector.putShort(this.f156b.newUTF8(TypeAnnotationsAttribute.invisibleTag));
                this.f197X.m1582a(byteVector);
            }
            if (this.f198J != null) {
                this.f198J.m1578a(this.f156b, this.f175r.f33a, this.f175r.f34b, this.f177t, this.f176s, byteVector);
            }
        }
        if (this.f164j > 0) {
            byteVector.putShort(this.f156b.newUTF8(ExceptionsAttribute.tag)).putInt((2 * this.f164j) + 2);
            byteVector.putShort(this.f164j);
            for (int i4 = 0; i4 < this.f164j; i4++) {
                byteVector.putShort(this.f165k[i4]);
            }
        }
        if ((this.f157c & 4096) != 0 && ((this.f156b.f42b & 65535) < 49 || (this.f157c & 262144) != 0)) {
            byteVector.putShort(this.f156b.newUTF8(SyntheticAttribute.tag)).putInt(0);
        }
        if ((this.f157c & 131072) != 0) {
            byteVector.putShort(this.f156b.newUTF8(DeprecatedAttribute.tag)).putInt(0);
        }
        if (this.f161g != null) {
            byteVector.putShort(this.f156b.newUTF8(SignatureAttribute.tag)).putInt(2).putShort(this.f156b.newUTF8(this.f161g));
        }
        if (this.f188$ != null) {
            byteVector.putShort(this.f156b.newUTF8(MethodParametersAttribute.tag));
            byteVector.putInt(this.f188$.f34b + 1).putByte(this.f187Z);
            byteVector.putByteArray(this.f188$.f33a, 0, this.f188$.f34b);
        }
        if (this.f166l != null) {
            byteVector.putShort(this.f156b.newUTF8(AnnotationDefaultAttribute.tag));
            byteVector.putInt(this.f166l.f34b);
            byteVector.putByteArray(this.f166l.f33a, 0, this.f166l.f34b);
        }
        if (this.f167m != null) {
            byteVector.putShort(this.f156b.newUTF8(AnnotationsAttribute.visibleTag));
            this.f167m.m1582a(byteVector);
        }
        if (this.f168n != null) {
            byteVector.putShort(this.f156b.newUTF8(AnnotationsAttribute.invisibleTag));
            this.f168n.m1582a(byteVector);
        }
        if (this.f169U != null) {
            byteVector.putShort(this.f156b.newUTF8(TypeAnnotationsAttribute.visibleTag));
            this.f169U.m1582a(byteVector);
        }
        if (this.f170V != null) {
            byteVector.putShort(this.f156b.newUTF8(TypeAnnotationsAttribute.invisibleTag));
            this.f170V.m1582a(byteVector);
        }
        if (this.f171o != null) {
            byteVector.putShort(this.f156b.newUTF8(ParameterAnnotationsAttribute.visibleTag));
            AnnotationWriter.m1581a(this.f171o, this.f173S, byteVector);
        }
        if (this.f172p != null) {
            byteVector.putShort(this.f156b.newUTF8(ParameterAnnotationsAttribute.invisibleTag));
            AnnotationWriter.m1581a(this.f172p, this.f173S, byteVector);
        }
        if (this.f174q != null) {
            this.f174q.m1578a(this.f156b, null, 0, -1, -1, byteVector);
        }
    }

    /* renamed from: d */
    private void m1486d() {
        int i;
        int i2;
        byte[] bArr = this.f175r.f33a;
        int[] iArr = new int[0];
        int[] iArr2 = new int[0];
        boolean[] zArr = new boolean[this.f175r.f34b];
        int i3 = 3;
        do {
            if (i3 == 3) {
                i3 = 2;
            }
            int i4 = 0;
            while (i4 < bArr.length) {
                int i5 = bArr[i4] & 255;
                int i6 = 0;
                switch (ClassWriter.f40a[i5]) {
                    case 0:
                    case 4:
                        i4++;
                        break;
                    case 1:
                    case 3:
                    case 11:
                        i4 += 2;
                        break;
                    case 2:
                    case 5:
                    case 6:
                    case 12:
                    case 13:
                        i4 += 3;
                        break;
                    case 7:
                    case 8:
                        i4 += 5;
                        break;
                    case 9:
                        if (i5 > 201) {
                            i5 = i5 < 218 ? i5 - 49 : i5 - 20;
                            i2 = i4 + m1487c(bArr, i4 + 1);
                        } else {
                            i2 = i4 + m1489b(bArr, i4 + 1);
                        }
                        int a = m1493a(iArr, iArr2, i4, i2);
                        if ((a < -32768 || a > 32767) && !zArr[i4]) {
                            i6 = (i5 == 167 || i5 == 168) ? 2 : 5;
                            zArr[i4] = true;
                        }
                        i4 += 3;
                        break;
                    case 10:
                        i4 += 5;
                        break;
                    case 14:
                        if (i3 == 1) {
                            i6 = -(m1493a(iArr, iArr2, 0, i4) & 3);
                        } else if (!zArr[i4]) {
                            i6 = i4 & 3;
                            zArr[i4] = true;
                        }
                        int i7 = (i4 + 4) - (i4 & 3);
                        i4 = i7 + (4 * ((m1495a(bArr, i7 + 8) - m1495a(bArr, i7 + 4)) + 1)) + 12;
                        break;
                    case 15:
                        if (i3 == 1) {
                            i6 = -(m1493a(iArr, iArr2, 0, i4) & 3);
                        } else if (!zArr[i4]) {
                            i6 = i4 & 3;
                            zArr[i4] = true;
                        }
                        int i8 = (i4 + 4) - (i4 & 3);
                        i4 = i8 + (8 * m1495a(bArr, i8 + 4)) + 8;
                        break;
                    case 16:
                    default:
                        i4 += 4;
                        break;
                    case 17:
                        if ((bArr[i4 + 1] & 255) == 132) {
                            i4 += 6;
                            break;
                        } else {
                            i4 += 4;
                            break;
                        }
                }
                if (i6 != 0) {
                    int[] iArr3 = new int[iArr.length + 1];
                    int[] iArr4 = new int[iArr2.length + 1];
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                    System.arraycopy(iArr2, 0, iArr4, 0, iArr2.length);
                    iArr3[iArr.length] = i4;
                    iArr4[iArr2.length] = i6;
                    iArr = iArr3;
                    iArr2 = iArr4;
                    if (i6 > 0) {
                        i3 = 3;
                    }
                }
            }
            if (i3 < 3) {
                i3--;
            }
        } while (i3 != 0);
        ByteVector byteVector = new ByteVector(this.f175r.f34b);
        short s = 0;
        while (s < this.f175r.f34b) {
            int i9 = bArr[s] & 255;
            switch (ClassWriter.f40a[i9]) {
                case 0:
                case 4:
                    byteVector.putByte(i9);
                    s++;
                    break;
                case 1:
                case 3:
                case 11:
                    byteVector.putByteArray(bArr, s, 2);
                    s += 2;
                    break;
                case 2:
                case 5:
                case 6:
                case 12:
                case 13:
                    byteVector.putByteArray(bArr, s, 3);
                    s += 3;
                    break;
                case 7:
                case 8:
                    byteVector.putByteArray(bArr, s, 5);
                    s += 5;
                    break;
                case 9:
                    if (i9 > 201) {
                        i9 = i9 < 218 ? i9 - 49 : i9 - 20;
                        i = s + m1487c(bArr, s + 1);
                    } else {
                        i = s + m1489b(bArr, s + 1);
                    }
                    int a2 = m1493a(iArr, iArr2, s, i);
                    if (zArr[s]) {
                        if (i9 == 167) {
                            byteVector.putByte(200);
                        } else if (i9 == 168) {
                            byteVector.putByte(201);
                        } else {
                            byteVector.putByte(i9 <= 166 ? ((i9 + 1) ^ 1) - 1 : i9 ^ 1);
                            byteVector.putShort(8);
                            byteVector.putByte(200);
                            a2 -= 3;
                        }
                        byteVector.putInt(a2);
                    } else {
                        byteVector.putByte(i9);
                        byteVector.putShort(a2);
                    }
                    s += 3;
                    break;
                case 10:
                    int a3 = m1493a(iArr, iArr2, s, s + m1495a(bArr, s + 1));
                    byteVector.putByte(i9);
                    byteVector.putInt(a3);
                    s += 5;
                    break;
                case 14:
                    int i10 = (s + 4) - (s & 3);
                    byteVector.putByte(170);
                    byteVector.putByteArray(null, 0, (4 - (byteVector.f34b % 4)) % 4);
                    int a4 = s + m1495a(bArr, i10);
                    int i11 = i10 + 4;
                    byteVector.putInt(m1493a(iArr, iArr2, s, a4));
                    int a5 = m1495a(bArr, i11);
                    int i12 = i11 + 4;
                    byteVector.putInt(a5);
                    s = i12 + 4;
                    byteVector.putInt(m1495a(bArr, s - 4));
                    for (int a6 = (m1495a(bArr, i12) - a5) + 1; a6 > 0; a6--) {
                        int a7 = s + m1495a(bArr, s);
                        s += 4;
                        byteVector.putInt(m1493a(iArr, iArr2, s, a7));
                    }
                    break;
                case 15:
                    int i13 = (s + 4) - (s & 3);
                    byteVector.putByte(171);
                    byteVector.putByteArray(null, 0, (4 - (byteVector.f34b % 4)) % 4);
                    int a8 = s + m1495a(bArr, i13);
                    int i14 = i13 + 4;
                    byteVector.putInt(m1493a(iArr, iArr2, s, a8));
                    int a9 = m1495a(bArr, i14);
                    s = i14 + 4;
                    byteVector.putInt(a9);
                    while (a9 > 0) {
                        byteVector.putInt(m1495a(bArr, s));
                        int i15 = s + 4;
                        int a10 = s + m1495a(bArr, i15);
                        s = i15 + 4;
                        byteVector.putInt(m1493a(iArr, iArr2, s, a10));
                        a9--;
                    }
                    break;
                case 16:
                default:
                    byteVector.putByteArray(bArr, s, 4);
                    s += 4;
                    break;
                case 17:
                    if ((bArr[s + 1] & 255) == 132) {
                        byteVector.putByteArray(bArr, s, 6);
                        s += 6;
                        break;
                    } else {
                        byteVector.putByteArray(bArr, s, 4);
                        s += 4;
                        break;
                    }
            }
        }
        if (this.f201M == 0) {
            for (Label label = this.f202N; label != null; label = label.f152i) {
                int i16 = label.f146c - 3;
                if (i16 >= 0 && zArr[i16]) {
                    label.f144a |= 16;
                }
                m1492a(iArr, iArr2, label);
            }
            if (this.f156b.f51H != null) {
                for (int i17 = 0; i17 < this.f156b.f51H.length; i17++) {
                    Item item = this.f156b.f51H[i17];
                    if (item != null && item.f136b == 31) {
                        item.f137c = m1493a(iArr, iArr2, 0, item.f137c);
                    }
                }
            }
        } else if (this.f179u > 0) {
            this.f156b.f79L = true;
        }
        for (Handler handler = this.f185B; handler != null; handler = handler.f134f) {
            m1492a(iArr, iArr2, handler.f129a);
            m1492a(iArr, iArr2, handler.f130b);
            m1492a(iArr, iArr2, handler.f131c);
        }
        int i18 = 0;
        while (i18 < 2) {
            ByteVector byteVector2 = i18 == 0 ? this.f190E : this.f192G;
            if (byteVector2 != null) {
                byte[] bArr2 = byteVector2.f33a;
                for (int i19 = 0; i19 < byteVector2.f34b; i19 += 10) {
                    int c = m1487c(bArr2, i19);
                    int a11 = m1493a(iArr, iArr2, 0, c);
                    m1494a(bArr2, i19, a11);
                    m1494a(bArr2, i19 + 2, m1493a(iArr, iArr2, 0, c + m1487c(bArr2, i19 + 2)) - a11);
                }
            }
            i18++;
        }
        if (this.f194I != null) {
            byte[] bArr3 = this.f194I.f33a;
            for (int i20 = 0; i20 < this.f194I.f34b; i20 += 4) {
                m1494a(bArr3, i20, m1493a(iArr, iArr2, 0, m1487c(bArr3, i20)));
            }
        }
        for (Attribute attribute = this.f198J; attribute != null; attribute = attribute.f32a) {
            Label[] labels = attribute.getLabels();
            if (labels != null) {
                for (int length = labels.length - 1; length >= 0; length--) {
                    m1492a(iArr, iArr2, labels[length]);
                }
            }
        }
        this.f175r = byteVector;
    }

    /* renamed from: c */
    static int m1487c(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 8) | (bArr[i + 1] & 255);
    }

    /* renamed from: b */
    static short m1489b(byte[] bArr, int i) {
        return (short) (((bArr[i] & 255) << 8) | (bArr[i + 1] & 255));
    }

    /* renamed from: a */
    static int m1495a(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8) | (bArr[i + 3] & 255);
    }

    /* renamed from: a */
    static void m1494a(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >>> 8);
        bArr[i + 1] = (byte) i2;
    }

    /* renamed from: a */
    static int m1493a(int[] iArr, int[] iArr2, int i, int i2) {
        int i3 = i2 - i;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            if (i < iArr[i4] && iArr[i4] <= i2) {
                i3 += iArr2[i4];
            } else if (i2 < iArr[i4] && iArr[i4] <= i) {
                i3 -= iArr2[i4];
            }
        }
        return i3;
    }

    /* renamed from: a */
    static void m1492a(int[] iArr, int[] iArr2, Label label) {
        if ((label.f144a & 4) == 0) {
            label.f146c = m1493a(iArr, iArr2, 0, label.f146c);
            label.f144a |= 4;
        }
    }
}
