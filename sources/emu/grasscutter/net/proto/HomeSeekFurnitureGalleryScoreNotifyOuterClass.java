package emu.grasscutter.net.proto;

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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.GalleryStopReasonOuterClass;
import emu.grasscutter.net.proto.HomeSeekFurnitureOneRecordOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeSeekFurnitureGalleryScoreNotifyOuterClass.class */
public final class HomeSeekFurnitureGalleryScoreNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n)HomeSeekFurnitureGalleryScoreNotify.proto\u001a\u0017GalleryStopReason.proto\u001a HomeSeekFurnitureOneRecord.proto\"\u0001\n#HomeSeekFurnitureGalleryScoreNotify\u0012\u0011\n\tgalleryId\u0018\u0002 \u0001(\r\u0012\"\n\u0006reason\u0018\t \u0001(\u000e2\u0012.GalleryStopReason\u0012+\n\u0006record\u0018\u0007 \u0001(\u000b2\u001b.HomeSeekFurnitureOneRecordB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{GalleryStopReasonOuterClass.getDescriptor(), HomeSeekFurnitureOneRecordOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeSeekFurnitureGalleryScoreNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_HomeSeekFurnitureGalleryScoreNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f746xb8af3b37 = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeSeekFurnitureGalleryScoreNotify_descriptor, new String[]{"GalleryId", "Reason", "Record"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeSeekFurnitureGalleryScoreNotifyOuterClass$HomeSeekFurnitureGalleryScoreNotifyOrBuilder.class */
    public interface HomeSeekFurnitureGalleryScoreNotifyOrBuilder extends MessageOrBuilder {
        int getGalleryId();

        int getReasonValue();

        GalleryStopReasonOuterClass.GalleryStopReason getReason();

        boolean hasRecord();

        HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord getRecord();

        HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder getRecordOrBuilder();
    }

    private HomeSeekFurnitureGalleryScoreNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeSeekFurnitureGalleryScoreNotifyOuterClass$HomeSeekFurnitureGalleryScoreNotify.class */
    public static final class HomeSeekFurnitureGalleryScoreNotify extends GeneratedMessageV3 implements HomeSeekFurnitureGalleryScoreNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GALLERYID_FIELD_NUMBER = 2;
        private int galleryId_;
        public static final int REASON_FIELD_NUMBER = 9;
        private int reason_;
        public static final int RECORD_FIELD_NUMBER = 7;
        private HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord record_;
        private byte memoizedIsInitialized;
        private static final HomeSeekFurnitureGalleryScoreNotify DEFAULT_INSTANCE = new HomeSeekFurnitureGalleryScoreNotify();
        private static final Parser<HomeSeekFurnitureGalleryScoreNotify> PARSER = new AbstractParser<HomeSeekFurnitureGalleryScoreNotify>() { // from class: emu.grasscutter.net.proto.HomeSeekFurnitureGalleryScoreNotifyOuterClass.HomeSeekFurnitureGalleryScoreNotify.1
            @Override // com.google.protobuf.Parser
            public HomeSeekFurnitureGalleryScoreNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeSeekFurnitureGalleryScoreNotify(input, extensionRegistry);
            }
        };

        private HomeSeekFurnitureGalleryScoreNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeSeekFurnitureGalleryScoreNotify() {
            this.memoizedIsInitialized = -1;
            this.reason_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeSeekFurnitureGalleryScoreNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeSeekFurnitureGalleryScoreNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                this.galleryId_ = input.readUInt32();
                                break;
                            case 58:
                                HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.Builder subBuilder = this.record_ != null ? this.record_.toBuilder() : null;
                                this.record_ = (HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord) input.readMessage(HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.record_);
                                    this.record_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 72:
                                this.reason_ = input.readEnum();
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
            return HomeSeekFurnitureGalleryScoreNotifyOuterClass.internal_static_HomeSeekFurnitureGalleryScoreNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeSeekFurnitureGalleryScoreNotifyOuterClass.f746xb8af3b37.ensureFieldAccessorsInitialized(HomeSeekFurnitureGalleryScoreNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeSeekFurnitureGalleryScoreNotifyOuterClass.HomeSeekFurnitureGalleryScoreNotifyOrBuilder
        public int getGalleryId() {
            return this.galleryId_;
        }

        @Override // emu.grasscutter.net.proto.HomeSeekFurnitureGalleryScoreNotifyOuterClass.HomeSeekFurnitureGalleryScoreNotifyOrBuilder
        public int getReasonValue() {
            return this.reason_;
        }

        @Override // emu.grasscutter.net.proto.HomeSeekFurnitureGalleryScoreNotifyOuterClass.HomeSeekFurnitureGalleryScoreNotifyOrBuilder
        public GalleryStopReasonOuterClass.GalleryStopReason getReason() {
            GalleryStopReasonOuterClass.GalleryStopReason result = GalleryStopReasonOuterClass.GalleryStopReason.valueOf(this.reason_);
            return result == null ? GalleryStopReasonOuterClass.GalleryStopReason.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.HomeSeekFurnitureGalleryScoreNotifyOuterClass.HomeSeekFurnitureGalleryScoreNotifyOrBuilder
        public boolean hasRecord() {
            return this.record_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeSeekFurnitureGalleryScoreNotifyOuterClass.HomeSeekFurnitureGalleryScoreNotifyOrBuilder
        public HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord getRecord() {
            return this.record_ == null ? HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.getDefaultInstance() : this.record_;
        }

        @Override // emu.grasscutter.net.proto.HomeSeekFurnitureGalleryScoreNotifyOuterClass.HomeSeekFurnitureGalleryScoreNotifyOrBuilder
        public HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder getRecordOrBuilder() {
            return getRecord();
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
            if (this.galleryId_ != 0) {
                output.writeUInt32(2, this.galleryId_);
            }
            if (this.record_ != null) {
                output.writeMessage(7, getRecord());
            }
            if (this.reason_ != GalleryStopReasonOuterClass.GalleryStopReason.GALLERY_STOP_REASON_NONE.getNumber()) {
                output.writeEnum(9, this.reason_);
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
            if (this.galleryId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.galleryId_);
            }
            if (this.record_ != null) {
                size2 += CodedOutputStream.computeMessageSize(7, getRecord());
            }
            if (this.reason_ != GalleryStopReasonOuterClass.GalleryStopReason.GALLERY_STOP_REASON_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(9, this.reason_);
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
            if (!(obj instanceof HomeSeekFurnitureGalleryScoreNotify)) {
                return equals(obj);
            }
            HomeSeekFurnitureGalleryScoreNotify other = (HomeSeekFurnitureGalleryScoreNotify) obj;
            if (getGalleryId() == other.getGalleryId() && this.reason_ == other.reason_ && hasRecord() == other.hasRecord()) {
                return (!hasRecord() || getRecord().equals(other.getRecord())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + getGalleryId())) + 9)) + this.reason_;
            if (hasRecord()) {
                hash = (53 * ((37 * hash) + 7)) + getRecord().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeSeekFurnitureGalleryScoreNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeSeekFurnitureGalleryScoreNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeSeekFurnitureGalleryScoreNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeSeekFurnitureGalleryScoreNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeSeekFurnitureGalleryScoreNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeSeekFurnitureGalleryScoreNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeSeekFurnitureGalleryScoreNotify parseFrom(InputStream input) throws IOException {
            return (HomeSeekFurnitureGalleryScoreNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeSeekFurnitureGalleryScoreNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeSeekFurnitureGalleryScoreNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeSeekFurnitureGalleryScoreNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeSeekFurnitureGalleryScoreNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeSeekFurnitureGalleryScoreNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeSeekFurnitureGalleryScoreNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeSeekFurnitureGalleryScoreNotify parseFrom(CodedInputStream input) throws IOException {
            return (HomeSeekFurnitureGalleryScoreNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeSeekFurnitureGalleryScoreNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeSeekFurnitureGalleryScoreNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeSeekFurnitureGalleryScoreNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeSeekFurnitureGalleryScoreNotifyOuterClass$HomeSeekFurnitureGalleryScoreNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeSeekFurnitureGalleryScoreNotifyOrBuilder {
            private int galleryId_;
            private int reason_ = 0;
            private HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord record_;
            private SingleFieldBuilderV3<HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord, HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.Builder, HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder> recordBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeSeekFurnitureGalleryScoreNotifyOuterClass.internal_static_HomeSeekFurnitureGalleryScoreNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeSeekFurnitureGalleryScoreNotifyOuterClass.f746xb8af3b37.ensureFieldAccessorsInitialized(HomeSeekFurnitureGalleryScoreNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeSeekFurnitureGalleryScoreNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.galleryId_ = 0;
                this.reason_ = 0;
                if (this.recordBuilder_ == null) {
                    this.record_ = null;
                } else {
                    this.record_ = null;
                    this.recordBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeSeekFurnitureGalleryScoreNotifyOuterClass.internal_static_HomeSeekFurnitureGalleryScoreNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeSeekFurnitureGalleryScoreNotify getDefaultInstanceForType() {
                return HomeSeekFurnitureGalleryScoreNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeSeekFurnitureGalleryScoreNotify build() {
                HomeSeekFurnitureGalleryScoreNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeSeekFurnitureGalleryScoreNotify buildPartial() {
                HomeSeekFurnitureGalleryScoreNotify result = new HomeSeekFurnitureGalleryScoreNotify(this);
                result.galleryId_ = this.galleryId_;
                result.reason_ = this.reason_;
                if (this.recordBuilder_ == null) {
                    result.record_ = this.record_;
                } else {
                    result.record_ = this.recordBuilder_.build();
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
                if (other instanceof HomeSeekFurnitureGalleryScoreNotify) {
                    return mergeFrom((HomeSeekFurnitureGalleryScoreNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeSeekFurnitureGalleryScoreNotify other) {
                if (other == HomeSeekFurnitureGalleryScoreNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getGalleryId() != 0) {
                    setGalleryId(other.getGalleryId());
                }
                if (other.reason_ != 0) {
                    setReasonValue(other.getReasonValue());
                }
                if (other.hasRecord()) {
                    mergeRecord(other.getRecord());
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
                HomeSeekFurnitureGalleryScoreNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeSeekFurnitureGalleryScoreNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeSeekFurnitureGalleryScoreNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeSeekFurnitureGalleryScoreNotifyOuterClass.HomeSeekFurnitureGalleryScoreNotifyOrBuilder
            public int getGalleryId() {
                return this.galleryId_;
            }

            public Builder setGalleryId(int value) {
                this.galleryId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGalleryId() {
                this.galleryId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeSeekFurnitureGalleryScoreNotifyOuterClass.HomeSeekFurnitureGalleryScoreNotifyOrBuilder
            public int getReasonValue() {
                return this.reason_;
            }

            public Builder setReasonValue(int value) {
                this.reason_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeSeekFurnitureGalleryScoreNotifyOuterClass.HomeSeekFurnitureGalleryScoreNotifyOrBuilder
            public GalleryStopReasonOuterClass.GalleryStopReason getReason() {
                GalleryStopReasonOuterClass.GalleryStopReason result = GalleryStopReasonOuterClass.GalleryStopReason.valueOf(this.reason_);
                return result == null ? GalleryStopReasonOuterClass.GalleryStopReason.UNRECOGNIZED : result;
            }

            public Builder setReason(GalleryStopReasonOuterClass.GalleryStopReason value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.reason_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearReason() {
                this.reason_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeSeekFurnitureGalleryScoreNotifyOuterClass.HomeSeekFurnitureGalleryScoreNotifyOrBuilder
            public boolean hasRecord() {
                return (this.recordBuilder_ == null && this.record_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeSeekFurnitureGalleryScoreNotifyOuterClass.HomeSeekFurnitureGalleryScoreNotifyOrBuilder
            public HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord getRecord() {
                if (this.recordBuilder_ == null) {
                    return this.record_ == null ? HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.getDefaultInstance() : this.record_;
                }
                return this.recordBuilder_.getMessage();
            }

            public Builder setRecord(HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord value) {
                if (this.recordBuilder_ != null) {
                    this.recordBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.record_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setRecord(HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.Builder builderForValue) {
                if (this.recordBuilder_ == null) {
                    this.record_ = builderForValue.build();
                    onChanged();
                } else {
                    this.recordBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeRecord(HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord value) {
                if (this.recordBuilder_ == null) {
                    if (this.record_ != null) {
                        this.record_ = HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.newBuilder(this.record_).mergeFrom(value).buildPartial();
                    } else {
                        this.record_ = value;
                    }
                    onChanged();
                } else {
                    this.recordBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearRecord() {
                if (this.recordBuilder_ == null) {
                    this.record_ = null;
                    onChanged();
                } else {
                    this.record_ = null;
                    this.recordBuilder_ = null;
                }
                return this;
            }

            public HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.Builder getRecordBuilder() {
                onChanged();
                return getRecordFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeSeekFurnitureGalleryScoreNotifyOuterClass.HomeSeekFurnitureGalleryScoreNotifyOrBuilder
            public HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder getRecordOrBuilder() {
                if (this.recordBuilder_ != null) {
                    return this.recordBuilder_.getMessageOrBuilder();
                }
                return this.record_ == null ? HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.getDefaultInstance() : this.record_;
            }

            private SingleFieldBuilderV3<HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord, HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.Builder, HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder> getRecordFieldBuilder() {
                if (this.recordBuilder_ == null) {
                    this.recordBuilder_ = new SingleFieldBuilderV3<>(getRecord(), getParentForChildren(), isClean());
                    this.record_ = null;
                }
                return this.recordBuilder_;
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

        public static HomeSeekFurnitureGalleryScoreNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeSeekFurnitureGalleryScoreNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeSeekFurnitureGalleryScoreNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeSeekFurnitureGalleryScoreNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        GalleryStopReasonOuterClass.getDescriptor();
        HomeSeekFurnitureOneRecordOuterClass.getDescriptor();
    }
}
