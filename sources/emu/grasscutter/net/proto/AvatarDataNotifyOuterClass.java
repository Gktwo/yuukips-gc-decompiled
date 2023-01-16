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
import emu.grasscutter.net.proto.AvatarInfoOuterClass;
import emu.grasscutter.net.proto.AvatarRenameInfoOuterClass;
import emu.grasscutter.net.proto.AvatarTeamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarDataNotifyOuterClass.class */
public final class AvatarDataNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016AvatarDataNotify.proto\u001a\u0010AvatarInfo.proto\u001a\u0016AvatarRenameInfo.proto\u001a\u0010AvatarTeam.proto\"\u0003\n\u0010AvatarDataNotify\u0012 \n\u000bavatar_list\u0018\u000e \u0003(\u000b2\u000b.AvatarInfo\u0012-\n\u0012avatar_rename_list\u0018\b \u0003(\u000b2\u0011.AvatarRenameInfo\u0012\u001a\n\u0012cur_avatar_team_id\u0018\u0007 \u0001(\r\u0012\u001b\n\u0013owned_flycloak_list\u0018\u0006 \u0003(\r\u0012\u001d\n\u0015temp_avatar_guid_list\u0018\u000f \u0003(\u0004\u0012\u001a\n\u0012choose_avatar_guid\u0018\u0001 \u0001(\u0004\u0012=\n\u000favatar_team_map\u0018\u000b \u0003(\u000b2$.AvatarDataNotify.AvatarTeamMapEntry\u0012\u001a\n\u0012owned_costume_list\u0018\u0005 \u0003(\r\u0012%\n\u001dbackup_avatar_team_order_list\u0018\u0003 \u0003(\r\u001aA\n\u0012AvatarTeamMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\u001a\n\u0005value\u0018\u0002 \u0001(\u000b2\u000b.AvatarTeam:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AvatarInfoOuterClass.getDescriptor(), AvatarRenameInfoOuterClass.getDescriptor(), AvatarTeamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AvatarDataNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarDataNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarDataNotify_descriptor, new String[]{"AvatarList", "AvatarRenameList", "CurAvatarTeamId", "OwnedFlycloakList", "TempAvatarGuidList", "ChooseAvatarGuid", "AvatarTeamMap", "OwnedCostumeList", "BackupAvatarTeamOrderList"});
    private static final Descriptors.Descriptor internal_static_AvatarDataNotify_AvatarTeamMapEntry_descriptor = internal_static_AvatarDataNotify_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_AvatarDataNotify_AvatarTeamMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f626xe63edadc = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarDataNotify_AvatarTeamMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarDataNotifyOuterClass$AvatarDataNotifyOrBuilder.class */
    public interface AvatarDataNotifyOrBuilder extends MessageOrBuilder {
        List<AvatarInfoOuterClass.AvatarInfo> getAvatarListList();

        AvatarInfoOuterClass.AvatarInfo getAvatarList(int i);

        int getAvatarListCount();

        List<? extends AvatarInfoOuterClass.AvatarInfoOrBuilder> getAvatarListOrBuilderList();

        AvatarInfoOuterClass.AvatarInfoOrBuilder getAvatarListOrBuilder(int i);

        List<AvatarRenameInfoOuterClass.AvatarRenameInfo> getAvatarRenameListList();

        AvatarRenameInfoOuterClass.AvatarRenameInfo getAvatarRenameList(int i);

        int getAvatarRenameListCount();

        List<? extends AvatarRenameInfoOuterClass.AvatarRenameInfoOrBuilder> getAvatarRenameListOrBuilderList();

        AvatarRenameInfoOuterClass.AvatarRenameInfoOrBuilder getAvatarRenameListOrBuilder(int i);

        int getCurAvatarTeamId();

        List<Integer> getOwnedFlycloakListList();

        int getOwnedFlycloakListCount();

        int getOwnedFlycloakList(int i);

        List<Long> getTempAvatarGuidListList();

        int getTempAvatarGuidListCount();

        long getTempAvatarGuidList(int i);

        long getChooseAvatarGuid();

        int getAvatarTeamMapCount();

        boolean containsAvatarTeamMap(int i);

        @Deprecated
        Map<Integer, AvatarTeamOuterClass.AvatarTeam> getAvatarTeamMap();

        Map<Integer, AvatarTeamOuterClass.AvatarTeam> getAvatarTeamMapMap();

        AvatarTeamOuterClass.AvatarTeam getAvatarTeamMapOrDefault(int i, AvatarTeamOuterClass.AvatarTeam avatarTeam);

        AvatarTeamOuterClass.AvatarTeam getAvatarTeamMapOrThrow(int i);

        List<Integer> getOwnedCostumeListList();

        int getOwnedCostumeListCount();

        int getOwnedCostumeList(int i);

        List<Integer> getBackupAvatarTeamOrderListList();

        int getBackupAvatarTeamOrderListCount();

        int getBackupAvatarTeamOrderList(int i);
    }

    private AvatarDataNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarDataNotifyOuterClass$AvatarDataNotify.class */
    public static final class AvatarDataNotify extends GeneratedMessageV3 implements AvatarDataNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATAR_LIST_FIELD_NUMBER = 14;
        private List<AvatarInfoOuterClass.AvatarInfo> avatarList_;
        public static final int AVATAR_RENAME_LIST_FIELD_NUMBER = 8;
        private List<AvatarRenameInfoOuterClass.AvatarRenameInfo> avatarRenameList_;
        public static final int CUR_AVATAR_TEAM_ID_FIELD_NUMBER = 7;
        private int curAvatarTeamId_;
        public static final int OWNED_FLYCLOAK_LIST_FIELD_NUMBER = 6;
        private Internal.IntList ownedFlycloakList_;
        private int ownedFlycloakListMemoizedSerializedSize;
        public static final int TEMP_AVATAR_GUID_LIST_FIELD_NUMBER = 15;
        private Internal.LongList tempAvatarGuidList_;
        private int tempAvatarGuidListMemoizedSerializedSize;
        public static final int CHOOSE_AVATAR_GUID_FIELD_NUMBER = 1;
        private long chooseAvatarGuid_;
        public static final int AVATAR_TEAM_MAP_FIELD_NUMBER = 11;
        private MapField<Integer, AvatarTeamOuterClass.AvatarTeam> avatarTeamMap_;
        public static final int OWNED_COSTUME_LIST_FIELD_NUMBER = 5;
        private Internal.IntList ownedCostumeList_;
        private int ownedCostumeListMemoizedSerializedSize;
        public static final int BACKUP_AVATAR_TEAM_ORDER_LIST_FIELD_NUMBER = 3;
        private Internal.IntList backupAvatarTeamOrderList_;
        private int backupAvatarTeamOrderListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final AvatarDataNotify DEFAULT_INSTANCE = new AvatarDataNotify();
        private static final Parser<AvatarDataNotify> PARSER = new AbstractParser<AvatarDataNotify>() { // from class: emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotify.1
            @Override // com.google.protobuf.Parser
            public AvatarDataNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarDataNotify(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotify.internalGetMapField(int):com.google.protobuf.MapField
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
                com.google.protobuf.MapField r0 = r0.internalGetAvatarTeamMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotify.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private AvatarDataNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.ownedFlycloakListMemoizedSerializedSize = -1;
            this.tempAvatarGuidListMemoizedSerializedSize = -1;
            this.ownedCostumeListMemoizedSerializedSize = -1;
            this.backupAvatarTeamOrderListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private AvatarDataNotify() {
            this.ownedFlycloakListMemoizedSerializedSize = -1;
            this.tempAvatarGuidListMemoizedSerializedSize = -1;
            this.ownedCostumeListMemoizedSerializedSize = -1;
            this.backupAvatarTeamOrderListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.avatarList_ = Collections.emptyList();
            this.avatarRenameList_ = Collections.emptyList();
            this.ownedFlycloakList_ = emptyIntList();
            this.tempAvatarGuidList_ = emptyLongList();
            this.ownedCostumeList_ = emptyIntList();
            this.backupAvatarTeamOrderList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarDataNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:151:0x0314 */
        private AvatarDataNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.chooseAvatarGuid_ = input.readUInt64();
                                    break;
                                case 24:
                                    if ((mutable_bitField0_ & 64) == 0) {
                                        this.backupAvatarTeamOrderList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 64) == 1 ? 1 : 0;
                                    }
                                    this.backupAvatarTeamOrderList_.addInt(input.readUInt32());
                                    break;
                                case 26:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 64) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.backupAvatarTeamOrderList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 64) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.backupAvatarTeamOrderList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 40:
                                    if ((mutable_bitField0_ & 32) == 0) {
                                        this.ownedCostumeList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 32) == 1 ? 1 : 0;
                                    }
                                    this.ownedCostumeList_.addInt(input.readUInt32());
                                    break;
                                case 42:
                                    int limit2 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 32) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.ownedCostumeList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 32) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.ownedCostumeList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit2);
                                    break;
                                case 48:
                                    if ((mutable_bitField0_ & 4) == 0) {
                                        this.ownedFlycloakList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                    }
                                    this.ownedFlycloakList_.addInt(input.readUInt32());
                                    break;
                                case 50:
                                    int limit3 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.ownedFlycloakList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.ownedFlycloakList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit3);
                                    break;
                                case 56:
                                    this.curAvatarTeamId_ = input.readUInt32();
                                    break;
                                case 66:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.avatarRenameList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.avatarRenameList_.add((AvatarRenameInfoOuterClass.AvatarRenameInfo) input.readMessage(AvatarRenameInfoOuterClass.AvatarRenameInfo.parser(), extensionRegistry));
                                    break;
                                case 90:
                                    if ((mutable_bitField0_ & 16) == 0) {
                                        this.avatarTeamMap_ = MapField.newMapField(AvatarTeamMapDefaultEntryHolder.defaultEntry);
                                        mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                    }
                                    MapEntry<Integer, AvatarTeamOuterClass.AvatarTeam> avatarTeamMap__ = (MapEntry) input.readMessage(AvatarTeamMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                    this.avatarTeamMap_.getMutableMap().put(avatarTeamMap__.getKey(), avatarTeamMap__.getValue());
                                    break;
                                case 114:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.avatarList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.avatarList_.add((AvatarInfoOuterClass.AvatarInfo) input.readMessage(AvatarInfoOuterClass.AvatarInfo.parser(), extensionRegistry));
                                    break;
                                case 120:
                                    if ((mutable_bitField0_ & 8) == 0) {
                                        this.tempAvatarGuidList_ = newLongList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                    }
                                    this.tempAvatarGuidList_.addLong(input.readUInt64());
                                    break;
                                case 122:
                                    int limit4 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 8) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.tempAvatarGuidList_ = newLongList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.tempAvatarGuidList_.addLong(input.readUInt64());
                                    }
                                    input.popLimit(limit4);
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
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 64) != 0) {
                    this.backupAvatarTeamOrderList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 32) != 0) {
                    this.ownedCostumeList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.ownedFlycloakList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.avatarRenameList_ = Collections.unmodifiableList(this.avatarRenameList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.avatarList_ = Collections.unmodifiableList(this.avatarList_);
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.tempAvatarGuidList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvatarDataNotifyOuterClass.internal_static_AvatarDataNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarDataNotifyOuterClass.internal_static_AvatarDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarDataNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public List<AvatarInfoOuterClass.AvatarInfo> getAvatarListList() {
            return this.avatarList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public List<? extends AvatarInfoOuterClass.AvatarInfoOrBuilder> getAvatarListOrBuilderList() {
            return this.avatarList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public int getAvatarListCount() {
            return this.avatarList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public AvatarInfoOuterClass.AvatarInfo getAvatarList(int index) {
            return this.avatarList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public AvatarInfoOuterClass.AvatarInfoOrBuilder getAvatarListOrBuilder(int index) {
            return this.avatarList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public List<AvatarRenameInfoOuterClass.AvatarRenameInfo> getAvatarRenameListList() {
            return this.avatarRenameList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public List<? extends AvatarRenameInfoOuterClass.AvatarRenameInfoOrBuilder> getAvatarRenameListOrBuilderList() {
            return this.avatarRenameList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public int getAvatarRenameListCount() {
            return this.avatarRenameList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public AvatarRenameInfoOuterClass.AvatarRenameInfo getAvatarRenameList(int index) {
            return this.avatarRenameList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public AvatarRenameInfoOuterClass.AvatarRenameInfoOrBuilder getAvatarRenameListOrBuilder(int index) {
            return this.avatarRenameList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public int getCurAvatarTeamId() {
            return this.curAvatarTeamId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public List<Integer> getOwnedFlycloakListList() {
            return this.ownedFlycloakList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public int getOwnedFlycloakListCount() {
            return this.ownedFlycloakList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public int getOwnedFlycloakList(int index) {
            return this.ownedFlycloakList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public List<Long> getTempAvatarGuidListList() {
            return this.tempAvatarGuidList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public int getTempAvatarGuidListCount() {
            return this.tempAvatarGuidList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public long getTempAvatarGuidList(int index) {
            return this.tempAvatarGuidList_.getLong(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public long getChooseAvatarGuid() {
            return this.chooseAvatarGuid_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarDataNotifyOuterClass$AvatarDataNotify$AvatarTeamMapDefaultEntryHolder.class */
        public static final class AvatarTeamMapDefaultEntryHolder {
            static final MapEntry<Integer, AvatarTeamOuterClass.AvatarTeam> defaultEntry = MapEntry.newDefaultInstance(AvatarDataNotifyOuterClass.internal_static_AvatarDataNotify_AvatarTeamMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, AvatarTeamOuterClass.AvatarTeam.getDefaultInstance());

            private AvatarTeamMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, AvatarTeamOuterClass.AvatarTeam> internalGetAvatarTeamMap() {
            if (this.avatarTeamMap_ == null) {
                return MapField.emptyMapField(AvatarTeamMapDefaultEntryHolder.defaultEntry);
            }
            return this.avatarTeamMap_;
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public int getAvatarTeamMapCount() {
            return internalGetAvatarTeamMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public boolean containsAvatarTeamMap(int key) {
            return internalGetAvatarTeamMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        @Deprecated
        public Map<Integer, AvatarTeamOuterClass.AvatarTeam> getAvatarTeamMap() {
            return getAvatarTeamMapMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public Map<Integer, AvatarTeamOuterClass.AvatarTeam> getAvatarTeamMapMap() {
            return internalGetAvatarTeamMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public AvatarTeamOuterClass.AvatarTeam getAvatarTeamMapOrDefault(int key, AvatarTeamOuterClass.AvatarTeam defaultValue) {
            Map<Integer, AvatarTeamOuterClass.AvatarTeam> map = internalGetAvatarTeamMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public AvatarTeamOuterClass.AvatarTeam getAvatarTeamMapOrThrow(int key) {
            Map<Integer, AvatarTeamOuterClass.AvatarTeam> map = internalGetAvatarTeamMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public List<Integer> getOwnedCostumeListList() {
            return this.ownedCostumeList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public int getOwnedCostumeListCount() {
            return this.ownedCostumeList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public int getOwnedCostumeList(int index) {
            return this.ownedCostumeList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public List<Integer> getBackupAvatarTeamOrderListList() {
            return this.backupAvatarTeamOrderList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public int getBackupAvatarTeamOrderListCount() {
            return this.backupAvatarTeamOrderList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
        public int getBackupAvatarTeamOrderList(int index) {
            return this.backupAvatarTeamOrderList_.getInt(index);
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
            if (this.chooseAvatarGuid_ != 0) {
                output.writeUInt64(1, this.chooseAvatarGuid_);
            }
            if (getBackupAvatarTeamOrderListList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.backupAvatarTeamOrderListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.backupAvatarTeamOrderList_.size(); i++) {
                output.writeUInt32NoTag(this.backupAvatarTeamOrderList_.getInt(i));
            }
            if (getOwnedCostumeListList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.ownedCostumeListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.ownedCostumeList_.size(); i2++) {
                output.writeUInt32NoTag(this.ownedCostumeList_.getInt(i2));
            }
            if (getOwnedFlycloakListList().size() > 0) {
                output.writeUInt32NoTag(50);
                output.writeUInt32NoTag(this.ownedFlycloakListMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.ownedFlycloakList_.size(); i3++) {
                output.writeUInt32NoTag(this.ownedFlycloakList_.getInt(i3));
            }
            if (this.curAvatarTeamId_ != 0) {
                output.writeUInt32(7, this.curAvatarTeamId_);
            }
            for (int i4 = 0; i4 < this.avatarRenameList_.size(); i4++) {
                output.writeMessage(8, this.avatarRenameList_.get(i4));
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetAvatarTeamMap(), AvatarTeamMapDefaultEntryHolder.defaultEntry, 11);
            for (int i5 = 0; i5 < this.avatarList_.size(); i5++) {
                output.writeMessage(14, this.avatarList_.get(i5));
            }
            if (getTempAvatarGuidListList().size() > 0) {
                output.writeUInt32NoTag(122);
                output.writeUInt32NoTag(this.tempAvatarGuidListMemoizedSerializedSize);
            }
            for (int i6 = 0; i6 < this.tempAvatarGuidList_.size(); i6++) {
                output.writeUInt64NoTag(this.tempAvatarGuidList_.getLong(i6));
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
            if (this.chooseAvatarGuid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(1, this.chooseAvatarGuid_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.backupAvatarTeamOrderList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.backupAvatarTeamOrderList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getBackupAvatarTeamOrderListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.backupAvatarTeamOrderListMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.ownedCostumeList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.ownedCostumeList_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getOwnedCostumeListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.ownedCostumeListMemoizedSerializedSize = dataSize2;
            int dataSize3 = 0;
            for (int i3 = 0; i3 < this.ownedFlycloakList_.size(); i3++) {
                dataSize3 += CodedOutputStream.computeUInt32SizeNoTag(this.ownedFlycloakList_.getInt(i3));
            }
            int size5 = size4 + dataSize3;
            if (!getOwnedFlycloakListList().isEmpty()) {
                size5 = size5 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize3);
            }
            this.ownedFlycloakListMemoizedSerializedSize = dataSize3;
            if (this.curAvatarTeamId_ != 0) {
                size5 += CodedOutputStream.computeUInt32Size(7, this.curAvatarTeamId_);
            }
            for (int i4 = 0; i4 < this.avatarRenameList_.size(); i4++) {
                size5 += CodedOutputStream.computeMessageSize(8, this.avatarRenameList_.get(i4));
            }
            for (Map.Entry<Integer, AvatarTeamOuterClass.AvatarTeam> entry : internalGetAvatarTeamMap().getMap().entrySet()) {
                size5 += CodedOutputStream.computeMessageSize(11, AvatarTeamMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            for (int i5 = 0; i5 < this.avatarList_.size(); i5++) {
                size5 += CodedOutputStream.computeMessageSize(14, this.avatarList_.get(i5));
            }
            int dataSize4 = 0;
            for (int i6 = 0; i6 < this.tempAvatarGuidList_.size(); i6++) {
                dataSize4 += CodedOutputStream.computeUInt64SizeNoTag(this.tempAvatarGuidList_.getLong(i6));
            }
            int size6 = size5 + dataSize4;
            if (!getTempAvatarGuidListList().isEmpty()) {
                size6 = size6 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize4);
            }
            this.tempAvatarGuidListMemoizedSerializedSize = dataSize4;
            int size7 = size6 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size7;
            return size7;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AvatarDataNotify)) {
                return equals(obj);
            }
            AvatarDataNotify other = (AvatarDataNotify) obj;
            return getAvatarListList().equals(other.getAvatarListList()) && getAvatarRenameListList().equals(other.getAvatarRenameListList()) && getCurAvatarTeamId() == other.getCurAvatarTeamId() && getOwnedFlycloakListList().equals(other.getOwnedFlycloakListList()) && getTempAvatarGuidListList().equals(other.getTempAvatarGuidListList()) && getChooseAvatarGuid() == other.getChooseAvatarGuid() && internalGetAvatarTeamMap().equals(other.internalGetAvatarTeamMap()) && getOwnedCostumeListList().equals(other.getOwnedCostumeListList()) && getBackupAvatarTeamOrderListList().equals(other.getBackupAvatarTeamOrderListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getAvatarListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getAvatarListList().hashCode();
            }
            if (getAvatarRenameListCount() > 0) {
                hash = (53 * ((37 * hash) + 8)) + getAvatarRenameListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 7)) + getCurAvatarTeamId();
            if (getOwnedFlycloakListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 6)) + getOwnedFlycloakListList().hashCode();
            }
            if (getTempAvatarGuidListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 15)) + getTempAvatarGuidListList().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 1)) + Internal.hashLong(getChooseAvatarGuid());
            if (!internalGetAvatarTeamMap().getMap().isEmpty()) {
                hash3 = (53 * ((37 * hash3) + 11)) + internalGetAvatarTeamMap().hashCode();
            }
            if (getOwnedCostumeListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 5)) + getOwnedCostumeListList().hashCode();
            }
            if (getBackupAvatarTeamOrderListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 3)) + getBackupAvatarTeamOrderListList().hashCode();
            }
            int hash4 = (29 * hash3) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static AvatarDataNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarDataNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarDataNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarDataNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarDataNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarDataNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarDataNotify parseFrom(InputStream input) throws IOException {
            return (AvatarDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarDataNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarDataNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarDataNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarDataNotify parseFrom(CodedInputStream input) throws IOException {
            return (AvatarDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarDataNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarDataNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarDataNotifyOuterClass$AvatarDataNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarDataNotifyOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<AvatarInfoOuterClass.AvatarInfo, AvatarInfoOuterClass.AvatarInfo.Builder, AvatarInfoOuterClass.AvatarInfoOrBuilder> avatarListBuilder_;
            private RepeatedFieldBuilderV3<AvatarRenameInfoOuterClass.AvatarRenameInfo, AvatarRenameInfoOuterClass.AvatarRenameInfo.Builder, AvatarRenameInfoOuterClass.AvatarRenameInfoOrBuilder> avatarRenameListBuilder_;
            private int curAvatarTeamId_;
            private long chooseAvatarGuid_;
            private MapField<Integer, AvatarTeamOuterClass.AvatarTeam> avatarTeamMap_;
            private List<AvatarInfoOuterClass.AvatarInfo> avatarList_ = Collections.emptyList();
            private List<AvatarRenameInfoOuterClass.AvatarRenameInfo> avatarRenameList_ = Collections.emptyList();
            private Internal.IntList ownedFlycloakList_ = AvatarDataNotify.emptyIntList();
            private Internal.LongList tempAvatarGuidList_ = AvatarDataNotify.emptyLongList();
            private Internal.IntList ownedCostumeList_ = AvatarDataNotify.emptyIntList();
            private Internal.IntList backupAvatarTeamOrderList_ = AvatarDataNotify.emptyIntList();

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetAvatarTeamMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetMutableAvatarTeamMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarDataNotifyOuterClass.internal_static_AvatarDataNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarDataNotifyOuterClass.internal_static_AvatarDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarDataNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarDataNotify.alwaysUseFieldBuilders) {
                    getAvatarListFieldBuilder();
                    getAvatarRenameListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.avatarListBuilder_ == null) {
                    this.avatarList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.avatarListBuilder_.clear();
                }
                if (this.avatarRenameListBuilder_ == null) {
                    this.avatarRenameList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.avatarRenameListBuilder_.clear();
                }
                this.curAvatarTeamId_ = 0;
                this.ownedFlycloakList_ = AvatarDataNotify.emptyIntList();
                this.bitField0_ &= -5;
                this.tempAvatarGuidList_ = AvatarDataNotify.emptyLongList();
                this.bitField0_ &= -9;
                this.chooseAvatarGuid_ = 0;
                internalGetMutableAvatarTeamMap().clear();
                this.ownedCostumeList_ = AvatarDataNotify.emptyIntList();
                this.bitField0_ &= -33;
                this.backupAvatarTeamOrderList_ = AvatarDataNotify.emptyIntList();
                this.bitField0_ &= -65;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarDataNotifyOuterClass.internal_static_AvatarDataNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarDataNotify getDefaultInstanceForType() {
                return AvatarDataNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarDataNotify build() {
                AvatarDataNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarDataNotify buildPartial() {
                AvatarDataNotify result = new AvatarDataNotify(this);
                int i = this.bitField0_;
                if (this.avatarListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.avatarList_ = Collections.unmodifiableList(this.avatarList_);
                        this.bitField0_ &= -2;
                    }
                    result.avatarList_ = this.avatarList_;
                } else {
                    result.avatarList_ = this.avatarListBuilder_.build();
                }
                if (this.avatarRenameListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.avatarRenameList_ = Collections.unmodifiableList(this.avatarRenameList_);
                        this.bitField0_ &= -3;
                    }
                    result.avatarRenameList_ = this.avatarRenameList_;
                } else {
                    result.avatarRenameList_ = this.avatarRenameListBuilder_.build();
                }
                result.curAvatarTeamId_ = this.curAvatarTeamId_;
                if ((this.bitField0_ & 4) != 0) {
                    this.ownedFlycloakList_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.ownedFlycloakList_ = this.ownedFlycloakList_;
                if ((this.bitField0_ & 8) != 0) {
                    this.tempAvatarGuidList_.makeImmutable();
                    this.bitField0_ &= -9;
                }
                result.tempAvatarGuidList_ = this.tempAvatarGuidList_;
                result.chooseAvatarGuid_ = this.chooseAvatarGuid_;
                result.avatarTeamMap_ = internalGetAvatarTeamMap();
                result.avatarTeamMap_.makeImmutable();
                if ((this.bitField0_ & 32) != 0) {
                    this.ownedCostumeList_.makeImmutable();
                    this.bitField0_ &= -33;
                }
                result.ownedCostumeList_ = this.ownedCostumeList_;
                if ((this.bitField0_ & 64) != 0) {
                    this.backupAvatarTeamOrderList_.makeImmutable();
                    this.bitField0_ &= -65;
                }
                result.backupAvatarTeamOrderList_ = this.backupAvatarTeamOrderList_;
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
                if (other instanceof AvatarDataNotify) {
                    return mergeFrom((AvatarDataNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarDataNotify other) {
                if (other == AvatarDataNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.avatarListBuilder_ == null) {
                    if (!other.avatarList_.isEmpty()) {
                        if (this.avatarList_.isEmpty()) {
                            this.avatarList_ = other.avatarList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureAvatarListIsMutable();
                            this.avatarList_.addAll(other.avatarList_);
                        }
                        onChanged();
                    }
                } else if (!other.avatarList_.isEmpty()) {
                    if (this.avatarListBuilder_.isEmpty()) {
                        this.avatarListBuilder_.dispose();
                        this.avatarListBuilder_ = null;
                        this.avatarList_ = other.avatarList_;
                        this.bitField0_ &= -2;
                        this.avatarListBuilder_ = AvatarDataNotify.alwaysUseFieldBuilders ? getAvatarListFieldBuilder() : null;
                    } else {
                        this.avatarListBuilder_.addAllMessages(other.avatarList_);
                    }
                }
                if (this.avatarRenameListBuilder_ == null) {
                    if (!other.avatarRenameList_.isEmpty()) {
                        if (this.avatarRenameList_.isEmpty()) {
                            this.avatarRenameList_ = other.avatarRenameList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureAvatarRenameListIsMutable();
                            this.avatarRenameList_.addAll(other.avatarRenameList_);
                        }
                        onChanged();
                    }
                } else if (!other.avatarRenameList_.isEmpty()) {
                    if (this.avatarRenameListBuilder_.isEmpty()) {
                        this.avatarRenameListBuilder_.dispose();
                        this.avatarRenameListBuilder_ = null;
                        this.avatarRenameList_ = other.avatarRenameList_;
                        this.bitField0_ &= -3;
                        this.avatarRenameListBuilder_ = AvatarDataNotify.alwaysUseFieldBuilders ? getAvatarRenameListFieldBuilder() : null;
                    } else {
                        this.avatarRenameListBuilder_.addAllMessages(other.avatarRenameList_);
                    }
                }
                if (other.getCurAvatarTeamId() != 0) {
                    setCurAvatarTeamId(other.getCurAvatarTeamId());
                }
                if (!other.ownedFlycloakList_.isEmpty()) {
                    if (this.ownedFlycloakList_.isEmpty()) {
                        this.ownedFlycloakList_ = other.ownedFlycloakList_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureOwnedFlycloakListIsMutable();
                        this.ownedFlycloakList_.addAll(other.ownedFlycloakList_);
                    }
                    onChanged();
                }
                if (!other.tempAvatarGuidList_.isEmpty()) {
                    if (this.tempAvatarGuidList_.isEmpty()) {
                        this.tempAvatarGuidList_ = other.tempAvatarGuidList_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureTempAvatarGuidListIsMutable();
                        this.tempAvatarGuidList_.addAll(other.tempAvatarGuidList_);
                    }
                    onChanged();
                }
                if (other.getChooseAvatarGuid() != 0) {
                    setChooseAvatarGuid(other.getChooseAvatarGuid());
                }
                internalGetMutableAvatarTeamMap().mergeFrom(other.internalGetAvatarTeamMap());
                if (!other.ownedCostumeList_.isEmpty()) {
                    if (this.ownedCostumeList_.isEmpty()) {
                        this.ownedCostumeList_ = other.ownedCostumeList_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureOwnedCostumeListIsMutable();
                        this.ownedCostumeList_.addAll(other.ownedCostumeList_);
                    }
                    onChanged();
                }
                if (!other.backupAvatarTeamOrderList_.isEmpty()) {
                    if (this.backupAvatarTeamOrderList_.isEmpty()) {
                        this.backupAvatarTeamOrderList_ = other.backupAvatarTeamOrderList_;
                        this.bitField0_ &= -65;
                    } else {
                        ensureBackupAvatarTeamOrderListIsMutable();
                        this.backupAvatarTeamOrderList_.addAll(other.backupAvatarTeamOrderList_);
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
                AvatarDataNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarDataNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarDataNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureAvatarListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.avatarList_ = new ArrayList(this.avatarList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public List<AvatarInfoOuterClass.AvatarInfo> getAvatarListList() {
                if (this.avatarListBuilder_ == null) {
                    return Collections.unmodifiableList(this.avatarList_);
                }
                return this.avatarListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public int getAvatarListCount() {
                if (this.avatarListBuilder_ == null) {
                    return this.avatarList_.size();
                }
                return this.avatarListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public AvatarInfoOuterClass.AvatarInfo getAvatarList(int index) {
                if (this.avatarListBuilder_ == null) {
                    return this.avatarList_.get(index);
                }
                return this.avatarListBuilder_.getMessage(index);
            }

            public Builder setAvatarList(int index, AvatarInfoOuterClass.AvatarInfo value) {
                if (this.avatarListBuilder_ != null) {
                    this.avatarListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarListIsMutable();
                    this.avatarList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setAvatarList(int index, AvatarInfoOuterClass.AvatarInfo.Builder builderForValue) {
                if (this.avatarListBuilder_ == null) {
                    ensureAvatarListIsMutable();
                    this.avatarList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAvatarList(AvatarInfoOuterClass.AvatarInfo value) {
                if (this.avatarListBuilder_ != null) {
                    this.avatarListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarListIsMutable();
                    this.avatarList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addAvatarList(int index, AvatarInfoOuterClass.AvatarInfo value) {
                if (this.avatarListBuilder_ != null) {
                    this.avatarListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarListIsMutable();
                    this.avatarList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addAvatarList(AvatarInfoOuterClass.AvatarInfo.Builder builderForValue) {
                if (this.avatarListBuilder_ == null) {
                    ensureAvatarListIsMutable();
                    this.avatarList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.avatarListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAvatarList(int index, AvatarInfoOuterClass.AvatarInfo.Builder builderForValue) {
                if (this.avatarListBuilder_ == null) {
                    ensureAvatarListIsMutable();
                    this.avatarList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAvatarList(Iterable<? extends AvatarInfoOuterClass.AvatarInfo> values) {
                if (this.avatarListBuilder_ == null) {
                    ensureAvatarListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.avatarList_);
                    onChanged();
                } else {
                    this.avatarListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAvatarList() {
                if (this.avatarListBuilder_ == null) {
                    this.avatarList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.avatarListBuilder_.clear();
                }
                return this;
            }

            public Builder removeAvatarList(int index) {
                if (this.avatarListBuilder_ == null) {
                    ensureAvatarListIsMutable();
                    this.avatarList_.remove(index);
                    onChanged();
                } else {
                    this.avatarListBuilder_.remove(index);
                }
                return this;
            }

            public AvatarInfoOuterClass.AvatarInfo.Builder getAvatarListBuilder(int index) {
                return getAvatarListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public AvatarInfoOuterClass.AvatarInfoOrBuilder getAvatarListOrBuilder(int index) {
                if (this.avatarListBuilder_ == null) {
                    return this.avatarList_.get(index);
                }
                return this.avatarListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public List<? extends AvatarInfoOuterClass.AvatarInfoOrBuilder> getAvatarListOrBuilderList() {
                if (this.avatarListBuilder_ != null) {
                    return this.avatarListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.avatarList_);
            }

            public AvatarInfoOuterClass.AvatarInfo.Builder addAvatarListBuilder() {
                return getAvatarListFieldBuilder().addBuilder(AvatarInfoOuterClass.AvatarInfo.getDefaultInstance());
            }

            public AvatarInfoOuterClass.AvatarInfo.Builder addAvatarListBuilder(int index) {
                return getAvatarListFieldBuilder().addBuilder(index, AvatarInfoOuterClass.AvatarInfo.getDefaultInstance());
            }

            public List<AvatarInfoOuterClass.AvatarInfo.Builder> getAvatarListBuilderList() {
                return getAvatarListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AvatarInfoOuterClass.AvatarInfo, AvatarInfoOuterClass.AvatarInfo.Builder, AvatarInfoOuterClass.AvatarInfoOrBuilder> getAvatarListFieldBuilder() {
                if (this.avatarListBuilder_ == null) {
                    this.avatarListBuilder_ = new RepeatedFieldBuilderV3<>(this.avatarList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.avatarList_ = null;
                }
                return this.avatarListBuilder_;
            }

            private void ensureAvatarRenameListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.avatarRenameList_ = new ArrayList(this.avatarRenameList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public List<AvatarRenameInfoOuterClass.AvatarRenameInfo> getAvatarRenameListList() {
                if (this.avatarRenameListBuilder_ == null) {
                    return Collections.unmodifiableList(this.avatarRenameList_);
                }
                return this.avatarRenameListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public int getAvatarRenameListCount() {
                if (this.avatarRenameListBuilder_ == null) {
                    return this.avatarRenameList_.size();
                }
                return this.avatarRenameListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public AvatarRenameInfoOuterClass.AvatarRenameInfo getAvatarRenameList(int index) {
                if (this.avatarRenameListBuilder_ == null) {
                    return this.avatarRenameList_.get(index);
                }
                return this.avatarRenameListBuilder_.getMessage(index);
            }

            public Builder setAvatarRenameList(int index, AvatarRenameInfoOuterClass.AvatarRenameInfo value) {
                if (this.avatarRenameListBuilder_ != null) {
                    this.avatarRenameListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarRenameListIsMutable();
                    this.avatarRenameList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setAvatarRenameList(int index, AvatarRenameInfoOuterClass.AvatarRenameInfo.Builder builderForValue) {
                if (this.avatarRenameListBuilder_ == null) {
                    ensureAvatarRenameListIsMutable();
                    this.avatarRenameList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarRenameListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAvatarRenameList(AvatarRenameInfoOuterClass.AvatarRenameInfo value) {
                if (this.avatarRenameListBuilder_ != null) {
                    this.avatarRenameListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarRenameListIsMutable();
                    this.avatarRenameList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addAvatarRenameList(int index, AvatarRenameInfoOuterClass.AvatarRenameInfo value) {
                if (this.avatarRenameListBuilder_ != null) {
                    this.avatarRenameListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarRenameListIsMutable();
                    this.avatarRenameList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addAvatarRenameList(AvatarRenameInfoOuterClass.AvatarRenameInfo.Builder builderForValue) {
                if (this.avatarRenameListBuilder_ == null) {
                    ensureAvatarRenameListIsMutable();
                    this.avatarRenameList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.avatarRenameListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAvatarRenameList(int index, AvatarRenameInfoOuterClass.AvatarRenameInfo.Builder builderForValue) {
                if (this.avatarRenameListBuilder_ == null) {
                    ensureAvatarRenameListIsMutable();
                    this.avatarRenameList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarRenameListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAvatarRenameList(Iterable<? extends AvatarRenameInfoOuterClass.AvatarRenameInfo> values) {
                if (this.avatarRenameListBuilder_ == null) {
                    ensureAvatarRenameListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.avatarRenameList_);
                    onChanged();
                } else {
                    this.avatarRenameListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAvatarRenameList() {
                if (this.avatarRenameListBuilder_ == null) {
                    this.avatarRenameList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.avatarRenameListBuilder_.clear();
                }
                return this;
            }

            public Builder removeAvatarRenameList(int index) {
                if (this.avatarRenameListBuilder_ == null) {
                    ensureAvatarRenameListIsMutable();
                    this.avatarRenameList_.remove(index);
                    onChanged();
                } else {
                    this.avatarRenameListBuilder_.remove(index);
                }
                return this;
            }

            public AvatarRenameInfoOuterClass.AvatarRenameInfo.Builder getAvatarRenameListBuilder(int index) {
                return getAvatarRenameListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public AvatarRenameInfoOuterClass.AvatarRenameInfoOrBuilder getAvatarRenameListOrBuilder(int index) {
                if (this.avatarRenameListBuilder_ == null) {
                    return this.avatarRenameList_.get(index);
                }
                return this.avatarRenameListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public List<? extends AvatarRenameInfoOuterClass.AvatarRenameInfoOrBuilder> getAvatarRenameListOrBuilderList() {
                if (this.avatarRenameListBuilder_ != null) {
                    return this.avatarRenameListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.avatarRenameList_);
            }

            public AvatarRenameInfoOuterClass.AvatarRenameInfo.Builder addAvatarRenameListBuilder() {
                return getAvatarRenameListFieldBuilder().addBuilder(AvatarRenameInfoOuterClass.AvatarRenameInfo.getDefaultInstance());
            }

            public AvatarRenameInfoOuterClass.AvatarRenameInfo.Builder addAvatarRenameListBuilder(int index) {
                return getAvatarRenameListFieldBuilder().addBuilder(index, AvatarRenameInfoOuterClass.AvatarRenameInfo.getDefaultInstance());
            }

            public List<AvatarRenameInfoOuterClass.AvatarRenameInfo.Builder> getAvatarRenameListBuilderList() {
                return getAvatarRenameListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AvatarRenameInfoOuterClass.AvatarRenameInfo, AvatarRenameInfoOuterClass.AvatarRenameInfo.Builder, AvatarRenameInfoOuterClass.AvatarRenameInfoOrBuilder> getAvatarRenameListFieldBuilder() {
                if (this.avatarRenameListBuilder_ == null) {
                    this.avatarRenameListBuilder_ = new RepeatedFieldBuilderV3<>(this.avatarRenameList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.avatarRenameList_ = null;
                }
                return this.avatarRenameListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public int getCurAvatarTeamId() {
                return this.curAvatarTeamId_;
            }

            public Builder setCurAvatarTeamId(int value) {
                this.curAvatarTeamId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurAvatarTeamId() {
                this.curAvatarTeamId_ = 0;
                onChanged();
                return this;
            }

            private void ensureOwnedFlycloakListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.ownedFlycloakList_ = AvatarDataNotify.mutableCopy(this.ownedFlycloakList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public List<Integer> getOwnedFlycloakListList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.ownedFlycloakList_) : this.ownedFlycloakList_;
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public int getOwnedFlycloakListCount() {
                return this.ownedFlycloakList_.size();
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public int getOwnedFlycloakList(int index) {
                return this.ownedFlycloakList_.getInt(index);
            }

            public Builder setOwnedFlycloakList(int index, int value) {
                ensureOwnedFlycloakListIsMutable();
                this.ownedFlycloakList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addOwnedFlycloakList(int value) {
                ensureOwnedFlycloakListIsMutable();
                this.ownedFlycloakList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllOwnedFlycloakList(Iterable<? extends Integer> values) {
                ensureOwnedFlycloakListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.ownedFlycloakList_);
                onChanged();
                return this;
            }

            public Builder clearOwnedFlycloakList() {
                this.ownedFlycloakList_ = AvatarDataNotify.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            private void ensureTempAvatarGuidListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.tempAvatarGuidList_ = AvatarDataNotify.mutableCopy(this.tempAvatarGuidList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public List<Long> getTempAvatarGuidListList() {
                return (this.bitField0_ & 8) != 0 ? Collections.unmodifiableList(this.tempAvatarGuidList_) : this.tempAvatarGuidList_;
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public int getTempAvatarGuidListCount() {
                return this.tempAvatarGuidList_.size();
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public long getTempAvatarGuidList(int index) {
                return this.tempAvatarGuidList_.getLong(index);
            }

            public Builder setTempAvatarGuidList(int index, long value) {
                ensureTempAvatarGuidListIsMutable();
                this.tempAvatarGuidList_.setLong(index, value);
                onChanged();
                return this;
            }

            public Builder addTempAvatarGuidList(long value) {
                ensureTempAvatarGuidListIsMutable();
                this.tempAvatarGuidList_.addLong(value);
                onChanged();
                return this;
            }

            public Builder addAllTempAvatarGuidList(Iterable<? extends Long> values) {
                ensureTempAvatarGuidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.tempAvatarGuidList_);
                onChanged();
                return this;
            }

            public Builder clearTempAvatarGuidList() {
                this.tempAvatarGuidList_ = AvatarDataNotify.emptyLongList();
                this.bitField0_ &= -9;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public long getChooseAvatarGuid() {
                return this.chooseAvatarGuid_;
            }

            public Builder setChooseAvatarGuid(long value) {
                this.chooseAvatarGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearChooseAvatarGuid() {
                this.chooseAvatarGuid_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, AvatarTeamOuterClass.AvatarTeam> internalGetAvatarTeamMap() {
                if (this.avatarTeamMap_ == null) {
                    return MapField.emptyMapField(AvatarTeamMapDefaultEntryHolder.defaultEntry);
                }
                return this.avatarTeamMap_;
            }

            private MapField<Integer, AvatarTeamOuterClass.AvatarTeam> internalGetMutableAvatarTeamMap() {
                onChanged();
                if (this.avatarTeamMap_ == null) {
                    this.avatarTeamMap_ = MapField.newMapField(AvatarTeamMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.avatarTeamMap_.isMutable()) {
                    this.avatarTeamMap_ = this.avatarTeamMap_.copy();
                }
                return this.avatarTeamMap_;
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public int getAvatarTeamMapCount() {
                return internalGetAvatarTeamMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public boolean containsAvatarTeamMap(int key) {
                return internalGetAvatarTeamMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            @Deprecated
            public Map<Integer, AvatarTeamOuterClass.AvatarTeam> getAvatarTeamMap() {
                return getAvatarTeamMapMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public Map<Integer, AvatarTeamOuterClass.AvatarTeam> getAvatarTeamMapMap() {
                return internalGetAvatarTeamMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public AvatarTeamOuterClass.AvatarTeam getAvatarTeamMapOrDefault(int key, AvatarTeamOuterClass.AvatarTeam defaultValue) {
                Map<Integer, AvatarTeamOuterClass.AvatarTeam> map = internalGetAvatarTeamMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public AvatarTeamOuterClass.AvatarTeam getAvatarTeamMapOrThrow(int key) {
                Map<Integer, AvatarTeamOuterClass.AvatarTeam> map = internalGetAvatarTeamMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearAvatarTeamMap() {
                internalGetMutableAvatarTeamMap().getMutableMap().clear();
                return this;
            }

            public Builder removeAvatarTeamMap(int key) {
                internalGetMutableAvatarTeamMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, AvatarTeamOuterClass.AvatarTeam> getMutableAvatarTeamMap() {
                return internalGetMutableAvatarTeamMap().getMutableMap();
            }

            public Builder putAvatarTeamMap(int key, AvatarTeamOuterClass.AvatarTeam value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableAvatarTeamMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllAvatarTeamMap(Map<Integer, AvatarTeamOuterClass.AvatarTeam> values) {
                internalGetMutableAvatarTeamMap().getMutableMap().putAll(values);
                return this;
            }

            private void ensureOwnedCostumeListIsMutable() {
                if ((this.bitField0_ & 32) == 0) {
                    this.ownedCostumeList_ = AvatarDataNotify.mutableCopy(this.ownedCostumeList_);
                    this.bitField0_ |= 32;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public List<Integer> getOwnedCostumeListList() {
                return (this.bitField0_ & 32) != 0 ? Collections.unmodifiableList(this.ownedCostumeList_) : this.ownedCostumeList_;
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public int getOwnedCostumeListCount() {
                return this.ownedCostumeList_.size();
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public int getOwnedCostumeList(int index) {
                return this.ownedCostumeList_.getInt(index);
            }

            public Builder setOwnedCostumeList(int index, int value) {
                ensureOwnedCostumeListIsMutable();
                this.ownedCostumeList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addOwnedCostumeList(int value) {
                ensureOwnedCostumeListIsMutable();
                this.ownedCostumeList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllOwnedCostumeList(Iterable<? extends Integer> values) {
                ensureOwnedCostumeListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.ownedCostumeList_);
                onChanged();
                return this;
            }

            public Builder clearOwnedCostumeList() {
                this.ownedCostumeList_ = AvatarDataNotify.emptyIntList();
                this.bitField0_ &= -33;
                onChanged();
                return this;
            }

            private void ensureBackupAvatarTeamOrderListIsMutable() {
                if ((this.bitField0_ & 64) == 0) {
                    this.backupAvatarTeamOrderList_ = AvatarDataNotify.mutableCopy(this.backupAvatarTeamOrderList_);
                    this.bitField0_ |= 64;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public List<Integer> getBackupAvatarTeamOrderListList() {
                return (this.bitField0_ & 64) != 0 ? Collections.unmodifiableList(this.backupAvatarTeamOrderList_) : this.backupAvatarTeamOrderList_;
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public int getBackupAvatarTeamOrderListCount() {
                return this.backupAvatarTeamOrderList_.size();
            }

            @Override // emu.grasscutter.net.proto.AvatarDataNotifyOuterClass.AvatarDataNotifyOrBuilder
            public int getBackupAvatarTeamOrderList(int index) {
                return this.backupAvatarTeamOrderList_.getInt(index);
            }

            public Builder setBackupAvatarTeamOrderList(int index, int value) {
                ensureBackupAvatarTeamOrderListIsMutable();
                this.backupAvatarTeamOrderList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addBackupAvatarTeamOrderList(int value) {
                ensureBackupAvatarTeamOrderListIsMutable();
                this.backupAvatarTeamOrderList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllBackupAvatarTeamOrderList(Iterable<? extends Integer> values) {
                ensureBackupAvatarTeamOrderListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.backupAvatarTeamOrderList_);
                onChanged();
                return this;
            }

            public Builder clearBackupAvatarTeamOrderList() {
                this.backupAvatarTeamOrderList_ = AvatarDataNotify.emptyIntList();
                this.bitField0_ &= -65;
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

        public static AvatarDataNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarDataNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarDataNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarDataNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AvatarInfoOuterClass.getDescriptor();
        AvatarRenameInfoOuterClass.getDescriptor();
        AvatarTeamOuterClass.getDescriptor();
    }
}
