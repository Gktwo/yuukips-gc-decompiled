package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import emu.grasscutter.net.proto.MaterialDeleteReturnTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteReturnNotifyOuterClass.class */
public final class MaterialDeleteReturnNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n MaterialDeleteReturnNotify.proto\u001a\u001eMaterialDeleteReturnType.proto\"ß\u0002\n\u001aMaterialDeleteReturnNotify\u0012'\n\u0004type\u0018\u0007 \u0001(\u000e2\u0019.MaterialDeleteReturnType\u0012P\n\u0013Unk3300_OFOKFKBALJD\u0018\f \u0003(\u000b23.MaterialDeleteReturnNotify.Unk3300OFOKFKBALJDEntry\u0012P\n\u0013Unk3300_LAIHDKJAHAF\u0018\b \u0003(\u000b23.MaterialDeleteReturnNotify.Unk3300LAIHDKJAHAFEntry\u001a9\n\u0017Unk3300OFOKFKBALJDEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001\u001a9\n\u0017Unk3300LAIHDKJAHAFEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MaterialDeleteReturnTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MaterialDeleteReturnNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MaterialDeleteReturnNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MaterialDeleteReturnNotify_descriptor, new String[]{"Type", "Unk3300OFOKFKBALJD", "Unk3300LAIHDKJAHAF"});

    /* renamed from: internal_static_MaterialDeleteReturnNotify_Unk3300OFOKFKBALJDEntry_descriptor */
    private static final Descriptors.Descriptor f786x79dd725e = internal_static_MaterialDeleteReturnNotify_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_MaterialDeleteReturnNotify_Unk3300OFOKFKBALJDEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f787x5adb5adc = new GeneratedMessageV3.FieldAccessorTable(f786x79dd725e, new String[]{"Key", "Value"});

    /* renamed from: internal_static_MaterialDeleteReturnNotify_Unk3300LAIHDKJAHAFEntry_descriptor */
    private static final Descriptors.Descriptor f788x972e14a = internal_static_MaterialDeleteReturnNotify_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_MaterialDeleteReturnNotify_Unk3300LAIHDKJAHAFEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f789x9c391dc8 = new GeneratedMessageV3.FieldAccessorTable(f788x972e14a, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteReturnNotifyOuterClass$MaterialDeleteReturnNotifyOrBuilder.class */
    public interface MaterialDeleteReturnNotifyOrBuilder extends MessageOrBuilder {
        int getTypeValue();

        MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType getType();

        int getUnk3300OFOKFKBALJDCount();

        boolean containsUnk3300OFOKFKBALJD(int i);

        @Deprecated
        Map<Integer, Integer> getUnk3300OFOKFKBALJD();

        Map<Integer, Integer> getUnk3300OFOKFKBALJDMap();

        int getUnk3300OFOKFKBALJDOrDefault(int i, int i2);

        int getUnk3300OFOKFKBALJDOrThrow(int i);

        int getUnk3300LAIHDKJAHAFCount();

        boolean containsUnk3300LAIHDKJAHAF(int i);

        @Deprecated
        Map<Integer, Integer> getUnk3300LAIHDKJAHAF();

        Map<Integer, Integer> getUnk3300LAIHDKJAHAFMap();

        int getUnk3300LAIHDKJAHAFOrDefault(int i, int i2);

        int getUnk3300LAIHDKJAHAFOrThrow(int i);
    }

    private MaterialDeleteReturnNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteReturnNotifyOuterClass$MaterialDeleteReturnNotify.class */
    public static final class MaterialDeleteReturnNotify extends GeneratedMessageV3 implements MaterialDeleteReturnNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TYPE_FIELD_NUMBER = 7;
        private int type_;
        public static final int UNK3300_OFOKFKBALJD_FIELD_NUMBER = 12;
        private MapField<Integer, Integer> unk3300OFOKFKBALJD_;
        public static final int UNK3300_LAIHDKJAHAF_FIELD_NUMBER = 8;
        private MapField<Integer, Integer> unk3300LAIHDKJAHAF_;
        private byte memoizedIsInitialized;
        private static final MaterialDeleteReturnNotify DEFAULT_INSTANCE = new MaterialDeleteReturnNotify();
        private static final Parser<MaterialDeleteReturnNotify> PARSER = new AbstractParser<MaterialDeleteReturnNotify>() { // from class: emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotify.1
            @Override // com.google.protobuf.Parser
            public MaterialDeleteReturnNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MaterialDeleteReturnNotify(input, extensionRegistry);
            }
        };

        /*  JADX ERROR: Dependency scan failed at insn: 0x002B: INVOKE_CUSTOM r0
            java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
            	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
            */
        /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotify.internalGetMapField(int):com.google.protobuf.MapField
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
            	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
            	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
            	at jadx.core.ProcessClass.process(ProcessClass.java:53)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        @Override // com.google.protobuf.GeneratedMessageV3
        protected com.google.protobuf.MapField internalGetMapField(int r5) {
            /*
                r4 = this;
                r0 = r5
                switch(r0) {
                    case 8: goto L_0x0021;
                    case 12: goto L_0x001c;
                    default: goto L_0x0026;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetUnk3300OFOKFKBALJD()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetUnk3300LAIHDKJAHAF()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotify.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private MaterialDeleteReturnNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MaterialDeleteReturnNotify() {
            this.memoizedIsInitialized = -1;
            this.type_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MaterialDeleteReturnNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MaterialDeleteReturnNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                int mutable_bitField0_ = 0;
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 56:
                                this.type_ = input.readEnum();
                                break;
                            case 66:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.unk3300LAIHDKJAHAF_ = MapField.newMapField(Unk3300LAIHDKJAHAFDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 2;
                                }
                                MapEntry<Integer, Integer> unk3300LAIHDKJAHAF__ = (MapEntry) input.readMessage(Unk3300LAIHDKJAHAFDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.unk3300LAIHDKJAHAF_.getMutableMap().put(unk3300LAIHDKJAHAF__.getKey(), unk3300LAIHDKJAHAF__.getValue());
                                break;
                            case 98:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.unk3300OFOKFKBALJD_ = MapField.newMapField(Unk3300OFOKFKBALJDDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, Integer> unk3300OFOKFKBALJD__ = (MapEntry) input.readMessage(Unk3300OFOKFKBALJDDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.unk3300OFOKFKBALJD_.getMutableMap().put(unk3300OFOKFKBALJD__.getKey(), unk3300OFOKFKBALJD__.getValue());
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MaterialDeleteReturnNotifyOuterClass.internal_static_MaterialDeleteReturnNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MaterialDeleteReturnNotifyOuterClass.internal_static_MaterialDeleteReturnNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(MaterialDeleteReturnNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
        public MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType getType() {
            MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType result = MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType.valueOf(this.type_);
            return result == null ? MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType.UNRECOGNIZED : result;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteReturnNotifyOuterClass$MaterialDeleteReturnNotify$Unk3300OFOKFKBALJDDefaultEntryHolder.class */
        public static final class Unk3300OFOKFKBALJDDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(MaterialDeleteReturnNotifyOuterClass.f786x79dd725e, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private Unk3300OFOKFKBALJDDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetUnk3300OFOKFKBALJD() {
            if (this.unk3300OFOKFKBALJD_ == null) {
                return MapField.emptyMapField(Unk3300OFOKFKBALJDDefaultEntryHolder.defaultEntry);
            }
            return this.unk3300OFOKFKBALJD_;
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
        public int getUnk3300OFOKFKBALJDCount() {
            return internalGetUnk3300OFOKFKBALJD().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
        public boolean containsUnk3300OFOKFKBALJD(int key) {
            return internalGetUnk3300OFOKFKBALJD().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
        @Deprecated
        public Map<Integer, Integer> getUnk3300OFOKFKBALJD() {
            return getUnk3300OFOKFKBALJDMap();
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
        public Map<Integer, Integer> getUnk3300OFOKFKBALJDMap() {
            return internalGetUnk3300OFOKFKBALJD().getMap();
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
        public int getUnk3300OFOKFKBALJDOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetUnk3300OFOKFKBALJD().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
        public int getUnk3300OFOKFKBALJDOrThrow(int key) {
            Map<Integer, Integer> map = internalGetUnk3300OFOKFKBALJD().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteReturnNotifyOuterClass$MaterialDeleteReturnNotify$Unk3300LAIHDKJAHAFDefaultEntryHolder.class */
        public static final class Unk3300LAIHDKJAHAFDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(MaterialDeleteReturnNotifyOuterClass.f788x972e14a, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private Unk3300LAIHDKJAHAFDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetUnk3300LAIHDKJAHAF() {
            if (this.unk3300LAIHDKJAHAF_ == null) {
                return MapField.emptyMapField(Unk3300LAIHDKJAHAFDefaultEntryHolder.defaultEntry);
            }
            return this.unk3300LAIHDKJAHAF_;
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
        public int getUnk3300LAIHDKJAHAFCount() {
            return internalGetUnk3300LAIHDKJAHAF().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
        public boolean containsUnk3300LAIHDKJAHAF(int key) {
            return internalGetUnk3300LAIHDKJAHAF().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
        @Deprecated
        public Map<Integer, Integer> getUnk3300LAIHDKJAHAF() {
            return getUnk3300LAIHDKJAHAFMap();
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
        public Map<Integer, Integer> getUnk3300LAIHDKJAHAFMap() {
            return internalGetUnk3300LAIHDKJAHAF().getMap();
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
        public int getUnk3300LAIHDKJAHAFOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetUnk3300LAIHDKJAHAF().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
        public int getUnk3300LAIHDKJAHAFOrThrow(int key) {
            Map<Integer, Integer> map = internalGetUnk3300LAIHDKJAHAF().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.type_ != MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType.MATERIAL_DELETE_RETURN_TYPE_BAG.getNumber()) {
                output.writeEnum(7, this.type_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetUnk3300LAIHDKJAHAF(), Unk3300LAIHDKJAHAFDefaultEntryHolder.defaultEntry, 8);
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetUnk3300OFOKFKBALJD(), Unk3300OFOKFKBALJDDefaultEntryHolder.defaultEntry, 12);
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.type_ != MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType.MATERIAL_DELETE_RETURN_TYPE_BAG.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(7, this.type_);
            }
            for (Map.Entry<Integer, Integer> entry : internalGetUnk3300LAIHDKJAHAF().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(8, Unk3300LAIHDKJAHAFDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            for (Map.Entry<Integer, Integer> entry2 : internalGetUnk3300OFOKFKBALJD().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(12, Unk3300OFOKFKBALJDDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MaterialDeleteReturnNotify)) {
                return equals(obj);
            }
            MaterialDeleteReturnNotify other = (MaterialDeleteReturnNotify) obj;
            return this.type_ == other.type_ && internalGetUnk3300OFOKFKBALJD().equals(other.internalGetUnk3300OFOKFKBALJD()) && internalGetUnk3300LAIHDKJAHAF().equals(other.internalGetUnk3300LAIHDKJAHAF()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + this.type_;
            if (!internalGetUnk3300OFOKFKBALJD().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 12)) + internalGetUnk3300OFOKFKBALJD().hashCode();
            }
            if (!internalGetUnk3300LAIHDKJAHAF().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 8)) + internalGetUnk3300LAIHDKJAHAF().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MaterialDeleteReturnNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MaterialDeleteReturnNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MaterialDeleteReturnNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MaterialDeleteReturnNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MaterialDeleteReturnNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MaterialDeleteReturnNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MaterialDeleteReturnNotify parseFrom(InputStream input) throws IOException {
            return (MaterialDeleteReturnNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MaterialDeleteReturnNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MaterialDeleteReturnNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MaterialDeleteReturnNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (MaterialDeleteReturnNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MaterialDeleteReturnNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MaterialDeleteReturnNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MaterialDeleteReturnNotify parseFrom(CodedInputStream input) throws IOException {
            return (MaterialDeleteReturnNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MaterialDeleteReturnNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MaterialDeleteReturnNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MaterialDeleteReturnNotify prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
            return new Builder(parent);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteReturnNotifyOuterClass$MaterialDeleteReturnNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MaterialDeleteReturnNotifyOrBuilder {
            private int bitField0_;
            private int type_ = 0;
            private MapField<Integer, Integer> unk3300OFOKFKBALJD_;
            private MapField<Integer, Integer> unk3300LAIHDKJAHAF_;

            /*  JADX ERROR: Dependency scan failed at insn: 0x002B: INVOKE_CUSTOM r0
                java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
                	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
                */
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField
                jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                	... 8 more
                */
            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.MapField internalGetMapField(int r5) {
                /*
                    r4 = this;
                    r0 = r5
                    switch(r0) {
                        case 8: goto L_0x0021;
                        case 12: goto L_0x001c;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetUnk3300OFOKFKBALJD()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetUnk3300LAIHDKJAHAF()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField");
            }

            /*  JADX ERROR: Dependency scan failed at insn: 0x002B: INVOKE_CUSTOM r0
                java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
                	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
                */
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
                jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                	... 8 more
                */
            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.MapField internalGetMutableMapField(int r5) {
                /*
                    r4 = this;
                    r0 = r5
                    switch(r0) {
                        case 8: goto L_0x0021;
                        case 12: goto L_0x001c;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableUnk3300OFOKFKBALJD()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableUnk3300LAIHDKJAHAF()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MaterialDeleteReturnNotifyOuterClass.internal_static_MaterialDeleteReturnNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MaterialDeleteReturnNotifyOuterClass.internal_static_MaterialDeleteReturnNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(MaterialDeleteReturnNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MaterialDeleteReturnNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.type_ = 0;
                internalGetMutableUnk3300OFOKFKBALJD().clear();
                internalGetMutableUnk3300LAIHDKJAHAF().clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MaterialDeleteReturnNotifyOuterClass.internal_static_MaterialDeleteReturnNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MaterialDeleteReturnNotify getDefaultInstanceForType() {
                return MaterialDeleteReturnNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MaterialDeleteReturnNotify build() {
                MaterialDeleteReturnNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MaterialDeleteReturnNotify buildPartial() {
                MaterialDeleteReturnNotify result = new MaterialDeleteReturnNotify(this);
                int i = this.bitField0_;
                result.type_ = this.type_;
                result.unk3300OFOKFKBALJD_ = internalGetUnk3300OFOKFKBALJD();
                result.unk3300OFOKFKBALJD_.makeImmutable();
                result.unk3300LAIHDKJAHAF_ = internalGetUnk3300LAIHDKJAHAF();
                result.unk3300LAIHDKJAHAF_.makeImmutable();
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, java.lang.Object, com.google.protobuf.Message.Builder
            public Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor field, Object value) {
                return setField(field, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor field) {
                return clearField(field);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneof) {
                return clearOneof(oneof);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
                return setRepeatedField(field, index, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
                return addRepeatedField(field, value);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof MaterialDeleteReturnNotify) {
                    return mergeFrom((MaterialDeleteReturnNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MaterialDeleteReturnNotify other) {
                if (other == MaterialDeleteReturnNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.type_ != 0) {
                    setTypeValue(other.getTypeValue());
                }
                internalGetMutableUnk3300OFOKFKBALJD().mergeFrom(other.internalGetUnk3300OFOKFKBALJD());
                internalGetMutableUnk3300LAIHDKJAHAF().mergeFrom(other.internalGetUnk3300LAIHDKJAHAF());
                mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MaterialDeleteReturnNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = MaterialDeleteReturnNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MaterialDeleteReturnNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            public Builder setTypeValue(int value) {
                this.type_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
            public MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType getType() {
                MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType result = MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType.valueOf(this.type_);
                return result == null ? MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType.UNRECOGNIZED : result;
            }

            public Builder setType(MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.type_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetUnk3300OFOKFKBALJD() {
                if (this.unk3300OFOKFKBALJD_ == null) {
                    return MapField.emptyMapField(Unk3300OFOKFKBALJDDefaultEntryHolder.defaultEntry);
                }
                return this.unk3300OFOKFKBALJD_;
            }

            private MapField<Integer, Integer> internalGetMutableUnk3300OFOKFKBALJD() {
                onChanged();
                if (this.unk3300OFOKFKBALJD_ == null) {
                    this.unk3300OFOKFKBALJD_ = MapField.newMapField(Unk3300OFOKFKBALJDDefaultEntryHolder.defaultEntry);
                }
                if (!this.unk3300OFOKFKBALJD_.isMutable()) {
                    this.unk3300OFOKFKBALJD_ = this.unk3300OFOKFKBALJD_.copy();
                }
                return this.unk3300OFOKFKBALJD_;
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
            public int getUnk3300OFOKFKBALJDCount() {
                return internalGetUnk3300OFOKFKBALJD().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
            public boolean containsUnk3300OFOKFKBALJD(int key) {
                return internalGetUnk3300OFOKFKBALJD().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
            @Deprecated
            public Map<Integer, Integer> getUnk3300OFOKFKBALJD() {
                return getUnk3300OFOKFKBALJDMap();
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
            public Map<Integer, Integer> getUnk3300OFOKFKBALJDMap() {
                return internalGetUnk3300OFOKFKBALJD().getMap();
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
            public int getUnk3300OFOKFKBALJDOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetUnk3300OFOKFKBALJD().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
            public int getUnk3300OFOKFKBALJDOrThrow(int key) {
                Map<Integer, Integer> map = internalGetUnk3300OFOKFKBALJD().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearUnk3300OFOKFKBALJD() {
                internalGetMutableUnk3300OFOKFKBALJD().getMutableMap().clear();
                return this;
            }

            public Builder removeUnk3300OFOKFKBALJD(int key) {
                internalGetMutableUnk3300OFOKFKBALJD().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableUnk3300OFOKFKBALJD() {
                return internalGetMutableUnk3300OFOKFKBALJD().getMutableMap();
            }

            public Builder putUnk3300OFOKFKBALJD(int key, int value) {
                internalGetMutableUnk3300OFOKFKBALJD().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllUnk3300OFOKFKBALJD(Map<Integer, Integer> values) {
                internalGetMutableUnk3300OFOKFKBALJD().getMutableMap().putAll(values);
                return this;
            }

            private MapField<Integer, Integer> internalGetUnk3300LAIHDKJAHAF() {
                if (this.unk3300LAIHDKJAHAF_ == null) {
                    return MapField.emptyMapField(Unk3300LAIHDKJAHAFDefaultEntryHolder.defaultEntry);
                }
                return this.unk3300LAIHDKJAHAF_;
            }

            private MapField<Integer, Integer> internalGetMutableUnk3300LAIHDKJAHAF() {
                onChanged();
                if (this.unk3300LAIHDKJAHAF_ == null) {
                    this.unk3300LAIHDKJAHAF_ = MapField.newMapField(Unk3300LAIHDKJAHAFDefaultEntryHolder.defaultEntry);
                }
                if (!this.unk3300LAIHDKJAHAF_.isMutable()) {
                    this.unk3300LAIHDKJAHAF_ = this.unk3300LAIHDKJAHAF_.copy();
                }
                return this.unk3300LAIHDKJAHAF_;
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
            public int getUnk3300LAIHDKJAHAFCount() {
                return internalGetUnk3300LAIHDKJAHAF().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
            public boolean containsUnk3300LAIHDKJAHAF(int key) {
                return internalGetUnk3300LAIHDKJAHAF().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
            @Deprecated
            public Map<Integer, Integer> getUnk3300LAIHDKJAHAF() {
                return getUnk3300LAIHDKJAHAFMap();
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
            public Map<Integer, Integer> getUnk3300LAIHDKJAHAFMap() {
                return internalGetUnk3300LAIHDKJAHAF().getMap();
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
            public int getUnk3300LAIHDKJAHAFOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetUnk3300LAIHDKJAHAF().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteReturnNotifyOuterClass.MaterialDeleteReturnNotifyOrBuilder
            public int getUnk3300LAIHDKJAHAFOrThrow(int key) {
                Map<Integer, Integer> map = internalGetUnk3300LAIHDKJAHAF().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearUnk3300LAIHDKJAHAF() {
                internalGetMutableUnk3300LAIHDKJAHAF().getMutableMap().clear();
                return this;
            }

            public Builder removeUnk3300LAIHDKJAHAF(int key) {
                internalGetMutableUnk3300LAIHDKJAHAF().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableUnk3300LAIHDKJAHAF() {
                return internalGetMutableUnk3300LAIHDKJAHAF().getMutableMap();
            }

            public Builder putUnk3300LAIHDKJAHAF(int key, int value) {
                internalGetMutableUnk3300LAIHDKJAHAF().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllUnk3300LAIHDKJAHAF(Map<Integer, Integer> values) {
                internalGetMutableUnk3300LAIHDKJAHAF().getMutableMap().putAll(values);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static MaterialDeleteReturnNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MaterialDeleteReturnNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MaterialDeleteReturnNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MaterialDeleteReturnNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MaterialDeleteReturnTypeOuterClass.getDescriptor();
    }
}
