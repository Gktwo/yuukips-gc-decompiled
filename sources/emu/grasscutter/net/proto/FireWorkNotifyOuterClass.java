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
import emu.grasscutter.net.proto.FireWorkDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireWorkNotifyOuterClass.class */
public final class FireWorkNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014FireWorkNotify.proto\u001a\u0012FireWorkData.proto\"5\n\u000eFireWorkNotify\u0012#\n\ffireWorkData\u0018\u0001 \u0003(\u000b2\r.FireWorkDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FireWorkDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FireWorkNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FireWorkNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FireWorkNotify_descriptor, new String[]{"FireWorkData"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireWorkNotifyOuterClass$FireWorkNotifyOrBuilder.class */
    public interface FireWorkNotifyOrBuilder extends MessageOrBuilder {
        List<FireWorkDataOuterClass.FireWorkData> getFireWorkDataList();

        FireWorkDataOuterClass.FireWorkData getFireWorkData(int i);

        int getFireWorkDataCount();

        List<? extends FireWorkDataOuterClass.FireWorkDataOrBuilder> getFireWorkDataOrBuilderList();

        FireWorkDataOuterClass.FireWorkDataOrBuilder getFireWorkDataOrBuilder(int i);
    }

    private FireWorkNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireWorkNotifyOuterClass$FireWorkNotify.class */
    public static final class FireWorkNotify extends GeneratedMessageV3 implements FireWorkNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FIREWORKDATA_FIELD_NUMBER = 1;
        private List<FireWorkDataOuterClass.FireWorkData> fireWorkData_;
        private byte memoizedIsInitialized;
        private static final FireWorkNotify DEFAULT_INSTANCE = new FireWorkNotify();
        private static final Parser<FireWorkNotify> PARSER = new AbstractParser<FireWorkNotify>() { // from class: emu.grasscutter.net.proto.FireWorkNotifyOuterClass.FireWorkNotify.1
            @Override // com.google.protobuf.Parser
            public FireWorkNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FireWorkNotify(input, extensionRegistry);
            }
        };

        private FireWorkNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FireWorkNotify() {
            this.memoizedIsInitialized = -1;
            this.fireWorkData_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FireWorkNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FireWorkNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                        this.fireWorkData_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.fireWorkData_.add((FireWorkDataOuterClass.FireWorkData) input.readMessage(FireWorkDataOuterClass.FireWorkData.parser(), extensionRegistry));
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
                    this.fireWorkData_ = Collections.unmodifiableList(this.fireWorkData_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FireWorkNotifyOuterClass.internal_static_FireWorkNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FireWorkNotifyOuterClass.internal_static_FireWorkNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(FireWorkNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FireWorkNotifyOuterClass.FireWorkNotifyOrBuilder
        public List<FireWorkDataOuterClass.FireWorkData> getFireWorkDataList() {
            return this.fireWorkData_;
        }

        @Override // emu.grasscutter.net.proto.FireWorkNotifyOuterClass.FireWorkNotifyOrBuilder
        public List<? extends FireWorkDataOuterClass.FireWorkDataOrBuilder> getFireWorkDataOrBuilderList() {
            return this.fireWorkData_;
        }

        @Override // emu.grasscutter.net.proto.FireWorkNotifyOuterClass.FireWorkNotifyOrBuilder
        public int getFireWorkDataCount() {
            return this.fireWorkData_.size();
        }

        @Override // emu.grasscutter.net.proto.FireWorkNotifyOuterClass.FireWorkNotifyOrBuilder
        public FireWorkDataOuterClass.FireWorkData getFireWorkData(int index) {
            return this.fireWorkData_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FireWorkNotifyOuterClass.FireWorkNotifyOrBuilder
        public FireWorkDataOuterClass.FireWorkDataOrBuilder getFireWorkDataOrBuilder(int index) {
            return this.fireWorkData_.get(index);
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
            for (int i = 0; i < this.fireWorkData_.size(); i++) {
                output.writeMessage(1, this.fireWorkData_.get(i));
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
            for (int i = 0; i < this.fireWorkData_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.fireWorkData_.get(i));
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
            if (!(obj instanceof FireWorkNotify)) {
                return equals(obj);
            }
            FireWorkNotify other = (FireWorkNotify) obj;
            return getFireWorkDataList().equals(other.getFireWorkDataList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getFireWorkDataCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getFireWorkDataList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FireWorkNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FireWorkNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FireWorkNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FireWorkNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FireWorkNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FireWorkNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FireWorkNotify parseFrom(InputStream input) throws IOException {
            return (FireWorkNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FireWorkNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FireWorkNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FireWorkNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (FireWorkNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FireWorkNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FireWorkNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FireWorkNotify parseFrom(CodedInputStream input) throws IOException {
            return (FireWorkNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FireWorkNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FireWorkNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FireWorkNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireWorkNotifyOuterClass$FireWorkNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FireWorkNotifyOrBuilder {
            private int bitField0_;
            private List<FireWorkDataOuterClass.FireWorkData> fireWorkData_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<FireWorkDataOuterClass.FireWorkData, FireWorkDataOuterClass.FireWorkData.Builder, FireWorkDataOuterClass.FireWorkDataOrBuilder> fireWorkDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FireWorkNotifyOuterClass.internal_static_FireWorkNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FireWorkNotifyOuterClass.internal_static_FireWorkNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(FireWorkNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FireWorkNotify.alwaysUseFieldBuilders) {
                    getFireWorkDataFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.fireWorkDataBuilder_ == null) {
                    this.fireWorkData_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.fireWorkDataBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FireWorkNotifyOuterClass.internal_static_FireWorkNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FireWorkNotify getDefaultInstanceForType() {
                return FireWorkNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FireWorkNotify build() {
                FireWorkNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FireWorkNotify buildPartial() {
                FireWorkNotify result = new FireWorkNotify(this);
                int i = this.bitField0_;
                if (this.fireWorkDataBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.fireWorkData_ = Collections.unmodifiableList(this.fireWorkData_);
                        this.bitField0_ &= -2;
                    }
                    result.fireWorkData_ = this.fireWorkData_;
                } else {
                    result.fireWorkData_ = this.fireWorkDataBuilder_.build();
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
                if (other instanceof FireWorkNotify) {
                    return mergeFrom((FireWorkNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FireWorkNotify other) {
                if (other == FireWorkNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.fireWorkDataBuilder_ == null) {
                    if (!other.fireWorkData_.isEmpty()) {
                        if (this.fireWorkData_.isEmpty()) {
                            this.fireWorkData_ = other.fireWorkData_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureFireWorkDataIsMutable();
                            this.fireWorkData_.addAll(other.fireWorkData_);
                        }
                        onChanged();
                    }
                } else if (!other.fireWorkData_.isEmpty()) {
                    if (this.fireWorkDataBuilder_.isEmpty()) {
                        this.fireWorkDataBuilder_.dispose();
                        this.fireWorkDataBuilder_ = null;
                        this.fireWorkData_ = other.fireWorkData_;
                        this.bitField0_ &= -2;
                        this.fireWorkDataBuilder_ = FireWorkNotify.alwaysUseFieldBuilders ? getFireWorkDataFieldBuilder() : null;
                    } else {
                        this.fireWorkDataBuilder_.addAllMessages(other.fireWorkData_);
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
                FireWorkNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = FireWorkNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FireWorkNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureFireWorkDataIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.fireWorkData_ = new ArrayList(this.fireWorkData_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.FireWorkNotifyOuterClass.FireWorkNotifyOrBuilder
            public List<FireWorkDataOuterClass.FireWorkData> getFireWorkDataList() {
                if (this.fireWorkDataBuilder_ == null) {
                    return Collections.unmodifiableList(this.fireWorkData_);
                }
                return this.fireWorkDataBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FireWorkNotifyOuterClass.FireWorkNotifyOrBuilder
            public int getFireWorkDataCount() {
                if (this.fireWorkDataBuilder_ == null) {
                    return this.fireWorkData_.size();
                }
                return this.fireWorkDataBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FireWorkNotifyOuterClass.FireWorkNotifyOrBuilder
            public FireWorkDataOuterClass.FireWorkData getFireWorkData(int index) {
                if (this.fireWorkDataBuilder_ == null) {
                    return this.fireWorkData_.get(index);
                }
                return this.fireWorkDataBuilder_.getMessage(index);
            }

            public Builder setFireWorkData(int index, FireWorkDataOuterClass.FireWorkData value) {
                if (this.fireWorkDataBuilder_ != null) {
                    this.fireWorkDataBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFireWorkDataIsMutable();
                    this.fireWorkData_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setFireWorkData(int index, FireWorkDataOuterClass.FireWorkData.Builder builderForValue) {
                if (this.fireWorkDataBuilder_ == null) {
                    ensureFireWorkDataIsMutable();
                    this.fireWorkData_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.fireWorkDataBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addFireWorkData(FireWorkDataOuterClass.FireWorkData value) {
                if (this.fireWorkDataBuilder_ != null) {
                    this.fireWorkDataBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFireWorkDataIsMutable();
                    this.fireWorkData_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addFireWorkData(int index, FireWorkDataOuterClass.FireWorkData value) {
                if (this.fireWorkDataBuilder_ != null) {
                    this.fireWorkDataBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFireWorkDataIsMutable();
                    this.fireWorkData_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addFireWorkData(FireWorkDataOuterClass.FireWorkData.Builder builderForValue) {
                if (this.fireWorkDataBuilder_ == null) {
                    ensureFireWorkDataIsMutable();
                    this.fireWorkData_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.fireWorkDataBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addFireWorkData(int index, FireWorkDataOuterClass.FireWorkData.Builder builderForValue) {
                if (this.fireWorkDataBuilder_ == null) {
                    ensureFireWorkDataIsMutable();
                    this.fireWorkData_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.fireWorkDataBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllFireWorkData(Iterable<? extends FireWorkDataOuterClass.FireWorkData> values) {
                if (this.fireWorkDataBuilder_ == null) {
                    ensureFireWorkDataIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.fireWorkData_);
                    onChanged();
                } else {
                    this.fireWorkDataBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearFireWorkData() {
                if (this.fireWorkDataBuilder_ == null) {
                    this.fireWorkData_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.fireWorkDataBuilder_.clear();
                }
                return this;
            }

            public Builder removeFireWorkData(int index) {
                if (this.fireWorkDataBuilder_ == null) {
                    ensureFireWorkDataIsMutable();
                    this.fireWorkData_.remove(index);
                    onChanged();
                } else {
                    this.fireWorkDataBuilder_.remove(index);
                }
                return this;
            }

            public FireWorkDataOuterClass.FireWorkData.Builder getFireWorkDataBuilder(int index) {
                return getFireWorkDataFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FireWorkNotifyOuterClass.FireWorkNotifyOrBuilder
            public FireWorkDataOuterClass.FireWorkDataOrBuilder getFireWorkDataOrBuilder(int index) {
                if (this.fireWorkDataBuilder_ == null) {
                    return this.fireWorkData_.get(index);
                }
                return this.fireWorkDataBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FireWorkNotifyOuterClass.FireWorkNotifyOrBuilder
            public List<? extends FireWorkDataOuterClass.FireWorkDataOrBuilder> getFireWorkDataOrBuilderList() {
                if (this.fireWorkDataBuilder_ != null) {
                    return this.fireWorkDataBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.fireWorkData_);
            }

            public FireWorkDataOuterClass.FireWorkData.Builder addFireWorkDataBuilder() {
                return getFireWorkDataFieldBuilder().addBuilder(FireWorkDataOuterClass.FireWorkData.getDefaultInstance());
            }

            public FireWorkDataOuterClass.FireWorkData.Builder addFireWorkDataBuilder(int index) {
                return getFireWorkDataFieldBuilder().addBuilder(index, FireWorkDataOuterClass.FireWorkData.getDefaultInstance());
            }

            public List<FireWorkDataOuterClass.FireWorkData.Builder> getFireWorkDataBuilderList() {
                return getFireWorkDataFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FireWorkDataOuterClass.FireWorkData, FireWorkDataOuterClass.FireWorkData.Builder, FireWorkDataOuterClass.FireWorkDataOrBuilder> getFireWorkDataFieldBuilder() {
                if (this.fireWorkDataBuilder_ == null) {
                    this.fireWorkDataBuilder_ = new RepeatedFieldBuilderV3<>(this.fireWorkData_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.fireWorkData_ = null;
                }
                return this.fireWorkDataBuilder_;
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

        public static FireWorkNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FireWorkNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FireWorkNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FireWorkNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FireWorkDataOuterClass.getDescriptor();
    }
}
