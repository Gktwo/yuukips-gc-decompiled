package emu.grasscutter.net.proto;

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
import emu.grasscutter.net.proto.RoguelikeSettleCoinInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeDungeonSettleInfoOuterClass.class */
public final class RoguelikeDungeonSettleInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n RoguelikeDungeonSettleInfo.proto\u001a\u001dRoguelikeSettleCoinInfo.proto\"ú\u0002\n\u001aRoguelikeDungeonSettleInfo\u0012\u0010\n\bstage_id\u0018\t \u0001(\r\u0012\u001b\n\u0013Unk3300_GMMECMPDJMI\u0018\b \u0001(\r\u0012\u001b\n\u0013Unk3300_PBELMOJKKHP\u0018\u0004 \u0001(\r\u0012\u0011\n\tcur_level\u0018\u000e \u0001(\r\u0012\u001b\n\u0013Unk3300_AHIEENGKPFA\u0018\n \u0001(\b\u0012\u001b\n\u0013Unk3300_BPLKJMIOKHM\u0018\u000f \u0001(\b\u0012e\n\u001ffinished_challenge_cell_num_map\u0018\u0006 \u0003(\u000b2<.RoguelikeDungeonSettleInfo.FinishedChallengeCellNumMapEntry\u001a\\\n FinishedChallengeCellNumMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012'\n\u0005value\u0018\u0002 \u0001(\u000b2\u0018.RoguelikeSettleCoinInfo:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{RoguelikeSettleCoinInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_RoguelikeDungeonSettleInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_RoguelikeDungeonSettleInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_RoguelikeDungeonSettleInfo_descriptor, new String[]{"StageId", "Unk3300GMMECMPDJMI", "Unk3300PBELMOJKKHP", "CurLevel", "Unk3300AHIEENGKPFA", "Unk3300BPLKJMIOKHM", "FinishedChallengeCellNumMap"});

    /* renamed from: internal_static_RoguelikeDungeonSettleInfo_FinishedChallengeCellNumMapEntry_descriptor */
    private static final Descriptors.Descriptor f848xd4dbd17 = internal_static_RoguelikeDungeonSettleInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_RoguelikeDungeonSettleInfo_FinishedChallengeCellNumMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f849x6bd5dc95 = new GeneratedMessageV3.FieldAccessorTable(f848xd4dbd17, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeDungeonSettleInfoOuterClass$RoguelikeDungeonSettleInfoOrBuilder.class */
    public interface RoguelikeDungeonSettleInfoOrBuilder extends MessageOrBuilder {
        int getStageId();

        int getUnk3300GMMECMPDJMI();

        int getUnk3300PBELMOJKKHP();

        int getCurLevel();

        boolean getUnk3300AHIEENGKPFA();

        boolean getUnk3300BPLKJMIOKHM();

        int getFinishedChallengeCellNumMapCount();

        boolean containsFinishedChallengeCellNumMap(int i);

        @Deprecated
        Map<Integer, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo> getFinishedChallengeCellNumMap();

        Map<Integer, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo> getFinishedChallengeCellNumMapMap();

        RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo getFinishedChallengeCellNumMapOrDefault(int i, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo roguelikeSettleCoinInfo);

        RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo getFinishedChallengeCellNumMapOrThrow(int i);
    }

    private RoguelikeDungeonSettleInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeDungeonSettleInfoOuterClass$RoguelikeDungeonSettleInfo.class */
    public static final class RoguelikeDungeonSettleInfo extends GeneratedMessageV3 implements RoguelikeDungeonSettleInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STAGE_ID_FIELD_NUMBER = 9;
        private int stageId_;
        public static final int UNK3300_GMMECMPDJMI_FIELD_NUMBER = 8;
        private int unk3300GMMECMPDJMI_;
        public static final int UNK3300_PBELMOJKKHP_FIELD_NUMBER = 4;
        private int unk3300PBELMOJKKHP_;
        public static final int CUR_LEVEL_FIELD_NUMBER = 14;
        private int curLevel_;
        public static final int UNK3300_AHIEENGKPFA_FIELD_NUMBER = 10;
        private boolean unk3300AHIEENGKPFA_;
        public static final int UNK3300_BPLKJMIOKHM_FIELD_NUMBER = 15;
        private boolean unk3300BPLKJMIOKHM_;
        public static final int FINISHED_CHALLENGE_CELL_NUM_MAP_FIELD_NUMBER = 6;
        private MapField<Integer, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo> finishedChallengeCellNumMap_;
        private byte memoizedIsInitialized;
        private static final RoguelikeDungeonSettleInfo DEFAULT_INSTANCE = new RoguelikeDungeonSettleInfo();
        private static final Parser<RoguelikeDungeonSettleInfo> PARSER = new AbstractParser<RoguelikeDungeonSettleInfo>() { // from class: emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo.1
            @Override // com.google.protobuf.Parser
            public RoguelikeDungeonSettleInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RoguelikeDungeonSettleInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                com.google.protobuf.MapField r0 = r0.internalGetFinishedChallengeCellNumMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private RoguelikeDungeonSettleInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private RoguelikeDungeonSettleInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new RoguelikeDungeonSettleInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RoguelikeDungeonSettleInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.unk3300PBELMOJKKHP_ = input.readUInt32();
                                break;
                            case 50:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.finishedChallengeCellNumMap_ = MapField.newMapField(FinishedChallengeCellNumMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo> finishedChallengeCellNumMap__ = (MapEntry) input.readMessage(FinishedChallengeCellNumMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.finishedChallengeCellNumMap_.getMutableMap().put(finishedChallengeCellNumMap__.getKey(), finishedChallengeCellNumMap__.getValue());
                                break;
                            case 64:
                                this.unk3300GMMECMPDJMI_ = input.readUInt32();
                                break;
                            case 72:
                                this.stageId_ = input.readUInt32();
                                break;
                            case 80:
                                this.unk3300AHIEENGKPFA_ = input.readBool();
                                break;
                            case 112:
                                this.curLevel_ = input.readUInt32();
                                break;
                            case 120:
                                this.unk3300BPLKJMIOKHM_ = input.readBool();
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
            return RoguelikeDungeonSettleInfoOuterClass.internal_static_RoguelikeDungeonSettleInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RoguelikeDungeonSettleInfoOuterClass.internal_static_RoguelikeDungeonSettleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RoguelikeDungeonSettleInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
        public int getUnk3300GMMECMPDJMI() {
            return this.unk3300GMMECMPDJMI_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
        public int getUnk3300PBELMOJKKHP() {
            return this.unk3300PBELMOJKKHP_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
        public int getCurLevel() {
            return this.curLevel_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
        public boolean getUnk3300AHIEENGKPFA() {
            return this.unk3300AHIEENGKPFA_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
        public boolean getUnk3300BPLKJMIOKHM() {
            return this.unk3300BPLKJMIOKHM_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeDungeonSettleInfoOuterClass$RoguelikeDungeonSettleInfo$FinishedChallengeCellNumMapDefaultEntryHolder.class */
        public static final class FinishedChallengeCellNumMapDefaultEntryHolder {
            static final MapEntry<Integer, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo> defaultEntry = MapEntry.newDefaultInstance(RoguelikeDungeonSettleInfoOuterClass.f848xd4dbd17, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo.getDefaultInstance());

            private FinishedChallengeCellNumMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo> internalGetFinishedChallengeCellNumMap() {
            if (this.finishedChallengeCellNumMap_ == null) {
                return MapField.emptyMapField(FinishedChallengeCellNumMapDefaultEntryHolder.defaultEntry);
            }
            return this.finishedChallengeCellNumMap_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
        public int getFinishedChallengeCellNumMapCount() {
            return internalGetFinishedChallengeCellNumMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
        public boolean containsFinishedChallengeCellNumMap(int key) {
            return internalGetFinishedChallengeCellNumMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
        @Deprecated
        public Map<Integer, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo> getFinishedChallengeCellNumMap() {
            return getFinishedChallengeCellNumMapMap();
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
        public Map<Integer, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo> getFinishedChallengeCellNumMapMap() {
            return internalGetFinishedChallengeCellNumMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
        public RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo getFinishedChallengeCellNumMapOrDefault(int key, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo defaultValue) {
            Map<Integer, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo> map = internalGetFinishedChallengeCellNumMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
        public RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo getFinishedChallengeCellNumMapOrThrow(int key) {
            Map<Integer, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo> map = internalGetFinishedChallengeCellNumMap().getMap();
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
            if (this.unk3300PBELMOJKKHP_ != 0) {
                output.writeUInt32(4, this.unk3300PBELMOJKKHP_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetFinishedChallengeCellNumMap(), FinishedChallengeCellNumMapDefaultEntryHolder.defaultEntry, 6);
            if (this.unk3300GMMECMPDJMI_ != 0) {
                output.writeUInt32(8, this.unk3300GMMECMPDJMI_);
            }
            if (this.stageId_ != 0) {
                output.writeUInt32(9, this.stageId_);
            }
            if (this.unk3300AHIEENGKPFA_) {
                output.writeBool(10, this.unk3300AHIEENGKPFA_);
            }
            if (this.curLevel_ != 0) {
                output.writeUInt32(14, this.curLevel_);
            }
            if (this.unk3300BPLKJMIOKHM_) {
                output.writeBool(15, this.unk3300BPLKJMIOKHM_);
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
            if (this.unk3300PBELMOJKKHP_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.unk3300PBELMOJKKHP_);
            }
            for (Map.Entry<Integer, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo> entry : internalGetFinishedChallengeCellNumMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(6, FinishedChallengeCellNumMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.unk3300GMMECMPDJMI_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.unk3300GMMECMPDJMI_);
            }
            if (this.stageId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.stageId_);
            }
            if (this.unk3300AHIEENGKPFA_) {
                size2 += CodedOutputStream.computeBoolSize(10, this.unk3300AHIEENGKPFA_);
            }
            if (this.curLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.curLevel_);
            }
            if (this.unk3300BPLKJMIOKHM_) {
                size2 += CodedOutputStream.computeBoolSize(15, this.unk3300BPLKJMIOKHM_);
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
            if (!(obj instanceof RoguelikeDungeonSettleInfo)) {
                return equals(obj);
            }
            RoguelikeDungeonSettleInfo other = (RoguelikeDungeonSettleInfo) obj;
            return getStageId() == other.getStageId() && getUnk3300GMMECMPDJMI() == other.getUnk3300GMMECMPDJMI() && getUnk3300PBELMOJKKHP() == other.getUnk3300PBELMOJKKHP() && getCurLevel() == other.getCurLevel() && getUnk3300AHIEENGKPFA() == other.getUnk3300AHIEENGKPFA() && getUnk3300BPLKJMIOKHM() == other.getUnk3300BPLKJMIOKHM() && internalGetFinishedChallengeCellNumMap().equals(other.internalGetFinishedChallengeCellNumMap()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getStageId())) + 8)) + getUnk3300GMMECMPDJMI())) + 4)) + getUnk3300PBELMOJKKHP())) + 14)) + getCurLevel())) + 10)) + Internal.hashBoolean(getUnk3300AHIEENGKPFA()))) + 15)) + Internal.hashBoolean(getUnk3300BPLKJMIOKHM());
            if (!internalGetFinishedChallengeCellNumMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 6)) + internalGetFinishedChallengeCellNumMap().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static RoguelikeDungeonSettleInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoguelikeDungeonSettleInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoguelikeDungeonSettleInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoguelikeDungeonSettleInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoguelikeDungeonSettleInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoguelikeDungeonSettleInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoguelikeDungeonSettleInfo parseFrom(InputStream input) throws IOException {
            return (RoguelikeDungeonSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RoguelikeDungeonSettleInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoguelikeDungeonSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RoguelikeDungeonSettleInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (RoguelikeDungeonSettleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static RoguelikeDungeonSettleInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoguelikeDungeonSettleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RoguelikeDungeonSettleInfo parseFrom(CodedInputStream input) throws IOException {
            return (RoguelikeDungeonSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RoguelikeDungeonSettleInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoguelikeDungeonSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RoguelikeDungeonSettleInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeDungeonSettleInfoOuterClass$RoguelikeDungeonSettleInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RoguelikeDungeonSettleInfoOrBuilder {
            private int bitField0_;
            private int stageId_;
            private int unk3300GMMECMPDJMI_;
            private int unk3300PBELMOJKKHP_;
            private int curLevel_;
            private boolean unk3300AHIEENGKPFA_;
            private boolean unk3300BPLKJMIOKHM_;
            private MapField<Integer, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo> finishedChallengeCellNumMap_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetFinishedChallengeCellNumMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetMutableFinishedChallengeCellNumMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return RoguelikeDungeonSettleInfoOuterClass.internal_static_RoguelikeDungeonSettleInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RoguelikeDungeonSettleInfoOuterClass.internal_static_RoguelikeDungeonSettleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RoguelikeDungeonSettleInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RoguelikeDungeonSettleInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.stageId_ = 0;
                this.unk3300GMMECMPDJMI_ = 0;
                this.unk3300PBELMOJKKHP_ = 0;
                this.curLevel_ = 0;
                this.unk3300AHIEENGKPFA_ = false;
                this.unk3300BPLKJMIOKHM_ = false;
                internalGetMutableFinishedChallengeCellNumMap().clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RoguelikeDungeonSettleInfoOuterClass.internal_static_RoguelikeDungeonSettleInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RoguelikeDungeonSettleInfo getDefaultInstanceForType() {
                return RoguelikeDungeonSettleInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RoguelikeDungeonSettleInfo build() {
                RoguelikeDungeonSettleInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RoguelikeDungeonSettleInfo buildPartial() {
                RoguelikeDungeonSettleInfo result = new RoguelikeDungeonSettleInfo(this);
                int i = this.bitField0_;
                result.stageId_ = this.stageId_;
                result.unk3300GMMECMPDJMI_ = this.unk3300GMMECMPDJMI_;
                result.unk3300PBELMOJKKHP_ = this.unk3300PBELMOJKKHP_;
                result.curLevel_ = this.curLevel_;
                result.unk3300AHIEENGKPFA_ = this.unk3300AHIEENGKPFA_;
                result.unk3300BPLKJMIOKHM_ = this.unk3300BPLKJMIOKHM_;
                result.finishedChallengeCellNumMap_ = internalGetFinishedChallengeCellNumMap();
                result.finishedChallengeCellNumMap_.makeImmutable();
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
                if (other instanceof RoguelikeDungeonSettleInfo) {
                    return mergeFrom((RoguelikeDungeonSettleInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RoguelikeDungeonSettleInfo other) {
                if (other == RoguelikeDungeonSettleInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (other.getUnk3300GMMECMPDJMI() != 0) {
                    setUnk3300GMMECMPDJMI(other.getUnk3300GMMECMPDJMI());
                }
                if (other.getUnk3300PBELMOJKKHP() != 0) {
                    setUnk3300PBELMOJKKHP(other.getUnk3300PBELMOJKKHP());
                }
                if (other.getCurLevel() != 0) {
                    setCurLevel(other.getCurLevel());
                }
                if (other.getUnk3300AHIEENGKPFA()) {
                    setUnk3300AHIEENGKPFA(other.getUnk3300AHIEENGKPFA());
                }
                if (other.getUnk3300BPLKJMIOKHM()) {
                    setUnk3300BPLKJMIOKHM(other.getUnk3300BPLKJMIOKHM());
                }
                internalGetMutableFinishedChallengeCellNumMap().mergeFrom(other.internalGetFinishedChallengeCellNumMap());
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
                RoguelikeDungeonSettleInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = RoguelikeDungeonSettleInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (RoguelikeDungeonSettleInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
            public int getStageId() {
                return this.stageId_;
            }

            public Builder setStageId(int value) {
                this.stageId_ = value;
                onChanged();
                return this;
            }

            public Builder clearStageId() {
                this.stageId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
            public int getUnk3300GMMECMPDJMI() {
                return this.unk3300GMMECMPDJMI_;
            }

            public Builder setUnk3300GMMECMPDJMI(int value) {
                this.unk3300GMMECMPDJMI_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300GMMECMPDJMI() {
                this.unk3300GMMECMPDJMI_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
            public int getUnk3300PBELMOJKKHP() {
                return this.unk3300PBELMOJKKHP_;
            }

            public Builder setUnk3300PBELMOJKKHP(int value) {
                this.unk3300PBELMOJKKHP_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300PBELMOJKKHP() {
                this.unk3300PBELMOJKKHP_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
            public int getCurLevel() {
                return this.curLevel_;
            }

            public Builder setCurLevel(int value) {
                this.curLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurLevel() {
                this.curLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
            public boolean getUnk3300AHIEENGKPFA() {
                return this.unk3300AHIEENGKPFA_;
            }

            public Builder setUnk3300AHIEENGKPFA(boolean value) {
                this.unk3300AHIEENGKPFA_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300AHIEENGKPFA() {
                this.unk3300AHIEENGKPFA_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
            public boolean getUnk3300BPLKJMIOKHM() {
                return this.unk3300BPLKJMIOKHM_;
            }

            public Builder setUnk3300BPLKJMIOKHM(boolean value) {
                this.unk3300BPLKJMIOKHM_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300BPLKJMIOKHM() {
                this.unk3300BPLKJMIOKHM_ = false;
                onChanged();
                return this;
            }

            private MapField<Integer, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo> internalGetFinishedChallengeCellNumMap() {
                if (this.finishedChallengeCellNumMap_ == null) {
                    return MapField.emptyMapField(FinishedChallengeCellNumMapDefaultEntryHolder.defaultEntry);
                }
                return this.finishedChallengeCellNumMap_;
            }

            private MapField<Integer, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo> internalGetMutableFinishedChallengeCellNumMap() {
                onChanged();
                if (this.finishedChallengeCellNumMap_ == null) {
                    this.finishedChallengeCellNumMap_ = MapField.newMapField(FinishedChallengeCellNumMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.finishedChallengeCellNumMap_.isMutable()) {
                    this.finishedChallengeCellNumMap_ = this.finishedChallengeCellNumMap_.copy();
                }
                return this.finishedChallengeCellNumMap_;
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
            public int getFinishedChallengeCellNumMapCount() {
                return internalGetFinishedChallengeCellNumMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
            public boolean containsFinishedChallengeCellNumMap(int key) {
                return internalGetFinishedChallengeCellNumMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
            @Deprecated
            public Map<Integer, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo> getFinishedChallengeCellNumMap() {
                return getFinishedChallengeCellNumMapMap();
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
            public Map<Integer, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo> getFinishedChallengeCellNumMapMap() {
                return internalGetFinishedChallengeCellNumMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
            public RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo getFinishedChallengeCellNumMapOrDefault(int key, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo defaultValue) {
                Map<Integer, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo> map = internalGetFinishedChallengeCellNumMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonSettleInfoOuterClass.RoguelikeDungeonSettleInfoOrBuilder
            public RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo getFinishedChallengeCellNumMapOrThrow(int key) {
                Map<Integer, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo> map = internalGetFinishedChallengeCellNumMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearFinishedChallengeCellNumMap() {
                internalGetMutableFinishedChallengeCellNumMap().getMutableMap().clear();
                return this;
            }

            public Builder removeFinishedChallengeCellNumMap(int key) {
                internalGetMutableFinishedChallengeCellNumMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo> getMutableFinishedChallengeCellNumMap() {
                return internalGetMutableFinishedChallengeCellNumMap().getMutableMap();
            }

            public Builder putFinishedChallengeCellNumMap(int key, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableFinishedChallengeCellNumMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllFinishedChallengeCellNumMap(Map<Integer, RoguelikeSettleCoinInfoOuterClass.RoguelikeSettleCoinInfo> values) {
                internalGetMutableFinishedChallengeCellNumMap().getMutableMap().putAll(values);
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

        public static RoguelikeDungeonSettleInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RoguelikeDungeonSettleInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RoguelikeDungeonSettleInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RoguelikeDungeonSettleInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        RoguelikeSettleCoinInfoOuterClass.getDescriptor();
    }
}
