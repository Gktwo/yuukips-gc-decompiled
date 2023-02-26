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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import emu.grasscutter.net.proto.ItemGivingTypeOuterClass;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemGivingReqOuterClass.class */
public final class ItemGivingReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013ItemGivingReq.proto\u001a\u0014ItemGivingType.proto\u001a\u000fItemParam.proto\"æ\u0001\n\rItemGivingReq\u0012>\n\u0010itemGuidCountMap\u0018\r \u0003(\u000b2$.ItemGivingReq.ItemGuidCountMapEntry\u0012\u0010\n\bgivingId\u0018\u0007 \u0001(\r\u0012!\n\ritemParamList\u0018\t \u0003(\u000b2\n.ItemParam\u0012'\n\u000eitemGivingType\u0018\b \u0001(\u000e2\u000f.ItemGivingType\u001a7\n\u0015ItemGuidCountMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\u0004\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ItemGivingTypeOuterClass.getDescriptor(), ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ItemGivingReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ItemGivingReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ItemGivingReq_descriptor, new String[]{"ItemGuidCountMap", "GivingId", "ItemParamList", "ItemGivingType"});
    private static final Descriptors.Descriptor internal_static_ItemGivingReq_ItemGuidCountMapEntry_descriptor = internal_static_ItemGivingReq_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_ItemGivingReq_ItemGuidCountMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f753x8550bf4 = new GeneratedMessageV3.FieldAccessorTable(internal_static_ItemGivingReq_ItemGuidCountMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemGivingReqOuterClass$ItemGivingReqOrBuilder.class */
    public interface ItemGivingReqOrBuilder extends MessageOrBuilder {
        int getItemGuidCountMapCount();

        boolean containsItemGuidCountMap(long j);

        @Deprecated
        Map<Long, Integer> getItemGuidCountMap();

        Map<Long, Integer> getItemGuidCountMapMap();

        int getItemGuidCountMapOrDefault(long j, int i);

        int getItemGuidCountMapOrThrow(long j);

        int getGivingId();

        List<ItemParamOuterClass.ItemParam> getItemParamListList();

        ItemParamOuterClass.ItemParam getItemParamList(int i);

        int getItemParamListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemParamListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getItemParamListOrBuilder(int i);

        int getItemGivingTypeValue();

        ItemGivingTypeOuterClass.ItemGivingType getItemGivingType();
    }

    private ItemGivingReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemGivingReqOuterClass$ItemGivingReq.class */
    public static final class ItemGivingReq extends GeneratedMessageV3 implements ItemGivingReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ITEMGUIDCOUNTMAP_FIELD_NUMBER = 13;
        private MapField<Long, Integer> itemGuidCountMap_;
        public static final int GIVINGID_FIELD_NUMBER = 7;
        private int givingId_;
        public static final int ITEMPARAMLIST_FIELD_NUMBER = 9;
        private List<ItemParamOuterClass.ItemParam> itemParamList_;
        public static final int ITEMGIVINGTYPE_FIELD_NUMBER = 8;
        private int itemGivingType_;
        private byte memoizedIsInitialized;
        private static final ItemGivingReq DEFAULT_INSTANCE = new ItemGivingReq();
        private static final Parser<ItemGivingReq> PARSER = new AbstractParser<ItemGivingReq>() { // from class: emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReq.1
            @Override // com.google.protobuf.Parser
            public ItemGivingReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ItemGivingReq(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReq.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 13: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetItemGuidCountMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReq.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private ItemGivingReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ItemGivingReq() {
            this.memoizedIsInitialized = -1;
            this.itemParamList_ = Collections.emptyList();
            this.itemGivingType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ItemGivingReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x00f9 */
        private ItemGivingReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 56:
                                this.givingId_ = input.readUInt32();
                                break;
                            case 64:
                                this.itemGivingType_ = input.readEnum();
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.itemParamList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.itemParamList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                break;
                            case 106:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.itemGuidCountMap_ = MapField.newMapField(ItemGuidCountMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                MapEntry<Long, Integer> itemGuidCountMap__ = (MapEntry) input.readMessage(ItemGuidCountMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.itemGuidCountMap_.getMutableMap().put(itemGuidCountMap__.getKey(), itemGuidCountMap__.getValue());
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                        done = done;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 2) != 0) {
                    this.itemParamList_ = Collections.unmodifiableList(this.itemParamList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ItemGivingReqOuterClass.internal_static_ItemGivingReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ItemGivingReqOuterClass.internal_static_ItemGivingReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemGivingReq.class, Builder.class);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemGivingReqOuterClass$ItemGivingReq$ItemGuidCountMapDefaultEntryHolder.class */
        public static final class ItemGuidCountMapDefaultEntryHolder {
            static final MapEntry<Long, Integer> defaultEntry = MapEntry.newDefaultInstance(ItemGivingReqOuterClass.internal_static_ItemGivingReq_ItemGuidCountMapEntry_descriptor, WireFormat.FieldType.UINT64, 0L, WireFormat.FieldType.UINT32, 0);

            private ItemGuidCountMapDefaultEntryHolder() {
            }
        }

        private MapField<Long, Integer> internalGetItemGuidCountMap() {
            if (this.itemGuidCountMap_ == null) {
                return MapField.emptyMapField(ItemGuidCountMapDefaultEntryHolder.defaultEntry);
            }
            return this.itemGuidCountMap_;
        }

        @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
        public int getItemGuidCountMapCount() {
            return internalGetItemGuidCountMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
        public boolean containsItemGuidCountMap(long key) {
            return internalGetItemGuidCountMap().getMap().containsKey(Long.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
        @Deprecated
        public Map<Long, Integer> getItemGuidCountMap() {
            return getItemGuidCountMapMap();
        }

        @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
        public Map<Long, Integer> getItemGuidCountMapMap() {
            return internalGetItemGuidCountMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
        public int getItemGuidCountMapOrDefault(long key, int defaultValue) {
            Map<Long, Integer> map = internalGetItemGuidCountMap().getMap();
            return map.containsKey(Long.valueOf(key)) ? map.get(Long.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
        public int getItemGuidCountMapOrThrow(long key) {
            Map<Long, Integer> map = internalGetItemGuidCountMap().getMap();
            if (map.containsKey(Long.valueOf(key))) {
                return map.get(Long.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
        public int getGivingId() {
            return this.givingId_;
        }

        @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
        public List<ItemParamOuterClass.ItemParam> getItemParamListList() {
            return this.itemParamList_;
        }

        @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemParamListOrBuilderList() {
            return this.itemParamList_;
        }

        @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
        public int getItemParamListCount() {
            return this.itemParamList_.size();
        }

        @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
        public ItemParamOuterClass.ItemParam getItemParamList(int index) {
            return this.itemParamList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getItemParamListOrBuilder(int index) {
            return this.itemParamList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
        public int getItemGivingTypeValue() {
            return this.itemGivingType_;
        }

        @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
        public ItemGivingTypeOuterClass.ItemGivingType getItemGivingType() {
            ItemGivingTypeOuterClass.ItemGivingType result = ItemGivingTypeOuterClass.ItemGivingType.valueOf(this.itemGivingType_);
            return result == null ? ItemGivingTypeOuterClass.ItemGivingType.UNRECOGNIZED : result;
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
            if (this.givingId_ != 0) {
                output.writeUInt32(7, this.givingId_);
            }
            if (this.itemGivingType_ != ItemGivingTypeOuterClass.ItemGivingType.ITEM_GIVING_TYPE_NONE.getNumber()) {
                output.writeEnum(8, this.itemGivingType_);
            }
            for (int i = 0; i < this.itemParamList_.size(); i++) {
                output.writeMessage(9, this.itemParamList_.get(i));
            }
            GeneratedMessageV3.serializeLongMapTo(output, internalGetItemGuidCountMap(), ItemGuidCountMapDefaultEntryHolder.defaultEntry, 13);
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.givingId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(7, this.givingId_);
            }
            if (this.itemGivingType_ != ItemGivingTypeOuterClass.ItemGivingType.ITEM_GIVING_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(8, this.itemGivingType_);
            }
            for (int i = 0; i < this.itemParamList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(9, this.itemParamList_.get(i));
            }
            for (Map.Entry<Long, Integer> entry : internalGetItemGuidCountMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(13, ItemGuidCountMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
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
            if (!(obj instanceof ItemGivingReq)) {
                return equals(obj);
            }
            ItemGivingReq other = (ItemGivingReq) obj;
            return internalGetItemGuidCountMap().equals(other.internalGetItemGuidCountMap()) && getGivingId() == other.getGivingId() && getItemParamListList().equals(other.getItemParamListList()) && this.itemGivingType_ == other.itemGivingType_ && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (!internalGetItemGuidCountMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 13)) + internalGetItemGuidCountMap().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 7)) + getGivingId();
            if (getItemParamListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 9)) + getItemParamListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 8)) + this.itemGivingType_)) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static ItemGivingReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ItemGivingReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ItemGivingReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ItemGivingReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ItemGivingReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ItemGivingReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ItemGivingReq parseFrom(InputStream input) throws IOException {
            return (ItemGivingReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ItemGivingReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemGivingReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ItemGivingReq parseDelimitedFrom(InputStream input) throws IOException {
            return (ItemGivingReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ItemGivingReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemGivingReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ItemGivingReq parseFrom(CodedInputStream input) throws IOException {
            return (ItemGivingReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ItemGivingReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemGivingReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ItemGivingReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemGivingReqOuterClass$ItemGivingReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ItemGivingReqOrBuilder {
            private int bitField0_;
            private MapField<Long, Integer> itemGuidCountMap_;
            private int givingId_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> itemParamListBuilder_;
            private List<ItemParamOuterClass.ItemParam> itemParamList_ = Collections.emptyList();
            private int itemGivingType_ = 0;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReq.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 13: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetItemGuidCountMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReq.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReq.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 13: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableItemGuidCountMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReq.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ItemGivingReqOuterClass.internal_static_ItemGivingReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ItemGivingReqOuterClass.internal_static_ItemGivingReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemGivingReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ItemGivingReq.alwaysUseFieldBuilders) {
                    getItemParamListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                internalGetMutableItemGuidCountMap().clear();
                this.givingId_ = 0;
                if (this.itemParamListBuilder_ == null) {
                    this.itemParamList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.itemParamListBuilder_.clear();
                }
                this.itemGivingType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ItemGivingReqOuterClass.internal_static_ItemGivingReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ItemGivingReq getDefaultInstanceForType() {
                return ItemGivingReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ItemGivingReq build() {
                ItemGivingReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ItemGivingReq buildPartial() {
                ItemGivingReq result = new ItemGivingReq(this);
                int i = this.bitField0_;
                result.itemGuidCountMap_ = internalGetItemGuidCountMap();
                result.itemGuidCountMap_.makeImmutable();
                result.givingId_ = this.givingId_;
                if (this.itemParamListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.itemParamList_ = Collections.unmodifiableList(this.itemParamList_);
                        this.bitField0_ &= -3;
                    }
                    result.itemParamList_ = this.itemParamList_;
                } else {
                    result.itemParamList_ = this.itemParamListBuilder_.build();
                }
                result.itemGivingType_ = this.itemGivingType_;
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
                if (other instanceof ItemGivingReq) {
                    return mergeFrom((ItemGivingReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ItemGivingReq other) {
                if (other == ItemGivingReq.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableItemGuidCountMap().mergeFrom(other.internalGetItemGuidCountMap());
                if (other.getGivingId() != 0) {
                    setGivingId(other.getGivingId());
                }
                if (this.itemParamListBuilder_ == null) {
                    if (!other.itemParamList_.isEmpty()) {
                        if (this.itemParamList_.isEmpty()) {
                            this.itemParamList_ = other.itemParamList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureItemParamListIsMutable();
                            this.itemParamList_.addAll(other.itemParamList_);
                        }
                        onChanged();
                    }
                } else if (!other.itemParamList_.isEmpty()) {
                    if (this.itemParamListBuilder_.isEmpty()) {
                        this.itemParamListBuilder_.dispose();
                        this.itemParamListBuilder_ = null;
                        this.itemParamList_ = other.itemParamList_;
                        this.bitField0_ &= -3;
                        this.itemParamListBuilder_ = ItemGivingReq.alwaysUseFieldBuilders ? getItemParamListFieldBuilder() : null;
                    } else {
                        this.itemParamListBuilder_.addAllMessages(other.itemParamList_);
                    }
                }
                if (other.itemGivingType_ != 0) {
                    setItemGivingTypeValue(other.getItemGivingTypeValue());
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
                ItemGivingReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = ItemGivingReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ItemGivingReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private MapField<Long, Integer> internalGetItemGuidCountMap() {
                if (this.itemGuidCountMap_ == null) {
                    return MapField.emptyMapField(ItemGuidCountMapDefaultEntryHolder.defaultEntry);
                }
                return this.itemGuidCountMap_;
            }

            private MapField<Long, Integer> internalGetMutableItemGuidCountMap() {
                onChanged();
                if (this.itemGuidCountMap_ == null) {
                    this.itemGuidCountMap_ = MapField.newMapField(ItemGuidCountMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.itemGuidCountMap_.isMutable()) {
                    this.itemGuidCountMap_ = this.itemGuidCountMap_.copy();
                }
                return this.itemGuidCountMap_;
            }

            @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
            public int getItemGuidCountMapCount() {
                return internalGetItemGuidCountMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
            public boolean containsItemGuidCountMap(long key) {
                return internalGetItemGuidCountMap().getMap().containsKey(Long.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
            @Deprecated
            public Map<Long, Integer> getItemGuidCountMap() {
                return getItemGuidCountMapMap();
            }

            @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
            public Map<Long, Integer> getItemGuidCountMapMap() {
                return internalGetItemGuidCountMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
            public int getItemGuidCountMapOrDefault(long key, int defaultValue) {
                Map<Long, Integer> map = internalGetItemGuidCountMap().getMap();
                return map.containsKey(Long.valueOf(key)) ? map.get(Long.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
            public int getItemGuidCountMapOrThrow(long key) {
                Map<Long, Integer> map = internalGetItemGuidCountMap().getMap();
                if (map.containsKey(Long.valueOf(key))) {
                    return map.get(Long.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearItemGuidCountMap() {
                internalGetMutableItemGuidCountMap().getMutableMap().clear();
                return this;
            }

            public Builder removeItemGuidCountMap(long key) {
                internalGetMutableItemGuidCountMap().getMutableMap().remove(Long.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Long, Integer> getMutableItemGuidCountMap() {
                return internalGetMutableItemGuidCountMap().getMutableMap();
            }

            public Builder putItemGuidCountMap(long key, int value) {
                internalGetMutableItemGuidCountMap().getMutableMap().put(Long.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllItemGuidCountMap(Map<Long, Integer> values) {
                internalGetMutableItemGuidCountMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
            public int getGivingId() {
                return this.givingId_;
            }

            public Builder setGivingId(int value) {
                this.givingId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGivingId() {
                this.givingId_ = 0;
                onChanged();
                return this;
            }

            private void ensureItemParamListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.itemParamList_ = new ArrayList(this.itemParamList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
            public List<ItemParamOuterClass.ItemParam> getItemParamListList() {
                if (this.itemParamListBuilder_ == null) {
                    return Collections.unmodifiableList(this.itemParamList_);
                }
                return this.itemParamListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
            public int getItemParamListCount() {
                if (this.itemParamListBuilder_ == null) {
                    return this.itemParamList_.size();
                }
                return this.itemParamListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
            public ItemParamOuterClass.ItemParam getItemParamList(int index) {
                if (this.itemParamListBuilder_ == null) {
                    return this.itemParamList_.get(index);
                }
                return this.itemParamListBuilder_.getMessage(index);
            }

            public Builder setItemParamList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.itemParamListBuilder_ != null) {
                    this.itemParamListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemParamListIsMutable();
                    this.itemParamList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setItemParamList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemParamListBuilder_ == null) {
                    ensureItemParamListIsMutable();
                    this.itemParamList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemParamListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addItemParamList(ItemParamOuterClass.ItemParam value) {
                if (this.itemParamListBuilder_ != null) {
                    this.itemParamListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemParamListIsMutable();
                    this.itemParamList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addItemParamList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.itemParamListBuilder_ != null) {
                    this.itemParamListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemParamListIsMutable();
                    this.itemParamList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addItemParamList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemParamListBuilder_ == null) {
                    ensureItemParamListIsMutable();
                    this.itemParamList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemParamListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addItemParamList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemParamListBuilder_ == null) {
                    ensureItemParamListIsMutable();
                    this.itemParamList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemParamListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllItemParamList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.itemParamListBuilder_ == null) {
                    ensureItemParamListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.itemParamList_);
                    onChanged();
                } else {
                    this.itemParamListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearItemParamList() {
                if (this.itemParamListBuilder_ == null) {
                    this.itemParamList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.itemParamListBuilder_.clear();
                }
                return this;
            }

            public Builder removeItemParamList(int index) {
                if (this.itemParamListBuilder_ == null) {
                    ensureItemParamListIsMutable();
                    this.itemParamList_.remove(index);
                    onChanged();
                } else {
                    this.itemParamListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getItemParamListBuilder(int index) {
                return getItemParamListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getItemParamListOrBuilder(int index) {
                if (this.itemParamListBuilder_ == null) {
                    return this.itemParamList_.get(index);
                }
                return this.itemParamListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemParamListOrBuilderList() {
                if (this.itemParamListBuilder_ != null) {
                    return this.itemParamListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.itemParamList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addItemParamListBuilder() {
                return getItemParamListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addItemParamListBuilder(int index) {
                return getItemParamListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getItemParamListBuilderList() {
                return getItemParamListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getItemParamListFieldBuilder() {
                if (this.itemParamListBuilder_ == null) {
                    this.itemParamListBuilder_ = new RepeatedFieldBuilderV3<>(this.itemParamList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.itemParamList_ = null;
                }
                return this.itemParamListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
            public int getItemGivingTypeValue() {
                return this.itemGivingType_;
            }

            public Builder setItemGivingTypeValue(int value) {
                this.itemGivingType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ItemGivingReqOuterClass.ItemGivingReqOrBuilder
            public ItemGivingTypeOuterClass.ItemGivingType getItemGivingType() {
                ItemGivingTypeOuterClass.ItemGivingType result = ItemGivingTypeOuterClass.ItemGivingType.valueOf(this.itemGivingType_);
                return result == null ? ItemGivingTypeOuterClass.ItemGivingType.UNRECOGNIZED : result;
            }

            public Builder setItemGivingType(ItemGivingTypeOuterClass.ItemGivingType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.itemGivingType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearItemGivingType() {
                this.itemGivingType_ = 0;
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

        public static ItemGivingReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ItemGivingReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ItemGivingReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ItemGivingReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ItemGivingTypeOuterClass.getDescriptor();
        ItemParamOuterClass.getDescriptor();
    }
}
