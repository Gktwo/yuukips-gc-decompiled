package com.esotericsoftware.asm;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.io.IOException;
import java.io.InputStream;
import javassist.bytecode.AnnotationDefaultAttribute;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.BootstrapMethodsAttribute;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.ConstantAttribute;
import javassist.bytecode.DeprecatedAttribute;
import javassist.bytecode.EnclosingMethodAttribute;
import javassist.bytecode.ExceptionsAttribute;
import javassist.bytecode.InnerClassesAttribute;
import javassist.bytecode.LineNumberAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodParametersAttribute;
import javassist.bytecode.ParameterAnnotationsAttribute;
import javassist.bytecode.SignatureAttribute;
import javassist.bytecode.SourceFileAttribute;
import javassist.bytecode.StackMap;
import javassist.bytecode.StackMapTable;
import javassist.bytecode.SyntheticAttribute;
import javassist.bytecode.TypeAnnotationsAttribute;
import net.bytebuddy.jar.asm.Opcodes;

/* loaded from: grasscutter.jar:com/esotericsoftware/asm/ClassReader.class */
public class ClassReader {
    public static final int SKIP_CODE = 1;
    public static final int SKIP_DEBUG = 2;
    public static final int SKIP_FRAMES = 4;
    public static final int EXPAND_FRAMES = 8;

    /* renamed from: b */
    public final byte[] f35b;

    /* renamed from: a */
    private final int[] f36a;

    /* renamed from: c */
    private final String[] f37c;

    /* renamed from: d */
    private final int f38d;
    public final int header;

