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
import emu.grasscutter.net.proto.AiSkillCdInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAiSyncSkillCdNotifyOuterClass.class */
public final class EvtAiSyncSkillCdNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cEvtAiSyncSkillCdNotify.proto\u001a\u0013AiSkillCdInfo.proto\"\u0001\n\u0016EvtAiSyncSkillCdNotify\u00125\n\u0007aiCdMap\u0018\u000b \u0003(\u000b2$.EvtAiSyncSkillCdNotify.AiCdMapEntry\u001a>\n\fAiCdMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\u001d\n\u0005value\u0018\u0002 \u0001(\u000b2\u000e.AiSkillCdInfo:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AiSkillCdInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_EvtAiSyncSkillCdNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EvtAiSyncSkillCdNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EvtAiSyncSkillCdNotify_descriptor, new String[]{"AiCdMap"});
    private static final Descriptors.Descriptor internal_static_EvtAiSyncSkillCdNotify_AiCdMapEntry_descriptor = internal_static_EvtAiSyncSkillCdNotify_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_EvtAiSyncSkillCdNotify_AiCdMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f702x9e746312 = new GeneratedMessageV3.FieldAccessorTable(internal_static_EvtAiSyncSkillCdNotify_AiCdMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAiSyncSkillCdNotifyOuterClass$EvtAiSyncSkillCdNotifyOrBuilder.class */
    public interface EvtAiSyncSkillCdNotifyOrBuilder extends MessageOrBuilder {
        int getAiCdMapCount();

        boolean containsAiCdMap(int i);

        @Deprecated
        Map<Integer, AiSkillCdInfoOuterClass.AiSkillCdInfo> getAiCdMap();

        Map<Integer, AiSkillCdInfoOuterClass.AiSkillCdInfo> getAiCdMapMap();

        AiSkillCdInfoOuterClass.AiSkillCdInfo getAiCdMapOrDefault(int i, AiSkillCdInfoOuterClass.AiSkillCdInfo aiSkillCdInfo);

        AiSkillCdInfoOuterClass.AiSkillCdInfo getAiCdMapOrThrow(int i);
    }

    private EvtAiSyncSkillCdNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAiSyncSkillCdNotifyOuterClass$EvtAiSyncSkillCdNotify.class */
    public static final class EvtAiSyncSkillCdNotify extends GeneratedMessageV3 implements EvtAiSyncSkillCdNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AICDMAP_FIELD_NUMBER = 11;
        private MapField<Integer, AiSkillCdInfoOuterClass.AiSkillCdInfo> aiCdMap_;
        private byte memoizedIsInitialized;
        private static final EvtAiSyncSkillCdNotify DEFAULT_INSTANCE = new EvtAiSyncSkillCdNotify();
        private static final Parser<EvtAiSyncSkillCdNotify> PARSER = new AbstractParser<EvtAiSyncSkillCdNotify>() { // from class: emu.grasscutter.net.proto.EvtAiSyncSkillCdNotifyOuterClass.EvtAiSyncSkillCdNotify.1
            @Override // com.google.protobuf.Parser
            public EvtAiSyncSkillCdNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EvtAiSyncSkillCdNotify(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.EvtAiSyncSkillCdNotifyOuterClass.EvtAiSyncSkillCdNotify.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 11: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetAiCdMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.EvtAiSyncSkillCdNotifyOuterClass.EvtAiSyncSkillCdNotify.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private EvtAiSyncSkillCdNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EvtAiSyncSkillCdNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EvtAiSyncSkillCdNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EvtAiSyncSkillCdNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 90:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.aiCdMap_ = MapField.newMapField(AiCdMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, AiSkillCdInfoOuterClass.AiSkillCdInfo> aiCdMap__ = (MapEntry) input.readMessage(AiCdMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.aiCdMap_.getMutableMap().put(aiCdMap__.getKey(), aiCdMap__.getValue());
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
            return EvtAiSyncSkillCdNotifyOuterClass.internal_static_EvtAiSyncSkillCdNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EvtAiSyncSkillCdNotifyOuterClass.internal_static_EvtAiSyncSkillCdNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(EvtAiSyncSkillCdNotify.class, Builder.class);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAiSyncSkillCdNotifyOuterClass$EvtAiSyncSkillCdNotify$AiCdMapDefaultEntryHolder.class */
        public static final class AiCdMapDefaultEntryHolder {
            static final MapEntry<Integer, AiSkillCdInfoOuterClass.AiSkillCdInfo> defaultEntry = MapEntry.newDefaultInstance(EvtAiSyncSkillCdNotifyOuterClass.internal_static_EvtAiSyncSkillCdNotify_AiCdMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, AiSkillCdInfoOuterClass.AiSkillCdInfo.getDefaultInstance());

            private AiCdMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, AiSkillCdInfoOuterClass.AiSkillCdInfo> internalGetAiCdMap() {
            if (this.aiCdMap_ == null) {
                return MapField.emptyMapField(AiCdMapDefaultEntryHolder.defaultEntry);
            }
            return this.aiCdMap_;
        }

        @Override // emu.grasscutter.net.proto.EvtAiSyncSkillCdNotifyOuterClass.EvtAiSyncSkillCdNotifyOrBuilder
        public int getAiCdMapCount() {
            return internalGetAiCdMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.EvtAiSyncSkillCdNotifyOuterClass.EvtAiSyncSkillCdNotifyOrBuilder
        public boolean containsAiCdMap(int key) {
            return internalGetAiCdMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.EvtAiSyncSkillCdNotifyOuterClass.EvtAiSyncSkillCdNotifyOrBuilder
        @Deprecated
        public Map<Integer, AiSkillCdInfoOuterClass.AiSkillCdInfo> getAiCdMap() {
            return getAiCdMapMap();
        }

        @Override // emu.grasscutter.net.proto.EvtAiSyncSkillCdNotifyOuterClass.EvtAiSyncSkillCdNotifyOrBuilder
        public Map<Integer, AiSkillCdInfoOuterClass.AiSkillCdInfo> getAiCdMapMap() {
            return internalGetAiCdMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.EvtAiSyncSkillCdNotifyOuterClass.EvtAiSyncSkillCdNotifyOrBuilder
        public AiSkillCdInfoOuterClass.AiSkillCdInfo getAiCdMapOrDefault(int key, AiSkillCdInfoOuterClass.AiSkillCdInfo defaultValue) {
            Map<Integer, AiSkillCdInfoOuterClass.AiSkillCdInfo> map = internalGetAiCdMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.EvtAiSyncSkillCdNotifyOuterClass.EvtAiSyncSkillCdNotifyOrBuilder
        public AiSkillCdInfoOuterClass.AiSkillCdInfo getAiCdMapOrThrow(int key) {
            Map<Integer, AiSkillCdInfoOuterClass.AiSkillCdInfo> map = internalGetAiCdMap().getMap();
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
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetAiCdMap(), AiCdMapDefaultEntryHolder.defaultEntry, 11);
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (Map.Entry<Integer, AiSkillCdInfoOuterClass.AiSkillCdInfo> entry : internalGetAiCdMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(11, AiCdMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
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
            if (!(obj instanceof EvtAiSyncSkillCdNotify)) {
                return equals(obj);
            }
            EvtAiSyncSkillCdNotify other = (EvtAiSyncSkillCdNotify) obj;
            return internalGetAiCdMap().equals(other.internalGetAiCdMap()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (!internalGetAiCdMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 11)) + internalGetAiCdMap().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static EvtAiSyncSkillCdNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtAiSyncSkillCdNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtAiSyncSkillCdNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtAiSyncSkillCdNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtAiSyncSkillCdNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtAiSyncSkillCdNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtAiSyncSkillCdNotify parseFrom(InputStream input) throws IOException {
            return (EvtAiSyncSkillCdNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EvtAiSyncSkillCdNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtAiSyncSkillCdNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EvtAiSyncSkillCdNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (EvtAiSyncSkillCdNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EvtAiSyncSkillCdNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtAiSyncSkillCdNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EvtAiSyncSkillCdNotify parseFrom(CodedInputStream input) throws IOException {
            return (EvtAiSyncSkillCdNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EvtAiSyncSkillCdNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtAiSyncSkillCdNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EvtAiSyncSkillCdNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAiSyncSkillCdNotifyOuterClass$EvtAiSyncSkillCdNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EvtAiSyncSkillCdNotifyOrBuilder {
            private int bitField0_;
            private MapField<Integer, AiSkillCdInfoOuterClass.AiSkillCdInfo> aiCdMap_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.EvtAiSyncSkillCdNotifyOuterClass.EvtAiSyncSkillCdNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetAiCdMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.EvtAiSyncSkillCdNotifyOuterClass.EvtAiSyncSkillCdNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.EvtAiSyncSkillCdNotifyOuterClass.EvtAiSyncSkillCdNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetMutableAiCdMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.EvtAiSyncSkillCdNotifyOuterClass.EvtAiSyncSkillCdNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return EvtAiSyncSkillCdNotifyOuterClass.internal_static_EvtAiSyncSkillCdNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EvtAiSyncSkillCdNotifyOuterClass.internal_static_EvtAiSyncSkillCdNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(EvtAiSyncSkillCdNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EvtAiSyncSkillCdNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                internalGetMutableAiCdMap().clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EvtAiSyncSkillCdNotifyOuterClass.internal_static_EvtAiSyncSkillCdNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EvtAiSyncSkillCdNotify getDefaultInstanceForType() {
                return EvtAiSyncSkillCdNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EvtAiSyncSkillCdNotify build() {
                EvtAiSyncSkillCdNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EvtAiSyncSkillCdNotify buildPartial() {
                EvtAiSyncSkillCdNotify result = new EvtAiSyncSkillCdNotify(this);
                int i = this.bitField0_;
                result.aiCdMap_ = internalGetAiCdMap();
                result.aiCdMap_.makeImmutable();
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
                if (other instanceof EvtAiSyncSkillCdNotify) {
                    return mergeFrom((EvtAiSyncSkillCdNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EvtAiSyncSkillCdNotify other) {
                if (other == EvtAiSyncSkillCdNotify.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableAiCdMap().mergeFrom(other.internalGetAiCdMap());
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
                EvtAiSyncSkillCdNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = EvtAiSyncSkillCdNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EvtAiSyncSkillCdNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private MapField<Integer, AiSkillCdInfoOuterClass.AiSkillCdInfo> internalGetAiCdMap() {
                if (this.aiCdMap_ == null) {
                    return MapField.emptyMapField(AiCdMapDefaultEntryHolder.defaultEntry);
                }
                return this.aiCdMap_;
            }

            private MapField<Integer, AiSkillCdInfoOuterClass.AiSkillCdInfo> internalGetMutableAiCdMap() {
                onChanged();
                if (this.aiCdMap_ == null) {
                    this.aiCdMap_ = MapField.newMapField(AiCdMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.aiCdMap_.isMutable()) {
                    this.aiCdMap_ = this.aiCdMap_.copy();
                }
                return this.aiCdMap_;
            }

            @Override // emu.grasscutter.net.proto.EvtAiSyncSkillCdNotifyOuterClass.EvtAiSyncSkillCdNotifyOrBuilder
            public int getAiCdMapCount() {
                return internalGetAiCdMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.EvtAiSyncSkillCdNotifyOuterClass.EvtAiSyncSkillCdNotifyOrBuilder
            public boolean containsAiCdMap(int key) {
                return internalGetAiCdMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.EvtAiSyncSkillCdNotifyOuterClass.EvtAiSyncSkillCdNotifyOrBuilder
            @Deprecated
            public Map<Integer, AiSkillCdInfoOuterClass.AiSkillCdInfo> getAiCdMap() {
                return getAiCdMapMap();
            }

            @Override // emu.grasscutter.net.proto.EvtAiSyncSkillCdNotifyOuterClass.EvtAiSyncSkillCdNotifyOrBuilder
            public Map<Integer, AiSkillCdInfoOuterClass.AiSkillCdInfo> getAiCdMapMap() {
                return internalGetAiCdMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.EvtAiSyncSkillCdNotifyOuterClass.EvtAiSyncSkillCdNotifyOrBuilder
            public AiSkillCdInfoOuterClass.AiSkillCdInfo getAiCdMapOrDefault(int key, AiSkillCdInfoOuterClass.AiSkillCdInfo defaultValue) {
                Map<Integer, AiSkillCdInfoOuterClass.AiSkillCdInfo> map = internalGetAiCdMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.EvtAiSyncSkillCdNotifyOuterClass.EvtAiSyncSkillCdNotifyOrBuilder
            public AiSkillCdInfoOuterClass.AiSkillCdInfo getAiCdMapOrThrow(int key) {
                Map<Integer, AiSkillCdInfoOuterClass.AiSkillCdInfo> map = internalGetAiCdMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearAiCdMap() {
                internalGetMutableAiCdMap().getMutableMap().clear();
                return this;
            }

            public Builder removeAiCdMap(int key) {
                internalGetMutableAiCdMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, AiSkillCdInfoOuterClass.AiSkillCdInfo> getMutableAiCdMap() {
                return internalGetMutableAiCdMap().getMutableMap();
            }

            public Builder putAiCdMap(int key, AiSkillCdInfoOuterClass.AiSkillCdInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableAiCdMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllAiCdMap(Map<Integer, AiSkillCdInfoOuterClass.AiSkillCdInfo> values) {
                internalGetMutableAiCdMap().getMutableMap().putAll(values);
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

        public static EvtAiSyncSkillCdNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EvtAiSyncSkillCdNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EvtAiSyncSkillCdNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EvtAiSyncSkillCdNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AiSkillCdInfoOuterClass.getDescriptor();
    }
}
