package com.esotericsoftware.asm;

import net.bytebuddy.implementation.auxiliary.TypeProxy;
import org.luaj.vm2.Lua;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/esotericsoftware/asm/Frame.class */
public final class Frame {

    /* renamed from: a */
    static final int[] f115a;

    /* renamed from: b */
    Label f116b;

    /* renamed from: c */
    int[] f117c;

    /* renamed from: d */
    int[] f118d;

    /* renamed from: e */
    private int[] f119e;

    /* renamed from: f */
    private int[] f120f;

    /* renamed from: g */
    private int f121g;

    /* renamed from: h */
    private int f122h;

    /* renamed from: i */
    private int[] f123i;

    /* renamed from: a */
    private int m1532a(int i) {
        if (this.f119e == null || i >= this.f119e.length) {
            return 33554432 | i;
        }
        int i2 = this.f119e[i];
        if (i2 == 0) {
            int i3 = 33554432 | i;
            this.f119e[i] = i3;
            i2 = i3;
        }
        return i2;
    }

    /* renamed from: a */
    private void m1531a(int i, int i2) {
        if (this.f119e == null) {
            this.f119e = new int[10];
        }
        int length = this.f119e.length;
        if (i >= length) {
            int[] iArr = new int[Math.max(i + 1, 2 * length)];
            System.arraycopy(this.f119e, 0, iArr, 0, length);
            this.f119e = iArr;
        }
        this.f119e[i] = i2;
    }

    /* renamed from: b */
    private void m1523b(int i) {
        if (this.f120f == null) {
            this.f120f = new int[10];
        }
        int length = this.f120f.length;
        if (this.f121g >= length) {
            int[] iArr = new int[Math.max(this.f121g + 1, 2 * length)];
            System.arraycopy(this.f120f, 0, iArr, 0, length);
            this.f120f = iArr;
        }
        int[] iArr2 = this.f120f;
        int i2 = this.f121g;
        this.f121g = i2 + 1;
        iArr2[i2] = i;
        int i3 = this.f116b.f149f + this.f121g;
        if (i3 > this.f116b.f150g) {
            this.f116b.f150g = i3;
        }
    }

    /* renamed from: a */
    private void m1525a(ClassWriter classWriter, String str) {
        int b = m1522b(classWriter, str);
        if (b != 0) {
            m1523b(b);
            if (b == 16777220 || b == 16777219) {
                m1523b(16777216);
            }
        }
    }

    /* renamed from: b */
    private static int m1522b(ClassWriter classWriter, String str) {
        int i;
        int indexOf = str.charAt(0) == '(' ? str.indexOf(41) + 1 : 0;
        switch (str.charAt(indexOf)) {
            case 'B':
            case 'C':
            case 'I':
            case 'S':
            case 'Z':
                return 16777217;
            case 'D':
                return 16777219;
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
            case 'W':
            case 'X':
            case 'Y':
            default:
                int i2 = indexOf + 1;
                while (str.charAt(i2) == '[') {
                    i2++;
                }
                switch (str.charAt(i2)) {
                    case 'B':
                        i = 16777226;
                        break;
                    case 'C':
                        i = 16777227;
                        break;
                    case 'D':
                        i = 16777219;
                        break;
                    case 'E':
                    case 'G':
                    case 'H':
                    case 'K':
                    case 'L':
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
                        i = 24117248 | classWriter.m1537c(str.substring(i2 + 1, str.length() - 1));
                        break;
                    case 'F':
                        i = 16777218;
                        break;
                    case 'I':
                        i = 16777217;
                        break;
                    case 'J':
                        i = 16777220;
                        break;
                    case 'S':
                        i = 16777228;
                        break;
                    case 'Z':
                        i = 16777225;
                        break;
                }
                return ((i2 - indexOf) << 28) | i;
            case 'F':
                return 16777218;
            case 'J':
                return 16777220;
            case 'L':
                return 24117248 | classWriter.m1537c(str.substring(indexOf + 1, str.length() - 1));
            case 'V':
                return 0;
        }
    }

