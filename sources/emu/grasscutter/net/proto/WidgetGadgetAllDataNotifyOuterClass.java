package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.WidgetGadgetDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetGadgetAllDataNotifyOuterClass.class */
public final class WidgetGadgetAllDataNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fWidgetGadgetAllDataNotify.proto\u001a\u0016WidgetGadgetData.proto\"H\n\u0019WidgetGadgetAllDataNotify\u0012+\n\u0010widgetGadgetData\u0018\u0004 \u0003(\u000b2\u0011.WidgetGadgetDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{WidgetGadgetDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WidgetGadgetAllDataNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WidgetGadgetAllDataNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WidgetGadgetAllDataNotify_descriptor, new String[]{"WidgetGadgetData"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetGadgetAllDataNotifyOuterClass$WidgetGadgetAllDataNotifyOrBuilder.class */
    public interface WidgetGadgetAllDataNotifyOrBuilder extends MessageOrBuilder {
        List<WidgetGadgetDataOuterClass.WidgetGadgetData> getWidgetGadgetDataList();

        WidgetGadgetDataOuterClass.WidgetGadgetData getWidgetGadgetData(int i);

        int getWidgetGadgetDataCount();

        List<? extends WidgetGadgetDataOuterClass.WidgetGadgetDataOrBuilder> getWidgetGadgetDataOrBuilderList();

        WidgetGadgetDataOuterClass.WidgetGadgetDataOrBuilder getWidgetGadgetDataOrBuilder(int i);
    }

    private WidgetGadgetAllDataNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetGadgetAllDataNotifyOuterClass$WidgetGadgetAllDataNotify.class */
    public static final class WidgetGadgetAllDataNotify extends GeneratedMessageV3 implements WidgetGadgetAllDataNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int WIDGETGADGETDATA_FIELD_NUMBER = 4;
        private List<WidgetGadgetDataOuterClass.WidgetGadgetData> widgetGadgetData_;
        private byte memoizedIsInitialized;
        private static final WidgetGadgetAllDataNotify DEFAULT_INSTANCE = new WidgetGadgetAllDataNotify();
        private static final Parser<WidgetGadgetAllDataNotify> PARSER = new AbstractParser<WidgetGadgetAllDataNotify>() { // from class: emu.grasscutter.net.proto.WidgetGadgetAllDataNotifyOuterClass.WidgetGadgetAllDataNotify.1
            @Override // com.google.protobuf.Parser
            public WidgetGadgetAllDataNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WidgetGadgetAllDataNotify(input, extensionRegistry);
            }
        };

        private WidgetGadgetAllDataNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WidgetGadgetAllDataNotify() {
            this.memoizedIsInitialized = -1;
            this.widgetGadgetData_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WidgetGadgetAllDataNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WidgetGadgetAllDataNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_;
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                mutable_bitField0_ = 0;
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
                                case 34:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.widgetGadgetData_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.widgetGadgetData_.add((WidgetGadgetDataOuterClass.WidgetGadgetData) input.readMessage(WidgetGadgetDataOuterClass.WidgetGadgetData.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.widgetGadgetData_ = Collections.unmodifiableList(this.widgetGadgetData_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WidgetGadgetAllDataNotifyOuterClass.internal_static_WidgetGadgetAllDataNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WidgetGadgetAllDataNotifyOuterClass.internal_static_WidgetGadgetAllDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WidgetGadgetAllDataNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WidgetGadgetAllDataNotifyOuterClass.WidgetGadgetAllDataNotifyOrBuilder
        public List<WidgetGadgetDataOuterClass.WidgetGadgetData> getWidgetGadgetDataList() {
            return this.widgetGadgetData_;
        }

        @Override // emu.grasscutter.net.proto.WidgetGadgetAllDataNotifyOuterClass.WidgetGadgetAllDataNotifyOrBuilder
        public List<? extends WidgetGadgetDataOuterClass.WidgetGadgetDataOrBuilder> getWidgetGadgetDataOrBuilderList() {
            return this.widgetGadgetData_;
        }

        @Override // emu.grasscutter.net.proto.WidgetGadgetAllDataNotifyOuterClass.WidgetGadgetAllDataNotifyOrBuilder
        public int getWidgetGadgetDataCount() {
            return this.widgetGadgetData_.size();
        }

        @Override // emu.grasscutter.net.proto.WidgetGadgetAllDataNotifyOuterClass.WidgetGadgetAllDataNotifyOrBuilder
        public WidgetGadgetDataOuterClass.WidgetGadgetData getWidgetGadgetData(int index) {
            return this.widgetGadgetData_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WidgetGadgetAllDataNotifyOuterClass.WidgetGadgetAllDataNotifyOrBuilder
        public WidgetGadgetDataOuterClass.WidgetGadgetDataOrBuilder getWidgetGadgetDataOrBuilder(int index) {
            return this.widgetGadgetData_.get(index);
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
            for (int i = 0; i < this.widgetGadgetData_.size(); i++) {
                output.writeMessage(4, this.widgetGadgetData_.get(i));
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
            for (int i = 0; i < this.widgetGadgetData_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.widgetGadgetData_.get(i));
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
            if (!(obj instanceof WidgetGadgetAllDataNotify)) {
                return equals(obj);
            }
            WidgetGadgetAllDataNotify other = (WidgetGadgetAllDataNotify) obj;
            return getWidgetGadgetDataList().equals(other.getWidgetGadgetDataList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getWidgetGadgetDataCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getWidgetGadgetDataList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WidgetGadgetAllDataNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetGadgetAllDataNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetGadgetAllDataNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetGadgetAllDataNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetGadgetAllDataNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetGadgetAllDataNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetGadgetAllDataNotify parseFrom(InputStream input) throws IOException {
            return (WidgetGadgetAllDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WidgetGadgetAllDataNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetGadgetAllDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WidgetGadgetAllDataNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (WidgetGadgetAllDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WidgetGadgetAllDataNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetGadgetAllDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WidgetGadgetAllDataNotify parseFrom(CodedInputStream input) throws IOException {
            return (WidgetGadgetAllDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WidgetGadgetAllDataNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetGadgetAllDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WidgetGadgetAllDataNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetGadgetAllDataNotifyOuterClass$WidgetGadgetAllDataNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WidgetGadgetAllDataNotifyOrBuilder {
            private int bitField0_;
            private List<WidgetGadgetDataOuterClass.WidgetGadgetData> widgetGadgetData_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<WidgetGadgetDataOuterClass.WidgetGadgetData, WidgetGadgetDataOuterClass.WidgetGadgetData.Builder, WidgetGadgetDataOuterClass.WidgetGadgetDataOrBuilder> widgetGadgetDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WidgetGadgetAllDataNotifyOuterClass.internal_static_WidgetGadgetAllDataNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WidgetGadgetAllDataNotifyOuterClass.internal_static_WidgetGadgetAllDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WidgetGadgetAllDataNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WidgetGadgetAllDataNotify.alwaysUseFieldBuilders) {
                    getWidgetGadgetDataFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.widgetGadgetDataBuilder_ == null) {
                    this.widgetGadgetData_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.widgetGadgetDataBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WidgetGadgetAllDataNotifyOuterClass.internal_static_WidgetGadgetAllDataNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WidgetGadgetAllDataNotify getDefaultInstanceForType() {
                return WidgetGadgetAllDataNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WidgetGadgetAllDataNotify build() {
                WidgetGadgetAllDataNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WidgetGadgetAllDataNotify buildPartial() {
                WidgetGadgetAllDataNotify result = new WidgetGadgetAllDataNotify(this);
                int i = this.bitField0_;
                if (this.widgetGadgetDataBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.widgetGadgetData_ = Collections.unmodifiableList(this.widgetGadgetData_);
                        this.bitField0_ &= -2;
                    }
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
                if (other instanceof WidgetGadgetAllDataNotify) {
                    return mergeFrom((WidgetGadgetAllDataNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WidgetGadgetAllDataNotify other) {
                if (other == WidgetGadgetAllDataNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.widgetGadgetDataBuilder_ == null) {
                    if (!other.widgetGadgetData_.isEmpty()) {
                        if (this.widgetGadgetData_.isEmpty()) {
                            this.widgetGadgetData_ = other.widgetGadgetData_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureWidgetGadgetDataIsMutable();
                            this.widgetGadgetData_.addAll(other.widgetGadgetData_);
                        }
                        onChanged();
                    }
                } else if (!other.widgetGadgetData_.isEmpty()) {
                    if (this.widgetGadgetDataBuilder_.isEmpty()) {
                        this.widgetGadgetDataBuilder_.dispose();
                        this.widgetGadgetDataBuilder_ = null;
                        this.widgetGadgetData_ = other.widgetGadgetData_;
                        this.bitField0_ &= -2;
                        this.widgetGadgetDataBuilder_ = WidgetGadgetAllDataNotify.alwaysUseFieldBuilders ? getWidgetGadgetDataFieldBuilder() : null;
                    } else {
                        this.widgetGadgetDataBuilder_.addAllMessages(other.widgetGadgetData_);
                    }
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
                WidgetGadgetAllDataNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = WidgetGadgetAllDataNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WidgetGadgetAllDataNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureWidgetGadgetDataIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.widgetGadgetData_ = new ArrayList(this.widgetGadgetData_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.WidgetGadgetAllDataNotifyOuterClass.WidgetGadgetAllDataNotifyOrBuilder
            public List<WidgetGadgetDataOuterClass.WidgetGadgetData> getWidgetGadgetDataList() {
                if (this.widgetGadgetDataBuilder_ == null) {
                    return Collections.unmodifiableList(this.widgetGadgetData_);
                }
                return this.widgetGadgetDataBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.WidgetGadgetAllDataNotifyOuterClass.WidgetGadgetAllDataNotifyOrBuilder
            public int getWidgetGadgetDataCount() {
                if (this.widgetGadgetDataBuilder_ == null) {
                    return this.widgetGadgetData_.size();
                }
                return this.widgetGadgetDataBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.WidgetGadgetAllDataNotifyOuterClass.WidgetGadgetAllDataNotifyOrBuilder
            public WidgetGadgetDataOuterClass.WidgetGadgetData getWidgetGadgetData(int index) {
                if (this.widgetGadgetDataBuilder_ == null) {
                    return this.widgetGadgetData_.get(index);
                }
                return this.widgetGadgetDataBuilder_.getMessage(index);
            }

            public Builder setWidgetGadgetData(int index, WidgetGadgetDataOuterClass.WidgetGadgetData value) {
                if (this.widgetGadgetDataBuilder_ != null) {
                    this.widgetGadgetDataBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureWidgetGadgetDataIsMutable();
                    this.widgetGadgetData_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setWidgetGadgetData(int index, WidgetGadgetDataOuterClass.WidgetGadgetData.Builder builderForValue) {
                if (this.widgetGadgetDataBuilder_ == null) {
                    ensureWidgetGadgetDataIsMutable();
                    this.widgetGadgetData_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.widgetGadgetDataBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addWidgetGadgetData(WidgetGadgetDataOuterClass.WidgetGadgetData value) {
                if (this.widgetGadgetDataBuilder_ != null) {
                    this.widgetGadgetDataBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureWidgetGadgetDataIsMutable();
                    this.widgetGadgetData_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addWidgetGadgetData(int index, WidgetGadgetDataOuterClass.WidgetGadgetData value) {
                if (this.widgetGadgetDataBuilder_ != null) {
                    this.widgetGadgetDataBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureWidgetGadgetDataIsMutable();
                    this.widgetGadgetData_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addWidgetGadgetData(WidgetGadgetDataOuterClass.WidgetGadgetData.Builder builderForValue) {
                if (this.widgetGadgetDataBuilder_ == null) {
                    ensureWidgetGadgetDataIsMutable();
                    this.widgetGadgetData_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.widgetGadgetDataBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addWidgetGadgetData(int index, WidgetGadgetDataOuterClass.WidgetGadgetData.Builder builderForValue) {
                if (this.widgetGadgetDataBuilder_ == null) {
                    ensureWidgetGadgetDataIsMutable();
                    this.widgetGadgetData_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.widgetGadgetDataBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllWidgetGadgetData(Iterable<? extends WidgetGadgetDataOuterClass.WidgetGadgetData> values) {
                if (this.widgetGadgetDataBuilder_ == null) {
                    ensureWidgetGadgetDataIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.widgetGadgetData_);
                    onChanged();
                } else {
                    this.widgetGadgetDataBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearWidgetGadgetData() {
                if (this.widgetGadgetDataBuilder_ == null) {
                    this.widgetGadgetData_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.widgetGadgetDataBuilder_.clear();
                }
                return this;
            }

            public Builder removeWidgetGadgetData(int index) {
                if (this.widgetGadgetDataBuilder_ == null) {
                    ensureWidgetGadgetDataIsMutable();
                    this.widgetGadgetData_.remove(index);
                    onChanged();
                } else {
                    this.widgetGadgetDataBuilder_.remove(index);
                }
                return this;
            }

            public WidgetGadgetDataOuterClass.WidgetGadgetData.Builder getWidgetGadgetDataBuilder(int index) {
                return getWidgetGadgetDataFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WidgetGadgetAllDataNotifyOuterClass.WidgetGadgetAllDataNotifyOrBuilder
            public WidgetGadgetDataOuterClass.WidgetGadgetDataOrBuilder getWidgetGadgetDataOrBuilder(int index) {
                if (this.widgetGadgetDataBuilder_ == null) {
                    return this.widgetGadgetData_.get(index);
                }
                return this.widgetGadgetDataBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WidgetGadgetAllDataNotifyOuterClass.WidgetGadgetAllDataNotifyOrBuilder
            public List<? extends WidgetGadgetDataOuterClass.WidgetGadgetDataOrBuilder> getWidgetGadgetDataOrBuilderList() {
                if (this.widgetGadgetDataBuilder_ != null) {
                    return this.widgetGadgetDataBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.widgetGadgetData_);
            }

            public WidgetGadgetDataOuterClass.WidgetGadgetData.Builder addWidgetGadgetDataBuilder() {
                return getWidgetGadgetDataFieldBuilder().addBuilder(WidgetGadgetDataOuterClass.WidgetGadgetData.getDefaultInstance());
            }

            public WidgetGadgetDataOuterClass.WidgetGadgetData.Builder addWidgetGadgetDataBuilder(int index) {
                return getWidgetGadgetDataFieldBuilder().addBuilder(index, WidgetGadgetDataOuterClass.WidgetGadgetData.getDefaultInstance());
            }

            public List<WidgetGadgetDataOuterClass.WidgetGadgetData.Builder> getWidgetGadgetDataBuilderList() {
                return getWidgetGadgetDataFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<WidgetGadgetDataOuterClass.WidgetGadgetData, WidgetGadgetDataOuterClass.WidgetGadgetData.Builder, WidgetGadgetDataOuterClass.WidgetGadgetDataOrBuilder> getWidgetGadgetDataFieldBuilder() {
                if (this.widgetGadgetDataBuilder_ == null) {
                    this.widgetGadgetDataBuilder_ = new RepeatedFieldBuilderV3<>(this.widgetGadgetData_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
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

        public static WidgetGadgetAllDataNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WidgetGadgetAllDataNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WidgetGadgetAllDataNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WidgetGadgetAllDataNotify getDefaultInstanceForType() {
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
