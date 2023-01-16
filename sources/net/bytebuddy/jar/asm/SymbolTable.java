package net.bytebuddy.jar.asm;

import javassist.bytecode.BootstrapMethodsAttribute;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:net/bytebuddy/jar/asm/SymbolTable.class */
public final class SymbolTable {
    final ClassWriter classWriter;
    private final ClassReader sourceClassReader;
    private int majorVersion;
    private String className;
    private int entryCount;
    private Entry[] entries;
    private int constantPoolCount;
    private ByteVector constantPool;
    private int bootstrapMethodCount;
    private ByteVector bootstrapMethods;
    private int typeCount;
    private Entry[] typeTable;

    /* access modifiers changed from: package-private */
    public SymbolTable(ClassWriter classWriter) {
        this.classWriter = classWriter;
        this.sourceClassReader = null;
        this.entries = new Entry[256];
        this.constantPoolCount = 1;
        this.constantPool = new ByteVector();
    }

    /* access modifiers changed from: package-private */
    public SymbolTable(ClassWriter classWriter, ClassReader classReader) {
        this.classWriter = classWriter;
        this.sourceClassReader = classReader;
        byte[] inputBytes = classReader.classFileBuffer;
        int constantPoolOffset = classReader.getItem(1) - 1;
        int constantPoolLength = classReader.header - constantPoolOffset;
        this.constantPoolCount = classReader.getItemCount();
        this.constantPool = new ByteVector(constantPoolLength);
        this.constantPool.putByteArray(inputBytes, constantPoolOffset, constantPoolLength);
        this.entries = new Entry[this.constantPoolCount * 2];
        char[] charBuffer = new char[classReader.getMaxStringLength()];
        boolean hasBootstrapMethods = false;
        int itemIndex = 1;
        while (itemIndex < this.constantPoolCount) {
            int itemOffset = classReader.getItem(itemIndex);
            byte b = inputBytes[itemOffset - 1];
            switch (b) {
                case 1:
                    addConstantUtf8(itemIndex, classReader.readUtf(itemIndex, charBuffer));
                    break;
                case 2:
                case 13:
                case 14:
                default:
                    throw new IllegalArgumentException();
                case 3:
                case 4:
                    addConstantIntegerOrFloat(itemIndex, b, classReader.readInt(itemOffset));
                    break;
                case 5:
                case 6:
                    addConstantLongOrDouble(itemIndex, b, classReader.readLong(itemOffset));
                    break;
                case 7:
                case 8:
                case 16:
                case 19:
                case 20:
                    addConstantUtf8Reference(itemIndex, b, classReader.readUTF8(itemOffset, charBuffer));
                    break;
                case 9:
                case 10:
                case 11:
                    int nameAndTypeItemOffset = classReader.getItem(classReader.readUnsignedShort(itemOffset + 2));
                    addConstantMemberReference(itemIndex, b, classReader.readClass(itemOffset, charBuffer), classReader.readUTF8(nameAndTypeItemOffset, charBuffer), classReader.readUTF8(nameAndTypeItemOffset + 2, charBuffer));
                    break;
                case 12:
                    addConstantNameAndType(itemIndex, classReader.readUTF8(itemOffset, charBuffer), classReader.readUTF8(itemOffset + 2, charBuffer));
                    break;
                case 15:
                    int memberRefItemOffset = classReader.getItem(classReader.readUnsignedShort(itemOffset + 1));
                    int nameAndTypeItemOffset2 = classReader.getItem(classReader.readUnsignedShort(memberRefItemOffset + 2));
                    addConstantMethodHandle(itemIndex, classReader.readByte(itemOffset), classReader.readClass(memberRefItemOffset, charBuffer), classReader.readUTF8(nameAndTypeItemOffset2, charBuffer), classReader.readUTF8(nameAndTypeItemOffset2 + 2, charBuffer));
                    break;
                case 17:
                case 18:
                    hasBootstrapMethods = true;
                    int nameAndTypeItemOffset3 = classReader.getItem(classReader.readUnsignedShort(itemOffset + 2));
                    addConstantDynamicOrInvokeDynamicReference(b, itemIndex, classReader.readUTF8(nameAndTypeItemOffset3, charBuffer), classReader.readUTF8(nameAndTypeItemOffset3 + 2, charBuffer), classReader.readUnsignedShort(itemOffset));
                    break;
            }
            itemIndex += (b == 5 || b == 6) ? 2 : 1;
        }
        if (hasBootstrapMethods) {
            copyBootstrapMethods(classReader, charBuffer);
        }
    }

