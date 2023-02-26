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
import emu.grasscutter.net.proto.LunchBoxDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetUpLunchBoxWidgetRspOuterClass.class */
public final class SetUpLunchBoxWidgetRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cSetUpLunchBoxWidgetRsp.proto\u001a\u0012LunchBoxData.proto\"N\n\u0016SetUpLunchBoxWidgetRsp\u0012#\n\flunchBoxData\u0018\u000f \u0001(\u000b2\r.LunchBoxData\u0012\u000f\n\u0007retcode\u0018\u0003 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{LunchBoxDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SetUpLunchBoxWidgetRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SetUpLunchBoxWidgetRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SetUpLunchBoxWidgetRsp_descriptor, new String[]{"LunchBoxData", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetUpLunchBoxWidgetRspOuterClass$SetUpLunchBoxWidgetRspOrBuilder.class */
    public interface SetUpLunchBoxWidgetRspOrBuilder extends MessageOrBuilder {
        boolean hasLunchBoxData();

        LunchBoxDataOuterClass.LunchBoxData getLunchBoxData();

        LunchBoxDataOuterClass.LunchBoxDataOrBuilder getLunchBoxDataOrBuilder();

        int getRetcode();
    }

    private SetUpLunchBoxWidgetRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetUpLunchBoxWidgetRspOuterClass$SetUpLunchBoxWidgetRsp.class */
    public static final class SetUpLunchBoxWidgetRsp extends GeneratedMessageV3 implements SetUpLunchBoxWidgetRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LUNCHBOXDATA_FIELD_NUMBER = 15;
        private LunchBoxDataOuterClass.LunchBoxData lunchBoxData_;
        public static final int RETCODE_FIELD_NUMBER = 3;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final SetUpLunchBoxWidgetRsp DEFAULT_INSTANCE = new SetUpLunchBoxWidgetRsp();
        private static final Parser<SetUpLunchBoxWidgetRsp> PARSER = new AbstractParser<SetUpLunchBoxWidgetRsp>() { // from class: emu.grasscutter.net.proto.SetUpLunchBoxWidgetRspOuterClass.SetUpLunchBoxWidgetRsp.1
            @Override // com.google.protobuf.Parser
            public SetUpLunchBoxWidgetRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SetUpLunchBoxWidgetRsp(input, extensionRegistry);
            }
        };

        private SetUpLunchBoxWidgetRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SetUpLunchBoxWidgetRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SetUpLunchBoxWidgetRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SetUpLunchBoxWidgetRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 24:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 122:
                                    LunchBoxDataOuterClass.LunchBoxData.Builder subBuilder = this.lunchBoxData_ != null ? this.lunchBoxData_.toBuilder() : null;
                                    this.lunchBoxData_ = (LunchBoxDataOuterClass.LunchBoxData) input.readMessage(LunchBoxDataOuterClass.LunchBoxData.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.lunchBoxData_);
                                        this.lunchBoxData_ = subBuilder.buildPartial();
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
            return SetUpLunchBoxWidgetRspOuterClass.internal_static_SetUpLunchBoxWidgetRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SetUpLunchBoxWidgetRspOuterClass.internal_static_SetUpLunchBoxWidgetRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(SetUpLunchBoxWidgetRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SetUpLunchBoxWidgetRspOuterClass.SetUpLunchBoxWidgetRspOrBuilder
        public boolean hasLunchBoxData() {
            return this.lunchBoxData_ != null;
        }

        @Override // emu.grasscutter.net.proto.SetUpLunchBoxWidgetRspOuterClass.SetUpLunchBoxWidgetRspOrBuilder
        public LunchBoxDataOuterClass.LunchBoxData getLunchBoxData() {
            return this.lunchBoxData_ == null ? LunchBoxDataOuterClass.LunchBoxData.getDefaultInstance() : this.lunchBoxData_;
        }

        @Override // emu.grasscutter.net.proto.SetUpLunchBoxWidgetRspOuterClass.SetUpLunchBoxWidgetRspOrBuilder
        public LunchBoxDataOuterClass.LunchBoxDataOrBuilder getLunchBoxDataOrBuilder() {
            return getLunchBoxData();
        }

        @Override // emu.grasscutter.net.proto.SetUpLunchBoxWidgetRspOuterClass.SetUpLunchBoxWidgetRspOrBuilder
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
                output.writeInt32(3, this.retcode_);
            }
            if (this.lunchBoxData_ != null) {
                output.writeMessage(15, getLunchBoxData());
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
                size2 = 0 + CodedOutputStream.computeInt32Size(3, this.retcode_);
            }
            if (this.lunchBoxData_ != null) {
                size2 += CodedOutputStream.computeMessageSize(15, getLunchBoxData());
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
            if (!(obj instanceof SetUpLunchBoxWidgetRsp)) {
                return equals(obj);
            }
            SetUpLunchBoxWidgetRsp other = (SetUpLunchBoxWidgetRsp) obj;
            if (hasLunchBoxData() != other.hasLunchBoxData()) {
                return false;
            }
            return (!hasLunchBoxData() || getLunchBoxData().equals(other.getLunchBoxData())) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasLunchBoxData()) {
                hash = (53 * ((37 * hash) + 15)) + getLunchBoxData().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 3)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SetUpLunchBoxWidgetRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetUpLunchBoxWidgetRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetUpLunchBoxWidgetRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetUpLunchBoxWidgetRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetUpLunchBoxWidgetRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetUpLunchBoxWidgetRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetUpLunchBoxWidgetRsp parseFrom(InputStream input) throws IOException {
            return (SetUpLunchBoxWidgetRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetUpLunchBoxWidgetRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetUpLunchBoxWidgetRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetUpLunchBoxWidgetRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (SetUpLunchBoxWidgetRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SetUpLunchBoxWidgetRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetUpLunchBoxWidgetRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetUpLunchBoxWidgetRsp parseFrom(CodedInputStream input) throws IOException {
            return (SetUpLunchBoxWidgetRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetUpLunchBoxWidgetRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetUpLunchBoxWidgetRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SetUpLunchBoxWidgetRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetUpLunchBoxWidgetRspOuterClass$SetUpLunchBoxWidgetRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SetUpLunchBoxWidgetRspOrBuilder {
            private LunchBoxDataOuterClass.LunchBoxData lunchBoxData_;
            private SingleFieldBuilderV3<LunchBoxDataOuterClass.LunchBoxData, LunchBoxDataOuterClass.LunchBoxData.Builder, LunchBoxDataOuterClass.LunchBoxDataOrBuilder> lunchBoxDataBuilder_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SetUpLunchBoxWidgetRspOuterClass.internal_static_SetUpLunchBoxWidgetRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SetUpLunchBoxWidgetRspOuterClass.internal_static_SetUpLunchBoxWidgetRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(SetUpLunchBoxWidgetRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SetUpLunchBoxWidgetRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.lunchBoxDataBuilder_ == null) {
                    this.lunchBoxData_ = null;
                } else {
                    this.lunchBoxData_ = null;
                    this.lunchBoxDataBuilder_ = null;
                }
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SetUpLunchBoxWidgetRspOuterClass.internal_static_SetUpLunchBoxWidgetRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SetUpLunchBoxWidgetRsp getDefaultInstanceForType() {
                return SetUpLunchBoxWidgetRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetUpLunchBoxWidgetRsp build() {
                SetUpLunchBoxWidgetRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetUpLunchBoxWidgetRsp buildPartial() {
                SetUpLunchBoxWidgetRsp result = new SetUpLunchBoxWidgetRsp(this);
                if (this.lunchBoxDataBuilder_ == null) {
                    result.lunchBoxData_ = this.lunchBoxData_;
                } else {
                    result.lunchBoxData_ = this.lunchBoxDataBuilder_.build();
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
                if (other instanceof SetUpLunchBoxWidgetRsp) {
                    return mergeFrom((SetUpLunchBoxWidgetRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SetUpLunchBoxWidgetRsp other) {
                if (other == SetUpLunchBoxWidgetRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.hasLunchBoxData()) {
                    mergeLunchBoxData(other.getLunchBoxData());
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
                SetUpLunchBoxWidgetRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = SetUpLunchBoxWidgetRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SetUpLunchBoxWidgetRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SetUpLunchBoxWidgetRspOuterClass.SetUpLunchBoxWidgetRspOrBuilder
            public boolean hasLunchBoxData() {
                return (this.lunchBoxDataBuilder_ == null && this.lunchBoxData_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SetUpLunchBoxWidgetRspOuterClass.SetUpLunchBoxWidgetRspOrBuilder
            public LunchBoxDataOuterClass.LunchBoxData getLunchBoxData() {
                if (this.lunchBoxDataBuilder_ == null) {
                    return this.lunchBoxData_ == null ? LunchBoxDataOuterClass.LunchBoxData.getDefaultInstance() : this.lunchBoxData_;
                }
                return this.lunchBoxDataBuilder_.getMessage();
            }

            public Builder setLunchBoxData(LunchBoxDataOuterClass.LunchBoxData value) {
                if (this.lunchBoxDataBuilder_ != null) {
                    this.lunchBoxDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.lunchBoxData_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setLunchBoxData(LunchBoxDataOuterClass.LunchBoxData.Builder builderForValue) {
                if (this.lunchBoxDataBuilder_ == null) {
                    this.lunchBoxData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.lunchBoxDataBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeLunchBoxData(LunchBoxDataOuterClass.LunchBoxData value) {
                if (this.lunchBoxDataBuilder_ == null) {
                    if (this.lunchBoxData_ != null) {
                        this.lunchBoxData_ = LunchBoxDataOuterClass.LunchBoxData.newBuilder(this.lunchBoxData_).mergeFrom(value).buildPartial();
                    } else {
                        this.lunchBoxData_ = value;
                    }
                    onChanged();
                } else {
                    this.lunchBoxDataBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearLunchBoxData() {
                if (this.lunchBoxDataBuilder_ == null) {
                    this.lunchBoxData_ = null;
                    onChanged();
                } else {
                    this.lunchBoxData_ = null;
                    this.lunchBoxDataBuilder_ = null;
                }
                return this;
            }

            public LunchBoxDataOuterClass.LunchBoxData.Builder getLunchBoxDataBuilder() {
                onChanged();
                return getLunchBoxDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SetUpLunchBoxWidgetRspOuterClass.SetUpLunchBoxWidgetRspOrBuilder
            public LunchBoxDataOuterClass.LunchBoxDataOrBuilder getLunchBoxDataOrBuilder() {
                if (this.lunchBoxDataBuilder_ != null) {
                    return this.lunchBoxDataBuilder_.getMessageOrBuilder();
                }
                return this.lunchBoxData_ == null ? LunchBoxDataOuterClass.LunchBoxData.getDefaultInstance() : this.lunchBoxData_;
            }

            private SingleFieldBuilderV3<LunchBoxDataOuterClass.LunchBoxData, LunchBoxDataOuterClass.LunchBoxData.Builder, LunchBoxDataOuterClass.LunchBoxDataOrBuilder> getLunchBoxDataFieldBuilder() {
                if (this.lunchBoxDataBuilder_ == null) {
                    this.lunchBoxDataBuilder_ = new SingleFieldBuilderV3<>(getLunchBoxData(), getParentForChildren(), isClean());
                    this.lunchBoxData_ = null;
                }
                return this.lunchBoxDataBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SetUpLunchBoxWidgetRspOuterClass.SetUpLunchBoxWidgetRspOrBuilder
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

        public static SetUpLunchBoxWidgetRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SetUpLunchBoxWidgetRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SetUpLunchBoxWidgetRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SetUpLunchBoxWidgetRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        LunchBoxDataOuterClass.getDescriptor();
    }
}
