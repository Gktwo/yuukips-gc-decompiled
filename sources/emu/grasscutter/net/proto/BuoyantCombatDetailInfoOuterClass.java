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
import emu.grasscutter.net.proto.BuoyantCombatDailyInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuoyantCombatDetailInfoOuterClass.class */
public final class BuoyantCombatDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dBuoyantCombatDetailInfo.proto\u001a\u001cBuoyantCombatDailyInfo.proto\"K\n\u0017BuoyantCombatDetailInfo\u00120\n\u000fdaily_info_list\u0018\u000b \u0003(\u000b2\u0017.BuoyantCombatDailyInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BuoyantCombatDailyInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BuoyantCombatDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BuoyantCombatDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BuoyantCombatDetailInfo_descriptor, new String[]{"DailyInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuoyantCombatDetailInfoOuterClass$BuoyantCombatDetailInfoOrBuilder.class */
    public interface BuoyantCombatDetailInfoOrBuilder extends MessageOrBuilder {
        List<BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo> getDailyInfoListList();

        BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo getDailyInfoList(int i);

        int getDailyInfoListCount();

        List<? extends BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfoOrBuilder> getDailyInfoListOrBuilderList();

        BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfoOrBuilder getDailyInfoListOrBuilder(int i);
    }

    private BuoyantCombatDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuoyantCombatDetailInfoOuterClass$BuoyantCombatDetailInfo.class */
    public static final class BuoyantCombatDetailInfo extends GeneratedMessageV3 implements BuoyantCombatDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DAILY_INFO_LIST_FIELD_NUMBER = 11;
        private List<BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo> dailyInfoList_;
        private byte memoizedIsInitialized;
        private static final BuoyantCombatDetailInfo DEFAULT_INSTANCE = new BuoyantCombatDetailInfo();
        private static final Parser<BuoyantCombatDetailInfo> PARSER = new AbstractParser<BuoyantCombatDetailInfo>() { // from class: emu.grasscutter.net.proto.BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo.1
            @Override // com.google.protobuf.Parser
            public BuoyantCombatDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BuoyantCombatDetailInfo(input, extensionRegistry);
            }
        };

        private BuoyantCombatDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BuoyantCombatDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.dailyInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BuoyantCombatDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BuoyantCombatDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                        this.dailyInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.dailyInfoList_.add((BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo) input.readMessage(BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo.parser(), extensionRegistry));
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
                    this.dailyInfoList_ = Collections.unmodifiableList(this.dailyInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BuoyantCombatDetailInfoOuterClass.internal_static_BuoyantCombatDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BuoyantCombatDetailInfoOuterClass.internal_static_BuoyantCombatDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BuoyantCombatDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfoOrBuilder
        public List<BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo> getDailyInfoListList() {
            return this.dailyInfoList_;
        }

        @Override // emu.grasscutter.net.proto.BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfoOrBuilder
        public List<? extends BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfoOrBuilder> getDailyInfoListOrBuilderList() {
            return this.dailyInfoList_;
        }

        @Override // emu.grasscutter.net.proto.BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfoOrBuilder
        public int getDailyInfoListCount() {
            return this.dailyInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfoOrBuilder
        public BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo getDailyInfoList(int index) {
            return this.dailyInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfoOrBuilder
        public BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfoOrBuilder getDailyInfoListOrBuilder(int index) {
            return this.dailyInfoList_.get(index);
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
            for (int i = 0; i < this.dailyInfoList_.size(); i++) {
                output.writeMessage(11, this.dailyInfoList_.get(i));
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
            for (int i = 0; i < this.dailyInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.dailyInfoList_.get(i));
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
            if (!(obj instanceof BuoyantCombatDetailInfo)) {
                return equals(obj);
            }
            BuoyantCombatDetailInfo other = (BuoyantCombatDetailInfo) obj;
            return getDailyInfoListList().equals(other.getDailyInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getDailyInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getDailyInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static BuoyantCombatDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BuoyantCombatDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuoyantCombatDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BuoyantCombatDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuoyantCombatDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BuoyantCombatDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuoyantCombatDetailInfo parseFrom(InputStream input) throws IOException {
            return (BuoyantCombatDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BuoyantCombatDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuoyantCombatDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BuoyantCombatDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BuoyantCombatDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BuoyantCombatDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuoyantCombatDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BuoyantCombatDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (BuoyantCombatDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BuoyantCombatDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuoyantCombatDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BuoyantCombatDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuoyantCombatDetailInfoOuterClass$BuoyantCombatDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BuoyantCombatDetailInfoOrBuilder {
            private int bitField0_;
            private List<BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo> dailyInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo, BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo.Builder, BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfoOrBuilder> dailyInfoListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BuoyantCombatDetailInfoOuterClass.internal_static_BuoyantCombatDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BuoyantCombatDetailInfoOuterClass.internal_static_BuoyantCombatDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BuoyantCombatDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BuoyantCombatDetailInfo.alwaysUseFieldBuilders) {
                    getDailyInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.dailyInfoListBuilder_ == null) {
                    this.dailyInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.dailyInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BuoyantCombatDetailInfoOuterClass.internal_static_BuoyantCombatDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BuoyantCombatDetailInfo getDefaultInstanceForType() {
                return BuoyantCombatDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BuoyantCombatDetailInfo build() {
                BuoyantCombatDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BuoyantCombatDetailInfo buildPartial() {
                BuoyantCombatDetailInfo result = new BuoyantCombatDetailInfo(this);
                int i = this.bitField0_;
                if (this.dailyInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.dailyInfoList_ = Collections.unmodifiableList(this.dailyInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.dailyInfoList_ = this.dailyInfoList_;
                } else {
                    result.dailyInfoList_ = this.dailyInfoListBuilder_.build();
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
                if (other instanceof BuoyantCombatDetailInfo) {
                    return mergeFrom((BuoyantCombatDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BuoyantCombatDetailInfo other) {
                if (other == BuoyantCombatDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.dailyInfoListBuilder_ == null) {
                    if (!other.dailyInfoList_.isEmpty()) {
                        if (this.dailyInfoList_.isEmpty()) {
                            this.dailyInfoList_ = other.dailyInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDailyInfoListIsMutable();
                            this.dailyInfoList_.addAll(other.dailyInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.dailyInfoList_.isEmpty()) {
                    if (this.dailyInfoListBuilder_.isEmpty()) {
                        this.dailyInfoListBuilder_.dispose();
                        this.dailyInfoListBuilder_ = null;
                        this.dailyInfoList_ = other.dailyInfoList_;
                        this.bitField0_ &= -2;
                        this.dailyInfoListBuilder_ = BuoyantCombatDetailInfo.alwaysUseFieldBuilders ? getDailyInfoListFieldBuilder() : null;
                    } else {
                        this.dailyInfoListBuilder_.addAllMessages(other.dailyInfoList_);
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
                BuoyantCombatDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BuoyantCombatDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BuoyantCombatDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureDailyInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.dailyInfoList_ = new ArrayList(this.dailyInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfoOrBuilder
            public List<BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo> getDailyInfoListList() {
                if (this.dailyInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.dailyInfoList_);
                }
                return this.dailyInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfoOrBuilder
            public int getDailyInfoListCount() {
                if (this.dailyInfoListBuilder_ == null) {
                    return this.dailyInfoList_.size();
                }
                return this.dailyInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfoOrBuilder
            public BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo getDailyInfoList(int index) {
                if (this.dailyInfoListBuilder_ == null) {
                    return this.dailyInfoList_.get(index);
                }
                return this.dailyInfoListBuilder_.getMessage(index);
            }

            public Builder setDailyInfoList(int index, BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo value) {
                if (this.dailyInfoListBuilder_ != null) {
                    this.dailyInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDailyInfoListIsMutable();
                    this.dailyInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDailyInfoList(int index, BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo.Builder builderForValue) {
                if (this.dailyInfoListBuilder_ == null) {
                    ensureDailyInfoListIsMutable();
                    this.dailyInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dailyInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDailyInfoList(BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo value) {
                if (this.dailyInfoListBuilder_ != null) {
                    this.dailyInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDailyInfoListIsMutable();
                    this.dailyInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDailyInfoList(int index, BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo value) {
                if (this.dailyInfoListBuilder_ != null) {
                    this.dailyInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDailyInfoListIsMutable();
                    this.dailyInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDailyInfoList(BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo.Builder builderForValue) {
                if (this.dailyInfoListBuilder_ == null) {
                    ensureDailyInfoListIsMutable();
                    this.dailyInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dailyInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDailyInfoList(int index, BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo.Builder builderForValue) {
                if (this.dailyInfoListBuilder_ == null) {
                    ensureDailyInfoListIsMutable();
                    this.dailyInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dailyInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDailyInfoList(Iterable<? extends BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo> values) {
                if (this.dailyInfoListBuilder_ == null) {
                    ensureDailyInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.dailyInfoList_);
                    onChanged();
                } else {
                    this.dailyInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDailyInfoList() {
                if (this.dailyInfoListBuilder_ == null) {
                    this.dailyInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.dailyInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeDailyInfoList(int index) {
                if (this.dailyInfoListBuilder_ == null) {
                    ensureDailyInfoListIsMutable();
                    this.dailyInfoList_.remove(index);
                    onChanged();
                } else {
                    this.dailyInfoListBuilder_.remove(index);
                }
                return this;
            }

            public BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo.Builder getDailyInfoListBuilder(int index) {
                return getDailyInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfoOrBuilder
            public BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfoOrBuilder getDailyInfoListOrBuilder(int index) {
                if (this.dailyInfoListBuilder_ == null) {
                    return this.dailyInfoList_.get(index);
                }
                return this.dailyInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfoOrBuilder
            public List<? extends BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfoOrBuilder> getDailyInfoListOrBuilderList() {
                if (this.dailyInfoListBuilder_ != null) {
                    return this.dailyInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.dailyInfoList_);
            }

            public BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo.Builder addDailyInfoListBuilder() {
                return getDailyInfoListFieldBuilder().addBuilder(BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo.getDefaultInstance());
            }

            public BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo.Builder addDailyInfoListBuilder(int index) {
                return getDailyInfoListFieldBuilder().addBuilder(index, BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo.getDefaultInstance());
            }

            public List<BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo.Builder> getDailyInfoListBuilderList() {
                return getDailyInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo, BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfo.Builder, BuoyantCombatDailyInfoOuterClass.BuoyantCombatDailyInfoOrBuilder> getDailyInfoListFieldBuilder() {
                if (this.dailyInfoListBuilder_ == null) {
                    this.dailyInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.dailyInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.dailyInfoList_ = null;
                }
                return this.dailyInfoListBuilder_;
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

        public static BuoyantCombatDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BuoyantCombatDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BuoyantCombatDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BuoyantCombatDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BuoyantCombatDailyInfoOuterClass.getDescriptor();
    }
}
