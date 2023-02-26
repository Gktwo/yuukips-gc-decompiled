package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
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
import emu.grasscutter.net.proto.ForgeQueueDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeQueueDataNotifyOuterClass.class */
public final class ForgeQueueDataNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aForgeQueueDataNotify.proto\u001a\u0014ForgeQueueData.proto\"½\u0001\n\u0014ForgeQueueDataNotify\u0012\u001d\n\u0015removedForgeQueueList\u0018\n \u0003(\r\u0012?\n\rforgeQueueMap\u0018\u000e \u0003(\u000b2(.ForgeQueueDataNotify.ForgeQueueMapEntry\u001aE\n\u0012ForgeQueueMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\u001e\n\u0005value\u0018\u0002 \u0001(\u000b2\u000f.ForgeQueueData:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ForgeQueueDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ForgeQueueDataNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ForgeQueueDataNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ForgeQueueDataNotify_descriptor, new String[]{"RemovedForgeQueueList", "ForgeQueueMap"});

    /* renamed from: internal_static_ForgeQueueDataNotify_ForgeQueueMapEntry_descriptor */
    private static final Descriptors.Descriptor f714xf8a1bf5b = internal_static_ForgeQueueDataNotify_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_ForgeQueueDataNotify_ForgeQueueMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f715xae355ad9 = new GeneratedMessageV3.FieldAccessorTable(f714xf8a1bf5b, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeQueueDataNotifyOuterClass$ForgeQueueDataNotifyOrBuilder.class */
    public interface ForgeQueueDataNotifyOrBuilder extends MessageOrBuilder {
        List<Integer> getRemovedForgeQueueListList();

        int getRemovedForgeQueueListCount();

        int getRemovedForgeQueueList(int i);

        int getForgeQueueMapCount();

        boolean containsForgeQueueMap(int i);

        @Deprecated
        Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> getForgeQueueMap();

        Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> getForgeQueueMapMap();

        ForgeQueueDataOuterClass.ForgeQueueData getForgeQueueMapOrDefault(int i, ForgeQueueDataOuterClass.ForgeQueueData forgeQueueData);

        ForgeQueueDataOuterClass.ForgeQueueData getForgeQueueMapOrThrow(int i);
    }

    private ForgeQueueDataNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeQueueDataNotifyOuterClass$ForgeQueueDataNotify.class */
    public static final class ForgeQueueDataNotify extends GeneratedMessageV3 implements ForgeQueueDataNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int REMOVEDFORGEQUEUELIST_FIELD_NUMBER = 10;
        private Internal.IntList removedForgeQueueList_;
        private int removedForgeQueueListMemoizedSerializedSize;
        public static final int FORGEQUEUEMAP_FIELD_NUMBER = 14;
        private MapField<Integer, ForgeQueueDataOuterClass.ForgeQueueData> forgeQueueMap_;
        private byte memoizedIsInitialized;
        private static final ForgeQueueDataNotify DEFAULT_INSTANCE = new ForgeQueueDataNotify();
        private static final Parser<ForgeQueueDataNotify> PARSER = new AbstractParser<ForgeQueueDataNotify>() { // from class: emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotify.1
            @Override // com.google.protobuf.Parser
            public ForgeQueueDataNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ForgeQueueDataNotify(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotify.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 14: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetForgeQueueMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotify.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private ForgeQueueDataNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.removedForgeQueueListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ForgeQueueDataNotify() {
            this.removedForgeQueueListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.removedForgeQueueList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ForgeQueueDataNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ForgeQueueDataNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_;
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                mutable_bitField0_ = 0;
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 80:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.removedForgeQueueList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.removedForgeQueueList_.addInt(input.readUInt32());
                                break;
                            case 82:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.removedForgeQueueList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.removedForgeQueueList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 114:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.forgeQueueMap_ = MapField.newMapField(ForgeQueueMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 2;
                                }
                                MapEntry<Integer, ForgeQueueDataOuterClass.ForgeQueueData> forgeQueueMap__ = (MapEntry) input.readMessage(ForgeQueueMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.forgeQueueMap_.getMutableMap().put(forgeQueueMap__.getKey(), forgeQueueMap__.getValue());
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.removedForgeQueueList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ForgeQueueDataNotifyOuterClass.internal_static_ForgeQueueDataNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ForgeQueueDataNotifyOuterClass.internal_static_ForgeQueueDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ForgeQueueDataNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotifyOrBuilder
        public List<Integer> getRemovedForgeQueueListList() {
            return this.removedForgeQueueList_;
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotifyOrBuilder
        public int getRemovedForgeQueueListCount() {
            return this.removedForgeQueueList_.size();
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotifyOrBuilder
        public int getRemovedForgeQueueList(int index) {
            return this.removedForgeQueueList_.getInt(index);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeQueueDataNotifyOuterClass$ForgeQueueDataNotify$ForgeQueueMapDefaultEntryHolder.class */
        public static final class ForgeQueueMapDefaultEntryHolder {
            static final MapEntry<Integer, ForgeQueueDataOuterClass.ForgeQueueData> defaultEntry = MapEntry.newDefaultInstance(ForgeQueueDataNotifyOuterClass.f714xf8a1bf5b, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, ForgeQueueDataOuterClass.ForgeQueueData.getDefaultInstance());

            private ForgeQueueMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, ForgeQueueDataOuterClass.ForgeQueueData> internalGetForgeQueueMap() {
            if (this.forgeQueueMap_ == null) {
                return MapField.emptyMapField(ForgeQueueMapDefaultEntryHolder.defaultEntry);
            }
            return this.forgeQueueMap_;
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotifyOrBuilder
        public int getForgeQueueMapCount() {
            return internalGetForgeQueueMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotifyOrBuilder
        public boolean containsForgeQueueMap(int key) {
            return internalGetForgeQueueMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotifyOrBuilder
        @Deprecated
        public Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> getForgeQueueMap() {
            return getForgeQueueMapMap();
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotifyOrBuilder
        public Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> getForgeQueueMapMap() {
            return internalGetForgeQueueMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotifyOrBuilder
        public ForgeQueueDataOuterClass.ForgeQueueData getForgeQueueMapOrDefault(int key, ForgeQueueDataOuterClass.ForgeQueueData defaultValue) {
            Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> map = internalGetForgeQueueMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotifyOrBuilder
        public ForgeQueueDataOuterClass.ForgeQueueData getForgeQueueMapOrThrow(int key) {
            Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> map = internalGetForgeQueueMap().getMap();
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
            getSerializedSize();
            if (getRemovedForgeQueueListList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.removedForgeQueueListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.removedForgeQueueList_.size(); i++) {
                output.writeUInt32NoTag(this.removedForgeQueueList_.getInt(i));
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetForgeQueueMap(), ForgeQueueMapDefaultEntryHolder.defaultEntry, 14);
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.removedForgeQueueList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.removedForgeQueueList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getRemovedForgeQueueListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.removedForgeQueueListMemoizedSerializedSize = dataSize;
            for (Map.Entry<Integer, ForgeQueueDataOuterClass.ForgeQueueData> entry : internalGetForgeQueueMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(14, ForgeQueueMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
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
            if (!(obj instanceof ForgeQueueDataNotify)) {
                return equals(obj);
            }
            ForgeQueueDataNotify other = (ForgeQueueDataNotify) obj;
            return getRemovedForgeQueueListList().equals(other.getRemovedForgeQueueListList()) && internalGetForgeQueueMap().equals(other.internalGetForgeQueueMap()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getRemovedForgeQueueListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getRemovedForgeQueueListList().hashCode();
            }
            if (!internalGetForgeQueueMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 14)) + internalGetForgeQueueMap().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ForgeQueueDataNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForgeQueueDataNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForgeQueueDataNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForgeQueueDataNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForgeQueueDataNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForgeQueueDataNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForgeQueueDataNotify parseFrom(InputStream input) throws IOException {
            return (ForgeQueueDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ForgeQueueDataNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForgeQueueDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ForgeQueueDataNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ForgeQueueDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ForgeQueueDataNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForgeQueueDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ForgeQueueDataNotify parseFrom(CodedInputStream input) throws IOException {
            return (ForgeQueueDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ForgeQueueDataNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForgeQueueDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ForgeQueueDataNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeQueueDataNotifyOuterClass$ForgeQueueDataNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ForgeQueueDataNotifyOrBuilder {
            private int bitField0_;
            private Internal.IntList removedForgeQueueList_ = ForgeQueueDataNotify.emptyIntList();
            private MapField<Integer, ForgeQueueDataOuterClass.ForgeQueueData> forgeQueueMap_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 14: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetForgeQueueMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 14: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableForgeQueueMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ForgeQueueDataNotifyOuterClass.internal_static_ForgeQueueDataNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ForgeQueueDataNotifyOuterClass.internal_static_ForgeQueueDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ForgeQueueDataNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ForgeQueueDataNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.removedForgeQueueList_ = ForgeQueueDataNotify.emptyIntList();
                this.bitField0_ &= -2;
                internalGetMutableForgeQueueMap().clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ForgeQueueDataNotifyOuterClass.internal_static_ForgeQueueDataNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ForgeQueueDataNotify getDefaultInstanceForType() {
                return ForgeQueueDataNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ForgeQueueDataNotify build() {
                ForgeQueueDataNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ForgeQueueDataNotify buildPartial() {
                ForgeQueueDataNotify result = new ForgeQueueDataNotify(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.removedForgeQueueList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.removedForgeQueueList_ = this.removedForgeQueueList_;
                result.forgeQueueMap_ = internalGetForgeQueueMap();
                result.forgeQueueMap_.makeImmutable();
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
                if (other instanceof ForgeQueueDataNotify) {
                    return mergeFrom((ForgeQueueDataNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ForgeQueueDataNotify other) {
                if (other == ForgeQueueDataNotify.getDefaultInstance()) {
                    return this;
                }
                if (!other.removedForgeQueueList_.isEmpty()) {
                    if (this.removedForgeQueueList_.isEmpty()) {
                        this.removedForgeQueueList_ = other.removedForgeQueueList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRemovedForgeQueueListIsMutable();
                        this.removedForgeQueueList_.addAll(other.removedForgeQueueList_);
                    }
                    onChanged();
                }
                internalGetMutableForgeQueueMap().mergeFrom(other.internalGetForgeQueueMap());
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
                ForgeQueueDataNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ForgeQueueDataNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ForgeQueueDataNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureRemovedForgeQueueListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.removedForgeQueueList_ = ForgeQueueDataNotify.mutableCopy(this.removedForgeQueueList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotifyOrBuilder
            public List<Integer> getRemovedForgeQueueListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.removedForgeQueueList_) : this.removedForgeQueueList_;
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotifyOrBuilder
            public int getRemovedForgeQueueListCount() {
                return this.removedForgeQueueList_.size();
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotifyOrBuilder
            public int getRemovedForgeQueueList(int index) {
                return this.removedForgeQueueList_.getInt(index);
            }

            public Builder setRemovedForgeQueueList(int index, int value) {
                ensureRemovedForgeQueueListIsMutable();
                this.removedForgeQueueList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addRemovedForgeQueueList(int value) {
                ensureRemovedForgeQueueListIsMutable();
                this.removedForgeQueueList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllRemovedForgeQueueList(Iterable<? extends Integer> values) {
                ensureRemovedForgeQueueListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.removedForgeQueueList_);
                onChanged();
                return this;
            }

            public Builder clearRemovedForgeQueueList() {
                this.removedForgeQueueList_ = ForgeQueueDataNotify.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private MapField<Integer, ForgeQueueDataOuterClass.ForgeQueueData> internalGetForgeQueueMap() {
                if (this.forgeQueueMap_ == null) {
                    return MapField.emptyMapField(ForgeQueueMapDefaultEntryHolder.defaultEntry);
                }
                return this.forgeQueueMap_;
            }

            private MapField<Integer, ForgeQueueDataOuterClass.ForgeQueueData> internalGetMutableForgeQueueMap() {
                onChanged();
                if (this.forgeQueueMap_ == null) {
                    this.forgeQueueMap_ = MapField.newMapField(ForgeQueueMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.forgeQueueMap_.isMutable()) {
                    this.forgeQueueMap_ = this.forgeQueueMap_.copy();
                }
                return this.forgeQueueMap_;
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotifyOrBuilder
            public int getForgeQueueMapCount() {
                return internalGetForgeQueueMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotifyOrBuilder
            public boolean containsForgeQueueMap(int key) {
                return internalGetForgeQueueMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotifyOrBuilder
            @Deprecated
            public Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> getForgeQueueMap() {
                return getForgeQueueMapMap();
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotifyOrBuilder
            public Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> getForgeQueueMapMap() {
                return internalGetForgeQueueMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotifyOrBuilder
            public ForgeQueueDataOuterClass.ForgeQueueData getForgeQueueMapOrDefault(int key, ForgeQueueDataOuterClass.ForgeQueueData defaultValue) {
                Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> map = internalGetForgeQueueMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueDataNotifyOuterClass.ForgeQueueDataNotifyOrBuilder
            public ForgeQueueDataOuterClass.ForgeQueueData getForgeQueueMapOrThrow(int key) {
                Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> map = internalGetForgeQueueMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearForgeQueueMap() {
                internalGetMutableForgeQueueMap().getMutableMap().clear();
                return this;
            }

            public Builder removeForgeQueueMap(int key) {
                internalGetMutableForgeQueueMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> getMutableForgeQueueMap() {
                return internalGetMutableForgeQueueMap().getMutableMap();
            }

            public Builder putForgeQueueMap(int key, ForgeQueueDataOuterClass.ForgeQueueData value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableForgeQueueMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllForgeQueueMap(Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> values) {
                internalGetMutableForgeQueueMap().getMutableMap().putAll(values);
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

        public static ForgeQueueDataNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ForgeQueueDataNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ForgeQueueDataNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ForgeQueueDataNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ForgeQueueDataOuterClass.getDescriptor();
    }
}
