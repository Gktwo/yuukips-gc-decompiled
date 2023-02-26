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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import emu.grasscutter.net.proto.TowerLevelRecordOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerFloorRecordOuterClass.class */
public final class TowerFloorRecordOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016TowerFloorRecord.proto\u001a\u0016TowerLevelRecord.proto\"ì\u0001\n\u0010TowerFloorRecord\u0012\u001f\n\u0017floorStarRewardProgress\u0018\u0004 \u0001(\r\u0012=\n\u000epassedLevelMap\u0018\u0006 \u0003(\u000b2%.TowerFloorRecord.PassedLevelMapEntry\u00120\n\u0015passedLevelRecordList\u0018\u0007 \u0003(\u000b2\u0011.TowerLevelRecord\u0012\u000f\n\u0007floorId\u0018\u000f \u0001(\r\u001a5\n\u0013PassedLevelMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{TowerLevelRecordOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TowerFloorRecord_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TowerFloorRecord_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TowerFloorRecord_descriptor, new String[]{"FloorStarRewardProgress", "PassedLevelMap", "PassedLevelRecordList", "FloorId"});
    private static final Descriptors.Descriptor internal_static_TowerFloorRecord_PassedLevelMapEntry_descriptor = internal_static_TowerFloorRecord_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_TowerFloorRecord_PassedLevelMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f862x2662389e = new GeneratedMessageV3.FieldAccessorTable(internal_static_TowerFloorRecord_PassedLevelMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerFloorRecordOuterClass$TowerFloorRecordOrBuilder.class */
    public interface TowerFloorRecordOrBuilder extends MessageOrBuilder {
        int getFloorStarRewardProgress();

        int getPassedLevelMapCount();

        boolean containsPassedLevelMap(int i);

        @Deprecated
        Map<Integer, Integer> getPassedLevelMap();

        Map<Integer, Integer> getPassedLevelMapMap();

        int getPassedLevelMapOrDefault(int i, int i2);

        int getPassedLevelMapOrThrow(int i);

        List<TowerLevelRecordOuterClass.TowerLevelRecord> getPassedLevelRecordListList();

        TowerLevelRecordOuterClass.TowerLevelRecord getPassedLevelRecordList(int i);

        int getPassedLevelRecordListCount();

        List<? extends TowerLevelRecordOuterClass.TowerLevelRecordOrBuilder> getPassedLevelRecordListOrBuilderList();

        TowerLevelRecordOuterClass.TowerLevelRecordOrBuilder getPassedLevelRecordListOrBuilder(int i);

        int getFloorId();
    }

    private TowerFloorRecordOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerFloorRecordOuterClass$TowerFloorRecord.class */
    public static final class TowerFloorRecord extends GeneratedMessageV3 implements TowerFloorRecordOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FLOORSTARREWARDPROGRESS_FIELD_NUMBER = 4;
        private int floorStarRewardProgress_;
        public static final int PASSEDLEVELMAP_FIELD_NUMBER = 6;
        private MapField<Integer, Integer> passedLevelMap_;
        public static final int PASSEDLEVELRECORDLIST_FIELD_NUMBER = 7;
        private List<TowerLevelRecordOuterClass.TowerLevelRecord> passedLevelRecordList_;
        public static final int FLOORID_FIELD_NUMBER = 15;
        private int floorId_;
        private byte memoizedIsInitialized;
        private static final TowerFloorRecord DEFAULT_INSTANCE = new TowerFloorRecord();
        private static final Parser<TowerFloorRecord> PARSER = new AbstractParser<TowerFloorRecord>() { // from class: emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecord.1
            @Override // com.google.protobuf.Parser
            public TowerFloorRecord parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TowerFloorRecord(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecord.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 6: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetPassedLevelMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecord.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private TowerFloorRecord(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TowerFloorRecord() {
            this.memoizedIsInitialized = -1;
            this.passedLevelRecordList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TowerFloorRecord();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x00f5 */
        private TowerFloorRecord(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.floorStarRewardProgress_ = input.readUInt32();
                                    break;
                                case 50:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.passedLevelMap_ = MapField.newMapField(PassedLevelMapDefaultEntryHolder.defaultEntry);
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    MapEntry<Integer, Integer> passedLevelMap__ = (MapEntry) input.readMessage(PassedLevelMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                    this.passedLevelMap_.getMutableMap().put(passedLevelMap__.getKey(), passedLevelMap__.getValue());
                                    break;
                                case 58:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.passedLevelRecordList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.passedLevelRecordList_.add((TowerLevelRecordOuterClass.TowerLevelRecord) input.readMessage(TowerLevelRecordOuterClass.TowerLevelRecord.parser(), extensionRegistry));
                                    break;
                                case 120:
                                    this.floorId_ = input.readUInt32();
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                            done = done;
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 2) != 0) {
                    this.passedLevelRecordList_ = Collections.unmodifiableList(this.passedLevelRecordList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TowerFloorRecordOuterClass.internal_static_TowerFloorRecord_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TowerFloorRecordOuterClass.internal_static_TowerFloorRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(TowerFloorRecord.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
        public int getFloorStarRewardProgress() {
            return this.floorStarRewardProgress_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerFloorRecordOuterClass$TowerFloorRecord$PassedLevelMapDefaultEntryHolder.class */
        public static final class PassedLevelMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(TowerFloorRecordOuterClass.internal_static_TowerFloorRecord_PassedLevelMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private PassedLevelMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetPassedLevelMap() {
            if (this.passedLevelMap_ == null) {
                return MapField.emptyMapField(PassedLevelMapDefaultEntryHolder.defaultEntry);
            }
            return this.passedLevelMap_;
        }

        @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
        public int getPassedLevelMapCount() {
            return internalGetPassedLevelMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
        public boolean containsPassedLevelMap(int key) {
            return internalGetPassedLevelMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
        @Deprecated
        public Map<Integer, Integer> getPassedLevelMap() {
            return getPassedLevelMapMap();
        }

        @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
        public Map<Integer, Integer> getPassedLevelMapMap() {
            return internalGetPassedLevelMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
        public int getPassedLevelMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetPassedLevelMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
        public int getPassedLevelMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetPassedLevelMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
        public List<TowerLevelRecordOuterClass.TowerLevelRecord> getPassedLevelRecordListList() {
            return this.passedLevelRecordList_;
        }

        @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
        public List<? extends TowerLevelRecordOuterClass.TowerLevelRecordOrBuilder> getPassedLevelRecordListOrBuilderList() {
            return this.passedLevelRecordList_;
        }

        @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
        public int getPassedLevelRecordListCount() {
            return this.passedLevelRecordList_.size();
        }

        @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
        public TowerLevelRecordOuterClass.TowerLevelRecord getPassedLevelRecordList(int index) {
            return this.passedLevelRecordList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
        public TowerLevelRecordOuterClass.TowerLevelRecordOrBuilder getPassedLevelRecordListOrBuilder(int index) {
            return this.passedLevelRecordList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
        public int getFloorId() {
            return this.floorId_;
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
            if (this.floorStarRewardProgress_ != 0) {
                output.writeUInt32(4, this.floorStarRewardProgress_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetPassedLevelMap(), PassedLevelMapDefaultEntryHolder.defaultEntry, 6);
            for (int i = 0; i < this.passedLevelRecordList_.size(); i++) {
                output.writeMessage(7, this.passedLevelRecordList_.get(i));
            }
            if (this.floorId_ != 0) {
                output.writeUInt32(15, this.floorId_);
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
            if (this.floorStarRewardProgress_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.floorStarRewardProgress_);
            }
            for (Map.Entry<Integer, Integer> entry : internalGetPassedLevelMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(6, PassedLevelMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            for (int i = 0; i < this.passedLevelRecordList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.passedLevelRecordList_.get(i));
            }
            if (this.floorId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.floorId_);
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
            if (!(obj instanceof TowerFloorRecord)) {
                return equals(obj);
            }
            TowerFloorRecord other = (TowerFloorRecord) obj;
            return getFloorStarRewardProgress() == other.getFloorStarRewardProgress() && internalGetPassedLevelMap().equals(other.internalGetPassedLevelMap()) && getPassedLevelRecordListList().equals(other.getPassedLevelRecordListList()) && getFloorId() == other.getFloorId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getFloorStarRewardProgress();
            if (!internalGetPassedLevelMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 6)) + internalGetPassedLevelMap().hashCode();
            }
            if (getPassedLevelRecordListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getPassedLevelRecordListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 15)) + getFloorId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TowerFloorRecord parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerFloorRecord parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerFloorRecord parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerFloorRecord parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerFloorRecord parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerFloorRecord parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerFloorRecord parseFrom(InputStream input) throws IOException {
            return (TowerFloorRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerFloorRecord parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerFloorRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerFloorRecord parseDelimitedFrom(InputStream input) throws IOException {
            return (TowerFloorRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TowerFloorRecord parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerFloorRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerFloorRecord parseFrom(CodedInputStream input) throws IOException {
            return (TowerFloorRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerFloorRecord parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerFloorRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TowerFloorRecord prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerFloorRecordOuterClass$TowerFloorRecord$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TowerFloorRecordOrBuilder {
            private int bitField0_;
            private int floorStarRewardProgress_;
            private MapField<Integer, Integer> passedLevelMap_;
            private List<TowerLevelRecordOuterClass.TowerLevelRecord> passedLevelRecordList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<TowerLevelRecordOuterClass.TowerLevelRecord, TowerLevelRecordOuterClass.TowerLevelRecord.Builder, TowerLevelRecordOuterClass.TowerLevelRecordOrBuilder> passedLevelRecordListBuilder_;
            private int floorId_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecord.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 6: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetPassedLevelMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecord.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecord.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 6: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutablePassedLevelMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecord.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return TowerFloorRecordOuterClass.internal_static_TowerFloorRecord_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TowerFloorRecordOuterClass.internal_static_TowerFloorRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(TowerFloorRecord.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TowerFloorRecord.alwaysUseFieldBuilders) {
                    getPassedLevelRecordListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.floorStarRewardProgress_ = 0;
                internalGetMutablePassedLevelMap().clear();
                if (this.passedLevelRecordListBuilder_ == null) {
                    this.passedLevelRecordList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.passedLevelRecordListBuilder_.clear();
                }
                this.floorId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TowerFloorRecordOuterClass.internal_static_TowerFloorRecord_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TowerFloorRecord getDefaultInstanceForType() {
                return TowerFloorRecord.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerFloorRecord build() {
                TowerFloorRecord result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerFloorRecord buildPartial() {
                TowerFloorRecord result = new TowerFloorRecord(this);
                int i = this.bitField0_;
                result.floorStarRewardProgress_ = this.floorStarRewardProgress_;
                result.passedLevelMap_ = internalGetPassedLevelMap();
                result.passedLevelMap_.makeImmutable();
                if (this.passedLevelRecordListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.passedLevelRecordList_ = Collections.unmodifiableList(this.passedLevelRecordList_);
                        this.bitField0_ &= -3;
                    }
                    result.passedLevelRecordList_ = this.passedLevelRecordList_;
                } else {
                    result.passedLevelRecordList_ = this.passedLevelRecordListBuilder_.build();
                }
                result.floorId_ = this.floorId_;
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
                if (other instanceof TowerFloorRecord) {
                    return mergeFrom((TowerFloorRecord) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TowerFloorRecord other) {
                if (other == TowerFloorRecord.getDefaultInstance()) {
                    return this;
                }
                if (other.getFloorStarRewardProgress() != 0) {
                    setFloorStarRewardProgress(other.getFloorStarRewardProgress());
                }
                internalGetMutablePassedLevelMap().mergeFrom(other.internalGetPassedLevelMap());
                if (this.passedLevelRecordListBuilder_ == null) {
                    if (!other.passedLevelRecordList_.isEmpty()) {
                        if (this.passedLevelRecordList_.isEmpty()) {
                            this.passedLevelRecordList_ = other.passedLevelRecordList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensurePassedLevelRecordListIsMutable();
                            this.passedLevelRecordList_.addAll(other.passedLevelRecordList_);
                        }
                        onChanged();
                    }
                } else if (!other.passedLevelRecordList_.isEmpty()) {
                    if (this.passedLevelRecordListBuilder_.isEmpty()) {
                        this.passedLevelRecordListBuilder_.dispose();
                        this.passedLevelRecordListBuilder_ = null;
                        this.passedLevelRecordList_ = other.passedLevelRecordList_;
                        this.bitField0_ &= -3;
                        this.passedLevelRecordListBuilder_ = TowerFloorRecord.alwaysUseFieldBuilders ? getPassedLevelRecordListFieldBuilder() : null;
                    } else {
                        this.passedLevelRecordListBuilder_.addAllMessages(other.passedLevelRecordList_);
                    }
                }
                if (other.getFloorId() != 0) {
                    setFloorId(other.getFloorId());
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
                TowerFloorRecord parsedMessage = null;
                try {
                    try {
                        parsedMessage = TowerFloorRecord.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TowerFloorRecord) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
            public int getFloorStarRewardProgress() {
                return this.floorStarRewardProgress_;
            }

            public Builder setFloorStarRewardProgress(int value) {
                this.floorStarRewardProgress_ = value;
                onChanged();
                return this;
            }

            public Builder clearFloorStarRewardProgress() {
                this.floorStarRewardProgress_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetPassedLevelMap() {
                if (this.passedLevelMap_ == null) {
                    return MapField.emptyMapField(PassedLevelMapDefaultEntryHolder.defaultEntry);
                }
                return this.passedLevelMap_;
            }

            private MapField<Integer, Integer> internalGetMutablePassedLevelMap() {
                onChanged();
                if (this.passedLevelMap_ == null) {
                    this.passedLevelMap_ = MapField.newMapField(PassedLevelMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.passedLevelMap_.isMutable()) {
                    this.passedLevelMap_ = this.passedLevelMap_.copy();
                }
                return this.passedLevelMap_;
            }

            @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
            public int getPassedLevelMapCount() {
                return internalGetPassedLevelMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
            public boolean containsPassedLevelMap(int key) {
                return internalGetPassedLevelMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
            @Deprecated
            public Map<Integer, Integer> getPassedLevelMap() {
                return getPassedLevelMapMap();
            }

            @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
            public Map<Integer, Integer> getPassedLevelMapMap() {
                return internalGetPassedLevelMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
            public int getPassedLevelMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetPassedLevelMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
            public int getPassedLevelMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetPassedLevelMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearPassedLevelMap() {
                internalGetMutablePassedLevelMap().getMutableMap().clear();
                return this;
            }

            public Builder removePassedLevelMap(int key) {
                internalGetMutablePassedLevelMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutablePassedLevelMap() {
                return internalGetMutablePassedLevelMap().getMutableMap();
            }

            public Builder putPassedLevelMap(int key, int value) {
                internalGetMutablePassedLevelMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllPassedLevelMap(Map<Integer, Integer> values) {
                internalGetMutablePassedLevelMap().getMutableMap().putAll(values);
                return this;
            }

            private void ensurePassedLevelRecordListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.passedLevelRecordList_ = new ArrayList(this.passedLevelRecordList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
            public List<TowerLevelRecordOuterClass.TowerLevelRecord> getPassedLevelRecordListList() {
                if (this.passedLevelRecordListBuilder_ == null) {
                    return Collections.unmodifiableList(this.passedLevelRecordList_);
                }
                return this.passedLevelRecordListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
            public int getPassedLevelRecordListCount() {
                if (this.passedLevelRecordListBuilder_ == null) {
                    return this.passedLevelRecordList_.size();
                }
                return this.passedLevelRecordListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
            public TowerLevelRecordOuterClass.TowerLevelRecord getPassedLevelRecordList(int index) {
                if (this.passedLevelRecordListBuilder_ == null) {
                    return this.passedLevelRecordList_.get(index);
                }
                return this.passedLevelRecordListBuilder_.getMessage(index);
            }

            public Builder setPassedLevelRecordList(int index, TowerLevelRecordOuterClass.TowerLevelRecord value) {
                if (this.passedLevelRecordListBuilder_ != null) {
                    this.passedLevelRecordListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePassedLevelRecordListIsMutable();
                    this.passedLevelRecordList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setPassedLevelRecordList(int index, TowerLevelRecordOuterClass.TowerLevelRecord.Builder builderForValue) {
                if (this.passedLevelRecordListBuilder_ == null) {
                    ensurePassedLevelRecordListIsMutable();
                    this.passedLevelRecordList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.passedLevelRecordListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addPassedLevelRecordList(TowerLevelRecordOuterClass.TowerLevelRecord value) {
                if (this.passedLevelRecordListBuilder_ != null) {
                    this.passedLevelRecordListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePassedLevelRecordListIsMutable();
                    this.passedLevelRecordList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addPassedLevelRecordList(int index, TowerLevelRecordOuterClass.TowerLevelRecord value) {
                if (this.passedLevelRecordListBuilder_ != null) {
                    this.passedLevelRecordListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePassedLevelRecordListIsMutable();
                    this.passedLevelRecordList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addPassedLevelRecordList(TowerLevelRecordOuterClass.TowerLevelRecord.Builder builderForValue) {
                if (this.passedLevelRecordListBuilder_ == null) {
                    ensurePassedLevelRecordListIsMutable();
                    this.passedLevelRecordList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.passedLevelRecordListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addPassedLevelRecordList(int index, TowerLevelRecordOuterClass.TowerLevelRecord.Builder builderForValue) {
                if (this.passedLevelRecordListBuilder_ == null) {
                    ensurePassedLevelRecordListIsMutable();
                    this.passedLevelRecordList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.passedLevelRecordListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllPassedLevelRecordList(Iterable<? extends TowerLevelRecordOuterClass.TowerLevelRecord> values) {
                if (this.passedLevelRecordListBuilder_ == null) {
                    ensurePassedLevelRecordListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.passedLevelRecordList_);
                    onChanged();
                } else {
                    this.passedLevelRecordListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearPassedLevelRecordList() {
                if (this.passedLevelRecordListBuilder_ == null) {
                    this.passedLevelRecordList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.passedLevelRecordListBuilder_.clear();
                }
                return this;
            }

            public Builder removePassedLevelRecordList(int index) {
                if (this.passedLevelRecordListBuilder_ == null) {
                    ensurePassedLevelRecordListIsMutable();
                    this.passedLevelRecordList_.remove(index);
                    onChanged();
                } else {
                    this.passedLevelRecordListBuilder_.remove(index);
                }
                return this;
            }

            public TowerLevelRecordOuterClass.TowerLevelRecord.Builder getPassedLevelRecordListBuilder(int index) {
                return getPassedLevelRecordListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
            public TowerLevelRecordOuterClass.TowerLevelRecordOrBuilder getPassedLevelRecordListOrBuilder(int index) {
                if (this.passedLevelRecordListBuilder_ == null) {
                    return this.passedLevelRecordList_.get(index);
                }
                return this.passedLevelRecordListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
            public List<? extends TowerLevelRecordOuterClass.TowerLevelRecordOrBuilder> getPassedLevelRecordListOrBuilderList() {
                if (this.passedLevelRecordListBuilder_ != null) {
                    return this.passedLevelRecordListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.passedLevelRecordList_);
            }

            public TowerLevelRecordOuterClass.TowerLevelRecord.Builder addPassedLevelRecordListBuilder() {
                return getPassedLevelRecordListFieldBuilder().addBuilder(TowerLevelRecordOuterClass.TowerLevelRecord.getDefaultInstance());
            }

            public TowerLevelRecordOuterClass.TowerLevelRecord.Builder addPassedLevelRecordListBuilder(int index) {
                return getPassedLevelRecordListFieldBuilder().addBuilder(index, TowerLevelRecordOuterClass.TowerLevelRecord.getDefaultInstance());
            }

            public List<TowerLevelRecordOuterClass.TowerLevelRecord.Builder> getPassedLevelRecordListBuilderList() {
                return getPassedLevelRecordListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<TowerLevelRecordOuterClass.TowerLevelRecord, TowerLevelRecordOuterClass.TowerLevelRecord.Builder, TowerLevelRecordOuterClass.TowerLevelRecordOrBuilder> getPassedLevelRecordListFieldBuilder() {
                if (this.passedLevelRecordListBuilder_ == null) {
                    this.passedLevelRecordListBuilder_ = new RepeatedFieldBuilderV3<>(this.passedLevelRecordList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.passedLevelRecordList_ = null;
                }
                return this.passedLevelRecordListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder
            public int getFloorId() {
                return this.floorId_;
            }

            public Builder setFloorId(int value) {
                this.floorId_ = value;
                onChanged();
                return this;
            }

            public Builder clearFloorId() {
                this.floorId_ = 0;
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

        public static TowerFloorRecord getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TowerFloorRecord> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TowerFloorRecord> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TowerFloorRecord getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        TowerLevelRecordOuterClass.getDescriptor();
    }
}
