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
import emu.grasscutter.net.proto.CodexTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CodexTypeDataOuterClass.class */
public final class CodexTypeDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013CodexTypeData.proto\u001a\u000fCodexType.proto\"ç\u0001\n\rCodexTypeData\u0012\u0013\n\u000bcodexIdList\u0018\u0004 \u0003(\r\u0012\u0016\n\u000ehaveViewedList\u0018\b \u0003(\b\u0012\u0018\n\u0004type\u0018\u000e \u0001(\u000e2\n.CodexType\u0012N\n\u0018weaponMaxPromoteLevelMap\u0018\u0003 \u0003(\u000b2,.CodexTypeData.WeaponMaxPromoteLevelMapEntry\u001a?\n\u001dWeaponMaxPromoteLevelMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CodexTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CodexTypeData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CodexTypeData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CodexTypeData_descriptor, new String[]{"CodexIdList", "HaveViewedList", "Type", "WeaponMaxPromoteLevelMap"});

    /* renamed from: internal_static_CodexTypeData_WeaponMaxPromoteLevelMapEntry_descriptor */
    private static final Descriptors.Descriptor f678x6279cfeb = internal_static_CodexTypeData_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_CodexTypeData_WeaponMaxPromoteLevelMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f679x6d7bdb69 = new GeneratedMessageV3.FieldAccessorTable(f678x6279cfeb, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CodexTypeDataOuterClass$CodexTypeDataOrBuilder.class */
    public interface CodexTypeDataOrBuilder extends MessageOrBuilder {
        List<Integer> getCodexIdListList();

        int getCodexIdListCount();

        int getCodexIdList(int i);

        List<Boolean> getHaveViewedListList();

        int getHaveViewedListCount();

        boolean getHaveViewedList(int i);

        int getTypeValue();

        CodexTypeOuterClass.CodexType getType();

        int getWeaponMaxPromoteLevelMapCount();

        boolean containsWeaponMaxPromoteLevelMap(int i);

        @Deprecated
        Map<Integer, Integer> getWeaponMaxPromoteLevelMap();

        Map<Integer, Integer> getWeaponMaxPromoteLevelMapMap();

        int getWeaponMaxPromoteLevelMapOrDefault(int i, int i2);

        int getWeaponMaxPromoteLevelMapOrThrow(int i);
    }

    private CodexTypeDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CodexTypeDataOuterClass$CodexTypeData.class */
    public static final class CodexTypeData extends GeneratedMessageV3 implements CodexTypeDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CODEXIDLIST_FIELD_NUMBER = 4;
        private Internal.IntList codexIdList_;
        private int codexIdListMemoizedSerializedSize;
        public static final int HAVEVIEWEDLIST_FIELD_NUMBER = 8;
        private Internal.BooleanList haveViewedList_;
        private int haveViewedListMemoizedSerializedSize;
        public static final int TYPE_FIELD_NUMBER = 14;
        private int type_;
        public static final int WEAPONMAXPROMOTELEVELMAP_FIELD_NUMBER = 3;
        private MapField<Integer, Integer> weaponMaxPromoteLevelMap_;
        private byte memoizedIsInitialized;
        private static final CodexTypeData DEFAULT_INSTANCE = new CodexTypeData();
        private static final Parser<CodexTypeData> PARSER = new AbstractParser<CodexTypeData>() { // from class: emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeData.1
            @Override // com.google.protobuf.Parser
            public CodexTypeData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CodexTypeData(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeData.internalGetMapField(int):com.google.protobuf.MapField
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
                com.google.protobuf.MapField r0 = r0.internalGetWeaponMaxPromoteLevelMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeData.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private CodexTypeData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.codexIdListMemoizedSerializedSize = -1;
            this.haveViewedListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private CodexTypeData() {
            this.codexIdListMemoizedSerializedSize = -1;
            this.haveViewedListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.codexIdList_ = emptyIntList();
            this.haveViewedList_ = emptyBooleanList();
            this.type_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CodexTypeData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:85:0x019f */
        private CodexTypeData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 26:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.weaponMaxPromoteLevelMap_ = MapField.newMapField(WeaponMaxPromoteLevelMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Integer> weaponMaxPromoteLevelMap__ = (MapEntry) input.readMessage(WeaponMaxPromoteLevelMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.weaponMaxPromoteLevelMap_.getMutableMap().put(weaponMaxPromoteLevelMap__.getKey(), weaponMaxPromoteLevelMap__.getValue());
                                break;
                            case 32:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.codexIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.codexIdList_.addInt(input.readUInt32());
                                break;
                            case 34:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.codexIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.codexIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 64:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.haveViewedList_ = newBooleanList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.haveViewedList_.addBoolean(input.readBool());
                                break;
                            case 66:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.haveViewedList_ = newBooleanList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.haveViewedList_.addBoolean(input.readBool());
                                }
                                input.popLimit(limit2);
                                break;
                            case 112:
                                this.type_ = input.readEnum();
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
                    this.codexIdList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.haveViewedList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CodexTypeDataOuterClass.internal_static_CodexTypeData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CodexTypeDataOuterClass.internal_static_CodexTypeData_fieldAccessorTable.ensureFieldAccessorsInitialized(CodexTypeData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
        public List<Integer> getCodexIdListList() {
            return this.codexIdList_;
        }

        @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
        public int getCodexIdListCount() {
            return this.codexIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
        public int getCodexIdList(int index) {
            return this.codexIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
        public List<Boolean> getHaveViewedListList() {
            return this.haveViewedList_;
        }

        @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
        public int getHaveViewedListCount() {
            return this.haveViewedList_.size();
        }

        @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
        public boolean getHaveViewedList(int index) {
            return this.haveViewedList_.getBoolean(index);
        }

        @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
        public CodexTypeOuterClass.CodexType getType() {
            CodexTypeOuterClass.CodexType result = CodexTypeOuterClass.CodexType.valueOf(this.type_);
            return result == null ? CodexTypeOuterClass.CodexType.UNRECOGNIZED : result;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CodexTypeDataOuterClass$CodexTypeData$WeaponMaxPromoteLevelMapDefaultEntryHolder.class */
        public static final class WeaponMaxPromoteLevelMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(CodexTypeDataOuterClass.f678x6279cfeb, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private WeaponMaxPromoteLevelMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetWeaponMaxPromoteLevelMap() {
            if (this.weaponMaxPromoteLevelMap_ == null) {
                return MapField.emptyMapField(WeaponMaxPromoteLevelMapDefaultEntryHolder.defaultEntry);
            }
            return this.weaponMaxPromoteLevelMap_;
        }

        @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
        public int getWeaponMaxPromoteLevelMapCount() {
            return internalGetWeaponMaxPromoteLevelMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
        public boolean containsWeaponMaxPromoteLevelMap(int key) {
            return internalGetWeaponMaxPromoteLevelMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
        @Deprecated
        public Map<Integer, Integer> getWeaponMaxPromoteLevelMap() {
            return getWeaponMaxPromoteLevelMapMap();
        }

        @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
        public Map<Integer, Integer> getWeaponMaxPromoteLevelMapMap() {
            return internalGetWeaponMaxPromoteLevelMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
        public int getWeaponMaxPromoteLevelMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetWeaponMaxPromoteLevelMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
        public int getWeaponMaxPromoteLevelMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetWeaponMaxPromoteLevelMap().getMap();
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
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetWeaponMaxPromoteLevelMap(), WeaponMaxPromoteLevelMapDefaultEntryHolder.defaultEntry, 3);
            if (getCodexIdListList().size() > 0) {
                output.writeUInt32NoTag(34);
                output.writeUInt32NoTag(this.codexIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.codexIdList_.size(); i++) {
                output.writeUInt32NoTag(this.codexIdList_.getInt(i));
            }
            if (getHaveViewedListList().size() > 0) {
                output.writeUInt32NoTag(66);
                output.writeUInt32NoTag(this.haveViewedListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.haveViewedList_.size(); i2++) {
                output.writeBoolNoTag(this.haveViewedList_.getBoolean(i2));
            }
            if (this.type_ != CodexTypeOuterClass.CodexType.CODEX_TYPE_NONE.getNumber()) {
                output.writeEnum(14, this.type_);
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
            for (Map.Entry<Integer, Integer> entry : internalGetWeaponMaxPromoteLevelMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(3, WeaponMaxPromoteLevelMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            int dataSize = 0;
            for (int i = 0; i < this.codexIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.codexIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getCodexIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.codexIdListMemoizedSerializedSize = dataSize;
            int dataSize2 = 1 * getHaveViewedListList().size();
            int size4 = size3 + dataSize2;
            if (!getHaveViewedListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.haveViewedListMemoizedSerializedSize = dataSize2;
            if (this.type_ != CodexTypeOuterClass.CodexType.CODEX_TYPE_NONE.getNumber()) {
                size4 += CodedOutputStream.computeEnumSize(14, this.type_);
            }
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CodexTypeData)) {
                return equals(obj);
            }
            CodexTypeData other = (CodexTypeData) obj;
            return getCodexIdListList().equals(other.getCodexIdListList()) && getHaveViewedListList().equals(other.getHaveViewedListList()) && this.type_ == other.type_ && internalGetWeaponMaxPromoteLevelMap().equals(other.internalGetWeaponMaxPromoteLevelMap()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getCodexIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getCodexIdListList().hashCode();
            }
            if (getHaveViewedListCount() > 0) {
                hash = (53 * ((37 * hash) + 8)) + getHaveViewedListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 14)) + this.type_;
            if (!internalGetWeaponMaxPromoteLevelMap().getMap().isEmpty()) {
                hash2 = (53 * ((37 * hash2) + 3)) + internalGetWeaponMaxPromoteLevelMap().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static CodexTypeData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CodexTypeData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CodexTypeData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CodexTypeData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CodexTypeData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CodexTypeData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CodexTypeData parseFrom(InputStream input) throws IOException {
            return (CodexTypeData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CodexTypeData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CodexTypeData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CodexTypeData parseDelimitedFrom(InputStream input) throws IOException {
            return (CodexTypeData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CodexTypeData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CodexTypeData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CodexTypeData parseFrom(CodedInputStream input) throws IOException {
            return (CodexTypeData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CodexTypeData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CodexTypeData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CodexTypeData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CodexTypeDataOuterClass$CodexTypeData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CodexTypeDataOrBuilder {
            private int bitField0_;
            private Internal.IntList codexIdList_ = CodexTypeData.emptyIntList();
            private Internal.BooleanList haveViewedList_ = CodexTypeData.emptyBooleanList();
            private int type_ = 0;
            private MapField<Integer, Integer> weaponMaxPromoteLevelMap_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeData.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetWeaponMaxPromoteLevelMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeData.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeData.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetMutableWeaponMaxPromoteLevelMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeData.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return CodexTypeDataOuterClass.internal_static_CodexTypeData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CodexTypeDataOuterClass.internal_static_CodexTypeData_fieldAccessorTable.ensureFieldAccessorsInitialized(CodexTypeData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CodexTypeData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.codexIdList_ = CodexTypeData.emptyIntList();
                this.bitField0_ &= -2;
                this.haveViewedList_ = CodexTypeData.emptyBooleanList();
                this.bitField0_ &= -3;
                this.type_ = 0;
                internalGetMutableWeaponMaxPromoteLevelMap().clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CodexTypeDataOuterClass.internal_static_CodexTypeData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CodexTypeData getDefaultInstanceForType() {
                return CodexTypeData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodexTypeData build() {
                CodexTypeData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodexTypeData buildPartial() {
                CodexTypeData result = new CodexTypeData(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.codexIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.codexIdList_ = this.codexIdList_;
                if ((this.bitField0_ & 2) != 0) {
                    this.haveViewedList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.haveViewedList_ = this.haveViewedList_;
                result.type_ = this.type_;
                result.weaponMaxPromoteLevelMap_ = internalGetWeaponMaxPromoteLevelMap();
                result.weaponMaxPromoteLevelMap_.makeImmutable();
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
                if (other instanceof CodexTypeData) {
                    return mergeFrom((CodexTypeData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CodexTypeData other) {
                if (other == CodexTypeData.getDefaultInstance()) {
                    return this;
                }
                if (!other.codexIdList_.isEmpty()) {
                    if (this.codexIdList_.isEmpty()) {
                        this.codexIdList_ = other.codexIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureCodexIdListIsMutable();
                        this.codexIdList_.addAll(other.codexIdList_);
                    }
                    onChanged();
                }
                if (!other.haveViewedList_.isEmpty()) {
                    if (this.haveViewedList_.isEmpty()) {
                        this.haveViewedList_ = other.haveViewedList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureHaveViewedListIsMutable();
                        this.haveViewedList_.addAll(other.haveViewedList_);
                    }
                    onChanged();
                }
                if (other.type_ != 0) {
                    setTypeValue(other.getTypeValue());
                }
                internalGetMutableWeaponMaxPromoteLevelMap().mergeFrom(other.internalGetWeaponMaxPromoteLevelMap());
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
                CodexTypeData parsedMessage = null;
                try {
                    try {
                        parsedMessage = CodexTypeData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CodexTypeData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureCodexIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.codexIdList_ = CodexTypeData.mutableCopy(this.codexIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
            public List<Integer> getCodexIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.codexIdList_) : this.codexIdList_;
            }

            @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
            public int getCodexIdListCount() {
                return this.codexIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
            public int getCodexIdList(int index) {
                return this.codexIdList_.getInt(index);
            }

            public Builder setCodexIdList(int index, int value) {
                ensureCodexIdListIsMutable();
                this.codexIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addCodexIdList(int value) {
                ensureCodexIdListIsMutable();
                this.codexIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllCodexIdList(Iterable<? extends Integer> values) {
                ensureCodexIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.codexIdList_);
                onChanged();
                return this;
            }

            public Builder clearCodexIdList() {
                this.codexIdList_ = CodexTypeData.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureHaveViewedListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.haveViewedList_ = CodexTypeData.mutableCopy(this.haveViewedList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
            public List<Boolean> getHaveViewedListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.haveViewedList_) : this.haveViewedList_;
            }

            @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
            public int getHaveViewedListCount() {
                return this.haveViewedList_.size();
            }

            @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
            public boolean getHaveViewedList(int index) {
                return this.haveViewedList_.getBoolean(index);
            }

            public Builder setHaveViewedList(int index, boolean value) {
                ensureHaveViewedListIsMutable();
                this.haveViewedList_.setBoolean(index, value);
                onChanged();
                return this;
            }

            public Builder addHaveViewedList(boolean value) {
                ensureHaveViewedListIsMutable();
                this.haveViewedList_.addBoolean(value);
                onChanged();
                return this;
            }

            public Builder addAllHaveViewedList(Iterable<? extends Boolean> values) {
                ensureHaveViewedListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.haveViewedList_);
                onChanged();
                return this;
            }

            public Builder clearHaveViewedList() {
                this.haveViewedList_ = CodexTypeData.emptyBooleanList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            public Builder setTypeValue(int value) {
                this.type_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
            public CodexTypeOuterClass.CodexType getType() {
                CodexTypeOuterClass.CodexType result = CodexTypeOuterClass.CodexType.valueOf(this.type_);
                return result == null ? CodexTypeOuterClass.CodexType.UNRECOGNIZED : result;
            }

            public Builder setType(CodexTypeOuterClass.CodexType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.type_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetWeaponMaxPromoteLevelMap() {
                if (this.weaponMaxPromoteLevelMap_ == null) {
                    return MapField.emptyMapField(WeaponMaxPromoteLevelMapDefaultEntryHolder.defaultEntry);
                }
                return this.weaponMaxPromoteLevelMap_;
            }

            private MapField<Integer, Integer> internalGetMutableWeaponMaxPromoteLevelMap() {
                onChanged();
                if (this.weaponMaxPromoteLevelMap_ == null) {
                    this.weaponMaxPromoteLevelMap_ = MapField.newMapField(WeaponMaxPromoteLevelMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.weaponMaxPromoteLevelMap_.isMutable()) {
                    this.weaponMaxPromoteLevelMap_ = this.weaponMaxPromoteLevelMap_.copy();
                }
                return this.weaponMaxPromoteLevelMap_;
            }

            @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
            public int getWeaponMaxPromoteLevelMapCount() {
                return internalGetWeaponMaxPromoteLevelMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
            public boolean containsWeaponMaxPromoteLevelMap(int key) {
                return internalGetWeaponMaxPromoteLevelMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
            @Deprecated
            public Map<Integer, Integer> getWeaponMaxPromoteLevelMap() {
                return getWeaponMaxPromoteLevelMapMap();
            }

            @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
            public Map<Integer, Integer> getWeaponMaxPromoteLevelMapMap() {
                return internalGetWeaponMaxPromoteLevelMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
            public int getWeaponMaxPromoteLevelMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetWeaponMaxPromoteLevelMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.CodexTypeDataOuterClass.CodexTypeDataOrBuilder
            public int getWeaponMaxPromoteLevelMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetWeaponMaxPromoteLevelMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearWeaponMaxPromoteLevelMap() {
                internalGetMutableWeaponMaxPromoteLevelMap().getMutableMap().clear();
                return this;
            }

            public Builder removeWeaponMaxPromoteLevelMap(int key) {
                internalGetMutableWeaponMaxPromoteLevelMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableWeaponMaxPromoteLevelMap() {
                return internalGetMutableWeaponMaxPromoteLevelMap().getMutableMap();
            }

            public Builder putWeaponMaxPromoteLevelMap(int key, int value) {
                internalGetMutableWeaponMaxPromoteLevelMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllWeaponMaxPromoteLevelMap(Map<Integer, Integer> values) {
                internalGetMutableWeaponMaxPromoteLevelMap().getMutableMap().putAll(values);
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

        public static CodexTypeData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CodexTypeData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CodexTypeData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CodexTypeData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CodexTypeOuterClass.getDescriptor();
    }
}