    private void copyBootstrapMethods(ClassReader classReader, char[] charBuffer) {
        byte[] inputBytes = classReader.classFileBuffer;
        int currentAttributeOffset = classReader.getFirstAttributeOffset();
        int i = classReader.readUnsignedShort(currentAttributeOffset - 2);
        while (true) {
            if (i <= 0) {
                break;
            } else if (BootstrapMethodsAttribute.tag.equals(classReader.readUTF8(currentAttributeOffset, charBuffer))) {
                this.bootstrapMethodCount = classReader.readUnsignedShort(currentAttributeOffset + 6);
                break;
            } else {
                currentAttributeOffset += 6 + classReader.readInt(currentAttributeOffset + 2);
                i--;
            }
        }
        if (this.bootstrapMethodCount > 0) {
            int bootstrapMethodsOffset = currentAttributeOffset + 8;
            int bootstrapMethodsLength = classReader.readInt(currentAttributeOffset + 2) - 2;
            this.bootstrapMethods = new ByteVector(bootstrapMethodsLength);
            this.bootstrapMethods.putByteArray(inputBytes, bootstrapMethodsOffset, bootstrapMethodsLength);
            int currentOffset = bootstrapMethodsOffset;
            for (int i2 = 0; i2 < this.bootstrapMethodCount; i2++) {
                int offset = currentOffset - bootstrapMethodsOffset;
                int bootstrapMethodRef = classReader.readUnsignedShort(currentOffset);
                int currentOffset2 = currentOffset + 2;
                int numBootstrapArguments = classReader.readUnsignedShort(currentOffset2);
                currentOffset = currentOffset2 + 2;
                int hashCode = classReader.readConst(bootstrapMethodRef, charBuffer).hashCode();
                while (true) {
                    numBootstrapArguments--;
                    if (numBootstrapArguments > 0) {
                        int bootstrapArgument = classReader.readUnsignedShort(currentOffset);
                        currentOffset += 2;
                        hashCode ^= classReader.readConst(bootstrapArgument, charBuffer).hashCode();
                    }
                }
                add(new Entry(i2, 64, (long) offset, hashCode & Integer.MAX_VALUE));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ClassReader getSource() {
        return this.sourceClassReader;
    }

    /* access modifiers changed from: package-private */
    public int getMajorVersion() {
        return this.majorVersion;
    }

    /* access modifiers changed from: package-private */
    public String getClassName() {
        return this.className;
    }

    /* access modifiers changed from: package-private */
    public int setMajorVersionAndClassName(int majorVersion, String className) {
        this.majorVersion = majorVersion;
        this.className = className;
        return addConstantClass(className).index;
    }

    /* access modifiers changed from: package-private */
    public int getConstantPoolCount() {
        return this.constantPoolCount;
    }

    /* access modifiers changed from: package-private */
    public int getConstantPoolLength() {
        return this.constantPool.length;
    }

    /* access modifiers changed from: package-private */
    public void putConstantPool(ByteVector output) {
        output.putShort(this.constantPoolCount).putByteArray(this.constantPool.data, 0, this.constantPool.length);
    }

    /* access modifiers changed from: package-private */
    public int computeBootstrapMethodsSize() {
        if (this.bootstrapMethods == null) {
            return 0;
        }
        addConstantUtf8(BootstrapMethodsAttribute.tag);
        return 8 + this.bootstrapMethods.length;
    }

    /* access modifiers changed from: package-private */
    public void putBootstrapMethods(ByteVector output) {
        if (this.bootstrapMethods != null) {
            output.putShort(addConstantUtf8(BootstrapMethodsAttribute.tag)).putInt(this.bootstrapMethods.length + 2).putShort(this.bootstrapMethodCount).putByteArray(this.bootstrapMethods.data, 0, this.bootstrapMethods.length);
        }
    }

    private Entry get(int hashCode) {
        return this.entries[hashCode % this.entries.length];
    }

    private Entry put(Entry entry) {
        if (this.entryCount > (this.entries.length * 3) / 4) {
            int currentCapacity = this.entries.length;
            int newCapacity = (currentCapacity * 2) + 1;
            Entry[] newEntries = new Entry[newCapacity];
            for (int i = currentCapacity - 1; i >= 0; i--) {
                Entry currentEntry = this.entries[i];
                while (currentEntry != null) {
                    int newCurrentEntryIndex = currentEntry.hashCode % newCapacity;
                    Entry nextEntry = currentEntry.next;
                    currentEntry.next = newEntries[newCurrentEntryIndex];
                    newEntries[newCurrentEntryIndex] = currentEntry;
                    currentEntry = nextEntry;
                }
            }
            this.entries = newEntries;
        }
        this.entryCount++;
        int index = entry.hashCode % this.entries.length;
        entry.next = this.entries[index];
        this.entries[index] = entry;
        return entry;
    }

    private void add(Entry entry) {
        this.entryCount++;
        int index = entry.hashCode % this.entries.length;
        entry.next = this.entries[index];
        this.entries[index] = entry;
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstant(Object value) {
        if (value instanceof Integer) {
            return addConstantInteger(((Integer) value).intValue());
        }
        if (value instanceof Byte) {
            return addConstantInteger(((Byte) value).intValue());
        }
        if (value instanceof Character) {
            return addConstantInteger(((Character) value).charValue());
        }
        if (value instanceof Short) {
            return addConstantInteger(((Short) value).intValue());
        }
        if (value instanceof Boolean) {
            return addConstantInteger(((Boolean) value).booleanValue() ? 1 : 0);
        } else if (value instanceof Float) {
            return addConstantFloat(((Float) value).floatValue());
        } else {
            if (value instanceof Long) {
                return addConstantLong(((Long) value).longValue());
            }
            if (value instanceof Double) {
                return addConstantDouble(((Double) value).doubleValue());
            }
            if (value instanceof String) {
                return addConstantString((String) value);
            }
            if (value instanceof Type) {
                Type type = (Type) value;
                int typeSort = type.getSort();
                if (typeSort == 10) {
                    return addConstantClass(type.getInternalName());
                }
                if (typeSort == 11) {
                    return addConstantMethodType(type.getDescriptor());
                }
                return addConstantClass(type.getDescriptor());
            } else if (value instanceof Handle) {
                Handle handle = (Handle) value;
                return addConstantMethodHandle(handle.getTag(), handle.getOwner(), handle.getName(), handle.getDesc(), handle.isInterface());
            } else if (value instanceof ConstantDynamic) {
                ConstantDynamic constantDynamic = (ConstantDynamic) value;
                return addConstantDynamic(constantDynamic.getName(), constantDynamic.getDescriptor(), constantDynamic.getBootstrapMethod(), constantDynamic.getBootstrapMethodArgumentsUnsafe());
            } else {
                throw new IllegalArgumentException("value " + value);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantClass(String value) {
        return addConstantUtf8Reference(7, value);
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantFieldref(String owner, String name, String descriptor) {
        return addConstantMemberReference(9, owner, name, descriptor);
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantMethodref(String owner, String name, String descriptor, boolean isInterface) {
        return addConstantMemberReference(isInterface ? 11 : 10, owner, name, descriptor);
    }

    private Entry addConstantMemberReference(int tag, String owner, String name, String descriptor) {
        int hashCode = hash(tag, owner, name, descriptor);
        for (Entry entry = get(hashCode); entry != null; entry = entry.next) {
            if (entry.tag == tag && entry.hashCode == hashCode && entry.owner.equals(owner) && entry.name.equals(name) && entry.value.equals(descriptor)) {
                return entry;
            }
        }
        this.constantPool.put122(tag, addConstantClass(owner).index, addConstantNameAndType(name, descriptor));
        int i = this.constantPoolCount;
        this.constantPoolCount = i + 1;
        return put(new Entry(i, tag, owner, name, descriptor, 0, hashCode));
    }

    private void addConstantMemberReference(int index, int tag, String owner, String name, String descriptor) {
        add(new Entry(index, tag, owner, name, descriptor, 0, hash(tag, owner, name, descriptor)));
    }

    Symbol addConstantString(String value) {
        return addConstantUtf8Reference(8, value);
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantInteger(int value) {
        return addConstantIntegerOrFloat(3, value);
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantFloat(float value) {
        return addConstantIntegerOrFloat(4, Float.floatToRawIntBits(value));
    }

    private Symbol addConstantIntegerOrFloat(int tag, int value) {
        int hashCode = hash(tag, value);
        for (Entry entry = get(hashCode); entry != null; entry = entry.next) {
            if (entry.tag == tag && entry.hashCode == hashCode && entry.data == ((long) value)) {
                return entry;
            }
        }
        this.constantPool.putByte(tag).putInt(value);
        int i = this.constantPoolCount;
        this.constantPoolCount = i + 1;
        return put(new Entry(i, tag, (long) value, hashCode));
    }

    private void addConstantIntegerOrFloat(int index, int tag, int value) {
        add(new Entry(index, tag, (long) value, hash(tag, value)));
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantLong(long value) {
        return addConstantLongOrDouble(5, value);
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantDouble(double value) {
        return addConstantLongOrDouble(6, Double.doubleToRawLongBits(value));
    }

    private Symbol addConstantLongOrDouble(int tag, long value) {
        int hashCode = hash(tag, value);
        for (Entry entry = get(hashCode); entry != null; entry = entry.next) {
            if (entry.tag == tag && entry.hashCode == hashCode && entry.data == value) {
                return entry;
            }
        }
        int index = this.constantPoolCount;
        this.constantPool.putByte(tag).putLong(value);
        this.constantPoolCount += 2;
        return put(new Entry(index, tag, value, hashCode));
    }

    private void addConstantLongOrDouble(int index, int tag, long value) {
        add(new Entry(index, tag, value, hash(tag, value)));
    }

    /* access modifiers changed from: package-private */
    public int addConstantNameAndType(String name, String descriptor) {
        int hashCode = hash(12, name, descriptor);
        for (Entry entry = get(hashCode); entry != null; entry = entry.next) {
            if (entry.tag == 12 && entry.hashCode == hashCode && entry.name.equals(name) && entry.value.equals(descriptor)) {
                return entry.index;
            }
        }
        this.constantPool.put122(12, addConstantUtf8(name), addConstantUtf8(descriptor));
        int i = this.constantPoolCount;
        this.constantPoolCount = i + 1;
        return put(new Entry(i, 12, name, descriptor, hashCode)).index;
    }

    private void addConstantNameAndType(int index, String name, String descriptor) {
        add(new Entry(index, 12, name, descriptor, hash(12, name, descriptor)));
    }

    /* access modifiers changed from: package-private */
    public int addConstantUtf8(String value) {
        int hashCode = hash(1, value);
        for (Entry entry = get(hashCode); entry != null; entry = entry.next) {
            if (entry.tag == 1 && entry.hashCode == hashCode && entry.value.equals(value)) {
                return entry.index;
            }
        }
        this.constantPool.putByte(1).putUTF8(value);
        int i = this.constantPoolCount;
        this.constantPoolCount = i + 1;
        return put(new Entry(i, 1, value, hashCode)).index;
    }

    private void addConstantUtf8(int index, String value) {
        add(new Entry(index, 1, value, hash(1, value)));
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantMethodHandle(int referenceKind, String owner, String name, String descriptor, boolean isInterface) {
        int hashCode = hash(15, owner, name, descriptor, referenceKind);
        for (Entry entry = get(hashCode); entry != null; entry = entry.next) {
            if (entry.tag == 15 && entry.hashCode == hashCode && entry.data == ((long) referenceKind) && entry.owner.equals(owner) && entry.name.equals(name) && entry.value.equals(descriptor)) {
                return entry;
            }
        }
        if (referenceKind <= 4) {
            this.constantPool.put112(15, referenceKind, addConstantFieldref(owner, name, descriptor).index);
        } else {
            this.constantPool.put112(15, referenceKind, addConstantMethodref(owner, name, descriptor, isInterface).index);
        }
        int i = this.constantPoolCount;
        this.constantPoolCount = i + 1;
        return put(new Entry(i, 15, owner, name, descriptor, (long) referenceKind, hashCode));
    }

    private void addConstantMethodHandle(int index, int referenceKind, String owner, String name, String descriptor) {
        add(new Entry(index, 15, owner, name, descriptor, (long) referenceKind, hash(15, owner, name, descriptor, referenceKind)));
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantMethodType(String methodDescriptor) {
        return addConstantUtf8Reference(16, methodDescriptor);
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantDynamic(String name, String descriptor, Handle bootstrapMethodHandle, Object... bootstrapMethodArguments) {
        return addConstantDynamicOrInvokeDynamicReference(17, name, descriptor, addBootstrapMethod(bootstrapMethodHandle, bootstrapMethodArguments).index);
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantInvokeDynamic(String name, String descriptor, Handle bootstrapMethodHandle, Object... bootstrapMethodArguments) {
        return addConstantDynamicOrInvokeDynamicReference(18, name, descriptor, addBootstrapMethod(bootstrapMethodHandle, bootstrapMethodArguments).index);
    }

    private Symbol addConstantDynamicOrInvokeDynamicReference(int tag, String name, String descriptor, int bootstrapMethodIndex) {
        int hashCode = hash(tag, name, descriptor, bootstrapMethodIndex);
        for (Entry entry = get(hashCode); entry != null; entry = entry.next) {
            if (entry.tag == tag && entry.hashCode == hashCode && entry.data == ((long) bootstrapMethodIndex) && entry.name.equals(name) && entry.value.equals(descriptor)) {
                return entry;
            }
        }
        this.constantPool.put122(tag, bootstrapMethodIndex, addConstantNameAndType(name, descriptor));
        int i = this.constantPoolCount;
        this.constantPoolCount = i + 1;
        return put(new Entry(i, tag, null, name, descriptor, (long) bootstrapMethodIndex, hashCode));
    }

    private void addConstantDynamicOrInvokeDynamicReference(int tag, int index, String name, String descriptor, int bootstrapMethodIndex) {
        add(new Entry(index, tag, null, name, descriptor, (long) bootstrapMethodIndex, hash(tag, name, descriptor, bootstrapMethodIndex)));
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantModule(String moduleName) {
        return addConstantUtf8Reference(19, moduleName);
    }

    /* access modifiers changed from: package-private */
    public Symbol addConstantPackage(String packageName) {
        return addConstantUtf8Reference(20, packageName);
    }

    private Symbol addConstantUtf8Reference(int tag, String value) {
        int hashCode = hash(tag, value);
        for (Entry entry = get(hashCode); entry != null; entry = entry.next) {
            if (entry.tag == tag && entry.hashCode == hashCode && entry.value.equals(value)) {
                return entry;
            }
        }
        this.constantPool.put12(tag, addConstantUtf8(value));
        int i = this.constantPoolCount;
        this.constantPoolCount = i + 1;
        return put(new Entry(i, tag, value, hashCode));
    }

    private void addConstantUtf8Reference(int index, int tag, String value) {
        add(new Entry(index, tag, value, hash(tag, value)));
    }

    Symbol addBootstrapMethod(Handle bootstrapMethodHandle, Object... bootstrapMethodArguments) {
        ByteVector bootstrapMethodsAttribute = this.bootstrapMethods;
        if (bootstrapMethodsAttribute == null) {
            ByteVector byteVector = new ByteVector();
            this.bootstrapMethods = byteVector;
            bootstrapMethodsAttribute = byteVector;
        }
        int numBootstrapArguments = bootstrapMethodArguments.length;
        int[] bootstrapMethodArgumentIndexes = new int[numBootstrapArguments];
        for (int i = 0; i < numBootstrapArguments; i++) {
            bootstrapMethodArgumentIndexes[i] = addConstant(bootstrapMethodArguments[i]).index;
        }
        int bootstrapMethodOffset = bootstrapMethodsAttribute.length;
        bootstrapMethodsAttribute.putShort(addConstantMethodHandle(bootstrapMethodHandle.getTag(), bootstrapMethodHandle.getOwner(), bootstrapMethodHandle.getName(), bootstrapMethodHandle.getDesc(), bootstrapMethodHandle.isInterface()).index);
        bootstrapMethodsAttribute.putShort(numBootstrapArguments);
        for (int i2 = 0; i2 < numBootstrapArguments; i2++) {
            bootstrapMethodsAttribute.putShort(bootstrapMethodArgumentIndexes[i2]);
        }
        int bootstrapMethodlength = bootstrapMethodsAttribute.length - bootstrapMethodOffset;
        int hashCode = bootstrapMethodHandle.hashCode();
        for (Object bootstrapMethodArgument : bootstrapMethodArguments) {
            hashCode ^= bootstrapMethodArgument.hashCode();
        }
        return addBootstrapMethod(bootstrapMethodOffset, bootstrapMethodlength, hashCode & Integer.MAX_VALUE);
    }

    private Symbol addBootstrapMethod(int offset, int length, int hashCode) {
        byte[] bootstrapMethodsData = this.bootstrapMethods.data;
        for (Entry entry = get(hashCode); entry != null; entry = entry.next) {
            if (entry.tag == 64 && entry.hashCode == hashCode) {
                int otherOffset = (int) entry.data;
                boolean isSameBootstrapMethod = true;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (bootstrapMethodsData[offset + i] != bootstrapMethodsData[otherOffset + i]) {
                        isSameBootstrapMethod = false;
                        break;
                    } else {
                        i++;
                    }
                }
                if (isSameBootstrapMethod) {
                    this.bootstrapMethods.length = offset;
                    return entry;
                }
            }
        }
        int i2 = this.bootstrapMethodCount;
        this.bootstrapMethodCount = i2 + 1;
        return put(new Entry(i2, 64, (long) offset, hashCode));
    }

    /* access modifiers changed from: package-private */
    public Symbol getType(int typeIndex) {
        return this.typeTable[typeIndex];
    }

    /* access modifiers changed from: package-private */
    public int addType(String value) {
        int hashCode = hash(128, value);
        for (Entry entry = get(hashCode); entry != null; entry = entry.next) {
            if (entry.tag == 128 && entry.hashCode == hashCode && entry.value.equals(value)) {
                return entry.index;
            }
        }
        return addTypeInternal(new Entry(this.typeCount, 128, value, hashCode));
    }

    /* access modifiers changed from: package-private */
    public int addUninitializedType(String value, int bytecodeOffset) {
        int hashCode = hash(129, value, bytecodeOffset);
        for (Entry entry = get(hashCode); entry != null; entry = entry.next) {
            if (entry.tag == 129 && entry.hashCode == hashCode && entry.data == ((long) bytecodeOffset) && entry.value.equals(value)) {
                return entry.index;
            }
        }
        return addTypeInternal(new Entry(this.typeCount, 129, value, (long) bytecodeOffset, hashCode));
    }

    /* access modifiers changed from: package-private */
    public int addMergedType(int typeTableIndex1, int typeTableIndex2) {
        long data;
        if (typeTableIndex1 < typeTableIndex2) {
            data = ((long) typeTableIndex1) | (((long) typeTableIndex2) << 32);
        } else {
            data = ((long) typeTableIndex2) | (((long) typeTableIndex1) << 32);
        }
        int hashCode = hash(130, typeTableIndex1 + typeTableIndex2);
        for (Entry entry = get(hashCode); entry != null; entry = entry.next) {
            if (entry.tag == 130 && entry.hashCode == hashCode && entry.data == data) {
                return entry.info;
            }
        }
        int commonSuperTypeIndex = addType(this.classWriter.getCommonSuperClass(this.typeTable[typeTableIndex1].value, this.typeTable[typeTableIndex2].value));
        put(new Entry(this.typeCount, 130, data, hashCode)).info = commonSuperTypeIndex;
        return commonSuperTypeIndex;
    }

    private int addTypeInternal(Entry entry) {
        if (this.typeTable == null) {
            this.typeTable = new Entry[16];
        }
        if (this.typeCount == this.typeTable.length) {
            Entry[] newTypeTable = new Entry[2 * this.typeTable.length];
            System.arraycopy(this.typeTable, 0, newTypeTable, 0, this.typeTable.length);
            this.typeTable = newTypeTable;
        }
        Entry[] entryArr = this.typeTable;
        int i = this.typeCount;
        this.typeCount = i + 1;
        entryArr[i] = entry;
        return put(entry).index;
    }

    private static int hash(int tag, int value) {
        return Integer.MAX_VALUE & (tag + value);
    }

    private static int hash(int tag, long value) {
        return Integer.MAX_VALUE & (tag + ((int) value) + ((int) (value >>> 32)));
    }

    private static int hash(int tag, String value) {
        return Integer.MAX_VALUE & (tag + value.hashCode());
    }

    private static int hash(int tag, String value1, int value2) {
        return Integer.MAX_VALUE & (tag + value1.hashCode() + value2);
    }

    private static int hash(int tag, String value1, String value2) {
        return Integer.MAX_VALUE & (tag + (value1.hashCode() * value2.hashCode()));
    }

    private static int hash(int tag, String value1, String value2, int value3) {
        return Integer.MAX_VALUE & (tag + (value1.hashCode() * value2.hashCode() * (value3 + 1)));
    }

    private static int hash(int tag, String value1, String value2, String value3) {
        return Integer.MAX_VALUE & (tag + (value1.hashCode() * value2.hashCode() * value3.hashCode()));
    }

    private static int hash(int tag, String value1, String value2, String value3, int value4) {
        return Integer.MAX_VALUE & (tag + (value1.hashCode() * value2.hashCode() * value3.hashCode() * value4));
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:net/bytebuddy/jar/asm/SymbolTable$Entry.class */
    public static class Entry extends Symbol {
        final int hashCode;
        Entry next;

        Entry(int index, int tag, String owner, String name, String value, long data, int hashCode) {
            super(index, tag, owner, name, value, data);
            this.hashCode = hashCode;
        }

        Entry(int index, int tag, String value, int hashCode) {
            super(index, tag, null, null, value, 0);
            this.hashCode = hashCode;
        }

        Entry(int index, int tag, String value, long data, int hashCode) {
            super(index, tag, null, null, value, data);
            this.hashCode = hashCode;
        }

        Entry(int index, int tag, String name, String value, int hashCode) {
            super(index, tag, null, name, value, 0);
            this.hashCode = hashCode;
        }

        Entry(int index, int tag, long data, int hashCode) {
            super(index, tag, null, null, null, data);
            this.hashCode = hashCode;
        }
    }
}
