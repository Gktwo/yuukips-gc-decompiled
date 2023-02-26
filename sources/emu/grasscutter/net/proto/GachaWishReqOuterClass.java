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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaWishReqOuterClass.class */
public final class GachaWishReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012GachaWishReq.proto\"J\n\fGachaWishReq\u0012\u0011\n\tgachaType\u0018\u0006 \u0001(\r\u0012\u0017\n\u000fgachaScheduleId\u0018\n \u0001(\r\u0012\u000e\n\u0006itemId\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GachaWishReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GachaWishReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GachaWishReq_descriptor, new String[]{"GachaType", "GachaScheduleId", "ItemId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaWishReqOuterClass$GachaWishReqOrBuilder.class */
    public interface GachaWishReqOrBuilder extends MessageOrBuilder {
        int getGachaType();

        int getGachaScheduleId();

        int getItemId();
    }

    private GachaWishReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaWishReqOuterClass$GachaWishReq.class */
    public static final class GachaWishReq extends GeneratedMessageV3 implements GachaWishReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GACHATYPE_FIELD_NUMBER = 6;
        private int gachaType_;
        public static final int GACHASCHEDULEID_FIELD_NUMBER = 10;
        private int gachaScheduleId_;
        public static final int ITEMID_FIELD_NUMBER = 9;
        private int itemId_;
        private byte memoizedIsInitialized;
        private static final GachaWishReq DEFAULT_INSTANCE = new GachaWishReq();
        private static final Parser<GachaWishReq> PARSER = new AbstractParser<GachaWishReq>() { // from class: emu.grasscutter.net.proto.GachaWishReqOuterClass.GachaWishReq.1
            @Override // com.google.protobuf.Parser
            public GachaWishReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GachaWishReq(input, extensionRegistry);
            }
        };

        private GachaWishReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GachaWishReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GachaWishReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GachaWishReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 48:
                                    this.gachaType_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.itemId_ = input.readUInt32();
                                    break;
                                case 80:
                                    this.gachaScheduleId_ = input.readUInt32();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GachaWishReqOuterClass.internal_static_GachaWishReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GachaWishReqOuterClass.internal_static_GachaWishReq_fieldAccessorTable.ensureFieldAccessorsInitialized(GachaWishReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GachaWishReqOuterClass.GachaWishReqOrBuilder
        public int getGachaType() {
            return this.gachaType_;
        }

        @Override // emu.grasscutter.net.proto.GachaWishReqOuterClass.GachaWishReqOrBuilder
        public int getGachaScheduleId() {
            return this.gachaScheduleId_;
        }

        @Override // emu.grasscutter.net.proto.GachaWishReqOuterClass.GachaWishReqOrBuilder
        public int getItemId() {
            return this.itemId_;
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
            if (this.gachaType_ != 0) {
                output.writeUInt32(6, this.gachaType_);
            }
            if (this.itemId_ != 0) {
                output.writeUInt32(9, this.itemId_);
            }
            if (this.gachaScheduleId_ != 0) {
                output.writeUInt32(10, this.gachaScheduleId_);
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
            if (this.gachaType_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(6, this.gachaType_);
            }
            if (this.itemId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.itemId_);
            }
            if (this.gachaScheduleId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.gachaScheduleId_);
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
            if (!(obj instanceof GachaWishReq)) {
                return equals(obj);
            }
            GachaWishReq other = (GachaWishReq) obj;
            return getGachaType() == other.getGachaType() && getGachaScheduleId() == other.getGachaScheduleId() && getItemId() == other.getItemId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getGachaType())) + 10)) + getGachaScheduleId())) + 9)) + getItemId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static GachaWishReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaWishReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaWishReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaWishReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaWishReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaWishReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaWishReq parseFrom(InputStream input) throws IOException {
            return (GachaWishReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GachaWishReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaWishReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GachaWishReq parseDelimitedFrom(InputStream input) throws IOException {
            return (GachaWishReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GachaWishReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaWishReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GachaWishReq parseFrom(CodedInputStream input) throws IOException {
            return (GachaWishReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GachaWishReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaWishReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GachaWishReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaWishReqOuterClass$GachaWishReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GachaWishReqOrBuilder {
            private int gachaType_;
            private int gachaScheduleId_;
            private int itemId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GachaWishReqOuterClass.internal_static_GachaWishReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GachaWishReqOuterClass.internal_static_GachaWishReq_fieldAccessorTable.ensureFieldAccessorsInitialized(GachaWishReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GachaWishReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.gachaType_ = 0;
                this.gachaScheduleId_ = 0;
                this.itemId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GachaWishReqOuterClass.internal_static_GachaWishReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GachaWishReq getDefaultInstanceForType() {
                return GachaWishReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GachaWishReq build() {
                GachaWishReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GachaWishReq buildPartial() {
                GachaWishReq result = new GachaWishReq(this);
                result.gachaType_ = this.gachaType_;
                result.gachaScheduleId_ = this.gachaScheduleId_;
                result.itemId_ = this.itemId_;
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
                if (other instanceof GachaWishReq) {
                    return mergeFrom((GachaWishReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GachaWishReq other) {
                if (other == GachaWishReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getGachaType() != 0) {
                    setGachaType(other.getGachaType());
                }
                if (other.getGachaScheduleId() != 0) {
                    setGachaScheduleId(other.getGachaScheduleId());
                }
                if (other.getItemId() != 0) {
                    setItemId(other.getItemId());
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
                GachaWishReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = GachaWishReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GachaWishReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GachaWishReqOuterClass.GachaWishReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.GachaWishReqOuterClass.GachaWishReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.GachaWishReqOuterClass.GachaWishReqOrBuilder
            public int getItemId() {
                return this.itemId_;
            }

            public Builder setItemId(int value) {
                this.itemId_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemId() {
                this.itemId_ = 0;
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

        public static GachaWishReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GachaWishReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GachaWishReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GachaWishReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
