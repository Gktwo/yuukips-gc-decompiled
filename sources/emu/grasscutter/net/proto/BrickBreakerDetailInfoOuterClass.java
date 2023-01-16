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
import emu.grasscutter.net.proto.BrickBreakerActivityStageInfoOuterClass;
import emu.grasscutter.net.proto.BrickBreakerLevelInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BrickBreakerDetailInfoOuterClass.class */
public final class BrickBreakerDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cBrickBreakerDetailInfo.proto\u001a#BrickBreakerActivityStageInfo.proto\u001a\u001bBrickBreakerLevelInfo.proto\"¹\u0002\n\u0016BrickBreakerDetailInfo\u00127\n\u000fstage_info_list\u0018\r \u0003(\u000b2\u001e.BrickBreakerActivityStageInfo\u00127\n\u0017dungeon_level_info_list\u0018\t \u0003(\u000b2\u0016.BrickBreakerLevelInfo\u00125\n\u0015world_level_info_list\u0018\u000b \u0003(\u000b2\u0016.BrickBreakerLevelInfo\u0012A\n\u000eskill_info_map\u0018\u0001 \u0003(\u000b2).BrickBreakerDetailInfo.SkillInfoMapEntry\u001a3\n\u0011SkillInfoMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BrickBreakerActivityStageInfoOuterClass.getDescriptor(), BrickBreakerLevelInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BrickBreakerDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BrickBreakerDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BrickBreakerDetailInfo_descriptor, new String[]{"StageInfoList", "DungeonLevelInfoList", "WorldLevelInfoList", "SkillInfoMap"});

    /* renamed from: internal_static_BrickBreakerDetailInfo_SkillInfoMapEntry_descriptor */
    private static final Descriptors.Descriptor f668x737b7df = internal_static_BrickBreakerDetailInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_BrickBreakerDetailInfo_SkillInfoMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f669x169c8f5d = new GeneratedMessageV3.FieldAccessorTable(f668x737b7df, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BrickBreakerDetailInfoOuterClass$BrickBreakerDetailInfoOrBuilder.class */
    public interface BrickBreakerDetailInfoOrBuilder extends MessageOrBuilder {
        List<BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo> getStageInfoListList();

        BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo getStageInfoList(int i);

        int getStageInfoListCount();

        List<? extends BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfoOrBuilder> getStageInfoListOrBuilderList();

        BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfoOrBuilder getStageInfoListOrBuilder(int i);

        List<BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo> getDungeonLevelInfoListList();

        BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo getDungeonLevelInfoList(int i);

        int getDungeonLevelInfoListCount();

        List<? extends BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder> getDungeonLevelInfoListOrBuilderList();

        BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder getDungeonLevelInfoListOrBuilder(int i);

        List<BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo> getWorldLevelInfoListList();

        BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo getWorldLevelInfoList(int i);

        int getWorldLevelInfoListCount();

        List<? extends BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder> getWorldLevelInfoListOrBuilderList();

        BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder getWorldLevelInfoListOrBuilder(int i);

        int getSkillInfoMapCount();

        boolean containsSkillInfoMap(int i);

        @Deprecated
        Map<Integer, Integer> getSkillInfoMap();

        Map<Integer, Integer> getSkillInfoMapMap();

        int getSkillInfoMapOrDefault(int i, int i2);

        int getSkillInfoMapOrThrow(int i);
    }

    private BrickBreakerDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BrickBreakerDetailInfoOuterClass$BrickBreakerDetailInfo.class */
    public static final class BrickBreakerDetailInfo extends GeneratedMessageV3 implements BrickBreakerDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STAGE_INFO_LIST_FIELD_NUMBER = 13;
        private List<BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo> stageInfoList_;
        public static final int DUNGEON_LEVEL_INFO_LIST_FIELD_NUMBER = 9;
        private List<BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo> dungeonLevelInfoList_;
        public static final int WORLD_LEVEL_INFO_LIST_FIELD_NUMBER = 11;
        private List<BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo> worldLevelInfoList_;
        public static final int SKILL_INFO_MAP_FIELD_NUMBER = 1;
        private MapField<Integer, Integer> skillInfoMap_;
        private byte memoizedIsInitialized;
        private static final BrickBreakerDetailInfo DEFAULT_INSTANCE = new BrickBreakerDetailInfo();
        private static final Parser<BrickBreakerDetailInfo> PARSER = new AbstractParser<BrickBreakerDetailInfo>() { // from class: emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo.1
            @Override // com.google.protobuf.Parser
            public BrickBreakerDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BrickBreakerDetailInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 1: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetSkillInfoMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private BrickBreakerDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BrickBreakerDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.stageInfoList_ = Collections.emptyList();
            this.dungeonLevelInfoList_ = Collections.emptyList();
            this.worldLevelInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BrickBreakerDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:74:0x013b */
        private BrickBreakerDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 10:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.skillInfoMap_ = MapField.newMapField(SkillInfoMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Integer> skillInfoMap__ = (MapEntry) input.readMessage(SkillInfoMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.skillInfoMap_.getMutableMap().put(skillInfoMap__.getKey(), skillInfoMap__.getValue());
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.dungeonLevelInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.dungeonLevelInfoList_.add((BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo) input.readMessage(BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.parser(), extensionRegistry));
                                break;
                            case 90:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.worldLevelInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.worldLevelInfoList_.add((BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo) input.readMessage(BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.parser(), extensionRegistry));
                                break;
                            case 106:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.stageInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.stageInfoList_.add((BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo) input.readMessage(BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 2) != 0) {
                    this.dungeonLevelInfoList_ = Collections.unmodifiableList(this.dungeonLevelInfoList_);
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.worldLevelInfoList_ = Collections.unmodifiableList(this.worldLevelInfoList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.stageInfoList_ = Collections.unmodifiableList(this.stageInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BrickBreakerDetailInfoOuterClass.internal_static_BrickBreakerDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BrickBreakerDetailInfoOuterClass.internal_static_BrickBreakerDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BrickBreakerDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
        public List<BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo> getStageInfoListList() {
            return this.stageInfoList_;
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
        public List<? extends BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfoOrBuilder> getStageInfoListOrBuilderList() {
            return this.stageInfoList_;
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
        public int getStageInfoListCount() {
            return this.stageInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
        public BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo getStageInfoList(int index) {
            return this.stageInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
        public BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfoOrBuilder getStageInfoListOrBuilder(int index) {
            return this.stageInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
        public List<BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo> getDungeonLevelInfoListList() {
            return this.dungeonLevelInfoList_;
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
        public List<? extends BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder> getDungeonLevelInfoListOrBuilderList() {
            return this.dungeonLevelInfoList_;
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
        public int getDungeonLevelInfoListCount() {
            return this.dungeonLevelInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
        public BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo getDungeonLevelInfoList(int index) {
            return this.dungeonLevelInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
        public BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder getDungeonLevelInfoListOrBuilder(int index) {
            return this.dungeonLevelInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
        public List<BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo> getWorldLevelInfoListList() {
            return this.worldLevelInfoList_;
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
        public List<? extends BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder> getWorldLevelInfoListOrBuilderList() {
            return this.worldLevelInfoList_;
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
        public int getWorldLevelInfoListCount() {
            return this.worldLevelInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
        public BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo getWorldLevelInfoList(int index) {
            return this.worldLevelInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
        public BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder getWorldLevelInfoListOrBuilder(int index) {
            return this.worldLevelInfoList_.get(index);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BrickBreakerDetailInfoOuterClass$BrickBreakerDetailInfo$SkillInfoMapDefaultEntryHolder.class */
        public static final class SkillInfoMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(BrickBreakerDetailInfoOuterClass.f668x737b7df, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private SkillInfoMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetSkillInfoMap() {
            if (this.skillInfoMap_ == null) {
                return MapField.emptyMapField(SkillInfoMapDefaultEntryHolder.defaultEntry);
            }
            return this.skillInfoMap_;
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
        public int getSkillInfoMapCount() {
            return internalGetSkillInfoMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
        public boolean containsSkillInfoMap(int key) {
            return internalGetSkillInfoMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getSkillInfoMap() {
            return getSkillInfoMapMap();
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
        public Map<Integer, Integer> getSkillInfoMapMap() {
            return internalGetSkillInfoMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
        public int getSkillInfoMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetSkillInfoMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
        public int getSkillInfoMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetSkillInfoMap().getMap();
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
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetSkillInfoMap(), SkillInfoMapDefaultEntryHolder.defaultEntry, 1);
            for (int i = 0; i < this.dungeonLevelInfoList_.size(); i++) {
                output.writeMessage(9, this.dungeonLevelInfoList_.get(i));
            }
            for (int i2 = 0; i2 < this.worldLevelInfoList_.size(); i2++) {
                output.writeMessage(11, this.worldLevelInfoList_.get(i2));
            }
            for (int i3 = 0; i3 < this.stageInfoList_.size(); i3++) {
                output.writeMessage(13, this.stageInfoList_.get(i3));
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
            for (Map.Entry<Integer, Integer> entry : internalGetSkillInfoMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(1, SkillInfoMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            for (int i = 0; i < this.dungeonLevelInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(9, this.dungeonLevelInfoList_.get(i));
            }
            for (int i2 = 0; i2 < this.worldLevelInfoList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.worldLevelInfoList_.get(i2));
            }
            for (int i3 = 0; i3 < this.stageInfoList_.size(); i3++) {
                size2 += CodedOutputStream.computeMessageSize(13, this.stageInfoList_.get(i3));
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
            if (!(obj instanceof BrickBreakerDetailInfo)) {
                return equals(obj);
            }
            BrickBreakerDetailInfo other = (BrickBreakerDetailInfo) obj;
            return getStageInfoListList().equals(other.getStageInfoListList()) && getDungeonLevelInfoListList().equals(other.getDungeonLevelInfoListList()) && getWorldLevelInfoListList().equals(other.getWorldLevelInfoListList()) && internalGetSkillInfoMap().equals(other.internalGetSkillInfoMap()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getStageInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getStageInfoListList().hashCode();
            }
            if (getDungeonLevelInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getDungeonLevelInfoListList().hashCode();
            }
            if (getWorldLevelInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getWorldLevelInfoListList().hashCode();
            }
            if (!internalGetSkillInfoMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 1)) + internalGetSkillInfoMap().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static BrickBreakerDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BrickBreakerDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BrickBreakerDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BrickBreakerDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BrickBreakerDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BrickBreakerDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BrickBreakerDetailInfo parseFrom(InputStream input) throws IOException {
            return (BrickBreakerDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BrickBreakerDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BrickBreakerDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BrickBreakerDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BrickBreakerDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BrickBreakerDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BrickBreakerDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BrickBreakerDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (BrickBreakerDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BrickBreakerDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BrickBreakerDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BrickBreakerDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BrickBreakerDetailInfoOuterClass$BrickBreakerDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BrickBreakerDetailInfoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo, BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo.Builder, BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfoOrBuilder> stageInfoListBuilder_;
            private RepeatedFieldBuilderV3<BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo, BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.Builder, BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder> dungeonLevelInfoListBuilder_;
            private RepeatedFieldBuilderV3<BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo, BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.Builder, BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder> worldLevelInfoListBuilder_;
            private MapField<Integer, Integer> skillInfoMap_;
            private List<BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo> stageInfoList_ = Collections.emptyList();
            private List<BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo> dungeonLevelInfoList_ = Collections.emptyList();
            private List<BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo> worldLevelInfoList_ = Collections.emptyList();

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 1: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetSkillInfoMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 1: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableSkillInfoMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return BrickBreakerDetailInfoOuterClass.internal_static_BrickBreakerDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BrickBreakerDetailInfoOuterClass.internal_static_BrickBreakerDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BrickBreakerDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BrickBreakerDetailInfo.alwaysUseFieldBuilders) {
                    getStageInfoListFieldBuilder();
                    getDungeonLevelInfoListFieldBuilder();
                    getWorldLevelInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.stageInfoListBuilder_ == null) {
                    this.stageInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.stageInfoListBuilder_.clear();
                }
                if (this.dungeonLevelInfoListBuilder_ == null) {
                    this.dungeonLevelInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.dungeonLevelInfoListBuilder_.clear();
                }
                if (this.worldLevelInfoListBuilder_ == null) {
                    this.worldLevelInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.worldLevelInfoListBuilder_.clear();
                }
                internalGetMutableSkillInfoMap().clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BrickBreakerDetailInfoOuterClass.internal_static_BrickBreakerDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BrickBreakerDetailInfo getDefaultInstanceForType() {
                return BrickBreakerDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BrickBreakerDetailInfo build() {
                BrickBreakerDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BrickBreakerDetailInfo buildPartial() {
                BrickBreakerDetailInfo result = new BrickBreakerDetailInfo(this);
                int i = this.bitField0_;
                if (this.stageInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.stageInfoList_ = Collections.unmodifiableList(this.stageInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.stageInfoList_ = this.stageInfoList_;
                } else {
                    result.stageInfoList_ = this.stageInfoListBuilder_.build();
                }
                if (this.dungeonLevelInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.dungeonLevelInfoList_ = Collections.unmodifiableList(this.dungeonLevelInfoList_);
                        this.bitField0_ &= -3;
                    }
                    result.dungeonLevelInfoList_ = this.dungeonLevelInfoList_;
                } else {
                    result.dungeonLevelInfoList_ = this.dungeonLevelInfoListBuilder_.build();
                }
                if (this.worldLevelInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.worldLevelInfoList_ = Collections.unmodifiableList(this.worldLevelInfoList_);
                        this.bitField0_ &= -5;
                    }
                    result.worldLevelInfoList_ = this.worldLevelInfoList_;
                } else {
                    result.worldLevelInfoList_ = this.worldLevelInfoListBuilder_.build();
                }
                result.skillInfoMap_ = internalGetSkillInfoMap();
                result.skillInfoMap_.makeImmutable();
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
                if (other instanceof BrickBreakerDetailInfo) {
                    return mergeFrom((BrickBreakerDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BrickBreakerDetailInfo other) {
                if (other == BrickBreakerDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.stageInfoListBuilder_ == null) {
                    if (!other.stageInfoList_.isEmpty()) {
                        if (this.stageInfoList_.isEmpty()) {
                            this.stageInfoList_ = other.stageInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureStageInfoListIsMutable();
                            this.stageInfoList_.addAll(other.stageInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.stageInfoList_.isEmpty()) {
                    if (this.stageInfoListBuilder_.isEmpty()) {
                        this.stageInfoListBuilder_.dispose();
                        this.stageInfoListBuilder_ = null;
                        this.stageInfoList_ = other.stageInfoList_;
                        this.bitField0_ &= -2;
                        this.stageInfoListBuilder_ = BrickBreakerDetailInfo.alwaysUseFieldBuilders ? getStageInfoListFieldBuilder() : null;
                    } else {
                        this.stageInfoListBuilder_.addAllMessages(other.stageInfoList_);
                    }
                }
                if (this.dungeonLevelInfoListBuilder_ == null) {
                    if (!other.dungeonLevelInfoList_.isEmpty()) {
                        if (this.dungeonLevelInfoList_.isEmpty()) {
                            this.dungeonLevelInfoList_ = other.dungeonLevelInfoList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureDungeonLevelInfoListIsMutable();
                            this.dungeonLevelInfoList_.addAll(other.dungeonLevelInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.dungeonLevelInfoList_.isEmpty()) {
                    if (this.dungeonLevelInfoListBuilder_.isEmpty()) {
                        this.dungeonLevelInfoListBuilder_.dispose();
                        this.dungeonLevelInfoListBuilder_ = null;
                        this.dungeonLevelInfoList_ = other.dungeonLevelInfoList_;
                        this.bitField0_ &= -3;
                        this.dungeonLevelInfoListBuilder_ = BrickBreakerDetailInfo.alwaysUseFieldBuilders ? getDungeonLevelInfoListFieldBuilder() : null;
                    } else {
                        this.dungeonLevelInfoListBuilder_.addAllMessages(other.dungeonLevelInfoList_);
                    }
                }
                if (this.worldLevelInfoListBuilder_ == null) {
                    if (!other.worldLevelInfoList_.isEmpty()) {
                        if (this.worldLevelInfoList_.isEmpty()) {
                            this.worldLevelInfoList_ = other.worldLevelInfoList_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureWorldLevelInfoListIsMutable();
                            this.worldLevelInfoList_.addAll(other.worldLevelInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.worldLevelInfoList_.isEmpty()) {
                    if (this.worldLevelInfoListBuilder_.isEmpty()) {
                        this.worldLevelInfoListBuilder_.dispose();
                        this.worldLevelInfoListBuilder_ = null;
                        this.worldLevelInfoList_ = other.worldLevelInfoList_;
                        this.bitField0_ &= -5;
                        this.worldLevelInfoListBuilder_ = BrickBreakerDetailInfo.alwaysUseFieldBuilders ? getWorldLevelInfoListFieldBuilder() : null;
                    } else {
                        this.worldLevelInfoListBuilder_.addAllMessages(other.worldLevelInfoList_);
                    }
                }
                internalGetMutableSkillInfoMap().mergeFrom(other.internalGetSkillInfoMap());
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
                BrickBreakerDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BrickBreakerDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BrickBreakerDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureStageInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.stageInfoList_ = new ArrayList(this.stageInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
            public List<BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo> getStageInfoListList() {
                if (this.stageInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.stageInfoList_);
                }
                return this.stageInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
            public int getStageInfoListCount() {
                if (this.stageInfoListBuilder_ == null) {
                    return this.stageInfoList_.size();
                }
                return this.stageInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
            public BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo getStageInfoList(int index) {
                if (this.stageInfoListBuilder_ == null) {
                    return this.stageInfoList_.get(index);
                }
                return this.stageInfoListBuilder_.getMessage(index);
            }

            public Builder setStageInfoList(int index, BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo value) {
                if (this.stageInfoListBuilder_ != null) {
                    this.stageInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setStageInfoList(int index, BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo.Builder builderForValue) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addStageInfoList(BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo value) {
                if (this.stageInfoListBuilder_ != null) {
                    this.stageInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addStageInfoList(int index, BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo value) {
                if (this.stageInfoListBuilder_ != null) {
                    this.stageInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addStageInfoList(BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo.Builder builderForValue) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addStageInfoList(int index, BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo.Builder builderForValue) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllStageInfoList(Iterable<? extends BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo> values) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.stageInfoList_);
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearStageInfoList() {
                if (this.stageInfoListBuilder_ == null) {
                    this.stageInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeStageInfoList(int index) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.remove(index);
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.remove(index);
                }
                return this;
            }

            public BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo.Builder getStageInfoListBuilder(int index) {
                return getStageInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
            public BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfoOrBuilder getStageInfoListOrBuilder(int index) {
                if (this.stageInfoListBuilder_ == null) {
                    return this.stageInfoList_.get(index);
                }
                return this.stageInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
            public List<? extends BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfoOrBuilder> getStageInfoListOrBuilderList() {
                if (this.stageInfoListBuilder_ != null) {
                    return this.stageInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.stageInfoList_);
            }

            public BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo.Builder addStageInfoListBuilder() {
                return getStageInfoListFieldBuilder().addBuilder(BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo.getDefaultInstance());
            }

            public BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo.Builder addStageInfoListBuilder(int index) {
                return getStageInfoListFieldBuilder().addBuilder(index, BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo.getDefaultInstance());
            }

            public List<BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo.Builder> getStageInfoListBuilderList() {
                return getStageInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo, BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfo.Builder, BrickBreakerActivityStageInfoOuterClass.BrickBreakerActivityStageInfoOrBuilder> getStageInfoListFieldBuilder() {
                if (this.stageInfoListBuilder_ == null) {
                    this.stageInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.stageInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.stageInfoList_ = null;
                }
                return this.stageInfoListBuilder_;
            }

            private void ensureDungeonLevelInfoListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.dungeonLevelInfoList_ = new ArrayList(this.dungeonLevelInfoList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
            public List<BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo> getDungeonLevelInfoListList() {
                if (this.dungeonLevelInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.dungeonLevelInfoList_);
                }
                return this.dungeonLevelInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
            public int getDungeonLevelInfoListCount() {
                if (this.dungeonLevelInfoListBuilder_ == null) {
                    return this.dungeonLevelInfoList_.size();
                }
                return this.dungeonLevelInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
            public BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo getDungeonLevelInfoList(int index) {
                if (this.dungeonLevelInfoListBuilder_ == null) {
                    return this.dungeonLevelInfoList_.get(index);
                }
                return this.dungeonLevelInfoListBuilder_.getMessage(index);
            }

            public Builder setDungeonLevelInfoList(int index, BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo value) {
                if (this.dungeonLevelInfoListBuilder_ != null) {
                    this.dungeonLevelInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDungeonLevelInfoListIsMutable();
                    this.dungeonLevelInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDungeonLevelInfoList(int index, BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.Builder builderForValue) {
                if (this.dungeonLevelInfoListBuilder_ == null) {
                    ensureDungeonLevelInfoListIsMutable();
                    this.dungeonLevelInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dungeonLevelInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDungeonLevelInfoList(BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo value) {
                if (this.dungeonLevelInfoListBuilder_ != null) {
                    this.dungeonLevelInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDungeonLevelInfoListIsMutable();
                    this.dungeonLevelInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDungeonLevelInfoList(int index, BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo value) {
                if (this.dungeonLevelInfoListBuilder_ != null) {
                    this.dungeonLevelInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDungeonLevelInfoListIsMutable();
                    this.dungeonLevelInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDungeonLevelInfoList(BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.Builder builderForValue) {
                if (this.dungeonLevelInfoListBuilder_ == null) {
                    ensureDungeonLevelInfoListIsMutable();
                    this.dungeonLevelInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dungeonLevelInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDungeonLevelInfoList(int index, BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.Builder builderForValue) {
                if (this.dungeonLevelInfoListBuilder_ == null) {
                    ensureDungeonLevelInfoListIsMutable();
                    this.dungeonLevelInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dungeonLevelInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDungeonLevelInfoList(Iterable<? extends BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo> values) {
                if (this.dungeonLevelInfoListBuilder_ == null) {
                    ensureDungeonLevelInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.dungeonLevelInfoList_);
                    onChanged();
                } else {
                    this.dungeonLevelInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDungeonLevelInfoList() {
                if (this.dungeonLevelInfoListBuilder_ == null) {
                    this.dungeonLevelInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.dungeonLevelInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeDungeonLevelInfoList(int index) {
                if (this.dungeonLevelInfoListBuilder_ == null) {
                    ensureDungeonLevelInfoListIsMutable();
                    this.dungeonLevelInfoList_.remove(index);
                    onChanged();
                } else {
                    this.dungeonLevelInfoListBuilder_.remove(index);
                }
                return this;
            }

            public BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.Builder getDungeonLevelInfoListBuilder(int index) {
                return getDungeonLevelInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
            public BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder getDungeonLevelInfoListOrBuilder(int index) {
                if (this.dungeonLevelInfoListBuilder_ == null) {
                    return this.dungeonLevelInfoList_.get(index);
                }
                return this.dungeonLevelInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
            public List<? extends BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder> getDungeonLevelInfoListOrBuilderList() {
                if (this.dungeonLevelInfoListBuilder_ != null) {
                    return this.dungeonLevelInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.dungeonLevelInfoList_);
            }

            public BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.Builder addDungeonLevelInfoListBuilder() {
                return getDungeonLevelInfoListFieldBuilder().addBuilder(BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.getDefaultInstance());
            }

            public BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.Builder addDungeonLevelInfoListBuilder(int index) {
                return getDungeonLevelInfoListFieldBuilder().addBuilder(index, BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.getDefaultInstance());
            }

            public List<BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.Builder> getDungeonLevelInfoListBuilderList() {
                return getDungeonLevelInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo, BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.Builder, BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder> getDungeonLevelInfoListFieldBuilder() {
                if (this.dungeonLevelInfoListBuilder_ == null) {
                    this.dungeonLevelInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.dungeonLevelInfoList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.dungeonLevelInfoList_ = null;
                }
                return this.dungeonLevelInfoListBuilder_;
            }

            private void ensureWorldLevelInfoListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.worldLevelInfoList_ = new ArrayList(this.worldLevelInfoList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
            public List<BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo> getWorldLevelInfoListList() {
                if (this.worldLevelInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.worldLevelInfoList_);
                }
                return this.worldLevelInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
            public int getWorldLevelInfoListCount() {
                if (this.worldLevelInfoListBuilder_ == null) {
                    return this.worldLevelInfoList_.size();
                }
                return this.worldLevelInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
            public BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo getWorldLevelInfoList(int index) {
                if (this.worldLevelInfoListBuilder_ == null) {
                    return this.worldLevelInfoList_.get(index);
                }
                return this.worldLevelInfoListBuilder_.getMessage(index);
            }

            public Builder setWorldLevelInfoList(int index, BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo value) {
                if (this.worldLevelInfoListBuilder_ != null) {
                    this.worldLevelInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureWorldLevelInfoListIsMutable();
                    this.worldLevelInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setWorldLevelInfoList(int index, BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.Builder builderForValue) {
                if (this.worldLevelInfoListBuilder_ == null) {
                    ensureWorldLevelInfoListIsMutable();
                    this.worldLevelInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.worldLevelInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addWorldLevelInfoList(BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo value) {
                if (this.worldLevelInfoListBuilder_ != null) {
                    this.worldLevelInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureWorldLevelInfoListIsMutable();
                    this.worldLevelInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addWorldLevelInfoList(int index, BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo value) {
                if (this.worldLevelInfoListBuilder_ != null) {
                    this.worldLevelInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureWorldLevelInfoListIsMutable();
                    this.worldLevelInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addWorldLevelInfoList(BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.Builder builderForValue) {
                if (this.worldLevelInfoListBuilder_ == null) {
                    ensureWorldLevelInfoListIsMutable();
                    this.worldLevelInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.worldLevelInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addWorldLevelInfoList(int index, BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.Builder builderForValue) {
                if (this.worldLevelInfoListBuilder_ == null) {
                    ensureWorldLevelInfoListIsMutable();
                    this.worldLevelInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.worldLevelInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllWorldLevelInfoList(Iterable<? extends BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo> values) {
                if (this.worldLevelInfoListBuilder_ == null) {
                    ensureWorldLevelInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.worldLevelInfoList_);
                    onChanged();
                } else {
                    this.worldLevelInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearWorldLevelInfoList() {
                if (this.worldLevelInfoListBuilder_ == null) {
                    this.worldLevelInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.worldLevelInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeWorldLevelInfoList(int index) {
                if (this.worldLevelInfoListBuilder_ == null) {
                    ensureWorldLevelInfoListIsMutable();
                    this.worldLevelInfoList_.remove(index);
                    onChanged();
                } else {
                    this.worldLevelInfoListBuilder_.remove(index);
                }
                return this;
            }

            public BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.Builder getWorldLevelInfoListBuilder(int index) {
                return getWorldLevelInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
            public BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder getWorldLevelInfoListOrBuilder(int index) {
                if (this.worldLevelInfoListBuilder_ == null) {
                    return this.worldLevelInfoList_.get(index);
                }
                return this.worldLevelInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
            public List<? extends BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder> getWorldLevelInfoListOrBuilderList() {
                if (this.worldLevelInfoListBuilder_ != null) {
                    return this.worldLevelInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.worldLevelInfoList_);
            }

            public BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.Builder addWorldLevelInfoListBuilder() {
                return getWorldLevelInfoListFieldBuilder().addBuilder(BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.getDefaultInstance());
            }

            public BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.Builder addWorldLevelInfoListBuilder(int index) {
                return getWorldLevelInfoListFieldBuilder().addBuilder(index, BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.getDefaultInstance());
            }

            public List<BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.Builder> getWorldLevelInfoListBuilderList() {
                return getWorldLevelInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo, BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.Builder, BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder> getWorldLevelInfoListFieldBuilder() {
                if (this.worldLevelInfoListBuilder_ == null) {
                    this.worldLevelInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.worldLevelInfoList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.worldLevelInfoList_ = null;
                }
                return this.worldLevelInfoListBuilder_;
            }

            private MapField<Integer, Integer> internalGetSkillInfoMap() {
                if (this.skillInfoMap_ == null) {
                    return MapField.emptyMapField(SkillInfoMapDefaultEntryHolder.defaultEntry);
                }
                return this.skillInfoMap_;
            }

            private MapField<Integer, Integer> internalGetMutableSkillInfoMap() {
                onChanged();
                if (this.skillInfoMap_ == null) {
                    this.skillInfoMap_ = MapField.newMapField(SkillInfoMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.skillInfoMap_.isMutable()) {
                    this.skillInfoMap_ = this.skillInfoMap_.copy();
                }
                return this.skillInfoMap_;
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
            public int getSkillInfoMapCount() {
                return internalGetSkillInfoMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
            public boolean containsSkillInfoMap(int key) {
                return internalGetSkillInfoMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getSkillInfoMap() {
                return getSkillInfoMapMap();
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
            public Map<Integer, Integer> getSkillInfoMapMap() {
                return internalGetSkillInfoMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
            public int getSkillInfoMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetSkillInfoMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder
            public int getSkillInfoMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetSkillInfoMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearSkillInfoMap() {
                internalGetMutableSkillInfoMap().getMutableMap().clear();
                return this;
            }

            public Builder removeSkillInfoMap(int key) {
                internalGetMutableSkillInfoMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableSkillInfoMap() {
                return internalGetMutableSkillInfoMap().getMutableMap();
            }

            public Builder putSkillInfoMap(int key, int value) {
                internalGetMutableSkillInfoMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllSkillInfoMap(Map<Integer, Integer> values) {
                internalGetMutableSkillInfoMap().getMutableMap().putAll(values);
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

        public static BrickBreakerDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BrickBreakerDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BrickBreakerDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BrickBreakerDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BrickBreakerActivityStageInfoOuterClass.getDescriptor();
        BrickBreakerLevelInfoOuterClass.getDescriptor();
    }
}
