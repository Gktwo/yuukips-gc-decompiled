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
import emu.grasscutter.net.proto.IrodoriChessMonsterInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessEntranceInfoOuterClass.class */
public final class IrodoriChessEntranceInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eIrodoriChessEntranceInfo.proto\u001a\u001dIrodoriChessMonsterInfo.proto\"j\n\u0018IrodoriChessEntranceInfo\u0012\u0019\n\u0011entrance_point_id\u0018\u000b \u0001(\r\u00123\n\u0011monster_info_list\u0018\b \u0003(\u000b2\u0018.IrodoriChessMonsterInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{IrodoriChessMonsterInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_IrodoriChessEntranceInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_IrodoriChessEntranceInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_IrodoriChessEntranceInfo_descriptor, new String[]{"EntrancePointId", "MonsterInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessEntranceInfoOuterClass$IrodoriChessEntranceInfoOrBuilder.class */
    public interface IrodoriChessEntranceInfoOrBuilder extends MessageOrBuilder {
        int getEntrancePointId();

        List<IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo> getMonsterInfoListList();

        IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo getMonsterInfoList(int i);

        int getMonsterInfoListCount();

        List<? extends IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder> getMonsterInfoListOrBuilderList();

        IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder getMonsterInfoListOrBuilder(int i);
    }

    private IrodoriChessEntranceInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessEntranceInfoOuterClass$IrodoriChessEntranceInfo.class */
    public static final class IrodoriChessEntranceInfo extends GeneratedMessageV3 implements IrodoriChessEntranceInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTRANCE_POINT_ID_FIELD_NUMBER = 11;
        private int entrancePointId_;
        public static final int MONSTER_INFO_LIST_FIELD_NUMBER = 8;
        private List<IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo> monsterInfoList_;
        private byte memoizedIsInitialized;
        private static final IrodoriChessEntranceInfo DEFAULT_INSTANCE = new IrodoriChessEntranceInfo();
        private static final Parser<IrodoriChessEntranceInfo> PARSER = new AbstractParser<IrodoriChessEntranceInfo>() { // from class: emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo.1
            @Override // com.google.protobuf.Parser
            public IrodoriChessEntranceInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new IrodoriChessEntranceInfo(input, extensionRegistry);
            }
        };

        private IrodoriChessEntranceInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private IrodoriChessEntranceInfo() {
            this.memoizedIsInitialized = -1;
            this.monsterInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new IrodoriChessEntranceInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private IrodoriChessEntranceInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 66:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.monsterInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.monsterInfoList_.add((IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo) input.readMessage(IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.parser(), extensionRegistry));
                                    break;
                                case 88:
                                    this.entrancePointId_ = input.readUInt32();
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
                    this.monsterInfoList_ = Collections.unmodifiableList(this.monsterInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return IrodoriChessEntranceInfoOuterClass.internal_static_IrodoriChessEntranceInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return IrodoriChessEntranceInfoOuterClass.internal_static_IrodoriChessEntranceInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriChessEntranceInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
        public int getEntrancePointId() {
            return this.entrancePointId_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
        public List<IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo> getMonsterInfoListList() {
            return this.monsterInfoList_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
        public List<? extends IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder> getMonsterInfoListOrBuilderList() {
            return this.monsterInfoList_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
        public int getMonsterInfoListCount() {
            return this.monsterInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
        public IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo getMonsterInfoList(int index) {
            return this.monsterInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
        public IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder getMonsterInfoListOrBuilder(int index) {
            return this.monsterInfoList_.get(index);
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
            for (int i = 0; i < this.monsterInfoList_.size(); i++) {
                output.writeMessage(8, this.monsterInfoList_.get(i));
            }
            if (this.entrancePointId_ != 0) {
                output.writeUInt32(11, this.entrancePointId_);
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
            for (int i = 0; i < this.monsterInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(8, this.monsterInfoList_.get(i));
            }
            if (this.entrancePointId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.entrancePointId_);
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
            if (!(obj instanceof IrodoriChessEntranceInfo)) {
                return equals(obj);
            }
            IrodoriChessEntranceInfo other = (IrodoriChessEntranceInfo) obj;
            return getEntrancePointId() == other.getEntrancePointId() && getMonsterInfoListList().equals(other.getMonsterInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getEntrancePointId();
            if (getMonsterInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 8)) + getMonsterInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static IrodoriChessEntranceInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessEntranceInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessEntranceInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessEntranceInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessEntranceInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessEntranceInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessEntranceInfo parseFrom(InputStream input) throws IOException {
            return (IrodoriChessEntranceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriChessEntranceInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessEntranceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriChessEntranceInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (IrodoriChessEntranceInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static IrodoriChessEntranceInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessEntranceInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriChessEntranceInfo parseFrom(CodedInputStream input) throws IOException {
            return (IrodoriChessEntranceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriChessEntranceInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessEntranceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(IrodoriChessEntranceInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessEntranceInfoOuterClass$IrodoriChessEntranceInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements IrodoriChessEntranceInfoOrBuilder {
            private int bitField0_;
            private int entrancePointId_;
            private List<IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo> monsterInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo, IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.Builder, IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder> monsterInfoListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return IrodoriChessEntranceInfoOuterClass.internal_static_IrodoriChessEntranceInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return IrodoriChessEntranceInfoOuterClass.internal_static_IrodoriChessEntranceInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriChessEntranceInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (IrodoriChessEntranceInfo.alwaysUseFieldBuilders) {
                    getMonsterInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.entrancePointId_ = 0;
                if (this.monsterInfoListBuilder_ == null) {
                    this.monsterInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.monsterInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return IrodoriChessEntranceInfoOuterClass.internal_static_IrodoriChessEntranceInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public IrodoriChessEntranceInfo getDefaultInstanceForType() {
                return IrodoriChessEntranceInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriChessEntranceInfo build() {
                IrodoriChessEntranceInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriChessEntranceInfo buildPartial() {
                IrodoriChessEntranceInfo result = new IrodoriChessEntranceInfo(this);
                int i = this.bitField0_;
                result.entrancePointId_ = this.entrancePointId_;
                if (this.monsterInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.monsterInfoList_ = Collections.unmodifiableList(this.monsterInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.monsterInfoList_ = this.monsterInfoList_;
                } else {
                    result.monsterInfoList_ = this.monsterInfoListBuilder_.build();
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
                if (other instanceof IrodoriChessEntranceInfo) {
                    return mergeFrom((IrodoriChessEntranceInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(IrodoriChessEntranceInfo other) {
                if (other == IrodoriChessEntranceInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getEntrancePointId() != 0) {
                    setEntrancePointId(other.getEntrancePointId());
                }
                if (this.monsterInfoListBuilder_ == null) {
                    if (!other.monsterInfoList_.isEmpty()) {
                        if (this.monsterInfoList_.isEmpty()) {
                            this.monsterInfoList_ = other.monsterInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureMonsterInfoListIsMutable();
                            this.monsterInfoList_.addAll(other.monsterInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.monsterInfoList_.isEmpty()) {
                    if (this.monsterInfoListBuilder_.isEmpty()) {
                        this.monsterInfoListBuilder_.dispose();
                        this.monsterInfoListBuilder_ = null;
                        this.monsterInfoList_ = other.monsterInfoList_;
                        this.bitField0_ &= -2;
                        this.monsterInfoListBuilder_ = IrodoriChessEntranceInfo.alwaysUseFieldBuilders ? getMonsterInfoListFieldBuilder() : null;
                    } else {
                        this.monsterInfoListBuilder_.addAllMessages(other.monsterInfoList_);
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
                IrodoriChessEntranceInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = IrodoriChessEntranceInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (IrodoriChessEntranceInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
            public int getEntrancePointId() {
                return this.entrancePointId_;
            }

            public Builder setEntrancePointId(int value) {
                this.entrancePointId_ = value;
                onChanged();
                return this;
            }

            public Builder clearEntrancePointId() {
                this.entrancePointId_ = 0;
                onChanged();
                return this;
            }

            private void ensureMonsterInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.monsterInfoList_ = new ArrayList(this.monsterInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
            public List<IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo> getMonsterInfoListList() {
                if (this.monsterInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.monsterInfoList_);
                }
                return this.monsterInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
            public int getMonsterInfoListCount() {
                if (this.monsterInfoListBuilder_ == null) {
                    return this.monsterInfoList_.size();
                }
                return this.monsterInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
            public IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo getMonsterInfoList(int index) {
                if (this.monsterInfoListBuilder_ == null) {
                    return this.monsterInfoList_.get(index);
                }
                return this.monsterInfoListBuilder_.getMessage(index);
            }

            public Builder setMonsterInfoList(int index, IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo value) {
                if (this.monsterInfoListBuilder_ != null) {
                    this.monsterInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMonsterInfoListIsMutable();
                    this.monsterInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMonsterInfoList(int index, IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.Builder builderForValue) {
                if (this.monsterInfoListBuilder_ == null) {
                    ensureMonsterInfoListIsMutable();
                    this.monsterInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.monsterInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMonsterInfoList(IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo value) {
                if (this.monsterInfoListBuilder_ != null) {
                    this.monsterInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMonsterInfoListIsMutable();
                    this.monsterInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMonsterInfoList(int index, IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo value) {
                if (this.monsterInfoListBuilder_ != null) {
                    this.monsterInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMonsterInfoListIsMutable();
                    this.monsterInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMonsterInfoList(IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.Builder builderForValue) {
                if (this.monsterInfoListBuilder_ == null) {
                    ensureMonsterInfoListIsMutable();
                    this.monsterInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.monsterInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMonsterInfoList(int index, IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.Builder builderForValue) {
                if (this.monsterInfoListBuilder_ == null) {
                    ensureMonsterInfoListIsMutable();
                    this.monsterInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.monsterInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMonsterInfoList(Iterable<? extends IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo> values) {
                if (this.monsterInfoListBuilder_ == null) {
                    ensureMonsterInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.monsterInfoList_);
                    onChanged();
                } else {
                    this.monsterInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMonsterInfoList() {
                if (this.monsterInfoListBuilder_ == null) {
                    this.monsterInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.monsterInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeMonsterInfoList(int index) {
                if (this.monsterInfoListBuilder_ == null) {
                    ensureMonsterInfoListIsMutable();
                    this.monsterInfoList_.remove(index);
                    onChanged();
                } else {
                    this.monsterInfoListBuilder_.remove(index);
                }
                return this;
            }

            public IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.Builder getMonsterInfoListBuilder(int index) {
                return getMonsterInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
            public IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder getMonsterInfoListOrBuilder(int index) {
                if (this.monsterInfoListBuilder_ == null) {
                    return this.monsterInfoList_.get(index);
                }
                return this.monsterInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
            public List<? extends IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder> getMonsterInfoListOrBuilderList() {
                if (this.monsterInfoListBuilder_ != null) {
                    return this.monsterInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.monsterInfoList_);
            }

            public IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.Builder addMonsterInfoListBuilder() {
                return getMonsterInfoListFieldBuilder().addBuilder(IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.getDefaultInstance());
            }

            public IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.Builder addMonsterInfoListBuilder(int index) {
                return getMonsterInfoListFieldBuilder().addBuilder(index, IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.getDefaultInstance());
            }

            public List<IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.Builder> getMonsterInfoListBuilderList() {
                return getMonsterInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo, IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.Builder, IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder> getMonsterInfoListFieldBuilder() {
                if (this.monsterInfoListBuilder_ == null) {
                    this.monsterInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.monsterInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.monsterInfoList_ = null;
                }
                return this.monsterInfoListBuilder_;
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

        public static IrodoriChessEntranceInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<IrodoriChessEntranceInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<IrodoriChessEntranceInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public IrodoriChessEntranceInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        IrodoriChessMonsterInfoOuterClass.getDescriptor();
    }
}
