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
import emu.grasscutter.net.proto.MusicBriefInfoOuterClass;
import emu.grasscutter.net.proto.MusicGameRecordOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameActivityDetailInfoOuterClass.class */
public final class MusicGameActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!MusicGameActivityDetailInfo.proto\u001a\u0014MusicBriefInfo.proto\u001a\u0015MusicGameRecord.proto\"\u0002\n\u001bMusicGameActivityDetailInfo\u0012,\n\u0013Unk3300_AAGCDCOIPJM\u0018\u0002 \u0003(\u000b2\u000f.MusicBriefInfo\u0012,\n\u0013Unk3300_OKHAACGHMAP\u0018\u0006 \u0003(\u000b2\u000f.MusicBriefInfo\u0012P\n\u0012musicGameRecordMap\u0018\b \u0003(\u000b24.MusicGameActivityDetailInfo.MusicGameRecordMapEntry\u001aK\n\u0017MusicGameRecordMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\u001f\n\u0005value\u0018\u0002 \u0001(\u000b2\u0010.MusicGameRecord:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MusicBriefInfoOuterClass.getDescriptor(), MusicGameRecordOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MusicGameActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MusicGameActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MusicGameActivityDetailInfo_descriptor, new String[]{"Unk3300AAGCDCOIPJM", "Unk3300OKHAACGHMAP", "MusicGameRecordMap"});

    /* renamed from: internal_static_MusicGameActivityDetailInfo_MusicGameRecordMapEntry_descriptor */
    private static final Descriptors.Descriptor f785x47b14459 = internal_static_MusicGameActivityDetailInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_MusicGameActivityDetailInfo_MusicGameRecordMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f786xe36701d7 = new GeneratedMessageV3.FieldAccessorTable(f785x47b14459, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameActivityDetailInfoOuterClass$MusicGameActivityDetailInfoOrBuilder.class */
    public interface MusicGameActivityDetailInfoOrBuilder extends MessageOrBuilder {
        List<MusicBriefInfoOuterClass.MusicBriefInfo> getUnk3300AAGCDCOIPJMList();

        MusicBriefInfoOuterClass.MusicBriefInfo getUnk3300AAGCDCOIPJM(int i);

        int getUnk3300AAGCDCOIPJMCount();

        List<? extends MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder> getUnk3300AAGCDCOIPJMOrBuilderList();

        MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder getUnk3300AAGCDCOIPJMOrBuilder(int i);

        List<MusicBriefInfoOuterClass.MusicBriefInfo> getUnk3300OKHAACGHMAPList();

        MusicBriefInfoOuterClass.MusicBriefInfo getUnk3300OKHAACGHMAP(int i);

        int getUnk3300OKHAACGHMAPCount();

        List<? extends MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder> getUnk3300OKHAACGHMAPOrBuilderList();

        MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder getUnk3300OKHAACGHMAPOrBuilder(int i);

        int getMusicGameRecordMapCount();

        boolean containsMusicGameRecordMap(int i);

        @Deprecated
        Map<Integer, MusicGameRecordOuterClass.MusicGameRecord> getMusicGameRecordMap();

        Map<Integer, MusicGameRecordOuterClass.MusicGameRecord> getMusicGameRecordMapMap();

        MusicGameRecordOuterClass.MusicGameRecord getMusicGameRecordMapOrDefault(int i, MusicGameRecordOuterClass.MusicGameRecord musicGameRecord);

        MusicGameRecordOuterClass.MusicGameRecord getMusicGameRecordMapOrThrow(int i);
    }

    private MusicGameActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameActivityDetailInfoOuterClass$MusicGameActivityDetailInfo.class */
    public static final class MusicGameActivityDetailInfo extends GeneratedMessageV3 implements MusicGameActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_AAGCDCOIPJM_FIELD_NUMBER = 2;
        private List<MusicBriefInfoOuterClass.MusicBriefInfo> unk3300AAGCDCOIPJM_;
        public static final int UNK3300_OKHAACGHMAP_FIELD_NUMBER = 6;
        private List<MusicBriefInfoOuterClass.MusicBriefInfo> unk3300OKHAACGHMAP_;
        public static final int MUSICGAMERECORDMAP_FIELD_NUMBER = 8;
        private MapField<Integer, MusicGameRecordOuterClass.MusicGameRecord> musicGameRecordMap_;
        private byte memoizedIsInitialized;
        private static final MusicGameActivityDetailInfo DEFAULT_INSTANCE = new MusicGameActivityDetailInfo();
        private static final Parser<MusicGameActivityDetailInfo> PARSER = new AbstractParser<MusicGameActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public MusicGameActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MusicGameActivityDetailInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 8: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetMusicGameRecordMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private MusicGameActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MusicGameActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.unk3300AAGCDCOIPJM_ = Collections.emptyList();
            this.unk3300OKHAACGHMAP_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MusicGameActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:63:0x0104 */
        private MusicGameActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 18:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.unk3300AAGCDCOIPJM_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.unk3300AAGCDCOIPJM_.add((MusicBriefInfoOuterClass.MusicBriefInfo) input.readMessage(MusicBriefInfoOuterClass.MusicBriefInfo.parser(), extensionRegistry));
                                    break;
                                case 50:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.unk3300OKHAACGHMAP_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.unk3300OKHAACGHMAP_.add((MusicBriefInfoOuterClass.MusicBriefInfo) input.readMessage(MusicBriefInfoOuterClass.MusicBriefInfo.parser(), extensionRegistry));
                                    break;
                                case 66:
                                    if ((mutable_bitField0_ & 4) == 0) {
                                        this.musicGameRecordMap_ = MapField.newMapField(MusicGameRecordMapDefaultEntryHolder.defaultEntry);
                                        mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                    }
                                    MapEntry<Integer, MusicGameRecordOuterClass.MusicGameRecord> musicGameRecordMap__ = (MapEntry) input.readMessage(MusicGameRecordMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                    this.musicGameRecordMap_.getMutableMap().put(musicGameRecordMap__.getKey(), musicGameRecordMap__.getValue());
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.unk3300AAGCDCOIPJM_ = Collections.unmodifiableList(this.unk3300AAGCDCOIPJM_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.unk3300OKHAACGHMAP_ = Collections.unmodifiableList(this.unk3300OKHAACGHMAP_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MusicGameActivityDetailInfoOuterClass.internal_static_MusicGameActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MusicGameActivityDetailInfoOuterClass.internal_static_MusicGameActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicGameActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
        public List<MusicBriefInfoOuterClass.MusicBriefInfo> getUnk3300AAGCDCOIPJMList() {
            return this.unk3300AAGCDCOIPJM_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
        public List<? extends MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder> getUnk3300AAGCDCOIPJMOrBuilderList() {
            return this.unk3300AAGCDCOIPJM_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
        public int getUnk3300AAGCDCOIPJMCount() {
            return this.unk3300AAGCDCOIPJM_.size();
        }

        @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
        public MusicBriefInfoOuterClass.MusicBriefInfo getUnk3300AAGCDCOIPJM(int index) {
            return this.unk3300AAGCDCOIPJM_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
        public MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder getUnk3300AAGCDCOIPJMOrBuilder(int index) {
            return this.unk3300AAGCDCOIPJM_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
        public List<MusicBriefInfoOuterClass.MusicBriefInfo> getUnk3300OKHAACGHMAPList() {
            return this.unk3300OKHAACGHMAP_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
        public List<? extends MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder> getUnk3300OKHAACGHMAPOrBuilderList() {
            return this.unk3300OKHAACGHMAP_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
        public int getUnk3300OKHAACGHMAPCount() {
            return this.unk3300OKHAACGHMAP_.size();
        }

        @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
        public MusicBriefInfoOuterClass.MusicBriefInfo getUnk3300OKHAACGHMAP(int index) {
            return this.unk3300OKHAACGHMAP_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
        public MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder getUnk3300OKHAACGHMAPOrBuilder(int index) {
            return this.unk3300OKHAACGHMAP_.get(index);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameActivityDetailInfoOuterClass$MusicGameActivityDetailInfo$MusicGameRecordMapDefaultEntryHolder.class */
        public static final class MusicGameRecordMapDefaultEntryHolder {
            static final MapEntry<Integer, MusicGameRecordOuterClass.MusicGameRecord> defaultEntry = MapEntry.newDefaultInstance(MusicGameActivityDetailInfoOuterClass.f785x47b14459, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, MusicGameRecordOuterClass.MusicGameRecord.getDefaultInstance());

            private MusicGameRecordMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, MusicGameRecordOuterClass.MusicGameRecord> internalGetMusicGameRecordMap() {
            if (this.musicGameRecordMap_ == null) {
                return MapField.emptyMapField(MusicGameRecordMapDefaultEntryHolder.defaultEntry);
            }
            return this.musicGameRecordMap_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
        public int getMusicGameRecordMapCount() {
            return internalGetMusicGameRecordMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
        public boolean containsMusicGameRecordMap(int key) {
            return internalGetMusicGameRecordMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
        @Deprecated
        public Map<Integer, MusicGameRecordOuterClass.MusicGameRecord> getMusicGameRecordMap() {
            return getMusicGameRecordMapMap();
        }

        @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
        public Map<Integer, MusicGameRecordOuterClass.MusicGameRecord> getMusicGameRecordMapMap() {
            return internalGetMusicGameRecordMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
        public MusicGameRecordOuterClass.MusicGameRecord getMusicGameRecordMapOrDefault(int key, MusicGameRecordOuterClass.MusicGameRecord defaultValue) {
            Map<Integer, MusicGameRecordOuterClass.MusicGameRecord> map = internalGetMusicGameRecordMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
        public MusicGameRecordOuterClass.MusicGameRecord getMusicGameRecordMapOrThrow(int key) {
            Map<Integer, MusicGameRecordOuterClass.MusicGameRecord> map = internalGetMusicGameRecordMap().getMap();
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
            for (int i = 0; i < this.unk3300AAGCDCOIPJM_.size(); i++) {
                output.writeMessage(2, this.unk3300AAGCDCOIPJM_.get(i));
            }
            for (int i2 = 0; i2 < this.unk3300OKHAACGHMAP_.size(); i2++) {
                output.writeMessage(6, this.unk3300OKHAACGHMAP_.get(i2));
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetMusicGameRecordMap(), MusicGameRecordMapDefaultEntryHolder.defaultEntry, 8);
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (int i = 0; i < this.unk3300AAGCDCOIPJM_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.unk3300AAGCDCOIPJM_.get(i));
            }
            for (int i2 = 0; i2 < this.unk3300OKHAACGHMAP_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(6, this.unk3300OKHAACGHMAP_.get(i2));
            }
            for (Map.Entry<Integer, MusicGameRecordOuterClass.MusicGameRecord> entry : internalGetMusicGameRecordMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(8, MusicGameRecordMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
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
            if (!(obj instanceof MusicGameActivityDetailInfo)) {
                return equals(obj);
            }
            MusicGameActivityDetailInfo other = (MusicGameActivityDetailInfo) obj;
            return getUnk3300AAGCDCOIPJMList().equals(other.getUnk3300AAGCDCOIPJMList()) && getUnk3300OKHAACGHMAPList().equals(other.getUnk3300OKHAACGHMAPList()) && internalGetMusicGameRecordMap().equals(other.internalGetMusicGameRecordMap()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getUnk3300AAGCDCOIPJMCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getUnk3300AAGCDCOIPJMList().hashCode();
            }
            if (getUnk3300OKHAACGHMAPCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getUnk3300OKHAACGHMAPList().hashCode();
            }
            if (!internalGetMusicGameRecordMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 8)) + internalGetMusicGameRecordMap().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MusicGameActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (MusicGameActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicGameActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicGameActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (MusicGameActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MusicGameActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicGameActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (MusicGameActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicGameActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MusicGameActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameActivityDetailInfoOuterClass$MusicGameActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MusicGameActivityDetailInfoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<MusicBriefInfoOuterClass.MusicBriefInfo, MusicBriefInfoOuterClass.MusicBriefInfo.Builder, MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder> unk3300AAGCDCOIPJMBuilder_;
            private RepeatedFieldBuilderV3<MusicBriefInfoOuterClass.MusicBriefInfo, MusicBriefInfoOuterClass.MusicBriefInfo.Builder, MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder> unk3300OKHAACGHMAPBuilder_;
            private MapField<Integer, MusicGameRecordOuterClass.MusicGameRecord> musicGameRecordMap_;
            private List<MusicBriefInfoOuterClass.MusicBriefInfo> unk3300AAGCDCOIPJM_ = Collections.emptyList();
            private List<MusicBriefInfoOuterClass.MusicBriefInfo> unk3300OKHAACGHMAP_ = Collections.emptyList();

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 8: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMusicGameRecordMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 8: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableMusicGameRecordMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MusicGameActivityDetailInfoOuterClass.internal_static_MusicGameActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MusicGameActivityDetailInfoOuterClass.internal_static_MusicGameActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicGameActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MusicGameActivityDetailInfo.alwaysUseFieldBuilders) {
                    getUnk3300AAGCDCOIPJMFieldBuilder();
                    getUnk3300OKHAACGHMAPFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.unk3300AAGCDCOIPJMBuilder_ == null) {
                    this.unk3300AAGCDCOIPJM_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.unk3300AAGCDCOIPJMBuilder_.clear();
                }
                if (this.unk3300OKHAACGHMAPBuilder_ == null) {
                    this.unk3300OKHAACGHMAP_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.unk3300OKHAACGHMAPBuilder_.clear();
                }
                internalGetMutableMusicGameRecordMap().clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MusicGameActivityDetailInfoOuterClass.internal_static_MusicGameActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MusicGameActivityDetailInfo getDefaultInstanceForType() {
                return MusicGameActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicGameActivityDetailInfo build() {
                MusicGameActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicGameActivityDetailInfo buildPartial() {
                MusicGameActivityDetailInfo result = new MusicGameActivityDetailInfo(this);
                int i = this.bitField0_;
                if (this.unk3300AAGCDCOIPJMBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.unk3300AAGCDCOIPJM_ = Collections.unmodifiableList(this.unk3300AAGCDCOIPJM_);
                        this.bitField0_ &= -2;
                    }
                    result.unk3300AAGCDCOIPJM_ = this.unk3300AAGCDCOIPJM_;
                } else {
                    result.unk3300AAGCDCOIPJM_ = this.unk3300AAGCDCOIPJMBuilder_.build();
                }
                if (this.unk3300OKHAACGHMAPBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.unk3300OKHAACGHMAP_ = Collections.unmodifiableList(this.unk3300OKHAACGHMAP_);
                        this.bitField0_ &= -3;
                    }
                    result.unk3300OKHAACGHMAP_ = this.unk3300OKHAACGHMAP_;
                } else {
                    result.unk3300OKHAACGHMAP_ = this.unk3300OKHAACGHMAPBuilder_.build();
                }
                result.musicGameRecordMap_ = internalGetMusicGameRecordMap();
                result.musicGameRecordMap_.makeImmutable();
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
                if (other instanceof MusicGameActivityDetailInfo) {
                    return mergeFrom((MusicGameActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MusicGameActivityDetailInfo other) {
                if (other == MusicGameActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.unk3300AAGCDCOIPJMBuilder_ == null) {
                    if (!other.unk3300AAGCDCOIPJM_.isEmpty()) {
                        if (this.unk3300AAGCDCOIPJM_.isEmpty()) {
                            this.unk3300AAGCDCOIPJM_ = other.unk3300AAGCDCOIPJM_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureUnk3300AAGCDCOIPJMIsMutable();
                            this.unk3300AAGCDCOIPJM_.addAll(other.unk3300AAGCDCOIPJM_);
                        }
                        onChanged();
                    }
                } else if (!other.unk3300AAGCDCOIPJM_.isEmpty()) {
                    if (this.unk3300AAGCDCOIPJMBuilder_.isEmpty()) {
                        this.unk3300AAGCDCOIPJMBuilder_.dispose();
                        this.unk3300AAGCDCOIPJMBuilder_ = null;
                        this.unk3300AAGCDCOIPJM_ = other.unk3300AAGCDCOIPJM_;
                        this.bitField0_ &= -2;
                        this.unk3300AAGCDCOIPJMBuilder_ = MusicGameActivityDetailInfo.alwaysUseFieldBuilders ? getUnk3300AAGCDCOIPJMFieldBuilder() : null;
                    } else {
                        this.unk3300AAGCDCOIPJMBuilder_.addAllMessages(other.unk3300AAGCDCOIPJM_);
                    }
                }
                if (this.unk3300OKHAACGHMAPBuilder_ == null) {
                    if (!other.unk3300OKHAACGHMAP_.isEmpty()) {
                        if (this.unk3300OKHAACGHMAP_.isEmpty()) {
                            this.unk3300OKHAACGHMAP_ = other.unk3300OKHAACGHMAP_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureUnk3300OKHAACGHMAPIsMutable();
                            this.unk3300OKHAACGHMAP_.addAll(other.unk3300OKHAACGHMAP_);
                        }
                        onChanged();
                    }
                } else if (!other.unk3300OKHAACGHMAP_.isEmpty()) {
                    if (this.unk3300OKHAACGHMAPBuilder_.isEmpty()) {
                        this.unk3300OKHAACGHMAPBuilder_.dispose();
                        this.unk3300OKHAACGHMAPBuilder_ = null;
                        this.unk3300OKHAACGHMAP_ = other.unk3300OKHAACGHMAP_;
                        this.bitField0_ &= -3;
                        this.unk3300OKHAACGHMAPBuilder_ = MusicGameActivityDetailInfo.alwaysUseFieldBuilders ? getUnk3300OKHAACGHMAPFieldBuilder() : null;
                    } else {
                        this.unk3300OKHAACGHMAPBuilder_.addAllMessages(other.unk3300OKHAACGHMAP_);
                    }
                }
                internalGetMutableMusicGameRecordMap().mergeFrom(other.internalGetMusicGameRecordMap());
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
                MusicGameActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = MusicGameActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MusicGameActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureUnk3300AAGCDCOIPJMIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unk3300AAGCDCOIPJM_ = new ArrayList(this.unk3300AAGCDCOIPJM_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
            public List<MusicBriefInfoOuterClass.MusicBriefInfo> getUnk3300AAGCDCOIPJMList() {
                if (this.unk3300AAGCDCOIPJMBuilder_ == null) {
                    return Collections.unmodifiableList(this.unk3300AAGCDCOIPJM_);
                }
                return this.unk3300AAGCDCOIPJMBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
            public int getUnk3300AAGCDCOIPJMCount() {
                if (this.unk3300AAGCDCOIPJMBuilder_ == null) {
                    return this.unk3300AAGCDCOIPJM_.size();
                }
                return this.unk3300AAGCDCOIPJMBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
            public MusicBriefInfoOuterClass.MusicBriefInfo getUnk3300AAGCDCOIPJM(int index) {
                if (this.unk3300AAGCDCOIPJMBuilder_ == null) {
                    return this.unk3300AAGCDCOIPJM_.get(index);
                }
                return this.unk3300AAGCDCOIPJMBuilder_.getMessage(index);
            }

            public Builder setUnk3300AAGCDCOIPJM(int index, MusicBriefInfoOuterClass.MusicBriefInfo value) {
                if (this.unk3300AAGCDCOIPJMBuilder_ != null) {
                    this.unk3300AAGCDCOIPJMBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnk3300AAGCDCOIPJMIsMutable();
                    this.unk3300AAGCDCOIPJM_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setUnk3300AAGCDCOIPJM(int index, MusicBriefInfoOuterClass.MusicBriefInfo.Builder builderForValue) {
                if (this.unk3300AAGCDCOIPJMBuilder_ == null) {
                    ensureUnk3300AAGCDCOIPJMIsMutable();
                    this.unk3300AAGCDCOIPJM_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.unk3300AAGCDCOIPJMBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUnk3300AAGCDCOIPJM(MusicBriefInfoOuterClass.MusicBriefInfo value) {
                if (this.unk3300AAGCDCOIPJMBuilder_ != null) {
                    this.unk3300AAGCDCOIPJMBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnk3300AAGCDCOIPJMIsMutable();
                    this.unk3300AAGCDCOIPJM_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addUnk3300AAGCDCOIPJM(int index, MusicBriefInfoOuterClass.MusicBriefInfo value) {
                if (this.unk3300AAGCDCOIPJMBuilder_ != null) {
                    this.unk3300AAGCDCOIPJMBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnk3300AAGCDCOIPJMIsMutable();
                    this.unk3300AAGCDCOIPJM_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addUnk3300AAGCDCOIPJM(MusicBriefInfoOuterClass.MusicBriefInfo.Builder builderForValue) {
                if (this.unk3300AAGCDCOIPJMBuilder_ == null) {
                    ensureUnk3300AAGCDCOIPJMIsMutable();
                    this.unk3300AAGCDCOIPJM_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.unk3300AAGCDCOIPJMBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUnk3300AAGCDCOIPJM(int index, MusicBriefInfoOuterClass.MusicBriefInfo.Builder builderForValue) {
                if (this.unk3300AAGCDCOIPJMBuilder_ == null) {
                    ensureUnk3300AAGCDCOIPJMIsMutable();
                    this.unk3300AAGCDCOIPJM_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.unk3300AAGCDCOIPJMBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUnk3300AAGCDCOIPJM(Iterable<? extends MusicBriefInfoOuterClass.MusicBriefInfo> values) {
                if (this.unk3300AAGCDCOIPJMBuilder_ == null) {
                    ensureUnk3300AAGCDCOIPJMIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300AAGCDCOIPJM_);
                    onChanged();
                } else {
                    this.unk3300AAGCDCOIPJMBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUnk3300AAGCDCOIPJM() {
                if (this.unk3300AAGCDCOIPJMBuilder_ == null) {
                    this.unk3300AAGCDCOIPJM_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.unk3300AAGCDCOIPJMBuilder_.clear();
                }
                return this;
            }

            public Builder removeUnk3300AAGCDCOIPJM(int index) {
                if (this.unk3300AAGCDCOIPJMBuilder_ == null) {
                    ensureUnk3300AAGCDCOIPJMIsMutable();
                    this.unk3300AAGCDCOIPJM_.remove(index);
                    onChanged();
                } else {
                    this.unk3300AAGCDCOIPJMBuilder_.remove(index);
                }
                return this;
            }

            public MusicBriefInfoOuterClass.MusicBriefInfo.Builder getUnk3300AAGCDCOIPJMBuilder(int index) {
                return getUnk3300AAGCDCOIPJMFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
            public MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder getUnk3300AAGCDCOIPJMOrBuilder(int index) {
                if (this.unk3300AAGCDCOIPJMBuilder_ == null) {
                    return this.unk3300AAGCDCOIPJM_.get(index);
                }
                return this.unk3300AAGCDCOIPJMBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
            public List<? extends MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder> getUnk3300AAGCDCOIPJMOrBuilderList() {
                if (this.unk3300AAGCDCOIPJMBuilder_ != null) {
                    return this.unk3300AAGCDCOIPJMBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.unk3300AAGCDCOIPJM_);
            }

            public MusicBriefInfoOuterClass.MusicBriefInfo.Builder addUnk3300AAGCDCOIPJMBuilder() {
                return getUnk3300AAGCDCOIPJMFieldBuilder().addBuilder(MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance());
            }

            public MusicBriefInfoOuterClass.MusicBriefInfo.Builder addUnk3300AAGCDCOIPJMBuilder(int index) {
                return getUnk3300AAGCDCOIPJMFieldBuilder().addBuilder(index, MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance());
            }

            public List<MusicBriefInfoOuterClass.MusicBriefInfo.Builder> getUnk3300AAGCDCOIPJMBuilderList() {
                return getUnk3300AAGCDCOIPJMFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<MusicBriefInfoOuterClass.MusicBriefInfo, MusicBriefInfoOuterClass.MusicBriefInfo.Builder, MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder> getUnk3300AAGCDCOIPJMFieldBuilder() {
                if (this.unk3300AAGCDCOIPJMBuilder_ == null) {
                    this.unk3300AAGCDCOIPJMBuilder_ = new RepeatedFieldBuilderV3<>(this.unk3300AAGCDCOIPJM_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.unk3300AAGCDCOIPJM_ = null;
                }
                return this.unk3300AAGCDCOIPJMBuilder_;
            }

            private void ensureUnk3300OKHAACGHMAPIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unk3300OKHAACGHMAP_ = new ArrayList(this.unk3300OKHAACGHMAP_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
            public List<MusicBriefInfoOuterClass.MusicBriefInfo> getUnk3300OKHAACGHMAPList() {
                if (this.unk3300OKHAACGHMAPBuilder_ == null) {
                    return Collections.unmodifiableList(this.unk3300OKHAACGHMAP_);
                }
                return this.unk3300OKHAACGHMAPBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
            public int getUnk3300OKHAACGHMAPCount() {
                if (this.unk3300OKHAACGHMAPBuilder_ == null) {
                    return this.unk3300OKHAACGHMAP_.size();
                }
                return this.unk3300OKHAACGHMAPBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
            public MusicBriefInfoOuterClass.MusicBriefInfo getUnk3300OKHAACGHMAP(int index) {
                if (this.unk3300OKHAACGHMAPBuilder_ == null) {
                    return this.unk3300OKHAACGHMAP_.get(index);
                }
                return this.unk3300OKHAACGHMAPBuilder_.getMessage(index);
            }

            public Builder setUnk3300OKHAACGHMAP(int index, MusicBriefInfoOuterClass.MusicBriefInfo value) {
                if (this.unk3300OKHAACGHMAPBuilder_ != null) {
                    this.unk3300OKHAACGHMAPBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnk3300OKHAACGHMAPIsMutable();
                    this.unk3300OKHAACGHMAP_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setUnk3300OKHAACGHMAP(int index, MusicBriefInfoOuterClass.MusicBriefInfo.Builder builderForValue) {
                if (this.unk3300OKHAACGHMAPBuilder_ == null) {
                    ensureUnk3300OKHAACGHMAPIsMutable();
                    this.unk3300OKHAACGHMAP_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.unk3300OKHAACGHMAPBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUnk3300OKHAACGHMAP(MusicBriefInfoOuterClass.MusicBriefInfo value) {
                if (this.unk3300OKHAACGHMAPBuilder_ != null) {
                    this.unk3300OKHAACGHMAPBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnk3300OKHAACGHMAPIsMutable();
                    this.unk3300OKHAACGHMAP_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addUnk3300OKHAACGHMAP(int index, MusicBriefInfoOuterClass.MusicBriefInfo value) {
                if (this.unk3300OKHAACGHMAPBuilder_ != null) {
                    this.unk3300OKHAACGHMAPBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnk3300OKHAACGHMAPIsMutable();
                    this.unk3300OKHAACGHMAP_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addUnk3300OKHAACGHMAP(MusicBriefInfoOuterClass.MusicBriefInfo.Builder builderForValue) {
                if (this.unk3300OKHAACGHMAPBuilder_ == null) {
                    ensureUnk3300OKHAACGHMAPIsMutable();
                    this.unk3300OKHAACGHMAP_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.unk3300OKHAACGHMAPBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUnk3300OKHAACGHMAP(int index, MusicBriefInfoOuterClass.MusicBriefInfo.Builder builderForValue) {
                if (this.unk3300OKHAACGHMAPBuilder_ == null) {
                    ensureUnk3300OKHAACGHMAPIsMutable();
                    this.unk3300OKHAACGHMAP_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.unk3300OKHAACGHMAPBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUnk3300OKHAACGHMAP(Iterable<? extends MusicBriefInfoOuterClass.MusicBriefInfo> values) {
                if (this.unk3300OKHAACGHMAPBuilder_ == null) {
                    ensureUnk3300OKHAACGHMAPIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300OKHAACGHMAP_);
                    onChanged();
                } else {
                    this.unk3300OKHAACGHMAPBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUnk3300OKHAACGHMAP() {
                if (this.unk3300OKHAACGHMAPBuilder_ == null) {
                    this.unk3300OKHAACGHMAP_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.unk3300OKHAACGHMAPBuilder_.clear();
                }
                return this;
            }

            public Builder removeUnk3300OKHAACGHMAP(int index) {
                if (this.unk3300OKHAACGHMAPBuilder_ == null) {
                    ensureUnk3300OKHAACGHMAPIsMutable();
                    this.unk3300OKHAACGHMAP_.remove(index);
                    onChanged();
                } else {
                    this.unk3300OKHAACGHMAPBuilder_.remove(index);
                }
                return this;
            }

            public MusicBriefInfoOuterClass.MusicBriefInfo.Builder getUnk3300OKHAACGHMAPBuilder(int index) {
                return getUnk3300OKHAACGHMAPFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
            public MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder getUnk3300OKHAACGHMAPOrBuilder(int index) {
                if (this.unk3300OKHAACGHMAPBuilder_ == null) {
                    return this.unk3300OKHAACGHMAP_.get(index);
                }
                return this.unk3300OKHAACGHMAPBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
            public List<? extends MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder> getUnk3300OKHAACGHMAPOrBuilderList() {
                if (this.unk3300OKHAACGHMAPBuilder_ != null) {
                    return this.unk3300OKHAACGHMAPBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.unk3300OKHAACGHMAP_);
            }

            public MusicBriefInfoOuterClass.MusicBriefInfo.Builder addUnk3300OKHAACGHMAPBuilder() {
                return getUnk3300OKHAACGHMAPFieldBuilder().addBuilder(MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance());
            }

            public MusicBriefInfoOuterClass.MusicBriefInfo.Builder addUnk3300OKHAACGHMAPBuilder(int index) {
                return getUnk3300OKHAACGHMAPFieldBuilder().addBuilder(index, MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance());
            }

            public List<MusicBriefInfoOuterClass.MusicBriefInfo.Builder> getUnk3300OKHAACGHMAPBuilderList() {
                return getUnk3300OKHAACGHMAPFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<MusicBriefInfoOuterClass.MusicBriefInfo, MusicBriefInfoOuterClass.MusicBriefInfo.Builder, MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder> getUnk3300OKHAACGHMAPFieldBuilder() {
                if (this.unk3300OKHAACGHMAPBuilder_ == null) {
                    this.unk3300OKHAACGHMAPBuilder_ = new RepeatedFieldBuilderV3<>(this.unk3300OKHAACGHMAP_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.unk3300OKHAACGHMAP_ = null;
                }
                return this.unk3300OKHAACGHMAPBuilder_;
            }

            private MapField<Integer, MusicGameRecordOuterClass.MusicGameRecord> internalGetMusicGameRecordMap() {
                if (this.musicGameRecordMap_ == null) {
                    return MapField.emptyMapField(MusicGameRecordMapDefaultEntryHolder.defaultEntry);
                }
                return this.musicGameRecordMap_;
            }

            private MapField<Integer, MusicGameRecordOuterClass.MusicGameRecord> internalGetMutableMusicGameRecordMap() {
                onChanged();
                if (this.musicGameRecordMap_ == null) {
                    this.musicGameRecordMap_ = MapField.newMapField(MusicGameRecordMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.musicGameRecordMap_.isMutable()) {
                    this.musicGameRecordMap_ = this.musicGameRecordMap_.copy();
                }
                return this.musicGameRecordMap_;
            }

            @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
            public int getMusicGameRecordMapCount() {
                return internalGetMusicGameRecordMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
            public boolean containsMusicGameRecordMap(int key) {
                return internalGetMusicGameRecordMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
            @Deprecated
            public Map<Integer, MusicGameRecordOuterClass.MusicGameRecord> getMusicGameRecordMap() {
                return getMusicGameRecordMapMap();
            }

            @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
            public Map<Integer, MusicGameRecordOuterClass.MusicGameRecord> getMusicGameRecordMapMap() {
                return internalGetMusicGameRecordMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
            public MusicGameRecordOuterClass.MusicGameRecord getMusicGameRecordMapOrDefault(int key, MusicGameRecordOuterClass.MusicGameRecord defaultValue) {
                Map<Integer, MusicGameRecordOuterClass.MusicGameRecord> map = internalGetMusicGameRecordMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder
            public MusicGameRecordOuterClass.MusicGameRecord getMusicGameRecordMapOrThrow(int key) {
                Map<Integer, MusicGameRecordOuterClass.MusicGameRecord> map = internalGetMusicGameRecordMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearMusicGameRecordMap() {
                internalGetMutableMusicGameRecordMap().getMutableMap().clear();
                return this;
            }

            public Builder removeMusicGameRecordMap(int key) {
                internalGetMutableMusicGameRecordMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, MusicGameRecordOuterClass.MusicGameRecord> getMutableMusicGameRecordMap() {
                return internalGetMutableMusicGameRecordMap().getMutableMap();
            }

            public Builder putMusicGameRecordMap(int key, MusicGameRecordOuterClass.MusicGameRecord value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableMusicGameRecordMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllMusicGameRecordMap(Map<Integer, MusicGameRecordOuterClass.MusicGameRecord> values) {
                internalGetMutableMusicGameRecordMap().getMutableMap().putAll(values);
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

        public static MusicGameActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MusicGameActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MusicGameActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MusicGameActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MusicBriefInfoOuterClass.getDescriptor();
        MusicGameRecordOuterClass.getDescriptor();
    }
}
