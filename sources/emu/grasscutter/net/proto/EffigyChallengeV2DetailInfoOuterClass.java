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
import emu.grasscutter.net.proto.EffigyChallengeV2LevelDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyChallengeV2DetailInfoOuterClass.class */
public final class EffigyChallengeV2DetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!EffigyChallengeV2DetailInfo.proto\u001a EffigyChallengeV2LevelData.proto\"S\n\u001bEffigyChallengeV2DetailInfo\u00124\n\u000flevel_data_list\u0018\u0001 \u0003(\u000b2\u001b.EffigyChallengeV2LevelDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{EffigyChallengeV2LevelDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_EffigyChallengeV2DetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EffigyChallengeV2DetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EffigyChallengeV2DetailInfo_descriptor, new String[]{"LevelDataList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyChallengeV2DetailInfoOuterClass$EffigyChallengeV2DetailInfoOrBuilder.class */
    public interface EffigyChallengeV2DetailInfoOrBuilder extends MessageOrBuilder {
        List<EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData> getLevelDataListList();

        EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData getLevelDataList(int i);

        int getLevelDataListCount();

        List<? extends EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelDataOrBuilder> getLevelDataListOrBuilderList();

        EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelDataOrBuilder getLevelDataListOrBuilder(int i);
    }

    private EffigyChallengeV2DetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyChallengeV2DetailInfoOuterClass$EffigyChallengeV2DetailInfo.class */
    public static final class EffigyChallengeV2DetailInfo extends GeneratedMessageV3 implements EffigyChallengeV2DetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LEVEL_DATA_LIST_FIELD_NUMBER = 1;
        private List<EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData> levelDataList_;
        private byte memoizedIsInitialized;
        private static final EffigyChallengeV2DetailInfo DEFAULT_INSTANCE = new EffigyChallengeV2DetailInfo();
        private static final Parser<EffigyChallengeV2DetailInfo> PARSER = new AbstractParser<EffigyChallengeV2DetailInfo>() { // from class: emu.grasscutter.net.proto.EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo.1
            @Override // com.google.protobuf.Parser
            public EffigyChallengeV2DetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EffigyChallengeV2DetailInfo(input, extensionRegistry);
            }
        };

        private EffigyChallengeV2DetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EffigyChallengeV2DetailInfo() {
            this.memoizedIsInitialized = -1;
            this.levelDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EffigyChallengeV2DetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EffigyChallengeV2DetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                        this.levelDataList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.levelDataList_.add((EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData) input.readMessage(EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData.parser(), extensionRegistry));
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
                    this.levelDataList_ = Collections.unmodifiableList(this.levelDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return EffigyChallengeV2DetailInfoOuterClass.internal_static_EffigyChallengeV2DetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EffigyChallengeV2DetailInfoOuterClass.internal_static_EffigyChallengeV2DetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EffigyChallengeV2DetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfoOrBuilder
        public List<EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData> getLevelDataListList() {
            return this.levelDataList_;
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfoOrBuilder
        public List<? extends EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelDataOrBuilder> getLevelDataListOrBuilderList() {
            return this.levelDataList_;
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfoOrBuilder
        public int getLevelDataListCount() {
            return this.levelDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfoOrBuilder
        public EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData getLevelDataList(int index) {
            return this.levelDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfoOrBuilder
        public EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelDataOrBuilder getLevelDataListOrBuilder(int index) {
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
            for (int i = 0; i < this.levelDataList_.size(); i++) {
                output.writeMessage(1, this.levelDataList_.get(i));
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
            for (int i = 0; i < this.levelDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.levelDataList_.get(i));
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
            if (!(obj instanceof EffigyChallengeV2DetailInfo)) {
                return equals(obj);
            }
            EffigyChallengeV2DetailInfo other = (EffigyChallengeV2DetailInfo) obj;
            return getLevelDataListList().equals(other.getLevelDataListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getLevelDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getLevelDataListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static EffigyChallengeV2DetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EffigyChallengeV2DetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffigyChallengeV2DetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EffigyChallengeV2DetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffigyChallengeV2DetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EffigyChallengeV2DetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffigyChallengeV2DetailInfo parseFrom(InputStream input) throws IOException {
            return (EffigyChallengeV2DetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EffigyChallengeV2DetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffigyChallengeV2DetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EffigyChallengeV2DetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (EffigyChallengeV2DetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EffigyChallengeV2DetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffigyChallengeV2DetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EffigyChallengeV2DetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (EffigyChallengeV2DetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EffigyChallengeV2DetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffigyChallengeV2DetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EffigyChallengeV2DetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyChallengeV2DetailInfoOuterClass$EffigyChallengeV2DetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EffigyChallengeV2DetailInfoOrBuilder {
            private int bitField0_;
            private List<EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData> levelDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData, EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData.Builder, EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelDataOrBuilder> levelDataListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EffigyChallengeV2DetailInfoOuterClass.internal_static_EffigyChallengeV2DetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EffigyChallengeV2DetailInfoOuterClass.internal_static_EffigyChallengeV2DetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EffigyChallengeV2DetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EffigyChallengeV2DetailInfo.alwaysUseFieldBuilders) {
                    getLevelDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
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
                return EffigyChallengeV2DetailInfoOuterClass.internal_static_EffigyChallengeV2DetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EffigyChallengeV2DetailInfo getDefaultInstanceForType() {
                return EffigyChallengeV2DetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EffigyChallengeV2DetailInfo build() {
                EffigyChallengeV2DetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EffigyChallengeV2DetailInfo buildPartial() {
                EffigyChallengeV2DetailInfo result = new EffigyChallengeV2DetailInfo(this);
                int i = this.bitField0_;
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
                if (other instanceof EffigyChallengeV2DetailInfo) {
                    return mergeFrom((EffigyChallengeV2DetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EffigyChallengeV2DetailInfo other) {
                if (other == EffigyChallengeV2DetailInfo.getDefaultInstance()) {
                    return this;
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
                        this.levelDataListBuilder_ = EffigyChallengeV2DetailInfo.alwaysUseFieldBuilders ? getLevelDataListFieldBuilder() : null;
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
                EffigyChallengeV2DetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = EffigyChallengeV2DetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EffigyChallengeV2DetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureLevelDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.levelDataList_ = new ArrayList(this.levelDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfoOrBuilder
            public List<EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData> getLevelDataListList() {
                if (this.levelDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.levelDataList_);
                }
                return this.levelDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfoOrBuilder
            public int getLevelDataListCount() {
                if (this.levelDataListBuilder_ == null) {
                    return this.levelDataList_.size();
                }
                return this.levelDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfoOrBuilder
            public EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData getLevelDataList(int index) {
                if (this.levelDataListBuilder_ == null) {
                    return this.levelDataList_.get(index);
                }
                return this.levelDataListBuilder_.getMessage(index);
            }

            public Builder setLevelDataList(int index, EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData value) {
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

            public Builder setLevelDataList(int index, EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData.Builder builderForValue) {
                if (this.levelDataListBuilder_ == null) {
                    ensureLevelDataListIsMutable();
                    this.levelDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.levelDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addLevelDataList(EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData value) {
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

            public Builder addLevelDataList(int index, EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData value) {
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

            public Builder addLevelDataList(EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData.Builder builderForValue) {
                if (this.levelDataListBuilder_ == null) {
                    ensureLevelDataListIsMutable();
                    this.levelDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.levelDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addLevelDataList(int index, EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData.Builder builderForValue) {
                if (this.levelDataListBuilder_ == null) {
                    ensureLevelDataListIsMutable();
                    this.levelDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.levelDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllLevelDataList(Iterable<? extends EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData> values) {
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

            public EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData.Builder getLevelDataListBuilder(int index) {
                return getLevelDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfoOrBuilder
            public EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelDataOrBuilder getLevelDataListOrBuilder(int index) {
                if (this.levelDataListBuilder_ == null) {
                    return this.levelDataList_.get(index);
                }
                return this.levelDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfoOrBuilder
            public List<? extends EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelDataOrBuilder> getLevelDataListOrBuilderList() {
                if (this.levelDataListBuilder_ != null) {
                    return this.levelDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.levelDataList_);
            }

            public EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData.Builder addLevelDataListBuilder() {
                return getLevelDataListFieldBuilder().addBuilder(EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData.getDefaultInstance());
            }

            public EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData.Builder addLevelDataListBuilder(int index) {
                return getLevelDataListFieldBuilder().addBuilder(index, EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData.getDefaultInstance());
            }

            public List<EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData.Builder> getLevelDataListBuilderList() {
                return getLevelDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData, EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData.Builder, EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelDataOrBuilder> getLevelDataListFieldBuilder() {
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

        public static EffigyChallengeV2DetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EffigyChallengeV2DetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EffigyChallengeV2DetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EffigyChallengeV2DetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        EffigyChallengeV2LevelDataOuterClass.getDescriptor();
    }
}
