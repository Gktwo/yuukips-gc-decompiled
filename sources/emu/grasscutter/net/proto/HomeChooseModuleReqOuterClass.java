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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeChooseModuleReqOuterClass.class */
public final class HomeChooseModuleReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019HomeChooseModuleReq.proto\"'\n\u0013HomeChooseModuleReq\u0012\u0010\n\bmoduleId\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_HomeChooseModuleReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeChooseModuleReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeChooseModuleReq_descriptor, new String[]{"ModuleId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeChooseModuleReqOuterClass$HomeChooseModuleReqOrBuilder.class */
    public interface HomeChooseModuleReqOrBuilder extends MessageOrBuilder {
        int getModuleId();
    }

    private HomeChooseModuleReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeChooseModuleReqOuterClass$HomeChooseModuleReq.class */
    public static final class HomeChooseModuleReq extends GeneratedMessageV3 implements HomeChooseModuleReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MODULEID_FIELD_NUMBER = 11;
        private int moduleId_;
        private byte memoizedIsInitialized;
        private static final HomeChooseModuleReq DEFAULT_INSTANCE = new HomeChooseModuleReq();
        private static final Parser<HomeChooseModuleReq> PARSER = new AbstractParser<HomeChooseModuleReq>() { // from class: emu.grasscutter.net.proto.HomeChooseModuleReqOuterClass.HomeChooseModuleReq.1
            @Override // com.google.protobuf.Parser
            public HomeChooseModuleReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeChooseModuleReq(input, extensionRegistry);
            }
        };

        private HomeChooseModuleReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeChooseModuleReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeChooseModuleReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeChooseModuleReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 88:
                                this.moduleId_ = input.readUInt32();
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
            return HomeChooseModuleReqOuterClass.internal_static_HomeChooseModuleReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeChooseModuleReqOuterClass.internal_static_HomeChooseModuleReq_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeChooseModuleReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeChooseModuleReqOuterClass.HomeChooseModuleReqOrBuilder
        public int getModuleId() {
            return this.moduleId_;
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
            if (this.moduleId_ != 0) {
                output.writeUInt32(11, this.moduleId_);
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
            if (this.moduleId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(11, this.moduleId_);
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
            if (!(obj instanceof HomeChooseModuleReq)) {
                return equals(obj);
            }
            HomeChooseModuleReq other = (HomeChooseModuleReq) obj;
            return getModuleId() == other.getModuleId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getModuleId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static HomeChooseModuleReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeChooseModuleReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeChooseModuleReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeChooseModuleReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeChooseModuleReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeChooseModuleReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeChooseModuleReq parseFrom(InputStream input) throws IOException {
            return (HomeChooseModuleReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeChooseModuleReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeChooseModuleReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeChooseModuleReq parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeChooseModuleReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeChooseModuleReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeChooseModuleReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeChooseModuleReq parseFrom(CodedInputStream input) throws IOException {
            return (HomeChooseModuleReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeChooseModuleReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeChooseModuleReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeChooseModuleReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeChooseModuleReqOuterClass$HomeChooseModuleReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeChooseModuleReqOrBuilder {
            private int moduleId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeChooseModuleReqOuterClass.internal_static_HomeChooseModuleReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeChooseModuleReqOuterClass.internal_static_HomeChooseModuleReq_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeChooseModuleReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeChooseModuleReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.moduleId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeChooseModuleReqOuterClass.internal_static_HomeChooseModuleReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeChooseModuleReq getDefaultInstanceForType() {
                return HomeChooseModuleReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeChooseModuleReq build() {
                HomeChooseModuleReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeChooseModuleReq buildPartial() {
                HomeChooseModuleReq result = new HomeChooseModuleReq(this);
                result.moduleId_ = this.moduleId_;
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
                if (other instanceof HomeChooseModuleReq) {
                    return mergeFrom((HomeChooseModuleReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeChooseModuleReq other) {
                if (other == HomeChooseModuleReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getModuleId() != 0) {
                    setModuleId(other.getModuleId());
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
                HomeChooseModuleReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeChooseModuleReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeChooseModuleReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeChooseModuleReqOuterClass.HomeChooseModuleReqOrBuilder
            public int getModuleId() {
                return this.moduleId_;
            }

            public Builder setModuleId(int value) {
                this.moduleId_ = value;
                onChanged();
                return this;
            }

            public Builder clearModuleId() {
                this.moduleId_ = 0;
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

        public static HomeChooseModuleReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeChooseModuleReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeChooseModuleReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeChooseModuleReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
