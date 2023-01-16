package com.google.protobuf;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.FieldSet;
import com.google.protobuf.Internal;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import dev.morphia.mapping.Mapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.logging.Logger;
import net.bytebuddy.utility.JavaConstant;

/* loaded from: grasscutter.jar:com/google/protobuf/Descriptors.class */
public final class Descriptors {
    private static final Logger logger = Logger.getLogger(Descriptors.class.getName());

    /* loaded from: grasscutter.jar:com/google/protobuf/Descriptors$FileDescriptor.class */
    public static final class FileDescriptor extends GenericDescriptor {
        private DescriptorProtos.FileDescriptorProto proto;
        private final Descriptor[] messageTypes;
        private final EnumDescriptor[] enumTypes;
        private final ServiceDescriptor[] services;
        private final FieldDescriptor[] extensions;
        private final FileDescriptor[] dependencies;
        private final FileDescriptor[] publicDependencies;
        private final DescriptorPool pool;

        @Deprecated
        /* loaded from: grasscutter.jar:com/google/protobuf/Descriptors$FileDescriptor$InternalDescriptorAssigner.class */
        public interface InternalDescriptorAssigner {
            ExtensionRegistry assignDescriptors(FileDescriptor fileDescriptor);
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.FileDescriptorProto toProto() {
            return this.proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.proto.getName();
        }

        public String getPackage() {
            return this.proto.getPackage();
        }

        public DescriptorProtos.FileOptions getOptions() {
            return this.proto.getOptions();
        }

