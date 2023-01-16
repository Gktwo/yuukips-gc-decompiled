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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AchievementInfoOuterClass.class */
public final class AchievementInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015AchievementInfo.proto\"\u0002\n\u000fAchievementInfo\u0012\n\n\u0002id\u0018\u0001 \u0001(\r\u00126\n\u0006status\u0018\u0002 \u0001(\u000e2&.AchievementInfo.AchievementInfoStatus\u0012\u000f\n\u0007current\u0018\u0003 \u0001(\r\u0012\f\n\u0004goal\u0018\u0004 \u0001(\r\u0012\u0013\n\u000bachievedate\u0018\u0005 \u0001(\r\"\u0001\n\u0015AchievementInfoStatus\u0012\u0017\n\u0013ACHIEVEMENT_INVALID\u0010��\u0012\u001a\n\u0016ACHIEVEMENT_UNFINISHED\u0010\u0001\u0012\u0018\n\u0014ACHIEVEMENT_FINISHED\u0010\u0002\u0012\u001b\n\u0017ACHIEVEMENT_POINT_TAKEN\u0010\u0003B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AchievementInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AchievementInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AchievementInfo_descriptor, new String[]{"Id", "Status", "Current", "Goal", "Achievedate"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AchievementInfoOuterClass$AchievementInfoOrBuilder.class */
    public interface AchievementInfoOrBuilder extends MessageOrBuilder {
        int getId();

        int getStatusValue();

        AchievementInfo.AchievementInfoStatus getStatus();

        int getCurrent();

        int getGoal();

        int getAchievedate();
    }

    private AchievementInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AchievementInfoOuterClass$AchievementInfo.class */
    public static final class AchievementInfo extends GeneratedMessageV3 implements AchievementInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int STATUS_FIELD_NUMBER = 2;
        private int status_;
        public static final int CURRENT_FIELD_NUMBER = 3;
        private int current_;
        public static final int GOAL_FIELD_NUMBER = 4;
        private int goal_;
        public static final int ACHIEVEDATE_FIELD_NUMBER = 5;
        private int achievedate_;
        private byte memoizedIsInitialized;
        private static final AchievementInfo DEFAULT_INSTANCE = new AchievementInfo();
        private static final Parser<AchievementInfo> PARSER = new AbstractParser<AchievementInfo>() { // from class: emu.grasscutter.net.proto.AchievementInfoOuterClass.AchievementInfo.1
            @Override // com.google.protobuf.Parser
            public AchievementInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AchievementInfo(input, extensionRegistry);
            }
        };

        private AchievementInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AchievementInfo() {
            this.memoizedIsInitialized = -1;
            this.status_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AchievementInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AchievementInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.id_ = input.readUInt32();
                                break;
                            case 16:
                                this.status_ = input.readEnum();
                                break;
                            case 24:
                                this.current_ = input.readUInt32();
                                break;
                            case 32:
                                this.goal_ = input.readUInt32();
                                break;
                            case 40:
                                this.achievedate_ = input.readUInt32();
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
            return AchievementInfoOuterClass.internal_static_AchievementInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AchievementInfoOuterClass.internal_static_AchievementInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AchievementInfo.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AchievementInfoOuterClass$AchievementInfo$AchievementInfoStatus.class */
        public enum AchievementInfoStatus implements ProtocolMessageEnum {
            ACHIEVEMENT_INVALID(0),
            ACHIEVEMENT_UNFINISHED(1),
            ACHIEVEMENT_FINISHED(2),
            ACHIEVEMENT_POINT_TAKEN(3),
            UNRECOGNIZED(-1);
            
            public static final int ACHIEVEMENT_INVALID_VALUE = 0;
            public static final int ACHIEVEMENT_UNFINISHED_VALUE = 1;
            public static final int ACHIEVEMENT_FINISHED_VALUE = 2;
            public static final int ACHIEVEMENT_POINT_TAKEN_VALUE = 3;
            private static final Internal.EnumLiteMap<AchievementInfoStatus> internalValueMap = new Internal.EnumLiteMap<AchievementInfoStatus>() { // from class: emu.grasscutter.net.proto.AchievementInfoOuterClass.AchievementInfo.AchievementInfoStatus.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public AchievementInfoStatus findValueByNumber(int number) {
                    return AchievementInfoStatus.forNumber(number);
                }
            };
            private static final AchievementInfoStatus[] VALUES = values();
            private final int value;

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static AchievementInfoStatus valueOf(int value) {
                return forNumber(value);
            }

            public static AchievementInfoStatus forNumber(int value) {
                switch (value) {
                    case 0:
                        return ACHIEVEMENT_INVALID;
                    case 1:
                        return ACHIEVEMENT_UNFINISHED;
                    case 2:
                        return ACHIEVEMENT_FINISHED;
                    case 3:
                        return ACHIEVEMENT_POINT_TAKEN;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<AchievementInfoStatus> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                if (this != UNRECOGNIZED) {
                    return getDescriptor().getValues().get(ordinal());
                }
                throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return AchievementInfo.getDescriptor().getEnumTypes().get(0);
            }

            public static AchievementInfoStatus valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                } else if (desc.getIndex() == -1) {
                    return UNRECOGNIZED;
                } else {
                    return VALUES[desc.getIndex()];
                }
            }

            AchievementInfoStatus(int value) {
                this.value = value;
            }
        }

        @Override // emu.grasscutter.net.proto.AchievementInfoOuterClass.AchievementInfoOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // emu.grasscutter.net.proto.AchievementInfoOuterClass.AchievementInfoOrBuilder
        public int getStatusValue() {
            return this.status_;
        }

        @Override // emu.grasscutter.net.proto.AchievementInfoOuterClass.AchievementInfoOrBuilder
        public AchievementInfoStatus getStatus() {
            AchievementInfoStatus result = AchievementInfoStatus.valueOf(this.status_);
            return result == null ? AchievementInfoStatus.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.AchievementInfoOuterClass.AchievementInfoOrBuilder
        public int getCurrent() {
            return this.current_;
        }

        @Override // emu.grasscutter.net.proto.AchievementInfoOuterClass.AchievementInfoOrBuilder
        public int getGoal() {
            return this.goal_;
        }

        @Override // emu.grasscutter.net.proto.AchievementInfoOuterClass.AchievementInfoOrBuilder
        public int getAchievedate() {
            return this.achievedate_;
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
            if (this.id_ != 0) {
                output.writeUInt32(1, this.id_);
            }
            if (this.status_ != AchievementInfoStatus.ACHIEVEMENT_INVALID.getNumber()) {
                output.writeEnum(2, this.status_);
            }
            if (this.current_ != 0) {
                output.writeUInt32(3, this.current_);
            }
            if (this.goal_ != 0) {
                output.writeUInt32(4, this.goal_);
            }
            if (this.achievedate_ != 0) {
                output.writeUInt32(5, this.achievedate_);
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
            if (this.id_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.id_);
            }
            if (this.status_ != AchievementInfoStatus.ACHIEVEMENT_INVALID.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(2, this.status_);
            }
            if (this.current_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.current_);
            }
            if (this.goal_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.goal_);
            }
            if (this.achievedate_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.achievedate_);
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
            if (!(obj instanceof AchievementInfo)) {
                return equals(obj);
            }
            AchievementInfo other = (AchievementInfo) obj;
            return getId() == other.getId() && this.status_ == other.status_ && getCurrent() == other.getCurrent() && getGoal() == other.getGoal() && getAchievedate() == other.getAchievedate() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getId())) + 2)) + this.status_)) + 3)) + getCurrent())) + 4)) + getGoal())) + 5)) + getAchievedate())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AchievementInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AchievementInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AchievementInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AchievementInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AchievementInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AchievementInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AchievementInfo parseFrom(InputStream input) throws IOException {
            return (AchievementInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AchievementInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AchievementInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AchievementInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (AchievementInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AchievementInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AchievementInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AchievementInfo parseFrom(CodedInputStream input) throws IOException {
            return (AchievementInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AchievementInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AchievementInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AchievementInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AchievementInfoOuterClass$AchievementInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AchievementInfoOrBuilder {
            private int id_;
            private int status_ = 0;
            private int current_;
            private int goal_;
            private int achievedate_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AchievementInfoOuterClass.internal_static_AchievementInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AchievementInfoOuterClass.internal_static_AchievementInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AchievementInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AchievementInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.id_ = 0;
                this.status_ = 0;
                this.current_ = 0;
                this.goal_ = 0;
                this.achievedate_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AchievementInfoOuterClass.internal_static_AchievementInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AchievementInfo getDefaultInstanceForType() {
                return AchievementInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AchievementInfo build() {
                AchievementInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AchievementInfo buildPartial() {
                AchievementInfo result = new AchievementInfo(this);
                result.id_ = this.id_;
                result.status_ = this.status_;
                result.current_ = this.current_;
                result.goal_ = this.goal_;
                result.achievedate_ = this.achievedate_;
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
                if (other instanceof AchievementInfo) {
                    return mergeFrom((AchievementInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AchievementInfo other) {
                if (other == AchievementInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getId() != 0) {
                    setId(other.getId());
                }
                if (other.status_ != 0) {
                    setStatusValue(other.getStatusValue());
                }
                if (other.getCurrent() != 0) {
                    setCurrent(other.getCurrent());
                }
                if (other.getGoal() != 0) {
                    setGoal(other.getGoal());
                }
                if (other.getAchievedate() != 0) {
                    setAchievedate(other.getAchievedate());
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
                AchievementInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = AchievementInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AchievementInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AchievementInfoOuterClass.AchievementInfoOrBuilder
            public int getId() {
                return this.id_;
            }

            public Builder setId(int value) {
                this.id_ = value;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AchievementInfoOuterClass.AchievementInfoOrBuilder
            public int getStatusValue() {
                return this.status_;
            }

            public Builder setStatusValue(int value) {
                this.status_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AchievementInfoOuterClass.AchievementInfoOrBuilder
            public AchievementInfoStatus getStatus() {
                AchievementInfoStatus result = AchievementInfoStatus.valueOf(this.status_);
                return result == null ? AchievementInfoStatus.UNRECOGNIZED : result;
            }

            public Builder setStatus(AchievementInfoStatus value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.status_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearStatus() {
                this.status_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AchievementInfoOuterClass.AchievementInfoOrBuilder
            public int getCurrent() {
                return this.current_;
            }

            public Builder setCurrent(int value) {
                this.current_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurrent() {
                this.current_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AchievementInfoOuterClass.AchievementInfoOrBuilder
            public int getGoal() {
                return this.goal_;
            }

            public Builder setGoal(int value) {
                this.goal_ = value;
                onChanged();
                return this;
            }

            public Builder clearGoal() {
                this.goal_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AchievementInfoOuterClass.AchievementInfoOrBuilder
            public int getAchievedate() {
                return this.achievedate_;
            }

            public Builder setAchievedate(int value) {
                this.achievedate_ = value;
                onChanged();
                return this;
            }

            public Builder clearAchievedate() {
                this.achievedate_ = 0;
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

        public static AchievementInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AchievementInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AchievementInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AchievementInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
