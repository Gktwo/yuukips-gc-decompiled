package com.esotericsoftware.asm;

import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.BootstrapMethodsAttribute;
import javassist.bytecode.DeprecatedAttribute;
import javassist.bytecode.EnclosingMethodAttribute;
import javassist.bytecode.InnerClassesAttribute;
import javassist.bytecode.SignatureAttribute;
import javassist.bytecode.SourceFileAttribute;
import javassist.bytecode.SyntheticAttribute;
import javassist.bytecode.TypeAnnotationsAttribute;
import net.bytebuddy.implementation.auxiliary.TypeProxy;

/* loaded from: grasscutter.jar:com/esotericsoftware/asm/ClassWriter.class */
public class ClassWriter extends ClassVisitor {
    public static final int COMPUTE_MAXS = 1;
    public static final int COMPUTE_FRAMES = 2;

    /* renamed from: a */
    static final byte[] f40a;

    /* renamed from: M */
    ClassReader f41M;

    /* renamed from: b */
    int f42b;

    /* renamed from: c */
    int f43c;

    /* renamed from: d */
    final ByteVector f44d;

    /* renamed from: e */
    Item[] f45e;

    /* renamed from: f */
    int f46f;

    /* renamed from: g */
    final Item f47g;

    /* renamed from: h */
    final Item f48h;

    /* renamed from: i */
    final Item f49i;

    /* renamed from: j */
    final Item f50j;

    /* renamed from: H */
    Item[] f51H;

    /* renamed from: G */
    private short f52G;

    /* renamed from: k */
    private int f53k;

    /* renamed from: l */
    private int f54l;

    /* renamed from: I */
    String f55I;

    /* renamed from: m */
    private int f56m;

    /* renamed from: n */
    private int f57n;

    /* renamed from: o */
    private int f58o;

    /* renamed from: p */
    private int[] f59p;

    /* renamed from: q */
    private int f60q;

    /* renamed from: r */
    private ByteVector f61r;

    /* renamed from: s */
    private int f62s;

    /* renamed from: t */
    private int f63t;

    /* renamed from: u */
    private AnnotationWriter f64u;

    /* renamed from: v */
    private AnnotationWriter f65v;

    /* renamed from: N */
    private AnnotationWriter f66N;

    /* renamed from: O */
    private AnnotationWriter f67O;

    /* renamed from: w */
    private Attribute f68w;

    /* renamed from: x */
    private int f69x;

    /* renamed from: y */
    private ByteVector f70y;

    /* renamed from: z */
    int f71z;

    /* renamed from: A */
    ByteVector f72A;

    /* renamed from: B */
    FieldWriter f73B;

    /* renamed from: C */
    FieldWriter f74C;

    /* renamed from: D */
    MethodWriter f75D;

    /* renamed from: E */
    MethodWriter f76E;

    /* renamed from: K */
    private boolean f77K;

    /* renamed from: J */
    private boolean f78J;

    /* renamed from: L */
    boolean f79L;

    public ClassWriter(int i) {
        super(327680);
        this.f43c = 1;
        this.f44d = new ByteVector();
        this.f45e = new Item[256];
        this.f46f = (int) (0.75d * ((double) this.f45e.length));
        this.f47g = new Item();
        this.f48h = new Item();
        this.f49i = new Item();
        this.f50j = new Item();
        this.f77K = (i & 1) != 0;
        this.f78J = (i & 2) != 0;
    }

    public ClassWriter(ClassReader classReader, int i) {
        this(i);
        classReader.m1567a(this);
        this.f41M = classReader;
    }

