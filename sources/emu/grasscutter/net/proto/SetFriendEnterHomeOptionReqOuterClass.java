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
import emu.grasscutter.net.proto.FriendEnterHomeOptionOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetFriendEnterHomeOptionReqOuterClass.class */
public final class SetFriendEnterHomeOptionReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!SetFriendEnterHomeOptionReq.proto\u001a\u001bFriendEnterHomeOption.proto\"E\n\u001bSetFriendEnterHomeOptionReq\u0012&\n\u0006option\u0018\b \u0001(\u000e2\u0016.FriendEnterHomeOptionB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FriendEnterHomeOptionOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SetFriendEnterHomeOptionReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SetFriendEnterHomeOptionReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SetFriendEnterHomeOptionReq_descriptor, new String[]{"Option"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetFriendEnterHomeOptionReqOuterClass$SetFriendEnterHomeOptionReqOrBuilder.class */
    public interface SetFriendEnterHomeOptionReqOrBuilder extends MessageOrBuilder {
        int getOptionValue();

        FriendEnterHomeOptionOuterClass.FriendEnterHomeOption getOption();
    }

    private SetFriendEnterHomeOptionReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetFriendEnterHomeOptionReqOuterClass$SetFriendEnterHomeOptionReq.class */
    public static final class SetFriendEnterHomeOptionReq extends GeneratedMessageV3 implements SetFriendEnterHomeOptionReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int OPTION_FIELD_NUMBER = 8;
        private int option_;
        private byte memoizedIsInitialized;
        private static final SetFriendEnterHomeOptionReq DEFAULT_INSTANCE = new SetFriendEnterHomeOptionReq();
        private static final Parser<SetFriendEnterHomeOptionReq> PARSER = new AbstractParser<SetFriendEnterHomeOptionReq>() { // from class: emu.grasscutter.net.proto.SetFriendEnterHomeOptionReqOuterClass.SetFriendEnterHomeOptionReq.1
            @Override // com.google.protobuf.Parser
            public SetFriendEnterHomeOptionReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SetFriendEnterHomeOptionReq(input, extensionRegistry);
            }
        };

        private SetFriendEnterHomeOptionReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SetFriendEnterHomeOptionReq() {
            this.memoizedIsInitialized = -1;
            this.option_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SetFriendEnterHomeOptionReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SetFriendEnterHomeOptionReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 64:
                                this.option_ = input.readEnum();
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
            return SetFriendEnterHomeOptionReqOuterClass.internal_static_SetFriendEnterHomeOptionReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SetFriendEnterHomeOptionReqOuterClass.internal_static_SetFriendEnterHomeOptionReq_fieldAccessorTable.ensureFieldAccessorsInitialized(SetFriendEnterHomeOptionReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SetFriendEnterHomeOptionReqOuterClass.SetFriendEnterHomeOptionReqOrBuilder
        public int getOptionValue() {
            return this.option_;
        }

        @Override // emu.grasscutter.net.proto.SetFriendEnterHomeOptionReqOuterClass.SetFriendEnterHomeOptionReqOrBuilder
        public FriendEnterHomeOptionOuterClass.FriendEnterHomeOption getOption() {
            FriendEnterHomeOptionOuterClass.FriendEnterHomeOption result = FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.valueOf(this.option_);
            return result == null ? FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.UNRECOGNIZED : result;
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
            if (this.option_ != FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.FRIEND_ENTER_HOME_OPTION_NEED_CONFIRM.getNumber()) {
                output.writeEnum(8, this.option_);
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
            if (this.option_ != FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.FRIEND_ENTER_HOME_OPTION_NEED_CONFIRM.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(8, this.option_);
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
            if (!(obj instanceof SetFriendEnterHomeOptionReq)) {
                return equals(obj);
            }
            SetFriendEnterHomeOptionReq other = (SetFriendEnterHomeOptionReq) obj;
            return this.option_ == other.option_ && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + this.option_)) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static SetFriendEnterHomeOptionReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetFriendEnterHomeOptionReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetFriendEnterHomeOptionReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetFriendEnterHomeOptionReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetFriendEnterHomeOptionReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetFriendEnterHomeOptionReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetFriendEnterHomeOptionReq parseFrom(InputStream input) throws IOException {
            return (SetFriendEnterHomeOptionReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetFriendEnterHomeOptionReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetFriendEnterHomeOptionReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetFriendEnterHomeOptionReq parseDelimitedFrom(InputStream input) throws IOException {
            return (SetFriendEnterHomeOptionReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SetFriendEnterHomeOptionReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetFriendEnterHomeOptionReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetFriendEnterHomeOptionReq parseFrom(CodedInputStream input) throws IOException {
            return (SetFriendEnterHomeOptionReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetFriendEnterHomeOptionReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetFriendEnterHomeOptionReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SetFriendEnterHomeOptionReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetFriendEnterHomeOptionReqOuterClass$SetFriendEnterHomeOptionReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SetFriendEnterHomeOptionReqOrBuilder {
            private int option_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return SetFriendEnterHomeOptionReqOuterClass.internal_static_SetFriendEnterHomeOptionReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SetFriendEnterHomeOptionReqOuterClass.internal_static_SetFriendEnterHomeOptionReq_fieldAccessorTable.ensureFieldAccessorsInitialized(SetFriendEnterHomeOptionReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SetFriendEnterHomeOptionReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.option_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SetFriendEnterHomeOptionReqOuterClass.internal_static_SetFriendEnterHomeOptionReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SetFriendEnterHomeOptionReq getDefaultInstanceForType() {
                return SetFriendEnterHomeOptionReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetFriendEnterHomeOptionReq build() {
                SetFriendEnterHomeOptionReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetFriendEnterHomeOptionReq buildPartial() {
                SetFriendEnterHomeOptionReq result = new SetFriendEnterHomeOptionReq(this);
                result.option_ = this.option_;
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
                if (other instanceof SetFriendEnterHomeOptionReq) {
                    return mergeFrom((SetFriendEnterHomeOptionReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SetFriendEnterHomeOptionReq other) {
                if (other == SetFriendEnterHomeOptionReq.getDefaultInstance()) {
                    return this;
                }
                if (other.option_ != 0) {
                    setOptionValue(other.getOptionValue());
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
                SetFriendEnterHomeOptionReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = SetFriendEnterHomeOptionReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SetFriendEnterHomeOptionReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SetFriendEnterHomeOptionReqOuterClass.SetFriendEnterHomeOptionReqOrBuilder
            public int getOptionValue() {
                return this.option_;
            }

            public Builder setOptionValue(int value) {
                this.option_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SetFriendEnterHomeOptionReqOuterClass.SetFriendEnterHomeOptionReqOrBuilder
            public FriendEnterHomeOptionOuterClass.FriendEnterHomeOption getOption() {
                FriendEnterHomeOptionOuterClass.FriendEnterHomeOption result = FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.valueOf(this.option_);
                return result == null ? FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.UNRECOGNIZED : result;
            }

            public Builder setOption(FriendEnterHomeOptionOuterClass.FriendEnterHomeOption value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.option_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearOption() {
                this.option_ = 0;
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

        public static SetFriendEnterHomeOptionReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SetFriendEnterHomeOptionReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SetFriendEnterHomeOptionReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SetFriendEnterHomeOptionReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FriendEnterHomeOptionOuterClass.getDescriptor();
    }
}
