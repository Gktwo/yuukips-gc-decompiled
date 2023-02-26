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
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.EnterTypeOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerEnterSceneNotifyOuterClass.class */
public final class PlayerEnterSceneNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cPlayerEnterSceneNotify.proto\u001a\fVector.proto\u001a\u000fEnterType.proto\"\u0003\n\u0016PlayerEnterSceneNotify\u0012\u001e\n\u0016isFirstLoginEnterScene\u0018\n \u0001(\b\u0012\u0017\n\u000fenterSceneToken\u0018\u0002 \u0001(\r\u0012\u0013\n\u000bprevSceneId\u0018\u0004 \u0001(\r\u0012\u0012\n\tworldType\u0018Â\b \u0001(\r\u0012\u0011\n\bisSkipUi\u0018½\u0002 \u0001(\b\u0012\u000f\n\u0007sceneId\u0018\u0003 \u0001(\r\u0012\u0014\n\u0003pos\u0018\r \u0001(\u000b2\u0007.Vector\u0012\u0012\n\nworldLevel\u0018\u0005 \u0001(\r\u0012\u0019\n\u0010sceneTransaction\u0018\u0005 \u0001(\t\u0012\u0013\n\u000benterReason\u0018J \u0001(\r\u0012\u0018\n\u0004type\u0018\t \u0001(\u000e2\n.EnterType\u0012\u0011\n\tdungeonId\u0018\u000b \u0001(\r\u0012\u0016\n\u000esceneTagIdList\u0018\b \u0003(\r\u0012\u0018\n\u0007prevPos\u0018\f \u0001(\u000b2\u0007.Vector\u0012\u0016\n\u000esceneBeginTime\u0018\u000f \u0001(\u0004\u0012\u0011\n\ttargetUid\u0018\u0001 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor(), EnterTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlayerEnterSceneNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerEnterSceneNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerEnterSceneNotify_descriptor, new String[]{"IsFirstLoginEnterScene", "EnterSceneToken", "PrevSceneId", "WorldType", "IsSkipUi", "SceneId", "Pos", "WorldLevel", "SceneTransaction", "EnterReason", "Type", "DungeonId", "SceneTagIdList", "PrevPos", "SceneBeginTime", "TargetUid"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotifyOrBuilder.class */
    public interface PlayerEnterSceneNotifyOrBuilder extends MessageOrBuilder {
        boolean getIsFirstLoginEnterScene();

        int getEnterSceneToken();

        int getPrevSceneId();

        int getWorldType();

        boolean getIsSkipUi();

        int getSceneId();

        boolean hasPos();

        VectorOuterClass.Vector getPos();

        VectorOuterClass.VectorOrBuilder getPosOrBuilder();

        int getWorldLevel();

        String getSceneTransaction();

        ByteString getSceneTransactionBytes();

        int getEnterReason();

        int getTypeValue();

        EnterTypeOuterClass.EnterType getType();

        int getDungeonId();

        List<Integer> getSceneTagIdListList();

        int getSceneTagIdListCount();

        int getSceneTagIdList(int i);

        boolean hasPrevPos();

        VectorOuterClass.Vector getPrevPos();

        VectorOuterClass.VectorOrBuilder getPrevPosOrBuilder();

        long getSceneBeginTime();

        int getTargetUid();
    }

    private PlayerEnterSceneNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify.class */
    public static final class PlayerEnterSceneNotify extends GeneratedMessageV3 implements PlayerEnterSceneNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISFIRSTLOGINENTERSCENE_FIELD_NUMBER = 10;
        private boolean isFirstLoginEnterScene_;
        public static final int ENTERSCENETOKEN_FIELD_NUMBER = 2;
        private int enterSceneToken_;
        public static final int PREVSCENEID_FIELD_NUMBER = 4;
        private int prevSceneId_;
        public static final int WORLDTYPE_FIELD_NUMBER = 1090;
        private int worldType_;
        public static final int ISSKIPUI_FIELD_NUMBER = 317;
        private boolean isSkipUi_;
        public static final int SCENEID_FIELD_NUMBER = 3;
        private int sceneId_;
        public static final int POS_FIELD_NUMBER = 13;
        private VectorOuterClass.Vector pos_;
        public static final int WORLDLEVEL_FIELD_NUMBER = 5;
        private int worldLevel_;
        public static final int SCENETRANSACTION_FIELD_NUMBER = 647;
        private volatile Object sceneTransaction_;
        public static final int ENTERREASON_FIELD_NUMBER = 74;
        private int enterReason_;
        public static final int TYPE_FIELD_NUMBER = 9;
        private int type_;
        public static final int DUNGEONID_FIELD_NUMBER = 11;
        private int dungeonId_;
        public static final int SCENETAGIDLIST_FIELD_NUMBER = 8;
        private Internal.IntList sceneTagIdList_;
        private int sceneTagIdListMemoizedSerializedSize;
        public static final int PREVPOS_FIELD_NUMBER = 12;
        private VectorOuterClass.Vector prevPos_;
        public static final int SCENEBEGINTIME_FIELD_NUMBER = 15;
        private long sceneBeginTime_;
        public static final int TARGETUID_FIELD_NUMBER = 1;
        private int targetUid_;
        private byte memoizedIsInitialized;
        private static final PlayerEnterSceneNotify DEFAULT_INSTANCE = new PlayerEnterSceneNotify();
        private static final Parser<PlayerEnterSceneNotify> PARSER = new AbstractParser<PlayerEnterSceneNotify>() { // from class: emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotify.1
            @Override // com.google.protobuf.Parser
            public PlayerEnterSceneNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerEnterSceneNotify(input, extensionRegistry);
            }
        };

        private PlayerEnterSceneNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.sceneTagIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private PlayerEnterSceneNotify() {
            this.sceneTagIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.sceneTransaction_ = "";
            this.type_ = 0;
            this.sceneTagIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerEnterSceneNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerEnterSceneNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.targetUid_ = input.readUInt32();
                                break;
                            case 16:
                                this.enterSceneToken_ = input.readUInt32();
                                break;
                            case 24:
                                this.sceneId_ = input.readUInt32();
                                break;
                            case 32:
                                this.prevSceneId_ = input.readUInt32();
                                break;
                            case 40:
                                this.worldLevel_ = input.readUInt32();
                                break;
                            case 64:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.sceneTagIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.sceneTagIdList_.addInt(input.readUInt32());
                                break;
                            case 66:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.sceneTagIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.sceneTagIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 72:
                                this.type_ = input.readEnum();
                                break;
                            case 80:
                                this.isFirstLoginEnterScene_ = input.readBool();
                                break;
                            case 88:
                                this.dungeonId_ = input.readUInt32();
                                break;
                            case 98:
                                VectorOuterClass.Vector.Builder subBuilder = this.prevPos_ != null ? this.prevPos_.toBuilder() : null;
                                this.prevPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.prevPos_);
                                    this.prevPos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 106:
                                VectorOuterClass.Vector.Builder subBuilder2 = this.pos_ != null ? this.pos_.toBuilder() : null;
                                this.pos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.pos_);
                                    this.pos_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 120:
                                this.sceneBeginTime_ = input.readUInt64();
                                break;
                            case 592:
                                this.enterReason_ = input.readUInt32();
                                break;
                            case 2536:
                                this.isSkipUi_ = input.readBool();
                                break;
                            case 5178:
                                this.sceneTransaction_ = input.readStringRequireUtf8();
                                break;
                            case 8720:
                                this.worldType_ = input.readUInt32();
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
                    this.sceneTagIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PlayerEnterSceneNotifyOuterClass.internal_static_PlayerEnterSceneNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerEnterSceneNotifyOuterClass.internal_static_PlayerEnterSceneNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerEnterSceneNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public boolean getIsFirstLoginEnterScene() {
            return this.isFirstLoginEnterScene_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public int getEnterSceneToken() {
            return this.enterSceneToken_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public int getPrevSceneId() {
            return this.prevSceneId_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public int getWorldType() {
            return this.worldType_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public boolean getIsSkipUi() {
            return this.isSkipUi_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public int getSceneId() {
            return this.sceneId_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public boolean hasPos() {
            return this.pos_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public VectorOuterClass.Vector getPos() {
            return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
            return getPos();
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public int getWorldLevel() {
            return this.worldLevel_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public String getSceneTransaction() {
            Object ref = this.sceneTransaction_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.sceneTransaction_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public ByteString getSceneTransactionBytes() {
            Object ref = this.sceneTransaction_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.sceneTransaction_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public int getEnterReason() {
            return this.enterReason_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public EnterTypeOuterClass.EnterType getType() {
            EnterTypeOuterClass.EnterType result = EnterTypeOuterClass.EnterType.valueOf(this.type_);
            return result == null ? EnterTypeOuterClass.EnterType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public int getDungeonId() {
            return this.dungeonId_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public List<Integer> getSceneTagIdListList() {
            return this.sceneTagIdList_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public int getSceneTagIdListCount() {
            return this.sceneTagIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public int getSceneTagIdList(int index) {
            return this.sceneTagIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public boolean hasPrevPos() {
            return this.prevPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public VectorOuterClass.Vector getPrevPos() {
            return this.prevPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.prevPos_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public VectorOuterClass.VectorOrBuilder getPrevPosOrBuilder() {
            return getPrevPos();
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public long getSceneBeginTime() {
            return this.sceneBeginTime_;
        }

        @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
        public int getTargetUid() {
            return this.targetUid_;
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
            if (this.targetUid_ != 0) {
                output.writeUInt32(1, this.targetUid_);
            }
            if (this.enterSceneToken_ != 0) {
                output.writeUInt32(2, this.enterSceneToken_);
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(3, this.sceneId_);
            }
            if (this.prevSceneId_ != 0) {
                output.writeUInt32(4, this.prevSceneId_);
            }
            if (this.worldLevel_ != 0) {
                output.writeUInt32(5, this.worldLevel_);
            }
            if (getSceneTagIdListList().size() > 0) {
                output.writeUInt32NoTag(66);
                output.writeUInt32NoTag(this.sceneTagIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.sceneTagIdList_.size(); i++) {
                output.writeUInt32NoTag(this.sceneTagIdList_.getInt(i));
            }
            if (this.type_ != EnterTypeOuterClass.EnterType.ENTER_TYPE_NONE.getNumber()) {
                output.writeEnum(9, this.type_);
            }
            if (this.isFirstLoginEnterScene_) {
                output.writeBool(10, this.isFirstLoginEnterScene_);
            }
            if (this.dungeonId_ != 0) {
                output.writeUInt32(11, this.dungeonId_);
            }
            if (this.prevPos_ != null) {
                output.writeMessage(12, getPrevPos());
            }
            if (this.pos_ != null) {
                output.writeMessage(13, getPos());
            }
            if (this.sceneBeginTime_ != 0) {
                output.writeUInt64(15, this.sceneBeginTime_);
            }
            if (this.enterReason_ != 0) {
                output.writeUInt32(74, this.enterReason_);
            }
            if (this.isSkipUi_) {
                output.writeBool(317, this.isSkipUi_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.sceneTransaction_)) {
                GeneratedMessageV3.writeString(output, 647, this.sceneTransaction_);
            }
            if (this.worldType_ != 0) {
                output.writeUInt32(WORLDTYPE_FIELD_NUMBER, this.worldType_);
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
            if (this.targetUid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.targetUid_);
            }
            if (this.enterSceneToken_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.enterSceneToken_);
            }
            if (this.sceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.sceneId_);
            }
            if (this.prevSceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.prevSceneId_);
            }
            if (this.worldLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.worldLevel_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.sceneTagIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.sceneTagIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getSceneTagIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.sceneTagIdListMemoizedSerializedSize = dataSize;
            if (this.type_ != EnterTypeOuterClass.EnterType.ENTER_TYPE_NONE.getNumber()) {
                size3 += CodedOutputStream.computeEnumSize(9, this.type_);
            }
            if (this.isFirstLoginEnterScene_) {
                size3 += CodedOutputStream.computeBoolSize(10, this.isFirstLoginEnterScene_);
            }
            if (this.dungeonId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(11, this.dungeonId_);
            }
            if (this.prevPos_ != null) {
                size3 += CodedOutputStream.computeMessageSize(12, getPrevPos());
            }
            if (this.pos_ != null) {
                size3 += CodedOutputStream.computeMessageSize(13, getPos());
            }
            if (this.sceneBeginTime_ != 0) {
                size3 += CodedOutputStream.computeUInt64Size(15, this.sceneBeginTime_);
            }
            if (this.enterReason_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(74, this.enterReason_);
            }
            if (this.isSkipUi_) {
                size3 += CodedOutputStream.computeBoolSize(317, this.isSkipUi_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.sceneTransaction_)) {
                size3 += GeneratedMessageV3.computeStringSize(647, this.sceneTransaction_);
            }
            if (this.worldType_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(WORLDTYPE_FIELD_NUMBER, this.worldType_);
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
            if (!(obj instanceof PlayerEnterSceneNotify)) {
                return equals(obj);
            }
            PlayerEnterSceneNotify other = (PlayerEnterSceneNotify) obj;
            if (getIsFirstLoginEnterScene() != other.getIsFirstLoginEnterScene() || getEnterSceneToken() != other.getEnterSceneToken() || getPrevSceneId() != other.getPrevSceneId() || getWorldType() != other.getWorldType() || getIsSkipUi() != other.getIsSkipUi() || getSceneId() != other.getSceneId() || hasPos() != other.hasPos()) {
                return false;
            }
            if ((!hasPos() || getPos().equals(other.getPos())) && getWorldLevel() == other.getWorldLevel() && getSceneTransaction().equals(other.getSceneTransaction()) && getEnterReason() == other.getEnterReason() && this.type_ == other.type_ && getDungeonId() == other.getDungeonId() && getSceneTagIdListList().equals(other.getSceneTagIdListList()) && hasPrevPos() == other.hasPrevPos()) {
                return (!hasPrevPos() || getPrevPos().equals(other.getPrevPos())) && getSceneBeginTime() == other.getSceneBeginTime() && getTargetUid() == other.getTargetUid() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + Internal.hashBoolean(getIsFirstLoginEnterScene()))) + 2)) + getEnterSceneToken())) + 4)) + getPrevSceneId())) + WORLDTYPE_FIELD_NUMBER)) + getWorldType())) + 317)) + Internal.hashBoolean(getIsSkipUi()))) + 3)) + getSceneId();
            if (hasPos()) {
                hash = (53 * ((37 * hash) + 13)) + getPos().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 5)) + getWorldLevel())) + 647)) + getSceneTransaction().hashCode())) + 74)) + getEnterReason())) + 9)) + this.type_)) + 11)) + getDungeonId();
            if (getSceneTagIdListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 8)) + getSceneTagIdListList().hashCode();
            }
            if (hasPrevPos()) {
                hash2 = (53 * ((37 * hash2) + 12)) + getPrevPos().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * ((53 * ((37 * hash2) + 15)) + Internal.hashLong(getSceneBeginTime()))) + 1)) + getTargetUid())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static PlayerEnterSceneNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerEnterSceneNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerEnterSceneNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerEnterSceneNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerEnterSceneNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerEnterSceneNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerEnterSceneNotify parseFrom(InputStream input) throws IOException {
            return (PlayerEnterSceneNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerEnterSceneNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerEnterSceneNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerEnterSceneNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerEnterSceneNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerEnterSceneNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerEnterSceneNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerEnterSceneNotify parseFrom(CodedInputStream input) throws IOException {
            return (PlayerEnterSceneNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerEnterSceneNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerEnterSceneNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerEnterSceneNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerEnterSceneNotifyOrBuilder {
            private int bitField0_;
            private boolean isFirstLoginEnterScene_;
            private int enterSceneToken_;
            private int prevSceneId_;
            private int worldType_;
            private boolean isSkipUi_;
            private int sceneId_;
            private VectorOuterClass.Vector pos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> posBuilder_;
            private int worldLevel_;
            private int enterReason_;
            private int dungeonId_;
            private VectorOuterClass.Vector prevPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> prevPosBuilder_;
            private long sceneBeginTime_;
            private int targetUid_;
            private Object sceneTransaction_ = "";
            private int type_ = 0;
            private Internal.IntList sceneTagIdList_ = PlayerEnterSceneNotify.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerEnterSceneNotifyOuterClass.internal_static_PlayerEnterSceneNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerEnterSceneNotifyOuterClass.internal_static_PlayerEnterSceneNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerEnterSceneNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerEnterSceneNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isFirstLoginEnterScene_ = false;
                this.enterSceneToken_ = 0;
                this.prevSceneId_ = 0;
                this.worldType_ = 0;
                this.isSkipUi_ = false;
                this.sceneId_ = 0;
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                this.worldLevel_ = 0;
                this.sceneTransaction_ = "";
                this.enterReason_ = 0;
                this.type_ = 0;
                this.dungeonId_ = 0;
                this.sceneTagIdList_ = PlayerEnterSceneNotify.emptyIntList();
                this.bitField0_ &= -2;
                if (this.prevPosBuilder_ == null) {
                    this.prevPos_ = null;
                } else {
                    this.prevPos_ = null;
                    this.prevPosBuilder_ = null;
                }
                this.sceneBeginTime_ = 0;
                this.targetUid_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerEnterSceneNotifyOuterClass.internal_static_PlayerEnterSceneNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerEnterSceneNotify getDefaultInstanceForType() {
                return PlayerEnterSceneNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerEnterSceneNotify build() {
                PlayerEnterSceneNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerEnterSceneNotify buildPartial() {
                PlayerEnterSceneNotify result = new PlayerEnterSceneNotify(this);
                int i = this.bitField0_;
                result.isFirstLoginEnterScene_ = this.isFirstLoginEnterScene_;
                result.enterSceneToken_ = this.enterSceneToken_;
                result.prevSceneId_ = this.prevSceneId_;
                result.worldType_ = this.worldType_;
                result.isSkipUi_ = this.isSkipUi_;
                result.sceneId_ = this.sceneId_;
                if (this.posBuilder_ == null) {
                    result.pos_ = this.pos_;
                } else {
                    result.pos_ = this.posBuilder_.build();
                }
                result.worldLevel_ = this.worldLevel_;
                result.sceneTransaction_ = this.sceneTransaction_;
                result.enterReason_ = this.enterReason_;
                result.type_ = this.type_;
                result.dungeonId_ = this.dungeonId_;
                if ((this.bitField0_ & 1) != 0) {
                    this.sceneTagIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.sceneTagIdList_ = this.sceneTagIdList_;
                if (this.prevPosBuilder_ == null) {
                    result.prevPos_ = this.prevPos_;
                } else {
                    result.prevPos_ = this.prevPosBuilder_.build();
                }
                result.sceneBeginTime_ = this.sceneBeginTime_;
                result.targetUid_ = this.targetUid_;
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
                if (other instanceof PlayerEnterSceneNotify) {
                    return mergeFrom((PlayerEnterSceneNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerEnterSceneNotify other) {
                if (other == PlayerEnterSceneNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsFirstLoginEnterScene()) {
                    setIsFirstLoginEnterScene(other.getIsFirstLoginEnterScene());
                }
                if (other.getEnterSceneToken() != 0) {
                    setEnterSceneToken(other.getEnterSceneToken());
                }
                if (other.getPrevSceneId() != 0) {
                    setPrevSceneId(other.getPrevSceneId());
                }
                if (other.getWorldType() != 0) {
                    setWorldType(other.getWorldType());
                }
                if (other.getIsSkipUi()) {
                    setIsSkipUi(other.getIsSkipUi());
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
                }
                if (other.hasPos()) {
                    mergePos(other.getPos());
                }
                if (other.getWorldLevel() != 0) {
                    setWorldLevel(other.getWorldLevel());
                }
                if (!other.getSceneTransaction().isEmpty()) {
                    this.sceneTransaction_ = other.sceneTransaction_;
                    onChanged();
                }
                if (other.getEnterReason() != 0) {
                    setEnterReason(other.getEnterReason());
                }
                if (other.type_ != 0) {
                    setTypeValue(other.getTypeValue());
                }
                if (other.getDungeonId() != 0) {
                    setDungeonId(other.getDungeonId());
                }
                if (!other.sceneTagIdList_.isEmpty()) {
                    if (this.sceneTagIdList_.isEmpty()) {
                        this.sceneTagIdList_ = other.sceneTagIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureSceneTagIdListIsMutable();
                        this.sceneTagIdList_.addAll(other.sceneTagIdList_);
                    }
                    onChanged();
                }
                if (other.hasPrevPos()) {
                    mergePrevPos(other.getPrevPos());
                }
                if (other.getSceneBeginTime() != 0) {
                    setSceneBeginTime(other.getSceneBeginTime());
                }
                if (other.getTargetUid() != 0) {
                    setTargetUid(other.getTargetUid());
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
                PlayerEnterSceneNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerEnterSceneNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerEnterSceneNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public boolean getIsFirstLoginEnterScene() {
                return this.isFirstLoginEnterScene_;
            }

            public Builder setIsFirstLoginEnterScene(boolean value) {
                this.isFirstLoginEnterScene_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFirstLoginEnterScene() {
                this.isFirstLoginEnterScene_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public int getEnterSceneToken() {
                return this.enterSceneToken_;
            }

            public Builder setEnterSceneToken(int value) {
                this.enterSceneToken_ = value;
                onChanged();
                return this;
            }

            public Builder clearEnterSceneToken() {
                this.enterSceneToken_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public int getPrevSceneId() {
                return this.prevSceneId_;
            }

            public Builder setPrevSceneId(int value) {
                this.prevSceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPrevSceneId() {
                this.prevSceneId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public int getWorldType() {
                return this.worldType_;
            }

            public Builder setWorldType(int value) {
                this.worldType_ = value;
                onChanged();
                return this;
            }

            public Builder clearWorldType() {
                this.worldType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public boolean getIsSkipUi() {
                return this.isSkipUi_;
            }

            public Builder setIsSkipUi(boolean value) {
                this.isSkipUi_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsSkipUi() {
                this.isSkipUi_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public int getSceneId() {
                return this.sceneId_;
            }

            public Builder setSceneId(int value) {
                this.sceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneId() {
                this.sceneId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public boolean hasPos() {
                return (this.posBuilder_ == null && this.pos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public VectorOuterClass.Vector getPos() {
                if (this.posBuilder_ == null) {
                    return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
                }
                return this.posBuilder_.getMessage();
            }

            public Builder setPos(VectorOuterClass.Vector value) {
                if (this.posBuilder_ != null) {
                    this.posBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.pos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.posBuilder_ == null) {
                    this.pos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.posBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePos(VectorOuterClass.Vector value) {
                if (this.posBuilder_ == null) {
                    if (this.pos_ != null) {
                        this.pos_ = VectorOuterClass.Vector.newBuilder(this.pos_).mergeFrom(value).buildPartial();
                    } else {
                        this.pos_ = value;
                    }
                    onChanged();
                } else {
                    this.posBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPos() {
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                    onChanged();
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getPosBuilder() {
                onChanged();
                return getPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
                if (this.posBuilder_ != null) {
                    return this.posBuilder_.getMessageOrBuilder();
                }
                return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getPosFieldBuilder() {
                if (this.posBuilder_ == null) {
                    this.posBuilder_ = new SingleFieldBuilderV3<>(getPos(), getParentForChildren(), isClean());
                    this.pos_ = null;
                }
                return this.posBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public int getWorldLevel() {
                return this.worldLevel_;
            }

            public Builder setWorldLevel(int value) {
                this.worldLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearWorldLevel() {
                this.worldLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public String getSceneTransaction() {
                Object ref = this.sceneTransaction_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.sceneTransaction_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public ByteString getSceneTransactionBytes() {
                Object ref = this.sceneTransaction_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.sceneTransaction_ = b;
                return b;
            }

            public Builder setSceneTransaction(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.sceneTransaction_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneTransaction() {
                this.sceneTransaction_ = PlayerEnterSceneNotify.getDefaultInstance().getSceneTransaction();
                onChanged();
                return this;
            }

            public Builder setSceneTransactionBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerEnterSceneNotify.checkByteStringIsUtf8(value);
                this.sceneTransaction_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public int getEnterReason() {
                return this.enterReason_;
            }

            public Builder setEnterReason(int value) {
                this.enterReason_ = value;
                onChanged();
                return this;
            }

            public Builder clearEnterReason() {
                this.enterReason_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            public Builder setTypeValue(int value) {
                this.type_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public EnterTypeOuterClass.EnterType getType() {
                EnterTypeOuterClass.EnterType result = EnterTypeOuterClass.EnterType.valueOf(this.type_);
                return result == null ? EnterTypeOuterClass.EnterType.UNRECOGNIZED : result;
            }

            public Builder setType(EnterTypeOuterClass.EnterType value) {
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

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public int getDungeonId() {
                return this.dungeonId_;
            }

            public Builder setDungeonId(int value) {
                this.dungeonId_ = value;
                onChanged();
                return this;
            }

            public Builder clearDungeonId() {
                this.dungeonId_ = 0;
                onChanged();
                return this;
            }

            private void ensureSceneTagIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.sceneTagIdList_ = PlayerEnterSceneNotify.mutableCopy(this.sceneTagIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public List<Integer> getSceneTagIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.sceneTagIdList_) : this.sceneTagIdList_;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public int getSceneTagIdListCount() {
                return this.sceneTagIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public int getSceneTagIdList(int index) {
                return this.sceneTagIdList_.getInt(index);
            }

            public Builder setSceneTagIdList(int index, int value) {
                ensureSceneTagIdListIsMutable();
                this.sceneTagIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addSceneTagIdList(int value) {
                ensureSceneTagIdListIsMutable();
                this.sceneTagIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllSceneTagIdList(Iterable<? extends Integer> values) {
                ensureSceneTagIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.sceneTagIdList_);
                onChanged();
                return this;
            }

            public Builder clearSceneTagIdList() {
                this.sceneTagIdList_ = PlayerEnterSceneNotify.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public boolean hasPrevPos() {
                return (this.prevPosBuilder_ == null && this.prevPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public VectorOuterClass.Vector getPrevPos() {
                if (this.prevPosBuilder_ == null) {
                    return this.prevPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.prevPos_;
                }
                return this.prevPosBuilder_.getMessage();
            }

            public Builder setPrevPos(VectorOuterClass.Vector value) {
                if (this.prevPosBuilder_ != null) {
                    this.prevPosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.prevPos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPrevPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.prevPosBuilder_ == null) {
                    this.prevPos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.prevPosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePrevPos(VectorOuterClass.Vector value) {
                if (this.prevPosBuilder_ == null) {
                    if (this.prevPos_ != null) {
                        this.prevPos_ = VectorOuterClass.Vector.newBuilder(this.prevPos_).mergeFrom(value).buildPartial();
                    } else {
                        this.prevPos_ = value;
                    }
                    onChanged();
                } else {
                    this.prevPosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPrevPos() {
                if (this.prevPosBuilder_ == null) {
                    this.prevPos_ = null;
                    onChanged();
                } else {
                    this.prevPos_ = null;
                    this.prevPosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getPrevPosBuilder() {
                onChanged();
                return getPrevPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public VectorOuterClass.VectorOrBuilder getPrevPosOrBuilder() {
                if (this.prevPosBuilder_ != null) {
                    return this.prevPosBuilder_.getMessageOrBuilder();
                }
                return this.prevPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.prevPos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getPrevPosFieldBuilder() {
                if (this.prevPosBuilder_ == null) {
                    this.prevPosBuilder_ = new SingleFieldBuilderV3<>(getPrevPos(), getParentForChildren(), isClean());
                    this.prevPos_ = null;
                }
                return this.prevPosBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public long getSceneBeginTime() {
                return this.sceneBeginTime_;
            }

            public Builder setSceneBeginTime(long value) {
                this.sceneBeginTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneBeginTime() {
                this.sceneBeginTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotifyOrBuilder
            public int getTargetUid() {
                return this.targetUid_;
            }

            public Builder setTargetUid(int value) {
                this.targetUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                this.targetUid_ = 0;
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

        public static PlayerEnterSceneNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerEnterSceneNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerEnterSceneNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerEnterSceneNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VectorOuterClass.getDescriptor();
        EnterTypeOuterClass.getDescriptor();
    }
}
