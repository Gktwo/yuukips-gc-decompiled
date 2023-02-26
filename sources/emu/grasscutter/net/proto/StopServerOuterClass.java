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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StopServerOuterClass.class */
public final class StopServerOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010StopServer.proto\"Y\n\nStopServer\u0012\u0015\n\rstopBeginTime\u0018\u0001 \u0001(\r\u0012\u0013\n\u000bstopEndTime\u0018\u0002 \u0001(\r\u0012\u000b\n\u0003url\u0018\u0003 \u0001(\t\u0012\u0012\n\ncontentMsg\u0018\u0004 \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_StopServer_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_StopServer_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_StopServer_descriptor, new String[]{"StopBeginTime", "StopEndTime", "Url", "ContentMsg"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StopServerOuterClass$StopServerOrBuilder.class */
    public interface StopServerOrBuilder extends MessageOrBuilder {
        int getStopBeginTime();

        int getStopEndTime();

        String getUrl();

        ByteString getUrlBytes();

        String getContentMsg();

        ByteString getContentMsgBytes();
    }

    private StopServerOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StopServerOuterClass$StopServer.class */
    public static final class StopServer extends GeneratedMessageV3 implements StopServerOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STOPBEGINTIME_FIELD_NUMBER = 1;
        private int stopBeginTime_;
        public static final int STOPENDTIME_FIELD_NUMBER = 2;
        private int stopEndTime_;
        public static final int URL_FIELD_NUMBER = 3;
        private volatile Object url_;
        public static final int CONTENTMSG_FIELD_NUMBER = 4;
        private volatile Object contentMsg_;
        private byte memoizedIsInitialized;
        private static final StopServer DEFAULT_INSTANCE = new StopServer();
        private static final Parser<StopServer> PARSER = new AbstractParser<StopServer>() { // from class: emu.grasscutter.net.proto.StopServerOuterClass.StopServer.1
            @Override // com.google.protobuf.Parser
            public StopServer parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new StopServer(input, extensionRegistry);
            }
        };

        private StopServer(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private StopServer() {
            this.memoizedIsInitialized = -1;
            this.url_ = "";
            this.contentMsg_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new StopServer();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private StopServer(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.stopBeginTime_ = input.readUInt32();
                                break;
                            case 16:
                                this.stopEndTime_ = input.readUInt32();
                                break;
                            case 26:
                                this.url_ = input.readStringRequireUtf8();
                                break;
                            case 34:
                                this.contentMsg_ = input.readStringRequireUtf8();
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
            return StopServerOuterClass.internal_static_StopServer_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StopServerOuterClass.internal_static_StopServer_fieldAccessorTable.ensureFieldAccessorsInitialized(StopServer.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.StopServerOuterClass.StopServerOrBuilder
        public int getStopBeginTime() {
            return this.stopBeginTime_;
        }

        @Override // emu.grasscutter.net.proto.StopServerOuterClass.StopServerOrBuilder
        public int getStopEndTime() {
            return this.stopEndTime_;
        }

        @Override // emu.grasscutter.net.proto.StopServerOuterClass.StopServerOrBuilder
        public String getUrl() {
            Object ref = this.url_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.url_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.StopServerOuterClass.StopServerOrBuilder
        public ByteString getUrlBytes() {
            Object ref = this.url_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.url_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.StopServerOuterClass.StopServerOrBuilder
        public String getContentMsg() {
            Object ref = this.contentMsg_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.contentMsg_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.StopServerOuterClass.StopServerOrBuilder
        public ByteString getContentMsgBytes() {
            Object ref = this.contentMsg_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.contentMsg_ = b;
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
            if (this.stopBeginTime_ != 0) {
                output.writeUInt32(1, this.stopBeginTime_);
            }
            if (this.stopEndTime_ != 0) {
                output.writeUInt32(2, this.stopEndTime_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.url_)) {
                GeneratedMessageV3.writeString(output, 3, this.url_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.contentMsg_)) {
                GeneratedMessageV3.writeString(output, 4, this.contentMsg_);
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
            if (this.stopBeginTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.stopBeginTime_);
            }
            if (this.stopEndTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.stopEndTime_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.url_)) {
                size2 += GeneratedMessageV3.computeStringSize(3, this.url_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.contentMsg_)) {
                size2 += GeneratedMessageV3.computeStringSize(4, this.contentMsg_);
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
            if (!(obj instanceof StopServer)) {
                return equals(obj);
            }
            StopServer other = (StopServer) obj;
            return getStopBeginTime() == other.getStopBeginTime() && getStopEndTime() == other.getStopEndTime() && getUrl().equals(other.getUrl()) && getContentMsg().equals(other.getContentMsg()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getStopBeginTime())) + 2)) + getStopEndTime())) + 3)) + getUrl().hashCode())) + 4)) + getContentMsg().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static StopServer parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static StopServer parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static StopServer parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static StopServer parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static StopServer parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static StopServer parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static StopServer parseFrom(InputStream input) throws IOException {
            return (StopServer) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static StopServer parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StopServer) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static StopServer parseDelimitedFrom(InputStream input) throws IOException {
            return (StopServer) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static StopServer parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StopServer) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static StopServer parseFrom(CodedInputStream input) throws IOException {
            return (StopServer) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static StopServer parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StopServer) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(StopServer prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StopServerOuterClass$StopServer$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements StopServerOrBuilder {
            private int stopBeginTime_;
            private int stopEndTime_;
            private Object url_ = "";
            private Object contentMsg_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return StopServerOuterClass.internal_static_StopServer_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StopServerOuterClass.internal_static_StopServer_fieldAccessorTable.ensureFieldAccessorsInitialized(StopServer.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (StopServer.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.stopBeginTime_ = 0;
                this.stopEndTime_ = 0;
                this.url_ = "";
                this.contentMsg_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return StopServerOuterClass.internal_static_StopServer_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public StopServer getDefaultInstanceForType() {
                return StopServer.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public StopServer build() {
                StopServer result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public StopServer buildPartial() {
                StopServer result = new StopServer(this);
                result.stopBeginTime_ = this.stopBeginTime_;
                result.stopEndTime_ = this.stopEndTime_;
                result.url_ = this.url_;
                result.contentMsg_ = this.contentMsg_;
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
                if (other instanceof StopServer) {
                    return mergeFrom((StopServer) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(StopServer other) {
                if (other == StopServer.getDefaultInstance()) {
                    return this;
                }
                if (other.getStopBeginTime() != 0) {
                    setStopBeginTime(other.getStopBeginTime());
                }
                if (other.getStopEndTime() != 0) {
                    setStopEndTime(other.getStopEndTime());
                }
                if (!other.getUrl().isEmpty()) {
                    this.url_ = other.url_;
                    onChanged();
                }
                if (!other.getContentMsg().isEmpty()) {
                    this.contentMsg_ = other.contentMsg_;
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
                StopServer parsedMessage = null;
                try {
                    try {
                        parsedMessage = StopServer.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (StopServer) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.StopServerOuterClass.StopServerOrBuilder
            public int getStopBeginTime() {
                return this.stopBeginTime_;
            }

            public Builder setStopBeginTime(int value) {
                this.stopBeginTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearStopBeginTime() {
                this.stopBeginTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.StopServerOuterClass.StopServerOrBuilder
            public int getStopEndTime() {
                return this.stopEndTime_;
            }

            public Builder setStopEndTime(int value) {
                this.stopEndTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearStopEndTime() {
                this.stopEndTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.StopServerOuterClass.StopServerOrBuilder
            public String getUrl() {
                Object ref = this.url_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.url_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.StopServerOuterClass.StopServerOrBuilder
            public ByteString getUrlBytes() {
                Object ref = this.url_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.url_ = b;
                return b;
            }

            public Builder setUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.url_ = value;
                onChanged();
                return this;
            }

            public Builder clearUrl() {
                this.url_ = StopServer.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            public Builder setUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                StopServer.checkByteStringIsUtf8(value);
                this.url_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.StopServerOuterClass.StopServerOrBuilder
            public String getContentMsg() {
                Object ref = this.contentMsg_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.contentMsg_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.StopServerOuterClass.StopServerOrBuilder
            public ByteString getContentMsgBytes() {
                Object ref = this.contentMsg_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.contentMsg_ = b;
                return b;
            }

            public Builder setContentMsg(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.contentMsg_ = value;
                onChanged();
                return this;
            }

            public Builder clearContentMsg() {
                this.contentMsg_ = StopServer.getDefaultInstance().getContentMsg();
                onChanged();
                return this;
            }

            public Builder setContentMsgBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                StopServer.checkByteStringIsUtf8(value);
                this.contentMsg_ = value;
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

        public static StopServer getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StopServer> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<StopServer> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public StopServer getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
