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
import emu.grasscutter.net.proto.FireworkSetDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javassist.bytecode.CodeAttribute;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireworkSetNotifyOuterClass.class */
public final class FireworkSetNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017FireworkSetNotify.proto\u001a\u0015FireworkSetData.proto\"A\n\u0011FireworkSetNotify\u0012\f\n\u0004code\u0018\u0001 \u0001(\r\u0012\u001e\n\u0004data\u0018\t \u0003(\u000b2\u0010.FireworkSetDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FireworkSetDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FireworkSetNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FireworkSetNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FireworkSetNotify_descriptor, new String[]{CodeAttribute.tag, "Data"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireworkSetNotifyOuterClass$FireworkSetNotifyOrBuilder.class */
    public interface FireworkSetNotifyOrBuilder extends MessageOrBuilder {
        int getCode();

        List<FireworkSetDataOuterClass.FireworkSetData> getDataList();

        FireworkSetDataOuterClass.FireworkSetData getData(int i);

        int getDataCount();

        List<? extends FireworkSetDataOuterClass.FireworkSetDataOrBuilder> getDataOrBuilderList();

        FireworkSetDataOuterClass.FireworkSetDataOrBuilder getDataOrBuilder(int i);
    }

    private FireworkSetNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireworkSetNotifyOuterClass$FireworkSetNotify.class */
    public static final class FireworkSetNotify extends GeneratedMessageV3 implements FireworkSetNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CODE_FIELD_NUMBER = 1;
        private int code_;
        public static final int DATA_FIELD_NUMBER = 9;
        private List<FireworkSetDataOuterClass.FireworkSetData> data_;
        private byte memoizedIsInitialized;
        private static final FireworkSetNotify DEFAULT_INSTANCE = new FireworkSetNotify();
        private static final Parser<FireworkSetNotify> PARSER = new AbstractParser<FireworkSetNotify>() { // from class: emu.grasscutter.net.proto.FireworkSetNotifyOuterClass.FireworkSetNotify.1
            @Override // com.google.protobuf.Parser
            public FireworkSetNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FireworkSetNotify(input, extensionRegistry);
            }
        };

        private FireworkSetNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FireworkSetNotify() {
            this.memoizedIsInitialized = -1;
            this.data_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FireworkSetNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FireworkSetNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.code_ = input.readUInt32();
                                    break;
                                case 74:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.data_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.data_.add((FireworkSetDataOuterClass.FireworkSetData) input.readMessage(FireworkSetDataOuterClass.FireworkSetData.parser(), extensionRegistry));
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
                    this.data_ = Collections.unmodifiableList(this.data_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FireworkSetNotifyOuterClass.internal_static_FireworkSetNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FireworkSetNotifyOuterClass.internal_static_FireworkSetNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(FireworkSetNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FireworkSetNotifyOuterClass.FireworkSetNotifyOrBuilder
        public int getCode() {
            return this.code_;
        }

        @Override // emu.grasscutter.net.proto.FireworkSetNotifyOuterClass.FireworkSetNotifyOrBuilder
        public List<FireworkSetDataOuterClass.FireworkSetData> getDataList() {
            return this.data_;
        }

        @Override // emu.grasscutter.net.proto.FireworkSetNotifyOuterClass.FireworkSetNotifyOrBuilder
        public List<? extends FireworkSetDataOuterClass.FireworkSetDataOrBuilder> getDataOrBuilderList() {
            return this.data_;
        }

        @Override // emu.grasscutter.net.proto.FireworkSetNotifyOuterClass.FireworkSetNotifyOrBuilder
        public int getDataCount() {
            return this.data_.size();
        }

        @Override // emu.grasscutter.net.proto.FireworkSetNotifyOuterClass.FireworkSetNotifyOrBuilder
        public FireworkSetDataOuterClass.FireworkSetData getData(int index) {
            return this.data_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FireworkSetNotifyOuterClass.FireworkSetNotifyOrBuilder
        public FireworkSetDataOuterClass.FireworkSetDataOrBuilder getDataOrBuilder(int index) {
            return this.data_.get(index);
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
            if (this.code_ != 0) {
                output.writeUInt32(1, this.code_);
            }
            for (int i = 0; i < this.data_.size(); i++) {
                output.writeMessage(9, this.data_.get(i));
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
            if (this.code_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.code_);
            }
            for (int i = 0; i < this.data_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(9, this.data_.get(i));
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
            if (!(obj instanceof FireworkSetNotify)) {
                return equals(obj);
            }
            FireworkSetNotify other = (FireworkSetNotify) obj;
            return getCode() == other.getCode() && getDataList().equals(other.getDataList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getCode();
            if (getDataCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getDataList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FireworkSetNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FireworkSetNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FireworkSetNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FireworkSetNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FireworkSetNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FireworkSetNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FireworkSetNotify parseFrom(InputStream input) throws IOException {
            return (FireworkSetNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FireworkSetNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FireworkSetNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FireworkSetNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (FireworkSetNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FireworkSetNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FireworkSetNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FireworkSetNotify parseFrom(CodedInputStream input) throws IOException {
            return (FireworkSetNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FireworkSetNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FireworkSetNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FireworkSetNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireworkSetNotifyOuterClass$FireworkSetNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FireworkSetNotifyOrBuilder {
            private int bitField0_;
            private int code_;
            private List<FireworkSetDataOuterClass.FireworkSetData> data_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<FireworkSetDataOuterClass.FireworkSetData, FireworkSetDataOuterClass.FireworkSetData.Builder, FireworkSetDataOuterClass.FireworkSetDataOrBuilder> dataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FireworkSetNotifyOuterClass.internal_static_FireworkSetNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FireworkSetNotifyOuterClass.internal_static_FireworkSetNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(FireworkSetNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FireworkSetNotify.alwaysUseFieldBuilders) {
                    getDataFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.code_ = 0;
                if (this.dataBuilder_ == null) {
                    this.data_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.dataBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FireworkSetNotifyOuterClass.internal_static_FireworkSetNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FireworkSetNotify getDefaultInstanceForType() {
                return FireworkSetNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FireworkSetNotify build() {
                FireworkSetNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FireworkSetNotify buildPartial() {
                FireworkSetNotify result = new FireworkSetNotify(this);
                int i = this.bitField0_;
                result.code_ = this.code_;
                if (this.dataBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.data_ = Collections.unmodifiableList(this.data_);
                        this.bitField0_ &= -2;
                    }
                    result.data_ = this.data_;
                } else {
                    result.data_ = this.dataBuilder_.build();
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
                if (other instanceof FireworkSetNotify) {
                    return mergeFrom((FireworkSetNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FireworkSetNotify other) {
                if (other == FireworkSetNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getCode() != 0) {
                    setCode(other.getCode());
                }
                if (this.dataBuilder_ == null) {
                    if (!other.data_.isEmpty()) {
                        if (this.data_.isEmpty()) {
                            this.data_ = other.data_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDataIsMutable();
                            this.data_.addAll(other.data_);
                        }
                        onChanged();
                    }
                } else if (!other.data_.isEmpty()) {
                    if (this.dataBuilder_.isEmpty()) {
                        this.dataBuilder_.dispose();
                        this.dataBuilder_ = null;
                        this.data_ = other.data_;
                        this.bitField0_ &= -2;
                        this.dataBuilder_ = FireworkSetNotify.alwaysUseFieldBuilders ? getDataFieldBuilder() : null;
                    } else {
                        this.dataBuilder_.addAllMessages(other.data_);
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
                FireworkSetNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = FireworkSetNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FireworkSetNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FireworkSetNotifyOuterClass.FireworkSetNotifyOrBuilder
            public int getCode() {
                return this.code_;
            }

            public Builder setCode(int value) {
                this.code_ = value;
                onChanged();
                return this;
            }

            public Builder clearCode() {
                this.code_ = 0;
                onChanged();
                return this;
            }

            private void ensureDataIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.data_ = new ArrayList(this.data_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.FireworkSetNotifyOuterClass.FireworkSetNotifyOrBuilder
            public List<FireworkSetDataOuterClass.FireworkSetData> getDataList() {
                if (this.dataBuilder_ == null) {
                    return Collections.unmodifiableList(this.data_);
                }
                return this.dataBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FireworkSetNotifyOuterClass.FireworkSetNotifyOrBuilder
            public int getDataCount() {
                if (this.dataBuilder_ == null) {
                    return this.data_.size();
                }
                return this.dataBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FireworkSetNotifyOuterClass.FireworkSetNotifyOrBuilder
            public FireworkSetDataOuterClass.FireworkSetData getData(int index) {
                if (this.dataBuilder_ == null) {
                    return this.data_.get(index);
                }
                return this.dataBuilder_.getMessage(index);
            }

            public Builder setData(int index, FireworkSetDataOuterClass.FireworkSetData value) {
                if (this.dataBuilder_ != null) {
                    this.dataBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDataIsMutable();
                    this.data_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setData(int index, FireworkSetDataOuterClass.FireworkSetData.Builder builderForValue) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    this.data_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dataBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addData(FireworkSetDataOuterClass.FireworkSetData value) {
                if (this.dataBuilder_ != null) {
                    this.dataBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDataIsMutable();
                    this.data_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addData(int index, FireworkSetDataOuterClass.FireworkSetData value) {
                if (this.dataBuilder_ != null) {
                    this.dataBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDataIsMutable();
                    this.data_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addData(FireworkSetDataOuterClass.FireworkSetData.Builder builderForValue) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    this.data_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dataBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addData(int index, FireworkSetDataOuterClass.FireworkSetData.Builder builderForValue) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    this.data_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dataBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllData(Iterable<? extends FireworkSetDataOuterClass.FireworkSetData> values) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.data_);
                    onChanged();
                } else {
                    this.dataBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearData() {
                if (this.dataBuilder_ == null) {
                    this.data_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.dataBuilder_.clear();
                }
                return this;
            }

            public Builder removeData(int index) {
                if (this.dataBuilder_ == null) {
                    ensureDataIsMutable();
                    this.data_.remove(index);
                    onChanged();
                } else {
                    this.dataBuilder_.remove(index);
                }
                return this;
            }

            public FireworkSetDataOuterClass.FireworkSetData.Builder getDataBuilder(int index) {
                return getDataFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FireworkSetNotifyOuterClass.FireworkSetNotifyOrBuilder
            public FireworkSetDataOuterClass.FireworkSetDataOrBuilder getDataOrBuilder(int index) {
                if (this.dataBuilder_ == null) {
                    return this.data_.get(index);
                }
                return this.dataBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FireworkSetNotifyOuterClass.FireworkSetNotifyOrBuilder
            public List<? extends FireworkSetDataOuterClass.FireworkSetDataOrBuilder> getDataOrBuilderList() {
                if (this.dataBuilder_ != null) {
                    return this.dataBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.data_);
            }

            public FireworkSetDataOuterClass.FireworkSetData.Builder addDataBuilder() {
                return getDataFieldBuilder().addBuilder(FireworkSetDataOuterClass.FireworkSetData.getDefaultInstance());
            }

            public FireworkSetDataOuterClass.FireworkSetData.Builder addDataBuilder(int index) {
                return getDataFieldBuilder().addBuilder(index, FireworkSetDataOuterClass.FireworkSetData.getDefaultInstance());
            }

            public List<FireworkSetDataOuterClass.FireworkSetData.Builder> getDataBuilderList() {
                return getDataFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FireworkSetDataOuterClass.FireworkSetData, FireworkSetDataOuterClass.FireworkSetData.Builder, FireworkSetDataOuterClass.FireworkSetDataOrBuilder> getDataFieldBuilder() {
                if (this.dataBuilder_ == null) {
                    this.dataBuilder_ = new RepeatedFieldBuilderV3<>(this.data_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.data_ = null;
                }
                return this.dataBuilder_;
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

        public static FireworkSetNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FireworkSetNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FireworkSetNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FireworkSetNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FireworkSetDataOuterClass.getDescriptor();
    }
}
