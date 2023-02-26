package emu.grasscutter.net.proto;

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
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import emu.grasscutter.net.proto.BalloonPlayerInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BalloonInfoOuterClass.class */
public final class BalloonInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011BalloonInfo.proto\u001a\u0017BalloonPlayerInfo.proto\"Ä\u0001\n\u000bBalloonInfo\u0012N\n\u0019scenePlayerBalloonInfoMap\u0018\r \u0003(\u000b2+.BalloonInfo.ScenePlayerBalloonInfoMapEntry\u0012\u000f\n\u0007endTime\u0018\u0007 \u0001(\r\u001aT\n\u001eScenePlayerBalloonInfoMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012!\n\u0005value\u0018\u0002 \u0001(\u000b2\u0012.BalloonPlayerInfo:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BalloonPlayerInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BalloonInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BalloonInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BalloonInfo_descriptor, new String[]{"ScenePlayerBalloonInfoMap", "EndTime"});

    /* renamed from: internal_static_BalloonInfo_ScenePlayerBalloonInfoMapEntry_descriptor */
    private static final Descriptors.Descriptor f656x790f02b7 = internal_static_BalloonInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_BalloonInfo_ScenePlayerBalloonInfoMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f657xa3478235 = new GeneratedMessageV3.FieldAccessorTable(f656x790f02b7, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BalloonInfoOuterClass$BalloonInfoOrBuilder.class */
    public interface BalloonInfoOrBuilder extends MessageOrBuilder {
        int getScenePlayerBalloonInfoMapCount();

        boolean containsScenePlayerBalloonInfoMap(int i);

        @Deprecated
        Map<Integer, BalloonPlayerInfoOuterClass.BalloonPlayerInfo> getScenePlayerBalloonInfoMap();

        Map<Integer, BalloonPlayerInfoOuterClass.BalloonPlayerInfo> getScenePlayerBalloonInfoMapMap();

        BalloonPlayerInfoOuterClass.BalloonPlayerInfo getScenePlayerBalloonInfoMapOrDefault(int i, BalloonPlayerInfoOuterClass.BalloonPlayerInfo balloonPlayerInfo);

        BalloonPlayerInfoOuterClass.BalloonPlayerInfo getScenePlayerBalloonInfoMapOrThrow(int i);

        int getEndTime();
    }

    private BalloonInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BalloonInfoOuterClass$BalloonInfo.class */
    public static final class BalloonInfo extends GeneratedMessageV3 implements BalloonInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SCENEPLAYERBALLOONINFOMAP_FIELD_NUMBER = 13;
        private MapField<Integer, BalloonPlayerInfoOuterClass.BalloonPlayerInfo> scenePlayerBalloonInfoMap_;
        public static final int ENDTIME_FIELD_NUMBER = 7;
        private int endTime_;
        private byte memoizedIsInitialized;
        private static final BalloonInfo DEFAULT_INSTANCE = new BalloonInfo();
        private static final Parser<BalloonInfo> PARSER = new AbstractParser<BalloonInfo>() { // from class: emu.grasscutter.net.proto.BalloonInfoOuterClass.BalloonInfo.1
            @Override // com.google.protobuf.Parser
            public BalloonInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BalloonInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.BalloonInfoOuterClass.BalloonInfo.internalGetMapField(int):com.google.protobuf.MapField
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
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
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
                    case 13: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetScenePlayerBalloonInfoMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.BalloonInfoOuterClass.BalloonInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private BalloonInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BalloonInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BalloonInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BalloonInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 56:
                                this.endTime_ = input.readUInt32();
                                break;
                            case 106:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.scenePlayerBalloonInfoMap_ = MapField.newMapField(ScenePlayerBalloonInfoMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, BalloonPlayerInfoOuterClass.BalloonPlayerInfo> scenePlayerBalloonInfoMap__ = (MapEntry) input.readMessage(ScenePlayerBalloonInfoMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.scenePlayerBalloonInfoMap_.getMutableMap().put(scenePlayerBalloonInfoMap__.getKey(), scenePlayerBalloonInfoMap__.getValue());
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
            return BalloonInfoOuterClass.internal_static_BalloonInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BalloonInfoOuterClass.internal_static_BalloonInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BalloonInfo.class, Builder.class);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BalloonInfoOuterClass$BalloonInfo$ScenePlayerBalloonInfoMapDefaultEntryHolder.class */
        public static final class ScenePlayerBalloonInfoMapDefaultEntryHolder {
            static final MapEntry<Integer, BalloonPlayerInfoOuterClass.BalloonPlayerInfo> defaultEntry = MapEntry.newDefaultInstance(BalloonInfoOuterClass.f656x790f02b7, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, BalloonPlayerInfoOuterClass.BalloonPlayerInfo.getDefaultInstance());

            private ScenePlayerBalloonInfoMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, BalloonPlayerInfoOuterClass.BalloonPlayerInfo> internalGetScenePlayerBalloonInfoMap() {
            if (this.scenePlayerBalloonInfoMap_ == null) {
                return MapField.emptyMapField(ScenePlayerBalloonInfoMapDefaultEntryHolder.defaultEntry);
            }
            return this.scenePlayerBalloonInfoMap_;
        }

        @Override // emu.grasscutter.net.proto.BalloonInfoOuterClass.BalloonInfoOrBuilder
        public int getScenePlayerBalloonInfoMapCount() {
            return internalGetScenePlayerBalloonInfoMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.BalloonInfoOuterClass.BalloonInfoOrBuilder
        public boolean containsScenePlayerBalloonInfoMap(int key) {
            return internalGetScenePlayerBalloonInfoMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.BalloonInfoOuterClass.BalloonInfoOrBuilder
        @Deprecated
        public Map<Integer, BalloonPlayerInfoOuterClass.BalloonPlayerInfo> getScenePlayerBalloonInfoMap() {
            return getScenePlayerBalloonInfoMapMap();
        }

        @Override // emu.grasscutter.net.proto.BalloonInfoOuterClass.BalloonInfoOrBuilder
        public Map<Integer, BalloonPlayerInfoOuterClass.BalloonPlayerInfo> getScenePlayerBalloonInfoMapMap() {
            return internalGetScenePlayerBalloonInfoMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.BalloonInfoOuterClass.BalloonInfoOrBuilder
        public BalloonPlayerInfoOuterClass.BalloonPlayerInfo getScenePlayerBalloonInfoMapOrDefault(int key, BalloonPlayerInfoOuterClass.BalloonPlayerInfo defaultValue) {
            Map<Integer, BalloonPlayerInfoOuterClass.BalloonPlayerInfo> map = internalGetScenePlayerBalloonInfoMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.BalloonInfoOuterClass.BalloonInfoOrBuilder
        public BalloonPlayerInfoOuterClass.BalloonPlayerInfo getScenePlayerBalloonInfoMapOrThrow(int key) {
            Map<Integer, BalloonPlayerInfoOuterClass.BalloonPlayerInfo> map = internalGetScenePlayerBalloonInfoMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.BalloonInfoOuterClass.BalloonInfoOrBuilder
        public int getEndTime() {
            return this.endTime_;
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
            if (this.endTime_ != 0) {
                output.writeUInt32(7, this.endTime_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetScenePlayerBalloonInfoMap(), ScenePlayerBalloonInfoMapDefaultEntryHolder.defaultEntry, 13);
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.endTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(7, this.endTime_);
            }
            for (Map.Entry<Integer, BalloonPlayerInfoOuterClass.BalloonPlayerInfo> entry : internalGetScenePlayerBalloonInfoMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(13, ScenePlayerBalloonInfoMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
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
            if (!(obj instanceof BalloonInfo)) {
                return equals(obj);
            }
            BalloonInfo other = (BalloonInfo) obj;
            return internalGetScenePlayerBalloonInfoMap().equals(other.internalGetScenePlayerBalloonInfoMap()) && getEndTime() == other.getEndTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (!internalGetScenePlayerBalloonInfoMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 13)) + internalGetScenePlayerBalloonInfoMap().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 7)) + getEndTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static BalloonInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BalloonInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BalloonInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BalloonInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BalloonInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BalloonInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BalloonInfo parseFrom(InputStream input) throws IOException {
            return (BalloonInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BalloonInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BalloonInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BalloonInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BalloonInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BalloonInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BalloonInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BalloonInfo parseFrom(CodedInputStream input) throws IOException {
            return (BalloonInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BalloonInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BalloonInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BalloonInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BalloonInfoOuterClass$BalloonInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BalloonInfoOrBuilder {
            private int bitField0_;
            private MapField<Integer, BalloonPlayerInfoOuterClass.BalloonPlayerInfo> scenePlayerBalloonInfoMap_;
            private int endTime_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.BalloonInfoOuterClass.BalloonInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 13: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetScenePlayerBalloonInfoMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.BalloonInfoOuterClass.BalloonInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.BalloonInfoOuterClass.BalloonInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 13: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableScenePlayerBalloonInfoMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.BalloonInfoOuterClass.BalloonInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return BalloonInfoOuterClass.internal_static_BalloonInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BalloonInfoOuterClass.internal_static_BalloonInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BalloonInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BalloonInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                internalGetMutableScenePlayerBalloonInfoMap().clear();
                this.endTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BalloonInfoOuterClass.internal_static_BalloonInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BalloonInfo getDefaultInstanceForType() {
                return BalloonInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BalloonInfo build() {
                BalloonInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BalloonInfo buildPartial() {
                BalloonInfo result = new BalloonInfo(this);
                int i = this.bitField0_;
                result.scenePlayerBalloonInfoMap_ = internalGetScenePlayerBalloonInfoMap();
                result.scenePlayerBalloonInfoMap_.makeImmutable();
                result.endTime_ = this.endTime_;
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
                if (other instanceof BalloonInfo) {
                    return mergeFrom((BalloonInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BalloonInfo other) {
                if (other == BalloonInfo.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableScenePlayerBalloonInfoMap().mergeFrom(other.internalGetScenePlayerBalloonInfoMap());
                if (other.getEndTime() != 0) {
                    setEndTime(other.getEndTime());
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
                BalloonInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BalloonInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BalloonInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private MapField<Integer, BalloonPlayerInfoOuterClass.BalloonPlayerInfo> internalGetScenePlayerBalloonInfoMap() {
                if (this.scenePlayerBalloonInfoMap_ == null) {
                    return MapField.emptyMapField(ScenePlayerBalloonInfoMapDefaultEntryHolder.defaultEntry);
                }
                return this.scenePlayerBalloonInfoMap_;
            }

            private MapField<Integer, BalloonPlayerInfoOuterClass.BalloonPlayerInfo> internalGetMutableScenePlayerBalloonInfoMap() {
                onChanged();
                if (this.scenePlayerBalloonInfoMap_ == null) {
                    this.scenePlayerBalloonInfoMap_ = MapField.newMapField(ScenePlayerBalloonInfoMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.scenePlayerBalloonInfoMap_.isMutable()) {
                    this.scenePlayerBalloonInfoMap_ = this.scenePlayerBalloonInfoMap_.copy();
                }
                return this.scenePlayerBalloonInfoMap_;
            }

            @Override // emu.grasscutter.net.proto.BalloonInfoOuterClass.BalloonInfoOrBuilder
            public int getScenePlayerBalloonInfoMapCount() {
                return internalGetScenePlayerBalloonInfoMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.BalloonInfoOuterClass.BalloonInfoOrBuilder
            public boolean containsScenePlayerBalloonInfoMap(int key) {
                return internalGetScenePlayerBalloonInfoMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.BalloonInfoOuterClass.BalloonInfoOrBuilder
            @Deprecated
            public Map<Integer, BalloonPlayerInfoOuterClass.BalloonPlayerInfo> getScenePlayerBalloonInfoMap() {
                return getScenePlayerBalloonInfoMapMap();
            }

            @Override // emu.grasscutter.net.proto.BalloonInfoOuterClass.BalloonInfoOrBuilder
            public Map<Integer, BalloonPlayerInfoOuterClass.BalloonPlayerInfo> getScenePlayerBalloonInfoMapMap() {
                return internalGetScenePlayerBalloonInfoMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.BalloonInfoOuterClass.BalloonInfoOrBuilder
            public BalloonPlayerInfoOuterClass.BalloonPlayerInfo getScenePlayerBalloonInfoMapOrDefault(int key, BalloonPlayerInfoOuterClass.BalloonPlayerInfo defaultValue) {
                Map<Integer, BalloonPlayerInfoOuterClass.BalloonPlayerInfo> map = internalGetScenePlayerBalloonInfoMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.BalloonInfoOuterClass.BalloonInfoOrBuilder
            public BalloonPlayerInfoOuterClass.BalloonPlayerInfo getScenePlayerBalloonInfoMapOrThrow(int key) {
                Map<Integer, BalloonPlayerInfoOuterClass.BalloonPlayerInfo> map = internalGetScenePlayerBalloonInfoMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearScenePlayerBalloonInfoMap() {
                internalGetMutableScenePlayerBalloonInfoMap().getMutableMap().clear();
                return this;
            }

            public Builder removeScenePlayerBalloonInfoMap(int key) {
                internalGetMutableScenePlayerBalloonInfoMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, BalloonPlayerInfoOuterClass.BalloonPlayerInfo> getMutableScenePlayerBalloonInfoMap() {
                return internalGetMutableScenePlayerBalloonInfoMap().getMutableMap();
            }

            public Builder putScenePlayerBalloonInfoMap(int key, BalloonPlayerInfoOuterClass.BalloonPlayerInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableScenePlayerBalloonInfoMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllScenePlayerBalloonInfoMap(Map<Integer, BalloonPlayerInfoOuterClass.BalloonPlayerInfo> values) {
                internalGetMutableScenePlayerBalloonInfoMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.BalloonInfoOuterClass.BalloonInfoOrBuilder
            public int getEndTime() {
                return this.endTime_;
            }

            public Builder setEndTime(int value) {
                this.endTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearEndTime() {
                this.endTime_ = 0;
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

        public static BalloonInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BalloonInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BalloonInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BalloonInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BalloonPlayerInfoOuterClass.getDescriptor();
    }
}
