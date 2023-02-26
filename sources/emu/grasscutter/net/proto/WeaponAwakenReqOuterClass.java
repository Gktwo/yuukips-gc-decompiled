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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponAwakenReqOuterClass.class */
public final class WeaponAwakenReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015WeaponAwakenReq.proto\"¯\u0001\n\u000fWeaponAwakenReq\u0012:\n\raffixLevelMap\u0018\f \u0003(\u000b2#.WeaponAwakenReq.AffixLevelMapEntry\u0012\u0010\n\bitemGuid\u0018\u0002 \u0001(\u0004\u0012\u0018\n\u0010targetWeaponGuid\u0018\t \u0001(\u0004\u001a4\n\u0012AffixLevelMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_WeaponAwakenReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WeaponAwakenReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WeaponAwakenReq_descriptor, new String[]{"AffixLevelMap", "ItemGuid", "TargetWeaponGuid"});
    private static final Descriptors.Descriptor internal_static_WeaponAwakenReq_AffixLevelMapEntry_descriptor = internal_static_WeaponAwakenReq_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_WeaponAwakenReq_AffixLevelMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f903xb038e5ed = new GeneratedMessageV3.FieldAccessorTable(internal_static_WeaponAwakenReq_AffixLevelMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponAwakenReqOuterClass$WeaponAwakenReqOrBuilder.class */
    public interface WeaponAwakenReqOrBuilder extends MessageOrBuilder {
        int getAffixLevelMapCount();

        boolean containsAffixLevelMap(int i);

        @Deprecated
        Map<Integer, Integer> getAffixLevelMap();

        Map<Integer, Integer> getAffixLevelMapMap();

        int getAffixLevelMapOrDefault(int i, int i2);

        int getAffixLevelMapOrThrow(int i);

        long getItemGuid();

        long getTargetWeaponGuid();
    }

    private WeaponAwakenReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponAwakenReqOuterClass$WeaponAwakenReq.class */
    public static final class WeaponAwakenReq extends GeneratedMessageV3 implements WeaponAwakenReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AFFIXLEVELMAP_FIELD_NUMBER = 12;
        private MapField<Integer, Integer> affixLevelMap_;
        public static final int ITEMGUID_FIELD_NUMBER = 2;
        private long itemGuid_;
        public static final int TARGETWEAPONGUID_FIELD_NUMBER = 9;
        private long targetWeaponGuid_;
        private byte memoizedIsInitialized;
        private static final WeaponAwakenReq DEFAULT_INSTANCE = new WeaponAwakenReq();
        private static final Parser<WeaponAwakenReq> PARSER = new AbstractParser<WeaponAwakenReq>() { // from class: emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReq.1
            @Override // com.google.protobuf.Parser
            public WeaponAwakenReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WeaponAwakenReq(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReq.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 12: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetAffixLevelMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReq.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private WeaponAwakenReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WeaponAwakenReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WeaponAwakenReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WeaponAwakenReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                this.itemGuid_ = input.readUInt64();
                                break;
                            case 72:
                                this.targetWeaponGuid_ = input.readUInt64();
                                break;
                            case 98:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.affixLevelMap_ = MapField.newMapField(AffixLevelMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, Integer> affixLevelMap__ = (MapEntry) input.readMessage(AffixLevelMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.affixLevelMap_.getMutableMap().put(affixLevelMap__.getKey(), affixLevelMap__.getValue());
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
            return WeaponAwakenReqOuterClass.internal_static_WeaponAwakenReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WeaponAwakenReqOuterClass.internal_static_WeaponAwakenReq_fieldAccessorTable.ensureFieldAccessorsInitialized(WeaponAwakenReq.class, Builder.class);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponAwakenReqOuterClass$WeaponAwakenReq$AffixLevelMapDefaultEntryHolder.class */
        public static final class AffixLevelMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(WeaponAwakenReqOuterClass.internal_static_WeaponAwakenReq_AffixLevelMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private AffixLevelMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetAffixLevelMap() {
            if (this.affixLevelMap_ == null) {
                return MapField.emptyMapField(AffixLevelMapDefaultEntryHolder.defaultEntry);
            }
            return this.affixLevelMap_;
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReqOrBuilder
        public int getAffixLevelMapCount() {
            return internalGetAffixLevelMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReqOrBuilder
        public boolean containsAffixLevelMap(int key) {
            return internalGetAffixLevelMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReqOrBuilder
        @Deprecated
        public Map<Integer, Integer> getAffixLevelMap() {
            return getAffixLevelMapMap();
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReqOrBuilder
        public Map<Integer, Integer> getAffixLevelMapMap() {
            return internalGetAffixLevelMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReqOrBuilder
        public int getAffixLevelMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetAffixLevelMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReqOrBuilder
        public int getAffixLevelMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetAffixLevelMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReqOrBuilder
        public long getItemGuid() {
            return this.itemGuid_;
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReqOrBuilder
        public long getTargetWeaponGuid() {
            return this.targetWeaponGuid_;
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
            if (this.itemGuid_ != 0) {
                output.writeUInt64(2, this.itemGuid_);
            }
            if (this.targetWeaponGuid_ != 0) {
                output.writeUInt64(9, this.targetWeaponGuid_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetAffixLevelMap(), AffixLevelMapDefaultEntryHolder.defaultEntry, 12);
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.itemGuid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(2, this.itemGuid_);
            }
            if (this.targetWeaponGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(9, this.targetWeaponGuid_);
            }
            for (Map.Entry<Integer, Integer> entry : internalGetAffixLevelMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(12, AffixLevelMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
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
            if (!(obj instanceof WeaponAwakenReq)) {
                return equals(obj);
            }
            WeaponAwakenReq other = (WeaponAwakenReq) obj;
            return internalGetAffixLevelMap().equals(other.internalGetAffixLevelMap()) && getItemGuid() == other.getItemGuid() && getTargetWeaponGuid() == other.getTargetWeaponGuid() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (!internalGetAffixLevelMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 12)) + internalGetAffixLevelMap().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 2)) + Internal.hashLong(getItemGuid()))) + 9)) + Internal.hashLong(getTargetWeaponGuid()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WeaponAwakenReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WeaponAwakenReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WeaponAwakenReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WeaponAwakenReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WeaponAwakenReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WeaponAwakenReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WeaponAwakenReq parseFrom(InputStream input) throws IOException {
            return (WeaponAwakenReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WeaponAwakenReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WeaponAwakenReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WeaponAwakenReq parseDelimitedFrom(InputStream input) throws IOException {
            return (WeaponAwakenReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WeaponAwakenReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WeaponAwakenReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WeaponAwakenReq parseFrom(CodedInputStream input) throws IOException {
            return (WeaponAwakenReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WeaponAwakenReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WeaponAwakenReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WeaponAwakenReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponAwakenReqOuterClass$WeaponAwakenReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WeaponAwakenReqOrBuilder {
            private int bitField0_;
            private MapField<Integer, Integer> affixLevelMap_;
            private long itemGuid_;
            private long targetWeaponGuid_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReq.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 12: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetAffixLevelMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReq.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReq.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 12: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableAffixLevelMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReq.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return WeaponAwakenReqOuterClass.internal_static_WeaponAwakenReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WeaponAwakenReqOuterClass.internal_static_WeaponAwakenReq_fieldAccessorTable.ensureFieldAccessorsInitialized(WeaponAwakenReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WeaponAwakenReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                internalGetMutableAffixLevelMap().clear();
                this.itemGuid_ = 0;
                this.targetWeaponGuid_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WeaponAwakenReqOuterClass.internal_static_WeaponAwakenReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WeaponAwakenReq getDefaultInstanceForType() {
                return WeaponAwakenReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WeaponAwakenReq build() {
                WeaponAwakenReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WeaponAwakenReq buildPartial() {
                WeaponAwakenReq result = new WeaponAwakenReq(this);
                int i = this.bitField0_;
                result.affixLevelMap_ = internalGetAffixLevelMap();
                result.affixLevelMap_.makeImmutable();
                result.itemGuid_ = this.itemGuid_;
                result.targetWeaponGuid_ = this.targetWeaponGuid_;
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
                if (other instanceof WeaponAwakenReq) {
                    return mergeFrom((WeaponAwakenReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WeaponAwakenReq other) {
                if (other == WeaponAwakenReq.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableAffixLevelMap().mergeFrom(other.internalGetAffixLevelMap());
                if (other.getItemGuid() != 0) {
                    setItemGuid(other.getItemGuid());
                }
                if (other.getTargetWeaponGuid() != 0) {
                    setTargetWeaponGuid(other.getTargetWeaponGuid());
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
                WeaponAwakenReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = WeaponAwakenReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WeaponAwakenReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private MapField<Integer, Integer> internalGetAffixLevelMap() {
                if (this.affixLevelMap_ == null) {
                    return MapField.emptyMapField(AffixLevelMapDefaultEntryHolder.defaultEntry);
                }
                return this.affixLevelMap_;
            }

            private MapField<Integer, Integer> internalGetMutableAffixLevelMap() {
                onChanged();
                if (this.affixLevelMap_ == null) {
                    this.affixLevelMap_ = MapField.newMapField(AffixLevelMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.affixLevelMap_.isMutable()) {
                    this.affixLevelMap_ = this.affixLevelMap_.copy();
                }
                return this.affixLevelMap_;
            }

            @Override // emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReqOrBuilder
            public int getAffixLevelMapCount() {
                return internalGetAffixLevelMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReqOrBuilder
            public boolean containsAffixLevelMap(int key) {
                return internalGetAffixLevelMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReqOrBuilder
            @Deprecated
            public Map<Integer, Integer> getAffixLevelMap() {
                return getAffixLevelMapMap();
            }

            @Override // emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReqOrBuilder
            public Map<Integer, Integer> getAffixLevelMapMap() {
                return internalGetAffixLevelMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReqOrBuilder
            public int getAffixLevelMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetAffixLevelMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReqOrBuilder
            public int getAffixLevelMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetAffixLevelMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearAffixLevelMap() {
                internalGetMutableAffixLevelMap().getMutableMap().clear();
                return this;
            }

            public Builder removeAffixLevelMap(int key) {
                internalGetMutableAffixLevelMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableAffixLevelMap() {
                return internalGetMutableAffixLevelMap().getMutableMap();
            }

            public Builder putAffixLevelMap(int key, int value) {
                internalGetMutableAffixLevelMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllAffixLevelMap(Map<Integer, Integer> values) {
                internalGetMutableAffixLevelMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReqOrBuilder
            public long getItemGuid() {
                return this.itemGuid_;
            }

            public Builder setItemGuid(long value) {
                this.itemGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemGuid() {
                this.itemGuid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WeaponAwakenReqOuterClass.WeaponAwakenReqOrBuilder
            public long getTargetWeaponGuid() {
                return this.targetWeaponGuid_;
            }

            public Builder setTargetWeaponGuid(long value) {
                this.targetWeaponGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetWeaponGuid() {
                this.targetWeaponGuid_ = 0;
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

        public static WeaponAwakenReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WeaponAwakenReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WeaponAwakenReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WeaponAwakenReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
