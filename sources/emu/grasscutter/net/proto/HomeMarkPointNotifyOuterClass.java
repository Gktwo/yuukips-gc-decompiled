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
import emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeMarkPointNotifyOuterClass.class */
public final class HomeMarkPointNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019HomeMarkPointNotify.proto\u001a\u001cHomeMarkPointSceneData.proto\"I\n\u0013HomeMarkPointNotify\u00122\n\u0011markPointDataList\u0018\u000b \u0003(\u000b2\u0017.HomeMarkPointSceneDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeMarkPointSceneDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeMarkPointNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeMarkPointNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeMarkPointNotify_descriptor, new String[]{"MarkPointDataList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeMarkPointNotifyOuterClass$HomeMarkPointNotifyOrBuilder.class */
    public interface HomeMarkPointNotifyOrBuilder extends MessageOrBuilder {
        List<HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData> getMarkPointDataListList();

        HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData getMarkPointDataList(int i);

        int getMarkPointDataListCount();

        List<? extends HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder> getMarkPointDataListOrBuilderList();

        HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder getMarkPointDataListOrBuilder(int i);
    }

    private HomeMarkPointNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeMarkPointNotifyOuterClass$HomeMarkPointNotify.class */
    public static final class HomeMarkPointNotify extends GeneratedMessageV3 implements HomeMarkPointNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MARKPOINTDATALIST_FIELD_NUMBER = 11;
        private List<HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData> markPointDataList_;
        private byte memoizedIsInitialized;
        private static final HomeMarkPointNotify DEFAULT_INSTANCE = new HomeMarkPointNotify();
        private static final Parser<HomeMarkPointNotify> PARSER = new AbstractParser<HomeMarkPointNotify>() { // from class: emu.grasscutter.net.proto.HomeMarkPointNotifyOuterClass.HomeMarkPointNotify.1
            @Override // com.google.protobuf.Parser
            public HomeMarkPointNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeMarkPointNotify(input, extensionRegistry);
            }
        };

        private HomeMarkPointNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeMarkPointNotify() {
            this.memoizedIsInitialized = -1;
            this.markPointDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeMarkPointNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeMarkPointNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 90:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.markPointDataList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.markPointDataList_.add((HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData) input.readMessage(HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.markPointDataList_ = Collections.unmodifiableList(this.markPointDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeMarkPointNotifyOuterClass.internal_static_HomeMarkPointNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeMarkPointNotifyOuterClass.internal_static_HomeMarkPointNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeMarkPointNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointNotifyOuterClass.HomeMarkPointNotifyOrBuilder
        public List<HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData> getMarkPointDataListList() {
            return this.markPointDataList_;
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointNotifyOuterClass.HomeMarkPointNotifyOrBuilder
        public List<? extends HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder> getMarkPointDataListOrBuilderList() {
            return this.markPointDataList_;
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointNotifyOuterClass.HomeMarkPointNotifyOrBuilder
        public int getMarkPointDataListCount() {
            return this.markPointDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointNotifyOuterClass.HomeMarkPointNotifyOrBuilder
        public HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData getMarkPointDataList(int index) {
            return this.markPointDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeMarkPointNotifyOuterClass.HomeMarkPointNotifyOrBuilder
        public HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder getMarkPointDataListOrBuilder(int index) {
            return this.markPointDataList_.get(index);
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
            for (int i = 0; i < this.markPointDataList_.size(); i++) {
                output.writeMessage(11, this.markPointDataList_.get(i));
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
            for (int i = 0; i < this.markPointDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.markPointDataList_.get(i));
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
            if (!(obj instanceof HomeMarkPointNotify)) {
                return equals(obj);
            }
            HomeMarkPointNotify other = (HomeMarkPointNotify) obj;
            return getMarkPointDataListList().equals(other.getMarkPointDataListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getMarkPointDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getMarkPointDataListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeMarkPointNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeMarkPointNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeMarkPointNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeMarkPointNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeMarkPointNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeMarkPointNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeMarkPointNotify parseFrom(InputStream input) throws IOException {
            return (HomeMarkPointNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeMarkPointNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeMarkPointNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeMarkPointNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeMarkPointNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeMarkPointNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeMarkPointNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeMarkPointNotify parseFrom(CodedInputStream input) throws IOException {
            return (HomeMarkPointNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeMarkPointNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeMarkPointNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeMarkPointNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeMarkPointNotifyOuterClass$HomeMarkPointNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeMarkPointNotifyOrBuilder {
            private int bitField0_;
            private List<HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData> markPointDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData, HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData.Builder, HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder> markPointDataListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeMarkPointNotifyOuterClass.internal_static_HomeMarkPointNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeMarkPointNotifyOuterClass.internal_static_HomeMarkPointNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeMarkPointNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeMarkPointNotify.alwaysUseFieldBuilders) {
                    getMarkPointDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.markPointDataListBuilder_ == null) {
                    this.markPointDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.markPointDataListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeMarkPointNotifyOuterClass.internal_static_HomeMarkPointNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeMarkPointNotify getDefaultInstanceForType() {
                return HomeMarkPointNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeMarkPointNotify build() {
                HomeMarkPointNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeMarkPointNotify buildPartial() {
                HomeMarkPointNotify result = new HomeMarkPointNotify(this);
                int i = this.bitField0_;
                if (this.markPointDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.markPointDataList_ = Collections.unmodifiableList(this.markPointDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.markPointDataList_ = this.markPointDataList_;
                } else {
                    result.markPointDataList_ = this.markPointDataListBuilder_.build();
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
                if (other instanceof HomeMarkPointNotify) {
                    return mergeFrom((HomeMarkPointNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeMarkPointNotify other) {
                if (other == HomeMarkPointNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.markPointDataListBuilder_ == null) {
                    if (!other.markPointDataList_.isEmpty()) {
                        if (this.markPointDataList_.isEmpty()) {
                            this.markPointDataList_ = other.markPointDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureMarkPointDataListIsMutable();
                            this.markPointDataList_.addAll(other.markPointDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.markPointDataList_.isEmpty()) {
                    if (this.markPointDataListBuilder_.isEmpty()) {
                        this.markPointDataListBuilder_.dispose();
                        this.markPointDataListBuilder_ = null;
                        this.markPointDataList_ = other.markPointDataList_;
                        this.bitField0_ &= -2;
                        this.markPointDataListBuilder_ = HomeMarkPointNotify.alwaysUseFieldBuilders ? getMarkPointDataListFieldBuilder() : null;
                    } else {
                        this.markPointDataListBuilder_.addAllMessages(other.markPointDataList_);
                    }
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
                HomeMarkPointNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeMarkPointNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeMarkPointNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureMarkPointDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.markPointDataList_ = new ArrayList(this.markPointDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointNotifyOuterClass.HomeMarkPointNotifyOrBuilder
            public List<HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData> getMarkPointDataListList() {
                if (this.markPointDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.markPointDataList_);
                }
                return this.markPointDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointNotifyOuterClass.HomeMarkPointNotifyOrBuilder
            public int getMarkPointDataListCount() {
                if (this.markPointDataListBuilder_ == null) {
                    return this.markPointDataList_.size();
                }
                return this.markPointDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointNotifyOuterClass.HomeMarkPointNotifyOrBuilder
            public HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData getMarkPointDataList(int index) {
                if (this.markPointDataListBuilder_ == null) {
                    return this.markPointDataList_.get(index);
                }
                return this.markPointDataListBuilder_.getMessage(index);
            }

            public Builder setMarkPointDataList(int index, HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData value) {
                if (this.markPointDataListBuilder_ != null) {
                    this.markPointDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMarkPointDataListIsMutable();
                    this.markPointDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMarkPointDataList(int index, HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData.Builder builderForValue) {
                if (this.markPointDataListBuilder_ == null) {
                    ensureMarkPointDataListIsMutable();
                    this.markPointDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.markPointDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMarkPointDataList(HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData value) {
                if (this.markPointDataListBuilder_ != null) {
                    this.markPointDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMarkPointDataListIsMutable();
                    this.markPointDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMarkPointDataList(int index, HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData value) {
                if (this.markPointDataListBuilder_ != null) {
                    this.markPointDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMarkPointDataListIsMutable();
                    this.markPointDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMarkPointDataList(HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData.Builder builderForValue) {
                if (this.markPointDataListBuilder_ == null) {
                    ensureMarkPointDataListIsMutable();
                    this.markPointDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.markPointDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMarkPointDataList(int index, HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData.Builder builderForValue) {
                if (this.markPointDataListBuilder_ == null) {
                    ensureMarkPointDataListIsMutable();
                    this.markPointDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.markPointDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMarkPointDataList(Iterable<? extends HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData> values) {
                if (this.markPointDataListBuilder_ == null) {
                    ensureMarkPointDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.markPointDataList_);
                    onChanged();
                } else {
                    this.markPointDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMarkPointDataList() {
                if (this.markPointDataListBuilder_ == null) {
                    this.markPointDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.markPointDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeMarkPointDataList(int index) {
                if (this.markPointDataListBuilder_ == null) {
                    ensureMarkPointDataListIsMutable();
                    this.markPointDataList_.remove(index);
                    onChanged();
                } else {
                    this.markPointDataListBuilder_.remove(index);
                }
                return this;
            }

            public HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData.Builder getMarkPointDataListBuilder(int index) {
                return getMarkPointDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointNotifyOuterClass.HomeMarkPointNotifyOrBuilder
            public HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder getMarkPointDataListOrBuilder(int index) {
                if (this.markPointDataListBuilder_ == null) {
                    return this.markPointDataList_.get(index);
                }
                return this.markPointDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeMarkPointNotifyOuterClass.HomeMarkPointNotifyOrBuilder
            public List<? extends HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder> getMarkPointDataListOrBuilderList() {
                if (this.markPointDataListBuilder_ != null) {
                    return this.markPointDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.markPointDataList_);
            }

            public HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData.Builder addMarkPointDataListBuilder() {
                return getMarkPointDataListFieldBuilder().addBuilder(HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData.getDefaultInstance());
            }

            public HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData.Builder addMarkPointDataListBuilder(int index) {
                return getMarkPointDataListFieldBuilder().addBuilder(index, HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData.getDefaultInstance());
            }

            public List<HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData.Builder> getMarkPointDataListBuilderList() {
                return getMarkPointDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData, HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData.Builder, HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneDataOrBuilder> getMarkPointDataListFieldBuilder() {
                if (this.markPointDataListBuilder_ == null) {
                    this.markPointDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.markPointDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.markPointDataList_ = null;
                }
                return this.markPointDataListBuilder_;
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

        public static HomeMarkPointNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeMarkPointNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeMarkPointNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeMarkPointNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HomeMarkPointSceneDataOuterClass.getDescriptor();
    }
}
