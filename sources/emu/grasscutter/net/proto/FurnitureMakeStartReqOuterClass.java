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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeStartReqOuterClass.class */
public final class FurnitureMakeStartReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bFurnitureMakeStartReq.proto\"9\n\u0015FurnitureMakeStartReq\u0012\u000e\n\u0006makeId\u0018\u000f \u0001(\r\u0012\u0010\n\bavatarId\u0018\r \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_FurnitureMakeStartReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FurnitureMakeStartReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FurnitureMakeStartReq_descriptor, new String[]{"MakeId", "AvatarId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeStartReqOuterClass$FurnitureMakeStartReqOrBuilder.class */
    public interface FurnitureMakeStartReqOrBuilder extends MessageOrBuilder {
        int getMakeId();

        int getAvatarId();
    }

    private FurnitureMakeStartReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeStartReqOuterClass$FurnitureMakeStartReq.class */
    public static final class FurnitureMakeStartReq extends GeneratedMessageV3 implements FurnitureMakeStartReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MAKEID_FIELD_NUMBER = 15;
        private int makeId_;
        public static final int AVATARID_FIELD_NUMBER = 13;
        private int avatarId_;
        private byte memoizedIsInitialized;
        private static final FurnitureMakeStartReq DEFAULT_INSTANCE = new FurnitureMakeStartReq();
        private static final Parser<FurnitureMakeStartReq> PARSER = new AbstractParser<FurnitureMakeStartReq>() { // from class: emu.grasscutter.net.proto.FurnitureMakeStartReqOuterClass.FurnitureMakeStartReq.1
            @Override // com.google.protobuf.Parser
            public FurnitureMakeStartReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FurnitureMakeStartReq(input, extensionRegistry);
            }
        };

        private FurnitureMakeStartReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FurnitureMakeStartReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FurnitureMakeStartReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FurnitureMakeStartReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 104:
                                this.avatarId_ = input.readUInt32();
                                break;
                            case 120:
                                this.makeId_ = input.readUInt32();
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
            return FurnitureMakeStartReqOuterClass.internal_static_FurnitureMakeStartReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FurnitureMakeStartReqOuterClass.internal_static_FurnitureMakeStartReq_fieldAccessorTable.ensureFieldAccessorsInitialized(FurnitureMakeStartReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeStartReqOuterClass.FurnitureMakeStartReqOrBuilder
        public int getMakeId() {
            return this.makeId_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeStartReqOuterClass.FurnitureMakeStartReqOrBuilder
        public int getAvatarId() {
            return this.avatarId_;
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
            if (this.avatarId_ != 0) {
                output.writeUInt32(13, this.avatarId_);
            }
            if (this.makeId_ != 0) {
                output.writeUInt32(15, this.makeId_);
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
            if (this.avatarId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(13, this.avatarId_);
            }
            if (this.makeId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.makeId_);
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
            if (!(obj instanceof FurnitureMakeStartReq)) {
                return equals(obj);
            }
            FurnitureMakeStartReq other = (FurnitureMakeStartReq) obj;
            return getMakeId() == other.getMakeId() && getAvatarId() == other.getAvatarId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getMakeId())) + 13)) + getAvatarId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static FurnitureMakeStartReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeStartReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeStartReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeStartReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeStartReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeStartReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeStartReq parseFrom(InputStream input) throws IOException {
            return (FurnitureMakeStartReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FurnitureMakeStartReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeStartReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FurnitureMakeStartReq parseDelimitedFrom(InputStream input) throws IOException {
            return (FurnitureMakeStartReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FurnitureMakeStartReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeStartReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FurnitureMakeStartReq parseFrom(CodedInputStream input) throws IOException {
            return (FurnitureMakeStartReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FurnitureMakeStartReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeStartReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FurnitureMakeStartReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeStartReqOuterClass$FurnitureMakeStartReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FurnitureMakeStartReqOrBuilder {
            private int makeId_;
            private int avatarId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FurnitureMakeStartReqOuterClass.internal_static_FurnitureMakeStartReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FurnitureMakeStartReqOuterClass.internal_static_FurnitureMakeStartReq_fieldAccessorTable.ensureFieldAccessorsInitialized(FurnitureMakeStartReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FurnitureMakeStartReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.makeId_ = 0;
                this.avatarId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FurnitureMakeStartReqOuterClass.internal_static_FurnitureMakeStartReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FurnitureMakeStartReq getDefaultInstanceForType() {
                return FurnitureMakeStartReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FurnitureMakeStartReq build() {
                FurnitureMakeStartReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FurnitureMakeStartReq buildPartial() {
                FurnitureMakeStartReq result = new FurnitureMakeStartReq(this);
                result.makeId_ = this.makeId_;
                result.avatarId_ = this.avatarId_;
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
                if (other instanceof FurnitureMakeStartReq) {
                    return mergeFrom((FurnitureMakeStartReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FurnitureMakeStartReq other) {
                if (other == FurnitureMakeStartReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getMakeId() != 0) {
                    setMakeId(other.getMakeId());
                }
                if (other.getAvatarId() != 0) {
                    setAvatarId(other.getAvatarId());
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
                FurnitureMakeStartReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = FurnitureMakeStartReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FurnitureMakeStartReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeStartReqOuterClass.FurnitureMakeStartReqOrBuilder
            public int getMakeId() {
                return this.makeId_;
            }

            public Builder setMakeId(int value) {
                this.makeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMakeId() {
                this.makeId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeStartReqOuterClass.FurnitureMakeStartReqOrBuilder
            public int getAvatarId() {
                return this.avatarId_;
            }

            public Builder setAvatarId(int value) {
                this.avatarId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarId() {
                this.avatarId_ = 0;
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

        public static FurnitureMakeStartReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FurnitureMakeStartReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FurnitureMakeStartReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FurnitureMakeStartReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