    /* renamed from: a */
    private int m1533a() {
        if (this.f121g > 0) {
            int[] iArr = this.f120f;
            int i = this.f121g - 1;
            this.f121g = i;
            return iArr[i];
        }
        Label label = this.f116b;
        int i2 = label.f149f - 1;
        label.f149f = i2;
        return 50331648 | (-i2);
    }

    /* renamed from: c */
    private void m1521c(int i) {
        if (this.f121g >= i) {
            this.f121g -= i;
            return;
        }
        this.f116b.f149f -= i - this.f121g;
        this.f121g = 0;
    }

    /* renamed from: a */
    private void m1524a(String str) {
        char charAt = str.charAt(0);
        if (charAt == '(') {
            m1521c((Type.getArgumentsAndReturnSizes(str) >> 2) - 1);
        } else if (charAt == 'J' || charAt == 'D') {
            m1521c(2);
        } else {
            m1521c(1);
        }
    }

    /* renamed from: d */
    private void m1520d(int i) {
        if (this.f123i == null) {
            this.f123i = new int[2];
        }
        int length = this.f123i.length;
        if (this.f122h >= length) {
            int[] iArr = new int[Math.max(this.f122h + 1, 2 * length)];
            System.arraycopy(this.f123i, 0, iArr, 0, length);
            this.f123i = iArr;
        }
        int[] iArr2 = this.f123i;
        int i2 = this.f122h;
        this.f122h = i2 + 1;
        iArr2[i2] = i;
    }

