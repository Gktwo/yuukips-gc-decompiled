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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PhotoInfoOuterClass.class */
public final class PhotoInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fPhotoInfo.proto\u001a\u0012PhotoPosData.proto\"J\n\tPhotoInfo\u0012'\n\u0010photoPosDataList\u0018\r \u0003(\u000b2\r.PhotoPosData\u0012\u0014\n\fleftMonsters\u0018\t \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{PhotoPosDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PhotoInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PhotoInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PhotoInfo_descriptor, new String[]{"PhotoPosDataList", "LeftMonsters"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PhotoInfoOuterClass$PhotoInfoOrBuilder.class */
    public interface PhotoInfoOrBuilder extends MessageOrBuilder {
        List<PhotoPosDataOuterClass.PhotoPosData> getPhotoPosDataListList();

        PhotoPosDataOuterClass.PhotoPosData getPhotoPosDataList(int i);

        int getPhotoPosDataListCount();

        List<? extends PhotoPosDataOuterClass.PhotoPosDataOrBuilder> getPhotoPosDataListOrBuilderList();

        PhotoPosDataOuterClass.PhotoPosDataOrBuilder getPhotoPosDataListOrBuilder(int i);

        boolean getLeftMonsters();
    }

    private PhotoInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PhotoInfoOuterClass$PhotoInfo.class */
    public static final class PhotoInfo extends GeneratedMessageV3 implements PhotoInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PHOTOPOSDATALIST_FIELD_NUMBER = 13;
        private List<PhotoPosDataOuterClass.PhotoPosData> photoPosDataList_;
        public static final int LEFTMONSTERS_FIELD_NUMBER = 9;
        private boolean leftMonsters_;
        private byte memoizedIsInitialized;
        private static final PhotoInfo DEFAULT_INSTANCE = new PhotoInfo();
        private static final Parser<PhotoInfo> PARSER = new AbstractParser<PhotoInfo>() { // from class: emu.grasscutter.net.proto.PhotoInfoOuterClass.PhotoInfo.1
            @Override // com.google.protobuf.Parser
            public PhotoInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PhotoInfo(input, extensionRegistry);
            }
        };

        private PhotoInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PhotoInfo() {
            this.memoizedIsInitialized = -1;
            this.photoPosDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PhotoInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PhotoInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 72:
                                    this.leftMonsters_ = input.readBool();
                                    break;
                                case 106:
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
            return PhotoInfoOuterClass.internal_static_PhotoInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PhotoInfoOuterClass.internal_static_PhotoInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PhotoInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PhotoInfoOuterClass.PhotoInfoOrBuilder
        public List<PhotoPosDataOuterClass.PhotoPosData> getPhotoPosDataListList() {
            return this.photoPosDataList_;
        }

        @Override // emu.grasscutter.net.proto.PhotoInfoOuterClass.PhotoInfoOrBuilder
        public List<? extends PhotoPosDataOuterClass.PhotoPosDataOrBuilder> getPhotoPosDataListOrBuilderList() {
            return this.photoPosDataList_;
        }

        @Override // emu.grasscutter.net.proto.PhotoInfoOuterClass.PhotoInfoOrBuilder
        public int getPhotoPosDataListCount() {
            return this.photoPosDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.PhotoInfoOuterClass.PhotoInfoOrBuilder
        public PhotoPosDataOuterClass.PhotoPosData getPhotoPosDataList(int index) {
            return this.photoPosDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PhotoInfoOuterClass.PhotoInfoOrBuilder
        public PhotoPosDataOuterClass.PhotoPosDataOrBuilder getPhotoPosDataListOrBuilder(int index) {
            return this.photoPosDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PhotoInfoOuterClass.PhotoInfoOrBuilder
        public boolean getLeftMonsters() {
            return this.leftMonsters_;
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
            if (this.leftMonsters_) {
                output.writeBool(9, this.leftMonsters_);
            }
            for (int i = 0; i < this.photoPosDataList_.size(); i++) {
                output.writeMessage(13, this.photoPosDataList_.get(i));
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
            if (this.leftMonsters_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(9, this.leftMonsters_);
            }
            for (int i = 0; i < this.photoPosDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(13, this.photoPosDataList_.get(i));
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
            if (!(obj instanceof PhotoInfo)) {
                return equals(obj);
            }
            PhotoInfo other = (PhotoInfo) obj;
            return getPhotoPosDataListList().equals(other.getPhotoPosDataListList()) && getLeftMonsters() == other.getLeftMonsters() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getPhotoPosDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getPhotoPosDataListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 9)) + Internal.hashBoolean(getLeftMonsters()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PhotoInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PhotoInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PhotoInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PhotoInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PhotoInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PhotoInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PhotoInfo parseFrom(InputStream input) throws IOException {
            return (PhotoInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PhotoInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PhotoInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PhotoInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (PhotoInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PhotoInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PhotoInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PhotoInfo parseFrom(CodedInputStream input) throws IOException {
            return (PhotoInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PhotoInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PhotoInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PhotoInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PhotoInfoOuterClass$PhotoInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PhotoInfoOrBuilder {
            private int bitField0_;
            private List<PhotoPosDataOuterClass.PhotoPosData> photoPosDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<PhotoPosDataOuterClass.PhotoPosData, PhotoPosDataOuterClass.PhotoPosData.Builder, PhotoPosDataOuterClass.PhotoPosDataOrBuilder> photoPosDataListBuilder_;
            private boolean leftMonsters_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PhotoInfoOuterClass.internal_static_PhotoInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PhotoInfoOuterClass.internal_static_PhotoInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PhotoInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PhotoInfo.alwaysUseFieldBuilders) {
                    getPhotoPosDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.photoPosDataListBuilder_ == null) {
                    this.photoPosDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.photoPosDataListBuilder_.clear();
                }
                this.leftMonsters_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PhotoInfoOuterClass.internal_static_PhotoInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PhotoInfo getDefaultInstanceForType() {
                return PhotoInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PhotoInfo build() {
                PhotoInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PhotoInfo buildPartial() {
                PhotoInfo result = new PhotoInfo(this);
                int i = this.bitField0_;
                if (this.photoPosDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.photoPosDataList_ = Collections.unmodifiableList(this.photoPosDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.photoPosDataList_ = this.photoPosDataList_;
                } else {
                    result.photoPosDataList_ = this.photoPosDataListBuilder_.build();
                }
                result.leftMonsters_ = this.leftMonsters_;
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
                if (other instanceof PhotoInfo) {
                    return mergeFrom((PhotoInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PhotoInfo other) {
                if (other == PhotoInfo.getDefaultInstance()) {
                    return this;
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
                        this.photoPosDataListBuilder_ = PhotoInfo.alwaysUseFieldBuilders ? getPhotoPosDataListFieldBuilder() : null;
                    } else {
                        this.photoPosDataListBuilder_.addAllMessages(other.photoPosDataList_);
                    }
                }
                if (other.getLeftMonsters()) {
                    setLeftMonsters(other.getLeftMonsters());
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
                PhotoInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = PhotoInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PhotoInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensurePhotoPosDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.photoPosDataList_ = new ArrayList(this.photoPosDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.PhotoInfoOuterClass.PhotoInfoOrBuilder
            public List<PhotoPosDataOuterClass.PhotoPosData> getPhotoPosDataListList() {
                if (this.photoPosDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.photoPosDataList_);
                }
                return this.photoPosDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.PhotoInfoOuterClass.PhotoInfoOrBuilder
            public int getPhotoPosDataListCount() {
                if (this.photoPosDataListBuilder_ == null) {
                    return this.photoPosDataList_.size();
                }
                return this.photoPosDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.PhotoInfoOuterClass.PhotoInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.PhotoInfoOuterClass.PhotoInfoOrBuilder
            public PhotoPosDataOuterClass.PhotoPosDataOrBuilder getPhotoPosDataListOrBuilder(int index) {
                if (this.photoPosDataListBuilder_ == null) {
                    return this.photoPosDataList_.get(index);
                }
                return this.photoPosDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PhotoInfoOuterClass.PhotoInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.PhotoInfoOuterClass.PhotoInfoOrBuilder
            public boolean getLeftMonsters() {
                return this.leftMonsters_;
            }

            public Builder setLeftMonsters(boolean value) {
                this.leftMonsters_ = value;
                onChanged();
                return this;
            }

            public Builder clearLeftMonsters() {
                this.leftMonsters_ = false;
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

        public static PhotoInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PhotoInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PhotoInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PhotoInfo getDefaultInstanceForType() {
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
