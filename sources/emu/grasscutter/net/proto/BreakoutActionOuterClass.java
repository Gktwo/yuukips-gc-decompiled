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
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.BreakoutVector2OuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutActionOuterClass.class */
public final class BreakoutActionOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014BreakoutAction.proto\u001a\u0015BreakoutVector2.proto\"Ã\u0005\n\u000eBreakoutAction\u00127\n\u000baction_type\u0018\u0001 \u0001(\u000e2\".BreakoutAction.BreakoutActionType\u0012\u0018\n\u0010client_game_time\u0018\u0002 \u0001(\u0004\u0012\u0018\n\u0010server_game_time\u0018\u0003 \u0001(\u0004\u0012\u0011\n\tis_failed\u0018\u0004 \u0001(\b\u0012\u0011\n\tpre_index\u0018\u0005 \u0001(\r\u0012\u0011\n\tnew_index\u0018\u0006 \u0001(\r\u0012\u001d\n\u0003pos\u0018\u0007 \u0001(\u000b2\u0010.BreakoutVector2\u0012\"\n\bmove_dir\u0018\b \u0001(\u000b2\u0010.BreakoutVector2\u0012\r\n\u0005speed\u0018\t \u0001(\u0005\u0012\u000f\n\u0007peer_id\u0018\n \u0001(\r\u0012\u0014\n\felement_type\u0018\u000b \u0001(\r\u0012\u001d\n\u0015element_reaction_buff\u0018\f \u0001(\r\u0012\u001c\n\u0014speed_increase_count\u0018\r \u0001(\r\u0012\u0016\n\u000ehas_extra_ball\u0018\u000e \u0001(\b\u0012(\n\u000eextra_ball_dir\u0018\u000f \u0001(\u000b2\u0010.BreakoutVector2\u0012\u0018\n\u0010extra_ball_index\u0018\u0010 \u0001(\r\u0012\u000e\n\u0006offset\u0018\u0011 \u0001(\u0005\u0012\u001b\n\u0013Unk3300_AIEBGJHBOHL\u0018\u0012 \u0001(\u0004\"Ë\u0001\n\u0012BreakoutActionType\u0012\u001d\n\u0019BREAKOUT_ACTION_TYPE_NONE\u0010��\u0012$\n BREAKOUT_ACTION_TYPE_LAUNCH_BALL\u0010\u0001\u0012%\n!BREAKOUT_ACTION_TYPE_DESTROY_BALL\u0010\u0002\u0012'\n#BREAKOUT_ACTION_TYPE_FALLING_OBJECT\u0010\u0003\u0012 \n\u001cBREAKOUT_ACTION_TYPE_MISSILE\u0010\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BreakoutVector2OuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BreakoutAction_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BreakoutAction_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BreakoutAction_descriptor, new String[]{"ActionType", "ClientGameTime", "ServerGameTime", "IsFailed", "PreIndex", "NewIndex", "Pos", "MoveDir", "Speed", "PeerId", "ElementType", "ElementReactionBuff", "SpeedIncreaseCount", "HasExtraBall", "ExtraBallDir", "ExtraBallIndex", "Offset", "Unk3300AIEBGJHBOHL"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutActionOuterClass$BreakoutActionOrBuilder.class */
    public interface BreakoutActionOrBuilder extends MessageOrBuilder {
        int getActionTypeValue();

        BreakoutAction.BreakoutActionType getActionType();

        long getClientGameTime();

        long getServerGameTime();

        boolean getIsFailed();

        int getPreIndex();

        int getNewIndex();

        boolean hasPos();

        BreakoutVector2OuterClass.BreakoutVector2 getPos();

        BreakoutVector2OuterClass.BreakoutVector2OrBuilder getPosOrBuilder();

        boolean hasMoveDir();

        BreakoutVector2OuterClass.BreakoutVector2 getMoveDir();

        BreakoutVector2OuterClass.BreakoutVector2OrBuilder getMoveDirOrBuilder();

        int getSpeed();

        int getPeerId();

        int getElementType();

        int getElementReactionBuff();

        int getSpeedIncreaseCount();

        boolean getHasExtraBall();

        boolean hasExtraBallDir();

        BreakoutVector2OuterClass.BreakoutVector2 getExtraBallDir();

        BreakoutVector2OuterClass.BreakoutVector2OrBuilder getExtraBallDirOrBuilder();

        int getExtraBallIndex();

        int getOffset();

        long getUnk3300AIEBGJHBOHL();
    }

    private BreakoutActionOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutActionOuterClass$BreakoutAction.class */
    public static final class BreakoutAction extends GeneratedMessageV3 implements BreakoutActionOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ACTION_TYPE_FIELD_NUMBER = 1;
        private int actionType_;
        public static final int CLIENT_GAME_TIME_FIELD_NUMBER = 2;
        private long clientGameTime_;
        public static final int SERVER_GAME_TIME_FIELD_NUMBER = 3;
        private long serverGameTime_;
        public static final int IS_FAILED_FIELD_NUMBER = 4;
        private boolean isFailed_;
        public static final int PRE_INDEX_FIELD_NUMBER = 5;
        private int preIndex_;
        public static final int NEW_INDEX_FIELD_NUMBER = 6;
        private int newIndex_;
        public static final int POS_FIELD_NUMBER = 7;
        private BreakoutVector2OuterClass.BreakoutVector2 pos_;
        public static final int MOVE_DIR_FIELD_NUMBER = 8;
        private BreakoutVector2OuterClass.BreakoutVector2 moveDir_;
        public static final int SPEED_FIELD_NUMBER = 9;
        private int speed_;
        public static final int PEER_ID_FIELD_NUMBER = 10;
        private int peerId_;
        public static final int ELEMENT_TYPE_FIELD_NUMBER = 11;
        private int elementType_;
        public static final int ELEMENT_REACTION_BUFF_FIELD_NUMBER = 12;
        private int elementReactionBuff_;
        public static final int SPEED_INCREASE_COUNT_FIELD_NUMBER = 13;
        private int speedIncreaseCount_;
        public static final int HAS_EXTRA_BALL_FIELD_NUMBER = 14;
        private boolean hasExtraBall_;
        public static final int EXTRA_BALL_DIR_FIELD_NUMBER = 15;
        private BreakoutVector2OuterClass.BreakoutVector2 extraBallDir_;
        public static final int EXTRA_BALL_INDEX_FIELD_NUMBER = 16;
        private int extraBallIndex_;
        public static final int OFFSET_FIELD_NUMBER = 17;
        private int offset_;
        public static final int UNK3300_AIEBGJHBOHL_FIELD_NUMBER = 18;
        private long unk3300AIEBGJHBOHL_;
        private byte memoizedIsInitialized;
        private static final BreakoutAction DEFAULT_INSTANCE = new BreakoutAction();
        private static final Parser<BreakoutAction> PARSER = new AbstractParser<BreakoutAction>() { // from class: emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutAction.1
            @Override // com.google.protobuf.Parser
            public BreakoutAction parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BreakoutAction(input, extensionRegistry);
            }
        };

        private BreakoutAction(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BreakoutAction() {
            this.memoizedIsInitialized = -1;
            this.actionType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BreakoutAction();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BreakoutAction(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
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
                                this.actionType_ = input.readEnum();
                                break;
                            case 16:
                                this.clientGameTime_ = input.readUInt64();
                                break;
                            case 24:
                                this.serverGameTime_ = input.readUInt64();
                                break;
                            case 32:
                                this.isFailed_ = input.readBool();
                                break;
                            case 40:
                                this.preIndex_ = input.readUInt32();
                                break;
                            case 48:
                                this.newIndex_ = input.readUInt32();
                                break;
                            case 58:
                                BreakoutVector2OuterClass.BreakoutVector2.Builder subBuilder = this.pos_ != null ? this.pos_.toBuilder() : null;
                                this.pos_ = (BreakoutVector2OuterClass.BreakoutVector2) input.readMessage(BreakoutVector2OuterClass.BreakoutVector2.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.pos_);
                                    this.pos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 66:
                                BreakoutVector2OuterClass.BreakoutVector2.Builder subBuilder2 = this.moveDir_ != null ? this.moveDir_.toBuilder() : null;
                                this.moveDir_ = (BreakoutVector2OuterClass.BreakoutVector2) input.readMessage(BreakoutVector2OuterClass.BreakoutVector2.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.moveDir_);
                                    this.moveDir_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 72:
                                this.speed_ = input.readInt32();
                                break;
                            case 80:
                                this.peerId_ = input.readUInt32();
                                break;
                            case 88:
                                this.elementType_ = input.readUInt32();
                                break;
                            case 96:
                                this.elementReactionBuff_ = input.readUInt32();
                                break;
                            case 104:
                                this.speedIncreaseCount_ = input.readUInt32();
                                break;
                            case 112:
                                this.hasExtraBall_ = input.readBool();
                                break;
                            case 122:
                                BreakoutVector2OuterClass.BreakoutVector2.Builder subBuilder3 = this.extraBallDir_ != null ? this.extraBallDir_.toBuilder() : null;
                                this.extraBallDir_ = (BreakoutVector2OuterClass.BreakoutVector2) input.readMessage(BreakoutVector2OuterClass.BreakoutVector2.parser(), extensionRegistry);
                                if (subBuilder3 == null) {
                                    break;
                                } else {
                                    subBuilder3.mergeFrom(this.extraBallDir_);
                                    this.extraBallDir_ = subBuilder3.buildPartial();
                                    break;
                                }
                            case 128:
                                this.extraBallIndex_ = input.readUInt32();
                                break;
                            case 136:
                                this.offset_ = input.readInt32();
                                break;
                            case 144:
                                this.unk3300AIEBGJHBOHL_ = input.readUInt64();
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
            return BreakoutActionOuterClass.internal_static_BreakoutAction_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BreakoutActionOuterClass.internal_static_BreakoutAction_fieldAccessorTable.ensureFieldAccessorsInitialized(BreakoutAction.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutActionOuterClass$BreakoutAction$BreakoutActionType.class */
        public enum BreakoutActionType implements ProtocolMessageEnum {
            BREAKOUT_ACTION_TYPE_NONE(0),
            BREAKOUT_ACTION_TYPE_LAUNCH_BALL(1),
            BREAKOUT_ACTION_TYPE_DESTROY_BALL(2),
            BREAKOUT_ACTION_TYPE_FALLING_OBJECT(3),
            BREAKOUT_ACTION_TYPE_MISSILE(4),
            UNRECOGNIZED(-1);
            
            public static final int BREAKOUT_ACTION_TYPE_NONE_VALUE = 0;
            public static final int BREAKOUT_ACTION_TYPE_LAUNCH_BALL_VALUE = 1;
            public static final int BREAKOUT_ACTION_TYPE_DESTROY_BALL_VALUE = 2;
            public static final int BREAKOUT_ACTION_TYPE_FALLING_OBJECT_VALUE = 3;
            public static final int BREAKOUT_ACTION_TYPE_MISSILE_VALUE = 4;
            private static final Internal.EnumLiteMap<BreakoutActionType> internalValueMap = new Internal.EnumLiteMap<BreakoutActionType>() { // from class: emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutAction.BreakoutActionType.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public BreakoutActionType findValueByNumber(int number) {
                    return BreakoutActionType.forNumber(number);
                }
            };
            private static final BreakoutActionType[] VALUES = values();
            private final int value;

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static BreakoutActionType valueOf(int value) {
                return forNumber(value);
            }

            public static BreakoutActionType forNumber(int value) {
                switch (value) {
                    case 0:
                        return BREAKOUT_ACTION_TYPE_NONE;
                    case 1:
                        return BREAKOUT_ACTION_TYPE_LAUNCH_BALL;
                    case 2:
                        return BREAKOUT_ACTION_TYPE_DESTROY_BALL;
                    case 3:
                        return BREAKOUT_ACTION_TYPE_FALLING_OBJECT;
                    case 4:
                        return BREAKOUT_ACTION_TYPE_MISSILE;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<BreakoutActionType> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                if (this != UNRECOGNIZED) {
                    return getDescriptor().getValues().get(ordinal());
                }
                throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return BreakoutAction.getDescriptor().getEnumTypes().get(0);
            }

            public static BreakoutActionType valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                } else if (desc.getIndex() == -1) {
                    return UNRECOGNIZED;
                } else {
                    return VALUES[desc.getIndex()];
                }
            }

            BreakoutActionType(int value) {
                this.value = value;
            }
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public int getActionTypeValue() {
            return this.actionType_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public BreakoutActionType getActionType() {
            BreakoutActionType result = BreakoutActionType.valueOf(this.actionType_);
            return result == null ? BreakoutActionType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public long getClientGameTime() {
            return this.clientGameTime_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public long getServerGameTime() {
            return this.serverGameTime_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public boolean getIsFailed() {
            return this.isFailed_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public int getPreIndex() {
            return this.preIndex_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public int getNewIndex() {
            return this.newIndex_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public boolean hasPos() {
            return this.pos_ != null;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public BreakoutVector2OuterClass.BreakoutVector2 getPos() {
            return this.pos_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.pos_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public BreakoutVector2OuterClass.BreakoutVector2OrBuilder getPosOrBuilder() {
            return getPos();
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public boolean hasMoveDir() {
            return this.moveDir_ != null;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public BreakoutVector2OuterClass.BreakoutVector2 getMoveDir() {
            return this.moveDir_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.moveDir_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public BreakoutVector2OuterClass.BreakoutVector2OrBuilder getMoveDirOrBuilder() {
            return getMoveDir();
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public int getSpeed() {
            return this.speed_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public int getPeerId() {
            return this.peerId_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public int getElementType() {
            return this.elementType_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public int getElementReactionBuff() {
            return this.elementReactionBuff_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public int getSpeedIncreaseCount() {
            return this.speedIncreaseCount_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public boolean getHasExtraBall() {
            return this.hasExtraBall_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public boolean hasExtraBallDir() {
            return this.extraBallDir_ != null;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public BreakoutVector2OuterClass.BreakoutVector2 getExtraBallDir() {
            return this.extraBallDir_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.extraBallDir_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public BreakoutVector2OuterClass.BreakoutVector2OrBuilder getExtraBallDirOrBuilder() {
            return getExtraBallDir();
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public int getExtraBallIndex() {
            return this.extraBallIndex_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public int getOffset() {
            return this.offset_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public long getUnk3300AIEBGJHBOHL() {
            return this.unk3300AIEBGJHBOHL_;
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
            if (this.actionType_ != BreakoutActionType.BREAKOUT_ACTION_TYPE_NONE.getNumber()) {
                output.writeEnum(1, this.actionType_);
            }
            if (this.clientGameTime_ != 0) {
                output.writeUInt64(2, this.clientGameTime_);
            }
            if (this.serverGameTime_ != 0) {
                output.writeUInt64(3, this.serverGameTime_);
            }
            if (this.isFailed_) {
                output.writeBool(4, this.isFailed_);
            }
            if (this.preIndex_ != 0) {
                output.writeUInt32(5, this.preIndex_);
            }
            if (this.newIndex_ != 0) {
                output.writeUInt32(6, this.newIndex_);
            }
            if (this.pos_ != null) {
                output.writeMessage(7, getPos());
            }
            if (this.moveDir_ != null) {
                output.writeMessage(8, getMoveDir());
            }
            if (this.speed_ != 0) {
                output.writeInt32(9, this.speed_);
            }
            if (this.peerId_ != 0) {
                output.writeUInt32(10, this.peerId_);
            }
            if (this.elementType_ != 0) {
                output.writeUInt32(11, this.elementType_);
            }
            if (this.elementReactionBuff_ != 0) {
                output.writeUInt32(12, this.elementReactionBuff_);
            }
            if (this.speedIncreaseCount_ != 0) {
                output.writeUInt32(13, this.speedIncreaseCount_);
            }
            if (this.hasExtraBall_) {
                output.writeBool(14, this.hasExtraBall_);
            }
            if (this.extraBallDir_ != null) {
                output.writeMessage(15, getExtraBallDir());
            }
            if (this.extraBallIndex_ != 0) {
                output.writeUInt32(16, this.extraBallIndex_);
            }
            if (this.offset_ != 0) {
                output.writeInt32(17, this.offset_);
            }
            if (this.unk3300AIEBGJHBOHL_ != 0) {
                output.writeUInt64(18, this.unk3300AIEBGJHBOHL_);
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
            if (this.actionType_ != BreakoutActionType.BREAKOUT_ACTION_TYPE_NONE.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(1, this.actionType_);
            }
            if (this.clientGameTime_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(2, this.clientGameTime_);
            }
            if (this.serverGameTime_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(3, this.serverGameTime_);
            }
            if (this.isFailed_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.isFailed_);
            }
            if (this.preIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.preIndex_);
            }
            if (this.newIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.newIndex_);
            }
            if (this.pos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(7, getPos());
            }
            if (this.moveDir_ != null) {
                size2 += CodedOutputStream.computeMessageSize(8, getMoveDir());
            }
            if (this.speed_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(9, this.speed_);
            }
            if (this.peerId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.peerId_);
            }
            if (this.elementType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.elementType_);
            }
            if (this.elementReactionBuff_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.elementReactionBuff_);
            }
            if (this.speedIncreaseCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.speedIncreaseCount_);
            }
            if (this.hasExtraBall_) {
                size2 += CodedOutputStream.computeBoolSize(14, this.hasExtraBall_);
            }
            if (this.extraBallDir_ != null) {
                size2 += CodedOutputStream.computeMessageSize(15, getExtraBallDir());
            }
            if (this.extraBallIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(16, this.extraBallIndex_);
            }
            if (this.offset_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(17, this.offset_);
            }
            if (this.unk3300AIEBGJHBOHL_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(18, this.unk3300AIEBGJHBOHL_);
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
            if (!(obj instanceof BreakoutAction)) {
                return equals(obj);
            }
            BreakoutAction other = (BreakoutAction) obj;
            if (this.actionType_ != other.actionType_ || getClientGameTime() != other.getClientGameTime() || getServerGameTime() != other.getServerGameTime() || getIsFailed() != other.getIsFailed() || getPreIndex() != other.getPreIndex() || getNewIndex() != other.getNewIndex() || hasPos() != other.hasPos()) {
                return false;
            }
            if ((hasPos() && !getPos().equals(other.getPos())) || hasMoveDir() != other.hasMoveDir()) {
                return false;
            }
            if ((!hasMoveDir() || getMoveDir().equals(other.getMoveDir())) && getSpeed() == other.getSpeed() && getPeerId() == other.getPeerId() && getElementType() == other.getElementType() && getElementReactionBuff() == other.getElementReactionBuff() && getSpeedIncreaseCount() == other.getSpeedIncreaseCount() && getHasExtraBall() == other.getHasExtraBall() && hasExtraBallDir() == other.hasExtraBallDir()) {
                return (!hasExtraBallDir() || getExtraBallDir().equals(other.getExtraBallDir())) && getExtraBallIndex() == other.getExtraBallIndex() && getOffset() == other.getOffset() && getUnk3300AIEBGJHBOHL() == other.getUnk3300AIEBGJHBOHL() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + this.actionType_)) + 2)) + Internal.hashLong(getClientGameTime()))) + 3)) + Internal.hashLong(getServerGameTime()))) + 4)) + Internal.hashBoolean(getIsFailed()))) + 5)) + getPreIndex())) + 6)) + getNewIndex();
            if (hasPos()) {
                hash = (53 * ((37 * hash) + 7)) + getPos().hashCode();
            }
            if (hasMoveDir()) {
                hash = (53 * ((37 * hash) + 8)) + getMoveDir().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 9)) + getSpeed())) + 10)) + getPeerId())) + 11)) + getElementType())) + 12)) + getElementReactionBuff())) + 13)) + getSpeedIncreaseCount())) + 14)) + Internal.hashBoolean(getHasExtraBall());
            if (hasExtraBallDir()) {
                hash2 = (53 * ((37 * hash2) + 15)) + getExtraBallDir().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + 16)) + getExtraBallIndex())) + 17)) + getOffset())) + 18)) + Internal.hashLong(getUnk3300AIEBGJHBOHL()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static BreakoutAction parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutAction parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutAction parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutAction parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutAction parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutAction parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutAction parseFrom(InputStream input) throws IOException {
            return (BreakoutAction) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BreakoutAction parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutAction) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BreakoutAction parseDelimitedFrom(InputStream input) throws IOException {
            return (BreakoutAction) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BreakoutAction parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutAction) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BreakoutAction parseFrom(CodedInputStream input) throws IOException {
            return (BreakoutAction) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BreakoutAction parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutAction) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BreakoutAction prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutActionOuterClass$BreakoutAction$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BreakoutActionOrBuilder {
            private int actionType_ = 0;
            private long clientGameTime_;
            private long serverGameTime_;
            private boolean isFailed_;
            private int preIndex_;
            private int newIndex_;
            private BreakoutVector2OuterClass.BreakoutVector2 pos_;
            private SingleFieldBuilderV3<BreakoutVector2OuterClass.BreakoutVector2, BreakoutVector2OuterClass.BreakoutVector2.Builder, BreakoutVector2OuterClass.BreakoutVector2OrBuilder> posBuilder_;
            private BreakoutVector2OuterClass.BreakoutVector2 moveDir_;
            private SingleFieldBuilderV3<BreakoutVector2OuterClass.BreakoutVector2, BreakoutVector2OuterClass.BreakoutVector2.Builder, BreakoutVector2OuterClass.BreakoutVector2OrBuilder> moveDirBuilder_;
            private int speed_;
            private int peerId_;
            private int elementType_;
            private int elementReactionBuff_;
            private int speedIncreaseCount_;
            private boolean hasExtraBall_;
            private BreakoutVector2OuterClass.BreakoutVector2 extraBallDir_;
            private SingleFieldBuilderV3<BreakoutVector2OuterClass.BreakoutVector2, BreakoutVector2OuterClass.BreakoutVector2.Builder, BreakoutVector2OuterClass.BreakoutVector2OrBuilder> extraBallDirBuilder_;
            private int extraBallIndex_;
            private int offset_;
            private long unk3300AIEBGJHBOHL_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BreakoutActionOuterClass.internal_static_BreakoutAction_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BreakoutActionOuterClass.internal_static_BreakoutAction_fieldAccessorTable.ensureFieldAccessorsInitialized(BreakoutAction.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BreakoutAction.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.actionType_ = 0;
                this.clientGameTime_ = 0;
                this.serverGameTime_ = 0;
                this.isFailed_ = false;
                this.preIndex_ = 0;
                this.newIndex_ = 0;
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                if (this.moveDirBuilder_ == null) {
                    this.moveDir_ = null;
                } else {
                    this.moveDir_ = null;
                    this.moveDirBuilder_ = null;
                }
                this.speed_ = 0;
                this.peerId_ = 0;
                this.elementType_ = 0;
                this.elementReactionBuff_ = 0;
                this.speedIncreaseCount_ = 0;
                this.hasExtraBall_ = false;
                if (this.extraBallDirBuilder_ == null) {
                    this.extraBallDir_ = null;
                } else {
                    this.extraBallDir_ = null;
                    this.extraBallDirBuilder_ = null;
                }
                this.extraBallIndex_ = 0;
                this.offset_ = 0;
                this.unk3300AIEBGJHBOHL_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BreakoutActionOuterClass.internal_static_BreakoutAction_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BreakoutAction getDefaultInstanceForType() {
                return BreakoutAction.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BreakoutAction build() {
                BreakoutAction result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BreakoutAction buildPartial() {
                BreakoutAction result = new BreakoutAction(this);
                result.actionType_ = this.actionType_;
                result.clientGameTime_ = this.clientGameTime_;
                result.serverGameTime_ = this.serverGameTime_;
                result.isFailed_ = this.isFailed_;
                result.preIndex_ = this.preIndex_;
                result.newIndex_ = this.newIndex_;
                if (this.posBuilder_ == null) {
                    result.pos_ = this.pos_;
                } else {
                    result.pos_ = this.posBuilder_.build();
                }
                if (this.moveDirBuilder_ == null) {
                    result.moveDir_ = this.moveDir_;
                } else {
                    result.moveDir_ = this.moveDirBuilder_.build();
                }
                result.speed_ = this.speed_;
                result.peerId_ = this.peerId_;
                result.elementType_ = this.elementType_;
                result.elementReactionBuff_ = this.elementReactionBuff_;
                result.speedIncreaseCount_ = this.speedIncreaseCount_;
                result.hasExtraBall_ = this.hasExtraBall_;
                if (this.extraBallDirBuilder_ == null) {
                    result.extraBallDir_ = this.extraBallDir_;
                } else {
                    result.extraBallDir_ = this.extraBallDirBuilder_.build();
                }
                result.extraBallIndex_ = this.extraBallIndex_;
                result.offset_ = this.offset_;
                result.unk3300AIEBGJHBOHL_ = this.unk3300AIEBGJHBOHL_;
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
                if (other instanceof BreakoutAction) {
                    return mergeFrom((BreakoutAction) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BreakoutAction other) {
                if (other == BreakoutAction.getDefaultInstance()) {
                    return this;
                }
                if (other.actionType_ != 0) {
                    setActionTypeValue(other.getActionTypeValue());
                }
                if (other.getClientGameTime() != 0) {
                    setClientGameTime(other.getClientGameTime());
                }
                if (other.getServerGameTime() != 0) {
                    setServerGameTime(other.getServerGameTime());
                }
                if (other.getIsFailed()) {
                    setIsFailed(other.getIsFailed());
                }
                if (other.getPreIndex() != 0) {
                    setPreIndex(other.getPreIndex());
                }
                if (other.getNewIndex() != 0) {
                    setNewIndex(other.getNewIndex());
                }
                if (other.hasPos()) {
                    mergePos(other.getPos());
                }
                if (other.hasMoveDir()) {
                    mergeMoveDir(other.getMoveDir());
                }
                if (other.getSpeed() != 0) {
                    setSpeed(other.getSpeed());
                }
                if (other.getPeerId() != 0) {
                    setPeerId(other.getPeerId());
                }
                if (other.getElementType() != 0) {
                    setElementType(other.getElementType());
                }
                if (other.getElementReactionBuff() != 0) {
                    setElementReactionBuff(other.getElementReactionBuff());
                }
                if (other.getSpeedIncreaseCount() != 0) {
                    setSpeedIncreaseCount(other.getSpeedIncreaseCount());
                }
                if (other.getHasExtraBall()) {
                    setHasExtraBall(other.getHasExtraBall());
                }
                if (other.hasExtraBallDir()) {
                    mergeExtraBallDir(other.getExtraBallDir());
                }
                if (other.getExtraBallIndex() != 0) {
                    setExtraBallIndex(other.getExtraBallIndex());
                }
                if (other.getOffset() != 0) {
                    setOffset(other.getOffset());
                }
                if (other.getUnk3300AIEBGJHBOHL() != 0) {
                    setUnk3300AIEBGJHBOHL(other.getUnk3300AIEBGJHBOHL());
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
                BreakoutAction parsedMessage = null;
                try {
                    try {
                        parsedMessage = BreakoutAction.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BreakoutAction) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public int getActionTypeValue() {
                return this.actionType_;
            }

            public Builder setActionTypeValue(int value) {
                this.actionType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public BreakoutActionType getActionType() {
                BreakoutActionType result = BreakoutActionType.valueOf(this.actionType_);
                return result == null ? BreakoutActionType.UNRECOGNIZED : result;
            }

            public Builder setActionType(BreakoutActionType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.actionType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearActionType() {
                this.actionType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public long getClientGameTime() {
                return this.clientGameTime_;
            }

            public Builder setClientGameTime(long value) {
                this.clientGameTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientGameTime() {
                this.clientGameTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public long getServerGameTime() {
                return this.serverGameTime_;
            }

            public Builder setServerGameTime(long value) {
                this.serverGameTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearServerGameTime() {
                this.serverGameTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public boolean getIsFailed() {
                return this.isFailed_;
            }

            public Builder setIsFailed(boolean value) {
                this.isFailed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFailed() {
                this.isFailed_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public int getPreIndex() {
                return this.preIndex_;
            }

            public Builder setPreIndex(int value) {
                this.preIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearPreIndex() {
                this.preIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public int getNewIndex() {
                return this.newIndex_;
            }

            public Builder setNewIndex(int value) {
                this.newIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearNewIndex() {
                this.newIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public boolean hasPos() {
                return (this.posBuilder_ == null && this.pos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public BreakoutVector2OuterClass.BreakoutVector2 getPos() {
                if (this.posBuilder_ == null) {
                    return this.pos_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.pos_;
                }
                return this.posBuilder_.getMessage();
            }

            public Builder setPos(BreakoutVector2OuterClass.BreakoutVector2 value) {
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

            public Builder setPos(BreakoutVector2OuterClass.BreakoutVector2.Builder builderForValue) {
                if (this.posBuilder_ == null) {
                    this.pos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.posBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePos(BreakoutVector2OuterClass.BreakoutVector2 value) {
                if (this.posBuilder_ == null) {
                    if (this.pos_ != null) {
                        this.pos_ = BreakoutVector2OuterClass.BreakoutVector2.newBuilder(this.pos_).mergeFrom(value).buildPartial();
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

            public BreakoutVector2OuterClass.BreakoutVector2.Builder getPosBuilder() {
                onChanged();
                return getPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public BreakoutVector2OuterClass.BreakoutVector2OrBuilder getPosOrBuilder() {
                if (this.posBuilder_ != null) {
                    return this.posBuilder_.getMessageOrBuilder();
                }
                return this.pos_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.pos_;
            }

            private SingleFieldBuilderV3<BreakoutVector2OuterClass.BreakoutVector2, BreakoutVector2OuterClass.BreakoutVector2.Builder, BreakoutVector2OuterClass.BreakoutVector2OrBuilder> getPosFieldBuilder() {
                if (this.posBuilder_ == null) {
                    this.posBuilder_ = new SingleFieldBuilderV3<>(getPos(), getParentForChildren(), isClean());
                    this.pos_ = null;
                }
                return this.posBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public boolean hasMoveDir() {
                return (this.moveDirBuilder_ == null && this.moveDir_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public BreakoutVector2OuterClass.BreakoutVector2 getMoveDir() {
                if (this.moveDirBuilder_ == null) {
                    return this.moveDir_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.moveDir_;
                }
                return this.moveDirBuilder_.getMessage();
            }

            public Builder setMoveDir(BreakoutVector2OuterClass.BreakoutVector2 value) {
                if (this.moveDirBuilder_ != null) {
                    this.moveDirBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.moveDir_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setMoveDir(BreakoutVector2OuterClass.BreakoutVector2.Builder builderForValue) {
                if (this.moveDirBuilder_ == null) {
                    this.moveDir_ = builderForValue.build();
                    onChanged();
                } else {
                    this.moveDirBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeMoveDir(BreakoutVector2OuterClass.BreakoutVector2 value) {
                if (this.moveDirBuilder_ == null) {
                    if (this.moveDir_ != null) {
                        this.moveDir_ = BreakoutVector2OuterClass.BreakoutVector2.newBuilder(this.moveDir_).mergeFrom(value).buildPartial();
                    } else {
                        this.moveDir_ = value;
                    }
                    onChanged();
                } else {
                    this.moveDirBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearMoveDir() {
                if (this.moveDirBuilder_ == null) {
                    this.moveDir_ = null;
                    onChanged();
                } else {
                    this.moveDir_ = null;
                    this.moveDirBuilder_ = null;
                }
                return this;
            }

            public BreakoutVector2OuterClass.BreakoutVector2.Builder getMoveDirBuilder() {
                onChanged();
                return getMoveDirFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public BreakoutVector2OuterClass.BreakoutVector2OrBuilder getMoveDirOrBuilder() {
                if (this.moveDirBuilder_ != null) {
                    return this.moveDirBuilder_.getMessageOrBuilder();
                }
                return this.moveDir_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.moveDir_;
            }

            private SingleFieldBuilderV3<BreakoutVector2OuterClass.BreakoutVector2, BreakoutVector2OuterClass.BreakoutVector2.Builder, BreakoutVector2OuterClass.BreakoutVector2OrBuilder> getMoveDirFieldBuilder() {
                if (this.moveDirBuilder_ == null) {
                    this.moveDirBuilder_ = new SingleFieldBuilderV3<>(getMoveDir(), getParentForChildren(), isClean());
                    this.moveDir_ = null;
                }
                return this.moveDirBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public int getSpeed() {
                return this.speed_;
            }

            public Builder setSpeed(int value) {
                this.speed_ = value;
                onChanged();
                return this;
            }

            public Builder clearSpeed() {
                this.speed_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public int getPeerId() {
                return this.peerId_;
            }

            public Builder setPeerId(int value) {
                this.peerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPeerId() {
                this.peerId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public int getElementType() {
                return this.elementType_;
            }

            public Builder setElementType(int value) {
                this.elementType_ = value;
                onChanged();
                return this;
            }

            public Builder clearElementType() {
                this.elementType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public int getElementReactionBuff() {
                return this.elementReactionBuff_;
            }

            public Builder setElementReactionBuff(int value) {
                this.elementReactionBuff_ = value;
                onChanged();
                return this;
            }

            public Builder clearElementReactionBuff() {
                this.elementReactionBuff_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public int getSpeedIncreaseCount() {
                return this.speedIncreaseCount_;
            }

            public Builder setSpeedIncreaseCount(int value) {
                this.speedIncreaseCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearSpeedIncreaseCount() {
                this.speedIncreaseCount_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public boolean getHasExtraBall() {
                return this.hasExtraBall_;
            }

            public Builder setHasExtraBall(boolean value) {
                this.hasExtraBall_ = value;
                onChanged();
                return this;
            }

            public Builder clearHasExtraBall() {
                this.hasExtraBall_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public boolean hasExtraBallDir() {
                return (this.extraBallDirBuilder_ == null && this.extraBallDir_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public BreakoutVector2OuterClass.BreakoutVector2 getExtraBallDir() {
                if (this.extraBallDirBuilder_ == null) {
                    return this.extraBallDir_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.extraBallDir_;
                }
                return this.extraBallDirBuilder_.getMessage();
            }

            public Builder setExtraBallDir(BreakoutVector2OuterClass.BreakoutVector2 value) {
                if (this.extraBallDirBuilder_ != null) {
                    this.extraBallDirBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.extraBallDir_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setExtraBallDir(BreakoutVector2OuterClass.BreakoutVector2.Builder builderForValue) {
                if (this.extraBallDirBuilder_ == null) {
                    this.extraBallDir_ = builderForValue.build();
                    onChanged();
                } else {
                    this.extraBallDirBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeExtraBallDir(BreakoutVector2OuterClass.BreakoutVector2 value) {
                if (this.extraBallDirBuilder_ == null) {
                    if (this.extraBallDir_ != null) {
                        this.extraBallDir_ = BreakoutVector2OuterClass.BreakoutVector2.newBuilder(this.extraBallDir_).mergeFrom(value).buildPartial();
                    } else {
                        this.extraBallDir_ = value;
                    }
                    onChanged();
                } else {
                    this.extraBallDirBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearExtraBallDir() {
                if (this.extraBallDirBuilder_ == null) {
                    this.extraBallDir_ = null;
                    onChanged();
                } else {
                    this.extraBallDir_ = null;
                    this.extraBallDirBuilder_ = null;
                }
                return this;
            }

            public BreakoutVector2OuterClass.BreakoutVector2.Builder getExtraBallDirBuilder() {
                onChanged();
                return getExtraBallDirFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public BreakoutVector2OuterClass.BreakoutVector2OrBuilder getExtraBallDirOrBuilder() {
                if (this.extraBallDirBuilder_ != null) {
                    return this.extraBallDirBuilder_.getMessageOrBuilder();
                }
                return this.extraBallDir_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.extraBallDir_;
            }

            private SingleFieldBuilderV3<BreakoutVector2OuterClass.BreakoutVector2, BreakoutVector2OuterClass.BreakoutVector2.Builder, BreakoutVector2OuterClass.BreakoutVector2OrBuilder> getExtraBallDirFieldBuilder() {
                if (this.extraBallDirBuilder_ == null) {
                    this.extraBallDirBuilder_ = new SingleFieldBuilderV3<>(getExtraBallDir(), getParentForChildren(), isClean());
                    this.extraBallDir_ = null;
                }
                return this.extraBallDirBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public int getExtraBallIndex() {
                return this.extraBallIndex_;
            }

            public Builder setExtraBallIndex(int value) {
                this.extraBallIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearExtraBallIndex() {
                this.extraBallIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public int getOffset() {
                return this.offset_;
            }

            public Builder setOffset(int value) {
                this.offset_ = value;
                onChanged();
                return this;
            }

            public Builder clearOffset() {
                this.offset_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public long getUnk3300AIEBGJHBOHL() {
                return this.unk3300AIEBGJHBOHL_;
            }

            public Builder setUnk3300AIEBGJHBOHL(long value) {
                this.unk3300AIEBGJHBOHL_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300AIEBGJHBOHL() {
                this.unk3300AIEBGJHBOHL_ = 0;
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

        public static BreakoutAction getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BreakoutAction> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BreakoutAction> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BreakoutAction getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BreakoutVector2OuterClass.getDescriptor();
    }
}
