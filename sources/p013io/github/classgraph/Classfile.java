package p013io.github.classgraph;

import dev.morphia.mapping.Mapper;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javassist.bytecode.AnnotationDefaultAttribute;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.ConstantAttribute;
import javassist.bytecode.EnclosingMethodAttribute;
import javassist.bytecode.InnerClassesAttribute;
import javassist.bytecode.MethodParametersAttribute;
import javassist.bytecode.ParameterAnnotationsAttribute;
import javassist.bytecode.SignatureAttribute;
import net.bytebuddy.description.type.PackageDescription;
import nonapi.p019io.github.classgraph.concurrency.WorkQueue;
import nonapi.p019io.github.classgraph.fileslice.reader.ClassfileReader;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.types.ParseException;
import nonapi.p019io.github.classgraph.utils.CollectionUtils;
import nonapi.p019io.github.classgraph.utils.JarUtils;
import nonapi.p019io.github.classgraph.utils.Join;
import nonapi.p019io.github.classgraph.utils.LogNode;
import p013io.github.classgraph.Scanner;

/* access modifiers changed from: package-private */
/* renamed from: io.github.classgraph.Classfile */
/* loaded from: grasscutter.jar:io/github/classgraph/Classfile.class */
public class Classfile {
    private ClassfileReader reader;
    private final ClasspathElement classpathElement;
    private final List<ClasspathElement> classpathOrder;
    private final String relativePath;
    private final Resource classfileResource;
    private final ConcurrentHashMap<String, String> stringInternMap;
    private String className;
    private int minorVersion;
    private int majorVersion;
    private final boolean isExternalClass;
    private int classModifiers;
    private boolean isInterface;
    private boolean isRecord;
    private boolean isAnnotation;
    private String superclassName;
    private List<String> implementedInterfaces;
    private AnnotationInfoList classAnnotations;
    private String fullyQualifiedDefiningMethodName;
    private List<ClassContainment> classContainmentEntries;
    private AnnotationParameterValueList annotationParamDefaultValues;
    private Set<String> refdClassNames;
    private FieldInfoList fieldInfoList;
    private MethodInfoList methodInfoList;
    private String typeSignature;
    private final Set<String> whitelistedClassNamesFound;
    private final Set<String> classNamesScheduledForExtendedScanning;
    private List<Scanner.ClassfileScanWorkUnit> additionalWorkUnits;
    private final ScanSpec scanSpec;
    private int cpCount;
    private int[] entryOffset;
    private int[] entryTag;
    private int[] indirectStringRefs;
    private static final AnnotationInfo[] NO_ANNOTATIONS = new AnnotationInfo[0];

    /* access modifiers changed from: package-private */
    /* renamed from: io.github.classgraph.Classfile$ClassContainment */
    /* loaded from: grasscutter.jar:io/github/classgraph/Classfile$ClassContainment.class */
    public static class ClassContainment {
        public final String innerClassName;
        public final int innerClassModifierBits;
        public final String outerClassName;

