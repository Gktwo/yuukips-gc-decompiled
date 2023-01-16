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
import emu.grasscutter.net.proto.WidgetGadgetDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetGadgetDataNotifyOuterClass.class */
public final class WidgetGadgetDataNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cWidgetGadgetDataNotify.proto\u001a\u0016WidgetGadgetData.proto\"G\n\u0016WidgetGadgetDataNotify\u0012-\n\u0012widget_gadget_data\u0018\u0003 \u0001(\u000b2\u0011.WidgetGadgetDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{WidgetGadgetDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WidgetGadgetDataNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WidgetGadgetDataNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WidgetGadgetDataNotify_descriptor, new String[]{"WidgetGadgetData"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetGadgetDataNotifyOuterClass$WidgetGadgetDataNotifyOrBuilder.class */
    public interface WidgetGadgetDataNotifyOrBuilder extends MessageOrBuilder {
        boolean hasWidgetGadgetData();

        WidgetGadgetDataOuterClass.WidgetGadgetData getWidgetGadgetData();

        WidgetGadgetDataOuterClass.WidgetGadgetDataOrBuilder getWidgetGadgetDataOrBuilder();
    }

    private WidgetGadgetDataNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetGadgetDataNotifyOuterClass$WidgetGadgetDataNotify.class */
    public static final class WidgetGadgetDataNotify extends GeneratedMessageV3 implements WidgetGadgetDataNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int WIDGET_GADGET_DATA_FIELD_NUMBER = 3;
        private WidgetGadgetDataOuterClass.WidgetGadgetData widgetGadgetData_;
        private byte memoizedIsInitialized;
        private static final WidgetGadgetDataNotify DEFAULT_INSTANCE = new WidgetGadgetDataNotify();
        private static final Parser<WidgetGadgetDataNotify> PARSER = new AbstractParser<WidgetGadgetDataNotify>() { // from class: emu.grasscutter.net.proto.WidgetGadgetDataNotifyOuterClass.WidgetGadgetDataNotify.1
            @Override // com.google.protobuf.Parser
            public WidgetGadgetDataNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WidgetGadgetDataNotify(input, extensionRegistry);
            }
        };

        private WidgetGadgetDataNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WidgetGadgetDataNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WidgetGadgetDataNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WidgetGadgetDataNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 26:
                                WidgetGadgetDataOuterClass.WidgetGadgetData.Builder subBuilder = this.widgetGadgetData_ != null ? this.widgetGadgetData_.toBuilder() : null;
                                this.widgetGadgetData_ = (WidgetGadgetDataOuterClass.WidgetGadgetData) input.readMessage(WidgetGadgetDataOuterClass.WidgetGadgetData.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.widgetGadgetData_);
                                    this.widgetGadgetData_ = subBuilder.buildPartial();
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
            return WidgetGadgetDataNotifyOuterClass.internal_static_WidgetGadgetDataNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WidgetGadgetDataNotifyOuterClass.internal_static_WidgetGadgetDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WidgetGadgetDataNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WidgetGadgetDataNotifyOuterClass.WidgetGadgetDataNotifyOrBuilder
        public boolean hasWidgetGadgetData() {
            return this.widgetGadgetData_ != null;
        }

        @Override // emu.grasscutter.net.proto.WidgetGadgetDataNotifyOuterClass.WidgetGadgetDataNotifyOrBuilder
        public WidgetGadgetDataOuterClass.WidgetGadgetData getWidgetGadgetData() {
            return this.widgetGadgetData_ == null ? WidgetGadgetDataOuterClass.WidgetGadgetData.getDefaultInstance() : this.widgetGadgetData_;
        }

        @Override // emu.grasscutter.net.proto.WidgetGadgetDataNotifyOuterClass.WidgetGadgetDataNotifyOrBuilder
        public WidgetGadgetDataOuterClass.WidgetGadgetDataOrBuilder getWidgetGadgetDataOrBuilder() {
            return getWidgetGadgetData();
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
            if (this.widgetGadgetData_ != null) {
                output.writeMessage(3, getWidgetGadgetData());
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
            if (this.widgetGadgetData_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(3, getWidgetGadgetData());
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
            if (!(obj instanceof WidgetGadgetDataNotify)) {
                return equals(obj);
            }
            WidgetGadgetDataNotify other = (WidgetGadgetDataNotify) obj;
            if (hasWidgetGadgetData() != other.hasWidgetGadgetData()) {
                return false;
            }
            return (!hasWidgetGadgetData() || getWidgetGadgetData().equals(other.getWidgetGadgetData())) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasWidgetGadgetData()) {
                hash = (53 * ((37 * hash) + 3)) + getWidgetGadgetData().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WidgetGadgetDataNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetGadgetDataNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetGadgetDataNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetGadgetDataNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetGadgetDataNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetGadgetDataNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetGadgetDataNotify parseFrom(InputStream input) throws IOException {
            return (WidgetGadgetDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WidgetGadgetDataNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetGadgetDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WidgetGadgetDataNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (WidgetGadgetDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WidgetGadgetDataNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetGadgetDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WidgetGadgetDataNotify parseFrom(CodedInputStream input) throws IOException {
            return (WidgetGadgetDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WidgetGadgetDataNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetGadgetDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WidgetGadgetDataNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetGadgetDataNotifyOuterClass$WidgetGadgetDataNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WidgetGadgetDataNotifyOrBuilder {
            private WidgetGadgetDataOuterClass.WidgetGadgetData widgetGadgetData_;
            private SingleFieldBuilderV3<WidgetGadgetDataOuterClass.WidgetGadgetData, WidgetGadgetDataOuterClass.WidgetGadgetData.Builder, WidgetGadgetDataOuterClass.WidgetGadgetDataOrBuilder> widgetGadgetDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WidgetGadgetDataNotifyOuterClass.internal_static_WidgetGadgetDataNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WidgetGadgetDataNotifyOuterClass.internal_static_WidgetGadgetDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WidgetGadgetDataNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WidgetGadgetDataNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.widgetGadgetDataBuilder_ == null) {
                    this.widgetGadgetData_ = null;
                } else {
                    this.widgetGadgetData_ = null;
                    this.widgetGadgetDataBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WidgetGadgetDataNotifyOuterClass.internal_static_WidgetGadgetDataNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WidgetGadgetDataNotify getDefaultInstanceForType() {
                return WidgetGadgetDataNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WidgetGadgetDataNotify build() {
                WidgetGadgetDataNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WidgetGadgetDataNotify buildPartial() {
                WidgetGadgetDataNotify result = new WidgetGadgetDataNotify(this);
                if (this.widgetGadgetDataBuilder_ == null) {
                    result.widgetGadgetData_ = this.widgetGadgetData_;
                } else {
                    result.widgetGadgetData_ = this.widgetGadgetDataBuilder_.build();
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
                if (other instanceof WidgetGadgetDataNotify) {
                    return mergeFrom((WidgetGadgetDataNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WidgetGadgetDataNotify other) {
                if (other == WidgetGadgetDataNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasWidgetGadgetData()) {
                    mergeWidgetGadgetData(other.getWidgetGadgetData());
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
                WidgetGadgetDataNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = WidgetGadgetDataNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WidgetGadgetDataNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.WidgetGadgetDataNotifyOuterClass.WidgetGadgetDataNotifyOrBuilder
            public boolean hasWidgetGadgetData() {
                return (this.widgetGadgetDataBuilder_ == null && this.widgetGadgetData_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.WidgetGadgetDataNotifyOuterClass.WidgetGadgetDataNotifyOrBuilder
            public WidgetGadgetDataOuterClass.WidgetGadgetData getWidgetGadgetData() {
                if (this.widgetGadgetDataBuilder_ == null) {
                    return this.widgetGadgetData_ == null ? WidgetGadgetDataOuterClass.WidgetGadgetData.getDefaultInstance() : this.widgetGadgetData_;
                }
                return this.widgetGadgetDataBuilder_.getMessage();
            }

            public Builder setWidgetGadgetData(WidgetGadgetDataOuterClass.WidgetGadgetData value) {
                if (this.widgetGadgetDataBuilder_ != null) {
                    this.widgetGadgetDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.widgetGadgetData_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setWidgetGadgetData(WidgetGadgetDataOuterClass.WidgetGadgetData.Builder builderForValue) {
                if (this.widgetGadgetDataBuilder_ == null) {
                    this.widgetGadgetData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.widgetGadgetDataBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeWidgetGadgetData(WidgetGadgetDataOuterClass.WidgetGadgetData value) {
                if (this.widgetGadgetDataBuilder_ == null) {
                    if (this.widgetGadgetData_ != null) {
                        this.widgetGadgetData_ = WidgetGadgetDataOuterClass.WidgetGadgetData.newBuilder(this.widgetGadgetData_).mergeFrom(value).buildPartial();
                    } else {
                        this.widgetGadgetData_ = value;
                    }
                    onChanged();
                } else {
                    this.widgetGadgetDataBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearWidgetGadgetData() {
                if (this.widgetGadgetDataBuilder_ == null) {
                    this.widgetGadgetData_ = null;
                    onChanged();
                } else {
                    this.widgetGadgetData_ = null;
                    this.widgetGadgetDataBuilder_ = null;
                }
                return this;
            }

            public WidgetGadgetDataOuterClass.WidgetGadgetData.Builder getWidgetGadgetDataBuilder() {
                onChanged();
                return getWidgetGadgetDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.WidgetGadgetDataNotifyOuterClass.WidgetGadgetDataNotifyOrBuilder
            public WidgetGadgetDataOuterClass.WidgetGadgetDataOrBuilder getWidgetGadgetDataOrBuilder() {
                if (this.widgetGadgetDataBuilder_ != null) {
                    return this.widgetGadgetDataBuilder_.getMessageOrBuilder();
                }
                return this.widgetGadgetData_ == null ? WidgetGadgetDataOuterClass.WidgetGadgetData.getDefaultInstance() : this.widgetGadgetData_;
            }

            private SingleFieldBuilderV3<WidgetGadgetDataOuterClass.WidgetGadgetData, WidgetGadgetDataOuterClass.WidgetGadgetData.Builder, WidgetGadgetDataOuterClass.WidgetGadgetDataOrBuilder> getWidgetGadgetDataFieldBuilder() {
                if (this.widgetGadgetDataBuilder_ == null) {
                    this.widgetGadgetDataBuilder_ = new SingleFieldBuilderV3<>(getWidgetGadgetData(), getParentForChildren(), isClean());
                    this.widgetGadgetData_ = null;
                }
                return this.widgetGadgetDataBuilder_;
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

        public static WidgetGadgetDataNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WidgetGadgetDataNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WidgetGadgetDataNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WidgetGadgetDataNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        WidgetGadgetDataOuterClass.getDescriptor();
    }
}