    @Override // com.esotericsoftware.asm.ClassVisitor
    public final void visit(int i, int i2, String str, String str2, String str3, String[] strArr) {
        this.f42b = i;
        this.f53k = i2;
        this.f54l = newClass(str);
        this.f55I = str;
        if (str2 != null) {
            this.f56m = newUTF8(str2);
        }
        this.f57n = str3 == null ? 0 : newClass(str3);
        if (strArr != null && strArr.length > 0) {
            this.f58o = strArr.length;
            this.f59p = new int[this.f58o];
            for (int i3 = 0; i3 < this.f58o; i3++) {
                this.f59p[i3] = newClass(strArr[i3]);
            }
        }
    }

    @Override // com.esotericsoftware.asm.ClassVisitor
    public final void visitSource(String str, String str2) {
        if (str != null) {
            this.f60q = newUTF8(str);
        }
        if (str2 != null) {
            this.f61r = new ByteVector().m1574c(str2, 0, Integer.MAX_VALUE);
        }
    }

    @Override // com.esotericsoftware.asm.ClassVisitor
    public final void visitOuterClass(String str, String str2, String str3) {
        this.f62s = newClass(str);
        if (str2 != null && str3 != null) {
            this.f63t = newNameType(str2, str3);
        }
    }

    @Override // com.esotericsoftware.asm.ClassVisitor
    public final AnnotationVisitor visitAnnotation(String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this, true, byteVector, byteVector, 2);
        if (z) {
            annotationWriter.f29g = this.f64u;
            this.f64u = annotationWriter;
        } else {
            annotationWriter.f29g = this.f65v;
            this.f65v = annotationWriter;
        }
        return annotationWriter;
    }

    @Override // com.esotericsoftware.asm.ClassVisitor
    public final AnnotationVisitor visitTypeAnnotation(int i, TypePath typePath, String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        AnnotationWriter.m1583a(i, typePath, byteVector);
        byteVector.putShort(newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this, true, byteVector, byteVector, byteVector.f34b - 2);
        if (z) {
            annotationWriter.f29g = this.f66N;
            this.f66N = annotationWriter;
        } else {
            annotationWriter.f29g = this.f67O;
            this.f67O = annotationWriter;
        }
        return annotationWriter;
    }

    @Override // com.esotericsoftware.asm.ClassVisitor
    public final void visitAttribute(Attribute attribute) {
        attribute.f32a = this.f68w;
        this.f68w = attribute;
    }

    @Override // com.esotericsoftware.asm.ClassVisitor
    public final void visitInnerClass(String str, String str2, String str3, int i) {
        if (this.f70y == null) {
            this.f70y = new ByteVector();
        }
        Item a = m1547a(str);
        if (a.f137c == 0) {
            this.f69x++;
            this.f70y.putShort(a.f135a);
            this.f70y.putShort(str2 == null ? 0 : newClass(str2));
            this.f70y.putShort(str3 == null ? 0 : newUTF8(str3));
            this.f70y.putShort(i);
            a.f137c = this.f69x;
        }
    }

    @Override // com.esotericsoftware.asm.ClassVisitor
    public final FieldVisitor visitField(int i, String str, String str2, String str3, Object obj) {
        return new FieldWriter(this, i, str, str2, str3, obj);
    }

    @Override // com.esotericsoftware.asm.ClassVisitor
    public final MethodVisitor visitMethod(int i, String str, String str2, String str3, String[] strArr) {
        return new MethodWriter(this, i, str, str2, str3, strArr, this.f77K, this.f78J);
    }

    @Override // com.esotericsoftware.asm.ClassVisitor
    public final void visitEnd() {
    }

    public byte[] toByteArray() {
        if (this.f43c > 65535) {
            throw new RuntimeException("Class file too large!");
        }
        int i = 24 + (2 * this.f58o);
        int i2 = 0;
        for (FieldWriter fieldWriter = this.f73B; fieldWriter != null; fieldWriter = (FieldWriter) fieldWriter.f103fv) {
            i2++;
            i += fieldWriter.m1535a();
        }
        int i3 = 0;
        for (MethodWriter methodWriter = this.f75D; methodWriter != null; methodWriter = (MethodWriter) methodWriter.f155mv) {
            i3++;
            i += methodWriter.m1502a();
        }
        int i4 = 0;
        if (this.f72A != null) {
            i4 = 0 + 1;
            i += 8 + this.f72A.f34b;
            newUTF8(BootstrapMethodsAttribute.tag);
        }
        if (this.f56m != 0) {
            i4++;
            i += 8;
            newUTF8(SignatureAttribute.tag);
        }
        if (this.f60q != 0) {
            i4++;
            i += 8;
            newUTF8(SourceFileAttribute.tag);
        }
        if (this.f61r != null) {
            i4++;
            i += this.f61r.f34b + 6;
            newUTF8("SourceDebugExtension");
        }
        if (this.f62s != 0) {
            i4++;
            i += 10;
            newUTF8(EnclosingMethodAttribute.tag);
        }
        if ((this.f53k & 131072) != 0) {
            i4++;
            i += 6;
            newUTF8(DeprecatedAttribute.tag);
        }
        if ((this.f53k & 4096) != 0 && ((this.f42b & 65535) < 49 || (this.f53k & 262144) != 0)) {
            i4++;
            i += 6;
            newUTF8(SyntheticAttribute.tag);
        }
        if (this.f70y != null) {
            i4++;
            i += 8 + this.f70y.f34b;
            newUTF8(InnerClassesAttribute.tag);
        }
        if (this.f64u != null) {
            i4++;
            i += 8 + this.f64u.m1584a();
            newUTF8(AnnotationsAttribute.visibleTag);
        }
        if (this.f65v != null) {
            i4++;
            i += 8 + this.f65v.m1584a();
            newUTF8(AnnotationsAttribute.invisibleTag);
        }
        if (this.f66N != null) {
            i4++;
            i += 8 + this.f66N.m1584a();
            newUTF8(TypeAnnotationsAttribute.visibleTag);
        }
        if (this.f67O != null) {
            i4++;
            i += 8 + this.f67O.m1584a();
            newUTF8(TypeAnnotationsAttribute.invisibleTag);
        }
        if (this.f68w != null) {
            i4 += this.f68w.m1580a();
            i += this.f68w.m1579a(this, null, 0, -1, -1);
        }
        ByteVector byteVector = new ByteVector(i + this.f44d.f34b);
        byteVector.putInt(-889275714).putInt(this.f42b);
        byteVector.putShort(this.f43c).putByteArray(this.f44d.f33a, 0, this.f44d.f34b);
        byteVector.putShort(this.f53k & ((393216 | ((this.f53k & 262144) / 64)) ^ -1)).putShort(this.f54l).putShort(this.f57n);
        byteVector.putShort(this.f58o);
        for (int i5 = 0; i5 < this.f58o; i5++) {
            byteVector.putShort(this.f59p[i5]);
        }
        byteVector.putShort(i2);
        for (FieldWriter fieldWriter2 = this.f73B; fieldWriter2 != null; fieldWriter2 = (FieldWriter) fieldWriter2.f103fv) {
            fieldWriter2.m1534a(byteVector);
        }
        byteVector.putShort(i3);
        for (MethodWriter methodWriter2 = this.f75D; methodWriter2 != null; methodWriter2 = (MethodWriter) methodWriter2.f155mv) {
            methodWriter2.m1498a(byteVector);
        }
        byteVector.putShort(i4);
        if (this.f72A != null) {
            byteVector.putShort(newUTF8(BootstrapMethodsAttribute.tag));
            byteVector.putInt(this.f72A.f34b + 2).putShort(this.f71z);
            byteVector.putByteArray(this.f72A.f33a, 0, this.f72A.f34b);
        }
        if (this.f56m != 0) {
            byteVector.putShort(newUTF8(SignatureAttribute.tag)).putInt(2).putShort(this.f56m);
        }
        if (this.f60q != 0) {
            byteVector.putShort(newUTF8(SourceFileAttribute.tag)).putInt(2).putShort(this.f60q);
        }
        if (this.f61r != null) {
            int i6 = this.f61r.f34b;
            byteVector.putShort(newUTF8("SourceDebugExtension")).putInt(i6);
            byteVector.putByteArray(this.f61r.f33a, 0, i6);
        }
        if (this.f62s != 0) {
            byteVector.putShort(newUTF8(EnclosingMethodAttribute.tag)).putInt(4);
            byteVector.putShort(this.f62s).putShort(this.f63t);
        }
        if ((this.f53k & 131072) != 0) {
            byteVector.putShort(newUTF8(DeprecatedAttribute.tag)).putInt(0);
        }
        if ((this.f53k & 4096) != 0 && ((this.f42b & 65535) < 49 || (this.f53k & 262144) != 0)) {
            byteVector.putShort(newUTF8(SyntheticAttribute.tag)).putInt(0);
        }
        if (this.f70y != null) {
            byteVector.putShort(newUTF8(InnerClassesAttribute.tag));
            byteVector.putInt(this.f70y.f34b + 2).putShort(this.f69x);
            byteVector.putByteArray(this.f70y.f33a, 0, this.f70y.f34b);
        }
        if (this.f64u != null) {
            byteVector.putShort(newUTF8(AnnotationsAttribute.visibleTag));
            this.f64u.m1582a(byteVector);
        }
        if (this.f65v != null) {
            byteVector.putShort(newUTF8(AnnotationsAttribute.invisibleTag));
            this.f65v.m1582a(byteVector);
        }
        if (this.f66N != null) {
            byteVector.putShort(newUTF8(TypeAnnotationsAttribute.visibleTag));
            this.f66N.m1582a(byteVector);
        }
        if (this.f67O != null) {
            byteVector.putShort(newUTF8(TypeAnnotationsAttribute.invisibleTag));
            this.f67O.m1582a(byteVector);
        }
        if (this.f68w != null) {
            this.f68w.m1578a(this, null, 0, -1, -1, byteVector);
        }
        if (!this.f79L) {
            return byteVector.f33a;
        }
        this.f64u = null;
        this.f65v = null;
        this.f68w = null;
        this.f69x = 0;
        this.f70y = null;
        this.f71z = 0;
        this.f72A = null;
        this.f73B = null;
        this.f74C = null;
        this.f75D = null;
        this.f76E = null;
        this.f77K = false;
        this.f78J = true;
        this.f79L = false;
        new ClassReader(byteVector.f33a).accept(this, 4);
        return toByteArray();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Item m1548a(Object obj) {
        if (obj instanceof Integer) {
            return m1554a(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return m1554a(((Byte) obj).intValue());
        }
        if (obj instanceof Character) {
            return m1554a((int) ((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return m1554a(((Short) obj).intValue());
        }
        if (obj instanceof Boolean) {
            return m1554a(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return m1555a(((Float) obj).floatValue());
        } else {
            if (obj instanceof Long) {
                return m1550a(((Long) obj).longValue());
            }
            if (obj instanceof Double) {
                return m1556a(((Double) obj).doubleValue());
            }
            if (obj instanceof String) {
                return m1539b((String) obj);
            }
            if (obj instanceof Type) {
                Type type = (Type) obj;
                int sort = type.getSort();
                return sort == 10 ? m1547a(type.getInternalName()) : sort == 11 ? m1536c(type.getDescriptor()) : m1547a(type.getDescriptor());
            } else if (obj instanceof Handle) {
                Handle handle = (Handle) obj;
                return m1551a(handle.f124a, handle.f125b, handle.f126c, handle.f127d, handle.f128e);
            } else {
                throw new IllegalArgumentException(new StringBuffer().append("value ").append(obj).toString());
            }
        }
    }

    public int newConst(Object obj) {
        return m1548a(obj).f135a;
    }

    public int newUTF8(String str) {
        this.f47g.m1514a(1, str, null, null);
        Item a = m1549a(this.f47g);
        if (a == null) {
            this.f44d.putByte(1).putUTF8(str);
            int i = this.f43c;
            this.f43c = i + 1;
            a = new Item(i, this.f47g);
            m1540b(a);
        }
        return a.f135a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Item m1547a(String str) {
        this.f48h.m1514a(7, str, null, null);
        Item a = m1549a(this.f48h);
        if (a == null) {
            this.f44d.m1575b(7, newUTF8(str));
            int i = this.f43c;
            this.f43c = i + 1;
            a = new Item(i, this.f48h);
            m1540b(a);
        }
        return a;
    }

    public int newClass(String str) {
        return m1547a(str).f135a;
    }

    /* renamed from: c */
    Item m1536c(String str) {
        this.f48h.m1514a(16, str, null, null);
        Item a = m1549a(this.f48h);
        if (a == null) {
            this.f44d.m1575b(16, newUTF8(str));
            int i = this.f43c;
            this.f43c = i + 1;
            a = new Item(i, this.f48h);
            m1540b(a);
        }
        return a;
    }

    public int newMethodType(String str) {
        return m1536c(str).f135a;
    }

    /* renamed from: a */
    Item m1551a(int i, String str, String str2, String str3, boolean z) {
        this.f50j.m1514a(20 + i, str, str2, str3);
        Item a = m1549a(this.f50j);
        if (a == null) {
            if (i <= 4) {
                m1541b(15, i, newField(str, str2, str3));
            } else {
                m1541b(15, i, newMethod(str, str2, str3, z));
            }
            int i2 = this.f43c;
            this.f43c = i2 + 1;
            a = new Item(i2, this.f50j);
            m1540b(a);
        }
        return a;
    }

    public int newHandle(int i, String str, String str2, String str3) {
        return newHandle(i, str, str2, str3, i == 9);
    }

    public int newHandle(int i, String str, String str2, String str3, boolean z) {
        return m1551a(i, str, str2, str3, z).f135a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Item m1544a(String str, String str2, Handle handle, Object... objArr) {
        int i;
        ByteVector byteVector = this.f72A;
        if (byteVector == null) {
            ByteVector byteVector2 = new ByteVector();
            this.f72A = byteVector2;
            byteVector = byteVector2;
        }
        int i2 = byteVector.f34b;
        int hashCode = handle.hashCode();
        byteVector.putShort(newHandle(handle.f124a, handle.f125b, handle.f126c, handle.f127d, handle.isInterface()));
        int length = objArr.length;
        byteVector.putShort(length);
        for (Object obj : objArr) {
            hashCode ^= obj.hashCode();
            byteVector.putShort(newConst(obj));
        }
        byte[] bArr = byteVector.f33a;
        int i3 = (2 + length) << 1;
        int i4 = hashCode & Integer.MAX_VALUE;
        Item item = this.f45e[i4 % this.f45e.length];
        loop1: while (item != null) {
            if (item.f136b == 33 && item.f142j == i4) {
                int i5 = item.f137c;
                for (int i6 = 0; i6 < i3; i6++) {
                    if (bArr[i2 + i6] != bArr[i5 + i6]) {
                        item = item.f143k;
                    }
                }
                break loop1;
            }
            item = item.f143k;
        }
        if (item != null) {
            i = item.f135a;
            byteVector.f34b = i2;
        } else {
            int i7 = this.f71z;
            this.f71z = i7 + 1;
            i = i7;
            Item item2 = new Item(i);
            item2.m1515a(i2, i4);
            m1540b(item2);
        }
        this.f49i.m1511a(str, str2, i);
        Item a = m1549a(this.f49i);
        if (a == null) {
            m1552a(18, i, newNameType(str, str2));
            int i8 = this.f43c;
            this.f43c = i8 + 1;
            a = new Item(i8, this.f49i);
            m1540b(a);
        }
        return a;
    }

    public int newInvokeDynamic(String str, String str2, Handle handle, Object... objArr) {
        return m1544a(str, str2, handle, objArr).f135a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Item m1543a(String str, String str2, String str3) {
        this.f49i.m1514a(9, str, str2, str3);
        Item a = m1549a(this.f49i);
        if (a == null) {
            m1552a(9, newClass(str), newNameType(str2, str3));
            int i = this.f43c;
            this.f43c = i + 1;
            a = new Item(i, this.f49i);
            m1540b(a);
        }
        return a;
    }

    public int newField(String str, String str2, String str3) {
        return m1543a(str, str2, str3).f135a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Item m1542a(String str, String str2, String str3, boolean z) {
        int i = z ? 11 : 10;
        this.f49i.m1514a(i, str, str2, str3);
        Item a = m1549a(this.f49i);
        if (a == null) {
            m1552a(i, newClass(str), newNameType(str2, str3));
            int i2 = this.f43c;
            this.f43c = i2 + 1;
            a = new Item(i2, this.f49i);
            m1540b(a);
        }
        return a;
    }

    public int newMethod(String str, String str2, String str3, boolean z) {
        return m1542a(str, str2, str3, z).f135a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Item m1554a(int i) {
        this.f47g.m1516a(i);
        Item a = m1549a(this.f47g);
        if (a == null) {
            this.f44d.putByte(3).putInt(i);
            int i2 = this.f43c;
            this.f43c = i2 + 1;
            a = new Item(i2, this.f47g);
            m1540b(a);
        }
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Item m1555a(float f) {
        this.f47g.m1517a(f);
        Item a = m1549a(this.f47g);
        if (a == null) {
            this.f44d.putByte(4).putInt(this.f47g.f137c);
            int i = this.f43c;
            this.f43c = i + 1;
            a = new Item(i, this.f47g);
            m1540b(a);
        }
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Item m1550a(long j) {
        this.f47g.m1513a(j);
        Item a = m1549a(this.f47g);
        if (a == null) {
            this.f44d.putByte(5).putLong(j);
            a = new Item(this.f43c, this.f47g);
            this.f43c += 2;
            m1540b(a);
        }
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Item m1556a(double d) {
        this.f47g.m1518a(d);
        Item a = m1549a(this.f47g);
        if (a == null) {
            this.f44d.putByte(6).putLong(this.f47g.f138d);
            a = new Item(this.f43c, this.f47g);
            this.f43c += 2;
            m1540b(a);
        }
        return a;
    }

    /* renamed from: b */
    private Item m1539b(String str) {
        this.f48h.m1514a(8, str, null, null);
        Item a = m1549a(this.f48h);
        if (a == null) {
            this.f44d.m1575b(8, newUTF8(str));
            int i = this.f43c;
            this.f43c = i + 1;
            a = new Item(i, this.f48h);
            m1540b(a);
        }
        return a;
    }

    public int newNameType(String str, String str2) {
        return m1545a(str, str2).f135a;
    }

    /* renamed from: a */
    Item m1545a(String str, String str2) {
        this.f48h.m1514a(12, str, str2, null);
        Item a = m1549a(this.f48h);
        if (a == null) {
            m1552a(12, newUTF8(str), newUTF8(str2));
            int i = this.f43c;
            this.f43c = i + 1;
            a = new Item(i, this.f48h);
            m1540b(a);
        }
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int m1537c(String str) {
        this.f47g.m1514a(30, str, null, null);
        Item a = m1549a(this.f47g);
        if (a == null) {
            a = m1538c(this.f47g);
        }
        return a.f135a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int m1546a(String str, int i) {
        this.f47g.f136b = 31;
        this.f47g.f137c = i;
        this.f47g.f139g = str;
        this.f47g.f142j = Integer.MAX_VALUE & (31 + str.hashCode() + i);
        Item a = m1549a(this.f47g);
        if (a == null) {
            a = m1538c(this.f47g);
        }
        return a.f135a;
    }

    /* renamed from: c */
    private Item m1538c(Item item) {
        this.f52G = (short) (this.f52G + 1);
        Item item2 = new Item(this.f52G, this.f47g);
        m1540b(item2);
        if (this.f51H == null) {
            this.f51H = new Item[16];
        }
        if (this.f52G == this.f51H.length) {
            Item[] itemArr = new Item[2 * this.f51H.length];
            System.arraycopy(this.f51H, 0, itemArr, 0, this.f51H.length);
            this.f51H = itemArr;
        }
        this.f51H[this.f52G] = item2;
        return item2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int m1553a(int i, int i2) {
        this.f48h.f136b = 32;
        this.f48h.f138d = ((long) i) | (((long) i2) << 32);
        this.f48h.f142j = Integer.MAX_VALUE & (32 + i + i2);
        Item a = m1549a(this.f48h);
        if (a == null) {
            String str = this.f51H[i].f139g;
            String str2 = this.f51H[i2].f139g;
            this.f48h.f137c = m1537c(getCommonSuperClass(str, str2));
            a = new Item(0, this.f48h);
            m1540b(a);
        }
        return a.f137c;
    }

    protected String getCommonSuperClass(String str, String str2) {
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            Class<?> cls = Class.forName(str.replace('/', '.'), false, classLoader);
            Class<?> cls2 = Class.forName(str2.replace('/', '.'), false, classLoader);
            if (cls.isAssignableFrom(cls2)) {
                return str;
            }
            if (cls2.isAssignableFrom(cls)) {
                return str2;
            }
            if (cls.isInterface() || cls2.isInterface()) {
                return TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME;
            }
            do {
                cls = cls.getSuperclass();
            } while (!cls.isAssignableFrom(cls2));
            return cls.getName().replace('.', '/');
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /* renamed from: a */
    private Item m1549a(Item item) {
        Item item2 = this.f45e[item.f142j % this.f45e.length];
        while (item2 != null && (item2.f136b != item.f136b || !item.m1512a(item2))) {
            item2 = item2.f143k;
        }
        return item2;
    }

    /* renamed from: b */
    private void m1540b(Item item) {
        if (this.f43c + this.f52G > this.f46f) {
            int length = this.f45e.length;
            int i = (length * 2) + 1;
            Item[] itemArr = new Item[i];
            for (int i2 = length - 1; i2 >= 0; i2--) {
                Item item2 = this.f45e[i2];
                while (item2 != null) {
                    int length2 = item2.f142j % itemArr.length;
                    item2 = item2.f143k;
                    item2.f143k = itemArr[length2];
                    itemArr[length2] = item2;
                }
            }
            this.f45e = itemArr;
            this.f46f = (int) (((double) i) * 0.75d);
        }
        int length3 = item.f142j % this.f45e.length;
        item.f143k = this.f45e[length3];
        this.f45e[length3] = item;
    }

    /* renamed from: a */
    private void m1552a(int i, int i2, int i3) {
        this.f44d.m1575b(i, i2).putShort(i3);
    }

    /* renamed from: b */
    private void m1541b(int i, int i2, int i3) {
        this.f44d.m1576a(i, i2).putShort(i3);
    }

    static {
        _clinit_();
        byte[] bArr = new byte[220];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) ("AAAAAAAAAAAAAAAABCLMMDDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAADDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANAAAAAAAAAAAAAAAAAAAAJJJJJJJJJJJJJJJJDOPAAAAAAGGGGGGGHIFBFAAFFAARQJJKKJJJJJJJJJJJJJJJJJJ".charAt(i) - 'A');
        }
        f40a = bArr;
    }

    static void _clinit_() {
    }
}
