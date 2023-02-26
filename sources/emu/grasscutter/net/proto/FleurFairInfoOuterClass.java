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
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairInfoOuterClass.class */
public final class FleurFairInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013FleurFairInfo.proto\u001a\fuint32.proto\u001a\u001aFleurFairChapterInfo.proto\u001a!FleurFairDungeonSectionInfo.proto\"²\u0003\n\rFleurFairInfo\u0012\u0013\n\u000bgpjbakimcgp\u0018\n \u0001(\r\u0012@\n\u0011previewStageIndex\u0018\u0006 \u0003(\u000b2%.FleurFairInfo.PreviewStageIndexEntry\u0012\u0014\n\fleftMonsters\u0018\u0007 \u0001(\b\u0012.\n\u000fchapterInfoList\u0018\u0005 \u0003(\u000b2\u0015.FleurFairChapterInfo\u0012\u0013\n\u000bhpepmphkgml\u0018\t \u0001(\b\u0012\u0018\n\u0010contentCloseTime\u0018\u000f \u0001(\r\u0012\u0013\n\u000bppjmalghkch\u0018\u0001 \u0001(\r\u00124\n\u000bpnpcagimleg\u0018\u000b \u0003(\u000b2\u001f.FleurFairInfo.PnpcagimlegEntry\u001a8\n\u0016PreviewStageIndexEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001\u001aP\n\u0010PnpcagimlegEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012+\n\u0005value\u0018\u0002 \u0001(\u000b2\u001c.FleurFairDungeonSectionInfo:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{Uint32.getDescriptor(), FleurFairChapterInfoOuterClass.getDescriptor(), FleurFairDungeonSectionInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FleurFairInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FleurFairInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FleurFairInfo_descriptor, new String[]{"Gpjbakimcgp", "PreviewStageIndex", "LeftMonsters", "ChapterInfoList", "Hpepmphkgml", "ContentCloseTime", "Ppjmalghkch", "Pnpcagimleg"});
    private static final Descriptors.Descriptor internal_static_FleurFairInfo_PreviewStageIndexEntry_descriptor = internal_static_FleurFairInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_FleurFairInfo_PreviewStageIndexEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f709x7432d356 = new GeneratedMessageV3.FieldAccessorTable(internal_static_FleurFairInfo_PreviewStageIndexEntry_descriptor, new String[]{"Key", "Value"});
    private static final Descriptors.Descriptor internal_static_FleurFairInfo_PnpcagimlegEntry_descriptor = internal_static_FleurFairInfo_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_FleurFairInfo_PnpcagimlegEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f710xee425c6d = new GeneratedMessageV3.FieldAccessorTable(internal_static_FleurFairInfo_PnpcagimlegEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairInfoOuterClass$FleurFairInfoOrBuilder.class */
    public interface FleurFairInfoOrBuilder extends MessageOrBuilder {
        int getGpjbakimcgp();

        int getPreviewStageIndexCount();

        boolean containsPreviewStageIndex(int i);

        @Deprecated
        Map<Integer, Integer> getPreviewStageIndex();

        Map<Integer, Integer> getPreviewStageIndexMap();

        int getPreviewStageIndexOrDefault(int i, int i2);

        int getPreviewStageIndexOrThrow(int i);

        boolean getLeftMonsters();

        List<FleurFairChapterInfoOuterClass.FleurFairChapterInfo> getChapterInfoListList();

        FleurFairChapterInfoOuterClass.FleurFairChapterInfo getChapterInfoList(int i);

        int getChapterInfoListCount();

        List<? extends FleurFairChapterInfoOuterClass.FleurFairChapterInfoOrBuilder> getChapterInfoListOrBuilderList();

        FleurFairChapterInfoOuterClass.FleurFairChapterInfoOrBuilder getChapterInfoListOrBuilder(int i);

        boolean getHpepmphkgml();

        int getContentCloseTime();

        int getPpjmalghkch();

        int getPnpcagimlegCount();

        boolean containsPnpcagimleg(int i);

        @Deprecated
        Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> getPnpcagimleg();

        Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> getPnpcagimlegMap();

        FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo getPnpcagimlegOrDefault(int i, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo fleurFairDungeonSectionInfo);

        FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo getPnpcagimlegOrThrow(int i);
    }

    private FleurFairInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairInfoOuterClass$FleurFairInfo.class */
    public static final class FleurFairInfo extends GeneratedMessageV3 implements FleurFairInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GPJBAKIMCGP_FIELD_NUMBER = 10;
        private int gpjbakimcgp_;
        public static final int PREVIEWSTAGEINDEX_FIELD_NUMBER = 6;
        private MapField<Integer, Integer> previewStageIndex_;
        public static final int LEFTMONSTERS_FIELD_NUMBER = 7;
        private boolean leftMonsters_;
        public static final int CHAPTERINFOLIST_FIELD_NUMBER = 5;
        private List<FleurFairChapterInfoOuterClass.FleurFairChapterInfo> chapterInfoList_;
        public static final int HPEPMPHKGML_FIELD_NUMBER = 9;
        private boolean hpepmphkgml_;
        public static final int CONTENTCLOSETIME_FIELD_NUMBER = 15;
        private int contentCloseTime_;
        public static final int PPJMALGHKCH_FIELD_NUMBER = 1;
        private int ppjmalghkch_;
        public static final int PNPCAGIMLEG_FIELD_NUMBER = 11;
        private MapField<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> pnpcagimleg_;
        private byte memoizedIsInitialized;
        private static final FleurFairInfo DEFAULT_INSTANCE = new FleurFairInfo();
        private static final Parser<FleurFairInfo> PARSER = new AbstractParser<FleurFairInfo>() { // from class: emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfo.1
            @Override // com.google.protobuf.Parser
            public FleurFairInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FleurFairInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 6: goto L_0x001c;
                    case 11: goto L_0x0021;
                    default: goto L_0x0026;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetPreviewStageIndex()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetPnpcagimleg()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private FleurFairInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FleurFairInfo() {
            this.memoizedIsInitialized = -1;
            this.chapterInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FleurFairInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:67:0x017a */
        private FleurFairInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.ppjmalghkch_ = input.readUInt32();
                                break;
                            case 42:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.chapterInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.chapterInfoList_.add((FleurFairChapterInfoOuterClass.FleurFairChapterInfo) input.readMessage(FleurFairChapterInfoOuterClass.FleurFairChapterInfo.parser(), extensionRegistry));
                                break;
                            case 50:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.previewStageIndex_ = MapField.newMapField(PreviewStageIndexDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Integer> previewStageIndex__ = (MapEntry) input.readMessage(PreviewStageIndexDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.previewStageIndex_.getMutableMap().put(previewStageIndex__.getKey(), previewStageIndex__.getValue());
                                break;
                            case 56:
                                this.leftMonsters_ = input.readBool();
                                break;
                            case 72:
                                this.hpepmphkgml_ = input.readBool();
                                break;
                            case 80:
                                this.gpjbakimcgp_ = input.readUInt32();
                                break;
                            case 90:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.pnpcagimleg_ = MapField.newMapField(PnpcagimlegDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> pnpcagimleg__ = (MapEntry) input.readMessage(PnpcagimlegDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.pnpcagimleg_.getMutableMap().put(pnpcagimleg__.getKey(), pnpcagimleg__.getValue());
                                break;
                            case 120:
                                this.contentCloseTime_ = input.readUInt32();
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
                    this.chapterInfoList_ = Collections.unmodifiableList(this.chapterInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FleurFairInfoOuterClass.internal_static_FleurFairInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FleurFairInfoOuterClass.internal_static_FleurFairInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FleurFairInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
        public int getGpjbakimcgp() {
            return this.gpjbakimcgp_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairInfoOuterClass$FleurFairInfo$PreviewStageIndexDefaultEntryHolder.class */
        public static final class PreviewStageIndexDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(FleurFairInfoOuterClass.internal_static_FleurFairInfo_PreviewStageIndexEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private PreviewStageIndexDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetPreviewStageIndex() {
            if (this.previewStageIndex_ == null) {
                return MapField.emptyMapField(PreviewStageIndexDefaultEntryHolder.defaultEntry);
            }
            return this.previewStageIndex_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
        public int getPreviewStageIndexCount() {
            return internalGetPreviewStageIndex().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
        public boolean containsPreviewStageIndex(int key) {
            return internalGetPreviewStageIndex().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getPreviewStageIndex() {
            return getPreviewStageIndexMap();
        }

        @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
        public Map<Integer, Integer> getPreviewStageIndexMap() {
            return internalGetPreviewStageIndex().getMap();
        }

        @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
        public int getPreviewStageIndexOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetPreviewStageIndex().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
        public int getPreviewStageIndexOrThrow(int key) {
            Map<Integer, Integer> map = internalGetPreviewStageIndex().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
        public boolean getLeftMonsters() {
            return this.leftMonsters_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
        public List<FleurFairChapterInfoOuterClass.FleurFairChapterInfo> getChapterInfoListList() {
            return this.chapterInfoList_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
        public List<? extends FleurFairChapterInfoOuterClass.FleurFairChapterInfoOrBuilder> getChapterInfoListOrBuilderList() {
            return this.chapterInfoList_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
        public int getChapterInfoListCount() {
            return this.chapterInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
        public FleurFairChapterInfoOuterClass.FleurFairChapterInfo getChapterInfoList(int index) {
            return this.chapterInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
        public FleurFairChapterInfoOuterClass.FleurFairChapterInfoOrBuilder getChapterInfoListOrBuilder(int index) {
            return this.chapterInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
        public boolean getHpepmphkgml() {
            return this.hpepmphkgml_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
        public int getContentCloseTime() {
            return this.contentCloseTime_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
        public int getPpjmalghkch() {
            return this.ppjmalghkch_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairInfoOuterClass$FleurFairInfo$PnpcagimlegDefaultEntryHolder.class */
        public static final class PnpcagimlegDefaultEntryHolder {
            static final MapEntry<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> defaultEntry = MapEntry.newDefaultInstance(FleurFairInfoOuterClass.internal_static_FleurFairInfo_PnpcagimlegEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo.getDefaultInstance());

            private PnpcagimlegDefaultEntryHolder() {
            }
        }

        private MapField<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> internalGetPnpcagimleg() {
            if (this.pnpcagimleg_ == null) {
                return MapField.emptyMapField(PnpcagimlegDefaultEntryHolder.defaultEntry);
            }
            return this.pnpcagimleg_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
        public int getPnpcagimlegCount() {
            return internalGetPnpcagimleg().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
        public boolean containsPnpcagimleg(int key) {
            return internalGetPnpcagimleg().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
        @Deprecated
        public Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> getPnpcagimleg() {
            return getPnpcagimlegMap();
        }

        @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
        public Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> getPnpcagimlegMap() {
            return internalGetPnpcagimleg().getMap();
        }

        @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
        public FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo getPnpcagimlegOrDefault(int key, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo defaultValue) {
            Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> map = internalGetPnpcagimleg().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
        public FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo getPnpcagimlegOrThrow(int key) {
            Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> map = internalGetPnpcagimleg().getMap();
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
            if (this.ppjmalghkch_ != 0) {
                output.writeUInt32(1, this.ppjmalghkch_);
            }
            for (int i = 0; i < this.chapterInfoList_.size(); i++) {
                output.writeMessage(5, this.chapterInfoList_.get(i));
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetPreviewStageIndex(), PreviewStageIndexDefaultEntryHolder.defaultEntry, 6);
            if (this.leftMonsters_) {
                output.writeBool(7, this.leftMonsters_);
            }
            if (this.hpepmphkgml_) {
                output.writeBool(9, this.hpepmphkgml_);
            }
            if (this.gpjbakimcgp_ != 0) {
                output.writeUInt32(10, this.gpjbakimcgp_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetPnpcagimleg(), PnpcagimlegDefaultEntryHolder.defaultEntry, 11);
            if (this.contentCloseTime_ != 0) {
                output.writeUInt32(15, this.contentCloseTime_);
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
            if (this.ppjmalghkch_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.ppjmalghkch_);
            }
            for (int i = 0; i < this.chapterInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.chapterInfoList_.get(i));
            }
            for (Map.Entry<Integer, Integer> entry : internalGetPreviewStageIndex().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(6, PreviewStageIndexDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.leftMonsters_) {
                size2 += CodedOutputStream.computeBoolSize(7, this.leftMonsters_);
            }
            if (this.hpepmphkgml_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.hpepmphkgml_);
            }
            if (this.gpjbakimcgp_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.gpjbakimcgp_);
            }
            for (Map.Entry<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> entry2 : internalGetPnpcagimleg().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(11, PnpcagimlegDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            if (this.contentCloseTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.contentCloseTime_);
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
            if (!(obj instanceof FleurFairInfo)) {
                return equals(obj);
            }
            FleurFairInfo other = (FleurFairInfo) obj;
            return getGpjbakimcgp() == other.getGpjbakimcgp() && internalGetPreviewStageIndex().equals(other.internalGetPreviewStageIndex()) && getLeftMonsters() == other.getLeftMonsters() && getChapterInfoListList().equals(other.getChapterInfoListList()) && getHpepmphkgml() == other.getHpepmphkgml() && getContentCloseTime() == other.getContentCloseTime() && getPpjmalghkch() == other.getPpjmalghkch() && internalGetPnpcagimleg().equals(other.internalGetPnpcagimleg()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getGpjbakimcgp();
            if (!internalGetPreviewStageIndex().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 6)) + internalGetPreviewStageIndex().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 7)) + Internal.hashBoolean(getLeftMonsters());
            if (getChapterInfoListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 5)) + getChapterInfoListList().hashCode();
            }
            int hash3 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + 9)) + Internal.hashBoolean(getHpepmphkgml()))) + 15)) + getContentCloseTime())) + 1)) + getPpjmalghkch();
            if (!internalGetPnpcagimleg().getMap().isEmpty()) {
                hash3 = (53 * ((37 * hash3) + 11)) + internalGetPnpcagimleg().hashCode();
            }
            int hash4 = (29 * hash3) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static FleurFairInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FleurFairInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FleurFairInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FleurFairInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FleurFairInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FleurFairInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FleurFairInfo parseFrom(InputStream input) throws IOException {
            return (FleurFairInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FleurFairInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FleurFairInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FleurFairInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (FleurFairInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FleurFairInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FleurFairInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FleurFairInfo parseFrom(CodedInputStream input) throws IOException {
            return (FleurFairInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FleurFairInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FleurFairInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FleurFairInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairInfoOuterClass$FleurFairInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FleurFairInfoOrBuilder {
            private int bitField0_;
            private int gpjbakimcgp_;
            private MapField<Integer, Integer> previewStageIndex_;
            private boolean leftMonsters_;
            private List<FleurFairChapterInfoOuterClass.FleurFairChapterInfo> chapterInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<FleurFairChapterInfoOuterClass.FleurFairChapterInfo, FleurFairChapterInfoOuterClass.FleurFairChapterInfo.Builder, FleurFairChapterInfoOuterClass.FleurFairChapterInfoOrBuilder> chapterInfoListBuilder_;
            private boolean hpepmphkgml_;
            private int contentCloseTime_;
            private int ppjmalghkch_;
            private MapField<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> pnpcagimleg_;

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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 6: goto L_0x001c;
                        case 11: goto L_0x0021;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetPreviewStageIndex()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetPnpcagimleg()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 6: goto L_0x001c;
                        case 11: goto L_0x0021;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutablePreviewStageIndex()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutablePnpcagimleg()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return FleurFairInfoOuterClass.internal_static_FleurFairInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FleurFairInfoOuterClass.internal_static_FleurFairInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FleurFairInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FleurFairInfo.alwaysUseFieldBuilders) {
                    getChapterInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.gpjbakimcgp_ = 0;
                internalGetMutablePreviewStageIndex().clear();
                this.leftMonsters_ = false;
                if (this.chapterInfoListBuilder_ == null) {
                    this.chapterInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.chapterInfoListBuilder_.clear();
                }
                this.hpepmphkgml_ = false;
                this.contentCloseTime_ = 0;
                this.ppjmalghkch_ = 0;
                internalGetMutablePnpcagimleg().clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FleurFairInfoOuterClass.internal_static_FleurFairInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FleurFairInfo getDefaultInstanceForType() {
                return FleurFairInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FleurFairInfo build() {
                FleurFairInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FleurFairInfo buildPartial() {
                FleurFairInfo result = new FleurFairInfo(this);
                int i = this.bitField0_;
                result.gpjbakimcgp_ = this.gpjbakimcgp_;
                result.previewStageIndex_ = internalGetPreviewStageIndex();
                result.previewStageIndex_.makeImmutable();
                result.leftMonsters_ = this.leftMonsters_;
                if (this.chapterInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.chapterInfoList_ = Collections.unmodifiableList(this.chapterInfoList_);
                        this.bitField0_ &= -3;
                    }
                    result.chapterInfoList_ = this.chapterInfoList_;
                } else {
                    result.chapterInfoList_ = this.chapterInfoListBuilder_.build();
                }
                result.hpepmphkgml_ = this.hpepmphkgml_;
                result.contentCloseTime_ = this.contentCloseTime_;
                result.ppjmalghkch_ = this.ppjmalghkch_;
                result.pnpcagimleg_ = internalGetPnpcagimleg();
                result.pnpcagimleg_.makeImmutable();
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
                if (other instanceof FleurFairInfo) {
                    return mergeFrom((FleurFairInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FleurFairInfo other) {
                if (other == FleurFairInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getGpjbakimcgp() != 0) {
                    setGpjbakimcgp(other.getGpjbakimcgp());
                }
                internalGetMutablePreviewStageIndex().mergeFrom(other.internalGetPreviewStageIndex());
                if (other.getLeftMonsters()) {
                    setLeftMonsters(other.getLeftMonsters());
                }
                if (this.chapterInfoListBuilder_ == null) {
                    if (!other.chapterInfoList_.isEmpty()) {
                        if (this.chapterInfoList_.isEmpty()) {
                            this.chapterInfoList_ = other.chapterInfoList_;
                            this.bitField0_ &= -3;
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
                        this.bitField0_ &= -3;
                        this.chapterInfoListBuilder_ = FleurFairInfo.alwaysUseFieldBuilders ? getChapterInfoListFieldBuilder() : null;
                    } else {
                        this.chapterInfoListBuilder_.addAllMessages(other.chapterInfoList_);
                    }
                }
                if (other.getHpepmphkgml()) {
                    setHpepmphkgml(other.getHpepmphkgml());
                }
                if (other.getContentCloseTime() != 0) {
                    setContentCloseTime(other.getContentCloseTime());
                }
                if (other.getPpjmalghkch() != 0) {
                    setPpjmalghkch(other.getPpjmalghkch());
                }
                internalGetMutablePnpcagimleg().mergeFrom(other.internalGetPnpcagimleg());
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
                FleurFairInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = FleurFairInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FleurFairInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
            public int getGpjbakimcgp() {
                return this.gpjbakimcgp_;
            }

            public Builder setGpjbakimcgp(int value) {
                this.gpjbakimcgp_ = value;
                onChanged();
                return this;
            }

            public Builder clearGpjbakimcgp() {
                this.gpjbakimcgp_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetPreviewStageIndex() {
                if (this.previewStageIndex_ == null) {
                    return MapField.emptyMapField(PreviewStageIndexDefaultEntryHolder.defaultEntry);
                }
                return this.previewStageIndex_;
            }

            private MapField<Integer, Integer> internalGetMutablePreviewStageIndex() {
                onChanged();
                if (this.previewStageIndex_ == null) {
                    this.previewStageIndex_ = MapField.newMapField(PreviewStageIndexDefaultEntryHolder.defaultEntry);
                }
                if (!this.previewStageIndex_.isMutable()) {
                    this.previewStageIndex_ = this.previewStageIndex_.copy();
                }
                return this.previewStageIndex_;
            }

            @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
            public int getPreviewStageIndexCount() {
                return internalGetPreviewStageIndex().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
            public boolean containsPreviewStageIndex(int key) {
                return internalGetPreviewStageIndex().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getPreviewStageIndex() {
                return getPreviewStageIndexMap();
            }

            @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
            public Map<Integer, Integer> getPreviewStageIndexMap() {
                return internalGetPreviewStageIndex().getMap();
            }

            @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
            public int getPreviewStageIndexOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetPreviewStageIndex().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
            public int getPreviewStageIndexOrThrow(int key) {
                Map<Integer, Integer> map = internalGetPreviewStageIndex().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearPreviewStageIndex() {
                internalGetMutablePreviewStageIndex().getMutableMap().clear();
                return this;
            }

            public Builder removePreviewStageIndex(int key) {
                internalGetMutablePreviewStageIndex().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutablePreviewStageIndex() {
                return internalGetMutablePreviewStageIndex().getMutableMap();
            }

            public Builder putPreviewStageIndex(int key, int value) {
                internalGetMutablePreviewStageIndex().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllPreviewStageIndex(Map<Integer, Integer> values) {
                internalGetMutablePreviewStageIndex().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
            public boolean getLeftMonsters() {
                return this.leftMonsters_;
            }

            public Builder setLeftMonsters(boolean value) {
                this.leftMonsters_ = value;
                onChanged();
                return this;
            }

            public Builder clearLeftMonsters() {
                this.leftMonsters_ = false;
                onChanged();
                return this;
            }

            private void ensureChapterInfoListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.chapterInfoList_ = new ArrayList(this.chapterInfoList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
            public List<FleurFairChapterInfoOuterClass.FleurFairChapterInfo> getChapterInfoListList() {
                if (this.chapterInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.chapterInfoList_);
                }
                return this.chapterInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
            public int getChapterInfoListCount() {
                if (this.chapterInfoListBuilder_ == null) {
                    return this.chapterInfoList_.size();
                }
                return this.chapterInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
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
                    this.bitField0_ &= -3;
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

            @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
            public FleurFairChapterInfoOuterClass.FleurFairChapterInfoOrBuilder getChapterInfoListOrBuilder(int index) {
                if (this.chapterInfoListBuilder_ == null) {
                    return this.chapterInfoList_.get(index);
                }
                return this.chapterInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
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
                    this.chapterInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.chapterInfoList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.chapterInfoList_ = null;
                }
                return this.chapterInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
            public boolean getHpepmphkgml() {
                return this.hpepmphkgml_;
            }

            public Builder setHpepmphkgml(boolean value) {
                this.hpepmphkgml_ = value;
                onChanged();
                return this;
            }

            public Builder clearHpepmphkgml() {
                this.hpepmphkgml_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
            public int getPpjmalghkch() {
                return this.ppjmalghkch_;
            }

            public Builder setPpjmalghkch(int value) {
                this.ppjmalghkch_ = value;
                onChanged();
                return this;
            }

            public Builder clearPpjmalghkch() {
                this.ppjmalghkch_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> internalGetPnpcagimleg() {
                if (this.pnpcagimleg_ == null) {
                    return MapField.emptyMapField(PnpcagimlegDefaultEntryHolder.defaultEntry);
                }
                return this.pnpcagimleg_;
            }

            private MapField<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> internalGetMutablePnpcagimleg() {
                onChanged();
                if (this.pnpcagimleg_ == null) {
                    this.pnpcagimleg_ = MapField.newMapField(PnpcagimlegDefaultEntryHolder.defaultEntry);
                }
                if (!this.pnpcagimleg_.isMutable()) {
                    this.pnpcagimleg_ = this.pnpcagimleg_.copy();
                }
                return this.pnpcagimleg_;
            }

            @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
            public int getPnpcagimlegCount() {
                return internalGetPnpcagimleg().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
            public boolean containsPnpcagimleg(int key) {
                return internalGetPnpcagimleg().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
            @Deprecated
            public Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> getPnpcagimleg() {
                return getPnpcagimlegMap();
            }

            @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
            public Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> getPnpcagimlegMap() {
                return internalGetPnpcagimleg().getMap();
            }

            @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
            public FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo getPnpcagimlegOrDefault(int key, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo defaultValue) {
                Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> map = internalGetPnpcagimleg().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.FleurFairInfoOuterClass.FleurFairInfoOrBuilder
            public FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo getPnpcagimlegOrThrow(int key) {
                Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> map = internalGetPnpcagimleg().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearPnpcagimleg() {
                internalGetMutablePnpcagimleg().getMutableMap().clear();
                return this;
            }

            public Builder removePnpcagimleg(int key) {
                internalGetMutablePnpcagimleg().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> getMutablePnpcagimleg() {
                return internalGetMutablePnpcagimleg().getMutableMap();
            }

            public Builder putPnpcagimleg(int key, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutablePnpcagimleg().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllPnpcagimleg(Map<Integer, FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo> values) {
                internalGetMutablePnpcagimleg().getMutableMap().putAll(values);
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

        public static FleurFairInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FleurFairInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FleurFairInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FleurFairInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Uint32.getDescriptor();
        FleurFairChapterInfoOuterClass.getDescriptor();
        FleurFairDungeonSectionInfoOuterClass.getDescriptor();
    }
}
