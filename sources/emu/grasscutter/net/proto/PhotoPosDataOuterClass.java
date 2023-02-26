package emu.grasscutter.net.proto;

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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PhotoPosDataOuterClass.class */
public final class PhotoPosDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012PhotoPosData.proto\u001a\fVector.proto\"h\n\fPhotoPosData\u0012\u000e\n\u0006isOpen\u0018\u0002 \u0001(\b\u0012\u000e\n\u0006isView\u0018\t \u0001(\b\u0012\r\n\u0005posId\u0018\n \u0001(\r\u0012\u0010\n\bopenTime\u0018\u0001 \u0001(\r\u0012\u0017\n\u0006center\u0018\u0003 \u0001(\u000b2\u0007.VectorB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PhotoPosData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PhotoPosData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PhotoPosData_descriptor, new String[]{"IsOpen", "IsView", "PosId", "OpenTime", "Center"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PhotoPosDataOuterClass$PhotoPosDataOrBuilder.class */
    public interface PhotoPosDataOrBuilder extends MessageOrBuilder {
        boolean getIsOpen();

        boolean getIsView();

        int getPosId();

        int getOpenTime();

        boolean hasCenter();

        VectorOuterClass.Vector getCenter();

        VectorOuterClass.VectorOrBuilder getCenterOrBuilder();
    }

    private PhotoPosDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PhotoPosDataOuterClass$PhotoPosData.class */
    public static final class PhotoPosData extends GeneratedMessageV3 implements PhotoPosDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISOPEN_FIELD_NUMBER = 2;
        private boolean isOpen_;
        public static final int ISVIEW_FIELD_NUMBER = 9;
        private boolean isView_;
        public static final int POSID_FIELD_NUMBER = 10;
        private int posId_;
        public static final int OPENTIME_FIELD_NUMBER = 1;
        private int openTime_;
        public static final int CENTER_FIELD_NUMBER = 3;
        private VectorOuterClass.Vector center_;
        private byte memoizedIsInitialized;
        private static final PhotoPosData DEFAULT_INSTANCE = new PhotoPosData();
        private static final Parser<PhotoPosData> PARSER = new AbstractParser<PhotoPosData>() { // from class: emu.grasscutter.net.proto.PhotoPosDataOuterClass.PhotoPosData.1
            @Override // com.google.protobuf.Parser
            public PhotoPosData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PhotoPosData(input, extensionRegistry);
            }
        };

        private PhotoPosData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PhotoPosData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PhotoPosData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PhotoPosData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 8:
                                this.openTime_ = input.readUInt32();
                                break;
                            case 16:
                                this.isOpen_ = input.readBool();
                                break;
                            case 26:
                                VectorOuterClass.Vector.Builder subBuilder = this.center_ != null ? this.center_.toBuilder() : null;
                                this.center_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.center_);
                                    this.center_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 72:
                                this.isView_ = input.readBool();
                                break;
                            case 80:
                                this.posId_ = input.readUInt32();
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
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PhotoPosDataOuterClass.internal_static_PhotoPosData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PhotoPosDataOuterClass.internal_static_PhotoPosData_fieldAccessorTable.ensureFieldAccessorsInitialized(PhotoPosData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PhotoPosDataOuterClass.PhotoPosDataOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.PhotoPosDataOuterClass.PhotoPosDataOrBuilder
        public boolean getIsView() {
            return this.isView_;
        }

        @Override // emu.grasscutter.net.proto.PhotoPosDataOuterClass.PhotoPosDataOrBuilder
        public int getPosId() {
            return this.posId_;
        }

        @Override // emu.grasscutter.net.proto.PhotoPosDataOuterClass.PhotoPosDataOrBuilder
        public int getOpenTime() {
            return this.openTime_;
        }

        @Override // emu.grasscutter.net.proto.PhotoPosDataOuterClass.PhotoPosDataOrBuilder
        public boolean hasCenter() {
            return this.center_ != null;
        }

        @Override // emu.grasscutter.net.proto.PhotoPosDataOuterClass.PhotoPosDataOrBuilder
        public VectorOuterClass.Vector getCenter() {
            return this.center_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.center_;
        }

        @Override // emu.grasscutter.net.proto.PhotoPosDataOuterClass.PhotoPosDataOrBuilder
        public VectorOuterClass.VectorOrBuilder getCenterOrBuilder() {
            return getCenter();
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
            if (this.openTime_ != 0) {
                output.writeUInt32(1, this.openTime_);
            }
            if (this.isOpen_) {
                output.writeBool(2, this.isOpen_);
            }
            if (this.center_ != null) {
                output.writeMessage(3, getCenter());
            }
            if (this.isView_) {
                output.writeBool(9, this.isView_);
            }
            if (this.posId_ != 0) {
                output.writeUInt32(10, this.posId_);
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
            if (this.openTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.openTime_);
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(2, this.isOpen_);
            }
            if (this.center_ != null) {
                size2 += CodedOutputStream.computeMessageSize(3, getCenter());
            }
            if (this.isView_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.isView_);
            }
            if (this.posId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.posId_);
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
            if (!(obj instanceof PhotoPosData)) {
                return equals(obj);
            }
            PhotoPosData other = (PhotoPosData) obj;
            if (getIsOpen() == other.getIsOpen() && getIsView() == other.getIsView() && getPosId() == other.getPosId() && getOpenTime() == other.getOpenTime() && hasCenter() == other.hasCenter()) {
                return (!hasCenter() || getCenter().equals(other.getCenter())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + Internal.hashBoolean(getIsOpen()))) + 9)) + Internal.hashBoolean(getIsView()))) + 10)) + getPosId())) + 1)) + getOpenTime();
            if (hasCenter()) {
                hash = (53 * ((37 * hash) + 3)) + getCenter().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PhotoPosData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PhotoPosData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PhotoPosData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PhotoPosData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PhotoPosData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PhotoPosData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PhotoPosData parseFrom(InputStream input) throws IOException {
            return (PhotoPosData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PhotoPosData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PhotoPosData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PhotoPosData parseDelimitedFrom(InputStream input) throws IOException {
            return (PhotoPosData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PhotoPosData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PhotoPosData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PhotoPosData parseFrom(CodedInputStream input) throws IOException {
            return (PhotoPosData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PhotoPosData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PhotoPosData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PhotoPosData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PhotoPosDataOuterClass$PhotoPosData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PhotoPosDataOrBuilder {
            private boolean isOpen_;
            private boolean isView_;
            private int posId_;
            private int openTime_;
            private VectorOuterClass.Vector center_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> centerBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PhotoPosDataOuterClass.internal_static_PhotoPosData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PhotoPosDataOuterClass.internal_static_PhotoPosData_fieldAccessorTable.ensureFieldAccessorsInitialized(PhotoPosData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PhotoPosData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isOpen_ = false;
                this.isView_ = false;
                this.posId_ = 0;
                this.openTime_ = 0;
                if (this.centerBuilder_ == null) {
                    this.center_ = null;
                } else {
                    this.center_ = null;
                    this.centerBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PhotoPosDataOuterClass.internal_static_PhotoPosData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PhotoPosData getDefaultInstanceForType() {
                return PhotoPosData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PhotoPosData build() {
                PhotoPosData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PhotoPosData buildPartial() {
                PhotoPosData result = new PhotoPosData(this);
                result.isOpen_ = this.isOpen_;
                result.isView_ = this.isView_;
                result.posId_ = this.posId_;
                result.openTime_ = this.openTime_;
                if (this.centerBuilder_ == null) {
                    result.center_ = this.center_;
                } else {
                    result.center_ = this.centerBuilder_.build();
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
                if (other instanceof PhotoPosData) {
                    return mergeFrom((PhotoPosData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PhotoPosData other) {
                if (other == PhotoPosData.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (other.getIsView()) {
                    setIsView(other.getIsView());
                }
                if (other.getPosId() != 0) {
                    setPosId(other.getPosId());
                }
                if (other.getOpenTime() != 0) {
                    setOpenTime(other.getOpenTime());
                }
                if (other.hasCenter()) {
                    mergeCenter(other.getCenter());
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
                PhotoPosData parsedMessage = null;
                try {
                    try {
                        parsedMessage = PhotoPosData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PhotoPosData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PhotoPosDataOuterClass.PhotoPosDataOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            public Builder setIsOpen(boolean value) {
                this.isOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.isOpen_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PhotoPosDataOuterClass.PhotoPosDataOrBuilder
            public boolean getIsView() {
                return this.isView_;
            }

            public Builder setIsView(boolean value) {
                this.isView_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsView() {
                this.isView_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PhotoPosDataOuterClass.PhotoPosDataOrBuilder
            public int getPosId() {
                return this.posId_;
            }

            public Builder setPosId(int value) {
                this.posId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPosId() {
                this.posId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PhotoPosDataOuterClass.PhotoPosDataOrBuilder
            public int getOpenTime() {
                return this.openTime_;
            }

            public Builder setOpenTime(int value) {
                this.openTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearOpenTime() {
                this.openTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PhotoPosDataOuterClass.PhotoPosDataOrBuilder
            public boolean hasCenter() {
                return (this.centerBuilder_ == null && this.center_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PhotoPosDataOuterClass.PhotoPosDataOrBuilder
            public VectorOuterClass.Vector getCenter() {
                if (this.centerBuilder_ == null) {
                    return this.center_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.center_;
                }
                return this.centerBuilder_.getMessage();
            }

            public Builder setCenter(VectorOuterClass.Vector value) {
                if (this.centerBuilder_ != null) {
                    this.centerBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.center_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setCenter(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.centerBuilder_ == null) {
                    this.center_ = builderForValue.build();
                    onChanged();
                } else {
                    this.centerBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeCenter(VectorOuterClass.Vector value) {
                if (this.centerBuilder_ == null) {
                    if (this.center_ != null) {
                        this.center_ = VectorOuterClass.Vector.newBuilder(this.center_).mergeFrom(value).buildPartial();
                    } else {
                        this.center_ = value;
                    }
                    onChanged();
                } else {
                    this.centerBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearCenter() {
                if (this.centerBuilder_ == null) {
                    this.center_ = null;
                    onChanged();
                } else {
                    this.center_ = null;
                    this.centerBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getCenterBuilder() {
                onChanged();
                return getCenterFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PhotoPosDataOuterClass.PhotoPosDataOrBuilder
            public VectorOuterClass.VectorOrBuilder getCenterOrBuilder() {
                if (this.centerBuilder_ != null) {
                    return this.centerBuilder_.getMessageOrBuilder();
                }
                return this.center_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.center_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getCenterFieldBuilder() {
                if (this.centerBuilder_ == null) {
                    this.centerBuilder_ = new SingleFieldBuilderV3<>(getCenter(), getParentForChildren(), isClean());
                    this.center_ = null;
                }
                return this.centerBuilder_;
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

        public static PhotoPosData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PhotoPosData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PhotoPosData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PhotoPosData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VectorOuterClass.getDescriptor();
    }
}
