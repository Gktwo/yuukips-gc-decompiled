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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeTeamNameRspOuterClass.class */
public final class ChangeTeamNameRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017ChangeTeamNameRsp.proto\"F\n\u0011ChangeTeamNameRsp\u0012\u000f\n\u0007retcode\u0018\u000e \u0001(\u0005\u0012\u0010\n\bteamName\u0018\u0002 \u0001(\t\u0012\u000e\n\u0006teamId\u0018\u0003 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ChangeTeamNameRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChangeTeamNameRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChangeTeamNameRsp_descriptor, new String[]{"Retcode", "TeamName", "TeamId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeTeamNameRspOuterClass$ChangeTeamNameRspOrBuilder.class */
    public interface ChangeTeamNameRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        String getTeamName();

        ByteString getTeamNameBytes();

        int getTeamId();
    }

    private ChangeTeamNameRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeTeamNameRspOuterClass$ChangeTeamNameRsp.class */
    public static final class ChangeTeamNameRsp extends GeneratedMessageV3 implements ChangeTeamNameRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 14;
        private int retcode_;
        public static final int TEAMNAME_FIELD_NUMBER = 2;
        private volatile Object teamName_;
        public static final int TEAMID_FIELD_NUMBER = 3;
        private int teamId_;
        private byte memoizedIsInitialized;
        private static final ChangeTeamNameRsp DEFAULT_INSTANCE = new ChangeTeamNameRsp();
        private static final Parser<ChangeTeamNameRsp> PARSER = new AbstractParser<ChangeTeamNameRsp>() { // from class: emu.grasscutter.net.proto.ChangeTeamNameRspOuterClass.ChangeTeamNameRsp.1
            @Override // com.google.protobuf.Parser
            public ChangeTeamNameRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChangeTeamNameRsp(input, extensionRegistry);
            }
        };

        private ChangeTeamNameRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ChangeTeamNameRsp() {
            this.memoizedIsInitialized = -1;
            this.teamName_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChangeTeamNameRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChangeTeamNameRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 18:
                                this.teamName_ = input.readStringRequireUtf8();
                                break;
                            case 24:
                                this.teamId_ = input.readInt32();
                                break;
                            case 112:
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
            return ChangeTeamNameRspOuterClass.internal_static_ChangeTeamNameRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChangeTeamNameRspOuterClass.internal_static_ChangeTeamNameRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangeTeamNameRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ChangeTeamNameRspOuterClass.ChangeTeamNameRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.ChangeTeamNameRspOuterClass.ChangeTeamNameRspOrBuilder
        public String getTeamName() {
            Object ref = this.teamName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.teamName_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.ChangeTeamNameRspOuterClass.ChangeTeamNameRspOrBuilder
        public ByteString getTeamNameBytes() {
            Object ref = this.teamName_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.teamName_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.ChangeTeamNameRspOuterClass.ChangeTeamNameRspOrBuilder
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
            if (!GeneratedMessageV3.isStringEmpty(this.teamName_)) {
                GeneratedMessageV3.writeString(output, 2, this.teamName_);
            }
            if (this.teamId_ != 0) {
                output.writeInt32(3, this.teamId_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(14, this.retcode_);
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
            if (!GeneratedMessageV3.isStringEmpty(this.teamName_)) {
                size2 = 0 + GeneratedMessageV3.computeStringSize(2, this.teamName_);
            }
            if (this.teamId_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(3, this.teamId_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(14, this.retcode_);
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
            if (!(obj instanceof ChangeTeamNameRsp)) {
                return equals(obj);
            }
            ChangeTeamNameRsp other = (ChangeTeamNameRsp) obj;
            return getRetcode() == other.getRetcode() && getTeamName().equals(other.getTeamName()) && getTeamId() == other.getTeamId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + getRetcode())) + 2)) + getTeamName().hashCode())) + 3)) + getTeamId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ChangeTeamNameRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChangeTeamNameRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeTeamNameRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChangeTeamNameRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeTeamNameRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChangeTeamNameRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeTeamNameRsp parseFrom(InputStream input) throws IOException {
            return (ChangeTeamNameRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChangeTeamNameRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeTeamNameRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChangeTeamNameRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (ChangeTeamNameRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChangeTeamNameRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeTeamNameRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChangeTeamNameRsp parseFrom(CodedInputStream input) throws IOException {
            return (ChangeTeamNameRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChangeTeamNameRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeTeamNameRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChangeTeamNameRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeTeamNameRspOuterClass$ChangeTeamNameRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChangeTeamNameRspOrBuilder {
            private int retcode_;
            private Object teamName_ = "";
            private int teamId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ChangeTeamNameRspOuterClass.internal_static_ChangeTeamNameRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChangeTeamNameRspOuterClass.internal_static_ChangeTeamNameRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangeTeamNameRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChangeTeamNameRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.teamName_ = "";
                this.teamId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChangeTeamNameRspOuterClass.internal_static_ChangeTeamNameRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChangeTeamNameRsp getDefaultInstanceForType() {
                return ChangeTeamNameRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChangeTeamNameRsp build() {
                ChangeTeamNameRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChangeTeamNameRsp buildPartial() {
                ChangeTeamNameRsp result = new ChangeTeamNameRsp(this);
                result.retcode_ = this.retcode_;
                result.teamName_ = this.teamName_;
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
                if (other instanceof ChangeTeamNameRsp) {
                    return mergeFrom((ChangeTeamNameRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChangeTeamNameRsp other) {
                if (other == ChangeTeamNameRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (!other.getTeamName().isEmpty()) {
                    this.teamName_ = other.teamName_;
                    onChanged();
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
                ChangeTeamNameRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChangeTeamNameRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChangeTeamNameRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ChangeTeamNameRspOuterClass.ChangeTeamNameRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.ChangeTeamNameRspOuterClass.ChangeTeamNameRspOrBuilder
            public String getTeamName() {
                Object ref = this.teamName_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.teamName_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.ChangeTeamNameRspOuterClass.ChangeTeamNameRspOrBuilder
            public ByteString getTeamNameBytes() {
                Object ref = this.teamName_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.teamName_ = b;
                return b;
            }

            public Builder setTeamName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.teamName_ = value;
                onChanged();
                return this;
            }

            public Builder clearTeamName() {
                this.teamName_ = ChangeTeamNameRsp.getDefaultInstance().getTeamName();
                onChanged();
                return this;
            }

            public Builder setTeamNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ChangeTeamNameRsp.checkByteStringIsUtf8(value);
                this.teamName_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChangeTeamNameRspOuterClass.ChangeTeamNameRspOrBuilder
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

        public static ChangeTeamNameRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChangeTeamNameRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChangeTeamNameRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChangeTeamNameRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