        public ClassContainment(String innerClassName, int innerClassModifierBits, String outerClassName) {
            this.innerClassName = innerClassName;
            this.innerClassModifierBits = innerClassModifierBits;
            this.outerClassName = outerClassName;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.github.classgraph.Classfile$ClassfileFormatException */
    /* loaded from: grasscutter.jar:io/github/classgraph/Classfile$ClassfileFormatException.class */
    public static class ClassfileFormatException extends IOException {
        static final long serialVersionUID = 1;

        public ClassfileFormatException(String message) {
            super(message);
        }

        public ClassfileFormatException(String message, Throwable cause) {
            super(message, cause);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.github.classgraph.Classfile$SkipClassException */
    /* loaded from: grasscutter.jar:io/github/classgraph/Classfile$SkipClassException.class */
    public static class SkipClassException extends IOException {
        static final long serialVersionUID = 1;

        public SkipClassException(String message) {
            super(message);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    private void scheduleScanningIfExternalClass(String className, String relationship, LogNode log) {
        if (className != null && !className.equals("java.lang.Object") && !this.whitelistedClassNamesFound.contains(className) && this.classNamesScheduledForExtendedScanning.add(className)) {
            if (!this.scanSpec.classWhiteBlackList.isBlacklisted(className)) {
                String classfilePath = JarUtils.classNameToClassfilePath(className);
                Resource classResource = this.classpathElement.getResource(classfilePath);
                ClasspathElement foundInClasspathElt = null;
                if (classResource != null) {
                    foundInClasspathElt = this.classpathElement;
                } else {
                    Iterator<ClasspathElement> it = this.classpathOrder.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ClasspathElement classpathOrderElt = it.next();
                        if (classpathOrderElt != this.classpathElement) {
                            classResource = classpathOrderElt.getResource(classfilePath);
                            if (classResource != null) {
                                foundInClasspathElt = classpathOrderElt;
                                break;
                            }
                        }
                    }
                }
                if (classResource != null) {
                    if (log != null) {
                        classResource.scanLog = log.log("Extending scanning to external " + relationship + (foundInClasspathElt == this.classpathElement ? " in same classpath element" : " in classpath element " + foundInClasspathElt) + ": " + className);
                    }
                    if (this.additionalWorkUnits == null) {
                        this.additionalWorkUnits = new ArrayList();
                    }
                    this.additionalWorkUnits.add(new Scanner.ClassfileScanWorkUnit(foundInClasspathElt, classResource, true));
                } else if (log != null) {
                    log.log("External " + relationship + " " + className + " was not found in non-blacklisted packages -- cannot extend scanning to this class");
                }
            } else if (log != null) {
                log.log("Cannot extend scanning upwards to external " + relationship + " " + className + ", since it is blacklisted");
            }
        }
    }

    private void extendScanningUpwardsFromAnnotationParameterValues(Object annotationParamVal, LogNode log) {
        if (annotationParamVal != null) {
            if (annotationParamVal instanceof AnnotationInfo) {
                AnnotationInfo annotationInfo = (AnnotationInfo) annotationParamVal;
                scheduleScanningIfExternalClass(annotationInfo.getClassName(), "annotation class", log);
                Iterator it = annotationInfo.getParameterValues().iterator();
                while (it.hasNext()) {
                    extendScanningUpwardsFromAnnotationParameterValues(((AnnotationParameterValue) it.next()).getValue(), log);
                }
            } else if (annotationParamVal instanceof AnnotationEnumValue) {
                scheduleScanningIfExternalClass(((AnnotationEnumValue) annotationParamVal).getClassName(), "enum class", log);
            } else if (annotationParamVal instanceof AnnotationClassRef) {
                scheduleScanningIfExternalClass(((AnnotationClassRef) annotationParamVal).getClassName(), "class ref", log);
            } else if (annotationParamVal.getClass().isArray()) {
                int n = Array.getLength(annotationParamVal);
                for (int i = 0; i < n; i++) {
                    extendScanningUpwardsFromAnnotationParameterValues(Array.get(annotationParamVal, i), log);
                }
            }
        }
    }

    private void extendScanningUpwards(LogNode log) {
        if (this.superclassName != null) {
            scheduleScanningIfExternalClass(this.superclassName, "superclass", log);
        }
        if (this.implementedInterfaces != null) {
            for (String interfaceName : this.implementedInterfaces) {
                scheduleScanningIfExternalClass(interfaceName, "interface", log);
            }
        }
        if (this.classAnnotations != null) {
            Iterator it = this.classAnnotations.iterator();
            while (it.hasNext()) {
                AnnotationInfo annotationInfo = (AnnotationInfo) it.next();
                scheduleScanningIfExternalClass(annotationInfo.getName(), "class annotation", log);
                extendScanningUpwardsFromAnnotationParameterValues(annotationInfo, log);
            }
        }
        if (this.annotationParamDefaultValues != null) {
            Iterator it2 = this.annotationParamDefaultValues.iterator();
            while (it2.hasNext()) {
                extendScanningUpwardsFromAnnotationParameterValues(((AnnotationParameterValue) it2.next()).getValue(), log);
            }
        }
        if (this.methodInfoList != null) {
            Iterator it3 = this.methodInfoList.iterator();
            while (it3.hasNext()) {
                MethodInfo methodInfo = (MethodInfo) it3.next();
                if (methodInfo.annotationInfo != null) {
                    Iterator it4 = methodInfo.annotationInfo.iterator();
                    while (it4.hasNext()) {
                        AnnotationInfo methodAnnotationInfo = (AnnotationInfo) it4.next();
                        scheduleScanningIfExternalClass(methodAnnotationInfo.getName(), "method annotation", log);
                        extendScanningUpwardsFromAnnotationParameterValues(methodAnnotationInfo, log);
                    }
                    if (methodInfo.parameterAnnotationInfo != null && methodInfo.parameterAnnotationInfo.length > 0) {
                        AnnotationInfo[][] annotationInfoArr = methodInfo.parameterAnnotationInfo;
                        for (AnnotationInfo[] paramAnnInfoArr : annotationInfoArr) {
                            if (paramAnnInfoArr != null && paramAnnInfoArr.length > 0) {
                                for (AnnotationInfo paramAnnInfo : paramAnnInfoArr) {
                                    scheduleScanningIfExternalClass(paramAnnInfo.getName(), "method parameter annotation", log);
                                    extendScanningUpwardsFromAnnotationParameterValues(paramAnnInfo, log);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (this.fieldInfoList != null) {
            Iterator it5 = this.fieldInfoList.iterator();
            while (it5.hasNext()) {
                FieldInfo fieldInfo = (FieldInfo) it5.next();
                if (fieldInfo.annotationInfo != null) {
                    Iterator it6 = fieldInfo.annotationInfo.iterator();
                    while (it6.hasNext()) {
                        AnnotationInfo fieldAnnotationInfo = (AnnotationInfo) it6.next();
                        scheduleScanningIfExternalClass(fieldAnnotationInfo.getName(), "field annotation", log);
                        extendScanningUpwardsFromAnnotationParameterValues(fieldAnnotationInfo, log);
                    }
                }
            }
        }
        if (this.classContainmentEntries != null) {
            for (ClassContainment classContainmentEntry : this.classContainmentEntries) {
                if (classContainmentEntry.innerClassName.equals(this.className)) {
                    scheduleScanningIfExternalClass(classContainmentEntry.outerClassName, "outer class", log);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void link(Map<String, ClassInfo> classNameToClassInfo, Map<String, PackageInfo> packageNameToPackageInfo, Map<String, ModuleInfo> moduleNameToModuleInfo) {
        boolean isModuleDescriptor = false;
        boolean isPackageDescriptor = false;
        ClassInfo classInfo = null;
        if (this.className.equals("module-info")) {
            isModuleDescriptor = true;
        } else if (this.className.equals(PackageDescription.PACKAGE_CLASS_NAME) || this.className.endsWith(".package-info")) {
            isPackageDescriptor = true;
        } else {
            classInfo = ClassInfo.addScannedClass(this.className, this.classModifiers, this.isExternalClass, classNameToClassInfo, this.classpathElement, this.classfileResource);
            classInfo.setClassfileVersion(this.minorVersion, this.majorVersion);
            classInfo.setModifiers(this.classModifiers);
            classInfo.setIsInterface(this.isInterface);
            classInfo.setIsAnnotation(this.isAnnotation);
            classInfo.setIsRecord(this.isRecord);
            if (this.superclassName != null) {
                classInfo.addSuperclass(this.superclassName, classNameToClassInfo);
            }
            if (this.implementedInterfaces != null) {
                for (String interfaceName : this.implementedInterfaces) {
                    classInfo.addImplementedInterface(interfaceName, classNameToClassInfo);
                }
            }
            if (this.classAnnotations != null) {
                Iterator it = this.classAnnotations.iterator();
                while (it.hasNext()) {
                    classInfo.addClassAnnotation((AnnotationInfo) it.next(), classNameToClassInfo);
                }
            }
            if (this.classContainmentEntries != null) {
                ClassInfo.addClassContainment(this.classContainmentEntries, classNameToClassInfo);
            }
            if (this.annotationParamDefaultValues != null) {
                classInfo.addAnnotationParamDefaultValues(this.annotationParamDefaultValues);
            }
            if (this.fullyQualifiedDefiningMethodName != null) {
                classInfo.addFullyQualifiedDefiningMethodName(this.fullyQualifiedDefiningMethodName);
            }
            if (this.fieldInfoList != null) {
                classInfo.addFieldInfo(this.fieldInfoList, classNameToClassInfo);
            }
            if (this.methodInfoList != null) {
                classInfo.addMethodInfo(this.methodInfoList, classNameToClassInfo);
            }
            if (this.typeSignature != null) {
                classInfo.setTypeSignature(this.typeSignature);
            }
            if (this.refdClassNames != null) {
                classInfo.addReferencedClassNames(this.refdClassNames);
            }
        }
        PackageInfo packageInfo = null;
        if (!isModuleDescriptor) {
            packageInfo = PackageInfo.getOrCreatePackage(PackageInfo.getParentPackageName(this.className), packageNameToPackageInfo);
            if (isPackageDescriptor) {
                packageInfo.addAnnotations(this.classAnnotations);
            } else if (classInfo != null) {
                packageInfo.addClassInfo(classInfo);
                classInfo.packageInfo = packageInfo;
            }
        }
        String moduleName = this.classpathElement.getModuleName();
        if (moduleName != null) {
            ModuleInfo moduleInfo = moduleNameToModuleInfo.get(moduleName);
            if (moduleInfo == null) {
                ModuleInfo moduleInfo2 = new ModuleInfo(this.classfileResource.getModuleRef(), this.classpathElement);
                moduleInfo = moduleInfo2;
                moduleNameToModuleInfo.put(moduleName, moduleInfo2);
            }
            if (isModuleDescriptor) {
                moduleInfo.addAnnotations(this.classAnnotations);
            }
            if (classInfo != null) {
                moduleInfo.addClassInfo(classInfo);
                classInfo.moduleInfo = moduleInfo;
            }
            if (packageInfo != null) {
                moduleInfo.addPackageInfo(packageInfo);
            }
        }
    }

    private String intern(String str) {
        if (str == null) {
            return null;
        }
        String interned = this.stringInternMap.putIfAbsent(str, str);
        if (interned != null) {
            return interned;
        }
        return str;
    }

    private int getConstantPoolStringOffset(int cpIdx, int subFieldIdx) throws ClassfileFormatException {
        int cpIdxToUse;
        if (cpIdx < 1 || cpIdx >= this.cpCount) {
            throw new ClassfileFormatException("Constant pool index " + cpIdx + ", should be in range [1, " + (this.cpCount - 1) + "] -- cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
        }
        int t = this.entryTag[cpIdx];
        if ((t != 12 && subFieldIdx != 0) || (t == 12 && subFieldIdx != 0 && subFieldIdx != 1)) {
            throw new ClassfileFormatException("Bad subfield index " + subFieldIdx + " for tag " + t + ", cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
        } else if (t == 0) {
            return 0;
        } else {
            if (t == 1) {
                cpIdxToUse = cpIdx;
            } else if (t == 7 || t == 8 || t == 19) {
                int indirIdx = this.indirectStringRefs[cpIdx];
                if (indirIdx == -1) {
                    throw new ClassfileFormatException("Bad string indirection index, cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
                } else if (indirIdx == 0) {
                    return 0;
                } else {
                    cpIdxToUse = indirIdx;
                }
            } else if (t == 12) {
                int compoundIndirIdx = this.indirectStringRefs[cpIdx];
                if (compoundIndirIdx == -1) {
                    throw new ClassfileFormatException("Bad string indirection index, cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
                }
                int indirIdx2 = (subFieldIdx == 0 ? compoundIndirIdx >> 16 : compoundIndirIdx) & 65535;
                if (indirIdx2 == 0) {
                    throw new ClassfileFormatException("Bad string indirection index, cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
                }
                cpIdxToUse = indirIdx2;
            } else {
                throw new ClassfileFormatException("Wrong tag number " + t + " at constant pool index " + cpIdx + ", cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
            }
            if (cpIdxToUse >= 1 && cpIdxToUse < this.cpCount) {
                return this.entryOffset[cpIdxToUse];
            }
            throw new ClassfileFormatException("Constant pool index " + cpIdx + ", should be in range [1, " + (this.cpCount - 1) + "] -- cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
        }
    }

    private String getConstantPoolString(int cpIdx, boolean replaceSlashWithDot, boolean stripLSemicolon) throws ClassfileFormatException, IOException {
        int constantPoolStringOffset = getConstantPoolStringOffset(cpIdx, 0);
        if (constantPoolStringOffset == 0) {
            return null;
        }
        int utfLen = this.reader.readUnsignedShort((long) constantPoolStringOffset);
        if (utfLen == 0) {
            return "";
        }
        return intern(this.reader.readString(((long) constantPoolStringOffset) + 2, utfLen, replaceSlashWithDot, stripLSemicolon));
    }

    private String getConstantPoolString(int cpIdx, int subFieldIdx) throws ClassfileFormatException, IOException {
        int constantPoolStringOffset = getConstantPoolStringOffset(cpIdx, subFieldIdx);
        if (constantPoolStringOffset == 0) {
            return null;
        }
        int utfLen = this.reader.readUnsignedShort((long) constantPoolStringOffset);
        if (utfLen == 0) {
            return "";
        }
        return intern(this.reader.readString(((long) constantPoolStringOffset) + 2, utfLen, false, false));
    }

    private String getConstantPoolString(int cpIdx) throws ClassfileFormatException, IOException {
        return getConstantPoolString(cpIdx, 0);
    }

    private byte getConstantPoolStringFirstByte(int cpIdx) throws ClassfileFormatException, IOException {
        int constantPoolStringOffset = getConstantPoolStringOffset(cpIdx, 0);
        if (constantPoolStringOffset == 0 || this.reader.readUnsignedShort((long) constantPoolStringOffset) == 0) {
            return 0;
        }
        return this.reader.readByte(((long) constantPoolStringOffset) + 2);
    }

    private String getConstantPoolClassName(int cpIdx) throws ClassfileFormatException, IOException {
        return getConstantPoolString(cpIdx, true, false);
    }

    private String getConstantPoolClassDescriptor(int cpIdx) throws ClassfileFormatException, IOException {
        return getConstantPoolString(cpIdx, true, true);
    }

    private boolean constantPoolStringEquals(int cpIdx, String asciiStr) throws ClassfileFormatException, IOException {
        int cpStrLen;
        int cpStrOffset = getConstantPoolStringOffset(cpIdx, 0);
        if (cpStrOffset == 0) {
            return asciiStr == null;
        }
        if (asciiStr == null || (cpStrLen = this.reader.readUnsignedShort((long) cpStrOffset)) != asciiStr.length()) {
            return false;
        }
        int cpStrStart = cpStrOffset + 2;
        this.reader.bufferTo(cpStrStart + cpStrLen);
        byte[] buf = this.reader.buf();
        for (int i = 0; i < cpStrLen; i++) {
            if (((char) (buf[cpStrStart + i] & 255)) != asciiStr.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private int cpReadUnsignedShort(int cpIdx) throws IOException {
        if (cpIdx >= 1 && cpIdx < this.cpCount) {
            return this.reader.readUnsignedShort((long) this.entryOffset[cpIdx]);
        }
        throw new ClassfileFormatException("Constant pool index " + cpIdx + ", should be in range [1, " + (this.cpCount - 1) + "] -- cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
    }

    private int cpReadInt(int cpIdx) throws IOException {
        if (cpIdx >= 1 && cpIdx < this.cpCount) {
            return this.reader.readInt((long) this.entryOffset[cpIdx]);
        }
        throw new ClassfileFormatException("Constant pool index " + cpIdx + ", should be in range [1, " + (this.cpCount - 1) + "] -- cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
    }

    private long cpReadLong(int cpIdx) throws IOException {
        if (cpIdx >= 1 && cpIdx < this.cpCount) {
            return this.reader.readLong((long) this.entryOffset[cpIdx]);
        }
        throw new ClassfileFormatException("Constant pool index " + cpIdx + ", should be in range [1, " + (this.cpCount - 1) + "] -- cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
    }

    private Object getFieldConstantPoolValue(int tag, char fieldTypeDescriptorFirstChar, int cpIdx) throws ClassfileFormatException, IOException {
        switch (tag) {
            case 1:
            case 7:
            case 8:
                return getConstantPoolString(cpIdx);
            case 2:
            default:
                throw new ClassfileFormatException("Unknown constant pool tag " + tag + ", cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
            case 3:
                int intVal = cpReadInt(cpIdx);
                switch (fieldTypeDescriptorFirstChar) {
                    case 'B':
                        return Byte.valueOf((byte) intVal);
                    case 'C':
                        return Character.valueOf((char) intVal);
                    case 'I':
                        return Integer.valueOf(intVal);
                    case 'S':
                        return Short.valueOf((short) intVal);
                    case 'Z':
                        return Boolean.valueOf(intVal != 0);
                    default:
                        throw new ClassfileFormatException("Unknown Constant_INTEGER type " + fieldTypeDescriptorFirstChar + ", cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
                }
            case 4:
                return Float.valueOf(Float.intBitsToFloat(cpReadInt(cpIdx)));
            case 5:
                return Long.valueOf(cpReadLong(cpIdx));
            case 6:
                return Double.valueOf(Double.longBitsToDouble(cpReadLong(cpIdx)));
        }
    }

    private AnnotationInfo readAnnotation() throws IOException {
        String annotationClassName = getConstantPoolClassDescriptor(this.reader.readUnsignedShort());
        int numElementValuePairs = this.reader.readUnsignedShort();
        AnnotationParameterValueList paramVals = null;
        if (numElementValuePairs > 0) {
            paramVals = new AnnotationParameterValueList(numElementValuePairs);
            for (int i = 0; i < numElementValuePairs; i++) {
                paramVals.add(new AnnotationParameterValue(getConstantPoolString(this.reader.readUnsignedShort()), readAnnotationElementValue()));
            }
        }
        return new AnnotationInfo(annotationClassName, paramVals);
    }

    private Object readAnnotationElementValue() throws IOException {
        int tag = (char) this.reader.readUnsignedByte();
        switch (tag) {
            case 64:
                return readAnnotation();
            case 65:
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
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 100:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            default:
                throw new ClassfileFormatException("Class " + this.className + " has unknown annotation element type tag '" + ((char) tag) + "': element size unknown, cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
            case 66:
                return Byte.valueOf((byte) cpReadInt(this.reader.readUnsignedShort()));
            case 67:
                return Character.valueOf((char) cpReadInt(this.reader.readUnsignedShort()));
            case 68:
                return Double.valueOf(Double.longBitsToDouble(cpReadLong(this.reader.readUnsignedShort())));
            case 70:
                return Float.valueOf(Float.intBitsToFloat(cpReadInt(this.reader.readUnsignedShort())));
            case 73:
                return Integer.valueOf(cpReadInt(this.reader.readUnsignedShort()));
            case 74:
                return Long.valueOf(cpReadLong(this.reader.readUnsignedShort()));
            case 83:
                return Short.valueOf((short) cpReadUnsignedShort(this.reader.readUnsignedShort()));
            case 90:
                return Boolean.valueOf(cpReadInt(this.reader.readUnsignedShort()) != 0);
            case 91:
                int count = this.reader.readUnsignedShort();
                Object[] arr = new Object[count];
                for (int i = 0; i < count; i++) {
                    arr[i] = readAnnotationElementValue();
                }
                return arr;
            case 99:
                return new AnnotationClassRef(getConstantPoolString(this.reader.readUnsignedShort()));
            case 101:
                return new AnnotationEnumValue(getConstantPoolClassDescriptor(this.reader.readUnsignedShort()), getConstantPoolString(this.reader.readUnsignedShort()));
            case 115:
                return getConstantPoolString(this.reader.readUnsignedShort());
        }
    }

    private void readConstantPoolEntries() throws IOException {
        List<Integer> classNameCpIdxs = null;
        List<Integer> typeSignatureIdxs = null;
        if (this.scanSpec.enableInterClassDependencies) {
            classNameCpIdxs = new ArrayList<>();
            typeSignatureIdxs = new ArrayList<>();
        }
        this.cpCount = this.reader.readUnsignedShort();
        this.entryOffset = new int[this.cpCount];
        this.entryTag = new int[this.cpCount];
        this.indirectStringRefs = new int[this.cpCount];
        Arrays.fill(this.indirectStringRefs, 0, this.cpCount, -1);
        int skipSlot = 0;
        for (int i = 1; i < this.cpCount; i++) {
            if (skipSlot == 1) {
                skipSlot = 0;
            } else {
                this.entryTag[i] = this.reader.readUnsignedByte();
                this.entryOffset[i] = this.reader.currPos();
                switch (this.entryTag[i]) {
                    case 0:
                        throw new ClassfileFormatException("Unknown constant pool tag 0 in classfile " + this.relativePath + " (possible buffer underflow issue). Please report this at https://github.com/classgraph/classgraph/issues");
                    case 1:
                        this.reader.skip(this.reader.readUnsignedShort());
                        continue;
                    case 2:
                    case 13:
                    case 14:
                    case 17:
                    default:
                        throw new ClassfileFormatException("Unknown constant pool tag " + this.entryTag[i] + " (element size unknown, cannot continue reading class). Please report this at https://github.com/classgraph/classgraph/issues");
                    case 3:
                    case 4:
                        this.reader.skip(4);
                        continue;
                    case 5:
                    case 6:
                        this.reader.skip(8);
                        skipSlot = 1;
                        continue;
                    case 7:
                        this.indirectStringRefs[i] = this.reader.readUnsignedShort();
                        if (classNameCpIdxs != null) {
                            classNameCpIdxs.add(Integer.valueOf(this.indirectStringRefs[i]));
                            break;
                        } else {
                            continue;
                        }
                    case 8:
                        this.indirectStringRefs[i] = this.reader.readUnsignedShort();
                        continue;
                    case 9:
                        this.reader.skip(4);
                        continue;
                    case 10:
                        this.reader.skip(4);
                        continue;
                    case 11:
                        this.reader.skip(4);
                        continue;
                    case 12:
                        int nameRef = this.reader.readUnsignedShort();
                        int typeRef = this.reader.readUnsignedShort();
                        if (typeSignatureIdxs != null) {
                            typeSignatureIdxs.add(Integer.valueOf(typeRef));
                        }
                        this.indirectStringRefs[i] = (nameRef << 16) | typeRef;
                        continue;
                    case 15:
                        this.reader.skip(3);
                        continue;
                    case 16:
                        this.reader.skip(2);
                        continue;
                    case 18:
                        this.reader.skip(4);
                        continue;
                    case 19:
                        this.indirectStringRefs[i] = this.reader.readUnsignedShort();
                        continue;
                    case 20:
                        this.reader.skip(2);
                        continue;
                }
            }
        }
        if (classNameCpIdxs != null) {
            this.refdClassNames = new HashSet();
            for (Integer num : classNameCpIdxs) {
                String refdClassName = getConstantPoolString(num.intValue(), true, false);
                if (refdClassName != null) {
                    if (refdClassName.startsWith("[")) {
                        try {
                            TypeSignature.parse(refdClassName.replace('.', '/'), (String) null).findReferencedClassNames(this.refdClassNames);
                        } catch (ParseException e) {
                            throw new ClassfileFormatException("Could not parse class name: " + refdClassName, e);
                        }
                    } else {
                        this.refdClassNames.add(refdClassName);
                    }
                }
            }
        }
        if (typeSignatureIdxs != null) {
            for (Integer num2 : typeSignatureIdxs) {
                String typeSigStr = getConstantPoolString(num2.intValue());
                if (typeSigStr != null) {
                    try {
                        if (typeSigStr.indexOf(40) >= 0 || "<init>".equals(typeSigStr)) {
                            MethodTypeSignature.parse(typeSigStr, null).findReferencedClassNames(this.refdClassNames);
                        } else {
                            TypeSignature.parse(typeSigStr, (String) null).findReferencedClassNames(this.refdClassNames);
                        }
                    } catch (ParseException e2) {
                        throw new ClassfileFormatException("Could not parse type signature: " + typeSigStr, e2);
                    }
                }
            }
        }
    }

    private void readBasicClassInfo() throws IOException, ClassfileFormatException, SkipClassException {
        this.classModifiers = this.reader.readUnsignedShort();
        this.isInterface = (this.classModifiers & 512) != 0;
        this.isAnnotation = (this.classModifiers & 8192) != 0;
        String classNamePath = getConstantPoolString(this.reader.readUnsignedShort());
        if (classNamePath == null) {
            throw new ClassfileFormatException("Class name is null");
        }
        this.className = classNamePath.replace('/', '.');
        if ("java.lang.Object".equals(this.className)) {
            throw new SkipClassException("No need to scan java.lang.Object");
        }
        boolean isModule = (this.classModifiers & 32768) != 0;
        boolean isPackage = this.relativePath.regionMatches(this.relativePath.lastIndexOf(47) + 1, "package-info.class", 0, 18);
        if (!this.scanSpec.ignoreClassVisibility && !Modifier.isPublic(this.classModifiers) && !isModule && !isPackage) {
            throw new SkipClassException("Class is not public, and ignoreClassVisibility() was not called");
        } else if (!this.relativePath.endsWith(".class")) {
            throw new SkipClassException("Classfile filename " + this.relativePath + " does not end in \".class\"");
        } else {
            int len = classNamePath.length();
            if (this.relativePath.length() != len + 6 || !classNamePath.regionMatches(0, this.relativePath, 0, len)) {
                throw new SkipClassException("Relative path " + this.relativePath + " does not match class name " + this.className);
            }
            int superclassNameCpIdx = this.reader.readUnsignedShort();
            if (superclassNameCpIdx > 0) {
                this.superclassName = getConstantPoolClassName(superclassNameCpIdx);
            }
        }
    }

    private void readInterfaces() throws IOException {
        int interfaceCount = this.reader.readUnsignedShort();
        for (int i = 0; i < interfaceCount; i++) {
            String interfaceName = getConstantPoolClassName(this.reader.readUnsignedShort());
            if (this.implementedInterfaces == null) {
                this.implementedInterfaces = new ArrayList();
            }
            this.implementedInterfaces.add(interfaceName);
        }
    }

    private void readFields() throws IOException, ClassfileFormatException {
        int fieldCount = this.reader.readUnsignedShort();
        for (int i = 0; i < fieldCount; i++) {
            int fieldModifierFlags = this.reader.readUnsignedShort();
            boolean fieldIsVisible = ((fieldModifierFlags & 1) == 1) || this.scanSpec.ignoreFieldVisibility;
            boolean getStaticFinalFieldConstValue = this.scanSpec.enableStaticFinalFieldConstantInitializerValues && fieldIsVisible;
            if (!fieldIsVisible || (!this.scanSpec.enableFieldInfo && !getStaticFinalFieldConstValue)) {
                this.reader.readUnsignedShort();
                this.reader.readUnsignedShort();
                int attributesCount = this.reader.readUnsignedShort();
                for (int j = 0; j < attributesCount; j++) {
                    this.reader.readUnsignedShort();
                    this.reader.skip(this.reader.readInt());
                }
            } else {
                String fieldName = getConstantPoolString(this.reader.readUnsignedShort());
                int fieldTypeDescriptorCpIdx = this.reader.readUnsignedShort();
                char fieldTypeDescriptorFirstChar = (char) getConstantPoolStringFirstByte(fieldTypeDescriptorCpIdx);
                String fieldTypeSignature = null;
                String fieldTypeDescriptor = getConstantPoolString(fieldTypeDescriptorCpIdx);
                Object fieldConstValue = null;
                AnnotationInfoList fieldAnnotationInfo = null;
                int attributesCount2 = this.reader.readUnsignedShort();
                for (int j2 = 0; j2 < attributesCount2; j2++) {
                    int attributeNameCpIdx = this.reader.readUnsignedShort();
                    int attributeLength = this.reader.readInt();
                    if (getStaticFinalFieldConstValue && constantPoolStringEquals(attributeNameCpIdx, ConstantAttribute.tag)) {
                        int cpIdx = this.reader.readUnsignedShort();
                        if (cpIdx < 1 || cpIdx >= this.cpCount) {
                            throw new ClassfileFormatException("Constant pool index " + cpIdx + ", should be in range [1, " + (this.cpCount - 1) + "] -- cannot continue reading class. Please report this at https://github.com/classgraph/classgraph/issues");
                        }
                        fieldConstValue = getFieldConstantPoolValue(this.entryTag[cpIdx], fieldTypeDescriptorFirstChar, cpIdx);
                    } else if (fieldIsVisible && constantPoolStringEquals(attributeNameCpIdx, SignatureAttribute.tag)) {
                        fieldTypeSignature = getConstantPoolString(this.reader.readUnsignedShort());
                    } else if (!this.scanSpec.enableAnnotationInfo || (!constantPoolStringEquals(attributeNameCpIdx, AnnotationsAttribute.visibleTag) && (this.scanSpec.disableRuntimeInvisibleAnnotations || !constantPoolStringEquals(attributeNameCpIdx, AnnotationsAttribute.invisibleTag)))) {
                        this.reader.skip(attributeLength);
                    } else {
                        int fieldAnnotationCount = this.reader.readUnsignedShort();
                        if (fieldAnnotationCount > 0) {
                            if (fieldAnnotationInfo == null) {
                                fieldAnnotationInfo = new AnnotationInfoList(1);
                            }
                            for (int k = 0; k < fieldAnnotationCount; k++) {
                                fieldAnnotationInfo.add(readAnnotation());
                            }
                        }
                    }
                }
                if (this.scanSpec.enableFieldInfo && fieldIsVisible) {
                    if (this.fieldInfoList == null) {
                        this.fieldInfoList = new FieldInfoList();
                    }
                    this.fieldInfoList.add(new FieldInfo(this.className, fieldName, fieldModifierFlags, fieldTypeDescriptor, fieldTypeSignature, fieldConstValue, fieldAnnotationInfo));
                }
            }
        }
    }

    private void readMethods() throws IOException, ClassfileFormatException {
        int methodCount = this.reader.readUnsignedShort();
        for (int i = 0; i < methodCount; i++) {
            int methodModifierFlags = this.reader.readUnsignedShort();
            boolean methodIsVisible = ((methodModifierFlags & 1) == 1) || this.scanSpec.ignoreMethodVisibility;
            String methodName = null;
            String methodTypeDescriptor = null;
            String methodTypeSignature = null;
            boolean enableMethodInfo = this.scanSpec.enableMethodInfo || this.isAnnotation;
            if (enableMethodInfo || this.isAnnotation) {
                methodName = getConstantPoolString(this.reader.readUnsignedShort());
                methodTypeDescriptor = getConstantPoolString(this.reader.readUnsignedShort());
            } else {
                this.reader.skip(4);
            }
            int attributesCount = this.reader.readUnsignedShort();
            String[] methodParameterNames = null;
            int[] methodParameterModifiers = null;
            AnnotationInfo[][] methodParameterAnnotations = null;
            AnnotationInfoList methodAnnotationInfo = null;
            boolean methodHasBody = false;
            if (!methodIsVisible || (!enableMethodInfo && !this.isAnnotation)) {
                for (int j = 0; j < attributesCount; j++) {
                    this.reader.skip(2);
                    this.reader.skip(this.reader.readInt());
                }
            } else {
                for (int j2 = 0; j2 < attributesCount; j2++) {
                    int attributeNameCpIdx = this.reader.readUnsignedShort();
                    int attributeLength = this.reader.readInt();
                    if (this.scanSpec.enableAnnotationInfo && (constantPoolStringEquals(attributeNameCpIdx, AnnotationsAttribute.visibleTag) || (!this.scanSpec.disableRuntimeInvisibleAnnotations && constantPoolStringEquals(attributeNameCpIdx, AnnotationsAttribute.invisibleTag)))) {
                        int methodAnnotationCount = this.reader.readUnsignedShort();
                        if (methodAnnotationCount > 0) {
                            if (methodAnnotationInfo == null) {
                                methodAnnotationInfo = new AnnotationInfoList(1);
                            }
                            for (int k = 0; k < methodAnnotationCount; k++) {
                                methodAnnotationInfo.add(readAnnotation());
                            }
                        }
                    } else if (this.scanSpec.enableAnnotationInfo && (constantPoolStringEquals(attributeNameCpIdx, ParameterAnnotationsAttribute.visibleTag) || (!this.scanSpec.disableRuntimeInvisibleAnnotations && constantPoolStringEquals(attributeNameCpIdx, ParameterAnnotationsAttribute.invisibleTag)))) {
                        int numParams = this.reader.readUnsignedByte();
                        if (methodParameterAnnotations == null) {
                            methodParameterAnnotations = new AnnotationInfo[numParams];
                        } else if (methodParameterAnnotations.length != numParams) {
                            throw new ClassfileFormatException("Mismatch in number of parameters between RuntimeVisibleParameterAnnotations and RuntimeInvisibleParameterAnnotations");
                        }
                        for (int paramIdx = 0; paramIdx < numParams; paramIdx++) {
                            int numAnnotations = this.reader.readUnsignedShort();
                            if (numAnnotations > 0) {
                                int annStartIdx = 0;
                                if (methodParameterAnnotations[paramIdx] != null) {
                                    annStartIdx = methodParameterAnnotations[paramIdx].length;
                                    methodParameterAnnotations[paramIdx] = (AnnotationInfo[]) Arrays.copyOf(methodParameterAnnotations[paramIdx], annStartIdx + numAnnotations);
                                } else {
                                    methodParameterAnnotations[paramIdx] = new AnnotationInfo[numAnnotations];
                                }
                                for (int annIdx = 0; annIdx < numAnnotations; annIdx++) {
                                    methodParameterAnnotations[paramIdx][annStartIdx + annIdx] = readAnnotation();
                                }
                            } else if (methodParameterAnnotations[paramIdx] == null) {
                                methodParameterAnnotations[paramIdx] = NO_ANNOTATIONS;
                            }
                        }
                    } else if (constantPoolStringEquals(attributeNameCpIdx, MethodParametersAttribute.tag)) {
                        int paramCount = this.reader.readUnsignedByte();
                        methodParameterNames = new String[paramCount];
                        methodParameterModifiers = new int[paramCount];
                        for (int k2 = 0; k2 < paramCount; k2++) {
                            int cpIdx = this.reader.readUnsignedShort();
                            methodParameterNames[k2] = cpIdx == 0 ? null : getConstantPoolString(cpIdx);
                            methodParameterModifiers[k2] = this.reader.readUnsignedShort();
                        }
                    } else if (constantPoolStringEquals(attributeNameCpIdx, SignatureAttribute.tag)) {
                        methodTypeSignature = getConstantPoolString(this.reader.readUnsignedShort());
                    } else if (constantPoolStringEquals(attributeNameCpIdx, AnnotationDefaultAttribute.tag)) {
                        if (this.annotationParamDefaultValues == null) {
                            this.annotationParamDefaultValues = new AnnotationParameterValueList();
                        }
                        this.annotationParamDefaultValues.add(new AnnotationParameterValue(methodName, readAnnotationElementValue()));
                    } else if (constantPoolStringEquals(attributeNameCpIdx, CodeAttribute.tag)) {
                        methodHasBody = true;
                        this.reader.skip(attributeLength);
                    } else {
                        this.reader.skip(attributeLength);
                    }
                }
                if (enableMethodInfo) {
                    if (this.methodInfoList == null) {
                        this.methodInfoList = new MethodInfoList();
                    }
                    this.methodInfoList.add(new MethodInfo(this.className, methodName, methodAnnotationInfo, methodModifierFlags, methodTypeDescriptor, methodTypeSignature, methodParameterNames, methodParameterModifiers, methodParameterAnnotations, methodHasBody));
                }
            }
        }
    }

    private void readClassAttributes() throws IOException, ClassfileFormatException {
        String definingMethodName;
        int attributesCount = this.reader.readUnsignedShort();
        for (int i = 0; i < attributesCount; i++) {
            int attributeNameCpIdx = this.reader.readUnsignedShort();
            int attributeLength = this.reader.readInt();
            if (this.scanSpec.enableAnnotationInfo && (constantPoolStringEquals(attributeNameCpIdx, AnnotationsAttribute.visibleTag) || (!this.scanSpec.disableRuntimeInvisibleAnnotations && constantPoolStringEquals(attributeNameCpIdx, AnnotationsAttribute.invisibleTag)))) {
                int annotationCount = this.reader.readUnsignedShort();
                if (annotationCount > 0) {
                    if (this.classAnnotations == null) {
                        this.classAnnotations = new AnnotationInfoList();
                    }
                    for (int m = 0; m < annotationCount; m++) {
                        this.classAnnotations.add(readAnnotation());
                    }
                }
            } else if (constantPoolStringEquals(attributeNameCpIdx, "Record")) {
                this.isRecord = true;
                this.reader.skip(attributeLength);
            } else if (constantPoolStringEquals(attributeNameCpIdx, InnerClassesAttribute.tag)) {
                int numInnerClasses = this.reader.readUnsignedShort();
                for (int j = 0; j < numInnerClasses; j++) {
                    int innerClassInfoCpIdx = this.reader.readUnsignedShort();
                    int outerClassInfoCpIdx = this.reader.readUnsignedShort();
                    this.reader.skip(2);
                    int innerClassAccessFlags = this.reader.readUnsignedShort();
                    if (!(innerClassInfoCpIdx == 0 || outerClassInfoCpIdx == 0)) {
                        String innerClassName = getConstantPoolClassName(innerClassInfoCpIdx);
                        String outerClassName = getConstantPoolClassName(outerClassInfoCpIdx);
                        if (innerClassName == null || outerClassName == null) {
                            throw new ClassfileFormatException("Inner and/or outer class name is null");
                        } else if (innerClassName.equals(outerClassName)) {
                            throw new ClassfileFormatException("Inner and outer class name cannot be the same");
                        } else if (!"java.lang.invoke.MethodHandles$Lookup".equals(innerClassName) || !"java.lang.invoke.MethodHandles".equals(outerClassName)) {
                            if (this.classContainmentEntries == null) {
                                this.classContainmentEntries = new ArrayList();
                            }
                            this.classContainmentEntries.add(new ClassContainment(innerClassName, innerClassAccessFlags, outerClassName));
                        }
                    }
                }
                continue;
            } else if (constantPoolStringEquals(attributeNameCpIdx, SignatureAttribute.tag)) {
                this.typeSignature = getConstantPoolString(this.reader.readUnsignedShort());
            } else if (constantPoolStringEquals(attributeNameCpIdx, EnclosingMethodAttribute.tag)) {
                String innermostEnclosingClassName = getConstantPoolClassName(this.reader.readUnsignedShort());
                int enclosingMethodCpIdx = this.reader.readUnsignedShort();
                if (enclosingMethodCpIdx == 0) {
                    definingMethodName = "<clinit>";
                } else {
                    definingMethodName = getConstantPoolString(enclosingMethodCpIdx, 0);
                }
                if (this.classContainmentEntries == null) {
                    this.classContainmentEntries = new ArrayList();
                }
                this.classContainmentEntries.add(new ClassContainment(this.className, this.classModifiers, innermostEnclosingClassName));
                this.fullyQualifiedDefiningMethodName = innermostEnclosingClassName + Mapper.IGNORED_FIELDNAME + definingMethodName;
            } else if (constantPoolStringEquals(attributeNameCpIdx, "Module")) {
                this.classpathElement.moduleNameFromModuleDescriptor = getConstantPoolString(this.reader.readUnsignedShort());
                this.reader.skip(attributeLength - 2);
            } else {
                this.reader.skip(attributeLength);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Classfile(ClasspathElement classpathElement, List<ClasspathElement> classpathOrder, Set<String> whitelistedClassNamesFound, Set<String> classNamesScheduledForExtendedScanning, String relativePath, Resource classfileResource, boolean isExternalClass, ConcurrentHashMap<String, String> stringInternMap, WorkQueue<Scanner.ClassfileScanWorkUnit> workQueue, ScanSpec scanSpec, LogNode log) throws IOException, ClassfileFormatException, SkipClassException {
        LogNode subLog;
        this.classpathElement = classpathElement;
        this.classpathOrder = classpathOrder;
        this.relativePath = relativePath;
        this.whitelistedClassNamesFound = whitelistedClassNamesFound;
        this.classNamesScheduledForExtendedScanning = classNamesScheduledForExtendedScanning;
        this.classfileResource = classfileResource;
        this.isExternalClass = isExternalClass;
        this.stringInternMap = stringInternMap;
        this.scanSpec = scanSpec;
        try {
            this.reader = classfileResource.openClassfile();
            if (this.reader.readInt() != -889275714) {
                throw new ClassfileFormatException("Classfile does not have correct magic number");
            }
            this.minorVersion = this.reader.readUnsignedShort();
            this.majorVersion = this.reader.readUnsignedShort();
            readConstantPoolEntries();
            readBasicClassInfo();
            readInterfaces();
            readFields();
            readMethods();
            readClassAttributes();
            classfileResource.close();
            this.reader = null;
            if (log == null) {
                subLog = null;
            } else {
                subLog = log.log("Found " + (this.isAnnotation ? "annotation class" : this.isInterface ? "interface class" : "class") + " " + this.className);
            }
            if (subLog != null) {
                if (this.superclassName != null) {
                    subLog.log("Super" + ((!this.isInterface || this.isAnnotation) ? "class" : "interface") + ": " + this.superclassName);
                }
                if (this.implementedInterfaces != null) {
                    subLog.log("Interfaces: " + Join.join(", ", this.implementedInterfaces));
                }
                if (this.classAnnotations != null) {
                    subLog.log("Class annotations: " + Join.join(", ", this.classAnnotations));
                }
                if (this.annotationParamDefaultValues != null) {
                    Iterator it = this.annotationParamDefaultValues.iterator();
                    while (it.hasNext()) {
                        subLog.log("Annotation default param value: " + ((AnnotationParameterValue) it.next()));
                    }
                }
                if (this.fieldInfoList != null) {
                    Iterator it2 = this.fieldInfoList.iterator();
                    while (it2.hasNext()) {
                        subLog.log("Field: " + ((FieldInfo) it2.next()));
                    }
                }
                if (this.methodInfoList != null) {
                    Iterator it3 = this.methodInfoList.iterator();
                    while (it3.hasNext()) {
                        subLog.log("Method: " + ((MethodInfo) it3.next()));
                    }
                }
                if (this.typeSignature != null) {
                    ClassTypeSignature typeSig = null;
                    try {
                        typeSig = ClassTypeSignature.parse(this.typeSignature, null);
                        if (this.refdClassNames != null) {
                            typeSig.findReferencedClassNames(this.refdClassNames);
                        }
                    } catch (ParseException e) {
                    }
                    subLog.log("Class type signature: " + (typeSig == null ? this.typeSignature : typeSig.toString(this.className, false, this.classModifiers, this.isAnnotation, this.isInterface)));
                }
                if (this.refdClassNames != null) {
                    List<String> refdClassNamesSorted = new ArrayList<>(this.refdClassNames);
                    CollectionUtils.sortIfNotEmpty(refdClassNamesSorted);
                    subLog.log("Referenced class names: " + Join.join(", ", refdClassNamesSorted));
                }
            }
            if (scanSpec.extendScanningUpwardsToExternalClasses) {
                extendScanningUpwards(subLog);
                if (this.additionalWorkUnits != null) {
                    workQueue.addWorkUnits(this.additionalWorkUnits);
                }
            }
        } catch (Throwable th) {
            classfileResource.close();
            this.reader = null;
            throw th;
        }
    }
}
