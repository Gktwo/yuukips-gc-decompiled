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
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetQuestLackingResourceRspOuterClass.class */
public final class GetQuestLackingResourceRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n GetQuestLackingResourceRsp.proto\"ñ\u0002\n\u001aGetQuestLackingResourceRsp\u0012I\n\u0010lacked_place_map\u0018\u0002 \u0003(\u000b2/.GetQuestLackingResourceRsp.LackedPlaceMapEntry\u0012E\n\u000elacked_npc_map\u0018\u0007 \u0003(\u000b2-.GetQuestLackingResourceRsp.LackedNpcMapEntry\u0012\u0019\n\u0011lacked_place_list\u0018\u000b \u0003(\r\u0012\u0010\n\bquest_id\u0018\u0003 \u0001(\r\u0012\u000f\n\u0007retcode\u0018\u0006 \u0001(\u0005\u0012\u0017\n\u000flacked_npc_list\u0018\u000e \u0003(\r\u001a5\n\u0013LackedPlaceMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001\u001a3\n\u0011LackedNpcMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GetQuestLackingResourceRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetQuestLackingResourceRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetQuestLackingResourceRsp_descriptor, new String[]{"LackedPlaceMap", "LackedNpcMap", "LackedPlaceList", "QuestId", "Retcode", "LackedNpcList"});

    /* renamed from: internal_static_GetQuestLackingResourceRsp_LackedPlaceMapEntry_descriptor */
    private static final Descriptors.Descriptor f745x5d6a41f5 = internal_static_GetQuestLackingResourceRsp_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_GetQuestLackingResourceRsp_LackedPlaceMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f746xbc86a373 = new GeneratedMessageV3.FieldAccessorTable(f745x5d6a41f5, new String[]{"Key", "Value"});

    /* renamed from: internal_static_GetQuestLackingResourceRsp_LackedNpcMapEntry_descriptor */
    private static final Descriptors.Descriptor f747xfb45f6db = internal_static_GetQuestLackingResourceRsp_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_GetQuestLackingResourceRsp_LackedNpcMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f748xa2ea1259 = new GeneratedMessageV3.FieldAccessorTable(f747xfb45f6db, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetQuestLackingResourceRspOuterClass$GetQuestLackingResourceRspOrBuilder.class */
    public interface GetQuestLackingResourceRspOrBuilder extends MessageOrBuilder {
        int getLackedPlaceMapCount();

        boolean containsLackedPlaceMap(int i);

        @Deprecated
        Map<Integer, Integer> getLackedPlaceMap();

        Map<Integer, Integer> getLackedPlaceMapMap();

        int getLackedPlaceMapOrDefault(int i, int i2);

        int getLackedPlaceMapOrThrow(int i);

        int getLackedNpcMapCount();

        boolean containsLackedNpcMap(int i);

        @Deprecated
        Map<Integer, Integer> getLackedNpcMap();

        Map<Integer, Integer> getLackedNpcMapMap();

        int getLackedNpcMapOrDefault(int i, int i2);

        int getLackedNpcMapOrThrow(int i);

        List<Integer> getLackedPlaceListList();

        int getLackedPlaceListCount();

        int getLackedPlaceList(int i);

        int getQuestId();

        int getRetcode();

        List<Integer> getLackedNpcListList();

        int getLackedNpcListCount();

        int getLackedNpcList(int i);
    }

    private GetQuestLackingResourceRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetQuestLackingResourceRspOuterClass$GetQuestLackingResourceRsp.class */
    public static final class GetQuestLackingResourceRsp extends GeneratedMessageV3 implements GetQuestLackingResourceRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LACKED_PLACE_MAP_FIELD_NUMBER = 2;
        private MapField<Integer, Integer> lackedPlaceMap_;
        public static final int LACKED_NPC_MAP_FIELD_NUMBER = 7;
        private MapField<Integer, Integer> lackedNpcMap_;
        public static final int LACKED_PLACE_LIST_FIELD_NUMBER = 11;
        private Internal.IntList lackedPlaceList_;
        private int lackedPlaceListMemoizedSerializedSize;
        public static final int QUEST_ID_FIELD_NUMBER = 3;
        private int questId_;
        public static final int RETCODE_FIELD_NUMBER = 6;
        private int retcode_;
        public static final int LACKED_NPC_LIST_FIELD_NUMBER = 14;
        private Internal.IntList lackedNpcList_;
        private int lackedNpcListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final GetQuestLackingResourceRsp DEFAULT_INSTANCE = new GetQuestLackingResourceRsp();
        private static final Parser<GetQuestLackingResourceRsp> PARSER = new AbstractParser<GetQuestLackingResourceRsp>() { // from class: emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRsp.1
            @Override // com.google.protobuf.Parser
            public GetQuestLackingResourceRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetQuestLackingResourceRsp(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRsp.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 2: goto L_0x001c;
                    case 7: goto L_0x0021;
                    default: goto L_0x0026;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetLackedPlaceMap()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetLackedNpcMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRsp.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private GetQuestLackingResourceRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.lackedPlaceListMemoizedSerializedSize = -1;
            this.lackedNpcListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GetQuestLackingResourceRsp() {
            this.lackedPlaceListMemoizedSerializedSize = -1;
            this.lackedNpcListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.lackedPlaceList_ = emptyIntList();
            this.lackedNpcList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetQuestLackingResourceRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:92:0x01fe */
        private GetQuestLackingResourceRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 18:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.lackedPlaceMap_ = MapField.newMapField(LackedPlaceMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Integer> lackedPlaceMap__ = (MapEntry) input.readMessage(LackedPlaceMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.lackedPlaceMap_.getMutableMap().put(lackedPlaceMap__.getKey(), lackedPlaceMap__.getValue());
                                break;
                            case 24:
                                this.questId_ = input.readUInt32();
                                break;
                            case 48:
                                this.retcode_ = input.readInt32();
                                break;
                            case 58:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.lackedNpcMap_ = MapField.newMapField(LackedNpcMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Integer> lackedNpcMap__ = (MapEntry) input.readMessage(LackedNpcMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.lackedNpcMap_.getMutableMap().put(lackedNpcMap__.getKey(), lackedNpcMap__.getValue());
                                break;
                            case 88:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.lackedPlaceList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.lackedPlaceList_.addInt(input.readUInt32());
                                break;
                            case 90:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.lackedPlaceList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.lackedPlaceList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 112:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.lackedNpcList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.lackedNpcList_.addInt(input.readUInt32());
                                break;
                            case 114:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 8) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.lackedNpcList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.lackedNpcList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
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
                if ((mutable_bitField0_ & 4) != 0) {
                    this.lackedPlaceList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.lackedNpcList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetQuestLackingResourceRspOuterClass.internal_static_GetQuestLackingResourceRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetQuestLackingResourceRspOuterClass.internal_static_GetQuestLackingResourceRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetQuestLackingResourceRsp.class, Builder.class);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetQuestLackingResourceRspOuterClass$GetQuestLackingResourceRsp$LackedPlaceMapDefaultEntryHolder.class */
        public static final class LackedPlaceMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(GetQuestLackingResourceRspOuterClass.f745x5d6a41f5, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private LackedPlaceMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetLackedPlaceMap() {
            if (this.lackedPlaceMap_ == null) {
                return MapField.emptyMapField(LackedPlaceMapDefaultEntryHolder.defaultEntry);
            }
            return this.lackedPlaceMap_;
        }

        @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
        public int getLackedPlaceMapCount() {
            return internalGetLackedPlaceMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
        public boolean containsLackedPlaceMap(int key) {
            return internalGetLackedPlaceMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
        @Deprecated
        public Map<Integer, Integer> getLackedPlaceMap() {
            return getLackedPlaceMapMap();
        }

        @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
        public Map<Integer, Integer> getLackedPlaceMapMap() {
            return internalGetLackedPlaceMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
        public int getLackedPlaceMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetLackedPlaceMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
        public int getLackedPlaceMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetLackedPlaceMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetQuestLackingResourceRspOuterClass$GetQuestLackingResourceRsp$LackedNpcMapDefaultEntryHolder.class */
        public static final class LackedNpcMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(GetQuestLackingResourceRspOuterClass.f747xfb45f6db, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private LackedNpcMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetLackedNpcMap() {
            if (this.lackedNpcMap_ == null) {
                return MapField.emptyMapField(LackedNpcMapDefaultEntryHolder.defaultEntry);
            }
            return this.lackedNpcMap_;
        }

        @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
        public int getLackedNpcMapCount() {
            return internalGetLackedNpcMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
        public boolean containsLackedNpcMap(int key) {
            return internalGetLackedNpcMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
        @Deprecated
        public Map<Integer, Integer> getLackedNpcMap() {
            return getLackedNpcMapMap();
        }

        @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
        public Map<Integer, Integer> getLackedNpcMapMap() {
            return internalGetLackedNpcMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
        public int getLackedNpcMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetLackedNpcMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
        public int getLackedNpcMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetLackedNpcMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
        public List<Integer> getLackedPlaceListList() {
            return this.lackedPlaceList_;
        }

        @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
        public int getLackedPlaceListCount() {
            return this.lackedPlaceList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
        public int getLackedPlaceList(int index) {
            return this.lackedPlaceList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
        public int getQuestId() {
            return this.questId_;
        }

        @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
        public List<Integer> getLackedNpcListList() {
            return this.lackedNpcList_;
        }

        @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
        public int getLackedNpcListCount() {
            return this.lackedNpcList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
        public int getLackedNpcList(int index) {
            return this.lackedNpcList_.getInt(index);
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
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetLackedPlaceMap(), LackedPlaceMapDefaultEntryHolder.defaultEntry, 2);
            if (this.questId_ != 0) {
                output.writeUInt32(3, this.questId_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(6, this.retcode_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetLackedNpcMap(), LackedNpcMapDefaultEntryHolder.defaultEntry, 7);
            if (getLackedPlaceListList().size() > 0) {
                output.writeUInt32NoTag(90);
                output.writeUInt32NoTag(this.lackedPlaceListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.lackedPlaceList_.size(); i++) {
                output.writeUInt32NoTag(this.lackedPlaceList_.getInt(i));
            }
            if (getLackedNpcListList().size() > 0) {
                output.writeUInt32NoTag(114);
                output.writeUInt32NoTag(this.lackedNpcListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.lackedNpcList_.size(); i2++) {
                output.writeUInt32NoTag(this.lackedNpcList_.getInt(i2));
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
            for (Map.Entry<Integer, Integer> entry : internalGetLackedPlaceMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(2, LackedPlaceMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.questId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.questId_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(6, this.retcode_);
            }
            for (Map.Entry<Integer, Integer> entry2 : internalGetLackedNpcMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(7, LackedNpcMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            int dataSize = 0;
            for (int i = 0; i < this.lackedPlaceList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.lackedPlaceList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getLackedPlaceListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.lackedPlaceListMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.lackedNpcList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.lackedNpcList_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getLackedNpcListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.lackedNpcListMemoizedSerializedSize = dataSize2;
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GetQuestLackingResourceRsp)) {
                return equals(obj);
            }
            GetQuestLackingResourceRsp other = (GetQuestLackingResourceRsp) obj;
            return internalGetLackedPlaceMap().equals(other.internalGetLackedPlaceMap()) && internalGetLackedNpcMap().equals(other.internalGetLackedNpcMap()) && getLackedPlaceListList().equals(other.getLackedPlaceListList()) && getQuestId() == other.getQuestId() && getRetcode() == other.getRetcode() && getLackedNpcListList().equals(other.getLackedNpcListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (!internalGetLackedPlaceMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 2)) + internalGetLackedPlaceMap().hashCode();
            }
            if (!internalGetLackedNpcMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 7)) + internalGetLackedNpcMap().hashCode();
            }
            if (getLackedPlaceListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getLackedPlaceListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * hash) + 3)) + getQuestId())) + 6)) + getRetcode();
            if (getLackedNpcListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 14)) + getLackedNpcListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static GetQuestLackingResourceRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetQuestLackingResourceRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetQuestLackingResourceRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetQuestLackingResourceRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetQuestLackingResourceRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetQuestLackingResourceRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetQuestLackingResourceRsp parseFrom(InputStream input) throws IOException {
            return (GetQuestLackingResourceRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetQuestLackingResourceRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetQuestLackingResourceRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetQuestLackingResourceRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetQuestLackingResourceRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetQuestLackingResourceRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetQuestLackingResourceRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetQuestLackingResourceRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetQuestLackingResourceRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetQuestLackingResourceRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetQuestLackingResourceRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetQuestLackingResourceRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetQuestLackingResourceRspOuterClass$GetQuestLackingResourceRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetQuestLackingResourceRspOrBuilder {
            private int bitField0_;
            private MapField<Integer, Integer> lackedPlaceMap_;
            private MapField<Integer, Integer> lackedNpcMap_;
            private int questId_;
            private int retcode_;
            private Internal.IntList lackedPlaceList_ = GetQuestLackingResourceRsp.emptyIntList();
            private Internal.IntList lackedNpcList_ = GetQuestLackingResourceRsp.emptyIntList();

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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRsp.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 2: goto L_0x001c;
                        case 7: goto L_0x0021;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetLackedPlaceMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetLackedNpcMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRsp.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRsp.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 2: goto L_0x001c;
                        case 7: goto L_0x0021;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableLackedPlaceMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableLackedNpcMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRsp.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return GetQuestLackingResourceRspOuterClass.internal_static_GetQuestLackingResourceRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetQuestLackingResourceRspOuterClass.internal_static_GetQuestLackingResourceRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetQuestLackingResourceRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetQuestLackingResourceRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                internalGetMutableLackedPlaceMap().clear();
                internalGetMutableLackedNpcMap().clear();
                this.lackedPlaceList_ = GetQuestLackingResourceRsp.emptyIntList();
                this.bitField0_ &= -5;
                this.questId_ = 0;
                this.retcode_ = 0;
                this.lackedNpcList_ = GetQuestLackingResourceRsp.emptyIntList();
                this.bitField0_ &= -9;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetQuestLackingResourceRspOuterClass.internal_static_GetQuestLackingResourceRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetQuestLackingResourceRsp getDefaultInstanceForType() {
                return GetQuestLackingResourceRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetQuestLackingResourceRsp build() {
                GetQuestLackingResourceRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetQuestLackingResourceRsp buildPartial() {
                GetQuestLackingResourceRsp result = new GetQuestLackingResourceRsp(this);
                int i = this.bitField0_;
                result.lackedPlaceMap_ = internalGetLackedPlaceMap();
                result.lackedPlaceMap_.makeImmutable();
                result.lackedNpcMap_ = internalGetLackedNpcMap();
                result.lackedNpcMap_.makeImmutable();
                if ((this.bitField0_ & 4) != 0) {
                    this.lackedPlaceList_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.lackedPlaceList_ = this.lackedPlaceList_;
                result.questId_ = this.questId_;
                result.retcode_ = this.retcode_;
                if ((this.bitField0_ & 8) != 0) {
                    this.lackedNpcList_.makeImmutable();
                    this.bitField0_ &= -9;
                }
                result.lackedNpcList_ = this.lackedNpcList_;
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
                if (other instanceof GetQuestLackingResourceRsp) {
                    return mergeFrom((GetQuestLackingResourceRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetQuestLackingResourceRsp other) {
                if (other == GetQuestLackingResourceRsp.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableLackedPlaceMap().mergeFrom(other.internalGetLackedPlaceMap());
                internalGetMutableLackedNpcMap().mergeFrom(other.internalGetLackedNpcMap());
                if (!other.lackedPlaceList_.isEmpty()) {
                    if (this.lackedPlaceList_.isEmpty()) {
                        this.lackedPlaceList_ = other.lackedPlaceList_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureLackedPlaceListIsMutable();
                        this.lackedPlaceList_.addAll(other.lackedPlaceList_);
                    }
                    onChanged();
                }
                if (other.getQuestId() != 0) {
                    setQuestId(other.getQuestId());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (!other.lackedNpcList_.isEmpty()) {
                    if (this.lackedNpcList_.isEmpty()) {
                        this.lackedNpcList_ = other.lackedNpcList_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureLackedNpcListIsMutable();
                        this.lackedNpcList_.addAll(other.lackedNpcList_);
                    }
                    onChanged();
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
                GetQuestLackingResourceRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetQuestLackingResourceRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetQuestLackingResourceRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private MapField<Integer, Integer> internalGetLackedPlaceMap() {
                if (this.lackedPlaceMap_ == null) {
                    return MapField.emptyMapField(LackedPlaceMapDefaultEntryHolder.defaultEntry);
                }
                return this.lackedPlaceMap_;
            }

            private MapField<Integer, Integer> internalGetMutableLackedPlaceMap() {
                onChanged();
                if (this.lackedPlaceMap_ == null) {
                    this.lackedPlaceMap_ = MapField.newMapField(LackedPlaceMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.lackedPlaceMap_.isMutable()) {
                    this.lackedPlaceMap_ = this.lackedPlaceMap_.copy();
                }
                return this.lackedPlaceMap_;
            }

            @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
            public int getLackedPlaceMapCount() {
                return internalGetLackedPlaceMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
            public boolean containsLackedPlaceMap(int key) {
                return internalGetLackedPlaceMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
            @Deprecated
            public Map<Integer, Integer> getLackedPlaceMap() {
                return getLackedPlaceMapMap();
            }

            @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
            public Map<Integer, Integer> getLackedPlaceMapMap() {
                return internalGetLackedPlaceMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
            public int getLackedPlaceMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetLackedPlaceMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
            public int getLackedPlaceMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetLackedPlaceMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearLackedPlaceMap() {
                internalGetMutableLackedPlaceMap().getMutableMap().clear();
                return this;
            }

            public Builder removeLackedPlaceMap(int key) {
                internalGetMutableLackedPlaceMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableLackedPlaceMap() {
                return internalGetMutableLackedPlaceMap().getMutableMap();
            }

            public Builder putLackedPlaceMap(int key, int value) {
                internalGetMutableLackedPlaceMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllLackedPlaceMap(Map<Integer, Integer> values) {
                internalGetMutableLackedPlaceMap().getMutableMap().putAll(values);
                return this;
            }

            private MapField<Integer, Integer> internalGetLackedNpcMap() {
                if (this.lackedNpcMap_ == null) {
                    return MapField.emptyMapField(LackedNpcMapDefaultEntryHolder.defaultEntry);
                }
                return this.lackedNpcMap_;
            }

            private MapField<Integer, Integer> internalGetMutableLackedNpcMap() {
                onChanged();
                if (this.lackedNpcMap_ == null) {
                    this.lackedNpcMap_ = MapField.newMapField(LackedNpcMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.lackedNpcMap_.isMutable()) {
                    this.lackedNpcMap_ = this.lackedNpcMap_.copy();
                }
                return this.lackedNpcMap_;
            }

            @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
            public int getLackedNpcMapCount() {
                return internalGetLackedNpcMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
            public boolean containsLackedNpcMap(int key) {
                return internalGetLackedNpcMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
            @Deprecated
            public Map<Integer, Integer> getLackedNpcMap() {
                return getLackedNpcMapMap();
            }

            @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
            public Map<Integer, Integer> getLackedNpcMapMap() {
                return internalGetLackedNpcMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
            public int getLackedNpcMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetLackedNpcMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
            public int getLackedNpcMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetLackedNpcMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearLackedNpcMap() {
                internalGetMutableLackedNpcMap().getMutableMap().clear();
                return this;
            }

            public Builder removeLackedNpcMap(int key) {
                internalGetMutableLackedNpcMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableLackedNpcMap() {
                return internalGetMutableLackedNpcMap().getMutableMap();
            }

            public Builder putLackedNpcMap(int key, int value) {
                internalGetMutableLackedNpcMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllLackedNpcMap(Map<Integer, Integer> values) {
                internalGetMutableLackedNpcMap().getMutableMap().putAll(values);
                return this;
            }

            private void ensureLackedPlaceListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.lackedPlaceList_ = GetQuestLackingResourceRsp.mutableCopy(this.lackedPlaceList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
            public List<Integer> getLackedPlaceListList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.lackedPlaceList_) : this.lackedPlaceList_;
            }

            @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
            public int getLackedPlaceListCount() {
                return this.lackedPlaceList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
            public int getLackedPlaceList(int index) {
                return this.lackedPlaceList_.getInt(index);
            }

            public Builder setLackedPlaceList(int index, int value) {
                ensureLackedPlaceListIsMutable();
                this.lackedPlaceList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addLackedPlaceList(int value) {
                ensureLackedPlaceListIsMutable();
                this.lackedPlaceList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllLackedPlaceList(Iterable<? extends Integer> values) {
                ensureLackedPlaceListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.lackedPlaceList_);
                onChanged();
                return this;
            }

            public Builder clearLackedPlaceList() {
                this.lackedPlaceList_ = GetQuestLackingResourceRsp.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
            public int getQuestId() {
                return this.questId_;
            }

            public Builder setQuestId(int value) {
                this.questId_ = value;
                onChanged();
                return this;
            }

            public Builder clearQuestId() {
                this.questId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
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

            private void ensureLackedNpcListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.lackedNpcList_ = GetQuestLackingResourceRsp.mutableCopy(this.lackedNpcList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
            public List<Integer> getLackedNpcListList() {
                return (this.bitField0_ & 8) != 0 ? Collections.unmodifiableList(this.lackedNpcList_) : this.lackedNpcList_;
            }

            @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
            public int getLackedNpcListCount() {
                return this.lackedNpcList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetQuestLackingResourceRspOuterClass.GetQuestLackingResourceRspOrBuilder
            public int getLackedNpcList(int index) {
                return this.lackedNpcList_.getInt(index);
            }

            public Builder setLackedNpcList(int index, int value) {
                ensureLackedNpcListIsMutable();
                this.lackedNpcList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addLackedNpcList(int value) {
                ensureLackedNpcListIsMutable();
                this.lackedNpcList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllLackedNpcList(Iterable<? extends Integer> values) {
                ensureLackedNpcListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.lackedNpcList_);
                onChanged();
                return this;
            }

            public Builder clearLackedNpcList() {
                this.lackedNpcList_ = GetQuestLackingResourceRsp.emptyIntList();
                this.bitField0_ &= -9;
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

        public static GetQuestLackingResourceRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetQuestLackingResourceRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetQuestLackingResourceRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetQuestLackingResourceRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
