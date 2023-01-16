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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SelectWorktopOptionRspOuterClass.class */
public final class SelectWorktopOptionRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cSelectWorktopOptionRsp.proto\"V\n\u0016SelectWorktopOptionRsp\u0012\u0011\n\toption_id\u0018\n \u0001(\r\u0012\u000f\n\u0007retcode\u0018\u0004 \u0001(\u0005\u0012\u0018\n\u0010gadget_entity_id\u0018\f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SelectWorktopOptionRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SelectWorktopOptionRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SelectWorktopOptionRsp_descriptor, new String[]{"OptionId", "Retcode", "GadgetEntityId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SelectWorktopOptionRspOuterClass$SelectWorktopOptionRspOrBuilder.class */
    public interface SelectWorktopOptionRspOrBuilder extends MessageOrBuilder {
        int getOptionId();

        int getRetcode();

        int getGadgetEntityId();
    }

    private SelectWorktopOptionRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SelectWorktopOptionRspOuterClass$SelectWorktopOptionRsp.class */
    public static final class SelectWorktopOptionRsp extends GeneratedMessageV3 implements SelectWorktopOptionRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int OPTION_ID_FIELD_NUMBER = 10;
        private int optionId_;
        public static final int RETCODE_FIELD_NUMBER = 4;
        private int retcode_;
        public static final int GADGET_ENTITY_ID_FIELD_NUMBER = 12;
        private int gadgetEntityId_;
        private byte memoizedIsInitialized;
        private static final SelectWorktopOptionRsp DEFAULT_INSTANCE = new SelectWorktopOptionRsp();
        private static final Parser<SelectWorktopOptionRsp> PARSER = new AbstractParser<SelectWorktopOptionRsp>() { // from class: emu.grasscutter.net.proto.SelectWorktopOptionRspOuterClass.SelectWorktopOptionRsp.1
            @Override // com.google.protobuf.Parser
            public SelectWorktopOptionRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SelectWorktopOptionRsp(input, extensionRegistry);
            }
        };

        private SelectWorktopOptionRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SelectWorktopOptionRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SelectWorktopOptionRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SelectWorktopOptionRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 32:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 80:
                                    this.optionId_ = input.readUInt32();
                                    break;
                                case 96:
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
            return SelectWorktopOptionRspOuterClass.internal_static_SelectWorktopOptionRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SelectWorktopOptionRspOuterClass.internal_static_SelectWorktopOptionRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(SelectWorktopOptionRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SelectWorktopOptionRspOuterClass.SelectWorktopOptionRspOrBuilder
        public int getOptionId() {
            return this.optionId_;
        }

        @Override // emu.grasscutter.net.proto.SelectWorktopOptionRspOuterClass.SelectWorktopOptionRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.SelectWorktopOptionRspOuterClass.SelectWorktopOptionRspOrBuilder
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
            if (this.retcode_ != 0) {
                output.writeInt32(4, this.retcode_);
            }
            if (this.optionId_ != 0) {
                output.writeUInt32(10, this.optionId_);
            }
            if (this.gadgetEntityId_ != 0) {
                output.writeUInt32(12, this.gadgetEntityId_);
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
            if (this.retcode_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(4, this.retcode_);
            }
            if (this.optionId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.optionId_);
            }
            if (this.gadgetEntityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.gadgetEntityId_);
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
            if (!(obj instanceof SelectWorktopOptionRsp)) {
                return equals(obj);
            }
            SelectWorktopOptionRsp other = (SelectWorktopOptionRsp) obj;
            return getOptionId() == other.getOptionId() && getRetcode() == other.getRetcode() && getGadgetEntityId() == other.getGadgetEntityId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getOptionId())) + 4)) + getRetcode())) + 12)) + getGadgetEntityId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static SelectWorktopOptionRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SelectWorktopOptionRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SelectWorktopOptionRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SelectWorktopOptionRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SelectWorktopOptionRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SelectWorktopOptionRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SelectWorktopOptionRsp parseFrom(InputStream input) throws IOException {
            return (SelectWorktopOptionRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SelectWorktopOptionRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SelectWorktopOptionRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SelectWorktopOptionRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (SelectWorktopOptionRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SelectWorktopOptionRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SelectWorktopOptionRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SelectWorktopOptionRsp parseFrom(CodedInputStream input) throws IOException {
            return (SelectWorktopOptionRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SelectWorktopOptionRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SelectWorktopOptionRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SelectWorktopOptionRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SelectWorktopOptionRspOuterClass$SelectWorktopOptionRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SelectWorktopOptionRspOrBuilder {
            private int optionId_;
            private int retcode_;
            private int gadgetEntityId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SelectWorktopOptionRspOuterClass.internal_static_SelectWorktopOptionRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SelectWorktopOptionRspOuterClass.internal_static_SelectWorktopOptionRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(SelectWorktopOptionRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SelectWorktopOptionRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.optionId_ = 0;
                this.retcode_ = 0;
                this.gadgetEntityId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SelectWorktopOptionRspOuterClass.internal_static_SelectWorktopOptionRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SelectWorktopOptionRsp getDefaultInstanceForType() {
                return SelectWorktopOptionRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SelectWorktopOptionRsp build() {
                SelectWorktopOptionRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SelectWorktopOptionRsp buildPartial() {
                SelectWorktopOptionRsp result = new SelectWorktopOptionRsp(this);
                result.optionId_ = this.optionId_;
                result.retcode_ = this.retcode_;
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
                if (other instanceof SelectWorktopOptionRsp) {
                    return mergeFrom((SelectWorktopOptionRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SelectWorktopOptionRsp other) {
                if (other == SelectWorktopOptionRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getOptionId() != 0) {
                    setOptionId(other.getOptionId());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                SelectWorktopOptionRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = SelectWorktopOptionRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SelectWorktopOptionRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SelectWorktopOptionRspOuterClass.SelectWorktopOptionRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.SelectWorktopOptionRspOuterClass.SelectWorktopOptionRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.SelectWorktopOptionRspOuterClass.SelectWorktopOptionRspOrBuilder
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

        public static SelectWorktopOptionRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SelectWorktopOptionRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SelectWorktopOptionRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SelectWorktopOptionRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
