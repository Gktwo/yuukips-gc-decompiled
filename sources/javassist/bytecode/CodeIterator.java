package javassist.bytecode;

import java.util.ArrayList;
import java.util.List;
import javassist.bytecode.CodeAttribute;

/* loaded from: grasscutter.jar:javassist/bytecode/CodeIterator.class */
public class CodeIterator implements Opcode {
    protected CodeAttribute codeAttr;
    protected byte[] bytecode;
    protected int endPos;
    protected int currentPos;
    protected int mark;
    protected int mark2;
    private static final int[] opcodeLength = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 2, 3, 3, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 0, 0, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 5, 5, 3, 2, 3, 1, 1, 3, 3, 1, 1, 0, 4, 3, 3, 5, 5};

    /* loaded from: grasscutter.jar:javassist/bytecode/CodeIterator$Gap.class */
    public static class Gap {
        public int position;
        public int length;
    }

    /* access modifiers changed from: protected */
    public CodeIterator(CodeAttribute ca) {
        this.codeAttr = ca;
        this.bytecode = ca.getCode();
        begin();
    }

    public void begin() {
        this.mark2 = 0;
        this.mark = 0;
        this.currentPos = 0;
        this.endPos = getCodeLength();
    }

    public void move(int index) {
        this.currentPos = index;
    }

    public void setMark(int index) {
        this.mark = index;
    }

    public void setMark2(int index) {
        this.mark2 = index;
    }

    public int getMark() {
        return this.mark;
    }

    public int getMark2() {
        return this.mark2;
    }

    public CodeAttribute get() {
        return this.codeAttr;
    }

    public int getCodeLength() {
        return this.bytecode.length;
    }

    public int byteAt(int index) {
        return this.bytecode[index] & 255;
    }

    public int signedByteAt(int index) {
        return this.bytecode[index];
    }

    public void writeByte(int value, int index) {
        this.bytecode[index] = (byte) value;
    }

    public int u16bitAt(int index) {
        return ByteArray.readU16bit(this.bytecode, index);
    }

    public int s16bitAt(int index) {
        return ByteArray.readS16bit(this.bytecode, index);
    }

    public void write16bit(int value, int index) {
        ByteArray.write16bit(value, this.bytecode, index);
    }

    public int s32bitAt(int index) {
        return ByteArray.read32bit(this.bytecode, index);
    }

    public void write32bit(int value, int index) {
        ByteArray.write32bit(value, this.bytecode, index);
    }

    public void write(byte[] code, int index) {
        for (byte b : code) {
            index++;
            this.bytecode[index] = b;
        }
    }

    public boolean hasNext() {
        return this.currentPos < this.endPos;
    }

    public int next() throws BadBytecode {
        int pos = this.currentPos;
        this.currentPos = nextOpcode(this.bytecode, pos);
        return pos;
    }

    public int lookAhead() {
        return this.currentPos;
    }

    public int skipConstructor() throws BadBytecode {
        return skipSuperConstructor0(-1);
    }

    public int skipSuperConstructor() throws BadBytecode {
        return skipSuperConstructor0(0);
    }

    public int skipThisConstructor() throws BadBytecode {
        return skipSuperConstructor0(1);
    }

    private int skipSuperConstructor0(int skipThis) throws BadBytecode {
        begin();
        ConstPool cp = this.codeAttr.getConstPool();
        String thisClassName = this.codeAttr.getDeclaringClass();
        int nested = 0;
        while (true) {
            if (!hasNext()) {
                break;
            }
            int index = next();
            int c = byteAt(index);
            if (c == 187) {
                nested++;
            } else if (c == 183) {
                int mref = ByteArray.readU16bit(this.bytecode, index + 1);
                if (cp.getMethodrefName(mref).equals("<init>")) {
                    nested--;
                    if (nested < 0) {
                        if (skipThis < 0) {
                            return index;
                        }
                        if (cp.getMethodrefClassName(mref).equals(thisClassName) == (skipThis > 0)) {
                            return index;
                        }
                    }
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
        begin();
        return -1;
    }

    public int insert(byte[] code) throws BadBytecode {
        return insert0(this.currentPos, code, false);
    }

    public void insert(int pos, byte[] code) throws BadBytecode {
        insert0(pos, code, false);
    }

    public int insertAt(int pos, byte[] code) throws BadBytecode {
        return insert0(pos, code, false);
    }

    public int insertEx(byte[] code) throws BadBytecode {
        return insert0(this.currentPos, code, true);
    }

    public void insertEx(int pos, byte[] code) throws BadBytecode {
        insert0(pos, code, true);
    }

    public int insertExAt(int pos, byte[] code) throws BadBytecode {
        return insert0(pos, code, true);
    }

    private int insert0(int pos, byte[] code, boolean exclusive) throws BadBytecode {
        int len = code.length;
        if (len <= 0) {
            return pos;
        }
        int pos2 = insertGapAt(pos, len, exclusive).position;
        int p = pos2;
        for (byte b : code) {
            p++;
            this.bytecode[p] = b;
        }
        return pos2;
    }

    public int insertGap(int length) throws BadBytecode {
        return insertGapAt(this.currentPos, length, false).position;
    }

    public int insertGap(int pos, int length) throws BadBytecode {
        return insertGapAt(pos, length, false).length;
    }

    public int insertExGap(int length) throws BadBytecode {
        return insertGapAt(this.currentPos, length, true).position;
    }

    public int insertExGap(int pos, int length) throws BadBytecode {
        return insertGapAt(pos, length, true).length;
    }

    public Gap insertGapAt(int pos, int length, boolean exclusive) throws BadBytecode {
        int length2;
        byte[] c;
        Gap gap = new Gap();
        if (length <= 0) {
            gap.position = pos;
            gap.length = 0;
            return gap;
        }
        if (this.bytecode.length + length > 32767) {
            c = insertGapCore0w(this.bytecode, pos, length, exclusive, get().getExceptionTable(), this.codeAttr, gap);
            pos = gap.position;
            length2 = length;
        } else {
            int cur = this.currentPos;
            c = insertGapCore0(this.bytecode, pos, length, exclusive, get().getExceptionTable(), this.codeAttr);
            length2 = c.length - this.bytecode.length;
            gap.position = pos;
            gap.length = length2;
            if (cur >= pos) {
                this.currentPos = cur + length2;
            }
            if (this.mark > pos || (this.mark == pos && exclusive)) {
                this.mark += length2;
            }
            if (this.mark2 > pos || (this.mark2 == pos && exclusive)) {
                this.mark2 += length2;
            }
        }
        this.codeAttr.setCode(c);
        this.bytecode = c;
        this.endPos = getCodeLength();
        updateCursors(pos, length2);
        return gap;
    }

    protected void updateCursors(int pos, int length) {
    }

    public void insert(ExceptionTable et, int offset) {
        this.codeAttr.getExceptionTable().add(0, et, offset);
    }

    public int append(byte[] code) {
        int size = getCodeLength();
        int len = code.length;
        if (len <= 0) {
            return size;
        }
        appendGap(len);
        byte[] dest = this.bytecode;
        for (int i = 0; i < len; i++) {
            dest[i + size] = code[i];
        }
        return size;
    }

    public void appendGap(int gapLength) {
        byte[] code = this.bytecode;
        int codeLength = code.length;
        byte[] newcode = new byte[codeLength + gapLength];
        for (int i = 0; i < codeLength; i++) {
            newcode[i] = code[i];
        }
        for (int i2 = codeLength; i2 < codeLength + gapLength; i2++) {
            newcode[i2] = 0;
        }
        this.codeAttr.setCode(newcode);
        this.bytecode = newcode;
        this.endPos = getCodeLength();
    }

    public void append(ExceptionTable et, int offset) {
        ExceptionTable table = this.codeAttr.getExceptionTable();
        table.add(table.size(), et, offset);
    }

    /* access modifiers changed from: package-private */
    public static int nextOpcode(byte[] code, int index) throws BadBytecode {
        int len;
        try {
            int opcode = code[index] & 255;
            try {
                len = opcodeLength[opcode];
            } catch (IndexOutOfBoundsException e) {
            }
            if (len > 0) {
                return index + len;
            }
            if (opcode != 196) {
                int index2 = (index & -4) + 8;
                if (opcode == 171) {
                    return index2 + (ByteArray.read32bit(code, index2) * 8) + 4;
                }
                if (opcode == 170) {
                    return index2 + (((ByteArray.read32bit(code, index2 + 4) - ByteArray.read32bit(code, index2)) + 1) * 4) + 8;
                }
                throw new BadBytecode(opcode);
            } else if (code[index + 1] == -124) {
                return index + 6;
            } else {
                return index + 4;
            }
        } catch (IndexOutOfBoundsException e2) {
            throw new BadBytecode("invalid opcode address");
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:javassist/bytecode/CodeIterator$AlignmentException.class */
    public static class AlignmentException extends Exception {
        private static final long serialVersionUID = 1;

        AlignmentException() {
        }
    }

    static byte[] insertGapCore0(byte[] code, int where, int gapLength, boolean exclusive, ExceptionTable etable, CodeAttribute ca) throws BadBytecode {
        if (gapLength <= 0) {
            return code;
        }
        try {
            return insertGapCore1(code, where, gapLength, exclusive, etable, ca);
        } catch (AlignmentException e) {
            try {
                return insertGapCore1(code, where, (gapLength + 3) & -4, exclusive, etable, ca);
            } catch (AlignmentException e2) {
                throw new RuntimeException("fatal error?");
            }
        }
    }

    private static byte[] insertGapCore1(byte[] code, int where, int gapLength, boolean exclusive, ExceptionTable etable, CodeAttribute ca) throws BadBytecode, AlignmentException {
        int codeLength = code.length;
        byte[] newcode = new byte[codeLength + gapLength];
        insertGap2(code, where, gapLength, codeLength, newcode, exclusive);
        etable.shiftPc(where, gapLength, exclusive);
        LineNumberAttribute na = (LineNumberAttribute) ca.getAttribute(LineNumberAttribute.tag);
        if (na != null) {
            na.shiftPc(where, gapLength, exclusive);
        }
        LocalVariableAttribute va = (LocalVariableAttribute) ca.getAttribute(LocalVariableAttribute.tag);
        if (va != null) {
            va.shiftPc(where, gapLength, exclusive);
        }
        LocalVariableAttribute vta = (LocalVariableAttribute) ca.getAttribute("LocalVariableTypeTable");
        if (vta != null) {
            vta.shiftPc(where, gapLength, exclusive);
        }
        StackMapTable smt = (StackMapTable) ca.getAttribute(StackMapTable.tag);
        if (smt != null) {
            smt.shiftPc(where, gapLength, exclusive);
        }
        StackMap sm = (StackMap) ca.getAttribute(StackMap.tag);
        if (sm != null) {
            sm.shiftPc(where, gapLength, exclusive);
        }
        return newcode;
    }

    private static void insertGap2(byte[] code, int where, int gapLength, int endPos, byte[] newcode, boolean exclusive) throws BadBytecode, AlignmentException {
        int i = 0;
        int j = 0;
        while (i < endPos) {
            if (i == where) {
                int j2 = j + gapLength;
                while (j < j2) {
                    j++;
                    newcode[j] = 0;
                }
            }
            int nextPos = nextOpcode(code, i);
            int inst = code[i] & 255;
            if ((153 <= inst && inst <= 168) || inst == 198 || inst == 199) {
                int offset = newOffset(i, (code[i + 1] << 8) | (code[i + 2] & 255), where, gapLength, exclusive);
                newcode[j] = code[i];
                ByteArray.write16bit(offset, newcode, j + 1);
                j += 3;
            } else if (inst == 200 || inst == 201) {
                int offset2 = newOffset(i, ByteArray.read32bit(code, i + 1), where, gapLength, exclusive);
                int j3 = j + 1;
                newcode[j] = code[i];
                ByteArray.write32bit(offset2, newcode, j3);
                j = j3 + 4;
            } else if (inst == 170) {
                if (i == j || (gapLength & 3) == 0) {
                    int i2 = (i & -4) + 4;
                    int j4 = copyGapBytes(newcode, j, code, i, i2);
                    ByteArray.write32bit(newOffset(i, ByteArray.read32bit(code, i2), where, gapLength, exclusive), newcode, j4);
                    int lowbyte = ByteArray.read32bit(code, i2 + 4);
                    ByteArray.write32bit(lowbyte, newcode, j4 + 4);
                    int highbyte = ByteArray.read32bit(code, i2 + 8);
                    ByteArray.write32bit(highbyte, newcode, j4 + 8);
                    j = j4 + 12;
                    int i0 = i2 + 12;
                    int i22 = i0 + (((highbyte - lowbyte) + 1) * 4);
                    while (i0 < i22) {
                        ByteArray.write32bit(newOffset(i, ByteArray.read32bit(code, i0), where, gapLength, exclusive), newcode, j);
                        j += 4;
                        i0 += 4;
                    }
                } else {
                    throw new AlignmentException();
                }
            } else if (inst != 171) {
                while (i < nextPos) {
                    j++;
                    i++;
                    newcode[j] = code[i];
                }
            } else if (i == j || (gapLength & 3) == 0) {
                int i23 = (i & -4) + 4;
                int j5 = copyGapBytes(newcode, j, code, i, i23);
                ByteArray.write32bit(newOffset(i, ByteArray.read32bit(code, i23), where, gapLength, exclusive), newcode, j5);
                int npairs = ByteArray.read32bit(code, i23 + 4);
                ByteArray.write32bit(npairs, newcode, j5 + 4);
                j = j5 + 8;
                int i02 = i23 + 8;
                int i24 = i02 + (npairs * 8);
                while (i02 < i24) {
                    ByteArray.copy32bit(code, i02, newcode, j);
                    ByteArray.write32bit(newOffset(i, ByteArray.read32bit(code, i02 + 4), where, gapLength, exclusive), newcode, j + 4);
                    j += 8;
                    i02 += 8;
                }
            } else {
                throw new AlignmentException();
            }
            i = nextPos;
        }
    }

    private static int copyGapBytes(byte[] newcode, int j, byte[] code, int i, int iEnd) {
        switch (iEnd - i) {
            case 4:
                j++;
                i++;
                newcode[j] = code[i];
            case 3:
                j++;
                i++;
                newcode[j] = code[i];
            case 2:
                j++;
                i++;
                newcode[j] = code[i];
            case 1:
                j++;
                int i2 = i + 1;
                newcode[j] = code[i];
                break;
        }
        return j;
    }

    private static int newOffset(int i, int offset, int where, int gapLength, boolean exclusive) {
        int target = i + offset;
        if (i < where) {
            if (where < target || (exclusive && where == target)) {
                offset += gapLength;
            }
        } else if (i == where) {
            if (target < where) {
                offset -= gapLength;
            }
        } else if (target < where || (!exclusive && where == target)) {
            offset -= gapLength;
        }
        return offset;
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:javassist/bytecode/CodeIterator$Pointers.class */
    public static class Pointers {
        int cursor;
        int mark0;
        int mark;
        int mark2;
        ExceptionTable etable;
        LineNumberAttribute line;
        LocalVariableAttribute vars;
        LocalVariableAttribute types;
        StackMapTable stack;
        StackMap stack2;

        Pointers(int cur, int m, int m2, int m0, ExceptionTable et, CodeAttribute ca) {
            this.cursor = cur;
            this.mark = m;
            this.mark2 = m2;
            this.mark0 = m0;
            this.etable = et;
            this.line = (LineNumberAttribute) ca.getAttribute(LineNumberAttribute.tag);
            this.vars = (LocalVariableAttribute) ca.getAttribute(LocalVariableAttribute.tag);
            this.types = (LocalVariableAttribute) ca.getAttribute("LocalVariableTypeTable");
            this.stack = (StackMapTable) ca.getAttribute(StackMapTable.tag);
            this.stack2 = (StackMap) ca.getAttribute(StackMap.tag);
        }

        void shiftPc(int where, int gapLength, boolean exclusive) throws BadBytecode {
            if (where < this.cursor || (where == this.cursor && exclusive)) {
                this.cursor += gapLength;
            }
            if (where < this.mark || (where == this.mark && exclusive)) {
                this.mark += gapLength;
            }
            if (where < this.mark2 || (where == this.mark2 && exclusive)) {
                this.mark2 += gapLength;
            }
            if (where < this.mark0 || (where == this.mark0 && exclusive)) {
                this.mark0 += gapLength;
            }
            this.etable.shiftPc(where, gapLength, exclusive);
            if (this.line != null) {
                this.line.shiftPc(where, gapLength, exclusive);
            }
            if (this.vars != null) {
                this.vars.shiftPc(where, gapLength, exclusive);
            }
            if (this.types != null) {
                this.types.shiftPc(where, gapLength, exclusive);
            }
            if (this.stack != null) {
                this.stack.shiftPc(where, gapLength, exclusive);
            }
            if (this.stack2 != null) {
                this.stack2.shiftPc(where, gapLength, exclusive);
            }
        }

        void shiftForSwitch(int where, int gapLength) throws BadBytecode {
            if (this.stack != null) {
                this.stack.shiftForSwitch(where, gapLength);
            }
            if (this.stack2 != null) {
                this.stack2.shiftForSwitch(where, gapLength);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static byte[] changeLdcToLdcW(byte[] code, ExceptionTable etable, CodeAttribute ca, CodeAttribute.LdcEntry ldcs) throws BadBytecode {
        Pointers pointers = new Pointers(0, 0, 0, 0, etable, ca);
        List<Branch> jumps = makeJumpList(code, code.length, pointers);
        while (ldcs != null) {
            addLdcW(ldcs, jumps);
            ldcs = ldcs.next;
        }
        return insertGap2w(code, 0, 0, false, jumps, pointers);
    }

    private static void addLdcW(CodeAttribute.LdcEntry ldcs, List<Branch> jumps) {
        int where = ldcs.where;
        LdcW ldcw = new LdcW(where, ldcs.index);
        int s = jumps.size();
        for (int i = 0; i < s; i++) {
            if (where < jumps.get(i).orgPos) {
                jumps.add(i, ldcw);
                return;
            }
        }
        jumps.add(ldcw);
    }

    private byte[] insertGapCore0w(byte[] code, int where, int gapLength, boolean exclusive, ExceptionTable etable, CodeAttribute ca, Gap newWhere) throws BadBytecode {
        if (gapLength <= 0) {
            return code;
        }
        Pointers pointers = new Pointers(this.currentPos, this.mark, this.mark2, where, etable, ca);
        byte[] r = insertGap2w(code, where, gapLength, exclusive, makeJumpList(code, code.length, pointers), pointers);
        this.currentPos = pointers.cursor;
        this.mark = pointers.mark;
        this.mark2 = pointers.mark2;
        int where2 = pointers.mark0;
        if (where2 == this.currentPos && !exclusive) {
            this.currentPos += gapLength;
        }
        if (exclusive) {
            where2 -= gapLength;
        }
        newWhere.position = where2;
        newWhere.length = gapLength;
        return r;
    }

    private static byte[] insertGap2w(byte[] code, int where, int gapLength, boolean exclusive, List<Branch> jumps, Pointers ptrs) throws BadBytecode {
        if (gapLength > 0) {
            ptrs.shiftPc(where, gapLength, exclusive);
            for (Branch b : jumps) {
                b.shift(where, gapLength, exclusive);
            }
        }
        boolean unstable = true;
        while (true) {
            if (unstable) {
                unstable = false;
                for (Branch b2 : jumps) {
                    if (b2.expanded()) {
                        unstable = true;
                        int p = b2.pos;
                        int delta = b2.deltaSize();
                        ptrs.shiftPc(p, delta, false);
                        for (Branch bb : jumps) {
                            bb.shift(p, delta, false);
                        }
                    }
                }
            } else {
                for (Branch b3 : jumps) {
                    int diff = b3.gapChanged();
                    if (diff > 0) {
                        unstable = true;
                        int p2 = b3.pos;
                        ptrs.shiftPc(p2, diff, false);
                        for (Branch bb2 : jumps) {
                            bb2.shift(p2, diff, false);
                        }
                    }
                }
                if (!unstable) {
                    return makeExapndedCode(code, jumps, where, gapLength);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static List<Branch> makeJumpList(byte[] code, int endPos, Pointers ptrs) throws BadBytecode {
        Branch b;
        List<Branch> jumps = new ArrayList<>();
        int i = 0;
        while (i < endPos) {
            int nextPos = nextOpcode(code, i);
            int inst = code[i] & 255;
            if ((153 <= inst && inst <= 168) || inst == 198 || inst == 199) {
                int offset = (code[i + 1] << 8) | (code[i + 2] & 255);
                if (inst == 167 || inst == 168) {
                    b = new Jump16(i, offset);
                } else {
                    b = new If16(i, offset);
                }
                jumps.add(b);
            } else if (inst == 200 || inst == 201) {
                jumps.add(new Jump32(i, ByteArray.read32bit(code, i + 1)));
            } else if (inst == 170) {
                int i2 = (i & -4) + 4;
                int defaultbyte = ByteArray.read32bit(code, i2);
                int lowbyte = ByteArray.read32bit(code, i2 + 4);
                int highbyte = ByteArray.read32bit(code, i2 + 8);
                int i0 = i2 + 12;
                int size = (highbyte - lowbyte) + 1;
                int[] offsets = new int[size];
                for (int j = 0; j < size; j++) {
                    offsets[j] = ByteArray.read32bit(code, i0);
                    i0 += 4;
                }
                jumps.add(new Table(i, defaultbyte, lowbyte, highbyte, offsets, ptrs));
            } else if (inst == 171) {
                int i22 = (i & -4) + 4;
                int defaultbyte2 = ByteArray.read32bit(code, i22);
                int npairs = ByteArray.read32bit(code, i22 + 4);
                int i02 = i22 + 8;
                int[] matches = new int[npairs];
                int[] offsets2 = new int[npairs];
                for (int j2 = 0; j2 < npairs; j2++) {
                    matches[j2] = ByteArray.read32bit(code, i02);
                    offsets2[j2] = ByteArray.read32bit(code, i02 + 4);
                    i02 += 8;
                }
                jumps.add(new Lookup(i, defaultbyte2, matches, offsets2, ptrs));
            }
            i = nextPos;
        }
        return jumps;
    }

    private static byte[] makeExapndedCode(byte[] code, List<Branch> jumps, int where, int gapLength) throws BadBytecode {
        int bpos;
        Branch b;
        int n = jumps.size();
        int size = code.length + gapLength;
        for (Branch b2 : jumps) {
            size += b2.deltaSize();
        }
        byte[] newcode = new byte[size];
        int src = 0;
        int dest = 0;
        int bindex = 0;
        int len = code.length;
        if (0 < n) {
            b = jumps.get(0);
            bpos = b.orgPos;
        } else {
            b = null;
            bpos = len;
        }
        while (src < len) {
            if (src == where) {
                int pos2 = dest + gapLength;
                while (dest < pos2) {
                    dest++;
                    newcode[dest] = 0;
                }
            }
            if (src != bpos) {
                dest++;
                src++;
                newcode[dest] = code[src];
            } else {
                int s = b.write(src, code, dest, newcode);
                src += s;
                dest += s + b.deltaSize();
                bindex++;
                if (bindex < n) {
                    b = jumps.get(bindex);
                    bpos = b.orgPos;
                } else {
                    b = null;
                    bpos = len;
                }
            }
        }
        return newcode;
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:javassist/bytecode/CodeIterator$Branch.class */
    public static abstract class Branch {
        int pos;
        int orgPos;

        abstract int write(int i, byte[] bArr, int i2, byte[] bArr2) throws BadBytecode;

        Branch(int p) {
            this.orgPos = p;
            this.pos = p;
        }

        void shift(int where, int gapLength, boolean exclusive) {
            if (where < this.pos || (where == this.pos && exclusive)) {
                this.pos += gapLength;
            }
        }

        static int shiftOffset(int i, int offset, int where, int gapLength, boolean exclusive) {
            int target = i + offset;
            if (i < where) {
                if (where < target || (exclusive && where == target)) {
                    offset += gapLength;
                }
            } else if (i == where) {
                if (target < where && exclusive) {
                    offset -= gapLength;
                } else if (where < target && !exclusive) {
                    offset += gapLength;
                }
            } else if (target < where || (!exclusive && where == target)) {
                offset -= gapLength;
            }
            return offset;
        }

        boolean expanded() {
            return false;
        }

        int gapChanged() {
            return 0;
        }

        int deltaSize() {
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:javassist/bytecode/CodeIterator$LdcW.class */
    public static class LdcW extends Branch {
        int index;
        boolean state = true;

        LdcW(int p, int i) {
            super(p);
            this.index = i;
        }

        @Override // javassist.bytecode.CodeIterator.Branch
        boolean expanded() {
            if (!this.state) {
                return false;
            }
            this.state = false;
            return true;
        }

        @Override // javassist.bytecode.CodeIterator.Branch
        int deltaSize() {
            return 1;
        }

        @Override // javassist.bytecode.CodeIterator.Branch
        int write(int srcPos, byte[] code, int destPos, byte[] newcode) {
            newcode[destPos] = 19;
            ByteArray.write16bit(this.index, newcode, destPos + 1);
            return 2;
        }
    }

    /* loaded from: grasscutter.jar:javassist/bytecode/CodeIterator$Branch16.class */
    static abstract class Branch16 extends Branch {
        int offset;
        int state = 0;
        static final int BIT16 = 0;
        static final int EXPAND = 1;
        static final int BIT32 = 2;

        @Override // javassist.bytecode.CodeIterator.Branch
        abstract int deltaSize();

        abstract void write32(int i, byte[] bArr, int i2, byte[] bArr2);

        Branch16(int p, int off) {
            super(p);
            this.offset = off;
        }

        @Override // javassist.bytecode.CodeIterator.Branch
        void shift(int where, int gapLength, boolean exclusive) {
            this.offset = shiftOffset(this.pos, this.offset, where, gapLength, exclusive);
            shift(where, gapLength, exclusive);
            if (this.state != 0) {
                return;
            }
            if (this.offset < -32768 || 32767 < this.offset) {
                this.state = 1;
            }
        }

        @Override // javassist.bytecode.CodeIterator.Branch
        boolean expanded() {
            if (this.state != 1) {
                return false;
            }
            this.state = 2;
            return true;
        }

        @Override // javassist.bytecode.CodeIterator.Branch
        int write(int src, byte[] code, int dest, byte[] newcode) {
            if (this.state == 2) {
                write32(src, code, dest, newcode);
                return 3;
            }
            newcode[dest] = code[src];
            ByteArray.write16bit(this.offset, newcode, dest + 1);
            return 3;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:javassist/bytecode/CodeIterator$Jump16.class */
    public static class Jump16 extends Branch16 {
        Jump16(int p, int off) {
            super(p, off);
        }

        @Override // javassist.bytecode.CodeIterator.Branch16, javassist.bytecode.CodeIterator.Branch
        int deltaSize() {
            return this.state == 2 ? 2 : 0;
        }

        @Override // javassist.bytecode.CodeIterator.Branch16
        void write32(int src, byte[] code, int dest, byte[] newcode) {
            newcode[dest] = (byte) ((code[src] & 255) == 167 ? 200 : 201);
            ByteArray.write32bit(this.offset, newcode, dest + 1);
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:javassist/bytecode/CodeIterator$If16.class */
    public static class If16 extends Branch16 {
        If16(int p, int off) {
            super(p, off);
        }

        @Override // javassist.bytecode.CodeIterator.Branch16, javassist.bytecode.CodeIterator.Branch
        int deltaSize() {
            return this.state == 2 ? 5 : 0;
        }

        @Override // javassist.bytecode.CodeIterator.Branch16
        void write32(int src, byte[] code, int dest, byte[] newcode) {
            newcode[dest] = (byte) opcode(code[src] & 255);
            newcode[dest + 1] = 0;
            newcode[dest + 2] = 8;
            newcode[dest + 3] = -56;
            ByteArray.write32bit(this.offset - 3, newcode, dest + 4);
        }

        int opcode(int op) {
            if (op == 198) {
                return 199;
            }
            if (op == 199) {
                return 198;
            }
            if (((op - 153) & 1) == 0) {
                return op + 1;
            }
            return op - 1;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:javassist/bytecode/CodeIterator$Jump32.class */
    public static class Jump32 extends Branch {
        int offset;

        Jump32(int p, int off) {
            super(p);
            this.offset = off;
        }

        @Override // javassist.bytecode.CodeIterator.Branch
        void shift(int where, int gapLength, boolean exclusive) {
            this.offset = shiftOffset(this.pos, this.offset, where, gapLength, exclusive);
            shift(where, gapLength, exclusive);
        }

        @Override // javassist.bytecode.CodeIterator.Branch
        int write(int src, byte[] code, int dest, byte[] newcode) {
            newcode[dest] = code[src];
            ByteArray.write32bit(this.offset, newcode, dest + 1);
            return 5;
        }
    }

    /* loaded from: grasscutter.jar:javassist/bytecode/CodeIterator$Switcher.class */
    static abstract class Switcher extends Branch {
        int gap;
        int defaultByte;
        int[] offsets;
        Pointers pointers;

        abstract int write2(int i, byte[] bArr);

        abstract int tableSize();

        Switcher(int pos, int defaultByte, int[] offsets, Pointers ptrs) {
            super(pos);
            this.gap = 3 - (pos & 3);
            this.defaultByte = defaultByte;
            this.offsets = offsets;
            this.pointers = ptrs;
        }

        @Override // javassist.bytecode.CodeIterator.Branch
        void shift(int where, int gapLength, boolean exclusive) {
            int p = this.pos;
            this.defaultByte = shiftOffset(p, this.defaultByte, where, gapLength, exclusive);
            int num = this.offsets.length;
            for (int i = 0; i < num; i++) {
                this.offsets[i] = shiftOffset(p, this.offsets[i], where, gapLength, exclusive);
            }
            shift(where, gapLength, exclusive);
        }

        @Override // javassist.bytecode.CodeIterator.Branch
        int gapChanged() {
            int newGap = 3 - (this.pos & 3);
            if (newGap <= this.gap) {
                return 0;
            }
            int diff = newGap - this.gap;
            this.gap = newGap;
            return diff;
        }

        @Override // javassist.bytecode.CodeIterator.Branch
        int deltaSize() {
            return this.gap - (3 - (this.orgPos & 3));
        }

        @Override // javassist.bytecode.CodeIterator.Branch
        int write(int src, byte[] code, int dest, byte[] newcode) throws BadBytecode {
            int padding = 3 - (this.pos & 3);
            int nops = this.gap - padding;
            int bytecodeSize = 5 + (3 - (this.orgPos & 3)) + tableSize();
            if (nops > 0) {
                adjustOffsets(bytecodeSize, nops);
            }
            int dest2 = dest + 1;
            newcode[dest] = code[src];
            while (true) {
                padding--;
                if (padding <= 0) {
                    break;
                }
                dest2++;
                newcode[dest2] = 0;
            }
            ByteArray.write32bit(this.defaultByte, newcode, dest2);
            int size = write2(dest2 + 4, newcode);
            int dest3 = dest2 + size + 4;
            while (true) {
                nops--;
                if (nops <= 0) {
                    return 5 + (3 - (this.orgPos & 3)) + size;
                }
                dest3++;
                newcode[dest3] = 0;
            }
        }

        void adjustOffsets(int size, int nops) throws BadBytecode {
            this.pointers.shiftForSwitch(this.pos + size, nops);
            if (this.defaultByte == size) {
                this.defaultByte -= nops;
            }
            for (int i = 0; i < this.offsets.length; i++) {
                if (this.offsets[i] == size) {
                    int[] iArr = this.offsets;
                    iArr[i] = iArr[i] - nops;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:javassist/bytecode/CodeIterator$Table.class */
    public static class Table extends Switcher {
        int low;
        int high;

        Table(int pos, int defaultByte, int low, int high, int[] offsets, Pointers ptrs) {
            super(pos, defaultByte, offsets, ptrs);
            this.low = low;
            this.high = high;
        }

        @Override // javassist.bytecode.CodeIterator.Switcher
        int write2(int dest, byte[] newcode) {
            ByteArray.write32bit(this.low, newcode, dest);
            ByteArray.write32bit(this.high, newcode, dest + 4);
            int n = this.offsets.length;
            int dest2 = dest + 8;
            for (int i = 0; i < n; i++) {
                ByteArray.write32bit(this.offsets[i], newcode, dest2);
                dest2 += 4;
            }
            return 8 + (4 * n);
        }

        @Override // javassist.bytecode.CodeIterator.Switcher
        int tableSize() {
            return 8 + (4 * this.offsets.length);
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:javassist/bytecode/CodeIterator$Lookup.class */
    public static class Lookup extends Switcher {
        int[] matches;

        Lookup(int pos, int defaultByte, int[] matches, int[] offsets, Pointers ptrs) {
            super(pos, defaultByte, offsets, ptrs);
            this.matches = matches;
        }

        @Override // javassist.bytecode.CodeIterator.Switcher
        int write2(int dest, byte[] newcode) {
            int n = this.matches.length;
            ByteArray.write32bit(n, newcode, dest);
            int dest2 = dest + 4;
            for (int i = 0; i < n; i++) {
                ByteArray.write32bit(this.matches[i], newcode, dest2);
                ByteArray.write32bit(this.offsets[i], newcode, dest2 + 4);
                dest2 += 8;
            }
            return 4 + (8 * n);
        }

        @Override // javassist.bytecode.CodeIterator.Switcher
        int tableSize() {
            return 4 + (8 * this.matches.length);
        }
    }
}
