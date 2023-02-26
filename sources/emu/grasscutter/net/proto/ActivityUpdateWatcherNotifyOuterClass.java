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
import emu.grasscutter.net.proto.ActivityWatcherInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityUpdateWatcherNotifyOuterClass.class */
public final class ActivityUpdateWatcherNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!ActivityUpdateWatcherNotify.proto\u001a\u0019ActivityWatcherInfo.proto\"\\\n\u001bActivityUpdateWatcherNotify\u0012)\n\u000bwatcherInfo\u0018\u000b \u0001(\u000b2\u0014.ActivityWatcherInfo\u0012\u0012\n\nactivityId\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ActivityWatcherInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ActivityUpdateWatcherNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ActivityUpdateWatcherNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ActivityUpdateWatcherNotify_descriptor, new String[]{"WatcherInfo", "ActivityId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityUpdateWatcherNotifyOuterClass$ActivityUpdateWatcherNotifyOrBuilder.class */
    public interface ActivityUpdateWatcherNotifyOrBuilder extends MessageOrBuilder {
        boolean hasWatcherInfo();

        ActivityWatcherInfoOuterClass.ActivityWatcherInfo getWatcherInfo();

        ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder getWatcherInfoOrBuilder();

        int getActivityId();
    }

    private ActivityUpdateWatcherNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityUpdateWatcherNotifyOuterClass$ActivityUpdateWatcherNotify.class */
    public static final class ActivityUpdateWatcherNotify extends GeneratedMessageV3 implements ActivityUpdateWatcherNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int WATCHERINFO_FIELD_NUMBER = 11;
        private ActivityWatcherInfoOuterClass.ActivityWatcherInfo watcherInfo_;
        public static final int ACTIVITYID_FIELD_NUMBER = 3;
        private int activityId_;
        private byte memoizedIsInitialized;
        private static final ActivityUpdateWatcherNotify DEFAULT_INSTANCE = new ActivityUpdateWatcherNotify();
        private static final Parser<ActivityUpdateWatcherNotify> PARSER = new AbstractParser<ActivityUpdateWatcherNotify>() { // from class: emu.grasscutter.net.proto.ActivityUpdateWatcherNotifyOuterClass.ActivityUpdateWatcherNotify.1
            @Override // com.google.protobuf.Parser
            public ActivityUpdateWatcherNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ActivityUpdateWatcherNotify(input, extensionRegistry);
            }
        };

        private ActivityUpdateWatcherNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ActivityUpdateWatcherNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ActivityUpdateWatcherNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ActivityUpdateWatcherNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.activityId_ = input.readUInt32();
                                    break;
                                case 90:
                                    ActivityWatcherInfoOuterClass.ActivityWatcherInfo.Builder subBuilder = this.watcherInfo_ != null ? this.watcherInfo_.toBuilder() : null;
                                    this.watcherInfo_ = (ActivityWatcherInfoOuterClass.ActivityWatcherInfo) input.readMessage(ActivityWatcherInfoOuterClass.ActivityWatcherInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.watcherInfo_);
                                        this.watcherInfo_ = subBuilder.buildPartial();
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
            return ActivityUpdateWatcherNotifyOuterClass.internal_static_ActivityUpdateWatcherNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ActivityUpdateWatcherNotifyOuterClass.internal_static_ActivityUpdateWatcherNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityUpdateWatcherNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ActivityUpdateWatcherNotifyOuterClass.ActivityUpdateWatcherNotifyOrBuilder
        public boolean hasWatcherInfo() {
            return this.watcherInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.ActivityUpdateWatcherNotifyOuterClass.ActivityUpdateWatcherNotifyOrBuilder
        public ActivityWatcherInfoOuterClass.ActivityWatcherInfo getWatcherInfo() {
            return this.watcherInfo_ == null ? ActivityWatcherInfoOuterClass.ActivityWatcherInfo.getDefaultInstance() : this.watcherInfo_;
        }

        @Override // emu.grasscutter.net.proto.ActivityUpdateWatcherNotifyOuterClass.ActivityUpdateWatcherNotifyOrBuilder
        public ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder getWatcherInfoOrBuilder() {
            return getWatcherInfo();
        }

        @Override // emu.grasscutter.net.proto.ActivityUpdateWatcherNotifyOuterClass.ActivityUpdateWatcherNotifyOrBuilder
        public int getActivityId() {
            return this.activityId_;
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
            if (this.activityId_ != 0) {
                output.writeUInt32(3, this.activityId_);
            }
            if (this.watcherInfo_ != null) {
                output.writeMessage(11, getWatcherInfo());
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
            if (this.activityId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.activityId_);
            }
            if (this.watcherInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(11, getWatcherInfo());
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
            if (!(obj instanceof ActivityUpdateWatcherNotify)) {
                return equals(obj);
            }
            ActivityUpdateWatcherNotify other = (ActivityUpdateWatcherNotify) obj;
            if (hasWatcherInfo() != other.hasWatcherInfo()) {
                return false;
            }
            return (!hasWatcherInfo() || getWatcherInfo().equals(other.getWatcherInfo())) && getActivityId() == other.getActivityId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasWatcherInfo()) {
                hash = (53 * ((37 * hash) + 11)) + getWatcherInfo().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 3)) + getActivityId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ActivityUpdateWatcherNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityUpdateWatcherNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityUpdateWatcherNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityUpdateWatcherNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityUpdateWatcherNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityUpdateWatcherNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityUpdateWatcherNotify parseFrom(InputStream input) throws IOException {
            return (ActivityUpdateWatcherNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ActivityUpdateWatcherNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityUpdateWatcherNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ActivityUpdateWatcherNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ActivityUpdateWatcherNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ActivityUpdateWatcherNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityUpdateWatcherNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ActivityUpdateWatcherNotify parseFrom(CodedInputStream input) throws IOException {
            return (ActivityUpdateWatcherNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ActivityUpdateWatcherNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityUpdateWatcherNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ActivityUpdateWatcherNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityUpdateWatcherNotifyOuterClass$ActivityUpdateWatcherNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ActivityUpdateWatcherNotifyOrBuilder {
            private ActivityWatcherInfoOuterClass.ActivityWatcherInfo watcherInfo_;
            private SingleFieldBuilderV3<ActivityWatcherInfoOuterClass.ActivityWatcherInfo, ActivityWatcherInfoOuterClass.ActivityWatcherInfo.Builder, ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder> watcherInfoBuilder_;
            private int activityId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ActivityUpdateWatcherNotifyOuterClass.internal_static_ActivityUpdateWatcherNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ActivityUpdateWatcherNotifyOuterClass.internal_static_ActivityUpdateWatcherNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityUpdateWatcherNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ActivityUpdateWatcherNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.watcherInfoBuilder_ == null) {
                    this.watcherInfo_ = null;
                } else {
                    this.watcherInfo_ = null;
                    this.watcherInfoBuilder_ = null;
                }
                this.activityId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ActivityUpdateWatcherNotifyOuterClass.internal_static_ActivityUpdateWatcherNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ActivityUpdateWatcherNotify getDefaultInstanceForType() {
                return ActivityUpdateWatcherNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ActivityUpdateWatcherNotify build() {
                ActivityUpdateWatcherNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ActivityUpdateWatcherNotify buildPartial() {
                ActivityUpdateWatcherNotify result = new ActivityUpdateWatcherNotify(this);
                if (this.watcherInfoBuilder_ == null) {
                    result.watcherInfo_ = this.watcherInfo_;
                } else {
                    result.watcherInfo_ = this.watcherInfoBuilder_.build();
                }
                result.activityId_ = this.activityId_;
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
                if (other instanceof ActivityUpdateWatcherNotify) {
                    return mergeFrom((ActivityUpdateWatcherNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ActivityUpdateWatcherNotify other) {
                if (other == ActivityUpdateWatcherNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasWatcherInfo()) {
                    mergeWatcherInfo(other.getWatcherInfo());
                }
                if (other.getActivityId() != 0) {
                    setActivityId(other.getActivityId());
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
                ActivityUpdateWatcherNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ActivityUpdateWatcherNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ActivityUpdateWatcherNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ActivityUpdateWatcherNotifyOuterClass.ActivityUpdateWatcherNotifyOrBuilder
            public boolean hasWatcherInfo() {
                return (this.watcherInfoBuilder_ == null && this.watcherInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ActivityUpdateWatcherNotifyOuterClass.ActivityUpdateWatcherNotifyOrBuilder
            public ActivityWatcherInfoOuterClass.ActivityWatcherInfo getWatcherInfo() {
                if (this.watcherInfoBuilder_ == null) {
                    return this.watcherInfo_ == null ? ActivityWatcherInfoOuterClass.ActivityWatcherInfo.getDefaultInstance() : this.watcherInfo_;
                }
                return this.watcherInfoBuilder_.getMessage();
            }

            public Builder setWatcherInfo(ActivityWatcherInfoOuterClass.ActivityWatcherInfo value) {
                if (this.watcherInfoBuilder_ != null) {
                    this.watcherInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.watcherInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setWatcherInfo(ActivityWatcherInfoOuterClass.ActivityWatcherInfo.Builder builderForValue) {
                if (this.watcherInfoBuilder_ == null) {
                    this.watcherInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.watcherInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeWatcherInfo(ActivityWatcherInfoOuterClass.ActivityWatcherInfo value) {
                if (this.watcherInfoBuilder_ == null) {
                    if (this.watcherInfo_ != null) {
                        this.watcherInfo_ = ActivityWatcherInfoOuterClass.ActivityWatcherInfo.newBuilder(this.watcherInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.watcherInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.watcherInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearWatcherInfo() {
                if (this.watcherInfoBuilder_ == null) {
                    this.watcherInfo_ = null;
                    onChanged();
                } else {
                    this.watcherInfo_ = null;
                    this.watcherInfoBuilder_ = null;
                }
                return this;
            }

            public ActivityWatcherInfoOuterClass.ActivityWatcherInfo.Builder getWatcherInfoBuilder() {
                onChanged();
                return getWatcherInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityUpdateWatcherNotifyOuterClass.ActivityUpdateWatcherNotifyOrBuilder
            public ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder getWatcherInfoOrBuilder() {
                if (this.watcherInfoBuilder_ != null) {
                    return this.watcherInfoBuilder_.getMessageOrBuilder();
                }
                return this.watcherInfo_ == null ? ActivityWatcherInfoOuterClass.ActivityWatcherInfo.getDefaultInstance() : this.watcherInfo_;
            }

            private SingleFieldBuilderV3<ActivityWatcherInfoOuterClass.ActivityWatcherInfo, ActivityWatcherInfoOuterClass.ActivityWatcherInfo.Builder, ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder> getWatcherInfoFieldBuilder() {
                if (this.watcherInfoBuilder_ == null) {
                    this.watcherInfoBuilder_ = new SingleFieldBuilderV3<>(getWatcherInfo(), getParentForChildren(), isClean());
                    this.watcherInfo_ = null;
                }
                return this.watcherInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityUpdateWatcherNotifyOuterClass.ActivityUpdateWatcherNotifyOrBuilder
            public int getActivityId() {
                return this.activityId_;
            }

            public Builder setActivityId(int value) {
                this.activityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearActivityId() {
                this.activityId_ = 0;
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

        public static ActivityUpdateWatcherNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ActivityUpdateWatcherNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ActivityUpdateWatcherNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ActivityUpdateWatcherNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ActivityWatcherInfoOuterClass.getDescriptor();
    }
}
