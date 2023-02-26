package net.bytebuddy.jar.asm;

import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.DeprecatedAttribute;
import javassist.bytecode.EnclosingMethodAttribute;
import javassist.bytecode.InnerClassesAttribute;
import javassist.bytecode.NestHostAttribute;
import javassist.bytecode.NestMembersAttribute;
import javassist.bytecode.SignatureAttribute;
import javassist.bytecode.SourceFileAttribute;
import javassist.bytecode.SyntheticAttribute;
import javassist.bytecode.TypeAnnotationsAttribute;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.jar.asm.Attribute;

/* loaded from: grasscutter.jar:net/bytebuddy/jar/asm/ClassWriter.class */
public class ClassWriter extends ClassVisitor {
    public static final int COMPUTE_MAXS = 1;
    public static final int COMPUTE_FRAMES = 2;
    private int version;
    private final SymbolTable symbolTable;
    private int accessFlags;
    private int thisClass;
    private int superClass;
    private int interfaceCount;
    private int[] interfaces;
    private FieldWriter firstField;
    private FieldWriter lastField;
    private MethodWriter firstMethod;
    private MethodWriter lastMethod;
    private int numberOfInnerClasses;
    private ByteVector innerClasses;
    private int enclosingClassIndex;
    private int enclosingMethodIndex;
    private int signatureIndex;
    private int sourceFileIndex;
    private ByteVector debugExtension;
    private AnnotationWriter lastRuntimeVisibleAnnotation;
    private AnnotationWriter lastRuntimeInvisibleAnnotation;
    private AnnotationWriter lastRuntimeVisibleTypeAnnotation;
    private AnnotationWriter lastRuntimeInvisibleTypeAnnotation;
    private ModuleWriter moduleWriter;
    private int nestHostClassIndex;
    private int numberOfNestMemberClasses;
    private ByteVector nestMemberClasses;
    private int numberOfPermittedSubclasses;
    private ByteVector permittedSubclasses;
    private RecordComponentWriter firstRecordComponent;
    private RecordComponentWriter lastRecordComponent;
    private Attribute firstAttribute;
    private int compute;

    public ClassWriter(int flags) {
        this(null, flags);
    }