    /* renamed from: a */
    private int m1529a(ClassWriter classWriter, int i) {
        int i2;
        if (i == 16777222) {
            i2 = 24117248 | classWriter.m1537c(classWriter.f55I);
        } else if ((i & -1048576) != 25165824) {
            return i;
        } else {
            i2 = 24117248 | classWriter.m1537c(classWriter.f51H[i & 1048575].f139g);
        }
        for (int i3 = 0; i3 < this.f122h; i3++) {
            int i4 = this.f123i[i3];
            int i5 = i4 & -268435456;
            int i6 = i4 & 251658240;
            if (i6 == 33554432) {
                i4 = i5 + this.f117c[i4 & Lua.MASK_NOT_B];
            } else if (i6 == 50331648) {
                i4 = i5 + this.f118d[this.f118d.length - (i4 & Lua.MASK_NOT_B)];
            }
            if (i == i4) {
                return i2;
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1527a(ClassWriter classWriter, int i, Type[] typeArr, int i2) {
        this.f117c = new int[i2];
        this.f118d = new int[0];
        int i3 = 0;
        if ((i & 8) == 0) {
            if ((i & 524288) == 0) {
                i3 = 0 + 1;
                this.f117c[0] = 24117248 | classWriter.m1537c(classWriter.f55I);
            } else {
                i3 = 0 + 1;
                this.f117c[0] = 16777222;
            }
        }
        for (Type type : typeArr) {
            int b = m1522b(classWriter, type.getDescriptor());
            i3++;
            this.f117c[i3] = b;
            if (b == 16777220 || b == 16777219) {
                i3++;
                this.f117c[i3] = 16777216;
            }
        }
        while (i3 < i2) {
            i3++;
            this.f117c[i3] = 16777216;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1530a(int i, int i2, ClassWriter classWriter, Item item) {
        switch (i) {
            case 0:
            case 116:
            case 117:
            case 118:
            case 119:
            case 145:
            case 146:
            case 147:
            case 167:
            case 177:
                return;
            case 1:
                m1523b(16777221);
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 16:
            case 17:
            case 21:
                m1523b(16777217);
                return;
            case 9:
            case 10:
            case 22:
                m1523b(16777220);
                m1523b(16777216);
                return;
            case 11:
            case 12:
            case 13:
            case 23:
                m1523b(16777218);
                return;
            case 14:
            case 15:
            case 24:
                m1523b(16777219);
                m1523b(16777216);
                return;
            case 18:
                switch (item.f136b) {
                    case 3:
                        m1523b(16777217);
                        return;
                    case 4:
                        m1523b(16777218);
                        return;
                    case 5:
                        m1523b(16777220);
                        m1523b(16777216);
                        return;
                    case 6:
                        m1523b(16777219);
                        m1523b(16777216);
                        return;
                    case 7:
                        m1523b(24117248 | classWriter.m1537c(TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME));
                        return;
                    case 8:
                        m1523b(24117248 | classWriter.m1537c("java/lang/String"));
                        return;
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    default:
                        m1523b(24117248 | classWriter.m1537c("java/lang/invoke/MethodHandle"));
                        return;
                    case 16:
                        m1523b(24117248 | classWriter.m1537c("java/lang/invoke/MethodType"));
                        return;
                }
            case 19:
            case 20:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 196:
            case 197:
            default:
                m1521c(i2);
                m1525a(classWriter, item.f139g);
                return;
            case 25:
                m1523b(m1532a(i2));
                return;
            case 46:
            case 51:
            case 52:
            case 53:
                m1521c(2);
                m1523b(16777217);
                return;
            case 47:
            case 143:
                m1521c(2);
                m1523b(16777220);
                m1523b(16777216);
                return;
            case 48:
                m1521c(2);
                m1523b(16777218);
                return;
            case 49:
            case 138:
                m1521c(2);
                m1523b(16777219);
                m1523b(16777216);
                return;
            case 50:
                m1521c(1);
                m1523b(-268435456 + m1533a());
                return;
            case 54:
            case 56:
            case 58:
                m1531a(i2, m1533a());
                if (i2 > 0) {
                    int a = m1532a(i2 - 1);
                    if (a == 16777220 || a == 16777219) {
                        m1531a(i2 - 1, 16777216);
                        return;
                    } else if ((a & 251658240) != 16777216) {
                        m1531a(i2 - 1, a | 8388608);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case 55:
            case 57:
                m1521c(1);
                m1531a(i2, m1533a());
                m1531a(i2 + 1, 16777216);
                if (i2 > 0) {
                    int a2 = m1532a(i2 - 1);
                    if (a2 == 16777220 || a2 == 16777219) {
                        m1531a(i2 - 1, 16777216);
                        return;
                    } else if ((a2 & 251658240) != 16777216) {
                        m1531a(i2 - 1, a2 | 8388608);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case 79:
            case 81:
            case 83:
            case 84:
            case 85:
            case 86:
                m1521c(3);
                return;
            case 80:
            case 82:
                m1521c(4);
                return;
            case 87:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 170:
            case 171:
            case 172:
            case 174:
            case 176:
            case 191:
            case 194:
            case 195:
            case 198:
            case 199:
                m1521c(1);
                return;
            case 88:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 173:
            case 175:
                m1521c(2);
                return;
            case 89:
                int a3 = m1533a();
                m1523b(a3);
                m1523b(a3);
                return;
            case 90:
                int a4 = m1533a();
                int a5 = m1533a();
                m1523b(a4);
                m1523b(a5);
                m1523b(a4);
                return;
            case 91:
                int a6 = m1533a();
                int a7 = m1533a();
                int a8 = m1533a();
                m1523b(a6);
                m1523b(a8);
                m1523b(a7);
                m1523b(a6);
                return;
            case 92:
                int a9 = m1533a();
                int a10 = m1533a();
                m1523b(a10);
                m1523b(a9);
                m1523b(a10);
                m1523b(a9);
                return;
            case 93:
                int a11 = m1533a();
                int a12 = m1533a();
                int a13 = m1533a();
                m1523b(a12);
                m1523b(a11);
                m1523b(a13);
                m1523b(a12);
                m1523b(a11);
                return;
            case 94:
                int a14 = m1533a();
                int a15 = m1533a();
                int a16 = m1533a();
                int a17 = m1533a();
                m1523b(a15);
                m1523b(a14);
                m1523b(a17);
                m1523b(a16);
                m1523b(a15);
                m1523b(a14);
                return;
            case 95:
                int a18 = m1533a();
                int a19 = m1533a();
                m1523b(a18);
                m1523b(a19);
                return;
            case 96:
            case 100:
            case 104:
            case 108:
            case 112:
            case 120:
            case 122:
            case 124:
            case 126:
            case 128:
            case 130:
            case 136:
            case 142:
            case 149:
            case 150:
                m1521c(2);
                m1523b(16777217);
                return;
            case 97:
            case 101:
            case 105:
            case 109:
            case 113:
            case 127:
            case 129:
            case 131:
                m1521c(4);
                m1523b(16777220);
                m1523b(16777216);
                return;
            case 98:
            case 102:
            case 106:
            case 110:
            case 114:
            case 137:
            case 144:
                m1521c(2);
                m1523b(16777218);
                return;
            case 99:
            case 103:
            case 107:
            case 111:
            case 115:
                m1521c(4);
                m1523b(16777219);
                m1523b(16777216);
                return;
            case 121:
            case 123:
            case 125:
                m1521c(3);
                m1523b(16777220);
                m1523b(16777216);
                return;
            case 132:
                m1531a(i2, 16777217);
                return;
            case 133:
            case 140:
                m1521c(1);
                m1523b(16777220);
                m1523b(16777216);
                return;
            case 134:
                m1521c(1);
                m1523b(16777218);
                return;
            case 135:
            case 141:
                m1521c(1);
                m1523b(16777219);
                m1523b(16777216);
                return;
            case 139:
            case 190:
            case 193:
                m1521c(1);
                m1523b(16777217);
                return;
            case 148:
            case 151:
            case 152:
                m1521c(4);
                m1523b(16777217);
                return;
            case 168:
            case 169:
                throw new RuntimeException("JSR/RET are not supported with computeFrames option");
            case 178:
                m1525a(classWriter, item.f141i);
                return;
            case 179:
                m1524a(item.f141i);
                return;
            case 180:
                m1521c(1);
                m1525a(classWriter, item.f141i);
                return;
            case 181:
                m1524a(item.f141i);
                m1533a();
                return;
            case 182:
            case 183:
            case 184:
            case 185:
                m1524a(item.f141i);
                if (i != 184) {
                    int a20 = m1533a();
                    if (i == 183 && item.f140h.charAt(0) == '<') {
                        m1520d(a20);
                    }
                }
                m1525a(classWriter, item.f141i);
                return;
            case 186:
                m1524a(item.f140h);
                m1525a(classWriter, item.f140h);
                return;
            case 187:
                m1523b(25165824 | classWriter.m1546a(item.f139g, i2));
                return;
            case 188:
                m1533a();
                switch (i2) {
                    case 4:
                        m1523b(285212681);
                        return;
                    case 5:
                        m1523b(285212683);
                        return;
                    case 6:
                        m1523b(285212674);
                        return;
                    case 7:
                        m1523b(285212675);
                        return;
                    case 8:
                        m1523b(285212682);
                        return;
                    case 9:
                        m1523b(285212684);
                        return;
                    case 10:
                        m1523b(285212673);
                        return;
                    default:
                        m1523b(285212676);
                        return;
                }
            case 189:
                String str = item.f139g;
                m1533a();
                if (str.charAt(0) == '[') {
                    m1525a(classWriter, new StringBuffer().append('[').append(str).toString());
                    return;
                } else {
                    m1523b(292552704 | classWriter.m1537c(str));
                    return;
                }
            case 192:
                String str2 = item.f139g;
                m1533a();
                if (str2.charAt(0) == '[') {
                    m1525a(classWriter, str2);
                    return;
                } else {
                    m1523b(24117248 | classWriter.m1537c(str2));
                    return;
                }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m1526a(ClassWriter classWriter, Frame frame, int i) {
        int i2;
        int i3;
        boolean z = false;
        int length = this.f117c.length;
        int length2 = this.f118d.length;
        if (frame.f117c == null) {
            frame.f117c = new int[length];
            z = true;
        }
        for (int i4 = 0; i4 < length; i4++) {
            if (this.f119e == null || i4 >= this.f119e.length) {
                i3 = this.f117c[i4];
            } else {
                int i5 = this.f119e[i4];
                if (i5 == 0) {
                    i3 = this.f117c[i4];
                } else {
                    int i6 = i5 & -268435456;
                    int i7 = i5 & 251658240;
                    if (i7 == 16777216) {
                        i3 = i5;
                    } else {
                        i3 = i7 == 33554432 ? i6 + this.f117c[i5 & Lua.MASK_NOT_B] : i6 + this.f118d[length2 - (i5 & Lua.MASK_NOT_B)];
                        if ((i5 & 8388608) != 0 && (i3 == 16777220 || i3 == 16777219)) {
                            i3 = 16777216;
                        }
                    }
                }
            }
            if (this.f123i != null) {
                i3 = m1529a(classWriter, i3);
            }
            z |= m1528a(classWriter, i3, frame.f117c, i4);
        }
        if (i > 0) {
            for (int i8 = 0; i8 < length; i8++) {
                z |= m1528a(classWriter, this.f117c[i8], frame.f117c, i8);
            }
            if (frame.f118d == null) {
                frame.f118d = new int[1];
                z = true;
            }
            return z | m1528a(classWriter, i, frame.f118d, 0);
        }
        int length3 = this.f118d.length + this.f116b.f149f;
        if (frame.f118d == null) {
            frame.f118d = new int[length3 + this.f121g];
            z = true;
        }
        for (int i9 = 0; i9 < length3; i9++) {
            int i10 = this.f118d[i9];
            if (this.f123i != null) {
                i10 = m1529a(classWriter, i10);
            }
            z |= m1528a(classWriter, i10, frame.f118d, i9);
        }
        for (int i11 = 0; i11 < this.f121g; i11++) {
            int i12 = this.f120f[i11];
            int i13 = i12 & -268435456;
            int i14 = i12 & 251658240;
            if (i14 == 16777216) {
                i2 = i12;
            } else {
                i2 = i14 == 33554432 ? i13 + this.f117c[i12 & Lua.MASK_NOT_B] : i13 + this.f118d[length2 - (i12 & Lua.MASK_NOT_B)];
                if ((i12 & 8388608) != 0 && (i2 == 16777220 || i2 == 16777219)) {
                    i2 = 16777216;
                }
            }
            if (this.f123i != null) {
                i2 = m1529a(classWriter, i2);
            }
            z |= m1528a(classWriter, i2, frame.f118d, length3 + i11);
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m1528a(ClassWriter classWriter, int i, int[] iArr, int i2) {
        int i3;
        int i4 = iArr[i2];
        if (i4 == i) {
            return false;
        }
        if ((i & 268435455) == 16777221) {
            if (i4 == 16777221) {
                return false;
            }
            i = 16777221;
        }
        if (i4 == 0) {
            iArr[i2] = i;
            return true;
        }
        if ((i4 & 267386880) != 24117248 && (i4 & -268435456) == 0) {
            i3 = i4 == 16777221 ? ((i & 267386880) == 24117248 || (i & -268435456) != 0) ? i : 16777216 : 16777216;
        } else if (i == 16777221) {
            return false;
        } else {
            if ((i & -1048576) == (i4 & -1048576)) {
                i3 = (i4 & 267386880) == 24117248 ? (i & -268435456) | 24117248 | classWriter.m1553a(i & 1048575, i4 & 1048575) : (-268435456 + (i4 & -268435456)) | 24117248 | classWriter.m1537c(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME);
            } else if ((i & 267386880) == 24117248 || (i & -268435456) != 0) {
                i3 = Math.min((((i & -268435456) == 0 || (i & 267386880) == 24117248) ? 0 : -268435456) + (i & -268435456), (((i4 & -268435456) == 0 || (i4 & 267386880) == 24117248) ? 0 : -268435456) + (i4 & -268435456)) | 24117248 | classWriter.m1537c(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME);
            } else {
                i3 = 16777216;
            }
        }
        if (i4 == i3) {
            return false;
        }
        iArr[i2] = i3;
        return true;
    }

    static {
        _clinit_();
        int[] iArr = new int[202];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDDCDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCDCDCEEEEDDDDDDDCDCDCEFEFDDEEFFDEDEEEBDDBBDDDDDDCCCCCCCCEFEDDDCDCDEEEEEEEEEEFEEEEEEDDEEDDEE".charAt(i) - 'E';
        }
        f115a = iArr;
    }

    static void _clinit_() {
    }
}
