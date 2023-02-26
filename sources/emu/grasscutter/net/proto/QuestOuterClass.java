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
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestOuterClass.class */
public final class QuestOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000bQuest.proto\"Û\u0003\n\u0005Quest\u0012\u000f\n\u0007questId\u0018\u0001 \u0001(\r\u0012\r\n\u0005state\u0018\u0002 \u0001(\r\u0012\u0011\n\tstartTime\u0018\u0004 \u0001(\r\u0012\u0010\n\bisRandom\u0018\u0005 \u0001(\b\u0012\u0015\n\rparentQuestId\u0018\u0006 \u0001(\r\u0012\u0015\n\rquestConfigId\u0018\u0007 \u0001(\r\u0012\u0015\n\rstartGameTime\u0018\b \u0001(\r\u0012\u0012\n\nacceptTime\u0018\t \u0001(\r\u0012\u0015\n\rlackedNpcList\u0018\n \u0003(\r\u0012\u001a\n\u0012finishProgressList\u0018\u000b \u0003(\r\u0012\u0018\n\u0010failProgressList\u0018\f \u0003(\r\u0012.\n\flackedNpcMap\u0018\r \u0003(\u000b2\u0018.Quest.LackedNpcMapEntry\u0012\u0017\n\u000flackedPlaceList\u0018\u000e \u0003(\r\u00122\n\u000elackedPlaceMap\u0018\u000f \u0003(\u000b2\u001a.Quest.LackedPlaceMapEntry\u001a3\n\u0011LackedNpcMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001\u001a5\n\u0013LackedPlaceMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_Quest_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_Quest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_Quest_descriptor, new String[]{"QuestId", "State", "StartTime", "IsRandom", "ParentQuestId", "QuestConfigId", "StartGameTime", "AcceptTime", "LackedNpcList", "FinishProgressList", "FailProgressList", "LackedNpcMap", "LackedPlaceList", "LackedPlaceMap"});
    private static final Descriptors.Descriptor internal_static_Quest_LackedNpcMapEntry_descriptor = internal_static_Quest_descriptor.getNestedTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_Quest_LackedNpcMapEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_Quest_LackedNpcMapEntry_descriptor, new String[]{"Key", "Value"});
    private static final Descriptors.Descriptor internal_static_Quest_LackedPlaceMapEntry_descriptor = internal_static_Quest_descriptor.getNestedTypes().get(1);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_Quest_LackedPlaceMapEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_Quest_LackedPlaceMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestOuterClass$QuestOrBuilder.class */
    public interface QuestOrBuilder extends MessageOrBuilder {
        int getQuestId();

        int getState();

        int getStartTime();

        boolean getIsRandom();

        int getParentQuestId();

        int getQuestConfigId();

        int getStartGameTime();

        int getAcceptTime();

        List<Integer> getLackedNpcListList();

        int getLackedNpcListCount();

        int getLackedNpcList(int i);

        List<Integer> getFinishProgressListList();

        int getFinishProgressListCount();

        int getFinishProgressList(int i);

        List<Integer> getFailProgressListList();

        int getFailProgressListCount();

        int getFailProgressList(int i);

        int getLackedNpcMapCount();

        boolean containsLackedNpcMap(int i);

        @Deprecated
        Map<Integer, Integer> getLackedNpcMap();

        Map<Integer, Integer> getLackedNpcMapMap();

        int getLackedNpcMapOrDefault(int i, int i2);

        int getLackedNpcMapOrThrow(int i);

        List<Integer> getLackedPlaceListList();

        int getLackedPlaceListCount();

        int getLackedPlaceList(int i);

        int getLackedPlaceMapCount();

        boolean containsLackedPlaceMap(int i);

        @Deprecated
        Map<Integer, Integer> getLackedPlaceMap();

        Map<Integer, Integer> getLackedPlaceMapMap();

        int getLackedPlaceMapOrDefault(int i, int i2);

        int getLackedPlaceMapOrThrow(int i);
    }

    private QuestOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestOuterClass$Quest.class */
    public static final class Quest extends GeneratedMessageV3 implements QuestOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int QUESTID_FIELD_NUMBER = 1;
        private int questId_;
        public static final int STATE_FIELD_NUMBER = 2;
        private int state_;
        public static final int STARTTIME_FIELD_NUMBER = 4;
        private int startTime_;
        public static final int ISRANDOM_FIELD_NUMBER = 5;
        private boolean isRandom_;
        public static final int PARENTQUESTID_FIELD_NUMBER = 6;
        private int parentQuestId_;
        public static final int QUESTCONFIGID_FIELD_NUMBER = 7;
        private int questConfigId_;
        public static final int STARTGAMETIME_FIELD_NUMBER = 8;
        private int startGameTime_;
        public static final int ACCEPTTIME_FIELD_NUMBER = 9;
        private int acceptTime_;
        public static final int LACKEDNPCLIST_FIELD_NUMBER = 10;
        private Internal.IntList lackedNpcList_;
        private int lackedNpcListMemoizedSerializedSize;
        public static final int FINISHPROGRESSLIST_FIELD_NUMBER = 11;
        private Internal.IntList finishProgressList_;
        private int finishProgressListMemoizedSerializedSize;
        public static final int FAILPROGRESSLIST_FIELD_NUMBER = 12;
        private Internal.IntList failProgressList_;
        private int failProgressListMemoizedSerializedSize;
        public static final int LACKEDNPCMAP_FIELD_NUMBER = 13;
        private MapField<Integer, Integer> lackedNpcMap_;
        public static final int LACKEDPLACELIST_FIELD_NUMBER = 14;
        private Internal.IntList lackedPlaceList_;
        private int lackedPlaceListMemoizedSerializedSize;
        public static final int LACKEDPLACEMAP_FIELD_NUMBER = 15;
        private MapField<Integer, Integer> lackedPlaceMap_;
        private byte memoizedIsInitialized;
        private static final Quest DEFAULT_INSTANCE = new Quest();
        private static final Parser<Quest> PARSER = new AbstractParser<Quest>() { // from class: emu.grasscutter.net.proto.QuestOuterClass.Quest.1
            @Override // com.google.protobuf.Parser
            public Quest parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Quest(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.QuestOuterClass.Quest.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 13: goto L_0x001c;
                    case 15: goto L_0x0021;
                    default: goto L_0x0026;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetLackedNpcMap()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetLackedPlaceMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.QuestOuterClass.Quest.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private Quest(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.lackedNpcListMemoizedSerializedSize = -1;
            this.finishProgressListMemoizedSerializedSize = -1;
            this.failProgressListMemoizedSerializedSize = -1;
            this.lackedPlaceListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private Quest() {
            this.lackedNpcListMemoizedSerializedSize = -1;
            this.finishProgressListMemoizedSerializedSize = -1;
            this.failProgressListMemoizedSerializedSize = -1;
            this.lackedPlaceListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.lackedNpcList_ = emptyIntList();
            this.finishProgressList_ = emptyIntList();
            this.failProgressList_ = emptyIntList();
            this.lackedPlaceList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new Quest();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:146:0x0362 */
        private Quest(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.questId_ = input.readUInt32();
                                break;
                            case 16:
                                this.state_ = input.readUInt32();
                                break;
                            case 32:
                                this.startTime_ = input.readUInt32();
                                break;
                            case 40:
                                this.isRandom_ = input.readBool();
                                break;
                            case 48:
                                this.parentQuestId_ = input.readUInt32();
                                break;
                            case 56:
                                this.questConfigId_ = input.readUInt32();
                                break;
                            case 64:
                                this.startGameTime_ = input.readUInt32();
                                break;
                            case 72:
                                this.acceptTime_ = input.readUInt32();
                                break;
                            case 80:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.lackedNpcList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.lackedNpcList_.addInt(input.readUInt32());
                                break;
                            case 82:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.lackedNpcList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.lackedNpcList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 88:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.finishProgressList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.finishProgressList_.addInt(input.readUInt32());
                                break;
                            case 90:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.finishProgressList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.finishProgressList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 96:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.failProgressList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.failProgressList_.addInt(input.readUInt32());
                                break;
                            case 98:
                                int limit3 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.failProgressList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.failProgressList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit3);
                                break;
                            case 106:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.lackedNpcMap_ = MapField.newMapField(LackedNpcMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Integer> lackedNpcMap__ = (MapEntry) input.readMessage(LackedNpcMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.lackedNpcMap_.getMutableMap().put(lackedNpcMap__.getKey(), lackedNpcMap__.getValue());
                                break;
                            case 112:
                                if ((mutable_bitField0_ & 16) == 0) {
                                    this.lackedPlaceList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                }
                                this.lackedPlaceList_.addInt(input.readUInt32());
                                break;
                            case 114:
                                int limit4 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 16) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.lackedPlaceList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.lackedPlaceList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit4);
                                break;
                            case 122:
                                if ((mutable_bitField0_ & 32) == 0) {
                                    this.lackedPlaceMap_ = MapField.newMapField(LackedPlaceMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 32) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Integer> lackedPlaceMap__ = (MapEntry) input.readMessage(LackedPlaceMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.lackedPlaceMap_.getMutableMap().put(lackedPlaceMap__.getKey(), lackedPlaceMap__.getValue());
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
                    this.lackedNpcList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.finishProgressList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.failProgressList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 16) != 0) {
                    this.lackedPlaceList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return QuestOuterClass.internal_static_Quest_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QuestOuterClass.internal_static_Quest_fieldAccessorTable.ensureFieldAccessorsInitialized(Quest.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public int getQuestId() {
            return this.questId_;
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public int getState() {
            return this.state_;
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public int getStartTime() {
            return this.startTime_;
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public boolean getIsRandom() {
            return this.isRandom_;
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public int getParentQuestId() {
            return this.parentQuestId_;
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public int getQuestConfigId() {
            return this.questConfigId_;
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public int getStartGameTime() {
            return this.startGameTime_;
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public int getAcceptTime() {
            return this.acceptTime_;
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public List<Integer> getLackedNpcListList() {
            return this.lackedNpcList_;
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public int getLackedNpcListCount() {
            return this.lackedNpcList_.size();
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public int getLackedNpcList(int index) {
            return this.lackedNpcList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public List<Integer> getFinishProgressListList() {
            return this.finishProgressList_;
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public int getFinishProgressListCount() {
            return this.finishProgressList_.size();
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public int getFinishProgressList(int index) {
            return this.finishProgressList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public List<Integer> getFailProgressListList() {
            return this.failProgressList_;
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public int getFailProgressListCount() {
            return this.failProgressList_.size();
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public int getFailProgressList(int index) {
            return this.failProgressList_.getInt(index);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestOuterClass$Quest$LackedNpcMapDefaultEntryHolder.class */
        public static final class LackedNpcMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(QuestOuterClass.internal_static_Quest_LackedNpcMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private LackedNpcMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetLackedNpcMap() {
            if (this.lackedNpcMap_ == null) {
                return MapField.emptyMapField(LackedNpcMapDefaultEntryHolder.defaultEntry);
            }
            return this.lackedNpcMap_;
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public int getLackedNpcMapCount() {
            return internalGetLackedNpcMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public boolean containsLackedNpcMap(int key) {
            return internalGetLackedNpcMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        @Deprecated
        public Map<Integer, Integer> getLackedNpcMap() {
            return getLackedNpcMapMap();
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public Map<Integer, Integer> getLackedNpcMapMap() {
            return internalGetLackedNpcMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public int getLackedNpcMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetLackedNpcMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public int getLackedNpcMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetLackedNpcMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public List<Integer> getLackedPlaceListList() {
            return this.lackedPlaceList_;
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public int getLackedPlaceListCount() {
            return this.lackedPlaceList_.size();
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public int getLackedPlaceList(int index) {
            return this.lackedPlaceList_.getInt(index);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestOuterClass$Quest$LackedPlaceMapDefaultEntryHolder.class */
        public static final class LackedPlaceMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(QuestOuterClass.internal_static_Quest_LackedPlaceMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private LackedPlaceMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetLackedPlaceMap() {
            if (this.lackedPlaceMap_ == null) {
                return MapField.emptyMapField(LackedPlaceMapDefaultEntryHolder.defaultEntry);
            }
            return this.lackedPlaceMap_;
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public int getLackedPlaceMapCount() {
            return internalGetLackedPlaceMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public boolean containsLackedPlaceMap(int key) {
            return internalGetLackedPlaceMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        @Deprecated
        public Map<Integer, Integer> getLackedPlaceMap() {
            return getLackedPlaceMapMap();
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public Map<Integer, Integer> getLackedPlaceMapMap() {
            return internalGetLackedPlaceMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public int getLackedPlaceMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetLackedPlaceMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
        public int getLackedPlaceMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetLackedPlaceMap().getMap();
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
            getSerializedSize();
            if (this.questId_ != 0) {
                output.writeUInt32(1, this.questId_);
            }
            if (this.state_ != 0) {
                output.writeUInt32(2, this.state_);
            }
            if (this.startTime_ != 0) {
                output.writeUInt32(4, this.startTime_);
            }
            if (this.isRandom_) {
                output.writeBool(5, this.isRandom_);
            }
            if (this.parentQuestId_ != 0) {
                output.writeUInt32(6, this.parentQuestId_);
            }
            if (this.questConfigId_ != 0) {
                output.writeUInt32(7, this.questConfigId_);
            }
            if (this.startGameTime_ != 0) {
                output.writeUInt32(8, this.startGameTime_);
            }
            if (this.acceptTime_ != 0) {
                output.writeUInt32(9, this.acceptTime_);
            }
            if (getLackedNpcListList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.lackedNpcListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.lackedNpcList_.size(); i++) {
                output.writeUInt32NoTag(this.lackedNpcList_.getInt(i));
            }
            if (getFinishProgressListList().size() > 0) {
                output.writeUInt32NoTag(90);
                output.writeUInt32NoTag(this.finishProgressListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.finishProgressList_.size(); i2++) {
                output.writeUInt32NoTag(this.finishProgressList_.getInt(i2));
            }
            if (getFailProgressListList().size() > 0) {
                output.writeUInt32NoTag(98);
                output.writeUInt32NoTag(this.failProgressListMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.failProgressList_.size(); i3++) {
                output.writeUInt32NoTag(this.failProgressList_.getInt(i3));
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetLackedNpcMap(), LackedNpcMapDefaultEntryHolder.defaultEntry, 13);
            if (getLackedPlaceListList().size() > 0) {
                output.writeUInt32NoTag(114);
                output.writeUInt32NoTag(this.lackedPlaceListMemoizedSerializedSize);
            }
            for (int i4 = 0; i4 < this.lackedPlaceList_.size(); i4++) {
                output.writeUInt32NoTag(this.lackedPlaceList_.getInt(i4));
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetLackedPlaceMap(), LackedPlaceMapDefaultEntryHolder.defaultEntry, 15);
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.questId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.questId_);
            }
            if (this.state_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.state_);
            }
            if (this.startTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.startTime_);
            }
            if (this.isRandom_) {
                size2 += CodedOutputStream.computeBoolSize(5, this.isRandom_);
            }
            if (this.parentQuestId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.parentQuestId_);
            }
            if (this.questConfigId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.questConfigId_);
            }
            if (this.startGameTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.startGameTime_);
            }
            if (this.acceptTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.acceptTime_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.lackedNpcList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.lackedNpcList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getLackedNpcListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.lackedNpcListMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.finishProgressList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.finishProgressList_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getFinishProgressListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.finishProgressListMemoizedSerializedSize = dataSize2;
            int dataSize3 = 0;
            for (int i3 = 0; i3 < this.failProgressList_.size(); i3++) {
                dataSize3 += CodedOutputStream.computeUInt32SizeNoTag(this.failProgressList_.getInt(i3));
            }
            int size5 = size4 + dataSize3;
            if (!getFailProgressListList().isEmpty()) {
                size5 = size5 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize3);
            }
            this.failProgressListMemoizedSerializedSize = dataSize3;
            for (Map.Entry<Integer, Integer> entry : internalGetLackedNpcMap().getMap().entrySet()) {
                size5 += CodedOutputStream.computeMessageSize(13, LackedNpcMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            int dataSize4 = 0;
            for (int i4 = 0; i4 < this.lackedPlaceList_.size(); i4++) {
                dataSize4 += CodedOutputStream.computeUInt32SizeNoTag(this.lackedPlaceList_.getInt(i4));
            }
            int size6 = size5 + dataSize4;
            if (!getLackedPlaceListList().isEmpty()) {
                size6 = size6 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize4);
            }
            this.lackedPlaceListMemoizedSerializedSize = dataSize4;
            for (Map.Entry<Integer, Integer> entry2 : internalGetLackedPlaceMap().getMap().entrySet()) {
                size6 += CodedOutputStream.computeMessageSize(15, LackedPlaceMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            int size7 = size6 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size7;
            return size7;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Quest)) {
                return equals(obj);
            }
            Quest other = (Quest) obj;
            return getQuestId() == other.getQuestId() && getState() == other.getState() && getStartTime() == other.getStartTime() && getIsRandom() == other.getIsRandom() && getParentQuestId() == other.getParentQuestId() && getQuestConfigId() == other.getQuestConfigId() && getStartGameTime() == other.getStartGameTime() && getAcceptTime() == other.getAcceptTime() && getLackedNpcListList().equals(other.getLackedNpcListList()) && getFinishProgressListList().equals(other.getFinishProgressListList()) && getFailProgressListList().equals(other.getFailProgressListList()) && internalGetLackedNpcMap().equals(other.internalGetLackedNpcMap()) && getLackedPlaceListList().equals(other.getLackedPlaceListList()) && internalGetLackedPlaceMap().equals(other.internalGetLackedPlaceMap()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getQuestId())) + 2)) + getState())) + 4)) + getStartTime())) + 5)) + Internal.hashBoolean(getIsRandom()))) + 6)) + getParentQuestId())) + 7)) + getQuestConfigId())) + 8)) + getStartGameTime())) + 9)) + getAcceptTime();
            if (getLackedNpcListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getLackedNpcListList().hashCode();
            }
            if (getFinishProgressListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getFinishProgressListList().hashCode();
            }
            if (getFailProgressListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getFailProgressListList().hashCode();
            }
            if (!internalGetLackedNpcMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 13)) + internalGetLackedNpcMap().hashCode();
            }
            if (getLackedPlaceListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getLackedPlaceListList().hashCode();
            }
            if (!internalGetLackedPlaceMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 15)) + internalGetLackedPlaceMap().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static Quest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Quest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Quest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Quest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Quest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Quest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Quest parseFrom(InputStream input) throws IOException {
            return (Quest) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Quest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Quest) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static Quest parseDelimitedFrom(InputStream input) throws IOException {
            return (Quest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static Quest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Quest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static Quest parseFrom(CodedInputStream input) throws IOException {
            return (Quest) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Quest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Quest) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Quest prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestOuterClass$Quest$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuestOrBuilder {
            private int bitField0_;
            private int questId_;
            private int state_;
            private int startTime_;
            private boolean isRandom_;
            private int parentQuestId_;
            private int questConfigId_;
            private int startGameTime_;
            private int acceptTime_;
            private MapField<Integer, Integer> lackedNpcMap_;
            private MapField<Integer, Integer> lackedPlaceMap_;
            private Internal.IntList lackedNpcList_ = Quest.emptyIntList();
            private Internal.IntList finishProgressList_ = Quest.emptyIntList();
            private Internal.IntList failProgressList_ = Quest.emptyIntList();
            private Internal.IntList lackedPlaceList_ = Quest.emptyIntList();

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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.QuestOuterClass.Quest.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 13: goto L_0x001c;
                        case 15: goto L_0x0021;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetLackedNpcMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetLackedPlaceMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.QuestOuterClass.Quest.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.QuestOuterClass.Quest.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 13: goto L_0x001c;
                        case 15: goto L_0x0021;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableLackedNpcMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableLackedPlaceMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.QuestOuterClass.Quest.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return QuestOuterClass.internal_static_Quest_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QuestOuterClass.internal_static_Quest_fieldAccessorTable.ensureFieldAccessorsInitialized(Quest.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Quest.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.questId_ = 0;
                this.state_ = 0;
                this.startTime_ = 0;
                this.isRandom_ = false;
                this.parentQuestId_ = 0;
                this.questConfigId_ = 0;
                this.startGameTime_ = 0;
                this.acceptTime_ = 0;
                this.lackedNpcList_ = Quest.emptyIntList();
                this.bitField0_ &= -2;
                this.finishProgressList_ = Quest.emptyIntList();
                this.bitField0_ &= -3;
                this.failProgressList_ = Quest.emptyIntList();
                this.bitField0_ &= -5;
                internalGetMutableLackedNpcMap().clear();
                this.lackedPlaceList_ = Quest.emptyIntList();
                this.bitField0_ &= -17;
                internalGetMutableLackedPlaceMap().clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QuestOuterClass.internal_static_Quest_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Quest getDefaultInstanceForType() {
                return Quest.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Quest build() {
                Quest result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Quest buildPartial() {
                Quest result = new Quest(this);
                int i = this.bitField0_;
                result.questId_ = this.questId_;
                result.state_ = this.state_;
                result.startTime_ = this.startTime_;
                result.isRandom_ = this.isRandom_;
                result.parentQuestId_ = this.parentQuestId_;
                result.questConfigId_ = this.questConfigId_;
                result.startGameTime_ = this.startGameTime_;
                result.acceptTime_ = this.acceptTime_;
                if ((this.bitField0_ & 1) != 0) {
                    this.lackedNpcList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.lackedNpcList_ = this.lackedNpcList_;
                if ((this.bitField0_ & 2) != 0) {
                    this.finishProgressList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.finishProgressList_ = this.finishProgressList_;
                if ((this.bitField0_ & 4) != 0) {
                    this.failProgressList_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.failProgressList_ = this.failProgressList_;
                result.lackedNpcMap_ = internalGetLackedNpcMap();
                result.lackedNpcMap_.makeImmutable();
                if ((this.bitField0_ & 16) != 0) {
                    this.lackedPlaceList_.makeImmutable();
                    this.bitField0_ &= -17;
                }
                result.lackedPlaceList_ = this.lackedPlaceList_;
                result.lackedPlaceMap_ = internalGetLackedPlaceMap();
                result.lackedPlaceMap_.makeImmutable();
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
                if (other instanceof Quest) {
                    return mergeFrom((Quest) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Quest other) {
                if (other == Quest.getDefaultInstance()) {
                    return this;
                }
                if (other.getQuestId() != 0) {
                    setQuestId(other.getQuestId());
                }
                if (other.getState() != 0) {
                    setState(other.getState());
                }
                if (other.getStartTime() != 0) {
                    setStartTime(other.getStartTime());
                }
                if (other.getIsRandom()) {
                    setIsRandom(other.getIsRandom());
                }
                if (other.getParentQuestId() != 0) {
                    setParentQuestId(other.getParentQuestId());
                }
                if (other.getQuestConfigId() != 0) {
                    setQuestConfigId(other.getQuestConfigId());
                }
                if (other.getStartGameTime() != 0) {
                    setStartGameTime(other.getStartGameTime());
                }
                if (other.getAcceptTime() != 0) {
                    setAcceptTime(other.getAcceptTime());
                }
                if (!other.lackedNpcList_.isEmpty()) {
                    if (this.lackedNpcList_.isEmpty()) {
                        this.lackedNpcList_ = other.lackedNpcList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureLackedNpcListIsMutable();
                        this.lackedNpcList_.addAll(other.lackedNpcList_);
                    }
                    onChanged();
                }
                if (!other.finishProgressList_.isEmpty()) {
                    if (this.finishProgressList_.isEmpty()) {
                        this.finishProgressList_ = other.finishProgressList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureFinishProgressListIsMutable();
                        this.finishProgressList_.addAll(other.finishProgressList_);
                    }
                    onChanged();
                }
                if (!other.failProgressList_.isEmpty()) {
                    if (this.failProgressList_.isEmpty()) {
                        this.failProgressList_ = other.failProgressList_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureFailProgressListIsMutable();
                        this.failProgressList_.addAll(other.failProgressList_);
                    }
                    onChanged();
                }
                internalGetMutableLackedNpcMap().mergeFrom(other.internalGetLackedNpcMap());
                if (!other.lackedPlaceList_.isEmpty()) {
                    if (this.lackedPlaceList_.isEmpty()) {
                        this.lackedPlaceList_ = other.lackedPlaceList_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureLackedPlaceListIsMutable();
                        this.lackedPlaceList_.addAll(other.lackedPlaceList_);
                    }
                    onChanged();
                }
                internalGetMutableLackedPlaceMap().mergeFrom(other.internalGetLackedPlaceMap());
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
                Quest parsedMessage = null;
                try {
                    try {
                        parsedMessage = Quest.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (Quest) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public int getQuestId() {
                return this.questId_;
            }

            public Builder setQuestId(int value) {
                this.questId_ = value;
                onChanged();
                return this;
            }

            public Builder clearQuestId() {
                this.questId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public int getState() {
                return this.state_;
            }

            public Builder setState(int value) {
                this.state_ = value;
                onChanged();
                return this;
            }

            public Builder clearState() {
                this.state_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public int getStartTime() {
                return this.startTime_;
            }

            public Builder setStartTime(int value) {
                this.startTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearStartTime() {
                this.startTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
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

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
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

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public int getQuestConfigId() {
                return this.questConfigId_;
            }

            public Builder setQuestConfigId(int value) {
                this.questConfigId_ = value;
                onChanged();
                return this;
            }

            public Builder clearQuestConfigId() {
                this.questConfigId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public int getStartGameTime() {
                return this.startGameTime_;
            }

            public Builder setStartGameTime(int value) {
                this.startGameTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearStartGameTime() {
                this.startGameTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public int getAcceptTime() {
                return this.acceptTime_;
            }

            public Builder setAcceptTime(int value) {
                this.acceptTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearAcceptTime() {
                this.acceptTime_ = 0;
                onChanged();
                return this;
            }

            private void ensureLackedNpcListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.lackedNpcList_ = Quest.mutableCopy(this.lackedNpcList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public List<Integer> getLackedNpcListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.lackedNpcList_) : this.lackedNpcList_;
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public int getLackedNpcListCount() {
                return this.lackedNpcList_.size();
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public int getLackedNpcList(int index) {
                return this.lackedNpcList_.getInt(index);
            }

            public Builder setLackedNpcList(int index, int value) {
                ensureLackedNpcListIsMutable();
                this.lackedNpcList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addLackedNpcList(int value) {
                ensureLackedNpcListIsMutable();
                this.lackedNpcList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllLackedNpcList(Iterable<? extends Integer> values) {
                ensureLackedNpcListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.lackedNpcList_);
                onChanged();
                return this;
            }

            public Builder clearLackedNpcList() {
                this.lackedNpcList_ = Quest.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureFinishProgressListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.finishProgressList_ = Quest.mutableCopy(this.finishProgressList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public List<Integer> getFinishProgressListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.finishProgressList_) : this.finishProgressList_;
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public int getFinishProgressListCount() {
                return this.finishProgressList_.size();
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public int getFinishProgressList(int index) {
                return this.finishProgressList_.getInt(index);
            }

            public Builder setFinishProgressList(int index, int value) {
                ensureFinishProgressListIsMutable();
                this.finishProgressList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addFinishProgressList(int value) {
                ensureFinishProgressListIsMutable();
                this.finishProgressList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllFinishProgressList(Iterable<? extends Integer> values) {
                ensureFinishProgressListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.finishProgressList_);
                onChanged();
                return this;
            }

            public Builder clearFinishProgressList() {
                this.finishProgressList_ = Quest.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            private void ensureFailProgressListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.failProgressList_ = Quest.mutableCopy(this.failProgressList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public List<Integer> getFailProgressListList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.failProgressList_) : this.failProgressList_;
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public int getFailProgressListCount() {
                return this.failProgressList_.size();
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public int getFailProgressList(int index) {
                return this.failProgressList_.getInt(index);
            }

            public Builder setFailProgressList(int index, int value) {
                ensureFailProgressListIsMutable();
                this.failProgressList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addFailProgressList(int value) {
                ensureFailProgressListIsMutable();
                this.failProgressList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllFailProgressList(Iterable<? extends Integer> values) {
                ensureFailProgressListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.failProgressList_);
                onChanged();
                return this;
            }

            public Builder clearFailProgressList() {
                this.failProgressList_ = Quest.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetLackedNpcMap() {
                if (this.lackedNpcMap_ == null) {
                    return MapField.emptyMapField(LackedNpcMapDefaultEntryHolder.defaultEntry);
                }
                return this.lackedNpcMap_;
            }

            private MapField<Integer, Integer> internalGetMutableLackedNpcMap() {
                onChanged();
                if (this.lackedNpcMap_ == null) {
                    this.lackedNpcMap_ = MapField.newMapField(LackedNpcMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.lackedNpcMap_.isMutable()) {
                    this.lackedNpcMap_ = this.lackedNpcMap_.copy();
                }
                return this.lackedNpcMap_;
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public int getLackedNpcMapCount() {
                return internalGetLackedNpcMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public boolean containsLackedNpcMap(int key) {
                return internalGetLackedNpcMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            @Deprecated
            public Map<Integer, Integer> getLackedNpcMap() {
                return getLackedNpcMapMap();
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public Map<Integer, Integer> getLackedNpcMapMap() {
                return internalGetLackedNpcMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public int getLackedNpcMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetLackedNpcMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public int getLackedNpcMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetLackedNpcMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearLackedNpcMap() {
                internalGetMutableLackedNpcMap().getMutableMap().clear();
                return this;
            }

            public Builder removeLackedNpcMap(int key) {
                internalGetMutableLackedNpcMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableLackedNpcMap() {
                return internalGetMutableLackedNpcMap().getMutableMap();
            }

            public Builder putLackedNpcMap(int key, int value) {
                internalGetMutableLackedNpcMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllLackedNpcMap(Map<Integer, Integer> values) {
                internalGetMutableLackedNpcMap().getMutableMap().putAll(values);
                return this;
            }

            private void ensureLackedPlaceListIsMutable() {
                if ((this.bitField0_ & 16) == 0) {
                    this.lackedPlaceList_ = Quest.mutableCopy(this.lackedPlaceList_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public List<Integer> getLackedPlaceListList() {
                return (this.bitField0_ & 16) != 0 ? Collections.unmodifiableList(this.lackedPlaceList_) : this.lackedPlaceList_;
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public int getLackedPlaceListCount() {
                return this.lackedPlaceList_.size();
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public int getLackedPlaceList(int index) {
                return this.lackedPlaceList_.getInt(index);
            }

            public Builder setLackedPlaceList(int index, int value) {
                ensureLackedPlaceListIsMutable();
                this.lackedPlaceList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addLackedPlaceList(int value) {
                ensureLackedPlaceListIsMutable();
                this.lackedPlaceList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllLackedPlaceList(Iterable<? extends Integer> values) {
                ensureLackedPlaceListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.lackedPlaceList_);
                onChanged();
                return this;
            }

            public Builder clearLackedPlaceList() {
                this.lackedPlaceList_ = Quest.emptyIntList();
                this.bitField0_ &= -17;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetLackedPlaceMap() {
                if (this.lackedPlaceMap_ == null) {
                    return MapField.emptyMapField(LackedPlaceMapDefaultEntryHolder.defaultEntry);
                }
                return this.lackedPlaceMap_;
            }

            private MapField<Integer, Integer> internalGetMutableLackedPlaceMap() {
                onChanged();
                if (this.lackedPlaceMap_ == null) {
                    this.lackedPlaceMap_ = MapField.newMapField(LackedPlaceMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.lackedPlaceMap_.isMutable()) {
                    this.lackedPlaceMap_ = this.lackedPlaceMap_.copy();
                }
                return this.lackedPlaceMap_;
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public int getLackedPlaceMapCount() {
                return internalGetLackedPlaceMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public boolean containsLackedPlaceMap(int key) {
                return internalGetLackedPlaceMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            @Deprecated
            public Map<Integer, Integer> getLackedPlaceMap() {
                return getLackedPlaceMapMap();
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public Map<Integer, Integer> getLackedPlaceMapMap() {
                return internalGetLackedPlaceMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public int getLackedPlaceMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetLackedPlaceMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.QuestOuterClass.QuestOrBuilder
            public int getLackedPlaceMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetLackedPlaceMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearLackedPlaceMap() {
                internalGetMutableLackedPlaceMap().getMutableMap().clear();
                return this;
            }

            public Builder removeLackedPlaceMap(int key) {
                internalGetMutableLackedPlaceMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableLackedPlaceMap() {
                return internalGetMutableLackedPlaceMap().getMutableMap();
            }

            public Builder putLackedPlaceMap(int key, int value) {
                internalGetMutableLackedPlaceMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllLackedPlaceMap(Map<Integer, Integer> values) {
                internalGetMutableLackedPlaceMap().getMutableMap().putAll(values);
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

        public static Quest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Quest> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Quest> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Quest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
