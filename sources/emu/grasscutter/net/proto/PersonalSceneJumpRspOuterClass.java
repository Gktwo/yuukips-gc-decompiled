package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PersonalSceneJumpRspOuterClass.class */
public final class PersonalSceneJumpRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aPersonalSceneJumpRsp.proto\u001a\fVector.proto\"V\n\u0014PersonalSceneJumpRsp\u0012\u0013\n\u000bdestSceneId\u0018\u0003 \u0001(\r\u0012\u0018\n\u0007destPos\u0018\u0002 \u0001(\u000b2\u0007.Vector\u0012\u000f\n\u0007retcode\u0018\f \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PersonalSceneJumpRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PersonalSceneJumpRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PersonalSceneJumpRsp_descriptor, new String[]{"DestSceneId", "DestPos", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PersonalSceneJumpRspOuterClass$PersonalSceneJumpRspOrBuilder.class */
    public interface PersonalSceneJumpRspOrBuilder extends MessageOrBuilder {
        int getDestSceneId();

        boolean hasDestPos();

        VectorOuterClass.Vector getDestPos();

        VectorOuterClass.VectorOrBuilder getDestPosOrBuilder();

        int getRetcode();
    }

    private PersonalSceneJumpRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PersonalSceneJumpRspOuterClass$PersonalSceneJumpRsp.class */
    public static final class PersonalSceneJumpRsp extends GeneratedMessageV3 implements PersonalSceneJumpRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DESTSCENEID_FIELD_NUMBER = 3;
        private int destSceneId_;
        public static final int DESTPOS_FIELD_NUMBER = 2;
        private VectorOuterClass.Vector destPos_;
        public static final int RETCODE_FIELD_NUMBER = 12;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final PersonalSceneJumpRsp DEFAULT_INSTANCE = new PersonalSceneJumpRsp();
        private static final Parser<PersonalSceneJumpRsp> PARSER = new AbstractParser<PersonalSceneJumpRsp>() { // from class: emu.grasscutter.net.proto.PersonalSceneJumpRspOuterClass.PersonalSceneJumpRsp.1
            @Override // com.google.protobuf.Parser
            public PersonalSceneJumpRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PersonalSceneJumpRsp(input, extensionRegistry);
            }
        };

        private PersonalSceneJumpRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PersonalSceneJumpRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PersonalSceneJumpRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PersonalSceneJumpRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    VectorOuterClass.Vector.Builder subBuilder = this.destPos_ != null ? this.destPos_.toBuilder() : null;
                                    this.destPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.destPos_);
                                        this.destPos_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 24:
                                    this.destSceneId_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.retcode_ = input.readInt32();
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
            return PersonalSceneJumpRspOuterClass.internal_static_PersonalSceneJumpRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PersonalSceneJumpRspOuterClass.internal_static_PersonalSceneJumpRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(PersonalSceneJumpRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PersonalSceneJumpRspOuterClass.PersonalSceneJumpRspOrBuilder
        public int getDestSceneId() {
            return this.destSceneId_;
        }

        @Override // emu.grasscutter.net.proto.PersonalSceneJumpRspOuterClass.PersonalSceneJumpRspOrBuilder
        public boolean hasDestPos() {
            return this.destPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.PersonalSceneJumpRspOuterClass.PersonalSceneJumpRspOrBuilder
        public VectorOuterClass.Vector getDestPos() {
            return this.destPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.destPos_;
        }

        @Override // emu.grasscutter.net.proto.PersonalSceneJumpRspOuterClass.PersonalSceneJumpRspOrBuilder
        public VectorOuterClass.VectorOrBuilder getDestPosOrBuilder() {
            return getDestPos();
        }

        @Override // emu.grasscutter.net.proto.PersonalSceneJumpRspOuterClass.PersonalSceneJumpRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
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
            if (this.destPos_ != null) {
                output.writeMessage(2, getDestPos());
            }
            if (this.destSceneId_ != 0) {
                output.writeUInt32(3, this.destSceneId_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(12, this.retcode_);
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
            if (this.destPos_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(2, getDestPos());
            }
            if (this.destSceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.destSceneId_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(12, this.retcode_);
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
            if (!(obj instanceof PersonalSceneJumpRsp)) {
                return equals(obj);
            }
            PersonalSceneJumpRsp other = (PersonalSceneJumpRsp) obj;
            if (getDestSceneId() == other.getDestSceneId() && hasDestPos() == other.hasDestPos()) {
                return (!hasDestPos() || getDestPos().equals(other.getDestPos())) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getDestSceneId();
            if (hasDestPos()) {
                hash = (53 * ((37 * hash) + 2)) + getDestPos().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 12)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PersonalSceneJumpRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PersonalSceneJumpRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PersonalSceneJumpRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PersonalSceneJumpRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PersonalSceneJumpRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PersonalSceneJumpRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PersonalSceneJumpRsp parseFrom(InputStream input) throws IOException {
            return (PersonalSceneJumpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PersonalSceneJumpRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PersonalSceneJumpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PersonalSceneJumpRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (PersonalSceneJumpRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PersonalSceneJumpRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PersonalSceneJumpRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PersonalSceneJumpRsp parseFrom(CodedInputStream input) throws IOException {
            return (PersonalSceneJumpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PersonalSceneJumpRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PersonalSceneJumpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PersonalSceneJumpRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PersonalSceneJumpRspOuterClass$PersonalSceneJumpRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PersonalSceneJumpRspOrBuilder {
            private int destSceneId_;
            private VectorOuterClass.Vector destPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> destPosBuilder_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PersonalSceneJumpRspOuterClass.internal_static_PersonalSceneJumpRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PersonalSceneJumpRspOuterClass.internal_static_PersonalSceneJumpRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(PersonalSceneJumpRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PersonalSceneJumpRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.destSceneId_ = 0;
                if (this.destPosBuilder_ == null) {
                    this.destPos_ = null;
                } else {
                    this.destPos_ = null;
                    this.destPosBuilder_ = null;
                }
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PersonalSceneJumpRspOuterClass.internal_static_PersonalSceneJumpRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PersonalSceneJumpRsp getDefaultInstanceForType() {
                return PersonalSceneJumpRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PersonalSceneJumpRsp build() {
                PersonalSceneJumpRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PersonalSceneJumpRsp buildPartial() {
                PersonalSceneJumpRsp result = new PersonalSceneJumpRsp(this);
                result.destSceneId_ = this.destSceneId_;
                if (this.destPosBuilder_ == null) {
                    result.destPos_ = this.destPos_;
                } else {
                    result.destPos_ = this.destPosBuilder_.build();
                }
                result.retcode_ = this.retcode_;
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
                if (other instanceof PersonalSceneJumpRsp) {
                    return mergeFrom((PersonalSceneJumpRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PersonalSceneJumpRsp other) {
                if (other == PersonalSceneJumpRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getDestSceneId() != 0) {
                    setDestSceneId(other.getDestSceneId());
                }
                if (other.hasDestPos()) {
                    mergeDestPos(other.getDestPos());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                PersonalSceneJumpRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = PersonalSceneJumpRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PersonalSceneJumpRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PersonalSceneJumpRspOuterClass.PersonalSceneJumpRspOrBuilder
            public int getDestSceneId() {
                return this.destSceneId_;
            }

            public Builder setDestSceneId(int value) {
                this.destSceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearDestSceneId() {
                this.destSceneId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PersonalSceneJumpRspOuterClass.PersonalSceneJumpRspOrBuilder
            public boolean hasDestPos() {
                return (this.destPosBuilder_ == null && this.destPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PersonalSceneJumpRspOuterClass.PersonalSceneJumpRspOrBuilder
            public VectorOuterClass.Vector getDestPos() {
                if (this.destPosBuilder_ == null) {
                    return this.destPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.destPos_;
                }
                return this.destPosBuilder_.getMessage();
            }

            public Builder setDestPos(VectorOuterClass.Vector value) {
                if (this.destPosBuilder_ != null) {
                    this.destPosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.destPos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setDestPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.destPosBuilder_ == null) {
                    this.destPos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.destPosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeDestPos(VectorOuterClass.Vector value) {
                if (this.destPosBuilder_ == null) {
                    if (this.destPos_ != null) {
                        this.destPos_ = VectorOuterClass.Vector.newBuilder(this.destPos_).mergeFrom(value).buildPartial();
                    } else {
                        this.destPos_ = value;
                    }
                    onChanged();
                } else {
                    this.destPosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearDestPos() {
                if (this.destPosBuilder_ == null) {
                    this.destPos_ = null;
                    onChanged();
                } else {
                    this.destPos_ = null;
                    this.destPosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getDestPosBuilder() {
                onChanged();
                return getDestPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PersonalSceneJumpRspOuterClass.PersonalSceneJumpRspOrBuilder
            public VectorOuterClass.VectorOrBuilder getDestPosOrBuilder() {
                if (this.destPosBuilder_ != null) {
                    return this.destPosBuilder_.getMessageOrBuilder();
                }
                return this.destPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.destPos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getDestPosFieldBuilder() {
                if (this.destPosBuilder_ == null) {
                    this.destPosBuilder_ = new SingleFieldBuilderV3<>(getDestPos(), getParentForChildren(), isClean());
                    this.destPos_ = null;
                }
                return this.destPosBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PersonalSceneJumpRspOuterClass.PersonalSceneJumpRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static PersonalSceneJumpRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PersonalSceneJumpRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PersonalSceneJumpRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PersonalSceneJumpRsp getDefaultInstanceForType() {
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
