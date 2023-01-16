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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarDieAnimationEndReqOuterClass.class */
public final class AvatarDieAnimationEndReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eAvatarDieAnimationEndReq.proto\u001a\fVector.proto\"[\n\u0018AvatarDieAnimationEndReq\u0012\u0010\n\bdie_guid\u0018\r \u0001(\u0004\u0012\u001b\n\nreborn_pos\u0018\u000e \u0001(\u000b2\u0007.Vector\u0012\u0010\n\bskill_id\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AvatarDieAnimationEndReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarDieAnimationEndReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarDieAnimationEndReq_descriptor, new String[]{"DieGuid", "RebornPos", "SkillId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarDieAnimationEndReqOuterClass$AvatarDieAnimationEndReqOrBuilder.class */
    public interface AvatarDieAnimationEndReqOrBuilder extends MessageOrBuilder {
        long getDieGuid();

        boolean hasRebornPos();

        VectorOuterClass.Vector getRebornPos();

        VectorOuterClass.VectorOrBuilder getRebornPosOrBuilder();

        int getSkillId();
    }

    private AvatarDieAnimationEndReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarDieAnimationEndReqOuterClass$AvatarDieAnimationEndReq.class */
    public static final class AvatarDieAnimationEndReq extends GeneratedMessageV3 implements AvatarDieAnimationEndReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DIE_GUID_FIELD_NUMBER = 13;
        private long dieGuid_;
        public static final int REBORN_POS_FIELD_NUMBER = 14;
        private VectorOuterClass.Vector rebornPos_;
        public static final int SKILL_ID_FIELD_NUMBER = 9;
        private int skillId_;
        private byte memoizedIsInitialized;
        private static final AvatarDieAnimationEndReq DEFAULT_INSTANCE = new AvatarDieAnimationEndReq();
        private static final Parser<AvatarDieAnimationEndReq> PARSER = new AbstractParser<AvatarDieAnimationEndReq>() { // from class: emu.grasscutter.net.proto.AvatarDieAnimationEndReqOuterClass.AvatarDieAnimationEndReq.1
            @Override // com.google.protobuf.Parser
            public AvatarDieAnimationEndReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarDieAnimationEndReq(input, extensionRegistry);
            }
        };

        private AvatarDieAnimationEndReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarDieAnimationEndReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarDieAnimationEndReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarDieAnimationEndReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 72:
                                    this.skillId_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.dieGuid_ = input.readUInt64();
                                    break;
                                case 114:
                                    VectorOuterClass.Vector.Builder subBuilder = this.rebornPos_ != null ? this.rebornPos_.toBuilder() : null;
                                    this.rebornPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.rebornPos_);
                                        this.rebornPos_ = subBuilder.buildPartial();
                                        break;
                                    }
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
            return AvatarDieAnimationEndReqOuterClass.internal_static_AvatarDieAnimationEndReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarDieAnimationEndReqOuterClass.internal_static_AvatarDieAnimationEndReq_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarDieAnimationEndReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarDieAnimationEndReqOuterClass.AvatarDieAnimationEndReqOrBuilder
        public long getDieGuid() {
            return this.dieGuid_;
        }

        @Override // emu.grasscutter.net.proto.AvatarDieAnimationEndReqOuterClass.AvatarDieAnimationEndReqOrBuilder
        public boolean hasRebornPos() {
            return this.rebornPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.AvatarDieAnimationEndReqOuterClass.AvatarDieAnimationEndReqOrBuilder
        public VectorOuterClass.Vector getRebornPos() {
            return this.rebornPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.rebornPos_;
        }

        @Override // emu.grasscutter.net.proto.AvatarDieAnimationEndReqOuterClass.AvatarDieAnimationEndReqOrBuilder
        public VectorOuterClass.VectorOrBuilder getRebornPosOrBuilder() {
            return getRebornPos();
        }

        @Override // emu.grasscutter.net.proto.AvatarDieAnimationEndReqOuterClass.AvatarDieAnimationEndReqOrBuilder
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
                output.writeUInt32(9, this.skillId_);
            }
            if (this.dieGuid_ != 0) {
                output.writeUInt64(13, this.dieGuid_);
            }
            if (this.rebornPos_ != null) {
                output.writeMessage(14, getRebornPos());
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(9, this.skillId_);
            }
            if (this.dieGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(13, this.dieGuid_);
            }
            if (this.rebornPos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(14, getRebornPos());
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
            if (!(obj instanceof AvatarDieAnimationEndReq)) {
                return equals(obj);
            }
            AvatarDieAnimationEndReq other = (AvatarDieAnimationEndReq) obj;
            if (getDieGuid() == other.getDieGuid() && hasRebornPos() == other.hasRebornPos()) {
                return (!hasRebornPos() || getRebornPos().equals(other.getRebornPos())) && getSkillId() == other.getSkillId() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + Internal.hashLong(getDieGuid());
            if (hasRebornPos()) {
                hash = (53 * ((37 * hash) + 14)) + getRebornPos().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 9)) + getSkillId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AvatarDieAnimationEndReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarDieAnimationEndReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarDieAnimationEndReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarDieAnimationEndReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarDieAnimationEndReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarDieAnimationEndReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarDieAnimationEndReq parseFrom(InputStream input) throws IOException {
            return (AvatarDieAnimationEndReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarDieAnimationEndReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarDieAnimationEndReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarDieAnimationEndReq parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarDieAnimationEndReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarDieAnimationEndReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarDieAnimationEndReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarDieAnimationEndReq parseFrom(CodedInputStream input) throws IOException {
            return (AvatarDieAnimationEndReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarDieAnimationEndReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarDieAnimationEndReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarDieAnimationEndReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarDieAnimationEndReqOuterClass$AvatarDieAnimationEndReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarDieAnimationEndReqOrBuilder {
            private long dieGuid_;
            private VectorOuterClass.Vector rebornPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> rebornPosBuilder_;
            private int skillId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarDieAnimationEndReqOuterClass.internal_static_AvatarDieAnimationEndReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarDieAnimationEndReqOuterClass.internal_static_AvatarDieAnimationEndReq_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarDieAnimationEndReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarDieAnimationEndReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.dieGuid_ = 0;
                if (this.rebornPosBuilder_ == null) {
                    this.rebornPos_ = null;
                } else {
                    this.rebornPos_ = null;
                    this.rebornPosBuilder_ = null;
                }
                this.skillId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarDieAnimationEndReqOuterClass.internal_static_AvatarDieAnimationEndReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarDieAnimationEndReq getDefaultInstanceForType() {
                return AvatarDieAnimationEndReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarDieAnimationEndReq build() {
                AvatarDieAnimationEndReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarDieAnimationEndReq buildPartial() {
                AvatarDieAnimationEndReq result = new AvatarDieAnimationEndReq(this);
                result.dieGuid_ = this.dieGuid_;
                if (this.rebornPosBuilder_ == null) {
                    result.rebornPos_ = this.rebornPos_;
                } else {
                    result.rebornPos_ = this.rebornPosBuilder_.build();
                }
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
                if (other instanceof AvatarDieAnimationEndReq) {
                    return mergeFrom((AvatarDieAnimationEndReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarDieAnimationEndReq other) {
                if (other == AvatarDieAnimationEndReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getDieGuid() != 0) {
                    setDieGuid(other.getDieGuid());
                }
                if (other.hasRebornPos()) {
                    mergeRebornPos(other.getRebornPos());
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
                AvatarDieAnimationEndReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarDieAnimationEndReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarDieAnimationEndReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarDieAnimationEndReqOuterClass.AvatarDieAnimationEndReqOrBuilder
            public long getDieGuid() {
                return this.dieGuid_;
            }

            public Builder setDieGuid(long value) {
                this.dieGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearDieGuid() {
                this.dieGuid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarDieAnimationEndReqOuterClass.AvatarDieAnimationEndReqOrBuilder
            public boolean hasRebornPos() {
                return (this.rebornPosBuilder_ == null && this.rebornPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AvatarDieAnimationEndReqOuterClass.AvatarDieAnimationEndReqOrBuilder
            public VectorOuterClass.Vector getRebornPos() {
                if (this.rebornPosBuilder_ == null) {
                    return this.rebornPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.rebornPos_;
                }
                return this.rebornPosBuilder_.getMessage();
            }

            public Builder setRebornPos(VectorOuterClass.Vector value) {
                if (this.rebornPosBuilder_ != null) {
                    this.rebornPosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.rebornPos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setRebornPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.rebornPosBuilder_ == null) {
                    this.rebornPos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.rebornPosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeRebornPos(VectorOuterClass.Vector value) {
                if (this.rebornPosBuilder_ == null) {
                    if (this.rebornPos_ != null) {
                        this.rebornPos_ = VectorOuterClass.Vector.newBuilder(this.rebornPos_).mergeFrom(value).buildPartial();
                    } else {
                        this.rebornPos_ = value;
                    }
                    onChanged();
                } else {
                    this.rebornPosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearRebornPos() {
                if (this.rebornPosBuilder_ == null) {
                    this.rebornPos_ = null;
                    onChanged();
                } else {
                    this.rebornPos_ = null;
                    this.rebornPosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getRebornPosBuilder() {
                onChanged();
                return getRebornPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AvatarDieAnimationEndReqOuterClass.AvatarDieAnimationEndReqOrBuilder
            public VectorOuterClass.VectorOrBuilder getRebornPosOrBuilder() {
                if (this.rebornPosBuilder_ != null) {
                    return this.rebornPosBuilder_.getMessageOrBuilder();
                }
                return this.rebornPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.rebornPos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getRebornPosFieldBuilder() {
                if (this.rebornPosBuilder_ == null) {
                    this.rebornPosBuilder_ = new SingleFieldBuilderV3<>(getRebornPos(), getParentForChildren(), isClean());
                    this.rebornPos_ = null;
                }
                return this.rebornPosBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AvatarDieAnimationEndReqOuterClass.AvatarDieAnimationEndReqOrBuilder
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

        public static AvatarDieAnimationEndReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarDieAnimationEndReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarDieAnimationEndReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarDieAnimationEndReq getDefaultInstanceForType() {
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
