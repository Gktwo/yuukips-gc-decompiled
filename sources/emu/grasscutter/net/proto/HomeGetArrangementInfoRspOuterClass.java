package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeGetArrangementInfoRspOuterClass.class */
public final class HomeGetArrangementInfoRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fHomeGetArrangementInfoRsp.proto\u001a\u001eHomeSceneArrangementInfo.proto\"l\n\u0019HomeGetArrangementInfoRsp\u0012>\n\u001bscene_arrangement_info_list\u0018\r \u0003(\u000b2\u0019.HomeSceneArrangementInfo\u0012\u000f\n\u0007retcode\u0018\u000b \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeSceneArrangementInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeGetArrangementInfoRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeGetArrangementInfoRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeGetArrangementInfoRsp_descriptor, new String[]{"SceneArrangementInfoList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeGetArrangementInfoRspOuterClass$HomeGetArrangementInfoRspOrBuilder.class */
    public interface HomeGetArrangementInfoRspOrBuilder extends MessageOrBuilder {
        List<HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo> getSceneArrangementInfoListList();

        HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo getSceneArrangementInfoList(int i);

        int getSceneArrangementInfoListCount();

        List<? extends HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder> getSceneArrangementInfoListOrBuilderList();

        HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder getSceneArrangementInfoListOrBuilder(int i);

        int getRetcode();
    }

    private HomeGetArrangementInfoRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeGetArrangementInfoRspOuterClass$HomeGetArrangementInfoRsp.class */
    public static final class HomeGetArrangementInfoRsp extends GeneratedMessageV3 implements HomeGetArrangementInfoRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SCENE_ARRANGEMENT_INFO_LIST_FIELD_NUMBER = 13;
        private List<HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo> sceneArrangementInfoList_;
        public static final int RETCODE_FIELD_NUMBER = 11;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final HomeGetArrangementInfoRsp DEFAULT_INSTANCE = new HomeGetArrangementInfoRsp();
        private static final Parser<HomeGetArrangementInfoRsp> PARSER = new AbstractParser<HomeGetArrangementInfoRsp>() { // from class: emu.grasscutter.net.proto.HomeGetArrangementInfoRspOuterClass.HomeGetArrangementInfoRsp.1
            @Override // com.google.protobuf.Parser
            public HomeGetArrangementInfoRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeGetArrangementInfoRsp(input, extensionRegistry);
            }
        };

        private HomeGetArrangementInfoRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeGetArrangementInfoRsp() {
            this.memoizedIsInitialized = -1;
            this.sceneArrangementInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeGetArrangementInfoRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeGetArrangementInfoRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_;
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                mutable_bitField0_ = 0;
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
                                case 88:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 106:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.sceneArrangementInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.sceneArrangementInfoList_.add((HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo) input.readMessage(HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.sceneArrangementInfoList_ = Collections.unmodifiableList(this.sceneArrangementInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeGetArrangementInfoRspOuterClass.internal_static_HomeGetArrangementInfoRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeGetArrangementInfoRspOuterClass.internal_static_HomeGetArrangementInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeGetArrangementInfoRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeGetArrangementInfoRspOuterClass.HomeGetArrangementInfoRspOrBuilder
        public List<HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo> getSceneArrangementInfoListList() {
            return this.sceneArrangementInfoList_;
        }

        @Override // emu.grasscutter.net.proto.HomeGetArrangementInfoRspOuterClass.HomeGetArrangementInfoRspOrBuilder
        public List<? extends HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder> getSceneArrangementInfoListOrBuilderList() {
            return this.sceneArrangementInfoList_;
        }

        @Override // emu.grasscutter.net.proto.HomeGetArrangementInfoRspOuterClass.HomeGetArrangementInfoRspOrBuilder
        public int getSceneArrangementInfoListCount() {
            return this.sceneArrangementInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeGetArrangementInfoRspOuterClass.HomeGetArrangementInfoRspOrBuilder
        public HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo getSceneArrangementInfoList(int index) {
            return this.sceneArrangementInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeGetArrangementInfoRspOuterClass.HomeGetArrangementInfoRspOrBuilder
        public HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder getSceneArrangementInfoListOrBuilder(int index) {
            return this.sceneArrangementInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeGetArrangementInfoRspOuterClass.HomeGetArrangementInfoRspOrBuilder
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
            if (this.retcode_ != 0) {
                output.writeInt32(11, this.retcode_);
            }
            for (int i = 0; i < this.sceneArrangementInfoList_.size(); i++) {
                output.writeMessage(13, this.sceneArrangementInfoList_.get(i));
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
            if (this.retcode_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(11, this.retcode_);
            }
            for (int i = 0; i < this.sceneArrangementInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(13, this.sceneArrangementInfoList_.get(i));
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
            if (!(obj instanceof HomeGetArrangementInfoRsp)) {
                return equals(obj);
            }
            HomeGetArrangementInfoRsp other = (HomeGetArrangementInfoRsp) obj;
            return getSceneArrangementInfoListList().equals(other.getSceneArrangementInfoListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getSceneArrangementInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getSceneArrangementInfoListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 11)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeGetArrangementInfoRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeGetArrangementInfoRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeGetArrangementInfoRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeGetArrangementInfoRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeGetArrangementInfoRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeGetArrangementInfoRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeGetArrangementInfoRsp parseFrom(InputStream input) throws IOException {
            return (HomeGetArrangementInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeGetArrangementInfoRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeGetArrangementInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeGetArrangementInfoRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeGetArrangementInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeGetArrangementInfoRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeGetArrangementInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeGetArrangementInfoRsp parseFrom(CodedInputStream input) throws IOException {
            return (HomeGetArrangementInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeGetArrangementInfoRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeGetArrangementInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeGetArrangementInfoRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeGetArrangementInfoRspOuterClass$HomeGetArrangementInfoRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeGetArrangementInfoRspOrBuilder {
            private int bitField0_;
            private List<HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo> sceneArrangementInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo, HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.Builder, HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder> sceneArrangementInfoListBuilder_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeGetArrangementInfoRspOuterClass.internal_static_HomeGetArrangementInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeGetArrangementInfoRspOuterClass.internal_static_HomeGetArrangementInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeGetArrangementInfoRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeGetArrangementInfoRsp.alwaysUseFieldBuilders) {
                    getSceneArrangementInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.sceneArrangementInfoListBuilder_ == null) {
                    this.sceneArrangementInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.sceneArrangementInfoListBuilder_.clear();
                }
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeGetArrangementInfoRspOuterClass.internal_static_HomeGetArrangementInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeGetArrangementInfoRsp getDefaultInstanceForType() {
                return HomeGetArrangementInfoRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeGetArrangementInfoRsp build() {
                HomeGetArrangementInfoRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeGetArrangementInfoRsp buildPartial() {
                HomeGetArrangementInfoRsp result = new HomeGetArrangementInfoRsp(this);
                int i = this.bitField0_;
                if (this.sceneArrangementInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.sceneArrangementInfoList_ = Collections.unmodifiableList(this.sceneArrangementInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.sceneArrangementInfoList_ = this.sceneArrangementInfoList_;
                } else {
                    result.sceneArrangementInfoList_ = this.sceneArrangementInfoListBuilder_.build();
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
                if (other instanceof HomeGetArrangementInfoRsp) {
                    return mergeFrom((HomeGetArrangementInfoRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeGetArrangementInfoRsp other) {
                if (other == HomeGetArrangementInfoRsp.getDefaultInstance()) {
                    return this;
                }
                if (this.sceneArrangementInfoListBuilder_ == null) {
                    if (!other.sceneArrangementInfoList_.isEmpty()) {
                        if (this.sceneArrangementInfoList_.isEmpty()) {
                            this.sceneArrangementInfoList_ = other.sceneArrangementInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureSceneArrangementInfoListIsMutable();
                            this.sceneArrangementInfoList_.addAll(other.sceneArrangementInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.sceneArrangementInfoList_.isEmpty()) {
                    if (this.sceneArrangementInfoListBuilder_.isEmpty()) {
                        this.sceneArrangementInfoListBuilder_.dispose();
                        this.sceneArrangementInfoListBuilder_ = null;
                        this.sceneArrangementInfoList_ = other.sceneArrangementInfoList_;
                        this.bitField0_ &= -2;
                        this.sceneArrangementInfoListBuilder_ = HomeGetArrangementInfoRsp.alwaysUseFieldBuilders ? getSceneArrangementInfoListFieldBuilder() : null;
                    } else {
                        this.sceneArrangementInfoListBuilder_.addAllMessages(other.sceneArrangementInfoList_);
                    }
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
                HomeGetArrangementInfoRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeGetArrangementInfoRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeGetArrangementInfoRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureSceneArrangementInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.sceneArrangementInfoList_ = new ArrayList(this.sceneArrangementInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeGetArrangementInfoRspOuterClass.HomeGetArrangementInfoRspOrBuilder
            public List<HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo> getSceneArrangementInfoListList() {
                if (this.sceneArrangementInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.sceneArrangementInfoList_);
                }
                return this.sceneArrangementInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeGetArrangementInfoRspOuterClass.HomeGetArrangementInfoRspOrBuilder
            public int getSceneArrangementInfoListCount() {
                if (this.sceneArrangementInfoListBuilder_ == null) {
                    return this.sceneArrangementInfoList_.size();
                }
                return this.sceneArrangementInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeGetArrangementInfoRspOuterClass.HomeGetArrangementInfoRspOrBuilder
            public HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo getSceneArrangementInfoList(int index) {
                if (this.sceneArrangementInfoListBuilder_ == null) {
                    return this.sceneArrangementInfoList_.get(index);
                }
                return this.sceneArrangementInfoListBuilder_.getMessage(index);
            }

            public Builder setSceneArrangementInfoList(int index, HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo value) {
                if (this.sceneArrangementInfoListBuilder_ != null) {
                    this.sceneArrangementInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSceneArrangementInfoListIsMutable();
                    this.sceneArrangementInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setSceneArrangementInfoList(int index, HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.Builder builderForValue) {
                if (this.sceneArrangementInfoListBuilder_ == null) {
                    ensureSceneArrangementInfoListIsMutable();
                    this.sceneArrangementInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.sceneArrangementInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addSceneArrangementInfoList(HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo value) {
                if (this.sceneArrangementInfoListBuilder_ != null) {
                    this.sceneArrangementInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSceneArrangementInfoListIsMutable();
                    this.sceneArrangementInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addSceneArrangementInfoList(int index, HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo value) {
                if (this.sceneArrangementInfoListBuilder_ != null) {
                    this.sceneArrangementInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSceneArrangementInfoListIsMutable();
                    this.sceneArrangementInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addSceneArrangementInfoList(HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.Builder builderForValue) {
                if (this.sceneArrangementInfoListBuilder_ == null) {
                    ensureSceneArrangementInfoListIsMutable();
                    this.sceneArrangementInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.sceneArrangementInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addSceneArrangementInfoList(int index, HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.Builder builderForValue) {
                if (this.sceneArrangementInfoListBuilder_ == null) {
                    ensureSceneArrangementInfoListIsMutable();
                    this.sceneArrangementInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.sceneArrangementInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllSceneArrangementInfoList(Iterable<? extends HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo> values) {
                if (this.sceneArrangementInfoListBuilder_ == null) {
                    ensureSceneArrangementInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.sceneArrangementInfoList_);
                    onChanged();
                } else {
                    this.sceneArrangementInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearSceneArrangementInfoList() {
                if (this.sceneArrangementInfoListBuilder_ == null) {
                    this.sceneArrangementInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.sceneArrangementInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeSceneArrangementInfoList(int index) {
                if (this.sceneArrangementInfoListBuilder_ == null) {
                    ensureSceneArrangementInfoListIsMutable();
                    this.sceneArrangementInfoList_.remove(index);
                    onChanged();
                } else {
                    this.sceneArrangementInfoListBuilder_.remove(index);
                }
                return this;
            }

            public HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.Builder getSceneArrangementInfoListBuilder(int index) {
                return getSceneArrangementInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeGetArrangementInfoRspOuterClass.HomeGetArrangementInfoRspOrBuilder
            public HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder getSceneArrangementInfoListOrBuilder(int index) {
                if (this.sceneArrangementInfoListBuilder_ == null) {
                    return this.sceneArrangementInfoList_.get(index);
                }
                return this.sceneArrangementInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeGetArrangementInfoRspOuterClass.HomeGetArrangementInfoRspOrBuilder
            public List<? extends HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder> getSceneArrangementInfoListOrBuilderList() {
                if (this.sceneArrangementInfoListBuilder_ != null) {
                    return this.sceneArrangementInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.sceneArrangementInfoList_);
            }

            public HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.Builder addSceneArrangementInfoListBuilder() {
                return getSceneArrangementInfoListFieldBuilder().addBuilder(HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.getDefaultInstance());
            }

            public HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.Builder addSceneArrangementInfoListBuilder(int index) {
                return getSceneArrangementInfoListFieldBuilder().addBuilder(index, HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.getDefaultInstance());
            }

            public List<HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.Builder> getSceneArrangementInfoListBuilderList() {
                return getSceneArrangementInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo, HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.Builder, HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder> getSceneArrangementInfoListFieldBuilder() {
                if (this.sceneArrangementInfoListBuilder_ == null) {
                    this.sceneArrangementInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.sceneArrangementInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.sceneArrangementInfoList_ = null;
                }
                return this.sceneArrangementInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeGetArrangementInfoRspOuterClass.HomeGetArrangementInfoRspOrBuilder
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

        public static HomeGetArrangementInfoRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeGetArrangementInfoRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeGetArrangementInfoRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeGetArrangementInfoRsp getDefaultInstanceForType() {
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
