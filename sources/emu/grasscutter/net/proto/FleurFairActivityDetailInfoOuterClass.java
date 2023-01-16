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
import emu.grasscutter.net.proto.FleurFairChapterInfoOuterClass;
import emu.grasscutter.net.proto.FleurFairDungeonSectionInfoOuterClass;
import emu.grasscutter.net.proto.FleurFairMinigameInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairActivityDetailInfoOuterClass.class */
public final class FleurFairActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!FleurFairActivityDetailInfo.proto\u001a\u001aFleurFairChapterInfo.proto\u001a!FleurFairDungeonSectionInfo.proto\u001a\u001bFleurFairMinigameInfo.proto\"²\u0004\n\u001bFleurFairActivityDetailInfo\u0012\u001b\n\u0013Unk3300_KONOCAMIIIE\u0018\u0003 \u0001(\r\u00120\n\u0011chapter_info_list\u0018\u0005 \u0003(\u000b2\u0015.FleurFairChapterInfo\u0012\u001b\n\u0013is_dungeon_unlocked\u0018\u0006 \u0001(\b\u0012Y\n\u0018dungeon_section_info_map\u0018\b \u0003(\u000b27.FleurFairActivityDetailInfo.DungeonSectionInfoMapEntry\u0012\u0019\n\u0011is_content_closed\u0018\r \u0001(\b\u0012L\n\u0011minigame_info_map\u0018\t \u0003(\u000b21.FleurFairActivityDetailInfo.MinigameInfoMapEntry\u0012\u001b\n\u0013Unk3300_LOFLGOOIMNH\u0018\n \u0001(\r\u0012\u001a\n\u0012content_close_time\u0018\u0004 \u0001(\r\u001aZ\n\u001aDungeonSectionInfoMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012+\n\u0005value\u0018\u0002 \u0001(\u000b2\u001c.FleurFairDungeonSectionInfo:\u00028\u0001\u001aN\n\u0014MinigameInfoMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012%\n\u0005value\u0018\u0002 \u0001(\u000b2\u0016.FleurFairMinigameInfo:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FleurFairChapterInfoOuterClass.getDescriptor(), FleurFairDungeonSectionInfoOuterClass.getDescriptor(), FleurFairMinigameInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FleurFairActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FleurFairActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FleurFairActivityDetailInfo_descriptor, new String[]{"Unk3300KONOCAMIIIE", "ChapterInfoList", "IsDungeonUnlocked", "DungeonSectionInfoMap", "IsContentClosed", "MinigameInfoMap", "Unk3300LOFLGOOIMNH", "ContentCloseTime"});

    /* renamed from: internal_static_FleurFairActivityDetailInfo_DungeonSectionInfoMapEntry_descriptor */
    private static final Descriptors.Descriptor f711xfbce079f = internal_static_FleurFairActivityDetailInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_FleurFairActivityDetailInfo_DungeonSectionInfoMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f712x66c71f1d = new GeneratedMessageV3.FieldAccessorTable(f711xfbce079f, new String[]{"Key", "Value"});

    /* renamed from: internal_static_FleurFairActivityDetailInfo_MinigameInfoMapEntry_descriptor */
    private static final Descriptors.Descriptor f713xebd4cbe1 = internal_static_FleurFairActivityDetailInfo_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_FleurFairActivityDetailInfo_MinigameInfoMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f714x8f6e815f = new GeneratedMessageV3.FieldAccessorTable(f713xebd4cbe1, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairActivityDetailInfoOuterClass$FleurFairActivityDetailInfoOrBuilder.class */
    public interface FleurFairActivityDetailInfoOrBuilder extends MessageOrBuilder {
        int getUnk3300KONOCAMIIIE();

        List<FleurFairChapterInfoOuterClass.FleurFairChapterInfo> getChapterInfoListList();

        FleurFairChapterInfoOuterClass.FleurFairChapterInfo getChapterInfoList(int i);

        int getChapterInfoListCount();

        List<? extends FleurFairChapterInfoOuterClass.FleurFairChapterInfoOrBuilder> getChapterInfoListOrBuilderList();

        FleurFairChapterInfoOuterClass.FleurFairChapterInfoOrBuilder getChapterInfoListOrBuilder(int i);

        boolean getIsDungeonUnlocked();

        int getDungeonSectionInfoMapCount();

        boolean containsDungeonSectionInfoMap(int i);

        @Deprecated
        Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> getDungeonSectionInfoMap();

        Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> getDungeonSectionInfoMapMap();

        FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo getDungeonSectionInfoMapOrDefault(int i, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo fleurFairDungeonSectionInfo);

        FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo getDungeonSectionInfoMapOrThrow(int i);

        boolean getIsContentClosed();

        int getMinigameInfoMapCount();

        boolean containsMinigameInfoMap(int i);

        @Deprecated
        Map<Integer, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo> getMinigameInfoMap();

        Map<Integer, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo> getMinigameInfoMapMap();

        FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo getMinigameInfoMapOrDefault(int i, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo fleurFairMinigameInfo);

        FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo getMinigameInfoMapOrThrow(int i);

        int getUnk3300LOFLGOOIMNH();

        int getContentCloseTime();
    }

    private FleurFairActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairActivityDetailInfoOuterClass$FleurFairActivityDetailInfo.class */
    public static final class FleurFairActivityDetailInfo extends GeneratedMessageV3 implements FleurFairActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_KONOCAMIIIE_FIELD_NUMBER = 3;
        private int unk3300KONOCAMIIIE_;
        public static final int CHAPTER_INFO_LIST_FIELD_NUMBER = 5;
        private List<FleurFairChapterInfoOuterClass.FleurFairChapterInfo> chapterInfoList_;
        public static final int IS_DUNGEON_UNLOCKED_FIELD_NUMBER = 6;
        private boolean isDungeonUnlocked_;
        public static final int DUNGEON_SECTION_INFO_MAP_FIELD_NUMBER = 8;
        private MapField<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> dungeonSectionInfoMap_;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 13;
        private boolean isContentClosed_;
        public static final int MINIGAME_INFO_MAP_FIELD_NUMBER = 9;
        private MapField<Integer, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo> minigameInfoMap_;
        public static final int UNK3300_LOFLGOOIMNH_FIELD_NUMBER = 10;
        private int unk3300LOFLGOOIMNH_;
        public static final int CONTENT_CLOSE_TIME_FIELD_NUMBER = 4;
        private int contentCloseTime_;
        private byte memoizedIsInitialized;
        private static final FleurFairActivityDetailInfo DEFAULT_INSTANCE = new FleurFairActivityDetailInfo();
        private static final Parser<FleurFairActivityDetailInfo> PARSER = new AbstractParser<FleurFairActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public FleurFairActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FleurFairActivityDetailInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 8: goto L_0x001c;
                    case 9: goto L_0x0021;
                    default: goto L_0x0026;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetDungeonSectionInfoMap()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetMinigameInfoMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private FleurFairActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FleurFairActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.chapterInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FleurFairActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FleurFairActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.unk3300KONOCAMIIIE_ = input.readUInt32();
                                break;
                            case 32:
                                this.contentCloseTime_ = input.readUInt32();
                                break;
                            case 42:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.chapterInfoList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.chapterInfoList_.add((FleurFairChapterInfoOuterClass.FleurFairChapterInfo) input.readMessage(FleurFairChapterInfoOuterClass.FleurFairChapterInfo.parser(), extensionRegistry));
                                break;
                            case 48:
                                this.isDungeonUnlocked_ = input.readBool();
                                break;
                            case 66:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.dungeonSectionInfoMap_ = MapField.newMapField(DungeonSectionInfoMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 2;
                                }
                                MapEntry<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> dungeonSectionInfoMap__ = (MapEntry) input.readMessage(DungeonSectionInfoMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.dungeonSectionInfoMap_.getMutableMap().put(dungeonSectionInfoMap__.getKey(), dungeonSectionInfoMap__.getValue());
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.minigameInfoMap_ = MapField.newMapField(MinigameInfoMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 4;
                                }
                                MapEntry<Integer, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo> minigameInfoMap__ = (MapEntry) input.readMessage(MinigameInfoMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.minigameInfoMap_.getMutableMap().put(minigameInfoMap__.getKey(), minigameInfoMap__.getValue());
                                break;
                            case 80:
                                this.unk3300LOFLGOOIMNH_ = input.readUInt32();
                                break;
                            case 104:
                                this.isContentClosed_ = input.readBool();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.chapterInfoList_ = Collections.unmodifiableList(this.chapterInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FleurFairActivityDetailInfoOuterClass.internal_static_FleurFairActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FleurFairActivityDetailInfoOuterClass.internal_static_FleurFairActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FleurFairActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
        public int getUnk3300KONOCAMIIIE() {
            return this.unk3300KONOCAMIIIE_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
        public List<FleurFairChapterInfoOuterClass.FleurFairChapterInfo> getChapterInfoListList() {
            return this.chapterInfoList_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
        public List<? extends FleurFairChapterInfoOuterClass.FleurFairChapterInfoOrBuilder> getChapterInfoListOrBuilderList() {
            return this.chapterInfoList_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
        public int getChapterInfoListCount() {
            return this.chapterInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
        public FleurFairChapterInfoOuterClass.FleurFairChapterInfo getChapterInfoList(int index) {
            return this.chapterInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
        public FleurFairChapterInfoOuterClass.FleurFairChapterInfoOrBuilder getChapterInfoListOrBuilder(int index) {
            return this.chapterInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
        public boolean getIsDungeonUnlocked() {
            return this.isDungeonUnlocked_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairActivityDetailInfoOuterClass$FleurFairActivityDetailInfo$DungeonSectionInfoMapDefaultEntryHolder.class */
        public static final class DungeonSectionInfoMapDefaultEntryHolder {
            static final MapEntry<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> defaultEntry = MapEntry.newDefaultInstance(FleurFairActivityDetailInfoOuterClass.f711xfbce079f, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo.getDefaultInstance());

            private DungeonSectionInfoMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> internalGetDungeonSectionInfoMap() {
            if (this.dungeonSectionInfoMap_ == null) {
                return MapField.emptyMapField(DungeonSectionInfoMapDefaultEntryHolder.defaultEntry);
            }
            return this.dungeonSectionInfoMap_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
        public int getDungeonSectionInfoMapCount() {
            return internalGetDungeonSectionInfoMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
        public boolean containsDungeonSectionInfoMap(int key) {
            return internalGetDungeonSectionInfoMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
        @Deprecated
        public Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> getDungeonSectionInfoMap() {
            return getDungeonSectionInfoMapMap();
        }

        @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
        public Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> getDungeonSectionInfoMapMap() {
            return internalGetDungeonSectionInfoMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
        public FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo getDungeonSectionInfoMapOrDefault(int key, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo defaultValue) {
            Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> map = internalGetDungeonSectionInfoMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
        public FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo getDungeonSectionInfoMapOrThrow(int key) {
            Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> map = internalGetDungeonSectionInfoMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairActivityDetailInfoOuterClass$FleurFairActivityDetailInfo$MinigameInfoMapDefaultEntryHolder.class */
        public static final class MinigameInfoMapDefaultEntryHolder {
            static final MapEntry<Integer, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo> defaultEntry = MapEntry.newDefaultInstance(FleurFairActivityDetailInfoOuterClass.f713xebd4cbe1, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo.getDefaultInstance());

            private MinigameInfoMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo> internalGetMinigameInfoMap() {
            if (this.minigameInfoMap_ == null) {
                return MapField.emptyMapField(MinigameInfoMapDefaultEntryHolder.defaultEntry);
            }
            return this.minigameInfoMap_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
        public int getMinigameInfoMapCount() {
            return internalGetMinigameInfoMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
        public boolean containsMinigameInfoMap(int key) {
            return internalGetMinigameInfoMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
        @Deprecated
        public Map<Integer, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo> getMinigameInfoMap() {
            return getMinigameInfoMapMap();
        }

        @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
        public Map<Integer, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo> getMinigameInfoMapMap() {
            return internalGetMinigameInfoMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
        public FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo getMinigameInfoMapOrDefault(int key, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo defaultValue) {
            Map<Integer, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo> map = internalGetMinigameInfoMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
        public FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo getMinigameInfoMapOrThrow(int key) {
            Map<Integer, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo> map = internalGetMinigameInfoMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
        public int getUnk3300LOFLGOOIMNH() {
            return this.unk3300LOFLGOOIMNH_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
        public int getContentCloseTime() {
            return this.contentCloseTime_;
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
            if (this.unk3300KONOCAMIIIE_ != 0) {
                output.writeUInt32(3, this.unk3300KONOCAMIIIE_);
            }
            if (this.contentCloseTime_ != 0) {
                output.writeUInt32(4, this.contentCloseTime_);
            }
            for (int i = 0; i < this.chapterInfoList_.size(); i++) {
                output.writeMessage(5, this.chapterInfoList_.get(i));
            }
            if (this.isDungeonUnlocked_) {
                output.writeBool(6, this.isDungeonUnlocked_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetDungeonSectionInfoMap(), DungeonSectionInfoMapDefaultEntryHolder.defaultEntry, 8);
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetMinigameInfoMap(), MinigameInfoMapDefaultEntryHolder.defaultEntry, 9);
            if (this.unk3300LOFLGOOIMNH_ != 0) {
                output.writeUInt32(10, this.unk3300LOFLGOOIMNH_);
            }
            if (this.isContentClosed_) {
                output.writeBool(13, this.isContentClosed_);
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
            if (this.unk3300KONOCAMIIIE_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.unk3300KONOCAMIIIE_);
            }
            if (this.contentCloseTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.contentCloseTime_);
            }
            for (int i = 0; i < this.chapterInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.chapterInfoList_.get(i));
            }
            if (this.isDungeonUnlocked_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.isDungeonUnlocked_);
            }
            for (Map.Entry<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> entry : internalGetDungeonSectionInfoMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(8, DungeonSectionInfoMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            for (Map.Entry<Integer, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo> entry2 : internalGetMinigameInfoMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(9, MinigameInfoMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            if (this.unk3300LOFLGOOIMNH_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.unk3300LOFLGOOIMNH_);
            }
            if (this.isContentClosed_) {
                size2 += CodedOutputStream.computeBoolSize(13, this.isContentClosed_);
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
            if (!(obj instanceof FleurFairActivityDetailInfo)) {
                return equals(obj);
            }
            FleurFairActivityDetailInfo other = (FleurFairActivityDetailInfo) obj;
            return getUnk3300KONOCAMIIIE() == other.getUnk3300KONOCAMIIIE() && getChapterInfoListList().equals(other.getChapterInfoListList()) && getIsDungeonUnlocked() == other.getIsDungeonUnlocked() && internalGetDungeonSectionInfoMap().equals(other.internalGetDungeonSectionInfoMap()) && getIsContentClosed() == other.getIsContentClosed() && internalGetMinigameInfoMap().equals(other.internalGetMinigameInfoMap()) && getUnk3300LOFLGOOIMNH() == other.getUnk3300LOFLGOOIMNH() && getContentCloseTime() == other.getContentCloseTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getUnk3300KONOCAMIIIE();
            if (getChapterInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getChapterInfoListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 6)) + Internal.hashBoolean(getIsDungeonUnlocked());
            if (!internalGetDungeonSectionInfoMap().getMap().isEmpty()) {
                hash2 = (53 * ((37 * hash2) + 8)) + internalGetDungeonSectionInfoMap().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 13)) + Internal.hashBoolean(getIsContentClosed());
            if (!internalGetMinigameInfoMap().getMap().isEmpty()) {
                hash3 = (53 * ((37 * hash3) + 9)) + internalGetMinigameInfoMap().hashCode();
            }
            int hash4 = (29 * ((53 * ((37 * ((53 * ((37 * hash3) + 10)) + getUnk3300LOFLGOOIMNH())) + 4)) + getContentCloseTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static FleurFairActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FleurFairActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FleurFairActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FleurFairActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FleurFairActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FleurFairActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FleurFairActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (FleurFairActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FleurFairActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FleurFairActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FleurFairActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (FleurFairActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FleurFairActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FleurFairActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FleurFairActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (FleurFairActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FleurFairActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FleurFairActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FleurFairActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairActivityDetailInfoOuterClass$FleurFairActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FleurFairActivityDetailInfoOrBuilder {
            private int bitField0_;
            private int unk3300KONOCAMIIIE_;
            private List<FleurFairChapterInfoOuterClass.FleurFairChapterInfo> chapterInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<FleurFairChapterInfoOuterClass.FleurFairChapterInfo, FleurFairChapterInfoOuterClass.FleurFairChapterInfo.Builder, FleurFairChapterInfoOuterClass.FleurFairChapterInfoOrBuilder> chapterInfoListBuilder_;
            private boolean isDungeonUnlocked_;
            private MapField<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> dungeonSectionInfoMap_;
            private boolean isContentClosed_;
            private MapField<Integer, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo> minigameInfoMap_;
            private int unk3300LOFLGOOIMNH_;
            private int contentCloseTime_;

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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 8: goto L_0x001c;
                        case 9: goto L_0x0021;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetDungeonSectionInfoMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMinigameInfoMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 8: goto L_0x001c;
                        case 9: goto L_0x0021;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableDungeonSectionInfoMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableMinigameInfoMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return FleurFairActivityDetailInfoOuterClass.internal_static_FleurFairActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FleurFairActivityDetailInfoOuterClass.internal_static_FleurFairActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FleurFairActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FleurFairActivityDetailInfo.alwaysUseFieldBuilders) {
                    getChapterInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300KONOCAMIIIE_ = 0;
                if (this.chapterInfoListBuilder_ == null) {
                    this.chapterInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.chapterInfoListBuilder_.clear();
                }
                this.isDungeonUnlocked_ = false;
                internalGetMutableDungeonSectionInfoMap().clear();
                this.isContentClosed_ = false;
                internalGetMutableMinigameInfoMap().clear();
                this.unk3300LOFLGOOIMNH_ = 0;
                this.contentCloseTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FleurFairActivityDetailInfoOuterClass.internal_static_FleurFairActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FleurFairActivityDetailInfo getDefaultInstanceForType() {
                return FleurFairActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FleurFairActivityDetailInfo build() {
                FleurFairActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FleurFairActivityDetailInfo buildPartial() {
                FleurFairActivityDetailInfo result = new FleurFairActivityDetailInfo(this);
                int i = this.bitField0_;
                result.unk3300KONOCAMIIIE_ = this.unk3300KONOCAMIIIE_;
                if (this.chapterInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.chapterInfoList_ = Collections.unmodifiableList(this.chapterInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.chapterInfoList_ = this.chapterInfoList_;
                } else {
                    result.chapterInfoList_ = this.chapterInfoListBuilder_.build();
                }
                result.isDungeonUnlocked_ = this.isDungeonUnlocked_;
                result.dungeonSectionInfoMap_ = internalGetDungeonSectionInfoMap();
                result.dungeonSectionInfoMap_.makeImmutable();
                result.isContentClosed_ = this.isContentClosed_;
                result.minigameInfoMap_ = internalGetMinigameInfoMap();
                result.minigameInfoMap_.makeImmutable();
                result.unk3300LOFLGOOIMNH_ = this.unk3300LOFLGOOIMNH_;
                result.contentCloseTime_ = this.contentCloseTime_;
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
                if (other instanceof FleurFairActivityDetailInfo) {
                    return mergeFrom((FleurFairActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FleurFairActivityDetailInfo other) {
                if (other == FleurFairActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300KONOCAMIIIE() != 0) {
                    setUnk3300KONOCAMIIIE(other.getUnk3300KONOCAMIIIE());
                }
                if (this.chapterInfoListBuilder_ == null) {
                    if (!other.chapterInfoList_.isEmpty()) {
                        if (this.chapterInfoList_.isEmpty()) {
                            this.chapterInfoList_ = other.chapterInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureChapterInfoListIsMutable();
                            this.chapterInfoList_.addAll(other.chapterInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.chapterInfoList_.isEmpty()) {
                    if (this.chapterInfoListBuilder_.isEmpty()) {
                        this.chapterInfoListBuilder_.dispose();
                        this.chapterInfoListBuilder_ = null;
                        this.chapterInfoList_ = other.chapterInfoList_;
                        this.bitField0_ &= -2;
                        this.chapterInfoListBuilder_ = FleurFairActivityDetailInfo.alwaysUseFieldBuilders ? getChapterInfoListFieldBuilder() : null;
                    } else {
                        this.chapterInfoListBuilder_.addAllMessages(other.chapterInfoList_);
                    }
                }
                if (other.getIsDungeonUnlocked()) {
                    setIsDungeonUnlocked(other.getIsDungeonUnlocked());
                }
                internalGetMutableDungeonSectionInfoMap().mergeFrom(other.internalGetDungeonSectionInfoMap());
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
                }
                internalGetMutableMinigameInfoMap().mergeFrom(other.internalGetMinigameInfoMap());
                if (other.getUnk3300LOFLGOOIMNH() != 0) {
                    setUnk3300LOFLGOOIMNH(other.getUnk3300LOFLGOOIMNH());
                }
                if (other.getContentCloseTime() != 0) {
                    setContentCloseTime(other.getContentCloseTime());
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
                FleurFairActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = FleurFairActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FleurFairActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
            public int getUnk3300KONOCAMIIIE() {
                return this.unk3300KONOCAMIIIE_;
            }

            public Builder setUnk3300KONOCAMIIIE(int value) {
                this.unk3300KONOCAMIIIE_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300KONOCAMIIIE() {
                this.unk3300KONOCAMIIIE_ = 0;
                onChanged();
                return this;
            }

            private void ensureChapterInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.chapterInfoList_ = new ArrayList(this.chapterInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
            public List<FleurFairChapterInfoOuterClass.FleurFairChapterInfo> getChapterInfoListList() {
                if (this.chapterInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.chapterInfoList_);
                }
                return this.chapterInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
            public int getChapterInfoListCount() {
                if (this.chapterInfoListBuilder_ == null) {
                    return this.chapterInfoList_.size();
                }
                return this.chapterInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
            public FleurFairChapterInfoOuterClass.FleurFairChapterInfo getChapterInfoList(int index) {
                if (this.chapterInfoListBuilder_ == null) {
                    return this.chapterInfoList_.get(index);
                }
                return this.chapterInfoListBuilder_.getMessage(index);
            }

            public Builder setChapterInfoList(int index, FleurFairChapterInfoOuterClass.FleurFairChapterInfo value) {
                if (this.chapterInfoListBuilder_ != null) {
                    this.chapterInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChapterInfoListIsMutable();
                    this.chapterInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setChapterInfoList(int index, FleurFairChapterInfoOuterClass.FleurFairChapterInfo.Builder builderForValue) {
                if (this.chapterInfoListBuilder_ == null) {
                    ensureChapterInfoListIsMutable();
                    this.chapterInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.chapterInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addChapterInfoList(FleurFairChapterInfoOuterClass.FleurFairChapterInfo value) {
                if (this.chapterInfoListBuilder_ != null) {
                    this.chapterInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChapterInfoListIsMutable();
                    this.chapterInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addChapterInfoList(int index, FleurFairChapterInfoOuterClass.FleurFairChapterInfo value) {
                if (this.chapterInfoListBuilder_ != null) {
                    this.chapterInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChapterInfoListIsMutable();
                    this.chapterInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addChapterInfoList(FleurFairChapterInfoOuterClass.FleurFairChapterInfo.Builder builderForValue) {
                if (this.chapterInfoListBuilder_ == null) {
                    ensureChapterInfoListIsMutable();
                    this.chapterInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.chapterInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addChapterInfoList(int index, FleurFairChapterInfoOuterClass.FleurFairChapterInfo.Builder builderForValue) {
                if (this.chapterInfoListBuilder_ == null) {
                    ensureChapterInfoListIsMutable();
                    this.chapterInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.chapterInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllChapterInfoList(Iterable<? extends FleurFairChapterInfoOuterClass.FleurFairChapterInfo> values) {
                if (this.chapterInfoListBuilder_ == null) {
                    ensureChapterInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.chapterInfoList_);
                    onChanged();
                } else {
                    this.chapterInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearChapterInfoList() {
                if (this.chapterInfoListBuilder_ == null) {
                    this.chapterInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.chapterInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeChapterInfoList(int index) {
                if (this.chapterInfoListBuilder_ == null) {
                    ensureChapterInfoListIsMutable();
                    this.chapterInfoList_.remove(index);
                    onChanged();
                } else {
                    this.chapterInfoListBuilder_.remove(index);
                }
                return this;
            }

            public FleurFairChapterInfoOuterClass.FleurFairChapterInfo.Builder getChapterInfoListBuilder(int index) {
                return getChapterInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
            public FleurFairChapterInfoOuterClass.FleurFairChapterInfoOrBuilder getChapterInfoListOrBuilder(int index) {
                if (this.chapterInfoListBuilder_ == null) {
                    return this.chapterInfoList_.get(index);
                }
                return this.chapterInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
            public List<? extends FleurFairChapterInfoOuterClass.FleurFairChapterInfoOrBuilder> getChapterInfoListOrBuilderList() {
                if (this.chapterInfoListBuilder_ != null) {
                    return this.chapterInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.chapterInfoList_);
            }

            public FleurFairChapterInfoOuterClass.FleurFairChapterInfo.Builder addChapterInfoListBuilder() {
                return getChapterInfoListFieldBuilder().addBuilder(FleurFairChapterInfoOuterClass.FleurFairChapterInfo.getDefaultInstance());
            }

            public FleurFairChapterInfoOuterClass.FleurFairChapterInfo.Builder addChapterInfoListBuilder(int index) {
                return getChapterInfoListFieldBuilder().addBuilder(index, FleurFairChapterInfoOuterClass.FleurFairChapterInfo.getDefaultInstance());
            }

            public List<FleurFairChapterInfoOuterClass.FleurFairChapterInfo.Builder> getChapterInfoListBuilderList() {
                return getChapterInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FleurFairChapterInfoOuterClass.FleurFairChapterInfo, FleurFairChapterInfoOuterClass.FleurFairChapterInfo.Builder, FleurFairChapterInfoOuterClass.FleurFairChapterInfoOrBuilder> getChapterInfoListFieldBuilder() {
                if (this.chapterInfoListBuilder_ == null) {
                    this.chapterInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.chapterInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.chapterInfoList_ = null;
                }
                return this.chapterInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
            public boolean getIsDungeonUnlocked() {
                return this.isDungeonUnlocked_;
            }

            public Builder setIsDungeonUnlocked(boolean value) {
                this.isDungeonUnlocked_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsDungeonUnlocked() {
                this.isDungeonUnlocked_ = false;
                onChanged();
                return this;
            }

            private MapField<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> internalGetDungeonSectionInfoMap() {
                if (this.dungeonSectionInfoMap_ == null) {
                    return MapField.emptyMapField(DungeonSectionInfoMapDefaultEntryHolder.defaultEntry);
                }
                return this.dungeonSectionInfoMap_;
            }

            private MapField<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> internalGetMutableDungeonSectionInfoMap() {
                onChanged();
                if (this.dungeonSectionInfoMap_ == null) {
                    this.dungeonSectionInfoMap_ = MapField.newMapField(DungeonSectionInfoMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.dungeonSectionInfoMap_.isMutable()) {
                    this.dungeonSectionInfoMap_ = this.dungeonSectionInfoMap_.copy();
                }
                return this.dungeonSectionInfoMap_;
            }

            @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
            public int getDungeonSectionInfoMapCount() {
                return internalGetDungeonSectionInfoMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
            public boolean containsDungeonSectionInfoMap(int key) {
                return internalGetDungeonSectionInfoMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
            @Deprecated
            public Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> getDungeonSectionInfoMap() {
                return getDungeonSectionInfoMapMap();
            }

            @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
            public Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> getDungeonSectionInfoMapMap() {
                return internalGetDungeonSectionInfoMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
            public FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo getDungeonSectionInfoMapOrDefault(int key, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo defaultValue) {
                Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> map = internalGetDungeonSectionInfoMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
            public FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo getDungeonSectionInfoMapOrThrow(int key) {
                Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> map = internalGetDungeonSectionInfoMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearDungeonSectionInfoMap() {
                internalGetMutableDungeonSectionInfoMap().getMutableMap().clear();
                return this;
            }

            public Builder removeDungeonSectionInfoMap(int key) {
                internalGetMutableDungeonSectionInfoMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> getMutableDungeonSectionInfoMap() {
                return internalGetMutableDungeonSectionInfoMap().getMutableMap();
            }

            public Builder putDungeonSectionInfoMap(int key, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableDungeonSectionInfoMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllDungeonSectionInfoMap(Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> values) {
                internalGetMutableDungeonSectionInfoMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
            public boolean getIsContentClosed() {
                return this.isContentClosed_;
            }

            public Builder setIsContentClosed(boolean value) {
                this.isContentClosed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsContentClosed() {
                this.isContentClosed_ = false;
                onChanged();
                return this;
            }

            private MapField<Integer, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo> internalGetMinigameInfoMap() {
                if (this.minigameInfoMap_ == null) {
                    return MapField.emptyMapField(MinigameInfoMapDefaultEntryHolder.defaultEntry);
                }
                return this.minigameInfoMap_;
            }

            private MapField<Integer, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo> internalGetMutableMinigameInfoMap() {
                onChanged();
                if (this.minigameInfoMap_ == null) {
                    this.minigameInfoMap_ = MapField.newMapField(MinigameInfoMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.minigameInfoMap_.isMutable()) {
                    this.minigameInfoMap_ = this.minigameInfoMap_.copy();
                }
                return this.minigameInfoMap_;
            }

            @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
            public int getMinigameInfoMapCount() {
                return internalGetMinigameInfoMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
            public boolean containsMinigameInfoMap(int key) {
                return internalGetMinigameInfoMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
            @Deprecated
            public Map<Integer, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo> getMinigameInfoMap() {
                return getMinigameInfoMapMap();
            }

            @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
            public Map<Integer, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo> getMinigameInfoMapMap() {
                return internalGetMinigameInfoMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
            public FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo getMinigameInfoMapOrDefault(int key, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo defaultValue) {
                Map<Integer, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo> map = internalGetMinigameInfoMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
            public FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo getMinigameInfoMapOrThrow(int key) {
                Map<Integer, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo> map = internalGetMinigameInfoMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearMinigameInfoMap() {
                internalGetMutableMinigameInfoMap().getMutableMap().clear();
                return this;
            }

            public Builder removeMinigameInfoMap(int key) {
                internalGetMutableMinigameInfoMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo> getMutableMinigameInfoMap() {
                return internalGetMutableMinigameInfoMap().getMutableMap();
            }

            public Builder putMinigameInfoMap(int key, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableMinigameInfoMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllMinigameInfoMap(Map<Integer, FleurFairMinigameInfoOuterClass.FleurFairMinigameInfo> values) {
                internalGetMutableMinigameInfoMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
            public int getUnk3300LOFLGOOIMNH() {
                return this.unk3300LOFLGOOIMNH_;
            }

            public Builder setUnk3300LOFLGOOIMNH(int value) {
                this.unk3300LOFLGOOIMNH_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300LOFLGOOIMNH() {
                this.unk3300LOFLGOOIMNH_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder
            public int getContentCloseTime() {
                return this.contentCloseTime_;
            }

            public Builder setContentCloseTime(int value) {
                this.contentCloseTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearContentCloseTime() {
                this.contentCloseTime_ = 0;
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

        public static FleurFairActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FleurFairActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FleurFairActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FleurFairActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FleurFairChapterInfoOuterClass.getDescriptor();
        FleurFairDungeonSectionInfoOuterClass.getDescriptor();
        FleurFairMinigameInfoOuterClass.getDescriptor();
    }
}
