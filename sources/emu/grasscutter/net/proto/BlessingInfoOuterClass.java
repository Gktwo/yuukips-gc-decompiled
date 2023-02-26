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
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BlessingInfoOuterClass.class */
public final class BlessingInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012BlessingInfo.proto\" \u0002\n\fBlessingInfo\u0012\u0014\n\fleftMonsters\u0018\u0005 \u0001(\b\u0012\u0018\n\u0010contentCloseTime\u0018\u000b \u0001(\r\u0012\u0015\n\rcurDayScanNum\u0018\f \u0001(\r\u0012\u001b\n\u0013Unk3300_INOHLELBOAM\u0018\u000f \u0001(\r\u0012\u001b\n\u0013Unk3300_JLADHEKJPBP\u0018\t \u0001(\r\u0012/\n\tpicNumMap\u0018\u0007 \u0003(\u000b2\u001c.BlessingInfo.PicNumMapEntry\u0012\u0017\n\u000fnextRefreshTime\u0018\u000e \u0001(\r\u0012\u0013\n\u000bisActivated\u0018\b \u0001(\b\u001a0\n\u000ePicNumMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_BlessingInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BlessingInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BlessingInfo_descriptor, new String[]{"LeftMonsters", "ContentCloseTime", "CurDayScanNum", "Unk3300INOHLELBOAM", "Unk3300JLADHEKJPBP", "PicNumMap", "NextRefreshTime", "IsActivated"});
    private static final Descriptors.Descriptor internal_static_BlessingInfo_PicNumMapEntry_descriptor = internal_static_BlessingInfo_descriptor.getNestedTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BlessingInfo_PicNumMapEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BlessingInfo_PicNumMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BlessingInfoOuterClass$BlessingInfoOrBuilder.class */
    public interface BlessingInfoOrBuilder extends MessageOrBuilder {
        boolean getLeftMonsters();

        int getContentCloseTime();

        int getCurDayScanNum();

        int getUnk3300INOHLELBOAM();

        int getUnk3300JLADHEKJPBP();

        int getPicNumMapCount();

        boolean containsPicNumMap(int i);

        @Deprecated
        Map<Integer, Integer> getPicNumMap();

        Map<Integer, Integer> getPicNumMapMap();

        int getPicNumMapOrDefault(int i, int i2);

        int getPicNumMapOrThrow(int i);

        int getNextRefreshTime();

        boolean getIsActivated();
    }

    private BlessingInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BlessingInfoOuterClass$BlessingInfo.class */
    public static final class BlessingInfo extends GeneratedMessageV3 implements BlessingInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LEFTMONSTERS_FIELD_NUMBER = 5;
        private boolean leftMonsters_;
        public static final int CONTENTCLOSETIME_FIELD_NUMBER = 11;
        private int contentCloseTime_;
        public static final int CURDAYSCANNUM_FIELD_NUMBER = 12;
        private int curDayScanNum_;
        public static final int UNK3300_INOHLELBOAM_FIELD_NUMBER = 15;
        private int unk3300INOHLELBOAM_;
        public static final int UNK3300_JLADHEKJPBP_FIELD_NUMBER = 9;
        private int unk3300JLADHEKJPBP_;
        public static final int PICNUMMAP_FIELD_NUMBER = 7;
        private MapField<Integer, Integer> picNumMap_;
        public static final int NEXTREFRESHTIME_FIELD_NUMBER = 14;
        private int nextRefreshTime_;
        public static final int ISACTIVATED_FIELD_NUMBER = 8;
        private boolean isActivated_;
        private byte memoizedIsInitialized;
        private static final BlessingInfo DEFAULT_INSTANCE = new BlessingInfo();
        private static final Parser<BlessingInfo> PARSER = new AbstractParser<BlessingInfo>() { // from class: emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfo.1
            @Override // com.google.protobuf.Parser
            public BlessingInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BlessingInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 7: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetPicNumMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private BlessingInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BlessingInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BlessingInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BlessingInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 40:
                                this.leftMonsters_ = input.readBool();
                                break;
                            case 58:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.picNumMap_ = MapField.newMapField(PicNumMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, Integer> picNumMap__ = (MapEntry) input.readMessage(PicNumMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.picNumMap_.getMutableMap().put(picNumMap__.getKey(), picNumMap__.getValue());
                                break;
                            case 64:
                                this.isActivated_ = input.readBool();
                                break;
                            case 72:
                                this.unk3300JLADHEKJPBP_ = input.readUInt32();
                                break;
                            case 88:
                                this.contentCloseTime_ = input.readUInt32();
                                break;
                            case 96:
                                this.curDayScanNum_ = input.readUInt32();
                                break;
                            case 112:
                                this.nextRefreshTime_ = input.readUInt32();
                                break;
                            case 120:
                                this.unk3300INOHLELBOAM_ = input.readUInt32();
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
            return BlessingInfoOuterClass.internal_static_BlessingInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BlessingInfoOuterClass.internal_static_BlessingInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BlessingInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
        public boolean getLeftMonsters() {
            return this.leftMonsters_;
        }

        @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
        public int getContentCloseTime() {
            return this.contentCloseTime_;
        }

        @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
        public int getCurDayScanNum() {
            return this.curDayScanNum_;
        }

        @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
        public int getUnk3300INOHLELBOAM() {
            return this.unk3300INOHLELBOAM_;
        }

        @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
        public int getUnk3300JLADHEKJPBP() {
            return this.unk3300JLADHEKJPBP_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BlessingInfoOuterClass$BlessingInfo$PicNumMapDefaultEntryHolder.class */
        public static final class PicNumMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(BlessingInfoOuterClass.internal_static_BlessingInfo_PicNumMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private PicNumMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetPicNumMap() {
            if (this.picNumMap_ == null) {
                return MapField.emptyMapField(PicNumMapDefaultEntryHolder.defaultEntry);
            }
            return this.picNumMap_;
        }

        @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
        public int getPicNumMapCount() {
            return internalGetPicNumMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
        public boolean containsPicNumMap(int key) {
            return internalGetPicNumMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getPicNumMap() {
            return getPicNumMapMap();
        }

        @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
        public Map<Integer, Integer> getPicNumMapMap() {
            return internalGetPicNumMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
        public int getPicNumMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetPicNumMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
        public int getPicNumMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetPicNumMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
        public int getNextRefreshTime() {
            return this.nextRefreshTime_;
        }

        @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
        public boolean getIsActivated() {
            return this.isActivated_;
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
            if (this.leftMonsters_) {
                output.writeBool(5, this.leftMonsters_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetPicNumMap(), PicNumMapDefaultEntryHolder.defaultEntry, 7);
            if (this.isActivated_) {
                output.writeBool(8, this.isActivated_);
            }
            if (this.unk3300JLADHEKJPBP_ != 0) {
                output.writeUInt32(9, this.unk3300JLADHEKJPBP_);
            }
            if (this.contentCloseTime_ != 0) {
                output.writeUInt32(11, this.contentCloseTime_);
            }
            if (this.curDayScanNum_ != 0) {
                output.writeUInt32(12, this.curDayScanNum_);
            }
            if (this.nextRefreshTime_ != 0) {
                output.writeUInt32(14, this.nextRefreshTime_);
            }
            if (this.unk3300INOHLELBOAM_ != 0) {
                output.writeUInt32(15, this.unk3300INOHLELBOAM_);
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
            if (this.leftMonsters_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(5, this.leftMonsters_);
            }
            for (Map.Entry<Integer, Integer> entry : internalGetPicNumMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(7, PicNumMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.isActivated_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.isActivated_);
            }
            if (this.unk3300JLADHEKJPBP_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.unk3300JLADHEKJPBP_);
            }
            if (this.contentCloseTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.contentCloseTime_);
            }
            if (this.curDayScanNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.curDayScanNum_);
            }
            if (this.nextRefreshTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.nextRefreshTime_);
            }
            if (this.unk3300INOHLELBOAM_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.unk3300INOHLELBOAM_);
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
            if (!(obj instanceof BlessingInfo)) {
                return equals(obj);
            }
            BlessingInfo other = (BlessingInfo) obj;
            return getLeftMonsters() == other.getLeftMonsters() && getContentCloseTime() == other.getContentCloseTime() && getCurDayScanNum() == other.getCurDayScanNum() && getUnk3300INOHLELBOAM() == other.getUnk3300INOHLELBOAM() && getUnk3300JLADHEKJPBP() == other.getUnk3300JLADHEKJPBP() && internalGetPicNumMap().equals(other.internalGetPicNumMap()) && getNextRefreshTime() == other.getNextRefreshTime() && getIsActivated() == other.getIsActivated() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + Internal.hashBoolean(getLeftMonsters()))) + 11)) + getContentCloseTime())) + 12)) + getCurDayScanNum())) + 15)) + getUnk3300INOHLELBOAM())) + 9)) + getUnk3300JLADHEKJPBP();
            if (!internalGetPicNumMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 7)) + internalGetPicNumMap().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 14)) + getNextRefreshTime())) + 8)) + Internal.hashBoolean(getIsActivated()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static BlessingInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BlessingInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BlessingInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BlessingInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BlessingInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BlessingInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BlessingInfo parseFrom(InputStream input) throws IOException {
            return (BlessingInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BlessingInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlessingInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BlessingInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BlessingInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BlessingInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlessingInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BlessingInfo parseFrom(CodedInputStream input) throws IOException {
            return (BlessingInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BlessingInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlessingInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BlessingInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BlessingInfoOuterClass$BlessingInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BlessingInfoOrBuilder {
            private int bitField0_;
            private boolean leftMonsters_;
            private int contentCloseTime_;
            private int curDayScanNum_;
            private int unk3300INOHLELBOAM_;
            private int unk3300JLADHEKJPBP_;
            private MapField<Integer, Integer> picNumMap_;
            private int nextRefreshTime_;
            private boolean isActivated_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetPicNumMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetMutablePicNumMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return BlessingInfoOuterClass.internal_static_BlessingInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BlessingInfoOuterClass.internal_static_BlessingInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BlessingInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BlessingInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.leftMonsters_ = false;
                this.contentCloseTime_ = 0;
                this.curDayScanNum_ = 0;
                this.unk3300INOHLELBOAM_ = 0;
                this.unk3300JLADHEKJPBP_ = 0;
                internalGetMutablePicNumMap().clear();
                this.nextRefreshTime_ = 0;
                this.isActivated_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BlessingInfoOuterClass.internal_static_BlessingInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BlessingInfo getDefaultInstanceForType() {
                return BlessingInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BlessingInfo build() {
                BlessingInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BlessingInfo buildPartial() {
                BlessingInfo result = new BlessingInfo(this);
                int i = this.bitField0_;
                result.leftMonsters_ = this.leftMonsters_;
                result.contentCloseTime_ = this.contentCloseTime_;
                result.curDayScanNum_ = this.curDayScanNum_;
                result.unk3300INOHLELBOAM_ = this.unk3300INOHLELBOAM_;
                result.unk3300JLADHEKJPBP_ = this.unk3300JLADHEKJPBP_;
                result.picNumMap_ = internalGetPicNumMap();
                result.picNumMap_.makeImmutable();
                result.nextRefreshTime_ = this.nextRefreshTime_;
                result.isActivated_ = this.isActivated_;
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
                if (other instanceof BlessingInfo) {
                    return mergeFrom((BlessingInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BlessingInfo other) {
                if (other == BlessingInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getLeftMonsters()) {
                    setLeftMonsters(other.getLeftMonsters());
                }
                if (other.getContentCloseTime() != 0) {
                    setContentCloseTime(other.getContentCloseTime());
                }
                if (other.getCurDayScanNum() != 0) {
                    setCurDayScanNum(other.getCurDayScanNum());
                }
                if (other.getUnk3300INOHLELBOAM() != 0) {
                    setUnk3300INOHLELBOAM(other.getUnk3300INOHLELBOAM());
                }
                if (other.getUnk3300JLADHEKJPBP() != 0) {
                    setUnk3300JLADHEKJPBP(other.getUnk3300JLADHEKJPBP());
                }
                internalGetMutablePicNumMap().mergeFrom(other.internalGetPicNumMap());
                if (other.getNextRefreshTime() != 0) {
                    setNextRefreshTime(other.getNextRefreshTime());
                }
                if (other.getIsActivated()) {
                    setIsActivated(other.getIsActivated());
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
                BlessingInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BlessingInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BlessingInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
            public int getCurDayScanNum() {
                return this.curDayScanNum_;
            }

            public Builder setCurDayScanNum(int value) {
                this.curDayScanNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurDayScanNum() {
                this.curDayScanNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
            public int getUnk3300INOHLELBOAM() {
                return this.unk3300INOHLELBOAM_;
            }

            public Builder setUnk3300INOHLELBOAM(int value) {
                this.unk3300INOHLELBOAM_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300INOHLELBOAM() {
                this.unk3300INOHLELBOAM_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
            public int getUnk3300JLADHEKJPBP() {
                return this.unk3300JLADHEKJPBP_;
            }

            public Builder setUnk3300JLADHEKJPBP(int value) {
                this.unk3300JLADHEKJPBP_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300JLADHEKJPBP() {
                this.unk3300JLADHEKJPBP_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetPicNumMap() {
                if (this.picNumMap_ == null) {
                    return MapField.emptyMapField(PicNumMapDefaultEntryHolder.defaultEntry);
                }
                return this.picNumMap_;
            }

            private MapField<Integer, Integer> internalGetMutablePicNumMap() {
                onChanged();
                if (this.picNumMap_ == null) {
                    this.picNumMap_ = MapField.newMapField(PicNumMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.picNumMap_.isMutable()) {
                    this.picNumMap_ = this.picNumMap_.copy();
                }
                return this.picNumMap_;
            }

            @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
            public int getPicNumMapCount() {
                return internalGetPicNumMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
            public boolean containsPicNumMap(int key) {
                return internalGetPicNumMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getPicNumMap() {
                return getPicNumMapMap();
            }

            @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
            public Map<Integer, Integer> getPicNumMapMap() {
                return internalGetPicNumMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
            public int getPicNumMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetPicNumMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
            public int getPicNumMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetPicNumMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearPicNumMap() {
                internalGetMutablePicNumMap().getMutableMap().clear();
                return this;
            }

            public Builder removePicNumMap(int key) {
                internalGetMutablePicNumMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutablePicNumMap() {
                return internalGetMutablePicNumMap().getMutableMap();
            }

            public Builder putPicNumMap(int key, int value) {
                internalGetMutablePicNumMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllPicNumMap(Map<Integer, Integer> values) {
                internalGetMutablePicNumMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
            public int getNextRefreshTime() {
                return this.nextRefreshTime_;
            }

            public Builder setNextRefreshTime(int value) {
                this.nextRefreshTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearNextRefreshTime() {
                this.nextRefreshTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BlessingInfoOuterClass.BlessingInfoOrBuilder
            public boolean getIsActivated() {
                return this.isActivated_;
            }

            public Builder setIsActivated(boolean value) {
                this.isActivated_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsActivated() {
                this.isActivated_ = false;
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

        public static BlessingInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BlessingInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BlessingInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BlessingInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
