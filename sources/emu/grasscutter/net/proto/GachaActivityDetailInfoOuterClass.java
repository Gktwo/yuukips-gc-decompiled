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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import emu.grasscutter.net.proto.GachaStageDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaActivityDetailInfoOuterClass.class */
public final class GachaActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dGachaActivityDetailInfo.proto\u001a\u0014GachaStageData.proto\"¬\u0003\n\u0017GachaActivityDetailInfo\u0012\u001b\n\u0013Unk3300_JJDHKJGDEKJ\u0018\f \u0001(\r\u0012@\n\rrobot_num_map\u0018\n \u0003(\u000b2).GachaActivityDetailInfo.RobotNumMapEntry\u0012V\n\u0019have_reward_robot_num_map\u0018\u0003 \u0003(\u000b23.GachaActivityDetailInfo.HaveRewardRobotNumMapEntry\u0012\u001b\n\u0013have_get_robot_list\u0018\u000e \u0003(\r\u0012.\n\u0015gacha_stage_data_list\u0018\u0007 \u0003(\u000b2\u000f.GachaStageData\u0012\u001b\n\u0013Unk3300_IGGPBEOCNGI\u0018\u000f \u0001(\r\u001a2\n\u0010RobotNumMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001\u001a<\n\u001aHaveRewardRobotNumMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{GachaStageDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GachaActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GachaActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GachaActivityDetailInfo_descriptor, new String[]{"Unk3300JJDHKJGDEKJ", "RobotNumMap", "HaveRewardRobotNumMap", "HaveGetRobotList", "GachaStageDataList", "Unk3300IGGPBEOCNGI"});

    /* renamed from: internal_static_GachaActivityDetailInfo_RobotNumMapEntry_descriptor */
    private static final Descriptors.Descriptor f727x4b20c61e = internal_static_GachaActivityDetailInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_GachaActivityDetailInfo_RobotNumMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f728x9c6eee9c = new GeneratedMessageV3.FieldAccessorTable(f727x4b20c61e, new String[]{"Key", "Value"});

    /* renamed from: internal_static_GachaActivityDetailInfo_HaveRewardRobotNumMapEntry_descriptor */
    private static final Descriptors.Descriptor f729xb4b9c267 = internal_static_GachaActivityDetailInfo_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_GachaActivityDetailInfo_HaveRewardRobotNumMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f730x92cf91e5 = new GeneratedMessageV3.FieldAccessorTable(f729xb4b9c267, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaActivityDetailInfoOuterClass$GachaActivityDetailInfoOrBuilder.class */
    public interface GachaActivityDetailInfoOrBuilder extends MessageOrBuilder {
        int getUnk3300JJDHKJGDEKJ();

        int getRobotNumMapCount();

        boolean containsRobotNumMap(int i);

        @Deprecated
        Map<Integer, Integer> getRobotNumMap();

        Map<Integer, Integer> getRobotNumMapMap();

        int getRobotNumMapOrDefault(int i, int i2);

        int getRobotNumMapOrThrow(int i);

        int getHaveRewardRobotNumMapCount();

        boolean containsHaveRewardRobotNumMap(int i);

        @Deprecated
        Map<Integer, Integer> getHaveRewardRobotNumMap();

        Map<Integer, Integer> getHaveRewardRobotNumMapMap();

        int getHaveRewardRobotNumMapOrDefault(int i, int i2);

        int getHaveRewardRobotNumMapOrThrow(int i);

        List<Integer> getHaveGetRobotListList();

        int getHaveGetRobotListCount();

        int getHaveGetRobotList(int i);

        List<GachaStageDataOuterClass.GachaStageData> getGachaStageDataListList();

        GachaStageDataOuterClass.GachaStageData getGachaStageDataList(int i);

        int getGachaStageDataListCount();

        List<? extends GachaStageDataOuterClass.GachaStageDataOrBuilder> getGachaStageDataListOrBuilderList();

        GachaStageDataOuterClass.GachaStageDataOrBuilder getGachaStageDataListOrBuilder(int i);

        int getUnk3300IGGPBEOCNGI();
    }

    private GachaActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaActivityDetailInfoOuterClass$GachaActivityDetailInfo.class */
    public static final class GachaActivityDetailInfo extends GeneratedMessageV3 implements GachaActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_JJDHKJGDEKJ_FIELD_NUMBER = 12;
        private int unk3300JJDHKJGDEKJ_;
        public static final int ROBOT_NUM_MAP_FIELD_NUMBER = 10;
        private MapField<Integer, Integer> robotNumMap_;
        public static final int HAVE_REWARD_ROBOT_NUM_MAP_FIELD_NUMBER = 3;
        private MapField<Integer, Integer> haveRewardRobotNumMap_;
        public static final int HAVE_GET_ROBOT_LIST_FIELD_NUMBER = 14;
        private Internal.IntList haveGetRobotList_;
        private int haveGetRobotListMemoizedSerializedSize;
        public static final int GACHA_STAGE_DATA_LIST_FIELD_NUMBER = 7;
        private List<GachaStageDataOuterClass.GachaStageData> gachaStageDataList_;
        public static final int UNK3300_IGGPBEOCNGI_FIELD_NUMBER = 15;
        private int unk3300IGGPBEOCNGI_;
        private byte memoizedIsInitialized;
        private static final GachaActivityDetailInfo DEFAULT_INSTANCE = new GachaActivityDetailInfo();
        private static final Parser<GachaActivityDetailInfo> PARSER = new AbstractParser<GachaActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public GachaActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GachaActivityDetailInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 3: goto L_0x0021;
                    case 10: goto L_0x001c;
                    default: goto L_0x0026;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetRobotNumMap()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetHaveRewardRobotNumMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private GachaActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.haveGetRobotListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GachaActivityDetailInfo() {
            this.haveGetRobotListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.haveGetRobotList_ = emptyIntList();
            this.gachaStageDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GachaActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:82:0x01ba */
        private GachaActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 26:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.haveRewardRobotNumMap_ = MapField.newMapField(HaveRewardRobotNumMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Integer> haveRewardRobotNumMap__ = (MapEntry) input.readMessage(HaveRewardRobotNumMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.haveRewardRobotNumMap_.getMutableMap().put(haveRewardRobotNumMap__.getKey(), haveRewardRobotNumMap__.getValue());
                                break;
                            case 58:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.gachaStageDataList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.gachaStageDataList_.add((GachaStageDataOuterClass.GachaStageData) input.readMessage(GachaStageDataOuterClass.GachaStageData.parser(), extensionRegistry));
                                break;
                            case 82:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.robotNumMap_ = MapField.newMapField(RobotNumMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Integer> robotNumMap__ = (MapEntry) input.readMessage(RobotNumMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.robotNumMap_.getMutableMap().put(robotNumMap__.getKey(), robotNumMap__.getValue());
                                break;
                            case 96:
                                this.unk3300JJDHKJGDEKJ_ = input.readUInt32();
                                break;
                            case 112:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.haveGetRobotList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.haveGetRobotList_.addInt(input.readUInt32());
                                break;
                            case 114:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.haveGetRobotList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.haveGetRobotList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 120:
                                this.unk3300IGGPBEOCNGI_ = input.readUInt32();
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
                if ((mutable_bitField0_ & 8) != 0) {
                    this.gachaStageDataList_ = Collections.unmodifiableList(this.gachaStageDataList_);
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.haveGetRobotList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GachaActivityDetailInfoOuterClass.internal_static_GachaActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GachaActivityDetailInfoOuterClass.internal_static_GachaActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GachaActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
        public int getUnk3300JJDHKJGDEKJ() {
            return this.unk3300JJDHKJGDEKJ_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaActivityDetailInfoOuterClass$GachaActivityDetailInfo$RobotNumMapDefaultEntryHolder.class */
        public static final class RobotNumMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(GachaActivityDetailInfoOuterClass.f727x4b20c61e, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private RobotNumMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetRobotNumMap() {
            if (this.robotNumMap_ == null) {
                return MapField.emptyMapField(RobotNumMapDefaultEntryHolder.defaultEntry);
            }
            return this.robotNumMap_;
        }

        @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
        public int getRobotNumMapCount() {
            return internalGetRobotNumMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
        public boolean containsRobotNumMap(int key) {
            return internalGetRobotNumMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getRobotNumMap() {
            return getRobotNumMapMap();
        }

        @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
        public Map<Integer, Integer> getRobotNumMapMap() {
            return internalGetRobotNumMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
        public int getRobotNumMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetRobotNumMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
        public int getRobotNumMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetRobotNumMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaActivityDetailInfoOuterClass$GachaActivityDetailInfo$HaveRewardRobotNumMapDefaultEntryHolder.class */
        public static final class HaveRewardRobotNumMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(GachaActivityDetailInfoOuterClass.f729xb4b9c267, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private HaveRewardRobotNumMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetHaveRewardRobotNumMap() {
            if (this.haveRewardRobotNumMap_ == null) {
                return MapField.emptyMapField(HaveRewardRobotNumMapDefaultEntryHolder.defaultEntry);
            }
            return this.haveRewardRobotNumMap_;
        }

        @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
        public int getHaveRewardRobotNumMapCount() {
            return internalGetHaveRewardRobotNumMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
        public boolean containsHaveRewardRobotNumMap(int key) {
            return internalGetHaveRewardRobotNumMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getHaveRewardRobotNumMap() {
            return getHaveRewardRobotNumMapMap();
        }

        @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
        public Map<Integer, Integer> getHaveRewardRobotNumMapMap() {
            return internalGetHaveRewardRobotNumMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
        public int getHaveRewardRobotNumMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetHaveRewardRobotNumMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
        public int getHaveRewardRobotNumMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetHaveRewardRobotNumMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
        public List<Integer> getHaveGetRobotListList() {
            return this.haveGetRobotList_;
        }

        @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
        public int getHaveGetRobotListCount() {
            return this.haveGetRobotList_.size();
        }

        @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
        public int getHaveGetRobotList(int index) {
            return this.haveGetRobotList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
        public List<GachaStageDataOuterClass.GachaStageData> getGachaStageDataListList() {
            return this.gachaStageDataList_;
        }

        @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
        public List<? extends GachaStageDataOuterClass.GachaStageDataOrBuilder> getGachaStageDataListOrBuilderList() {
            return this.gachaStageDataList_;
        }

        @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
        public int getGachaStageDataListCount() {
            return this.gachaStageDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
        public GachaStageDataOuterClass.GachaStageData getGachaStageDataList(int index) {
            return this.gachaStageDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
        public GachaStageDataOuterClass.GachaStageDataOrBuilder getGachaStageDataListOrBuilder(int index) {
            return this.gachaStageDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
        public int getUnk3300IGGPBEOCNGI() {
            return this.unk3300IGGPBEOCNGI_;
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
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetHaveRewardRobotNumMap(), HaveRewardRobotNumMapDefaultEntryHolder.defaultEntry, 3);
            for (int i = 0; i < this.gachaStageDataList_.size(); i++) {
                output.writeMessage(7, this.gachaStageDataList_.get(i));
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetRobotNumMap(), RobotNumMapDefaultEntryHolder.defaultEntry, 10);
            if (this.unk3300JJDHKJGDEKJ_ != 0) {
                output.writeUInt32(12, this.unk3300JJDHKJGDEKJ_);
            }
            if (getHaveGetRobotListList().size() > 0) {
                output.writeUInt32NoTag(114);
                output.writeUInt32NoTag(this.haveGetRobotListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.haveGetRobotList_.size(); i2++) {
                output.writeUInt32NoTag(this.haveGetRobotList_.getInt(i2));
            }
            if (this.unk3300IGGPBEOCNGI_ != 0) {
                output.writeUInt32(15, this.unk3300IGGPBEOCNGI_);
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
            for (Map.Entry<Integer, Integer> entry : internalGetHaveRewardRobotNumMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(3, HaveRewardRobotNumMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            for (int i = 0; i < this.gachaStageDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.gachaStageDataList_.get(i));
            }
            for (Map.Entry<Integer, Integer> entry2 : internalGetRobotNumMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(10, RobotNumMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            if (this.unk3300JJDHKJGDEKJ_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.unk3300JJDHKJGDEKJ_);
            }
            int dataSize = 0;
            for (int i2 = 0; i2 < this.haveGetRobotList_.size(); i2++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.haveGetRobotList_.getInt(i2));
            }
            int size3 = size2 + dataSize;
            if (!getHaveGetRobotListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.haveGetRobotListMemoizedSerializedSize = dataSize;
            if (this.unk3300IGGPBEOCNGI_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(15, this.unk3300IGGPBEOCNGI_);
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
            if (!(obj instanceof GachaActivityDetailInfo)) {
                return equals(obj);
            }
            GachaActivityDetailInfo other = (GachaActivityDetailInfo) obj;
            return getUnk3300JJDHKJGDEKJ() == other.getUnk3300JJDHKJGDEKJ() && internalGetRobotNumMap().equals(other.internalGetRobotNumMap()) && internalGetHaveRewardRobotNumMap().equals(other.internalGetHaveRewardRobotNumMap()) && getHaveGetRobotListList().equals(other.getHaveGetRobotListList()) && getGachaStageDataListList().equals(other.getGachaStageDataListList()) && getUnk3300IGGPBEOCNGI() == other.getUnk3300IGGPBEOCNGI() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + getUnk3300JJDHKJGDEKJ();
            if (!internalGetRobotNumMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 10)) + internalGetRobotNumMap().hashCode();
            }
            if (!internalGetHaveRewardRobotNumMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 3)) + internalGetHaveRewardRobotNumMap().hashCode();
            }
            if (getHaveGetRobotListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getHaveGetRobotListList().hashCode();
            }
            if (getGachaStageDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getGachaStageDataListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 15)) + getUnk3300IGGPBEOCNGI())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GachaActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (GachaActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GachaActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GachaActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (GachaActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GachaActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GachaActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (GachaActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GachaActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GachaActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaActivityDetailInfoOuterClass$GachaActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GachaActivityDetailInfoOrBuilder {
            private int bitField0_;
            private int unk3300JJDHKJGDEKJ_;
            private MapField<Integer, Integer> robotNumMap_;
            private MapField<Integer, Integer> haveRewardRobotNumMap_;
            private Internal.IntList haveGetRobotList_ = GachaActivityDetailInfo.emptyIntList();
            private List<GachaStageDataOuterClass.GachaStageData> gachaStageDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<GachaStageDataOuterClass.GachaStageData, GachaStageDataOuterClass.GachaStageData.Builder, GachaStageDataOuterClass.GachaStageDataOrBuilder> gachaStageDataListBuilder_;
            private int unk3300IGGPBEOCNGI_;

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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 3: goto L_0x0021;
                        case 10: goto L_0x001c;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetRobotNumMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetHaveRewardRobotNumMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 3: goto L_0x0021;
                        case 10: goto L_0x001c;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableRobotNumMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableHaveRewardRobotNumMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return GachaActivityDetailInfoOuterClass.internal_static_GachaActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GachaActivityDetailInfoOuterClass.internal_static_GachaActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GachaActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GachaActivityDetailInfo.alwaysUseFieldBuilders) {
                    getGachaStageDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300JJDHKJGDEKJ_ = 0;
                internalGetMutableRobotNumMap().clear();
                internalGetMutableHaveRewardRobotNumMap().clear();
                this.haveGetRobotList_ = GachaActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -5;
                if (this.gachaStageDataListBuilder_ == null) {
                    this.gachaStageDataList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.gachaStageDataListBuilder_.clear();
                }
                this.unk3300IGGPBEOCNGI_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GachaActivityDetailInfoOuterClass.internal_static_GachaActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GachaActivityDetailInfo getDefaultInstanceForType() {
                return GachaActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GachaActivityDetailInfo build() {
                GachaActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GachaActivityDetailInfo buildPartial() {
                GachaActivityDetailInfo result = new GachaActivityDetailInfo(this);
                int i = this.bitField0_;
                result.unk3300JJDHKJGDEKJ_ = this.unk3300JJDHKJGDEKJ_;
                result.robotNumMap_ = internalGetRobotNumMap();
                result.robotNumMap_.makeImmutable();
                result.haveRewardRobotNumMap_ = internalGetHaveRewardRobotNumMap();
                result.haveRewardRobotNumMap_.makeImmutable();
                if ((this.bitField0_ & 4) != 0) {
                    this.haveGetRobotList_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.haveGetRobotList_ = this.haveGetRobotList_;
                if (this.gachaStageDataListBuilder_ == null) {
                    if ((this.bitField0_ & 8) != 0) {
                        this.gachaStageDataList_ = Collections.unmodifiableList(this.gachaStageDataList_);
                        this.bitField0_ &= -9;
                    }
                    result.gachaStageDataList_ = this.gachaStageDataList_;
                } else {
                    result.gachaStageDataList_ = this.gachaStageDataListBuilder_.build();
                }
                result.unk3300IGGPBEOCNGI_ = this.unk3300IGGPBEOCNGI_;
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
                if (other instanceof GachaActivityDetailInfo) {
                    return mergeFrom((GachaActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GachaActivityDetailInfo other) {
                if (other == GachaActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300JJDHKJGDEKJ() != 0) {
                    setUnk3300JJDHKJGDEKJ(other.getUnk3300JJDHKJGDEKJ());
                }
                internalGetMutableRobotNumMap().mergeFrom(other.internalGetRobotNumMap());
                internalGetMutableHaveRewardRobotNumMap().mergeFrom(other.internalGetHaveRewardRobotNumMap());
                if (!other.haveGetRobotList_.isEmpty()) {
                    if (this.haveGetRobotList_.isEmpty()) {
                        this.haveGetRobotList_ = other.haveGetRobotList_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureHaveGetRobotListIsMutable();
                        this.haveGetRobotList_.addAll(other.haveGetRobotList_);
                    }
                    onChanged();
                }
                if (this.gachaStageDataListBuilder_ == null) {
                    if (!other.gachaStageDataList_.isEmpty()) {
                        if (this.gachaStageDataList_.isEmpty()) {
                            this.gachaStageDataList_ = other.gachaStageDataList_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureGachaStageDataListIsMutable();
                            this.gachaStageDataList_.addAll(other.gachaStageDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.gachaStageDataList_.isEmpty()) {
                    if (this.gachaStageDataListBuilder_.isEmpty()) {
                        this.gachaStageDataListBuilder_.dispose();
                        this.gachaStageDataListBuilder_ = null;
                        this.gachaStageDataList_ = other.gachaStageDataList_;
                        this.bitField0_ &= -9;
                        this.gachaStageDataListBuilder_ = GachaActivityDetailInfo.alwaysUseFieldBuilders ? getGachaStageDataListFieldBuilder() : null;
                    } else {
                        this.gachaStageDataListBuilder_.addAllMessages(other.gachaStageDataList_);
                    }
                }
                if (other.getUnk3300IGGPBEOCNGI() != 0) {
                    setUnk3300IGGPBEOCNGI(other.getUnk3300IGGPBEOCNGI());
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
                GachaActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = GachaActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GachaActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
            public int getUnk3300JJDHKJGDEKJ() {
                return this.unk3300JJDHKJGDEKJ_;
            }

            public Builder setUnk3300JJDHKJGDEKJ(int value) {
                this.unk3300JJDHKJGDEKJ_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300JJDHKJGDEKJ() {
                this.unk3300JJDHKJGDEKJ_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetRobotNumMap() {
                if (this.robotNumMap_ == null) {
                    return MapField.emptyMapField(RobotNumMapDefaultEntryHolder.defaultEntry);
                }
                return this.robotNumMap_;
            }

            private MapField<Integer, Integer> internalGetMutableRobotNumMap() {
                onChanged();
                if (this.robotNumMap_ == null) {
                    this.robotNumMap_ = MapField.newMapField(RobotNumMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.robotNumMap_.isMutable()) {
                    this.robotNumMap_ = this.robotNumMap_.copy();
                }
                return this.robotNumMap_;
            }

            @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
            public int getRobotNumMapCount() {
                return internalGetRobotNumMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
            public boolean containsRobotNumMap(int key) {
                return internalGetRobotNumMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getRobotNumMap() {
                return getRobotNumMapMap();
            }

            @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
            public Map<Integer, Integer> getRobotNumMapMap() {
                return internalGetRobotNumMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
            public int getRobotNumMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetRobotNumMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
            public int getRobotNumMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetRobotNumMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearRobotNumMap() {
                internalGetMutableRobotNumMap().getMutableMap().clear();
                return this;
            }

            public Builder removeRobotNumMap(int key) {
                internalGetMutableRobotNumMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableRobotNumMap() {
                return internalGetMutableRobotNumMap().getMutableMap();
            }

            public Builder putRobotNumMap(int key, int value) {
                internalGetMutableRobotNumMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllRobotNumMap(Map<Integer, Integer> values) {
                internalGetMutableRobotNumMap().getMutableMap().putAll(values);
                return this;
            }

            private MapField<Integer, Integer> internalGetHaveRewardRobotNumMap() {
                if (this.haveRewardRobotNumMap_ == null) {
                    return MapField.emptyMapField(HaveRewardRobotNumMapDefaultEntryHolder.defaultEntry);
                }
                return this.haveRewardRobotNumMap_;
            }

            private MapField<Integer, Integer> internalGetMutableHaveRewardRobotNumMap() {
                onChanged();
                if (this.haveRewardRobotNumMap_ == null) {
                    this.haveRewardRobotNumMap_ = MapField.newMapField(HaveRewardRobotNumMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.haveRewardRobotNumMap_.isMutable()) {
                    this.haveRewardRobotNumMap_ = this.haveRewardRobotNumMap_.copy();
                }
                return this.haveRewardRobotNumMap_;
            }

            @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
            public int getHaveRewardRobotNumMapCount() {
                return internalGetHaveRewardRobotNumMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
            public boolean containsHaveRewardRobotNumMap(int key) {
                return internalGetHaveRewardRobotNumMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getHaveRewardRobotNumMap() {
                return getHaveRewardRobotNumMapMap();
            }

            @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
            public Map<Integer, Integer> getHaveRewardRobotNumMapMap() {
                return internalGetHaveRewardRobotNumMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
            public int getHaveRewardRobotNumMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetHaveRewardRobotNumMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
            public int getHaveRewardRobotNumMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetHaveRewardRobotNumMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearHaveRewardRobotNumMap() {
                internalGetMutableHaveRewardRobotNumMap().getMutableMap().clear();
                return this;
            }

            public Builder removeHaveRewardRobotNumMap(int key) {
                internalGetMutableHaveRewardRobotNumMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableHaveRewardRobotNumMap() {
                return internalGetMutableHaveRewardRobotNumMap().getMutableMap();
            }

            public Builder putHaveRewardRobotNumMap(int key, int value) {
                internalGetMutableHaveRewardRobotNumMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllHaveRewardRobotNumMap(Map<Integer, Integer> values) {
                internalGetMutableHaveRewardRobotNumMap().getMutableMap().putAll(values);
                return this;
            }

            private void ensureHaveGetRobotListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.haveGetRobotList_ = GachaActivityDetailInfo.mutableCopy(this.haveGetRobotList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
            public List<Integer> getHaveGetRobotListList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.haveGetRobotList_) : this.haveGetRobotList_;
            }

            @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
            public int getHaveGetRobotListCount() {
                return this.haveGetRobotList_.size();
            }

            @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
            public int getHaveGetRobotList(int index) {
                return this.haveGetRobotList_.getInt(index);
            }

            public Builder setHaveGetRobotList(int index, int value) {
                ensureHaveGetRobotListIsMutable();
                this.haveGetRobotList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addHaveGetRobotList(int value) {
                ensureHaveGetRobotListIsMutable();
                this.haveGetRobotList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllHaveGetRobotList(Iterable<? extends Integer> values) {
                ensureHaveGetRobotListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.haveGetRobotList_);
                onChanged();
                return this;
            }

            public Builder clearHaveGetRobotList() {
                this.haveGetRobotList_ = GachaActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            private void ensureGachaStageDataListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.gachaStageDataList_ = new ArrayList(this.gachaStageDataList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
            public List<GachaStageDataOuterClass.GachaStageData> getGachaStageDataListList() {
                if (this.gachaStageDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.gachaStageDataList_);
                }
                return this.gachaStageDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
            public int getGachaStageDataListCount() {
                if (this.gachaStageDataListBuilder_ == null) {
                    return this.gachaStageDataList_.size();
                }
                return this.gachaStageDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
            public GachaStageDataOuterClass.GachaStageData getGachaStageDataList(int index) {
                if (this.gachaStageDataListBuilder_ == null) {
                    return this.gachaStageDataList_.get(index);
                }
                return this.gachaStageDataListBuilder_.getMessage(index);
            }

            public Builder setGachaStageDataList(int index, GachaStageDataOuterClass.GachaStageData value) {
                if (this.gachaStageDataListBuilder_ != null) {
                    this.gachaStageDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGachaStageDataListIsMutable();
                    this.gachaStageDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setGachaStageDataList(int index, GachaStageDataOuterClass.GachaStageData.Builder builderForValue) {
                if (this.gachaStageDataListBuilder_ == null) {
                    ensureGachaStageDataListIsMutable();
                    this.gachaStageDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.gachaStageDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addGachaStageDataList(GachaStageDataOuterClass.GachaStageData value) {
                if (this.gachaStageDataListBuilder_ != null) {
                    this.gachaStageDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGachaStageDataListIsMutable();
                    this.gachaStageDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addGachaStageDataList(int index, GachaStageDataOuterClass.GachaStageData value) {
                if (this.gachaStageDataListBuilder_ != null) {
                    this.gachaStageDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGachaStageDataListIsMutable();
                    this.gachaStageDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addGachaStageDataList(GachaStageDataOuterClass.GachaStageData.Builder builderForValue) {
                if (this.gachaStageDataListBuilder_ == null) {
                    ensureGachaStageDataListIsMutable();
                    this.gachaStageDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.gachaStageDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addGachaStageDataList(int index, GachaStageDataOuterClass.GachaStageData.Builder builderForValue) {
                if (this.gachaStageDataListBuilder_ == null) {
                    ensureGachaStageDataListIsMutable();
                    this.gachaStageDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.gachaStageDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllGachaStageDataList(Iterable<? extends GachaStageDataOuterClass.GachaStageData> values) {
                if (this.gachaStageDataListBuilder_ == null) {
                    ensureGachaStageDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.gachaStageDataList_);
                    onChanged();
                } else {
                    this.gachaStageDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearGachaStageDataList() {
                if (this.gachaStageDataListBuilder_ == null) {
                    this.gachaStageDataList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    this.gachaStageDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeGachaStageDataList(int index) {
                if (this.gachaStageDataListBuilder_ == null) {
                    ensureGachaStageDataListIsMutable();
                    this.gachaStageDataList_.remove(index);
                    onChanged();
                } else {
                    this.gachaStageDataListBuilder_.remove(index);
                }
                return this;
            }

            public GachaStageDataOuterClass.GachaStageData.Builder getGachaStageDataListBuilder(int index) {
                return getGachaStageDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
            public GachaStageDataOuterClass.GachaStageDataOrBuilder getGachaStageDataListOrBuilder(int index) {
                if (this.gachaStageDataListBuilder_ == null) {
                    return this.gachaStageDataList_.get(index);
                }
                return this.gachaStageDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
            public List<? extends GachaStageDataOuterClass.GachaStageDataOrBuilder> getGachaStageDataListOrBuilderList() {
                if (this.gachaStageDataListBuilder_ != null) {
                    return this.gachaStageDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.gachaStageDataList_);
            }

            public GachaStageDataOuterClass.GachaStageData.Builder addGachaStageDataListBuilder() {
                return getGachaStageDataListFieldBuilder().addBuilder(GachaStageDataOuterClass.GachaStageData.getDefaultInstance());
            }

            public GachaStageDataOuterClass.GachaStageData.Builder addGachaStageDataListBuilder(int index) {
                return getGachaStageDataListFieldBuilder().addBuilder(index, GachaStageDataOuterClass.GachaStageData.getDefaultInstance());
            }

            public List<GachaStageDataOuterClass.GachaStageData.Builder> getGachaStageDataListBuilderList() {
                return getGachaStageDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<GachaStageDataOuterClass.GachaStageData, GachaStageDataOuterClass.GachaStageData.Builder, GachaStageDataOuterClass.GachaStageDataOrBuilder> getGachaStageDataListFieldBuilder() {
                if (this.gachaStageDataListBuilder_ == null) {
                    this.gachaStageDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.gachaStageDataList_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.gachaStageDataList_ = null;
                }
                return this.gachaStageDataListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder
            public int getUnk3300IGGPBEOCNGI() {
                return this.unk3300IGGPBEOCNGI_;
            }

            public Builder setUnk3300IGGPBEOCNGI(int value) {
                this.unk3300IGGPBEOCNGI_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300IGGPBEOCNGI() {
                this.unk3300IGGPBEOCNGI_ = 0;
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

        public static GachaActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GachaActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GachaActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GachaActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        GachaStageDataOuterClass.getDescriptor();
    }
}
