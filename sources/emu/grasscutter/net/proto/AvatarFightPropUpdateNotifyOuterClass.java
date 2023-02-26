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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarFightPropUpdateNotifyOuterClass.class */
public final class AvatarFightPropUpdateNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!AvatarFightPropUpdateNotify.proto\"¬\u0001\n\u001bAvatarFightPropUpdateNotify\u0012\u0012\n\navatarGuid\u0018\b \u0001(\u0004\u0012D\n\ffightPropMap\u0018\n \u0003(\u000b2..AvatarFightPropUpdateNotify.FightPropMapEntry\u001a3\n\u0011FightPropMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\u0002:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AvatarFightPropUpdateNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarFightPropUpdateNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarFightPropUpdateNotify_descriptor, new String[]{"AvatarGuid", "FightPropMap"});

    /* renamed from: internal_static_AvatarFightPropUpdateNotify_FightPropMapEntry_descriptor */
    private static final Descriptors.Descriptor f640x8a99f647 = internal_static_AvatarFightPropUpdateNotify_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_AvatarFightPropUpdateNotify_FightPropMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f641xe6ade5c5 = new GeneratedMessageV3.FieldAccessorTable(f640x8a99f647, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarFightPropUpdateNotifyOuterClass$AvatarFightPropUpdateNotifyOrBuilder.class */
    public interface AvatarFightPropUpdateNotifyOrBuilder extends MessageOrBuilder {
        long getAvatarGuid();

        int getFightPropMapCount();

        boolean containsFightPropMap(int i);

        @Deprecated
        Map<Integer, Float> getFightPropMap();

        Map<Integer, Float> getFightPropMapMap();

        float getFightPropMapOrDefault(int i, float f);

        float getFightPropMapOrThrow(int i);
    }

    private AvatarFightPropUpdateNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarFightPropUpdateNotifyOuterClass$AvatarFightPropUpdateNotify.class */
    public static final class AvatarFightPropUpdateNotify extends GeneratedMessageV3 implements AvatarFightPropUpdateNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATARGUID_FIELD_NUMBER = 8;
        private long avatarGuid_;
        public static final int FIGHTPROPMAP_FIELD_NUMBER = 10;
        private MapField<Integer, Float> fightPropMap_;
        private byte memoizedIsInitialized;
        private static final AvatarFightPropUpdateNotify DEFAULT_INSTANCE = new AvatarFightPropUpdateNotify();
        private static final Parser<AvatarFightPropUpdateNotify> PARSER = new AbstractParser<AvatarFightPropUpdateNotify>() { // from class: emu.grasscutter.net.proto.AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotify.1
            @Override // com.google.protobuf.Parser
            public AvatarFightPropUpdateNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarFightPropUpdateNotify(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotify.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 10: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetFightPropMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotify.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private AvatarFightPropUpdateNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarFightPropUpdateNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarFightPropUpdateNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarFightPropUpdateNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 64:
                                this.avatarGuid_ = input.readUInt64();
                                break;
                            case 82:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.fightPropMap_ = MapField.newMapField(FightPropMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, Float> fightPropMap__ = (MapEntry) input.readMessage(FightPropMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.fightPropMap_.getMutableMap().put(fightPropMap__.getKey(), fightPropMap__.getValue());
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
            return AvatarFightPropUpdateNotifyOuterClass.internal_static_AvatarFightPropUpdateNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarFightPropUpdateNotifyOuterClass.internal_static_AvatarFightPropUpdateNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarFightPropUpdateNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotifyOrBuilder
        public long getAvatarGuid() {
            return this.avatarGuid_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarFightPropUpdateNotifyOuterClass$AvatarFightPropUpdateNotify$FightPropMapDefaultEntryHolder.class */
        public static final class FightPropMapDefaultEntryHolder {
            static final MapEntry<Integer, Float> defaultEntry = MapEntry.newDefaultInstance(AvatarFightPropUpdateNotifyOuterClass.f640x8a99f647, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.FLOAT, Float.valueOf(0.0f));

            private FightPropMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Float> internalGetFightPropMap() {
            if (this.fightPropMap_ == null) {
                return MapField.emptyMapField(FightPropMapDefaultEntryHolder.defaultEntry);
            }
            return this.fightPropMap_;
        }

        @Override // emu.grasscutter.net.proto.AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotifyOrBuilder
        public int getFightPropMapCount() {
            return internalGetFightPropMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotifyOrBuilder
        public boolean containsFightPropMap(int key) {
            return internalGetFightPropMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotifyOrBuilder
        @Deprecated
        public Map<Integer, Float> getFightPropMap() {
            return getFightPropMapMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotifyOrBuilder
        public Map<Integer, Float> getFightPropMapMap() {
            return internalGetFightPropMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotifyOrBuilder
        public float getFightPropMapOrDefault(int key, float defaultValue) {
            Map<Integer, Float> map = internalGetFightPropMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).floatValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotifyOrBuilder
        public float getFightPropMapOrThrow(int key) {
            Map<Integer, Float> map = internalGetFightPropMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).floatValue();
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
            if (this.avatarGuid_ != 0) {
                output.writeUInt64(8, this.avatarGuid_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetFightPropMap(), FightPropMapDefaultEntryHolder.defaultEntry, 10);
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.avatarGuid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(8, this.avatarGuid_);
            }
            for (Map.Entry<Integer, Float> entry : internalGetFightPropMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(10, FightPropMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
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
            if (!(obj instanceof AvatarFightPropUpdateNotify)) {
                return equals(obj);
            }
            AvatarFightPropUpdateNotify other = (AvatarFightPropUpdateNotify) obj;
            return getAvatarGuid() == other.getAvatarGuid() && internalGetFightPropMap().equals(other.internalGetFightPropMap()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + Internal.hashLong(getAvatarGuid());
            if (!internalGetFightPropMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 10)) + internalGetFightPropMap().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AvatarFightPropUpdateNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarFightPropUpdateNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarFightPropUpdateNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarFightPropUpdateNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarFightPropUpdateNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarFightPropUpdateNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarFightPropUpdateNotify parseFrom(InputStream input) throws IOException {
            return (AvatarFightPropUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarFightPropUpdateNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarFightPropUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarFightPropUpdateNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarFightPropUpdateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarFightPropUpdateNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarFightPropUpdateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarFightPropUpdateNotify parseFrom(CodedInputStream input) throws IOException {
            return (AvatarFightPropUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarFightPropUpdateNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarFightPropUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarFightPropUpdateNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarFightPropUpdateNotifyOuterClass$AvatarFightPropUpdateNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarFightPropUpdateNotifyOrBuilder {
            private int bitField0_;
            private long avatarGuid_;
            private MapField<Integer, Float> fightPropMap_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 10: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetFightPropMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 10: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableFightPropMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarFightPropUpdateNotifyOuterClass.internal_static_AvatarFightPropUpdateNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarFightPropUpdateNotifyOuterClass.internal_static_AvatarFightPropUpdateNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarFightPropUpdateNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarFightPropUpdateNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.avatarGuid_ = 0;
                internalGetMutableFightPropMap().clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarFightPropUpdateNotifyOuterClass.internal_static_AvatarFightPropUpdateNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarFightPropUpdateNotify getDefaultInstanceForType() {
                return AvatarFightPropUpdateNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarFightPropUpdateNotify build() {
                AvatarFightPropUpdateNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarFightPropUpdateNotify buildPartial() {
                AvatarFightPropUpdateNotify result = new AvatarFightPropUpdateNotify(this);
                int i = this.bitField0_;
                result.avatarGuid_ = this.avatarGuid_;
                result.fightPropMap_ = internalGetFightPropMap();
                result.fightPropMap_.makeImmutable();
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
                if (other instanceof AvatarFightPropUpdateNotify) {
                    return mergeFrom((AvatarFightPropUpdateNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarFightPropUpdateNotify other) {
                if (other == AvatarFightPropUpdateNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getAvatarGuid() != 0) {
                    setAvatarGuid(other.getAvatarGuid());
                }
                internalGetMutableFightPropMap().mergeFrom(other.internalGetFightPropMap());
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
                AvatarFightPropUpdateNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarFightPropUpdateNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarFightPropUpdateNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotifyOrBuilder
            public long getAvatarGuid() {
                return this.avatarGuid_;
            }

            public Builder setAvatarGuid(long value) {
                this.avatarGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarGuid() {
                this.avatarGuid_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, Float> internalGetFightPropMap() {
                if (this.fightPropMap_ == null) {
                    return MapField.emptyMapField(FightPropMapDefaultEntryHolder.defaultEntry);
                }
                return this.fightPropMap_;
            }

            private MapField<Integer, Float> internalGetMutableFightPropMap() {
                onChanged();
                if (this.fightPropMap_ == null) {
                    this.fightPropMap_ = MapField.newMapField(FightPropMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.fightPropMap_.isMutable()) {
                    this.fightPropMap_ = this.fightPropMap_.copy();
                }
                return this.fightPropMap_;
            }

            @Override // emu.grasscutter.net.proto.AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotifyOrBuilder
            public int getFightPropMapCount() {
                return internalGetFightPropMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotifyOrBuilder
            public boolean containsFightPropMap(int key) {
                return internalGetFightPropMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotifyOrBuilder
            @Deprecated
            public Map<Integer, Float> getFightPropMap() {
                return getFightPropMapMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotifyOrBuilder
            public Map<Integer, Float> getFightPropMapMap() {
                return internalGetFightPropMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotifyOrBuilder
            public float getFightPropMapOrDefault(int key, float defaultValue) {
                Map<Integer, Float> map = internalGetFightPropMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).floatValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.AvatarFightPropUpdateNotifyOuterClass.AvatarFightPropUpdateNotifyOrBuilder
            public float getFightPropMapOrThrow(int key) {
                Map<Integer, Float> map = internalGetFightPropMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).floatValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearFightPropMap() {
                internalGetMutableFightPropMap().getMutableMap().clear();
                return this;
            }

            public Builder removeFightPropMap(int key) {
                internalGetMutableFightPropMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Float> getMutableFightPropMap() {
                return internalGetMutableFightPropMap().getMutableMap();
            }

            public Builder putFightPropMap(int key, float value) {
                internalGetMutableFightPropMap().getMutableMap().put(Integer.valueOf(key), Float.valueOf(value));
                return this;
            }

            public Builder putAllFightPropMap(Map<Integer, Float> values) {
                internalGetMutableFightPropMap().getMutableMap().putAll(values);
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

        public static AvatarFightPropUpdateNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarFightPropUpdateNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarFightPropUpdateNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarFightPropUpdateNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
