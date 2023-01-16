package javassist.bytecode;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Map;
import javassist.CannotCompileException;

/* loaded from: grasscutter.jar:javassist/bytecode/StackMapTable.class */
public class StackMapTable extends AttributeInfo {
    public static final String tag = "StackMapTable";
    public static final int TOP = 0;
    public static final int INTEGER = 1;
    public static final int FLOAT = 2;
    public static final int DOUBLE = 3;
    public static final int LONG = 4;
    public static final int NULL = 5;
    public static final int THIS = 6;
    public static final int OBJECT = 7;
    public static final int UNINIT = 8;

    StackMapTable(ConstPool cp, byte[] newInfo) {
        super(cp, tag, newInfo);
    }

    /* access modifiers changed from: package-private */
    public StackMapTable(ConstPool cp, int name_id, DataInputStream in) throws IOException {
        super(cp, name_id, in);
    }

    @Override // javassist.bytecode.AttributeInfo
    public AttributeInfo copy(ConstPool newCp, Map<String, String> classnames) throws RuntimeCopyException {
        try {
            return new StackMapTable(newCp, new Copier(this.constPool, this.info, newCp, classnames).doit());
        } catch (BadBytecode e) {
            throw new RuntimeCopyException("bad bytecode. fatal?");
        }
    }

    /* loaded from: grasscutter.jar:javassist/bytecode/StackMapTable$RuntimeCopyException.class */
    public static class RuntimeCopyException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public RuntimeCopyException(String s) {
            super(s);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // javassist.bytecode.AttributeInfo
    public void write(DataOutputStream out) throws IOException {
        write(out);
    }

    /* loaded from: grasscutter.jar:javassist/bytecode/StackMapTable$Walker.class */
    public static class Walker {
        byte[] info;
        int numOfEntries;

        public Walker(StackMapTable smt) {
            this(smt.get());
        }

        public Walker(byte[] data) {
            this.info = data;
            this.numOfEntries = ByteArray.readU16bit(data, 0);
        }

        public final int size() {
            return this.numOfEntries;
        }

        public void parse() throws BadBytecode {
            int n = this.numOfEntries;
            int pos = 2;
            for (int i = 0; i < n; i++) {
                pos = stackMapFrames(pos, i);
            }
        }

        int stackMapFrames(int pos, int nth) throws BadBytecode {
            int pos2;
            int type = this.info[pos] & 255;
            if (type < 64) {
                sameFrame(pos, type);
                pos2 = pos + 1;
            } else if (type < 128) {
                pos2 = sameLocals(pos, type);
            } else if (type < 247) {
                throw new BadBytecode("bad frame_type " + type + " in StackMapTable (pos: " + pos + ", frame no.:" + nth + ")");
            } else if (type == 247) {
                pos2 = sameLocals(pos, type);
            } else if (type < 251) {
                chopFrame(pos, ByteArray.readU16bit(this.info, pos + 1), PacketOpcodes.EnterSceneReadyRsp - type);
                pos2 = pos + 3;
            } else if (type == 251) {
                sameFrame(pos, ByteArray.readU16bit(this.info, pos + 1));
                pos2 = pos + 3;
            } else if (type < 255) {
                pos2 = appendFrame(pos, type);
            } else {
                pos2 = fullFrame(pos);
            }
            return pos2;
        }

        public void sameFrame(int pos, int offsetDelta) throws BadBytecode {
        }

        private int sameLocals(int pos, int type) throws BadBytecode {
            int offset;
            if (type < 128) {
                offset = type - 64;
            } else {
                offset = ByteArray.readU16bit(this.info, pos + 1);
                pos += 2;
            }
            int tag = this.info[pos + 1] & 255;
            int data = 0;
            if (tag == 7 || tag == 8) {
                data = ByteArray.readU16bit(this.info, pos + 2);
                objectOrUninitialized(tag, data, pos + 2);
                pos += 2;
            }
            sameLocals(pos, offset, tag, data);
            return pos + 2;
        }

        public void sameLocals(int pos, int offsetDelta, int stackTag, int stackData) throws BadBytecode {
        }

        public void chopFrame(int pos, int offsetDelta, int k) throws BadBytecode {
        }

