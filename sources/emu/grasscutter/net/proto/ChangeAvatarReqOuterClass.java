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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeAvatarReqOuterClass.class */
public final class ChangeAvatarReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015ChangeAvatarReq.proto\u001a\fVector.proto\"]\n\u000fChangeAvatarReq\u0012\u0019\n\bmove_pos\u0018\t \u0001(\u000b2\u0007.Vector\u0012\f\n\u0004guid\u0018\u000e \u0001(\u0004\u0012\u000f\n\u0007is_move\u0018\u000b \u0001(\b\u0012\u0010\n\bskill_id\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ChangeAvatarReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChangeAvatarReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChangeAvatarReq_descriptor, new String[]{"MovePos", "Guid", "IsMove", "SkillId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeAvatarReqOuterClass$ChangeAvatarReqOrBuilder.class */
    public interface ChangeAvatarReqOrBuilder extends MessageOrBuilder {
        boolean hasMovePos();

        VectorOuterClass.Vector getMovePos();

        VectorOuterClass.VectorOrBuilder getMovePosOrBuilder();

        long getGuid();

        boolean getIsMove();

        int getSkillId();
    }

    private ChangeAvatarReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeAvatarReqOuterClass$ChangeAvatarReq.class */
    public static final class ChangeAvatarReq extends GeneratedMessageV3 implements ChangeAvatarReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MOVE_POS_FIELD_NUMBER = 9;
        private VectorOuterClass.Vector movePos_;
        public static final int GUID_FIELD_NUMBER = 14;
        private long guid_;
        public static final int IS_MOVE_FIELD_NUMBER = 11;
        private boolean isMove_;
        public static final int SKILL_ID_FIELD_NUMBER = 4;
        private int skillId_;
        private byte memoizedIsInitialized;
        private static final ChangeAvatarReq DEFAULT_INSTANCE = new ChangeAvatarReq();
        private static final Parser<ChangeAvatarReq> PARSER = new AbstractParser<ChangeAvatarReq>() { // from class: emu.grasscutter.net.proto.ChangeAvatarReqOuterClass.ChangeAvatarReq.1
            @Override // com.google.protobuf.Parser
            public ChangeAvatarReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChangeAvatarReq(input, extensionRegistry);
            }
        };

        private ChangeAvatarReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ChangeAvatarReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChangeAvatarReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChangeAvatarReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                this.skillId_ = input.readUInt32();
                                break;
                            case 74:
                                VectorOuterClass.Vector.Builder subBuilder = this.movePos_ != null ? this.movePos_.toBuilder() : null;
                                this.movePos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.movePos_);
                                    this.movePos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 88:
                                this.isMove_ = input.readBool();
                                break;
                            case 112:
                                this.guid_ = input.readUInt64();
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
            return ChangeAvatarReqOuterClass.internal_static_ChangeAvatarReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChangeAvatarReqOuterClass.internal_static_ChangeAvatarReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangeAvatarReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ChangeAvatarReqOuterClass.ChangeAvatarReqOrBuilder
        public boolean hasMovePos() {
            return this.movePos_ != null;
        }

        @Override // emu.grasscutter.net.proto.ChangeAvatarReqOuterClass.ChangeAvatarReqOrBuilder
        public VectorOuterClass.Vector getMovePos() {
            return this.movePos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.movePos_;
        }

        @Override // emu.grasscutter.net.proto.ChangeAvatarReqOuterClass.ChangeAvatarReqOrBuilder
        public VectorOuterClass.VectorOrBuilder getMovePosOrBuilder() {
            return getMovePos();
        }

        @Override // emu.grasscutter.net.proto.ChangeAvatarReqOuterClass.ChangeAvatarReqOrBuilder
        public long getGuid() {
            return this.guid_;
        }

        @Override // emu.grasscutter.net.proto.ChangeAvatarReqOuterClass.ChangeAvatarReqOrBuilder
        public boolean getIsMove() {
            return this.isMove_;
        }

        @Override // emu.grasscutter.net.proto.ChangeAvatarReqOuterClass.ChangeAvatarReqOrBuilder
        public int getSkillId() {
            return this.skillId_;
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
            if (this.skillId_ != 0) {
                output.writeUInt32(4, this.skillId_);
            }
            if (this.movePos_ != null) {
                output.writeMessage(9, getMovePos());
            }
            if (this.isMove_) {
                output.writeBool(11, this.isMove_);
            }
            if (this.guid_ != 0) {
                output.writeUInt64(14, this.guid_);
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
            if (this.skillId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.skillId_);
            }
            if (this.movePos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(9, getMovePos());
            }
            if (this.isMove_) {
                size2 += CodedOutputStream.computeBoolSize(11, this.isMove_);
            }
            if (this.guid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(14, this.guid_);
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
            if (!(obj instanceof ChangeAvatarReq)) {
                return equals(obj);
            }
            ChangeAvatarReq other = (ChangeAvatarReq) obj;
            if (hasMovePos() != other.hasMovePos()) {
                return false;
            }
            return (!hasMovePos() || getMovePos().equals(other.getMovePos())) && getGuid() == other.getGuid() && getIsMove() == other.getIsMove() && getSkillId() == other.getSkillId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasMovePos()) {
                hash = (53 * ((37 * hash) + 9)) + getMovePos().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 14)) + Internal.hashLong(getGuid()))) + 11)) + Internal.hashBoolean(getIsMove()))) + 4)) + getSkillId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ChangeAvatarReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChangeAvatarReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeAvatarReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChangeAvatarReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeAvatarReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChangeAvatarReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeAvatarReq parseFrom(InputStream input) throws IOException {
            return (ChangeAvatarReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChangeAvatarReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeAvatarReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChangeAvatarReq parseDelimitedFrom(InputStream input) throws IOException {
            return (ChangeAvatarReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChangeAvatarReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeAvatarReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChangeAvatarReq parseFrom(CodedInputStream input) throws IOException {
            return (ChangeAvatarReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChangeAvatarReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeAvatarReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChangeAvatarReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeAvatarReqOuterClass$ChangeAvatarReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChangeAvatarReqOrBuilder {
            private VectorOuterClass.Vector movePos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> movePosBuilder_;
            private long guid_;
            private boolean isMove_;
            private int skillId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ChangeAvatarReqOuterClass.internal_static_ChangeAvatarReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChangeAvatarReqOuterClass.internal_static_ChangeAvatarReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangeAvatarReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChangeAvatarReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.movePosBuilder_ == null) {
                    this.movePos_ = null;
                } else {
                    this.movePos_ = null;
                    this.movePosBuilder_ = null;
                }
                this.guid_ = 0;
                this.isMove_ = false;
                this.skillId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChangeAvatarReqOuterClass.internal_static_ChangeAvatarReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChangeAvatarReq getDefaultInstanceForType() {
                return ChangeAvatarReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChangeAvatarReq build() {
                ChangeAvatarReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChangeAvatarReq buildPartial() {
                ChangeAvatarReq result = new ChangeAvatarReq(this);
                if (this.movePosBuilder_ == null) {
                    result.movePos_ = this.movePos_;
                } else {
                    result.movePos_ = this.movePosBuilder_.build();
                }
                result.guid_ = this.guid_;
                result.isMove_ = this.isMove_;
                result.skillId_ = this.skillId_;
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
                if (other instanceof ChangeAvatarReq) {
                    return mergeFrom((ChangeAvatarReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChangeAvatarReq other) {
                if (other == ChangeAvatarReq.getDefaultInstance()) {
                    return this;
                }
                if (other.hasMovePos()) {
                    mergeMovePos(other.getMovePos());
                }
                if (other.getGuid() != 0) {
                    setGuid(other.getGuid());
                }
                if (other.getIsMove()) {
                    setIsMove(other.getIsMove());
                }
                if (other.getSkillId() != 0) {
                    setSkillId(other.getSkillId());
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
                ChangeAvatarReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChangeAvatarReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChangeAvatarReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ChangeAvatarReqOuterClass.ChangeAvatarReqOrBuilder
            public boolean hasMovePos() {
                return (this.movePosBuilder_ == null && this.movePos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ChangeAvatarReqOuterClass.ChangeAvatarReqOrBuilder
            public VectorOuterClass.Vector getMovePos() {
                if (this.movePosBuilder_ == null) {
                    return this.movePos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.movePos_;
                }
                return this.movePosBuilder_.getMessage();
            }

            public Builder setMovePos(VectorOuterClass.Vector value) {
                if (this.movePosBuilder_ != null) {
                    this.movePosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.movePos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setMovePos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.movePosBuilder_ == null) {
                    this.movePos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.movePosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeMovePos(VectorOuterClass.Vector value) {
                if (this.movePosBuilder_ == null) {
                    if (this.movePos_ != null) {
                        this.movePos_ = VectorOuterClass.Vector.newBuilder(this.movePos_).mergeFrom(value).buildPartial();
                    } else {
                        this.movePos_ = value;
                    }
                    onChanged();
                } else {
                    this.movePosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearMovePos() {
                if (this.movePosBuilder_ == null) {
                    this.movePos_ = null;
                    onChanged();
                } else {
                    this.movePos_ = null;
                    this.movePosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getMovePosBuilder() {
                onChanged();
                return getMovePosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ChangeAvatarReqOuterClass.ChangeAvatarReqOrBuilder
            public VectorOuterClass.VectorOrBuilder getMovePosOrBuilder() {
                if (this.movePosBuilder_ != null) {
                    return this.movePosBuilder_.getMessageOrBuilder();
                }
                return this.movePos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.movePos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getMovePosFieldBuilder() {
                if (this.movePosBuilder_ == null) {
                    this.movePosBuilder_ = new SingleFieldBuilderV3<>(getMovePos(), getParentForChildren(), isClean());
                    this.movePos_ = null;
                }
                return this.movePosBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ChangeAvatarReqOuterClass.ChangeAvatarReqOrBuilder
            public long getGuid() {
                return this.guid_;
            }

            public Builder setGuid(long value) {
                this.guid_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuid() {
                this.guid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChangeAvatarReqOuterClass.ChangeAvatarReqOrBuilder
            public boolean getIsMove() {
                return this.isMove_;
            }

            public Builder setIsMove(boolean value) {
                this.isMove_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsMove() {
                this.isMove_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChangeAvatarReqOuterClass.ChangeAvatarReqOrBuilder
            public int getSkillId() {
                return this.skillId_;
            }

            public Builder setSkillId(int value) {
                this.skillId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSkillId() {
                this.skillId_ = 0;
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

        public static ChangeAvatarReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChangeAvatarReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChangeAvatarReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChangeAvatarReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VectorOuterClass.getDescriptor();
    }
}
