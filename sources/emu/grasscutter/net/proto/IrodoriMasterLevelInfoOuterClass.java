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
import emu.grasscutter.net.proto.IrodoriMasterLevelDetailInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriMasterLevelInfoOuterClass.class */
public final class IrodoriMasterLevelInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cIrodoriMasterLevelInfo.proto\u001a\"IrodoriMasterLevelDetailInfo.proto\"^\n\u0016IrodoriMasterLevelInfo\u00122\n\u000bdetail_info\u0018\u0001 \u0003(\u000b2\u001d.IrodoriMasterLevelDetailInfo\u0012\u0010\n\blevel_id\u0018\u0007 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{IrodoriMasterLevelDetailInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_IrodoriMasterLevelInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_IrodoriMasterLevelInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_IrodoriMasterLevelInfo_descriptor, new String[]{"DetailInfo", "LevelId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriMasterLevelInfoOuterClass$IrodoriMasterLevelInfoOrBuilder.class */
    public interface IrodoriMasterLevelInfoOrBuilder extends MessageOrBuilder {
        List<IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo> getDetailInfoList();

        IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo getDetailInfo(int i);

        int getDetailInfoCount();

        List<? extends IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfoOrBuilder> getDetailInfoOrBuilderList();

        IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfoOrBuilder getDetailInfoOrBuilder(int i);

        int getLevelId();
    }

    private IrodoriMasterLevelInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriMasterLevelInfoOuterClass$IrodoriMasterLevelInfo.class */
    public static final class IrodoriMasterLevelInfo extends GeneratedMessageV3 implements IrodoriMasterLevelInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DETAIL_INFO_FIELD_NUMBER = 1;
        private List<IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo> detailInfo_;
        public static final int LEVEL_ID_FIELD_NUMBER = 7;
        private int levelId_;
        private byte memoizedIsInitialized;
        private static final IrodoriMasterLevelInfo DEFAULT_INSTANCE = new IrodoriMasterLevelInfo();
        private static final Parser<IrodoriMasterLevelInfo> PARSER = new AbstractParser<IrodoriMasterLevelInfo>() { // from class: emu.grasscutter.net.proto.IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfo.1
            @Override // com.google.protobuf.Parser
            public IrodoriMasterLevelInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new IrodoriMasterLevelInfo(input, extensionRegistry);
            }
        };

        private IrodoriMasterLevelInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private IrodoriMasterLevelInfo() {
            this.memoizedIsInitialized = -1;
            this.detailInfo_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new IrodoriMasterLevelInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private IrodoriMasterLevelInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 10:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.detailInfo_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.detailInfo_.add((IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo) input.readMessage(IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo.parser(), extensionRegistry));
                                    break;
                                case 56:
                                    this.levelId_ = input.readUInt32();
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
                    this.detailInfo_ = Collections.unmodifiableList(this.detailInfo_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return IrodoriMasterLevelInfoOuterClass.internal_static_IrodoriMasterLevelInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return IrodoriMasterLevelInfoOuterClass.internal_static_IrodoriMasterLevelInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriMasterLevelInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfoOrBuilder
        public List<IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo> getDetailInfoList() {
            return this.detailInfo_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfoOrBuilder
        public List<? extends IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfoOrBuilder> getDetailInfoOrBuilderList() {
            return this.detailInfo_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfoOrBuilder
        public int getDetailInfoCount() {
            return this.detailInfo_.size();
        }

        @Override // emu.grasscutter.net.proto.IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfoOrBuilder
        public IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo getDetailInfo(int index) {
            return this.detailInfo_.get(index);
        }

        @Override // emu.grasscutter.net.proto.IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfoOrBuilder
        public IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfoOrBuilder getDetailInfoOrBuilder(int index) {
            return this.detailInfo_.get(index);
        }

        @Override // emu.grasscutter.net.proto.IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfoOrBuilder
        public int getLevelId() {
            return this.levelId_;
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
            for (int i = 0; i < this.detailInfo_.size(); i++) {
                output.writeMessage(1, this.detailInfo_.get(i));
            }
            if (this.levelId_ != 0) {
                output.writeUInt32(7, this.levelId_);
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
            for (int i = 0; i < this.detailInfo_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.detailInfo_.get(i));
            }
            if (this.levelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.levelId_);
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
            if (!(obj instanceof IrodoriMasterLevelInfo)) {
                return equals(obj);
            }
            IrodoriMasterLevelInfo other = (IrodoriMasterLevelInfo) obj;
            return getDetailInfoList().equals(other.getDetailInfoList()) && getLevelId() == other.getLevelId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getDetailInfoCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getDetailInfoList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 7)) + getLevelId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static IrodoriMasterLevelInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriMasterLevelInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriMasterLevelInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriMasterLevelInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriMasterLevelInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriMasterLevelInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriMasterLevelInfo parseFrom(InputStream input) throws IOException {
            return (IrodoriMasterLevelInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriMasterLevelInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriMasterLevelInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriMasterLevelInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (IrodoriMasterLevelInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static IrodoriMasterLevelInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriMasterLevelInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriMasterLevelInfo parseFrom(CodedInputStream input) throws IOException {
            return (IrodoriMasterLevelInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriMasterLevelInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriMasterLevelInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(IrodoriMasterLevelInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriMasterLevelInfoOuterClass$IrodoriMasterLevelInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements IrodoriMasterLevelInfoOrBuilder {
            private int bitField0_;
            private List<IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo> detailInfo_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo, IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo.Builder, IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfoOrBuilder> detailInfoBuilder_;
            private int levelId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return IrodoriMasterLevelInfoOuterClass.internal_static_IrodoriMasterLevelInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return IrodoriMasterLevelInfoOuterClass.internal_static_IrodoriMasterLevelInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriMasterLevelInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (IrodoriMasterLevelInfo.alwaysUseFieldBuilders) {
                    getDetailInfoFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.detailInfoBuilder_ == null) {
                    this.detailInfo_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.detailInfoBuilder_.clear();
                }
                this.levelId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return IrodoriMasterLevelInfoOuterClass.internal_static_IrodoriMasterLevelInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public IrodoriMasterLevelInfo getDefaultInstanceForType() {
                return IrodoriMasterLevelInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriMasterLevelInfo build() {
                IrodoriMasterLevelInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriMasterLevelInfo buildPartial() {
                IrodoriMasterLevelInfo result = new IrodoriMasterLevelInfo(this);
                int i = this.bitField0_;
                if (this.detailInfoBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.detailInfo_ = Collections.unmodifiableList(this.detailInfo_);
                        this.bitField0_ &= -2;
                    }
                    result.detailInfo_ = this.detailInfo_;
                } else {
                    result.detailInfo_ = this.detailInfoBuilder_.build();
                }
                result.levelId_ = this.levelId_;
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
                if (other instanceof IrodoriMasterLevelInfo) {
                    return mergeFrom((IrodoriMasterLevelInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(IrodoriMasterLevelInfo other) {
                if (other == IrodoriMasterLevelInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.detailInfoBuilder_ == null) {
                    if (!other.detailInfo_.isEmpty()) {
                        if (this.detailInfo_.isEmpty()) {
                            this.detailInfo_ = other.detailInfo_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDetailInfoIsMutable();
                            this.detailInfo_.addAll(other.detailInfo_);
                        }
                        onChanged();
                    }
                } else if (!other.detailInfo_.isEmpty()) {
                    if (this.detailInfoBuilder_.isEmpty()) {
                        this.detailInfoBuilder_.dispose();
                        this.detailInfoBuilder_ = null;
                        this.detailInfo_ = other.detailInfo_;
                        this.bitField0_ &= -2;
                        this.detailInfoBuilder_ = IrodoriMasterLevelInfo.alwaysUseFieldBuilders ? getDetailInfoFieldBuilder() : null;
                    } else {
                        this.detailInfoBuilder_.addAllMessages(other.detailInfo_);
                    }
                }
                if (other.getLevelId() != 0) {
                    setLevelId(other.getLevelId());
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
                IrodoriMasterLevelInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = IrodoriMasterLevelInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (IrodoriMasterLevelInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureDetailInfoIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.detailInfo_ = new ArrayList(this.detailInfo_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfoOrBuilder
            public List<IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo> getDetailInfoList() {
                if (this.detailInfoBuilder_ == null) {
                    return Collections.unmodifiableList(this.detailInfo_);
                }
                return this.detailInfoBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfoOrBuilder
            public int getDetailInfoCount() {
                if (this.detailInfoBuilder_ == null) {
                    return this.detailInfo_.size();
                }
                return this.detailInfoBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfoOrBuilder
            public IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo getDetailInfo(int index) {
                if (this.detailInfoBuilder_ == null) {
                    return this.detailInfo_.get(index);
                }
                return this.detailInfoBuilder_.getMessage(index);
            }

            public Builder setDetailInfo(int index, IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo value) {
                if (this.detailInfoBuilder_ != null) {
                    this.detailInfoBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDetailInfoIsMutable();
                    this.detailInfo_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDetailInfo(int index, IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo.Builder builderForValue) {
                if (this.detailInfoBuilder_ == null) {
                    ensureDetailInfoIsMutable();
                    this.detailInfo_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.detailInfoBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDetailInfo(IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo value) {
                if (this.detailInfoBuilder_ != null) {
                    this.detailInfoBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDetailInfoIsMutable();
                    this.detailInfo_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDetailInfo(int index, IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo value) {
                if (this.detailInfoBuilder_ != null) {
                    this.detailInfoBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDetailInfoIsMutable();
                    this.detailInfo_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDetailInfo(IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo.Builder builderForValue) {
                if (this.detailInfoBuilder_ == null) {
                    ensureDetailInfoIsMutable();
                    this.detailInfo_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.detailInfoBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDetailInfo(int index, IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo.Builder builderForValue) {
                if (this.detailInfoBuilder_ == null) {
                    ensureDetailInfoIsMutable();
                    this.detailInfo_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.detailInfoBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDetailInfo(Iterable<? extends IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo> values) {
                if (this.detailInfoBuilder_ == null) {
                    ensureDetailInfoIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.detailInfo_);
                    onChanged();
                } else {
                    this.detailInfoBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDetailInfo() {
                if (this.detailInfoBuilder_ == null) {
                    this.detailInfo_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.detailInfoBuilder_.clear();
                }
                return this;
            }

            public Builder removeDetailInfo(int index) {
                if (this.detailInfoBuilder_ == null) {
                    ensureDetailInfoIsMutable();
                    this.detailInfo_.remove(index);
                    onChanged();
                } else {
                    this.detailInfoBuilder_.remove(index);
                }
                return this;
            }

            public IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo.Builder getDetailInfoBuilder(int index) {
                return getDetailInfoFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfoOrBuilder
            public IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfoOrBuilder getDetailInfoOrBuilder(int index) {
                if (this.detailInfoBuilder_ == null) {
                    return this.detailInfo_.get(index);
                }
                return this.detailInfoBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfoOrBuilder
            public List<? extends IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfoOrBuilder> getDetailInfoOrBuilderList() {
                if (this.detailInfoBuilder_ != null) {
                    return this.detailInfoBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.detailInfo_);
            }

            public IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo.Builder addDetailInfoBuilder() {
                return getDetailInfoFieldBuilder().addBuilder(IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo.getDefaultInstance());
            }

            public IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo.Builder addDetailInfoBuilder(int index) {
                return getDetailInfoFieldBuilder().addBuilder(index, IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo.getDefaultInstance());
            }

            public List<IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo.Builder> getDetailInfoBuilderList() {
                return getDetailInfoFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo, IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo.Builder, IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfoOrBuilder> getDetailInfoFieldBuilder() {
                if (this.detailInfoBuilder_ == null) {
                    this.detailInfoBuilder_ = new RepeatedFieldBuilderV3<>(this.detailInfo_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.detailInfo_ = null;
                }
                return this.detailInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.IrodoriMasterLevelInfoOuterClass.IrodoriMasterLevelInfoOrBuilder
            public int getLevelId() {
                return this.levelId_;
            }

            public Builder setLevelId(int value) {
                this.levelId_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevelId() {
                this.levelId_ = 0;
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

        public static IrodoriMasterLevelInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<IrodoriMasterLevelInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<IrodoriMasterLevelInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public IrodoriMasterLevelInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        IrodoriMasterLevelDetailInfoOuterClass.getDescriptor();
    }
}
