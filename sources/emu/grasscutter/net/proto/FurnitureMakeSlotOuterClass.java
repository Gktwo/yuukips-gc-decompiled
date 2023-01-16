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
import emu.grasscutter.net.proto.FurnitureMakeDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeSlotOuterClass.class */
public final class FurnitureMakeSlotOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017FurnitureMakeSlot.proto\u001a\u0017FurnitureMakeData.proto\"I\n\u0011FurnitureMakeSlot\u00124\n\u0018furniture_make_data_list\u0018\u0001 \u0003(\u000b2\u0012.FurnitureMakeDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FurnitureMakeDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FurnitureMakeSlot_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FurnitureMakeSlot_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FurnitureMakeSlot_descriptor, new String[]{"FurnitureMakeDataList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeSlotOuterClass$FurnitureMakeSlotOrBuilder.class */
    public interface FurnitureMakeSlotOrBuilder extends MessageOrBuilder {
        List<FurnitureMakeDataOuterClass.FurnitureMakeData> getFurnitureMakeDataListList();

        FurnitureMakeDataOuterClass.FurnitureMakeData getFurnitureMakeDataList(int i);

        int getFurnitureMakeDataListCount();

        List<? extends FurnitureMakeDataOuterClass.FurnitureMakeDataOrBuilder> getFurnitureMakeDataListOrBuilderList();

        FurnitureMakeDataOuterClass.FurnitureMakeDataOrBuilder getFurnitureMakeDataListOrBuilder(int i);
    }

    private FurnitureMakeSlotOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeSlotOuterClass$FurnitureMakeSlot.class */
    public static final class FurnitureMakeSlot extends GeneratedMessageV3 implements FurnitureMakeSlotOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FURNITURE_MAKE_DATA_LIST_FIELD_NUMBER = 1;
        private List<FurnitureMakeDataOuterClass.FurnitureMakeData> furnitureMakeDataList_;
        private byte memoizedIsInitialized;
        private static final FurnitureMakeSlot DEFAULT_INSTANCE = new FurnitureMakeSlot();
        private static final Parser<FurnitureMakeSlot> PARSER = new AbstractParser<FurnitureMakeSlot>() { // from class: emu.grasscutter.net.proto.FurnitureMakeSlotOuterClass.FurnitureMakeSlot.1
            @Override // com.google.protobuf.Parser
            public FurnitureMakeSlot parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FurnitureMakeSlot(input, extensionRegistry);
            }
        };

        private FurnitureMakeSlot(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FurnitureMakeSlot() {
            this.memoizedIsInitialized = -1;
            this.furnitureMakeDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FurnitureMakeSlot();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FurnitureMakeSlot(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                        this.furnitureMakeDataList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.furnitureMakeDataList_.add((FurnitureMakeDataOuterClass.FurnitureMakeData) input.readMessage(FurnitureMakeDataOuterClass.FurnitureMakeData.parser(), extensionRegistry));
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
                    this.furnitureMakeDataList_ = Collections.unmodifiableList(this.furnitureMakeDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FurnitureMakeSlotOuterClass.internal_static_FurnitureMakeSlot_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FurnitureMakeSlotOuterClass.internal_static_FurnitureMakeSlot_fieldAccessorTable.ensureFieldAccessorsInitialized(FurnitureMakeSlot.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder
        public List<FurnitureMakeDataOuterClass.FurnitureMakeData> getFurnitureMakeDataListList() {
            return this.furnitureMakeDataList_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder
        public List<? extends FurnitureMakeDataOuterClass.FurnitureMakeDataOrBuilder> getFurnitureMakeDataListOrBuilderList() {
            return this.furnitureMakeDataList_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder
        public int getFurnitureMakeDataListCount() {
            return this.furnitureMakeDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder
        public FurnitureMakeDataOuterClass.FurnitureMakeData getFurnitureMakeDataList(int index) {
            return this.furnitureMakeDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder
        public FurnitureMakeDataOuterClass.FurnitureMakeDataOrBuilder getFurnitureMakeDataListOrBuilder(int index) {
            return this.furnitureMakeDataList_.get(index);
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
            for (int i = 0; i < this.furnitureMakeDataList_.size(); i++) {
                output.writeMessage(1, this.furnitureMakeDataList_.get(i));
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
            for (int i = 0; i < this.furnitureMakeDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.furnitureMakeDataList_.get(i));
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
            if (!(obj instanceof FurnitureMakeSlot)) {
                return equals(obj);
            }
            FurnitureMakeSlot other = (FurnitureMakeSlot) obj;
            return getFurnitureMakeDataListList().equals(other.getFurnitureMakeDataListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getFurnitureMakeDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getFurnitureMakeDataListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FurnitureMakeSlot parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeSlot parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeSlot parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeSlot parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeSlot parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeSlot parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeSlot parseFrom(InputStream input) throws IOException {
            return (FurnitureMakeSlot) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FurnitureMakeSlot parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeSlot) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FurnitureMakeSlot parseDelimitedFrom(InputStream input) throws IOException {
            return (FurnitureMakeSlot) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FurnitureMakeSlot parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeSlot) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FurnitureMakeSlot parseFrom(CodedInputStream input) throws IOException {
            return (FurnitureMakeSlot) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FurnitureMakeSlot parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeSlot) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FurnitureMakeSlot prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeSlotOuterClass$FurnitureMakeSlot$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FurnitureMakeSlotOrBuilder {
            private int bitField0_;
            private List<FurnitureMakeDataOuterClass.FurnitureMakeData> furnitureMakeDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<FurnitureMakeDataOuterClass.FurnitureMakeData, FurnitureMakeDataOuterClass.FurnitureMakeData.Builder, FurnitureMakeDataOuterClass.FurnitureMakeDataOrBuilder> furnitureMakeDataListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FurnitureMakeSlotOuterClass.internal_static_FurnitureMakeSlot_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FurnitureMakeSlotOuterClass.internal_static_FurnitureMakeSlot_fieldAccessorTable.ensureFieldAccessorsInitialized(FurnitureMakeSlot.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FurnitureMakeSlot.alwaysUseFieldBuilders) {
                    getFurnitureMakeDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.furnitureMakeDataListBuilder_ == null) {
                    this.furnitureMakeDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.furnitureMakeDataListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FurnitureMakeSlotOuterClass.internal_static_FurnitureMakeSlot_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FurnitureMakeSlot getDefaultInstanceForType() {
                return FurnitureMakeSlot.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FurnitureMakeSlot build() {
                FurnitureMakeSlot result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FurnitureMakeSlot buildPartial() {
                FurnitureMakeSlot result = new FurnitureMakeSlot(this);
                int i = this.bitField0_;
                if (this.furnitureMakeDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.furnitureMakeDataList_ = Collections.unmodifiableList(this.furnitureMakeDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.furnitureMakeDataList_ = this.furnitureMakeDataList_;
                } else {
                    result.furnitureMakeDataList_ = this.furnitureMakeDataListBuilder_.build();
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
                if (other instanceof FurnitureMakeSlot) {
                    return mergeFrom((FurnitureMakeSlot) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FurnitureMakeSlot other) {
                if (other == FurnitureMakeSlot.getDefaultInstance()) {
                    return this;
                }
                if (this.furnitureMakeDataListBuilder_ == null) {
                    if (!other.furnitureMakeDataList_.isEmpty()) {
                        if (this.furnitureMakeDataList_.isEmpty()) {
                            this.furnitureMakeDataList_ = other.furnitureMakeDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureFurnitureMakeDataListIsMutable();
                            this.furnitureMakeDataList_.addAll(other.furnitureMakeDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.furnitureMakeDataList_.isEmpty()) {
                    if (this.furnitureMakeDataListBuilder_.isEmpty()) {
                        this.furnitureMakeDataListBuilder_.dispose();
                        this.furnitureMakeDataListBuilder_ = null;
                        this.furnitureMakeDataList_ = other.furnitureMakeDataList_;
                        this.bitField0_ &= -2;
                        this.furnitureMakeDataListBuilder_ = FurnitureMakeSlot.alwaysUseFieldBuilders ? getFurnitureMakeDataListFieldBuilder() : null;
                    } else {
                        this.furnitureMakeDataListBuilder_.addAllMessages(other.furnitureMakeDataList_);
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
                FurnitureMakeSlot parsedMessage = null;
                try {
                    try {
                        parsedMessage = FurnitureMakeSlot.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FurnitureMakeSlot) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureFurnitureMakeDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.furnitureMakeDataList_ = new ArrayList(this.furnitureMakeDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder
            public List<FurnitureMakeDataOuterClass.FurnitureMakeData> getFurnitureMakeDataListList() {
                if (this.furnitureMakeDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.furnitureMakeDataList_);
                }
                return this.furnitureMakeDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder
            public int getFurnitureMakeDataListCount() {
                if (this.furnitureMakeDataListBuilder_ == null) {
                    return this.furnitureMakeDataList_.size();
                }
                return this.furnitureMakeDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder
            public FurnitureMakeDataOuterClass.FurnitureMakeData getFurnitureMakeDataList(int index) {
                if (this.furnitureMakeDataListBuilder_ == null) {
                    return this.furnitureMakeDataList_.get(index);
                }
                return this.furnitureMakeDataListBuilder_.getMessage(index);
            }

            public Builder setFurnitureMakeDataList(int index, FurnitureMakeDataOuterClass.FurnitureMakeData value) {
                if (this.furnitureMakeDataListBuilder_ != null) {
                    this.furnitureMakeDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFurnitureMakeDataListIsMutable();
                    this.furnitureMakeDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setFurnitureMakeDataList(int index, FurnitureMakeDataOuterClass.FurnitureMakeData.Builder builderForValue) {
                if (this.furnitureMakeDataListBuilder_ == null) {
                    ensureFurnitureMakeDataListIsMutable();
                    this.furnitureMakeDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.furnitureMakeDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addFurnitureMakeDataList(FurnitureMakeDataOuterClass.FurnitureMakeData value) {
                if (this.furnitureMakeDataListBuilder_ != null) {
                    this.furnitureMakeDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFurnitureMakeDataListIsMutable();
                    this.furnitureMakeDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addFurnitureMakeDataList(int index, FurnitureMakeDataOuterClass.FurnitureMakeData value) {
                if (this.furnitureMakeDataListBuilder_ != null) {
                    this.furnitureMakeDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFurnitureMakeDataListIsMutable();
                    this.furnitureMakeDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addFurnitureMakeDataList(FurnitureMakeDataOuterClass.FurnitureMakeData.Builder builderForValue) {
                if (this.furnitureMakeDataListBuilder_ == null) {
                    ensureFurnitureMakeDataListIsMutable();
                    this.furnitureMakeDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.furnitureMakeDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addFurnitureMakeDataList(int index, FurnitureMakeDataOuterClass.FurnitureMakeData.Builder builderForValue) {
                if (this.furnitureMakeDataListBuilder_ == null) {
                    ensureFurnitureMakeDataListIsMutable();
                    this.furnitureMakeDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.furnitureMakeDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllFurnitureMakeDataList(Iterable<? extends FurnitureMakeDataOuterClass.FurnitureMakeData> values) {
                if (this.furnitureMakeDataListBuilder_ == null) {
                    ensureFurnitureMakeDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.furnitureMakeDataList_);
                    onChanged();
                } else {
                    this.furnitureMakeDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearFurnitureMakeDataList() {
                if (this.furnitureMakeDataListBuilder_ == null) {
                    this.furnitureMakeDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.furnitureMakeDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeFurnitureMakeDataList(int index) {
                if (this.furnitureMakeDataListBuilder_ == null) {
                    ensureFurnitureMakeDataListIsMutable();
                    this.furnitureMakeDataList_.remove(index);
                    onChanged();
                } else {
                    this.furnitureMakeDataListBuilder_.remove(index);
                }
                return this;
            }

            public FurnitureMakeDataOuterClass.FurnitureMakeData.Builder getFurnitureMakeDataListBuilder(int index) {
                return getFurnitureMakeDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder
            public FurnitureMakeDataOuterClass.FurnitureMakeDataOrBuilder getFurnitureMakeDataListOrBuilder(int index) {
                if (this.furnitureMakeDataListBuilder_ == null) {
                    return this.furnitureMakeDataList_.get(index);
                }
                return this.furnitureMakeDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder
            public List<? extends FurnitureMakeDataOuterClass.FurnitureMakeDataOrBuilder> getFurnitureMakeDataListOrBuilderList() {
                if (this.furnitureMakeDataListBuilder_ != null) {
                    return this.furnitureMakeDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.furnitureMakeDataList_);
            }

            public FurnitureMakeDataOuterClass.FurnitureMakeData.Builder addFurnitureMakeDataListBuilder() {
                return getFurnitureMakeDataListFieldBuilder().addBuilder(FurnitureMakeDataOuterClass.FurnitureMakeData.getDefaultInstance());
            }

            public FurnitureMakeDataOuterClass.FurnitureMakeData.Builder addFurnitureMakeDataListBuilder(int index) {
                return getFurnitureMakeDataListFieldBuilder().addBuilder(index, FurnitureMakeDataOuterClass.FurnitureMakeData.getDefaultInstance());
            }

            public List<FurnitureMakeDataOuterClass.FurnitureMakeData.Builder> getFurnitureMakeDataListBuilderList() {
                return getFurnitureMakeDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FurnitureMakeDataOuterClass.FurnitureMakeData, FurnitureMakeDataOuterClass.FurnitureMakeData.Builder, FurnitureMakeDataOuterClass.FurnitureMakeDataOrBuilder> getFurnitureMakeDataListFieldBuilder() {
                if (this.furnitureMakeDataListBuilder_ == null) {
                    this.furnitureMakeDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.furnitureMakeDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.furnitureMakeDataList_ = null;
                }
                return this.furnitureMakeDataListBuilder_;
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

        public static FurnitureMakeSlot getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FurnitureMakeSlot> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FurnitureMakeSlot> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FurnitureMakeSlot getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FurnitureMakeDataOuterClass.getDescriptor();
    }
}
