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
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AiSkillCdInfoOuterClass.class */
public final class AiSkillCdInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013AiSkillCdInfo.proto\"ì\u0001\n\rAiSkillCdInfo\u00122\n\nskillCdMap\u0018\u000e \u0003(\u000b2\u001e.AiSkillCdInfo.SkillCdMapEntry\u0012<\n\u000fskillGroupCdMap\u0018\u0003 \u0003(\u000b2#.AiSkillCdInfo.SkillGroupCdMapEntry\u001a1\n\u000fSkillCdMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001\u001a6\n\u0014SkillGroupCdMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AiSkillCdInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AiSkillCdInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AiSkillCdInfo_descriptor, new String[]{"SkillCdMap", "SkillGroupCdMap"});
    private static final Descriptors.Descriptor internal_static_AiSkillCdInfo_SkillCdMapEntry_descriptor = internal_static_AiSkillCdInfo_descriptor.getNestedTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AiSkillCdInfo_SkillCdMapEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AiSkillCdInfo_SkillCdMapEntry_descriptor, new String[]{"Key", "Value"});
    private static final Descriptors.Descriptor internal_static_AiSkillCdInfo_SkillGroupCdMapEntry_descriptor = internal_static_AiSkillCdInfo_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_AiSkillCdInfo_SkillGroupCdMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f620x285b22f1 = new GeneratedMessageV3.FieldAccessorTable(internal_static_AiSkillCdInfo_SkillGroupCdMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AiSkillCdInfoOuterClass$AiSkillCdInfoOrBuilder.class */
    public interface AiSkillCdInfoOrBuilder extends MessageOrBuilder {
        int getSkillCdMapCount();

        boolean containsSkillCdMap(int i);

        @Deprecated
        Map<Integer, Integer> getSkillCdMap();

        Map<Integer, Integer> getSkillCdMapMap();

        int getSkillCdMapOrDefault(int i, int i2);

        int getSkillCdMapOrThrow(int i);

        int getSkillGroupCdMapCount();

        boolean containsSkillGroupCdMap(int i);

        @Deprecated
        Map<Integer, Integer> getSkillGroupCdMap();

        Map<Integer, Integer> getSkillGroupCdMapMap();

        int getSkillGroupCdMapOrDefault(int i, int i2);

        int getSkillGroupCdMapOrThrow(int i);
    }

    private AiSkillCdInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AiSkillCdInfoOuterClass$AiSkillCdInfo.class */
    public static final class AiSkillCdInfo extends GeneratedMessageV3 implements AiSkillCdInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SKILLCDMAP_FIELD_NUMBER = 14;
        private MapField<Integer, Integer> skillCdMap_;
        public static final int SKILLGROUPCDMAP_FIELD_NUMBER = 3;
        private MapField<Integer, Integer> skillGroupCdMap_;
        private byte memoizedIsInitialized;
        private static final AiSkillCdInfo DEFAULT_INSTANCE = new AiSkillCdInfo();
        private static final Parser<AiSkillCdInfo> PARSER = new AbstractParser<AiSkillCdInfo>() { // from class: emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfo.1
            @Override // com.google.protobuf.Parser
            public AiSkillCdInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AiSkillCdInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 3: goto L_0x0021;
                    case 14: goto L_0x001c;
                    default: goto L_0x0026;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetSkillCdMap()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetSkillGroupCdMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private AiSkillCdInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AiSkillCdInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AiSkillCdInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AiSkillCdInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 26:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.skillGroupCdMap_ = MapField.newMapField(SkillGroupCdMapDefaultEntryHolder.defaultEntry);
                                        mutable_bitField0_ |= 2;
                                    }
                                    MapEntry<Integer, Integer> skillGroupCdMap__ = (MapEntry) input.readMessage(SkillGroupCdMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                    this.skillGroupCdMap_.getMutableMap().put(skillGroupCdMap__.getKey(), skillGroupCdMap__.getValue());
                                    break;
                                case 114:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.skillCdMap_ = MapField.newMapField(SkillCdMapDefaultEntryHolder.defaultEntry);
                                        mutable_bitField0_ |= 1;
                                    }
                                    MapEntry<Integer, Integer> skillCdMap__ = (MapEntry) input.readMessage(SkillCdMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                    this.skillCdMap_.getMutableMap().put(skillCdMap__.getKey(), skillCdMap__.getValue());
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
            return AiSkillCdInfoOuterClass.internal_static_AiSkillCdInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AiSkillCdInfoOuterClass.internal_static_AiSkillCdInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AiSkillCdInfo.class, Builder.class);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AiSkillCdInfoOuterClass$AiSkillCdInfo$SkillCdMapDefaultEntryHolder.class */
        public static final class SkillCdMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(AiSkillCdInfoOuterClass.internal_static_AiSkillCdInfo_SkillCdMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private SkillCdMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetSkillCdMap() {
            if (this.skillCdMap_ == null) {
                return MapField.emptyMapField(SkillCdMapDefaultEntryHolder.defaultEntry);
            }
            return this.skillCdMap_;
        }

        @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
        public int getSkillCdMapCount() {
            return internalGetSkillCdMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
        public boolean containsSkillCdMap(int key) {
            return internalGetSkillCdMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getSkillCdMap() {
            return getSkillCdMapMap();
        }

        @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
        public Map<Integer, Integer> getSkillCdMapMap() {
            return internalGetSkillCdMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
        public int getSkillCdMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetSkillCdMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
        public int getSkillCdMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetSkillCdMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AiSkillCdInfoOuterClass$AiSkillCdInfo$SkillGroupCdMapDefaultEntryHolder.class */
        public static final class SkillGroupCdMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(AiSkillCdInfoOuterClass.internal_static_AiSkillCdInfo_SkillGroupCdMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private SkillGroupCdMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetSkillGroupCdMap() {
            if (this.skillGroupCdMap_ == null) {
                return MapField.emptyMapField(SkillGroupCdMapDefaultEntryHolder.defaultEntry);
            }
            return this.skillGroupCdMap_;
        }

        @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
        public int getSkillGroupCdMapCount() {
            return internalGetSkillGroupCdMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
        public boolean containsSkillGroupCdMap(int key) {
            return internalGetSkillGroupCdMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getSkillGroupCdMap() {
            return getSkillGroupCdMapMap();
        }

        @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
        public Map<Integer, Integer> getSkillGroupCdMapMap() {
            return internalGetSkillGroupCdMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
        public int getSkillGroupCdMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetSkillGroupCdMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
        public int getSkillGroupCdMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetSkillGroupCdMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
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
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetSkillGroupCdMap(), SkillGroupCdMapDefaultEntryHolder.defaultEntry, 3);
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetSkillCdMap(), SkillCdMapDefaultEntryHolder.defaultEntry, 14);
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (Map.Entry<Integer, Integer> entry : internalGetSkillGroupCdMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(3, SkillGroupCdMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            for (Map.Entry<Integer, Integer> entry2 : internalGetSkillCdMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(14, SkillCdMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
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
            if (!(obj instanceof AiSkillCdInfo)) {
                return equals(obj);
            }
            AiSkillCdInfo other = (AiSkillCdInfo) obj;
            return internalGetSkillCdMap().equals(other.internalGetSkillCdMap()) && internalGetSkillGroupCdMap().equals(other.internalGetSkillGroupCdMap()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (!internalGetSkillCdMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 14)) + internalGetSkillCdMap().hashCode();
            }
            if (!internalGetSkillGroupCdMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 3)) + internalGetSkillGroupCdMap().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AiSkillCdInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AiSkillCdInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AiSkillCdInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AiSkillCdInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AiSkillCdInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AiSkillCdInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AiSkillCdInfo parseFrom(InputStream input) throws IOException {
            return (AiSkillCdInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AiSkillCdInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AiSkillCdInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AiSkillCdInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (AiSkillCdInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AiSkillCdInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AiSkillCdInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AiSkillCdInfo parseFrom(CodedInputStream input) throws IOException {
            return (AiSkillCdInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AiSkillCdInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AiSkillCdInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AiSkillCdInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AiSkillCdInfoOuterClass$AiSkillCdInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AiSkillCdInfoOrBuilder {
            private int bitField0_;
            private MapField<Integer, Integer> skillCdMap_;
            private MapField<Integer, Integer> skillGroupCdMap_;

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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 3: goto L_0x0021;
                        case 14: goto L_0x001c;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetSkillCdMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetSkillGroupCdMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 3: goto L_0x0021;
                        case 14: goto L_0x001c;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableSkillCdMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableSkillGroupCdMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AiSkillCdInfoOuterClass.internal_static_AiSkillCdInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AiSkillCdInfoOuterClass.internal_static_AiSkillCdInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AiSkillCdInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AiSkillCdInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                internalGetMutableSkillCdMap().clear();
                internalGetMutableSkillGroupCdMap().clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AiSkillCdInfoOuterClass.internal_static_AiSkillCdInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AiSkillCdInfo getDefaultInstanceForType() {
                return AiSkillCdInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AiSkillCdInfo build() {
                AiSkillCdInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AiSkillCdInfo buildPartial() {
                AiSkillCdInfo result = new AiSkillCdInfo(this);
                int i = this.bitField0_;
                result.skillCdMap_ = internalGetSkillCdMap();
                result.skillCdMap_.makeImmutable();
                result.skillGroupCdMap_ = internalGetSkillGroupCdMap();
                result.skillGroupCdMap_.makeImmutable();
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
                if (other instanceof AiSkillCdInfo) {
                    return mergeFrom((AiSkillCdInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AiSkillCdInfo other) {
                if (other == AiSkillCdInfo.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableSkillCdMap().mergeFrom(other.internalGetSkillCdMap());
                internalGetMutableSkillGroupCdMap().mergeFrom(other.internalGetSkillGroupCdMap());
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
                AiSkillCdInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = AiSkillCdInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AiSkillCdInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private MapField<Integer, Integer> internalGetSkillCdMap() {
                if (this.skillCdMap_ == null) {
                    return MapField.emptyMapField(SkillCdMapDefaultEntryHolder.defaultEntry);
                }
                return this.skillCdMap_;
            }

            private MapField<Integer, Integer> internalGetMutableSkillCdMap() {
                onChanged();
                if (this.skillCdMap_ == null) {
                    this.skillCdMap_ = MapField.newMapField(SkillCdMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.skillCdMap_.isMutable()) {
                    this.skillCdMap_ = this.skillCdMap_.copy();
                }
                return this.skillCdMap_;
            }

            @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
            public int getSkillCdMapCount() {
                return internalGetSkillCdMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
            public boolean containsSkillCdMap(int key) {
                return internalGetSkillCdMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getSkillCdMap() {
                return getSkillCdMapMap();
            }

            @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
            public Map<Integer, Integer> getSkillCdMapMap() {
                return internalGetSkillCdMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
            public int getSkillCdMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetSkillCdMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
            public int getSkillCdMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetSkillCdMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearSkillCdMap() {
                internalGetMutableSkillCdMap().getMutableMap().clear();
                return this;
            }

            public Builder removeSkillCdMap(int key) {
                internalGetMutableSkillCdMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableSkillCdMap() {
                return internalGetMutableSkillCdMap().getMutableMap();
            }

            public Builder putSkillCdMap(int key, int value) {
                internalGetMutableSkillCdMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllSkillCdMap(Map<Integer, Integer> values) {
                internalGetMutableSkillCdMap().getMutableMap().putAll(values);
                return this;
            }

            private MapField<Integer, Integer> internalGetSkillGroupCdMap() {
                if (this.skillGroupCdMap_ == null) {
                    return MapField.emptyMapField(SkillGroupCdMapDefaultEntryHolder.defaultEntry);
                }
                return this.skillGroupCdMap_;
            }

            private MapField<Integer, Integer> internalGetMutableSkillGroupCdMap() {
                onChanged();
                if (this.skillGroupCdMap_ == null) {
                    this.skillGroupCdMap_ = MapField.newMapField(SkillGroupCdMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.skillGroupCdMap_.isMutable()) {
                    this.skillGroupCdMap_ = this.skillGroupCdMap_.copy();
                }
                return this.skillGroupCdMap_;
            }

            @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
            public int getSkillGroupCdMapCount() {
                return internalGetSkillGroupCdMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
            public boolean containsSkillGroupCdMap(int key) {
                return internalGetSkillGroupCdMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getSkillGroupCdMap() {
                return getSkillGroupCdMapMap();
            }

            @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
            public Map<Integer, Integer> getSkillGroupCdMapMap() {
                return internalGetSkillGroupCdMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
            public int getSkillGroupCdMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetSkillGroupCdMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.AiSkillCdInfoOuterClass.AiSkillCdInfoOrBuilder
            public int getSkillGroupCdMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetSkillGroupCdMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearSkillGroupCdMap() {
                internalGetMutableSkillGroupCdMap().getMutableMap().clear();
                return this;
            }

            public Builder removeSkillGroupCdMap(int key) {
                internalGetMutableSkillGroupCdMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableSkillGroupCdMap() {
                return internalGetMutableSkillGroupCdMap().getMutableMap();
            }

            public Builder putSkillGroupCdMap(int key, int value) {
                internalGetMutableSkillGroupCdMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllSkillGroupCdMap(Map<Integer, Integer> values) {
                internalGetMutableSkillGroupCdMap().getMutableMap().putAll(values);
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

        public static AiSkillCdInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AiSkillCdInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AiSkillCdInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AiSkillCdInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
