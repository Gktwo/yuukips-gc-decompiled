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
import emu.grasscutter.net.proto.FallPlayerInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FallInfoOuterClass.class */
public final class FallInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000eFallInfo.proto\u001a\u0014FallPlayerInfo.proto\"²\u0001\n\bFallInfo\u0012\u000f\n\u0007endTime\u0018\u0006 \u0001(\r\u0012E\n\u0016scenePlayerFallInfoMap\u0018\t \u0003(\u000b2%.FallInfo.ScenePlayerFallInfoMapEntry\u001aN\n\u001bScenePlayerFallInfoMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\u001e\n\u0005value\u0018\u0002 \u0001(\u000b2\u000f.FallPlayerInfo:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FallPlayerInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FallInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FallInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FallInfo_descriptor, new String[]{"EndTime", "ScenePlayerFallInfoMap"});
    private static final Descriptors.Descriptor internal_static_FallInfo_ScenePlayerFallInfoMapEntry_descriptor = internal_static_FallInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_FallInfo_ScenePlayerFallInfoMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f704x48739627 = new GeneratedMessageV3.FieldAccessorTable(internal_static_FallInfo_ScenePlayerFallInfoMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FallInfoOuterClass$FallInfoOrBuilder.class */
    public interface FallInfoOrBuilder extends MessageOrBuilder {
        int getEndTime();

        int getScenePlayerFallInfoMapCount();

        boolean containsScenePlayerFallInfoMap(int i);

        @Deprecated
        Map<Integer, FallPlayerInfoOuterClass.FallPlayerInfo> getScenePlayerFallInfoMap();

        Map<Integer, FallPlayerInfoOuterClass.FallPlayerInfo> getScenePlayerFallInfoMapMap();

        FallPlayerInfoOuterClass.FallPlayerInfo getScenePlayerFallInfoMapOrDefault(int i, FallPlayerInfoOuterClass.FallPlayerInfo fallPlayerInfo);

        FallPlayerInfoOuterClass.FallPlayerInfo getScenePlayerFallInfoMapOrThrow(int i);
    }

    private FallInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FallInfoOuterClass$FallInfo.class */
    public static final class FallInfo extends GeneratedMessageV3 implements FallInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENDTIME_FIELD_NUMBER = 6;
        private int endTime_;
        public static final int SCENEPLAYERFALLINFOMAP_FIELD_NUMBER = 9;
        private MapField<Integer, FallPlayerInfoOuterClass.FallPlayerInfo> scenePlayerFallInfoMap_;
        private byte memoizedIsInitialized;
        private static final FallInfo DEFAULT_INSTANCE = new FallInfo();
        private static final Parser<FallInfo> PARSER = new AbstractParser<FallInfo>() { // from class: emu.grasscutter.net.proto.FallInfoOuterClass.FallInfo.1
            @Override // com.google.protobuf.Parser
            public FallInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FallInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.FallInfoOuterClass.FallInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 9: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetScenePlayerFallInfoMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.FallInfoOuterClass.FallInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private FallInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FallInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FallInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FallInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 48:
                                this.endTime_ = input.readUInt32();
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.scenePlayerFallInfoMap_ = MapField.newMapField(ScenePlayerFallInfoMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, FallPlayerInfoOuterClass.FallPlayerInfo> scenePlayerFallInfoMap__ = (MapEntry) input.readMessage(ScenePlayerFallInfoMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.scenePlayerFallInfoMap_.getMutableMap().put(scenePlayerFallInfoMap__.getKey(), scenePlayerFallInfoMap__.getValue());
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
            return FallInfoOuterClass.internal_static_FallInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FallInfoOuterClass.internal_static_FallInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FallInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FallInfoOuterClass.FallInfoOrBuilder
        public int getEndTime() {
            return this.endTime_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FallInfoOuterClass$FallInfo$ScenePlayerFallInfoMapDefaultEntryHolder.class */
        public static final class ScenePlayerFallInfoMapDefaultEntryHolder {
            static final MapEntry<Integer, FallPlayerInfoOuterClass.FallPlayerInfo> defaultEntry = MapEntry.newDefaultInstance(FallInfoOuterClass.internal_static_FallInfo_ScenePlayerFallInfoMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, FallPlayerInfoOuterClass.FallPlayerInfo.getDefaultInstance());

            private ScenePlayerFallInfoMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, FallPlayerInfoOuterClass.FallPlayerInfo> internalGetScenePlayerFallInfoMap() {
            if (this.scenePlayerFallInfoMap_ == null) {
                return MapField.emptyMapField(ScenePlayerFallInfoMapDefaultEntryHolder.defaultEntry);
            }
            return this.scenePlayerFallInfoMap_;
        }

        @Override // emu.grasscutter.net.proto.FallInfoOuterClass.FallInfoOrBuilder
        public int getScenePlayerFallInfoMapCount() {
            return internalGetScenePlayerFallInfoMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.FallInfoOuterClass.FallInfoOrBuilder
        public boolean containsScenePlayerFallInfoMap(int key) {
            return internalGetScenePlayerFallInfoMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.FallInfoOuterClass.FallInfoOrBuilder
        @Deprecated
        public Map<Integer, FallPlayerInfoOuterClass.FallPlayerInfo> getScenePlayerFallInfoMap() {
            return getScenePlayerFallInfoMapMap();
        }

        @Override // emu.grasscutter.net.proto.FallInfoOuterClass.FallInfoOrBuilder
        public Map<Integer, FallPlayerInfoOuterClass.FallPlayerInfo> getScenePlayerFallInfoMapMap() {
            return internalGetScenePlayerFallInfoMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.FallInfoOuterClass.FallInfoOrBuilder
        public FallPlayerInfoOuterClass.FallPlayerInfo getScenePlayerFallInfoMapOrDefault(int key, FallPlayerInfoOuterClass.FallPlayerInfo defaultValue) {
            Map<Integer, FallPlayerInfoOuterClass.FallPlayerInfo> map = internalGetScenePlayerFallInfoMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.FallInfoOuterClass.FallInfoOrBuilder
        public FallPlayerInfoOuterClass.FallPlayerInfo getScenePlayerFallInfoMapOrThrow(int key) {
            Map<Integer, FallPlayerInfoOuterClass.FallPlayerInfo> map = internalGetScenePlayerFallInfoMap().getMap();
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
            if (this.endTime_ != 0) {
                output.writeUInt32(6, this.endTime_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetScenePlayerFallInfoMap(), ScenePlayerFallInfoMapDefaultEntryHolder.defaultEntry, 9);
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(6, this.endTime_);
            }
            for (Map.Entry<Integer, FallPlayerInfoOuterClass.FallPlayerInfo> entry : internalGetScenePlayerFallInfoMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(9, ScenePlayerFallInfoMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
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
            if (!(obj instanceof FallInfo)) {
                return equals(obj);
            }
            FallInfo other = (FallInfo) obj;
            return getEndTime() == other.getEndTime() && internalGetScenePlayerFallInfoMap().equals(other.internalGetScenePlayerFallInfoMap()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getEndTime();
            if (!internalGetScenePlayerFallInfoMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 9)) + internalGetScenePlayerFallInfoMap().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FallInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FallInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FallInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FallInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FallInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FallInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FallInfo parseFrom(InputStream input) throws IOException {
            return (FallInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FallInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FallInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FallInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (FallInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FallInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FallInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FallInfo parseFrom(CodedInputStream input) throws IOException {
            return (FallInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FallInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FallInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FallInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FallInfoOuterClass$FallInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FallInfoOrBuilder {
            private int bitField0_;
            private int endTime_;
            private MapField<Integer, FallPlayerInfoOuterClass.FallPlayerInfo> scenePlayerFallInfoMap_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.FallInfoOuterClass.FallInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 9: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetScenePlayerFallInfoMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.FallInfoOuterClass.FallInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.FallInfoOuterClass.FallInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 9: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableScenePlayerFallInfoMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.FallInfoOuterClass.FallInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return FallInfoOuterClass.internal_static_FallInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FallInfoOuterClass.internal_static_FallInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FallInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FallInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.endTime_ = 0;
                internalGetMutableScenePlayerFallInfoMap().clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FallInfoOuterClass.internal_static_FallInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FallInfo getDefaultInstanceForType() {
                return FallInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FallInfo build() {
                FallInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FallInfo buildPartial() {
                FallInfo result = new FallInfo(this);
                int i = this.bitField0_;
                result.endTime_ = this.endTime_;
                result.scenePlayerFallInfoMap_ = internalGetScenePlayerFallInfoMap();
                result.scenePlayerFallInfoMap_.makeImmutable();
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
                if (other instanceof FallInfo) {
                    return mergeFrom((FallInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FallInfo other) {
                if (other == FallInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getEndTime() != 0) {
                    setEndTime(other.getEndTime());
                }
                internalGetMutableScenePlayerFallInfoMap().mergeFrom(other.internalGetScenePlayerFallInfoMap());
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
                FallInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = FallInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FallInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FallInfoOuterClass.FallInfoOrBuilder
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

            private MapField<Integer, FallPlayerInfoOuterClass.FallPlayerInfo> internalGetScenePlayerFallInfoMap() {
                if (this.scenePlayerFallInfoMap_ == null) {
                    return MapField.emptyMapField(ScenePlayerFallInfoMapDefaultEntryHolder.defaultEntry);
                }
                return this.scenePlayerFallInfoMap_;
            }

            private MapField<Integer, FallPlayerInfoOuterClass.FallPlayerInfo> internalGetMutableScenePlayerFallInfoMap() {
                onChanged();
                if (this.scenePlayerFallInfoMap_ == null) {
                    this.scenePlayerFallInfoMap_ = MapField.newMapField(ScenePlayerFallInfoMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.scenePlayerFallInfoMap_.isMutable()) {
                    this.scenePlayerFallInfoMap_ = this.scenePlayerFallInfoMap_.copy();
                }
                return this.scenePlayerFallInfoMap_;
            }

            @Override // emu.grasscutter.net.proto.FallInfoOuterClass.FallInfoOrBuilder
            public int getScenePlayerFallInfoMapCount() {
                return internalGetScenePlayerFallInfoMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.FallInfoOuterClass.FallInfoOrBuilder
            public boolean containsScenePlayerFallInfoMap(int key) {
                return internalGetScenePlayerFallInfoMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.FallInfoOuterClass.FallInfoOrBuilder
            @Deprecated
            public Map<Integer, FallPlayerInfoOuterClass.FallPlayerInfo> getScenePlayerFallInfoMap() {
                return getScenePlayerFallInfoMapMap();
            }

            @Override // emu.grasscutter.net.proto.FallInfoOuterClass.FallInfoOrBuilder
            public Map<Integer, FallPlayerInfoOuterClass.FallPlayerInfo> getScenePlayerFallInfoMapMap() {
                return internalGetScenePlayerFallInfoMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.FallInfoOuterClass.FallInfoOrBuilder
            public FallPlayerInfoOuterClass.FallPlayerInfo getScenePlayerFallInfoMapOrDefault(int key, FallPlayerInfoOuterClass.FallPlayerInfo defaultValue) {
                Map<Integer, FallPlayerInfoOuterClass.FallPlayerInfo> map = internalGetScenePlayerFallInfoMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.FallInfoOuterClass.FallInfoOrBuilder
            public FallPlayerInfoOuterClass.FallPlayerInfo getScenePlayerFallInfoMapOrThrow(int key) {
                Map<Integer, FallPlayerInfoOuterClass.FallPlayerInfo> map = internalGetScenePlayerFallInfoMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearScenePlayerFallInfoMap() {
                internalGetMutableScenePlayerFallInfoMap().getMutableMap().clear();
                return this;
            }

            public Builder removeScenePlayerFallInfoMap(int key) {
                internalGetMutableScenePlayerFallInfoMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, FallPlayerInfoOuterClass.FallPlayerInfo> getMutableScenePlayerFallInfoMap() {
                return internalGetMutableScenePlayerFallInfoMap().getMutableMap();
            }

            public Builder putScenePlayerFallInfoMap(int key, FallPlayerInfoOuterClass.FallPlayerInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableScenePlayerFallInfoMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllScenePlayerFallInfoMap(Map<Integer, FallPlayerInfoOuterClass.FallPlayerInfo> values) {
                internalGetMutableScenePlayerFallInfoMap().getMutableMap().putAll(values);
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

        public static FallInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FallInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FallInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FallInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FallPlayerInfoOuterClass.getDescriptor();
    }
}