        public List<Descriptor> getMessageTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.messageTypes));
        }

        public List<EnumDescriptor> getEnumTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
        }

        public List<ServiceDescriptor> getServices() {
            return Collections.unmodifiableList(Arrays.asList(this.services));
        }

        public List<FieldDescriptor> getExtensions() {
            return Collections.unmodifiableList(Arrays.asList(this.extensions));
        }

        public List<FileDescriptor> getDependencies() {
            return Collections.unmodifiableList(Arrays.asList(this.dependencies));
        }

        public List<FileDescriptor> getPublicDependencies() {
            return Collections.unmodifiableList(Arrays.asList(this.publicDependencies));
        }

        /* loaded from: grasscutter.jar:com/google/protobuf/Descriptors$FileDescriptor$Syntax.class */
        public enum Syntax {
            UNKNOWN("unknown"),
            PROTO2("proto2"),
            PROTO3("proto3");
            
            private final String name;

            Syntax(String name) {
                this.name = name;
            }
        }

        public Syntax getSyntax() {
            if (Syntax.PROTO3.name.equals(this.proto.getSyntax())) {
                return Syntax.PROTO3;
            }
            return Syntax.PROTO2;
        }

        public Descriptor findMessageTypeByName(String name) {
            if (name.indexOf(46) != -1) {
                return null;
            }
            String packageName = getPackage();
            if (!packageName.isEmpty()) {
                name = packageName + '.' + name;
            }
            GenericDescriptor result = this.pool.findSymbol(name);
            if (!(result instanceof Descriptor) || result.getFile() != this) {
                return null;
            }
            return (Descriptor) result;
        }

        public EnumDescriptor findEnumTypeByName(String name) {
            if (name.indexOf(46) != -1) {
                return null;
            }
            String packageName = getPackage();
            if (!packageName.isEmpty()) {
                name = packageName + '.' + name;
            }
            GenericDescriptor result = this.pool.findSymbol(name);
            if (!(result instanceof EnumDescriptor) || result.getFile() != this) {
                return null;
            }
            return (EnumDescriptor) result;
        }

        public ServiceDescriptor findServiceByName(String name) {
            if (name.indexOf(46) != -1) {
                return null;
            }
            String packageName = getPackage();
            if (!packageName.isEmpty()) {
                name = packageName + '.' + name;
            }
            GenericDescriptor result = this.pool.findSymbol(name);
            if (!(result instanceof ServiceDescriptor) || result.getFile() != this) {
                return null;
            }
            return (ServiceDescriptor) result;
        }

        public FieldDescriptor findExtensionByName(String name) {
            if (name.indexOf(46) != -1) {
                return null;
            }
            String packageName = getPackage();
            if (!packageName.isEmpty()) {
                name = packageName + '.' + name;
            }
            GenericDescriptor result = this.pool.findSymbol(name);
            if (!(result instanceof FieldDescriptor) || result.getFile() != this) {
                return null;
            }
            return (FieldDescriptor) result;
        }

        public static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto proto, FileDescriptor[] dependencies) throws DescriptorValidationException {
            return buildFrom(proto, dependencies, false);
        }

        public static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto proto, FileDescriptor[] dependencies, boolean allowUnknownDependencies) throws DescriptorValidationException {
            FileDescriptor result = new FileDescriptor(proto, dependencies, new DescriptorPool(dependencies, allowUnknownDependencies), allowUnknownDependencies);
            result.crossLink();
            return result;
        }

        private static byte[] latin1Cat(String[] strings) {
            if (strings.length == 1) {
                return strings[0].getBytes(Internal.ISO_8859_1);
            }
            StringBuilder descriptorData = new StringBuilder();
            for (String part : strings) {
                descriptorData.append(part);
            }
            return descriptorData.toString().getBytes(Internal.ISO_8859_1);
        }

        private static FileDescriptor[] findDescriptors(Class<?> descriptorOuterClass, String[] dependencyClassNames, String[] dependencyFileNames) {
            List<FileDescriptor> descriptors = new ArrayList<>();
            for (int i = 0; i < dependencyClassNames.length; i++) {
                try {
                    descriptors.add((FileDescriptor) descriptorOuterClass.getClassLoader().loadClass(dependencyClassNames[i]).getField("descriptor").get(null));
                } catch (Exception e) {
                    Descriptors.logger.warning("Descriptors for \"" + dependencyFileNames[i] + "\" can not be found.");
                }
            }
            return (FileDescriptor[]) descriptors.toArray(new FileDescriptor[0]);
        }

        @Deprecated
        public static void internalBuildGeneratedFileFrom(String[] descriptorDataParts, FileDescriptor[] dependencies, InternalDescriptorAssigner descriptorAssigner) {
            byte[] descriptorBytes = latin1Cat(descriptorDataParts);
            try {
                DescriptorProtos.FileDescriptorProto proto = DescriptorProtos.FileDescriptorProto.parseFrom(descriptorBytes);
                try {
                    FileDescriptor result = buildFrom(proto, dependencies, true);
                    ExtensionRegistry registry = descriptorAssigner.assignDescriptors(result);
                    if (registry != null) {
                        try {
                            result.setProto(DescriptorProtos.FileDescriptorProto.parseFrom(descriptorBytes, registry));
                        } catch (InvalidProtocolBufferException e) {
                            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
                        }
                    }
                } catch (DescriptorValidationException e2) {
                    throw new IllegalArgumentException("Invalid embedded descriptor for \"" + proto.getName() + "\".", e2);
                }
            } catch (InvalidProtocolBufferException e3) {
                throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e3);
            }
        }

        public static FileDescriptor internalBuildGeneratedFileFrom(String[] descriptorDataParts, FileDescriptor[] dependencies) {
            try {
                DescriptorProtos.FileDescriptorProto proto = DescriptorProtos.FileDescriptorProto.parseFrom(latin1Cat(descriptorDataParts));
                try {
                    return buildFrom(proto, dependencies, true);
                } catch (DescriptorValidationException e) {
                    throw new IllegalArgumentException("Invalid embedded descriptor for \"" + proto.getName() + "\".", e);
                }
            } catch (InvalidProtocolBufferException e2) {
                throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e2);
            }
        }

        @Deprecated
        public static void internalBuildGeneratedFileFrom(String[] descriptorDataParts, Class<?> descriptorOuterClass, String[] dependencyClassNames, String[] dependencyFileNames, InternalDescriptorAssigner descriptorAssigner) {
            internalBuildGeneratedFileFrom(descriptorDataParts, findDescriptors(descriptorOuterClass, dependencyClassNames, dependencyFileNames), descriptorAssigner);
        }

        public static FileDescriptor internalBuildGeneratedFileFrom(String[] descriptorDataParts, Class<?> descriptorOuterClass, String[] dependencyClassNames, String[] dependencyFileNames) {
            return internalBuildGeneratedFileFrom(descriptorDataParts, findDescriptors(descriptorOuterClass, dependencyClassNames, dependencyFileNames));
        }

        public static void internalUpdateFileDescriptor(FileDescriptor descriptor, ExtensionRegistry registry) {
            try {
                descriptor.setProto(DescriptorProtos.FileDescriptorProto.parseFrom(descriptor.proto.toByteString(), registry));
            } catch (InvalidProtocolBufferException e) {
                throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
            }
        }

        private FileDescriptor(DescriptorProtos.FileDescriptorProto proto, FileDescriptor[] dependencies, DescriptorPool pool, boolean allowUnknownDependencies) throws DescriptorValidationException {
            super(null);
            this.pool = pool;
            this.proto = proto;
            this.dependencies = (FileDescriptor[]) dependencies.clone();
            HashMap<String, FileDescriptor> nameToFileMap = new HashMap<>();
            for (FileDescriptor file : dependencies) {
                nameToFileMap.put(file.getName(), file);
            }
            List<FileDescriptor> publicDependencies = new ArrayList<>();
            for (int i = 0; i < proto.getPublicDependencyCount(); i++) {
                int index = proto.getPublicDependency(i);
                if (index < 0 || index >= proto.getDependencyCount()) {
                    throw new DescriptorValidationException(this, "Invalid public dependency index.", (C07721) null);
                }
                String name = proto.getDependency(index);
                FileDescriptor file2 = nameToFileMap.get(name);
                if (file2 != null) {
                    publicDependencies.add(file2);
                } else if (!allowUnknownDependencies) {
                    throw new DescriptorValidationException(this, "Invalid public dependency: " + name, (C07721) null);
                }
            }
            this.publicDependencies = new FileDescriptor[publicDependencies.size()];
            publicDependencies.toArray(this.publicDependencies);
            pool.addPackage(getPackage(), this);
            this.messageTypes = new Descriptor[proto.getMessageTypeCount()];
            for (int i2 = 0; i2 < proto.getMessageTypeCount(); i2++) {
                this.messageTypes[i2] = new Descriptor(proto.getMessageType(i2), this, null, i2, null);
            }
            this.enumTypes = new EnumDescriptor[proto.getEnumTypeCount()];
            for (int i3 = 0; i3 < proto.getEnumTypeCount(); i3++) {
                this.enumTypes[i3] = new EnumDescriptor(proto.getEnumType(i3), this, null, i3, null);
            }
            this.services = new ServiceDescriptor[proto.getServiceCount()];
            for (int i4 = 0; i4 < proto.getServiceCount(); i4++) {
                this.services[i4] = new ServiceDescriptor(proto.getService(i4), this, i4, null);
            }
            this.extensions = new FieldDescriptor[proto.getExtensionCount()];
            for (int i5 = 0; i5 < proto.getExtensionCount(); i5++) {
                this.extensions[i5] = new FieldDescriptor(proto.getExtension(i5), this, null, i5, true, null);
            }
        }

        FileDescriptor(String packageName, Descriptor message) throws DescriptorValidationException {
            super(null);
            this.pool = new DescriptorPool(new FileDescriptor[0], true);
            this.proto = DescriptorProtos.FileDescriptorProto.newBuilder().setName(message.getFullName() + ".placeholder.proto").setPackage(packageName).addMessageType(message.toProto()).build();
            this.dependencies = new FileDescriptor[0];
            this.publicDependencies = new FileDescriptor[0];
            this.messageTypes = new Descriptor[]{message};
            this.enumTypes = new EnumDescriptor[0];
            this.services = new ServiceDescriptor[0];
            this.extensions = new FieldDescriptor[0];
            this.pool.addPackage(packageName, this);
            this.pool.addSymbol(message);
        }

        private void crossLink() throws DescriptorValidationException {
            for (Descriptor messageType : this.messageTypes) {
                messageType.crossLink();
            }
            for (ServiceDescriptor service : this.services) {
                service.crossLink();
            }
            for (FieldDescriptor extension : this.extensions) {
                extension.crossLink();
            }
        }

        private void setProto(DescriptorProtos.FileDescriptorProto proto) {
            this.proto = proto;
            for (int i = 0; i < this.messageTypes.length; i++) {
                this.messageTypes[i].setProto(proto.getMessageType(i));
            }
            for (int i2 = 0; i2 < this.enumTypes.length; i2++) {
                this.enumTypes[i2].setProto(proto.getEnumType(i2));
            }
            for (int i3 = 0; i3 < this.services.length; i3++) {
                this.services[i3].setProto(proto.getService(i3));
            }
            for (int i4 = 0; i4 < this.extensions.length; i4++) {
                this.extensions[i4].setProto(proto.getExtension(i4));
            }
        }

        /* access modifiers changed from: package-private */
        public boolean supportsUnknownEnumValue() {
            return getSyntax() == Syntax.PROTO3;
        }
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/Descriptors$Descriptor.class */
    public static final class Descriptor extends GenericDescriptor {
        private final int index;
        private DescriptorProtos.DescriptorProto proto;
        private final String fullName;
        private final FileDescriptor file;
        private final Descriptor containingType;
        private final Descriptor[] nestedTypes;
        private final EnumDescriptor[] enumTypes;
        private final FieldDescriptor[] fields;
        private final FieldDescriptor[] extensions;
        private final OneofDescriptor[] oneofs;
        private final int realOneofCount;
        private final int[] extensionRangeLowerBounds;
        private final int[] extensionRangeUpperBounds;

        /* synthetic */ Descriptor(DescriptorProtos.DescriptorProto x0, FileDescriptor x1, Descriptor x2, int x3, C07721 x4) throws DescriptorValidationException {
            this(x0, x1, x2, x3);
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.DescriptorProto toProto() {
            return this.proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public DescriptorProtos.MessageOptions getOptions() {
            return this.proto.getOptions();
        }

        public List<FieldDescriptor> getFields() {
            return Collections.unmodifiableList(Arrays.asList(this.fields));
        }

        public List<OneofDescriptor> getOneofs() {
            return Collections.unmodifiableList(Arrays.asList(this.oneofs));
        }

        public List<OneofDescriptor> getRealOneofs() {
            return Collections.unmodifiableList(Arrays.asList(this.oneofs).subList(0, this.realOneofCount));
        }

        public List<FieldDescriptor> getExtensions() {
            return Collections.unmodifiableList(Arrays.asList(this.extensions));
        }

        public List<Descriptor> getNestedTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.nestedTypes));
        }

        public List<EnumDescriptor> getEnumTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
        }

        public boolean isExtensionNumber(int number) {
            int index = Arrays.binarySearch(this.extensionRangeLowerBounds, number);
            if (index < 0) {
                index = (index ^ -1) - 1;
            }
            return index >= 0 && number < this.extensionRangeUpperBounds[index];
        }

        public boolean isReservedNumber(int number) {
            for (DescriptorProtos.DescriptorProto.ReservedRange range : this.proto.getReservedRangeList()) {
                if (range.getStart() <= number && number < range.getEnd()) {
                    return true;
                }
            }
            return false;
        }

        public boolean isReservedName(String name) {
            Internal.checkNotNull(name);
            for (String reservedName : this.proto.getReservedNameList()) {
                if (reservedName.equals(name)) {
                    return true;
                }
            }
            return false;
        }

        public boolean isExtendable() {
            return !this.proto.getExtensionRangeList().isEmpty();
        }

        public FieldDescriptor findFieldByName(String name) {
            GenericDescriptor result = this.file.pool.findSymbol(this.fullName + '.' + name);
            if (result instanceof FieldDescriptor) {
                return (FieldDescriptor) result;
            }
            return null;
        }

        public FieldDescriptor findFieldByNumber(int number) {
            return (FieldDescriptor) this.file.pool.fieldsByNumber.get(new DescriptorPool.DescriptorIntPair(this, number));
        }

        public Descriptor findNestedTypeByName(String name) {
            GenericDescriptor result = this.file.pool.findSymbol(this.fullName + '.' + name);
            if (result instanceof Descriptor) {
                return (Descriptor) result;
            }
            return null;
        }

        public EnumDescriptor findEnumTypeByName(String name) {
            GenericDescriptor result = this.file.pool.findSymbol(this.fullName + '.' + name);
            if (result instanceof EnumDescriptor) {
                return (EnumDescriptor) result;
            }
            return null;
        }

        Descriptor(String fullname) throws DescriptorValidationException {
            super(null);
            String name = fullname;
            String packageName = "";
            int pos = fullname.lastIndexOf(46);
            if (pos != -1) {
                name = fullname.substring(pos + 1);
                packageName = fullname.substring(0, pos);
            }
            this.index = 0;
            this.proto = DescriptorProtos.DescriptorProto.newBuilder().setName(name).addExtensionRange(DescriptorProtos.DescriptorProto.ExtensionRange.newBuilder().setStart(1).setEnd(536870912).build()).build();
            this.fullName = fullname;
            this.containingType = null;
            this.nestedTypes = new Descriptor[0];
            this.enumTypes = new EnumDescriptor[0];
            this.fields = new FieldDescriptor[0];
            this.extensions = new FieldDescriptor[0];
            this.oneofs = new OneofDescriptor[0];
            this.realOneofCount = 0;
            this.file = new FileDescriptor(packageName, this);
            this.extensionRangeLowerBounds = new int[]{1};
            this.extensionRangeUpperBounds = new int[]{536870912};
        }

        private Descriptor(DescriptorProtos.DescriptorProto proto, FileDescriptor file, Descriptor parent, int index) throws DescriptorValidationException {
            super(null);
            this.index = index;
            this.proto = proto;
            this.fullName = Descriptors.computeFullName(file, parent, proto.getName());
            this.file = file;
            this.containingType = parent;
            this.oneofs = new OneofDescriptor[proto.getOneofDeclCount()];
            for (int i = 0; i < proto.getOneofDeclCount(); i++) {
                this.oneofs[i] = new OneofDescriptor(proto.getOneofDecl(i), file, this, i, null);
            }
            this.nestedTypes = new Descriptor[proto.getNestedTypeCount()];
            for (int i2 = 0; i2 < proto.getNestedTypeCount(); i2++) {
                this.nestedTypes[i2] = new Descriptor(proto.getNestedType(i2), file, this, i2);
            }
            this.enumTypes = new EnumDescriptor[proto.getEnumTypeCount()];
            for (int i3 = 0; i3 < proto.getEnumTypeCount(); i3++) {
                this.enumTypes[i3] = new EnumDescriptor(proto.getEnumType(i3), file, this, i3, null);
            }
            this.fields = new FieldDescriptor[proto.getFieldCount()];
            for (int i4 = 0; i4 < proto.getFieldCount(); i4++) {
                this.fields[i4] = new FieldDescriptor(proto.getField(i4), file, this, i4, false, null);
            }
            this.extensions = new FieldDescriptor[proto.getExtensionCount()];
            for (int i5 = 0; i5 < proto.getExtensionCount(); i5++) {
                this.extensions[i5] = new FieldDescriptor(proto.getExtension(i5), file, this, i5, true, null);
            }
            for (int i6 = 0; i6 < proto.getOneofDeclCount(); i6++) {
                this.oneofs[i6].fields = new FieldDescriptor[this.oneofs[i6].getFieldCount()];
                this.oneofs[i6].fieldCount = 0;
            }
            for (int i7 = 0; i7 < proto.getFieldCount(); i7++) {
                OneofDescriptor oneofDescriptor = this.fields[i7].getContainingOneof();
                if (oneofDescriptor != null) {
                    oneofDescriptor.fields[OneofDescriptor.access$2008(oneofDescriptor)] = this.fields[i7];
                }
            }
            int syntheticOneofCount = 0;
            for (OneofDescriptor oneof : this.oneofs) {
                if (oneof.isSynthetic()) {
                    syntheticOneofCount++;
                } else if (syntheticOneofCount > 0) {
                    throw new DescriptorValidationException(this, "Synthetic oneofs must come last.", (C07721) null);
                }
            }
            this.realOneofCount = this.oneofs.length - syntheticOneofCount;
            file.pool.addSymbol(this);
            this.extensionRangeLowerBounds = new int[proto.getExtensionRangeCount()];
            this.extensionRangeUpperBounds = new int[proto.getExtensionRangeCount()];
            int i8 = 0;
            for (DescriptorProtos.DescriptorProto.ExtensionRange range : proto.getExtensionRangeList()) {
                this.extensionRangeLowerBounds[i8] = range.getStart();
                this.extensionRangeUpperBounds[i8] = range.getEnd();
                i8++;
            }
            Arrays.sort(this.extensionRangeLowerBounds);
            Arrays.sort(this.extensionRangeUpperBounds);
        }

        /* access modifiers changed from: private */
        public void crossLink() throws DescriptorValidationException {
            for (Descriptor nestedType : this.nestedTypes) {
                nestedType.crossLink();
            }
            for (FieldDescriptor field : this.fields) {
                field.crossLink();
            }
            for (FieldDescriptor extension : this.extensions) {
                extension.crossLink();
            }
        }

        /* access modifiers changed from: private */
        public void setProto(DescriptorProtos.DescriptorProto proto) {
            this.proto = proto;
            for (int i = 0; i < this.nestedTypes.length; i++) {
                this.nestedTypes[i].setProto(proto.getNestedType(i));
            }
            for (int i2 = 0; i2 < this.oneofs.length; i2++) {
                this.oneofs[i2].setProto(proto.getOneofDecl(i2));
            }
            for (int i3 = 0; i3 < this.enumTypes.length; i3++) {
                this.enumTypes[i3].setProto(proto.getEnumType(i3));
            }
            for (int i4 = 0; i4 < this.fields.length; i4++) {
                this.fields[i4].setProto(proto.getField(i4));
            }
            for (int i5 = 0; i5 < this.extensions.length; i5++) {
                this.extensions[i5].setProto(proto.getExtension(i5));
            }
        }
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/Descriptors$FieldDescriptor.class */
    public static final class FieldDescriptor extends GenericDescriptor implements Comparable<FieldDescriptor>, FieldSet.FieldDescriptorLite<FieldDescriptor> {
        private static final WireFormat.FieldType[] table = WireFormat.FieldType.values();
        private final int index;
        private DescriptorProtos.FieldDescriptorProto proto;
        private final String fullName;
        private final String jsonName;
        private final FileDescriptor file;
        private final Descriptor extensionScope;
        private final boolean isProto3Optional;
        private Type type;
        private Descriptor containingType;
        private Descriptor messageType;
        private OneofDescriptor containingOneof;
        private EnumDescriptor enumType;
        private Object defaultValue;

        /* synthetic */ FieldDescriptor(DescriptorProtos.FieldDescriptorProto x0, FileDescriptor x1, Descriptor x2, int x3, boolean x4, C07721 x5) throws DescriptorValidationException {
            this(x0, x1, x2, x3, x4);
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.FieldDescriptorProto toProto() {
            return this.proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.proto.getNumber();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public String getJsonName() {
            return this.jsonName;
        }

        public JavaType getJavaType() {
            return this.type.getJavaType();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return getLiteType().getJavaType();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        public Type getType() {
            return this.type;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return table[this.type.ordinal()];
        }

        public boolean needsUtf8Check() {
            if (this.type != Type.STRING) {
                return false;
            }
            if (!getContainingType().getOptions().getMapEntry() && getFile().getSyntax() != FileDescriptor.Syntax.PROTO3) {
                return getFile().getOptions().getJavaStringCheckUtf8();
            }
            return true;
        }

        public boolean isMapField() {
            return getType() == Type.MESSAGE && isRepeated() && getMessageType().getOptions().getMapEntry();
        }

        static {
            if (Type.types.length != DescriptorProtos.FieldDescriptorProto.Type.values().length) {
                throw new RuntimeException("descriptor.proto has a new declared type but Descriptors.java wasn't updated.");
            }
        }

        public boolean isRequired() {
            return this.proto.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REQUIRED;
        }

        public boolean isOptional() {
            return this.proto.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.proto.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            if (!isPackable()) {
                return false;
            }
            if (getFile().getSyntax() == FileDescriptor.Syntax.PROTO2) {
                return getOptions().getPacked();
            }
            return !getOptions().hasPacked() || getOptions().getPacked();
        }

        public boolean isPackable() {
            return isRepeated() && getLiteType().isPackable();
        }

        public boolean hasDefaultValue() {
            return this.proto.hasDefaultValue();
        }

        public Object getDefaultValue() {
            if (getJavaType() != JavaType.MESSAGE) {
                return this.defaultValue;
            }
            throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
        }

        public DescriptorProtos.FieldOptions getOptions() {
            return this.proto.getOptions();
        }

        public boolean isExtension() {
            return this.proto.hasExtendee();
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public OneofDescriptor getContainingOneof() {
            return this.containingOneof;
        }

        public OneofDescriptor getRealContainingOneof() {
            if (this.containingOneof == null || this.containingOneof.isSynthetic()) {
                return null;
            }
            return this.containingOneof;
        }

        public boolean hasOptionalKeyword() {
            return this.isProto3Optional || (this.file.getSyntax() == FileDescriptor.Syntax.PROTO2 && isOptional() && getContainingOneof() == null);
        }

        boolean hasPresence() {
            if (isRepeated()) {
                return false;
            }
            return getType() == Type.MESSAGE || getType() == Type.GROUP || getContainingOneof() != null || this.file.getSyntax() == FileDescriptor.Syntax.PROTO2;
        }

        public Descriptor getExtensionScope() {
            if (isExtension()) {
                return this.extensionScope;
            }
            throw new UnsupportedOperationException(String.format("This field is not an extension. (%s)", this.fullName));
        }

        public Descriptor getMessageType() {
            if (getJavaType() == JavaType.MESSAGE) {
                return this.messageType;
            }
            throw new UnsupportedOperationException(String.format("This field is not of message type. (%s)", this.fullName));
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public EnumDescriptor getEnumType() {
            if (getJavaType() == JavaType.ENUM) {
                return this.enumType;
            }
            throw new UnsupportedOperationException(String.format("This field is not of enum type. (%s)", this.fullName));
        }

        public int compareTo(FieldDescriptor other) {
            if (other.containingType == this.containingType) {
                return getNumber() - other.getNumber();
            }
            throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
        }

        @Override // java.lang.Object
        public String toString() {
            return getFullName();
        }

        /* loaded from: grasscutter.jar:com/google/protobuf/Descriptors$FieldDescriptor$Type.class */
        public enum Type {
            DOUBLE(JavaType.DOUBLE),
            FLOAT(JavaType.FLOAT),
            INT64(JavaType.LONG),
            UINT64(JavaType.LONG),
            INT32(JavaType.INT),
            FIXED64(JavaType.LONG),
            FIXED32(JavaType.INT),
            BOOL(JavaType.BOOLEAN),
            STRING(JavaType.STRING),
            GROUP(JavaType.MESSAGE),
            MESSAGE(JavaType.MESSAGE),
            BYTES(JavaType.BYTE_STRING),
            UINT32(JavaType.INT),
            ENUM(JavaType.ENUM),
            SFIXED32(JavaType.INT),
            SFIXED64(JavaType.LONG),
            SINT32(JavaType.INT),
            SINT64(JavaType.LONG);
            
            private static final Type[] types = values();
            private final JavaType javaType;

            Type(JavaType javaType) {
                this.javaType = javaType;
            }

            public DescriptorProtos.FieldDescriptorProto.Type toProto() {
                return DescriptorProtos.FieldDescriptorProto.Type.forNumber(ordinal() + 1);
            }

            public JavaType getJavaType() {
                return this.javaType;
            }

            public static Type valueOf(DescriptorProtos.FieldDescriptorProto.Type type) {
                return types[type.getNumber() - 1];
            }
        }

        /* loaded from: grasscutter.jar:com/google/protobuf/Descriptors$FieldDescriptor$JavaType.class */
        public enum JavaType {
            INT(0),
            LONG(0L),
            FLOAT(Float.valueOf(0.0f)),
            DOUBLE(Double.valueOf(0.0d)),
            BOOLEAN(false),
            STRING(""),
            BYTE_STRING(ByteString.EMPTY),
            ENUM(null),
            MESSAGE(null);
            
            private final Object defaultDefault;

            JavaType(Object defaultDefault) {
                this.defaultDefault = defaultDefault;
            }
        }

        private static String fieldNameToJsonName(String name) {
            int length = name.length();
            StringBuilder result = new StringBuilder(length);
            boolean isNextUpperCase = false;
            for (int i = 0; i < length; i++) {
                char ch = name.charAt(i);
                if (ch == '_') {
                    isNextUpperCase = true;
                } else if (isNextUpperCase) {
                    if ('a' <= ch && ch <= 'z') {
                        ch = (char) ((ch - 'a') + 65);
                    }
                    result.append(ch);
                    isNextUpperCase = false;
                } else {
                    result.append(ch);
                }
            }
            return result.toString();
        }

        private FieldDescriptor(DescriptorProtos.FieldDescriptorProto proto, FileDescriptor file, Descriptor parent, int index, boolean isExtension) throws DescriptorValidationException {
            super(null);
            this.index = index;
            this.proto = proto;
            this.fullName = Descriptors.computeFullName(file, parent, proto.getName());
            this.file = file;
            if (proto.hasJsonName()) {
                this.jsonName = proto.getJsonName();
            } else {
                this.jsonName = fieldNameToJsonName(proto.getName());
            }
            if (proto.hasType()) {
                this.type = Type.valueOf(proto.getType());
            }
            this.isProto3Optional = proto.getProto3Optional();
            if (getNumber() <= 0) {
                throw new DescriptorValidationException(this, "Field numbers must be positive integers.", (C07721) null);
            }
            if (isExtension) {
                if (!proto.hasExtendee()) {
                    throw new DescriptorValidationException(this, "FieldDescriptorProto.extendee not set for extension field.", (C07721) null);
                }
                this.containingType = null;
                if (parent != null) {
                    this.extensionScope = parent;
                } else {
                    this.extensionScope = null;
                }
                if (proto.hasOneofIndex()) {
                    throw new DescriptorValidationException(this, "FieldDescriptorProto.oneof_index set for extension field.", (C07721) null);
                }
                this.containingOneof = null;
            } else if (proto.hasExtendee()) {
                throw new DescriptorValidationException(this, "FieldDescriptorProto.extendee set for non-extension field.", (C07721) null);
            } else {
                this.containingType = parent;
                if (!proto.hasOneofIndex()) {
                    this.containingOneof = null;
                } else if (proto.getOneofIndex() < 0 || proto.getOneofIndex() >= parent.toProto().getOneofDeclCount()) {
                    throw new DescriptorValidationException(this, "FieldDescriptorProto.oneof_index is out of range for type " + parent.getName(), (C07721) null);
                } else {
                    this.containingOneof = parent.getOneofs().get(proto.getOneofIndex());
                    OneofDescriptor.access$2008(this.containingOneof);
                }
                this.extensionScope = null;
            }
            file.pool.addSymbol(this);
        }

        /* access modifiers changed from: private */
        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:90:0x03bb
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        public void crossLink() throws com.google.protobuf.Descriptors.DescriptorValidationException {
            /*
            // Method dump skipped, instructions count: 1290
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Descriptors.FieldDescriptor.crossLink():void");
        }

        /* access modifiers changed from: private */
        public void setProto(DescriptorProtos.FieldDescriptorProto proto) {
            this.proto = proto;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder to, MessageLite from) {
            return ((Message.Builder) to).mergeFrom((Message) from);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.protobuf.Descriptors$1 */
    /* loaded from: grasscutter.jar:com/google/protobuf/Descriptors$1.class */
    public static /* synthetic */ class C07721 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;

        /* renamed from: $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType */
        static final /* synthetic */ int[] f363xdde82548 = new int[FieldDescriptor.JavaType.values().length];

        static {
            try {
                f363xdde82548[FieldDescriptor.JavaType.ENUM.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f363xdde82548[FieldDescriptor.JavaType.MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = new int[FieldDescriptor.Type.values().length];
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.INT32.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.SINT32.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.SFIXED32.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.UINT32.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.INT64.ordinal()] = 6;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.SINT64.ordinal()] = 7;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.SFIXED64.ordinal()] = 8;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.UINT64.ordinal()] = 9;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.FIXED64.ordinal()] = 10;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.FLOAT.ordinal()] = 11;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.DOUBLE.ordinal()] = 12;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.BOOL.ordinal()] = 13;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.STRING.ordinal()] = 14;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.ENUM.ordinal()] = 16;
            } catch (NoSuchFieldError e18) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError e19) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[FieldDescriptor.Type.GROUP.ordinal()] = 18;
            } catch (NoSuchFieldError e20) {
            }
        }
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/Descriptors$EnumDescriptor.class */
    public static final class EnumDescriptor extends GenericDescriptor implements Internal.EnumLiteMap<EnumValueDescriptor> {
        private final int index;
        private DescriptorProtos.EnumDescriptorProto proto;
        private final String fullName;
        private final FileDescriptor file;
        private final Descriptor containingType;
        private EnumValueDescriptor[] values;
        private final WeakHashMap<Integer, WeakReference<EnumValueDescriptor>> unknownValues;

        /* synthetic */ EnumDescriptor(DescriptorProtos.EnumDescriptorProto x0, FileDescriptor x1, Descriptor x2, int x3, C07721 x4) throws DescriptorValidationException {
            this(x0, x1, x2, x3);
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.EnumDescriptorProto toProto() {
            return this.proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public DescriptorProtos.EnumOptions getOptions() {
            return this.proto.getOptions();
        }

        public List<EnumValueDescriptor> getValues() {
            return Collections.unmodifiableList(Arrays.asList(this.values));
        }

        public EnumValueDescriptor findValueByName(String name) {
            GenericDescriptor result = this.file.pool.findSymbol(this.fullName + '.' + name);
            if (result instanceof EnumValueDescriptor) {
                return (EnumValueDescriptor) result;
            }
            return null;
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public EnumValueDescriptor findValueByNumber(int number) {
            return (EnumValueDescriptor) this.file.pool.enumValuesByNumber.get(new DescriptorPool.DescriptorIntPair(this, number));
        }

        public EnumValueDescriptor findValueByNumberCreatingIfUnknown(int number) {
            EnumValueDescriptor result = findValueByNumber(number);
            if (result != null) {
                return result;
            }
            synchronized (this) {
                Integer key = new Integer(number);
                WeakReference<EnumValueDescriptor> reference = this.unknownValues.get(key);
                if (reference != null) {
                    result = reference.get();
                }
                if (result == null) {
                    result = new EnumValueDescriptor(this.file, this, key, (C07721) null);
                    this.unknownValues.put(key, new WeakReference<>(result));
                }
            }
            return result;
        }

        int getUnknownEnumValueDescriptorCount() {
            return this.unknownValues.size();
        }

        private EnumDescriptor(DescriptorProtos.EnumDescriptorProto proto, FileDescriptor file, Descriptor parent, int index) throws DescriptorValidationException {
            super(null);
            this.unknownValues = new WeakHashMap<>();
            this.index = index;
            this.proto = proto;
            this.fullName = Descriptors.computeFullName(file, parent, proto.getName());
            this.file = file;
            this.containingType = parent;
            if (proto.getValueCount() == 0) {
                throw new DescriptorValidationException(this, "Enums must contain at least one value.", (C07721) null);
            }
            this.values = new EnumValueDescriptor[proto.getValueCount()];
            for (int i = 0; i < proto.getValueCount(); i++) {
                this.values[i] = new EnumValueDescriptor(proto.getValue(i), file, this, i, null);
            }
            file.pool.addSymbol(this);
        }

        /* access modifiers changed from: private */
        public void setProto(DescriptorProtos.EnumDescriptorProto proto) {
            this.proto = proto;
            for (int i = 0; i < this.values.length; i++) {
                this.values[i].setProto(proto.getValue(i));
            }
        }
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/Descriptors$EnumValueDescriptor.class */
    public static final class EnumValueDescriptor extends GenericDescriptor implements Internal.EnumLite {
        private final int index;
        private DescriptorProtos.EnumValueDescriptorProto proto;
        private final String fullName;
        private final FileDescriptor file;
        private final EnumDescriptor type;

        /* synthetic */ EnumValueDescriptor(FileDescriptor x0, EnumDescriptor x1, Integer x2, C07721 x3) {
            this(x0, x1, x2);
        }

        /* synthetic */ EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto x0, FileDescriptor x1, EnumDescriptor x2, int x3, C07721 x4) throws DescriptorValidationException {
            this(x0, x1, x2, x3);
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.EnumValueDescriptorProto toProto() {
            return this.proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.proto.getNumber();
        }

        public String toString() {
            return this.proto.getName();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        public EnumDescriptor getType() {
            return this.type;
        }

        public DescriptorProtos.EnumValueOptions getOptions() {
            return this.proto.getOptions();
        }

        private EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto proto, FileDescriptor file, EnumDescriptor parent, int index) throws DescriptorValidationException {
            super(null);
            this.index = index;
            this.proto = proto;
            this.file = file;
            this.type = parent;
            this.fullName = parent.getFullName() + '.' + proto.getName();
            file.pool.addSymbol(this);
            file.pool.addEnumValueByNumber(this);
        }

        private EnumValueDescriptor(FileDescriptor file, EnumDescriptor parent, Integer number) {
            super(null);
            DescriptorProtos.EnumValueDescriptorProto proto = DescriptorProtos.EnumValueDescriptorProto.newBuilder().setName("UNKNOWN_ENUM_VALUE_" + parent.getName() + JavaConstant.Dynamic.DEFAULT_NAME + number).setNumber(number.intValue()).build();
            this.index = -1;
            this.proto = proto;
            this.file = file;
            this.type = parent;
            this.fullName = parent.getFullName() + '.' + proto.getName();
        }

        /* access modifiers changed from: private */
        public void setProto(DescriptorProtos.EnumValueDescriptorProto proto) {
            this.proto = proto;
        }
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/Descriptors$ServiceDescriptor.class */
    public static final class ServiceDescriptor extends GenericDescriptor {
        private final int index;
        private DescriptorProtos.ServiceDescriptorProto proto;
        private final String fullName;
        private final FileDescriptor file;
        private MethodDescriptor[] methods;

        /* synthetic */ ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto x0, FileDescriptor x1, int x2, C07721 x3) throws DescriptorValidationException {
            this(x0, x1, x2);
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.ServiceDescriptorProto toProto() {
            return this.proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        public DescriptorProtos.ServiceOptions getOptions() {
            return this.proto.getOptions();
        }

        public List<MethodDescriptor> getMethods() {
            return Collections.unmodifiableList(Arrays.asList(this.methods));
        }

        public MethodDescriptor findMethodByName(String name) {
            GenericDescriptor result = this.file.pool.findSymbol(this.fullName + '.' + name);
            if (result instanceof MethodDescriptor) {
                return (MethodDescriptor) result;
            }
            return null;
        }

        private ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto proto, FileDescriptor file, int index) throws DescriptorValidationException {
            super(null);
            this.index = index;
            this.proto = proto;
            this.fullName = Descriptors.computeFullName(file, null, proto.getName());
            this.file = file;
            this.methods = new MethodDescriptor[proto.getMethodCount()];
            for (int i = 0; i < proto.getMethodCount(); i++) {
                this.methods[i] = new MethodDescriptor(proto.getMethod(i), file, this, i, null);
            }
            file.pool.addSymbol(this);
        }

        /* access modifiers changed from: private */
        public void crossLink() throws DescriptorValidationException {
            for (MethodDescriptor method : this.methods) {
                method.crossLink();
            }
        }

        /* access modifiers changed from: private */
        public void setProto(DescriptorProtos.ServiceDescriptorProto proto) {
            this.proto = proto;
            for (int i = 0; i < this.methods.length; i++) {
                this.methods[i].setProto(proto.getMethod(i));
            }
        }
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/Descriptors$MethodDescriptor.class */
    public static final class MethodDescriptor extends GenericDescriptor {
        private final int index;
        private DescriptorProtos.MethodDescriptorProto proto;
        private final String fullName;
        private final FileDescriptor file;
        private final ServiceDescriptor service;
        private Descriptor inputType;
        private Descriptor outputType;

        /* synthetic */ MethodDescriptor(DescriptorProtos.MethodDescriptorProto x0, FileDescriptor x1, ServiceDescriptor x2, int x3, C07721 x4) throws DescriptorValidationException {
            this(x0, x1, x2, x3);
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.MethodDescriptorProto toProto() {
            return this.proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        public ServiceDescriptor getService() {
            return this.service;
        }

        public Descriptor getInputType() {
            return this.inputType;
        }

        public Descriptor getOutputType() {
            return this.outputType;
        }

        public boolean isClientStreaming() {
            return this.proto.getClientStreaming();
        }

        public boolean isServerStreaming() {
            return this.proto.getServerStreaming();
        }

        public DescriptorProtos.MethodOptions getOptions() {
            return this.proto.getOptions();
        }

        private MethodDescriptor(DescriptorProtos.MethodDescriptorProto proto, FileDescriptor file, ServiceDescriptor parent, int index) throws DescriptorValidationException {
            super(null);
            this.index = index;
            this.proto = proto;
            this.file = file;
            this.service = parent;
            this.fullName = parent.getFullName() + '.' + proto.getName();
            file.pool.addSymbol(this);
        }

        /* access modifiers changed from: private */
        public void crossLink() throws DescriptorValidationException {
            GenericDescriptor input = this.file.pool.lookupSymbol(this.proto.getInputType(), this, DescriptorPool.SearchFilter.TYPES_ONLY);
            if (!(input instanceof Descriptor)) {
                throw new DescriptorValidationException(this, '\"' + this.proto.getInputType() + "\" is not a message type.", (C07721) null);
            }
            this.inputType = (Descriptor) input;
            GenericDescriptor output = this.file.pool.lookupSymbol(this.proto.getOutputType(), this, DescriptorPool.SearchFilter.TYPES_ONLY);
            if (!(output instanceof Descriptor)) {
                throw new DescriptorValidationException(this, '\"' + this.proto.getOutputType() + "\" is not a message type.", (C07721) null);
            }
            this.outputType = (Descriptor) output;
        }

        /* access modifiers changed from: private */
        public void setProto(DescriptorProtos.MethodDescriptorProto proto) {
            this.proto = proto;
        }
    }

    /* access modifiers changed from: private */
    public static String computeFullName(FileDescriptor file, Descriptor parent, String name) {
        if (parent != null) {
            return parent.getFullName() + '.' + name;
        }
        String packageName = file.getPackage();
        if (!packageName.isEmpty()) {
            return packageName + '.' + name;
        }
        return name;
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/Descriptors$GenericDescriptor.class */
    public static abstract class GenericDescriptor {
        public abstract Message toProto();

        public abstract String getName();

        public abstract String getFullName();

        public abstract FileDescriptor getFile();

        /* synthetic */ GenericDescriptor(C07721 x0) {
            this();
        }

        private GenericDescriptor() {
        }
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/Descriptors$DescriptorValidationException.class */
    public static class DescriptorValidationException extends Exception {
        private static final long serialVersionUID = 5750205775490483148L;
        private final String name;
        private final Message proto;
        private final String description;

        /* synthetic */ DescriptorValidationException(FileDescriptor x0, String x1, C07721 x2) {
            this(x0, x1);
        }

        /* synthetic */ DescriptorValidationException(GenericDescriptor x0, String x1, C07721 x2) {
            this(x0, x1);
        }

        /* synthetic */ DescriptorValidationException(GenericDescriptor x0, String x1, Throwable x2, C07721 x3) {
            this(x0, x1, x2);
        }

        public String getProblemSymbolName() {
            return this.name;
        }

        public Message getProblemProto() {
            return this.proto;
        }

        public String getDescription() {
            return this.description;
        }

        private DescriptorValidationException(GenericDescriptor problemDescriptor, String description) {
            super(problemDescriptor.getFullName() + ": " + description);
            this.name = problemDescriptor.getFullName();
            this.proto = problemDescriptor.toProto();
            this.description = description;
        }

        private DescriptorValidationException(GenericDescriptor problemDescriptor, String description, Throwable cause) {
            this(problemDescriptor, description);
            initCause(cause);
        }

        private DescriptorValidationException(FileDescriptor problemDescriptor, String description) {
            super(problemDescriptor.getName() + ": " + description);
            this.name = problemDescriptor.getName();
            this.proto = problemDescriptor.toProto();
            this.description = description;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/protobuf/Descriptors$DescriptorPool.class */
    public static final class DescriptorPool {
        private boolean allowUnknownDependencies;
        private final Map<String, GenericDescriptor> descriptorsByName = new HashMap();
        private final Map<DescriptorIntPair, FieldDescriptor> fieldsByNumber = new HashMap();
        private final Map<DescriptorIntPair, EnumValueDescriptor> enumValuesByNumber = new HashMap();
        private final Set<FileDescriptor> dependencies = new HashSet();

        /* access modifiers changed from: package-private */
        /* loaded from: grasscutter.jar:com/google/protobuf/Descriptors$DescriptorPool$SearchFilter.class */
        public enum SearchFilter {
            TYPES_ONLY,
            AGGREGATES_ONLY,
            ALL_SYMBOLS
        }

        DescriptorPool(FileDescriptor[] dependencies, boolean allowUnknownDependencies) {
            this.allowUnknownDependencies = allowUnknownDependencies;
            for (FileDescriptor dependency : dependencies) {
                this.dependencies.add(dependency);
                importPublicDependencies(dependency);
            }
            for (FileDescriptor dependency2 : this.dependencies) {
                try {
                    addPackage(dependency2.getPackage(), dependency2);
                } catch (DescriptorValidationException e) {
                    throw new AssertionError(e);
                }
            }
        }

        private void importPublicDependencies(FileDescriptor file) {
            for (FileDescriptor dependency : file.getPublicDependencies()) {
                if (this.dependencies.add(dependency)) {
                    importPublicDependencies(dependency);
                }
            }
        }

        GenericDescriptor findSymbol(String fullName) {
            return findSymbol(fullName, SearchFilter.ALL_SYMBOLS);
        }

        GenericDescriptor findSymbol(String fullName, SearchFilter filter) {
            GenericDescriptor result = this.descriptorsByName.get(fullName);
            if (result != null && (filter == SearchFilter.ALL_SYMBOLS || ((filter == SearchFilter.TYPES_ONLY && isType(result)) || (filter == SearchFilter.AGGREGATES_ONLY && isAggregate(result))))) {
                return result;
            }
            for (FileDescriptor dependency : this.dependencies) {
                GenericDescriptor result2 = dependency.pool.descriptorsByName.get(fullName);
                if (result2 != null && (filter == SearchFilter.ALL_SYMBOLS || ((filter == SearchFilter.TYPES_ONLY && isType(result2)) || (filter == SearchFilter.AGGREGATES_ONLY && isAggregate(result2))))) {
                    return result2;
                }
            }
            return null;
        }

        boolean isType(GenericDescriptor descriptor) {
            return (descriptor instanceof Descriptor) || (descriptor instanceof EnumDescriptor);
        }

        boolean isAggregate(GenericDescriptor descriptor) {
            return (descriptor instanceof Descriptor) || (descriptor instanceof EnumDescriptor) || (descriptor instanceof PackageDescriptor) || (descriptor instanceof ServiceDescriptor);
        }

        GenericDescriptor lookupSymbol(String name, GenericDescriptor relativeTo, SearchFilter filter) throws DescriptorValidationException {
            String fullname;
            GenericDescriptor result;
            String firstPart;
            if (name.startsWith(Mapper.IGNORED_FIELDNAME)) {
                fullname = name.substring(1);
                result = findSymbol(fullname, filter);
            } else {
                int firstPartLength = name.indexOf(46);
                if (firstPartLength == -1) {
                    firstPart = name;
                } else {
                    firstPart = name.substring(0, firstPartLength);
                }
                StringBuilder scopeToTry = new StringBuilder(relativeTo.getFullName());
                while (true) {
                    int dotpos = scopeToTry.lastIndexOf(Mapper.IGNORED_FIELDNAME);
                    if (dotpos == -1) {
                        fullname = name;
                        result = findSymbol(name, filter);
                        break;
                    }
                    scopeToTry.setLength(dotpos + 1);
                    scopeToTry.append(firstPart);
                    result = findSymbol(scopeToTry.toString(), SearchFilter.AGGREGATES_ONLY);
                    if (result != null) {
                        if (firstPartLength != -1) {
                            scopeToTry.setLength(dotpos + 1);
                            scopeToTry.append(name);
                            result = findSymbol(scopeToTry.toString(), filter);
                        }
                        fullname = scopeToTry.toString();
                    } else {
                        scopeToTry.setLength(dotpos);
                    }
                }
            }
            if (result != null) {
                return result;
            }
            if (!this.allowUnknownDependencies || filter != SearchFilter.TYPES_ONLY) {
                throw new DescriptorValidationException(relativeTo, '\"' + name + "\" is not defined.", (C07721) null);
            }
            Descriptors.logger.warning("The descriptor for message type \"" + name + "\" can not be found and a placeholder is created for it");
            GenericDescriptor result2 = new Descriptor(fullname);
            this.dependencies.add(result2.getFile());
            return result2;
        }

        void addSymbol(GenericDescriptor descriptor) throws DescriptorValidationException {
            validateSymbolName(descriptor);
            String fullName = descriptor.getFullName();
            GenericDescriptor old = this.descriptorsByName.put(fullName, descriptor);
            if (old != null) {
                this.descriptorsByName.put(fullName, old);
                if (descriptor.getFile() == old.getFile()) {
                    int dotpos = fullName.lastIndexOf(46);
                    if (dotpos == -1) {
                        throw new DescriptorValidationException(descriptor, '\"' + fullName + "\" is already defined.", (C07721) null);
                    }
                    throw new DescriptorValidationException(descriptor, '\"' + fullName.substring(dotpos + 1) + "\" is already defined in \"" + fullName.substring(0, dotpos) + "\".", (C07721) null);
                }
                throw new DescriptorValidationException(descriptor, '\"' + fullName + "\" is already defined in file \"" + old.getFile().getName() + "\".", (C07721) null);
            }
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:com/google/protobuf/Descriptors$DescriptorPool$PackageDescriptor.class */
        public static final class PackageDescriptor extends GenericDescriptor {
            private final String name;
            private final String fullName;
            private final FileDescriptor file;

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public Message toProto() {
                return this.file.toProto();
            }

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public String getName() {
                return this.name;
            }

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public String getFullName() {
                return this.fullName;
            }

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public FileDescriptor getFile() {
                return this.file;
            }

            PackageDescriptor(String name, String fullName, FileDescriptor file) {
                super(null);
                this.file = file;
                this.fullName = fullName;
                this.name = name;
            }
        }

        void addPackage(String fullName, FileDescriptor file) throws DescriptorValidationException {
            String name;
            int dotpos = fullName.lastIndexOf(46);
            if (dotpos == -1) {
                name = fullName;
            } else {
                addPackage(fullName.substring(0, dotpos), file);
                name = fullName.substring(dotpos + 1);
            }
            GenericDescriptor old = this.descriptorsByName.put(fullName, new PackageDescriptor(name, fullName, file));
            if (old != null) {
                this.descriptorsByName.put(fullName, old);
                if (!(old instanceof PackageDescriptor)) {
                    throw new DescriptorValidationException(file, '\"' + name + "\" is already defined (as something other than a package) in file \"" + old.getFile().getName() + "\".", (C07721) null);
                }
            }
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:com/google/protobuf/Descriptors$DescriptorPool$DescriptorIntPair.class */
        public static final class DescriptorIntPair {
            private final GenericDescriptor descriptor;
            private final int number;

            DescriptorIntPair(GenericDescriptor descriptor, int number) {
                this.descriptor = descriptor;
                this.number = number;
            }

            public int hashCode() {
                return (this.descriptor.hashCode() * 65535) + this.number;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof DescriptorIntPair)) {
                    return false;
                }
                DescriptorIntPair other = (DescriptorIntPair) obj;
                return this.descriptor == other.descriptor && this.number == other.number;
            }
        }

        void addFieldByNumber(FieldDescriptor field) throws DescriptorValidationException {
            DescriptorIntPair key = new DescriptorIntPair(field.getContainingType(), field.getNumber());
            FieldDescriptor old = this.fieldsByNumber.put(key, field);
            if (old != null) {
                this.fieldsByNumber.put(key, old);
                throw new DescriptorValidationException(field, "Field number " + field.getNumber() + " has already been used in \"" + field.getContainingType().getFullName() + "\" by field \"" + old.getName() + "\".", (C07721) null);
            }
        }

        void addEnumValueByNumber(EnumValueDescriptor value) {
            DescriptorIntPair key = new DescriptorIntPair(value.getType(), value.getNumber());
            EnumValueDescriptor old = this.enumValuesByNumber.put(key, value);
            if (old != null) {
                this.enumValuesByNumber.put(key, old);
            }
        }

        static void validateSymbolName(GenericDescriptor descriptor) throws DescriptorValidationException {
            String name = descriptor.getName();
            if (name.length() == 0) {
                throw new DescriptorValidationException(descriptor, "Missing name.", (C07721) null);
            }
            for (int i = 0; i < name.length(); i++) {
                char c = name.charAt(i);
                if (('a' > c || c > 'z') && (('A' > c || c > 'Z') && c != '_' && ('0' > c || c > '9' || i <= 0))) {
                    throw new DescriptorValidationException(descriptor, '\"' + name + "\" is not a valid identifier.", (C07721) null);
                }
            }
        }
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/Descriptors$OneofDescriptor.class */
    public static final class OneofDescriptor extends GenericDescriptor {
        private final int index;
        private DescriptorProtos.OneofDescriptorProto proto;
        private final String fullName;
        private final FileDescriptor file;
        private Descriptor containingType;
        private int fieldCount;
        private FieldDescriptor[] fields;

        /* synthetic */ OneofDescriptor(DescriptorProtos.OneofDescriptorProto x0, FileDescriptor x1, Descriptor x2, int x3, C07721 x4) throws DescriptorValidationException {
            this(x0, x1, x2, x3);
        }

        static /* synthetic */ int access$2008(OneofDescriptor x0) {
            int i = x0.fieldCount;
            x0.fieldCount = i + 1;
            return i;
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public int getFieldCount() {
            return this.fieldCount;
        }

        public DescriptorProtos.OneofOptions getOptions() {
            return this.proto.getOptions();
        }

        public boolean isSynthetic() {
            return this.fields.length == 1 && this.fields[0].isProto3Optional;
        }

        public List<FieldDescriptor> getFields() {
            return Collections.unmodifiableList(Arrays.asList(this.fields));
        }

        public FieldDescriptor getField(int index) {
            return this.fields[index];
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.OneofDescriptorProto toProto() {
            return this.proto;
        }

        /* access modifiers changed from: private */
        public void setProto(DescriptorProtos.OneofDescriptorProto proto) {
            this.proto = proto;
        }

        private OneofDescriptor(DescriptorProtos.OneofDescriptorProto proto, FileDescriptor file, Descriptor parent, int index) throws DescriptorValidationException {
            super(null);
            this.proto = proto;
            this.fullName = Descriptors.computeFullName(file, parent, proto.getName());
            this.file = file;
            this.index = index;
            this.containingType = parent;
            this.fieldCount = 0;
        }
    }
}
