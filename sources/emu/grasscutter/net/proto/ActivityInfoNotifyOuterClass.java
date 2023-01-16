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
import emu.grasscutter.net.proto.ActivityInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityInfoNotifyOuterClass.class */
public final class ActivityInfoNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018ActivityInfoNotify.proto\u001a\u0012ActivityInfo.proto\":\n\u0012ActivityInfoNotify\u0012$\n\ractivity_info\u0018\f \u0001(\u000b2\r.ActivityInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ActivityInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ActivityInfoNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ActivityInfoNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ActivityInfoNotify_descriptor, new String[]{"ActivityInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityInfoNotifyOuterClass$ActivityInfoNotifyOrBuilder.class */
    public interface ActivityInfoNotifyOrBuilder extends MessageOrBuilder {
        boolean hasActivityInfo();

        ActivityInfoOuterClass.ActivityInfo getActivityInfo();

        ActivityInfoOuterClass.ActivityInfoOrBuilder getActivityInfoOrBuilder();
    }

    private ActivityInfoNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityInfoNotifyOuterClass$ActivityInfoNotify.class */
    public static final class ActivityInfoNotify extends GeneratedMessageV3 implements ActivityInfoNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ACTIVITY_INFO_FIELD_NUMBER = 12;
        private ActivityInfoOuterClass.ActivityInfo activityInfo_;
        private byte memoizedIsInitialized;
        private static final ActivityInfoNotify DEFAULT_INSTANCE = new ActivityInfoNotify();
        private static final Parser<ActivityInfoNotify> PARSER = new AbstractParser<ActivityInfoNotify>() { // from class: emu.grasscutter.net.proto.ActivityInfoNotifyOuterClass.ActivityInfoNotify.1
            @Override // com.google.protobuf.Parser
            public ActivityInfoNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ActivityInfoNotify(input, extensionRegistry);
            }
        };

        private ActivityInfoNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ActivityInfoNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ActivityInfoNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ActivityInfoNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                ActivityInfoOuterClass.ActivityInfo.Builder subBuilder = this.activityInfo_ != null ? this.activityInfo_.toBuilder() : null;
                                this.activityInfo_ = (ActivityInfoOuterClass.ActivityInfo) input.readMessage(ActivityInfoOuterClass.ActivityInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.activityInfo_);
                                    this.activityInfo_ = subBuilder.buildPartial();
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
            return ActivityInfoNotifyOuterClass.internal_static_ActivityInfoNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ActivityInfoNotifyOuterClass.internal_static_ActivityInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityInfoNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoNotifyOuterClass.ActivityInfoNotifyOrBuilder
        public boolean hasActivityInfo() {
            return this.activityInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoNotifyOuterClass.ActivityInfoNotifyOrBuilder
        public ActivityInfoOuterClass.ActivityInfo getActivityInfo() {
            return this.activityInfo_ == null ? ActivityInfoOuterClass.ActivityInfo.getDefaultInstance() : this.activityInfo_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoNotifyOuterClass.ActivityInfoNotifyOrBuilder
        public ActivityInfoOuterClass.ActivityInfoOrBuilder getActivityInfoOrBuilder() {
            return getActivityInfo();
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
            if (this.activityInfo_ != null) {
                output.writeMessage(12, getActivityInfo());
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
            if (this.activityInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(12, getActivityInfo());
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
            if (!(obj instanceof ActivityInfoNotify)) {
                return equals(obj);
            }
            ActivityInfoNotify other = (ActivityInfoNotify) obj;
            if (hasActivityInfo() != other.hasActivityInfo()) {
                return false;
            }
            return (!hasActivityInfo() || getActivityInfo().equals(other.getActivityInfo())) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasActivityInfo()) {
                hash = (53 * ((37 * hash) + 12)) + getActivityInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ActivityInfoNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityInfoNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityInfoNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityInfoNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityInfoNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityInfoNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityInfoNotify parseFrom(InputStream input) throws IOException {
            return (ActivityInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ActivityInfoNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ActivityInfoNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ActivityInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ActivityInfoNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ActivityInfoNotify parseFrom(CodedInputStream input) throws IOException {
            return (ActivityInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ActivityInfoNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ActivityInfoNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityInfoNotifyOuterClass$ActivityInfoNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ActivityInfoNotifyOrBuilder {
            private ActivityInfoOuterClass.ActivityInfo activityInfo_;
            private SingleFieldBuilderV3<ActivityInfoOuterClass.ActivityInfo, ActivityInfoOuterClass.ActivityInfo.Builder, ActivityInfoOuterClass.ActivityInfoOrBuilder> activityInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ActivityInfoNotifyOuterClass.internal_static_ActivityInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ActivityInfoNotifyOuterClass.internal_static_ActivityInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityInfoNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ActivityInfoNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.activityInfoBuilder_ == null) {
                    this.activityInfo_ = null;
                } else {
                    this.activityInfo_ = null;
                    this.activityInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ActivityInfoNotifyOuterClass.internal_static_ActivityInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ActivityInfoNotify getDefaultInstanceForType() {
                return ActivityInfoNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ActivityInfoNotify build() {
                ActivityInfoNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ActivityInfoNotify buildPartial() {
                ActivityInfoNotify result = new ActivityInfoNotify(this);
                if (this.activityInfoBuilder_ == null) {
                    result.activityInfo_ = this.activityInfo_;
                } else {
                    result.activityInfo_ = this.activityInfoBuilder_.build();
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
                if (other instanceof ActivityInfoNotify) {
                    return mergeFrom((ActivityInfoNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ActivityInfoNotify other) {
                if (other == ActivityInfoNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasActivityInfo()) {
                    mergeActivityInfo(other.getActivityInfo());
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
                ActivityInfoNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ActivityInfoNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ActivityInfoNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoNotifyOuterClass.ActivityInfoNotifyOrBuilder
            public boolean hasActivityInfo() {
                return (this.activityInfoBuilder_ == null && this.activityInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoNotifyOuterClass.ActivityInfoNotifyOrBuilder
            public ActivityInfoOuterClass.ActivityInfo getActivityInfo() {
                if (this.activityInfoBuilder_ == null) {
                    return this.activityInfo_ == null ? ActivityInfoOuterClass.ActivityInfo.getDefaultInstance() : this.activityInfo_;
                }
                return this.activityInfoBuilder_.getMessage();
            }

            public Builder setActivityInfo(ActivityInfoOuterClass.ActivityInfo value) {
                if (this.activityInfoBuilder_ != null) {
                    this.activityInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.activityInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setActivityInfo(ActivityInfoOuterClass.ActivityInfo.Builder builderForValue) {
                if (this.activityInfoBuilder_ == null) {
                    this.activityInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.activityInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeActivityInfo(ActivityInfoOuterClass.ActivityInfo value) {
                if (this.activityInfoBuilder_ == null) {
                    if (this.activityInfo_ != null) {
                        this.activityInfo_ = ActivityInfoOuterClass.ActivityInfo.newBuilder(this.activityInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.activityInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.activityInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearActivityInfo() {
                if (this.activityInfoBuilder_ == null) {
                    this.activityInfo_ = null;
                    onChanged();
                } else {
                    this.activityInfo_ = null;
                    this.activityInfoBuilder_ = null;
                }
                return this;
            }

            public ActivityInfoOuterClass.ActivityInfo.Builder getActivityInfoBuilder() {
                onChanged();
                return getActivityInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoNotifyOuterClass.ActivityInfoNotifyOrBuilder
            public ActivityInfoOuterClass.ActivityInfoOrBuilder getActivityInfoOrBuilder() {
                if (this.activityInfoBuilder_ != null) {
                    return this.activityInfoBuilder_.getMessageOrBuilder();
                }
                return this.activityInfo_ == null ? ActivityInfoOuterClass.ActivityInfo.getDefaultInstance() : this.activityInfo_;
            }

            private SingleFieldBuilderV3<ActivityInfoOuterClass.ActivityInfo, ActivityInfoOuterClass.ActivityInfo.Builder, ActivityInfoOuterClass.ActivityInfoOrBuilder> getActivityInfoFieldBuilder() {
                if (this.activityInfoBuilder_ == null) {
                    this.activityInfoBuilder_ = new SingleFieldBuilderV3<>(getActivityInfo(), getParentForChildren(), isClean());
                    this.activityInfo_ = null;
                }
                return this.activityInfoBuilder_;
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

        public static ActivityInfoNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ActivityInfoNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ActivityInfoNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ActivityInfoNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ActivityInfoOuterClass.getDescriptor();
    }
}