        private int appendFrame(int pos, int type) throws BadBytecode {
            int k = type - PacketOpcodes.EnterSceneReadyRsp;
            int offset = ByteArray.readU16bit(this.info, pos + 1);
            int[] tags = new int[k];
            int[] data = new int[k];
            int p = pos + 3;
            for (int i = 0; i < k; i++) {
                int tag = this.info[p] & 255;
                tags[i] = tag;
                if (tag == 7 || tag == 8) {
                    data[i] = ByteArray.readU16bit(this.info, p + 1);
                    objectOrUninitialized(tag, data[i], p + 1);
                    p += 3;
                } else {
                    data[i] = 0;
                    p++;
                }
            }
            appendFrame(pos, offset, tags, data);
            return p;
        }

        public void appendFrame(int pos, int offsetDelta, int[] tags, int[] data) throws BadBytecode {
        }

        private int fullFrame(int pos) throws BadBytecode {
            int offset = ByteArray.readU16bit(this.info, pos + 1);
            int numOfLocals = ByteArray.readU16bit(this.info, pos + 3);
            int[] localsTags = new int[numOfLocals];
            int[] localsData = new int[numOfLocals];
            int p = verifyTypeInfo(pos + 5, numOfLocals, localsTags, localsData);
            int numOfItems = ByteArray.readU16bit(this.info, p);
            int[] itemsTags = new int[numOfItems];
            int[] itemsData = new int[numOfItems];
            int p2 = verifyTypeInfo(p + 2, numOfItems, itemsTags, itemsData);
            fullFrame(pos, offset, localsTags, localsData, itemsTags, itemsData);
            return p2;
        }

        public void fullFrame(int pos, int offsetDelta, int[] localTags, int[] localData, int[] stackTags, int[] stackData) throws BadBytecode {
        }

        private int verifyTypeInfo(int pos, int n, int[] tags, int[] data) {
            for (int i = 0; i < n; i++) {
                pos++;
                int tag = this.info[pos] & 255;
                tags[i] = tag;
                if (tag == 7 || tag == 8) {
                    data[i] = ByteArray.readU16bit(this.info, pos);
                    objectOrUninitialized(tag, data[i], pos);
                    pos += 2;
                }
            }
            return pos;
        }

        public void objectOrUninitialized(int tag, int data, int pos) {
        }
    }

    /* loaded from: grasscutter.jar:javassist/bytecode/StackMapTable$SimpleCopy.class */
    static class SimpleCopy extends Walker {
        private Writer writer;

        public SimpleCopy(byte[] data) {
            super(data);
            this.writer = new Writer(data.length);
        }

        public byte[] doit() throws BadBytecode {
            parse();
            return this.writer.toByteArray();
        }

        @Override // javassist.bytecode.StackMapTable.Walker
        public void sameFrame(int pos, int offsetDelta) {
            this.writer.sameFrame(offsetDelta);
        }

        @Override // javassist.bytecode.StackMapTable.Walker
        public void sameLocals(int pos, int offsetDelta, int stackTag, int stackData) {
            this.writer.sameLocals(offsetDelta, stackTag, copyData(stackTag, stackData));
        }

        @Override // javassist.bytecode.StackMapTable.Walker
        public void chopFrame(int pos, int offsetDelta, int k) {
            this.writer.chopFrame(offsetDelta, k);
        }

        @Override // javassist.bytecode.StackMapTable.Walker
        public void appendFrame(int pos, int offsetDelta, int[] tags, int[] data) {
            this.writer.appendFrame(offsetDelta, tags, copyData(tags, data));
        }

        @Override // javassist.bytecode.StackMapTable.Walker
        public void fullFrame(int pos, int offsetDelta, int[] localTags, int[] localData, int[] stackTags, int[] stackData) {
            this.writer.fullFrame(offsetDelta, localTags, copyData(localTags, localData), stackTags, copyData(stackTags, stackData));
        }

        protected int copyData(int tag, int data) {
            return data;
        }

        protected int[] copyData(int[] tags, int[] data) {
            return data;
        }
    }

    /* loaded from: grasscutter.jar:javassist/bytecode/StackMapTable$Copier.class */
    static class Copier extends SimpleCopy {
        private ConstPool srcPool;
        private ConstPool destPool;
        private Map<String, String> classnames;

        public Copier(ConstPool src, byte[] data, ConstPool dest, Map<String, String> names) {
            super(data);
            this.srcPool = src;
            this.destPool = dest;
            this.classnames = names;
        }

