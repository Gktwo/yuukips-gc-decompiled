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
import emu.grasscutter.net.proto.HomeSeekFurnitureOneRecordOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeSeekFurnitureAllRecordOuterClass.class */
public final class HomeSeekFurnitureAllRecordOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n HomeSeekFurnitureAllRecord.proto\u001a HomeSeekFurnitureOneRecord.proto\"M\n\u001aHomeSeekFurnitureAllRecord\u0012/\n\nrecordList\u0018\u0005 \u0003(\u000b2\u001b.HomeSeekFurnitureOneRecordB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeSeekFurnitureOneRecordOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeSeekFurnitureAllRecord_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeSeekFurnitureAllRecord_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeSeekFurnitureAllRecord_descriptor, new String[]{"RecordList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeSeekFurnitureAllRecordOuterClass$HomeSeekFurnitureAllRecordOrBuilder.class */
    public interface HomeSeekFurnitureAllRecordOrBuilder extends MessageOrBuilder {
        List<HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord> getRecordListList();

        HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord getRecordList(int i);

        int getRecordListCount();

        List<? extends HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder> getRecordListOrBuilderList();

        HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder getRecordListOrBuilder(int i);
    }

    private HomeSeekFurnitureAllRecordOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeSeekFurnitureAllRecordOuterClass$HomeSeekFurnitureAllRecord.class */
    public static final class HomeSeekFurnitureAllRecord extends GeneratedMessageV3 implements HomeSeekFurnitureAllRecordOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RECORDLIST_FIELD_NUMBER = 5;
        private List<HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord> recordList_;
        private byte memoizedIsInitialized;
        private static final HomeSeekFurnitureAllRecord DEFAULT_INSTANCE = new HomeSeekFurnitureAllRecord();
        private static final Parser<HomeSeekFurnitureAllRecord> PARSER = new AbstractParser<HomeSeekFurnitureAllRecord>() { // from class: emu.grasscutter.net.proto.HomeSeekFurnitureAllRecordOuterClass.HomeSeekFurnitureAllRecord.1
            @Override // com.google.protobuf.Parser
            public HomeSeekFurnitureAllRecord parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeSeekFurnitureAllRecord(input, extensionRegistry);
            }
        };

        private HomeSeekFurnitureAllRecord(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeSeekFurnitureAllRecord() {
            this.memoizedIsInitialized = -1;
            this.recordList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeSeekFurnitureAllRecord();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeSeekFurnitureAllRecord(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                        this.recordList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.recordList_.add((HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord) input.readMessage(HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.parser(), extensionRegistry));
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
                    this.recordList_ = Collections.unmodifiableList(this.recordList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeSeekFurnitureAllRecordOuterClass.internal_static_HomeSeekFurnitureAllRecord_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeSeekFurnitureAllRecordOuterClass.internal_static_HomeSeekFurnitureAllRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeSeekFurnitureAllRecord.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeSeekFurnitureAllRecordOuterClass.HomeSeekFurnitureAllRecordOrBuilder
        public List<HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord> getRecordListList() {
            return this.recordList_;
        }

        @Override // emu.grasscutter.net.proto.HomeSeekFurnitureAllRecordOuterClass.HomeSeekFurnitureAllRecordOrBuilder
        public List<? extends HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder> getRecordListOrBuilderList() {
            return this.recordList_;
        }

        @Override // emu.grasscutter.net.proto.HomeSeekFurnitureAllRecordOuterClass.HomeSeekFurnitureAllRecordOrBuilder
        public int getRecordListCount() {
            return this.recordList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeSeekFurnitureAllRecordOuterClass.HomeSeekFurnitureAllRecordOrBuilder
        public HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord getRecordList(int index) {
            return this.recordList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeSeekFurnitureAllRecordOuterClass.HomeSeekFurnitureAllRecordOrBuilder
        public HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder getRecordListOrBuilder(int index) {
            return this.recordList_.get(index);
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
            for (int i = 0; i < this.recordList_.size(); i++) {
                output.writeMessage(5, this.recordList_.get(i));
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
            for (int i = 0; i < this.recordList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.recordList_.get(i));
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
            if (!(obj instanceof HomeSeekFurnitureAllRecord)) {
                return equals(obj);
            }
            HomeSeekFurnitureAllRecord other = (HomeSeekFurnitureAllRecord) obj;
            return getRecordListList().equals(other.getRecordListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getRecordListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getRecordListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeSeekFurnitureAllRecord parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeSeekFurnitureAllRecord parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeSeekFurnitureAllRecord parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeSeekFurnitureAllRecord parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeSeekFurnitureAllRecord parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeSeekFurnitureAllRecord parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeSeekFurnitureAllRecord parseFrom(InputStream input) throws IOException {
            return (HomeSeekFurnitureAllRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeSeekFurnitureAllRecord parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeSeekFurnitureAllRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeSeekFurnitureAllRecord parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeSeekFurnitureAllRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeSeekFurnitureAllRecord parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeSeekFurnitureAllRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeSeekFurnitureAllRecord parseFrom(CodedInputStream input) throws IOException {
            return (HomeSeekFurnitureAllRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeSeekFurnitureAllRecord parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeSeekFurnitureAllRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeSeekFurnitureAllRecord prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeSeekFurnitureAllRecordOuterClass$HomeSeekFurnitureAllRecord$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeSeekFurnitureAllRecordOrBuilder {
            private int bitField0_;
            private List<HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord> recordList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord, HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.Builder, HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder> recordListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeSeekFurnitureAllRecordOuterClass.internal_static_HomeSeekFurnitureAllRecord_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeSeekFurnitureAllRecordOuterClass.internal_static_HomeSeekFurnitureAllRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeSeekFurnitureAllRecord.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeSeekFurnitureAllRecord.alwaysUseFieldBuilders) {
                    getRecordListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.recordListBuilder_ == null) {
                    this.recordList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.recordListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeSeekFurnitureAllRecordOuterClass.internal_static_HomeSeekFurnitureAllRecord_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeSeekFurnitureAllRecord getDefaultInstanceForType() {
                return HomeSeekFurnitureAllRecord.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeSeekFurnitureAllRecord build() {
                HomeSeekFurnitureAllRecord result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeSeekFurnitureAllRecord buildPartial() {
                HomeSeekFurnitureAllRecord result = new HomeSeekFurnitureAllRecord(this);
                int i = this.bitField0_;
                if (this.recordListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.recordList_ = Collections.unmodifiableList(this.recordList_);
                        this.bitField0_ &= -2;
                    }
                    result.recordList_ = this.recordList_;
                } else {
                    result.recordList_ = this.recordListBuilder_.build();
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
                if (other instanceof HomeSeekFurnitureAllRecord) {
                    return mergeFrom((HomeSeekFurnitureAllRecord) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeSeekFurnitureAllRecord other) {
                if (other == HomeSeekFurnitureAllRecord.getDefaultInstance()) {
                    return this;
                }
                if (this.recordListBuilder_ == null) {
                    if (!other.recordList_.isEmpty()) {
                        if (this.recordList_.isEmpty()) {
                            this.recordList_ = other.recordList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureRecordListIsMutable();
                            this.recordList_.addAll(other.recordList_);
                        }
                        onChanged();
                    }
                } else if (!other.recordList_.isEmpty()) {
                    if (this.recordListBuilder_.isEmpty()) {
                        this.recordListBuilder_.dispose();
                        this.recordListBuilder_ = null;
                        this.recordList_ = other.recordList_;
                        this.bitField0_ &= -2;
                        this.recordListBuilder_ = HomeSeekFurnitureAllRecord.alwaysUseFieldBuilders ? getRecordListFieldBuilder() : null;
                    } else {
                        this.recordListBuilder_.addAllMessages(other.recordList_);
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
                HomeSeekFurnitureAllRecord parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeSeekFurnitureAllRecord.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeSeekFurnitureAllRecord) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureRecordListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.recordList_ = new ArrayList(this.recordList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeSeekFurnitureAllRecordOuterClass.HomeSeekFurnitureAllRecordOrBuilder
            public List<HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord> getRecordListList() {
                if (this.recordListBuilder_ == null) {
                    return Collections.unmodifiableList(this.recordList_);
                }
                return this.recordListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeSeekFurnitureAllRecordOuterClass.HomeSeekFurnitureAllRecordOrBuilder
            public int getRecordListCount() {
                if (this.recordListBuilder_ == null) {
                    return this.recordList_.size();
                }
                return this.recordListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeSeekFurnitureAllRecordOuterClass.HomeSeekFurnitureAllRecordOrBuilder
            public HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord getRecordList(int index) {
                if (this.recordListBuilder_ == null) {
                    return this.recordList_.get(index);
                }
                return this.recordListBuilder_.getMessage(index);
            }

            public Builder setRecordList(int index, HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord value) {
                if (this.recordListBuilder_ != null) {
                    this.recordListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRecordListIsMutable();
                    this.recordList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setRecordList(int index, HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.Builder builderForValue) {
                if (this.recordListBuilder_ == null) {
                    ensureRecordListIsMutable();
                    this.recordList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.recordListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addRecordList(HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord value) {
                if (this.recordListBuilder_ != null) {
                    this.recordListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRecordListIsMutable();
                    this.recordList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addRecordList(int index, HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord value) {
                if (this.recordListBuilder_ != null) {
                    this.recordListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRecordListIsMutable();
                    this.recordList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addRecordList(HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.Builder builderForValue) {
                if (this.recordListBuilder_ == null) {
                    ensureRecordListIsMutable();
                    this.recordList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.recordListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addRecordList(int index, HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.Builder builderForValue) {
                if (this.recordListBuilder_ == null) {
                    ensureRecordListIsMutable();
                    this.recordList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.recordListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllRecordList(Iterable<? extends HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord> values) {
                if (this.recordListBuilder_ == null) {
                    ensureRecordListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.recordList_);
                    onChanged();
                } else {
                    this.recordListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearRecordList() {
                if (this.recordListBuilder_ == null) {
                    this.recordList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.recordListBuilder_.clear();
                }
                return this;
            }

            public Builder removeRecordList(int index) {
                if (this.recordListBuilder_ == null) {
                    ensureRecordListIsMutable();
                    this.recordList_.remove(index);
                    onChanged();
                } else {
                    this.recordListBuilder_.remove(index);
                }
                return this;
            }

            public HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.Builder getRecordListBuilder(int index) {
                return getRecordListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeSeekFurnitureAllRecordOuterClass.HomeSeekFurnitureAllRecordOrBuilder
            public HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder getRecordListOrBuilder(int index) {
                if (this.recordListBuilder_ == null) {
                    return this.recordList_.get(index);
                }
                return this.recordListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeSeekFurnitureAllRecordOuterClass.HomeSeekFurnitureAllRecordOrBuilder
            public List<? extends HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder> getRecordListOrBuilderList() {
                if (this.recordListBuilder_ != null) {
                    return this.recordListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.recordList_);
            }

            public HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.Builder addRecordListBuilder() {
                return getRecordListFieldBuilder().addBuilder(HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.getDefaultInstance());
            }

            public HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.Builder addRecordListBuilder(int index) {
                return getRecordListFieldBuilder().addBuilder(index, HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.getDefaultInstance());
            }

            public List<HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.Builder> getRecordListBuilderList() {
                return getRecordListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord, HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.Builder, HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder> getRecordListFieldBuilder() {
                if (this.recordListBuilder_ == null) {
                    this.recordListBuilder_ = new RepeatedFieldBuilderV3<>(this.recordList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.recordList_ = null;
                }
                return this.recordListBuilder_;
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

        public static HomeSeekFurnitureAllRecord getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeSeekFurnitureAllRecord> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeSeekFurnitureAllRecord> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeSeekFurnitureAllRecord getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HomeSeekFurnitureOneRecordOuterClass.getDescriptor();
    }
}
