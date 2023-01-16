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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StopServerInfoOuterClass.class */
public final class StopServerInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014StopServerInfo.proto\"b\n\u000eStopServerInfo\u0012\u0017\n\u000fstop_begin_time\u0018\u0001 \u0001(\r\u0012\u0015\n\rstop_end_time\u0018\u0002 \u0001(\r\u0012\u000b\n\u0003url\u0018\u0003 \u0001(\t\u0012\u0013\n\u000bcontent_msg\u0018\u0004 \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_StopServerInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_StopServerInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_StopServerInfo_descriptor, new String[]{"StopBeginTime", "StopEndTime", "Url", "ContentMsg"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StopServerInfoOuterClass$StopServerInfoOrBuilder.class */
    public interface StopServerInfoOrBuilder extends MessageOrBuilder {
        int getStopBeginTime();

        int getStopEndTime();

        String getUrl();

        ByteString getUrlBytes();

        String getContentMsg();

        ByteString getContentMsgBytes();
    }

    private StopServerInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StopServerInfoOuterClass$StopServerInfo.class */
    public static final class StopServerInfo extends GeneratedMessageV3 implements StopServerInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STOP_BEGIN_TIME_FIELD_NUMBER = 1;
        private int stopBeginTime_;
        public static final int STOP_END_TIME_FIELD_NUMBER = 2;
        private int stopEndTime_;
        public static final int URL_FIELD_NUMBER = 3;
        private volatile Object url_;
        public static final int CONTENT_MSG_FIELD_NUMBER = 4;
        private volatile Object contentMsg_;
        private byte memoizedIsInitialized;
        private static final StopServerInfo DEFAULT_INSTANCE = new StopServerInfo();
        private static final Parser<StopServerInfo> PARSER = new AbstractParser<StopServerInfo>() { // from class: emu.grasscutter.net.proto.StopServerInfoOuterClass.StopServerInfo.1
            @Override // com.google.protobuf.Parser
            public StopServerInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new StopServerInfo(input, extensionRegistry);
            }
        };

        private StopServerInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private StopServerInfo() {
            this.memoizedIsInitialized = -1;
            this.url_ = "";
            this.contentMsg_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new StopServerInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private StopServerInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
            return StopServerInfoOuterClass.internal_static_StopServerInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StopServerInfoOuterClass.internal_static_StopServerInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(StopServerInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.StopServerInfoOuterClass.StopServerInfoOrBuilder
        public int getStopBeginTime() {
            return this.stopBeginTime_;
        }

        @Override // emu.grasscutter.net.proto.StopServerInfoOuterClass.StopServerInfoOrBuilder
        public int getStopEndTime() {
            return this.stopEndTime_;
        }

        @Override // emu.grasscutter.net.proto.StopServerInfoOuterClass.StopServerInfoOrBuilder
        public String getUrl() {
            Object ref = this.url_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.url_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.StopServerInfoOuterClass.StopServerInfoOrBuilder
        public ByteString getUrlBytes() {
            Object ref = this.url_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.url_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.StopServerInfoOuterClass.StopServerInfoOrBuilder
        public String getContentMsg() {
            Object ref = this.contentMsg_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.contentMsg_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.StopServerInfoOuterClass.StopServerInfoOrBuilder
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
            if (!(obj instanceof StopServerInfo)) {
                return equals(obj);
            }
            StopServerInfo other = (StopServerInfo) obj;
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

        public static StopServerInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static StopServerInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static StopServerInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static StopServerInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static StopServerInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static StopServerInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static StopServerInfo parseFrom(InputStream input) throws IOException {
            return (StopServerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static StopServerInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StopServerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static StopServerInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (StopServerInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static StopServerInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StopServerInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static StopServerInfo parseFrom(CodedInputStream input) throws IOException {
            return (StopServerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static StopServerInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StopServerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(StopServerInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StopServerInfoOuterClass$StopServerInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements StopServerInfoOrBuilder {
            private int stopBeginTime_;
            private int stopEndTime_;
            private Object url_ = "";
            private Object contentMsg_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return StopServerInfoOuterClass.internal_static_StopServerInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StopServerInfoOuterClass.internal_static_StopServerInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(StopServerInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (StopServerInfo.alwaysUseFieldBuilders) {
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
                return StopServerInfoOuterClass.internal_static_StopServerInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public StopServerInfo getDefaultInstanceForType() {
                return StopServerInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public StopServerInfo build() {
                StopServerInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public StopServerInfo buildPartial() {
                StopServerInfo result = new StopServerInfo(this);
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
                if (other instanceof StopServerInfo) {
                    return mergeFrom((StopServerInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(StopServerInfo other) {
                if (other == StopServerInfo.getDefaultInstance()) {
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
                StopServerInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = StopServerInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (StopServerInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.StopServerInfoOuterClass.StopServerInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.StopServerInfoOuterClass.StopServerInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.StopServerInfoOuterClass.StopServerInfoOrBuilder
            public String getUrl() {
                Object ref = this.url_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.url_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.StopServerInfoOuterClass.StopServerInfoOrBuilder
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
                this.url_ = StopServerInfo.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            public Builder setUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                StopServerInfo.checkByteStringIsUtf8(value);
                this.url_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.StopServerInfoOuterClass.StopServerInfoOrBuilder
            public String getContentMsg() {
                Object ref = this.contentMsg_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.contentMsg_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.StopServerInfoOuterClass.StopServerInfoOrBuilder
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
                this.contentMsg_ = StopServerInfo.getDefaultInstance().getContentMsg();
                onChanged();
                return this;
            }

            public Builder setContentMsgBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                StopServerInfo.checkByteStringIsUtf8(value);
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

        public static StopServerInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StopServerInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<StopServerInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public StopServerInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
