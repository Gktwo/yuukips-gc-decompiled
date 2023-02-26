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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityTakeWatcherRewardReqOuterClass.class */
public final class ActivityTakeWatcherRewardReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"ActivityTakeWatcherRewardReq.proto\"E\n\u001cActivityTakeWatcherRewardReq\u0012\u0012\n\nactivityId\u0018\u000b \u0001(\r\u0012\u0011\n\twatcherId\u0018\u0006 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ActivityTakeWatcherRewardReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ActivityTakeWatcherRewardReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ActivityTakeWatcherRewardReq_descriptor, new String[]{"ActivityId", "WatcherId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityTakeWatcherRewardReqOuterClass$ActivityTakeWatcherRewardReqOrBuilder.class */
    public interface ActivityTakeWatcherRewardReqOrBuilder extends MessageOrBuilder {
        int getActivityId();

        int getWatcherId();
    }

    private ActivityTakeWatcherRewardReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityTakeWatcherRewardReqOuterClass$ActivityTakeWatcherRewardReq.class */
    public static final class ActivityTakeWatcherRewardReq extends GeneratedMessageV3 implements ActivityTakeWatcherRewardReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ACTIVITYID_FIELD_NUMBER = 11;
        private int activityId_;
        public static final int WATCHERID_FIELD_NUMBER = 6;
        private int watcherId_;
        private byte memoizedIsInitialized;
        private static final ActivityTakeWatcherRewardReq DEFAULT_INSTANCE = new ActivityTakeWatcherRewardReq();
        private static final Parser<ActivityTakeWatcherRewardReq> PARSER = new AbstractParser<ActivityTakeWatcherRewardReq>() { // from class: emu.grasscutter.net.proto.ActivityTakeWatcherRewardReqOuterClass.ActivityTakeWatcherRewardReq.1
            @Override // com.google.protobuf.Parser
            public ActivityTakeWatcherRewardReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ActivityTakeWatcherRewardReq(input, extensionRegistry);
            }
        };

        private ActivityTakeWatcherRewardReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ActivityTakeWatcherRewardReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ActivityTakeWatcherRewardReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ActivityTakeWatcherRewardReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 48:
                                this.watcherId_ = input.readUInt32();
                                break;
                            case 88:
                                this.activityId_ = input.readUInt32();
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
            return ActivityTakeWatcherRewardReqOuterClass.internal_static_ActivityTakeWatcherRewardReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ActivityTakeWatcherRewardReqOuterClass.internal_static_ActivityTakeWatcherRewardReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityTakeWatcherRewardReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ActivityTakeWatcherRewardReqOuterClass.ActivityTakeWatcherRewardReqOrBuilder
        public int getActivityId() {
            return this.activityId_;
        }

        @Override // emu.grasscutter.net.proto.ActivityTakeWatcherRewardReqOuterClass.ActivityTakeWatcherRewardReqOrBuilder
        public int getWatcherId() {
            return this.watcherId_;
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
            if (this.watcherId_ != 0) {
                output.writeUInt32(6, this.watcherId_);
            }
            if (this.activityId_ != 0) {
                output.writeUInt32(11, this.activityId_);
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
            if (this.watcherId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(6, this.watcherId_);
            }
            if (this.activityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.activityId_);
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
            if (!(obj instanceof ActivityTakeWatcherRewardReq)) {
                return equals(obj);
            }
            ActivityTakeWatcherRewardReq other = (ActivityTakeWatcherRewardReq) obj;
            return getActivityId() == other.getActivityId() && getWatcherId() == other.getWatcherId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getActivityId())) + 6)) + getWatcherId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ActivityTakeWatcherRewardReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityTakeWatcherRewardReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityTakeWatcherRewardReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityTakeWatcherRewardReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityTakeWatcherRewardReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityTakeWatcherRewardReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityTakeWatcherRewardReq parseFrom(InputStream input) throws IOException {
            return (ActivityTakeWatcherRewardReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ActivityTakeWatcherRewardReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityTakeWatcherRewardReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ActivityTakeWatcherRewardReq parseDelimitedFrom(InputStream input) throws IOException {
            return (ActivityTakeWatcherRewardReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ActivityTakeWatcherRewardReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityTakeWatcherRewardReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ActivityTakeWatcherRewardReq parseFrom(CodedInputStream input) throws IOException {
            return (ActivityTakeWatcherRewardReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ActivityTakeWatcherRewardReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityTakeWatcherRewardReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ActivityTakeWatcherRewardReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityTakeWatcherRewardReqOuterClass$ActivityTakeWatcherRewardReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ActivityTakeWatcherRewardReqOrBuilder {
            private int activityId_;
            private int watcherId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ActivityTakeWatcherRewardReqOuterClass.internal_static_ActivityTakeWatcherRewardReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ActivityTakeWatcherRewardReqOuterClass.internal_static_ActivityTakeWatcherRewardReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityTakeWatcherRewardReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ActivityTakeWatcherRewardReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.activityId_ = 0;
                this.watcherId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ActivityTakeWatcherRewardReqOuterClass.internal_static_ActivityTakeWatcherRewardReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ActivityTakeWatcherRewardReq getDefaultInstanceForType() {
                return ActivityTakeWatcherRewardReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ActivityTakeWatcherRewardReq build() {
                ActivityTakeWatcherRewardReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ActivityTakeWatcherRewardReq buildPartial() {
                ActivityTakeWatcherRewardReq result = new ActivityTakeWatcherRewardReq(this);
                result.activityId_ = this.activityId_;
                result.watcherId_ = this.watcherId_;
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
                if (other instanceof ActivityTakeWatcherRewardReq) {
                    return mergeFrom((ActivityTakeWatcherRewardReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ActivityTakeWatcherRewardReq other) {
                if (other == ActivityTakeWatcherRewardReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getActivityId() != 0) {
                    setActivityId(other.getActivityId());
                }
                if (other.getWatcherId() != 0) {
                    setWatcherId(other.getWatcherId());
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
                ActivityTakeWatcherRewardReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = ActivityTakeWatcherRewardReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ActivityTakeWatcherRewardReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ActivityTakeWatcherRewardReqOuterClass.ActivityTakeWatcherRewardReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.ActivityTakeWatcherRewardReqOuterClass.ActivityTakeWatcherRewardReqOrBuilder
            public int getWatcherId() {
                return this.watcherId_;
            }

            public Builder setWatcherId(int value) {
                this.watcherId_ = value;
                onChanged();
                return this;
            }

            public Builder clearWatcherId() {
                this.watcherId_ = 0;
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

        public static ActivityTakeWatcherRewardReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ActivityTakeWatcherRewardReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ActivityTakeWatcherRewardReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ActivityTakeWatcherRewardReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
