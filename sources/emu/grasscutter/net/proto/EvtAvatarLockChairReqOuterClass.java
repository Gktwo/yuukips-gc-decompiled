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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAvatarLockChairReqOuterClass.class */
public final class EvtAvatarLockChairReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bEvtAvatarLockChairReq.proto\u001a\fVector.proto\"C\n\u0015EvtAvatarLockChairReq\u0012\u000f\n\u0007chairId\u0018\u0003 \u0001(\u0004\u0012\u0019\n\bposition\u0018\u000e \u0001(\u000b2\u0007.VectorB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_EvtAvatarLockChairReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EvtAvatarLockChairReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EvtAvatarLockChairReq_descriptor, new String[]{"ChairId", "Position"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAvatarLockChairReqOuterClass$EvtAvatarLockChairReqOrBuilder.class */
    public interface EvtAvatarLockChairReqOrBuilder extends MessageOrBuilder {
        long getChairId();

        boolean hasPosition();

        VectorOuterClass.Vector getPosition();

        VectorOuterClass.VectorOrBuilder getPositionOrBuilder();
    }

    private EvtAvatarLockChairReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAvatarLockChairReqOuterClass$EvtAvatarLockChairReq.class */
    public static final class EvtAvatarLockChairReq extends GeneratedMessageV3 implements EvtAvatarLockChairReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CHAIRID_FIELD_NUMBER = 3;
        private long chairId_;
        public static final int POSITION_FIELD_NUMBER = 14;
        private VectorOuterClass.Vector position_;
        private byte memoizedIsInitialized;
        private static final EvtAvatarLockChairReq DEFAULT_INSTANCE = new EvtAvatarLockChairReq();
        private static final Parser<EvtAvatarLockChairReq> PARSER = new AbstractParser<EvtAvatarLockChairReq>() { // from class: emu.grasscutter.net.proto.EvtAvatarLockChairReqOuterClass.EvtAvatarLockChairReq.1
            @Override // com.google.protobuf.Parser
            public EvtAvatarLockChairReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EvtAvatarLockChairReq(input, extensionRegistry);
            }
        };

        private EvtAvatarLockChairReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EvtAvatarLockChairReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EvtAvatarLockChairReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EvtAvatarLockChairReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 24:
                                    this.chairId_ = input.readUInt64();
                                    break;
                                case 114:
                                    VectorOuterClass.Vector.Builder subBuilder = this.position_ != null ? this.position_.toBuilder() : null;
                                    this.position_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.position_);
                                        this.position_ = subBuilder.buildPartial();
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
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        }
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
            return EvtAvatarLockChairReqOuterClass.internal_static_EvtAvatarLockChairReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EvtAvatarLockChairReqOuterClass.internal_static_EvtAvatarLockChairReq_fieldAccessorTable.ensureFieldAccessorsInitialized(EvtAvatarLockChairReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EvtAvatarLockChairReqOuterClass.EvtAvatarLockChairReqOrBuilder
        public long getChairId() {
            return this.chairId_;
        }

        @Override // emu.grasscutter.net.proto.EvtAvatarLockChairReqOuterClass.EvtAvatarLockChairReqOrBuilder
        public boolean hasPosition() {
            return this.position_ != null;
        }

        @Override // emu.grasscutter.net.proto.EvtAvatarLockChairReqOuterClass.EvtAvatarLockChairReqOrBuilder
        public VectorOuterClass.Vector getPosition() {
            return this.position_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.position_;
        }

        @Override // emu.grasscutter.net.proto.EvtAvatarLockChairReqOuterClass.EvtAvatarLockChairReqOrBuilder
        public VectorOuterClass.VectorOrBuilder getPositionOrBuilder() {
            return getPosition();
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
            if (this.chairId_ != 0) {
                output.writeUInt64(3, this.chairId_);
            }
            if (this.position_ != null) {
                output.writeMessage(14, getPosition());
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
            if (this.chairId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(3, this.chairId_);
            }
            if (this.position_ != null) {
                size2 += CodedOutputStream.computeMessageSize(14, getPosition());
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
            if (!(obj instanceof EvtAvatarLockChairReq)) {
                return equals(obj);
            }
            EvtAvatarLockChairReq other = (EvtAvatarLockChairReq) obj;
            if (getChairId() == other.getChairId() && hasPosition() == other.hasPosition()) {
                return (!hasPosition() || getPosition().equals(other.getPosition())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + Internal.hashLong(getChairId());
            if (hasPosition()) {
                hash = (53 * ((37 * hash) + 14)) + getPosition().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static EvtAvatarLockChairReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtAvatarLockChairReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtAvatarLockChairReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtAvatarLockChairReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtAvatarLockChairReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtAvatarLockChairReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtAvatarLockChairReq parseFrom(InputStream input) throws IOException {
            return (EvtAvatarLockChairReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EvtAvatarLockChairReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtAvatarLockChairReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EvtAvatarLockChairReq parseDelimitedFrom(InputStream input) throws IOException {
            return (EvtAvatarLockChairReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EvtAvatarLockChairReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtAvatarLockChairReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EvtAvatarLockChairReq parseFrom(CodedInputStream input) throws IOException {
            return (EvtAvatarLockChairReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EvtAvatarLockChairReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtAvatarLockChairReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EvtAvatarLockChairReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAvatarLockChairReqOuterClass$EvtAvatarLockChairReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EvtAvatarLockChairReqOrBuilder {
            private long chairId_;
            private VectorOuterClass.Vector position_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> positionBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EvtAvatarLockChairReqOuterClass.internal_static_EvtAvatarLockChairReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EvtAvatarLockChairReqOuterClass.internal_static_EvtAvatarLockChairReq_fieldAccessorTable.ensureFieldAccessorsInitialized(EvtAvatarLockChairReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EvtAvatarLockChairReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.chairId_ = 0;
                if (this.positionBuilder_ == null) {
                    this.position_ = null;
                } else {
                    this.position_ = null;
                    this.positionBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EvtAvatarLockChairReqOuterClass.internal_static_EvtAvatarLockChairReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EvtAvatarLockChairReq getDefaultInstanceForType() {
                return EvtAvatarLockChairReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EvtAvatarLockChairReq build() {
                EvtAvatarLockChairReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EvtAvatarLockChairReq buildPartial() {
                EvtAvatarLockChairReq result = new EvtAvatarLockChairReq(this);
                result.chairId_ = this.chairId_;
                if (this.positionBuilder_ == null) {
                    result.position_ = this.position_;
                } else {
                    result.position_ = this.positionBuilder_.build();
                }
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
                if (other instanceof EvtAvatarLockChairReq) {
                    return mergeFrom((EvtAvatarLockChairReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EvtAvatarLockChairReq other) {
                if (other == EvtAvatarLockChairReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getChairId() != 0) {
                    setChairId(other.getChairId());
                }
                if (other.hasPosition()) {
                    mergePosition(other.getPosition());
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
                EvtAvatarLockChairReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = EvtAvatarLockChairReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EvtAvatarLockChairReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EvtAvatarLockChairReqOuterClass.EvtAvatarLockChairReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.EvtAvatarLockChairReqOuterClass.EvtAvatarLockChairReqOrBuilder
            public boolean hasPosition() {
                return (this.positionBuilder_ == null && this.position_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.EvtAvatarLockChairReqOuterClass.EvtAvatarLockChairReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.EvtAvatarLockChairReqOuterClass.EvtAvatarLockChairReqOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static EvtAvatarLockChairReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EvtAvatarLockChairReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EvtAvatarLockChairReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EvtAvatarLockChairReq getDefaultInstanceForType() {
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
