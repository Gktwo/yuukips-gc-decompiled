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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChooseCurAvatarTeamReqOuterClass.class */
public final class ChooseCurAvatarTeamReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cChooseCurAvatarTeamReq.proto\")\n\u0016ChooseCurAvatarTeamReq\u0012\u000f\n\u0007team_id\u0018\n \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ChooseCurAvatarTeamReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChooseCurAvatarTeamReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChooseCurAvatarTeamReq_descriptor, new String[]{"TeamId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChooseCurAvatarTeamReqOuterClass$ChooseCurAvatarTeamReqOrBuilder.class */
    public interface ChooseCurAvatarTeamReqOrBuilder extends MessageOrBuilder {
        int getTeamId();
    }

    private ChooseCurAvatarTeamReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChooseCurAvatarTeamReqOuterClass$ChooseCurAvatarTeamReq.class */
    public static final class ChooseCurAvatarTeamReq extends GeneratedMessageV3 implements ChooseCurAvatarTeamReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TEAM_ID_FIELD_NUMBER = 10;
        private int teamId_;
        private byte memoizedIsInitialized;
        private static final ChooseCurAvatarTeamReq DEFAULT_INSTANCE = new ChooseCurAvatarTeamReq();
        private static final Parser<ChooseCurAvatarTeamReq> PARSER = new AbstractParser<ChooseCurAvatarTeamReq>() { // from class: emu.grasscutter.net.proto.ChooseCurAvatarTeamReqOuterClass.ChooseCurAvatarTeamReq.1
            @Override // com.google.protobuf.Parser
            public ChooseCurAvatarTeamReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChooseCurAvatarTeamReq(input, extensionRegistry);
            }
        };

        private ChooseCurAvatarTeamReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ChooseCurAvatarTeamReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChooseCurAvatarTeamReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChooseCurAvatarTeamReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 80:
                                this.teamId_ = input.readUInt32();
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
            return ChooseCurAvatarTeamReqOuterClass.internal_static_ChooseCurAvatarTeamReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChooseCurAvatarTeamReqOuterClass.internal_static_ChooseCurAvatarTeamReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ChooseCurAvatarTeamReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ChooseCurAvatarTeamReqOuterClass.ChooseCurAvatarTeamReqOrBuilder
        public int getTeamId() {
            return this.teamId_;
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
            if (this.teamId_ != 0) {
                output.writeUInt32(10, this.teamId_);
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
            if (this.teamId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(10, this.teamId_);
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
            if (!(obj instanceof ChooseCurAvatarTeamReq)) {
                return equals(obj);
            }
            ChooseCurAvatarTeamReq other = (ChooseCurAvatarTeamReq) obj;
            return getTeamId() == other.getTeamId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getTeamId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ChooseCurAvatarTeamReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChooseCurAvatarTeamReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChooseCurAvatarTeamReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChooseCurAvatarTeamReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChooseCurAvatarTeamReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChooseCurAvatarTeamReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChooseCurAvatarTeamReq parseFrom(InputStream input) throws IOException {
            return (ChooseCurAvatarTeamReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChooseCurAvatarTeamReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChooseCurAvatarTeamReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChooseCurAvatarTeamReq parseDelimitedFrom(InputStream input) throws IOException {
            return (ChooseCurAvatarTeamReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChooseCurAvatarTeamReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChooseCurAvatarTeamReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChooseCurAvatarTeamReq parseFrom(CodedInputStream input) throws IOException {
            return (ChooseCurAvatarTeamReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChooseCurAvatarTeamReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChooseCurAvatarTeamReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChooseCurAvatarTeamReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChooseCurAvatarTeamReqOuterClass$ChooseCurAvatarTeamReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChooseCurAvatarTeamReqOrBuilder {
            private int teamId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ChooseCurAvatarTeamReqOuterClass.internal_static_ChooseCurAvatarTeamReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChooseCurAvatarTeamReqOuterClass.internal_static_ChooseCurAvatarTeamReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ChooseCurAvatarTeamReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChooseCurAvatarTeamReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.teamId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChooseCurAvatarTeamReqOuterClass.internal_static_ChooseCurAvatarTeamReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChooseCurAvatarTeamReq getDefaultInstanceForType() {
                return ChooseCurAvatarTeamReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChooseCurAvatarTeamReq build() {
                ChooseCurAvatarTeamReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChooseCurAvatarTeamReq buildPartial() {
                ChooseCurAvatarTeamReq result = new ChooseCurAvatarTeamReq(this);
                result.teamId_ = this.teamId_;
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
                if (other instanceof ChooseCurAvatarTeamReq) {
                    return mergeFrom((ChooseCurAvatarTeamReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChooseCurAvatarTeamReq other) {
                if (other == ChooseCurAvatarTeamReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getTeamId() != 0) {
                    setTeamId(other.getTeamId());
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
                ChooseCurAvatarTeamReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChooseCurAvatarTeamReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChooseCurAvatarTeamReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ChooseCurAvatarTeamReqOuterClass.ChooseCurAvatarTeamReqOrBuilder
            public int getTeamId() {
                return this.teamId_;
            }

            public Builder setTeamId(int value) {
                this.teamId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTeamId() {
                this.teamId_ = 0;
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

        public static ChooseCurAvatarTeamReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChooseCurAvatarTeamReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChooseCurAvatarTeamReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChooseCurAvatarTeamReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