    public ClassWriter(ClassReader classReader, int flags) {
        super(Opcodes.ASM9);
        this.symbolTable = classReader == null ? new SymbolTable(this) : new SymbolTable(this, classReader);
        if ((flags & 2) != 0) {
            this.compute = 4;
        } else if ((flags & 1) != 0) {
            this.compute = 1;
        } else {
            this.compute = 0;
        }
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.version = version;
        this.accessFlags = access;
        this.thisClass = this.symbolTable.setMajorVersionAndClassName(version & 65535, name);
        if (signature != null) {
            this.signatureIndex = this.symbolTable.addConstantUtf8(signature);
        }
        this.superClass = superName == null ? 0 : this.symbolTable.addConstantClass(superName).index;
        if (interfaces != null && interfaces.length > 0) {
            this.interfaceCount = interfaces.length;
            this.interfaces = new int[this.interfaceCount];
            for (int i = 0; i < this.interfaceCount; i++) {
                this.interfaces[i] = this.symbolTable.addConstantClass(interfaces[i]).index;
            }
        }
        if (this.compute == 1 && (version & 65535) >= 51) {
            this.compute = 2;
        }
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitSource(String file, String debug) {
        if (file != null) {
            this.sourceFileIndex = this.symbolTable.addConstantUtf8(file);
        }
        if (debug != null) {
            this.debugExtension = new ByteVector().encodeUtf8(debug, 0, Integer.MAX_VALUE);
        }
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final ModuleVisitor visitModule(String name, int access, String version) {
        ModuleWriter moduleWriter = new ModuleWriter(this.symbolTable, this.symbolTable.addConstantModule(name).index, access, version == null ? 0 : this.symbolTable.addConstantUtf8(version));
        this.moduleWriter = moduleWriter;
        return moduleWriter;
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitNestHost(String nestHost) {
        this.nestHostClassIndex = this.symbolTable.addConstantClass(nestHost).index;
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitOuterClass(String owner, String name, String descriptor) {
        this.enclosingClassIndex = this.symbolTable.addConstantClass(owner).index;
        if (name != null && descriptor != null) {
            this.enclosingMethodIndex = this.symbolTable.addConstantNameAndType(name, descriptor);
        }
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        if (visible) {
            AnnotationWriter create = AnnotationWriter.create(this.symbolTable, descriptor, this.lastRuntimeVisibleAnnotation);
            this.lastRuntimeVisibleAnnotation = create;
            return create;
        }
        AnnotationWriter create2 = AnnotationWriter.create(this.symbolTable, descriptor, this.lastRuntimeInvisibleAnnotation);
        this.lastRuntimeInvisibleAnnotation = create2;
        return create2;
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        if (visible) {
            AnnotationWriter create = AnnotationWriter.create(this.symbolTable, typeRef, typePath, descriptor, this.lastRuntimeVisibleTypeAnnotation);
            this.lastRuntimeVisibleTypeAnnotation = create;
            return create;
        }
        AnnotationWriter create2 = AnnotationWriter.create(this.symbolTable, typeRef, typePath, descriptor, this.lastRuntimeInvisibleTypeAnnotation);
        this.lastRuntimeInvisibleTypeAnnotation = create2;
        return create2;
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitAttribute(Attribute attribute) {
        attribute.nextAttribute = this.firstAttribute;
        this.firstAttribute = attribute;
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitNestMember(String nestMember) {
        if (this.nestMemberClasses == null) {
            this.nestMemberClasses = new ByteVector();
        }
        this.numberOfNestMemberClasses++;
        this.nestMemberClasses.putShort(this.symbolTable.addConstantClass(nestMember).index);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitPermittedSubclass(String permittedSubclass) {
        if (this.permittedSubclasses == null) {
            this.permittedSubclasses = new ByteVector();
        }
        this.numberOfPermittedSubclasses++;
        this.permittedSubclasses.putShort(this.symbolTable.addConstantClass(permittedSubclass).index);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitInnerClass(String name, String outerName, String innerName, int access) {
        if (this.innerClasses == null) {
            this.innerClasses = new ByteVector();
        }
        Symbol nameSymbol = this.symbolTable.addConstantClass(name);
        if (nameSymbol.info == 0) {
            this.numberOfInnerClasses++;
            this.innerClasses.putShort(nameSymbol.index);
            this.innerClasses.putShort(outerName == null ? 0 : this.symbolTable.addConstantClass(outerName).index);
            this.innerClasses.putShort(innerName == null ? 0 : this.symbolTable.addConstantUtf8(innerName));
            this.innerClasses.putShort(access);
            nameSymbol.info = this.numberOfInnerClasses;
        }
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final RecordComponentVisitor visitRecordComponent(String name, String descriptor, String signature) {
        RecordComponentWriter recordComponentWriter = new RecordComponentWriter(this.symbolTable, name, descriptor, signature);
        if (this.firstRecordComponent == null) {
            this.firstRecordComponent = recordComponentWriter;
        } else {
            this.lastRecordComponent.delegate = recordComponentWriter;
        }
        this.lastRecordComponent = recordComponentWriter;
        return recordComponentWriter;
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        FieldWriter fieldWriter = new FieldWriter(this.symbolTable, access, name, descriptor, signature, value);
        if (this.firstField == null) {
            this.firstField = fieldWriter;
        } else {
            this.lastField.f3067fv = fieldWriter;
        }
        this.lastField = fieldWriter;
        return fieldWriter;
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodWriter methodWriter = new MethodWriter(this.symbolTable, access, name, descriptor, signature, exceptions, this.compute);
        if (this.firstMethod == null) {
            this.firstMethod = methodWriter;
        } else {
            this.lastMethod.f3068mv = methodWriter;
        }
        this.lastMethod = methodWriter;
        return methodWriter;
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitEnd() {
    }

    public byte[] toByteArray() {
        int size = 24 + (2 * this.interfaceCount);
        int fieldsCount = 0;
        for (FieldWriter fieldWriter = this.firstField; fieldWriter != null; fieldWriter = (FieldWriter) fieldWriter.f3067fv) {
            fieldsCount++;
            size += fieldWriter.computeFieldInfoSize();
        }
        int methodsCount = 0;
        for (MethodWriter methodWriter = this.firstMethod; methodWriter != null; methodWriter = (MethodWriter) methodWriter.f3068mv) {
            methodsCount++;
            size += methodWriter.computeMethodInfoSize();
        }
        int attributesCount = 0;
        if (this.innerClasses != null) {
            attributesCount = 0 + 1;
            size += 8 + this.innerClasses.length;
            this.symbolTable.addConstantUtf8(InnerClassesAttribute.tag);
        }
        if (this.enclosingClassIndex != 0) {
            attributesCount++;
            size += 10;
            this.symbolTable.addConstantUtf8(EnclosingMethodAttribute.tag);
        }
        if ((this.accessFlags & 4096) != 0 && (this.version & 65535) < 49) {
            attributesCount++;
            size += 6;
            this.symbolTable.addConstantUtf8(SyntheticAttribute.tag);
        }
        if (this.signatureIndex != 0) {
            attributesCount++;
            size += 8;
            this.symbolTable.addConstantUtf8(SignatureAttribute.tag);
        }
        if (this.sourceFileIndex != 0) {
            attributesCount++;
            size += 8;
            this.symbolTable.addConstantUtf8(SourceFileAttribute.tag);
        }
        if (this.debugExtension != null) {
            attributesCount++;
            size += 6 + this.debugExtension.length;
            this.symbolTable.addConstantUtf8("SourceDebugExtension");
        }
        if ((this.accessFlags & 131072) != 0) {
            attributesCount++;
            size += 6;
            this.symbolTable.addConstantUtf8(DeprecatedAttribute.tag);
        }
        if (this.lastRuntimeVisibleAnnotation != null) {
            attributesCount++;
            size += this.lastRuntimeVisibleAnnotation.computeAnnotationsSize(AnnotationsAttribute.visibleTag);
        }
        if (this.lastRuntimeInvisibleAnnotation != null) {
            attributesCount++;
            size += this.lastRuntimeInvisibleAnnotation.computeAnnotationsSize(AnnotationsAttribute.invisibleTag);
        }
        if (this.lastRuntimeVisibleTypeAnnotation != null) {
            attributesCount++;
            size += this.lastRuntimeVisibleTypeAnnotation.computeAnnotationsSize(TypeAnnotationsAttribute.visibleTag);
        }
        if (this.lastRuntimeInvisibleTypeAnnotation != null) {
            attributesCount++;
            size += this.lastRuntimeInvisibleTypeAnnotation.computeAnnotationsSize(TypeAnnotationsAttribute.invisibleTag);
        }
        if (this.symbolTable.computeBootstrapMethodsSize() > 0) {
            attributesCount++;
            size += this.symbolTable.computeBootstrapMethodsSize();
        }
        if (this.moduleWriter != null) {
            attributesCount += this.moduleWriter.getAttributeCount();
            size += this.moduleWriter.computeAttributesSize();
        }
        if (this.nestHostClassIndex != 0) {
            attributesCount++;
            size += 8;
            this.symbolTable.addConstantUtf8(NestHostAttribute.tag);
        }
        if (this.nestMemberClasses != null) {
            attributesCount++;
            size += 8 + this.nestMemberClasses.length;
            this.symbolTable.addConstantUtf8(NestMembersAttribute.tag);
        }
        if (this.permittedSubclasses != null) {
            attributesCount++;
            size += 8 + this.permittedSubclasses.length;
            this.symbolTable.addConstantUtf8("PermittedSubclasses");
        }
        int recordComponentCount = 0;
        int recordSize = 0;
        if (!((this.accessFlags & 65536) == 0 && this.firstRecordComponent == null)) {
            for (RecordComponentWriter recordComponentWriter = this.firstRecordComponent; recordComponentWriter != null; recordComponentWriter = (RecordComponentWriter) recordComponentWriter.delegate) {
                recordComponentCount++;
                recordSize += recordComponentWriter.computeRecordComponentInfoSize();
            }
            attributesCount++;
            size += 8 + recordSize;
            this.symbolTable.addConstantUtf8("Record");
        }
        if (this.firstAttribute != null) {
            attributesCount += this.firstAttribute.getAttributeCount();
            size += this.firstAttribute.computeAttributesSize(this.symbolTable);
        }
        int size2 = size + this.symbolTable.getConstantPoolLength();
        int constantPoolCount = this.symbolTable.getConstantPoolCount();
        if (constantPoolCount > 65535) {
            throw new ClassTooLargeException(this.symbolTable.getClassName(), constantPoolCount);
        }
        ByteVector result = new ByteVector(size2);
        result.putInt(-889275714).putInt(this.version);
        this.symbolTable.putConstantPool(result);
        result.putShort(this.accessFlags & (((this.version & 65535) < 49 ? 4096 : 0) ^ -1)).putShort(this.thisClass).putShort(this.superClass);
        result.putShort(this.interfaceCount);
        for (int i = 0; i < this.interfaceCount; i++) {
            result.putShort(this.interfaces[i]);
        }
        result.putShort(fieldsCount);
        for (FieldWriter fieldWriter2 = this.firstField; fieldWriter2 != null; fieldWriter2 = (FieldWriter) fieldWriter2.f3067fv) {
            fieldWriter2.putFieldInfo(result);
        }
        result.putShort(methodsCount);
        boolean hasFrames = false;
        boolean hasAsmInstructions = false;
        for (MethodWriter methodWriter2 = this.firstMethod; methodWriter2 != null; methodWriter2 = (MethodWriter) methodWriter2.f3068mv) {
            hasFrames |= methodWriter2.hasFrames();
            hasAsmInstructions |= methodWriter2.hasAsmInstructions();
            methodWriter2.putMethodInfo(result);
        }
        result.putShort(attributesCount);
        if (this.innerClasses != null) {
            result.putShort(this.symbolTable.addConstantUtf8(InnerClassesAttribute.tag)).putInt(this.innerClasses.length + 2).putShort(this.numberOfInnerClasses).putByteArray(this.innerClasses.data, 0, this.innerClasses.length);
        }
        if (this.enclosingClassIndex != 0) {
            result.putShort(this.symbolTable.addConstantUtf8(EnclosingMethodAttribute.tag)).putInt(4).putShort(this.enclosingClassIndex).putShort(this.enclosingMethodIndex);
        }
        if ((this.accessFlags & 4096) != 0 && (this.version & 65535) < 49) {
            result.putShort(this.symbolTable.addConstantUtf8(SyntheticAttribute.tag)).putInt(0);
        }
        if (this.signatureIndex != 0) {
            result.putShort(this.symbolTable.addConstantUtf8(SignatureAttribute.tag)).putInt(2).putShort(this.signatureIndex);
        }
        if (this.sourceFileIndex != 0) {
            result.putShort(this.symbolTable.addConstantUtf8(SourceFileAttribute.tag)).putInt(2).putShort(this.sourceFileIndex);
        }
        if (this.debugExtension != null) {
            int length = this.debugExtension.length;
            result.putShort(this.symbolTable.addConstantUtf8("SourceDebugExtension")).putInt(length).putByteArray(this.debugExtension.data, 0, length);
        }
        if ((this.accessFlags & 131072) != 0) {
            result.putShort(this.symbolTable.addConstantUtf8(DeprecatedAttribute.tag)).putInt(0);
        }
        AnnotationWriter.putAnnotations(this.symbolTable, this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation, result);
        this.symbolTable.putBootstrapMethods(result);
        if (this.moduleWriter != null) {
            this.moduleWriter.putAttributes(result);
        }
        if (this.nestHostClassIndex != 0) {
            result.putShort(this.symbolTable.addConstantUtf8(NestHostAttribute.tag)).putInt(2).putShort(this.nestHostClassIndex);
        }
        if (this.nestMemberClasses != null) {
            result.putShort(this.symbolTable.addConstantUtf8(NestMembersAttribute.tag)).putInt(this.nestMemberClasses.length + 2).putShort(this.numberOfNestMemberClasses).putByteArray(this.nestMemberClasses.data, 0, this.nestMemberClasses.length);
        }
        if (this.permittedSubclasses != null) {
            result.putShort(this.symbolTable.addConstantUtf8("PermittedSubclasses")).putInt(this.permittedSubclasses.length + 2).putShort(this.numberOfPermittedSubclasses).putByteArray(this.permittedSubclasses.data, 0, this.permittedSubclasses.length);
        }
        if (!((this.accessFlags & 65536) == 0 && this.firstRecordComponent == null)) {
            result.putShort(this.symbolTable.addConstantUtf8("Record")).putInt(recordSize + 2).putShort(recordComponentCount);
            for (RecordComponentWriter recordComponentWriter2 = this.firstRecordComponent; recordComponentWriter2 != null; recordComponentWriter2 = (RecordComponentWriter) recordComponentWriter2.delegate) {
                recordComponentWriter2.putRecordComponentInfo(result);
            }
        }
        if (this.firstAttribute != null) {
            this.firstAttribute.putAttributes(this.symbolTable, result);
        }
        if (hasAsmInstructions) {
            return replaceAsmInstructions(result.data, hasFrames);
        }
        return result.data;
    }

    private byte[] replaceAsmInstructions(byte[] classFile, boolean hasFrames) {
        Attribute[] attributes = getAttributePrototypes();
        this.firstField = null;
        this.lastField = null;
        this.firstMethod = null;
        this.lastMethod = null;
        this.lastRuntimeVisibleAnnotation = null;
        this.lastRuntimeInvisibleAnnotation = null;
        this.lastRuntimeVisibleTypeAnnotation = null;
        this.lastRuntimeInvisibleTypeAnnotation = null;
        this.moduleWriter = null;
        this.nestHostClassIndex = 0;
        this.numberOfNestMemberClasses = 0;
        this.nestMemberClasses = null;
        this.numberOfPermittedSubclasses = 0;
        this.permittedSubclasses = null;
        this.firstRecordComponent = null;
        this.lastRecordComponent = null;
        this.firstAttribute = null;
        this.compute = hasFrames ? 3 : 0;
        new ClassReader(classFile, 0, false).accept(this, attributes, (hasFrames ? 8 : 0) | 256);
        return toByteArray();
    }

    private Attribute[] getAttributePrototypes() {
        Attribute.Set attributePrototypes = new Attribute.Set();
        attributePrototypes.addAttributes(this.firstAttribute);
        for (FieldWriter fieldWriter = this.firstField; fieldWriter != null; fieldWriter = (FieldWriter) fieldWriter.f3067fv) {
            fieldWriter.collectAttributePrototypes(attributePrototypes);
        }
        for (MethodWriter methodWriter = this.firstMethod; methodWriter != null; methodWriter = (MethodWriter) methodWriter.f3068mv) {
            methodWriter.collectAttributePrototypes(attributePrototypes);
        }
        for (RecordComponentWriter recordComponentWriter = this.firstRecordComponent; recordComponentWriter != null; recordComponentWriter = (RecordComponentWriter) recordComponentWriter.delegate) {
            recordComponentWriter.collectAttributePrototypes(attributePrototypes);
        }
        return attributePrototypes.toArray();
    }

    public int newConst(Object value) {
        return this.symbolTable.addConstant(value).index;
    }

    public int newUTF8(String value) {
        return this.symbolTable.addConstantUtf8(value);
    }

    public int newClass(String value) {
        return this.symbolTable.addConstantClass(value).index;
    }

    public int newMethodType(String methodDescriptor) {
        return this.symbolTable.addConstantMethodType(methodDescriptor).index;
    }

    public int newModule(String moduleName) {
        return this.symbolTable.addConstantModule(moduleName).index;
    }

    public int newPackage(String packageName) {
        return this.symbolTable.addConstantPackage(packageName).index;
    }

    @Deprecated
    public int newHandle(int tag, String owner, String name, String descriptor) {
        return newHandle(tag, owner, name, descriptor, tag == 9);
    }

    public int newHandle(int tag, String owner, String name, String descriptor, boolean isInterface) {
        return this.symbolTable.addConstantMethodHandle(tag, owner, name, descriptor, isInterface).index;
    }

    public int newConstantDynamic(String name, String descriptor, Handle bootstrapMethodHandle, Object... bootstrapMethodArguments) {
        return this.symbolTable.addConstantDynamic(name, descriptor, bootstrapMethodHandle, bootstrapMethodArguments).index;
    }

    public int newInvokeDynamic(String name, String descriptor, Handle bootstrapMethodHandle, Object... bootstrapMethodArguments) {
        return this.symbolTable.addConstantInvokeDynamic(name, descriptor, bootstrapMethodHandle, bootstrapMethodArguments).index;
    }

    public int newField(String owner, String name, String descriptor) {
        return this.symbolTable.addConstantFieldref(owner, name, descriptor).index;
    }

    public int newMethod(String owner, String name, String descriptor, boolean isInterface) {
        return this.symbolTable.addConstantMethodref(owner, name, descriptor, isInterface).index;
    }

    public int newNameType(String name, String descriptor) {
        return this.symbolTable.addConstantNameAndType(name, descriptor);
    }

    /* access modifiers changed from: protected */
    public String getCommonSuperClass(String type1, String type2) {
        ClassLoader classLoader = getClassLoader();
        try {
            Class<?> class1 = Class.forName(type1.replace('/', '.'), false, classLoader);
            try {
                Class<?> class2 = Class.forName(type2.replace('/', '.'), false, classLoader);
                if (class1.isAssignableFrom(class2)) {
                    return type1;
                }
                if (class2.isAssignableFrom(class1)) {
                    return type2;
                }
                if (class1.isInterface() || class2.isInterface()) {
                    return TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME;
                }
                do {
                    class1 = class1.getSuperclass();
                } while (!class1.isAssignableFrom(class2));
                return class1.getName().replace('.', '/');
            } catch (ClassNotFoundException e) {
                throw new TypeNotPresentException(type2, e);
            }
        } catch (ClassNotFoundException e2) {
            throw new TypeNotPresentException(type1, e2);
        }
    }

    protected ClassLoader getClassLoader() {
        return getClass().getClassLoader();
    }
}
