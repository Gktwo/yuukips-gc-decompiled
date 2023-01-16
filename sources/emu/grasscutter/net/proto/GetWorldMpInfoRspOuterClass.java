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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetWorldMpInfoRspOuterClass.class */
public final class GetWorldMpInfoRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017GetWorldMpInfoRsp.proto\"W\n\u0011GetWorldMpInfoRsp\u0012\u001a\n\u0012quit_mp_valid_time\u0018\u000f \u0001(\r\u0012\u000f\n\u0007retcode\u0018\u0001 \u0001(\u0005\u0012\u0015\n\ris_in_mp_mode\u0018\u000e \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GetWorldMpInfoRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetWorldMpInfoRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetWorldMpInfoRsp_descriptor, new String[]{"QuitMpValidTime", "Retcode", "IsInMpMode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetWorldMpInfoRspOuterClass$GetWorldMpInfoRspOrBuilder.class */
    public interface GetWorldMpInfoRspOrBuilder extends MessageOrBuilder {
        int getQuitMpValidTime();

        int getRetcode();

        boolean getIsInMpMode();
    }

    private GetWorldMpInfoRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetWorldMpInfoRspOuterClass$GetWorldMpInfoRsp.class */
    public static final class GetWorldMpInfoRsp extends GeneratedMessageV3 implements GetWorldMpInfoRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int QUIT_MP_VALID_TIME_FIELD_NUMBER = 15;
        private int quitMpValidTime_;
        public static final int RETCODE_FIELD_NUMBER = 1;
        private int retcode_;
        public static final int IS_IN_MP_MODE_FIELD_NUMBER = 14;
        private boolean isInMpMode_;
        private byte memoizedIsInitialized;
        private static final GetWorldMpInfoRsp DEFAULT_INSTANCE = new GetWorldMpInfoRsp();
        private static final Parser<GetWorldMpInfoRsp> PARSER = new AbstractParser<GetWorldMpInfoRsp>() { // from class: emu.grasscutter.net.proto.GetWorldMpInfoRspOuterClass.GetWorldMpInfoRsp.1
            @Override // com.google.protobuf.Parser
            public GetWorldMpInfoRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetWorldMpInfoRsp(input, extensionRegistry);
            }
        };

        private GetWorldMpInfoRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetWorldMpInfoRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetWorldMpInfoRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetWorldMpInfoRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 112:
                                    this.isInMpMode_ = input.readBool();
                                    break;
                                case 120:
                                    this.quitMpValidTime_ = input.readUInt32();
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
            return GetWorldMpInfoRspOuterClass.internal_static_GetWorldMpInfoRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetWorldMpInfoRspOuterClass.internal_static_GetWorldMpInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetWorldMpInfoRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetWorldMpInfoRspOuterClass.GetWorldMpInfoRspOrBuilder
        public int getQuitMpValidTime() {
            return this.quitMpValidTime_;
        }

        @Override // emu.grasscutter.net.proto.GetWorldMpInfoRspOuterClass.GetWorldMpInfoRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GetWorldMpInfoRspOuterClass.GetWorldMpInfoRspOrBuilder
        public boolean getIsInMpMode() {
            return this.isInMpMode_;
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
                output.writeInt32(1, this.retcode_);
            }
            if (this.isInMpMode_) {
                output.writeBool(14, this.isInMpMode_);
            }
            if (this.quitMpValidTime_ != 0) {
                output.writeUInt32(15, this.quitMpValidTime_);
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
                size2 = 0 + CodedOutputStream.computeInt32Size(1, this.retcode_);
            }
            if (this.isInMpMode_) {
                size2 += CodedOutputStream.computeBoolSize(14, this.isInMpMode_);
            }
            if (this.quitMpValidTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.quitMpValidTime_);
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
            if (!(obj instanceof GetWorldMpInfoRsp)) {
                return equals(obj);
            }
            GetWorldMpInfoRsp other = (GetWorldMpInfoRsp) obj;
            return getQuitMpValidTime() == other.getQuitMpValidTime() && getRetcode() == other.getRetcode() && getIsInMpMode() == other.getIsInMpMode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getQuitMpValidTime())) + 1)) + getRetcode())) + 14)) + Internal.hashBoolean(getIsInMpMode()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static GetWorldMpInfoRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetWorldMpInfoRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetWorldMpInfoRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetWorldMpInfoRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetWorldMpInfoRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetWorldMpInfoRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetWorldMpInfoRsp parseFrom(InputStream input) throws IOException {
            return (GetWorldMpInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetWorldMpInfoRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetWorldMpInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetWorldMpInfoRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetWorldMpInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetWorldMpInfoRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetWorldMpInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetWorldMpInfoRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetWorldMpInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetWorldMpInfoRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetWorldMpInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetWorldMpInfoRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetWorldMpInfoRspOuterClass$GetWorldMpInfoRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetWorldMpInfoRspOrBuilder {
            private int quitMpValidTime_;
            private int retcode_;
            private boolean isInMpMode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetWorldMpInfoRspOuterClass.internal_static_GetWorldMpInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetWorldMpInfoRspOuterClass.internal_static_GetWorldMpInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetWorldMpInfoRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetWorldMpInfoRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.quitMpValidTime_ = 0;
                this.retcode_ = 0;
                this.isInMpMode_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetWorldMpInfoRspOuterClass.internal_static_GetWorldMpInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetWorldMpInfoRsp getDefaultInstanceForType() {
                return GetWorldMpInfoRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetWorldMpInfoRsp build() {
                GetWorldMpInfoRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetWorldMpInfoRsp buildPartial() {
                GetWorldMpInfoRsp result = new GetWorldMpInfoRsp(this);
                result.quitMpValidTime_ = this.quitMpValidTime_;
                result.retcode_ = this.retcode_;
                result.isInMpMode_ = this.isInMpMode_;
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
                if (other instanceof GetWorldMpInfoRsp) {
                    return mergeFrom((GetWorldMpInfoRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetWorldMpInfoRsp other) {
                if (other == GetWorldMpInfoRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getQuitMpValidTime() != 0) {
                    setQuitMpValidTime(other.getQuitMpValidTime());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getIsInMpMode()) {
                    setIsInMpMode(other.getIsInMpMode());
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
                GetWorldMpInfoRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetWorldMpInfoRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetWorldMpInfoRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetWorldMpInfoRspOuterClass.GetWorldMpInfoRspOrBuilder
            public int getQuitMpValidTime() {
                return this.quitMpValidTime_;
            }

            public Builder setQuitMpValidTime(int value) {
                this.quitMpValidTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearQuitMpValidTime() {
                this.quitMpValidTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetWorldMpInfoRspOuterClass.GetWorldMpInfoRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetWorldMpInfoRspOuterClass.GetWorldMpInfoRspOrBuilder
            public boolean getIsInMpMode() {
                return this.isInMpMode_;
            }

            public Builder setIsInMpMode(boolean value) {
                this.isInMpMode_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsInMpMode() {
                this.isInMpMode_ = false;
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

        public static GetWorldMpInfoRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetWorldMpInfoRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetWorldMpInfoRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetWorldMpInfoRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
