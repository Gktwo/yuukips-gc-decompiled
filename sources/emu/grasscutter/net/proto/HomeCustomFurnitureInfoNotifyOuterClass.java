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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import emu.grasscutter.net.proto.HomeCustomFurnitureInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeCustomFurnitureInfoNotifyOuterClass.class */
public final class HomeCustomFurnitureInfoNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#HomeCustomFurnitureInfoNotify.proto\u001a\u001dHomeCustomFurnitureInfo.proto\"¨\u0002\n\u001dHomeCustomFurnitureInfoNotify\u0012$\n\u001cdelete_custom_furniture_list\u0018\r \u0003(\r\u0012<\n\u001acustom_furniture_info_list\u0018\u000f \u0003(\u000b2\u0018.HomeCustomFurnitureInfo\u0012b\n\u001cused_sub_furniture_count_map\u0018\u0003 \u0003(\u000b2<.HomeCustomFurnitureInfoNotify.UsedSubFurnitureCountMapEntry\u001a?\n\u001dUsedSubFurnitureCountMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeCustomFurnitureInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeCustomFurnitureInfoNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeCustomFurnitureInfoNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeCustomFurnitureInfoNotify_descriptor, new String[]{"DeleteCustomFurnitureList", "CustomFurnitureInfoList", "UsedSubFurnitureCountMap"});

    /* renamed from: internal_static_HomeCustomFurnitureInfoNotify_UsedSubFurnitureCountMapEntry_descriptor */
    private static final Descriptors.Descriptor f757xe9bbbd2d = internal_static_HomeCustomFurnitureInfoNotify_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_HomeCustomFurnitureInfoNotify_UsedSubFurnitureCountMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f758xb82566ab = new GeneratedMessageV3.FieldAccessorTable(f757xe9bbbd2d, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeCustomFurnitureInfoNotifyOuterClass$HomeCustomFurnitureInfoNotifyOrBuilder.class */
    public interface HomeCustomFurnitureInfoNotifyOrBuilder extends MessageOrBuilder {
        List<Integer> getDeleteCustomFurnitureListList();

        int getDeleteCustomFurnitureListCount();

        int getDeleteCustomFurnitureList(int i);

        List<HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo> getCustomFurnitureInfoListList();

        HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo getCustomFurnitureInfoList(int i);

        int getCustomFurnitureInfoListCount();

        List<? extends HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder> getCustomFurnitureInfoListOrBuilderList();

        HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder getCustomFurnitureInfoListOrBuilder(int i);

        int getUsedSubFurnitureCountMapCount();

        boolean containsUsedSubFurnitureCountMap(int i);

        @Deprecated
        Map<Integer, Integer> getUsedSubFurnitureCountMap();

        Map<Integer, Integer> getUsedSubFurnitureCountMapMap();

        int getUsedSubFurnitureCountMapOrDefault(int i, int i2);

        int getUsedSubFurnitureCountMapOrThrow(int i);
    }

    private HomeCustomFurnitureInfoNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeCustomFurnitureInfoNotifyOuterClass$HomeCustomFurnitureInfoNotify.class */
    public static final class HomeCustomFurnitureInfoNotify extends GeneratedMessageV3 implements HomeCustomFurnitureInfoNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DELETE_CUSTOM_FURNITURE_LIST_FIELD_NUMBER = 13;
        private Internal.IntList deleteCustomFurnitureList_;
        private int deleteCustomFurnitureListMemoizedSerializedSize;
        public static final int CUSTOM_FURNITURE_INFO_LIST_FIELD_NUMBER = 15;
        private List<HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo> customFurnitureInfoList_;
        public static final int USED_SUB_FURNITURE_COUNT_MAP_FIELD_NUMBER = 3;
        private MapField<Integer, Integer> usedSubFurnitureCountMap_;
        private byte memoizedIsInitialized;
        private static final HomeCustomFurnitureInfoNotify DEFAULT_INSTANCE = new HomeCustomFurnitureInfoNotify();
        private static final Parser<HomeCustomFurnitureInfoNotify> PARSER = new AbstractParser<HomeCustomFurnitureInfoNotify>() { // from class: emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotify.1
            @Override // com.google.protobuf.Parser
            public HomeCustomFurnitureInfoNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeCustomFurnitureInfoNotify(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotify.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 3: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetUsedSubFurnitureCountMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotify.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private HomeCustomFurnitureInfoNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.deleteCustomFurnitureListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private HomeCustomFurnitureInfoNotify() {
            this.deleteCustomFurnitureListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.deleteCustomFurnitureList_ = emptyIntList();
            this.customFurnitureInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeCustomFurnitureInfoNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:73:0x0146 */
        private HomeCustomFurnitureInfoNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 26:
                                    if ((mutable_bitField0_ & 4) == 0) {
                                        this.usedSubFurnitureCountMap_ = MapField.newMapField(UsedSubFurnitureCountMapDefaultEntryHolder.defaultEntry);
                                        mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                    }
                                    MapEntry<Integer, Integer> usedSubFurnitureCountMap__ = (MapEntry) input.readMessage(UsedSubFurnitureCountMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                    this.usedSubFurnitureCountMap_.getMutableMap().put(usedSubFurnitureCountMap__.getKey(), usedSubFurnitureCountMap__.getValue());
                                    break;
                                case 104:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.deleteCustomFurnitureList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.deleteCustomFurnitureList_.addInt(input.readUInt32());
                                    break;
                                case 106:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.deleteCustomFurnitureList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.deleteCustomFurnitureList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 122:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.customFurnitureInfoList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.customFurnitureInfoList_.add((HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo) input.readMessage(HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.parser(), extensionRegistry));
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.deleteCustomFurnitureList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.customFurnitureInfoList_ = Collections.unmodifiableList(this.customFurnitureInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeCustomFurnitureInfoNotifyOuterClass.internal_static_HomeCustomFurnitureInfoNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeCustomFurnitureInfoNotifyOuterClass.internal_static_HomeCustomFurnitureInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeCustomFurnitureInfoNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
        public List<Integer> getDeleteCustomFurnitureListList() {
            return this.deleteCustomFurnitureList_;
        }

        @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
        public int getDeleteCustomFurnitureListCount() {
            return this.deleteCustomFurnitureList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
        public int getDeleteCustomFurnitureList(int index) {
            return this.deleteCustomFurnitureList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
        public List<HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo> getCustomFurnitureInfoListList() {
            return this.customFurnitureInfoList_;
        }

        @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
        public List<? extends HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder> getCustomFurnitureInfoListOrBuilderList() {
            return this.customFurnitureInfoList_;
        }

        @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
        public int getCustomFurnitureInfoListCount() {
            return this.customFurnitureInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
        public HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo getCustomFurnitureInfoList(int index) {
            return this.customFurnitureInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
        public HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder getCustomFurnitureInfoListOrBuilder(int index) {
            return this.customFurnitureInfoList_.get(index);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeCustomFurnitureInfoNotifyOuterClass$HomeCustomFurnitureInfoNotify$UsedSubFurnitureCountMapDefaultEntryHolder.class */
        public static final class UsedSubFurnitureCountMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(HomeCustomFurnitureInfoNotifyOuterClass.f757xe9bbbd2d, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private UsedSubFurnitureCountMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetUsedSubFurnitureCountMap() {
            if (this.usedSubFurnitureCountMap_ == null) {
                return MapField.emptyMapField(UsedSubFurnitureCountMapDefaultEntryHolder.defaultEntry);
            }
            return this.usedSubFurnitureCountMap_;
        }

        @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
        public int getUsedSubFurnitureCountMapCount() {
            return internalGetUsedSubFurnitureCountMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
        public boolean containsUsedSubFurnitureCountMap(int key) {
            return internalGetUsedSubFurnitureCountMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
        @Deprecated
        public Map<Integer, Integer> getUsedSubFurnitureCountMap() {
            return getUsedSubFurnitureCountMapMap();
        }

        @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
        public Map<Integer, Integer> getUsedSubFurnitureCountMapMap() {
            return internalGetUsedSubFurnitureCountMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
        public int getUsedSubFurnitureCountMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetUsedSubFurnitureCountMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
        public int getUsedSubFurnitureCountMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetUsedSubFurnitureCountMap().getMap();
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
            getSerializedSize();
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetUsedSubFurnitureCountMap(), UsedSubFurnitureCountMapDefaultEntryHolder.defaultEntry, 3);
            if (getDeleteCustomFurnitureListList().size() > 0) {
                output.writeUInt32NoTag(106);
                output.writeUInt32NoTag(this.deleteCustomFurnitureListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.deleteCustomFurnitureList_.size(); i++) {
                output.writeUInt32NoTag(this.deleteCustomFurnitureList_.getInt(i));
            }
            for (int i2 = 0; i2 < this.customFurnitureInfoList_.size(); i2++) {
                output.writeMessage(15, this.customFurnitureInfoList_.get(i2));
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
            for (Map.Entry<Integer, Integer> entry : internalGetUsedSubFurnitureCountMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(3, UsedSubFurnitureCountMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            int dataSize = 0;
            for (int i = 0; i < this.deleteCustomFurnitureList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.deleteCustomFurnitureList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getDeleteCustomFurnitureListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.deleteCustomFurnitureListMemoizedSerializedSize = dataSize;
            for (int i2 = 0; i2 < this.customFurnitureInfoList_.size(); i2++) {
                size3 += CodedOutputStream.computeMessageSize(15, this.customFurnitureInfoList_.get(i2));
            }
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof HomeCustomFurnitureInfoNotify)) {
                return equals(obj);
            }
            HomeCustomFurnitureInfoNotify other = (HomeCustomFurnitureInfoNotify) obj;
            return getDeleteCustomFurnitureListList().equals(other.getDeleteCustomFurnitureListList()) && getCustomFurnitureInfoListList().equals(other.getCustomFurnitureInfoListList()) && internalGetUsedSubFurnitureCountMap().equals(other.internalGetUsedSubFurnitureCountMap()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getDeleteCustomFurnitureListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getDeleteCustomFurnitureListList().hashCode();
            }
            if (getCustomFurnitureInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getCustomFurnitureInfoListList().hashCode();
            }
            if (!internalGetUsedSubFurnitureCountMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 3)) + internalGetUsedSubFurnitureCountMap().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeCustomFurnitureInfoNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeCustomFurnitureInfoNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeCustomFurnitureInfoNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeCustomFurnitureInfoNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeCustomFurnitureInfoNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeCustomFurnitureInfoNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeCustomFurnitureInfoNotify parseFrom(InputStream input) throws IOException {
            return (HomeCustomFurnitureInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeCustomFurnitureInfoNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeCustomFurnitureInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeCustomFurnitureInfoNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeCustomFurnitureInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeCustomFurnitureInfoNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeCustomFurnitureInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeCustomFurnitureInfoNotify parseFrom(CodedInputStream input) throws IOException {
            return (HomeCustomFurnitureInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeCustomFurnitureInfoNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeCustomFurnitureInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeCustomFurnitureInfoNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeCustomFurnitureInfoNotifyOuterClass$HomeCustomFurnitureInfoNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeCustomFurnitureInfoNotifyOrBuilder {
            private int bitField0_;
            private Internal.IntList deleteCustomFurnitureList_ = HomeCustomFurnitureInfoNotify.emptyIntList();
            private List<HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo> customFurnitureInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo, HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.Builder, HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder> customFurnitureInfoListBuilder_;
            private MapField<Integer, Integer> usedSubFurnitureCountMap_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetUsedSubFurnitureCountMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetMutableUsedSubFurnitureCountMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeCustomFurnitureInfoNotifyOuterClass.internal_static_HomeCustomFurnitureInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeCustomFurnitureInfoNotifyOuterClass.internal_static_HomeCustomFurnitureInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeCustomFurnitureInfoNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeCustomFurnitureInfoNotify.alwaysUseFieldBuilders) {
                    getCustomFurnitureInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.deleteCustomFurnitureList_ = HomeCustomFurnitureInfoNotify.emptyIntList();
                this.bitField0_ &= -2;
                if (this.customFurnitureInfoListBuilder_ == null) {
                    this.customFurnitureInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.customFurnitureInfoListBuilder_.clear();
                }
                internalGetMutableUsedSubFurnitureCountMap().clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeCustomFurnitureInfoNotifyOuterClass.internal_static_HomeCustomFurnitureInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeCustomFurnitureInfoNotify getDefaultInstanceForType() {
                return HomeCustomFurnitureInfoNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeCustomFurnitureInfoNotify build() {
                HomeCustomFurnitureInfoNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeCustomFurnitureInfoNotify buildPartial() {
                HomeCustomFurnitureInfoNotify result = new HomeCustomFurnitureInfoNotify(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.deleteCustomFurnitureList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.deleteCustomFurnitureList_ = this.deleteCustomFurnitureList_;
                if (this.customFurnitureInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.customFurnitureInfoList_ = Collections.unmodifiableList(this.customFurnitureInfoList_);
                        this.bitField0_ &= -3;
                    }
                    result.customFurnitureInfoList_ = this.customFurnitureInfoList_;
                } else {
                    result.customFurnitureInfoList_ = this.customFurnitureInfoListBuilder_.build();
                }
                result.usedSubFurnitureCountMap_ = internalGetUsedSubFurnitureCountMap();
                result.usedSubFurnitureCountMap_.makeImmutable();
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
                if (other instanceof HomeCustomFurnitureInfoNotify) {
                    return mergeFrom((HomeCustomFurnitureInfoNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeCustomFurnitureInfoNotify other) {
                if (other == HomeCustomFurnitureInfoNotify.getDefaultInstance()) {
                    return this;
                }
                if (!other.deleteCustomFurnitureList_.isEmpty()) {
                    if (this.deleteCustomFurnitureList_.isEmpty()) {
                        this.deleteCustomFurnitureList_ = other.deleteCustomFurnitureList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureDeleteCustomFurnitureListIsMutable();
                        this.deleteCustomFurnitureList_.addAll(other.deleteCustomFurnitureList_);
                    }
                    onChanged();
                }
                if (this.customFurnitureInfoListBuilder_ == null) {
                    if (!other.customFurnitureInfoList_.isEmpty()) {
                        if (this.customFurnitureInfoList_.isEmpty()) {
                            this.customFurnitureInfoList_ = other.customFurnitureInfoList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureCustomFurnitureInfoListIsMutable();
                            this.customFurnitureInfoList_.addAll(other.customFurnitureInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.customFurnitureInfoList_.isEmpty()) {
                    if (this.customFurnitureInfoListBuilder_.isEmpty()) {
                        this.customFurnitureInfoListBuilder_.dispose();
                        this.customFurnitureInfoListBuilder_ = null;
                        this.customFurnitureInfoList_ = other.customFurnitureInfoList_;
                        this.bitField0_ &= -3;
                        this.customFurnitureInfoListBuilder_ = HomeCustomFurnitureInfoNotify.alwaysUseFieldBuilders ? getCustomFurnitureInfoListFieldBuilder() : null;
                    } else {
                        this.customFurnitureInfoListBuilder_.addAllMessages(other.customFurnitureInfoList_);
                    }
                }
                internalGetMutableUsedSubFurnitureCountMap().mergeFrom(other.internalGetUsedSubFurnitureCountMap());
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
                HomeCustomFurnitureInfoNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeCustomFurnitureInfoNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeCustomFurnitureInfoNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureDeleteCustomFurnitureListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.deleteCustomFurnitureList_ = HomeCustomFurnitureInfoNotify.mutableCopy(this.deleteCustomFurnitureList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
            public List<Integer> getDeleteCustomFurnitureListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.deleteCustomFurnitureList_) : this.deleteCustomFurnitureList_;
            }

            @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
            public int getDeleteCustomFurnitureListCount() {
                return this.deleteCustomFurnitureList_.size();
            }

            @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
            public int getDeleteCustomFurnitureList(int index) {
                return this.deleteCustomFurnitureList_.getInt(index);
            }

            public Builder setDeleteCustomFurnitureList(int index, int value) {
                ensureDeleteCustomFurnitureListIsMutable();
                this.deleteCustomFurnitureList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addDeleteCustomFurnitureList(int value) {
                ensureDeleteCustomFurnitureListIsMutable();
                this.deleteCustomFurnitureList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllDeleteCustomFurnitureList(Iterable<? extends Integer> values) {
                ensureDeleteCustomFurnitureListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.deleteCustomFurnitureList_);
                onChanged();
                return this;
            }

            public Builder clearDeleteCustomFurnitureList() {
                this.deleteCustomFurnitureList_ = HomeCustomFurnitureInfoNotify.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureCustomFurnitureInfoListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.customFurnitureInfoList_ = new ArrayList(this.customFurnitureInfoList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
            public List<HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo> getCustomFurnitureInfoListList() {
                if (this.customFurnitureInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.customFurnitureInfoList_);
                }
                return this.customFurnitureInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
            public int getCustomFurnitureInfoListCount() {
                if (this.customFurnitureInfoListBuilder_ == null) {
                    return this.customFurnitureInfoList_.size();
                }
                return this.customFurnitureInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
            public HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo getCustomFurnitureInfoList(int index) {
                if (this.customFurnitureInfoListBuilder_ == null) {
                    return this.customFurnitureInfoList_.get(index);
                }
                return this.customFurnitureInfoListBuilder_.getMessage(index);
            }

            public Builder setCustomFurnitureInfoList(int index, HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo value) {
                if (this.customFurnitureInfoListBuilder_ != null) {
                    this.customFurnitureInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCustomFurnitureInfoListIsMutable();
                    this.customFurnitureInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setCustomFurnitureInfoList(int index, HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.Builder builderForValue) {
                if (this.customFurnitureInfoListBuilder_ == null) {
                    ensureCustomFurnitureInfoListIsMutable();
                    this.customFurnitureInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.customFurnitureInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addCustomFurnitureInfoList(HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo value) {
                if (this.customFurnitureInfoListBuilder_ != null) {
                    this.customFurnitureInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCustomFurnitureInfoListIsMutable();
                    this.customFurnitureInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addCustomFurnitureInfoList(int index, HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo value) {
                if (this.customFurnitureInfoListBuilder_ != null) {
                    this.customFurnitureInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCustomFurnitureInfoListIsMutable();
                    this.customFurnitureInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addCustomFurnitureInfoList(HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.Builder builderForValue) {
                if (this.customFurnitureInfoListBuilder_ == null) {
                    ensureCustomFurnitureInfoListIsMutable();
                    this.customFurnitureInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.customFurnitureInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addCustomFurnitureInfoList(int index, HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.Builder builderForValue) {
                if (this.customFurnitureInfoListBuilder_ == null) {
                    ensureCustomFurnitureInfoListIsMutable();
                    this.customFurnitureInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.customFurnitureInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllCustomFurnitureInfoList(Iterable<? extends HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo> values) {
                if (this.customFurnitureInfoListBuilder_ == null) {
                    ensureCustomFurnitureInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.customFurnitureInfoList_);
                    onChanged();
                } else {
                    this.customFurnitureInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearCustomFurnitureInfoList() {
                if (this.customFurnitureInfoListBuilder_ == null) {
                    this.customFurnitureInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.customFurnitureInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeCustomFurnitureInfoList(int index) {
                if (this.customFurnitureInfoListBuilder_ == null) {
                    ensureCustomFurnitureInfoListIsMutable();
                    this.customFurnitureInfoList_.remove(index);
                    onChanged();
                } else {
                    this.customFurnitureInfoListBuilder_.remove(index);
                }
                return this;
            }

            public HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.Builder getCustomFurnitureInfoListBuilder(int index) {
                return getCustomFurnitureInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
            public HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder getCustomFurnitureInfoListOrBuilder(int index) {
                if (this.customFurnitureInfoListBuilder_ == null) {
                    return this.customFurnitureInfoList_.get(index);
                }
                return this.customFurnitureInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
            public List<? extends HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder> getCustomFurnitureInfoListOrBuilderList() {
                if (this.customFurnitureInfoListBuilder_ != null) {
                    return this.customFurnitureInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.customFurnitureInfoList_);
            }

            public HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.Builder addCustomFurnitureInfoListBuilder() {
                return getCustomFurnitureInfoListFieldBuilder().addBuilder(HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.getDefaultInstance());
            }

            public HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.Builder addCustomFurnitureInfoListBuilder(int index) {
                return getCustomFurnitureInfoListFieldBuilder().addBuilder(index, HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.getDefaultInstance());
            }

            public List<HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.Builder> getCustomFurnitureInfoListBuilderList() {
                return getCustomFurnitureInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo, HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfo.Builder, HomeCustomFurnitureInfoOuterClass.HomeCustomFurnitureInfoOrBuilder> getCustomFurnitureInfoListFieldBuilder() {
                if (this.customFurnitureInfoListBuilder_ == null) {
                    this.customFurnitureInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.customFurnitureInfoList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.customFurnitureInfoList_ = null;
                }
                return this.customFurnitureInfoListBuilder_;
            }

            private MapField<Integer, Integer> internalGetUsedSubFurnitureCountMap() {
                if (this.usedSubFurnitureCountMap_ == null) {
                    return MapField.emptyMapField(UsedSubFurnitureCountMapDefaultEntryHolder.defaultEntry);
                }
                return this.usedSubFurnitureCountMap_;
            }

            private MapField<Integer, Integer> internalGetMutableUsedSubFurnitureCountMap() {
                onChanged();
                if (this.usedSubFurnitureCountMap_ == null) {
                    this.usedSubFurnitureCountMap_ = MapField.newMapField(UsedSubFurnitureCountMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.usedSubFurnitureCountMap_.isMutable()) {
                    this.usedSubFurnitureCountMap_ = this.usedSubFurnitureCountMap_.copy();
                }
                return this.usedSubFurnitureCountMap_;
            }

            @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
            public int getUsedSubFurnitureCountMapCount() {
                return internalGetUsedSubFurnitureCountMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
            public boolean containsUsedSubFurnitureCountMap(int key) {
                return internalGetUsedSubFurnitureCountMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
            @Deprecated
            public Map<Integer, Integer> getUsedSubFurnitureCountMap() {
                return getUsedSubFurnitureCountMapMap();
            }

            @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
            public Map<Integer, Integer> getUsedSubFurnitureCountMapMap() {
                return internalGetUsedSubFurnitureCountMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
            public int getUsedSubFurnitureCountMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetUsedSubFurnitureCountMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.HomeCustomFurnitureInfoNotifyOuterClass.HomeCustomFurnitureInfoNotifyOrBuilder
            public int getUsedSubFurnitureCountMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetUsedSubFurnitureCountMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearUsedSubFurnitureCountMap() {
                internalGetMutableUsedSubFurnitureCountMap().getMutableMap().clear();
                return this;
            }

            public Builder removeUsedSubFurnitureCountMap(int key) {
                internalGetMutableUsedSubFurnitureCountMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableUsedSubFurnitureCountMap() {
                return internalGetMutableUsedSubFurnitureCountMap().getMutableMap();
            }

            public Builder putUsedSubFurnitureCountMap(int key, int value) {
                internalGetMutableUsedSubFurnitureCountMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllUsedSubFurnitureCountMap(Map<Integer, Integer> values) {
                internalGetMutableUsedSubFurnitureCountMap().getMutableMap().putAll(values);
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

        public static HomeCustomFurnitureInfoNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeCustomFurnitureInfoNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeCustomFurnitureInfoNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeCustomFurnitureInfoNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HomeCustomFurnitureInfoOuterClass.getDescriptor();
    }
}
