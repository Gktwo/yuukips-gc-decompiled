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
import emu.grasscutter.net.proto.ActivityPushTipsStateOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityPushTipsDataOuterClass.class */
public final class ActivityPushTipsDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aActivityPushTipsData.proto\u001a\u001bActivityPushTipsState.proto\"Y\n\u0014ActivityPushTipsData\u0012%\n\u0005state\u0018\f \u0001(\u000e2\u0016.ActivityPushTipsState\u0012\u001a\n\u0012activityPushTipsId\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ActivityPushTipsStateOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ActivityPushTipsData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ActivityPushTipsData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ActivityPushTipsData_descriptor, new String[]{"State", "ActivityPushTipsId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityPushTipsDataOuterClass$ActivityPushTipsDataOrBuilder.class */
    public interface ActivityPushTipsDataOrBuilder extends MessageOrBuilder {
        int getStateValue();

        ActivityPushTipsStateOuterClass.ActivityPushTipsState getState();

        int getActivityPushTipsId();
    }

    private ActivityPushTipsDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityPushTipsDataOuterClass$ActivityPushTipsData.class */
    public static final class ActivityPushTipsData extends GeneratedMessageV3 implements ActivityPushTipsDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STATE_FIELD_NUMBER = 12;
        private int state_;
        public static final int ACTIVITYPUSHTIPSID_FIELD_NUMBER = 11;
        private int activityPushTipsId_;
        private byte memoizedIsInitialized;
        private static final ActivityPushTipsData DEFAULT_INSTANCE = new ActivityPushTipsData();
        private static final Parser<ActivityPushTipsData> PARSER = new AbstractParser<ActivityPushTipsData>() { // from class: emu.grasscutter.net.proto.ActivityPushTipsDataOuterClass.ActivityPushTipsData.1
            @Override // com.google.protobuf.Parser
            public ActivityPushTipsData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ActivityPushTipsData(input, extensionRegistry);
            }
        };

        private ActivityPushTipsData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ActivityPushTipsData() {
            this.memoizedIsInitialized = -1;
            this.state_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ActivityPushTipsData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ActivityPushTipsData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 88:
                                    this.activityPushTipsId_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.state_ = input.readEnum();
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ActivityPushTipsDataOuterClass.internal_static_ActivityPushTipsData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ActivityPushTipsDataOuterClass.internal_static_ActivityPushTipsData_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityPushTipsData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ActivityPushTipsDataOuterClass.ActivityPushTipsDataOrBuilder
        public int getStateValue() {
            return this.state_;
        }

        @Override // emu.grasscutter.net.proto.ActivityPushTipsDataOuterClass.ActivityPushTipsDataOrBuilder
        public ActivityPushTipsStateOuterClass.ActivityPushTipsState getState() {
            ActivityPushTipsStateOuterClass.ActivityPushTipsState result = ActivityPushTipsStateOuterClass.ActivityPushTipsState.valueOf(this.state_);
            return result == null ? ActivityPushTipsStateOuterClass.ActivityPushTipsState.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.ActivityPushTipsDataOuterClass.ActivityPushTipsDataOrBuilder
        public int getActivityPushTipsId() {
            return this.activityPushTipsId_;
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
            if (this.activityPushTipsId_ != 0) {
                output.writeUInt32(11, this.activityPushTipsId_);
            }
            if (this.state_ != ActivityPushTipsStateOuterClass.ActivityPushTipsState.ACTIVITY_PUSH_TIPS_STATE_NONE.getNumber()) {
                output.writeEnum(12, this.state_);
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
            if (this.activityPushTipsId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(11, this.activityPushTipsId_);
            }
            if (this.state_ != ActivityPushTipsStateOuterClass.ActivityPushTipsState.ACTIVITY_PUSH_TIPS_STATE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(12, this.state_);
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
            if (!(obj instanceof ActivityPushTipsData)) {
                return equals(obj);
            }
            ActivityPushTipsData other = (ActivityPushTipsData) obj;
            return this.state_ == other.state_ && getActivityPushTipsId() == other.getActivityPushTipsId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + this.state_)) + 11)) + getActivityPushTipsId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ActivityPushTipsData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityPushTipsData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityPushTipsData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityPushTipsData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityPushTipsData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityPushTipsData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityPushTipsData parseFrom(InputStream input) throws IOException {
            return (ActivityPushTipsData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ActivityPushTipsData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityPushTipsData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ActivityPushTipsData parseDelimitedFrom(InputStream input) throws IOException {
            return (ActivityPushTipsData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ActivityPushTipsData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityPushTipsData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ActivityPushTipsData parseFrom(CodedInputStream input) throws IOException {
            return (ActivityPushTipsData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ActivityPushTipsData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityPushTipsData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ActivityPushTipsData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityPushTipsDataOuterClass$ActivityPushTipsData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ActivityPushTipsDataOrBuilder {
            private int state_ = 0;
            private int activityPushTipsId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ActivityPushTipsDataOuterClass.internal_static_ActivityPushTipsData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ActivityPushTipsDataOuterClass.internal_static_ActivityPushTipsData_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityPushTipsData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ActivityPushTipsData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.state_ = 0;
                this.activityPushTipsId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ActivityPushTipsDataOuterClass.internal_static_ActivityPushTipsData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ActivityPushTipsData getDefaultInstanceForType() {
                return ActivityPushTipsData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ActivityPushTipsData build() {
                ActivityPushTipsData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ActivityPushTipsData buildPartial() {
                ActivityPushTipsData result = new ActivityPushTipsData(this);
                result.state_ = this.state_;
                result.activityPushTipsId_ = this.activityPushTipsId_;
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
                if (other instanceof ActivityPushTipsData) {
                    return mergeFrom((ActivityPushTipsData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ActivityPushTipsData other) {
                if (other == ActivityPushTipsData.getDefaultInstance()) {
                    return this;
                }
                if (other.state_ != 0) {
                    setStateValue(other.getStateValue());
                }
                if (other.getActivityPushTipsId() != 0) {
                    setActivityPushTipsId(other.getActivityPushTipsId());
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
                ActivityPushTipsData parsedMessage = null;
                try {
                    try {
                        parsedMessage = ActivityPushTipsData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ActivityPushTipsData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ActivityPushTipsDataOuterClass.ActivityPushTipsDataOrBuilder
            public int getStateValue() {
                return this.state_;
            }

            public Builder setStateValue(int value) {
                this.state_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityPushTipsDataOuterClass.ActivityPushTipsDataOrBuilder
            public ActivityPushTipsStateOuterClass.ActivityPushTipsState getState() {
                ActivityPushTipsStateOuterClass.ActivityPushTipsState result = ActivityPushTipsStateOuterClass.ActivityPushTipsState.valueOf(this.state_);
                return result == null ? ActivityPushTipsStateOuterClass.ActivityPushTipsState.UNRECOGNIZED : result;
            }

            public Builder setState(ActivityPushTipsStateOuterClass.ActivityPushTipsState value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.state_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearState() {
                this.state_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityPushTipsDataOuterClass.ActivityPushTipsDataOrBuilder
            public int getActivityPushTipsId() {
                return this.activityPushTipsId_;
            }

            public Builder setActivityPushTipsId(int value) {
                this.activityPushTipsId_ = value;
                onChanged();
                return this;
            }

            public Builder clearActivityPushTipsId() {
                this.activityPushTipsId_ = 0;
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

        public static ActivityPushTipsData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ActivityPushTipsData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ActivityPushTipsData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ActivityPushTipsData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ActivityPushTipsStateOuterClass.getDescriptor();
    }
}
