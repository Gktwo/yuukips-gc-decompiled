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
import emu.grasscutter.net.proto.RogueAvatarInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueShowAvatarTeamInfoOuterClass.class */
public final class RogueShowAvatarTeamInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dRogueShowAvatarTeamInfo.proto\u001a\u0015RogueAvatarInfo.proto\"?\n\u0017RogueShowAvatarTeamInfo\u0012$\n\navatarList\u0018\u0003 \u0003(\u000b2\u0010.RogueAvatarInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{RogueAvatarInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_RogueShowAvatarTeamInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_RogueShowAvatarTeamInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_RogueShowAvatarTeamInfo_descriptor, new String[]{"AvatarList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueShowAvatarTeamInfoOuterClass$RogueShowAvatarTeamInfoOrBuilder.class */
    public interface RogueShowAvatarTeamInfoOrBuilder extends MessageOrBuilder {
        List<RogueAvatarInfoOuterClass.RogueAvatarInfo> getAvatarListList();

        RogueAvatarInfoOuterClass.RogueAvatarInfo getAvatarList(int i);

        int getAvatarListCount();

        List<? extends RogueAvatarInfoOuterClass.RogueAvatarInfoOrBuilder> getAvatarListOrBuilderList();

        RogueAvatarInfoOuterClass.RogueAvatarInfoOrBuilder getAvatarListOrBuilder(int i);
    }

    private RogueShowAvatarTeamInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueShowAvatarTeamInfoOuterClass$RogueShowAvatarTeamInfo.class */
    public static final class RogueShowAvatarTeamInfo extends GeneratedMessageV3 implements RogueShowAvatarTeamInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATARLIST_FIELD_NUMBER = 3;
        private List<RogueAvatarInfoOuterClass.RogueAvatarInfo> avatarList_;
        private byte memoizedIsInitialized;
        private static final RogueShowAvatarTeamInfo DEFAULT_INSTANCE = new RogueShowAvatarTeamInfo();
        private static final Parser<RogueShowAvatarTeamInfo> PARSER = new AbstractParser<RogueShowAvatarTeamInfo>() { // from class: emu.grasscutter.net.proto.RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfo.1
            @Override // com.google.protobuf.Parser
            public RogueShowAvatarTeamInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RogueShowAvatarTeamInfo(input, extensionRegistry);
            }
        };

        private RogueShowAvatarTeamInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private RogueShowAvatarTeamInfo() {
            this.memoizedIsInitialized = -1;
            this.avatarList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new RogueShowAvatarTeamInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RogueShowAvatarTeamInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 26:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.avatarList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.avatarList_.add((RogueAvatarInfoOuterClass.RogueAvatarInfo) input.readMessage(RogueAvatarInfoOuterClass.RogueAvatarInfo.parser(), extensionRegistry));
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
                    this.avatarList_ = Collections.unmodifiableList(this.avatarList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return RogueShowAvatarTeamInfoOuterClass.internal_static_RogueShowAvatarTeamInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RogueShowAvatarTeamInfoOuterClass.internal_static_RogueShowAvatarTeamInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RogueShowAvatarTeamInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfoOrBuilder
        public List<RogueAvatarInfoOuterClass.RogueAvatarInfo> getAvatarListList() {
            return this.avatarList_;
        }

        @Override // emu.grasscutter.net.proto.RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfoOrBuilder
        public List<? extends RogueAvatarInfoOuterClass.RogueAvatarInfoOrBuilder> getAvatarListOrBuilderList() {
            return this.avatarList_;
        }

        @Override // emu.grasscutter.net.proto.RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfoOrBuilder
        public int getAvatarListCount() {
            return this.avatarList_.size();
        }

        @Override // emu.grasscutter.net.proto.RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfoOrBuilder
        public RogueAvatarInfoOuterClass.RogueAvatarInfo getAvatarList(int index) {
            return this.avatarList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfoOrBuilder
        public RogueAvatarInfoOuterClass.RogueAvatarInfoOrBuilder getAvatarListOrBuilder(int index) {
            return this.avatarList_.get(index);
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
            for (int i = 0; i < this.avatarList_.size(); i++) {
                output.writeMessage(3, this.avatarList_.get(i));
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
            for (int i = 0; i < this.avatarList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.avatarList_.get(i));
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
            if (!(obj instanceof RogueShowAvatarTeamInfo)) {
                return equals(obj);
            }
            RogueShowAvatarTeamInfo other = (RogueShowAvatarTeamInfo) obj;
            return getAvatarListList().equals(other.getAvatarListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getAvatarListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getAvatarListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static RogueShowAvatarTeamInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueShowAvatarTeamInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueShowAvatarTeamInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueShowAvatarTeamInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueShowAvatarTeamInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueShowAvatarTeamInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueShowAvatarTeamInfo parseFrom(InputStream input) throws IOException {
            return (RogueShowAvatarTeamInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RogueShowAvatarTeamInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueShowAvatarTeamInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RogueShowAvatarTeamInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (RogueShowAvatarTeamInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static RogueShowAvatarTeamInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueShowAvatarTeamInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RogueShowAvatarTeamInfo parseFrom(CodedInputStream input) throws IOException {
            return (RogueShowAvatarTeamInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RogueShowAvatarTeamInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueShowAvatarTeamInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RogueShowAvatarTeamInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueShowAvatarTeamInfoOuterClass$RogueShowAvatarTeamInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RogueShowAvatarTeamInfoOrBuilder {
            private int bitField0_;
            private List<RogueAvatarInfoOuterClass.RogueAvatarInfo> avatarList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<RogueAvatarInfoOuterClass.RogueAvatarInfo, RogueAvatarInfoOuterClass.RogueAvatarInfo.Builder, RogueAvatarInfoOuterClass.RogueAvatarInfoOrBuilder> avatarListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RogueShowAvatarTeamInfoOuterClass.internal_static_RogueShowAvatarTeamInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RogueShowAvatarTeamInfoOuterClass.internal_static_RogueShowAvatarTeamInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RogueShowAvatarTeamInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RogueShowAvatarTeamInfo.alwaysUseFieldBuilders) {
                    getAvatarListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.avatarListBuilder_ == null) {
                    this.avatarList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.avatarListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RogueShowAvatarTeamInfoOuterClass.internal_static_RogueShowAvatarTeamInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RogueShowAvatarTeamInfo getDefaultInstanceForType() {
                return RogueShowAvatarTeamInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RogueShowAvatarTeamInfo build() {
                RogueShowAvatarTeamInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RogueShowAvatarTeamInfo buildPartial() {
                RogueShowAvatarTeamInfo result = new RogueShowAvatarTeamInfo(this);
                int i = this.bitField0_;
                if (this.avatarListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.avatarList_ = Collections.unmodifiableList(this.avatarList_);
                        this.bitField0_ &= -2;
                    }
                    result.avatarList_ = this.avatarList_;
                } else {
                    result.avatarList_ = this.avatarListBuilder_.build();
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
                if (other instanceof RogueShowAvatarTeamInfo) {
                    return mergeFrom((RogueShowAvatarTeamInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RogueShowAvatarTeamInfo other) {
                if (other == RogueShowAvatarTeamInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.avatarListBuilder_ == null) {
                    if (!other.avatarList_.isEmpty()) {
                        if (this.avatarList_.isEmpty()) {
                            this.avatarList_ = other.avatarList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureAvatarListIsMutable();
                            this.avatarList_.addAll(other.avatarList_);
                        }
                        onChanged();
                    }
                } else if (!other.avatarList_.isEmpty()) {
                    if (this.avatarListBuilder_.isEmpty()) {
                        this.avatarListBuilder_.dispose();
                        this.avatarListBuilder_ = null;
                        this.avatarList_ = other.avatarList_;
                        this.bitField0_ &= -2;
                        this.avatarListBuilder_ = RogueShowAvatarTeamInfo.alwaysUseFieldBuilders ? getAvatarListFieldBuilder() : null;
                    } else {
                        this.avatarListBuilder_.addAllMessages(other.avatarList_);
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
                RogueShowAvatarTeamInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = RogueShowAvatarTeamInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (RogueShowAvatarTeamInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureAvatarListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.avatarList_ = new ArrayList(this.avatarList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfoOrBuilder
            public List<RogueAvatarInfoOuterClass.RogueAvatarInfo> getAvatarListList() {
                if (this.avatarListBuilder_ == null) {
                    return Collections.unmodifiableList(this.avatarList_);
                }
                return this.avatarListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfoOrBuilder
            public int getAvatarListCount() {
                if (this.avatarListBuilder_ == null) {
                    return this.avatarList_.size();
                }
                return this.avatarListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfoOrBuilder
            public RogueAvatarInfoOuterClass.RogueAvatarInfo getAvatarList(int index) {
                if (this.avatarListBuilder_ == null) {
                    return this.avatarList_.get(index);
                }
                return this.avatarListBuilder_.getMessage(index);
            }

            public Builder setAvatarList(int index, RogueAvatarInfoOuterClass.RogueAvatarInfo value) {
                if (this.avatarListBuilder_ != null) {
                    this.avatarListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarListIsMutable();
                    this.avatarList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setAvatarList(int index, RogueAvatarInfoOuterClass.RogueAvatarInfo.Builder builderForValue) {
                if (this.avatarListBuilder_ == null) {
                    ensureAvatarListIsMutable();
                    this.avatarList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAvatarList(RogueAvatarInfoOuterClass.RogueAvatarInfo value) {
                if (this.avatarListBuilder_ != null) {
                    this.avatarListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarListIsMutable();
                    this.avatarList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addAvatarList(int index, RogueAvatarInfoOuterClass.RogueAvatarInfo value) {
                if (this.avatarListBuilder_ != null) {
                    this.avatarListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarListIsMutable();
                    this.avatarList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addAvatarList(RogueAvatarInfoOuterClass.RogueAvatarInfo.Builder builderForValue) {
                if (this.avatarListBuilder_ == null) {
                    ensureAvatarListIsMutable();
                    this.avatarList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.avatarListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAvatarList(int index, RogueAvatarInfoOuterClass.RogueAvatarInfo.Builder builderForValue) {
                if (this.avatarListBuilder_ == null) {
                    ensureAvatarListIsMutable();
                    this.avatarList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAvatarList(Iterable<? extends RogueAvatarInfoOuterClass.RogueAvatarInfo> values) {
                if (this.avatarListBuilder_ == null) {
                    ensureAvatarListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.avatarList_);
                    onChanged();
                } else {
                    this.avatarListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAvatarList() {
                if (this.avatarListBuilder_ == null) {
                    this.avatarList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.avatarListBuilder_.clear();
                }
                return this;
            }

            public Builder removeAvatarList(int index) {
                if (this.avatarListBuilder_ == null) {
                    ensureAvatarListIsMutable();
                    this.avatarList_.remove(index);
                    onChanged();
                } else {
                    this.avatarListBuilder_.remove(index);
                }
                return this;
            }

            public RogueAvatarInfoOuterClass.RogueAvatarInfo.Builder getAvatarListBuilder(int index) {
                return getAvatarListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfoOrBuilder
            public RogueAvatarInfoOuterClass.RogueAvatarInfoOrBuilder getAvatarListOrBuilder(int index) {
                if (this.avatarListBuilder_ == null) {
                    return this.avatarList_.get(index);
                }
                return this.avatarListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.RogueShowAvatarTeamInfoOuterClass.RogueShowAvatarTeamInfoOrBuilder
            public List<? extends RogueAvatarInfoOuterClass.RogueAvatarInfoOrBuilder> getAvatarListOrBuilderList() {
                if (this.avatarListBuilder_ != null) {
                    return this.avatarListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.avatarList_);
            }

            public RogueAvatarInfoOuterClass.RogueAvatarInfo.Builder addAvatarListBuilder() {
                return getAvatarListFieldBuilder().addBuilder(RogueAvatarInfoOuterClass.RogueAvatarInfo.getDefaultInstance());
            }

            public RogueAvatarInfoOuterClass.RogueAvatarInfo.Builder addAvatarListBuilder(int index) {
                return getAvatarListFieldBuilder().addBuilder(index, RogueAvatarInfoOuterClass.RogueAvatarInfo.getDefaultInstance());
            }

            public List<RogueAvatarInfoOuterClass.RogueAvatarInfo.Builder> getAvatarListBuilderList() {
                return getAvatarListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<RogueAvatarInfoOuterClass.RogueAvatarInfo, RogueAvatarInfoOuterClass.RogueAvatarInfo.Builder, RogueAvatarInfoOuterClass.RogueAvatarInfoOrBuilder> getAvatarListFieldBuilder() {
                if (this.avatarListBuilder_ == null) {
                    this.avatarListBuilder_ = new RepeatedFieldBuilderV3<>(this.avatarList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.avatarList_ = null;
                }
                return this.avatarListBuilder_;
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

        public static RogueShowAvatarTeamInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RogueShowAvatarTeamInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RogueShowAvatarTeamInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RogueShowAvatarTeamInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        RogueAvatarInfoOuterClass.getDescriptor();
    }
}
