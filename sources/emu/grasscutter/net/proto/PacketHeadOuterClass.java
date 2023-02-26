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
import emu.grasscutter.net.packet.PacketOpcodes;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PacketHeadOuterClass.class */
public final class PacketHeadOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010PacketHead.proto\"È\u0004\n\nPacketHead\u0012\u0011\n\tpacket_id\u0018\u0001 \u0001(\r\u0012\u000e\n\u0006rpc_id\u0018\u0002 \u0001(\r\u0012\u001a\n\u0012client_sequence_id\u0018\u0003 \u0001(\r\u0012\u0017\n\u000fenet_channel_id\u0018\u0004 \u0001(\r\u0012\u0018\n\u0010enet_is_reliable\u0018\u0005 \u0001(\r\u0012\u000f\n\u0007sent_ms\u0018\u0006 \u0001(\u0004\u0012\u000f\n\u0007user_id\u0018\u000b \u0001(\r\u0012\u000f\n\u0007user_ip\u0018\f \u0001(\r\u0012\u0017\n\u000fuser_session_id\u0018\r \u0001(\r\u0012\u0014\n\frecv_time_ms\u0018\u0015 \u0001(\u0004\u0012\u0019\n\u0011rpc_begin_time_ms\u0018\u0016 \u0001(\r\u0012(\n\u0007ext_map\u0018\u0017 \u0003(\u000b2\u0017.PacketHead.ExtMapEntry\u0012\u0015\n\rsender_app_id\u0018\u0018 \u0001(\r\u0012\u0016\n\u000esource_service\u0018\u001f \u0001(\r\u0012\u0016\n\u000etarget_service\u0018  \u0001(\r\u0012<\n\u0012service_app_id_map\u0018! \u0003(\u000b2 .PacketHead.ServiceAppIdMapEntry\u0012\u001a\n\u0012is_set_game_thread\u0018\" \u0001(\b\u0012\u0019\n\u0011game_thread_index\u0018# \u0001(\r\u001a-\n\u000bExtMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001\u001a6\n\u0014ServiceAppIdMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PacketHead_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PacketHead_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PacketHead_descriptor, new String[]{"PacketId", "RpcId", "ClientSequenceId", "EnetChannelId", "EnetIsReliable", "SentMs", "UserId", "UserIp", "UserSessionId", "RecvTimeMs", "RpcBeginTimeMs", "ExtMap", "SenderAppId", "SourceService", "TargetService", "ServiceAppIdMap", "IsSetGameThread", "GameThreadIndex"});
    private static final Descriptors.Descriptor internal_static_PacketHead_ExtMapEntry_descriptor = internal_static_PacketHead_descriptor.getNestedTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PacketHead_ExtMapEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PacketHead_ExtMapEntry_descriptor, new String[]{"Key", "Value"});
    private static final Descriptors.Descriptor internal_static_PacketHead_ServiceAppIdMapEntry_descriptor = internal_static_PacketHead_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_PacketHead_ServiceAppIdMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f799x49e14327 = new GeneratedMessageV3.FieldAccessorTable(internal_static_PacketHead_ServiceAppIdMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PacketHeadOuterClass$PacketHeadOrBuilder.class */
    public interface PacketHeadOrBuilder extends MessageOrBuilder {
        int getPacketId();

        int getRpcId();

        int getClientSequenceId();

        int getEnetChannelId();

        int getEnetIsReliable();

        long getSentMs();

        int getUserId();

        int getUserIp();

        int getUserSessionId();

        long getRecvTimeMs();

        int getRpcBeginTimeMs();

        int getExtMapCount();

        boolean containsExtMap(int i);

        @Deprecated
        Map<Integer, Integer> getExtMap();

        Map<Integer, Integer> getExtMapMap();

        int getExtMapOrDefault(int i, int i2);

        int getExtMapOrThrow(int i);

        int getSenderAppId();

        int getSourceService();

        int getTargetService();

        int getServiceAppIdMapCount();

        boolean containsServiceAppIdMap(int i);

        @Deprecated
        Map<Integer, Integer> getServiceAppIdMap();

        Map<Integer, Integer> getServiceAppIdMapMap();

        int getServiceAppIdMapOrDefault(int i, int i2);

        int getServiceAppIdMapOrThrow(int i);

        boolean getIsSetGameThread();

        int getGameThreadIndex();
    }

    private PacketHeadOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PacketHeadOuterClass$PacketHead.class */
    public static final class PacketHead extends GeneratedMessageV3 implements PacketHeadOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PACKET_ID_FIELD_NUMBER = 1;
        private int packetId_;
        public static final int RPC_ID_FIELD_NUMBER = 2;
        private int rpcId_;
        public static final int CLIENT_SEQUENCE_ID_FIELD_NUMBER = 3;
        private int clientSequenceId_;
        public static final int ENET_CHANNEL_ID_FIELD_NUMBER = 4;
        private int enetChannelId_;
        public static final int ENET_IS_RELIABLE_FIELD_NUMBER = 5;
        private int enetIsReliable_;
        public static final int SENT_MS_FIELD_NUMBER = 6;
        private long sentMs_;
        public static final int USER_ID_FIELD_NUMBER = 11;
        private int userId_;
        public static final int USER_IP_FIELD_NUMBER = 12;
        private int userIp_;
        public static final int USER_SESSION_ID_FIELD_NUMBER = 13;
        private int userSessionId_;
        public static final int RECV_TIME_MS_FIELD_NUMBER = 21;
        private long recvTimeMs_;
        public static final int RPC_BEGIN_TIME_MS_FIELD_NUMBER = 22;
        private int rpcBeginTimeMs_;
        public static final int EXT_MAP_FIELD_NUMBER = 23;
        private MapField<Integer, Integer> extMap_;
        public static final int SENDER_APP_ID_FIELD_NUMBER = 24;
        private int senderAppId_;
        public static final int SOURCE_SERVICE_FIELD_NUMBER = 31;
        private int sourceService_;
        public static final int TARGET_SERVICE_FIELD_NUMBER = 32;
        private int targetService_;
        public static final int SERVICE_APP_ID_MAP_FIELD_NUMBER = 33;
        private MapField<Integer, Integer> serviceAppIdMap_;
        public static final int IS_SET_GAME_THREAD_FIELD_NUMBER = 34;
        private boolean isSetGameThread_;
        public static final int GAME_THREAD_INDEX_FIELD_NUMBER = 35;
        private int gameThreadIndex_;
        private byte memoizedIsInitialized;
        private static final PacketHead DEFAULT_INSTANCE = new PacketHead();
        private static final Parser<PacketHead> PARSER = new AbstractParser<PacketHead>() { // from class: emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHead.1
            @Override // com.google.protobuf.Parser
            public PacketHead parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PacketHead(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHead.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 23: goto L_0x001c;
                    case 33: goto L_0x0021;
                    default: goto L_0x0026;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetExtMap()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetServiceAppIdMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHead.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private PacketHead(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PacketHead() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PacketHead();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PacketHead(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.packetId_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.rpcId_ = input.readUInt32();
                                    break;
                                case 24:
                                    this.clientSequenceId_ = input.readUInt32();
                                    break;
                                case 32:
                                    this.enetChannelId_ = input.readUInt32();
                                    break;
                                case 40:
                                    this.enetIsReliable_ = input.readUInt32();
                                    break;
                                case 48:
                                    this.sentMs_ = input.readUInt64();
                                    break;
                                case 88:
                                    this.userId_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.userIp_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.userSessionId_ = input.readUInt32();
                                    break;
                                case 168:
                                    this.recvTimeMs_ = input.readUInt64();
                                    break;
                                case 176:
                                    this.rpcBeginTimeMs_ = input.readUInt32();
                                    break;
                                case 186:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.extMap_ = MapField.newMapField(ExtMapDefaultEntryHolder.defaultEntry);
                                        mutable_bitField0_ |= 1;
                                    }
                                    MapEntry<Integer, Integer> extMap__ = (MapEntry) input.readMessage(ExtMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                    this.extMap_.getMutableMap().put(extMap__.getKey(), extMap__.getValue());
                                    break;
                                case 192:
                                    this.senderAppId_ = input.readUInt32();
                                    break;
                                case PacketOpcodes.EnterSceneDoneReq:
                                    this.sourceService_ = input.readUInt32();
                                    break;
                                case 256:
                                    this.targetService_ = input.readUInt32();
                                    break;
                                case PacketOpcodes.SetSceneWeatherAreaRsp:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.serviceAppIdMap_ = MapField.newMapField(ServiceAppIdMapDefaultEntryHolder.defaultEntry);
                                        mutable_bitField0_ |= 2;
                                    }
                                    MapEntry<Integer, Integer> serviceAppIdMap__ = (MapEntry) input.readMessage(ServiceAppIdMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                    this.serviceAppIdMap_.getMutableMap().put(serviceAppIdMap__.getKey(), serviceAppIdMap__.getValue());
                                    break;
                                case PacketOpcodes.HitClientTrivialNotify:
                                    this.isSetGameThread_ = input.readBool();
                                    break;
                                case PacketOpcodes.SceneEntityDisappearNotify:
                                    this.gameThreadIndex_ = input.readUInt32();
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
            return PacketHeadOuterClass.internal_static_PacketHead_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PacketHeadOuterClass.internal_static_PacketHead_fieldAccessorTable.ensureFieldAccessorsInitialized(PacketHead.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public int getPacketId() {
            return this.packetId_;
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public int getRpcId() {
            return this.rpcId_;
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public int getClientSequenceId() {
            return this.clientSequenceId_;
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public int getEnetChannelId() {
            return this.enetChannelId_;
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public int getEnetIsReliable() {
            return this.enetIsReliable_;
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public long getSentMs() {
            return this.sentMs_;
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public int getUserId() {
            return this.userId_;
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public int getUserIp() {
            return this.userIp_;
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public int getUserSessionId() {
            return this.userSessionId_;
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public long getRecvTimeMs() {
            return this.recvTimeMs_;
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public int getRpcBeginTimeMs() {
            return this.rpcBeginTimeMs_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PacketHeadOuterClass$PacketHead$ExtMapDefaultEntryHolder.class */
        public static final class ExtMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(PacketHeadOuterClass.internal_static_PacketHead_ExtMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private ExtMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetExtMap() {
            if (this.extMap_ == null) {
                return MapField.emptyMapField(ExtMapDefaultEntryHolder.defaultEntry);
            }
            return this.extMap_;
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public int getExtMapCount() {
            return internalGetExtMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public boolean containsExtMap(int key) {
            return internalGetExtMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        @Deprecated
        public Map<Integer, Integer> getExtMap() {
            return getExtMapMap();
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public Map<Integer, Integer> getExtMapMap() {
            return internalGetExtMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public int getExtMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetExtMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public int getExtMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetExtMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public int getSenderAppId() {
            return this.senderAppId_;
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public int getSourceService() {
            return this.sourceService_;
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public int getTargetService() {
            return this.targetService_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PacketHeadOuterClass$PacketHead$ServiceAppIdMapDefaultEntryHolder.class */
        public static final class ServiceAppIdMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(PacketHeadOuterClass.internal_static_PacketHead_ServiceAppIdMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private ServiceAppIdMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetServiceAppIdMap() {
            if (this.serviceAppIdMap_ == null) {
                return MapField.emptyMapField(ServiceAppIdMapDefaultEntryHolder.defaultEntry);
            }
            return this.serviceAppIdMap_;
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public int getServiceAppIdMapCount() {
            return internalGetServiceAppIdMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public boolean containsServiceAppIdMap(int key) {
            return internalGetServiceAppIdMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        @Deprecated
        public Map<Integer, Integer> getServiceAppIdMap() {
            return getServiceAppIdMapMap();
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public Map<Integer, Integer> getServiceAppIdMapMap() {
            return internalGetServiceAppIdMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public int getServiceAppIdMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetServiceAppIdMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public int getServiceAppIdMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetServiceAppIdMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public boolean getIsSetGameThread() {
            return this.isSetGameThread_;
        }

        @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
        public int getGameThreadIndex() {
            return this.gameThreadIndex_;
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
            if (this.packetId_ != 0) {
                output.writeUInt32(1, this.packetId_);
            }
            if (this.rpcId_ != 0) {
                output.writeUInt32(2, this.rpcId_);
            }
            if (this.clientSequenceId_ != 0) {
                output.writeUInt32(3, this.clientSequenceId_);
            }
            if (this.enetChannelId_ != 0) {
                output.writeUInt32(4, this.enetChannelId_);
            }
            if (this.enetIsReliable_ != 0) {
                output.writeUInt32(5, this.enetIsReliable_);
            }
            if (this.sentMs_ != 0) {
                output.writeUInt64(6, this.sentMs_);
            }
            if (this.userId_ != 0) {
                output.writeUInt32(11, this.userId_);
            }
            if (this.userIp_ != 0) {
                output.writeUInt32(12, this.userIp_);
            }
            if (this.userSessionId_ != 0) {
                output.writeUInt32(13, this.userSessionId_);
            }
            if (this.recvTimeMs_ != 0) {
                output.writeUInt64(21, this.recvTimeMs_);
            }
            if (this.rpcBeginTimeMs_ != 0) {
                output.writeUInt32(22, this.rpcBeginTimeMs_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetExtMap(), ExtMapDefaultEntryHolder.defaultEntry, 23);
            if (this.senderAppId_ != 0) {
                output.writeUInt32(24, this.senderAppId_);
            }
            if (this.sourceService_ != 0) {
                output.writeUInt32(31, this.sourceService_);
            }
            if (this.targetService_ != 0) {
                output.writeUInt32(32, this.targetService_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetServiceAppIdMap(), ServiceAppIdMapDefaultEntryHolder.defaultEntry, 33);
            if (this.isSetGameThread_) {
                output.writeBool(34, this.isSetGameThread_);
            }
            if (this.gameThreadIndex_ != 0) {
                output.writeUInt32(35, this.gameThreadIndex_);
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
            if (this.packetId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.packetId_);
            }
            if (this.rpcId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.rpcId_);
            }
            if (this.clientSequenceId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.clientSequenceId_);
            }
            if (this.enetChannelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.enetChannelId_);
            }
            if (this.enetIsReliable_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.enetIsReliable_);
            }
            if (this.sentMs_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(6, this.sentMs_);
            }
            if (this.userId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.userId_);
            }
            if (this.userIp_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.userIp_);
            }
            if (this.userSessionId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.userSessionId_);
            }
            if (this.recvTimeMs_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(21, this.recvTimeMs_);
            }
            if (this.rpcBeginTimeMs_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(22, this.rpcBeginTimeMs_);
            }
            for (Map.Entry<Integer, Integer> entry : internalGetExtMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(23, ExtMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.senderAppId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(24, this.senderAppId_);
            }
            if (this.sourceService_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(31, this.sourceService_);
            }
            if (this.targetService_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(32, this.targetService_);
            }
            for (Map.Entry<Integer, Integer> entry2 : internalGetServiceAppIdMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(33, ServiceAppIdMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            if (this.isSetGameThread_) {
                size2 += CodedOutputStream.computeBoolSize(34, this.isSetGameThread_);
            }
            if (this.gameThreadIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(35, this.gameThreadIndex_);
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
            if (!(obj instanceof PacketHead)) {
                return equals(obj);
            }
            PacketHead other = (PacketHead) obj;
            return getPacketId() == other.getPacketId() && getRpcId() == other.getRpcId() && getClientSequenceId() == other.getClientSequenceId() && getEnetChannelId() == other.getEnetChannelId() && getEnetIsReliable() == other.getEnetIsReliable() && getSentMs() == other.getSentMs() && getUserId() == other.getUserId() && getUserIp() == other.getUserIp() && getUserSessionId() == other.getUserSessionId() && getRecvTimeMs() == other.getRecvTimeMs() && getRpcBeginTimeMs() == other.getRpcBeginTimeMs() && internalGetExtMap().equals(other.internalGetExtMap()) && getSenderAppId() == other.getSenderAppId() && getSourceService() == other.getSourceService() && getTargetService() == other.getTargetService() && internalGetServiceAppIdMap().equals(other.internalGetServiceAppIdMap()) && getIsSetGameThread() == other.getIsSetGameThread() && getGameThreadIndex() == other.getGameThreadIndex() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getPacketId())) + 2)) + getRpcId())) + 3)) + getClientSequenceId())) + 4)) + getEnetChannelId())) + 5)) + getEnetIsReliable())) + 6)) + Internal.hashLong(getSentMs()))) + 11)) + getUserId())) + 12)) + getUserIp())) + 13)) + getUserSessionId())) + 21)) + Internal.hashLong(getRecvTimeMs()))) + 22)) + getRpcBeginTimeMs();
            if (!internalGetExtMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 23)) + internalGetExtMap().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 24)) + getSenderAppId())) + 31)) + getSourceService())) + 32)) + getTargetService();
            if (!internalGetServiceAppIdMap().getMap().isEmpty()) {
                hash2 = (53 * ((37 * hash2) + 33)) + internalGetServiceAppIdMap().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * ((53 * ((37 * hash2) + 34)) + Internal.hashBoolean(getIsSetGameThread()))) + 35)) + getGameThreadIndex())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static PacketHead parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PacketHead parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PacketHead parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PacketHead parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PacketHead parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PacketHead parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PacketHead parseFrom(InputStream input) throws IOException {
            return (PacketHead) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PacketHead parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PacketHead) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PacketHead parseDelimitedFrom(InputStream input) throws IOException {
            return (PacketHead) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PacketHead parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PacketHead) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PacketHead parseFrom(CodedInputStream input) throws IOException {
            return (PacketHead) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PacketHead parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PacketHead) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PacketHead prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PacketHeadOuterClass$PacketHead$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PacketHeadOrBuilder {
            private int bitField0_;
            private int packetId_;
            private int rpcId_;
            private int clientSequenceId_;
            private int enetChannelId_;
            private int enetIsReliable_;
            private long sentMs_;
            private int userId_;
            private int userIp_;
            private int userSessionId_;
            private long recvTimeMs_;
            private int rpcBeginTimeMs_;
            private MapField<Integer, Integer> extMap_;
            private int senderAppId_;
            private int sourceService_;
            private int targetService_;
            private MapField<Integer, Integer> serviceAppIdMap_;
            private boolean isSetGameThread_;
            private int gameThreadIndex_;

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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHead.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 23: goto L_0x001c;
                        case 33: goto L_0x0021;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetExtMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetServiceAppIdMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHead.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHead.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 23: goto L_0x001c;
                        case 33: goto L_0x0021;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableExtMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableServiceAppIdMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHead.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PacketHeadOuterClass.internal_static_PacketHead_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PacketHeadOuterClass.internal_static_PacketHead_fieldAccessorTable.ensureFieldAccessorsInitialized(PacketHead.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PacketHead.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.packetId_ = 0;
                this.rpcId_ = 0;
                this.clientSequenceId_ = 0;
                this.enetChannelId_ = 0;
                this.enetIsReliable_ = 0;
                this.sentMs_ = 0;
                this.userId_ = 0;
                this.userIp_ = 0;
                this.userSessionId_ = 0;
                this.recvTimeMs_ = 0;
                this.rpcBeginTimeMs_ = 0;
                internalGetMutableExtMap().clear();
                this.senderAppId_ = 0;
                this.sourceService_ = 0;
                this.targetService_ = 0;
                internalGetMutableServiceAppIdMap().clear();
                this.isSetGameThread_ = false;
                this.gameThreadIndex_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PacketHeadOuterClass.internal_static_PacketHead_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PacketHead getDefaultInstanceForType() {
                return PacketHead.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PacketHead build() {
                PacketHead result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PacketHead buildPartial() {
                PacketHead result = new PacketHead(this);
                int i = this.bitField0_;
                result.packetId_ = this.packetId_;
                result.rpcId_ = this.rpcId_;
                result.clientSequenceId_ = this.clientSequenceId_;
                result.enetChannelId_ = this.enetChannelId_;
                result.enetIsReliable_ = this.enetIsReliable_;
                result.sentMs_ = this.sentMs_;
                result.userId_ = this.userId_;
                result.userIp_ = this.userIp_;
                result.userSessionId_ = this.userSessionId_;
                result.recvTimeMs_ = this.recvTimeMs_;
                result.rpcBeginTimeMs_ = this.rpcBeginTimeMs_;
                result.extMap_ = internalGetExtMap();
                result.extMap_.makeImmutable();
                result.senderAppId_ = this.senderAppId_;
                result.sourceService_ = this.sourceService_;
                result.targetService_ = this.targetService_;
                result.serviceAppIdMap_ = internalGetServiceAppIdMap();
                result.serviceAppIdMap_.makeImmutable();
                result.isSetGameThread_ = this.isSetGameThread_;
                result.gameThreadIndex_ = this.gameThreadIndex_;
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
                if (other instanceof PacketHead) {
                    return mergeFrom((PacketHead) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PacketHead other) {
                if (other == PacketHead.getDefaultInstance()) {
                    return this;
                }
                if (other.getPacketId() != 0) {
                    setPacketId(other.getPacketId());
                }
                if (other.getRpcId() != 0) {
                    setRpcId(other.getRpcId());
                }
                if (other.getClientSequenceId() != 0) {
                    setClientSequenceId(other.getClientSequenceId());
                }
                if (other.getEnetChannelId() != 0) {
                    setEnetChannelId(other.getEnetChannelId());
                }
                if (other.getEnetIsReliable() != 0) {
                    setEnetIsReliable(other.getEnetIsReliable());
                }
                if (other.getSentMs() != 0) {
                    setSentMs(other.getSentMs());
                }
                if (other.getUserId() != 0) {
                    setUserId(other.getUserId());
                }
                if (other.getUserIp() != 0) {
                    setUserIp(other.getUserIp());
                }
                if (other.getUserSessionId() != 0) {
                    setUserSessionId(other.getUserSessionId());
                }
                if (other.getRecvTimeMs() != 0) {
                    setRecvTimeMs(other.getRecvTimeMs());
                }
                if (other.getRpcBeginTimeMs() != 0) {
                    setRpcBeginTimeMs(other.getRpcBeginTimeMs());
                }
                internalGetMutableExtMap().mergeFrom(other.internalGetExtMap());
                if (other.getSenderAppId() != 0) {
                    setSenderAppId(other.getSenderAppId());
                }
                if (other.getSourceService() != 0) {
                    setSourceService(other.getSourceService());
                }
                if (other.getTargetService() != 0) {
                    setTargetService(other.getTargetService());
                }
                internalGetMutableServiceAppIdMap().mergeFrom(other.internalGetServiceAppIdMap());
                if (other.getIsSetGameThread()) {
                    setIsSetGameThread(other.getIsSetGameThread());
                }
                if (other.getGameThreadIndex() != 0) {
                    setGameThreadIndex(other.getGameThreadIndex());
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
                PacketHead parsedMessage = null;
                try {
                    try {
                        parsedMessage = PacketHead.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PacketHead) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public int getPacketId() {
                return this.packetId_;
            }

            public Builder setPacketId(int value) {
                this.packetId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPacketId() {
                this.packetId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public int getRpcId() {
                return this.rpcId_;
            }

            public Builder setRpcId(int value) {
                this.rpcId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRpcId() {
                this.rpcId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public int getClientSequenceId() {
                return this.clientSequenceId_;
            }

            public Builder setClientSequenceId(int value) {
                this.clientSequenceId_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientSequenceId() {
                this.clientSequenceId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public int getEnetChannelId() {
                return this.enetChannelId_;
            }

            public Builder setEnetChannelId(int value) {
                this.enetChannelId_ = value;
                onChanged();
                return this;
            }

            public Builder clearEnetChannelId() {
                this.enetChannelId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public int getEnetIsReliable() {
                return this.enetIsReliable_;
            }

            public Builder setEnetIsReliable(int value) {
                this.enetIsReliable_ = value;
                onChanged();
                return this;
            }

            public Builder clearEnetIsReliable() {
                this.enetIsReliable_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public long getSentMs() {
                return this.sentMs_;
            }

            public Builder setSentMs(long value) {
                this.sentMs_ = value;
                onChanged();
                return this;
            }

            public Builder clearSentMs() {
                this.sentMs_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public int getUserId() {
                return this.userId_;
            }

            public Builder setUserId(int value) {
                this.userId_ = value;
                onChanged();
                return this;
            }

            public Builder clearUserId() {
                this.userId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public int getUserIp() {
                return this.userIp_;
            }

            public Builder setUserIp(int value) {
                this.userIp_ = value;
                onChanged();
                return this;
            }

            public Builder clearUserIp() {
                this.userIp_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public int getUserSessionId() {
                return this.userSessionId_;
            }

            public Builder setUserSessionId(int value) {
                this.userSessionId_ = value;
                onChanged();
                return this;
            }

            public Builder clearUserSessionId() {
                this.userSessionId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public long getRecvTimeMs() {
                return this.recvTimeMs_;
            }

            public Builder setRecvTimeMs(long value) {
                this.recvTimeMs_ = value;
                onChanged();
                return this;
            }

            public Builder clearRecvTimeMs() {
                this.recvTimeMs_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public int getRpcBeginTimeMs() {
                return this.rpcBeginTimeMs_;
            }

            public Builder setRpcBeginTimeMs(int value) {
                this.rpcBeginTimeMs_ = value;
                onChanged();
                return this;
            }

            public Builder clearRpcBeginTimeMs() {
                this.rpcBeginTimeMs_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetExtMap() {
                if (this.extMap_ == null) {
                    return MapField.emptyMapField(ExtMapDefaultEntryHolder.defaultEntry);
                }
                return this.extMap_;
            }

            private MapField<Integer, Integer> internalGetMutableExtMap() {
                onChanged();
                if (this.extMap_ == null) {
                    this.extMap_ = MapField.newMapField(ExtMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.extMap_.isMutable()) {
                    this.extMap_ = this.extMap_.copy();
                }
                return this.extMap_;
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public int getExtMapCount() {
                return internalGetExtMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public boolean containsExtMap(int key) {
                return internalGetExtMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            @Deprecated
            public Map<Integer, Integer> getExtMap() {
                return getExtMapMap();
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public Map<Integer, Integer> getExtMapMap() {
                return internalGetExtMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public int getExtMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetExtMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public int getExtMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetExtMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearExtMap() {
                internalGetMutableExtMap().getMutableMap().clear();
                return this;
            }

            public Builder removeExtMap(int key) {
                internalGetMutableExtMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableExtMap() {
                return internalGetMutableExtMap().getMutableMap();
            }

            public Builder putExtMap(int key, int value) {
                internalGetMutableExtMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllExtMap(Map<Integer, Integer> values) {
                internalGetMutableExtMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public int getSenderAppId() {
                return this.senderAppId_;
            }

            public Builder setSenderAppId(int value) {
                this.senderAppId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSenderAppId() {
                this.senderAppId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public int getSourceService() {
                return this.sourceService_;
            }

            public Builder setSourceService(int value) {
                this.sourceService_ = value;
                onChanged();
                return this;
            }

            public Builder clearSourceService() {
                this.sourceService_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public int getTargetService() {
                return this.targetService_;
            }

            public Builder setTargetService(int value) {
                this.targetService_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetService() {
                this.targetService_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetServiceAppIdMap() {
                if (this.serviceAppIdMap_ == null) {
                    return MapField.emptyMapField(ServiceAppIdMapDefaultEntryHolder.defaultEntry);
                }
                return this.serviceAppIdMap_;
            }

            private MapField<Integer, Integer> internalGetMutableServiceAppIdMap() {
                onChanged();
                if (this.serviceAppIdMap_ == null) {
                    this.serviceAppIdMap_ = MapField.newMapField(ServiceAppIdMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.serviceAppIdMap_.isMutable()) {
                    this.serviceAppIdMap_ = this.serviceAppIdMap_.copy();
                }
                return this.serviceAppIdMap_;
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public int getServiceAppIdMapCount() {
                return internalGetServiceAppIdMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public boolean containsServiceAppIdMap(int key) {
                return internalGetServiceAppIdMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            @Deprecated
            public Map<Integer, Integer> getServiceAppIdMap() {
                return getServiceAppIdMapMap();
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public Map<Integer, Integer> getServiceAppIdMapMap() {
                return internalGetServiceAppIdMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public int getServiceAppIdMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetServiceAppIdMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public int getServiceAppIdMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetServiceAppIdMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearServiceAppIdMap() {
                internalGetMutableServiceAppIdMap().getMutableMap().clear();
                return this;
            }

            public Builder removeServiceAppIdMap(int key) {
                internalGetMutableServiceAppIdMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableServiceAppIdMap() {
                return internalGetMutableServiceAppIdMap().getMutableMap();
            }

            public Builder putServiceAppIdMap(int key, int value) {
                internalGetMutableServiceAppIdMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllServiceAppIdMap(Map<Integer, Integer> values) {
                internalGetMutableServiceAppIdMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public boolean getIsSetGameThread() {
                return this.isSetGameThread_;
            }

            public Builder setIsSetGameThread(boolean value) {
                this.isSetGameThread_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsSetGameThread() {
                this.isSetGameThread_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHeadOrBuilder
            public int getGameThreadIndex() {
                return this.gameThreadIndex_;
            }

            public Builder setGameThreadIndex(int value) {
                this.gameThreadIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearGameThreadIndex() {
                this.gameThreadIndex_ = 0;
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

        public static PacketHead getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PacketHead> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PacketHead> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PacketHead getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
