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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import emu.grasscutter.net.proto.ChallengeFinishTypeOuterClass;
import emu.grasscutter.net.proto.ChannellerSlabLoopDungeonResultInfoOuterClass;
import emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass;
import emu.grasscutter.net.proto.EffigyChallengeDungeonResultInfoOuterClass;
import emu.grasscutter.net.proto.PotionDungeonResultInfoOuterClass;
import emu.grasscutter.net.proto.StrengthenPointDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonChallengeFinishNotifyOuterClass.class */
public final class DungeonChallengeFinishNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"DungeonChallengeFinishNotify.proto\u001a\u0019ChallengeFinishType.proto\u001a)ChannellerSlabLoopDungeonResultInfo.proto\u001a&EffigyChallengeDungeonResultInfo.proto\u001a\u001dPotionDungeonResultInfo.proto\u001a\u001dCustomDungeonResultInfo.proto\u001a\u0019StrengthenPointData.proto\"·\u0005\n\u001cDungeonChallengeFinishNotify\u0012\u0016\n\u000echallengeIndex\u0018\b \u0001(\r\u0012(\n\nfinishType\u0018\r \u0001(\u000e2\u0014.ChallengeFinishType\u0012\u0011\n\tisSuccess\u0018\u0006 \u0001(\b\u0012\u001b\n\u0013challengeRecordType\u0018\u0005 \u0001(\r\u0012\u0013\n\u000bisNewRecord\u0018\u0003 \u0001(\b\u0012\u0014\n\fcurrentValue\u0018\t \u0001(\r\u0012\u0010\n\btimeCost\u0018\u000b \u0001(\r\u0012Y\n\u0016strengthenPointDataMap\u0018\u0007 \u0003(\u000b29.DungeonChallengeFinishNotify.StrengthenPointDataMapEntry\u0012Y\n(channeller_slab_loop_dungeon_result_info\u0018Ë\u000e \u0001(\u000b2$.ChannellerSlabLoopDungeonResultInfoH��\u0012R\n$effigy_challenge_dungeon_result_info\u0018®\u0007 \u0001(\u000b2!.EffigyChallengeDungeonResultInfoH��\u0012?\n\u001apotion_dungeon_result_info\u0018Å\u0005 \u0001(\u000b2\u0018.PotionDungeonResultInfoH��\u0012>\n\u001acustom_dungeon_result_info\u0018) \u0001(\u000b2\u0018.CustomDungeonResultInfoH��\u001aS\n\u001bStrengthenPointDataMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012#\n\u0005value\u0018\u0002 \u0001(\u000b2\u0014.StrengthenPointData:\u00028\u0001B\b\n\u0006detailB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ChallengeFinishTypeOuterClass.getDescriptor(), ChannellerSlabLoopDungeonResultInfoOuterClass.getDescriptor(), EffigyChallengeDungeonResultInfoOuterClass.getDescriptor(), PotionDungeonResultInfoOuterClass.getDescriptor(), CustomDungeonResultInfoOuterClass.getDescriptor(), StrengthenPointDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_DungeonChallengeFinishNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DungeonChallengeFinishNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DungeonChallengeFinishNotify_descriptor, new String[]{"ChallengeIndex", "FinishType", "IsSuccess", "ChallengeRecordType", "IsNewRecord", "CurrentValue", "TimeCost", "StrengthenPointDataMap", "ChannellerSlabLoopDungeonResultInfo", "EffigyChallengeDungeonResultInfo", "PotionDungeonResultInfo", "CustomDungeonResultInfo", "Detail"});

    /* renamed from: internal_static_DungeonChallengeFinishNotify_StrengthenPointDataMapEntry_descriptor */
    private static final Descriptors.Descriptor f683x6c2150b3 = internal_static_DungeonChallengeFinishNotify_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_DungeonChallengeFinishNotify_StrengthenPointDataMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f684xed1a1431 = new GeneratedMessageV3.FieldAccessorTable(f683x6c2150b3, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonChallengeFinishNotifyOuterClass$DungeonChallengeFinishNotifyOrBuilder.class */
    public interface DungeonChallengeFinishNotifyOrBuilder extends MessageOrBuilder {
        int getChallengeIndex();

        int getFinishTypeValue();

        ChallengeFinishTypeOuterClass.ChallengeFinishType getFinishType();

        boolean getIsSuccess();

        int getChallengeRecordType();

        boolean getIsNewRecord();

        int getCurrentValue();

        int getTimeCost();

        int getStrengthenPointDataMapCount();

        boolean containsStrengthenPointDataMap(int i);

        @Deprecated
        Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> getStrengthenPointDataMap();

        Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> getStrengthenPointDataMapMap();

        StrengthenPointDataOuterClass.StrengthenPointData getStrengthenPointDataMapOrDefault(int i, StrengthenPointDataOuterClass.StrengthenPointData strengthenPointData);

        StrengthenPointDataOuterClass.StrengthenPointData getStrengthenPointDataMapOrThrow(int i);

        boolean hasChannellerSlabLoopDungeonResultInfo();

        ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo getChannellerSlabLoopDungeonResultInfo();

        ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfoOrBuilder getChannellerSlabLoopDungeonResultInfoOrBuilder();

        boolean hasEffigyChallengeDungeonResultInfo();

        EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo getEffigyChallengeDungeonResultInfo();

        EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfoOrBuilder getEffigyChallengeDungeonResultInfoOrBuilder();

        boolean hasPotionDungeonResultInfo();

        PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo getPotionDungeonResultInfo();

        PotionDungeonResultInfoOuterClass.PotionDungeonResultInfoOrBuilder getPotionDungeonResultInfoOrBuilder();

        boolean hasCustomDungeonResultInfo();

        CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo getCustomDungeonResultInfo();

        CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder getCustomDungeonResultInfoOrBuilder();

        DungeonChallengeFinishNotify.DetailCase getDetailCase();
    }

    private DungeonChallengeFinishNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonChallengeFinishNotifyOuterClass$DungeonChallengeFinishNotify.class */
    public static final class DungeonChallengeFinishNotify extends GeneratedMessageV3 implements DungeonChallengeFinishNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        private int detailCase_;
        private Object detail_;
        public static final int CHALLENGEINDEX_FIELD_NUMBER = 8;
        private int challengeIndex_;
        public static final int FINISHTYPE_FIELD_NUMBER = 13;
        private int finishType_;
        public static final int ISSUCCESS_FIELD_NUMBER = 6;
        private boolean isSuccess_;
        public static final int CHALLENGERECORDTYPE_FIELD_NUMBER = 5;
        private int challengeRecordType_;
        public static final int ISNEWRECORD_FIELD_NUMBER = 3;
        private boolean isNewRecord_;
        public static final int CURRENTVALUE_FIELD_NUMBER = 9;
        private int currentValue_;
        public static final int TIMECOST_FIELD_NUMBER = 11;
        private int timeCost_;
        public static final int STRENGTHENPOINTDATAMAP_FIELD_NUMBER = 7;
        private MapField<Integer, StrengthenPointDataOuterClass.StrengthenPointData> strengthenPointDataMap_;
        public static final int CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER = 1867;
        public static final int EFFIGY_CHALLENGE_DUNGEON_RESULT_INFO_FIELD_NUMBER = 942;
        public static final int POTION_DUNGEON_RESULT_INFO_FIELD_NUMBER = 709;
        public static final int CUSTOM_DUNGEON_RESULT_INFO_FIELD_NUMBER = 41;
        private byte memoizedIsInitialized;
        private static final DungeonChallengeFinishNotify DEFAULT_INSTANCE = new DungeonChallengeFinishNotify();
        private static final Parser<DungeonChallengeFinishNotify> PARSER = new AbstractParser<DungeonChallengeFinishNotify>() { // from class: emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotify.1
            @Override // com.google.protobuf.Parser
            public DungeonChallengeFinishNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DungeonChallengeFinishNotify(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotify.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 7: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetStrengthenPointDataMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotify.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private DungeonChallengeFinishNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.detailCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private DungeonChallengeFinishNotify() {
            this.detailCase_ = 0;
            this.memoizedIsInitialized = -1;
            this.finishType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DungeonChallengeFinishNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DungeonChallengeFinishNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.isNewRecord_ = input.readBool();
                                break;
                            case 40:
                                this.challengeRecordType_ = input.readUInt32();
                                break;
                            case 48:
                                this.isSuccess_ = input.readBool();
                                break;
                            case 58:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.strengthenPointDataMap_ = MapField.newMapField(StrengthenPointDataMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, StrengthenPointDataOuterClass.StrengthenPointData> strengthenPointDataMap__ = (MapEntry) input.readMessage(StrengthenPointDataMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.strengthenPointDataMap_.getMutableMap().put(strengthenPointDataMap__.getKey(), strengthenPointDataMap__.getValue());
                                break;
                            case 64:
                                this.challengeIndex_ = input.readUInt32();
                                break;
                            case 72:
                                this.currentValue_ = input.readUInt32();
                                break;
                            case 88:
                                this.timeCost_ = input.readUInt32();
                                break;
                            case 104:
                                this.finishType_ = input.readEnum();
                                break;
                            case 330:
                                CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo.Builder subBuilder = this.detailCase_ == 41 ? ((CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo.parser(), extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo) this.detail_);
                                    this.detail_ = subBuilder.buildPartial();
                                }
                                this.detailCase_ = 41;
                                break;
                            case 5674:
                                PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo.Builder subBuilder2 = this.detailCase_ == 709 ? ((PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo.parser(), extensionRegistry);
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo) this.detail_);
                                    this.detail_ = subBuilder2.buildPartial();
                                }
                                this.detailCase_ = 709;
                                break;
                            case 7538:
                                EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.Builder subBuilder3 = this.detailCase_ == 942 ? ((EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.parser(), extensionRegistry);
                                if (subBuilder3 != null) {
                                    subBuilder3.mergeFrom((EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo) this.detail_);
                                    this.detail_ = subBuilder3.buildPartial();
                                }
                                this.detailCase_ = 942;
                                break;
                            case 14938:
                                ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.Builder subBuilder4 = this.detailCase_ == 1867 ? ((ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.parser(), extensionRegistry);
                                if (subBuilder4 != null) {
                                    subBuilder4.mergeFrom((ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo) this.detail_);
                                    this.detail_ = subBuilder4.buildPartial();
                                }
                                this.detailCase_ = CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER;
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
            return DungeonChallengeFinishNotifyOuterClass.internal_static_DungeonChallengeFinishNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DungeonChallengeFinishNotifyOuterClass.internal_static_DungeonChallengeFinishNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(DungeonChallengeFinishNotify.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonChallengeFinishNotifyOuterClass$DungeonChallengeFinishNotify$DetailCase.class */
        public enum DetailCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO(DungeonChallengeFinishNotify.CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER),
            EFFIGY_CHALLENGE_DUNGEON_RESULT_INFO(942),
            POTION_DUNGEON_RESULT_INFO(709),
            CUSTOM_DUNGEON_RESULT_INFO(41),
            DETAIL_NOT_SET(0);
            
            private final int value;

            DetailCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static DetailCase valueOf(int value) {
                return forNumber(value);
            }

            public static DetailCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return DETAIL_NOT_SET;
                    case 41:
                        return CUSTOM_DUNGEON_RESULT_INFO;
                    case 709:
                        return POTION_DUNGEON_RESULT_INFO;
                    case 942:
                        return EFFIGY_CHALLENGE_DUNGEON_RESULT_INFO;
                    case DungeonChallengeFinishNotify.CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER /* 1867 */:
                        return CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public DetailCase getDetailCase() {
            return DetailCase.forNumber(this.detailCase_);
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public int getChallengeIndex() {
            return this.challengeIndex_;
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public int getFinishTypeValue() {
            return this.finishType_;
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public ChallengeFinishTypeOuterClass.ChallengeFinishType getFinishType() {
            ChallengeFinishTypeOuterClass.ChallengeFinishType result = ChallengeFinishTypeOuterClass.ChallengeFinishType.valueOf(this.finishType_);
            return result == null ? ChallengeFinishTypeOuterClass.ChallengeFinishType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public boolean getIsSuccess() {
            return this.isSuccess_;
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public int getChallengeRecordType() {
            return this.challengeRecordType_;
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public boolean getIsNewRecord() {
            return this.isNewRecord_;
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public int getCurrentValue() {
            return this.currentValue_;
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public int getTimeCost() {
            return this.timeCost_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonChallengeFinishNotifyOuterClass$DungeonChallengeFinishNotify$StrengthenPointDataMapDefaultEntryHolder.class */
        public static final class StrengthenPointDataMapDefaultEntryHolder {
            static final MapEntry<Integer, StrengthenPointDataOuterClass.StrengthenPointData> defaultEntry = MapEntry.newDefaultInstance(DungeonChallengeFinishNotifyOuterClass.f683x6c2150b3, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, StrengthenPointDataOuterClass.StrengthenPointData.getDefaultInstance());

            private StrengthenPointDataMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, StrengthenPointDataOuterClass.StrengthenPointData> internalGetStrengthenPointDataMap() {
            if (this.strengthenPointDataMap_ == null) {
                return MapField.emptyMapField(StrengthenPointDataMapDefaultEntryHolder.defaultEntry);
            }
            return this.strengthenPointDataMap_;
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public int getStrengthenPointDataMapCount() {
            return internalGetStrengthenPointDataMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public boolean containsStrengthenPointDataMap(int key) {
            return internalGetStrengthenPointDataMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        @Deprecated
        public Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> getStrengthenPointDataMap() {
            return getStrengthenPointDataMapMap();
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> getStrengthenPointDataMapMap() {
            return internalGetStrengthenPointDataMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public StrengthenPointDataOuterClass.StrengthenPointData getStrengthenPointDataMapOrDefault(int key, StrengthenPointDataOuterClass.StrengthenPointData defaultValue) {
            Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> map = internalGetStrengthenPointDataMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public StrengthenPointDataOuterClass.StrengthenPointData getStrengthenPointDataMapOrThrow(int key) {
            Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> map = internalGetStrengthenPointDataMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public boolean hasChannellerSlabLoopDungeonResultInfo() {
            return this.detailCase_ == 1867;
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo getChannellerSlabLoopDungeonResultInfo() {
            if (this.detailCase_ == 1867) {
                return (ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo) this.detail_;
            }
            return ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfoOrBuilder getChannellerSlabLoopDungeonResultInfoOrBuilder() {
            if (this.detailCase_ == 1867) {
                return (ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo) this.detail_;
            }
            return ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public boolean hasEffigyChallengeDungeonResultInfo() {
            return this.detailCase_ == 942;
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo getEffigyChallengeDungeonResultInfo() {
            if (this.detailCase_ == 942) {
                return (EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo) this.detail_;
            }
            return EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfoOrBuilder getEffigyChallengeDungeonResultInfoOrBuilder() {
            if (this.detailCase_ == 942) {
                return (EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo) this.detail_;
            }
            return EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public boolean hasPotionDungeonResultInfo() {
            return this.detailCase_ == 709;
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo getPotionDungeonResultInfo() {
            if (this.detailCase_ == 709) {
                return (PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo) this.detail_;
            }
            return PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public PotionDungeonResultInfoOuterClass.PotionDungeonResultInfoOrBuilder getPotionDungeonResultInfoOrBuilder() {
            if (this.detailCase_ == 709) {
                return (PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo) this.detail_;
            }
            return PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public boolean hasCustomDungeonResultInfo() {
            return this.detailCase_ == 41;
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo getCustomDungeonResultInfo() {
            if (this.detailCase_ == 41) {
                return (CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo) this.detail_;
            }
            return CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
        public CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder getCustomDungeonResultInfoOrBuilder() {
            if (this.detailCase_ == 41) {
                return (CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo) this.detail_;
            }
            return CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo.getDefaultInstance();
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
            if (this.isNewRecord_) {
                output.writeBool(3, this.isNewRecord_);
            }
            if (this.challengeRecordType_ != 0) {
                output.writeUInt32(5, this.challengeRecordType_);
            }
            if (this.isSuccess_) {
                output.writeBool(6, this.isSuccess_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetStrengthenPointDataMap(), StrengthenPointDataMapDefaultEntryHolder.defaultEntry, 7);
            if (this.challengeIndex_ != 0) {
                output.writeUInt32(8, this.challengeIndex_);
            }
            if (this.currentValue_ != 0) {
                output.writeUInt32(9, this.currentValue_);
            }
            if (this.timeCost_ != 0) {
                output.writeUInt32(11, this.timeCost_);
            }
            if (this.finishType_ != ChallengeFinishTypeOuterClass.ChallengeFinishType.CHALLENGE_FINISH_TYPE_NONE.getNumber()) {
                output.writeEnum(13, this.finishType_);
            }
            if (this.detailCase_ == 41) {
                output.writeMessage(41, (CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo) this.detail_);
            }
            if (this.detailCase_ == 709) {
                output.writeMessage(709, (PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo) this.detail_);
            }
            if (this.detailCase_ == 942) {
                output.writeMessage(942, (EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo) this.detail_);
            }
            if (this.detailCase_ == 1867) {
                output.writeMessage(CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER, (ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo) this.detail_);
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
            if (this.isNewRecord_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(3, this.isNewRecord_);
            }
            if (this.challengeRecordType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.challengeRecordType_);
            }
            if (this.isSuccess_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.isSuccess_);
            }
            for (Map.Entry<Integer, StrengthenPointDataOuterClass.StrengthenPointData> entry : internalGetStrengthenPointDataMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(7, StrengthenPointDataMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.challengeIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.challengeIndex_);
            }
            if (this.currentValue_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.currentValue_);
            }
            if (this.timeCost_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.timeCost_);
            }
            if (this.finishType_ != ChallengeFinishTypeOuterClass.ChallengeFinishType.CHALLENGE_FINISH_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(13, this.finishType_);
            }
            if (this.detailCase_ == 41) {
                size2 += CodedOutputStream.computeMessageSize(41, (CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo) this.detail_);
            }
            if (this.detailCase_ == 709) {
                size2 += CodedOutputStream.computeMessageSize(709, (PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo) this.detail_);
            }
            if (this.detailCase_ == 942) {
                size2 += CodedOutputStream.computeMessageSize(942, (EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo) this.detail_);
            }
            if (this.detailCase_ == 1867) {
                size2 += CodedOutputStream.computeMessageSize(CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER, (ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo) this.detail_);
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
            if (!(obj instanceof DungeonChallengeFinishNotify)) {
                return equals(obj);
            }
            DungeonChallengeFinishNotify other = (DungeonChallengeFinishNotify) obj;
            if (getChallengeIndex() != other.getChallengeIndex() || this.finishType_ != other.finishType_ || getIsSuccess() != other.getIsSuccess() || getChallengeRecordType() != other.getChallengeRecordType() || getIsNewRecord() != other.getIsNewRecord() || getCurrentValue() != other.getCurrentValue() || getTimeCost() != other.getTimeCost() || !internalGetStrengthenPointDataMap().equals(other.internalGetStrengthenPointDataMap()) || !getDetailCase().equals(other.getDetailCase())) {
                return false;
            }
            switch (this.detailCase_) {
                case 41:
                    if (!getCustomDungeonResultInfo().equals(other.getCustomDungeonResultInfo())) {
                        return false;
                    }
                    break;
                case 709:
                    if (!getPotionDungeonResultInfo().equals(other.getPotionDungeonResultInfo())) {
                        return false;
                    }
                    break;
                case 942:
                    if (!getEffigyChallengeDungeonResultInfo().equals(other.getEffigyChallengeDungeonResultInfo())) {
                        return false;
                    }
                    break;
                case CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER /* 1867 */:
                    if (!getChannellerSlabLoopDungeonResultInfo().equals(other.getChannellerSlabLoopDungeonResultInfo())) {
                        return false;
                    }
                    break;
            }
            return this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + getChallengeIndex())) + 13)) + this.finishType_)) + 6)) + Internal.hashBoolean(getIsSuccess()))) + 5)) + getChallengeRecordType())) + 3)) + Internal.hashBoolean(getIsNewRecord()))) + 9)) + getCurrentValue())) + 11)) + getTimeCost();
            if (!internalGetStrengthenPointDataMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 7)) + internalGetStrengthenPointDataMap().hashCode();
            }
            switch (this.detailCase_) {
                case 41:
                    hash = (53 * ((37 * hash) + 41)) + getCustomDungeonResultInfo().hashCode();
                    break;
                case 709:
                    hash = (53 * ((37 * hash) + 709)) + getPotionDungeonResultInfo().hashCode();
                    break;
                case 942:
                    hash = (53 * ((37 * hash) + 942)) + getEffigyChallengeDungeonResultInfo().hashCode();
                    break;
                case CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER /* 1867 */:
                    hash = (53 * ((37 * hash) + CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER)) + getChannellerSlabLoopDungeonResultInfo().hashCode();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DungeonChallengeFinishNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonChallengeFinishNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonChallengeFinishNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonChallengeFinishNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonChallengeFinishNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonChallengeFinishNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonChallengeFinishNotify parseFrom(InputStream input) throws IOException {
            return (DungeonChallengeFinishNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DungeonChallengeFinishNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonChallengeFinishNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DungeonChallengeFinishNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (DungeonChallengeFinishNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DungeonChallengeFinishNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonChallengeFinishNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DungeonChallengeFinishNotify parseFrom(CodedInputStream input) throws IOException {
            return (DungeonChallengeFinishNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DungeonChallengeFinishNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonChallengeFinishNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DungeonChallengeFinishNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonChallengeFinishNotifyOuterClass$DungeonChallengeFinishNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DungeonChallengeFinishNotifyOrBuilder {
            private Object detail_;
            private int bitField0_;
            private int challengeIndex_;
            private boolean isSuccess_;
            private int challengeRecordType_;
            private boolean isNewRecord_;
            private int currentValue_;
            private int timeCost_;
            private MapField<Integer, StrengthenPointDataOuterClass.StrengthenPointData> strengthenPointDataMap_;
            private SingleFieldBuilderV3<ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo, ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.Builder, ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfoOrBuilder> channellerSlabLoopDungeonResultInfoBuilder_;
            private SingleFieldBuilderV3<EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo, EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.Builder, EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfoOrBuilder> effigyChallengeDungeonResultInfoBuilder_;
            private SingleFieldBuilderV3<PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo, PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo.Builder, PotionDungeonResultInfoOuterClass.PotionDungeonResultInfoOrBuilder> potionDungeonResultInfoBuilder_;
            private SingleFieldBuilderV3<CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo, CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo.Builder, CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder> customDungeonResultInfoBuilder_;
            private int detailCase_ = 0;
            private int finishType_ = 0;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 7: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetStrengthenPointDataMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 7: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableStrengthenPointDataMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return DungeonChallengeFinishNotifyOuterClass.internal_static_DungeonChallengeFinishNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DungeonChallengeFinishNotifyOuterClass.internal_static_DungeonChallengeFinishNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(DungeonChallengeFinishNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DungeonChallengeFinishNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.challengeIndex_ = 0;
                this.finishType_ = 0;
                this.isSuccess_ = false;
                this.challengeRecordType_ = 0;
                this.isNewRecord_ = false;
                this.currentValue_ = 0;
                this.timeCost_ = 0;
                internalGetMutableStrengthenPointDataMap().clear();
                this.detailCase_ = 0;
                this.detail_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DungeonChallengeFinishNotifyOuterClass.internal_static_DungeonChallengeFinishNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DungeonChallengeFinishNotify getDefaultInstanceForType() {
                return DungeonChallengeFinishNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DungeonChallengeFinishNotify build() {
                DungeonChallengeFinishNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DungeonChallengeFinishNotify buildPartial() {
                DungeonChallengeFinishNotify result = new DungeonChallengeFinishNotify(this);
                int i = this.bitField0_;
                result.challengeIndex_ = this.challengeIndex_;
                result.finishType_ = this.finishType_;
                result.isSuccess_ = this.isSuccess_;
                result.challengeRecordType_ = this.challengeRecordType_;
                result.isNewRecord_ = this.isNewRecord_;
                result.currentValue_ = this.currentValue_;
                result.timeCost_ = this.timeCost_;
                result.strengthenPointDataMap_ = internalGetStrengthenPointDataMap();
                result.strengthenPointDataMap_.makeImmutable();
                if (this.detailCase_ == 1867) {
                    if (this.channellerSlabLoopDungeonResultInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.channellerSlabLoopDungeonResultInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 942) {
                    if (this.effigyChallengeDungeonResultInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.effigyChallengeDungeonResultInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 709) {
                    if (this.potionDungeonResultInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.potionDungeonResultInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 41) {
                    if (this.customDungeonResultInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.customDungeonResultInfoBuilder_.build();
                    }
                }
                result.detailCase_ = this.detailCase_;
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
                if (other instanceof DungeonChallengeFinishNotify) {
                    return mergeFrom((DungeonChallengeFinishNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DungeonChallengeFinishNotify other) {
                if (other == DungeonChallengeFinishNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getChallengeIndex() != 0) {
                    setChallengeIndex(other.getChallengeIndex());
                }
                if (other.finishType_ != 0) {
                    setFinishTypeValue(other.getFinishTypeValue());
                }
                if (other.getIsSuccess()) {
                    setIsSuccess(other.getIsSuccess());
                }
                if (other.getChallengeRecordType() != 0) {
                    setChallengeRecordType(other.getChallengeRecordType());
                }
                if (other.getIsNewRecord()) {
                    setIsNewRecord(other.getIsNewRecord());
                }
                if (other.getCurrentValue() != 0) {
                    setCurrentValue(other.getCurrentValue());
                }
                if (other.getTimeCost() != 0) {
                    setTimeCost(other.getTimeCost());
                }
                internalGetMutableStrengthenPointDataMap().mergeFrom(other.internalGetStrengthenPointDataMap());
                switch (other.getDetailCase()) {
                    case CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO:
                        mergeChannellerSlabLoopDungeonResultInfo(other.getChannellerSlabLoopDungeonResultInfo());
                        break;
                    case EFFIGY_CHALLENGE_DUNGEON_RESULT_INFO:
                        mergeEffigyChallengeDungeonResultInfo(other.getEffigyChallengeDungeonResultInfo());
                        break;
                    case POTION_DUNGEON_RESULT_INFO:
                        mergePotionDungeonResultInfo(other.getPotionDungeonResultInfo());
                        break;
                    case CUSTOM_DUNGEON_RESULT_INFO:
                        mergeCustomDungeonResultInfo(other.getCustomDungeonResultInfo());
                        break;
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
                DungeonChallengeFinishNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = DungeonChallengeFinishNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DungeonChallengeFinishNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public DetailCase getDetailCase() {
                return DetailCase.forNumber(this.detailCase_);
            }

            public Builder clearDetail() {
                this.detailCase_ = 0;
                this.detail_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public int getChallengeIndex() {
                return this.challengeIndex_;
            }

            public Builder setChallengeIndex(int value) {
                this.challengeIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearChallengeIndex() {
                this.challengeIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public int getFinishTypeValue() {
                return this.finishType_;
            }

            public Builder setFinishTypeValue(int value) {
                this.finishType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public ChallengeFinishTypeOuterClass.ChallengeFinishType getFinishType() {
                ChallengeFinishTypeOuterClass.ChallengeFinishType result = ChallengeFinishTypeOuterClass.ChallengeFinishType.valueOf(this.finishType_);
                return result == null ? ChallengeFinishTypeOuterClass.ChallengeFinishType.UNRECOGNIZED : result;
            }

            public Builder setFinishType(ChallengeFinishTypeOuterClass.ChallengeFinishType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.finishType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearFinishType() {
                this.finishType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public boolean getIsSuccess() {
                return this.isSuccess_;
            }

            public Builder setIsSuccess(boolean value) {
                this.isSuccess_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsSuccess() {
                this.isSuccess_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public int getChallengeRecordType() {
                return this.challengeRecordType_;
            }

            public Builder setChallengeRecordType(int value) {
                this.challengeRecordType_ = value;
                onChanged();
                return this;
            }

            public Builder clearChallengeRecordType() {
                this.challengeRecordType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public boolean getIsNewRecord() {
                return this.isNewRecord_;
            }

            public Builder setIsNewRecord(boolean value) {
                this.isNewRecord_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsNewRecord() {
                this.isNewRecord_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public int getCurrentValue() {
                return this.currentValue_;
            }

            public Builder setCurrentValue(int value) {
                this.currentValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurrentValue() {
                this.currentValue_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public int getTimeCost() {
                return this.timeCost_;
            }

            public Builder setTimeCost(int value) {
                this.timeCost_ = value;
                onChanged();
                return this;
            }

            public Builder clearTimeCost() {
                this.timeCost_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, StrengthenPointDataOuterClass.StrengthenPointData> internalGetStrengthenPointDataMap() {
                if (this.strengthenPointDataMap_ == null) {
                    return MapField.emptyMapField(StrengthenPointDataMapDefaultEntryHolder.defaultEntry);
                }
                return this.strengthenPointDataMap_;
            }

            private MapField<Integer, StrengthenPointDataOuterClass.StrengthenPointData> internalGetMutableStrengthenPointDataMap() {
                onChanged();
                if (this.strengthenPointDataMap_ == null) {
                    this.strengthenPointDataMap_ = MapField.newMapField(StrengthenPointDataMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.strengthenPointDataMap_.isMutable()) {
                    this.strengthenPointDataMap_ = this.strengthenPointDataMap_.copy();
                }
                return this.strengthenPointDataMap_;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public int getStrengthenPointDataMapCount() {
                return internalGetStrengthenPointDataMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public boolean containsStrengthenPointDataMap(int key) {
                return internalGetStrengthenPointDataMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            @Deprecated
            public Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> getStrengthenPointDataMap() {
                return getStrengthenPointDataMapMap();
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> getStrengthenPointDataMapMap() {
                return internalGetStrengthenPointDataMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public StrengthenPointDataOuterClass.StrengthenPointData getStrengthenPointDataMapOrDefault(int key, StrengthenPointDataOuterClass.StrengthenPointData defaultValue) {
                Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> map = internalGetStrengthenPointDataMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public StrengthenPointDataOuterClass.StrengthenPointData getStrengthenPointDataMapOrThrow(int key) {
                Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> map = internalGetStrengthenPointDataMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearStrengthenPointDataMap() {
                internalGetMutableStrengthenPointDataMap().getMutableMap().clear();
                return this;
            }

            public Builder removeStrengthenPointDataMap(int key) {
                internalGetMutableStrengthenPointDataMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> getMutableStrengthenPointDataMap() {
                return internalGetMutableStrengthenPointDataMap().getMutableMap();
            }

            public Builder putStrengthenPointDataMap(int key, StrengthenPointDataOuterClass.StrengthenPointData value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableStrengthenPointDataMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllStrengthenPointDataMap(Map<Integer, StrengthenPointDataOuterClass.StrengthenPointData> values) {
                internalGetMutableStrengthenPointDataMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public boolean hasChannellerSlabLoopDungeonResultInfo() {
                return this.detailCase_ == 1867;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo getChannellerSlabLoopDungeonResultInfo() {
                if (this.channellerSlabLoopDungeonResultInfoBuilder_ == null) {
                    if (this.detailCase_ == 1867) {
                        return (ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo) this.detail_;
                    }
                    return ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1867) {
                    return this.channellerSlabLoopDungeonResultInfoBuilder_.getMessage();
                } else {
                    return ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.getDefaultInstance();
                }
            }

            public Builder setChannellerSlabLoopDungeonResultInfo(ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo value) {
                if (this.channellerSlabLoopDungeonResultInfoBuilder_ != null) {
                    this.channellerSlabLoopDungeonResultInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = DungeonChallengeFinishNotify.CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setChannellerSlabLoopDungeonResultInfo(ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.Builder builderForValue) {
                if (this.channellerSlabLoopDungeonResultInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.channellerSlabLoopDungeonResultInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = DungeonChallengeFinishNotify.CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeChannellerSlabLoopDungeonResultInfo(ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo value) {
                if (this.channellerSlabLoopDungeonResultInfoBuilder_ == null) {
                    if (this.detailCase_ != 1867 || this.detail_ == ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.newBuilder((ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1867) {
                        this.channellerSlabLoopDungeonResultInfoBuilder_.mergeFrom(value);
                    }
                    this.channellerSlabLoopDungeonResultInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = DungeonChallengeFinishNotify.CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearChannellerSlabLoopDungeonResultInfo() {
                if (this.channellerSlabLoopDungeonResultInfoBuilder_ != null) {
                    if (this.detailCase_ == 1867) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.channellerSlabLoopDungeonResultInfoBuilder_.clear();
                } else if (this.detailCase_ == 1867) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.Builder getChannellerSlabLoopDungeonResultInfoBuilder() {
                return getChannellerSlabLoopDungeonResultInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfoOrBuilder getChannellerSlabLoopDungeonResultInfoOrBuilder() {
                if (this.detailCase_ == 1867 && this.channellerSlabLoopDungeonResultInfoBuilder_ != null) {
                    return this.channellerSlabLoopDungeonResultInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1867) {
                    return (ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo) this.detail_;
                }
                return ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo, ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.Builder, ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfoOrBuilder> getChannellerSlabLoopDungeonResultInfoFieldBuilder() {
                if (this.channellerSlabLoopDungeonResultInfoBuilder_ == null) {
                    if (this.detailCase_ != 1867) {
                        this.detail_ = ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo.getDefaultInstance();
                    }
                    this.channellerSlabLoopDungeonResultInfoBuilder_ = new SingleFieldBuilderV3<>((ChannellerSlabLoopDungeonResultInfoOuterClass.ChannellerSlabLoopDungeonResultInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = DungeonChallengeFinishNotify.CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER;
                onChanged();
                return this.channellerSlabLoopDungeonResultInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public boolean hasEffigyChallengeDungeonResultInfo() {
                return this.detailCase_ == 942;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo getEffigyChallengeDungeonResultInfo() {
                if (this.effigyChallengeDungeonResultInfoBuilder_ == null) {
                    if (this.detailCase_ == 942) {
                        return (EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo) this.detail_;
                    }
                    return EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.getDefaultInstance();
                } else if (this.detailCase_ == 942) {
                    return this.effigyChallengeDungeonResultInfoBuilder_.getMessage();
                } else {
                    return EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.getDefaultInstance();
                }
            }

            public Builder setEffigyChallengeDungeonResultInfo(EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo value) {
                if (this.effigyChallengeDungeonResultInfoBuilder_ != null) {
                    this.effigyChallengeDungeonResultInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 942;
                return this;
            }

            public Builder setEffigyChallengeDungeonResultInfo(EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.Builder builderForValue) {
                if (this.effigyChallengeDungeonResultInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.effigyChallengeDungeonResultInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 942;
                return this;
            }

            public Builder mergeEffigyChallengeDungeonResultInfo(EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo value) {
                if (this.effigyChallengeDungeonResultInfoBuilder_ == null) {
                    if (this.detailCase_ != 942 || this.detail_ == EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.newBuilder((EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 942) {
                        this.effigyChallengeDungeonResultInfoBuilder_.mergeFrom(value);
                    }
                    this.effigyChallengeDungeonResultInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 942;
                return this;
            }

            public Builder clearEffigyChallengeDungeonResultInfo() {
                if (this.effigyChallengeDungeonResultInfoBuilder_ != null) {
                    if (this.detailCase_ == 942) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.effigyChallengeDungeonResultInfoBuilder_.clear();
                } else if (this.detailCase_ == 942) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.Builder getEffigyChallengeDungeonResultInfoBuilder() {
                return getEffigyChallengeDungeonResultInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfoOrBuilder getEffigyChallengeDungeonResultInfoOrBuilder() {
                if (this.detailCase_ == 942 && this.effigyChallengeDungeonResultInfoBuilder_ != null) {
                    return this.effigyChallengeDungeonResultInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 942) {
                    return (EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo) this.detail_;
                }
                return EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo, EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.Builder, EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfoOrBuilder> getEffigyChallengeDungeonResultInfoFieldBuilder() {
                if (this.effigyChallengeDungeonResultInfoBuilder_ == null) {
                    if (this.detailCase_ != 942) {
                        this.detail_ = EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo.getDefaultInstance();
                    }
                    this.effigyChallengeDungeonResultInfoBuilder_ = new SingleFieldBuilderV3<>((EffigyChallengeDungeonResultInfoOuterClass.EffigyChallengeDungeonResultInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 942;
                onChanged();
                return this.effigyChallengeDungeonResultInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public boolean hasPotionDungeonResultInfo() {
                return this.detailCase_ == 709;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo getPotionDungeonResultInfo() {
                if (this.potionDungeonResultInfoBuilder_ == null) {
                    if (this.detailCase_ == 709) {
                        return (PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo) this.detail_;
                    }
                    return PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo.getDefaultInstance();
                } else if (this.detailCase_ == 709) {
                    return this.potionDungeonResultInfoBuilder_.getMessage();
                } else {
                    return PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo.getDefaultInstance();
                }
            }

            public Builder setPotionDungeonResultInfo(PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo value) {
                if (this.potionDungeonResultInfoBuilder_ != null) {
                    this.potionDungeonResultInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 709;
                return this;
            }

            public Builder setPotionDungeonResultInfo(PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo.Builder builderForValue) {
                if (this.potionDungeonResultInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.potionDungeonResultInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 709;
                return this;
            }

            public Builder mergePotionDungeonResultInfo(PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo value) {
                if (this.potionDungeonResultInfoBuilder_ == null) {
                    if (this.detailCase_ != 709 || this.detail_ == PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo.newBuilder((PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 709) {
                        this.potionDungeonResultInfoBuilder_.mergeFrom(value);
                    }
                    this.potionDungeonResultInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 709;
                return this;
            }

            public Builder clearPotionDungeonResultInfo() {
                if (this.potionDungeonResultInfoBuilder_ != null) {
                    if (this.detailCase_ == 709) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.potionDungeonResultInfoBuilder_.clear();
                } else if (this.detailCase_ == 709) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo.Builder getPotionDungeonResultInfoBuilder() {
                return getPotionDungeonResultInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public PotionDungeonResultInfoOuterClass.PotionDungeonResultInfoOrBuilder getPotionDungeonResultInfoOrBuilder() {
                if (this.detailCase_ == 709 && this.potionDungeonResultInfoBuilder_ != null) {
                    return this.potionDungeonResultInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 709) {
                    return (PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo) this.detail_;
                }
                return PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo, PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo.Builder, PotionDungeonResultInfoOuterClass.PotionDungeonResultInfoOrBuilder> getPotionDungeonResultInfoFieldBuilder() {
                if (this.potionDungeonResultInfoBuilder_ == null) {
                    if (this.detailCase_ != 709) {
                        this.detail_ = PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo.getDefaultInstance();
                    }
                    this.potionDungeonResultInfoBuilder_ = new SingleFieldBuilderV3<>((PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 709;
                onChanged();
                return this.potionDungeonResultInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public boolean hasCustomDungeonResultInfo() {
                return this.detailCase_ == 41;
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo getCustomDungeonResultInfo() {
                if (this.customDungeonResultInfoBuilder_ == null) {
                    if (this.detailCase_ == 41) {
                        return (CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo) this.detail_;
                    }
                    return CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo.getDefaultInstance();
                } else if (this.detailCase_ == 41) {
                    return this.customDungeonResultInfoBuilder_.getMessage();
                } else {
                    return CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo.getDefaultInstance();
                }
            }

            public Builder setCustomDungeonResultInfo(CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo value) {
                if (this.customDungeonResultInfoBuilder_ != null) {
                    this.customDungeonResultInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 41;
                return this;
            }

            public Builder setCustomDungeonResultInfo(CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo.Builder builderForValue) {
                if (this.customDungeonResultInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.customDungeonResultInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 41;
                return this;
            }

            public Builder mergeCustomDungeonResultInfo(CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo value) {
                if (this.customDungeonResultInfoBuilder_ == null) {
                    if (this.detailCase_ != 41 || this.detail_ == CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo.newBuilder((CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 41) {
                        this.customDungeonResultInfoBuilder_.mergeFrom(value);
                    }
                    this.customDungeonResultInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 41;
                return this;
            }

            public Builder clearCustomDungeonResultInfo() {
                if (this.customDungeonResultInfoBuilder_ != null) {
                    if (this.detailCase_ == 41) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.customDungeonResultInfoBuilder_.clear();
                } else if (this.detailCase_ == 41) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo.Builder getCustomDungeonResultInfoBuilder() {
                return getCustomDungeonResultInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.DungeonChallengeFinishNotifyOuterClass.DungeonChallengeFinishNotifyOrBuilder
            public CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder getCustomDungeonResultInfoOrBuilder() {
                if (this.detailCase_ == 41 && this.customDungeonResultInfoBuilder_ != null) {
                    return this.customDungeonResultInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 41) {
                    return (CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo) this.detail_;
                }
                return CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo, CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo.Builder, CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder> getCustomDungeonResultInfoFieldBuilder() {
                if (this.customDungeonResultInfoBuilder_ == null) {
                    if (this.detailCase_ != 41) {
                        this.detail_ = CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo.getDefaultInstance();
                    }
                    this.customDungeonResultInfoBuilder_ = new SingleFieldBuilderV3<>((CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 41;
                onChanged();
                return this.customDungeonResultInfoBuilder_;
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

        public static DungeonChallengeFinishNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DungeonChallengeFinishNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DungeonChallengeFinishNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DungeonChallengeFinishNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ChallengeFinishTypeOuterClass.getDescriptor();
        ChannellerSlabLoopDungeonResultInfoOuterClass.getDescriptor();
        EffigyChallengeDungeonResultInfoOuterClass.getDescriptor();
        PotionDungeonResultInfoOuterClass.getDescriptor();
        CustomDungeonResultInfoOuterClass.getDescriptor();
        StrengthenPointDataOuterClass.getDescriptor();
    }
}
