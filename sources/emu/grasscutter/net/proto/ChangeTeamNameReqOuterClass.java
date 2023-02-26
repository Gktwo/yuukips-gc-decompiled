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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeTeamNameReqOuterClass.class */
public final class ChangeTeamNameReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017ChangeTeamNameReq.proto\"5\n\u0011ChangeTeamNameReq\u0012\u0010\n\bteamName\u0018\b \u0001(\t\u0012\u000e\n\u0006teamId\u0018\u0001 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ChangeTeamNameReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChangeTeamNameReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChangeTeamNameReq_descriptor, new String[]{"TeamName", "TeamId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeTeamNameReqOuterClass$ChangeTeamNameReqOrBuilder.class */
    public interface ChangeTeamNameReqOrBuilder extends MessageOrBuilder {
        String getTeamName();

        ByteString getTeamNameBytes();

        int getTeamId();
    }

    private ChangeTeamNameReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeTeamNameReqOuterClass$ChangeTeamNameReq.class */
    public static final class ChangeTeamNameReq extends GeneratedMessageV3 implements ChangeTeamNameReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TEAMNAME_FIELD_NUMBER = 8;
        private volatile Object teamName_;
        public static final int TEAMID_FIELD_NUMBER = 1;
        private int teamId_;
        private byte memoizedIsInitialized;
        private static final ChangeTeamNameReq DEFAULT_INSTANCE = new ChangeTeamNameReq();
        private static final Parser<ChangeTeamNameReq> PARSER = new AbstractParser<ChangeTeamNameReq>() { // from class: emu.grasscutter.net.proto.ChangeTeamNameReqOuterClass.ChangeTeamNameReq.1
            @Override // com.google.protobuf.Parser
            public ChangeTeamNameReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChangeTeamNameReq(input, extensionRegistry);
            }
        };

        private ChangeTeamNameReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ChangeTeamNameReq() {
            this.memoizedIsInitialized = -1;
            this.teamName_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChangeTeamNameReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChangeTeamNameReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.teamId_ = input.readInt32();
                                    break;
                                case 66:
                                    this.teamName_ = input.readStringRequireUtf8();
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ChangeTeamNameReqOuterClass.internal_static_ChangeTeamNameReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChangeTeamNameReqOuterClass.internal_static_ChangeTeamNameReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangeTeamNameReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ChangeTeamNameReqOuterClass.ChangeTeamNameReqOrBuilder
        public String getTeamName() {
            Object ref = this.teamName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.teamName_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.ChangeTeamNameReqOuterClass.ChangeTeamNameReqOrBuilder
        public ByteString getTeamNameBytes() {
            Object ref = this.teamName_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.teamName_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.ChangeTeamNameReqOuterClass.ChangeTeamNameReqOrBuilder
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
                output.writeInt32(1, this.teamId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.teamName_)) {
                GeneratedMessageV3.writeString(output, 8, this.teamName_);
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
                size2 = 0 + CodedOutputStream.computeInt32Size(1, this.teamId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.teamName_)) {
                size2 += GeneratedMessageV3.computeStringSize(8, this.teamName_);
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
            if (!(obj instanceof ChangeTeamNameReq)) {
                return equals(obj);
            }
            ChangeTeamNameReq other = (ChangeTeamNameReq) obj;
            return getTeamName().equals(other.getTeamName()) && getTeamId() == other.getTeamId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + getTeamName().hashCode())) + 1)) + getTeamId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ChangeTeamNameReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChangeTeamNameReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeTeamNameReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChangeTeamNameReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeTeamNameReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChangeTeamNameReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChangeTeamNameReq parseFrom(InputStream input) throws IOException {
            return (ChangeTeamNameReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChangeTeamNameReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeTeamNameReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChangeTeamNameReq parseDelimitedFrom(InputStream input) throws IOException {
            return (ChangeTeamNameReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChangeTeamNameReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeTeamNameReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChangeTeamNameReq parseFrom(CodedInputStream input) throws IOException {
            return (ChangeTeamNameReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChangeTeamNameReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangeTeamNameReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChangeTeamNameReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeTeamNameReqOuterClass$ChangeTeamNameReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChangeTeamNameReqOrBuilder {
            private Object teamName_ = "";
            private int teamId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ChangeTeamNameReqOuterClass.internal_static_ChangeTeamNameReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChangeTeamNameReqOuterClass.internal_static_ChangeTeamNameReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ChangeTeamNameReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChangeTeamNameReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.teamName_ = "";
                this.teamId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChangeTeamNameReqOuterClass.internal_static_ChangeTeamNameReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChangeTeamNameReq getDefaultInstanceForType() {
                return ChangeTeamNameReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChangeTeamNameReq build() {
                ChangeTeamNameReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChangeTeamNameReq buildPartial() {
                ChangeTeamNameReq result = new ChangeTeamNameReq(this);
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
                if (other instanceof ChangeTeamNameReq) {
                    return mergeFrom((ChangeTeamNameReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChangeTeamNameReq other) {
                if (other == ChangeTeamNameReq.getDefaultInstance()) {
                    return this;
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
                ChangeTeamNameReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChangeTeamNameReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChangeTeamNameReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ChangeTeamNameReqOuterClass.ChangeTeamNameReqOrBuilder
            public String getTeamName() {
                Object ref = this.teamName_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.teamName_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.ChangeTeamNameReqOuterClass.ChangeTeamNameReqOrBuilder
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
                this.teamName_ = ChangeTeamNameReq.getDefaultInstance().getTeamName();
                onChanged();
                return this;
            }

            public Builder setTeamNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ChangeTeamNameReq.checkByteStringIsUtf8(value);
                this.teamName_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChangeTeamNameReqOuterClass.ChangeTeamNameReqOrBuilder
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

        public static ChangeTeamNameReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChangeTeamNameReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChangeTeamNameReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChangeTeamNameReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
