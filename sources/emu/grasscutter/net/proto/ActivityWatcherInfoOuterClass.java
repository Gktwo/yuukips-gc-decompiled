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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityWatcherInfoOuterClass.class */
public final class ActivityWatcherInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019ActivityWatcherInfo.proto\"p\n\u0013ActivityWatcherInfo\u0012\u0017\n\u000fis_taken_reward\u0018\u0002 \u0001(\b\u0012\u0016\n\u000etotal_progress\u0018\u0001 \u0001(\r\u0012\u0014\n\fcur_progress\u0018\b \u0001(\r\u0012\u0012\n\nwatcher_id\u0018\u000e \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ActivityWatcherInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ActivityWatcherInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ActivityWatcherInfo_descriptor, new String[]{"IsTakenReward", "TotalProgress", "CurProgress", "WatcherId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityWatcherInfoOuterClass$ActivityWatcherInfoOrBuilder.class */
    public interface ActivityWatcherInfoOrBuilder extends MessageOrBuilder {
        boolean getIsTakenReward();

        int getTotalProgress();

        int getCurProgress();

        int getWatcherId();
    }

    private ActivityWatcherInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityWatcherInfoOuterClass$ActivityWatcherInfo.class */
    public static final class ActivityWatcherInfo extends GeneratedMessageV3 implements ActivityWatcherInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_TAKEN_REWARD_FIELD_NUMBER = 2;
        private boolean isTakenReward_;
        public static final int TOTAL_PROGRESS_FIELD_NUMBER = 1;
        private int totalProgress_;
        public static final int CUR_PROGRESS_FIELD_NUMBER = 8;
        private int curProgress_;
        public static final int WATCHER_ID_FIELD_NUMBER = 14;
        private int watcherId_;
        private byte memoizedIsInitialized;
        private static final ActivityWatcherInfo DEFAULT_INSTANCE = new ActivityWatcherInfo();
        private static final Parser<ActivityWatcherInfo> PARSER = new AbstractParser<ActivityWatcherInfo>() { // from class: emu.grasscutter.net.proto.ActivityWatcherInfoOuterClass.ActivityWatcherInfo.1
            @Override // com.google.protobuf.Parser
            public ActivityWatcherInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ActivityWatcherInfo(input, extensionRegistry);
            }
        };

        private ActivityWatcherInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ActivityWatcherInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ActivityWatcherInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ActivityWatcherInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.totalProgress_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.isTakenReward_ = input.readBool();
                                    break;
                                case 64:
                                    this.curProgress_ = input.readUInt32();
                                    break;
                                case 112:
                                    this.watcherId_ = input.readUInt32();
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
            return ActivityWatcherInfoOuterClass.internal_static_ActivityWatcherInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ActivityWatcherInfoOuterClass.internal_static_ActivityWatcherInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityWatcherInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder
        public boolean getIsTakenReward() {
            return this.isTakenReward_;
        }

        @Override // emu.grasscutter.net.proto.ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder
        public int getTotalProgress() {
            return this.totalProgress_;
        }

        @Override // emu.grasscutter.net.proto.ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder
        public int getCurProgress() {
            return this.curProgress_;
        }

        @Override // emu.grasscutter.net.proto.ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder
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
            if (this.totalProgress_ != 0) {
                output.writeUInt32(1, this.totalProgress_);
            }
            if (this.isTakenReward_) {
                output.writeBool(2, this.isTakenReward_);
            }
            if (this.curProgress_ != 0) {
                output.writeUInt32(8, this.curProgress_);
            }
            if (this.watcherId_ != 0) {
                output.writeUInt32(14, this.watcherId_);
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
            if (this.totalProgress_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.totalProgress_);
            }
            if (this.isTakenReward_) {
                size2 += CodedOutputStream.computeBoolSize(2, this.isTakenReward_);
            }
            if (this.curProgress_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.curProgress_);
            }
            if (this.watcherId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.watcherId_);
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
            if (!(obj instanceof ActivityWatcherInfo)) {
                return equals(obj);
            }
            ActivityWatcherInfo other = (ActivityWatcherInfo) obj;
            return getIsTakenReward() == other.getIsTakenReward() && getTotalProgress() == other.getTotalProgress() && getCurProgress() == other.getCurProgress() && getWatcherId() == other.getWatcherId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + Internal.hashBoolean(getIsTakenReward()))) + 1)) + getTotalProgress())) + 8)) + getCurProgress())) + 14)) + getWatcherId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ActivityWatcherInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityWatcherInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityWatcherInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityWatcherInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityWatcherInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityWatcherInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityWatcherInfo parseFrom(InputStream input) throws IOException {
            return (ActivityWatcherInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ActivityWatcherInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityWatcherInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ActivityWatcherInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ActivityWatcherInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ActivityWatcherInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityWatcherInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ActivityWatcherInfo parseFrom(CodedInputStream input) throws IOException {
            return (ActivityWatcherInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ActivityWatcherInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityWatcherInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ActivityWatcherInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityWatcherInfoOuterClass$ActivityWatcherInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ActivityWatcherInfoOrBuilder {
            private boolean isTakenReward_;
            private int totalProgress_;
            private int curProgress_;
            private int watcherId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ActivityWatcherInfoOuterClass.internal_static_ActivityWatcherInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ActivityWatcherInfoOuterClass.internal_static_ActivityWatcherInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityWatcherInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ActivityWatcherInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isTakenReward_ = false;
                this.totalProgress_ = 0;
                this.curProgress_ = 0;
                this.watcherId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ActivityWatcherInfoOuterClass.internal_static_ActivityWatcherInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ActivityWatcherInfo getDefaultInstanceForType() {
                return ActivityWatcherInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ActivityWatcherInfo build() {
                ActivityWatcherInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ActivityWatcherInfo buildPartial() {
                ActivityWatcherInfo result = new ActivityWatcherInfo(this);
                result.isTakenReward_ = this.isTakenReward_;
                result.totalProgress_ = this.totalProgress_;
                result.curProgress_ = this.curProgress_;
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
                if (other instanceof ActivityWatcherInfo) {
                    return mergeFrom((ActivityWatcherInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ActivityWatcherInfo other) {
                if (other == ActivityWatcherInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsTakenReward()) {
                    setIsTakenReward(other.getIsTakenReward());
                }
                if (other.getTotalProgress() != 0) {
                    setTotalProgress(other.getTotalProgress());
                }
                if (other.getCurProgress() != 0) {
                    setCurProgress(other.getCurProgress());
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
                ActivityWatcherInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ActivityWatcherInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ActivityWatcherInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder
            public boolean getIsTakenReward() {
                return this.isTakenReward_;
            }

            public Builder setIsTakenReward(boolean value) {
                this.isTakenReward_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsTakenReward() {
                this.isTakenReward_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder
            public int getTotalProgress() {
                return this.totalProgress_;
            }

            public Builder setTotalProgress(int value) {
                this.totalProgress_ = value;
                onChanged();
                return this;
            }

            public Builder clearTotalProgress() {
                this.totalProgress_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder
            public int getCurProgress() {
                return this.curProgress_;
            }

            public Builder setCurProgress(int value) {
                this.curProgress_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurProgress() {
                this.curProgress_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder
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

        public static ActivityWatcherInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ActivityWatcherInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ActivityWatcherInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ActivityWatcherInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