        @Override // javassist.bytecode.StackMapTable.SimpleCopy
        protected int copyData(int tag, int data) {
            if (tag == 7) {
                return this.srcPool.copy(data, this.destPool, this.classnames);
            }
            return data;
        }

        @Override // javassist.bytecode.StackMapTable.SimpleCopy
        protected int[] copyData(int[] tags, int[] data) {
            int[] newData = new int[data.length];
            for (int i = 0; i < data.length; i++) {
                if (tags[i] == 7) {
                    newData[i] = this.srcPool.copy(data[i], this.destPool, this.classnames);
                } else {
                    newData[i] = data[i];
                }
            }
            return newData;
        }
    }

    public void insertLocal(int index, int tag2, int classInfo) throws BadBytecode {
        set(new InsertLocal(get(), index, tag2, classInfo).doit());
    }

    public static int typeTagOf(char descriptor) {
        switch (descriptor) {
            case 'D':
                return 3;
            case 'F':
                return 2;
            case 'J':
                return 4;
            case 'L':
            case '[':
                return 7;
            default:
                return 1;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:javassist/bytecode/StackMapTable$InsertLocal.class */
    public static class InsertLocal extends SimpleCopy {
        private int varIndex;
        private int varTag;
        private int varData;

        public InsertLocal(byte[] data, int varIndex, int varTag, int varData) {
            super(data);
            this.varIndex = varIndex;
            this.varTag = varTag;
            this.varData = varData;
        }

        @Override // javassist.bytecode.StackMapTable.SimpleCopy, javassist.bytecode.StackMapTable.Walker
        public void fullFrame(int pos, int offsetDelta, int[] localTags, int[] localData, int[] stackTags, int[] stackData) {
            int len = localTags.length;
            if (len < this.varIndex) {
                fullFrame(pos, offsetDelta, localTags, localData, stackTags, stackData);
                return;
            }
            int typeSize = (this.varTag == 4 || this.varTag == 3) ? 2 : 1;
            int[] localTags2 = new int[len + typeSize];
            int[] localData2 = new int[len + typeSize];
            int index = this.varIndex;
            int j = 0;
            for (int i = 0; i < len; i++) {
                if (j == index) {
                    j += typeSize;
                }
                localTags2[j] = localTags[i];
                j++;
                localData2[j] = localData[i];
            }
            localTags2[index] = this.varTag;
            localData2[index] = this.varData;
            if (typeSize > 1) {
                localTags2[index + 1] = 0;
                localData2[index + 1] = 0;
            }
            fullFrame(pos, offsetDelta, localTags2, localData2, stackTags, stackData);
        }
    }

    /* loaded from: grasscutter.jar:javassist/bytecode/StackMapTable$Writer.class */
    public static class Writer {
        ByteArrayOutputStream output;
        int numOfEntries = 0;

        public Writer(int size) {
            this.output = new ByteArrayOutputStream(size);
            this.output.write(0);
            this.output.write(0);
        }

        public byte[] toByteArray() {
            byte[] b = this.output.toByteArray();
            ByteArray.write16bit(this.numOfEntries, b, 0);
            return b;
        }

        public StackMapTable toStackMapTable(ConstPool cp) {
            return new StackMapTable(cp, toByteArray());
        }

        public void sameFrame(int offsetDelta) {
            this.numOfEntries++;
            if (offsetDelta < 64) {
                this.output.write(offsetDelta);
                return;
            }
            this.output.write(PacketOpcodes.EnterSceneReadyRsp);
            write16(offsetDelta);
        }

        public void sameLocals(int offsetDelta, int tag, int data) {
            this.numOfEntries++;
            if (offsetDelta < 64) {
                this.output.write(offsetDelta + 64);
            } else {
                this.output.write(247);
                write16(offsetDelta);
            }
            writeTypeInfo(tag, data);
        }

        public void chopFrame(int offsetDelta, int k) {
            this.numOfEntries++;
            this.output.write(PacketOpcodes.EnterSceneReadyRsp - k);
            write16(offsetDelta);
        }

        public void appendFrame(int offsetDelta, int[] tags, int[] data) {
            this.numOfEntries++;
            int k = tags.length;
            this.output.write(k + PacketOpcodes.EnterSceneReadyRsp);
            write16(offsetDelta);
            for (int i = 0; i < k; i++) {
                writeTypeInfo(tags[i], data[i]);
            }
        }

        public void fullFrame(int offsetDelta, int[] localTags, int[] localData, int[] stackTags, int[] stackData) {
            this.numOfEntries++;
            this.output.write(255);
            write16(offsetDelta);
            int n = localTags.length;
            write16(n);
            for (int i = 0; i < n; i++) {
                writeTypeInfo(localTags[i], localData[i]);
            }
            int n2 = stackTags.length;
            write16(n2);
            for (int i2 = 0; i2 < n2; i2++) {
                writeTypeInfo(stackTags[i2], stackData[i2]);
            }
        }

        private void writeTypeInfo(int tag, int data) {
            this.output.write(tag);
            if (tag == 7 || tag == 8) {
                write16(data);
            }
        }

        private void write16(int value) {
            this.output.write((value >>> 8) & 255);
            this.output.write(value & 255);
        }
    }

    public void println(PrintWriter w) {
        Printer.print(this, w);
    }

    public void println(PrintStream ps) {
        Printer.print(this, new PrintWriter((OutputStream) ps, true));
    }

    /* loaded from: grasscutter.jar:javassist/bytecode/StackMapTable$Printer.class */
    static class Printer extends Walker {
        private PrintWriter writer;
        private int offset = -1;

        public static void print(StackMapTable smt, PrintWriter writer) {
            try {
                new Printer(smt.get(), writer).parse();
            } catch (BadBytecode e) {
                writer.println(e.getMessage());
            }
        }

        Printer(byte[] data, PrintWriter pw) {
            super(data);
            this.writer = pw;
        }

        @Override // javassist.bytecode.StackMapTable.Walker
        public void sameFrame(int pos, int offsetDelta) {
            this.offset += offsetDelta + 1;
            this.writer.println(this.offset + " same frame: " + offsetDelta);
        }

        @Override // javassist.bytecode.StackMapTable.Walker
        public void sameLocals(int pos, int offsetDelta, int stackTag, int stackData) {
            this.offset += offsetDelta + 1;
            this.writer.println(this.offset + " same locals: " + offsetDelta);
            printTypeInfo(stackTag, stackData);
        }

        @Override // javassist.bytecode.StackMapTable.Walker
        public void chopFrame(int pos, int offsetDelta, int k) {
            this.offset += offsetDelta + 1;
            this.writer.println(this.offset + " chop frame: " + offsetDelta + ",    " + k + " last locals");
        }

        @Override // javassist.bytecode.StackMapTable.Walker
        public void appendFrame(int pos, int offsetDelta, int[] tags, int[] data) {
            this.offset += offsetDelta + 1;
            this.writer.println(this.offset + " append frame: " + offsetDelta);
            for (int i = 0; i < tags.length; i++) {
                printTypeInfo(tags[i], data[i]);
            }
        }

        @Override // javassist.bytecode.StackMapTable.Walker
        public void fullFrame(int pos, int offsetDelta, int[] localTags, int[] localData, int[] stackTags, int[] stackData) {
            this.offset += offsetDelta + 1;
            this.writer.println(this.offset + " full frame: " + offsetDelta);
            this.writer.println("[locals]");
            for (int i = 0; i < localTags.length; i++) {
                printTypeInfo(localTags[i], localData[i]);
            }
            this.writer.println("[stack]");
            for (int i2 = 0; i2 < stackTags.length; i2++) {
                printTypeInfo(stackTags[i2], stackData[i2]);
            }
        }

        private void printTypeInfo(int tag, int data) {
            String msg = null;
            switch (tag) {
                case 0:
                    msg = "top";
                    break;
                case 1:
                    msg = "integer";
                    break;
                case 2:
                    msg = "float";
                    break;
                case 3:
                    msg = "double";
                    break;
                case 4:
                    msg = "long";
                    break;
                case 5:
                    msg = "null";
                    break;
                case 6:
                    msg = "this";
                    break;
                case 7:
                    msg = "object (cpool_index " + data + ")";
                    break;
                case 8:
                    msg = "uninitialized (offset " + data + ")";
                    break;
            }
            this.writer.print("    ");
            this.writer.println(msg);
        }
    }

    /* access modifiers changed from: package-private */
    public void shiftPc(int where, int gapSize, boolean exclusive) throws BadBytecode {
        new OffsetShifter(this, where, gapSize).parse();
        new Shifter(this, where, gapSize, exclusive).doit();
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:javassist/bytecode/StackMapTable$OffsetShifter.class */
    public static class OffsetShifter extends Walker {
        int where;
        int gap;

        public OffsetShifter(StackMapTable smt, int where, int gap) {
            super(smt);
            this.where = where;
            this.gap = gap;
        }

        @Override // javassist.bytecode.StackMapTable.Walker
        public void objectOrUninitialized(int tag, int data, int pos) {
            if (tag == 8 && this.where <= data) {
                ByteArray.write16bit(data + this.gap, this.info, pos);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:javassist/bytecode/StackMapTable$Shifter.class */
    public static class Shifter extends Walker {
        private StackMapTable stackMap;
        int where;
        int gap;
        int position = 0;
        byte[] updatedInfo = null;
        boolean exclusive;

        public Shifter(StackMapTable smt, int where, int gap, boolean exclusive) {
            super(smt);
            this.stackMap = smt;
            this.where = where;
            this.gap = gap;
            this.exclusive = exclusive;
        }

        public void doit() throws BadBytecode {
            parse();
            if (this.updatedInfo != null) {
                this.stackMap.set(this.updatedInfo);
            }
        }

        @Override // javassist.bytecode.StackMapTable.Walker
        public void sameFrame(int pos, int offsetDelta) {
            update(pos, offsetDelta, 0, PacketOpcodes.EnterSceneReadyRsp);
        }

        @Override // javassist.bytecode.StackMapTable.Walker
        public void sameLocals(int pos, int offsetDelta, int stackTag, int stackData) {
            update(pos, offsetDelta, 64, 247);
        }

        void update(int pos, int offsetDelta, int base, int entry) {
            boolean match;
            int oldPos = this.position;
            this.position = oldPos + offsetDelta + (oldPos == 0 ? 0 : 1);
            if (this.exclusive) {
                match = (oldPos == 0 && this.where == 0) || (oldPos < this.where && this.where <= this.position);
            } else {
                match = oldPos <= this.where && this.where < this.position;
            }
            if (match) {
                int current = this.info[pos] & 255;
                int newDelta = offsetDelta + this.gap;
                this.position += this.gap;
                if (newDelta < 64) {
                    this.info[pos] = (byte) (newDelta + base);
                } else if (offsetDelta >= 64 || current == entry) {
                    ByteArray.write16bit(newDelta, this.info, pos + 1);
                } else {
                    byte[] newinfo = insertGap(this.info, pos, 2);
                    newinfo[pos] = (byte) entry;
                    ByteArray.write16bit(newDelta, newinfo, pos + 1);
                    this.updatedInfo = newinfo;
                }
            }
        }

        static byte[] insertGap(byte[] info, int where, int gap) {
            int len = info.length;
            byte[] newinfo = new byte[len + gap];
            int i = 0;
            while (i < len) {
                newinfo[i + (i < where ? 0 : gap)] = info[i];
                i++;
            }
            return newinfo;
        }

        @Override // javassist.bytecode.StackMapTable.Walker
        public void chopFrame(int pos, int offsetDelta, int k) {
            update(pos, offsetDelta);
        }

        @Override // javassist.bytecode.StackMapTable.Walker
        public void appendFrame(int pos, int offsetDelta, int[] tags, int[] data) {
            update(pos, offsetDelta);
        }

        @Override // javassist.bytecode.StackMapTable.Walker
        public void fullFrame(int pos, int offsetDelta, int[] localTags, int[] localData, int[] stackTags, int[] stackData) {
            update(pos, offsetDelta);
        }

        void update(int pos, int offsetDelta) {
            boolean match;
            int oldPos = this.position;
            this.position = oldPos + offsetDelta + (oldPos == 0 ? 0 : 1);
            if (this.exclusive) {
                match = (oldPos == 0 && this.where == 0) || (oldPos < this.where && this.where <= this.position);
            } else {
                match = oldPos <= this.where && this.where < this.position;
            }
            if (match) {
                ByteArray.write16bit(offsetDelta + this.gap, this.info, pos + 1);
                this.position += this.gap;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void shiftForSwitch(int where, int gapSize) throws BadBytecode {
        new SwitchShifter(this, where, gapSize).doit();
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:javassist/bytecode/StackMapTable$SwitchShifter.class */
    public static class SwitchShifter extends Shifter {
        SwitchShifter(StackMapTable smt, int where, int gap) {
            super(smt, where, gap, false);
        }

        @Override // javassist.bytecode.StackMapTable.Shifter
        void update(int pos, int offsetDelta, int base, int entry) {
            int newDelta;
            int oldPos = this.position;
            this.position = oldPos + offsetDelta + (oldPos == 0 ? 0 : 1);
            if (this.where == this.position) {
                newDelta = offsetDelta - this.gap;
            } else if (this.where == oldPos) {
                newDelta = offsetDelta + this.gap;
            } else {
                return;
            }
            if (offsetDelta < 64) {
                if (newDelta < 64) {
                    this.info[pos] = (byte) (newDelta + base);
                    return;
                }
                byte[] newinfo = insertGap(this.info, pos, 2);
                newinfo[pos] = (byte) entry;
                ByteArray.write16bit(newDelta, newinfo, pos + 1);
                this.updatedInfo = newinfo;
            } else if (newDelta < 64) {
                byte[] newinfo2 = deleteGap(this.info, pos, 2);
                newinfo2[pos] = (byte) (newDelta + base);
                this.updatedInfo = newinfo2;
            } else {
                ByteArray.write16bit(newDelta, this.info, pos + 1);
            }
        }

        static byte[] deleteGap(byte[] info, int where, int gap) {
            int where2 = where + gap;
            int len = info.length;
            byte[] newinfo = new byte[len - gap];
            int i = 0;
            while (i < len) {
                newinfo[i - (i < where2 ? 0 : gap)] = info[i];
                i++;
            }
            return newinfo;
        }

        @Override // javassist.bytecode.StackMapTable.Shifter
        void update(int pos, int offsetDelta) {
            int newDelta;
            int oldPos = this.position;
            this.position = oldPos + offsetDelta + (oldPos == 0 ? 0 : 1);
            if (this.where == this.position) {
                newDelta = offsetDelta - this.gap;
            } else if (this.where == oldPos) {
                newDelta = offsetDelta + this.gap;
            } else {
                return;
            }
            ByteArray.write16bit(newDelta, this.info, pos + 1);
        }
    }

    public void removeNew(int where) throws CannotCompileException {
        try {
            set(new NewRemover(get(), where).doit());
        } catch (BadBytecode e) {
            throw new CannotCompileException("bad stack map table", e);
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:javassist/bytecode/StackMapTable$NewRemover.class */
    public static class NewRemover extends SimpleCopy {
        int posOfNew;

        public NewRemover(byte[] data, int pos) {
            super(data);
            this.posOfNew = pos;
        }

        @Override // javassist.bytecode.StackMapTable.SimpleCopy, javassist.bytecode.StackMapTable.Walker
        public void sameLocals(int pos, int offsetDelta, int stackTag, int stackData) {
            if (stackTag == 8 && stackData == this.posOfNew) {
                sameFrame(pos, offsetDelta);
            } else {
                sameLocals(pos, offsetDelta, stackTag, stackData);
            }
        }

        @Override // javassist.bytecode.StackMapTable.SimpleCopy, javassist.bytecode.StackMapTable.Walker
        public void fullFrame(int pos, int offsetDelta, int[] localTags, int[] localData, int[] stackTags, int[] stackData) {
            int n = stackTags.length - 1;
            int i = 0;
            while (true) {
                if (i >= n) {
                    break;
                } else if (stackTags[i] == 8 && stackData[i] == this.posOfNew && stackTags[i + 1] == 8 && stackData[i + 1] == this.posOfNew) {
                    int n2 = n + 1;
                    int[] stackTags2 = new int[n2 - 2];
                    int[] stackData2 = new int[n2 - 2];
                    int k = 0;
                    int j = 0;
                    while (j < n2) {
                        if (j == i) {
                            j++;
                        } else {
                            stackTags2[k] = stackTags[j];
                            k++;
                            stackData2[k] = stackData[j];
                        }
                        j++;
                    }
                    stackTags = stackTags2;
                    stackData = stackData2;
                } else {
                    i++;
                }
            }
            fullFrame(pos, offsetDelta, localTags, localData, stackTags, stackData);
        }
    }
}
