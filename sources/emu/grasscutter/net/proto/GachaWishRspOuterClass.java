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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaWishRspOuterClass.class */
public final class GachaWishRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012GachaWishRsp.proto\"\u0001\n\fGachaWishRsp\u0012\u0015\n\rwish_progress\u0018\u0006 \u0001(\r\u0012\u0014\n\fwish_item_id\u0018\u000f \u0001(\r\u0012\u0019\n\u0011gacha_schedule_id\u0018\u000b \u0001(\r\u0012\u000f\n\u0007retcode\u0018\r \u0001(\u0005\u0012\u0019\n\u0011wish_max_progress\u0018\n \u0001(\r\u0012\u0012\n\ngacha_type\u0018\b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GachaWishRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GachaWishRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GachaWishRsp_descriptor, new String[]{"WishProgress", "WishItemId", "GachaScheduleId", "Retcode", "WishMaxProgress", "GachaType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaWishRspOuterClass$GachaWishRspOrBuilder.class */
    public interface GachaWishRspOrBuilder extends MessageOrBuilder {
        int getWishProgress();

        int getWishItemId();

        int getGachaScheduleId();

        int getRetcode();

        int getWishMaxProgress();

        int getGachaType();
    }

    private GachaWishRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaWishRspOuterClass$GachaWishRsp.class */
    public static final class GachaWishRsp extends GeneratedMessageV3 implements GachaWishRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int WISH_PROGRESS_FIELD_NUMBER = 6;
        private int wishProgress_;
        public static final int WISH_ITEM_ID_FIELD_NUMBER = 15;
        private int wishItemId_;
        public static final int GACHA_SCHEDULE_ID_FIELD_NUMBER = 11;
        private int gachaScheduleId_;
        public static final int RETCODE_FIELD_NUMBER = 13;
        private int retcode_;
        public static final int WISH_MAX_PROGRESS_FIELD_NUMBER = 10;
        private int wishMaxProgress_;
        public static final int GACHA_TYPE_FIELD_NUMBER = 8;
        private int gachaType_;
        private byte memoizedIsInitialized;
        private static final GachaWishRsp DEFAULT_INSTANCE = new GachaWishRsp();
        private static final Parser<GachaWishRsp> PARSER = new AbstractParser<GachaWishRsp>() { // from class: emu.grasscutter.net.proto.GachaWishRspOuterClass.GachaWishRsp.1
            @Override // com.google.protobuf.Parser
            public GachaWishRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GachaWishRsp(input, extensionRegistry);
            }
        };

        private GachaWishRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GachaWishRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GachaWishRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GachaWishRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 48:
                                this.wishProgress_ = input.readUInt32();
                                break;
                            case 64:
                                this.gachaType_ = input.readUInt32();
                                break;
                            case 80:
                                this.wishMaxProgress_ = input.readUInt32();
                                break;
                            case 88:
                                this.gachaScheduleId_ = input.readUInt32();
                                break;
                            case 104:
                                this.retcode_ = input.readInt32();
                                break;
                            case 120:
                                this.wishItemId_ = input.readUInt32();
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
            return GachaWishRspOuterClass.internal_static_GachaWishRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GachaWishRspOuterClass.internal_static_GachaWishRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GachaWishRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GachaWishRspOuterClass.GachaWishRspOrBuilder
        public int getWishProgress() {
            return this.wishProgress_;
        }

        @Override // emu.grasscutter.net.proto.GachaWishRspOuterClass.GachaWishRspOrBuilder
        public int getWishItemId() {
            return this.wishItemId_;
        }

        @Override // emu.grasscutter.net.proto.GachaWishRspOuterClass.GachaWishRspOrBuilder
        public int getGachaScheduleId() {
            return this.gachaScheduleId_;
        }

        @Override // emu.grasscutter.net.proto.GachaWishRspOuterClass.GachaWishRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GachaWishRspOuterClass.GachaWishRspOrBuilder
        public int getWishMaxProgress() {
            return this.wishMaxProgress_;
        }

        @Override // emu.grasscutter.net.proto.GachaWishRspOuterClass.GachaWishRspOrBuilder
        public int getGachaType() {
            return this.gachaType_;
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
            if (this.wishProgress_ != 0) {
                output.writeUInt32(6, this.wishProgress_);
            }
            if (this.gachaType_ != 0) {
                output.writeUInt32(8, this.gachaType_);
            }
            if (this.wishMaxProgress_ != 0) {
                output.writeUInt32(10, this.wishMaxProgress_);
            }
            if (this.gachaScheduleId_ != 0) {
                output.writeUInt32(11, this.gachaScheduleId_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(13, this.retcode_);
            }
            if (this.wishItemId_ != 0) {
                output.writeUInt32(15, this.wishItemId_);
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
            if (this.wishProgress_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(6, this.wishProgress_);
            }
            if (this.gachaType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.gachaType_);
            }
            if (this.wishMaxProgress_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.wishMaxProgress_);
            }
            if (this.gachaScheduleId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.gachaScheduleId_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(13, this.retcode_);
            }
            if (this.wishItemId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.wishItemId_);
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
            if (!(obj instanceof GachaWishRsp)) {
                return equals(obj);
            }
            GachaWishRsp other = (GachaWishRsp) obj;
            return getWishProgress() == other.getWishProgress() && getWishItemId() == other.getWishItemId() && getGachaScheduleId() == other.getGachaScheduleId() && getRetcode() == other.getRetcode() && getWishMaxProgress() == other.getWishMaxProgress() && getGachaType() == other.getGachaType() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getWishProgress())) + 15)) + getWishItemId())) + 11)) + getGachaScheduleId())) + 13)) + getRetcode())) + 10)) + getWishMaxProgress())) + 8)) + getGachaType())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static GachaWishRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaWishRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaWishRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaWishRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaWishRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaWishRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaWishRsp parseFrom(InputStream input) throws IOException {
            return (GachaWishRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GachaWishRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaWishRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GachaWishRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GachaWishRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GachaWishRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaWishRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GachaWishRsp parseFrom(CodedInputStream input) throws IOException {
            return (GachaWishRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GachaWishRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaWishRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GachaWishRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaWishRspOuterClass$GachaWishRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GachaWishRspOrBuilder {
            private int wishProgress_;
            private int wishItemId_;
            private int gachaScheduleId_;
            private int retcode_;
            private int wishMaxProgress_;
            private int gachaType_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GachaWishRspOuterClass.internal_static_GachaWishRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GachaWishRspOuterClass.internal_static_GachaWishRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GachaWishRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GachaWishRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.wishProgress_ = 0;
                this.wishItemId_ = 0;
                this.gachaScheduleId_ = 0;
                this.retcode_ = 0;
                this.wishMaxProgress_ = 0;
                this.gachaType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GachaWishRspOuterClass.internal_static_GachaWishRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GachaWishRsp getDefaultInstanceForType() {
                return GachaWishRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GachaWishRsp build() {
                GachaWishRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GachaWishRsp buildPartial() {
                GachaWishRsp result = new GachaWishRsp(this);
                result.wishProgress_ = this.wishProgress_;
                result.wishItemId_ = this.wishItemId_;
                result.gachaScheduleId_ = this.gachaScheduleId_;
                result.retcode_ = this.retcode_;
                result.wishMaxProgress_ = this.wishMaxProgress_;
                result.gachaType_ = this.gachaType_;
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
                if (other instanceof GachaWishRsp) {
                    return mergeFrom((GachaWishRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GachaWishRsp other) {
                if (other == GachaWishRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getWishProgress() != 0) {
                    setWishProgress(other.getWishProgress());
                }
                if (other.getWishItemId() != 0) {
                    setWishItemId(other.getWishItemId());
                }
                if (other.getGachaScheduleId() != 0) {
                    setGachaScheduleId(other.getGachaScheduleId());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getWishMaxProgress() != 0) {
                    setWishMaxProgress(other.getWishMaxProgress());
                }
                if (other.getGachaType() != 0) {
                    setGachaType(other.getGachaType());
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
                GachaWishRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GachaWishRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GachaWishRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GachaWishRspOuterClass.GachaWishRspOrBuilder
            public int getWishProgress() {
                return this.wishProgress_;
            }

            public Builder setWishProgress(int value) {
                this.wishProgress_ = value;
                onChanged();
                return this;
            }

            public Builder clearWishProgress() {
                this.wishProgress_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaWishRspOuterClass.GachaWishRspOrBuilder
            public int getWishItemId() {
                return this.wishItemId_;
            }

            public Builder setWishItemId(int value) {
                this.wishItemId_ = value;
                onChanged();
                return this;
            }

            public Builder clearWishItemId() {
                this.wishItemId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaWishRspOuterClass.GachaWishRspOrBuilder
            public int getGachaScheduleId() {
                return this.gachaScheduleId_;
            }

            public Builder setGachaScheduleId(int value) {
                this.gachaScheduleId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaScheduleId() {
                this.gachaScheduleId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaWishRspOuterClass.GachaWishRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaWishRspOuterClass.GachaWishRspOrBuilder
            public int getWishMaxProgress() {
                return this.wishMaxProgress_;
            }

            public Builder setWishMaxProgress(int value) {
                this.wishMaxProgress_ = value;
                onChanged();
                return this;
            }

            public Builder clearWishMaxProgress() {
                this.wishMaxProgress_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaWishRspOuterClass.GachaWishRspOrBuilder
            public int getGachaType() {
                return this.gachaType_;
            }

            public Builder setGachaType(int value) {
                this.gachaType_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaType() {
                this.gachaType_ = 0;
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

        public static GachaWishRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GachaWishRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GachaWishRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GachaWishRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
