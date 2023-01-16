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
import emu.grasscutter.net.proto.FungusTrainingMonsterPreviewDetailOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusTrainingPoolPreviewDetailOuterClass.class */
public final class FungusTrainingPoolPreviewDetailOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n%FungusTrainingPoolPreviewDetail.proto\u001a(FungusTrainingMonsterPreviewDetail.proto\"|\n\u001fFungusTrainingPoolPreviewDetail\u0012H\n\u001bmonster_preview_detail_list\u0018\n \u0003(\u000b2#.FungusTrainingMonsterPreviewDetail\u0012\u000f\n\u0007pool_id\u0018\b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FungusTrainingMonsterPreviewDetailOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FungusTrainingPoolPreviewDetail_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_FungusTrainingPoolPreviewDetail_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f724x54f4b3fe = new GeneratedMessageV3.FieldAccessorTable(internal_static_FungusTrainingPoolPreviewDetail_descriptor, new String[]{"MonsterPreviewDetailList", "PoolId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusTrainingPoolPreviewDetailOuterClass$FungusTrainingPoolPreviewDetailOrBuilder.class */
    public interface FungusTrainingPoolPreviewDetailOrBuilder extends MessageOrBuilder {
        List<FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail> getMonsterPreviewDetailListList();

        FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail getMonsterPreviewDetailList(int i);

        int getMonsterPreviewDetailListCount();

        List<? extends FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetailOrBuilder> getMonsterPreviewDetailListOrBuilderList();

        FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetailOrBuilder getMonsterPreviewDetailListOrBuilder(int i);

        int getPoolId();
    }

    private FungusTrainingPoolPreviewDetailOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusTrainingPoolPreviewDetailOuterClass$FungusTrainingPoolPreviewDetail.class */
    public static final class FungusTrainingPoolPreviewDetail extends GeneratedMessageV3 implements FungusTrainingPoolPreviewDetailOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MONSTER_PREVIEW_DETAIL_LIST_FIELD_NUMBER = 10;
        private List<FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail> monsterPreviewDetailList_;
        public static final int POOL_ID_FIELD_NUMBER = 8;
        private int poolId_;
        private byte memoizedIsInitialized;
        private static final FungusTrainingPoolPreviewDetail DEFAULT_INSTANCE = new FungusTrainingPoolPreviewDetail();
        private static final Parser<FungusTrainingPoolPreviewDetail> PARSER = new AbstractParser<FungusTrainingPoolPreviewDetail>() { // from class: emu.grasscutter.net.proto.FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail.1
            @Override // com.google.protobuf.Parser
            public FungusTrainingPoolPreviewDetail parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FungusTrainingPoolPreviewDetail(input, extensionRegistry);
            }
        };

        private FungusTrainingPoolPreviewDetail(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FungusTrainingPoolPreviewDetail() {
            this.memoizedIsInitialized = -1;
            this.monsterPreviewDetailList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FungusTrainingPoolPreviewDetail();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FungusTrainingPoolPreviewDetail(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.poolId_ = input.readUInt32();
                                    break;
                                case 82:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.monsterPreviewDetailList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.monsterPreviewDetailList_.add((FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail) input.readMessage(FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail.parser(), extensionRegistry));
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
                    this.monsterPreviewDetailList_ = Collections.unmodifiableList(this.monsterPreviewDetailList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FungusTrainingPoolPreviewDetailOuterClass.internal_static_FungusTrainingPoolPreviewDetail_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FungusTrainingPoolPreviewDetailOuterClass.f724x54f4b3fe.ensureFieldAccessorsInitialized(FungusTrainingPoolPreviewDetail.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetailOrBuilder
        public List<FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail> getMonsterPreviewDetailListList() {
            return this.monsterPreviewDetailList_;
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetailOrBuilder
        public List<? extends FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetailOrBuilder> getMonsterPreviewDetailListOrBuilderList() {
            return this.monsterPreviewDetailList_;
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetailOrBuilder
        public int getMonsterPreviewDetailListCount() {
            return this.monsterPreviewDetailList_.size();
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetailOrBuilder
        public FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail getMonsterPreviewDetailList(int index) {
            return this.monsterPreviewDetailList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetailOrBuilder
        public FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetailOrBuilder getMonsterPreviewDetailListOrBuilder(int index) {
            return this.monsterPreviewDetailList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetailOrBuilder
        public int getPoolId() {
            return this.poolId_;
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
            if (this.poolId_ != 0) {
                output.writeUInt32(8, this.poolId_);
            }
            for (int i = 0; i < this.monsterPreviewDetailList_.size(); i++) {
                output.writeMessage(10, this.monsterPreviewDetailList_.get(i));
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
            if (this.poolId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(8, this.poolId_);
            }
            for (int i = 0; i < this.monsterPreviewDetailList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(10, this.monsterPreviewDetailList_.get(i));
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
            if (!(obj instanceof FungusTrainingPoolPreviewDetail)) {
                return equals(obj);
            }
            FungusTrainingPoolPreviewDetail other = (FungusTrainingPoolPreviewDetail) obj;
            return getMonsterPreviewDetailListList().equals(other.getMonsterPreviewDetailListList()) && getPoolId() == other.getPoolId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getMonsterPreviewDetailListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getMonsterPreviewDetailListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 8)) + getPoolId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FungusTrainingPoolPreviewDetail parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FungusTrainingPoolPreviewDetail parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FungusTrainingPoolPreviewDetail parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FungusTrainingPoolPreviewDetail parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FungusTrainingPoolPreviewDetail parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FungusTrainingPoolPreviewDetail parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FungusTrainingPoolPreviewDetail parseFrom(InputStream input) throws IOException {
            return (FungusTrainingPoolPreviewDetail) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FungusTrainingPoolPreviewDetail parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FungusTrainingPoolPreviewDetail) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FungusTrainingPoolPreviewDetail parseDelimitedFrom(InputStream input) throws IOException {
            return (FungusTrainingPoolPreviewDetail) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FungusTrainingPoolPreviewDetail parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FungusTrainingPoolPreviewDetail) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FungusTrainingPoolPreviewDetail parseFrom(CodedInputStream input) throws IOException {
            return (FungusTrainingPoolPreviewDetail) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FungusTrainingPoolPreviewDetail parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FungusTrainingPoolPreviewDetail) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FungusTrainingPoolPreviewDetail prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusTrainingPoolPreviewDetailOuterClass$FungusTrainingPoolPreviewDetail$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FungusTrainingPoolPreviewDetailOrBuilder {
            private int bitField0_;
            private List<FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail> monsterPreviewDetailList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail, FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail.Builder, FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetailOrBuilder> monsterPreviewDetailListBuilder_;
            private int poolId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FungusTrainingPoolPreviewDetailOuterClass.internal_static_FungusTrainingPoolPreviewDetail_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FungusTrainingPoolPreviewDetailOuterClass.f724x54f4b3fe.ensureFieldAccessorsInitialized(FungusTrainingPoolPreviewDetail.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FungusTrainingPoolPreviewDetail.alwaysUseFieldBuilders) {
                    getMonsterPreviewDetailListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.monsterPreviewDetailListBuilder_ == null) {
                    this.monsterPreviewDetailList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.monsterPreviewDetailListBuilder_.clear();
                }
                this.poolId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FungusTrainingPoolPreviewDetailOuterClass.internal_static_FungusTrainingPoolPreviewDetail_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FungusTrainingPoolPreviewDetail getDefaultInstanceForType() {
                return FungusTrainingPoolPreviewDetail.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FungusTrainingPoolPreviewDetail build() {
                FungusTrainingPoolPreviewDetail result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FungusTrainingPoolPreviewDetail buildPartial() {
                FungusTrainingPoolPreviewDetail result = new FungusTrainingPoolPreviewDetail(this);
                int i = this.bitField0_;
                if (this.monsterPreviewDetailListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.monsterPreviewDetailList_ = Collections.unmodifiableList(this.monsterPreviewDetailList_);
                        this.bitField0_ &= -2;
                    }
                    result.monsterPreviewDetailList_ = this.monsterPreviewDetailList_;
                } else {
                    result.monsterPreviewDetailList_ = this.monsterPreviewDetailListBuilder_.build();
                }
                result.poolId_ = this.poolId_;
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
                if (other instanceof FungusTrainingPoolPreviewDetail) {
                    return mergeFrom((FungusTrainingPoolPreviewDetail) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FungusTrainingPoolPreviewDetail other) {
                if (other == FungusTrainingPoolPreviewDetail.getDefaultInstance()) {
                    return this;
                }
                if (this.monsterPreviewDetailListBuilder_ == null) {
                    if (!other.monsterPreviewDetailList_.isEmpty()) {
                        if (this.monsterPreviewDetailList_.isEmpty()) {
                            this.monsterPreviewDetailList_ = other.monsterPreviewDetailList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureMonsterPreviewDetailListIsMutable();
                            this.monsterPreviewDetailList_.addAll(other.monsterPreviewDetailList_);
                        }
                        onChanged();
                    }
                } else if (!other.monsterPreviewDetailList_.isEmpty()) {
                    if (this.monsterPreviewDetailListBuilder_.isEmpty()) {
                        this.monsterPreviewDetailListBuilder_.dispose();
                        this.monsterPreviewDetailListBuilder_ = null;
                        this.monsterPreviewDetailList_ = other.monsterPreviewDetailList_;
                        this.bitField0_ &= -2;
                        this.monsterPreviewDetailListBuilder_ = FungusTrainingPoolPreviewDetail.alwaysUseFieldBuilders ? getMonsterPreviewDetailListFieldBuilder() : null;
                    } else {
                        this.monsterPreviewDetailListBuilder_.addAllMessages(other.monsterPreviewDetailList_);
                    }
                }
                if (other.getPoolId() != 0) {
                    setPoolId(other.getPoolId());
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
                FungusTrainingPoolPreviewDetail parsedMessage = null;
                try {
                    try {
                        parsedMessage = FungusTrainingPoolPreviewDetail.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FungusTrainingPoolPreviewDetail) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureMonsterPreviewDetailListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.monsterPreviewDetailList_ = new ArrayList(this.monsterPreviewDetailList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetailOrBuilder
            public List<FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail> getMonsterPreviewDetailListList() {
                if (this.monsterPreviewDetailListBuilder_ == null) {
                    return Collections.unmodifiableList(this.monsterPreviewDetailList_);
                }
                return this.monsterPreviewDetailListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetailOrBuilder
            public int getMonsterPreviewDetailListCount() {
                if (this.monsterPreviewDetailListBuilder_ == null) {
                    return this.monsterPreviewDetailList_.size();
                }
                return this.monsterPreviewDetailListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetailOrBuilder
            public FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail getMonsterPreviewDetailList(int index) {
                if (this.monsterPreviewDetailListBuilder_ == null) {
                    return this.monsterPreviewDetailList_.get(index);
                }
                return this.monsterPreviewDetailListBuilder_.getMessage(index);
            }

            public Builder setMonsterPreviewDetailList(int index, FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail value) {
                if (this.monsterPreviewDetailListBuilder_ != null) {
                    this.monsterPreviewDetailListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMonsterPreviewDetailListIsMutable();
                    this.monsterPreviewDetailList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMonsterPreviewDetailList(int index, FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail.Builder builderForValue) {
                if (this.monsterPreviewDetailListBuilder_ == null) {
                    ensureMonsterPreviewDetailListIsMutable();
                    this.monsterPreviewDetailList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.monsterPreviewDetailListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMonsterPreviewDetailList(FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail value) {
                if (this.monsterPreviewDetailListBuilder_ != null) {
                    this.monsterPreviewDetailListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMonsterPreviewDetailListIsMutable();
                    this.monsterPreviewDetailList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMonsterPreviewDetailList(int index, FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail value) {
                if (this.monsterPreviewDetailListBuilder_ != null) {
                    this.monsterPreviewDetailListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMonsterPreviewDetailListIsMutable();
                    this.monsterPreviewDetailList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMonsterPreviewDetailList(FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail.Builder builderForValue) {
                if (this.monsterPreviewDetailListBuilder_ == null) {
                    ensureMonsterPreviewDetailListIsMutable();
                    this.monsterPreviewDetailList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.monsterPreviewDetailListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMonsterPreviewDetailList(int index, FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail.Builder builderForValue) {
                if (this.monsterPreviewDetailListBuilder_ == null) {
                    ensureMonsterPreviewDetailListIsMutable();
                    this.monsterPreviewDetailList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.monsterPreviewDetailListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMonsterPreviewDetailList(Iterable<? extends FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail> values) {
                if (this.monsterPreviewDetailListBuilder_ == null) {
                    ensureMonsterPreviewDetailListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.monsterPreviewDetailList_);
                    onChanged();
                } else {
                    this.monsterPreviewDetailListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMonsterPreviewDetailList() {
                if (this.monsterPreviewDetailListBuilder_ == null) {
                    this.monsterPreviewDetailList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.monsterPreviewDetailListBuilder_.clear();
                }
                return this;
            }

            public Builder removeMonsterPreviewDetailList(int index) {
                if (this.monsterPreviewDetailListBuilder_ == null) {
                    ensureMonsterPreviewDetailListIsMutable();
                    this.monsterPreviewDetailList_.remove(index);
                    onChanged();
                } else {
                    this.monsterPreviewDetailListBuilder_.remove(index);
                }
                return this;
            }

            public FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail.Builder getMonsterPreviewDetailListBuilder(int index) {
                return getMonsterPreviewDetailListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetailOrBuilder
            public FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetailOrBuilder getMonsterPreviewDetailListOrBuilder(int index) {
                if (this.monsterPreviewDetailListBuilder_ == null) {
                    return this.monsterPreviewDetailList_.get(index);
                }
                return this.monsterPreviewDetailListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetailOrBuilder
            public List<? extends FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetailOrBuilder> getMonsterPreviewDetailListOrBuilderList() {
                if (this.monsterPreviewDetailListBuilder_ != null) {
                    return this.monsterPreviewDetailListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.monsterPreviewDetailList_);
            }

            public FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail.Builder addMonsterPreviewDetailListBuilder() {
                return getMonsterPreviewDetailListFieldBuilder().addBuilder(FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail.getDefaultInstance());
            }

            public FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail.Builder addMonsterPreviewDetailListBuilder(int index) {
                return getMonsterPreviewDetailListFieldBuilder().addBuilder(index, FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail.getDefaultInstance());
            }

            public List<FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail.Builder> getMonsterPreviewDetailListBuilderList() {
                return getMonsterPreviewDetailListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail, FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetail.Builder, FungusTrainingMonsterPreviewDetailOuterClass.FungusTrainingMonsterPreviewDetailOrBuilder> getMonsterPreviewDetailListFieldBuilder() {
                if (this.monsterPreviewDetailListBuilder_ == null) {
                    this.monsterPreviewDetailListBuilder_ = new RepeatedFieldBuilderV3<>(this.monsterPreviewDetailList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.monsterPreviewDetailList_ = null;
                }
                return this.monsterPreviewDetailListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetailOrBuilder
            public int getPoolId() {
                return this.poolId_;
            }

            public Builder setPoolId(int value) {
                this.poolId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPoolId() {
                this.poolId_ = 0;
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

        public static FungusTrainingPoolPreviewDetail getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FungusTrainingPoolPreviewDetail> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FungusTrainingPoolPreviewDetail> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FungusTrainingPoolPreviewDetail getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FungusTrainingMonsterPreviewDetailOuterClass.getDescriptor();
    }
}
