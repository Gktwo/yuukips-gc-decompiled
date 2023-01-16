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
import emu.grasscutter.net.proto.AiThreatInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAiSyncCombatThreatInfoNotifyOuterClass.class */
public final class EvtAiSyncCombatThreatInfoNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n%EvtAiSyncCombatThreatInfoNotify.proto\u001a\u0012AiThreatInfo.proto\"Ç\u0001\n\u001fEvtAiSyncCombatThreatInfoNotify\u0012Y\n\u0016combat_threat_info_map\u0018\u000b \u0003(\u000b29.EvtAiSyncCombatThreatInfoNotify.CombatThreatInfoMapEntry\u001aI\n\u0018CombatThreatInfoMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\u001c\n\u0005value\u0018\u0002 \u0001(\u000b2\r.AiThreatInfo:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AiThreatInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_EvtAiSyncCombatThreatInfoNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_EvtAiSyncCombatThreatInfoNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f702x8c307990 = new GeneratedMessageV3.FieldAccessorTable(internal_static_EvtAiSyncCombatThreatInfoNotify_descriptor, new String[]{"CombatThreatInfoMap"});

    /* renamed from: internal_static_EvtAiSyncCombatThreatInfoNotify_CombatThreatInfoMapEntry_descriptor */
    private static final Descriptors.Descriptor f703x4092c4d9 = internal_static_EvtAiSyncCombatThreatInfoNotify_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_EvtAiSyncCombatThreatInfoNotify_CombatThreatInfoMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f704xc5000257 = new GeneratedMessageV3.FieldAccessorTable(f703x4092c4d9, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAiSyncCombatThreatInfoNotifyOuterClass$EvtAiSyncCombatThreatInfoNotifyOrBuilder.class */
    public interface EvtAiSyncCombatThreatInfoNotifyOrBuilder extends MessageOrBuilder {
        int getCombatThreatInfoMapCount();

        boolean containsCombatThreatInfoMap(int i);

        @Deprecated
        Map<Integer, AiThreatInfoOuterClass.AiThreatInfo> getCombatThreatInfoMap();

        Map<Integer, AiThreatInfoOuterClass.AiThreatInfo> getCombatThreatInfoMapMap();

        AiThreatInfoOuterClass.AiThreatInfo getCombatThreatInfoMapOrDefault(int i, AiThreatInfoOuterClass.AiThreatInfo aiThreatInfo);

        AiThreatInfoOuterClass.AiThreatInfo getCombatThreatInfoMapOrThrow(int i);
    }

    private EvtAiSyncCombatThreatInfoNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAiSyncCombatThreatInfoNotifyOuterClass$EvtAiSyncCombatThreatInfoNotify.class */
    public static final class EvtAiSyncCombatThreatInfoNotify extends GeneratedMessageV3 implements EvtAiSyncCombatThreatInfoNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int COMBAT_THREAT_INFO_MAP_FIELD_NUMBER = 11;
        private MapField<Integer, AiThreatInfoOuterClass.AiThreatInfo> combatThreatInfoMap_;
        private byte memoizedIsInitialized;
        private static final EvtAiSyncCombatThreatInfoNotify DEFAULT_INSTANCE = new EvtAiSyncCombatThreatInfoNotify();
        private static final Parser<EvtAiSyncCombatThreatInfoNotify> PARSER = new AbstractParser<EvtAiSyncCombatThreatInfoNotify>() { // from class: emu.grasscutter.net.proto.EvtAiSyncCombatThreatInfoNotifyOuterClass.EvtAiSyncCombatThreatInfoNotify.1
            @Override // com.google.protobuf.Parser
            public EvtAiSyncCombatThreatInfoNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EvtAiSyncCombatThreatInfoNotify(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.EvtAiSyncCombatThreatInfoNotifyOuterClass.EvtAiSyncCombatThreatInfoNotify.internalGetMapField(int):com.google.protobuf.MapField
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
                com.google.protobuf.MapField r0 = r0.internalGetCombatThreatInfoMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.EvtAiSyncCombatThreatInfoNotifyOuterClass.EvtAiSyncCombatThreatInfoNotify.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private EvtAiSyncCombatThreatInfoNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EvtAiSyncCombatThreatInfoNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EvtAiSyncCombatThreatInfoNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EvtAiSyncCombatThreatInfoNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.combatThreatInfoMap_ = MapField.newMapField(CombatThreatInfoMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, AiThreatInfoOuterClass.AiThreatInfo> combatThreatInfoMap__ = (MapEntry) input.readMessage(CombatThreatInfoMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.combatThreatInfoMap_.getMutableMap().put(combatThreatInfoMap__.getKey(), combatThreatInfoMap__.getValue());
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
            return EvtAiSyncCombatThreatInfoNotifyOuterClass.internal_static_EvtAiSyncCombatThreatInfoNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EvtAiSyncCombatThreatInfoNotifyOuterClass.f702x8c307990.ensureFieldAccessorsInitialized(EvtAiSyncCombatThreatInfoNotify.class, Builder.class);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAiSyncCombatThreatInfoNotifyOuterClass$EvtAiSyncCombatThreatInfoNotify$CombatThreatInfoMapDefaultEntryHolder.class */
        public static final class CombatThreatInfoMapDefaultEntryHolder {
            static final MapEntry<Integer, AiThreatInfoOuterClass.AiThreatInfo> defaultEntry = MapEntry.newDefaultInstance(EvtAiSyncCombatThreatInfoNotifyOuterClass.f703x4092c4d9, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, AiThreatInfoOuterClass.AiThreatInfo.getDefaultInstance());

            private CombatThreatInfoMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, AiThreatInfoOuterClass.AiThreatInfo> internalGetCombatThreatInfoMap() {
            if (this.combatThreatInfoMap_ == null) {
                return MapField.emptyMapField(CombatThreatInfoMapDefaultEntryHolder.defaultEntry);
            }
            return this.combatThreatInfoMap_;
        }

        @Override // emu.grasscutter.net.proto.EvtAiSyncCombatThreatInfoNotifyOuterClass.EvtAiSyncCombatThreatInfoNotifyOrBuilder
        public int getCombatThreatInfoMapCount() {
            return internalGetCombatThreatInfoMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.EvtAiSyncCombatThreatInfoNotifyOuterClass.EvtAiSyncCombatThreatInfoNotifyOrBuilder
        public boolean containsCombatThreatInfoMap(int key) {
            return internalGetCombatThreatInfoMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.EvtAiSyncCombatThreatInfoNotifyOuterClass.EvtAiSyncCombatThreatInfoNotifyOrBuilder
        @Deprecated
        public Map<Integer, AiThreatInfoOuterClass.AiThreatInfo> getCombatThreatInfoMap() {
            return getCombatThreatInfoMapMap();
        }

        @Override // emu.grasscutter.net.proto.EvtAiSyncCombatThreatInfoNotifyOuterClass.EvtAiSyncCombatThreatInfoNotifyOrBuilder
        public Map<Integer, AiThreatInfoOuterClass.AiThreatInfo> getCombatThreatInfoMapMap() {
            return internalGetCombatThreatInfoMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.EvtAiSyncCombatThreatInfoNotifyOuterClass.EvtAiSyncCombatThreatInfoNotifyOrBuilder
        public AiThreatInfoOuterClass.AiThreatInfo getCombatThreatInfoMapOrDefault(int key, AiThreatInfoOuterClass.AiThreatInfo defaultValue) {
            Map<Integer, AiThreatInfoOuterClass.AiThreatInfo> map = internalGetCombatThreatInfoMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.EvtAiSyncCombatThreatInfoNotifyOuterClass.EvtAiSyncCombatThreatInfoNotifyOrBuilder
        public AiThreatInfoOuterClass.AiThreatInfo getCombatThreatInfoMapOrThrow(int key) {
            Map<Integer, AiThreatInfoOuterClass.AiThreatInfo> map = internalGetCombatThreatInfoMap().getMap();
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
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetCombatThreatInfoMap(), CombatThreatInfoMapDefaultEntryHolder.defaultEntry, 11);
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (Map.Entry<Integer, AiThreatInfoOuterClass.AiThreatInfo> entry : internalGetCombatThreatInfoMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(11, CombatThreatInfoMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
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
            if (!(obj instanceof EvtAiSyncCombatThreatInfoNotify)) {
                return equals(obj);
            }
            EvtAiSyncCombatThreatInfoNotify other = (EvtAiSyncCombatThreatInfoNotify) obj;
            return internalGetCombatThreatInfoMap().equals(other.internalGetCombatThreatInfoMap()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (!internalGetCombatThreatInfoMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 11)) + internalGetCombatThreatInfoMap().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static EvtAiSyncCombatThreatInfoNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtAiSyncCombatThreatInfoNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtAiSyncCombatThreatInfoNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtAiSyncCombatThreatInfoNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtAiSyncCombatThreatInfoNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtAiSyncCombatThreatInfoNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtAiSyncCombatThreatInfoNotify parseFrom(InputStream input) throws IOException {
            return (EvtAiSyncCombatThreatInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EvtAiSyncCombatThreatInfoNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtAiSyncCombatThreatInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EvtAiSyncCombatThreatInfoNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (EvtAiSyncCombatThreatInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EvtAiSyncCombatThreatInfoNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtAiSyncCombatThreatInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EvtAiSyncCombatThreatInfoNotify parseFrom(CodedInputStream input) throws IOException {
            return (EvtAiSyncCombatThreatInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EvtAiSyncCombatThreatInfoNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtAiSyncCombatThreatInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EvtAiSyncCombatThreatInfoNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAiSyncCombatThreatInfoNotifyOuterClass$EvtAiSyncCombatThreatInfoNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EvtAiSyncCombatThreatInfoNotifyOrBuilder {
            private int bitField0_;
            private MapField<Integer, AiThreatInfoOuterClass.AiThreatInfo> combatThreatInfoMap_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.EvtAiSyncCombatThreatInfoNotifyOuterClass.EvtAiSyncCombatThreatInfoNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetCombatThreatInfoMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.EvtAiSyncCombatThreatInfoNotifyOuterClass.EvtAiSyncCombatThreatInfoNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.EvtAiSyncCombatThreatInfoNotifyOuterClass.EvtAiSyncCombatThreatInfoNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetMutableCombatThreatInfoMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.EvtAiSyncCombatThreatInfoNotifyOuterClass.EvtAiSyncCombatThreatInfoNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return EvtAiSyncCombatThreatInfoNotifyOuterClass.internal_static_EvtAiSyncCombatThreatInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EvtAiSyncCombatThreatInfoNotifyOuterClass.f702x8c307990.ensureFieldAccessorsInitialized(EvtAiSyncCombatThreatInfoNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EvtAiSyncCombatThreatInfoNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                internalGetMutableCombatThreatInfoMap().clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EvtAiSyncCombatThreatInfoNotifyOuterClass.internal_static_EvtAiSyncCombatThreatInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EvtAiSyncCombatThreatInfoNotify getDefaultInstanceForType() {
                return EvtAiSyncCombatThreatInfoNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EvtAiSyncCombatThreatInfoNotify build() {
                EvtAiSyncCombatThreatInfoNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EvtAiSyncCombatThreatInfoNotify buildPartial() {
                EvtAiSyncCombatThreatInfoNotify result = new EvtAiSyncCombatThreatInfoNotify(this);
                int i = this.bitField0_;
                result.combatThreatInfoMap_ = internalGetCombatThreatInfoMap();
                result.combatThreatInfoMap_.makeImmutable();
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
                if (other instanceof EvtAiSyncCombatThreatInfoNotify) {
                    return mergeFrom((EvtAiSyncCombatThreatInfoNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EvtAiSyncCombatThreatInfoNotify other) {
                if (other == EvtAiSyncCombatThreatInfoNotify.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableCombatThreatInfoMap().mergeFrom(other.internalGetCombatThreatInfoMap());
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
                EvtAiSyncCombatThreatInfoNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = EvtAiSyncCombatThreatInfoNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EvtAiSyncCombatThreatInfoNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private MapField<Integer, AiThreatInfoOuterClass.AiThreatInfo> internalGetCombatThreatInfoMap() {
                if (this.combatThreatInfoMap_ == null) {
                    return MapField.emptyMapField(CombatThreatInfoMapDefaultEntryHolder.defaultEntry);
                }
                return this.combatThreatInfoMap_;
            }

            private MapField<Integer, AiThreatInfoOuterClass.AiThreatInfo> internalGetMutableCombatThreatInfoMap() {
                onChanged();
                if (this.combatThreatInfoMap_ == null) {
                    this.combatThreatInfoMap_ = MapField.newMapField(CombatThreatInfoMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.combatThreatInfoMap_.isMutable()) {
                    this.combatThreatInfoMap_ = this.combatThreatInfoMap_.copy();
                }
                return this.combatThreatInfoMap_;
            }

            @Override // emu.grasscutter.net.proto.EvtAiSyncCombatThreatInfoNotifyOuterClass.EvtAiSyncCombatThreatInfoNotifyOrBuilder
            public int getCombatThreatInfoMapCount() {
                return internalGetCombatThreatInfoMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.EvtAiSyncCombatThreatInfoNotifyOuterClass.EvtAiSyncCombatThreatInfoNotifyOrBuilder
            public boolean containsCombatThreatInfoMap(int key) {
                return internalGetCombatThreatInfoMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.EvtAiSyncCombatThreatInfoNotifyOuterClass.EvtAiSyncCombatThreatInfoNotifyOrBuilder
            @Deprecated
            public Map<Integer, AiThreatInfoOuterClass.AiThreatInfo> getCombatThreatInfoMap() {
                return getCombatThreatInfoMapMap();
            }

            @Override // emu.grasscutter.net.proto.EvtAiSyncCombatThreatInfoNotifyOuterClass.EvtAiSyncCombatThreatInfoNotifyOrBuilder
            public Map<Integer, AiThreatInfoOuterClass.AiThreatInfo> getCombatThreatInfoMapMap() {
                return internalGetCombatThreatInfoMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.EvtAiSyncCombatThreatInfoNotifyOuterClass.EvtAiSyncCombatThreatInfoNotifyOrBuilder
            public AiThreatInfoOuterClass.AiThreatInfo getCombatThreatInfoMapOrDefault(int key, AiThreatInfoOuterClass.AiThreatInfo defaultValue) {
                Map<Integer, AiThreatInfoOuterClass.AiThreatInfo> map = internalGetCombatThreatInfoMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.EvtAiSyncCombatThreatInfoNotifyOuterClass.EvtAiSyncCombatThreatInfoNotifyOrBuilder
            public AiThreatInfoOuterClass.AiThreatInfo getCombatThreatInfoMapOrThrow(int key) {
                Map<Integer, AiThreatInfoOuterClass.AiThreatInfo> map = internalGetCombatThreatInfoMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearCombatThreatInfoMap() {
                internalGetMutableCombatThreatInfoMap().getMutableMap().clear();
                return this;
            }

            public Builder removeCombatThreatInfoMap(int key) {
                internalGetMutableCombatThreatInfoMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, AiThreatInfoOuterClass.AiThreatInfo> getMutableCombatThreatInfoMap() {
                return internalGetMutableCombatThreatInfoMap().getMutableMap();
            }

            public Builder putCombatThreatInfoMap(int key, AiThreatInfoOuterClass.AiThreatInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableCombatThreatInfoMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllCombatThreatInfoMap(Map<Integer, AiThreatInfoOuterClass.AiThreatInfo> values) {
                internalGetMutableCombatThreatInfoMap().getMutableMap().putAll(values);
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

        public static EvtAiSyncCombatThreatInfoNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EvtAiSyncCombatThreatInfoNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EvtAiSyncCombatThreatInfoNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EvtAiSyncCombatThreatInfoNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AiThreatInfoOuterClass.getDescriptor();
    }
}
