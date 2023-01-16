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
import emu.grasscutter.net.proto.MistTrialLevelDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MistTrialActivityDetailInfoOuterClass.class */
public final class MistTrialActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!MistTrialActivityDetailInfo.proto\u001a\u0018MistTrialLevelData.proto\"Q\n\u001bMistTrialActivityDetailInfo\u00122\n\u0015trial_level_data_list\u0018\u0001 \u0003(\u000b2\u0013.MistTrialLevelDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MistTrialLevelDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MistTrialActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MistTrialActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MistTrialActivityDetailInfo_descriptor, new String[]{"TrialLevelDataList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MistTrialActivityDetailInfoOuterClass$MistTrialActivityDetailInfoOrBuilder.class */
    public interface MistTrialActivityDetailInfoOrBuilder extends MessageOrBuilder {
        List<MistTrialLevelDataOuterClass.MistTrialLevelData> getTrialLevelDataListList();

        MistTrialLevelDataOuterClass.MistTrialLevelData getTrialLevelDataList(int i);

        int getTrialLevelDataListCount();

        List<? extends MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder> getTrialLevelDataListOrBuilderList();

        MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder getTrialLevelDataListOrBuilder(int i);
    }

    private MistTrialActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MistTrialActivityDetailInfoOuterClass$MistTrialActivityDetailInfo.class */
    public static final class MistTrialActivityDetailInfo extends GeneratedMessageV3 implements MistTrialActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TRIAL_LEVEL_DATA_LIST_FIELD_NUMBER = 1;
        private List<MistTrialLevelDataOuterClass.MistTrialLevelData> trialLevelDataList_;
        private byte memoizedIsInitialized;
        private static final MistTrialActivityDetailInfo DEFAULT_INSTANCE = new MistTrialActivityDetailInfo();
        private static final Parser<MistTrialActivityDetailInfo> PARSER = new AbstractParser<MistTrialActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public MistTrialActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MistTrialActivityDetailInfo(input, extensionRegistry);
            }
        };

        private MistTrialActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MistTrialActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.trialLevelDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MistTrialActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MistTrialActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                        this.trialLevelDataList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.trialLevelDataList_.add((MistTrialLevelDataOuterClass.MistTrialLevelData) input.readMessage(MistTrialLevelDataOuterClass.MistTrialLevelData.parser(), extensionRegistry));
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
                    this.trialLevelDataList_ = Collections.unmodifiableList(this.trialLevelDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MistTrialActivityDetailInfoOuterClass.internal_static_MistTrialActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MistTrialActivityDetailInfoOuterClass.internal_static_MistTrialActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MistTrialActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfoOrBuilder
        public List<MistTrialLevelDataOuterClass.MistTrialLevelData> getTrialLevelDataListList() {
            return this.trialLevelDataList_;
        }

        @Override // emu.grasscutter.net.proto.MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfoOrBuilder
        public List<? extends MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder> getTrialLevelDataListOrBuilderList() {
            return this.trialLevelDataList_;
        }

        @Override // emu.grasscutter.net.proto.MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfoOrBuilder
        public int getTrialLevelDataListCount() {
            return this.trialLevelDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfoOrBuilder
        public MistTrialLevelDataOuterClass.MistTrialLevelData getTrialLevelDataList(int index) {
            return this.trialLevelDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfoOrBuilder
        public MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder getTrialLevelDataListOrBuilder(int index) {
            return this.trialLevelDataList_.get(index);
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
            for (int i = 0; i < this.trialLevelDataList_.size(); i++) {
                output.writeMessage(1, this.trialLevelDataList_.get(i));
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
            for (int i = 0; i < this.trialLevelDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.trialLevelDataList_.get(i));
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
            if (!(obj instanceof MistTrialActivityDetailInfo)) {
                return equals(obj);
            }
            MistTrialActivityDetailInfo other = (MistTrialActivityDetailInfo) obj;
            return getTrialLevelDataListList().equals(other.getTrialLevelDataListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getTrialLevelDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getTrialLevelDataListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MistTrialActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MistTrialActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MistTrialActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MistTrialActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MistTrialActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MistTrialActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MistTrialActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (MistTrialActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MistTrialActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MistTrialActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MistTrialActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (MistTrialActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MistTrialActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MistTrialActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MistTrialActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (MistTrialActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MistTrialActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MistTrialActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MistTrialActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MistTrialActivityDetailInfoOuterClass$MistTrialActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MistTrialActivityDetailInfoOrBuilder {
            private int bitField0_;
            private List<MistTrialLevelDataOuterClass.MistTrialLevelData> trialLevelDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<MistTrialLevelDataOuterClass.MistTrialLevelData, MistTrialLevelDataOuterClass.MistTrialLevelData.Builder, MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder> trialLevelDataListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MistTrialActivityDetailInfoOuterClass.internal_static_MistTrialActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MistTrialActivityDetailInfoOuterClass.internal_static_MistTrialActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MistTrialActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MistTrialActivityDetailInfo.alwaysUseFieldBuilders) {
                    getTrialLevelDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.trialLevelDataListBuilder_ == null) {
                    this.trialLevelDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.trialLevelDataListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MistTrialActivityDetailInfoOuterClass.internal_static_MistTrialActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MistTrialActivityDetailInfo getDefaultInstanceForType() {
                return MistTrialActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MistTrialActivityDetailInfo build() {
                MistTrialActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MistTrialActivityDetailInfo buildPartial() {
                MistTrialActivityDetailInfo result = new MistTrialActivityDetailInfo(this);
                int i = this.bitField0_;
                if (this.trialLevelDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.trialLevelDataList_ = Collections.unmodifiableList(this.trialLevelDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.trialLevelDataList_ = this.trialLevelDataList_;
                } else {
                    result.trialLevelDataList_ = this.trialLevelDataListBuilder_.build();
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
                if (other instanceof MistTrialActivityDetailInfo) {
                    return mergeFrom((MistTrialActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MistTrialActivityDetailInfo other) {
                if (other == MistTrialActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.trialLevelDataListBuilder_ == null) {
                    if (!other.trialLevelDataList_.isEmpty()) {
                        if (this.trialLevelDataList_.isEmpty()) {
                            this.trialLevelDataList_ = other.trialLevelDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureTrialLevelDataListIsMutable();
                            this.trialLevelDataList_.addAll(other.trialLevelDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.trialLevelDataList_.isEmpty()) {
                    if (this.trialLevelDataListBuilder_.isEmpty()) {
                        this.trialLevelDataListBuilder_.dispose();
                        this.trialLevelDataListBuilder_ = null;
                        this.trialLevelDataList_ = other.trialLevelDataList_;
                        this.bitField0_ &= -2;
                        this.trialLevelDataListBuilder_ = MistTrialActivityDetailInfo.alwaysUseFieldBuilders ? getTrialLevelDataListFieldBuilder() : null;
                    } else {
                        this.trialLevelDataListBuilder_.addAllMessages(other.trialLevelDataList_);
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
                MistTrialActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = MistTrialActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MistTrialActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureTrialLevelDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.trialLevelDataList_ = new ArrayList(this.trialLevelDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfoOrBuilder
            public List<MistTrialLevelDataOuterClass.MistTrialLevelData> getTrialLevelDataListList() {
                if (this.trialLevelDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.trialLevelDataList_);
                }
                return this.trialLevelDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfoOrBuilder
            public int getTrialLevelDataListCount() {
                if (this.trialLevelDataListBuilder_ == null) {
                    return this.trialLevelDataList_.size();
                }
                return this.trialLevelDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfoOrBuilder
            public MistTrialLevelDataOuterClass.MistTrialLevelData getTrialLevelDataList(int index) {
                if (this.trialLevelDataListBuilder_ == null) {
                    return this.trialLevelDataList_.get(index);
                }
                return this.trialLevelDataListBuilder_.getMessage(index);
            }

            public Builder setTrialLevelDataList(int index, MistTrialLevelDataOuterClass.MistTrialLevelData value) {
                if (this.trialLevelDataListBuilder_ != null) {
                    this.trialLevelDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTrialLevelDataListIsMutable();
                    this.trialLevelDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTrialLevelDataList(int index, MistTrialLevelDataOuterClass.MistTrialLevelData.Builder builderForValue) {
                if (this.trialLevelDataListBuilder_ == null) {
                    ensureTrialLevelDataListIsMutable();
                    this.trialLevelDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.trialLevelDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTrialLevelDataList(MistTrialLevelDataOuterClass.MistTrialLevelData value) {
                if (this.trialLevelDataListBuilder_ != null) {
                    this.trialLevelDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTrialLevelDataListIsMutable();
                    this.trialLevelDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTrialLevelDataList(int index, MistTrialLevelDataOuterClass.MistTrialLevelData value) {
                if (this.trialLevelDataListBuilder_ != null) {
                    this.trialLevelDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTrialLevelDataListIsMutable();
                    this.trialLevelDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTrialLevelDataList(MistTrialLevelDataOuterClass.MistTrialLevelData.Builder builderForValue) {
                if (this.trialLevelDataListBuilder_ == null) {
                    ensureTrialLevelDataListIsMutable();
                    this.trialLevelDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.trialLevelDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTrialLevelDataList(int index, MistTrialLevelDataOuterClass.MistTrialLevelData.Builder builderForValue) {
                if (this.trialLevelDataListBuilder_ == null) {
                    ensureTrialLevelDataListIsMutable();
                    this.trialLevelDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.trialLevelDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTrialLevelDataList(Iterable<? extends MistTrialLevelDataOuterClass.MistTrialLevelData> values) {
                if (this.trialLevelDataListBuilder_ == null) {
                    ensureTrialLevelDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.trialLevelDataList_);
                    onChanged();
                } else {
                    this.trialLevelDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTrialLevelDataList() {
                if (this.trialLevelDataListBuilder_ == null) {
                    this.trialLevelDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.trialLevelDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTrialLevelDataList(int index) {
                if (this.trialLevelDataListBuilder_ == null) {
                    ensureTrialLevelDataListIsMutable();
                    this.trialLevelDataList_.remove(index);
                    onChanged();
                } else {
                    this.trialLevelDataListBuilder_.remove(index);
                }
                return this;
            }

            public MistTrialLevelDataOuterClass.MistTrialLevelData.Builder getTrialLevelDataListBuilder(int index) {
                return getTrialLevelDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfoOrBuilder
            public MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder getTrialLevelDataListOrBuilder(int index) {
                if (this.trialLevelDataListBuilder_ == null) {
                    return this.trialLevelDataList_.get(index);
                }
                return this.trialLevelDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfoOrBuilder
            public List<? extends MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder> getTrialLevelDataListOrBuilderList() {
                if (this.trialLevelDataListBuilder_ != null) {
                    return this.trialLevelDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.trialLevelDataList_);
            }

            public MistTrialLevelDataOuterClass.MistTrialLevelData.Builder addTrialLevelDataListBuilder() {
                return getTrialLevelDataListFieldBuilder().addBuilder(MistTrialLevelDataOuterClass.MistTrialLevelData.getDefaultInstance());
            }

            public MistTrialLevelDataOuterClass.MistTrialLevelData.Builder addTrialLevelDataListBuilder(int index) {
                return getTrialLevelDataListFieldBuilder().addBuilder(index, MistTrialLevelDataOuterClass.MistTrialLevelData.getDefaultInstance());
            }

            public List<MistTrialLevelDataOuterClass.MistTrialLevelData.Builder> getTrialLevelDataListBuilderList() {
                return getTrialLevelDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<MistTrialLevelDataOuterClass.MistTrialLevelData, MistTrialLevelDataOuterClass.MistTrialLevelData.Builder, MistTrialLevelDataOuterClass.MistTrialLevelDataOrBuilder> getTrialLevelDataListFieldBuilder() {
                if (this.trialLevelDataListBuilder_ == null) {
                    this.trialLevelDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.trialLevelDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.trialLevelDataList_ = null;
                }
                return this.trialLevelDataListBuilder_;
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

        public static MistTrialActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MistTrialActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MistTrialActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MistTrialActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MistTrialLevelDataOuterClass.getDescriptor();
    }
}
