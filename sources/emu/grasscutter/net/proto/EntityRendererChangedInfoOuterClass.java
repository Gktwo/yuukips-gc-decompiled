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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityRendererChangedInfoOuterClass.class */
public final class EntityRendererChangedInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fEntityRendererChangedInfo.proto\"Î\u0001\n\u0019EntityRendererChangedInfo\u0012K\n\u0011changed_renderers\u0018\u0001 \u0003(\u000b20.EntityRendererChangedInfo.ChangedRenderersEntry\u0012\u0018\n\u0010visibility_count\u0018\u0002 \u0001(\r\u0012\u0011\n\tis_cached\u0018\u0003 \u0001(\b\u001a7\n\u0015ChangedRenderersEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_EntityRendererChangedInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EntityRendererChangedInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EntityRendererChangedInfo_descriptor, new String[]{"ChangedRenderers", "VisibilityCount", "IsCached"});

    /* renamed from: internal_static_EntityRendererChangedInfo_ChangedRenderersEntry_descriptor */
    private static final Descriptors.Descriptor f699x35ddfcea = internal_static_EntityRendererChangedInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_EntityRendererChangedInfo_ChangedRenderersEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f700x101e9968 = new GeneratedMessageV3.FieldAccessorTable(f699x35ddfcea, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityRendererChangedInfoOuterClass$EntityRendererChangedInfoOrBuilder.class */
    public interface EntityRendererChangedInfoOrBuilder extends MessageOrBuilder {
        int getChangedRenderersCount();

        boolean containsChangedRenderers(String str);

        @Deprecated
        Map<String, Integer> getChangedRenderers();

        Map<String, Integer> getChangedRenderersMap();

        int getChangedRenderersOrDefault(String str, int i);

        int getChangedRenderersOrThrow(String str);

        int getVisibilityCount();

        boolean getIsCached();
    }

    private EntityRendererChangedInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityRendererChangedInfoOuterClass$EntityRendererChangedInfo.class */
    public static final class EntityRendererChangedInfo extends GeneratedMessageV3 implements EntityRendererChangedInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CHANGED_RENDERERS_FIELD_NUMBER = 1;
        private MapField<String, Integer> changedRenderers_;
        public static final int VISIBILITY_COUNT_FIELD_NUMBER = 2;
        private int visibilityCount_;
        public static final int IS_CACHED_FIELD_NUMBER = 3;
        private boolean isCached_;
        private byte memoizedIsInitialized;
        private static final EntityRendererChangedInfo DEFAULT_INSTANCE = new EntityRendererChangedInfo();
        private static final Parser<EntityRendererChangedInfo> PARSER = new AbstractParser<EntityRendererChangedInfo>() { // from class: emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.1
            @Override // com.google.protobuf.Parser
            public EntityRendererChangedInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EntityRendererChangedInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 1: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetChangedRenderers()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private EntityRendererChangedInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EntityRendererChangedInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EntityRendererChangedInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EntityRendererChangedInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 10:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.changedRenderers_ = MapField.newMapField(ChangedRenderersDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<String, Integer> changedRenderers__ = (MapEntry) input.readMessage(ChangedRenderersDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.changedRenderers_.getMutableMap().put(changedRenderers__.getKey(), changedRenderers__.getValue());
                                break;
                            case 16:
                                this.visibilityCount_ = input.readUInt32();
                                break;
                            case 24:
                                this.isCached_ = input.readBool();
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
            return EntityRendererChangedInfoOuterClass.internal_static_EntityRendererChangedInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EntityRendererChangedInfoOuterClass.internal_static_EntityRendererChangedInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EntityRendererChangedInfo.class, Builder.class);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityRendererChangedInfoOuterClass$EntityRendererChangedInfo$ChangedRenderersDefaultEntryHolder.class */
        public static final class ChangedRenderersDefaultEntryHolder {
            static final MapEntry<String, Integer> defaultEntry = MapEntry.newDefaultInstance(EntityRendererChangedInfoOuterClass.f699x35ddfcea, WireFormat.FieldType.STRING, "", WireFormat.FieldType.UINT32, 0);

            private ChangedRenderersDefaultEntryHolder() {
            }
        }

        private MapField<String, Integer> internalGetChangedRenderers() {
            if (this.changedRenderers_ == null) {
                return MapField.emptyMapField(ChangedRenderersDefaultEntryHolder.defaultEntry);
            }
            return this.changedRenderers_;
        }

        @Override // emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder
        public int getChangedRenderersCount() {
            return internalGetChangedRenderers().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder
        public boolean containsChangedRenderers(String key) {
            if (key != null) {
                return internalGetChangedRenderers().getMap().containsKey(key);
            }
            throw new NullPointerException();
        }

        @Override // emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder
        @Deprecated
        public Map<String, Integer> getChangedRenderers() {
            return getChangedRenderersMap();
        }

        @Override // emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder
        public Map<String, Integer> getChangedRenderersMap() {
            return internalGetChangedRenderers().getMap();
        }

        @Override // emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder
        public int getChangedRenderersOrDefault(String key, int defaultValue) {
            if (key == null) {
                throw new NullPointerException();
            }
            Map<String, Integer> map = internalGetChangedRenderers().getMap();
            return map.containsKey(key) ? map.get(key).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder
        public int getChangedRenderersOrThrow(String key) {
            if (key == null) {
                throw new NullPointerException();
            }
            Map<String, Integer> map = internalGetChangedRenderers().getMap();
            if (map.containsKey(key)) {
                return map.get(key).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder
        public int getVisibilityCount() {
            return this.visibilityCount_;
        }

        @Override // emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder
        public boolean getIsCached() {
            return this.isCached_;
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
            GeneratedMessageV3.serializeStringMapTo(output, internalGetChangedRenderers(), ChangedRenderersDefaultEntryHolder.defaultEntry, 1);
            if (this.visibilityCount_ != 0) {
                output.writeUInt32(2, this.visibilityCount_);
            }
            if (this.isCached_) {
                output.writeBool(3, this.isCached_);
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
            for (Map.Entry<String, Integer> entry : internalGetChangedRenderers().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(1, ChangedRenderersDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.visibilityCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.visibilityCount_);
            }
            if (this.isCached_) {
                size2 += CodedOutputStream.computeBoolSize(3, this.isCached_);
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
            if (!(obj instanceof EntityRendererChangedInfo)) {
                return equals(obj);
            }
            EntityRendererChangedInfo other = (EntityRendererChangedInfo) obj;
            return internalGetChangedRenderers().equals(other.internalGetChangedRenderers()) && getVisibilityCount() == other.getVisibilityCount() && getIsCached() == other.getIsCached() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (!internalGetChangedRenderers().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 1)) + internalGetChangedRenderers().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 2)) + getVisibilityCount())) + 3)) + Internal.hashBoolean(getIsCached()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static EntityRendererChangedInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityRendererChangedInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityRendererChangedInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityRendererChangedInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityRendererChangedInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityRendererChangedInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityRendererChangedInfo parseFrom(InputStream input) throws IOException {
            return (EntityRendererChangedInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EntityRendererChangedInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityRendererChangedInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EntityRendererChangedInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (EntityRendererChangedInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EntityRendererChangedInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityRendererChangedInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EntityRendererChangedInfo parseFrom(CodedInputStream input) throws IOException {
            return (EntityRendererChangedInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EntityRendererChangedInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityRendererChangedInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EntityRendererChangedInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityRendererChangedInfoOuterClass$EntityRendererChangedInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EntityRendererChangedInfoOrBuilder {
            private int bitField0_;
            private MapField<String, Integer> changedRenderers_;
            private int visibilityCount_;
            private boolean isCached_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 1: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetChangedRenderers()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 1: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableChangedRenderers()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return EntityRendererChangedInfoOuterClass.internal_static_EntityRendererChangedInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EntityRendererChangedInfoOuterClass.internal_static_EntityRendererChangedInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EntityRendererChangedInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EntityRendererChangedInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                internalGetMutableChangedRenderers().clear();
                this.visibilityCount_ = 0;
                this.isCached_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EntityRendererChangedInfoOuterClass.internal_static_EntityRendererChangedInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EntityRendererChangedInfo getDefaultInstanceForType() {
                return EntityRendererChangedInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EntityRendererChangedInfo build() {
                EntityRendererChangedInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EntityRendererChangedInfo buildPartial() {
                EntityRendererChangedInfo result = new EntityRendererChangedInfo(this);
                int i = this.bitField0_;
                result.changedRenderers_ = internalGetChangedRenderers();
                result.changedRenderers_.makeImmutable();
                result.visibilityCount_ = this.visibilityCount_;
                result.isCached_ = this.isCached_;
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
                if (other instanceof EntityRendererChangedInfo) {
                    return mergeFrom((EntityRendererChangedInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EntityRendererChangedInfo other) {
                if (other == EntityRendererChangedInfo.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableChangedRenderers().mergeFrom(other.internalGetChangedRenderers());
                if (other.getVisibilityCount() != 0) {
                    setVisibilityCount(other.getVisibilityCount());
                }
                if (other.getIsCached()) {
                    setIsCached(other.getIsCached());
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
                EntityRendererChangedInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = EntityRendererChangedInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EntityRendererChangedInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private MapField<String, Integer> internalGetChangedRenderers() {
                if (this.changedRenderers_ == null) {
                    return MapField.emptyMapField(ChangedRenderersDefaultEntryHolder.defaultEntry);
                }
                return this.changedRenderers_;
            }

            private MapField<String, Integer> internalGetMutableChangedRenderers() {
                onChanged();
                if (this.changedRenderers_ == null) {
                    this.changedRenderers_ = MapField.newMapField(ChangedRenderersDefaultEntryHolder.defaultEntry);
                }
                if (!this.changedRenderers_.isMutable()) {
                    this.changedRenderers_ = this.changedRenderers_.copy();
                }
                return this.changedRenderers_;
            }

            @Override // emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder
            public int getChangedRenderersCount() {
                return internalGetChangedRenderers().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder
            public boolean containsChangedRenderers(String key) {
                if (key != null) {
                    return internalGetChangedRenderers().getMap().containsKey(key);
                }
                throw new NullPointerException();
            }

            @Override // emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder
            @Deprecated
            public Map<String, Integer> getChangedRenderers() {
                return getChangedRenderersMap();
            }

            @Override // emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder
            public Map<String, Integer> getChangedRenderersMap() {
                return internalGetChangedRenderers().getMap();
            }

            @Override // emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder
            public int getChangedRenderersOrDefault(String key, int defaultValue) {
                if (key == null) {
                    throw new NullPointerException();
                }
                Map<String, Integer> map = internalGetChangedRenderers().getMap();
                return map.containsKey(key) ? map.get(key).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder
            public int getChangedRenderersOrThrow(String key) {
                if (key == null) {
                    throw new NullPointerException();
                }
                Map<String, Integer> map = internalGetChangedRenderers().getMap();
                if (map.containsKey(key)) {
                    return map.get(key).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearChangedRenderers() {
                internalGetMutableChangedRenderers().getMutableMap().clear();
                return this;
            }

            public Builder removeChangedRenderers(String key) {
                if (key == null) {
                    throw new NullPointerException();
                }
                internalGetMutableChangedRenderers().getMutableMap().remove(key);
                return this;
            }

            @Deprecated
            public Map<String, Integer> getMutableChangedRenderers() {
                return internalGetMutableChangedRenderers().getMutableMap();
            }

            public Builder putChangedRenderers(String key, int value) {
                if (key == null) {
                    throw new NullPointerException();
                }
                internalGetMutableChangedRenderers().getMutableMap().put(key, Integer.valueOf(value));
                return this;
            }

            public Builder putAllChangedRenderers(Map<String, Integer> values) {
                internalGetMutableChangedRenderers().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder
            public int getVisibilityCount() {
                return this.visibilityCount_;
            }

            public Builder setVisibilityCount(int value) {
                this.visibilityCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearVisibilityCount() {
                this.visibilityCount_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder
            public boolean getIsCached() {
                return this.isCached_;
            }

            public Builder setIsCached(boolean value) {
                this.isCached_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsCached() {
                this.isCached_ = false;
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

        public static EntityRendererChangedInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EntityRendererChangedInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EntityRendererChangedInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EntityRendererChangedInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
