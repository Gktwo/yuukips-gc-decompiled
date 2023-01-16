package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestRenameAvatarRspOuterClass.class */
public final class QuestRenameAvatarRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aQuestRenameAvatarRsp.proto\"a\n\u0014QuestRenameAvatarRsp\u0012\u000f\n\u0007retcode\u0018\u000b \u0001(\u0005\u0012\u0010\n\bis_check\u0018\u0004 \u0001(\b\u0012\u0011\n\trename_id\u0018\u000f \u0001(\r\u0012\u0013\n\u000bavatar_name\u0018\b \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_QuestRenameAvatarRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_QuestRenameAvatarRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_QuestRenameAvatarRsp_descriptor, new String[]{"Retcode", "IsCheck", "RenameId", "AvatarName"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestRenameAvatarRspOuterClass$QuestRenameAvatarRspOrBuilder.class */
    public interface QuestRenameAvatarRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        boolean getIsCheck();

        int getRenameId();

        String getAvatarName();

        ByteString getAvatarNameBytes();
    }

    private QuestRenameAvatarRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestRenameAvatarRspOuterClass$QuestRenameAvatarRsp.class */
    public static final class QuestRenameAvatarRsp extends GeneratedMessageV3 implements QuestRenameAvatarRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 11;
        private int retcode_;
        public static final int IS_CHECK_FIELD_NUMBER = 4;
        private boolean isCheck_;
        public static final int RENAME_ID_FIELD_NUMBER = 15;
        private int renameId_;
        public static final int AVATAR_NAME_FIELD_NUMBER = 8;
        private volatile Object avatarName_;
        private byte memoizedIsInitialized;
        private static final QuestRenameAvatarRsp DEFAULT_INSTANCE = new QuestRenameAvatarRsp();
        private static final Parser<QuestRenameAvatarRsp> PARSER = new AbstractParser<QuestRenameAvatarRsp>() { // from class: emu.grasscutter.net.proto.QuestRenameAvatarRspOuterClass.QuestRenameAvatarRsp.1
            @Override // com.google.protobuf.Parser
            public QuestRenameAvatarRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new QuestRenameAvatarRsp(input, extensionRegistry);
            }
        };

        private QuestRenameAvatarRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private QuestRenameAvatarRsp() {
            this.memoizedIsInitialized = -1;
            this.avatarName_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new QuestRenameAvatarRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QuestRenameAvatarRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.isCheck_ = input.readBool();
                                break;
                            case 66:
                                this.avatarName_ = input.readStringRequireUtf8();
                                break;
                            case 88:
                                this.retcode_ = input.readInt32();
                                break;
                            case 120:
                                this.renameId_ = input.readUInt32();
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
            return QuestRenameAvatarRspOuterClass.internal_static_QuestRenameAvatarRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QuestRenameAvatarRspOuterClass.internal_static_QuestRenameAvatarRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestRenameAvatarRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.QuestRenameAvatarRspOuterClass.QuestRenameAvatarRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.QuestRenameAvatarRspOuterClass.QuestRenameAvatarRspOrBuilder
        public boolean getIsCheck() {
            return this.isCheck_;
        }

        @Override // emu.grasscutter.net.proto.QuestRenameAvatarRspOuterClass.QuestRenameAvatarRspOrBuilder
        public int getRenameId() {
            return this.renameId_;
        }

        @Override // emu.grasscutter.net.proto.QuestRenameAvatarRspOuterClass.QuestRenameAvatarRspOrBuilder
        public String getAvatarName() {
            Object ref = this.avatarName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.avatarName_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.QuestRenameAvatarRspOuterClass.QuestRenameAvatarRspOrBuilder
        public ByteString getAvatarNameBytes() {
            Object ref = this.avatarName_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.avatarName_ = b;
            return b;
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
            if (this.isCheck_) {
                output.writeBool(4, this.isCheck_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.avatarName_)) {
                GeneratedMessageV3.writeString(output, 8, this.avatarName_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(11, this.retcode_);
            }
            if (this.renameId_ != 0) {
                output.writeUInt32(15, this.renameId_);
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
            if (this.isCheck_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(4, this.isCheck_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.avatarName_)) {
                size2 += GeneratedMessageV3.computeStringSize(8, this.avatarName_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(11, this.retcode_);
            }
            if (this.renameId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.renameId_);
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
            if (!(obj instanceof QuestRenameAvatarRsp)) {
                return equals(obj);
            }
            QuestRenameAvatarRsp other = (QuestRenameAvatarRsp) obj;
            return getRetcode() == other.getRetcode() && getIsCheck() == other.getIsCheck() && getRenameId() == other.getRenameId() && getAvatarName().equals(other.getAvatarName()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getRetcode())) + 4)) + Internal.hashBoolean(getIsCheck()))) + 15)) + getRenameId())) + 8)) + getAvatarName().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static QuestRenameAvatarRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestRenameAvatarRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestRenameAvatarRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestRenameAvatarRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestRenameAvatarRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestRenameAvatarRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestRenameAvatarRsp parseFrom(InputStream input) throws IOException {
            return (QuestRenameAvatarRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestRenameAvatarRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestRenameAvatarRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestRenameAvatarRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (QuestRenameAvatarRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static QuestRenameAvatarRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestRenameAvatarRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestRenameAvatarRsp parseFrom(CodedInputStream input) throws IOException {
            return (QuestRenameAvatarRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestRenameAvatarRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestRenameAvatarRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QuestRenameAvatarRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestRenameAvatarRspOuterClass$QuestRenameAvatarRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuestRenameAvatarRspOrBuilder {
            private int retcode_;
            private boolean isCheck_;
            private int renameId_;
            private Object avatarName_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return QuestRenameAvatarRspOuterClass.internal_static_QuestRenameAvatarRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QuestRenameAvatarRspOuterClass.internal_static_QuestRenameAvatarRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestRenameAvatarRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (QuestRenameAvatarRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.isCheck_ = false;
                this.renameId_ = 0;
                this.avatarName_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QuestRenameAvatarRspOuterClass.internal_static_QuestRenameAvatarRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public QuestRenameAvatarRsp getDefaultInstanceForType() {
                return QuestRenameAvatarRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestRenameAvatarRsp build() {
                QuestRenameAvatarRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestRenameAvatarRsp buildPartial() {
                QuestRenameAvatarRsp result = new QuestRenameAvatarRsp(this);
                result.retcode_ = this.retcode_;
                result.isCheck_ = this.isCheck_;
                result.renameId_ = this.renameId_;
                result.avatarName_ = this.avatarName_;
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
                if (other instanceof QuestRenameAvatarRsp) {
                    return mergeFrom((QuestRenameAvatarRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(QuestRenameAvatarRsp other) {
                if (other == QuestRenameAvatarRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getIsCheck()) {
                    setIsCheck(other.getIsCheck());
                }
                if (other.getRenameId() != 0) {
                    setRenameId(other.getRenameId());
                }
                if (!other.getAvatarName().isEmpty()) {
                    this.avatarName_ = other.avatarName_;
                    onChanged();
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
                QuestRenameAvatarRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = QuestRenameAvatarRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QuestRenameAvatarRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestRenameAvatarRspOuterClass.QuestRenameAvatarRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.QuestRenameAvatarRspOuterClass.QuestRenameAvatarRspOrBuilder
            public boolean getIsCheck() {
                return this.isCheck_;
            }

            public Builder setIsCheck(boolean value) {
                this.isCheck_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsCheck() {
                this.isCheck_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QuestRenameAvatarRspOuterClass.QuestRenameAvatarRspOrBuilder
            public int getRenameId() {
                return this.renameId_;
            }

            public Builder setRenameId(int value) {
                this.renameId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRenameId() {
                this.renameId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QuestRenameAvatarRspOuterClass.QuestRenameAvatarRspOrBuilder
            public String getAvatarName() {
                Object ref = this.avatarName_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.avatarName_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.QuestRenameAvatarRspOuterClass.QuestRenameAvatarRspOrBuilder
            public ByteString getAvatarNameBytes() {
                Object ref = this.avatarName_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.avatarName_ = b;
                return b;
            }

            public Builder setAvatarName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.avatarName_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarName() {
                this.avatarName_ = QuestRenameAvatarRsp.getDefaultInstance().getAvatarName();
                onChanged();
                return this;
            }

            public Builder setAvatarNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                QuestRenameAvatarRsp.checkByteStringIsUtf8(value);
                this.avatarName_ = value;
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

        public static QuestRenameAvatarRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QuestRenameAvatarRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<QuestRenameAvatarRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QuestRenameAvatarRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
