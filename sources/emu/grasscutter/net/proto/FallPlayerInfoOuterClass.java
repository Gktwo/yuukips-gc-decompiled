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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FallPlayerInfoOuterClass.class */
public final class FallPlayerInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014FallPlayerInfo.proto\"Ð\u0001\n\u000eFallPlayerInfo\u0012\u0010\n\btimeCost\u0018\n \u0001(\r\u0012\u000b\n\u0003uid\u0018\u0004 \u0001(\r\u0012A\n\u0011ballCatchCountMap\u0018\b \u0003(\u000b2&.FallPlayerInfo.BallCatchCountMapEntry\u0012\u0010\n\bcurScore\u0018\u000b \u0001(\r\u0012\u0010\n\bisGround\u0018\u000f \u0001(\b\u001a8\n\u0016BallCatchCountMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_FallPlayerInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FallPlayerInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FallPlayerInfo_descriptor, new String[]{"TimeCost", "Uid", "BallCatchCountMap", "CurScore", "IsGround"});
    private static final Descriptors.Descriptor internal_static_FallPlayerInfo_BallCatchCountMapEntry_descriptor = internal_static_FallPlayerInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_FallPlayerInfo_BallCatchCountMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f705xd95ba51d = new GeneratedMessageV3.FieldAccessorTable(internal_static_FallPlayerInfo_BallCatchCountMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FallPlayerInfoOuterClass$FallPlayerInfoOrBuilder.class */
    public interface FallPlayerInfoOrBuilder extends MessageOrBuilder {
        int getTimeCost();

        int getUid();

        int getBallCatchCountMapCount();

        boolean containsBallCatchCountMap(int i);

        @Deprecated
        Map<Integer, Integer> getBallCatchCountMap();

        Map<Integer, Integer> getBallCatchCountMapMap();

        int getBallCatchCountMapOrDefault(int i, int i2);

        int getBallCatchCountMapOrThrow(int i);

        int getCurScore();

        boolean getIsGround();
    }

    private FallPlayerInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FallPlayerInfoOuterClass$FallPlayerInfo.class */
    public static final class FallPlayerInfo extends GeneratedMessageV3 implements FallPlayerInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TIMECOST_FIELD_NUMBER = 10;
        private int timeCost_;
        public static final int UID_FIELD_NUMBER = 4;
        private int uid_;
        public static final int BALLCATCHCOUNTMAP_FIELD_NUMBER = 8;
        private MapField<Integer, Integer> ballCatchCountMap_;
        public static final int CURSCORE_FIELD_NUMBER = 11;
        private int curScore_;
        public static final int ISGROUND_FIELD_NUMBER = 15;
        private boolean isGround_;
        private byte memoizedIsInitialized;
        private static final FallPlayerInfo DEFAULT_INSTANCE = new FallPlayerInfo();
        private static final Parser<FallPlayerInfo> PARSER = new AbstractParser<FallPlayerInfo>() { // from class: emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfo.1
            @Override // com.google.protobuf.Parser
            public FallPlayerInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FallPlayerInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                com.google.protobuf.MapField r0 = r0.internalGetBallCatchCountMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private FallPlayerInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FallPlayerInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FallPlayerInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FallPlayerInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 32:
                                    this.uid_ = input.readUInt32();
                                    break;
                                case 66:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.ballCatchCountMap_ = MapField.newMapField(BallCatchCountMapDefaultEntryHolder.defaultEntry);
                                        mutable_bitField0_ |= 1;
                                    }
                                    MapEntry<Integer, Integer> ballCatchCountMap__ = (MapEntry) input.readMessage(BallCatchCountMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                    this.ballCatchCountMap_.getMutableMap().put(ballCatchCountMap__.getKey(), ballCatchCountMap__.getValue());
                                    break;
                                case 80:
                                    this.timeCost_ = input.readUInt32();
                                    break;
                                case 88:
                                    this.curScore_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.isGround_ = input.readBool();
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FallPlayerInfoOuterClass.internal_static_FallPlayerInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FallPlayerInfoOuterClass.internal_static_FallPlayerInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FallPlayerInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfoOrBuilder
        public int getTimeCost() {
            return this.timeCost_;
        }

        @Override // emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfoOrBuilder
        public int getUid() {
            return this.uid_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FallPlayerInfoOuterClass$FallPlayerInfo$BallCatchCountMapDefaultEntryHolder.class */
        public static final class BallCatchCountMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(FallPlayerInfoOuterClass.internal_static_FallPlayerInfo_BallCatchCountMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private BallCatchCountMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetBallCatchCountMap() {
            if (this.ballCatchCountMap_ == null) {
                return MapField.emptyMapField(BallCatchCountMapDefaultEntryHolder.defaultEntry);
            }
            return this.ballCatchCountMap_;
        }

        @Override // emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfoOrBuilder
        public int getBallCatchCountMapCount() {
            return internalGetBallCatchCountMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfoOrBuilder
        public boolean containsBallCatchCountMap(int key) {
            return internalGetBallCatchCountMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getBallCatchCountMap() {
            return getBallCatchCountMapMap();
        }

        @Override // emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfoOrBuilder
        public Map<Integer, Integer> getBallCatchCountMapMap() {
            return internalGetBallCatchCountMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfoOrBuilder
        public int getBallCatchCountMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetBallCatchCountMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfoOrBuilder
        public int getBallCatchCountMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetBallCatchCountMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfoOrBuilder
        public int getCurScore() {
            return this.curScore_;
        }

        @Override // emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfoOrBuilder
        public boolean getIsGround() {
            return this.isGround_;
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
            if (this.uid_ != 0) {
                output.writeUInt32(4, this.uid_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetBallCatchCountMap(), BallCatchCountMapDefaultEntryHolder.defaultEntry, 8);
            if (this.timeCost_ != 0) {
                output.writeUInt32(10, this.timeCost_);
            }
            if (this.curScore_ != 0) {
                output.writeUInt32(11, this.curScore_);
            }
            if (this.isGround_) {
                output.writeBool(15, this.isGround_);
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
            if (this.uid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.uid_);
            }
            for (Map.Entry<Integer, Integer> entry : internalGetBallCatchCountMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(8, BallCatchCountMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.timeCost_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.timeCost_);
            }
            if (this.curScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.curScore_);
            }
            if (this.isGround_) {
                size2 += CodedOutputStream.computeBoolSize(15, this.isGround_);
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
            if (!(obj instanceof FallPlayerInfo)) {
                return equals(obj);
            }
            FallPlayerInfo other = (FallPlayerInfo) obj;
            return getTimeCost() == other.getTimeCost() && getUid() == other.getUid() && internalGetBallCatchCountMap().equals(other.internalGetBallCatchCountMap()) && getCurScore() == other.getCurScore() && getIsGround() == other.getIsGround() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getTimeCost())) + 4)) + getUid();
            if (!internalGetBallCatchCountMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 8)) + internalGetBallCatchCountMap().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 11)) + getCurScore())) + 15)) + Internal.hashBoolean(getIsGround()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FallPlayerInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FallPlayerInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FallPlayerInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FallPlayerInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FallPlayerInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FallPlayerInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FallPlayerInfo parseFrom(InputStream input) throws IOException {
            return (FallPlayerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FallPlayerInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FallPlayerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FallPlayerInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (FallPlayerInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FallPlayerInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FallPlayerInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FallPlayerInfo parseFrom(CodedInputStream input) throws IOException {
            return (FallPlayerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FallPlayerInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FallPlayerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FallPlayerInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FallPlayerInfoOuterClass$FallPlayerInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FallPlayerInfoOrBuilder {
            private int bitField0_;
            private int timeCost_;
            private int uid_;
            private MapField<Integer, Integer> ballCatchCountMap_;
            private int curScore_;
            private boolean isGround_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetBallCatchCountMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetMutableBallCatchCountMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return FallPlayerInfoOuterClass.internal_static_FallPlayerInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FallPlayerInfoOuterClass.internal_static_FallPlayerInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FallPlayerInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FallPlayerInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.timeCost_ = 0;
                this.uid_ = 0;
                internalGetMutableBallCatchCountMap().clear();
                this.curScore_ = 0;
                this.isGround_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FallPlayerInfoOuterClass.internal_static_FallPlayerInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FallPlayerInfo getDefaultInstanceForType() {
                return FallPlayerInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FallPlayerInfo build() {
                FallPlayerInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FallPlayerInfo buildPartial() {
                FallPlayerInfo result = new FallPlayerInfo(this);
                int i = this.bitField0_;
                result.timeCost_ = this.timeCost_;
                result.uid_ = this.uid_;
                result.ballCatchCountMap_ = internalGetBallCatchCountMap();
                result.ballCatchCountMap_.makeImmutable();
                result.curScore_ = this.curScore_;
                result.isGround_ = this.isGround_;
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
                if (other instanceof FallPlayerInfo) {
                    return mergeFrom((FallPlayerInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FallPlayerInfo other) {
                if (other == FallPlayerInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getTimeCost() != 0) {
                    setTimeCost(other.getTimeCost());
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
                }
                internalGetMutableBallCatchCountMap().mergeFrom(other.internalGetBallCatchCountMap());
                if (other.getCurScore() != 0) {
                    setCurScore(other.getCurScore());
                }
                if (other.getIsGround()) {
                    setIsGround(other.getIsGround());
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
                FallPlayerInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = FallPlayerInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FallPlayerInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfoOrBuilder
            public int getTimeCost() {
                return this.timeCost_;
            }

            public Builder setTimeCost(int value) {
                this.timeCost_ = value;
                onChanged();
                return this;
            }

            public Builder clearTimeCost() {
                this.timeCost_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfoOrBuilder
            public int getUid() {
                return this.uid_;
            }

            public Builder setUid(int value) {
                this.uid_ = value;
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.uid_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetBallCatchCountMap() {
                if (this.ballCatchCountMap_ == null) {
                    return MapField.emptyMapField(BallCatchCountMapDefaultEntryHolder.defaultEntry);
                }
                return this.ballCatchCountMap_;
            }

            private MapField<Integer, Integer> internalGetMutableBallCatchCountMap() {
                onChanged();
                if (this.ballCatchCountMap_ == null) {
                    this.ballCatchCountMap_ = MapField.newMapField(BallCatchCountMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.ballCatchCountMap_.isMutable()) {
                    this.ballCatchCountMap_ = this.ballCatchCountMap_.copy();
                }
                return this.ballCatchCountMap_;
            }

            @Override // emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfoOrBuilder
            public int getBallCatchCountMapCount() {
                return internalGetBallCatchCountMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfoOrBuilder
            public boolean containsBallCatchCountMap(int key) {
                return internalGetBallCatchCountMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getBallCatchCountMap() {
                return getBallCatchCountMapMap();
            }

            @Override // emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfoOrBuilder
            public Map<Integer, Integer> getBallCatchCountMapMap() {
                return internalGetBallCatchCountMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfoOrBuilder
            public int getBallCatchCountMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetBallCatchCountMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfoOrBuilder
            public int getBallCatchCountMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetBallCatchCountMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearBallCatchCountMap() {
                internalGetMutableBallCatchCountMap().getMutableMap().clear();
                return this;
            }

            public Builder removeBallCatchCountMap(int key) {
                internalGetMutableBallCatchCountMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableBallCatchCountMap() {
                return internalGetMutableBallCatchCountMap().getMutableMap();
            }

            public Builder putBallCatchCountMap(int key, int value) {
                internalGetMutableBallCatchCountMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllBallCatchCountMap(Map<Integer, Integer> values) {
                internalGetMutableBallCatchCountMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfoOrBuilder
            public int getCurScore() {
                return this.curScore_;
            }

            public Builder setCurScore(int value) {
                this.curScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurScore() {
                this.curScore_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FallPlayerInfoOuterClass.FallPlayerInfoOrBuilder
            public boolean getIsGround() {
                return this.isGround_;
            }

            public Builder setIsGround(boolean value) {
                this.isGround_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsGround() {
                this.isGround_ = false;
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

        public static FallPlayerInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FallPlayerInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FallPlayerInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FallPlayerInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
