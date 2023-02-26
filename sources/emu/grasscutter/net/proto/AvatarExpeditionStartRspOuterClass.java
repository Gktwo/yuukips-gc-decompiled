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
import emu.grasscutter.net.proto.AvatarExpeditionInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionStartRspOuterClass.class */
public final class AvatarExpeditionStartRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eAvatarExpeditionStartRsp.proto\u001a\u001aAvatarExpeditionInfo.proto\"É\u0001\n\u0018AvatarExpeditionStartRsp\u0012K\n\u0011expeditionInfoMap\u0018\u0007 \u0003(\u000b20.AvatarExpeditionStartRsp.ExpeditionInfoMapEntry\u0012\u000f\n\u0007retcode\u0018\n \u0001(\u0005\u001aO\n\u0016ExpeditionInfoMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\u0004\u0012$\n\u0005value\u0018\u0002 \u0001(\u000b2\u0015.AvatarExpeditionInfo:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AvatarExpeditionInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AvatarExpeditionStartRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarExpeditionStartRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarExpeditionStartRsp_descriptor, new String[]{"ExpeditionInfoMap", "Retcode"});

    /* renamed from: internal_static_AvatarExpeditionStartRsp_ExpeditionInfoMapEntry_descriptor */
    private static final Descriptors.Descriptor f634xce48e20 = internal_static_AvatarExpeditionStartRsp_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_AvatarExpeditionStartRsp_ExpeditionInfoMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f635x8a73949e = new GeneratedMessageV3.FieldAccessorTable(f634xce48e20, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionStartRspOuterClass$AvatarExpeditionStartRspOrBuilder.class */
    public interface AvatarExpeditionStartRspOrBuilder extends MessageOrBuilder {
        int getExpeditionInfoMapCount();

        boolean containsExpeditionInfoMap(long j);

        @Deprecated
        Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMap();

        Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMapMap();

        AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo getExpeditionInfoMapOrDefault(long j, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo avatarExpeditionInfo);

        AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo getExpeditionInfoMapOrThrow(long j);

        int getRetcode();
    }

    private AvatarExpeditionStartRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionStartRspOuterClass$AvatarExpeditionStartRsp.class */
    public static final class AvatarExpeditionStartRsp extends GeneratedMessageV3 implements AvatarExpeditionStartRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int EXPEDITIONINFOMAP_FIELD_NUMBER = 7;
        private MapField<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> expeditionInfoMap_;
        public static final int RETCODE_FIELD_NUMBER = 10;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final AvatarExpeditionStartRsp DEFAULT_INSTANCE = new AvatarExpeditionStartRsp();
        private static final Parser<AvatarExpeditionStartRsp> PARSER = new AbstractParser<AvatarExpeditionStartRsp>() { // from class: emu.grasscutter.net.proto.AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRsp.1
            @Override // com.google.protobuf.Parser
            public AvatarExpeditionStartRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarExpeditionStartRsp(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRsp.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 7: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetExpeditionInfoMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRsp.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private AvatarExpeditionStartRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarExpeditionStartRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarExpeditionStartRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarExpeditionStartRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 58:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.expeditionInfoMap_ = MapField.newMapField(ExpeditionInfoMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> expeditionInfoMap__ = (MapEntry) input.readMessage(ExpeditionInfoMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.expeditionInfoMap_.getMutableMap().put(expeditionInfoMap__.getKey(), expeditionInfoMap__.getValue());
                                break;
                            case 80:
                                this.retcode_ = input.readInt32();
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
            return AvatarExpeditionStartRspOuterClass.internal_static_AvatarExpeditionStartRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarExpeditionStartRspOuterClass.internal_static_AvatarExpeditionStartRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarExpeditionStartRsp.class, Builder.class);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionStartRspOuterClass$AvatarExpeditionStartRsp$ExpeditionInfoMapDefaultEntryHolder.class */
        public static final class ExpeditionInfoMapDefaultEntryHolder {
            static final MapEntry<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> defaultEntry = MapEntry.newDefaultInstance(AvatarExpeditionStartRspOuterClass.f634xce48e20, WireFormat.FieldType.UINT64, 0L, WireFormat.FieldType.MESSAGE, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo.getDefaultInstance());

            private ExpeditionInfoMapDefaultEntryHolder() {
            }
        }

        private MapField<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> internalGetExpeditionInfoMap() {
            if (this.expeditionInfoMap_ == null) {
                return MapField.emptyMapField(ExpeditionInfoMapDefaultEntryHolder.defaultEntry);
            }
            return this.expeditionInfoMap_;
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRspOrBuilder
        public int getExpeditionInfoMapCount() {
            return internalGetExpeditionInfoMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRspOrBuilder
        public boolean containsExpeditionInfoMap(long key) {
            return internalGetExpeditionInfoMap().getMap().containsKey(Long.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRspOrBuilder
        @Deprecated
        public Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMap() {
            return getExpeditionInfoMapMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRspOrBuilder
        public Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMapMap() {
            return internalGetExpeditionInfoMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRspOrBuilder
        public AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo getExpeditionInfoMapOrDefault(long key, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo defaultValue) {
            Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> map = internalGetExpeditionInfoMap().getMap();
            return map.containsKey(Long.valueOf(key)) ? map.get(Long.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRspOrBuilder
        public AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo getExpeditionInfoMapOrThrow(long key) {
            Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> map = internalGetExpeditionInfoMap().getMap();
            if (map.containsKey(Long.valueOf(key))) {
                return map.get(Long.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
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
            GeneratedMessageV3.serializeLongMapTo(output, internalGetExpeditionInfoMap(), ExpeditionInfoMapDefaultEntryHolder.defaultEntry, 7);
            if (this.retcode_ != 0) {
                output.writeInt32(10, this.retcode_);
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
            for (Map.Entry<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> entry : internalGetExpeditionInfoMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(7, ExpeditionInfoMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(10, this.retcode_);
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
            if (!(obj instanceof AvatarExpeditionStartRsp)) {
                return equals(obj);
            }
            AvatarExpeditionStartRsp other = (AvatarExpeditionStartRsp) obj;
            return internalGetExpeditionInfoMap().equals(other.internalGetExpeditionInfoMap()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (!internalGetExpeditionInfoMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 7)) + internalGetExpeditionInfoMap().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 10)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AvatarExpeditionStartRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarExpeditionStartRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarExpeditionStartRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarExpeditionStartRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarExpeditionStartRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarExpeditionStartRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarExpeditionStartRsp parseFrom(InputStream input) throws IOException {
            return (AvatarExpeditionStartRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarExpeditionStartRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarExpeditionStartRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarExpeditionStartRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarExpeditionStartRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarExpeditionStartRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarExpeditionStartRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarExpeditionStartRsp parseFrom(CodedInputStream input) throws IOException {
            return (AvatarExpeditionStartRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarExpeditionStartRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarExpeditionStartRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarExpeditionStartRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionStartRspOuterClass$AvatarExpeditionStartRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarExpeditionStartRspOrBuilder {
            private int bitField0_;
            private MapField<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> expeditionInfoMap_;
            private int retcode_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRsp.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetExpeditionInfoMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRsp.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRsp.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetMutableExpeditionInfoMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRsp.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarExpeditionStartRspOuterClass.internal_static_AvatarExpeditionStartRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarExpeditionStartRspOuterClass.internal_static_AvatarExpeditionStartRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarExpeditionStartRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarExpeditionStartRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                internalGetMutableExpeditionInfoMap().clear();
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarExpeditionStartRspOuterClass.internal_static_AvatarExpeditionStartRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarExpeditionStartRsp getDefaultInstanceForType() {
                return AvatarExpeditionStartRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarExpeditionStartRsp build() {
                AvatarExpeditionStartRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarExpeditionStartRsp buildPartial() {
                AvatarExpeditionStartRsp result = new AvatarExpeditionStartRsp(this);
                int i = this.bitField0_;
                result.expeditionInfoMap_ = internalGetExpeditionInfoMap();
                result.expeditionInfoMap_.makeImmutable();
                result.retcode_ = this.retcode_;
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
                if (other instanceof AvatarExpeditionStartRsp) {
                    return mergeFrom((AvatarExpeditionStartRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarExpeditionStartRsp other) {
                if (other == AvatarExpeditionStartRsp.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableExpeditionInfoMap().mergeFrom(other.internalGetExpeditionInfoMap());
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                AvatarExpeditionStartRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarExpeditionStartRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarExpeditionStartRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private MapField<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> internalGetExpeditionInfoMap() {
                if (this.expeditionInfoMap_ == null) {
                    return MapField.emptyMapField(ExpeditionInfoMapDefaultEntryHolder.defaultEntry);
                }
                return this.expeditionInfoMap_;
            }

            private MapField<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> internalGetMutableExpeditionInfoMap() {
                onChanged();
                if (this.expeditionInfoMap_ == null) {
                    this.expeditionInfoMap_ = MapField.newMapField(ExpeditionInfoMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.expeditionInfoMap_.isMutable()) {
                    this.expeditionInfoMap_ = this.expeditionInfoMap_.copy();
                }
                return this.expeditionInfoMap_;
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRspOrBuilder
            public int getExpeditionInfoMapCount() {
                return internalGetExpeditionInfoMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRspOrBuilder
            public boolean containsExpeditionInfoMap(long key) {
                return internalGetExpeditionInfoMap().getMap().containsKey(Long.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRspOrBuilder
            @Deprecated
            public Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMap() {
                return getExpeditionInfoMapMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRspOrBuilder
            public Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMapMap() {
                return internalGetExpeditionInfoMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRspOrBuilder
            public AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo getExpeditionInfoMapOrDefault(long key, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo defaultValue) {
                Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> map = internalGetExpeditionInfoMap().getMap();
                return map.containsKey(Long.valueOf(key)) ? map.get(Long.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRspOrBuilder
            public AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo getExpeditionInfoMapOrThrow(long key) {
                Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> map = internalGetExpeditionInfoMap().getMap();
                if (map.containsKey(Long.valueOf(key))) {
                    return map.get(Long.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearExpeditionInfoMap() {
                internalGetMutableExpeditionInfoMap().getMutableMap().clear();
                return this;
            }

            public Builder removeExpeditionInfoMap(long key) {
                internalGetMutableExpeditionInfoMap().getMutableMap().remove(Long.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getMutableExpeditionInfoMap() {
                return internalGetMutableExpeditionInfoMap().getMutableMap();
            }

            public Builder putExpeditionInfoMap(long key, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableExpeditionInfoMap().getMutableMap().put(Long.valueOf(key), value);
                return this;
            }

            public Builder putAllExpeditionInfoMap(Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> values) {
                internalGetMutableExpeditionInfoMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionStartRspOuterClass.AvatarExpeditionStartRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
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

        public static AvatarExpeditionStartRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarExpeditionStartRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarExpeditionStartRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarExpeditionStartRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AvatarExpeditionInfoOuterClass.getDescriptor();
    }
}
