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
import emu.grasscutter.net.proto.DailyTaskInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorldOwnerDailyTaskNotifyOuterClass.class */
public final class WorldOwnerDailyTaskNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fWorldOwnerDailyTaskNotify.proto\u001a\u0013DailyTaskInfo.proto\"w\n\u0019WorldOwnerDailyTaskNotify\u0012\u0016\n\u000efilter_city_id\u0018\u0004 \u0001(\r\u0012!\n\ttask_list\u0018\u0002 \u0003(\u000b2\u000e.DailyTaskInfo\u0012\u001f\n\u0017finished_daily_task_num\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{DailyTaskInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WorldOwnerDailyTaskNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WorldOwnerDailyTaskNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WorldOwnerDailyTaskNotify_descriptor, new String[]{"FilterCityId", "TaskList", "FinishedDailyTaskNum"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorldOwnerDailyTaskNotifyOuterClass$WorldOwnerDailyTaskNotifyOrBuilder.class */
    public interface WorldOwnerDailyTaskNotifyOrBuilder extends MessageOrBuilder {
        int getFilterCityId();

        List<DailyTaskInfoOuterClass.DailyTaskInfo> getTaskListList();

        DailyTaskInfoOuterClass.DailyTaskInfo getTaskList(int i);

        int getTaskListCount();

        List<? extends DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder> getTaskListOrBuilderList();

        DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder getTaskListOrBuilder(int i);

        int getFinishedDailyTaskNum();
    }

    private WorldOwnerDailyTaskNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorldOwnerDailyTaskNotifyOuterClass$WorldOwnerDailyTaskNotify.class */
    public static final class WorldOwnerDailyTaskNotify extends GeneratedMessageV3 implements WorldOwnerDailyTaskNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FILTER_CITY_ID_FIELD_NUMBER = 4;
        private int filterCityId_;
        public static final int TASK_LIST_FIELD_NUMBER = 2;
        private List<DailyTaskInfoOuterClass.DailyTaskInfo> taskList_;
        public static final int FINISHED_DAILY_TASK_NUM_FIELD_NUMBER = 9;
        private int finishedDailyTaskNum_;
        private byte memoizedIsInitialized;
        private static final WorldOwnerDailyTaskNotify DEFAULT_INSTANCE = new WorldOwnerDailyTaskNotify();
        private static final Parser<WorldOwnerDailyTaskNotify> PARSER = new AbstractParser<WorldOwnerDailyTaskNotify>() { // from class: emu.grasscutter.net.proto.WorldOwnerDailyTaskNotifyOuterClass.WorldOwnerDailyTaskNotify.1
            @Override // com.google.protobuf.Parser
            public WorldOwnerDailyTaskNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WorldOwnerDailyTaskNotify(input, extensionRegistry);
            }
        };

        private WorldOwnerDailyTaskNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WorldOwnerDailyTaskNotify() {
            this.memoizedIsInitialized = -1;
            this.taskList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WorldOwnerDailyTaskNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WorldOwnerDailyTaskNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 18:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.taskList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.taskList_.add((DailyTaskInfoOuterClass.DailyTaskInfo) input.readMessage(DailyTaskInfoOuterClass.DailyTaskInfo.parser(), extensionRegistry));
                                break;
                            case 32:
                                this.filterCityId_ = input.readUInt32();
                                break;
                            case 72:
                                this.finishedDailyTaskNum_ = input.readUInt32();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.taskList_ = Collections.unmodifiableList(this.taskList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WorldOwnerDailyTaskNotifyOuterClass.internal_static_WorldOwnerDailyTaskNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WorldOwnerDailyTaskNotifyOuterClass.internal_static_WorldOwnerDailyTaskNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WorldOwnerDailyTaskNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WorldOwnerDailyTaskNotifyOuterClass.WorldOwnerDailyTaskNotifyOrBuilder
        public int getFilterCityId() {
            return this.filterCityId_;
        }

        @Override // emu.grasscutter.net.proto.WorldOwnerDailyTaskNotifyOuterClass.WorldOwnerDailyTaskNotifyOrBuilder
        public List<DailyTaskInfoOuterClass.DailyTaskInfo> getTaskListList() {
            return this.taskList_;
        }

        @Override // emu.grasscutter.net.proto.WorldOwnerDailyTaskNotifyOuterClass.WorldOwnerDailyTaskNotifyOrBuilder
        public List<? extends DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder> getTaskListOrBuilderList() {
            return this.taskList_;
        }

        @Override // emu.grasscutter.net.proto.WorldOwnerDailyTaskNotifyOuterClass.WorldOwnerDailyTaskNotifyOrBuilder
        public int getTaskListCount() {
            return this.taskList_.size();
        }

        @Override // emu.grasscutter.net.proto.WorldOwnerDailyTaskNotifyOuterClass.WorldOwnerDailyTaskNotifyOrBuilder
        public DailyTaskInfoOuterClass.DailyTaskInfo getTaskList(int index) {
            return this.taskList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WorldOwnerDailyTaskNotifyOuterClass.WorldOwnerDailyTaskNotifyOrBuilder
        public DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder getTaskListOrBuilder(int index) {
            return this.taskList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WorldOwnerDailyTaskNotifyOuterClass.WorldOwnerDailyTaskNotifyOrBuilder
        public int getFinishedDailyTaskNum() {
            return this.finishedDailyTaskNum_;
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
            for (int i = 0; i < this.taskList_.size(); i++) {
                output.writeMessage(2, this.taskList_.get(i));
            }
            if (this.filterCityId_ != 0) {
                output.writeUInt32(4, this.filterCityId_);
            }
            if (this.finishedDailyTaskNum_ != 0) {
                output.writeUInt32(9, this.finishedDailyTaskNum_);
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
            for (int i = 0; i < this.taskList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.taskList_.get(i));
            }
            if (this.filterCityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.filterCityId_);
            }
            if (this.finishedDailyTaskNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.finishedDailyTaskNum_);
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
            if (!(obj instanceof WorldOwnerDailyTaskNotify)) {
                return equals(obj);
            }
            WorldOwnerDailyTaskNotify other = (WorldOwnerDailyTaskNotify) obj;
            return getFilterCityId() == other.getFilterCityId() && getTaskListList().equals(other.getTaskListList()) && getFinishedDailyTaskNum() == other.getFinishedDailyTaskNum() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getFilterCityId();
            if (getTaskListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getTaskListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 9)) + getFinishedDailyTaskNum())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WorldOwnerDailyTaskNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WorldOwnerDailyTaskNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorldOwnerDailyTaskNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WorldOwnerDailyTaskNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorldOwnerDailyTaskNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WorldOwnerDailyTaskNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WorldOwnerDailyTaskNotify parseFrom(InputStream input) throws IOException {
            return (WorldOwnerDailyTaskNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WorldOwnerDailyTaskNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldOwnerDailyTaskNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WorldOwnerDailyTaskNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (WorldOwnerDailyTaskNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WorldOwnerDailyTaskNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldOwnerDailyTaskNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WorldOwnerDailyTaskNotify parseFrom(CodedInputStream input) throws IOException {
            return (WorldOwnerDailyTaskNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WorldOwnerDailyTaskNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WorldOwnerDailyTaskNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WorldOwnerDailyTaskNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WorldOwnerDailyTaskNotifyOuterClass$WorldOwnerDailyTaskNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WorldOwnerDailyTaskNotifyOrBuilder {
            private int bitField0_;
            private int filterCityId_;
            private List<DailyTaskInfoOuterClass.DailyTaskInfo> taskList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<DailyTaskInfoOuterClass.DailyTaskInfo, DailyTaskInfoOuterClass.DailyTaskInfo.Builder, DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder> taskListBuilder_;
            private int finishedDailyTaskNum_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WorldOwnerDailyTaskNotifyOuterClass.internal_static_WorldOwnerDailyTaskNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WorldOwnerDailyTaskNotifyOuterClass.internal_static_WorldOwnerDailyTaskNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WorldOwnerDailyTaskNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WorldOwnerDailyTaskNotify.alwaysUseFieldBuilders) {
                    getTaskListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.filterCityId_ = 0;
                if (this.taskListBuilder_ == null) {
                    this.taskList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.taskListBuilder_.clear();
                }
                this.finishedDailyTaskNum_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WorldOwnerDailyTaskNotifyOuterClass.internal_static_WorldOwnerDailyTaskNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WorldOwnerDailyTaskNotify getDefaultInstanceForType() {
                return WorldOwnerDailyTaskNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WorldOwnerDailyTaskNotify build() {
                WorldOwnerDailyTaskNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WorldOwnerDailyTaskNotify buildPartial() {
                WorldOwnerDailyTaskNotify result = new WorldOwnerDailyTaskNotify(this);
                int i = this.bitField0_;
                result.filterCityId_ = this.filterCityId_;
                if (this.taskListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.taskList_ = Collections.unmodifiableList(this.taskList_);
                        this.bitField0_ &= -2;
                    }
                    result.taskList_ = this.taskList_;
                } else {
                    result.taskList_ = this.taskListBuilder_.build();
                }
                result.finishedDailyTaskNum_ = this.finishedDailyTaskNum_;
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
                if (other instanceof WorldOwnerDailyTaskNotify) {
                    return mergeFrom((WorldOwnerDailyTaskNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WorldOwnerDailyTaskNotify other) {
                if (other == WorldOwnerDailyTaskNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getFilterCityId() != 0) {
                    setFilterCityId(other.getFilterCityId());
                }
                if (this.taskListBuilder_ == null) {
                    if (!other.taskList_.isEmpty()) {
                        if (this.taskList_.isEmpty()) {
                            this.taskList_ = other.taskList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureTaskListIsMutable();
                            this.taskList_.addAll(other.taskList_);
                        }
                        onChanged();
                    }
                } else if (!other.taskList_.isEmpty()) {
                    if (this.taskListBuilder_.isEmpty()) {
                        this.taskListBuilder_.dispose();
                        this.taskListBuilder_ = null;
                        this.taskList_ = other.taskList_;
                        this.bitField0_ &= -2;
                        this.taskListBuilder_ = WorldOwnerDailyTaskNotify.alwaysUseFieldBuilders ? getTaskListFieldBuilder() : null;
                    } else {
                        this.taskListBuilder_.addAllMessages(other.taskList_);
                    }
                }
                if (other.getFinishedDailyTaskNum() != 0) {
                    setFinishedDailyTaskNum(other.getFinishedDailyTaskNum());
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
                WorldOwnerDailyTaskNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = WorldOwnerDailyTaskNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WorldOwnerDailyTaskNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.WorldOwnerDailyTaskNotifyOuterClass.WorldOwnerDailyTaskNotifyOrBuilder
            public int getFilterCityId() {
                return this.filterCityId_;
            }

            public Builder setFilterCityId(int value) {
                this.filterCityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearFilterCityId() {
                this.filterCityId_ = 0;
                onChanged();
                return this;
            }

            private void ensureTaskListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.taskList_ = new ArrayList(this.taskList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.WorldOwnerDailyTaskNotifyOuterClass.WorldOwnerDailyTaskNotifyOrBuilder
            public List<DailyTaskInfoOuterClass.DailyTaskInfo> getTaskListList() {
                if (this.taskListBuilder_ == null) {
                    return Collections.unmodifiableList(this.taskList_);
                }
                return this.taskListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.WorldOwnerDailyTaskNotifyOuterClass.WorldOwnerDailyTaskNotifyOrBuilder
            public int getTaskListCount() {
                if (this.taskListBuilder_ == null) {
                    return this.taskList_.size();
                }
                return this.taskListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.WorldOwnerDailyTaskNotifyOuterClass.WorldOwnerDailyTaskNotifyOrBuilder
            public DailyTaskInfoOuterClass.DailyTaskInfo getTaskList(int index) {
                if (this.taskListBuilder_ == null) {
                    return this.taskList_.get(index);
                }
                return this.taskListBuilder_.getMessage(index);
            }

            public Builder setTaskList(int index, DailyTaskInfoOuterClass.DailyTaskInfo value) {
                if (this.taskListBuilder_ != null) {
                    this.taskListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTaskListIsMutable();
                    this.taskList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTaskList(int index, DailyTaskInfoOuterClass.DailyTaskInfo.Builder builderForValue) {
                if (this.taskListBuilder_ == null) {
                    ensureTaskListIsMutable();
                    this.taskList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.taskListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTaskList(DailyTaskInfoOuterClass.DailyTaskInfo value) {
                if (this.taskListBuilder_ != null) {
                    this.taskListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTaskListIsMutable();
                    this.taskList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTaskList(int index, DailyTaskInfoOuterClass.DailyTaskInfo value) {
                if (this.taskListBuilder_ != null) {
                    this.taskListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTaskListIsMutable();
                    this.taskList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTaskList(DailyTaskInfoOuterClass.DailyTaskInfo.Builder builderForValue) {
                if (this.taskListBuilder_ == null) {
                    ensureTaskListIsMutable();
                    this.taskList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.taskListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTaskList(int index, DailyTaskInfoOuterClass.DailyTaskInfo.Builder builderForValue) {
                if (this.taskListBuilder_ == null) {
                    ensureTaskListIsMutable();
                    this.taskList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.taskListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTaskList(Iterable<? extends DailyTaskInfoOuterClass.DailyTaskInfo> values) {
                if (this.taskListBuilder_ == null) {
                    ensureTaskListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.taskList_);
                    onChanged();
                } else {
                    this.taskListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTaskList() {
                if (this.taskListBuilder_ == null) {
                    this.taskList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.taskListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTaskList(int index) {
                if (this.taskListBuilder_ == null) {
                    ensureTaskListIsMutable();
                    this.taskList_.remove(index);
                    onChanged();
                } else {
                    this.taskListBuilder_.remove(index);
                }
                return this;
            }

            public DailyTaskInfoOuterClass.DailyTaskInfo.Builder getTaskListBuilder(int index) {
                return getTaskListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WorldOwnerDailyTaskNotifyOuterClass.WorldOwnerDailyTaskNotifyOrBuilder
            public DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder getTaskListOrBuilder(int index) {
                if (this.taskListBuilder_ == null) {
                    return this.taskList_.get(index);
                }
                return this.taskListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WorldOwnerDailyTaskNotifyOuterClass.WorldOwnerDailyTaskNotifyOrBuilder
            public List<? extends DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder> getTaskListOrBuilderList() {
                if (this.taskListBuilder_ != null) {
                    return this.taskListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.taskList_);
            }

            public DailyTaskInfoOuterClass.DailyTaskInfo.Builder addTaskListBuilder() {
                return getTaskListFieldBuilder().addBuilder(DailyTaskInfoOuterClass.DailyTaskInfo.getDefaultInstance());
            }

            public DailyTaskInfoOuterClass.DailyTaskInfo.Builder addTaskListBuilder(int index) {
                return getTaskListFieldBuilder().addBuilder(index, DailyTaskInfoOuterClass.DailyTaskInfo.getDefaultInstance());
            }

            public List<DailyTaskInfoOuterClass.DailyTaskInfo.Builder> getTaskListBuilderList() {
                return getTaskListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<DailyTaskInfoOuterClass.DailyTaskInfo, DailyTaskInfoOuterClass.DailyTaskInfo.Builder, DailyTaskInfoOuterClass.DailyTaskInfoOrBuilder> getTaskListFieldBuilder() {
                if (this.taskListBuilder_ == null) {
                    this.taskListBuilder_ = new RepeatedFieldBuilderV3<>(this.taskList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.taskList_ = null;
                }
                return this.taskListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.WorldOwnerDailyTaskNotifyOuterClass.WorldOwnerDailyTaskNotifyOrBuilder
            public int getFinishedDailyTaskNum() {
                return this.finishedDailyTaskNum_;
            }

            public Builder setFinishedDailyTaskNum(int value) {
                this.finishedDailyTaskNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearFinishedDailyTaskNum() {
                this.finishedDailyTaskNum_ = 0;
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

        public static WorldOwnerDailyTaskNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WorldOwnerDailyTaskNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WorldOwnerDailyTaskNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WorldOwnerDailyTaskNotify getDefaultInstanceForType() {
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