    public ClassReader(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public ClassReader(byte[] bArr, int i, int i2) {
        int i3;
        this.f35b = bArr;
        if (readShort(i + 6) > 52) {
            throw new IllegalArgumentException();
        }
        this.f36a = new int[readUnsignedShort(i + 8)];
        int length = this.f36a.length;
        this.f37c = new String[length];
        int i4 = 0;
        int i5 = i + 10;
        int i6 = 1;
        while (i6 < length) {
            this.f36a[i6] = i5 + 1;
            switch (bArr[i5]) {
                case 1:
                    i3 = 3 + readUnsignedShort(i5 + 1);
                    if (i3 <= i4) {
                        break;
                    } else {
                        i4 = i3;
                        break;
                    }
                case 2:
                case 7:
                case 8:
                case 13:
                case 14:
                case 16:
                case 17:
                default:
                    i3 = 3;
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                case 18:
                    i3 = 5;
                    break;
                case 5:
                case 6:
                    i3 = 9;
                    i6++;
                    break;
                case 15:
                    i3 = 4;
                    break;
            }
            i5 += i3;
            i6++;
        }
        this.f38d = i4;
        this.header = i5;
    }

    public int getAccess() {
        return readUnsignedShort(this.header);
    }

    public String getClassName() {
        return readClass(this.header + 2, new char[this.f38d]);
    }

    public String getSuperName() {
        return readClass(this.header + 4, new char[this.f38d]);
    }

    public String[] getInterfaces() {
        int i = this.header + 6;
        int readUnsignedShort = readUnsignedShort(i);
        String[] strArr = new String[readUnsignedShort];
        if (readUnsignedShort > 0) {
            char[] cArr = new char[this.f38d];
            for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                i += 2;
                strArr[i2] = readClass(i, cArr);
            }
        }
        return strArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1567a(ClassWriter classWriter) {
        char[] cArr = new char[this.f38d];
        int length = this.f36a.length;
        Item[] itemArr = new Item[length];
        int i = 1;
        while (i < length) {
            int i2 = this.f36a[i];
            byte b = this.f35b[i2 - 1];
            Item item = new Item(i);
            switch (b) {
                case 1:
                    String str = this.f37c[i];
                    if (str == null) {
                        int i3 = this.f36a[i];
                        String[] strArr = this.f37c;
                        String a = m1572a(i3 + 2, readUnsignedShort(i3), cArr);
                        strArr[i] = a;
                        str = a;
                    }
                    item.m1514a(b, str, null, null);
                    break;
                case 2:
                case 7:
                case 8:
                case 13:
                case 14:
                case 16:
                case 17:
                default:
                    item.m1514a(b, readUTF8(i2, cArr), null, null);
                    break;
                case 3:
                    item.m1516a(readInt(i2));
                    break;
                case 4:
                    item.m1517a(Float.intBitsToFloat(readInt(i2)));
                    break;
                case 5:
                    item.m1513a(readLong(i2));
                    i++;
                    break;
                case 6:
                    item.m1518a(Double.longBitsToDouble(readLong(i2)));
                    i++;
                    break;
                case 9:
                case 10:
                case 11:
                    int i4 = this.f36a[readUnsignedShort(i2 + 2)];
                    item.m1514a(b, readClass(i2, cArr), readUTF8(i4, cArr), readUTF8(i4 + 2, cArr));
                    break;
                case 12:
                    item.m1514a(b, readUTF8(i2, cArr), readUTF8(i2 + 2, cArr), null);
                    break;
                case 15:
                    int i5 = this.f36a[readUnsignedShort(i2 + 1)];
                    int i6 = this.f36a[readUnsignedShort(i5 + 2)];
                    item.m1514a(20 + readByte(i2), readClass(i5, cArr), readUTF8(i6, cArr), readUTF8(i6 + 2, cArr));
                    break;
                case 18:
                    if (classWriter.f72A == null) {
                        m1566a(classWriter, itemArr, cArr);
                    }
                    int i7 = this.f36a[readUnsignedShort(i2 + 2)];
                    item.m1511a(readUTF8(i7, cArr), readUTF8(i7 + 2, cArr), readUnsignedShort(i2));
                    break;
            }
            int length2 = item.f142j % itemArr.length;
            item.f143k = itemArr[length2];
            itemArr[length2] = item;
            i++;
        }
        int i8 = this.f36a[1] - 1;
        classWriter.f44d.putByteArray(this.f35b, i8, this.header - i8);
        classWriter.f45e = itemArr;
        classWriter.f46f = (int) (0.75d * ((double) length));
        classWriter.f43c = length;
    }

    /* renamed from: a */
    private void m1566a(ClassWriter classWriter, Item[] itemArr, char[] cArr) {
        int a = m1573a();
        boolean z = false;
        int readUnsignedShort = readUnsignedShort(a);
        while (true) {
            if (readUnsignedShort <= 0) {
                break;
            } else if (BootstrapMethodsAttribute.tag.equals(readUTF8(a + 2, cArr))) {
                z = true;
                break;
            } else {
                a += 6 + readInt(a + 4);
                readUnsignedShort--;
            }
        }
        if (z) {
            int readUnsignedShort2 = readUnsignedShort(a + 8);
            int i = a + 10;
            for (int i2 = 0; i2 < readUnsignedShort2; i2++) {
                int i3 = (i - a) - 10;
                int hashCode = readConst(readUnsignedShort(i), cArr).hashCode();
                for (int readUnsignedShort3 = readUnsignedShort(i + 2); readUnsignedShort3 > 0; readUnsignedShort3--) {
                    hashCode ^= readConst(readUnsignedShort(i + 4), cArr).hashCode();
                    i += 2;
                }
                i += 4;
                Item item = new Item(i2);
                item.m1515a(i3, hashCode & Integer.MAX_VALUE);
                int length = item.f142j % itemArr.length;
                item.f143k = itemArr[length];
                itemArr[length] = item;
            }
            int readInt = readInt(a + 4);
            ByteVector byteVector = new ByteVector(readInt + 62);
            byteVector.putByteArray(this.f35b, a + 10, readInt - 2);
            classWriter.f71z = readUnsignedShort2;
            classWriter.f72A = byteVector;
        }
    }

    public ClassReader(InputStream inputStream) throws IOException {
        this(m1561a(inputStream, false));
    }

    public ClassReader(String str) throws IOException {
        this(m1561a(ClassLoader.getSystemResourceAsStream(new StringBuffer().append(str.replace('.', '/')).append(".class").toString()), true));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        if (r9 >= r8.length) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        r0 = new byte[r9];
        java.lang.System.arraycopy(r8, 0, r0, 0, r9);
        r8 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        return r8;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] m1561a(java.io.InputStream r6, boolean r7) throws java.io.IOException {
        /*
            r0 = r6
            if (r0 != 0) goto L_0x000e
            java.io.IOException r0 = new java.io.IOException
            r1 = r0
            java.lang.String r2 = "Class not found"
            r1.<init>(r2)
            throw r0
        L_0x000e:
            r0 = r6
            int r0 = r0.available()     // Catch: all -> 0x0095
            byte[] r0 = new byte[r0]     // Catch: all -> 0x0095
            r8 = r0
            r0 = 0
            r9 = r0
        L_0x0017:
            r0 = r6
            r1 = r8
            r2 = r9
            r3 = r8
            int r3 = r3.length     // Catch: all -> 0x0095
            r4 = r9
            int r3 = r3 - r4
            int r0 = r0.read(r1, r2, r3)     // Catch: all -> 0x0095
            r10 = r0
            r0 = r10
            r1 = -1
            if (r0 != r1) goto L_0x004e
            r0 = r9
            r1 = r8
            int r1 = r1.length     // Catch: all -> 0x0095
            if (r0 >= r1) goto L_0x0040
            r0 = r9
            byte[] r0 = new byte[r0]     // Catch: all -> 0x0095
            r11 = r0
            r0 = r8
            r1 = 0
            r2 = r11
            r3 = 0
            r4 = r9
            java.lang.System.arraycopy(r0, r1, r2, r3, r4)     // Catch: all -> 0x0095
            r0 = r11
            r8 = r0
        L_0x0040:
            r0 = r8
            r11 = r0
            r0 = r7
            if (r0 == 0) goto L_0x004b
            r0 = r6
            r0.close()
        L_0x004b:
            r0 = r11
            return r0
        L_0x004e:
            r0 = r9
            r1 = r10
            int r0 = r0 + r1
            r9 = r0
            r0 = r9
            r1 = r8
            int r1 = r1.length     // Catch: all -> 0x0095
            if (r0 != r1) goto L_0x0092
            r0 = r6
            int r0 = r0.read()     // Catch: all -> 0x0095
            r11 = r0
            r0 = r11
            if (r0 >= 0) goto L_0x0072
            r0 = r8
            r12 = r0
            r0 = r7
            if (r0 == 0) goto L_0x006f
            r0 = r6
            r0.close()
        L_0x006f:
            r0 = r12
            return r0
        L_0x0072:
            r0 = r8
            int r0 = r0.length     // Catch: all -> 0x0095
            r1 = 1000(0x3e8, float:1.401E-42)
            int r0 = r0 + r1
            byte[] r0 = new byte[r0]     // Catch: all -> 0x0095
            r12 = r0
            r0 = r8
            r1 = 0
            r2 = r12
            r3 = 0
            r4 = r9
            java.lang.System.arraycopy(r0, r1, r2, r3, r4)     // Catch: all -> 0x0095
            r0 = r12
            r1 = r9
            int r9 = r9 + 1
            r2 = r11
            byte r2 = (byte) r2     // Catch: all -> 0x0095
            r0[r1] = r2     // Catch: all -> 0x0095
            r0 = r12
            r8 = r0
        L_0x0092:
            goto L_0x0017
        L_0x0095:
            r13 = move-exception
            r0 = r7
            if (r0 == 0) goto L_0x009f
            r0 = r6
            r0.close()
        L_0x009f:
            r0 = r13
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.esotericsoftware.asm.ClassReader.m1561a(java.io.InputStream, boolean):byte[]");
    }

    public void accept(ClassVisitor classVisitor, int i) {
        accept(classVisitor, new Attribute[0], i);
    }

    public void accept(ClassVisitor classVisitor, Attribute[] attributeArr, int i) {
        int i2 = this.header;
        char[] cArr = new char[this.f38d];
        Context context = new Context();
        context.f80a = attributeArr;
        context.f81b = i;
        context.f82c = cArr;
        int readUnsignedShort = readUnsignedShort(i2);
        String readClass = readClass(i2 + 2, cArr);
        String readClass2 = readClass(i2 + 4, cArr);
        String[] strArr = new String[readUnsignedShort(i2 + 6)];
        int i3 = i2 + 8;
        for (int i4 = 0; i4 < strArr.length; i4++) {
            strArr[i4] = readClass(i3, cArr);
            i3 += 2;
        }
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        Attribute attribute = null;
        int a = m1573a();
        for (int readUnsignedShort2 = readUnsignedShort(a); readUnsignedShort2 > 0; readUnsignedShort2--) {
            String readUTF8 = readUTF8(a + 2, cArr);
            if (SourceFileAttribute.tag.equals(readUTF8)) {
                str2 = readUTF8(a + 8, cArr);
            } else if (InnerClassesAttribute.tag.equals(readUTF8)) {
                i9 = a + 8;
            } else if (EnclosingMethodAttribute.tag.equals(readUTF8)) {
                str4 = readClass(a + 8, cArr);
                int readUnsignedShort3 = readUnsignedShort(a + 10);
                if (readUnsignedShort3 != 0) {
                    str5 = readUTF8(this.f36a[readUnsignedShort3], cArr);
                    str6 = readUTF8(this.f36a[readUnsignedShort3] + 2, cArr);
                }
            } else if (SignatureAttribute.tag.equals(readUTF8)) {
                str = readUTF8(a + 8, cArr);
            } else if (AnnotationsAttribute.visibleTag.equals(readUTF8)) {
                i5 = a + 8;
            } else if (TypeAnnotationsAttribute.visibleTag.equals(readUTF8)) {
                i7 = a + 8;
            } else if (DeprecatedAttribute.tag.equals(readUTF8)) {
                readUnsignedShort |= 131072;
            } else if (SyntheticAttribute.tag.equals(readUTF8)) {
                readUnsignedShort |= 266240;
            } else if ("SourceDebugExtension".equals(readUTF8)) {
                int readInt = readInt(a + 4);
                str3 = m1572a(a + 8, readInt, new char[readInt]);
            } else if (AnnotationsAttribute.invisibleTag.equals(readUTF8)) {
                i6 = a + 8;
            } else if (TypeAnnotationsAttribute.invisibleTag.equals(readUTF8)) {
                i8 = a + 8;
            } else if (BootstrapMethodsAttribute.tag.equals(readUTF8)) {
                int[] iArr = new int[readUnsignedShort(a + 8)];
                int i10 = a + 10;
                for (int i11 = 0; i11 < iArr.length; i11++) {
                    iArr[i11] = i10;
                    i10 += (2 + readUnsignedShort(i10 + 2)) << 1;
                }
                context.f83d = iArr;
            } else {
                Attribute a2 = m1560a(attributeArr, readUTF8, a + 8, readInt(a + 4), cArr, -1, null);
                if (a2 != null) {
                    a2.f32a = attribute;
                    attribute = a2;
                }
            }
            a += 6 + readInt(a + 4);
        }
        classVisitor.visit(readInt(this.f36a[1] - 7), readUnsignedShort, readClass, str, readClass2, strArr);
        if ((i & 2) == 0 && !(str2 == null && str3 == null)) {
            classVisitor.visitSource(str2, str3);
        }
        if (str4 != null) {
            classVisitor.visitOuterClass(str4, str5, str6);
        }
        if (i5 != 0) {
            int i12 = i5 + 2;
            for (int readUnsignedShort4 = readUnsignedShort(i5); readUnsignedShort4 > 0; readUnsignedShort4--) {
                i12 = m1569a(i12 + 2, cArr, true, classVisitor.visitAnnotation(readUTF8(i12, cArr), true));
            }
        }
        if (i6 != 0) {
            int i13 = i6 + 2;
            for (int readUnsignedShort5 = readUnsignedShort(i6); readUnsignedShort5 > 0; readUnsignedShort5--) {
                i13 = m1569a(i13 + 2, cArr, true, classVisitor.visitAnnotation(readUTF8(i13, cArr), false));
            }
        }
        if (i7 != 0) {
            int i14 = i7 + 2;
            for (int readUnsignedShort6 = readUnsignedShort(i7); readUnsignedShort6 > 0; readUnsignedShort6--) {
                int a3 = m1564a(context, i14);
                i14 = m1569a(a3 + 2, cArr, true, classVisitor.visitTypeAnnotation(context.f88i, context.f89j, readUTF8(a3, cArr), true));
            }
        }
        if (i8 != 0) {
            int i15 = i8 + 2;
            for (int readUnsignedShort7 = readUnsignedShort(i8); readUnsignedShort7 > 0; readUnsignedShort7--) {
                int a4 = m1564a(context, i15);
                i15 = m1569a(a4 + 2, cArr, true, classVisitor.visitTypeAnnotation(context.f88i, context.f89j, readUTF8(a4, cArr), false));
            }
        }
        while (attribute != null) {
            attribute = attribute.f32a;
            attribute.f32a = null;
            classVisitor.visitAttribute(attribute);
        }
        if (i9 != 0) {
            int i16 = i9 + 2;
            for (int readUnsignedShort8 = readUnsignedShort(i9); readUnsignedShort8 > 0; readUnsignedShort8--) {
                classVisitor.visitInnerClass(readClass(i16, cArr), readClass(i16 + 2, cArr), readUTF8(i16 + 4, cArr), readUnsignedShort(i16 + 6));
                i16 += 8;
            }
        }
        int length = this.header + 10 + (2 * strArr.length);
        for (int readUnsignedShort9 = readUnsignedShort(length - 2); readUnsignedShort9 > 0; readUnsignedShort9--) {
            length = m1568a(classVisitor, context, length);
        }
        int i17 = length + 2;
        for (int readUnsignedShort10 = readUnsignedShort(i17 - 2); readUnsignedShort10 > 0; readUnsignedShort10--) {
            i17 = m1558b(classVisitor, context, i17);
        }
        classVisitor.visitEnd();
    }

    /* renamed from: a */
    private int m1568a(ClassVisitor classVisitor, Context context, int i) {
        char[] cArr = context.f82c;
        int readUnsignedShort = readUnsignedShort(i);
        String readUTF8 = readUTF8(i + 2, cArr);
        String readUTF82 = readUTF8(i + 4, cArr);
        int i2 = i + 6;
        String str = null;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        Object obj = null;
        Attribute attribute = null;
        for (int readUnsignedShort2 = readUnsignedShort(i2); readUnsignedShort2 > 0; readUnsignedShort2--) {
            String readUTF83 = readUTF8(i2 + 2, cArr);
            if (ConstantAttribute.tag.equals(readUTF83)) {
                int readUnsignedShort3 = readUnsignedShort(i2 + 8);
                obj = readUnsignedShort3 == 0 ? null : readConst(readUnsignedShort3, cArr);
            } else if (SignatureAttribute.tag.equals(readUTF83)) {
                str = readUTF8(i2 + 8, cArr);
            } else if (DeprecatedAttribute.tag.equals(readUTF83)) {
                readUnsignedShort |= 131072;
            } else if (SyntheticAttribute.tag.equals(readUTF83)) {
                readUnsignedShort |= 266240;
            } else if (AnnotationsAttribute.visibleTag.equals(readUTF83)) {
                i3 = i2 + 8;
            } else if (TypeAnnotationsAttribute.visibleTag.equals(readUTF83)) {
                i5 = i2 + 8;
            } else if (AnnotationsAttribute.invisibleTag.equals(readUTF83)) {
                i4 = i2 + 8;
            } else if (TypeAnnotationsAttribute.invisibleTag.equals(readUTF83)) {
                i6 = i2 + 8;
            } else {
                Attribute a = m1560a(context.f80a, readUTF83, i2 + 8, readInt(i2 + 4), cArr, -1, null);
                if (a != null) {
                    a.f32a = attribute;
                    attribute = a;
                }
            }
            i2 += 6 + readInt(i2 + 4);
        }
        int i7 = i2 + 2;
        FieldVisitor visitField = classVisitor.visitField(readUnsignedShort, readUTF8, readUTF82, str, obj);
        if (visitField == null) {
            return i7;
        }
        if (i3 != 0) {
            int i8 = i3 + 2;
            for (int readUnsignedShort4 = readUnsignedShort(i3); readUnsignedShort4 > 0; readUnsignedShort4--) {
                i8 = m1569a(i8 + 2, cArr, true, visitField.visitAnnotation(readUTF8(i8, cArr), true));
            }
        }
        if (i4 != 0) {
            int i9 = i4 + 2;
            for (int readUnsignedShort5 = readUnsignedShort(i4); readUnsignedShort5 > 0; readUnsignedShort5--) {
                i9 = m1569a(i9 + 2, cArr, true, visitField.visitAnnotation(readUTF8(i9, cArr), false));
            }
        }
        if (i5 != 0) {
            int i10 = i5 + 2;
            for (int readUnsignedShort6 = readUnsignedShort(i5); readUnsignedShort6 > 0; readUnsignedShort6--) {
                int a2 = m1564a(context, i10);
                i10 = m1569a(a2 + 2, cArr, true, visitField.visitTypeAnnotation(context.f88i, context.f89j, readUTF8(a2, cArr), true));
            }
        }
        if (i6 != 0) {
            int i11 = i6 + 2;
            for (int readUnsignedShort7 = readUnsignedShort(i6); readUnsignedShort7 > 0; readUnsignedShort7--) {
                int a3 = m1564a(context, i11);
                i11 = m1569a(a3 + 2, cArr, true, visitField.visitTypeAnnotation(context.f88i, context.f89j, readUTF8(a3, cArr), false));
            }
        }
        while (attribute != null) {
            attribute = attribute.f32a;
            attribute.f32a = null;
            visitField.visitAttribute(attribute);
        }
        visitField.visitEnd();
        return i7;
    }

    /* renamed from: b */
    private int m1558b(ClassVisitor classVisitor, Context context, int i) {
        char[] cArr = context.f82c;
        context.f84e = readUnsignedShort(i);
        context.f85f = readUTF8(i + 2, cArr);
        context.f86g = readUTF8(i + 4, cArr);
        int i2 = i + 6;
        int i3 = 0;
        int i4 = 0;
        String[] strArr = null;
        String str = null;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        Attribute attribute = null;
        for (int readUnsignedShort = readUnsignedShort(i2); readUnsignedShort > 0; readUnsignedShort--) {
            String readUTF8 = readUTF8(i2 + 2, cArr);
            if (CodeAttribute.tag.equals(readUTF8)) {
                if ((context.f81b & 1) == 0) {
                    i3 = i2 + 8;
                }
            } else if (ExceptionsAttribute.tag.equals(readUTF8)) {
                strArr = new String[readUnsignedShort(i2 + 8)];
                i4 = i2 + 10;
                for (int i13 = 0; i13 < strArr.length; i13++) {
                    strArr[i13] = readClass(i4, cArr);
                    i4 += 2;
                }
            } else if (SignatureAttribute.tag.equals(readUTF8)) {
                str = readUTF8(i2 + 8, cArr);
            } else if (DeprecatedAttribute.tag.equals(readUTF8)) {
                context.f84e |= 131072;
            } else if (AnnotationsAttribute.visibleTag.equals(readUTF8)) {
                i6 = i2 + 8;
            } else if (TypeAnnotationsAttribute.visibleTag.equals(readUTF8)) {
                i8 = i2 + 8;
            } else if (AnnotationDefaultAttribute.tag.equals(readUTF8)) {
                i10 = i2 + 8;
            } else if (SyntheticAttribute.tag.equals(readUTF8)) {
                context.f84e |= 266240;
            } else if (AnnotationsAttribute.invisibleTag.equals(readUTF8)) {
                i7 = i2 + 8;
            } else if (TypeAnnotationsAttribute.invisibleTag.equals(readUTF8)) {
                i9 = i2 + 8;
            } else if (ParameterAnnotationsAttribute.visibleTag.equals(readUTF8)) {
                i11 = i2 + 8;
            } else if (ParameterAnnotationsAttribute.invisibleTag.equals(readUTF8)) {
                i12 = i2 + 8;
            } else if (MethodParametersAttribute.tag.equals(readUTF8)) {
                i5 = i2 + 8;
            } else {
                Attribute a = m1560a(context.f80a, readUTF8, i2 + 8, readInt(i2 + 4), cArr, -1, null);
                if (a != null) {
                    a.f32a = attribute;
                    attribute = a;
                }
            }
            i2 += 6 + readInt(i2 + 4);
        }
        int i14 = i2 + 2;
        MethodVisitor visitMethod = classVisitor.visitMethod(context.f84e, context.f85f, context.f86g, str, strArr);
        if (visitMethod == null) {
            return i14;
        }
        if (visitMethod instanceof MethodWriter) {
            MethodWriter methodWriter = (MethodWriter) visitMethod;
            if (methodWriter.f156b.f41M == this && str == methodWriter.f161g) {
                boolean z = false;
                if (strArr == null) {
                    z = methodWriter.f164j == 0;
                } else if (strArr.length == methodWriter.f164j) {
                    z = true;
                    int length = strArr.length - 1;
                    while (true) {
                        if (length < 0) {
                            break;
                        }
                        i4 -= 2;
                        if (methodWriter.f165k[length] != readUnsignedShort(i4)) {
                            z = false;
                            break;
                        }
                        length--;
                    }
                }
                if (z) {
                    methodWriter.f162h = i2;
                    methodWriter.f163i = i14 - i2;
                    return i14;
                }
            }
        }
        if (i5 != 0) {
            int i15 = this.f35b[i5] & 255;
            int i16 = i5;
            int i17 = 1;
            while (true) {
                int i18 = i16 + i17;
                if (i15 <= 0) {
                    break;
                }
                visitMethod.visitParameter(readUTF8(i18, cArr), readUnsignedShort(i18 + 2));
                i15--;
                i16 = i18;
                i17 = 4;
            }
        }
        if (i10 != 0) {
            AnnotationVisitor visitAnnotationDefault = visitMethod.visitAnnotationDefault();
            m1570a(i10, cArr, (String) null, visitAnnotationDefault);
            if (visitAnnotationDefault != null) {
                visitAnnotationDefault.visitEnd();
            }
        }
        if (i6 != 0) {
            int i19 = i6 + 2;
            for (int readUnsignedShort2 = readUnsignedShort(i6); readUnsignedShort2 > 0; readUnsignedShort2--) {
                i19 = m1569a(i19 + 2, cArr, true, visitMethod.visitAnnotation(readUTF8(i19, cArr), true));
            }
        }
        if (i7 != 0) {
            int i20 = i7 + 2;
            for (int readUnsignedShort3 = readUnsignedShort(i7); readUnsignedShort3 > 0; readUnsignedShort3--) {
                i20 = m1569a(i20 + 2, cArr, true, visitMethod.visitAnnotation(readUTF8(i20, cArr), false));
            }
        }
        if (i8 != 0) {
            int i21 = i8 + 2;
            for (int readUnsignedShort4 = readUnsignedShort(i8); readUnsignedShort4 > 0; readUnsignedShort4--) {
                int a2 = m1564a(context, i21);
                i21 = m1569a(a2 + 2, cArr, true, visitMethod.visitTypeAnnotation(context.f88i, context.f89j, readUTF8(a2, cArr), true));
            }
        }
        if (i9 != 0) {
            int i22 = i9 + 2;
            for (int readUnsignedShort5 = readUnsignedShort(i9); readUnsignedShort5 > 0; readUnsignedShort5--) {
                int a3 = m1564a(context, i22);
                i22 = m1569a(a3 + 2, cArr, true, visitMethod.visitTypeAnnotation(context.f88i, context.f89j, readUTF8(a3, cArr), false));
            }
        }
        if (i11 != 0) {
            m1557b(visitMethod, context, i11, true);
        }
        if (i12 != 0) {
            m1557b(visitMethod, context, i12, false);
        }
        while (attribute != null) {
            attribute = attribute.f32a;
            attribute.f32a = null;
            visitMethod.visitAttribute(attribute);
        }
        if (i3 != 0) {
            visitMethod.visitCode();
            m1563a(visitMethod, context, i3);
        }
        visitMethod.visitEnd();
        return i14;
    }

    /* renamed from: a */
    private void m1563a(MethodVisitor methodVisitor, Context context, int i) {
        int readUnsignedShort;
        Attribute read;
        byte[] bArr = this.f35b;
        char[] cArr = context.f82c;
        int readUnsignedShort2 = readUnsignedShort(i);
        int readUnsignedShort3 = readUnsignedShort(i + 2);
        int readInt = readInt(i + 4);
        int i2 = i + 8;
        int i3 = i2 + readInt;
        Label[] labelArr = new Label[readInt + 2];
        context.f87h = labelArr;
        readLabel(readInt + 1, labelArr);
        while (i2 < i3) {
            int i4 = i2 - i2;
            switch (ClassWriter.f40a[bArr[i2] & 255]) {
                case 0:
                case 4:
                    i2++;
                    break;
                case 1:
                case 3:
                case 11:
                    i2 += 2;
                    break;
                case 2:
                case 5:
                case 6:
                case 12:
                case 13:
                    i2 += 3;
                    break;
                case 7:
                case 8:
                    i2 += 5;
                    break;
                case 9:
                    readLabel(i4 + readShort(i2 + 1), labelArr);
                    i2 += 3;
                    break;
                case 10:
                    readLabel(i4 + readInt(i2 + 1), labelArr);
                    i2 += 5;
                    break;
                case 14:
                    int i5 = (i2 + 4) - (i4 & 3);
                    readLabel(i4 + readInt(i5), labelArr);
                    for (int readInt2 = (readInt(i5 + 8) - readInt(i5 + 4)) + 1; readInt2 > 0; readInt2--) {
                        readLabel(i4 + readInt(i5 + 12), labelArr);
                        i5 += 4;
                    }
                    i2 = i5 + 12;
                    break;
                case 15:
                    int i6 = (i2 + 4) - (i4 & 3);
                    readLabel(i4 + readInt(i6), labelArr);
                    for (int readInt3 = readInt(i6 + 4); readInt3 > 0; readInt3--) {
                        readLabel(i4 + readInt(i6 + 12), labelArr);
                        i6 += 8;
                    }
                    i2 = i6 + 8;
                    break;
                case 16:
                default:
                    i2 += 4;
                    break;
                case 17:
                    if ((bArr[i2 + 1] & 255) == 132) {
                        i2 += 6;
                        break;
                    } else {
                        i2 += 4;
                        break;
                    }
            }
        }
        for (int readUnsignedShort4 = readUnsignedShort(i2); readUnsignedShort4 > 0; readUnsignedShort4--) {
            methodVisitor.visitTryCatchBlock(readLabel(readUnsignedShort(i2 + 2), labelArr), readLabel(readUnsignedShort(i2 + 4), labelArr), readLabel(readUnsignedShort(i2 + 6), labelArr), readUTF8(this.f36a[readUnsignedShort(i2 + 8)], cArr));
            i2 += 8;
        }
        int i7 = i2 + 2;
        int[] iArr = null;
        int[] iArr2 = null;
        int i8 = 0;
        int i9 = 0;
        int i10 = -1;
        int i11 = -1;
        int i12 = 0;
        int i13 = 0;
        boolean z = true;
        boolean z2 = (context.f81b & 8) != 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        Context context2 = null;
        Attribute attribute = null;
        for (int readUnsignedShort5 = readUnsignedShort(i7); readUnsignedShort5 > 0; readUnsignedShort5--) {
            String readUTF8 = readUTF8(i7 + 2, cArr);
            if (LocalVariableAttribute.tag.equals(readUTF8)) {
                if ((context.f81b & 2) == 0) {
                    i12 = i7 + 8;
                    int i17 = i7;
                    for (int readUnsignedShort6 = readUnsignedShort(i7 + 8); readUnsignedShort6 > 0; readUnsignedShort6--) {
                        int readUnsignedShort7 = readUnsignedShort(i17 + 10);
                        if (labelArr[readUnsignedShort7] == null) {
                            readLabel(readUnsignedShort7, labelArr).f144a |= 1;
                        }
                        int readUnsignedShort8 = readUnsignedShort7 + readUnsignedShort(i17 + 12);
                        if (labelArr[readUnsignedShort8] == null) {
                            readLabel(readUnsignedShort8, labelArr).f144a |= 1;
                        }
                        i17 += 10;
                    }
                }
            } else if ("LocalVariableTypeTable".equals(readUTF8)) {
                i13 = i7 + 8;
            } else if (LineNumberAttribute.tag.equals(readUTF8)) {
                if ((context.f81b & 2) == 0) {
                    int i18 = i7;
                    for (int readUnsignedShort9 = readUnsignedShort(i7 + 8); readUnsignedShort9 > 0; readUnsignedShort9--) {
                        int readUnsignedShort10 = readUnsignedShort(i18 + 10);
                        if (labelArr[readUnsignedShort10] == null) {
                            readLabel(readUnsignedShort10, labelArr).f144a |= 1;
                        }
                        Label label = labelArr[readUnsignedShort10];
                        while (label.f145b > 0) {
                            if (label.f154k == null) {
                                label.f154k = new Label();
                            }
                            label = label.f154k;
                        }
                        label.f145b = readUnsignedShort(i18 + 12);
                        i18 += 4;
                    }
                }
            } else if (TypeAnnotationsAttribute.visibleTag.equals(readUTF8)) {
                iArr = m1562a(methodVisitor, context, i7 + 8, true);
                i10 = (iArr.length == 0 || readByte(iArr[0]) < 67) ? -1 : readUnsignedShort(iArr[0] + 1);
            } else if (TypeAnnotationsAttribute.invisibleTag.equals(readUTF8)) {
                iArr2 = m1562a(methodVisitor, context, i7 + 8, false);
                i11 = (iArr2.length == 0 || readByte(iArr2[0]) < 67) ? -1 : readUnsignedShort(iArr2[0] + 1);
            } else if (StackMapTable.tag.equals(readUTF8)) {
                if ((context.f81b & 4) == 0) {
                    i14 = i7 + 10;
                    i15 = readInt(i7 + 4);
                    i16 = readUnsignedShort(i7 + 8);
                }
            } else if (!StackMap.tag.equals(readUTF8)) {
                for (int i19 = 0; i19 < context.f80a.length; i19++) {
                    if (context.f80a[i19].type.equals(readUTF8) && (read = context.f80a[i19].read(this, i7 + 8, readInt(i7 + 4), cArr, i2 - 8, labelArr)) != null) {
                        read.f32a = attribute;
                        attribute = read;
                    }
                }
            } else if ((context.f81b & 4) == 0) {
                z = false;
                i14 = i7 + 10;
                i15 = readInt(i7 + 4);
                i16 = readUnsignedShort(i7 + 8);
            }
            i7 += 6 + readInt(i7 + 4);
        }
        int i20 = i7 + 2;
        if (i14 != 0) {
            context2 = context;
            context2.f90o = -1;
            context2.f94p = 0;
            context2.f95q = 0;
            context2.f96r = 0;
            context2.f98t = 0;
            context2.f97s = new Object[readUnsignedShort3];
            context2.f99u = new Object[readUnsignedShort2];
            if (z2) {
                m1565a(context);
            }
            for (int i21 = i14; i21 < (i14 + i15) - 2; i21++) {
                if (bArr[i21] == 8 && (readUnsignedShort = readUnsignedShort(i21 + 1)) >= 0 && readUnsignedShort < readInt && (bArr[i2 + readUnsignedShort] & 255) == 187) {
                    readLabel(readUnsignedShort, labelArr);
                }
            }
        }
        int i22 = i2;
        while (i22 < i3) {
            int i23 = i22 - i2;
            Label label2 = labelArr[i23];
            if (label2 != null) {
                label2.f154k = null;
                methodVisitor.visitLabel(label2);
                if ((context.f81b & 2) == 0 && label2.f145b > 0) {
                    methodVisitor.visitLineNumber(label2.f145b, label2);
                    for (Label label3 = label2.f154k; label3 != null; label3 = label3.f154k) {
                        methodVisitor.visitLineNumber(label3.f145b, label2);
                    }
                }
            }
            while (context2 != null && (context2.f90o == i23 || context2.f90o == -1)) {
                if (context2.f90o != -1) {
                    if (!z || z2) {
                        methodVisitor.visitFrame(-1, context2.f95q, context2.f97s, context2.f98t, context2.f99u);
                    } else {
                        methodVisitor.visitFrame(context2.f94p, context2.f96r, context2.f97s, context2.f98t, context2.f99u);
                    }
                }
                if (i16 > 0) {
                    i14 = m1571a(i14, z, z2, context2);
                    i16--;
                } else {
                    context2 = null;
                }
            }
            int i24 = bArr[i22] & 255;
            switch (ClassWriter.f40a[i24]) {
                case 0:
                    methodVisitor.visitInsn(i24);
                    i22++;
                    break;
                case 1:
                    methodVisitor.visitIntInsn(i24, bArr[i22 + 1]);
                    i22 += 2;
                    break;
                case 2:
                    methodVisitor.visitIntInsn(i24, readShort(i22 + 1));
                    i22 += 3;
                    break;
                case 3:
                    methodVisitor.visitVarInsn(i24, bArr[i22 + 1] & 255);
                    i22 += 2;
                    break;
                case 4:
                    if (i24 > 54) {
                        int i25 = i24 - 59;
                        methodVisitor.visitVarInsn(54 + (i25 >> 2), i25 & 3);
                    } else {
                        int i26 = i24 - 26;
                        methodVisitor.visitVarInsn(21 + (i26 >> 2), i26 & 3);
                    }
                    i22++;
                    break;
                case 5:
                    methodVisitor.visitTypeInsn(i24, readClass(i22 + 1, cArr));
                    i22 += 3;
                    break;
                case 6:
                case 7:
                    int i27 = this.f36a[readUnsignedShort(i22 + 1)];
                    boolean z3 = bArr[i27 - 1] == 11;
                    String readClass = readClass(i27, cArr);
                    int i28 = this.f36a[readUnsignedShort(i27 + 2)];
                    String readUTF82 = readUTF8(i28, cArr);
                    String readUTF83 = readUTF8(i28 + 2, cArr);
                    if (i24 < 182) {
                        methodVisitor.visitFieldInsn(i24, readClass, readUTF82, readUTF83);
                    } else {
                        methodVisitor.visitMethodInsn(i24, readClass, readUTF82, readUTF83, z3);
                    }
                    if (i24 == 185) {
                        i22 += 5;
                        break;
                    } else {
                        i22 += 3;
                        break;
                    }
                case 8:
                    int i29 = this.f36a[readUnsignedShort(i22 + 1)];
                    int i30 = context.f83d[readUnsignedShort(i29)];
                    Handle handle = (Handle) readConst(readUnsignedShort(i30), cArr);
                    int readUnsignedShort11 = readUnsignedShort(i30 + 2);
                    Object[] objArr = new Object[readUnsignedShort11];
                    int i31 = i30 + 4;
                    for (int i32 = 0; i32 < readUnsignedShort11; i32++) {
                        objArr[i32] = readConst(readUnsignedShort(i31), cArr);
                        i31 += 2;
                    }
                    int i33 = this.f36a[readUnsignedShort(i29 + 2)];
                    methodVisitor.visitInvokeDynamicInsn(readUTF8(i33, cArr), readUTF8(i33 + 2, cArr), handle, objArr);
                    i22 += 5;
                    break;
                case 9:
                    methodVisitor.visitJumpInsn(i24, labelArr[i23 + readShort(i22 + 1)]);
                    i22 += 3;
                    break;
                case 10:
                    methodVisitor.visitJumpInsn(i24 - 33, labelArr[i23 + readInt(i22 + 1)]);
                    i22 += 5;
                    break;
                case 11:
                    methodVisitor.visitLdcInsn(readConst(bArr[i22 + 1] & 255, cArr));
                    i22 += 2;
                    break;
                case 12:
                    methodVisitor.visitLdcInsn(readConst(readUnsignedShort(i22 + 1), cArr));
                    i22 += 3;
                    break;
                case 13:
                    methodVisitor.visitIincInsn(bArr[i22 + 1] & 255, bArr[i22 + 2]);
                    i22 += 3;
                    break;
                case 14:
                    int i34 = (i22 + 4) - (i23 & 3);
                    int readInt4 = i23 + readInt(i34);
                    int readInt5 = readInt(i34 + 4);
                    int readInt6 = readInt(i34 + 8);
                    Label[] labelArr2 = new Label[(readInt6 - readInt5) + 1];
                    i22 = i34 + 12;
                    for (int i35 = 0; i35 < labelArr2.length; i35++) {
                        labelArr2[i35] = labelArr[i23 + readInt(i22)];
                        i22 += 4;
                    }
                    methodVisitor.visitTableSwitchInsn(readInt5, readInt6, labelArr[readInt4], labelArr2);
                    break;
                case 15:
                    int i36 = (i22 + 4) - (i23 & 3);
                    int readInt7 = i23 + readInt(i36);
                    int readInt8 = readInt(i36 + 4);
                    int[] iArr3 = new int[readInt8];
                    Label[] labelArr3 = new Label[readInt8];
                    i22 = i36 + 8;
                    for (int i37 = 0; i37 < readInt8; i37++) {
                        iArr3[i37] = readInt(i22);
                        labelArr3[i37] = labelArr[i23 + readInt(i22 + 4)];
                        i22 += 8;
                    }
                    methodVisitor.visitLookupSwitchInsn(labelArr[readInt7], iArr3, labelArr3);
                    break;
                case 16:
                default:
                    methodVisitor.visitMultiANewArrayInsn(readClass(i22 + 1, cArr), bArr[i22 + 3] & 255);
                    i22 += 4;
                    break;
                case 17:
                    int i38 = bArr[i22 + 1] & 255;
                    if (i38 == 132) {
                        methodVisitor.visitIincInsn(readUnsignedShort(i22 + 2), readShort(i22 + 4));
                        i22 += 6;
                        break;
                    } else {
                        methodVisitor.visitVarInsn(i38, readUnsignedShort(i22 + 2));
                        i22 += 4;
                        break;
                    }
            }
            while (iArr != null && i8 < iArr.length && i10 <= i23) {
                if (i10 == i23) {
                    int a = m1564a(context, iArr[i8]);
                    m1569a(a + 2, cArr, true, methodVisitor.visitInsnAnnotation(context.f88i, context.f89j, readUTF8(a, cArr), true));
                }
                i8++;
                i10 = (i8 >= iArr.length || readByte(iArr[i8]) < 67) ? -1 : readUnsignedShort(iArr[i8] + 1);
            }
            while (iArr2 != null && i9 < iArr2.length && i11 <= i23) {
                if (i11 == i23) {
                    int a2 = m1564a(context, iArr2[i9]);
                    m1569a(a2 + 2, cArr, true, methodVisitor.visitInsnAnnotation(context.f88i, context.f89j, readUTF8(a2, cArr), false));
                }
                i9++;
                i11 = (i9 >= iArr2.length || readByte(iArr2[i9]) < 67) ? -1 : readUnsignedShort(iArr2[i9] + 1);
            }
        }
        if (labelArr[readInt] != null) {
            methodVisitor.visitLabel(labelArr[readInt]);
        }
        if ((context.f81b & 2) == 0 && i12 != 0) {
            int[] iArr4 = null;
            if (i13 != 0) {
                int i39 = i13 + 2;
                iArr4 = new int[readUnsignedShort(i13) * 3];
                int length = iArr4.length;
                while (length > 0) {
                    int i40 = length - 1;
                    iArr4[i40] = i39 + 6;
                    int i41 = i40 - 1;
                    iArr4[i41] = readUnsignedShort(i39 + 8);
                    length = i41 - 1;
                    iArr4[length] = readUnsignedShort(i39);
                    i39 += 10;
                }
            }
            int i42 = i12 + 2;
            for (int readUnsignedShort12 = readUnsignedShort(i12); readUnsignedShort12 > 0; readUnsignedShort12--) {
                int readUnsignedShort13 = readUnsignedShort(i42);
                int readUnsignedShort14 = readUnsignedShort(i42 + 2);
                int readUnsignedShort15 = readUnsignedShort(i42 + 8);
                String str = null;
                if (iArr4 != null) {
                    int i43 = 0;
                    while (true) {
                        if (i43 >= iArr4.length) {
                            break;
                        } else if (iArr4[i43] == readUnsignedShort13 && iArr4[i43 + 1] == readUnsignedShort15) {
                            str = readUTF8(iArr4[i43 + 2], cArr);
                        } else {
                            i43 += 3;
                        }
                    }
                }
                methodVisitor.visitLocalVariable(readUTF8(i42 + 4, cArr), readUTF8(i42 + 6, cArr), str, labelArr[readUnsignedShort13], labelArr[readUnsignedShort13 + readUnsignedShort14], readUnsignedShort15);
                i42 += 10;
            }
        }
        if (iArr != null) {
            for (int i44 = 0; i44 < iArr.length; i44++) {
                if ((readByte(iArr[i44]) >> 1) == 32) {
                    int a3 = m1564a(context, iArr[i44]);
                    m1569a(a3 + 2, cArr, true, methodVisitor.visitLocalVariableAnnotation(context.f88i, context.f89j, context.f91l, context.f92m, context.f93n, readUTF8(a3, cArr), true));
                }
            }
        }
        if (iArr2 != null) {
            for (int i45 = 0; i45 < iArr2.length; i45++) {
                if ((readByte(iArr2[i45]) >> 1) == 32) {
                    int a4 = m1564a(context, iArr2[i45]);
                    m1569a(a4 + 2, cArr, true, methodVisitor.visitLocalVariableAnnotation(context.f88i, context.f89j, context.f91l, context.f92m, context.f93n, readUTF8(a4, cArr), false));
                }
            }
        }
        while (attribute != null) {
            attribute = attribute.f32a;
            attribute.f32a = null;
            methodVisitor.visitAttribute(attribute);
        }
        methodVisitor.visitMaxs(readUnsignedShort2, readUnsignedShort3);
    }

    /* renamed from: a */
    private int[] m1562a(MethodVisitor methodVisitor, Context context, int i, boolean z) {
        int i2;
        char[] cArr = context.f82c;
        int[] iArr = new int[readUnsignedShort(i)];
        int i3 = i + 2;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            iArr[i4] = i3;
            int readInt = readInt(i3);
            switch (readInt >>> 24) {
                case 0:
                case 1:
                case 22:
                    i2 = i3 + 2;
                    break;
                case 19:
                case 20:
                case 21:
                    i2 = i3 + 1;
                    break;
                case 64:
                case 65:
                    for (int readUnsignedShort = readUnsignedShort(i3 + 1); readUnsignedShort > 0; readUnsignedShort--) {
                        int readUnsignedShort2 = readUnsignedShort(i3 + 3);
                        int readUnsignedShort3 = readUnsignedShort(i3 + 5);
                        readLabel(readUnsignedShort2, context.f87h);
                        readLabel(readUnsignedShort2 + readUnsignedShort3, context.f87h);
                        i3 += 6;
                    }
                    i2 = i3 + 3;
                    break;
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                    i2 = i3 + 4;
                    break;
                default:
                    i2 = i3 + 3;
                    break;
            }
            int readByte = readByte(i2);
            if ((readInt >>> 24) == 66) {
                TypePath typePath = readByte == 0 ? null : new TypePath(this.f35b, i2);
                int i5 = i2 + 1 + (2 * readByte);
                i3 = m1569a(i5 + 2, cArr, true, methodVisitor.visitTryCatchAnnotation(readInt, typePath, readUTF8(i5, cArr), z));
            } else {
                i3 = m1569a(i2 + 3 + (2 * readByte), cArr, true, (AnnotationVisitor) null);
            }
        }
        return iArr;
    }

    /* renamed from: a */
    private int m1564a(Context context, int i) {
        int i2;
        int i3;
        int readInt = readInt(i);
        switch (readInt >>> 24) {
            case 0:
            case 1:
            case 22:
                i2 = readInt & Opcodes.V_PREVIEW;
                i3 = i + 2;
                break;
            case 19:
            case 20:
            case 21:
                i2 = readInt & -16777216;
                i3 = i + 1;
                break;
            case 64:
            case 65:
                i2 = readInt & -16777216;
                int readUnsignedShort = readUnsignedShort(i + 1);
                context.f91l = new Label[readUnsignedShort];
                context.f92m = new Label[readUnsignedShort];
                context.f93n = new int[readUnsignedShort];
                i3 = i + 3;
                for (int i4 = 0; i4 < readUnsignedShort; i4++) {
                    int readUnsignedShort2 = readUnsignedShort(i3);
                    int readUnsignedShort3 = readUnsignedShort(i3 + 2);
                    context.f91l[i4] = readLabel(readUnsignedShort2, context.f87h);
                    context.f92m[i4] = readLabel(readUnsignedShort2 + readUnsignedShort3, context.f87h);
                    context.f93n[i4] = readUnsignedShort(i3 + 4);
                    i3 += 6;
                }
                break;
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
                i2 = readInt & -16776961;
                i3 = i + 4;
                break;
            default:
                i2 = readInt & ((readInt >>> 24) < 67 ? -256 : -16777216);
                i3 = i + 3;
                break;
        }
        int readByte = readByte(i3);
        context.f88i = i2;
        context.f89j = readByte == 0 ? null : new TypePath(this.f35b, i3);
        return i3 + 1 + (2 * readByte);
    }

    /* renamed from: b */
    private void m1557b(MethodVisitor methodVisitor, Context context, int i, boolean z) {
        int i2 = i + 1;
        int i3 = this.f35b[i] & 255;
        int length = Type.getArgumentTypes(context.f86g).length - i3;
        int i4 = 0;
        while (i4 < length) {
            AnnotationVisitor visitParameterAnnotation = methodVisitor.visitParameterAnnotation(i4, "Ljava/lang/Synthetic;", false);
            if (visitParameterAnnotation != null) {
                visitParameterAnnotation.visitEnd();
            }
            i4++;
        }
        char[] cArr = context.f82c;
        while (i4 < i3 + length) {
            i2 += 2;
            for (int readUnsignedShort = readUnsignedShort(i2); readUnsignedShort > 0; readUnsignedShort--) {
                i2 = m1569a(i2 + 2, cArr, true, methodVisitor.visitParameterAnnotation(i4, readUTF8(i2, cArr), z));
            }
            i4++;
        }
    }

    /* renamed from: a */
    private int m1569a(int i, char[] cArr, boolean z, AnnotationVisitor annotationVisitor) {
        int readUnsignedShort = readUnsignedShort(i);
        int i2 = i + 2;
        if (z) {
            while (readUnsignedShort > 0) {
                i2 = m1570a(i2 + 2, cArr, readUTF8(i2, cArr), annotationVisitor);
                readUnsignedShort--;
            }
        } else {
            while (readUnsignedShort > 0) {
                i2 = m1570a(i2, cArr, (String) null, annotationVisitor);
                readUnsignedShort--;
            }
        }
        if (annotationVisitor != null) {
            annotationVisitor.visitEnd();
        }
        return i2;
    }

    /* renamed from: a */
    private int m1570a(int i, char[] cArr, String str, AnnotationVisitor annotationVisitor) {
        if (annotationVisitor == null) {
            switch (this.f35b[i] & 255) {
                case 64:
                    return m1569a(i + 3, cArr, true, (AnnotationVisitor) null);
                case 91:
                    return m1569a(i + 1, cArr, false, (AnnotationVisitor) null);
                case 101:
                    return i + 5;
                default:
                    return i + 3;
            }
        } else {
            int i2 = i + 1;
            switch (this.f35b[i] & 255) {
                case 64:
                    i2 = m1569a(i2 + 2, cArr, true, annotationVisitor.visitAnnotation(str, readUTF8(i2, cArr)));
                    break;
                case 66:
                    annotationVisitor.visit(str, new Byte((byte) readInt(this.f36a[readUnsignedShort(i2)])));
                    i2 += 2;
                    break;
                case 67:
                    annotationVisitor.visit(str, new Character((char) readInt(this.f36a[readUnsignedShort(i2)])));
                    i2 += 2;
                    break;
                case 68:
                case 70:
                case 73:
                case 74:
                    annotationVisitor.visit(str, readConst(readUnsignedShort(i2), cArr));
                    i2 += 2;
                    break;
                case 83:
                    annotationVisitor.visit(str, new Short((short) readInt(this.f36a[readUnsignedShort(i2)])));
                    i2 += 2;
                    break;
                case 90:
                    annotationVisitor.visit(str, readInt(this.f36a[readUnsignedShort(i2)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
                    i2 += 2;
                    break;
                case 91:
                    int readUnsignedShort = readUnsignedShort(i2);
                    int i3 = i2 + 2;
                    if (readUnsignedShort != 0) {
                        int i4 = i3 + 1;
                        switch (this.f35b[i3] & 255) {
                            case 66:
                                byte[] bArr = new byte[readUnsignedShort];
                                for (int i5 = 0; i5 < readUnsignedShort; i5++) {
                                    bArr[i5] = (byte) readInt(this.f36a[readUnsignedShort(i4)]);
                                    i4 += 3;
                                }
                                annotationVisitor.visit(str, bArr);
                                i2 = i4 - 1;
                                break;
                            case 67:
                                char[] cArr2 = new char[readUnsignedShort];
                                for (int i6 = 0; i6 < readUnsignedShort; i6++) {
                                    cArr2[i6] = (char) readInt(this.f36a[readUnsignedShort(i4)]);
                                    i4 += 3;
                                }
                                annotationVisitor.visit(str, cArr2);
                                i2 = i4 - 1;
                                break;
                            case 68:
                                double[] dArr = new double[readUnsignedShort];
                                for (int i7 = 0; i7 < readUnsignedShort; i7++) {
                                    dArr[i7] = Double.longBitsToDouble(readLong(this.f36a[readUnsignedShort(i4)]));
                                    i4 += 3;
                                }
                                annotationVisitor.visit(str, dArr);
                                i2 = i4 - 1;
                                break;
                            case 69:
                            case 71:
                            case 72:
                            case 75:
                            case 76:
                            case 77:
                            case 78:
                            case 79:
                            case 80:
                            case 81:
                            case 82:
                            case 84:
                            case 85:
                            case 86:
                            case 87:
                            case 88:
                            case 89:
                            default:
                                i2 = m1569a(i4 - 3, cArr, false, annotationVisitor.visitArray(str));
                                break;
                            case 70:
                                float[] fArr = new float[readUnsignedShort];
                                for (int i8 = 0; i8 < readUnsignedShort; i8++) {
                                    fArr[i8] = Float.intBitsToFloat(readInt(this.f36a[readUnsignedShort(i4)]));
                                    i4 += 3;
                                }
                                annotationVisitor.visit(str, fArr);
                                i2 = i4 - 1;
                                break;
                            case 73:
                                int[] iArr = new int[readUnsignedShort];
                                for (int i9 = 0; i9 < readUnsignedShort; i9++) {
                                    iArr[i9] = readInt(this.f36a[readUnsignedShort(i4)]);
                                    i4 += 3;
                                }
                                annotationVisitor.visit(str, iArr);
                                i2 = i4 - 1;
                                break;
                            case 74:
                                long[] jArr = new long[readUnsignedShort];
                                for (int i10 = 0; i10 < readUnsignedShort; i10++) {
                                    jArr[i10] = readLong(this.f36a[readUnsignedShort(i4)]);
                                    i4 += 3;
                                }
                                annotationVisitor.visit(str, jArr);
                                i2 = i4 - 1;
                                break;
                            case 83:
                                short[] sArr = new short[readUnsignedShort];
                                for (int i11 = 0; i11 < readUnsignedShort; i11++) {
                                    sArr[i11] = (short) readInt(this.f36a[readUnsignedShort(i4)]);
                                    i4 += 3;
                                }
                                annotationVisitor.visit(str, sArr);
                                i2 = i4 - 1;
                                break;
                            case 90:
                                boolean[] zArr = new boolean[readUnsignedShort];
                                for (int i12 = 0; i12 < readUnsignedShort; i12++) {
                                    zArr[i12] = readInt(this.f36a[readUnsignedShort(i4)]) != 0;
                                    i4 += 3;
                                }
                                annotationVisitor.visit(str, zArr);
                                i2 = i4 - 1;
                                break;
                        }
                    } else {
                        return m1569a(i3 - 2, cArr, false, annotationVisitor.visitArray(str));
                    }
                case 99:
                    annotationVisitor.visit(str, Type.getType(readUTF8(i2, cArr)));
                    i2 += 2;
                    break;
                case 101:
                    annotationVisitor.visitEnum(str, readUTF8(i2, cArr), readUTF8(i2 + 2, cArr));
                    i2 += 4;
                    break;
                case 115:
                    annotationVisitor.visit(str, readUTF8(i2, cArr));
                    i2 += 2;
                    break;
            }
            return i2;
        }
    }

    /* renamed from: a */
    private void m1565a(Context context) {
        String str = context.f86g;
        Object[] objArr = context.f97s;
        int i = 0;
        if ((context.f84e & 8) == 0) {
            if ("<init>".equals(context.f85f)) {
                i = 0 + 1;
                objArr[0] = Opcodes.UNINITIALIZED_THIS;
            } else {
                i = 0 + 1;
                objArr[0] = readClass(this.header + 2, context.f82c);
            }
        }
        int i2 = 1;
        while (true) {
            i2++;
            switch (str.charAt(i2)) {
                case 'B':
                case 'C':
                case 'I':
                case 'S':
                case 'Z':
                    i++;
                    objArr[i] = Opcodes.INTEGER;
                    break;
                case 'D':
                    i++;
                    objArr[i] = Opcodes.DOUBLE;
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
                    context.f95q = i;
                    return;
                case 'F':
                    i++;
                    objArr[i] = Opcodes.FLOAT;
                    break;
                case 'J':
                    i++;
                    objArr[i] = Opcodes.LONG;
                    break;
                case 'L':
                    while (str.charAt(i2) != ';') {
                        i2++;
                    }
                    i++;
                    int i3 = i2 + 1;
                    i2++;
                    objArr[i] = str.substring(i3, i2);
                    break;
                case '[':
                    while (str.charAt(i2) == '[') {
                        i2++;
                    }
                    if (str.charAt(i2) == 'L') {
                        while (true) {
                            i2++;
                            if (str.charAt(i2) != ';') {
                            }
                        }
                    }
                    i++;
                    i2++;
                    objArr[i] = str.substring(i2, i2);
                    break;
            }
        }
    }

    /* renamed from: a */
    private int m1571a(int i, boolean z, boolean z2, Context context) {
        int i2;
        int i3;
        char[] cArr = context.f82c;
        Label[] labelArr = context.f87h;
        if (z) {
            i++;
            i2 = this.f35b[i] & 255;
        } else {
            i2 = 255;
            context.f90o = -1;
        }
        context.f96r = 0;
        if (i2 < 64) {
            i3 = i2;
            context.f94p = 3;
            context.f98t = 0;
        } else if (i2 < 128) {
            i3 = i2 - 64;
            i = m1559a(context.f99u, 0, i, cArr, labelArr);
            context.f94p = 4;
            context.f98t = 1;
        } else {
            i3 = readUnsignedShort(i);
            i += 2;
            if (i2 == 247) {
                i = m1559a(context.f99u, 0, i, cArr, labelArr);
                context.f94p = 4;
                context.f98t = 1;
            } else if (i2 >= 248 && i2 < 251) {
                context.f94p = 2;
                context.f96r = PacketOpcodes.EnterSceneReadyRsp - i2;
                context.f95q -= context.f96r;
                context.f98t = 0;
            } else if (i2 == 251) {
                context.f94p = 3;
                context.f98t = 0;
            } else if (i2 < 255) {
                int i4 = z2 ? context.f95q : 0;
                for (int i5 = i2 - PacketOpcodes.EnterSceneReadyRsp; i5 > 0; i5--) {
                    i4++;
                    i = m1559a(context.f97s, i4, i, cArr, labelArr);
                }
                context.f94p = 1;
                context.f96r = i2 - PacketOpcodes.EnterSceneReadyRsp;
                context.f95q += context.f96r;
                context.f98t = 0;
            } else {
                context.f94p = 0;
                int readUnsignedShort = readUnsignedShort(i);
                int i6 = i + 2;
                context.f96r = readUnsignedShort;
                context.f95q = readUnsignedShort;
                int i7 = 0;
                while (readUnsignedShort > 0) {
                    i7++;
                    i6 = m1559a(context.f97s, i7, i6, cArr, labelArr);
                    readUnsignedShort--;
                }
                int readUnsignedShort2 = readUnsignedShort(i6);
                i = i6 + 2;
                context.f98t = readUnsignedShort2;
                int i8 = 0;
                while (readUnsignedShort2 > 0) {
                    i8++;
                    i = m1559a(context.f99u, i8, i, cArr, labelArr);
                    readUnsignedShort2--;
                }
            }
        }
        context.f90o += i3 + 1;
        readLabel(context.f90o, labelArr);
        return i;
    }

    /* renamed from: a */
    private int m1559a(Object[] objArr, int i, int i2, char[] cArr, Label[] labelArr) {
        int i3 = i2 + 1;
        switch (this.f35b[i2] & 255) {
            case 0:
                objArr[i] = Opcodes.TOP;
                break;
            case 1:
                objArr[i] = Opcodes.INTEGER;
                break;
            case 2:
                objArr[i] = Opcodes.FLOAT;
                break;
            case 3:
                objArr[i] = Opcodes.DOUBLE;
                break;
            case 4:
                objArr[i] = Opcodes.LONG;
                break;
            case 5:
                objArr[i] = Opcodes.NULL;
                break;
            case 6:
                objArr[i] = Opcodes.UNINITIALIZED_THIS;
                break;
            case 7:
                objArr[i] = readClass(i3, cArr);
                i3 += 2;
                break;
            default:
                objArr[i] = readLabel(readUnsignedShort(i3), labelArr);
                i3 += 2;
                break;
        }
        return i3;
    }

    protected Label readLabel(int i, Label[] labelArr) {
        if (labelArr[i] == null) {
            labelArr[i] = new Label();
        }
        return labelArr[i];
    }

    /* renamed from: a */
    private int m1573a() {
        int readUnsignedShort = this.header + 8 + (readUnsignedShort(this.header + 6) * 2);
        for (int readUnsignedShort2 = readUnsignedShort(readUnsignedShort); readUnsignedShort2 > 0; readUnsignedShort2--) {
            for (int readUnsignedShort3 = readUnsignedShort(readUnsignedShort + 8); readUnsignedShort3 > 0; readUnsignedShort3--) {
                readUnsignedShort += 6 + readInt(readUnsignedShort + 12);
            }
            readUnsignedShort += 8;
        }
        int i = readUnsignedShort + 2;
        for (int readUnsignedShort4 = readUnsignedShort(i); readUnsignedShort4 > 0; readUnsignedShort4--) {
            for (int readUnsignedShort5 = readUnsignedShort(i + 8); readUnsignedShort5 > 0; readUnsignedShort5--) {
                i += 6 + readInt(i + 12);
            }
            i += 8;
        }
        return i + 2;
    }

    /* renamed from: a */
    private Attribute m1560a(Attribute[] attributeArr, String str, int i, int i2, char[] cArr, int i3, Label[] labelArr) {
        for (int i4 = 0; i4 < attributeArr.length; i4++) {
            if (attributeArr[i4].type.equals(str)) {
                return attributeArr[i4].read(this, i, i2, cArr, i3, labelArr);
            }
        }
        return new Attribute(str).read(this, i, i2, null, -1, null);
    }

    public int getItemCount() {
        return this.f36a.length;
    }

    public int getItem(int i) {
        return this.f36a[i];
    }

    public int getMaxStringLength() {
        return this.f38d;
    }

    public int readByte(int i) {
        return this.f35b[i] & 255;
    }

    public int readUnsignedShort(int i) {
        byte[] bArr = this.f35b;
        return ((bArr[i] & 255) << 8) | (bArr[i + 1] & 255);
    }

    public short readShort(int i) {
        byte[] bArr = this.f35b;
        return (short) (((bArr[i] & 255) << 8) | (bArr[i + 1] & 255));
    }

    public int readInt(int i) {
        byte[] bArr = this.f35b;
        return ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8) | (bArr[i + 3] & 255);
    }

    public long readLong(int i) {
        long readInt = (long) readInt(i);
        return (readInt << 32) | (((long) readInt(i + 4)) & 4294967295L);
    }

    public String readUTF8(int i, char[] cArr) {
        int readUnsignedShort = readUnsignedShort(i);
        if (i == 0 || readUnsignedShort == 0) {
            return null;
        }
        String str = this.f37c[readUnsignedShort];
        if (str != null) {
            return str;
        }
        int i2 = this.f36a[readUnsignedShort];
        String[] strArr = this.f37c;
        String a = m1572a(i2 + 2, readUnsignedShort(i2), cArr);
        strArr[readUnsignedShort] = a;
        return a;
    }

    /* renamed from: a */
    private String m1572a(int i, int i2, char[] cArr) {
        int i3 = i + i2;
        byte[] bArr = this.f35b;
        int i4 = 0;
        char c = 0;
        char c2 = 0;
        while (i < i3) {
            i++;
            byte b = bArr[i];
            switch (c) {
                case 0:
                    int i5 = b & 255;
                    if (i5 >= 128) {
                        if (i5 < 224 && i5 > 191) {
                            c2 = (char) (i5 & 31);
                            c = 1;
                            break;
                        } else {
                            c2 = (char) (i5 & 15);
                            c = 2;
                            break;
                        }
                    } else {
                        i4++;
                        cArr[i4] = (char) i5;
                        break;
                    }
                    break;
                case 1:
                    i4++;
                    cArr[i4] = (char) ((c2 << 6) | (b & 63));
                    c = 0;
                    break;
                case 2:
                    c2 = (char) ((c2 << 6) | (b & 63));
                    c = 1;
                    break;
            }
        }
        return new String(cArr, 0, i4);
    }

    public String readClass(int i, char[] cArr) {
        return readUTF8(this.f36a[readUnsignedShort(i)], cArr);
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: com.esotericsoftware.asm.ClassReader.readConst(int, char[]):java.lang.Object, file: grasscutter.jar:com/esotericsoftware/asm/ClassReader.class
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:204)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.plugins.input.java.utils.JavaClassParseException: Unknown opcode: 0x5e
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:71)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	... 5 more
        */
    public java.lang.Object readConst(int r1, char[] r2) {
        /*
        // Can't load method instructions: Load method exception: JavaClassParseException: Unknown opcode: 0x5e in method: com.esotericsoftware.asm.ClassReader.readConst(int, char[]):java.lang.Object, file: grasscutter.jar:com/esotericsoftware/asm/ClassReader.class
        */
        throw new UnsupportedOperationException("Method not decompiled: com.esotericsoftware.asm.ClassReader.readConst(int, char[]):java.lang.Object");
    }
}
