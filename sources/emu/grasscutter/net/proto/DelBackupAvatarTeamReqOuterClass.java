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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DelBackupAvatarTeamReqOuterClass.class */
public final class DelBackupAvatarTeamReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cDelBackupAvatarTeamReq.proto\"4\n\u0016DelBackupAvatarTeamReq\u0012\u001a\n\u0012backupAvatarTeamId\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_DelBackupAvatarTeamReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DelBackupAvatarTeamReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DelBackupAvatarTeamReq_descriptor, new String[]{"BackupAvatarTeamId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DelBackupAvatarTeamReqOuterClass$DelBackupAvatarTeamReqOrBuilder.class */
    public interface DelBackupAvatarTeamReqOrBuilder extends MessageOrBuilder {
        int getBackupAvatarTeamId();
    }

    private DelBackupAvatarTeamReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DelBackupAvatarTeamReqOuterClass$DelBackupAvatarTeamReq.class */
    public static final class DelBackupAvatarTeamReq extends GeneratedMessageV3 implements DelBackupAvatarTeamReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BACKUPAVATARTEAMID_FIELD_NUMBER = 4;
        private int backupAvatarTeamId_;
        private byte memoizedIsInitialized;
        private static final DelBackupAvatarTeamReq DEFAULT_INSTANCE = new DelBackupAvatarTeamReq();
        private static final Parser<DelBackupAvatarTeamReq> PARSER = new AbstractParser<DelBackupAvatarTeamReq>() { // from class: emu.grasscutter.net.proto.DelBackupAvatarTeamReqOuterClass.DelBackupAvatarTeamReq.1
            @Override // com.google.protobuf.Parser
            public DelBackupAvatarTeamReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DelBackupAvatarTeamReq(input, extensionRegistry);
            }
        };

        private DelBackupAvatarTeamReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DelBackupAvatarTeamReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DelBackupAvatarTeamReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DelBackupAvatarTeamReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                this.backupAvatarTeamId_ = input.readUInt32();
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
            return DelBackupAvatarTeamReqOuterClass.internal_static_DelBackupAvatarTeamReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DelBackupAvatarTeamReqOuterClass.internal_static_DelBackupAvatarTeamReq_fieldAccessorTable.ensureFieldAccessorsInitialized(DelBackupAvatarTeamReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DelBackupAvatarTeamReqOuterClass.DelBackupAvatarTeamReqOrBuilder
        public int getBackupAvatarTeamId() {
            return this.backupAvatarTeamId_;
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
            if (this.backupAvatarTeamId_ != 0) {
                output.writeUInt32(4, this.backupAvatarTeamId_);
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
            if (this.backupAvatarTeamId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.backupAvatarTeamId_);
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
            if (!(obj instanceof DelBackupAvatarTeamReq)) {
                return equals(obj);
            }
            DelBackupAvatarTeamReq other = (DelBackupAvatarTeamReq) obj;
            return getBackupAvatarTeamId() == other.getBackupAvatarTeamId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getBackupAvatarTeamId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static DelBackupAvatarTeamReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DelBackupAvatarTeamReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DelBackupAvatarTeamReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DelBackupAvatarTeamReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DelBackupAvatarTeamReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DelBackupAvatarTeamReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DelBackupAvatarTeamReq parseFrom(InputStream input) throws IOException {
            return (DelBackupAvatarTeamReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DelBackupAvatarTeamReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DelBackupAvatarTeamReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DelBackupAvatarTeamReq parseDelimitedFrom(InputStream input) throws IOException {
            return (DelBackupAvatarTeamReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DelBackupAvatarTeamReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DelBackupAvatarTeamReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DelBackupAvatarTeamReq parseFrom(CodedInputStream input) throws IOException {
            return (DelBackupAvatarTeamReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DelBackupAvatarTeamReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DelBackupAvatarTeamReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DelBackupAvatarTeamReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DelBackupAvatarTeamReqOuterClass$DelBackupAvatarTeamReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DelBackupAvatarTeamReqOrBuilder {
            private int backupAvatarTeamId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DelBackupAvatarTeamReqOuterClass.internal_static_DelBackupAvatarTeamReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DelBackupAvatarTeamReqOuterClass.internal_static_DelBackupAvatarTeamReq_fieldAccessorTable.ensureFieldAccessorsInitialized(DelBackupAvatarTeamReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DelBackupAvatarTeamReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.backupAvatarTeamId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DelBackupAvatarTeamReqOuterClass.internal_static_DelBackupAvatarTeamReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DelBackupAvatarTeamReq getDefaultInstanceForType() {
                return DelBackupAvatarTeamReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DelBackupAvatarTeamReq build() {
                DelBackupAvatarTeamReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DelBackupAvatarTeamReq buildPartial() {
                DelBackupAvatarTeamReq result = new DelBackupAvatarTeamReq(this);
                result.backupAvatarTeamId_ = this.backupAvatarTeamId_;
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
                if (other instanceof DelBackupAvatarTeamReq) {
                    return mergeFrom((DelBackupAvatarTeamReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DelBackupAvatarTeamReq other) {
                if (other == DelBackupAvatarTeamReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getBackupAvatarTeamId() != 0) {
                    setBackupAvatarTeamId(other.getBackupAvatarTeamId());
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
                DelBackupAvatarTeamReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = DelBackupAvatarTeamReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DelBackupAvatarTeamReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DelBackupAvatarTeamReqOuterClass.DelBackupAvatarTeamReqOrBuilder
            public int getBackupAvatarTeamId() {
                return this.backupAvatarTeamId_;
            }

            public Builder setBackupAvatarTeamId(int value) {
                this.backupAvatarTeamId_ = value;
                onChanged();
                return this;
            }

            public Builder clearBackupAvatarTeamId() {
                this.backupAvatarTeamId_ = 0;
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

        public static DelBackupAvatarTeamReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DelBackupAvatarTeamReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DelBackupAvatarTeamReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DelBackupAvatarTeamReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
