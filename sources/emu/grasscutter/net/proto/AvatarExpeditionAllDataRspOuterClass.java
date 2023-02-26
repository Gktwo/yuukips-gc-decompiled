package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import emu.grasscutter.net.proto.AvatarExpeditionInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionAllDataRspOuterClass.class */
public final class AvatarExpeditionAllDataRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n AvatarExpeditionAllDataRsp.proto\u001a\u001aAvatarExpeditionInfo.proto\"\u0002\n\u001aAvatarExpeditionAllDataRsp\u0012\u001c\n\u0014expeditionCountLimit\u0018\f \u0001(\r\u0012\u001a\n\u0012openExpeditionList\u0018\t \u0003(\r\u0012\u000f\n\u0007retcode\u0018\u0004 \u0001(\u0005\u0012M\n\u0011expeditionInfoMap\u0018\n \u0003(\u000b22.AvatarExpeditionAllDataRsp.ExpeditionInfoMapEntry\u001aO\n\u0016ExpeditionInfoMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\u0004\u0012$\n\u0005value\u0018\u0002 \u0001(\u000b2\u0015.AvatarExpeditionInfo:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AvatarExpeditionInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AvatarExpeditionAllDataRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarExpeditionAllDataRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarExpeditionAllDataRsp_descriptor, new String[]{"ExpeditionCountLimit", "OpenExpeditionList", "Retcode", "ExpeditionInfoMap"});

    /* renamed from: internal_static_AvatarExpeditionAllDataRsp_ExpeditionInfoMapEntry_descriptor */
    private static final Descriptors.Descriptor f626xba2e08f7 = internal_static_AvatarExpeditionAllDataRsp_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_AvatarExpeditionAllDataRsp_ExpeditionInfoMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f627x11c4875 = new GeneratedMessageV3.FieldAccessorTable(f626xba2e08f7, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionAllDataRspOuterClass$AvatarExpeditionAllDataRspOrBuilder.class */
    public interface AvatarExpeditionAllDataRspOrBuilder extends MessageOrBuilder {
        int getExpeditionCountLimit();

        List<Integer> getOpenExpeditionListList();

        int getOpenExpeditionListCount();

        int getOpenExpeditionList(int i);

        int getRetcode();

        int getExpeditionInfoMapCount();

        boolean containsExpeditionInfoMap(long j);

        @Deprecated
        Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMap();

        Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMapMap();

        AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo getExpeditionInfoMapOrDefault(long j, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo avatarExpeditionInfo);

        AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo getExpeditionInfoMapOrThrow(long j);
    }

    private AvatarExpeditionAllDataRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionAllDataRspOuterClass$AvatarExpeditionAllDataRsp.class */
    public static final class AvatarExpeditionAllDataRsp extends GeneratedMessageV3 implements AvatarExpeditionAllDataRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int EXPEDITIONCOUNTLIMIT_FIELD_NUMBER = 12;
        private int expeditionCountLimit_;
        public static final int OPENEXPEDITIONLIST_FIELD_NUMBER = 9;
        private Internal.IntList openExpeditionList_;
        private int openExpeditionListMemoizedSerializedSize;
        public static final int RETCODE_FIELD_NUMBER = 4;
        private int retcode_;
        public static final int EXPEDITIONINFOMAP_FIELD_NUMBER = 10;
        private MapField<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> expeditionInfoMap_;
        private byte memoizedIsInitialized;
        private static final AvatarExpeditionAllDataRsp DEFAULT_INSTANCE = new AvatarExpeditionAllDataRsp();
        private static final Parser<AvatarExpeditionAllDataRsp> PARSER = new AbstractParser<AvatarExpeditionAllDataRsp>() { // from class: emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRsp.1
            @Override // com.google.protobuf.Parser
            public AvatarExpeditionAllDataRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarExpeditionAllDataRsp(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRsp.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 10: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetExpeditionInfoMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRsp.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private AvatarExpeditionAllDataRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.openExpeditionListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private AvatarExpeditionAllDataRsp() {
            this.openExpeditionListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.openExpeditionList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarExpeditionAllDataRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarExpeditionAllDataRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_;
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                mutable_bitField0_ = 0;
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 32:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 72:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.openExpeditionList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.openExpeditionList_.addInt(input.readUInt32());
                                    break;
                                case 74:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.openExpeditionList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.openExpeditionList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 82:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.expeditionInfoMap_ = MapField.newMapField(ExpeditionInfoMapDefaultEntryHolder.defaultEntry);
                                        mutable_bitField0_ |= 2;
                                    }
                                    MapEntry<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> expeditionInfoMap__ = (MapEntry) input.readMessage(ExpeditionInfoMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                    this.expeditionInfoMap_.getMutableMap().put(expeditionInfoMap__.getKey(), expeditionInfoMap__.getValue());
                                    break;
                                case 96:
                                    this.expeditionCountLimit_ = input.readUInt32();
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.openExpeditionList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvatarExpeditionAllDataRspOuterClass.internal_static_AvatarExpeditionAllDataRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarExpeditionAllDataRspOuterClass.internal_static_AvatarExpeditionAllDataRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarExpeditionAllDataRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRspOrBuilder
        public int getExpeditionCountLimit() {
            return this.expeditionCountLimit_;
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRspOrBuilder
        public List<Integer> getOpenExpeditionListList() {
            return this.openExpeditionList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRspOrBuilder
        public int getOpenExpeditionListCount() {
            return this.openExpeditionList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRspOrBuilder
        public int getOpenExpeditionList(int index) {
            return this.openExpeditionList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionAllDataRspOuterClass$AvatarExpeditionAllDataRsp$ExpeditionInfoMapDefaultEntryHolder.class */
        public static final class ExpeditionInfoMapDefaultEntryHolder {
            static final MapEntry<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> defaultEntry = MapEntry.newDefaultInstance(AvatarExpeditionAllDataRspOuterClass.f626xba2e08f7, WireFormat.FieldType.UINT64, 0L, WireFormat.FieldType.MESSAGE, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo.getDefaultInstance());

            private ExpeditionInfoMapDefaultEntryHolder() {
            }
        }

        private MapField<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> internalGetExpeditionInfoMap() {
            if (this.expeditionInfoMap_ == null) {
                return MapField.emptyMapField(ExpeditionInfoMapDefaultEntryHolder.defaultEntry);
            }
            return this.expeditionInfoMap_;
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRspOrBuilder
        public int getExpeditionInfoMapCount() {
            return internalGetExpeditionInfoMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRspOrBuilder
        public boolean containsExpeditionInfoMap(long key) {
            return internalGetExpeditionInfoMap().getMap().containsKey(Long.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRspOrBuilder
        @Deprecated
        public Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMap() {
            return getExpeditionInfoMapMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRspOrBuilder
        public Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMapMap() {
            return internalGetExpeditionInfoMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRspOrBuilder
        public AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo getExpeditionInfoMapOrDefault(long key, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo defaultValue) {
            Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> map = internalGetExpeditionInfoMap().getMap();
            return map.containsKey(Long.valueOf(key)) ? map.get(Long.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRspOrBuilder
        public AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo getExpeditionInfoMapOrThrow(long key) {
            Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> map = internalGetExpeditionInfoMap().getMap();
            if (map.containsKey(Long.valueOf(key))) {
                return map.get(Long.valueOf(key));
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
            getSerializedSize();
            if (this.retcode_ != 0) {
                output.writeInt32(4, this.retcode_);
            }
            if (getOpenExpeditionListList().size() > 0) {
                output.writeUInt32NoTag(74);
                output.writeUInt32NoTag(this.openExpeditionListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.openExpeditionList_.size(); i++) {
                output.writeUInt32NoTag(this.openExpeditionList_.getInt(i));
            }
            GeneratedMessageV3.serializeLongMapTo(output, internalGetExpeditionInfoMap(), ExpeditionInfoMapDefaultEntryHolder.defaultEntry, 10);
            if (this.expeditionCountLimit_ != 0) {
                output.writeUInt32(12, this.expeditionCountLimit_);
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
            if (this.retcode_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(4, this.retcode_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.openExpeditionList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.openExpeditionList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getOpenExpeditionListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.openExpeditionListMemoizedSerializedSize = dataSize;
            for (Map.Entry<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> entry : internalGetExpeditionInfoMap().getMap().entrySet()) {
                size3 += CodedOutputStream.computeMessageSize(10, ExpeditionInfoMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.expeditionCountLimit_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(12, this.expeditionCountLimit_);
            }
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AvatarExpeditionAllDataRsp)) {
                return equals(obj);
            }
            AvatarExpeditionAllDataRsp other = (AvatarExpeditionAllDataRsp) obj;
            return getExpeditionCountLimit() == other.getExpeditionCountLimit() && getOpenExpeditionListList().equals(other.getOpenExpeditionListList()) && getRetcode() == other.getRetcode() && internalGetExpeditionInfoMap().equals(other.internalGetExpeditionInfoMap()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + getExpeditionCountLimit();
            if (getOpenExpeditionListCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getOpenExpeditionListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 4)) + getRetcode();
            if (!internalGetExpeditionInfoMap().getMap().isEmpty()) {
                hash2 = (53 * ((37 * hash2) + 10)) + internalGetExpeditionInfoMap().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static AvatarExpeditionAllDataRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarExpeditionAllDataRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarExpeditionAllDataRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarExpeditionAllDataRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarExpeditionAllDataRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarExpeditionAllDataRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarExpeditionAllDataRsp parseFrom(InputStream input) throws IOException {
            return (AvatarExpeditionAllDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarExpeditionAllDataRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarExpeditionAllDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarExpeditionAllDataRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarExpeditionAllDataRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarExpeditionAllDataRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarExpeditionAllDataRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarExpeditionAllDataRsp parseFrom(CodedInputStream input) throws IOException {
            return (AvatarExpeditionAllDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarExpeditionAllDataRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarExpeditionAllDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarExpeditionAllDataRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionAllDataRspOuterClass$AvatarExpeditionAllDataRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarExpeditionAllDataRspOrBuilder {
            private int bitField0_;
            private int expeditionCountLimit_;
            private Internal.IntList openExpeditionList_ = AvatarExpeditionAllDataRsp.emptyIntList();
            private int retcode_;
            private MapField<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> expeditionInfoMap_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRsp.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 10: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetExpeditionInfoMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRsp.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRsp.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 10: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableExpeditionInfoMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRsp.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarExpeditionAllDataRspOuterClass.internal_static_AvatarExpeditionAllDataRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarExpeditionAllDataRspOuterClass.internal_static_AvatarExpeditionAllDataRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarExpeditionAllDataRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarExpeditionAllDataRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.expeditionCountLimit_ = 0;
                this.openExpeditionList_ = AvatarExpeditionAllDataRsp.emptyIntList();
                this.bitField0_ &= -2;
                this.retcode_ = 0;
                internalGetMutableExpeditionInfoMap().clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarExpeditionAllDataRspOuterClass.internal_static_AvatarExpeditionAllDataRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarExpeditionAllDataRsp getDefaultInstanceForType() {
                return AvatarExpeditionAllDataRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarExpeditionAllDataRsp build() {
                AvatarExpeditionAllDataRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarExpeditionAllDataRsp buildPartial() {
                AvatarExpeditionAllDataRsp result = new AvatarExpeditionAllDataRsp(this);
                int i = this.bitField0_;
                result.expeditionCountLimit_ = this.expeditionCountLimit_;
                if ((this.bitField0_ & 1) != 0) {
                    this.openExpeditionList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.openExpeditionList_ = this.openExpeditionList_;
                result.retcode_ = this.retcode_;
                result.expeditionInfoMap_ = internalGetExpeditionInfoMap();
                result.expeditionInfoMap_.makeImmutable();
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
                if (other instanceof AvatarExpeditionAllDataRsp) {
                    return mergeFrom((AvatarExpeditionAllDataRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarExpeditionAllDataRsp other) {
                if (other == AvatarExpeditionAllDataRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getExpeditionCountLimit() != 0) {
                    setExpeditionCountLimit(other.getExpeditionCountLimit());
                }
                if (!other.openExpeditionList_.isEmpty()) {
                    if (this.openExpeditionList_.isEmpty()) {
                        this.openExpeditionList_ = other.openExpeditionList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureOpenExpeditionListIsMutable();
                        this.openExpeditionList_.addAll(other.openExpeditionList_);
                    }
                    onChanged();
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                internalGetMutableExpeditionInfoMap().mergeFrom(other.internalGetExpeditionInfoMap());
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
                AvatarExpeditionAllDataRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarExpeditionAllDataRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarExpeditionAllDataRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRspOrBuilder
            public int getExpeditionCountLimit() {
                return this.expeditionCountLimit_;
            }

            public Builder setExpeditionCountLimit(int value) {
                this.expeditionCountLimit_ = value;
                onChanged();
                return this;
            }

            public Builder clearExpeditionCountLimit() {
                this.expeditionCountLimit_ = 0;
                onChanged();
                return this;
            }

            private void ensureOpenExpeditionListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.openExpeditionList_ = AvatarExpeditionAllDataRsp.mutableCopy(this.openExpeditionList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRspOrBuilder
            public List<Integer> getOpenExpeditionListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.openExpeditionList_) : this.openExpeditionList_;
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRspOrBuilder
            public int getOpenExpeditionListCount() {
                return this.openExpeditionList_.size();
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRspOrBuilder
            public int getOpenExpeditionList(int index) {
                return this.openExpeditionList_.getInt(index);
            }

            public Builder setOpenExpeditionList(int index, int value) {
                ensureOpenExpeditionListIsMutable();
                this.openExpeditionList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addOpenExpeditionList(int value) {
                ensureOpenExpeditionListIsMutable();
                this.openExpeditionList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllOpenExpeditionList(Iterable<? extends Integer> values) {
                ensureOpenExpeditionListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.openExpeditionList_);
                onChanged();
                return this;
            }

            public Builder clearOpenExpeditionList() {
                this.openExpeditionList_ = AvatarExpeditionAllDataRsp.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRspOrBuilder
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

            private MapField<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> internalGetExpeditionInfoMap() {
                if (this.expeditionInfoMap_ == null) {
                    return MapField.emptyMapField(ExpeditionInfoMapDefaultEntryHolder.defaultEntry);
                }
                return this.expeditionInfoMap_;
            }

            private MapField<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> internalGetMutableExpeditionInfoMap() {
                onChanged();
                if (this.expeditionInfoMap_ == null) {
                    this.expeditionInfoMap_ = MapField.newMapField(ExpeditionInfoMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.expeditionInfoMap_.isMutable()) {
                    this.expeditionInfoMap_ = this.expeditionInfoMap_.copy();
                }
                return this.expeditionInfoMap_;
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRspOrBuilder
            public int getExpeditionInfoMapCount() {
                return internalGetExpeditionInfoMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRspOrBuilder
            public boolean containsExpeditionInfoMap(long key) {
                return internalGetExpeditionInfoMap().getMap().containsKey(Long.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRspOrBuilder
            @Deprecated
            public Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMap() {
                return getExpeditionInfoMapMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRspOrBuilder
            public Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMapMap() {
                return internalGetExpeditionInfoMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRspOrBuilder
            public AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo getExpeditionInfoMapOrDefault(long key, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo defaultValue) {
                Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> map = internalGetExpeditionInfoMap().getMap();
                return map.containsKey(Long.valueOf(key)) ? map.get(Long.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionAllDataRspOuterClass.AvatarExpeditionAllDataRspOrBuilder
            public AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo getExpeditionInfoMapOrThrow(long key) {
                Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> map = internalGetExpeditionInfoMap().getMap();
                if (map.containsKey(Long.valueOf(key))) {
                    return map.get(Long.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearExpeditionInfoMap() {
                internalGetMutableExpeditionInfoMap().getMutableMap().clear();
                return this;
            }

            public Builder removeExpeditionInfoMap(long key) {
                internalGetMutableExpeditionInfoMap().getMutableMap().remove(Long.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getMutableExpeditionInfoMap() {
                return internalGetMutableExpeditionInfoMap().getMutableMap();
            }

            public Builder putExpeditionInfoMap(long key, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableExpeditionInfoMap().getMutableMap().put(Long.valueOf(key), value);
                return this;
            }

            public Builder putAllExpeditionInfoMap(Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> values) {
                internalGetMutableExpeditionInfoMap().getMutableMap().putAll(values);
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

        public static AvatarExpeditionAllDataRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarExpeditionAllDataRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarExpeditionAllDataRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarExpeditionAllDataRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AvatarExpeditionInfoOuterClass.getDescriptor();
    }
}
