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
import emu.grasscutter.net.proto.ChildQuestOuterClass;
import emu.grasscutter.net.proto.InferencePageInfoOuterClass;
import emu.grasscutter.net.proto.ParentQuestRandomInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ParentQuestOuterClass.class */
public final class ParentQuestOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011ParentQuest.proto\u001a\u0010ChildQuest.proto\u001a\u0017InferencePageInfo.proto\u001a\u001bParentQuestRandomInfo.proto\"\u0003\n\u000bParentQuest\u0012/\n\u0013inference_page_list\u0018\u0005 \u0003(\u000b2\u0012.InferencePageInfo\u0012\u0011\n\tquest_var\u0018\u0007 \u0003(\u0005\u0012\u0011\n\tvideo_key\u0018\u000b \u0001(\u0004\u0012\u001a\n\u0012parent_quest_state\u0018\u000f \u0001(\r\u0012+\n\u000brandom_info\u0018\t \u0001(\u000b2\u0016.ParentQuestRandomInfo\u0012\u0017\n\u000fparent_quest_id\u0018\u0003 \u0001(\r\u0012\u0011\n\tis_random\u0018\f \u0001(\b\u0012%\n\u0010child_quest_list\u0018\b \u0003(\u000b2\u000b.ChildQuest\u0012\u0013\n\u000bis_finished\u0018\u0001 \u0001(\b\u00122\n\ftime_var_map\u0018\u0002 \u0003(\u000b2\u001c.ParentQuest.TimeVarMapEntry\u0012\u0015\n\rquest_var_seq\u0018\u000e \u0001(\r\u001a1\n\u000fTimeVarMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ChildQuestOuterClass.getDescriptor(), InferencePageInfoOuterClass.getDescriptor(), ParentQuestRandomInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ParentQuest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ParentQuest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ParentQuest_descriptor, new String[]{"InferencePageList", "QuestVar", "VideoKey", "ParentQuestState", "RandomInfo", "ParentQuestId", "IsRandom", "ChildQuestList", "IsFinished", "TimeVarMap", "QuestVarSeq"});
    private static final Descriptors.Descriptor internal_static_ParentQuest_TimeVarMapEntry_descriptor = internal_static_ParentQuest_descriptor.getNestedTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ParentQuest_TimeVarMapEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ParentQuest_TimeVarMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ParentQuestOuterClass$ParentQuestOrBuilder.class */
    public interface ParentQuestOrBuilder extends MessageOrBuilder {
        List<InferencePageInfoOuterClass.InferencePageInfo> getInferencePageListList();

        InferencePageInfoOuterClass.InferencePageInfo getInferencePageList(int i);

        int getInferencePageListCount();

        List<? extends InferencePageInfoOuterClass.InferencePageInfoOrBuilder> getInferencePageListOrBuilderList();

        InferencePageInfoOuterClass.InferencePageInfoOrBuilder getInferencePageListOrBuilder(int i);

        List<Integer> getQuestVarList();

        int getQuestVarCount();

        int getQuestVar(int i);

        long getVideoKey();

        int getParentQuestState();

        boolean hasRandomInfo();

        ParentQuestRandomInfoOuterClass.ParentQuestRandomInfo getRandomInfo();

        ParentQuestRandomInfoOuterClass.ParentQuestRandomInfoOrBuilder getRandomInfoOrBuilder();

        int getParentQuestId();

        boolean getIsRandom();

        List<ChildQuestOuterClass.ChildQuest> getChildQuestListList();

        ChildQuestOuterClass.ChildQuest getChildQuestList(int i);

        int getChildQuestListCount();

        List<? extends ChildQuestOuterClass.ChildQuestOrBuilder> getChildQuestListOrBuilderList();

        ChildQuestOuterClass.ChildQuestOrBuilder getChildQuestListOrBuilder(int i);

        boolean getIsFinished();

        int getTimeVarMapCount();

        boolean containsTimeVarMap(int i);

        @Deprecated
        Map<Integer, Integer> getTimeVarMap();

        Map<Integer, Integer> getTimeVarMapMap();

        int getTimeVarMapOrDefault(int i, int i2);

        int getTimeVarMapOrThrow(int i);

        int getQuestVarSeq();
    }

    private ParentQuestOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ParentQuestOuterClass$ParentQuest.class */
    public static final class ParentQuest extends GeneratedMessageV3 implements ParentQuestOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int INFERENCE_PAGE_LIST_FIELD_NUMBER = 5;
        private List<InferencePageInfoOuterClass.InferencePageInfo> inferencePageList_;
        public static final int QUEST_VAR_FIELD_NUMBER = 7;
        private Internal.IntList questVar_;
        private int questVarMemoizedSerializedSize;
        public static final int VIDEO_KEY_FIELD_NUMBER = 11;
        private long videoKey_;
        public static final int PARENT_QUEST_STATE_FIELD_NUMBER = 15;
        private int parentQuestState_;
        public static final int RANDOM_INFO_FIELD_NUMBER = 9;
        private ParentQuestRandomInfoOuterClass.ParentQuestRandomInfo randomInfo_;
        public static final int PARENT_QUEST_ID_FIELD_NUMBER = 3;
        private int parentQuestId_;
        public static final int IS_RANDOM_FIELD_NUMBER = 12;
        private boolean isRandom_;
        public static final int CHILD_QUEST_LIST_FIELD_NUMBER = 8;
        private List<ChildQuestOuterClass.ChildQuest> childQuestList_;
        public static final int IS_FINISHED_FIELD_NUMBER = 1;
        private boolean isFinished_;
        public static final int TIME_VAR_MAP_FIELD_NUMBER = 2;
        private MapField<Integer, Integer> timeVarMap_;
        public static final int QUEST_VAR_SEQ_FIELD_NUMBER = 14;
        private int questVarSeq_;
        private byte memoizedIsInitialized;
        private static final ParentQuest DEFAULT_INSTANCE = new ParentQuest();
        private static final Parser<ParentQuest> PARSER = new AbstractParser<ParentQuest>() { // from class: emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuest.1
            @Override // com.google.protobuf.Parser
            public ParentQuest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ParentQuest(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuest.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 2: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetTimeVarMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuest.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private ParentQuest(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.questVarMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ParentQuest() {
            this.questVarMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.inferencePageList_ = Collections.emptyList();
            this.questVar_ = emptyIntList();
            this.childQuestList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ParentQuest();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:104:0x0234 */
        private ParentQuest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.isFinished_ = input.readBool();
                                    break;
                                case 18:
                                    if ((mutable_bitField0_ & 8) == 0) {
                                        this.timeVarMap_ = MapField.newMapField(TimeVarMapDefaultEntryHolder.defaultEntry);
                                        mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                    }
                                    MapEntry<Integer, Integer> timeVarMap__ = (MapEntry) input.readMessage(TimeVarMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                    this.timeVarMap_.getMutableMap().put(timeVarMap__.getKey(), timeVarMap__.getValue());
                                    break;
                                case 24:
                                    this.parentQuestId_ = input.readUInt32();
                                    break;
                                case 42:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.inferencePageList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.inferencePageList_.add((InferencePageInfoOuterClass.InferencePageInfo) input.readMessage(InferencePageInfoOuterClass.InferencePageInfo.parser(), extensionRegistry));
                                    break;
                                case 56:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.questVar_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.questVar_.addInt(input.readInt32());
                                    break;
                                case 58:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.questVar_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.questVar_.addInt(input.readInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 66:
                                    if ((mutable_bitField0_ & 4) == 0) {
                                        this.childQuestList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                    }
                                    this.childQuestList_.add((ChildQuestOuterClass.ChildQuest) input.readMessage(ChildQuestOuterClass.ChildQuest.parser(), extensionRegistry));
                                    break;
                                case 74:
                                    ParentQuestRandomInfoOuterClass.ParentQuestRandomInfo.Builder subBuilder = this.randomInfo_ != null ? this.randomInfo_.toBuilder() : null;
                                    this.randomInfo_ = (ParentQuestRandomInfoOuterClass.ParentQuestRandomInfo) input.readMessage(ParentQuestRandomInfoOuterClass.ParentQuestRandomInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.randomInfo_);
                                        this.randomInfo_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 88:
                                    this.videoKey_ = input.readUInt64();
                                    break;
                                case 96:
                                    this.isRandom_ = input.readBool();
                                    break;
                                case 112:
                                    this.questVarSeq_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.parentQuestState_ = input.readUInt32();
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
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.inferencePageList_ = Collections.unmodifiableList(this.inferencePageList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.questVar_.makeImmutable();
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.childQuestList_ = Collections.unmodifiableList(this.childQuestList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ParentQuestOuterClass.internal_static_ParentQuest_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ParentQuestOuterClass.internal_static_ParentQuest_fieldAccessorTable.ensureFieldAccessorsInitialized(ParentQuest.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public List<InferencePageInfoOuterClass.InferencePageInfo> getInferencePageListList() {
            return this.inferencePageList_;
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public List<? extends InferencePageInfoOuterClass.InferencePageInfoOrBuilder> getInferencePageListOrBuilderList() {
            return this.inferencePageList_;
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public int getInferencePageListCount() {
            return this.inferencePageList_.size();
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public InferencePageInfoOuterClass.InferencePageInfo getInferencePageList(int index) {
            return this.inferencePageList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public InferencePageInfoOuterClass.InferencePageInfoOrBuilder getInferencePageListOrBuilder(int index) {
            return this.inferencePageList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public List<Integer> getQuestVarList() {
            return this.questVar_;
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public int getQuestVarCount() {
            return this.questVar_.size();
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public int getQuestVar(int index) {
            return this.questVar_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public long getVideoKey() {
            return this.videoKey_;
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public int getParentQuestState() {
            return this.parentQuestState_;
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public boolean hasRandomInfo() {
            return this.randomInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public ParentQuestRandomInfoOuterClass.ParentQuestRandomInfo getRandomInfo() {
            return this.randomInfo_ == null ? ParentQuestRandomInfoOuterClass.ParentQuestRandomInfo.getDefaultInstance() : this.randomInfo_;
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public ParentQuestRandomInfoOuterClass.ParentQuestRandomInfoOrBuilder getRandomInfoOrBuilder() {
            return getRandomInfo();
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public int getParentQuestId() {
            return this.parentQuestId_;
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public boolean getIsRandom() {
            return this.isRandom_;
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public List<ChildQuestOuterClass.ChildQuest> getChildQuestListList() {
            return this.childQuestList_;
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public List<? extends ChildQuestOuterClass.ChildQuestOrBuilder> getChildQuestListOrBuilderList() {
            return this.childQuestList_;
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public int getChildQuestListCount() {
            return this.childQuestList_.size();
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public ChildQuestOuterClass.ChildQuest getChildQuestList(int index) {
            return this.childQuestList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public ChildQuestOuterClass.ChildQuestOrBuilder getChildQuestListOrBuilder(int index) {
            return this.childQuestList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public boolean getIsFinished() {
            return this.isFinished_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ParentQuestOuterClass$ParentQuest$TimeVarMapDefaultEntryHolder.class */
        public static final class TimeVarMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(ParentQuestOuterClass.internal_static_ParentQuest_TimeVarMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private TimeVarMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetTimeVarMap() {
            if (this.timeVarMap_ == null) {
                return MapField.emptyMapField(TimeVarMapDefaultEntryHolder.defaultEntry);
            }
            return this.timeVarMap_;
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public int getTimeVarMapCount() {
            return internalGetTimeVarMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public boolean containsTimeVarMap(int key) {
            return internalGetTimeVarMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        @Deprecated
        public Map<Integer, Integer> getTimeVarMap() {
            return getTimeVarMapMap();
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public Map<Integer, Integer> getTimeVarMapMap() {
            return internalGetTimeVarMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public int getTimeVarMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetTimeVarMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public int getTimeVarMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetTimeVarMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
        public int getQuestVarSeq() {
            return this.questVarSeq_;
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
            if (this.isFinished_) {
                output.writeBool(1, this.isFinished_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetTimeVarMap(), TimeVarMapDefaultEntryHolder.defaultEntry, 2);
            if (this.parentQuestId_ != 0) {
                output.writeUInt32(3, this.parentQuestId_);
            }
            for (int i = 0; i < this.inferencePageList_.size(); i++) {
                output.writeMessage(5, this.inferencePageList_.get(i));
            }
            if (getQuestVarList().size() > 0) {
                output.writeUInt32NoTag(58);
                output.writeUInt32NoTag(this.questVarMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.questVar_.size(); i2++) {
                output.writeInt32NoTag(this.questVar_.getInt(i2));
            }
            for (int i3 = 0; i3 < this.childQuestList_.size(); i3++) {
                output.writeMessage(8, this.childQuestList_.get(i3));
            }
            if (this.randomInfo_ != null) {
                output.writeMessage(9, getRandomInfo());
            }
            if (this.videoKey_ != 0) {
                output.writeUInt64(11, this.videoKey_);
            }
            if (this.isRandom_) {
                output.writeBool(12, this.isRandom_);
            }
            if (this.questVarSeq_ != 0) {
                output.writeUInt32(14, this.questVarSeq_);
            }
            if (this.parentQuestState_ != 0) {
                output.writeUInt32(15, this.parentQuestState_);
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
            if (this.isFinished_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.isFinished_);
            }
            for (Map.Entry<Integer, Integer> entry : internalGetTimeVarMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(2, TimeVarMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.parentQuestId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.parentQuestId_);
            }
            for (int i = 0; i < this.inferencePageList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.inferencePageList_.get(i));
            }
            int dataSize = 0;
            for (int i2 = 0; i2 < this.questVar_.size(); i2++) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.questVar_.getInt(i2));
            }
            int size3 = size2 + dataSize;
            if (!getQuestVarList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.questVarMemoizedSerializedSize = dataSize;
            for (int i3 = 0; i3 < this.childQuestList_.size(); i3++) {
                size3 += CodedOutputStream.computeMessageSize(8, this.childQuestList_.get(i3));
            }
            if (this.randomInfo_ != null) {
                size3 += CodedOutputStream.computeMessageSize(9, getRandomInfo());
            }
            if (this.videoKey_ != 0) {
                size3 += CodedOutputStream.computeUInt64Size(11, this.videoKey_);
            }
            if (this.isRandom_) {
                size3 += CodedOutputStream.computeBoolSize(12, this.isRandom_);
            }
            if (this.questVarSeq_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(14, this.questVarSeq_);
            }
            if (this.parentQuestState_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(15, this.parentQuestState_);
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
            if (!(obj instanceof ParentQuest)) {
                return equals(obj);
            }
            ParentQuest other = (ParentQuest) obj;
            if (getInferencePageListList().equals(other.getInferencePageListList()) && getQuestVarList().equals(other.getQuestVarList()) && getVideoKey() == other.getVideoKey() && getParentQuestState() == other.getParentQuestState() && hasRandomInfo() == other.hasRandomInfo()) {
                return (!hasRandomInfo() || getRandomInfo().equals(other.getRandomInfo())) && getParentQuestId() == other.getParentQuestId() && getIsRandom() == other.getIsRandom() && getChildQuestListList().equals(other.getChildQuestListList()) && getIsFinished() == other.getIsFinished() && internalGetTimeVarMap().equals(other.internalGetTimeVarMap()) && getQuestVarSeq() == other.getQuestVarSeq() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getInferencePageListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getInferencePageListList().hashCode();
            }
            if (getQuestVarCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getQuestVarList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * hash) + 11)) + Internal.hashLong(getVideoKey()))) + 15)) + getParentQuestState();
            if (hasRandomInfo()) {
                hash2 = (53 * ((37 * hash2) + 9)) + getRandomInfo().hashCode();
            }
            int hash3 = (53 * ((37 * ((53 * ((37 * hash2) + 3)) + getParentQuestId())) + 12)) + Internal.hashBoolean(getIsRandom());
            if (getChildQuestListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 8)) + getChildQuestListList().hashCode();
            }
            int hash4 = (53 * ((37 * hash3) + 1)) + Internal.hashBoolean(getIsFinished());
            if (!internalGetTimeVarMap().getMap().isEmpty()) {
                hash4 = (53 * ((37 * hash4) + 2)) + internalGetTimeVarMap().hashCode();
            }
            int hash5 = (29 * ((53 * ((37 * hash4) + 14)) + getQuestVarSeq())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash5;
            return hash5;
        }

        public static ParentQuest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ParentQuest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ParentQuest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ParentQuest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ParentQuest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ParentQuest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ParentQuest parseFrom(InputStream input) throws IOException {
            return (ParentQuest) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ParentQuest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ParentQuest) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ParentQuest parseDelimitedFrom(InputStream input) throws IOException {
            return (ParentQuest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ParentQuest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ParentQuest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ParentQuest parseFrom(CodedInputStream input) throws IOException {
            return (ParentQuest) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ParentQuest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ParentQuest) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ParentQuest prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ParentQuestOuterClass$ParentQuest$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ParentQuestOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<InferencePageInfoOuterClass.InferencePageInfo, InferencePageInfoOuterClass.InferencePageInfo.Builder, InferencePageInfoOuterClass.InferencePageInfoOrBuilder> inferencePageListBuilder_;
            private long videoKey_;
            private int parentQuestState_;
            private ParentQuestRandomInfoOuterClass.ParentQuestRandomInfo randomInfo_;
            private SingleFieldBuilderV3<ParentQuestRandomInfoOuterClass.ParentQuestRandomInfo, ParentQuestRandomInfoOuterClass.ParentQuestRandomInfo.Builder, ParentQuestRandomInfoOuterClass.ParentQuestRandomInfoOrBuilder> randomInfoBuilder_;
            private int parentQuestId_;
            private boolean isRandom_;
            private RepeatedFieldBuilderV3<ChildQuestOuterClass.ChildQuest, ChildQuestOuterClass.ChildQuest.Builder, ChildQuestOuterClass.ChildQuestOrBuilder> childQuestListBuilder_;
            private boolean isFinished_;
            private MapField<Integer, Integer> timeVarMap_;
            private int questVarSeq_;
            private List<InferencePageInfoOuterClass.InferencePageInfo> inferencePageList_ = Collections.emptyList();
            private Internal.IntList questVar_ = ParentQuest.emptyIntList();
            private List<ChildQuestOuterClass.ChildQuest> childQuestList_ = Collections.emptyList();

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuest.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 2: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetTimeVarMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuest.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuest.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 2: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableTimeVarMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuest.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ParentQuestOuterClass.internal_static_ParentQuest_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ParentQuestOuterClass.internal_static_ParentQuest_fieldAccessorTable.ensureFieldAccessorsInitialized(ParentQuest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ParentQuest.alwaysUseFieldBuilders) {
                    getInferencePageListFieldBuilder();
                    getChildQuestListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.inferencePageListBuilder_ == null) {
                    this.inferencePageList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.inferencePageListBuilder_.clear();
                }
                this.questVar_ = ParentQuest.emptyIntList();
                this.bitField0_ &= -3;
                this.videoKey_ = 0;
                this.parentQuestState_ = 0;
                if (this.randomInfoBuilder_ == null) {
                    this.randomInfo_ = null;
                } else {
                    this.randomInfo_ = null;
                    this.randomInfoBuilder_ = null;
                }
                this.parentQuestId_ = 0;
                this.isRandom_ = false;
                if (this.childQuestListBuilder_ == null) {
                    this.childQuestList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.childQuestListBuilder_.clear();
                }
                this.isFinished_ = false;
                internalGetMutableTimeVarMap().clear();
                this.questVarSeq_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ParentQuestOuterClass.internal_static_ParentQuest_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ParentQuest getDefaultInstanceForType() {
                return ParentQuest.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ParentQuest build() {
                ParentQuest result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ParentQuest buildPartial() {
                ParentQuest result = new ParentQuest(this);
                int i = this.bitField0_;
                if (this.inferencePageListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.inferencePageList_ = Collections.unmodifiableList(this.inferencePageList_);
                        this.bitField0_ &= -2;
                    }
                    result.inferencePageList_ = this.inferencePageList_;
                } else {
                    result.inferencePageList_ = this.inferencePageListBuilder_.build();
                }
                if ((this.bitField0_ & 2) != 0) {
                    this.questVar_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.questVar_ = this.questVar_;
                result.videoKey_ = this.videoKey_;
                result.parentQuestState_ = this.parentQuestState_;
                if (this.randomInfoBuilder_ == null) {
                    result.randomInfo_ = this.randomInfo_;
                } else {
                    result.randomInfo_ = this.randomInfoBuilder_.build();
                }
                result.parentQuestId_ = this.parentQuestId_;
                result.isRandom_ = this.isRandom_;
                if (this.childQuestListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.childQuestList_ = Collections.unmodifiableList(this.childQuestList_);
                        this.bitField0_ &= -5;
                    }
                    result.childQuestList_ = this.childQuestList_;
                } else {
                    result.childQuestList_ = this.childQuestListBuilder_.build();
                }
                result.isFinished_ = this.isFinished_;
                result.timeVarMap_ = internalGetTimeVarMap();
                result.timeVarMap_.makeImmutable();
                result.questVarSeq_ = this.questVarSeq_;
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
                if (other instanceof ParentQuest) {
                    return mergeFrom((ParentQuest) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ParentQuest other) {
                if (other == ParentQuest.getDefaultInstance()) {
                    return this;
                }
                if (this.inferencePageListBuilder_ == null) {
                    if (!other.inferencePageList_.isEmpty()) {
                        if (this.inferencePageList_.isEmpty()) {
                            this.inferencePageList_ = other.inferencePageList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureInferencePageListIsMutable();
                            this.inferencePageList_.addAll(other.inferencePageList_);
                        }
                        onChanged();
                    }
                } else if (!other.inferencePageList_.isEmpty()) {
                    if (this.inferencePageListBuilder_.isEmpty()) {
                        this.inferencePageListBuilder_.dispose();
                        this.inferencePageListBuilder_ = null;
                        this.inferencePageList_ = other.inferencePageList_;
                        this.bitField0_ &= -2;
                        this.inferencePageListBuilder_ = ParentQuest.alwaysUseFieldBuilders ? getInferencePageListFieldBuilder() : null;
                    } else {
                        this.inferencePageListBuilder_.addAllMessages(other.inferencePageList_);
                    }
                }
                if (!other.questVar_.isEmpty()) {
                    if (this.questVar_.isEmpty()) {
                        this.questVar_ = other.questVar_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureQuestVarIsMutable();
                        this.questVar_.addAll(other.questVar_);
                    }
                    onChanged();
                }
                if (other.getVideoKey() != 0) {
                    setVideoKey(other.getVideoKey());
                }
                if (other.getParentQuestState() != 0) {
                    setParentQuestState(other.getParentQuestState());
                }
                if (other.hasRandomInfo()) {
                    mergeRandomInfo(other.getRandomInfo());
                }
                if (other.getParentQuestId() != 0) {
                    setParentQuestId(other.getParentQuestId());
                }
                if (other.getIsRandom()) {
                    setIsRandom(other.getIsRandom());
                }
                if (this.childQuestListBuilder_ == null) {
                    if (!other.childQuestList_.isEmpty()) {
                        if (this.childQuestList_.isEmpty()) {
                            this.childQuestList_ = other.childQuestList_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureChildQuestListIsMutable();
                            this.childQuestList_.addAll(other.childQuestList_);
                        }
                        onChanged();
                    }
                } else if (!other.childQuestList_.isEmpty()) {
                    if (this.childQuestListBuilder_.isEmpty()) {
                        this.childQuestListBuilder_.dispose();
                        this.childQuestListBuilder_ = null;
                        this.childQuestList_ = other.childQuestList_;
                        this.bitField0_ &= -5;
                        this.childQuestListBuilder_ = ParentQuest.alwaysUseFieldBuilders ? getChildQuestListFieldBuilder() : null;
                    } else {
                        this.childQuestListBuilder_.addAllMessages(other.childQuestList_);
                    }
                }
                if (other.getIsFinished()) {
                    setIsFinished(other.getIsFinished());
                }
                internalGetMutableTimeVarMap().mergeFrom(other.internalGetTimeVarMap());
                if (other.getQuestVarSeq() != 0) {
                    setQuestVarSeq(other.getQuestVarSeq());
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
                ParentQuest parsedMessage = null;
                try {
                    try {
                        parsedMessage = ParentQuest.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ParentQuest) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureInferencePageListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.inferencePageList_ = new ArrayList(this.inferencePageList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public List<InferencePageInfoOuterClass.InferencePageInfo> getInferencePageListList() {
                if (this.inferencePageListBuilder_ == null) {
                    return Collections.unmodifiableList(this.inferencePageList_);
                }
                return this.inferencePageListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public int getInferencePageListCount() {
                if (this.inferencePageListBuilder_ == null) {
                    return this.inferencePageList_.size();
                }
                return this.inferencePageListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public InferencePageInfoOuterClass.InferencePageInfo getInferencePageList(int index) {
                if (this.inferencePageListBuilder_ == null) {
                    return this.inferencePageList_.get(index);
                }
                return this.inferencePageListBuilder_.getMessage(index);
            }

            public Builder setInferencePageList(int index, InferencePageInfoOuterClass.InferencePageInfo value) {
                if (this.inferencePageListBuilder_ != null) {
                    this.inferencePageListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInferencePageListIsMutable();
                    this.inferencePageList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setInferencePageList(int index, InferencePageInfoOuterClass.InferencePageInfo.Builder builderForValue) {
                if (this.inferencePageListBuilder_ == null) {
                    ensureInferencePageListIsMutable();
                    this.inferencePageList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.inferencePageListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addInferencePageList(InferencePageInfoOuterClass.InferencePageInfo value) {
                if (this.inferencePageListBuilder_ != null) {
                    this.inferencePageListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInferencePageListIsMutable();
                    this.inferencePageList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addInferencePageList(int index, InferencePageInfoOuterClass.InferencePageInfo value) {
                if (this.inferencePageListBuilder_ != null) {
                    this.inferencePageListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInferencePageListIsMutable();
                    this.inferencePageList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addInferencePageList(InferencePageInfoOuterClass.InferencePageInfo.Builder builderForValue) {
                if (this.inferencePageListBuilder_ == null) {
                    ensureInferencePageListIsMutable();
                    this.inferencePageList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.inferencePageListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addInferencePageList(int index, InferencePageInfoOuterClass.InferencePageInfo.Builder builderForValue) {
                if (this.inferencePageListBuilder_ == null) {
                    ensureInferencePageListIsMutable();
                    this.inferencePageList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.inferencePageListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllInferencePageList(Iterable<? extends InferencePageInfoOuterClass.InferencePageInfo> values) {
                if (this.inferencePageListBuilder_ == null) {
                    ensureInferencePageListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.inferencePageList_);
                    onChanged();
                } else {
                    this.inferencePageListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearInferencePageList() {
                if (this.inferencePageListBuilder_ == null) {
                    this.inferencePageList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.inferencePageListBuilder_.clear();
                }
                return this;
            }

            public Builder removeInferencePageList(int index) {
                if (this.inferencePageListBuilder_ == null) {
                    ensureInferencePageListIsMutable();
                    this.inferencePageList_.remove(index);
                    onChanged();
                } else {
                    this.inferencePageListBuilder_.remove(index);
                }
                return this;
            }

            public InferencePageInfoOuterClass.InferencePageInfo.Builder getInferencePageListBuilder(int index) {
                return getInferencePageListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public InferencePageInfoOuterClass.InferencePageInfoOrBuilder getInferencePageListOrBuilder(int index) {
                if (this.inferencePageListBuilder_ == null) {
                    return this.inferencePageList_.get(index);
                }
                return this.inferencePageListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public List<? extends InferencePageInfoOuterClass.InferencePageInfoOrBuilder> getInferencePageListOrBuilderList() {
                if (this.inferencePageListBuilder_ != null) {
                    return this.inferencePageListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.inferencePageList_);
            }

            public InferencePageInfoOuterClass.InferencePageInfo.Builder addInferencePageListBuilder() {
                return getInferencePageListFieldBuilder().addBuilder(InferencePageInfoOuterClass.InferencePageInfo.getDefaultInstance());
            }

            public InferencePageInfoOuterClass.InferencePageInfo.Builder addInferencePageListBuilder(int index) {
                return getInferencePageListFieldBuilder().addBuilder(index, InferencePageInfoOuterClass.InferencePageInfo.getDefaultInstance());
            }

            public List<InferencePageInfoOuterClass.InferencePageInfo.Builder> getInferencePageListBuilderList() {
                return getInferencePageListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<InferencePageInfoOuterClass.InferencePageInfo, InferencePageInfoOuterClass.InferencePageInfo.Builder, InferencePageInfoOuterClass.InferencePageInfoOrBuilder> getInferencePageListFieldBuilder() {
                if (this.inferencePageListBuilder_ == null) {
                    this.inferencePageListBuilder_ = new RepeatedFieldBuilderV3<>(this.inferencePageList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.inferencePageList_ = null;
                }
                return this.inferencePageListBuilder_;
            }

            private void ensureQuestVarIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.questVar_ = ParentQuest.mutableCopy(this.questVar_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public List<Integer> getQuestVarList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.questVar_) : this.questVar_;
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public int getQuestVarCount() {
                return this.questVar_.size();
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public int getQuestVar(int index) {
                return this.questVar_.getInt(index);
            }

            public Builder setQuestVar(int index, int value) {
                ensureQuestVarIsMutable();
                this.questVar_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addQuestVar(int value) {
                ensureQuestVarIsMutable();
                this.questVar_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllQuestVar(Iterable<? extends Integer> values) {
                ensureQuestVarIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.questVar_);
                onChanged();
                return this;
            }

            public Builder clearQuestVar() {
                this.questVar_ = ParentQuest.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public long getVideoKey() {
                return this.videoKey_;
            }

            public Builder setVideoKey(long value) {
                this.videoKey_ = value;
                onChanged();
                return this;
            }

            public Builder clearVideoKey() {
                this.videoKey_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public int getParentQuestState() {
                return this.parentQuestState_;
            }

            public Builder setParentQuestState(int value) {
                this.parentQuestState_ = value;
                onChanged();
                return this;
            }

            public Builder clearParentQuestState() {
                this.parentQuestState_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public boolean hasRandomInfo() {
                return (this.randomInfoBuilder_ == null && this.randomInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public ParentQuestRandomInfoOuterClass.ParentQuestRandomInfo getRandomInfo() {
                if (this.randomInfoBuilder_ == null) {
                    return this.randomInfo_ == null ? ParentQuestRandomInfoOuterClass.ParentQuestRandomInfo.getDefaultInstance() : this.randomInfo_;
                }
                return this.randomInfoBuilder_.getMessage();
            }

            public Builder setRandomInfo(ParentQuestRandomInfoOuterClass.ParentQuestRandomInfo value) {
                if (this.randomInfoBuilder_ != null) {
                    this.randomInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.randomInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setRandomInfo(ParentQuestRandomInfoOuterClass.ParentQuestRandomInfo.Builder builderForValue) {
                if (this.randomInfoBuilder_ == null) {
                    this.randomInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.randomInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeRandomInfo(ParentQuestRandomInfoOuterClass.ParentQuestRandomInfo value) {
                if (this.randomInfoBuilder_ == null) {
                    if (this.randomInfo_ != null) {
                        this.randomInfo_ = ParentQuestRandomInfoOuterClass.ParentQuestRandomInfo.newBuilder(this.randomInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.randomInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.randomInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearRandomInfo() {
                if (this.randomInfoBuilder_ == null) {
                    this.randomInfo_ = null;
                    onChanged();
                } else {
                    this.randomInfo_ = null;
                    this.randomInfoBuilder_ = null;
                }
                return this;
            }

            public ParentQuestRandomInfoOuterClass.ParentQuestRandomInfo.Builder getRandomInfoBuilder() {
                onChanged();
                return getRandomInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public ParentQuestRandomInfoOuterClass.ParentQuestRandomInfoOrBuilder getRandomInfoOrBuilder() {
                if (this.randomInfoBuilder_ != null) {
                    return this.randomInfoBuilder_.getMessageOrBuilder();
                }
                return this.randomInfo_ == null ? ParentQuestRandomInfoOuterClass.ParentQuestRandomInfo.getDefaultInstance() : this.randomInfo_;
            }

            private SingleFieldBuilderV3<ParentQuestRandomInfoOuterClass.ParentQuestRandomInfo, ParentQuestRandomInfoOuterClass.ParentQuestRandomInfo.Builder, ParentQuestRandomInfoOuterClass.ParentQuestRandomInfoOrBuilder> getRandomInfoFieldBuilder() {
                if (this.randomInfoBuilder_ == null) {
                    this.randomInfoBuilder_ = new SingleFieldBuilderV3<>(getRandomInfo(), getParentForChildren(), isClean());
                    this.randomInfo_ = null;
                }
                return this.randomInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public int getParentQuestId() {
                return this.parentQuestId_;
            }

            public Builder setParentQuestId(int value) {
                this.parentQuestId_ = value;
                onChanged();
                return this;
            }

            public Builder clearParentQuestId() {
                this.parentQuestId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public boolean getIsRandom() {
                return this.isRandom_;
            }

            public Builder setIsRandom(boolean value) {
                this.isRandom_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsRandom() {
                this.isRandom_ = false;
                onChanged();
                return this;
            }

            private void ensureChildQuestListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.childQuestList_ = new ArrayList(this.childQuestList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public List<ChildQuestOuterClass.ChildQuest> getChildQuestListList() {
                if (this.childQuestListBuilder_ == null) {
                    return Collections.unmodifiableList(this.childQuestList_);
                }
                return this.childQuestListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public int getChildQuestListCount() {
                if (this.childQuestListBuilder_ == null) {
                    return this.childQuestList_.size();
                }
                return this.childQuestListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public ChildQuestOuterClass.ChildQuest getChildQuestList(int index) {
                if (this.childQuestListBuilder_ == null) {
                    return this.childQuestList_.get(index);
                }
                return this.childQuestListBuilder_.getMessage(index);
            }

            public Builder setChildQuestList(int index, ChildQuestOuterClass.ChildQuest value) {
                if (this.childQuestListBuilder_ != null) {
                    this.childQuestListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChildQuestListIsMutable();
                    this.childQuestList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setChildQuestList(int index, ChildQuestOuterClass.ChildQuest.Builder builderForValue) {
                if (this.childQuestListBuilder_ == null) {
                    ensureChildQuestListIsMutable();
                    this.childQuestList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.childQuestListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addChildQuestList(ChildQuestOuterClass.ChildQuest value) {
                if (this.childQuestListBuilder_ != null) {
                    this.childQuestListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChildQuestListIsMutable();
                    this.childQuestList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addChildQuestList(int index, ChildQuestOuterClass.ChildQuest value) {
                if (this.childQuestListBuilder_ != null) {
                    this.childQuestListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChildQuestListIsMutable();
                    this.childQuestList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addChildQuestList(ChildQuestOuterClass.ChildQuest.Builder builderForValue) {
                if (this.childQuestListBuilder_ == null) {
                    ensureChildQuestListIsMutable();
                    this.childQuestList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.childQuestListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addChildQuestList(int index, ChildQuestOuterClass.ChildQuest.Builder builderForValue) {
                if (this.childQuestListBuilder_ == null) {
                    ensureChildQuestListIsMutable();
                    this.childQuestList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.childQuestListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllChildQuestList(Iterable<? extends ChildQuestOuterClass.ChildQuest> values) {
                if (this.childQuestListBuilder_ == null) {
                    ensureChildQuestListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.childQuestList_);
                    onChanged();
                } else {
                    this.childQuestListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearChildQuestList() {
                if (this.childQuestListBuilder_ == null) {
                    this.childQuestList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.childQuestListBuilder_.clear();
                }
                return this;
            }

            public Builder removeChildQuestList(int index) {
                if (this.childQuestListBuilder_ == null) {
                    ensureChildQuestListIsMutable();
                    this.childQuestList_.remove(index);
                    onChanged();
                } else {
                    this.childQuestListBuilder_.remove(index);
                }
                return this;
            }

            public ChildQuestOuterClass.ChildQuest.Builder getChildQuestListBuilder(int index) {
                return getChildQuestListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public ChildQuestOuterClass.ChildQuestOrBuilder getChildQuestListOrBuilder(int index) {
                if (this.childQuestListBuilder_ == null) {
                    return this.childQuestList_.get(index);
                }
                return this.childQuestListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public List<? extends ChildQuestOuterClass.ChildQuestOrBuilder> getChildQuestListOrBuilderList() {
                if (this.childQuestListBuilder_ != null) {
                    return this.childQuestListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.childQuestList_);
            }

            public ChildQuestOuterClass.ChildQuest.Builder addChildQuestListBuilder() {
                return getChildQuestListFieldBuilder().addBuilder(ChildQuestOuterClass.ChildQuest.getDefaultInstance());
            }

            public ChildQuestOuterClass.ChildQuest.Builder addChildQuestListBuilder(int index) {
                return getChildQuestListFieldBuilder().addBuilder(index, ChildQuestOuterClass.ChildQuest.getDefaultInstance());
            }

            public List<ChildQuestOuterClass.ChildQuest.Builder> getChildQuestListBuilderList() {
                return getChildQuestListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ChildQuestOuterClass.ChildQuest, ChildQuestOuterClass.ChildQuest.Builder, ChildQuestOuterClass.ChildQuestOrBuilder> getChildQuestListFieldBuilder() {
                if (this.childQuestListBuilder_ == null) {
                    this.childQuestListBuilder_ = new RepeatedFieldBuilderV3<>(this.childQuestList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.childQuestList_ = null;
                }
                return this.childQuestListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public boolean getIsFinished() {
                return this.isFinished_;
            }

            public Builder setIsFinished(boolean value) {
                this.isFinished_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFinished() {
                this.isFinished_ = false;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetTimeVarMap() {
                if (this.timeVarMap_ == null) {
                    return MapField.emptyMapField(TimeVarMapDefaultEntryHolder.defaultEntry);
                }
                return this.timeVarMap_;
            }

            private MapField<Integer, Integer> internalGetMutableTimeVarMap() {
                onChanged();
                if (this.timeVarMap_ == null) {
                    this.timeVarMap_ = MapField.newMapField(TimeVarMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.timeVarMap_.isMutable()) {
                    this.timeVarMap_ = this.timeVarMap_.copy();
                }
                return this.timeVarMap_;
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public int getTimeVarMapCount() {
                return internalGetTimeVarMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public boolean containsTimeVarMap(int key) {
                return internalGetTimeVarMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            @Deprecated
            public Map<Integer, Integer> getTimeVarMap() {
                return getTimeVarMapMap();
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public Map<Integer, Integer> getTimeVarMapMap() {
                return internalGetTimeVarMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public int getTimeVarMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetTimeVarMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public int getTimeVarMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetTimeVarMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearTimeVarMap() {
                internalGetMutableTimeVarMap().getMutableMap().clear();
                return this;
            }

            public Builder removeTimeVarMap(int key) {
                internalGetMutableTimeVarMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableTimeVarMap() {
                return internalGetMutableTimeVarMap().getMutableMap();
            }

            public Builder putTimeVarMap(int key, int value) {
                internalGetMutableTimeVarMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllTimeVarMap(Map<Integer, Integer> values) {
                internalGetMutableTimeVarMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.ParentQuestOuterClass.ParentQuestOrBuilder
            public int getQuestVarSeq() {
                return this.questVarSeq_;
            }

            public Builder setQuestVarSeq(int value) {
                this.questVarSeq_ = value;
                onChanged();
                return this;
            }

            public Builder clearQuestVarSeq() {
                this.questVarSeq_ = 0;
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

        public static ParentQuest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ParentQuest> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ParentQuest> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ParentQuest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ChildQuestOuterClass.getDescriptor();
        InferencePageInfoOuterClass.getDescriptor();
        ParentQuestRandomInfoOuterClass.getDescriptor();
    }
}
