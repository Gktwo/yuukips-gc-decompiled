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
import emu.grasscutter.net.proto.ActivityScheduleInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityScheduleInfoNotifyOuterClass.class */
public final class ActivityScheduleInfoNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n ActivityScheduleInfoNotify.proto\u001a\u001aActivityScheduleInfo.proto\"t\n\u001aActivityScheduleInfoNotify\u00125\n\u0016activity_schedule_list\u0018\u0001 \u0003(\u000b2\u0015.ActivityScheduleInfo\u0012\u001f\n\u0017remain_fly_sea_lamp_num\u0018\r \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ActivityScheduleInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ActivityScheduleInfoNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ActivityScheduleInfoNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ActivityScheduleInfoNotify_descriptor, new String[]{"ActivityScheduleList", "RemainFlySeaLampNum"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityScheduleInfoNotifyOuterClass$ActivityScheduleInfoNotifyOrBuilder.class */
    public interface ActivityScheduleInfoNotifyOrBuilder extends MessageOrBuilder {
        List<ActivityScheduleInfoOuterClass.ActivityScheduleInfo> getActivityScheduleListList();

        ActivityScheduleInfoOuterClass.ActivityScheduleInfo getActivityScheduleList(int i);

        int getActivityScheduleListCount();

        List<? extends ActivityScheduleInfoOuterClass.ActivityScheduleInfoOrBuilder> getActivityScheduleListOrBuilderList();

        ActivityScheduleInfoOuterClass.ActivityScheduleInfoOrBuilder getActivityScheduleListOrBuilder(int i);

        int getRemainFlySeaLampNum();
    }

    private ActivityScheduleInfoNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityScheduleInfoNotifyOuterClass$ActivityScheduleInfoNotify.class */
    public static final class ActivityScheduleInfoNotify extends GeneratedMessageV3 implements ActivityScheduleInfoNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ACTIVITY_SCHEDULE_LIST_FIELD_NUMBER = 1;
        private List<ActivityScheduleInfoOuterClass.ActivityScheduleInfo> activityScheduleList_;
        public static final int REMAIN_FLY_SEA_LAMP_NUM_FIELD_NUMBER = 13;
        private int remainFlySeaLampNum_;
        private byte memoizedIsInitialized;
        private static final ActivityScheduleInfoNotify DEFAULT_INSTANCE = new ActivityScheduleInfoNotify();
        private static final Parser<ActivityScheduleInfoNotify> PARSER = new AbstractParser<ActivityScheduleInfoNotify>() { // from class: emu.grasscutter.net.proto.ActivityScheduleInfoNotifyOuterClass.ActivityScheduleInfoNotify.1
            @Override // com.google.protobuf.Parser
            public ActivityScheduleInfoNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ActivityScheduleInfoNotify(input, extensionRegistry);
            }
        };

        private ActivityScheduleInfoNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ActivityScheduleInfoNotify() {
            this.memoizedIsInitialized = -1;
            this.activityScheduleList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ActivityScheduleInfoNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ActivityScheduleInfoNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 10:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.activityScheduleList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.activityScheduleList_.add((ActivityScheduleInfoOuterClass.ActivityScheduleInfo) input.readMessage(ActivityScheduleInfoOuterClass.ActivityScheduleInfo.parser(), extensionRegistry));
                                    break;
                                case 104:
                                    this.remainFlySeaLampNum_ = input.readUInt32();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.activityScheduleList_ = Collections.unmodifiableList(this.activityScheduleList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ActivityScheduleInfoNotifyOuterClass.internal_static_ActivityScheduleInfoNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ActivityScheduleInfoNotifyOuterClass.internal_static_ActivityScheduleInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityScheduleInfoNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ActivityScheduleInfoNotifyOuterClass.ActivityScheduleInfoNotifyOrBuilder
        public List<ActivityScheduleInfoOuterClass.ActivityScheduleInfo> getActivityScheduleListList() {
            return this.activityScheduleList_;
        }

        @Override // emu.grasscutter.net.proto.ActivityScheduleInfoNotifyOuterClass.ActivityScheduleInfoNotifyOrBuilder
        public List<? extends ActivityScheduleInfoOuterClass.ActivityScheduleInfoOrBuilder> getActivityScheduleListOrBuilderList() {
            return this.activityScheduleList_;
        }

        @Override // emu.grasscutter.net.proto.ActivityScheduleInfoNotifyOuterClass.ActivityScheduleInfoNotifyOrBuilder
        public int getActivityScheduleListCount() {
            return this.activityScheduleList_.size();
        }

        @Override // emu.grasscutter.net.proto.ActivityScheduleInfoNotifyOuterClass.ActivityScheduleInfoNotifyOrBuilder
        public ActivityScheduleInfoOuterClass.ActivityScheduleInfo getActivityScheduleList(int index) {
            return this.activityScheduleList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ActivityScheduleInfoNotifyOuterClass.ActivityScheduleInfoNotifyOrBuilder
        public ActivityScheduleInfoOuterClass.ActivityScheduleInfoOrBuilder getActivityScheduleListOrBuilder(int index) {
            return this.activityScheduleList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ActivityScheduleInfoNotifyOuterClass.ActivityScheduleInfoNotifyOrBuilder
        public int getRemainFlySeaLampNum() {
            return this.remainFlySeaLampNum_;
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
            for (int i = 0; i < this.activityScheduleList_.size(); i++) {
                output.writeMessage(1, this.activityScheduleList_.get(i));
            }
            if (this.remainFlySeaLampNum_ != 0) {
                output.writeUInt32(13, this.remainFlySeaLampNum_);
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
            for (int i = 0; i < this.activityScheduleList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.activityScheduleList_.get(i));
            }
            if (this.remainFlySeaLampNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.remainFlySeaLampNum_);
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
            if (!(obj instanceof ActivityScheduleInfoNotify)) {
                return equals(obj);
            }
            ActivityScheduleInfoNotify other = (ActivityScheduleInfoNotify) obj;
            return getActivityScheduleListList().equals(other.getActivityScheduleListList()) && getRemainFlySeaLampNum() == other.getRemainFlySeaLampNum() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getActivityScheduleListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getActivityScheduleListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 13)) + getRemainFlySeaLampNum())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ActivityScheduleInfoNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityScheduleInfoNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityScheduleInfoNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityScheduleInfoNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityScheduleInfoNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityScheduleInfoNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityScheduleInfoNotify parseFrom(InputStream input) throws IOException {
            return (ActivityScheduleInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ActivityScheduleInfoNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityScheduleInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ActivityScheduleInfoNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ActivityScheduleInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ActivityScheduleInfoNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityScheduleInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ActivityScheduleInfoNotify parseFrom(CodedInputStream input) throws IOException {
            return (ActivityScheduleInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ActivityScheduleInfoNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityScheduleInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ActivityScheduleInfoNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityScheduleInfoNotifyOuterClass$ActivityScheduleInfoNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ActivityScheduleInfoNotifyOrBuilder {
            private int bitField0_;
            private List<ActivityScheduleInfoOuterClass.ActivityScheduleInfo> activityScheduleList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ActivityScheduleInfoOuterClass.ActivityScheduleInfo, ActivityScheduleInfoOuterClass.ActivityScheduleInfo.Builder, ActivityScheduleInfoOuterClass.ActivityScheduleInfoOrBuilder> activityScheduleListBuilder_;
            private int remainFlySeaLampNum_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ActivityScheduleInfoNotifyOuterClass.internal_static_ActivityScheduleInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ActivityScheduleInfoNotifyOuterClass.internal_static_ActivityScheduleInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityScheduleInfoNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ActivityScheduleInfoNotify.alwaysUseFieldBuilders) {
                    getActivityScheduleListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.activityScheduleListBuilder_ == null) {
                    this.activityScheduleList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.activityScheduleListBuilder_.clear();
                }
                this.remainFlySeaLampNum_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ActivityScheduleInfoNotifyOuterClass.internal_static_ActivityScheduleInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ActivityScheduleInfoNotify getDefaultInstanceForType() {
                return ActivityScheduleInfoNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ActivityScheduleInfoNotify build() {
                ActivityScheduleInfoNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ActivityScheduleInfoNotify buildPartial() {
                ActivityScheduleInfoNotify result = new ActivityScheduleInfoNotify(this);
                int i = this.bitField0_;
                if (this.activityScheduleListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.activityScheduleList_ = Collections.unmodifiableList(this.activityScheduleList_);
                        this.bitField0_ &= -2;
                    }
                    result.activityScheduleList_ = this.activityScheduleList_;
                } else {
                    result.activityScheduleList_ = this.activityScheduleListBuilder_.build();
                }
                result.remainFlySeaLampNum_ = this.remainFlySeaLampNum_;
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
                if (other instanceof ActivityScheduleInfoNotify) {
                    return mergeFrom((ActivityScheduleInfoNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ActivityScheduleInfoNotify other) {
                if (other == ActivityScheduleInfoNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.activityScheduleListBuilder_ == null) {
                    if (!other.activityScheduleList_.isEmpty()) {
                        if (this.activityScheduleList_.isEmpty()) {
                            this.activityScheduleList_ = other.activityScheduleList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureActivityScheduleListIsMutable();
                            this.activityScheduleList_.addAll(other.activityScheduleList_);
                        }
                        onChanged();
                    }
                } else if (!other.activityScheduleList_.isEmpty()) {
                    if (this.activityScheduleListBuilder_.isEmpty()) {
                        this.activityScheduleListBuilder_.dispose();
                        this.activityScheduleListBuilder_ = null;
                        this.activityScheduleList_ = other.activityScheduleList_;
                        this.bitField0_ &= -2;
                        this.activityScheduleListBuilder_ = ActivityScheduleInfoNotify.alwaysUseFieldBuilders ? getActivityScheduleListFieldBuilder() : null;
                    } else {
                        this.activityScheduleListBuilder_.addAllMessages(other.activityScheduleList_);
                    }
                }
                if (other.getRemainFlySeaLampNum() != 0) {
                    setRemainFlySeaLampNum(other.getRemainFlySeaLampNum());
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
                ActivityScheduleInfoNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ActivityScheduleInfoNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ActivityScheduleInfoNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureActivityScheduleListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.activityScheduleList_ = new ArrayList(this.activityScheduleList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ActivityScheduleInfoNotifyOuterClass.ActivityScheduleInfoNotifyOrBuilder
            public List<ActivityScheduleInfoOuterClass.ActivityScheduleInfo> getActivityScheduleListList() {
                if (this.activityScheduleListBuilder_ == null) {
                    return Collections.unmodifiableList(this.activityScheduleList_);
                }
                return this.activityScheduleListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ActivityScheduleInfoNotifyOuterClass.ActivityScheduleInfoNotifyOrBuilder
            public int getActivityScheduleListCount() {
                if (this.activityScheduleListBuilder_ == null) {
                    return this.activityScheduleList_.size();
                }
                return this.activityScheduleListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ActivityScheduleInfoNotifyOuterClass.ActivityScheduleInfoNotifyOrBuilder
            public ActivityScheduleInfoOuterClass.ActivityScheduleInfo getActivityScheduleList(int index) {
                if (this.activityScheduleListBuilder_ == null) {
                    return this.activityScheduleList_.get(index);
                }
                return this.activityScheduleListBuilder_.getMessage(index);
            }

            public Builder setActivityScheduleList(int index, ActivityScheduleInfoOuterClass.ActivityScheduleInfo value) {
                if (this.activityScheduleListBuilder_ != null) {
                    this.activityScheduleListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureActivityScheduleListIsMutable();
                    this.activityScheduleList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setActivityScheduleList(int index, ActivityScheduleInfoOuterClass.ActivityScheduleInfo.Builder builderForValue) {
                if (this.activityScheduleListBuilder_ == null) {
                    ensureActivityScheduleListIsMutable();
                    this.activityScheduleList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.activityScheduleListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addActivityScheduleList(ActivityScheduleInfoOuterClass.ActivityScheduleInfo value) {
                if (this.activityScheduleListBuilder_ != null) {
                    this.activityScheduleListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureActivityScheduleListIsMutable();
                    this.activityScheduleList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addActivityScheduleList(int index, ActivityScheduleInfoOuterClass.ActivityScheduleInfo value) {
                if (this.activityScheduleListBuilder_ != null) {
                    this.activityScheduleListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureActivityScheduleListIsMutable();
                    this.activityScheduleList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addActivityScheduleList(ActivityScheduleInfoOuterClass.ActivityScheduleInfo.Builder builderForValue) {
                if (this.activityScheduleListBuilder_ == null) {
                    ensureActivityScheduleListIsMutable();
                    this.activityScheduleList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.activityScheduleListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addActivityScheduleList(int index, ActivityScheduleInfoOuterClass.ActivityScheduleInfo.Builder builderForValue) {
                if (this.activityScheduleListBuilder_ == null) {
                    ensureActivityScheduleListIsMutable();
                    this.activityScheduleList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.activityScheduleListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllActivityScheduleList(Iterable<? extends ActivityScheduleInfoOuterClass.ActivityScheduleInfo> values) {
                if (this.activityScheduleListBuilder_ == null) {
                    ensureActivityScheduleListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.activityScheduleList_);
                    onChanged();
                } else {
                    this.activityScheduleListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearActivityScheduleList() {
                if (this.activityScheduleListBuilder_ == null) {
                    this.activityScheduleList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.activityScheduleListBuilder_.clear();
                }
                return this;
            }

            public Builder removeActivityScheduleList(int index) {
                if (this.activityScheduleListBuilder_ == null) {
                    ensureActivityScheduleListIsMutable();
                    this.activityScheduleList_.remove(index);
                    onChanged();
                } else {
                    this.activityScheduleListBuilder_.remove(index);
                }
                return this;
            }

            public ActivityScheduleInfoOuterClass.ActivityScheduleInfo.Builder getActivityScheduleListBuilder(int index) {
                return getActivityScheduleListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ActivityScheduleInfoNotifyOuterClass.ActivityScheduleInfoNotifyOrBuilder
            public ActivityScheduleInfoOuterClass.ActivityScheduleInfoOrBuilder getActivityScheduleListOrBuilder(int index) {
                if (this.activityScheduleListBuilder_ == null) {
                    return this.activityScheduleList_.get(index);
                }
                return this.activityScheduleListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ActivityScheduleInfoNotifyOuterClass.ActivityScheduleInfoNotifyOrBuilder
            public List<? extends ActivityScheduleInfoOuterClass.ActivityScheduleInfoOrBuilder> getActivityScheduleListOrBuilderList() {
                if (this.activityScheduleListBuilder_ != null) {
                    return this.activityScheduleListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.activityScheduleList_);
            }

            public ActivityScheduleInfoOuterClass.ActivityScheduleInfo.Builder addActivityScheduleListBuilder() {
                return getActivityScheduleListFieldBuilder().addBuilder(ActivityScheduleInfoOuterClass.ActivityScheduleInfo.getDefaultInstance());
            }

            public ActivityScheduleInfoOuterClass.ActivityScheduleInfo.Builder addActivityScheduleListBuilder(int index) {
                return getActivityScheduleListFieldBuilder().addBuilder(index, ActivityScheduleInfoOuterClass.ActivityScheduleInfo.getDefaultInstance());
            }

            public List<ActivityScheduleInfoOuterClass.ActivityScheduleInfo.Builder> getActivityScheduleListBuilderList() {
                return getActivityScheduleListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ActivityScheduleInfoOuterClass.ActivityScheduleInfo, ActivityScheduleInfoOuterClass.ActivityScheduleInfo.Builder, ActivityScheduleInfoOuterClass.ActivityScheduleInfoOrBuilder> getActivityScheduleListFieldBuilder() {
                if (this.activityScheduleListBuilder_ == null) {
                    this.activityScheduleListBuilder_ = new RepeatedFieldBuilderV3<>(this.activityScheduleList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.activityScheduleList_ = null;
                }
                return this.activityScheduleListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityScheduleInfoNotifyOuterClass.ActivityScheduleInfoNotifyOrBuilder
            public int getRemainFlySeaLampNum() {
                return this.remainFlySeaLampNum_;
            }

            public Builder setRemainFlySeaLampNum(int value) {
                this.remainFlySeaLampNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearRemainFlySeaLampNum() {
                this.remainFlySeaLampNum_ = 0;
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

        public static ActivityScheduleInfoNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ActivityScheduleInfoNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ActivityScheduleInfoNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ActivityScheduleInfoNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ActivityScheduleInfoOuterClass.getDescriptor();
    }
}
