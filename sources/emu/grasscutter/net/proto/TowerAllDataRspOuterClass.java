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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass;
import emu.grasscutter.net.proto.TowerFloorRecordOuterClass;
import emu.grasscutter.net.proto.TowerMonthlyBriefOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerAllDataRspOuterClass.class */
public final class TowerAllDataRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015TowerAllDataRsp.proto\u001a\u0019TowerCurLevelRecord.proto\u001a\u0017TowerMonthlyBrief.proto\u001a\u0016TowerFloorRecord.proto\"\u0006\n\u000fTowerAllDataRsp\u0012\u001b\n\u0013Unk3300_OHCHCJGJIDK\u0018\u0007 \u0001(\r\u0012,\n\u000ecurLevelRecord\u0018\u0001 \u0001(\u000b2\u0014.TowerCurLevelRecord\u0012\u0017\n\u000fisFirstInteract\u0018\b \u0001(\b\u0012/\n\u0014towerFloorRecordList\u0018\u0006 \u0003(\u000b2\u0011.TowerFloorRecord\u0012\u001e\n\u0016nextScheduleChangeTime\u0018\u000f \u0001(\r\u0012\u0017\n\u000ftowerScheduleId\u0018\t \u0001(\r\u0012@\n\u0010floorOpenTimeMap\u0018\f \u0003(\u000b2&.TowerAllDataRsp.FloorOpenTimeMapEntry\u0012\u001b\n\u0013validTowerRecordNum\u0018\u0005 \u0001(\r\u0012Z\n\u001dskipFloorGrantedRewardItemMap\u0018\u000b \u0003(\u000b23.TowerAllDataRsp.SkipFloorGrantedRewardItemMapEntry\u0012\u001a\n\u0011scheduleStartTime\u0018Ï\u0004 \u0001(\r\u00125\n\u0018lastScheduleMonthlyBrief\u0018Ê\u000b \u0001(\u000b2\u0012.TowerMonthlyBrief\u0012\u001b\n\u0013Unk3300_LEKODCFPINJ\u0018\n \u0001(\r\u0012\u001b\n\u0013Unk3300_HCDFJBHMHHF\u0018\u0003 \u0001(\r\u0012\u001b\n\u0013Unk3300_JBACKENDHDG\u0018\u000e \u0001(\r\u0012\u001f\n\u0017isFinishedEntranceFloor\u0018\u0002 \u0001(\b\u0012(\n\fmonthlyBrief\u0018\r \u0001(\u000b2\u0012.TowerMonthlyBrief\u0012\u000f\n\u0007retcode\u0018\u0004 \u0001(\u0005\u001a7\n\u0015FloorOpenTimeMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001\u001aD\n\"SkipFloorGrantedRewardItemMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{TowerCurLevelRecordOuterClass.getDescriptor(), TowerMonthlyBriefOuterClass.getDescriptor(), TowerFloorRecordOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TowerAllDataRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TowerAllDataRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TowerAllDataRsp_descriptor, new String[]{"Unk3300OHCHCJGJIDK", "CurLevelRecord", "IsFirstInteract", "TowerFloorRecordList", "NextScheduleChangeTime", "TowerScheduleId", "FloorOpenTimeMap", "ValidTowerRecordNum", "SkipFloorGrantedRewardItemMap", "ScheduleStartTime", "LastScheduleMonthlyBrief", "Unk3300LEKODCFPINJ", "Unk3300HCDFJBHMHHF", "Unk3300JBACKENDHDG", "IsFinishedEntranceFloor", "MonthlyBrief", "Retcode"});
    private static final Descriptors.Descriptor internal_static_TowerAllDataRsp_FloorOpenTimeMapEntry_descriptor = internal_static_TowerAllDataRsp_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_TowerAllDataRsp_FloorOpenTimeMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f858x97d57514 = new GeneratedMessageV3.FieldAccessorTable(internal_static_TowerAllDataRsp_FloorOpenTimeMapEntry_descriptor, new String[]{"Key", "Value"});

    /* renamed from: internal_static_TowerAllDataRsp_SkipFloorGrantedRewardItemMapEntry_descriptor */
    private static final Descriptors.Descriptor f859x8182c987 = internal_static_TowerAllDataRsp_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_TowerAllDataRsp_SkipFloorGrantedRewardItemMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f860xee2f7905 = new GeneratedMessageV3.FieldAccessorTable(f859x8182c987, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerAllDataRspOuterClass$TowerAllDataRspOrBuilder.class */
    public interface TowerAllDataRspOrBuilder extends MessageOrBuilder {
        int getUnk3300OHCHCJGJIDK();

        boolean hasCurLevelRecord();

        TowerCurLevelRecordOuterClass.TowerCurLevelRecord getCurLevelRecord();

        TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder getCurLevelRecordOrBuilder();

        boolean getIsFirstInteract();

        List<TowerFloorRecordOuterClass.TowerFloorRecord> getTowerFloorRecordListList();

        TowerFloorRecordOuterClass.TowerFloorRecord getTowerFloorRecordList(int i);

        int getTowerFloorRecordListCount();

        List<? extends TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder> getTowerFloorRecordListOrBuilderList();

        TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder getTowerFloorRecordListOrBuilder(int i);

        int getNextScheduleChangeTime();

        int getTowerScheduleId();

        int getFloorOpenTimeMapCount();

        boolean containsFloorOpenTimeMap(int i);

        @Deprecated
        Map<Integer, Integer> getFloorOpenTimeMap();

        Map<Integer, Integer> getFloorOpenTimeMapMap();

        int getFloorOpenTimeMapOrDefault(int i, int i2);

        int getFloorOpenTimeMapOrThrow(int i);

        int getValidTowerRecordNum();

        int getSkipFloorGrantedRewardItemMapCount();

        boolean containsSkipFloorGrantedRewardItemMap(int i);

        @Deprecated
        Map<Integer, Integer> getSkipFloorGrantedRewardItemMap();

        Map<Integer, Integer> getSkipFloorGrantedRewardItemMapMap();

        int getSkipFloorGrantedRewardItemMapOrDefault(int i, int i2);

        int getSkipFloorGrantedRewardItemMapOrThrow(int i);

        int getScheduleStartTime();

        boolean hasLastScheduleMonthlyBrief();

        TowerMonthlyBriefOuterClass.TowerMonthlyBrief getLastScheduleMonthlyBrief();

        TowerMonthlyBriefOuterClass.TowerMonthlyBriefOrBuilder getLastScheduleMonthlyBriefOrBuilder();

        int getUnk3300LEKODCFPINJ();

        int getUnk3300HCDFJBHMHHF();

        int getUnk3300JBACKENDHDG();

        boolean getIsFinishedEntranceFloor();

        boolean hasMonthlyBrief();

        TowerMonthlyBriefOuterClass.TowerMonthlyBrief getMonthlyBrief();

        TowerMonthlyBriefOuterClass.TowerMonthlyBriefOrBuilder getMonthlyBriefOrBuilder();

        int getRetcode();
    }

    private TowerAllDataRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerAllDataRspOuterClass$TowerAllDataRsp.class */
    public static final class TowerAllDataRsp extends GeneratedMessageV3 implements TowerAllDataRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_OHCHCJGJIDK_FIELD_NUMBER = 7;
        private int unk3300OHCHCJGJIDK_;
        public static final int CURLEVELRECORD_FIELD_NUMBER = 1;
        private TowerCurLevelRecordOuterClass.TowerCurLevelRecord curLevelRecord_;
        public static final int ISFIRSTINTERACT_FIELD_NUMBER = 8;
        private boolean isFirstInteract_;
        public static final int TOWERFLOORRECORDLIST_FIELD_NUMBER = 6;
        private List<TowerFloorRecordOuterClass.TowerFloorRecord> towerFloorRecordList_;
        public static final int NEXTSCHEDULECHANGETIME_FIELD_NUMBER = 15;
        private int nextScheduleChangeTime_;
        public static final int TOWERSCHEDULEID_FIELD_NUMBER = 9;
        private int towerScheduleId_;
        public static final int FLOOROPENTIMEMAP_FIELD_NUMBER = 12;
        private MapField<Integer, Integer> floorOpenTimeMap_;
        public static final int VALIDTOWERRECORDNUM_FIELD_NUMBER = 5;
        private int validTowerRecordNum_;
        public static final int SKIPFLOORGRANTEDREWARDITEMMAP_FIELD_NUMBER = 11;
        private MapField<Integer, Integer> skipFloorGrantedRewardItemMap_;
        public static final int SCHEDULESTARTTIME_FIELD_NUMBER = 591;
        private int scheduleStartTime_;
        public static final int LASTSCHEDULEMONTHLYBRIEF_FIELD_NUMBER = 1482;
        private TowerMonthlyBriefOuterClass.TowerMonthlyBrief lastScheduleMonthlyBrief_;
        public static final int UNK3300_LEKODCFPINJ_FIELD_NUMBER = 10;
        private int unk3300LEKODCFPINJ_;
        public static final int UNK3300_HCDFJBHMHHF_FIELD_NUMBER = 3;
        private int unk3300HCDFJBHMHHF_;
        public static final int UNK3300_JBACKENDHDG_FIELD_NUMBER = 14;
        private int unk3300JBACKENDHDG_;
        public static final int ISFINISHEDENTRANCEFLOOR_FIELD_NUMBER = 2;
        private boolean isFinishedEntranceFloor_;
        public static final int MONTHLYBRIEF_FIELD_NUMBER = 13;
        private TowerMonthlyBriefOuterClass.TowerMonthlyBrief monthlyBrief_;
        public static final int RETCODE_FIELD_NUMBER = 4;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final TowerAllDataRsp DEFAULT_INSTANCE = new TowerAllDataRsp();
        private static final Parser<TowerAllDataRsp> PARSER = new AbstractParser<TowerAllDataRsp>() { // from class: emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRsp.1
            @Override // com.google.protobuf.Parser
            public TowerAllDataRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TowerAllDataRsp(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRsp.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 11: goto L_0x0021;
                    case 12: goto L_0x001c;
                    default: goto L_0x0026;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetFloorOpenTimeMap()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetSkipFloorGrantedRewardItemMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRsp.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private TowerAllDataRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TowerAllDataRsp() {
            this.memoizedIsInitialized = -1;
            this.towerFloorRecordList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TowerAllDataRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TowerAllDataRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                TowerCurLevelRecordOuterClass.TowerCurLevelRecord.Builder subBuilder = this.curLevelRecord_ != null ? this.curLevelRecord_.toBuilder() : null;
                                this.curLevelRecord_ = (TowerCurLevelRecordOuterClass.TowerCurLevelRecord) input.readMessage(TowerCurLevelRecordOuterClass.TowerCurLevelRecord.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.curLevelRecord_);
                                    this.curLevelRecord_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 16:
                                this.isFinishedEntranceFloor_ = input.readBool();
                                break;
                            case 24:
                                this.unk3300HCDFJBHMHHF_ = input.readUInt32();
                                break;
                            case 32:
                                this.retcode_ = input.readInt32();
                                break;
                            case 40:
                                this.validTowerRecordNum_ = input.readUInt32();
                                break;
                            case 50:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.towerFloorRecordList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.towerFloorRecordList_.add((TowerFloorRecordOuterClass.TowerFloorRecord) input.readMessage(TowerFloorRecordOuterClass.TowerFloorRecord.parser(), extensionRegistry));
                                break;
                            case 56:
                                this.unk3300OHCHCJGJIDK_ = input.readUInt32();
                                break;
                            case 64:
                                this.isFirstInteract_ = input.readBool();
                                break;
                            case 72:
                                this.towerScheduleId_ = input.readUInt32();
                                break;
                            case 80:
                                this.unk3300LEKODCFPINJ_ = input.readUInt32();
                                break;
                            case 90:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.skipFloorGrantedRewardItemMap_ = MapField.newMapField(SkipFloorGrantedRewardItemMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 4;
                                }
                                MapEntry<Integer, Integer> skipFloorGrantedRewardItemMap__ = (MapEntry) input.readMessage(SkipFloorGrantedRewardItemMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.skipFloorGrantedRewardItemMap_.getMutableMap().put(skipFloorGrantedRewardItemMap__.getKey(), skipFloorGrantedRewardItemMap__.getValue());
                                break;
                            case 98:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.floorOpenTimeMap_ = MapField.newMapField(FloorOpenTimeMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 2;
                                }
                                MapEntry<Integer, Integer> floorOpenTimeMap__ = (MapEntry) input.readMessage(FloorOpenTimeMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.floorOpenTimeMap_.getMutableMap().put(floorOpenTimeMap__.getKey(), floorOpenTimeMap__.getValue());
                                break;
                            case 106:
                                TowerMonthlyBriefOuterClass.TowerMonthlyBrief.Builder subBuilder2 = this.monthlyBrief_ != null ? this.monthlyBrief_.toBuilder() : null;
                                this.monthlyBrief_ = (TowerMonthlyBriefOuterClass.TowerMonthlyBrief) input.readMessage(TowerMonthlyBriefOuterClass.TowerMonthlyBrief.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.monthlyBrief_);
                                    this.monthlyBrief_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 112:
                                this.unk3300JBACKENDHDG_ = input.readUInt32();
                                break;
                            case 120:
                                this.nextScheduleChangeTime_ = input.readUInt32();
                                break;
                            case 4728:
                                this.scheduleStartTime_ = input.readUInt32();
                                break;
                            case 11858:
                                TowerMonthlyBriefOuterClass.TowerMonthlyBrief.Builder subBuilder3 = this.lastScheduleMonthlyBrief_ != null ? this.lastScheduleMonthlyBrief_.toBuilder() : null;
                                this.lastScheduleMonthlyBrief_ = (TowerMonthlyBriefOuterClass.TowerMonthlyBrief) input.readMessage(TowerMonthlyBriefOuterClass.TowerMonthlyBrief.parser(), extensionRegistry);
                                if (subBuilder3 == null) {
                                    break;
                                } else {
                                    subBuilder3.mergeFrom(this.lastScheduleMonthlyBrief_);
                                    this.lastScheduleMonthlyBrief_ = subBuilder3.buildPartial();
                                    break;
                                }
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.towerFloorRecordList_ = Collections.unmodifiableList(this.towerFloorRecordList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TowerAllDataRspOuterClass.internal_static_TowerAllDataRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TowerAllDataRspOuterClass.internal_static_TowerAllDataRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(TowerAllDataRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public int getUnk3300OHCHCJGJIDK() {
            return this.unk3300OHCHCJGJIDK_;
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public boolean hasCurLevelRecord() {
            return this.curLevelRecord_ != null;
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public TowerCurLevelRecordOuterClass.TowerCurLevelRecord getCurLevelRecord() {
            return this.curLevelRecord_ == null ? TowerCurLevelRecordOuterClass.TowerCurLevelRecord.getDefaultInstance() : this.curLevelRecord_;
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder getCurLevelRecordOrBuilder() {
            return getCurLevelRecord();
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public boolean getIsFirstInteract() {
            return this.isFirstInteract_;
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public List<TowerFloorRecordOuterClass.TowerFloorRecord> getTowerFloorRecordListList() {
            return this.towerFloorRecordList_;
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public List<? extends TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder> getTowerFloorRecordListOrBuilderList() {
            return this.towerFloorRecordList_;
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public int getTowerFloorRecordListCount() {
            return this.towerFloorRecordList_.size();
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public TowerFloorRecordOuterClass.TowerFloorRecord getTowerFloorRecordList(int index) {
            return this.towerFloorRecordList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder getTowerFloorRecordListOrBuilder(int index) {
            return this.towerFloorRecordList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public int getNextScheduleChangeTime() {
            return this.nextScheduleChangeTime_;
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public int getTowerScheduleId() {
            return this.towerScheduleId_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerAllDataRspOuterClass$TowerAllDataRsp$FloorOpenTimeMapDefaultEntryHolder.class */
        public static final class FloorOpenTimeMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(TowerAllDataRspOuterClass.internal_static_TowerAllDataRsp_FloorOpenTimeMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private FloorOpenTimeMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetFloorOpenTimeMap() {
            if (this.floorOpenTimeMap_ == null) {
                return MapField.emptyMapField(FloorOpenTimeMapDefaultEntryHolder.defaultEntry);
            }
            return this.floorOpenTimeMap_;
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public int getFloorOpenTimeMapCount() {
            return internalGetFloorOpenTimeMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public boolean containsFloorOpenTimeMap(int key) {
            return internalGetFloorOpenTimeMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        @Deprecated
        public Map<Integer, Integer> getFloorOpenTimeMap() {
            return getFloorOpenTimeMapMap();
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public Map<Integer, Integer> getFloorOpenTimeMapMap() {
            return internalGetFloorOpenTimeMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public int getFloorOpenTimeMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetFloorOpenTimeMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public int getFloorOpenTimeMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetFloorOpenTimeMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public int getValidTowerRecordNum() {
            return this.validTowerRecordNum_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerAllDataRspOuterClass$TowerAllDataRsp$SkipFloorGrantedRewardItemMapDefaultEntryHolder.class */
        public static final class SkipFloorGrantedRewardItemMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(TowerAllDataRspOuterClass.f859x8182c987, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private SkipFloorGrantedRewardItemMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetSkipFloorGrantedRewardItemMap() {
            if (this.skipFloorGrantedRewardItemMap_ == null) {
                return MapField.emptyMapField(SkipFloorGrantedRewardItemMapDefaultEntryHolder.defaultEntry);
            }
            return this.skipFloorGrantedRewardItemMap_;
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public int getSkipFloorGrantedRewardItemMapCount() {
            return internalGetSkipFloorGrantedRewardItemMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public boolean containsSkipFloorGrantedRewardItemMap(int key) {
            return internalGetSkipFloorGrantedRewardItemMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        @Deprecated
        public Map<Integer, Integer> getSkipFloorGrantedRewardItemMap() {
            return getSkipFloorGrantedRewardItemMapMap();
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public Map<Integer, Integer> getSkipFloorGrantedRewardItemMapMap() {
            return internalGetSkipFloorGrantedRewardItemMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public int getSkipFloorGrantedRewardItemMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetSkipFloorGrantedRewardItemMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public int getSkipFloorGrantedRewardItemMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetSkipFloorGrantedRewardItemMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public int getScheduleStartTime() {
            return this.scheduleStartTime_;
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public boolean hasLastScheduleMonthlyBrief() {
            return this.lastScheduleMonthlyBrief_ != null;
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public TowerMonthlyBriefOuterClass.TowerMonthlyBrief getLastScheduleMonthlyBrief() {
            return this.lastScheduleMonthlyBrief_ == null ? TowerMonthlyBriefOuterClass.TowerMonthlyBrief.getDefaultInstance() : this.lastScheduleMonthlyBrief_;
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public TowerMonthlyBriefOuterClass.TowerMonthlyBriefOrBuilder getLastScheduleMonthlyBriefOrBuilder() {
            return getLastScheduleMonthlyBrief();
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public int getUnk3300LEKODCFPINJ() {
            return this.unk3300LEKODCFPINJ_;
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public int getUnk3300HCDFJBHMHHF() {
            return this.unk3300HCDFJBHMHHF_;
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public int getUnk3300JBACKENDHDG() {
            return this.unk3300JBACKENDHDG_;
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public boolean getIsFinishedEntranceFloor() {
            return this.isFinishedEntranceFloor_;
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public boolean hasMonthlyBrief() {
            return this.monthlyBrief_ != null;
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public TowerMonthlyBriefOuterClass.TowerMonthlyBrief getMonthlyBrief() {
            return this.monthlyBrief_ == null ? TowerMonthlyBriefOuterClass.TowerMonthlyBrief.getDefaultInstance() : this.monthlyBrief_;
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
        public TowerMonthlyBriefOuterClass.TowerMonthlyBriefOrBuilder getMonthlyBriefOrBuilder() {
            return getMonthlyBrief();
        }

        @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
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
            if (this.curLevelRecord_ != null) {
                output.writeMessage(1, getCurLevelRecord());
            }
            if (this.isFinishedEntranceFloor_) {
                output.writeBool(2, this.isFinishedEntranceFloor_);
            }
            if (this.unk3300HCDFJBHMHHF_ != 0) {
                output.writeUInt32(3, this.unk3300HCDFJBHMHHF_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(4, this.retcode_);
            }
            if (this.validTowerRecordNum_ != 0) {
                output.writeUInt32(5, this.validTowerRecordNum_);
            }
            for (int i = 0; i < this.towerFloorRecordList_.size(); i++) {
                output.writeMessage(6, this.towerFloorRecordList_.get(i));
            }
            if (this.unk3300OHCHCJGJIDK_ != 0) {
                output.writeUInt32(7, this.unk3300OHCHCJGJIDK_);
            }
            if (this.isFirstInteract_) {
                output.writeBool(8, this.isFirstInteract_);
            }
            if (this.towerScheduleId_ != 0) {
                output.writeUInt32(9, this.towerScheduleId_);
            }
            if (this.unk3300LEKODCFPINJ_ != 0) {
                output.writeUInt32(10, this.unk3300LEKODCFPINJ_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetSkipFloorGrantedRewardItemMap(), SkipFloorGrantedRewardItemMapDefaultEntryHolder.defaultEntry, 11);
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetFloorOpenTimeMap(), FloorOpenTimeMapDefaultEntryHolder.defaultEntry, 12);
            if (this.monthlyBrief_ != null) {
                output.writeMessage(13, getMonthlyBrief());
            }
            if (this.unk3300JBACKENDHDG_ != 0) {
                output.writeUInt32(14, this.unk3300JBACKENDHDG_);
            }
            if (this.nextScheduleChangeTime_ != 0) {
                output.writeUInt32(15, this.nextScheduleChangeTime_);
            }
            if (this.scheduleStartTime_ != 0) {
                output.writeUInt32(SCHEDULESTARTTIME_FIELD_NUMBER, this.scheduleStartTime_);
            }
            if (this.lastScheduleMonthlyBrief_ != null) {
                output.writeMessage(LASTSCHEDULEMONTHLYBRIEF_FIELD_NUMBER, getLastScheduleMonthlyBrief());
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
            if (this.curLevelRecord_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(1, getCurLevelRecord());
            }
            if (this.isFinishedEntranceFloor_) {
                size2 += CodedOutputStream.computeBoolSize(2, this.isFinishedEntranceFloor_);
            }
            if (this.unk3300HCDFJBHMHHF_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.unk3300HCDFJBHMHHF_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(4, this.retcode_);
            }
            if (this.validTowerRecordNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.validTowerRecordNum_);
            }
            for (int i = 0; i < this.towerFloorRecordList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(6, this.towerFloorRecordList_.get(i));
            }
            if (this.unk3300OHCHCJGJIDK_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.unk3300OHCHCJGJIDK_);
            }
            if (this.isFirstInteract_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.isFirstInteract_);
            }
            if (this.towerScheduleId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.towerScheduleId_);
            }
            if (this.unk3300LEKODCFPINJ_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.unk3300LEKODCFPINJ_);
            }
            for (Map.Entry<Integer, Integer> entry : internalGetSkipFloorGrantedRewardItemMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(11, SkipFloorGrantedRewardItemMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            for (Map.Entry<Integer, Integer> entry2 : internalGetFloorOpenTimeMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(12, FloorOpenTimeMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            if (this.monthlyBrief_ != null) {
                size2 += CodedOutputStream.computeMessageSize(13, getMonthlyBrief());
            }
            if (this.unk3300JBACKENDHDG_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.unk3300JBACKENDHDG_);
            }
            if (this.nextScheduleChangeTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.nextScheduleChangeTime_);
            }
            if (this.scheduleStartTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(SCHEDULESTARTTIME_FIELD_NUMBER, this.scheduleStartTime_);
            }
            if (this.lastScheduleMonthlyBrief_ != null) {
                size2 += CodedOutputStream.computeMessageSize(LASTSCHEDULEMONTHLYBRIEF_FIELD_NUMBER, getLastScheduleMonthlyBrief());
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
            if (!(obj instanceof TowerAllDataRsp)) {
                return equals(obj);
            }
            TowerAllDataRsp other = (TowerAllDataRsp) obj;
            if (getUnk3300OHCHCJGJIDK() != other.getUnk3300OHCHCJGJIDK() || hasCurLevelRecord() != other.hasCurLevelRecord()) {
                return false;
            }
            if ((hasCurLevelRecord() && !getCurLevelRecord().equals(other.getCurLevelRecord())) || getIsFirstInteract() != other.getIsFirstInteract() || !getTowerFloorRecordListList().equals(other.getTowerFloorRecordListList()) || getNextScheduleChangeTime() != other.getNextScheduleChangeTime() || getTowerScheduleId() != other.getTowerScheduleId() || !internalGetFloorOpenTimeMap().equals(other.internalGetFloorOpenTimeMap()) || getValidTowerRecordNum() != other.getValidTowerRecordNum() || !internalGetSkipFloorGrantedRewardItemMap().equals(other.internalGetSkipFloorGrantedRewardItemMap()) || getScheduleStartTime() != other.getScheduleStartTime() || hasLastScheduleMonthlyBrief() != other.hasLastScheduleMonthlyBrief()) {
                return false;
            }
            if ((!hasLastScheduleMonthlyBrief() || getLastScheduleMonthlyBrief().equals(other.getLastScheduleMonthlyBrief())) && getUnk3300LEKODCFPINJ() == other.getUnk3300LEKODCFPINJ() && getUnk3300HCDFJBHMHHF() == other.getUnk3300HCDFJBHMHHF() && getUnk3300JBACKENDHDG() == other.getUnk3300JBACKENDHDG() && getIsFinishedEntranceFloor() == other.getIsFinishedEntranceFloor() && hasMonthlyBrief() == other.hasMonthlyBrief()) {
                return (!hasMonthlyBrief() || getMonthlyBrief().equals(other.getMonthlyBrief())) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + getUnk3300OHCHCJGJIDK();
            if (hasCurLevelRecord()) {
                hash = (53 * ((37 * hash) + 1)) + getCurLevelRecord().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 8)) + Internal.hashBoolean(getIsFirstInteract());
            if (getTowerFloorRecordListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 6)) + getTowerFloorRecordListList().hashCode();
            }
            int hash3 = (53 * ((37 * ((53 * ((37 * hash2) + 15)) + getNextScheduleChangeTime())) + 9)) + getTowerScheduleId();
            if (!internalGetFloorOpenTimeMap().getMap().isEmpty()) {
                hash3 = (53 * ((37 * hash3) + 12)) + internalGetFloorOpenTimeMap().hashCode();
            }
            int hash4 = (53 * ((37 * hash3) + 5)) + getValidTowerRecordNum();
            if (!internalGetSkipFloorGrantedRewardItemMap().getMap().isEmpty()) {
                hash4 = (53 * ((37 * hash4) + 11)) + internalGetSkipFloorGrantedRewardItemMap().hashCode();
            }
            int hash5 = (53 * ((37 * hash4) + SCHEDULESTARTTIME_FIELD_NUMBER)) + getScheduleStartTime();
            if (hasLastScheduleMonthlyBrief()) {
                hash5 = (53 * ((37 * hash5) + LASTSCHEDULEMONTHLYBRIEF_FIELD_NUMBER)) + getLastScheduleMonthlyBrief().hashCode();
            }
            int hash6 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash5) + 10)) + getUnk3300LEKODCFPINJ())) + 3)) + getUnk3300HCDFJBHMHHF())) + 14)) + getUnk3300JBACKENDHDG())) + 2)) + Internal.hashBoolean(getIsFinishedEntranceFloor());
            if (hasMonthlyBrief()) {
                hash6 = (53 * ((37 * hash6) + 13)) + getMonthlyBrief().hashCode();
            }
            int hash7 = (29 * ((53 * ((37 * hash6) + 4)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash7;
            return hash7;
        }

        public static TowerAllDataRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerAllDataRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerAllDataRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerAllDataRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerAllDataRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerAllDataRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerAllDataRsp parseFrom(InputStream input) throws IOException {
            return (TowerAllDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerAllDataRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerAllDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerAllDataRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (TowerAllDataRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TowerAllDataRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerAllDataRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerAllDataRsp parseFrom(CodedInputStream input) throws IOException {
            return (TowerAllDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerAllDataRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerAllDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TowerAllDataRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerAllDataRspOuterClass$TowerAllDataRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TowerAllDataRspOrBuilder {
            private int bitField0_;
            private int unk3300OHCHCJGJIDK_;
            private TowerCurLevelRecordOuterClass.TowerCurLevelRecord curLevelRecord_;
            private SingleFieldBuilderV3<TowerCurLevelRecordOuterClass.TowerCurLevelRecord, TowerCurLevelRecordOuterClass.TowerCurLevelRecord.Builder, TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder> curLevelRecordBuilder_;
            private boolean isFirstInteract_;
            private List<TowerFloorRecordOuterClass.TowerFloorRecord> towerFloorRecordList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<TowerFloorRecordOuterClass.TowerFloorRecord, TowerFloorRecordOuterClass.TowerFloorRecord.Builder, TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder> towerFloorRecordListBuilder_;
            private int nextScheduleChangeTime_;
            private int towerScheduleId_;
            private MapField<Integer, Integer> floorOpenTimeMap_;
            private int validTowerRecordNum_;
            private MapField<Integer, Integer> skipFloorGrantedRewardItemMap_;
            private int scheduleStartTime_;
            private TowerMonthlyBriefOuterClass.TowerMonthlyBrief lastScheduleMonthlyBrief_;
            private SingleFieldBuilderV3<TowerMonthlyBriefOuterClass.TowerMonthlyBrief, TowerMonthlyBriefOuterClass.TowerMonthlyBrief.Builder, TowerMonthlyBriefOuterClass.TowerMonthlyBriefOrBuilder> lastScheduleMonthlyBriefBuilder_;
            private int unk3300LEKODCFPINJ_;
            private int unk3300HCDFJBHMHHF_;
            private int unk3300JBACKENDHDG_;
            private boolean isFinishedEntranceFloor_;
            private TowerMonthlyBriefOuterClass.TowerMonthlyBrief monthlyBrief_;
            private SingleFieldBuilderV3<TowerMonthlyBriefOuterClass.TowerMonthlyBrief, TowerMonthlyBriefOuterClass.TowerMonthlyBrief.Builder, TowerMonthlyBriefOuterClass.TowerMonthlyBriefOrBuilder> monthlyBriefBuilder_;
            private int retcode_;

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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRsp.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 11: goto L_0x0021;
                        case 12: goto L_0x001c;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetFloorOpenTimeMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetSkipFloorGrantedRewardItemMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRsp.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRsp.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 11: goto L_0x0021;
                        case 12: goto L_0x001c;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableFloorOpenTimeMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableSkipFloorGrantedRewardItemMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRsp.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return TowerAllDataRspOuterClass.internal_static_TowerAllDataRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TowerAllDataRspOuterClass.internal_static_TowerAllDataRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(TowerAllDataRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TowerAllDataRsp.alwaysUseFieldBuilders) {
                    getTowerFloorRecordListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300OHCHCJGJIDK_ = 0;
                if (this.curLevelRecordBuilder_ == null) {
                    this.curLevelRecord_ = null;
                } else {
                    this.curLevelRecord_ = null;
                    this.curLevelRecordBuilder_ = null;
                }
                this.isFirstInteract_ = false;
                if (this.towerFloorRecordListBuilder_ == null) {
                    this.towerFloorRecordList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.towerFloorRecordListBuilder_.clear();
                }
                this.nextScheduleChangeTime_ = 0;
                this.towerScheduleId_ = 0;
                internalGetMutableFloorOpenTimeMap().clear();
                this.validTowerRecordNum_ = 0;
                internalGetMutableSkipFloorGrantedRewardItemMap().clear();
                this.scheduleStartTime_ = 0;
                if (this.lastScheduleMonthlyBriefBuilder_ == null) {
                    this.lastScheduleMonthlyBrief_ = null;
                } else {
                    this.lastScheduleMonthlyBrief_ = null;
                    this.lastScheduleMonthlyBriefBuilder_ = null;
                }
                this.unk3300LEKODCFPINJ_ = 0;
                this.unk3300HCDFJBHMHHF_ = 0;
                this.unk3300JBACKENDHDG_ = 0;
                this.isFinishedEntranceFloor_ = false;
                if (this.monthlyBriefBuilder_ == null) {
                    this.monthlyBrief_ = null;
                } else {
                    this.monthlyBrief_ = null;
                    this.monthlyBriefBuilder_ = null;
                }
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TowerAllDataRspOuterClass.internal_static_TowerAllDataRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TowerAllDataRsp getDefaultInstanceForType() {
                return TowerAllDataRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerAllDataRsp build() {
                TowerAllDataRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerAllDataRsp buildPartial() {
                TowerAllDataRsp result = new TowerAllDataRsp(this);
                int i = this.bitField0_;
                result.unk3300OHCHCJGJIDK_ = this.unk3300OHCHCJGJIDK_;
                if (this.curLevelRecordBuilder_ == null) {
                    result.curLevelRecord_ = this.curLevelRecord_;
                } else {
                    result.curLevelRecord_ = this.curLevelRecordBuilder_.build();
                }
                result.isFirstInteract_ = this.isFirstInteract_;
                if (this.towerFloorRecordListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.towerFloorRecordList_ = Collections.unmodifiableList(this.towerFloorRecordList_);
                        this.bitField0_ &= -2;
                    }
                    result.towerFloorRecordList_ = this.towerFloorRecordList_;
                } else {
                    result.towerFloorRecordList_ = this.towerFloorRecordListBuilder_.build();
                }
                result.nextScheduleChangeTime_ = this.nextScheduleChangeTime_;
                result.towerScheduleId_ = this.towerScheduleId_;
                result.floorOpenTimeMap_ = internalGetFloorOpenTimeMap();
                result.floorOpenTimeMap_.makeImmutable();
                result.validTowerRecordNum_ = this.validTowerRecordNum_;
                result.skipFloorGrantedRewardItemMap_ = internalGetSkipFloorGrantedRewardItemMap();
                result.skipFloorGrantedRewardItemMap_.makeImmutable();
                result.scheduleStartTime_ = this.scheduleStartTime_;
                if (this.lastScheduleMonthlyBriefBuilder_ == null) {
                    result.lastScheduleMonthlyBrief_ = this.lastScheduleMonthlyBrief_;
                } else {
                    result.lastScheduleMonthlyBrief_ = this.lastScheduleMonthlyBriefBuilder_.build();
                }
                result.unk3300LEKODCFPINJ_ = this.unk3300LEKODCFPINJ_;
                result.unk3300HCDFJBHMHHF_ = this.unk3300HCDFJBHMHHF_;
                result.unk3300JBACKENDHDG_ = this.unk3300JBACKENDHDG_;
                result.isFinishedEntranceFloor_ = this.isFinishedEntranceFloor_;
                if (this.monthlyBriefBuilder_ == null) {
                    result.monthlyBrief_ = this.monthlyBrief_;
                } else {
                    result.monthlyBrief_ = this.monthlyBriefBuilder_.build();
                }
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
                if (other instanceof TowerAllDataRsp) {
                    return mergeFrom((TowerAllDataRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TowerAllDataRsp other) {
                if (other == TowerAllDataRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300OHCHCJGJIDK() != 0) {
                    setUnk3300OHCHCJGJIDK(other.getUnk3300OHCHCJGJIDK());
                }
                if (other.hasCurLevelRecord()) {
                    mergeCurLevelRecord(other.getCurLevelRecord());
                }
                if (other.getIsFirstInteract()) {
                    setIsFirstInteract(other.getIsFirstInteract());
                }
                if (this.towerFloorRecordListBuilder_ == null) {
                    if (!other.towerFloorRecordList_.isEmpty()) {
                        if (this.towerFloorRecordList_.isEmpty()) {
                            this.towerFloorRecordList_ = other.towerFloorRecordList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureTowerFloorRecordListIsMutable();
                            this.towerFloorRecordList_.addAll(other.towerFloorRecordList_);
                        }
                        onChanged();
                    }
                } else if (!other.towerFloorRecordList_.isEmpty()) {
                    if (this.towerFloorRecordListBuilder_.isEmpty()) {
                        this.towerFloorRecordListBuilder_.dispose();
                        this.towerFloorRecordListBuilder_ = null;
                        this.towerFloorRecordList_ = other.towerFloorRecordList_;
                        this.bitField0_ &= -2;
                        this.towerFloorRecordListBuilder_ = TowerAllDataRsp.alwaysUseFieldBuilders ? getTowerFloorRecordListFieldBuilder() : null;
                    } else {
                        this.towerFloorRecordListBuilder_.addAllMessages(other.towerFloorRecordList_);
                    }
                }
                if (other.getNextScheduleChangeTime() != 0) {
                    setNextScheduleChangeTime(other.getNextScheduleChangeTime());
                }
                if (other.getTowerScheduleId() != 0) {
                    setTowerScheduleId(other.getTowerScheduleId());
                }
                internalGetMutableFloorOpenTimeMap().mergeFrom(other.internalGetFloorOpenTimeMap());
                if (other.getValidTowerRecordNum() != 0) {
                    setValidTowerRecordNum(other.getValidTowerRecordNum());
                }
                internalGetMutableSkipFloorGrantedRewardItemMap().mergeFrom(other.internalGetSkipFloorGrantedRewardItemMap());
                if (other.getScheduleStartTime() != 0) {
                    setScheduleStartTime(other.getScheduleStartTime());
                }
                if (other.hasLastScheduleMonthlyBrief()) {
                    mergeLastScheduleMonthlyBrief(other.getLastScheduleMonthlyBrief());
                }
                if (other.getUnk3300LEKODCFPINJ() != 0) {
                    setUnk3300LEKODCFPINJ(other.getUnk3300LEKODCFPINJ());
                }
                if (other.getUnk3300HCDFJBHMHHF() != 0) {
                    setUnk3300HCDFJBHMHHF(other.getUnk3300HCDFJBHMHHF());
                }
                if (other.getUnk3300JBACKENDHDG() != 0) {
                    setUnk3300JBACKENDHDG(other.getUnk3300JBACKENDHDG());
                }
                if (other.getIsFinishedEntranceFloor()) {
                    setIsFinishedEntranceFloor(other.getIsFinishedEntranceFloor());
                }
                if (other.hasMonthlyBrief()) {
                    mergeMonthlyBrief(other.getMonthlyBrief());
                }
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
                TowerAllDataRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = TowerAllDataRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TowerAllDataRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public int getUnk3300OHCHCJGJIDK() {
                return this.unk3300OHCHCJGJIDK_;
            }

            public Builder setUnk3300OHCHCJGJIDK(int value) {
                this.unk3300OHCHCJGJIDK_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300OHCHCJGJIDK() {
                this.unk3300OHCHCJGJIDK_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public boolean hasCurLevelRecord() {
                return (this.curLevelRecordBuilder_ == null && this.curLevelRecord_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public TowerCurLevelRecordOuterClass.TowerCurLevelRecord getCurLevelRecord() {
                if (this.curLevelRecordBuilder_ == null) {
                    return this.curLevelRecord_ == null ? TowerCurLevelRecordOuterClass.TowerCurLevelRecord.getDefaultInstance() : this.curLevelRecord_;
                }
                return this.curLevelRecordBuilder_.getMessage();
            }

            public Builder setCurLevelRecord(TowerCurLevelRecordOuterClass.TowerCurLevelRecord value) {
                if (this.curLevelRecordBuilder_ != null) {
                    this.curLevelRecordBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.curLevelRecord_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setCurLevelRecord(TowerCurLevelRecordOuterClass.TowerCurLevelRecord.Builder builderForValue) {
                if (this.curLevelRecordBuilder_ == null) {
                    this.curLevelRecord_ = builderForValue.build();
                    onChanged();
                } else {
                    this.curLevelRecordBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeCurLevelRecord(TowerCurLevelRecordOuterClass.TowerCurLevelRecord value) {
                if (this.curLevelRecordBuilder_ == null) {
                    if (this.curLevelRecord_ != null) {
                        this.curLevelRecord_ = TowerCurLevelRecordOuterClass.TowerCurLevelRecord.newBuilder(this.curLevelRecord_).mergeFrom(value).buildPartial();
                    } else {
                        this.curLevelRecord_ = value;
                    }
                    onChanged();
                } else {
                    this.curLevelRecordBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearCurLevelRecord() {
                if (this.curLevelRecordBuilder_ == null) {
                    this.curLevelRecord_ = null;
                    onChanged();
                } else {
                    this.curLevelRecord_ = null;
                    this.curLevelRecordBuilder_ = null;
                }
                return this;
            }

            public TowerCurLevelRecordOuterClass.TowerCurLevelRecord.Builder getCurLevelRecordBuilder() {
                onChanged();
                return getCurLevelRecordFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder getCurLevelRecordOrBuilder() {
                if (this.curLevelRecordBuilder_ != null) {
                    return this.curLevelRecordBuilder_.getMessageOrBuilder();
                }
                return this.curLevelRecord_ == null ? TowerCurLevelRecordOuterClass.TowerCurLevelRecord.getDefaultInstance() : this.curLevelRecord_;
            }

            private SingleFieldBuilderV3<TowerCurLevelRecordOuterClass.TowerCurLevelRecord, TowerCurLevelRecordOuterClass.TowerCurLevelRecord.Builder, TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder> getCurLevelRecordFieldBuilder() {
                if (this.curLevelRecordBuilder_ == null) {
                    this.curLevelRecordBuilder_ = new SingleFieldBuilderV3<>(getCurLevelRecord(), getParentForChildren(), isClean());
                    this.curLevelRecord_ = null;
                }
                return this.curLevelRecordBuilder_;
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public boolean getIsFirstInteract() {
                return this.isFirstInteract_;
            }

            public Builder setIsFirstInteract(boolean value) {
                this.isFirstInteract_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFirstInteract() {
                this.isFirstInteract_ = false;
                onChanged();
                return this;
            }

            private void ensureTowerFloorRecordListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.towerFloorRecordList_ = new ArrayList(this.towerFloorRecordList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public List<TowerFloorRecordOuterClass.TowerFloorRecord> getTowerFloorRecordListList() {
                if (this.towerFloorRecordListBuilder_ == null) {
                    return Collections.unmodifiableList(this.towerFloorRecordList_);
                }
                return this.towerFloorRecordListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public int getTowerFloorRecordListCount() {
                if (this.towerFloorRecordListBuilder_ == null) {
                    return this.towerFloorRecordList_.size();
                }
                return this.towerFloorRecordListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public TowerFloorRecordOuterClass.TowerFloorRecord getTowerFloorRecordList(int index) {
                if (this.towerFloorRecordListBuilder_ == null) {
                    return this.towerFloorRecordList_.get(index);
                }
                return this.towerFloorRecordListBuilder_.getMessage(index);
            }

            public Builder setTowerFloorRecordList(int index, TowerFloorRecordOuterClass.TowerFloorRecord value) {
                if (this.towerFloorRecordListBuilder_ != null) {
                    this.towerFloorRecordListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTowerFloorRecordListIsMutable();
                    this.towerFloorRecordList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTowerFloorRecordList(int index, TowerFloorRecordOuterClass.TowerFloorRecord.Builder builderForValue) {
                if (this.towerFloorRecordListBuilder_ == null) {
                    ensureTowerFloorRecordListIsMutable();
                    this.towerFloorRecordList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.towerFloorRecordListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTowerFloorRecordList(TowerFloorRecordOuterClass.TowerFloorRecord value) {
                if (this.towerFloorRecordListBuilder_ != null) {
                    this.towerFloorRecordListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTowerFloorRecordListIsMutable();
                    this.towerFloorRecordList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTowerFloorRecordList(int index, TowerFloorRecordOuterClass.TowerFloorRecord value) {
                if (this.towerFloorRecordListBuilder_ != null) {
                    this.towerFloorRecordListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTowerFloorRecordListIsMutable();
                    this.towerFloorRecordList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTowerFloorRecordList(TowerFloorRecordOuterClass.TowerFloorRecord.Builder builderForValue) {
                if (this.towerFloorRecordListBuilder_ == null) {
                    ensureTowerFloorRecordListIsMutable();
                    this.towerFloorRecordList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.towerFloorRecordListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTowerFloorRecordList(int index, TowerFloorRecordOuterClass.TowerFloorRecord.Builder builderForValue) {
                if (this.towerFloorRecordListBuilder_ == null) {
                    ensureTowerFloorRecordListIsMutable();
                    this.towerFloorRecordList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.towerFloorRecordListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTowerFloorRecordList(Iterable<? extends TowerFloorRecordOuterClass.TowerFloorRecord> values) {
                if (this.towerFloorRecordListBuilder_ == null) {
                    ensureTowerFloorRecordListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.towerFloorRecordList_);
                    onChanged();
                } else {
                    this.towerFloorRecordListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTowerFloorRecordList() {
                if (this.towerFloorRecordListBuilder_ == null) {
                    this.towerFloorRecordList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.towerFloorRecordListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTowerFloorRecordList(int index) {
                if (this.towerFloorRecordListBuilder_ == null) {
                    ensureTowerFloorRecordListIsMutable();
                    this.towerFloorRecordList_.remove(index);
                    onChanged();
                } else {
                    this.towerFloorRecordListBuilder_.remove(index);
                }
                return this;
            }

            public TowerFloorRecordOuterClass.TowerFloorRecord.Builder getTowerFloorRecordListBuilder(int index) {
                return getTowerFloorRecordListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder getTowerFloorRecordListOrBuilder(int index) {
                if (this.towerFloorRecordListBuilder_ == null) {
                    return this.towerFloorRecordList_.get(index);
                }
                return this.towerFloorRecordListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public List<? extends TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder> getTowerFloorRecordListOrBuilderList() {
                if (this.towerFloorRecordListBuilder_ != null) {
                    return this.towerFloorRecordListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.towerFloorRecordList_);
            }

            public TowerFloorRecordOuterClass.TowerFloorRecord.Builder addTowerFloorRecordListBuilder() {
                return getTowerFloorRecordListFieldBuilder().addBuilder(TowerFloorRecordOuterClass.TowerFloorRecord.getDefaultInstance());
            }

            public TowerFloorRecordOuterClass.TowerFloorRecord.Builder addTowerFloorRecordListBuilder(int index) {
                return getTowerFloorRecordListFieldBuilder().addBuilder(index, TowerFloorRecordOuterClass.TowerFloorRecord.getDefaultInstance());
            }

            public List<TowerFloorRecordOuterClass.TowerFloorRecord.Builder> getTowerFloorRecordListBuilderList() {
                return getTowerFloorRecordListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<TowerFloorRecordOuterClass.TowerFloorRecord, TowerFloorRecordOuterClass.TowerFloorRecord.Builder, TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder> getTowerFloorRecordListFieldBuilder() {
                if (this.towerFloorRecordListBuilder_ == null) {
                    this.towerFloorRecordListBuilder_ = new RepeatedFieldBuilderV3<>(this.towerFloorRecordList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.towerFloorRecordList_ = null;
                }
                return this.towerFloorRecordListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public int getNextScheduleChangeTime() {
                return this.nextScheduleChangeTime_;
            }

            public Builder setNextScheduleChangeTime(int value) {
                this.nextScheduleChangeTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearNextScheduleChangeTime() {
                this.nextScheduleChangeTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public int getTowerScheduleId() {
                return this.towerScheduleId_;
            }

            public Builder setTowerScheduleId(int value) {
                this.towerScheduleId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTowerScheduleId() {
                this.towerScheduleId_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetFloorOpenTimeMap() {
                if (this.floorOpenTimeMap_ == null) {
                    return MapField.emptyMapField(FloorOpenTimeMapDefaultEntryHolder.defaultEntry);
                }
                return this.floorOpenTimeMap_;
            }

            private MapField<Integer, Integer> internalGetMutableFloorOpenTimeMap() {
                onChanged();
                if (this.floorOpenTimeMap_ == null) {
                    this.floorOpenTimeMap_ = MapField.newMapField(FloorOpenTimeMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.floorOpenTimeMap_.isMutable()) {
                    this.floorOpenTimeMap_ = this.floorOpenTimeMap_.copy();
                }
                return this.floorOpenTimeMap_;
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public int getFloorOpenTimeMapCount() {
                return internalGetFloorOpenTimeMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public boolean containsFloorOpenTimeMap(int key) {
                return internalGetFloorOpenTimeMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            @Deprecated
            public Map<Integer, Integer> getFloorOpenTimeMap() {
                return getFloorOpenTimeMapMap();
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public Map<Integer, Integer> getFloorOpenTimeMapMap() {
                return internalGetFloorOpenTimeMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public int getFloorOpenTimeMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetFloorOpenTimeMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public int getFloorOpenTimeMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetFloorOpenTimeMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearFloorOpenTimeMap() {
                internalGetMutableFloorOpenTimeMap().getMutableMap().clear();
                return this;
            }

            public Builder removeFloorOpenTimeMap(int key) {
                internalGetMutableFloorOpenTimeMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableFloorOpenTimeMap() {
                return internalGetMutableFloorOpenTimeMap().getMutableMap();
            }

            public Builder putFloorOpenTimeMap(int key, int value) {
                internalGetMutableFloorOpenTimeMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllFloorOpenTimeMap(Map<Integer, Integer> values) {
                internalGetMutableFloorOpenTimeMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public int getValidTowerRecordNum() {
                return this.validTowerRecordNum_;
            }

            public Builder setValidTowerRecordNum(int value) {
                this.validTowerRecordNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearValidTowerRecordNum() {
                this.validTowerRecordNum_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetSkipFloorGrantedRewardItemMap() {
                if (this.skipFloorGrantedRewardItemMap_ == null) {
                    return MapField.emptyMapField(SkipFloorGrantedRewardItemMapDefaultEntryHolder.defaultEntry);
                }
                return this.skipFloorGrantedRewardItemMap_;
            }

            private MapField<Integer, Integer> internalGetMutableSkipFloorGrantedRewardItemMap() {
                onChanged();
                if (this.skipFloorGrantedRewardItemMap_ == null) {
                    this.skipFloorGrantedRewardItemMap_ = MapField.newMapField(SkipFloorGrantedRewardItemMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.skipFloorGrantedRewardItemMap_.isMutable()) {
                    this.skipFloorGrantedRewardItemMap_ = this.skipFloorGrantedRewardItemMap_.copy();
                }
                return this.skipFloorGrantedRewardItemMap_;
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public int getSkipFloorGrantedRewardItemMapCount() {
                return internalGetSkipFloorGrantedRewardItemMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public boolean containsSkipFloorGrantedRewardItemMap(int key) {
                return internalGetSkipFloorGrantedRewardItemMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            @Deprecated
            public Map<Integer, Integer> getSkipFloorGrantedRewardItemMap() {
                return getSkipFloorGrantedRewardItemMapMap();
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public Map<Integer, Integer> getSkipFloorGrantedRewardItemMapMap() {
                return internalGetSkipFloorGrantedRewardItemMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public int getSkipFloorGrantedRewardItemMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetSkipFloorGrantedRewardItemMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public int getSkipFloorGrantedRewardItemMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetSkipFloorGrantedRewardItemMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearSkipFloorGrantedRewardItemMap() {
                internalGetMutableSkipFloorGrantedRewardItemMap().getMutableMap().clear();
                return this;
            }

            public Builder removeSkipFloorGrantedRewardItemMap(int key) {
                internalGetMutableSkipFloorGrantedRewardItemMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableSkipFloorGrantedRewardItemMap() {
                return internalGetMutableSkipFloorGrantedRewardItemMap().getMutableMap();
            }

            public Builder putSkipFloorGrantedRewardItemMap(int key, int value) {
                internalGetMutableSkipFloorGrantedRewardItemMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllSkipFloorGrantedRewardItemMap(Map<Integer, Integer> values) {
                internalGetMutableSkipFloorGrantedRewardItemMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public int getScheduleStartTime() {
                return this.scheduleStartTime_;
            }

            public Builder setScheduleStartTime(int value) {
                this.scheduleStartTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearScheduleStartTime() {
                this.scheduleStartTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public boolean hasLastScheduleMonthlyBrief() {
                return (this.lastScheduleMonthlyBriefBuilder_ == null && this.lastScheduleMonthlyBrief_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public TowerMonthlyBriefOuterClass.TowerMonthlyBrief getLastScheduleMonthlyBrief() {
                if (this.lastScheduleMonthlyBriefBuilder_ == null) {
                    return this.lastScheduleMonthlyBrief_ == null ? TowerMonthlyBriefOuterClass.TowerMonthlyBrief.getDefaultInstance() : this.lastScheduleMonthlyBrief_;
                }
                return this.lastScheduleMonthlyBriefBuilder_.getMessage();
            }

            public Builder setLastScheduleMonthlyBrief(TowerMonthlyBriefOuterClass.TowerMonthlyBrief value) {
                if (this.lastScheduleMonthlyBriefBuilder_ != null) {
                    this.lastScheduleMonthlyBriefBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.lastScheduleMonthlyBrief_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setLastScheduleMonthlyBrief(TowerMonthlyBriefOuterClass.TowerMonthlyBrief.Builder builderForValue) {
                if (this.lastScheduleMonthlyBriefBuilder_ == null) {
                    this.lastScheduleMonthlyBrief_ = builderForValue.build();
                    onChanged();
                } else {
                    this.lastScheduleMonthlyBriefBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeLastScheduleMonthlyBrief(TowerMonthlyBriefOuterClass.TowerMonthlyBrief value) {
                if (this.lastScheduleMonthlyBriefBuilder_ == null) {
                    if (this.lastScheduleMonthlyBrief_ != null) {
                        this.lastScheduleMonthlyBrief_ = TowerMonthlyBriefOuterClass.TowerMonthlyBrief.newBuilder(this.lastScheduleMonthlyBrief_).mergeFrom(value).buildPartial();
                    } else {
                        this.lastScheduleMonthlyBrief_ = value;
                    }
                    onChanged();
                } else {
                    this.lastScheduleMonthlyBriefBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearLastScheduleMonthlyBrief() {
                if (this.lastScheduleMonthlyBriefBuilder_ == null) {
                    this.lastScheduleMonthlyBrief_ = null;
                    onChanged();
                } else {
                    this.lastScheduleMonthlyBrief_ = null;
                    this.lastScheduleMonthlyBriefBuilder_ = null;
                }
                return this;
            }

            public TowerMonthlyBriefOuterClass.TowerMonthlyBrief.Builder getLastScheduleMonthlyBriefBuilder() {
                onChanged();
                return getLastScheduleMonthlyBriefFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public TowerMonthlyBriefOuterClass.TowerMonthlyBriefOrBuilder getLastScheduleMonthlyBriefOrBuilder() {
                if (this.lastScheduleMonthlyBriefBuilder_ != null) {
                    return this.lastScheduleMonthlyBriefBuilder_.getMessageOrBuilder();
                }
                return this.lastScheduleMonthlyBrief_ == null ? TowerMonthlyBriefOuterClass.TowerMonthlyBrief.getDefaultInstance() : this.lastScheduleMonthlyBrief_;
            }

            private SingleFieldBuilderV3<TowerMonthlyBriefOuterClass.TowerMonthlyBrief, TowerMonthlyBriefOuterClass.TowerMonthlyBrief.Builder, TowerMonthlyBriefOuterClass.TowerMonthlyBriefOrBuilder> getLastScheduleMonthlyBriefFieldBuilder() {
                if (this.lastScheduleMonthlyBriefBuilder_ == null) {
                    this.lastScheduleMonthlyBriefBuilder_ = new SingleFieldBuilderV3<>(getLastScheduleMonthlyBrief(), getParentForChildren(), isClean());
                    this.lastScheduleMonthlyBrief_ = null;
                }
                return this.lastScheduleMonthlyBriefBuilder_;
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public int getUnk3300LEKODCFPINJ() {
                return this.unk3300LEKODCFPINJ_;
            }

            public Builder setUnk3300LEKODCFPINJ(int value) {
                this.unk3300LEKODCFPINJ_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300LEKODCFPINJ() {
                this.unk3300LEKODCFPINJ_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public int getUnk3300HCDFJBHMHHF() {
                return this.unk3300HCDFJBHMHHF_;
            }

            public Builder setUnk3300HCDFJBHMHHF(int value) {
                this.unk3300HCDFJBHMHHF_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300HCDFJBHMHHF() {
                this.unk3300HCDFJBHMHHF_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public int getUnk3300JBACKENDHDG() {
                return this.unk3300JBACKENDHDG_;
            }

            public Builder setUnk3300JBACKENDHDG(int value) {
                this.unk3300JBACKENDHDG_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300JBACKENDHDG() {
                this.unk3300JBACKENDHDG_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public boolean getIsFinishedEntranceFloor() {
                return this.isFinishedEntranceFloor_;
            }

            public Builder setIsFinishedEntranceFloor(boolean value) {
                this.isFinishedEntranceFloor_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFinishedEntranceFloor() {
                this.isFinishedEntranceFloor_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public boolean hasMonthlyBrief() {
                return (this.monthlyBriefBuilder_ == null && this.monthlyBrief_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public TowerMonthlyBriefOuterClass.TowerMonthlyBrief getMonthlyBrief() {
                if (this.monthlyBriefBuilder_ == null) {
                    return this.monthlyBrief_ == null ? TowerMonthlyBriefOuterClass.TowerMonthlyBrief.getDefaultInstance() : this.monthlyBrief_;
                }
                return this.monthlyBriefBuilder_.getMessage();
            }

            public Builder setMonthlyBrief(TowerMonthlyBriefOuterClass.TowerMonthlyBrief value) {
                if (this.monthlyBriefBuilder_ != null) {
                    this.monthlyBriefBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.monthlyBrief_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setMonthlyBrief(TowerMonthlyBriefOuterClass.TowerMonthlyBrief.Builder builderForValue) {
                if (this.monthlyBriefBuilder_ == null) {
                    this.monthlyBrief_ = builderForValue.build();
                    onChanged();
                } else {
                    this.monthlyBriefBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeMonthlyBrief(TowerMonthlyBriefOuterClass.TowerMonthlyBrief value) {
                if (this.monthlyBriefBuilder_ == null) {
                    if (this.monthlyBrief_ != null) {
                        this.monthlyBrief_ = TowerMonthlyBriefOuterClass.TowerMonthlyBrief.newBuilder(this.monthlyBrief_).mergeFrom(value).buildPartial();
                    } else {
                        this.monthlyBrief_ = value;
                    }
                    onChanged();
                } else {
                    this.monthlyBriefBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearMonthlyBrief() {
                if (this.monthlyBriefBuilder_ == null) {
                    this.monthlyBrief_ = null;
                    onChanged();
                } else {
                    this.monthlyBrief_ = null;
                    this.monthlyBriefBuilder_ = null;
                }
                return this;
            }

            public TowerMonthlyBriefOuterClass.TowerMonthlyBrief.Builder getMonthlyBriefBuilder() {
                onChanged();
                return getMonthlyBriefFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
            public TowerMonthlyBriefOuterClass.TowerMonthlyBriefOrBuilder getMonthlyBriefOrBuilder() {
                if (this.monthlyBriefBuilder_ != null) {
                    return this.monthlyBriefBuilder_.getMessageOrBuilder();
                }
                return this.monthlyBrief_ == null ? TowerMonthlyBriefOuterClass.TowerMonthlyBrief.getDefaultInstance() : this.monthlyBrief_;
            }

            private SingleFieldBuilderV3<TowerMonthlyBriefOuterClass.TowerMonthlyBrief, TowerMonthlyBriefOuterClass.TowerMonthlyBrief.Builder, TowerMonthlyBriefOuterClass.TowerMonthlyBriefOrBuilder> getMonthlyBriefFieldBuilder() {
                if (this.monthlyBriefBuilder_ == null) {
                    this.monthlyBriefBuilder_ = new SingleFieldBuilderV3<>(getMonthlyBrief(), getParentForChildren(), isClean());
                    this.monthlyBrief_ = null;
                }
                return this.monthlyBriefBuilder_;
            }

            @Override // emu.grasscutter.net.proto.TowerAllDataRspOuterClass.TowerAllDataRspOrBuilder
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

        public static TowerAllDataRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TowerAllDataRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TowerAllDataRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TowerAllDataRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        TowerCurLevelRecordOuterClass.getDescriptor();
        TowerMonthlyBriefOuterClass.getDescriptor();
        TowerFloorRecordOuterClass.getDescriptor();
    }
}
