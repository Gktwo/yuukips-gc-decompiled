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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AddQuestContentProgressReqOuterClass.class */
public final class AddQuestContentProgressReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n AddQuestContentProgressReq.proto\"W\n\u001aAddQuestContentProgressReq\u0012\u0014\n\fcontent_type\u0018\u0001 \u0001(\r\u0012\u0014\n\fadd_progress\u0018\u0006 \u0001(\r\u0012\r\n\u0005param\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AddQuestContentProgressReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AddQuestContentProgressReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AddQuestContentProgressReq_descriptor, new String[]{"ContentType", "AddProgress", "Param"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AddQuestContentProgressReqOuterClass$AddQuestContentProgressReqOrBuilder.class */
    public interface AddQuestContentProgressReqOrBuilder extends MessageOrBuilder {
        int getContentType();

        int getAddProgress();

        int getParam();
    }

    private AddQuestContentProgressReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AddQuestContentProgressReqOuterClass$AddQuestContentProgressReq.class */
    public static final class AddQuestContentProgressReq extends GeneratedMessageV3 implements AddQuestContentProgressReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CONTENT_TYPE_FIELD_NUMBER = 1;
        private int contentType_;
        public static final int ADD_PROGRESS_FIELD_NUMBER = 6;
        private int addProgress_;
        public static final int PARAM_FIELD_NUMBER = 11;
        private int param_;
        private byte memoizedIsInitialized;
        private static final AddQuestContentProgressReq DEFAULT_INSTANCE = new AddQuestContentProgressReq();
        private static final Parser<AddQuestContentProgressReq> PARSER = new AbstractParser<AddQuestContentProgressReq>() { // from class: emu.grasscutter.net.proto.AddQuestContentProgressReqOuterClass.AddQuestContentProgressReq.1
            @Override // com.google.protobuf.Parser
            public AddQuestContentProgressReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AddQuestContentProgressReq(input, extensionRegistry);
            }
        };

        private AddQuestContentProgressReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AddQuestContentProgressReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AddQuestContentProgressReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AddQuestContentProgressReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.contentType_ = input.readUInt32();
                                    break;
                                case 48:
                                    this.addProgress_ = input.readUInt32();
                                    break;
                                case 88:
                                    this.param_ = input.readUInt32();
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
            return AddQuestContentProgressReqOuterClass.internal_static_AddQuestContentProgressReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AddQuestContentProgressReqOuterClass.internal_static_AddQuestContentProgressReq_fieldAccessorTable.ensureFieldAccessorsInitialized(AddQuestContentProgressReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AddQuestContentProgressReqOuterClass.AddQuestContentProgressReqOrBuilder
        public int getContentType() {
            return this.contentType_;
        }

        @Override // emu.grasscutter.net.proto.AddQuestContentProgressReqOuterClass.AddQuestContentProgressReqOrBuilder
        public int getAddProgress() {
            return this.addProgress_;
        }

        @Override // emu.grasscutter.net.proto.AddQuestContentProgressReqOuterClass.AddQuestContentProgressReqOrBuilder
        public int getParam() {
            return this.param_;
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
            if (this.contentType_ != 0) {
                output.writeUInt32(1, this.contentType_);
            }
            if (this.addProgress_ != 0) {
                output.writeUInt32(6, this.addProgress_);
            }
            if (this.param_ != 0) {
                output.writeUInt32(11, this.param_);
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
            if (this.contentType_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.contentType_);
            }
            if (this.addProgress_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.addProgress_);
            }
            if (this.param_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.param_);
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
            if (!(obj instanceof AddQuestContentProgressReq)) {
                return equals(obj);
            }
            AddQuestContentProgressReq other = (AddQuestContentProgressReq) obj;
            return getContentType() == other.getContentType() && getAddProgress() == other.getAddProgress() && getParam() == other.getParam() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getContentType())) + 6)) + getAddProgress())) + 11)) + getParam())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AddQuestContentProgressReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AddQuestContentProgressReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AddQuestContentProgressReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AddQuestContentProgressReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AddQuestContentProgressReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AddQuestContentProgressReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AddQuestContentProgressReq parseFrom(InputStream input) throws IOException {
            return (AddQuestContentProgressReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AddQuestContentProgressReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AddQuestContentProgressReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AddQuestContentProgressReq parseDelimitedFrom(InputStream input) throws IOException {
            return (AddQuestContentProgressReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AddQuestContentProgressReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AddQuestContentProgressReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AddQuestContentProgressReq parseFrom(CodedInputStream input) throws IOException {
            return (AddQuestContentProgressReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AddQuestContentProgressReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AddQuestContentProgressReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AddQuestContentProgressReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AddQuestContentProgressReqOuterClass$AddQuestContentProgressReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AddQuestContentProgressReqOrBuilder {
            private int contentType_;
            private int addProgress_;
            private int param_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AddQuestContentProgressReqOuterClass.internal_static_AddQuestContentProgressReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AddQuestContentProgressReqOuterClass.internal_static_AddQuestContentProgressReq_fieldAccessorTable.ensureFieldAccessorsInitialized(AddQuestContentProgressReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AddQuestContentProgressReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.contentType_ = 0;
                this.addProgress_ = 0;
                this.param_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AddQuestContentProgressReqOuterClass.internal_static_AddQuestContentProgressReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AddQuestContentProgressReq getDefaultInstanceForType() {
                return AddQuestContentProgressReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AddQuestContentProgressReq build() {
                AddQuestContentProgressReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AddQuestContentProgressReq buildPartial() {
                AddQuestContentProgressReq result = new AddQuestContentProgressReq(this);
                result.contentType_ = this.contentType_;
                result.addProgress_ = this.addProgress_;
                result.param_ = this.param_;
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
                if (other instanceof AddQuestContentProgressReq) {
                    return mergeFrom((AddQuestContentProgressReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AddQuestContentProgressReq other) {
                if (other == AddQuestContentProgressReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getContentType() != 0) {
                    setContentType(other.getContentType());
                }
                if (other.getAddProgress() != 0) {
                    setAddProgress(other.getAddProgress());
                }
                if (other.getParam() != 0) {
                    setParam(other.getParam());
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
                AddQuestContentProgressReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = AddQuestContentProgressReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AddQuestContentProgressReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AddQuestContentProgressReqOuterClass.AddQuestContentProgressReqOrBuilder
            public int getContentType() {
                return this.contentType_;
            }

            public Builder setContentType(int value) {
                this.contentType_ = value;
                onChanged();
                return this;
            }

            public Builder clearContentType() {
                this.contentType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AddQuestContentProgressReqOuterClass.AddQuestContentProgressReqOrBuilder
            public int getAddProgress() {
                return this.addProgress_;
            }

            public Builder setAddProgress(int value) {
                this.addProgress_ = value;
                onChanged();
                return this;
            }

            public Builder clearAddProgress() {
                this.addProgress_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AddQuestContentProgressReqOuterClass.AddQuestContentProgressReqOrBuilder
            public int getParam() {
                return this.param_;
            }

            public Builder setParam(int value) {
                this.param_ = value;
                onChanged();
                return this;
            }

            public Builder clearParam() {
                this.param_ = 0;
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

        public static AddQuestContentProgressReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AddQuestContentProgressReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AddQuestContentProgressReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AddQuestContentProgressReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
