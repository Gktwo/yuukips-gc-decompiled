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
import emu.grasscutter.net.proto.InstableSprayAvatarInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InstableSprayTeamInfoOuterClass.class */
public final class InstableSprayTeamInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bInstableSprayTeamInfo.proto\u001a\u001dInstableSprayAvatarInfo.proto\"K\n\u0015InstableSprayTeamInfo\u00122\n\u0010avatar_info_list\u0018\u0005 \u0003(\u000b2\u0018.InstableSprayAvatarInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{InstableSprayAvatarInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_InstableSprayTeamInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_InstableSprayTeamInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_InstableSprayTeamInfo_descriptor, new String[]{"AvatarInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InstableSprayTeamInfoOuterClass$InstableSprayTeamInfoOrBuilder.class */
    public interface InstableSprayTeamInfoOrBuilder extends MessageOrBuilder {
        List<InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo> getAvatarInfoListList();

        InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo getAvatarInfoList(int i);

        int getAvatarInfoListCount();

        List<? extends InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfoOrBuilder> getAvatarInfoListOrBuilderList();

        InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfoOrBuilder getAvatarInfoListOrBuilder(int i);
    }

    private InstableSprayTeamInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InstableSprayTeamInfoOuterClass$InstableSprayTeamInfo.class */
    public static final class InstableSprayTeamInfo extends GeneratedMessageV3 implements InstableSprayTeamInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATAR_INFO_LIST_FIELD_NUMBER = 5;
        private List<InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo> avatarInfoList_;
        private byte memoizedIsInitialized;
        private static final InstableSprayTeamInfo DEFAULT_INSTANCE = new InstableSprayTeamInfo();
        private static final Parser<InstableSprayTeamInfo> PARSER = new AbstractParser<InstableSprayTeamInfo>() { // from class: emu.grasscutter.net.proto.InstableSprayTeamInfoOuterClass.InstableSprayTeamInfo.1
            @Override // com.google.protobuf.Parser
            public InstableSprayTeamInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new InstableSprayTeamInfo(input, extensionRegistry);
            }
        };

        private InstableSprayTeamInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private InstableSprayTeamInfo() {
            this.memoizedIsInitialized = -1;
            this.avatarInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new InstableSprayTeamInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private InstableSprayTeamInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 42:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.avatarInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.avatarInfoList_.add((InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo) input.readMessage(InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo.parser(), extensionRegistry));
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
                    this.avatarInfoList_ = Collections.unmodifiableList(this.avatarInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return InstableSprayTeamInfoOuterClass.internal_static_InstableSprayTeamInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return InstableSprayTeamInfoOuterClass.internal_static_InstableSprayTeamInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(InstableSprayTeamInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.InstableSprayTeamInfoOuterClass.InstableSprayTeamInfoOrBuilder
        public List<InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo> getAvatarInfoListList() {
            return this.avatarInfoList_;
        }

        @Override // emu.grasscutter.net.proto.InstableSprayTeamInfoOuterClass.InstableSprayTeamInfoOrBuilder
        public List<? extends InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfoOrBuilder> getAvatarInfoListOrBuilderList() {
            return this.avatarInfoList_;
        }

        @Override // emu.grasscutter.net.proto.InstableSprayTeamInfoOuterClass.InstableSprayTeamInfoOrBuilder
        public int getAvatarInfoListCount() {
            return this.avatarInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.InstableSprayTeamInfoOuterClass.InstableSprayTeamInfoOrBuilder
        public InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo getAvatarInfoList(int index) {
            return this.avatarInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.InstableSprayTeamInfoOuterClass.InstableSprayTeamInfoOrBuilder
        public InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfoOrBuilder getAvatarInfoListOrBuilder(int index) {
            return this.avatarInfoList_.get(index);
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
            for (int i = 0; i < this.avatarInfoList_.size(); i++) {
                output.writeMessage(5, this.avatarInfoList_.get(i));
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
            for (int i = 0; i < this.avatarInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.avatarInfoList_.get(i));
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
            if (!(obj instanceof InstableSprayTeamInfo)) {
                return equals(obj);
            }
            InstableSprayTeamInfo other = (InstableSprayTeamInfo) obj;
            return getAvatarInfoListList().equals(other.getAvatarInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getAvatarInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getAvatarInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static InstableSprayTeamInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InstableSprayTeamInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InstableSprayTeamInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InstableSprayTeamInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InstableSprayTeamInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InstableSprayTeamInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InstableSprayTeamInfo parseFrom(InputStream input) throws IOException {
            return (InstableSprayTeamInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static InstableSprayTeamInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InstableSprayTeamInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static InstableSprayTeamInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (InstableSprayTeamInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static InstableSprayTeamInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InstableSprayTeamInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static InstableSprayTeamInfo parseFrom(CodedInputStream input) throws IOException {
            return (InstableSprayTeamInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static InstableSprayTeamInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InstableSprayTeamInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(InstableSprayTeamInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InstableSprayTeamInfoOuterClass$InstableSprayTeamInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements InstableSprayTeamInfoOrBuilder {
            private int bitField0_;
            private List<InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo> avatarInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo, InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo.Builder, InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfoOrBuilder> avatarInfoListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return InstableSprayTeamInfoOuterClass.internal_static_InstableSprayTeamInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return InstableSprayTeamInfoOuterClass.internal_static_InstableSprayTeamInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(InstableSprayTeamInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (InstableSprayTeamInfo.alwaysUseFieldBuilders) {
                    getAvatarInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.avatarInfoListBuilder_ == null) {
                    this.avatarInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.avatarInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return InstableSprayTeamInfoOuterClass.internal_static_InstableSprayTeamInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public InstableSprayTeamInfo getDefaultInstanceForType() {
                return InstableSprayTeamInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public InstableSprayTeamInfo build() {
                InstableSprayTeamInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public InstableSprayTeamInfo buildPartial() {
                InstableSprayTeamInfo result = new InstableSprayTeamInfo(this);
                int i = this.bitField0_;
                if (this.avatarInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.avatarInfoList_ = Collections.unmodifiableList(this.avatarInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.avatarInfoList_ = this.avatarInfoList_;
                } else {
                    result.avatarInfoList_ = this.avatarInfoListBuilder_.build();
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
                if (other instanceof InstableSprayTeamInfo) {
                    return mergeFrom((InstableSprayTeamInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(InstableSprayTeamInfo other) {
                if (other == InstableSprayTeamInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.avatarInfoListBuilder_ == null) {
                    if (!other.avatarInfoList_.isEmpty()) {
                        if (this.avatarInfoList_.isEmpty()) {
                            this.avatarInfoList_ = other.avatarInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureAvatarInfoListIsMutable();
                            this.avatarInfoList_.addAll(other.avatarInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.avatarInfoList_.isEmpty()) {
                    if (this.avatarInfoListBuilder_.isEmpty()) {
                        this.avatarInfoListBuilder_.dispose();
                        this.avatarInfoListBuilder_ = null;
                        this.avatarInfoList_ = other.avatarInfoList_;
                        this.bitField0_ &= -2;
                        this.avatarInfoListBuilder_ = InstableSprayTeamInfo.alwaysUseFieldBuilders ? getAvatarInfoListFieldBuilder() : null;
                    } else {
                        this.avatarInfoListBuilder_.addAllMessages(other.avatarInfoList_);
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
                InstableSprayTeamInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = InstableSprayTeamInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (InstableSprayTeamInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureAvatarInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.avatarInfoList_ = new ArrayList(this.avatarInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.InstableSprayTeamInfoOuterClass.InstableSprayTeamInfoOrBuilder
            public List<InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo> getAvatarInfoListList() {
                if (this.avatarInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.avatarInfoList_);
                }
                return this.avatarInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.InstableSprayTeamInfoOuterClass.InstableSprayTeamInfoOrBuilder
            public int getAvatarInfoListCount() {
                if (this.avatarInfoListBuilder_ == null) {
                    return this.avatarInfoList_.size();
                }
                return this.avatarInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.InstableSprayTeamInfoOuterClass.InstableSprayTeamInfoOrBuilder
            public InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo getAvatarInfoList(int index) {
                if (this.avatarInfoListBuilder_ == null) {
                    return this.avatarInfoList_.get(index);
                }
                return this.avatarInfoListBuilder_.getMessage(index);
            }

            public Builder setAvatarInfoList(int index, InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo value) {
                if (this.avatarInfoListBuilder_ != null) {
                    this.avatarInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setAvatarInfoList(int index, InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo.Builder builderForValue) {
                if (this.avatarInfoListBuilder_ == null) {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAvatarInfoList(InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo value) {
                if (this.avatarInfoListBuilder_ != null) {
                    this.avatarInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addAvatarInfoList(int index, InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo value) {
                if (this.avatarInfoListBuilder_ != null) {
                    this.avatarInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addAvatarInfoList(InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo.Builder builderForValue) {
                if (this.avatarInfoListBuilder_ == null) {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.avatarInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAvatarInfoList(int index, InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo.Builder builderForValue) {
                if (this.avatarInfoListBuilder_ == null) {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAvatarInfoList(Iterable<? extends InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo> values) {
                if (this.avatarInfoListBuilder_ == null) {
                    ensureAvatarInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.avatarInfoList_);
                    onChanged();
                } else {
                    this.avatarInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAvatarInfoList() {
                if (this.avatarInfoListBuilder_ == null) {
                    this.avatarInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.avatarInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeAvatarInfoList(int index) {
                if (this.avatarInfoListBuilder_ == null) {
                    ensureAvatarInfoListIsMutable();
                    this.avatarInfoList_.remove(index);
                    onChanged();
                } else {
                    this.avatarInfoListBuilder_.remove(index);
                }
                return this;
            }

            public InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo.Builder getAvatarInfoListBuilder(int index) {
                return getAvatarInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.InstableSprayTeamInfoOuterClass.InstableSprayTeamInfoOrBuilder
            public InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfoOrBuilder getAvatarInfoListOrBuilder(int index) {
                if (this.avatarInfoListBuilder_ == null) {
                    return this.avatarInfoList_.get(index);
                }
                return this.avatarInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.InstableSprayTeamInfoOuterClass.InstableSprayTeamInfoOrBuilder
            public List<? extends InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfoOrBuilder> getAvatarInfoListOrBuilderList() {
                if (this.avatarInfoListBuilder_ != null) {
                    return this.avatarInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.avatarInfoList_);
            }

            public InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo.Builder addAvatarInfoListBuilder() {
                return getAvatarInfoListFieldBuilder().addBuilder(InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo.getDefaultInstance());
            }

            public InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo.Builder addAvatarInfoListBuilder(int index) {
                return getAvatarInfoListFieldBuilder().addBuilder(index, InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo.getDefaultInstance());
            }

            public List<InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo.Builder> getAvatarInfoListBuilderList() {
                return getAvatarInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo, InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfo.Builder, InstableSprayAvatarInfoOuterClass.InstableSprayAvatarInfoOrBuilder> getAvatarInfoListFieldBuilder() {
                if (this.avatarInfoListBuilder_ == null) {
                    this.avatarInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.avatarInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.avatarInfoList_ = null;
                }
                return this.avatarInfoListBuilder_;
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

        public static InstableSprayTeamInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<InstableSprayTeamInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<InstableSprayTeamInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public InstableSprayTeamInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        InstableSprayAvatarInfoOuterClass.getDescriptor();
    }
}
