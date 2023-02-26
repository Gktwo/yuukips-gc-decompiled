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
import emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeUpdateArrangementInfoReqOuterClass.class */
public final class HomeUpdateArrangementInfoReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"HomeUpdateArrangementInfoReq.proto\u001a\u001eHomeSceneArrangementInfo.proto\"W\n\u001cHomeUpdateArrangementInfoReq\u00127\n\u0014sceneArrangementInfo\u0018\u0002 \u0001(\u000b2\u0019.HomeSceneArrangementInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeSceneArrangementInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeUpdateArrangementInfoReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeUpdateArrangementInfoReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeUpdateArrangementInfoReq_descriptor, new String[]{"SceneArrangementInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeUpdateArrangementInfoReqOuterClass$HomeUpdateArrangementInfoReqOrBuilder.class */
    public interface HomeUpdateArrangementInfoReqOrBuilder extends MessageOrBuilder {
        boolean hasSceneArrangementInfo();

        HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo getSceneArrangementInfo();

        HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder getSceneArrangementInfoOrBuilder();
    }

    private HomeUpdateArrangementInfoReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeUpdateArrangementInfoReqOuterClass$HomeUpdateArrangementInfoReq.class */
    public static final class HomeUpdateArrangementInfoReq extends GeneratedMessageV3 implements HomeUpdateArrangementInfoReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SCENEARRANGEMENTINFO_FIELD_NUMBER = 2;
        private HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo sceneArrangementInfo_;
        private byte memoizedIsInitialized;
        private static final HomeUpdateArrangementInfoReq DEFAULT_INSTANCE = new HomeUpdateArrangementInfoReq();
        private static final Parser<HomeUpdateArrangementInfoReq> PARSER = new AbstractParser<HomeUpdateArrangementInfoReq>() { // from class: emu.grasscutter.net.proto.HomeUpdateArrangementInfoReqOuterClass.HomeUpdateArrangementInfoReq.1
            @Override // com.google.protobuf.Parser
            public HomeUpdateArrangementInfoReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeUpdateArrangementInfoReq(input, extensionRegistry);
            }
        };

        private HomeUpdateArrangementInfoReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeUpdateArrangementInfoReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeUpdateArrangementInfoReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeUpdateArrangementInfoReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 18:
                                HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.Builder subBuilder = this.sceneArrangementInfo_ != null ? this.sceneArrangementInfo_.toBuilder() : null;
                                this.sceneArrangementInfo_ = (HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo) input.readMessage(HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.sceneArrangementInfo_);
                                    this.sceneArrangementInfo_ = subBuilder.buildPartial();
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
            return HomeUpdateArrangementInfoReqOuterClass.internal_static_HomeUpdateArrangementInfoReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeUpdateArrangementInfoReqOuterClass.internal_static_HomeUpdateArrangementInfoReq_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeUpdateArrangementInfoReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeUpdateArrangementInfoReqOuterClass.HomeUpdateArrangementInfoReqOrBuilder
        public boolean hasSceneArrangementInfo() {
            return this.sceneArrangementInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeUpdateArrangementInfoReqOuterClass.HomeUpdateArrangementInfoReqOrBuilder
        public HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo getSceneArrangementInfo() {
            return this.sceneArrangementInfo_ == null ? HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.getDefaultInstance() : this.sceneArrangementInfo_;
        }

        @Override // emu.grasscutter.net.proto.HomeUpdateArrangementInfoReqOuterClass.HomeUpdateArrangementInfoReqOrBuilder
        public HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder getSceneArrangementInfoOrBuilder() {
            return getSceneArrangementInfo();
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
            if (this.sceneArrangementInfo_ != null) {
                output.writeMessage(2, getSceneArrangementInfo());
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
            if (this.sceneArrangementInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(2, getSceneArrangementInfo());
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
            if (!(obj instanceof HomeUpdateArrangementInfoReq)) {
                return equals(obj);
            }
            HomeUpdateArrangementInfoReq other = (HomeUpdateArrangementInfoReq) obj;
            if (hasSceneArrangementInfo() != other.hasSceneArrangementInfo()) {
                return false;
            }
            return (!hasSceneArrangementInfo() || getSceneArrangementInfo().equals(other.getSceneArrangementInfo())) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasSceneArrangementInfo()) {
                hash = (53 * ((37 * hash) + 2)) + getSceneArrangementInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeUpdateArrangementInfoReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeUpdateArrangementInfoReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeUpdateArrangementInfoReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeUpdateArrangementInfoReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeUpdateArrangementInfoReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeUpdateArrangementInfoReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeUpdateArrangementInfoReq parseFrom(InputStream input) throws IOException {
            return (HomeUpdateArrangementInfoReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeUpdateArrangementInfoReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeUpdateArrangementInfoReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeUpdateArrangementInfoReq parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeUpdateArrangementInfoReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeUpdateArrangementInfoReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeUpdateArrangementInfoReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeUpdateArrangementInfoReq parseFrom(CodedInputStream input) throws IOException {
            return (HomeUpdateArrangementInfoReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeUpdateArrangementInfoReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeUpdateArrangementInfoReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeUpdateArrangementInfoReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeUpdateArrangementInfoReqOuterClass$HomeUpdateArrangementInfoReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeUpdateArrangementInfoReqOrBuilder {
            private HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo sceneArrangementInfo_;
            private SingleFieldBuilderV3<HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo, HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.Builder, HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder> sceneArrangementInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeUpdateArrangementInfoReqOuterClass.internal_static_HomeUpdateArrangementInfoReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeUpdateArrangementInfoReqOuterClass.internal_static_HomeUpdateArrangementInfoReq_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeUpdateArrangementInfoReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeUpdateArrangementInfoReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.sceneArrangementInfoBuilder_ == null) {
                    this.sceneArrangementInfo_ = null;
                } else {
                    this.sceneArrangementInfo_ = null;
                    this.sceneArrangementInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeUpdateArrangementInfoReqOuterClass.internal_static_HomeUpdateArrangementInfoReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeUpdateArrangementInfoReq getDefaultInstanceForType() {
                return HomeUpdateArrangementInfoReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeUpdateArrangementInfoReq build() {
                HomeUpdateArrangementInfoReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeUpdateArrangementInfoReq buildPartial() {
                HomeUpdateArrangementInfoReq result = new HomeUpdateArrangementInfoReq(this);
                if (this.sceneArrangementInfoBuilder_ == null) {
                    result.sceneArrangementInfo_ = this.sceneArrangementInfo_;
                } else {
                    result.sceneArrangementInfo_ = this.sceneArrangementInfoBuilder_.build();
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
                if (other instanceof HomeUpdateArrangementInfoReq) {
                    return mergeFrom((HomeUpdateArrangementInfoReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeUpdateArrangementInfoReq other) {
                if (other == HomeUpdateArrangementInfoReq.getDefaultInstance()) {
                    return this;
                }
                if (other.hasSceneArrangementInfo()) {
                    mergeSceneArrangementInfo(other.getSceneArrangementInfo());
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
                HomeUpdateArrangementInfoReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeUpdateArrangementInfoReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeUpdateArrangementInfoReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeUpdateArrangementInfoReqOuterClass.HomeUpdateArrangementInfoReqOrBuilder
            public boolean hasSceneArrangementInfo() {
                return (this.sceneArrangementInfoBuilder_ == null && this.sceneArrangementInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeUpdateArrangementInfoReqOuterClass.HomeUpdateArrangementInfoReqOrBuilder
            public HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo getSceneArrangementInfo() {
                if (this.sceneArrangementInfoBuilder_ == null) {
                    return this.sceneArrangementInfo_ == null ? HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.getDefaultInstance() : this.sceneArrangementInfo_;
                }
                return this.sceneArrangementInfoBuilder_.getMessage();
            }

            public Builder setSceneArrangementInfo(HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo value) {
                if (this.sceneArrangementInfoBuilder_ != null) {
                    this.sceneArrangementInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.sceneArrangementInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setSceneArrangementInfo(HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.Builder builderForValue) {
                if (this.sceneArrangementInfoBuilder_ == null) {
                    this.sceneArrangementInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.sceneArrangementInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeSceneArrangementInfo(HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo value) {
                if (this.sceneArrangementInfoBuilder_ == null) {
                    if (this.sceneArrangementInfo_ != null) {
                        this.sceneArrangementInfo_ = HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.newBuilder(this.sceneArrangementInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.sceneArrangementInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.sceneArrangementInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearSceneArrangementInfo() {
                if (this.sceneArrangementInfoBuilder_ == null) {
                    this.sceneArrangementInfo_ = null;
                    onChanged();
                } else {
                    this.sceneArrangementInfo_ = null;
                    this.sceneArrangementInfoBuilder_ = null;
                }
                return this;
            }

            public HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.Builder getSceneArrangementInfoBuilder() {
                onChanged();
                return getSceneArrangementInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeUpdateArrangementInfoReqOuterClass.HomeUpdateArrangementInfoReqOrBuilder
            public HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder getSceneArrangementInfoOrBuilder() {
                if (this.sceneArrangementInfoBuilder_ != null) {
                    return this.sceneArrangementInfoBuilder_.getMessageOrBuilder();
                }
                return this.sceneArrangementInfo_ == null ? HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.getDefaultInstance() : this.sceneArrangementInfo_;
            }

            private SingleFieldBuilderV3<HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo, HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.Builder, HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder> getSceneArrangementInfoFieldBuilder() {
                if (this.sceneArrangementInfoBuilder_ == null) {
                    this.sceneArrangementInfoBuilder_ = new SingleFieldBuilderV3<>(getSceneArrangementInfo(), getParentForChildren(), isClean());
                    this.sceneArrangementInfo_ = null;
                }
                return this.sceneArrangementInfoBuilder_;
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

        public static HomeUpdateArrangementInfoReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeUpdateArrangementInfoReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeUpdateArrangementInfoReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeUpdateArrangementInfoReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HomeSceneArrangementInfoOuterClass.getDescriptor();
    }
}
