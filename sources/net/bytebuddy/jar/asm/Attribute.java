package net.bytebuddy.jar.asm;

import javassist.bytecode.DeprecatedAttribute;
import javassist.bytecode.SignatureAttribute;
import javassist.bytecode.SyntheticAttribute;

/* loaded from: grasscutter.jar:net/bytebuddy/jar/asm/Attribute.class */
public class Attribute {
    public final String type;
    private byte[] content;
    Attribute nextAttribute;

    /* access modifiers changed from: protected */
    public Attribute(String type) {
        this.type = type;
    }

    public boolean isUnknown() {
        return true;
    }

    public boolean isCodeAttribute() {
        return false;
    }

    protected Label[] getLabels() {
        return new Label[0];
    }

    /* access modifiers changed from: protected */
    public Attribute read(ClassReader classReader, int offset, int length, char[] charBuffer, int codeAttributeOffset, Label[] labels) {
        Attribute attribute = new Attribute(this.type);
        attribute.content = new byte[length];
        System.arraycopy(classReader.classFileBuffer, offset, attribute.content, 0, length);
        return attribute;
    }

    protected ByteVector write(ClassWriter classWriter, byte[] code, int codeLength, int maxStack, int maxLocals) {
        return new ByteVector(this.content);
    }

    /* access modifiers changed from: package-private */
    public final int getAttributeCount() {
        int count = 0;
        for (Attribute attribute = this; attribute != null; attribute = attribute.nextAttribute) {
            count++;
        }
        return count;
    }

    /* access modifiers changed from: package-private */
    public final int computeAttributesSize(SymbolTable symbolTable) {
        return computeAttributesSize(symbolTable, null, 0, -1, -1);
    }

    /* access modifiers changed from: package-private */
    public final int computeAttributesSize(SymbolTable symbolTable, byte[] code, int codeLength, int maxStack, int maxLocals) {
        ClassWriter classWriter = symbolTable.classWriter;
        int size = 0;
        for (Attribute attribute = this; attribute != null; attribute = attribute.nextAttribute) {
            symbolTable.addConstantUtf8(attribute.type);
            size += 6 + attribute.write(classWriter, code, codeLength, maxStack, maxLocals).length;
        }
        return size;
    }

    /* access modifiers changed from: package-private */
    public static int computeAttributesSize(SymbolTable symbolTable, int accessFlags, int signatureIndex) {
        int size = 0;
        if ((accessFlags & 4096) != 0 && symbolTable.getMajorVersion() < 49) {
            symbolTable.addConstantUtf8(SyntheticAttribute.tag);
            size = 0 + 6;
        }
        if (signatureIndex != 0) {
            symbolTable.addConstantUtf8(SignatureAttribute.tag);
            size += 8;
        }
        if ((accessFlags & 131072) != 0) {
            symbolTable.addConstantUtf8(DeprecatedAttribute.tag);
            size += 6;
        }
        return size;
    }

    /* access modifiers changed from: package-private */
    public final void putAttributes(SymbolTable symbolTable, ByteVector output) {
        putAttributes(symbolTable, null, 0, -1, -1, output);
    }

    /* access modifiers changed from: package-private */
    public final void putAttributes(SymbolTable symbolTable, byte[] code, int codeLength, int maxStack, int maxLocals, ByteVector output) {
        ClassWriter classWriter = symbolTable.classWriter;
        for (Attribute attribute = this; attribute != null; attribute = attribute.nextAttribute) {
            ByteVector attributeContent = attribute.write(classWriter, code, codeLength, maxStack, maxLocals);
            output.putShort(symbolTable.addConstantUtf8(attribute.type)).putInt(attributeContent.length);
            output.putByteArray(attributeContent.data, 0, attributeContent.length);
        }
    }

    /* access modifiers changed from: package-private */
    public static void putAttributes(SymbolTable symbolTable, int accessFlags, int signatureIndex, ByteVector output) {
        if ((accessFlags & 4096) != 0 && symbolTable.getMajorVersion() < 49) {
            output.putShort(symbolTable.addConstantUtf8(SyntheticAttribute.tag)).putInt(0);
        }
        if (signatureIndex != 0) {
            output.putShort(symbolTable.addConstantUtf8(SignatureAttribute.tag)).putInt(2).putShort(signatureIndex);
        }
        if ((accessFlags & 131072) != 0) {
            output.putShort(symbolTable.addConstantUtf8(DeprecatedAttribute.tag)).putInt(0);
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/jar/asm/Attribute$Set.class */
    static final class Set {
        private static final int SIZE_INCREMENT = 6;
        private int size;
        private Attribute[] data = new Attribute[6];

        /* access modifiers changed from: package-private */
        public void addAttributes(Attribute attributeList) {
            for (Attribute attribute = attributeList; attribute != null; attribute = attribute.nextAttribute) {
                if (!contains(attribute)) {
                    add(attribute);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public Attribute[] toArray() {
            Attribute[] result = new Attribute[this.size];
            System.arraycopy(this.data, 0, result, 0, this.size);
            return result;
        }

        private boolean contains(Attribute attribute) {
            for (int i = 0; i < this.size; i++) {
                if (this.data[i].type.equals(attribute.type)) {
                    return true;
                }
            }
            return false;
        }

        private void add(Attribute attribute) {
            if (this.size >= this.data.length) {
                Attribute[] newData = new Attribute[this.data.length + 6];
                System.arraycopy(this.data, 0, newData, 0, this.size);
                this.data = newData;
            }
            Attribute[] attributeArr = this.data;
            int i = this.size;
            this.size = i + 1;
            attributeArr[i] = attribute;
        }
    }
}
