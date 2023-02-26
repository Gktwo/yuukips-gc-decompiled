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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SelectWorktopOptionReqOuterClass.class */
public final class SelectWorktopOptionReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cSelectWorktopOptionReq.proto\"B\n\u0016SelectWorktopOptionReq\u0012\u0010\n\boptionId\u0018\u0001 \u0001(\r\u0012\u0016\n\u000egadgetEntityId\u0018\u000f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SelectWorktopOptionReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SelectWorktopOptionReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SelectWorktopOptionReq_descriptor, new String[]{"OptionId", "GadgetEntityId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SelectWorktopOptionReqOuterClass$SelectWorktopOptionReqOrBuilder.class */
    public interface SelectWorktopOptionReqOrBuilder extends MessageOrBuilder {
        int getOptionId();

        int getGadgetEntityId();
    }

    private SelectWorktopOptionReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SelectWorktopOptionReqOuterClass$SelectWorktopOptionReq.class */
    public static final class SelectWorktopOptionReq extends GeneratedMessageV3 implements SelectWorktopOptionReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int OPTIONID_FIELD_NUMBER = 1;
        private int optionId_;
        public static final int GADGETENTITYID_FIELD_NUMBER = 15;
        private int gadgetEntityId_;
        private byte memoizedIsInitialized;
        private static final SelectWorktopOptionReq DEFAULT_INSTANCE = new SelectWorktopOptionReq();
        private static final Parser<SelectWorktopOptionReq> PARSER = new AbstractParser<SelectWorktopOptionReq>() { // from class: emu.grasscutter.net.proto.SelectWorktopOptionReqOuterClass.SelectWorktopOptionReq.1
            @Override // com.google.protobuf.Parser
            public SelectWorktopOptionReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SelectWorktopOptionReq(input, extensionRegistry);
            }
        };

        private SelectWorktopOptionReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SelectWorktopOptionReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SelectWorktopOptionReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SelectWorktopOptionReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.optionId_ = input.readUInt32();
                                break;
                            case 120:
                                this.gadgetEntityId_ = input.readUInt32();
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
            return SelectWorktopOptionReqOuterClass.internal_static_SelectWorktopOptionReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SelectWorktopOptionReqOuterClass.internal_static_SelectWorktopOptionReq_fieldAccessorTable.ensureFieldAccessorsInitialized(SelectWorktopOptionReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SelectWorktopOptionReqOuterClass.SelectWorktopOptionReqOrBuilder
        public int getOptionId() {
            return this.optionId_;
        }

        @Override // emu.grasscutter.net.proto.SelectWorktopOptionReqOuterClass.SelectWorktopOptionReqOrBuilder
        public int getGadgetEntityId() {
            return this.gadgetEntityId_;
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
            if (this.optionId_ != 0) {
                output.writeUInt32(1, this.optionId_);
            }
            if (this.gadgetEntityId_ != 0) {
                output.writeUInt32(15, this.gadgetEntityId_);
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
            if (this.optionId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.optionId_);
            }
            if (this.gadgetEntityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.gadgetEntityId_);
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
            if (!(obj instanceof SelectWorktopOptionReq)) {
                return equals(obj);
            }
            SelectWorktopOptionReq other = (SelectWorktopOptionReq) obj;
            return getOptionId() == other.getOptionId() && getGadgetEntityId() == other.getGadgetEntityId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getOptionId())) + 15)) + getGadgetEntityId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static SelectWorktopOptionReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SelectWorktopOptionReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SelectWorktopOptionReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SelectWorktopOptionReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SelectWorktopOptionReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SelectWorktopOptionReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SelectWorktopOptionReq parseFrom(InputStream input) throws IOException {
            return (SelectWorktopOptionReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SelectWorktopOptionReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SelectWorktopOptionReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SelectWorktopOptionReq parseDelimitedFrom(InputStream input) throws IOException {
            return (SelectWorktopOptionReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SelectWorktopOptionReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SelectWorktopOptionReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SelectWorktopOptionReq parseFrom(CodedInputStream input) throws IOException {
            return (SelectWorktopOptionReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SelectWorktopOptionReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SelectWorktopOptionReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SelectWorktopOptionReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SelectWorktopOptionReqOuterClass$SelectWorktopOptionReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SelectWorktopOptionReqOrBuilder {
            private int optionId_;
            private int gadgetEntityId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SelectWorktopOptionReqOuterClass.internal_static_SelectWorktopOptionReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SelectWorktopOptionReqOuterClass.internal_static_SelectWorktopOptionReq_fieldAccessorTable.ensureFieldAccessorsInitialized(SelectWorktopOptionReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SelectWorktopOptionReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.optionId_ = 0;
                this.gadgetEntityId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SelectWorktopOptionReqOuterClass.internal_static_SelectWorktopOptionReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SelectWorktopOptionReq getDefaultInstanceForType() {
                return SelectWorktopOptionReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SelectWorktopOptionReq build() {
                SelectWorktopOptionReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SelectWorktopOptionReq buildPartial() {
                SelectWorktopOptionReq result = new SelectWorktopOptionReq(this);
                result.optionId_ = this.optionId_;
                result.gadgetEntityId_ = this.gadgetEntityId_;
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
                if (other instanceof SelectWorktopOptionReq) {
                    return mergeFrom((SelectWorktopOptionReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SelectWorktopOptionReq other) {
                if (other == SelectWorktopOptionReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getOptionId() != 0) {
                    setOptionId(other.getOptionId());
                }
                if (other.getGadgetEntityId() != 0) {
                    setGadgetEntityId(other.getGadgetEntityId());
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
                SelectWorktopOptionReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = SelectWorktopOptionReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SelectWorktopOptionReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SelectWorktopOptionReqOuterClass.SelectWorktopOptionReqOrBuilder
            public int getOptionId() {
                return this.optionId_;
            }

            public Builder setOptionId(int value) {
                this.optionId_ = value;
                onChanged();
                return this;
            }

            public Builder clearOptionId() {
                this.optionId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SelectWorktopOptionReqOuterClass.SelectWorktopOptionReqOrBuilder
            public int getGadgetEntityId() {
                return this.gadgetEntityId_;
            }

            public Builder setGadgetEntityId(int value) {
                this.gadgetEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGadgetEntityId() {
                this.gadgetEntityId_ = 0;
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

        public static SelectWorktopOptionReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SelectWorktopOptionReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SelectWorktopOptionReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SelectWorktopOptionReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
