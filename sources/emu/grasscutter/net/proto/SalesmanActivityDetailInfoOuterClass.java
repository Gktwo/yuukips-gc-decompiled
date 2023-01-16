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
import emu.grasscutter.net.proto.SalesmanStatusTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SalesmanActivityDetailInfoOuterClass.class */
public final class SalesmanActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n SalesmanActivityDetailInfo.proto\u001a\u0018SalesmanStatusType.proto\"«\u0003\n\u001aSalesmanActivityDetailInfo\u0012#\n\u0006status\u0018\u0005 \u0001(\u000e2\u0013.SalesmanStatusType\u0012T\n\u0016selected_reward_id_map\u0018\f \u0003(\u000b24.SalesmanActivityDetailInfo.SelectedRewardIdMapEntry\u0012\u001b\n\u0013Unk3300_DIJFOCBGIAM\u0018\u0007 \u0001(\r\u0012\u001b\n\u0013Unk3300_DJFCEFKGKPI\u0018\u0002 \u0001(\b\u0012\u0011\n\tday_index\u0018\t \u0001(\r\u0012\u001b\n\u0013Unk3300_LPABHMOPFCE\u0018\u0006 \u0001(\r\u0012\u001b\n\u0013Unk3300_KNJCBGFKLFD\u0018\n \u0001(\r\u0012\u001b\n\u0013Unk3300_FOFFAEEBBNP\u0018\u0003 \u0001(\r\u0012\u001b\n\u0013Unk3300_JNALBACFNFN\u0018\u000e \u0001(\b\u0012\u0015\n\rday_reward_id\u0018\u000b \u0001(\r\u001a:\n\u0018SelectedRewardIdMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SalesmanStatusTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SalesmanActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SalesmanActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SalesmanActivityDetailInfo_descriptor, new String[]{"Status", "SelectedRewardIdMap", "Unk3300DIJFOCBGIAM", "Unk3300DJFCEFKGKPI", "DayIndex", "Unk3300LPABHMOPFCE", "Unk3300KNJCBGFKLFD", "Unk3300FOFFAEEBBNP", "Unk3300JNALBACFNFN", "DayRewardId"});

    /* renamed from: internal_static_SalesmanActivityDetailInfo_SelectedRewardIdMapEntry_descriptor */
    private static final Descriptors.Descriptor f852xe21b15df = internal_static_SalesmanActivityDetailInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_SalesmanActivityDetailInfo_SelectedRewardIdMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f853x7f41ed5d = new GeneratedMessageV3.FieldAccessorTable(f852xe21b15df, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SalesmanActivityDetailInfoOuterClass$SalesmanActivityDetailInfoOrBuilder.class */
    public interface SalesmanActivityDetailInfoOrBuilder extends MessageOrBuilder {
        int getStatusValue();

        SalesmanStatusTypeOuterClass.SalesmanStatusType getStatus();

        int getSelectedRewardIdMapCount();

        boolean containsSelectedRewardIdMap(int i);

        @Deprecated
        Map<Integer, Integer> getSelectedRewardIdMap();

        Map<Integer, Integer> getSelectedRewardIdMapMap();

        int getSelectedRewardIdMapOrDefault(int i, int i2);

        int getSelectedRewardIdMapOrThrow(int i);

        int getUnk3300DIJFOCBGIAM();

        boolean getUnk3300DJFCEFKGKPI();

        int getDayIndex();

        int getUnk3300LPABHMOPFCE();

        int getUnk3300KNJCBGFKLFD();

        int getUnk3300FOFFAEEBBNP();

        boolean getUnk3300JNALBACFNFN();

        int getDayRewardId();
    }

    private SalesmanActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SalesmanActivityDetailInfoOuterClass$SalesmanActivityDetailInfo.class */
    public static final class SalesmanActivityDetailInfo extends GeneratedMessageV3 implements SalesmanActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STATUS_FIELD_NUMBER = 5;
        private int status_;
        public static final int SELECTED_REWARD_ID_MAP_FIELD_NUMBER = 12;
        private MapField<Integer, Integer> selectedRewardIdMap_;
        public static final int UNK3300_DIJFOCBGIAM_FIELD_NUMBER = 7;
        private int unk3300DIJFOCBGIAM_;
        public static final int UNK3300_DJFCEFKGKPI_FIELD_NUMBER = 2;
        private boolean unk3300DJFCEFKGKPI_;
        public static final int DAY_INDEX_FIELD_NUMBER = 9;
        private int dayIndex_;
        public static final int UNK3300_LPABHMOPFCE_FIELD_NUMBER = 6;
        private int unk3300LPABHMOPFCE_;
        public static final int UNK3300_KNJCBGFKLFD_FIELD_NUMBER = 10;
        private int unk3300KNJCBGFKLFD_;
        public static final int UNK3300_FOFFAEEBBNP_FIELD_NUMBER = 3;
        private int unk3300FOFFAEEBBNP_;
        public static final int UNK3300_JNALBACFNFN_FIELD_NUMBER = 14;
        private boolean unk3300JNALBACFNFN_;
        public static final int DAY_REWARD_ID_FIELD_NUMBER = 11;
        private int dayRewardId_;
        private byte memoizedIsInitialized;
        private static final SalesmanActivityDetailInfo DEFAULT_INSTANCE = new SalesmanActivityDetailInfo();
        private static final Parser<SalesmanActivityDetailInfo> PARSER = new AbstractParser<SalesmanActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public SalesmanActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SalesmanActivityDetailInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 12: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetSelectedRewardIdMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private SalesmanActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SalesmanActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.status_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SalesmanActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SalesmanActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                this.unk3300DJFCEFKGKPI_ = input.readBool();
                                break;
                            case 24:
                                this.unk3300FOFFAEEBBNP_ = input.readUInt32();
                                break;
                            case 40:
                                this.status_ = input.readEnum();
                                break;
                            case 48:
                                this.unk3300LPABHMOPFCE_ = input.readUInt32();
                                break;
                            case 56:
                                this.unk3300DIJFOCBGIAM_ = input.readUInt32();
                                break;
                            case 72:
                                this.dayIndex_ = input.readUInt32();
                                break;
                            case 80:
                                this.unk3300KNJCBGFKLFD_ = input.readUInt32();
                                break;
                            case 88:
                                this.dayRewardId_ = input.readUInt32();
                                break;
                            case 98:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.selectedRewardIdMap_ = MapField.newMapField(SelectedRewardIdMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, Integer> selectedRewardIdMap__ = (MapEntry) input.readMessage(SelectedRewardIdMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.selectedRewardIdMap_.getMutableMap().put(selectedRewardIdMap__.getKey(), selectedRewardIdMap__.getValue());
                                break;
                            case 112:
                                this.unk3300JNALBACFNFN_ = input.readBool();
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
            return SalesmanActivityDetailInfoOuterClass.internal_static_SalesmanActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SalesmanActivityDetailInfoOuterClass.internal_static_SalesmanActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SalesmanActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
        public int getStatusValue() {
            return this.status_;
        }

        @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
        public SalesmanStatusTypeOuterClass.SalesmanStatusType getStatus() {
            SalesmanStatusTypeOuterClass.SalesmanStatusType result = SalesmanStatusTypeOuterClass.SalesmanStatusType.valueOf(this.status_);
            return result == null ? SalesmanStatusTypeOuterClass.SalesmanStatusType.UNRECOGNIZED : result;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SalesmanActivityDetailInfoOuterClass$SalesmanActivityDetailInfo$SelectedRewardIdMapDefaultEntryHolder.class */
        public static final class SelectedRewardIdMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(SalesmanActivityDetailInfoOuterClass.f852xe21b15df, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private SelectedRewardIdMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetSelectedRewardIdMap() {
            if (this.selectedRewardIdMap_ == null) {
                return MapField.emptyMapField(SelectedRewardIdMapDefaultEntryHolder.defaultEntry);
            }
            return this.selectedRewardIdMap_;
        }

        @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
        public int getSelectedRewardIdMapCount() {
            return internalGetSelectedRewardIdMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
        public boolean containsSelectedRewardIdMap(int key) {
            return internalGetSelectedRewardIdMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getSelectedRewardIdMap() {
            return getSelectedRewardIdMapMap();
        }

        @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
        public Map<Integer, Integer> getSelectedRewardIdMapMap() {
            return internalGetSelectedRewardIdMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
        public int getSelectedRewardIdMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetSelectedRewardIdMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
        public int getSelectedRewardIdMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetSelectedRewardIdMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
        public int getUnk3300DIJFOCBGIAM() {
            return this.unk3300DIJFOCBGIAM_;
        }

        @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
        public boolean getUnk3300DJFCEFKGKPI() {
            return this.unk3300DJFCEFKGKPI_;
        }

        @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
        public int getDayIndex() {
            return this.dayIndex_;
        }

        @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
        public int getUnk3300LPABHMOPFCE() {
            return this.unk3300LPABHMOPFCE_;
        }

        @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
        public int getUnk3300KNJCBGFKLFD() {
            return this.unk3300KNJCBGFKLFD_;
        }

        @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
        public int getUnk3300FOFFAEEBBNP() {
            return this.unk3300FOFFAEEBBNP_;
        }

        @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
        public boolean getUnk3300JNALBACFNFN() {
            return this.unk3300JNALBACFNFN_;
        }

        @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
        public int getDayRewardId() {
            return this.dayRewardId_;
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
            if (this.unk3300DJFCEFKGKPI_) {
                output.writeBool(2, this.unk3300DJFCEFKGKPI_);
            }
            if (this.unk3300FOFFAEEBBNP_ != 0) {
                output.writeUInt32(3, this.unk3300FOFFAEEBBNP_);
            }
            if (this.status_ != SalesmanStatusTypeOuterClass.SalesmanStatusType.SALESMAN_STATUS_TYPE_NONE.getNumber()) {
                output.writeEnum(5, this.status_);
            }
            if (this.unk3300LPABHMOPFCE_ != 0) {
                output.writeUInt32(6, this.unk3300LPABHMOPFCE_);
            }
            if (this.unk3300DIJFOCBGIAM_ != 0) {
                output.writeUInt32(7, this.unk3300DIJFOCBGIAM_);
            }
            if (this.dayIndex_ != 0) {
                output.writeUInt32(9, this.dayIndex_);
            }
            if (this.unk3300KNJCBGFKLFD_ != 0) {
                output.writeUInt32(10, this.unk3300KNJCBGFKLFD_);
            }
            if (this.dayRewardId_ != 0) {
                output.writeUInt32(11, this.dayRewardId_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetSelectedRewardIdMap(), SelectedRewardIdMapDefaultEntryHolder.defaultEntry, 12);
            if (this.unk3300JNALBACFNFN_) {
                output.writeBool(14, this.unk3300JNALBACFNFN_);
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
            if (this.unk3300DJFCEFKGKPI_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(2, this.unk3300DJFCEFKGKPI_);
            }
            if (this.unk3300FOFFAEEBBNP_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.unk3300FOFFAEEBBNP_);
            }
            if (this.status_ != SalesmanStatusTypeOuterClass.SalesmanStatusType.SALESMAN_STATUS_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(5, this.status_);
            }
            if (this.unk3300LPABHMOPFCE_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.unk3300LPABHMOPFCE_);
            }
            if (this.unk3300DIJFOCBGIAM_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.unk3300DIJFOCBGIAM_);
            }
            if (this.dayIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.dayIndex_);
            }
            if (this.unk3300KNJCBGFKLFD_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.unk3300KNJCBGFKLFD_);
            }
            if (this.dayRewardId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.dayRewardId_);
            }
            for (Map.Entry<Integer, Integer> entry : internalGetSelectedRewardIdMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(12, SelectedRewardIdMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.unk3300JNALBACFNFN_) {
                size2 += CodedOutputStream.computeBoolSize(14, this.unk3300JNALBACFNFN_);
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
            if (!(obj instanceof SalesmanActivityDetailInfo)) {
                return equals(obj);
            }
            SalesmanActivityDetailInfo other = (SalesmanActivityDetailInfo) obj;
            return this.status_ == other.status_ && internalGetSelectedRewardIdMap().equals(other.internalGetSelectedRewardIdMap()) && getUnk3300DIJFOCBGIAM() == other.getUnk3300DIJFOCBGIAM() && getUnk3300DJFCEFKGKPI() == other.getUnk3300DJFCEFKGKPI() && getDayIndex() == other.getDayIndex() && getUnk3300LPABHMOPFCE() == other.getUnk3300LPABHMOPFCE() && getUnk3300KNJCBGFKLFD() == other.getUnk3300KNJCBGFKLFD() && getUnk3300FOFFAEEBBNP() == other.getUnk3300FOFFAEEBBNP() && getUnk3300JNALBACFNFN() == other.getUnk3300JNALBACFNFN() && getDayRewardId() == other.getDayRewardId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + this.status_;
            if (!internalGetSelectedRewardIdMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 12)) + internalGetSelectedRewardIdMap().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 7)) + getUnk3300DIJFOCBGIAM())) + 2)) + Internal.hashBoolean(getUnk3300DJFCEFKGKPI()))) + 9)) + getDayIndex())) + 6)) + getUnk3300LPABHMOPFCE())) + 10)) + getUnk3300KNJCBGFKLFD())) + 3)) + getUnk3300FOFFAEEBBNP())) + 14)) + Internal.hashBoolean(getUnk3300JNALBACFNFN()))) + 11)) + getDayRewardId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SalesmanActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SalesmanActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SalesmanActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SalesmanActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SalesmanActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SalesmanActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SalesmanActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (SalesmanActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SalesmanActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SalesmanActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SalesmanActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SalesmanActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SalesmanActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SalesmanActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SalesmanActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (SalesmanActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SalesmanActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SalesmanActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SalesmanActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SalesmanActivityDetailInfoOuterClass$SalesmanActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SalesmanActivityDetailInfoOrBuilder {
            private int bitField0_;
            private int status_ = 0;
            private MapField<Integer, Integer> selectedRewardIdMap_;
            private int unk3300DIJFOCBGIAM_;
            private boolean unk3300DJFCEFKGKPI_;
            private int dayIndex_;
            private int unk3300LPABHMOPFCE_;
            private int unk3300KNJCBGFKLFD_;
            private int unk3300FOFFAEEBBNP_;
            private boolean unk3300JNALBACFNFN_;
            private int dayRewardId_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 12: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetSelectedRewardIdMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 12: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableSelectedRewardIdMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SalesmanActivityDetailInfoOuterClass.internal_static_SalesmanActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SalesmanActivityDetailInfoOuterClass.internal_static_SalesmanActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SalesmanActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SalesmanActivityDetailInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.status_ = 0;
                internalGetMutableSelectedRewardIdMap().clear();
                this.unk3300DIJFOCBGIAM_ = 0;
                this.unk3300DJFCEFKGKPI_ = false;
                this.dayIndex_ = 0;
                this.unk3300LPABHMOPFCE_ = 0;
                this.unk3300KNJCBGFKLFD_ = 0;
                this.unk3300FOFFAEEBBNP_ = 0;
                this.unk3300JNALBACFNFN_ = false;
                this.dayRewardId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SalesmanActivityDetailInfoOuterClass.internal_static_SalesmanActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SalesmanActivityDetailInfo getDefaultInstanceForType() {
                return SalesmanActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SalesmanActivityDetailInfo build() {
                SalesmanActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SalesmanActivityDetailInfo buildPartial() {
                SalesmanActivityDetailInfo result = new SalesmanActivityDetailInfo(this);
                int i = this.bitField0_;
                result.status_ = this.status_;
                result.selectedRewardIdMap_ = internalGetSelectedRewardIdMap();
                result.selectedRewardIdMap_.makeImmutable();
                result.unk3300DIJFOCBGIAM_ = this.unk3300DIJFOCBGIAM_;
                result.unk3300DJFCEFKGKPI_ = this.unk3300DJFCEFKGKPI_;
                result.dayIndex_ = this.dayIndex_;
                result.unk3300LPABHMOPFCE_ = this.unk3300LPABHMOPFCE_;
                result.unk3300KNJCBGFKLFD_ = this.unk3300KNJCBGFKLFD_;
                result.unk3300FOFFAEEBBNP_ = this.unk3300FOFFAEEBBNP_;
                result.unk3300JNALBACFNFN_ = this.unk3300JNALBACFNFN_;
                result.dayRewardId_ = this.dayRewardId_;
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
                if (other instanceof SalesmanActivityDetailInfo) {
                    return mergeFrom((SalesmanActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SalesmanActivityDetailInfo other) {
                if (other == SalesmanActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.status_ != 0) {
                    setStatusValue(other.getStatusValue());
                }
                internalGetMutableSelectedRewardIdMap().mergeFrom(other.internalGetSelectedRewardIdMap());
                if (other.getUnk3300DIJFOCBGIAM() != 0) {
                    setUnk3300DIJFOCBGIAM(other.getUnk3300DIJFOCBGIAM());
                }
                if (other.getUnk3300DJFCEFKGKPI()) {
                    setUnk3300DJFCEFKGKPI(other.getUnk3300DJFCEFKGKPI());
                }
                if (other.getDayIndex() != 0) {
                    setDayIndex(other.getDayIndex());
                }
                if (other.getUnk3300LPABHMOPFCE() != 0) {
                    setUnk3300LPABHMOPFCE(other.getUnk3300LPABHMOPFCE());
                }
                if (other.getUnk3300KNJCBGFKLFD() != 0) {
                    setUnk3300KNJCBGFKLFD(other.getUnk3300KNJCBGFKLFD());
                }
                if (other.getUnk3300FOFFAEEBBNP() != 0) {
                    setUnk3300FOFFAEEBBNP(other.getUnk3300FOFFAEEBBNP());
                }
                if (other.getUnk3300JNALBACFNFN()) {
                    setUnk3300JNALBACFNFN(other.getUnk3300JNALBACFNFN());
                }
                if (other.getDayRewardId() != 0) {
                    setDayRewardId(other.getDayRewardId());
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
                SalesmanActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SalesmanActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SalesmanActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
            public int getStatusValue() {
                return this.status_;
            }

            public Builder setStatusValue(int value) {
                this.status_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
            public SalesmanStatusTypeOuterClass.SalesmanStatusType getStatus() {
                SalesmanStatusTypeOuterClass.SalesmanStatusType result = SalesmanStatusTypeOuterClass.SalesmanStatusType.valueOf(this.status_);
                return result == null ? SalesmanStatusTypeOuterClass.SalesmanStatusType.UNRECOGNIZED : result;
            }

            public Builder setStatus(SalesmanStatusTypeOuterClass.SalesmanStatusType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.status_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearStatus() {
                this.status_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetSelectedRewardIdMap() {
                if (this.selectedRewardIdMap_ == null) {
                    return MapField.emptyMapField(SelectedRewardIdMapDefaultEntryHolder.defaultEntry);
                }
                return this.selectedRewardIdMap_;
            }

            private MapField<Integer, Integer> internalGetMutableSelectedRewardIdMap() {
                onChanged();
                if (this.selectedRewardIdMap_ == null) {
                    this.selectedRewardIdMap_ = MapField.newMapField(SelectedRewardIdMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.selectedRewardIdMap_.isMutable()) {
                    this.selectedRewardIdMap_ = this.selectedRewardIdMap_.copy();
                }
                return this.selectedRewardIdMap_;
            }

            @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
            public int getSelectedRewardIdMapCount() {
                return internalGetSelectedRewardIdMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
            public boolean containsSelectedRewardIdMap(int key) {
                return internalGetSelectedRewardIdMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getSelectedRewardIdMap() {
                return getSelectedRewardIdMapMap();
            }

            @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
            public Map<Integer, Integer> getSelectedRewardIdMapMap() {
                return internalGetSelectedRewardIdMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
            public int getSelectedRewardIdMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetSelectedRewardIdMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
            public int getSelectedRewardIdMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetSelectedRewardIdMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearSelectedRewardIdMap() {
                internalGetMutableSelectedRewardIdMap().getMutableMap().clear();
                return this;
            }

            public Builder removeSelectedRewardIdMap(int key) {
                internalGetMutableSelectedRewardIdMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableSelectedRewardIdMap() {
                return internalGetMutableSelectedRewardIdMap().getMutableMap();
            }

            public Builder putSelectedRewardIdMap(int key, int value) {
                internalGetMutableSelectedRewardIdMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllSelectedRewardIdMap(Map<Integer, Integer> values) {
                internalGetMutableSelectedRewardIdMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
            public int getUnk3300DIJFOCBGIAM() {
                return this.unk3300DIJFOCBGIAM_;
            }

            public Builder setUnk3300DIJFOCBGIAM(int value) {
                this.unk3300DIJFOCBGIAM_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300DIJFOCBGIAM() {
                this.unk3300DIJFOCBGIAM_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
            public boolean getUnk3300DJFCEFKGKPI() {
                return this.unk3300DJFCEFKGKPI_;
            }

            public Builder setUnk3300DJFCEFKGKPI(boolean value) {
                this.unk3300DJFCEFKGKPI_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300DJFCEFKGKPI() {
                this.unk3300DJFCEFKGKPI_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
            public int getDayIndex() {
                return this.dayIndex_;
            }

            public Builder setDayIndex(int value) {
                this.dayIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearDayIndex() {
                this.dayIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
            public int getUnk3300LPABHMOPFCE() {
                return this.unk3300LPABHMOPFCE_;
            }

            public Builder setUnk3300LPABHMOPFCE(int value) {
                this.unk3300LPABHMOPFCE_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300LPABHMOPFCE() {
                this.unk3300LPABHMOPFCE_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
            public int getUnk3300KNJCBGFKLFD() {
                return this.unk3300KNJCBGFKLFD_;
            }

            public Builder setUnk3300KNJCBGFKLFD(int value) {
                this.unk3300KNJCBGFKLFD_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300KNJCBGFKLFD() {
                this.unk3300KNJCBGFKLFD_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
            public int getUnk3300FOFFAEEBBNP() {
                return this.unk3300FOFFAEEBBNP_;
            }

            public Builder setUnk3300FOFFAEEBBNP(int value) {
                this.unk3300FOFFAEEBBNP_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300FOFFAEEBBNP() {
                this.unk3300FOFFAEEBBNP_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
            public boolean getUnk3300JNALBACFNFN() {
                return this.unk3300JNALBACFNFN_;
            }

            public Builder setUnk3300JNALBACFNFN(boolean value) {
                this.unk3300JNALBACFNFN_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300JNALBACFNFN() {
                this.unk3300JNALBACFNFN_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder
            public int getDayRewardId() {
                return this.dayRewardId_;
            }

            public Builder setDayRewardId(int value) {
                this.dayRewardId_ = value;
                onChanged();
                return this;
            }

            public Builder clearDayRewardId() {
                this.dayRewardId_ = 0;
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

        public static SalesmanActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SalesmanActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SalesmanActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SalesmanActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SalesmanStatusTypeOuterClass.getDescriptor();
    }
}
