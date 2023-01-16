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
import emu.grasscutter.net.proto.DailyTaskInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DailyTaskProgressNotifyOuterClass.class */
public final class DailyTaskProgressNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dDailyTaskProgressNotify.proto\u001a\u0013DailyTaskInfo.proto\"7\n\u0017DailyTaskProgressNotify\u0012\u001c\n\u0004info\u0018\f \u0001(\u000b2\u000e.DailyTaskInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{DailyTaskInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_DailyTaskProgressNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DailyTaskProgressNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DailyTaskProgressNotify_descriptor, new String[]{"Info"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DailyTaskProgressNotifyOuterClass$DailyTaskProgressNotifyOrBuilder.class */
    public interface DailyTaskProgressNotifyOrBuilder extends MessageOrBuilder {
        boolean hasInfo();

        DailyTaskInfoOuterClass.DailyTaskInfo getInfo();

        DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder getInfoOrBuilder();
    }

    private DailyTaskProgressNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DailyTaskProgressNotifyOuterClass$DailyTaskProgressNotify.class */
    public static final class DailyTaskProgressNotify extends GeneratedMessageV3 implements DailyTaskProgressNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int INFO_FIELD_NUMBER = 12;
        private DailyTaskInfoOuterClass.DailyTaskInfo info_;
        private byte memoizedIsInitialized;
        private static final DailyTaskProgressNotify DEFAULT_INSTANCE = new DailyTaskProgressNotify();
        private static final Parser<DailyTaskProgressNotify> PARSER = new AbstractParser<DailyTaskProgressNotify>() { // from class: emu.grasscutter.net.proto.DailyTaskProgressNotifyOuterClass.DailyTaskProgressNotify.1
            @Override // com.google.protobuf.Parser
            public DailyTaskProgressNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DailyTaskProgressNotify(input, extensionRegistry);
            }
        };

        private DailyTaskProgressNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DailyTaskProgressNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DailyTaskProgressNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DailyTaskProgressNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 98:
                                DailyTaskInfoOuterClass.DailyTaskInfo.Builder subBuilder = this.info_ != null ? this.info_.toBuilder() : null;
                                this.info_ = (DailyTaskInfoOuterClass.DailyTaskInfo) input.readMessage(DailyTaskInfoOuterClass.DailyTaskInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.info_);
                                    this.info_ = subBuilder.buildPartial();
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
            return DailyTaskProgressNotifyOuterClass.internal_static_DailyTaskProgressNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DailyTaskProgressNotifyOuterClass.internal_static_DailyTaskProgressNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyTaskProgressNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DailyTaskProgressNotifyOuterClass.DailyTaskProgressNotifyOrBuilder
        public boolean hasInfo() {
            return this.info_ != null;
        }

        @Override // emu.grasscutter.net.proto.DailyTaskProgressNotifyOuterClass.DailyTaskProgressNotifyOrBuilder
        public DailyTaskInfoOuterClass.DailyTaskInfo getInfo() {
            return this.info_ == null ? DailyTaskInfoOuterClass.DailyTaskInfo.getDefaultInstance() : this.info_;
        }

        @Override // emu.grasscutter.net.proto.DailyTaskProgressNotifyOuterClass.DailyTaskProgressNotifyOrBuilder
        public DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder getInfoOrBuilder() {
            return getInfo();
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
            if (this.info_ != null) {
                output.writeMessage(12, getInfo());
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
            if (this.info_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(12, getInfo());
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
            if (!(obj instanceof DailyTaskProgressNotify)) {
                return equals(obj);
            }
            DailyTaskProgressNotify other = (DailyTaskProgressNotify) obj;
            if (hasInfo() != other.hasInfo()) {
                return false;
            }
            return (!hasInfo() || getInfo().equals(other.getInfo())) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasInfo()) {
                hash = (53 * ((37 * hash) + 12)) + getInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DailyTaskProgressNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DailyTaskProgressNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DailyTaskProgressNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DailyTaskProgressNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DailyTaskProgressNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DailyTaskProgressNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DailyTaskProgressNotify parseFrom(InputStream input) throws IOException {
            return (DailyTaskProgressNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DailyTaskProgressNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyTaskProgressNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DailyTaskProgressNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (DailyTaskProgressNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DailyTaskProgressNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyTaskProgressNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DailyTaskProgressNotify parseFrom(CodedInputStream input) throws IOException {
            return (DailyTaskProgressNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DailyTaskProgressNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyTaskProgressNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DailyTaskProgressNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DailyTaskProgressNotifyOuterClass$DailyTaskProgressNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DailyTaskProgressNotifyOrBuilder {
            private DailyTaskInfoOuterClass.DailyTaskInfo info_;
            private SingleFieldBuilderV3<DailyTaskInfoOuterClass.DailyTaskInfo, DailyTaskInfoOuterClass.DailyTaskInfo.Builder, DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder> infoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DailyTaskProgressNotifyOuterClass.internal_static_DailyTaskProgressNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DailyTaskProgressNotifyOuterClass.internal_static_DailyTaskProgressNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyTaskProgressNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DailyTaskProgressNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.infoBuilder_ == null) {
                    this.info_ = null;
                } else {
                    this.info_ = null;
                    this.infoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DailyTaskProgressNotifyOuterClass.internal_static_DailyTaskProgressNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DailyTaskProgressNotify getDefaultInstanceForType() {
                return DailyTaskProgressNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DailyTaskProgressNotify build() {
                DailyTaskProgressNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DailyTaskProgressNotify buildPartial() {
                DailyTaskProgressNotify result = new DailyTaskProgressNotify(this);
                if (this.infoBuilder_ == null) {
                    result.info_ = this.info_;
                } else {
                    result.info_ = this.infoBuilder_.build();
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
                if (other instanceof DailyTaskProgressNotify) {
                    return mergeFrom((DailyTaskProgressNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DailyTaskProgressNotify other) {
                if (other == DailyTaskProgressNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasInfo()) {
                    mergeInfo(other.getInfo());
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
                DailyTaskProgressNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = DailyTaskProgressNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DailyTaskProgressNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DailyTaskProgressNotifyOuterClass.DailyTaskProgressNotifyOrBuilder
            public boolean hasInfo() {
                return (this.infoBuilder_ == null && this.info_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.DailyTaskProgressNotifyOuterClass.DailyTaskProgressNotifyOrBuilder
            public DailyTaskInfoOuterClass.DailyTaskInfo getInfo() {
                if (this.infoBuilder_ == null) {
                    return this.info_ == null ? DailyTaskInfoOuterClass.DailyTaskInfo.getDefaultInstance() : this.info_;
                }
                return this.infoBuilder_.getMessage();
            }

            public Builder setInfo(DailyTaskInfoOuterClass.DailyTaskInfo value) {
                if (this.infoBuilder_ != null) {
                    this.infoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.info_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setInfo(DailyTaskInfoOuterClass.DailyTaskInfo.Builder builderForValue) {
                if (this.infoBuilder_ == null) {
                    this.info_ = builderForValue.build();
                    onChanged();
                } else {
                    this.infoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeInfo(DailyTaskInfoOuterClass.DailyTaskInfo value) {
                if (this.infoBuilder_ == null) {
                    if (this.info_ != null) {
                        this.info_ = DailyTaskInfoOuterClass.DailyTaskInfo.newBuilder(this.info_).mergeFrom(value).buildPartial();
                    } else {
                        this.info_ = value;
                    }
                    onChanged();
                } else {
                    this.infoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearInfo() {
                if (this.infoBuilder_ == null) {
                    this.info_ = null;
                    onChanged();
                } else {
                    this.info_ = null;
                    this.infoBuilder_ = null;
                }
                return this;
            }

            public DailyTaskInfoOuterClass.DailyTaskInfo.Builder getInfoBuilder() {
                onChanged();
                return getInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.DailyTaskProgressNotifyOuterClass.DailyTaskProgressNotifyOrBuilder
            public DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder getInfoOrBuilder() {
                if (this.infoBuilder_ != null) {
                    return this.infoBuilder_.getMessageOrBuilder();
                }
                return this.info_ == null ? DailyTaskInfoOuterClass.DailyTaskInfo.getDefaultInstance() : this.info_;
            }

            private SingleFieldBuilderV3<DailyTaskInfoOuterClass.DailyTaskInfo, DailyTaskInfoOuterClass.DailyTaskInfo.Builder, DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder> getInfoFieldBuilder() {
                if (this.infoBuilder_ == null) {
                    this.infoBuilder_ = new SingleFieldBuilderV3<>(getInfo(), getParentForChildren(), isClean());
                    this.info_ = null;
                }
                return this.infoBuilder_;
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

        public static DailyTaskProgressNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DailyTaskProgressNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DailyTaskProgressNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DailyTaskProgressNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        DailyTaskInfoOuterClass.getDescriptor();
    }
}
