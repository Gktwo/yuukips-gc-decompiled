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
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabBuffSchemeInfoOuterClass.class */
public final class ChannelerSlabBuffSchemeInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!ChannelerSlabBuffSchemeInfo.proto\"Ã\u0001\n\u001bChannelerSlabBuffSchemeInfo\u0012:\n\u0007slotMap\u0018\t \u0003(\u000b2).ChannelerSlabBuffSchemeInfo.SlotMapEntry\u0012\u001b\n\u0013Unk3300_NCMDDAFNENO\u0018\u0001 \u0001(\r\u0012\u001b\n\u0013Unk3300_CKMNFOCNMGL\u0018\n \u0001(\r\u001a.\n\fSlotMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ChannelerSlabBuffSchemeInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChannelerSlabBuffSchemeInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChannelerSlabBuffSchemeInfo_descriptor, new String[]{"SlotMap", "Unk3300NCMDDAFNENO", "Unk3300CKMNFOCNMGL"});

    /* renamed from: internal_static_ChannelerSlabBuffSchemeInfo_SlotMapEntry_descriptor */
    private static final Descriptors.Descriptor f669xc06a247c = internal_static_ChannelerSlabBuffSchemeInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_ChannelerSlabBuffSchemeInfo_SlotMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f670x4a9b0efa = new GeneratedMessageV3.FieldAccessorTable(f669xc06a247c, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabBuffSchemeInfoOuterClass$ChannelerSlabBuffSchemeInfoOrBuilder.class */
    public interface ChannelerSlabBuffSchemeInfoOrBuilder extends MessageOrBuilder {
        int getSlotMapCount();

        boolean containsSlotMap(int i);

        @Deprecated
        Map<Integer, Integer> getSlotMap();

        Map<Integer, Integer> getSlotMapMap();

        int getSlotMapOrDefault(int i, int i2);

        int getSlotMapOrThrow(int i);

        int getUnk3300NCMDDAFNENO();

        int getUnk3300CKMNFOCNMGL();
    }

    private ChannelerSlabBuffSchemeInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabBuffSchemeInfoOuterClass$ChannelerSlabBuffSchemeInfo.class */
    public static final class ChannelerSlabBuffSchemeInfo extends GeneratedMessageV3 implements ChannelerSlabBuffSchemeInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SLOTMAP_FIELD_NUMBER = 9;
        private MapField<Integer, Integer> slotMap_;
        public static final int UNK3300_NCMDDAFNENO_FIELD_NUMBER = 1;
        private int unk3300NCMDDAFNENO_;
        public static final int UNK3300_CKMNFOCNMGL_FIELD_NUMBER = 10;
        private int unk3300CKMNFOCNMGL_;
        private byte memoizedIsInitialized;
        private static final ChannelerSlabBuffSchemeInfo DEFAULT_INSTANCE = new ChannelerSlabBuffSchemeInfo();
        private static final Parser<ChannelerSlabBuffSchemeInfo> PARSER = new AbstractParser<ChannelerSlabBuffSchemeInfo>() { // from class: emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.1
            @Override // com.google.protobuf.Parser
            public ChannelerSlabBuffSchemeInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChannelerSlabBuffSchemeInfo(input, extensionRegistry);
            }
        };

        /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r0
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.internalGetMapField(int):com.google.protobuf.MapField
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
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
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
                    case 9: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetSlotMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private ChannelerSlabBuffSchemeInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ChannelerSlabBuffSchemeInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChannelerSlabBuffSchemeInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChannelerSlabBuffSchemeInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.unk3300NCMDDAFNENO_ = input.readUInt32();
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.slotMap_ = MapField.newMapField(SlotMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, Integer> slotMap__ = (MapEntry) input.readMessage(SlotMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.slotMap_.getMutableMap().put(slotMap__.getKey(), slotMap__.getValue());
                                break;
                            case 80:
                                this.unk3300CKMNFOCNMGL_ = input.readUInt32();
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
            return ChannelerSlabBuffSchemeInfoOuterClass.internal_static_ChannelerSlabBuffSchemeInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChannelerSlabBuffSchemeInfoOuterClass.internal_static_ChannelerSlabBuffSchemeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ChannelerSlabBuffSchemeInfo.class, Builder.class);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabBuffSchemeInfoOuterClass$ChannelerSlabBuffSchemeInfo$SlotMapDefaultEntryHolder.class */
        public static final class SlotMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(ChannelerSlabBuffSchemeInfoOuterClass.f669xc06a247c, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private SlotMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetSlotMap() {
            if (this.slotMap_ == null) {
                return MapField.emptyMapField(SlotMapDefaultEntryHolder.defaultEntry);
            }
            return this.slotMap_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder
        public int getSlotMapCount() {
            return internalGetSlotMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder
        public boolean containsSlotMap(int key) {
            return internalGetSlotMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getSlotMap() {
            return getSlotMapMap();
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder
        public Map<Integer, Integer> getSlotMapMap() {
            return internalGetSlotMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder
        public int getSlotMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetSlotMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder
        public int getSlotMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetSlotMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder
        public int getUnk3300NCMDDAFNENO() {
            return this.unk3300NCMDDAFNENO_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder
        public int getUnk3300CKMNFOCNMGL() {
            return this.unk3300CKMNFOCNMGL_;
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
            if (this.unk3300NCMDDAFNENO_ != 0) {
                output.writeUInt32(1, this.unk3300NCMDDAFNENO_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetSlotMap(), SlotMapDefaultEntryHolder.defaultEntry, 9);
            if (this.unk3300CKMNFOCNMGL_ != 0) {
                output.writeUInt32(10, this.unk3300CKMNFOCNMGL_);
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.unk3300NCMDDAFNENO_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.unk3300NCMDDAFNENO_);
            }
            for (Map.Entry<Integer, Integer> entry : internalGetSlotMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(9, SlotMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.unk3300CKMNFOCNMGL_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.unk3300CKMNFOCNMGL_);
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
            if (!(obj instanceof ChannelerSlabBuffSchemeInfo)) {
                return equals(obj);
            }
            ChannelerSlabBuffSchemeInfo other = (ChannelerSlabBuffSchemeInfo) obj;
            return internalGetSlotMap().equals(other.internalGetSlotMap()) && getUnk3300NCMDDAFNENO() == other.getUnk3300NCMDDAFNENO() && getUnk3300CKMNFOCNMGL() == other.getUnk3300CKMNFOCNMGL() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (!internalGetSlotMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 9)) + internalGetSlotMap().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 1)) + getUnk3300NCMDDAFNENO())) + 10)) + getUnk3300CKMNFOCNMGL())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ChannelerSlabBuffSchemeInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabBuffSchemeInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabBuffSchemeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabBuffSchemeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabBuffSchemeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabBuffSchemeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabBuffSchemeInfo parseFrom(InputStream input) throws IOException {
            return (ChannelerSlabBuffSchemeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChannelerSlabBuffSchemeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabBuffSchemeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChannelerSlabBuffSchemeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ChannelerSlabBuffSchemeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChannelerSlabBuffSchemeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabBuffSchemeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChannelerSlabBuffSchemeInfo parseFrom(CodedInputStream input) throws IOException {
            return (ChannelerSlabBuffSchemeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChannelerSlabBuffSchemeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabBuffSchemeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChannelerSlabBuffSchemeInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabBuffSchemeInfoOuterClass$ChannelerSlabBuffSchemeInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChannelerSlabBuffSchemeInfoOrBuilder {
            private int bitField0_;
            private MapField<Integer, Integer> slotMap_;
            private int unk3300NCMDDAFNENO_;
            private int unk3300CKMNFOCNMGL_;

            /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r0
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 9: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetSlotMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
            }

            /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r0
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 9: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableSlotMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ChannelerSlabBuffSchemeInfoOuterClass.internal_static_ChannelerSlabBuffSchemeInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChannelerSlabBuffSchemeInfoOuterClass.internal_static_ChannelerSlabBuffSchemeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ChannelerSlabBuffSchemeInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChannelerSlabBuffSchemeInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                internalGetMutableSlotMap().clear();
                this.unk3300NCMDDAFNENO_ = 0;
                this.unk3300CKMNFOCNMGL_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChannelerSlabBuffSchemeInfoOuterClass.internal_static_ChannelerSlabBuffSchemeInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChannelerSlabBuffSchemeInfo getDefaultInstanceForType() {
                return ChannelerSlabBuffSchemeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChannelerSlabBuffSchemeInfo build() {
                ChannelerSlabBuffSchemeInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChannelerSlabBuffSchemeInfo buildPartial() {
                ChannelerSlabBuffSchemeInfo result = new ChannelerSlabBuffSchemeInfo(this);
                int i = this.bitField0_;
                result.slotMap_ = internalGetSlotMap();
                result.slotMap_.makeImmutable();
                result.unk3300NCMDDAFNENO_ = this.unk3300NCMDDAFNENO_;
                result.unk3300CKMNFOCNMGL_ = this.unk3300CKMNFOCNMGL_;
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
                if (other instanceof ChannelerSlabBuffSchemeInfo) {
                    return mergeFrom((ChannelerSlabBuffSchemeInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChannelerSlabBuffSchemeInfo other) {
                if (other == ChannelerSlabBuffSchemeInfo.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableSlotMap().mergeFrom(other.internalGetSlotMap());
                if (other.getUnk3300NCMDDAFNENO() != 0) {
                    setUnk3300NCMDDAFNENO(other.getUnk3300NCMDDAFNENO());
                }
                if (other.getUnk3300CKMNFOCNMGL() != 0) {
                    setUnk3300CKMNFOCNMGL(other.getUnk3300CKMNFOCNMGL());
                }
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
                ChannelerSlabBuffSchemeInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChannelerSlabBuffSchemeInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChannelerSlabBuffSchemeInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private MapField<Integer, Integer> internalGetSlotMap() {
                if (this.slotMap_ == null) {
                    return MapField.emptyMapField(SlotMapDefaultEntryHolder.defaultEntry);
                }
                return this.slotMap_;
            }

            private MapField<Integer, Integer> internalGetMutableSlotMap() {
                onChanged();
                if (this.slotMap_ == null) {
                    this.slotMap_ = MapField.newMapField(SlotMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.slotMap_.isMutable()) {
                    this.slotMap_ = this.slotMap_.copy();
                }
                return this.slotMap_;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder
            public int getSlotMapCount() {
                return internalGetSlotMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder
            public boolean containsSlotMap(int key) {
                return internalGetSlotMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getSlotMap() {
                return getSlotMapMap();
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder
            public Map<Integer, Integer> getSlotMapMap() {
                return internalGetSlotMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder
            public int getSlotMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetSlotMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder
            public int getSlotMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetSlotMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearSlotMap() {
                internalGetMutableSlotMap().getMutableMap().clear();
                return this;
            }

            public Builder removeSlotMap(int key) {
                internalGetMutableSlotMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableSlotMap() {
                return internalGetMutableSlotMap().getMutableMap();
            }

            public Builder putSlotMap(int key, int value) {
                internalGetMutableSlotMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllSlotMap(Map<Integer, Integer> values) {
                internalGetMutableSlotMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder
            public int getUnk3300NCMDDAFNENO() {
                return this.unk3300NCMDDAFNENO_;
            }

            public Builder setUnk3300NCMDDAFNENO(int value) {
                this.unk3300NCMDDAFNENO_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300NCMDDAFNENO() {
                this.unk3300NCMDDAFNENO_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder
            public int getUnk3300CKMNFOCNMGL() {
                return this.unk3300CKMNFOCNMGL_;
            }

            public Builder setUnk3300CKMNFOCNMGL(int value) {
                this.unk3300CKMNFOCNMGL_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300CKMNFOCNMGL() {
                this.unk3300CKMNFOCNMGL_ = 0;
                onChanged();
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

        public static ChannelerSlabBuffSchemeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChannelerSlabBuffSchemeInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChannelerSlabBuffSchemeInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChannelerSlabBuffSchemeInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
