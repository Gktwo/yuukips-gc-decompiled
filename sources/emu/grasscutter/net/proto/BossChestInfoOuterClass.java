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
import emu.grasscutter.net.proto.WeeklyBossResinDiscountInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BossChestInfoOuterClass.class */
public final class BossChestInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013BossChestInfo.proto\u001a!WeeklyBossResinDiscountInfo.proto\"÷\u0001\n\rBossChestInfo\u0012\u0017\n\u000fmonsterConfigId\u0018\u0001 \u0001(\r\u0012\r\n\u0005resin\u0018\u0002 \u0001(\r\u0012\u0015\n\rremainUidList\u0018\u0003 \u0003(\r\u0012\u0016\n\u000equalifyUidList\u0018\u0004 \u0003(\r\u0012:\n\u000euidDiscountMap\u0018\u0005 \u0003(\u000b2\".BossChestInfo.UidDiscountMapEntry\u001aS\n\u0013UidDiscountMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012+\n\u0005value\u0018\u0002 \u0001(\u000b2\u001c.WeeklyBossResinDiscountInfo:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{WeeklyBossResinDiscountInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BossChestInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BossChestInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BossChestInfo_descriptor, new String[]{"MonsterConfigId", "Resin", "RemainUidList", "QualifyUidList", "UidDiscountMap"});
    private static final Descriptors.Descriptor internal_static_BossChestInfo_UidDiscountMapEntry_descriptor = internal_static_BossChestInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_BossChestInfo_UidDiscountMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f659xc6636051 = new GeneratedMessageV3.FieldAccessorTable(internal_static_BossChestInfo_UidDiscountMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BossChestInfoOuterClass$BossChestInfoOrBuilder.class */
    public interface BossChestInfoOrBuilder extends MessageOrBuilder {
        int getMonsterConfigId();

        int getResin();

        List<Integer> getRemainUidListList();

        int getRemainUidListCount();

        int getRemainUidList(int i);

        List<Integer> getQualifyUidListList();

        int getQualifyUidListCount();

        int getQualifyUidList(int i);

        int getUidDiscountMapCount();

        boolean containsUidDiscountMap(int i);

        @Deprecated
        Map<Integer, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo> getUidDiscountMap();

        Map<Integer, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo> getUidDiscountMapMap();

        WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo getUidDiscountMapOrDefault(int i, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo weeklyBossResinDiscountInfo);

        WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo getUidDiscountMapOrThrow(int i);
    }

    private BossChestInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BossChestInfoOuterClass$BossChestInfo.class */
    public static final class BossChestInfo extends GeneratedMessageV3 implements BossChestInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MONSTERCONFIGID_FIELD_NUMBER = 1;
        private int monsterConfigId_;
        public static final int RESIN_FIELD_NUMBER = 2;
        private int resin_;
        public static final int REMAINUIDLIST_FIELD_NUMBER = 3;
        private Internal.IntList remainUidList_;
        private int remainUidListMemoizedSerializedSize;
        public static final int QUALIFYUIDLIST_FIELD_NUMBER = 4;
        private Internal.IntList qualifyUidList_;
        private int qualifyUidListMemoizedSerializedSize;
        public static final int UIDDISCOUNTMAP_FIELD_NUMBER = 5;
        private MapField<Integer, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo> uidDiscountMap_;
        private byte memoizedIsInitialized;
        private static final BossChestInfo DEFAULT_INSTANCE = new BossChestInfo();
        private static final Parser<BossChestInfo> PARSER = new AbstractParser<BossChestInfo>() { // from class: emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfo.1
            @Override // com.google.protobuf.Parser
            public BossChestInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BossChestInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 5: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetUidDiscountMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private BossChestInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.remainUidListMemoizedSerializedSize = -1;
            this.qualifyUidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private BossChestInfo() {
            this.remainUidListMemoizedSerializedSize = -1;
            this.qualifyUidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.remainUidList_ = emptyIntList();
            this.qualifyUidList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BossChestInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:87:0x01ae */
        private BossChestInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 8:
                                this.monsterConfigId_ = input.readUInt32();
                                break;
                            case 16:
                                this.resin_ = input.readUInt32();
                                break;
                            case 24:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.remainUidList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.remainUidList_.addInt(input.readUInt32());
                                break;
                            case 26:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.remainUidList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.remainUidList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 32:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.qualifyUidList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.qualifyUidList_.addInt(input.readUInt32());
                                break;
                            case 34:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.qualifyUidList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.qualifyUidList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 42:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.uidDiscountMap_ = MapField.newMapField(UidDiscountMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo> uidDiscountMap__ = (MapEntry) input.readMessage(UidDiscountMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.uidDiscountMap_.getMutableMap().put(uidDiscountMap__.getKey(), uidDiscountMap__.getValue());
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
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.remainUidList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.qualifyUidList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BossChestInfoOuterClass.internal_static_BossChestInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BossChestInfoOuterClass.internal_static_BossChestInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BossChestInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
        public int getMonsterConfigId() {
            return this.monsterConfigId_;
        }

        @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
        public int getResin() {
            return this.resin_;
        }

        @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
        public List<Integer> getRemainUidListList() {
            return this.remainUidList_;
        }

        @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
        public int getRemainUidListCount() {
            return this.remainUidList_.size();
        }

        @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
        public int getRemainUidList(int index) {
            return this.remainUidList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
        public List<Integer> getQualifyUidListList() {
            return this.qualifyUidList_;
        }

        @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
        public int getQualifyUidListCount() {
            return this.qualifyUidList_.size();
        }

        @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
        public int getQualifyUidList(int index) {
            return this.qualifyUidList_.getInt(index);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BossChestInfoOuterClass$BossChestInfo$UidDiscountMapDefaultEntryHolder.class */
        public static final class UidDiscountMapDefaultEntryHolder {
            static final MapEntry<Integer, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo> defaultEntry = MapEntry.newDefaultInstance(BossChestInfoOuterClass.internal_static_BossChestInfo_UidDiscountMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo.getDefaultInstance());

            private UidDiscountMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo> internalGetUidDiscountMap() {
            if (this.uidDiscountMap_ == null) {
                return MapField.emptyMapField(UidDiscountMapDefaultEntryHolder.defaultEntry);
            }
            return this.uidDiscountMap_;
        }

        @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
        public int getUidDiscountMapCount() {
            return internalGetUidDiscountMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
        public boolean containsUidDiscountMap(int key) {
            return internalGetUidDiscountMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
        @Deprecated
        public Map<Integer, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo> getUidDiscountMap() {
            return getUidDiscountMapMap();
        }

        @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
        public Map<Integer, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo> getUidDiscountMapMap() {
            return internalGetUidDiscountMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
        public WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo getUidDiscountMapOrDefault(int key, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo defaultValue) {
            Map<Integer, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo> map = internalGetUidDiscountMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
        public WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo getUidDiscountMapOrThrow(int key) {
            Map<Integer, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo> map = internalGetUidDiscountMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
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
            if (this.monsterConfigId_ != 0) {
                output.writeUInt32(1, this.monsterConfigId_);
            }
            if (this.resin_ != 0) {
                output.writeUInt32(2, this.resin_);
            }
            if (getRemainUidListList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.remainUidListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.remainUidList_.size(); i++) {
                output.writeUInt32NoTag(this.remainUidList_.getInt(i));
            }
            if (getQualifyUidListList().size() > 0) {
                output.writeUInt32NoTag(34);
                output.writeUInt32NoTag(this.qualifyUidListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.qualifyUidList_.size(); i2++) {
                output.writeUInt32NoTag(this.qualifyUidList_.getInt(i2));
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetUidDiscountMap(), UidDiscountMapDefaultEntryHolder.defaultEntry, 5);
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.monsterConfigId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.monsterConfigId_);
            }
            if (this.resin_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.resin_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.remainUidList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.remainUidList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getRemainUidListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.remainUidListMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.qualifyUidList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.qualifyUidList_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getQualifyUidListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.qualifyUidListMemoizedSerializedSize = dataSize2;
            for (Map.Entry<Integer, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo> entry : internalGetUidDiscountMap().getMap().entrySet()) {
                size4 += CodedOutputStream.computeMessageSize(5, UidDiscountMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BossChestInfo)) {
                return equals(obj);
            }
            BossChestInfo other = (BossChestInfo) obj;
            return getMonsterConfigId() == other.getMonsterConfigId() && getResin() == other.getResin() && getRemainUidListList().equals(other.getRemainUidListList()) && getQualifyUidListList().equals(other.getQualifyUidListList()) && internalGetUidDiscountMap().equals(other.internalGetUidDiscountMap()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getMonsterConfigId())) + 2)) + getResin();
            if (getRemainUidListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getRemainUidListList().hashCode();
            }
            if (getQualifyUidListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getQualifyUidListList().hashCode();
            }
            if (!internalGetUidDiscountMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 5)) + internalGetUidDiscountMap().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static BossChestInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BossChestInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BossChestInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BossChestInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BossChestInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BossChestInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BossChestInfo parseFrom(InputStream input) throws IOException {
            return (BossChestInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BossChestInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BossChestInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BossChestInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BossChestInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BossChestInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BossChestInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BossChestInfo parseFrom(CodedInputStream input) throws IOException {
            return (BossChestInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BossChestInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BossChestInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BossChestInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BossChestInfoOuterClass$BossChestInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BossChestInfoOrBuilder {
            private int bitField0_;
            private int monsterConfigId_;
            private int resin_;
            private Internal.IntList remainUidList_ = BossChestInfo.emptyIntList();
            private Internal.IntList qualifyUidList_ = BossChestInfo.emptyIntList();
            private MapField<Integer, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo> uidDiscountMap_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 5: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetUidDiscountMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 5: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableUidDiscountMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return BossChestInfoOuterClass.internal_static_BossChestInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BossChestInfoOuterClass.internal_static_BossChestInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BossChestInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BossChestInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.monsterConfigId_ = 0;
                this.resin_ = 0;
                this.remainUidList_ = BossChestInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.qualifyUidList_ = BossChestInfo.emptyIntList();
                this.bitField0_ &= -3;
                internalGetMutableUidDiscountMap().clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BossChestInfoOuterClass.internal_static_BossChestInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BossChestInfo getDefaultInstanceForType() {
                return BossChestInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BossChestInfo build() {
                BossChestInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BossChestInfo buildPartial() {
                BossChestInfo result = new BossChestInfo(this);
                int i = this.bitField0_;
                result.monsterConfigId_ = this.monsterConfigId_;
                result.resin_ = this.resin_;
                if ((this.bitField0_ & 1) != 0) {
                    this.remainUidList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.remainUidList_ = this.remainUidList_;
                if ((this.bitField0_ & 2) != 0) {
                    this.qualifyUidList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.qualifyUidList_ = this.qualifyUidList_;
                result.uidDiscountMap_ = internalGetUidDiscountMap();
                result.uidDiscountMap_.makeImmutable();
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
                if (other instanceof BossChestInfo) {
                    return mergeFrom((BossChestInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BossChestInfo other) {
                if (other == BossChestInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getMonsterConfigId() != 0) {
                    setMonsterConfigId(other.getMonsterConfigId());
                }
                if (other.getResin() != 0) {
                    setResin(other.getResin());
                }
                if (!other.remainUidList_.isEmpty()) {
                    if (this.remainUidList_.isEmpty()) {
                        this.remainUidList_ = other.remainUidList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRemainUidListIsMutable();
                        this.remainUidList_.addAll(other.remainUidList_);
                    }
                    onChanged();
                }
                if (!other.qualifyUidList_.isEmpty()) {
                    if (this.qualifyUidList_.isEmpty()) {
                        this.qualifyUidList_ = other.qualifyUidList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureQualifyUidListIsMutable();
                        this.qualifyUidList_.addAll(other.qualifyUidList_);
                    }
                    onChanged();
                }
                internalGetMutableUidDiscountMap().mergeFrom(other.internalGetUidDiscountMap());
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
                BossChestInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BossChestInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BossChestInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
            public int getMonsterConfigId() {
                return this.monsterConfigId_;
            }

            public Builder setMonsterConfigId(int value) {
                this.monsterConfigId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMonsterConfigId() {
                this.monsterConfigId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
            public int getResin() {
                return this.resin_;
            }

            public Builder setResin(int value) {
                this.resin_ = value;
                onChanged();
                return this;
            }

            public Builder clearResin() {
                this.resin_ = 0;
                onChanged();
                return this;
            }

            private void ensureRemainUidListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.remainUidList_ = BossChestInfo.mutableCopy(this.remainUidList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
            public List<Integer> getRemainUidListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.remainUidList_) : this.remainUidList_;
            }

            @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
            public int getRemainUidListCount() {
                return this.remainUidList_.size();
            }

            @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
            public int getRemainUidList(int index) {
                return this.remainUidList_.getInt(index);
            }

            public Builder setRemainUidList(int index, int value) {
                ensureRemainUidListIsMutable();
                this.remainUidList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addRemainUidList(int value) {
                ensureRemainUidListIsMutable();
                this.remainUidList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllRemainUidList(Iterable<? extends Integer> values) {
                ensureRemainUidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.remainUidList_);
                onChanged();
                return this;
            }

            public Builder clearRemainUidList() {
                this.remainUidList_ = BossChestInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureQualifyUidListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.qualifyUidList_ = BossChestInfo.mutableCopy(this.qualifyUidList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
            public List<Integer> getQualifyUidListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.qualifyUidList_) : this.qualifyUidList_;
            }

            @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
            public int getQualifyUidListCount() {
                return this.qualifyUidList_.size();
            }

            @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
            public int getQualifyUidList(int index) {
                return this.qualifyUidList_.getInt(index);
            }

            public Builder setQualifyUidList(int index, int value) {
                ensureQualifyUidListIsMutable();
                this.qualifyUidList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addQualifyUidList(int value) {
                ensureQualifyUidListIsMutable();
                this.qualifyUidList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllQualifyUidList(Iterable<? extends Integer> values) {
                ensureQualifyUidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.qualifyUidList_);
                onChanged();
                return this;
            }

            public Builder clearQualifyUidList() {
                this.qualifyUidList_ = BossChestInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            private MapField<Integer, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo> internalGetUidDiscountMap() {
                if (this.uidDiscountMap_ == null) {
                    return MapField.emptyMapField(UidDiscountMapDefaultEntryHolder.defaultEntry);
                }
                return this.uidDiscountMap_;
            }

            private MapField<Integer, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo> internalGetMutableUidDiscountMap() {
                onChanged();
                if (this.uidDiscountMap_ == null) {
                    this.uidDiscountMap_ = MapField.newMapField(UidDiscountMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.uidDiscountMap_.isMutable()) {
                    this.uidDiscountMap_ = this.uidDiscountMap_.copy();
                }
                return this.uidDiscountMap_;
            }

            @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
            public int getUidDiscountMapCount() {
                return internalGetUidDiscountMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
            public boolean containsUidDiscountMap(int key) {
                return internalGetUidDiscountMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
            @Deprecated
            public Map<Integer, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo> getUidDiscountMap() {
                return getUidDiscountMapMap();
            }

            @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
            public Map<Integer, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo> getUidDiscountMapMap() {
                return internalGetUidDiscountMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
            public WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo getUidDiscountMapOrDefault(int key, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo defaultValue) {
                Map<Integer, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo> map = internalGetUidDiscountMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.BossChestInfoOuterClass.BossChestInfoOrBuilder
            public WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo getUidDiscountMapOrThrow(int key) {
                Map<Integer, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo> map = internalGetUidDiscountMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearUidDiscountMap() {
                internalGetMutableUidDiscountMap().getMutableMap().clear();
                return this;
            }

            public Builder removeUidDiscountMap(int key) {
                internalGetMutableUidDiscountMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo> getMutableUidDiscountMap() {
                return internalGetMutableUidDiscountMap().getMutableMap();
            }

            public Builder putUidDiscountMap(int key, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableUidDiscountMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllUidDiscountMap(Map<Integer, WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo> values) {
                internalGetMutableUidDiscountMap().getMutableMap().putAll(values);
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

        public static BossChestInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BossChestInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BossChestInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BossChestInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        WeeklyBossResinDiscountInfoOuterClass.getDescriptor();
    }
}
