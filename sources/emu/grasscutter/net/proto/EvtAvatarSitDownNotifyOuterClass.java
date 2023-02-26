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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAvatarSitDownNotifyOuterClass.class */
public final class EvtAvatarSitDownNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cEvtAvatarSitDownNotify.proto\u001a\fVector.proto\"V\n\u0016EvtAvatarSitDownNotify\u0012\u0019\n\bposition\u0018\u0002 \u0001(\u000b2\u0007.Vector\u0012\u0010\n\bentityId\u0018\u0004 \u0001(\r\u0012\u000f\n\u0007chairId\u0018\u000b \u0001(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_EvtAvatarSitDownNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EvtAvatarSitDownNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EvtAvatarSitDownNotify_descriptor, new String[]{"Position", "EntityId", "ChairId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAvatarSitDownNotifyOuterClass$EvtAvatarSitDownNotifyOrBuilder.class */
    public interface EvtAvatarSitDownNotifyOrBuilder extends MessageOrBuilder {
        boolean hasPosition();

        VectorOuterClass.Vector getPosition();

        VectorOuterClass.VectorOrBuilder getPositionOrBuilder();

        int getEntityId();

        long getChairId();
    }

    private EvtAvatarSitDownNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAvatarSitDownNotifyOuterClass$EvtAvatarSitDownNotify.class */
    public static final class EvtAvatarSitDownNotify extends GeneratedMessageV3 implements EvtAvatarSitDownNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int POSITION_FIELD_NUMBER = 2;
        private VectorOuterClass.Vector position_;
        public static final int ENTITYID_FIELD_NUMBER = 4;
        private int entityId_;
        public static final int CHAIRID_FIELD_NUMBER = 11;
        private long chairId_;
        private byte memoizedIsInitialized;
        private static final EvtAvatarSitDownNotify DEFAULT_INSTANCE = new EvtAvatarSitDownNotify();
        private static final Parser<EvtAvatarSitDownNotify> PARSER = new AbstractParser<EvtAvatarSitDownNotify>() { // from class: emu.grasscutter.net.proto.EvtAvatarSitDownNotifyOuterClass.EvtAvatarSitDownNotify.1
            @Override // com.google.protobuf.Parser
            public EvtAvatarSitDownNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EvtAvatarSitDownNotify(input, extensionRegistry);
            }
        };

        private EvtAvatarSitDownNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EvtAvatarSitDownNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EvtAvatarSitDownNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EvtAvatarSitDownNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 18:
                                    VectorOuterClass.Vector.Builder subBuilder = this.position_ != null ? this.position_.toBuilder() : null;
                                    this.position_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.position_);
                                        this.position_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 32:
                                    this.entityId_ = input.readUInt32();
                                    break;
                                case 88:
                                    this.chairId_ = input.readUInt64();
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
            return EvtAvatarSitDownNotifyOuterClass.internal_static_EvtAvatarSitDownNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EvtAvatarSitDownNotifyOuterClass.internal_static_EvtAvatarSitDownNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(EvtAvatarSitDownNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EvtAvatarSitDownNotifyOuterClass.EvtAvatarSitDownNotifyOrBuilder
        public boolean hasPosition() {
            return this.position_ != null;
        }

        @Override // emu.grasscutter.net.proto.EvtAvatarSitDownNotifyOuterClass.EvtAvatarSitDownNotifyOrBuilder
        public VectorOuterClass.Vector getPosition() {
            return this.position_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.position_;
        }

        @Override // emu.grasscutter.net.proto.EvtAvatarSitDownNotifyOuterClass.EvtAvatarSitDownNotifyOrBuilder
        public VectorOuterClass.VectorOrBuilder getPositionOrBuilder() {
            return getPosition();
        }

        @Override // emu.grasscutter.net.proto.EvtAvatarSitDownNotifyOuterClass.EvtAvatarSitDownNotifyOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.EvtAvatarSitDownNotifyOuterClass.EvtAvatarSitDownNotifyOrBuilder
        public long getChairId() {
            return this.chairId_;
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
            if (this.position_ != null) {
                output.writeMessage(2, getPosition());
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(4, this.entityId_);
            }
            if (this.chairId_ != 0) {
                output.writeUInt64(11, this.chairId_);
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
            if (this.position_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(2, getPosition());
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.entityId_);
            }
            if (this.chairId_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(11, this.chairId_);
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
            if (!(obj instanceof EvtAvatarSitDownNotify)) {
                return equals(obj);
            }
            EvtAvatarSitDownNotify other = (EvtAvatarSitDownNotify) obj;
            if (hasPosition() != other.hasPosition()) {
                return false;
            }
            return (!hasPosition() || getPosition().equals(other.getPosition())) && getEntityId() == other.getEntityId() && getChairId() == other.getChairId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasPosition()) {
                hash = (53 * ((37 * hash) + 2)) + getPosition().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 4)) + getEntityId())) + 11)) + Internal.hashLong(getChairId()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static EvtAvatarSitDownNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtAvatarSitDownNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtAvatarSitDownNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtAvatarSitDownNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtAvatarSitDownNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtAvatarSitDownNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtAvatarSitDownNotify parseFrom(InputStream input) throws IOException {
            return (EvtAvatarSitDownNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EvtAvatarSitDownNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtAvatarSitDownNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EvtAvatarSitDownNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (EvtAvatarSitDownNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EvtAvatarSitDownNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtAvatarSitDownNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EvtAvatarSitDownNotify parseFrom(CodedInputStream input) throws IOException {
            return (EvtAvatarSitDownNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EvtAvatarSitDownNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtAvatarSitDownNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EvtAvatarSitDownNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAvatarSitDownNotifyOuterClass$EvtAvatarSitDownNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EvtAvatarSitDownNotifyOrBuilder {
            private VectorOuterClass.Vector position_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> positionBuilder_;
            private int entityId_;
            private long chairId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EvtAvatarSitDownNotifyOuterClass.internal_static_EvtAvatarSitDownNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EvtAvatarSitDownNotifyOuterClass.internal_static_EvtAvatarSitDownNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(EvtAvatarSitDownNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EvtAvatarSitDownNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.positionBuilder_ == null) {
                    this.position_ = null;
                } else {
                    this.position_ = null;
                    this.positionBuilder_ = null;
                }
                this.entityId_ = 0;
                this.chairId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EvtAvatarSitDownNotifyOuterClass.internal_static_EvtAvatarSitDownNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EvtAvatarSitDownNotify getDefaultInstanceForType() {
                return EvtAvatarSitDownNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EvtAvatarSitDownNotify build() {
                EvtAvatarSitDownNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EvtAvatarSitDownNotify buildPartial() {
                EvtAvatarSitDownNotify result = new EvtAvatarSitDownNotify(this);
                if (this.positionBuilder_ == null) {
                    result.position_ = this.position_;
                } else {
                    result.position_ = this.positionBuilder_.build();
                }
                result.entityId_ = this.entityId_;
                result.chairId_ = this.chairId_;
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
                if (other instanceof EvtAvatarSitDownNotify) {
                    return mergeFrom((EvtAvatarSitDownNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EvtAvatarSitDownNotify other) {
                if (other == EvtAvatarSitDownNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasPosition()) {
                    mergePosition(other.getPosition());
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.getChairId() != 0) {
                    setChairId(other.getChairId());
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
                EvtAvatarSitDownNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = EvtAvatarSitDownNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EvtAvatarSitDownNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EvtAvatarSitDownNotifyOuterClass.EvtAvatarSitDownNotifyOrBuilder
            public boolean hasPosition() {
                return (this.positionBuilder_ == null && this.position_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.EvtAvatarSitDownNotifyOuterClass.EvtAvatarSitDownNotifyOrBuilder
            public VectorOuterClass.Vector getPosition() {
                if (this.positionBuilder_ == null) {
                    return this.position_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.position_;
                }
                return this.positionBuilder_.getMessage();
            }

            public Builder setPosition(VectorOuterClass.Vector value) {
                if (this.positionBuilder_ != null) {
                    this.positionBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.position_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPosition(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.positionBuilder_ == null) {
                    this.position_ = builderForValue.build();
                    onChanged();
                } else {
                    this.positionBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePosition(VectorOuterClass.Vector value) {
                if (this.positionBuilder_ == null) {
                    if (this.position_ != null) {
                        this.position_ = VectorOuterClass.Vector.newBuilder(this.position_).mergeFrom(value).buildPartial();
                    } else {
                        this.position_ = value;
                    }
                    onChanged();
                } else {
                    this.positionBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPosition() {
                if (this.positionBuilder_ == null) {
                    this.position_ = null;
                    onChanged();
                } else {
                    this.position_ = null;
                    this.positionBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getPositionBuilder() {
                onChanged();
                return getPositionFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.EvtAvatarSitDownNotifyOuterClass.EvtAvatarSitDownNotifyOrBuilder
            public VectorOuterClass.VectorOrBuilder getPositionOrBuilder() {
                if (this.positionBuilder_ != null) {
                    return this.positionBuilder_.getMessageOrBuilder();
                }
                return this.position_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.position_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getPositionFieldBuilder() {
                if (this.positionBuilder_ == null) {
                    this.positionBuilder_ = new SingleFieldBuilderV3<>(getPosition(), getParentForChildren(), isClean());
                    this.position_ = null;
                }
                return this.positionBuilder_;
            }

            @Override // emu.grasscutter.net.proto.EvtAvatarSitDownNotifyOuterClass.EvtAvatarSitDownNotifyOrBuilder
            public int getEntityId() {
                return this.entityId_;
            }

            public Builder setEntityId(int value) {
                this.entityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearEntityId() {
                this.entityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtAvatarSitDownNotifyOuterClass.EvtAvatarSitDownNotifyOrBuilder
            public long getChairId() {
                return this.chairId_;
            }

            public Builder setChairId(long value) {
                this.chairId_ = value;
                onChanged();
                return this;
            }

            public Builder clearChairId() {
                this.chairId_ = 0;
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

        public static EvtAvatarSitDownNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EvtAvatarSitDownNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EvtAvatarSitDownNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EvtAvatarSitDownNotify getDefaultInstanceForType() {
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
