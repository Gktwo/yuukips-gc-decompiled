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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BlessingActivityDetailInfoOuterClass.class */
public final class BlessingActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n BlessingActivityDetailInfo.proto\"Ë\u0002\n\u001aBlessingActivityDetailInfo\u0012\u0018\n\u0010cur_day_scan_num\u0018\n \u0001(\r\u0012\u001a\n\u0012content_close_time\u0018\b \u0001(\r\u0012\u001b\n\u0013Unk3300_JLADHEKJPBP\u0018\u0001 \u0001(\r\u0012\u0019\n\u0011next_refresh_time\u0018\u0006 \u0001(\r\u0012\u0014\n\fis_activated\u0018\u0005 \u0001(\b\u0012\u001b\n\u0013Unk3300_INOHLELBOAM\u0018\u0007 \u0001(\r\u0012\u0019\n\u0011is_content_closed\u0018\u0002 \u0001(\b\u0012?\n\u000bpic_num_map\u0018\u000b \u0003(\u000b2*.BlessingActivityDetailInfo.PicNumMapEntry\u001a0\n\u000ePicNumMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_BlessingActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BlessingActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BlessingActivityDetailInfo_descriptor, new String[]{"CurDayScanNum", "ContentCloseTime", "Unk3300JLADHEKJPBP", "NextRefreshTime", "IsActivated", "Unk3300INOHLELBOAM", "IsContentClosed", "PicNumMap"});

    /* renamed from: internal_static_BlessingActivityDetailInfo_PicNumMapEntry_descriptor */
    private static final Descriptors.Descriptor f658xa50f5101 = internal_static_BlessingActivityDetailInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_BlessingActivityDetailInfo_PicNumMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f659x84e1e67f = new GeneratedMessageV3.FieldAccessorTable(f658xa50f5101, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BlessingActivityDetailInfoOuterClass$BlessingActivityDetailInfoOrBuilder.class */
    public interface BlessingActivityDetailInfoOrBuilder extends MessageOrBuilder {
        int getCurDayScanNum();

        int getContentCloseTime();

        int getUnk3300JLADHEKJPBP();

        int getNextRefreshTime();

        boolean getIsActivated();

        int getUnk3300INOHLELBOAM();

        boolean getIsContentClosed();

        int getPicNumMapCount();

        boolean containsPicNumMap(int i);

        @Deprecated
        Map<Integer, Integer> getPicNumMap();

        Map<Integer, Integer> getPicNumMapMap();

        int getPicNumMapOrDefault(int i, int i2);

        int getPicNumMapOrThrow(int i);
    }

    private BlessingActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BlessingActivityDetailInfoOuterClass$BlessingActivityDetailInfo.class */
    public static final class BlessingActivityDetailInfo extends GeneratedMessageV3 implements BlessingActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CUR_DAY_SCAN_NUM_FIELD_NUMBER = 10;
        private int curDayScanNum_;
        public static final int CONTENT_CLOSE_TIME_FIELD_NUMBER = 8;
        private int contentCloseTime_;
        public static final int UNK3300_JLADHEKJPBP_FIELD_NUMBER = 1;
        private int unk3300JLADHEKJPBP_;
        public static final int NEXT_REFRESH_TIME_FIELD_NUMBER = 6;
        private int nextRefreshTime_;
        public static final int IS_ACTIVATED_FIELD_NUMBER = 5;
        private boolean isActivated_;
        public static final int UNK3300_INOHLELBOAM_FIELD_NUMBER = 7;
        private int unk3300INOHLELBOAM_;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 2;
        private boolean isContentClosed_;
        public static final int PIC_NUM_MAP_FIELD_NUMBER = 11;
        private MapField<Integer, Integer> picNumMap_;
        private byte memoizedIsInitialized;
        private static final BlessingActivityDetailInfo DEFAULT_INSTANCE = new BlessingActivityDetailInfo();
        private static final Parser<BlessingActivityDetailInfo> PARSER = new AbstractParser<BlessingActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public BlessingActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BlessingActivityDetailInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 11: goto L_0x0014;
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
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private BlessingActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BlessingActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BlessingActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BlessingActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.unk3300JLADHEKJPBP_ = input.readUInt32();
                                break;
                            case 16:
                                this.isContentClosed_ = input.readBool();
                                break;
                            case 40:
                                this.isActivated_ = input.readBool();
                                break;
                            case 48:
                                this.nextRefreshTime_ = input.readUInt32();
                                break;
                            case 56:
                                this.unk3300INOHLELBOAM_ = input.readUInt32();
                                break;
                            case 64:
                                this.contentCloseTime_ = input.readUInt32();
                                break;
                            case 80:
                                this.curDayScanNum_ = input.readUInt32();
                                break;
                            case 90:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.picNumMap_ = MapField.newMapField(PicNumMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, Integer> picNumMap__ = (MapEntry) input.readMessage(PicNumMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.picNumMap_.getMutableMap().put(picNumMap__.getKey(), picNumMap__.getValue());
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
            return BlessingActivityDetailInfoOuterClass.internal_static_BlessingActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BlessingActivityDetailInfoOuterClass.internal_static_BlessingActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BlessingActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
        public int getCurDayScanNum() {
            return this.curDayScanNum_;
        }

        @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
        public int getContentCloseTime() {
            return this.contentCloseTime_;
        }

        @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
        public int getUnk3300JLADHEKJPBP() {
            return this.unk3300JLADHEKJPBP_;
        }

        @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
        public int getNextRefreshTime() {
            return this.nextRefreshTime_;
        }

        @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
        public boolean getIsActivated() {
            return this.isActivated_;
        }

        @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
        public int getUnk3300INOHLELBOAM() {
            return this.unk3300INOHLELBOAM_;
        }

        @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BlessingActivityDetailInfoOuterClass$BlessingActivityDetailInfo$PicNumMapDefaultEntryHolder.class */
        public static final class PicNumMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(BlessingActivityDetailInfoOuterClass.f658xa50f5101, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private PicNumMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetPicNumMap() {
            if (this.picNumMap_ == null) {
                return MapField.emptyMapField(PicNumMapDefaultEntryHolder.defaultEntry);
            }
            return this.picNumMap_;
        }

        @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
        public int getPicNumMapCount() {
            return internalGetPicNumMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
        public boolean containsPicNumMap(int key) {
            return internalGetPicNumMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getPicNumMap() {
            return getPicNumMapMap();
        }

        @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
        public Map<Integer, Integer> getPicNumMapMap() {
            return internalGetPicNumMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
        public int getPicNumMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetPicNumMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
        public int getPicNumMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetPicNumMap().getMap();
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
            if (this.unk3300JLADHEKJPBP_ != 0) {
                output.writeUInt32(1, this.unk3300JLADHEKJPBP_);
            }
            if (this.isContentClosed_) {
                output.writeBool(2, this.isContentClosed_);
            }
            if (this.isActivated_) {
                output.writeBool(5, this.isActivated_);
            }
            if (this.nextRefreshTime_ != 0) {
                output.writeUInt32(6, this.nextRefreshTime_);
            }
            if (this.unk3300INOHLELBOAM_ != 0) {
                output.writeUInt32(7, this.unk3300INOHLELBOAM_);
            }
            if (this.contentCloseTime_ != 0) {
                output.writeUInt32(8, this.contentCloseTime_);
            }
            if (this.curDayScanNum_ != 0) {
                output.writeUInt32(10, this.curDayScanNum_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetPicNumMap(), PicNumMapDefaultEntryHolder.defaultEntry, 11);
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.unk3300JLADHEKJPBP_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.unk3300JLADHEKJPBP_);
            }
            if (this.isContentClosed_) {
                size2 += CodedOutputStream.computeBoolSize(2, this.isContentClosed_);
            }
            if (this.isActivated_) {
                size2 += CodedOutputStream.computeBoolSize(5, this.isActivated_);
            }
            if (this.nextRefreshTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.nextRefreshTime_);
            }
            if (this.unk3300INOHLELBOAM_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.unk3300INOHLELBOAM_);
            }
            if (this.contentCloseTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.contentCloseTime_);
            }
            if (this.curDayScanNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.curDayScanNum_);
            }
            for (Map.Entry<Integer, Integer> entry : internalGetPicNumMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(11, PicNumMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
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
            if (!(obj instanceof BlessingActivityDetailInfo)) {
                return equals(obj);
            }
            BlessingActivityDetailInfo other = (BlessingActivityDetailInfo) obj;
            return getCurDayScanNum() == other.getCurDayScanNum() && getContentCloseTime() == other.getContentCloseTime() && getUnk3300JLADHEKJPBP() == other.getUnk3300JLADHEKJPBP() && getNextRefreshTime() == other.getNextRefreshTime() && getIsActivated() == other.getIsActivated() && getUnk3300INOHLELBOAM() == other.getUnk3300INOHLELBOAM() && getIsContentClosed() == other.getIsContentClosed() && internalGetPicNumMap().equals(other.internalGetPicNumMap()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getCurDayScanNum())) + 8)) + getContentCloseTime())) + 1)) + getUnk3300JLADHEKJPBP())) + 6)) + getNextRefreshTime())) + 5)) + Internal.hashBoolean(getIsActivated()))) + 7)) + getUnk3300INOHLELBOAM())) + 2)) + Internal.hashBoolean(getIsContentClosed());
            if (!internalGetPicNumMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 11)) + internalGetPicNumMap().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static BlessingActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BlessingActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BlessingActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BlessingActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BlessingActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BlessingActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BlessingActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (BlessingActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BlessingActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlessingActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BlessingActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BlessingActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BlessingActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlessingActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BlessingActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (BlessingActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BlessingActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlessingActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BlessingActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BlessingActivityDetailInfoOuterClass$BlessingActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BlessingActivityDetailInfoOrBuilder {
            private int bitField0_;
            private int curDayScanNum_;
            private int contentCloseTime_;
            private int unk3300JLADHEKJPBP_;
            private int nextRefreshTime_;
            private boolean isActivated_;
            private int unk3300INOHLELBOAM_;
            private boolean isContentClosed_;
            private MapField<Integer, Integer> picNumMap_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 11: goto L_0x0014;
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
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 11: goto L_0x0014;
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
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return BlessingActivityDetailInfoOuterClass.internal_static_BlessingActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BlessingActivityDetailInfoOuterClass.internal_static_BlessingActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BlessingActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BlessingActivityDetailInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.curDayScanNum_ = 0;
                this.contentCloseTime_ = 0;
                this.unk3300JLADHEKJPBP_ = 0;
                this.nextRefreshTime_ = 0;
                this.isActivated_ = false;
                this.unk3300INOHLELBOAM_ = 0;
                this.isContentClosed_ = false;
                internalGetMutablePicNumMap().clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BlessingActivityDetailInfoOuterClass.internal_static_BlessingActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BlessingActivityDetailInfo getDefaultInstanceForType() {
                return BlessingActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BlessingActivityDetailInfo build() {
                BlessingActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BlessingActivityDetailInfo buildPartial() {
                BlessingActivityDetailInfo result = new BlessingActivityDetailInfo(this);
                int i = this.bitField0_;
                result.curDayScanNum_ = this.curDayScanNum_;
                result.contentCloseTime_ = this.contentCloseTime_;
                result.unk3300JLADHEKJPBP_ = this.unk3300JLADHEKJPBP_;
                result.nextRefreshTime_ = this.nextRefreshTime_;
                result.isActivated_ = this.isActivated_;
                result.unk3300INOHLELBOAM_ = this.unk3300INOHLELBOAM_;
                result.isContentClosed_ = this.isContentClosed_;
                result.picNumMap_ = internalGetPicNumMap();
                result.picNumMap_.makeImmutable();
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
                if (other instanceof BlessingActivityDetailInfo) {
                    return mergeFrom((BlessingActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BlessingActivityDetailInfo other) {
                if (other == BlessingActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getCurDayScanNum() != 0) {
                    setCurDayScanNum(other.getCurDayScanNum());
                }
                if (other.getContentCloseTime() != 0) {
                    setContentCloseTime(other.getContentCloseTime());
                }
                if (other.getUnk3300JLADHEKJPBP() != 0) {
                    setUnk3300JLADHEKJPBP(other.getUnk3300JLADHEKJPBP());
                }
                if (other.getNextRefreshTime() != 0) {
                    setNextRefreshTime(other.getNextRefreshTime());
                }
                if (other.getIsActivated()) {
                    setIsActivated(other.getIsActivated());
                }
                if (other.getUnk3300INOHLELBOAM() != 0) {
                    setUnk3300INOHLELBOAM(other.getUnk3300INOHLELBOAM());
                }
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
                }
                internalGetMutablePicNumMap().mergeFrom(other.internalGetPicNumMap());
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
                BlessingActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BlessingActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BlessingActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
            public int getPicNumMapCount() {
                return internalGetPicNumMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
            public boolean containsPicNumMap(int key) {
                return internalGetPicNumMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getPicNumMap() {
                return getPicNumMapMap();
            }

            @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
            public Map<Integer, Integer> getPicNumMapMap() {
                return internalGetPicNumMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
            public int getPicNumMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetPicNumMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static BlessingActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BlessingActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BlessingActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BlessingActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
