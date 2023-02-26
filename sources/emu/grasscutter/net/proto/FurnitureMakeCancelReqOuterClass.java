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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeCancelReqOuterClass.class */
public final class FurnitureMakeCancelReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cFurnitureMakeCancelReq.proto\"7\n\u0016FurnitureMakeCancelReq\u0012\u000e\n\u0006makeId\u0018\u0005 \u0001(\r\u0012\r\n\u0005index\u0018\f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_FurnitureMakeCancelReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FurnitureMakeCancelReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FurnitureMakeCancelReq_descriptor, new String[]{"MakeId", "Index"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeCancelReqOuterClass$FurnitureMakeCancelReqOrBuilder.class */
    public interface FurnitureMakeCancelReqOrBuilder extends MessageOrBuilder {
        int getMakeId();

        int getIndex();
    }

    private FurnitureMakeCancelReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeCancelReqOuterClass$FurnitureMakeCancelReq.class */
    public static final class FurnitureMakeCancelReq extends GeneratedMessageV3 implements FurnitureMakeCancelReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MAKEID_FIELD_NUMBER = 5;
        private int makeId_;
        public static final int INDEX_FIELD_NUMBER = 12;
        private int index_;
        private byte memoizedIsInitialized;
        private static final FurnitureMakeCancelReq DEFAULT_INSTANCE = new FurnitureMakeCancelReq();
        private static final Parser<FurnitureMakeCancelReq> PARSER = new AbstractParser<FurnitureMakeCancelReq>() { // from class: emu.grasscutter.net.proto.FurnitureMakeCancelReqOuterClass.FurnitureMakeCancelReq.1
            @Override // com.google.protobuf.Parser
            public FurnitureMakeCancelReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FurnitureMakeCancelReq(input, extensionRegistry);
            }
        };

        private FurnitureMakeCancelReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FurnitureMakeCancelReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FurnitureMakeCancelReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FurnitureMakeCancelReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 40:
                                this.makeId_ = input.readUInt32();
                                break;
                            case 96:
                                this.index_ = input.readUInt32();
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
            return FurnitureMakeCancelReqOuterClass.internal_static_FurnitureMakeCancelReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FurnitureMakeCancelReqOuterClass.internal_static_FurnitureMakeCancelReq_fieldAccessorTable.ensureFieldAccessorsInitialized(FurnitureMakeCancelReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeCancelReqOuterClass.FurnitureMakeCancelReqOrBuilder
        public int getMakeId() {
            return this.makeId_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeCancelReqOuterClass.FurnitureMakeCancelReqOrBuilder
        public int getIndex() {
            return this.index_;
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
            if (this.makeId_ != 0) {
                output.writeUInt32(5, this.makeId_);
            }
            if (this.index_ != 0) {
                output.writeUInt32(12, this.index_);
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
            if (this.makeId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(5, this.makeId_);
            }
            if (this.index_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.index_);
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
            if (!(obj instanceof FurnitureMakeCancelReq)) {
                return equals(obj);
            }
            FurnitureMakeCancelReq other = (FurnitureMakeCancelReq) obj;
            return getMakeId() == other.getMakeId() && getIndex() == other.getIndex() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getMakeId())) + 12)) + getIndex())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static FurnitureMakeCancelReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeCancelReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeCancelReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeCancelReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeCancelReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeCancelReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeCancelReq parseFrom(InputStream input) throws IOException {
            return (FurnitureMakeCancelReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FurnitureMakeCancelReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeCancelReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FurnitureMakeCancelReq parseDelimitedFrom(InputStream input) throws IOException {
            return (FurnitureMakeCancelReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FurnitureMakeCancelReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeCancelReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FurnitureMakeCancelReq parseFrom(CodedInputStream input) throws IOException {
            return (FurnitureMakeCancelReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FurnitureMakeCancelReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeCancelReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FurnitureMakeCancelReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeCancelReqOuterClass$FurnitureMakeCancelReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FurnitureMakeCancelReqOrBuilder {
            private int makeId_;
            private int index_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FurnitureMakeCancelReqOuterClass.internal_static_FurnitureMakeCancelReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FurnitureMakeCancelReqOuterClass.internal_static_FurnitureMakeCancelReq_fieldAccessorTable.ensureFieldAccessorsInitialized(FurnitureMakeCancelReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FurnitureMakeCancelReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.makeId_ = 0;
                this.index_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FurnitureMakeCancelReqOuterClass.internal_static_FurnitureMakeCancelReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FurnitureMakeCancelReq getDefaultInstanceForType() {
                return FurnitureMakeCancelReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FurnitureMakeCancelReq build() {
                FurnitureMakeCancelReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FurnitureMakeCancelReq buildPartial() {
                FurnitureMakeCancelReq result = new FurnitureMakeCancelReq(this);
                result.makeId_ = this.makeId_;
                result.index_ = this.index_;
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
                if (other instanceof FurnitureMakeCancelReq) {
                    return mergeFrom((FurnitureMakeCancelReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FurnitureMakeCancelReq other) {
                if (other == FurnitureMakeCancelReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getMakeId() != 0) {
                    setMakeId(other.getMakeId());
                }
                if (other.getIndex() != 0) {
                    setIndex(other.getIndex());
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
                FurnitureMakeCancelReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = FurnitureMakeCancelReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FurnitureMakeCancelReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeCancelReqOuterClass.FurnitureMakeCancelReqOrBuilder
            public int getMakeId() {
                return this.makeId_;
            }

            public Builder setMakeId(int value) {
                this.makeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMakeId() {
                this.makeId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeCancelReqOuterClass.FurnitureMakeCancelReqOrBuilder
            public int getIndex() {
                return this.index_;
            }

            public Builder setIndex(int value) {
                this.index_ = value;
                onChanged();
                return this;
            }

            public Builder clearIndex() {
                this.index_ = 0;
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

        public static FurnitureMakeCancelReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FurnitureMakeCancelReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FurnitureMakeCancelReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FurnitureMakeCancelReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
