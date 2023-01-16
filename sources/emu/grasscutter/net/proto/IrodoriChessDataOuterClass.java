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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.IrodoriChessLevelDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessDataOuterClass.class */
public final class IrodoriChessDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016IrodoriChessData.proto\u001a\u001bIrodoriChessLevelData.proto\"T\n\u0010IrodoriChessData\u0012\u000f\n\u0007is_open\u0018\b \u0001(\b\u0012/\n\u000flevel_data_list\u0018\r \u0003(\u000b2\u0016.IrodoriChessLevelDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{IrodoriChessLevelDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_IrodoriChessData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_IrodoriChessData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_IrodoriChessData_descriptor, new String[]{"IsOpen", "LevelDataList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessDataOuterClass$IrodoriChessDataOrBuilder.class */
    public interface IrodoriChessDataOrBuilder extends MessageOrBuilder {
        boolean getIsOpen();

        List<IrodoriChessLevelDataOuterClass.IrodoriChessLevelData> getLevelDataListList();

        IrodoriChessLevelDataOuterClass.IrodoriChessLevelData getLevelDataList(int i);

        int getLevelDataListCount();

        List<? extends IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder> getLevelDataListOrBuilderList();

        IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder getLevelDataListOrBuilder(int i);
    }

    private IrodoriChessDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessDataOuterClass$IrodoriChessData.class */
    public static final class IrodoriChessData extends GeneratedMessageV3 implements IrodoriChessDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_OPEN_FIELD_NUMBER = 8;
        private boolean isOpen_;
        public static final int LEVEL_DATA_LIST_FIELD_NUMBER = 13;
        private List<IrodoriChessLevelDataOuterClass.IrodoriChessLevelData> levelDataList_;
        private byte memoizedIsInitialized;
        private static final IrodoriChessData DEFAULT_INSTANCE = new IrodoriChessData();
        private static final Parser<IrodoriChessData> PARSER = new AbstractParser<IrodoriChessData>() { // from class: emu.grasscutter.net.proto.IrodoriChessDataOuterClass.IrodoriChessData.1
            @Override // com.google.protobuf.Parser
            public IrodoriChessData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new IrodoriChessData(input, extensionRegistry);
            }
        };

        private IrodoriChessData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private IrodoriChessData() {
            this.memoizedIsInitialized = -1;
            this.levelDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new IrodoriChessData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private IrodoriChessData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 64:
                                    this.isOpen_ = input.readBool();
                                    break;
                                case 106:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.levelDataList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.levelDataList_.add((IrodoriChessLevelDataOuterClass.IrodoriChessLevelData) input.readMessage(IrodoriChessLevelDataOuterClass.IrodoriChessLevelData.parser(), extensionRegistry));
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
                    this.levelDataList_ = Collections.unmodifiableList(this.levelDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return IrodoriChessDataOuterClass.internal_static_IrodoriChessData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return IrodoriChessDataOuterClass.internal_static_IrodoriChessData_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriChessData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessDataOuterClass.IrodoriChessDataOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessDataOuterClass.IrodoriChessDataOrBuilder
        public List<IrodoriChessLevelDataOuterClass.IrodoriChessLevelData> getLevelDataListList() {
            return this.levelDataList_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessDataOuterClass.IrodoriChessDataOrBuilder
        public List<? extends IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder> getLevelDataListOrBuilderList() {
            return this.levelDataList_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessDataOuterClass.IrodoriChessDataOrBuilder
        public int getLevelDataListCount() {
            return this.levelDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessDataOuterClass.IrodoriChessDataOrBuilder
        public IrodoriChessLevelDataOuterClass.IrodoriChessLevelData getLevelDataList(int index) {
            return this.levelDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessDataOuterClass.IrodoriChessDataOrBuilder
        public IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder getLevelDataListOrBuilder(int index) {
            return this.levelDataList_.get(index);
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
            if (this.isOpen_) {
                output.writeBool(8, this.isOpen_);
            }
            for (int i = 0; i < this.levelDataList_.size(); i++) {
                output.writeMessage(13, this.levelDataList_.get(i));
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
            if (this.isOpen_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(8, this.isOpen_);
            }
            for (int i = 0; i < this.levelDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(13, this.levelDataList_.get(i));
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
            if (!(obj instanceof IrodoriChessData)) {
                return equals(obj);
            }
            IrodoriChessData other = (IrodoriChessData) obj;
            return getIsOpen() == other.getIsOpen() && getLevelDataListList().equals(other.getLevelDataListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + Internal.hashBoolean(getIsOpen());
            if (getLevelDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getLevelDataListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static IrodoriChessData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessData parseFrom(InputStream input) throws IOException {
            return (IrodoriChessData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriChessData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriChessData parseDelimitedFrom(InputStream input) throws IOException {
            return (IrodoriChessData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static IrodoriChessData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriChessData parseFrom(CodedInputStream input) throws IOException {
            return (IrodoriChessData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriChessData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(IrodoriChessData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessDataOuterClass$IrodoriChessData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements IrodoriChessDataOrBuilder {
            private int bitField0_;
            private boolean isOpen_;
            private List<IrodoriChessLevelDataOuterClass.IrodoriChessLevelData> levelDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<IrodoriChessLevelDataOuterClass.IrodoriChessLevelData, IrodoriChessLevelDataOuterClass.IrodoriChessLevelData.Builder, IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder> levelDataListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return IrodoriChessDataOuterClass.internal_static_IrodoriChessData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return IrodoriChessDataOuterClass.internal_static_IrodoriChessData_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriChessData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (IrodoriChessData.alwaysUseFieldBuilders) {
                    getLevelDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isOpen_ = false;
                if (this.levelDataListBuilder_ == null) {
                    this.levelDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.levelDataListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return IrodoriChessDataOuterClass.internal_static_IrodoriChessData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public IrodoriChessData getDefaultInstanceForType() {
                return IrodoriChessData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriChessData build() {
                IrodoriChessData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriChessData buildPartial() {
                IrodoriChessData result = new IrodoriChessData(this);
                int i = this.bitField0_;
                result.isOpen_ = this.isOpen_;
                if (this.levelDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.levelDataList_ = Collections.unmodifiableList(this.levelDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.levelDataList_ = this.levelDataList_;
                } else {
                    result.levelDataList_ = this.levelDataListBuilder_.build();
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
                if (other instanceof IrodoriChessData) {
                    return mergeFrom((IrodoriChessData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(IrodoriChessData other) {
                if (other == IrodoriChessData.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (this.levelDataListBuilder_ == null) {
                    if (!other.levelDataList_.isEmpty()) {
                        if (this.levelDataList_.isEmpty()) {
                            this.levelDataList_ = other.levelDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureLevelDataListIsMutable();
                            this.levelDataList_.addAll(other.levelDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.levelDataList_.isEmpty()) {
                    if (this.levelDataListBuilder_.isEmpty()) {
                        this.levelDataListBuilder_.dispose();
                        this.levelDataListBuilder_ = null;
                        this.levelDataList_ = other.levelDataList_;
                        this.bitField0_ &= -2;
                        this.levelDataListBuilder_ = IrodoriChessData.alwaysUseFieldBuilders ? getLevelDataListFieldBuilder() : null;
                    } else {
                        this.levelDataListBuilder_.addAllMessages(other.levelDataList_);
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
                IrodoriChessData parsedMessage = null;
                try {
                    try {
                        parsedMessage = IrodoriChessData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (IrodoriChessData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessDataOuterClass.IrodoriChessDataOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            public Builder setIsOpen(boolean value) {
                this.isOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.isOpen_ = false;
                onChanged();
                return this;
            }

            private void ensureLevelDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.levelDataList_ = new ArrayList(this.levelDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessDataOuterClass.IrodoriChessDataOrBuilder
            public List<IrodoriChessLevelDataOuterClass.IrodoriChessLevelData> getLevelDataListList() {
                if (this.levelDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.levelDataList_);
                }
                return this.levelDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessDataOuterClass.IrodoriChessDataOrBuilder
            public int getLevelDataListCount() {
                if (this.levelDataListBuilder_ == null) {
                    return this.levelDataList_.size();
                }
                return this.levelDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessDataOuterClass.IrodoriChessDataOrBuilder
            public IrodoriChessLevelDataOuterClass.IrodoriChessLevelData getLevelDataList(int index) {
                if (this.levelDataListBuilder_ == null) {
                    return this.levelDataList_.get(index);
                }
                return this.levelDataListBuilder_.getMessage(index);
            }

            public Builder setLevelDataList(int index, IrodoriChessLevelDataOuterClass.IrodoriChessLevelData value) {
                if (this.levelDataListBuilder_ != null) {
                    this.levelDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLevelDataListIsMutable();
                    this.levelDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setLevelDataList(int index, IrodoriChessLevelDataOuterClass.IrodoriChessLevelData.Builder builderForValue) {
                if (this.levelDataListBuilder_ == null) {
                    ensureLevelDataListIsMutable();
                    this.levelDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.levelDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addLevelDataList(IrodoriChessLevelDataOuterClass.IrodoriChessLevelData value) {
                if (this.levelDataListBuilder_ != null) {
                    this.levelDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLevelDataListIsMutable();
                    this.levelDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addLevelDataList(int index, IrodoriChessLevelDataOuterClass.IrodoriChessLevelData value) {
                if (this.levelDataListBuilder_ != null) {
                    this.levelDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLevelDataListIsMutable();
                    this.levelDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addLevelDataList(IrodoriChessLevelDataOuterClass.IrodoriChessLevelData.Builder builderForValue) {
                if (this.levelDataListBuilder_ == null) {
                    ensureLevelDataListIsMutable();
                    this.levelDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.levelDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addLevelDataList(int index, IrodoriChessLevelDataOuterClass.IrodoriChessLevelData.Builder builderForValue) {
                if (this.levelDataListBuilder_ == null) {
                    ensureLevelDataListIsMutable();
                    this.levelDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.levelDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllLevelDataList(Iterable<? extends IrodoriChessLevelDataOuterClass.IrodoriChessLevelData> values) {
                if (this.levelDataListBuilder_ == null) {
                    ensureLevelDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.levelDataList_);
                    onChanged();
                } else {
                    this.levelDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearLevelDataList() {
                if (this.levelDataListBuilder_ == null) {
                    this.levelDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.levelDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeLevelDataList(int index) {
                if (this.levelDataListBuilder_ == null) {
                    ensureLevelDataListIsMutable();
                    this.levelDataList_.remove(index);
                    onChanged();
                } else {
                    this.levelDataListBuilder_.remove(index);
                }
                return this;
            }

            public IrodoriChessLevelDataOuterClass.IrodoriChessLevelData.Builder getLevelDataListBuilder(int index) {
                return getLevelDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessDataOuterClass.IrodoriChessDataOrBuilder
            public IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder getLevelDataListOrBuilder(int index) {
                if (this.levelDataListBuilder_ == null) {
                    return this.levelDataList_.get(index);
                }
                return this.levelDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessDataOuterClass.IrodoriChessDataOrBuilder
            public List<? extends IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder> getLevelDataListOrBuilderList() {
                if (this.levelDataListBuilder_ != null) {
                    return this.levelDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.levelDataList_);
            }

            public IrodoriChessLevelDataOuterClass.IrodoriChessLevelData.Builder addLevelDataListBuilder() {
                return getLevelDataListFieldBuilder().addBuilder(IrodoriChessLevelDataOuterClass.IrodoriChessLevelData.getDefaultInstance());
            }

            public IrodoriChessLevelDataOuterClass.IrodoriChessLevelData.Builder addLevelDataListBuilder(int index) {
                return getLevelDataListFieldBuilder().addBuilder(index, IrodoriChessLevelDataOuterClass.IrodoriChessLevelData.getDefaultInstance());
            }

            public List<IrodoriChessLevelDataOuterClass.IrodoriChessLevelData.Builder> getLevelDataListBuilderList() {
                return getLevelDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<IrodoriChessLevelDataOuterClass.IrodoriChessLevelData, IrodoriChessLevelDataOuterClass.IrodoriChessLevelData.Builder, IrodoriChessLevelDataOuterClass.IrodoriChessLevelDataOrBuilder> getLevelDataListFieldBuilder() {
                if (this.levelDataListBuilder_ == null) {
                    this.levelDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.levelDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.levelDataList_ = null;
                }
                return this.levelDataListBuilder_;
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

        public static IrodoriChessData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<IrodoriChessData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<IrodoriChessData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public IrodoriChessData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        IrodoriChessLevelDataOuterClass.getDescriptor();
    }
}
