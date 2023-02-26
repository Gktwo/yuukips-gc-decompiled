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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityTakeWatcherRewardRspOuterClass.class */
public final class ActivityTakeWatcherRewardRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"ActivityTakeWatcherRewardRsp.proto\"V\n\u001cActivityTakeWatcherRewardRsp\u0012\u000f\n\u0007retcode\u0018\t \u0001(\u0005\u0012\u0011\n\twatcherId\u0018\u0005 \u0001(\r\u0012\u0012\n\nactivityId\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ActivityTakeWatcherRewardRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ActivityTakeWatcherRewardRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ActivityTakeWatcherRewardRsp_descriptor, new String[]{"Retcode", "WatcherId", "ActivityId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityTakeWatcherRewardRspOuterClass$ActivityTakeWatcherRewardRspOrBuilder.class */
    public interface ActivityTakeWatcherRewardRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        int getWatcherId();

        int getActivityId();
    }

    private ActivityTakeWatcherRewardRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityTakeWatcherRewardRspOuterClass$ActivityTakeWatcherRewardRsp.class */
    public static final class ActivityTakeWatcherRewardRsp extends GeneratedMessageV3 implements ActivityTakeWatcherRewardRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 9;
        private int retcode_;
        public static final int WATCHERID_FIELD_NUMBER = 5;
        private int watcherId_;
        public static final int ACTIVITYID_FIELD_NUMBER = 3;
        private int activityId_;
        private byte memoizedIsInitialized;
        private static final ActivityTakeWatcherRewardRsp DEFAULT_INSTANCE = new ActivityTakeWatcherRewardRsp();
        private static final Parser<ActivityTakeWatcherRewardRsp> PARSER = new AbstractParser<ActivityTakeWatcherRewardRsp>() { // from class: emu.grasscutter.net.proto.ActivityTakeWatcherRewardRspOuterClass.ActivityTakeWatcherRewardRsp.1
            @Override // com.google.protobuf.Parser
            public ActivityTakeWatcherRewardRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ActivityTakeWatcherRewardRsp(input, extensionRegistry);
            }
        };

        private ActivityTakeWatcherRewardRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ActivityTakeWatcherRewardRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ActivityTakeWatcherRewardRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ActivityTakeWatcherRewardRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 40:
                                    this.watcherId_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.retcode_ = input.readInt32();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ActivityTakeWatcherRewardRspOuterClass.internal_static_ActivityTakeWatcherRewardRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ActivityTakeWatcherRewardRspOuterClass.internal_static_ActivityTakeWatcherRewardRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityTakeWatcherRewardRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ActivityTakeWatcherRewardRspOuterClass.ActivityTakeWatcherRewardRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.ActivityTakeWatcherRewardRspOuterClass.ActivityTakeWatcherRewardRspOrBuilder
        public int getWatcherId() {
            return this.watcherId_;
        }

        @Override // emu.grasscutter.net.proto.ActivityTakeWatcherRewardRspOuterClass.ActivityTakeWatcherRewardRspOrBuilder
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
            if (this.watcherId_ != 0) {
                output.writeUInt32(5, this.watcherId_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(9, this.retcode_);
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
            if (this.watcherId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.watcherId_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(9, this.retcode_);
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
            if (!(obj instanceof ActivityTakeWatcherRewardRsp)) {
                return equals(obj);
            }
            ActivityTakeWatcherRewardRsp other = (ActivityTakeWatcherRewardRsp) obj;
            return getRetcode() == other.getRetcode() && getWatcherId() == other.getWatcherId() && getActivityId() == other.getActivityId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getRetcode())) + 5)) + getWatcherId())) + 3)) + getActivityId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ActivityTakeWatcherRewardRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityTakeWatcherRewardRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityTakeWatcherRewardRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityTakeWatcherRewardRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityTakeWatcherRewardRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityTakeWatcherRewardRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityTakeWatcherRewardRsp parseFrom(InputStream input) throws IOException {
            return (ActivityTakeWatcherRewardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ActivityTakeWatcherRewardRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityTakeWatcherRewardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ActivityTakeWatcherRewardRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (ActivityTakeWatcherRewardRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ActivityTakeWatcherRewardRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityTakeWatcherRewardRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ActivityTakeWatcherRewardRsp parseFrom(CodedInputStream input) throws IOException {
            return (ActivityTakeWatcherRewardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ActivityTakeWatcherRewardRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityTakeWatcherRewardRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ActivityTakeWatcherRewardRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityTakeWatcherRewardRspOuterClass$ActivityTakeWatcherRewardRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ActivityTakeWatcherRewardRspOrBuilder {
            private int retcode_;
            private int watcherId_;
            private int activityId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ActivityTakeWatcherRewardRspOuterClass.internal_static_ActivityTakeWatcherRewardRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ActivityTakeWatcherRewardRspOuterClass.internal_static_ActivityTakeWatcherRewardRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityTakeWatcherRewardRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ActivityTakeWatcherRewardRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.watcherId_ = 0;
                this.activityId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ActivityTakeWatcherRewardRspOuterClass.internal_static_ActivityTakeWatcherRewardRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ActivityTakeWatcherRewardRsp getDefaultInstanceForType() {
                return ActivityTakeWatcherRewardRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ActivityTakeWatcherRewardRsp build() {
                ActivityTakeWatcherRewardRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ActivityTakeWatcherRewardRsp buildPartial() {
                ActivityTakeWatcherRewardRsp result = new ActivityTakeWatcherRewardRsp(this);
                result.retcode_ = this.retcode_;
                result.watcherId_ = this.watcherId_;
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
                if (other instanceof ActivityTakeWatcherRewardRsp) {
                    return mergeFrom((ActivityTakeWatcherRewardRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ActivityTakeWatcherRewardRsp other) {
                if (other == ActivityTakeWatcherRewardRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getWatcherId() != 0) {
                    setWatcherId(other.getWatcherId());
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
                ActivityTakeWatcherRewardRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = ActivityTakeWatcherRewardRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ActivityTakeWatcherRewardRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ActivityTakeWatcherRewardRspOuterClass.ActivityTakeWatcherRewardRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.ActivityTakeWatcherRewardRspOuterClass.ActivityTakeWatcherRewardRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.ActivityTakeWatcherRewardRspOuterClass.ActivityTakeWatcherRewardRspOrBuilder
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

        public static ActivityTakeWatcherRewardRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ActivityTakeWatcherRewardRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ActivityTakeWatcherRewardRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ActivityTakeWatcherRewardRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
