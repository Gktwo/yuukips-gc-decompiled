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
import emu.grasscutter.net.proto.PhotoPosDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PhotoActivityDetailInfoOuterClass.class */
public final class PhotoActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dPhotoActivityDetailInfo.proto\u001a\u0012PhotoPosData.proto\"`\n\u0017PhotoActivityDetailInfo\u0012\u0019\n\u0011is_content_closed\u0018\u0005 \u0001(\b\u0012*\n\u0013photo_pos_data_list\u0018\u000e \u0003(\u000b2\r.PhotoPosDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{PhotoPosDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PhotoActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PhotoActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PhotoActivityDetailInfo_descriptor, new String[]{"IsContentClosed", "PhotoPosDataList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PhotoActivityDetailInfoOuterClass$PhotoActivityDetailInfoOrBuilder.class */
    public interface PhotoActivityDetailInfoOrBuilder extends MessageOrBuilder {
        boolean getIsContentClosed();

        List<PhotoPosDataOuterClass.PhotoPosData> getPhotoPosDataListList();

        PhotoPosDataOuterClass.PhotoPosData getPhotoPosDataList(int i);

        int getPhotoPosDataListCount();

        List<? extends PhotoPosDataOuterClass.PhotoPosDataOrBuilder> getPhotoPosDataListOrBuilderList();

        PhotoPosDataOuterClass.PhotoPosDataOrBuilder getPhotoPosDataListOrBuilder(int i);
    }

    private PhotoActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PhotoActivityDetailInfoOuterClass$PhotoActivityDetailInfo.class */
    public static final class PhotoActivityDetailInfo extends GeneratedMessageV3 implements PhotoActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 5;
        private boolean isContentClosed_;
        public static final int PHOTO_POS_DATA_LIST_FIELD_NUMBER = 14;
        private List<PhotoPosDataOuterClass.PhotoPosData> photoPosDataList_;
        private byte memoizedIsInitialized;
        private static final PhotoActivityDetailInfo DEFAULT_INSTANCE = new PhotoActivityDetailInfo();
        private static final Parser<PhotoActivityDetailInfo> PARSER = new AbstractParser<PhotoActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public PhotoActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PhotoActivityDetailInfo(input, extensionRegistry);
            }
        };

        private PhotoActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PhotoActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.photoPosDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PhotoActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PhotoActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 40:
                                    this.isContentClosed_ = input.readBool();
                                    break;
                                case 114:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.photoPosDataList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.photoPosDataList_.add((PhotoPosDataOuterClass.PhotoPosData) input.readMessage(PhotoPosDataOuterClass.PhotoPosData.parser(), extensionRegistry));
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
                    this.photoPosDataList_ = Collections.unmodifiableList(this.photoPosDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PhotoActivityDetailInfoOuterClass.internal_static_PhotoActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PhotoActivityDetailInfoOuterClass.internal_static_PhotoActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PhotoActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
        }

        @Override // emu.grasscutter.net.proto.PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfoOrBuilder
        public List<PhotoPosDataOuterClass.PhotoPosData> getPhotoPosDataListList() {
            return this.photoPosDataList_;
        }

        @Override // emu.grasscutter.net.proto.PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfoOrBuilder
        public List<? extends PhotoPosDataOuterClass.PhotoPosDataOrBuilder> getPhotoPosDataListOrBuilderList() {
            return this.photoPosDataList_;
        }

        @Override // emu.grasscutter.net.proto.PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfoOrBuilder
        public int getPhotoPosDataListCount() {
            return this.photoPosDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfoOrBuilder
        public PhotoPosDataOuterClass.PhotoPosData getPhotoPosDataList(int index) {
            return this.photoPosDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfoOrBuilder
        public PhotoPosDataOuterClass.PhotoPosDataOrBuilder getPhotoPosDataListOrBuilder(int index) {
            return this.photoPosDataList_.get(index);
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
            if (this.isContentClosed_) {
                output.writeBool(5, this.isContentClosed_);
            }
            for (int i = 0; i < this.photoPosDataList_.size(); i++) {
                output.writeMessage(14, this.photoPosDataList_.get(i));
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
            if (this.isContentClosed_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(5, this.isContentClosed_);
            }
            for (int i = 0; i < this.photoPosDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(14, this.photoPosDataList_.get(i));
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
            if (!(obj instanceof PhotoActivityDetailInfo)) {
                return equals(obj);
            }
            PhotoActivityDetailInfo other = (PhotoActivityDetailInfo) obj;
            return getIsContentClosed() == other.getIsContentClosed() && getPhotoPosDataListList().equals(other.getPhotoPosDataListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + Internal.hashBoolean(getIsContentClosed());
            if (getPhotoPosDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getPhotoPosDataListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PhotoActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PhotoActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PhotoActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PhotoActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PhotoActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PhotoActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PhotoActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (PhotoActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PhotoActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PhotoActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PhotoActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (PhotoActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PhotoActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PhotoActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PhotoActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (PhotoActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PhotoActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PhotoActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PhotoActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PhotoActivityDetailInfoOuterClass$PhotoActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PhotoActivityDetailInfoOrBuilder {
            private int bitField0_;
            private boolean isContentClosed_;
            private List<PhotoPosDataOuterClass.PhotoPosData> photoPosDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<PhotoPosDataOuterClass.PhotoPosData, PhotoPosDataOuterClass.PhotoPosData.Builder, PhotoPosDataOuterClass.PhotoPosDataOrBuilder> photoPosDataListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PhotoActivityDetailInfoOuterClass.internal_static_PhotoActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PhotoActivityDetailInfoOuterClass.internal_static_PhotoActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PhotoActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PhotoActivityDetailInfo.alwaysUseFieldBuilders) {
                    getPhotoPosDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isContentClosed_ = false;
                if (this.photoPosDataListBuilder_ == null) {
                    this.photoPosDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.photoPosDataListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PhotoActivityDetailInfoOuterClass.internal_static_PhotoActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PhotoActivityDetailInfo getDefaultInstanceForType() {
                return PhotoActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PhotoActivityDetailInfo build() {
                PhotoActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PhotoActivityDetailInfo buildPartial() {
                PhotoActivityDetailInfo result = new PhotoActivityDetailInfo(this);
                int i = this.bitField0_;
                result.isContentClosed_ = this.isContentClosed_;
                if (this.photoPosDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.photoPosDataList_ = Collections.unmodifiableList(this.photoPosDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.photoPosDataList_ = this.photoPosDataList_;
                } else {
                    result.photoPosDataList_ = this.photoPosDataListBuilder_.build();
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
                if (other instanceof PhotoActivityDetailInfo) {
                    return mergeFrom((PhotoActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PhotoActivityDetailInfo other) {
                if (other == PhotoActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
                }
                if (this.photoPosDataListBuilder_ == null) {
                    if (!other.photoPosDataList_.isEmpty()) {
                        if (this.photoPosDataList_.isEmpty()) {
                            this.photoPosDataList_ = other.photoPosDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensurePhotoPosDataListIsMutable();
                            this.photoPosDataList_.addAll(other.photoPosDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.photoPosDataList_.isEmpty()) {
                    if (this.photoPosDataListBuilder_.isEmpty()) {
                        this.photoPosDataListBuilder_.dispose();
                        this.photoPosDataListBuilder_ = null;
                        this.photoPosDataList_ = other.photoPosDataList_;
                        this.bitField0_ &= -2;
                        this.photoPosDataListBuilder_ = PhotoActivityDetailInfo.alwaysUseFieldBuilders ? getPhotoPosDataListFieldBuilder() : null;
                    } else {
                        this.photoPosDataListBuilder_.addAllMessages(other.photoPosDataList_);
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
                PhotoActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = PhotoActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PhotoActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfoOrBuilder
            public boolean getIsContentClosed() {
                return this.isContentClosed_;
            }

            public Builder setIsContentClosed(boolean value) {
                this.isContentClosed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsContentClosed() {
                this.isContentClosed_ = false;
                onChanged();
                return this;
            }

            private void ensurePhotoPosDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.photoPosDataList_ = new ArrayList(this.photoPosDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfoOrBuilder
            public List<PhotoPosDataOuterClass.PhotoPosData> getPhotoPosDataListList() {
                if (this.photoPosDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.photoPosDataList_);
                }
                return this.photoPosDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfoOrBuilder
            public int getPhotoPosDataListCount() {
                if (this.photoPosDataListBuilder_ == null) {
                    return this.photoPosDataList_.size();
                }
                return this.photoPosDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfoOrBuilder
            public PhotoPosDataOuterClass.PhotoPosData getPhotoPosDataList(int index) {
                if (this.photoPosDataListBuilder_ == null) {
                    return this.photoPosDataList_.get(index);
                }
                return this.photoPosDataListBuilder_.getMessage(index);
            }

            public Builder setPhotoPosDataList(int index, PhotoPosDataOuterClass.PhotoPosData value) {
                if (this.photoPosDataListBuilder_ != null) {
                    this.photoPosDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePhotoPosDataListIsMutable();
                    this.photoPosDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setPhotoPosDataList(int index, PhotoPosDataOuterClass.PhotoPosData.Builder builderForValue) {
                if (this.photoPosDataListBuilder_ == null) {
                    ensurePhotoPosDataListIsMutable();
                    this.photoPosDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.photoPosDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addPhotoPosDataList(PhotoPosDataOuterClass.PhotoPosData value) {
                if (this.photoPosDataListBuilder_ != null) {
                    this.photoPosDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePhotoPosDataListIsMutable();
                    this.photoPosDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addPhotoPosDataList(int index, PhotoPosDataOuterClass.PhotoPosData value) {
                if (this.photoPosDataListBuilder_ != null) {
                    this.photoPosDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePhotoPosDataListIsMutable();
                    this.photoPosDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addPhotoPosDataList(PhotoPosDataOuterClass.PhotoPosData.Builder builderForValue) {
                if (this.photoPosDataListBuilder_ == null) {
                    ensurePhotoPosDataListIsMutable();
                    this.photoPosDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.photoPosDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addPhotoPosDataList(int index, PhotoPosDataOuterClass.PhotoPosData.Builder builderForValue) {
                if (this.photoPosDataListBuilder_ == null) {
                    ensurePhotoPosDataListIsMutable();
                    this.photoPosDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.photoPosDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllPhotoPosDataList(Iterable<? extends PhotoPosDataOuterClass.PhotoPosData> values) {
                if (this.photoPosDataListBuilder_ == null) {
                    ensurePhotoPosDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.photoPosDataList_);
                    onChanged();
                } else {
                    this.photoPosDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearPhotoPosDataList() {
                if (this.photoPosDataListBuilder_ == null) {
                    this.photoPosDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.photoPosDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removePhotoPosDataList(int index) {
                if (this.photoPosDataListBuilder_ == null) {
                    ensurePhotoPosDataListIsMutable();
                    this.photoPosDataList_.remove(index);
                    onChanged();
                } else {
                    this.photoPosDataListBuilder_.remove(index);
                }
                return this;
            }

            public PhotoPosDataOuterClass.PhotoPosData.Builder getPhotoPosDataListBuilder(int index) {
                return getPhotoPosDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfoOrBuilder
            public PhotoPosDataOuterClass.PhotoPosDataOrBuilder getPhotoPosDataListOrBuilder(int index) {
                if (this.photoPosDataListBuilder_ == null) {
                    return this.photoPosDataList_.get(index);
                }
                return this.photoPosDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfoOrBuilder
            public List<? extends PhotoPosDataOuterClass.PhotoPosDataOrBuilder> getPhotoPosDataListOrBuilderList() {
                if (this.photoPosDataListBuilder_ != null) {
                    return this.photoPosDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.photoPosDataList_);
            }

            public PhotoPosDataOuterClass.PhotoPosData.Builder addPhotoPosDataListBuilder() {
                return getPhotoPosDataListFieldBuilder().addBuilder(PhotoPosDataOuterClass.PhotoPosData.getDefaultInstance());
            }

            public PhotoPosDataOuterClass.PhotoPosData.Builder addPhotoPosDataListBuilder(int index) {
                return getPhotoPosDataListFieldBuilder().addBuilder(index, PhotoPosDataOuterClass.PhotoPosData.getDefaultInstance());
            }

            public List<PhotoPosDataOuterClass.PhotoPosData.Builder> getPhotoPosDataListBuilderList() {
                return getPhotoPosDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<PhotoPosDataOuterClass.PhotoPosData, PhotoPosDataOuterClass.PhotoPosData.Builder, PhotoPosDataOuterClass.PhotoPosDataOrBuilder> getPhotoPosDataListFieldBuilder() {
                if (this.photoPosDataListBuilder_ == null) {
                    this.photoPosDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.photoPosDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.photoPosDataList_ = null;
                }
                return this.photoPosDataListBuilder_;
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

        public static PhotoActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PhotoActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PhotoActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PhotoActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PhotoPosDataOuterClass.getDescriptor();
    }
}
