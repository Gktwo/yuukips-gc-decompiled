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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampAcceptGiveItemRspOuterClass.class */
public final class WinterCampAcceptGiveItemRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!WinterCampAcceptGiveItemRsp.proto\u001a$WinterCampAcceptItemResultInfo.proto\"p\n\u001bWinterCampAcceptGiveItemRsp\u0012@\n\u0017accept_item_result_info\u0018\u000f \u0001(\u000b2\u001f.WinterCampAcceptItemResultInfo\u0012\u000f\n\u0007retcode\u0018\u0006 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{WinterCampAcceptItemResultInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WinterCampAcceptGiveItemRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WinterCampAcceptGiveItemRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WinterCampAcceptGiveItemRsp_descriptor, new String[]{"AcceptItemResultInfo", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampAcceptGiveItemRspOuterClass$WinterCampAcceptGiveItemRspOrBuilder.class */
    public interface WinterCampAcceptGiveItemRspOrBuilder extends MessageOrBuilder {
        boolean hasAcceptItemResultInfo();

        WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo getAcceptItemResultInfo();

        WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder getAcceptItemResultInfoOrBuilder();

        int getRetcode();
    }

    private WinterCampAcceptGiveItemRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampAcceptGiveItemRspOuterClass$WinterCampAcceptGiveItemRsp.class */
    public static final class WinterCampAcceptGiveItemRsp extends GeneratedMessageV3 implements WinterCampAcceptGiveItemRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ACCEPT_ITEM_RESULT_INFO_FIELD_NUMBER = 15;
        private WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo acceptItemResultInfo_;
        public static final int RETCODE_FIELD_NUMBER = 6;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final WinterCampAcceptGiveItemRsp DEFAULT_INSTANCE = new WinterCampAcceptGiveItemRsp();
        private static final Parser<WinterCampAcceptGiveItemRsp> PARSER = new AbstractParser<WinterCampAcceptGiveItemRsp>() { // from class: emu.grasscutter.net.proto.WinterCampAcceptGiveItemRspOuterClass.WinterCampAcceptGiveItemRsp.1
            @Override // com.google.protobuf.Parser
            public WinterCampAcceptGiveItemRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WinterCampAcceptGiveItemRsp(input, extensionRegistry);
            }
        };

        private WinterCampAcceptGiveItemRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WinterCampAcceptGiveItemRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WinterCampAcceptGiveItemRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WinterCampAcceptGiveItemRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 48:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 122:
                                    WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.Builder subBuilder = this.acceptItemResultInfo_ != null ? this.acceptItemResultInfo_.toBuilder() : null;
                                    this.acceptItemResultInfo_ = (WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo) input.readMessage(WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.acceptItemResultInfo_);
                                        this.acceptItemResultInfo_ = subBuilder.buildPartial();
                                        break;
                                    }
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
            return WinterCampAcceptGiveItemRspOuterClass.internal_static_WinterCampAcceptGiveItemRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WinterCampAcceptGiveItemRspOuterClass.internal_static_WinterCampAcceptGiveItemRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(WinterCampAcceptGiveItemRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WinterCampAcceptGiveItemRspOuterClass.WinterCampAcceptGiveItemRspOrBuilder
        public boolean hasAcceptItemResultInfo() {
            return this.acceptItemResultInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.WinterCampAcceptGiveItemRspOuterClass.WinterCampAcceptGiveItemRspOrBuilder
        public WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo getAcceptItemResultInfo() {
            return this.acceptItemResultInfo_ == null ? WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.getDefaultInstance() : this.acceptItemResultInfo_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampAcceptGiveItemRspOuterClass.WinterCampAcceptGiveItemRspOrBuilder
        public WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder getAcceptItemResultInfoOrBuilder() {
            return getAcceptItemResultInfo();
        }

        @Override // emu.grasscutter.net.proto.WinterCampAcceptGiveItemRspOuterClass.WinterCampAcceptGiveItemRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
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
                output.writeInt32(6, this.retcode_);
            }
            if (this.acceptItemResultInfo_ != null) {
                output.writeMessage(15, getAcceptItemResultInfo());
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
                size2 = 0 + CodedOutputStream.computeInt32Size(6, this.retcode_);
            }
            if (this.acceptItemResultInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(15, getAcceptItemResultInfo());
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
            if (!(obj instanceof WinterCampAcceptGiveItemRsp)) {
                return equals(obj);
            }
            WinterCampAcceptGiveItemRsp other = (WinterCampAcceptGiveItemRsp) obj;
            if (hasAcceptItemResultInfo() != other.hasAcceptItemResultInfo()) {
                return false;
            }
            return (!hasAcceptItemResultInfo() || getAcceptItemResultInfo().equals(other.getAcceptItemResultInfo())) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasAcceptItemResultInfo()) {
                hash = (53 * ((37 * hash) + 15)) + getAcceptItemResultInfo().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 6)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WinterCampAcceptGiveItemRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampAcceptGiveItemRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampAcceptGiveItemRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampAcceptGiveItemRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampAcceptGiveItemRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampAcceptGiveItemRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampAcceptGiveItemRsp parseFrom(InputStream input) throws IOException {
            return (WinterCampAcceptGiveItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WinterCampAcceptGiveItemRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampAcceptGiveItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WinterCampAcceptGiveItemRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (WinterCampAcceptGiveItemRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WinterCampAcceptGiveItemRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampAcceptGiveItemRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WinterCampAcceptGiveItemRsp parseFrom(CodedInputStream input) throws IOException {
            return (WinterCampAcceptGiveItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WinterCampAcceptGiveItemRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampAcceptGiveItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WinterCampAcceptGiveItemRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampAcceptGiveItemRspOuterClass$WinterCampAcceptGiveItemRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WinterCampAcceptGiveItemRspOrBuilder {
            private WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo acceptItemResultInfo_;
            private SingleFieldBuilderV3<WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo, WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.Builder, WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder> acceptItemResultInfoBuilder_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WinterCampAcceptGiveItemRspOuterClass.internal_static_WinterCampAcceptGiveItemRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WinterCampAcceptGiveItemRspOuterClass.internal_static_WinterCampAcceptGiveItemRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(WinterCampAcceptGiveItemRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WinterCampAcceptGiveItemRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.acceptItemResultInfoBuilder_ == null) {
                    this.acceptItemResultInfo_ = null;
                } else {
                    this.acceptItemResultInfo_ = null;
                    this.acceptItemResultInfoBuilder_ = null;
                }
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WinterCampAcceptGiveItemRspOuterClass.internal_static_WinterCampAcceptGiveItemRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WinterCampAcceptGiveItemRsp getDefaultInstanceForType() {
                return WinterCampAcceptGiveItemRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WinterCampAcceptGiveItemRsp build() {
                WinterCampAcceptGiveItemRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WinterCampAcceptGiveItemRsp buildPartial() {
                WinterCampAcceptGiveItemRsp result = new WinterCampAcceptGiveItemRsp(this);
                if (this.acceptItemResultInfoBuilder_ == null) {
                    result.acceptItemResultInfo_ = this.acceptItemResultInfo_;
                } else {
                    result.acceptItemResultInfo_ = this.acceptItemResultInfoBuilder_.build();
                }
                result.retcode_ = this.retcode_;
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
                if (other instanceof WinterCampAcceptGiveItemRsp) {
                    return mergeFrom((WinterCampAcceptGiveItemRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WinterCampAcceptGiveItemRsp other) {
                if (other == WinterCampAcceptGiveItemRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.hasAcceptItemResultInfo()) {
                    mergeAcceptItemResultInfo(other.getAcceptItemResultInfo());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                WinterCampAcceptGiveItemRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = WinterCampAcceptGiveItemRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WinterCampAcceptGiveItemRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampAcceptGiveItemRspOuterClass.WinterCampAcceptGiveItemRspOrBuilder
            public boolean hasAcceptItemResultInfo() {
                return (this.acceptItemResultInfoBuilder_ == null && this.acceptItemResultInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.WinterCampAcceptGiveItemRspOuterClass.WinterCampAcceptGiveItemRspOrBuilder
            public WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo getAcceptItemResultInfo() {
                if (this.acceptItemResultInfoBuilder_ == null) {
                    return this.acceptItemResultInfo_ == null ? WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.getDefaultInstance() : this.acceptItemResultInfo_;
                }
                return this.acceptItemResultInfoBuilder_.getMessage();
            }

            public Builder setAcceptItemResultInfo(WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo value) {
                if (this.acceptItemResultInfoBuilder_ != null) {
                    this.acceptItemResultInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.acceptItemResultInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setAcceptItemResultInfo(WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.Builder builderForValue) {
                if (this.acceptItemResultInfoBuilder_ == null) {
                    this.acceptItemResultInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.acceptItemResultInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeAcceptItemResultInfo(WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo value) {
                if (this.acceptItemResultInfoBuilder_ == null) {
                    if (this.acceptItemResultInfo_ != null) {
                        this.acceptItemResultInfo_ = WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.newBuilder(this.acceptItemResultInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.acceptItemResultInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.acceptItemResultInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearAcceptItemResultInfo() {
                if (this.acceptItemResultInfoBuilder_ == null) {
                    this.acceptItemResultInfo_ = null;
                    onChanged();
                } else {
                    this.acceptItemResultInfo_ = null;
                    this.acceptItemResultInfoBuilder_ = null;
                }
                return this;
            }

            public WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.Builder getAcceptItemResultInfoBuilder() {
                onChanged();
                return getAcceptItemResultInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.WinterCampAcceptGiveItemRspOuterClass.WinterCampAcceptGiveItemRspOrBuilder
            public WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder getAcceptItemResultInfoOrBuilder() {
                if (this.acceptItemResultInfoBuilder_ != null) {
                    return this.acceptItemResultInfoBuilder_.getMessageOrBuilder();
                }
                return this.acceptItemResultInfo_ == null ? WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.getDefaultInstance() : this.acceptItemResultInfo_;
            }

            private SingleFieldBuilderV3<WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo, WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.Builder, WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder> getAcceptItemResultInfoFieldBuilder() {
                if (this.acceptItemResultInfoBuilder_ == null) {
                    this.acceptItemResultInfoBuilder_ = new SingleFieldBuilderV3<>(getAcceptItemResultInfo(), getParentForChildren(), isClean());
                    this.acceptItemResultInfo_ = null;
                }
                return this.acceptItemResultInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.WinterCampAcceptGiveItemRspOuterClass.WinterCampAcceptGiveItemRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static WinterCampAcceptGiveItemRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WinterCampAcceptGiveItemRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WinterCampAcceptGiveItemRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WinterCampAcceptGiveItemRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        WinterCampAcceptItemResultInfoOuterClass.getDescriptor();
    }
}
