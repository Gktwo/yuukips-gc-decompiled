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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WaterSpiritInfoOuterClass.class */
public final class WaterSpiritInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015WaterSpiritInfo.proto\"­\u0001\n\u000fWaterSpiritInfo\u0012\u0010\n\bmpPlayId\u0018\r \u0001(\r\u0012:\n\rsearchTimeMap\u0018\u0003 \u0003(\u000b2#.WaterSpiritInfo.SearchTimeMapEntry\u0012\u0016\n\u000eregionSearchId\u0018\u0004 \u0001(\r\u001a4\n\u0012SearchTimeMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_WaterSpiritInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WaterSpiritInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WaterSpiritInfo_descriptor, new String[]{"MpPlayId", "SearchTimeMap", "RegionSearchId"});
    private static final Descriptors.Descriptor internal_static_WaterSpiritInfo_SearchTimeMapEntry_descriptor = internal_static_WaterSpiritInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_WaterSpiritInfo_SearchTimeMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f902x1c3c79a9 = new GeneratedMessageV3.FieldAccessorTable(internal_static_WaterSpiritInfo_SearchTimeMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WaterSpiritInfoOuterClass$WaterSpiritInfoOrBuilder.class */
    public interface WaterSpiritInfoOrBuilder extends MessageOrBuilder {
        int getMpPlayId();

        int getSearchTimeMapCount();

        boolean containsSearchTimeMap(int i);

        @Deprecated
        Map<Integer, Integer> getSearchTimeMap();

        Map<Integer, Integer> getSearchTimeMapMap();

        int getSearchTimeMapOrDefault(int i, int i2);

        int getSearchTimeMapOrThrow(int i);

        int getRegionSearchId();
    }

    private WaterSpiritInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WaterSpiritInfoOuterClass$WaterSpiritInfo.class */
    public static final class WaterSpiritInfo extends GeneratedMessageV3 implements WaterSpiritInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MPPLAYID_FIELD_NUMBER = 13;
        private int mpPlayId_;
        public static final int SEARCHTIMEMAP_FIELD_NUMBER = 3;
        private MapField<Integer, Integer> searchTimeMap_;
        public static final int REGIONSEARCHID_FIELD_NUMBER = 4;
        private int regionSearchId_;
        private byte memoizedIsInitialized;
        private static final WaterSpiritInfo DEFAULT_INSTANCE = new WaterSpiritInfo();
        private static final Parser<WaterSpiritInfo> PARSER = new AbstractParser<WaterSpiritInfo>() { // from class: emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfo.1
            @Override // com.google.protobuf.Parser
            public WaterSpiritInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WaterSpiritInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 3: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetSearchTimeMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private WaterSpiritInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WaterSpiritInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WaterSpiritInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WaterSpiritInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 26:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.searchTimeMap_ = MapField.newMapField(SearchTimeMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, Integer> searchTimeMap__ = (MapEntry) input.readMessage(SearchTimeMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.searchTimeMap_.getMutableMap().put(searchTimeMap__.getKey(), searchTimeMap__.getValue());
                                break;
                            case 32:
                                this.regionSearchId_ = input.readUInt32();
                                break;
                            case 104:
                                this.mpPlayId_ = input.readUInt32();
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
            return WaterSpiritInfoOuterClass.internal_static_WaterSpiritInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WaterSpiritInfoOuterClass.internal_static_WaterSpiritInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WaterSpiritInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfoOrBuilder
        public int getMpPlayId() {
            return this.mpPlayId_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WaterSpiritInfoOuterClass$WaterSpiritInfo$SearchTimeMapDefaultEntryHolder.class */
        public static final class SearchTimeMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(WaterSpiritInfoOuterClass.internal_static_WaterSpiritInfo_SearchTimeMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private SearchTimeMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetSearchTimeMap() {
            if (this.searchTimeMap_ == null) {
                return MapField.emptyMapField(SearchTimeMapDefaultEntryHolder.defaultEntry);
            }
            return this.searchTimeMap_;
        }

        @Override // emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfoOrBuilder
        public int getSearchTimeMapCount() {
            return internalGetSearchTimeMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfoOrBuilder
        public boolean containsSearchTimeMap(int key) {
            return internalGetSearchTimeMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getSearchTimeMap() {
            return getSearchTimeMapMap();
        }

        @Override // emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfoOrBuilder
        public Map<Integer, Integer> getSearchTimeMapMap() {
            return internalGetSearchTimeMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfoOrBuilder
        public int getSearchTimeMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetSearchTimeMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfoOrBuilder
        public int getSearchTimeMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetSearchTimeMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfoOrBuilder
        public int getRegionSearchId() {
            return this.regionSearchId_;
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
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetSearchTimeMap(), SearchTimeMapDefaultEntryHolder.defaultEntry, 3);
            if (this.regionSearchId_ != 0) {
                output.writeUInt32(4, this.regionSearchId_);
            }
            if (this.mpPlayId_ != 0) {
                output.writeUInt32(13, this.mpPlayId_);
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
            for (Map.Entry<Integer, Integer> entry : internalGetSearchTimeMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(3, SearchTimeMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.regionSearchId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.regionSearchId_);
            }
            if (this.mpPlayId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.mpPlayId_);
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
            if (!(obj instanceof WaterSpiritInfo)) {
                return equals(obj);
            }
            WaterSpiritInfo other = (WaterSpiritInfo) obj;
            return getMpPlayId() == other.getMpPlayId() && internalGetSearchTimeMap().equals(other.internalGetSearchTimeMap()) && getRegionSearchId() == other.getRegionSearchId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + getMpPlayId();
            if (!internalGetSearchTimeMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 3)) + internalGetSearchTimeMap().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 4)) + getRegionSearchId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WaterSpiritInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WaterSpiritInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WaterSpiritInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WaterSpiritInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WaterSpiritInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WaterSpiritInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WaterSpiritInfo parseFrom(InputStream input) throws IOException {
            return (WaterSpiritInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WaterSpiritInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WaterSpiritInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WaterSpiritInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (WaterSpiritInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WaterSpiritInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WaterSpiritInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WaterSpiritInfo parseFrom(CodedInputStream input) throws IOException {
            return (WaterSpiritInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WaterSpiritInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WaterSpiritInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WaterSpiritInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WaterSpiritInfoOuterClass$WaterSpiritInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WaterSpiritInfoOrBuilder {
            private int bitField0_;
            private int mpPlayId_;
            private MapField<Integer, Integer> searchTimeMap_;
            private int regionSearchId_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 3: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetSearchTimeMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 3: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableSearchTimeMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return WaterSpiritInfoOuterClass.internal_static_WaterSpiritInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WaterSpiritInfoOuterClass.internal_static_WaterSpiritInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WaterSpiritInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WaterSpiritInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.mpPlayId_ = 0;
                internalGetMutableSearchTimeMap().clear();
                this.regionSearchId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WaterSpiritInfoOuterClass.internal_static_WaterSpiritInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WaterSpiritInfo getDefaultInstanceForType() {
                return WaterSpiritInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WaterSpiritInfo build() {
                WaterSpiritInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WaterSpiritInfo buildPartial() {
                WaterSpiritInfo result = new WaterSpiritInfo(this);
                int i = this.bitField0_;
                result.mpPlayId_ = this.mpPlayId_;
                result.searchTimeMap_ = internalGetSearchTimeMap();
                result.searchTimeMap_.makeImmutable();
                result.regionSearchId_ = this.regionSearchId_;
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
                if (other instanceof WaterSpiritInfo) {
                    return mergeFrom((WaterSpiritInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WaterSpiritInfo other) {
                if (other == WaterSpiritInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getMpPlayId() != 0) {
                    setMpPlayId(other.getMpPlayId());
                }
                internalGetMutableSearchTimeMap().mergeFrom(other.internalGetSearchTimeMap());
                if (other.getRegionSearchId() != 0) {
                    setRegionSearchId(other.getRegionSearchId());
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
                WaterSpiritInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = WaterSpiritInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WaterSpiritInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfoOrBuilder
            public int getMpPlayId() {
                return this.mpPlayId_;
            }

            public Builder setMpPlayId(int value) {
                this.mpPlayId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMpPlayId() {
                this.mpPlayId_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetSearchTimeMap() {
                if (this.searchTimeMap_ == null) {
                    return MapField.emptyMapField(SearchTimeMapDefaultEntryHolder.defaultEntry);
                }
                return this.searchTimeMap_;
            }

            private MapField<Integer, Integer> internalGetMutableSearchTimeMap() {
                onChanged();
                if (this.searchTimeMap_ == null) {
                    this.searchTimeMap_ = MapField.newMapField(SearchTimeMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.searchTimeMap_.isMutable()) {
                    this.searchTimeMap_ = this.searchTimeMap_.copy();
                }
                return this.searchTimeMap_;
            }

            @Override // emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfoOrBuilder
            public int getSearchTimeMapCount() {
                return internalGetSearchTimeMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfoOrBuilder
            public boolean containsSearchTimeMap(int key) {
                return internalGetSearchTimeMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getSearchTimeMap() {
                return getSearchTimeMapMap();
            }

            @Override // emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfoOrBuilder
            public Map<Integer, Integer> getSearchTimeMapMap() {
                return internalGetSearchTimeMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfoOrBuilder
            public int getSearchTimeMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetSearchTimeMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfoOrBuilder
            public int getSearchTimeMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetSearchTimeMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearSearchTimeMap() {
                internalGetMutableSearchTimeMap().getMutableMap().clear();
                return this;
            }

            public Builder removeSearchTimeMap(int key) {
                internalGetMutableSearchTimeMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableSearchTimeMap() {
                return internalGetMutableSearchTimeMap().getMutableMap();
            }

            public Builder putSearchTimeMap(int key, int value) {
                internalGetMutableSearchTimeMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllSearchTimeMap(Map<Integer, Integer> values) {
                internalGetMutableSearchTimeMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.WaterSpiritInfoOuterClass.WaterSpiritInfoOrBuilder
            public int getRegionSearchId() {
                return this.regionSearchId_;
            }

            public Builder setRegionSearchId(int value) {
                this.regionSearchId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRegionSearchId() {
                this.regionSearchId_ = 0;
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

        public static WaterSpiritInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WaterSpiritInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WaterSpiritInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WaterSpiritInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
