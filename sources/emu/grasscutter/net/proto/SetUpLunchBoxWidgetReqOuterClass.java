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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetUpLunchBoxWidgetReqOuterClass.class */
public final class SetUpLunchBoxWidgetReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cSetUpLunchBoxWidgetReq.proto\u001a\u0012LunchBoxData.proto\"?\n\u0016SetUpLunchBoxWidgetReq\u0012%\n\u000elunch_box_data\u0018\u0007 \u0001(\u000b2\r.LunchBoxDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{LunchBoxDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SetUpLunchBoxWidgetReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SetUpLunchBoxWidgetReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SetUpLunchBoxWidgetReq_descriptor, new String[]{"LunchBoxData"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetUpLunchBoxWidgetReqOuterClass$SetUpLunchBoxWidgetReqOrBuilder.class */
    public interface SetUpLunchBoxWidgetReqOrBuilder extends MessageOrBuilder {
        boolean hasLunchBoxData();

        LunchBoxDataOuterClass.LunchBoxData getLunchBoxData();

        LunchBoxDataOuterClass.LunchBoxDataOrBuilder getLunchBoxDataOrBuilder();
    }

    private SetUpLunchBoxWidgetReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetUpLunchBoxWidgetReqOuterClass$SetUpLunchBoxWidgetReq.class */
    public static final class SetUpLunchBoxWidgetReq extends GeneratedMessageV3 implements SetUpLunchBoxWidgetReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LUNCH_BOX_DATA_FIELD_NUMBER = 7;
        private LunchBoxDataOuterClass.LunchBoxData lunchBoxData_;
        private byte memoizedIsInitialized;
        private static final SetUpLunchBoxWidgetReq DEFAULT_INSTANCE = new SetUpLunchBoxWidgetReq();
        private static final Parser<SetUpLunchBoxWidgetReq> PARSER = new AbstractParser<SetUpLunchBoxWidgetReq>() { // from class: emu.grasscutter.net.proto.SetUpLunchBoxWidgetReqOuterClass.SetUpLunchBoxWidgetReq.1
            @Override // com.google.protobuf.Parser
            public SetUpLunchBoxWidgetReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SetUpLunchBoxWidgetReq(input, extensionRegistry);
            }
        };

        private SetUpLunchBoxWidgetReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SetUpLunchBoxWidgetReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SetUpLunchBoxWidgetReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SetUpLunchBoxWidgetReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 58:
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
            return SetUpLunchBoxWidgetReqOuterClass.internal_static_SetUpLunchBoxWidgetReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SetUpLunchBoxWidgetReqOuterClass.internal_static_SetUpLunchBoxWidgetReq_fieldAccessorTable.ensureFieldAccessorsInitialized(SetUpLunchBoxWidgetReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SetUpLunchBoxWidgetReqOuterClass.SetUpLunchBoxWidgetReqOrBuilder
        public boolean hasLunchBoxData() {
            return this.lunchBoxData_ != null;
        }

        @Override // emu.grasscutter.net.proto.SetUpLunchBoxWidgetReqOuterClass.SetUpLunchBoxWidgetReqOrBuilder
        public LunchBoxDataOuterClass.LunchBoxData getLunchBoxData() {
            return this.lunchBoxData_ == null ? LunchBoxDataOuterClass.LunchBoxData.getDefaultInstance() : this.lunchBoxData_;
        }

        @Override // emu.grasscutter.net.proto.SetUpLunchBoxWidgetReqOuterClass.SetUpLunchBoxWidgetReqOrBuilder
        public LunchBoxDataOuterClass.LunchBoxDataOrBuilder getLunchBoxDataOrBuilder() {
            return getLunchBoxData();
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
            if (this.lunchBoxData_ != null) {
                output.writeMessage(7, getLunchBoxData());
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
            if (this.lunchBoxData_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(7, getLunchBoxData());
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
            if (!(obj instanceof SetUpLunchBoxWidgetReq)) {
                return equals(obj);
            }
            SetUpLunchBoxWidgetReq other = (SetUpLunchBoxWidgetReq) obj;
            if (hasLunchBoxData() != other.hasLunchBoxData()) {
                return false;
            }
            return (!hasLunchBoxData() || getLunchBoxData().equals(other.getLunchBoxData())) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasLunchBoxData()) {
                hash = (53 * ((37 * hash) + 7)) + getLunchBoxData().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SetUpLunchBoxWidgetReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetUpLunchBoxWidgetReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetUpLunchBoxWidgetReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetUpLunchBoxWidgetReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetUpLunchBoxWidgetReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetUpLunchBoxWidgetReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetUpLunchBoxWidgetReq parseFrom(InputStream input) throws IOException {
            return (SetUpLunchBoxWidgetReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetUpLunchBoxWidgetReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetUpLunchBoxWidgetReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetUpLunchBoxWidgetReq parseDelimitedFrom(InputStream input) throws IOException {
            return (SetUpLunchBoxWidgetReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SetUpLunchBoxWidgetReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetUpLunchBoxWidgetReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetUpLunchBoxWidgetReq parseFrom(CodedInputStream input) throws IOException {
            return (SetUpLunchBoxWidgetReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetUpLunchBoxWidgetReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetUpLunchBoxWidgetReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SetUpLunchBoxWidgetReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetUpLunchBoxWidgetReqOuterClass$SetUpLunchBoxWidgetReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SetUpLunchBoxWidgetReqOrBuilder {
            private LunchBoxDataOuterClass.LunchBoxData lunchBoxData_;
            private SingleFieldBuilderV3<LunchBoxDataOuterClass.LunchBoxData, LunchBoxDataOuterClass.LunchBoxData.Builder, LunchBoxDataOuterClass.LunchBoxDataOrBuilder> lunchBoxDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SetUpLunchBoxWidgetReqOuterClass.internal_static_SetUpLunchBoxWidgetReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SetUpLunchBoxWidgetReqOuterClass.internal_static_SetUpLunchBoxWidgetReq_fieldAccessorTable.ensureFieldAccessorsInitialized(SetUpLunchBoxWidgetReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SetUpLunchBoxWidgetReq.alwaysUseFieldBuilders) {
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
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SetUpLunchBoxWidgetReqOuterClass.internal_static_SetUpLunchBoxWidgetReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SetUpLunchBoxWidgetReq getDefaultInstanceForType() {
                return SetUpLunchBoxWidgetReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetUpLunchBoxWidgetReq build() {
                SetUpLunchBoxWidgetReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetUpLunchBoxWidgetReq buildPartial() {
                SetUpLunchBoxWidgetReq result = new SetUpLunchBoxWidgetReq(this);
                if (this.lunchBoxDataBuilder_ == null) {
                    result.lunchBoxData_ = this.lunchBoxData_;
                } else {
                    result.lunchBoxData_ = this.lunchBoxDataBuilder_.build();
                }
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
                if (other instanceof SetUpLunchBoxWidgetReq) {
                    return mergeFrom((SetUpLunchBoxWidgetReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SetUpLunchBoxWidgetReq other) {
                if (other == SetUpLunchBoxWidgetReq.getDefaultInstance()) {
                    return this;
                }
                if (other.hasLunchBoxData()) {
                    mergeLunchBoxData(other.getLunchBoxData());
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
                SetUpLunchBoxWidgetReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = SetUpLunchBoxWidgetReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SetUpLunchBoxWidgetReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SetUpLunchBoxWidgetReqOuterClass.SetUpLunchBoxWidgetReqOrBuilder
            public boolean hasLunchBoxData() {
                return (this.lunchBoxDataBuilder_ == null && this.lunchBoxData_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SetUpLunchBoxWidgetReqOuterClass.SetUpLunchBoxWidgetReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.SetUpLunchBoxWidgetReqOuterClass.SetUpLunchBoxWidgetReqOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static SetUpLunchBoxWidgetReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SetUpLunchBoxWidgetReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SetUpLunchBoxWidgetReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SetUpLunchBoxWidgetReq getDefaultInstanceForType() {
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
