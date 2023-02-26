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
import emu.grasscutter.net.proto.HomeModuleComfortInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeComfortInfoNotifyOuterClass.class */
public final class HomeComfortInfoNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bHomeComfortInfoNotify.proto\u001a\u001bHomeModuleComfortInfo.proto\"G\n\u0015HomeComfortInfoNotify\u0012.\n\u000emoduleInfoList\u0018\u000b \u0003(\u000b2\u0016.HomeModuleComfortInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeModuleComfortInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeComfortInfoNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeComfortInfoNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeComfortInfoNotify_descriptor, new String[]{"ModuleInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeComfortInfoNotifyOuterClass$HomeComfortInfoNotifyOrBuilder.class */
    public interface HomeComfortInfoNotifyOrBuilder extends MessageOrBuilder {
        List<HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo> getModuleInfoListList();

        HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo getModuleInfoList(int i);

        int getModuleInfoListCount();

        List<? extends HomeModuleComfortInfoOuterClass.HomeModuleComfortInfoOrBuilder> getModuleInfoListOrBuilderList();

        HomeModuleComfortInfoOuterClass.HomeModuleComfortInfoOrBuilder getModuleInfoListOrBuilder(int i);
    }

    private HomeComfortInfoNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeComfortInfoNotifyOuterClass$HomeComfortInfoNotify.class */
    public static final class HomeComfortInfoNotify extends GeneratedMessageV3 implements HomeComfortInfoNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MODULEINFOLIST_FIELD_NUMBER = 11;
        private List<HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo> moduleInfoList_;
        private byte memoizedIsInitialized;
        private static final HomeComfortInfoNotify DEFAULT_INSTANCE = new HomeComfortInfoNotify();
        private static final Parser<HomeComfortInfoNotify> PARSER = new AbstractParser<HomeComfortInfoNotify>() { // from class: emu.grasscutter.net.proto.HomeComfortInfoNotifyOuterClass.HomeComfortInfoNotify.1
            @Override // com.google.protobuf.Parser
            public HomeComfortInfoNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeComfortInfoNotify(input, extensionRegistry);
            }
        };

        private HomeComfortInfoNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeComfortInfoNotify() {
            this.memoizedIsInitialized = -1;
            this.moduleInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeComfortInfoNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeComfortInfoNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                        this.moduleInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.moduleInfoList_.add((HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo) input.readMessage(HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo.parser(), extensionRegistry));
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
                    this.moduleInfoList_ = Collections.unmodifiableList(this.moduleInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeComfortInfoNotifyOuterClass.internal_static_HomeComfortInfoNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeComfortInfoNotifyOuterClass.internal_static_HomeComfortInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeComfortInfoNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeComfortInfoNotifyOuterClass.HomeComfortInfoNotifyOrBuilder
        public List<HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo> getModuleInfoListList() {
            return this.moduleInfoList_;
        }

        @Override // emu.grasscutter.net.proto.HomeComfortInfoNotifyOuterClass.HomeComfortInfoNotifyOrBuilder
        public List<? extends HomeModuleComfortInfoOuterClass.HomeModuleComfortInfoOrBuilder> getModuleInfoListOrBuilderList() {
            return this.moduleInfoList_;
        }

        @Override // emu.grasscutter.net.proto.HomeComfortInfoNotifyOuterClass.HomeComfortInfoNotifyOrBuilder
        public int getModuleInfoListCount() {
            return this.moduleInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeComfortInfoNotifyOuterClass.HomeComfortInfoNotifyOrBuilder
        public HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo getModuleInfoList(int index) {
            return this.moduleInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeComfortInfoNotifyOuterClass.HomeComfortInfoNotifyOrBuilder
        public HomeModuleComfortInfoOuterClass.HomeModuleComfortInfoOrBuilder getModuleInfoListOrBuilder(int index) {
            return this.moduleInfoList_.get(index);
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
            for (int i = 0; i < this.moduleInfoList_.size(); i++) {
                output.writeMessage(11, this.moduleInfoList_.get(i));
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
            for (int i = 0; i < this.moduleInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.moduleInfoList_.get(i));
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
            if (!(obj instanceof HomeComfortInfoNotify)) {
                return equals(obj);
            }
            HomeComfortInfoNotify other = (HomeComfortInfoNotify) obj;
            return getModuleInfoListList().equals(other.getModuleInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getModuleInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getModuleInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeComfortInfoNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeComfortInfoNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeComfortInfoNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeComfortInfoNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeComfortInfoNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeComfortInfoNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeComfortInfoNotify parseFrom(InputStream input) throws IOException {
            return (HomeComfortInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeComfortInfoNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeComfortInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeComfortInfoNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeComfortInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeComfortInfoNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeComfortInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeComfortInfoNotify parseFrom(CodedInputStream input) throws IOException {
            return (HomeComfortInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeComfortInfoNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeComfortInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeComfortInfoNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeComfortInfoNotifyOuterClass$HomeComfortInfoNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeComfortInfoNotifyOrBuilder {
            private int bitField0_;
            private List<HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo> moduleInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo, HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo.Builder, HomeModuleComfortInfoOuterClass.HomeModuleComfortInfoOrBuilder> moduleInfoListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeComfortInfoNotifyOuterClass.internal_static_HomeComfortInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeComfortInfoNotifyOuterClass.internal_static_HomeComfortInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeComfortInfoNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeComfortInfoNotify.alwaysUseFieldBuilders) {
                    getModuleInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.moduleInfoListBuilder_ == null) {
                    this.moduleInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.moduleInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeComfortInfoNotifyOuterClass.internal_static_HomeComfortInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeComfortInfoNotify getDefaultInstanceForType() {
                return HomeComfortInfoNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeComfortInfoNotify build() {
                HomeComfortInfoNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeComfortInfoNotify buildPartial() {
                HomeComfortInfoNotify result = new HomeComfortInfoNotify(this);
                int i = this.bitField0_;
                if (this.moduleInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.moduleInfoList_ = Collections.unmodifiableList(this.moduleInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.moduleInfoList_ = this.moduleInfoList_;
                } else {
                    result.moduleInfoList_ = this.moduleInfoListBuilder_.build();
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
                if (other instanceof HomeComfortInfoNotify) {
                    return mergeFrom((HomeComfortInfoNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeComfortInfoNotify other) {
                if (other == HomeComfortInfoNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.moduleInfoListBuilder_ == null) {
                    if (!other.moduleInfoList_.isEmpty()) {
                        if (this.moduleInfoList_.isEmpty()) {
                            this.moduleInfoList_ = other.moduleInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureModuleInfoListIsMutable();
                            this.moduleInfoList_.addAll(other.moduleInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.moduleInfoList_.isEmpty()) {
                    if (this.moduleInfoListBuilder_.isEmpty()) {
                        this.moduleInfoListBuilder_.dispose();
                        this.moduleInfoListBuilder_ = null;
                        this.moduleInfoList_ = other.moduleInfoList_;
                        this.bitField0_ &= -2;
                        this.moduleInfoListBuilder_ = HomeComfortInfoNotify.alwaysUseFieldBuilders ? getModuleInfoListFieldBuilder() : null;
                    } else {
                        this.moduleInfoListBuilder_.addAllMessages(other.moduleInfoList_);
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
                HomeComfortInfoNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeComfortInfoNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeComfortInfoNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureModuleInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.moduleInfoList_ = new ArrayList(this.moduleInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeComfortInfoNotifyOuterClass.HomeComfortInfoNotifyOrBuilder
            public List<HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo> getModuleInfoListList() {
                if (this.moduleInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.moduleInfoList_);
                }
                return this.moduleInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeComfortInfoNotifyOuterClass.HomeComfortInfoNotifyOrBuilder
            public int getModuleInfoListCount() {
                if (this.moduleInfoListBuilder_ == null) {
                    return this.moduleInfoList_.size();
                }
                return this.moduleInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeComfortInfoNotifyOuterClass.HomeComfortInfoNotifyOrBuilder
            public HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo getModuleInfoList(int index) {
                if (this.moduleInfoListBuilder_ == null) {
                    return this.moduleInfoList_.get(index);
                }
                return this.moduleInfoListBuilder_.getMessage(index);
            }

            public Builder setModuleInfoList(int index, HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo value) {
                if (this.moduleInfoListBuilder_ != null) {
                    this.moduleInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureModuleInfoListIsMutable();
                    this.moduleInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setModuleInfoList(int index, HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo.Builder builderForValue) {
                if (this.moduleInfoListBuilder_ == null) {
                    ensureModuleInfoListIsMutable();
                    this.moduleInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.moduleInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addModuleInfoList(HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo value) {
                if (this.moduleInfoListBuilder_ != null) {
                    this.moduleInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureModuleInfoListIsMutable();
                    this.moduleInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addModuleInfoList(int index, HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo value) {
                if (this.moduleInfoListBuilder_ != null) {
                    this.moduleInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureModuleInfoListIsMutable();
                    this.moduleInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addModuleInfoList(HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo.Builder builderForValue) {
                if (this.moduleInfoListBuilder_ == null) {
                    ensureModuleInfoListIsMutable();
                    this.moduleInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.moduleInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addModuleInfoList(int index, HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo.Builder builderForValue) {
                if (this.moduleInfoListBuilder_ == null) {
                    ensureModuleInfoListIsMutable();
                    this.moduleInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.moduleInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllModuleInfoList(Iterable<? extends HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo> values) {
                if (this.moduleInfoListBuilder_ == null) {
                    ensureModuleInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.moduleInfoList_);
                    onChanged();
                } else {
                    this.moduleInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearModuleInfoList() {
                if (this.moduleInfoListBuilder_ == null) {
                    this.moduleInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.moduleInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeModuleInfoList(int index) {
                if (this.moduleInfoListBuilder_ == null) {
                    ensureModuleInfoListIsMutable();
                    this.moduleInfoList_.remove(index);
                    onChanged();
                } else {
                    this.moduleInfoListBuilder_.remove(index);
                }
                return this;
            }

            public HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo.Builder getModuleInfoListBuilder(int index) {
                return getModuleInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeComfortInfoNotifyOuterClass.HomeComfortInfoNotifyOrBuilder
            public HomeModuleComfortInfoOuterClass.HomeModuleComfortInfoOrBuilder getModuleInfoListOrBuilder(int index) {
                if (this.moduleInfoListBuilder_ == null) {
                    return this.moduleInfoList_.get(index);
                }
                return this.moduleInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeComfortInfoNotifyOuterClass.HomeComfortInfoNotifyOrBuilder
            public List<? extends HomeModuleComfortInfoOuterClass.HomeModuleComfortInfoOrBuilder> getModuleInfoListOrBuilderList() {
                if (this.moduleInfoListBuilder_ != null) {
                    return this.moduleInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.moduleInfoList_);
            }

            public HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo.Builder addModuleInfoListBuilder() {
                return getModuleInfoListFieldBuilder().addBuilder(HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo.getDefaultInstance());
            }

            public HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo.Builder addModuleInfoListBuilder(int index) {
                return getModuleInfoListFieldBuilder().addBuilder(index, HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo.getDefaultInstance());
            }

            public List<HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo.Builder> getModuleInfoListBuilderList() {
                return getModuleInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo, HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo.Builder, HomeModuleComfortInfoOuterClass.HomeModuleComfortInfoOrBuilder> getModuleInfoListFieldBuilder() {
                if (this.moduleInfoListBuilder_ == null) {
                    this.moduleInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.moduleInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.moduleInfoList_ = null;
                }
                return this.moduleInfoListBuilder_;
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

        public static HomeComfortInfoNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeComfortInfoNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeComfortInfoNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeComfortInfoNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HomeModuleComfortInfoOuterClass.getDescriptor();
    }
}
