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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/H5ActivityInfoOuterClass.class */
public final class H5ActivityInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014H5ActivityInfo.proto\"È\u0001\n\u000eH5ActivityInfo\u0012\u0018\n\u0010is_entrance_open\u0018\u0002 \u0001(\b\u0012\u001b\n\u0013Unk3300_OBKEBDCKHJF\u0018\u0001 \u0001(\r\u0012\u001b\n\u0013Unk3300_DMBNFECAKBH\u0018\u000e \u0001(\r\u0012\u001a\n\u0012content_close_time\u0018\u0004 \u0001(\r\u0012\u000b\n\u0003url\u0018\u0003 \u0001(\t\u0012\u0013\n\u000bprefab_path\u0018\u000f \u0001(\t\u0012\u0012\n\nbegin_time\u0018\u0005 \u0001(\r\u0012\u0010\n\bend_time\u0018\u0007 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_H5ActivityInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_H5ActivityInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_H5ActivityInfo_descriptor, new String[]{"IsEntranceOpen", "Unk3300OBKEBDCKHJF", "Unk3300DMBNFECAKBH", "ContentCloseTime", "Url", "PrefabPath", "BeginTime", "EndTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/H5ActivityInfoOuterClass$H5ActivityInfoOrBuilder.class */
    public interface H5ActivityInfoOrBuilder extends MessageOrBuilder {
        boolean getIsEntranceOpen();

        int getUnk3300OBKEBDCKHJF();

        int getUnk3300DMBNFECAKBH();

        int getContentCloseTime();

        String getUrl();

        ByteString getUrlBytes();

        String getPrefabPath();

        ByteString getPrefabPathBytes();

        int getBeginTime();

        int getEndTime();
    }

    private H5ActivityInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/H5ActivityInfoOuterClass$H5ActivityInfo.class */
    public static final class H5ActivityInfo extends GeneratedMessageV3 implements H5ActivityInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_ENTRANCE_OPEN_FIELD_NUMBER = 2;
        private boolean isEntranceOpen_;
        public static final int UNK3300_OBKEBDCKHJF_FIELD_NUMBER = 1;
        private int unk3300OBKEBDCKHJF_;
        public static final int UNK3300_DMBNFECAKBH_FIELD_NUMBER = 14;
        private int unk3300DMBNFECAKBH_;
        public static final int CONTENT_CLOSE_TIME_FIELD_NUMBER = 4;
        private int contentCloseTime_;
        public static final int URL_FIELD_NUMBER = 3;
        private volatile Object url_;
        public static final int PREFAB_PATH_FIELD_NUMBER = 15;
        private volatile Object prefabPath_;
        public static final int BEGIN_TIME_FIELD_NUMBER = 5;
        private int beginTime_;
        public static final int END_TIME_FIELD_NUMBER = 7;
        private int endTime_;
        private byte memoizedIsInitialized;
        private static final H5ActivityInfo DEFAULT_INSTANCE = new H5ActivityInfo();
        private static final Parser<H5ActivityInfo> PARSER = new AbstractParser<H5ActivityInfo>() { // from class: emu.grasscutter.net.proto.H5ActivityInfoOuterClass.H5ActivityInfo.1
            @Override // com.google.protobuf.Parser
            public H5ActivityInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new H5ActivityInfo(input, extensionRegistry);
            }
        };

        private H5ActivityInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private H5ActivityInfo() {
            this.memoizedIsInitialized = -1;
            this.url_ = "";
            this.prefabPath_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new H5ActivityInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private H5ActivityInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.unk3300OBKEBDCKHJF_ = input.readUInt32();
                                break;
                            case 16:
                                this.isEntranceOpen_ = input.readBool();
                                break;
                            case 26:
                                this.url_ = input.readStringRequireUtf8();
                                break;
                            case 32:
                                this.contentCloseTime_ = input.readUInt32();
                                break;
                            case 40:
                                this.beginTime_ = input.readUInt32();
                                break;
                            case 56:
                                this.endTime_ = input.readUInt32();
                                break;
                            case 112:
                                this.unk3300DMBNFECAKBH_ = input.readUInt32();
                                break;
                            case 122:
                                this.prefabPath_ = input.readStringRequireUtf8();
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
            return H5ActivityInfoOuterClass.internal_static_H5ActivityInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return H5ActivityInfoOuterClass.internal_static_H5ActivityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(H5ActivityInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder
        public boolean getIsEntranceOpen() {
            return this.isEntranceOpen_;
        }

        @Override // emu.grasscutter.net.proto.H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder
        public int getUnk3300OBKEBDCKHJF() {
            return this.unk3300OBKEBDCKHJF_;
        }

        @Override // emu.grasscutter.net.proto.H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder
        public int getUnk3300DMBNFECAKBH() {
            return this.unk3300DMBNFECAKBH_;
        }

        @Override // emu.grasscutter.net.proto.H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder
        public int getContentCloseTime() {
            return this.contentCloseTime_;
        }

        @Override // emu.grasscutter.net.proto.H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder
        public String getUrl() {
            Object ref = this.url_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.url_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder
        public ByteString getUrlBytes() {
            Object ref = this.url_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.url_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder
        public String getPrefabPath() {
            Object ref = this.prefabPath_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.prefabPath_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder
        public ByteString getPrefabPathBytes() {
            Object ref = this.prefabPath_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.prefabPath_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder
        public int getBeginTime() {
            return this.beginTime_;
        }

        @Override // emu.grasscutter.net.proto.H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder
        public int getEndTime() {
            return this.endTime_;
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
            if (this.unk3300OBKEBDCKHJF_ != 0) {
                output.writeUInt32(1, this.unk3300OBKEBDCKHJF_);
            }
            if (this.isEntranceOpen_) {
                output.writeBool(2, this.isEntranceOpen_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.url_)) {
                GeneratedMessageV3.writeString(output, 3, this.url_);
            }
            if (this.contentCloseTime_ != 0) {
                output.writeUInt32(4, this.contentCloseTime_);
            }
            if (this.beginTime_ != 0) {
                output.writeUInt32(5, this.beginTime_);
            }
            if (this.endTime_ != 0) {
                output.writeUInt32(7, this.endTime_);
            }
            if (this.unk3300DMBNFECAKBH_ != 0) {
                output.writeUInt32(14, this.unk3300DMBNFECAKBH_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.prefabPath_)) {
                GeneratedMessageV3.writeString(output, 15, this.prefabPath_);
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
            if (this.unk3300OBKEBDCKHJF_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.unk3300OBKEBDCKHJF_);
            }
            if (this.isEntranceOpen_) {
                size2 += CodedOutputStream.computeBoolSize(2, this.isEntranceOpen_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.url_)) {
                size2 += GeneratedMessageV3.computeStringSize(3, this.url_);
            }
            if (this.contentCloseTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.contentCloseTime_);
            }
            if (this.beginTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.beginTime_);
            }
            if (this.endTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.endTime_);
            }
            if (this.unk3300DMBNFECAKBH_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.unk3300DMBNFECAKBH_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.prefabPath_)) {
                size2 += GeneratedMessageV3.computeStringSize(15, this.prefabPath_);
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
            if (!(obj instanceof H5ActivityInfo)) {
                return equals(obj);
            }
            H5ActivityInfo other = (H5ActivityInfo) obj;
            return getIsEntranceOpen() == other.getIsEntranceOpen() && getUnk3300OBKEBDCKHJF() == other.getUnk3300OBKEBDCKHJF() && getUnk3300DMBNFECAKBH() == other.getUnk3300DMBNFECAKBH() && getContentCloseTime() == other.getContentCloseTime() && getUrl().equals(other.getUrl()) && getPrefabPath().equals(other.getPrefabPath()) && getBeginTime() == other.getBeginTime() && getEndTime() == other.getEndTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + Internal.hashBoolean(getIsEntranceOpen()))) + 1)) + getUnk3300OBKEBDCKHJF())) + 14)) + getUnk3300DMBNFECAKBH())) + 4)) + getContentCloseTime())) + 3)) + getUrl().hashCode())) + 15)) + getPrefabPath().hashCode())) + 5)) + getBeginTime())) + 7)) + getEndTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static H5ActivityInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static H5ActivityInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static H5ActivityInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static H5ActivityInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static H5ActivityInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static H5ActivityInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static H5ActivityInfo parseFrom(InputStream input) throws IOException {
            return (H5ActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static H5ActivityInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (H5ActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static H5ActivityInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (H5ActivityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static H5ActivityInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (H5ActivityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static H5ActivityInfo parseFrom(CodedInputStream input) throws IOException {
            return (H5ActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static H5ActivityInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (H5ActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(H5ActivityInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/H5ActivityInfoOuterClass$H5ActivityInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements H5ActivityInfoOrBuilder {
            private boolean isEntranceOpen_;
            private int unk3300OBKEBDCKHJF_;
            private int unk3300DMBNFECAKBH_;
            private int contentCloseTime_;
            private Object url_ = "";
            private Object prefabPath_ = "";
            private int beginTime_;
            private int endTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return H5ActivityInfoOuterClass.internal_static_H5ActivityInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return H5ActivityInfoOuterClass.internal_static_H5ActivityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(H5ActivityInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (H5ActivityInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isEntranceOpen_ = false;
                this.unk3300OBKEBDCKHJF_ = 0;
                this.unk3300DMBNFECAKBH_ = 0;
                this.contentCloseTime_ = 0;
                this.url_ = "";
                this.prefabPath_ = "";
                this.beginTime_ = 0;
                this.endTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return H5ActivityInfoOuterClass.internal_static_H5ActivityInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public H5ActivityInfo getDefaultInstanceForType() {
                return H5ActivityInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public H5ActivityInfo build() {
                H5ActivityInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public H5ActivityInfo buildPartial() {
                H5ActivityInfo result = new H5ActivityInfo(this);
                result.isEntranceOpen_ = this.isEntranceOpen_;
                result.unk3300OBKEBDCKHJF_ = this.unk3300OBKEBDCKHJF_;
                result.unk3300DMBNFECAKBH_ = this.unk3300DMBNFECAKBH_;
                result.contentCloseTime_ = this.contentCloseTime_;
                result.url_ = this.url_;
                result.prefabPath_ = this.prefabPath_;
                result.beginTime_ = this.beginTime_;
                result.endTime_ = this.endTime_;
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
                if (other instanceof H5ActivityInfo) {
                    return mergeFrom((H5ActivityInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(H5ActivityInfo other) {
                if (other == H5ActivityInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsEntranceOpen()) {
                    setIsEntranceOpen(other.getIsEntranceOpen());
                }
                if (other.getUnk3300OBKEBDCKHJF() != 0) {
                    setUnk3300OBKEBDCKHJF(other.getUnk3300OBKEBDCKHJF());
                }
                if (other.getUnk3300DMBNFECAKBH() != 0) {
                    setUnk3300DMBNFECAKBH(other.getUnk3300DMBNFECAKBH());
                }
                if (other.getContentCloseTime() != 0) {
                    setContentCloseTime(other.getContentCloseTime());
                }
                if (!other.getUrl().isEmpty()) {
                    this.url_ = other.url_;
                    onChanged();
                }
                if (!other.getPrefabPath().isEmpty()) {
                    this.prefabPath_ = other.prefabPath_;
                    onChanged();
                }
                if (other.getBeginTime() != 0) {
                    setBeginTime(other.getBeginTime());
                }
                if (other.getEndTime() != 0) {
                    setEndTime(other.getEndTime());
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
                H5ActivityInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = H5ActivityInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (H5ActivityInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder
            public boolean getIsEntranceOpen() {
                return this.isEntranceOpen_;
            }

            public Builder setIsEntranceOpen(boolean value) {
                this.isEntranceOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsEntranceOpen() {
                this.isEntranceOpen_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder
            public int getUnk3300OBKEBDCKHJF() {
                return this.unk3300OBKEBDCKHJF_;
            }

            public Builder setUnk3300OBKEBDCKHJF(int value) {
                this.unk3300OBKEBDCKHJF_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300OBKEBDCKHJF() {
                this.unk3300OBKEBDCKHJF_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder
            public int getUnk3300DMBNFECAKBH() {
                return this.unk3300DMBNFECAKBH_;
            }

            public Builder setUnk3300DMBNFECAKBH(int value) {
                this.unk3300DMBNFECAKBH_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300DMBNFECAKBH() {
                this.unk3300DMBNFECAKBH_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder
            public int getContentCloseTime() {
                return this.contentCloseTime_;
            }

            public Builder setContentCloseTime(int value) {
                this.contentCloseTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearContentCloseTime() {
                this.contentCloseTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder
            public String getUrl() {
                Object ref = this.url_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.url_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder
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
                this.url_ = H5ActivityInfo.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            public Builder setUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                H5ActivityInfo.checkByteStringIsUtf8(value);
                this.url_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder
            public String getPrefabPath() {
                Object ref = this.prefabPath_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.prefabPath_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder
            public ByteString getPrefabPathBytes() {
                Object ref = this.prefabPath_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.prefabPath_ = b;
                return b;
            }

            public Builder setPrefabPath(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.prefabPath_ = value;
                onChanged();
                return this;
            }

            public Builder clearPrefabPath() {
                this.prefabPath_ = H5ActivityInfo.getDefaultInstance().getPrefabPath();
                onChanged();
                return this;
            }

            public Builder setPrefabPathBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                H5ActivityInfo.checkByteStringIsUtf8(value);
                this.prefabPath_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder
            public int getBeginTime() {
                return this.beginTime_;
            }

            public Builder setBeginTime(int value) {
                this.beginTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearBeginTime() {
                this.beginTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.H5ActivityInfoOuterClass.H5ActivityInfoOrBuilder
            public int getEndTime() {
                return this.endTime_;
            }

            public Builder setEndTime(int value) {
                this.endTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearEndTime() {
                this.endTime_ = 0;
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

        public static H5ActivityInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<H5ActivityInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<H5ActivityInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public H5ActivityInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
