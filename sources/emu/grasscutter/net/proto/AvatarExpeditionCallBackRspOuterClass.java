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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionCallBackRspOuterClass.class */
public final class AvatarExpeditionCallBackRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!AvatarExpeditionCallBackRsp.proto\u001a\u001aAvatarExpeditionInfo.proto\"Ï\u0001\n\u001bAvatarExpeditionCallBackRsp\u0012\u000f\n\u0007retcode\u0018\u000e \u0001(\u0005\u0012N\n\u0011expeditionInfoMap\u0018\u0007 \u0003(\u000b23.AvatarExpeditionCallBackRsp.ExpeditionInfoMapEntry\u001aO\n\u0016ExpeditionInfoMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\u0004\u0012$\n\u0005value\u0018\u0002 \u0001(\u000b2\u0015.AvatarExpeditionInfo:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AvatarExpeditionInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AvatarExpeditionCallBackRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarExpeditionCallBackRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarExpeditionCallBackRsp_descriptor, new String[]{"Retcode", "ExpeditionInfoMap"});

    /* renamed from: internal_static_AvatarExpeditionCallBackRsp_ExpeditionInfoMapEntry_descriptor */
    private static final Descriptors.Descriptor f628x4eadfa8b = internal_static_AvatarExpeditionCallBackRsp_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_AvatarExpeditionCallBackRsp_ExpeditionInfoMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f629xcaab6609 = new GeneratedMessageV3.FieldAccessorTable(f628x4eadfa8b, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionCallBackRspOuterClass$AvatarExpeditionCallBackRspOrBuilder.class */
    public interface AvatarExpeditionCallBackRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        int getExpeditionInfoMapCount();

        boolean containsExpeditionInfoMap(long j);

        @Deprecated
        Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMap();

        Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMapMap();

        AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo getExpeditionInfoMapOrDefault(long j, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo avatarExpeditionInfo);

        AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo getExpeditionInfoMapOrThrow(long j);
    }

    private AvatarExpeditionCallBackRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionCallBackRspOuterClass$AvatarExpeditionCallBackRsp.class */
    public static final class AvatarExpeditionCallBackRsp extends GeneratedMessageV3 implements AvatarExpeditionCallBackRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 14;
        private int retcode_;
        public static final int EXPEDITIONINFOMAP_FIELD_NUMBER = 7;
        private MapField<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> expeditionInfoMap_;
        private byte memoizedIsInitialized;
        private static final AvatarExpeditionCallBackRsp DEFAULT_INSTANCE = new AvatarExpeditionCallBackRsp();
        private static final Parser<AvatarExpeditionCallBackRsp> PARSER = new AbstractParser<AvatarExpeditionCallBackRsp>() { // from class: emu.grasscutter.net.proto.AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRsp.1
            @Override // com.google.protobuf.Parser
            public AvatarExpeditionCallBackRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarExpeditionCallBackRsp(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRsp.internalGetMapField(int):com.google.protobuf.MapField
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
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRsp.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private AvatarExpeditionCallBackRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarExpeditionCallBackRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarExpeditionCallBackRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarExpeditionCallBackRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 112:
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
            return AvatarExpeditionCallBackRspOuterClass.internal_static_AvatarExpeditionCallBackRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarExpeditionCallBackRspOuterClass.internal_static_AvatarExpeditionCallBackRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarExpeditionCallBackRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionCallBackRspOuterClass$AvatarExpeditionCallBackRsp$ExpeditionInfoMapDefaultEntryHolder.class */
        public static final class ExpeditionInfoMapDefaultEntryHolder {
            static final MapEntry<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> defaultEntry = MapEntry.newDefaultInstance(AvatarExpeditionCallBackRspOuterClass.f628x4eadfa8b, WireFormat.FieldType.UINT64, 0L, WireFormat.FieldType.MESSAGE, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo.getDefaultInstance());

            private ExpeditionInfoMapDefaultEntryHolder() {
            }
        }

        private MapField<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> internalGetExpeditionInfoMap() {
            if (this.expeditionInfoMap_ == null) {
                return MapField.emptyMapField(ExpeditionInfoMapDefaultEntryHolder.defaultEntry);
            }
            return this.expeditionInfoMap_;
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRspOrBuilder
        public int getExpeditionInfoMapCount() {
            return internalGetExpeditionInfoMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRspOrBuilder
        public boolean containsExpeditionInfoMap(long key) {
            return internalGetExpeditionInfoMap().getMap().containsKey(Long.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRspOrBuilder
        @Deprecated
        public Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMap() {
            return getExpeditionInfoMapMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRspOrBuilder
        public Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMapMap() {
            return internalGetExpeditionInfoMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRspOrBuilder
        public AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo getExpeditionInfoMapOrDefault(long key, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo defaultValue) {
            Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> map = internalGetExpeditionInfoMap().getMap();
            return map.containsKey(Long.valueOf(key)) ? map.get(Long.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRspOrBuilder
        public AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo getExpeditionInfoMapOrThrow(long key) {
            Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> map = internalGetExpeditionInfoMap().getMap();
            if (map.containsKey(Long.valueOf(key))) {
                return map.get(Long.valueOf(key));
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
            GeneratedMessageV3.serializeLongMapTo(output, internalGetExpeditionInfoMap(), ExpeditionInfoMapDefaultEntryHolder.defaultEntry, 7);
            if (this.retcode_ != 0) {
                output.writeInt32(14, this.retcode_);
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
                size2 += CodedOutputStream.computeInt32Size(14, this.retcode_);
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
            if (!(obj instanceof AvatarExpeditionCallBackRsp)) {
                return equals(obj);
            }
            AvatarExpeditionCallBackRsp other = (AvatarExpeditionCallBackRsp) obj;
            return getRetcode() == other.getRetcode() && internalGetExpeditionInfoMap().equals(other.internalGetExpeditionInfoMap()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + getRetcode();
            if (!internalGetExpeditionInfoMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 7)) + internalGetExpeditionInfoMap().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AvatarExpeditionCallBackRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarExpeditionCallBackRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarExpeditionCallBackRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarExpeditionCallBackRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarExpeditionCallBackRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarExpeditionCallBackRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarExpeditionCallBackRsp parseFrom(InputStream input) throws IOException {
            return (AvatarExpeditionCallBackRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarExpeditionCallBackRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarExpeditionCallBackRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarExpeditionCallBackRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarExpeditionCallBackRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarExpeditionCallBackRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarExpeditionCallBackRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarExpeditionCallBackRsp parseFrom(CodedInputStream input) throws IOException {
            return (AvatarExpeditionCallBackRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarExpeditionCallBackRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarExpeditionCallBackRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarExpeditionCallBackRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionCallBackRspOuterClass$AvatarExpeditionCallBackRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarExpeditionCallBackRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private MapField<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> expeditionInfoMap_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRsp.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRsp.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRsp.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRsp.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarExpeditionCallBackRspOuterClass.internal_static_AvatarExpeditionCallBackRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarExpeditionCallBackRspOuterClass.internal_static_AvatarExpeditionCallBackRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarExpeditionCallBackRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarExpeditionCallBackRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                internalGetMutableExpeditionInfoMap().clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarExpeditionCallBackRspOuterClass.internal_static_AvatarExpeditionCallBackRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarExpeditionCallBackRsp getDefaultInstanceForType() {
                return AvatarExpeditionCallBackRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarExpeditionCallBackRsp build() {
                AvatarExpeditionCallBackRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarExpeditionCallBackRsp buildPartial() {
                AvatarExpeditionCallBackRsp result = new AvatarExpeditionCallBackRsp(this);
                int i = this.bitField0_;
                result.retcode_ = this.retcode_;
                result.expeditionInfoMap_ = internalGetExpeditionInfoMap();
                result.expeditionInfoMap_.makeImmutable();
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
                if (other instanceof AvatarExpeditionCallBackRsp) {
                    return mergeFrom((AvatarExpeditionCallBackRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarExpeditionCallBackRsp other) {
                if (other == AvatarExpeditionCallBackRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                internalGetMutableExpeditionInfoMap().mergeFrom(other.internalGetExpeditionInfoMap());
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
                AvatarExpeditionCallBackRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarExpeditionCallBackRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarExpeditionCallBackRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRspOrBuilder
            public int getExpeditionInfoMapCount() {
                return internalGetExpeditionInfoMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRspOrBuilder
            public boolean containsExpeditionInfoMap(long key) {
                return internalGetExpeditionInfoMap().getMap().containsKey(Long.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRspOrBuilder
            @Deprecated
            public Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMap() {
                return getExpeditionInfoMapMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRspOrBuilder
            public Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMapMap() {
                return internalGetExpeditionInfoMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRspOrBuilder
            public AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo getExpeditionInfoMapOrDefault(long key, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo defaultValue) {
                Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> map = internalGetExpeditionInfoMap().getMap();
                return map.containsKey(Long.valueOf(key)) ? map.get(Long.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionCallBackRspOuterClass.AvatarExpeditionCallBackRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static AvatarExpeditionCallBackRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarExpeditionCallBackRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarExpeditionCallBackRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarExpeditionCallBackRsp getDefaultInstanceForType() {
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
