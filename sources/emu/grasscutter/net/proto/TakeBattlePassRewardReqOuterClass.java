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
import emu.grasscutter.net.proto.BattlePassRewardTakeOptionOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeBattlePassRewardReqOuterClass.class */
public final class TakeBattlePassRewardReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dTakeBattlePassRewardReq.proto\u001a BattlePassRewardTakeOption.proto\"N\n\u0017TakeBattlePassRewardReq\u00123\n\u000etakeOptionList\u0018\u0001 \u0003(\u000b2\u001b.BattlePassRewardTakeOptionB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BattlePassRewardTakeOptionOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TakeBattlePassRewardReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TakeBattlePassRewardReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TakeBattlePassRewardReq_descriptor, new String[]{"TakeOptionList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeBattlePassRewardReqOuterClass$TakeBattlePassRewardReqOrBuilder.class */
    public interface TakeBattlePassRewardReqOrBuilder extends MessageOrBuilder {
        List<BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption> getTakeOptionListList();

        BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption getTakeOptionList(int i);

        int getTakeOptionListCount();

        List<? extends BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder> getTakeOptionListOrBuilderList();

        BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder getTakeOptionListOrBuilder(int i);
    }

    private TakeBattlePassRewardReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeBattlePassRewardReqOuterClass$TakeBattlePassRewardReq.class */
    public static final class TakeBattlePassRewardReq extends GeneratedMessageV3 implements TakeBattlePassRewardReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TAKEOPTIONLIST_FIELD_NUMBER = 1;
        private List<BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption> takeOptionList_;
        private byte memoizedIsInitialized;
        private static final TakeBattlePassRewardReq DEFAULT_INSTANCE = new TakeBattlePassRewardReq();
        private static final Parser<TakeBattlePassRewardReq> PARSER = new AbstractParser<TakeBattlePassRewardReq>() { // from class: emu.grasscutter.net.proto.TakeBattlePassRewardReqOuterClass.TakeBattlePassRewardReq.1
            @Override // com.google.protobuf.Parser
            public TakeBattlePassRewardReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TakeBattlePassRewardReq(input, extensionRegistry);
            }
        };

        private TakeBattlePassRewardReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TakeBattlePassRewardReq() {
            this.memoizedIsInitialized = -1;
            this.takeOptionList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TakeBattlePassRewardReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TakeBattlePassRewardReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                        this.takeOptionList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.takeOptionList_.add((BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption) input.readMessage(BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.parser(), extensionRegistry));
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
                    this.takeOptionList_ = Collections.unmodifiableList(this.takeOptionList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TakeBattlePassRewardReqOuterClass.internal_static_TakeBattlePassRewardReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TakeBattlePassRewardReqOuterClass.internal_static_TakeBattlePassRewardReq_fieldAccessorTable.ensureFieldAccessorsInitialized(TakeBattlePassRewardReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TakeBattlePassRewardReqOuterClass.TakeBattlePassRewardReqOrBuilder
        public List<BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption> getTakeOptionListList() {
            return this.takeOptionList_;
        }

        @Override // emu.grasscutter.net.proto.TakeBattlePassRewardReqOuterClass.TakeBattlePassRewardReqOrBuilder
        public List<? extends BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder> getTakeOptionListOrBuilderList() {
            return this.takeOptionList_;
        }

        @Override // emu.grasscutter.net.proto.TakeBattlePassRewardReqOuterClass.TakeBattlePassRewardReqOrBuilder
        public int getTakeOptionListCount() {
            return this.takeOptionList_.size();
        }

        @Override // emu.grasscutter.net.proto.TakeBattlePassRewardReqOuterClass.TakeBattlePassRewardReqOrBuilder
        public BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption getTakeOptionList(int index) {
            return this.takeOptionList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TakeBattlePassRewardReqOuterClass.TakeBattlePassRewardReqOrBuilder
        public BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder getTakeOptionListOrBuilder(int index) {
            return this.takeOptionList_.get(index);
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
            for (int i = 0; i < this.takeOptionList_.size(); i++) {
                output.writeMessage(1, this.takeOptionList_.get(i));
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
            for (int i = 0; i < this.takeOptionList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.takeOptionList_.get(i));
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
            if (!(obj instanceof TakeBattlePassRewardReq)) {
                return equals(obj);
            }
            TakeBattlePassRewardReq other = (TakeBattlePassRewardReq) obj;
            return getTakeOptionListList().equals(other.getTakeOptionListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getTakeOptionListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getTakeOptionListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TakeBattlePassRewardReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeBattlePassRewardReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeBattlePassRewardReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeBattlePassRewardReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeBattlePassRewardReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeBattlePassRewardReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeBattlePassRewardReq parseFrom(InputStream input) throws IOException {
            return (TakeBattlePassRewardReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeBattlePassRewardReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeBattlePassRewardReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeBattlePassRewardReq parseDelimitedFrom(InputStream input) throws IOException {
            return (TakeBattlePassRewardReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TakeBattlePassRewardReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeBattlePassRewardReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeBattlePassRewardReq parseFrom(CodedInputStream input) throws IOException {
            return (TakeBattlePassRewardReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeBattlePassRewardReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeBattlePassRewardReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TakeBattlePassRewardReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeBattlePassRewardReqOuterClass$TakeBattlePassRewardReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TakeBattlePassRewardReqOrBuilder {
            private int bitField0_;
            private List<BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption> takeOptionList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption, BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.Builder, BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder> takeOptionListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TakeBattlePassRewardReqOuterClass.internal_static_TakeBattlePassRewardReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TakeBattlePassRewardReqOuterClass.internal_static_TakeBattlePassRewardReq_fieldAccessorTable.ensureFieldAccessorsInitialized(TakeBattlePassRewardReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TakeBattlePassRewardReq.alwaysUseFieldBuilders) {
                    getTakeOptionListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.takeOptionListBuilder_ == null) {
                    this.takeOptionList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.takeOptionListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TakeBattlePassRewardReqOuterClass.internal_static_TakeBattlePassRewardReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TakeBattlePassRewardReq getDefaultInstanceForType() {
                return TakeBattlePassRewardReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeBattlePassRewardReq build() {
                TakeBattlePassRewardReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeBattlePassRewardReq buildPartial() {
                TakeBattlePassRewardReq result = new TakeBattlePassRewardReq(this);
                int i = this.bitField0_;
                if (this.takeOptionListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.takeOptionList_ = Collections.unmodifiableList(this.takeOptionList_);
                        this.bitField0_ &= -2;
                    }
                    result.takeOptionList_ = this.takeOptionList_;
                } else {
                    result.takeOptionList_ = this.takeOptionListBuilder_.build();
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
                if (other instanceof TakeBattlePassRewardReq) {
                    return mergeFrom((TakeBattlePassRewardReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TakeBattlePassRewardReq other) {
                if (other == TakeBattlePassRewardReq.getDefaultInstance()) {
                    return this;
                }
                if (this.takeOptionListBuilder_ == null) {
                    if (!other.takeOptionList_.isEmpty()) {
                        if (this.takeOptionList_.isEmpty()) {
                            this.takeOptionList_ = other.takeOptionList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureTakeOptionListIsMutable();
                            this.takeOptionList_.addAll(other.takeOptionList_);
                        }
                        onChanged();
                    }
                } else if (!other.takeOptionList_.isEmpty()) {
                    if (this.takeOptionListBuilder_.isEmpty()) {
                        this.takeOptionListBuilder_.dispose();
                        this.takeOptionListBuilder_ = null;
                        this.takeOptionList_ = other.takeOptionList_;
                        this.bitField0_ &= -2;
                        this.takeOptionListBuilder_ = TakeBattlePassRewardReq.alwaysUseFieldBuilders ? getTakeOptionListFieldBuilder() : null;
                    } else {
                        this.takeOptionListBuilder_.addAllMessages(other.takeOptionList_);
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
                TakeBattlePassRewardReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = TakeBattlePassRewardReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TakeBattlePassRewardReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureTakeOptionListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.takeOptionList_ = new ArrayList(this.takeOptionList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TakeBattlePassRewardReqOuterClass.TakeBattlePassRewardReqOrBuilder
            public List<BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption> getTakeOptionListList() {
                if (this.takeOptionListBuilder_ == null) {
                    return Collections.unmodifiableList(this.takeOptionList_);
                }
                return this.takeOptionListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.TakeBattlePassRewardReqOuterClass.TakeBattlePassRewardReqOrBuilder
            public int getTakeOptionListCount() {
                if (this.takeOptionListBuilder_ == null) {
                    return this.takeOptionList_.size();
                }
                return this.takeOptionListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.TakeBattlePassRewardReqOuterClass.TakeBattlePassRewardReqOrBuilder
            public BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption getTakeOptionList(int index) {
                if (this.takeOptionListBuilder_ == null) {
                    return this.takeOptionList_.get(index);
                }
                return this.takeOptionListBuilder_.getMessage(index);
            }

            public Builder setTakeOptionList(int index, BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption value) {
                if (this.takeOptionListBuilder_ != null) {
                    this.takeOptionListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTakeOptionListIsMutable();
                    this.takeOptionList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTakeOptionList(int index, BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.Builder builderForValue) {
                if (this.takeOptionListBuilder_ == null) {
                    ensureTakeOptionListIsMutable();
                    this.takeOptionList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.takeOptionListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTakeOptionList(BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption value) {
                if (this.takeOptionListBuilder_ != null) {
                    this.takeOptionListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTakeOptionListIsMutable();
                    this.takeOptionList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTakeOptionList(int index, BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption value) {
                if (this.takeOptionListBuilder_ != null) {
                    this.takeOptionListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTakeOptionListIsMutable();
                    this.takeOptionList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTakeOptionList(BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.Builder builderForValue) {
                if (this.takeOptionListBuilder_ == null) {
                    ensureTakeOptionListIsMutable();
                    this.takeOptionList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.takeOptionListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTakeOptionList(int index, BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.Builder builderForValue) {
                if (this.takeOptionListBuilder_ == null) {
                    ensureTakeOptionListIsMutable();
                    this.takeOptionList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.takeOptionListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTakeOptionList(Iterable<? extends BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption> values) {
                if (this.takeOptionListBuilder_ == null) {
                    ensureTakeOptionListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.takeOptionList_);
                    onChanged();
                } else {
                    this.takeOptionListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTakeOptionList() {
                if (this.takeOptionListBuilder_ == null) {
                    this.takeOptionList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.takeOptionListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTakeOptionList(int index) {
                if (this.takeOptionListBuilder_ == null) {
                    ensureTakeOptionListIsMutable();
                    this.takeOptionList_.remove(index);
                    onChanged();
                } else {
                    this.takeOptionListBuilder_.remove(index);
                }
                return this;
            }

            public BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.Builder getTakeOptionListBuilder(int index) {
                return getTakeOptionListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TakeBattlePassRewardReqOuterClass.TakeBattlePassRewardReqOrBuilder
            public BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder getTakeOptionListOrBuilder(int index) {
                if (this.takeOptionListBuilder_ == null) {
                    return this.takeOptionList_.get(index);
                }
                return this.takeOptionListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TakeBattlePassRewardReqOuterClass.TakeBattlePassRewardReqOrBuilder
            public List<? extends BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder> getTakeOptionListOrBuilderList() {
                if (this.takeOptionListBuilder_ != null) {
                    return this.takeOptionListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.takeOptionList_);
            }

            public BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.Builder addTakeOptionListBuilder() {
                return getTakeOptionListFieldBuilder().addBuilder(BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.getDefaultInstance());
            }

            public BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.Builder addTakeOptionListBuilder(int index) {
                return getTakeOptionListFieldBuilder().addBuilder(index, BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.getDefaultInstance());
            }

            public List<BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.Builder> getTakeOptionListBuilderList() {
                return getTakeOptionListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption, BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.Builder, BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder> getTakeOptionListFieldBuilder() {
                if (this.takeOptionListBuilder_ == null) {
                    this.takeOptionListBuilder_ = new RepeatedFieldBuilderV3<>(this.takeOptionList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.takeOptionList_ = null;
                }
                return this.takeOptionListBuilder_;
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

        public static TakeBattlePassRewardReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TakeBattlePassRewardReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TakeBattlePassRewardReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TakeBattlePassRewardReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BattlePassRewardTakeOptionOuterClass.getDescriptor();
    }
}
