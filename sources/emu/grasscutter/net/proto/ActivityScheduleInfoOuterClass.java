package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityScheduleInfoOuterClass.class */
public final class ActivityScheduleInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aActivityScheduleInfo.proto\"w\n\u0014ActivityScheduleInfo\u0012\u0010\n\bend_time\u0018\u0003 \u0001(\r\u0012\u000f\n\u0007is_open\u0018\f \u0001(\b\u0012\u0012\n\nbegin_time\u0018\u0001 \u0001(\r\u0012\u0013\n\u000bschedule_id\u0018\t \u0001(\r\u0012\u0013\n\u000bactivity_id\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ActivityScheduleInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ActivityScheduleInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ActivityScheduleInfo_descriptor, new String[]{"EndTime", "IsOpen", "BeginTime", "ScheduleId", "ActivityId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityScheduleInfoOuterClass$ActivityScheduleInfoOrBuilder.class */
    public interface ActivityScheduleInfoOrBuilder extends MessageOrBuilder {
        int getEndTime();

        boolean getIsOpen();

        int getBeginTime();

        int getScheduleId();

        int getActivityId();
    }

    private ActivityScheduleInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityScheduleInfoOuterClass$ActivityScheduleInfo.class */
    public static final class ActivityScheduleInfo extends GeneratedMessageV3 implements ActivityScheduleInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int END_TIME_FIELD_NUMBER = 3;
        private int endTime_;
        public static final int IS_OPEN_FIELD_NUMBER = 12;
        private boolean isOpen_;
        public static final int BEGIN_TIME_FIELD_NUMBER = 1;
        private int beginTime_;
        public static final int SCHEDULE_ID_FIELD_NUMBER = 9;
        private int scheduleId_;
        public static final int ACTIVITY_ID_FIELD_NUMBER = 11;
        private int activityId_;
        private byte memoizedIsInitialized;
        private static final ActivityScheduleInfo DEFAULT_INSTANCE = new ActivityScheduleInfo();
        private static final Parser<ActivityScheduleInfo> PARSER = new AbstractParser<ActivityScheduleInfo>() { // from class: emu.grasscutter.net.proto.ActivityScheduleInfoOuterClass.ActivityScheduleInfo.1
            @Override // com.google.protobuf.Parser
            public ActivityScheduleInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ActivityScheduleInfo(input, extensionRegistry);
            }
        };

        private ActivityScheduleInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ActivityScheduleInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ActivityScheduleInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ActivityScheduleInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.beginTime_ = input.readUInt32();
                                break;
                            case 24:
                                this.endTime_ = input.readUInt32();
                                break;
                            case 72:
                                this.scheduleId_ = input.readUInt32();
                                break;
                            case 88:
                                this.activityId_ = input.readUInt32();
                                break;
                            case 96:
                                this.isOpen_ = input.readBool();
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
            return ActivityScheduleInfoOuterClass.internal_static_ActivityScheduleInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ActivityScheduleInfoOuterClass.internal_static_ActivityScheduleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityScheduleInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ActivityScheduleInfoOuterClass.ActivityScheduleInfoOrBuilder
        public int getEndTime() {
            return this.endTime_;
        }

        @Override // emu.grasscutter.net.proto.ActivityScheduleInfoOuterClass.ActivityScheduleInfoOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.ActivityScheduleInfoOuterClass.ActivityScheduleInfoOrBuilder
        public int getBeginTime() {
            return this.beginTime_;
        }

        @Override // emu.grasscutter.net.proto.ActivityScheduleInfoOuterClass.ActivityScheduleInfoOrBuilder
        public int getScheduleId() {
            return this.scheduleId_;
        }

        @Override // emu.grasscutter.net.proto.ActivityScheduleInfoOuterClass.ActivityScheduleInfoOrBuilder
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
            if (this.beginTime_ != 0) {
                output.writeUInt32(1, this.beginTime_);
            }
            if (this.endTime_ != 0) {
                output.writeUInt32(3, this.endTime_);
            }
            if (this.scheduleId_ != 0) {
                output.writeUInt32(9, this.scheduleId_);
            }
            if (this.activityId_ != 0) {
                output.writeUInt32(11, this.activityId_);
            }
            if (this.isOpen_) {
                output.writeBool(12, this.isOpen_);
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
            if (this.beginTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.beginTime_);
            }
            if (this.endTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.endTime_);
            }
            if (this.scheduleId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.scheduleId_);
            }
            if (this.activityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.activityId_);
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(12, this.isOpen_);
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
            if (!(obj instanceof ActivityScheduleInfo)) {
                return equals(obj);
            }
            ActivityScheduleInfo other = (ActivityScheduleInfo) obj;
            return getEndTime() == other.getEndTime() && getIsOpen() == other.getIsOpen() && getBeginTime() == other.getBeginTime() && getScheduleId() == other.getScheduleId() && getActivityId() == other.getActivityId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getEndTime())) + 12)) + Internal.hashBoolean(getIsOpen()))) + 1)) + getBeginTime())) + 9)) + getScheduleId())) + 11)) + getActivityId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ActivityScheduleInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityScheduleInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityScheduleInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityScheduleInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityScheduleInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityScheduleInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityScheduleInfo parseFrom(InputStream input) throws IOException {
            return (ActivityScheduleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ActivityScheduleInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityScheduleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ActivityScheduleInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ActivityScheduleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ActivityScheduleInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityScheduleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ActivityScheduleInfo parseFrom(CodedInputStream input) throws IOException {
            return (ActivityScheduleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ActivityScheduleInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityScheduleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ActivityScheduleInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityScheduleInfoOuterClass$ActivityScheduleInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ActivityScheduleInfoOrBuilder {
            private int endTime_;
            private boolean isOpen_;
            private int beginTime_;
            private int scheduleId_;
            private int activityId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ActivityScheduleInfoOuterClass.internal_static_ActivityScheduleInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ActivityScheduleInfoOuterClass.internal_static_ActivityScheduleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityScheduleInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ActivityScheduleInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.endTime_ = 0;
                this.isOpen_ = false;
                this.beginTime_ = 0;
                this.scheduleId_ = 0;
                this.activityId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ActivityScheduleInfoOuterClass.internal_static_ActivityScheduleInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ActivityScheduleInfo getDefaultInstanceForType() {
                return ActivityScheduleInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ActivityScheduleInfo build() {
                ActivityScheduleInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ActivityScheduleInfo buildPartial() {
                ActivityScheduleInfo result = new ActivityScheduleInfo(this);
                result.endTime_ = this.endTime_;
                result.isOpen_ = this.isOpen_;
                result.beginTime_ = this.beginTime_;
                result.scheduleId_ = this.scheduleId_;
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
                if (other instanceof ActivityScheduleInfo) {
                    return mergeFrom((ActivityScheduleInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ActivityScheduleInfo other) {
                if (other == ActivityScheduleInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getEndTime() != 0) {
                    setEndTime(other.getEndTime());
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (other.getBeginTime() != 0) {
                    setBeginTime(other.getBeginTime());
                }
                if (other.getScheduleId() != 0) {
                    setScheduleId(other.getScheduleId());
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
                ActivityScheduleInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ActivityScheduleInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ActivityScheduleInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ActivityScheduleInfoOuterClass.ActivityScheduleInfoOrBuilder
            public int getEndTime() {
                return this.endTime_;
            }

            public Builder setEndTime(int value) {
                this.endTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearEndTime() {
                this.endTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityScheduleInfoOuterClass.ActivityScheduleInfoOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            public Builder setIsOpen(boolean value) {
                this.isOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.isOpen_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityScheduleInfoOuterClass.ActivityScheduleInfoOrBuilder
            public int getBeginTime() {
                return this.beginTime_;
            }

            public Builder setBeginTime(int value) {
                this.beginTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearBeginTime() {
                this.beginTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityScheduleInfoOuterClass.ActivityScheduleInfoOrBuilder
            public int getScheduleId() {
                return this.scheduleId_;
            }

            public Builder setScheduleId(int value) {
                this.scheduleId_ = value;
                onChanged();
                return this;
            }

            public Builder clearScheduleId() {
                this.scheduleId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityScheduleInfoOuterClass.ActivityScheduleInfoOrBuilder
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

        public static ActivityScheduleInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ActivityScheduleInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ActivityScheduleInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ActivityScheduleInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
