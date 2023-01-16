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
import emu.grasscutter.net.proto.AvatarExpeditionInfoOuterClass;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionGetRewardRspOuterClass.class */
public final class AvatarExpeditionGetRewardRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"AvatarExpeditionGetRewardRsp.proto\u001a\u001aAvatarExpeditionInfo.proto\u001a\u000fItemParam.proto\"\u0002\n\u001cAvatarExpeditionGetRewardRsp\u0012\u001d\n\titem_list\u0018\u0007 \u0003(\u000b2\n.ItemParam\u0012#\n\u000fextra_item_list\u0018\u000b \u0003(\u000b2\n.ItemParam\u0012Q\n\u0013expedition_info_map\u0018\r \u0003(\u000b24.AvatarExpeditionGetRewardRsp.ExpeditionInfoMapEntry\u0012\u000f\n\u0007retcode\u0018\b \u0001(\u0005\u001aO\n\u0016ExpeditionInfoMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\u0004\u0012$\n\u0005value\u0018\u0002 \u0001(\u000b2\u0015.AvatarExpeditionInfo:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AvatarExpeditionInfoOuterClass.getDescriptor(), ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AvatarExpeditionGetRewardRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarExpeditionGetRewardRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarExpeditionGetRewardRsp_descriptor, new String[]{"ItemList", "ExtraItemList", "ExpeditionInfoMap", "Retcode"});

    /* renamed from: internal_static_AvatarExpeditionGetRewardRsp_ExpeditionInfoMapEntry_descriptor */
    private static final Descriptors.Descriptor f633x9920f1bd = internal_static_AvatarExpeditionGetRewardRsp_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_AvatarExpeditionGetRewardRsp_ExpeditionInfoMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f634x7f950b3b = new GeneratedMessageV3.FieldAccessorTable(f633x9920f1bd, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionGetRewardRspOuterClass$AvatarExpeditionGetRewardRspOrBuilder.class */
    public interface AvatarExpeditionGetRewardRspOrBuilder extends MessageOrBuilder {
        List<ItemParamOuterClass.ItemParam> getItemListList();

        ItemParamOuterClass.ItemParam getItemList(int i);

        int getItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getItemListOrBuilder(int i);

        List<ItemParamOuterClass.ItemParam> getExtraItemListList();

        ItemParamOuterClass.ItemParam getExtraItemList(int i);

        int getExtraItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getExtraItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getExtraItemListOrBuilder(int i);

        int getExpeditionInfoMapCount();

        boolean containsExpeditionInfoMap(long j);

        @Deprecated
        Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMap();

        Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMapMap();

        AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo getExpeditionInfoMapOrDefault(long j, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo avatarExpeditionInfo);

        AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo getExpeditionInfoMapOrThrow(long j);

        int getRetcode();
    }

    private AvatarExpeditionGetRewardRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionGetRewardRspOuterClass$AvatarExpeditionGetRewardRsp.class */
    public static final class AvatarExpeditionGetRewardRsp extends GeneratedMessageV3 implements AvatarExpeditionGetRewardRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ITEM_LIST_FIELD_NUMBER = 7;
        private List<ItemParamOuterClass.ItemParam> itemList_;
        public static final int EXTRA_ITEM_LIST_FIELD_NUMBER = 11;
        private List<ItemParamOuterClass.ItemParam> extraItemList_;
        public static final int EXPEDITION_INFO_MAP_FIELD_NUMBER = 13;
        private MapField<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> expeditionInfoMap_;
        public static final int RETCODE_FIELD_NUMBER = 8;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final AvatarExpeditionGetRewardRsp DEFAULT_INSTANCE = new AvatarExpeditionGetRewardRsp();
        private static final Parser<AvatarExpeditionGetRewardRsp> PARSER = new AbstractParser<AvatarExpeditionGetRewardRsp>() { // from class: emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRsp.1
            @Override // com.google.protobuf.Parser
            public AvatarExpeditionGetRewardRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarExpeditionGetRewardRsp(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRsp.internalGetMapField(int):com.google.protobuf.MapField
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
                com.google.protobuf.MapField r0 = r0.internalGetExpeditionInfoMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRsp.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private AvatarExpeditionGetRewardRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarExpeditionGetRewardRsp() {
            this.memoizedIsInitialized = -1;
            this.itemList_ = Collections.emptyList();
            this.extraItemList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarExpeditionGetRewardRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:65:0x0117 */
        private AvatarExpeditionGetRewardRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 58:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.itemList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.itemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                break;
                            case 64:
                                this.retcode_ = input.readInt32();
                                break;
                            case 90:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.extraItemList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.extraItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                break;
                            case 106:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.expeditionInfoMap_ = MapField.newMapField(ExpeditionInfoMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                MapEntry<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> expeditionInfoMap__ = (MapEntry) input.readMessage(ExpeditionInfoMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.expeditionInfoMap_.getMutableMap().put(expeditionInfoMap__.getKey(), expeditionInfoMap__.getValue());
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.itemList_ = Collections.unmodifiableList(this.itemList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.extraItemList_ = Collections.unmodifiableList(this.extraItemList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvatarExpeditionGetRewardRspOuterClass.internal_static_AvatarExpeditionGetRewardRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarExpeditionGetRewardRspOuterClass.internal_static_AvatarExpeditionGetRewardRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarExpeditionGetRewardRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
        public List<ItemParamOuterClass.ItemParam> getItemListList() {
            return this.itemList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemListOrBuilderList() {
            return this.itemList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
        public int getItemListCount() {
            return this.itemList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
        public ItemParamOuterClass.ItemParam getItemList(int index) {
            return this.itemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getItemListOrBuilder(int index) {
            return this.itemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
        public List<ItemParamOuterClass.ItemParam> getExtraItemListList() {
            return this.extraItemList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getExtraItemListOrBuilderList() {
            return this.extraItemList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
        public int getExtraItemListCount() {
            return this.extraItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
        public ItemParamOuterClass.ItemParam getExtraItemList(int index) {
            return this.extraItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getExtraItemListOrBuilder(int index) {
            return this.extraItemList_.get(index);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionGetRewardRspOuterClass$AvatarExpeditionGetRewardRsp$ExpeditionInfoMapDefaultEntryHolder.class */
        public static final class ExpeditionInfoMapDefaultEntryHolder {
            static final MapEntry<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> defaultEntry = MapEntry.newDefaultInstance(AvatarExpeditionGetRewardRspOuterClass.f633x9920f1bd, WireFormat.FieldType.UINT64, 0L, WireFormat.FieldType.MESSAGE, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo.getDefaultInstance());

            private ExpeditionInfoMapDefaultEntryHolder() {
            }
        }

        private MapField<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> internalGetExpeditionInfoMap() {
            if (this.expeditionInfoMap_ == null) {
                return MapField.emptyMapField(ExpeditionInfoMapDefaultEntryHolder.defaultEntry);
            }
            return this.expeditionInfoMap_;
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
        public int getExpeditionInfoMapCount() {
            return internalGetExpeditionInfoMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
        public boolean containsExpeditionInfoMap(long key) {
            return internalGetExpeditionInfoMap().getMap().containsKey(Long.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
        @Deprecated
        public Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMap() {
            return getExpeditionInfoMapMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
        public Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMapMap() {
            return internalGetExpeditionInfoMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
        public AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo getExpeditionInfoMapOrDefault(long key, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo defaultValue) {
            Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> map = internalGetExpeditionInfoMap().getMap();
            return map.containsKey(Long.valueOf(key)) ? map.get(Long.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
        public AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo getExpeditionInfoMapOrThrow(long key) {
            Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> map = internalGetExpeditionInfoMap().getMap();
            if (map.containsKey(Long.valueOf(key))) {
                return map.get(Long.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
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
            for (int i = 0; i < this.itemList_.size(); i++) {
                output.writeMessage(7, this.itemList_.get(i));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(8, this.retcode_);
            }
            for (int i2 = 0; i2 < this.extraItemList_.size(); i2++) {
                output.writeMessage(11, this.extraItemList_.get(i2));
            }
            GeneratedMessageV3.serializeLongMapTo(output, internalGetExpeditionInfoMap(), ExpeditionInfoMapDefaultEntryHolder.defaultEntry, 13);
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (int i = 0; i < this.itemList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.itemList_.get(i));
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(8, this.retcode_);
            }
            for (int i2 = 0; i2 < this.extraItemList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.extraItemList_.get(i2));
            }
            for (Map.Entry<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> entry : internalGetExpeditionInfoMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(13, ExpeditionInfoMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
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
            if (!(obj instanceof AvatarExpeditionGetRewardRsp)) {
                return equals(obj);
            }
            AvatarExpeditionGetRewardRsp other = (AvatarExpeditionGetRewardRsp) obj;
            return getItemListList().equals(other.getItemListList()) && getExtraItemListList().equals(other.getExtraItemListList()) && internalGetExpeditionInfoMap().equals(other.internalGetExpeditionInfoMap()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getItemListList().hashCode();
            }
            if (getExtraItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getExtraItemListList().hashCode();
            }
            if (!internalGetExpeditionInfoMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 13)) + internalGetExpeditionInfoMap().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 8)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AvatarExpeditionGetRewardRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarExpeditionGetRewardRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarExpeditionGetRewardRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarExpeditionGetRewardRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarExpeditionGetRewardRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarExpeditionGetRewardRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarExpeditionGetRewardRsp parseFrom(InputStream input) throws IOException {
            return (AvatarExpeditionGetRewardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarExpeditionGetRewardRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarExpeditionGetRewardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarExpeditionGetRewardRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarExpeditionGetRewardRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarExpeditionGetRewardRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarExpeditionGetRewardRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarExpeditionGetRewardRsp parseFrom(CodedInputStream input) throws IOException {
            return (AvatarExpeditionGetRewardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarExpeditionGetRewardRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarExpeditionGetRewardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarExpeditionGetRewardRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionGetRewardRspOuterClass$AvatarExpeditionGetRewardRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarExpeditionGetRewardRspOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> itemListBuilder_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> extraItemListBuilder_;
            private MapField<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> expeditionInfoMap_;
            private int retcode_;
            private List<ItemParamOuterClass.ItemParam> itemList_ = Collections.emptyList();
            private List<ItemParamOuterClass.ItemParam> extraItemList_ = Collections.emptyList();

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRsp.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetExpeditionInfoMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRsp.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRsp.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetMutableExpeditionInfoMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRsp.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarExpeditionGetRewardRspOuterClass.internal_static_AvatarExpeditionGetRewardRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarExpeditionGetRewardRspOuterClass.internal_static_AvatarExpeditionGetRewardRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarExpeditionGetRewardRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarExpeditionGetRewardRsp.alwaysUseFieldBuilders) {
                    getItemListFieldBuilder();
                    getExtraItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.itemListBuilder_.clear();
                }
                if (this.extraItemListBuilder_ == null) {
                    this.extraItemList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.extraItemListBuilder_.clear();
                }
                internalGetMutableExpeditionInfoMap().clear();
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarExpeditionGetRewardRspOuterClass.internal_static_AvatarExpeditionGetRewardRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarExpeditionGetRewardRsp getDefaultInstanceForType() {
                return AvatarExpeditionGetRewardRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarExpeditionGetRewardRsp build() {
                AvatarExpeditionGetRewardRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarExpeditionGetRewardRsp buildPartial() {
                AvatarExpeditionGetRewardRsp result = new AvatarExpeditionGetRewardRsp(this);
                int i = this.bitField0_;
                if (this.itemListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.itemList_ = Collections.unmodifiableList(this.itemList_);
                        this.bitField0_ &= -2;
                    }
                    result.itemList_ = this.itemList_;
                } else {
                    result.itemList_ = this.itemListBuilder_.build();
                }
                if (this.extraItemListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.extraItemList_ = Collections.unmodifiableList(this.extraItemList_);
                        this.bitField0_ &= -3;
                    }
                    result.extraItemList_ = this.extraItemList_;
                } else {
                    result.extraItemList_ = this.extraItemListBuilder_.build();
                }
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
                if (other instanceof AvatarExpeditionGetRewardRsp) {
                    return mergeFrom((AvatarExpeditionGetRewardRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarExpeditionGetRewardRsp other) {
                if (other == AvatarExpeditionGetRewardRsp.getDefaultInstance()) {
                    return this;
                }
                if (this.itemListBuilder_ == null) {
                    if (!other.itemList_.isEmpty()) {
                        if (this.itemList_.isEmpty()) {
                            this.itemList_ = other.itemList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureItemListIsMutable();
                            this.itemList_.addAll(other.itemList_);
                        }
                        onChanged();
                    }
                } else if (!other.itemList_.isEmpty()) {
                    if (this.itemListBuilder_.isEmpty()) {
                        this.itemListBuilder_.dispose();
                        this.itemListBuilder_ = null;
                        this.itemList_ = other.itemList_;
                        this.bitField0_ &= -2;
                        this.itemListBuilder_ = AvatarExpeditionGetRewardRsp.alwaysUseFieldBuilders ? getItemListFieldBuilder() : null;
                    } else {
                        this.itemListBuilder_.addAllMessages(other.itemList_);
                    }
                }
                if (this.extraItemListBuilder_ == null) {
                    if (!other.extraItemList_.isEmpty()) {
                        if (this.extraItemList_.isEmpty()) {
                            this.extraItemList_ = other.extraItemList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureExtraItemListIsMutable();
                            this.extraItemList_.addAll(other.extraItemList_);
                        }
                        onChanged();
                    }
                } else if (!other.extraItemList_.isEmpty()) {
                    if (this.extraItemListBuilder_.isEmpty()) {
                        this.extraItemListBuilder_.dispose();
                        this.extraItemListBuilder_ = null;
                        this.extraItemList_ = other.extraItemList_;
                        this.bitField0_ &= -3;
                        this.extraItemListBuilder_ = AvatarExpeditionGetRewardRsp.alwaysUseFieldBuilders ? getExtraItemListFieldBuilder() : null;
                    } else {
                        this.extraItemListBuilder_.addAllMessages(other.extraItemList_);
                    }
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
                AvatarExpeditionGetRewardRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarExpeditionGetRewardRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarExpeditionGetRewardRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureItemListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.itemList_ = new ArrayList(this.itemList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
            public List<ItemParamOuterClass.ItemParam> getItemListList() {
                if (this.itemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.itemList_);
                }
                return this.itemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
            public int getItemListCount() {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.size();
                }
                return this.itemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
            public ItemParamOuterClass.ItemParam getItemList(int index) {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.get(index);
                }
                return this.itemListBuilder_.getMessage(index);
            }

            public Builder setItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.itemListBuilder_ != null) {
                    this.itemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemListIsMutable();
                    this.itemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addItemList(ItemParamOuterClass.ItemParam value) {
                if (this.itemListBuilder_ != null) {
                    this.itemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemListIsMutable();
                    this.itemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.itemListBuilder_ != null) {
                    this.itemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemListIsMutable();
                    this.itemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.itemList_);
                    onChanged();
                } else {
                    this.itemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearItemList() {
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.itemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeItemList(int index) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.remove(index);
                    onChanged();
                } else {
                    this.itemListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getItemListBuilder(int index) {
                return getItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getItemListOrBuilder(int index) {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.get(index);
                }
                return this.itemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemListOrBuilderList() {
                if (this.itemListBuilder_ != null) {
                    return this.itemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.itemList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addItemListBuilder() {
                return getItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addItemListBuilder(int index) {
                return getItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getItemListBuilderList() {
                return getItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getItemListFieldBuilder() {
                if (this.itemListBuilder_ == null) {
                    this.itemListBuilder_ = new RepeatedFieldBuilderV3<>(this.itemList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.itemList_ = null;
                }
                return this.itemListBuilder_;
            }

            private void ensureExtraItemListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.extraItemList_ = new ArrayList(this.extraItemList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
            public List<ItemParamOuterClass.ItemParam> getExtraItemListList() {
                if (this.extraItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.extraItemList_);
                }
                return this.extraItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
            public int getExtraItemListCount() {
                if (this.extraItemListBuilder_ == null) {
                    return this.extraItemList_.size();
                }
                return this.extraItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
            public ItemParamOuterClass.ItemParam getExtraItemList(int index) {
                if (this.extraItemListBuilder_ == null) {
                    return this.extraItemList_.get(index);
                }
                return this.extraItemListBuilder_.getMessage(index);
            }

            public Builder setExtraItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.extraItemListBuilder_ != null) {
                    this.extraItemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExtraItemListIsMutable();
                    this.extraItemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setExtraItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.extraItemListBuilder_ == null) {
                    ensureExtraItemListIsMutable();
                    this.extraItemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.extraItemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addExtraItemList(ItemParamOuterClass.ItemParam value) {
                if (this.extraItemListBuilder_ != null) {
                    this.extraItemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExtraItemListIsMutable();
                    this.extraItemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addExtraItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.extraItemListBuilder_ != null) {
                    this.extraItemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExtraItemListIsMutable();
                    this.extraItemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addExtraItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.extraItemListBuilder_ == null) {
                    ensureExtraItemListIsMutable();
                    this.extraItemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.extraItemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addExtraItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.extraItemListBuilder_ == null) {
                    ensureExtraItemListIsMutable();
                    this.extraItemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.extraItemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllExtraItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.extraItemListBuilder_ == null) {
                    ensureExtraItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.extraItemList_);
                    onChanged();
                } else {
                    this.extraItemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearExtraItemList() {
                if (this.extraItemListBuilder_ == null) {
                    this.extraItemList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.extraItemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeExtraItemList(int index) {
                if (this.extraItemListBuilder_ == null) {
                    ensureExtraItemListIsMutable();
                    this.extraItemList_.remove(index);
                    onChanged();
                } else {
                    this.extraItemListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getExtraItemListBuilder(int index) {
                return getExtraItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getExtraItemListOrBuilder(int index) {
                if (this.extraItemListBuilder_ == null) {
                    return this.extraItemList_.get(index);
                }
                return this.extraItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getExtraItemListOrBuilderList() {
                if (this.extraItemListBuilder_ != null) {
                    return this.extraItemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.extraItemList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addExtraItemListBuilder() {
                return getExtraItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addExtraItemListBuilder(int index) {
                return getExtraItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getExtraItemListBuilderList() {
                return getExtraItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getExtraItemListFieldBuilder() {
                if (this.extraItemListBuilder_ == null) {
                    this.extraItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.extraItemList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.extraItemList_ = null;
                }
                return this.extraItemListBuilder_;
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

            @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
            public int getExpeditionInfoMapCount() {
                return internalGetExpeditionInfoMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
            public boolean containsExpeditionInfoMap(long key) {
                return internalGetExpeditionInfoMap().getMap().containsKey(Long.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
            @Deprecated
            public Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMap() {
                return getExpeditionInfoMapMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
            public Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> getExpeditionInfoMapMap() {
                return internalGetExpeditionInfoMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
            public AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo getExpeditionInfoMapOrDefault(long key, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo defaultValue) {
                Map<Long, AvatarExpeditionInfoOuterClass.AvatarExpeditionInfo> map = internalGetExpeditionInfoMap().getMap();
                return map.containsKey(Long.valueOf(key)) ? map.get(Long.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarExpeditionGetRewardRspOuterClass.AvatarExpeditionGetRewardRspOrBuilder
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

        public static AvatarExpeditionGetRewardRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarExpeditionGetRewardRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarExpeditionGetRewardRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarExpeditionGetRewardRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AvatarExpeditionInfoOuterClass.getDescriptor();
        ItemParamOuterClass.getDescriptor();
    }
}
