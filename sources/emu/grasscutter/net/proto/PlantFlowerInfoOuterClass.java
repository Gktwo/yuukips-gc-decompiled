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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlantFlowerInfoOuterClass.class */
public final class PlantFlowerInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015PlantFlowerInfo.proto\"ó\u0002\n\u000fPlantFlowerInfo\u0012E\n\u0013Unk3300_ELAIBMDIBFJ\u0018\u000e \u0003(\u000b2(.PlantFlowerInfo.Unk3300ELAIBMDIBFJEntry\u0012\u0010\n\bdayIndex\u0018\b \u0001(\r\u0012\u0019\n\u0011isTodayHasAwarded\u0018\u0002 \u0001(\b\u0012\u0014\n\fleftMonsters\u0018\u0001 \u0001(\b\u0012E\n\u0013Unk3300_EPMKDFOBLFK\u0018\u000b \u0003(\u000b2(.PlantFlowerInfo.Unk3300EPMKDFOBLFKEntry\u0012\u0019\n\u0011todaySeedRewardId\u0018\u0004 \u0001(\r\u001a9\n\u0017Unk3300ELAIBMDIBFJEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001\u001a9\n\u0017Unk3300EPMKDFOBLFKEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PlantFlowerInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlantFlowerInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlantFlowerInfo_descriptor, new String[]{"Unk3300ELAIBMDIBFJ", "DayIndex", "IsTodayHasAwarded", "LeftMonsters", "Unk3300EPMKDFOBLFK", "TodaySeedRewardId"});

    /* renamed from: internal_static_PlantFlowerInfo_Unk3300ELAIBMDIBFJEntry_descriptor */
    private static final Descriptors.Descriptor f801x4c3d8acb = internal_static_PlantFlowerInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_PlantFlowerInfo_Unk3300ELAIBMDIBFJEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f802x58c6b649 = new GeneratedMessageV3.FieldAccessorTable(f801x4c3d8acb, new String[]{"Key", "Value"});

    /* renamed from: internal_static_PlantFlowerInfo_Unk3300EPMKDFOBLFKEntry_descriptor */
    private static final Descriptors.Descriptor f803xf31c08b7 = internal_static_PlantFlowerInfo_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_PlantFlowerInfo_Unk3300EPMKDFOBLFKEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f804x5aee8835 = new GeneratedMessageV3.FieldAccessorTable(f803xf31c08b7, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlantFlowerInfoOuterClass$PlantFlowerInfoOrBuilder.class */
    public interface PlantFlowerInfoOrBuilder extends MessageOrBuilder {
        int getUnk3300ELAIBMDIBFJCount();

        boolean containsUnk3300ELAIBMDIBFJ(int i);

        @Deprecated
        Map<Integer, Integer> getUnk3300ELAIBMDIBFJ();

        Map<Integer, Integer> getUnk3300ELAIBMDIBFJMap();

        int getUnk3300ELAIBMDIBFJOrDefault(int i, int i2);

        int getUnk3300ELAIBMDIBFJOrThrow(int i);

        int getDayIndex();

        boolean getIsTodayHasAwarded();

        boolean getLeftMonsters();

        int getUnk3300EPMKDFOBLFKCount();

        boolean containsUnk3300EPMKDFOBLFK(int i);

        @Deprecated
        Map<Integer, Integer> getUnk3300EPMKDFOBLFK();

        Map<Integer, Integer> getUnk3300EPMKDFOBLFKMap();

        int getUnk3300EPMKDFOBLFKOrDefault(int i, int i2);

        int getUnk3300EPMKDFOBLFKOrThrow(int i);

        int getTodaySeedRewardId();
    }

    private PlantFlowerInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlantFlowerInfoOuterClass$PlantFlowerInfo.class */
    public static final class PlantFlowerInfo extends GeneratedMessageV3 implements PlantFlowerInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_ELAIBMDIBFJ_FIELD_NUMBER = 14;
        private MapField<Integer, Integer> unk3300ELAIBMDIBFJ_;
        public static final int DAYINDEX_FIELD_NUMBER = 8;
        private int dayIndex_;
        public static final int ISTODAYHASAWARDED_FIELD_NUMBER = 2;
        private boolean isTodayHasAwarded_;
        public static final int LEFTMONSTERS_FIELD_NUMBER = 1;
        private boolean leftMonsters_;
        public static final int UNK3300_EPMKDFOBLFK_FIELD_NUMBER = 11;
        private MapField<Integer, Integer> unk3300EPMKDFOBLFK_;
        public static final int TODAYSEEDREWARDID_FIELD_NUMBER = 4;
        private int todaySeedRewardId_;
        private byte memoizedIsInitialized;
        private static final PlantFlowerInfo DEFAULT_INSTANCE = new PlantFlowerInfo();
        private static final Parser<PlantFlowerInfo> PARSER = new AbstractParser<PlantFlowerInfo>() { // from class: emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfo.1
            @Override // com.google.protobuf.Parser
            public PlantFlowerInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlantFlowerInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 11: goto L_0x0021;
                    case 14: goto L_0x001c;
                    default: goto L_0x0026;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetUnk3300ELAIBMDIBFJ()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetUnk3300EPMKDFOBLFK()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private PlantFlowerInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlantFlowerInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlantFlowerInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlantFlowerInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.leftMonsters_ = input.readBool();
                                break;
                            case 16:
                                this.isTodayHasAwarded_ = input.readBool();
                                break;
                            case 32:
                                this.todaySeedRewardId_ = input.readUInt32();
                                break;
                            case 64:
                                this.dayIndex_ = input.readUInt32();
                                break;
                            case 90:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.unk3300EPMKDFOBLFK_ = MapField.newMapField(Unk3300EPMKDFOBLFKDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 2;
                                }
                                MapEntry<Integer, Integer> unk3300EPMKDFOBLFK__ = (MapEntry) input.readMessage(Unk3300EPMKDFOBLFKDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.unk3300EPMKDFOBLFK_.getMutableMap().put(unk3300EPMKDFOBLFK__.getKey(), unk3300EPMKDFOBLFK__.getValue());
                                break;
                            case 114:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.unk3300ELAIBMDIBFJ_ = MapField.newMapField(Unk3300ELAIBMDIBFJDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, Integer> unk3300ELAIBMDIBFJ__ = (MapEntry) input.readMessage(Unk3300ELAIBMDIBFJDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.unk3300ELAIBMDIBFJ_.getMutableMap().put(unk3300ELAIBMDIBFJ__.getKey(), unk3300ELAIBMDIBFJ__.getValue());
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
            return PlantFlowerInfoOuterClass.internal_static_PlantFlowerInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlantFlowerInfoOuterClass.internal_static_PlantFlowerInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PlantFlowerInfo.class, Builder.class);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlantFlowerInfoOuterClass$PlantFlowerInfo$Unk3300ELAIBMDIBFJDefaultEntryHolder.class */
        public static final class Unk3300ELAIBMDIBFJDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(PlantFlowerInfoOuterClass.f801x4c3d8acb, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private Unk3300ELAIBMDIBFJDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetUnk3300ELAIBMDIBFJ() {
            if (this.unk3300ELAIBMDIBFJ_ == null) {
                return MapField.emptyMapField(Unk3300ELAIBMDIBFJDefaultEntryHolder.defaultEntry);
            }
            return this.unk3300ELAIBMDIBFJ_;
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
        public int getUnk3300ELAIBMDIBFJCount() {
            return internalGetUnk3300ELAIBMDIBFJ().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
        public boolean containsUnk3300ELAIBMDIBFJ(int key) {
            return internalGetUnk3300ELAIBMDIBFJ().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getUnk3300ELAIBMDIBFJ() {
            return getUnk3300ELAIBMDIBFJMap();
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
        public Map<Integer, Integer> getUnk3300ELAIBMDIBFJMap() {
            return internalGetUnk3300ELAIBMDIBFJ().getMap();
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
        public int getUnk3300ELAIBMDIBFJOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetUnk3300ELAIBMDIBFJ().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
        public int getUnk3300ELAIBMDIBFJOrThrow(int key) {
            Map<Integer, Integer> map = internalGetUnk3300ELAIBMDIBFJ().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
        public int getDayIndex() {
            return this.dayIndex_;
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
        public boolean getIsTodayHasAwarded() {
            return this.isTodayHasAwarded_;
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
        public boolean getLeftMonsters() {
            return this.leftMonsters_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlantFlowerInfoOuterClass$PlantFlowerInfo$Unk3300EPMKDFOBLFKDefaultEntryHolder.class */
        public static final class Unk3300EPMKDFOBLFKDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(PlantFlowerInfoOuterClass.f803xf31c08b7, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private Unk3300EPMKDFOBLFKDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetUnk3300EPMKDFOBLFK() {
            if (this.unk3300EPMKDFOBLFK_ == null) {
                return MapField.emptyMapField(Unk3300EPMKDFOBLFKDefaultEntryHolder.defaultEntry);
            }
            return this.unk3300EPMKDFOBLFK_;
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
        public int getUnk3300EPMKDFOBLFKCount() {
            return internalGetUnk3300EPMKDFOBLFK().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
        public boolean containsUnk3300EPMKDFOBLFK(int key) {
            return internalGetUnk3300EPMKDFOBLFK().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getUnk3300EPMKDFOBLFK() {
            return getUnk3300EPMKDFOBLFKMap();
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
        public Map<Integer, Integer> getUnk3300EPMKDFOBLFKMap() {
            return internalGetUnk3300EPMKDFOBLFK().getMap();
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
        public int getUnk3300EPMKDFOBLFKOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetUnk3300EPMKDFOBLFK().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
        public int getUnk3300EPMKDFOBLFKOrThrow(int key) {
            Map<Integer, Integer> map = internalGetUnk3300EPMKDFOBLFK().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
        public int getTodaySeedRewardId() {
            return this.todaySeedRewardId_;
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
                output.writeBool(1, this.leftMonsters_);
            }
            if (this.isTodayHasAwarded_) {
                output.writeBool(2, this.isTodayHasAwarded_);
            }
            if (this.todaySeedRewardId_ != 0) {
                output.writeUInt32(4, this.todaySeedRewardId_);
            }
            if (this.dayIndex_ != 0) {
                output.writeUInt32(8, this.dayIndex_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetUnk3300EPMKDFOBLFK(), Unk3300EPMKDFOBLFKDefaultEntryHolder.defaultEntry, 11);
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetUnk3300ELAIBMDIBFJ(), Unk3300ELAIBMDIBFJDefaultEntryHolder.defaultEntry, 14);
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
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.leftMonsters_);
            }
            if (this.isTodayHasAwarded_) {
                size2 += CodedOutputStream.computeBoolSize(2, this.isTodayHasAwarded_);
            }
            if (this.todaySeedRewardId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.todaySeedRewardId_);
            }
            if (this.dayIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.dayIndex_);
            }
            for (Map.Entry<Integer, Integer> entry : internalGetUnk3300EPMKDFOBLFK().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(11, Unk3300EPMKDFOBLFKDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            for (Map.Entry<Integer, Integer> entry2 : internalGetUnk3300ELAIBMDIBFJ().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(14, Unk3300ELAIBMDIBFJDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
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
            if (!(obj instanceof PlantFlowerInfo)) {
                return equals(obj);
            }
            PlantFlowerInfo other = (PlantFlowerInfo) obj;
            return internalGetUnk3300ELAIBMDIBFJ().equals(other.internalGetUnk3300ELAIBMDIBFJ()) && getDayIndex() == other.getDayIndex() && getIsTodayHasAwarded() == other.getIsTodayHasAwarded() && getLeftMonsters() == other.getLeftMonsters() && internalGetUnk3300EPMKDFOBLFK().equals(other.internalGetUnk3300EPMKDFOBLFK()) && getTodaySeedRewardId() == other.getTodaySeedRewardId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (!internalGetUnk3300ELAIBMDIBFJ().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 14)) + internalGetUnk3300ELAIBMDIBFJ().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 8)) + getDayIndex())) + 2)) + Internal.hashBoolean(getIsTodayHasAwarded()))) + 1)) + Internal.hashBoolean(getLeftMonsters());
            if (!internalGetUnk3300EPMKDFOBLFK().getMap().isEmpty()) {
                hash2 = (53 * ((37 * hash2) + 11)) + internalGetUnk3300EPMKDFOBLFK().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 4)) + getTodaySeedRewardId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static PlantFlowerInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlantFlowerInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlantFlowerInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlantFlowerInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlantFlowerInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlantFlowerInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlantFlowerInfo parseFrom(InputStream input) throws IOException {
            return (PlantFlowerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlantFlowerInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlantFlowerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlantFlowerInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (PlantFlowerInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlantFlowerInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlantFlowerInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlantFlowerInfo parseFrom(CodedInputStream input) throws IOException {
            return (PlantFlowerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlantFlowerInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlantFlowerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlantFlowerInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlantFlowerInfoOuterClass$PlantFlowerInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlantFlowerInfoOrBuilder {
            private int bitField0_;
            private MapField<Integer, Integer> unk3300ELAIBMDIBFJ_;
            private int dayIndex_;
            private boolean isTodayHasAwarded_;
            private boolean leftMonsters_;
            private MapField<Integer, Integer> unk3300EPMKDFOBLFK_;
            private int todaySeedRewardId_;

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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 11: goto L_0x0021;
                        case 14: goto L_0x001c;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetUnk3300ELAIBMDIBFJ()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetUnk3300EPMKDFOBLFK()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 11: goto L_0x0021;
                        case 14: goto L_0x001c;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableUnk3300ELAIBMDIBFJ()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableUnk3300EPMKDFOBLFK()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PlantFlowerInfoOuterClass.internal_static_PlantFlowerInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlantFlowerInfoOuterClass.internal_static_PlantFlowerInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PlantFlowerInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlantFlowerInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                internalGetMutableUnk3300ELAIBMDIBFJ().clear();
                this.dayIndex_ = 0;
                this.isTodayHasAwarded_ = false;
                this.leftMonsters_ = false;
                internalGetMutableUnk3300EPMKDFOBLFK().clear();
                this.todaySeedRewardId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlantFlowerInfoOuterClass.internal_static_PlantFlowerInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlantFlowerInfo getDefaultInstanceForType() {
                return PlantFlowerInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlantFlowerInfo build() {
                PlantFlowerInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlantFlowerInfo buildPartial() {
                PlantFlowerInfo result = new PlantFlowerInfo(this);
                int i = this.bitField0_;
                result.unk3300ELAIBMDIBFJ_ = internalGetUnk3300ELAIBMDIBFJ();
                result.unk3300ELAIBMDIBFJ_.makeImmutable();
                result.dayIndex_ = this.dayIndex_;
                result.isTodayHasAwarded_ = this.isTodayHasAwarded_;
                result.leftMonsters_ = this.leftMonsters_;
                result.unk3300EPMKDFOBLFK_ = internalGetUnk3300EPMKDFOBLFK();
                result.unk3300EPMKDFOBLFK_.makeImmutable();
                result.todaySeedRewardId_ = this.todaySeedRewardId_;
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
                if (other instanceof PlantFlowerInfo) {
                    return mergeFrom((PlantFlowerInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlantFlowerInfo other) {
                if (other == PlantFlowerInfo.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableUnk3300ELAIBMDIBFJ().mergeFrom(other.internalGetUnk3300ELAIBMDIBFJ());
                if (other.getDayIndex() != 0) {
                    setDayIndex(other.getDayIndex());
                }
                if (other.getIsTodayHasAwarded()) {
                    setIsTodayHasAwarded(other.getIsTodayHasAwarded());
                }
                if (other.getLeftMonsters()) {
                    setLeftMonsters(other.getLeftMonsters());
                }
                internalGetMutableUnk3300EPMKDFOBLFK().mergeFrom(other.internalGetUnk3300EPMKDFOBLFK());
                if (other.getTodaySeedRewardId() != 0) {
                    setTodaySeedRewardId(other.getTodaySeedRewardId());
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
                PlantFlowerInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlantFlowerInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlantFlowerInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
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

            @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
            public int getUnk3300ELAIBMDIBFJCount() {
                return internalGetUnk3300ELAIBMDIBFJ().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
            public boolean containsUnk3300ELAIBMDIBFJ(int key) {
                return internalGetUnk3300ELAIBMDIBFJ().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getUnk3300ELAIBMDIBFJ() {
                return getUnk3300ELAIBMDIBFJMap();
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
            public Map<Integer, Integer> getUnk3300ELAIBMDIBFJMap() {
                return internalGetUnk3300ELAIBMDIBFJ().getMap();
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
            public int getUnk3300ELAIBMDIBFJOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetUnk3300ELAIBMDIBFJ().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
            public int getUnk3300EPMKDFOBLFKCount() {
                return internalGetUnk3300EPMKDFOBLFK().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
            public boolean containsUnk3300EPMKDFOBLFK(int key) {
                return internalGetUnk3300EPMKDFOBLFK().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getUnk3300EPMKDFOBLFK() {
                return getUnk3300EPMKDFOBLFKMap();
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
            public Map<Integer, Integer> getUnk3300EPMKDFOBLFKMap() {
                return internalGetUnk3300EPMKDFOBLFK().getMap();
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
            public int getUnk3300EPMKDFOBLFKOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetUnk3300EPMKDFOBLFK().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static PlantFlowerInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlantFlowerInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlantFlowerInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlantFlowerInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
