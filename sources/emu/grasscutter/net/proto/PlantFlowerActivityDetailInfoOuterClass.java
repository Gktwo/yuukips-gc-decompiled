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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlantFlowerActivityDetailInfoOuterClass.class */
public final class PlantFlowerActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#PlantFlowerActivityDetailInfo.proto\"©\u0003\n\u001dPlantFlowerActivityDetailInfo\u0012\u0011\n\tday_index\u0018\u0001 \u0001(\r\u0012\u001c\n\u0014today_seed_reward_id\u0018\u000f \u0001(\r\u0012\u0019\n\u0011is_content_closed\u0018\u0003 \u0001(\b\u0012S\n\u0013Unk3300_EPMKDFOBLFK\u0018\t \u0003(\u000b26.PlantFlowerActivityDetailInfo.Unk3300EPMKDFOBLFKEntry\u0012S\n\u0013Unk3300_ELAIBMDIBFJ\u0018\u0005 \u0003(\u000b26.PlantFlowerActivityDetailInfo.Unk3300ELAIBMDIBFJEntry\u0012\u001c\n\u0014is_today_has_awarded\u0018\b \u0001(\b\u001a9\n\u0017Unk3300EPMKDFOBLFKEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001\u001a9\n\u0017Unk3300ELAIBMDIBFJEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PlantFlowerActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlantFlowerActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlantFlowerActivityDetailInfo_descriptor, new String[]{"DayIndex", "TodaySeedRewardId", "IsContentClosed", "Unk3300EPMKDFOBLFK", "Unk3300ELAIBMDIBFJ", "IsTodayHasAwarded"});

    /* renamed from: internal_static_PlantFlowerActivityDetailInfo_Unk3300EPMKDFOBLFKEntry_descriptor */
    private static final Descriptors.Descriptor f823xa69fa497 = internal_static_PlantFlowerActivityDetailInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_PlantFlowerActivityDetailInfo_Unk3300EPMKDFOBLFKEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f824x6884415 = new GeneratedMessageV3.FieldAccessorTable(f823xa69fa497, new String[]{"Key", "Value"});

    /* renamed from: internal_static_PlantFlowerActivityDetailInfo_Unk3300ELAIBMDIBFJEntry_descriptor */
    private static final Descriptors.Descriptor f825xffc126ab = internal_static_PlantFlowerActivityDetailInfo_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_PlantFlowerActivityDetailInfo_Unk3300ELAIBMDIBFJEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f826x4607229 = new GeneratedMessageV3.FieldAccessorTable(f825xffc126ab, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlantFlowerActivityDetailInfoOuterClass$PlantFlowerActivityDetailInfoOrBuilder.class */
    public interface PlantFlowerActivityDetailInfoOrBuilder extends MessageOrBuilder {
        int getDayIndex();

        int getTodaySeedRewardId();

        boolean getIsContentClosed();

        int getUnk3300EPMKDFOBLFKCount();

        boolean containsUnk3300EPMKDFOBLFK(int i);

        @Deprecated
        Map<Integer, Integer> getUnk3300EPMKDFOBLFK();

        Map<Integer, Integer> getUnk3300EPMKDFOBLFKMap();

        int getUnk3300EPMKDFOBLFKOrDefault(int i, int i2);

        int getUnk3300EPMKDFOBLFKOrThrow(int i);

        int getUnk3300ELAIBMDIBFJCount();

        boolean containsUnk3300ELAIBMDIBFJ(int i);

        @Deprecated
        Map<Integer, Integer> getUnk3300ELAIBMDIBFJ();

        Map<Integer, Integer> getUnk3300ELAIBMDIBFJMap();

        int getUnk3300ELAIBMDIBFJOrDefault(int i, int i2);

        int getUnk3300ELAIBMDIBFJOrThrow(int i);

        boolean getIsTodayHasAwarded();
    }

    private PlantFlowerActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlantFlowerActivityDetailInfoOuterClass$PlantFlowerActivityDetailInfo.class */
    public static final class PlantFlowerActivityDetailInfo extends GeneratedMessageV3 implements PlantFlowerActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DAY_INDEX_FIELD_NUMBER = 1;
        private int dayIndex_;
        public static final int TODAY_SEED_REWARD_ID_FIELD_NUMBER = 15;
        private int todaySeedRewardId_;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 3;
        private boolean isContentClosed_;
        public static final int UNK3300_EPMKDFOBLFK_FIELD_NUMBER = 9;
        private MapField<Integer, Integer> unk3300EPMKDFOBLFK_;
        public static final int UNK3300_ELAIBMDIBFJ_FIELD_NUMBER = 5;
        private MapField<Integer, Integer> unk3300ELAIBMDIBFJ_;
        public static final int IS_TODAY_HAS_AWARDED_FIELD_NUMBER = 8;
        private boolean isTodayHasAwarded_;
        private byte memoizedIsInitialized;
        private static final PlantFlowerActivityDetailInfo DEFAULT_INSTANCE = new PlantFlowerActivityDetailInfo();
        private static final Parser<PlantFlowerActivityDetailInfo> PARSER = new AbstractParser<PlantFlowerActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public PlantFlowerActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlantFlowerActivityDetailInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 5: goto L_0x0021;
                    case 9: goto L_0x001c;
                    default: goto L_0x0026;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetUnk3300EPMKDFOBLFK()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetUnk3300ELAIBMDIBFJ()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private PlantFlowerActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlantFlowerActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlantFlowerActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlantFlowerActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.dayIndex_ = input.readUInt32();
                                break;
                            case 24:
                                this.isContentClosed_ = input.readBool();
                                break;
                            case 42:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.unk3300ELAIBMDIBFJ_ = MapField.newMapField(Unk3300ELAIBMDIBFJDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 2;
                                }
                                MapEntry<Integer, Integer> unk3300ELAIBMDIBFJ__ = (MapEntry) input.readMessage(Unk3300ELAIBMDIBFJDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.unk3300ELAIBMDIBFJ_.getMutableMap().put(unk3300ELAIBMDIBFJ__.getKey(), unk3300ELAIBMDIBFJ__.getValue());
                                break;
                            case 64:
                                this.isTodayHasAwarded_ = input.readBool();
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.unk3300EPMKDFOBLFK_ = MapField.newMapField(Unk3300EPMKDFOBLFKDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, Integer> unk3300EPMKDFOBLFK__ = (MapEntry) input.readMessage(Unk3300EPMKDFOBLFKDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.unk3300EPMKDFOBLFK_.getMutableMap().put(unk3300EPMKDFOBLFK__.getKey(), unk3300EPMKDFOBLFK__.getValue());
                                break;
                            case 120:
                                this.todaySeedRewardId_ = input.readUInt32();
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
            return PlantFlowerActivityDetailInfoOuterClass.internal_static_PlantFlowerActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlantFlowerActivityDetailInfoOuterClass.internal_static_PlantFlowerActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PlantFlowerActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
        public int getDayIndex() {
            return this.dayIndex_;
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
        public int getTodaySeedRewardId() {
            return this.todaySeedRewardId_;
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlantFlowerActivityDetailInfoOuterClass$PlantFlowerActivityDetailInfo$Unk3300EPMKDFOBLFKDefaultEntryHolder.class */
        public static final class Unk3300EPMKDFOBLFKDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(PlantFlowerActivityDetailInfoOuterClass.f823xa69fa497, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private Unk3300EPMKDFOBLFKDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetUnk3300EPMKDFOBLFK() {
            if (this.unk3300EPMKDFOBLFK_ == null) {
                return MapField.emptyMapField(Unk3300EPMKDFOBLFKDefaultEntryHolder.defaultEntry);
            }
            return this.unk3300EPMKDFOBLFK_;
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
        public int getUnk3300EPMKDFOBLFKCount() {
            return internalGetUnk3300EPMKDFOBLFK().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
        public boolean containsUnk3300EPMKDFOBLFK(int key) {
            return internalGetUnk3300EPMKDFOBLFK().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getUnk3300EPMKDFOBLFK() {
            return getUnk3300EPMKDFOBLFKMap();
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
        public Map<Integer, Integer> getUnk3300EPMKDFOBLFKMap() {
            return internalGetUnk3300EPMKDFOBLFK().getMap();
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
        public int getUnk3300EPMKDFOBLFKOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetUnk3300EPMKDFOBLFK().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
        public int getUnk3300EPMKDFOBLFKOrThrow(int key) {
            Map<Integer, Integer> map = internalGetUnk3300EPMKDFOBLFK().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlantFlowerActivityDetailInfoOuterClass$PlantFlowerActivityDetailInfo$Unk3300ELAIBMDIBFJDefaultEntryHolder.class */
        public static final class Unk3300ELAIBMDIBFJDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(PlantFlowerActivityDetailInfoOuterClass.f825xffc126ab, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private Unk3300ELAIBMDIBFJDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetUnk3300ELAIBMDIBFJ() {
            if (this.unk3300ELAIBMDIBFJ_ == null) {
                return MapField.emptyMapField(Unk3300ELAIBMDIBFJDefaultEntryHolder.defaultEntry);
            }
            return this.unk3300ELAIBMDIBFJ_;
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
        public int getUnk3300ELAIBMDIBFJCount() {
            return internalGetUnk3300ELAIBMDIBFJ().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
        public boolean containsUnk3300ELAIBMDIBFJ(int key) {
            return internalGetUnk3300ELAIBMDIBFJ().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getUnk3300ELAIBMDIBFJ() {
            return getUnk3300ELAIBMDIBFJMap();
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
        public Map<Integer, Integer> getUnk3300ELAIBMDIBFJMap() {
            return internalGetUnk3300ELAIBMDIBFJ().getMap();
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
        public int getUnk3300ELAIBMDIBFJOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetUnk3300ELAIBMDIBFJ().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
        public int getUnk3300ELAIBMDIBFJOrThrow(int key) {
            Map<Integer, Integer> map = internalGetUnk3300ELAIBMDIBFJ().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
        public boolean getIsTodayHasAwarded() {
            return this.isTodayHasAwarded_;
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
            if (this.dayIndex_ != 0) {
                output.writeUInt32(1, this.dayIndex_);
            }
            if (this.isContentClosed_) {
                output.writeBool(3, this.isContentClosed_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetUnk3300ELAIBMDIBFJ(), Unk3300ELAIBMDIBFJDefaultEntryHolder.defaultEntry, 5);
            if (this.isTodayHasAwarded_) {
                output.writeBool(8, this.isTodayHasAwarded_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetUnk3300EPMKDFOBLFK(), Unk3300EPMKDFOBLFKDefaultEntryHolder.defaultEntry, 9);
            if (this.todaySeedRewardId_ != 0) {
                output.writeUInt32(15, this.todaySeedRewardId_);
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
            if (this.dayIndex_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.dayIndex_);
            }
            if (this.isContentClosed_) {
                size2 += CodedOutputStream.computeBoolSize(3, this.isContentClosed_);
            }
            for (Map.Entry<Integer, Integer> entry : internalGetUnk3300ELAIBMDIBFJ().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(5, Unk3300ELAIBMDIBFJDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.isTodayHasAwarded_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.isTodayHasAwarded_);
            }
            for (Map.Entry<Integer, Integer> entry2 : internalGetUnk3300EPMKDFOBLFK().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(9, Unk3300EPMKDFOBLFKDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            if (this.todaySeedRewardId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.todaySeedRewardId_);
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
            if (!(obj instanceof PlantFlowerActivityDetailInfo)) {
                return equals(obj);
            }
            PlantFlowerActivityDetailInfo other = (PlantFlowerActivityDetailInfo) obj;
            return getDayIndex() == other.getDayIndex() && getTodaySeedRewardId() == other.getTodaySeedRewardId() && getIsContentClosed() == other.getIsContentClosed() && internalGetUnk3300EPMKDFOBLFK().equals(other.internalGetUnk3300EPMKDFOBLFK()) && internalGetUnk3300ELAIBMDIBFJ().equals(other.internalGetUnk3300ELAIBMDIBFJ()) && getIsTodayHasAwarded() == other.getIsTodayHasAwarded() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getDayIndex())) + 15)) + getTodaySeedRewardId())) + 3)) + Internal.hashBoolean(getIsContentClosed());
            if (!internalGetUnk3300EPMKDFOBLFK().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 9)) + internalGetUnk3300EPMKDFOBLFK().hashCode();
            }
            if (!internalGetUnk3300ELAIBMDIBFJ().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 5)) + internalGetUnk3300ELAIBMDIBFJ().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 8)) + Internal.hashBoolean(getIsTodayHasAwarded()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PlantFlowerActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlantFlowerActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlantFlowerActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlantFlowerActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlantFlowerActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlantFlowerActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlantFlowerActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (PlantFlowerActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlantFlowerActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlantFlowerActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlantFlowerActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (PlantFlowerActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlantFlowerActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlantFlowerActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlantFlowerActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (PlantFlowerActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlantFlowerActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlantFlowerActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlantFlowerActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlantFlowerActivityDetailInfoOuterClass$PlantFlowerActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlantFlowerActivityDetailInfoOrBuilder {
            private int bitField0_;
            private int dayIndex_;
            private int todaySeedRewardId_;
            private boolean isContentClosed_;
            private MapField<Integer, Integer> unk3300EPMKDFOBLFK_;
            private MapField<Integer, Integer> unk3300ELAIBMDIBFJ_;
            private boolean isTodayHasAwarded_;

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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 5: goto L_0x0021;
                        case 9: goto L_0x001c;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetUnk3300EPMKDFOBLFK()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetUnk3300ELAIBMDIBFJ()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 5: goto L_0x0021;
                        case 9: goto L_0x001c;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableUnk3300EPMKDFOBLFK()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableUnk3300ELAIBMDIBFJ()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PlantFlowerActivityDetailInfoOuterClass.internal_static_PlantFlowerActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlantFlowerActivityDetailInfoOuterClass.internal_static_PlantFlowerActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PlantFlowerActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlantFlowerActivityDetailInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.dayIndex_ = 0;
                this.todaySeedRewardId_ = 0;
                this.isContentClosed_ = false;
                internalGetMutableUnk3300EPMKDFOBLFK().clear();
                internalGetMutableUnk3300ELAIBMDIBFJ().clear();
                this.isTodayHasAwarded_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlantFlowerActivityDetailInfoOuterClass.internal_static_PlantFlowerActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlantFlowerActivityDetailInfo getDefaultInstanceForType() {
                return PlantFlowerActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlantFlowerActivityDetailInfo build() {
                PlantFlowerActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlantFlowerActivityDetailInfo buildPartial() {
                PlantFlowerActivityDetailInfo result = new PlantFlowerActivityDetailInfo(this);
                int i = this.bitField0_;
                result.dayIndex_ = this.dayIndex_;
                result.todaySeedRewardId_ = this.todaySeedRewardId_;
                result.isContentClosed_ = this.isContentClosed_;
                result.unk3300EPMKDFOBLFK_ = internalGetUnk3300EPMKDFOBLFK();
                result.unk3300EPMKDFOBLFK_.makeImmutable();
                result.unk3300ELAIBMDIBFJ_ = internalGetUnk3300ELAIBMDIBFJ();
                result.unk3300ELAIBMDIBFJ_.makeImmutable();
                result.isTodayHasAwarded_ = this.isTodayHasAwarded_;
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
                if (other instanceof PlantFlowerActivityDetailInfo) {
                    return mergeFrom((PlantFlowerActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlantFlowerActivityDetailInfo other) {
                if (other == PlantFlowerActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getDayIndex() != 0) {
                    setDayIndex(other.getDayIndex());
                }
                if (other.getTodaySeedRewardId() != 0) {
                    setTodaySeedRewardId(other.getTodaySeedRewardId());
                }
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
                }
                internalGetMutableUnk3300EPMKDFOBLFK().mergeFrom(other.internalGetUnk3300EPMKDFOBLFK());
                internalGetMutableUnk3300ELAIBMDIBFJ().mergeFrom(other.internalGetUnk3300ELAIBMDIBFJ());
                if (other.getIsTodayHasAwarded()) {
                    setIsTodayHasAwarded(other.getIsTodayHasAwarded());
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
                PlantFlowerActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlantFlowerActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlantFlowerActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
            public int getTodaySeedRewardId() {
                return this.todaySeedRewardId_;
            }

            public Builder setTodaySeedRewardId(int value) {
                this.todaySeedRewardId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTodaySeedRewardId() {
                this.todaySeedRewardId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
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

            private MapField<Integer, Integer> internalGetUnk3300EPMKDFOBLFK() {
                if (this.unk3300EPMKDFOBLFK_ == null) {
                    return MapField.emptyMapField(Unk3300EPMKDFOBLFKDefaultEntryHolder.defaultEntry);
                }
                return this.unk3300EPMKDFOBLFK_;
            }

            private MapField<Integer, Integer> internalGetMutableUnk3300EPMKDFOBLFK() {
                onChanged();
                if (this.unk3300EPMKDFOBLFK_ == null) {
                    this.unk3300EPMKDFOBLFK_ = MapField.newMapField(Unk3300EPMKDFOBLFKDefaultEntryHolder.defaultEntry);
                }
                if (!this.unk3300EPMKDFOBLFK_.isMutable()) {
                    this.unk3300EPMKDFOBLFK_ = this.unk3300EPMKDFOBLFK_.copy();
                }
                return this.unk3300EPMKDFOBLFK_;
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
            public int getUnk3300EPMKDFOBLFKCount() {
                return internalGetUnk3300EPMKDFOBLFK().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
            public boolean containsUnk3300EPMKDFOBLFK(int key) {
                return internalGetUnk3300EPMKDFOBLFK().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getUnk3300EPMKDFOBLFK() {
                return getUnk3300EPMKDFOBLFKMap();
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
            public Map<Integer, Integer> getUnk3300EPMKDFOBLFKMap() {
                return internalGetUnk3300EPMKDFOBLFK().getMap();
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
            public int getUnk3300EPMKDFOBLFKOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetUnk3300EPMKDFOBLFK().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
            public int getUnk3300EPMKDFOBLFKOrThrow(int key) {
                Map<Integer, Integer> map = internalGetUnk3300EPMKDFOBLFK().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearUnk3300EPMKDFOBLFK() {
                internalGetMutableUnk3300EPMKDFOBLFK().getMutableMap().clear();
                return this;
            }

            public Builder removeUnk3300EPMKDFOBLFK(int key) {
                internalGetMutableUnk3300EPMKDFOBLFK().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableUnk3300EPMKDFOBLFK() {
                return internalGetMutableUnk3300EPMKDFOBLFK().getMutableMap();
            }

            public Builder putUnk3300EPMKDFOBLFK(int key, int value) {
                internalGetMutableUnk3300EPMKDFOBLFK().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllUnk3300EPMKDFOBLFK(Map<Integer, Integer> values) {
                internalGetMutableUnk3300EPMKDFOBLFK().getMutableMap().putAll(values);
                return this;
            }

            private MapField<Integer, Integer> internalGetUnk3300ELAIBMDIBFJ() {
                if (this.unk3300ELAIBMDIBFJ_ == null) {
                    return MapField.emptyMapField(Unk3300ELAIBMDIBFJDefaultEntryHolder.defaultEntry);
                }
                return this.unk3300ELAIBMDIBFJ_;
            }

            private MapField<Integer, Integer> internalGetMutableUnk3300ELAIBMDIBFJ() {
                onChanged();
                if (this.unk3300ELAIBMDIBFJ_ == null) {
                    this.unk3300ELAIBMDIBFJ_ = MapField.newMapField(Unk3300ELAIBMDIBFJDefaultEntryHolder.defaultEntry);
                }
                if (!this.unk3300ELAIBMDIBFJ_.isMutable()) {
                    this.unk3300ELAIBMDIBFJ_ = this.unk3300ELAIBMDIBFJ_.copy();
                }
                return this.unk3300ELAIBMDIBFJ_;
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
            public int getUnk3300ELAIBMDIBFJCount() {
                return internalGetUnk3300ELAIBMDIBFJ().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
            public boolean containsUnk3300ELAIBMDIBFJ(int key) {
                return internalGetUnk3300ELAIBMDIBFJ().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getUnk3300ELAIBMDIBFJ() {
                return getUnk3300ELAIBMDIBFJMap();
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
            public Map<Integer, Integer> getUnk3300ELAIBMDIBFJMap() {
                return internalGetUnk3300ELAIBMDIBFJ().getMap();
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
            public int getUnk3300ELAIBMDIBFJOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetUnk3300ELAIBMDIBFJ().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
            public int getUnk3300ELAIBMDIBFJOrThrow(int key) {
                Map<Integer, Integer> map = internalGetUnk3300ELAIBMDIBFJ().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearUnk3300ELAIBMDIBFJ() {
                internalGetMutableUnk3300ELAIBMDIBFJ().getMutableMap().clear();
                return this;
            }

            public Builder removeUnk3300ELAIBMDIBFJ(int key) {
                internalGetMutableUnk3300ELAIBMDIBFJ().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableUnk3300ELAIBMDIBFJ() {
                return internalGetMutableUnk3300ELAIBMDIBFJ().getMutableMap();
            }

            public Builder putUnk3300ELAIBMDIBFJ(int key, int value) {
                internalGetMutableUnk3300ELAIBMDIBFJ().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllUnk3300ELAIBMDIBFJ(Map<Integer, Integer> values) {
                internalGetMutableUnk3300ELAIBMDIBFJ().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder
            public boolean getIsTodayHasAwarded() {
                return this.isTodayHasAwarded_;
            }

            public Builder setIsTodayHasAwarded(boolean value) {
                this.isTodayHasAwarded_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsTodayHasAwarded() {
                this.isTodayHasAwarded_ = false;
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

        public static PlantFlowerActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlantFlowerActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlantFlowerActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlantFlowerActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
