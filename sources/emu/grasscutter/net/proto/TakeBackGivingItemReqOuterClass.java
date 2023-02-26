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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeBackGivingItemReqOuterClass.class */
public final class TakeBackGivingItemReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bTakeBackGivingItemReq.proto\":\n\u0015TakeBackGivingItemReq\u0012\u0010\n\bgivingId\u0018\u0003 \u0001(\r\u0012\u000f\n\u0007retcode\u0018\u000b \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TakeBackGivingItemReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TakeBackGivingItemReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TakeBackGivingItemReq_descriptor, new String[]{"GivingId", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeBackGivingItemReqOuterClass$TakeBackGivingItemReqOrBuilder.class */
    public interface TakeBackGivingItemReqOrBuilder extends MessageOrBuilder {
        int getGivingId();

        int getRetcode();
    }

    private TakeBackGivingItemReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeBackGivingItemReqOuterClass$TakeBackGivingItemReq.class */
    public static final class TakeBackGivingItemReq extends GeneratedMessageV3 implements TakeBackGivingItemReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GIVINGID_FIELD_NUMBER = 3;
        private int givingId_;
        public static final int RETCODE_FIELD_NUMBER = 11;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final TakeBackGivingItemReq DEFAULT_INSTANCE = new TakeBackGivingItemReq();
        private static final Parser<TakeBackGivingItemReq> PARSER = new AbstractParser<TakeBackGivingItemReq>() { // from class: emu.grasscutter.net.proto.TakeBackGivingItemReqOuterClass.TakeBackGivingItemReq.1
            @Override // com.google.protobuf.Parser
            public TakeBackGivingItemReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TakeBackGivingItemReq(input, extensionRegistry);
            }
        };

        private TakeBackGivingItemReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TakeBackGivingItemReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TakeBackGivingItemReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TakeBackGivingItemReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.givingId_ = input.readUInt32();
                                break;
                            case 88:
                                this.retcode_ = input.readInt32();
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
            return TakeBackGivingItemReqOuterClass.internal_static_TakeBackGivingItemReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TakeBackGivingItemReqOuterClass.internal_static_TakeBackGivingItemReq_fieldAccessorTable.ensureFieldAccessorsInitialized(TakeBackGivingItemReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TakeBackGivingItemReqOuterClass.TakeBackGivingItemReqOrBuilder
        public int getGivingId() {
            return this.givingId_;
        }

        @Override // emu.grasscutter.net.proto.TakeBackGivingItemReqOuterClass.TakeBackGivingItemReqOrBuilder
        public int getRetcode() {
            return this.retcode_;
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
            if (this.givingId_ != 0) {
                output.writeUInt32(3, this.givingId_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(11, this.retcode_);
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
            if (this.givingId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.givingId_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(11, this.retcode_);
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
            if (!(obj instanceof TakeBackGivingItemReq)) {
                return equals(obj);
            }
            TakeBackGivingItemReq other = (TakeBackGivingItemReq) obj;
            return getGivingId() == other.getGivingId() && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getGivingId())) + 11)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static TakeBackGivingItemReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeBackGivingItemReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeBackGivingItemReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeBackGivingItemReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeBackGivingItemReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeBackGivingItemReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeBackGivingItemReq parseFrom(InputStream input) throws IOException {
            return (TakeBackGivingItemReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeBackGivingItemReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeBackGivingItemReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeBackGivingItemReq parseDelimitedFrom(InputStream input) throws IOException {
            return (TakeBackGivingItemReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TakeBackGivingItemReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeBackGivingItemReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeBackGivingItemReq parseFrom(CodedInputStream input) throws IOException {
            return (TakeBackGivingItemReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeBackGivingItemReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeBackGivingItemReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TakeBackGivingItemReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeBackGivingItemReqOuterClass$TakeBackGivingItemReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TakeBackGivingItemReqOrBuilder {
            private int givingId_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TakeBackGivingItemReqOuterClass.internal_static_TakeBackGivingItemReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TakeBackGivingItemReqOuterClass.internal_static_TakeBackGivingItemReq_fieldAccessorTable.ensureFieldAccessorsInitialized(TakeBackGivingItemReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TakeBackGivingItemReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.givingId_ = 0;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TakeBackGivingItemReqOuterClass.internal_static_TakeBackGivingItemReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TakeBackGivingItemReq getDefaultInstanceForType() {
                return TakeBackGivingItemReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeBackGivingItemReq build() {
                TakeBackGivingItemReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeBackGivingItemReq buildPartial() {
                TakeBackGivingItemReq result = new TakeBackGivingItemReq(this);
                result.givingId_ = this.givingId_;
                result.retcode_ = this.retcode_;
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
                if (other instanceof TakeBackGivingItemReq) {
                    return mergeFrom((TakeBackGivingItemReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TakeBackGivingItemReq other) {
                if (other == TakeBackGivingItemReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getGivingId() != 0) {
                    setGivingId(other.getGivingId());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                TakeBackGivingItemReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = TakeBackGivingItemReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TakeBackGivingItemReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TakeBackGivingItemReqOuterClass.TakeBackGivingItemReqOrBuilder
            public int getGivingId() {
                return this.givingId_;
            }

            public Builder setGivingId(int value) {
                this.givingId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGivingId() {
                this.givingId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TakeBackGivingItemReqOuterClass.TakeBackGivingItemReqOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static TakeBackGivingItemReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TakeBackGivingItemReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TakeBackGivingItemReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TakeBackGivingItemReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
