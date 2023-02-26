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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityShopSheetInfoOuterClass.class */
public final class ActivityShopSheetInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bActivityShopSheetInfo.proto\"L\n\u0015ActivityShopSheetInfo\u0012\u0011\n\tbeginTime\u0018\u0005 \u0001(\r\u0012\u000f\n\u0007sheetId\u0018\u000e \u0001(\r\u0012\u000f\n\u0007endTime\u0018\f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ActivityShopSheetInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ActivityShopSheetInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ActivityShopSheetInfo_descriptor, new String[]{"BeginTime", "SheetId", "EndTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityShopSheetInfoOuterClass$ActivityShopSheetInfoOrBuilder.class */
    public interface ActivityShopSheetInfoOrBuilder extends MessageOrBuilder {
        int getBeginTime();

        int getSheetId();

        int getEndTime();
    }

    private ActivityShopSheetInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityShopSheetInfoOuterClass$ActivityShopSheetInfo.class */
    public static final class ActivityShopSheetInfo extends GeneratedMessageV3 implements ActivityShopSheetInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BEGINTIME_FIELD_NUMBER = 5;
        private int beginTime_;
        public static final int SHEETID_FIELD_NUMBER = 14;
        private int sheetId_;
        public static final int ENDTIME_FIELD_NUMBER = 12;
        private int endTime_;
        private byte memoizedIsInitialized;
        private static final ActivityShopSheetInfo DEFAULT_INSTANCE = new ActivityShopSheetInfo();
        private static final Parser<ActivityShopSheetInfo> PARSER = new AbstractParser<ActivityShopSheetInfo>() { // from class: emu.grasscutter.net.proto.ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo.1
            @Override // com.google.protobuf.Parser
            public ActivityShopSheetInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ActivityShopSheetInfo(input, extensionRegistry);
            }
        };

        private ActivityShopSheetInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ActivityShopSheetInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ActivityShopSheetInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ActivityShopSheetInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 40:
                                    this.beginTime_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.endTime_ = input.readUInt32();
                                    break;
                                case 112:
                                    this.sheetId_ = input.readUInt32();
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
            return ActivityShopSheetInfoOuterClass.internal_static_ActivityShopSheetInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ActivityShopSheetInfoOuterClass.internal_static_ActivityShopSheetInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityShopSheetInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ActivityShopSheetInfoOuterClass.ActivityShopSheetInfoOrBuilder
        public int getBeginTime() {
            return this.beginTime_;
        }

        @Override // emu.grasscutter.net.proto.ActivityShopSheetInfoOuterClass.ActivityShopSheetInfoOrBuilder
        public int getSheetId() {
            return this.sheetId_;
        }

        @Override // emu.grasscutter.net.proto.ActivityShopSheetInfoOuterClass.ActivityShopSheetInfoOrBuilder
        public int getEndTime() {
            return this.endTime_;
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
                output.writeUInt32(5, this.beginTime_);
            }
            if (this.endTime_ != 0) {
                output.writeUInt32(12, this.endTime_);
            }
            if (this.sheetId_ != 0) {
                output.writeUInt32(14, this.sheetId_);
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(5, this.beginTime_);
            }
            if (this.endTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.endTime_);
            }
            if (this.sheetId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.sheetId_);
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
            if (!(obj instanceof ActivityShopSheetInfo)) {
                return equals(obj);
            }
            ActivityShopSheetInfo other = (ActivityShopSheetInfo) obj;
            return getBeginTime() == other.getBeginTime() && getSheetId() == other.getSheetId() && getEndTime() == other.getEndTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getBeginTime())) + 14)) + getSheetId())) + 12)) + getEndTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ActivityShopSheetInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityShopSheetInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityShopSheetInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityShopSheetInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityShopSheetInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityShopSheetInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityShopSheetInfo parseFrom(InputStream input) throws IOException {
            return (ActivityShopSheetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ActivityShopSheetInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityShopSheetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ActivityShopSheetInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ActivityShopSheetInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ActivityShopSheetInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityShopSheetInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ActivityShopSheetInfo parseFrom(CodedInputStream input) throws IOException {
            return (ActivityShopSheetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ActivityShopSheetInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityShopSheetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ActivityShopSheetInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityShopSheetInfoOuterClass$ActivityShopSheetInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ActivityShopSheetInfoOrBuilder {
            private int beginTime_;
            private int sheetId_;
            private int endTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ActivityShopSheetInfoOuterClass.internal_static_ActivityShopSheetInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ActivityShopSheetInfoOuterClass.internal_static_ActivityShopSheetInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityShopSheetInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ActivityShopSheetInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.beginTime_ = 0;
                this.sheetId_ = 0;
                this.endTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ActivityShopSheetInfoOuterClass.internal_static_ActivityShopSheetInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ActivityShopSheetInfo getDefaultInstanceForType() {
                return ActivityShopSheetInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ActivityShopSheetInfo build() {
                ActivityShopSheetInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ActivityShopSheetInfo buildPartial() {
                ActivityShopSheetInfo result = new ActivityShopSheetInfo(this);
                result.beginTime_ = this.beginTime_;
                result.sheetId_ = this.sheetId_;
                result.endTime_ = this.endTime_;
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
                if (other instanceof ActivityShopSheetInfo) {
                    return mergeFrom((ActivityShopSheetInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ActivityShopSheetInfo other) {
                if (other == ActivityShopSheetInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getBeginTime() != 0) {
                    setBeginTime(other.getBeginTime());
                }
                if (other.getSheetId() != 0) {
                    setSheetId(other.getSheetId());
                }
                if (other.getEndTime() != 0) {
                    setEndTime(other.getEndTime());
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
                ActivityShopSheetInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ActivityShopSheetInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ActivityShopSheetInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ActivityShopSheetInfoOuterClass.ActivityShopSheetInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.ActivityShopSheetInfoOuterClass.ActivityShopSheetInfoOrBuilder
            public int getSheetId() {
                return this.sheetId_;
            }

            public Builder setSheetId(int value) {
                this.sheetId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSheetId() {
                this.sheetId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityShopSheetInfoOuterClass.ActivityShopSheetInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static ActivityShopSheetInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ActivityShopSheetInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ActivityShopSheetInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ActivityShopSheetInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
