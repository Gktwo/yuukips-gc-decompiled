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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrialAvatarGrantRecordOuterClass.class */
public final class TrialAvatarGrantRecordOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cTrialAvatarGrantRecord.proto\"æ\u0004\n\u0016TrialAvatarGrantRecord\u0012\u0014\n\fgrant_reason\u0018\u0001 \u0001(\r\u0012\u001c\n\u0014from_parent_quest_id\u0018\u0002 \u0001(\r\"\u0004\n\u000bGrantReason\u0012\u0018\n\u0014GRANT_REASON_INVALID\u0010��\u0012\u0019\n\u0015GRANT_REASON_BY_QUEST\u0010\u0001\u0012)\n%GRANT_REASON_BY_TRIAL_AVATAR_ACTIVITY\u0010\u0002\u0012-\n)GRANT_REASON_BY_DUNGEON_ELEMENT_CHALLENGE\u0010\u0003\u0012'\n#GRANT_REASON_BY_MIST_TRIAL_ACTIVITY\u0010\u0004\u0012!\n\u001dGRANT_REASON_BY_SUMO_ACTIVITY\u0010\u0005\u0012#\n\u001fGRANT_REASON_BY_POTION_ACTIVITY\u0010\u0006\u0012)\n%GRANT_REASON_BY_CRYSTAL_LINK_ACTIVITY\u0010\u0007\u0012\"\n\u001eGRANT_REASON_BY_IRODORI_MASTER\u0010\b\u0012\u0016\n\u0012GRANT_REASON_BY_GM\u0010\t\u0012+\n'GRANT_REASON_BY_INSTABLE_SPRAY_ACTIVITY\u0010\n\u0012+\n'GRANT_REASON_BY_MUQADAS_POTION_ACTIVITY\u0010\u000b\u0012#\n\u001fGRANT_REASON_BY_VINTAGE_HUNTING\u0010\f\u0012\"\n\u001eGRANT_REASON_BY_CHAR_AMUSEMENT\u0010\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TrialAvatarGrantRecord_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TrialAvatarGrantRecord_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TrialAvatarGrantRecord_descriptor, new String[]{"GrantReason", "FromParentQuestId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrialAvatarGrantRecordOuterClass$TrialAvatarGrantRecordOrBuilder.class */
    public interface TrialAvatarGrantRecordOrBuilder extends MessageOrBuilder {
        int getGrantReason();

        int getFromParentQuestId();
    }

    private TrialAvatarGrantRecordOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrialAvatarGrantRecordOuterClass$TrialAvatarGrantRecord.class */
    public static final class TrialAvatarGrantRecord extends GeneratedMessageV3 implements TrialAvatarGrantRecordOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GRANT_REASON_FIELD_NUMBER = 1;
        private int grantReason_;
        public static final int FROM_PARENT_QUEST_ID_FIELD_NUMBER = 2;
        private int fromParentQuestId_;
        private byte memoizedIsInitialized;
        private static final TrialAvatarGrantRecord DEFAULT_INSTANCE = new TrialAvatarGrantRecord();
        private static final Parser<TrialAvatarGrantRecord> PARSER = new AbstractParser<TrialAvatarGrantRecord>() { // from class: emu.grasscutter.net.proto.TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecord.1
            @Override // com.google.protobuf.Parser
            public TrialAvatarGrantRecord parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TrialAvatarGrantRecord(input, extensionRegistry);
            }
        };

        private TrialAvatarGrantRecord(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TrialAvatarGrantRecord() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TrialAvatarGrantRecord();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TrialAvatarGrantRecord(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.grantReason_ = input.readUInt32();
                                break;
                            case 16:
                                this.fromParentQuestId_ = input.readUInt32();
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
            return TrialAvatarGrantRecordOuterClass.internal_static_TrialAvatarGrantRecord_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TrialAvatarGrantRecordOuterClass.internal_static_TrialAvatarGrantRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(TrialAvatarGrantRecord.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrialAvatarGrantRecordOuterClass$TrialAvatarGrantRecord$GrantReason.class */
        public enum GrantReason implements ProtocolMessageEnum {
            GRANT_REASON_INVALID(0),
            GRANT_REASON_BY_QUEST(1),
            GRANT_REASON_BY_TRIAL_AVATAR_ACTIVITY(2),
            GRANT_REASON_BY_DUNGEON_ELEMENT_CHALLENGE(3),
            GRANT_REASON_BY_MIST_TRIAL_ACTIVITY(4),
            GRANT_REASON_BY_SUMO_ACTIVITY(5),
            GRANT_REASON_BY_POTION_ACTIVITY(6),
            GRANT_REASON_BY_CRYSTAL_LINK_ACTIVITY(7),
            GRANT_REASON_BY_IRODORI_MASTER(8),
            GRANT_REASON_BY_GM(9),
            GRANT_REASON_BY_INSTABLE_SPRAY_ACTIVITY(10),
            GRANT_REASON_BY_MUQADAS_POTION_ACTIVITY(11),
            GRANT_REASON_BY_VINTAGE_HUNTING(12),
            GRANT_REASON_BY_CHAR_AMUSEMENT(13),
            UNRECOGNIZED(-1);
            
            public static final int GRANT_REASON_INVALID_VALUE = 0;
            public static final int GRANT_REASON_BY_QUEST_VALUE = 1;
            public static final int GRANT_REASON_BY_TRIAL_AVATAR_ACTIVITY_VALUE = 2;
            public static final int GRANT_REASON_BY_DUNGEON_ELEMENT_CHALLENGE_VALUE = 3;
            public static final int GRANT_REASON_BY_MIST_TRIAL_ACTIVITY_VALUE = 4;
            public static final int GRANT_REASON_BY_SUMO_ACTIVITY_VALUE = 5;
            public static final int GRANT_REASON_BY_POTION_ACTIVITY_VALUE = 6;
            public static final int GRANT_REASON_BY_CRYSTAL_LINK_ACTIVITY_VALUE = 7;
            public static final int GRANT_REASON_BY_IRODORI_MASTER_VALUE = 8;
            public static final int GRANT_REASON_BY_GM_VALUE = 9;
            public static final int GRANT_REASON_BY_INSTABLE_SPRAY_ACTIVITY_VALUE = 10;
            public static final int GRANT_REASON_BY_MUQADAS_POTION_ACTIVITY_VALUE = 11;
            public static final int GRANT_REASON_BY_VINTAGE_HUNTING_VALUE = 12;
            public static final int GRANT_REASON_BY_CHAR_AMUSEMENT_VALUE = 13;
            private static final Internal.EnumLiteMap<GrantReason> internalValueMap = new Internal.EnumLiteMap<GrantReason>() { // from class: emu.grasscutter.net.proto.TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecord.GrantReason.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public GrantReason findValueByNumber(int number) {
                    return GrantReason.forNumber(number);
                }
            };
            private static final GrantReason[] VALUES = values();
            private final int value;

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static GrantReason valueOf(int value) {
                return forNumber(value);
            }

            public static GrantReason forNumber(int value) {
                switch (value) {
                    case 0:
                        return GRANT_REASON_INVALID;
                    case 1:
                        return GRANT_REASON_BY_QUEST;
                    case 2:
                        return GRANT_REASON_BY_TRIAL_AVATAR_ACTIVITY;
                    case 3:
                        return GRANT_REASON_BY_DUNGEON_ELEMENT_CHALLENGE;
                    case 4:
                        return GRANT_REASON_BY_MIST_TRIAL_ACTIVITY;
                    case 5:
                        return GRANT_REASON_BY_SUMO_ACTIVITY;
                    case 6:
                        return GRANT_REASON_BY_POTION_ACTIVITY;
                    case 7:
                        return GRANT_REASON_BY_CRYSTAL_LINK_ACTIVITY;
                    case 8:
                        return GRANT_REASON_BY_IRODORI_MASTER;
                    case 9:
                        return GRANT_REASON_BY_GM;
                    case 10:
                        return GRANT_REASON_BY_INSTABLE_SPRAY_ACTIVITY;
                    case 11:
                        return GRANT_REASON_BY_MUQADAS_POTION_ACTIVITY;
                    case 12:
                        return GRANT_REASON_BY_VINTAGE_HUNTING;
                    case 13:
                        return GRANT_REASON_BY_CHAR_AMUSEMENT;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<GrantReason> internalGetValueMap() {
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
                return TrialAvatarGrantRecord.getDescriptor().getEnumTypes().get(0);
            }

            public static GrantReason valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                } else if (desc.getIndex() == -1) {
                    return UNRECOGNIZED;
                } else {
                    return VALUES[desc.getIndex()];
                }
            }

            GrantReason(int value) {
                this.value = value;
            }
        }

        @Override // emu.grasscutter.net.proto.TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecordOrBuilder
        public int getGrantReason() {
            return this.grantReason_;
        }

        @Override // emu.grasscutter.net.proto.TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecordOrBuilder
        public int getFromParentQuestId() {
            return this.fromParentQuestId_;
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
            if (this.grantReason_ != 0) {
                output.writeUInt32(1, this.grantReason_);
            }
            if (this.fromParentQuestId_ != 0) {
                output.writeUInt32(2, this.fromParentQuestId_);
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
            if (this.grantReason_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.grantReason_);
            }
            if (this.fromParentQuestId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.fromParentQuestId_);
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
            if (!(obj instanceof TrialAvatarGrantRecord)) {
                return equals(obj);
            }
            TrialAvatarGrantRecord other = (TrialAvatarGrantRecord) obj;
            return getGrantReason() == other.getGrantReason() && getFromParentQuestId() == other.getFromParentQuestId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getGrantReason())) + 2)) + getFromParentQuestId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static TrialAvatarGrantRecord parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TrialAvatarGrantRecord parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TrialAvatarGrantRecord parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TrialAvatarGrantRecord parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TrialAvatarGrantRecord parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TrialAvatarGrantRecord parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TrialAvatarGrantRecord parseFrom(InputStream input) throws IOException {
            return (TrialAvatarGrantRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TrialAvatarGrantRecord parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrialAvatarGrantRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TrialAvatarGrantRecord parseDelimitedFrom(InputStream input) throws IOException {
            return (TrialAvatarGrantRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TrialAvatarGrantRecord parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrialAvatarGrantRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TrialAvatarGrantRecord parseFrom(CodedInputStream input) throws IOException {
            return (TrialAvatarGrantRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TrialAvatarGrantRecord parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrialAvatarGrantRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TrialAvatarGrantRecord prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrialAvatarGrantRecordOuterClass$TrialAvatarGrantRecord$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TrialAvatarGrantRecordOrBuilder {
            private int grantReason_;
            private int fromParentQuestId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TrialAvatarGrantRecordOuterClass.internal_static_TrialAvatarGrantRecord_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TrialAvatarGrantRecordOuterClass.internal_static_TrialAvatarGrantRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(TrialAvatarGrantRecord.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TrialAvatarGrantRecord.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.grantReason_ = 0;
                this.fromParentQuestId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TrialAvatarGrantRecordOuterClass.internal_static_TrialAvatarGrantRecord_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TrialAvatarGrantRecord getDefaultInstanceForType() {
                return TrialAvatarGrantRecord.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TrialAvatarGrantRecord build() {
                TrialAvatarGrantRecord result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TrialAvatarGrantRecord buildPartial() {
                TrialAvatarGrantRecord result = new TrialAvatarGrantRecord(this);
                result.grantReason_ = this.grantReason_;
                result.fromParentQuestId_ = this.fromParentQuestId_;
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
                if (other instanceof TrialAvatarGrantRecord) {
                    return mergeFrom((TrialAvatarGrantRecord) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TrialAvatarGrantRecord other) {
                if (other == TrialAvatarGrantRecord.getDefaultInstance()) {
                    return this;
                }
                if (other.getGrantReason() != 0) {
                    setGrantReason(other.getGrantReason());
                }
                if (other.getFromParentQuestId() != 0) {
                    setFromParentQuestId(other.getFromParentQuestId());
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
                TrialAvatarGrantRecord parsedMessage = null;
                try {
                    try {
                        parsedMessage = TrialAvatarGrantRecord.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TrialAvatarGrantRecord) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecordOrBuilder
            public int getGrantReason() {
                return this.grantReason_;
            }

            public Builder setGrantReason(int value) {
                this.grantReason_ = value;
                onChanged();
                return this;
            }

            public Builder clearGrantReason() {
                this.grantReason_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TrialAvatarGrantRecordOuterClass.TrialAvatarGrantRecordOrBuilder
            public int getFromParentQuestId() {
                return this.fromParentQuestId_;
            }

            public Builder setFromParentQuestId(int value) {
                this.fromParentQuestId_ = value;
                onChanged();
                return this;
            }

            public Builder clearFromParentQuestId() {
                this.fromParentQuestId_ = 0;
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

        public static TrialAvatarGrantRecord getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TrialAvatarGrantRecord> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TrialAvatarGrantRecord> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TrialAvatarGrantRecord getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
