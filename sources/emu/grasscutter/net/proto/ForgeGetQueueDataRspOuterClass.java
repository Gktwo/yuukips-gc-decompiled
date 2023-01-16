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
import emu.grasscutter.net.proto.ForgeQueueDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeGetQueueDataRspOuterClass.class */
public final class ForgeGetQueueDataRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aForgeGetQueueDataRsp.proto\u001a\u0014ForgeQueueData.proto\"È\u0001\n\u0014ForgeGetQueueDataRsp\u0012\u0015\n\rmax_queue_num\u0018\u0004 \u0001(\r\u0012A\n\u000fforge_queue_map\u0018\t \u0003(\u000b2(.ForgeGetQueueDataRsp.ForgeQueueMapEntry\u0012\u000f\n\u0007retcode\u0018\u000f \u0001(\u0005\u001aE\n\u0012ForgeQueueMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\u001e\n\u0005value\u0018\u0002 \u0001(\u000b2\u000f.ForgeQueueData:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ForgeQueueDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ForgeGetQueueDataRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ForgeGetQueueDataRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ForgeGetQueueDataRsp_descriptor, new String[]{"MaxQueueNum", "ForgeQueueMap", "Retcode"});

    /* renamed from: internal_static_ForgeGetQueueDataRsp_ForgeQueueMapEntry_descriptor */
    private static final Descriptors.Descriptor f719xe8b92fc1 = internal_static_ForgeGetQueueDataRsp_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_ForgeGetQueueDataRsp_ForgeQueueMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f720x9b21053f = new GeneratedMessageV3.FieldAccessorTable(f719xe8b92fc1, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeGetQueueDataRspOuterClass$ForgeGetQueueDataRspOrBuilder.class */
    public interface ForgeGetQueueDataRspOrBuilder extends MessageOrBuilder {
        int getMaxQueueNum();

        int getForgeQueueMapCount();

        boolean containsForgeQueueMap(int i);

        @Deprecated
        Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> getForgeQueueMap();

        Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> getForgeQueueMapMap();

        ForgeQueueDataOuterClass.ForgeQueueData getForgeQueueMapOrDefault(int i, ForgeQueueDataOuterClass.ForgeQueueData forgeQueueData);

        ForgeQueueDataOuterClass.ForgeQueueData getForgeQueueMapOrThrow(int i);

        int getRetcode();
    }

    private ForgeGetQueueDataRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeGetQueueDataRspOuterClass$ForgeGetQueueDataRsp.class */
    public static final class ForgeGetQueueDataRsp extends GeneratedMessageV3 implements ForgeGetQueueDataRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MAX_QUEUE_NUM_FIELD_NUMBER = 4;
        private int maxQueueNum_;
        public static final int FORGE_QUEUE_MAP_FIELD_NUMBER = 9;
        private MapField<Integer, ForgeQueueDataOuterClass.ForgeQueueData> forgeQueueMap_;
        public static final int RETCODE_FIELD_NUMBER = 15;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final ForgeGetQueueDataRsp DEFAULT_INSTANCE = new ForgeGetQueueDataRsp();
        private static final Parser<ForgeGetQueueDataRsp> PARSER = new AbstractParser<ForgeGetQueueDataRsp>() { // from class: emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRsp.1
            @Override // com.google.protobuf.Parser
            public ForgeGetQueueDataRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ForgeGetQueueDataRsp(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRsp.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 9: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetForgeQueueMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRsp.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private ForgeGetQueueDataRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ForgeGetQueueDataRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ForgeGetQueueDataRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ForgeGetQueueDataRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                this.maxQueueNum_ = input.readUInt32();
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.forgeQueueMap_ = MapField.newMapField(ForgeQueueMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, ForgeQueueDataOuterClass.ForgeQueueData> forgeQueueMap__ = (MapEntry) input.readMessage(ForgeQueueMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.forgeQueueMap_.getMutableMap().put(forgeQueueMap__.getKey(), forgeQueueMap__.getValue());
                                break;
                            case 120:
                                this.retcode_ = input.readInt32();
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
            return ForgeGetQueueDataRspOuterClass.internal_static_ForgeGetQueueDataRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ForgeGetQueueDataRspOuterClass.internal_static_ForgeGetQueueDataRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(ForgeGetQueueDataRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRspOrBuilder
        public int getMaxQueueNum() {
            return this.maxQueueNum_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeGetQueueDataRspOuterClass$ForgeGetQueueDataRsp$ForgeQueueMapDefaultEntryHolder.class */
        public static final class ForgeQueueMapDefaultEntryHolder {
            static final MapEntry<Integer, ForgeQueueDataOuterClass.ForgeQueueData> defaultEntry = MapEntry.newDefaultInstance(ForgeGetQueueDataRspOuterClass.f719xe8b92fc1, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, ForgeQueueDataOuterClass.ForgeQueueData.getDefaultInstance());

            private ForgeQueueMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, ForgeQueueDataOuterClass.ForgeQueueData> internalGetForgeQueueMap() {
            if (this.forgeQueueMap_ == null) {
                return MapField.emptyMapField(ForgeQueueMapDefaultEntryHolder.defaultEntry);
            }
            return this.forgeQueueMap_;
        }

        @Override // emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRspOrBuilder
        public int getForgeQueueMapCount() {
            return internalGetForgeQueueMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRspOrBuilder
        public boolean containsForgeQueueMap(int key) {
            return internalGetForgeQueueMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRspOrBuilder
        @Deprecated
        public Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> getForgeQueueMap() {
            return getForgeQueueMapMap();
        }

        @Override // emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRspOrBuilder
        public Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> getForgeQueueMapMap() {
            return internalGetForgeQueueMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRspOrBuilder
        public ForgeQueueDataOuterClass.ForgeQueueData getForgeQueueMapOrDefault(int key, ForgeQueueDataOuterClass.ForgeQueueData defaultValue) {
            Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> map = internalGetForgeQueueMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRspOrBuilder
        public ForgeQueueDataOuterClass.ForgeQueueData getForgeQueueMapOrThrow(int key) {
            Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> map = internalGetForgeQueueMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
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
            if (this.maxQueueNum_ != 0) {
                output.writeUInt32(4, this.maxQueueNum_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetForgeQueueMap(), ForgeQueueMapDefaultEntryHolder.defaultEntry, 9);
            if (this.retcode_ != 0) {
                output.writeInt32(15, this.retcode_);
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
            if (this.maxQueueNum_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.maxQueueNum_);
            }
            for (Map.Entry<Integer, ForgeQueueDataOuterClass.ForgeQueueData> entry : internalGetForgeQueueMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(9, ForgeQueueMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(15, this.retcode_);
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
            if (!(obj instanceof ForgeGetQueueDataRsp)) {
                return equals(obj);
            }
            ForgeGetQueueDataRsp other = (ForgeGetQueueDataRsp) obj;
            return getMaxQueueNum() == other.getMaxQueueNum() && internalGetForgeQueueMap().equals(other.internalGetForgeQueueMap()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getMaxQueueNum();
            if (!internalGetForgeQueueMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 9)) + internalGetForgeQueueMap().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 15)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ForgeGetQueueDataRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForgeGetQueueDataRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForgeGetQueueDataRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForgeGetQueueDataRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForgeGetQueueDataRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForgeGetQueueDataRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForgeGetQueueDataRsp parseFrom(InputStream input) throws IOException {
            return (ForgeGetQueueDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ForgeGetQueueDataRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForgeGetQueueDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ForgeGetQueueDataRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (ForgeGetQueueDataRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ForgeGetQueueDataRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForgeGetQueueDataRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ForgeGetQueueDataRsp parseFrom(CodedInputStream input) throws IOException {
            return (ForgeGetQueueDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ForgeGetQueueDataRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForgeGetQueueDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ForgeGetQueueDataRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeGetQueueDataRspOuterClass$ForgeGetQueueDataRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ForgeGetQueueDataRspOrBuilder {
            private int bitField0_;
            private int maxQueueNum_;
            private MapField<Integer, ForgeQueueDataOuterClass.ForgeQueueData> forgeQueueMap_;
            private int retcode_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRsp.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetForgeQueueMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRsp.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRsp.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetMutableForgeQueueMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRsp.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ForgeGetQueueDataRspOuterClass.internal_static_ForgeGetQueueDataRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ForgeGetQueueDataRspOuterClass.internal_static_ForgeGetQueueDataRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(ForgeGetQueueDataRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ForgeGetQueueDataRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.maxQueueNum_ = 0;
                internalGetMutableForgeQueueMap().clear();
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ForgeGetQueueDataRspOuterClass.internal_static_ForgeGetQueueDataRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ForgeGetQueueDataRsp getDefaultInstanceForType() {
                return ForgeGetQueueDataRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ForgeGetQueueDataRsp build() {
                ForgeGetQueueDataRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ForgeGetQueueDataRsp buildPartial() {
                ForgeGetQueueDataRsp result = new ForgeGetQueueDataRsp(this);
                int i = this.bitField0_;
                result.maxQueueNum_ = this.maxQueueNum_;
                result.forgeQueueMap_ = internalGetForgeQueueMap();
                result.forgeQueueMap_.makeImmutable();
                result.retcode_ = this.retcode_;
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
                if (other instanceof ForgeGetQueueDataRsp) {
                    return mergeFrom((ForgeGetQueueDataRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ForgeGetQueueDataRsp other) {
                if (other == ForgeGetQueueDataRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getMaxQueueNum() != 0) {
                    setMaxQueueNum(other.getMaxQueueNum());
                }
                internalGetMutableForgeQueueMap().mergeFrom(other.internalGetForgeQueueMap());
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                ForgeGetQueueDataRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = ForgeGetQueueDataRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ForgeGetQueueDataRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRspOrBuilder
            public int getMaxQueueNum() {
                return this.maxQueueNum_;
            }

            public Builder setMaxQueueNum(int value) {
                this.maxQueueNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxQueueNum() {
                this.maxQueueNum_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, ForgeQueueDataOuterClass.ForgeQueueData> internalGetForgeQueueMap() {
                if (this.forgeQueueMap_ == null) {
                    return MapField.emptyMapField(ForgeQueueMapDefaultEntryHolder.defaultEntry);
                }
                return this.forgeQueueMap_;
            }

            private MapField<Integer, ForgeQueueDataOuterClass.ForgeQueueData> internalGetMutableForgeQueueMap() {
                onChanged();
                if (this.forgeQueueMap_ == null) {
                    this.forgeQueueMap_ = MapField.newMapField(ForgeQueueMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.forgeQueueMap_.isMutable()) {
                    this.forgeQueueMap_ = this.forgeQueueMap_.copy();
                }
                return this.forgeQueueMap_;
            }

            @Override // emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRspOrBuilder
            public int getForgeQueueMapCount() {
                return internalGetForgeQueueMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRspOrBuilder
            public boolean containsForgeQueueMap(int key) {
                return internalGetForgeQueueMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRspOrBuilder
            @Deprecated
            public Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> getForgeQueueMap() {
                return getForgeQueueMapMap();
            }

            @Override // emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRspOrBuilder
            public Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> getForgeQueueMapMap() {
                return internalGetForgeQueueMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRspOrBuilder
            public ForgeQueueDataOuterClass.ForgeQueueData getForgeQueueMapOrDefault(int key, ForgeQueueDataOuterClass.ForgeQueueData defaultValue) {
                Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> map = internalGetForgeQueueMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRspOrBuilder
            public ForgeQueueDataOuterClass.ForgeQueueData getForgeQueueMapOrThrow(int key) {
                Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> map = internalGetForgeQueueMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearForgeQueueMap() {
                internalGetMutableForgeQueueMap().getMutableMap().clear();
                return this;
            }

            public Builder removeForgeQueueMap(int key) {
                internalGetMutableForgeQueueMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> getMutableForgeQueueMap() {
                return internalGetMutableForgeQueueMap().getMutableMap();
            }

            public Builder putForgeQueueMap(int key, ForgeQueueDataOuterClass.ForgeQueueData value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableForgeQueueMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllForgeQueueMap(Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> values) {
                internalGetMutableForgeQueueMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.ForgeGetQueueDataRspOuterClass.ForgeGetQueueDataRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
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

        public static ForgeGetQueueDataRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ForgeGetQueueDataRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ForgeGetQueueDataRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ForgeGetQueueDataRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ForgeQueueDataOuterClass.getDescriptor();
    }
}
